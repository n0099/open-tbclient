package com.baidu.tbadk.widget.horizontalpullview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes.dex */
public class PullLeftRefreshLayout extends FrameLayout {
    private com.baidu.tbadk.widget.horizontalpullview.a fSJ;
    private View fSK;
    private int fSL;
    private int fSM;
    private int fSN;
    private int fSO;
    private float fSP;
    private ValueAnimator fSQ;
    private ValueAnimator fSR;
    private int fSS;
    private int fST;
    private float fSU;
    private a fSV;
    private boolean fSW;
    private int mLastX;
    private int mLastY;
    RecyclerView.OnScrollListener mOnScrollListener;
    private RecyclerView mRecyclerView;

    /* loaded from: classes.dex */
    public interface a {
        void bGW();
    }

    public PullLeftRefreshLayout(@NonNull Context context) {
        super(context);
        this.fSU = 0.0f;
        this.fSW = false;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1
            private boolean fSX = true;
            private int fSY = 0;
            private int state;
            private ValueAnimator valueAnimator;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
                this.state = i;
                if (PullLeftRefreshLayout.this.fSW && this.state == 0 && !this.fSX) {
                    if (this.valueAnimator != null) {
                        this.valueAnimator.cancel();
                    }
                    int i2 = (int) (PullLeftRefreshLayout.this.fSP - 1.0f);
                    if (this.fSY > i2) {
                        this.fSY = i2;
                    }
                    this.valueAnimator = ValueAnimator.ofInt(this.fSY, 0);
                    this.valueAnimator.setDuration(100L);
                    this.valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            PullLeftRefreshLayout.this.setTranslationStatus(-((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    this.valueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1.2
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                            onAnimationEnd(animator);
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            PullLeftRefreshLayout.this.bGS();
                        }
                    });
                    this.valueAnimator.start();
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
                this.fSY = i;
                if (!recyclerView.canScrollHorizontally(1) && i > 0) {
                    this.fSX = false;
                } else {
                    this.fSX = true;
                }
            }
        };
        init(context);
    }

    public PullLeftRefreshLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fSU = 0.0f;
        this.fSW = false;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1
            private boolean fSX = true;
            private int fSY = 0;
            private int state;
            private ValueAnimator valueAnimator;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
                this.state = i;
                if (PullLeftRefreshLayout.this.fSW && this.state == 0 && !this.fSX) {
                    if (this.valueAnimator != null) {
                        this.valueAnimator.cancel();
                    }
                    int i2 = (int) (PullLeftRefreshLayout.this.fSP - 1.0f);
                    if (this.fSY > i2) {
                        this.fSY = i2;
                    }
                    this.valueAnimator = ValueAnimator.ofInt(this.fSY, 0);
                    this.valueAnimator.setDuration(100L);
                    this.valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            PullLeftRefreshLayout.this.setTranslationStatus(-((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    this.valueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1.2
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                            onAnimationEnd(animator);
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            PullLeftRefreshLayout.this.bGS();
                        }
                    });
                    this.valueAnimator.start();
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
                this.fSY = i;
                if (!recyclerView.canScrollHorizontally(1) && i > 0) {
                    this.fSX = false;
                } else {
                    this.fSX = true;
                }
            }
        };
        init(context);
    }

    public PullLeftRefreshLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fSU = 0.0f;
        this.fSW = false;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1
            private boolean fSX = true;
            private int fSY = 0;
            private int state;
            private ValueAnimator valueAnimator;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i2) {
                this.state = i2;
                if (PullLeftRefreshLayout.this.fSW && this.state == 0 && !this.fSX) {
                    if (this.valueAnimator != null) {
                        this.valueAnimator.cancel();
                    }
                    int i22 = (int) (PullLeftRefreshLayout.this.fSP - 1.0f);
                    if (this.fSY > i22) {
                        this.fSY = i22;
                    }
                    this.valueAnimator = ValueAnimator.ofInt(this.fSY, 0);
                    this.valueAnimator.setDuration(100L);
                    this.valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            PullLeftRefreshLayout.this.setTranslationStatus(-((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    this.valueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1.2
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                            onAnimationEnd(animator);
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            PullLeftRefreshLayout.this.bGS();
                        }
                    });
                    this.valueAnimator.start();
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NonNull RecyclerView recyclerView, int i2, int i22) {
                this.fSY = i2;
                if (!recyclerView.canScrollHorizontally(1) && i2 > 0) {
                    this.fSX = false;
                } else {
                    this.fSX = true;
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
    }

    public void setCallback(a aVar) {
        this.fSV = aVar;
    }

    public void setRefreshViewAndListener(com.baidu.tbadk.widget.horizontalpullview.a aVar) {
        this.fSJ = aVar;
        this.fSK = aVar.getView();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = GravityCompat.END;
        this.fSK.setLayoutParams(layoutParams);
        addView(this.fSK, 0);
    }

    public void setEnablePull(boolean z) {
        this.fSW = z;
    }

    public boolean bGQ() {
        return this.fSW;
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
        if (this.fSK != null) {
            this.fSM = this.fSK.getMeasuredWidth();
            this.fSO = this.fSM * 2;
            this.fSN = this.fSM + this.fSO;
            this.fSP = this.fSM;
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.fSL == 0) {
            this.fSK.setTranslationX(this.fSM);
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                this.fSS = x;
                this.mLastX = x;
                this.fST = y;
                this.mLastY = y;
                break;
            case 1:
            case 3:
                this.fSS = 0;
                this.fST = 0;
                break;
            case 2:
                int i = x - this.fSS;
                this.fSS = x;
                this.mLastX = x;
                this.fST = y;
                this.mLastY = y;
                if (Math.abs(i) > Math.abs(y - this.fST) && this.fSW && i < 0 && !bGU() && this.fSL == 0) {
                    if (getParent() != null) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    this.fSL = 2;
                    if (this.fSJ != null) {
                        this.fSJ.bX(this.fSK);
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
        if (!this.fSW) {
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
                this.fSS = 0;
                this.mLastX = 0;
                this.fST = 0;
                this.mLastY = 0;
                if (Math.abs(this.fSU) < this.fSP) {
                    bGR();
                    return true;
                }
                bGT();
                return true;
            case 2:
                int i = x - this.mLastX;
                this.mLastX = x;
                this.mLastY = y;
                this.fSU = ((1.0f - Math.abs(this.fSU / this.fSN)) * i) + this.fSU;
                if (this.fSU >= 0.0f) {
                    this.fSU = 0.0f;
                    this.mRecyclerView.setTranslationX(this.fSU);
                    if (this.fSJ != null) {
                        this.fSJ.bX(this.fSK);
                    }
                } else if (this.fSU <= (-this.fSN)) {
                    this.fSU = -this.fSN;
                    this.mRecyclerView.setTranslationX(this.fSU);
                    if (this.fSJ != null) {
                        this.fSJ.bY(this.fSK);
                    }
                } else {
                    this.mRecyclerView.setTranslationX(this.fSU);
                    if (Math.abs(this.fSU) > this.fSP) {
                        if (this.fSJ != null) {
                            this.fSJ.bY(this.fSK);
                        }
                    } else if (this.fSJ != null) {
                        this.fSJ.bX(this.fSK);
                    }
                }
                if (this.fSK != null) {
                    this.fSK.setTranslationX(this.fSM + this.fSU);
                    return true;
                }
                return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void bGR() {
        if (this.fSQ != null) {
            this.fSQ.cancel();
        }
        this.fSQ = ValueAnimator.ofFloat(Math.abs(this.fSU), 0.0f);
        this.fSQ.setDuration(150L);
        this.fSQ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null) {
                    PullLeftRefreshLayout.this.setTranslationStatus(-((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.fSQ.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PullLeftRefreshLayout.this.bGS();
            }
        });
        this.fSQ.start();
        if (this.fSK != null) {
            this.fSJ.bX(this.fSK);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTranslationStatus(float f) {
        if (this.mRecyclerView != null) {
            this.mRecyclerView.setTranslationX(f);
        }
        if (this.fSK != null) {
            this.fSK.setTranslationX(this.fSM + f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGS() {
        this.fSL = 0;
        this.fSU = 0.0f;
        setTranslationStatus(0.0f);
    }

    private void bGT() {
        if (this.fSR != null) {
            this.fSR.cancel();
        }
        this.fSR = ValueAnimator.ofFloat(Math.abs(this.fSU), 0.0f);
        this.fSR.setDuration(150L);
        this.fSR.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null) {
                    PullLeftRefreshLayout.this.setTranslationStatus(-((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.fSR.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PullLeftRefreshLayout.this.bGS();
                PullLeftRefreshLayout.this.postDelayed(new Runnable() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PullLeftRefreshLayout.this.bGV();
                    }
                }, 50L);
            }
        });
        this.fSR.start();
        if (this.fSK != null) {
            this.fSJ.bX(this.fSK);
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

    public boolean bGU() {
        return ViewCompat.canScrollHorizontally(this.mRecyclerView, 1);
    }

    public void bGV() {
        if (this.fSV != null) {
            this.fSV.bGW();
        }
    }
}
