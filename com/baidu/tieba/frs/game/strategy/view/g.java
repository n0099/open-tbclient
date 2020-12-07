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
    private ValueAnimator iYb;
    private TextView jla;
    private Context mContext;
    private Runnable mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.g.3
        @Override // java.lang.Runnable
        public void run() {
            if (g.this.jla != null && g.this.jla.getParent() != null && g.this.iYb != null) {
                g.this.iYb.start();
            }
        }
    };
    private Handler mHandler = new Handler();

    public g(Context context) {
        this.mContext = context;
        cHA();
    }

    private void cHA() {
        this.jla = new TextView(this.mContext);
        this.jla.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(R.dimen.fontsize24));
        ap.setBackgroundResource(this.jla, R.color.CAM_X0302);
        ap.setViewTextColor(this.jla, (int) R.color.CAM_X0101);
        this.jla.setGravity(17);
        this.jla.setVisibility(0);
        this.iYb = new ValueAnimator();
        this.iYb.setFloatValues(1.0f, 0.0f);
        this.iYb.setDuration(400L);
        this.iYb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.game.strategy.view.g.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (g.this.jla != null && valueAnimator != null) {
                    g.this.jla.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.iYb.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.game.strategy.view.g.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (g.this.jla != null) {
                    g.this.cEz();
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

    public void cEz() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.iYb != null) {
            this.iYb.cancel();
        }
        if (this.jla != null) {
            ViewParent parent = this.jla.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.jla);
            }
            this.jla.setVisibility(8);
            this.jla = null;
        }
    }

    public boolean isShowing() {
        return this.jla != null && this.jla.getVisibility() == 0;
    }

    public TextView cHB() {
        return this.jla;
    }

    public void cHC() {
        this.mHandler.removeCallbacks(this.mHideRunnable);
        this.mHandler.postDelayed(this.mHideRunnable, 2000L);
    }
}
