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
import com.baidu.tbadk.core.data.bk;
import com.baidu.tieba.play.operableVideoView.d;
import java.util.HashMap;
import tbclient.VideoInfo;
/* loaded from: classes9.dex */
public class f extends com.baidu.tieba.play.operableVideoView.d {
    private bk aee;
    private com.baidu.afd.videopaster.d gDU;
    private CustomMessageListener gEk;
    private boolean igC;
    protected boolean igD;
    private Runnable igE;

    public f(Context context, View view) {
        super(context, view);
        this.igC = false;
        this.gEk = new CustomMessageListener(2921395) { // from class: com.baidu.tieba.homepage.personalize.view.f.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.afd.videopaster.data.b bVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.afd.videopaster.data.b) && (bVar = (com.baidu.afd.videopaster.data.b) customResponsedMessage.getData()) != null) {
                    String videoId = bVar.getVideoId();
                    if (!StringUtils.isNull(videoId) && f.this.aee != null && videoId.equals(f.this.aee.getId())) {
                        f.this.gDU.a(f.this.a(f.this.aee, bVar));
                    }
                }
            }
        };
        this.igE = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.view.f.4
            @Override // java.lang.Runnable
            public void run() {
                if (f.this.gDU != null) {
                    f.this.igD = false;
                    f.this.gDU.stop();
                    f.this.gDU.onDestroy();
                }
            }
        };
        tz(true);
        cgL();
    }

    protected void cgL() {
        this.gDU = new com.baidu.afd.videopaster.d(this.mContext, (ViewGroup) cQD());
        this.gDU.a(new d.a() { // from class: com.baidu.tieba.homepage.personalize.view.f.1
            @Override // com.baidu.afd.videopaster.d.a
            public void pV() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void pU() {
                f.this.AU(f.this.kCG);
                f.this.kCK |= 1;
                f.this.AU(f.this.kCK);
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void pT() {
                f.this.cSa();
            }

            @Override // com.baidu.afd.videopaster.d.a
            public boolean pW() {
                return false;
            }
        });
        a(new d.a() { // from class: com.baidu.tieba.homepage.personalize.view.f.2
            @Override // com.baidu.tieba.play.operableVideoView.d.a
            public void cj(int i, int i2) {
                if (!f.this.cSd()) {
                    if (i2 >= i) {
                        if (f.this.gDU.a(f.this.isFullScreen(), f.this.air, "NEWINDEX")) {
                        }
                    } else if (i != 0 && !f.this.air && (i2 * 100) / i >= 80 && i > 15000) {
                        f.this.aD(f.this.aee);
                    }
                }
            }
        });
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        this.gEk.setTag(this.afZ);
        MessageManager.getInstance().registerListener(this.gEk);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(bk bkVar) {
        if (bkVar != null) {
            super.setData(bkVar);
            boolean z = this.aee == bkVar;
            this.aee = bkVar;
            if (this.gDU != null) {
                if (this.igC && z) {
                    this.igC = false;
                } else {
                    this.gDU.reset();
                }
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.g.a
    public void onCompletion(com.baidu.tieba.play.g gVar) {
        if (!this.gDU.a(isFullScreen(), this.air, "NEWINDEX")) {
            AU(this.kCG);
            this.kCK |= 1;
            AU(this.kCK);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void os(boolean z) {
        super.os(z);
        if (this.gDU != null) {
            if (z) {
                this.gDU.pM();
            } else {
                this.gDU.pN();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aD(bk bkVar) {
        if (bkVar != null && bkVar.getId() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921394, bkVar.getId()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.afd.videopaster.a a(bk bkVar, com.baidu.afd.videopaster.data.b bVar) {
        int i;
        int i2;
        int i3;
        int i4 = -1;
        if (bkVar == null || bVar == null) {
            return null;
        }
        int qa = bVar.qa();
        int qb = bVar.qb();
        int pZ = bVar.pZ();
        if (pZ != -1) {
            i = qa != -1 ? (pZ - qa) - 1 : -1;
            if (qb != -1) {
                i4 = (qb - pZ) - 1;
            }
        } else {
            i = -1;
        }
        VideoInfo aQQ = bkVar.aQQ();
        if (aQQ != null) {
            i3 = aQQ.video_width.intValue();
            i2 = aQQ.video_height.intValue();
        } else {
            i2 = 0;
            i3 = 0;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("video_vid", bkVar.getId());
        hashMap.put("video_title", bkVar.getTitle());
        hashMap.put("forum_id", String.valueOf(bkVar.getFid()));
        hashMap.put("forum_name", bkVar.aQC());
        hashMap.put("up_distance", String.valueOf(i));
        hashMap.put("down_distance", String.valueOf(i4));
        com.baidu.afd.videopaster.a a = com.baidu.afd.videopaster.c.a(3, 0, "1546854828072", pZ + 1, i3, i2);
        a.w(hashMap);
        return a;
    }

    public void onPause() {
    }

    public void onResume() {
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean or(boolean z) {
        if (this.gDU != null) {
            if (z) {
                if (this.gDU.pE()) {
                    this.igD = false;
                    this.gDU.stop();
                }
            } else if (this.gDU.pE()) {
                this.igC = true;
                this.gDU.az(true);
            }
        }
        return super.or(z);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void startPlay() {
        if (this.gDU != null && this.gDU.pE()) {
            this.igD = true;
            this.gDU.resume();
            return;
        }
        super.startPlay();
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void stopPlay() {
        super.stopPlay();
        if (this.gDU != null && this.gDU.pE()) {
            com.baidu.adp.lib.f.e.ld().removeCallbacks(this.igE);
            com.baidu.adp.lib.f.e.ld().post(this.igE);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected int cgM() {
        return 1;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean isPlaying() {
        if (this.gDU == null || !this.gDU.pE()) {
            return super.isPlaying();
        }
        return this.igD || this.gDU.pO();
    }
}
