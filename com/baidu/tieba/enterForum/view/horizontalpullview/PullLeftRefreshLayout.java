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
    private int gYA;
    private float gYB;
    private ValueAnimator gYC;
    private ValueAnimator gYD;
    private int gYE;
    private int gYF;
    private float gYG;
    private a gYH;
    private boolean gYI;
    private com.baidu.tieba.enterForum.view.horizontalpullview.a gYv;
    private View gYw;
    private int gYx;
    private int gYy;
    private int gYz;
    private int mLastX;
    private int mLastY;
    RecyclerView.OnScrollListener mOnScrollListener;
    private RecyclerView mRecyclerView;

    /* loaded from: classes9.dex */
    public interface a {
        void bQG();
    }

    public PullLeftRefreshLayout(@NonNull Context context) {
        super(context);
        this.gYG = 0.0f;
        this.gYI = false;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.view.horizontalpullview.PullLeftRefreshLayout.1
            private boolean gYJ = true;
            private int gYK = 0;
            private ValueAnimator gYL;
            private int state;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
                this.state = i;
                if (PullLeftRefreshLayout.this.gYI && this.state == 0 && !this.gYJ) {
                    if (this.gYL != null) {
                        this.gYL.cancel();
                    }
                    int i2 = (int) (PullLeftRefreshLayout.this.gYB - 1.0f);
                    if (this.gYK > i2) {
                        this.gYK = i2;
                    }
                    this.gYL = ValueAnimator.ofInt(this.gYK, 0);
                    this.gYL.setDuration(100L);
                    this.gYL.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.view.horizontalpullview.PullLeftRefreshLayout.1.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            PullLeftRefreshLayout.this.setTranslationStatus(-((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    this.gYL.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.enterForum.view.horizontalpullview.PullLeftRefreshLayout.1.2
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                            onAnimationEnd(animator);
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            PullLeftRefreshLayout.this.bQJ();
                        }
                    });
                    this.gYL.start();
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
                this.gYK = i;
                if (!recyclerView.canScrollHorizontally(1) && i > 0) {
                    this.gYJ = false;
                } else {
                    this.gYJ = true;
                }
            }
        };
        init(context);
    }

    public PullLeftRefreshLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gYG = 0.0f;
        this.gYI = false;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.view.horizontalpullview.PullLeftRefreshLayout.1
            private boolean gYJ = true;
            private int gYK = 0;
            private ValueAnimator gYL;
            private int state;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
                this.state = i;
                if (PullLeftRefreshLayout.this.gYI && this.state == 0 && !this.gYJ) {
                    if (this.gYL != null) {
                        this.gYL.cancel();
                    }
                    int i2 = (int) (PullLeftRefreshLayout.this.gYB - 1.0f);
                    if (this.gYK > i2) {
                        this.gYK = i2;
                    }
                    this.gYL = ValueAnimator.ofInt(this.gYK, 0);
                    this.gYL.setDuration(100L);
                    this.gYL.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.view.horizontalpullview.PullLeftRefreshLayout.1.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            PullLeftRefreshLayout.this.setTranslationStatus(-((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    this.gYL.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.enterForum.view.horizontalpullview.PullLeftRefreshLayout.1.2
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                            onAnimationEnd(animator);
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            PullLeftRefreshLayout.this.bQJ();
                        }
                    });
                    this.gYL.start();
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
                this.gYK = i;
                if (!recyclerView.canScrollHorizontally(1) && i > 0) {
                    this.gYJ = false;
                } else {
                    this.gYJ = true;
                }
            }
        };
        init(context);
    }

    public PullLeftRefreshLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gYG = 0.0f;
        this.gYI = false;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.view.horizontalpullview.PullLeftRefreshLayout.1
            private boolean gYJ = true;
            private int gYK = 0;
            private ValueAnimator gYL;
            private int state;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i2) {
                this.state = i2;
                if (PullLeftRefreshLayout.this.gYI && this.state == 0 && !this.gYJ) {
                    if (this.gYL != null) {
                        this.gYL.cancel();
                    }
                    int i22 = (int) (PullLeftRefreshLayout.this.gYB - 1.0f);
                    if (this.gYK > i22) {
                        this.gYK = i22;
                    }
                    this.gYL = ValueAnimator.ofInt(this.gYK, 0);
                    this.gYL.setDuration(100L);
                    this.gYL.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.view.horizontalpullview.PullLeftRefreshLayout.1.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            PullLeftRefreshLayout.this.setTranslationStatus(-((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    this.gYL.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.enterForum.view.horizontalpullview.PullLeftRefreshLayout.1.2
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                            onAnimationEnd(animator);
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            PullLeftRefreshLayout.this.bQJ();
                        }
                    });
                    this.gYL.start();
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NonNull RecyclerView recyclerView, int i2, int i22) {
                this.gYK = i2;
                if (!recyclerView.canScrollHorizontally(1) && i2 > 0) {
                    this.gYJ = false;
                } else {
                    this.gYJ = true;
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
    }

    public void setCallback(a aVar) {
        this.gYH = aVar;
    }

    public void setRefreshViewAndListener(com.baidu.tieba.enterForum.view.horizontalpullview.a aVar) {
        this.gYv = aVar;
        this.gYw = aVar.getView();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = GravityCompat.END;
        this.gYw.setLayoutParams(layoutParams);
        addView(this.gYw, 0);
    }

    public void setEnablePull(boolean z) {
        this.gYI = z;
    }

    public boolean bQH() {
        return this.gYI;
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
        if (this.gYw != null) {
            this.gYy = this.gYw.getMeasuredWidth();
            this.gYA = this.gYy * 2;
            this.gYz = this.gYy + this.gYA;
            this.gYB = this.gYy;
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.gYx == 0) {
            this.gYw.setTranslationX(this.gYy);
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                this.gYE = x;
                this.mLastX = x;
                this.gYF = y;
                this.mLastY = y;
                break;
            case 1:
            case 3:
                this.gYE = 0;
                this.gYF = 0;
                break;
            case 2:
                int i = x - this.gYE;
                this.gYE = x;
                this.mLastX = x;
                this.gYF = y;
                this.mLastY = y;
                if (Math.abs(i) > Math.abs(y - this.gYF) && this.gYI && i < 0 && !bQL() && this.gYx == 0) {
                    if (getParent() != null) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    this.gYx = 2;
                    if (this.gYv != null) {
                        this.gYv.bT(this.gYw);
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
        if (!this.gYI) {
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
                this.gYE = 0;
                this.mLastX = 0;
                this.gYF = 0;
                this.mLastY = 0;
                if (Math.abs(this.gYG) < this.gYB) {
                    bQI();
                    return true;
                }
                bQK();
                return true;
            case 2:
                int i = x - this.mLastX;
                this.mLastX = x;
                this.mLastY = y;
                this.gYG = ((1.0f - Math.abs(this.gYG / this.gYz)) * i) + this.gYG;
                if (this.gYG >= 0.0f) {
                    this.gYG = 0.0f;
                    this.mRecyclerView.setTranslationX(this.gYG);
                    if (this.gYv != null) {
                        this.gYv.bT(this.gYw);
                    }
                } else if (this.gYG <= (-this.gYz)) {
                    this.gYG = -this.gYz;
                    this.mRecyclerView.setTranslationX(this.gYG);
                    if (this.gYv != null) {
                        this.gYv.bU(this.gYw);
                    }
                } else {
                    this.mRecyclerView.setTranslationX(this.gYG);
                    if (Math.abs(this.gYG) > this.gYB) {
                        if (this.gYv != null) {
                            this.gYv.bU(this.gYw);
                        }
                    } else if (this.gYv != null) {
                        this.gYv.bT(this.gYw);
                    }
                }
                if (this.gYw != null) {
                    this.gYw.setTranslationX(this.gYy + this.gYG);
                    return true;
                }
                return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void bQI() {
        if (this.gYC != null) {
            this.gYC.cancel();
        }
        this.gYC = ValueAnimator.ofFloat(Math.abs(this.gYG), 0.0f);
        this.gYC.setDuration(150L);
        this.gYC.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.view.horizontalpullview.PullLeftRefreshLayout.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null) {
                    PullLeftRefreshLayout.this.setTranslationStatus(-((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.gYC.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.enterForum.view.horizontalpullview.PullLeftRefreshLayout.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PullLeftRefreshLayout.this.bQJ();
            }
        });
        this.gYC.start();
        if (this.gYw != null) {
            this.gYv.bT(this.gYw);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTranslationStatus(float f) {
        if (this.mRecyclerView != null) {
            this.mRecyclerView.setTranslationX(f);
        }
        if (this.gYw != null) {
            this.gYw.setTranslationX(this.gYy + f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQJ() {
        this.gYx = 0;
        this.gYG = 0.0f;
        setTranslationStatus(0.0f);
    }

    private void bQK() {
        if (this.gYD != null) {
            this.gYD.cancel();
        }
        this.gYD = ValueAnimator.ofFloat(Math.abs(this.gYG), 0.0f);
        this.gYD.setDuration(150L);
        this.gYD.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.view.horizontalpullview.PullLeftRefreshLayout.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null) {
                    PullLeftRefreshLayout.this.setTranslationStatus(-((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.gYD.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.enterForum.view.horizontalpullview.PullLeftRefreshLayout.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PullLeftRefreshLayout.this.bQJ();
                PullLeftRefreshLayout.this.postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.view.horizontalpullview.PullLeftRefreshLayout.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PullLeftRefreshLayout.this.bQM();
                    }
                }, 50L);
            }
        });
        this.gYD.start();
        if (this.gYw != null) {
            this.gYv.bT(this.gYw);
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

    public boolean bQL() {
        return ViewCompat.canScrollHorizontally(this.mRecyclerView, 1);
    }

    public void bQM() {
        if (this.gYH != null) {
            this.gYH.bQG();
        }
    }
}
