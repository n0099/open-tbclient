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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tieba.play.operableVideoView.d;
import java.util.HashMap;
import tbclient.VideoInfo;
/* loaded from: classes16.dex */
public class f extends com.baidu.tieba.play.operableVideoView.b {
    private bv aeA;
    private CustomMessageListener gWF;
    private com.baidu.afd.videopaster.d gWq;
    private boolean iCh;
    protected boolean iCi;
    private Runnable iCj;

    public f(Context context, View view) {
        super(context, view);
        this.iCh = false;
        this.gWF = new CustomMessageListener(2921395) { // from class: com.baidu.tieba.homepage.personalize.view.f.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.afd.videopaster.data.b bVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.afd.videopaster.data.b) && (bVar = (com.baidu.afd.videopaster.data.b) customResponsedMessage.getData()) != null) {
                    String videoId = bVar.getVideoId();
                    if (!StringUtils.isNull(videoId) && f.this.aeA != null && videoId.equals(f.this.aeA.getId())) {
                        f.this.gWq.a(f.this.a(f.this.aeA, bVar));
                    }
                }
            }
        };
        this.iCj = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.view.f.4
            @Override // java.lang.Runnable
            public void run() {
                if (f.this.gWq != null) {
                    f.this.iCi = false;
                    f.this.gWq.stop();
                    f.this.gWq.onDestroy();
                }
            }
        };
        us(true);
        cnO();
    }

    protected void cnO() {
        this.gWq = new com.baidu.afd.videopaster.d(this.mContext, (ViewGroup) cYJ());
        this.gWq.a(new d.a() { // from class: com.baidu.tieba.homepage.personalize.view.f.1
            @Override // com.baidu.afd.videopaster.d.a
            public void qn() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void qm() {
                f.this.startPlay();
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void ql() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public boolean qo() {
                return false;
            }
        });
        a(new d.a() { // from class: com.baidu.tieba.homepage.personalize.view.f.2
            @Override // com.baidu.tieba.play.operableVideoView.d.a
            public void cs(int i, int i2) {
                if (!f.this.cZG()) {
                    if (i2 >= i) {
                        if (f.this.gWq.a(false, false, "NEWINDEX")) {
                        }
                    } else if (i != 0 && !f.this.ajI && (i2 * 100) / i >= 80 && i > 15000) {
                        f.this.aA(f.this.aeA);
                    }
                }
            }
        });
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        this.gWF.setTag(this.agB);
        MessageManager.getInstance().registerListener(this.gWF);
    }

    @Override // com.baidu.tieba.play.operableVideoView.b, com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(bv bvVar) {
        if (bvVar != null) {
            super.setData(bvVar);
            boolean z = this.aeA == bvVar;
            this.aeA = bvVar;
            if (this.gWq != null) {
                if (this.iCh && z) {
                    this.iCh = false;
                } else {
                    this.gWq.reset();
                }
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.b, com.baidu.tieba.play.operableVideoView.d, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        if (!this.gWq.a(false, false, "NEWINDEX")) {
            startPlay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aA(bv bvVar) {
        if (bvVar != null && bvVar.getId() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921394, bvVar.getId()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.afd.videopaster.a a(bv bvVar, com.baidu.afd.videopaster.data.b bVar) {
        int i;
        int i2;
        int i3;
        int i4 = -1;
        if (bvVar == null || bVar == null) {
            return null;
        }
        int qs = bVar.qs();
        int qt = bVar.qt();
        int qr = bVar.qr();
        if (qr != -1) {
            i = qs != -1 ? (qr - qs) - 1 : -1;
            if (qt != -1) {
                i4 = (qt - qr) - 1;
            }
        } else {
            i = -1;
        }
        VideoInfo aWD = bvVar.aWD();
        if (aWD != null) {
            i3 = aWD.video_width.intValue();
            i2 = aWD.video_height.intValue();
        } else {
            i2 = 0;
            i3 = 0;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("video_vid", bvVar.getId());
        hashMap.put("video_title", bvVar.getTitle());
        hashMap.put("forum_id", String.valueOf(bvVar.getFid()));
        hashMap.put("forum_name", bvVar.aWp());
        hashMap.put("up_distance", String.valueOf(i));
        hashMap.put("down_distance", String.valueOf(i4));
        com.baidu.afd.videopaster.a a = com.baidu.afd.videopaster.c.a(3, 0, "1546854828072", qr + 1, i3, i2);
        a.w(hashMap);
        return a;
    }

    public void onPause() {
    }

    public void onResume() {
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean ph(boolean z) {
        if (this.gWq != null) {
            if (z) {
                if (this.gWq.pW()) {
                    this.iCi = false;
                    this.gWq.stop();
                }
            } else if (this.gWq.pW()) {
                this.iCh = true;
                this.gWq.aA(true);
            }
        }
        return super.ph(z);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void startPlay() {
        if (this.gWq != null && this.gWq.pW()) {
            this.iCi = true;
            this.gWq.resume();
            return;
        }
        super.startPlay();
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void stopPlay() {
        super.stopPlay();
        if (this.gWq != null && this.gWq.pW()) {
            com.baidu.adp.lib.f.e.lt().removeCallbacks(this.iCj);
            com.baidu.adp.lib.f.e.lt().post(this.iCj);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected int cnP() {
        return 1;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean isPlaying() {
        if (this.gWq == null || !this.gWq.pW()) {
            return super.isPlaying();
        }
        return this.iCi || this.gWq.qg();
    }
}
