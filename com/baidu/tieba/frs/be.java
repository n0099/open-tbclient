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
    private TranslateAnimation bQl;
    private View iXZ = null;
    private int iYa = 2000;
    private Runnable bQm = new Runnable() { // from class: com.baidu.tieba.frs.be.1
        @Override // java.lang.Runnable
        public void run() {
            be.this.hideTip();
        }
    };
    private ValueAnimator iYb = new ValueAnimator();

    public be() {
        this.iYb.setFloatValues(1.0f, 0.0f);
        this.iYb.setDuration(400L);
        this.iYb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.be.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (be.this.iXZ != null && valueAnimator != null) {
                    be.this.iXZ.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.iYb.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.be.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (be.this.iXZ != null) {
                    be.this.cEz();
                    be.this.iXZ.setAlpha(1.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.bQl = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds56), 0.0f);
        this.bQl.setDuration(400L);
        this.bQl.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.be.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                com.baidu.adp.lib.f.e.mY().postDelayed(be.this.bQm, be.this.iYa);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i) {
        if (viewGroup != null && view != null) {
            this.iXZ = view;
            cEz();
            viewGroup.addView(this.iXZ, layoutParams);
            this.iXZ.setVisibility(0);
            this.iYa = i;
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.bQm);
            com.baidu.adp.lib.f.e.mY().postDelayed(this.bQm, this.iYa);
        }
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup != null && view != null) {
            this.iXZ = view;
            cEz();
            viewGroup.addView(this.iXZ, layoutParams);
            this.iXZ.setVisibility(0);
        }
    }

    public void hideTip() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.bQm);
        if (this.iXZ != null && this.iXZ.getParent() != null && this.iXZ.getVisibility() == 0 && !this.iYb.isRunning()) {
            this.iYb.start();
        }
    }

    public void cEz() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.bQm);
        if (this.iXZ != null) {
            if (this.iYb != null && this.iYb.isRunning()) {
                this.iYb.cancel();
            }
            this.iXZ.clearAnimation();
            if (this.iXZ.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.iXZ.getParent()).removeView(this.iXZ);
            }
            this.iXZ.setVisibility(8);
        }
    }

    public void onDestroy() {
        cEz();
    }
}
