package com.baidu.tieba.frs.headvideo;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class j implements Animation.AnimationListener {
    final /* synthetic */ ForumHeadVideoView bRD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(ForumHeadVideoView forumHeadVideoView) {
        this.bRD = forumHeadVideoView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        com.baidu.adp.lib.g.h.eE().post(this.bRD.mRunnable);
    }
}
