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
    private bg VK;
    private com.baidu.afd.videopaster.d exj;
    private CustomMessageListener exz;
    private boolean geV;
    protected boolean geW;
    private Runnable geX;

    public d(Context context, View view) {
        super(context, view);
        this.geV = false;
        this.exz = new CustomMessageListener(2921395) { // from class: com.baidu.tieba.homepage.personalize.view.d.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.afd.videopaster.data.b bVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.afd.videopaster.data.b) && (bVar = (com.baidu.afd.videopaster.data.b) customResponsedMessage.getData()) != null) {
                    String videoId = bVar.getVideoId();
                    if (!StringUtils.isNull(videoId) && d.this.VK != null && videoId.equals(d.this.VK.getId())) {
                        d.this.exj.a(d.this.a(d.this.VK, bVar));
                    }
                }
            }
        };
        this.geX = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.view.d.4
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.exj != null) {
                    d.this.geW = false;
                    d.this.exj.stop();
                }
            }
        };
        pS(true);
        buB();
    }

    protected void buB() {
        this.exj = new com.baidu.afd.videopaster.d(this.mContext, (ViewGroup) caY());
        this.exj.a(new d.a() { // from class: com.baidu.tieba.homepage.personalize.view.d.1
            @Override // com.baidu.afd.videopaster.d.a
            public void pn() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void pm() {
                d.this.yv(d.this.irM);
                d.this.irQ |= 1;
                d.this.yv(d.this.irQ);
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void pl() {
                d.this.ccl();
            }

            @Override // com.baidu.afd.videopaster.d.a
            public boolean po() {
                return false;
            }
        });
        a(new c.a() { // from class: com.baidu.tieba.homepage.personalize.view.d.2
            @Override // com.baidu.tieba.play.operableVideoView.c.a
            public void bE(int i, int i2) {
                if (!d.this.ccn()) {
                    if (i2 >= i) {
                        if (d.this.exj.a(d.this.isFullScreen(), d.this.isk, "NEWINDEX")) {
                        }
                    } else if (i != 0 && !d.this.isk && (i2 * 100) / i >= 80 && i > 15000) {
                        d.this.aq(d.this.VK);
                    }
                }
            }
        });
        this.exz.setTag(this.Xk);
        MessageManager.getInstance().registerListener(this.exz);
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.operableVideoView.a
    public void setData(bg bgVar) {
        if (bgVar != null) {
            super.setData(bgVar);
            boolean z = this.VK == bgVar;
            this.VK = bgVar;
            if (this.exj != null) {
                if (this.geV && z) {
                    this.geV = false;
                } else {
                    this.exj.reset();
                }
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.g.a
    public void onCompletion(g gVar) {
        if (!this.exj.a(isFullScreen(), this.isk, "NEWINDEX")) {
            yv(this.irM);
            this.irQ |= 1;
            yv(this.irQ);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.c
    public void li(boolean z) {
        super.li(z);
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
    public boolean lh(boolean z) {
        if (this.exj != null) {
            if (z) {
                if (this.exj.oW()) {
                    this.geW = false;
                    this.exj.stop();
                }
            } else if (this.exj.oW()) {
                this.geV = true;
                this.exj.au(true);
            }
        }
        return super.lh(z);
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.operableVideoView.a
    public void startPlay() {
        if (this.exj != null && this.exj.oW()) {
            this.geW = true;
            this.exj.resume();
            return;
        }
        super.startPlay();
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.operableVideoView.a
    public void stopPlay() {
        super.stopPlay();
        if (this.exj != null && this.exj.oW()) {
            com.baidu.adp.lib.g.e.iB().removeCallbacks(this.geX);
            com.baidu.adp.lib.g.e.iB().post(this.geX);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.c
    protected int buC() {
        return 1;
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.operableVideoView.a
    public boolean isPlaying() {
        if (this.exj == null || !this.exj.oW()) {
            return super.isPlaying();
        }
        return this.geW || this.exj.pg();
    }
}
