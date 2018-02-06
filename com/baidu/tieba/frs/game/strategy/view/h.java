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
    private ValueAnimator dHM;
    private TextView dPd;
    private Context mContext;
    private Runnable dPe = new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.h.3
        @Override // java.lang.Runnable
        public void run() {
            if (h.this.dPd != null && h.this.dPd.getParent() != null && h.this.dHM != null) {
                h.this.dHM.start();
            }
        }
    };
    private Handler mHandler = new Handler();

    public h(Context context) {
        this.mContext = context;
        ayb();
    }

    private void ayb() {
        this.dPd = new TextView(this.mContext);
        this.dPd.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(d.e.fontsize24));
        aj.s(this.dPd, d.C0140d.common_color_10260);
        aj.r(this.dPd, d.C0140d.cp_cont_i);
        this.dPd.setGravity(17);
        this.dPd.setVisibility(0);
        this.dHM = new ValueAnimator();
        this.dHM.setFloatValues(1.0f, 0.0f);
        this.dHM.setDuration(400L);
        this.dHM.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.game.strategy.view.h.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (h.this.dPd != null && valueAnimator != null) {
                    h.this.dPd.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.dHM.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.game.strategy.view.h.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (h.this.dPd != null) {
                    h.this.awv();
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

    public void awv() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.dHM != null) {
            this.dHM.cancel();
        }
        if (this.dPd != null) {
            ViewParent parent = this.dPd.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.dPd);
            }
            this.dPd.setVisibility(8);
            this.dPd = null;
        }
    }

    public boolean isShowing() {
        return this.dPd != null && this.dPd.getVisibility() == 0;
    }

    public TextView ayc() {
        return this.dPd;
    }

    public void ayd() {
        this.mHandler.removeCallbacks(this.dPe);
        this.mHandler.postDelayed(this.dPe, 2000L);
    }
}
