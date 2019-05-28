package com.baidu.tieba.frs.game.strategy.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class g {
    private TextView fBm;
    private ValueAnimator ftp;
    private Context mContext;
    private Runnable mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.g.3
        @Override // java.lang.Runnable
        public void run() {
            if (g.this.fBm != null && g.this.fBm.getParent() != null && g.this.ftp != null) {
                g.this.ftp.start();
            }
        }
    };
    private Handler mHandler = new Handler();

    public g(Context context) {
        this.mContext = context;
        bnE();
    }

    private void bnE() {
        this.fBm = new TextView(this.mContext);
        this.fBm.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(R.dimen.fontsize24));
        al.k(this.fBm, R.color.cp_btn_c);
        al.j(this.fBm, R.color.cp_btn_a);
        this.fBm.setGravity(17);
        this.fBm.setVisibility(0);
        this.ftp = new ValueAnimator();
        this.ftp.setFloatValues(1.0f, 0.0f);
        this.ftp.setDuration(400L);
        this.ftp.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.game.strategy.view.g.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (g.this.fBm != null && valueAnimator != null) {
                    g.this.fBm.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.ftp.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.game.strategy.view.g.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (g.this.fBm != null) {
                    g.this.blS();
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

    public void blS() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.ftp != null) {
            this.ftp.cancel();
        }
        if (this.fBm != null) {
            ViewParent parent = this.fBm.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.fBm);
            }
            this.fBm.setVisibility(8);
            this.fBm = null;
        }
    }

    public boolean isShowing() {
        return this.fBm != null && this.fBm.getVisibility() == 0;
    }

    public TextView bnF() {
        return this.fBm;
    }

    public void bnG() {
        this.mHandler.removeCallbacks(this.mHideRunnable);
        this.mHandler.postDelayed(this.mHideRunnable, 2000L);
    }
}
