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
    private AlaVideoContainer dBh;
    private j dlN;
    private n dlO;
    private AlaInfoData eAr;
    private String eAs;
    private String mForumName;
    private boolean exq = false;
    private j.a exD = new j.a() { // from class: com.baidu.tieba.card.ala.a.1
        @Override // com.baidu.tieba.play.j.a
        public void pz() {
            a.this.aXy();
        }
    };

    public a(AlaVideoContainer alaVideoContainer) {
        this.dBh = alaVideoContainer;
        if (this.dBh != null) {
            this.dlN = new j();
            this.dlN.setPlayer(this.dBh.getVideoView());
            this.dlN.a(this.exD);
            if (this.dBh.getVideoView() != null) {
                this.dlO = new n(this.dBh.getVideoView().getContext());
                this.dBh.getVideoView().setBusiness(this.dlO);
            }
        }
    }

    public void a(bg bgVar, String str, String str2, boolean z) {
        this.eAs = str2;
        this.mForumName = str;
        if (bgVar != null) {
            this.cbg = bgVar;
            if (this.dBh != null && this.cbg.adO() != null) {
                this.eAr = this.cbg.adO();
                this.dBh.setVideoThumbnail(this.eAr.cover);
                if (this.dlO != null && this.dlO.cbz() != null) {
                    this.dlO.cbz().b(this.eAr);
                }
                if (z) {
                    this.dBh.setTitle(this.cbg.getTitle());
                } else {
                    this.dBh.setTitle("");
                }
                this.dBh.setPlayCount(String.format(this.dBh.getVideoView().getContext().getResources().getString(R.string.ala_audience_count_prefix), ap.aN(this.cbg.adO().audience_count)));
            }
        }
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        return this.exq;
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
        if (this.dBh != null && this.dBh.getVideoView() != null) {
            this.dBh.getVideoView().stopPlayback();
            this.dBh.aHB();
            if (this.dlN != null) {
                this.dlN.stop();
            }
        }
        this.exq = false;
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.dBh != null) {
            return this.dBh.getView();
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
        if (this.dBh == null || this.dBh.getVideoView() == null) {
            return 0;
        }
        return this.dBh.getVideoView().getCurrentPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXy() {
        if (this.cbg == null || this.cbg.adM() == null) {
        }
    }

    public void startPlayAnimation() {
        if (this.dBh != null) {
            this.dBh.startPlayAnimation();
        }
    }
}
