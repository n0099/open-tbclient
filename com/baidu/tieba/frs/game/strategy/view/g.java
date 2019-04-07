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
/* loaded from: classes4.dex */
public class g {
    private ValueAnimator fda;
    private TextView fkQ;
    private Context mContext;
    private Runnable mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.g.3
        @Override // java.lang.Runnable
        public void run() {
            if (g.this.fkQ != null && g.this.fkQ.getParent() != null && g.this.fda != null) {
                g.this.fda.start();
            }
        }
    };
    private Handler mHandler = new Handler();

    public g(Context context) {
        this.mContext = context;
        bgk();
    }

    private void bgk() {
        this.fkQ = new TextView(this.mContext);
        this.fkQ.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(d.e.fontsize24));
        al.k(this.fkQ, d.C0277d.cp_btn_c);
        al.j(this.fkQ, d.C0277d.cp_btn_a);
        this.fkQ.setGravity(17);
        this.fkQ.setVisibility(0);
        this.fda = new ValueAnimator();
        this.fda.setFloatValues(1.0f, 0.0f);
        this.fda.setDuration(400L);
        this.fda.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.game.strategy.view.g.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (g.this.fkQ != null && valueAnimator != null) {
                    g.this.fkQ.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.fda.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.game.strategy.view.g.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (g.this.fkQ != null) {
                    g.this.bex();
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

    public void bex() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.fda != null) {
            this.fda.cancel();
        }
        if (this.fkQ != null) {
            ViewParent parent = this.fkQ.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.fkQ);
            }
            this.fkQ.setVisibility(8);
            this.fkQ = null;
        }
    }

    public boolean isShowing() {
        return this.fkQ != null && this.fkQ.getVisibility() == 0;
    }

    public TextView bgl() {
        return this.fkQ;
    }

    public void bgm() {
        this.mHandler.removeCallbacks(this.mHideRunnable);
        this.mHandler.postDelayed(this.mHideRunnable, 2000L);
    }
}
