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
    private TranslateAnimation cml;
    private View cmi = null;
    private int cmj = 2000;
    private Runnable cmm = new Runnable() { // from class: com.baidu.tieba.frs.ar.1
        @Override // java.lang.Runnable
        public void run() {
            ar.this.hideTip();
        }
    };
    private ValueAnimator cmk = new ValueAnimator();

    public ar() {
        this.cmk.setFloatValues(1.0f, 0.0f);
        this.cmk.setDuration(400L);
        this.cmk.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.ar.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (ar.this.cmi != null && valueAnimator != null) {
                    ar.this.cmi.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.cmk.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.ar.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (ar.this.cmi != null) {
                    ar.this.agm();
                    ar.this.cmi.setAlpha(1.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.cml = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.getInst().getResources().getDimension(d.f.ds56), 0.0f);
        this.cml.setDuration(400L);
        this.cml.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.ar.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                com.baidu.adp.lib.g.e.ga().postDelayed(ar.this.cmm, ar.this.cmj);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i) {
        if (viewGroup != null && view != null) {
            this.cmi = view;
            agm();
            viewGroup.addView(this.cmi, layoutParams);
            this.cmi.setVisibility(0);
            this.cmj = i;
            com.baidu.adp.lib.g.e.ga().removeCallbacks(this.cmm);
            com.baidu.adp.lib.g.e.ga().postDelayed(this.cmm, this.cmj);
        }
    }

    public void hideTip() {
        com.baidu.adp.lib.g.e.ga().removeCallbacks(this.cmm);
        if (this.cmi != null && this.cmi.getParent() != null && this.cmi.getVisibility() == 0 && !this.cmk.isRunning()) {
            this.cmk.start();
        }
    }

    public void agm() {
        com.baidu.adp.lib.g.e.ga().removeCallbacks(this.cmm);
        if (this.cmi != null) {
            if (this.cmk != null && this.cmk.isRunning()) {
                this.cmk.cancel();
            }
            this.cmi.clearAnimation();
            if (this.cmi.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.cmi.getParent()).removeView(this.cmi);
            }
            this.cmi.setVisibility(8);
        }
    }

    public void onDestroy() {
        agm();
    }
}
