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
/* loaded from: classes22.dex */
public class g {
    private TextView iEw;
    private ValueAnimator iue;
    private Context mContext;
    private Runnable mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.g.3
        @Override // java.lang.Runnable
        public void run() {
            if (g.this.iEw != null && g.this.iEw.getParent() != null && g.this.iue != null) {
                g.this.iue.start();
            }
        }
    };
    private Handler mHandler = new Handler();

    public g(Context context) {
        this.mContext = context;
        cxd();
    }

    private void cxd() {
        this.iEw = new TextView(this.mContext);
        this.iEw.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(R.dimen.fontsize24));
        ap.setBackgroundResource(this.iEw, R.color.cp_link_tip_a);
        ap.setViewTextColor(this.iEw, (int) R.color.cp_cont_a);
        this.iEw.setGravity(17);
        this.iEw.setVisibility(0);
        this.iue = new ValueAnimator();
        this.iue.setFloatValues(1.0f, 0.0f);
        this.iue.setDuration(400L);
        this.iue.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.game.strategy.view.g.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (g.this.iEw != null && valueAnimator != null) {
                    g.this.iEw.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.iue.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.game.strategy.view.g.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (g.this.iEw != null) {
                    g.this.cuY();
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

    public void cuY() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.iue != null) {
            this.iue.cancel();
        }
        if (this.iEw != null) {
            ViewParent parent = this.iEw.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.iEw);
            }
            this.iEw.setVisibility(8);
            this.iEw = null;
        }
    }

    public boolean isShowing() {
        return this.iEw != null && this.iEw.getVisibility() == 0;
    }

    public TextView cxe() {
        return this.iEw;
    }

    public void cxf() {
        this.mHandler.removeCallbacks(this.mHideRunnable);
        this.mHandler.postDelayed(this.mHideRunnable, 2000L);
    }
}
