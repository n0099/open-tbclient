package com.baidu.tieba.frs.game.strategy.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class g {
    private ValueAnimator fdn;
    private TextView fle;
    private Context mContext;
    private Runnable mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.g.3
        @Override // java.lang.Runnable
        public void run() {
            if (g.this.fle != null && g.this.fle.getParent() != null && g.this.fdn != null) {
                g.this.fdn.start();
            }
        }
    };
    private Handler mHandler = new Handler();

    public g(Context context) {
        this.mContext = context;
        bgm();
    }

    private void bgm() {
        this.fle = new TextView(this.mContext);
        this.fle.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(d.e.fontsize24));
        al.k(this.fle, d.C0277d.cp_btn_c);
        al.j(this.fle, d.C0277d.cp_btn_a);
        this.fle.setGravity(17);
        this.fle.setVisibility(0);
        this.fdn = new ValueAnimator();
        this.fdn.setFloatValues(1.0f, 0.0f);
        this.fdn.setDuration(400L);
        this.fdn.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.game.strategy.view.g.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (g.this.fle != null && valueAnimator != null) {
                    g.this.fle.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.fdn.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.game.strategy.view.g.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (g.this.fle != null) {
                    g.this.bez();
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

    public void bez() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.fdn != null) {
            this.fdn.cancel();
        }
        if (this.fle != null) {
            ViewParent parent = this.fle.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.fle);
            }
            this.fle.setVisibility(8);
            this.fle = null;
        }
    }

    public boolean isShowing() {
        return this.fle != null && this.fle.getVisibility() == 0;
    }

    public TextView bgn() {
        return this.fle;
    }

    public void bgo() {
        this.mHandler.removeCallbacks(this.mHideRunnable);
        this.mHandler.postDelayed(this.mHideRunnable, 2000L);
    }
}
