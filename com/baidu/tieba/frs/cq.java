package com.baidu.tieba.frs;

import android.animation.ValueAnimator;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cq implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ co bJL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cq(co coVar) {
        this.bJL = coVar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        View view;
        View view2;
        view = this.bJL.bJG;
        if (view != null && valueAnimator != null) {
            view2 = this.bJL.bJG;
            view2.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }
}
