package com.baidu.tieba.horizonalList.widget;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.Checkable;
import android.widget.ListAdapter;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.EdgeEffectCompat;
import com.baidu.tieba.R;
import com.baidu.tieba.R$styleable;
import com.baidu.tieba.horizonalList.widget.AdapterView;
import d.b.i0.a1.a.b;
import java.util.ArrayList;
import java.util.List;
@TargetApi(11)
/* loaded from: classes3.dex */
public abstract class AbsHListView extends AdapterView<ListAdapter> implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnTouchModeChangeListener {
    public static final int CHECK_POSITION_SEARCH_DISTANCE = 20;
    public static final int INVALID_POINTER = -1;
    public static final int LAYOUT_FORCE_LEFT = 1;
    public static final int LAYOUT_FORCE_RIGHT = 3;
    public static final int LAYOUT_MOVE_SELECTION = 6;
    public static final int LAYOUT_NORMAL = 0;
    public static final int LAYOUT_SET_SELECTION = 2;
    public static final int LAYOUT_SPECIFIC = 4;
    public static final int LAYOUT_SYNC = 5;
    public static final int OVERSCROLL_LIMIT_DIVISOR = 3;
    public static final String TAG = "AbsListView";
    public static final int TOUCH_MODE_DONE_WAITING = 2;
    public static final int TOUCH_MODE_DOWN = 0;
    public static final int TOUCH_MODE_FLING = 4;
    public static final int TOUCH_MODE_OFF = 1;
    public static final int TOUCH_MODE_ON = 0;
    public static final int TOUCH_MODE_OVERFLING = 6;
    public static final int TOUCH_MODE_OVERSCROLL = 5;
    public static final int TOUCH_MODE_REST = -1;
    public static final int TOUCH_MODE_SCROLL = 3;
    public static final int TOUCH_MODE_TAP = 1;
    public static final int TOUCH_MODE_UNKNOWN = -1;
    public static final int TRANSCRIPT_MODE_ALWAYS_SCROLL = 2;
    public static final int TRANSCRIPT_MODE_DISABLED = 0;
    public static final int TRANSCRIPT_MODE_NORMAL = 1;
    public h mAccessibilityDelegate;
    public int mActivePointerId;
    public ListAdapter mAdapter;
    public boolean mAdapterHasStableIds;
    public int mCacheColorHint;
    public boolean mCachingActive;
    public boolean mCachingStarted;
    public SparseArrayCompat<Boolean> mCheckStates;
    public LongSparseArray<Integer> mCheckedIdStates;
    public int mCheckedItemCount;
    public Object mChoiceActionMode;
    public int mChoiceMode;
    public Runnable mClearScrollingCache;
    public ContextMenu.ContextMenuInfo mContextMenuInfo;
    public c mDataSetObserver;
    public int mDirection;
    public boolean mDrawSelectorOnTop;
    public EdgeEffectCompat mEdgeGlowBottom;
    public EdgeEffectCompat mEdgeGlowTop;
    public boolean mFastScrollEnabled;
    public int mFirstPositionDistanceGuess;
    public g mFlingRunnable;
    public boolean mForceTranscriptScroll;
    public int mGlowPaddingBottom;
    public int mGlowPaddingTop;
    public int mHeightMeasureSpec;
    public float mHorizontalScrollFactor;
    public boolean mIsAttached;
    public boolean mIsChildViewEnabled;
    public final boolean[] mIsScrap;
    public int mLastAccessibilityScrollEventFromIndex;
    public int mLastAccessibilityScrollEventToIndex;
    public int mLastHandledItemCount;
    public int mLastPositionDistanceGuess;
    public int mLastScrollState;
    public int mLastTouchMode;
    public int mLastX;
    public int mLayoutMode;
    public Rect mListPadding;
    public int mMaximumVelocity;
    public int mMinimumVelocity;
    public int mMotionCorrection;
    public int mMotionPosition;
    public int mMotionViewNewLeft;
    public int mMotionViewOriginalLeft;
    public int mMotionX;
    public int mMotionY;
    public Object mMultiChoiceModeCallback;
    public i mOnScrollListener;
    public int mOverflingDistance;
    public int mOverscrollDistance;
    public int mOverscrollMax;
    public d mPendingCheckForKeyLongPress;
    public e mPendingCheckForLongPress;
    public Runnable mPendingCheckForTap;
    public SavedState mPendingSync;
    public j mPerformClick;
    public Runnable mPositionScrollAfterLayout;
    public k mPositionScroller;
    public final l mRecycler;
    public int mResurrectToPosition;
    public View mScrollLeft;
    public View mScrollRight;
    public boolean mScrollingCacheEnabled;
    public int mSelectedLeft;
    public int mSelectionBottomPadding;
    public int mSelectionLeftPadding;
    public int mSelectionRightPadding;
    public int mSelectionTopPadding;
    public Drawable mSelector;
    public int mSelectorPosition;
    public Rect mSelectorRect;
    public boolean mSmoothScrollbarEnabled;
    public boolean mStackFromRight;
    public Rect mTouchFrame;
    public int mTouchMode;
    public Runnable mTouchModeReset;
    public int mTouchSlop;
    public int mTranscriptMode;
    public float mVelocityScale;
    public VelocityTracker mVelocityTracker;
    public b.a mViewHelper;
    public static final Interpolator sLinearInterpolator = new LinearInterpolator();
    public static final int[] STATESET_NOTHING = {0};

    /* loaded from: classes3.dex */
    public static class LayoutParams extends ViewGroup.LayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public int f17447a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f17448b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f17449c;

        /* renamed from: d  reason: collision with root package name */
        public int f17450d;

        /* renamed from: e  reason: collision with root package name */
        public long f17451e;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(int i, int i2, int i3) {
            super(i, i2);
            this.f17447a = i3;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    /* loaded from: classes3.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: e  reason: collision with root package name */
        public long f17452e;

        /* renamed from: f  reason: collision with root package name */
        public long f17453f;

        /* renamed from: g  reason: collision with root package name */
        public int f17454g;

        /* renamed from: h  reason: collision with root package name */
        public int f17455h;
        public int i;
        public String j;
        public boolean k;
        public int l;
        public SparseArrayCompat<Boolean> m;
        public LongSparseArray<Integer> n;

        /* loaded from: classes3.dex */
        public static class a implements Parcelable.Creator<SavedState> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        public /* synthetic */ SavedState(Parcel parcel, a aVar) {
            this(parcel);
        }

        public final SparseArrayCompat<Boolean> a(Parcel parcel) {
            int readInt = parcel.readInt();
            if (readInt < 0) {
                return null;
            }
            SparseArrayCompat<Boolean> sparseArrayCompat = new SparseArrayCompat<>(readInt);
            b(sparseArrayCompat, parcel, readInt);
            return sparseArrayCompat;
        }

        public final void b(SparseArrayCompat<Boolean> sparseArrayCompat, Parcel parcel, int i) {
            while (i > 0) {
                int readInt = parcel.readInt();
                boolean z = true;
                if (parcel.readByte() != 1) {
                    z = false;
                }
                sparseArrayCompat.append(readInt, Boolean.valueOf(z));
                i--;
            }
        }

        public final LongSparseArray<Integer> c(Parcel parcel) {
            int readInt = parcel.readInt();
            if (readInt <= 0) {
                return null;
            }
            LongSparseArray<Integer> longSparseArray = new LongSparseArray<>(readInt);
            d(longSparseArray, parcel, readInt);
            return longSparseArray;
        }

        public final void d(LongSparseArray<Integer> longSparseArray, Parcel parcel, int i) {
            while (i > 0) {
                longSparseArray.put(parcel.readLong(), Integer.valueOf(parcel.readInt()));
                i--;
            }
        }

        public final void e(SparseArrayCompat<Boolean> sparseArrayCompat, Parcel parcel) {
            if (sparseArrayCompat == null) {
                parcel.writeInt(-1);
                return;
            }
            int size = sparseArrayCompat.size();
            parcel.writeInt(size);
            for (int i = 0; i < size; i++) {
                parcel.writeInt(sparseArrayCompat.keyAt(i));
                parcel.writeByte(sparseArrayCompat.valueAt(i).booleanValue() ? (byte) 1 : (byte) 0);
            }
        }

        public final void f(LongSparseArray<Integer> longSparseArray, Parcel parcel) {
            int size = longSparseArray != null ? longSparseArray.size() : 0;
            parcel.writeInt(size);
            for (int i = 0; i < size; i++) {
                parcel.writeLong(longSparseArray.keyAt(i));
                parcel.writeInt(longSparseArray.valueAt(i).intValue());
            }
        }

        public String toString() {
            return "AbsListView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " selectedId=" + this.f17452e + " firstId=" + this.f17453f + " viewLeft=" + this.f17454g + " position=" + this.f17455h + " width=" + this.i + " filter=" + this.j + " checkState=" + this.m + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeLong(this.f17452e);
            parcel.writeLong(this.f17453f);
            parcel.writeInt(this.f17454g);
            parcel.writeInt(this.f17455h);
            parcel.writeInt(this.i);
            parcel.writeString(this.j);
            parcel.writeByte(this.k ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.l);
            e(this.m, parcel);
            f(this.n, parcel);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f17452e = parcel.readLong();
            this.f17453f = parcel.readLong();
            this.f17454g = parcel.readInt();
            this.f17455h = parcel.readInt();
            this.i = parcel.readInt();
            this.j = parcel.readString();
            this.k = parcel.readByte() != 0;
            this.l = parcel.readInt();
            this.m = a(parcel);
            this.n = c(parcel);
        }
    }

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f17456e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ j f17457f;

