package com.baidu.tieba.frs;

import android.animation.ValueAnimator;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cj implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ ch bRq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cj(ch chVar) {
        this.bRq = chVar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        View view;
        View view2;
        view = this.bRq.bRl;
        if (view != null && valueAnimator != null) {
            view2 = this.bRq.bRl;
            view2.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }
}
