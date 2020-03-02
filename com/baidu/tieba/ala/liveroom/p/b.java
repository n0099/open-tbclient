package com.baidu.tieba.ala.liveroom.p;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.ala.helper.AlaLiveDebugInfo;
import com.baidu.ala.player.AlaLivePlayer;
import com.baidu.ala.player.AlaLivePlayerCallback;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.live.liveroom.e.c;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b implements com.baidu.live.liveroom.e.a {
    private int fju = 1;
    private int fjv = -1;
    private AlaLivePlayer fjw;
    private c fjx;
    private Uri mUri;

    public b(Context context) {
        if (this.fjw == null) {
            this.fjw = AlaLivePlayer.createLivePlayer(context);
        }
    }

    @Override // com.baidu.live.liveroom.e.a
    public void d(Context context, Uri uri) {
        if (this.fjw == null) {
            this.fjw = AlaLivePlayer.createLivePlayer(context);
        }
        this.mUri = uri;
    }

    @Override // com.baidu.live.liveroom.e.a
    public void a(c cVar) {
        this.fjx = cVar;
        this.fjw.setPlayerCallback(new AlaLivePlayerCallback() { // from class: com.baidu.tieba.ala.liveroom.p.b.1
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
                if (b.this.fjx != null) {
                    b.this.fjx.a(b.this, CyberPlayerManager.MEDIA_INFO_FIRST_DISP_INTERVAL, 0);
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

    @Override // com.baidu.live.liveroom.e.a
    public void setDecodeMode(int i) {
    }

    @Override // com.baidu.live.liveroom.e.a
    public void b(int i, JSONObject jSONObject) {
        if (this.fjv == -1) {
            this.fjv = i;
        }
        if (this.fjw != null) {
            this.fjw.setStartInfo(i, jSONObject.optString("LIVE_ID"), jSONObject.optString("SESSION_ID"), jSONObject.optString("CLIENT_IP"), jSONObject.optString("LEVEL"), jSONObject.optInt("SESSION_LINE"), TbConfig.getSubappType());
        }
    }

    @Override // com.baidu.live.liveroom.e.a
    public View getPlayerView() {
        return this.fjw;
    }

    @Override // com.baidu.live.liveroom.e.a
    public void cf(int i) {
    }

    @Override // com.baidu.live.liveroom.e.a
    public void c(Uri uri) {
        this.mUri = uri;
    }

    @Override // com.baidu.live.liveroom.e.a
    public void setVideoScalingMode(int i) {
        this.fjw.setRenderVideoModel(this.fjv, 1);
    }

    @Override // com.baidu.live.liveroom.e.a
    public void start() {
        this.fjw.setStatConfigBeforeStart(TbadkCoreApplication.getInst().getApp().getFilesDir().getAbsolutePath() + "/live_sdk_log/", "http://c.tieba.baidu.com/ala/sys/mlog", com.baidu.live.v.a.zl().awB.ZF);
        if (this.fjv == -1) {
            this.fjv = 1;
        }
        AlaLivePlayer.AlaLivePlayerConf alaLivePlayerConf = new AlaLivePlayer.AlaLivePlayerConf();
        alaLivePlayerConf.index = this.fjv;
        alaLivePlayerConf.url = this.mUri.toString();
        alaLivePlayerConf.param = new LinearLayout.LayoutParams(-1, -1);
        ArrayList arrayList = new ArrayList();
        arrayList.add(alaLivePlayerConf);
        this.fjw.start2(arrayList);
        this.fju = 2;
    }

    @Override // com.baidu.live.liveroom.e.a
    public void stop() {
        if (this.fjw != null) {
            this.fjw.stop();
            this.fju = 4;
        }
    }

    @Override // com.baidu.live.liveroom.e.a
    public void release() {
        if (this.fjw != null) {
            this.fjw.stop();
            this.fjw.destroy();
            this.fju = 4;
        }
    }
}
