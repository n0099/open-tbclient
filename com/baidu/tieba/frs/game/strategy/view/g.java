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
    private ValueAnimator dpT;
    private TextView dxR;
    private Context mContext;
    private Runnable mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.g.3
        @Override // java.lang.Runnable
        public void run() {
            if (g.this.dxR != null && g.this.dxR.getParent() != null && g.this.dpT != null) {
                g.this.dpT.start();
            }
        }
    };
    private Handler mHandler = new Handler();

    public g(Context context) {
        this.mContext = context;
        axV();
    }

    private void axV() {
        this.dxR = new TextView(this.mContext);
        this.dxR.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(d.e.fontsize24));
        am.i(this.dxR, d.C0140d.common_color_10260);
        am.h(this.dxR, d.C0140d.cp_cont_i);
        this.dxR.setGravity(17);
        this.dxR.setVisibility(0);
        this.dpT = new ValueAnimator();
        this.dpT.setFloatValues(1.0f, 0.0f);
        this.dpT.setDuration(400L);
        this.dpT.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.game.strategy.view.g.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (g.this.dxR != null && valueAnimator != null) {
                    g.this.dxR.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.dpT.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.game.strategy.view.g.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (g.this.dxR != null) {
                    g.this.avS();
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

    public void avS() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.dpT != null) {
            this.dpT.cancel();
        }
        if (this.dxR != null) {
            ViewParent parent = this.dxR.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.dxR);
            }
            this.dxR.setVisibility(8);
            this.dxR = null;
        }
    }

    public boolean isShowing() {
        return this.dxR != null && this.dxR.getVisibility() == 0;
    }

    public TextView axW() {
        return this.dxR;
    }

    public void axX() {
        this.mHandler.removeCallbacks(this.mHideRunnable);
        this.mHandler.postDelayed(this.mHideRunnable, 2000L);
    }
}
