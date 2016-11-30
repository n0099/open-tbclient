package com.baidu.tieba.frs.view;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
/* loaded from: classes.dex */
class j implements Animation.AnimationListener {
    private final /* synthetic */ float cmg;
    final /* synthetic */ i cmh;
    private final /* synthetic */ View sq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar, float f, View view) {
        this.cmh = iVar;
        this.cmg = f;
        this.sq = view;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, this.cmg, 1.0f, 1.0f);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(300L);
        this.sq.startAnimation(scaleAnimation);
    }
}
