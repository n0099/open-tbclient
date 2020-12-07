package com.baidu.tbadk.widget;

import android.animation.Animator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ContinuousAnimationView extends TBLottieAnimationView implements BdSwipeRefreshLayout.b {
    private boolean fGw;
    private boolean fGx;

    public ContinuousAnimationView(Context context) {
        this(context, null);
    }

    public ContinuousAnimationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ContinuousAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fGw = false;
        this.fGx = false;
        init();
    }

    private void init() {
        addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tbadk.widget.ContinuousAnimationView.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ContinuousAnimationView.this.bHb();
                ContinuousAnimationView.this.fGw = true;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ContinuousAnimationView.this.bGY();
                if (ContinuousAnimationView.this.fGx) {
                    ContinuousAnimationView.this.fGx = false;
                }
                ContinuousAnimationView.this.fGw = false;
                ContinuousAnimationView.this.setFrame(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                ContinuousAnimationView.this.bGZ();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                ContinuousAnimationView.this.bHa();
                if (ContinuousAnimationView.this.fGx) {
                    ContinuousAnimationView.this.cancelAnimation();
                    ContinuousAnimationView.this.fGx = false;
                }
            }
        });
        setAnimation(R.raw.lottie_common_pull_refresh);
        loop(true);
        setFrame(0);
    }

    @Override // com.baidu.tbadk.widget.lottie.TBLottieAnimationView, com.airbnb.lottie.LottieAnimationView
    public void playAnimation() {
        if (isAnimating()) {
            cancelAnimation();
        }
        setAlpha(1.0f);
        super.playAnimation();
    }

    @Override // com.baidu.tbadk.widget.lottie.TBLottieAnimationView, com.airbnb.lottie.LottieAnimationView
    public void pauseAnimation() {
        if (this.fGw) {
            this.fGx = true;
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

    /* JADX INFO: Access modifiers changed from: private */
    public void bGY() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGZ() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHa() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHb() {
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void onPullToRefresh() {
        if (isAnimating()) {
            cancelAnimation();
        }
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void onReleaseToRefresh() {
        playAnimation();
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void onRefreshing() {
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void onCompleteRefresh() {
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void onFinish() {
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void onPullPercentChange(float f, float f2) {
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public long getCompleteAnimTime() {
        return 0L;
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public View getView() {
        return null;
    }
}
