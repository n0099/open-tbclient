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
public class bc {
    private TranslateAnimation boH;
    private View hKw = null;
    private int hKx = 2000;
    private Runnable boI = new Runnable() { // from class: com.baidu.tieba.frs.bc.1
        @Override // java.lang.Runnable
        public void run() {
            bc.this.hideTip();
        }
    };
    private ValueAnimator hKy = new ValueAnimator();

    public bc() {
        this.hKy.setFloatValues(1.0f, 0.0f);
        this.hKy.setDuration(400L);
        this.hKy.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.bc.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (bc.this.hKw != null && valueAnimator != null) {
                    bc.this.hKw.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.hKy.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.bc.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (bc.this.hKw != null) {
                    bc.this.cdN();
                    bc.this.hKw.setAlpha(1.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.boH = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds56), 0.0f);
        this.boH.setDuration(400L);
        this.boH.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.bc.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                com.baidu.adp.lib.f.e.lt().postDelayed(bc.this.boI, bc.this.hKx);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i) {
        if (viewGroup != null && view != null) {
            this.hKw = view;
            cdN();
            viewGroup.addView(this.hKw, layoutParams);
            this.hKw.setVisibility(0);
            this.hKx = i;
            com.baidu.adp.lib.f.e.lt().removeCallbacks(this.boI);
            com.baidu.adp.lib.f.e.lt().postDelayed(this.boI, this.hKx);
        }
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup != null && view != null) {
            this.hKw = view;
            cdN();
            viewGroup.addView(this.hKw, layoutParams);
            this.hKw.setVisibility(0);
        }
    }

    public void hideTip() {
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.boI);
        if (this.hKw != null && this.hKw.getParent() != null && this.hKw.getVisibility() == 0 && !this.hKy.isRunning()) {
            this.hKy.start();
        }
    }

    public void cdN() {
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.boI);
        if (this.hKw != null) {
            if (this.hKy != null && this.hKy.isRunning()) {
                this.hKy.cancel();
            }
            this.hKw.clearAnimation();
            if (this.hKw.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.hKw.getParent()).removeView(this.hKw);
            }
            this.hKw.setVisibility(8);
        }
    }

    public void onDestroy() {
        cdN();
    }
}
