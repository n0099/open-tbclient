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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tieba.play.operableVideoView.d;
import java.util.HashMap;
import tbclient.VideoInfo;
/* loaded from: classes21.dex */
public class f extends com.baidu.tieba.play.operableVideoView.b {
    private bw agf;
    private CustomMessageListener hqF;
    private com.baidu.afd.videopaster.d hqq;
    private boolean iZM;
    protected boolean iZN;
    private Runnable iZO;

    public f(Context context, View view) {
        super(context, view);
        this.iZM = false;
        this.hqF = new CustomMessageListener(2921395) { // from class: com.baidu.tieba.homepage.personalize.view.f.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.afd.videopaster.data.b bVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.afd.videopaster.data.b) && (bVar = (com.baidu.afd.videopaster.data.b) customResponsedMessage.getData()) != null) {
                    String videoId = bVar.getVideoId();
                    if (!StringUtils.isNull(videoId) && f.this.agf != null && videoId.equals(f.this.agf.getId())) {
                        f.this.hqq.a(f.this.a(f.this.agf, bVar));
                    }
                }
            }
        };
        this.iZO = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.view.f.4
            @Override // java.lang.Runnable
            public void run() {
                if (f.this.hqq != null) {
                    f.this.iZN = false;
                    f.this.hqq.stop();
                    f.this.hqq.onDestroy();
                }
            }
        };
        vo(true);
        cCp();
    }

    protected void cCp() {
        this.hqq = new com.baidu.afd.videopaster.d(this.mContext, (ViewGroup) dnv());
        this.hqq.a(new d.a() { // from class: com.baidu.tieba.homepage.personalize.view.f.1
            @Override // com.baidu.afd.videopaster.d.a
            public void rR() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void rQ() {
                f.this.startPlay();
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void rP() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public boolean rS() {
                return false;
            }
        });
        a(new d.a() { // from class: com.baidu.tieba.homepage.personalize.view.f.2
            @Override // com.baidu.tieba.play.operableVideoView.d.a
            public void cD(int i, int i2) {
                if (!f.this.dou()) {
                    if (i2 >= i) {
                        if (f.this.hqq.a(false, false, "NEWINDEX")) {
                        }
                    } else if (i != 0 && !f.this.alz && (i2 * 100) / i >= 80 && i > 15000) {
                        f.this.aC(f.this.agf);
                    }
                }
            }
        });
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        this.hqF.setTag(this.aih);
        MessageManager.getInstance().registerListener(this.hqF);
    }

    @Override // com.baidu.tieba.play.operableVideoView.b, com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(bw bwVar) {
        if (bwVar != null) {
            super.setData(bwVar);
            boolean z = this.agf == bwVar;
            this.agf = bwVar;
            if (this.hqq != null) {
                if (this.iZM && z) {
                    this.iZM = false;
                } else {
                    this.hqq.reset();
                }
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.b, com.baidu.tieba.play.operableVideoView.d, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        if (!this.hqq.a(false, false, "NEWINDEX")) {
            startPlay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aC(bw bwVar) {
        if (bwVar != null && bwVar.getId() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921394, bwVar.getId()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.afd.videopaster.a a(bw bwVar, com.baidu.afd.videopaster.data.b bVar) {
        int i;
        int i2;
        int i3;
        int i4 = -1;
        if (bwVar == null || bVar == null) {
            return null;
        }
        int rW = bVar.rW();
        int rX = bVar.rX();
        int rV = bVar.rV();
        if (rV != -1) {
            i = rW != -1 ? (rV - rW) - 1 : -1;
            if (rX != -1) {
                i4 = (rX - rV) - 1;
            }
        } else {
            i = -1;
        }
        VideoInfo bfQ = bwVar.bfQ();
        if (bfQ != null) {
            i3 = bfQ.video_width.intValue();
            i2 = bfQ.video_height.intValue();
        } else {
            i2 = 0;
            i3 = 0;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("video_vid", bwVar.getId());
        hashMap.put("video_title", bwVar.getTitle());
        hashMap.put("forum_id", String.valueOf(bwVar.getFid()));
        hashMap.put("forum_name", bwVar.bfC());
        hashMap.put("up_distance", String.valueOf(i));
        hashMap.put("down_distance", String.valueOf(i4));
        com.baidu.afd.videopaster.a a = com.baidu.afd.videopaster.c.a(3, 0, "1546854828072", rV + 1, i3, i2);
        a.u(hashMap);
        return a;
    }

    public void onPause() {
    }

    public void onResume() {
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean pX(boolean z) {
        if (this.hqq != null) {
            if (z) {
                if (this.hqq.rA()) {
                    this.iZN = false;
                    this.hqq.stop();
                }
            } else if (this.hqq.rA()) {
                this.iZM = true;
                this.hqq.aB(true);
            }
        }
        return super.pX(z);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void startPlay() {
        if (this.hqq != null && this.hqq.rA()) {
            this.iZN = true;
            this.hqq.resume();
            return;
        }
        super.startPlay();
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void stopPlay() {
        super.stopPlay();
        if (this.hqq != null && this.hqq.rA()) {
            com.baidu.adp.lib.f.e.mX().removeCallbacks(this.iZO);
            com.baidu.adp.lib.f.e.mX().post(this.iZO);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected int cCq() {
        return 1;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean isPlaying() {
        if (this.hqq == null || !this.hqq.rA()) {
            return super.isPlaying();
        }
        return this.iZN || this.hqq.rK();
    }
}
