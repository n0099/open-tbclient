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
public class bb {
    private TranslateAnimation bVT;
    private View jnm = null;
    private int jnn = 2000;
    private Runnable bVU = new Runnable() { // from class: com.baidu.tieba.frs.bb.1
        @Override // java.lang.Runnable
        public void run() {
            bb.this.hideTip();
        }
    };
    private ValueAnimator jno = new ValueAnimator();

    public bb() {
        this.jno.setFloatValues(1.0f, 0.0f);
        this.jno.setDuration(400L);
        this.jno.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.bb.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (bb.this.jnm != null && valueAnimator != null) {
                    bb.this.jnm.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.jno.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.bb.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (bb.this.jnm != null) {
                    bb.this.cFd();
                    bb.this.jnm.setAlpha(1.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.bVT = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds56), 0.0f);
        this.bVT.setDuration(400L);
        this.bVT.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.bb.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                com.baidu.adp.lib.f.e.mA().postDelayed(bb.this.bVU, bb.this.jnn);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i) {
        if (viewGroup != null && view != null) {
            this.jnm = view;
            cFd();
            viewGroup.addView(this.jnm, layoutParams);
            this.jnm.setVisibility(0);
            this.jnn = i;
            com.baidu.adp.lib.f.e.mA().removeCallbacks(this.bVU);
            com.baidu.adp.lib.f.e.mA().postDelayed(this.bVU, this.jnn);
        }
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup != null && view != null) {
            this.jnm = view;
            cFd();
            viewGroup.addView(this.jnm, layoutParams);
            this.jnm.setVisibility(0);
        }
    }

    public void hideTip() {
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.bVU);
        if (this.jnm != null && this.jnm.getParent() != null && this.jnm.getVisibility() == 0 && !this.jno.isRunning()) {
            this.jno.start();
        }
    }

    public void cFd() {
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.bVU);
        if (this.jnm != null) {
            if (this.jno != null && this.jno.isRunning()) {
                this.jno.cancel();
            }
            this.jnm.clearAnimation();
            if (this.jnm.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.jnm.getParent()).removeView(this.jnm);
            }
            this.jnm.setVisibility(8);
        }
    }

    public void onDestroy() {
        cFd();
    }
}
