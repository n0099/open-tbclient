package com.baidu.tieba.frs.headvideo;

import android.media.MediaPlayer;
/* loaded from: classes.dex */
class u implements MediaPlayer.OnErrorListener {
    final /* synthetic */ ForumHeadVideoView ccd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(ForumHeadVideoView forumHeadVideoView) {
        this.ccd = forumHeadVideoView;
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        e currentVideoItemView = this.ccd.getCurrentVideoItemView();
        if (currentVideoItemView != null) {
            currentVideoItemView.stopPlayback();
            currentVideoItemView.setVideoPlayState(4);
            return true;
        }
        return true;
    }
}
