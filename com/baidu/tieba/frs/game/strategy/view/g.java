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
    private TextView hUo;
    private Context mContext;
    private Runnable mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.g.3
        @Override // java.lang.Runnable
        public void run() {
            if (g.this.hUo != null && g.this.hUo.getParent() != null && g.this.hKy != null) {
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
        this.hUo = new TextView(this.mContext);
        this.hUo.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(R.dimen.fontsize24));
        ao.setBackgroundResource(this.hUo, R.color.cp_link_tip_a);
        ao.setViewTextColor(this.hUo, R.color.cp_cont_a);
        this.hUo.setGravity(17);
        this.hUo.setVisibility(0);
        this.hKy = new ValueAnimator();
        this.hKy.setFloatValues(1.0f, 0.0f);
        this.hKy.setDuration(400L);
        this.hKy.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.game.strategy.view.g.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (g.this.hUo != null && valueAnimator != null) {
                    g.this.hUo.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.hKy.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.game.strategy.view.g.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (g.this.hUo != null) {
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
        if (this.hUo != null) {
            ViewParent parent = this.hUo.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.hUo);
            }
            this.hUo.setVisibility(8);
            this.hUo = null;
        }
    }

    public boolean isShowing() {
        return this.hUo != null && this.hUo.getVisibility() == 0;
    }

    public TextView cfO() {
        return this.hUo;
    }

    public void cfP() {
        this.mHandler.removeCallbacks(this.mHideRunnable);
        this.mHandler.postDelayed(this.mHideRunnable, 2000L);
    }
}
