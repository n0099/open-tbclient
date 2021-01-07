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
    private com.baidu.tbadk.widget.horizontalpullview.a fVd;
    private View fVe;
    private int fVf;
    private int fVg;
    private int fVh;
    private int fVi;
    private float fVj;
    private ValueAnimator fVk;
    private ValueAnimator fVl;
    private int fVm;
    private int fVn;
    private float fVo;
    private a fVp;
    private boolean fVq;
    private int mLastX;
    private int mLastY;
    RecyclerView.OnScrollListener mOnScrollListener;
    private RecyclerView mRecyclerView;

    /* loaded from: classes.dex */
    public interface a {
        void bKu();
    }

    public PullLeftRefreshLayout(@NonNull Context context) {
        super(context);
        this.fVo = 0.0f;
        this.fVq = false;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1
            private boolean fVr = true;
            private int fVs = 0;
            private int state;
            private ValueAnimator valueAnimator;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
                this.state = i;
                if (PullLeftRefreshLayout.this.fVq && this.state == 0 && !this.fVr) {
                    if (this.valueAnimator != null) {
                        this.valueAnimator.cancel();
                    }
                    int i2 = (int) (PullLeftRefreshLayout.this.fVj - 1.0f);
                    if (this.fVs > i2) {
                        this.fVs = i2;
                    }
                    this.valueAnimator = ValueAnimator.ofInt(this.fVs, 0);
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
                            PullLeftRefreshLayout.this.bKq();
                        }
                    });
                    this.valueAnimator.start();
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
                this.fVs = i;
                if (!recyclerView.canScrollHorizontally(1) && i > 0) {
                    this.fVr = false;
                } else {
                    this.fVr = true;
                }
            }
        };
        init(context);
    }

    public PullLeftRefreshLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fVo = 0.0f;
        this.fVq = false;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1
            private boolean fVr = true;
            private int fVs = 0;
            private int state;
            private ValueAnimator valueAnimator;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
                this.state = i;
                if (PullLeftRefreshLayout.this.fVq && this.state == 0 && !this.fVr) {
                    if (this.valueAnimator != null) {
                        this.valueAnimator.cancel();
                    }
                    int i2 = (int) (PullLeftRefreshLayout.this.fVj - 1.0f);
                    if (this.fVs > i2) {
                        this.fVs = i2;
                    }
                    this.valueAnimator = ValueAnimator.ofInt(this.fVs, 0);
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
                            PullLeftRefreshLayout.this.bKq();
                        }
                    });
                    this.valueAnimator.start();
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
                this.fVs = i;
                if (!recyclerView.canScrollHorizontally(1) && i > 0) {
                    this.fVr = false;
                } else {
                    this.fVr = true;
                }
            }
        };
        init(context);
    }

    public PullLeftRefreshLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fVo = 0.0f;
        this.fVq = false;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1
            private boolean fVr = true;
            private int fVs = 0;
            private int state;
            private ValueAnimator valueAnimator;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i2) {
                this.state = i2;
                if (PullLeftRefreshLayout.this.fVq && this.state == 0 && !this.fVr) {
                    if (this.valueAnimator != null) {
                        this.valueAnimator.cancel();
                    }
                    int i22 = (int) (PullLeftRefreshLayout.this.fVj - 1.0f);
                    if (this.fVs > i22) {
                        this.fVs = i22;
                    }
                    this.valueAnimator = ValueAnimator.ofInt(this.fVs, 0);
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
                            PullLeftRefreshLayout.this.bKq();
                        }
                    });
                    this.valueAnimator.start();
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NonNull RecyclerView recyclerView, int i2, int i22) {
                this.fVs = i2;
                if (!recyclerView.canScrollHorizontally(1) && i2 > 0) {
                    this.fVr = false;
                } else {
                    this.fVr = true;
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
    }

    public void setCallback(a aVar) {
        this.fVp = aVar;
    }

    public void setRefreshViewAndListener(com.baidu.tbadk.widget.horizontalpullview.a aVar) {
        this.fVd = aVar;
        this.fVe = aVar.getView();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = GravityCompat.END;
        this.fVe.setLayoutParams(layoutParams);
        addView(this.fVe, 0);
    }

    public void setEnablePull(boolean z) {
        this.fVq = z;
    }

    public boolean bKo() {
        return this.fVq;
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
        if (this.fVe != null) {
            this.fVg = this.fVe.getMeasuredWidth();
            this.fVi = this.fVg * 2;
            this.fVh = this.fVg + this.fVi;
            this.fVj = this.fVg;
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.fVf == 0) {
            this.fVe.setTranslationX(this.fVg);
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                this.fVm = x;
                this.mLastX = x;
                this.fVn = y;
                this.mLastY = y;
                break;
            case 1:
            case 3:
                this.fVm = 0;
                this.fVn = 0;
                break;
            case 2:
                int i = x - this.fVm;
                this.fVm = x;
                this.mLastX = x;
                this.fVn = y;
                this.mLastY = y;
                if (Math.abs(i) > Math.abs(y - this.fVn) && this.fVq && i < 0 && !bKs() && this.fVf == 0) {
                    if (getParent() != null) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    this.fVf = 2;
                    if (this.fVd != null) {
                        this.fVd.cb(this.fVe);
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
        if (!this.fVq) {
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
                this.fVm = 0;
                this.mLastX = 0;
                this.fVn = 0;
                this.mLastY = 0;
                if (Math.abs(this.fVo) < this.fVj) {
                    bKp();
                    return true;
                }
                bKr();
                return true;
            case 2:
                int i = x - this.mLastX;
                this.mLastX = x;
                this.mLastY = y;
                this.fVo = ((1.0f - Math.abs(this.fVo / this.fVh)) * i) + this.fVo;
                if (this.fVo >= 0.0f) {
                    this.fVo = 0.0f;
                    this.mRecyclerView.setTranslationX(this.fVo);
                    if (this.fVd != null) {
                        this.fVd.cb(this.fVe);
                    }
                } else if (this.fVo <= (-this.fVh)) {
                    this.fVo = -this.fVh;
                    this.mRecyclerView.setTranslationX(this.fVo);
                    if (this.fVd != null) {
                        this.fVd.cc(this.fVe);
                    }
                } else {
                    this.mRecyclerView.setTranslationX(this.fVo);
                    if (Math.abs(this.fVo) > this.fVj) {
                        if (this.fVd != null) {
                            this.fVd.cc(this.fVe);
                        }
                    } else if (this.fVd != null) {
                        this.fVd.cb(this.fVe);
                    }
                }
                if (this.fVe != null) {
                    this.fVe.setTranslationX(this.fVg + this.fVo);
                    return true;
                }
                return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void bKp() {
        if (this.fVk != null) {
            this.fVk.cancel();
        }
        this.fVk = ValueAnimator.ofFloat(Math.abs(this.fVo), 0.0f);
        this.fVk.setDuration(150L);
        this.fVk.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null) {
                    PullLeftRefreshLayout.this.setTranslationStatus(-((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.fVk.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PullLeftRefreshLayout.this.bKq();
            }
        });
        this.fVk.start();
        if (this.fVe != null) {
            this.fVd.cb(this.fVe);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTranslationStatus(float f) {
        if (this.mRecyclerView != null) {
            this.mRecyclerView.setTranslationX(f);
        }
        if (this.fVe != null) {
            this.fVe.setTranslationX(this.fVg + f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKq() {
        this.fVf = 0;
        this.fVo = 0.0f;
        setTranslationStatus(0.0f);
    }

    private void bKr() {
        if (this.fVl != null) {
            this.fVl.cancel();
        }
        this.fVl = ValueAnimator.ofFloat(Math.abs(this.fVo), 0.0f);
        this.fVl.setDuration(150L);
        this.fVl.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null) {
                    PullLeftRefreshLayout.this.setTranslationStatus(-((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.fVl.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PullLeftRefreshLayout.this.bKq();
                PullLeftRefreshLayout.this.postDelayed(new Runnable() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PullLeftRefreshLayout.this.bKt();
                    }
                }, 50L);
            }
        });
        this.fVl.start();
        if (this.fVe != null) {
            this.fVd.cb(this.fVe);
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

    public boolean bKs() {
        return ViewCompat.canScrollHorizontally(this.mRecyclerView, 1);
    }

    public void bKt() {
        if (this.fVp != null) {
            this.fVp.bKu();
        }
    }
}
