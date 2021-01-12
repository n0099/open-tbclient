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
    private int fQA;
    private int fQB;
    private float fQC;
    private ValueAnimator fQD;
    private ValueAnimator fQE;
    private int fQF;
    private int fQG;
    private float fQH;
    private a fQI;
    private boolean fQJ;
    private com.baidu.tbadk.widget.horizontalpullview.a fQw;
    private View fQx;
    private int fQy;
    private int fQz;
    private int mLastX;
    private int mLastY;
    RecyclerView.OnScrollListener mOnScrollListener;
    private RecyclerView mRecyclerView;

    /* loaded from: classes.dex */
    public interface a {
        void bGC();
    }

    public PullLeftRefreshLayout(@NonNull Context context) {
        super(context);
        this.fQH = 0.0f;
        this.fQJ = false;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1
            private boolean fQK = true;
            private int fQL = 0;
            private int state;
            private ValueAnimator valueAnimator;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
                this.state = i;
                if (PullLeftRefreshLayout.this.fQJ && this.state == 0 && !this.fQK) {
                    if (this.valueAnimator != null) {
                        this.valueAnimator.cancel();
                    }
                    int i2 = (int) (PullLeftRefreshLayout.this.fQC - 1.0f);
                    if (this.fQL > i2) {
                        this.fQL = i2;
                    }
                    this.valueAnimator = ValueAnimator.ofInt(this.fQL, 0);
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
                            PullLeftRefreshLayout.this.bGy();
                        }
                    });
                    this.valueAnimator.start();
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
                this.fQL = i;
                if (!recyclerView.canScrollHorizontally(1) && i > 0) {
                    this.fQK = false;
                } else {
                    this.fQK = true;
                }
            }
        };
        init(context);
    }

    public PullLeftRefreshLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fQH = 0.0f;
        this.fQJ = false;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1
            private boolean fQK = true;
            private int fQL = 0;
            private int state;
            private ValueAnimator valueAnimator;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
                this.state = i;
                if (PullLeftRefreshLayout.this.fQJ && this.state == 0 && !this.fQK) {
                    if (this.valueAnimator != null) {
                        this.valueAnimator.cancel();
                    }
                    int i2 = (int) (PullLeftRefreshLayout.this.fQC - 1.0f);
                    if (this.fQL > i2) {
                        this.fQL = i2;
                    }
                    this.valueAnimator = ValueAnimator.ofInt(this.fQL, 0);
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
                            PullLeftRefreshLayout.this.bGy();
                        }
                    });
                    this.valueAnimator.start();
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
                this.fQL = i;
                if (!recyclerView.canScrollHorizontally(1) && i > 0) {
                    this.fQK = false;
                } else {
                    this.fQK = true;
                }
            }
        };
        init(context);
    }

    public PullLeftRefreshLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fQH = 0.0f;
        this.fQJ = false;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1
            private boolean fQK = true;
            private int fQL = 0;
            private int state;
            private ValueAnimator valueAnimator;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i2) {
                this.state = i2;
                if (PullLeftRefreshLayout.this.fQJ && this.state == 0 && !this.fQK) {
                    if (this.valueAnimator != null) {
                        this.valueAnimator.cancel();
                    }
                    int i22 = (int) (PullLeftRefreshLayout.this.fQC - 1.0f);
                    if (this.fQL > i22) {
                        this.fQL = i22;
                    }
                    this.valueAnimator = ValueAnimator.ofInt(this.fQL, 0);
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
                            PullLeftRefreshLayout.this.bGy();
                        }
                    });
                    this.valueAnimator.start();
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NonNull RecyclerView recyclerView, int i2, int i22) {
                this.fQL = i2;
                if (!recyclerView.canScrollHorizontally(1) && i2 > 0) {
                    this.fQK = false;
                } else {
                    this.fQK = true;
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
    }

    public void setCallback(a aVar) {
        this.fQI = aVar;
    }

    public void setRefreshViewAndListener(com.baidu.tbadk.widget.horizontalpullview.a aVar) {
        this.fQw = aVar;
        this.fQx = aVar.getView();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = GravityCompat.END;
        this.fQx.setLayoutParams(layoutParams);
        addView(this.fQx, 0);
    }

    public void setEnablePull(boolean z) {
        this.fQJ = z;
    }

    public boolean bGw() {
        return this.fQJ;
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
        if (this.fQx != null) {
            this.fQz = this.fQx.getMeasuredWidth();
            this.fQB = this.fQz * 2;
            this.fQA = this.fQz + this.fQB;
            this.fQC = this.fQz;
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.fQy == 0) {
            this.fQx.setTranslationX(this.fQz);
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                this.fQF = x;
                this.mLastX = x;
                this.fQG = y;
                this.mLastY = y;
                break;
            case 1:
            case 3:
                this.fQF = 0;
                this.fQG = 0;
                break;
            case 2:
                int i = x - this.fQF;
                this.fQF = x;
                this.mLastX = x;
                this.fQG = y;
                this.mLastY = y;
                if (Math.abs(i) > Math.abs(y - this.fQG) && this.fQJ && i < 0 && !bGA() && this.fQy == 0) {
                    if (getParent() != null) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    this.fQy = 2;
                    if (this.fQw != null) {
                        this.fQw.cb(this.fQx);
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
        if (!this.fQJ) {
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
                this.fQF = 0;
                this.mLastX = 0;
                this.fQG = 0;
                this.mLastY = 0;
                if (Math.abs(this.fQH) < this.fQC) {
                    bGx();
                    return true;
                }
                bGz();
                return true;
            case 2:
                int i = x - this.mLastX;
                this.mLastX = x;
                this.mLastY = y;
                this.fQH = ((1.0f - Math.abs(this.fQH / this.fQA)) * i) + this.fQH;
                if (this.fQH >= 0.0f) {
                    this.fQH = 0.0f;
                    this.mRecyclerView.setTranslationX(this.fQH);
                    if (this.fQw != null) {
                        this.fQw.cb(this.fQx);
                    }
                } else if (this.fQH <= (-this.fQA)) {
                    this.fQH = -this.fQA;
                    this.mRecyclerView.setTranslationX(this.fQH);
                    if (this.fQw != null) {
                        this.fQw.cc(this.fQx);
                    }
                } else {
                    this.mRecyclerView.setTranslationX(this.fQH);
                    if (Math.abs(this.fQH) > this.fQC) {
                        if (this.fQw != null) {
                            this.fQw.cc(this.fQx);
                        }
                    } else if (this.fQw != null) {
                        this.fQw.cb(this.fQx);
                    }
                }
                if (this.fQx != null) {
                    this.fQx.setTranslationX(this.fQz + this.fQH);
                    return true;
                }
                return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void bGx() {
        if (this.fQD != null) {
            this.fQD.cancel();
        }
        this.fQD = ValueAnimator.ofFloat(Math.abs(this.fQH), 0.0f);
        this.fQD.setDuration(150L);
        this.fQD.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null) {
                    PullLeftRefreshLayout.this.setTranslationStatus(-((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.fQD.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PullLeftRefreshLayout.this.bGy();
            }
        });
        this.fQD.start();
        if (this.fQx != null) {
            this.fQw.cb(this.fQx);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTranslationStatus(float f) {
        if (this.mRecyclerView != null) {
            this.mRecyclerView.setTranslationX(f);
        }
        if (this.fQx != null) {
            this.fQx.setTranslationX(this.fQz + f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGy() {
        this.fQy = 0;
        this.fQH = 0.0f;
        setTranslationStatus(0.0f);
    }

    private void bGz() {
        if (this.fQE != null) {
            this.fQE.cancel();
        }
        this.fQE = ValueAnimator.ofFloat(Math.abs(this.fQH), 0.0f);
        this.fQE.setDuration(150L);
        this.fQE.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null) {
                    PullLeftRefreshLayout.this.setTranslationStatus(-((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.fQE.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PullLeftRefreshLayout.this.bGy();
                PullLeftRefreshLayout.this.postDelayed(new Runnable() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PullLeftRefreshLayout.this.bGB();
                    }
                }, 50L);
            }
        });
        this.fQE.start();
        if (this.fQx != null) {
            this.fQw.cb(this.fQx);
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

    public boolean bGA() {
        return ViewCompat.canScrollHorizontally(this.mRecyclerView, 1);
    }

    public void bGB() {
        if (this.fQI != null) {
            this.fQI.bGC();
        }
    }
}
