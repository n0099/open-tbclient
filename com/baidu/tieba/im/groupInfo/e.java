package com.baidu.tieba.im.groupInfo;

import android.view.animation.Animation;
import com.baidu.tieba.view.NavigationBar;
/* loaded from: classes.dex */
class e implements Animation.AnimationListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f1745a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.f1745a = dVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        boolean z;
        NavigationBar navigationBar;
        this.f1745a.f1744a.o = true;
        z = this.f1745a.f1744a.p;
        if (z) {
            this.f1745a.f1744a.p = false;
            navigationBar = this.f1745a.f1744a.e;
            navigationBar.setVisibility(8);
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
