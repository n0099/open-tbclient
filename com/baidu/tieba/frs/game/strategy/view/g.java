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
    private TextView gAS;
    private ValueAnimator gsC;
    private Context mContext;
    private Runnable mHideRunnable = new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.view.g.3
        @Override // java.lang.Runnable
        public void run() {
            if (g.this.gAS != null && g.this.gAS.getParent() != null && g.this.gsC != null) {
                g.this.gsC.start();
            }
        }
    };
    private Handler mHandler = new Handler();

    public g(Context context) {
        this.mContext = context;
        bHK();
    }

    private void bHK() {
        this.gAS = new TextView(this.mContext);
        this.gAS.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(R.dimen.fontsize24));
        am.setBackgroundResource(this.gAS, R.color.cp_link_tip_a);
        am.setViewTextColor(this.gAS, (int) R.color.cp_cont_a);
        this.gAS.setGravity(17);
        this.gAS.setVisibility(0);
        this.gsC = new ValueAnimator();
        this.gsC.setFloatValues(1.0f, 0.0f);
        this.gsC.setDuration(400L);
        this.gsC.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.game.strategy.view.g.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (g.this.gAS != null && valueAnimator != null) {
                    g.this.gAS.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.gsC.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.frs.game.strategy.view.g.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (g.this.gAS != null) {
                    g.this.bFS();
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

    public void bFS() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.gsC != null) {
            this.gsC.cancel();
        }
        if (this.gAS != null) {
            ViewParent parent = this.gAS.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.gAS);
            }
            this.gAS.setVisibility(8);
            this.gAS = null;
        }
    }

    public boolean isShowing() {
        return this.gAS != null && this.gAS.getVisibility() == 0;
    }

    public TextView bHL() {
        return this.gAS;
    }

    public void bHM() {
        this.mHandler.removeCallbacks(this.mHideRunnable);
        this.mHandler.postDelayed(this.mHideRunnable, 2000L);
    }
}
