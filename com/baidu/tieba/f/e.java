package com.baidu.tieba.f;

import android.view.View;
import android.view.animation.Animation;
import com.baidu.tieba.f.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Animation.AnimationListener {
    final /* synthetic */ c bJA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar) {
        this.bJA = cVar;
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
        view = this.bJA.bJt;
        if (view != null) {
            view2 = this.bJA.bJt;
            view2.clearAnimation();
            view3 = this.bJA.bJt;
            view3.setVisibility(8);
            this.bJA.dx(true);
            aVar = this.bJA.bJq;
            if (aVar != null) {
                aVar2 = this.bJA.bJq;
                aVar2.dy(false);
            }
        }
    }
}
