package com.baidu.tieba.card.ala;

import android.view.View;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.f;
import com.baidu.tieba.play.f;
import com.baidu.tieba.play.j;
import com.baidu.tieba.play.n;
/* loaded from: classes2.dex */
public class a implements f {
    private AlaVideoContainer bHQ;
    private bb buy;
    private j bvs;
    private n bvt;
    private AlaInfoData cBE;
    private String cBF;
    private boolean cyG = false;
    private j.a cyQ = new j.a() { // from class: com.baidu.tieba.card.ala.a.1
        @Override // com.baidu.tieba.play.j.a
        public void aiR() {
            a.this.aiL();
        }
    };
    private String mForumName;

    public a(AlaVideoContainer alaVideoContainer) {
        this.bHQ = alaVideoContainer;
        if (this.bHQ != null) {
            this.bvs = new j();
            this.bvs.setPlayer(this.bHQ.getVideoView());
            this.bvs.a(this.cyQ);
            if (this.bHQ.getVideoView() != null) {
                this.bvt = new n(this.bHQ.getVideoView().getContext());
                this.bHQ.getVideoView().setBusiness(this.bvt);
            }
        }
    }

    public void a(bb bbVar, String str, String str2, boolean z) {
        this.cBF = str2;
        this.mForumName = str;
        if (bbVar != null) {
            this.buy = bbVar;
            if (this.bHQ != null && this.buy.vC() != null) {
                this.cBE = this.buy.vC();
                this.bHQ.setVideoThumbnail(this.cBE.cover);
                if (this.bvt != null && this.bvt.bkx() != null) {
                    this.bvt.bkx().b(this.cBE);
                }
                if (z) {
                    this.bHQ.setTitle(this.buy.getTitle());
                } else {
                    this.bHQ.setTitle("");
                }
                this.bHQ.setPlayCount(String.format(this.bHQ.getVideoView().getContext().getResources().getString(f.j.ala_audience_count_prefix), ap.H(this.buy.vC().audience_count)));
            }
        }
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        return this.cyG;
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
            this.bHQ.Ty();
            if (this.bvs != null) {
                this.bvs.stop();
            }
        }
        this.cyG = false;
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
        if (this.buy == null || this.buy.vB() == null) {
            return null;
        }
        return this.buy.vB().video_url;
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.bHQ == null || this.bHQ.getVideoView() == null) {
            return 0;
        }
        return this.bHQ.getVideoView().getCurrentPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiL() {
        if (this.buy == null || this.buy.vB() == null) {
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
