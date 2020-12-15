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
    private f gqW;
    private AlaVideoContainer hbP;
    private boolean ijk = false;
    private f.a ijw = new f.a() { // from class: com.baidu.tieba.card.ala.a.1
        @Override // com.baidu.tieba.play.f.a
        public void se() {
            a.this.crP();
        }
    };
    private AlaInfoData imq;
    private String imr;
    private String mForumName;

    public a(AlaVideoContainer alaVideoContainer) {
        this.hbP = alaVideoContainer;
        if (this.hbP != null) {
            this.gqW = new f();
            this.gqW.setPlayer(this.hbP.getVideoView());
            this.gqW.a(this.ijw);
        }
    }

    public void a(by byVar, String str, String str2, boolean z) {
        this.imr = str2;
        this.mForumName = str;
        if (byVar != null) {
            this.alu = byVar;
            if (this.hbP != null && this.alu.bpj() != null) {
                this.imq = this.alu.bpj();
                this.hbP.setVideoThumbnail(this.imq.cover);
                if (z) {
                    this.hbP.setTitle(this.alu.getTitle());
                } else {
                    this.hbP.setTitle("");
                }
                this.hbP.setPlayCount(String.format(this.hbP.getVideoView().getContext().getResources().getString(R.string.ala_audience_count_prefix), au.numFormatOverWan(this.alu.bpj().audience_count)));
            }
        }
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        return this.ijk;
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
        if (this.hbP != null && this.hbP.getVideoView() != null) {
            this.hbP.getVideoView().stopPlayback();
            this.hbP.bRW();
            if (this.gqW != null) {
                this.gqW.stop();
            }
        }
        this.ijk = false;
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        if (this.hbP != null) {
            return this.hbP.getView();
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
        if (this.hbP == null || this.hbP.getVideoView() == null) {
            return 0;
        }
        return this.hbP.getVideoView().getCurrentPositionSync();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crP() {
        if (this.alu == null || this.alu.bph() == null) {
        }
    }

    public void startPlayAnimation() {
        if (this.hbP != null) {
            this.hbP.startPlayAnimation();
        }
    }
}
