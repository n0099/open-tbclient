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
    private View dmZ = null;
    private int dna = 2000;
    private Runnable mHideTipRunnable = new Runnable() { // from class: com.baidu.tieba.frs.as.1
        @Override // java.lang.Runnable
        public void run() {
            as.this.hideTip();
        }
    };
    private ValueAnimator dnb = new ValueAnimator();

    public as() {
        this.dnb.setFloatValues(1.0f, 0.0f);
        this.dnb.setDuration(400L);
        this.dnb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.as.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (as.this.dmZ != null && valueAnimator != null) {
                    as.this.dmZ.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.dnb.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.as.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (as.this.dmZ != null) {
                    as.this.avn();
                    as.this.dmZ.setAlpha(1.0f);
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
                com.baidu.adp.lib.g.e.im().postDelayed(as.this.mHideTipRunnable, as.this.dna);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i) {
        if (viewGroup != null && view != null) {
            this.dmZ = view;
            avn();
            viewGroup.addView(this.dmZ, layoutParams);
            this.dmZ.setVisibility(0);
            this.dna = i;
            com.baidu.adp.lib.g.e.im().removeCallbacks(this.mHideTipRunnable);
            com.baidu.adp.lib.g.e.im().postDelayed(this.mHideTipRunnable, this.dna);
        }
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup != null && view != null) {
            this.dmZ = view;
            avn();
            viewGroup.addView(this.dmZ, layoutParams);
            this.dmZ.setVisibility(0);
        }
    }

    public void hideTip() {
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.mHideTipRunnable);
        if (this.dmZ != null && this.dmZ.getParent() != null && this.dmZ.getVisibility() == 0 && !this.dnb.isRunning()) {
            this.dnb.start();
        }
    }

    public void avn() {
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.mHideTipRunnable);
        if (this.dmZ != null) {
            if (this.dnb != null && this.dnb.isRunning()) {
                this.dnb.cancel();
            }
            this.dmZ.clearAnimation();
            if (this.dmZ.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.dmZ.getParent()).removeView(this.dmZ);
            }
            this.dmZ.setVisibility(8);
        }
    }

    public void onDestroy() {
        avn();
    }
}
