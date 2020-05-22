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
import com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b implements com.baidu.live.liveroom.e.a {
    private int gcI = 1;
    private int gcJ = -1;
    private AlaLivePlayer gcK;
    private c gcL;
    private Uri mUri;

    public b(Context context) {
        if (this.gcK == null) {
            this.gcK = AlaLivePlayer.createLivePlayer(context);
        }
    }

    @Override // com.baidu.live.liveroom.e.a
    public void d(Context context, Uri uri) {
        if (this.gcK == null) {
            this.gcK = AlaLivePlayer.createLivePlayer(context);
        }
        this.mUri = uri;
    }

    @Override // com.baidu.live.liveroom.e.a
    public void a(c cVar) {
        this.gcL = cVar;
        if (this.gcK != null) {
            this.gcK.setPlayerCallback(new AlaLivePlayerCallback() { // from class: com.baidu.tieba.ala.liveroom.p.b.1
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
                    if (b.this.gcL != null) {
                        b.this.gcL.a(b.this, CyberPlayerManager.MEDIA_INFO_FIRST_DISP_INTERVAL, 0);
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

    @Override // com.baidu.live.liveroom.e.a
    public void setDecodeMode(int i) {
    }

    @Override // com.baidu.live.liveroom.e.a
    public void b(int i, JSONObject jSONObject) {
        if (this.gcJ == -1) {
            this.gcJ = i;
        }
        if (this.gcK != null) {
            this.gcK.setStartInfo(i, jSONObject.optString("liveId"), jSONObject.optString("sessionId"), jSONObject.optString("clientIp"), jSONObject.optString(ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL), jSONObject.optInt("sessionLine"), TbConfig.getSubappType());
        }
    }

    @Override // com.baidu.live.liveroom.e.a
    public View getPlayerView() {
        return this.gcK;
    }

    @Override // com.baidu.live.liveroom.e.a
    public void cB(int i) {
    }

    @Override // com.baidu.live.liveroom.e.a
    public void c(Uri uri) {
        this.mUri = uri;
    }

    @Override // com.baidu.live.liveroom.e.a
    public void setVideoScalingMode(int i) {
        if (i == 0) {
            this.gcK.setRenderVideoModel(this.gcJ, 1);
        } else {
            this.gcK.setRenderVideoModel(this.gcJ, 2);
        }
    }

    @Override // com.baidu.live.liveroom.e.a
    public void start() {
        this.gcK.setStatConfigBeforeStart(TbadkCoreApplication.getInst().getApp().getFilesDir().getAbsolutePath() + "/live_sdk_log/", "http://c.tieba.baidu.com/ala/sys/mlog", com.baidu.live.v.a.Ge().aWF.axl);
        if (this.gcJ == -1) {
            this.gcJ = 1;
        }
        AlaLivePlayer.AlaLivePlayerConf alaLivePlayerConf = new AlaLivePlayer.AlaLivePlayerConf();
        alaLivePlayerConf.index = this.gcJ;
        alaLivePlayerConf.url = this.mUri.toString();
        alaLivePlayerConf.param = new LinearLayout.LayoutParams(-1, -1);
        ArrayList arrayList = new ArrayList();
        arrayList.add(alaLivePlayerConf);
        this.gcK.start2(arrayList);
        this.gcI = 2;
    }

    @Override // com.baidu.live.liveroom.e.a
    public void stop() {
        if (this.gcK != null) {
            this.gcK.stop();
            this.gcI = 4;
        }
    }

    @Override // com.baidu.live.liveroom.e.a
    public void release() {
        if (this.gcK != null) {
            this.gcK.stop();
            this.gcK.destroy();
            this.gcI = 4;
        }
    }

    @Override // com.baidu.live.liveroom.e.a
    public void b(int i, Map<String, String> map) {
    }
}
