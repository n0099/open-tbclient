package com.baidu.tieba;

import android.view.animation.Animation;
/* loaded from: classes.dex */
final class h implements Animation.AnimationListener {
    final /* synthetic */ LogoActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(LogoActivity logoActivity) {
        this.a = logoActivity;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        boolean z;
        this.a.a = true;
        z = this.a.b;
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
