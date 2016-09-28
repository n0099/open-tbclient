package com.baidu.tieba.frs.headvideo;

import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements Animation.AnimationListener {
    final /* synthetic */ ForumHeadVideoView ccf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(ForumHeadVideoView forumHeadVideoView) {
        this.ccf = forumHeadVideoView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.ccf.cbR = false;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        e swapVideoItemView = this.ccf.getSwapVideoItemView();
        if (swapVideoItemView != null) {
            swapVideoItemView.clearAnimation();
            this.ccf.h(swapVideoItemView);
        }
    }
}
