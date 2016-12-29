package com.baidu.tieba.e;

import android.view.View;
import android.view.animation.Animation;
import com.baidu.tieba.e.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Animation.AnimationListener {
    final /* synthetic */ c bsy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar) {
        this.bsy = cVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        View view;
        View view2;
        View view3;
        c.a aVar;
        c.a aVar2;
        view = this.bsy.bss;
        if (view != null) {
            view2 = this.bsy.bss;
            view2.clearAnimation();
            view3 = this.bsy.bss;
            view3.setVisibility(8);
            this.bsy.de(true);
            aVar = this.bsy.bsp;
            if (aVar != null) {
                aVar2 = this.bsy.bsp;
                aVar2.df(false);
            }
        }
    }
}
