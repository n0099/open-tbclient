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
    private com.baidu.tbadk.widget.horizontalpullview.a fUj;
    private View fUk;
    private int fUl;
    private int fUm;
    private int fUn;
    private int fUo;
    private float fUp;
    private ValueAnimator fUq;
    private ValueAnimator fUr;
    private int fUs;
    private int fUt;
    private float fUu;
    private a fUv;
    private boolean fUw;
    private int mLastX;
    private int mLastY;
    RecyclerView.OnScrollListener mOnScrollListener;
    private RecyclerView mRecyclerView;

    /* loaded from: classes.dex */
    public interface a {
        void bHa();
    }

    public PullLeftRefreshLayout(@NonNull Context context) {
        super(context);
        this.fUu = 0.0f;
        this.fUw = false;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1
            private boolean fUx = true;
            private int fUy = 0;
            private int state;
            private ValueAnimator valueAnimator;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
                this.state = i;
                if (PullLeftRefreshLayout.this.fUw && this.state == 0 && !this.fUx) {
                    if (this.valueAnimator != null) {
                        this.valueAnimator.cancel();
                    }
                    int i2 = (int) (PullLeftRefreshLayout.this.fUp - 1.0f);
                    if (this.fUy > i2) {
                        this.fUy = i2;
                    }
                    this.valueAnimator = ValueAnimator.ofInt(this.fUy, 0);
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
                            PullLeftRefreshLayout.this.bGW();
                        }
                    });
                    this.valueAnimator.start();
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
                this.fUy = i;
                if (!recyclerView.canScrollHorizontally(1) && i > 0) {
                    this.fUx = false;
                } else {
                    this.fUx = true;
                }
            }
        };
        init(context);
    }

    public PullLeftRefreshLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fUu = 0.0f;
        this.fUw = false;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1
            private boolean fUx = true;
            private int fUy = 0;
            private int state;
            private ValueAnimator valueAnimator;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
                this.state = i;
                if (PullLeftRefreshLayout.this.fUw && this.state == 0 && !this.fUx) {
                    if (this.valueAnimator != null) {
                        this.valueAnimator.cancel();
                    }
                    int i2 = (int) (PullLeftRefreshLayout.this.fUp - 1.0f);
                    if (this.fUy > i2) {
                        this.fUy = i2;
                    }
                    this.valueAnimator = ValueAnimator.ofInt(this.fUy, 0);
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
                            PullLeftRefreshLayout.this.bGW();
                        }
                    });
                    this.valueAnimator.start();
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
                this.fUy = i;
                if (!recyclerView.canScrollHorizontally(1) && i > 0) {
                    this.fUx = false;
                } else {
                    this.fUx = true;
                }
            }
        };
        init(context);
    }

    public PullLeftRefreshLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fUu = 0.0f;
        this.fUw = false;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.1
            private boolean fUx = true;
            private int fUy = 0;
            private int state;
            private ValueAnimator valueAnimator;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i2) {
                this.state = i2;
                if (PullLeftRefreshLayout.this.fUw && this.state == 0 && !this.fUx) {
                    if (this.valueAnimator != null) {
                        this.valueAnimator.cancel();
                    }
                    int i22 = (int) (PullLeftRefreshLayout.this.fUp - 1.0f);
                    if (this.fUy > i22) {
                        this.fUy = i22;
                    }
                    this.valueAnimator = ValueAnimator.ofInt(this.fUy, 0);
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
                            PullLeftRefreshLayout.this.bGW();
                        }
                    });
                    this.valueAnimator.start();
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NonNull RecyclerView recyclerView, int i2, int i22) {
                this.fUy = i2;
                if (!recyclerView.canScrollHorizontally(1) && i2 > 0) {
                    this.fUx = false;
                } else {
                    this.fUx = true;
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
    }

    public void setCallback(a aVar) {
        this.fUv = aVar;
    }

    public void setRefreshViewAndListener(com.baidu.tbadk.widget.horizontalpullview.a aVar) {
        this.fUj = aVar;
        this.fUk = aVar.getView();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = GravityCompat.END;
        this.fUk.setLayoutParams(layoutParams);
        addView(this.fUk, 0);
    }

    public void setEnablePull(boolean z) {
        this.fUw = z;
    }

    public boolean bGU() {
        return this.fUw;
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
        if (this.fUk != null) {
            this.fUm = this.fUk.getMeasuredWidth();
            this.fUo = this.fUm * 2;
            this.fUn = this.fUm + this.fUo;
            this.fUp = this.fUm;
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.fUl == 0) {
            this.fUk.setTranslationX(this.fUm);
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                this.fUs = x;
                this.mLastX = x;
                this.fUt = y;
                this.mLastY = y;
                break;
            case 1:
            case 3:
                this.fUs = 0;
                this.fUt = 0;
                break;
            case 2:
                int i = x - this.fUs;
                this.fUs = x;
                this.mLastX = x;
                this.fUt = y;
                this.mLastY = y;
                if (Math.abs(i) > Math.abs(y - this.fUt) && this.fUw && i < 0 && !bGY() && this.fUl == 0) {
                    if (getParent() != null) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    this.fUl = 2;
                    if (this.fUj != null) {
                        this.fUj.bX(this.fUk);
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
        if (!this.fUw) {
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
                this.fUs = 0;
                this.mLastX = 0;
                this.fUt = 0;
                this.mLastY = 0;
                if (Math.abs(this.fUu) < this.fUp) {
                    bGV();
                    return true;
                }
                bGX();
                return true;
            case 2:
                int i = x - this.mLastX;
                this.mLastX = x;
                this.mLastY = y;
                this.fUu = ((1.0f - Math.abs(this.fUu / this.fUn)) * i) + this.fUu;
                if (this.fUu >= 0.0f) {
                    this.fUu = 0.0f;
                    this.mRecyclerView.setTranslationX(this.fUu);
                    if (this.fUj != null) {
                        this.fUj.bX(this.fUk);
                    }
                } else if (this.fUu <= (-this.fUn)) {
                    this.fUu = -this.fUn;
                    this.mRecyclerView.setTranslationX(this.fUu);
                    if (this.fUj != null) {
                        this.fUj.bY(this.fUk);
                    }
                } else {
                    this.mRecyclerView.setTranslationX(this.fUu);
                    if (Math.abs(this.fUu) > this.fUp) {
                        if (this.fUj != null) {
                            this.fUj.bY(this.fUk);
                        }
                    } else if (this.fUj != null) {
                        this.fUj.bX(this.fUk);
                    }
                }
                if (this.fUk != null) {
                    this.fUk.setTranslationX(this.fUm + this.fUu);
                    return true;
                }
                return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void bGV() {
        if (this.fUq != null) {
            this.fUq.cancel();
        }
        this.fUq = ValueAnimator.ofFloat(Math.abs(this.fUu), 0.0f);
        this.fUq.setDuration(150L);
        this.fUq.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null) {
                    PullLeftRefreshLayout.this.setTranslationStatus(-((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.fUq.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PullLeftRefreshLayout.this.bGW();
            }
        });
        this.fUq.start();
        if (this.fUk != null) {
            this.fUj.bX(this.fUk);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTranslationStatus(float f) {
        if (this.mRecyclerView != null) {
            this.mRecyclerView.setTranslationX(f);
        }
        if (this.fUk != null) {
            this.fUk.setTranslationX(this.fUm + f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGW() {
        this.fUl = 0;
        this.fUu = 0.0f;
        setTranslationStatus(0.0f);
    }

    private void bGX() {
        if (this.fUr != null) {
            this.fUr.cancel();
        }
        this.fUr = ValueAnimator.ofFloat(Math.abs(this.fUu), 0.0f);
        this.fUr.setDuration(150L);
        this.fUr.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null) {
                    PullLeftRefreshLayout.this.setTranslationStatus(-((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.fUr.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PullLeftRefreshLayout.this.bGW();
                PullLeftRefreshLayout.this.postDelayed(new Runnable() { // from class: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PullLeftRefreshLayout.this.bGZ();
                    }
                }, 50L);
            }
        });
        this.fUr.start();
        if (this.fUk != null) {
            this.fUj.bX(this.fUk);
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

    public boolean bGY() {
        return ViewCompat.canScrollHorizontally(this.mRecyclerView, 1);
    }

    public void bGZ() {
        if (this.fUv != null) {
            this.fUv.bHa();
        }
    }
}
