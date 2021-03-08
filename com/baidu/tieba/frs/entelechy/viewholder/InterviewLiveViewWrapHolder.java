package com.baidu.tieba.frs.entelechy.viewholder;

import android.view.View;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.frs.entelechy.adapter.FrsCardVideoViewHolder;
import com.baidu.tieba.play.e;
/* loaded from: classes2.dex */
public class InterviewLiveViewWrapHolder extends TypeAdapter.ViewHolder implements e {
    private FrsCardVideoViewHolder jvp;

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        if (this.jvp == null) {
            return false;
        }
        return this.jvp.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlaying() {
        if (this.jvp == null) {
            return false;
        }
        return this.jvp.isPlaying();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isFullScreen() {
        if (this.jvp == null) {
            return false;
        }
        return this.jvp.isFullScreen();
    }

    @Override // com.baidu.tieba.play.e
    public void startPlay() {
        if (this.jvp != null) {
            this.jvp.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public void stopPlay() {
        if (this.jvp != null) {
            this.jvp.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        if (this.jvp == null) {
            return null;
        }
        return this.jvp.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.e
    public String getPlayUrl() {
        return this.jvp == null ? "" : this.jvp.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        if (this.jvp == null) {
            return 0;
        }
        return this.jvp.getCurrentPosition();
    }
}
