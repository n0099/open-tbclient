package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.g.e;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.afd.videopaster.d;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.operableVideoView.c;
import java.util.HashMap;
import tbclient.VideoInfo;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.play.operableVideoView.b {
    private bg XS;
    private CustomMessageListener ehK;
    private com.baidu.afd.videopaster.d ehu;
    private boolean fNL;
    protected boolean fNM;
    private Runnable fNN;

    public c(Context context, View view) {
        super(context, view);
        this.fNL = false;
        this.ehK = new CustomMessageListener(2921395) { // from class: com.baidu.tieba.homepage.personalize.view.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.afd.videopaster.data.b bVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.afd.videopaster.data.b) && (bVar = (com.baidu.afd.videopaster.data.b) customResponsedMessage.getData()) != null) {
                    String videoId = bVar.getVideoId();
                    if (!StringUtils.isNull(videoId) && c.this.XS != null && videoId.equals(c.this.XS.getId())) {
                        c.this.ehu.a(c.this.a(c.this.XS, bVar));
                    }
                }
            }
        };
        this.fNN = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.view.c.4
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.ehu != null) {
                    c.this.fNM = false;
                    c.this.ehu.stop();
                }
            }
        };
        pe(true);
        bmW();
    }

    protected void bmW() {
        this.ehu = new com.baidu.afd.videopaster.d(this.mContext, (ViewGroup) bSV());
        this.ehu.a(new d.a() { // from class: com.baidu.tieba.homepage.personalize.view.c.1
            @Override // com.baidu.afd.videopaster.d.a
            public void qs() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void qr() {
                c.this.startPlay();
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void qq() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public boolean qt() {
                return false;
            }
        });
        a(new c.a() { // from class: com.baidu.tieba.homepage.personalize.view.c.2
            @Override // com.baidu.tieba.play.operableVideoView.c.a
            public void bx(int i, int i2) {
                if (!c.this.bUj()) {
                    if (i2 >= i) {
                        if (c.this.ehu.a(false, false, "NEWINDEX")) {
                        }
                    } else if (i != 0 && !c.this.hZA && (i2 * 100) / i >= 80 && i > 15000) {
                        c.this.as(c.this.XS);
                    }
                }
            }
        });
        this.ehK.setTag(this.Zr);
        MessageManager.getInstance().registerListener(this.ehK);
    }

    @Override // com.baidu.tieba.play.operableVideoView.b, com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.operableVideoView.a
    public void setData(bg bgVar) {
        if (bgVar != null) {
            super.setData(bgVar);
            boolean z = this.XS == bgVar;
            this.XS = bgVar;
            if (this.ehu != null) {
                if (this.fNL && z) {
                    this.fNL = false;
                } else {
                    this.ehu.reset();
                }
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.b, com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.g.a
    public void onCompletion(g gVar) {
        if (!this.ehu.a(false, false, "NEWINDEX")) {
            startPlay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void as(bg bgVar) {
        if (bgVar != null && bgVar.getId() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921394, bgVar.getId()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.afd.videopaster.a a(bg bgVar, com.baidu.afd.videopaster.data.b bVar) {
        int i;
        int i2;
        int i3;
        int i4 = -1;
        if (bgVar == null || bVar == null) {
            return null;
        }
        int qx = bVar.qx();
        int qy = bVar.qy();
        int qw = bVar.qw();
        if (qw != -1) {
            i = qx != -1 ? (qw - qx) - 1 : -1;
            if (qy != -1) {
                i4 = (qy - qw) - 1;
            }
        } else {
            i = -1;
        }
        VideoInfo Zf = bgVar.Zf();
        if (Zf != null) {
            i3 = Zf.video_width.intValue();
            i2 = Zf.video_height.intValue();
        } else {
            i2 = 0;
            i3 = 0;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("video_vid", bgVar.getId());
        hashMap.put("video_title", bgVar.getTitle());
        hashMap.put("forum_id", String.valueOf(bgVar.getFid()));
        hashMap.put("forum_name", bgVar.YT());
        hashMap.put("up_distance", String.valueOf(i));
        hashMap.put("down_distance", String.valueOf(i4));
        com.baidu.afd.videopaster.a a = com.baidu.afd.videopaster.c.a(3, 0, "1546854828072", qw + 1, i3, i2);
        a.l(hashMap);
        return a;
    }

    public void onPause() {
    }

    public void onResume() {
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.operableVideoView.a
    public boolean kr(boolean z) {
        if (this.ehu != null) {
            if (z) {
                if (this.ehu.qb()) {
                    this.fNM = false;
                    this.ehu.stop();
                }
            } else if (this.ehu.qb()) {
                this.fNL = true;
                this.ehu.aC(true);
            }
        }
        return super.kr(z);
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.operableVideoView.a
    public void startPlay() {
        if (this.ehu != null && this.ehu.qb()) {
            this.fNM = true;
            this.ehu.resume();
            return;
        }
        super.startPlay();
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.operableVideoView.a
    public void stopPlay() {
        super.stopPlay();
        if (this.ehu != null && this.ehu.qb()) {
            e.jH().removeCallbacks(this.fNN);
            e.jH().post(this.fNN);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.c
    protected int bmX() {
        return 1;
    }

    @Override // com.baidu.tieba.play.operableVideoView.c, com.baidu.tieba.play.operableVideoView.a
    public boolean isPlaying() {
        if (this.ehu == null || !this.ehu.qb()) {
            return super.isPlaying();
        }
        return this.fNM || this.ehu.ql();
    }
}
