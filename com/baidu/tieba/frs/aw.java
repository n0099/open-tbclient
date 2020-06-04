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
    private TranslateAnimation bjj;
    private View hrH = null;
    private int hrI = 2000;
    private Runnable bjk = new Runnable() { // from class: com.baidu.tieba.frs.aw.1
        @Override // java.lang.Runnable
        public void run() {
            aw.this.hideTip();
        }
    };
    private ValueAnimator hrJ = new ValueAnimator();

    public aw() {
        this.hrJ.setFloatValues(1.0f, 0.0f);
        this.hrJ.setDuration(400L);
        this.hrJ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.aw.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (aw.this.hrH != null && valueAnimator != null) {
                    aw.this.hrH.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.hrJ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.aw.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (aw.this.hrH != null) {
                    aw.this.bXd();
                    aw.this.hrH.setAlpha(1.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.bjj = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds56), 0.0f);
        this.bjj.setDuration(400L);
        this.bjj.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.aw.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                com.baidu.adp.lib.f.e.ld().postDelayed(aw.this.bjk, aw.this.hrI);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i) {
        if (viewGroup != null && view != null) {
            this.hrH = view;
            bXd();
            viewGroup.addView(this.hrH, layoutParams);
            this.hrH.setVisibility(0);
            this.hrI = i;
            com.baidu.adp.lib.f.e.ld().removeCallbacks(this.bjk);
            com.baidu.adp.lib.f.e.ld().postDelayed(this.bjk, this.hrI);
        }
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup != null && view != null) {
            this.hrH = view;
            bXd();
            viewGroup.addView(this.hrH, layoutParams);
            this.hrH.setVisibility(0);
        }
    }

    public void hideTip() {
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.bjk);
        if (this.hrH != null && this.hrH.getParent() != null && this.hrH.getVisibility() == 0 && !this.hrJ.isRunning()) {
            this.hrJ.start();
        }
    }

    public void bXd() {
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.bjk);
        if (this.hrH != null) {
            if (this.hrJ != null && this.hrJ.isRunning()) {
                this.hrJ.cancel();
            }
            this.hrH.clearAnimation();
            if (this.hrH.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.hrH.getParent()).removeView(this.hrH);
            }
            this.hrH.setVisibility(8);
        }
    }

    public void onDestroy() {
        bXd();
    }
}
