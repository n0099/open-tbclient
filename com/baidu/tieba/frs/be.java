package com.baidu.tieba.frs;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class be {
    private TranslateAnimation buu;
    private View hXV = null;
    private int hXW = 2000;
    private Runnable buv = new Runnable() { // from class: com.baidu.tieba.frs.be.1
        @Override // java.lang.Runnable
        public void run() {
            be.this.hideTip();
        }
    };
    private ValueAnimator hXX = new ValueAnimator();

    public be() {
        this.hXX.setFloatValues(1.0f, 0.0f);
        this.hXX.setDuration(400L);
        this.hXX.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.be.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (be.this.hXV != null && valueAnimator != null) {
                    be.this.hXV.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.hXX.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.be.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (be.this.hXV != null) {
                    be.this.com();
                    be.this.hXV.setAlpha(1.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.buu = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds56), 0.0f);
        this.buu.setDuration(400L);
        this.buu.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.be.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                com.baidu.adp.lib.f.e.mS().postDelayed(be.this.buv, be.this.hXW);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i) {
        if (viewGroup != null && view != null) {
            this.hXV = view;
            com();
            viewGroup.addView(this.hXV, layoutParams);
            this.hXV.setVisibility(0);
            this.hXW = i;
            com.baidu.adp.lib.f.e.mS().removeCallbacks(this.buv);
            com.baidu.adp.lib.f.e.mS().postDelayed(this.buv, this.hXW);
        }
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup != null && view != null) {
            this.hXV = view;
            com();
            viewGroup.addView(this.hXV, layoutParams);
            this.hXV.setVisibility(0);
        }
    }

    public void hideTip() {
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.buv);
        if (this.hXV != null && this.hXV.getParent() != null && this.hXV.getVisibility() == 0 && !this.hXX.isRunning()) {
            this.hXX.start();
        }
    }

    public void com() {
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.buv);
        if (this.hXV != null) {
            if (this.hXX != null && this.hXX.isRunning()) {
                this.hXX.cancel();
            }
            this.hXV.clearAnimation();
            if (this.hXV.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.hXV.getParent()).removeView(this.hXV);
            }
            this.hXV.setVisibility(8);
        }
    }

    public void onDestroy() {
        com();
    }
}
