package com.baidu.tieba.frs;

import android.view.animation.Animation;
/* loaded from: classes.dex */
final class bl implements Animation.AnimationListener {
    final /* synthetic */ bj a;
    private final /* synthetic */ com.baidu.adp.lib.guide.d b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(bj bjVar, com.baidu.adp.lib.guide.d dVar) {
        this.a = bjVar;
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
