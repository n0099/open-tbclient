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
/* loaded from: classes7.dex */
public class c extends com.baidu.tieba.play.operableVideoView.b {
    private bj Kn;
    private com.baidu.afd.videopaster.d fGO;
    private CustomMessageListener fHd;
    private boolean hdB;
    protected boolean hdC;
    private Runnable hdD;

    public c(Context context, View view) {
        super(context, view);
        this.hdB = false;
        this.fHd = new CustomMessageListener(2921395) { // from class: com.baidu.tieba.homepage.personalize.view.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.afd.videopaster.data.b bVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.afd.videopaster.data.b) && (bVar = (com.baidu.afd.videopaster.data.b) customResponsedMessage.getData()) != null) {
                    String videoId = bVar.getVideoId();
                    if (!StringUtils.isNull(videoId) && c.this.Kn != null && videoId.equals(c.this.Kn.getId())) {
                        c.this.fGO.a(c.this.a(c.this.Kn, bVar));
                    }
                }
            }
        };
        this.hdD = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.view.c.4
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.fGO != null) {
                    c.this.hdC = false;
                    c.this.fGO.stop();
                    c.this.fGO.onDestroy();
                }
            }
        };
        rO(true);
        bNG();
    }

    protected void bNG() {
        this.fGO = new com.baidu.afd.videopaster.d(this.mContext, (ViewGroup) cwU());
        this.fGO.a(new d.a() { // from class: com.baidu.tieba.homepage.personalize.view.c.1
            @Override // com.baidu.afd.videopaster.d.a
            public void kW() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void kV() {
                c.this.startPlay();
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void kU() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public boolean kX() {
                return false;
            }
        });
        a(new d.a() { // from class: com.baidu.tieba.homepage.personalize.view.c.2
            @Override // com.baidu.tieba.play.operableVideoView.d.a
            public void bW(int i, int i2) {
                if (!c.this.cyl()) {
                    if (i2 >= i) {
                        if (c.this.fGO.a(false, false, "NEWINDEX")) {
                        }
                    } else if (i != 0 && !c.this.OF && (i2 * 100) / i >= 80 && i > 15000) {
                        c.this.ax(c.this.Kn);
                    }
                }
            }
        });
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        this.fHd.setTag(this.Mm);
        MessageManager.getInstance().registerListener(this.fHd);
    }

    @Override // com.baidu.tieba.play.operableVideoView.b, com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(bj bjVar) {
        if (bjVar != null) {
            super.setData(bjVar);
            boolean z = this.Kn == bjVar;
            this.Kn = bjVar;
            if (this.fGO != null) {
                if (this.hdB && z) {
                    this.hdB = false;
                } else {
                    this.fGO.reset();
                }
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.b, com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.g.a
    public void onCompletion(g gVar) {
        if (!this.fGO.a(false, false, "NEWINDEX")) {
            startPlay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ax(bj bjVar) {
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
        int lb = bVar.lb();
        int lc = bVar.lc();
        int la = bVar.la();
        if (la != -1) {
            i = lb != -1 ? (la - lb) - 1 : -1;
            if (lc != -1) {
                i4 = (lc - la) - 1;
            }
        } else {
            i = -1;
        }
        VideoInfo aAo = bjVar.aAo();
        if (aAo != null) {
            i3 = aAo.video_width.intValue();
            i2 = aAo.video_height.intValue();
        } else {
            i2 = 0;
            i3 = 0;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("video_vid", bjVar.getId());
        hashMap.put("video_title", bjVar.getTitle());
        hashMap.put("forum_id", String.valueOf(bjVar.getFid()));
        hashMap.put("forum_name", bjVar.aAc());
        hashMap.put("up_distance", String.valueOf(i));
        hashMap.put("down_distance", String.valueOf(i4));
        com.baidu.afd.videopaster.a a = com.baidu.afd.videopaster.c.a(3, 0, "1546854828072", la + 1, i3, i2);
        a.j(hashMap);
        return a;
    }

    public void onPause() {
    }

    public void onResume() {
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean mJ(boolean z) {
        if (this.fGO != null) {
            if (z) {
                if (this.fGO.kF()) {
                    this.hdC = false;
                    this.fGO.stop();
                }
            } else if (this.fGO.kF()) {
                this.hdB = true;
                this.fGO.V(true);
            }
        }
        return super.mJ(z);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void startPlay() {
        if (this.fGO != null && this.fGO.kF()) {
            this.hdC = true;
            this.fGO.resume();
            return;
        }
        super.startPlay();
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void stopPlay() {
        super.stopPlay();
        if (this.fGO != null && this.fGO.kF()) {
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.hdD);
            com.baidu.adp.lib.f.e.gx().post(this.hdD);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected int bNH() {
        return 1;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean isPlaying() {
        if (this.fGO == null || !this.fGO.kF()) {
            return super.isPlaying();
        }
        return this.hdC || this.fGO.kP();
    }
}
