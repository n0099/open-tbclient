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
    private bd bZU;
    private AlaInfoData cZB;
    private String cZC;
    private j caQ;
    private n caR;
    private AlaVideoContainer cmc;
    private String mForumName;
    private boolean cWz = false;
    private j.a cWL = new j.a() { // from class: com.baidu.tieba.card.ala.a.1
        @Override // com.baidu.tieba.play.j.a
        public void alf() {
            a.this.akY();
        }
    };

    public a(AlaVideoContainer alaVideoContainer) {
        this.cmc = alaVideoContainer;
        if (this.cmc != null) {
            this.caQ = new j();
            this.caQ.setPlayer(this.cmc.getVideoView());
            this.caQ.a(this.cWL);
            if (this.cmc.getVideoView() != null) {
                this.caR = new n(this.cmc.getVideoView().getContext());
                this.cmc.getVideoView().setBusiness(this.caR);
            }
        }
    }

    public void a(bd bdVar, String str, String str2, boolean z) {
        this.cZC = str2;
        this.mForumName = str;
        if (bdVar != null) {
            this.bZU = bdVar;
            if (this.cmc != null && this.bZU.zG() != null) {
                this.cZB = this.bZU.zG();
                this.cmc.setVideoThumbnail(this.cZB.cover);
                if (this.caR != null && this.caR.blz() != null) {
                    this.caR.blz().b(this.cZB);
                }
                if (z) {
                    this.cmc.setTitle(this.bZU.getTitle());
                } else {
                    this.cmc.setTitle("");
                }
                this.cmc.setPlayCount(String.format(this.cmc.getVideoView().getContext().getResources().getString(d.j.ala_audience_count_prefix), am.J(this.bZU.zG().audience_count)));
            }
        }
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        return this.cWz;
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
        if (this.cmc != null && this.cmc.getVideoView() != null) {
            this.cmc.getVideoView().stopPlayback();
            this.cmc.WW();
            if (this.caQ != null) {
                this.caQ.stop();
            }
        }
        this.cWz = false;
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.cmc != null) {
            return this.cmc.getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.bZU == null || this.bZU.zF() == null) {
            return null;
        }
        return this.bZU.zF().video_url;
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.cmc == null || this.cmc.getVideoView() == null) {
            return 0;
        }
        return this.cmc.getVideoView().getCurrentPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akY() {
        if (this.bZU == null || this.bZU.zF() == null) {
        }
    }

    public void startPlayAnimation() {
        if (this.cmc != null) {
            this.cmc.startPlayAnimation();
        }
    }

    public void setAutoStartPlay(boolean z) {
        if (this.cmc != null) {
            this.cmc.setAutoStartPlay(z);
        }
    }
}
