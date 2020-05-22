package com.baidu.tieba.frs.game.strategy.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class g {
    private TextView hAs;
    private ValueAnimator hry;
    private Context mContext;
    private Runnable mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.g.3
        @Override // java.lang.Runnable
        public void run() {
            if (g.this.hAs != null && g.this.hAs.getParent() != null && g.this.hry != null) {
                g.this.hry.start();
            }
        }
    };
    private Handler mHandler = new Handler();

    public g(Context context) {
        this.mContext = context;
        bYQ();
    }

    private void bYQ() {
        this.hAs = new TextView(this.mContext);
        this.hAs.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(R.dimen.fontsize24));
        am.setBackgroundResource(this.hAs, R.color.cp_link_tip_a);
        am.setViewTextColor(this.hAs, (int) R.color.cp_cont_a);
        this.hAs.setGravity(17);
        this.hAs.setVisibility(0);
        this.hry = new ValueAnimator();
        this.hry.setFloatValues(1.0f, 0.0f);
        this.hry.setDuration(400L);
        this.hry.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.game.strategy.view.g.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (g.this.hAs != null && valueAnimator != null) {
                    g.this.hAs.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.hry.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.game.strategy.view.g.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (g.this.hAs != null) {
                    g.this.bXb();
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

    public void bXb() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.hry != null) {
            this.hry.cancel();
        }
        if (this.hAs != null) {
            ViewParent parent = this.hAs.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.hAs);
            }
            this.hAs.setVisibility(8);
            this.hAs = null;
        }
    }

    public boolean isShowing() {
        return this.hAs != null && this.hAs.getVisibility() == 0;
    }

    public TextView bYR() {
        return this.hAs;
    }

    public void bYS() {
        this.mHandler.removeCallbacks(this.mHideRunnable);
        this.mHandler.postDelayed(this.mHideRunnable, 2000L);
    }
}
