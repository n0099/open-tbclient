package com.baidu.tbadk.widget.horizontalpullview;

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
/* loaded from: classes20.dex */
public class PullLeftRefreshLayout extends FrameLayout {
    private com.baidu.tbadk.widget.horizontalpullview.a fdG;
    private View fdH;
    private int fdI;
    private int fdJ;
    private int fdK;
    private int fdL;
    private float fdM;
    private ValueAnimator fdN;
    private ValueAnimator fdO;
    private int fdP;
    private int fdQ;
    private float fdR;
    private a fdS;
    private boolean fdT;
    private int mLastX;
    private int mLastY;
    RecyclerView.OnScrollListener mOnScrollListener;
    private RecyclerView mRecyclerView;

    /* loaded from: classes20.dex */
    public interface a {
        void byd();
    }

    public PullLeftRefreshLayout(@NonNull Context context) {
        super(context);
        this.fdR = 0.0f;
        this.fdT = false;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1
            private boolean fdU = true;
            private int fdV = 0;
            private ValueAnimator fdW;
            private int state;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
                this.state = i;
                if (PullLeftRefreshLayout.this.fdT && this.state == 0 && !this.fdU) {
                    if (this.fdW != null) {
                        this.fdW.cancel();
                    }
                    int i2 = (int) (PullLeftRefreshLayout.this.fdM - 1.0f);
                    if (this.fdV > i2) {
                        this.fdV = i2;
                    }
                    this.fdW = ValueAnimator.ofInt(this.fdV, 0);
                    this.fdW.setDuration(100L);
                    this.fdW.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            PullLeftRefreshLayout.this.setTranslationStatus(-((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    this.fdW.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1.2
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                            onAnimationEnd(animator);
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            PullLeftRefreshLayout.this.bxZ();
                        }
                    });
                    this.fdW.start();
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
                this.fdV = i;
                if (!recyclerView.canScrollHorizontally(1) && i > 0) {
                    this.fdU = false;
                } else {
                    this.fdU = true;
                }
            }
        };
        init(context);
    }

    public PullLeftRefreshLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fdR = 0.0f;
        this.fdT = false;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1
            private boolean fdU = true;
            private int fdV = 0;
            private ValueAnimator fdW;
            private int state;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
                this.state = i;
                if (PullLeftRefreshLayout.this.fdT && this.state == 0 && !this.fdU) {
                    if (this.fdW != null) {
                        this.fdW.cancel();
                    }
                    int i2 = (int) (PullLeftRefreshLayout.this.fdM - 1.0f);
                    if (this.fdV > i2) {
                        this.fdV = i2;
                    }
                    this.fdW = ValueAnimator.ofInt(this.fdV, 0);
                    this.fdW.setDuration(100L);
                    this.fdW.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            PullLeftRefreshLayout.this.setTranslationStatus(-((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    this.fdW.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1.2
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                            onAnimationEnd(animator);
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            PullLeftRefreshLayout.this.bxZ();
                        }
                    });
                    this.fdW.start();
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
                this.fdV = i;
                if (!recyclerView.canScrollHorizontally(1) && i > 0) {
                    this.fdU = false;
                } else {
                    this.fdU = true;
                }
            }
        };
        init(context);
    }

    public PullLeftRefreshLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fdR = 0.0f;
        this.fdT = false;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1
            private boolean fdU = true;
            private int fdV = 0;
            private ValueAnimator fdW;
            private int state;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i2) {
                this.state = i2;
                if (PullLeftRefreshLayout.this.fdT && this.state == 0 && !this.fdU) {
                    if (this.fdW != null) {
                        this.fdW.cancel();
                    }
                    int i22 = (int) (PullLeftRefreshLayout.this.fdM - 1.0f);
                    if (this.fdV > i22) {
                        this.fdV = i22;
                    }
                    this.fdW = ValueAnimator.ofInt(this.fdV, 0);
                    this.fdW.setDuration(100L);
                    this.fdW.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            PullLeftRefreshLayout.this.setTranslationStatus(-((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    this.fdW.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1.2
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                            onAnimationEnd(animator);
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            PullLeftRefreshLayout.this.bxZ();
                        }
                    });
                    this.fdW.start();
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NonNull RecyclerView recyclerView, int i2, int i22) {
                this.fdV = i2;
                if (!recyclerView.canScrollHorizontally(1) && i2 > 0) {
                    this.fdU = false;
                } else {
                    this.fdU = true;
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
    }

    public void setCallback(a aVar) {
        this.fdS = aVar;
    }

    public void setRefreshViewAndListener(com.baidu.tbadk.widget.horizontalpullview.a aVar) {
        this.fdG = aVar;
        this.fdH = aVar.getView();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = GravityCompat.END;
        this.fdH.setLayoutParams(layoutParams);
        addView(this.fdH, 0);
    }

    public void setEnablePull(boolean z) {
        this.fdT = z;
    }

    public boolean bxX() {
        return this.fdT;
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
        if (this.fdH != null) {
            this.fdJ = this.fdH.getMeasuredWidth();
            this.fdL = this.fdJ * 2;
            this.fdK = this.fdJ + this.fdL;
            this.fdM = this.fdJ;
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.fdI == 0) {
            this.fdH.setTranslationX(this.fdJ);
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                this.fdP = x;
                this.mLastX = x;
                this.fdQ = y;
                this.mLastY = y;
                break;
            case 1:
            case 3:
                this.fdP = 0;
                this.fdQ = 0;
                break;
            case 2:
                int i = x - this.fdP;
                this.fdP = x;
                this.mLastX = x;
                this.fdQ = y;
                this.mLastY = y;
                if (Math.abs(i) > Math.abs(y - this.fdQ) && this.fdT && i < 0 && !byb() && this.fdI == 0) {
                    if (getParent() != null) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    this.fdI = 2;
                    if (this.fdG != null) {
                        this.fdG.bz(this.fdH);
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
        if (!this.fdT) {
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
                this.fdP = 0;
                this.mLastX = 0;
                this.fdQ = 0;
                this.mLastY = 0;
                if (Math.abs(this.fdR) < this.fdM) {
                    bxY();
                    return true;
                }
                bya();
                return true;
            case 2:
                int i = x - this.mLastX;
                this.mLastX = x;
                this.mLastY = y;
                this.fdR = ((1.0f - Math.abs(this.fdR / this.fdK)) * i) + this.fdR;
                if (this.fdR >= 0.0f) {
                    this.fdR = 0.0f;
                    this.mRecyclerView.setTranslationX(this.fdR);
                    if (this.fdG != null) {
                        this.fdG.bz(this.fdH);
                    }
                } else if (this.fdR <= (-this.fdK)) {
                    this.fdR = -this.fdK;
                    this.mRecyclerView.setTranslationX(this.fdR);
                    if (this.fdG != null) {
                        this.fdG.bA(this.fdH);
                    }
                } else {
                    this.mRecyclerView.setTranslationX(this.fdR);
                    if (Math.abs(this.fdR) > this.fdM) {
                        if (this.fdG != null) {
                            this.fdG.bA(this.fdH);
                        }
                    } else if (this.fdG != null) {
                        this.fdG.bz(this.fdH);
                    }
                }
                if (this.fdH != null) {
                    this.fdH.setTranslationX(this.fdJ + this.fdR);
                    return true;
                }
                return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void bxY() {
        if (this.fdN != null) {
            this.fdN.cancel();
        }
        this.fdN = ValueAnimator.ofFloat(Math.abs(this.fdR), 0.0f);
        this.fdN.setDuration(150L);
        this.fdN.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null) {
                    PullLeftRefreshLayout.this.setTranslationStatus(-((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.fdN.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PullLeftRefreshLayout.this.bxZ();
            }
        });
        this.fdN.start();
        if (this.fdH != null) {
            this.fdG.bz(this.fdH);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTranslationStatus(float f) {
        if (this.mRecyclerView != null) {
            this.mRecyclerView.setTranslationX(f);
        }
        if (this.fdH != null) {
            this.fdH.setTranslationX(this.fdJ + f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxZ() {
        this.fdI = 0;
        this.fdR = 0.0f;
        setTranslationStatus(0.0f);
    }

    private void bya() {
        if (this.fdO != null) {
            this.fdO.cancel();
        }
        this.fdO = ValueAnimator.ofFloat(Math.abs(this.fdR), 0.0f);
        this.fdO.setDuration(150L);
        this.fdO.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null) {
                    PullLeftRefreshLayout.this.setTranslationStatus(-((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.fdO.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PullLeftRefreshLayout.this.bxZ();
                PullLeftRefreshLayout.this.postDelayed(new Runnable() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PullLeftRefreshLayout.this.byc();
                    }
                }, 50L);
            }
        });
        this.fdO.start();
        if (this.fdH != null) {
            this.fdG.bz(this.fdH);
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

    public boolean byb() {
        return ViewCompat.canScrollHorizontally(this.mRecyclerView, 1);
    }

    public void byc() {
        if (this.fdS != null) {
            this.fdS.byd();
        }
    }
}
