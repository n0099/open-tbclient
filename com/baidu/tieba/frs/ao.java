package com.baidu.tieba.frs;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class ao implements Animation.AnimationListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.baidu.adp.lib.guide.d f1371a;
    final /* synthetic */ am b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(am amVar, com.baidu.adp.lib.guide.d dVar) {
        this.b = amVar;
        this.f1371a = dVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.f1371a.a();
    }
}
