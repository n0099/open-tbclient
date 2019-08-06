package com.baidu.tieba.card.ala;

import android.view.View;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.play.f;
import com.baidu.tieba.play.j;
import com.baidu.tieba.play.n;
/* loaded from: classes3.dex */
public class a implements f {
    private bh ccq;
    private AlaVideoContainer dEK;
    private j dnC;
    private n dnD;
    private AlaInfoData eFu;
    private String eFv;
    private String mForumName;
    private boolean eCw = false;
    private j.a eCI = new j.a() { // from class: com.baidu.tieba.card.ala.a.1
        @Override // com.baidu.tieba.play.j.a
        public void pU() {
            a.this.aZx();
        }
    };

    public a(AlaVideoContainer alaVideoContainer) {
        this.dEK = alaVideoContainer;
        if (this.dEK != null) {
            this.dnC = new j();
            this.dnC.setPlayer(this.dEK.getVideoView());
            this.dnC.a(this.eCI);
            if (this.dEK.getVideoView() != null) {
                this.dnD = new n(this.dEK.getVideoView().getContext());
                this.dEK.getVideoView().setBusiness(this.dnD);
            }
        }
    }

    public void a(bh bhVar, String str, String str2, boolean z) {
        this.eFv = str2;
        this.mForumName = str;
        if (bhVar != null) {
            this.ccq = bhVar;
            if (this.dEK != null && this.ccq.aeR() != null) {
                this.eFu = this.ccq.aeR();
                this.dEK.setVideoThumbnail(this.eFu.cover);
                if (this.dnD != null && this.dnD.ceI() != null) {
                    this.dnD.ceI().b(this.eFu);
                }
                if (z) {
                    this.dEK.setTitle(this.ccq.getTitle());
                } else {
                    this.dEK.setTitle("");
                }
                this.dEK.setPlayCount(String.format(this.dEK.getVideoView().getContext().getResources().getString(R.string.ala_audience_count_prefix), aq.aO(this.ccq.aeR().audience_count)));
            }
        }
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        return this.eCw;
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
        if (this.dEK != null && this.dEK.getVideoView() != null) {
            this.dEK.getVideoView().cey();
            this.dEK.aJa();
            if (this.dnC != null) {
                this.dnC.stop();
            }
        }
        this.eCw = false;
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.dEK != null) {
            return this.dEK.getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.ccq == null || this.ccq.aeP() == null) {
            return null;
        }
        return this.ccq.aeP().video_url;
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.dEK == null || this.dEK.getVideoView() == null) {
            return 0;
        }
        return this.dEK.getVideoView().getCurrentPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZx() {
        if (this.ccq == null || this.ccq.aeP() == null) {
        }
    }

    public void startPlayAnimation() {
        if (this.dEK != null) {
            this.dEK.startPlayAnimation();
        }
    }
}
