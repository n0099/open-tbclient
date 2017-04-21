package com.baidu.tieba.frs.view;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
/* loaded from: classes.dex */
class j implements Animation.AnimationListener {
    private final /* synthetic */ float cgh;
    final /* synthetic */ i cgi;
    private final /* synthetic */ View zf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar, float f, View view) {
        this.cgi = iVar;
        this.cgh = f;
        this.zf = view;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, this.cgh, 1.0f, 1.0f);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(300L);
        this.zf.startAnimation(scaleAnimation);
    }
}
