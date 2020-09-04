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
public class be {
    private TranslateAnimation bux;
    private View hYb = null;
    private int hYc = 2000;
    private Runnable buy = new Runnable() { // from class: com.baidu.tieba.frs.be.1
        @Override // java.lang.Runnable
        public void run() {
            be.this.hideTip();
        }
    };
    private ValueAnimator hYd = new ValueAnimator();

    public be() {
        this.hYd.setFloatValues(1.0f, 0.0f);
        this.hYd.setDuration(400L);
        this.hYd.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.be.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (be.this.hYb != null && valueAnimator != null) {
                    be.this.hYb.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.hYd.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.be.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (be.this.hYb != null) {
                    be.this.con();
                    be.this.hYb.setAlpha(1.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.bux = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds56), 0.0f);
        this.bux.setDuration(400L);
        this.bux.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.be.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                com.baidu.adp.lib.f.e.mS().postDelayed(be.this.buy, be.this.hYc);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i) {
        if (viewGroup != null && view != null) {
            this.hYb = view;
            con();
            viewGroup.addView(this.hYb, layoutParams);
            this.hYb.setVisibility(0);
            this.hYc = i;
            com.baidu.adp.lib.f.e.mS().removeCallbacks(this.buy);
            com.baidu.adp.lib.f.e.mS().postDelayed(this.buy, this.hYc);
        }
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup != null && view != null) {
            this.hYb = view;
            con();
            viewGroup.addView(this.hYb, layoutParams);
            this.hYb.setVisibility(0);
        }
    }

    public void hideTip() {
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.buy);
        if (this.hYb != null && this.hYb.getParent() != null && this.hYb.getVisibility() == 0 && !this.hYd.isRunning()) {
            this.hYd.start();
        }
    }

    public void con() {
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.buy);
        if (this.hYb != null) {
            if (this.hYd != null && this.hYd.isRunning()) {
                this.hYd.cancel();
            }
            this.hYb.clearAnimation();
            if (this.hYb.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.hYb.getParent()).removeView(this.hYb);
            }
            this.hYb.setVisibility(8);
        }
    }

    public void onDestroy() {
        con();
    }
}
