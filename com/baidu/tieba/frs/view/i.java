package com.baidu.tieba.frs.view;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
/* loaded from: classes.dex */
class i implements Animation.AnimationListener {
    private final /* synthetic */ float bVR;
    final /* synthetic */ h bVS;
    private final /* synthetic */ View qa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, float f, View view) {
        this.bVS = hVar;
        this.bVR = f;
        this.qa = view;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, this.bVR, 1.0f, 1.0f);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(300L);
        this.qa.startAnimation(scaleAnimation);
    }
}
