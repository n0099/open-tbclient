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
import com.baidu.tbadk.core.data.bk;
import com.baidu.tieba.play.operableVideoView.d;
import java.util.HashMap;
import tbclient.VideoInfo;
/* loaded from: classes9.dex */
public class e extends com.baidu.tieba.play.operableVideoView.b {
    private bk aee;
    private com.baidu.afd.videopaster.d gDJ;
    private CustomMessageListener gDZ;
    private boolean ifP;
    protected boolean ifQ;
    private Runnable ifR;

    public e(Context context, View view) {
        super(context, view);
        this.ifP = false;
        this.gDZ = new CustomMessageListener(2921395) { // from class: com.baidu.tieba.homepage.personalize.view.e.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.afd.videopaster.data.b bVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.afd.videopaster.data.b) && (bVar = (com.baidu.afd.videopaster.data.b) customResponsedMessage.getData()) != null) {
                    String videoId = bVar.getVideoId();
                    if (!StringUtils.isNull(videoId) && e.this.aee != null && videoId.equals(e.this.aee.getId())) {
                        e.this.gDJ.a(e.this.a(e.this.aee, bVar));
                    }
                }
            }
        };
        this.ifR = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.view.e.4
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.gDJ != null) {
                    e.this.ifQ = false;
                    e.this.gDJ.stop();
                    e.this.gDJ.onDestroy();
                }
            }
        };
        tz(true);
        cgC();
    }

    protected void cgC() {
        this.gDJ = new com.baidu.afd.videopaster.d(this.mContext, (ViewGroup) cQn());
        this.gDJ.a(new d.a() { // from class: com.baidu.tieba.homepage.personalize.view.e.1
            @Override // com.baidu.afd.videopaster.d.a
            public void pV() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void pU() {
                e.this.startPlay();
            }

            @Override // com.baidu.afd.videopaster.d.a
            public void pT() {
            }

            @Override // com.baidu.afd.videopaster.d.a
            public boolean pW() {
                return false;
            }
        });
        a(new d.a() { // from class: com.baidu.tieba.homepage.personalize.view.e.2
            @Override // com.baidu.tieba.play.operableVideoView.d.a
            public void cj(int i, int i2) {
                if (!e.this.cRN()) {
                    if (i2 >= i) {
                        if (e.this.gDJ.a(false, false, "NEWINDEX")) {
                        }
                    } else if (i != 0 && !e.this.air && (i2 * 100) / i >= 80 && i > 15000) {
                        e.this.aD(e.this.aee);
                    }
                }
            }
        });
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        this.gDZ.setTag(this.afZ);
        MessageManager.getInstance().registerListener(this.gDZ);
    }

    @Override // com.baidu.tieba.play.operableVideoView.b, com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void setData(bk bkVar) {
        if (bkVar != null) {
            super.setData(bkVar);
            boolean z = this.aee == bkVar;
            this.aee = bkVar;
            if (this.gDJ != null) {
                if (this.ifP && z) {
                    this.ifP = false;
                } else {
                    this.gDJ.reset();
                }
            }
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.b, com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.g.a
    public void onCompletion(com.baidu.tieba.play.g gVar) {
        if (!this.gDJ.a(false, false, "NEWINDEX")) {
            startPlay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aD(bk bkVar) {
        if (bkVar != null && bkVar.getId() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921394, bkVar.getId()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.afd.videopaster.a a(bk bkVar, com.baidu.afd.videopaster.data.b bVar) {
        int i;
        int i2;
        int i3;
        int i4 = -1;
        if (bkVar == null || bVar == null) {
            return null;
        }
        int qa = bVar.qa();
        int qb = bVar.qb();
        int pZ = bVar.pZ();
        if (pZ != -1) {
            i = qa != -1 ? (pZ - qa) - 1 : -1;
            if (qb != -1) {
                i4 = (qb - pZ) - 1;
            }
        } else {
            i = -1;
        }
        VideoInfo aQQ = bkVar.aQQ();
        if (aQQ != null) {
            i3 = aQQ.video_width.intValue();
            i2 = aQQ.video_height.intValue();
        } else {
            i2 = 0;
            i3 = 0;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("video_vid", bkVar.getId());
        hashMap.put("video_title", bkVar.getTitle());
        hashMap.put("forum_id", String.valueOf(bkVar.getFid()));
        hashMap.put("forum_name", bkVar.aQC());
        hashMap.put("up_distance", String.valueOf(i));
        hashMap.put("down_distance", String.valueOf(i4));
        com.baidu.afd.videopaster.a a = com.baidu.afd.videopaster.c.a(3, 0, "1546854828072", pZ + 1, i3, i2);
        a.w(hashMap);
        return a;
    }

    public void onPause() {
    }

    public void onResume() {
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean or(boolean z) {
        if (this.gDJ != null) {
            if (z) {
                if (this.gDJ.pE()) {
                    this.ifQ = false;
                    this.gDJ.stop();
                }
            } else if (this.gDJ.pE()) {
                this.ifP = true;
                this.gDJ.az(true);
            }
        }
        return super.or(z);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void startPlay() {
        if (this.gDJ != null && this.gDJ.pE()) {
            this.ifQ = true;
            this.gDJ.resume();
            return;
        }
        super.startPlay();
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public void stopPlay() {
        super.stopPlay();
        if (this.gDJ != null && this.gDJ.pE()) {
            com.baidu.adp.lib.f.e.ld().removeCallbacks(this.ifR);
            com.baidu.adp.lib.f.e.ld().post(this.ifR);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected int cgD() {
        return 1;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.tieba.play.operableVideoView.a
    public boolean isPlaying() {
        if (this.gDJ == null || !this.gDJ.pE()) {
            return super.isPlaying();
        }
        return this.ifQ || this.gDJ.pO();
    }
}
