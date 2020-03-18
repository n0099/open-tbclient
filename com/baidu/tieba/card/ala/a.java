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
    private bj NR;
    private AlaVideoContainer eNZ;
    private j elB;
    private n elC;
    private AlaInfoData fNk;
    private String fNl;
    private String mForumName;
    private boolean fKp = false;
    private j.a fKB = new j.a() { // from class: com.baidu.tieba.card.ala.a.1
        @Override // com.baidu.tieba.play.j.a
        public void lw() {
            a.this.buU();
        }
    };

    public a(AlaVideoContainer alaVideoContainer) {
        this.eNZ = alaVideoContainer;
        if (this.eNZ != null) {
            this.elB = new j();
            this.elB.setPlayer(this.eNZ.getVideoView());
            this.elB.a(this.fKB);
            if (this.eNZ.getVideoView() != null) {
                this.elC = new n(this.eNZ.getVideoView().getContext());
                this.eNZ.getVideoView().setBusiness(this.elC);
            }
        }
    }

    public void a(bj bjVar, String str, String str2, boolean z) {
        this.fNl = str2;
        this.mForumName = str;
        if (bjVar != null) {
            this.NR = bjVar;
            if (this.eNZ != null && this.NR.aCK() != null) {
                this.fNk = this.NR.aCK();
                this.eNZ.setVideoThumbnail(this.fNk.cover);
                if (this.elC != null && this.elC.czt() != null) {
                    this.elC.czt().b(this.fNk);
                }
                if (z) {
                    this.eNZ.setTitle(this.NR.getTitle());
                } else {
                    this.eNZ.setTitle("");
                }
                this.eNZ.setPlayCount(String.format(this.eNZ.getVideoView().getContext().getResources().getString(R.string.ala_audience_count_prefix), aq.numFormatOverWan(this.NR.aCK().audience_count)));
            }
        }
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        return this.fKp;
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
        if (this.eNZ != null && this.eNZ.getVideoView() != null) {
            this.eNZ.getVideoView().stopPlayback();
            this.eNZ.bct();
            if (this.elB != null) {
                this.elB.stop();
            }
        }
        this.fKp = false;
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.eNZ != null) {
            return this.eNZ.getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.NR == null || this.NR.aCI() == null) {
            return null;
        }
        return this.NR.aCI().video_url;
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.eNZ == null || this.eNZ.getVideoView() == null) {
            return 0;
        }
        return this.eNZ.getVideoView().getCurrentPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buU() {
        if (this.NR == null || this.NR.aCI() == null) {
        }
    }

    public void startPlayAnimation() {
        if (this.eNZ != null) {
            this.eNZ.startPlayAnimation();
        }
    }
}
