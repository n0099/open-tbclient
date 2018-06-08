package com.baidu.tieba.card.ala;

import android.view.View;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.d;
import com.baidu.tieba.play.f;
import com.baidu.tieba.play.j;
import com.baidu.tieba.play.n;
/* loaded from: classes2.dex */
public class a implements f {
    private AlaVideoContainer bFg;
    private bd bso;
    private j btj;
    private n btk;
    private AlaInfoData cBi;
    private String cBj;
    private boolean cyj = false;
    private j.a cyw = new j.a() { // from class: com.baidu.tieba.card.ala.a.1
        @Override // com.baidu.tieba.play.j.a
        public void aiX() {
            a.this.aiR();
        }
    };
    private String mForumName;

    public a(AlaVideoContainer alaVideoContainer) {
        this.bFg = alaVideoContainer;
        if (this.bFg != null) {
            this.btj = new j();
            this.btj.setPlayer(this.bFg.getVideoView());
            this.btj.a(this.cyw);
            if (this.bFg.getVideoView() != null) {
                this.btk = new n(this.bFg.getVideoView().getContext());
                this.bFg.getVideoView().setBusiness(this.btk);
            }
        }
    }

    public void a(bd bdVar, String str, String str2, boolean z) {
        this.cBj = str2;
        this.mForumName = str;
        if (bdVar != null) {
            this.bso = bdVar;
            if (this.bFg != null && this.bso.vE() != null) {
                this.cBi = this.bso.vE();
                this.bFg.setVideoThumbnail(this.cBi.cover);
                if (this.btk != null && this.btk.blD() != null) {
                    this.btk.blD().b(this.cBi);
                }
                if (z) {
                    this.bFg.setTitle(this.bso.getTitle());
                } else {
                    this.bFg.setTitle("");
                }
                this.bFg.setPlayCount(String.format(this.bFg.getVideoView().getContext().getResources().getString(d.k.ala_audience_count_prefix), ao.E(this.bso.vE().audience_count)));
            }
        }
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        return this.cyj;
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
        if (this.bFg != null && this.bFg.getVideoView() != null) {
            this.bFg.getVideoView().stopPlayback();
            this.bFg.SR();
            if (this.btj != null) {
                this.btj.stop();
            }
        }
        this.cyj = false;
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.bFg != null) {
            return this.bFg.getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.bso == null || this.bso.vD() == null) {
            return null;
        }
        return this.bso.vD().video_url;
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.bFg == null || this.bFg.getVideoView() == null) {
            return 0;
        }
        return this.bFg.getVideoView().getCurrentPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiR() {
        if (this.bso == null || this.bso.vD() == null) {
        }
    }

    public void startPlayAnimation() {
        if (this.bFg != null) {
            this.bFg.startPlayAnimation();
        }
    }

    public void setAutoStartPlay(boolean z) {
        if (this.bFg != null) {
            this.bFg.setAutoStartPlay(z);
        }
    }
}
