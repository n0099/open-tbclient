package com.baidu.tieba.card.ala;

import android.view.View;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.e;
import com.baidu.tieba.play.f;
import com.baidu.tieba.play.j;
import com.baidu.tieba.play.n;
/* loaded from: classes2.dex */
public class a implements f {
    private bb bAn;
    private j bBh;
    private n bBi;
    private AlaVideoContainer bNF;
    private AlaInfoData cHw;
    private String cHx;
    private String mForumName;
    private boolean cEw = false;
    private j.a cEH = new j.a() { // from class: com.baidu.tieba.card.ala.a.1
        @Override // com.baidu.tieba.play.j.a
        public void akC() {
            a.this.akv();
        }
    };

    public a(AlaVideoContainer alaVideoContainer) {
        this.bNF = alaVideoContainer;
        if (this.bNF != null) {
            this.bBh = new j();
            this.bBh.setPlayer(this.bNF.getVideoView());
            this.bBh.a(this.cEH);
            if (this.bNF.getVideoView() != null) {
                this.bBi = new n(this.bNF.getVideoView().getContext());
                this.bNF.getVideoView().setBusiness(this.bBi);
            }
        }
    }

    public void a(bb bbVar, String str, String str2, boolean z) {
        this.cHx = str2;
        this.mForumName = str;
        if (bbVar != null) {
            this.bAn = bbVar;
            if (this.bNF != null && this.bAn.wG() != null) {
                this.cHw = this.bAn.wG();
                this.bNF.setVideoThumbnail(this.cHw.cover);
                if (this.bBi != null && this.bBi.bnd() != null) {
                    this.bBi.bnd().b(this.cHw);
                }
                if (z) {
                    this.bNF.setTitle(this.bAn.getTitle());
                } else {
                    this.bNF.setTitle("");
                }
                this.bNF.setPlayCount(String.format(this.bNF.getVideoView().getContext().getResources().getString(e.j.ala_audience_count_prefix), ao.L(this.bAn.wG().audience_count)));
            }
        }
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        return this.cEw;
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
        if (this.bNF != null && this.bNF.getVideoView() != null) {
            this.bNF.getVideoView().stopPlayback();
            this.bNF.Vl();
            if (this.bBh != null) {
                this.bBh.stop();
            }
        }
        this.cEw = false;
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.bNF != null) {
            return this.bNF.getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.bAn == null || this.bAn.wE() == null) {
            return null;
        }
        return this.bAn.wE().video_url;
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.bNF == null || this.bNF.getVideoView() == null) {
            return 0;
        }
        return this.bNF.getVideoView().getCurrentPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akv() {
        if (this.bAn == null || this.bAn.wE() == null) {
        }
    }

    public void startPlayAnimation() {
        if (this.bNF != null) {
            this.bNF.startPlayAnimation();
        }
    }

    public void setAutoStartPlay(boolean z) {
        if (this.bNF != null) {
            this.bNF.setAutoStartPlay(z);
        }
    }
}
