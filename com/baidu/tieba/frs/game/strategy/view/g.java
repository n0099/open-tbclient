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
    private ValueAnimator iNk;
    private TextView iXB;
    private Context mContext;
    private Runnable mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.g.3
        @Override // java.lang.Runnable
        public void run() {
            if (g.this.iXB != null && g.this.iXB.getParent() != null && g.this.iNk != null) {
                g.this.iNk.start();
            }
        }
    };
    private Handler mHandler = new Handler();

    public g(Context context) {
        this.mContext = context;
        cCp();
    }

    private void cCp() {
        this.iXB = new TextView(this.mContext);
        this.iXB.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(R.dimen.fontsize24));
        ap.setBackgroundResource(this.iXB, R.color.CAM_X0302);
        ap.setViewTextColor(this.iXB, (int) R.color.CAM_X0101);
        this.iXB.setGravity(17);
        this.iXB.setVisibility(0);
        this.iNk = new ValueAnimator();
        this.iNk.setFloatValues(1.0f, 0.0f);
        this.iNk.setDuration(400L);
        this.iNk.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.game.strategy.view.g.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (g.this.iXB != null && valueAnimator != null) {
                    g.this.iXB.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.iNk.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.game.strategy.view.g.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (g.this.iXB != null) {
                    g.this.cAj();
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

    public void cAj() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.iNk != null) {
            this.iNk.cancel();
        }
        if (this.iXB != null) {
            ViewParent parent = this.iXB.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.iXB);
            }
            this.iXB.setVisibility(8);
            this.iXB = null;
        }
    }

    public boolean isShowing() {
        return this.iXB != null && this.iXB.getVisibility() == 0;
    }

    public TextView cCq() {
        return this.iXB;
    }

    public void cCr() {
        this.mHandler.removeCallbacks(this.mHideRunnable);
        this.mHandler.postDelayed(this.mHideRunnable, 2000L);
    }
}
