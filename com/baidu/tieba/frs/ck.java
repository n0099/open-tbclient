package com.baidu.tieba.frs;

import android.animation.Animator;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ck implements Animator.AnimatorListener {
    final /* synthetic */ ch bRq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ck(ch chVar) {
        this.bRq = chVar;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        View view;
        View view2;
        view = this.bRq.bRl;
        if (view != null) {
            this.bRq.aaf();
            view2 = this.bRq.bRl;
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
