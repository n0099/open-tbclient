package com.baidu.tieba.im.chat;

import android.view.animation.Animation;
import com.baidu.tieba.view.NavigationBar;
/* loaded from: classes.dex */
class ah implements Animation.AnimationListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ag f1541a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(ag agVar) {
        this.f1541a = agVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        boolean z;
        NavigationBar navigationBar;
        this.f1541a.f1540a.o = true;
        z = this.f1541a.f1540a.p;
        if (z) {
            this.f1541a.f1540a.p = false;
            navigationBar = this.f1541a.f1540a.i;
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
