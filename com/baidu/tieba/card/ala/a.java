package com.baidu.tieba.card.ala;

import android.view.View;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.d;
import com.baidu.tieba.play.f;
import com.baidu.tieba.play.j;
import com.baidu.tieba.play.n;
/* loaded from: classes2.dex */
public class a implements f {
    private bd bjU;
    private j bkQ;
    private n bkR;
    private AlaVideoContainer bwm;
    private AlaInfoData crw;
    private String crx;
    private String mForumName;
    private boolean cow = false;
    private j.a coJ = new j.a() { // from class: com.baidu.tieba.card.ala.a.1
        @Override // com.baidu.tieba.play.j.a
        public void afo() {
            a.this.afi();
        }
    };

    public a(AlaVideoContainer alaVideoContainer) {
        this.bwm = alaVideoContainer;
        if (this.bwm != null) {
            this.bkQ = new j();
            this.bkQ.setPlayer(this.bwm.getVideoView());
            this.bkQ.a(this.coJ);
            if (this.bwm.getVideoView() != null) {
                this.bkR = new n(this.bwm.getVideoView().getContext());
                this.bwm.getVideoView().setBusiness(this.bkR);
            }
        }
    }

    public void a(bd bdVar, String str, String str2, boolean z) {
        this.crx = str2;
        this.mForumName = str;
        if (bdVar != null) {
            this.bjU = bdVar;
            if (this.bwm != null && this.bjU.si() != null) {
                this.crw = this.bjU.si();
                this.bwm.setVideoThumbnail(this.crw.cover);
                if (this.bkR != null && this.bkR.bgF() != null) {
                    this.bkR.bgF().b(this.crw);
                }
                if (z) {
                    this.bwm.setTitle(this.bjU.getTitle());
                } else {
                    this.bwm.setTitle("");
                }
                this.bwm.setPlayCount(String.format(this.bwm.getVideoView().getContext().getResources().getString(d.k.ala_audience_count_prefix), an.B(this.bjU.si().audience_count)));
            }
        }
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        return this.cow;
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
        if (this.bwm != null && this.bwm.getVideoView() != null) {
            this.bwm.getVideoView().stopPlayback();
            this.bwm.Pw();
            if (this.bkQ != null) {
                this.bkQ.stop();
            }
        }
        this.cow = false;
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.bwm != null) {
            return this.bwm.getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.bjU == null || this.bjU.sh() == null) {
            return null;
        }
        return this.bjU.sh().video_url;
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.bwm == null || this.bwm.getVideoView() == null) {
            return 0;
        }
        return this.bwm.getVideoView().getCurrentPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afi() {
        if (this.bjU == null || this.bjU.sh() == null) {
        }
    }

    public void startPlayAnimation() {
        if (this.bwm != null) {
            this.bwm.startPlayAnimation();
        }
    }

    public void setAutoStartPlay(boolean z) {
        if (this.bwm != null) {
            this.bwm.setAutoStartPlay(z);
        }
    }
}
