package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.afd.videopaster.d;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.operableVideoView.c;
import java.util.HashMap;
import tbclient.VideoInfo;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.play.operableVideoView.b {
    private bh Fs;
    private com.baidu.afd.videopaster.d eLO;
    private CustomMessageListener eMd;
    private boolean gmx;
    protected boolean gmy;
    private Runnable gmz;

    public c(Context context, View view) {
        super(context, view);
        this.gmx = false;
        this.eMd = new CustomMessageListener(2921395) { // from class: com.baidu.tieba.homepage.personalize.view.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.afd.videopaster.data.b bVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.afd.videopaster.data.b) && (bVar = (com.baidu.afd.videopaster.data.b) customResponsedMessage.getData()) != null) {
                    String videoId = bVar.getVideoId();
                    if (!StringUtils.isNull(videoId) && c.this.Fs != null && videoId.equals(c.this.Fs.getId())) {
                        c.this.eLO.a(c.this.a(c.this.Fs, bVar));
                    }
                }
            }
        };
        this.gmz = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.view.c.4
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.eLO != null) {
                    c.this.gmy = false;
                    c.this.eLO.stop();
                }
            }
        };
        pS(true);
        bvk();
    }

    protected void bvk() {
        this.eLO = new com.baidu.afd.videopaster.d(this.mContext, (ViewGroup) cbV());
        this.eLO.a(new d.a() { // from class: com.baidu.tieba.homepage.personalize.view.c.1
            @Override // com.baidu.afd.videopaster.d.a
            public void kE() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void kD() {
                c.this.startPlay();
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void kC() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public boolean kF() {
                return false;
            }
        });
        a(new c.a() { // from class: com.baidu.tieba.homepage.personalize.view.c.2
            @Override // com.baidu.tieba.play.operableVideoView.c.a
            public void bE(int i, int i2) {
                if (!c.this.cdi()) {
                    if (i2 >= i) {
                        if (c.this.eLO.a(false, false, "NEWINDEX")) {
                        }
                    } else if (i != 0 && !c.this.izD && (i2 * 100) / i >= 80 && i > 15000) {
                        c.this.aq(c.this.Fs);
                    }
                }
            }
        });
        this.eMd.setTag(this.GX);
        MessageManager.getInstance().registerListener(this.eMd);
    }

    @Override // com.baidu.tieba.play.operableVideoView.b, com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.operableVideoView.a
    public void setData(bh bhVar) {
        if (bhVar != null) {
            super.setData(bhVar);
            boolean z = this.Fs == bhVar;
            this.Fs = bhVar;
            if (this.eLO != null) {
                if (this.gmx && z) {
                    this.gmx = false;
                } else {
                    this.eLO.reset();
                }
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.b, com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.g.a
    public void onCompletion(g gVar) {
        if (!this.eLO.a(false, false, "NEWINDEX")) {
            startPlay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aq(bh bhVar) {
        if (bhVar != null && bhVar.getId() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921394, bhVar.getId()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.afd.videopaster.a a(bh bhVar, com.baidu.afd.videopaster.data.b bVar) {
        int i;
        int i2;
        int i3;
        int i4 = -1;
        if (bhVar == null || bVar == null) {
            return null;
        }
        int kJ = bVar.kJ();
        int kK = bVar.kK();
        int kI = bVar.kI();
        if (kI != -1) {
            i = kJ != -1 ? (kI - kJ) - 1 : -1;
            if (kK != -1) {
                i4 = (kK - kI) - 1;
            }
        } else {
            i = -1;
        }
        VideoInfo aiV = bhVar.aiV();
        if (aiV != null) {
            i3 = aiV.video_width.intValue();
            i2 = aiV.video_height.intValue();
        } else {
            i2 = 0;
            i3 = 0;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("video_vid", bhVar.getId());
        hashMap.put("video_title", bhVar.getTitle());
        hashMap.put("forum_id", String.valueOf(bhVar.getFid()));
        hashMap.put("forum_name", bhVar.aiJ());
        hashMap.put("up_distance", String.valueOf(i));
        hashMap.put("down_distance", String.valueOf(i4));
        com.baidu.afd.videopaster.a a = com.baidu.afd.videopaster.c.a(3, 0, "1546854828072", kI + 1, i3, i2);
        a.k(hashMap);
        return a;
    }

    public void onPause() {
    }

    public void onResume() {
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.operableVideoView.a
    public boolean ll(boolean z) {
        if (this.eLO != null) {
            if (z) {
                if (this.eLO.kn()) {
                    this.gmy = false;
                    this.eLO.stop();
                }
            } else if (this.eLO.kn()) {
                this.gmx = true;
                this.eLO.Q(true);
            }
        }
        return super.ll(z);
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.operableVideoView.a
    public void startPlay() {
        if (this.eLO != null && this.eLO.kn()) {
            this.gmy = true;
            this.eLO.resume();
            return;
        }
        super.startPlay();
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.operableVideoView.a
    public void stopPlay() {
        super.stopPlay();
        if (this.eLO != null && this.eLO.kn()) {
            com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.gmz);
            com.baidu.adp.lib.g.e.fZ().post(this.gmz);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.c
    protected int bvl() {
        return 1;
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.operableVideoView.a
    public boolean isPlaying() {
        if (this.eLO == null || !this.eLO.kn()) {
            return super.isPlaying();
        }
        return this.gmy || this.eLO.kx();
    }
}
