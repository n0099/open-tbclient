package com.baidu.tieba.card.ala;

import android.view.View;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import com.baidu.tieba.play.f;
import com.baidu.tieba.play.j;
import com.baidu.tieba.play.n;
/* loaded from: classes8.dex */
public class a implements f {
    private bu aiq;
    private AlaVideoContainer fRK;
    private j fni;
    private n fnj;
    private boolean gQS = false;
    private j.a gRe = new j.a() { // from class: com.baidu.tieba.card.ala.a.1
        @Override // com.baidu.tieba.play.j.a
        public void qx() {
            a.this.bOj();
        }
    };
    private AlaInfoData gTX;
    private String gTY;
    private String mForumName;

    public a(AlaVideoContainer alaVideoContainer) {
        this.fRK = alaVideoContainer;
        if (this.fRK != null) {
            this.fni = new j();
            this.fni.setPlayer(this.fRK.getVideoView());
            this.fni.a(this.gRe);
            if (this.fRK.getVideoView() != null) {
                this.fnj = new n(this.fRK.getVideoView().getContext());
                this.fRK.getVideoView().setBusiness(this.fnj);
            }
        }
    }

    public void a(bu buVar, String str, String str2, boolean z) {
        this.gTY = str2;
        this.mForumName = str;
        if (buVar != null) {
            this.aiq = buVar;
            if (this.fRK != null && this.aiq.aSJ() != null) {
                this.gTX = this.aiq.aSJ();
                this.fRK.setVideoThumbnail(this.gTX.cover);
                if (this.fnj != null && this.fnj.cVD() != null) {
                    this.fnj.cVD().c(this.gTX);
                }
                if (z) {
                    this.fRK.setTitle(this.aiq.getTitle());
                } else {
                    this.fRK.setTitle("");
                }
                this.fRK.setPlayCount(String.format(this.fRK.getVideoView().getContext().getResources().getString(R.string.ala_audience_count_prefix), ar.numFormatOverWan(this.aiq.aSJ().audience_count)));
            }
        }
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        return this.gQS;
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
        if (this.fRK != null && this.fRK.getVideoView() != null) {
            this.fRK.getVideoView().stopPlayback();
            this.fRK.btE();
            if (this.fni != null) {
                this.fni.stop();
            }
        }
        this.gQS = false;
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.fRK != null) {
            return this.fRK.getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.aiq == null || this.aiq.aSH() == null) {
            return null;
        }
        return this.aiq.aSH().video_url;
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.fRK == null || this.fRK.getVideoView() == null) {
            return 0;
        }
        return this.fRK.getVideoView().getCurrentPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOj() {
        if (this.aiq == null || this.aiq.aSH() == null) {
        }
    }

    public void startPlayAnimation() {
        if (this.fRK != null) {
            this.fRK.startPlayAnimation();
        }
    }
}
