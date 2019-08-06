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
    private TextView fGY;
    private ValueAnimator fyK;
    private Context mContext;
    private Runnable mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.g.3
        @Override // java.lang.Runnable
        public void run() {
            if (g.this.fGY != null && g.this.fGY.getParent() != null && g.this.fyK != null) {
                g.this.fyK.start();
            }
        }
    };
    private Handler mHandler = new Handler();

    public g(Context context) {
        this.mContext = context;
        bpS();
    }

    private void bpS() {
        this.fGY = new TextView(this.mContext);
        this.fGY.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(R.dimen.fontsize24));
        am.k(this.fGY, R.color.cp_btn_c);
        am.j(this.fGY, R.color.cp_btn_a);
        this.fGY.setGravity(17);
        this.fGY.setVisibility(0);
        this.fyK = new ValueAnimator();
        this.fyK.setFloatValues(1.0f, 0.0f);
        this.fyK.setDuration(400L);
        this.fyK.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.game.strategy.view.g.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (g.this.fGY != null && valueAnimator != null) {
                    g.this.fGY.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.fyK.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.game.strategy.view.g.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (g.this.fGY != null) {
                    g.this.bod();
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

    public void bod() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.fyK != null) {
            this.fyK.cancel();
        }
        if (this.fGY != null) {
            ViewParent parent = this.fGY.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.fGY);
            }
            this.fGY.setVisibility(8);
            this.fGY = null;
        }
    }

    public boolean isShowing() {
        return this.fGY != null && this.fGY.getVisibility() == 0;
    }

    public TextView bpT() {
        return this.fGY;
    }

    public void bpU() {
        this.mHandler.removeCallbacks(this.mHideRunnable);
        this.mHandler.postDelayed(this.mHideRunnable, 2000L);
    }
}
