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
    private cb akU;
    private f gzY;
    private AlaVideoContainer hni;
    private boolean iwC = false;
    private f.a iwO = new f.a() { // from class: com.baidu.tieba.card.ala.a.1
        @Override // com.baidu.tieba.play.f.a
        public void rD() {
            a.this.csb();
        }
    };
    private AlaInfoData izN;
    private String izO;
    private String mForumName;

    public a(AlaVideoContainer alaVideoContainer) {
        this.hni = alaVideoContainer;
        if (this.hni != null) {
            this.gzY = new f();
            this.gzY.setPlayer(this.hni.getVideoView());
            this.gzY.a(this.iwO);
        }
    }

    public void a(cb cbVar, String str, String str2, boolean z) {
        this.izO = str2;
        this.mForumName = str;
        if (cbVar != null) {
            this.akU = cbVar;
            if (this.hni != null && this.akU.boj() != null) {
                this.izN = this.akU.boj();
                this.hni.setVideoThumbnail(this.izN.cover);
                if (z) {
                    this.hni.setTitle(this.akU.getTitle());
                } else {
                    this.hni.setTitle("");
                }
                this.hni.setPlayCount(String.format(this.hni.getVideoView().getContext().getResources().getString(R.string.ala_audience_count_prefix), au.numFormatOverWan(this.akU.boj().audience_count)));
            }
        }
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        return this.iwC;
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
        if (this.hni != null && this.hni.getVideoView() != null) {
            this.hni.getVideoView().stopPlayback();
            this.hni.bRl();
            if (this.gzY != null) {
                this.gzY.stop();
            }
        }
        this.iwC = false;
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        if (this.hni != null) {
            return this.hni.getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.play.e
    public String getPlayUrl() {
        if (this.akU == null || this.akU.boh() == null) {
            return null;
        }
        return this.akU.boh().video_url;
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        if (this.hni == null || this.hni.getVideoView() == null) {
            return 0;
        }
        return this.hni.getVideoView().getCurrentPositionSync();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csb() {
        if (this.akU == null || this.akU.boh() == null) {
        }
    }

    public void startPlayAnimation() {
        if (this.hni != null) {
            this.hni.startPlayAnimation();
        }
    }
}
