package com.baidu.tieba.frs;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class ak implements Animation.AnimationListener {
    final /* synthetic */ com.baidu.adp.lib.guide.d a;
    final /* synthetic */ ai b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(ai aiVar, com.baidu.adp.lib.guide.d dVar) {
        this.b = aiVar;
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
