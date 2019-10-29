package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.afd.videopaster.d;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.operableVideoView.c;
import java.util.HashMap;
import tbclient.VideoInfo;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.play.operableVideoView.b {
    private bh FT;
    private com.baidu.afd.videopaster.d eMF;
    private CustomMessageListener eMU;
    private boolean gno;
    protected boolean gnp;
    private Runnable gnq;

    public c(Context context, View view) {
        super(context, view);
        this.gno = false;
        this.eMU = new CustomMessageListener(2921395) { // from class: com.baidu.tieba.homepage.personalize.view.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.afd.videopaster.data.b bVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.afd.videopaster.data.b) && (bVar = (com.baidu.afd.videopaster.data.b) customResponsedMessage.getData()) != null) {
                    String videoId = bVar.getVideoId();
                    if (!StringUtils.isNull(videoId) && c.this.FT != null && videoId.equals(c.this.FT.getId())) {
                        c.this.eMF.a(c.this.a(c.this.FT, bVar));
                    }
                }
            }
        };
        this.gnq = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.view.c.4
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.eMF != null) {
                    c.this.gnp = false;
                    c.this.eMF.stop();
                }
            }
        };
        pS(true);
        bvm();
    }

    protected void bvm() {
        this.eMF = new com.baidu.afd.videopaster.d(this.mContext, (ViewGroup) cbX());
        this.eMF.a(new d.a() { // from class: com.baidu.tieba.homepage.personalize.view.c.1
            @Override // com.baidu.afd.videopaster.d.a
            public void kE() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void kD() {
                c.this.startPlay();
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void kC() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public boolean kF() {
                return false;
            }
        });
        a(new c.a() { // from class: com.baidu.tieba.homepage.personalize.view.c.2
            @Override // com.baidu.tieba.play.operableVideoView.c.a
            public void bG(int i, int i2) {
                if (!c.this.cdk()) {
                    if (i2 >= i) {
                        if (c.this.eMF.a(false, false, "NEWINDEX")) {
                        }
                    } else if (i != 0 && !c.this.iAu && (i2 * 100) / i >= 80 && i > 15000) {
                        c.this.aq(c.this.FT);
                    }
                }
            }
        });
        this.eMU.setTag(this.Hx);
        MessageManager.getInstance().registerListener(this.eMU);
    }

    @Override // com.baidu.tieba.play.operableVideoView.b, com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.operableVideoView.a
    public void setData(bh bhVar) {
        if (bhVar != null) {
            super.setData(bhVar);
            boolean z = this.FT == bhVar;
            this.FT = bhVar;
            if (this.eMF != null) {
                if (this.gno && z) {
                    this.gno = false;
                } else {
                    this.eMF.reset();
                }
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.b, com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.g.a
    public void onCompletion(g gVar) {
        if (!this.eMF.a(false, false, "NEWINDEX")) {
            startPlay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aq(bh bhVar) {
        if (bhVar != null && bhVar.getId() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921394, bhVar.getId()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.afd.videopaster.a a(bh bhVar, com.baidu.afd.videopaster.data.b bVar) {
        int i;
        int i2;
        int i3;
        int i4 = -1;
        if (bhVar == null || bVar == null) {
            return null;
        }
        int kJ = bVar.kJ();
        int kK = bVar.kK();
        int kI = bVar.kI();
        if (kI != -1) {
            i = kJ != -1 ? (kI - kJ) - 1 : -1;
            if (kK != -1) {
                i4 = (kK - kI) - 1;
            }
        } else {
            i = -1;
        }
        VideoInfo aiX = bhVar.aiX();
        if (aiX != null) {
            i3 = aiX.video_width.intValue();
            i2 = aiX.video_height.intValue();
        } else {
            i2 = 0;
            i3 = 0;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("video_vid", bhVar.getId());
        hashMap.put("video_title", bhVar.getTitle());
        hashMap.put("forum_id", String.valueOf(bhVar.getFid()));
        hashMap.put("forum_name", bhVar.aiL());
        hashMap.put("up_distance", String.valueOf(i));
        hashMap.put("down_distance", String.valueOf(i4));
        com.baidu.afd.videopaster.a a = com.baidu.afd.videopaster.c.a(3, 0, "1546854828072", kI + 1, i3, i2);
        a.k(hashMap);
        return a;
    }

    public void onPause() {
    }

    public void onResume() {
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.operableVideoView.a
    public boolean ll(boolean z) {
        if (this.eMF != null) {
            if (z) {
                if (this.eMF.kn()) {
                    this.gnp = false;
                    this.eMF.stop();
                }
            } else if (this.eMF.kn()) {
                this.gno = true;
                this.eMF.Q(true);
            }
        }
        return super.ll(z);
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.operableVideoView.a
    public void startPlay() {
        if (this.eMF != null && this.eMF.kn()) {
            this.gnp = true;
            this.eMF.resume();
            return;
        }
        super.startPlay();
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.operableVideoView.a
    public void stopPlay() {
        super.stopPlay();
        if (this.eMF != null && this.eMF.kn()) {
            com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.gnq);
            com.baidu.adp.lib.g.e.fZ().post(this.gnq);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.c
    protected int bvn() {
        return 1;
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.operableVideoView.a
    public boolean isPlaying() {
        if (this.eMF == null || !this.eMF.kn()) {
            return super.isPlaying();
        }
        return this.gnp || this.eMF.kx();
    }
}
