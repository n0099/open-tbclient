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
public class bc {
    private TranslateAnimation bom;
    private View hEy = null;
    private int hEz = 2000;
    private Runnable bon = new Runnable() { // from class: com.baidu.tieba.frs.bc.1
        @Override // java.lang.Runnable
        public void run() {
            bc.this.hideTip();
        }
    };
    private ValueAnimator hEA = new ValueAnimator();

    public bc() {
        this.hEA.setFloatValues(1.0f, 0.0f);
        this.hEA.setDuration(400L);
        this.hEA.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.bc.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (bc.this.hEy != null && valueAnimator != null) {
                    bc.this.hEy.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.hEA.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.bc.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (bc.this.hEy != null) {
                    bc.this.cao();
                    bc.this.hEy.setAlpha(1.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.bom = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds56), 0.0f);
        this.bom.setDuration(400L);
        this.bom.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.bc.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                com.baidu.adp.lib.f.e.lt().postDelayed(bc.this.bon, bc.this.hEz);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i) {
        if (viewGroup != null && view != null) {
            this.hEy = view;
            cao();
            viewGroup.addView(this.hEy, layoutParams);
            this.hEy.setVisibility(0);
            this.hEz = i;
            com.baidu.adp.lib.f.e.lt().removeCallbacks(this.bon);
            com.baidu.adp.lib.f.e.lt().postDelayed(this.bon, this.hEz);
        }
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup != null && view != null) {
            this.hEy = view;
            cao();
            viewGroup.addView(this.hEy, layoutParams);
            this.hEy.setVisibility(0);
        }
    }

    public void hideTip() {
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.bon);
        if (this.hEy != null && this.hEy.getParent() != null && this.hEy.getVisibility() == 0 && !this.hEA.isRunning()) {
            this.hEA.start();
        }
    }

    public void cao() {
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.bon);
        if (this.hEy != null) {
            if (this.hEA != null && this.hEA.isRunning()) {
                this.hEA.cancel();
            }
            this.hEy.clearAnimation();
            if (this.hEy.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.hEy.getParent()).removeView(this.hEy);
            }
            this.hEy.setVisibility(8);
        }
    }

    public void onDestroy() {
        cao();
    }
}
