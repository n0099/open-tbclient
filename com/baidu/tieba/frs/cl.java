package com.baidu.tieba.frs;

import android.animation.Animator;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cl implements Animator.AnimatorListener {
    final /* synthetic */ ci bXg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cl(ci ciVar) {
        this.bXg = ciVar;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        View view;
        View view2;
        view = this.bXg.bXb;
        if (view != null) {
            this.bXg.abh();
            view2 = this.bXg.bXb;
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
