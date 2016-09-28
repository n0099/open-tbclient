package com.baidu.tieba.frs.view;

import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements Animation.AnimationListener {
    final /* synthetic */ t chL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar) {
        this.chL = tVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        if (animation == this.chL.chH) {
            this.chL.mState = 0;
            return;
        }
        this.chL.mState = 1;
        this.chL.bo(8000L);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
