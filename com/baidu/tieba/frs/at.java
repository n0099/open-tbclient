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
public class at {
    private TranslateAnimation mTipInAnimation;
    private View cKF = null;
    private int cKG = 2000;
    private Runnable mHideTipRunnable = new Runnable() { // from class: com.baidu.tieba.frs.at.1
        @Override // java.lang.Runnable
        public void run() {
            at.this.hideTip();
        }
    };
    private ValueAnimator cKH = new ValueAnimator();

    public at() {
        this.cKH.setFloatValues(1.0f, 0.0f);
        this.cKH.setDuration(400L);
        this.cKH.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.at.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (at.this.cKF != null && valueAnimator != null) {
                    at.this.cKF.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.cKH.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.at.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (at.this.cKF != null) {
                    at.this.amJ();
                    at.this.cKF.setAlpha(1.0f);
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
        this.mTipInAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.at.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                com.baidu.adp.lib.g.e.fP().postDelayed(at.this.mHideTipRunnable, at.this.cKG);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i) {
        if (viewGroup != null && view != null) {
            this.cKF = view;
            amJ();
            viewGroup.addView(this.cKF, layoutParams);
            this.cKF.setVisibility(0);
            this.cKG = i;
            com.baidu.adp.lib.g.e.fP().removeCallbacks(this.mHideTipRunnable);
            com.baidu.adp.lib.g.e.fP().postDelayed(this.mHideTipRunnable, this.cKG);
        }
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup != null && view != null) {
            this.cKF = view;
            amJ();
            viewGroup.addView(this.cKF, layoutParams);
            this.cKF.setVisibility(0);
        }
    }

    public void hideTip() {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.mHideTipRunnable);
        if (this.cKF != null && this.cKF.getParent() != null && this.cKF.getVisibility() == 0 && !this.cKH.isRunning()) {
            this.cKH.start();
        }
    }

    public void amJ() {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.mHideTipRunnable);
        if (this.cKF != null) {
            if (this.cKH != null && this.cKH.isRunning()) {
                this.cKH.cancel();
            }
            this.cKF.clearAnimation();
            if (this.cKF.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.cKF.getParent()).removeView(this.cKF);
            }
            this.cKF.setVisibility(8);
        }
    }

    public void onDestroy() {
        amJ();
    }
}
