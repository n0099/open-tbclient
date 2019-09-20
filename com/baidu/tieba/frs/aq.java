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
    private View fAv = null;
    private int fAw = 2000;
    private Runnable mHideTipRunnable = new Runnable() { // from class: com.baidu.tieba.frs.aq.1
        @Override // java.lang.Runnable
        public void run() {
            aq.this.hideTip();
        }
    };
    private ValueAnimator fAx = new ValueAnimator();

    public aq() {
        this.fAx.setFloatValues(1.0f, 0.0f);
        this.fAx.setDuration(400L);
        this.fAx.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.aq.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (aq.this.fAv != null && valueAnimator != null) {
                    aq.this.fAv.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.fAx.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.aq.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (aq.this.fAv != null) {
                    aq.this.boO();
                    aq.this.fAv.setAlpha(1.0f);
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
                com.baidu.adp.lib.g.e.iK().postDelayed(aq.this.mHideTipRunnable, aq.this.fAw);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i) {
        if (viewGroup != null && view != null) {
            this.fAv = view;
            boO();
            viewGroup.addView(this.fAv, layoutParams);
            this.fAv.setVisibility(0);
            this.fAw = i;
            com.baidu.adp.lib.g.e.iK().removeCallbacks(this.mHideTipRunnable);
            com.baidu.adp.lib.g.e.iK().postDelayed(this.mHideTipRunnable, this.fAw);
        }
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup != null && view != null) {
            this.fAv = view;
            boO();
            viewGroup.addView(this.fAv, layoutParams);
            this.fAv.setVisibility(0);
        }
    }

    public void hideTip() {
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.mHideTipRunnable);
        if (this.fAv != null && this.fAv.getParent() != null && this.fAv.getVisibility() == 0 && !this.fAx.isRunning()) {
            this.fAx.start();
        }
    }

    public void boO() {
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.mHideTipRunnable);
        if (this.fAv != null) {
            if (this.fAx != null && this.fAx.isRunning()) {
                this.fAx.cancel();
            }
            this.fAv.clearAnimation();
            if (this.fAv.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.fAv.getParent()).removeView(this.fAv);
            }
            this.fAv.setVisibility(8);
        }
    }

    public void onDestroy() {
        boO();
    }
}
