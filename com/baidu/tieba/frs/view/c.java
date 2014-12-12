package com.baidu.tieba.frs.view;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
/* loaded from: classes.dex */
class c implements Animation.AnimationListener {
    private final /* synthetic */ float aGD;
    final /* synthetic */ b aGE;
    private final /* synthetic */ View ns;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, float f, View view) {
        this.aGE = bVar;
        this.aGD = f;
        this.ns = view;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, this.aGD, 1.0f, 1.0f);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(300L);
        this.ns.startAnimation(scaleAnimation);
    }
}
