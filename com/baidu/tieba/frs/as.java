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
    private View cBn = null;
    private int cBo = 2000;
    private Runnable mHideTipRunnable = new Runnable() { // from class: com.baidu.tieba.frs.as.1
        @Override // java.lang.Runnable
        public void run() {
            as.this.hideTip();
        }
    };
    private ValueAnimator cBp = new ValueAnimator();

    public as() {
        this.cBp.setFloatValues(1.0f, 0.0f);
        this.cBp.setDuration(400L);
        this.cBp.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.as.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (as.this.cBn != null && valueAnimator != null) {
                    as.this.cBn.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.cBp.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.as.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (as.this.cBn != null) {
                    as.this.akE();
                    as.this.cBn.setAlpha(1.0f);
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
                com.baidu.adp.lib.g.e.fP().postDelayed(as.this.mHideTipRunnable, as.this.cBo);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i) {
        if (viewGroup != null && view != null) {
            this.cBn = view;
            akE();
            viewGroup.addView(this.cBn, layoutParams);
            this.cBn.setVisibility(0);
            this.cBo = i;
            com.baidu.adp.lib.g.e.fP().removeCallbacks(this.mHideTipRunnable);
            com.baidu.adp.lib.g.e.fP().postDelayed(this.mHideTipRunnable, this.cBo);
        }
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup != null && view != null) {
            this.cBn = view;
            akE();
            viewGroup.addView(this.cBn, layoutParams);
            this.cBn.setVisibility(0);
        }
    }

    public void hideTip() {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.mHideTipRunnable);
        if (this.cBn != null && this.cBn.getParent() != null && this.cBn.getVisibility() == 0 && !this.cBp.isRunning()) {
            this.cBp.start();
        }
    }

    public void akE() {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.mHideTipRunnable);
        if (this.cBn != null) {
            if (this.cBp != null && this.cBp.isRunning()) {
                this.cBp.cancel();
            }
            this.cBn.clearAnimation();
            if (this.cBn.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.cBn.getParent()).removeView(this.cBn);
            }
            this.cBn.setVisibility(8);
        }
    }

    public void onDestroy() {
        akE();
    }
}
