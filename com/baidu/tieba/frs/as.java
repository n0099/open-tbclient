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
    private View cAU = null;
    private int cAV = 2000;
    private Runnable mHideTipRunnable = new Runnable() { // from class: com.baidu.tieba.frs.as.1
        @Override // java.lang.Runnable
        public void run() {
            as.this.hideTip();
        }
    };
    private ValueAnimator cAW = new ValueAnimator();

    public as() {
        this.cAW.setFloatValues(1.0f, 0.0f);
        this.cAW.setDuration(400L);
        this.cAW.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.as.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (as.this.cAU != null && valueAnimator != null) {
                    as.this.cAU.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.cAW.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.as.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (as.this.cAU != null) {
                    as.this.akq();
                    as.this.cAU.setAlpha(1.0f);
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
                com.baidu.adp.lib.g.e.fP().postDelayed(as.this.mHideTipRunnable, as.this.cAV);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i) {
        if (viewGroup != null && view != null) {
            this.cAU = view;
            akq();
            viewGroup.addView(this.cAU, layoutParams);
            this.cAU.setVisibility(0);
            this.cAV = i;
            com.baidu.adp.lib.g.e.fP().removeCallbacks(this.mHideTipRunnable);
            com.baidu.adp.lib.g.e.fP().postDelayed(this.mHideTipRunnable, this.cAV);
        }
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup != null && view != null) {
            this.cAU = view;
            akq();
            viewGroup.addView(this.cAU, layoutParams);
            this.cAU.setVisibility(0);
        }
    }

    public void hideTip() {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.mHideTipRunnable);
        if (this.cAU != null && this.cAU.getParent() != null && this.cAU.getVisibility() == 0 && !this.cAW.isRunning()) {
            this.cAW.start();
        }
    }

    public void akq() {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.mHideTipRunnable);
        if (this.cAU != null) {
            if (this.cAW != null && this.cAW.isRunning()) {
                this.cAW.cancel();
            }
            this.cAU.clearAnimation();
            if (this.cAU.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.cAU.getParent()).removeView(this.cAU);
            }
            this.cAU.setVisibility(8);
        }
    }

    public void onDestroy() {
        akq();
    }
}
