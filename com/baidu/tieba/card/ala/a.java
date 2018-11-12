package com.baidu.tieba.card.ala;

import android.view.View;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.e;
import com.baidu.tieba.play.f;
import com.baidu.tieba.play.j;
import com.baidu.tieba.play.n;
/* loaded from: classes6.dex */
public class a implements f {
    private bb bJG;
    private n bKA;
    private j bKz;
    private AlaVideoContainer bWT;
    private boolean cNW = false;
    private j.a cOh = new j.a() { // from class: com.baidu.tieba.card.ala.a.1
        @Override // com.baidu.tieba.play.j.a
        public void anG() {
            a.this.anz();
        }
    };
    private AlaInfoData cQW;
    private String cQX;
    private String mForumName;

    public a(AlaVideoContainer alaVideoContainer) {
        this.bWT = alaVideoContainer;
        if (this.bWT != null) {
            this.bKz = new j();
            this.bKz.setPlayer(this.bWT.getVideoView());
            this.bKz.a(this.cOh);
            if (this.bWT.getVideoView() != null) {
                this.bKA = new n(this.bWT.getVideoView().getContext());
                this.bWT.getVideoView().setBusiness(this.bKA);
            }
        }
    }

    public void a(bb bbVar, String str, String str2, boolean z) {
        this.cQX = str2;
        this.mForumName = str;
        if (bbVar != null) {
            this.bJG = bbVar;
            if (this.bWT != null && this.bJG.yW() != null) {
                this.cQW = this.bJG.yW();
                this.bWT.setVideoThumbnail(this.cQW.cover);
                if (this.bKA != null && this.bKA.bpO() != null) {
                    this.bKA.bpO().b(this.cQW);
                }
                if (z) {
                    this.bWT.setTitle(this.bJG.getTitle());
                } else {
                    this.bWT.setTitle("");
                }
                this.bWT.setPlayCount(String.format(this.bWT.getVideoView().getContext().getResources().getString(e.j.ala_audience_count_prefix), ao.P(this.bJG.yW().audience_count)));
            }
        }
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        return this.cNW;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        return false;
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.bWT != null && this.bWT.getVideoView() != null) {
            this.bWT.getVideoView().stopPlayback();
            this.bWT.Zd();
            if (this.bKz != null) {
                this.bKz.stop();
            }
        }
        this.cNW = false;
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.bWT != null) {
            return this.bWT.getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.bJG == null || this.bJG.yU() == null) {
            return null;
        }
        return this.bJG.yU().video_url;
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.bWT == null || this.bWT.getVideoView() == null) {
            return 0;
        }
        return this.bWT.getVideoView().getCurrentPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anz() {
        if (this.bJG == null || this.bJG.yU() == null) {
        }
    }

    public void startPlayAnimation() {
        if (this.bWT != null) {
            this.bWT.startPlayAnimation();
        }
    }

    public void setAutoStartPlay(boolean z) {
        if (this.bWT != null) {
            this.bWT.setAutoStartPlay(z);
        }
    }
}
