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
public class aq {
    private TranslateAnimation mTipInAnimation;
    private View dkS = null;
    private int dkT = 2000;
    private Runnable mHideTipRunnable = new Runnable() { // from class: com.baidu.tieba.frs.aq.1
        @Override // java.lang.Runnable
        public void run() {
            aq.this.hideTip();
        }
    };
    private ValueAnimator dkU = new ValueAnimator();

    public aq() {
        this.dkU.setFloatValues(1.0f, 0.0f);
        this.dkU.setDuration(400L);
        this.dkU.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.aq.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (aq.this.dkS != null && valueAnimator != null) {
                    aq.this.dkS.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.dkU.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.aq.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (aq.this.dkS != null) {
                    aq.this.auT();
                    aq.this.dkS.setAlpha(1.0f);
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
        this.mTipInAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.aq.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                com.baidu.adp.lib.g.e.im().postDelayed(aq.this.mHideTipRunnable, aq.this.dkT);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i) {
        if (viewGroup != null && view != null) {
            this.dkS = view;
            auT();
            viewGroup.addView(this.dkS, layoutParams);
            this.dkS.setVisibility(0);
            this.dkT = i;
            com.baidu.adp.lib.g.e.im().removeCallbacks(this.mHideTipRunnable);
            com.baidu.adp.lib.g.e.im().postDelayed(this.mHideTipRunnable, this.dkT);
        }
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup != null && view != null) {
            this.dkS = view;
            auT();
            viewGroup.addView(this.dkS, layoutParams);
            this.dkS.setVisibility(0);
        }
    }

    public void hideTip() {
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.mHideTipRunnable);
        if (this.dkS != null && this.dkS.getParent() != null && this.dkS.getVisibility() == 0 && !this.dkU.isRunning()) {
            this.dkU.start();
        }
    }

    public void auT() {
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.mHideTipRunnable);
        if (this.dkS != null) {
            if (this.dkU != null && this.dkU.isRunning()) {
                this.dkU.cancel();
            }
            this.dkS.clearAnimation();
            if (this.dkS.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.dkS.getParent()).removeView(this.dkS);
            }
            this.dkS.setVisibility(8);
        }
    }

    public void onDestroy() {
        auT();
    }
}
