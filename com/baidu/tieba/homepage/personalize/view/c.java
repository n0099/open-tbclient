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
import com.baidu.tbadk.core.data.cb;
import com.baidu.tieba.play.operableVideoView.d;
import java.util.HashMap;
import tbclient.VideoInfo;
/* loaded from: classes2.dex */
public class c extends com.baidu.tieba.play.operableVideoView.b {
    private cb ahi;
    private CustomMessageListener iwK;
    private com.baidu.afd.videopaster.d iwv;
    private boolean kmm;
    protected boolean kmn;
    private Runnable kmo;

    public c(Context context, View view) {
        super(context, view);
        this.kmm = false;
        this.iwK = new CustomMessageListener(2921395) { // from class: com.baidu.tieba.homepage.personalize.view.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.afd.videopaster.data.b bVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.afd.videopaster.data.b) && (bVar = (com.baidu.afd.videopaster.data.b) customResponsedMessage.getData()) != null) {
                    String videoId = bVar.getVideoId();
                    if (!StringUtils.isNull(videoId) && c.this.ahi != null && videoId.equals(c.this.ahi.getId())) {
                        c.this.iwv.a(c.this.a(c.this.ahi, bVar));
                    }
                }
            }
        };
        this.kmo = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.view.c.4
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.iwv != null) {
                    c.this.kmn = false;
                    c.this.iwv.stop();
                    c.this.iwv.onDestroy();
                }
            }
        };
        xr(true);
        cRP();
    }

    protected void cRP() {
        this.iwv = new com.baidu.afd.videopaster.d(this.mContext, (ViewGroup) dzP());
        this.iwv.a(new d.a() { // from class: com.baidu.tieba.homepage.personalize.view.c.1
            @Override // com.baidu.afd.videopaster.d.a
            public void rs() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void rr() {
                c.this.startPlay();
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void rq() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public boolean rt() {
                return false;
            }
        });
        a(new d.a() { // from class: com.baidu.tieba.homepage.personalize.view.c.2
            @Override // com.baidu.tieba.play.operableVideoView.d.a
            public void cG(int i, int i2) {
                if (!c.this.dAO()) {
                    if (i2 >= i) {
                        if (c.this.iwv.d(false, false, "NEWINDEX")) {
                        }
                    } else if (i != 0 && !c.this.amB && (i2 * 100) / i >= 80 && i > 15000) {
                        c.this.aG(c.this.ahi);
                    }
                }
            }
        });
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        this.iwK.setTag(this.agC);
        MessageManager.getInstance().registerListener(this.iwK);
    }

    @Override // com.baidu.tieba.play.operableVideoView.b, com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(cb cbVar) {
        if (cbVar != null) {
            super.setData(cbVar);
            boolean z = this.ahi == cbVar;
            this.ahi = cbVar;
            if (this.iwv != null) {
                if (this.kmm && z) {
                    this.kmm = false;
                } else {
                    this.iwv.reset();
                }
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.b, com.baidu.tieba.play.operableVideoView.d, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        if (!this.iwv.d(false, false, "NEWINDEX")) {
            startPlay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aG(cb cbVar) {
        if (cbVar != null && cbVar.getId() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921394, cbVar.getId()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.afd.videopaster.a a(cb cbVar, com.baidu.afd.videopaster.data.b bVar) {
        int i;
        int i2;
        int i3;
        int i4;
        if (cbVar == null || bVar == null) {
            return null;
        }
        int rx2 = bVar.rx();
        int ry = bVar.ry();
        int rw = bVar.rw();
        if (rw != -1) {
            i2 = rx2 != -1 ? (rw - rx2) - 1 : -1;
            i = ry != -1 ? (ry - rw) - 1 : -1;
        } else {
            i = -1;
            i2 = -1;
        }
        VideoInfo boh = cbVar.boh();
        if (boh != null) {
            i4 = boh.video_width.intValue();
            i3 = boh.video_height.intValue();
        } else {
            i3 = 0;
            i4 = 0;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("video_vid", cbVar.getId());
        hashMap.put("video_title", cbVar.getTitle());
        hashMap.put("forum_id", String.valueOf(cbVar.getFid()));
        hashMap.put("forum_name", cbVar.bnU());
        hashMap.put("up_distance", String.valueOf(i2));
        hashMap.put("down_distance", String.valueOf(i));
        com.baidu.afd.videopaster.a a2 = com.baidu.afd.videopaster.c.a(3, 0, "1546854828072", rw + 1, i4, i3);
        a2.u(hashMap);
        return a2;
    }

    public void onPause() {
    }

    public void onResume() {
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean sp(boolean z) {
        if (this.iwv != null) {
            if (z) {
                if (this.iwv.rc()) {
                    this.kmn = false;
                    this.iwv.stop();
                }
            } else if (this.iwv.rc()) {
                this.kmm = true;
                this.iwv.az(true);
            }
        }
        return super.sp(z);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void startPlay() {
        if (this.iwv != null && this.iwv.rc()) {
            this.kmn = true;
            this.iwv.resume();
            return;
        }
        super.startPlay();
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void stopPlay() {
        super.stopPlay();
        if (this.iwv != null && this.iwv.rc()) {
            e.mA().removeCallbacks(this.kmo);
            e.mA().post(this.kmo);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected int cRQ() {
        return 1;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean isPlaying() {
        if (this.iwv == null || !this.iwv.rc()) {
            return super.isPlaying();
        }
        return this.kmn || this.iwv.rl();
    }
}
