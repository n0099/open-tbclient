package com.baidu.tieba.frs.game.strategy.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class g {
    private ValueAnimator dEg;
    private TextView dMx;
    private Context mContext;
    private Runnable mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.g.3
        @Override // java.lang.Runnable
        public void run() {
            if (g.this.dMx != null && g.this.dMx.getParent() != null && g.this.dEg != null) {
                g.this.dEg.start();
            }
        }
    };
    private Handler mHandler = new Handler();

    public g(Context context) {
        this.mContext = context;
        aDC();
    }

    private void aDC() {
        this.dMx = new TextView(this.mContext);
        this.dMx.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(e.C0175e.fontsize24));
        al.i(this.dMx, e.d.common_color_10260);
        al.h(this.dMx, e.d.cp_cont_i);
        this.dMx.setGravity(17);
        this.dMx.setVisibility(0);
        this.dEg = new ValueAnimator();
        this.dEg.setFloatValues(1.0f, 0.0f);
        this.dEg.setDuration(400L);
        this.dEg.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.game.strategy.view.g.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (g.this.dMx != null && valueAnimator != null) {
                    g.this.dMx.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.dEg.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.game.strategy.view.g.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (g.this.dMx != null) {
                    g.this.aBy();
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

    public void aBy() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.dEg != null) {
            this.dEg.cancel();
        }
        if (this.dMx != null) {
            ViewParent parent = this.dMx.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.dMx);
            }
            this.dMx.setVisibility(8);
            this.dMx = null;
        }
    }

    public boolean isShowing() {
        return this.dMx != null && this.dMx.getVisibility() == 0;
    }

    public TextView aDD() {
        return this.dMx;
    }

    public void aDE() {
        this.mHandler.removeCallbacks(this.mHideRunnable);
        this.mHandler.postDelayed(this.mHideRunnable, SystemScreenshotManager.DELAY_TIME);
    }
}
