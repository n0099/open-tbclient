package com.baidu.tieba.frs;

import android.animation.ValueAnimator;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cu implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ cs bWl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cu(cs csVar) {
        this.bWl = csVar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        View view;
        View view2;
        view = this.bWl.bWg;
        if (view != null && valueAnimator != null) {
            view2 = this.bWl.bWg;
            view2.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }
}
