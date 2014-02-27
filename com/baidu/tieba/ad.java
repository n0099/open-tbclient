package com.baidu.tieba;

import android.view.animation.Animation;
/* loaded from: classes.dex */
final class ad implements Animation.AnimationListener {
    final /* synthetic */ LogoActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(LogoActivity logoActivity) {
        this.a = logoActivity;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        boolean z;
        this.a.b = true;
        z = this.a.c;
        if (z) {
            LogoActivity logoActivity = this.a;
            this.a.getBaseContext();
            logoActivity.a();
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation animation) {
    }
}
