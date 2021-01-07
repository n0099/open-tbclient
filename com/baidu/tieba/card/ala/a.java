package com.baidu.tieba.card.ala;

import android.view.View;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
import com.baidu.tieba.play.e;
import com.baidu.tieba.play.f;
/* loaded from: classes.dex */
public class a implements e {
    private bz alW;
    private f gBV;
    private AlaVideoContainer hnB;
    private boolean ivF = false;
    private f.a ivR = new f.a() { // from class: com.baidu.tieba.card.ala.a.1
        @Override // com.baidu.tieba.play.f.a
        public void rF() {
            a.this.cuJ();
        }
    };
    private AlaInfoData iyK;
    private String iyL;
    private String mForumName;

    public a(AlaVideoContainer alaVideoContainer) {
        this.hnB = alaVideoContainer;
        if (this.hnB != null) {
            this.gBV = new f();
            this.gBV.setPlayer(this.hnB.getVideoView());
            this.gBV.a(this.ivR);
        }
    }

    public void a(bz bzVar, String str, String str2, boolean z) {
        this.iyL = str2;
        this.mForumName = str;
        if (bzVar != null) {
            this.alW = bzVar;
            if (this.hnB != null && this.alW.brK() != null) {
                this.iyK = this.alW.brK();
                this.hnB.setVideoThumbnail(this.iyK.cover);
                if (z) {
                    this.hnB.setTitle(this.alW.getTitle());
                } else {
                    this.hnB.setTitle("");
                }
                this.hnB.setPlayCount(String.format(this.hnB.getVideoView().getContext().getResources().getString(R.string.ala_audience_count_prefix), at.numFormatOverWan(this.alW.brK().audience_count)));
            }
        }
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        return this.ivF;
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
        if (this.hnB != null && this.hnB.getVideoView() != null) {
            this.hnB.getVideoView().stopPlayback();
            this.hnB.bUz();
            if (this.gBV != null) {
                this.gBV.stop();
            }
        }
        this.ivF = false;
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        if (this.hnB != null) {
            return this.hnB.getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.play.e
    public String getPlayUrl() {
        if (this.alW == null || this.alW.brI() == null) {
            return null;
        }
        return this.alW.brI().video_url;
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        if (this.hnB == null || this.hnB.getVideoView() == null) {
            return 0;
        }
        return this.hnB.getVideoView().getCurrentPositionSync();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuJ() {
        if (this.alW == null || this.alW.brI() == null) {
        }
    }

    public void startPlayAnimation() {
        if (this.hnB != null) {
            this.hnB.startPlayAnimation();
        }
    }
}
