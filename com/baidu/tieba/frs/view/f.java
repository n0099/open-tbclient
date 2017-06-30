package com.baidu.tieba.frs.view;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
/* loaded from: classes.dex */
class f implements Animation.AnimationListener {
    private final /* synthetic */ float crs;
    final /* synthetic */ e crt;
    private final /* synthetic */ View zg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar, float f, View view) {
        this.crt = eVar;
        this.crs = f;
        this.zg = view;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, this.crs, 1.0f, 1.0f);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(300L);
        this.zg.startAnimation(scaleAnimation);
    }
}
