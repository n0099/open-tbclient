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
    private View dPr = null;
    private int dPs = 2000;
    private Runnable mHideTipRunnable = new Runnable() { // from class: com.baidu.tieba.frs.as.1
        @Override // java.lang.Runnable
        public void run() {
            as.this.hideTip();
        }
    };
    private ValueAnimator dPt = new ValueAnimator();

    public as() {
        this.dPt.setFloatValues(1.0f, 0.0f);
        this.dPt.setDuration(400L);
        this.dPt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.as.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (as.this.dPr != null && valueAnimator != null) {
                    as.this.dPr.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.dPt.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.as.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (as.this.dPr != null) {
                    as.this.aDR();
                    as.this.dPr.setAlpha(1.0f);
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
                com.baidu.adp.lib.g.e.jG().postDelayed(as.this.mHideTipRunnable, as.this.dPs);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i) {
        if (viewGroup != null && view != null) {
            this.dPr = view;
            aDR();
            viewGroup.addView(this.dPr, layoutParams);
            this.dPr.setVisibility(0);
            this.dPs = i;
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.mHideTipRunnable);
            com.baidu.adp.lib.g.e.jG().postDelayed(this.mHideTipRunnable, this.dPs);
        }
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup != null && view != null) {
            this.dPr = view;
            aDR();
            viewGroup.addView(this.dPr, layoutParams);
            this.dPr.setVisibility(0);
        }
    }

    public void hideTip() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.mHideTipRunnable);
        if (this.dPr != null && this.dPr.getParent() != null && this.dPr.getVisibility() == 0 && !this.dPt.isRunning()) {
            this.dPt.start();
        }
    }

    public void aDR() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.mHideTipRunnable);
        if (this.dPr != null) {
            if (this.dPt != null && this.dPt.isRunning()) {
                this.dPt.cancel();
            }
            this.dPr.clearAnimation();
            if (this.dPr.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.dPr.getParent()).removeView(this.dPr);
            }
            this.dPr.setVisibility(8);
        }
    }

    public void onDestroy() {
        aDR();
    }
}
