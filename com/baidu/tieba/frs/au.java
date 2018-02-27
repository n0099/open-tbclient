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
public class au {
    private TranslateAnimation mTipInAnimation;
    private View dHy = null;
    private int dHz = 2000;
    private Runnable mHideTipRunnable = new Runnable() { // from class: com.baidu.tieba.frs.au.1
        @Override // java.lang.Runnable
        public void run() {
            au.this.hideTip();
        }
    };
    private ValueAnimator dHA = new ValueAnimator();

    public au() {
        this.dHA.setFloatValues(1.0f, 0.0f);
        this.dHA.setDuration(400L);
        this.dHA.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.au.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (au.this.dHy != null && valueAnimator != null) {
                    au.this.dHy.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.dHA.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.au.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (au.this.dHy != null) {
                    au.this.awu();
                    au.this.dHy.setAlpha(1.0f);
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
        this.mTipInAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.au.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                com.baidu.adp.lib.g.e.ns().postDelayed(au.this.mHideTipRunnable, au.this.dHz);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i) {
        if (viewGroup != null && view != null) {
            this.dHy = view;
            awu();
            viewGroup.addView(this.dHy, layoutParams);
            this.dHy.setVisibility(0);
            this.dHz = i;
            com.baidu.adp.lib.g.e.ns().removeCallbacks(this.mHideTipRunnable);
            com.baidu.adp.lib.g.e.ns().postDelayed(this.mHideTipRunnable, this.dHz);
        }
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup != null && view != null) {
            this.dHy = view;
            awu();
            viewGroup.addView(this.dHy, layoutParams);
            this.dHy.setVisibility(0);
        }
    }

    public void hideTip() {
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.mHideTipRunnable);
        if (this.dHy != null && this.dHy.getParent() != null && this.dHy.getVisibility() == 0 && !this.dHA.isRunning()) {
            this.dHA.start();
        }
    }

    public void awu() {
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.mHideTipRunnable);
        if (this.dHy != null) {
            if (this.dHA != null && this.dHA.isRunning()) {
                this.dHA.cancel();
            }
            this.dHy.clearAnimation();
            if (this.dHy.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.dHy.getParent()).removeView(this.dHy);
            }
            this.dHy.setVisibility(8);
        }
    }

    public void onDestroy() {
        awu();
    }
}
