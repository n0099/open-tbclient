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
    private com.baidu.tbadk.widget.horizontalpullview.a eQd;
    private View eQe;
    private int eQf;
    private int eQg;
    private int eQh;
    private int eQi;
    private float eQj;
    private ValueAnimator eQk;
    private ValueAnimator eQl;
    private int eQm;
    private int eQn;
    private float eQo;
    private a eQp;
    private boolean eQq;
    private int mLastX;
    private int mLastY;
    RecyclerView.OnScrollListener mOnScrollListener;
    private RecyclerView mRecyclerView;

    /* loaded from: classes15.dex */
    public interface a {
        void bog();
    }

    public PullLeftRefreshLayout(@NonNull Context context) {
        super(context);
        this.eQo = 0.0f;
        this.eQq = false;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1
            private boolean eQr = true;
            private int eQs = 0;
            private ValueAnimator eQt;
            private int state;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
                this.state = i;
                if (PullLeftRefreshLayout.this.eQq && this.state == 0 && !this.eQr) {
                    if (this.eQt != null) {
                        this.eQt.cancel();
                    }
                    int i2 = (int) (PullLeftRefreshLayout.this.eQj - 1.0f);
                    if (this.eQs > i2) {
                        this.eQs = i2;
                    }
                    this.eQt = ValueAnimator.ofInt(this.eQs, 0);
                    this.eQt.setDuration(100L);
                    this.eQt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            PullLeftRefreshLayout.this.setTranslationStatus(-((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    this.eQt.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1.2
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                            onAnimationEnd(animator);
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            PullLeftRefreshLayout.this.boc();
                        }
                    });
                    this.eQt.start();
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
                this.eQs = i;
                if (!recyclerView.canScrollHorizontally(1) && i > 0) {
                    this.eQr = false;
                } else {
                    this.eQr = true;
                }
            }
        };
        init(context);
    }

    public PullLeftRefreshLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eQo = 0.0f;
        this.eQq = false;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1
            private boolean eQr = true;
            private int eQs = 0;
            private ValueAnimator eQt;
            private int state;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
                this.state = i;
                if (PullLeftRefreshLayout.this.eQq && this.state == 0 && !this.eQr) {
                    if (this.eQt != null) {
                        this.eQt.cancel();
                    }
                    int i2 = (int) (PullLeftRefreshLayout.this.eQj - 1.0f);
                    if (this.eQs > i2) {
                        this.eQs = i2;
                    }
                    this.eQt = ValueAnimator.ofInt(this.eQs, 0);
                    this.eQt.setDuration(100L);
                    this.eQt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            PullLeftRefreshLayout.this.setTranslationStatus(-((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    this.eQt.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1.2
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                            onAnimationEnd(animator);
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            PullLeftRefreshLayout.this.boc();
                        }
                    });
                    this.eQt.start();
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
                this.eQs = i;
                if (!recyclerView.canScrollHorizontally(1) && i > 0) {
                    this.eQr = false;
                } else {
                    this.eQr = true;
                }
            }
        };
        init(context);
    }

    public PullLeftRefreshLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eQo = 0.0f;
        this.eQq = false;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1
            private boolean eQr = true;
            private int eQs = 0;
            private ValueAnimator eQt;
            private int state;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i2) {
                this.state = i2;
                if (PullLeftRefreshLayout.this.eQq && this.state == 0 && !this.eQr) {
                    if (this.eQt != null) {
                        this.eQt.cancel();
                    }
                    int i22 = (int) (PullLeftRefreshLayout.this.eQj - 1.0f);
                    if (this.eQs > i22) {
                        this.eQs = i22;
                    }
                    this.eQt = ValueAnimator.ofInt(this.eQs, 0);
                    this.eQt.setDuration(100L);
                    this.eQt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            PullLeftRefreshLayout.this.setTranslationStatus(-((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    this.eQt.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1.2
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                            onAnimationEnd(animator);
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            PullLeftRefreshLayout.this.boc();
                        }
                    });
                    this.eQt.start();
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NonNull RecyclerView recyclerView, int i2, int i22) {
                this.eQs = i2;
                if (!recyclerView.canScrollHorizontally(1) && i2 > 0) {
                    this.eQr = false;
                } else {
                    this.eQr = true;
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
    }

    public void setCallback(a aVar) {
        this.eQp = aVar;
    }

    public void setRefreshViewAndListener(com.baidu.tbadk.widget.horizontalpullview.a aVar) {
        this.eQd = aVar;
        this.eQe = aVar.getView();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = GravityCompat.END;
        this.eQe.setLayoutParams(layoutParams);
        addView(this.eQe, 0);
    }

    public void setEnablePull(boolean z) {
        this.eQq = z;
    }

    public boolean boa() {
        return this.eQq;
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
        if (this.eQe != null) {
            this.eQg = this.eQe.getMeasuredWidth();
            this.eQi = this.eQg * 2;
            this.eQh = this.eQg + this.eQi;
            this.eQj = this.eQg;
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.eQf == 0) {
            this.eQe.setTranslationX(this.eQg);
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                this.eQm = x;
                this.mLastX = x;
                this.eQn = y;
                this.mLastY = y;
                break;
            case 1:
            case 3:
                this.eQm = 0;
                this.eQn = 0;
                break;
            case 2:
                int i = x - this.eQm;
                this.eQm = x;
                this.mLastX = x;
                this.eQn = y;
                this.mLastY = y;
                if (Math.abs(i) > Math.abs(y - this.eQn) && this.eQq && i < 0 && !boe() && this.eQf == 0) {
                    if (getParent() != null) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    this.eQf = 2;
                    if (this.eQd != null) {
                        this.eQd.bt(this.eQe);
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
        if (!this.eQq) {
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
                this.eQm = 0;
                this.mLastX = 0;
                this.eQn = 0;
                this.mLastY = 0;
                if (Math.abs(this.eQo) < this.eQj) {
                    bob();
                    return true;
                }
                bod();
                return true;
            case 2:
                int i = x - this.mLastX;
                this.mLastX = x;
                this.mLastY = y;
                this.eQo = ((1.0f - Math.abs(this.eQo / this.eQh)) * i) + this.eQo;
                if (this.eQo >= 0.0f) {
                    this.eQo = 0.0f;
                    this.mRecyclerView.setTranslationX(this.eQo);
                    if (this.eQd != null) {
                        this.eQd.bt(this.eQe);
                    }
                } else if (this.eQo <= (-this.eQh)) {
                    this.eQo = -this.eQh;
                    this.mRecyclerView.setTranslationX(this.eQo);
                    if (this.eQd != null) {
                        this.eQd.bu(this.eQe);
                    }
                } else {
                    this.mRecyclerView.setTranslationX(this.eQo);
                    if (Math.abs(this.eQo) > this.eQj) {
                        if (this.eQd != null) {
                            this.eQd.bu(this.eQe);
                        }
                    } else if (this.eQd != null) {
                        this.eQd.bt(this.eQe);
                    }
                }
                if (this.eQe != null) {
                    this.eQe.setTranslationX(this.eQg + this.eQo);
                    return true;
                }
                return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void bob() {
        if (this.eQk != null) {
            this.eQk.cancel();
        }
        this.eQk = ValueAnimator.ofFloat(Math.abs(this.eQo), 0.0f);
        this.eQk.setDuration(150L);
        this.eQk.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null) {
                    PullLeftRefreshLayout.this.setTranslationStatus(-((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.eQk.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PullLeftRefreshLayout.this.boc();
            }
        });
        this.eQk.start();
        if (this.eQe != null) {
            this.eQd.bt(this.eQe);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTranslationStatus(float f) {
        if (this.mRecyclerView != null) {
            this.mRecyclerView.setTranslationX(f);
        }
        if (this.eQe != null) {
            this.eQe.setTranslationX(this.eQg + f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boc() {
        this.eQf = 0;
        this.eQo = 0.0f;
        setTranslationStatus(0.0f);
    }

    private void bod() {
        if (this.eQl != null) {
            this.eQl.cancel();
        }
        this.eQl = ValueAnimator.ofFloat(Math.abs(this.eQo), 0.0f);
        this.eQl.setDuration(150L);
        this.eQl.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null) {
                    PullLeftRefreshLayout.this.setTranslationStatus(-((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.eQl.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PullLeftRefreshLayout.this.boc();
                PullLeftRefreshLayout.this.postDelayed(new Runnable() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PullLeftRefreshLayout.this.bof();
                    }
                }, 50L);
            }
        });
        this.eQl.start();
        if (this.eQe != null) {
            this.eQd.bt(this.eQe);
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

    public boolean boe() {
        return ViewCompat.canScrollHorizontally(this.mRecyclerView, 1);
    }

    public void bof() {
        if (this.eQp != null) {
            this.eQp.bog();
        }
    }
}
