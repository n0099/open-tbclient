package com.baidu.tieba.frs.headvideo;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class o implements Runnable {
    final /* synthetic */ ForumHeadVideoView cfB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(ForumHeadVideoView forumHeadVideoView) {
        this.cfB = forumHeadVideoView;
    }

    @Override // java.lang.Runnable
    public void run() {
        Animation animation;
        c currentVideoItemView = this.cfB.getCurrentVideoItemView();
        if (currentVideoItemView != null) {
            currentVideoItemView.setVisibility(0);
            animation = this.cfB.cfm;
            currentVideoItemView.startAnimation(animation);
        }
    }
}
