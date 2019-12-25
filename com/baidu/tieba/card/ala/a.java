package com.baidu.tieba.card.ala;

import android.view.View;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.play.f;
import com.baidu.tieba.play.j;
import com.baidu.tieba.play.n;
/* loaded from: classes5.dex */
public class a implements f {
    private bj Nl;
    private AlaVideoContainer eIj;
    private j egJ;
    private n egK;
    private boolean fDL = false;
    private j.a fDX = new j.a() { // from class: com.baidu.tieba.card.ala.a.1
        @Override // com.baidu.tieba.play.j.a
        public void lg() {
            a.this.bsg();
        }
    };
    private AlaInfoData fGG;
    private String fGH;
    private String mForumName;

    public a(AlaVideoContainer alaVideoContainer) {
        this.eIj = alaVideoContainer;
        if (this.eIj != null) {
            this.egJ = new j();
            this.egJ.setPlayer(this.eIj.getVideoView());
            this.egJ.a(this.fDX);
            if (this.eIj.getVideoView() != null) {
                this.egK = new n(this.eIj.getVideoView().getContext());
                this.eIj.getVideoView().setBusiness(this.egK);
            }
        }
    }

    public void a(bj bjVar, String str, String str2, boolean z) {
        this.fGH = str2;
        this.mForumName = str;
        if (bjVar != null) {
            this.Nl = bjVar;
            if (this.eIj != null && this.Nl.azX() != null) {
                this.fGG = this.Nl.azX();
                this.eIj.setVideoThumbnail(this.fGG.cover);
                if (this.egK != null && this.egK.cwu() != null) {
                    this.egK.cwu().b(this.fGG);
                }
                if (z) {
                    this.eIj.setTitle(this.Nl.getTitle());
                } else {
                    this.eIj.setTitle("");
                }
                this.eIj.setPlayCount(String.format(this.eIj.getVideoView().getContext().getResources().getString(R.string.ala_audience_count_prefix), aq.numFormatOverWan(this.Nl.azX().audience_count)));
            }
        }
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        return this.fDL;
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
        if (this.eIj != null && this.eIj.getVideoView() != null) {
            this.eIj.getVideoView().stopPlayback();
            this.eIj.aZB();
            if (this.egJ != null) {
                this.egJ.stop();
            }
        }
        this.fDL = false;
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.eIj != null) {
            return this.eIj.getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.Nl == null || this.Nl.azV() == null) {
            return null;
        }
        return this.Nl.azV().video_url;
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.eIj == null || this.eIj.getVideoView() == null) {
            return 0;
        }
        return this.eIj.getVideoView().getCurrentPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsg() {
        if (this.Nl == null || this.Nl.azV() == null) {
        }
    }

    public void startPlayAnimation() {
        if (this.eIj != null) {
            this.eIj.startPlayAnimation();
        }
    }
}
