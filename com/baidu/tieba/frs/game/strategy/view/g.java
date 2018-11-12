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
    private ValueAnimator dFw;
    private TextView dNB;
    private Context mContext;
    private Runnable mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.g.3
        @Override // java.lang.Runnable
        public void run() {
            if (g.this.dNB != null && g.this.dNB.getParent() != null && g.this.dFw != null) {
                g.this.dFw.start();
            }
        }
    };
    private Handler mHandler = new Handler();

    public g(Context context) {
        this.mContext = context;
        aCW();
    }

    private void aCW() {
        this.dNB = new TextView(this.mContext);
        this.dNB.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(e.C0200e.fontsize24));
        al.i(this.dNB, e.d.common_color_10260);
        al.h(this.dNB, e.d.cp_cont_i);
        this.dNB.setGravity(17);
        this.dNB.setVisibility(0);
        this.dFw = new ValueAnimator();
        this.dFw.setFloatValues(1.0f, 0.0f);
        this.dFw.setDuration(400L);
        this.dFw.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.game.strategy.view.g.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (g.this.dNB != null && valueAnimator != null) {
                    g.this.dNB.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.dFw.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.game.strategy.view.g.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (g.this.dNB != null) {
                    g.this.aAV();
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

    public void aAV() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.dFw != null) {
            this.dFw.cancel();
        }
        if (this.dNB != null) {
            ViewParent parent = this.dNB.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.dNB);
            }
            this.dNB.setVisibility(8);
            this.dNB = null;
        }
    }

    public boolean isShowing() {
        return this.dNB != null && this.dNB.getVisibility() == 0;
    }

    public TextView aCX() {
        return this.dNB;
    }

    public void aCY() {
        this.mHandler.removeCallbacks(this.mHideRunnable);
        this.mHandler.postDelayed(this.mHideRunnable, SystemScreenshotManager.DELAY_TIME);
    }
}
