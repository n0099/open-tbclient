package com.baidu.tieba.card.ala;

import android.view.View;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
import com.baidu.tieba.play.e;
import com.baidu.tieba.play.f;
/* loaded from: classes20.dex */
public class a implements e {
    private bw ajX;
    private f fHc;
    private AlaVideoContainer gmn;
    private AlaInfoData htB;
    private String htC;
    private String mForumName;
    private boolean hqx = false;
    private f.a hqJ = new f.a() { // from class: com.baidu.tieba.card.ala.a.1
        @Override // com.baidu.tieba.play.f.a
        public void sc() {
            a.this.ceV();
        }
    };

    public a(AlaVideoContainer alaVideoContainer) {
        this.gmn = alaVideoContainer;
        if (this.gmn != null) {
            this.fHc = new f();
            this.fHc.setPlayer(this.gmn.getVideoView());
            this.fHc.a(this.hqJ);
        }
    }

    public void a(bw bwVar, String str, String str2, boolean z) {
        this.htC = str2;
        this.mForumName = str;
        if (bwVar != null) {
            this.ajX = bwVar;
            if (this.gmn != null && this.ajX.bfS() != null) {
                this.htB = this.ajX.bfS();
                this.gmn.setVideoThumbnail(this.htB.cover);
                if (z) {
                    this.gmn.setTitle(this.ajX.getTitle());
                } else {
                    this.gmn.setTitle("");
                }
                this.gmn.setPlayCount(String.format(this.gmn.getVideoView().getContext().getResources().getString(R.string.ala_audience_count_prefix), at.numFormatOverWan(this.ajX.bfS().audience_count)));
            }
        }
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        return this.hqx;
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
        if (this.gmn != null && this.gmn.getVideoView() != null) {
            this.gmn.getVideoView().stopPlayback();
            this.gmn.bHd();
            if (this.fHc != null) {
                this.fHc.stop();
            }
        }
        this.hqx = false;
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        if (this.gmn != null) {
            return this.gmn.getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.play.e
    public String getPlayUrl() {
        if (this.ajX == null || this.ajX.bfQ() == null) {
            return null;
        }
        return this.ajX.bfQ().video_url;
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        if (this.gmn == null || this.gmn.getVideoView() == null) {
            return 0;
        }
        return this.gmn.getVideoView().getCurrentPositionSync();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ceV() {
        if (this.ajX == null || this.ajX.bfQ() == null) {
        }
    }

    public void startPlayAnimation() {
        if (this.gmn != null) {
            this.gmn.startPlayAnimation();
        }
    }
}
