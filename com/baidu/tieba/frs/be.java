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
    private TranslateAnimation bMQ;
    private View iMv = null;
    private int iMw = 2000;
    private Runnable bMR = new Runnable() { // from class: com.baidu.tieba.frs.be.1
        @Override // java.lang.Runnable
        public void run() {
            be.this.hideTip();
        }
    };
    private ValueAnimator iMx = new ValueAnimator();

    public be() {
        this.iMx.setFloatValues(1.0f, 0.0f);
        this.iMx.setDuration(400L);
        this.iMx.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.be.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (be.this.iMv != null && valueAnimator != null) {
                    be.this.iMv.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.iMx.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.be.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (be.this.iMv != null) {
                    be.this.cAG();
                    be.this.iMv.setAlpha(1.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.bMQ = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds56), 0.0f);
        this.bMQ.setDuration(400L);
        this.bMQ.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.be.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                com.baidu.adp.lib.f.e.mY().postDelayed(be.this.bMR, be.this.iMw);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i) {
        if (viewGroup != null && view != null) {
            this.iMv = view;
            cAG();
            viewGroup.addView(this.iMv, layoutParams);
            this.iMv.setVisibility(0);
            this.iMw = i;
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.bMR);
            com.baidu.adp.lib.f.e.mY().postDelayed(this.bMR, this.iMw);
        }
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup != null && view != null) {
            this.iMv = view;
            cAG();
            viewGroup.addView(this.iMv, layoutParams);
            this.iMv.setVisibility(0);
        }
    }

    public void hideTip() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.bMR);
        if (this.iMv != null && this.iMv.getParent() != null && this.iMv.getVisibility() == 0 && !this.iMx.isRunning()) {
            this.iMx.start();
        }
    }

    public void cAG() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.bMR);
        if (this.iMv != null) {
            if (this.iMx != null && this.iMx.isRunning()) {
                this.iMx.cancel();
            }
            this.iMv.clearAnimation();
            if (this.iMv.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.iMv.getParent()).removeView(this.iMv);
            }
            this.iMv.setVisibility(8);
        }
    }

    public void onDestroy() {
        cAG();
    }
}
