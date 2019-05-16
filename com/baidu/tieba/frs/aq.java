package com.baidu.tieba.frs;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class aq {
    private TranslateAnimation mTipInAnimation;
    private View ftm = null;
    private int ftn = 2000;
    private Runnable mHideTipRunnable = new Runnable() { // from class: com.baidu.tieba.frs.aq.1
        @Override // java.lang.Runnable
        public void run() {
            aq.this.hideTip();
        }
    };
    private ValueAnimator fto = new ValueAnimator();

    public aq() {
        this.fto.setFloatValues(1.0f, 0.0f);
        this.fto.setDuration(400L);
        this.fto.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.aq.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (aq.this.ftm != null && valueAnimator != null) {
                    aq.this.ftm.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.fto.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.aq.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (aq.this.ftm != null) {
                    aq.this.blP();
                    aq.this.ftm.setAlpha(1.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.mTipInAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds56), 0.0f);
        this.mTipInAnimation.setDuration(400L);
        this.mTipInAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.aq.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                com.baidu.adp.lib.g.e.iB().postDelayed(aq.this.mHideTipRunnable, aq.this.ftn);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i) {
        if (viewGroup != null && view != null) {
            this.ftm = view;
            blP();
            viewGroup.addView(this.ftm, layoutParams);
            this.ftm.setVisibility(0);
            this.ftn = i;
            com.baidu.adp.lib.g.e.iB().removeCallbacks(this.mHideTipRunnable);
            com.baidu.adp.lib.g.e.iB().postDelayed(this.mHideTipRunnable, this.ftn);
        }
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup != null && view != null) {
            this.ftm = view;
            blP();
            viewGroup.addView(this.ftm, layoutParams);
            this.ftm.setVisibility(0);
        }
    }

    public void hideTip() {
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.mHideTipRunnable);
        if (this.ftm != null && this.ftm.getParent() != null && this.ftm.getVisibility() == 0 && !this.fto.isRunning()) {
            this.fto.start();
        }
    }

    public void blP() {
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.mHideTipRunnable);
        if (this.ftm != null) {
            if (this.fto != null && this.fto.isRunning()) {
                this.fto.cancel();
            }
            this.ftm.clearAnimation();
            if (this.ftm.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.ftm.getParent()).removeView(this.ftm);
            }
            this.ftm.setVisibility(8);
        }
    }

    public void onDestroy() {
        blP();
    }
}
