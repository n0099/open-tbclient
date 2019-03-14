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
    private boolean ctQ;
    private boolean ctR;

    public ContinuousAnimationView(Context context) {
        this(context, null);
    }

    public ContinuousAnimationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ContinuousAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ctQ = false;
        this.ctR = false;
        init();
    }

    private void init() {
        a(new Animator.AnimatorListener() { // from class: com.baidu.tbadk.widget.ContinuousAnimationView.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ContinuousAnimationView.this.aqz();
                ContinuousAnimationView.this.ctQ = true;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ContinuousAnimationView.this.aqw();
                if (ContinuousAnimationView.this.ctR) {
                    ContinuousAnimationView.this.ctR = false;
                }
                ContinuousAnimationView.this.ctQ = false;
                ContinuousAnimationView.this.setFrame(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                ContinuousAnimationView.this.aqx();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                ContinuousAnimationView.this.aqy();
                if (ContinuousAnimationView.this.ctR) {
                    ContinuousAnimationView.this.cancelAnimation();
                    ContinuousAnimationView.this.ctR = false;
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
        if (this.ctQ) {
            this.ctR = true;
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
    public void aqw() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqx() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqy() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqz() {
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
