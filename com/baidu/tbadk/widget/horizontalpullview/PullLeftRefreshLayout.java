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
/* loaded from: classes15.dex */
public class PullLeftRefreshLayout extends FrameLayout {
    private com.baidu.tbadk.widget.horizontalpullview.a faJ;
    private View faK;
    private int faL;
    private int faM;
    private int faN;
    private int faO;
    private float faP;
    private ValueAnimator faQ;
    private ValueAnimator faR;
    private int faS;
    private int faT;
    private float faU;
    private a faV;
    private boolean faW;
    private int mLastX;
    private int mLastY;
    RecyclerView.OnScrollListener mOnScrollListener;
    private RecyclerView mRecyclerView;

    /* loaded from: classes15.dex */
    public interface a {
        void bwT();
    }

    public PullLeftRefreshLayout(@NonNull Context context) {
        super(context);
        this.faU = 0.0f;
        this.faW = false;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1
            private boolean faX = true;
            private int faY = 0;
            private ValueAnimator faZ;
            private int state;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
                this.state = i;
                if (PullLeftRefreshLayout.this.faW && this.state == 0 && !this.faX) {
                    if (this.faZ != null) {
                        this.faZ.cancel();
                    }
                    int i2 = (int) (PullLeftRefreshLayout.this.faP - 1.0f);
                    if (this.faY > i2) {
                        this.faY = i2;
                    }
                    this.faZ = ValueAnimator.ofInt(this.faY, 0);
                    this.faZ.setDuration(100L);
                    this.faZ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            PullLeftRefreshLayout.this.setTranslationStatus(-((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    this.faZ.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1.2
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                            onAnimationEnd(animator);
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            PullLeftRefreshLayout.this.bwP();
                        }
                    });
                    this.faZ.start();
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
                this.faY = i;
                if (!recyclerView.canScrollHorizontally(1) && i > 0) {
                    this.faX = false;
                } else {
                    this.faX = true;
                }
            }
        };
        init(context);
    }

    public PullLeftRefreshLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.faU = 0.0f;
        this.faW = false;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1
            private boolean faX = true;
            private int faY = 0;
            private ValueAnimator faZ;
            private int state;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
                this.state = i;
                if (PullLeftRefreshLayout.this.faW && this.state == 0 && !this.faX) {
                    if (this.faZ != null) {
                        this.faZ.cancel();
                    }
                    int i2 = (int) (PullLeftRefreshLayout.this.faP - 1.0f);
                    if (this.faY > i2) {
                        this.faY = i2;
                    }
                    this.faZ = ValueAnimator.ofInt(this.faY, 0);
                    this.faZ.setDuration(100L);
                    this.faZ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            PullLeftRefreshLayout.this.setTranslationStatus(-((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    this.faZ.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1.2
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                            onAnimationEnd(animator);
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            PullLeftRefreshLayout.this.bwP();
                        }
                    });
                    this.faZ.start();
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
                this.faY = i;
                if (!recyclerView.canScrollHorizontally(1) && i > 0) {
                    this.faX = false;
                } else {
                    this.faX = true;
                }
            }
        };
        init(context);
    }

    public PullLeftRefreshLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.faU = 0.0f;
        this.faW = false;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1
            private boolean faX = true;
            private int faY = 0;
            private ValueAnimator faZ;
            private int state;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i2) {
                this.state = i2;
                if (PullLeftRefreshLayout.this.faW && this.state == 0 && !this.faX) {
                    if (this.faZ != null) {
                        this.faZ.cancel();
                    }
                    int i22 = (int) (PullLeftRefreshLayout.this.faP - 1.0f);
                    if (this.faY > i22) {
                        this.faY = i22;
                    }
                    this.faZ = ValueAnimator.ofInt(this.faY, 0);
                    this.faZ.setDuration(100L);
                    this.faZ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            PullLeftRefreshLayout.this.setTranslationStatus(-((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    this.faZ.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1.2
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                            onAnimationEnd(animator);
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            PullLeftRefreshLayout.this.bwP();
                        }
                    });
                    this.faZ.start();
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NonNull RecyclerView recyclerView, int i2, int i22) {
                this.faY = i2;
                if (!recyclerView.canScrollHorizontally(1) && i2 > 0) {
                    this.faX = false;
                } else {
                    this.faX = true;
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
    }

    public void setCallback(a aVar) {
        this.faV = aVar;
    }

    public void setRefreshViewAndListener(com.baidu.tbadk.widget.horizontalpullview.a aVar) {
        this.faJ = aVar;
        this.faK = aVar.getView();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = GravityCompat.END;
        this.faK.setLayoutParams(layoutParams);
        addView(this.faK, 0);
    }

    public void setEnablePull(boolean z) {
        this.faW = z;
    }

    public boolean bwN() {
        return this.faW;
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
        if (this.faK != null) {
            this.faM = this.faK.getMeasuredWidth();
            this.faO = this.faM * 2;
            this.faN = this.faM + this.faO;
            this.faP = this.faM;
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.faL == 0) {
            this.faK.setTranslationX(this.faM);
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                this.faS = x;
                this.mLastX = x;
                this.faT = y;
                this.mLastY = y;
                break;
            case 1:
            case 3:
                this.faS = 0;
                this.faT = 0;
                break;
            case 2:
                int i = x - this.faS;
                this.faS = x;
                this.mLastX = x;
                this.faT = y;
                this.mLastY = y;
                if (Math.abs(i) > Math.abs(y - this.faT) && this.faW && i < 0 && !bwR() && this.faL == 0) {
                    if (getParent() != null) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    this.faL = 2;
                    if (this.faJ != null) {
                        this.faJ.bv(this.faK);
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
        if (!this.faW) {
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
                this.faS = 0;
                this.mLastX = 0;
                this.faT = 0;
                this.mLastY = 0;
                if (Math.abs(this.faU) < this.faP) {
                    bwO();
                    return true;
                }
                bwQ();
                return true;
            case 2:
                int i = x - this.mLastX;
                this.mLastX = x;
                this.mLastY = y;
                this.faU = ((1.0f - Math.abs(this.faU / this.faN)) * i) + this.faU;
                if (this.faU >= 0.0f) {
                    this.faU = 0.0f;
                    this.mRecyclerView.setTranslationX(this.faU);
                    if (this.faJ != null) {
                        this.faJ.bv(this.faK);
                    }
                } else if (this.faU <= (-this.faN)) {
                    this.faU = -this.faN;
                    this.mRecyclerView.setTranslationX(this.faU);
                    if (this.faJ != null) {
                        this.faJ.bw(this.faK);
                    }
                } else {
                    this.mRecyclerView.setTranslationX(this.faU);
                    if (Math.abs(this.faU) > this.faP) {
                        if (this.faJ != null) {
                            this.faJ.bw(this.faK);
                        }
                    } else if (this.faJ != null) {
                        this.faJ.bv(this.faK);
                    }
                }
                if (this.faK != null) {
                    this.faK.setTranslationX(this.faM + this.faU);
                    return true;
                }
                return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void bwO() {
        if (this.faQ != null) {
            this.faQ.cancel();
        }
        this.faQ = ValueAnimator.ofFloat(Math.abs(this.faU), 0.0f);
        this.faQ.setDuration(150L);
        this.faQ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null) {
                    PullLeftRefreshLayout.this.setTranslationStatus(-((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.faQ.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PullLeftRefreshLayout.this.bwP();
            }
        });
        this.faQ.start();
        if (this.faK != null) {
            this.faJ.bv(this.faK);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTranslationStatus(float f) {
        if (this.mRecyclerView != null) {
            this.mRecyclerView.setTranslationX(f);
        }
        if (this.faK != null) {
            this.faK.setTranslationX(this.faM + f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwP() {
        this.faL = 0;
        this.faU = 0.0f;
        setTranslationStatus(0.0f);
    }

    private void bwQ() {
        if (this.faR != null) {
            this.faR.cancel();
        }
        this.faR = ValueAnimator.ofFloat(Math.abs(this.faU), 0.0f);
        this.faR.setDuration(150L);
        this.faR.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null) {
                    PullLeftRefreshLayout.this.setTranslationStatus(-((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.faR.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PullLeftRefreshLayout.this.bwP();
                PullLeftRefreshLayout.this.postDelayed(new Runnable() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PullLeftRefreshLayout.this.bwS();
                    }
                }, 50L);
            }
        });
        this.faR.start();
        if (this.faK != null) {
            this.faJ.bv(this.faK);
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

    public boolean bwR() {
        return ViewCompat.canScrollHorizontally(this.mRecyclerView, 1);
    }

    public void bwS() {
        if (this.faV != null) {
            this.faV.bwT();
        }
    }
}
