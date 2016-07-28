package com.baidu.tieba.frs.headvideo;

import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements Animation.AnimationListener {
    final /* synthetic */ ForumHeadVideoView bQU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(ForumHeadVideoView forumHeadVideoView) {
        this.bQU = forumHeadVideoView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.bQU.bQH = false;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        e swapVideoItemView = this.bQU.getSwapVideoItemView();
        if (swapVideoItemView != null) {
            swapVideoItemView.clearAnimation();
            this.bQU.g(swapVideoItemView);
        }
    }
}
