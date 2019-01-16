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
    private ValueAnimator dPs;
    private TextView dXB;
    private Context mContext;
    private Runnable mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.g.3
        @Override // java.lang.Runnable
        public void run() {
            if (g.this.dXB != null && g.this.dXB.getParent() != null && g.this.dPs != null) {
                g.this.dPs.start();
            }
        }
    };
    private Handler mHandler = new Handler();

    public g(Context context) {
        this.mContext = context;
        aFU();
    }

    private void aFU() {
        this.dXB = new TextView(this.mContext);
        this.dXB.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(e.C0210e.fontsize24));
        al.i(this.dXB, e.d.common_color_10260);
        al.h(this.dXB, e.d.cp_cont_i);
        this.dXB.setGravity(17);
        this.dXB.setVisibility(0);
        this.dPs = new ValueAnimator();
        this.dPs.setFloatValues(1.0f, 0.0f);
        this.dPs.setDuration(400L);
        this.dPs.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.game.strategy.view.g.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (g.this.dXB != null && valueAnimator != null) {
                    g.this.dXB.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.dPs.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.game.strategy.view.g.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (g.this.dXB != null) {
                    g.this.aDR();
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

    public void aDR() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.dPs != null) {
            this.dPs.cancel();
        }
        if (this.dXB != null) {
            ViewParent parent = this.dXB.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.dXB);
            }
            this.dXB.setVisibility(8);
            this.dXB = null;
        }
    }

    public boolean isShowing() {
        return this.dXB != null && this.dXB.getVisibility() == 0;
    }

    public TextView aFV() {
        return this.dXB;
    }

    public void aFW() {
        this.mHandler.removeCallbacks(this.mHideRunnable);
        this.mHandler.postDelayed(this.mHideRunnable, SystemScreenshotManager.DELAY_TIME);
    }
}
