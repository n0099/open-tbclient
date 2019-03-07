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
    private bg bTk;
    private j dbh;
    private n dbi;
    private AlaVideoContainer dqB;
    private boolean ehU = false;
    private j.a eig = new j.a() { // from class: com.baidu.tieba.card.ala.a.1
        @Override // com.baidu.tieba.play.j.a
        public void qE() {
            a.this.aQo();
        }
    };
    private AlaInfoData ekT;
    private String ekU;
    private String mForumName;

    public a(AlaVideoContainer alaVideoContainer) {
        this.dqB = alaVideoContainer;
        if (this.dqB != null) {
            this.dbh = new j();
            this.dbh.setPlayer(this.dqB.getVideoView());
            this.dbh.a(this.eig);
            if (this.dqB.getVideoView() != null) {
                this.dbi = new n(this.dqB.getVideoView().getContext());
                this.dqB.getVideoView().setBusiness(this.dbi);
            }
        }
    }

    public void a(bg bgVar, String str, String str2, boolean z) {
        this.ekU = str2;
        this.mForumName = str;
        if (bgVar != null) {
            this.bTk = bgVar;
            if (this.dqB != null && this.bTk.Zk() != null) {
                this.ekT = this.bTk.Zk();
                this.dqB.setVideoThumbnail(this.ekT.cover);
                if (this.dbi != null && this.dbi.bTw() != null) {
                    this.dbi.bTw().b(this.ekT);
                }
                if (z) {
                    this.dqB.setTitle(this.bTk.getTitle());
                } else {
                    this.dqB.setTitle("");
                }
                this.dqB.setPlayCount(String.format(this.dqB.getVideoView().getContext().getResources().getString(d.j.ala_audience_count_prefix), ap.az(this.bTk.Zk().audience_count)));
            }
        }
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        return this.ehU;
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
        if (this.dqB != null && this.dqB.getVideoView() != null) {
            this.dqB.getVideoView().stopPlayback();
            this.dqB.aBk();
            if (this.dbh != null) {
                this.dbh.stop();
            }
        }
        this.ehU = false;
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.dqB != null) {
            return this.dqB.getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.bTk == null || this.bTk.Zi() == null) {
            return null;
        }
        return this.bTk.Zi().video_url;
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.dqB == null || this.dqB.getVideoView() == null) {
            return 0;
        }
        return this.dqB.getVideoView().getCurrentPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQo() {
        if (this.bTk == null || this.bTk.Zi() == null) {
        }
    }

    public void startPlayAnimation() {
        if (this.dqB != null) {
            this.dqB.startPlayAnimation();
        }
    }
}
