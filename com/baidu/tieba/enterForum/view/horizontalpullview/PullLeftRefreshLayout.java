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
    private com.baidu.tieba.enterForum.view.horizontalpullview.a gJJ;
    private View gJK;
    private int gJL;
    private int gJM;
    private int gJN;
    private int gJO;
    private float gJP;
    private ValueAnimator gJQ;
    private ValueAnimator gJR;
    private int gJS;
    private int gJT;
    private float gJU;
    private a gJV;
    private boolean gJW;
    private int mLastX;
    private int mLastY;
    RecyclerView.OnScrollListener mOnScrollListener;
    private RecyclerView mRecyclerView;

    /* loaded from: classes9.dex */
    public interface a {
        void bKl();
    }

    public PullLeftRefreshLayout(@NonNull Context context) {
        super(context);
        this.gJU = 0.0f;
        this.gJW = false;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.view.horizontalpullview.PullLeftRefreshLayout.1
            private boolean gJX = true;
            private int gJY = 0;
            private ValueAnimator gJZ;
            private int state;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
                this.state = i;
                if (PullLeftRefreshLayout.this.gJW && this.state == 0 && !this.gJX) {
                    if (this.gJZ != null) {
                        this.gJZ.cancel();
                    }
                    int i2 = (int) (PullLeftRefreshLayout.this.gJP - 1.0f);
                    if (this.gJY > i2) {
                        this.gJY = i2;
                    }
                    this.gJZ = ValueAnimator.ofInt(this.gJY, 0);
                    this.gJZ.setDuration(100L);
                    this.gJZ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.view.horizontalpullview.PullLeftRefreshLayout.1.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            PullLeftRefreshLayout.this.setTranslationStatus(-((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    this.gJZ.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.enterForum.view.horizontalpullview.PullLeftRefreshLayout.1.2
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                            onAnimationEnd(animator);
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            PullLeftRefreshLayout.this.bKo();
                        }
                    });
                    this.gJZ.start();
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
                this.gJY = i;
                if (!recyclerView.canScrollHorizontally(1) && i > 0) {
                    this.gJX = false;
                } else {
                    this.gJX = true;
                }
            }
        };
        init(context);
    }

    public PullLeftRefreshLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gJU = 0.0f;
        this.gJW = false;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.view.horizontalpullview.PullLeftRefreshLayout.1
            private boolean gJX = true;
            private int gJY = 0;
            private ValueAnimator gJZ;
            private int state;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
                this.state = i;
                if (PullLeftRefreshLayout.this.gJW && this.state == 0 && !this.gJX) {
                    if (this.gJZ != null) {
                        this.gJZ.cancel();
                    }
                    int i2 = (int) (PullLeftRefreshLayout.this.gJP - 1.0f);
                    if (this.gJY > i2) {
                        this.gJY = i2;
                    }
                    this.gJZ = ValueAnimator.ofInt(this.gJY, 0);
                    this.gJZ.setDuration(100L);
                    this.gJZ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.view.horizontalpullview.PullLeftRefreshLayout.1.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            PullLeftRefreshLayout.this.setTranslationStatus(-((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    this.gJZ.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.enterForum.view.horizontalpullview.PullLeftRefreshLayout.1.2
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                            onAnimationEnd(animator);
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            PullLeftRefreshLayout.this.bKo();
                        }
                    });
                    this.gJZ.start();
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
                this.gJY = i;
                if (!recyclerView.canScrollHorizontally(1) && i > 0) {
                    this.gJX = false;
                } else {
                    this.gJX = true;
                }
            }
        };
        init(context);
    }

    public PullLeftRefreshLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gJU = 0.0f;
        this.gJW = false;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.view.horizontalpullview.PullLeftRefreshLayout.1
            private boolean gJX = true;
            private int gJY = 0;
            private ValueAnimator gJZ;
            private int state;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i2) {
                this.state = i2;
                if (PullLeftRefreshLayout.this.gJW && this.state == 0 && !this.gJX) {
                    if (this.gJZ != null) {
                        this.gJZ.cancel();
                    }
                    int i22 = (int) (PullLeftRefreshLayout.this.gJP - 1.0f);
                    if (this.gJY > i22) {
                        this.gJY = i22;
                    }
                    this.gJZ = ValueAnimator.ofInt(this.gJY, 0);
                    this.gJZ.setDuration(100L);
                    this.gJZ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.view.horizontalpullview.PullLeftRefreshLayout.1.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            PullLeftRefreshLayout.this.setTranslationStatus(-((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    this.gJZ.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.enterForum.view.horizontalpullview.PullLeftRefreshLayout.1.2
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                            onAnimationEnd(animator);
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            PullLeftRefreshLayout.this.bKo();
                        }
                    });
                    this.gJZ.start();
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NonNull RecyclerView recyclerView, int i2, int i22) {
                this.gJY = i2;
                if (!recyclerView.canScrollHorizontally(1) && i2 > 0) {
                    this.gJX = false;
                } else {
                    this.gJX = true;
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
    }

    public void setCallback(a aVar) {
        this.gJV = aVar;
    }

    public void setRefreshViewAndListener(com.baidu.tieba.enterForum.view.horizontalpullview.a aVar) {
        this.gJJ = aVar;
        this.gJK = aVar.getView();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = GravityCompat.END;
        this.gJK.setLayoutParams(layoutParams);
        addView(this.gJK, 0);
    }

    public void setEnablePull(boolean z) {
        this.gJW = z;
    }

    public boolean bKm() {
        return this.gJW;
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
        if (this.gJK != null) {
            this.gJM = this.gJK.getMeasuredWidth();
            this.gJO = this.gJM * 2;
            this.gJN = this.gJM + this.gJO;
            this.gJP = this.gJM;
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.gJL == 0) {
            this.gJK.setTranslationX(this.gJM);
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                this.gJS = x;
                this.mLastX = x;
                this.gJT = y;
                this.mLastY = y;
                break;
            case 1:
            case 3:
                this.gJS = 0;
                this.gJT = 0;
                break;
            case 2:
                int i = x - this.gJS;
                this.gJS = x;
                this.mLastX = x;
                this.gJT = y;
                this.mLastY = y;
                if (Math.abs(i) > Math.abs(y - this.gJT) && this.gJW && i < 0 && !bKq() && this.gJL == 0) {
                    if (getParent() != null) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    this.gJL = 2;
                    if (this.gJJ != null) {
                        this.gJJ.bT(this.gJK);
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
        if (!this.gJW) {
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
                this.gJS = 0;
                this.mLastX = 0;
                this.gJT = 0;
                this.mLastY = 0;
                if (Math.abs(this.gJU) < this.gJP) {
                    bKn();
                    return true;
                }
                bKp();
                return true;
            case 2:
                int i = x - this.mLastX;
                this.mLastX = x;
                this.mLastY = y;
                this.gJU = ((1.0f - Math.abs(this.gJU / this.gJN)) * i) + this.gJU;
                if (this.gJU >= 0.0f) {
                    this.gJU = 0.0f;
                    this.mRecyclerView.setTranslationX(this.gJU);
                    if (this.gJJ != null) {
                        this.gJJ.bT(this.gJK);
                    }
                } else if (this.gJU <= (-this.gJN)) {
                    this.gJU = -this.gJN;
                    this.mRecyclerView.setTranslationX(this.gJU);
                    if (this.gJJ != null) {
                        this.gJJ.bU(this.gJK);
                    }
                } else {
                    this.mRecyclerView.setTranslationX(this.gJU);
                    if (Math.abs(this.gJU) > this.gJP) {
                        if (this.gJJ != null) {
                            this.gJJ.bU(this.gJK);
                        }
                    } else if (this.gJJ != null) {
                        this.gJJ.bT(this.gJK);
                    }
                }
                if (this.gJK != null) {
                    this.gJK.setTranslationX(this.gJM + this.gJU);
                    return true;
                }
                return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void bKn() {
        if (this.gJQ != null) {
            this.gJQ.cancel();
        }
        this.gJQ = ValueAnimator.ofFloat(Math.abs(this.gJU), 0.0f);
        this.gJQ.setDuration(150L);
        this.gJQ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.view.horizontalpullview.PullLeftRefreshLayout.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null) {
                    PullLeftRefreshLayout.this.setTranslationStatus(-((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.gJQ.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.enterForum.view.horizontalpullview.PullLeftRefreshLayout.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PullLeftRefreshLayout.this.bKo();
            }
        });
        this.gJQ.start();
        if (this.gJK != null) {
            this.gJJ.bT(this.gJK);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTranslationStatus(float f) {
        if (this.mRecyclerView != null) {
            this.mRecyclerView.setTranslationX(f);
        }
        if (this.gJK != null) {
            this.gJK.setTranslationX(this.gJM + f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKo() {
        this.gJL = 0;
        this.gJU = 0.0f;
        setTranslationStatus(0.0f);
    }

    private void bKp() {
        if (this.gJR != null) {
            this.gJR.cancel();
        }
        this.gJR = ValueAnimator.ofFloat(Math.abs(this.gJU), 0.0f);
        this.gJR.setDuration(150L);
        this.gJR.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.view.horizontalpullview.PullLeftRefreshLayout.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null) {
                    PullLeftRefreshLayout.this.setTranslationStatus(-((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.gJR.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.enterForum.view.horizontalpullview.PullLeftRefreshLayout.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PullLeftRefreshLayout.this.bKo();
                PullLeftRefreshLayout.this.postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.view.horizontalpullview.PullLeftRefreshLayout.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PullLeftRefreshLayout.this.bKr();
                    }
                }, 50L);
            }
        });
        this.gJR.start();
        if (this.gJK != null) {
            this.gJJ.bT(this.gJK);
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

    public boolean bKq() {
        return ViewCompat.canScrollHorizontally(this.mRecyclerView, 1);
    }

    public void bKr() {
        if (this.gJV != null) {
            this.gJV.bKl();
        }
    }
}
