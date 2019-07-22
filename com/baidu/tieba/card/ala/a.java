package com.baidu.tieba.card.ala;

import android.view.View;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.play.f;
import com.baidu.tieba.play.j;
import com.baidu.tieba.play.n;
/* loaded from: classes3.dex */
public class a implements f {
    private bg ccj;
    private AlaVideoContainer dED;
    private j dnv;
    private n dnw;
    private AlaInfoData eFn;
    private String eFo;
    private String mForumName;
    private boolean eCp = false;
    private j.a eCB = new j.a() { // from class: com.baidu.tieba.card.ala.a.1
        @Override // com.baidu.tieba.play.j.a
        public void pU() {
            a.this.aZv();
        }
    };

    public a(AlaVideoContainer alaVideoContainer) {
        this.dED = alaVideoContainer;
        if (this.dED != null) {
            this.dnv = new j();
            this.dnv.setPlayer(this.dED.getVideoView());
            this.dnv.a(this.eCB);
            if (this.dED.getVideoView() != null) {
                this.dnw = new n(this.dED.getVideoView().getContext());
                this.dED.getVideoView().setBusiness(this.dnw);
            }
        }
    }

    public void a(bg bgVar, String str, String str2, boolean z) {
        this.eFo = str2;
        this.mForumName = str;
        if (bgVar != null) {
            this.ccj = bgVar;
            if (this.dED != null && this.ccj.aeQ() != null) {
                this.eFn = this.ccj.aeQ();
                this.dED.setVideoThumbnail(this.eFn.cover);
                if (this.dnw != null && this.dnw.ceq() != null) {
                    this.dnw.ceq().b(this.eFn);
                }
                if (z) {
                    this.dED.setTitle(this.ccj.getTitle());
                } else {
                    this.dED.setTitle("");
                }
                this.dED.setPlayCount(String.format(this.dED.getVideoView().getContext().getResources().getString(R.string.ala_audience_count_prefix), aq.aO(this.ccj.aeQ().audience_count)));
            }
        }
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        return this.eCp;
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
        if (this.dED != null && this.dED.getVideoView() != null) {
            this.dED.getVideoView().ceg();
            this.dED.aIY();
            if (this.dnv != null) {
                this.dnv.stop();
            }
        }
        this.eCp = false;
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.dED != null) {
            return this.dED.getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.ccj == null || this.ccj.aeO() == null) {
            return null;
        }
        return this.ccj.aeO().video_url;
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.dED == null || this.dED.getVideoView() == null) {
            return 0;
        }
        return this.dED.getVideoView().getCurrentPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZv() {
        if (this.ccj == null || this.ccj.aeO() == null) {
        }
    }

    public void startPlayAnimation() {
        if (this.dED != null) {
            this.dED.startPlayAnimation();
        }
    }
}
