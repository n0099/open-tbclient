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
    private TranslateAnimation bxM;
    private View iff = null;
    private int ifg = 2000;
    private Runnable bxN = new Runnable() { // from class: com.baidu.tieba.frs.be.1
        @Override // java.lang.Runnable
        public void run() {
            be.this.hideTip();
        }
    };
    private ValueAnimator ifh = new ValueAnimator();

    public be() {
        this.ifh.setFloatValues(1.0f, 0.0f);
        this.ifh.setDuration(400L);
        this.ifh.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.be.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (be.this.iff != null && valueAnimator != null) {
                    be.this.iff.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.ifh.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.be.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (be.this.iff != null) {
                    be.this.crA();
                    be.this.iff.setAlpha(1.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.bxM = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds56), 0.0f);
        this.bxM.setDuration(400L);
        this.bxM.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.be.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                com.baidu.adp.lib.f.e.mX().postDelayed(be.this.bxN, be.this.ifg);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i) {
        if (viewGroup != null && view != null) {
            this.iff = view;
            crA();
            viewGroup.addView(this.iff, layoutParams);
            this.iff.setVisibility(0);
            this.ifg = i;
            com.baidu.adp.lib.f.e.mX().removeCallbacks(this.bxN);
            com.baidu.adp.lib.f.e.mX().postDelayed(this.bxN, this.ifg);
        }
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup != null && view != null) {
            this.iff = view;
            crA();
            viewGroup.addView(this.iff, layoutParams);
            this.iff.setVisibility(0);
        }
    }

    public void hideTip() {
        com.baidu.adp.lib.f.e.mX().removeCallbacks(this.bxN);
        if (this.iff != null && this.iff.getParent() != null && this.iff.getVisibility() == 0 && !this.ifh.isRunning()) {
            this.ifh.start();
        }
    }

    public void crA() {
        com.baidu.adp.lib.f.e.mX().removeCallbacks(this.bxN);
        if (this.iff != null) {
            if (this.ifh != null && this.ifh.isRunning()) {
                this.ifh.cancel();
            }
            this.iff.clearAnimation();
            if (this.iff.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.iff.getParent()).removeView(this.iff);
            }
            this.iff.setVisibility(8);
        }
    }

    public void onDestroy() {
        crA();
    }
}
