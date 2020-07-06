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
/* loaded from: classes8.dex */
public class PullLeftRefreshLayout extends FrameLayout {
    private com.baidu.tbadk.widget.horizontalpullview.a eJH;
    private View eJI;
    private int eJJ;
    private int eJK;
    private int eJL;
    private int eJM;
    private float eJN;
    private ValueAnimator eJO;
    private ValueAnimator eJP;
    private int eJQ;
    private int eJR;
    private float eJS;
    private a eJT;
    private boolean eJU;
    private int mLastX;
    private int mLastY;
    RecyclerView.OnScrollListener mOnScrollListener;
    private RecyclerView mRecyclerView;

    /* loaded from: classes8.dex */
    public interface a {
        void bkn();
    }

    public PullLeftRefreshLayout(@NonNull Context context) {
        super(context);
        this.eJS = 0.0f;
        this.eJU = false;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1
            private boolean eJV = true;
            private int eJW = 0;
            private ValueAnimator eJX;
            private int state;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
                this.state = i;
                if (PullLeftRefreshLayout.this.eJU && this.state == 0 && !this.eJV) {
                    if (this.eJX != null) {
                        this.eJX.cancel();
                    }
                    int i2 = (int) (PullLeftRefreshLayout.this.eJN - 1.0f);
                    if (this.eJW > i2) {
                        this.eJW = i2;
                    }
                    this.eJX = ValueAnimator.ofInt(this.eJW, 0);
                    this.eJX.setDuration(100L);
                    this.eJX.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            PullLeftRefreshLayout.this.setTranslationStatus(-((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    this.eJX.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1.2
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                            onAnimationEnd(animator);
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            PullLeftRefreshLayout.this.bkj();
                        }
                    });
                    this.eJX.start();
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
                this.eJW = i;
                if (!recyclerView.canScrollHorizontally(1) && i > 0) {
                    this.eJV = false;
                } else {
                    this.eJV = true;
                }
            }
        };
        init(context);
    }

    public PullLeftRefreshLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eJS = 0.0f;
        this.eJU = false;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1
            private boolean eJV = true;
            private int eJW = 0;
            private ValueAnimator eJX;
            private int state;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
                this.state = i;
                if (PullLeftRefreshLayout.this.eJU && this.state == 0 && !this.eJV) {
                    if (this.eJX != null) {
                        this.eJX.cancel();
                    }
                    int i2 = (int) (PullLeftRefreshLayout.this.eJN - 1.0f);
                    if (this.eJW > i2) {
                        this.eJW = i2;
                    }
                    this.eJX = ValueAnimator.ofInt(this.eJW, 0);
                    this.eJX.setDuration(100L);
                    this.eJX.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            PullLeftRefreshLayout.this.setTranslationStatus(-((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    this.eJX.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1.2
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                            onAnimationEnd(animator);
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            PullLeftRefreshLayout.this.bkj();
                        }
                    });
                    this.eJX.start();
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
                this.eJW = i;
                if (!recyclerView.canScrollHorizontally(1) && i > 0) {
                    this.eJV = false;
                } else {
                    this.eJV = true;
                }
            }
        };
        init(context);
    }

    public PullLeftRefreshLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eJS = 0.0f;
        this.eJU = false;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1
            private boolean eJV = true;
            private int eJW = 0;
            private ValueAnimator eJX;
            private int state;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i2) {
                this.state = i2;
                if (PullLeftRefreshLayout.this.eJU && this.state == 0 && !this.eJV) {
                    if (this.eJX != null) {
                        this.eJX.cancel();
                    }
                    int i22 = (int) (PullLeftRefreshLayout.this.eJN - 1.0f);
                    if (this.eJW > i22) {
                        this.eJW = i22;
                    }
                    this.eJX = ValueAnimator.ofInt(this.eJW, 0);
                    this.eJX.setDuration(100L);
                    this.eJX.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            PullLeftRefreshLayout.this.setTranslationStatus(-((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    this.eJX.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1.2
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                            onAnimationEnd(animator);
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            PullLeftRefreshLayout.this.bkj();
                        }
                    });
                    this.eJX.start();
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NonNull RecyclerView recyclerView, int i2, int i22) {
                this.eJW = i2;
                if (!recyclerView.canScrollHorizontally(1) && i2 > 0) {
                    this.eJV = false;
                } else {
                    this.eJV = true;
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
    }

    public void setCallback(a aVar) {
        this.eJT = aVar;
    }

    public void setRefreshViewAndListener(com.baidu.tbadk.widget.horizontalpullview.a aVar) {
        this.eJH = aVar;
        this.eJI = aVar.getView();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = GravityCompat.END;
        this.eJI.setLayoutParams(layoutParams);
        addView(this.eJI, 0);
    }

    public void setEnablePull(boolean z) {
        this.eJU = z;
    }

    public boolean bkh() {
        return this.eJU;
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
        if (this.eJI != null) {
            this.eJK = this.eJI.getMeasuredWidth();
            this.eJM = this.eJK * 2;
            this.eJL = this.eJK + this.eJM;
            this.eJN = this.eJK;
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.eJJ == 0) {
            this.eJI.setTranslationX(this.eJK);
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                this.eJQ = x;
                this.mLastX = x;
                this.eJR = y;
                this.mLastY = y;
                break;
            case 1:
            case 3:
                this.eJQ = 0;
                this.eJR = 0;
                break;
            case 2:
                int i = x - this.eJQ;
                this.eJQ = x;
                this.mLastX = x;
                this.eJR = y;
                this.mLastY = y;
                if (Math.abs(i) > Math.abs(y - this.eJR) && this.eJU && i < 0 && !bkl() && this.eJJ == 0) {
                    if (getParent() != null) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    this.eJJ = 2;
                    if (this.eJH != null) {
                        this.eJH.bn(this.eJI);
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
        if (!this.eJU) {
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
                this.eJQ = 0;
                this.mLastX = 0;
                this.eJR = 0;
                this.mLastY = 0;
                if (Math.abs(this.eJS) < this.eJN) {
                    bki();
                    return true;
                }
                bkk();
                return true;
            case 2:
                int i = x - this.mLastX;
                this.mLastX = x;
                this.mLastY = y;
                this.eJS = ((1.0f - Math.abs(this.eJS / this.eJL)) * i) + this.eJS;
                if (this.eJS >= 0.0f) {
                    this.eJS = 0.0f;
                    this.mRecyclerView.setTranslationX(this.eJS);
                    if (this.eJH != null) {
                        this.eJH.bn(this.eJI);
                    }
                } else if (this.eJS <= (-this.eJL)) {
                    this.eJS = -this.eJL;
                    this.mRecyclerView.setTranslationX(this.eJS);
                    if (this.eJH != null) {
                        this.eJH.bo(this.eJI);
                    }
                } else {
                    this.mRecyclerView.setTranslationX(this.eJS);
                    if (Math.abs(this.eJS) > this.eJN) {
                        if (this.eJH != null) {
                            this.eJH.bo(this.eJI);
                        }
                    } else if (this.eJH != null) {
                        this.eJH.bn(this.eJI);
                    }
                }
                if (this.eJI != null) {
                    this.eJI.setTranslationX(this.eJK + this.eJS);
                    return true;
                }
                return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void bki() {
        if (this.eJO != null) {
            this.eJO.cancel();
        }
        this.eJO = ValueAnimator.ofFloat(Math.abs(this.eJS), 0.0f);
        this.eJO.setDuration(150L);
        this.eJO.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null) {
                    PullLeftRefreshLayout.this.setTranslationStatus(-((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.eJO.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PullLeftRefreshLayout.this.bkj();
            }
        });
        this.eJO.start();
        if (this.eJI != null) {
            this.eJH.bn(this.eJI);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTranslationStatus(float f) {
        if (this.mRecyclerView != null) {
            this.mRecyclerView.setTranslationX(f);
        }
        if (this.eJI != null) {
            this.eJI.setTranslationX(this.eJK + f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkj() {
        this.eJJ = 0;
        this.eJS = 0.0f;
        setTranslationStatus(0.0f);
    }

    private void bkk() {
        if (this.eJP != null) {
            this.eJP.cancel();
        }
        this.eJP = ValueAnimator.ofFloat(Math.abs(this.eJS), 0.0f);
        this.eJP.setDuration(150L);
        this.eJP.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null) {
                    PullLeftRefreshLayout.this.setTranslationStatus(-((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.eJP.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PullLeftRefreshLayout.this.bkj();
                PullLeftRefreshLayout.this.postDelayed(new Runnable() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PullLeftRefreshLayout.this.bkm();
                    }
                }, 50L);
            }
        });
        this.eJP.start();
        if (this.eJI != null) {
            this.eJH.bn(this.eJI);
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

    public boolean bkl() {
        return ViewCompat.canScrollHorizontally(this.mRecyclerView, 1);
    }

    public void bkm() {
        if (this.eJT != null) {
            this.eJT.bkn();
        }
    }
}
