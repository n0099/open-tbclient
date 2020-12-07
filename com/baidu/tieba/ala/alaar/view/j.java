package com.baidu.tieba.ala.alaar.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
/* loaded from: classes4.dex */
public class j {
    private boolean bbP;
    protected a gow;
    private ValueAnimator gox;
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
                bRw();
            } else {
                lR(isShowing());
            }
        }
    }

    private void bRw() {
        this.gox = z(0.0f, 1.0f);
    }

    private void EW() {
        lR(isShowing());
        this.gox = z(1.0f, 0.0f);
    }

    private ValueAnimator z(float f, float f2) {
        if (this.gox != null && this.gox.isRunning()) {
            this.gox.cancel();
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
            boolean goz;

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                this.goz = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (!this.goz) {
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
        this.gow = aVar;
    }
}
