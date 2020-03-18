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
public class as {
    private TranslateAnimation aFX;
    private View gtr = null;
    private int gts = 2000;
    private Runnable aFY = new Runnable() { // from class: com.baidu.tieba.frs.as.1
        @Override // java.lang.Runnable
        public void run() {
            as.this.hideTip();
        }
    };
    private ValueAnimator gtt = new ValueAnimator();

    public as() {
        this.gtt.setFloatValues(1.0f, 0.0f);
        this.gtt.setDuration(400L);
        this.gtt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.as.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (as.this.gtr != null && valueAnimator != null) {
                    as.this.gtr.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.gtt.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.as.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (as.this.gtr != null) {
                    as.this.bGe();
                    as.this.gtr.setAlpha(1.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.aFX = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds56), 0.0f);
        this.aFX.setDuration(400L);
        this.aFX.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.as.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                com.baidu.adp.lib.f.e.gx().postDelayed(as.this.aFY, as.this.gts);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i) {
        if (viewGroup != null && view != null) {
            this.gtr = view;
            bGe();
            viewGroup.addView(this.gtr, layoutParams);
            this.gtr.setVisibility(0);
            this.gts = i;
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.aFY);
            com.baidu.adp.lib.f.e.gx().postDelayed(this.aFY, this.gts);
        }
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup != null && view != null) {
            this.gtr = view;
            bGe();
            viewGroup.addView(this.gtr, layoutParams);
            this.gtr.setVisibility(0);
        }
    }

    public void hideTip() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.aFY);
        if (this.gtr != null && this.gtr.getParent() != null && this.gtr.getVisibility() == 0 && !this.gtt.isRunning()) {
            this.gtt.start();
        }
    }

    public void bGe() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.aFY);
        if (this.gtr != null) {
            if (this.gtt != null && this.gtt.isRunning()) {
                this.gtt.cancel();
            }
            this.gtr.clearAnimation();
            if (this.gtr.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.gtr.getParent()).removeView(this.gtr);
            }
            this.gtr.setVisibility(8);
        }
    }

    public void onDestroy() {
        bGe();
    }
}
