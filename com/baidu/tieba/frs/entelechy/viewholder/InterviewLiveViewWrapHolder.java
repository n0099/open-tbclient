package com.baidu.tieba.frs.entelechy.viewholder;

import android.view.View;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.frs.entelechy.adapter.FrsCardVideoViewHolder;
import com.baidu.tieba.play.e;
/* loaded from: classes2.dex */
public class InterviewLiveViewWrapHolder extends TypeAdapter.ViewHolder implements e {
    private FrsCardVideoViewHolder jts;

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        if (this.jts == null) {
            return false;
        }
        return this.jts.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlaying() {
        if (this.jts == null) {
            return false;
        }
        return this.jts.isPlaying();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isFullScreen() {
        if (this.jts == null) {
            return false;
        }
        return this.jts.isFullScreen();
    }

    @Override // com.baidu.tieba.play.e
    public void startPlay() {
        if (this.jts != null) {
            this.jts.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public void stopPlay() {
        if (this.jts != null) {
            this.jts.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        if (this.jts == null) {
            return null;
        }
        return this.jts.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.e
    public String getPlayUrl() {
        return this.jts == null ? "" : this.jts.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        if (this.jts == null) {
            return 0;
        }
        return this.jts.getCurrentPosition();
    }
}
