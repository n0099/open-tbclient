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
    private View dpR = null;
    private int dpS = 2000;
    private Runnable mHideTipRunnable = new Runnable() { // from class: com.baidu.tieba.frs.as.1
        @Override // java.lang.Runnable
        public void run() {
            as.this.hideTip();
        }
    };
    private ValueAnimator dpT = new ValueAnimator();

    public as() {
        this.dpT.setFloatValues(1.0f, 0.0f);
        this.dpT.setDuration(400L);
        this.dpT.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.as.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (as.this.dpR != null && valueAnimator != null) {
                    as.this.dpR.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.dpT.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.as.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (as.this.dpR != null) {
                    as.this.avS();
                    as.this.dpR.setAlpha(1.0f);
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
                com.baidu.adp.lib.g.e.in().postDelayed(as.this.mHideTipRunnable, as.this.dpS);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i) {
        if (viewGroup != null && view != null) {
            this.dpR = view;
            avS();
            viewGroup.addView(this.dpR, layoutParams);
            this.dpR.setVisibility(0);
            this.dpS = i;
            com.baidu.adp.lib.g.e.in().removeCallbacks(this.mHideTipRunnable);
            com.baidu.adp.lib.g.e.in().postDelayed(this.mHideTipRunnable, this.dpS);
        }
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup != null && view != null) {
            this.dpR = view;
            avS();
            viewGroup.addView(this.dpR, layoutParams);
            this.dpR.setVisibility(0);
        }
    }

    public void hideTip() {
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.mHideTipRunnable);
        if (this.dpR != null && this.dpR.getParent() != null && this.dpR.getVisibility() == 0 && !this.dpT.isRunning()) {
            this.dpT.start();
        }
    }

    public void avS() {
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.mHideTipRunnable);
        if (this.dpR != null) {
            if (this.dpT != null && this.dpT.isRunning()) {
                this.dpT.cancel();
            }
            this.dpR.clearAnimation();
            if (this.dpR.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.dpR.getParent()).removeView(this.dpR);
            }
            this.dpR.setVisibility(8);
        }
    }

    public void onDestroy() {
        avS();
    }
}
