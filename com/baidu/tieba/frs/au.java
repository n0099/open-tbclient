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
    private View dHD = null;
    private int dHE = 2000;
    private Runnable mHideTipRunnable = new Runnable() { // from class: com.baidu.tieba.frs.au.1
        @Override // java.lang.Runnable
        public void run() {
            au.this.hideTip();
        }
    };
    private ValueAnimator dHF = new ValueAnimator();

    public au() {
        this.dHF.setFloatValues(1.0f, 0.0f);
        this.dHF.setDuration(400L);
        this.dHF.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.au.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (au.this.dHD != null && valueAnimator != null) {
                    au.this.dHD.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.dHF.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.au.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (au.this.dHD != null) {
                    au.this.aww();
                    au.this.dHD.setAlpha(1.0f);
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
                com.baidu.adp.lib.g.e.ns().postDelayed(au.this.mHideTipRunnable, au.this.dHE);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i) {
        if (viewGroup != null && view != null) {
            this.dHD = view;
            aww();
            viewGroup.addView(this.dHD, layoutParams);
            this.dHD.setVisibility(0);
            this.dHE = i;
            com.baidu.adp.lib.g.e.ns().removeCallbacks(this.mHideTipRunnable);
            com.baidu.adp.lib.g.e.ns().postDelayed(this.mHideTipRunnable, this.dHE);
        }
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup != null && view != null) {
            this.dHD = view;
            aww();
            viewGroup.addView(this.dHD, layoutParams);
            this.dHD.setVisibility(0);
        }
    }

    public void hideTip() {
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.mHideTipRunnable);
        if (this.dHD != null && this.dHD.getParent() != null && this.dHD.getVisibility() == 0 && !this.dHF.isRunning()) {
            this.dHF.start();
        }
    }

    public void aww() {
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.mHideTipRunnable);
        if (this.dHD != null) {
            if (this.dHF != null && this.dHF.isRunning()) {
                this.dHF.cancel();
            }
            this.dHD.clearAnimation();
            if (this.dHD.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.dHD.getParent()).removeView(this.dHD);
            }
            this.dHD.setVisibility(8);
        }
    }

    public void onDestroy() {
        aww();
    }
}
