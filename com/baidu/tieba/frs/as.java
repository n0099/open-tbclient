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
    private View dOH = null;
    private int dOI = 2000;
    private Runnable mHideTipRunnable = new Runnable() { // from class: com.baidu.tieba.frs.as.1
        @Override // java.lang.Runnable
        public void run() {
            as.this.hideTip();
        }
    };
    private ValueAnimator dOJ = new ValueAnimator();

    public as() {
        this.dOJ.setFloatValues(1.0f, 0.0f);
        this.dOJ.setDuration(400L);
        this.dOJ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.as.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (as.this.dOH != null && valueAnimator != null) {
                    as.this.dOH.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.dOJ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.as.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (as.this.dOH != null) {
                    as.this.aDu();
                    as.this.dOH.setAlpha(1.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.mTipInAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.getInst().getResources().getDimension(e.C0210e.ds56), 0.0f);
        this.mTipInAnimation.setDuration(400L);
        this.mTipInAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.as.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                com.baidu.adp.lib.g.e.jG().postDelayed(as.this.mHideTipRunnable, as.this.dOI);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i) {
        if (viewGroup != null && view != null) {
            this.dOH = view;
            aDu();
            viewGroup.addView(this.dOH, layoutParams);
            this.dOH.setVisibility(0);
            this.dOI = i;
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.mHideTipRunnable);
            com.baidu.adp.lib.g.e.jG().postDelayed(this.mHideTipRunnable, this.dOI);
        }
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup != null && view != null) {
            this.dOH = view;
            aDu();
            viewGroup.addView(this.dOH, layoutParams);
            this.dOH.setVisibility(0);
        }
    }

    public void hideTip() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.mHideTipRunnable);
        if (this.dOH != null && this.dOH.getParent() != null && this.dOH.getVisibility() == 0 && !this.dOJ.isRunning()) {
            this.dOJ.start();
        }
    }

    public void aDu() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.mHideTipRunnable);
        if (this.dOH != null) {
            if (this.dOJ != null && this.dOJ.isRunning()) {
                this.dOJ.cancel();
            }
            this.dOH.clearAnimation();
            if (this.dOH.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.dOH.getParent()).removeView(this.dOH);
            }
            this.dOH.setVisibility(8);
        }
    }

    public void onDestroy() {
        aDu();
    }
}
