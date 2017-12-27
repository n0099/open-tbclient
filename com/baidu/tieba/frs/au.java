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
public class au {
    private TranslateAnimation mTipInAnimation;
    private View dzK = null;
    private int dzL = 2000;
    private Runnable mHideTipRunnable = new Runnable() { // from class: com.baidu.tieba.frs.au.1
        @Override // java.lang.Runnable
        public void run() {
            au.this.hideTip();
        }
    };
    private ValueAnimator dzM = new ValueAnimator();

    public au() {
        this.dzM.setFloatValues(1.0f, 0.0f);
        this.dzM.setDuration(400L);
        this.dzM.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.au.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (au.this.dzK != null && valueAnimator != null) {
                    au.this.dzK.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.dzM.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.au.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (au.this.dzK != null) {
                    au.this.auq();
                    au.this.dzK.setAlpha(1.0f);
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
        this.mTipInAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.au.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                com.baidu.adp.lib.g.e.nr().postDelayed(au.this.mHideTipRunnable, au.this.dzL);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i) {
        if (viewGroup != null && view != null) {
            this.dzK = view;
            auq();
            viewGroup.addView(this.dzK, layoutParams);
            this.dzK.setVisibility(0);
            this.dzL = i;
            com.baidu.adp.lib.g.e.nr().removeCallbacks(this.mHideTipRunnable);
            com.baidu.adp.lib.g.e.nr().postDelayed(this.mHideTipRunnable, this.dzL);
        }
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup != null && view != null) {
            this.dzK = view;
            auq();
            viewGroup.addView(this.dzK, layoutParams);
            this.dzK.setVisibility(0);
        }
    }

    public void hideTip() {
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.mHideTipRunnable);
        if (this.dzK != null && this.dzK.getParent() != null && this.dzK.getVisibility() == 0 && !this.dzM.isRunning()) {
            this.dzM.start();
        }
    }

    public void auq() {
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.mHideTipRunnable);
        if (this.dzK != null) {
            if (this.dzM != null && this.dzM.isRunning()) {
                this.dzM.cancel();
            }
            this.dzK.clearAnimation();
            if (this.dzK.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.dzK.getParent()).removeView(this.dzK);
            }
            this.dzK.setVisibility(8);
        }
    }

    public void onDestroy() {
        auq();
    }
}
