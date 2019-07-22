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
    private View fyj = null;
    private int fyk = 2000;
    private Runnable mHideTipRunnable = new Runnable() { // from class: com.baidu.tieba.frs.aq.1
        @Override // java.lang.Runnable
        public void run() {
            aq.this.hideTip();
        }
    };
    private ValueAnimator fyl = new ValueAnimator();

    public aq() {
        this.fyl.setFloatValues(1.0f, 0.0f);
        this.fyl.setDuration(400L);
        this.fyl.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.aq.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (aq.this.fyj != null && valueAnimator != null) {
                    aq.this.fyj.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.fyl.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.aq.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (aq.this.fyj != null) {
                    aq.this.bnT();
                    aq.this.fyj.setAlpha(1.0f);
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
                com.baidu.adp.lib.g.e.iK().postDelayed(aq.this.mHideTipRunnable, aq.this.fyk);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i) {
        if (viewGroup != null && view != null) {
            this.fyj = view;
            bnT();
            viewGroup.addView(this.fyj, layoutParams);
            this.fyj.setVisibility(0);
            this.fyk = i;
            com.baidu.adp.lib.g.e.iK().removeCallbacks(this.mHideTipRunnable);
            com.baidu.adp.lib.g.e.iK().postDelayed(this.mHideTipRunnable, this.fyk);
        }
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup != null && view != null) {
            this.fyj = view;
            bnT();
            viewGroup.addView(this.fyj, layoutParams);
            this.fyj.setVisibility(0);
        }
    }

    public void hideTip() {
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.mHideTipRunnable);
        if (this.fyj != null && this.fyj.getParent() != null && this.fyj.getVisibility() == 0 && !this.fyl.isRunning()) {
            this.fyl.start();
        }
    }

    public void bnT() {
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.mHideTipRunnable);
        if (this.fyj != null) {
            if (this.fyl != null && this.fyl.isRunning()) {
                this.fyl.cancel();
            }
            this.fyj.clearAnimation();
            if (this.fyj.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.fyj.getParent()).removeView(this.fyj);
            }
            this.fyj.setVisibility(8);
        }
    }

    public void onDestroy() {
        bnT();
    }
}
