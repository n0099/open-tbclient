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
    private com.baidu.tbadk.widget.horizontalpullview.a fpT;
    private View fpU;
    private int fpV;
    private int fpW;
    private int fpX;
    private int fpY;
    private float fpZ;
    private ValueAnimator fqa;
    private ValueAnimator fqb;
    private int fqc;
    private int fqd;
    private float fqe;
    private a fqf;
    private boolean fqg;
    private int mLastX;
    private int mLastY;
    RecyclerView.OnScrollListener mOnScrollListener;
    private RecyclerView mRecyclerView;

    /* loaded from: classes21.dex */
    public interface a {
        void bAN();
    }

    public PullLeftRefreshLayout(@NonNull Context context) {
        super(context);
        this.fqe = 0.0f;
        this.fqg = false;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1
            private boolean fqh = true;
            private int fqi = 0;
            private ValueAnimator fqj;
            private int state;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
                this.state = i;
                if (PullLeftRefreshLayout.this.fqg && this.state == 0 && !this.fqh) {
                    if (this.fqj != null) {
                        this.fqj.cancel();
                    }
                    int i2 = (int) (PullLeftRefreshLayout.this.fpZ - 1.0f);
                    if (this.fqi > i2) {
                        this.fqi = i2;
                    }
                    this.fqj = ValueAnimator.ofInt(this.fqi, 0);
                    this.fqj.setDuration(100L);
                    this.fqj.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            PullLeftRefreshLayout.this.setTranslationStatus(-((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    this.fqj.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1.2
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                            onAnimationEnd(animator);
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            PullLeftRefreshLayout.this.bAJ();
                        }
                    });
                    this.fqj.start();
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
                this.fqi = i;
                if (!recyclerView.canScrollHorizontally(1) && i > 0) {
                    this.fqh = false;
                } else {
                    this.fqh = true;
                }
            }
        };
        init(context);
    }

    public PullLeftRefreshLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fqe = 0.0f;
        this.fqg = false;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1
            private boolean fqh = true;
            private int fqi = 0;
            private ValueAnimator fqj;
            private int state;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
                this.state = i;
                if (PullLeftRefreshLayout.this.fqg && this.state == 0 && !this.fqh) {
                    if (this.fqj != null) {
                        this.fqj.cancel();
                    }
                    int i2 = (int) (PullLeftRefreshLayout.this.fpZ - 1.0f);
                    if (this.fqi > i2) {
                        this.fqi = i2;
                    }
                    this.fqj = ValueAnimator.ofInt(this.fqi, 0);
                    this.fqj.setDuration(100L);
                    this.fqj.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            PullLeftRefreshLayout.this.setTranslationStatus(-((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    this.fqj.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1.2
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                            onAnimationEnd(animator);
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            PullLeftRefreshLayout.this.bAJ();
                        }
                    });
                    this.fqj.start();
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
                this.fqi = i;
                if (!recyclerView.canScrollHorizontally(1) && i > 0) {
                    this.fqh = false;
                } else {
                    this.fqh = true;
                }
            }
        };
        init(context);
    }

    public PullLeftRefreshLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fqe = 0.0f;
        this.fqg = false;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1
            private boolean fqh = true;
            private int fqi = 0;
            private ValueAnimator fqj;
            private int state;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i2) {
                this.state = i2;
                if (PullLeftRefreshLayout.this.fqg && this.state == 0 && !this.fqh) {
                    if (this.fqj != null) {
                        this.fqj.cancel();
                    }
                    int i22 = (int) (PullLeftRefreshLayout.this.fpZ - 1.0f);
                    if (this.fqi > i22) {
                        this.fqi = i22;
                    }
                    this.fqj = ValueAnimator.ofInt(this.fqi, 0);
                    this.fqj.setDuration(100L);
                    this.fqj.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            PullLeftRefreshLayout.this.setTranslationStatus(-((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    this.fqj.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1.2
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                            onAnimationEnd(animator);
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            PullLeftRefreshLayout.this.bAJ();
                        }
                    });
                    this.fqj.start();
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NonNull RecyclerView recyclerView, int i2, int i22) {
                this.fqi = i2;
                if (!recyclerView.canScrollHorizontally(1) && i2 > 0) {
                    this.fqh = false;
                } else {
                    this.fqh = true;
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
    }

    public void setCallback(a aVar) {
        this.fqf = aVar;
    }

    public void setRefreshViewAndListener(com.baidu.tbadk.widget.horizontalpullview.a aVar) {
        this.fpT = aVar;
        this.fpU = aVar.getView();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = GravityCompat.END;
        this.fpU.setLayoutParams(layoutParams);
        addView(this.fpU, 0);
    }

    public void setEnablePull(boolean z) {
        this.fqg = z;
    }

    public boolean bAH() {
        return this.fqg;
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
        if (this.fpU != null) {
            this.fpW = this.fpU.getMeasuredWidth();
            this.fpY = this.fpW * 2;
            this.fpX = this.fpW + this.fpY;
            this.fpZ = this.fpW;
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.fpV == 0) {
            this.fpU.setTranslationX(this.fpW);
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                this.fqc = x;
                this.mLastX = x;
                this.fqd = y;
                this.mLastY = y;
                break;
            case 1:
            case 3:
                this.fqc = 0;
                this.fqd = 0;
                break;
            case 2:
                int i = x - this.fqc;
                this.fqc = x;
                this.mLastX = x;
                this.fqd = y;
                this.mLastY = y;
                if (Math.abs(i) > Math.abs(y - this.fqd) && this.fqg && i < 0 && !bAL() && this.fpV == 0) {
                    if (getParent() != null) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    this.fpV = 2;
                    if (this.fpT != null) {
                        this.fpT.bD(this.fpU);
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
        if (!this.fqg) {
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
                this.fqc = 0;
                this.mLastX = 0;
                this.fqd = 0;
                this.mLastY = 0;
                if (Math.abs(this.fqe) < this.fpZ) {
                    bAI();
                    return true;
                }
                bAK();
                return true;
            case 2:
                int i = x - this.mLastX;
                this.mLastX = x;
                this.mLastY = y;
                this.fqe = ((1.0f - Math.abs(this.fqe / this.fpX)) * i) + this.fqe;
                if (this.fqe >= 0.0f) {
                    this.fqe = 0.0f;
                    this.mRecyclerView.setTranslationX(this.fqe);
                    if (this.fpT != null) {
                        this.fpT.bD(this.fpU);
                    }
                } else if (this.fqe <= (-this.fpX)) {
                    this.fqe = -this.fpX;
                    this.mRecyclerView.setTranslationX(this.fqe);
                    if (this.fpT != null) {
                        this.fpT.bE(this.fpU);
                    }
                } else {
                    this.mRecyclerView.setTranslationX(this.fqe);
                    if (Math.abs(this.fqe) > this.fpZ) {
                        if (this.fpT != null) {
                            this.fpT.bE(this.fpU);
                        }
                    } else if (this.fpT != null) {
                        this.fpT.bD(this.fpU);
                    }
                }
                if (this.fpU != null) {
                    this.fpU.setTranslationX(this.fpW + this.fqe);
                    return true;
                }
                return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void bAI() {
        if (this.fqa != null) {
            this.fqa.cancel();
        }
        this.fqa = ValueAnimator.ofFloat(Math.abs(this.fqe), 0.0f);
        this.fqa.setDuration(150L);
        this.fqa.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null) {
                    PullLeftRefreshLayout.this.setTranslationStatus(-((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.fqa.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PullLeftRefreshLayout.this.bAJ();
            }
        });
        this.fqa.start();
        if (this.fpU != null) {
            this.fpT.bD(this.fpU);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTranslationStatus(float f) {
        if (this.mRecyclerView != null) {
            this.mRecyclerView.setTranslationX(f);
        }
        if (this.fpU != null) {
            this.fpU.setTranslationX(this.fpW + f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAJ() {
        this.fpV = 0;
        this.fqe = 0.0f;
        setTranslationStatus(0.0f);
    }

    private void bAK() {
        if (this.fqb != null) {
            this.fqb.cancel();
        }
        this.fqb = ValueAnimator.ofFloat(Math.abs(this.fqe), 0.0f);
        this.fqb.setDuration(150L);
        this.fqb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null) {
                    PullLeftRefreshLayout.this.setTranslationStatus(-((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.fqb.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PullLeftRefreshLayout.this.bAJ();
                PullLeftRefreshLayout.this.postDelayed(new Runnable() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PullLeftRefreshLayout.this.bAM();
                    }
                }, 50L);
            }
        });
        this.fqb.start();
        if (this.fpU != null) {
            this.fpT.bD(this.fpU);
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

    public boolean bAL() {
        return ViewCompat.canScrollHorizontally(this.mRecyclerView, 1);
    }

    public void bAM() {
        if (this.fqf != null) {
            this.fqf.bAN();
        }
    }
}
