package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Animation.AnimationListener {
    final /* synthetic */ a aEV;
    private final /* synthetic */ float aEW;
    private final /* synthetic */ View nt;
    private final /* synthetic */ Context val$context;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, Context context, View view, float f) {
        this.aEV = aVar;
        this.val$context = context;
        this.nt = view;
        this.aEW = f;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 1.0f);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(300L);
        com.baidu.tbadk.core.a.a(this.val$context, this.nt, scaleAnimation, new c(this, this.aEW, this.nt));
    }
}
