package com.baidu.tieba.frs;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.f;
/* loaded from: classes.dex */
public class as {
    private TranslateAnimation mTipInAnimation;
    private View dpP = null;
    private int dpQ = 2000;
    private Runnable mHideTipRunnable = new Runnable() { // from class: com.baidu.tieba.frs.as.1
        @Override // java.lang.Runnable
        public void run() {
            as.this.hideTip();
        }
    };
    private ValueAnimator dpR = new ValueAnimator();

    public as() {
        this.dpR.setFloatValues(1.0f, 0.0f);
        this.dpR.setDuration(400L);
        this.dpR.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.as.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (as.this.dpP != null && valueAnimator != null) {
                    as.this.dpP.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.dpR.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.as.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (as.this.dpP != null) {
                    as.this.avR();
                    as.this.dpP.setAlpha(1.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.mTipInAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.getInst().getResources().getDimension(f.e.ds56), 0.0f);
        this.mTipInAnimation.setDuration(400L);
        this.mTipInAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.as.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                com.baidu.adp.lib.g.e.in().postDelayed(as.this.mHideTipRunnable, as.this.dpQ);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i) {
        if (viewGroup != null && view != null) {
            this.dpP = view;
            avR();
            viewGroup.addView(this.dpP, layoutParams);
            this.dpP.setVisibility(0);
            this.dpQ = i;
            com.baidu.adp.lib.g.e.in().removeCallbacks(this.mHideTipRunnable);
            com.baidu.adp.lib.g.e.in().postDelayed(this.mHideTipRunnable, this.dpQ);
        }
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup != null && view != null) {
            this.dpP = view;
            avR();
            viewGroup.addView(this.dpP, layoutParams);
            this.dpP.setVisibility(0);
        }
    }

    public void hideTip() {
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.mHideTipRunnable);
        if (this.dpP != null && this.dpP.getParent() != null && this.dpP.getVisibility() == 0 && !this.dpR.isRunning()) {
            this.dpR.start();
        }
    }

    public void avR() {
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.mHideTipRunnable);
        if (this.dpP != null) {
            if (this.dpR != null && this.dpR.isRunning()) {
                this.dpR.cancel();
            }
            this.dpP.clearAnimation();
            if (this.dpP.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.dpP.getParent()).removeView(this.dpP);
            }
            this.dpP.setVisibility(8);
        }
    }

    public void onDestroy() {
        avR();
    }
}
