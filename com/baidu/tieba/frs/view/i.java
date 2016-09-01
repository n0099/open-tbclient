package com.baidu.tieba.frs.view;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
/* loaded from: classes.dex */
class i implements Animation.AnimationListener {
    private final /* synthetic */ float chb;
    final /* synthetic */ h chc;
    private final /* synthetic */ View so;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, float f, View view) {
        this.chc = hVar;
        this.chb = f;
        this.so = view;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, this.chb, 1.0f, 1.0f);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(300L);
        this.so.startAnimation(scaleAnimation);
    }
}
