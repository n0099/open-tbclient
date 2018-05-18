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
    private View dbC = null;
    private int dbD = 2000;
    private Runnable mHideTipRunnable = new Runnable() { // from class: com.baidu.tieba.frs.aq.1
        @Override // java.lang.Runnable
        public void run() {
            aq.this.hideTip();
        }
    };
    private ValueAnimator dbE = new ValueAnimator();

    public aq() {
        this.dbE.setFloatValues(1.0f, 0.0f);
        this.dbE.setDuration(400L);
        this.dbE.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.aq.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (aq.this.dbC != null && valueAnimator != null) {
                    aq.this.dbC.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.dbE.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.aq.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (aq.this.dbC != null) {
                    aq.this.aqO();
                    aq.this.dbC.setAlpha(1.0f);
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
                com.baidu.adp.lib.g.e.fw().postDelayed(aq.this.mHideTipRunnable, aq.this.dbD);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void a(View view2, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i) {
        if (viewGroup != null && view2 != null) {
            this.dbC = view2;
            aqO();
            viewGroup.addView(this.dbC, layoutParams);
            this.dbC.setVisibility(0);
            this.dbD = i;
            com.baidu.adp.lib.g.e.fw().removeCallbacks(this.mHideTipRunnable);
            com.baidu.adp.lib.g.e.fw().postDelayed(this.mHideTipRunnable, this.dbD);
        }
    }

    public void a(View view2, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup != null && view2 != null) {
            this.dbC = view2;
            aqO();
            viewGroup.addView(this.dbC, layoutParams);
            this.dbC.setVisibility(0);
        }
    }

    public void hideTip() {
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.mHideTipRunnable);
        if (this.dbC != null && this.dbC.getParent() != null && this.dbC.getVisibility() == 0 && !this.dbE.isRunning()) {
            this.dbE.start();
        }
    }

    public void aqO() {
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.mHideTipRunnable);
        if (this.dbC != null) {
            if (this.dbE != null && this.dbE.isRunning()) {
                this.dbE.cancel();
            }
            this.dbC.clearAnimation();
            if (this.dbC.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.dbC.getParent()).removeView(this.dbC);
            }
            this.dbC.setVisibility(8);
        }
    }

    public void onDestroy() {
        aqO();
    }
}
