package com.baidu.tieba.frs;

import android.animation.ValueAnimator;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cs implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ cq bSX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cs(cq cqVar) {
        this.bSX = cqVar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        View view;
        View view2;
        view = this.bSX.bSS;
        if (view != null && valueAnimator != null) {
            view2 = this.bSX.bSS;
            view2.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }
}
