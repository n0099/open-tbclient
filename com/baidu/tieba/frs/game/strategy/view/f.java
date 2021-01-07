package com.baidu.tieba.frs.game.strategy.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class f {
    private ValueAnimator jkq;
    private TextView jxB;
    private Context mContext;
    private Runnable mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.f.3
        @Override // java.lang.Runnable
        public void run() {
            if (f.this.jxB != null && f.this.jxB.getParent() != null && f.this.jkq != null) {
                f.this.jkq.start();
            }
        }
    };
    private Handler mHandler = new Handler();

    public f(Context context) {
        this.mContext = context;
        cKC();
    }

    private void cKC() {
        this.jxB = new TextView(this.mContext);
        this.jxB.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(R.dimen.fontsize24));
        ao.setBackgroundResource(this.jxB, R.color.CAM_X0302);
        ao.setViewTextColor(this.jxB, R.color.CAM_X0101);
        this.jxB.setGravity(17);
        this.jxB.setVisibility(0);
        this.jkq = new ValueAnimator();
        this.jkq.setFloatValues(1.0f, 0.0f);
        this.jkq.setDuration(400L);
        this.jkq.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.game.strategy.view.f.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (f.this.jxB != null && valueAnimator != null) {
                    f.this.jxB.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.jkq.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.game.strategy.view.f.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (f.this.jxB != null) {
                    f.this.cHw();
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

    public void cHw() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.jkq != null) {
            this.jkq.cancel();
        }
        if (this.jxB != null) {
            ViewParent parent = this.jxB.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.jxB);
            }
            this.jxB.setVisibility(8);
            this.jxB = null;
        }
    }

    public boolean isShowing() {
        return this.jxB != null && this.jxB.getVisibility() == 0;
    }

    public TextView cKD() {
        return this.jxB;
    }

    public void cKE() {
        this.mHandler.removeCallbacks(this.mHideRunnable);
        this.mHandler.postDelayed(this.mHideRunnable, 2000L);
    }
}
