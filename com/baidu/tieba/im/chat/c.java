package com.baidu.tieba.im.chat;

import android.view.animation.Animation;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
final class c implements Animation.AnimationListener {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.a = bVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        a aVar;
        a aVar2;
        boolean z;
        a aVar3;
        a aVar4;
        NavigationBar navigationBar;
        aVar = this.a.a;
        aVar.o = true;
        aVar2 = this.a.a;
        z = aVar2.p;
        if (z) {
            aVar3 = this.a.a;
            aVar3.p = false;
            aVar4 = this.a.a;
            navigationBar = aVar4.i;
            navigationBar.setVisibility(8);
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation animation) {
    }
}
