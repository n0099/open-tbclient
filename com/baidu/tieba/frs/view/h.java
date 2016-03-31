package com.baidu.tieba.frs.view;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
/* loaded from: classes.dex */
class h implements Animation.AnimationListener {
    private final /* synthetic */ float bwt;
    final /* synthetic */ g bwu;
    private final /* synthetic */ View zn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar, float f, View view) {
        this.bwu = gVar;
        this.bwt = f;
        this.zn = view;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, this.bwt, 1.0f, 1.0f);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(300L);
        this.zn.startAnimation(scaleAnimation);
    }
}
