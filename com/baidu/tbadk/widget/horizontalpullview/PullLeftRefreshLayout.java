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
/* loaded from: classes20.dex */
public class PullLeftRefreshLayout extends FrameLayout {
    private com.baidu.tbadk.widget.horizontalpullview.a fDL;
    private View fDM;
    private int fDN;
    private int fDO;
    private int fDP;
    private int fDQ;
    private float fDR;
    private ValueAnimator fDS;
    private ValueAnimator fDT;
    private int fDU;
    private int fDV;
    private float fDW;
    private a fDX;
    private boolean fDY;
    private int mLastX;
    private int mLastY;
    RecyclerView.OnScrollListener mOnScrollListener;
    private RecyclerView mRecyclerView;

    /* loaded from: classes20.dex */
    public interface a {
        void bEy();
    }

    public PullLeftRefreshLayout(@NonNull Context context) {
        super(context);
        this.fDW = 0.0f;
        this.fDY = false;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1
            private boolean fDZ = true;
            private int fEa = 0;
            private ValueAnimator fEb;
            private int state;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
                this.state = i;
                if (PullLeftRefreshLayout.this.fDY && this.state == 0 && !this.fDZ) {
                    if (this.fEb != null) {
                        this.fEb.cancel();
                    }
                    int i2 = (int) (PullLeftRefreshLayout.this.fDR - 1.0f);
                    if (this.fEa > i2) {
                        this.fEa = i2;
                    }
                    this.fEb = ValueAnimator.ofInt(this.fEa, 0);
                    this.fEb.setDuration(100L);
                    this.fEb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            PullLeftRefreshLayout.this.setTranslationStatus(-((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    this.fEb.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1.2
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                            onAnimationEnd(animator);
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            PullLeftRefreshLayout.this.bEu();
                        }
                    });
                    this.fEb.start();
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
                this.fEa = i;
                if (!recyclerView.canScrollHorizontally(1) && i > 0) {
                    this.fDZ = false;
                } else {
                    this.fDZ = true;
                }
            }
        };
        init(context);
    }

    public PullLeftRefreshLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fDW = 0.0f;
        this.fDY = false;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1
            private boolean fDZ = true;
            private int fEa = 0;
            private ValueAnimator fEb;
            private int state;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
                this.state = i;
                if (PullLeftRefreshLayout.this.fDY && this.state == 0 && !this.fDZ) {
                    if (this.fEb != null) {
                        this.fEb.cancel();
                    }
                    int i2 = (int) (PullLeftRefreshLayout.this.fDR - 1.0f);
                    if (this.fEa > i2) {
                        this.fEa = i2;
                    }
                    this.fEb = ValueAnimator.ofInt(this.fEa, 0);
                    this.fEb.setDuration(100L);
                    this.fEb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            PullLeftRefreshLayout.this.setTranslationStatus(-((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    this.fEb.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1.2
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                            onAnimationEnd(animator);
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            PullLeftRefreshLayout.this.bEu();
                        }
                    });
                    this.fEb.start();
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
                this.fEa = i;
                if (!recyclerView.canScrollHorizontally(1) && i > 0) {
                    this.fDZ = false;
                } else {
                    this.fDZ = true;
                }
            }
        };
        init(context);
    }

    public PullLeftRefreshLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fDW = 0.0f;
        this.fDY = false;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1
            private boolean fDZ = true;
            private int fEa = 0;
            private ValueAnimator fEb;
            private int state;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i2) {
                this.state = i2;
                if (PullLeftRefreshLayout.this.fDY && this.state == 0 && !this.fDZ) {
                    if (this.fEb != null) {
                        this.fEb.cancel();
                    }
                    int i22 = (int) (PullLeftRefreshLayout.this.fDR - 1.0f);
                    if (this.fEa > i22) {
                        this.fEa = i22;
                    }
                    this.fEb = ValueAnimator.ofInt(this.fEa, 0);
                    this.fEb.setDuration(100L);
                    this.fEb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            PullLeftRefreshLayout.this.setTranslationStatus(-((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    this.fEb.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1.2
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                            onAnimationEnd(animator);
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            PullLeftRefreshLayout.this.bEu();
                        }
                    });
                    this.fEb.start();
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NonNull RecyclerView recyclerView, int i2, int i22) {
                this.fEa = i2;
                if (!recyclerView.canScrollHorizontally(1) && i2 > 0) {
                    this.fDZ = false;
                } else {
                    this.fDZ = true;
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
    }

    public void setCallback(a aVar) {
        this.fDX = aVar;
    }

    public void setRefreshViewAndListener(com.baidu.tbadk.widget.horizontalpullview.a aVar) {
        this.fDL = aVar;
        this.fDM = aVar.getView();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = GravityCompat.END;
        this.fDM.setLayoutParams(layoutParams);
        addView(this.fDM, 0);
    }

    public void setEnablePull(boolean z) {
        this.fDY = z;
    }

    public boolean bEs() {
        return this.fDY;
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
        if (this.fDM != null) {
            this.fDO = this.fDM.getMeasuredWidth();
            this.fDQ = this.fDO * 2;
            this.fDP = this.fDO + this.fDQ;
            this.fDR = this.fDO;
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.fDN == 0) {
            this.fDM.setTranslationX(this.fDO);
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                this.fDU = x;
                this.mLastX = x;
                this.fDV = y;
                this.mLastY = y;
                break;
            case 1:
            case 3:
                this.fDU = 0;
                this.fDV = 0;
                break;
            case 2:
                int i = x - this.fDU;
                this.fDU = x;
                this.mLastX = x;
                this.fDV = y;
                this.mLastY = y;
                if (Math.abs(i) > Math.abs(y - this.fDV) && this.fDY && i < 0 && !bEw() && this.fDN == 0) {
                    if (getParent() != null) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    this.fDN = 2;
                    if (this.fDL != null) {
                        this.fDL.bL(this.fDM);
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
        if (!this.fDY) {
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
                this.fDU = 0;
                this.mLastX = 0;
                this.fDV = 0;
                this.mLastY = 0;
                if (Math.abs(this.fDW) < this.fDR) {
                    bEt();
                    return true;
                }
                bEv();
                return true;
            case 2:
                int i = x - this.mLastX;
                this.mLastX = x;
                this.mLastY = y;
                this.fDW = ((1.0f - Math.abs(this.fDW / this.fDP)) * i) + this.fDW;
                if (this.fDW >= 0.0f) {
                    this.fDW = 0.0f;
                    this.mRecyclerView.setTranslationX(this.fDW);
                    if (this.fDL != null) {
                        this.fDL.bL(this.fDM);
                    }
                } else if (this.fDW <= (-this.fDP)) {
                    this.fDW = -this.fDP;
                    this.mRecyclerView.setTranslationX(this.fDW);
                    if (this.fDL != null) {
                        this.fDL.bM(this.fDM);
                    }
                } else {
                    this.mRecyclerView.setTranslationX(this.fDW);
                    if (Math.abs(this.fDW) > this.fDR) {
                        if (this.fDL != null) {
                            this.fDL.bM(this.fDM);
                        }
                    } else if (this.fDL != null) {
                        this.fDL.bL(this.fDM);
                    }
                }
                if (this.fDM != null) {
                    this.fDM.setTranslationX(this.fDO + this.fDW);
                    return true;
                }
                return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void bEt() {
        if (this.fDS != null) {
            this.fDS.cancel();
        }
        this.fDS = ValueAnimator.ofFloat(Math.abs(this.fDW), 0.0f);
        this.fDS.setDuration(150L);
        this.fDS.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null) {
                    PullLeftRefreshLayout.this.setTranslationStatus(-((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.fDS.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PullLeftRefreshLayout.this.bEu();
            }
        });
        this.fDS.start();
        if (this.fDM != null) {
            this.fDL.bL(this.fDM);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTranslationStatus(float f) {
        if (this.mRecyclerView != null) {
            this.mRecyclerView.setTranslationX(f);
        }
        if (this.fDM != null) {
            this.fDM.setTranslationX(this.fDO + f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEu() {
        this.fDN = 0;
        this.fDW = 0.0f;
        setTranslationStatus(0.0f);
    }

    private void bEv() {
        if (this.fDT != null) {
            this.fDT.cancel();
        }
        this.fDT = ValueAnimator.ofFloat(Math.abs(this.fDW), 0.0f);
        this.fDT.setDuration(150L);
        this.fDT.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null) {
                    PullLeftRefreshLayout.this.setTranslationStatus(-((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.fDT.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PullLeftRefreshLayout.this.bEu();
                PullLeftRefreshLayout.this.postDelayed(new Runnable() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PullLeftRefreshLayout.this.bEx();
                    }
                }, 50L);
            }
        });
        this.fDT.start();
        if (this.fDM != null) {
            this.fDL.bL(this.fDM);
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

    public boolean bEw() {
        return ViewCompat.canScrollHorizontally(this.mRecyclerView, 1);
    }

    public void bEx() {
        if (this.fDX != null) {
            this.fDX.bEy();
        }
    }
}
