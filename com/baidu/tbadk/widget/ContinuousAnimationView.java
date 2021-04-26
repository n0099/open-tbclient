package com.baidu.tbadk.widget;

import android.animation.Animator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class ContinuousAnimationView extends TBLottieAnimationView implements BdSwipeRefreshLayout.i {
    public boolean l;
    public boolean m;

    /* loaded from: classes3.dex */
    public class a implements Animator.AnimatorListener {
        public a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            ContinuousAnimationView.this.v();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ContinuousAnimationView.this.w();
            if (ContinuousAnimationView.this.m) {
                ContinuousAnimationView.this.m = false;
            }
            ContinuousAnimationView.this.l = false;
            ContinuousAnimationView.this.setFrame(0);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            ContinuousAnimationView.this.x();
            if (ContinuousAnimationView.this.m) {
                ContinuousAnimationView.this.cancelAnimation();
                ContinuousAnimationView.this.m = false;
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            ContinuousAnimationView.this.y();
            ContinuousAnimationView.this.l = true;
        }
    }

    public ContinuousAnimationView(Context context) {
        this(context, null);
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.i
    public void c() {
        if (isAnimating()) {
            cancelAnimation();
        }
    }

    @Override // com.baidu.tbadk.widget.lottie.TBLottieAnimationView, com.airbnb.lottie.LottieAnimationView
    public void cancelAnimation() {
        super.cancelAnimation();
    }

    @Override // android.view.View
    public void clearAnimation() {
        super.clearAnimation();
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.i
    public void d() {
        playAnimation();
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.i
    public void e(float f2, float f3) {
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.i
    public long getCompleteAnimTime() {
        return 0L;
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.i
    public View getView() {
        return null;
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.i
    public void k() {
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.i
    public void m() {
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.i
    public void onFinish() {
    }

    @Override // com.baidu.tbadk.widget.lottie.TBLottieAnimationView, com.airbnb.lottie.LottieAnimationView
    public void pauseAnimation() {
        if (this.l) {
            this.m = true;
        }
    }

    @Override // com.baidu.tbadk.widget.lottie.TBLottieAnimationView, com.airbnb.lottie.LottieAnimationView
    public void playAnimation() {
        if (isAnimating()) {
            cancelAnimation();
        }
        setAlpha(1.0f);
        super.playAnimation();
    }

    public final void v() {
    }

    public final void w() {
    }

    public final void x() {
    }

    public final void y() {
    }

    public final void z() {
        addAnimatorListener(new a());
        setAnimation(R.raw.lottie_common_pull_refresh);
        loop(true);
        setFrame(0);
    }

    public ContinuousAnimationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ContinuousAnimationView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.l = false;
        this.m = false;
        z();
    }
}
