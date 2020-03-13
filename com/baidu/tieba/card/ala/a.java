package com.baidu.tieba.card.ala;

import android.view.View;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.play.f;
import com.baidu.tieba.play.j;
import com.baidu.tieba.play.n;
/* loaded from: classes8.dex */
public class a implements f {
    private bj NQ;
    private AlaVideoContainer eNB;
    private j ell;
    private n elm;
    private boolean fJH = false;
    private j.a fJT = new j.a() { // from class: com.baidu.tieba.card.ala.a.1
        @Override // com.baidu.tieba.play.j.a
        public void lw() {
            a.this.buP();
        }
    };
    private AlaInfoData fMC;
    private String fMD;
    private String mForumName;

    public a(AlaVideoContainer alaVideoContainer) {
        this.eNB = alaVideoContainer;
        if (this.eNB != null) {
            this.ell = new j();
            this.ell.setPlayer(this.eNB.getVideoView());
            this.ell.a(this.fJT);
            if (this.eNB.getVideoView() != null) {
                this.elm = new n(this.eNB.getVideoView().getContext());
                this.eNB.getVideoView().setBusiness(this.elm);
            }
        }
    }

    public void a(bj bjVar, String str, String str2, boolean z) {
        this.fMD = str2;
        this.mForumName = str;
        if (bjVar != null) {
            this.NQ = bjVar;
            if (this.eNB != null && this.NQ.aCH() != null) {
                this.fMC = this.NQ.aCH();
                this.eNB.setVideoThumbnail(this.fMC.cover);
                if (this.elm != null && this.elm.cza() != null) {
                    this.elm.cza().b(this.fMC);
                }
                if (z) {
                    this.eNB.setTitle(this.NQ.getTitle());
                } else {
                    this.eNB.setTitle("");
                }
                this.eNB.setPlayCount(String.format(this.eNB.getVideoView().getContext().getResources().getString(R.string.ala_audience_count_prefix), aq.numFormatOverWan(this.NQ.aCH().audience_count)));
            }
        }
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        return this.fJH;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        return false;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.eNB != null && this.eNB.getVideoView() != null) {
            this.eNB.getVideoView().stopPlayback();
            this.eNB.bcp();
            if (this.ell != null) {
                this.ell.stop();
            }
        }
        this.fJH = false;
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.eNB != null) {
            return this.eNB.getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.NQ == null || this.NQ.aCF() == null) {
            return null;
        }
        return this.NQ.aCF().video_url;
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.eNB == null || this.eNB.getVideoView() == null) {
            return 0;
        }
        return this.eNB.getVideoView().getCurrentPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buP() {
        if (this.NQ == null || this.NQ.aCF() == null) {
        }
    }

    public void startPlayAnimation() {
        if (this.eNB != null) {
            this.eNB.startPlayAnimation();
        }
    }
}
