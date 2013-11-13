package com.baidu.tieba.im.chat;

import android.view.animation.Animation;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
class ae implements Animation.AnimationListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ad f1500a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ad adVar) {
        this.f1500a = adVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        boolean z;
        LinearLayout linearLayout;
        this.f1500a.f1499a.n = true;
        z = this.f1500a.f1499a.o;
        if (z) {
            this.f1500a.f1499a.o = false;
            linearLayout = this.f1500a.f1499a.h;
            linearLayout.setVisibility(8);
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
