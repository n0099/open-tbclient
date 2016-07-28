package com.baidu.tieba.frs.headvideo;

import android.media.MediaPlayer;
/* loaded from: classes.dex */
class u implements MediaPlayer.OnErrorListener {
    final /* synthetic */ ForumHeadVideoView bQU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(ForumHeadVideoView forumHeadVideoView) {
        this.bQU = forumHeadVideoView;
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        e currentVideoItemView = this.bQU.getCurrentVideoItemView();
        if (currentVideoItemView != null) {
            currentVideoItemView.stopPlayback();
            currentVideoItemView.setVideoPlayState(4);
            return true;
        }
        return true;
    }
}
