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
    private bd bXM;
    private j bYI;
    private n bYJ;
    private boolean cTE = false;
    private j.a cTQ = new j.a() { // from class: com.baidu.tieba.card.ala.a.1
        @Override // com.baidu.tieba.play.j.a
        public void akr() {
            a.this.akk();
        }
    };
    private AlaInfoData cWC;
    private String cWD;
    private AlaVideoContainer ciN;
    private String mForumName;

    public a(AlaVideoContainer alaVideoContainer) {
        this.ciN = alaVideoContainer;
        if (this.ciN != null) {
            this.bYI = new j();
            this.bYI.setPlayer(this.ciN.getVideoView());
            this.bYI.a(this.cTQ);
            if (this.ciN.getVideoView() != null) {
                this.bYJ = new n(this.ciN.getVideoView().getContext());
                this.ciN.getVideoView().setBusiness(this.bYJ);
            }
        }
    }

    public void a(bd bdVar, String str, String str2, boolean z) {
        this.cWD = str2;
        this.mForumName = str;
        if (bdVar != null) {
            this.bXM = bdVar;
            if (this.ciN != null && this.bXM.zl() != null) {
                this.cWC = this.bXM.zl();
                this.ciN.setVideoThumbnail(this.cWC.cover);
                if (this.bYJ != null && this.bYJ.bkl() != null) {
                    this.bYJ.bkl().b(this.cWC);
                }
                if (z) {
                    this.ciN.setTitle(this.bXM.getTitle());
                } else {
                    this.ciN.setTitle("");
                }
                this.ciN.setPlayCount(String.format(this.ciN.getVideoView().getContext().getResources().getString(d.j.ala_audience_count_prefix), am.J(this.bXM.zl().audience_count)));
            }
        }
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        return this.cTE;
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
        if (this.ciN != null && this.ciN.getVideoView() != null) {
            this.ciN.getVideoView().stopPlayback();
            this.ciN.Wd();
            if (this.bYI != null) {
                this.bYI.stop();
            }
        }
        this.cTE = false;
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.ciN != null) {
            return this.ciN.getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.bXM == null || this.bXM.zk() == null) {
            return null;
        }
        return this.bXM.zk().video_url;
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.ciN == null || this.ciN.getVideoView() == null) {
            return 0;
        }
        return this.ciN.getVideoView().getCurrentPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akk() {
        if (this.bXM == null || this.bXM.zk() == null) {
        }
    }

    public void startPlayAnimation() {
        if (this.ciN != null) {
            this.ciN.startPlayAnimation();
        }
    }

    public void setAutoStartPlay(boolean z) {
        if (this.ciN != null) {
            this.ciN.setAutoStartPlay(z);
        }
    }
}
