package com.baidu.tieba.card.ala;

import android.view.View;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.play.f;
import com.baidu.tieba.play.j;
import com.baidu.tieba.play.n;
/* loaded from: classes6.dex */
public class a implements f {
    private bj Np;
    private AlaVideoContainer eJt;
    private j egT;
    private n egU;
    private boolean fGV = false;
    private j.a fHh = new j.a() { // from class: com.baidu.tieba.card.ala.a.1
        @Override // com.baidu.tieba.play.j.a
        public void lh() {
            a.this.bti();
        }
    };
    private AlaInfoData fJQ;
    private String fJR;
    private String mForumName;

    public a(AlaVideoContainer alaVideoContainer) {
        this.eJt = alaVideoContainer;
        if (this.eJt != null) {
            this.egT = new j();
            this.egT.setPlayer(this.eJt.getVideoView());
            this.egT.a(this.fHh);
            if (this.eJt.getVideoView() != null) {
                this.egU = new n(this.eJt.getVideoView().getContext());
                this.eJt.getVideoView().setBusiness(this.egU);
            }
        }
    }

    public void a(bj bjVar, String str, String str2, boolean z) {
        this.fJR = str2;
        this.mForumName = str;
        if (bjVar != null) {
            this.Np = bjVar;
            if (this.eJt != null && this.Np.aAq() != null) {
                this.fJQ = this.Np.aAq();
                this.eJt.setVideoThumbnail(this.fJQ.cover);
                if (this.egU != null && this.egU.cxB() != null) {
                    this.egU.cxB().b(this.fJQ);
                }
                if (z) {
                    this.eJt.setTitle(this.Np.getTitle());
                } else {
                    this.eJt.setTitle("");
                }
                this.eJt.setPlayCount(String.format(this.eJt.getVideoView().getContext().getResources().getString(R.string.ala_audience_count_prefix), aq.numFormatOverWan(this.Np.aAq().audience_count)));
            }
        }
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        return this.fGV;
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
        if (this.eJt != null && this.eJt.getVideoView() != null) {
            this.eJt.getVideoView().stopPlayback();
            this.eJt.aZW();
            if (this.egT != null) {
                this.egT.stop();
            }
        }
        this.fGV = false;
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.eJt != null) {
            return this.eJt.getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.Np == null || this.Np.aAo() == null) {
            return null;
        }
        return this.Np.aAo().video_url;
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.eJt == null || this.eJt.getVideoView() == null) {
            return 0;
        }
        return this.eJt.getVideoView().getCurrentPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bti() {
        if (this.Np == null || this.Np.aAo() == null) {
        }
    }

    public void startPlayAnimation() {
        if (this.eJt != null) {
            this.eJt.startPlayAnimation();
        }
    }
}
