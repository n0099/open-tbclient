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
/* loaded from: classes21.dex */
public class PullLeftRefreshLayout extends FrameLayout {
    private int fLA;
    private int fLB;
    private int fLC;
    private float fLD;
    private ValueAnimator fLE;
    private ValueAnimator fLF;
    private int fLG;
    private int fLH;
    private float fLI;
    private a fLJ;
    private boolean fLK;
    private com.baidu.tbadk.widget.horizontalpullview.a fLx;
    private View fLy;
    private int fLz;
    private int mLastX;
    private int mLastY;
    RecyclerView.OnScrollListener mOnScrollListener;
    private RecyclerView mRecyclerView;

    /* loaded from: classes21.dex */
    public interface a {
        void bHZ();
    }

    public PullLeftRefreshLayout(@NonNull Context context) {
        super(context);
        this.fLI = 0.0f;
        this.fLK = false;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1
            private boolean fLL = true;
            private int fLM = 0;
            private ValueAnimator fLN;
            private int state;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
                this.state = i;
                if (PullLeftRefreshLayout.this.fLK && this.state == 0 && !this.fLL) {
                    if (this.fLN != null) {
                        this.fLN.cancel();
                    }
                    int i2 = (int) (PullLeftRefreshLayout.this.fLD - 1.0f);
                    if (this.fLM > i2) {
                        this.fLM = i2;
                    }
                    this.fLN = ValueAnimator.ofInt(this.fLM, 0);
                    this.fLN.setDuration(100L);
                    this.fLN.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            PullLeftRefreshLayout.this.setTranslationStatus(-((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    this.fLN.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1.2
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                            onAnimationEnd(animator);
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            PullLeftRefreshLayout.this.bHV();
                        }
                    });
                    this.fLN.start();
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
                this.fLM = i;
                if (!recyclerView.canScrollHorizontally(1) && i > 0) {
                    this.fLL = false;
                } else {
                    this.fLL = true;
                }
            }
        };
        init(context);
    }

    public PullLeftRefreshLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fLI = 0.0f;
        this.fLK = false;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1
            private boolean fLL = true;
            private int fLM = 0;
            private ValueAnimator fLN;
            private int state;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
                this.state = i;
                if (PullLeftRefreshLayout.this.fLK && this.state == 0 && !this.fLL) {
                    if (this.fLN != null) {
                        this.fLN.cancel();
                    }
                    int i2 = (int) (PullLeftRefreshLayout.this.fLD - 1.0f);
                    if (this.fLM > i2) {
                        this.fLM = i2;
                    }
                    this.fLN = ValueAnimator.ofInt(this.fLM, 0);
                    this.fLN.setDuration(100L);
                    this.fLN.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            PullLeftRefreshLayout.this.setTranslationStatus(-((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    this.fLN.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1.2
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                            onAnimationEnd(animator);
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            PullLeftRefreshLayout.this.bHV();
                        }
                    });
                    this.fLN.start();
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
                this.fLM = i;
                if (!recyclerView.canScrollHorizontally(1) && i > 0) {
                    this.fLL = false;
                } else {
                    this.fLL = true;
                }
            }
        };
        init(context);
    }

    public PullLeftRefreshLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fLI = 0.0f;
        this.fLK = false;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1
            private boolean fLL = true;
            private int fLM = 0;
            private ValueAnimator fLN;
            private int state;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i2) {
                this.state = i2;
                if (PullLeftRefreshLayout.this.fLK && this.state == 0 && !this.fLL) {
                    if (this.fLN != null) {
                        this.fLN.cancel();
                    }
                    int i22 = (int) (PullLeftRefreshLayout.this.fLD - 1.0f);
                    if (this.fLM > i22) {
                        this.fLM = i22;
                    }
                    this.fLN = ValueAnimator.ofInt(this.fLM, 0);
                    this.fLN.setDuration(100L);
                    this.fLN.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            PullLeftRefreshLayout.this.setTranslationStatus(-((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    this.fLN.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1.2
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                            onAnimationEnd(animator);
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            PullLeftRefreshLayout.this.bHV();
                        }
                    });
                    this.fLN.start();
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NonNull RecyclerView recyclerView, int i2, int i22) {
                this.fLM = i2;
                if (!recyclerView.canScrollHorizontally(1) && i2 > 0) {
                    this.fLL = false;
                } else {
                    this.fLL = true;
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
    }

    public void setCallback(a aVar) {
        this.fLJ = aVar;
    }

    public void setRefreshViewAndListener(com.baidu.tbadk.widget.horizontalpullview.a aVar) {
        this.fLx = aVar;
        this.fLy = aVar.getView();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = GravityCompat.END;
        this.fLy.setLayoutParams(layoutParams);
        addView(this.fLy, 0);
    }

    public void setEnablePull(boolean z) {
        this.fLK = z;
    }

    public boolean bHT() {
        return this.fLK;
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
        if (this.fLy != null) {
            this.fLA = this.fLy.getMeasuredWidth();
            this.fLC = this.fLA * 2;
            this.fLB = this.fLA + this.fLC;
            this.fLD = this.fLA;
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.fLz == 0) {
            this.fLy.setTranslationX(this.fLA);
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                this.fLG = x;
                this.mLastX = x;
                this.fLH = y;
                this.mLastY = y;
                break;
            case 1:
            case 3:
                this.fLG = 0;
                this.fLH = 0;
                break;
            case 2:
                int i = x - this.fLG;
                this.fLG = x;
                this.mLastX = x;
                this.fLH = y;
                this.mLastY = y;
                if (Math.abs(i) > Math.abs(y - this.fLH) && this.fLK && i < 0 && !bHX() && this.fLz == 0) {
                    if (getParent() != null) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    this.fLz = 2;
                    if (this.fLx != null) {
                        this.fLx.bS(this.fLy);
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
        if (!this.fLK) {
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
                this.fLG = 0;
                this.mLastX = 0;
                this.fLH = 0;
                this.mLastY = 0;
                if (Math.abs(this.fLI) < this.fLD) {
                    bHU();
                    return true;
                }
                bHW();
                return true;
            case 2:
                int i = x - this.mLastX;
                this.mLastX = x;
                this.mLastY = y;
                this.fLI = ((1.0f - Math.abs(this.fLI / this.fLB)) * i) + this.fLI;
                if (this.fLI >= 0.0f) {
                    this.fLI = 0.0f;
                    this.mRecyclerView.setTranslationX(this.fLI);
                    if (this.fLx != null) {
                        this.fLx.bS(this.fLy);
                    }
                } else if (this.fLI <= (-this.fLB)) {
                    this.fLI = -this.fLB;
                    this.mRecyclerView.setTranslationX(this.fLI);
                    if (this.fLx != null) {
                        this.fLx.bT(this.fLy);
                    }
                } else {
                    this.mRecyclerView.setTranslationX(this.fLI);
                    if (Math.abs(this.fLI) > this.fLD) {
                        if (this.fLx != null) {
                            this.fLx.bT(this.fLy);
                        }
                    } else if (this.fLx != null) {
                        this.fLx.bS(this.fLy);
                    }
                }
                if (this.fLy != null) {
                    this.fLy.setTranslationX(this.fLA + this.fLI);
                    return true;
                }
                return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void bHU() {
        if (this.fLE != null) {
            this.fLE.cancel();
        }
        this.fLE = ValueAnimator.ofFloat(Math.abs(this.fLI), 0.0f);
        this.fLE.setDuration(150L);
        this.fLE.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null) {
                    PullLeftRefreshLayout.this.setTranslationStatus(-((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.fLE.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PullLeftRefreshLayout.this.bHV();
            }
        });
        this.fLE.start();
        if (this.fLy != null) {
            this.fLx.bS(this.fLy);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTranslationStatus(float f) {
        if (this.mRecyclerView != null) {
            this.mRecyclerView.setTranslationX(f);
        }
        if (this.fLy != null) {
            this.fLy.setTranslationX(this.fLA + f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHV() {
        this.fLz = 0;
        this.fLI = 0.0f;
        setTranslationStatus(0.0f);
    }

    private void bHW() {
        if (this.fLF != null) {
            this.fLF.cancel();
        }
        this.fLF = ValueAnimator.ofFloat(Math.abs(this.fLI), 0.0f);
        this.fLF.setDuration(150L);
        this.fLF.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null) {
                    PullLeftRefreshLayout.this.setTranslationStatus(-((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.fLF.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PullLeftRefreshLayout.this.bHV();
                PullLeftRefreshLayout.this.postDelayed(new Runnable() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PullLeftRefreshLayout.this.bHY();
                    }
                }, 50L);
            }
        });
        this.fLF.start();
        if (this.fLy != null) {
            this.fLx.bS(this.fLy);
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

    public boolean bHX() {
        return ViewCompat.canScrollHorizontally(this.mRecyclerView, 1);
    }

    public void bHY() {
        if (this.fLJ != null) {
            this.fLJ.bHZ();
        }
    }
}
