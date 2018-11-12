package com.baidu.tieba.frs;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class as {
    private TranslateAnimation mTipInAnimation;
    private View dFu = null;
    private int dFv = 2000;
    private Runnable mHideTipRunnable = new Runnable() { // from class: com.baidu.tieba.frs.as.1
        @Override // java.lang.Runnable
        public void run() {
            as.this.hideTip();
        }
    };
    private ValueAnimator dFw = new ValueAnimator();

    public as() {
        this.dFw.setFloatValues(1.0f, 0.0f);
        this.dFw.setDuration(400L);
        this.dFw.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.as.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (as.this.dFu != null && valueAnimator != null) {
                    as.this.dFu.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.dFw.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.as.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (as.this.dFu != null) {
                    as.this.aAV();
                    as.this.dFu.setAlpha(1.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.mTipInAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.getInst().getResources().getDimension(e.C0200e.ds56), 0.0f);
        this.mTipInAnimation.setDuration(400L);
        this.mTipInAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.as.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                com.baidu.adp.lib.g.e.jG().postDelayed(as.this.mHideTipRunnable, as.this.dFv);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i) {
        if (viewGroup != null && view != null) {
            this.dFu = view;
            aAV();
            viewGroup.addView(this.dFu, layoutParams);
            this.dFu.setVisibility(0);
            this.dFv = i;
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.mHideTipRunnable);
            com.baidu.adp.lib.g.e.jG().postDelayed(this.mHideTipRunnable, this.dFv);
        }
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup != null && view != null) {
            this.dFu = view;
            aAV();
            viewGroup.addView(this.dFu, layoutParams);
            this.dFu.setVisibility(0);
        }
    }

    public void hideTip() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.mHideTipRunnable);
        if (this.dFu != null && this.dFu.getParent() != null && this.dFu.getVisibility() == 0 && !this.dFw.isRunning()) {
            this.dFw.start();
        }
    }

    public void aAV() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.mHideTipRunnable);
        if (this.dFu != null) {
            if (this.dFw != null && this.dFw.isRunning()) {
                this.dFw.cancel();
            }
            this.dFu.clearAnimation();
            if (this.dFu.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.dFu.getParent()).removeView(this.dFu);
            }
            this.dFu.setVisibility(8);
        }
    }

    public void onDestroy() {
        aAV();
    }
}
