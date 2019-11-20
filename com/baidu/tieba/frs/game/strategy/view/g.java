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
/* loaded from: classes4.dex */
public class g {
    private TextView fHn;
    private ValueAnimator fyU;
    private Context mContext;
    private Runnable mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.g.3
        @Override // java.lang.Runnable
        public void run() {
            if (g.this.fHn != null && g.this.fHn.getParent() != null && g.this.fyU != null) {
                g.this.fyU.start();
            }
        }
    };
    private Handler mHandler = new Handler();

    public g(Context context) {
        this.mContext = context;
        bnH();
    }

    private void bnH() {
        this.fHn = new TextView(this.mContext);
        this.fHn.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(R.dimen.fontsize24));
        am.setBackgroundResource(this.fHn, R.color.cp_link_tip_a);
        am.setViewTextColor(this.fHn, (int) R.color.cp_cont_a);
        this.fHn.setGravity(17);
        this.fHn.setVisibility(0);
        this.fyU = new ValueAnimator();
        this.fyU.setFloatValues(1.0f, 0.0f);
        this.fyU.setDuration(400L);
        this.fyU.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.game.strategy.view.g.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (g.this.fHn != null && valueAnimator != null) {
                    g.this.fHn.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.fyU.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.game.strategy.view.g.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (g.this.fHn != null) {
                    g.this.blQ();
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

    public void blQ() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.fyU != null) {
            this.fyU.cancel();
        }
        if (this.fHn != null) {
            ViewParent parent = this.fHn.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.fHn);
            }
            this.fHn.setVisibility(8);
            this.fHn = null;
        }
    }

    public boolean isShowing() {
        return this.fHn != null && this.fHn.getVisibility() == 0;
    }

    public TextView bnI() {
        return this.fHn;
    }

    public void bnJ() {
        this.mHandler.removeCallbacks(this.mHideRunnable);
        this.mHandler.postDelayed(this.mHideRunnable, 2000L);
    }
}
