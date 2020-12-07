package com.baidu.tieba.card.ala;

import android.view.View;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
import com.baidu.tieba.play.e;
import com.baidu.tieba.play.f;
/* loaded from: classes21.dex */
public class a implements e {
    private by alu;
    private f gqU;
    private AlaVideoContainer hbN;
    private boolean iji = false;
    private f.a iju = new f.a() { // from class: com.baidu.tieba.card.ala.a.1
        @Override // com.baidu.tieba.play.f.a
        public void se() {
            a.this.crO();
        }
    };
    private AlaInfoData imo;
    private String imp;
    private String mForumName;

    public a(AlaVideoContainer alaVideoContainer) {
        this.hbN = alaVideoContainer;
        if (this.hbN != null) {
            this.gqU = new f();
            this.gqU.setPlayer(this.hbN.getVideoView());
            this.gqU.a(this.iju);
        }
    }

    public void a(by byVar, String str, String str2, boolean z) {
        this.imp = str2;
        this.mForumName = str;
        if (byVar != null) {
            this.alu = byVar;
            if (this.hbN != null && this.alu.bpj() != null) {
                this.imo = this.alu.bpj();
                this.hbN.setVideoThumbnail(this.imo.cover);
                if (z) {
                    this.hbN.setTitle(this.alu.getTitle());
                } else {
                    this.hbN.setTitle("");
                }
                this.hbN.setPlayCount(String.format(this.hbN.getVideoView().getContext().getResources().getString(R.string.ala_audience_count_prefix), au.numFormatOverWan(this.alu.bpj().audience_count)));
            }
        }
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        return this.iji;
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
        if (this.hbN != null && this.hbN.getVideoView() != null) {
            this.hbN.getVideoView().stopPlayback();
            this.hbN.bRV();
            if (this.gqU != null) {
                this.gqU.stop();
            }
        }
        this.iji = false;
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        if (this.hbN != null) {
            return this.hbN.getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.play.e
    public String getPlayUrl() {
        if (this.alu == null || this.alu.bph() == null) {
            return null;
        }
        return this.alu.bph().video_url;
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        if (this.hbN == null || this.hbN.getVideoView() == null) {
            return 0;
        }
        return this.hbN.getVideoView().getCurrentPositionSync();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crO() {
        if (this.alu == null || this.alu.bph() == null) {
        }
    }

    public void startPlayAnimation() {
        if (this.hbN != null) {
            this.hbN.startPlayAnimation();
        }
    }
}
