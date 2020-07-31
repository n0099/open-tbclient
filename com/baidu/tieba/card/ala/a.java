package com.baidu.tieba.card.ala;

import android.view.View;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.R;
import com.baidu.tieba.play.e;
import com.baidu.tieba.play.f;
/* loaded from: classes15.dex */
public class a implements e {
    private bv aii;
    private AlaVideoContainer fXd;
    private f fss;
    private AlaInfoData gZB;
    private String gZC;
    private String mForumName;
    private boolean gWx = false;
    private f.a gWJ = new f.a() { // from class: com.baidu.tieba.card.ala.a.1
        @Override // com.baidu.tieba.play.f.a
        public void qy() {
            a.this.bRt();
        }
    };

    public a(AlaVideoContainer alaVideoContainer) {
        this.fXd = alaVideoContainer;
        if (this.fXd != null) {
            this.fss = new f();
            this.fss.setPlayer(this.fXd.getVideoView());
            this.fss.a(this.gWJ);
        }
    }

    public void a(bv bvVar, String str, String str2, boolean z) {
        this.gZC = str2;
        this.mForumName = str;
        if (bvVar != null) {
            this.aii = bvVar;
            if (this.fXd != null && this.aii.aWF() != null) {
                this.gZB = this.aii.aWF();
                this.fXd.setVideoThumbnail(this.gZB.cover);
                if (z) {
                    this.fXd.setTitle(this.aii.getTitle());
                } else {
                    this.fXd.setTitle("");
                }
                this.fXd.setPlayCount(String.format(this.fXd.getVideoView().getContext().getResources().getString(R.string.ala_audience_count_prefix), as.numFormatOverWan(this.aii.aWF().audience_count)));
            }
        }
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        return this.gWx;
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
        if (this.fXd != null && this.fXd.getVideoView() != null) {
            this.fXd.getVideoView().stopPlayback();
            this.fXd.bwN();
            if (this.fss != null) {
                this.fss.stop();
            }
        }
        this.gWx = false;
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        if (this.fXd != null) {
            return this.fXd.getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.play.e
    public String getPlayUrl() {
        if (this.aii == null || this.aii.aWD() == null) {
            return null;
        }
        return this.aii.aWD().video_url;
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        if (this.fXd == null || this.fXd.getVideoView() == null) {
            return 0;
        }
        return this.fXd.getVideoView().getCurrentPositionSync();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRt() {
        if (this.aii == null || this.aii.aWD() == null) {
        }
    }

    public void startPlayAnimation() {
        if (this.fXd != null) {
            this.fXd.startPlayAnimation();
        }
    }
}
