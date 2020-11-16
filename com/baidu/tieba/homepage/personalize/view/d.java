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
import com.baidu.tbadk.core.data.bx;
import com.baidu.tieba.play.operableVideoView.d;
import java.util.HashMap;
import tbclient.VideoInfo;
/* loaded from: classes21.dex */
public class d extends com.baidu.tieba.play.operableVideoView.b {
    private bx agB;
    private com.baidu.afd.videopaster.d hYe;
    private CustomMessageListener hYt;
    private boolean jHT;
    protected boolean jHU;
    private Runnable jHV;

    public d(Context context, View view) {
        super(context, view);
        this.jHT = false;
        this.hYt = new CustomMessageListener(2921395) { // from class: com.baidu.tieba.homepage.personalize.view.d.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.afd.videopaster.data.b bVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.afd.videopaster.data.b) && (bVar = (com.baidu.afd.videopaster.data.b) customResponsedMessage.getData()) != null) {
                    String videoId = bVar.getVideoId();
                    if (!StringUtils.isNull(videoId) && d.this.agB != null && videoId.equals(d.this.agB.getId())) {
                        d.this.hYe.a(d.this.a(d.this.agB, bVar));
                    }
                }
            }
        };
        this.jHV = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.view.d.4
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.hYe != null) {
                    d.this.jHU = false;
                    d.this.hYe.stop();
                    d.this.hYe.onDestroy();
                }
            }
        };
        wy(true);
        cLm();
    }

    protected void cLm() {
        this.hYe = new com.baidu.afd.videopaster.d(this.mContext, (ViewGroup) dwp());
        this.hYe.a(new d.a() { // from class: com.baidu.tieba.homepage.personalize.view.d.1
            @Override // com.baidu.afd.videopaster.d.a
            public void rR() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void rQ() {
                d.this.startPlay();
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void rP() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public boolean rS() {
                return false;
            }
        });
        a(new d.a() { // from class: com.baidu.tieba.homepage.personalize.view.d.2
            @Override // com.baidu.tieba.play.operableVideoView.d.a
            public void cH(int i, int i2) {
                if (!d.this.dxo()) {
                    if (i2 >= i) {
                        if (d.this.hYe.a(false, false, "NEWINDEX")) {
                        }
                    } else if (i != 0 && !d.this.alY && (i2 * 100) / i >= 80 && i > 15000) {
                        d.this.aE(d.this.agB);
                    }
                }
            }
        });
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        this.hYt.setTag(this.aiE);
        MessageManager.getInstance().registerListener(this.hYt);
    }

    @Override // com.baidu.tieba.play.operableVideoView.b, com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(bx bxVar) {
        if (bxVar != null) {
            super.setData(bxVar);
            boolean z = this.agB == bxVar;
            this.agB = bxVar;
            if (this.hYe != null) {
                if (this.jHT && z) {
                    this.jHT = false;
                } else {
                    this.hYe.reset();
                }
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.b, com.baidu.tieba.play.operableVideoView.d, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        if (!this.hYe.a(false, false, "NEWINDEX")) {
            startPlay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aE(bx bxVar) {
        if (bxVar != null && bxVar.getId() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921394, bxVar.getId()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.afd.videopaster.a a(bx bxVar, com.baidu.afd.videopaster.data.b bVar) {
        int i;
        int i2;
        int i3;
        int i4 = -1;
        if (bxVar == null || bVar == null) {
            return null;
        }
        int rW = bVar.rW();
        int rX = bVar.rX();
        int rV = bVar.rV();
        if (rV != -1) {
            i = rW != -1 ? (rV - rW) - 1 : -1;
            if (rX != -1) {
                i4 = (rX - rV) - 1;
            }
        } else {
            i = -1;
        }
        VideoInfo blU = bxVar.blU();
        if (blU != null) {
            i3 = blU.video_width.intValue();
            i2 = blU.video_height.intValue();
        } else {
            i2 = 0;
            i3 = 0;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("video_vid", bxVar.getId());
        hashMap.put("video_title", bxVar.getTitle());
        hashMap.put("forum_id", String.valueOf(bxVar.getFid()));
        hashMap.put("forum_name", bxVar.blG());
        hashMap.put("up_distance", String.valueOf(i));
        hashMap.put("down_distance", String.valueOf(i4));
        com.baidu.afd.videopaster.a a2 = com.baidu.afd.videopaster.c.a(3, 0, "1546854828072", rV + 1, i3, i2);
        a2.u(hashMap);
        return a2;
    }

    public void onPause() {
    }

    public void onResume() {
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean rh(boolean z) {
        if (this.hYe != null) {
            if (z) {
                if (this.hYe.rA()) {
                    this.jHU = false;
                    this.hYe.stop();
                }
            } else if (this.hYe.rA()) {
                this.jHT = true;
                this.hYe.aB(true);
            }
        }
        return super.rh(z);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void startPlay() {
        if (this.hYe != null && this.hYe.rA()) {
            this.jHU = true;
            this.hYe.resume();
            return;
        }
        super.startPlay();
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void stopPlay() {
        super.stopPlay();
        if (this.hYe != null && this.hYe.rA()) {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jHV);
            com.baidu.adp.lib.f.e.mY().post(this.jHV);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected int cLn() {
        return 1;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean isPlaying() {
        if (this.hYe == null || !this.hYe.rA()) {
            return super.isPlaying();
        }
        return this.jHU || this.hYe.rK();
    }
}
