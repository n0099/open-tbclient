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
/* loaded from: classes22.dex */
public class f extends com.baidu.tieba.play.operableVideoView.b {
    private bw agx;
    private com.baidu.afd.videopaster.d hXE;
    private CustomMessageListener hXT;
    private boolean jHi;
    protected boolean jHj;
    private Runnable jHk;

    public f(Context context, View view) {
        super(context, view);
        this.jHi = false;
        this.hXT = new CustomMessageListener(2921395) { // from class: com.baidu.tieba.homepage.personalize.view.f.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.afd.videopaster.data.b bVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.afd.videopaster.data.b) && (bVar = (com.baidu.afd.videopaster.data.b) customResponsedMessage.getData()) != null) {
                    String videoId = bVar.getVideoId();
                    if (!StringUtils.isNull(videoId) && f.this.agx != null && videoId.equals(f.this.agx.getId())) {
                        f.this.hXE.a(f.this.a(f.this.agx, bVar));
                    }
                }
            }
        };
        this.jHk = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.view.f.4
            @Override // java.lang.Runnable
            public void run() {
                if (f.this.hXE != null) {
                    f.this.jHj = false;
                    f.this.hXE.stop();
                    f.this.hXE.onDestroy();
                }
            }
        };
        wv(true);
        cLG();
    }

    protected void cLG() {
        this.hXE = new com.baidu.afd.videopaster.d(this.mContext, (ViewGroup) dwP());
        this.hXE.a(new d.a() { // from class: com.baidu.tieba.homepage.personalize.view.f.1
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
            public void cH(int i, int i2) {
                if (!f.this.dxO()) {
                    if (i2 >= i) {
                        if (f.this.hXE.a(false, false, "NEWINDEX")) {
                        }
                    } else if (i != 0 && !f.this.alS && (i2 * 100) / i >= 80 && i > 15000) {
                        f.this.aC(f.this.agx);
                    }
                }
            }
        });
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        this.hXT.setTag(this.aiz);
        MessageManager.getInstance().registerListener(this.hXT);
    }

    @Override // com.baidu.tieba.play.operableVideoView.b, com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(bw bwVar) {
        if (bwVar != null) {
            super.setData(bwVar);
            boolean z = this.agx == bwVar;
            this.agx = bwVar;
            if (this.hXE != null) {
                if (this.jHi && z) {
                    this.jHi = false;
                } else {
                    this.hXE.reset();
                }
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.b, com.baidu.tieba.play.operableVideoView.d, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        if (!this.hXE.a(false, false, "NEWINDEX")) {
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
        VideoInfo bmS = bwVar.bmS();
        if (bmS != null) {
            i3 = bmS.video_width.intValue();
            i2 = bmS.video_height.intValue();
        } else {
            i2 = 0;
            i3 = 0;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("video_vid", bwVar.getId());
        hashMap.put("video_title", bwVar.getTitle());
        hashMap.put("forum_id", String.valueOf(bwVar.getFid()));
        hashMap.put("forum_name", bwVar.bmE());
        hashMap.put("up_distance", String.valueOf(i));
        hashMap.put("down_distance", String.valueOf(i4));
        com.baidu.afd.videopaster.a a2 = com.baidu.afd.videopaster.c.a(3, 0, "1546854828072", rV + 1, i3, i2);
        a2.u(hashMap);
        return a2;
    }

    public void onPause() {
    }

    public void onResume() {
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean re(boolean z) {
        if (this.hXE != null) {
            if (z) {
                if (this.hXE.rA()) {
                    this.jHj = false;
                    this.hXE.stop();
                }
            } else if (this.hXE.rA()) {
                this.jHi = true;
                this.hXE.aB(true);
            }
        }
        return super.re(z);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void startPlay() {
        if (this.hXE != null && this.hXE.rA()) {
            this.jHj = true;
            this.hXE.resume();
            return;
        }
        super.startPlay();
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void stopPlay() {
        super.stopPlay();
        if (this.hXE != null && this.hXE.rA()) {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jHk);
            com.baidu.adp.lib.f.e.mY().post(this.jHk);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected int cLH() {
        return 1;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean isPlaying() {
        if (this.hXE == null || !this.hXE.rA()) {
            return super.isPlaying();
        }
        return this.jHj || this.hXE.rK();
    }
}
