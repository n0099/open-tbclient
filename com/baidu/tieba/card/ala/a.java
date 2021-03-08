package com.baidu.tieba.card.ala;

import android.view.View;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
import com.baidu.tieba.play.e;
import com.baidu.tieba.play.f;
/* loaded from: classes.dex */
public class a implements e {
    private cb amn;
    private f gBV;
    private AlaVideoContainer hpg;
    private AlaInfoData iBK;
    private String iBL;
    private String mForumName;
    private boolean iyz = false;
    private f.a iyL = new f.a() { // from class: com.baidu.tieba.card.ala.a.1
        @Override // com.baidu.tieba.play.f.a
        public void rD() {
            a.this.cso();
        }
    };

    public a(AlaVideoContainer alaVideoContainer) {
        this.hpg = alaVideoContainer;
        if (this.hpg != null) {
            this.gBV = new f();
            this.gBV.setPlayer(this.hpg.getVideoView());
            this.gBV.a(this.iyL);
        }
    }

    public void a(cb cbVar, String str, String str2, boolean z) {
        this.iBL = str2;
        this.mForumName = str;
        if (cbVar != null) {
            this.amn = cbVar;
            if (this.hpg != null && this.amn.bol() != null) {
                this.iBK = this.amn.bol();
                this.hpg.setVideoThumbnail(this.iBK.cover);
                if (z) {
                    this.hpg.setTitle(this.amn.getTitle());
                } else {
                    this.hpg.setTitle("");
                }
                this.hpg.setPlayCount(String.format(this.hpg.getVideoView().getContext().getResources().getString(R.string.ala_audience_count_prefix), au.numFormatOverWan(this.amn.bol().audience_count)));
            }
        }
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        return this.iyz;
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
        if (this.hpg != null && this.hpg.getVideoView() != null) {
            this.hpg.getVideoView().stopPlayback();
            this.hpg.bRy();
            if (this.gBV != null) {
                this.gBV.stop();
            }
        }
        this.iyz = false;
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        if (this.hpg != null) {
            return this.hpg.getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.play.e
    public String getPlayUrl() {
        if (this.amn == null || this.amn.boj() == null) {
            return null;
        }
        return this.amn.boj().video_url;
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        if (this.hpg == null || this.hpg.getVideoView() == null) {
            return 0;
        }
        return this.hpg.getVideoView().getCurrentPositionSync();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cso() {
        if (this.amn == null || this.amn.boj() == null) {
        }
    }

    public void startPlayAnimation() {
        if (this.hpg != null) {
            this.hpg.startPlayAnimation();
        }
    }
}
