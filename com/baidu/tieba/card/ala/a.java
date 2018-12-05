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
    private bb bNv;
    private j bOo;
    private n bOp;
    private boolean cUD = false;
    private j.a cUO = new j.a() { // from class: com.baidu.tieba.card.ala.a.1
        @Override // com.baidu.tieba.play.j.a
        public void apt() {
            a.this.apm();
        }
    };
    private AlaInfoData cXD;
    private String cXE;
    private AlaVideoContainer caL;
    private String mForumName;

    public a(AlaVideoContainer alaVideoContainer) {
        this.caL = alaVideoContainer;
        if (this.caL != null) {
            this.bOo = new j();
            this.bOo.setPlayer(this.caL.getVideoView());
            this.bOo.a(this.cUO);
            if (this.caL.getVideoView() != null) {
                this.bOp = new n(this.caL.getVideoView().getContext());
                this.caL.getVideoView().setBusiness(this.bOp);
            }
        }
    }

    public void a(bb bbVar, String str, String str2, boolean z) {
        this.cXE = str2;
        this.mForumName = str;
        if (bbVar != null) {
            this.bNv = bbVar;
            if (this.caL != null && this.bNv.Aa() != null) {
                this.cXD = this.bNv.Aa();
                this.caL.setVideoThumbnail(this.cXD.cover);
                if (this.bOp != null && this.bOp.brH() != null) {
                    this.bOp.brH().b(this.cXD);
                }
                if (z) {
                    this.caL.setTitle(this.bNv.getTitle());
                } else {
                    this.caL.setTitle("");
                }
                this.caL.setPlayCount(String.format(this.caL.getVideoView().getContext().getResources().getString(e.j.ala_audience_count_prefix), ao.W(this.bNv.Aa().audience_count)));
            }
        }
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        return this.cUD;
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
        if (this.caL != null && this.caL.getVideoView() != null) {
            this.caL.getVideoView().stopPlayback();
            this.caL.aaj();
            if (this.bOo != null) {
                this.bOo.stop();
            }
        }
        this.cUD = false;
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.caL != null) {
            return this.caL.getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.bNv == null || this.bNv.zY() == null) {
            return null;
        }
        return this.bNv.zY().video_url;
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.caL == null || this.caL.getVideoView() == null) {
            return 0;
        }
        return this.caL.getVideoView().getCurrentPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apm() {
        if (this.bNv == null || this.bNv.zY() == null) {
        }
    }

    public void startPlayAnimation() {
        if (this.caL != null) {
            this.caL.startPlayAnimation();
        }
    }

    public void setAutoStartPlay(boolean z) {
        if (this.caL != null) {
            this.caL.setAutoStartPlay(z);
        }
    }
}
