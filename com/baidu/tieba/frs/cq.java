package com.baidu.tieba.frs;

import android.animation.ValueAnimator;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cq implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ co bQR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cq(co coVar) {
        this.bQR = coVar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        View view;
        View view2;
        view = this.bQR.bQM;
        if (view != null && valueAnimator != null) {
            view2 = this.bQR.bQM;
            view2.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }
}
