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
public class be {
    private TranslateAnimation bQl;
    private View iYb = null;
    private int iYc = 2000;
    private Runnable bQm = new Runnable() { // from class: com.baidu.tieba.frs.be.1
        @Override // java.lang.Runnable
        public void run() {
            be.this.hideTip();
        }
    };
    private ValueAnimator iYd = new ValueAnimator();

    public be() {
        this.iYd.setFloatValues(1.0f, 0.0f);
        this.iYd.setDuration(400L);
        this.iYd.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.be.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (be.this.iYb != null && valueAnimator != null) {
                    be.this.iYb.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.iYd.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.be.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (be.this.iYb != null) {
                    be.this.cEA();
                    be.this.iYb.setAlpha(1.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.bQl = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds56), 0.0f);
        this.bQl.setDuration(400L);
        this.bQl.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.be.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                com.baidu.adp.lib.f.e.mY().postDelayed(be.this.bQm, be.this.iYc);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i) {
        if (viewGroup != null && view != null) {
            this.iYb = view;
            cEA();
            viewGroup.addView(this.iYb, layoutParams);
            this.iYb.setVisibility(0);
            this.iYc = i;
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.bQm);
            com.baidu.adp.lib.f.e.mY().postDelayed(this.bQm, this.iYc);
        }
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup != null && view != null) {
            this.iYb = view;
            cEA();
            viewGroup.addView(this.iYb, layoutParams);
            this.iYb.setVisibility(0);
        }
    }

    public void hideTip() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.bQm);
        if (this.iYb != null && this.iYb.getParent() != null && this.iYb.getVisibility() == 0 && !this.iYd.isRunning()) {
            this.iYd.start();
        }
    }

    public void cEA() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.bQm);
        if (this.iYb != null) {
            if (this.iYd != null && this.iYd.isRunning()) {
                this.iYd.cancel();
            }
            this.iYb.clearAnimation();
            if (this.iYb.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.iYb.getParent()).removeView(this.iYb);
            }
            this.iYb.setVisibility(8);
        }
    }

    public void onDestroy() {
        cEA();
    }
}
