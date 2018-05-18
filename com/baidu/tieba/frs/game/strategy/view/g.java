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
    private ValueAnimator dbE;
    private TextView diG;
    private Context mContext;
    private Runnable diH = new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.g.3
        @Override // java.lang.Runnable
        public void run() {
            if (g.this.diG != null && g.this.diG.getParent() != null && g.this.dbE != null) {
                g.this.dbE.start();
            }
        }
    };
    private Handler mHandler = new Handler();

    public g(Context context) {
        this.mContext = context;
        asG();
    }

    private void asG() {
        this.diG = new TextView(this.mContext);
        this.diG.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(d.e.fontsize24));
        ak.i(this.diG, d.C0126d.common_color_10260);
        ak.h(this.diG, d.C0126d.cp_cont_i);
        this.diG.setGravity(17);
        this.diG.setVisibility(0);
        this.dbE = new ValueAnimator();
        this.dbE.setFloatValues(1.0f, 0.0f);
        this.dbE.setDuration(400L);
        this.dbE.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.game.strategy.view.g.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (g.this.diG != null && valueAnimator != null) {
                    g.this.diG.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.dbE.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.game.strategy.view.g.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (g.this.diG != null) {
                    g.this.aqO();
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

    public void aqO() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.dbE != null) {
            this.dbE.cancel();
        }
        if (this.diG != null) {
            ViewParent parent = this.diG.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.diG);
            }
            this.diG.setVisibility(8);
            this.diG = null;
        }
    }

    public boolean isShowing() {
        return this.diG != null && this.diG.getVisibility() == 0;
    }

    public TextView asH() {
        return this.diG;
    }

    public void asI() {
        this.mHandler.removeCallbacks(this.diH);
        this.mHandler.postDelayed(this.diH, 2000L);
    }
}
