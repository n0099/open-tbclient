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
    private ValueAnimator iYd;
    private TextView jlc;
    private Context mContext;
    private Runnable mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.g.3
        @Override // java.lang.Runnable
        public void run() {
            if (g.this.jlc != null && g.this.jlc.getParent() != null && g.this.iYd != null) {
                g.this.iYd.start();
            }
        }
    };
    private Handler mHandler = new Handler();

    public g(Context context) {
        this.mContext = context;
        cHB();
    }

    private void cHB() {
        this.jlc = new TextView(this.mContext);
        this.jlc.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(R.dimen.fontsize24));
        ap.setBackgroundResource(this.jlc, R.color.CAM_X0302);
        ap.setViewTextColor(this.jlc, (int) R.color.CAM_X0101);
        this.jlc.setGravity(17);
        this.jlc.setVisibility(0);
        this.iYd = new ValueAnimator();
        this.iYd.setFloatValues(1.0f, 0.0f);
        this.iYd.setDuration(400L);
        this.iYd.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.game.strategy.view.g.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (g.this.jlc != null && valueAnimator != null) {
                    g.this.jlc.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.iYd.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.game.strategy.view.g.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (g.this.jlc != null) {
                    g.this.cEA();
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

    public void cEA() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.iYd != null) {
            this.iYd.cancel();
        }
        if (this.jlc != null) {
            ViewParent parent = this.jlc.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.jlc);
            }
            this.jlc.setVisibility(8);
            this.jlc = null;
        }
    }

    public boolean isShowing() {
        return this.jlc != null && this.jlc.getVisibility() == 0;
    }

    public TextView cHC() {
        return this.jlc;
    }

    public void cHD() {
        this.mHandler.removeCallbacks(this.mHideRunnable);
        this.mHandler.postDelayed(this.mHideRunnable, 2000L);
    }
}
