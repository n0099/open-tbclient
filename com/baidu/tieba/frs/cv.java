package com.baidu.tieba.frs;

import android.animation.Animator;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cv implements Animator.AnimatorListener {
    final /* synthetic */ cs bCv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cv(cs csVar) {
        this.bCv = csVar;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        View view;
        View view2;
        view = this.bCv.bCq;
        if (view != null) {
            this.bCv.Yj();
            view2 = this.bCv.bCq;
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
