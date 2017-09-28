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
public class as {
    private TranslateAnimation ctO;
    private View ctL = null;
    private int ctM = 2000;
    private Runnable ctP = new Runnable() { // from class: com.baidu.tieba.frs.as.1
        @Override // java.lang.Runnable
        public void run() {
            as.this.hideTip();
        }
    };
    private ValueAnimator ctN = new ValueAnimator();

    public as() {
        this.ctN.setFloatValues(1.0f, 0.0f);
        this.ctN.setDuration(400L);
        this.ctN.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.as.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (as.this.ctL != null && valueAnimator != null) {
                    as.this.ctL.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.ctN.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.as.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (as.this.ctL != null) {
                    as.this.ain();
                    as.this.ctL.setAlpha(1.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.ctO = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.getInst().getResources().getDimension(d.f.ds56), 0.0f);
        this.ctO.setDuration(400L);
        this.ctO.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.as.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                com.baidu.adp.lib.g.e.fP().postDelayed(as.this.ctP, as.this.ctM);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i) {
        if (viewGroup != null && view != null) {
            this.ctL = view;
            ain();
            viewGroup.addView(this.ctL, layoutParams);
            this.ctL.setVisibility(0);
            this.ctM = i;
            com.baidu.adp.lib.g.e.fP().removeCallbacks(this.ctP);
            com.baidu.adp.lib.g.e.fP().postDelayed(this.ctP, this.ctM);
        }
    }

    public void hideTip() {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.ctP);
        if (this.ctL != null && this.ctL.getParent() != null && this.ctL.getVisibility() == 0 && !this.ctN.isRunning()) {
            this.ctN.start();
        }
    }

    public void ain() {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.ctP);
        if (this.ctL != null) {
            if (this.ctN != null && this.ctN.isRunning()) {
                this.ctN.cancel();
            }
            this.ctL.clearAnimation();
            if (this.ctL.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.ctL.getParent()).removeView(this.ctL);
            }
            this.ctL.setVisibility(8);
        }
    }

    public void onDestroy() {
        ain();
    }
}
