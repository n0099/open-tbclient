package com.baidu.tieba;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class ah implements Animation.AnimationListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LogoActivity f901a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(LogoActivity logoActivity) {
        this.f901a = logoActivity;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        boolean z;
        this.f901a.b = true;
        z = this.f901a.c;
        if (!z) {
            return;
        }
        this.f901a.a(this.f901a.getBaseContext());
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
