package com.baidu.tieba.frs;

import android.animation.ValueAnimator;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cl implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ cj cfp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cl(cj cjVar) {
        this.cfp = cjVar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        View view;
        View view2;
        view = this.cfp.cfk;
        if (view != null && valueAnimator != null) {
            view2 = this.cfp.cfk;
            view2.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }
}
