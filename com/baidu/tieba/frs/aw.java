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
    private View hrw = null;
    private int hrx = 2000;
    private Runnable bjk = new Runnable() { // from class: com.baidu.tieba.frs.aw.1
        @Override // java.lang.Runnable
        public void run() {
            aw.this.hideTip();
        }
    };
    private ValueAnimator hry = new ValueAnimator();

    public aw() {
        this.hry.setFloatValues(1.0f, 0.0f);
        this.hry.setDuration(400L);
        this.hry.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.aw.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (aw.this.hrw != null && valueAnimator != null) {
                    aw.this.hrw.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.hry.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.aw.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (aw.this.hrw != null) {
                    aw.this.bXb();
                    aw.this.hrw.setAlpha(1.0f);
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
                com.baidu.adp.lib.f.e.ld().postDelayed(aw.this.bjk, aw.this.hrx);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i) {
        if (viewGroup != null && view != null) {
            this.hrw = view;
            bXb();
            viewGroup.addView(this.hrw, layoutParams);
            this.hrw.setVisibility(0);
            this.hrx = i;
            com.baidu.adp.lib.f.e.ld().removeCallbacks(this.bjk);
            com.baidu.adp.lib.f.e.ld().postDelayed(this.bjk, this.hrx);
        }
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup != null && view != null) {
            this.hrw = view;
            bXb();
            viewGroup.addView(this.hrw, layoutParams);
            this.hrw.setVisibility(0);
        }
    }

    public void hideTip() {
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.bjk);
        if (this.hrw != null && this.hrw.getParent() != null && this.hrw.getVisibility() == 0 && !this.hry.isRunning()) {
            this.hry.start();
        }
    }

    public void bXb() {
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.bjk);
        if (this.hrw != null) {
            if (this.hry != null && this.hry.isRunning()) {
                this.hry.cancel();
            }
            this.hrw.clearAnimation();
            if (this.hrw.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.hrw.getParent()).removeView(this.hrw);
            }
            this.hrw.setVisibility(8);
        }
    }

    public void onDestroy() {
        bXb();
    }
}
