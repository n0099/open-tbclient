package com.baidu.tieba.frs.game.strategy.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class g {
    private ValueAnimator dpR;
    private TextView dxO;
    private Context mContext;
    private Runnable mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.g.3
        @Override // java.lang.Runnable
        public void run() {
            if (g.this.dxO != null && g.this.dxO.getParent() != null && g.this.dpR != null) {
                g.this.dpR.start();
            }
        }
    };
    private Handler mHandler = new Handler();

    public g(Context context) {
        this.mContext = context;
        axT();
    }

    private void axT() {
        this.dxO = new TextView(this.mContext);
        this.dxO.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(f.e.fontsize24));
        am.i(this.dxO, f.d.common_color_10260);
        am.h(this.dxO, f.d.cp_cont_i);
        this.dxO.setGravity(17);
        this.dxO.setVisibility(0);
        this.dpR = new ValueAnimator();
        this.dpR.setFloatValues(1.0f, 0.0f);
        this.dpR.setDuration(400L);
        this.dpR.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.game.strategy.view.g.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (g.this.dxO != null && valueAnimator != null) {
                    g.this.dxO.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.dpR.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.game.strategy.view.g.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (g.this.dxO != null) {
                    g.this.avR();
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

    public void avR() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.dpR != null) {
            this.dpR.cancel();
        }
        if (this.dxO != null) {
            ViewParent parent = this.dxO.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.dxO);
            }
            this.dxO.setVisibility(8);
            this.dxO = null;
        }
    }

    public boolean isShowing() {
        return this.dxO != null && this.dxO.getVisibility() == 0;
    }

    public TextView axU() {
        return this.dxO;
    }

    public void axV() {
        this.mHandler.removeCallbacks(this.mHideRunnable);
        this.mHandler.postDelayed(this.mHideRunnable, 2000L);
    }
}
