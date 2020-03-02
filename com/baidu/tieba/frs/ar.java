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
    private TranslateAnimation aFI;
    private View gsA = null;
    private int gsB = 2000;
    private Runnable aFJ = new Runnable() { // from class: com.baidu.tieba.frs.ar.1
        @Override // java.lang.Runnable
        public void run() {
            ar.this.hideTip();
        }
    };
    private ValueAnimator gsC = new ValueAnimator();

    public ar() {
        this.gsC.setFloatValues(1.0f, 0.0f);
        this.gsC.setDuration(400L);
        this.gsC.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.ar.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (ar.this.gsA != null && valueAnimator != null) {
                    ar.this.gsA.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.gsC.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.ar.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (ar.this.gsA != null) {
                    ar.this.bFS();
                    ar.this.gsA.setAlpha(1.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.aFI = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds56), 0.0f);
        this.aFI.setDuration(400L);
        this.aFI.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.ar.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                com.baidu.adp.lib.f.e.gx().postDelayed(ar.this.aFJ, ar.this.gsB);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i) {
        if (viewGroup != null && view != null) {
            this.gsA = view;
            bFS();
            viewGroup.addView(this.gsA, layoutParams);
            this.gsA.setVisibility(0);
            this.gsB = i;
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.aFJ);
            com.baidu.adp.lib.f.e.gx().postDelayed(this.aFJ, this.gsB);
        }
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup != null && view != null) {
            this.gsA = view;
            bFS();
            viewGroup.addView(this.gsA, layoutParams);
            this.gsA.setVisibility(0);
        }
    }

    public void hideTip() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.aFJ);
        if (this.gsA != null && this.gsA.getParent() != null && this.gsA.getVisibility() == 0 && !this.gsC.isRunning()) {
            this.gsC.start();
        }
    }

    public void bFS() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.aFJ);
        if (this.gsA != null) {
            if (this.gsC != null && this.gsC.isRunning()) {
                this.gsC.cancel();
            }
            this.gsA.clearAnimation();
            if (this.gsA.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.gsA.getParent()).removeView(this.gsA);
            }
            this.gsA.setVisibility(8);
        }
    }

    public void onDestroy() {
        bFS();
    }
}
