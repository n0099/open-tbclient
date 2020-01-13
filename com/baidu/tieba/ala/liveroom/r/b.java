package com.baidu.tieba.ala.liveroom.r;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.ala.helper.AlaLiveDebugInfo;
import com.baidu.ala.player.AlaLivePlayer;
import com.baidu.ala.player.AlaLivePlayerCallback;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.live.liveroom.d.c;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b implements com.baidu.live.liveroom.d.a {
    private int fge = 1;
    private int fgf = -1;
    private AlaLivePlayer fgg;
    private c fgh;
    private Uri mUri;

    public b(Context context) {
        if (this.fgg == null) {
            this.fgg = AlaLivePlayer.createLivePlayer(context);
        }
    }

    @Override // com.baidu.live.liveroom.d.a
    public void d(Context context, Uri uri) {
        if (this.fgg == null) {
            this.fgg = AlaLivePlayer.createLivePlayer(context);
        }
        this.mUri = uri;
    }

    @Override // com.baidu.live.liveroom.d.a
    public void a(c cVar) {
        this.fgh = cVar;
        this.fgg.setPlayerCallback(new AlaLivePlayerCallback() { // from class: com.baidu.tieba.ala.liveroom.r.b.1
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
                if (b.this.fgh != null) {
                    b.this.fgh.a(b.this, CyberPlayerManager.MEDIA_INFO_FIRST_DISP_INTERVAL, 0);
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

    @Override // com.baidu.live.liveroom.d.a
    public void setDecodeMode(int i) {
    }

    @Override // com.baidu.live.liveroom.d.a
    public void b(int i, JSONObject jSONObject) {
        if (this.fgf == -1) {
            this.fgf = i;
        }
        if (this.fgg != null) {
            this.fgg.setStartInfo(i, jSONObject.optString("LIVE_ID"), jSONObject.optString("SESSION_ID"), jSONObject.optString("CLIENT_IP"), jSONObject.optString("LEVEL"), jSONObject.optInt("SESSION_LINE"), TbConfig.getSubappType());
        }
    }

    @Override // com.baidu.live.liveroom.d.a
    public View getPlayerView() {
        return this.fgg;
    }

    @Override // com.baidu.live.liveroom.d.a
    public void bQ(int i) {
    }

    @Override // com.baidu.live.liveroom.d.a
    public void b(Uri uri) {
        this.mUri = uri;
    }

    @Override // com.baidu.live.liveroom.d.a
    public void setVideoScalingMode(int i) {
        this.fgg.setRenderVideoModel(this.fgf, 1);
    }

    @Override // com.baidu.live.liveroom.d.a
    public void start() {
        this.fgg.setStatConfigBeforeStart(TbadkCoreApplication.getInst().getApp().getFilesDir().getAbsolutePath() + "/live_sdk_log/", "http://c.tieba.baidu.com/ala/sys/mlog", com.baidu.live.s.a.wR().asq.XO);
        if (this.fgf == -1) {
            this.fgf = 1;
        }
        AlaLivePlayer.AlaLivePlayerConf alaLivePlayerConf = new AlaLivePlayer.AlaLivePlayerConf();
        alaLivePlayerConf.index = this.fgf;
        alaLivePlayerConf.url = this.mUri.toString();
        alaLivePlayerConf.param = new LinearLayout.LayoutParams(-1, -1);
        ArrayList arrayList = new ArrayList();
        arrayList.add(alaLivePlayerConf);
        this.fgg.start2(arrayList);
        this.fge = 2;
    }

    @Override // com.baidu.live.liveroom.d.a
    public void stop() {
        if (this.fgg != null) {
            this.fgg.stop();
            this.fge = 4;
        }
    }

    @Override // com.baidu.live.liveroom.d.a
    public void release() {
        if (this.fgg != null) {
            this.fgg.stop();
            this.fgg.destroy();
            this.fge = 4;
        }
    }
}
