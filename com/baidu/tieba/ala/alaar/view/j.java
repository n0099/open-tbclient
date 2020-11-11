package com.baidu.tieba.ala.alaar.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
/* loaded from: classes4.dex */
public class j {
    protected a ggG;
    private ValueAnimator ggH;
    private boolean mShowing;
    View view;

    /* loaded from: classes4.dex */
    public interface a {
        void a(k kVar, View view);
    }

    public void show() {
        show(true);
    }

    public void show(boolean z) {
        if (!this.mShowing) {
            this.mShowing = true;
            Pc();
            if (z) {
                DV();
            } else {
                lv(isShowing());
            }
        }
    }

    public boolean isShowing() {
        return this.mShowing;
    }

    public void dismiss(boolean z) {
        if (this.mShowing) {
            this.mShowing = false;
            onDismiss();
            if (z) {
                bOs();
            } else {
                lv(isShowing());
            }
        }
    }

    private void bOs() {
        this.ggH = z(0.0f, 1.0f);
    }

    private void DV() {
        lv(isShowing());
        this.ggH = z(1.0f, 0.0f);
    }

    private ValueAnimator z(float f, float f2) {
        if (this.ggH != null && this.ggH.isRunning()) {
            this.ggH.cancel();
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
            boolean isCanceled;

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                this.isCanceled = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (!this.isCanceled) {
                    j.this.lv(j.this.isShowing());
                }
            }
        });
        ofFloat.start();
        return ofFloat;
    }

    protected void a(ValueAnimator valueAnimator) {
    }

    protected void lv(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Pc() {
    }

    protected void onDismiss() {
    }

    public void a(a aVar) {
        this.ggG = aVar;
    }
}
