package com.baidu.tieba;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class af implements Animation.AnimationListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LogoActivity f688a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(LogoActivity logoActivity) {
        this.f688a = logoActivity;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        boolean z;
        this.f688a.b = true;
        z = this.f688a.c;
        if (!z) {
            return;
        }
        this.f688a.d();
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
