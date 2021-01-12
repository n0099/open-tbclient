package com.baidu.tieba.card.ala;

import android.view.View;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
import com.baidu.tieba.play.e;
import com.baidu.tieba.play.f;
/* loaded from: classes.dex */
public class a implements e {
    private bz ale;
    private f gxo;
    private AlaVideoContainer hiV;
    private boolean iqY = false;
    private f.a irk = new f.a() { // from class: com.baidu.tieba.card.ala.a.1
        @Override // com.baidu.tieba.play.f.a
        public void rF() {
            a.this.cqR();
        }
    };
    private AlaInfoData iud;
    private String iue;
    private String mForumName;

    public a(AlaVideoContainer alaVideoContainer) {
        this.hiV = alaVideoContainer;
        if (this.hiV != null) {
            this.gxo = new f();
            this.gxo.setPlayer(this.hiV.getVideoView());
            this.gxo.a(this.irk);
        }
    }

    public void a(bz bzVar, String str, String str2, boolean z) {
        this.iue = str2;
        this.mForumName = str;
        if (bzVar != null) {
            this.ale = bzVar;
            if (this.hiV != null && this.ale.bnQ() != null) {
                this.iud = this.ale.bnQ();
                this.hiV.setVideoThumbnail(this.iud.cover);
                if (z) {
                    this.hiV.setTitle(this.ale.getTitle());
                } else {
                    this.hiV.setTitle("");
                }
                this.hiV.setPlayCount(String.format(this.hiV.getVideoView().getContext().getResources().getString(R.string.ala_audience_count_prefix), at.numFormatOverWan(this.ale.bnQ().audience_count)));
            }
        }
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        return this.iqY;
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
        if (this.hiV != null && this.hiV.getVideoView() != null) {
            this.hiV.getVideoView().stopPlayback();
            this.hiV.bQH();
            if (this.gxo != null) {
                this.gxo.stop();
            }
        }
        this.iqY = false;
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        if (this.hiV != null) {
            return this.hiV.getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.play.e
    public String getPlayUrl() {
        if (this.ale == null || this.ale.bnO() == null) {
            return null;
        }
        return this.ale.bnO().video_url;
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        if (this.hiV == null || this.hiV.getVideoView() == null) {
            return 0;
        }
        return this.hiV.getVideoView().getCurrentPositionSync();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqR() {
        if (this.ale == null || this.ale.bnO() == null) {
        }
    }

    public void startPlayAnimation() {
        if (this.hiV != null) {
            this.hiV.startPlayAnimation();
        }
    }
}
