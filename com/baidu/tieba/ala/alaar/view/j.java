package com.baidu.tieba.ala.alaar.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
/* loaded from: classes4.dex */
public class j {
    private boolean bbP;
    protected a goy;
    private ValueAnimator goz;
    View view;

    /* loaded from: classes4.dex */
    public interface a {
        void a(k kVar, View view);
    }

    public void show() {
        show(true);
    }

    public void show(boolean z) {
        if (!this.bbP) {
            this.bbP = true;
            QM();
            if (z) {
                EW();
            } else {
                lR(isShowing());
            }
        }
    }

    public boolean isShowing() {
        return this.bbP;
    }

    public void dismiss(boolean z) {
        if (this.bbP) {
            this.bbP = false;
            onDismiss();
            if (z) {
                bRx();
            } else {
                lR(isShowing());
            }
        }
    }

    private void bRx() {
        this.goz = z(0.0f, 1.0f);
    }

    private void EW() {
        lR(isShowing());
        this.goz = z(1.0f, 0.0f);
    }

    private ValueAnimator z(float f, float f2) {
        if (this.goz != null && this.goz.isRunning()) {
            this.goz.cancel();
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
            boolean goB;

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                this.goB = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (!this.goB) {
                    j.this.lR(j.this.isShowing());
                }
            }
        });
        ofFloat.start();
        return ofFloat;
    }

    protected void a(ValueAnimator valueAnimator) {
    }

    protected void lR(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void QM() {
    }

    protected void onDismiss() {
    }

    public void a(a aVar) {
        this.goy = aVar;
    }
}
