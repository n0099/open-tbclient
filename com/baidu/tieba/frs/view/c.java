package com.baidu.tieba.frs.view;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
/* loaded from: classes.dex */
class c implements Animation.AnimationListener {
    private final /* synthetic */ float aEW;
    final /* synthetic */ b aEX;
    private final /* synthetic */ View nt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, float f, View view) {
        this.aEX = bVar;
        this.aEW = f;
        this.nt = view;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, this.aEW, 1.0f, 1.0f);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(300L);
        this.nt.startAnimation(scaleAnimation);
    }
}
