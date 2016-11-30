package com.baidu.tieba.e;

import android.view.View;
import android.view.animation.Animation;
import com.baidu.tieba.e.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Animation.AnimationListener {
    final /* synthetic */ c bMu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar) {
        this.bMu = cVar;
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
        view = this.bMu.bMo;
        if (view != null) {
            view2 = this.bMu.bMo;
            view2.clearAnimation();
            view3 = this.bMu.bMo;
            view3.setVisibility(8);
            this.bMu.dw(true);
            aVar = this.bMu.bMl;
            if (aVar != null) {
                aVar2 = this.bMu.bMl;
                aVar2.dx(false);
            }
        }
    }
}
