package com.baidu.tieba.frs;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class as {
    private TranslateAnimation mTipInAnimation;
    private View cKr = null;
    private int cKs = 2000;
    private Runnable mHideTipRunnable = new Runnable() { // from class: com.baidu.tieba.frs.as.1
        @Override // java.lang.Runnable
        public void run() {
            as.this.hideTip();
        }
    };
    private ValueAnimator cKt = new ValueAnimator();

    public as() {
        this.cKt.setFloatValues(1.0f, 0.0f);
        this.cKt.setDuration(400L);
        this.cKt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.as.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (as.this.cKr != null && valueAnimator != null) {
                    as.this.cKr.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.cKt.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.as.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (as.this.cKr != null) {
                    as.this.amA();
                    as.this.cKr.setAlpha(1.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.mTipInAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.getInst().getResources().getDimension(d.e.ds56), 0.0f);
        this.mTipInAnimation.setDuration(400L);
        this.mTipInAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.as.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                com.baidu.adp.lib.g.e.fP().postDelayed(as.this.mHideTipRunnable, as.this.cKs);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i) {
        if (viewGroup != null && view != null) {
            this.cKr = view;
            amA();
            viewGroup.addView(this.cKr, layoutParams);
            this.cKr.setVisibility(0);
            this.cKs = i;
            com.baidu.adp.lib.g.e.fP().removeCallbacks(this.mHideTipRunnable);
            com.baidu.adp.lib.g.e.fP().postDelayed(this.mHideTipRunnable, this.cKs);
        }
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup != null && view != null) {
            this.cKr = view;
            amA();
            viewGroup.addView(this.cKr, layoutParams);
            this.cKr.setVisibility(0);
        }
    }

    public void hideTip() {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.mHideTipRunnable);
        if (this.cKr != null && this.cKr.getParent() != null && this.cKr.getVisibility() == 0 && !this.cKt.isRunning()) {
            this.cKt.start();
        }
    }

    public void amA() {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.mHideTipRunnable);
        if (this.cKr != null) {
            if (this.cKt != null && this.cKt.isRunning()) {
                this.cKt.cancel();
            }
            this.cKr.clearAnimation();
            if (this.cKr.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.cKr.getParent()).removeView(this.cKr);
            }
            this.cKr.setVisibility(8);
        }
    }

    public void onDestroy() {
        amA();
    }
}
