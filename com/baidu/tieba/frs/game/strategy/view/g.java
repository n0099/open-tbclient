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
/* loaded from: classes7.dex */
public class g {
    private ValueAnimator gqz;
    private TextView gyQ;
    private Context mContext;
    private Runnable mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.g.3
        @Override // java.lang.Runnable
        public void run() {
            if (g.this.gyQ != null && g.this.gyQ.getParent() != null && g.this.gqz != null) {
                g.this.gqz.start();
            }
        }
    };
    private Handler mHandler = new Handler();

    public g(Context context) {
        this.mContext = context;
        bGg();
    }

    private void bGg() {
        this.gyQ = new TextView(this.mContext);
        this.gyQ.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(R.dimen.fontsize24));
        am.setBackgroundResource(this.gyQ, R.color.cp_link_tip_a);
        am.setViewTextColor(this.gyQ, (int) R.color.cp_cont_a);
        this.gyQ.setGravity(17);
        this.gyQ.setVisibility(0);
        this.gqz = new ValueAnimator();
        this.gqz.setFloatValues(1.0f, 0.0f);
        this.gqz.setDuration(400L);
        this.gqz.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.game.strategy.view.g.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (g.this.gyQ != null && valueAnimator != null) {
                    g.this.gyQ.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.gqz.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.game.strategy.view.g.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (g.this.gyQ != null) {
                    g.this.bEo();
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

    public void bEo() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.gqz != null) {
            this.gqz.cancel();
        }
        if (this.gyQ != null) {
            ViewParent parent = this.gyQ.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.gyQ);
            }
            this.gyQ.setVisibility(8);
            this.gyQ = null;
        }
    }

    public boolean isShowing() {
        return this.gyQ != null && this.gyQ.getVisibility() == 0;
    }

    public TextView bGh() {
        return this.gyQ;
    }

    public void bGi() {
        this.mHandler.removeCallbacks(this.mHideRunnable);
        this.mHandler.postDelayed(this.mHideRunnable, 2000L);
    }
}
