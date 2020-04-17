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
public class aw {
    private TranslateAnimation bbE;
    private View hcC = null;
    private int hcD = 2000;
    private Runnable bbF = new Runnable() { // from class: com.baidu.tieba.frs.aw.1
        @Override // java.lang.Runnable
        public void run() {
            aw.this.hideTip();
        }
    };
    private ValueAnimator hcE = new ValueAnimator();

    public aw() {
        this.hcE.setFloatValues(1.0f, 0.0f);
        this.hcE.setDuration(400L);
        this.hcE.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.aw.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (aw.this.hcC != null && valueAnimator != null) {
                    aw.this.hcC.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.hcE.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.aw.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (aw.this.hcC != null) {
                    aw.this.bQG();
                    aw.this.hcC.setAlpha(1.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.bbE = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds56), 0.0f);
        this.bbE.setDuration(400L);
        this.bbE.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.aw.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                com.baidu.adp.lib.f.e.lb().postDelayed(aw.this.bbF, aw.this.hcD);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i) {
        if (viewGroup != null && view != null) {
            this.hcC = view;
            bQG();
            viewGroup.addView(this.hcC, layoutParams);
            this.hcC.setVisibility(0);
            this.hcD = i;
            com.baidu.adp.lib.f.e.lb().removeCallbacks(this.bbF);
            com.baidu.adp.lib.f.e.lb().postDelayed(this.bbF, this.hcD);
        }
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup != null && view != null) {
            this.hcC = view;
            bQG();
            viewGroup.addView(this.hcC, layoutParams);
            this.hcC.setVisibility(0);
        }
    }

    public void hideTip() {
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.bbF);
        if (this.hcC != null && this.hcC.getParent() != null && this.hcC.getVisibility() == 0 && !this.hcE.isRunning()) {
            this.hcE.start();
        }
    }

    public void bQG() {
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.bbF);
        if (this.hcC != null) {
            if (this.hcE != null && this.hcE.isRunning()) {
                this.hcE.cancel();
            }
            this.hcC.clearAnimation();
            if (this.hcC.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.hcC.getParent()).removeView(this.hcC);
            }
            this.hcC.setVisibility(8);
        }
    }

    public void onDestroy() {
        bQG();
    }
}
