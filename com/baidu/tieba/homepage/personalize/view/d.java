package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.afd.videopaster.d;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.operableVideoView.c;
import java.util.HashMap;
import tbclient.VideoInfo;
/* loaded from: classes4.dex */
public class d extends com.baidu.tieba.play.operableVideoView.c {
    private bg VJ;
    private com.baidu.afd.videopaster.d exj;
    private CustomMessageListener exz;
    private boolean geX;
    protected boolean geY;
    private Runnable geZ;

    public d(Context context, View view) {
        super(context, view);
        this.geX = false;
        this.exz = new CustomMessageListener(2921395) { // from class: com.baidu.tieba.homepage.personalize.view.d.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.afd.videopaster.data.b bVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.afd.videopaster.data.b) && (bVar = (com.baidu.afd.videopaster.data.b) customResponsedMessage.getData()) != null) {
                    String videoId = bVar.getVideoId();
                    if (!StringUtils.isNull(videoId) && d.this.VJ != null && videoId.equals(d.this.VJ.getId())) {
                        d.this.exj.a(d.this.a(d.this.VJ, bVar));
                    }
                }
            }
        };
        this.geZ = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.view.d.4
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.exj != null) {
                    d.this.geY = false;
                    d.this.exj.stop();
                }
            }
        };
        pT(true);
        buC();
    }

    protected void buC() {
        this.exj = new com.baidu.afd.videopaster.d(this.mContext, (ViewGroup) caZ());
        this.exj.a(new d.a() { // from class: com.baidu.tieba.homepage.personalize.view.d.1
            @Override // com.baidu.afd.videopaster.d.a
            public void pn() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void pm() {
                d.this.yv(d.this.irN);
                d.this.irR |= 1;
                d.this.yv(d.this.irR);
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void pl() {
                d.this.ccm();
            }

            @Override // com.baidu.afd.videopaster.d.a
            public boolean po() {
                return false;
            }
        });
        a(new c.a() { // from class: com.baidu.tieba.homepage.personalize.view.d.2
            @Override // com.baidu.tieba.play.operableVideoView.c.a
            public void bE(int i, int i2) {
                if (!d.this.cco()) {
                    if (i2 >= i) {
                        if (d.this.exj.a(d.this.isFullScreen(), d.this.isl, "NEWINDEX")) {
                        }
                    } else if (i != 0 && !d.this.isl && (i2 * 100) / i >= 80 && i > 15000) {
                        d.this.aq(d.this.VJ);
                    }
                }
            }
        });
        this.exz.setTag(this.Xj);
        MessageManager.getInstance().registerListener(this.exz);
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.operableVideoView.a
    public void setData(bg bgVar) {
        if (bgVar != null) {
            super.setData(bgVar);
            boolean z = this.VJ == bgVar;
            this.VJ = bgVar;
            if (this.exj != null) {
                if (this.geX && z) {
                    this.geX = false;
                } else {
                    this.exj.reset();
                }
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.g.a
    public void onCompletion(g gVar) {
        if (!this.exj.a(isFullScreen(), this.isl, "NEWINDEX")) {
            yv(this.irN);
            this.irR |= 1;
            yv(this.irR);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.c
    public void lj(boolean z) {
        super.lj(z);
        if (this.exj != null) {
            if (z) {
                this.exj.pe();
            } else {
                this.exj.pf();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aq(bg bgVar) {
        if (bgVar != null && bgVar.getId() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921394, bgVar.getId()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.afd.videopaster.a a(bg bgVar, com.baidu.afd.videopaster.data.b bVar) {
        int i;
        int i2;
        int i3;
        int i4 = -1;
        if (bgVar == null || bVar == null) {
            return null;
        }
        int ps = bVar.ps();
        int pt = bVar.pt();
        int pr = bVar.pr();
        if (pr != -1) {
            i = ps != -1 ? (pr - ps) - 1 : -1;
            if (pt != -1) {
                i4 = (pt - pr) - 1;
            }
        } else {
            i = -1;
        }
        VideoInfo adM = bgVar.adM();
        if (adM != null) {
            i3 = adM.video_width.intValue();
            i2 = adM.video_height.intValue();
        } else {
            i2 = 0;
            i3 = 0;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("video_vid", bgVar.getId());
        hashMap.put("video_title", bgVar.getTitle());
        hashMap.put("forum_id", String.valueOf(bgVar.getFid()));
        hashMap.put("forum_name", bgVar.adA());
        hashMap.put("up_distance", String.valueOf(i));
        hashMap.put("down_distance", String.valueOf(i4));
        com.baidu.afd.videopaster.a a = com.baidu.afd.videopaster.c.a(3, 0, "1546854828072", pr + 1, i3, i2);
        a.k(hashMap);
        return a;
    }

    public void onPause() {
    }

    public void onResume() {
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.operableVideoView.a
    public boolean li(boolean z) {
        if (this.exj != null) {
            if (z) {
                if (this.exj.oW()) {
                    this.geY = false;
                    this.exj.stop();
                }
            } else if (this.exj.oW()) {
                this.geX = true;
                this.exj.au(true);
            }
        }
        return super.li(z);
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.operableVideoView.a
    public void startPlay() {
        if (this.exj != null && this.exj.oW()) {
            this.geY = true;
            this.exj.resume();
            return;
        }
        super.startPlay();
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.operableVideoView.a
    public void stopPlay() {
        super.stopPlay();
        if (this.exj != null && this.exj.oW()) {
            com.baidu.adp.lib.g.e.iB().removeCallbacks(this.geZ);
            com.baidu.adp.lib.g.e.iB().post(this.geZ);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.c
    protected int buD() {
        return 1;
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.operableVideoView.a
    public boolean isPlaying() {
        if (this.exj == null || !this.exj.oW()) {
            return super.isPlaying();
        }
        return this.geY || this.exj.pg();
    }
}
