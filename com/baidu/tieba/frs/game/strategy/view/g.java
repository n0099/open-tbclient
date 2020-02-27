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
    private TextView gAQ;
    private ValueAnimator gsA;
    private Context mContext;
    private Runnable mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.g.3
        @Override // java.lang.Runnable
        public void run() {
            if (g.this.gAQ != null && g.this.gAQ.getParent() != null && g.this.gsA != null) {
                g.this.gsA.start();
            }
        }
    };
    private Handler mHandler = new Handler();

    public g(Context context) {
        this.mContext = context;
        bHI();
    }

    private void bHI() {
        this.gAQ = new TextView(this.mContext);
        this.gAQ.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(R.dimen.fontsize24));
        am.setBackgroundResource(this.gAQ, R.color.cp_link_tip_a);
        am.setViewTextColor(this.gAQ, (int) R.color.cp_cont_a);
        this.gAQ.setGravity(17);
        this.gAQ.setVisibility(0);
        this.gsA = new ValueAnimator();
        this.gsA.setFloatValues(1.0f, 0.0f);
        this.gsA.setDuration(400L);
        this.gsA.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.game.strategy.view.g.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (g.this.gAQ != null && valueAnimator != null) {
                    g.this.gAQ.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.gsA.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.game.strategy.view.g.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (g.this.gAQ != null) {
                    g.this.bFQ();
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

    public void bFQ() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.gsA != null) {
            this.gsA.cancel();
        }
        if (this.gAQ != null) {
            ViewParent parent = this.gAQ.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.gAQ);
            }
            this.gAQ.setVisibility(8);
            this.gAQ = null;
        }
    }

    public boolean isShowing() {
        return this.gAQ != null && this.gAQ.getVisibility() == 0;
    }

    public TextView bHJ() {
        return this.gAQ;
    }

    public void bHK() {
        this.mHandler.removeCallbacks(this.mHideRunnable);
        this.mHandler.postDelayed(this.mHideRunnable, 2000L);
    }
}
