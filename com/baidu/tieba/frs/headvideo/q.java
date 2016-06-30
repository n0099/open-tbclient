package com.baidu.tieba.frs.headvideo;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class q implements Runnable {
    final /* synthetic */ ForumHeadVideoView bPh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(ForumHeadVideoView forumHeadVideoView) {
        this.bPh = forumHeadVideoView;
    }

    @Override // java.lang.Runnable
    public void run() {
        Animation animation;
        e currentVideoItemView = this.bPh.getCurrentVideoItemView();
        if (currentVideoItemView != null) {
            currentVideoItemView.setVisibility(0);
            animation = this.bPh.bOU;
            currentVideoItemView.startAnimation(animation);
        }
    }
}
