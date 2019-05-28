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
    private TranslateAnimation mTipInAnimation;
    private View ftn = null;
    private int fto = 2000;
    private Runnable mHideTipRunnable = new Runnable() { // from class: com.baidu.tieba.frs.aq.1
        @Override // java.lang.Runnable
        public void run() {
            aq.this.hideTip();
        }
    };
    private ValueAnimator ftp = new ValueAnimator();

    public aq() {
        this.ftp.setFloatValues(1.0f, 0.0f);
        this.ftp.setDuration(400L);
        this.ftp.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.aq.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (aq.this.ftn != null && valueAnimator != null) {
                    aq.this.ftn.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.ftp.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.aq.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (aq.this.ftn != null) {
                    aq.this.blS();
                    aq.this.ftn.setAlpha(1.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.mTipInAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds56), 0.0f);
        this.mTipInAnimation.setDuration(400L);
        this.mTipInAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.aq.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                com.baidu.adp.lib.g.e.iB().postDelayed(aq.this.mHideTipRunnable, aq.this.fto);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i) {
        if (viewGroup != null && view != null) {
            this.ftn = view;
            blS();
            viewGroup.addView(this.ftn, layoutParams);
            this.ftn.setVisibility(0);
            this.fto = i;
            com.baidu.adp.lib.g.e.iB().removeCallbacks(this.mHideTipRunnable);
            com.baidu.adp.lib.g.e.iB().postDelayed(this.mHideTipRunnable, this.fto);
        }
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup != null && view != null) {
            this.ftn = view;
            blS();
            viewGroup.addView(this.ftn, layoutParams);
            this.ftn.setVisibility(0);
        }
    }

    public void hideTip() {
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.mHideTipRunnable);
        if (this.ftn != null && this.ftn.getParent() != null && this.ftn.getVisibility() == 0 && !this.ftp.isRunning()) {
            this.ftp.start();
        }
    }

    public void blS() {
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.mHideTipRunnable);
        if (this.ftn != null) {
            if (this.ftp != null && this.ftp.isRunning()) {
                this.ftp.cancel();
            }
            this.ftn.clearAnimation();
            if (this.ftn.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.ftn.getParent()).removeView(this.ftn);
            }
            this.ftn.setVisibility(8);
        }
    }

    public void onDestroy() {
        blS();
    }
}
