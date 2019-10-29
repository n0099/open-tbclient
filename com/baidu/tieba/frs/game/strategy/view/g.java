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
    private TextView fIe;
    private ValueAnimator fzL;
    private Context mContext;
    private Runnable mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.g.3
        @Override // java.lang.Runnable
        public void run() {
            if (g.this.fIe != null && g.this.fIe.getParent() != null && g.this.fzL != null) {
                g.this.fzL.start();
            }
        }
    };
    private Handler mHandler = new Handler();

    public g(Context context) {
        this.mContext = context;
        bnJ();
    }

    private void bnJ() {
        this.fIe = new TextView(this.mContext);
        this.fIe.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(R.dimen.fontsize24));
        am.setBackgroundResource(this.fIe, R.color.cp_link_tip_a);
        am.setViewTextColor(this.fIe, (int) R.color.cp_cont_a);
        this.fIe.setGravity(17);
        this.fIe.setVisibility(0);
        this.fzL = new ValueAnimator();
        this.fzL.setFloatValues(1.0f, 0.0f);
        this.fzL.setDuration(400L);
        this.fzL.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.game.strategy.view.g.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (g.this.fIe != null && valueAnimator != null) {
                    g.this.fIe.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.fzL.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.game.strategy.view.g.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (g.this.fIe != null) {
                    g.this.blS();
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

    public void blS() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.fzL != null) {
            this.fzL.cancel();
        }
        if (this.fIe != null) {
            ViewParent parent = this.fIe.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.fIe);
            }
            this.fIe.setVisibility(8);
            this.fIe = null;
        }
    }

    public boolean isShowing() {
        return this.fIe != null && this.fIe.getVisibility() == 0;
    }

    public TextView bnK() {
        return this.fIe;
    }

    public void bnL() {
        this.mHandler.removeCallbacks(this.mHideRunnable);
        this.mHandler.postDelayed(this.mHideRunnable, 2000L);
    }
}
