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
    private ValueAnimator hcE;
    private TextView hly;
    private Context mContext;
    private Runnable mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.g.3
        @Override // java.lang.Runnable
        public void run() {
            if (g.this.hly != null && g.this.hly.getParent() != null && g.this.hcE != null) {
                g.this.hcE.start();
            }
        }
    };
    private Handler mHandler = new Handler();

    public g(Context context) {
        this.mContext = context;
        bSw();
    }

    private void bSw() {
        this.hly = new TextView(this.mContext);
        this.hly.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(R.dimen.fontsize24));
        am.setBackgroundResource(this.hly, R.color.cp_link_tip_a);
        am.setViewTextColor(this.hly, (int) R.color.cp_cont_a);
        this.hly.setGravity(17);
        this.hly.setVisibility(0);
        this.hcE = new ValueAnimator();
        this.hcE.setFloatValues(1.0f, 0.0f);
        this.hcE.setDuration(400L);
        this.hcE.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.game.strategy.view.g.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (g.this.hly != null && valueAnimator != null) {
                    g.this.hly.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.hcE.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.game.strategy.view.g.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (g.this.hly != null) {
                    g.this.bQG();
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

    public void bQG() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.hcE != null) {
            this.hcE.cancel();
        }
        if (this.hly != null) {
            ViewParent parent = this.hly.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.hly);
            }
            this.hly.setVisibility(8);
            this.hly = null;
        }
    }

    public boolean isShowing() {
        return this.hly != null && this.hly.getVisibility() == 0;
    }

    public TextView bSx() {
        return this.hly;
    }

    public void bSy() {
        this.mHandler.removeCallbacks(this.mHideRunnable);
        this.mHandler.postDelayed(this.mHideRunnable, 2000L);
    }
}
