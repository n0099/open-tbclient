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
    private TextView fGk;
    private ValueAnimator fyl;
    private Context mContext;
    private Runnable mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.g.3
        @Override // java.lang.Runnable
        public void run() {
            if (g.this.fGk != null && g.this.fGk.getParent() != null && g.this.fyl != null) {
                g.this.fyl.start();
            }
        }
    };
    private Handler mHandler = new Handler();

    public g(Context context) {
        this.mContext = context;
        bpF();
    }

    private void bpF() {
        this.fGk = new TextView(this.mContext);
        this.fGk.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(R.dimen.fontsize24));
        am.k(this.fGk, R.color.cp_btn_c);
        am.j(this.fGk, R.color.cp_btn_a);
        this.fGk.setGravity(17);
        this.fGk.setVisibility(0);
        this.fyl = new ValueAnimator();
        this.fyl.setFloatValues(1.0f, 0.0f);
        this.fyl.setDuration(400L);
        this.fyl.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.game.strategy.view.g.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (g.this.fGk != null && valueAnimator != null) {
                    g.this.fGk.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.fyl.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.game.strategy.view.g.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (g.this.fGk != null) {
                    g.this.bnT();
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

    public void bnT() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.fyl != null) {
            this.fyl.cancel();
        }
        if (this.fGk != null) {
            ViewParent parent = this.fGk.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.fGk);
            }
            this.fGk.setVisibility(8);
            this.fGk = null;
        }
    }

    public boolean isShowing() {
        return this.fGk != null && this.fGk.getVisibility() == 0;
    }

    public TextView bpG() {
        return this.fGk;
    }

    public void bpH() {
        this.mHandler.removeCallbacks(this.mHideRunnable);
        this.mHandler.postDelayed(this.mHideRunnable, 2000L);
    }
}
