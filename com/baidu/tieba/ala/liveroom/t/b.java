package com.baidu.tieba.ala.liveroom.t;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.ala.helper.AlaLiveDebugInfo;
import com.baidu.ala.player.AlaLivePlayer;
import com.baidu.ala.player.AlaLivePlayerCallback;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.live.liveroom.e.d;
import com.baidu.live.liveroom.e.f;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b implements d {
    private int hao = 1;
    private int hap = -1;
    private AlaLivePlayer haq;
    private f har;
    private Uri mUri;

    public b(Context context) {
        if (this.haq == null) {
            this.haq = AlaLivePlayer.createLivePlayer(context);
        }
    }

    @Override // com.baidu.live.liveroom.e.d
    public void d(Context context, Uri uri) {
        if (this.haq == null) {
            this.haq = AlaLivePlayer.createLivePlayer(context);
        }
        this.mUri = uri;
    }

    @Override // com.baidu.live.liveroom.e.d
    public void setPlayerCallback(f fVar) {
        this.har = fVar;
        if (this.haq != null) {
            this.haq.setPlayerCallback(new AlaLivePlayerCallback() { // from class: com.baidu.tieba.ala.liveroom.t.b.1
                @Override // com.baidu.ala.player.AlaLivePlayerCallback
                public void onStreamChanged(int i, int i2) {
                }

                @Override // com.baidu.ala.player.AlaLivePlayerCallback
                public void onDebugInfo(int i, AlaLiveDebugInfo alaLiveDebugInfo) {
                }

                @Override // com.baidu.ala.player.AlaLivePlayerCallback
                public void onBufferingEvent(int i, int i2, long j, int i3) {
                }

                @Override // com.baidu.ala.player.AlaLivePlayerCallback
                public void onFrameDelay(int i, int i2, int i3) {
                }

                @Override // com.baidu.ala.player.AlaLivePlayerCallback
                public void onFirstFrame(int i, int i2, int i3) {
                    if (b.this.har != null) {
                        b.this.har.a(b.this, CyberPlayerManager.MEDIA_INFO_FIRST_DISP_INTERVAL, 0);
                    }
                }

                @Override // com.baidu.ala.player.AlaLivePlayerCallback
                public void onStreamStuck(int i, int i2, int i3) {
                }

                @Override // com.baidu.ala.player.AlaLivePlayerCallback
                public void onFastOpen(int i, int i2) {
                }
            });
        }
    }

    @Override // com.baidu.live.liveroom.e.d
    public void setDecodeMode(int i) {
    }

    @Override // com.baidu.live.liveroom.e.d
    public void b(int i, JSONObject jSONObject) {
        if (this.hap == -1) {
            this.hap = i;
        }
        if (this.haq != null) {
            this.haq.setStartInfo(i, jSONObject.optString("liveId"), jSONObject.optString("sessionId"), jSONObject.optString("clientIp"), jSONObject.optString("level"), jSONObject.optInt("sessionLine"), TbConfig.getSubappType());
        }
    }

    @Override // com.baidu.live.liveroom.e.d
    public View getPlayerView() {
        return this.haq;
    }

    @Override // com.baidu.live.liveroom.e.d
    public void eN(int i) {
    }

    @Override // com.baidu.live.liveroom.e.d
    public void c(Uri uri) {
        this.mUri = uri;
    }

    @Override // com.baidu.live.liveroom.e.d
    public void setVideoScalingMode(int i) {
        if (i == 0) {
            this.haq.setRenderVideoModel(this.hap, 1);
        } else {
            this.haq.setRenderVideoModel(this.hap, 2);
        }
    }

    @Override // com.baidu.live.liveroom.e.d
    public void start() {
        this.haq.setStatConfigBeforeStart(TbadkCoreApplication.getInst().getApp().getFilesDir().getAbsolutePath() + "/live_sdk_log/", "http://c.tieba.baidu.com/ala/sys/mlog", com.baidu.live.x.a.OS().blo.aKm);
        if (this.hap == -1) {
            this.hap = 1;
        }
        AlaLivePlayer.AlaLivePlayerConf alaLivePlayerConf = new AlaLivePlayer.AlaLivePlayerConf();
        alaLivePlayerConf.index = this.hap;
        alaLivePlayerConf.url = this.mUri.toString();
        alaLivePlayerConf.param = new LinearLayout.LayoutParams(-1, -1);
        ArrayList arrayList = new ArrayList();
        arrayList.add(alaLivePlayerConf);
        this.haq.start2(arrayList);
        this.hao = 2;
    }

    @Override // com.baidu.live.liveroom.e.d
    public void pause() {
    }

    @Override // com.baidu.live.liveroom.e.d
    public void resume() {
        if (this.haq != null) {
            this.haq.resume();
        }
    }

    @Override // com.baidu.live.liveroom.e.d
    public void stop() {
        if (this.haq != null) {
            this.haq.stop();
            this.hao = 4;
        }
    }

    @Override // com.baidu.live.liveroom.e.d
    public boolean isPlaying() {
        return false;
    }

    @Override // com.baidu.live.liveroom.e.d
    public void release() {
        if (this.haq != null) {
            this.haq.stop();
            this.haq.destroy();
            this.hao = 4;
        }
    }

    @Override // com.baidu.live.liveroom.e.d
    public void b(int i, Map<String, String> map) {
    }
}
