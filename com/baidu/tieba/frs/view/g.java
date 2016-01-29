package com.baidu.tieba.frs.view;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
/* loaded from: classes.dex */
class g implements Animation.AnimationListener {
    private final /* synthetic */ float brl;
    final /* synthetic */ f brm;
    private final /* synthetic */ View yW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar, float f, View view) {
        this.brm = fVar;
        this.brl = f;
        this.yW = view;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, this.brl, 1.0f, 1.0f);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(300L);
        this.yW.startAnimation(scaleAnimation);
    }
}
