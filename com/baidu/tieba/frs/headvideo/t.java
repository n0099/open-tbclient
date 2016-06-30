package com.baidu.tieba.frs.headvideo;

import android.media.MediaPlayer;
import com.baidu.tbadk.core.util.y;
import java.util.List;
/* loaded from: classes.dex */
class t implements MediaPlayer.OnCompletionListener {
    final /* synthetic */ ForumHeadVideoView bPh;
    private long bPi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(ForumHeadVideoView forumHeadVideoView) {
        this.bPh = forumHeadVideoView;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        List list;
        e currentVideoItemView = this.bPh.getCurrentVideoItemView();
        if (currentVideoItemView != null) {
            list = this.bPh.aLB;
            if (y.s(list) == 1 && mediaPlayer != null && mediaPlayer.isLooping()) {
                if (System.currentTimeMillis() - this.bPi > 100) {
                    currentVideoItemView.Ze();
                    this.bPi = System.currentTimeMillis();
                    this.bPh.n(currentVideoItemView.getThreadInfo());
                    return;
                }
                return;
            }
            currentVideoItemView.setVideoPlayState(1);
            this.bPh.Zp();
        }
    }
}
