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
    private View dwd = null;
    private int dwe = 2000;
    private Runnable mHideTipRunnable = new Runnable() { // from class: com.baidu.tieba.frs.as.1
        @Override // java.lang.Runnable
        public void run() {
            as.this.hideTip();
        }
    };
    private ValueAnimator dwf = new ValueAnimator();

    public as() {
        this.dwf.setFloatValues(1.0f, 0.0f);
        this.dwf.setDuration(400L);
        this.dwf.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.as.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (as.this.dwd != null && valueAnimator != null) {
                    as.this.dwd.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.dwf.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.as.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (as.this.dwd != null) {
                    as.this.ayc();
                    as.this.dwd.setAlpha(1.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.mTipInAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.getInst().getResources().getDimension(e.C0141e.ds56), 0.0f);
        this.mTipInAnimation.setDuration(400L);
        this.mTipInAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.as.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                com.baidu.adp.lib.g.e.jt().postDelayed(as.this.mHideTipRunnable, as.this.dwe);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i) {
        if (viewGroup != null && view != null) {
            this.dwd = view;
            ayc();
            viewGroup.addView(this.dwd, layoutParams);
            this.dwd.setVisibility(0);
            this.dwe = i;
            com.baidu.adp.lib.g.e.jt().removeCallbacks(this.mHideTipRunnable);
            com.baidu.adp.lib.g.e.jt().postDelayed(this.mHideTipRunnable, this.dwe);
        }
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup != null && view != null) {
            this.dwd = view;
            ayc();
            viewGroup.addView(this.dwd, layoutParams);
            this.dwd.setVisibility(0);
        }
    }

    public void hideTip() {
        com.baidu.adp.lib.g.e.jt().removeCallbacks(this.mHideTipRunnable);
        if (this.dwd != null && this.dwd.getParent() != null && this.dwd.getVisibility() == 0 && !this.dwf.isRunning()) {
            this.dwf.start();
        }
    }

    public void ayc() {
        com.baidu.adp.lib.g.e.jt().removeCallbacks(this.mHideTipRunnable);
        if (this.dwd != null) {
            if (this.dwf != null && this.dwf.isRunning()) {
                this.dwf.cancel();
            }
            this.dwd.clearAnimation();
            if (this.dwd.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.dwd.getParent()).removeView(this.dwd);
            }
            this.dwd.setVisibility(8);
        }
    }

    public void onDestroy() {
        ayc();
    }
}
