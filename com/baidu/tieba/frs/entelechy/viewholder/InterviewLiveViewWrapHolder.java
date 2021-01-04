package com.baidu.tieba.frs.entelechy.viewholder;

import android.view.View;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.frs.entelechy.adapter.FrsCardVideoViewHolder;
import com.baidu.tieba.play.e;
/* loaded from: classes2.dex */
public class InterviewLiveViewWrapHolder extends TypeAdapter.ViewHolder implements e {
    private FrsCardVideoViewHolder jss;

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        if (this.jss == null) {
            return false;
        }
        return this.jss.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlaying() {
        if (this.jss == null) {
            return false;
        }
        return this.jss.isPlaying();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isFullScreen() {
        if (this.jss == null) {
            return false;
        }
        return this.jss.isFullScreen();
    }

    @Override // com.baidu.tieba.play.e
    public void startPlay() {
        if (this.jss != null) {
            this.jss.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public void stopPlay() {
        if (this.jss != null) {
            this.jss.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        if (this.jss == null) {
            return null;
        }
        return this.jss.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.e
    public String getPlayUrl() {
        return this.jss == null ? "" : this.jss.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        if (this.jss == null) {
            return 0;
        }
        return this.jss.getCurrentPosition();
    }
}
