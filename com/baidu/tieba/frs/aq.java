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
public class aq {
    private TranslateAnimation asL;
    private View fyS = null;
    private int fyT = 2000;
    private Runnable asM = new Runnable() { // from class: com.baidu.tieba.frs.aq.1
        @Override // java.lang.Runnable
        public void run() {
            aq.this.hideTip();
        }
    };
    private ValueAnimator fyU = new ValueAnimator();

    public aq() {
        this.fyU.setFloatValues(1.0f, 0.0f);
        this.fyU.setDuration(400L);
        this.fyU.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.aq.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (aq.this.fyS != null && valueAnimator != null) {
                    aq.this.fyS.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.fyU.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.aq.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (aq.this.fyS != null) {
                    aq.this.blQ();
                    aq.this.fyS.setAlpha(1.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.asL = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds56), 0.0f);
        this.asL.setDuration(400L);
        this.asL.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.aq.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                com.baidu.adp.lib.g.e.fZ().postDelayed(aq.this.asM, aq.this.fyT);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i) {
        if (viewGroup != null && view != null) {
            this.fyS = view;
            blQ();
            viewGroup.addView(this.fyS, layoutParams);
            this.fyS.setVisibility(0);
            this.fyT = i;
            com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.asM);
            com.baidu.adp.lib.g.e.fZ().postDelayed(this.asM, this.fyT);
        }
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup != null && view != null) {
            this.fyS = view;
            blQ();
            viewGroup.addView(this.fyS, layoutParams);
            this.fyS.setVisibility(0);
        }
    }

    public void hideTip() {
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.asM);
        if (this.fyS != null && this.fyS.getParent() != null && this.fyS.getVisibility() == 0 && !this.fyU.isRunning()) {
            this.fyU.start();
        }
    }

    public void blQ() {
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.asM);
        if (this.fyS != null) {
            if (this.fyU != null && this.fyU.isRunning()) {
                this.fyU.cancel();
            }
            this.fyS.clearAnimation();
            if (this.fyS.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.fyS.getParent()).removeView(this.fyS);
            }
            this.fyS.setVisibility(8);
        }
    }

    public void onDestroy() {
        blQ();
    }
}
