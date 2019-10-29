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
    private TranslateAnimation atd;
    private View fzJ = null;
    private int fzK = 2000;
    private Runnable ate = new Runnable() { // from class: com.baidu.tieba.frs.aq.1
        @Override // java.lang.Runnable
        public void run() {
            aq.this.hideTip();
        }
    };
    private ValueAnimator fzL = new ValueAnimator();

    public aq() {
        this.fzL.setFloatValues(1.0f, 0.0f);
        this.fzL.setDuration(400L);
        this.fzL.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.aq.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (aq.this.fzJ != null && valueAnimator != null) {
                    aq.this.fzJ.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.fzL.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.aq.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (aq.this.fzJ != null) {
                    aq.this.blS();
                    aq.this.fzJ.setAlpha(1.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.atd = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds56), 0.0f);
        this.atd.setDuration(400L);
        this.atd.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.aq.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                com.baidu.adp.lib.g.e.fZ().postDelayed(aq.this.ate, aq.this.fzK);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i) {
        if (viewGroup != null && view != null) {
            this.fzJ = view;
            blS();
            viewGroup.addView(this.fzJ, layoutParams);
            this.fzJ.setVisibility(0);
            this.fzK = i;
            com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.ate);
            com.baidu.adp.lib.g.e.fZ().postDelayed(this.ate, this.fzK);
        }
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup != null && view != null) {
            this.fzJ = view;
            blS();
            viewGroup.addView(this.fzJ, layoutParams);
            this.fzJ.setVisibility(0);
        }
    }

    public void hideTip() {
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.ate);
        if (this.fzJ != null && this.fzJ.getParent() != null && this.fzJ.getVisibility() == 0 && !this.fzL.isRunning()) {
            this.fzL.start();
        }
    }

    public void blS() {
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.ate);
        if (this.fzJ != null) {
            if (this.fzL != null && this.fzL.isRunning()) {
                this.fzL.cancel();
            }
            this.fzJ.clearAnimation();
            if (this.fzJ.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.fzJ.getParent()).removeView(this.fzJ);
            }
            this.fzJ.setVisibility(8);
        }
    }

    public void onDestroy() {
        blS();
    }
}
