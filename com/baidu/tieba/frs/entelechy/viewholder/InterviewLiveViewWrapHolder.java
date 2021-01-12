package com.baidu.tieba.frs.entelechy.viewholder;

import android.view.View;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.frs.entelechy.adapter.FrsCardVideoViewHolder;
import com.baidu.tieba.play.e;
/* loaded from: classes2.dex */
public class InterviewLiveViewWrapHolder extends TypeAdapter.ViewHolder implements e {
    private FrsCardVideoViewHolder jnM;

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        if (this.jnM == null) {
            return false;
        }
        return this.jnM.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlaying() {
        if (this.jnM == null) {
            return false;
        }
        return this.jnM.isPlaying();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isFullScreen() {
        if (this.jnM == null) {
            return false;
        }
        return this.jnM.isFullScreen();
    }

    @Override // com.baidu.tieba.play.e
    public void startPlay() {
        if (this.jnM != null) {
            this.jnM.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public void stopPlay() {
        if (this.jnM != null) {
            this.jnM.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        if (this.jnM == null) {
            return null;
        }
        return this.jnM.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.e
    public String getPlayUrl() {
        return this.jnM == null ? "" : this.jnM.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        if (this.jnM == null) {
            return 0;
        }
        return this.jnM.getCurrentPosition();
    }
}
