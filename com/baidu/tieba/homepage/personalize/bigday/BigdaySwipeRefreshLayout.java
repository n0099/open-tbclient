package com.baidu.tieba.homepage.personalize.bigday;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.NestedScrollingChild;
import android.support.v4.view.NestedScrollingChildHelper;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.NestedScrollingParentHelper;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.tbadk.core.view.f;
/* loaded from: classes9.dex */
public class BigdaySwipeRefreshLayout extends ViewGroup implements NestedScrollingChild, NestedScrollingParent {
    private static final int[] LAYOUT_ATTRS = {16842766};
    private int dUs;
    a ieL;
    private boolean ieM;
    private int ieN;
    private final Animation ieO;
    Runnable ieP;
    private int mActivePointerId;
    private final Animation mAnimateToCorrectPosition;
    private final Animation mAnimateToStartPosition;
    private int mCircleDiameter;
    private int mCircleViewIndex;
    int mCurrentTargetOffsetTop;
    private final DecelerateInterpolator mDecelerateInterpolator;
    protected int mFrom;
    private float mInitialDownY;
    private float mInitialMotionY;
    private boolean mIsBeingDragged;
    private boolean mNestedScrollInProgress;
    private final NestedScrollingChildHelper mNestedScrollingChildHelper;
    private final NestedScrollingParentHelper mNestedScrollingParentHelper;
    boolean mNotify;
    protected int mOriginalOffsetTop;
    private final int[] mParentOffsetInWindow;
    private final int[] mParentScrollConsumed;
    private Animation.AnimationListener mRefreshListener;
    boolean mRefreshing;
    private boolean mReturningToStart;
    private Animation mScaleDownAnimation;
    int mSpinnerOffsetEnd;
    private int mState;
    private View mTarget;
    private float mTotalDragDistance;
    private float mTotalUnconsumed;
    private int mTouchSlop;
    boolean mUsingCustomStart;

    /* loaded from: classes9.dex */
    public interface a extends BdSwipeRefreshLayout.b {
        int cgk();

        void cgl();

        void cgm();

        void cgn();
    }

