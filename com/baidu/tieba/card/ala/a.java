package com.baidu.tieba.card.ala;

import android.view.View;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
import com.baidu.tieba.play.f;
import com.baidu.tieba.play.j;
import com.baidu.tieba.play.n;
/* loaded from: classes.dex */
public class a implements f {
    private be bXF;
    private j bYB;
    private n bYC;
    private boolean cPd = false;
    private j.a cPp = new j.a() { // from class: com.baidu.tieba.card.ala.a.1
        @Override // com.baidu.tieba.play.j.a
        public void ajo() {
            a.this.ajh();
        }
    };
    private AlaInfoData cSa;
    private String cSb;
    private AlaVideoContainer ciG;
    private String mForumName;

    public a(AlaVideoContainer alaVideoContainer) {
        this.ciG = alaVideoContainer;
        if (this.ciG != null) {
            this.bYB = new j();
            this.bYB.setPlayer(this.ciG.getVideoView());
            this.bYB.a(this.cPp);
            if (this.ciG.getVideoView() != null) {
                this.bYC = new n(this.ciG.getVideoView().getContext());
                this.ciG.getVideoView().setBusiness(this.bYC);
            }
        }
    }

    public void a(be beVar, String str, String str2, boolean z) {
        this.cSb = str2;
        this.mForumName = str;
        if (beVar != null) {
            this.bXF = beVar;
            if (this.ciG != null && this.bXF.zq() != null) {
                this.cSa = this.bXF.zq();
                this.ciG.setVideoThumbnail(this.cSa.cover);
                if (this.bYC != null && this.bYC.bqS() != null) {
                    this.bYC.bqS().b(this.cSa);
                }
                if (z) {
                    this.ciG.setTitle(this.bXF.getTitle());
                } else {
                    this.ciG.setTitle("");
                }
                this.ciG.setPlayCount(String.format(this.ciG.getVideoView().getContext().getResources().getString(d.j.ala_audience_count_prefix), am.I(this.bXF.zq().audience_count)));
            }
        }
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        return this.cPd;
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
        if (this.ciG != null && this.ciG.getVideoView() != null) {
            this.ciG.getVideoView().stopPlayback();
            this.ciG.Wp();
            if (this.bYB != null) {
                this.bYB.stop();
            }
        }
        this.cPd = false;
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.ciG != null) {
            return this.ciG.getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.bXF == null || this.bXF.zp() == null) {
            return null;
        }
        return this.bXF.zp().video_url;
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.ciG == null || this.ciG.getVideoView() == null) {
            return 0;
        }
        return this.ciG.getVideoView().getCurrentPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajh() {
        if (this.bXF == null || this.bXF.zp() == null) {
        }
    }

    public void startPlayAnimation() {
        if (this.ciG != null) {
            this.ciG.startPlayAnimation();
        }
    }

    public void setAutoStartPlay(boolean z) {
        if (this.ciG != null) {
            this.ciG.setAutoStartPlay(z);
        }
    }
}
