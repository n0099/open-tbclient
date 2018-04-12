package com.baidu.tieba.frs.game.strategy.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class g {
    private ValueAnimator daA;
    private TextView dhC;
    private Context mContext;
    private Runnable dhD = new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.g.3
        @Override // java.lang.Runnable
        public void run() {
            if (g.this.dhC != null && g.this.dhC.getParent() != null && g.this.daA != null) {
                g.this.daA.start();
            }
        }
    };
    private Handler mHandler = new Handler();

    public g(Context context) {
        this.mContext = context;
        asH();
    }

    private void asH() {
        this.dhC = new TextView(this.mContext);
        this.dhC.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(d.e.fontsize24));
        ak.i(this.dhC, d.C0126d.common_color_10260);
        ak.h(this.dhC, d.C0126d.cp_cont_i);
        this.dhC.setGravity(17);
        this.dhC.setVisibility(0);
        this.daA = new ValueAnimator();
        this.daA.setFloatValues(1.0f, 0.0f);
        this.daA.setDuration(400L);
        this.daA.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.game.strategy.view.g.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (g.this.dhC != null && valueAnimator != null) {
                    g.this.dhC.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.daA.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.game.strategy.view.g.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (g.this.dhC != null) {
                    g.this.aqP();
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

    public void aqP() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.daA != null) {
            this.daA.cancel();
        }
        if (this.dhC != null) {
            ViewParent parent = this.dhC.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.dhC);
            }
            this.dhC.setVisibility(8);
            this.dhC = null;
        }
    }

    public boolean isShowing() {
        return this.dhC != null && this.dhC.getVisibility() == 0;
    }

    public TextView asI() {
        return this.dhC;
    }

    public void asJ() {
        this.mHandler.removeCallbacks(this.dhD);
        this.mHandler.postDelayed(this.dhD, 2000L);
    }
}
