package com.baidu.tieba.card.ala;

import android.view.View;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.e;
import com.baidu.tieba.play.f;
import com.baidu.tieba.play.j;
import com.baidu.tieba.play.n;
/* loaded from: classes6.dex */
public class a implements f {
    private bb bIV;
    private j bJO;
    private n bJP;
    private AlaVideoContainer bWh;
    private boolean cMQ = false;
    private j.a cNb = new j.a() { // from class: com.baidu.tieba.card.ala.a.1
        @Override // com.baidu.tieba.play.j.a
        public void aof() {
            a.this.anY();
        }
    };
    private AlaInfoData cPQ;
    private String cPR;
    private String mForumName;

    public a(AlaVideoContainer alaVideoContainer) {
        this.bWh = alaVideoContainer;
        if (this.bWh != null) {
            this.bJO = new j();
            this.bJO.setPlayer(this.bWh.getVideoView());
            this.bJO.a(this.cNb);
            if (this.bWh.getVideoView() != null) {
                this.bJP = new n(this.bWh.getVideoView().getContext());
                this.bWh.getVideoView().setBusiness(this.bJP);
            }
        }
    }

    public void a(bb bbVar, String str, String str2, boolean z) {
        this.cPR = str2;
        this.mForumName = str;
        if (bbVar != null) {
            this.bIV = bbVar;
            if (this.bWh != null && this.bIV.yP() != null) {
                this.cPQ = this.bIV.yP();
                this.bWh.setVideoThumbnail(this.cPQ.cover);
                if (this.bJP != null && this.bJP.bqs() != null) {
                    this.bJP.bqs().b(this.cPQ);
                }
                if (z) {
                    this.bWh.setTitle(this.bIV.getTitle());
                } else {
                    this.bWh.setTitle("");
                }
                this.bWh.setPlayCount(String.format(this.bWh.getVideoView().getContext().getResources().getString(e.j.ala_audience_count_prefix), ao.N(this.bIV.yP().audience_count)));
            }
        }
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        return this.cMQ;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        return false;
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.bWh != null && this.bWh.getVideoView() != null) {
            this.bWh.getVideoView().stopPlayback();
            this.bWh.YT();
            if (this.bJO != null) {
                this.bJO.stop();
            }
        }
        this.cMQ = false;
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.bWh != null) {
            return this.bWh.getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.bIV == null || this.bIV.yN() == null) {
            return null;
        }
        return this.bIV.yN().video_url;
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.bWh == null || this.bWh.getVideoView() == null) {
            return 0;
        }
        return this.bWh.getVideoView().getCurrentPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anY() {
        if (this.bIV == null || this.bIV.yN() == null) {
        }
    }

    public void startPlayAnimation() {
        if (this.bWh != null) {
            this.bWh.startPlayAnimation();
        }
    }

    public void setAutoStartPlay(boolean z) {
        if (this.bWh != null) {
            this.bWh.setAutoStartPlay(z);
        }
    }
}
