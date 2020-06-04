package com.baidu.tieba.enterForum.view.horizontalpullview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
/* loaded from: classes9.dex */
public class PullLeftRefreshLayout extends FrameLayout {
    private com.baidu.tieba.enterForum.view.horizontalpullview.a gYG;
    private View gYH;
    private int gYI;
    private int gYJ;
    private int gYK;
    private int gYL;
    private float gYM;
    private ValueAnimator gYN;
    private ValueAnimator gYO;
    private int gYP;
    private int gYQ;
    private float gYR;
    private a gYS;
    private boolean gYT;
    private int mLastX;
    private int mLastY;
    RecyclerView.OnScrollListener mOnScrollListener;
    private RecyclerView mRecyclerView;

    /* loaded from: classes9.dex */
    public interface a {
        void bQI();
    }

    public PullLeftRefreshLayout(@NonNull Context context) {
        super(context);
        this.gYR = 0.0f;
        this.gYT = false;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.view.horizontalpullview.PullLeftRefreshLayout.1
            private boolean gYU = true;
            private int gYV = 0;
            private ValueAnimator gYW;
            private int state;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
                this.state = i;
                if (PullLeftRefreshLayout.this.gYT && this.state == 0 && !this.gYU) {
                    if (this.gYW != null) {
                        this.gYW.cancel();
                    }
                    int i2 = (int) (PullLeftRefreshLayout.this.gYM - 1.0f);
                    if (this.gYV > i2) {
                        this.gYV = i2;
                    }
                    this.gYW = ValueAnimator.ofInt(this.gYV, 0);
                    this.gYW.setDuration(100L);
                    this.gYW.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.view.horizontalpullview.PullLeftRefreshLayout.1.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            PullLeftRefreshLayout.this.setTranslationStatus(-((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    this.gYW.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.enterForum.view.horizontalpullview.PullLeftRefreshLayout.1.2
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                            onAnimationEnd(animator);
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            PullLeftRefreshLayout.this.bQL();
                        }
                    });
                    this.gYW.start();
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
                this.gYV = i;
                if (!recyclerView.canScrollHorizontally(1) && i > 0) {
                    this.gYU = false;
                } else {
                    this.gYU = true;
                }
            }
        };
        init(context);
    }

    public PullLeftRefreshLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gYR = 0.0f;
        this.gYT = false;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.view.horizontalpullview.PullLeftRefreshLayout.1
            private boolean gYU = true;
            private int gYV = 0;
            private ValueAnimator gYW;
            private int state;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
                this.state = i;
                if (PullLeftRefreshLayout.this.gYT && this.state == 0 && !this.gYU) {
                    if (this.gYW != null) {
                        this.gYW.cancel();
                    }
                    int i2 = (int) (PullLeftRefreshLayout.this.gYM - 1.0f);
                    if (this.gYV > i2) {
                        this.gYV = i2;
                    }
                    this.gYW = ValueAnimator.ofInt(this.gYV, 0);
                    this.gYW.setDuration(100L);
                    this.gYW.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.view.horizontalpullview.PullLeftRefreshLayout.1.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            PullLeftRefreshLayout.this.setTranslationStatus(-((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    this.gYW.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.enterForum.view.horizontalpullview.PullLeftRefreshLayout.1.2
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                            onAnimationEnd(animator);
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            PullLeftRefreshLayout.this.bQL();
                        }
                    });
                    this.gYW.start();
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
                this.gYV = i;
                if (!recyclerView.canScrollHorizontally(1) && i > 0) {
                    this.gYU = false;
                } else {
                    this.gYU = true;
                }
            }
        };
        init(context);
    }

    public PullLeftRefreshLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gYR = 0.0f;
        this.gYT = false;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.view.horizontalpullview.PullLeftRefreshLayout.1
            private boolean gYU = true;
            private int gYV = 0;
            private ValueAnimator gYW;
            private int state;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i2) {
                this.state = i2;
                if (PullLeftRefreshLayout.this.gYT && this.state == 0 && !this.gYU) {
                    if (this.gYW != null) {
                        this.gYW.cancel();
                    }
                    int i22 = (int) (PullLeftRefreshLayout.this.gYM - 1.0f);
                    if (this.gYV > i22) {
                        this.gYV = i22;
                    }
                    this.gYW = ValueAnimator.ofInt(this.gYV, 0);
                    this.gYW.setDuration(100L);
                    this.gYW.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.view.horizontalpullview.PullLeftRefreshLayout.1.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            PullLeftRefreshLayout.this.setTranslationStatus(-((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    this.gYW.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.enterForum.view.horizontalpullview.PullLeftRefreshLayout.1.2
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                            onAnimationEnd(animator);
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            PullLeftRefreshLayout.this.bQL();
                        }
                    });
                    this.gYW.start();
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NonNull RecyclerView recyclerView, int i2, int i22) {
                this.gYV = i2;
                if (!recyclerView.canScrollHorizontally(1) && i2 > 0) {
                    this.gYU = false;
                } else {
                    this.gYU = true;
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
    }

    public void setCallback(a aVar) {
        this.gYS = aVar;
    }

    public void setRefreshViewAndListener(com.baidu.tieba.enterForum.view.horizontalpullview.a aVar) {
        this.gYG = aVar;
        this.gYH = aVar.getView();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = GravityCompat.END;
        this.gYH.setLayoutParams(layoutParams);
        addView(this.gYH, 0);
    }

    public void setEnablePull(boolean z) {
        this.gYT = z;
    }

    public boolean bQJ() {
        return this.gYT;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < getChildCount()) {
                View childAt = getChildAt(i2);
                if (childAt instanceof RecyclerView) {
                    this.mRecyclerView = (RecyclerView) childAt;
                    if (this.mRecyclerView != null) {
                        this.mRecyclerView.addOnScrollListener(this.mOnScrollListener);
                    }
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.gYH != null) {
            this.gYJ = this.gYH.getMeasuredWidth();
            this.gYL = this.gYJ * 2;
            this.gYK = this.gYJ + this.gYL;
            this.gYM = this.gYJ;
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.gYI == 0) {
            this.gYH.setTranslationX(this.gYJ);
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                this.gYP = x;
                this.mLastX = x;
                this.gYQ = y;
                this.mLastY = y;
                break;
            case 1:
            case 3:
                this.gYP = 0;
                this.gYQ = 0;
                break;
            case 2:
                int i = x - this.gYP;
                this.gYP = x;
                this.mLastX = x;
                this.gYQ = y;
                this.mLastY = y;
                if (Math.abs(i) > Math.abs(y - this.gYQ) && this.gYT && i < 0 && !bQN() && this.gYI == 0) {
                    if (getParent() != null) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    this.gYI = 2;
                    if (this.gYG != null) {
                        this.gYG.bT(this.gYH);
                        return true;
                    }
                    return true;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.gYT) {
            return super.onTouchEvent(motionEvent);
        }
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                this.mLastX = x;
                this.mLastY = y;
                break;
            case 1:
            case 3:
                this.gYP = 0;
                this.mLastX = 0;
                this.gYQ = 0;
                this.mLastY = 0;
                if (Math.abs(this.gYR) < this.gYM) {
                    bQK();
                    return true;
                }
                bQM();
                return true;
            case 2:
                int i = x - this.mLastX;
                this.mLastX = x;
                this.mLastY = y;
                this.gYR = ((1.0f - Math.abs(this.gYR / this.gYK)) * i) + this.gYR;
                if (this.gYR >= 0.0f) {
                    this.gYR = 0.0f;
                    this.mRecyclerView.setTranslationX(this.gYR);
                    if (this.gYG != null) {
                        this.gYG.bT(this.gYH);
                    }
                } else if (this.gYR <= (-this.gYK)) {
                    this.gYR = -this.gYK;
                    this.mRecyclerView.setTranslationX(this.gYR);
                    if (this.gYG != null) {
                        this.gYG.bU(this.gYH);
                    }
                } else {
                    this.mRecyclerView.setTranslationX(this.gYR);
                    if (Math.abs(this.gYR) > this.gYM) {
                        if (this.gYG != null) {
                            this.gYG.bU(this.gYH);
                        }
                    } else if (this.gYG != null) {
                        this.gYG.bT(this.gYH);
                    }
                }
                if (this.gYH != null) {
                    this.gYH.setTranslationX(this.gYJ + this.gYR);
                    return true;
                }
                return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void bQK() {
        if (this.gYN != null) {
            this.gYN.cancel();
        }
        this.gYN = ValueAnimator.ofFloat(Math.abs(this.gYR), 0.0f);
        this.gYN.setDuration(150L);
        this.gYN.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.view.horizontalpullview.PullLeftRefreshLayout.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null) {
                    PullLeftRefreshLayout.this.setTranslationStatus(-((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.gYN.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.enterForum.view.horizontalpullview.PullLeftRefreshLayout.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PullLeftRefreshLayout.this.bQL();
            }
        });
        this.gYN.start();
        if (this.gYH != null) {
            this.gYG.bT(this.gYH);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTranslationStatus(float f) {
        if (this.mRecyclerView != null) {
            this.mRecyclerView.setTranslationX(f);
        }
        if (this.gYH != null) {
            this.gYH.setTranslationX(this.gYJ + f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQL() {
        this.gYI = 0;
        this.gYR = 0.0f;
        setTranslationStatus(0.0f);
    }

    private void bQM() {
        if (this.gYO != null) {
            this.gYO.cancel();
        }
        this.gYO = ValueAnimator.ofFloat(Math.abs(this.gYR), 0.0f);
        this.gYO.setDuration(150L);
        this.gYO.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.view.horizontalpullview.PullLeftRefreshLayout.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null) {
                    PullLeftRefreshLayout.this.setTranslationStatus(-((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.gYO.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.enterForum.view.horizontalpullview.PullLeftRefreshLayout.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PullLeftRefreshLayout.this.bQL();
                PullLeftRefreshLayout.this.postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.view.horizontalpullview.PullLeftRefreshLayout.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PullLeftRefreshLayout.this.bQO();
                    }
                }, 50L);
            }
        });
        this.gYO.start();
        if (this.gYH != null) {
            this.gYG.bT(this.gYH);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mRecyclerView != null) {
            this.mRecyclerView.addOnScrollListener(this.mOnScrollListener);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mRecyclerView != null) {
            this.mRecyclerView.removeOnScrollListener(this.mOnScrollListener);
        }
    }

    public boolean bQN() {
        return ViewCompat.canScrollHorizontally(this.mRecyclerView, 1);
    }

    public void bQO() {
        if (this.gYS != null) {
            this.gYS.bQI();
        }
    }
}
