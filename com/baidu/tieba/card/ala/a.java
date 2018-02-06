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
    private boolean cWI = false;
    private j.a cWU = new j.a() { // from class: com.baidu.tieba.card.ala.a.1
        @Override // com.baidu.tieba.play.j.a
        public void alf() {
            a.this.akY();
        }
    };
    private AlaInfoData cZK;
    private String cZL;
    private j caZ;
    private bd cad;
    private n cba;
    private AlaVideoContainer cmm;
    private String mForumName;

    public a(AlaVideoContainer alaVideoContainer) {
        this.cmm = alaVideoContainer;
        if (this.cmm != null) {
            this.caZ = new j();
            this.caZ.setPlayer(this.cmm.getVideoView());
            this.caZ.a(this.cWU);
            if (this.cmm.getVideoView() != null) {
                this.cba = new n(this.cmm.getVideoView().getContext());
                this.cmm.getVideoView().setBusiness(this.cba);
            }
        }
    }

    public void a(bd bdVar, String str, String str2, boolean z) {
        this.cZL = str2;
        this.mForumName = str;
        if (bdVar != null) {
            this.cad = bdVar;
            if (this.cmm != null && this.cad.zG() != null) {
                this.cZK = this.cad.zG();
                this.cmm.setVideoThumbnail(this.cZK.cover);
                if (this.cba != null && this.cba.blz() != null) {
                    this.cba.blz().b(this.cZK);
                }
                if (z) {
                    this.cmm.setTitle(this.cad.getTitle());
                } else {
                    this.cmm.setTitle("");
                }
                this.cmm.setPlayCount(String.format(this.cmm.getVideoView().getContext().getResources().getString(d.j.ala_audience_count_prefix), am.J(this.cad.zG().audience_count)));
            }
        }
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        return this.cWI;
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
        if (this.cmm != null && this.cmm.getVideoView() != null) {
            this.cmm.getVideoView().stopPlayback();
            this.cmm.WW();
            if (this.caZ != null) {
                this.caZ.stop();
            }
        }
        this.cWI = false;
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.cmm != null) {
            return this.cmm.getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.cad == null || this.cad.zF() == null) {
            return null;
        }
        return this.cad.zF().video_url;
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.cmm == null || this.cmm.getVideoView() == null) {
            return 0;
        }
        return this.cmm.getVideoView().getCurrentPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akY() {
        if (this.cad == null || this.cad.zF() == null) {
        }
    }

    public void startPlayAnimation() {
        if (this.cmm != null) {
            this.cmm.startPlayAnimation();
        }
    }

    public void setAutoStartPlay(boolean z) {
        if (this.cmm != null) {
            this.cmm.setAutoStartPlay(z);
        }
    }
}
