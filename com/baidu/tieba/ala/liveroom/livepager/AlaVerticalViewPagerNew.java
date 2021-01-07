package com.baidu.tieba.ala.liveroom.livepager;

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
import androidx.core.os.ParcelableCompat;
import androidx.core.os.ParcelableCompatCreatorCallbacks;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.VelocityTrackerCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityRecordCompat;
import androidx.core.widget.EdgeEffectCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.liveroom.livepager.a;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/* loaded from: classes11.dex */
public class AlaVerticalViewPagerNew extends ViewGroup {
    private boolean bWN;
    private int gdi;
    private int gdj;
    private EdgeEffectCompat gdk;
    private EdgeEffectCompat gdl;
    private Method gdn;
    private boolean hGi;
    private boolean hGj;
    private boolean hGk;
    private float hGl;
    private final c hGm;
    private f hGn;
    private e hGo;
    private com.baidu.tieba.ala.liveroom.livepager.a hGq;
    private a hGr;
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
    private final ArrayList<c> mItems;
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
    private static final Comparator<c> COMPARATOR = new Comparator<c>() { // from class: com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(c cVar, c cVar2) {
            return cVar.position - cVar2.position;
        }
    };
    private static final Interpolator sInterpolator = new Interpolator() { // from class: com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew.2
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * f3 * f3 * f3) + 1.0f;
        }
    };
    private static final g hGp = new g();

    /* loaded from: classes11.dex */
    public interface a {
        void cjE();
    }

    /* loaded from: classes11.dex */
    interface b {
    }

    /* loaded from: classes11.dex */
    interface e {
        void b(PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2);
    }

    public void setIsScrollable(boolean z) {
        if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled()) {
            this.hGi = false;
        } else {
            this.hGi = z;
        }
    }

    public void setTalentShowing(boolean z) {
        this.hGj = z;
    }

    public void setIsMixLive(boolean z) {
        this.hGk = z;
    }

    public void setDetermineYRatio(float f2) {
        this.hGl = f2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public static class c {
        float gdr;
        Object object;
        float offset;
        int position;
        boolean scrolling;

        c() {
        }
    }

    public AlaVerticalViewPagerNew(Context context) {
        super(context);
        this.hGi = true;
        this.hGk = false;
        this.bWN = false;
        this.mItems = new ArrayList<>();
        this.hGm = new c();
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
        this.mEndScrollRunnable = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew.3
            @Override // java.lang.Runnable
            public void run() {
                AlaVerticalViewPagerNew.this.setScrollState(0);
                AlaVerticalViewPagerNew.this.populate();
            }
        };
        this.mScrollState = 0;
        initViewPager();
    }

    public AlaVerticalViewPagerNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hGi = true;
        this.hGk = false;
        this.bWN = false;
        this.mItems = new ArrayList<>();
        this.hGm = new c();
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
        this.mEndScrollRunnable = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew.3
            @Override // java.lang.Runnable
            public void run() {
                AlaVerticalViewPagerNew.this.setScrollState(0);
                AlaVerticalViewPagerNew.this.populate();
            }
        };
        this.mScrollState = 0;
        initViewPager();
    }

    private void initViewPager() {
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
        this.gdk = new EdgeEffectCompat(context);
        this.gdl = new EdgeEffectCompat(context);
        this.mFlingDistance = (int) (25.0f * f2);
        this.mCloseEnough = (int) (2.0f * f2);
        this.mDefaultGutterSize = (int) (16.0f * f2);
        ViewCompat.setAccessibilityDelegate(this, new d());
        if (ViewCompat.getImportantForAccessibility(this) == 0) {
            ViewCompat.setImportantForAccessibility(this, 1);
        }
        this.hGq = new com.baidu.tieba.ala.liveroom.livepager.a(this);
        this.hGl = 0.5f;
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
            this.mAdapter.unregisterDataSetObserver(this.hGn);
            this.mAdapter.startUpdate((ViewGroup) this);
            for (int i = 0; i < this.mItems.size(); i++) {
                c cVar = this.mItems.get(i);
                this.mAdapter.destroyItem((ViewGroup) this, cVar.position, cVar.object);
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
            if (this.hGn == null) {
                this.hGn = new f();
            }
            this.mAdapter.registerDataSetObserver(this.hGn);
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
        if (this.hGo != null && pagerAdapter2 != pagerAdapter) {
            this.hGo.b(pagerAdapter2, pagerAdapter);
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

    void setOnAdapterChangeListener(e eVar) {
        this.hGo = eVar;
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
        c xe = xe(i);
        if (xe != null) {
            i3 = (int) (Math.max(this.mFirstOffset, Math.min(xe.offset, this.mLastOffset)) * getClientHeight());
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
            if (this.gdn == null) {
                try {
                    this.gdn = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", Boolean.TYPE);
                } catch (NoSuchMethodException e2) {
                    Log.e("ViewPager", "Can't find setChildrenDrawingOrderEnabled", e2);
                }
            }
            try {
                if (this.gdn != null) {
                    this.gdn.invoke(this, Boolean.valueOf(z));
                }
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
        this.mScroller.startScroll(scrollX, scrollY, i4, i5, Math.min(abs, 400));
        ViewCompat.postInvalidateOnAnimation(this);
    }

    c bW(int i, int i2) {
        c cVar = new c();
        cVar.position = i;
        cVar.object = this.mAdapter.instantiateItem((ViewGroup) this, i);
        cVar.gdr = this.mAdapter.getPageWidth(i);
        if (i2 < 0 || i2 >= this.mItems.size()) {
            this.mItems.add(cVar);
        } else {
            this.mItems.add(i2, cVar);
        }
        return cVar;
    }

    void dataSetChanged() {
        int count = this.mAdapter.getCount();
        this.mExpectedAdapterCount = count;
        boolean z = this.mItems.size() < (this.mOffscreenPageLimit * 2) + 1 && this.mItems.size() < count;
        int i = this.mCurItem;
        int i2 = 0;
        boolean z2 = false;
        boolean z3 = z;
        while (i2 < this.mItems.size()) {
            c cVar = this.mItems.get(i2);
            int itemPosition = this.mAdapter.getItemPosition(cVar.object);
            if (itemPosition != -1) {
                if (itemPosition == -2) {
                    this.mItems.remove(i2);
                    i2--;
                    if (!z2) {
                        this.mAdapter.startUpdate((ViewGroup) this);
                        z2 = true;
                    }
                    this.mAdapter.destroyItem((ViewGroup) this, cVar.position, cVar.object);
                    if (this.mCurItem == cVar.position) {
                        i = Math.max(0, Math.min(this.mCurItem, count - 1));
                        z3 = true;
                    } else {
                        z3 = true;
                    }
                } else if (cVar.position != itemPosition) {
                    if (cVar.position == this.mCurItem) {
                        i = itemPosition;
                    }
                    cVar.position = itemPosition;
                    z3 = true;
                }
            }
            i2++;
        }
        if (z2) {
            this.mAdapter.finishUpdate((ViewGroup) this);
        }
        Collections.sort(this.mItems, COMPARATOR);
        if (z3) {
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i3).getLayoutParams();
                if (!layoutParams.isDecor) {
                    layoutParams.gdr = 0.0f;
                }
            }
            setCurrentItemInternal(i, false, true);
            requestLayout();
        }
    }

    void populate() {
        populate(this.mCurItem);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00d5, code lost:
        if (r0.position == r14.mCurItem) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void populate(int i) {
        String hexString;
        int i2;
        c cVar;
        c cv;
        int i3;
        c cVar2 = null;
        int i4 = 2;
        if (this.mCurItem != i) {
            i4 = this.mCurItem < i ? IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER : 33;
            cVar2 = xe(this.mCurItem);
            this.mCurItem = i;
        }
        int i5 = i4;
        if (this.mAdapter == null) {
            sortChildDrawingOrder();
        } else if (this.mPopulatePending) {
            sortChildDrawingOrder();
        } else if (getWindowToken() != null) {
            this.mAdapter.startUpdate((ViewGroup) this);
            int i6 = this.mOffscreenPageLimit;
            int max = Math.max(0, this.mCurItem - i6);
            int count = this.mAdapter.getCount();
            int min = Math.min(count - 1, i6 + this.mCurItem);
            if (count != this.mExpectedAdapterCount) {
                try {
                    hexString = getResources().getResourceName(getId());
                } catch (Resources.NotFoundException e2) {
                    hexString = Integer.toHexString(getId());
                }
                throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.mExpectedAdapterCount + ", found: " + count + " Pager id: " + hexString + " Pager class: " + getClass() + " Problematic adapter: " + this.mAdapter.getClass());
            }
            int i7 = 0;
            while (true) {
                i2 = i7;
                if (i2 >= this.mItems.size()) {
                    break;
                }
                cVar = this.mItems.get(i2);
                if (cVar.position < this.mCurItem) {
                    i7 = i2 + 1;
                }
            }
            cVar = null;
            c bW = (cVar != null || count <= 0) ? cVar : bW(this.mCurItem, i2);
            if (bW != null) {
                float f2 = 0.0f;
                int i8 = i2 - 1;
                c cVar3 = i8 >= 0 ? this.mItems.get(i8) : null;
                int clientHeight = getClientHeight();
                float paddingLeft = clientHeight <= 0 ? 0.0f : (2.0f - bW.gdr) + (getPaddingLeft() / clientHeight);
                int i9 = this.mCurItem - 1;
                int i10 = i2;
                while (i9 >= 0) {
                    if (f2 >= paddingLeft && i9 < max) {
                        if (cVar3 == null) {
                            break;
                        } else if (i9 != cVar3.position || cVar3.scrolling) {
                            i3 = i8;
                        } else {
                            this.mItems.remove(i8);
                            this.mAdapter.destroyItem((ViewGroup) this, i9, cVar3.object);
                            i3 = i8 - 1;
                            int i11 = i10 - 1;
                            cVar3 = i3 >= 0 ? this.mItems.get(i3) : null;
                            i10 = i11;
                        }
                    } else if (cVar3 != null && i9 == cVar3.position) {
                        f2 += cVar3.gdr;
                        i3 = i8 - 1;
                        cVar3 = i3 >= 0 ? this.mItems.get(i3) : null;
                    } else {
                        f2 += bW(i9, i8 + 1).gdr;
                        i10++;
                        cVar3 = i8 >= 0 ? this.mItems.get(i8) : null;
                        i3 = i8;
                    }
                    i9--;
                    i8 = i3;
                }
                float f3 = bW.gdr;
                int i12 = i10 + 1;
                if (f3 < 2.0f) {
                    c cVar4 = i12 < this.mItems.size() ? this.mItems.get(i12) : null;
                    float paddingRight = clientHeight <= 0 ? 0.0f : (getPaddingRight() / clientHeight) + 2.0f;
                    c cVar5 = cVar4;
                    for (int i13 = this.mCurItem + 1; i13 < count; i13++) {
                        if (f3 >= paddingRight && i13 > min) {
                            if (cVar5 == null) {
                                break;
                            } else if (i13 == cVar5.position && !cVar5.scrolling) {
                                this.mItems.remove(i12);
                                this.mAdapter.destroyItem((ViewGroup) this, i13, cVar5.object);
                                cVar5 = i12 < this.mItems.size() ? this.mItems.get(i12) : null;
                            }
                        } else if (cVar5 != null && i13 == cVar5.position) {
                            f3 += cVar5.gdr;
                            i12++;
                            cVar5 = i12 < this.mItems.size() ? this.mItems.get(i12) : null;
                        } else {
                            c bW2 = bW(i13, i12);
                            i12++;
                            f3 += bW2.gdr;
                            cVar5 = i12 < this.mItems.size() ? this.mItems.get(i12) : null;
                        }
                    }
                }
                a(bW, i10, cVar2);
            }
            this.mAdapter.setPrimaryItem((ViewGroup) this, this.mCurItem, bW != null ? bW.object : null);
            this.mAdapter.finishUpdate((ViewGroup) this);
            int childCount = getChildCount();
            for (int i14 = 0; i14 < childCount; i14++) {
                View childAt = getChildAt(i14);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                layoutParams.childIndex = i14;
                if (!layoutParams.isDecor && layoutParams.gdr == 0.0f && (cv = cv(childAt)) != null) {
                    layoutParams.gdr = cv.gdr;
                    layoutParams.position = cv.position;
                }
            }
            sortChildDrawingOrder();
            if (hasFocus()) {
                View findFocus = findFocus();
                c cw = findFocus != null ? cw(findFocus) : null;
                if (cw == null || cw.position != this.mCurItem) {
                    for (int i15 = 0; i15 < getChildCount(); i15++) {
                        View childAt2 = getChildAt(i15);
                        c cv2 = cv(childAt2);
                        if (cv2 != null && cv2.position == this.mCurItem && childAt2.requestFocus(i5)) {
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
            Collections.sort(this.mDrawingOrderedChildren, hGp);
        }
    }

    private void a(c cVar, int i, c cVar2) {
        c cVar3;
        c cVar4;
        int count = this.mAdapter.getCount();
        int clientHeight = getClientHeight();
        float f2 = clientHeight > 0 ? this.mPageMargin / clientHeight : 0.0f;
        if (cVar2 != null) {
            int i2 = cVar2.position;
            if (i2 < cVar.position) {
                float f3 = cVar2.offset + cVar2.gdr + f2;
                int i3 = i2 + 1;
                int i4 = 0;
                while (i3 <= cVar.position && i4 < this.mItems.size()) {
                    c cVar5 = this.mItems.get(i4);
                    while (true) {
                        cVar4 = cVar5;
                        if (i3 <= cVar4.position || i4 >= this.mItems.size() - 1) {
                            break;
                        }
                        i4++;
                        cVar5 = this.mItems.get(i4);
                    }
                    while (i3 < cVar4.position) {
                        f3 += this.mAdapter.getPageWidth(i3) + f2;
                        i3++;
                    }
                    cVar4.offset = f3;
                    f3 += cVar4.gdr + f2;
                    i3++;
                }
            } else if (i2 > cVar.position) {
                int size = this.mItems.size() - 1;
                float f4 = cVar2.offset;
                int i5 = i2 - 1;
                while (i5 >= cVar.position && size >= 0) {
                    c cVar6 = this.mItems.get(size);
                    while (true) {
                        cVar3 = cVar6;
                        if (i5 >= cVar3.position || size <= 0) {
                            break;
                        }
                        size--;
                        cVar6 = this.mItems.get(size);
                    }
                    while (i5 > cVar3.position) {
                        f4 -= this.mAdapter.getPageWidth(i5) + f2;
                        i5--;
                    }
                    f4 -= cVar3.gdr + f2;
                    cVar3.offset = f4;
                    i5--;
                }
            }
        }
        int size2 = this.mItems.size();
        float f5 = cVar.offset;
        int i6 = cVar.position - 1;
        this.mFirstOffset = cVar.position == 0 ? cVar.offset : -3.4028235E38f;
        this.mLastOffset = cVar.position == count + (-1) ? (cVar.offset + cVar.gdr) - 1.0f : Float.MAX_VALUE;
        for (int i7 = i - 1; i7 >= 0; i7--) {
            c cVar7 = this.mItems.get(i7);
            float f6 = f5;
            while (i6 > cVar7.position) {
                f6 -= this.mAdapter.getPageWidth(i6) + f2;
                i6--;
            }
            f5 = f6 - (cVar7.gdr + f2);
            cVar7.offset = f5;
            if (cVar7.position == 0) {
                this.mFirstOffset = f5;
            }
            i6--;
        }
        float f7 = cVar.offset + cVar.gdr + f2;
        int i8 = cVar.position + 1;
        for (int i9 = i + 1; i9 < size2; i9++) {
            c cVar8 = this.mItems.get(i9);
            float f8 = f7;
            while (i8 < cVar8.position) {
                f8 += this.mAdapter.getPageWidth(i8) + f2;
                i8++;
            }
            if (cVar8.position == count - 1) {
                this.mLastOffset = (cVar8.gdr + f8) - 1.0f;
            }
            cVar8.offset = f8;
            f7 = f8 + cVar8.gdr + f2;
            i8++;
        }
        this.mNeedCalculatePageOffsets = false;
    }

    /* loaded from: classes11.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = ParcelableCompat.newCreator(new ParcelableCompatCreatorCallbacks<SavedState>() { // from class: com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.core.os.ParcelableCompatCreatorCallbacks
            /* renamed from: c */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.core.os.ParcelableCompatCreatorCallbacks
            /* renamed from: xf */
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
        layoutParams2.isDecor |= view instanceof b;
        if (this.mInLayout) {
            if (layoutParams2.isDecor) {
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

    c cv(View view) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mItems.size()) {
                c cVar = this.mItems.get(i2);
                if (!this.mAdapter.isViewFromObject(view, cVar.object)) {
                    i = i2 + 1;
                } else {
                    return cVar;
                }
            } else {
                return null;
            }
        }
    }

    c cw(View view) {
        while (true) {
            ViewParent parent = view.getParent();
            if (parent != this) {
                if (!(parent instanceof View)) {
                    return null;
                }
                view = (View) parent;
            } else {
                return cv(view);
            }
        }
    }

    c xe(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.mItems.size()) {
                c cVar = this.mItems.get(i3);
                if (cVar.position != i) {
                    i2 = i3 + 1;
                } else {
                    return cVar;
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

    /* JADX WARN: Removed duplicated region for block: B:34:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b5  */
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
                    i4 = 1073741824;
                    i3 = layoutParams2.width != -1 ? layoutParams2.width : measuredWidth;
                } else {
                    i3 = measuredWidth;
                    i4 = i9;
                }
                if (layoutParams2.height != -2) {
                    i10 = 1073741824;
                    if (layoutParams2.height != -1) {
                        i5 = layoutParams2.height;
                        childAt.measure(View.MeasureSpec.makeMeasureSpec(i3, i4), View.MeasureSpec.makeMeasureSpec(i5, i10));
                        if (!z) {
                            paddingTop -= childAt.getMeasuredHeight();
                        } else if (z2) {
                            measuredWidth -= childAt.getMeasuredWidth();
                        }
                    }
                }
                i5 = paddingTop;
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i3, i4), View.MeasureSpec.makeMeasureSpec(i5, i10));
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
            if (childAt2.getVisibility() != 8 && (layoutParams = (LayoutParams) childAt2.getLayoutParams()) != null && !layoutParams.isDecor) {
                childAt2.measure(this.mChildWidthMeasureSpec, View.MeasureSpec.makeMeasureSpec((int) (layoutParams.gdr * paddingTop), 1073741824));
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
                this.mScroller.startScroll(0, paddingTop, 0, (int) (xe(this.mCurItem).offset * i), this.mScroller.getDuration() - this.mScroller.timePassed());
                return;
            }
            return;
        }
        c xe = xe(this.mCurItem);
        int min = (int) ((xe != null ? Math.min(xe.offset, this.mLastOffset) : 0.0f) * ((i - getPaddingTop()) - getPaddingBottom()));
        if (min != getScrollY()) {
            completeScroll(false);
            scrollTo(getScrollX(), min);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        c cv;
        int i5;
        int i6;
        int i7;
        int measuredWidth;
        int measuredHeight;
        int i8;
        int childCount = getChildCount();
        int i9 = i3 - i;
        int i10 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollY = getScrollY();
        int i11 = 0;
        int i12 = 0;
        while (i12 < childCount) {
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.isDecor) {
                    int i13 = layoutParams.gravity & 7;
                    int i14 = layoutParams.gravity & 112;
                    switch (i13) {
                        case 1:
                            measuredWidth = Math.max((i9 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                            i6 = paddingRight;
                            i7 = paddingLeft;
                            break;
                        case 2:
                        case 4:
                        default:
                            measuredWidth = paddingLeft;
                            i6 = paddingRight;
                            i7 = paddingLeft;
                            break;
                        case 3:
                            i7 = paddingLeft + childAt.getMeasuredWidth();
                            measuredWidth = paddingLeft;
                            i6 = paddingRight;
                            break;
                        case 5:
                            measuredWidth = (i9 - paddingRight) - childAt.getMeasuredWidth();
                            i6 = paddingRight + childAt.getMeasuredWidth();
                            i7 = paddingLeft;
                            break;
                    }
                    switch (i14) {
                        case 16:
                            measuredHeight = Math.max((i10 - childAt.getMeasuredHeight()) / 2, paddingTop);
                            i8 = paddingTop;
                            break;
                        case 48:
                            i8 = paddingTop + childAt.getMeasuredHeight();
                            measuredHeight = paddingTop;
                            break;
                        case 80:
                            measuredHeight = (i10 - paddingBottom) - childAt.getMeasuredHeight();
                            paddingBottom += childAt.getMeasuredHeight();
                            i8 = paddingTop;
                            break;
                        default:
                            measuredHeight = paddingTop;
                            i8 = paddingTop;
                            break;
                    }
                    int i15 = measuredHeight + scrollY;
                    childAt.layout(measuredWidth, i15, childAt.getMeasuredWidth() + measuredWidth, childAt.getMeasuredHeight() + i15);
                    i5 = i11 + 1;
                    paddingTop = i8;
                    i12++;
                    i11 = i5;
                    paddingRight = i6;
                    paddingLeft = i7;
                }
            }
            i5 = i11;
            i6 = paddingRight;
            i7 = paddingLeft;
            i12++;
            i11 = i5;
            paddingRight = i6;
            paddingLeft = i7;
        }
        int i16 = (i10 - paddingTop) - paddingBottom;
        for (int i17 = 0; i17 < childCount; i17++) {
            View childAt2 = getChildAt(i17);
            if (childAt2.getVisibility() != 8) {
                LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                if (!layoutParams2.isDecor && (cv = cv(childAt2)) != null) {
                    int i18 = ((int) (cv.offset * i16)) + paddingTop;
                    if (layoutParams2.needsMeasure) {
                        layoutParams2.needsMeasure = false;
                        childAt2.measure(View.MeasureSpec.makeMeasureSpec((i9 - paddingLeft) - paddingRight, 1073741824), View.MeasureSpec.makeMeasureSpec((int) (layoutParams2.gdr * i16), 1073741824));
                    }
                    childAt2.layout(paddingLeft, i18, childAt2.getMeasuredWidth() + paddingLeft, childAt2.getMeasuredHeight() + i18);
                }
            }
        }
        this.gdi = paddingLeft;
        this.gdj = i9 - paddingRight;
        this.mDecorChildCount = i11;
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
            if (this.hGr != null && this.mScroller.getFinalY() - currY == 0) {
                this.hGr.cjE();
            }
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
        c cjD = cjD();
        int clientHeight = getClientHeight();
        int i2 = this.mPageMargin + clientHeight;
        float f2 = this.mPageMargin / clientHeight;
        int i3 = cjD.position;
        float f3 = ((i / clientHeight) - cjD.offset) / (cjD.gdr + f2);
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
        if (this.mDecorChildCount > 0) {
            int scrollY = getScrollY();
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int height = getHeight();
            int childCount = getChildCount();
            int i4 = 0;
            while (i4 < childCount) {
                View childAt = getChildAt(i4);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.isDecor) {
                    switch (layoutParams.gravity & 112) {
                        case 16:
                            measuredHeight = Math.max((height - childAt.getMeasuredHeight()) / 2, paddingTop);
                            i3 = paddingTop;
                            break;
                        case 48:
                            i3 = paddingTop + childAt.getHeight();
                            measuredHeight = paddingTop;
                            break;
                        case 80:
                            measuredHeight = (height - paddingBottom) - childAt.getMeasuredHeight();
                            paddingBottom += childAt.getMeasuredHeight();
                            i3 = paddingTop;
                            break;
                        default:
                            measuredHeight = paddingTop;
                            i3 = paddingTop;
                            break;
                    }
                    int top = (measuredHeight + scrollY) - childAt.getTop();
                    if (top != 0) {
                        childAt.offsetTopAndBottom(top);
                    }
                } else {
                    i3 = paddingTop;
                }
                i4++;
                paddingTop = i3;
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
            for (int i5 = 0; i5 < childCount2; i5++) {
                View childAt2 = getChildAt(i5);
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
            c cVar = this.mItems.get(i);
            if (cVar.scrolling) {
                cVar.scrolling = false;
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

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.bWN = false;
                break;
            case 1:
            case 3:
                if (this.bWN) {
                    resetTouch();
                    break;
                }
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        this.bWN = z;
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.hGi && !this.hGk) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (this.hGj) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            resetTouch();
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
            case 2:
                try {
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
                        if (abs > this.mTouchSlop && this.hGl * abs > abs2) {
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
                } catch (IllegalArgumentException e2) {
                    e2.printStackTrace();
                    break;
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
        if (!this.hGi && !this.hGk) {
            return super.onTouchEvent(motionEvent);
        }
        if (this.hGj) {
            return super.onTouchEvent(motionEvent);
        }
        if (this.mFakeDragging) {
            return true;
        }
        this.hGq.onTouchEvent(motionEvent);
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
                        c cjD = cjD();
                        setCurrentItemInternal(determineTargetPage(cjD.position, ((scrollY / clientHeight) - cjD.offset) / cjD.gdr, yVelocity, (int) (MotionEventCompat.getY(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.mActivePointerId)) - this.mInitialMotionY)), true, true, yVelocity);
                        this.mActivePointerId = -1;
                        endDrag();
                        z = this.gdk.onRelease() || this.gdl.onRelease();
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
                        if (this.gdk.onRelease() || this.gdl.onRelease()) {
                            z = true;
                            break;
                        }
                    }
                    break;
                case 5:
                    int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                    MotionEventCompat.getY(motionEvent, actionIndex);
                    this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                    break;
                case 6:
                    onSecondaryPointerUp(motionEvent);
                    break;
            }
            if (z) {
                ViewCompat.postInvalidateOnAnimation(this);
                return true;
            }
            return true;
        }
        return false;
    }

    private void resetTouch() {
        this.mIsBeingDragged = false;
        this.mIsUnableToDrag = false;
        this.mActivePointerId = -1;
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
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
        c cVar = this.mItems.get(0);
        c cVar2 = this.mItems.get(this.mItems.size() - 1);
        if (cVar.position != 0) {
            f4 = clientHeight * cVar.offset;
            z = false;
        } else {
            z = true;
        }
        if (cVar2.position != this.mAdapter.getCount() - 1) {
            f3 = cVar2.offset * clientHeight;
            z2 = false;
        } else {
            f3 = f5;
        }
        if (scrollY < f4) {
            if (z) {
                r2 = this.gdk.onPull(Math.abs(f4 - scrollY) / clientHeight);
            }
        } else if (scrollY > f3) {
            r2 = z2 ? this.gdl.onPull(Math.abs(scrollY - f3) / clientHeight) : false;
            f4 = f3;
        } else {
            f4 = scrollY;
        }
        this.mLastMotionX += f4 - ((int) f4);
        scrollTo(getScrollX(), (int) f4);
        pageScrolled((int) f4);
        return r2;
    }

    private c cjD() {
        c cVar;
        int clientHeight = getClientHeight();
        float scrollY = clientHeight > 0 ? getScrollY() / clientHeight : 0.0f;
        float f2 = clientHeight > 0 ? this.mPageMargin / clientHeight : 0.0f;
        int i = -1;
        boolean z = true;
        int i2 = 0;
        c cVar2 = null;
        float f3 = 0.0f;
        float f4 = 0.0f;
        while (i2 < this.mItems.size()) {
            c cVar3 = this.mItems.get(i2);
            if (z || cVar3.position == i + 1) {
                cVar = cVar3;
            } else {
                c cVar4 = this.hGm;
                cVar4.offset = f4 + f3 + f2;
                cVar4.position = i + 1;
                cVar4.gdr = this.mAdapter.getPageWidth(cVar4.position);
                i2--;
                cVar = cVar4;
            }
            f4 = cVar.offset;
            float f5 = cVar.gdr + f4 + f2;
            if (z || scrollY >= f4) {
                if (scrollY < f5 || i2 == this.mItems.size() - 1) {
                    return cVar;
                }
                i = cVar.position;
                f3 = cVar.gdr;
                i2++;
                cVar2 = cVar;
                z = false;
            } else {
                return cVar2;
            }
        }
        return cVar2;
    }

    private int determineTargetPage(int i, float f2, int i2, int i3) {
        if (Math.abs(i3) > this.mFlingDistance && Math.abs(i2) > this.mMinimumVelocity) {
            if (i2 <= 0) {
                i++;
            }
        } else if (Math.abs(i3) > getClientHeight() * 0.17f) {
            i = i3 > 0 ? i - 1 : i + 1;
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
            if (!this.gdk.isFinished()) {
                int save = canvas.save();
                int height = getHeight();
                int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                canvas.translate(getPaddingLeft(), this.mFirstOffset * height);
                this.gdk.setSize(width, height);
                z = false | this.gdk.draw(canvas);
                canvas.restoreToCount(save);
            }
            if (!this.gdl.isFinished()) {
                int save2 = canvas.save();
                int height2 = getHeight();
                int width2 = (getWidth() - getPaddingLeft()) - getPaddingRight();
                canvas.rotate(180.0f);
                canvas.translate((-width2) - getPaddingLeft(), (-(this.mLastOffset + 1.0f)) * height2);
                this.gdl.setSize(width2, height2);
                z |= this.gdl.draw(canvas);
                canvas.restoreToCount(save2);
            }
        } else {
            this.gdk.finish();
            this.gdl.finish();
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
            c cVar = this.mItems.get(0);
            float f4 = cVar.offset;
            int size = this.mItems.size();
            int i = cVar.position;
            int i2 = this.mItems.get(size - 1).position;
            int i3 = 0;
            for (int i4 = i; i4 < i2; i4++) {
                while (i4 > cVar.position && i3 < size) {
                    i3++;
                    cVar = this.mItems.get(i3);
                }
                if (i4 == cVar.position) {
                    f2 = (cVar.offset + cVar.gdr) * height;
                    f4 = cVar.offset + cVar.gdr + f3;
                } else {
                    float pageWidth = this.mAdapter.getPageWidth(i4);
                    f2 = (f4 + pageWidth) * height;
                    f4 += pageWidth + f3;
                }
                if (this.mPageMargin + f2 > scrollY) {
                    this.mMarginDrawable.setBounds(this.gdi, (int) f2, this.gdj, (int) (this.mPageMargin + f2 + 0.5f));
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

    public boolean uj(int i) {
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
        boolean bMo;
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
                    bMo = bMo();
                } else {
                    bMo = findNextFocus.requestFocus();
                }
            } else {
                if (i == 130) {
                    int i4 = getChildRectInPagerCoordinates(this.mTempRect, findNextFocus).bottom;
                    int i5 = getChildRectInPagerCoordinates(this.mTempRect, view).bottom;
                    if (view != null && i4 <= i5) {
                        bMo = bMp();
                    } else {
                        bMo = findNextFocus.requestFocus();
                    }
                }
                bMo = false;
            }
        } else if (i == 33 || i == 1) {
            bMo = bMo();
        } else {
            if (i == 130 || i == 2) {
                bMo = bMp();
            }
            bMo = false;
        }
        if (bMo) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
        }
        return bMo;
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

    boolean bMo() {
        if (this.mCurItem > 0) {
            setCurrentItem(this.mCurItem - 1, false);
            return true;
        }
        return false;
    }

    boolean bMp() {
        if (this.mAdapter == null || this.mCurItem >= this.mAdapter.getCount() - 1) {
            return false;
        }
        setCurrentItem(this.mCurItem + 1, false);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        c cv;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0 && (cv = cv(childAt)) != null && cv.position == this.mCurItem) {
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
        c cv;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (cv = cv(childAt)) != null && cv.position == this.mCurItem) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        int i3;
        c cv;
        int childCount = getChildCount();
        if ((i & 2) != 0) {
            i3 = 1;
            i2 = 0;
        } else {
            i2 = childCount - 1;
            childCount = -1;
            i3 = -1;
        }
        while (i2 != childCount) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (cv = cv(childAt)) != null && cv.position == this.mCurItem && childAt.requestFocus(i, rect)) {
                return true;
            }
            i2 += i3;
        }
        return false;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        c cv;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (cv = cv(childAt)) != null && cv.position == this.mCurItem && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
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

    public void setEventListener(a.InterfaceC0684a interfaceC0684a) {
        if (this.hGq != null) {
            this.hGq.setEventListener(interfaceC0684a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class d extends AccessibilityDelegateCompat {
        d() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(ViewPager.class.getName());
            AccessibilityRecordCompat obtain = AccessibilityRecordCompat.obtain();
            obtain.setScrollable(canScroll());
            if (accessibilityEvent.getEventType() == 4096 && AlaVerticalViewPagerNew.this.mAdapter != null) {
                obtain.setItemCount(AlaVerticalViewPagerNew.this.mAdapter.getCount());
                obtain.setFromIndex(AlaVerticalViewPagerNew.this.mCurItem);
                obtain.setToIndex(AlaVerticalViewPagerNew.this.mCurItem);
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setClassName(ViewPager.class.getName());
            accessibilityNodeInfoCompat.setScrollable(canScroll());
            if (AlaVerticalViewPagerNew.this.uj(1)) {
                accessibilityNodeInfoCompat.addAction(4096);
            }
            if (AlaVerticalViewPagerNew.this.uj(-1)) {
                accessibilityNodeInfoCompat.addAction(8192);
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (super.performAccessibilityAction(view, i, bundle)) {
                return true;
            }
            switch (i) {
                case 4096:
                    if (AlaVerticalViewPagerNew.this.uj(1)) {
                        AlaVerticalViewPagerNew.this.setCurrentItem(AlaVerticalViewPagerNew.this.mCurItem + 1);
                        return true;
                    }
                    return false;
                case 8192:
                    if (AlaVerticalViewPagerNew.this.uj(-1)) {
                        AlaVerticalViewPagerNew.this.setCurrentItem(AlaVerticalViewPagerNew.this.mCurItem - 1);
                        return true;
                    }
                    return false;
                default:
                    return false;
            }
        }

        private boolean canScroll() {
            return AlaVerticalViewPagerNew.this.mAdapter != null && AlaVerticalViewPagerNew.this.mAdapter.getCount() > 1;
        }
    }

    /* loaded from: classes11.dex */
    private class f extends DataSetObserver {
        private f() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            AlaVerticalViewPagerNew.this.dataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            AlaVerticalViewPagerNew.this.dataSetChanged();
        }
    }

    /* loaded from: classes11.dex */
    public static class LayoutParams extends ViewGroup.LayoutParams {
        int childIndex;
        float gdr;
        public int gravity;
        public boolean isDecor;
        boolean needsMeasure;
        int position;

        public LayoutParams() {
            super(-1, -1);
            this.gdr = 0.0f;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.gdr = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AlaVerticalViewPagerNew.LAYOUT_ATTRS);
            this.gravity = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public static class g implements Comparator<View> {
        g() {
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

    public void setCallback(a aVar) {
        this.hGr = aVar;
    }
}
