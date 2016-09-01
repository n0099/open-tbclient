package com.baidu.tieba.frs.headvideo;

import android.media.MediaPlayer;
import com.baidu.tbadk.core.util.y;
import java.util.List;
/* loaded from: classes.dex */
class t implements MediaPlayer.OnCompletionListener {
    final /* synthetic */ ForumHeadVideoView ccd;
    private long cce;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(ForumHeadVideoView forumHeadVideoView) {
        this.ccd = forumHeadVideoView;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        List list;
        e currentVideoItemView = this.ccd.getCurrentVideoItemView();
        if (currentVideoItemView != null) {
            list = this.ccd.aRP;
            if (y.s(list) == 1 && mediaPlayer != null && mediaPlayer.isLooping()) {
                if (System.currentTimeMillis() - this.cce > 100) {
                    currentVideoItemView.aem();
                    this.cce = System.currentTimeMillis();
                    this.ccd.p(currentVideoItemView.getThreadInfo());
                    return;
                }
                return;
            }
            currentVideoItemView.setVideoPlayState(1);
            this.ccd.aev();
        }
    }
}
