package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.g.e;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.afd.videopaster.d;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.operableVideoView.c;
import java.util.HashMap;
import tbclient.VideoInfo;
/* loaded from: classes4.dex */
public class d extends com.baidu.tieba.play.operableVideoView.c {
    private bg XR;
    private com.baidu.afd.videopaster.d ehM;
    private CustomMessageListener eic;
    private boolean fNY;
    protected boolean fNZ;
    private Runnable fOa;

    public d(Context context, View view) {
        super(context, view);
        this.fNY = false;
        this.eic = new CustomMessageListener(2921395) { // from class: com.baidu.tieba.homepage.personalize.view.d.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.afd.videopaster.data.b bVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.afd.videopaster.data.b) && (bVar = (com.baidu.afd.videopaster.data.b) customResponsedMessage.getData()) != null) {
                    String videoId = bVar.getVideoId();
                    if (!StringUtils.isNull(videoId) && d.this.XR != null && videoId.equals(d.this.XR.getId())) {
                        d.this.ehM.a(d.this.a(d.this.XR, bVar));
                    }
                }
            }
        };
        this.fOa = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.view.d.4
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.ehM != null) {
                    d.this.fNZ = false;
                    d.this.ehM.stop();
                }
            }
        };
        pe(true);
        bna();
    }

    protected void bna() {
        this.ehM = new com.baidu.afd.videopaster.d(this.mContext, (ViewGroup) bSX());
        this.ehM.a(new d.a() { // from class: com.baidu.tieba.homepage.personalize.view.d.1
            @Override // com.baidu.afd.videopaster.d.a
            public void qs() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void qr() {
                d.this.xs(d.this.hZw);
                d.this.hZA |= 1;
                d.this.xs(d.this.hZA);
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void qq() {
                d.this.bUj();
            }

            @Override // com.baidu.afd.videopaster.d.a
            public boolean qt() {
                return false;
            }
        });
        a(new c.a() { // from class: com.baidu.tieba.homepage.personalize.view.d.2
            @Override // com.baidu.tieba.play.operableVideoView.c.a
            public void bx(int i, int i2) {
                if (!d.this.bUl()) {
                    if (i2 >= i) {
                        if (d.this.ehM.a(d.this.isFullScreen(), d.this.hZU, "NEWINDEX")) {
                        }
                    } else if (i != 0 && !d.this.hZU && (i2 * 100) / i >= 80 && i > 15000) {
                        d.this.at(d.this.XR);
                    }
                }
            }
        });
        this.eic.setTag(this.Zq);
        MessageManager.getInstance().registerListener(this.eic);
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.operableVideoView.a
    public void setData(bg bgVar) {
        if (bgVar != null) {
            super.setData(bgVar);
            boolean z = this.XR == bgVar;
            this.XR = bgVar;
            if (this.ehM != null) {
                if (this.fNY && z) {
                    this.fNY = false;
                } else {
                    this.ehM.reset();
                }
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.g.a
    public void onCompletion(g gVar) {
        if (!this.ehM.a(isFullScreen(), this.hZU, "NEWINDEX")) {
            xs(this.hZw);
            this.hZA |= 1;
            xs(this.hZA);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.c
    public void ks(boolean z) {
        super.ks(z);
        if (this.ehM != null) {
            if (z) {
                this.ehM.qj();
            } else {
                this.ehM.qk();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void at(bg bgVar) {
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
        int qx = bVar.qx();
        int qy = bVar.qy();
        int qw = bVar.qw();
        if (qw != -1) {
            i = qx != -1 ? (qw - qx) - 1 : -1;
            if (qy != -1) {
                i4 = (qy - qw) - 1;
            }
        } else {
            i = -1;
        }
        VideoInfo Zi = bgVar.Zi();
        if (Zi != null) {
            i3 = Zi.video_width.intValue();
            i2 = Zi.video_height.intValue();
        } else {
            i2 = 0;
            i3 = 0;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("video_vid", bgVar.getId());
        hashMap.put("video_title", bgVar.getTitle());
        hashMap.put("forum_id", String.valueOf(bgVar.getFid()));
        hashMap.put("forum_name", bgVar.YW());
        hashMap.put("up_distance", String.valueOf(i));
        hashMap.put("down_distance", String.valueOf(i4));
        com.baidu.afd.videopaster.a a = com.baidu.afd.videopaster.c.a(3, 0, "1546854828072", qw + 1, i3, i2);
        a.l(hashMap);
        return a;
    }

    public void onPause() {
    }

    public void onResume() {
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.operableVideoView.a
    public boolean kr(boolean z) {
        if (this.ehM != null) {
            if (z) {
                if (this.ehM.qb()) {
                    this.fNZ = false;
                    this.ehM.stop();
                }
            } else if (this.ehM.qb()) {
                this.fNY = true;
                this.ehM.aC(true);
            }
        }
        return super.kr(z);
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.operableVideoView.a
    public void startPlay() {
        if (this.ehM != null && this.ehM.qb()) {
            this.fNZ = true;
            this.ehM.resume();
            return;
        }
        super.startPlay();
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.operableVideoView.a
    public void stopPlay() {
        super.stopPlay();
        if (this.ehM != null && this.ehM.qb()) {
            e.jH().removeCallbacks(this.fOa);
            e.jH().post(this.fOa);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.c
    protected int bnb() {
        return 1;
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.operableVideoView.a
    public boolean isPlaying() {
        if (this.ehM == null || !this.ehM.qb()) {
            return super.isPlaying();
        }
        return this.fNZ || this.ehM.ql();
    }
}
