package com.baidu.tieba.frs.game.strategy.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class g {
    private ValueAnimator hEA;
    private TextView hOn;
    private Context mContext;
    private Runnable mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.g.3
        @Override // java.lang.Runnable
        public void run() {
            if (g.this.hOn != null && g.this.hOn.getParent() != null && g.this.hEA != null) {
                g.this.hEA.start();
            }
        }
    };
    private Handler mHandler = new Handler();

    public g(Context context) {
        this.mContext = context;
        cco();
    }

    private void cco() {
        this.hOn = new TextView(this.mContext);
        this.hOn.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(R.dimen.fontsize24));
        an.setBackgroundResource(this.hOn, R.color.cp_link_tip_a);
        an.setViewTextColor(this.hOn, (int) R.color.cp_cont_a);
        this.hOn.setGravity(17);
        this.hOn.setVisibility(0);
        this.hEA = new ValueAnimator();
        this.hEA.setFloatValues(1.0f, 0.0f);
        this.hEA.setDuration(400L);
        this.hEA.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.game.strategy.view.g.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (g.this.hOn != null && valueAnimator != null) {
                    g.this.hOn.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.hEA.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.game.strategy.view.g.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (g.this.hOn != null) {
                    g.this.cao();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
    }

    public void cao() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.hEA != null) {
            this.hEA.cancel();
        }
        if (this.hOn != null) {
            ViewParent parent = this.hOn.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.hOn);
            }
            this.hOn.setVisibility(8);
            this.hOn = null;
        }
    }

    public boolean isShowing() {
        return this.hOn != null && this.hOn.getVisibility() == 0;
    }

    public TextView ccp() {
        return this.hOn;
    }

    public void ccq() {
        this.mHandler.removeCallbacks(this.mHideRunnable);
        this.mHandler.postDelayed(this.mHideRunnable, 2000L);
    }
}
