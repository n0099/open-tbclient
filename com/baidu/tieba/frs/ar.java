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
    private TranslateAnimation aFJ;
    private View gsN = null;
    private int gsO = 2000;
    private Runnable aFK = new Runnable() { // from class: com.baidu.tieba.frs.ar.1
        @Override // java.lang.Runnable
        public void run() {
            ar.this.hideTip();
        }
    };
    private ValueAnimator gsP = new ValueAnimator();

    public ar() {
        this.gsP.setFloatValues(1.0f, 0.0f);
        this.gsP.setDuration(400L);
        this.gsP.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.ar.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (ar.this.gsN != null && valueAnimator != null) {
                    ar.this.gsN.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.gsP.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.ar.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (ar.this.gsN != null) {
                    ar.this.bFT();
                    ar.this.gsN.setAlpha(1.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.aFJ = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds56), 0.0f);
        this.aFJ.setDuration(400L);
        this.aFJ.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.ar.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                com.baidu.adp.lib.f.e.gx().postDelayed(ar.this.aFK, ar.this.gsO);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i) {
        if (viewGroup != null && view != null) {
            this.gsN = view;
            bFT();
            viewGroup.addView(this.gsN, layoutParams);
            this.gsN.setVisibility(0);
            this.gsO = i;
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.aFK);
            com.baidu.adp.lib.f.e.gx().postDelayed(this.aFK, this.gsO);
        }
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup != null && view != null) {
            this.gsN = view;
            bFT();
            viewGroup.addView(this.gsN, layoutParams);
            this.gsN.setVisibility(0);
        }
    }

    public void hideTip() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.aFK);
        if (this.gsN != null && this.gsN.getParent() != null && this.gsN.getVisibility() == 0 && !this.gsP.isRunning()) {
            this.gsP.start();
        }
    }

    public void bFT() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.aFK);
        if (this.gsN != null) {
            if (this.gsP != null && this.gsP.isRunning()) {
                this.gsP.cancel();
            }
            this.gsN.clearAnimation();
            if (this.gsN.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.gsN.getParent()).removeView(this.gsN);
            }
            this.gsN.setVisibility(8);
        }
    }

    public void onDestroy() {
        bFT();
    }
}
