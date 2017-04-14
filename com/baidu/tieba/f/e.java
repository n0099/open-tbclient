package com.baidu.tieba.f;

import android.view.View;
import android.view.animation.Animation;
import com.baidu.tieba.f.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Animation.AnimationListener {
    final /* synthetic */ c bHj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar) {
        this.bHj = cVar;
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
        view = this.bHj.bHc;
        if (view != null) {
            view2 = this.bHj.bHc;
            view2.clearAnimation();
            view3 = this.bHj.bHc;
            view3.setVisibility(8);
            this.bHj.dn(true);
            aVar = this.bHj.bGZ;
            if (aVar != null) {
                aVar2 = this.bHj.bGZ;
                aVar2.m17do(false);
            }
        }
    }
}
