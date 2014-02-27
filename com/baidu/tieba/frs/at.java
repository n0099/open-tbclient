package com.baidu.tieba.frs;

import android.view.animation.Animation;
/* loaded from: classes.dex */
final class at implements Animation.AnimationListener {
    final /* synthetic */ ar a;
    private final /* synthetic */ com.baidu.adp.lib.guide.d b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(ar arVar, com.baidu.adp.lib.guide.d dVar) {
        this.a = arVar;
        this.b = dVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        this.b.a();
    }
}
