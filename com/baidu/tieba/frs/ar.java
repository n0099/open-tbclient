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
    private TranslateAnimation cmX;
    private View cmU = null;
    private int cmV = 2000;
    private Runnable cmY = new Runnable() { // from class: com.baidu.tieba.frs.ar.1
        @Override // java.lang.Runnable
        public void run() {
            ar.this.hideTip();
        }
    };
    private ValueAnimator cmW = new ValueAnimator();

    public ar() {
        this.cmW.setFloatValues(1.0f, 0.0f);
        this.cmW.setDuration(400L);
        this.cmW.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.ar.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (ar.this.cmU != null && valueAnimator != null) {
                    ar.this.cmU.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.cmW.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.ar.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (ar.this.cmU != null) {
                    ar.this.agB();
                    ar.this.cmU.setAlpha(1.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.cmX = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.getInst().getResources().getDimension(d.f.ds56), 0.0f);
        this.cmX.setDuration(400L);
        this.cmX.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.ar.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                com.baidu.adp.lib.g.e.ga().postDelayed(ar.this.cmY, ar.this.cmV);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i) {
        if (viewGroup != null && view != null) {
            this.cmU = view;
            agB();
            viewGroup.addView(this.cmU, layoutParams);
            this.cmU.setVisibility(0);
            this.cmV = i;
            com.baidu.adp.lib.g.e.ga().removeCallbacks(this.cmY);
            com.baidu.adp.lib.g.e.ga().postDelayed(this.cmY, this.cmV);
        }
    }

    public void hideTip() {
        com.baidu.adp.lib.g.e.ga().removeCallbacks(this.cmY);
        if (this.cmU != null && this.cmU.getParent() != null && this.cmU.getVisibility() == 0 && !this.cmW.isRunning()) {
            this.cmW.start();
        }
    }

    public void agB() {
        com.baidu.adp.lib.g.e.ga().removeCallbacks(this.cmY);
        if (this.cmU != null) {
            if (this.cmW != null && this.cmW.isRunning()) {
                this.cmW.cancel();
            }
            this.cmU.clearAnimation();
            if (this.cmU.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.cmU.getParent()).removeView(this.cmU);
            }
            this.cmU.setVisibility(8);
        }
    }

    public void onDestroy() {
        agB();
    }
}
