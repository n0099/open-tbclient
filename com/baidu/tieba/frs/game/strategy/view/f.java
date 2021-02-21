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
    private ValueAnimator jlE;
    private TextView jyP;
    private Context mContext;
    private Runnable mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.f.3
        @Override // java.lang.Runnable
        public void run() {
            if (f.this.jyP != null && f.this.jyP.getParent() != null && f.this.jlE != null) {
                f.this.jlE.start();
            }
        }
    };
    private Handler mHandler = new Handler();

    public f(Context context) {
        this.mContext = context;
        cIe();
    }

    private void cIe() {
        this.jyP = new TextView(this.mContext);
        this.jyP.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(R.dimen.fontsize24));
        ap.setBackgroundResource(this.jyP, R.color.CAM_X0302);
        ap.setViewTextColor(this.jyP, R.color.CAM_X0101);
        this.jyP.setGravity(17);
        this.jyP.setVisibility(0);
        this.jlE = new ValueAnimator();
        this.jlE.setFloatValues(1.0f, 0.0f);
        this.jlE.setDuration(400L);
        this.jlE.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.game.strategy.view.f.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (f.this.jyP != null && valueAnimator != null) {
                    f.this.jyP.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.jlE.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.game.strategy.view.f.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (f.this.jyP != null) {
                    f.this.cEX();
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

    public void cEX() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.jlE != null) {
            this.jlE.cancel();
        }
        if (this.jyP != null) {
            ViewParent parent = this.jyP.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.jyP);
            }
            this.jyP.setVisibility(8);
            this.jyP = null;
        }
    }

    public boolean isShowing() {
        return this.jyP != null && this.jyP.getVisibility() == 0;
    }

    public TextView cIf() {
        return this.jyP;
    }

    public void cIg() {
        this.mHandler.removeCallbacks(this.mHideRunnable);
        this.mHandler.postDelayed(this.mHideRunnable, 2000L);
    }
}
