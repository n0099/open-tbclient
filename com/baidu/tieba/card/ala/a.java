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
    private bb bOk;
    private j bPc;
    private n bPd;
    private boolean cYe = false;
    private j.a cYp = new j.a() { // from class: com.baidu.tieba.card.ala.a.1
        @Override // com.baidu.tieba.play.j.a
        public void aqF() {
            a.this.aqy();
        }
    };
    private AlaVideoContainer cbz;
    private AlaInfoData dbg;
    private String dbh;
    private String mForumName;

    public a(AlaVideoContainer alaVideoContainer) {
        this.cbz = alaVideoContainer;
        if (this.cbz != null) {
            this.bPc = new j();
            this.bPc.setPlayer(this.cbz.getVideoView());
            this.bPc.a(this.cYp);
            if (this.cbz.getVideoView() != null) {
                this.bPd = new n(this.cbz.getVideoView().getContext());
                this.cbz.getVideoView().setBusiness(this.bPd);
            }
        }
    }

    public void a(bb bbVar, String str, String str2, boolean z) {
        this.dbh = str2;
        this.mForumName = str;
        if (bbVar != null) {
            this.bOk = bbVar;
            if (this.cbz != null && this.bOk.An() != null) {
                this.dbg = this.bOk.An();
                this.cbz.setVideoThumbnail(this.dbg.cover);
                if (this.bPd != null && this.bPd.btb() != null) {
                    this.bPd.btb().b(this.dbg);
                }
                if (z) {
                    this.cbz.setTitle(this.bOk.getTitle());
                } else {
                    this.cbz.setTitle("");
                }
                this.cbz.setPlayCount(String.format(this.cbz.getVideoView().getContext().getResources().getString(e.j.ala_audience_count_prefix), ao.X(this.bOk.An().audience_count)));
            }
        }
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        return this.cYe;
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
        if (this.cbz != null && this.cbz.getVideoView() != null) {
            this.cbz.getVideoView().stopPlayback();
            this.cbz.aaI();
            if (this.bPc != null) {
                this.bPc.stop();
            }
        }
        this.cYe = false;
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.cbz != null) {
            return this.cbz.getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.bOk == null || this.bOk.Al() == null) {
            return null;
        }
        return this.bOk.Al().video_url;
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.cbz == null || this.cbz.getVideoView() == null) {
            return 0;
        }
        return this.cbz.getVideoView().getCurrentPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqy() {
        if (this.bOk == null || this.bOk.Al() == null) {
        }
    }

    public void startPlayAnimation() {
        if (this.cbz != null) {
            this.cbz.startPlayAnimation();
        }
    }

    public void setAutoStartPlay(boolean z) {
        if (this.cbz != null) {
            this.cbz.setAutoStartPlay(z);
        }
    }
}
