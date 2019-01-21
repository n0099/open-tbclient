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
    private ValueAnimator dPt;
    private TextView dXC;
    private Context mContext;
    private Runnable mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.g.3
        @Override // java.lang.Runnable
        public void run() {
            if (g.this.dXC != null && g.this.dXC.getParent() != null && g.this.dPt != null) {
                g.this.dPt.start();
            }
        }
    };
    private Handler mHandler = new Handler();

    public g(Context context) {
        this.mContext = context;
        aFU();
    }

    private void aFU() {
        this.dXC = new TextView(this.mContext);
        this.dXC.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(e.C0210e.fontsize24));
        al.i(this.dXC, e.d.common_color_10260);
        al.h(this.dXC, e.d.cp_cont_i);
        this.dXC.setGravity(17);
        this.dXC.setVisibility(0);
        this.dPt = new ValueAnimator();
        this.dPt.setFloatValues(1.0f, 0.0f);
        this.dPt.setDuration(400L);
        this.dPt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.game.strategy.view.g.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (g.this.dXC != null && valueAnimator != null) {
                    g.this.dXC.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.dPt.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.game.strategy.view.g.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (g.this.dXC != null) {
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
        if (this.dPt != null) {
            this.dPt.cancel();
        }
        if (this.dXC != null) {
            ViewParent parent = this.dXC.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.dXC);
            }
            this.dXC.setVisibility(8);
            this.dXC = null;
        }
    }

    public boolean isShowing() {
        return this.dXC != null && this.dXC.getVisibility() == 0;
    }

    public TextView aFV() {
        return this.dXC;
    }

    public void aFW() {
        this.mHandler.removeCallbacks(this.mHideRunnable);
        this.mHandler.postDelayed(this.mHideRunnable, SystemScreenshotManager.DELAY_TIME);
    }
}
