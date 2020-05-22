package com.baidu.tieba.card.ala;

import android.view.View;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.play.f;
import com.baidu.tieba.play.j;
import com.baidu.tieba.play.n;
/* loaded from: classes8.dex */
public class a implements f {
    private bk ahg;
    private AlaVideoContainer fGq;
    private j fbN;
    private n fbO;
    private boolean gDR = false;
    private j.a gEd = new j.a() { // from class: com.baidu.tieba.card.ala.a.1
        @Override // com.baidu.tieba.play.j.a
        public void qg() {
            a.this.bKY();
        }
    };
    private AlaInfoData gGM;
    private String gGN;
    private String mForumName;

    public a(AlaVideoContainer alaVideoContainer) {
        this.fGq = alaVideoContainer;
        if (this.fGq != null) {
            this.fbN = new j();
            this.fbN.setPlayer(this.fGq.getVideoView());
            this.fbN.a(this.gEd);
            if (this.fGq.getVideoView() != null) {
                this.fbO = new n(this.fGq.getVideoView().getContext());
                this.fGq.getVideoView().setBusiness(this.fbO);
            }
        }
    }

    public void a(bk bkVar, String str, String str2, boolean z) {
        this.gGN = str2;
        this.mForumName = str;
        if (bkVar != null) {
            this.ahg = bkVar;
            if (this.fGq != null && this.ahg.aQS() != null) {
                this.gGM = this.ahg.aQS();
                this.fGq.setVideoThumbnail(this.gGM.cover);
                if (this.fbO != null && this.fbO.cQV() != null) {
                    this.fbO.cQV().c(this.gGM);
                }
                if (z) {
                    this.fGq.setTitle(this.ahg.getTitle());
                } else {
                    this.fGq.setTitle("");
                }
                this.fGq.setPlayCount(String.format(this.fGq.getVideoView().getContext().getResources().getString(R.string.ala_audience_count_prefix), aq.numFormatOverWan(this.ahg.aQS().audience_count)));
            }
        }
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        return this.gDR;
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
        if (this.fGq != null && this.fGq.getVideoView() != null) {
            this.fGq.getVideoView().stopPlayback();
            this.fGq.bqE();
            if (this.fbN != null) {
                this.fbN.stop();
            }
        }
        this.gDR = false;
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.fGq != null) {
            return this.fGq.getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.ahg == null || this.ahg.aQQ() == null) {
            return null;
        }
        return this.ahg.aQQ().video_url;
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.fGq == null || this.fGq.getVideoView() == null) {
            return 0;
        }
        return this.fGq.getVideoView().getCurrentPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKY() {
        if (this.ahg == null || this.ahg.aQQ() == null) {
        }
    }

    public void startPlayAnimation() {
        if (this.fGq != null) {
            this.fGq.startPlayAnimation();
        }
    }
}
