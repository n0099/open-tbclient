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
    private TranslateAnimation bLg;
    private View iNi = null;
    private int iNj = 2000;
    private Runnable bLh = new Runnable() { // from class: com.baidu.tieba.frs.be.1
        @Override // java.lang.Runnable
        public void run() {
            be.this.hideTip();
        }
    };
    private ValueAnimator iNk = new ValueAnimator();

    public be() {
        this.iNk.setFloatValues(1.0f, 0.0f);
        this.iNk.setDuration(400L);
        this.iNk.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.be.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (be.this.iNi != null && valueAnimator != null) {
                    be.this.iNi.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.iNk.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.be.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (be.this.iNi != null) {
                    be.this.cAj();
                    be.this.iNi.setAlpha(1.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.bLg = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds56), 0.0f);
        this.bLg.setDuration(400L);
        this.bLg.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.be.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                com.baidu.adp.lib.f.e.mY().postDelayed(be.this.bLh, be.this.iNj);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i) {
        if (viewGroup != null && view != null) {
            this.iNi = view;
            cAj();
            viewGroup.addView(this.iNi, layoutParams);
            this.iNi.setVisibility(0);
            this.iNj = i;
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.bLh);
            com.baidu.adp.lib.f.e.mY().postDelayed(this.bLh, this.iNj);
        }
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup != null && view != null) {
            this.iNi = view;
            cAj();
            viewGroup.addView(this.iNi, layoutParams);
            this.iNi.setVisibility(0);
        }
    }

    public void hideTip() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.bLh);
        if (this.iNi != null && this.iNi.getParent() != null && this.iNi.getVisibility() == 0 && !this.iNk.isRunning()) {
            this.iNk.start();
        }
    }

    public void cAj() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.bLh);
        if (this.iNi != null) {
            if (this.iNk != null && this.iNk.isRunning()) {
                this.iNk.cancel();
            }
            this.iNi.clearAnimation();
            if (this.iNi.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.iNi.getParent()).removeView(this.iNi);
            }
            this.iNi.setVisibility(8);
        }
    }

    public void onDestroy() {
        cAj();
    }
}
