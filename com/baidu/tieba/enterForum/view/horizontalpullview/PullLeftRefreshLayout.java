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
    private com.baidu.tieba.enterForum.view.horizontalpullview.a gJD;
    private View gJE;
    private int gJF;
    private int gJG;
    private int gJH;
    private int gJI;
    private float gJJ;
    private ValueAnimator gJK;
    private ValueAnimator gJL;
    private int gJM;
    private int gJN;
    private float gJO;
    private a gJP;
    private boolean gJQ;
    private int mLastX;
    private int mLastY;
    RecyclerView.OnScrollListener mOnScrollListener;
    private RecyclerView mRecyclerView;

    /* loaded from: classes9.dex */
    public interface a {
        void bKm();
    }

    public PullLeftRefreshLayout(@NonNull Context context) {
        super(context);
        this.gJO = 0.0f;
        this.gJQ = false;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.view.horizontalpullview.PullLeftRefreshLayout.1
            private boolean gJR = true;
            private int gJS = 0;
            private ValueAnimator gJT;
            private int state;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
                this.state = i;
                if (PullLeftRefreshLayout.this.gJQ && this.state == 0 && !this.gJR) {
                    if (this.gJT != null) {
                        this.gJT.cancel();
                    }
                    int i2 = (int) (PullLeftRefreshLayout.this.gJJ - 1.0f);
                    if (this.gJS > i2) {
                        this.gJS = i2;
                    }
                    this.gJT = ValueAnimator.ofInt(this.gJS, 0);
                    this.gJT.setDuration(100L);
                    this.gJT.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.view.horizontalpullview.PullLeftRefreshLayout.1.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            PullLeftRefreshLayout.this.setTranslationStatus(-((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    this.gJT.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.enterForum.view.horizontalpullview.PullLeftRefreshLayout.1.2
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                            onAnimationEnd(animator);
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            PullLeftRefreshLayout.this.bKp();
                        }
                    });
                    this.gJT.start();
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
                this.gJS = i;
                if (!recyclerView.canScrollHorizontally(1) && i > 0) {
                    this.gJR = false;
                } else {
                    this.gJR = true;
                }
            }
        };
        init(context);
    }

    public PullLeftRefreshLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gJO = 0.0f;
        this.gJQ = false;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.view.horizontalpullview.PullLeftRefreshLayout.1
            private boolean gJR = true;
            private int gJS = 0;
            private ValueAnimator gJT;
            private int state;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
                this.state = i;
                if (PullLeftRefreshLayout.this.gJQ && this.state == 0 && !this.gJR) {
                    if (this.gJT != null) {
                        this.gJT.cancel();
                    }
                    int i2 = (int) (PullLeftRefreshLayout.this.gJJ - 1.0f);
                    if (this.gJS > i2) {
                        this.gJS = i2;
                    }
                    this.gJT = ValueAnimator.ofInt(this.gJS, 0);
                    this.gJT.setDuration(100L);
                    this.gJT.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.view.horizontalpullview.PullLeftRefreshLayout.1.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            PullLeftRefreshLayout.this.setTranslationStatus(-((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    this.gJT.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.enterForum.view.horizontalpullview.PullLeftRefreshLayout.1.2
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                            onAnimationEnd(animator);
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            PullLeftRefreshLayout.this.bKp();
                        }
                    });
                    this.gJT.start();
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
                this.gJS = i;
                if (!recyclerView.canScrollHorizontally(1) && i > 0) {
                    this.gJR = false;
                } else {
                    this.gJR = true;
                }
            }
        };
        init(context);
    }

    public PullLeftRefreshLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gJO = 0.0f;
        this.gJQ = false;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.view.horizontalpullview.PullLeftRefreshLayout.1
            private boolean gJR = true;
            private int gJS = 0;
            private ValueAnimator gJT;
            private int state;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i2) {
                this.state = i2;
                if (PullLeftRefreshLayout.this.gJQ && this.state == 0 && !this.gJR) {
                    if (this.gJT != null) {
                        this.gJT.cancel();
                    }
                    int i22 = (int) (PullLeftRefreshLayout.this.gJJ - 1.0f);
                    if (this.gJS > i22) {
                        this.gJS = i22;
                    }
                    this.gJT = ValueAnimator.ofInt(this.gJS, 0);
                    this.gJT.setDuration(100L);
                    this.gJT.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.view.horizontalpullview.PullLeftRefreshLayout.1.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            PullLeftRefreshLayout.this.setTranslationStatus(-((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    this.gJT.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.enterForum.view.horizontalpullview.PullLeftRefreshLayout.1.2
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                            onAnimationEnd(animator);
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            PullLeftRefreshLayout.this.bKp();
                        }
                    });
                    this.gJT.start();
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NonNull RecyclerView recyclerView, int i2, int i22) {
                this.gJS = i2;
                if (!recyclerView.canScrollHorizontally(1) && i2 > 0) {
                    this.gJR = false;
                } else {
                    this.gJR = true;
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
    }

    public void setCallback(a aVar) {
        this.gJP = aVar;
    }

    public void setRefreshViewAndListener(com.baidu.tieba.enterForum.view.horizontalpullview.a aVar) {
        this.gJD = aVar;
        this.gJE = aVar.getView();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = GravityCompat.END;
        this.gJE.setLayoutParams(layoutParams);
        addView(this.gJE, 0);
    }

    public void setEnablePull(boolean z) {
        this.gJQ = z;
    }

    public boolean bKn() {
        return this.gJQ;
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
        if (this.gJE != null) {
            this.gJG = this.gJE.getMeasuredWidth();
            this.gJI = this.gJG * 2;
            this.gJH = this.gJG + this.gJI;
            this.gJJ = this.gJG;
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.gJF == 0) {
            this.gJE.setTranslationX(this.gJG);
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                this.gJM = x;
                this.mLastX = x;
                this.gJN = y;
                this.mLastY = y;
                break;
            case 1:
            case 3:
                this.gJM = 0;
                this.gJN = 0;
                break;
            case 2:
                int i = x - this.gJM;
                this.gJM = x;
                this.mLastX = x;
                this.gJN = y;
                this.mLastY = y;
                if (Math.abs(i) > Math.abs(y - this.gJN) && this.gJQ && i < 0 && !bKr() && this.gJF == 0) {
                    if (getParent() != null) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    this.gJF = 2;
                    if (this.gJD != null) {
                        this.gJD.bT(this.gJE);
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
        if (!this.gJQ) {
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
                this.gJM = 0;
                this.mLastX = 0;
                this.gJN = 0;
                this.mLastY = 0;
                if (Math.abs(this.gJO) < this.gJJ) {
                    bKo();
                    return true;
                }
                bKq();
                return true;
            case 2:
                int i = x - this.mLastX;
                this.mLastX = x;
                this.mLastY = y;
                this.gJO = ((1.0f - Math.abs(this.gJO / this.gJH)) * i) + this.gJO;
                if (this.gJO >= 0.0f) {
                    this.gJO = 0.0f;
                    this.mRecyclerView.setTranslationX(this.gJO);
                    if (this.gJD != null) {
                        this.gJD.bT(this.gJE);
                    }
                } else if (this.gJO <= (-this.gJH)) {
                    this.gJO = -this.gJH;
                    this.mRecyclerView.setTranslationX(this.gJO);
                    if (this.gJD != null) {
                        this.gJD.bU(this.gJE);
                    }
                } else {
                    this.mRecyclerView.setTranslationX(this.gJO);
                    if (Math.abs(this.gJO) > this.gJJ) {
                        if (this.gJD != null) {
                            this.gJD.bU(this.gJE);
                        }
                    } else if (this.gJD != null) {
                        this.gJD.bT(this.gJE);
                    }
                }
                if (this.gJE != null) {
                    this.gJE.setTranslationX(this.gJG + this.gJO);
                    return true;
                }
                return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void bKo() {
        if (this.gJK != null) {
            this.gJK.cancel();
        }
        this.gJK = ValueAnimator.ofFloat(Math.abs(this.gJO), 0.0f);
        this.gJK.setDuration(150L);
        this.gJK.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.view.horizontalpullview.PullLeftRefreshLayout.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null) {
                    PullLeftRefreshLayout.this.setTranslationStatus(-((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.gJK.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.enterForum.view.horizontalpullview.PullLeftRefreshLayout.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PullLeftRefreshLayout.this.bKp();
            }
        });
        this.gJK.start();
        if (this.gJE != null) {
            this.gJD.bT(this.gJE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTranslationStatus(float f) {
        if (this.mRecyclerView != null) {
            this.mRecyclerView.setTranslationX(f);
        }
        if (this.gJE != null) {
            this.gJE.setTranslationX(this.gJG + f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKp() {
        this.gJF = 0;
        this.gJO = 0.0f;
        setTranslationStatus(0.0f);
    }

    private void bKq() {
        if (this.gJL != null) {
            this.gJL.cancel();
        }
        this.gJL = ValueAnimator.ofFloat(Math.abs(this.gJO), 0.0f);
        this.gJL.setDuration(150L);
        this.gJL.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.view.horizontalpullview.PullLeftRefreshLayout.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null) {
                    PullLeftRefreshLayout.this.setTranslationStatus(-((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.gJL.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.enterForum.view.horizontalpullview.PullLeftRefreshLayout.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PullLeftRefreshLayout.this.bKp();
                PullLeftRefreshLayout.this.postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.view.horizontalpullview.PullLeftRefreshLayout.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PullLeftRefreshLayout.this.bKs();
                    }
                }, 50L);
            }
        });
        this.gJL.start();
        if (this.gJE != null) {
            this.gJD.bT(this.gJE);
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

    public boolean bKr() {
        return ViewCompat.canScrollHorizontally(this.mRecyclerView, 1);
    }

    public void bKs() {
        if (this.gJP != null) {
            this.gJP.bKm();
        }
    }
}
