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
    private bh We;
    private CustomMessageListener eCE;
    private com.baidu.afd.videopaster.d eCp;
    private boolean glY;
    protected boolean glZ;
    private Runnable gma;

    public c(Context context, View view) {
        super(context, view);
        this.glY = false;
        this.eCE = new CustomMessageListener(2921395) { // from class: com.baidu.tieba.homepage.personalize.view.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.afd.videopaster.data.b bVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.afd.videopaster.data.b) && (bVar = (com.baidu.afd.videopaster.data.b) customResponsedMessage.getData()) != null) {
                    String videoId = bVar.getVideoId();
                    if (!StringUtils.isNull(videoId) && c.this.We != null && videoId.equals(c.this.We.getId())) {
                        c.this.eCp.a(c.this.a(c.this.We, bVar));
                    }
                }
            }
        };
        this.gma = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.view.c.4
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.eCp != null) {
                    c.this.glZ = false;
                    c.this.eCp.stop();
                }
            }
        };
        qi(true);
        bxu();
    }

    protected void bxu() {
        this.eCp = new com.baidu.afd.videopaster.d(this.mContext, (ViewGroup) ceg());
        this.eCp.a(new d.a() { // from class: com.baidu.tieba.homepage.personalize.view.c.1
            @Override // com.baidu.afd.videopaster.d.a
            public void pI() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void pH() {
                c.this.startPlay();
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void pG() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public boolean pJ() {
                return false;
            }
        });
        a(new c.a() { // from class: com.baidu.tieba.homepage.personalize.view.c.2
            @Override // com.baidu.tieba.play.operableVideoView.c.a
            public void bK(int i, int i2) {
                if (!c.this.cfw()) {
                    if (i2 >= i) {
                        if (c.this.eCp.a(false, false, "NEWINDEX")) {
                        }
                    } else if (i != 0 && !c.this.izG && (i2 * 100) / i >= 80 && i > 15000) {
                        c.this.ar(c.this.We);
                    }
                }
            }
        });
        this.eCE.setTag(this.XE);
        MessageManager.getInstance().registerListener(this.eCE);
    }

    @Override // com.baidu.tieba.play.operableVideoView.b, com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.operableVideoView.a
    public void setData(bh bhVar) {
        if (bhVar != null) {
            super.setData(bhVar);
            boolean z = this.We == bhVar;
            this.We = bhVar;
            if (this.eCp != null) {
                if (this.glY && z) {
                    this.glY = false;
                } else {
                    this.eCp.reset();
                }
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.b, com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.g.a
    public void onCompletion(g gVar) {
        if (!this.eCp.a(false, false, "NEWINDEX")) {
            startPlay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ar(bh bhVar) {
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
        int pN = bVar.pN();
        int pO = bVar.pO();
        int pM = bVar.pM();
        if (pM != -1) {
            i = pN != -1 ? (pM - pN) - 1 : -1;
            if (pO != -1) {
                i4 = (pO - pM) - 1;
            }
        } else {
            i = -1;
        }
        VideoInfo aeP = bhVar.aeP();
        if (aeP != null) {
            i3 = aeP.video_width.intValue();
            i2 = aeP.video_height.intValue();
        } else {
            i2 = 0;
            i3 = 0;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("video_vid", bhVar.getId());
        hashMap.put("video_title", bhVar.getTitle());
        hashMap.put("forum_id", String.valueOf(bhVar.getFid()));
        hashMap.put("forum_name", bhVar.aeD());
        hashMap.put("up_distance", String.valueOf(i));
        hashMap.put("down_distance", String.valueOf(i4));
        com.baidu.afd.videopaster.a a = com.baidu.afd.videopaster.c.a(3, 0, "1546854828072", pM + 1, i3, i2);
        a.k(hashMap);
        return a;
    }

    public void onPause() {
    }

    public void onResume() {
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.operableVideoView.a
    public boolean lu(boolean z) {
        if (this.eCp != null) {
            if (z) {
                if (this.eCp.pr()) {
                    this.glZ = false;
                    this.eCp.stop();
                }
            } else if (this.eCp.pr()) {
                this.glY = true;
                this.eCp.ax(true);
            }
        }
        return super.lu(z);
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.operableVideoView.a
    public void startPlay() {
        if (this.eCp != null && this.eCp.pr()) {
            this.glZ = true;
            this.eCp.resume();
            return;
        }
        super.startPlay();
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.operableVideoView.a
    public void stopPlay() {
        super.stopPlay();
        if (this.eCp != null && this.eCp.pr()) {
            com.baidu.adp.lib.g.e.iK().removeCallbacks(this.gma);
            com.baidu.adp.lib.g.e.iK().post(this.gma);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.c
    protected int bxv() {
        return 1;
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.operableVideoView.a
    public boolean isPlaying() {
        if (this.eCp == null || !this.eCp.pr()) {
            return super.isPlaying();
        }
        return this.glZ || this.eCp.pB();
    }
}
