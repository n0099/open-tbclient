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
public class c extends com.baidu.tieba.play.operableVideoView.b {
    private bj KJ;
    private com.baidu.afd.videopaster.d fJA;
    private CustomMessageListener fJP;
    private boolean hfP;
    protected boolean hfQ;
    private Runnable hfR;

    public c(Context context, View view) {
        super(context, view);
        this.hfP = false;
        this.fJP = new CustomMessageListener(2921395) { // from class: com.baidu.tieba.homepage.personalize.view.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.afd.videopaster.data.b bVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.afd.videopaster.data.b) && (bVar = (com.baidu.afd.videopaster.data.b) customResponsedMessage.getData()) != null) {
                    String videoId = bVar.getVideoId();
                    if (!StringUtils.isNull(videoId) && c.this.KJ != null && videoId.equals(c.this.KJ.getId())) {
                        c.this.fJA.a(c.this.a(c.this.KJ, bVar));
                    }
                }
            }
        };
        this.hfR = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.view.c.4
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.fJA != null) {
                    c.this.hfQ = false;
                    c.this.fJA.stop();
                    c.this.fJA.onDestroy();
                }
            }
        };
        rR(true);
        bPl();
    }

    protected void bPl() {
        this.fJA = new com.baidu.afd.videopaster.d(this.mContext, (ViewGroup) cys());
        this.fJA.a(new d.a() { // from class: com.baidu.tieba.homepage.personalize.view.c.1
            @Override // com.baidu.afd.videopaster.d.a
            public void ll() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void lk() {
                c.this.startPlay();
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void lj() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public boolean lm() {
                return false;
            }
        });
        a(new d.a() { // from class: com.baidu.tieba.homepage.personalize.view.c.2
            @Override // com.baidu.tieba.play.operableVideoView.d.a
            public void bX(int i, int i2) {
                if (!c.this.czL()) {
                    if (i2 >= i) {
                        if (c.this.fJA.a(false, false, "NEWINDEX")) {
                        }
                    } else if (i != 0 && !c.this.Pi && (i2 * 100) / i >= 80 && i > 15000) {
                        c.this.aB(c.this.KJ);
                    }
                }
            }
        });
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        this.fJP.setTag(this.MO);
        MessageManager.getInstance().registerListener(this.fJP);
    }

    @Override // com.baidu.tieba.play.operableVideoView.b, com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(bj bjVar) {
        if (bjVar != null) {
            super.setData(bjVar);
            boolean z = this.KJ == bjVar;
            this.KJ = bjVar;
            if (this.fJA != null) {
                if (this.hfP && z) {
                    this.hfP = false;
                } else {
                    this.fJA.reset();
                }
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.b, com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.g.a
    public void onCompletion(g gVar) {
        if (!this.fJA.a(false, false, "NEWINDEX")) {
            startPlay();
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
        if (this.fJA != null) {
            if (z) {
                if (this.fJA.kU()) {
                    this.hfQ = false;
                    this.fJA.stop();
                }
            } else if (this.fJA.kU()) {
                this.hfP = true;
                this.fJA.Y(true);
            }
        }
        return super.mL(z);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void startPlay() {
        if (this.fJA != null && this.fJA.kU()) {
            this.hfQ = true;
            this.fJA.resume();
            return;
        }
        super.startPlay();
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void stopPlay() {
        super.stopPlay();
        if (this.fJA != null && this.fJA.kU()) {
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.hfR);
            com.baidu.adp.lib.f.e.gx().post(this.hfR);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected int bPm() {
        return 1;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean isPlaying() {
        if (this.fJA == null || !this.fJA.kU()) {
            return super.isPlaying();
        }
        return this.hfQ || this.fJA.le();
    }
}
