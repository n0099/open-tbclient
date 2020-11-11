package com.baidu.tieba.card.ala;

import android.view.View;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
import com.baidu.tieba.play.e;
import com.baidu.tieba.play.f;
/* loaded from: classes21.dex */
public class a implements e {
    private bw akq;
    private AlaVideoContainer gST;
    private f gje;
    private boolean hXL = false;
    private f.a hXX = new f.a() { // from class: com.baidu.tieba.card.ala.a.1
        @Override // com.baidu.tieba.play.f.a
        public void sc() {
            a.this.cnZ();
        }
    };
    private AlaInfoData iaP;
    private String iaQ;
    private String mForumName;

    public a(AlaVideoContainer alaVideoContainer) {
        this.gST = alaVideoContainer;
        if (this.gST != null) {
            this.gje = new f();
            this.gje.setPlayer(this.gST.getVideoView());
            this.gje.a(this.hXX);
        }
    }

    public void a(bw bwVar, String str, String str2, boolean z) {
        this.iaQ = str2;
        this.mForumName = str;
        if (bwVar != null) {
            this.akq = bwVar;
            if (this.gST != null && this.akq.bmU() != null) {
                this.iaP = this.akq.bmU();
                this.gST.setVideoThumbnail(this.iaP.cover);
                if (z) {
                    this.gST.setTitle(this.akq.getTitle());
                } else {
                    this.gST.setTitle("");
                }
                this.gST.setPlayCount(String.format(this.gST.getVideoView().getContext().getResources().getString(R.string.ala_audience_count_prefix), at.numFormatOverWan(this.akq.bmU().audience_count)));
            }
        }
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        return this.hXL;
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlaying() {
        return false;
    }

    @Override // com.baidu.tieba.play.e
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.e
    public void startPlay() {
    }

    @Override // com.baidu.tieba.play.e
    public void stopPlay() {
        if (this.gST != null && this.gST.getVideoView() != null) {
            this.gST.getVideoView().stopPlayback();
            this.gST.bOR();
            if (this.gje != null) {
                this.gje.stop();
            }
        }
        this.hXL = false;
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        if (this.gST != null) {
            return this.gST.getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.play.e
    public String getPlayUrl() {
        if (this.akq == null || this.akq.bmS() == null) {
            return null;
        }
        return this.akq.bmS().video_url;
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        if (this.gST == null || this.gST.getVideoView() == null) {
            return 0;
        }
        return this.gST.getVideoView().getCurrentPositionSync();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnZ() {
        if (this.akq == null || this.akq.bmS() == null) {
        }
    }

    public void startPlayAnimation() {
        if (this.gST != null) {
            this.gST.startPlayAnimation();
        }
    }
}
