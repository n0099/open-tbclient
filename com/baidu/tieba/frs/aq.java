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
    private View dau = null;
    private int dav = 2000;
    private Runnable mHideTipRunnable = new Runnable() { // from class: com.baidu.tieba.frs.aq.1
        @Override // java.lang.Runnable
        public void run() {
            aq.this.hideTip();
        }
    };
    private ValueAnimator daw = new ValueAnimator();

    public aq() {
        this.daw.setFloatValues(1.0f, 0.0f);
        this.daw.setDuration(400L);
        this.daw.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.aq.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (aq.this.dau != null && valueAnimator != null) {
                    aq.this.dau.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.daw.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.aq.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (aq.this.dau != null) {
                    aq.this.aqP();
                    aq.this.dau.setAlpha(1.0f);
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
                com.baidu.adp.lib.g.e.fw().postDelayed(aq.this.mHideTipRunnable, aq.this.dav);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void a(View view2, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i) {
        if (viewGroup != null && view2 != null) {
            this.dau = view2;
            aqP();
            viewGroup.addView(this.dau, layoutParams);
            this.dau.setVisibility(0);
            this.dav = i;
            com.baidu.adp.lib.g.e.fw().removeCallbacks(this.mHideTipRunnable);
            com.baidu.adp.lib.g.e.fw().postDelayed(this.mHideTipRunnable, this.dav);
        }
    }

    public void a(View view2, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup != null && view2 != null) {
            this.dau = view2;
            aqP();
            viewGroup.addView(this.dau, layoutParams);
            this.dau.setVisibility(0);
        }
    }

    public void hideTip() {
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.mHideTipRunnable);
        if (this.dau != null && this.dau.getParent() != null && this.dau.getVisibility() == 0 && !this.daw.isRunning()) {
            this.daw.start();
        }
    }

    public void aqP() {
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.mHideTipRunnable);
        if (this.dau != null) {
            if (this.daw != null && this.daw.isRunning()) {
                this.daw.cancel();
            }
            this.dau.clearAnimation();
            if (this.dau.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.dau.getParent()).removeView(this.dau);
            }
            this.dau.setVisibility(8);
        }
    }

    public void onDestroy() {
        aqP();
    }
}
