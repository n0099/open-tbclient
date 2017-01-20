package com.baidu.tieba.frs.view;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
/* loaded from: classes.dex */
class j implements Animation.AnimationListener {
    private final /* synthetic */ float bXU;
    final /* synthetic */ i bXV;
    private final /* synthetic */ View sg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar, float f, View view) {
        this.bXV = iVar;
        this.bXU = f;
        this.sg = view;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, this.bXU, 1.0f, 1.0f);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(300L);
        this.sg.startAnimation(scaleAnimation);
    }
}
