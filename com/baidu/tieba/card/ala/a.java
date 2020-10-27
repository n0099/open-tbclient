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
    private AlaVideoContainer gMu;
    private f gdo;
    private boolean hRO = false;
    private f.a hSa = new f.a() { // from class: com.baidu.tieba.card.ala.a.1
        @Override // com.baidu.tieba.play.f.a
        public void sc() {
            a.this.cly();
        }
    };
    private AlaInfoData hUS;
    private String hUT;
    private String mForumName;

    public a(AlaVideoContainer alaVideoContainer) {
        this.gMu = alaVideoContainer;
        if (this.gMu != null) {
            this.gdo = new f();
            this.gdo.setPlayer(this.gMu.getVideoView());
            this.gdo.a(this.hSa);
        }
    }

    public void a(bw bwVar, String str, String str2, boolean z) {
        this.hUT = str2;
        this.mForumName = str;
        if (bwVar != null) {
            this.akq = bwVar;
            if (this.gMu != null && this.akq.bku() != null) {
                this.hUS = this.akq.bku();
                this.gMu.setVideoThumbnail(this.hUS.cover);
                if (z) {
                    this.gMu.setTitle(this.akq.getTitle());
                } else {
                    this.gMu.setTitle("");
                }
                this.gMu.setPlayCount(String.format(this.gMu.getVideoView().getContext().getResources().getString(R.string.ala_audience_count_prefix), at.numFormatOverWan(this.akq.bku().audience_count)));
            }
        }
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        return this.hRO;
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
        if (this.gMu != null && this.gMu.getVideoView() != null) {
            this.gMu.getVideoView().stopPlayback();
            this.gMu.bMr();
            if (this.gdo != null) {
                this.gdo.stop();
            }
        }
        this.hRO = false;
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        if (this.gMu != null) {
            return this.gMu.getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.play.e
    public String getPlayUrl() {
        if (this.akq == null || this.akq.bks() == null) {
            return null;
        }
        return this.akq.bks().video_url;
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        if (this.gMu == null || this.gMu.getVideoView() == null) {
            return 0;
        }
        return this.gMu.getVideoView().getCurrentPositionSync();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cly() {
        if (this.akq == null || this.akq.bks() == null) {
        }
    }

    public void startPlayAnimation() {
        if (this.gMu != null) {
            this.gMu.startPlayAnimation();
        }
    }
}
