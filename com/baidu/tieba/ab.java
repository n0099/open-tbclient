package com.baidu.tieba;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class ab implements Animation.AnimationListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LogoActivity f1016a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(LogoActivity logoActivity) {
        this.f1016a = logoActivity;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        boolean z;
        this.f1016a.b = true;
        z = this.f1016a.c;
        if (z) {
            this.f1016a.a(this.f1016a.getBaseContext());
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
