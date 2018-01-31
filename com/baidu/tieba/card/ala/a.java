package com.baidu.tieba.card.ala;

import android.view.View;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
import com.baidu.tieba.play.f;
import com.baidu.tieba.play.j;
import com.baidu.tieba.play.n;
/* loaded from: classes.dex */
public class a implements f {
    private bd bXU;
    private j bYQ;
    private n bYR;
    private boolean cTZ = false;
    private j.a cUl = new j.a() { // from class: com.baidu.tieba.card.ala.a.1
        @Override // com.baidu.tieba.play.j.a
        public void akw() {
            a.this.akp();
        }
    };
    private AlaInfoData cWX;
    private String cWY;
    private AlaVideoContainer ciV;
    private String mForumName;

    public a(AlaVideoContainer alaVideoContainer) {
        this.ciV = alaVideoContainer;
        if (this.ciV != null) {
            this.bYQ = new j();
            this.bYQ.setPlayer(this.ciV.getVideoView());
            this.bYQ.a(this.cUl);
            if (this.ciV.getVideoView() != null) {
                this.bYR = new n(this.ciV.getVideoView().getContext());
                this.ciV.getVideoView().setBusiness(this.bYR);
            }
        }
    }

    public void a(bd bdVar, String str, String str2, boolean z) {
        this.cWY = str2;
        this.mForumName = str;
        if (bdVar != null) {
            this.bXU = bdVar;
            if (this.ciV != null && this.bXU.zm() != null) {
                this.cWX = this.bXU.zm();
                this.ciV.setVideoThumbnail(this.cWX.cover);
                if (this.bYR != null && this.bYR.bkm() != null) {
                    this.bYR.bkm().b(this.cWX);
                }
                if (z) {
                    this.ciV.setTitle(this.bXU.getTitle());
                } else {
                    this.ciV.setTitle("");
                }
                this.ciV.setPlayCount(String.format(this.ciV.getVideoView().getContext().getResources().getString(d.j.ala_audience_count_prefix), am.J(this.bXU.zm().audience_count)));
            }
        }
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        return this.cTZ;
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
        if (this.ciV != null && this.ciV.getVideoView() != null) {
            this.ciV.getVideoView().stopPlayback();
            this.ciV.Wf();
            if (this.bYQ != null) {
                this.bYQ.stop();
            }
        }
        this.cTZ = false;
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.ciV != null) {
            return this.ciV.getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.bXU == null || this.bXU.zl() == null) {
            return null;
        }
        return this.bXU.zl().video_url;
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.ciV == null || this.ciV.getVideoView() == null) {
            return 0;
        }
        return this.ciV.getVideoView().getCurrentPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akp() {
        if (this.bXU == null || this.bXU.zl() == null) {
        }
    }

    public void startPlayAnimation() {
        if (this.ciV != null) {
            this.ciV.startPlayAnimation();
        }
    }

    public void setAutoStartPlay(boolean z) {
        if (this.ciV != null) {
            this.ciV.setAutoStartPlay(z);
        }
    }
}
