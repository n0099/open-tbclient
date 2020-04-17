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
    private bj agz;
    private j ePb;
    private n ePc;
    private AlaVideoContainer fst;
    private boolean goV = false;
    private j.a gph = new j.a() { // from class: com.baidu.tieba.card.ala.a.1
        @Override // com.baidu.tieba.play.j.a
        public void qa() {
            a.this.bEG();
        }
    };
    private AlaInfoData grR;
    private String grS;
    private String mForumName;

    public a(AlaVideoContainer alaVideoContainer) {
        this.fst = alaVideoContainer;
        if (this.fst != null) {
            this.ePb = new j();
            this.ePb.setPlayer(this.fst.getVideoView());
            this.ePb.a(this.gph);
            if (this.fst.getVideoView() != null) {
                this.ePc = new n(this.fst.getVideoView().getContext());
                this.fst.getVideoView().setBusiness(this.ePc);
            }
        }
    }

    public void a(bj bjVar, String str, String str2, boolean z) {
        this.grS = str2;
        this.mForumName = str;
        if (bjVar != null) {
            this.agz = bjVar;
            if (this.fst != null && this.agz.aKX() != null) {
                this.grR = this.agz.aKX();
                this.fst.setVideoThumbnail(this.grR.cover);
                if (this.ePc != null && this.ePc.cJY() != null) {
                    this.ePc.cJY().b(this.grR);
                }
                if (z) {
                    this.fst.setTitle(this.agz.getTitle());
                } else {
                    this.fst.setTitle("");
                }
                this.fst.setPlayCount(String.format(this.fst.getVideoView().getContext().getResources().getString(R.string.ala_audience_count_prefix), aq.numFormatOverWan(this.agz.aKX().audience_count)));
            }
        }
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        return this.goV;
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
        if (this.fst != null && this.fst.getVideoView() != null) {
            this.fst.getVideoView().stopPlayback();
            this.fst.blk();
            if (this.ePb != null) {
                this.ePb.stop();
            }
        }
        this.goV = false;
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.fst != null) {
            return this.fst.getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.agz == null || this.agz.aKV() == null) {
            return null;
        }
        return this.agz.aKV().video_url;
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.fst == null || this.fst.getVideoView() == null) {
            return 0;
        }
        return this.fst.getVideoView().getCurrentPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEG() {
        if (this.agz == null || this.agz.aKV() == null) {
        }
    }

    public void startPlayAnimation() {
        if (this.fst != null) {
            this.fst.startPlayAnimation();
        }
    }
}
