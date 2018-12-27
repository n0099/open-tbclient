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
    private bb bNy;
    private j bOr;
    private n bOs;
    private AlaVideoContainer caO;
    private AlaInfoData dau;
    private String dav;
    private String mForumName;
    private boolean cXt = false;
    private j.a cXE = new j.a() { // from class: com.baidu.tieba.card.ala.a.1
        @Override // com.baidu.tieba.play.j.a
        public void aqi() {
            a.this.aqb();
        }
    };

    public a(AlaVideoContainer alaVideoContainer) {
        this.caO = alaVideoContainer;
        if (this.caO != null) {
            this.bOr = new j();
            this.bOr.setPlayer(this.caO.getVideoView());
            this.bOr.a(this.cXE);
            if (this.caO.getVideoView() != null) {
                this.bOs = new n(this.caO.getVideoView().getContext());
                this.caO.getVideoView().setBusiness(this.bOs);
            }
        }
    }

    public void a(bb bbVar, String str, String str2, boolean z) {
        this.dav = str2;
        this.mForumName = str;
        if (bbVar != null) {
            this.bNy = bbVar;
            if (this.caO != null && this.bNy.Aa() != null) {
                this.dau = this.bNy.Aa();
                this.caO.setVideoThumbnail(this.dau.cover);
                if (this.bOs != null && this.bOs.bss() != null) {
                    this.bOs.bss().b(this.dau);
                }
                if (z) {
                    this.caO.setTitle(this.bNy.getTitle());
                } else {
                    this.caO.setTitle("");
                }
                this.caO.setPlayCount(String.format(this.caO.getVideoView().getContext().getResources().getString(e.j.ala_audience_count_prefix), ao.X(this.bNy.Aa().audience_count)));
            }
        }
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        return this.cXt;
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
        if (this.caO != null && this.caO.getVideoView() != null) {
            this.caO.getVideoView().stopPlayback();
            this.caO.aal();
            if (this.bOr != null) {
                this.bOr.stop();
            }
        }
        this.cXt = false;
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.caO != null) {
            return this.caO.getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.bNy == null || this.bNy.zY() == null) {
            return null;
        }
        return this.bNy.zY().video_url;
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.caO == null || this.caO.getVideoView() == null) {
            return 0;
        }
        return this.caO.getVideoView().getCurrentPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqb() {
        if (this.bNy == null || this.bNy.zY() == null) {
        }
    }

    public void startPlayAnimation() {
        if (this.caO != null) {
            this.caO.startPlayAnimation();
        }
    }

    public void setAutoStartPlay(boolean z) {
        if (this.caO != null) {
            this.caO.setAutoStartPlay(z);
        }
    }
}
