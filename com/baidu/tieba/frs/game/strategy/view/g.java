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
    private TextView gCc;
    private ValueAnimator gtt;
    private Context mContext;
    private Runnable mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.g.3
        @Override // java.lang.Runnable
        public void run() {
            if (g.this.gCc != null && g.this.gCc.getParent() != null && g.this.gtt != null) {
                g.this.gtt.start();
            }
        }
    };
    private Handler mHandler = new Handler();

    public g(Context context) {
        this.mContext = context;
        bHX();
    }

    private void bHX() {
        this.gCc = new TextView(this.mContext);
        this.gCc.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(R.dimen.fontsize24));
        am.setBackgroundResource(this.gCc, R.color.cp_link_tip_a);
        am.setViewTextColor(this.gCc, (int) R.color.cp_cont_a);
        this.gCc.setGravity(17);
        this.gCc.setVisibility(0);
        this.gtt = new ValueAnimator();
        this.gtt.setFloatValues(1.0f, 0.0f);
        this.gtt.setDuration(400L);
        this.gtt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.game.strategy.view.g.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (g.this.gCc != null && valueAnimator != null) {
                    g.this.gCc.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.gtt.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.game.strategy.view.g.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (g.this.gCc != null) {
                    g.this.bGe();
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

    public void bGe() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.gtt != null) {
            this.gtt.cancel();
        }
        if (this.gCc != null) {
            ViewParent parent = this.gCc.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.gCc);
            }
            this.gCc.setVisibility(8);
            this.gCc = null;
        }
    }

    public boolean isShowing() {
        return this.gCc != null && this.gCc.getVisibility() == 0;
    }

    public TextView bHY() {
        return this.gCc;
    }

    public void bHZ() {
        this.mHandler.removeCallbacks(this.mHideRunnable);
        this.mHandler.postDelayed(this.mHideRunnable, 2000L);
    }
}
