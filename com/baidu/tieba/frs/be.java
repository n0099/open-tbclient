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
    private TranslateAnimation bHl;
    private View iGy = null;
    private int iGz = 2000;
    private Runnable bHm = new Runnable() { // from class: com.baidu.tieba.frs.be.1
        @Override // java.lang.Runnable
        public void run() {
            be.this.hideTip();
        }
    };
    private ValueAnimator iGA = new ValueAnimator();

    public be() {
        this.iGA.setFloatValues(1.0f, 0.0f);
        this.iGA.setDuration(400L);
        this.iGA.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.be.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (be.this.iGy != null && valueAnimator != null) {
                    be.this.iGy.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.iGA.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.be.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (be.this.iGy != null) {
                    be.this.cyf();
                    be.this.iGy.setAlpha(1.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.bHl = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds56), 0.0f);
        this.bHl.setDuration(400L);
        this.bHl.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.be.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                com.baidu.adp.lib.f.e.mY().postDelayed(be.this.bHm, be.this.iGz);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i) {
        if (viewGroup != null && view != null) {
            this.iGy = view;
            cyf();
            viewGroup.addView(this.iGy, layoutParams);
            this.iGy.setVisibility(0);
            this.iGz = i;
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.bHm);
            com.baidu.adp.lib.f.e.mY().postDelayed(this.bHm, this.iGz);
        }
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup != null && view != null) {
            this.iGy = view;
            cyf();
            viewGroup.addView(this.iGy, layoutParams);
            this.iGy.setVisibility(0);
        }
    }

    public void hideTip() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.bHm);
        if (this.iGy != null && this.iGy.getParent() != null && this.iGy.getVisibility() == 0 && !this.iGA.isRunning()) {
            this.iGA.start();
        }
    }

    public void cyf() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.bHm);
        if (this.iGy != null) {
            if (this.iGA != null && this.iGA.isRunning()) {
                this.iGA.cancel();
            }
            this.iGy.clearAnimation();
            if (this.iGy.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.iGy.getParent()).removeView(this.iGy);
            }
            this.iGy.setVisibility(8);
        }
    }

    public void onDestroy() {
        cyf();
    }
}
