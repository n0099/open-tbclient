package com.baidu.tieba.e;

import android.view.View;
import android.view.animation.Animation;
import com.baidu.tieba.e.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Animation.AnimationListener {
    final /* synthetic */ c bJB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(c cVar) {
        this.bJB = cVar;
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
        view = this.bJB.bJv;
        if (view != null) {
            view2 = this.bJB.bJv;
            view2.clearAnimation();
            view3 = this.bJB.bJv;
            view3.setVisibility(0);
            this.bJB.dr(false);
            aVar = this.bJB.bJs;
            if (aVar != null) {
                aVar2 = this.bJB.bJs;
                aVar2.ds(true);
            }
        }
    }
}
