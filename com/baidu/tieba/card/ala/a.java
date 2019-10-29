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
    private bh cry;
    private AlaVideoContainer dTt;
    private j dwy;
    private n dwz;
    private boolean eMM = false;
    private j.a eMY = new j.a() { // from class: com.baidu.tieba.card.ala.a.1
        @Override // com.baidu.tieba.play.j.a
        public void kP() {
            a.this.bae();
        }
    };
    private AlaInfoData ePJ;
    private String ePK;
    private String mForumName;

    public a(AlaVideoContainer alaVideoContainer) {
        this.dTt = alaVideoContainer;
        if (this.dTt != null) {
            this.dwy = new j();
            this.dwy.setPlayer(this.dTt.getVideoView());
            this.dwy.a(this.eMY);
            if (this.dTt.getVideoView() != null) {
                this.dwz = new n(this.dTt.getVideoView().getContext());
                this.dTt.getVideoView().setBusiness(this.dwz);
            }
        }
    }

    public void a(bh bhVar, String str, String str2, boolean z) {
        this.ePK = str2;
        this.mForumName = str;
        if (bhVar != null) {
            this.cry = bhVar;
            if (this.dTt != null && this.cry.aiZ() != null) {
                this.ePJ = this.cry.aiZ();
                this.dTt.setVideoThumbnail(this.ePJ.cover);
                if (this.dwz != null && this.dwz.ccy() != null) {
                    this.dwz.ccy().b(this.ePJ);
                }
                if (z) {
                    this.dTt.setTitle(this.cry.getTitle());
                } else {
                    this.dTt.setTitle("");
                }
                this.dTt.setPlayCount(String.format(this.dTt.getVideoView().getContext().getResources().getString(R.string.ala_audience_count_prefix), aq.numFormatOverWan(this.cry.aiZ().audience_count)));
            }
        }
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        return this.eMM;
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
        if (this.dTt != null && this.dTt.getVideoView() != null) {
            this.dTt.getVideoView().stopPlayback();
            this.dTt.aJf();
            if (this.dwy != null) {
                this.dwy.stop();
            }
        }
        this.eMM = false;
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.dTt != null) {
            return this.dTt.getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.cry == null || this.cry.aiX() == null) {
            return null;
        }
        return this.cry.aiX().video_url;
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.dTt == null || this.dTt.getVideoView() == null) {
            return 0;
        }
        return this.dTt.getVideoView().getCurrentPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bae() {
        if (this.cry == null || this.cry.aiX() == null) {
        }
    }

    public void startPlayAnimation() {
        if (this.dTt != null) {
            this.dTt.startPlayAnimation();
        }
    }
}
