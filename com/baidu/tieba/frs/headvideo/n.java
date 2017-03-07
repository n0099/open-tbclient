package com.baidu.tieba.frs.headvideo;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class n implements Runnable {
    final /* synthetic */ ForumHeadVideoView bYL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(ForumHeadVideoView forumHeadVideoView) {
        this.bYL = forumHeadVideoView;
    }

    @Override // java.lang.Runnable
    public void run() {
        Animation animation;
        c currentVideoItemView = this.bYL.getCurrentVideoItemView();
        if (currentVideoItemView != null) {
            currentVideoItemView.setVisibility(0);
            animation = this.bYL.bYw;
            currentVideoItemView.startAnimation(animation);
        }
    }
}
