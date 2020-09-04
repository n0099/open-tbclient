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
    private bw ajz;
    private f fDQ;
    private AlaVideoContainer gjg;
    private AlaInfoData hmy;
    private String hmz;
    private String mForumName;
    private boolean hju = false;
    private f.a hjG = new f.a() { // from class: com.baidu.tieba.card.ala.a.1
        @Override // com.baidu.tieba.play.f.a
        public void rX() {
            a.this.cbG();
        }
    };

    public a(AlaVideoContainer alaVideoContainer) {
        this.gjg = alaVideoContainer;
        if (this.gjg != null) {
            this.fDQ = new f();
            this.fDQ.setPlayer(this.gjg.getVideoView());
            this.fDQ.a(this.hjG);
        }
    }

    public void a(bw bwVar, String str, String str2, boolean z) {
        this.hmz = str2;
        this.mForumName = str;
        if (bwVar != null) {
            this.ajz = bwVar;
            if (this.gjg != null && this.ajz.beY() != null) {
                this.hmy = this.ajz.beY();
                this.gjg.setVideoThumbnail(this.hmy.cover);
                if (z) {
                    this.gjg.setTitle(this.ajz.getTitle());
                } else {
                    this.gjg.setTitle("");
                }
                this.gjg.setPlayCount(String.format(this.gjg.getVideoView().getContext().getResources().getString(R.string.ala_audience_count_prefix), at.numFormatOverWan(this.ajz.beY().audience_count)));
            }
        }
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        return this.hju;
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
        if (this.gjg != null && this.gjg.getVideoView() != null) {
            this.gjg.getVideoView().stopPlayback();
            this.gjg.bFN();
            if (this.fDQ != null) {
                this.fDQ.stop();
            }
        }
        this.hju = false;
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        if (this.gjg != null) {
            return this.gjg.getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.play.e
    public String getPlayUrl() {
        if (this.ajz == null || this.ajz.beW() == null) {
            return null;
        }
        return this.ajz.beW().video_url;
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        if (this.gjg == null || this.gjg.getVideoView() == null) {
            return 0;
        }
        return this.gjg.getVideoView().getCurrentPositionSync();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbG() {
        if (this.ajz == null || this.ajz.beW() == null) {
        }
    }

    public void startPlayAnimation() {
        if (this.gjg != null) {
            this.gjg.startPlayAnimation();
        }
    }
}
