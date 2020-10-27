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
    private ValueAnimator iGA;
    private TextView iQS;
    private Context mContext;
    private Runnable mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.g.3
        @Override // java.lang.Runnable
        public void run() {
            if (g.this.iQS != null && g.this.iQS.getParent() != null && g.this.iGA != null) {
                g.this.iGA.start();
            }
        }
    };
    private Handler mHandler = new Handler();

    public g(Context context) {
        this.mContext = context;
        cAk();
    }

    private void cAk() {
        this.iQS = new TextView(this.mContext);
        this.iQS.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(R.dimen.fontsize24));
        ap.setBackgroundResource(this.iQS, R.color.cp_link_tip_a);
        ap.setViewTextColor(this.iQS, (int) R.color.cp_cont_a);
        this.iQS.setGravity(17);
        this.iQS.setVisibility(0);
        this.iGA = new ValueAnimator();
        this.iGA.setFloatValues(1.0f, 0.0f);
        this.iGA.setDuration(400L);
        this.iGA.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.game.strategy.view.g.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (g.this.iQS != null && valueAnimator != null) {
                    g.this.iQS.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.iGA.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.game.strategy.view.g.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (g.this.iQS != null) {
                    g.this.cyf();
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

    public void cyf() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.iGA != null) {
            this.iGA.cancel();
        }
        if (this.iQS != null) {
            ViewParent parent = this.iQS.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.iQS);
            }
            this.iQS.setVisibility(8);
            this.iQS = null;
        }
    }

    public boolean isShowing() {
        return this.iQS != null && this.iQS.getVisibility() == 0;
    }

    public TextView cAl() {
        return this.iQS;
    }

    public void cAm() {
        this.mHandler.removeCallbacks(this.mHideRunnable);
        this.mHandler.postDelayed(this.mHideRunnable, 2000L);
    }
}
