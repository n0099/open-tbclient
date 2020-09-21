package com.baidu.tieba.frs.game.strategy.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class g {
    private ValueAnimator ifh;
    private TextView ipD;
    private Context mContext;
    private Runnable mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.g.3
        @Override // java.lang.Runnable
        public void run() {
            if (g.this.ipD != null && g.this.ipD.getParent() != null && g.this.ifh != null) {
                g.this.ifh.start();
            }
        }
    };
    private Handler mHandler = new Handler();

    public g(Context context) {
        this.mContext = context;
        ctG();
    }

    private void ctG() {
        this.ipD = new TextView(this.mContext);
        this.ipD.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(R.dimen.fontsize24));
        ap.setBackgroundResource(this.ipD, R.color.cp_link_tip_a);
        ap.setViewTextColor(this.ipD, (int) R.color.cp_cont_a);
        this.ipD.setGravity(17);
        this.ipD.setVisibility(0);
        this.ifh = new ValueAnimator();
        this.ifh.setFloatValues(1.0f, 0.0f);
        this.ifh.setDuration(400L);
        this.ifh.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.game.strategy.view.g.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (g.this.ipD != null && valueAnimator != null) {
                    g.this.ipD.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.ifh.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.game.strategy.view.g.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (g.this.ipD != null) {
                    g.this.crA();
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

    public void crA() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.ifh != null) {
            this.ifh.cancel();
        }
        if (this.ipD != null) {
            ViewParent parent = this.ipD.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.ipD);
            }
            this.ipD.setVisibility(8);
            this.ipD = null;
        }
    }

    public boolean isShowing() {
        return this.ipD != null && this.ipD.getVisibility() == 0;
    }

    public TextView ctH() {
        return this.ipD;
    }

    public void ctI() {
        this.mHandler.removeCallbacks(this.mHideRunnable);
        this.mHandler.postDelayed(this.mHideRunnable, 2000L);
    }
}
