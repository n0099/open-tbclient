package com.baidu.tieba.ala.alaar.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
/* loaded from: classes10.dex */
public class j {
    private boolean aYJ;
    protected a guo;
    private ValueAnimator gup;
    View view;

    /* loaded from: classes10.dex */
    public interface a {
        void a(k kVar, View view);
    }

    public void show() {
        show(true);
    }

    public void show(boolean z) {
        if (!this.aYJ) {
            this.aYJ = true;
            onShow();
            if (z) {
                Aq();
            } else {
                mk(isShowing());
            }
        }
    }

    public boolean isShowing() {
        return this.aYJ;
    }

    public void dismiss(boolean z) {
        if (this.aYJ) {
            this.aYJ = false;
            onDismiss();
            if (z) {
                bQe();
            } else {
                mk(isShowing());
            }
        }
    }

    private void bQe() {
        this.gup = A(0.0f, 1.0f);
    }

    private void Aq() {
        mk(isShowing());
        this.gup = A(1.0f, 0.0f);
    }

    private ValueAnimator A(float f, float f2) {
        if (this.gup != null && this.gup.isRunning()) {
            this.gup.cancel();
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
            boolean gur;

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                this.gur = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (!this.gur) {
                    j.this.mk(j.this.isShowing());
                }
            }
        });
        ofFloat.start();
        return ofFloat;
    }

    protected void a(ValueAnimator valueAnimator) {
    }

    protected void mk(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onShow() {
    }

    protected void onDismiss() {
    }

    public void a(a aVar) {
        this.guo = aVar;
    }
}
