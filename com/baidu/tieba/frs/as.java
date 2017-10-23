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
public class as {
    private TranslateAnimation ctC;
    private View ctz = null;
    private int ctA = 2000;
    private Runnable ctD = new Runnable() { // from class: com.baidu.tieba.frs.as.1
        @Override // java.lang.Runnable
        public void run() {
            as.this.hideTip();
        }
    };
    private ValueAnimator ctB = new ValueAnimator();

    public as() {
        this.ctB.setFloatValues(1.0f, 0.0f);
        this.ctB.setDuration(400L);
        this.ctB.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.as.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (as.this.ctz != null && valueAnimator != null) {
                    as.this.ctz.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.ctB.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.as.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (as.this.ctz != null) {
                    as.this.aii();
                    as.this.ctz.setAlpha(1.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.ctC = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.getInst().getResources().getDimension(d.f.ds56), 0.0f);
        this.ctC.setDuration(400L);
        this.ctC.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.as.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                com.baidu.adp.lib.g.e.fP().postDelayed(as.this.ctD, as.this.ctA);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i) {
        if (viewGroup != null && view != null) {
            this.ctz = view;
            aii();
            viewGroup.addView(this.ctz, layoutParams);
            this.ctz.setVisibility(0);
            this.ctA = i;
            com.baidu.adp.lib.g.e.fP().removeCallbacks(this.ctD);
            com.baidu.adp.lib.g.e.fP().postDelayed(this.ctD, this.ctA);
        }
    }

    public void hideTip() {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.ctD);
        if (this.ctz != null && this.ctz.getParent() != null && this.ctz.getVisibility() == 0 && !this.ctB.isRunning()) {
            this.ctB.start();
        }
    }

    public void aii() {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.ctD);
        if (this.ctz != null) {
            if (this.ctB != null && this.ctB.isRunning()) {
                this.ctB.cancel();
            }
            this.ctz.clearAnimation();
            if (this.ctz.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.ctz.getParent()).removeView(this.ctz);
            }
            this.ctz.setVisibility(8);
        }
    }

    public void onDestroy() {
        aii();
    }
}
