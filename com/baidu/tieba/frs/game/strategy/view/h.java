package com.baidu.tieba.frs.game.strategy.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class h {
    private ValueAnimator dHF;
    private TextView dOW;
    private Context mContext;
    private Runnable dOX = new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.h.3
        @Override // java.lang.Runnable
        public void run() {
            if (h.this.dOW != null && h.this.dOW.getParent() != null && h.this.dHF != null) {
                h.this.dHF.start();
            }
        }
    };
    private Handler mHandler = new Handler();

    public h(Context context) {
        this.mContext = context;
        ayc();
    }

    private void ayc() {
        this.dOW = new TextView(this.mContext);
        this.dOW.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(d.e.fontsize24));
        aj.s(this.dOW, d.C0141d.common_color_10260);
        aj.r(this.dOW, d.C0141d.cp_cont_i);
        this.dOW.setGravity(17);
        this.dOW.setVisibility(0);
        this.dHF = new ValueAnimator();
        this.dHF.setFloatValues(1.0f, 0.0f);
        this.dHF.setDuration(400L);
        this.dHF.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.game.strategy.view.h.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (h.this.dOW != null && valueAnimator != null) {
                    h.this.dOW.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.dHF.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.game.strategy.view.h.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (h.this.dOW != null) {
                    h.this.aww();
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

    public void aww() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.dHF != null) {
            this.dHF.cancel();
        }
        if (this.dOW != null) {
            ViewParent parent = this.dOW.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.dOW);
            }
            this.dOW.setVisibility(8);
            this.dOW = null;
        }
    }

    public boolean isShowing() {
        return this.dOW != null && this.dOW.getVisibility() == 0;
    }

    public TextView ayd() {
        return this.dOW;
    }

    public void aye() {
        this.mHandler.removeCallbacks(this.dOX);
        this.mHandler.postDelayed(this.dOX, 2000L);
    }
}
