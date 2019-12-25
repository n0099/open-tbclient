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
public class ar {
    private TranslateAnimation aAH;
    private View gno = null;
    private int gnp = 2000;
    private Runnable aAI = new Runnable() { // from class: com.baidu.tieba.frs.ar.1
        @Override // java.lang.Runnable
        public void run() {
            ar.this.hideTip();
        }
    };
    private ValueAnimator gnq = new ValueAnimator();

    public ar() {
        this.gnq.setFloatValues(1.0f, 0.0f);
        this.gnq.setDuration(400L);
        this.gnq.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.ar.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (ar.this.gno != null && valueAnimator != null) {
                    ar.this.gno.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.gnq.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.ar.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (ar.this.gno != null) {
                    ar.this.bDm();
                    ar.this.gno.setAlpha(1.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.aAH = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds56), 0.0f);
        this.aAH.setDuration(400L);
        this.aAH.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.ar.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                com.baidu.adp.lib.f.e.gy().postDelayed(ar.this.aAI, ar.this.gnp);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i) {
        if (viewGroup != null && view != null) {
            this.gno = view;
            bDm();
            viewGroup.addView(this.gno, layoutParams);
            this.gno.setVisibility(0);
            this.gnp = i;
            com.baidu.adp.lib.f.e.gy().removeCallbacks(this.aAI);
            com.baidu.adp.lib.f.e.gy().postDelayed(this.aAI, this.gnp);
        }
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup != null && view != null) {
            this.gno = view;
            bDm();
            viewGroup.addView(this.gno, layoutParams);
            this.gno.setVisibility(0);
        }
    }

    public void hideTip() {
        com.baidu.adp.lib.f.e.gy().removeCallbacks(this.aAI);
        if (this.gno != null && this.gno.getParent() != null && this.gno.getVisibility() == 0 && !this.gnq.isRunning()) {
            this.gnq.start();
        }
    }

    public void bDm() {
        com.baidu.adp.lib.f.e.gy().removeCallbacks(this.aAI);
        if (this.gno != null) {
            if (this.gnq != null && this.gnq.isRunning()) {
                this.gnq.cancel();
            }
            this.gno.clearAnimation();
            if (this.gno.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.gno.getParent()).removeView(this.gno);
            }
            this.gno.setVisibility(8);
        }
    }

    public void onDestroy() {
        bDm();
    }
}
