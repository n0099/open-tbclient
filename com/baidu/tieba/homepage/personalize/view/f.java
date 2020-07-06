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
import com.baidu.tbadk.core.data.bu;
import com.baidu.tieba.play.operableVideoView.d;
import java.util.HashMap;
import tbclient.VideoInfo;
/* loaded from: classes9.dex */
public class f extends com.baidu.tieba.play.operableVideoView.b {
    private bu aeK;
    private com.baidu.afd.videopaster.d gQK;
    private CustomMessageListener gRa;
    private boolean iwb;
    protected boolean iwc;
    private Runnable iwd;

    public f(Context context, View view) {
        super(context, view);
        this.iwb = false;
        this.gRa = new CustomMessageListener(2921395) { // from class: com.baidu.tieba.homepage.personalize.view.f.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.afd.videopaster.data.b bVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.afd.videopaster.data.b) && (bVar = (com.baidu.afd.videopaster.data.b) customResponsedMessage.getData()) != null) {
                    String videoId = bVar.getVideoId();
                    if (!StringUtils.isNull(videoId) && f.this.aeK != null && videoId.equals(f.this.aeK.getId())) {
                        f.this.gQK.a(f.this.a(f.this.aeK, bVar));
                    }
                }
            }
        };
        this.iwd = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.view.f.4
            @Override // java.lang.Runnable
            public void run() {
                if (f.this.gQK != null) {
                    f.this.iwc = false;
                    f.this.gQK.stop();
                    f.this.gQK.onDestroy();
                }
            }
        };
        tO(true);
        ckn();
    }

    protected void ckn() {
        this.gQK = new com.baidu.afd.videopaster.d(this.mContext, (ViewGroup) cUV());
        this.gQK.a(new d.a() { // from class: com.baidu.tieba.homepage.personalize.view.f.1
            @Override // com.baidu.afd.videopaster.d.a
            public void qm() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void ql() {
                f.this.startPlay();
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void qk() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public boolean qn() {
                return false;
            }
        });
        a(new d.a() { // from class: com.baidu.tieba.homepage.personalize.view.f.2
            @Override // com.baidu.tieba.play.operableVideoView.d.a
            public void cp(int i, int i2) {
                if (!f.this.cWu()) {
                    if (i2 >= i) {
                        if (f.this.gQK.a(false, false, "NEWINDEX")) {
                        }
                    } else if (i != 0 && !f.this.ajN && (i2 * 100) / i >= 80 && i > 15000) {
                        f.this.aD(f.this.aeK);
                    }
                }
            }
        });
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        this.gRa.setTag(this.agK);
        MessageManager.getInstance().registerListener(this.gRa);
    }

    @Override // com.baidu.tieba.play.operableVideoView.b, com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(bu buVar) {
        if (buVar != null) {
            super.setData(buVar);
            boolean z = this.aeK == buVar;
            this.aeK = buVar;
            if (this.gQK != null) {
                if (this.iwb && z) {
                    this.iwb = false;
                } else {
                    this.gQK.reset();
                }
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.b, com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.g.a
    public void onCompletion(com.baidu.tieba.play.g gVar) {
        if (!this.gQK.a(false, false, "NEWINDEX")) {
            startPlay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aD(bu buVar) {
        if (buVar != null && buVar.getId() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921394, buVar.getId()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.afd.videopaster.a a(bu buVar, com.baidu.afd.videopaster.data.b bVar) {
        int i;
        int i2;
        int i3;
        int i4 = -1;
        if (buVar == null || bVar == null) {
            return null;
        }
        int qr = bVar.qr();
        int qs = bVar.qs();
        int qq = bVar.qq();
        if (qq != -1) {
            i = qr != -1 ? (qq - qr) - 1 : -1;
            if (qs != -1) {
                i4 = (qs - qq) - 1;
            }
        } else {
            i = -1;
        }
        VideoInfo aSH = buVar.aSH();
        if (aSH != null) {
            i3 = aSH.video_width.intValue();
            i2 = aSH.video_height.intValue();
        } else {
            i2 = 0;
            i3 = 0;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("video_vid", buVar.getId());
        hashMap.put("video_title", buVar.getTitle());
        hashMap.put("forum_id", String.valueOf(buVar.getFid()));
        hashMap.put("forum_name", buVar.aSt());
        hashMap.put("up_distance", String.valueOf(i));
        hashMap.put("down_distance", String.valueOf(i4));
        com.baidu.afd.videopaster.a a = com.baidu.afd.videopaster.c.a(3, 0, "1546854828072", qq + 1, i3, i2);
        a.w(hashMap);
        return a;
    }

    public void onPause() {
    }

    public void onResume() {
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean oC(boolean z) {
        if (this.gQK != null) {
            if (z) {
                if (this.gQK.pV()) {
                    this.iwc = false;
                    this.gQK.stop();
                }
            } else if (this.gQK.pV()) {
                this.iwb = true;
                this.gQK.aA(true);
            }
        }
        return super.oC(z);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void startPlay() {
        if (this.gQK != null && this.gQK.pV()) {
            this.iwc = true;
            this.gQK.resume();
            return;
        }
        super.startPlay();
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void stopPlay() {
        super.stopPlay();
        if (this.gQK != null && this.gQK.pV()) {
            com.baidu.adp.lib.f.e.lt().removeCallbacks(this.iwd);
            com.baidu.adp.lib.f.e.lt().post(this.iwd);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected int cko() {
        return 1;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean isPlaying() {
        if (this.gQK == null || !this.gQK.pV()) {
            return super.isPlaying();
        }
        return this.iwc || this.gQK.qf();
    }
}
