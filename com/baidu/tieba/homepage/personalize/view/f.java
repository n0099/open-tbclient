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
import com.baidu.tieba.play.operableVideoView.d;
import java.util.HashMap;
import tbclient.VideoInfo;
/* loaded from: classes9.dex */
public class f extends com.baidu.tieba.play.operableVideoView.d {
    private bj KJ;
    private com.baidu.afd.videopaster.d fKi;
    private CustomMessageListener fKx;
    private boolean hhp;
    protected boolean hhq;
    private Runnable hhr;

    public f(Context context, View view) {
        super(context, view);
        this.hhp = false;
        this.fKx = new CustomMessageListener(2921395) { // from class: com.baidu.tieba.homepage.personalize.view.f.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.afd.videopaster.data.b bVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.afd.videopaster.data.b) && (bVar = (com.baidu.afd.videopaster.data.b) customResponsedMessage.getData()) != null) {
                    String videoId = bVar.getVideoId();
                    if (!StringUtils.isNull(videoId) && f.this.KJ != null && videoId.equals(f.this.KJ.getId())) {
                        f.this.fKi.a(f.this.a(f.this.KJ, bVar));
                    }
                }
            }
        };
        this.hhr = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.view.f.4
            @Override // java.lang.Runnable
            public void run() {
                if (f.this.fKi != null) {
                    f.this.hhq = false;
                    f.this.fKi.stop();
                    f.this.fKi.onDestroy();
                }
            }
        };
        rX(true);
        bPD();
    }

    protected void bPD() {
        this.fKi = new com.baidu.afd.videopaster.d(this.mContext, (ViewGroup) cyL());
        this.fKi.a(new d.a() { // from class: com.baidu.tieba.homepage.personalize.view.f.1
            @Override // com.baidu.afd.videopaster.d.a
            public void ll() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void lk() {
                f.this.zG(f.this.jzv);
                f.this.jzz |= 1;
                f.this.zG(f.this.jzz);
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void lj() {
                f.this.cAc();
            }

            @Override // com.baidu.afd.videopaster.d.a
            public boolean lm() {
                return false;
            }
        });
        a(new d.a() { // from class: com.baidu.tieba.homepage.personalize.view.f.2
            @Override // com.baidu.tieba.play.operableVideoView.d.a
            public void bY(int i, int i2) {
                if (!f.this.cAf()) {
                    if (i2 >= i) {
                        if (f.this.fKi.a(f.this.isFullScreen(), f.this.Pj, "NEWINDEX")) {
                        }
                    } else if (i != 0 && !f.this.Pj && (i2 * 100) / i >= 80 && i > 15000) {
                        f.this.aC(f.this.KJ);
                    }
                }
            }
        });
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        this.fKx.setTag(this.MP);
        MessageManager.getInstance().registerListener(this.fKx);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(bj bjVar) {
        if (bjVar != null) {
            super.setData(bjVar);
            boolean z = this.KJ == bjVar;
            this.KJ = bjVar;
            if (this.fKi != null) {
                if (this.hhp && z) {
                    this.hhp = false;
                } else {
                    this.fKi.reset();
                }
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.g.a
    public void onCompletion(com.baidu.tieba.play.g gVar) {
        if (!this.fKi.a(isFullScreen(), this.Pj, "NEWINDEX")) {
            zG(this.jzv);
            this.jzz |= 1;
            zG(this.jzz);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void mS(boolean z) {
        super.mS(z);
        if (this.fKi != null) {
            if (z) {
                this.fKi.lc();
            } else {
                this.fKi.ld();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aC(bj bjVar) {
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
        VideoInfo aCI = bjVar.aCI();
        if (aCI != null) {
            i3 = aCI.video_width.intValue();
            i2 = aCI.video_height.intValue();
        } else {
            i2 = 0;
            i3 = 0;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("video_vid", bjVar.getId());
        hashMap.put("video_title", bjVar.getTitle());
        hashMap.put("forum_id", String.valueOf(bjVar.getFid()));
        hashMap.put("forum_name", bjVar.aCw());
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
    public boolean mR(boolean z) {
        if (this.fKi != null) {
            if (z) {
                if (this.fKi.kU()) {
                    this.hhq = false;
                    this.fKi.stop();
                }
            } else if (this.fKi.kU()) {
                this.hhp = true;
                this.fKi.Y(true);
            }
        }
        return super.mR(z);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void startPlay() {
        if (this.fKi != null && this.fKi.kU()) {
            this.hhq = true;
            this.fKi.resume();
            return;
        }
        super.startPlay();
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void stopPlay() {
        super.stopPlay();
        if (this.fKi != null && this.fKi.kU()) {
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.hhr);
            com.baidu.adp.lib.f.e.gx().post(this.hhr);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected int bPE() {
        return 1;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean isPlaying() {
        if (this.fKi == null || !this.fKi.kU()) {
            return super.isPlaying();
        }
        return this.hhq || this.fKi.le();
    }
}
