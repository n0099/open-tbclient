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
/* loaded from: classes6.dex */
public class d extends com.baidu.tieba.play.operableVideoView.d {
    private bj Ki;
    private com.baidu.afd.videopaster.d fDE;
    private CustomMessageListener fDT;
    private boolean gZZ;
    protected boolean haa;
    private Runnable hab;

    public d(Context context, View view) {
        super(context, view);
        this.gZZ = false;
        this.fDT = new CustomMessageListener(2921395) { // from class: com.baidu.tieba.homepage.personalize.view.d.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.afd.videopaster.data.b bVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.afd.videopaster.data.b) && (bVar = (com.baidu.afd.videopaster.data.b) customResponsedMessage.getData()) != null) {
                    String videoId = bVar.getVideoId();
                    if (!StringUtils.isNull(videoId) && d.this.Ki != null && videoId.equals(d.this.Ki.getId())) {
                        d.this.fDE.a(d.this.a(d.this.Ki, bVar));
                    }
                }
            }
        };
        this.hab = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.view.d.4
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.fDE != null) {
                    d.this.haa = false;
                    d.this.fDE.stop();
                    d.this.fDE.onDestroy();
                }
            }
        };
        rB(true);
        bMy();
    }

    protected void bMy() {
        this.fDE = new com.baidu.afd.videopaster.d(this.mContext, (ViewGroup) cvN());
        this.fDE.a(new d.a() { // from class: com.baidu.tieba.homepage.personalize.view.d.1
            @Override // com.baidu.afd.videopaster.d.a
            public void kV() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void kU() {
                d.this.zm(d.this.jtk);
                d.this.jto |= 1;
                d.this.zm(d.this.jto);
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void kT() {
                d.this.cxb();
            }

            @Override // com.baidu.afd.videopaster.d.a
            public boolean kW() {
                return false;
            }
        });
        a(new d.a() { // from class: com.baidu.tieba.homepage.personalize.view.d.2
            @Override // com.baidu.tieba.play.operableVideoView.d.a
            public void bX(int i, int i2) {
                if (!d.this.cxe()) {
                    if (i2 >= i) {
                        if (d.this.fDE.a(d.this.isFullScreen(), d.this.OB, "NEWINDEX")) {
                        }
                    } else if (i != 0 && !d.this.OB && (i2 * 100) / i >= 80 && i > 15000) {
                        d.this.aw(d.this.Ki);
                    }
                }
            }
        });
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        this.fDT.setTag(this.Mh);
        MessageManager.getInstance().registerListener(this.fDT);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(bj bjVar) {
        if (bjVar != null) {
            super.setData(bjVar);
            boolean z = this.Ki == bjVar;
            this.Ki = bjVar;
            if (this.fDE != null) {
                if (this.gZZ && z) {
                    this.gZZ = false;
                } else {
                    this.fDE.reset();
                }
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.g.a
    public void onCompletion(g gVar) {
        if (!this.fDE.a(isFullScreen(), this.OB, "NEWINDEX")) {
            zm(this.jtk);
            this.jto |= 1;
            zm(this.jto);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.play.operableVideoView.d
    public void mz(boolean z) {
        super.mz(z);
        if (this.fDE != null) {
            if (z) {
                this.fDE.kM();
            } else {
                this.fDE.kN();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aw(bj bjVar) {
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
        int la = bVar.la();
        int lb = bVar.lb();
        int kZ = bVar.kZ();
        if (kZ != -1) {
            i = la != -1 ? (kZ - la) - 1 : -1;
            if (lb != -1) {
                i4 = (lb - kZ) - 1;
            }
        } else {
            i = -1;
        }
        VideoInfo azV = bjVar.azV();
        if (azV != null) {
            i3 = azV.video_width.intValue();
            i2 = azV.video_height.intValue();
        } else {
            i2 = 0;
            i3 = 0;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("video_vid", bjVar.getId());
        hashMap.put("video_title", bjVar.getTitle());
        hashMap.put("forum_id", String.valueOf(bjVar.getFid()));
        hashMap.put("forum_name", bjVar.azJ());
        hashMap.put("up_distance", String.valueOf(i));
        hashMap.put("down_distance", String.valueOf(i4));
        com.baidu.afd.videopaster.a a = com.baidu.afd.videopaster.c.a(3, 0, "1546854828072", kZ + 1, i3, i2);
        a.j(hashMap);
        return a;
    }

    public void onPause() {
    }

    public void onResume() {
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean my(boolean z) {
        if (this.fDE != null) {
            if (z) {
                if (this.fDE.kE()) {
                    this.haa = false;
                    this.fDE.stop();
                }
            } else if (this.fDE.kE()) {
                this.gZZ = true;
                this.fDE.V(true);
            }
        }
        return super.my(z);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void startPlay() {
        if (this.fDE != null && this.fDE.kE()) {
            this.haa = true;
            this.fDE.resume();
            return;
        }
        super.startPlay();
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void stopPlay() {
        super.stopPlay();
        if (this.fDE != null && this.fDE.kE()) {
            com.baidu.adp.lib.f.e.gy().removeCallbacks(this.hab);
            com.baidu.adp.lib.f.e.gy().post(this.hab);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected int bMz() {
        return 1;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean isPlaying() {
        if (this.fDE == null || !this.fDE.kE()) {
            return super.isPlaying();
        }
        return this.haa || this.fDE.kO();
    }
}
