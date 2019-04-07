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
    private View fcY = null;
    private int fcZ = 2000;
    private Runnable mHideTipRunnable = new Runnable() { // from class: com.baidu.tieba.frs.aq.1
        @Override // java.lang.Runnable
        public void run() {
            aq.this.hideTip();
        }
    };
    private ValueAnimator fda = new ValueAnimator();

    public aq() {
        this.fda.setFloatValues(1.0f, 0.0f);
        this.fda.setDuration(400L);
        this.fda.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.aq.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (aq.this.fcY != null && valueAnimator != null) {
                    aq.this.fcY.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.fda.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.aq.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (aq.this.fcY != null) {
                    aq.this.bex();
                    aq.this.fcY.setAlpha(1.0f);
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
                com.baidu.adp.lib.g.e.jH().postDelayed(aq.this.mHideTipRunnable, aq.this.fcZ);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i) {
        if (viewGroup != null && view != null) {
            this.fcY = view;
            bex();
            viewGroup.addView(this.fcY, layoutParams);
            this.fcY.setVisibility(0);
            this.fcZ = i;
            com.baidu.adp.lib.g.e.jH().removeCallbacks(this.mHideTipRunnable);
            com.baidu.adp.lib.g.e.jH().postDelayed(this.mHideTipRunnable, this.fcZ);
        }
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup != null && view != null) {
            this.fcY = view;
            bex();
            viewGroup.addView(this.fcY, layoutParams);
            this.fcY.setVisibility(0);
        }
    }

    public void hideTip() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.mHideTipRunnable);
        if (this.fcY != null && this.fcY.getParent() != null && this.fcY.getVisibility() == 0 && !this.fda.isRunning()) {
            this.fda.start();
        }
    }

    public void bex() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.mHideTipRunnable);
        if (this.fcY != null) {
            if (this.fda != null && this.fda.isRunning()) {
                this.fda.cancel();
            }
            this.fcY.clearAnimation();
            if (this.fcY.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.fcY.getParent()).removeView(this.fcY);
            }
            this.fcY.setVisibility(8);
        }
    }

    public void onDestroy() {
        bex();
    }
}
