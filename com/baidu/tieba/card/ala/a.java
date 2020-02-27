package com.baidu.tieba.card.ala;

import android.view.View;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.play.f;
import com.baidu.tieba.play.j;
import com.baidu.tieba.play.n;
/* loaded from: classes8.dex */
public class a implements f {
    private bj NQ;
    private AlaVideoContainer eNn;
    private j ekX;
    private n ekY;
    private AlaInfoData fMn;
    private String fMo;
    private String mForumName;
    private boolean fJs = false;
    private j.a fJE = new j.a() { // from class: com.baidu.tieba.card.ala.a.1
        @Override // com.baidu.tieba.play.j.a
        public void lw() {
            a.this.buM();
        }
    };

    public a(AlaVideoContainer alaVideoContainer) {
        this.eNn = alaVideoContainer;
        if (this.eNn != null) {
            this.ekX = new j();
            this.ekX.setPlayer(this.eNn.getVideoView());
            this.ekX.a(this.fJE);
            if (this.eNn.getVideoView() != null) {
                this.ekY = new n(this.eNn.getVideoView().getContext());
                this.eNn.getVideoView().setBusiness(this.ekY);
            }
        }
    }

    public void a(bj bjVar, String str, String str2, boolean z) {
        this.fMo = str2;
        this.mForumName = str;
        if (bjVar != null) {
            this.NQ = bjVar;
            if (this.eNn != null && this.NQ.aCF() != null) {
                this.fMn = this.NQ.aCF();
                this.eNn.setVideoThumbnail(this.fMn.cover);
                if (this.ekY != null && this.ekY.cyX() != null) {
                    this.ekY.cyX().b(this.fMn);
                }
                if (z) {
                    this.eNn.setTitle(this.NQ.getTitle());
                } else {
                    this.eNn.setTitle("");
                }
                this.eNn.setPlayCount(String.format(this.eNn.getVideoView().getContext().getResources().getString(R.string.ala_audience_count_prefix), aq.numFormatOverWan(this.NQ.aCF().audience_count)));
            }
        }
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        return this.fJs;
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
        if (this.eNn != null && this.eNn.getVideoView() != null) {
            this.eNn.getVideoView().stopPlayback();
            this.eNn.bcm();
            if (this.ekX != null) {
                this.ekX.stop();
            }
        }
        this.fJs = false;
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.eNn != null) {
            return this.eNn.getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.NQ == null || this.NQ.aCD() == null) {
            return null;
        }
        return this.NQ.aCD().video_url;
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.eNn == null || this.eNn.getVideoView() == null) {
            return 0;
        }
        return this.eNn.getVideoView().getCurrentPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buM() {
        if (this.NQ == null || this.NQ.aCD() == null) {
        }
    }

    public void startPlayAnimation() {
        if (this.eNn != null) {
            this.eNn.startPlayAnimation();
        }
    }
}
