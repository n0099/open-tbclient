package com.baidu.tieba.card.ala;

import android.view.View;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
import com.baidu.tieba.play.e;
import com.baidu.tieba.play.f;
/* loaded from: classes21.dex */
public class a implements e {
    private bw akp;
    private f fTl;
    private AlaVideoContainer gAG;
    private AlaInfoData hIv;
    private String hIw;
    private String mForumName;
    private boolean hFr = false;
    private f.a hFD = new f.a() { // from class: com.baidu.tieba.card.ala.a.1
        @Override // com.baidu.tieba.play.f.a
        public void sc() {
            a.this.cir();
        }
    };

    public a(AlaVideoContainer alaVideoContainer) {
        this.gAG = alaVideoContainer;
        if (this.gAG != null) {
            this.fTl = new f();
            this.fTl.setPlayer(this.gAG.getVideoView());
            this.fTl.a(this.hFD);
        }
    }

    public void a(bw bwVar, String str, String str2, boolean z) {
        this.hIw = str2;
        this.mForumName = str;
        if (bwVar != null) {
            this.akp = bwVar;
            if (this.gAG != null && this.akp.biB() != null) {
                this.hIv = this.akp.biB();
                this.gAG.setVideoThumbnail(this.hIv.cover);
                if (z) {
                    this.gAG.setTitle(this.akp.getTitle());
                } else {
                    this.gAG.setTitle("");
                }
                this.gAG.setPlayCount(String.format(this.gAG.getVideoView().getContext().getResources().getString(R.string.ala_audience_count_prefix), at.numFormatOverWan(this.akp.biB().audience_count)));
            }
        }
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        return this.hFr;
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
        if (this.gAG != null && this.gAG.getVideoView() != null) {
            this.gAG.getVideoView().stopPlayback();
            this.gAG.bJP();
            if (this.fTl != null) {
                this.fTl.stop();
            }
        }
        this.hFr = false;
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        if (this.gAG != null) {
            return this.gAG.getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.play.e
    public String getPlayUrl() {
        if (this.akp == null || this.akp.biz() == null) {
            return null;
        }
        return this.akp.biz().video_url;
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        if (this.gAG == null || this.gAG.getVideoView() == null) {
            return 0;
        }
        return this.gAG.getVideoView().getCurrentPositionSync();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cir() {
        if (this.akp == null || this.akp.biz() == null) {
        }
    }

    public void startPlayAnimation() {
        if (this.gAG != null) {
            this.gAG.startPlayAnimation();
        }
    }
}
