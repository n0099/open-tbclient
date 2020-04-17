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
    private bj adG;
    private com.baidu.afd.videopaster.d goO;
    private CustomMessageListener gpd;
    private boolean hQZ;
    protected boolean hRa;
    private Runnable hRb;

    public f(Context context, View view) {
        super(context, view);
        this.hQZ = false;
        this.gpd = new CustomMessageListener(2921395) { // from class: com.baidu.tieba.homepage.personalize.view.f.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.afd.videopaster.data.b bVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.afd.videopaster.data.b) && (bVar = (com.baidu.afd.videopaster.data.b) customResponsedMessage.getData()) != null) {
                    String videoId = bVar.getVideoId();
                    if (!StringUtils.isNull(videoId) && f.this.adG != null && videoId.equals(f.this.adG.getId())) {
                        f.this.goO.a(f.this.a(f.this.adG, bVar));
                    }
                }
            }
        };
        this.hRb = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.view.f.4
            @Override // java.lang.Runnable
            public void run() {
                if (f.this.goO != null) {
                    f.this.hRa = false;
                    f.this.goO.stop();
                    f.this.goO.onDestroy();
                }
            }
        };
        tb(true);
        cae();
    }

    protected void cae() {
        this.goO = new com.baidu.afd.videopaster.d(this.mContext, (ViewGroup) cJq());
        this.goO.a(new d.a() { // from class: com.baidu.tieba.homepage.personalize.view.f.1
            @Override // com.baidu.afd.videopaster.d.a
            public void pP() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void pO() {
                f.this.Ah(f.this.kjz);
                f.this.kjD |= 1;
                f.this.Ah(f.this.kjD);
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void pN() {
                f.this.cKM();
            }

            @Override // com.baidu.afd.videopaster.d.a
            public boolean pQ() {
                return false;
            }
        });
        a(new d.a() { // from class: com.baidu.tieba.homepage.personalize.view.f.2
            @Override // com.baidu.tieba.play.operableVideoView.d.a
            public void ce(int i, int i2) {
                if (!f.this.cKP()) {
                    if (i2 >= i) {
                        if (f.this.goO.a(f.this.isFullScreen(), f.this.ahK, "NEWINDEX")) {
                        }
                    } else if (i != 0 && !f.this.ahK && (i2 * 100) / i >= 80 && i > 15000) {
                        f.this.aD(f.this.adG);
                    }
                }
            }
        });
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        this.gpd.setTag(this.afA);
        MessageManager.getInstance().registerListener(this.gpd);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(bj bjVar) {
        if (bjVar != null) {
            super.setData(bjVar);
            boolean z = this.adG == bjVar;
            this.adG = bjVar;
            if (this.goO != null) {
                if (this.hQZ && z) {
                    this.hQZ = false;
                } else {
                    this.goO.reset();
                }
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.g.a
    public void onCompletion(com.baidu.tieba.play.g gVar) {
        if (!this.goO.a(isFullScreen(), this.ahK, "NEWINDEX")) {
            Ah(this.kjz);
            this.kjD |= 1;
            Ah(this.kjD);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void nW(boolean z) {
        super.nW(z);
        if (this.goO != null) {
            if (z) {
                this.goO.pG();
            } else {
                this.goO.pH();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aD(bj bjVar) {
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
        int pU = bVar.pU();
        int pV = bVar.pV();
        int pT = bVar.pT();
        if (pT != -1) {
            i = pU != -1 ? (pT - pU) - 1 : -1;
            if (pV != -1) {
                i4 = (pV - pT) - 1;
            }
        } else {
            i = -1;
        }
        VideoInfo aKV = bjVar.aKV();
        if (aKV != null) {
            i3 = aKV.video_width.intValue();
            i2 = aKV.video_height.intValue();
        } else {
            i2 = 0;
            i3 = 0;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("video_vid", bjVar.getId());
        hashMap.put("video_title", bjVar.getTitle());
        hashMap.put("forum_id", String.valueOf(bjVar.getFid()));
        hashMap.put("forum_name", bjVar.aKJ());
        hashMap.put("up_distance", String.valueOf(i));
        hashMap.put("down_distance", String.valueOf(i4));
        com.baidu.afd.videopaster.a a = com.baidu.afd.videopaster.c.a(3, 0, "1546854828072", pT + 1, i3, i2);
        a.w(hashMap);
        return a;
    }

    public void onPause() {
    }

    public void onResume() {
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean nV(boolean z) {
        if (this.goO != null) {
            if (z) {
                if (this.goO.py()) {
                    this.hRa = false;
                    this.goO.stop();
                }
            } else if (this.goO.py()) {
                this.hQZ = true;
                this.goO.ax(true);
            }
        }
        return super.nV(z);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void startPlay() {
        if (this.goO != null && this.goO.py()) {
            this.hRa = true;
            this.goO.resume();
            return;
        }
        super.startPlay();
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void stopPlay() {
        super.stopPlay();
        if (this.goO != null && this.goO.py()) {
            com.baidu.adp.lib.f.e.lb().removeCallbacks(this.hRb);
            com.baidu.adp.lib.f.e.lb().post(this.hRb);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected int caf() {
        return 1;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean isPlaying() {
        if (this.goO == null || !this.goO.py()) {
            return super.isPlaying();
        }
        return this.hRa || this.goO.pI();
    }
}
