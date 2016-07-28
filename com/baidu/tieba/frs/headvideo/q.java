package com.baidu.tieba.frs.headvideo;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class q implements Runnable {
    final /* synthetic */ ForumHeadVideoView bQU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(ForumHeadVideoView forumHeadVideoView) {
        this.bQU = forumHeadVideoView;
    }

    @Override // java.lang.Runnable
    public void run() {
        Animation animation;
        e currentVideoItemView = this.bQU.getCurrentVideoItemView();
        if (currentVideoItemView != null) {
            currentVideoItemView.setVisibility(0);
            animation = this.bQU.bQG;
            currentVideoItemView.startAnimation(animation);
        }
    }
}
