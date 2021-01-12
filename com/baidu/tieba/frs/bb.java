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
    private TranslateAnimation bQD;
    private View jfH = null;
    private int jfI = 2000;
    private Runnable bQE = new Runnable() { // from class: com.baidu.tieba.frs.bb.1
        @Override // java.lang.Runnable
        public void run() {
            bb.this.hideTip();
        }
    };
    private ValueAnimator jfJ = new ValueAnimator();

    public bb() {
        this.jfJ.setFloatValues(1.0f, 0.0f);
        this.jfJ.setDuration(400L);
        this.jfJ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.bb.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (bb.this.jfH != null && valueAnimator != null) {
                    bb.this.jfH.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.jfJ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.bb.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (bb.this.jfH != null) {
                    bb.this.cDE();
                    bb.this.jfH.setAlpha(1.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.bQD = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds56), 0.0f);
        this.bQD.setDuration(400L);
        this.bQD.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.bb.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                com.baidu.adp.lib.f.e.mB().postDelayed(bb.this.bQE, bb.this.jfI);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i) {
        if (viewGroup != null && view != null) {
            this.jfH = view;
            cDE();
            viewGroup.addView(this.jfH, layoutParams);
            this.jfH.setVisibility(0);
            this.jfI = i;
            com.baidu.adp.lib.f.e.mB().removeCallbacks(this.bQE);
            com.baidu.adp.lib.f.e.mB().postDelayed(this.bQE, this.jfI);
        }
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup != null && view != null) {
            this.jfH = view;
            cDE();
            viewGroup.addView(this.jfH, layoutParams);
            this.jfH.setVisibility(0);
        }
    }

    public void hideTip() {
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.bQE);
        if (this.jfH != null && this.jfH.getParent() != null && this.jfH.getVisibility() == 0 && !this.jfJ.isRunning()) {
            this.jfJ.start();
        }
    }

    public void cDE() {
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.bQE);
        if (this.jfH != null) {
            if (this.jfJ != null && this.jfJ.isRunning()) {
                this.jfJ.cancel();
            }
            this.jfH.clearAnimation();
            if (this.jfH.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.jfH.getParent()).removeView(this.jfH);
            }
            this.jfH.setVisibility(8);
        }
    }

    public void onDestroy() {
        cDE();
    }
}
