package com.baidu.tieba.card.ala;

import android.view.View;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.d;
import com.baidu.tieba.play.f;
import com.baidu.tieba.play.j;
import com.baidu.tieba.play.n;
/* loaded from: classes3.dex */
public class a implements f {
    private bg bTl;
    private j dbd;
    private n dbe;
    private AlaVideoContainer dqx;
    private boolean ehQ = false;
    private j.a eic = new j.a() { // from class: com.baidu.tieba.card.ala.a.1
        @Override // com.baidu.tieba.play.j.a
        public void qE() {
            a.this.aQo();
        }
    };
    private AlaInfoData ekP;
    private String ekQ;
    private String mForumName;

    public a(AlaVideoContainer alaVideoContainer) {
        this.dqx = alaVideoContainer;
        if (this.dqx != null) {
            this.dbd = new j();
            this.dbd.setPlayer(this.dqx.getVideoView());
            this.dbd.a(this.eic);
            if (this.dqx.getVideoView() != null) {
                this.dbe = new n(this.dqx.getVideoView().getContext());
                this.dqx.getVideoView().setBusiness(this.dbe);
            }
        }
    }

    public void a(bg bgVar, String str, String str2, boolean z) {
        this.ekQ = str2;
        this.mForumName = str;
        if (bgVar != null) {
            this.bTl = bgVar;
            if (this.dqx != null && this.bTl.Zk() != null) {
                this.ekP = this.bTl.Zk();
                this.dqx.setVideoThumbnail(this.ekP.cover);
                if (this.dbe != null && this.dbe.bTz() != null) {
                    this.dbe.bTz().b(this.ekP);
                }
                if (z) {
                    this.dqx.setTitle(this.bTl.getTitle());
                } else {
                    this.dqx.setTitle("");
                }
                this.dqx.setPlayCount(String.format(this.dqx.getVideoView().getContext().getResources().getString(d.j.ala_audience_count_prefix), ap.az(this.bTl.Zk().audience_count)));
            }
        }
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        return this.ehQ;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        return false;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.dqx != null && this.dqx.getVideoView() != null) {
            this.dqx.getVideoView().stopPlayback();
            this.dqx.aBk();
            if (this.dbd != null) {
                this.dbd.stop();
            }
        }
        this.ehQ = false;
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.dqx != null) {
            return this.dqx.getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.bTl == null || this.bTl.Zi() == null) {
            return null;
        }
        return this.bTl.Zi().video_url;
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.dqx == null || this.dqx.getVideoView() == null) {
            return 0;
        }
        return this.dqx.getVideoView().getCurrentPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQo() {
        if (this.bTl == null || this.bTl.Zi() == null) {
        }
    }

    public void startPlayAnimation() {
        if (this.dqx != null) {
            this.dqx.startPlayAnimation();
        }
    }
}
