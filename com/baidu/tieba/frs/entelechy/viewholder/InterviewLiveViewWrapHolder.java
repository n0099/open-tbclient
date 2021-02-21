package com.baidu.tieba.frs.entelechy.viewholder;

import android.view.View;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.frs.entelechy.adapter.FrsCardVideoViewHolder;
import com.baidu.tieba.play.e;
/* loaded from: classes2.dex */
public class InterviewLiveViewWrapHolder extends TypeAdapter.ViewHolder implements e {
    private FrsCardVideoViewHolder jtG;

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        if (this.jtG == null) {
            return false;
        }
        return this.jtG.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlaying() {
        if (this.jtG == null) {
            return false;
        }
        return this.jtG.isPlaying();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isFullScreen() {
        if (this.jtG == null) {
            return false;
        }
        return this.jtG.isFullScreen();
    }

    @Override // com.baidu.tieba.play.e
    public void startPlay() {
        if (this.jtG != null) {
            this.jtG.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public void stopPlay() {
        if (this.jtG != null) {
            this.jtG.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        if (this.jtG == null) {
            return null;
        }
        return this.jtG.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.e
    public String getPlayUrl() {
        return this.jtG == null ? "" : this.jtG.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        if (this.jtG == null) {
            return 0;
        }
        return this.jtG.getCurrentPosition();
    }
}
