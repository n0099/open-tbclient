package com.baidu.tieba.frs;

import android.animation.Animator;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cr implements Animator.AnimatorListener {
    final /* synthetic */ co bQR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cr(co coVar) {
        this.bQR = coVar;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        View view;
        View view2;
        view = this.bQR.bQM;
        if (view != null) {
            this.bQR.aap();
            view2 = this.bQR.bQM;
            view2.setAlpha(1.0f);
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }
}
