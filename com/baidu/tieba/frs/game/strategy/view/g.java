package com.baidu.tieba.frs.game.strategy.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class g {
    private TextView fBl;
    private ValueAnimator fto;
    private Context mContext;
    private Runnable mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.g.3
        @Override // java.lang.Runnable
        public void run() {
            if (g.this.fBl != null && g.this.fBl.getParent() != null && g.this.fto != null) {
                g.this.fto.start();
            }
        }
    };
    private Handler mHandler = new Handler();

    public g(Context context) {
        this.mContext = context;
        bnB();
    }

    private void bnB() {
        this.fBl = new TextView(this.mContext);
        this.fBl.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(R.dimen.fontsize24));
        al.k(this.fBl, R.color.cp_btn_c);
        al.j(this.fBl, R.color.cp_btn_a);
        this.fBl.setGravity(17);
        this.fBl.setVisibility(0);
        this.fto = new ValueAnimator();
        this.fto.setFloatValues(1.0f, 0.0f);
        this.fto.setDuration(400L);
        this.fto.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.game.strategy.view.g.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (g.this.fBl != null && valueAnimator != null) {
                    g.this.fBl.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.fto.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.game.strategy.view.g.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (g.this.fBl != null) {
                    g.this.blP();
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

    public void blP() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.fto != null) {
            this.fto.cancel();
        }
        if (this.fBl != null) {
            ViewParent parent = this.fBl.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.fBl);
            }
            this.fBl.setVisibility(8);
            this.fBl = null;
        }
    }

    public boolean isShowing() {
        return this.fBl != null && this.fBl.getVisibility() == 0;
    }

    public TextView bnC() {
        return this.fBl;
    }

    public void bnD() {
        this.mHandler.removeCallbacks(this.mHideRunnable);
        this.mHandler.postDelayed(this.mHideRunnable, 2000L);
    }
}
