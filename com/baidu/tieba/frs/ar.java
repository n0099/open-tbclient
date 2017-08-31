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
    private TranslateAnimation csr;
    private View cso = null;
    private int csp = 2000;
    private Runnable css = new Runnable() { // from class: com.baidu.tieba.frs.ar.1
        @Override // java.lang.Runnable
        public void run() {
            ar.this.hideTip();
        }
    };
    private ValueAnimator csq = new ValueAnimator();

    public ar() {
        this.csq.setFloatValues(1.0f, 0.0f);
        this.csq.setDuration(400L);
        this.csq.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.ar.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (ar.this.cso != null && valueAnimator != null) {
                    ar.this.cso.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.csq.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.ar.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (ar.this.cso != null) {
                    ar.this.ahZ();
                    ar.this.cso.setAlpha(1.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.csr = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.getInst().getResources().getDimension(d.f.ds56), 0.0f);
        this.csr.setDuration(400L);
        this.csr.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.ar.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                com.baidu.adp.lib.g.e.fQ().postDelayed(ar.this.css, ar.this.csp);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i) {
        if (viewGroup != null && view != null) {
            this.cso = view;
            ahZ();
            viewGroup.addView(this.cso, layoutParams);
            this.cso.setVisibility(0);
            this.csp = i;
            com.baidu.adp.lib.g.e.fQ().removeCallbacks(this.css);
            com.baidu.adp.lib.g.e.fQ().postDelayed(this.css, this.csp);
        }
    }

    public void hideTip() {
        com.baidu.adp.lib.g.e.fQ().removeCallbacks(this.css);
        if (this.cso != null && this.cso.getParent() != null && this.cso.getVisibility() == 0 && !this.csq.isRunning()) {
            this.csq.start();
        }
    }

    public void ahZ() {
        com.baidu.adp.lib.g.e.fQ().removeCallbacks(this.css);
        if (this.cso != null) {
            if (this.csq != null && this.csq.isRunning()) {
                this.csq.cancel();
            }
            this.cso.clearAnimation();
            if (this.cso.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.cso.getParent()).removeView(this.cso);
            }
            this.cso.setVisibility(8);
        }
    }

    public void onDestroy() {
        ahZ();
    }
}
