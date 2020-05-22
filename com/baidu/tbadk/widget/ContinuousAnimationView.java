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
    private boolean evE;
    private boolean evF;

    public ContinuousAnimationView(Context context) {
        this(context, null);
    }

    public ContinuousAnimationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ContinuousAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.evE = false;
        this.evF = false;
        init();
    }

    private void init() {
        addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tbadk.widget.ContinuousAnimationView.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ContinuousAnimationView.this.bgZ();
                ContinuousAnimationView.this.evE = true;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ContinuousAnimationView.this.bgW();
                if (ContinuousAnimationView.this.evF) {
                    ContinuousAnimationView.this.evF = false;
                }
                ContinuousAnimationView.this.evE = false;
                ContinuousAnimationView.this.setFrame(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                ContinuousAnimationView.this.bgX();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                ContinuousAnimationView.this.bgY();
                if (ContinuousAnimationView.this.evF) {
                    ContinuousAnimationView.this.cancelAnimation();
                    ContinuousAnimationView.this.evF = false;
                }
            }
        });
        setAnimation(R.raw.lottie_pull_refresh);
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
        if (this.evE) {
            this.evF = true;
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
    public void bgW() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgX() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgY() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgZ() {
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
