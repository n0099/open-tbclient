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
    private TextView jAy;
    private ValueAnimator jno;
    private Context mContext;
    private Runnable mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.f.3
        @Override // java.lang.Runnable
        public void run() {
            if (f.this.jAy != null && f.this.jAy.getParent() != null && f.this.jno != null) {
                f.this.jno.start();
            }
        }
    };
    private Handler mHandler = new Handler();

    public f(Context context) {
        this.mContext = context;
        cIk();
    }

    private void cIk() {
        this.jAy = new TextView(this.mContext);
        this.jAy.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(R.dimen.fontsize24));
        ap.setBackgroundResource(this.jAy, R.color.CAM_X0302);
        ap.setViewTextColor(this.jAy, R.color.CAM_X0101);
        this.jAy.setGravity(17);
        this.jAy.setVisibility(0);
        this.jno = new ValueAnimator();
        this.jno.setFloatValues(1.0f, 0.0f);
        this.jno.setDuration(400L);
        this.jno.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.game.strategy.view.f.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (f.this.jAy != null && valueAnimator != null) {
                    f.this.jAy.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.jno.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.game.strategy.view.f.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (f.this.jAy != null) {
                    f.this.cFd();
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

    public void cFd() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.jno != null) {
            this.jno.cancel();
        }
        if (this.jAy != null) {
            ViewParent parent = this.jAy.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.jAy);
            }
            this.jAy.setVisibility(8);
            this.jAy = null;
        }
    }

    public boolean isShowing() {
        return this.jAy != null && this.jAy.getVisibility() == 0;
    }

    public TextView cIl() {
        return this.jAy;
    }

    public void cIm() {
        this.mHandler.removeCallbacks(this.mHideRunnable);
        this.mHandler.postDelayed(this.mHideRunnable, 2000L);
    }
}
