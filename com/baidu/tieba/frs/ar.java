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
    private TranslateAnimation clc;
    private View ckZ = null;
    private int cla = 2000;
    private Runnable cld = new Runnable() { // from class: com.baidu.tieba.frs.ar.1
        @Override // java.lang.Runnable
        public void run() {
            ar.this.hideTip();
        }
    };
    private ValueAnimator clb = new ValueAnimator();

    public ar() {
        this.clb.setFloatValues(1.0f, 0.0f);
        this.clb.setDuration(400L);
        this.clb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.ar.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (ar.this.ckZ != null && valueAnimator != null) {
                    ar.this.ckZ.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.clb.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.ar.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (ar.this.ckZ != null) {
                    ar.this.agf();
                    ar.this.ckZ.setAlpha(1.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.clc = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.getInst().getResources().getDimension(d.f.ds56), 0.0f);
        this.clc.setDuration(400L);
        this.clc.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.ar.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                com.baidu.adp.lib.g.e.fP().postDelayed(ar.this.cld, ar.this.cla);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i) {
        if (viewGroup != null && view != null) {
            this.ckZ = view;
            agf();
            viewGroup.addView(this.ckZ, layoutParams);
            this.ckZ.setVisibility(0);
            this.cla = i;
            com.baidu.adp.lib.g.e.fP().removeCallbacks(this.cld);
            com.baidu.adp.lib.g.e.fP().postDelayed(this.cld, this.cla);
        }
    }

    public void hideTip() {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.cld);
        if (this.ckZ != null && this.ckZ.getParent() != null && this.ckZ.getVisibility() == 0 && !this.clb.isRunning()) {
            this.clb.start();
        }
    }

    public void agf() {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.cld);
        if (this.ckZ != null) {
            if (this.clb != null && this.clb.isRunning()) {
                this.clb.cancel();
            }
            this.ckZ.clearAnimation();
            if (this.ckZ.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.ckZ.getParent()).removeView(this.ckZ);
            }
            this.ckZ.setVisibility(8);
        }
    }

    public void onDestroy() {
        agf();
    }
}
