package com.baidu.tieba.ala.alaar.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
/* loaded from: classes11.dex */
public class j {
    private boolean bdx;
    protected a gyV;
    private ValueAnimator gyW;
    View view;

    /* loaded from: classes11.dex */
    public interface a {
        void a(k kVar, View view);
    }

    public void show() {
        show(true);
    }

    public void show(boolean z) {
        if (!this.bdx) {
            this.bdx = true;
            onShow();
            if (z) {
                El();
            } else {
                mo(isShowing());
            }
        }
    }

    public boolean isShowing() {
        return this.bdx;
    }

    public void dismiss(boolean z) {
        if (this.bdx) {
            this.bdx = false;
            onDismiss();
            if (z) {
                bTV();
            } else {
                mo(isShowing());
            }
        }
    }

    private void bTV() {
        this.gyW = z(0.0f, 1.0f);
    }

    private void El() {
        mo(isShowing());
        this.gyW = z(1.0f, 0.0f);
    }

    private ValueAnimator z(float f, float f2) {
        if (this.gyW != null && this.gyW.isRunning()) {
            this.gyW.cancel();
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
            boolean gyY;

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                this.gyY = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (!this.gyY) {
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
        this.gyV = aVar;
    }
}
