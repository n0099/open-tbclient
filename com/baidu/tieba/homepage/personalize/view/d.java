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
    private com.baidu.afd.videopaster.d exi;
    private CustomMessageListener exy;
    private boolean geU;
    protected boolean geV;
    private Runnable geW;

    public d(Context context, View view) {
        super(context, view);
        this.geU = false;
        this.exy = new CustomMessageListener(2921395) { // from class: com.baidu.tieba.homepage.personalize.view.d.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.afd.videopaster.data.b bVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.afd.videopaster.data.b) && (bVar = (com.baidu.afd.videopaster.data.b) customResponsedMessage.getData()) != null) {
                    String videoId = bVar.getVideoId();
                    if (!StringUtils.isNull(videoId) && d.this.VK != null && videoId.equals(d.this.VK.getId())) {
                        d.this.exi.a(d.this.a(d.this.VK, bVar));
                    }
                }
            }
        };
        this.geW = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.view.d.4
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.exi != null) {
                    d.this.geV = false;
                    d.this.exi.stop();
                }
            }
        };
        pS(true);
        buy();
    }

    protected void buy() {
        this.exi = new com.baidu.afd.videopaster.d(this.mContext, (ViewGroup) caV());
        this.exi.a(new d.a() { // from class: com.baidu.tieba.homepage.personalize.view.d.1
            @Override // com.baidu.afd.videopaster.d.a
            public void pn() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void pm() {
                d.this.yv(d.this.irJ);
                d.this.irN |= 1;
                d.this.yv(d.this.irN);
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void pl() {
                d.this.cci();
            }

            @Override // com.baidu.afd.videopaster.d.a
            public boolean po() {
                return false;
            }
        });
        a(new c.a() { // from class: com.baidu.tieba.homepage.personalize.view.d.2
            @Override // com.baidu.tieba.play.operableVideoView.c.a
            public void bE(int i, int i2) {
                if (!d.this.cck()) {
                    if (i2 >= i) {
                        if (d.this.exi.a(d.this.isFullScreen(), d.this.ish, "NEWINDEX")) {
                        }
                    } else if (i != 0 && !d.this.ish && (i2 * 100) / i >= 80 && i > 15000) {
                        d.this.aq(d.this.VK);
                    }
                }
            }
        });
        this.exy.setTag(this.Xk);
        MessageManager.getInstance().registerListener(this.exy);
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.operableVideoView.a
    public void setData(bg bgVar) {
        if (bgVar != null) {
            super.setData(bgVar);
            boolean z = this.VK == bgVar;
            this.VK = bgVar;
            if (this.exi != null) {
                if (this.geU && z) {
                    this.geU = false;
                } else {
                    this.exi.reset();
                }
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.g.a
    public void onCompletion(g gVar) {
        if (!this.exi.a(isFullScreen(), this.ish, "NEWINDEX")) {
            yv(this.irJ);
            this.irN |= 1;
            yv(this.irN);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.c
    public void li(boolean z) {
        super.li(z);
        if (this.exi != null) {
            if (z) {
                this.exi.pe();
            } else {
                this.exi.pf();
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
        if (this.exi != null) {
            if (z) {
                if (this.exi.oW()) {
                    this.geV = false;
                    this.exi.stop();
                }
            } else if (this.exi.oW()) {
                this.geU = true;
                this.exi.au(true);
            }
        }
        return super.lh(z);
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.operableVideoView.a
    public void startPlay() {
        if (this.exi != null && this.exi.oW()) {
            this.geV = true;
            this.exi.resume();
            return;
        }
        super.startPlay();
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.operableVideoView.a
    public void stopPlay() {
        super.stopPlay();
        if (this.exi != null && this.exi.oW()) {
            com.baidu.adp.lib.g.e.iB().removeCallbacks(this.geW);
            com.baidu.adp.lib.g.e.iB().post(this.geW);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.c
    protected int buz() {
        return 1;
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.operableVideoView.a
    public boolean isPlaying() {
        if (this.exi == null || !this.exi.oW()) {
            return super.isPlaying();
        }
        return this.geV || this.exi.pg();
    }
}
