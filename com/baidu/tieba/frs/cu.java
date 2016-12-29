package com.baidu.tieba.frs;

import android.animation.ValueAnimator;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cu implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ cs bCv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cu(cs csVar) {
        this.bCv = csVar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        View view;
        View view2;
        view = this.bCv.bCq;
        if (view != null && valueAnimator != null) {
            view2 = this.bCv.bCq;
            view2.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }
}
