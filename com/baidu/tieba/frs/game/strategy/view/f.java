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
    private ValueAnimator jfJ;
    private TextView jsV;
    private Context mContext;
    private Runnable mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.f.3
        @Override // java.lang.Runnable
        public void run() {
            if (f.this.jsV != null && f.this.jsV.getParent() != null && f.this.jfJ != null) {
                f.this.jfJ.start();
            }
        }
    };
    private Handler mHandler = new Handler();

    public f(Context context) {
        this.mContext = context;
        cGK();
    }

    private void cGK() {
        this.jsV = new TextView(this.mContext);
        this.jsV.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(R.dimen.fontsize24));
        ao.setBackgroundResource(this.jsV, R.color.CAM_X0302);
        ao.setViewTextColor(this.jsV, R.color.CAM_X0101);
        this.jsV.setGravity(17);
        this.jsV.setVisibility(0);
        this.jfJ = new ValueAnimator();
        this.jfJ.setFloatValues(1.0f, 0.0f);
        this.jfJ.setDuration(400L);
        this.jfJ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.game.strategy.view.f.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (f.this.jsV != null && valueAnimator != null) {
                    f.this.jsV.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.jfJ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.game.strategy.view.f.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (f.this.jsV != null) {
                    f.this.cDE();
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

    public void cDE() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.jfJ != null) {
            this.jfJ.cancel();
        }
        if (this.jsV != null) {
            ViewParent parent = this.jsV.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.jsV);
            }
            this.jsV.setVisibility(8);
            this.jsV = null;
        }
    }

    public boolean isShowing() {
        return this.jsV != null && this.jsV.getVisibility() == 0;
    }

    public TextView cGL() {
        return this.jsV;
    }

    public void cGM() {
        this.mHandler.removeCallbacks(this.mHideRunnable);
        this.mHandler.postDelayed(this.mHideRunnable, 2000L);
    }
}