        public a(View view, j jVar) {
            this.f17456e = view;
            this.f17457f = jVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            AbsHListView.this.mTouchMode = -1;
            this.f17456e.setPressed(false);
            AbsHListView.this.setPressed(false);
            if (AbsHListView.this.mDataChanged) {
                return;
            }
            this.f17457f.run();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AbsHListView absHListView = AbsHListView.this;
            if (absHListView.mCachingStarted) {
                absHListView.mCachingActive = false;
                absHListView.mCachingStarted = false;
                absHListView.setChildrenDrawnWithCacheEnabled(false);
                if ((AbsHListView.this.getPersistentDrawingCache() & 2) == 0) {
                    AbsHListView.this.setChildrenDrawingCacheEnabled(false);
                }
                if (AbsHListView.this.isAlwaysDrawnWithCacheEnabled()) {
                    return;
                }
                AbsHListView.this.invalidate();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends AdapterView<ListAdapter>.c {
        public c() {
            super();
        }

        @Override // com.baidu.tieba.horizonalList.widget.AdapterView.c, android.database.DataSetObserver
        public void onChanged() {
            super.onChanged();
        }

        @Override // com.baidu.tieba.horizonalList.widget.AdapterView.c, android.database.DataSetObserver
        public void onInvalidated() {
            super.onInvalidated();
        }
    }

    /* loaded from: classes3.dex */
    public class d extends o implements Runnable {
        public d() {
            super(AbsHListView.this, null);
        }

        @Override // java.lang.Runnable
        public void run() {
            AbsHListView absHListView;
            int i;
            boolean z;
            if (!AbsHListView.this.isPressed() || (i = (absHListView = AbsHListView.this).mSelectedPosition) < 0) {
                return;
            }
            View childAt = absHListView.getChildAt(i - absHListView.mFirstPosition);
            AbsHListView absHListView2 = AbsHListView.this;
            if (!absHListView2.mDataChanged) {
                if (b()) {
                    AbsHListView absHListView3 = AbsHListView.this;
                    z = absHListView3.performLongPress(childAt, absHListView3.mSelectedPosition, absHListView3.mSelectedColId);
                } else {
                    z = false;
                }
                if (z) {
                    AbsHListView.this.setPressed(false);
                    childAt.setPressed(false);
                    return;
                }
                return;
            }
            absHListView2.setPressed(false);
            if (childAt != null) {
                childAt.setPressed(false);
            }
        }

        public /* synthetic */ d(AbsHListView absHListView, a aVar) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    public class e extends o implements Runnable {
        public e() {
            super(AbsHListView.this, null);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x002c  */
        /* JADX WARN: Removed duplicated region for block: B:12:0x0038  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            boolean z;
            AbsHListView absHListView = AbsHListView.this;
            View childAt = absHListView.getChildAt(absHListView.mMotionPosition - absHListView.mFirstPosition);
            if (childAt == null) {
                return;
            }
            AbsHListView absHListView2 = AbsHListView.this;
            int i = absHListView2.mMotionPosition;
            long itemId = absHListView2.mAdapter.getItemId(i);
            if (b()) {
                AbsHListView absHListView3 = AbsHListView.this;
                if (!absHListView3.mDataChanged) {
                    z = absHListView3.performLongPress(childAt, i, itemId);
                    if (!z) {
                        AbsHListView absHListView4 = AbsHListView.this;
                        absHListView4.mTouchMode = -1;
                        absHListView4.setPressed(false);
                        childAt.setPressed(false);
                        return;
                    }
                    AbsHListView.this.mTouchMode = 2;
                    return;
                }
            }
            z = false;
            if (!z) {
            }
        }

        public /* synthetic */ e(AbsHListView absHListView, a aVar) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    public final class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Drawable current;
            AbsHListView absHListView = AbsHListView.this;
            if (absHListView.mTouchMode == 0) {
                absHListView.mTouchMode = 1;
                View childAt = absHListView.getChildAt(absHListView.mMotionPosition - absHListView.mFirstPosition);
                if (childAt == null || childAt.hasFocusable()) {
                    return;
                }
                AbsHListView absHListView2 = AbsHListView.this;
                absHListView2.mLayoutMode = 0;
                if (!absHListView2.mDataChanged) {
                    childAt.setPressed(true);
                    AbsHListView.this.setPressed(true);
                    AbsHListView.this.layoutChildren();
                    AbsHListView absHListView3 = AbsHListView.this;
                    absHListView3.positionSelector(absHListView3.mMotionPosition, childAt);
                    AbsHListView.this.refreshDrawableState();
                    int longPressTimeout = ViewConfiguration.getLongPressTimeout();
                    boolean isLongClickable = AbsHListView.this.isLongClickable();
                    Drawable drawable = AbsHListView.this.mSelector;
                    if (drawable != null && (current = drawable.getCurrent()) != null && (current instanceof TransitionDrawable)) {
                        if (isLongClickable) {
                            ((TransitionDrawable) current).startTransition(longPressTimeout);
                        } else {
                            ((TransitionDrawable) current).resetTransition();
                        }
                    }
                    if (isLongClickable) {
                        if (AbsHListView.this.mPendingCheckForLongPress == null) {
                            AbsHListView absHListView4 = AbsHListView.this;
                            absHListView4.mPendingCheckForLongPress = new e(absHListView4, null);
                        }
                        AbsHListView.this.mPendingCheckForLongPress.a();
                        AbsHListView absHListView5 = AbsHListView.this;
                        absHListView5.postDelayed(absHListView5.mPendingCheckForLongPress, longPressTimeout);
                        return;
                    }
                    AbsHListView.this.mTouchMode = 2;
                    return;
                }
                absHListView2.mTouchMode = 2;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final d.b.i0.a1.b.e f17464e;

        /* renamed from: f  reason: collision with root package name */
        public int f17465f;

        /* renamed from: g  reason: collision with root package name */
        public final Runnable f17466g = new a();

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                int i = AbsHListView.this.mActivePointerId;
                VelocityTracker velocityTracker = AbsHListView.this.mVelocityTracker;
                d.b.i0.a1.b.e eVar = g.this.f17464e;
                if (velocityTracker == null || i == -1) {
                    return;
                }
                velocityTracker.computeCurrentVelocity(1000, AbsHListView.this.mMaximumVelocity);
                float f2 = -velocityTracker.getXVelocity(i);
                if (Math.abs(f2) >= AbsHListView.this.mMinimumVelocity && eVar.h(f2, 0.0f)) {
                    AbsHListView.this.postDelayed(this, 40L);
                    return;
                }
                g.this.c();
                AbsHListView absHListView = AbsHListView.this;
                absHListView.mTouchMode = 3;
                absHListView.reportScrollStateChange(1);
            }
        }

        public g() {
            this.f17464e = new d.b.i0.a1.b.e(AbsHListView.this.getContext());
        }

        public void b(int i) {
            this.f17464e.i(AbsHListView.this.getScrollX(), 0, AbsHListView.this.mOverflingDistance);
            int overScrollMode = AbsHListView.this.getOverScrollMode();
            if (overScrollMode != 0 && (overScrollMode != 1 || AbsHListView.this.contentFits())) {
                AbsHListView absHListView = AbsHListView.this;
                absHListView.mTouchMode = -1;
                k kVar = absHListView.mPositionScroller;
                if (kVar != null) {
                    kVar.f();
                }
            } else {
                AbsHListView.this.mTouchMode = 6;
                int e2 = (int) this.f17464e.e();
                if (i > 0) {
                    AbsHListView.this.mEdgeGlowTop.onAbsorb(e2);
                } else {
                    AbsHListView.this.mEdgeGlowBottom.onAbsorb(e2);
                }
            }
            AbsHListView.this.invalidate();
            AbsHListView.this.mViewHelper.b(this);
        }

        public void c() {
            AbsHListView absHListView = AbsHListView.this;
            absHListView.mTouchMode = -1;
            absHListView.removeCallbacks(this);
            AbsHListView.this.removeCallbacks(this.f17466g);
            AbsHListView.this.reportScrollStateChange(0);
            AbsHListView.this.clearScrollingCache();
            this.f17464e.a();
            AbsHListView.this.overScrollBy(0, 0, 0, 0, 0, 0, 0, 0, false);
        }

        public void d() {
            AbsHListView.this.postDelayed(this.f17466g, 40L);
        }

        public void e(int i) {
            int i2 = i < 0 ? Integer.MAX_VALUE : 0;
            this.f17465f = i2;
            this.f17464e.k(null);
            this.f17464e.c(i2, 0, i, 0, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
            AbsHListView absHListView = AbsHListView.this;
            absHListView.mTouchMode = 4;
            absHListView.mViewHelper.b(this);
        }

        public void f(int i) {
            this.f17464e.k(null);
            this.f17464e.d(AbsHListView.this.getScrollX(), 0, i, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0, AbsHListView.this.getWidth(), 0);
            AbsHListView absHListView = AbsHListView.this;
            absHListView.mTouchMode = 6;
            absHListView.invalidate();
            AbsHListView.this.mViewHelper.b(this);
        }

        public void g(int i, int i2, boolean z) {
            int i3 = i < 0 ? Integer.MAX_VALUE : 0;
            this.f17465f = i3;
            this.f17464e.k(z ? AbsHListView.sLinearInterpolator : null);
            this.f17464e.m(i3, 0, i, 0, i2);
            AbsHListView absHListView = AbsHListView.this;
            absHListView.mTouchMode = 4;
            absHListView.mViewHelper.b(this);
        }

        public void h() {
            if (this.f17464e.l(AbsHListView.this.getScrollX(), 0, 0, 0, 0, 0)) {
                AbsHListView absHListView = AbsHListView.this;
                absHListView.mTouchMode = 6;
                absHListView.invalidate();
                AbsHListView.this.mViewHelper.b(this);
                return;
            }
            AbsHListView absHListView2 = AbsHListView.this;
            absHListView2.mTouchMode = -1;
            absHListView2.reportScrollStateChange(0);
        }

        @Override // java.lang.Runnable
        public void run() {
            int max;
            int i = AbsHListView.this.mTouchMode;
            boolean z = false;
            if (i != 3) {
                if (i != 4) {
                    if (i != 6) {
                        c();
                        return;
                    }
                    d.b.i0.a1.b.e eVar = this.f17464e;
                    if (eVar.b()) {
                        int scrollX = AbsHListView.this.getScrollX();
                        int f2 = eVar.f();
                        AbsHListView absHListView = AbsHListView.this;
                        if (!absHListView.overScrollBy(f2 - scrollX, 0, scrollX, 0, 0, 0, absHListView.mOverflingDistance, 0, false)) {
                            AbsHListView.this.invalidate();
                            AbsHListView.this.mViewHelper.b(this);
                            return;
                        }
                        boolean z2 = scrollX <= 0 && f2 > 0;
                        if (scrollX >= 0 && f2 < 0) {
                            z = true;
                        }
                        if (!z2 && !z) {
                            h();
                            return;
                        }
                        int e2 = (int) eVar.e();
                        if (z) {
                            e2 = -e2;
                        }
                        eVar.a();
                        e(e2);
                        return;
                    }
                    c();
                    return;
                }
            } else if (this.f17464e.g()) {
                return;
            }
            AbsHListView absHListView2 = AbsHListView.this;
            if (absHListView2.mDataChanged) {
                absHListView2.layoutChildren();
            }
            AbsHListView absHListView3 = AbsHListView.this;
            if (absHListView3.mItemCount != 0 && absHListView3.getChildCount() != 0) {
                d.b.i0.a1.b.e eVar2 = this.f17464e;
                boolean b2 = eVar2.b();
                int f3 = eVar2.f();
                int i2 = this.f17465f - f3;
                if (i2 > 0) {
                    AbsHListView absHListView4 = AbsHListView.this;
                    absHListView4.mMotionPosition = absHListView4.mFirstPosition;
                    AbsHListView.this.mMotionViewOriginalLeft = absHListView4.getChildAt(0).getLeft();
                    max = Math.min(((AbsHListView.this.getWidth() - AbsHListView.this.getPaddingRight()) - AbsHListView.this.getPaddingLeft()) - 1, i2);
                } else {
                    int childCount = AbsHListView.this.getChildCount() - 1;
                    AbsHListView absHListView5 = AbsHListView.this;
                    absHListView5.mMotionPosition = absHListView5.mFirstPosition + childCount;
                    AbsHListView.this.mMotionViewOriginalLeft = absHListView5.getChildAt(childCount).getLeft();
                    max = Math.max(-(((AbsHListView.this.getWidth() - AbsHListView.this.getPaddingRight()) - AbsHListView.this.getPaddingLeft()) - 1), i2);
                }
                AbsHListView absHListView6 = AbsHListView.this;
                View childAt = absHListView6.getChildAt(absHListView6.mMotionPosition - absHListView6.mFirstPosition);
                int left = childAt != null ? childAt.getLeft() : 0;
                boolean trackMotionScroll = AbsHListView.this.trackMotionScroll(max, max);
                if (trackMotionScroll && max != 0) {
                    z = true;
                }
                if (z) {
                    if (childAt != null) {
                        AbsHListView absHListView7 = AbsHListView.this;
                        absHListView7.overScrollBy(-(max - (childAt.getLeft() - left)), 0, absHListView7.getScrollX(), 0, 0, 0, AbsHListView.this.mOverflingDistance, 0, false);
                    }
                    if (b2) {
                        b(max);
                        return;
                    }
                    return;
                } else if (b2 && !z) {
                    if (trackMotionScroll) {
                        AbsHListView.this.invalidate();
                    }
                    this.f17465f = f3;
                    AbsHListView.this.mViewHelper.b(this);
                    return;
                } else {
                    c();
                    return;
                }
            }
            c();
        }
    }

    @TargetApi(14)
    /* loaded from: classes3.dex */
    public class h extends AccessibilityDelegateCompat {
        public h() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            int positionForView = AbsHListView.this.getPositionForView(view);
            ListAdapter adapter = AbsHListView.this.getAdapter();
            if (positionForView == -1 || adapter == null || !AbsHListView.this.isEnabled() || !adapter.isEnabled(positionForView)) {
                return;
            }
            if (positionForView == AbsHListView.this.getSelectedItemPosition()) {
                accessibilityNodeInfoCompat.setSelected(true);
                accessibilityNodeInfoCompat.addAction(8);
            } else {
                accessibilityNodeInfoCompat.addAction(4);
            }
            if (AbsHListView.this.isClickable()) {
                accessibilityNodeInfoCompat.addAction(16);
                accessibilityNodeInfoCompat.setClickable(true);
            }
            if (AbsHListView.this.isLongClickable()) {
                accessibilityNodeInfoCompat.addAction(32);
                accessibilityNodeInfoCompat.setLongClickable(true);
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (super.performAccessibilityAction(view, i, bundle)) {
                return true;
            }
            int positionForView = AbsHListView.this.getPositionForView(view);
            ListAdapter adapter = AbsHListView.this.getAdapter();
            if (positionForView != -1 && adapter != null && AbsHListView.this.isEnabled() && adapter.isEnabled(positionForView)) {
                long itemIdAtPosition = AbsHListView.this.getItemIdAtPosition(positionForView);
                if (i != 4) {
                    if (i == 8) {
                        if (AbsHListView.this.getSelectedItemPosition() == positionForView) {
                            AbsHListView.this.setSelection(-1);
                            return true;
                        }
                        return false;
                    } else if (i != 16) {
                        if (i == 32 && AbsHListView.this.isLongClickable()) {
                            return AbsHListView.this.performLongPress(view, positionForView, itemIdAtPosition);
                        }
                        return false;
                    } else if (AbsHListView.this.isClickable()) {
                        return AbsHListView.this.performItemClick(view, positionForView, itemIdAtPosition);
                    } else {
                        return false;
                    }
                } else if (AbsHListView.this.getSelectedItemPosition() != positionForView) {
                    AbsHListView.this.setSelection(positionForView);
                    return true;
                }
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public interface i {
        void a(AbsHListView absHListView, int i, int i2, int i3);

        void b(AbsHListView absHListView, int i);
    }

    /* loaded from: classes3.dex */
    public class j extends o implements Runnable {

        /* renamed from: g  reason: collision with root package name */
        public int f17470g;

        public j() {
            super(AbsHListView.this, null);
        }

        @Override // java.lang.Runnable
        public void run() {
            AbsHListView absHListView = AbsHListView.this;
            if (absHListView.mDataChanged) {
                return;
            }
            ListAdapter listAdapter = absHListView.mAdapter;
            int i = this.f17470g;
            if (listAdapter == null || absHListView.mItemCount <= 0 || i == -1 || i >= listAdapter.getCount() || !b()) {
                return;
            }
            AbsHListView absHListView2 = AbsHListView.this;
            View childAt = absHListView2.getChildAt(i - absHListView2.mFirstPosition);
            if (childAt != null) {
                AbsHListView.this.performItemClick(childAt, i, listAdapter.getItemId(i));
            }
        }

        public /* synthetic */ j(AbsHListView absHListView, a aVar) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    public class k implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public int f17472e;

        /* renamed from: f  reason: collision with root package name */
        public int f17473f;

        /* renamed from: g  reason: collision with root package name */
        public int f17474g;

        /* renamed from: h  reason: collision with root package name */
        public int f17475h;
        public int i;
        public final int j;
        public int k;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f17476e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f17477f;

            public a(int i, int i2) {
                this.f17476e = i;
                this.f17477f = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                k.this.c(this.f17476e, this.f17477f);
            }
        }

        /* loaded from: classes3.dex */
        public class b implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f17479e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f17480f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ int f17481g;

            public b(int i, int i2, int i3) {
                this.f17479e = i;
                this.f17480f = i2;
                this.f17481g = i3;
            }

            @Override // java.lang.Runnable
            public void run() {
                k.this.e(this.f17479e, this.f17480f, this.f17481g);
            }
        }

        public k() {
            this.j = ViewConfiguration.get(AbsHListView.this.getContext()).getScaledFadingEdgeLength();
        }

        public void a(int i, int i2, int i3) {
            AbsHListView absHListView = AbsHListView.this;
            int i4 = absHListView.mFirstPosition;
            int childCount = (absHListView.getChildCount() + i4) - 1;
            AbsHListView absHListView2 = AbsHListView.this;
            int i5 = absHListView2.mListPadding.left;
            int width = absHListView2.getWidth() - AbsHListView.this.mListPadding.right;
            i2 = (i2 < i4 || i2 > childCount) ? -1 : -1;
            View childAt = AbsHListView.this.getChildAt(i - i4);
            int left = childAt.getLeft();
            int right = childAt.getRight();
            int i6 = right > width ? right - width : 0;
            if (left < i5) {
                i6 = left - i5;
            }
            if (i6 == 0) {
                return;
            }
            if (i2 >= 0) {
                View childAt2 = AbsHListView.this.getChildAt(i2 - i4);
                int left2 = childAt2.getLeft();
                int right2 = childAt2.getRight();
                int abs = Math.abs(i6);
                if (i6 < 0 && right2 + abs > width) {
                    i6 = Math.max(0, right2 - width);
                } else if (i6 > 0 && left2 - abs < i5) {
                    i6 = Math.min(0, left2 - i5);
                }
            }
            AbsHListView.this.smoothScrollBy(i6, i3);
        }

        public void b(int i) {
            f();
            int childCount = AbsHListView.this.getChildCount();
            int i2 = AbsHListView.this.mFirstPosition;
            int i3 = (childCount + i2) - 1;
            if (i < i2) {
                this.f17472e = 2;
            } else if (i > i3) {
                this.f17472e = 1;
            } else {
                a(i, -1, 200);
                return;
            }
            this.i = 200;
            this.f17473f = i;
            this.f17474g = -1;
            this.f17475h = -1;
            AbsHListView.this.mViewHelper.b(this);
        }

        /* JADX WARN: Removed duplicated region for block: B:32:0x0060  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0064  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void c(int i, int i2) {
            int i3;
            int i4;
            f();
            if (i2 == -1) {
                b(i);
                return;
            }
            AbsHListView absHListView = AbsHListView.this;
            if (absHListView.mDataChanged) {
                absHListView.mPositionScrollAfterLayout = new a(i, i2);
                return;
            }
            int childCount = absHListView.getChildCount();
            if (childCount == 0) {
                return;
            }
            AbsHListView absHListView2 = AbsHListView.this;
            int i5 = absHListView2.mFirstPosition;
            int i6 = (childCount + i5) - 1;
            int max = Math.max(0, Math.min(absHListView2.getCount() - 1, i));
            if (max < i5) {
                int i7 = i6 - i2;
                if (i7 < 1) {
                    return;
                }
                i4 = (i5 - max) + 1;
                i3 = i7 - 1;
                if (i3 < i4) {
                    this.f17472e = 4;
                    i4 = i3;
                    if (i4 <= 0) {
                        this.i = 200 / i4;
                    } else {
                        this.i = 200;
                    }
                    this.f17473f = max;
                    this.f17474g = i2;
                    this.f17475h = -1;
                    AbsHListView.this.mViewHelper.b(this);
                }
                this.f17472e = 2;
                if (i4 <= 0) {
                }
                this.f17473f = max;
                this.f17474g = i2;
                this.f17475h = -1;
                AbsHListView.this.mViewHelper.b(this);
            } else if (max <= i6) {
                a(max, i2, 200);
            } else {
                int i8 = i2 - i5;
                if (i8 < 1) {
                    return;
                }
                i3 = (max - i6) + 1;
                i4 = i8 - 1;
                if (i4 < i3) {
                    this.f17472e = 3;
                    if (i4 <= 0) {
                    }
                    this.f17473f = max;
                    this.f17474g = i2;
                    this.f17475h = -1;
                    AbsHListView.this.mViewHelper.b(this);
                }
                this.f17472e = 1;
                i4 = i3;
                if (i4 <= 0) {
                }
                this.f17473f = max;
                this.f17474g = i2;
                this.f17475h = -1;
                AbsHListView.this.mViewHelper.b(this);
            }
        }

        public void d(int i, int i2) {
            e(i, i2, 200);
        }

        public void e(int i, int i2, int i3) {
            int i4;
            f();
            AbsHListView absHListView = AbsHListView.this;
            if (absHListView.mDataChanged) {
                absHListView.mPositionScrollAfterLayout = new b(i, i2, i3);
                return;
            }
            int childCount = absHListView.getChildCount();
            if (childCount == 0) {
                return;
            }
            int paddingLeft = i2 + AbsHListView.this.getPaddingLeft();
            int max = Math.max(0, Math.min(AbsHListView.this.getCount() - 1, i));
            this.f17473f = max;
            this.k = paddingLeft;
            this.f17474g = -1;
            this.f17475h = -1;
            this.f17472e = 5;
            AbsHListView absHListView2 = AbsHListView.this;
            int i5 = absHListView2.mFirstPosition;
            int i6 = (i5 + childCount) - 1;
            if (max < i5) {
                i4 = i5 - max;
            } else if (max <= i6) {
                AbsHListView.this.smoothScrollBy(absHListView2.getChildAt(max - i5).getLeft() - paddingLeft, i3, false);
                return;
            } else {
                i4 = max - i6;
            }
            float f2 = i4 / childCount;
            if (f2 >= 1.0f) {
                i3 = (int) (i3 / f2);
            }
            this.i = i3;
            this.f17475h = -1;
            AbsHListView.this.mViewHelper.b(this);
        }

        public void f() {
            AbsHListView.this.removeCallbacks(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            int width = AbsHListView.this.getWidth();
            AbsHListView absHListView = AbsHListView.this;
            int i = absHListView.mFirstPosition;
            int i2 = this.f17472e;
            if (i2 == 1) {
                int childCount = absHListView.getChildCount() - 1;
                if (childCount < 0) {
                    return;
                }
                int i3 = i + childCount;
                View childAt = AbsHListView.this.getChildAt(childCount);
                int width2 = childAt.getWidth();
                int left = width - childAt.getLeft();
                AbsHListView absHListView2 = AbsHListView.this;
                int i4 = absHListView2.mItemCount - 1;
                int i5 = absHListView2.mListPadding.right;
                if (i3 < i4) {
                    i5 = Math.max(i5, this.j);
                }
                AbsHListView.this.smoothScrollBy((width2 - left) + i5, this.i, true);
                this.f17475h = i3;
                if (i3 < this.f17473f) {
                    AbsHListView.this.mViewHelper.b(this);
                    return;
                }
                return;
            }
            int i6 = 0;
            if (i2 == 2) {
                if (i == this.f17475h) {
                    absHListView.mViewHelper.b(this);
                    return;
                }
                View childAt2 = absHListView.getChildAt(0);
                if (childAt2 == null) {
                    return;
                }
                AbsHListView.this.smoothScrollBy(childAt2.getLeft() - (i > 0 ? Math.max(this.j, AbsHListView.this.mListPadding.left) : AbsHListView.this.mListPadding.left), this.i, true);
                this.f17475h = i;
                if (i > this.f17473f) {
                    AbsHListView.this.mViewHelper.b(this);
                }
            } else if (i2 == 3) {
                int childCount2 = absHListView.getChildCount();
                if (i == this.f17474g || childCount2 <= 1) {
                    return;
                }
                int i7 = childCount2 + i;
                AbsHListView absHListView3 = AbsHListView.this;
                if (i7 >= absHListView3.mItemCount) {
                    return;
                }
                int i8 = i + 1;
                if (i8 == this.f17475h) {
                    absHListView3.mViewHelper.b(this);
                    return;
                }
                View childAt3 = absHListView3.getChildAt(1);
                int width3 = childAt3.getWidth();
                int left2 = childAt3.getLeft();
                int max = Math.max(AbsHListView.this.mListPadding.right, this.j);
                if (i8 < this.f17474g) {
                    AbsHListView.this.smoothScrollBy(Math.max(0, (width3 + left2) - max), this.i, true);
                    this.f17475h = i8;
                    AbsHListView.this.mViewHelper.b(this);
                } else if (left2 > max) {
                    AbsHListView.this.smoothScrollBy(left2 - max, this.i, true);
                }
            } else if (i2 == 4) {
                int childCount3 = absHListView.getChildCount() - 2;
                if (childCount3 < 0) {
                    return;
                }
                int i9 = i + childCount3;
                if (i9 == this.f17475h) {
                    AbsHListView.this.mViewHelper.b(this);
                    return;
                }
                View childAt4 = AbsHListView.this.getChildAt(childCount3);
                int width4 = childAt4.getWidth();
                int left3 = childAt4.getLeft();
                int i10 = width - left3;
                int max2 = Math.max(AbsHListView.this.mListPadding.left, this.j);
                this.f17475h = i9;
                if (i9 > this.f17474g) {
                    AbsHListView.this.smoothScrollBy(-(i10 - max2), this.i, true);
                    AbsHListView.this.mViewHelper.b(this);
                    return;
                }
                int i11 = width - max2;
                int i12 = left3 + width4;
                if (i11 > i12) {
                    AbsHListView.this.smoothScrollBy(-(i11 - i12), this.i, true);
                }
            } else if (i2 != 5) {
            } else {
                if (this.f17475h == i) {
                    absHListView.mViewHelper.b(this);
                    return;
                }
                this.f17475h = i;
                int childCount4 = absHListView.getChildCount();
                int i13 = this.f17473f;
                int i14 = (i + childCount4) - 1;
                if (i13 < i) {
                    i6 = (i - i13) + 1;
                } else if (i13 > i14) {
                    i6 = i13 - i14;
                }
                float min = Math.min(Math.abs(i6 / childCount4), 1.0f);
                if (i13 < i) {
                    AbsHListView.this.smoothScrollBy((int) ((-AbsHListView.this.getWidth()) * min), (int) (this.i * min), true);
                    AbsHListView.this.mViewHelper.b(this);
                } else if (i13 > i14) {
                    AbsHListView.this.smoothScrollBy((int) (AbsHListView.this.getWidth() * min), (int) (this.i * min), true);
                    AbsHListView.this.mViewHelper.b(this);
                } else {
                    int left4 = AbsHListView.this.getChildAt(i13 - i).getLeft() - this.k;
                    AbsHListView.this.smoothScrollBy(left4, (int) (this.i * (Math.abs(left4) / AbsHListView.this.getWidth())), true);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class l {

        /* renamed from: a  reason: collision with root package name */
        public m f17483a;

        /* renamed from: b  reason: collision with root package name */
        public int f17484b;

        /* renamed from: c  reason: collision with root package name */
        public View[] f17485c = new View[0];

        /* renamed from: d  reason: collision with root package name */
        public ArrayList<View>[] f17486d;

        /* renamed from: e  reason: collision with root package name */
        public int f17487e;

        /* renamed from: f  reason: collision with root package name */
        public ArrayList<View> f17488f;

        /* renamed from: g  reason: collision with root package name */
        public ArrayList<View> f17489g;

        /* renamed from: h  reason: collision with root package name */
        public SparseArrayCompat<View> f17490h;

        public l() {
        }

        @SuppressLint({"NewApi"})
        public void c(View view, int i) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (layoutParams == null) {
                return;
            }
            layoutParams.f17450d = i;
            int i2 = layoutParams.f17447a;
            if (!q(i2)) {
                if (i2 == -2) {
                    return;
                }
                if (this.f17489g == null) {
                    this.f17489g = new ArrayList<>();
                }
                this.f17489g.add(view);
                return;
            }
            view.onStartTemporaryDetach();
            if (this.f17487e == 1) {
                this.f17488f.add(view);
            } else {
                this.f17486d[i2].add(view);
            }
            if (Build.VERSION.SDK_INT >= 14) {
                view.setAccessibilityDelegate(null);
            }
            m mVar = this.f17483a;
            if (mVar != null) {
                mVar.onMovedToScrapHeap(view);
            }
        }

        public void d() {
            int i = this.f17487e;
            if (i == 1) {
                ArrayList<View> arrayList = this.f17488f;
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    AbsHListView.this.removeDetachedView(arrayList.remove((size - 1) - i2), false);
                }
            } else {
                for (int i3 = 0; i3 < i; i3++) {
                    ArrayList<View> arrayList2 = this.f17486d[i3];
                    int size2 = arrayList2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        AbsHListView.this.removeDetachedView(arrayList2.remove((size2 - 1) - i4), false);
                    }
                }
            }
            SparseArrayCompat<View> sparseArrayCompat = this.f17490h;
            if (sparseArrayCompat != null) {
                sparseArrayCompat.clear();
            }
        }

        public void e() {
            SparseArrayCompat<View> sparseArrayCompat = this.f17490h;
            if (sparseArrayCompat != null) {
                sparseArrayCompat.clear();
            }
        }

        public void f(int i, int i2) {
            if (this.f17485c.length < i) {
                this.f17485c = new View[i];
            }
            this.f17484b = i2;
            View[] viewArr = this.f17485c;
            for (int i3 = 0; i3 < i; i3++) {
                View childAt = AbsHListView.this.getChildAt(i3);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams != null && layoutParams.f17447a != -2) {
                    viewArr[i3] = childAt;
                }
            }
        }

        public View g(int i) {
            int i2 = i - this.f17484b;
            View[] viewArr = this.f17485c;
            if (i2 < 0 || i2 >= viewArr.length) {
                return null;
            }
            View view = viewArr[i2];
            viewArr[i2] = null;
            return view;
        }

        public View h(int i) {
            if (this.f17487e == 1) {
                return AbsHListView.retrieveFromScrap(this.f17488f, i);
            }
            int itemViewType = AbsHListView.this.mAdapter.getItemViewType(i);
            if (itemViewType >= 0) {
                ArrayList<View>[] arrayListArr = this.f17486d;
                if (itemViewType < arrayListArr.length) {
                    return AbsHListView.retrieveFromScrap(arrayListArr[itemViewType], i);
                }
                return null;
            }
            return null;
        }

        public View i(int i) {
            int indexOfKey;
            SparseArrayCompat<View> sparseArrayCompat = this.f17490h;
            if (sparseArrayCompat != null && (indexOfKey = sparseArrayCompat.indexOfKey(i)) >= 0) {
                View valueAt = this.f17490h.valueAt(indexOfKey);
                this.f17490h.removeAt(indexOfKey);
                return valueAt;
            }
            return null;
        }

        public void j() {
            int i = this.f17487e;
            if (i == 1) {
                ArrayList<View> arrayList = this.f17488f;
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    arrayList.get(i2).forceLayout();
                }
            } else {
                for (int i3 = 0; i3 < i; i3++) {
                    ArrayList<View> arrayList2 = this.f17486d[i3];
                    int size2 = arrayList2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        arrayList2.get(i4).forceLayout();
                    }
                }
            }
            SparseArrayCompat<View> sparseArrayCompat = this.f17490h;
            if (sparseArrayCompat != null) {
                int size3 = sparseArrayCompat.size();
                for (int i5 = 0; i5 < size3; i5++) {
                    this.f17490h.valueAt(i5).forceLayout();
                }
            }
        }

