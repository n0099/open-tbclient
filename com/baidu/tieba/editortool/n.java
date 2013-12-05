package com.baidu.tieba.editortool;

import android.view.ViewGroup;
import android.view.animation.Animation;
/* loaded from: classes.dex */
final class n implements Animation.AnimationListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ o f1283a;
    final /* synthetic */ ViewGroup b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(o oVar, ViewGroup viewGroup) {
        this.f1283a = oVar;
        this.b = viewGroup;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        if (this.f1283a != null) {
            this.f1283a.a();
        }
        this.b.setVisibility(0);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.b.setVisibility(8);
    }
}
