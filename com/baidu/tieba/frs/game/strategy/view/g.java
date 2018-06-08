package com.baidu.tieba.frs.game.strategy.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class g {
    private ValueAnimator dkU;
    private TextView drV;
    private Context mContext;
    private Runnable mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.g.3
        @Override // java.lang.Runnable
        public void run() {
            if (g.this.drV != null && g.this.drV.getParent() != null && g.this.dkU != null) {
                g.this.dkU.start();
            }
        }
    };
    private Handler mHandler = new Handler();

    public g(Context context) {
        this.mContext = context;
        awM();
    }

    private void awM() {
        this.drV = new TextView(this.mContext);
        this.drV.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(d.e.fontsize24));
        al.i(this.drV, d.C0141d.common_color_10260);
        al.h(this.drV, d.C0141d.cp_cont_i);
        this.drV.setGravity(17);
        this.drV.setVisibility(0);
        this.dkU = new ValueAnimator();
        this.dkU.setFloatValues(1.0f, 0.0f);
        this.dkU.setDuration(400L);
        this.dkU.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.game.strategy.view.g.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (g.this.drV != null && valueAnimator != null) {
                    g.this.drV.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.dkU.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.game.strategy.view.g.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (g.this.drV != null) {
                    g.this.auT();
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

    public void auT() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.dkU != null) {
            this.dkU.cancel();
        }
        if (this.drV != null) {
            ViewParent parent = this.drV.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.drV);
            }
            this.drV.setVisibility(8);
            this.drV = null;
        }
    }

    public boolean isShowing() {
        return this.drV != null && this.drV.getVisibility() == 0;
    }

    public TextView awN() {
        return this.drV;
    }

    public void awO() {
        this.mHandler.removeCallbacks(this.mHideRunnable);
        this.mHandler.postDelayed(this.mHideRunnable, 2000L);
    }
}
