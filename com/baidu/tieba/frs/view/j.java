package com.baidu.tieba.frs.view;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
/* loaded from: classes.dex */
class j implements Animation.AnimationListener {
    private final /* synthetic */ float cfq;
    final /* synthetic */ i cfr;
    private final /* synthetic */ View zB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar, float f, View view) {
        this.cfr = iVar;
        this.cfq = f;
        this.zB = view;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, this.cfq, 1.0f, 1.0f);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(300L);
        this.zB.startAnimation(scaleAnimation);
    }
}
