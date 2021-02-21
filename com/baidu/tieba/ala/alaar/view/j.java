package com.baidu.tieba.ala.alaar.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
/* loaded from: classes11.dex */
public class j {
    private boolean bbQ;
    protected a gxm;
    private ValueAnimator gxn;
    View view;

    /* loaded from: classes11.dex */
    public interface a {
        void a(k kVar, View view);
    }

    public void show() {
        show(true);
    }

    public void show(boolean z) {
        if (!this.bbQ) {
            this.bbQ = true;
            onShow();
            if (z) {
                Ba();
            } else {
                mo(isShowing());
            }
        }
    }

    public boolean isShowing() {
        return this.bbQ;
    }

    public void dismiss(boolean z) {
        if (this.bbQ) {
            this.bbQ = false;
            onDismiss();
            if (z) {
                bQP();
            } else {
                mo(isShowing());
            }
        }
    }

    private void bQP() {
        this.gxn = A(0.0f, 1.0f);
    }

    private void Ba() {
        mo(isShowing());
        this.gxn = A(1.0f, 0.0f);
    }

    private ValueAnimator A(float f, float f2) {
        if (this.gxn != null && this.gxn.isRunning()) {
            this.gxn.cancel();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f, f2);
        ofFloat.setDuration(250L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.alaar.view.j.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                j.this.a(valueAnimator);
            }
        });
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.alaar.view.j.2
            boolean gxp;

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                this.gxp = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (!this.gxp) {
                    j.this.mo(j.this.isShowing());
                }
            }
        });
        ofFloat.start();
        return ofFloat;
    }

    protected void a(ValueAnimator valueAnimator) {
    }

    protected void mo(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onShow() {
    }

    protected void onDismiss() {
    }

    public void a(a aVar) {
        this.gxm = aVar;
    }
}
