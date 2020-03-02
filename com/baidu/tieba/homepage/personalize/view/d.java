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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.operableVideoView.d;
import java.util.HashMap;
import tbclient.VideoInfo;
/* loaded from: classes9.dex */
public class d extends com.baidu.tieba.play.operableVideoView.d {
    private bj KJ;
    private CustomMessageListener fJC;
    private com.baidu.afd.videopaster.d fJn;
    private boolean hfD;
    protected boolean hfE;
    private Runnable hfF;

    public d(Context context, View view) {
        super(context, view);
        this.hfD = false;
        this.fJC = new CustomMessageListener(2921395) { // from class: com.baidu.tieba.homepage.personalize.view.d.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.afd.videopaster.data.b bVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.afd.videopaster.data.b) && (bVar = (com.baidu.afd.videopaster.data.b) customResponsedMessage.getData()) != null) {
                    String videoId = bVar.getVideoId();
                    if (!StringUtils.isNull(videoId) && d.this.KJ != null && videoId.equals(d.this.KJ.getId())) {
                        d.this.fJn.a(d.this.a(d.this.KJ, bVar));
                    }
                }
            }
        };
        this.hfF = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.view.d.4
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.fJn != null) {
                    d.this.hfE = false;
                    d.this.fJn.stop();
                    d.this.fJn.onDestroy();
                }
            }
        };
        rR(true);
        bPk();
    }

    protected void bPk() {
        this.fJn = new com.baidu.afd.videopaster.d(this.mContext, (ViewGroup) cyr());
        this.fJn.a(new d.a() { // from class: com.baidu.tieba.homepage.personalize.view.d.1
            @Override // com.baidu.afd.videopaster.d.a
            public void ll() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void lk() {
                d.this.zy(d.this.jxK);
                d.this.jxO |= 1;
                d.this.zy(d.this.jxO);
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void lj() {
                d.this.czH();
            }

            @Override // com.baidu.afd.videopaster.d.a
            public boolean lm() {
                return false;
            }
        });
        a(new d.a() { // from class: com.baidu.tieba.homepage.personalize.view.d.2
            @Override // com.baidu.tieba.play.operableVideoView.d.a
            public void bX(int i, int i2) {
                if (!d.this.czK()) {
                    if (i2 >= i) {
                        if (d.this.fJn.a(d.this.isFullScreen(), d.this.Pi, "NEWINDEX")) {
                        }
                    } else if (i != 0 && !d.this.Pi && (i2 * 100) / i >= 80 && i > 15000) {
                        d.this.aB(d.this.KJ);
                    }
                }
            }
        });
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        this.fJC.setTag(this.MO);
        MessageManager.getInstance().registerListener(this.fJC);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(bj bjVar) {
        if (bjVar != null) {
            super.setData(bjVar);
            boolean z = this.KJ == bjVar;
            this.KJ = bjVar;
            if (this.fJn != null) {
                if (this.hfD && z) {
                    this.hfD = false;
                } else {
                    this.fJn.reset();
                }
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.g.a
    public void onCompletion(g gVar) {
        if (!this.fJn.a(isFullScreen(), this.Pi, "NEWINDEX")) {
            zy(this.jxK);
            this.jxO |= 1;
            zy(this.jxO);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void mM(boolean z) {
        super.mM(z);
        if (this.fJn != null) {
            if (z) {
                this.fJn.lc();
            } else {
                this.fJn.ld();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aB(bj bjVar) {
        if (bjVar != null && bjVar.getId() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921394, bjVar.getId()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.afd.videopaster.a a(bj bjVar, com.baidu.afd.videopaster.data.b bVar) {
        int i;
        int i2;
        int i3;
        int i4 = -1;
        if (bjVar == null || bVar == null) {
            return null;
        }
        int lq = bVar.lq();
        int lr = bVar.lr();
        int lp = bVar.lp();
        if (lp != -1) {
            i = lq != -1 ? (lp - lq) - 1 : -1;
            if (lr != -1) {
                i4 = (lr - lp) - 1;
            }
        } else {
            i = -1;
        }
        VideoInfo aCF = bjVar.aCF();
        if (aCF != null) {
            i3 = aCF.video_width.intValue();
            i2 = aCF.video_height.intValue();
        } else {
            i2 = 0;
            i3 = 0;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("video_vid", bjVar.getId());
        hashMap.put("video_title", bjVar.getTitle());
        hashMap.put("forum_id", String.valueOf(bjVar.getFid()));
        hashMap.put("forum_name", bjVar.aCt());
        hashMap.put("up_distance", String.valueOf(i));
        hashMap.put("down_distance", String.valueOf(i4));
        com.baidu.afd.videopaster.a a = com.baidu.afd.videopaster.c.a(3, 0, "1546854828072", lp + 1, i3, i2);
        a.j(hashMap);
        return a;
    }

    public void onPause() {
    }

    public void onResume() {
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean mL(boolean z) {
        if (this.fJn != null) {
            if (z) {
                if (this.fJn.kU()) {
                    this.hfE = false;
                    this.fJn.stop();
                }
            } else if (this.fJn.kU()) {
                this.hfD = true;
                this.fJn.Y(true);
            }
        }
        return super.mL(z);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void startPlay() {
        if (this.fJn != null && this.fJn.kU()) {
            this.hfE = true;
            this.fJn.resume();
            return;
        }
        super.startPlay();
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void stopPlay() {
        super.stopPlay();
        if (this.fJn != null && this.fJn.kU()) {
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.hfF);
            com.baidu.adp.lib.f.e.gx().post(this.hfF);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected int bPl() {
        return 1;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean isPlaying() {
        if (this.fJn == null || !this.fJn.kU()) {
            return super.isPlaying();
        }
        return this.hfE || this.fJn.le();
    }
}
