package com.baidu.tieba.card.ala;

import android.view.View;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
import com.baidu.tieba.play.e;
import com.baidu.tieba.play.f;
/* loaded from: classes.dex */
public class a implements e {
    private cb akU;
    private f gAm;
    private AlaVideoContainer hnw;
    private AlaInfoData iAb;
    private String iAc;
    private boolean iwQ = false;
    private f.a ixc = new f.a() { // from class: com.baidu.tieba.card.ala.a.1
        @Override // com.baidu.tieba.play.f.a
        public void rD() {
            a.this.csi();
        }
    };
    private String mForumName;

    public a(AlaVideoContainer alaVideoContainer) {
        this.hnw = alaVideoContainer;
        if (this.hnw != null) {
            this.gAm = new f();
            this.gAm.setPlayer(this.hnw.getVideoView());
            this.gAm.a(this.ixc);
        }
    }

    public void a(cb cbVar, String str, String str2, boolean z) {
        this.iAc = str2;
        this.mForumName = str;
        if (cbVar != null) {
            this.akU = cbVar;
            if (this.hnw != null && this.akU.boj() != null) {
                this.iAb = this.akU.boj();
                this.hnw.setVideoThumbnail(this.iAb.cover);
                if (z) {
                    this.hnw.setTitle(this.akU.getTitle());
                } else {
                    this.hnw.setTitle("");
                }
                this.hnw.setPlayCount(String.format(this.hnw.getVideoView().getContext().getResources().getString(R.string.ala_audience_count_prefix), au.numFormatOverWan(this.akU.boj().audience_count)));
            }
        }
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        return this.iwQ;
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
        if (this.hnw != null && this.hnw.getVideoView() != null) {
            this.hnw.getVideoView().stopPlayback();
            this.hnw.bRs();
            if (this.gAm != null) {
                this.gAm.stop();
            }
        }
        this.iwQ = false;
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        if (this.hnw != null) {
            return this.hnw.getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.play.e
    public String getPlayUrl() {
        if (this.akU == null || this.akU.boh() == null) {
            return null;
        }
        return this.akU.boh().video_url;
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        if (this.hnw == null || this.hnw.getVideoView() == null) {
            return 0;
        }
        return this.hnw.getVideoView().getCurrentPositionSync();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csi() {
        if (this.akU == null || this.akU.boh() == null) {
        }
    }

    public void startPlayAnimation() {
        if (this.hnw != null) {
            this.hnw.startPlayAnimation();
        }
    }
}