        @SuppressLint({"NewApi"})
        public final void k() {
            int length = this.f17485c.length;
            int i = this.f17487e;
            ArrayList<View>[] arrayListArr = this.f17486d;
            for (int i2 = 0; i2 < i; i2++) {
                ArrayList<View> arrayList = arrayListArr[i2];
                int size = arrayList.size();
                int i3 = size - length;
                int i4 = size - 1;
                int i5 = 0;
                while (i5 < i3) {
                    AbsHListView.this.removeDetachedView(arrayList.remove(i4), false);
                    i5++;
                    i4--;
                }
            }
            if (this.f17490h != null) {
                for (int i6 = 0; i6 < this.f17490h.size(); i6++) {
                    this.f17490h.valueAt(i6);
                }
            }
        }

        public void l(List<View> list) {
            int i = this.f17487e;
            if (i == 1) {
                list.addAll(this.f17488f);
                return;
            }
            ArrayList<View>[] arrayListArr = this.f17486d;
            for (int i2 = 0; i2 < i; i2++) {
                list.addAll(arrayListArr[i2]);
            }
        }

        public void m() {
            ArrayList<View> arrayList = this.f17489g;
            if (arrayList == null) {
                return;
            }
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                AbsHListView.this.removeDetachedView(this.f17489g.get(i), false);
            }
            this.f17489g.clear();
        }

        @SuppressLint({"NewApi"})
        public void n() {
            View[] viewArr = this.f17485c;
            boolean z = this.f17483a != null;
            boolean z2 = this.f17487e > 1;
            ArrayList<View> arrayList = this.f17488f;
            for (int length = viewArr.length - 1; length >= 0; length--) {
                View view = viewArr[length];
                if (view != null) {
                    LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                    int i = layoutParams.f17447a;
                    viewArr[length] = null;
                    if (q(i)) {
                        if (z2) {
                            arrayList = this.f17486d[i];
                        }
                        view.onStartTemporaryDetach();
                        layoutParams.f17450d = this.f17484b + length;
                        arrayList.add(view);
                        if (Build.VERSION.SDK_INT >= 14) {
                            view.setAccessibilityDelegate(null);
                        }
                        if (z) {
                            this.f17483a.onMovedToScrapHeap(view);
                        }
                    } else if (i != -2) {
                        AbsHListView.this.removeDetachedView(view, false);
                    }
                }
            }
            k();
        }

        public void o(int i) {
            View[] viewArr;
            int i2 = this.f17487e;
            if (i2 == 1) {
                ArrayList<View> arrayList = this.f17488f;
                int size = arrayList.size();
                for (int i3 = 0; i3 < size; i3++) {
                    arrayList.get(i3).setDrawingCacheBackgroundColor(i);
                }
            } else {
                for (int i4 = 0; i4 < i2; i4++) {
                    ArrayList<View> arrayList2 = this.f17486d[i4];
                    int size2 = arrayList2.size();
                    for (int i5 = 0; i5 < size2; i5++) {
                        arrayList2.get(i5).setDrawingCacheBackgroundColor(i);
                    }
                }
            }
            for (View view : this.f17485c) {
                if (view != null) {
                    view.setDrawingCacheBackgroundColor(i);
                }
            }
        }

        public void p(int i) {
            if (i >= 1) {
                ArrayList<View>[] arrayListArr = new ArrayList[i];
                for (int i2 = 0; i2 < i; i2++) {
                    arrayListArr[i2] = new ArrayList<>();
                }
                this.f17487e = i;
                this.f17488f = arrayListArr[0];
                this.f17486d = arrayListArr;
                return;
            }
            throw new IllegalArgumentException("Can't have a viewTypeCount < 1");
        }

        public boolean q(int i) {
            return i >= 0;
        }
    }

    /* loaded from: classes3.dex */
    public interface m {
        void onMovedToScrapHeap(View view);
    }

    /* loaded from: classes3.dex */
    public interface n {
        void adjustListItemSelectionBounds(Rect rect);
    }

    /* loaded from: classes3.dex */
    public class o {

        /* renamed from: e  reason: collision with root package name */
        public int f17491e;

        public o() {
        }

        public void a() {
            this.f17491e = AbsHListView.this.getWindowAttachCount();
        }

        public boolean b() {
            return AbsHListView.this.hasWindowFocus() && AbsHListView.this.getWindowAttachCount() == this.f17491e;
        }

        public /* synthetic */ o(AbsHListView absHListView, a aVar) {
            this();
        }
    }

    public AbsHListView(Context context) {
        super(context);
        this.mChoiceMode = 0;
        this.mLayoutMode = 0;
        this.mDrawSelectorOnTop = false;
        this.mSelectorPosition = -1;
        this.mSelectorRect = new Rect();
        this.mRecycler = new l();
        this.mSelectionLeftPadding = 0;
        this.mSelectionTopPadding = 0;
        this.mSelectionRightPadding = 0;
        this.mSelectionBottomPadding = 0;
        this.mListPadding = new Rect();
        this.mHeightMeasureSpec = 0;
        this.mTouchMode = -1;
        this.mSelectedLeft = 0;
        this.mSmoothScrollbarEnabled = true;
        this.mResurrectToPosition = -1;
        this.mContextMenuInfo = null;
        this.mLastTouchMode = -1;
        this.mLastScrollState = 0;
        this.mVelocityScale = 1.0f;
        this.mIsScrap = new boolean[1];
        this.mActivePointerId = -1;
        this.mDirection = 0;
        initAbsListView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearScrollingCache() {
        if (this.mViewHelper.a()) {
            return;
        }
        if (this.mClearScrollingCache == null) {
            this.mClearScrollingCache = new b();
        }
        post(this.mClearScrollingCache);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean contentFits() {
        int childCount = getChildCount();
        if (childCount == 0) {
            return true;
        }
        return childCount == this.mItemCount && getChildAt(0).getLeft() >= this.mListPadding.left && getChildAt(childCount - 1).getRight() <= getWidth() - this.mListPadding.right;
    }

    private void createScrollingCache() {
        if (!this.mScrollingCacheEnabled || this.mCachingStarted || this.mViewHelper.a()) {
            return;
        }
        setChildrenDrawnWithCacheEnabled(true);
        setChildrenDrawingCacheEnabled(true);
        this.mCachingActive = true;
        this.mCachingStarted = true;
    }

    private void drawSelector(Canvas canvas) {
        if (this.mSelectorRect.isEmpty()) {
            return;
        }
        Drawable drawable = this.mSelector;
        drawable.setBounds(this.mSelectorRect);
        drawable.draw(canvas);
    }

    private void finishGlows() {
        EdgeEffectCompat edgeEffectCompat = this.mEdgeGlowTop;
        if (edgeEffectCompat != null) {
            edgeEffectCompat.finish();
            this.mEdgeGlowBottom.finish();
        }
    }

    public static int getDistance(Rect rect, Rect rect2, int i2) {
        int width;
        int height;
        int width2;
        int i3;
        int height2;
        int i4;
        if (i2 == 1 || i2 == 2) {
            width = rect.right + (rect.width() / 2);
            height = (rect.height() / 2) + rect.top;
            width2 = rect2.left + (rect2.width() / 2);
            i3 = rect2.top;
            height2 = rect2.height() / 2;
        } else if (i2 != 17) {
            if (i2 == 33) {
                width = rect.left + (rect.width() / 2);
                height = rect.top;
                width2 = rect2.left + (rect2.width() / 2);
                i4 = rect2.bottom;
            } else if (i2 == 66) {
                width = rect.right;
                height = (rect.height() / 2) + rect.top;
                width2 = rect2.left;
                i3 = rect2.top;
                height2 = rect2.height() / 2;
            } else if (i2 == 130) {
                width = rect.left + (rect.width() / 2);
                height = rect.bottom;
                width2 = rect2.left + (rect2.width() / 2);
                i4 = rect2.top;
            } else {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT, FOCUS_FORWARD, FOCUS_BACKWARD}.");
            }
            int i5 = width2 - width;
            int i6 = i4 - height;
            return (i6 * i6) + (i5 * i5);
        } else {
            width = rect.left;
            height = (rect.height() / 2) + rect.top;
            width2 = rect2.right;
            i3 = rect2.top;
            height2 = rect2.height() / 2;
        }
        i4 = height2 + i3;
        int i52 = width2 - width;
        int i62 = i4 - height;
        return (i62 * i62) + (i52 * i52);
    }

    private void initAbsListView() {
        setClickable(true);
        setFocusableInTouchMode(true);
        setWillNotDraw(false);
        setAlwaysDrawnWithCacheEnabled(false);
        setScrollingCacheEnabled(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mOverscrollDistance = viewConfiguration.getScaledOverscrollDistance();
        this.mOverflingDistance = viewConfiguration.getScaledOverflingDistance();
        this.mViewHelper = d.b.i0.a1.a.b.a(this);
    }

    private void initOrResetVelocityTracker() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    private void initVelocityTrackerIfNotExists() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        int action = (motionEvent.getAction() & 65280) >> 8;
        if (motionEvent.getPointerId(action) == this.mActivePointerId) {
            int i2 = action == 0 ? 1 : 0;
            this.mMotionX = (int) motionEvent.getX(i2);
            this.mMotionY = (int) motionEvent.getY(i2);
            this.mMotionCorrection = 0;
            this.mActivePointerId = motionEvent.getPointerId(i2);
        }
    }

    private void recycleVelocityTracker() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    public static View retrieveFromScrap(ArrayList<View> arrayList, int i2) {
        int size = arrayList.size();
        if (size > 0) {
            for (int i3 = 0; i3 < size; i3++) {
                View view = arrayList.get(i3);
                if (((LayoutParams) view.getLayoutParams()).f17450d == i2) {
                    arrayList.remove(i3);
                    return view;
                }
            }
            return arrayList.remove(size - 1);
        }
        return null;
    }

    private void scrollIfNeeded(int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int childCount;
        VelocityTracker velocityTracker;
        ViewParent parent;
        int i8 = i2 - this.mMotionX;
        int i9 = i8 - this.mMotionCorrection;
        int i10 = this.mLastX;
        int i11 = i10 != Integer.MIN_VALUE ? i2 - i10 : i9;
        int i12 = this.mTouchMode;
        if (i12 == 3) {
            if (i2 != this.mLastX) {
                if (Math.abs(i8) > this.mTouchSlop && (parent = getParent()) != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
                int i13 = this.mMotionPosition;
                if (i13 >= 0) {
                    childCount = i13 - this.mFirstPosition;
                } else {
                    childCount = getChildCount() / 2;
                }
                View childAt = getChildAt(childCount);
                int left = childAt != null ? childAt.getLeft() : 0;
                boolean trackMotionScroll = i11 != 0 ? trackMotionScroll(i9, i11) : false;
                View childAt2 = getChildAt(childCount);
                if (childAt2 != null) {
                    int left2 = childAt2.getLeft();
                    if (trackMotionScroll) {
                        int i14 = (-i11) - (left2 - left);
                        overScrollBy(i14, 0, getScrollX(), 0, 0, 0, this.mOverscrollDistance, 0, true);
                        if (Math.abs(this.mOverscrollDistance) == Math.abs(getScrollX()) && (velocityTracker = this.mVelocityTracker) != null) {
                            velocityTracker.clear();
                        }
                        int overScrollMode = getOverScrollMode();
                        if (overScrollMode == 0 || (overScrollMode == 1 && !contentFits())) {
                            this.mDirection = 0;
                            this.mTouchMode = 5;
                            if (i8 > 0) {
                                this.mEdgeGlowTop.onPull(i14 / getWidth());
                                if (!this.mEdgeGlowBottom.isFinished()) {
                                    this.mEdgeGlowBottom.onRelease();
                                }
                                invalidate();
                            } else if (i8 < 0) {
                                this.mEdgeGlowBottom.onPull(i14 / getWidth());
                                if (!this.mEdgeGlowTop.isFinished()) {
                                    this.mEdgeGlowTop.onRelease();
                                }
                                invalidate();
                            }
                        }
                    }
                    this.mMotionX = i2;
                }
                this.mLastX = i2;
            }
        } else if (i12 != 5 || i2 == this.mLastX) {
        } else {
            int scrollX = getScrollX();
            int i15 = scrollX - i11;
            int i16 = i2 > this.mLastX ? 1 : -1;
            if (this.mDirection == 0) {
                this.mDirection = i16;
            }
            int i17 = -i11;
            if ((i15 >= 0 || scrollX < 0) && (i15 <= 0 || scrollX > 0)) {
                i3 = i17;
                i4 = 0;
            } else {
                int i18 = -scrollX;
                i4 = i11 + i18;
                i3 = i18;
            }
            if (i3 != 0) {
                i5 = i4;
                int i19 = i3;
                i6 = i16;
                overScrollBy(i3, 0, getScrollX(), 0, 0, 0, this.mOverscrollDistance, 0, true);
                int overScrollMode2 = getOverScrollMode();
                if (overScrollMode2 == 0 || (overScrollMode2 == 1 && !contentFits())) {
                    if (i8 > 0) {
                        this.mEdgeGlowTop.onPull(i19 / getWidth());
                        if (!this.mEdgeGlowBottom.isFinished()) {
                            this.mEdgeGlowBottom.onRelease();
                        }
                        invalidate();
                    } else if (i8 < 0) {
                        this.mEdgeGlowBottom.onPull(i19 / getWidth());
                        if (!this.mEdgeGlowTop.isFinished()) {
                            this.mEdgeGlowTop.onRelease();
                        }
                        invalidate();
                    }
                }
            } else {
                i5 = i4;
                i6 = i16;
            }
            if (i5 != 0) {
                if (getScrollX() != 0) {
                    i7 = 0;
                    this.mViewHelper.c(0);
                    invalidateParentIfNeeded();
                } else {
                    i7 = 0;
                }
                trackMotionScroll(i5, i5);
                this.mTouchMode = 3;
                int findClosestMotionCol = findClosestMotionCol(i2);
                this.mMotionCorrection = i7;
                View childAt3 = getChildAt(findClosestMotionCol - this.mFirstPosition);
                this.mMotionViewOriginalLeft = childAt3 != null ? childAt3.getLeft() : 0;
                this.mMotionX = i2;
                this.mMotionPosition = findClosestMotionCol;
            }
            this.mLastX = i2;
            this.mDirection = i6;
        }
    }

    private boolean startScrollIfNeeded(int i2) {
        int i3 = i2 - this.mMotionX;
        int abs = Math.abs(i3);
        boolean z = getScrollX() != 0;
        if (z || abs > this.mTouchSlop) {
            createScrollingCache();
            if (z) {
                this.mTouchMode = 5;
                this.mMotionCorrection = 0;
            } else {
                this.mTouchMode = 3;
                this.mMotionCorrection = i3 > 0 ? this.mTouchSlop : -this.mTouchSlop;
            }
            Handler handler = getHandler();
            if (handler != null) {
                handler.removeCallbacks(this.mPendingCheckForLongPress);
            }
            setPressed(false);
            View childAt = getChildAt(this.mMotionPosition - this.mFirstPosition);
            if (childAt != null) {
                childAt.setPressed(false);
            }
            reportScrollStateChange(1);
            ViewParent parent = getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            scrollIfNeeded(i2);
            return true;
        }
        return false;
    }

    private void updateOnScreenCheckedViews() {
        int i2 = this.mFirstPosition;
        int childCount = getChildCount();
        boolean z = Build.VERSION.SDK_INT >= 11;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            int i4 = i2 + i3;
            if (childAt instanceof Checkable) {
                ((Checkable) childAt).setChecked(this.mCheckStates.get(i4, Boolean.FALSE).booleanValue());
            } else if (z) {
                childAt.setActivated(this.mCheckStates.get(i4, Boolean.FALSE).booleanValue());
            }
        }
    }

    private void useDefaultSelector() {
        setSelector(getResources().getDrawable(17301602));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        int childCount = getChildCount();
        int i2 = this.mFirstPosition;
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter == null) {
            return;
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (listAdapter.isEnabled(i2 + i3)) {
                arrayList.add(childAt);
            }
            childAt.addTouchables(arrayList);
        }
    }

    @Override // android.view.View
    public boolean checkInputConnectionProxy(View view) {
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void clearChoices() {
        SparseArrayCompat<Boolean> sparseArrayCompat = this.mCheckStates;
        if (sparseArrayCompat != null) {
            sparseArrayCompat.clear();
        }
        LongSparseArray<Integer> longSparseArray = this.mCheckedIdStates;
        if (longSparseArray != null) {
            longSparseArray.clear();
        }
        this.mCheckedItemCount = 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        int childCount = getChildCount();
        if (childCount > 0) {
            if (this.mSmoothScrollbarEnabled) {
                int i2 = childCount * 100;
                View childAt = getChildAt(0);
                int left = childAt.getLeft();
                int width = childAt.getWidth();
                if (width > 0) {
                    i2 += (left * 100) / width;
                }
                View childAt2 = getChildAt(childCount - 1);
                int right = childAt2.getRight();
                int width2 = childAt2.getWidth();
                return width2 > 0 ? i2 - (((right - getWidth()) * 100) / width2) : i2;
            }
            return 1;
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        int i2 = this.mFirstPosition;
        int childCount = getChildCount();
        int i3 = 0;
        if (i2 >= 0 && childCount > 0) {
            if (this.mSmoothScrollbarEnabled) {
                View childAt = getChildAt(0);
                int left = childAt.getLeft();
                int width = childAt.getWidth();
                if (width > 0) {
                    return Math.max(((i2 * 100) - ((left * 100) / width)) + ((int) ((getScrollX() / getWidth()) * this.mItemCount * 100.0f)), 0);
                }
            } else {
                int i4 = this.mItemCount;
                if (i2 != 0) {
                    i3 = i2 + childCount == i4 ? i4 : (childCount / 2) + i2;
                }
                return (int) (i2 + (childCount * (i3 / i4)));
            }
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        if (this.mSmoothScrollbarEnabled) {
            int max = Math.max(this.mItemCount * 100, 0);
            return getScrollX() != 0 ? max + Math.abs((int) ((getScrollX() / getWidth()) * this.mItemCount * 100.0f)) : max;
        }
        return this.mItemCount;
    }

    public void confirmCheckedPositionsById() {
        Object obj;
        boolean z;
        Object obj2;
        Object obj3;
        this.mCheckStates.clear();
        int i2 = 0;
        boolean z2 = false;
        while (i2 < this.mCheckedIdStates.size()) {
            long keyAt = this.mCheckedIdStates.keyAt(i2);
            int intValue = this.mCheckedIdStates.valueAt(i2).intValue();
            if (keyAt != this.mAdapter.getItemId(intValue)) {
                int max = Math.max(0, intValue - 20);
                int min = Math.min(intValue + 20, this.mItemCount);
                while (true) {
                    if (max >= min) {
                        z = false;
                        break;
                    } else if (keyAt == this.mAdapter.getItemId(max)) {
                        this.mCheckStates.put(max, Boolean.TRUE);
                        this.mCheckedIdStates.setValueAt(i2, Integer.valueOf(max));
                        z = true;
                        break;
                    } else {
                        max++;
                    }
                }
                if (!z) {
                    this.mCheckedIdStates.delete(keyAt);
                    i2--;
                    this.mCheckedItemCount--;
                    if (Build.VERSION.SDK_INT > 11 && (obj2 = this.mChoiceActionMode) != null && (obj3 = this.mMultiChoiceModeCallback) != null) {
                        ((d.b.i0.a1.a.c.b) obj3).a((ActionMode) obj2, intValue, keyAt, false);
                    }
                    z2 = true;
                }
            } else {
                this.mCheckStates.put(intValue, Boolean.TRUE);
            }
            i2++;
        }
        if (!z2 || (obj = this.mChoiceActionMode) == null || Build.VERSION.SDK_INT <= 11) {
            return;
        }
        ((ActionMode) obj).invalidate();
    }

    public ContextMenu.ContextMenuInfo createContextMenuInfo(View view, int i2, long j2) {
        return new AdapterView.b(view, i2, j2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        boolean z = this.mDrawSelectorOnTop;
        if (!z) {
            drawSelector(canvas);
        }
        super.dispatchDraw(canvas);
        if (z) {
            drawSelector(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSetPressed(boolean z) {
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.mEdgeGlowTop != null) {
            int scrollX = getScrollX();
            if (!this.mEdgeGlowTop.isFinished()) {
                int save = canvas.save();
                Rect rect = this.mListPadding;
                int i2 = rect.top + this.mGlowPaddingTop;
                int height = (getHeight() - i2) - (rect.bottom + this.mGlowPaddingBottom);
                int min = Math.min(0, this.mFirstPositionDistanceGuess + scrollX);
                canvas.rotate(-90.0f);
                canvas.translate((-getHeight()) + i2, min);
                this.mEdgeGlowTop.setSize(height, height);
                if (this.mEdgeGlowTop.draw(canvas)) {
                    invalidate();
                }
                if (save >= 1 && save <= canvas.getSaveCount()) {
                    canvas.restoreToCount(save);
                }
            }
            if (this.mEdgeGlowBottom.isFinished()) {
                return;
            }
            int save2 = canvas.save();
            Rect rect2 = this.mListPadding;
            int i3 = rect2.left + this.mGlowPaddingTop;
            int height2 = (getHeight() - i3) - (rect2.right + this.mGlowPaddingBottom);
            int max = Math.max(getWidth(), scrollX + this.mLastPositionDistanceGuess);
            canvas.rotate(90.0f);
            canvas.translate(-i3, -max);
            this.mEdgeGlowBottom.setSize(height2, height2);
            if (this.mEdgeGlowBottom.draw(canvas)) {
                invalidate();
            }
            if (save2 < 1 || save2 > canvas.getSaveCount()) {
                return;
            }
            canvas.restoreToCount(save2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        updateSelectorState();
    }

    public abstract void fillGap(boolean z);

    public int findClosestMotionCol(int i2) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return -1;
        }
        int findMotionCol = findMotionCol(i2);
        return findMotionCol != -1 ? findMotionCol : (this.mFirstPosition + childCount) - 1;
    }

    public abstract int findMotionCol(int i2);

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -1, 0);
    }

    @ViewDebug.ExportedProperty(category = "drawing")
    public int getCacheColorHint() {
        return this.mCacheColorHint;
    }

    public int getCheckedItemCount() {
        return this.mCheckedItemCount;
    }

    public long[] getCheckedItemIds() {
        LongSparseArray<Integer> longSparseArray;
        if (this.mChoiceMode == 0 || (longSparseArray = this.mCheckedIdStates) == null || this.mAdapter == null) {
            return new long[0];
        }
        int size = longSparseArray.size();
        long[] jArr = new long[size];
        for (int i2 = 0; i2 < size; i2++) {
            jArr[i2] = longSparseArray.keyAt(i2);
        }
        return jArr;
    }

    public int getCheckedItemPosition() {
        SparseArrayCompat<Boolean> sparseArrayCompat;
        if (this.mChoiceMode == 1 && (sparseArrayCompat = this.mCheckStates) != null && sparseArrayCompat.size() == 1) {
            return this.mCheckStates.keyAt(0);
        }
        return -1;
    }

    public SparseArrayCompat<Boolean> getCheckedItemPositions() {
        if (this.mChoiceMode != 0) {
            return this.mCheckStates;
        }
        return null;
    }

    public int getChoiceMode() {
        return this.mChoiceMode;
    }

    @Override // android.view.View
    public ContextMenu.ContextMenuInfo getContextMenuInfo() {
        return this.mContextMenuInfo;
    }

    @Override // android.view.View
    public void getFocusedRect(Rect rect) {
        View selectedView = getSelectedView();
        if (selectedView != null && selectedView.getParent() == this) {
            selectedView.getFocusedRect(rect);
            offsetDescendantRectToMyCoords(selectedView, rect);
            return;
        }
        super.getFocusedRect(rect);
    }

    public int getFooterViewsCount() {
        return 0;
    }

    public int getHeaderViewsCount() {
        return 0;
    }

    public float getHorizontalScrollFactor() {
        if (this.mHorizontalScrollFactor == 0.0f) {
            TypedValue typedValue = new TypedValue();
            if (getContext().getTheme().resolveAttribute(R.attr.hlv_listPreferredItemWidth, typedValue, true)) {
                this.mHorizontalScrollFactor = typedValue.getDimension(getContext().getResources().getDisplayMetrics());
            }
        }
        return this.mHorizontalScrollFactor;
    }

    @Override // android.view.View
    public int getHorizontalScrollbarHeight() {
        return super.getHorizontalScrollbarHeight();
    }

    @Override // android.view.View
    public float getLeftFadingEdgeStrength() {
        int childCount = getChildCount();
        float leftFadingEdgeStrength = super.getLeftFadingEdgeStrength();
        if (childCount == 0) {
            return leftFadingEdgeStrength;
        }
        if (this.mFirstPosition > 0) {
            return 1.0f;
        }
        int left = getChildAt(0).getLeft();
        return left < getPaddingLeft() ? (-(left - getPaddingLeft())) / getHorizontalFadingEdgeLength() : leftFadingEdgeStrength;
    }

    public int getListPaddingBottom() {
        return this.mListPadding.bottom;
    }

    public int getListPaddingLeft() {
        return this.mListPadding.left;
    }

    public int getListPaddingRight() {
        return this.mListPadding.right;
    }

    public int getListPaddingTop() {
        return this.mListPadding.top;
    }

    @Override // android.view.View
    public float getRightFadingEdgeStrength() {
        int childCount = getChildCount();
        float rightFadingEdgeStrength = super.getRightFadingEdgeStrength();
        if (childCount == 0) {
            return rightFadingEdgeStrength;
        }
        if ((this.mFirstPosition + childCount) - 1 < this.mItemCount - 1) {
            return 1.0f;
        }
        int right = getChildAt(childCount - 1).getRight();
        int width = getWidth();
        return right > width - getPaddingRight() ? ((right - width) + getPaddingRight()) / getHorizontalFadingEdgeLength() : rightFadingEdgeStrength;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AdapterView
    @ViewDebug.ExportedProperty
    public View getSelectedView() {
        int i2;
        if (this.mItemCount <= 0 || (i2 = this.mSelectedPosition) < 0) {
            return null;
        }
        return getChildAt(i2 - this.mFirstPosition);
    }

    public Drawable getSelector() {
        return this.mSelector;
    }

    @Override // android.view.View
    public int getSolidColor() {
        return this.mCacheColorHint;
    }

    public int getTranscriptMode() {
        return this.mTranscriptMode;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AdapterView
    public void handleDataChanged() {
        ListAdapter listAdapter;
        int i2 = this.mItemCount;
        int i3 = this.mLastHandledItemCount;
        this.mLastHandledItemCount = i2;
        if (this.mChoiceMode != 0 && (listAdapter = this.mAdapter) != null && listAdapter.hasStableIds()) {
            confirmCheckedPositionsById();
        }
        this.mRecycler.e();
        if (i2 > 0) {
            if (this.mNeedSync) {
                this.mNeedSync = false;
                this.mPendingSync = null;
                int i4 = this.mTranscriptMode;
                if (i4 == 2) {
                    this.mLayoutMode = 3;
                    return;
                }
                if (i4 == 1) {
                    if (this.mForceTranscriptScroll) {
                        this.mForceTranscriptScroll = false;
                        this.mLayoutMode = 3;
                        return;
                    }
                    int childCount = getChildCount();
                    int width = getWidth() - getPaddingRight();
                    View childAt = getChildAt(childCount - 1);
                    int bottom = childAt != null ? childAt.getBottom() : width;
                    if (this.mFirstPosition + childCount >= i3 && bottom <= width) {
                        this.mLayoutMode = 3;
                        return;
                    }
                    awakenScrollBars();
                }
                int i5 = this.mSyncMode;
                if (i5 != 0) {
                    if (i5 == 1) {
                        this.mLayoutMode = 5;
                        this.mSyncPosition = Math.min(Math.max(0, this.mSyncPosition), i2 - 1);
                        return;
                    }
                } else if (isInTouchMode()) {
                    this.mLayoutMode = 5;
                    this.mSyncPosition = Math.min(Math.max(0, this.mSyncPosition), i2 - 1);
                    return;
                } else {
                    int findSyncPosition = findSyncPosition();
                    if (findSyncPosition >= 0 && lookForSelectablePosition(findSyncPosition, true) == findSyncPosition) {
                        this.mSyncPosition = findSyncPosition;
                        if (this.mSyncWidth == getWidth()) {
                            this.mLayoutMode = 5;
                        } else {
                            this.mLayoutMode = 2;
                        }
                        setNextSelectedPositionInt(findSyncPosition);
                        return;
                    }
                }
            }
            if (!isInTouchMode()) {
                int selectedItemPosition = getSelectedItemPosition();
                if (selectedItemPosition >= i2) {
                    selectedItemPosition = i2 - 1;
                }
                if (selectedItemPosition < 0) {
                    selectedItemPosition = 0;
                }
                int lookForSelectablePosition = lookForSelectablePosition(selectedItemPosition, true);
                if (lookForSelectablePosition >= 0) {
                    setNextSelectedPositionInt(lookForSelectablePosition);
                    return;
                }
                int lookForSelectablePosition2 = lookForSelectablePosition(selectedItemPosition, false);
                if (lookForSelectablePosition2 >= 0) {
                    setNextSelectedPositionInt(lookForSelectablePosition2);
                    return;
                }
            } else if (this.mResurrectToPosition >= 0) {
                return;
            }
        }
        this.mLayoutMode = this.mStackFromRight ? 3 : 1;
        this.mSelectedPosition = -1;
        this.mSelectedColId = Long.MIN_VALUE;
        this.mNextSelectedPosition = -1;
        this.mNextSelectedColId = Long.MIN_VALUE;
        this.mNeedSync = false;
        this.mPendingSync = null;
        this.mSelectorPosition = -1;
        checkSelectionChanged();
    }

    public void hideSelector() {
        int i2 = this.mSelectedPosition;
        if (i2 != -1) {
            if (this.mLayoutMode != 4) {
                this.mResurrectToPosition = i2;
            }
            int i3 = this.mNextSelectedPosition;
            if (i3 >= 0 && i3 != this.mSelectedPosition) {
                this.mResurrectToPosition = i3;
            }
            setSelectedPositionInt(-1);
            setNextSelectedPositionInt(-1);
            this.mSelectedLeft = 0;
        }
    }

    @TargetApi(11)
    public void invalidateParentIfNeeded() {
        if (this.mViewHelper.a() && (getParent() instanceof View)) {
            ((View) getParent()).invalidate();
        }
    }

    public void invalidateViews() {
        this.mDataChanged = true;
        rememberSyncState();
        requestLayout();
        invalidate();
    }

    public void invokeOnItemScrollListener() {
        i iVar = this.mOnScrollListener;
        if (iVar != null) {
            iVar.a(this, this.mFirstPosition, getChildCount(), this.mItemCount);
        }
        onScrollChanged(0, 0, 0, 0);
    }

    public boolean isItemChecked(int i2) {
        SparseArrayCompat<Boolean> sparseArrayCompat;
        if (this.mChoiceMode == 0 || (sparseArrayCompat = this.mCheckStates) == null) {
            return false;
        }
        return sparseArrayCompat.get(i2, Boolean.FALSE).booleanValue();
    }

    @ViewDebug.ExportedProperty
    public boolean isScrollingCacheEnabled() {
        return this.mScrollingCacheEnabled;
    }

    @ViewDebug.ExportedProperty
    public boolean isSmoothScrollbarEnabled() {
        return this.mSmoothScrollbarEnabled;
    }

    public boolean isStackFromRight() {
        return this.mStackFromRight;
    }

    @Override // android.view.ViewGroup, android.view.View
    @TargetApi(11)
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.mSelector;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    public void keyPressed() {
        if (isEnabled() && isClickable()) {
            Drawable drawable = this.mSelector;
            Rect rect = this.mSelectorRect;
            if (drawable != null) {
                if ((isFocused() || touchModeDrawsInPressedState()) && !rect.isEmpty()) {
                    View childAt = getChildAt(this.mSelectedPosition - this.mFirstPosition);
                    if (childAt != null) {
                        if (childAt.hasFocusable()) {
                            return;
                        }
                        childAt.setPressed(true);
                    }
                    setPressed(true);
                    boolean isLongClickable = isLongClickable();
                    Drawable current = drawable.getCurrent();
                    if (current != null && (current instanceof TransitionDrawable)) {
                        if (isLongClickable) {
                            ((TransitionDrawable) current).startTransition(ViewConfiguration.getLongPressTimeout());
                        } else {
                            ((TransitionDrawable) current).resetTransition();
                        }
                    }
                    if (!isLongClickable || this.mDataChanged) {
                        return;
                    }
                    if (this.mPendingCheckForKeyLongPress == null) {
                        this.mPendingCheckForKeyLongPress = new d(this, null);
                    }
                    this.mPendingCheckForKeyLongPress.a();
                    postDelayed(this.mPendingCheckForKeyLongPress, ViewConfiguration.getLongPressTimeout());
                }
            }
        }
    }

    public void layoutChildren() {
    }

    @SuppressLint({"NewApi"})
    public View obtainView(int i2, boolean[] zArr) {
        View view;
        LayoutParams layoutParams;
        zArr[0] = false;
        View i3 = this.mRecycler.i(i2);
        if (i3 != null) {
            return i3;
        }
        View h2 = this.mRecycler.h(i2);
        if (h2 != null) {
            view = this.mAdapter.getView(i2, h2, this);
            if (view != h2) {
                this.mRecycler.c(h2, i2);
                int i4 = this.mCacheColorHint;
                if (i4 != 0) {
                    view.setDrawingCacheBackgroundColor(i4);
                }
            } else {
                zArr[0] = true;
                view.onFinishTemporaryDetach();
            }
        } else {
            view = this.mAdapter.getView(i2, null, this);
            int i5 = this.mCacheColorHint;
            if (i5 != 0) {
                view.setDrawingCacheBackgroundColor(i5);
            }
        }
        if (this.mAdapterHasStableIds) {
            ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams = (LayoutParams) generateDefaultLayoutParams();
            } else if (!checkLayoutParams(layoutParams2)) {
                layoutParams = (LayoutParams) generateLayoutParams(layoutParams2);
            } else {
                layoutParams = (LayoutParams) layoutParams2;
            }
            layoutParams.f17451e = this.mAdapter.getItemId(i2);
            view.setLayoutParams(layoutParams);
        }
        if (this.mAccessibilityManager.isEnabled() && this.mAccessibilityDelegate == null) {
            this.mAccessibilityDelegate = new h();
        }
        return view;
    }

    public void offsetChildrenLeftAndRight(int i2) {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            getChildAt(i3).offsetLeftAndRight(i2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnTouchModeChangeListener(this);
        if (this.mAdapter != null && this.mDataSetObserver == null) {
            c cVar = new c();
            this.mDataSetObserver = cVar;
            this.mAdapter.registerDataSetObserver(cVar);
            this.mDataChanged = true;
            this.mOldItemCount = this.mItemCount;
            this.mItemCount = this.mAdapter.getCount();
        }
        this.mIsAttached = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    @SuppressLint({"Override"})
    public int[] onCreateDrawableState(int i2) {
        if (this.mIsChildViewEnabled) {
            return super.onCreateDrawableState(i2);
        }
        int i3 = ViewGroup.ENABLED_STATE_SET[0];
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 1);
        int length = onCreateDrawableState.length - 1;
        while (true) {
            if (length < 0) {
                length = -1;
                break;
            } else if (onCreateDrawableState[length] == i3) {
                break;
            } else {
                length--;
            }
        }
        if (length >= 0) {
            System.arraycopy(onCreateDrawableState, length + 1, onCreateDrawableState, length, (onCreateDrawableState.length - length) - 1);
        }
        return onCreateDrawableState;
    }

    @Override // android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return null;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        c cVar;
        super.onDetachedFromWindow();
        this.mRecycler.d();
        getViewTreeObserver().removeOnTouchModeChangeListener(this);
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter != null && (cVar = this.mDataSetObserver) != null) {
            listAdapter.unregisterDataSetObserver(cVar);
            this.mDataSetObserver = null;
        }
        g gVar = this.mFlingRunnable;
        if (gVar != null) {
            removeCallbacks(gVar);
        }
        k kVar = this.mPositionScroller;
        if (kVar != null) {
            kVar.f();
        }
        Runnable runnable = this.mClearScrollingCache;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        j jVar = this.mPerformClick;
        if (jVar != null) {
            removeCallbacks(jVar);
        }
        Runnable runnable2 = this.mTouchModeReset;
        if (runnable2 != null) {
            removeCallbacks(runnable2);
            this.mTouchModeReset = null;
        }
        this.mIsAttached = false;
    }

    @Override // android.view.View
    public void onFocusChanged(boolean z, int i2, Rect rect) {
        ListAdapter listAdapter;
        super.onFocusChanged(z, i2, rect);
        if (!z || this.mSelectedPosition >= 0 || isInTouchMode()) {
            return;
        }
        if (!this.mIsAttached && (listAdapter = this.mAdapter) != null) {
            this.mDataChanged = true;
            this.mOldItemCount = this.mItemCount;
            this.mItemCount = listAdapter.getCount();
        }
        resurrectSelection();
    }

    @Override // android.view.View
    @TargetApi(12)
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) != 0 && motionEvent.getAction() == 8 && this.mTouchMode == -1) {
            float axisValue = motionEvent.getAxisValue(10);
            if (axisValue != 0.0f) {
                int horizontalScrollFactor = (int) (axisValue * getHorizontalScrollFactor());
                if (!trackMotionScroll(horizontalScrollFactor, horizontalScrollFactor)) {
                    return true;
                }
            }
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AdapterView, android.view.View
    @TargetApi(14)
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(AbsHListView.class.getName());
    }

    @Override // com.baidu.tieba.horizonalList.widget.AdapterView, android.view.View
    @SuppressLint({"Override"})
    @TargetApi(14)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(AbsHListView.class.getName());
        if (isEnabled()) {
            if (getFirstVisiblePosition() > 0) {
                accessibilityNodeInfo.addAction(8192);
            }
            if (getLastVisiblePosition() < getCount() - 1) {
                accessibilityNodeInfo.addAction(4096);
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        k kVar = this.mPositionScroller;
        if (kVar != null) {
            kVar.f();
        }
        if (this.mIsAttached) {
            int i2 = action & 255;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            if (i2 == 6) {
                                onSecondaryPointerUp(motionEvent);
                            }
                        }
                    } else if (this.mTouchMode == 0) {
                        int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                        if (findPointerIndex == -1) {
                            this.mActivePointerId = motionEvent.getPointerId(0);
                            findPointerIndex = 0;
                        }
                        initVelocityTrackerIfNotExists();
                        this.mVelocityTracker.addMovement(motionEvent);
                        if (startScrollIfNeeded((int) motionEvent.getX(findPointerIndex))) {
                            return true;
                        }
                    }
                }
                this.mTouchMode = -1;
                this.mActivePointerId = -1;
                recycleVelocityTracker();
                reportScrollStateChange(0);
            } else {
                int i3 = this.mTouchMode;
                if (i3 != 6 && i3 != 5) {
                    int x = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();
                    this.mActivePointerId = motionEvent.getPointerId(0);
                    int findMotionCol = findMotionCol(x);
                    if (i3 != 4 && findMotionCol >= 0) {
                        this.mMotionViewOriginalLeft = getChildAt(findMotionCol - this.mFirstPosition).getLeft();
                        this.mMotionX = x;
                        this.mMotionY = y;
                        this.mMotionPosition = findMotionCol;
                        this.mTouchMode = 0;
                        clearScrollingCache();
                    }
                    this.mLastX = Integer.MIN_VALUE;
                    initOrResetVelocityTracker();
                    this.mVelocityTracker.addMovement(motionEvent);
                    if (i3 == 4) {
                        return true;
                    }
                } else {
                    this.mMotionCorrection = 0;
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        return false;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        int i3;
        ListAdapter listAdapter;
        if (i2 == 23 || i2 == 66) {
            if (!isEnabled()) {
                return true;
            }
            if (isClickable() && isPressed() && (i3 = this.mSelectedPosition) >= 0 && (listAdapter = this.mAdapter) != null && i3 < listAdapter.getCount()) {
                View childAt = getChildAt(this.mSelectedPosition - this.mFirstPosition);
                if (childAt != null) {
                    performItemClick(childAt, this.mSelectedPosition, this.mSelectedColId);
                    childAt.setPressed(false);
                }
                setPressed(false);
                return true;
            }
        }
        return super.onKeyUp(i2, keyEvent);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        this.mInLayout = true;
        if (z) {
            int childCount = getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                getChildAt(i6).forceLayout();
            }
            this.mRecycler.j();
        }
        layoutChildren();
        this.mInLayout = false;
        this.mOverscrollMax = (i4 - i2) / 3;
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.mSelector == null) {
            useDefaultSelector();
        }
        Rect rect = this.mListPadding;
        rect.left = this.mSelectionLeftPadding + getPaddingLeft();
        rect.top = this.mSelectionTopPadding + getPaddingTop();
        rect.right = this.mSelectionRightPadding + getPaddingRight();
        rect.bottom = this.mSelectionBottomPadding + getPaddingBottom();
        boolean z = true;
        if (this.mTranscriptMode == 1) {
            int childCount = getChildCount();
            int width = getWidth() - getPaddingRight();
            View childAt = getChildAt(childCount - 1);
            this.mForceTranscriptScroll = (this.mFirstPosition + childCount < this.mLastHandledItemCount || (childAt != null ? childAt.getRight() : width) > width) ? false : false;
        }
    }

    @Override // android.view.View
    public void onOverScrolled(int i2, int i3, boolean z, boolean z2) {
        if (getScrollX() != i2) {
            onScrollChanged(i2, getScrollY(), getScrollX(), getScrollY());
            this.mViewHelper.c(i2);
            invalidateParentIfNeeded();
            awakenScrollBars();
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Object obj;
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mDataChanged = true;
        this.mSyncWidth = savedState.i;
        long j2 = savedState.f17452e;
        if (j2 >= 0) {
            this.mNeedSync = true;
            this.mPendingSync = savedState;
            this.mSyncColId = j2;
            this.mSyncPosition = savedState.f17455h;
            this.mSpecificLeft = savedState.f17454g;
            this.mSyncMode = 0;
        } else if (savedState.f17453f >= 0) {
            setSelectedPositionInt(-1);
            setNextSelectedPositionInt(-1);
            this.mSelectorPosition = -1;
            this.mNeedSync = true;
            this.mPendingSync = savedState;
            this.mSyncColId = savedState.f17453f;
            this.mSyncPosition = savedState.f17455h;
            this.mSpecificLeft = savedState.f17454g;
            this.mSyncMode = 1;
        }
        SparseArrayCompat<Boolean> sparseArrayCompat = savedState.m;
        if (sparseArrayCompat != null) {
            this.mCheckStates = sparseArrayCompat;
        }
        LongSparseArray<Integer> longSparseArray = savedState.n;
        if (longSparseArray != null) {
            this.mCheckedIdStates = longSparseArray;
        }
        this.mCheckedItemCount = savedState.l;
        if (Build.VERSION.SDK_INT >= 11 && savedState.k && this.mChoiceMode == 3 && (obj = this.mMultiChoiceModeCallback) != null) {
            this.mChoiceActionMode = startActionMode((d.b.i0.a1.a.c.b) obj);
        }
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SavedState savedState2 = this.mPendingSync;
        if (savedState2 != null) {
            savedState.f17452e = savedState2.f17452e;
            savedState.f17453f = savedState2.f17453f;
            savedState.f17454g = savedState2.f17454g;
            savedState.f17455h = savedState2.f17455h;
            savedState.i = savedState2.i;
            savedState.j = savedState2.j;
            savedState.k = savedState2.k;
            savedState.l = savedState2.l;
            savedState.m = savedState2.m;
            savedState.n = savedState2.n;
            return savedState;
        }
        boolean z = true;
        boolean z2 = getChildCount() > 0 && this.mItemCount > 0;
        long selectedItemId = getSelectedItemId();
        savedState.f17452e = selectedItemId;
        savedState.i = getWidth();
        if (selectedItemId >= 0) {
            savedState.f17454g = this.mSelectedLeft;
            savedState.f17455h = getSelectedItemPosition();
            savedState.f17453f = -1L;
        } else if (z2 && this.mFirstPosition > 0) {
            savedState.f17454g = getChildAt(0).getLeft();
            int i2 = this.mFirstPosition;
            int i3 = this.mItemCount;
            if (i2 >= i3) {
                i2 = i3 - 1;
            }
            savedState.f17455h = i2;
            savedState.f17453f = this.mAdapter.getItemId(i2);
        } else {
            savedState.f17454g = 0;
            savedState.f17453f = -1L;
            savedState.f17455h = 0;
        }
        savedState.j = null;
        savedState.k = (Build.VERSION.SDK_INT < 11 || this.mChoiceMode != 3 || this.mChoiceActionMode == null) ? false : false;
        SparseArrayCompat<Boolean> sparseArrayCompat = this.mCheckStates;
        if (sparseArrayCompat != null) {
            try {
                savedState.m = sparseArrayCompat.m1clone();
            } catch (NoSuchMethodError e2) {
                e2.printStackTrace();
                savedState.m = new SparseArrayCompat<>();
            }
        }
        if (this.mCheckedIdStates != null) {
            LongSparseArray<Integer> longSparseArray = new LongSparseArray<>();
            int size = this.mCheckedIdStates.size();
            for (int i4 = 0; i4 < size; i4++) {
                longSparseArray.put(this.mCheckedIdStates.keyAt(i4), this.mCheckedIdStates.valueAt(i4));
            }
            savedState.n = longSparseArray;
        }
        savedState.l = this.mCheckedItemCount;
        return savedState;
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        if (getChildCount() > 0) {
            this.mDataChanged = true;
            rememberSyncState();
        }
    }

    @Override // android.view.View
    @SuppressLint({"Override"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        Drawable current;
        int i2 = 0;
        if (!isEnabled()) {
            return isClickable() || isLongClickable();
        }
        k kVar = this.mPositionScroller;
        if (kVar != null) {
            kVar.f();
        }
        if (this.mIsAttached) {
            int action = motionEvent.getAction();
            initVelocityTrackerIfNotExists();
            this.mVelocityTracker.addMovement(motionEvent);
            int i3 = action & 255;
            if (i3 == 0) {
                if (this.mTouchMode != 6) {
                    this.mActivePointerId = motionEvent.getPointerId(0);
                    int x = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();
                    int pointToPosition = pointToPosition(x, y);
                    if (!this.mDataChanged) {
                        if (this.mTouchMode != 4 && pointToPosition >= 0 && getAdapter().isEnabled(pointToPosition)) {
                            this.mTouchMode = 0;
                            if (this.mPendingCheckForTap == null) {
                                this.mPendingCheckForTap = new f();
                            }
                            postDelayed(this.mPendingCheckForTap, ViewConfiguration.getTapTimeout());
                        } else if (this.mTouchMode == 4) {
                            createScrollingCache();
                            this.mTouchMode = 3;
                            this.mMotionCorrection = 0;
                            pointToPosition = findMotionCol(x);
                            this.mFlingRunnable.d();
                        }
                    }
                    if (pointToPosition >= 0) {
                        this.mMotionViewOriginalLeft = getChildAt(pointToPosition - this.mFirstPosition).getLeft();
                    }
                    this.mMotionX = x;
                    this.mMotionY = y;
                    this.mMotionPosition = pointToPosition;
                    this.mLastX = Integer.MIN_VALUE;
                } else {
                    this.mFlingRunnable.c();
                    k kVar2 = this.mPositionScroller;
                    if (kVar2 != null) {
                        kVar2.f();
                    }
                    this.mTouchMode = 5;
                    this.mMotionY = (int) motionEvent.getY();
                    int x2 = (int) motionEvent.getX();
                    this.mLastX = x2;
                    this.mMotionX = x2;
                    this.mMotionCorrection = 0;
                    this.mActivePointerId = motionEvent.getPointerId(0);
                    this.mDirection = 0;
                }
                if (performButtonActionOnTouchDown(motionEvent) && this.mTouchMode == 0) {
                    removeCallbacks(this.mPendingCheckForTap);
                }
            } else if (i3 == 1) {
                int i4 = this.mTouchMode;
                if (i4 == 0 || i4 == 1 || i4 == 2) {
                    int i5 = this.mMotionPosition;
                    View childAt = getChildAt(i5 - this.mFirstPosition);
                    float x3 = motionEvent.getX();
                    boolean z = x3 > ((float) this.mListPadding.left) && x3 < ((float) (getWidth() - this.mListPadding.right));
                    if (childAt != null && !childAt.hasFocusable() && z) {
                        if (this.mTouchMode != 0) {
                            childAt.setPressed(false);
                        }
                        if (this.mPerformClick == null) {
                            this.mPerformClick = new j(this, null);
                        }
                        j jVar = this.mPerformClick;
                        jVar.f17470g = i5;
                        jVar.a();
                        this.mResurrectToPosition = i5;
                        int i6 = this.mTouchMode;
                        if (i6 != 0 && i6 != 1) {
                            if (!this.mDataChanged && this.mAdapter.isEnabled(i5)) {
                                jVar.run();
                            }
                        } else {
                            Handler handler = getHandler();
                            if (handler != null) {
                                handler.removeCallbacks(this.mTouchMode == 0 ? this.mPendingCheckForTap : this.mPendingCheckForLongPress);
                            }
                            this.mLayoutMode = 0;
                            if (!this.mDataChanged && this.mAdapter.isEnabled(i5)) {
                                this.mTouchMode = 1;
                                setSelectedPositionInt(this.mMotionPosition);
                                layoutChildren();
                                childAt.setPressed(true);
                                positionSelector(this.mMotionPosition, childAt);
                                setPressed(true);
                                Drawable drawable = this.mSelector;
                                if (drawable != null && (current = drawable.getCurrent()) != null && (current instanceof TransitionDrawable)) {
                                    ((TransitionDrawable) current).resetTransition();
                                }
                                Runnable runnable = this.mTouchModeReset;
                                if (runnable != null) {
                                    removeCallbacks(runnable);
                                }
                                a aVar = new a(childAt, jVar);
                                this.mTouchModeReset = aVar;
                                postDelayed(aVar, ViewConfiguration.getPressedStateDuration());
                            } else {
                                this.mTouchMode = -1;
                                updateSelectorState();
                            }
                            return true;
                        }
                    }
                    this.mTouchMode = -1;
                    updateSelectorState();
                } else if (i4 == 3) {
                    int childCount = getChildCount();
                    if (childCount > 0) {
                        int left = getChildAt(0).getLeft();
                        int right = getChildAt(childCount - 1).getRight();
                        int i7 = this.mListPadding.left;
                        int width = getWidth() - this.mListPadding.right;
                        int i8 = this.mFirstPosition;
                        if (i8 == 0 && left >= i7 && i8 + childCount < this.mItemCount && right <= getWidth() - width) {
                            this.mTouchMode = -1;
                            reportScrollStateChange(0);
                        } else {
                            VelocityTracker velocityTracker = this.mVelocityTracker;
                            velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                            int xVelocity = (int) (velocityTracker.getXVelocity(this.mActivePointerId) * this.mVelocityScale);
                            if (Math.abs(xVelocity) > this.mMinimumVelocity && ((this.mFirstPosition != 0 || left != i7 - this.mOverscrollDistance) && (this.mFirstPosition + childCount != this.mItemCount || right != width + this.mOverscrollDistance))) {
                                if (this.mFlingRunnable == null) {
                                    this.mFlingRunnable = new g();
                                }
                                reportScrollStateChange(2);
                                this.mFlingRunnable.e(-xVelocity);
                            } else {
                                this.mTouchMode = -1;
                                reportScrollStateChange(0);
                                g gVar = this.mFlingRunnable;
                                if (gVar != null) {
                                    gVar.c();
                                }
                                k kVar3 = this.mPositionScroller;
                                if (kVar3 != null) {
                                    kVar3.f();
                                }
                            }
                        }
                    } else {
                        this.mTouchMode = -1;
                        reportScrollStateChange(0);
                    }
                } else if (i4 == 5) {
                    if (this.mFlingRunnable == null) {
                        this.mFlingRunnable = new g();
                    }
                    VelocityTracker velocityTracker2 = this.mVelocityTracker;
                    velocityTracker2.computeCurrentVelocity(1000, this.mMaximumVelocity);
                    int xVelocity2 = (int) velocityTracker2.getXVelocity(this.mActivePointerId);
                    reportScrollStateChange(2);
                    if (Math.abs(xVelocity2) > this.mMinimumVelocity) {
                        this.mFlingRunnable.f(-xVelocity2);
                    } else {
                        this.mFlingRunnable.h();
                    }
                }
                setPressed(false);
                EdgeEffectCompat edgeEffectCompat = this.mEdgeGlowTop;
                if (edgeEffectCompat != null) {
                    edgeEffectCompat.onRelease();
                    this.mEdgeGlowBottom.onRelease();
                }
                invalidate();
                Handler handler2 = getHandler();
                if (handler2 != null) {
                    handler2.removeCallbacks(this.mPendingCheckForLongPress);
                }
                recycleVelocityTracker();
                this.mActivePointerId = -1;
            } else if (i3 == 2) {
                int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                if (findPointerIndex == -1) {
                    this.mActivePointerId = motionEvent.getPointerId(0);
                } else {
                    i2 = findPointerIndex;
                }
                int x4 = (int) motionEvent.getX(i2);
                if (this.mDataChanged) {
                    layoutChildren();
                }
                int i9 = this.mTouchMode;
                if (i9 == 0 || i9 == 1 || i9 == 2) {
                    startScrollIfNeeded(x4);
                } else if (i9 == 3 || i9 == 5) {
                    scrollIfNeeded(x4);
                }
            } else if (i3 == 3) {
                int i10 = this.mTouchMode;
                if (i10 == 5) {
                    if (this.mFlingRunnable == null) {
                        this.mFlingRunnable = new g();
                    }
                    this.mFlingRunnable.h();
                } else if (i10 != 6) {
                    this.mTouchMode = -1;
                    setPressed(false);
                    View childAt2 = getChildAt(this.mMotionPosition - this.mFirstPosition);
                    if (childAt2 != null) {
                        childAt2.setPressed(false);
                    }
                    clearScrollingCache();
                    Handler handler3 = getHandler();
                    if (handler3 != null) {
                        handler3.removeCallbacks(this.mPendingCheckForLongPress);
                    }
                    recycleVelocityTracker();
                }
                EdgeEffectCompat edgeEffectCompat2 = this.mEdgeGlowTop;
                if (edgeEffectCompat2 != null) {
                    edgeEffectCompat2.onRelease();
                    this.mEdgeGlowBottom.onRelease();
                }
                this.mActivePointerId = -1;
            } else if (i3 == 5) {
                int actionIndex = motionEvent.getActionIndex();
                int pointerId = motionEvent.getPointerId(actionIndex);
                int x5 = (int) motionEvent.getX(actionIndex);
                int y2 = (int) motionEvent.getY(actionIndex);
                this.mMotionCorrection = 0;
                this.mActivePointerId = pointerId;
                this.mMotionX = x5;
                this.mMotionY = y2;
                int pointToPosition2 = pointToPosition(x5, y2);
                if (pointToPosition2 >= 0) {
                    this.mMotionViewOriginalLeft = getChildAt(pointToPosition2 - this.mFirstPosition).getLeft();
                    this.mMotionPosition = pointToPosition2;
                }
                this.mLastX = x5;
            } else if (i3 == 6) {
                onSecondaryPointerUp(motionEvent);
                int i11 = this.mMotionX;
                int pointToPosition3 = pointToPosition(i11, this.mMotionY);
                if (pointToPosition3 >= 0) {
                    this.mMotionViewOriginalLeft = getChildAt(pointToPosition3 - this.mFirstPosition).getLeft();
                    this.mMotionPosition = pointToPosition3;
                }
                this.mLastX = i11;
            }
            return true;
        }
        return false;
    }

    @Override // android.view.ViewTreeObserver.OnTouchModeChangeListener
    public void onTouchModeChanged(boolean z) {
        if (z) {
            hideSelector();
            if (getWidth() > 0 && getChildCount() > 0) {
                layoutChildren();
            }
            updateSelectorState();
            return;
        }
        int i2 = this.mTouchMode;
        if (i2 == 5 || i2 == 6) {
            g gVar = this.mFlingRunnable;
            if (gVar != null) {
                gVar.c();
            }
            k kVar = this.mPositionScroller;
            if (kVar != null) {
                kVar.f();
            }
            if (getScrollX() != 0) {
                this.mViewHelper.c(0);
                finishGlows();
                invalidate();
            }
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        int i2 = !isInTouchMode();
        if (!z) {
            setChildrenDrawingCacheEnabled(false);
            g gVar = this.mFlingRunnable;
            if (gVar != null) {
                removeCallbacks(gVar);
                this.mFlingRunnable.c();
                k kVar = this.mPositionScroller;
                if (kVar != null) {
                    kVar.f();
                }
                if (getScrollX() != 0) {
                    this.mViewHelper.c(0);
                    finishGlows();
                    invalidate();
                }
            }
            if (i2 == 1) {
                this.mResurrectToPosition = this.mSelectedPosition;
            }
        } else {
            int i3 = this.mLastTouchMode;
            if (i2 != i3 && i3 != -1) {
                if (i2 == 1) {
                    resurrectSelection();
                } else {
                    hideSelector();
                    this.mLayoutMode = 0;
                    layoutChildren();
                }
            }
        }
        this.mLastTouchMode = i2;
    }

    @TargetApi(14)
    public boolean performButtonActionOnTouchDown(MotionEvent motionEvent) {
        return Build.VERSION.SDK_INT >= 14 && (motionEvent.getButtonState() & 2) != 0 && showContextMenu(motionEvent.getX(), motionEvent.getY(), motionEvent.getMetaState());
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00dc  */
    @Override // com.baidu.tieba.horizonalList.widget.AdapterView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean performItemClick(View view, int i2, long j2) {
        boolean z;
        int i3 = this.mChoiceMode;
        boolean z2 = false;
        boolean z3 = true;
        if (i3 != 0) {
            if (i3 != 2 && (Build.VERSION.SDK_INT < 11 || i3 != 3 || this.mChoiceActionMode == null)) {
                if (this.mChoiceMode == 1) {
                    if (!this.mCheckStates.get(i2, Boolean.FALSE).booleanValue()) {
                        this.mCheckStates.clear();
                        this.mCheckStates.put(i2, Boolean.TRUE);
                        if (this.mCheckedIdStates != null && this.mAdapter.hasStableIds()) {
                            this.mCheckedIdStates.clear();
                            this.mCheckedIdStates.put(this.mAdapter.getItemId(i2), Integer.valueOf(i2));
                        }
                        this.mCheckedItemCount = 1;
                    } else if (this.mCheckStates.size() == 0 || !this.mCheckStates.valueAt(0).booleanValue()) {
                        this.mCheckedItemCount = 0;
                    }
                    z = true;
                } else {
                    z = true;
                    if (z2) {
                        updateOnScreenCheckedViews();
                    }
                    z3 = z;
                    z2 = true;
                }
            } else {
                boolean z4 = !this.mCheckStates.get(i2, Boolean.FALSE).booleanValue();
                this.mCheckStates.put(i2, Boolean.valueOf(z4));
                if (this.mCheckedIdStates != null && this.mAdapter.hasStableIds()) {
                    if (z4) {
                        this.mCheckedIdStates.put(this.mAdapter.getItemId(i2), Integer.valueOf(i2));
                    } else {
                        this.mCheckedIdStates.delete(this.mAdapter.getItemId(i2));
                    }
                }
                if (z4) {
                    this.mCheckedItemCount++;
                } else {
                    this.mCheckedItemCount--;
                }
                Object obj = this.mChoiceActionMode;
                if (obj != null) {
                    ((d.b.i0.a1.a.c.b) this.mMultiChoiceModeCallback).a((ActionMode) obj, i2, j2, z4);
                } else {
                    z2 = true;
                }
                z = z2;
            }
            z2 = true;
            if (z2) {
            }
            z3 = z;
            z2 = true;
        }
        return z3 ? z2 | super.performItemClick(view, i2, j2) : z2;
    }

    public boolean performLongPress(View view, int i2, long j2) {
        if (Build.VERSION.SDK_INT >= 11 && this.mChoiceMode == 3) {
            if (this.mChoiceActionMode == null) {
                ActionMode startActionMode = startActionMode((d.b.i0.a1.a.c.b) this.mMultiChoiceModeCallback);
                this.mChoiceActionMode = startActionMode;
                if (startActionMode != null) {
                    setItemChecked(i2, true);
                    performHapticFeedback(0);
                }
            }
            return true;
        }
        AdapterView.e eVar = this.mOnItemLongClickListener;
        boolean a2 = eVar != null ? eVar.a(this, view, i2, j2) : false;
        if (!a2) {
            this.mContextMenuInfo = createContextMenuInfo(view, i2, j2);
            a2 = super.showContextMenuForChild(this);
        }
        if (a2) {
            performHapticFeedback(0);
        }
        return a2;
    }

    public long pointToColId(int i2, int i3) {
        int pointToPosition = pointToPosition(i2, i3);
        if (pointToPosition >= 0) {
            return this.mAdapter.getItemId(pointToPosition);
        }
        return Long.MIN_VALUE;
    }

    public int pointToPosition(int i2, int i3) {
        Rect rect = this.mTouchFrame;
        if (rect == null) {
            rect = new Rect();
            this.mTouchFrame = rect;
        }
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt.getVisibility() == 0) {
                childAt.getHitRect(rect);
                if (rect.contains(i2, i3)) {
                    return this.mFirstPosition + childCount;
                }
            }
        }
        return -1;
    }

    public void positionSelector(int i2, View view) {
        if (i2 != -1) {
            this.mSelectorPosition = i2;
        }
        Rect rect = this.mSelectorRect;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        if (view instanceof n) {
            ((n) view).adjustListItemSelectionBounds(rect);
        }
        positionSelector(rect.left, rect.top, rect.right, rect.bottom);
        boolean z = this.mIsChildViewEnabled;
        if (view.isEnabled() != z) {
            this.mIsChildViewEnabled = !z;
            if (getSelectedItemPosition() != -1) {
                refreshDrawableState();
            }
        }
    }

    @SuppressLint({"NewApi"})
    public void reclaimViews(List<View> list) {
        int childCount = getChildCount();
        m mVar = this.mRecycler.f17483a;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (layoutParams != null && this.mRecycler.q(layoutParams.f17447a)) {
                list.add(childAt);
                if (Build.VERSION.SDK_INT >= 14) {
                    childAt.setAccessibilityDelegate(null);
                }
                if (mVar != null) {
                    mVar.onMovedToScrapHeap(childAt);
                }
            }
        }
        this.mRecycler.l(list);
        removeAllViewsInLayout();
    }

    public int reconcileSelectedPosition() {
        int i2 = this.mSelectedPosition;
        if (i2 < 0) {
            i2 = this.mResurrectToPosition;
        }
        return Math.min(Math.max(0, i2), this.mItemCount - 1);
    }

    public void reportScrollStateChange(int i2) {
        i iVar;
        if (i2 == this.mLastScrollState || (iVar = this.mOnScrollListener) == null) {
            return;
        }
        this.mLastScrollState = i2;
        iVar.b(this, i2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            recycleVelocityTracker();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.mBlockLayoutRequests || this.mInLayout) {
            return;
        }
        super.requestLayout();
    }

    public void requestLayoutIfNecessary() {
        if (getChildCount() > 0) {
            resetList();
            requestLayout();
            invalidate();
        }
    }

    public void resetList() {
        removeAllViewsInLayout();
        this.mFirstPosition = 0;
        this.mDataChanged = false;
        this.mPositionScrollAfterLayout = null;
        this.mNeedSync = false;
        this.mPendingSync = null;
        this.mOldSelectedPosition = -1;
        this.mOldSelectedColId = Long.MIN_VALUE;
        setSelectedPositionInt(-1);
        setNextSelectedPositionInt(-1);
        this.mSelectedLeft = 0;
        this.mSelectorPosition = -1;
        this.mSelectorRect.setEmpty();
        invalidate();
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00d3 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean resurrectSelection() {
        int i2;
        boolean z;
        int i3;
        k kVar;
        int lookForSelectablePosition;
        int childCount = getChildCount();
        if (childCount <= 0) {
            return false;
        }
        int i4 = this.mListPadding.left;
        int right = (getRight() - getLeft()) - this.mListPadding.right;
        int i5 = this.mFirstPosition;
        int i6 = this.mResurrectToPosition;
        if (i6 >= i5 && i6 < i5 + childCount) {
            View childAt = getChildAt(i6 - i5);
            i2 = childAt.getLeft();
            int right2 = childAt.getRight();
            if (i2 < i4) {
                i2 = i4 + getHorizontalFadingEdgeLength();
            } else if (right2 > right) {
                i2 = (right - childAt.getMeasuredWidth()) - getHorizontalFadingEdgeLength();
            }
        } else if (i6 >= i5) {
            int i7 = this.mItemCount;
            int i8 = i5 + childCount;
            int i9 = i8 - 1;
            int i10 = childCount - 1;
            int i11 = i10;
            int i12 = 0;
            while (true) {
                if (i11 < 0) {
                    i6 = i9;
                    i2 = i12;
                    break;
                }
                View childAt2 = getChildAt(i11);
                int left = childAt2.getLeft();
                int right3 = childAt2.getRight();
                if (i11 == i10) {
                    if (i8 < i7 || right3 > right) {
                        right -= getHorizontalFadingEdgeLength();
                    }
                    i12 = left;
                }
                if (right3 <= right) {
                    i6 = i5 + i11;
                    i2 = left;
                    break;
                }
                i11--;
            }
            z = false;
            i3 = -1;
            this.mResurrectToPosition = -1;
            removeCallbacks(this.mFlingRunnable);
            kVar = this.mPositionScroller;
            if (kVar != null) {
                kVar.f();
            }
            this.mTouchMode = -1;
            clearScrollingCache();
            this.mSpecificLeft = i2;
            lookForSelectablePosition = lookForSelectablePosition(i6, z);
            if (lookForSelectablePosition >= i5 && lookForSelectablePosition <= getLastVisiblePosition()) {
                this.mLayoutMode = 4;
                updateSelectorState();
                setSelectionInt(lookForSelectablePosition);
                invokeOnItemScrollListener();
                i3 = lookForSelectablePosition;
            }
            reportScrollStateChange(0);
            return i3 < 0;
        } else {
            int i13 = 0;
            int i14 = 0;
            while (true) {
                if (i13 >= childCount) {
                    i2 = i14;
                    i6 = i5;
                    break;
                }
                i2 = getChildAt(i13).getLeft();
                if (i13 == 0) {
                    if (i5 > 0 || i2 < i4) {
                        i4 += getHorizontalFadingEdgeLength();
                    }
                    i14 = i2;
                }
                if (i2 >= i4) {
                    i6 = i13 + i5;
                    break;
                }
                i13++;
            }
        }
        z = true;
        i3 = -1;
        this.mResurrectToPosition = -1;
        removeCallbacks(this.mFlingRunnable);
        kVar = this.mPositionScroller;
        if (kVar != null) {
        }
        this.mTouchMode = -1;
        clearScrollingCache();
        this.mSpecificLeft = i2;
        lookForSelectablePosition = lookForSelectablePosition(i6, z);
        if (lookForSelectablePosition >= i5) {
            this.mLayoutMode = 4;
            updateSelectorState();
            setSelectionInt(lookForSelectablePosition);
            invokeOnItemScrollListener();
            i3 = lookForSelectablePosition;
        }
        reportScrollStateChange(0);
        if (i3 < 0) {
        }
    }

    public boolean resurrectSelectionIfNeeded() {
        if (this.mSelectedPosition >= 0 || !resurrectSelection()) {
            return false;
        }
        updateSelectorState();
        return true;
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEvent(int i2) {
        if (i2 == 4096) {
            int firstVisiblePosition = getFirstVisiblePosition();
            int lastVisiblePosition = getLastVisiblePosition();
            if (this.mLastAccessibilityScrollEventFromIndex == firstVisiblePosition && this.mLastAccessibilityScrollEventToIndex == lastVisiblePosition) {
                return;
            }
            this.mLastAccessibilityScrollEventFromIndex = firstVisiblePosition;
            this.mLastAccessibilityScrollEventToIndex = lastVisiblePosition;
        }
        super.sendAccessibilityEvent(i2);
    }

    public void setCacheColorHint(int i2) {
        if (i2 != this.mCacheColorHint) {
            this.mCacheColorHint = i2;
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                getChildAt(i3).setDrawingCacheBackgroundColor(i2);
            }
            this.mRecycler.o(i2);
        }
    }

    @TargetApi(11)
    public void setChoiceMode(int i2) {
        ListAdapter listAdapter;
        Object obj;
        this.mChoiceMode = i2;
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 11 && (obj = this.mChoiceActionMode) != null) {
            if (i3 >= 11) {
                ((ActionMode) obj).finish();
            }
            this.mChoiceActionMode = null;
        }
        if (this.mChoiceMode != 0) {
            if (this.mCheckStates == null) {
                this.mCheckStates = new SparseArrayCompat<>();
            }
            if (this.mCheckedIdStates == null && (listAdapter = this.mAdapter) != null && listAdapter.hasStableIds()) {
                this.mCheckedIdStates = new LongSparseArray<>();
            }
            if (Build.VERSION.SDK_INT < 11 || this.mChoiceMode != 3) {
                return;
            }
            clearChoices();
            setLongClickable(true);
        }
    }

    public void setDrawSelectorOnTop(boolean z) {
        this.mDrawSelectorOnTop = z;
    }

    public void setFriction(float f2) {
        if (this.mFlingRunnable == null) {
            this.mFlingRunnable = new g();
        }
        this.mFlingRunnable.f17464e.j(f2);
    }

    public void setItemChecked(int i2, boolean z) {
        int i3 = this.mChoiceMode;
        if (i3 == 0) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 11 && z && i3 == 3 && this.mChoiceActionMode == null) {
            Object obj = this.mMultiChoiceModeCallback;
            if (obj != null && ((d.b.i0.a1.a.c.b) obj).b()) {
                this.mChoiceActionMode = startActionMode((d.b.i0.a1.a.c.b) this.mMultiChoiceModeCallback);
            } else {
                throw new IllegalStateException("AbsListView: attempted to start selection mode for CHOICE_MODE_MULTIPLE_MODAL but no choice mode callback was supplied. Call setMultiChoiceModeListener to set a callback.");
            }
        }
        int i4 = this.mChoiceMode;
        if (i4 != 2 && (Build.VERSION.SDK_INT < 11 || i4 != 3)) {
            boolean z2 = this.mCheckedIdStates != null && this.mAdapter.hasStableIds();
            if (z || isItemChecked(i2)) {
                this.mCheckStates.clear();
                if (z2) {
                    this.mCheckedIdStates.clear();
                }
            }
            if (z) {
                this.mCheckStates.put(i2, Boolean.TRUE);
                if (z2) {
                    this.mCheckedIdStates.put(this.mAdapter.getItemId(i2), Integer.valueOf(i2));
                }
                this.mCheckedItemCount = 1;
            } else if (this.mCheckStates.size() == 0 || !this.mCheckStates.valueAt(0).booleanValue()) {
                this.mCheckedItemCount = 0;
            }
        } else {
            boolean booleanValue = this.mCheckStates.get(i2, Boolean.FALSE).booleanValue();
            this.mCheckStates.put(i2, Boolean.valueOf(z));
            if (this.mCheckedIdStates != null && this.mAdapter.hasStableIds()) {
                if (z) {
                    this.mCheckedIdStates.put(this.mAdapter.getItemId(i2), Integer.valueOf(i2));
                } else {
                    this.mCheckedIdStates.delete(this.mAdapter.getItemId(i2));
                }
            }
            if (booleanValue != z) {
                if (z) {
                    this.mCheckedItemCount++;
                } else {
                    this.mCheckedItemCount--;
                }
            }
            if (this.mChoiceActionMode != null) {
                ((d.b.i0.a1.a.c.b) this.mMultiChoiceModeCallback).a((ActionMode) this.mChoiceActionMode, i2, this.mAdapter.getItemId(i2), z);
            }
        }
        if (this.mInLayout || this.mBlockLayoutRequests) {
            return;
        }
        this.mDataChanged = true;
        rememberSyncState();
        requestLayout();
    }

    @TargetApi(11)
    public void setMultiChoiceModeListener(d.b.i0.a1.a.c.a aVar) {
        if (Build.VERSION.SDK_INT >= 11) {
            if (this.mMultiChoiceModeCallback == null) {
                this.mMultiChoiceModeCallback = new d.b.i0.a1.a.c.b(this);
            }
            ((d.b.i0.a1.a.c.b) this.mMultiChoiceModeCallback).c(aVar);
        }
    }

    public void setOnScrollListener(i iVar) {
        this.mOnScrollListener = iVar;
        invokeOnItemScrollListener();
    }

    public void setOverScrollEffectPadding(int i2, int i3) {
        this.mGlowPaddingTop = i2;
        this.mGlowPaddingBottom = i3;
    }

    @Override // android.view.View
    public void setOverScrollMode(int i2) {
        if (i2 != 2) {
            if (this.mEdgeGlowTop == null) {
                Context context = getContext();
                this.mEdgeGlowTop = new EdgeEffectCompat(context);
                this.mEdgeGlowBottom = new EdgeEffectCompat(context);
            }
        } else {
            this.mEdgeGlowTop = null;
            this.mEdgeGlowBottom = null;
        }
        super.setOverScrollMode(i2);
    }

    public void setRecyclerListener(m mVar) {
        this.mRecycler.f17483a = mVar;
    }

    public void setScrollIndicators(View view, View view2) {
        this.mScrollLeft = view;
        this.mScrollRight = view2;
    }

    public void setScrollingCacheEnabled(boolean z) {
        if (this.mScrollingCacheEnabled && !z) {
            clearScrollingCache();
        }
        this.mScrollingCacheEnabled = z;
    }

    public abstract void setSelectionInt(int i2);

    public void setSelector(int i2) {
        setSelector(getResources().getDrawable(i2));
    }

    public void setSmoothScrollbarEnabled(boolean z) {
        this.mSmoothScrollbarEnabled = z;
    }

    public void setStackFromRight(boolean z) {
        if (this.mStackFromRight != z) {
            this.mStackFromRight = z;
            requestLayoutIfNecessary();
        }
    }

    public void setTranscriptMode(int i2) {
        this.mTranscriptMode = i2;
    }

    public void setVelocityScale(float f2) {
        this.mVelocityScale = f2;
    }

    public void setVisibleRangeHint(int i2, int i3) {
    }

    public boolean shouldShowSelector() {
        return (hasFocus() && !isInTouchMode()) || touchModeDrawsInPressedState();
    }

    public boolean showContextMenu(float f2, float f3, int i2) {
        int pointToPosition = pointToPosition((int) f2, (int) f3);
        if (pointToPosition != -1) {
            long itemId = this.mAdapter.getItemId(pointToPosition);
            View childAt = getChildAt(pointToPosition - this.mFirstPosition);
            if (childAt != null) {
                this.mContextMenuInfo = createContextMenuInfo(childAt, pointToPosition, itemId);
                return super.showContextMenuForChild(this);
            }
        }
        return showContextMenu(f2, f3, i2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean showContextMenuForChild(View view) {
        int positionForView = getPositionForView(view);
        if (positionForView >= 0) {
            long itemId = this.mAdapter.getItemId(positionForView);
            AdapterView.e eVar = this.mOnItemLongClickListener;
            boolean a2 = eVar != null ? eVar.a(this, view, positionForView, itemId) : false;
            if (a2) {
                return a2;
            }
            this.mContextMenuInfo = createContextMenuInfo(getChildAt(positionForView - this.mFirstPosition), positionForView, itemId);
            return super.showContextMenuForChild(view);
        }
        return false;
    }

    public void smoothScrollBy(int i2, int i3) {
        smoothScrollBy(i2, i3, false);
    }

    public void smoothScrollByOffset(int i2) {
        int lastVisiblePosition;
        View childAt;
        Rect rect;
        if (i2 < 0) {
            lastVisiblePosition = getFirstVisiblePosition();
        } else {
            lastVisiblePosition = i2 > 0 ? getLastVisiblePosition() : -1;
        }
        if (lastVisiblePosition <= -1 || (childAt = getChildAt(lastVisiblePosition - getFirstVisiblePosition())) == null) {
            return;
        }
        if (childAt.getGlobalVisibleRect(new Rect())) {
            float width = (rect.width() * rect.height()) / (childAt.getWidth() * childAt.getHeight());
            if (i2 < 0 && width < 0.75f) {
                lastVisiblePosition++;
            } else if (i2 > 0 && width < 0.75f) {
                lastVisiblePosition--;
            }
        }
        smoothScrollToPosition(Math.max(0, Math.min(getCount(), lastVisiblePosition + i2)));
    }

    public void smoothScrollToPosition(int i2) {
        if (this.mPositionScroller == null) {
            this.mPositionScroller = new k();
        }
        this.mPositionScroller.b(i2);
    }

    public void smoothScrollToPositionFromLeft(int i2, int i3, int i4) {
        if (this.mPositionScroller == null) {
            this.mPositionScroller = new k();
        }
        this.mPositionScroller.e(i2, i3, i4);
    }

    public boolean touchModeDrawsInPressedState() {
        int i2 = this.mTouchMode;
        return i2 == 1 || i2 == 2;
    }

    public boolean trackMotionScroll(int i2, int i3) {
        int min;
        int min2;
        int i4;
        int i5;
        int i6;
        int i7;
        int childCount = getChildCount();
        if (childCount == 0) {
            return true;
        }
        int left = getChildAt(0).getLeft();
        int i8 = childCount - 1;
        int right = getChildAt(i8).getRight();
        Rect rect = this.mListPadding;
        int i9 = 0 - left;
        int width = right - (getWidth() - 0);
        int width2 = (getWidth() - getPaddingRight()) - getPaddingLeft();
        if (i2 < 0) {
            min = Math.max(-(width2 - 1), i2);
        } else {
            min = Math.min(width2 - 1, i2);
        }
        if (i3 < 0) {
            min2 = Math.max(-(width2 - 1), i3);
        } else {
            min2 = Math.min(width2 - 1, i3);
        }
        int i10 = this.mFirstPosition;
        if (i10 == 0) {
            this.mFirstPositionDistanceGuess = left - rect.left;
        } else {
            this.mFirstPositionDistanceGuess += min2;
        }
        int i11 = i10 + childCount;
        if (i11 == this.mItemCount) {
            this.mLastPositionDistanceGuess = rect.right + right;
        } else {
            this.mLastPositionDistanceGuess += min2;
        }
        boolean z = i10 == 0 && left >= rect.left && min2 >= 0;
        boolean z2 = i11 == this.mItemCount && right <= getWidth() - rect.right && min2 <= 0;
        if (z || z2) {
            return min2 != 0;
        }
        boolean z3 = min2 < 0;
        boolean isInTouchMode = isInTouchMode();
        if (isInTouchMode) {
            hideSelector();
        }
        int headerViewsCount = getHeaderViewsCount();
        int footerViewsCount = this.mItemCount - getFooterViewsCount();
        if (z3) {
            int i12 = -min2;
            int i13 = 0;
            i5 = 0;
            while (i13 < childCount) {
                View childAt = getChildAt(i13);
                if (childAt.getRight() >= i12) {
                    break;
                }
                i5++;
                int i14 = i10 + i13;
                if (i14 < headerViewsCount || i14 >= footerViewsCount) {
                    i7 = childCount;
                } else {
                    i7 = childCount;
                    this.mRecycler.c(childAt, i14);
                }
                i13++;
                childCount = i7;
            }
            i4 = 0;
        } else {
            int width3 = getWidth() - min2;
            i4 = 0;
            i5 = 0;
            while (i8 >= 0) {
                View childAt2 = getChildAt(i8);
                if (childAt2.getLeft() <= width3) {
                    break;
                }
                i5++;
                int i15 = i10 + i8;
                if (i15 >= headerViewsCount && i15 < footerViewsCount) {
                    this.mRecycler.c(childAt2, i15);
                }
                int i16 = i8;
                i8--;
                i4 = i16;
            }
        }
        this.mMotionViewNewLeft = this.mMotionViewOriginalLeft + min;
        this.mBlockLayoutRequests = true;
        if (i5 > 0) {
            detachViewsFromParent(i4, i5);
            this.mRecycler.m();
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        offsetChildrenLeftAndRight(min2);
        if (z3) {
            this.mFirstPosition += i5;
        }
        int abs = Math.abs(min2);
        if (i9 < abs || width < abs) {
            fillGap(z3);
        }
        if (!isInTouchMode && (i6 = this.mSelectedPosition) != -1) {
            int i17 = i6 - this.mFirstPosition;
            if (i17 >= 0 && i17 < getChildCount()) {
                positionSelector(this.mSelectedPosition, getChildAt(i17));
            }
        } else {
            int i18 = this.mSelectorPosition;
            if (i18 != -1) {
                int i19 = i18 - this.mFirstPosition;
                if (i19 >= 0 && i19 < getChildCount()) {
                    positionSelector(-1, getChildAt(i19));
                }
            } else {
                this.mSelectorRect.setEmpty();
            }
        }
        this.mBlockLayoutRequests = false;
        invokeOnItemScrollListener();
        return false;
    }

    public void updateScrollIndicators() {
        if (this.mScrollLeft != null) {
            boolean z = this.mFirstPosition > 0;
            if (!z && getChildCount() > 0) {
                z = getChildAt(0).getLeft() < this.mListPadding.left;
            }
            this.mScrollLeft.setVisibility(z ? 0 : 4);
        }
        if (this.mScrollRight != null) {
            int childCount = getChildCount();
            boolean z2 = this.mFirstPosition + childCount < this.mItemCount;
            if (!z2 && childCount > 0) {
                z2 = getChildAt(childCount - 1).getRight() > getRight() - this.mListPadding.right;
            }
            this.mScrollRight.setVisibility(z2 ? 0 : 4);
        }
    }

    public void updateSelectorState() {
        if (this.mSelector != null) {
            if (shouldShowSelector()) {
                this.mSelector.setState(getDrawableState());
            } else {
                this.mSelector.setState(STATESET_NOTHING);
            }
        }
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return this.mSelector == drawable || super.verifyDrawable(drawable);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.horizonalList.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            boolean hasStableIds = this.mAdapter.hasStableIds();
            this.mAdapterHasStableIds = hasStableIds;
            if (this.mChoiceMode != 0 && hasStableIds && this.mCheckedIdStates == null) {
                this.mCheckedIdStates = new LongSparseArray<>();
            }
        }
        SparseArrayCompat<Boolean> sparseArrayCompat = this.mCheckStates;
        if (sparseArrayCompat != null) {
            sparseArrayCompat.clear();
        }
        LongSparseArray<Integer> longSparseArray = this.mCheckedIdStates;
        if (longSparseArray != null) {
            longSparseArray.clear();
        }
    }

    public void setSelector(Drawable drawable) {
        Drawable drawable2 = this.mSelector;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.mSelector);
        }
        this.mSelector = drawable;
        Rect rect = new Rect();
        drawable.getPadding(rect);
        this.mSelectionLeftPadding = rect.left;
        this.mSelectionTopPadding = rect.top;
        this.mSelectionRightPadding = rect.right;
        this.mSelectionBottomPadding = rect.bottom;
        drawable.setCallback(this);
        updateSelectorState();
    }

    public void smoothScrollBy(int i2, int i3, boolean z) {
        if (this.mFlingRunnable == null) {
            this.mFlingRunnable = new g();
        }
        int i4 = this.mFirstPosition;
        int childCount = getChildCount();
        int i5 = i4 + childCount;
        int paddingLeft = getPaddingLeft();
        int width = getWidth() - getPaddingRight();
        if (i2 != 0 && this.mItemCount != 0 && childCount != 0 && ((i4 != 0 || getChildAt(0).getLeft() != paddingLeft || i2 >= 0) && (i5 != this.mItemCount || getChildAt(childCount - 1).getRight() != width || i2 <= 0))) {
            reportScrollStateChange(2);
            this.mFlingRunnable.g(i2, i3, z);
            return;
        }
        this.mFlingRunnable.c();
        k kVar = this.mPositionScroller;
        if (kVar != null) {
            kVar.f();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public void smoothScrollToPosition(int i2, int i3) {
        if (this.mPositionScroller == null) {
            this.mPositionScroller = new k();
        }
        this.mPositionScroller.c(i2, i3);
    }

    public void smoothScrollToPositionFromLeft(int i2, int i3) {
        if (this.mPositionScroller == null) {
            this.mPositionScroller = new k();
        }
        this.mPositionScroller.d(i2, i3);
    }

    private void positionSelector(int i2, int i3, int i4, int i5) {
        this.mSelectorRect.set(i2 - this.mSelectionLeftPadding, i3 - this.mSelectionTopPadding, i4 + this.mSelectionRightPadding, i5 + this.mSelectionBottomPadding);
    }

    public AbsHListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.hlv_absHListViewStyle);
    }

    public AbsHListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        int i3;
        boolean z;
        boolean z2;
        int i4;
        int i5;
        boolean z3 = false;
        this.mChoiceMode = 0;
        this.mLayoutMode = 0;
        this.mDrawSelectorOnTop = false;
        this.mSelectorPosition = -1;
        this.mSelectorRect = new Rect();
        this.mRecycler = new l();
        this.mSelectionLeftPadding = 0;
        this.mSelectionTopPadding = 0;
        this.mSelectionRightPadding = 0;
        this.mSelectionBottomPadding = 0;
        this.mListPadding = new Rect();
        this.mHeightMeasureSpec = 0;
        this.mTouchMode = -1;
        this.mSelectedLeft = 0;
        boolean z4 = true;
        this.mSmoothScrollbarEnabled = true;
        this.mResurrectToPosition = -1;
        Drawable drawable = null;
        this.mContextMenuInfo = null;
        this.mLastTouchMode = -1;
        this.mLastScrollState = 0;
        this.mVelocityScale = 1.0f;
        this.mIsScrap = new boolean[1];
        this.mActivePointerId = -1;
        this.mDirection = 0;
        initAbsListView();
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.HListView, i2, 0);
        if (obtainStyledAttributes != null) {
            drawable = obtainStyledAttributes.getDrawable(R$styleable.AbsHListView_android_listSelector);
            boolean z5 = obtainStyledAttributes.getBoolean(R$styleable.AbsHListView_android_drawSelectorOnTop, false);
            z2 = obtainStyledAttributes.getBoolean(R$styleable.AbsHListView_hlv_stackFromRight, false);
            boolean z6 = obtainStyledAttributes.getBoolean(R$styleable.AbsHListView_android_scrollingCache, true);
            i4 = obtainStyledAttributes.getInt(R$styleable.AbsHListView_hlv_transcriptMode, 0);
            i5 = obtainStyledAttributes.getColor(R$styleable.AbsHListView_android_cacheColorHint, 0);
            boolean z7 = obtainStyledAttributes.getBoolean(R$styleable.AbsHListView_android_smoothScrollbar, true);
            int i6 = obtainStyledAttributes.getInt(R$styleable.AbsHListView_android_choiceMode, 0);
            obtainStyledAttributes.recycle();
            i3 = i6;
            z3 = z5;
            z = z7;
            z4 = z6;
        } else {
            i3 = 0;
            z = true;
            z2 = false;
            i4 = 0;
            i5 = 0;
        }
        if (drawable != null) {
            setSelector(drawable);
        }
        this.mDrawSelectorOnTop = z3;
        setStackFromRight(z2);
        setScrollingCacheEnabled(z4);
        setTranscriptMode(i4);
        setCacheColorHint(i5);
        setSmoothScrollbarEnabled(z);
        setChoiceMode(i3);
    }
}
