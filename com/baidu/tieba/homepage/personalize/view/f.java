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
/* loaded from: classes16.dex */
public class f extends com.baidu.tieba.play.operableVideoView.b {
    private bw afJ;
    private com.baidu.afd.videopaster.d hjj;
    private CustomMessageListener hjy;
    private boolean iQZ;
    protected boolean iRa;
    private Runnable iRb;

    public f(Context context, View view) {
        super(context, view);
        this.iQZ = false;
        this.hjy = new CustomMessageListener(2921395) { // from class: com.baidu.tieba.homepage.personalize.view.f.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.afd.videopaster.data.b bVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.afd.videopaster.data.b) && (bVar = (com.baidu.afd.videopaster.data.b) customResponsedMessage.getData()) != null) {
                    String videoId = bVar.getVideoId();
                    if (!StringUtils.isNull(videoId) && f.this.afJ != null && videoId.equals(f.this.afJ.getId())) {
                        f.this.hjj.a(f.this.a(f.this.afJ, bVar));
                    }
                }
            }
        };
        this.iRb = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.view.f.4
            @Override // java.lang.Runnable
            public void run() {
                if (f.this.hjj != null) {
                    f.this.iRa = false;
                    f.this.hjj.stop();
                    f.this.hjj.onDestroy();
                }
            }
        };
        ve(true);
        cyH();
    }

    protected void cyH() {
        this.hjj = new com.baidu.afd.videopaster.d(this.mContext, (ViewGroup) djM());
        this.hjj.a(new d.a() { // from class: com.baidu.tieba.homepage.personalize.view.f.1
            @Override // com.baidu.afd.videopaster.d.a
            public void rM() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void rL() {
                f.this.startPlay();
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void rK() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public boolean rN() {
                return false;
            }
        });
        a(new d.a() { // from class: com.baidu.tieba.homepage.personalize.view.f.2
            @Override // com.baidu.tieba.play.operableVideoView.d.a
            public void cA(int i, int i2) {
                if (!f.this.dkK()) {
                    if (i2 >= i) {
                        if (f.this.hjj.a(false, false, "NEWINDEX")) {
                        }
                    } else if (i != 0 && !f.this.akX && (i2 * 100) / i >= 80 && i > 15000) {
                        f.this.aB(f.this.afJ);
                    }
                }
            }
        });
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        this.hjy.setTag(this.ahK);
        MessageManager.getInstance().registerListener(this.hjy);
    }

    @Override // com.baidu.tieba.play.operableVideoView.b, com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(bw bwVar) {
        if (bwVar != null) {
            super.setData(bwVar);
            boolean z = this.afJ == bwVar;
            this.afJ = bwVar;
            if (this.hjj != null) {
                if (this.iQZ && z) {
                    this.iQZ = false;
                } else {
                    this.hjj.reset();
                }
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.b, com.baidu.tieba.play.operableVideoView.d, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        if (!this.hjj.a(false, false, "NEWINDEX")) {
            startPlay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aB(bw bwVar) {
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
        int rR = bVar.rR();
        int rS = bVar.rS();
        int rQ = bVar.rQ();
        if (rQ != -1) {
            i = rR != -1 ? (rQ - rR) - 1 : -1;
            if (rS != -1) {
                i4 = (rS - rQ) - 1;
            }
        } else {
            i = -1;
        }
        VideoInfo beW = bwVar.beW();
        if (beW != null) {
            i3 = beW.video_width.intValue();
            i2 = beW.video_height.intValue();
        } else {
            i2 = 0;
            i3 = 0;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("video_vid", bwVar.getId());
        hashMap.put("video_title", bwVar.getTitle());
        hashMap.put("forum_id", String.valueOf(bwVar.getFid()));
        hashMap.put("forum_name", bwVar.beI());
        hashMap.put("up_distance", String.valueOf(i));
        hashMap.put("down_distance", String.valueOf(i4));
        com.baidu.afd.videopaster.a a = com.baidu.afd.videopaster.c.a(3, 0, "1546854828072", rQ + 1, i3, i2);
        a.u(hashMap);
        return a;
    }

    public void onPause() {
    }

    public void onResume() {
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean pN(boolean z) {
        if (this.hjj != null) {
            if (z) {
                if (this.hjj.rv()) {
                    this.iRa = false;
                    this.hjj.stop();
                }
            } else if (this.hjj.rv()) {
                this.iQZ = true;
                this.hjj.aB(true);
            }
        }
        return super.pN(z);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void startPlay() {
        if (this.hjj != null && this.hjj.rv()) {
            this.iRa = true;
            this.hjj.resume();
            return;
        }
        super.startPlay();
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void stopPlay() {
        super.stopPlay();
        if (this.hjj != null && this.hjj.rv()) {
            com.baidu.adp.lib.f.e.mS().removeCallbacks(this.iRb);
            com.baidu.adp.lib.f.e.mS().post(this.iRb);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected int cyI() {
        return 1;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean isPlaying() {
        if (this.hjj == null || !this.hjj.rv()) {
            return super.isPlaying();
        }
        return this.iRa || this.hjj.rF();
    }
}
