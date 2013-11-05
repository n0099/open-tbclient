package com.baidu.tieba.im.chat;

import android.view.animation.Animation;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
class af implements Animation.AnimationListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ae f1408a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ae aeVar) {
        this.f1408a = aeVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        boolean z;
        LinearLayout linearLayout;
        this.f1408a.f1407a.p = true;
        z = this.f1408a.f1407a.q;
        if (z) {
            this.f1408a.f1407a.q = false;
            linearLayout = this.f1408a.f1407a.j;
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
