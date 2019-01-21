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
    private bb bOl;
    private j bPd;
    private n bPe;
    private boolean cYf = false;
    private j.a cYq = new j.a() { // from class: com.baidu.tieba.card.ala.a.1
        @Override // com.baidu.tieba.play.j.a
        public void aqF() {
            a.this.aqy();
        }
    };
    private AlaVideoContainer cbA;
    private AlaInfoData dbh;
    private String dbi;
    private String mForumName;

    public a(AlaVideoContainer alaVideoContainer) {
        this.cbA = alaVideoContainer;
        if (this.cbA != null) {
            this.bPd = new j();
            this.bPd.setPlayer(this.cbA.getVideoView());
            this.bPd.a(this.cYq);
            if (this.cbA.getVideoView() != null) {
                this.bPe = new n(this.cbA.getVideoView().getContext());
                this.cbA.getVideoView().setBusiness(this.bPe);
            }
        }
    }

    public void a(bb bbVar, String str, String str2, boolean z) {
        this.dbi = str2;
        this.mForumName = str;
        if (bbVar != null) {
            this.bOl = bbVar;
            if (this.cbA != null && this.bOl.An() != null) {
                this.dbh = this.bOl.An();
                this.cbA.setVideoThumbnail(this.dbh.cover);
                if (this.bPe != null && this.bPe.btb() != null) {
                    this.bPe.btb().b(this.dbh);
                }
                if (z) {
                    this.cbA.setTitle(this.bOl.getTitle());
                } else {
                    this.cbA.setTitle("");
                }
                this.cbA.setPlayCount(String.format(this.cbA.getVideoView().getContext().getResources().getString(e.j.ala_audience_count_prefix), ao.X(this.bOl.An().audience_count)));
            }
        }
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        return this.cYf;
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
        if (this.cbA != null && this.cbA.getVideoView() != null) {
            this.cbA.getVideoView().stopPlayback();
            this.cbA.aaI();
            if (this.bPd != null) {
                this.bPd.stop();
            }
        }
        this.cYf = false;
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.cbA != null) {
            return this.cbA.getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.bOl == null || this.bOl.Al() == null) {
            return null;
        }
        return this.bOl.Al().video_url;
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.cbA == null || this.cbA.getVideoView() == null) {
            return 0;
        }
        return this.cbA.getVideoView().getCurrentPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqy() {
        if (this.bOl == null || this.bOl.Al() == null) {
        }
    }

    public void startPlayAnimation() {
        if (this.cbA != null) {
            this.cbA.startPlayAnimation();
        }
    }

    public void setAutoStartPlay(boolean z) {
        if (this.cbA != null) {
            this.cbA.setAutoStartPlay(z);
        }
    }
}
