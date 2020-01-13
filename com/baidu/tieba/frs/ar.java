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
    private TranslateAnimation aBr;
    private View gqx = null;
    private int gqy = 2000;
    private Runnable aBs = new Runnable() { // from class: com.baidu.tieba.frs.ar.1
        @Override // java.lang.Runnable
        public void run() {
            ar.this.hideTip();
        }
    };
    private ValueAnimator gqz = new ValueAnimator();

    public ar() {
        this.gqz.setFloatValues(1.0f, 0.0f);
        this.gqz.setDuration(400L);
        this.gqz.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.ar.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (ar.this.gqx != null && valueAnimator != null) {
                    ar.this.gqx.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.gqz.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.ar.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (ar.this.gqx != null) {
                    ar.this.bEo();
                    ar.this.gqx.setAlpha(1.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.aBr = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds56), 0.0f);
        this.aBr.setDuration(400L);
        this.aBr.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.ar.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                com.baidu.adp.lib.f.e.gx().postDelayed(ar.this.aBs, ar.this.gqy);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i) {
        if (viewGroup != null && view != null) {
            this.gqx = view;
            bEo();
            viewGroup.addView(this.gqx, layoutParams);
            this.gqx.setVisibility(0);
            this.gqy = i;
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.aBs);
            com.baidu.adp.lib.f.e.gx().postDelayed(this.aBs, this.gqy);
        }
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup != null && view != null) {
            this.gqx = view;
            bEo();
            viewGroup.addView(this.gqx, layoutParams);
            this.gqx.setVisibility(0);
        }
    }

    public void hideTip() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.aBs);
        if (this.gqx != null && this.gqx.getParent() != null && this.gqx.getVisibility() == 0 && !this.gqz.isRunning()) {
            this.gqz.start();
        }
    }

    public void bEo() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.aBs);
        if (this.gqx != null) {
            if (this.gqz != null && this.gqz.isRunning()) {
                this.gqz.cancel();
            }
            this.gqx.clearAnimation();
            if (this.gqx.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.gqx.getParent()).removeView(this.gqx);
            }
            this.gqx.setVisibility(8);
        }
    }

    public void onDestroy() {
        bEo();
    }
}
