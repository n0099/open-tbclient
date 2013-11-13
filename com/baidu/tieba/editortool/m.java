package com.baidu.tieba.editortool;

import android.view.ViewGroup;
import android.view.animation.Animation;
/* loaded from: classes.dex */
final class m implements Animation.AnimationListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ o f1230a;
    final /* synthetic */ ViewGroup b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(o oVar, ViewGroup viewGroup) {
        this.f1230a = oVar;
        this.b = viewGroup;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        if (this.f1230a != null) {
            this.f1230a.a();
        }
        this.b.setVisibility(0);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.b.setVisibility(8);
        if (this.f1230a != null) {
            this.f1230a.b();
        }
    }
}
