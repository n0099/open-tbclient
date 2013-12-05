package com.baidu.tieba;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class aj implements Animation.AnimationListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LogoActivity f1116a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(LogoActivity logoActivity) {
        this.f1116a = logoActivity;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        boolean z;
        this.f1116a.b = true;
        z = this.f1116a.c;
        if (z) {
            this.f1116a.a(this.f1116a.getBaseContext());
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
