package com.baidu.tieba.frs;

import android.animation.Animator;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ct implements Animator.AnimatorListener {
    final /* synthetic */ cq bSX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ct(cq cqVar) {
        this.bSX = cqVar;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        View view;
        View view2;
        view = this.bSX.bSS;
        if (view != null) {
            this.bSX.abO();
            view2 = this.bSX.bSS;
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
