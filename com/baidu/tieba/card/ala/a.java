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
    private bh cdk;
    private AlaVideoContainer dGv;
    private j dpo;
    private n dpp;
    private boolean eEf = false;
    private j.a eEr = new j.a() { // from class: com.baidu.tieba.card.ala.a.1
        @Override // com.baidu.tieba.play.j.a
        public void pV() {
            a.this.bab();
        }
    };
    private AlaInfoData eHd;
    private String eHe;
    private String mForumName;

    public a(AlaVideoContainer alaVideoContainer) {
        this.dGv = alaVideoContainer;
        if (this.dGv != null) {
            this.dpo = new j();
            this.dpo.setPlayer(this.dGv.getVideoView());
            this.dpo.a(this.eEr);
            if (this.dGv.getVideoView() != null) {
                this.dpp = new n(this.dGv.getVideoView().getContext());
                this.dGv.getVideoView().setBusiness(this.dpp);
            }
        }
    }

    public void a(bh bhVar, String str, String str2, boolean z) {
        this.eHe = str2;
        this.mForumName = str;
        if (bhVar != null) {
            this.cdk = bhVar;
            if (this.dGv != null && this.cdk.aeV() != null) {
                this.eHd = this.cdk.aeV();
                this.dGv.setVideoThumbnail(this.eHd.cover);
                if (this.dpp != null && this.dpp.cfw() != null) {
                    this.dpp.cfw().b(this.eHd);
                }
                if (z) {
                    this.dGv.setTitle(this.cdk.getTitle());
                } else {
                    this.dGv.setTitle("");
                }
                this.dGv.setPlayCount(String.format(this.dGv.getVideoView().getContext().getResources().getString(R.string.ala_audience_count_prefix), aq.aO(this.cdk.aeV().audience_count)));
            }
        }
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        return this.eEf;
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
        if (this.dGv != null && this.dGv.getVideoView() != null) {
            this.dGv.getVideoView().stopPlayback();
            this.dGv.aJE();
            if (this.dpo != null) {
                this.dpo.stop();
            }
        }
        this.eEf = false;
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.dGv != null) {
            return this.dGv.getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.cdk == null || this.cdk.aeT() == null) {
            return null;
        }
        return this.cdk.aeT().video_url;
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.dGv == null || this.dGv.getVideoView() == null) {
            return 0;
        }
        return this.dGv.getVideoView().getCurrentPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bab() {
        if (this.cdk == null || this.cdk.aeT() == null) {
        }
    }

    public void startPlayAnimation() {
        if (this.dGv != null) {
            this.dGv.startPlayAnimation();
        }
    }
}
