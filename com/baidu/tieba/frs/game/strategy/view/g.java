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
    private ValueAnimator dLV;
    private TextView dUe;
    private Context mContext;
    private Runnable mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.g.3
        @Override // java.lang.Runnable
        public void run() {
            if (g.this.dUe != null && g.this.dUe.getParent() != null && g.this.dLV != null) {
                g.this.dLV.start();
            }
        }
    };
    private Handler mHandler = new Handler();

    public g(Context context) {
        this.mContext = context;
        aEI();
    }

    private void aEI() {
        this.dUe = new TextView(this.mContext);
        this.dUe.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(e.C0210e.fontsize24));
        al.i(this.dUe, e.d.common_color_10260);
        al.h(this.dUe, e.d.cp_cont_i);
        this.dUe.setGravity(17);
        this.dUe.setVisibility(0);
        this.dLV = new ValueAnimator();
        this.dLV.setFloatValues(1.0f, 0.0f);
        this.dLV.setDuration(400L);
        this.dLV.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.game.strategy.view.g.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (g.this.dUe != null && valueAnimator != null) {
                    g.this.dUe.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.dLV.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.game.strategy.view.g.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (g.this.dUe != null) {
                    g.this.aCF();
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

    public void aCF() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.dLV != null) {
            this.dLV.cancel();
        }
        if (this.dUe != null) {
            ViewParent parent = this.dUe.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.dUe);
            }
            this.dUe.setVisibility(8);
            this.dUe = null;
        }
    }

    public boolean isShowing() {
        return this.dUe != null && this.dUe.getVisibility() == 0;
    }

    public TextView aEJ() {
        return this.dUe;
    }

    public void aEK() {
        this.mHandler.removeCallbacks(this.mHideRunnable);
        this.mHandler.postDelayed(this.mHideRunnable, SystemScreenshotManager.DELAY_TIME);
    }
}
