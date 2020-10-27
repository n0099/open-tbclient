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
    private ValueAnimator fyA;
    private int fyB;
    private int fyC;
    private float fyD;
    private a fyE;
    private boolean fyF;
    private com.baidu.tbadk.widget.horizontalpullview.a fys;
    private View fyt;
    private int fyu;
    private int fyv;
    private int fyw;
    private int fyx;
    private float fyy;
    private ValueAnimator fyz;
    private int mLastX;
    private int mLastY;
    RecyclerView.OnScrollListener mOnScrollListener;
    private RecyclerView mRecyclerView;

    /* loaded from: classes21.dex */
    public interface a {
        void bCG();
    }

    public PullLeftRefreshLayout(@NonNull Context context) {
        super(context);
        this.fyD = 0.0f;
        this.fyF = false;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1
            private boolean fyG = true;
            private int fyH = 0;
            private ValueAnimator fyI;
            private int state;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
                this.state = i;
                if (PullLeftRefreshLayout.this.fyF && this.state == 0 && !this.fyG) {
                    if (this.fyI != null) {
                        this.fyI.cancel();
                    }
                    int i2 = (int) (PullLeftRefreshLayout.this.fyy - 1.0f);
                    if (this.fyH > i2) {
                        this.fyH = i2;
                    }
                    this.fyI = ValueAnimator.ofInt(this.fyH, 0);
                    this.fyI.setDuration(100L);
                    this.fyI.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            PullLeftRefreshLayout.this.setTranslationStatus(-((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    this.fyI.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1.2
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                            onAnimationEnd(animator);
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            PullLeftRefreshLayout.this.bCC();
                        }
                    });
                    this.fyI.start();
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
                this.fyH = i;
                if (!recyclerView.canScrollHorizontally(1) && i > 0) {
                    this.fyG = false;
                } else {
                    this.fyG = true;
                }
            }
        };
        init(context);
    }

    public PullLeftRefreshLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fyD = 0.0f;
        this.fyF = false;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1
            private boolean fyG = true;
            private int fyH = 0;
            private ValueAnimator fyI;
            private int state;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
                this.state = i;
                if (PullLeftRefreshLayout.this.fyF && this.state == 0 && !this.fyG) {
                    if (this.fyI != null) {
                        this.fyI.cancel();
                    }
                    int i2 = (int) (PullLeftRefreshLayout.this.fyy - 1.0f);
                    if (this.fyH > i2) {
                        this.fyH = i2;
                    }
                    this.fyI = ValueAnimator.ofInt(this.fyH, 0);
                    this.fyI.setDuration(100L);
                    this.fyI.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            PullLeftRefreshLayout.this.setTranslationStatus(-((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    this.fyI.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1.2
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                            onAnimationEnd(animator);
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            PullLeftRefreshLayout.this.bCC();
                        }
                    });
                    this.fyI.start();
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
                this.fyH = i;
                if (!recyclerView.canScrollHorizontally(1) && i > 0) {
                    this.fyG = false;
                } else {
                    this.fyG = true;
                }
            }
        };
        init(context);
    }

    public PullLeftRefreshLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fyD = 0.0f;
        this.fyF = false;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1
            private boolean fyG = true;
            private int fyH = 0;
            private ValueAnimator fyI;
            private int state;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i2) {
                this.state = i2;
                if (PullLeftRefreshLayout.this.fyF && this.state == 0 && !this.fyG) {
                    if (this.fyI != null) {
                        this.fyI.cancel();
                    }
                    int i22 = (int) (PullLeftRefreshLayout.this.fyy - 1.0f);
                    if (this.fyH > i22) {
                        this.fyH = i22;
                    }
                    this.fyI = ValueAnimator.ofInt(this.fyH, 0);
                    this.fyI.setDuration(100L);
                    this.fyI.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            PullLeftRefreshLayout.this.setTranslationStatus(-((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    this.fyI.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1.2
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                            onAnimationEnd(animator);
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            PullLeftRefreshLayout.this.bCC();
                        }
                    });
                    this.fyI.start();
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NonNull RecyclerView recyclerView, int i2, int i22) {
                this.fyH = i2;
                if (!recyclerView.canScrollHorizontally(1) && i2 > 0) {
                    this.fyG = false;
                } else {
                    this.fyG = true;
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
    }

    public void setCallback(a aVar) {
        this.fyE = aVar;
    }

    public void setRefreshViewAndListener(com.baidu.tbadk.widget.horizontalpullview.a aVar) {
        this.fys = aVar;
        this.fyt = aVar.getView();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = GravityCompat.END;
        this.fyt.setLayoutParams(layoutParams);
        addView(this.fyt, 0);
    }

    public void setEnablePull(boolean z) {
        this.fyF = z;
    }

    public boolean bCA() {
        return this.fyF;
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
        if (this.fyt != null) {
            this.fyv = this.fyt.getMeasuredWidth();
            this.fyx = this.fyv * 2;
            this.fyw = this.fyv + this.fyx;
            this.fyy = this.fyv;
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.fyu == 0) {
            this.fyt.setTranslationX(this.fyv);
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                this.fyB = x;
                this.mLastX = x;
                this.fyC = y;
                this.mLastY = y;
                break;
            case 1:
            case 3:
                this.fyB = 0;
                this.fyC = 0;
                break;
            case 2:
                int i = x - this.fyB;
                this.fyB = x;
                this.mLastX = x;
                this.fyC = y;
                this.mLastY = y;
                if (Math.abs(i) > Math.abs(y - this.fyC) && this.fyF && i < 0 && !bCE() && this.fyu == 0) {
                    if (getParent() != null) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    this.fyu = 2;
                    if (this.fys != null) {
                        this.fys.bE(this.fyt);
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
        if (!this.fyF) {
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
                this.fyB = 0;
                this.mLastX = 0;
                this.fyC = 0;
                this.mLastY = 0;
                if (Math.abs(this.fyD) < this.fyy) {
                    bCB();
                    return true;
                }
                bCD();
                return true;
            case 2:
                int i = x - this.mLastX;
                this.mLastX = x;
                this.mLastY = y;
                this.fyD = ((1.0f - Math.abs(this.fyD / this.fyw)) * i) + this.fyD;
                if (this.fyD >= 0.0f) {
                    this.fyD = 0.0f;
                    this.mRecyclerView.setTranslationX(this.fyD);
                    if (this.fys != null) {
                        this.fys.bE(this.fyt);
                    }
                } else if (this.fyD <= (-this.fyw)) {
                    this.fyD = -this.fyw;
                    this.mRecyclerView.setTranslationX(this.fyD);
                    if (this.fys != null) {
                        this.fys.bF(this.fyt);
                    }
                } else {
                    this.mRecyclerView.setTranslationX(this.fyD);
                    if (Math.abs(this.fyD) > this.fyy) {
                        if (this.fys != null) {
                            this.fys.bF(this.fyt);
                        }
                    } else if (this.fys != null) {
                        this.fys.bE(this.fyt);
                    }
                }
                if (this.fyt != null) {
                    this.fyt.setTranslationX(this.fyv + this.fyD);
                    return true;
                }
                return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void bCB() {
        if (this.fyz != null) {
            this.fyz.cancel();
        }
        this.fyz = ValueAnimator.ofFloat(Math.abs(this.fyD), 0.0f);
        this.fyz.setDuration(150L);
        this.fyz.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null) {
                    PullLeftRefreshLayout.this.setTranslationStatus(-((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.fyz.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PullLeftRefreshLayout.this.bCC();
            }
        });
        this.fyz.start();
        if (this.fyt != null) {
            this.fys.bE(this.fyt);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTranslationStatus(float f) {
        if (this.mRecyclerView != null) {
            this.mRecyclerView.setTranslationX(f);
        }
        if (this.fyt != null) {
            this.fyt.setTranslationX(this.fyv + f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCC() {
        this.fyu = 0;
        this.fyD = 0.0f;
        setTranslationStatus(0.0f);
    }

    private void bCD() {
        if (this.fyA != null) {
            this.fyA.cancel();
        }
        this.fyA = ValueAnimator.ofFloat(Math.abs(this.fyD), 0.0f);
        this.fyA.setDuration(150L);
        this.fyA.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null) {
                    PullLeftRefreshLayout.this.setTranslationStatus(-((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.fyA.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PullLeftRefreshLayout.this.bCC();
                PullLeftRefreshLayout.this.postDelayed(new Runnable() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PullLeftRefreshLayout.this.bCF();
                    }
                }, 50L);
            }
        });
        this.fyA.start();
        if (this.fyt != null) {
            this.fys.bE(this.fyt);
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

    public boolean bCE() {
        return ViewCompat.canScrollHorizontally(this.mRecyclerView, 1);
    }

    public void bCF() {
        if (this.fyE != null) {
            this.fyE.bCG();
        }
    }
}