    void reset() {
        finish();
        if (getLayoutParams() instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) getLayoutParams()).topMargin = this.dUs;
        }
        if (this.ieL != null) {
            this.ieL.getView().setVisibility(8);
            if (this.ieL instanceof f) {
                ((f) this.ieL).aWx();
            }
            setColorViewAlpha(255);
            P(this.mOriginalOffsetTop - this.mCurrentTargetOffsetTop, true);
            this.mCurrentTargetOffsetTop = -this.mCircleDiameter;
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (!z) {
            reset();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        reset();
    }

    @SuppressLint({"NewApi"})
    private void setColorViewAlpha(int i) {
        if (this.ieL != null && this.ieL.getView() != null && this.ieL.getView().getBackground() != null) {
            this.ieL.getView().getBackground().setAlpha(i);
        }
    }

    public BigdaySwipeRefreshLayout(Context context) {
        this(context, null);
    }

    public BigdaySwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = 4;
        this.mRefreshing = false;
        this.mTotalDragDistance = -1.0f;
        this.mParentScrollConsumed = new int[2];
        this.mParentOffsetInWindow = new int[2];
        this.mActivePointerId = -1;
        this.mCircleViewIndex = -1;
        this.ieM = false;
        this.mRefreshListener = new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            @SuppressLint({"NewApi"})
            public void onAnimationEnd(Animation animation) {
                if (BigdaySwipeRefreshLayout.this.mRefreshing) {
                    BigdaySwipeRefreshLayout.this.refreshing();
                    BigdaySwipeRefreshLayout.this.mCurrentTargetOffsetTop = BigdaySwipeRefreshLayout.this.ieL.getView().getTop();
                    return;
                }
                BigdaySwipeRefreshLayout.this.reset();
            }
        };
        this.mAnimateToCorrectPosition = new Animation() { // from class: com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.7
            @Override // android.view.animation.Animation
            public void applyTransformation(float f, Transformation transformation) {
                int i;
                if (BigdaySwipeRefreshLayout.this.ieL != null) {
                    if (!BigdaySwipeRefreshLayout.this.mUsingCustomStart) {
                        i = BigdaySwipeRefreshLayout.this.mSpinnerOffsetEnd - Math.abs(BigdaySwipeRefreshLayout.this.mOriginalOffsetTop);
                    } else {
                        i = BigdaySwipeRefreshLayout.this.mSpinnerOffsetEnd;
                    }
                    BigdaySwipeRefreshLayout.this.P((((int) ((i - BigdaySwipeRefreshLayout.this.mFrom) * f)) + BigdaySwipeRefreshLayout.this.mFrom) - BigdaySwipeRefreshLayout.this.ieL.getView().getTop(), false);
                }
            }
        };
        this.ieO = new Animation() { // from class: com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.8
            @Override // android.view.animation.Animation
            public void applyTransformation(float f, Transformation transformation) {
                if (BigdaySwipeRefreshLayout.this.ieL != null) {
                    BigdaySwipeRefreshLayout.this.P((BigdaySwipeRefreshLayout.this.mFrom + ((int) ((-BigdaySwipeRefreshLayout.this.mFrom) * f))) - BigdaySwipeRefreshLayout.this.ieL.getView().getTop(), false);
                }
            }
        };
        this.mAnimateToStartPosition = new Animation() { // from class: com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.9
            @Override // android.view.animation.Animation
            public void applyTransformation(float f, Transformation transformation) {
                BigdaySwipeRefreshLayout.this.moveToStart(f);
            }
        };
        this.ieP = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.10
            @Override // java.lang.Runnable
            public void run() {
                if (BigdaySwipeRefreshLayout.this.ieM) {
                    BigdaySwipeRefreshLayout.this.ieM = false;
                    BigdaySwipeRefreshLayout.this.mOriginalOffsetTop = -BigdaySwipeRefreshLayout.this.mCircleDiameter;
                    BigdaySwipeRefreshLayout.this.requestLayout();
                    BigdaySwipeRefreshLayout.this.a(BigdaySwipeRefreshLayout.this.mCurrentTargetOffsetTop, BigdaySwipeRefreshLayout.this.mRefreshListener, 200);
                }
            }
        };
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.mDecelerateInterpolator = new DecelerateInterpolator(2.0f);
        ViewCompat.setChildrenDrawingOrderEnabled(this, true);
        this.mNestedScrollingParentHelper = new NestedScrollingParentHelper(this);
        this.mNestedScrollingChildHelper = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, LAYOUT_ATTRS);
        setEnabled(obtainStyledAttributes.getBoolean(0, true));
        obtainStyledAttributes.recycle();
        this.dUs = 0;
    }

    public void setCustomDistances(int i, int i2, int i3) {
        this.mTotalDragDistance = i2;
        this.mSpinnerOffsetEnd = i;
        this.mCircleDiameter = i3;
        int i4 = -i3;
        this.mCurrentTargetOffsetTop = i4;
        this.mOriginalOffsetTop = i4;
        moveToStart(1.0f);
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i, int i2) {
        if (this.mCircleViewIndex >= 0) {
            if (i2 == i - 1) {
                return this.mCircleViewIndex;
            }
            if (i2 >= this.mCircleViewIndex) {
                return i2 + 1;
            }
            return i2;
        }
        return i2;
    }

    public void setProgressView(a aVar) {
        if (aVar != null && aVar.getView() != null && aVar != this.ieL) {
            if (this.mState == 4 || this.mState == 6) {
                if (this.ieL != null) {
                    removeView(this.ieL.getView());
                }
                this.ieL = aVar;
                this.ieL.getView().setVisibility(8);
                addView(this.ieL.getView(), 0);
                if (aVar instanceof com.baidu.tieba.homepage.personalize.bigday.a) {
                    ((com.baidu.tieba.homepage.personalize.bigday.a) aVar).a(new f.InterfaceC0479f() { // from class: com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.3
                        @Override // com.baidu.tbadk.core.view.f.InterfaceC0479f
                        public void ma(int i) {
                            BigdaySwipeRefreshLayout.this.ieN = i;
                            BigdaySwipeRefreshLayout.this.ieM = true;
                            BigdaySwipeRefreshLayout.this.mCurrentTargetOffsetTop = (BigdaySwipeRefreshLayout.this.mCurrentTargetOffsetTop - BigdaySwipeRefreshLayout.this.mOriginalOffsetTop) - BigdaySwipeRefreshLayout.this.ieN;
                            BigdaySwipeRefreshLayout.this.mOriginalOffsetTop = -BigdaySwipeRefreshLayout.this.ieN;
                            BigdaySwipeRefreshLayout.this.P(BigdaySwipeRefreshLayout.this.mOriginalOffsetTop - BigdaySwipeRefreshLayout.this.mCurrentTargetOffsetTop, false);
                        }

                        @Override // com.baidu.tbadk.core.view.f.InterfaceC0479f
                        public void onAnimationEnd() {
                            BigdaySwipeRefreshLayout.this.setRefreshing(false);
                        }
                    });
                }
            }
        }
    }

    private boolean isAlphaUsedForScale() {
        return Build.VERSION.SDK_INT < 11;
    }

    public void setRefreshing(boolean z) {
        setRefreshing(z, false);
    }

    public void c(f.e eVar) {
        if (eVar == null) {
            setRefreshing(false);
        } else if (!aWv()) {
            setRefreshing(false);
        } else {
            a(false, false, eVar);
        }
    }

    public boolean aWv() {
        if (this.ieL != null && (this.ieL instanceof f)) {
            return ((f) this.ieL).aWv();
        }
        return false;
    }

    public void setExecuteMsgAnimation(boolean z) {
        if (this.ieL != null && (this.ieL instanceof f)) {
            ((f) this.ieL).setExecuteMsgAnimation(z);
        }
    }

    void setAnimationProgress(float f) {
        if (isAlphaUsedForScale()) {
            setColorViewAlpha((int) (255.0f * f));
        } else if (this.ieL != null) {
            ViewCompat.setScaleX(this.ieL.getView(), f);
            ViewCompat.setScaleY(this.ieL.getView(), f);
        }
    }

    private void setRefreshing(boolean z, boolean z2) {
        a(z, z2, (f.e) null);
    }

    private void a(boolean z, boolean z2, f.e eVar) {
        if (this.mRefreshing != z) {
            this.mNotify = z2;
            oq(z);
            ensureTarget();
            this.mRefreshing = z;
            if (this.mRefreshing) {
                animateOffsetToCorrectPosition(this.mCurrentTargetOffsetTop, this.mRefreshListener);
            } else {
                d(eVar);
            }
        }
    }

    void startScaleDownAnimation(Animation.AnimationListener animationListener) {
        this.mScaleDownAnimation = new Animation() { // from class: com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.4
            @Override // android.view.animation.Animation
            public void applyTransformation(float f, Transformation transformation) {
                BigdaySwipeRefreshLayout.this.setAnimationProgress(1.0f - f);
            }
        };
        this.mScaleDownAnimation.setDuration(150L);
        this.mScaleDownAnimation.setAnimationListener(animationListener);
        if (this.ieL != null) {
            this.ieL.getView().clearAnimation();
            this.ieL.getView().startAnimation(this.mScaleDownAnimation);
        }
    }

    public boolean isRefreshing() {
        return this.mRefreshing;
    }

    private void ensureTarget() {
        if (this.mTarget == null) {
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (this.ieL == null || !childAt.equals(this.ieL.getView())) {
                    this.mTarget = childAt;
                    return;
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingTop;
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() != 0) {
            if (this.mTarget == null) {
                ensureTarget();
            }
            if (this.mTarget != null) {
                View view = this.mTarget;
                int paddingLeft = getPaddingLeft();
                if (this.ieM) {
                    paddingTop = getPaddingTop() + this.ieN;
                } else {
                    paddingTop = (getPaddingTop() + this.mCurrentTargetOffsetTop) - this.mOriginalOffsetTop;
                }
                view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
                if (this.ieL != null) {
                    int measuredWidth2 = this.ieL.getView().getMeasuredWidth();
                    int measuredHeight2 = this.ieL.getView().getMeasuredHeight();
                    if (this.ieL != null) {
                        if (this.ieM) {
                            this.ieL.getView().layout(paddingLeft, 0, measuredWidth2 + paddingLeft, measuredHeight2);
                        } else {
                            this.ieL.getView().layout(paddingLeft, this.mCurrentTargetOffsetTop, measuredWidth2 + paddingLeft, measuredHeight2 + this.mCurrentTargetOffsetTop);
                        }
                    }
                }
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.mTarget == null) {
            ensureTarget();
        }
        if (this.mTarget != null) {
            this.mTarget.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
            if (this.ieL != null) {
                if (this.ieM) {
                    this.ieL.getView().measure(View.MeasureSpec.makeMeasureSpec(l.getEquipmentWidth(getContext()), 1073741824), View.MeasureSpec.makeMeasureSpec(this.ieN, 1073741824));
                    this.mOriginalOffsetTop = -this.ieN;
                } else {
                    this.ieL.getView().measure(View.MeasureSpec.makeMeasureSpec(l.getEquipmentWidth(getContext()), 1073741824), View.MeasureSpec.makeMeasureSpec(this.mCircleDiameter, 1073741824));
                    this.mOriginalOffsetTop = -this.mCircleDiameter;
                }
                this.mCircleViewIndex = -1;
                for (int i3 = 0; i3 < getChildCount(); i3++) {
                    if (getChildAt(i3) == this.ieL.getView()) {
                        this.mCircleViewIndex = i3;
                        return;
                    }
                }
            }
        }
    }

    public boolean canChildScrollUp() {
        return ViewCompat.canScrollVertically(this.mTarget, -1);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int findPointerIndex;
        ensureTarget();
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (this.mReturningToStart && actionMasked == 0) {
            this.mReturningToStart = false;
        }
        if (!isEnabled() || this.mReturningToStart || canChildScrollUp() || this.mNestedScrollInProgress) {
            return false;
        }
        switch (actionMasked) {
            case 0:
                this.mActivePointerId = motionEvent.getPointerId(0);
                this.mIsBeingDragged = false;
                int findPointerIndex2 = motionEvent.findPointerIndex(this.mActivePointerId);
                if (findPointerIndex2 >= 0) {
                    this.mInitialDownY = motionEvent.getY(findPointerIndex2);
                    break;
                } else {
                    return false;
                }
            case 1:
            case 3:
                this.mIsBeingDragged = false;
                this.mActivePointerId = -1;
                break;
            case 2:
                if (this.mActivePointerId != -1 && (findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId)) >= 0) {
                    startDragging(motionEvent.getY(findPointerIndex));
                    break;
                } else {
                    return false;
                }
                break;
            case 6:
                onSecondaryPointerUp(motionEvent);
                break;
        }
        return this.mIsBeingDragged;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (Build.VERSION.SDK_INT >= 21 || !(this.mTarget instanceof AbsListView)) {
            if (this.mTarget == null || ViewCompat.isNestedScrollingEnabled(this.mTarget)) {
                super.requestDisallowInterceptTouchEvent(z);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public boolean onStartNestedScroll(View view, View view2, int i) {
        return (!isEnabled() || this.mReturningToStart || (i & 2) == 0) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.mNestedScrollingParentHelper.onNestedScrollAccepted(view, view2, i);
        startNestedScroll(i & 2);
        this.mTotalUnconsumed = 0.0f;
        this.mNestedScrollInProgress = true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        if (i2 > 0 && this.mTotalUnconsumed > 0.0f) {
            if (i2 > this.mTotalUnconsumed) {
                iArr[1] = i2 - ((int) this.mTotalUnconsumed);
                this.mTotalUnconsumed = 0.0f;
            } else {
                this.mTotalUnconsumed -= i2;
                iArr[1] = i2;
            }
            moveSpinner(this.mTotalUnconsumed);
        }
        if (this.ieL != null && this.mUsingCustomStart && i2 > 0 && this.mTotalUnconsumed == 0.0f && Math.abs(i2 - iArr[1]) > 0) {
            this.ieL.getView().setVisibility(8);
        }
        int[] iArr2 = this.mParentScrollConsumed;
        if (dispatchNestedPreScroll(i - iArr[0], i2 - iArr[1], iArr2, null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr2[1] + iArr[1];
        }
        int i3 = i2 - iArr[1];
        if ((isRefreshing() || this.mState == 3) && Math.abs(i3) > 0) {
            if ((i3 > 0 && this.mCurrentTargetOffsetTop > this.mOriginalOffsetTop) || (i3 < 0 && this.mCurrentTargetOffsetTop < this.mOriginalOffsetTop + this.mSpinnerOffsetEnd && !canChildScrollUp())) {
                moveSpinner(Math.max(Math.min(this.mSpinnerOffsetEnd, (this.mCurrentTargetOffsetTop - this.mOriginalOffsetTop) - i3), 0.0f));
                iArr[1] = i3 + iArr[1];
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        dispatchNestedScroll(i, i2, i3, i4, this.mParentOffsetInWindow);
        int i5 = this.mParentOffsetInWindow[1] + i4;
        if (i5 < 0 && !canChildScrollUp() && !this.mRefreshing) {
            this.mTotalUnconsumed = Math.abs(i5) + this.mTotalUnconsumed;
            moveSpinner(this.mTotalUnconsumed);
        }
    }

    @Override // android.view.ViewGroup, android.support.v4.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.mNestedScrollingParentHelper.getNestedScrollAxes();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public void onStopNestedScroll(View view) {
        this.mNestedScrollingParentHelper.onStopNestedScroll(view);
        this.mNestedScrollInProgress = false;
        if (this.mTotalUnconsumed > 0.0f) {
            finishSpinner(this.mTotalUnconsumed);
            this.mTotalUnconsumed = 0.0f;
        }
        stopNestedScroll();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public boolean onNestedPreFling(View view, float f, float f2) {
        if (this.mState == 3 || this.mState == 2 || this.ieL == null || this.ieL.getView() == null || this.ieL.getView().getBottom() <= 0) {
            return dispatchNestedPreFling(f, f2);
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if ((this.mState == 3 || this.mState == 2) && f2 > 0.0f && this.mCurrentTargetOffsetTop > this.mOriginalOffsetTop) {
            a(this.mCurrentTargetOffsetTop, (Animation.AnimationListener) null, 200);
        }
        return dispatchNestedFling(f, f2, z);
    }

    @Override // android.view.View, android.support.v4.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z) {
        this.mNestedScrollingChildHelper.setNestedScrollingEnabled(z);
    }

    @Override // android.view.View, android.support.v4.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.mNestedScrollingChildHelper.isNestedScrollingEnabled();
    }

    @Override // android.view.View, android.support.v4.view.NestedScrollingChild
    public boolean startNestedScroll(int i) {
        return this.mNestedScrollingChildHelper.startNestedScroll(i);
    }

    @Override // android.view.View, android.support.v4.view.NestedScrollingChild
    public void stopNestedScroll() {
        this.mNestedScrollingChildHelper.stopNestedScroll();
    }

    @Override // android.view.View, android.support.v4.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return this.mNestedScrollingChildHelper.hasNestedScrollingParent();
    }

    @Override // android.view.View, android.support.v4.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.mNestedScrollingChildHelper.dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    @Override // android.view.View, android.support.v4.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.mNestedScrollingChildHelper.dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    @Override // android.view.View, android.support.v4.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.mNestedScrollingChildHelper.dispatchNestedFling(f, f2, z);
    }

    @Override // android.view.View, android.support.v4.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.mNestedScrollingChildHelper.dispatchNestedPreFling(f, f2);
    }

    @SuppressLint({"NewApi"})
    private void moveSpinner(float f) {
        if (this.ieL != null) {
            float min = Math.min(1.0f, Math.abs(f / this.mTotalDragDistance));
            float max = (((float) Math.max(min - 0.4d, 0.0d)) * 5.0f) / 3.0f;
            float abs = Math.abs(f) - this.mTotalDragDistance;
            int i = this.mSpinnerOffsetEnd;
            if (this.ieL.cgk() > 0) {
                i = this.ieL.cgk();
            }
            float f2 = this.mUsingCustomStart ? i - this.mOriginalOffsetTop : i;
            float max2 = Math.max(0.0f, Math.min(abs, f2 * 2.0f) / f2);
            float pow = ((float) ((max2 / 4.0f) - Math.pow(max2 / 4.0f, 2.0d))) * 2.0f;
            int i2 = ((int) ((f2 * min) + (f2 * pow * 2.0f))) + this.mOriginalOffsetTop;
            if (this.ieL.getView().getVisibility() != 0) {
                this.ieL.getView().setVisibility(0);
            }
            ViewCompat.setScaleX(this.ieL.getView(), 1.0f);
            ViewCompat.setScaleY(this.ieL.getView(), 1.0f);
            if (!this.mRefreshing && this.mState != 3 && this.mState != 6) {
                if (this.mOriginalOffsetTop < this.mCurrentTargetOffsetTop) {
                    if (this.mCurrentTargetOffsetTop - this.mOriginalOffsetTop < this.mSpinnerOffsetEnd) {
                        if (this.mState != 0) {
                            pullToRefresh();
                        }
                    } else if (this.ieL.cgk() > 0 && this.mCurrentTargetOffsetTop - this.mOriginalOffsetTop > this.ieL.cgk()) {
                        this.mState = 5;
                        this.ieL.cgl();
                    } else if (this.mState != 1) {
                        releaseToRefresh();
                    }
                }
                this.ieL.onPullPercentChange((this.mCurrentTargetOffsetTop - this.mOriginalOffsetTop) / this.mSpinnerOffsetEnd, pow);
            }
            P(i2 - this.mCurrentTargetOffsetTop, true);
        }
    }

    private void finishSpinner(float f) {
        if (this.ieL != null) {
            if (this.ieL.cgk() > 0 && this.mCurrentTargetOffsetTop - this.mOriginalOffsetTop > this.ieL.cgk()) {
                this.mState = 6;
                this.ieL.cgm();
                ((FrameLayout.LayoutParams) getLayoutParams()).topMargin = 0;
                this.mRefreshing = false;
                a(this.mCurrentTargetOffsetTop, new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.5
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        BigdaySwipeRefreshLayout.this.ieL.cgn();
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            } else if (this.mCurrentTargetOffsetTop - this.mOriginalOffsetTop > this.mSpinnerOffsetEnd) {
                setRefreshing(true, true);
            } else {
                cancelRefresh();
            }
        }
    }

    private void cancelRefresh() {
        this.mRefreshing = false;
        a(this.mCurrentTargetOffsetTop, new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                BigdaySwipeRefreshLayout.this.startScaleDownAnimation(null);
                BigdaySwipeRefreshLayout.this.finish();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        }, 200);
        if ((getLayoutParams() instanceof FrameLayout.LayoutParams) && ((FrameLayout.LayoutParams) getLayoutParams()).topMargin == 0) {
            ((FrameLayout.LayoutParams) getLayoutParams()).topMargin = this.dUs;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.ieL.getView().getAnimation() != null && !this.ieL.getView().getAnimation().hasEnded()) {
            return super.onTouchEvent(motionEvent);
        }
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (this.mReturningToStart && actionMasked == 0) {
            this.mReturningToStart = false;
        }
        if (!isEnabled() || this.mReturningToStart || canChildScrollUp() || this.mRefreshing || this.mNestedScrollInProgress) {
            return false;
        }
        switch (actionMasked) {
            case 0:
                this.mActivePointerId = motionEvent.getPointerId(0);
                this.mIsBeingDragged = false;
                break;
            case 1:
                int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                if (findPointerIndex >= 0) {
                    if (this.mIsBeingDragged) {
                        this.mIsBeingDragged = false;
                        finishSpinner((motionEvent.getY(findPointerIndex) - this.mInitialMotionY) * 0.5f);
                    }
                    this.mActivePointerId = -1;
                    return false;
                }
                return false;
            case 2:
                int findPointerIndex2 = motionEvent.findPointerIndex(this.mActivePointerId);
                if (findPointerIndex2 < 0) {
                    return false;
                }
                float y = motionEvent.getY(findPointerIndex2);
                startDragging(y);
                if (this.mIsBeingDragged) {
                    float f = (y - this.mInitialMotionY) * 0.5f;
                    if (f > 0.0f) {
                        moveSpinner(f);
                        break;
                    } else {
                        return false;
                    }
                }
                break;
            case 3:
                return false;
            case 5:
                int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                if (actionIndex >= 0) {
                    this.mActivePointerId = motionEvent.getPointerId(actionIndex);
                    break;
                } else {
                    return false;
                }
            case 6:
                onSecondaryPointerUp(motionEvent);
                break;
        }
        return true;
    }

    @SuppressLint({"NewApi"})
    private void startDragging(float f) {
        if (f - this.mInitialDownY > this.mTouchSlop && !this.mIsBeingDragged) {
            this.mInitialMotionY = this.mInitialDownY + this.mTouchSlop;
            this.mIsBeingDragged = true;
        }
    }

    private void animateOffsetToCorrectPosition(int i, Animation.AnimationListener animationListener) {
        if (this.ieL != null) {
            this.mFrom = i;
            this.mAnimateToCorrectPosition.reset();
            this.mAnimateToCorrectPosition.setDuration(200L);
            this.mAnimateToCorrectPosition.setInterpolator(this.mDecelerateInterpolator);
            if (animationListener != null) {
                this.mAnimateToCorrectPosition.setAnimationListener(animationListener);
            }
            if (this.ieL.getView().getVisibility() != 0) {
                this.ieL.getView().setVisibility(0);
            }
            this.ieL.getView().clearAnimation();
            this.ieL.getView().startAnimation(this.mAnimateToCorrectPosition);
        }
    }

    protected void a(int i, Animation.AnimationListener animationListener, int i2) {
        if (this.ieL != null) {
            this.mFrom = i;
            this.mAnimateToStartPosition.reset();
            this.mAnimateToStartPosition.setDuration(i2);
            this.mAnimateToStartPosition.setInterpolator(this.mDecelerateInterpolator);
            if (animationListener != null) {
                this.mAnimateToStartPosition.setAnimationListener(animationListener);
            }
            this.ieL.getView().clearAnimation();
            this.ieL.getView().startAnimation(this.mAnimateToStartPosition);
        }
    }

    private void a(int i, Animation.AnimationListener animationListener) {
        if (this.ieL != null) {
            this.mFrom = i;
            this.ieO.reset();
            this.ieO.setDuration(500L);
            this.ieO.setInterpolator(this.mDecelerateInterpolator);
            if (animationListener != null) {
                this.ieO.setAnimationListener(animationListener);
            }
            this.ieL.getView().clearAnimation();
            this.ieL.getView().startAnimation(this.ieO);
        }
    }

    void moveToStart(float f) {
        if (this.ieL != null) {
            P((this.mFrom + ((int) ((this.mOriginalOffsetTop - this.mFrom) * f))) - this.ieL.getView().getTop(), false);
        }
    }

    void P(int i, boolean z) {
        if (this.ieL != null) {
            this.ieL.getView().bringToFront();
            ViewCompat.offsetTopAndBottom(this.ieL.getView(), i);
            if (this.mTarget != null) {
                ViewCompat.offsetTopAndBottom(this.mTarget, i);
            }
            this.mCurrentTargetOffsetTop = this.ieL.getView().getTop();
            if (z && Build.VERSION.SDK_INT < 11) {
                invalidate();
            }
        }
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (motionEvent.getPointerId(actionIndex) == this.mActivePointerId) {
            this.mActivePointerId = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
        }
    }

    private void pullToRefresh() {
        if (this.ieL != null) {
            this.mState = 0;
            this.ieL.onPullToRefresh();
        }
    }

    private void releaseToRefresh() {
        if (this.ieL != null) {
            this.mState = 1;
            this.ieL.onReleaseToRefresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshing() {
        if (this.ieL != null) {
            this.mState = 2;
            this.ieL.onRefreshing();
        }
    }

    private void oq(boolean z) {
        if (z && this.ieL != null) {
            if (this.ieM) {
                this.mOriginalOffsetTop = -this.mCircleDiameter;
            }
            this.ieM = false;
            if (aWv() && (this.ieL instanceof f)) {
                ((f) this.ieL).aWx();
            }
        }
    }

    private void d(f.e eVar) {
        if (this.ieL != null) {
            this.mState = 3;
            if (eVar != null && aWv() && (this.ieL instanceof f)) {
                ((f) this.ieL).a(eVar);
                setExecuteMsgAnimation(true);
                this.ieL.onCompleteRefresh();
                e.ld().removeCallbacks(this.ieP);
                e.ld().postDelayed(this.ieP, 3000L);
                return;
            }
            setExecuteMsgAnimation(false);
            this.ieL.onCompleteRefresh();
            postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.2
                @Override // java.lang.Runnable
                public void run() {
                    if (BigdaySwipeRefreshLayout.this.ieM) {
                        BigdaySwipeRefreshLayout.this.mOriginalOffsetTop = -BigdaySwipeRefreshLayout.this.mCircleDiameter;
                    }
                    BigdaySwipeRefreshLayout.this.ieM = false;
                    BigdaySwipeRefreshLayout.this.a(BigdaySwipeRefreshLayout.this.mCurrentTargetOffsetTop, BigdaySwipeRefreshLayout.this.mRefreshListener, 200);
                }
            }, this.ieL.getCompleteAnimTime());
        }
    }

    public void interruptRefresh() {
        ensureTarget();
        this.mRefreshing = false;
        moveToStart(1.0f);
        reset();
    }

    protected void finish() {
        if (this.ieL != null) {
            this.mState = 4;
            this.mRefreshing = false;
            this.ieL.getView().clearAnimation();
            this.ieL.onFinish();
            if (this.ieM) {
                this.mOriginalOffsetTop = -this.mCircleDiameter;
                this.mCurrentTargetOffsetTop = (this.mCurrentTargetOffsetTop - this.mCircleDiameter) + this.ieN;
            }
            this.ieM = false;
            requestLayout();
        }
    }

    public void resume() {
        if (this.mState == 6) {
            if (getLayoutParams() instanceof FrameLayout.LayoutParams) {
                ((FrameLayout.LayoutParams) getLayoutParams()).topMargin = this.dUs;
            }
            a(this.mCurrentTargetOffsetTop, (Animation.AnimationListener) null, 400);
            this.mRefreshing = false;
            this.mState = 4;
        }
    }

    public a getProgressView() {
        return this.ieL;
    }
}
