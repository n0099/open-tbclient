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
/* loaded from: classes6.dex */
public class g {
    private ValueAnimator gnq;
    private TextView gvG;
    private Context mContext;
    private Runnable mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.g.3
        @Override // java.lang.Runnable
        public void run() {
            if (g.this.gvG != null && g.this.gvG.getParent() != null && g.this.gnq != null) {
                g.this.gnq.start();
            }
        }
    };
    private Handler mHandler = new Handler();

    public g(Context context) {
        this.mContext = context;
        bFe();
    }

    private void bFe() {
        this.gvG = new TextView(this.mContext);
        this.gvG.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(R.dimen.fontsize24));
        am.setBackgroundResource(this.gvG, R.color.cp_link_tip_a);
        am.setViewTextColor(this.gvG, (int) R.color.cp_cont_a);
        this.gvG.setGravity(17);
        this.gvG.setVisibility(0);
        this.gnq = new ValueAnimator();
        this.gnq.setFloatValues(1.0f, 0.0f);
        this.gnq.setDuration(400L);
        this.gnq.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.game.strategy.view.g.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (g.this.gvG != null && valueAnimator != null) {
                    g.this.gvG.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.gnq.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.game.strategy.view.g.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (g.this.gvG != null) {
                    g.this.bDm();
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

    public void bDm() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.gnq != null) {
            this.gnq.cancel();
        }
        if (this.gvG != null) {
            ViewParent parent = this.gvG.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.gvG);
            }
            this.gvG.setVisibility(8);
            this.gvG = null;
        }
    }

    public boolean isShowing() {
        return this.gvG != null && this.gvG.getVisibility() == 0;
    }

    public TextView bFf() {
        return this.gvG;
    }

    public void bFg() {
        this.mHandler.removeCallbacks(this.mHideRunnable);
        this.mHandler.postDelayed(this.mHideRunnable, 2000L);
    }
}
