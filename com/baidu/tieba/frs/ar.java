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
    private TranslateAnimation ctj;
    private View ctg = null;
    private int cth = 2000;
    private Runnable ctk = new Runnable() { // from class: com.baidu.tieba.frs.ar.1
        @Override // java.lang.Runnable
        public void run() {
            ar.this.hideTip();
        }
    };
    private ValueAnimator cti = new ValueAnimator();

    public ar() {
        this.cti.setFloatValues(1.0f, 0.0f);
        this.cti.setDuration(400L);
        this.cti.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.ar.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (ar.this.ctg != null && valueAnimator != null) {
                    ar.this.ctg.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.cti.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.ar.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (ar.this.ctg != null) {
                    ar.this.aik();
                    ar.this.ctg.setAlpha(1.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.ctj = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.getInst().getResources().getDimension(d.f.ds56), 0.0f);
        this.ctj.setDuration(400L);
        this.ctj.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.ar.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                com.baidu.adp.lib.g.e.fQ().postDelayed(ar.this.ctk, ar.this.cth);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i) {
        if (viewGroup != null && view != null) {
            this.ctg = view;
            aik();
            viewGroup.addView(this.ctg, layoutParams);
            this.ctg.setVisibility(0);
            this.cth = i;
            com.baidu.adp.lib.g.e.fQ().removeCallbacks(this.ctk);
            com.baidu.adp.lib.g.e.fQ().postDelayed(this.ctk, this.cth);
        }
    }

    public void hideTip() {
        com.baidu.adp.lib.g.e.fQ().removeCallbacks(this.ctk);
        if (this.ctg != null && this.ctg.getParent() != null && this.ctg.getVisibility() == 0 && !this.cti.isRunning()) {
            this.cti.start();
        }
    }

    public void aik() {
        com.baidu.adp.lib.g.e.fQ().removeCallbacks(this.ctk);
        if (this.ctg != null) {
            if (this.cti != null && this.cti.isRunning()) {
                this.cti.cancel();
            }
            this.ctg.clearAnimation();
            if (this.ctg.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.ctg.getParent()).removeView(this.ctg);
            }
            this.ctg.setVisibility(8);
        }
    }

    public void onDestroy() {
        aik();
    }
}
