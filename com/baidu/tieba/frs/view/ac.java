package com.baidu.tieba.frs.view;

import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements Animation.AnimationListener {
    final /* synthetic */ ab bwX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(ab abVar) {
        this.bwX = abVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        if (animation == this.bwX.bwT) {
            this.bwX.mState = 0;
            return;
        }
        this.bwX.mState = 1;
        this.bwX.aH(8000L);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
