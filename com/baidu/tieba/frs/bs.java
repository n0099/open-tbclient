package com.baidu.tieba.frs;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class bs implements Animation.AnimationListener {
    final /* synthetic */ bq a;
    private final /* synthetic */ com.baidu.adp.lib.guide.d b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(bq bqVar, com.baidu.adp.lib.guide.d dVar) {
        this.a = bqVar;
        this.b = dVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.b.a();
    }
}
