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
    private int gLr = 1;
    private int gLs = -1;
    private AlaLivePlayer gLt;
    private f gLu;
    private Uri mUri;

    public b(Context context) {
        if (this.gLt == null) {
            this.gLt = AlaLivePlayer.createLivePlayer(context);
        }
    }

    @Override // com.baidu.live.liveroom.e.d
    public void d(Context context, Uri uri) {
        if (this.gLt == null) {
            this.gLt = AlaLivePlayer.createLivePlayer(context);
        }
        this.mUri = uri;
    }

    @Override // com.baidu.live.liveroom.e.d
    public void setPlayerCallback(f fVar) {
        this.gLu = fVar;
        if (this.gLt != null) {
            this.gLt.setPlayerCallback(new AlaLivePlayerCallback() { // from class: com.baidu.tieba.ala.liveroom.t.b.1
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
                    if (b.this.gLu != null) {
                        b.this.gLu.a(b.this, CyberPlayerManager.MEDIA_INFO_FIRST_DISP_INTERVAL, 0);
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
        if (this.gLs == -1) {
            this.gLs = i;
        }
        if (this.gLt != null) {
            this.gLt.setStartInfo(i, jSONObject.optString("liveId"), jSONObject.optString("sessionId"), jSONObject.optString("clientIp"), jSONObject.optString("level"), jSONObject.optInt("sessionLine"), TbConfig.getSubappType());
        }
    }

    @Override // com.baidu.live.liveroom.e.d
    public View getPlayerView() {
        return this.gLt;
    }

    @Override // com.baidu.live.liveroom.e.d
    public void eE(int i) {
    }

    @Override // com.baidu.live.liveroom.e.d
    public void c(Uri uri) {
        this.mUri = uri;
    }

    @Override // com.baidu.live.liveroom.e.d
    public void setVideoScalingMode(int i) {
        if (i == 0) {
            this.gLt.setRenderVideoModel(this.gLs, 1);
        } else {
            this.gLt.setRenderVideoModel(this.gLs, 2);
        }
    }

    @Override // com.baidu.live.liveroom.e.d
    public void start() {
        this.gLt.setStatConfigBeforeStart(TbadkCoreApplication.getInst().getApp().getFilesDir().getAbsolutePath() + "/live_sdk_log/", "http://c.tieba.baidu.com/ala/sys/mlog", com.baidu.live.x.a.NN().bhy.aHi);
        if (this.gLs == -1) {
            this.gLs = 1;
        }
        AlaLivePlayer.AlaLivePlayerConf alaLivePlayerConf = new AlaLivePlayer.AlaLivePlayerConf();
        alaLivePlayerConf.index = this.gLs;
        alaLivePlayerConf.url = this.mUri.toString();
        alaLivePlayerConf.param = new LinearLayout.LayoutParams(-1, -1);
        ArrayList arrayList = new ArrayList();
        arrayList.add(alaLivePlayerConf);
        this.gLt.start2(arrayList);
        this.gLr = 2;
    }

    @Override // com.baidu.live.liveroom.e.d
    public void pause() {
    }

    @Override // com.baidu.live.liveroom.e.d
    public void resume() {
        if (this.gLt != null) {
            this.gLt.resume();
        }
    }

    @Override // com.baidu.live.liveroom.e.d
    public void stop() {
        if (this.gLt != null) {
            this.gLt.stop();
            this.gLr = 4;
        }
    }

    @Override // com.baidu.live.liveroom.e.d
    public boolean isPlaying() {
        return false;
    }

    @Override // com.baidu.live.liveroom.e.d
    public void release() {
        if (this.gLt != null) {
            this.gLt.stop();
            this.gLt.destroy();
            this.gLr = 4;
        }
    }

    @Override // com.baidu.live.liveroom.e.d
    public void b(int i, Map<String, String> map) {
    }
}
