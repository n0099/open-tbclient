package com.baidu.tieba.frs.game.strategy.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class g {
    private ValueAnimator dnb;
    private TextView dve;
    private Context mContext;
    private Runnable mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.g.3
        @Override // java.lang.Runnable
        public void run() {
            if (g.this.dve != null && g.this.dve.getParent() != null && g.this.dnb != null) {
                g.this.dnb.start();
            }
        }
    };
    private Handler mHandler = new Handler();

    public g(Context context) {
        this.mContext = context;
        axq();
    }

    private void axq() {
        this.dve = new TextView(this.mContext);
        this.dve.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(d.e.fontsize24));
        am.i(this.dve, d.C0142d.common_color_10260);
        am.h(this.dve, d.C0142d.cp_cont_i);
        this.dve.setGravity(17);
        this.dve.setVisibility(0);
        this.dnb = new ValueAnimator();
        this.dnb.setFloatValues(1.0f, 0.0f);
        this.dnb.setDuration(400L);
        this.dnb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.game.strategy.view.g.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (g.this.dve != null && valueAnimator != null) {
                    g.this.dve.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.dnb.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.game.strategy.view.g.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (g.this.dve != null) {
                    g.this.avn();
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

    public void avn() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.dnb != null) {
            this.dnb.cancel();
        }
        if (this.dve != null) {
            ViewParent parent = this.dve.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.dve);
            }
            this.dve.setVisibility(8);
            this.dve = null;
        }
    }

    public boolean isShowing() {
        return this.dve != null && this.dve.getVisibility() == 0;
    }

    public TextView axr() {
        return this.dve;
    }

    public void axs() {
        this.mHandler.removeCallbacks(this.mHideRunnable);
        this.mHandler.postDelayed(this.mHideRunnable, 2000L);
    }
}
