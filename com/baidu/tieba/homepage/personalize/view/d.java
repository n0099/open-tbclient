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
import com.baidu.tbadk.core.data.by;
import com.baidu.tieba.play.operableVideoView.d;
import java.util.HashMap;
import tbclient.VideoInfo;
/* loaded from: classes22.dex */
public class d extends com.baidu.tieba.play.operableVideoView.b {
    private by ahA;
    private com.baidu.afd.videopaster.d ijb;
    private CustomMessageListener ijq;
    private boolean jVw;
    protected boolean jVx;
    private Runnable jVy;

    public d(Context context, View view) {
        super(context, view);
        this.jVw = false;
        this.ijq = new CustomMessageListener(2921395) { // from class: com.baidu.tieba.homepage.personalize.view.d.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.afd.videopaster.data.b bVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.afd.videopaster.data.b) && (bVar = (com.baidu.afd.videopaster.data.b) customResponsedMessage.getData()) != null) {
                    String videoId = bVar.getVideoId();
                    if (!StringUtils.isNull(videoId) && d.this.ahA != null && videoId.equals(d.this.ahA.getId())) {
                        d.this.ijb.a(d.this.a(d.this.ahA, bVar));
                    }
                }
            }
        };
        this.jVy = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.view.d.4
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.ijb != null) {
                    d.this.jVx = false;
                    d.this.ijb.stop();
                    d.this.ijb.onDestroy();
                }
            }
        };
        xc(true);
        cQA();
    }

    protected void cQA() {
        this.ijb = new com.baidu.afd.videopaster.d(this.mContext, (ViewGroup) dBH());
        this.ijb.a(new d.a() { // from class: com.baidu.tieba.homepage.personalize.view.d.1
            @Override // com.baidu.afd.videopaster.d.a
            public void rT() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void rS() {
                d.this.startPlay();
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void rR() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public boolean rU() {
                return false;
            }
        });
        a(new d.a() { // from class: com.baidu.tieba.homepage.personalize.view.d.2
            @Override // com.baidu.tieba.play.operableVideoView.d.a
            public void cM(int i, int i2) {
                if (!d.this.dCF()) {
                    if (i2 >= i) {
                        if (d.this.ijb.a(false, false, "NEWINDEX")) {
                        }
                    } else if (i != 0 && !d.this.amX && (i2 * 100) / i >= 80 && i > 15000) {
                        d.this.aE(d.this.ahA);
                    }
                }
            }
        });
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        this.ijq.setTag(this.ajD);
        MessageManager.getInstance().registerListener(this.ijq);
    }

    @Override // com.baidu.tieba.play.operableVideoView.b, com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(by byVar) {
        if (byVar != null) {
            super.setData(byVar);
            boolean z = this.ahA == byVar;
            this.ahA = byVar;
            if (this.ijb != null) {
                if (this.jVw && z) {
                    this.jVw = false;
                } else {
                    this.ijb.reset();
                }
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.b, com.baidu.tieba.play.operableVideoView.d, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        if (!this.ijb.a(false, false, "NEWINDEX")) {
            startPlay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aE(by byVar) {
        if (byVar != null && byVar.getId() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921394, byVar.getId()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.afd.videopaster.a a(by byVar, com.baidu.afd.videopaster.data.b bVar) {
        int i;
        int i2;
        int i3;
        int i4 = -1;
        if (byVar == null || bVar == null) {
            return null;
        }
        int rY = bVar.rY();
        int rZ = bVar.rZ();
        int rX = bVar.rX();
        if (rX != -1) {
            i = rY != -1 ? (rX - rY) - 1 : -1;
            if (rZ != -1) {
                i4 = (rZ - rX) - 1;
            }
        } else {
            i = -1;
        }
        VideoInfo bph = byVar.bph();
        if (bph != null) {
            i3 = bph.video_width.intValue();
            i2 = bph.video_height.intValue();
        } else {
            i2 = 0;
            i3 = 0;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("video_vid", byVar.getId());
        hashMap.put("video_title", byVar.getTitle());
        hashMap.put("forum_id", String.valueOf(byVar.getFid()));
        hashMap.put("forum_name", byVar.boT());
        hashMap.put("up_distance", String.valueOf(i));
        hashMap.put("down_distance", String.valueOf(i4));
        com.baidu.afd.videopaster.a a2 = com.baidu.afd.videopaster.c.a(3, 0, "1546854828072", rX + 1, i3, i2);
        a2.u(hashMap);
        return a2;
    }

    public void onPause() {
    }

    public void onResume() {
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean rJ(boolean z) {
        if (this.ijb != null) {
            if (z) {
                if (this.ijb.rC()) {
                    this.jVx = false;
                    this.ijb.stop();
                }
            } else if (this.ijb.rC()) {
                this.jVw = true;
                this.ijb.aA(true);
            }
        }
        return super.rJ(z);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void startPlay() {
        if (this.ijb != null && this.ijb.rC()) {
            this.jVx = true;
            this.ijb.resume();
            return;
        }
        super.startPlay();
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void stopPlay() {
        super.stopPlay();
        if (this.ijb != null && this.ijb.rC()) {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jVy);
            com.baidu.adp.lib.f.e.mY().post(this.jVy);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected int cQB() {
        return 1;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean isPlaying() {
        if (this.ijb == null || !this.ijb.rC()) {
            return super.isPlaying();
        }
        return this.jVx || this.ijb.rM();
    }
}
