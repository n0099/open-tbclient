package com.baidu.tieba.frs.game.strategy.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class g {
    private TextView dEy;
    private ValueAnimator dwf;
    private Context mContext;
    private Runnable mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.g.3
        @Override // java.lang.Runnable
        public void run() {
            if (g.this.dEy != null && g.this.dEy.getParent() != null && g.this.dwf != null) {
                g.this.dwf.start();
            }
        }
    };
    private Handler mHandler = new Handler();

    public g(Context context) {
        this.mContext = context;
        aAi();
    }

    private void aAi() {
        this.dEy = new TextView(this.mContext);
        this.dEy.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(e.C0141e.fontsize24));
        al.i(this.dEy, e.d.common_color_10260);
        al.h(this.dEy, e.d.cp_cont_i);
        this.dEy.setGravity(17);
        this.dEy.setVisibility(0);
        this.dwf = new ValueAnimator();
        this.dwf.setFloatValues(1.0f, 0.0f);
        this.dwf.setDuration(400L);
        this.dwf.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.game.strategy.view.g.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (g.this.dEy != null && valueAnimator != null) {
                    g.this.dEy.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.dwf.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.game.strategy.view.g.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (g.this.dEy != null) {
                    g.this.ayc();
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

    public void ayc() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.dwf != null) {
            this.dwf.cancel();
        }
        if (this.dEy != null) {
            ViewParent parent = this.dEy.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.dEy);
            }
            this.dEy.setVisibility(8);
            this.dEy = null;
        }
    }

    public boolean isShowing() {
        return this.dEy != null && this.dEy.getVisibility() == 0;
    }

    public TextView aAj() {
        return this.dEy;
    }

    public void aAk() {
        this.mHandler.removeCallbacks(this.mHideRunnable);
        this.mHandler.postDelayed(this.mHideRunnable, 2000L);
    }
}
