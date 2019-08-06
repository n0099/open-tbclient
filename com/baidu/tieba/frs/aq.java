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
    private View fyI = null;
    private int fyJ = 2000;
    private Runnable mHideTipRunnable = new Runnable() { // from class: com.baidu.tieba.frs.aq.1
        @Override // java.lang.Runnable
        public void run() {
            aq.this.hideTip();
        }
    };
    private ValueAnimator fyK = new ValueAnimator();

    public aq() {
        this.fyK.setFloatValues(1.0f, 0.0f);
        this.fyK.setDuration(400L);
        this.fyK.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.aq.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (aq.this.fyI != null && valueAnimator != null) {
                    aq.this.fyI.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.fyK.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.aq.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (aq.this.fyI != null) {
                    aq.this.bod();
                    aq.this.fyI.setAlpha(1.0f);
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
                com.baidu.adp.lib.g.e.iK().postDelayed(aq.this.mHideTipRunnable, aq.this.fyJ);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i) {
        if (viewGroup != null && view != null) {
            this.fyI = view;
            bod();
            viewGroup.addView(this.fyI, layoutParams);
            this.fyI.setVisibility(0);
            this.fyJ = i;
            com.baidu.adp.lib.g.e.iK().removeCallbacks(this.mHideTipRunnable);
            com.baidu.adp.lib.g.e.iK().postDelayed(this.mHideTipRunnable, this.fyJ);
        }
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup != null && view != null) {
            this.fyI = view;
            bod();
            viewGroup.addView(this.fyI, layoutParams);
            this.fyI.setVisibility(0);
        }
    }

    public void hideTip() {
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.mHideTipRunnable);
        if (this.fyI != null && this.fyI.getParent() != null && this.fyI.getVisibility() == 0 && !this.fyK.isRunning()) {
            this.fyK.start();
        }
    }

    public void bod() {
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.mHideTipRunnable);
        if (this.fyI != null) {
            if (this.fyK != null && this.fyK.isRunning()) {
                this.fyK.cancel();
            }
            this.fyI.clearAnimation();
            if (this.fyI.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.fyI.getParent()).removeView(this.fyI);
            }
            this.fyI.setVisibility(8);
        }
    }

    public void onDestroy() {
        bod();
    }
}
