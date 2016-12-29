package com.baidu.tieba.frs.headvideo;

import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements Animation.AnimationListener {
    final /* synthetic */ ForumHeadVideoView bLk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(ForumHeadVideoView forumHeadVideoView) {
        this.bLk = forumHeadVideoView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        com.baidu.adp.lib.h.h.eG().post(this.bLk.mRunnable);
    }
}
