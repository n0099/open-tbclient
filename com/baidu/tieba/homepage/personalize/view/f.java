package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.afd.videopaster.d;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tieba.play.operableVideoView.d;
import java.util.HashMap;
import tbclient.VideoInfo;
/* loaded from: classes16.dex */
public class f extends com.baidu.tieba.play.operableVideoView.b {
    private bw afL;
    private CustomMessageListener hjC;
    private com.baidu.afd.videopaster.d hjn;
    private boolean iRf;
    protected boolean iRg;
    private Runnable iRh;

    public f(Context context, View view) {
        super(context, view);
        this.iRf = false;
        this.hjC = new CustomMessageListener(2921395) { // from class: com.baidu.tieba.homepage.personalize.view.f.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.afd.videopaster.data.b bVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.afd.videopaster.data.b) && (bVar = (com.baidu.afd.videopaster.data.b) customResponsedMessage.getData()) != null) {
                    String videoId = bVar.getVideoId();
                    if (!StringUtils.isNull(videoId) && f.this.afL != null && videoId.equals(f.this.afL.getId())) {
                        f.this.hjn.a(f.this.a(f.this.afL, bVar));
                    }
                }
            }
        };
        this.iRh = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.view.f.4
            @Override // java.lang.Runnable
            public void run() {
                if (f.this.hjn != null) {
                    f.this.iRg = false;
                    f.this.hjn.stop();
                    f.this.hjn.onDestroy();
                }
            }
        };
        vg(true);
        cyI();
    }

    protected void cyI() {
        this.hjn = new com.baidu.afd.videopaster.d(this.mContext, (ViewGroup) djP());
        this.hjn.a(new d.a() { // from class: com.baidu.tieba.homepage.personalize.view.f.1
            @Override // com.baidu.afd.videopaster.d.a
            public void rM() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void rL() {
                f.this.startPlay();
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void rK() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public boolean rN() {
                return false;
            }
        });
        a(new d.a() { // from class: com.baidu.tieba.homepage.personalize.view.f.2
            @Override // com.baidu.tieba.play.operableVideoView.d.a
            public void cA(int i, int i2) {
                if (!f.this.dkN()) {
                    if (i2 >= i) {
                        if (f.this.hjn.a(false, false, "NEWINDEX")) {
                        }
                    } else if (i != 0 && !f.this.akZ && (i2 * 100) / i >= 80 && i > 15000) {
                        f.this.aB(f.this.afL);
                    }
                }
            }
        });
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        this.hjC.setTag(this.ahM);
        MessageManager.getInstance().registerListener(this.hjC);
    }

    @Override // com.baidu.tieba.play.operableVideoView.b, com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(bw bwVar) {
        if (bwVar != null) {
            super.setData(bwVar);
            boolean z = this.afL == bwVar;
            this.afL = bwVar;
            if (this.hjn != null) {
                if (this.iRf && z) {
                    this.iRf = false;
                } else {
                    this.hjn.reset();
                }
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.b, com.baidu.tieba.play.operableVideoView.d, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        if (!this.hjn.a(false, false, "NEWINDEX")) {
            startPlay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aB(bw bwVar) {
        if (bwVar != null && bwVar.getId() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921394, bwVar.getId()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.afd.videopaster.a a(bw bwVar, com.baidu.afd.videopaster.data.b bVar) {
        int i;
        int i2;
        int i3;
        int i4 = -1;
        if (bwVar == null || bVar == null) {
            return null;
        }
        int rR = bVar.rR();
        int rS = bVar.rS();
        int rQ = bVar.rQ();
        if (rQ != -1) {
            i = rR != -1 ? (rQ - rR) - 1 : -1;
            if (rS != -1) {
                i4 = (rS - rQ) - 1;
            }
        } else {
            i = -1;
        }
        VideoInfo beW = bwVar.beW();
        if (beW != null) {
            i3 = beW.video_width.intValue();
            i2 = beW.video_height.intValue();
        } else {
            i2 = 0;
            i3 = 0;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("video_vid", bwVar.getId());
        hashMap.put("video_title", bwVar.getTitle());
        hashMap.put("forum_id", String.valueOf(bwVar.getFid()));
        hashMap.put("forum_name", bwVar.beI());
        hashMap.put("up_distance", String.valueOf(i));
        hashMap.put("down_distance", String.valueOf(i4));
        com.baidu.afd.videopaster.a a = com.baidu.afd.videopaster.c.a(3, 0, "1546854828072", rQ + 1, i3, i2);
        a.u(hashMap);
        return a;
    }

    public void onPause() {
    }

    public void onResume() {
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean pP(boolean z) {
        if (this.hjn != null) {
            if (z) {
                if (this.hjn.rv()) {
                    this.iRg = false;
                    this.hjn.stop();
                }
            } else if (this.hjn.rv()) {
                this.iRf = true;
                this.hjn.aB(true);
            }
        }
        return super.pP(z);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void startPlay() {
        if (this.hjn != null && this.hjn.rv()) {
            this.iRg = true;
            this.hjn.resume();
            return;
        }
        super.startPlay();
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void stopPlay() {
        super.stopPlay();
        if (this.hjn != null && this.hjn.rv()) {
            com.baidu.adp.lib.f.e.mS().removeCallbacks(this.iRh);
            com.baidu.adp.lib.f.e.mS().post(this.iRh);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected int cyJ() {
        return 1;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean isPlaying() {
        if (this.hjn == null || !this.hjn.rv()) {
            return super.isPlaying();
        }
        return this.iRg || this.hjn.rF();
    }
}
