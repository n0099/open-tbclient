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
    private ValueAnimator dOJ;
    private TextView dWV;
    private Context mContext;
    private Runnable mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.g.3
        @Override // java.lang.Runnable
        public void run() {
            if (g.this.dWV != null && g.this.dWV.getParent() != null && g.this.dOJ != null) {
                g.this.dOJ.start();
            }
        }
    };
    private Handler mHandler = new Handler();

    public g(Context context) {
        this.mContext = context;
        aFx();
    }

    private void aFx() {
        this.dWV = new TextView(this.mContext);
        this.dWV.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(e.C0210e.fontsize24));
        al.i(this.dWV, e.d.common_color_10260);
        al.h(this.dWV, e.d.cp_cont_i);
        this.dWV.setGravity(17);
        this.dWV.setVisibility(0);
        this.dOJ = new ValueAnimator();
        this.dOJ.setFloatValues(1.0f, 0.0f);
        this.dOJ.setDuration(400L);
        this.dOJ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.game.strategy.view.g.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (g.this.dWV != null && valueAnimator != null) {
                    g.this.dWV.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.dOJ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.game.strategy.view.g.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (g.this.dWV != null) {
                    g.this.aDu();
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

    public void aDu() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.dOJ != null) {
            this.dOJ.cancel();
        }
        if (this.dWV != null) {
            ViewParent parent = this.dWV.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.dWV);
            }
            this.dWV.setVisibility(8);
            this.dWV = null;
        }
    }

    public boolean isShowing() {
        return this.dWV != null && this.dWV.getVisibility() == 0;
    }

    public TextView aFy() {
        return this.dWV;
    }

    public void aFz() {
        this.mHandler.removeCallbacks(this.mHideRunnable);
        this.mHandler.postDelayed(this.mHideRunnable, SystemScreenshotManager.DELAY_TIME);
    }
}
