package com.baidu.tieba.frs.game.strategy.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class g {
    private ValueAnimator hYd;
    private TextView iiB;
    private Context mContext;
    private Runnable mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.g.3
        @Override // java.lang.Runnable
        public void run() {
            if (g.this.iiB != null && g.this.iiB.getParent() != null && g.this.hYd != null) {
                g.this.hYd.start();
            }
        }
    };
    private Handler mHandler = new Handler();

    public g(Context context) {
        this.mContext = context;
        cqt();
    }

    private void cqt() {
        this.iiB = new TextView(this.mContext);
        this.iiB.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(R.dimen.fontsize24));
        ap.setBackgroundResource(this.iiB, R.color.cp_link_tip_a);
        ap.setViewTextColor(this.iiB, (int) R.color.cp_cont_a);
        this.iiB.setGravity(17);
        this.iiB.setVisibility(0);
        this.hYd = new ValueAnimator();
        this.hYd.setFloatValues(1.0f, 0.0f);
        this.hYd.setDuration(400L);
        this.hYd.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.game.strategy.view.g.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (g.this.iiB != null && valueAnimator != null) {
                    g.this.iiB.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.hYd.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.game.strategy.view.g.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (g.this.iiB != null) {
                    g.this.con();
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

    public void con() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.hYd != null) {
            this.hYd.cancel();
        }
        if (this.iiB != null) {
            ViewParent parent = this.iiB.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.iiB);
            }
            this.iiB.setVisibility(8);
            this.iiB = null;
        }
    }

    public boolean isShowing() {
        return this.iiB != null && this.iiB.getVisibility() == 0;
    }

    public TextView cqu() {
        return this.iiB;
    }

    public void cqv() {
        this.mHandler.removeCallbacks(this.mHideRunnable);
        this.mHandler.postDelayed(this.mHideRunnable, 2000L);
    }
}
