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
    private View fdm = null;
    private int fdn = 2000;
    private Runnable mHideTipRunnable = new Runnable() { // from class: com.baidu.tieba.frs.aq.1
        @Override // java.lang.Runnable
        public void run() {
            aq.this.hideTip();
        }
    };
    private ValueAnimator fdo = new ValueAnimator();

    public aq() {
        this.fdo.setFloatValues(1.0f, 0.0f);
        this.fdo.setDuration(400L);
        this.fdo.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.aq.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (aq.this.fdm != null && valueAnimator != null) {
                    aq.this.fdm.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.fdo.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.aq.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (aq.this.fdm != null) {
                    aq.this.bez();
                    aq.this.fdm.setAlpha(1.0f);
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
                com.baidu.adp.lib.g.e.jH().postDelayed(aq.this.mHideTipRunnable, aq.this.fdn);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i) {
        if (viewGroup != null && view != null) {
            this.fdm = view;
            bez();
            viewGroup.addView(this.fdm, layoutParams);
            this.fdm.setVisibility(0);
            this.fdn = i;
            com.baidu.adp.lib.g.e.jH().removeCallbacks(this.mHideTipRunnable);
            com.baidu.adp.lib.g.e.jH().postDelayed(this.mHideTipRunnable, this.fdn);
        }
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup != null && view != null) {
            this.fdm = view;
            bez();
            viewGroup.addView(this.fdm, layoutParams);
            this.fdm.setVisibility(0);
        }
    }

    public void hideTip() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.mHideTipRunnable);
        if (this.fdm != null && this.fdm.getParent() != null && this.fdm.getVisibility() == 0 && !this.fdo.isRunning()) {
            this.fdo.start();
        }
    }

    public void bez() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.mHideTipRunnable);
        if (this.fdm != null) {
            if (this.fdo != null && this.fdo.isRunning()) {
                this.fdo.cancel();
            }
            this.fdm.clearAnimation();
            if (this.fdm.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.fdm.getParent()).removeView(this.fdm);
            }
            this.fdm.setVisibility(8);
        }
    }

    public void onDestroy() {
        bez();
    }
}
