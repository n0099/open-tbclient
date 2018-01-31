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
    private View dEG = null;
    private int dEH = 2000;
    private Runnable mHideTipRunnable = new Runnable() { // from class: com.baidu.tieba.frs.au.1
        @Override // java.lang.Runnable
        public void run() {
            au.this.hideTip();
        }
    };
    private ValueAnimator dEI = new ValueAnimator();

    public au() {
        this.dEI.setFloatValues(1.0f, 0.0f);
        this.dEI.setDuration(400L);
        this.dEI.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.au.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (au.this.dEG != null && valueAnimator != null) {
                    au.this.dEG.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.dEI.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.au.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (au.this.dEG != null) {
                    au.this.avy();
                    au.this.dEG.setAlpha(1.0f);
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
                com.baidu.adp.lib.g.e.ns().postDelayed(au.this.mHideTipRunnable, au.this.dEH);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i) {
        if (viewGroup != null && view != null) {
            this.dEG = view;
            avy();
            viewGroup.addView(this.dEG, layoutParams);
            this.dEG.setVisibility(0);
            this.dEH = i;
            com.baidu.adp.lib.g.e.ns().removeCallbacks(this.mHideTipRunnable);
            com.baidu.adp.lib.g.e.ns().postDelayed(this.mHideTipRunnable, this.dEH);
        }
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup != null && view != null) {
            this.dEG = view;
            avy();
            viewGroup.addView(this.dEG, layoutParams);
            this.dEG.setVisibility(0);
        }
    }

    public void hideTip() {
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.mHideTipRunnable);
        if (this.dEG != null && this.dEG.getParent() != null && this.dEG.getVisibility() == 0 && !this.dEI.isRunning()) {
            this.dEI.start();
        }
    }

    public void avy() {
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.mHideTipRunnable);
        if (this.dEG != null) {
            if (this.dEI != null && this.dEI.isRunning()) {
                this.dEI.cancel();
            }
            this.dEG.clearAnimation();
            if (this.dEG.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.dEG.getParent()).removeView(this.dEG);
            }
            this.dEG.setVisibility(8);
        }
    }

    public void onDestroy() {
        avy();
    }
}
