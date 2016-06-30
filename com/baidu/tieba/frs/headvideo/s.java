package com.baidu.tieba.frs.headvideo;

import android.media.MediaPlayer;
import com.baidu.tbadk.core.util.y;
import java.util.List;
/* loaded from: classes.dex */
class s implements MediaPlayer.OnPreparedListener {
    final /* synthetic */ ForumHeadVideoView bPh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(ForumHeadVideoView forumHeadVideoView) {
        this.bPh = forumHeadVideoView;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        List list;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.setVolume(0.0f, 0.0f);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        list = this.bPh.aLB;
        if (y.s(list) > 1) {
            mediaPlayer.setLooping(false);
        } else {
            mediaPlayer.setLooping(true);
        }
        e currentVideoItemView = this.bPh.getCurrentVideoItemView();
        if (currentVideoItemView != null) {
            currentVideoItemView.setVideoPlayState(3);
            this.bPh.n(currentVideoItemView.getThreadInfo());
        }
    }
}
