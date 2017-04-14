package com.baidu.tieba.frs;

import android.animation.ValueAnimator;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cs implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ cq bQG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cs(cq cqVar) {
        this.bQG = cqVar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        View view;
        View view2;
        view = this.bQG.bQB;
        if (view != null && valueAnimator != null) {
            view2 = this.bQG.bQB;
            view2.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }
}
