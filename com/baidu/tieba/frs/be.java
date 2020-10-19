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
    private TranslateAnimation bEp;
    private View iuc = null;
    private int iud = 2000;
    private Runnable bEq = new Runnable() { // from class: com.baidu.tieba.frs.be.1
        @Override // java.lang.Runnable
        public void run() {
            be.this.hideTip();
        }
    };
    private ValueAnimator iue = new ValueAnimator();

    public be() {
        this.iue.setFloatValues(1.0f, 0.0f);
        this.iue.setDuration(400L);
        this.iue.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.be.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (be.this.iuc != null && valueAnimator != null) {
                    be.this.iuc.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.iue.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.be.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (be.this.iuc != null) {
                    be.this.cuY();
                    be.this.iuc.setAlpha(1.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.bEp = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds56), 0.0f);
        this.bEp.setDuration(400L);
        this.bEp.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.be.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                com.baidu.adp.lib.f.e.mY().postDelayed(be.this.bEq, be.this.iud);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i) {
        if (viewGroup != null && view != null) {
            this.iuc = view;
            cuY();
            viewGroup.addView(this.iuc, layoutParams);
            this.iuc.setVisibility(0);
            this.iud = i;
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.bEq);
            com.baidu.adp.lib.f.e.mY().postDelayed(this.bEq, this.iud);
        }
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup != null && view != null) {
            this.iuc = view;
            cuY();
            viewGroup.addView(this.iuc, layoutParams);
            this.iuc.setVisibility(0);
        }
    }

    public void hideTip() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.bEq);
        if (this.iuc != null && this.iuc.getParent() != null && this.iuc.getVisibility() == 0 && !this.iue.isRunning()) {
            this.iue.start();
        }
    }

    public void cuY() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.bEq);
        if (this.iuc != null) {
            if (this.iue != null && this.iue.isRunning()) {
                this.iue.cancel();
            }
            this.iuc.clearAnimation();
            if (this.iuc.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.iuc.getParent()).removeView(this.iuc);
            }
            this.iuc.setVisibility(8);
        }
    }

    public void onDestroy() {
        cuY();
    }
}
