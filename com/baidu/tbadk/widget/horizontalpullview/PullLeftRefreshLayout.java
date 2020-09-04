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
    private com.baidu.tbadk.widget.horizontalpullview.a faN;
    private View faO;
    private int faP;
    private int faQ;
    private int faR;
    private int faS;
    private float faT;
    private ValueAnimator faU;
    private ValueAnimator faV;
    private int faW;
    private int faX;
    private float faY;
    private a faZ;
    private boolean fba;
    private int mLastX;
    private int mLastY;
    RecyclerView.OnScrollListener mOnScrollListener;
    private RecyclerView mRecyclerView;

    /* loaded from: classes15.dex */
    public interface a {
        void bwU();
    }

    public PullLeftRefreshLayout(@NonNull Context context) {
        super(context);
        this.faY = 0.0f;
        this.fba = false;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1
            private boolean fbb = true;
            private int fbc = 0;
            private ValueAnimator fbd;
            private int state;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
                this.state = i;
                if (PullLeftRefreshLayout.this.fba && this.state == 0 && !this.fbb) {
                    if (this.fbd != null) {
                        this.fbd.cancel();
                    }
                    int i2 = (int) (PullLeftRefreshLayout.this.faT - 1.0f);
                    if (this.fbc > i2) {
                        this.fbc = i2;
                    }
                    this.fbd = ValueAnimator.ofInt(this.fbc, 0);
                    this.fbd.setDuration(100L);
                    this.fbd.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            PullLeftRefreshLayout.this.setTranslationStatus(-((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    this.fbd.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1.2
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                            onAnimationEnd(animator);
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            PullLeftRefreshLayout.this.bwQ();
                        }
                    });
                    this.fbd.start();
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
                this.fbc = i;
                if (!recyclerView.canScrollHorizontally(1) && i > 0) {
                    this.fbb = false;
                } else {
                    this.fbb = true;
                }
            }
        };
        init(context);
    }

    public PullLeftRefreshLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.faY = 0.0f;
        this.fba = false;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1
            private boolean fbb = true;
            private int fbc = 0;
            private ValueAnimator fbd;
            private int state;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
                this.state = i;
                if (PullLeftRefreshLayout.this.fba && this.state == 0 && !this.fbb) {
                    if (this.fbd != null) {
                        this.fbd.cancel();
                    }
                    int i2 = (int) (PullLeftRefreshLayout.this.faT - 1.0f);
                    if (this.fbc > i2) {
                        this.fbc = i2;
                    }
                    this.fbd = ValueAnimator.ofInt(this.fbc, 0);
                    this.fbd.setDuration(100L);
                    this.fbd.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            PullLeftRefreshLayout.this.setTranslationStatus(-((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    this.fbd.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1.2
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                            onAnimationEnd(animator);
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            PullLeftRefreshLayout.this.bwQ();
                        }
                    });
                    this.fbd.start();
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
                this.fbc = i;
                if (!recyclerView.canScrollHorizontally(1) && i > 0) {
                    this.fbb = false;
                } else {
                    this.fbb = true;
                }
            }
        };
        init(context);
    }

    public PullLeftRefreshLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.faY = 0.0f;
        this.fba = false;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1
            private boolean fbb = true;
            private int fbc = 0;
            private ValueAnimator fbd;
            private int state;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i2) {
                this.state = i2;
                if (PullLeftRefreshLayout.this.fba && this.state == 0 && !this.fbb) {
                    if (this.fbd != null) {
                        this.fbd.cancel();
                    }
                    int i22 = (int) (PullLeftRefreshLayout.this.faT - 1.0f);
                    if (this.fbc > i22) {
                        this.fbc = i22;
                    }
                    this.fbd = ValueAnimator.ofInt(this.fbc, 0);
                    this.fbd.setDuration(100L);
                    this.fbd.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            PullLeftRefreshLayout.this.setTranslationStatus(-((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    this.fbd.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1.2
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                            onAnimationEnd(animator);
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            PullLeftRefreshLayout.this.bwQ();
                        }
                    });
                    this.fbd.start();
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NonNull RecyclerView recyclerView, int i2, int i22) {
                this.fbc = i2;
                if (!recyclerView.canScrollHorizontally(1) && i2 > 0) {
                    this.fbb = false;
                } else {
                    this.fbb = true;
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
    }

    public void setCallback(a aVar) {
        this.faZ = aVar;
    }

    public void setRefreshViewAndListener(com.baidu.tbadk.widget.horizontalpullview.a aVar) {
        this.faN = aVar;
        this.faO = aVar.getView();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = GravityCompat.END;
        this.faO.setLayoutParams(layoutParams);
        addView(this.faO, 0);
    }

    public void setEnablePull(boolean z) {
        this.fba = z;
    }

    public boolean bwO() {
        return this.fba;
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
        if (this.faO != null) {
            this.faQ = this.faO.getMeasuredWidth();
            this.faS = this.faQ * 2;
            this.faR = this.faQ + this.faS;
            this.faT = this.faQ;
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.faP == 0) {
            this.faO.setTranslationX(this.faQ);
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                this.faW = x;
                this.mLastX = x;
                this.faX = y;
                this.mLastY = y;
                break;
            case 1:
            case 3:
                this.faW = 0;
                this.faX = 0;
                break;
            case 2:
                int i = x - this.faW;
                this.faW = x;
                this.mLastX = x;
                this.faX = y;
                this.mLastY = y;
                if (Math.abs(i) > Math.abs(y - this.faX) && this.fba && i < 0 && !bwS() && this.faP == 0) {
                    if (getParent() != null) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    this.faP = 2;
                    if (this.faN != null) {
                        this.faN.bv(this.faO);
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
        if (!this.fba) {
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
                this.faW = 0;
                this.mLastX = 0;
                this.faX = 0;
                this.mLastY = 0;
                if (Math.abs(this.faY) < this.faT) {
                    bwP();
                    return true;
                }
                bwR();
                return true;
            case 2:
                int i = x - this.mLastX;
                this.mLastX = x;
                this.mLastY = y;
                this.faY = ((1.0f - Math.abs(this.faY / this.faR)) * i) + this.faY;
                if (this.faY >= 0.0f) {
                    this.faY = 0.0f;
                    this.mRecyclerView.setTranslationX(this.faY);
                    if (this.faN != null) {
                        this.faN.bv(this.faO);
                    }
                } else if (this.faY <= (-this.faR)) {
                    this.faY = -this.faR;
                    this.mRecyclerView.setTranslationX(this.faY);
                    if (this.faN != null) {
                        this.faN.bw(this.faO);
                    }
                } else {
                    this.mRecyclerView.setTranslationX(this.faY);
                    if (Math.abs(this.faY) > this.faT) {
                        if (this.faN != null) {
                            this.faN.bw(this.faO);
                        }
                    } else if (this.faN != null) {
                        this.faN.bv(this.faO);
                    }
                }
                if (this.faO != null) {
                    this.faO.setTranslationX(this.faQ + this.faY);
                    return true;
                }
                return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void bwP() {
        if (this.faU != null) {
            this.faU.cancel();
        }
        this.faU = ValueAnimator.ofFloat(Math.abs(this.faY), 0.0f);
        this.faU.setDuration(150L);
        this.faU.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null) {
                    PullLeftRefreshLayout.this.setTranslationStatus(-((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.faU.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PullLeftRefreshLayout.this.bwQ();
            }
        });
        this.faU.start();
        if (this.faO != null) {
            this.faN.bv(this.faO);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTranslationStatus(float f) {
        if (this.mRecyclerView != null) {
            this.mRecyclerView.setTranslationX(f);
        }
        if (this.faO != null) {
            this.faO.setTranslationX(this.faQ + f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwQ() {
        this.faP = 0;
        this.faY = 0.0f;
        setTranslationStatus(0.0f);
    }

    private void bwR() {
        if (this.faV != null) {
            this.faV.cancel();
        }
        this.faV = ValueAnimator.ofFloat(Math.abs(this.faY), 0.0f);
        this.faV.setDuration(150L);
        this.faV.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null) {
                    PullLeftRefreshLayout.this.setTranslationStatus(-((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.faV.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PullLeftRefreshLayout.this.bwQ();
                PullLeftRefreshLayout.this.postDelayed(new Runnable() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PullLeftRefreshLayout.this.bwT();
                    }
                }, 50L);
            }
        });
        this.faV.start();
        if (this.faO != null) {
            this.faN.bv(this.faO);
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

    public boolean bwS() {
        return ViewCompat.canScrollHorizontally(this.mRecyclerView, 1);
    }

    public void bwT() {
        if (this.faZ != null) {
            this.faZ.bwU();
        }
    }
}
