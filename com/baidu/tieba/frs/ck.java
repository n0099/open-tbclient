package com.baidu.tieba.frs;

import android.animation.ValueAnimator;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ck implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ ci bXg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ck(ci ciVar) {
        this.bXg = ciVar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        View view;
        View view2;
        view = this.bXg.bXb;
        if (view != null && valueAnimator != null) {
            view2 = this.bXg.bXb;
            view2.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }
}
