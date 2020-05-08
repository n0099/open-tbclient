package com.baidu.tieba.card.ala;

import android.view.View;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.play.f;
import com.baidu.tieba.play.j;
import com.baidu.tieba.play.n;
/* loaded from: classes8.dex */
public class a implements f {
    private bj agC;
    private j ePg;
    private n ePh;
    private AlaVideoContainer fsy;
    private boolean gpb = false;
    private j.a gpn = new j.a() { // from class: com.baidu.tieba.card.ala.a.1
        @Override // com.baidu.tieba.play.j.a
        public void qa() {
            a.this.bEE();
        }
    };
    private AlaInfoData grX;
    private String grY;
    private String mForumName;

    public a(AlaVideoContainer alaVideoContainer) {
        this.fsy = alaVideoContainer;
        if (this.fsy != null) {
            this.ePg = new j();
            this.ePg.setPlayer(this.fsy.getVideoView());
            this.ePg.a(this.gpn);
            if (this.fsy.getVideoView() != null) {
                this.ePh = new n(this.fsy.getVideoView().getContext());
                this.fsy.getVideoView().setBusiness(this.ePh);
            }
        }
    }

    public void a(bj bjVar, String str, String str2, boolean z) {
        this.grY = str2;
        this.mForumName = str;
        if (bjVar != null) {
            this.agC = bjVar;
            if (this.fsy != null && this.agC.aKV() != null) {
                this.grX = this.agC.aKV();
                this.fsy.setVideoThumbnail(this.grX.cover);
                if (this.ePh != null && this.ePh.cJV() != null) {
                    this.ePh.cJV().b(this.grX);
                }
                if (z) {
                    this.fsy.setTitle(this.agC.getTitle());
                } else {
                    this.fsy.setTitle("");
                }
                this.fsy.setPlayCount(String.format(this.fsy.getVideoView().getContext().getResources().getString(R.string.ala_audience_count_prefix), aq.numFormatOverWan(this.agC.aKV().audience_count)));
            }
        }
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        return this.gpb;
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
        if (this.fsy != null && this.fsy.getVideoView() != null) {
            this.fsy.getVideoView().stopPlayback();
            this.fsy.bli();
            if (this.ePg != null) {
                this.ePg.stop();
            }
        }
        this.gpb = false;
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.fsy != null) {
            return this.fsy.getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.agC == null || this.agC.aKT() == null) {
            return null;
        }
        return this.agC.aKT().video_url;
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.fsy == null || this.fsy.getVideoView() == null) {
            return 0;
        }
        return this.fsy.getVideoView().getCurrentPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEE() {
        if (this.agC == null || this.agC.aKT() == null) {
        }
    }

    public void startPlayAnimation() {
        if (this.fsy != null) {
            this.fsy.startPlayAnimation();
        }
    }
}
