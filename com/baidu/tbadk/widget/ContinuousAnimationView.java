package com.baidu.tbadk.widget;

import android.animation.Animator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class ContinuousAnimationView extends TBLottieAnimationView implements BdSwipeRefreshLayout.b {
    private boolean ctT;
    private boolean ctU;

    public ContinuousAnimationView(Context context) {
        this(context, null);
    }

    public ContinuousAnimationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ContinuousAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ctT = false;
        this.ctU = false;
        init();
    }

    private void init() {
        a(new Animator.AnimatorListener() { // from class: com.baidu.tbadk.widget.ContinuousAnimationView.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ContinuousAnimationView.this.aqw();
                ContinuousAnimationView.this.ctT = true;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ContinuousAnimationView.this.aqt();
                if (ContinuousAnimationView.this.ctU) {
                    ContinuousAnimationView.this.ctU = false;
                }
                ContinuousAnimationView.this.ctT = false;
                ContinuousAnimationView.this.setFrame(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                ContinuousAnimationView.this.aqu();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                ContinuousAnimationView.this.aqv();
                if (ContinuousAnimationView.this.ctU) {
                    ContinuousAnimationView.this.cancelAnimation();
                    ContinuousAnimationView.this.ctU = false;
                }
            }
        });
        setAnimation(d.i.refresh_load);
        G(true);
        setFrame(0);
    }

    @Override // com.baidu.tbadk.widget.lottie.TBLottieAnimationView, com.airbnb.lottie.LottieAnimationView
    public void cu() {
        if (isAnimating()) {
            cancelAnimation();
        }
        setAlpha(1.0f);
        super.cu();
    }

    @Override // com.baidu.tbadk.widget.lottie.TBLottieAnimationView, com.airbnb.lottie.LottieAnimationView
    public void cw() {
        if (this.ctT) {
            this.ctU = true;
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
    public void aqt() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqu() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqv() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqw() {
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void onPullToRefresh() {
        if (isAnimating()) {
            cancelAnimation();
        }
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void onReleaseToRefresh() {
        cu();
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void onRefreshing() {
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
    public void oP() {
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
