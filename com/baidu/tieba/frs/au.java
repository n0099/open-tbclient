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
    private View dEl = null;
    private int dEm = 2000;
    private Runnable mHideTipRunnable = new Runnable() { // from class: com.baidu.tieba.frs.au.1
        @Override // java.lang.Runnable
        public void run() {
            au.this.hideTip();
        }
    };
    private ValueAnimator dEn = new ValueAnimator();

    public au() {
        this.dEn.setFloatValues(1.0f, 0.0f);
        this.dEn.setDuration(400L);
        this.dEn.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.au.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (au.this.dEl != null && valueAnimator != null) {
                    au.this.dEl.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.dEn.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.au.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (au.this.dEl != null) {
                    au.this.avt();
                    au.this.dEl.setAlpha(1.0f);
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
                com.baidu.adp.lib.g.e.nr().postDelayed(au.this.mHideTipRunnable, au.this.dEm);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i) {
        if (viewGroup != null && view != null) {
            this.dEl = view;
            avt();
            viewGroup.addView(this.dEl, layoutParams);
            this.dEl.setVisibility(0);
            this.dEm = i;
            com.baidu.adp.lib.g.e.nr().removeCallbacks(this.mHideTipRunnable);
            com.baidu.adp.lib.g.e.nr().postDelayed(this.mHideTipRunnable, this.dEm);
        }
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup != null && view != null) {
            this.dEl = view;
            avt();
            viewGroup.addView(this.dEl, layoutParams);
            this.dEl.setVisibility(0);
        }
    }

    public void hideTip() {
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.mHideTipRunnable);
        if (this.dEl != null && this.dEl.getParent() != null && this.dEl.getVisibility() == 0 && !this.dEn.isRunning()) {
            this.dEn.start();
        }
    }

    public void avt() {
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.mHideTipRunnable);
        if (this.dEl != null) {
            if (this.dEn != null && this.dEn.isRunning()) {
                this.dEn.cancel();
            }
            this.dEl.clearAnimation();
            if (this.dEl.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.dEl.getParent()).removeView(this.dEl);
            }
            this.dEl.setVisibility(8);
        }
    }

    public void onDestroy() {
        avt();
    }
}
