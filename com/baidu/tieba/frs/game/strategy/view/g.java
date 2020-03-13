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
    private TextView gBe;
    private ValueAnimator gsP;
    private Context mContext;
    private Runnable mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.g.3
        @Override // java.lang.Runnable
        public void run() {
            if (g.this.gBe != null && g.this.gBe.getParent() != null && g.this.gsP != null) {
                g.this.gsP.start();
            }
        }
    };
    private Handler mHandler = new Handler();

    public g(Context context) {
        this.mContext = context;
        bHL();
    }

    private void bHL() {
        this.gBe = new TextView(this.mContext);
        this.gBe.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(R.dimen.fontsize24));
        am.setBackgroundResource(this.gBe, R.color.cp_link_tip_a);
        am.setViewTextColor(this.gBe, (int) R.color.cp_cont_a);
        this.gBe.setGravity(17);
        this.gBe.setVisibility(0);
        this.gsP = new ValueAnimator();
        this.gsP.setFloatValues(1.0f, 0.0f);
        this.gsP.setDuration(400L);
        this.gsP.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.game.strategy.view.g.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (g.this.gBe != null && valueAnimator != null) {
                    g.this.gBe.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.gsP.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.game.strategy.view.g.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (g.this.gBe != null) {
                    g.this.bFT();
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

    public void bFT() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.gsP != null) {
            this.gsP.cancel();
        }
        if (this.gBe != null) {
            ViewParent parent = this.gBe.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.gBe);
            }
            this.gBe.setVisibility(8);
            this.gBe = null;
        }
    }

    public boolean isShowing() {
        return this.gBe != null && this.gBe.getVisibility() == 0;
    }

    public TextView bHM() {
        return this.gBe;
    }

    public void bHN() {
        this.mHandler.removeCallbacks(this.mHideRunnable);
        this.mHandler.postDelayed(this.mHideRunnable, 2000L);
    }
}
