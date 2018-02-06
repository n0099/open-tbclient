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
    private View dHK = null;
    private int dHL = 2000;
    private Runnable mHideTipRunnable = new Runnable() { // from class: com.baidu.tieba.frs.au.1
        @Override // java.lang.Runnable
        public void run() {
            au.this.hideTip();
        }
    };
    private ValueAnimator dHM = new ValueAnimator();

    public au() {
        this.dHM.setFloatValues(1.0f, 0.0f);
        this.dHM.setDuration(400L);
        this.dHM.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.au.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (au.this.dHK != null && valueAnimator != null) {
                    au.this.dHK.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.dHM.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.au.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (au.this.dHK != null) {
                    au.this.awv();
                    au.this.dHK.setAlpha(1.0f);
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
                com.baidu.adp.lib.g.e.ns().postDelayed(au.this.mHideTipRunnable, au.this.dHL);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i) {
        if (viewGroup != null && view != null) {
            this.dHK = view;
            awv();
            viewGroup.addView(this.dHK, layoutParams);
            this.dHK.setVisibility(0);
            this.dHL = i;
            com.baidu.adp.lib.g.e.ns().removeCallbacks(this.mHideTipRunnable);
            com.baidu.adp.lib.g.e.ns().postDelayed(this.mHideTipRunnable, this.dHL);
        }
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup != null && view != null) {
            this.dHK = view;
            awv();
            viewGroup.addView(this.dHK, layoutParams);
            this.dHK.setVisibility(0);
        }
    }

    public void hideTip() {
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.mHideTipRunnable);
        if (this.dHK != null && this.dHK.getParent() != null && this.dHK.getVisibility() == 0 && !this.dHM.isRunning()) {
            this.dHM.start();
        }
    }

    public void awv() {
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.mHideTipRunnable);
        if (this.dHK != null) {
            if (this.dHM != null && this.dHM.isRunning()) {
                this.dHM.cancel();
            }
            this.dHK.clearAnimation();
            if (this.dHK.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.dHK.getParent()).removeView(this.dHK);
            }
            this.dHK.setVisibility(8);
        }
    }

    public void onDestroy() {
        awv();
    }
}
