package com.baidu.tbadk.widget.viewpager;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.os.ParcelableCompat;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.VelocityTrackerCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.support.v4.widget.EdgeEffectCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.tbadk.widget.viewpager.a;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/* loaded from: classes.dex */
public class VerticalViewPager extends ViewGroup {
    private final b flP;
    private e flQ;
    private int flR;
    private int flS;
    private EdgeEffectCompat flT;
    private EdgeEffectCompat flU;
    private d flV;
    private Method flW;
    private com.baidu.tbadk.widget.viewpager.a flY;
    private int mActivePointerId;
    private PagerAdapter mAdapter;
    private boolean mCalledSuper;
    private int mChildHeightMeasureSpec;
    private int mChildWidthMeasureSpec;
    private int mCloseEnough;
    private int mCurItem;
    private int mDecorChildCount;
    private int mDefaultGutterSize;
    private int mDrawingOrder;
    private ArrayList<View> mDrawingOrderedChildren;
    private final Runnable mEndScrollRunnable;
    private int mExpectedAdapterCount;
    private boolean mFakeDragging;
    private boolean mFirstLayout;
    private float mFirstOffset;
    private int mFlingDistance;
    private int mGutterSize;
    private boolean mInLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private ViewPager.OnPageChangeListener mInternalPageChangeListener;
    private boolean mIsBeingDragged;
    private boolean mIsUnableToDrag;
    private final ArrayList<b> mItems;
    private float mLastMotionX;
    private float mLastMotionY;
    private float mLastOffset;
    private Drawable mMarginDrawable;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private boolean mNeedCalculatePageOffsets;
    private int mOffscreenPageLimit;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private int mPageMargin;
    private ViewPager.PageTransformer mPageTransformer;
    private boolean mPopulatePending;
    private Parcelable mRestoredAdapterState;
    private ClassLoader mRestoredClassLoader;
    private int mRestoredCurItem;
    private int mScrollState;
    private Scroller mScroller;
    private boolean mScrollingCacheEnabled;
    private final Rect mTempRect;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    private static final int[] LAYOUT_ATTRS = {16842931};
    private static final Comparator<b> COMPARATOR = new Comparator<b>() { // from class: com.baidu.tbadk.widget.viewpager.VerticalViewPager.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(b bVar, b bVar2) {
            return bVar.position - bVar2.position;
        }
    };
    private static final Interpolator sInterpolator = new Interpolator() { // from class: com.baidu.tbadk.widget.viewpager.VerticalViewPager.2
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * f3 * f3 * f3) + 1.0f;
        }
    };
    private static final f flX = new f();

    /* loaded from: classes.dex */
    interface a {
    }

    /* loaded from: classes.dex */
    interface d {
        void a(PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b {
        float fma;
        Object object;
        float offset;
        int position;
        boolean scrolling;

        b() {
        }
    }

    public VerticalViewPager(Context context) {
        super(context);
        this.mItems = new ArrayList<>();
        this.flP = new b();
        this.mTempRect = new Rect();
        this.mRestoredCurItem = -1;
        this.mRestoredAdapterState = null;
        this.mRestoredClassLoader = null;
        this.mFirstOffset = -3.4028235E38f;
        this.mLastOffset = Float.MAX_VALUE;
        this.mOffscreenPageLimit = 1;
        this.mActivePointerId = -1;
        this.mFirstLayout = true;
        this.mNeedCalculatePageOffsets = false;
        this.mEndScrollRunnable = new Runnable() { // from class: com.baidu.tbadk.widget.viewpager.VerticalViewPager.3
            @Override // java.lang.Runnable
            public void run() {
                VerticalViewPager.this.setScrollState(0);
                VerticalViewPager.this.populate();
            }
        };
        this.mScrollState = 0;
        initViewPager();
    }

    public VerticalViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mItems = new ArrayList<>();
        this.flP = new b();
        this.mTempRect = new Rect();
        this.mRestoredCurItem = -1;
        this.mRestoredAdapterState = null;
        this.mRestoredClassLoader = null;
        this.mFirstOffset = -3.4028235E38f;
        this.mLastOffset = Float.MAX_VALUE;
        this.mOffscreenPageLimit = 1;
        this.mActivePointerId = -1;
        this.mFirstLayout = true;
        this.mNeedCalculatePageOffsets = false;
        this.mEndScrollRunnable = new Runnable() { // from class: com.baidu.tbadk.widget.viewpager.VerticalViewPager.3
            @Override // java.lang.Runnable
            public void run() {
                VerticalViewPager.this.setScrollState(0);
                VerticalViewPager.this.populate();
            }
        };
        this.mScrollState = 0;
        initViewPager();
    }

    void initViewPager() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.mScroller = new Scroller(context, sInterpolator);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(viewConfiguration);
        this.mMinimumVelocity = (int) (400.0f * f2);
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.flT = new EdgeEffectCompat(context);
        this.flU = new EdgeEffectCompat(context);
        this.mFlingDistance = (int) (25.0f * f2);
        this.mCloseEnough = (int) (2.0f * f2);
        this.mDefaultGutterSize = (int) (16.0f * f2);
        ViewCompat.setAccessibilityDelegate(this, new c());
        if (ViewCompat.getImportantForAccessibility(this) == 0) {
            ViewCompat.setImportantForAccessibility(this, 1);
        }
        this.flY = new com.baidu.tbadk.widget.viewpager.a(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.mEndScrollRunnable);
        super.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setScrollState(int i) {
        if (this.mScrollState != i) {
            this.mScrollState = i;
            if (this.mPageTransformer != null) {
                enableLayers(i != 0);
            }
            if (this.mOnPageChangeListener != null) {
                this.mOnPageChangeListener.onPageScrollStateChanged(i);
            }
        }
    }

    public void setAdapter(PagerAdapter pagerAdapter) {
        if (this.mAdapter != null) {
            this.mAdapter.unregisterDataSetObserver(this.flQ);
            this.mAdapter.startUpdate((ViewGroup) this);
            for (int i = 0; i < this.mItems.size(); i++) {
                b bVar = this.mItems.get(i);
                this.mAdapter.destroyItem((ViewGroup) this, bVar.position, bVar.object);
            }
            this.mAdapter.finishUpdate((ViewGroup) this);
            this.mItems.clear();
            removeNonDecorViews();
            this.mCurItem = 0;
            scrollTo(0, 0);
        }
        PagerAdapter pagerAdapter2 = this.mAdapter;
        this.mAdapter = pagerAdapter;
        this.mExpectedAdapterCount = 0;
        if (this.mAdapter != null) {
            if (this.flQ == null) {
                this.flQ = new e();
            }
            this.mAdapter.registerDataSetObserver(this.flQ);
            this.mPopulatePending = false;
            boolean z = this.mFirstLayout;
            this.mFirstLayout = true;
            this.mExpectedAdapterCount = this.mAdapter.getCount();
            if (this.mRestoredCurItem >= 0) {
                this.mAdapter.restoreState(this.mRestoredAdapterState, this.mRestoredClassLoader);
                setCurrentItemInternal(this.mRestoredCurItem, false, true);
                this.mRestoredCurItem = -1;
                this.mRestoredAdapterState = null;
                this.mRestoredClassLoader = null;
            } else if (!z) {
                populate();
            } else {
                requestLayout();
            }
        }
        if (this.flV != null && pagerAdapter2 != pagerAdapter) {
            this.flV.a(pagerAdapter2, pagerAdapter);
        }
    }

    private void removeNonDecorViews() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < getChildCount()) {
                if (!((LayoutParams) getChildAt(i2).getLayoutParams()).isDecor) {
                    removeViewAt(i2);
                    i2--;
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public PagerAdapter getAdapter() {
        return this.mAdapter;
    }

    void setOnAdapterChangeListener(d dVar) {
        this.flV = dVar;
    }

    private int getClientHeight() {
        return (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
    }

    public void setCurrentItem(int i) {
        this.mPopulatePending = false;
        setCurrentItemInternal(i, !this.mFirstLayout, false);
    }

    public void setCurrentItem(int i, boolean z) {
        this.mPopulatePending = false;
        setCurrentItemInternal(i, z, false);
    }

    public int getCurrentItem() {
        return this.mCurItem;
    }

    void setCurrentItemInternal(int i, boolean z, boolean z2) {
        setCurrentItemInternal(i, z, z2, 0);
    }

    void setCurrentItemInternal(int i, boolean z, boolean z2, int i2) {
        if (this.mAdapter == null || this.mAdapter.getCount() <= 0) {
            setScrollingCacheEnabled(false);
        } else if (!z2 && this.mCurItem == i && this.mItems.size() != 0) {
            setScrollingCacheEnabled(false);
        } else {
            if (i < 0) {
                i = 0;
            } else if (i >= this.mAdapter.getCount()) {
                i = this.mAdapter.getCount() - 1;
            }
            int i3 = this.mOffscreenPageLimit;
            if (i > this.mCurItem + i3 || i < this.mCurItem - i3) {
                for (int i4 = 0; i4 < this.mItems.size(); i4++) {
                    this.mItems.get(i4).scrolling = true;
                }
            }
            boolean z3 = this.mCurItem != i;
            if (this.mFirstLayout) {
                this.mCurItem = i;
                if (z3 && this.mOnPageChangeListener != null) {
                    this.mOnPageChangeListener.onPageSelected(i);
                }
                if (z3 && this.mInternalPageChangeListener != null) {
                    this.mInternalPageChangeListener.onPageSelected(i);
                }
                requestLayout();
                return;
            }
            populate(i);
            scrollToItem(i, z, i2, z3);
        }
    }

    private void scrollToItem(int i, boolean z, int i2, boolean z2) {
        int i3;
        b sc = sc(i);
        if (sc != null) {
            i3 = (int) (Math.max(this.mFirstOffset, Math.min(sc.offset, this.mLastOffset)) * getClientHeight());
        } else {
            i3 = 0;
        }
        if (z) {
            smoothScrollTo(0, i3, i2);
            if (z2 && this.mOnPageChangeListener != null) {
                this.mOnPageChangeListener.onPageSelected(i);
            }
            if (z2 && this.mInternalPageChangeListener != null) {
                this.mInternalPageChangeListener.onPageSelected(i);
                return;
            }
            return;
        }
        if (z2 && this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageSelected(i);
        }
        if (z2 && this.mInternalPageChangeListener != null) {
            this.mInternalPageChangeListener.onPageSelected(i);
        }
        completeScroll(false);
        scrollTo(0, i3);
        pageScrolled(i3);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.mOnPageChangeListener = onPageChangeListener;
    }

    public void setPageTransformer(boolean z, ViewPager.PageTransformer pageTransformer) {
        if (Build.VERSION.SDK_INT >= 11) {
            boolean z2 = pageTransformer != null;
            boolean z3 = z2 != (this.mPageTransformer != null);
            this.mPageTransformer = pageTransformer;
            setChildrenDrawingOrderEnabledCompat(z2);
            if (z2) {
                this.mDrawingOrder = z ? 2 : 1;
            } else {
                this.mDrawingOrder = 0;
            }
            if (z3) {
                populate();
            }
        }
    }

    void setChildrenDrawingOrderEnabledCompat(boolean z) {
        if (Build.VERSION.SDK_INT >= 7) {
            if (this.flW == null) {
                try {
                    this.flW = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", Boolean.TYPE);
                } catch (NoSuchMethodException e2) {
                    Log.e("ViewPager", "Can't find setChildrenDrawingOrderEnabled", e2);
                }
            }
            try {
                this.flW.invoke(this, Boolean.valueOf(z));
            } catch (Exception e3) {
                Log.e("ViewPager", "Error changing children drawing order", e3);
            }
        }
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i, int i2) {
        if (this.mDrawingOrder == 2) {
            i2 = (i - 1) - i2;
        }
        return ((LayoutParams) this.mDrawingOrderedChildren.get(i2).getLayoutParams()).childIndex;
    }

    public int getOffscreenPageLimit() {
        return this.mOffscreenPageLimit;
    }

    public void setOffscreenPageLimit(int i) {
        if (i < 1) {
            Log.w("ViewPager", "Requested offscreen page limit " + i + " too small; defaulting to 1");
            i = 1;
        }
        if (i != this.mOffscreenPageLimit) {
            this.mOffscreenPageLimit = i;
            populate();
        }
    }

    public void setPageMargin(int i) {
        int i2 = this.mPageMargin;
        this.mPageMargin = i;
        int height = getHeight();
        recomputeScrollPosition(height, height, i, i2);
        requestLayout();
    }

    public int getPageMargin() {
        return this.mPageMargin;
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.mMarginDrawable = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setPageMarginDrawable(int i) {
        setPageMarginDrawable(getContext().getResources().getDrawable(i));
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.mMarginDrawable;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.mMarginDrawable;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    float distanceInfluenceForSnapDuration(float f2) {
        return (float) Math.sin((float) ((f2 - 0.5f) * 0.4712389167638204d));
    }

    void smoothScrollTo(int i, int i2, int i3) {
        int abs;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int i4 = i - scrollX;
        int i5 = i2 - scrollY;
        if (i4 == 0 && i5 == 0) {
            completeScroll(false);
            populate();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientHeight = getClientHeight();
        int i6 = clientHeight / 2;
        float distanceInfluenceForSnapDuration = (i6 * distanceInfluenceForSnapDuration(Math.min(1.0f, (Math.abs(i4) * 1.0f) / clientHeight))) + i6;
        int abs2 = Math.abs(i3);
        if (abs2 > 0) {
            abs = Math.round(1000.0f * Math.abs(distanceInfluenceForSnapDuration / abs2)) * 4;
        } else {
            abs = (int) (((Math.abs(i4) / ((clientHeight * this.mAdapter.getPageWidth(this.mCurItem)) + this.mPageMargin)) + 1.0f) * 100.0f);
        }
        this.mScroller.startScroll(scrollX, scrollY, i4, i5, Math.min(abs, 600));
        ViewCompat.postInvalidateOnAnimation(this);
    }

    b bw(int i, int i2) {
        b bVar = new b();
        bVar.position = i;
        bVar.object = this.mAdapter.instantiateItem((ViewGroup) this, i);
        bVar.fma = this.mAdapter.getPageWidth(i);
        if (i2 < 0 || i2 >= this.mItems.size()) {
            this.mItems.add(bVar);
        } else {
            this.mItems.add(i2, bVar);
        }
        return bVar;
    }

    void dataSetChanged() {
        int i;
        boolean z;
        int i2;
        boolean z2;
        int count = this.mAdapter.getCount();
        this.mExpectedAdapterCount = count;
        boolean z3 = this.mItems.size() < (this.mOffscreenPageLimit * 2) + 1 && this.mItems.size() < count;
        boolean z4 = false;
        int i3 = this.mCurItem;
        boolean z5 = z3;
        int i4 = 0;
        while (i4 < this.mItems.size()) {
            b bVar = this.mItems.get(i4);
            int itemPosition = this.mAdapter.getItemPosition(bVar.object);
            if (itemPosition == -1) {
                i = i4;
                z = z4;
                i2 = i3;
                z2 = z5;
            } else if (itemPosition == -2) {
                this.mItems.remove(i4);
                int i5 = i4 - 1;
                if (!z4) {
                    this.mAdapter.startUpdate((ViewGroup) this);
                    z4 = true;
                }
                this.mAdapter.destroyItem((ViewGroup) this, bVar.position, bVar.object);
                if (this.mCurItem == bVar.position) {
                    i = i5;
                    z = z4;
                    i2 = Math.max(0, Math.min(this.mCurItem, count - 1));
                    z2 = true;
                } else {
                    i = i5;
                    z = z4;
                    i2 = i3;
                    z2 = true;
                }
            } else if (bVar.position != itemPosition) {
                if (bVar.position == this.mCurItem) {
                    i3 = itemPosition;
                }
                bVar.position = itemPosition;
                i = i4;
                z = z4;
                i2 = i3;
                z2 = true;
            } else {
                i = i4;
                z = z4;
                i2 = i3;
                z2 = z5;
            }
            z5 = z2;
            i3 = i2;
            z4 = z;
            i4 = i + 1;
        }
        if (z4) {
            this.mAdapter.finishUpdate((ViewGroup) this);
        }
        Collections.sort(this.mItems, COMPARATOR);
        if (z5) {
            int childCount = getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i6).getLayoutParams();
                if (!layoutParams.isDecor) {
                    layoutParams.fma = 0.0f;
                }
            }
            setCurrentItemInternal(i3, false, true);
            requestLayout();
        }
    }

    void populate() {
        populate(this.mCurItem);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0104, code lost:
        if (r2.position == r18.mCurItem) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void populate(int i) {
        b bVar;
        int i2;
        String hexString;
        int i3;
        b bVar2;
        b bE;
        if (this.mCurItem == i) {
            bVar = null;
            i2 = 2;
        } else {
            int i4 = this.mCurItem < i ? IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER : 33;
            b sc = sc(this.mCurItem);
            this.mCurItem = i;
            bVar = sc;
            i2 = i4;
        }
        if (this.mAdapter == null) {
            sortChildDrawingOrder();
        } else if (this.mPopulatePending) {
            sortChildDrawingOrder();
        } else if (getWindowToken() != null) {
            this.mAdapter.startUpdate((ViewGroup) this);
            int i5 = this.mOffscreenPageLimit;
            int max = Math.max(0, this.mCurItem - i5);
            int count = this.mAdapter.getCount();
            int min = Math.min(count - 1, i5 + this.mCurItem);
            if (count != this.mExpectedAdapterCount) {
                try {
                    hexString = getResources().getResourceName(getId());
                } catch (Resources.NotFoundException e2) {
                    hexString = Integer.toHexString(getId());
                }
                throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.mExpectedAdapterCount + ", found: " + count + " Pager id: " + hexString + " Pager class: " + getClass() + " Problematic adapter: " + this.mAdapter.getClass());
            }
            int i6 = 0;
            while (true) {
                i3 = i6;
                if (i3 >= this.mItems.size()) {
                    break;
                }
                bVar2 = this.mItems.get(i3);
                if (bVar2.position < this.mCurItem) {
                    i6 = i3 + 1;
                }
            }
            bVar2 = null;
            b bw = (bVar2 != null || count <= 0) ? bVar2 : bw(this.mCurItem, i3);
            if (bw != null) {
                int i7 = i3 - 1;
                b bVar3 = i7 >= 0 ? this.mItems.get(i7) : null;
                int clientHeight = getClientHeight();
                float paddingLeft = clientHeight <= 0 ? 0.0f : (2.0f - bw.fma) + (getPaddingLeft() / clientHeight);
                float f2 = 0.0f;
                int i8 = i3;
                int i9 = i7;
                for (int i10 = this.mCurItem - 1; i10 >= 0; i10--) {
                    if (f2 >= paddingLeft && i10 < max) {
                        if (bVar3 == null) {
                            break;
                        } else if (i10 == bVar3.position && !bVar3.scrolling) {
                            this.mItems.remove(i9);
                            this.mAdapter.destroyItem((ViewGroup) this, i10, bVar3.object);
                            i9--;
                            i8--;
                            bVar3 = i9 >= 0 ? this.mItems.get(i9) : null;
                        }
                    } else if (bVar3 != null && i10 == bVar3.position) {
                        f2 += bVar3.fma;
                        i9--;
                        bVar3 = i9 >= 0 ? this.mItems.get(i9) : null;
                    } else {
                        f2 += bw(i10, i9 + 1).fma;
                        i8++;
                        bVar3 = i9 >= 0 ? this.mItems.get(i9) : null;
                    }
                }
                float f3 = bw.fma;
                int i11 = i8 + 1;
                if (f3 < 2.0f) {
                    b bVar4 = i11 < this.mItems.size() ? this.mItems.get(i11) : null;
                    float paddingRight = clientHeight <= 0 ? 0.0f : (getPaddingRight() / clientHeight) + 2.0f;
                    b bVar5 = bVar4;
                    int i12 = i11;
                    int i13 = this.mCurItem + 1;
                    while (i13 < count) {
                        if (f3 >= paddingRight && i13 > min) {
                            if (bVar5 == null) {
                                break;
                            } else if (i13 == bVar5.position && !bVar5.scrolling) {
                                this.mItems.remove(i12);
                                this.mAdapter.destroyItem((ViewGroup) this, i13, bVar5.object);
                                bVar5 = i12 < this.mItems.size() ? this.mItems.get(i12) : null;
                            }
                        } else if (bVar5 != null && i13 == bVar5.position) {
                            f3 += bVar5.fma;
                            i12++;
                            bVar5 = i12 < this.mItems.size() ? this.mItems.get(i12) : null;
                        } else {
                            b bw2 = bw(i13, i12);
                            i12++;
                            f3 += bw2.fma;
                            bVar5 = i12 < this.mItems.size() ? this.mItems.get(i12) : null;
                        }
                        i13++;
                        bVar5 = bVar5;
                        f3 = f3;
                    }
                }
                a(bw, i8, bVar);
            }
            this.mAdapter.setPrimaryItem((ViewGroup) this, this.mCurItem, bw != null ? bw.object : null);
            this.mAdapter.finishUpdate((ViewGroup) this);
            int childCount = getChildCount();
            for (int i14 = 0; i14 < childCount; i14++) {
                View childAt = getChildAt(i14);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                layoutParams.childIndex = i14;
                if (!layoutParams.isDecor && layoutParams.fma == 0.0f && (bE = bE(childAt)) != null) {
                    layoutParams.fma = bE.fma;
                    layoutParams.position = bE.position;
                }
            }
            sortChildDrawingOrder();
            if (hasFocus()) {
                View findFocus = findFocus();
                b bF = findFocus != null ? bF(findFocus) : null;
                if (bF == null || bF.position != this.mCurItem) {
                    for (int i15 = 0; i15 < getChildCount(); i15++) {
                        View childAt2 = getChildAt(i15);
                        b bE2 = bE(childAt2);
                        if (bE2 != null && bE2.position == this.mCurItem && childAt2.requestFocus(i2)) {
                            return;
                        }
                    }
                }
            }
        }
    }

    private void sortChildDrawingOrder() {
        if (this.mDrawingOrder != 0) {
            if (this.mDrawingOrderedChildren == null) {
                this.mDrawingOrderedChildren = new ArrayList<>();
            } else {
                this.mDrawingOrderedChildren.clear();
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                this.mDrawingOrderedChildren.add(getChildAt(i));
            }
            Collections.sort(this.mDrawingOrderedChildren, flX);
        }
    }

    private void a(b bVar, int i, b bVar2) {
        b bVar3;
        b bVar4;
        int count = this.mAdapter.getCount();
        int clientHeight = getClientHeight();
        float f2 = clientHeight > 0 ? this.mPageMargin / clientHeight : 0.0f;
        if (bVar2 != null) {
            int i2 = bVar2.position;
            if (i2 < bVar.position) {
                float f3 = bVar2.offset + bVar2.fma + f2;
                int i3 = i2 + 1;
                int i4 = 0;
                while (i3 <= bVar.position && i4 < this.mItems.size()) {
                    b bVar5 = this.mItems.get(i4);
                    while (true) {
                        bVar4 = bVar5;
                        if (i3 <= bVar4.position || i4 >= this.mItems.size() - 1) {
                            break;
                        }
                        i4++;
                        bVar5 = this.mItems.get(i4);
                    }
                    while (i3 < bVar4.position) {
                        f3 += this.mAdapter.getPageWidth(i3) + f2;
                        i3++;
                    }
                    bVar4.offset = f3;
                    f3 += bVar4.fma + f2;
                    i3++;
                }
            } else if (i2 > bVar.position) {
                int size = this.mItems.size() - 1;
                float f4 = bVar2.offset;
                int i5 = i2 - 1;
                while (i5 >= bVar.position && size >= 0) {
                    b bVar6 = this.mItems.get(size);
                    while (true) {
                        bVar3 = bVar6;
                        if (i5 >= bVar3.position || size <= 0) {
                            break;
                        }
                        size--;
                        bVar6 = this.mItems.get(size);
                    }
                    while (i5 > bVar3.position) {
                        f4 -= this.mAdapter.getPageWidth(i5) + f2;
                        i5--;
                    }
                    f4 -= bVar3.fma + f2;
                    bVar3.offset = f4;
                    i5--;
                }
            }
        }
        int size2 = this.mItems.size();
        float f5 = bVar.offset;
        int i6 = bVar.position - 1;
        this.mFirstOffset = bVar.position == 0 ? bVar.offset : -3.4028235E38f;
        this.mLastOffset = bVar.position == count + (-1) ? (bVar.offset + bVar.fma) - 1.0f : Float.MAX_VALUE;
        for (int i7 = i - 1; i7 >= 0; i7--) {
            b bVar7 = this.mItems.get(i7);
            float f6 = f5;
            while (i6 > bVar7.position) {
                f6 -= this.mAdapter.getPageWidth(i6) + f2;
                i6--;
            }
            f5 = f6 - (bVar7.fma + f2);
            bVar7.offset = f5;
            if (bVar7.position == 0) {
                this.mFirstOffset = f5;
            }
            i6--;
        }
        float f7 = bVar.offset + bVar.fma + f2;
        int i8 = bVar.position + 1;
        for (int i9 = i + 1; i9 < size2; i9++) {
            b bVar8 = this.mItems.get(i9);
            float f8 = f7;
            while (i8 < bVar8.position) {
                f8 = this.mAdapter.getPageWidth(i8) + f2 + f8;
                i8++;
            }
            if (bVar8.position == count - 1) {
                this.mLastOffset = (bVar8.fma + f8) - 1.0f;
            }
            bVar8.offset = f8;
            f7 = f8 + bVar8.fma + f2;
            i8++;
        }
        this.mNeedCalculatePageOffsets = false;
    }

    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = ParcelableCompat.newCreator(new ParcelableCompatCreatorCallbacks<SavedState>() { // from class: com.baidu.tbadk.widget.viewpager.VerticalViewPager.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.support.v4.os.ParcelableCompatCreatorCallbacks
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.support.v4.os.ParcelableCompatCreatorCallbacks
            /* renamed from: se */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        });
        Parcelable adapterState;
        ClassLoader loader;
        int position;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.position);
            parcel.writeParcelable(this.adapterState, i);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.position + "}";
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.position = parcel.readInt();
            this.adapterState = parcel.readParcelable(classLoader);
            this.loader = classLoader;
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.position = this.mCurItem;
        if (this.mAdapter != null) {
            savedState.adapterState = this.mAdapter.saveState();
        }
        return savedState;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.mAdapter != null) {
            this.mAdapter.restoreState(savedState.adapterState, savedState.loader);
            setCurrentItemInternal(savedState.position, false, true);
            return;
        }
        this.mRestoredCurItem = savedState.position;
        this.mRestoredAdapterState = savedState.adapterState;
        this.mRestoredClassLoader = savedState.loader;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        ViewGroup.LayoutParams generateLayoutParams = !checkLayoutParams(layoutParams) ? generateLayoutParams(layoutParams) : layoutParams;
        LayoutParams layoutParams2 = (LayoutParams) generateLayoutParams;
        layoutParams2.isDecor |= view instanceof a;
        if (this.mInLayout) {
            if (layoutParams2 != null && layoutParams2.isDecor) {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            }
            layoutParams2.needsMeasure = true;
            addViewInLayout(view, i, generateLayoutParams);
            return;
        }
        super.addView(view, i, generateLayoutParams);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.mInLayout) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    b bE(View view) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mItems.size()) {
                b bVar = this.mItems.get(i2);
                if (!this.mAdapter.isViewFromObject(view, bVar.object)) {
                    i = i2 + 1;
                } else {
                    return bVar;
                }
            } else {
                return null;
            }
        }
    }

    b bF(View view) {
        while (true) {
            ViewParent parent = view.getParent();
            if (parent != this) {
                if (parent == null || !(parent instanceof View)) {
                    break;
                }
                view = (View) parent;
            } else {
                return bE(view);
            }
        }
        return null;
    }

    b sc(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.mItems.size()) {
                b bVar = this.mItems.get(i3);
                if (bVar.position != i) {
                    i2 = i3 + 1;
                } else {
                    return bVar;
                }
            } else {
                return null;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b4  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onMeasure(int i, int i2) {
        LayoutParams layoutParams;
        LayoutParams layoutParams2;
        int i3;
        int i4;
        int i5;
        setMeasuredDimension(getDefaultSize(0, i), getDefaultSize(0, i2));
        int measuredHeight = getMeasuredHeight();
        this.mGutterSize = Math.min(measuredHeight / 10, this.mDefaultGutterSize);
        int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        int paddingTop = (measuredHeight - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8 && (layoutParams2 = (LayoutParams) childAt.getLayoutParams()) != null && layoutParams2.isDecor) {
                int i7 = layoutParams2.gravity & 7;
                int i8 = layoutParams2.gravity & 112;
                int i9 = Integer.MIN_VALUE;
                int i10 = Integer.MIN_VALUE;
                boolean z = i8 == 48 || i8 == 80;
                boolean z2 = i7 == 3 || i7 == 5;
                if (z) {
                    i9 = 1073741824;
                } else if (z2) {
                    i10 = 1073741824;
                }
                if (layoutParams2.width != -2) {
                    i3 = 1073741824;
                    i4 = layoutParams2.width != -1 ? layoutParams2.width : measuredWidth;
                } else {
                    i3 = i9;
                    i4 = measuredWidth;
                }
                if (layoutParams2.height != -2) {
                    i10 = 1073741824;
                    if (layoutParams2.height != -1) {
                        i5 = layoutParams2.height;
                        childAt.measure(View.MeasureSpec.makeMeasureSpec(i4, i3), View.MeasureSpec.makeMeasureSpec(i5, i10));
                        if (!z) {
                            paddingTop -= childAt.getMeasuredHeight();
                        } else if (z2) {
                            measuredWidth -= childAt.getMeasuredWidth();
                        }
                    }
                }
                i5 = paddingTop;
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i4, i3), View.MeasureSpec.makeMeasureSpec(i5, i10));
                if (!z) {
                }
            }
        }
        this.mChildWidthMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
        this.mChildHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec(paddingTop, 1073741824);
        this.mInLayout = true;
        populate();
        this.mInLayout = false;
        int childCount2 = getChildCount();
        for (int i11 = 0; i11 < childCount2; i11++) {
            View childAt2 = getChildAt(i11);
            if (childAt2.getVisibility() != 8 && ((layoutParams = (LayoutParams) childAt2.getLayoutParams()) == null || !layoutParams.isDecor)) {
                childAt2.measure(this.mChildWidthMeasureSpec, View.MeasureSpec.makeMeasureSpec((int) (layoutParams.fma * paddingTop), 1073741824));
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i2 != i4) {
            recomputeScrollPosition(i2, i4, this.mPageMargin, this.mPageMargin);
        }
    }

    private void recomputeScrollPosition(int i, int i2, int i3, int i4) {
        if (i2 > 0 && !this.mItems.isEmpty()) {
            int paddingTop = (int) ((((i - getPaddingTop()) - getPaddingBottom()) + i3) * (getScrollY() / (((i2 - getPaddingTop()) - getPaddingBottom()) + i4)));
            scrollTo(getScrollX(), paddingTop);
            if (!this.mScroller.isFinished()) {
                this.mScroller.startScroll(0, paddingTop, 0, (int) (sc(this.mCurItem).offset * i), this.mScroller.getDuration() - this.mScroller.timePassed());
                return;
            }
            return;
        }
        b sc = sc(this.mCurItem);
        int min = (int) ((sc != null ? Math.min(sc.offset, this.mLastOffset) : 0.0f) * ((i - getPaddingTop()) - getPaddingBottom()));
        if (min != getScrollY()) {
            completeScroll(false);
            scrollTo(getScrollX(), min);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        b bE;
        int i5;
        int i6;
        int i7;
        int measuredHeight;
        int i8;
        int i9;
        int childCount = getChildCount();
        int i10 = i3 - i;
        int i11 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollY = getScrollY();
        int i12 = 0;
        int i13 = 0;
        while (i13 < childCount) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.isDecor) {
                    int i14 = layoutParams.gravity & 7;
                    int i15 = layoutParams.gravity & 112;
                    switch (i14) {
                        case 1:
                            i7 = Math.max((i10 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                            break;
                        case 2:
                        case 4:
                        default:
                            i7 = paddingLeft;
                            break;
                        case 3:
                            i7 = paddingLeft;
                            paddingLeft = childAt.getMeasuredWidth() + paddingLeft;
                            break;
                        case 5:
                            int measuredWidth = (i10 - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                            i7 = measuredWidth;
                            break;
                    }
                    switch (i15) {
                        case 16:
                            measuredHeight = Math.max((i11 - childAt.getMeasuredHeight()) / 2, paddingTop);
                            int i16 = paddingBottom;
                            i8 = paddingTop;
                            i9 = i16;
                            break;
                        case 48:
                            int measuredHeight2 = childAt.getMeasuredHeight() + paddingTop;
                            int i17 = paddingTop;
                            i9 = paddingBottom;
                            i8 = measuredHeight2;
                            measuredHeight = i17;
                            break;
                        case 80:
                            measuredHeight = (i11 - paddingBottom) - childAt.getMeasuredHeight();
                            int measuredHeight3 = paddingBottom + childAt.getMeasuredHeight();
                            i8 = paddingTop;
                            i9 = measuredHeight3;
                            break;
                        default:
                            measuredHeight = paddingTop;
                            int i18 = paddingBottom;
                            i8 = paddingTop;
                            i9 = i18;
                            break;
                    }
                    int i19 = measuredHeight + scrollY;
                    childAt.layout(i7, i19, childAt.getMeasuredWidth() + i7, childAt.getMeasuredHeight() + i19);
                    i5 = i12 + 1;
                    i6 = i8;
                    paddingBottom = i9;
                    i13++;
                    paddingLeft = paddingLeft;
                    paddingRight = paddingRight;
                    paddingTop = i6;
                    i12 = i5;
                }
            }
            i5 = i12;
            i6 = paddingTop;
            i13++;
            paddingLeft = paddingLeft;
            paddingRight = paddingRight;
            paddingTop = i6;
            i12 = i5;
        }
        int i20 = (i11 - paddingTop) - paddingBottom;
        for (int i21 = 0; i21 < childCount; i21++) {
            View childAt2 = getChildAt(i21);
            if (childAt2.getVisibility() != 8) {
                LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                if (!layoutParams2.isDecor && (bE = bE(childAt2)) != null) {
                    int i22 = ((int) (bE.offset * i20)) + paddingTop;
                    if (layoutParams2.needsMeasure) {
                        layoutParams2.needsMeasure = false;
                        childAt2.measure(View.MeasureSpec.makeMeasureSpec((i10 - paddingLeft) - paddingRight, 1073741824), View.MeasureSpec.makeMeasureSpec((int) (layoutParams2.fma * i20), 1073741824));
                    }
                    childAt2.layout(paddingLeft, i22, childAt2.getMeasuredWidth() + paddingLeft, childAt2.getMeasuredHeight() + i22);
                }
            }
        }
        this.flR = paddingLeft;
        this.flS = i10 - paddingRight;
        this.mDecorChildCount = i12;
        if (this.mFirstLayout) {
            scrollToItem(this.mCurItem, false, 0, false);
        }
        this.mFirstLayout = false;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (!this.mScroller.isFinished() && this.mScroller.computeScrollOffset()) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                scrollTo(currX, currY);
                if (!pageScrolled(currY)) {
                    this.mScroller.abortAnimation();
                    scrollTo(currX, 0);
                }
            }
            ViewCompat.postInvalidateOnAnimation(this);
            return;
        }
        completeScroll(true);
    }

    public boolean pageScrolled(int i) {
        if (this.mItems.size() == 0) {
            this.mCalledSuper = false;
            onPageScrolled(0, 0.0f, 0);
            if (this.mCalledSuper) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        b bzZ = bzZ();
        int clientHeight = getClientHeight();
        int i2 = this.mPageMargin + clientHeight;
        float f2 = this.mPageMargin / clientHeight;
        int i3 = bzZ.position;
        float f3 = ((i / clientHeight) - bzZ.offset) / (bzZ.fma + f2);
        this.mCalledSuper = false;
        onPageScrolled(i3, f3, (int) (i2 * f3));
        if (!this.mCalledSuper) {
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        return true;
    }

    protected void onPageScrolled(int i, float f2, int i2) {
        int measuredHeight;
        int i3;
        int i4;
        if (this.mDecorChildCount > 0) {
            int scrollY = getScrollY();
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int height = getHeight();
            int childCount = getChildCount();
            int i5 = 0;
            while (i5 < childCount) {
                View childAt = getChildAt(i5);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.isDecor) {
                    switch (layoutParams.gravity & 112) {
                        case 16:
                            measuredHeight = Math.max((height - childAt.getMeasuredHeight()) / 2, paddingTop);
                            int i6 = paddingBottom;
                            i3 = paddingTop;
                            i4 = i6;
                            break;
                        case 48:
                            int height2 = childAt.getHeight() + paddingTop;
                            int i7 = paddingTop;
                            i4 = paddingBottom;
                            i3 = height2;
                            measuredHeight = i7;
                            break;
                        case 80:
                            measuredHeight = (height - paddingBottom) - childAt.getMeasuredHeight();
                            int measuredHeight2 = paddingBottom + childAt.getMeasuredHeight();
                            i3 = paddingTop;
                            i4 = measuredHeight2;
                            break;
                        default:
                            measuredHeight = paddingTop;
                            int i8 = paddingBottom;
                            i3 = paddingTop;
                            i4 = i8;
                            break;
                    }
                    int top = (measuredHeight + scrollY) - childAt.getTop();
                    if (top != 0) {
                        childAt.offsetTopAndBottom(top);
                    }
                } else {
                    int i9 = paddingBottom;
                    i3 = paddingTop;
                    i4 = i9;
                }
                i5++;
                int i10 = i4;
                paddingTop = i3;
                paddingBottom = i10;
            }
        }
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageScrolled(i, f2, i2);
        }
        if (this.mInternalPageChangeListener != null) {
            this.mInternalPageChangeListener.onPageScrolled(i, f2, i2);
        }
        if (this.mPageTransformer != null) {
            int scrollY2 = getScrollY();
            int childCount2 = getChildCount();
            for (int i11 = 0; i11 < childCount2; i11++) {
                View childAt2 = getChildAt(i11);
                if (!((LayoutParams) childAt2.getLayoutParams()).isDecor) {
                    this.mPageTransformer.transformPage(childAt2, (childAt2.getTop() - scrollY2) / getClientHeight());
                }
            }
        }
        this.mCalledSuper = true;
    }

    private void completeScroll(boolean z) {
        boolean z2 = this.mScrollState == 2;
        if (z2) {
            setScrollingCacheEnabled(false);
            this.mScroller.abortAnimation();
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                scrollTo(currX, currY);
            }
        }
        this.mPopulatePending = false;
        boolean z3 = z2;
        for (int i = 0; i < this.mItems.size(); i++) {
            b bVar = this.mItems.get(i);
            if (bVar.scrolling) {
                bVar.scrolling = false;
                z3 = true;
            }
        }
        if (z3) {
            if (z) {
                ViewCompat.postOnAnimation(this, this.mEndScrollRunnable);
            } else {
                this.mEndScrollRunnable.run();
            }
        }
    }

    private boolean isGutterDrag(float f2, float f3) {
        return (f2 < ((float) this.mGutterSize) && f3 > 0.0f) || (f2 > ((float) (getHeight() - this.mGutterSize)) && f3 < 0.0f);
    }

    private void enableLayers(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            ViewCompat.setLayerType(getChildAt(i), z ? 2 : 0, null);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            this.mIsBeingDragged = false;
            this.mIsUnableToDrag = false;
            this.mActivePointerId = -1;
            if (this.mVelocityTracker != null) {
                this.mVelocityTracker.recycle();
                this.mVelocityTracker = null;
                return false;
            }
            return false;
        }
        if (action != 0) {
            if (this.mIsBeingDragged) {
                return true;
            }
            if (this.mIsUnableToDrag) {
                return false;
            }
        }
        switch (action) {
            case 0:
                float x = motionEvent.getX();
                this.mInitialMotionX = x;
                this.mLastMotionX = x;
                float y = motionEvent.getY();
                this.mInitialMotionY = y;
                this.mLastMotionY = y;
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, 0);
                this.mIsUnableToDrag = false;
                this.mScroller.computeScrollOffset();
                if (this.mScrollState == 2 && Math.abs(this.mScroller.getFinalY() - this.mScroller.getCurrY()) > this.mCloseEnough) {
                    this.mScroller.abortAnimation();
                    this.mPopulatePending = false;
                    populate();
                    this.mIsBeingDragged = true;
                    requestParentDisallowInterceptTouchEvent(true);
                    setScrollState(1);
                    break;
                } else {
                    completeScroll(false);
                    this.mIsBeingDragged = false;
                    break;
                }
                break;
            case 2:
                int i = this.mActivePointerId;
                if (i != -1) {
                    int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i);
                    float y2 = MotionEventCompat.getY(motionEvent, findPointerIndex);
                    float f2 = y2 - this.mLastMotionY;
                    float abs = Math.abs(f2);
                    float x2 = MotionEventCompat.getX(motionEvent, findPointerIndex);
                    float abs2 = Math.abs(x2 - this.mInitialMotionX);
                    if (f2 != 0.0f && !isGutterDrag(this.mLastMotionY, f2) && canScroll(this, false, (int) f2, (int) x2, (int) y2)) {
                        this.mLastMotionX = x2;
                        this.mLastMotionY = y2;
                        this.mIsUnableToDrag = true;
                        return false;
                    }
                    if (abs > this.mTouchSlop && 0.5f * abs > abs2) {
                        this.mIsBeingDragged = true;
                        requestParentDisallowInterceptTouchEvent(true);
                        setScrollState(1);
                        this.mLastMotionY = f2 > 0.0f ? this.mInitialMotionY + this.mTouchSlop : this.mInitialMotionY - this.mTouchSlop;
                        this.mLastMotionX = x2;
                        setScrollingCacheEnabled(true);
                    } else if (abs2 > this.mTouchSlop) {
                        this.mIsUnableToDrag = true;
                    }
                    if (this.mIsBeingDragged && performDrag(y2)) {
                        ViewCompat.postInvalidateOnAnimation(this);
                        break;
                    }
                }
                break;
            case 6:
                onSecondaryPointerUp(motionEvent);
                break;
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        return this.mIsBeingDragged;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.mFakeDragging) {
            return true;
        }
        this.flY.onTouchEvent(motionEvent);
        if (motionEvent.getAction() != 0 || motionEvent.getEdgeFlags() == 0) {
            if (this.mAdapter == null || this.mAdapter.getCount() == 0) {
                return false;
            }
            if (this.mVelocityTracker == null) {
                this.mVelocityTracker = VelocityTracker.obtain();
            }
            this.mVelocityTracker.addMovement(motionEvent);
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.mScroller.abortAnimation();
                    this.mPopulatePending = false;
                    populate();
                    float x = motionEvent.getX();
                    this.mInitialMotionX = x;
                    this.mLastMotionX = x;
                    float y = motionEvent.getY();
                    this.mInitialMotionY = y;
                    this.mLastMotionY = y;
                    this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, 0);
                    break;
                case 1:
                    if (this.mIsBeingDragged) {
                        VelocityTracker velocityTracker = this.mVelocityTracker;
                        velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                        int yVelocity = (int) VelocityTrackerCompat.getYVelocity(velocityTracker, this.mActivePointerId);
                        this.mPopulatePending = true;
                        int clientHeight = getClientHeight();
                        int scrollY = getScrollY();
                        b bzZ = bzZ();
                        setCurrentItemInternal(determineTargetPage(bzZ.position, ((scrollY / clientHeight) - bzZ.offset) / bzZ.fma, yVelocity, (int) (MotionEventCompat.getY(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.mActivePointerId)) - this.mInitialMotionY)), true, true, yVelocity);
                        this.mActivePointerId = -1;
                        endDrag();
                        z = this.flU.onRelease() | this.flT.onRelease();
                        break;
                    }
                    break;
                case 2:
                    if (!this.mIsBeingDragged) {
                        int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, this.mActivePointerId);
                        float y2 = MotionEventCompat.getY(motionEvent, findPointerIndex);
                        float abs = Math.abs(y2 - this.mLastMotionY);
                        float x2 = MotionEventCompat.getX(motionEvent, findPointerIndex);
                        float abs2 = Math.abs(x2 - this.mLastMotionX);
                        if (abs > this.mTouchSlop && abs > abs2) {
                            this.mIsBeingDragged = true;
                            requestParentDisallowInterceptTouchEvent(true);
                            this.mLastMotionY = y2 - this.mInitialMotionY > 0.0f ? this.mInitialMotionY + this.mTouchSlop : this.mInitialMotionY - this.mTouchSlop;
                            this.mLastMotionX = x2;
                            setScrollState(1);
                            setScrollingCacheEnabled(true);
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                            }
                        }
                    }
                    if (this.mIsBeingDragged) {
                        z = false | performDrag(MotionEventCompat.getY(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.mActivePointerId)));
                        break;
                    }
                    break;
                case 3:
                    if (this.mIsBeingDragged) {
                        scrollToItem(this.mCurItem, true, 0, false);
                        this.mActivePointerId = -1;
                        endDrag();
                        z = this.flU.onRelease() | this.flT.onRelease();
                        break;
                    }
                    break;
                case 5:
                    int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                    this.mLastMotionY = MotionEventCompat.getY(motionEvent, actionIndex);
                    this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                    break;
                case 6:
                    onSecondaryPointerUp(motionEvent);
                    this.mLastMotionY = MotionEventCompat.getY(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.mActivePointerId));
                    break;
            }
            if (z) {
                ViewCompat.postInvalidateOnAnimation(this);
            }
            return true;
        }
        return false;
    }

    private void requestParentDisallowInterceptTouchEvent(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    private boolean performDrag(float f2) {
        boolean z;
        float f3;
        boolean z2 = true;
        this.mLastMotionY = f2;
        float scrollY = getScrollY() + (this.mLastMotionY - f2);
        int clientHeight = getClientHeight();
        float f4 = clientHeight * this.mFirstOffset;
        float f5 = clientHeight * this.mLastOffset;
        b bVar = this.mItems.get(0);
        b bVar2 = this.mItems.get(this.mItems.size() - 1);
        if (bVar.position != 0) {
            f4 = bVar.offset * clientHeight;
            z = false;
        } else {
            z = true;
        }
        if (bVar2.position != this.mAdapter.getCount() - 1) {
            f3 = bVar2.offset * clientHeight;
            z2 = false;
        } else {
            f3 = f5;
        }
        if (scrollY < f4) {
            if (z) {
                r2 = this.flT.onPull(Math.abs(f4 - scrollY) / clientHeight);
            }
        } else if (scrollY > f3) {
            r2 = z2 ? this.flU.onPull(Math.abs(scrollY - f3) / clientHeight) : false;
            f4 = f3;
        } else {
            f4 = scrollY;
        }
        this.mLastMotionX += f4 - ((int) f4);
        scrollTo(getScrollX(), (int) f4);
        pageScrolled((int) f4);
        return r2;
    }

    private b bzZ() {
        int i;
        b bVar;
        int clientHeight = getClientHeight();
        float scrollY = clientHeight > 0 ? getScrollY() / clientHeight : 0.0f;
        float f2 = clientHeight > 0 ? this.mPageMargin / clientHeight : 0.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        int i2 = -1;
        int i3 = 0;
        boolean z = true;
        b bVar2 = null;
        while (i3 < this.mItems.size()) {
            b bVar3 = this.mItems.get(i3);
            if (z || bVar3.position == i2 + 1) {
                i = i3;
                bVar = bVar3;
            } else {
                b bVar4 = this.flP;
                bVar4.offset = f3 + f4 + f2;
                bVar4.position = i2 + 1;
                bVar4.fma = this.mAdapter.getPageWidth(bVar4.position);
                i = i3 - 1;
                bVar = bVar4;
            }
            float f5 = bVar.offset;
            float f6 = bVar.fma + f5 + f2;
            if (z || scrollY >= f5) {
                if (scrollY < f6 || i == this.mItems.size() - 1) {
                    return bVar;
                }
                f4 = f5;
                i2 = bVar.position;
                z = false;
                f3 = bVar.fma;
                bVar2 = bVar;
                i3 = i + 1;
            } else {
                return bVar2;
            }
        }
        return bVar2;
    }

    private int determineTargetPage(int i, float f2, int i2, int i3) {
        if (Math.abs(i3) > this.mFlingDistance && Math.abs(i2) > this.mMinimumVelocity) {
            if (i2 <= 0) {
                i++;
            }
        } else {
            i = (int) ((i >= this.mCurItem ? 0.4f : 0.6f) + i + f2);
        }
        if (this.mItems.size() > 0) {
            return Math.max(this.mItems.get(0).position, Math.min(i, this.mItems.get(this.mItems.size() - 1).position));
        }
        return i;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        boolean z = false;
        int overScrollMode = ViewCompat.getOverScrollMode(this);
        if (overScrollMode == 0 || (overScrollMode == 1 && this.mAdapter != null && this.mAdapter.getCount() > 1)) {
            if (!this.flT.isFinished()) {
                int save = canvas.save();
                int height = getHeight();
                int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                canvas.translate(getPaddingLeft(), this.mFirstOffset * height);
                this.flT.setSize(width, height);
                z = false | this.flT.draw(canvas);
                if (save >= 1 && save <= canvas.getSaveCount()) {
                    canvas.restoreToCount(save);
                }
            }
            if (!this.flU.isFinished()) {
                int save2 = canvas.save();
                int height2 = getHeight();
                int width2 = (getWidth() - getPaddingLeft()) - getPaddingRight();
                canvas.rotate(180.0f);
                canvas.translate((-width2) - getPaddingLeft(), (-(this.mLastOffset + 1.0f)) * height2);
                this.flU.setSize(width2, height2);
                z |= this.flU.draw(canvas);
                if (save2 >= 1 && save2 <= canvas.getSaveCount()) {
                    canvas.restoreToCount(save2);
                }
            }
        } else {
            this.flT.finish();
            this.flU.finish();
        }
        if (z) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f2;
        super.onDraw(canvas);
        if (this.mPageMargin > 0 && this.mMarginDrawable != null && this.mItems.size() > 0 && this.mAdapter != null) {
            int scrollY = getScrollY();
            int height = getHeight();
            float f3 = this.mPageMargin / height;
            b bVar = this.mItems.get(0);
            float f4 = bVar.offset;
            int size = this.mItems.size();
            int i = bVar.position;
            int i2 = this.mItems.get(size - 1).position;
            int i3 = 0;
            for (int i4 = i; i4 < i2; i4++) {
                while (i4 > bVar.position && i3 < size) {
                    i3++;
                    bVar = this.mItems.get(i3);
                }
                if (i4 == bVar.position) {
                    f2 = (bVar.offset + bVar.fma) * height;
                    f4 = bVar.offset + bVar.fma + f3;
                } else {
                    float pageWidth = this.mAdapter.getPageWidth(i4);
                    f2 = (f4 + pageWidth) * height;
                    f4 += pageWidth + f3;
                }
                if (this.mPageMargin + f2 > scrollY) {
                    this.mMarginDrawable.setBounds(this.flR, (int) f2, this.flS, (int) (this.mPageMargin + f2 + 0.5f));
                    this.mMarginDrawable.draw(canvas);
                }
                if (f2 > scrollY + height) {
                    return;
                }
            }
        }
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (MotionEventCompat.getPointerId(motionEvent, actionIndex) == this.mActivePointerId) {
            int i = actionIndex == 0 ? 1 : 0;
            this.mLastMotionY = MotionEventCompat.getY(motionEvent, i);
            this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, i);
            if (this.mVelocityTracker != null) {
                this.mVelocityTracker.clear();
            }
        }
    }

    private void endDrag() {
        this.mIsBeingDragged = false;
        this.mIsUnableToDrag = false;
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.mScrollingCacheEnabled != z) {
            this.mScrollingCacheEnabled = z;
        }
    }

    public boolean sd(int i) {
        if (this.mAdapter == null) {
            return false;
        }
        int clientHeight = getClientHeight();
        int scrollY = getScrollY();
        if (i < 0) {
            return scrollY > ((int) (((float) clientHeight) * this.mFirstOffset));
        } else if (i > 0) {
            return scrollY < ((int) (((float) clientHeight) * this.mLastOffset));
        } else {
            return false;
        }
    }

    protected boolean canScroll(View view, boolean z, int i, int i2, int i3) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (i3 + scrollY >= childAt.getTop() && i3 + scrollY < childAt.getBottom() && i2 + scrollX >= childAt.getLeft() && i2 + scrollX < childAt.getRight() && canScroll(childAt, true, i, (i2 + scrollX) - childAt.getLeft(), (i3 + scrollY) - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z && ViewCompat.canScrollVertically(view, -i);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || executeKeyEvent(keyEvent);
    }

    public boolean executeKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0) {
            return false;
        }
        switch (keyEvent.getKeyCode()) {
            case 21:
                return arrowScroll(17);
            case 22:
                return arrowScroll(66);
            case 61:
                if (Build.VERSION.SDK_INT < 11) {
                    return false;
                }
                if (keyEvent.hasNoModifiers()) {
                    return arrowScroll(2);
                }
                if (!keyEvent.hasModifiers(1)) {
                    return false;
                }
                return arrowScroll(1);
            default:
                return false;
        }
    }

    public boolean arrowScroll(int i) {
        View view;
        boolean z;
        boolean bAa;
        View findFocus = findFocus();
        if (findFocus == this) {
            view = null;
        } else {
            if (findFocus != null) {
                ViewParent parent = findFocus.getParent();
                while (true) {
                    if (!(parent instanceof ViewGroup)) {
                        z = false;
                        break;
                    } else if (parent == this) {
                        z = true;
                        break;
                    } else {
                        parent = parent.getParent();
                    }
                }
                if (!z) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(findFocus.getClass().getSimpleName());
                    for (ViewParent parent2 = findFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                        sb.append(" => ").append(parent2.getClass().getSimpleName());
                    }
                    Log.e("ViewPager", "arrowScroll tried to find focus based on non-child current focused view " + sb.toString());
                    view = null;
                }
            }
            view = findFocus;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, view, i);
        if (findNextFocus != null && findNextFocus != view) {
            if (i == 33) {
                int i2 = getChildRectInPagerCoordinates(this.mTempRect, findNextFocus).top;
                int i3 = getChildRectInPagerCoordinates(this.mTempRect, view).top;
                if (view != null && i2 >= i3) {
                    bAa = bAa();
                } else {
                    bAa = findNextFocus.requestFocus();
                }
            } else {
                if (i == 130) {
                    int i4 = getChildRectInPagerCoordinates(this.mTempRect, findNextFocus).bottom;
                    int i5 = getChildRectInPagerCoordinates(this.mTempRect, view).bottom;
                    if (view != null && i4 <= i5) {
                        bAa = bAb();
                    } else {
                        bAa = findNextFocus.requestFocus();
                    }
                }
                bAa = false;
            }
        } else if (i == 33 || i == 1) {
            bAa = bAa();
        } else {
            if (i == 130 || i == 2) {
                bAa = bAb();
            }
            bAa = false;
        }
        if (bAa) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
        }
        return bAa;
    }

    private Rect getChildRectInPagerCoordinates(Rect rect, View view) {
        Rect rect2 = rect == null ? new Rect() : rect;
        if (view == null) {
            rect2.set(0, 0, 0, 0);
            return rect2;
        }
        rect2.left = view.getLeft();
        rect2.right = view.getRight();
        rect2.top = view.getTop();
        rect2.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect2.left += viewGroup.getLeft();
            rect2.right += viewGroup.getRight();
            rect2.top += viewGroup.getTop();
            rect2.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect2;
    }

    boolean bAa() {
        if (this.mCurItem > 0) {
            setCurrentItem(this.mCurItem - 1, true);
            return true;
        }
        return false;
    }

    boolean bAb() {
        if (this.mAdapter == null || this.mCurItem >= this.mAdapter.getCount() - 1) {
            return false;
        }
        setCurrentItem(this.mCurItem + 1, true);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        b bE;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0 && (bE = bE(childAt)) != null && bE.position == this.mCurItem) {
                    childAt.addFocusables(arrayList, i, i2);
                }
            }
        }
        if ((descendantFocusability != 262144 || size == arrayList.size()) && isFocusable()) {
            if (((i2 & 1) != 1 || !isInTouchMode() || isFocusableInTouchMode()) && arrayList != null) {
                arrayList.add(this);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        b bE;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (bE = bE(childAt)) != null && bE.position == this.mCurItem) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        b bE;
        int i3 = -1;
        int childCount = getChildCount();
        if ((i & 2) != 0) {
            i3 = 1;
            i2 = 0;
        } else {
            i2 = childCount - 1;
            childCount = -1;
        }
        while (i2 != childCount) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (bE = bE(childAt)) != null && bE.position == this.mCurItem && childAt.requestFocus(i, rect)) {
                return true;
            }
            i2 += i3;
        }
        return false;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        b bE;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (bE = bE(childAt)) != null && bE.position == this.mCurItem && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public void setEventListener(a.InterfaceC0562a interfaceC0562a) {
        if (this.flY != null) {
            this.flY.setEventListener(interfaceC0562a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends AccessibilityDelegateCompat {
        c() {
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(ViewPager.class.getName());
            AccessibilityRecordCompat obtain = AccessibilityRecordCompat.obtain();
            obtain.setScrollable(canScroll());
            if (accessibilityEvent.getEventType() == 4096 && VerticalViewPager.this.mAdapter != null) {
                obtain.setItemCount(VerticalViewPager.this.mAdapter.getCount());
                obtain.setFromIndex(VerticalViewPager.this.mCurItem);
                obtain.setToIndex(VerticalViewPager.this.mCurItem);
            }
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setClassName(ViewPager.class.getName());
            accessibilityNodeInfoCompat.setScrollable(canScroll());
            if (VerticalViewPager.this.sd(1)) {
                accessibilityNodeInfoCompat.addAction(4096);
            }
            if (VerticalViewPager.this.sd(-1)) {
                accessibilityNodeInfoCompat.addAction(8192);
            }
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (super.performAccessibilityAction(view, i, bundle)) {
                return true;
            }
            switch (i) {
                case 4096:
                    if (VerticalViewPager.this.sd(1)) {
                        VerticalViewPager.this.setCurrentItem(VerticalViewPager.this.mCurItem + 1);
                        return true;
                    }
                    return false;
                case 8192:
                    if (VerticalViewPager.this.sd(-1)) {
                        VerticalViewPager.this.setCurrentItem(VerticalViewPager.this.mCurItem - 1);
                        return true;
                    }
                    return false;
                default:
                    return false;
            }
        }

        private boolean canScroll() {
            return VerticalViewPager.this.mAdapter != null && VerticalViewPager.this.mAdapter.getCount() > 1;
        }
    }

    /* loaded from: classes.dex */
    private class e extends DataSetObserver {
        private e() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            VerticalViewPager.this.dataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            VerticalViewPager.this.dataSetChanged();
        }
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends ViewGroup.LayoutParams {
        int childIndex;
        float fma;
        public int gravity;
        public boolean isDecor;
        boolean needsMeasure;
        int position;

        public LayoutParams() {
            super(-1, -1);
            this.fma = 0.0f;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.fma = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, VerticalViewPager.LAYOUT_ATTRS);
            this.gravity = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class f implements Comparator<View> {
        f() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        public int compare(View view, View view2) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
            if (layoutParams.isDecor != layoutParams2.isDecor) {
                return layoutParams.isDecor ? 1 : -1;
            }
            return layoutParams.position - layoutParams2.position;
        }
    }
}
