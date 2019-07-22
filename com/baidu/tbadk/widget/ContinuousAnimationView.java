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
    private boolean cDv;
    private boolean cDw;

    public ContinuousAnimationView(Context context) {
        this(context, null);
    }

    public ContinuousAnimationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ContinuousAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cDv = false;
        this.cDw = false;
        init();
    }

    private void init() {
        a(new Animator.AnimatorListener() { // from class: com.baidu.tbadk.widget.ContinuousAnimationView.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ContinuousAnimationView.this.awM();
                ContinuousAnimationView.this.cDv = true;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ContinuousAnimationView.this.awJ();
                if (ContinuousAnimationView.this.cDw) {
                    ContinuousAnimationView.this.cDw = false;
                }
                ContinuousAnimationView.this.cDv = false;
                ContinuousAnimationView.this.setFrame(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                ContinuousAnimationView.this.awK();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                ContinuousAnimationView.this.awL();
                if (ContinuousAnimationView.this.cDw) {
                    ContinuousAnimationView.this.cancelAnimation();
                    ContinuousAnimationView.this.cDw = false;
                }
            }
        });
        setAnimation(R.raw.refresh_load);
        y(true);
        setFrame(0);
    }

    @Override // com.baidu.tbadk.widget.lottie.TBLottieAnimationView, com.airbnb.lottie.LottieAnimationView
    public void br() {
        if (isAnimating()) {
            cancelAnimation();
        }
        setAlpha(1.0f);
        super.br();
    }

    @Override // com.baidu.tbadk.widget.lottie.TBLottieAnimationView, com.airbnb.lottie.LottieAnimationView
    public void bt() {
        if (this.cDv) {
            this.cDw = true;
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
    public void awJ() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awK() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awL() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awM() {
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void onPullToRefresh() {
        if (isAnimating()) {
            cancelAnimation();
        }
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void onReleaseToRefresh() {
        br();
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void onRefreshing() {
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void oc() {
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void onFinish() {
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void n(float f, float f2) {
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
