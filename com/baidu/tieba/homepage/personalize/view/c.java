package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.afd.videopaster.d;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tieba.play.operableVideoView.d;
import java.util.HashMap;
import tbclient.VideoInfo;
/* loaded from: classes2.dex */
public class c extends com.baidu.tieba.play.operableVideoView.b {
    private bz ahu;
    private com.baidu.afd.videopaster.d iqR;
    private CustomMessageListener irg;
    private boolean ked;
    protected boolean kee;
    private Runnable kef;

    public c(Context context, View view) {
        super(context, view);
        this.ked = false;
        this.irg = new CustomMessageListener(2921395) { // from class: com.baidu.tieba.homepage.personalize.view.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.afd.videopaster.data.b bVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.afd.videopaster.data.b) && (bVar = (com.baidu.afd.videopaster.data.b) customResponsedMessage.getData()) != null) {
                    String videoId = bVar.getVideoId();
                    if (!StringUtils.isNull(videoId) && c.this.ahu != null && videoId.equals(c.this.ahu.getId())) {
                        c.this.iqR.a(c.this.a(c.this.ahu, bVar));
                    }
                }
            }
        };
        this.kef = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.view.c.4
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.iqR != null) {
                    c.this.kee = false;
                    c.this.iqR.stop();
                    c.this.iqR.onDestroy();
                }
            }
        };
        wZ(true);
        cPQ();
    }

    protected void cPQ() {
        this.iqR = new com.baidu.afd.videopaster.d(this.mContext, (ViewGroup) dxG());
        this.iqR.a(new d.a() { // from class: com.baidu.tieba.homepage.personalize.view.c.1
            @Override // com.baidu.afd.videopaster.d.a
            public void ru() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void rt() {
                c.this.startPlay();
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void rs() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public boolean rv() {
                return false;
            }
        });
        a(new d.a() { // from class: com.baidu.tieba.homepage.personalize.view.c.2
            @Override // com.baidu.tieba.play.operableVideoView.d.a
            public void cJ(int i, int i2) {
                if (!c.this.dyE()) {
                    if (i2 >= i) {
                        if (c.this.iqR.d(false, false, "NEWINDEX")) {
                        }
                    } else if (i != 0 && !c.this.amL && (i2 * 100) / i >= 80 && i > 15000) {
                        c.this.aF(c.this.ahu);
                    }
                }
            }
        });
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        this.irg.setTag(this.agN);
        MessageManager.getInstance().registerListener(this.irg);
    }

    @Override // com.baidu.tieba.play.operableVideoView.b, com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(bz bzVar) {
        if (bzVar != null) {
            super.setData(bzVar);
            boolean z = this.ahu == bzVar;
            this.ahu = bzVar;
            if (this.iqR != null) {
                if (this.ked && z) {
                    this.ked = false;
                } else {
                    this.iqR.reset();
                }
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.b, com.baidu.tieba.play.operableVideoView.d, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        if (!this.iqR.d(false, false, "NEWINDEX")) {
            startPlay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aF(bz bzVar) {
        if (bzVar != null && bzVar.getId() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921394, bzVar.getId()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.afd.videopaster.a a(bz bzVar, com.baidu.afd.videopaster.data.b bVar) {
        int i;
        int i2;
        int i3;
        int i4;
        if (bzVar == null || bVar == null) {
            return null;
        }
        int rz = bVar.rz();
        int rA = bVar.rA();
        int ry = bVar.ry();
        if (ry != -1) {
            i2 = rz != -1 ? (ry - rz) - 1 : -1;
            i = rA != -1 ? (rA - ry) - 1 : -1;
        } else {
            i = -1;
            i2 = -1;
        }
        VideoInfo bnO = bzVar.bnO();
        if (bnO != null) {
            i4 = bnO.video_width.intValue();
            i3 = bnO.video_height.intValue();
        } else {
            i3 = 0;
            i4 = 0;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("video_vid", bzVar.getId());
        hashMap.put("video_title", bzVar.getTitle());
        hashMap.put("forum_id", String.valueOf(bzVar.getFid()));
        hashMap.put("forum_name", bzVar.bnB());
        hashMap.put("up_distance", String.valueOf(i2));
        hashMap.put("down_distance", String.valueOf(i));
        com.baidu.afd.videopaster.a a2 = com.baidu.afd.videopaster.c.a(3, 0, "1546854828072", ry + 1, i4, i3);
        a2.u(hashMap);
        return a2;
    }

    public void onPause() {
    }

    public void onResume() {
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean sc(boolean z) {
        if (this.iqR != null) {
            if (z) {
                if (this.iqR.re()) {
                    this.kee = false;
                    this.iqR.stop();
                }
            } else if (this.iqR.re()) {
                this.ked = true;
                this.iqR.az(true);
            }
        }
        return super.sc(z);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void startPlay() {
        if (this.iqR != null && this.iqR.re()) {
            this.kee = true;
            this.iqR.resume();
            return;
        }
        super.startPlay();
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void stopPlay() {
        super.stopPlay();
        if (this.iqR != null && this.iqR.re()) {
            e.mB().removeCallbacks(this.kef);
            e.mB().post(this.kef);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected int cPR() {
        return 1;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean isPlaying() {
        if (this.iqR == null || !this.iqR.re()) {
            return super.isPlaying();
        }
        return this.kee || this.iqR.rn();
    }
}
