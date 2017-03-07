package com.baidu.tieba.frs.headvideo;

import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements Animation.AnimationListener {
    final /* synthetic */ ForumHeadVideoView bYL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(ForumHeadVideoView forumHeadVideoView) {
        this.bYL = forumHeadVideoView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.bYL.bYx = false;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        c swapVideoItemView = this.bYL.getSwapVideoItemView();
        if (swapVideoItemView != null) {
            swapVideoItemView.clearAnimation();
            this.bYL.h(swapVideoItemView);
        }
    }
}
