package com.baidu.tieba.editortool;

import android.view.ViewGroup;
import android.view.animation.Animation;
/* loaded from: classes.dex */
class ad implements Animation.AnimationListener {
    private final /* synthetic */ ae a;
    private final /* synthetic */ ViewGroup b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ae aeVar, ViewGroup viewGroup) {
        this.a = aeVar;
        this.b = viewGroup;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        if (this.a != null) {
            this.a.a();
        }
        this.b.setVisibility(0);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.b.setVisibility(8);
        if (this.a != null) {
            this.a.b();
        }
    }
}
