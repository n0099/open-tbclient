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
public class d extends com.baidu.tieba.play.operableVideoView.c {
    private bh Wd;
    private com.baidu.afd.videopaster.d eDY;
    private CustomMessageListener eEn;
    private boolean gnP;
    protected boolean gnQ;
    private Runnable gnR;

    public d(Context context, View view) {
        super(context, view);
        this.gnP = false;
        this.eEn = new CustomMessageListener(2921395) { // from class: com.baidu.tieba.homepage.personalize.view.d.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.afd.videopaster.data.b bVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.afd.videopaster.data.b) && (bVar = (com.baidu.afd.videopaster.data.b) customResponsedMessage.getData()) != null) {
                    String videoId = bVar.getVideoId();
                    if (!StringUtils.isNull(videoId) && d.this.Wd != null && videoId.equals(d.this.Wd.getId())) {
                        d.this.eDY.a(d.this.a(d.this.Wd, bVar));
                    }
                }
            }
        };
        this.gnR = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.view.d.4
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.eDY != null) {
                    d.this.gnQ = false;
                    d.this.eDY.stop();
                }
            }
        };
        ql(true);
        byi();
    }

    protected void byi() {
        this.eDY = new com.baidu.afd.videopaster.d(this.mContext, (ViewGroup) ceV());
        this.eDY.a(new d.a() { // from class: com.baidu.tieba.homepage.personalize.view.d.1
            @Override // com.baidu.afd.videopaster.d.a
            public void pJ() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void pI() {
                d.this.zf(d.this.iBz);
                d.this.iBD |= 1;
                d.this.zf(d.this.iBD);
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void pH() {
                d.this.cgi();
            }

            @Override // com.baidu.afd.videopaster.d.a
            public boolean pK() {
                return false;
            }
        });
        a(new c.a() { // from class: com.baidu.tieba.homepage.personalize.view.d.2
            @Override // com.baidu.tieba.play.operableVideoView.c.a
            public void bK(int i, int i2) {
                if (!d.this.cgk()) {
                    if (i2 >= i) {
                        if (d.this.eDY.a(d.this.isFullScreen(), d.this.iBY, "NEWINDEX")) {
                        }
                    } else if (i != 0 && !d.this.iBY && (i2 * 100) / i >= 80 && i > 15000) {
                        d.this.as(d.this.Wd);
                    }
                }
            }
        });
        this.eEn.setTag(this.XD);
        MessageManager.getInstance().registerListener(this.eEn);
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.operableVideoView.a
    public void setData(bh bhVar) {
        if (bhVar != null) {
            super.setData(bhVar);
            boolean z = this.Wd == bhVar;
            this.Wd = bhVar;
            if (this.eDY != null) {
                if (this.gnP && z) {
                    this.gnP = false;
                } else {
                    this.eDY.reset();
                }
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.g.a
    public void onCompletion(g gVar) {
        if (!this.eDY.a(isFullScreen(), this.iBY, "NEWINDEX")) {
            zf(this.iBz);
            this.iBD |= 1;
            zf(this.iBD);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.c
    public void ly(boolean z) {
        super.ly(z);
        if (this.eDY != null) {
            if (z) {
                this.eDY.pA();
            } else {
                this.eDY.pB();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void as(bh bhVar) {
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
        int pO = bVar.pO();
        int pP = bVar.pP();
        int pN = bVar.pN();
        if (pN != -1) {
            i = pO != -1 ? (pN - pO) - 1 : -1;
            if (pP != -1) {
                i4 = (pP - pN) - 1;
            }
        } else {
            i = -1;
        }
        VideoInfo aeT = bhVar.aeT();
        if (aeT != null) {
            i3 = aeT.video_width.intValue();
            i2 = aeT.video_height.intValue();
        } else {
            i2 = 0;
            i3 = 0;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("video_vid", bhVar.getId());
        hashMap.put("video_title", bhVar.getTitle());
        hashMap.put("forum_id", String.valueOf(bhVar.getFid()));
        hashMap.put("forum_name", bhVar.aeH());
        hashMap.put("up_distance", String.valueOf(i));
        hashMap.put("down_distance", String.valueOf(i4));
        com.baidu.afd.videopaster.a a = com.baidu.afd.videopaster.c.a(3, 0, "1546854828072", pN + 1, i3, i2);
        a.k(hashMap);
        return a;
    }

    public void onPause() {
    }

    public void onResume() {
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.operableVideoView.a
    public boolean lx(boolean z) {
        if (this.eDY != null) {
            if (z) {
                if (this.eDY.ps()) {
                    this.gnQ = false;
                    this.eDY.stop();
                }
            } else if (this.eDY.ps()) {
                this.gnP = true;
                this.eDY.ax(true);
            }
        }
        return super.lx(z);
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.operableVideoView.a
    public void startPlay() {
        if (this.eDY != null && this.eDY.ps()) {
            this.gnQ = true;
            this.eDY.resume();
            return;
        }
        super.startPlay();
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.operableVideoView.a
    public void stopPlay() {
        super.stopPlay();
        if (this.eDY != null && this.eDY.ps()) {
            com.baidu.adp.lib.g.e.iK().removeCallbacks(this.gnR);
            com.baidu.adp.lib.g.e.iK().post(this.gnR);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.c
    protected int byj() {
        return 1;
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.operableVideoView.a
    public boolean isPlaying() {
        if (this.eDY == null || !this.eDY.ps()) {
            return super.isPlaying();
        }
        return this.gnQ || this.eDY.pC();
    }
}
