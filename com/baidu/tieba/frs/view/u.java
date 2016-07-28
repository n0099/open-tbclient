package com.baidu.tieba.frs.view;

import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements Animation.AnimationListener {
    final /* synthetic */ t bWD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar) {
        this.bWD = tVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        if (animation == this.bWD.bWz) {
            this.bWD.mState = 0;
            return;
        }
        this.bWD.mState = 1;
        this.bWD.aS(8000L);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
