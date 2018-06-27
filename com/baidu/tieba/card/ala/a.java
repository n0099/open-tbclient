package com.baidu.tieba.card.ala;

import android.view.View;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.d;
import com.baidu.tieba.play.f;
import com.baidu.tieba.play.j;
import com.baidu.tieba.play.n;
/* loaded from: classes2.dex */
public class a implements f {
    private AlaVideoContainer bHb;
    private bc btP;
    private j buK;
    private n buL;
    private boolean cwg = false;
    private j.a cwq = new j.a() { // from class: com.baidu.tieba.card.ala.a.1
        @Override // com.baidu.tieba.play.j.a
        public void aip() {
            a.this.aij();
        }
    };
    private AlaInfoData czc;
    private String czd;
    private String mForumName;

    public a(AlaVideoContainer alaVideoContainer) {
        this.bHb = alaVideoContainer;
        if (this.bHb != null) {
            this.buK = new j();
            this.buK.setPlayer(this.bHb.getVideoView());
            this.buK.a(this.cwq);
            if (this.bHb.getVideoView() != null) {
                this.buL = new n(this.bHb.getVideoView().getContext());
                this.bHb.getVideoView().setBusiness(this.buL);
            }
        }
    }

    public void a(bc bcVar, String str, String str2, boolean z) {
        this.czd = str2;
        this.mForumName = str;
        if (bcVar != null) {
            this.btP = bcVar;
            if (this.bHb != null && this.btP.vO() != null) {
                this.czc = this.btP.vO();
                this.bHb.setVideoThumbnail(this.czc.cover);
                if (this.buL != null && this.buL.bmh() != null) {
                    this.buL.bmh().b(this.czc);
                }
                if (z) {
                    this.bHb.setTitle(this.btP.getTitle());
                } else {
                    this.bHb.setTitle("");
                }
                this.bHb.setPlayCount(String.format(this.bHb.getVideoView().getContext().getResources().getString(d.k.ala_audience_count_prefix), ap.F(this.btP.vO().audience_count)));
            }
        }
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        return this.cwg;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        return false;
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.bHb != null && this.bHb.getVideoView() != null) {
            this.bHb.getVideoView().stopPlayback();
            this.bHb.Tn();
            if (this.buK != null) {
                this.buK.stop();
            }
        }
        this.cwg = false;
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.bHb != null) {
            return this.bHb.getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.btP == null || this.btP.vN() == null) {
            return null;
        }
        return this.btP.vN().video_url;
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.bHb == null || this.bHb.getVideoView() == null) {
            return 0;
        }
        return this.bHb.getVideoView().getCurrentPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aij() {
        if (this.btP == null || this.btP.vN() == null) {
        }
    }

    public void startPlayAnimation() {
        if (this.bHb != null) {
            this.bHb.startPlayAnimation();
        }
    }

    public void setAutoStartPlay(boolean z) {
        if (this.bHb != null) {
            this.bHb.setAutoStartPlay(z);
        }
    }
}
