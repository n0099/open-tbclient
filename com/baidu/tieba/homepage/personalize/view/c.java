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
public class c extends com.baidu.tieba.play.operableVideoView.b {
    private bg We;
    private com.baidu.afd.videopaster.d eCi;
    private CustomMessageListener eCx;
    private boolean gli;
    protected boolean glj;
    private Runnable glk;

    public c(Context context, View view) {
        super(context, view);
        this.gli = false;
        this.eCx = new CustomMessageListener(2921395) { // from class: com.baidu.tieba.homepage.personalize.view.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.afd.videopaster.data.b bVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.afd.videopaster.data.b) && (bVar = (com.baidu.afd.videopaster.data.b) customResponsedMessage.getData()) != null) {
                    String videoId = bVar.getVideoId();
                    if (!StringUtils.isNull(videoId) && c.this.We != null && videoId.equals(c.this.We.getId())) {
                        c.this.eCi.a(c.this.a(c.this.We, bVar));
                    }
                }
            }
        };
        this.glk = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.view.c.4
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.eCi != null) {
                    c.this.glj = false;
                    c.this.eCi.stop();
                }
            }
        };
        qh(true);
        bxg();
    }

    protected void bxg() {
        this.eCi = new com.baidu.afd.videopaster.d(this.mContext, (ViewGroup) cdO());
        this.eCi.a(new d.a() { // from class: com.baidu.tieba.homepage.personalize.view.c.1
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
                if (!c.this.cfe()) {
                    if (i2 >= i) {
                        if (c.this.eCi.a(false, false, "NEWINDEX")) {
                        }
                    } else if (i != 0 && !c.this.iyC && (i2 * 100) / i >= 80 && i > 15000) {
                        c.this.aq(c.this.We);
                    }
                }
            }
        });
        this.eCx.setTag(this.XE);
        MessageManager.getInstance().registerListener(this.eCx);
    }

    @Override // com.baidu.tieba.play.operableVideoView.b, com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.operableVideoView.a
    public void setData(bg bgVar) {
        if (bgVar != null) {
            super.setData(bgVar);
            boolean z = this.We == bgVar;
            this.We = bgVar;
            if (this.eCi != null) {
                if (this.gli && z) {
                    this.gli = false;
                } else {
                    this.eCi.reset();
                }
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.b, com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.g.a
    public void onCompletion(g gVar) {
        if (!this.eCi.a(false, false, "NEWINDEX")) {
            startPlay();
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
        VideoInfo aeO = bgVar.aeO();
        if (aeO != null) {
            i3 = aeO.video_width.intValue();
            i2 = aeO.video_height.intValue();
        } else {
            i2 = 0;
            i3 = 0;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("video_vid", bgVar.getId());
        hashMap.put("video_title", bgVar.getTitle());
        hashMap.put("forum_id", String.valueOf(bgVar.getFid()));
        hashMap.put("forum_name", bgVar.aeC());
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
        if (this.eCi != null) {
            if (z) {
                if (this.eCi.pr()) {
                    this.glj = false;
                    this.eCi.stop();
                }
            } else if (this.eCi.pr()) {
                this.gli = true;
                this.eCi.ax(true);
            }
        }
        return super.lu(z);
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.operableVideoView.a
    public void startPlay() {
        if (this.eCi != null && this.eCi.pr()) {
            this.glj = true;
            this.eCi.resume();
            return;
        }
        super.startPlay();
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.operableVideoView.a
    public void stopPlay() {
        super.stopPlay();
        if (this.eCi != null && this.eCi.pr()) {
            com.baidu.adp.lib.g.e.iK().removeCallbacks(this.glk);
            com.baidu.adp.lib.g.e.iK().post(this.glk);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.c
    protected int bxh() {
        return 1;
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.operableVideoView.a
    public boolean isPlaying() {
        if (this.eCi == null || !this.eCi.pr()) {
            return super.isPlaying();
        }
        return this.glj || this.eCi.pB();
    }
}
