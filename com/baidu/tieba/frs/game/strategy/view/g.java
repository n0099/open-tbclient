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
    private TextView hBf;
    private ValueAnimator hrJ;
    private Context mContext;
    private Runnable mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.g.3
        @Override // java.lang.Runnable
        public void run() {
            if (g.this.hBf != null && g.this.hBf.getParent() != null && g.this.hrJ != null) {
                g.this.hrJ.start();
            }
        }
    };
    private Handler mHandler = new Handler();

    public g(Context context) {
        this.mContext = context;
        bYY();
    }

    private void bYY() {
        this.hBf = new TextView(this.mContext);
        this.hBf.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(R.dimen.fontsize24));
        am.setBackgroundResource(this.hBf, R.color.cp_link_tip_a);
        am.setViewTextColor(this.hBf, (int) R.color.cp_cont_a);
        this.hBf.setGravity(17);
        this.hBf.setVisibility(0);
        this.hrJ = new ValueAnimator();
        this.hrJ.setFloatValues(1.0f, 0.0f);
        this.hrJ.setDuration(400L);
        this.hrJ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.game.strategy.view.g.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (g.this.hBf != null && valueAnimator != null) {
                    g.this.hBf.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.hrJ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.game.strategy.view.g.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (g.this.hBf != null) {
                    g.this.bXd();
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

    public void bXd() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.hrJ != null) {
            this.hrJ.cancel();
        }
        if (this.hBf != null) {
            ViewParent parent = this.hBf.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.hBf);
            }
            this.hBf.setVisibility(8);
            this.hBf = null;
        }
    }

    public boolean isShowing() {
        return this.hBf != null && this.hBf.getVisibility() == 0;
    }

    public TextView bYZ() {
        return this.hBf;
    }

    public void bZa() {
        this.mHandler.removeCallbacks(this.mHideRunnable);
        this.mHandler.postDelayed(this.mHideRunnable, 2000L);
    }
}
