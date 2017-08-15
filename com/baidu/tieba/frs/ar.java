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
public class ar {
    private TranslateAnimation cmW;
    private View cmT = null;
    private int cmU = 2000;
    private Runnable cmX = new Runnable() { // from class: com.baidu.tieba.frs.ar.1
        @Override // java.lang.Runnable
        public void run() {
            ar.this.hideTip();
        }
    };
    private ValueAnimator cmV = new ValueAnimator();

    public ar() {
        this.cmV.setFloatValues(1.0f, 0.0f);
        this.cmV.setDuration(400L);
        this.cmV.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.ar.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (ar.this.cmT != null && valueAnimator != null) {
                    ar.this.cmT.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.cmV.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.ar.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (ar.this.cmT != null) {
                    ar.this.agH();
                    ar.this.cmT.setAlpha(1.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.cmW = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.getInst().getResources().getDimension(d.f.ds56), 0.0f);
        this.cmW.setDuration(400L);
        this.cmW.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.ar.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                com.baidu.adp.lib.g.e.ga().postDelayed(ar.this.cmX, ar.this.cmU);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i) {
        if (viewGroup != null && view != null) {
            this.cmT = view;
            agH();
            viewGroup.addView(this.cmT, layoutParams);
            this.cmT.setVisibility(0);
            this.cmU = i;
            com.baidu.adp.lib.g.e.ga().removeCallbacks(this.cmX);
            com.baidu.adp.lib.g.e.ga().postDelayed(this.cmX, this.cmU);
        }
    }

    public void hideTip() {
        com.baidu.adp.lib.g.e.ga().removeCallbacks(this.cmX);
        if (this.cmT != null && this.cmT.getParent() != null && this.cmT.getVisibility() == 0 && !this.cmV.isRunning()) {
            this.cmV.start();
        }
    }

    public void agH() {
        com.baidu.adp.lib.g.e.ga().removeCallbacks(this.cmX);
        if (this.cmT != null) {
            if (this.cmV != null && this.cmV.isRunning()) {
                this.cmV.cancel();
            }
            this.cmT.clearAnimation();
            if (this.cmT.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.cmT.getParent()).removeView(this.cmT);
            }
            this.cmT.setVisibility(8);
        }
    }

    public void onDestroy() {
        agH();
    }
}
