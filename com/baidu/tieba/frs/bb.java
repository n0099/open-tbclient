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
    private TranslateAnimation bUt;
    private View jlC = null;
    private int jlD = 2000;
    private Runnable bUu = new Runnable() { // from class: com.baidu.tieba.frs.bb.1
        @Override // java.lang.Runnable
        public void run() {
            bb.this.hideTip();
        }
    };
    private ValueAnimator jlE = new ValueAnimator();

    public bb() {
        this.jlE.setFloatValues(1.0f, 0.0f);
        this.jlE.setDuration(400L);
        this.jlE.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.bb.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (bb.this.jlC != null && valueAnimator != null) {
                    bb.this.jlC.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.jlE.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.bb.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (bb.this.jlC != null) {
                    bb.this.cEX();
                    bb.this.jlC.setAlpha(1.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.bUt = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds56), 0.0f);
        this.bUt.setDuration(400L);
        this.bUt.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.bb.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                com.baidu.adp.lib.f.e.mA().postDelayed(bb.this.bUu, bb.this.jlD);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i) {
        if (viewGroup != null && view != null) {
            this.jlC = view;
            cEX();
            viewGroup.addView(this.jlC, layoutParams);
            this.jlC.setVisibility(0);
            this.jlD = i;
            com.baidu.adp.lib.f.e.mA().removeCallbacks(this.bUu);
            com.baidu.adp.lib.f.e.mA().postDelayed(this.bUu, this.jlD);
        }
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup != null && view != null) {
            this.jlC = view;
            cEX();
            viewGroup.addView(this.jlC, layoutParams);
            this.jlC.setVisibility(0);
        }
    }

    public void hideTip() {
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.bUu);
        if (this.jlC != null && this.jlC.getParent() != null && this.jlC.getVisibility() == 0 && !this.jlE.isRunning()) {
            this.jlE.start();
        }
    }

    public void cEX() {
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.bUu);
        if (this.jlC != null) {
            if (this.jlE != null && this.jlE.isRunning()) {
                this.jlE.cancel();
            }
            this.jlC.clearAnimation();
            if (this.jlC.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.jlC.getParent()).removeView(this.jlC);
            }
            this.jlC.setVisibility(8);
        }
    }

    public void onDestroy() {
        cEX();
    }
}
