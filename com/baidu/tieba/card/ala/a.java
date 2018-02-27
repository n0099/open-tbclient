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
    private bd bZR;
    private AlaInfoData cZy;
    private String cZz;
    private j caN;
    private n caO;
    private AlaVideoContainer clZ;
    private String mForumName;
    private boolean cWw = false;
    private j.a cWI = new j.a() { // from class: com.baidu.tieba.card.ala.a.1
        @Override // com.baidu.tieba.play.j.a
        public void ale() {
            a.this.akX();
        }
    };

    public a(AlaVideoContainer alaVideoContainer) {
        this.clZ = alaVideoContainer;
        if (this.clZ != null) {
            this.caN = new j();
            this.caN.setPlayer(this.clZ.getVideoView());
            this.caN.a(this.cWI);
            if (this.clZ.getVideoView() != null) {
                this.caO = new n(this.clZ.getVideoView().getContext());
                this.clZ.getVideoView().setBusiness(this.caO);
            }
        }
    }

    public void a(bd bdVar, String str, String str2, boolean z) {
        this.cZz = str2;
        this.mForumName = str;
        if (bdVar != null) {
            this.bZR = bdVar;
            if (this.clZ != null && this.bZR.zG() != null) {
                this.cZy = this.bZR.zG();
                this.clZ.setVideoThumbnail(this.cZy.cover);
                if (this.caO != null && this.caO.bly() != null) {
                    this.caO.bly().b(this.cZy);
                }
                if (z) {
                    this.clZ.setTitle(this.bZR.getTitle());
                } else {
                    this.clZ.setTitle("");
                }
                this.clZ.setPlayCount(String.format(this.clZ.getVideoView().getContext().getResources().getString(d.j.ala_audience_count_prefix), am.J(this.bZR.zG().audience_count)));
            }
        }
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        return this.cWw;
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
        if (this.clZ != null && this.clZ.getVideoView() != null) {
            this.clZ.getVideoView().stopPlayback();
            this.clZ.WV();
            if (this.caN != null) {
                this.caN.stop();
            }
        }
        this.cWw = false;
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.clZ != null) {
            return this.clZ.getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.bZR == null || this.bZR.zF() == null) {
            return null;
        }
        return this.bZR.zF().video_url;
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.clZ == null || this.clZ.getVideoView() == null) {
            return 0;
        }
        return this.clZ.getVideoView().getCurrentPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akX() {
        if (this.bZR == null || this.bZR.zF() == null) {
        }
    }

    public void startPlayAnimation() {
        if (this.clZ != null) {
            this.clZ.startPlayAnimation();
        }
    }

    public void setAutoStartPlay(boolean z) {
        if (this.clZ != null) {
            this.clZ.setAutoStartPlay(z);
        }
    }
}
