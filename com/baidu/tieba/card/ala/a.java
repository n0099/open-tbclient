package com.baidu.tieba.card.ala;

import android.view.View;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.play.f;
import com.baidu.tieba.play.j;
import com.baidu.tieba.play.n;
/* loaded from: classes3.dex */
public class a implements f {
    private bg cbg;
    private AlaVideoContainer dBg;
    private j dlM;
    private n dlN;
    private AlaInfoData eAq;
    private String eAr;
    private String mForumName;
    private boolean exp = false;
    private j.a exC = new j.a() { // from class: com.baidu.tieba.card.ala.a.1
        @Override // com.baidu.tieba.play.j.a
        public void pz() {
            a.this.aXv();
        }
    };

    public a(AlaVideoContainer alaVideoContainer) {
        this.dBg = alaVideoContainer;
        if (this.dBg != null) {
            this.dlM = new j();
            this.dlM.setPlayer(this.dBg.getVideoView());
            this.dlM.a(this.exC);
            if (this.dBg.getVideoView() != null) {
                this.dlN = new n(this.dBg.getVideoView().getContext());
                this.dBg.getVideoView().setBusiness(this.dlN);
            }
        }
    }

    public void a(bg bgVar, String str, String str2, boolean z) {
        this.eAr = str2;
        this.mForumName = str;
        if (bgVar != null) {
            this.cbg = bgVar;
            if (this.dBg != null && this.cbg.adO() != null) {
                this.eAq = this.cbg.adO();
                this.dBg.setVideoThumbnail(this.eAq.cover);
                if (this.dlN != null && this.dlN.cbw() != null) {
                    this.dlN.cbw().b(this.eAq);
                }
                if (z) {
                    this.dBg.setTitle(this.cbg.getTitle());
                } else {
                    this.dBg.setTitle("");
                }
                this.dBg.setPlayCount(String.format(this.dBg.getVideoView().getContext().getResources().getString(R.string.ala_audience_count_prefix), ap.aN(this.cbg.adO().audience_count)));
            }
        }
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        return this.exp;
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
        if (this.dBg != null && this.dBg.getVideoView() != null) {
            this.dBg.getVideoView().stopPlayback();
            this.dBg.aHy();
            if (this.dlM != null) {
                this.dlM.stop();
            }
        }
        this.exp = false;
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.dBg != null) {
            return this.dBg.getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.cbg == null || this.cbg.adM() == null) {
            return null;
        }
        return this.cbg.adM().video_url;
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.dBg == null || this.dBg.getVideoView() == null) {
            return 0;
        }
        return this.dBg.getVideoView().getCurrentPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXv() {
        if (this.cbg == null || this.cbg.adM() == null) {
        }
    }

    public void startPlayAnimation() {
        if (this.dBg != null) {
            this.dBg.startPlayAnimation();
        }
    }
}
