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
public class bb {
    private TranslateAnimation bVp;
    private View jko = null;
    private int jkp = 2000;
    private Runnable bVq = new Runnable() { // from class: com.baidu.tieba.frs.bb.1
        @Override // java.lang.Runnable
        public void run() {
            bb.this.hideTip();
        }
    };
    private ValueAnimator jkq = new ValueAnimator();

    public bb() {
        this.jkq.setFloatValues(1.0f, 0.0f);
        this.jkq.setDuration(400L);
        this.jkq.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.bb.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (bb.this.jko != null && valueAnimator != null) {
                    bb.this.jko.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.jkq.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.bb.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (bb.this.jko != null) {
                    bb.this.cHw();
                    bb.this.jko.setAlpha(1.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.bVp = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds56), 0.0f);
        this.bVp.setDuration(400L);
        this.bVp.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.bb.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                com.baidu.adp.lib.f.e.mB().postDelayed(bb.this.bVq, bb.this.jkp);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i) {
        if (viewGroup != null && view != null) {
            this.jko = view;
            cHw();
            viewGroup.addView(this.jko, layoutParams);
            this.jko.setVisibility(0);
            this.jkp = i;
            com.baidu.adp.lib.f.e.mB().removeCallbacks(this.bVq);
            com.baidu.adp.lib.f.e.mB().postDelayed(this.bVq, this.jkp);
        }
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup != null && view != null) {
            this.jko = view;
            cHw();
            viewGroup.addView(this.jko, layoutParams);
            this.jko.setVisibility(0);
        }
    }

    public void hideTip() {
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.bVq);
        if (this.jko != null && this.jko.getParent() != null && this.jko.getVisibility() == 0 && !this.jkq.isRunning()) {
            this.jkq.start();
        }
    }

    public void cHw() {
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.bVq);
        if (this.jko != null) {
            if (this.jkq != null && this.jkq.isRunning()) {
                this.jkq.cancel();
            }
            this.jko.clearAnimation();
            if (this.jko.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.jko.getParent()).removeView(this.jko);
            }
            this.jko.setVisibility(8);
        }
    }

    public void onDestroy() {
        cHw();
    }
}
