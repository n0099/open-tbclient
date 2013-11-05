package com.baidu.tieba.im.groupInfo;

import android.view.animation.Animation;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
class e implements Animation.AnimationListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f1600a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.f1600a = dVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        boolean z;
        LinearLayout linearLayout;
        this.f1600a.f1599a.p = true;
        z = this.f1600a.f1599a.q;
        if (z) {
            this.f1600a.f1599a.q = false;
            linearLayout = this.f1600a.f1599a.j;
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
