package com.baidu.tieba.card.ala;

import android.view.View;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.d;
import com.baidu.tieba.play.f;
import com.baidu.tieba.play.j;
import com.baidu.tieba.play.n;
/* loaded from: classes2.dex */
public class a implements f {
    private AlaVideoContainer bHQ;
    private bb buw;
    private j bvq;
    private n bvr;
    private AlaInfoData cBH;
    private String cBI;
    private boolean cyJ = false;
    private j.a cyT = new j.a() { // from class: com.baidu.tieba.card.ala.a.1
        @Override // com.baidu.tieba.play.j.a
        public void aiO() {
            a.this.aiI();
        }
    };
    private String mForumName;

    public a(AlaVideoContainer alaVideoContainer) {
        this.bHQ = alaVideoContainer;
        if (this.bHQ != null) {
            this.bvq = new j();
            this.bvq.setPlayer(this.bHQ.getVideoView());
            this.bvq.a(this.cyT);
            if (this.bHQ.getVideoView() != null) {
                this.bvr = new n(this.bHQ.getVideoView().getContext());
                this.bHQ.getVideoView().setBusiness(this.bvr);
            }
        }
    }

    public void a(bb bbVar, String str, String str2, boolean z) {
        this.cBI = str2;
        this.mForumName = str;
        if (bbVar != null) {
            this.buw = bbVar;
            if (this.bHQ != null && this.buw.vD() != null) {
                this.cBH = this.buw.vD();
                this.bHQ.setVideoThumbnail(this.cBH.cover);
                if (this.bvr != null && this.bvr.bkA() != null) {
                    this.bvr.bkA().b(this.cBH);
                }
                if (z) {
                    this.bHQ.setTitle(this.buw.getTitle());
                } else {
                    this.bHQ.setTitle("");
                }
                this.bHQ.setPlayCount(String.format(this.bHQ.getVideoView().getContext().getResources().getString(d.j.ala_audience_count_prefix), ap.H(this.buw.vD().audience_count)));
            }
        }
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        return this.cyJ;
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
        if (this.bHQ != null && this.bHQ.getVideoView() != null) {
            this.bHQ.getVideoView().stopPlayback();
            this.bHQ.Tv();
            if (this.bvq != null) {
                this.bvq.stop();
            }
        }
        this.cyJ = false;
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.bHQ != null) {
            return this.bHQ.getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.buw == null || this.buw.vC() == null) {
            return null;
        }
        return this.buw.vC().video_url;
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.bHQ == null || this.bHQ.getVideoView() == null) {
            return 0;
        }
        return this.bHQ.getVideoView().getCurrentPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiI() {
        if (this.buw == null || this.buw.vC() == null) {
        }
    }

    public void startPlayAnimation() {
        if (this.bHQ != null) {
            this.bHQ.startPlayAnimation();
        }
    }

    public void setAutoStartPlay(boolean z) {
        if (this.bHQ != null) {
            this.bHQ.setAutoStartPlay(z);
        }
    }
}
