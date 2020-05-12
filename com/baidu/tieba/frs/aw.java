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
public class aw {
    private TranslateAnimation bbJ;
    private View hcI = null;
    private int hcJ = 2000;
    private Runnable bbK = new Runnable() { // from class: com.baidu.tieba.frs.aw.1
        @Override // java.lang.Runnable
        public void run() {
            aw.this.hideTip();
        }
    };
    private ValueAnimator hcK = new ValueAnimator();

    public aw() {
        this.hcK.setFloatValues(1.0f, 0.0f);
        this.hcK.setDuration(400L);
        this.hcK.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.aw.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (aw.this.hcI != null && valueAnimator != null) {
                    aw.this.hcI.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.hcK.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.aw.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (aw.this.hcI != null) {
                    aw.this.bQF();
                    aw.this.hcI.setAlpha(1.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.bbJ = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds56), 0.0f);
        this.bbJ.setDuration(400L);
        this.bbJ.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.aw.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                com.baidu.adp.lib.f.e.lb().postDelayed(aw.this.bbK, aw.this.hcJ);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i) {
        if (viewGroup != null && view != null) {
            this.hcI = view;
            bQF();
            viewGroup.addView(this.hcI, layoutParams);
            this.hcI.setVisibility(0);
            this.hcJ = i;
            com.baidu.adp.lib.f.e.lb().removeCallbacks(this.bbK);
            com.baidu.adp.lib.f.e.lb().postDelayed(this.bbK, this.hcJ);
        }
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup != null && view != null) {
            this.hcI = view;
            bQF();
            viewGroup.addView(this.hcI, layoutParams);
            this.hcI.setVisibility(0);
        }
    }

    public void hideTip() {
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.bbK);
        if (this.hcI != null && this.hcI.getParent() != null && this.hcI.getVisibility() == 0 && !this.hcK.isRunning()) {
            this.hcK.start();
        }
    }

    public void bQF() {
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.bbK);
        if (this.hcI != null) {
            if (this.hcK != null && this.hcK.isRunning()) {
                this.hcK.cancel();
            }
            this.hcI.clearAnimation();
            if (this.hcI.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.hcI.getParent()).removeView(this.hcI);
            }
            this.hcI.setVisibility(8);
        }
    }

    public void onDestroy() {
        bQF();
    }
}
