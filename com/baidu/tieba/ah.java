package com.baidu.tieba;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class ah implements Animation.AnimationListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LogoActivity f903a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(LogoActivity logoActivity) {
        this.f903a = logoActivity;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        boolean z;
        this.f903a.b = true;
        z = this.f903a.c;
        if (!z) {
            return;
        }
        this.f903a.a(this.f903a.getBaseContext());
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
