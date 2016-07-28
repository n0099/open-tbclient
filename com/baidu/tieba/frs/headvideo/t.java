package com.baidu.tieba.frs.headvideo;

import android.media.MediaPlayer;
import com.baidu.tbadk.core.util.y;
import java.util.List;
/* loaded from: classes.dex */
class t implements MediaPlayer.OnCompletionListener {
    final /* synthetic */ ForumHeadVideoView bQU;
    private long bQV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(ForumHeadVideoView forumHeadVideoView) {
        this.bQU = forumHeadVideoView;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        List list;
        e currentVideoItemView = this.bQU.getCurrentVideoItemView();
        if (currentVideoItemView != null) {
            list = this.bQU.aMv;
            if (y.s(list) == 1 && mediaPlayer != null && mediaPlayer.isLooping()) {
                if (System.currentTimeMillis() - this.bQV > 100) {
                    currentVideoItemView.ZA();
                    this.bQV = System.currentTimeMillis();
                    this.bQU.p(currentVideoItemView.getThreadInfo());
                    return;
                }
                return;
            }
            currentVideoItemView.setVideoPlayState(1);
            this.bQU.ZL();
        }
    }
}
