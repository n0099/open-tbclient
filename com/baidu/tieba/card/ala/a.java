package com.baidu.tieba.card.ala;

import android.view.View;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
import com.baidu.tieba.play.e;
import com.baidu.tieba.play.f;
/* loaded from: classes15.dex */
public class a implements e {
    private bw ajx;
    private f fDM;
    private AlaVideoContainer gjc;
    private AlaInfoData hmu;
    private String hmv;
    private String mForumName;
    private boolean hjq = false;
    private f.a hjC = new f.a() { // from class: com.baidu.tieba.card.ala.a.1
        @Override // com.baidu.tieba.play.f.a
        public void rX() {
            a.this.cbF();
        }
    };

    public a(AlaVideoContainer alaVideoContainer) {
        this.gjc = alaVideoContainer;
        if (this.gjc != null) {
            this.fDM = new f();
            this.fDM.setPlayer(this.gjc.getVideoView());
            this.fDM.a(this.hjC);
        }
    }

    public void a(bw bwVar, String str, String str2, boolean z) {
        this.hmv = str2;
        this.mForumName = str;
        if (bwVar != null) {
            this.ajx = bwVar;
            if (this.gjc != null && this.ajx.beY() != null) {
                this.hmu = this.ajx.beY();
                this.gjc.setVideoThumbnail(this.hmu.cover);
                if (z) {
                    this.gjc.setTitle(this.ajx.getTitle());
                } else {
                    this.gjc.setTitle("");
                }
                this.gjc.setPlayCount(String.format(this.gjc.getVideoView().getContext().getResources().getString(R.string.ala_audience_count_prefix), at.numFormatOverWan(this.ajx.beY().audience_count)));
            }
        }
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        return this.hjq;
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
        if (this.gjc != null && this.gjc.getVideoView() != null) {
            this.gjc.getVideoView().stopPlayback();
            this.gjc.bFM();
            if (this.fDM != null) {
                this.fDM.stop();
            }
        }
        this.hjq = false;
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        if (this.gjc != null) {
            return this.gjc.getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.play.e
    public String getPlayUrl() {
        if (this.ajx == null || this.ajx.beW() == null) {
            return null;
        }
        return this.ajx.beW().video_url;
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        if (this.gjc == null || this.gjc.getVideoView() == null) {
            return 0;
        }
        return this.gjc.getVideoView().getCurrentPositionSync();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbF() {
        if (this.ajx == null || this.ajx.beW() == null) {
        }
    }

    public void startPlayAnimation() {
        if (this.gjc != null) {
            this.gjc.startPlayAnimation();
        }
    }
}
