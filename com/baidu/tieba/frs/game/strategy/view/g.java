package com.baidu.tieba.frs.game.strategy.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class g {
    private ValueAnimator hcK;
    private TextView hlE;
    private Context mContext;
    private Runnable mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.g.3
        @Override // java.lang.Runnable
        public void run() {
            if (g.this.hlE != null && g.this.hlE.getParent() != null && g.this.hcK != null) {
                g.this.hcK.start();
            }
        }
    };
    private Handler mHandler = new Handler();

    public g(Context context) {
        this.mContext = context;
        bSu();
    }

    private void bSu() {
        this.hlE = new TextView(this.mContext);
        this.hlE.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(R.dimen.fontsize24));
        am.setBackgroundResource(this.hlE, R.color.cp_link_tip_a);
        am.setViewTextColor(this.hlE, (int) R.color.cp_cont_a);
        this.hlE.setGravity(17);
        this.hlE.setVisibility(0);
        this.hcK = new ValueAnimator();
        this.hcK.setFloatValues(1.0f, 0.0f);
        this.hcK.setDuration(400L);
        this.hcK.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.game.strategy.view.g.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (g.this.hlE != null && valueAnimator != null) {
                    g.this.hlE.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.hcK.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.game.strategy.view.g.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (g.this.hlE != null) {
                    g.this.bQE();
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

    public void bQE() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.hcK != null) {
            this.hcK.cancel();
        }
        if (this.hlE != null) {
            ViewParent parent = this.hlE.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.hlE);
            }
            this.hlE.setVisibility(8);
            this.hlE = null;
        }
    }

    public boolean isShowing() {
        return this.hlE != null && this.hlE.getVisibility() == 0;
    }

    public TextView bSv() {
        return this.hlE;
    }

    public void bSw() {
        this.mHandler.removeCallbacks(this.mHideRunnable);
        this.mHandler.postDelayed(this.mHideRunnable, 2000L);
    }
}
