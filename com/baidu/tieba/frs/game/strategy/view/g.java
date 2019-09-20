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
    private ValueAnimator fAx;
    private TextView fIN;
    private Context mContext;
    private Runnable mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.g.3
        @Override // java.lang.Runnable
        public void run() {
            if (g.this.fIN != null && g.this.fIN.getParent() != null && g.this.fAx != null) {
                g.this.fAx.start();
            }
        }
    };
    private Handler mHandler = new Handler();

    public g(Context context) {
        this.mContext = context;
        bqE();
    }

    private void bqE() {
        this.fIN = new TextView(this.mContext);
        this.fIN.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(R.dimen.fontsize24));
        am.k(this.fIN, R.color.cp_link_tip_a);
        am.j(this.fIN, R.color.cp_cont_a);
        this.fIN.setGravity(17);
        this.fIN.setVisibility(0);
        this.fAx = new ValueAnimator();
        this.fAx.setFloatValues(1.0f, 0.0f);
        this.fAx.setDuration(400L);
        this.fAx.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.game.strategy.view.g.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (g.this.fIN != null && valueAnimator != null) {
                    g.this.fIN.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.fAx.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.game.strategy.view.g.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (g.this.fIN != null) {
                    g.this.boO();
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

    public void boO() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.fAx != null) {
            this.fAx.cancel();
        }
        if (this.fIN != null) {
            ViewParent parent = this.fIN.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.fIN);
            }
            this.fIN.setVisibility(8);
            this.fIN = null;
        }
    }

    public boolean isShowing() {
        return this.fIN != null && this.fIN.getVisibility() == 0;
    }

    public TextView bqF() {
        return this.fIN;
    }

    public void bqG() {
        this.mHandler.removeCallbacks(this.mHideRunnable);
        this.mHandler.postDelayed(this.mHideRunnable, 2000L);
    }
}
