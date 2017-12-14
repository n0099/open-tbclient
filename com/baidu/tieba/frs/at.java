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
    private View cKB = null;
    private int cKC = 2000;
    private Runnable mHideTipRunnable = new Runnable() { // from class: com.baidu.tieba.frs.at.1
        @Override // java.lang.Runnable
        public void run() {
            at.this.hideTip();
        }
    };
    private ValueAnimator cKD = new ValueAnimator();

    public at() {
        this.cKD.setFloatValues(1.0f, 0.0f);
        this.cKD.setDuration(400L);
        this.cKD.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.at.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (at.this.cKB != null && valueAnimator != null) {
                    at.this.cKB.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.cKD.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.at.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (at.this.cKB != null) {
                    at.this.amJ();
                    at.this.cKB.setAlpha(1.0f);
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
                com.baidu.adp.lib.g.e.fP().postDelayed(at.this.mHideTipRunnable, at.this.cKC);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i) {
        if (viewGroup != null && view != null) {
            this.cKB = view;
            amJ();
            viewGroup.addView(this.cKB, layoutParams);
            this.cKB.setVisibility(0);
            this.cKC = i;
            com.baidu.adp.lib.g.e.fP().removeCallbacks(this.mHideTipRunnable);
            com.baidu.adp.lib.g.e.fP().postDelayed(this.mHideTipRunnable, this.cKC);
        }
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup != null && view != null) {
            this.cKB = view;
            amJ();
            viewGroup.addView(this.cKB, layoutParams);
            this.cKB.setVisibility(0);
        }
    }

    public void hideTip() {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.mHideTipRunnable);
        if (this.cKB != null && this.cKB.getParent() != null && this.cKB.getVisibility() == 0 && !this.cKD.isRunning()) {
            this.cKD.start();
        }
    }

    public void amJ() {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.mHideTipRunnable);
        if (this.cKB != null) {
            if (this.cKD != null && this.cKD.isRunning()) {
                this.cKD.cancel();
            }
            this.cKB.clearAnimation();
            if (this.cKB.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.cKB.getParent()).removeView(this.cKB);
            }
            this.cKB.setVisibility(8);
        }
    }

    public void onDestroy() {
        amJ();
    }
}
