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
    private ValueAnimator dHA;
    private TextView dOR;
    private Context mContext;
    private Runnable dOS = new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.h.3
        @Override // java.lang.Runnable
        public void run() {
            if (h.this.dOR != null && h.this.dOR.getParent() != null && h.this.dHA != null) {
                h.this.dHA.start();
            }
        }
    };
    private Handler mHandler = new Handler();

    public h(Context context) {
        this.mContext = context;
        aya();
    }

    private void aya() {
        this.dOR = new TextView(this.mContext);
        this.dOR.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(d.e.fontsize24));
        aj.s(this.dOR, d.C0141d.common_color_10260);
        aj.r(this.dOR, d.C0141d.cp_cont_i);
        this.dOR.setGravity(17);
        this.dOR.setVisibility(0);
        this.dHA = new ValueAnimator();
        this.dHA.setFloatValues(1.0f, 0.0f);
        this.dHA.setDuration(400L);
        this.dHA.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.game.strategy.view.h.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (h.this.dOR != null && valueAnimator != null) {
                    h.this.dOR.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.dHA.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.game.strategy.view.h.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (h.this.dOR != null) {
                    h.this.awu();
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

    public void awu() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.dHA != null) {
            this.dHA.cancel();
        }
        if (this.dOR != null) {
            ViewParent parent = this.dOR.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.dOR);
            }
            this.dOR.setVisibility(8);
            this.dOR = null;
        }
    }

    public boolean isShowing() {
        return this.dOR != null && this.dOR.getVisibility() == 0;
    }

    public TextView ayb() {
        return this.dOR;
    }

    public void ayc() {
        this.mHandler.removeCallbacks(this.dOS);
        this.mHandler.postDelayed(this.dOS, 2000L);
    }
}
