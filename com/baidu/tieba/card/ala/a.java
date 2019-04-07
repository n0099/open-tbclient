package com.baidu.tieba.card.ala;

import android.view.View;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.d;
import com.baidu.tieba.play.f;
import com.baidu.tieba.play.j;
import com.baidu.tieba.play.n;
/* loaded from: classes3.dex */
public class a implements f {
    private bg bTn;
    private j dbg;
    private n dbh;
    private AlaVideoContainer dqA;
    private boolean ehC = false;
    private j.a ehO = new j.a() { // from class: com.baidu.tieba.card.ala.a.1
        @Override // com.baidu.tieba.play.j.a
        public void qE() {
            a.this.aQm();
        }
    };
    private AlaInfoData ekB;
    private String ekC;
    private String mForumName;

    public a(AlaVideoContainer alaVideoContainer) {
        this.dqA = alaVideoContainer;
        if (this.dqA != null) {
            this.dbg = new j();
            this.dbg.setPlayer(this.dqA.getVideoView());
            this.dbg.a(this.ehO);
            if (this.dqA.getVideoView() != null) {
                this.dbh = new n(this.dqA.getVideoView().getContext());
                this.dqA.getVideoView().setBusiness(this.dbh);
            }
        }
    }

    public void a(bg bgVar, String str, String str2, boolean z) {
        this.ekC = str2;
        this.mForumName = str;
        if (bgVar != null) {
            this.bTn = bgVar;
            if (this.dqA != null && this.bTn.Zh() != null) {
                this.ekB = this.bTn.Zh();
                this.dqA.setVideoThumbnail(this.ekB.cover);
                if (this.dbh != null && this.dbh.bTv() != null) {
                    this.dbh.bTv().b(this.ekB);
                }
                if (z) {
                    this.dqA.setTitle(this.bTn.getTitle());
                } else {
                    this.dqA.setTitle("");
                }
                this.dqA.setPlayCount(String.format(this.dqA.getVideoView().getContext().getResources().getString(d.j.ala_audience_count_prefix), ap.az(this.bTn.Zh().audience_count)));
            }
        }
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        return this.ehC;
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
        if (this.dqA != null && this.dqA.getVideoView() != null) {
            this.dqA.getVideoView().stopPlayback();
            this.dqA.aBh();
            if (this.dbg != null) {
                this.dbg.stop();
            }
        }
        this.ehC = false;
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.dqA != null) {
            return this.dqA.getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.bTn == null || this.bTn.Zf() == null) {
            return null;
        }
        return this.bTn.Zf().video_url;
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.dqA == null || this.dqA.getVideoView() == null) {
            return 0;
        }
        return this.dqA.getVideoView().getCurrentPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQm() {
        if (this.bTn == null || this.bTn.Zf() == null) {
        }
    }

    public void startPlayAnimation() {
        if (this.dqA != null) {
            this.dqA.startPlayAnimation();
        }
    }
}
