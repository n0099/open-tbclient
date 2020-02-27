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
public class ar {
    private TranslateAnimation aFH;
    private View gsy = null;
    private int gsz = 2000;
    private Runnable aFI = new Runnable() { // from class: com.baidu.tieba.frs.ar.1
        @Override // java.lang.Runnable
        public void run() {
            ar.this.hideTip();
        }
    };
    private ValueAnimator gsA = new ValueAnimator();

    public ar() {
        this.gsA.setFloatValues(1.0f, 0.0f);
        this.gsA.setDuration(400L);
        this.gsA.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.ar.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (ar.this.gsy != null && valueAnimator != null) {
                    ar.this.gsy.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.gsA.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.ar.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (ar.this.gsy != null) {
                    ar.this.bFQ();
                    ar.this.gsy.setAlpha(1.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.aFH = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds56), 0.0f);
        this.aFH.setDuration(400L);
        this.aFH.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.ar.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                com.baidu.adp.lib.f.e.gx().postDelayed(ar.this.aFI, ar.this.gsz);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i) {
        if (viewGroup != null && view != null) {
            this.gsy = view;
            bFQ();
            viewGroup.addView(this.gsy, layoutParams);
            this.gsy.setVisibility(0);
            this.gsz = i;
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.aFI);
            com.baidu.adp.lib.f.e.gx().postDelayed(this.aFI, this.gsz);
        }
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup != null && view != null) {
            this.gsy = view;
            bFQ();
            viewGroup.addView(this.gsy, layoutParams);
            this.gsy.setVisibility(0);
        }
    }

    public void hideTip() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.aFI);
        if (this.gsy != null && this.gsy.getParent() != null && this.gsy.getVisibility() == 0 && !this.gsA.isRunning()) {
            this.gsA.start();
        }
    }

    public void bFQ() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.aFI);
        if (this.gsy != null) {
            if (this.gsA != null && this.gsA.isRunning()) {
                this.gsA.cancel();
            }
            this.gsy.clearAnimation();
            if (this.gsy.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.gsy.getParent()).removeView(this.gsy);
            }
            this.gsy.setVisibility(8);
        }
    }

    public void onDestroy() {
        bFQ();
    }
}
