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
    private ValueAnimator daw;
    private TextView dhz;
    private Context mContext;
    private Runnable dhA = new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.g.3
        @Override // java.lang.Runnable
        public void run() {
            if (g.this.dhz != null && g.this.dhz.getParent() != null && g.this.daw != null) {
                g.this.daw.start();
            }
        }
    };
    private Handler mHandler = new Handler();

    public g(Context context) {
        this.mContext = context;
        asH();
    }

    private void asH() {
        this.dhz = new TextView(this.mContext);
        this.dhz.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(d.e.fontsize24));
        ak.i(this.dhz, d.C0126d.common_color_10260);
        ak.h(this.dhz, d.C0126d.cp_cont_i);
        this.dhz.setGravity(17);
        this.dhz.setVisibility(0);
        this.daw = new ValueAnimator();
        this.daw.setFloatValues(1.0f, 0.0f);
        this.daw.setDuration(400L);
        this.daw.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.game.strategy.view.g.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (g.this.dhz != null && valueAnimator != null) {
                    g.this.dhz.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.daw.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.game.strategy.view.g.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (g.this.dhz != null) {
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
        if (this.daw != null) {
            this.daw.cancel();
        }
        if (this.dhz != null) {
            ViewParent parent = this.dhz.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.dhz);
            }
            this.dhz.setVisibility(8);
            this.dhz = null;
        }
    }

    public boolean isShowing() {
        return this.dhz != null && this.dhz.getVisibility() == 0;
    }

    public TextView asI() {
        return this.dhz;
    }

    public void asJ() {
        this.mHandler.removeCallbacks(this.dhA);
        this.mHandler.postDelayed(this.dhA, 2000L);
    }
}
