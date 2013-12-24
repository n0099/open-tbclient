package com.baidu.tieba.frs;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class ao implements Animation.AnimationListener {
    final /* synthetic */ com.baidu.adp.lib.guide.d a;
    final /* synthetic */ am b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(am amVar, com.baidu.adp.lib.guide.d dVar) {
        this.b = amVar;
        this.a = dVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.a.a();
    }
}
