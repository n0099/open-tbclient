package com.baidu.tieba.frs;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class bb {
    private TranslateAnimation bUt;
    private View jlo = null;
    private int jlp = 2000;
    private Runnable bUu = new Runnable() { // from class: com.baidu.tieba.frs.bb.1
        @Override // java.lang.Runnable
        public void run() {
            bb.this.hideTip();
        }
    };
    private ValueAnimator jlq = new ValueAnimator();

    public bb() {
        this.jlq.setFloatValues(1.0f, 0.0f);
        this.jlq.setDuration(400L);
        this.jlq.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.bb.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (bb.this.jlo != null && valueAnimator != null) {
                    bb.this.jlo.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.jlq.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.bb.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (bb.this.jlo != null) {
                    bb.this.cEQ();
                    bb.this.jlo.setAlpha(1.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.bUt = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds56), 0.0f);
        this.bUt.setDuration(400L);
        this.bUt.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.bb.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                com.baidu.adp.lib.f.e.mA().postDelayed(bb.this.bUu, bb.this.jlp);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i) {
        if (viewGroup != null && view != null) {
            this.jlo = view;
            cEQ();
            viewGroup.addView(this.jlo, layoutParams);
            this.jlo.setVisibility(0);
            this.jlp = i;
            com.baidu.adp.lib.f.e.mA().removeCallbacks(this.bUu);
            com.baidu.adp.lib.f.e.mA().postDelayed(this.bUu, this.jlp);
        }
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup != null && view != null) {
            this.jlo = view;
            cEQ();
            viewGroup.addView(this.jlo, layoutParams);
            this.jlo.setVisibility(0);
        }
    }

    public void hideTip() {
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.bUu);
        if (this.jlo != null && this.jlo.getParent() != null && this.jlo.getVisibility() == 0 && !this.jlq.isRunning()) {
            this.jlq.start();
        }
    }

    public void cEQ() {
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.bUu);
        if (this.jlo != null) {
            if (this.jlq != null && this.jlq.isRunning()) {
                this.jlq.cancel();
            }
            this.jlo.clearAnimation();
            if (this.jlo.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.jlo.getParent()).removeView(this.jlo);
            }
            this.jlo.setVisibility(8);
        }
    }

    public void onDestroy() {
        cEQ();
    }
}
