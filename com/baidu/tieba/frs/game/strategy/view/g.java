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
/* loaded from: classes22.dex */
public class g {
    private ValueAnimator iMx;
    private TextView iWP;
    private Context mContext;
    private Runnable mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.g.3
        @Override // java.lang.Runnable
        public void run() {
            if (g.this.iWP != null && g.this.iWP.getParent() != null && g.this.iMx != null) {
                g.this.iMx.start();
            }
        }
    };
    private Handler mHandler = new Handler();

    public g(Context context) {
        this.mContext = context;
        cCL();
    }

    private void cCL() {
        this.iWP = new TextView(this.mContext);
        this.iWP.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(R.dimen.fontsize24));
        ap.setBackgroundResource(this.iWP, R.color.cp_link_tip_a);
        ap.setViewTextColor(this.iWP, (int) R.color.cp_cont_a);
        this.iWP.setGravity(17);
        this.iWP.setVisibility(0);
        this.iMx = new ValueAnimator();
        this.iMx.setFloatValues(1.0f, 0.0f);
        this.iMx.setDuration(400L);
        this.iMx.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.game.strategy.view.g.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (g.this.iWP != null && valueAnimator != null) {
                    g.this.iWP.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.iMx.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.game.strategy.view.g.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (g.this.iWP != null) {
                    g.this.cAG();
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

    public void cAG() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.iMx != null) {
            this.iMx.cancel();
        }
        if (this.iWP != null) {
            ViewParent parent = this.iWP.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.iWP);
            }
            this.iWP.setVisibility(8);
            this.iWP = null;
        }
    }

    public boolean isShowing() {
        return this.iWP != null && this.iWP.getVisibility() == 0;
    }

    public TextView cCM() {
        return this.iWP;
    }

    public void cCN() {
        this.mHandler.removeCallbacks(this.mHideRunnable);
        this.mHandler.postDelayed(this.mHideRunnable, 2000L);
    }
}
