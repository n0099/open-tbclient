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
/* loaded from: classes2.dex */
public class f {
    private ValueAnimator jlq;
    private TextView jyB;
    private Context mContext;
    private Runnable mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.f.3
        @Override // java.lang.Runnable
        public void run() {
            if (f.this.jyB != null && f.this.jyB.getParent() != null && f.this.jlq != null) {
                f.this.jlq.start();
            }
        }
    };
    private Handler mHandler = new Handler();

    public f(Context context) {
        this.mContext = context;
        cHX();
    }

    private void cHX() {
        this.jyB = new TextView(this.mContext);
        this.jyB.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(R.dimen.fontsize24));
        ap.setBackgroundResource(this.jyB, R.color.CAM_X0302);
        ap.setViewTextColor(this.jyB, R.color.CAM_X0101);
        this.jyB.setGravity(17);
        this.jyB.setVisibility(0);
        this.jlq = new ValueAnimator();
        this.jlq.setFloatValues(1.0f, 0.0f);
        this.jlq.setDuration(400L);
        this.jlq.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.game.strategy.view.f.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (f.this.jyB != null && valueAnimator != null) {
                    f.this.jyB.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.jlq.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.game.strategy.view.f.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (f.this.jyB != null) {
                    f.this.cEQ();
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

    public void cEQ() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.jlq != null) {
            this.jlq.cancel();
        }
        if (this.jyB != null) {
            ViewParent parent = this.jyB.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.jyB);
            }
            this.jyB.setVisibility(8);
            this.jyB = null;
        }
    }

    public boolean isShowing() {
        return this.jyB != null && this.jyB.getVisibility() == 0;
    }

    public TextView cHY() {
        return this.jyB;
    }

    public void cHZ() {
        this.mHandler.removeCallbacks(this.mHideRunnable);
        this.mHandler.postDelayed(this.mHideRunnable, 2000L);
    }
}
