package com.baidu.tieba.frs.game.strategy.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class g {
    private ValueAnimator hKy;
    private TextView hUm;
    private Context mContext;
    private Runnable mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.g.3
        @Override // java.lang.Runnable
        public void run() {
            if (g.this.hUm != null && g.this.hUm.getParent() != null && g.this.hKy != null) {
                g.this.hKy.start();
            }
        }
    };
    private Handler mHandler = new Handler();

    public g(Context context) {
        this.mContext = context;
        cfN();
    }

    private void cfN() {
        this.hUm = new TextView(this.mContext);
        this.hUm.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(R.dimen.fontsize24));
        ao.setBackgroundResource(this.hUm, R.color.cp_link_tip_a);
        ao.setViewTextColor(this.hUm, R.color.cp_cont_a);
        this.hUm.setGravity(17);
        this.hUm.setVisibility(0);
        this.hKy = new ValueAnimator();
        this.hKy.setFloatValues(1.0f, 0.0f);
        this.hKy.setDuration(400L);
        this.hKy.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.game.strategy.view.g.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (g.this.hUm != null && valueAnimator != null) {
                    g.this.hUm.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.hKy.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.game.strategy.view.g.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (g.this.hUm != null) {
                    g.this.cdN();
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

    public void cdN() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.hKy != null) {
            this.hKy.cancel();
        }
        if (this.hUm != null) {
            ViewParent parent = this.hUm.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.hUm);
            }
            this.hUm.setVisibility(8);
            this.hUm = null;
        }
    }

    public boolean isShowing() {
        return this.hUm != null && this.hUm.getVisibility() == 0;
    }

    public TextView cfO() {
        return this.hUm;
    }

    public void cfP() {
        this.mHandler.removeCallbacks(this.mHideRunnable);
        this.mHandler.postDelayed(this.mHideRunnable, 2000L);
    }
}
