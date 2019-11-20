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
    private bh cqG;
    private AlaVideoContainer dSC;
    private j dvH;
    private n dvI;
    private boolean eLV = false;
    private j.a eMh = new j.a() { // from class: com.baidu.tieba.card.ala.a.1
        @Override // com.baidu.tieba.play.j.a
        public void kP() {
            a.this.bac();
        }
    };
    private AlaInfoData eOS;
    private String eOT;
    private String mForumName;

    public a(AlaVideoContainer alaVideoContainer) {
        this.dSC = alaVideoContainer;
        if (this.dSC != null) {
            this.dvH = new j();
            this.dvH.setPlayer(this.dSC.getVideoView());
            this.dvH.a(this.eMh);
            if (this.dSC.getVideoView() != null) {
                this.dvI = new n(this.dSC.getVideoView().getContext());
                this.dSC.getVideoView().setBusiness(this.dvI);
            }
        }
    }

    public void a(bh bhVar, String str, String str2, boolean z) {
        this.eOT = str2;
        this.mForumName = str;
        if (bhVar != null) {
            this.cqG = bhVar;
            if (this.dSC != null && this.cqG.aiX() != null) {
                this.eOS = this.cqG.aiX();
                this.dSC.setVideoThumbnail(this.eOS.cover);
                if (this.dvI != null && this.dvI.ccw() != null) {
                    this.dvI.ccw().b(this.eOS);
                }
                if (z) {
                    this.dSC.setTitle(this.cqG.getTitle());
                } else {
                    this.dSC.setTitle("");
                }
                this.dSC.setPlayCount(String.format(this.dSC.getVideoView().getContext().getResources().getString(R.string.ala_audience_count_prefix), aq.numFormatOverWan(this.cqG.aiX().audience_count)));
            }
        }
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        return this.eLV;
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
        if (this.dSC != null && this.dSC.getVideoView() != null) {
            this.dSC.getVideoView().stopPlayback();
            this.dSC.aJd();
            if (this.dvH != null) {
                this.dvH.stop();
            }
        }
        this.eLV = false;
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.dSC != null) {
            return this.dSC.getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.cqG == null || this.cqG.aiV() == null) {
            return null;
        }
        return this.cqG.aiV().video_url;
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.dSC == null || this.dSC.getVideoView() == null) {
            return 0;
        }
        return this.dSC.getVideoView().getCurrentPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bac() {
        if (this.cqG == null || this.cqG.aiV() == null) {
        }
    }

    public void startPlayAnimation() {
        if (this.dSC != null) {
            this.dSC.startPlayAnimation();
        }
    }
}
