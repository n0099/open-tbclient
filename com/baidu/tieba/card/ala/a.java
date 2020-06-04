package com.baidu.tieba.card.ala;

import android.view.View;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.play.f;
import com.baidu.tieba.play.j;
import com.baidu.tieba.play.n;
/* loaded from: classes8.dex */
public class a implements f {
    private bk ahg;
    private AlaVideoContainer fGB;
    private j fbY;
    private n fbZ;
    private boolean gEc = false;
    private j.a gEo = new j.a() { // from class: com.baidu.tieba.card.ala.a.1
        @Override // com.baidu.tieba.play.j.a
        public void qg() {
            a.this.bLa();
        }
    };
    private AlaInfoData gGX;
    private String gGY;
    private String mForumName;

    public a(AlaVideoContainer alaVideoContainer) {
        this.fGB = alaVideoContainer;
        if (this.fGB != null) {
            this.fbY = new j();
            this.fbY.setPlayer(this.fGB.getVideoView());
            this.fbY.a(this.gEo);
            if (this.fGB.getVideoView() != null) {
                this.fbZ = new n(this.fGB.getVideoView().getContext());
                this.fGB.getVideoView().setBusiness(this.fbZ);
            }
        }
    }

    public void a(bk bkVar, String str, String str2, boolean z) {
        this.gGY = str2;
        this.mForumName = str;
        if (bkVar != null) {
            this.ahg = bkVar;
            if (this.fGB != null && this.ahg.aQS() != null) {
                this.gGX = this.ahg.aQS();
                this.fGB.setVideoThumbnail(this.gGX.cover);
                if (this.fbZ != null && this.fbZ.cRl() != null) {
                    this.fbZ.cRl().c(this.gGX);
                }
                if (z) {
                    this.fGB.setTitle(this.ahg.getTitle());
                } else {
                    this.fGB.setTitle("");
                }
                this.fGB.setPlayCount(String.format(this.fGB.getVideoView().getContext().getResources().getString(R.string.ala_audience_count_prefix), aq.numFormatOverWan(this.ahg.aQS().audience_count)));
            }
        }
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        return this.gEc;
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
        if (this.fGB != null && this.fGB.getVideoView() != null) {
            this.fGB.getVideoView().stopPlayback();
            this.fGB.bqG();
            if (this.fbY != null) {
                this.fbY.stop();
            }
        }
        this.gEc = false;
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.fGB != null) {
            return this.fGB.getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.ahg == null || this.ahg.aQQ() == null) {
            return null;
        }
        return this.ahg.aQQ().video_url;
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.fGB == null || this.fGB.getVideoView() == null) {
            return 0;
        }
        return this.fGB.getVideoView().getCurrentPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLa() {
        if (this.ahg == null || this.ahg.aQQ() == null) {
        }
    }

    public void startPlayAnimation() {
        if (this.fGB != null) {
            this.fGB.startPlayAnimation();
        }
    }
}
