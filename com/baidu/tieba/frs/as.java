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
    private View dLT = null;
    private int dLU = 2000;
    private Runnable mHideTipRunnable = new Runnable() { // from class: com.baidu.tieba.frs.as.1
        @Override // java.lang.Runnable
        public void run() {
            as.this.hideTip();
        }
    };
    private ValueAnimator dLV = new ValueAnimator();

    public as() {
        this.dLV.setFloatValues(1.0f, 0.0f);
        this.dLV.setDuration(400L);
        this.dLV.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.as.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (as.this.dLT != null && valueAnimator != null) {
                    as.this.dLT.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.dLV.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.as.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (as.this.dLT != null) {
                    as.this.aCF();
                    as.this.dLT.setAlpha(1.0f);
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
                com.baidu.adp.lib.g.e.jG().postDelayed(as.this.mHideTipRunnable, as.this.dLU);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i) {
        if (viewGroup != null && view != null) {
            this.dLT = view;
            aCF();
            viewGroup.addView(this.dLT, layoutParams);
            this.dLT.setVisibility(0);
            this.dLU = i;
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.mHideTipRunnable);
            com.baidu.adp.lib.g.e.jG().postDelayed(this.mHideTipRunnable, this.dLU);
        }
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup != null && view != null) {
            this.dLT = view;
            aCF();
            viewGroup.addView(this.dLT, layoutParams);
            this.dLT.setVisibility(0);
        }
    }

    public void hideTip() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.mHideTipRunnable);
        if (this.dLT != null && this.dLT.getParent() != null && this.dLT.getVisibility() == 0 && !this.dLV.isRunning()) {
            this.dLV.start();
        }
    }

    public void aCF() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.mHideTipRunnable);
        if (this.dLT != null) {
            if (this.dLV != null && this.dLV.isRunning()) {
                this.dLV.cancel();
            }
            this.dLT.clearAnimation();
            if (this.dLT.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.dLT.getParent()).removeView(this.dLT);
            }
            this.dLT.setVisibility(8);
        }
    }

    public void onDestroy() {
        aCF();
    }
}
