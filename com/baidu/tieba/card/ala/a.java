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
    private AlaVideoContainer eNo;
    private j ekY;
    private n ekZ;
    private AlaInfoData fMp;
    private String fMq;
    private String mForumName;
    private boolean fJu = false;
    private j.a fJG = new j.a() { // from class: com.baidu.tieba.card.ala.a.1
        @Override // com.baidu.tieba.play.j.a
        public void lw() {
            a.this.buO();
        }
    };

    public a(AlaVideoContainer alaVideoContainer) {
        this.eNo = alaVideoContainer;
        if (this.eNo != null) {
            this.ekY = new j();
            this.ekY.setPlayer(this.eNo.getVideoView());
            this.ekY.a(this.fJG);
            if (this.eNo.getVideoView() != null) {
                this.ekZ = new n(this.eNo.getVideoView().getContext());
                this.eNo.getVideoView().setBusiness(this.ekZ);
            }
        }
    }

    public void a(bj bjVar, String str, String str2, boolean z) {
        this.fMq = str2;
        this.mForumName = str;
        if (bjVar != null) {
            this.NQ = bjVar;
            if (this.eNo != null && this.NQ.aCH() != null) {
                this.fMp = this.NQ.aCH();
                this.eNo.setVideoThumbnail(this.fMp.cover);
                if (this.ekZ != null && this.ekZ.cyZ() != null) {
                    this.ekZ.cyZ().b(this.fMp);
                }
                if (z) {
                    this.eNo.setTitle(this.NQ.getTitle());
                } else {
                    this.eNo.setTitle("");
                }
                this.eNo.setPlayCount(String.format(this.eNo.getVideoView().getContext().getResources().getString(R.string.ala_audience_count_prefix), aq.numFormatOverWan(this.NQ.aCH().audience_count)));
            }
        }
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        return this.fJu;
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
        if (this.eNo != null && this.eNo.getVideoView() != null) {
            this.eNo.getVideoView().stopPlayback();
            this.eNo.bco();
            if (this.ekY != null) {
                this.ekY.stop();
            }
        }
        this.fJu = false;
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.eNo != null) {
            return this.eNo.getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.NQ == null || this.NQ.aCF() == null) {
            return null;
        }
        return this.NQ.aCF().video_url;
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.eNo == null || this.eNo.getVideoView() == null) {
            return 0;
        }
        return this.eNo.getVideoView().getCurrentPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buO() {
        if (this.NQ == null || this.NQ.aCF() == null) {
        }
    }

    public void startPlayAnimation() {
        if (this.eNo != null) {
            this.eNo.startPlayAnimation();
        }
    }
}
