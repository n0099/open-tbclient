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
    private bd bkk;
    private j blf;
    private n blg;
    private AlaVideoContainer bxd;
    private boolean cpG = false;
    private j.a cpT = new j.a() { // from class: com.baidu.tieba.card.ala.a.1
        @Override // com.baidu.tieba.play.j.a
        public void afo() {
            a.this.afi();
        }
    };
    private AlaInfoData csF;
    private String csG;
    private String mForumName;

    public a(AlaVideoContainer alaVideoContainer) {
        this.bxd = alaVideoContainer;
        if (this.bxd != null) {
            this.blf = new j();
            this.blf.setPlayer(this.bxd.getVideoView());
            this.blf.a(this.cpT);
            if (this.bxd.getVideoView() != null) {
                this.blg = new n(this.bxd.getVideoView().getContext());
                this.bxd.getVideoView().setBusiness(this.blg);
            }
        }
    }

    public void a(bd bdVar, String str, String str2, boolean z) {
        this.csG = str2;
        this.mForumName = str;
        if (bdVar != null) {
            this.bkk = bdVar;
            if (this.bxd != null && this.bkk.sh() != null) {
                this.csF = this.bkk.sh();
                this.bxd.setVideoThumbnail(this.csF.cover);
                if (this.blg != null && this.blg.bgF() != null) {
                    this.blg.bgF().b(this.csF);
                }
                if (z) {
                    this.bxd.setTitle(this.bkk.getTitle());
                } else {
                    this.bxd.setTitle("");
                }
                this.bxd.setPlayCount(String.format(this.bxd.getVideoView().getContext().getResources().getString(d.k.ala_audience_count_prefix), an.B(this.bkk.sh().audience_count)));
            }
        }
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        return this.cpG;
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
        if (this.bxd != null && this.bxd.getVideoView() != null) {
            this.bxd.getVideoView().stopPlayback();
            this.bxd.Pt();
            if (this.blf != null) {
                this.blf.stop();
            }
        }
        this.cpG = false;
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.bxd != null) {
            return this.bxd.getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.bkk == null || this.bkk.sg() == null) {
            return null;
        }
        return this.bkk.sg().video_url;
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.bxd == null || this.bxd.getVideoView() == null) {
            return 0;
        }
        return this.bxd.getVideoView().getCurrentPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afi() {
        if (this.bkk == null || this.bkk.sg() == null) {
        }
    }

    public void startPlayAnimation() {
        if (this.bxd != null) {
            this.bxd.startPlayAnimation();
        }
    }

    public void setAutoStartPlay(boolean z) {
        if (this.bxd != null) {
            this.bxd.setAutoStartPlay(z);
        }
    }
}
