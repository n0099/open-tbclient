package com.baidu.tieba.frs;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class bt implements Animation.AnimationListener {
    final /* synthetic */ br a;
    private final /* synthetic */ com.baidu.adp.lib.guide.d b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(br brVar, com.baidu.adp.lib.guide.d dVar) {
        this.a = brVar;
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
