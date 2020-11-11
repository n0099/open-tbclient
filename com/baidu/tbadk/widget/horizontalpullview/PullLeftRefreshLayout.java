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
    private com.baidu.tbadk.widget.horizontalpullview.a fEi;
    private View fEj;
    private int fEk;
    private int fEl;
    private int fEm;
    private int fEn;
    private float fEo;
    private ValueAnimator fEp;
    private ValueAnimator fEq;
    private int fEr;
    private int fEs;
    private float fEt;
    private a fEu;
    private boolean fEv;
    private int mLastX;
    private int mLastY;
    RecyclerView.OnScrollListener mOnScrollListener;
    private RecyclerView mRecyclerView;

    /* loaded from: classes21.dex */
    public interface a {
        void bFf();
    }

    public PullLeftRefreshLayout(@NonNull Context context) {
        super(context);
        this.fEt = 0.0f;
        this.fEv = false;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1
            private boolean fEw = true;
            private int fEx = 0;
            private ValueAnimator fEy;
            private int state;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
                this.state = i;
                if (PullLeftRefreshLayout.this.fEv && this.state == 0 && !this.fEw) {
                    if (this.fEy != null) {
                        this.fEy.cancel();
                    }
                    int i2 = (int) (PullLeftRefreshLayout.this.fEo - 1.0f);
                    if (this.fEx > i2) {
                        this.fEx = i2;
                    }
                    this.fEy = ValueAnimator.ofInt(this.fEx, 0);
                    this.fEy.setDuration(100L);
                    this.fEy.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            PullLeftRefreshLayout.this.setTranslationStatus(-((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    this.fEy.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1.2
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                            onAnimationEnd(animator);
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            PullLeftRefreshLayout.this.bFb();
                        }
                    });
                    this.fEy.start();
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
                this.fEx = i;
                if (!recyclerView.canScrollHorizontally(1) && i > 0) {
                    this.fEw = false;
                } else {
                    this.fEw = true;
                }
            }
        };
        init(context);
    }

    public PullLeftRefreshLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fEt = 0.0f;
        this.fEv = false;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1
            private boolean fEw = true;
            private int fEx = 0;
            private ValueAnimator fEy;
            private int state;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
                this.state = i;
                if (PullLeftRefreshLayout.this.fEv && this.state == 0 && !this.fEw) {
                    if (this.fEy != null) {
                        this.fEy.cancel();
                    }
                    int i2 = (int) (PullLeftRefreshLayout.this.fEo - 1.0f);
                    if (this.fEx > i2) {
                        this.fEx = i2;
                    }
                    this.fEy = ValueAnimator.ofInt(this.fEx, 0);
                    this.fEy.setDuration(100L);
                    this.fEy.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            PullLeftRefreshLayout.this.setTranslationStatus(-((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    this.fEy.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1.2
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                            onAnimationEnd(animator);
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            PullLeftRefreshLayout.this.bFb();
                        }
                    });
                    this.fEy.start();
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
                this.fEx = i;
                if (!recyclerView.canScrollHorizontally(1) && i > 0) {
                    this.fEw = false;
                } else {
                    this.fEw = true;
                }
            }
        };
        init(context);
    }

    public PullLeftRefreshLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fEt = 0.0f;
        this.fEv = false;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1
            private boolean fEw = true;
            private int fEx = 0;
            private ValueAnimator fEy;
            private int state;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i2) {
                this.state = i2;
                if (PullLeftRefreshLayout.this.fEv && this.state == 0 && !this.fEw) {
                    if (this.fEy != null) {
                        this.fEy.cancel();
                    }
                    int i22 = (int) (PullLeftRefreshLayout.this.fEo - 1.0f);
                    if (this.fEx > i22) {
                        this.fEx = i22;
                    }
                    this.fEy = ValueAnimator.ofInt(this.fEx, 0);
                    this.fEy.setDuration(100L);
                    this.fEy.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            PullLeftRefreshLayout.this.setTranslationStatus(-((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    this.fEy.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1.2
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                            onAnimationEnd(animator);
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            PullLeftRefreshLayout.this.bFb();
                        }
                    });
                    this.fEy.start();
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NonNull RecyclerView recyclerView, int i2, int i22) {
                this.fEx = i2;
                if (!recyclerView.canScrollHorizontally(1) && i2 > 0) {
                    this.fEw = false;
                } else {
                    this.fEw = true;
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
    }

    public void setCallback(a aVar) {
        this.fEu = aVar;
    }

    public void setRefreshViewAndListener(com.baidu.tbadk.widget.horizontalpullview.a aVar) {
        this.fEi = aVar;
        this.fEj = aVar.getView();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = GravityCompat.END;
        this.fEj.setLayoutParams(layoutParams);
        addView(this.fEj, 0);
    }

    public void setEnablePull(boolean z) {
        this.fEv = z;
    }

    public boolean bEZ() {
        return this.fEv;
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
        if (this.fEj != null) {
            this.fEl = this.fEj.getMeasuredWidth();
            this.fEn = this.fEl * 2;
            this.fEm = this.fEl + this.fEn;
            this.fEo = this.fEl;
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.fEk == 0) {
            this.fEj.setTranslationX(this.fEl);
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                this.fEr = x;
                this.mLastX = x;
                this.fEs = y;
                this.mLastY = y;
                break;
            case 1:
            case 3:
                this.fEr = 0;
                this.fEs = 0;
                break;
            case 2:
                int i = x - this.fEr;
                this.fEr = x;
                this.mLastX = x;
                this.fEs = y;
                this.mLastY = y;
                if (Math.abs(i) > Math.abs(y - this.fEs) && this.fEv && i < 0 && !bFd() && this.fEk == 0) {
                    if (getParent() != null) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    this.fEk = 2;
                    if (this.fEi != null) {
                        this.fEi.bI(this.fEj);
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
        if (!this.fEv) {
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
                this.fEr = 0;
                this.mLastX = 0;
                this.fEs = 0;
                this.mLastY = 0;
                if (Math.abs(this.fEt) < this.fEo) {
                    bFa();
                    return true;
                }
                bFc();
                return true;
            case 2:
                int i = x - this.mLastX;
                this.mLastX = x;
                this.mLastY = y;
                this.fEt = ((1.0f - Math.abs(this.fEt / this.fEm)) * i) + this.fEt;
                if (this.fEt >= 0.0f) {
                    this.fEt = 0.0f;
                    this.mRecyclerView.setTranslationX(this.fEt);
                    if (this.fEi != null) {
                        this.fEi.bI(this.fEj);
                    }
                } else if (this.fEt <= (-this.fEm)) {
                    this.fEt = -this.fEm;
                    this.mRecyclerView.setTranslationX(this.fEt);
                    if (this.fEi != null) {
                        this.fEi.bJ(this.fEj);
                    }
                } else {
                    this.mRecyclerView.setTranslationX(this.fEt);
                    if (Math.abs(this.fEt) > this.fEo) {
                        if (this.fEi != null) {
                            this.fEi.bJ(this.fEj);
                        }
                    } else if (this.fEi != null) {
                        this.fEi.bI(this.fEj);
                    }
                }
                if (this.fEj != null) {
                    this.fEj.setTranslationX(this.fEl + this.fEt);
                    return true;
                }
                return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void bFa() {
        if (this.fEp != null) {
            this.fEp.cancel();
        }
        this.fEp = ValueAnimator.ofFloat(Math.abs(this.fEt), 0.0f);
        this.fEp.setDuration(150L);
        this.fEp.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null) {
                    PullLeftRefreshLayout.this.setTranslationStatus(-((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.fEp.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PullLeftRefreshLayout.this.bFb();
            }
        });
        this.fEp.start();
        if (this.fEj != null) {
            this.fEi.bI(this.fEj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTranslationStatus(float f) {
        if (this.mRecyclerView != null) {
            this.mRecyclerView.setTranslationX(f);
        }
        if (this.fEj != null) {
            this.fEj.setTranslationX(this.fEl + f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFb() {
        this.fEk = 0;
        this.fEt = 0.0f;
        setTranslationStatus(0.0f);
    }

    private void bFc() {
        if (this.fEq != null) {
            this.fEq.cancel();
        }
        this.fEq = ValueAnimator.ofFloat(Math.abs(this.fEt), 0.0f);
        this.fEq.setDuration(150L);
        this.fEq.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null) {
                    PullLeftRefreshLayout.this.setTranslationStatus(-((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.fEq.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PullLeftRefreshLayout.this.bFb();
                PullLeftRefreshLayout.this.postDelayed(new Runnable() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PullLeftRefreshLayout.this.bFe();
                    }
                }, 50L);
            }
        });
        this.fEq.start();
        if (this.fEj != null) {
            this.fEi.bI(this.fEj);
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

    public boolean bFd() {
        return ViewCompat.canScrollHorizontally(this.mRecyclerView, 1);
    }

    public void bFe() {
        if (this.fEu != null) {
            this.fEu.bFf();
        }
    }
}
