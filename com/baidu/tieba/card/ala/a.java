package com.baidu.tieba.card.ala;

import android.view.View;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
import com.baidu.tieba.play.e;
import com.baidu.tieba.play.f;
/* loaded from: classes20.dex */
public class a implements e {
    private bx akt;
    private AlaVideoContainer gSA;
    private f giL;
    private boolean hYl = false;
    private f.a hYx = new f.a() { // from class: com.baidu.tieba.card.ala.a.1
        @Override // com.baidu.tieba.play.f.a
        public void sc() {
            a.this.cnB();
        }
    };
    private AlaInfoData ibr;
    private String ibs;
    private String mForumName;

    public a(AlaVideoContainer alaVideoContainer) {
        this.gSA = alaVideoContainer;
        if (this.gSA != null) {
            this.giL = new f();
            this.giL.setPlayer(this.gSA.getVideoView());
            this.giL.a(this.hYx);
        }
    }

    public void a(bx bxVar, String str, String str2, boolean z) {
        this.ibs = str2;
        this.mForumName = str;
        if (bxVar != null) {
            this.akt = bxVar;
            if (this.gSA != null && this.akt.blW() != null) {
                this.ibr = this.akt.blW();
                this.gSA.setVideoThumbnail(this.ibr.cover);
                if (z) {
                    this.gSA.setTitle(this.akt.getTitle());
                } else {
                    this.gSA.setTitle("");
                }
                this.gSA.setPlayCount(String.format(this.gSA.getVideoView().getContext().getResources().getString(R.string.ala_audience_count_prefix), au.numFormatOverWan(this.akt.blW().audience_count)));
            }
        }
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        return this.hYl;
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlaying() {
        return false;
    }

    @Override // com.baidu.tieba.play.e
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.e
    public void startPlay() {
    }

    @Override // com.baidu.tieba.play.e
    public void stopPlay() {
        if (this.gSA != null && this.gSA.getVideoView() != null) {
            this.gSA.getVideoView().stopPlayback();
            this.gSA.bOk();
            if (this.giL != null) {
                this.giL.stop();
            }
        }
        this.hYl = false;
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        if (this.gSA != null) {
            return this.gSA.getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.play.e
    public String getPlayUrl() {
        if (this.akt == null || this.akt.blU() == null) {
            return null;
        }
        return this.akt.blU().video_url;
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        if (this.gSA == null || this.gSA.getVideoView() == null) {
            return 0;
        }
        return this.gSA.getVideoView().getCurrentPositionSync();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnB() {
        if (this.akt == null || this.akt.blU() == null) {
        }
    }

    public void startPlayAnimation() {
        if (this.gSA != null) {
            this.gSA.startPlayAnimation();
        }
    }
}
