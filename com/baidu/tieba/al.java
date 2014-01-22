package com.baidu.tieba;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class al implements Animation.AnimationListener {
    final /* synthetic */ LogoActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(LogoActivity logoActivity) {
        this.a = logoActivity;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        boolean z;
        this.a.b = true;
        z = this.a.c;
        if (z) {
            this.a.a(this.a.getBaseContext());
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
