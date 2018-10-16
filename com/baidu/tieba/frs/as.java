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
    private View dEe = null;
    private int dEf = 2000;
    private Runnable mHideTipRunnable = new Runnable() { // from class: com.baidu.tieba.frs.as.1
        @Override // java.lang.Runnable
        public void run() {
            as.this.hideTip();
        }
    };
    private ValueAnimator dEg = new ValueAnimator();

    public as() {
        this.dEg.setFloatValues(1.0f, 0.0f);
        this.dEg.setDuration(400L);
        this.dEg.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.as.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (as.this.dEe != null && valueAnimator != null) {
                    as.this.dEe.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.dEg.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.as.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (as.this.dEe != null) {
                    as.this.aBx();
                    as.this.dEe.setAlpha(1.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.mTipInAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.getInst().getResources().getDimension(e.C0175e.ds56), 0.0f);
        this.mTipInAnimation.setDuration(400L);
        this.mTipInAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.as.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                com.baidu.adp.lib.g.e.jI().postDelayed(as.this.mHideTipRunnable, as.this.dEf);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i) {
        if (viewGroup != null && view != null) {
            this.dEe = view;
            aBx();
            viewGroup.addView(this.dEe, layoutParams);
            this.dEe.setVisibility(0);
            this.dEf = i;
            com.baidu.adp.lib.g.e.jI().removeCallbacks(this.mHideTipRunnable);
            com.baidu.adp.lib.g.e.jI().postDelayed(this.mHideTipRunnable, this.dEf);
        }
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup != null && view != null) {
            this.dEe = view;
            aBx();
            viewGroup.addView(this.dEe, layoutParams);
            this.dEe.setVisibility(0);
        }
    }

    public void hideTip() {
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.mHideTipRunnable);
        if (this.dEe != null && this.dEe.getParent() != null && this.dEe.getVisibility() == 0 && !this.dEg.isRunning()) {
            this.dEg.start();
        }
    }

    public void aBx() {
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.mHideTipRunnable);
        if (this.dEe != null) {
            if (this.dEg != null && this.dEg.isRunning()) {
                this.dEg.cancel();
            }
            this.dEe.clearAnimation();
            if (this.dEe.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.dEe.getParent()).removeView(this.dEe);
            }
            this.dEe.setVisibility(8);
        }
    }

    public void onDestroy() {
        aBx();
    }
}
