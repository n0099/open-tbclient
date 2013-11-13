package com.baidu.tieba.editortool;

import android.view.ViewGroup;
import android.view.animation.Animation;
/* loaded from: classes.dex */
final class n implements Animation.AnimationListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ o f1231a;
    final /* synthetic */ ViewGroup b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(o oVar, ViewGroup viewGroup) {
        this.f1231a = oVar;
        this.b = viewGroup;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        if (this.f1231a != null) {
            this.f1231a.a();
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
