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
import android.support.v4.media.TransportMediator;
import android.support.v4.util.LongSparseArray;
import android.support.v4.util.SparseArrayCompat;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.widget.EdgeEffectCompat;
import android.support.v4.widget.ExploreByTouchHelper;
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
import com.baidu.tieba.d;
import com.baidu.tieba.horizonalList.a.b;
import com.baidu.tieba.horizonalList.widget.a;
import java.util.ArrayList;
@TargetApi(11)
/* loaded from: classes.dex */
public abstract class AbsHListView extends com.baidu.tieba.horizonalList.widget.a<ListAdapter> implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnTouchModeChangeListener {
    static final Interpolator cYg = new LinearInterpolator();
    public static final int[] cYi = {0};
    View cXA;
    View cXB;
    protected boolean cXC;
    int cXD;
    int cXE;
    int cXF;
    private e cXG;
    protected j cXH;
    protected int cXI;
    protected boolean cXJ;
    private h cXK;
    protected int cXL;
    private c cXM;
    private b cXN;
    private i cXO;
    private Runnable cXP;
    protected Runnable cXQ;
    private float cXR;
    int cXS;
    int cXT;
    private EdgeEffectCompat cXU;
    private EdgeEffectCompat cXV;
    private int cXW;
    private int cXX;
    private boolean cXY;
    private int cXZ;
    b.a cXo;
    protected int cXp;
    public Object cXq;
    Object cXr;
    int cXs;
    protected SparseArrayCompat<Boolean> cXt;
    LongSparseArray<Integer> cXu;
    protected a cXv;
    boolean cXw;
    int cXx;
    protected final k cXy;
    protected int cXz;
    private int cYa;
    private g cYb;
    private int cYc;
    private int cYd;
    protected boolean cYe;
    private int cYf;
    private SavedState cYh;
    private float cYj;
    private int mActivePointerId;
    protected ListAdapter mAdapter;
    private int mCacheColorHint;
    protected boolean mCachingStarted;
    private Runnable mClearScrollingCache;
    private ContextMenu.ContextMenuInfo mContextMenuInfo;
    private int mDirection;
    boolean mDrawSelectorOnTop;
    private boolean mIsChildViewEnabled;
    protected final boolean[] mIsScrap;
    private int mLastScrollState;
    private int mLastTouchMode;
    protected int mLayoutMode;
    protected Rect mListPadding;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    int mMotionCorrection;
    protected int mMotionPosition;
    int mMotionX;
    int mMotionY;
    private Runnable mPendingCheckForTap;
    protected int mResurrectToPosition;
    boolean mScrollingCacheEnabled;
    int mSelectionBottomPadding;
    int mSelectionLeftPadding;
    int mSelectionRightPadding;
    int mSelectionTopPadding;
    Drawable mSelector;
    protected Rect mSelectorRect;
    private boolean mSmoothScrollbarEnabled;
    private Rect mTouchFrame;
    protected int mTouchMode;
    private int mTouchSlop;
    private int mTranscriptMode;
    private VelocityTracker mVelocityTracker;

    /* loaded from: classes.dex */
    public interface h {
        void a(AbsHListView absHListView, int i);

        void a(AbsHListView absHListView, int i, int i2, int i3);
    }

    /* loaded from: classes.dex */
    public interface l {
        void onMovedToScrapHeap(View view);
    }

    /* loaded from: classes.dex */
    public interface m {
        void adjustListItemSelectionBounds(Rect rect);
    }

    protected abstract void fillGap(boolean z);

    protected abstract int kW(int i2);

    public abstract void setSelectionInt(int i2);

    public AbsHListView(Context context) {
        super(context);
        this.cXp = 0;
        this.mLayoutMode = 0;
        this.mDrawSelectorOnTop = false;
        this.cXx = -1;
        this.mSelectorRect = new Rect();
        this.cXy = new k();
        this.mSelectionLeftPadding = 0;
        this.mSelectionTopPadding = 0;
        this.mSelectionRightPadding = 0;
        this.mSelectionBottomPadding = 0;
        this.mListPadding = new Rect();
        this.cXz = 0;
        this.mTouchMode = -1;
        this.cXI = 0;
        this.mSmoothScrollbarEnabled = true;
        this.mResurrectToPosition = -1;
        this.mContextMenuInfo = null;
        this.mLastTouchMode = -1;
        this.mLastScrollState = 0;
        this.cXR = 1.0f;
        this.mIsScrap = new boolean[1];
        this.mActivePointerId = -1;
        this.mDirection = 0;
        initAbsListView();
    }

    public AbsHListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, d.c.hlv_absHListViewStyle);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbsHListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        int i3;
        boolean z;
        boolean z2;
        boolean z3;
        Drawable drawable;
        int i4;
        boolean z4 = true;
        int i5 = 0;
        this.cXp = 0;
        this.mLayoutMode = 0;
        this.mDrawSelectorOnTop = false;
        this.cXx = -1;
        this.mSelectorRect = new Rect();
        this.cXy = new k();
        this.mSelectionLeftPadding = 0;
        this.mSelectionTopPadding = 0;
        this.mSelectionRightPadding = 0;
        this.mSelectionBottomPadding = 0;
        this.mListPadding = new Rect();
        this.cXz = 0;
        this.mTouchMode = -1;
        this.cXI = 0;
        this.mSmoothScrollbarEnabled = true;
        this.mResurrectToPosition = -1;
        this.mContextMenuInfo = null;
        this.mLastTouchMode = -1;
        this.mLastScrollState = 0;
        this.cXR = 1.0f;
        this.mIsScrap = new boolean[1];
        this.mActivePointerId = -1;
        this.mDirection = 0;
        initAbsListView();
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, d.n.HListView, i2, 0);
        if (obtainStyledAttributes != null) {
            drawable = obtainStyledAttributes.getDrawable(d.n.AbsHListView_android_listSelector);
            z3 = obtainStyledAttributes.getBoolean(d.n.AbsHListView_android_drawSelectorOnTop, false);
            z2 = obtainStyledAttributes.getBoolean(d.n.AbsHListView_hlv_stackFromRight, false);
            z = obtainStyledAttributes.getBoolean(d.n.AbsHListView_android_scrollingCache, true);
            i3 = obtainStyledAttributes.getInt(d.n.AbsHListView_hlv_transcriptMode, 0);
            i4 = obtainStyledAttributes.getColor(d.n.AbsHListView_android_cacheColorHint, 0);
            z4 = obtainStyledAttributes.getBoolean(d.n.AbsHListView_android_smoothScrollbar, true);
            i5 = obtainStyledAttributes.getInt(d.n.AbsHListView_android_choiceMode, 0);
            obtainStyledAttributes.recycle();
        } else {
            i3 = 0;
            z = true;
            z2 = false;
            z3 = false;
            drawable = null;
            i4 = 0;
        }
        if (drawable != null) {
            setSelector(drawable);
        }
        this.mDrawSelectorOnTop = z3;
        setStackFromRight(z2);
        setScrollingCacheEnabled(z);
        setTranscriptMode(i3);
        setCacheColorHint(i4);
        setSmoothScrollbarEnabled(z4);
        setChoiceMode(i5);
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
        this.cXS = viewConfiguration.getScaledOverscrollDistance();
        this.cXT = viewConfiguration.getScaledOverflingDistance();
        this.cXo = com.baidu.tieba.horizonalList.a.b.az(this);
    }

    @Override // android.view.View
    public void setOverScrollMode(int i2) {
        if (i2 != 2) {
            if (this.cXU == null) {
                Context context = getContext();
                this.cXU = new EdgeEffectCompat(context);
                this.cXV = new EdgeEffectCompat(context);
            }
        } else {
            this.cXU = null;
            this.cXV = null;
        }
        super.setOverScrollMode(i2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.horizonalList.widget.a
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            this.cXw = this.mAdapter.hasStableIds();
            if (this.cXp != 0 && this.cXw && this.cXu == null) {
                this.cXu = new LongSparseArray<>();
            }
        }
        if (this.cXt != null) {
            this.cXt.clear();
        }
        if (this.cXu != null) {
            this.cXu.clear();
        }
    }

    public int getCheckedItemCount() {
        return this.cXs;
    }

    public boolean isItemChecked(int i2) {
        if (this.cXp == 0 || this.cXt == null) {
            return false;
        }
        return this.cXt.get(i2, false).booleanValue();
    }

    public int getCheckedItemPosition() {
        if (this.cXp == 1 && this.cXt != null && this.cXt.size() == 1) {
            return this.cXt.keyAt(0);
        }
        return -1;
    }

    public SparseArrayCompat<Boolean> getCheckedItemPositions() {
        if (this.cXp != 0) {
            return this.cXt;
        }
        return null;
    }

    public long[] getCheckedItemIds() {
        if (this.cXp == 0 || this.cXu == null || this.mAdapter == null) {
            return new long[0];
        }
        LongSparseArray<Integer> longSparseArray = this.cXu;
        int size = longSparseArray.size();
        long[] jArr = new long[size];
        for (int i2 = 0; i2 < size; i2++) {
            jArr[i2] = longSparseArray.keyAt(i2);
        }
        return jArr;
    }

    public void clearChoices() {
        if (this.cXt != null) {
            this.cXt.clear();
        }
        if (this.cXu != null) {
            this.cXu.clear();
        }
        this.cXs = 0;
    }

    public void setItemChecked(int i2, boolean z) {
        if (this.cXp != 0) {
            if (Build.VERSION.SDK_INT >= 11 && z && this.cXp == 3 && this.cXq == null) {
                if (this.cXr == null || !((com.baidu.tieba.horizonalList.a.a.b) this.cXr).aps()) {
                    throw new IllegalStateException("AbsListView: attempted to start selection mode for CHOICE_MODE_MULTIPLE_MODAL but no choice mode callback was supplied. Call setMultiChoiceModeListener to set a callback.");
                }
                this.cXq = startActionMode((com.baidu.tieba.horizonalList.a.a.b) this.cXr);
            }
            if (this.cXp == 2 || (Build.VERSION.SDK_INT >= 11 && this.cXp == 3)) {
                boolean booleanValue = this.cXt.get(i2, false).booleanValue();
                this.cXt.put(i2, Boolean.valueOf(z));
                if (this.cXu != null && this.mAdapter.hasStableIds()) {
                    if (z) {
                        this.cXu.put(this.mAdapter.getItemId(i2), Integer.valueOf(i2));
                    } else {
                        this.cXu.delete(this.mAdapter.getItemId(i2));
                    }
                }
                if (booleanValue != z) {
                    if (z) {
                        this.cXs++;
                    } else {
                        this.cXs--;
                    }
                }
                if (this.cXq != null) {
                    ((com.baidu.tieba.horizonalList.a.a.b) this.cXr).onItemCheckedStateChanged((ActionMode) this.cXq, i2, this.mAdapter.getItemId(i2), z);
                }
            } else {
                boolean z2 = this.cXu != null && this.mAdapter.hasStableIds();
                if (z || isItemChecked(i2)) {
                    this.cXt.clear();
                    if (z2) {
                        this.cXu.clear();
                    }
                }
                if (z) {
                    this.cXt.put(i2, true);
                    if (z2) {
                        this.cXu.put(this.mAdapter.getItemId(i2), Integer.valueOf(i2));
                    }
                    this.cXs = 1;
                } else if (this.cXt.size() == 0 || !this.cXt.valueAt(0).booleanValue()) {
                    this.cXs = 0;
                }
            }
            if (!this.mInLayout && !this.mBlockLayoutRequests) {
                this.mDataChanged = true;
                rememberSyncState();
                requestLayout();
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.a
    public boolean performItemClick(View view, int i2, long j2) {
        boolean z;
        boolean z2;
        boolean z3 = true;
        boolean z4 = false;
        if (this.cXp != 0) {
            if (this.cXp == 2 || (Build.VERSION.SDK_INT >= 11 && this.cXp == 3 && this.cXq != null)) {
                boolean z5 = !this.cXt.get(i2, false).booleanValue();
                this.cXt.put(i2, Boolean.valueOf(z5));
                if (this.cXu != null && this.mAdapter.hasStableIds()) {
                    if (z5) {
                        this.cXu.put(this.mAdapter.getItemId(i2), Integer.valueOf(i2));
                    } else {
                        this.cXu.delete(this.mAdapter.getItemId(i2));
                    }
                }
                if (z5) {
                    this.cXs++;
                } else {
                    this.cXs--;
                }
                if (this.cXq != null) {
                    ((com.baidu.tieba.horizonalList.a.a.b) this.cXr).onItemCheckedStateChanged((ActionMode) this.cXq, i2, j2, z5);
                } else {
                    z4 = true;
                }
                z2 = z4;
                z4 = true;
            } else if (this.cXp == 1) {
                if (!this.cXt.get(i2, false).booleanValue()) {
                    this.cXt.clear();
                    this.cXt.put(i2, true);
                    if (this.cXu != null && this.mAdapter.hasStableIds()) {
                        this.cXu.clear();
                        this.cXu.put(this.mAdapter.getItemId(i2), Integer.valueOf(i2));
                    }
                    this.cXs = 1;
                } else if (this.cXt.size() == 0 || !this.cXt.valueAt(0).booleanValue()) {
                    this.cXs = 0;
                }
                z4 = true;
                z2 = true;
            } else {
                z2 = true;
            }
            if (z4) {
                apt();
            }
            boolean z6 = z2;
            z = true;
            z3 = z6;
        } else {
            z = false;
        }
        if (z3) {
            return z | super.performItemClick(view, i2, j2);
        }
        return z;
    }

    private void apt() {
        int i2 = this.mFirstPosition;
        int childCount = getChildCount();
        boolean z = Build.VERSION.SDK_INT >= 11;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            int i4 = i2 + i3;
            if (childAt instanceof Checkable) {
                ((Checkable) childAt).setChecked(this.cXt.get(i4, false).booleanValue());
            } else if (z) {
                childAt.setActivated(this.cXt.get(i4, false).booleanValue());
            }
        }
    }

    public int getChoiceMode() {
        return this.cXp;
    }

    @TargetApi(11)
    public void setChoiceMode(int i2) {
        this.cXp = i2;
        if (Build.VERSION.SDK_INT >= 11 && this.cXq != null) {
            if (Build.VERSION.SDK_INT >= 11) {
                ((ActionMode) this.cXq).finish();
            }
            this.cXq = null;
        }
        if (this.cXp != 0) {
            if (this.cXt == null) {
                this.cXt = new SparseArrayCompat<>();
            }
            if (this.cXu == null && this.mAdapter != null && this.mAdapter.hasStableIds()) {
                this.cXu = new LongSparseArray<>();
            }
            if (Build.VERSION.SDK_INT >= 11 && this.cXp == 3) {
                clearChoices();
                setLongClickable(true);
            }
        }
    }

    @TargetApi(11)
    public void setMultiChoiceModeListener(com.baidu.tieba.horizonalList.a.a.a aVar) {
        if (Build.VERSION.SDK_INT >= 11) {
            if (this.cXr == null) {
                this.cXr = new com.baidu.tieba.horizonalList.a.a.b(this);
            }
            ((com.baidu.tieba.horizonalList.a.a.b) this.cXr).a(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean apu() {
        int childCount = getChildCount();
        if (childCount == 0) {
            return true;
        }
        if (childCount != this.mItemCount) {
            return false;
        }
        return getChildAt(0).getLeft() >= this.mListPadding.left && getChildAt(childCount + (-1)).getRight() <= getWidth() - this.mListPadding.right;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public int getHorizontalScrollbarHeight() {
        return super.getHorizontalScrollbarHeight();
    }

    public void setSmoothScrollbarEnabled(boolean z) {
        this.mSmoothScrollbarEnabled = z;
    }

    public void setOnScrollListener(h hVar) {
        this.cXK = hVar;
        invokeOnItemScrollListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void invokeOnItemScrollListener() {
        if (this.cXK != null) {
            this.cXK.a(this, this.mFirstPosition, getChildCount(), this.mItemCount);
        }
        onScrollChanged(0, 0, 0, 0);
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEvent(int i2) {
        if (i2 == 4096) {
            int firstVisiblePosition = getFirstVisiblePosition();
            int lastVisiblePosition = getLastVisiblePosition();
            if (this.cYc != firstVisiblePosition || this.cYd != lastVisiblePosition) {
                this.cYc = firstVisiblePosition;
                this.cYd = lastVisiblePosition;
            } else {
                return;
            }
        }
        super.sendAccessibilityEvent(i2);
    }

    @Override // com.baidu.tieba.horizonalList.widget.a, android.view.View
    @TargetApi(14)
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(AbsHListView.class.getName());
    }

    @Override // com.baidu.tieba.horizonalList.widget.a, android.view.View
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

    public void setScrollingCacheEnabled(boolean z) {
        if (this.mScrollingCacheEnabled && !z) {
            clearScrollingCache();
        }
        this.mScrollingCacheEnabled = z;
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

    private void useDefaultSelector() {
        setSelector(getResources().getDrawable(17301602));
    }

    public void setStackFromRight(boolean z) {
        if (this.cXJ != z) {
            this.cXJ = z;
            requestLayoutIfNecessary();
        }
    }

    void requestLayoutIfNecessary() {
        if (getChildCount() > 0) {
            resetList();
            requestLayout();
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.tieba.horizonalList.widget.AbsHListView.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: m */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: lf */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        long cYN;
        long cYO;
        int cYP;
        String cYQ;
        boolean cYR;
        int cYS;
        SparseArrayCompat<Boolean> cYT;
        LongSparseArray<Integer> cYU;
        int position;
        int width;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.cYN = parcel.readLong();
            this.cYO = parcel.readLong();
            this.cYP = parcel.readInt();
            this.position = parcel.readInt();
            this.width = parcel.readInt();
            this.cYQ = parcel.readString();
            this.cYR = parcel.readByte() != 0;
            this.cYS = parcel.readInt();
            this.cYT = l(parcel);
            this.cYU = k(parcel);
        }

        private LongSparseArray<Integer> k(Parcel parcel) {
            int readInt = parcel.readInt();
            if (readInt <= 0) {
                return null;
            }
            LongSparseArray<Integer> longSparseArray = new LongSparseArray<>(readInt);
            a(longSparseArray, parcel, readInt);
            return longSparseArray;
        }

        private SparseArrayCompat<Boolean> l(Parcel parcel) {
            int readInt = parcel.readInt();
            if (readInt < 0) {
                return null;
            }
            SparseArrayCompat<Boolean> sparseArrayCompat = new SparseArrayCompat<>(readInt);
            a(sparseArrayCompat, parcel, readInt);
            return sparseArrayCompat;
        }

        private void a(LongSparseArray<Integer> longSparseArray, Parcel parcel, int i) {
            while (i > 0) {
                longSparseArray.put(parcel.readLong(), Integer.valueOf(parcel.readInt()));
                i--;
            }
        }

        private void a(SparseArrayCompat<Boolean> sparseArrayCompat, Parcel parcel, int i) {
            while (i > 0) {
                sparseArrayCompat.append(parcel.readInt(), Boolean.valueOf(parcel.readByte() == 1));
                i--;
            }
        }

        private void a(LongSparseArray<Integer> longSparseArray, Parcel parcel) {
            int size = longSparseArray != null ? longSparseArray.size() : 0;
            parcel.writeInt(size);
            for (int i = 0; i < size; i++) {
                parcel.writeLong(longSparseArray.keyAt(i));
                parcel.writeInt(longSparseArray.valueAt(i).intValue());
            }
        }

        private void a(SparseArrayCompat<Boolean> sparseArrayCompat, Parcel parcel) {
            if (sparseArrayCompat == null) {
                parcel.writeInt(-1);
                return;
            }
            int size = sparseArrayCompat.size();
            parcel.writeInt(size);
            for (int i = 0; i < size; i++) {
                parcel.writeInt(sparseArrayCompat.keyAt(i));
                parcel.writeByte((byte) (sparseArrayCompat.valueAt(i).booleanValue() ? 1 : 0));
            }
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeLong(this.cYN);
            parcel.writeLong(this.cYO);
            parcel.writeInt(this.cYP);
            parcel.writeInt(this.position);
            parcel.writeInt(this.width);
            parcel.writeString(this.cYQ);
            parcel.writeByte((byte) (this.cYR ? 1 : 0));
            parcel.writeInt(this.cYS);
            a(this.cYT, parcel);
            a(this.cYU, parcel);
        }

        public String toString() {
            return "AbsListView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " selectedId=" + this.cYN + " firstId=" + this.cYO + " viewLeft=" + this.cYP + " position=" + this.position + " width=" + this.width + " filter=" + this.cYQ + " checkState=" + this.cYT + "}";
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        boolean z = true;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.cYh != null) {
            savedState.cYN = this.cYh.cYN;
            savedState.cYO = this.cYh.cYO;
            savedState.cYP = this.cYh.cYP;
            savedState.position = this.cYh.position;
            savedState.width = this.cYh.width;
            savedState.cYQ = this.cYh.cYQ;
            savedState.cYR = this.cYh.cYR;
            savedState.cYS = this.cYh.cYS;
            savedState.cYT = this.cYh.cYT;
            savedState.cYU = this.cYh.cYU;
            return savedState;
        }
        boolean z2 = getChildCount() > 0 && this.mItemCount > 0;
        long selectedItemId = getSelectedItemId();
        savedState.cYN = selectedItemId;
        savedState.width = getWidth();
        if (selectedItemId >= 0) {
            savedState.cYP = this.cXI;
            savedState.position = getSelectedItemPosition();
            savedState.cYO = -1L;
        } else if (z2 && this.mFirstPosition > 0) {
            savedState.cYP = getChildAt(0).getLeft();
            int i2 = this.mFirstPosition;
            if (i2 >= this.mItemCount) {
                i2 = this.mItemCount - 1;
            }
            savedState.position = i2;
            savedState.cYO = this.mAdapter.getItemId(i2);
        } else {
            savedState.cYP = 0;
            savedState.cYO = -1L;
            savedState.position = 0;
        }
        savedState.cYQ = null;
        savedState.cYR = (Build.VERSION.SDK_INT < 11 || this.cXp != 3 || this.cXq == null) ? false : false;
        if (this.cXt != null) {
            try {
                savedState.cYT = this.cXt.m1clone();
            } catch (NoSuchMethodError e2) {
                e2.printStackTrace();
                savedState.cYT = new SparseArrayCompat<>();
            }
        }
        if (this.cXu != null) {
            LongSparseArray<Integer> longSparseArray = new LongSparseArray<>();
            int size = this.cXu.size();
            for (int i3 = 0; i3 < size; i3++) {
                longSparseArray.put(this.cXu.keyAt(i3), this.cXu.valueAt(i3));
            }
            savedState.cYU = longSparseArray;
        }
        savedState.cYS = this.cXs;
        return savedState;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mDataChanged = true;
        this.cYY = savedState.width;
        if (savedState.cYN >= 0) {
            this.mNeedSync = true;
            this.cYh = savedState;
            this.cYX = savedState.cYN;
            this.mSyncPosition = savedState.position;
            this.cYW = savedState.cYP;
            this.mSyncMode = 0;
        } else if (savedState.cYO >= 0) {
            setSelectedPositionInt(-1);
            setNextSelectedPositionInt(-1);
            this.cXx = -1;
            this.mNeedSync = true;
            this.cYh = savedState;
            this.cYX = savedState.cYO;
            this.mSyncPosition = savedState.position;
            this.cYW = savedState.cYP;
            this.mSyncMode = 1;
        }
        if (savedState.cYT != null) {
            this.cXt = savedState.cYT;
        }
        if (savedState.cYU != null) {
            this.cXu = savedState.cYU;
        }
        this.cXs = savedState.cYS;
        if (Build.VERSION.SDK_INT >= 11 && savedState.cYR && this.cXp == 3 && this.cXr != null) {
            this.cXq = startActionMode((com.baidu.tieba.horizonalList.a.a.b) this.cXr);
        }
        requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onFocusChanged(boolean z, int i2, Rect rect) {
        super.onFocusChanged(z, i2, rect);
        if (z && this.mSelectedPosition < 0 && !isInTouchMode()) {
            if (!this.cYe && this.mAdapter != null) {
                this.mDataChanged = true;
                this.mOldItemCount = this.mItemCount;
                this.mItemCount = this.mAdapter.getCount();
            }
            apE();
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (!this.mBlockLayoutRequests && !this.mInLayout) {
            super.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void resetList() {
        removeAllViewsInLayout();
        this.mFirstPosition = 0;
        this.mDataChanged = false;
        this.cXQ = null;
        this.mNeedSync = false;
        this.cYh = null;
        this.mOldSelectedPosition = -1;
        this.cZg = Long.MIN_VALUE;
        setSelectedPositionInt(-1);
        setNextSelectedPositionInt(-1);
        this.cXI = 0;
        this.cXx = -1;
        this.mSelectorRect.setEmpty();
        invalidate();
    }

    @Override // android.view.View
    protected int computeHorizontalScrollExtent() {
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
                if (width2 > 0) {
                    return i2 - (((right - getWidth()) * 100) / width2);
                }
                return i2;
            }
            return 1;
        }
        return 0;
    }

    @Override // android.view.View
    protected int computeHorizontalScrollOffset() {
        int i2 = 0;
        int i3 = this.mFirstPosition;
        int childCount = getChildCount();
        if (i3 < 0 || childCount <= 0) {
            return 0;
        }
        if (this.mSmoothScrollbarEnabled) {
            View childAt = getChildAt(0);
            int left = childAt.getLeft();
            int width = childAt.getWidth();
            if (width > 0) {
                return Math.max(((i3 * 100) - ((left * 100) / width)) + ((int) ((getScrollX() / getWidth()) * this.mItemCount * 100.0f)), 0);
            }
            return 0;
        }
        int i4 = this.mItemCount;
        if (i3 != 0) {
            i2 = i3 + childCount == i4 ? i4 : (childCount / 2) + i3;
        }
        return (int) (((i2 / i4) * childCount) + i3);
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        if (this.mSmoothScrollbarEnabled) {
            int max = Math.max(this.mItemCount * 100, 0);
            if (getScrollX() != 0) {
                return max + Math.abs((int) ((getScrollX() / getWidth()) * this.mItemCount * 100.0f));
            }
            return max;
        }
        return this.mItemCount;
    }

    @Override // android.view.View
    protected float getLeftFadingEdgeStrength() {
        int childCount = getChildCount();
        float leftFadingEdgeStrength = super.getLeftFadingEdgeStrength();
        if (childCount != 0) {
            if (this.mFirstPosition > 0) {
                return 1.0f;
            }
            int left = getChildAt(0).getLeft();
            return left < getPaddingLeft() ? (-(left - getPaddingLeft())) / getHorizontalFadingEdgeLength() : leftFadingEdgeStrength;
        }
        return leftFadingEdgeStrength;
    }

    @Override // android.view.View
    protected float getRightFadingEdgeStrength() {
        int childCount = getChildCount();
        float rightFadingEdgeStrength = super.getRightFadingEdgeStrength();
        if (childCount != 0) {
            if ((this.mFirstPosition + childCount) - 1 < this.mItemCount - 1) {
                return 1.0f;
            }
            int right = getChildAt(childCount - 1).getRight();
            int width = getWidth();
            return right > width - getPaddingRight() ? ((right - width) + getPaddingRight()) / getHorizontalFadingEdgeLength() : rightFadingEdgeStrength;
        }
        return rightFadingEdgeStrength;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        if (this.mSelector == null) {
            useDefaultSelector();
        }
        Rect rect = this.mListPadding;
        rect.left = this.mSelectionLeftPadding + getPaddingLeft();
        rect.top = this.mSelectionTopPadding + getPaddingTop();
        rect.right = this.mSelectionRightPadding + getPaddingRight();
        rect.bottom = this.mSelectionBottomPadding + getPaddingBottom();
        if (this.mTranscriptMode == 1) {
            int childCount = getChildCount();
            int width = getWidth() - getPaddingRight();
            View childAt = getChildAt(childCount - 1);
            this.cXY = childCount + this.mFirstPosition >= this.cYf && (childAt != null ? childAt.getRight() : width) <= width;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.a, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        this.mInLayout = true;
        if (z) {
            int childCount = getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                getChildAt(i6).forceLayout();
            }
            this.cXy.apK();
        }
        layoutChildren();
        this.mInLayout = false;
        this.cXL = (i4 - i2) / 3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void layoutChildren() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void apv() {
        boolean z = true;
        if (this.cXA != null) {
            boolean z2 = this.mFirstPosition > 0;
            if (!z2 && getChildCount() > 0) {
                z2 = getChildAt(0).getLeft() < this.mListPadding.left;
            }
            this.cXA.setVisibility(z2 ? 0 : 4);
        }
        if (this.cXB != null) {
            int childCount = getChildCount();
            boolean z3 = this.mFirstPosition + childCount < this.mItemCount;
            if (z3 || childCount <= 0) {
                z = z3;
            } else if (getChildAt(childCount - 1).getRight() <= getRight() - this.mListPadding.right) {
                z = false;
            }
            this.cXB.setVisibility(z ? 0 : 4);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.a
    @ViewDebug.ExportedProperty
    public View getSelectedView() {
        if (this.mItemCount <= 0 || this.mSelectedPosition < 0) {
            return null;
        }
        return getChildAt(this.mSelectedPosition - this.mFirstPosition);
    }

    public int getListPaddingTop() {
        return this.mListPadding.top;
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

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002f  */
    @SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View obtainView(int i2, boolean[] zArr) {
        View view;
        f fVar;
        zArr[0] = false;
        View ld = this.cXy.ld(i2);
        if (ld == null) {
            View le = this.cXy.le(i2);
            if (le != null) {
                view = this.mAdapter.getView(i2, le, this);
                if (view != le) {
                    this.cXy.r(le, i2);
                    if (this.mCacheColorHint != 0) {
                        view.setDrawingCacheBackgroundColor(this.mCacheColorHint);
                        ld = view;
                    }
                } else {
                    zArr[0] = true;
                    view.onFinishTemporaryDetach();
                    ld = view;
                }
                if (this.cXw) {
                    ViewGroup.LayoutParams layoutParams = ld.getLayoutParams();
                    if (layoutParams == null) {
                        fVar = (f) generateDefaultLayoutParams();
                    } else if (!checkLayoutParams(layoutParams)) {
                        fVar = (f) generateLayoutParams(layoutParams);
                    } else {
                        fVar = (f) layoutParams;
                    }
                    fVar.cYv = this.mAdapter.getItemId(i2);
                    ld.setLayoutParams(fVar);
                }
                if (this.cZf.isEnabled() && this.cYb == null) {
                    this.cYb = new g();
                }
            } else {
                view = this.mAdapter.getView(i2, null, this);
                if (this.mCacheColorHint != 0) {
                    view.setDrawingCacheBackgroundColor(this.mCacheColorHint);
                }
            }
            ld = view;
            if (this.cXw) {
            }
            if (this.cZf.isEnabled()) {
                this.cYb = new g();
            }
        }
        return ld;
    }

    @TargetApi(14)
    /* loaded from: classes.dex */
    class g extends AccessibilityDelegateCompat {
        g() {
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            int positionForView = AbsHListView.this.getPositionForView(view);
            ListAdapter adapter = AbsHListView.this.getAdapter();
            if (positionForView != -1 && adapter != null && AbsHListView.this.isEnabled() && adapter.isEnabled(positionForView)) {
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
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (super.performAccessibilityAction(view, i, bundle)) {
                return true;
            }
            int positionForView = AbsHListView.this.getPositionForView(view);
            ListAdapter adapter = AbsHListView.this.getAdapter();
            if (positionForView == -1 || adapter == null) {
                return false;
            }
            if (AbsHListView.this.isEnabled() && adapter.isEnabled(positionForView)) {
                long itemIdAtPosition = AbsHListView.this.getItemIdAtPosition(positionForView);
                switch (i) {
                    case 4:
                        if (AbsHListView.this.getSelectedItemPosition() != positionForView) {
                            AbsHListView.this.setSelection(positionForView);
                            return true;
                        }
                        return false;
                    case 8:
                        if (AbsHListView.this.getSelectedItemPosition() == positionForView) {
                            AbsHListView.this.setSelection(-1);
                            return true;
                        }
                        return false;
                    case 16:
                        if (AbsHListView.this.isClickable()) {
                            return AbsHListView.this.performItemClick(view, positionForView, itemIdAtPosition);
                        }
                        return false;
                    case 32:
                        if (AbsHListView.this.isLongClickable()) {
                            return AbsHListView.this.b(view, positionForView, itemIdAtPosition);
                        }
                        return false;
                    default:
                        return false;
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(int i2, View view) {
        if (i2 != -1) {
            this.cXx = i2;
        }
        Rect rect = this.mSelectorRect;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        if (view instanceof m) {
            ((m) view).adjustListItemSelectionBounds(rect);
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

    private void positionSelector(int i2, int i3, int i4, int i5) {
        this.mSelectorRect.set(i2 - this.mSelectionLeftPadding, i3 - this.mSelectionTopPadding, this.mSelectionRightPadding + i4, this.mSelectionBottomPadding + i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        if (getChildCount() > 0) {
            this.mDataChanged = true;
            rememberSyncState();
        }
    }

    boolean touchModeDrawsInPressedState() {
        switch (this.mTouchMode) {
            case 1:
            case 2:
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean shouldShowSelector() {
        return (hasFocus() && !isInTouchMode()) || touchModeDrawsInPressedState();
    }

    private void drawSelector(Canvas canvas) {
        if (!this.mSelectorRect.isEmpty()) {
            Drawable drawable = this.mSelector;
            drawable.setBounds(this.mSelectorRect);
            drawable.draw(canvas);
        }
    }

    public void setDrawSelectorOnTop(boolean z) {
        this.mDrawSelectorOnTop = z;
    }

    public void setSelector(int i2) {
        setSelector(getResources().getDrawable(i2));
    }

    public void setSelector(Drawable drawable) {
        if (this.mSelector != null) {
            this.mSelector.setCallback(null);
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
        apx();
    }

    public Drawable getSelector() {
        return this.mSelector;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void apw() {
        if (isEnabled() && isClickable()) {
            Drawable drawable = this.mSelector;
            Rect rect = this.mSelectorRect;
            if (drawable != null) {
                if ((isFocused() || touchModeDrawsInPressedState()) && !rect.isEmpty()) {
                    View childAt = getChildAt(this.mSelectedPosition - this.mFirstPosition);
                    if (childAt != null) {
                        if (!childAt.hasFocusable()) {
                            childAt.setPressed(true);
                        } else {
                            return;
                        }
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
                    if (isLongClickable && !this.mDataChanged) {
                        if (this.cXN == null) {
                            this.cXN = new b();
                        }
                        this.cXN.apP();
                        postDelayed(this.cXN, ViewConfiguration.getLongPressTimeout());
                    }
                }
            }
        }
    }

    void apx() {
        if (this.mSelector != null) {
            if (shouldShowSelector()) {
                this.mSelector.setState(getDrawableState());
            } else {
                this.mSelector.setState(cYi);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        apx();
    }

    @Override // android.view.ViewGroup, android.view.View
    @SuppressLint({"Override"})
    protected int[] onCreateDrawableState(int i2) {
        if (this.mIsChildViewEnabled) {
            return super.onCreateDrawableState(i2);
        }
        int i3 = ENABLED_STATE_SET[0];
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
            return onCreateDrawableState;
        }
        return onCreateDrawableState;
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return this.mSelector == drawable || super.verifyDrawable(drawable);
    }

    @Override // android.view.ViewGroup, android.view.View
    @TargetApi(11)
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.mSelector != null) {
            this.mSelector.jumpToCurrentState();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnTouchModeChangeListener(this);
        if (this.mAdapter != null && this.cXv == null) {
            this.cXv = new a();
            this.mAdapter.registerDataSetObserver(this.cXv);
            this.mDataChanged = true;
            this.mOldItemCount = this.mItemCount;
            this.mItemCount = this.mAdapter.getCount();
        }
        this.cYe = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.a, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.cXy.clear();
        getViewTreeObserver().removeOnTouchModeChangeListener(this);
        if (this.mAdapter != null && this.cXv != null) {
            this.mAdapter.unregisterDataSetObserver(this.cXv);
            this.cXv = null;
        }
        if (this.cXG != null) {
            removeCallbacks(this.cXG);
        }
        if (this.cXH != null) {
            this.cXH.stop();
        }
        if (this.mClearScrollingCache != null) {
            removeCallbacks(this.mClearScrollingCache);
        }
        if (this.cXO != null) {
            removeCallbacks(this.cXO);
        }
        if (this.cXP != null) {
            removeCallbacks(this.cXP);
            this.cXP = null;
        }
        this.cYe = false;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        int i2 = isInTouchMode() ? 0 : 1;
        if (!z) {
            setChildrenDrawingCacheEnabled(false);
            if (this.cXG != null) {
                removeCallbacks(this.cXG);
                this.cXG.apI();
                if (this.cXH != null) {
                    this.cXH.stop();
                }
                if (getScrollX() != 0) {
                    this.cXo.setScrollX(0);
                    apG();
                    invalidate();
                }
            }
            if (i2 == 1) {
                this.mResurrectToPosition = this.mSelectedPosition;
            }
        } else if (i2 != this.mLastTouchMode && this.mLastTouchMode != -1) {
            if (i2 == 1) {
                apE();
            } else {
                apC();
                this.mLayoutMode = 0;
                layoutChildren();
            }
        }
        this.mLastTouchMode = i2;
    }

    ContextMenu.ContextMenuInfo createContextMenuInfo(View view, int i2, long j2) {
        return new a.ContextMenu$ContextMenuInfoC0090a(view, i2, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class n {
        private int cYV;

        private n() {
        }

        public void apP() {
            this.cYV = AbsHListView.this.getWindowAttachCount();
        }

        public boolean apQ() {
            return AbsHListView.this.hasWindowFocus() && AbsHListView.this.getWindowAttachCount() == this.cYV;
        }
    }

    /* loaded from: classes.dex */
    private class i extends n implements Runnable {
        int cYw;

        private i() {
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            View childAt;
            if (!AbsHListView.this.mDataChanged) {
                ListAdapter listAdapter = AbsHListView.this.mAdapter;
                int i = this.cYw;
                if (listAdapter != null && AbsHListView.this.mItemCount > 0 && i != -1 && i < listAdapter.getCount() && apQ() && (childAt = AbsHListView.this.getChildAt(i - AbsHListView.this.mFirstPosition)) != null) {
                    AbsHListView.this.performItemClick(childAt, i, listAdapter.getItemId(i));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends n implements Runnable {
        private c() {
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            View childAt = AbsHListView.this.getChildAt(AbsHListView.this.mMotionPosition - AbsHListView.this.mFirstPosition);
            if (childAt != null) {
                if ((!apQ() || AbsHListView.this.mDataChanged) ? false : AbsHListView.this.b(childAt, AbsHListView.this.mMotionPosition, AbsHListView.this.mAdapter.getItemId(AbsHListView.this.mMotionPosition))) {
                    AbsHListView.this.mTouchMode = -1;
                    AbsHListView.this.setPressed(false);
                    childAt.setPressed(false);
                    return;
                }
                AbsHListView.this.mTouchMode = 2;
            }
        }
    }

    /* loaded from: classes.dex */
    private class b extends n implements Runnable {
        private b() {
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AbsHListView.this.isPressed() && AbsHListView.this.mSelectedPosition >= 0) {
                View childAt = AbsHListView.this.getChildAt(AbsHListView.this.mSelectedPosition - AbsHListView.this.mFirstPosition);
                if (!AbsHListView.this.mDataChanged) {
                    if (apQ() ? AbsHListView.this.b(childAt, AbsHListView.this.mSelectedPosition, AbsHListView.this.cZe) : false) {
                        AbsHListView.this.setPressed(false);
                        childAt.setPressed(false);
                        return;
                    }
                    return;
                }
                AbsHListView.this.setPressed(false);
                if (childAt != null) {
                    childAt.setPressed(false);
                }
            }
        }
    }

    boolean b(View view, int i2, long j2) {
        if (Build.VERSION.SDK_INT >= 11 && this.cXp == 3) {
            if (this.cXq == null) {
                ActionMode startActionMode = startActionMode((com.baidu.tieba.horizonalList.a.a.b) this.cXr);
                this.cXq = startActionMode;
                if (startActionMode != null) {
                    setItemChecked(i2, true);
                    performHapticFeedback(0);
                }
            }
            return true;
        }
        boolean b2 = this.cZb != null ? this.cZb.b(this, view, i2, j2) : false;
        if (!b2) {
            this.mContextMenuInfo = createContextMenuInfo(view, i2, j2);
            b2 = super.showContextMenuForChild(this);
        }
        if (b2) {
            performHapticFeedback(0);
            return b2;
        }
        return b2;
    }

    @Override // android.view.View
    protected ContextMenu.ContextMenuInfo getContextMenuInfo() {
        return this.mContextMenuInfo;
    }

    public boolean b(float f2, float f3, int i2) {
        int pointToPosition = pointToPosition((int) f2, (int) f3);
        if (pointToPosition != -1) {
            long itemId = this.mAdapter.getItemId(pointToPosition);
            View childAt = getChildAt(pointToPosition - this.mFirstPosition);
            if (childAt != null) {
                this.mContextMenuInfo = createContextMenuInfo(childAt, pointToPosition, itemId);
                return super.showContextMenuForChild(this);
            }
        }
        return b(f2, f3, i2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean showContextMenuForChild(View view) {
        int positionForView = getPositionForView(view);
        if (positionForView >= 0) {
            long itemId = this.mAdapter.getItemId(positionForView);
            boolean b2 = this.cZb != null ? this.cZb.b(this, view, positionForView, itemId) : false;
            if (!b2) {
                this.mContextMenuInfo = createContextMenuInfo(getChildAt(positionForView - this.mFirstPosition), positionForView, itemId);
                return super.showContextMenuForChild(view);
            }
            return b2;
        }
        return false;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        return false;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        switch (i2) {
            case 23:
            case 66:
                if (!isEnabled()) {
                    return true;
                }
                if (isClickable() && isPressed() && this.mSelectedPosition >= 0 && this.mAdapter != null && this.mSelectedPosition < this.mAdapter.getCount()) {
                    View childAt = getChildAt(this.mSelectedPosition - this.mFirstPosition);
                    if (childAt != null) {
                        performItemClick(childAt, this.mSelectedPosition, this.cZe);
                        childAt.setPressed(false);
                    }
                    setPressed(false);
                    return true;
                }
                break;
        }
        return super.onKeyUp(i2, keyEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    public int pointToPosition(int i2, int i3) {
        Rect rect = this.mTouchFrame;
        if (rect == null) {
            this.mTouchFrame = new Rect();
            rect = this.mTouchFrame;
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

    /* loaded from: classes.dex */
    final class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Drawable current;
            if (AbsHListView.this.mTouchMode == 0) {
                AbsHListView.this.mTouchMode = 1;
                View childAt = AbsHListView.this.getChildAt(AbsHListView.this.mMotionPosition - AbsHListView.this.mFirstPosition);
                if (childAt != null && !childAt.hasFocusable()) {
                    AbsHListView.this.mLayoutMode = 0;
                    if (!AbsHListView.this.mDataChanged) {
                        childAt.setPressed(true);
                        AbsHListView.this.setPressed(true);
                        AbsHListView.this.layoutChildren();
                        AbsHListView.this.d(AbsHListView.this.mMotionPosition, childAt);
                        AbsHListView.this.refreshDrawableState();
                        int longPressTimeout = ViewConfiguration.getLongPressTimeout();
                        boolean isLongClickable = AbsHListView.this.isLongClickable();
                        if (AbsHListView.this.mSelector != null && (current = AbsHListView.this.mSelector.getCurrent()) != null && (current instanceof TransitionDrawable)) {
                            if (isLongClickable) {
                                ((TransitionDrawable) current).startTransition(longPressTimeout);
                            } else {
                                ((TransitionDrawable) current).resetTransition();
                            }
                        }
                        if (isLongClickable) {
                            if (AbsHListView.this.cXM == null) {
                                AbsHListView.this.cXM = new c();
                            }
                            AbsHListView.this.cXM.apP();
                            AbsHListView.this.postDelayed(AbsHListView.this.cXM, longPressTimeout);
                            return;
                        }
                        AbsHListView.this.mTouchMode = 2;
                        return;
                    }
                    AbsHListView.this.mTouchMode = 2;
                }
            }
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
                handler.removeCallbacks(this.cXM);
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
            kU(i2);
            return true;
        }
        return false;
    }

    private void kU(int i2) {
        int i3;
        int childCount;
        ViewParent parent;
        int i4 = i2 - this.mMotionX;
        int i5 = i4 - this.mMotionCorrection;
        int i6 = this.cXF != Integer.MIN_VALUE ? i2 - this.cXF : i5;
        if (this.mTouchMode == 3) {
            if (i2 != this.cXF) {
                if (Math.abs(i4) > this.mTouchSlop && (parent = getParent()) != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
                if (this.mMotionPosition >= 0) {
                    childCount = this.mMotionPosition - this.mFirstPosition;
                } else {
                    childCount = getChildCount() / 2;
                }
                View childAt = getChildAt(childCount);
                int left = childAt != null ? childAt.getLeft() : 0;
                boolean trackMotionScroll = i6 != 0 ? trackMotionScroll(i5, i6) : false;
                View childAt2 = getChildAt(childCount);
                if (childAt2 != null) {
                    int left2 = childAt2.getLeft();
                    if (trackMotionScroll) {
                        int i7 = (-i6) - (left2 - left);
                        overScrollBy(i7, 0, getScrollX(), 0, 0, 0, this.cXS, 0, true);
                        if (Math.abs(this.cXS) == Math.abs(getScrollX()) && this.mVelocityTracker != null) {
                            this.mVelocityTracker.clear();
                        }
                        int overScrollMode = getOverScrollMode();
                        if (overScrollMode == 0 || (overScrollMode == 1 && !apu())) {
                            this.mDirection = 0;
                            this.mTouchMode = 5;
                            if (i4 > 0) {
                                this.cXU.onPull(i7 / getWidth());
                                if (!this.cXV.isFinished()) {
                                    this.cXV.onRelease();
                                }
                                invalidate();
                            } else if (i4 < 0) {
                                this.cXV.onPull(i7 / getWidth());
                                if (!this.cXU.isFinished()) {
                                    this.cXU.onRelease();
                                }
                                invalidate();
                            }
                        }
                    }
                    this.mMotionX = i2;
                }
                this.cXF = i2;
            }
        } else if (this.mTouchMode == 5 && i2 != this.cXF) {
            int scrollX = getScrollX();
            int i8 = scrollX - i6;
            int i9 = i2 > this.cXF ? 1 : -1;
            if (this.mDirection == 0) {
                this.mDirection = i9;
            }
            int i10 = -i6;
            if ((i8 >= 0 || scrollX < 0) && (i8 <= 0 || scrollX > 0)) {
                i3 = 0;
            } else {
                i10 = -scrollX;
                i3 = i6 + i10;
            }
            if (i10 != 0) {
                overScrollBy(i10, 0, getScrollX(), 0, 0, 0, this.cXS, 0, true);
                int overScrollMode2 = getOverScrollMode();
                if (overScrollMode2 == 0 || (overScrollMode2 == 1 && !apu())) {
                    if (i4 > 0) {
                        this.cXU.onPull(i10 / getWidth());
                        if (!this.cXV.isFinished()) {
                            this.cXV.onRelease();
                        }
                        invalidate();
                    } else if (i4 < 0) {
                        this.cXV.onPull(i10 / getWidth());
                        if (!this.cXU.isFinished()) {
                            this.cXU.onRelease();
                        }
                        invalidate();
                    }
                }
            }
            if (i3 != 0) {
                if (getScrollX() != 0) {
                    this.cXo.setScrollX(0);
                    apy();
                }
                trackMotionScroll(i3, i3);
                this.mTouchMode = 3;
                int kX = kX(i2);
                this.mMotionCorrection = 0;
                View childAt3 = getChildAt(kX - this.mFirstPosition);
                this.cXD = childAt3 != null ? childAt3.getLeft() : 0;
                this.mMotionX = i2;
                this.mMotionPosition = kX;
            }
            this.cXF = i2;
            this.mDirection = i9;
        }
    }

    @TargetApi(11)
    protected void apy() {
        if (this.cXo.isHardwareAccelerated() && (getParent() instanceof View)) {
            ((View) getParent()).invalidate();
        }
    }

    @Override // android.view.ViewTreeObserver.OnTouchModeChangeListener
    public void onTouchModeChanged(boolean z) {
        if (z) {
            apC();
            if (getWidth() > 0 && getChildCount() > 0) {
                layoutChildren();
            }
            apx();
            return;
        }
        int i2 = this.mTouchMode;
        if (i2 == 5 || i2 == 6) {
            if (this.cXG != null) {
                this.cXG.apI();
            }
            if (this.cXH != null) {
                this.cXH.stop();
            }
            if (getScrollX() != 0) {
                this.cXo.setScrollX(0);
                apG();
                invalidate();
            }
        }
    }

    @TargetApi(14)
    protected boolean r(MotionEvent motionEvent) {
        return Build.VERSION.SDK_INT >= 14 && (motionEvent.getButtonState() & 2) != 0 && b(motionEvent.getX(), motionEvent.getY(), motionEvent.getMetaState());
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0086  */
    @Override // android.view.View
    @SuppressLint({"Override"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        Drawable current;
        int i2;
        int i3 = 0;
        if (!isEnabled()) {
            return isClickable() || isLongClickable();
        }
        if (this.cXH != null) {
            this.cXH.stop();
        }
        if (this.cYe) {
            int action = motionEvent.getAction();
            apA();
            this.mVelocityTracker.addMovement(motionEvent);
            switch (action & MotionEventCompat.ACTION_MASK) {
                case 0:
                    switch (this.mTouchMode) {
                        case 6:
                            this.cXG.apI();
                            if (this.cXH != null) {
                                this.cXH.stop();
                            }
                            this.mTouchMode = 5;
                            this.mMotionY = (int) motionEvent.getY();
                            int x = (int) motionEvent.getX();
                            this.cXF = x;
                            this.mMotionX = x;
                            this.mMotionCorrection = 0;
                            this.mActivePointerId = motionEvent.getPointerId(0);
                            this.mDirection = 0;
                            break;
                        default:
                            this.mActivePointerId = motionEvent.getPointerId(0);
                            int x2 = (int) motionEvent.getX();
                            int y = (int) motionEvent.getY();
                            int pointToPosition = pointToPosition(x2, y);
                            if (!this.mDataChanged) {
                                if (this.mTouchMode != 4 && pointToPosition >= 0 && getAdapter().isEnabled(pointToPosition)) {
                                    this.mTouchMode = 0;
                                    if (this.mPendingCheckForTap == null) {
                                        this.mPendingCheckForTap = new d();
                                    }
                                    postDelayed(this.mPendingCheckForTap, ViewConfiguration.getTapTimeout());
                                    i2 = pointToPosition;
                                } else if (this.mTouchMode == 4) {
                                    createScrollingCache();
                                    this.mTouchMode = 3;
                                    this.mMotionCorrection = 0;
                                    i2 = kW(x2);
                                    this.cXG.apJ();
                                }
                                if (i2 >= 0) {
                                    this.cXD = getChildAt(i2 - this.mFirstPosition).getLeft();
                                }
                                this.mMotionX = x2;
                                this.mMotionY = y;
                                this.mMotionPosition = i2;
                                this.cXF = ExploreByTouchHelper.INVALID_ID;
                                break;
                            }
                            i2 = pointToPosition;
                            if (i2 >= 0) {
                            }
                            this.mMotionX = x2;
                            this.mMotionY = y;
                            this.mMotionPosition = i2;
                            this.cXF = ExploreByTouchHelper.INVALID_ID;
                    }
                    if (r(motionEvent) && this.mTouchMode == 0) {
                        removeCallbacks(this.mPendingCheckForTap);
                        return true;
                    }
                    return true;
                case 1:
                    switch (this.mTouchMode) {
                        case 0:
                        case 1:
                        case 2:
                            int i4 = this.mMotionPosition;
                            final View childAt = getChildAt(i4 - this.mFirstPosition);
                            float x3 = motionEvent.getX();
                            boolean z = x3 > ((float) this.mListPadding.left) && x3 < ((float) (getWidth() - this.mListPadding.right));
                            if (childAt != null && !childAt.hasFocusable() && z) {
                                if (this.mTouchMode != 0) {
                                    childAt.setPressed(false);
                                }
                                if (this.cXO == null) {
                                    this.cXO = new i();
                                }
                                final i iVar = this.cXO;
                                iVar.cYw = i4;
                                iVar.apP();
                                this.mResurrectToPosition = i4;
                                if (this.mTouchMode == 0 || this.mTouchMode == 1) {
                                    Handler handler = getHandler();
                                    if (handler != null) {
                                        handler.removeCallbacks(this.mTouchMode == 0 ? this.mPendingCheckForTap : this.cXM);
                                    }
                                    this.mLayoutMode = 0;
                                    if (!this.mDataChanged && this.mAdapter.isEnabled(i4)) {
                                        this.mTouchMode = 1;
                                        setSelectedPositionInt(this.mMotionPosition);
                                        layoutChildren();
                                        childAt.setPressed(true);
                                        d(this.mMotionPosition, childAt);
                                        setPressed(true);
                                        if (this.mSelector != null && (current = this.mSelector.getCurrent()) != null && (current instanceof TransitionDrawable)) {
                                            ((TransitionDrawable) current).resetTransition();
                                        }
                                        if (this.cXP != null) {
                                            removeCallbacks(this.cXP);
                                        }
                                        this.cXP = new Runnable() { // from class: com.baidu.tieba.horizonalList.widget.AbsHListView.1
                                            @Override // java.lang.Runnable
                                            public void run() {
                                                AbsHListView.this.mTouchMode = -1;
                                                childAt.setPressed(false);
                                                AbsHListView.this.setPressed(false);
                                                if (!AbsHListView.this.mDataChanged) {
                                                    iVar.run();
                                                }
                                            }
                                        };
                                        postDelayed(this.cXP, ViewConfiguration.getPressedStateDuration());
                                        return true;
                                    }
                                    this.mTouchMode = -1;
                                    apx();
                                    return true;
                                } else if (!this.mDataChanged && this.mAdapter.isEnabled(i4)) {
                                    iVar.run();
                                }
                            }
                            this.mTouchMode = -1;
                            apx();
                            break;
                        case 3:
                            int childCount = getChildCount();
                            if (childCount > 0) {
                                int left = getChildAt(0).getLeft();
                                int right = getChildAt(childCount - 1).getRight();
                                int i5 = this.mListPadding.left;
                                int width = getWidth() - this.mListPadding.right;
                                if (this.mFirstPosition == 0 && left >= i5 && this.mFirstPosition + childCount < this.mItemCount && right <= getWidth() - width) {
                                    this.mTouchMode = -1;
                                    reportScrollStateChange(0);
                                    break;
                                } else {
                                    VelocityTracker velocityTracker = this.mVelocityTracker;
                                    velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                                    int xVelocity = (int) (velocityTracker.getXVelocity(this.mActivePointerId) * this.cXR);
                                    if (Math.abs(xVelocity) > this.mMinimumVelocity && ((this.mFirstPosition != 0 || left != i5 - this.cXS) && (childCount + this.mFirstPosition != this.mItemCount || right != this.cXS + width))) {
                                        if (this.cXG == null) {
                                            this.cXG = new e();
                                        }
                                        reportScrollStateChange(2);
                                        this.cXG.start(-xVelocity);
                                        break;
                                    } else {
                                        this.mTouchMode = -1;
                                        reportScrollStateChange(0);
                                        if (this.cXG != null) {
                                            this.cXG.apI();
                                        }
                                        if (this.cXH != null) {
                                            this.cXH.stop();
                                            break;
                                        }
                                    }
                                }
                            } else {
                                this.mTouchMode = -1;
                                reportScrollStateChange(0);
                                break;
                            }
                            break;
                        case 5:
                            if (this.cXG == null) {
                                this.cXG = new e();
                            }
                            VelocityTracker velocityTracker2 = this.mVelocityTracker;
                            velocityTracker2.computeCurrentVelocity(1000, this.mMaximumVelocity);
                            int xVelocity2 = (int) velocityTracker2.getXVelocity(this.mActivePointerId);
                            reportScrollStateChange(2);
                            if (Math.abs(xVelocity2) > this.mMinimumVelocity) {
                                this.cXG.kY(-xVelocity2);
                                break;
                            } else {
                                this.cXG.apH();
                                break;
                            }
                    }
                    setPressed(false);
                    if (this.cXU != null) {
                        this.cXU.onRelease();
                        this.cXV.onRelease();
                    }
                    invalidate();
                    Handler handler2 = getHandler();
                    if (handler2 != null) {
                        handler2.removeCallbacks(this.cXM);
                    }
                    apB();
                    this.mActivePointerId = -1;
                    return true;
                case 2:
                    int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                    if (findPointerIndex == -1) {
                        this.mActivePointerId = motionEvent.getPointerId(0);
                    } else {
                        i3 = findPointerIndex;
                    }
                    int x4 = (int) motionEvent.getX(i3);
                    if (this.mDataChanged) {
                        layoutChildren();
                    }
                    switch (this.mTouchMode) {
                        case 0:
                        case 1:
                        case 2:
                            startScrollIfNeeded(x4);
                            return true;
                        case 3:
                        case 5:
                            kU(x4);
                            return true;
                        case 4:
                        default:
                            return true;
                    }
                case 3:
                    switch (this.mTouchMode) {
                        case 5:
                            if (this.cXG == null) {
                                this.cXG = new e();
                            }
                            this.cXG.apH();
                            break;
                        case 6:
                            break;
                        default:
                            this.mTouchMode = -1;
                            setPressed(false);
                            View childAt2 = getChildAt(this.mMotionPosition - this.mFirstPosition);
                            if (childAt2 != null) {
                                childAt2.setPressed(false);
                            }
                            clearScrollingCache();
                            Handler handler3 = getHandler();
                            if (handler3 != null) {
                                handler3.removeCallbacks(this.cXM);
                            }
                            apB();
                            break;
                    }
                    if (this.cXU != null) {
                        this.cXU.onRelease();
                        this.cXV.onRelease();
                    }
                    this.mActivePointerId = -1;
                    return true;
                case 4:
                default:
                    return true;
                case 5:
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
                        this.cXD = getChildAt(pointToPosition2 - this.mFirstPosition).getLeft();
                        this.mMotionPosition = pointToPosition2;
                    }
                    this.cXF = x5;
                    return true;
                case 6:
                    onSecondaryPointerUp(motionEvent);
                    int i6 = this.mMotionX;
                    int pointToPosition3 = pointToPosition(i6, this.mMotionY);
                    if (pointToPosition3 >= 0) {
                        this.cXD = getChildAt(pointToPosition3 - this.mFirstPosition).getLeft();
                        this.mMotionPosition = pointToPosition3;
                    }
                    this.cXF = i6;
                    return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    protected void onOverScrolled(int i2, int i3, boolean z, boolean z2) {
        if (getScrollX() != i2) {
            onScrollChanged(i2, getScrollY(), getScrollX(), getScrollY());
            this.cXo.setScrollX(i2);
            apy();
            awakenScrollBars();
        }
    }

    @Override // android.view.View
    @TargetApi(12)
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) != 0) {
            switch (motionEvent.getAction()) {
                case 8:
                    if (this.mTouchMode == -1) {
                        float axisValue = motionEvent.getAxisValue(10);
                        if (axisValue != 0.0f) {
                            int horizontalScrollFactor = (int) (axisValue * getHorizontalScrollFactor());
                            if (!trackMotionScroll(horizontalScrollFactor, horizontalScrollFactor)) {
                                return true;
                            }
                        }
                    }
                    break;
            }
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    protected float getHorizontalScrollFactor() {
        if (this.cYj == 0.0f) {
            TypedValue typedValue = new TypedValue();
            if (getContext().getTheme().resolveAttribute(d.c.hlv_listPreferredItemWidth, typedValue, true)) {
                this.cYj = typedValue.getDimension(getContext().getResources().getDisplayMetrics());
            }
        }
        return this.cYj;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.cXU != null) {
            int scrollX = getScrollX();
            if (!this.cXU.isFinished()) {
                int save = canvas.save();
                int i2 = this.mListPadding.top + this.cXZ;
                int height = (getHeight() - i2) - (this.mListPadding.bottom + this.cYa);
                int min = Math.min(0, this.cXW + scrollX);
                canvas.rotate(-90.0f);
                canvas.translate(i2 + (-getHeight()), min);
                this.cXU.setSize(height, height);
                if (this.cXU.draw(canvas)) {
                    invalidate();
                }
                canvas.restoreToCount(save);
            }
            if (!this.cXV.isFinished()) {
                int save2 = canvas.save();
                int i3 = this.mListPadding.left + this.cXZ;
                int height2 = (getHeight() - i3) - (this.mListPadding.right + this.cYa);
                int max = Math.max(getWidth(), scrollX + this.cXX);
                canvas.rotate(90.0f);
                canvas.translate(-i3, -max);
                this.cXV.setSize(height2, height2);
                if (this.cXV.draw(canvas)) {
                    invalidate();
                }
                canvas.restoreToCount(save2);
            }
        }
    }

    private void apz() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        } else {
            this.mVelocityTracker.clear();
        }
    }

    private void apA() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
    }

    private void apB() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            apB();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.cXH != null) {
            this.cXH.stop();
        }
        if (this.cYe) {
            switch (action & MotionEventCompat.ACTION_MASK) {
                case 0:
                    int i2 = this.mTouchMode;
                    if (i2 == 6 || i2 == 5) {
                        this.mMotionCorrection = 0;
                        return true;
                    }
                    int x = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();
                    this.mActivePointerId = motionEvent.getPointerId(0);
                    int kW = kW(x);
                    if (i2 != 4 && kW >= 0) {
                        this.cXD = getChildAt(kW - this.mFirstPosition).getLeft();
                        this.mMotionX = x;
                        this.mMotionY = y;
                        this.mMotionPosition = kW;
                        this.mTouchMode = 0;
                        clearScrollingCache();
                    }
                    this.cXF = ExploreByTouchHelper.INVALID_ID;
                    apz();
                    this.mVelocityTracker.addMovement(motionEvent);
                    return i2 == 4;
                case 1:
                case 3:
                    this.mTouchMode = -1;
                    this.mActivePointerId = -1;
                    apB();
                    reportScrollStateChange(0);
                    return false;
                case 2:
                    switch (this.mTouchMode) {
                        case 0:
                            int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                            if (findPointerIndex == -1) {
                                this.mActivePointerId = motionEvent.getPointerId(0);
                                findPointerIndex = 0;
                            }
                            apA();
                            this.mVelocityTracker.addMovement(motionEvent);
                            return startScrollIfNeeded((int) motionEvent.getX(findPointerIndex));
                        default:
                            return false;
                    }
                case 4:
                case 5:
                default:
                    return false;
                case 6:
                    onSecondaryPointerUp(motionEvent);
                    return false;
            }
        }
        return false;
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        int action = (motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
        if (motionEvent.getPointerId(action) == this.mActivePointerId) {
            int i2 = action == 0 ? 1 : 0;
            this.mMotionX = (int) motionEvent.getX(i2);
            this.mMotionY = (int) motionEvent.getY(i2);
            this.mMotionCorrection = 0;
            this.mActivePointerId = motionEvent.getPointerId(i2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        int childCount = getChildCount();
        int i2 = this.mFirstPosition;
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter != null) {
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (listAdapter.isEnabled(i2 + i3)) {
                    arrayList.add(childAt);
                }
                childAt.addTouchables(arrayList);
            }
        }
    }

    void reportScrollStateChange(int i2) {
        if (i2 != this.mLastScrollState && this.cXK != null) {
            this.mLastScrollState = i2;
            this.cXK.a(this, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e implements Runnable {
        private final com.baidu.tieba.horizonalList.widget.g cYn;
        private int cYo;
        private final Runnable cYp = new Runnable() { // from class: com.baidu.tieba.horizonalList.widget.AbsHListView.e.1
            @Override // java.lang.Runnable
            public void run() {
                int i = AbsHListView.this.mActivePointerId;
                VelocityTracker velocityTracker = AbsHListView.this.mVelocityTracker;
                com.baidu.tieba.horizonalList.widget.g gVar = e.this.cYn;
                if (velocityTracker != null && i != -1) {
                    velocityTracker.computeCurrentVelocity(1000, AbsHListView.this.mMaximumVelocity);
                    float f = -velocityTracker.getXVelocity(i);
                    if (Math.abs(f) >= AbsHListView.this.mMinimumVelocity && gVar.k(f, 0.0f)) {
                        AbsHListView.this.postDelayed(this, 40L);
                        return;
                    }
                    e.this.apI();
                    AbsHListView.this.mTouchMode = 3;
                    AbsHListView.this.reportScrollStateChange(1);
                }
            }
        };

        e() {
            this.cYn = new com.baidu.tieba.horizonalList.widget.g(AbsHListView.this.getContext());
        }

        void start(int i) {
            int i2 = i < 0 ? Integer.MAX_VALUE : 0;
            this.cYo = i2;
            this.cYn.setInterpolator(null);
            this.cYn.fling(i2, 0, i, 0, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
            AbsHListView.this.mTouchMode = 4;
            AbsHListView.this.cXo.k(this);
        }

        void apH() {
            if (this.cYn.springBack(AbsHListView.this.getScrollX(), 0, 0, 0, 0, 0)) {
                AbsHListView.this.mTouchMode = 6;
                AbsHListView.this.invalidate();
                AbsHListView.this.cXo.k(this);
                return;
            }
            AbsHListView.this.mTouchMode = -1;
            AbsHListView.this.reportScrollStateChange(0);
        }

        void kY(int i) {
            this.cYn.setInterpolator(null);
            this.cYn.fling(AbsHListView.this.getScrollX(), 0, i, 0, ExploreByTouchHelper.INVALID_ID, Integer.MAX_VALUE, 0, 0, AbsHListView.this.getWidth(), 0);
            AbsHListView.this.mTouchMode = 6;
            AbsHListView.this.invalidate();
            AbsHListView.this.cXo.k(this);
        }

        void kZ(int i) {
            this.cYn.notifyHorizontalEdgeReached(AbsHListView.this.getScrollX(), 0, AbsHListView.this.cXT);
            int overScrollMode = AbsHListView.this.getOverScrollMode();
            if (overScrollMode == 0 || (overScrollMode == 1 && !AbsHListView.this.apu())) {
                AbsHListView.this.mTouchMode = 6;
                int currVelocity = (int) this.cYn.getCurrVelocity();
                if (i > 0) {
                    AbsHListView.this.cXU.onAbsorb(currVelocity);
                } else {
                    AbsHListView.this.cXV.onAbsorb(currVelocity);
                }
            } else {
                AbsHListView.this.mTouchMode = -1;
                if (AbsHListView.this.cXH != null) {
                    AbsHListView.this.cXH.stop();
                }
            }
            AbsHListView.this.invalidate();
            AbsHListView.this.cXo.k(this);
        }

        void f(int i, int i2, boolean z) {
            int i3 = i < 0 ? Integer.MAX_VALUE : 0;
            this.cYo = i3;
            this.cYn.setInterpolator(z ? AbsHListView.cYg : null);
            this.cYn.startScroll(i3, 0, i, 0, i2);
            AbsHListView.this.mTouchMode = 4;
            AbsHListView.this.cXo.k(this);
        }

        void apI() {
            AbsHListView.this.mTouchMode = -1;
            AbsHListView.this.removeCallbacks(this);
            AbsHListView.this.removeCallbacks(this.cYp);
            AbsHListView.this.reportScrollStateChange(0);
            AbsHListView.this.clearScrollingCache();
            this.cYn.abortAnimation();
            AbsHListView.this.overScrollBy(0, 0, 0, 0, 0, 0, 0, 0, false);
        }

        void apJ() {
            AbsHListView.this.postDelayed(this.cYp, 40L);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // java.lang.Runnable
        public void run() {
            int max;
            boolean z = true;
            boolean z2 = false;
            switch (AbsHListView.this.mTouchMode) {
                case 3:
                    if (this.cYn.isFinished()) {
                        return;
                    }
                    break;
                case 4:
                    break;
                case 5:
                default:
                    apI();
                    return;
                case 6:
                    com.baidu.tieba.horizonalList.widget.g gVar = this.cYn;
                    if (gVar.computeScrollOffset()) {
                        int scrollX = AbsHListView.this.getScrollX();
                        int currX = gVar.getCurrX();
                        if (AbsHListView.this.overScrollBy(currX - scrollX, 0, scrollX, 0, 0, 0, AbsHListView.this.cXT, 0, false)) {
                            boolean z3 = scrollX <= 0 && currX > 0;
                            if (scrollX >= 0 && currX < 0) {
                                z2 = true;
                            }
                            if (z3 || z2) {
                                int currVelocity = (int) gVar.getCurrVelocity();
                                if (z2) {
                                    currVelocity = -currVelocity;
                                }
                                gVar.abortAnimation();
                                start(currVelocity);
                                return;
                            }
                            apH();
                            return;
                        }
                        AbsHListView.this.invalidate();
                        AbsHListView.this.cXo.k(this);
                        return;
                    }
                    apI();
                    return;
            }
            if (AbsHListView.this.mDataChanged) {
                AbsHListView.this.layoutChildren();
            }
            if (AbsHListView.this.mItemCount == 0 || AbsHListView.this.getChildCount() == 0) {
                apI();
                return;
            }
            com.baidu.tieba.horizonalList.widget.g gVar2 = this.cYn;
            boolean computeScrollOffset = gVar2.computeScrollOffset();
            int currX2 = gVar2.getCurrX();
            int i = this.cYo - currX2;
            if (i > 0) {
                AbsHListView.this.mMotionPosition = AbsHListView.this.mFirstPosition;
                AbsHListView.this.cXD = AbsHListView.this.getChildAt(0).getLeft();
                max = Math.min(((AbsHListView.this.getWidth() - AbsHListView.this.getPaddingRight()) - AbsHListView.this.getPaddingLeft()) - 1, i);
            } else {
                int childCount = AbsHListView.this.getChildCount() - 1;
                AbsHListView.this.mMotionPosition = AbsHListView.this.mFirstPosition + childCount;
                AbsHListView.this.cXD = AbsHListView.this.getChildAt(childCount).getLeft();
                max = Math.max(-(((AbsHListView.this.getWidth() - AbsHListView.this.getPaddingRight()) - AbsHListView.this.getPaddingLeft()) - 1), i);
            }
            View childAt = AbsHListView.this.getChildAt(AbsHListView.this.mMotionPosition - AbsHListView.this.mFirstPosition);
            int left = childAt != null ? childAt.getLeft() : 0;
            boolean trackMotionScroll = AbsHListView.this.trackMotionScroll(max, max);
            if (!trackMotionScroll || max == 0) {
                z = false;
            }
            if (z) {
                if (childAt != null) {
                    AbsHListView.this.overScrollBy(-(max - (childAt.getLeft() - left)), 0, AbsHListView.this.getScrollX(), 0, 0, 0, AbsHListView.this.cXT, 0, false);
                }
                if (computeScrollOffset) {
                    kZ(max);
                }
            } else if (computeScrollOffset && !z) {
                if (trackMotionScroll) {
                    AbsHListView.this.invalidate();
                }
                this.cYo = currX2;
                AbsHListView.this.cXo.k(this);
            } else {
                apI();
            }
        }
    }

    /* loaded from: classes.dex */
    public class j implements Runnable {
        private int cYA;
        private final int cYB;
        private int cYC;
        private int cYx;
        private int cYy;
        private int cYz;
        private int mMode;

        j() {
            this.cYB = ViewConfiguration.get(AbsHListView.this.getContext()).getScaledFadingEdgeLength();
        }

        void start(int i) {
            stop();
            int childCount = (AbsHListView.this.getChildCount() + AbsHListView.this.mFirstPosition) - 1;
            if (i < AbsHListView.this.mFirstPosition) {
                this.mMode = 2;
            } else if (i > childCount) {
                this.mMode = 1;
            } else {
                w(i, -1, 200);
                return;
            }
            this.cYA = 200;
            this.cYx = i;
            this.cYy = -1;
            this.cYz = -1;
            AbsHListView.this.cXo.k(this);
        }

        void aJ(final int i, final int i2) {
            int i3;
            int i4;
            stop();
            if (i2 == -1) {
                start(i);
            } else if (AbsHListView.this.mDataChanged) {
                AbsHListView.this.cXQ = new Runnable() { // from class: com.baidu.tieba.horizonalList.widget.AbsHListView.j.1
                    @Override // java.lang.Runnable
                    public void run() {
                        j.this.aJ(i, i2);
                    }
                };
            } else {
                int childCount = AbsHListView.this.getChildCount();
                if (childCount != 0) {
                    int i5 = AbsHListView.this.mFirstPosition;
                    int i6 = (childCount + i5) - 1;
                    int max = Math.max(0, Math.min(AbsHListView.this.getCount() - 1, i));
                    if (max < i5) {
                        int i7 = i6 - i2;
                        if (i7 >= 1) {
                            i3 = (i5 - max) + 1;
                            i4 = i7 - 1;
                            if (i4 < i3) {
                                this.mMode = 4;
                            } else {
                                this.mMode = 2;
                                i4 = i3;
                            }
                        } else {
                            return;
                        }
                    } else if (max > i6) {
                        int i8 = i2 - i5;
                        if (i8 >= 1) {
                            i3 = (max - i6) + 1;
                            i4 = i8 - 1;
                            if (i4 < i3) {
                                this.mMode = 3;
                            } else {
                                this.mMode = 1;
                                i4 = i3;
                            }
                        } else {
                            return;
                        }
                    } else {
                        w(max, i2, 200);
                        return;
                    }
                    if (i4 > 0) {
                        this.cYA = 200 / i4;
                    } else {
                        this.cYA = 200;
                    }
                    this.cYx = max;
                    this.cYy = i2;
                    this.cYz = -1;
                    AbsHListView.this.cXo.k(this);
                }
            }
        }

        void w(int i, int i2, int i3) {
            int i4 = AbsHListView.this.mFirstPosition;
            int childCount = (AbsHListView.this.getChildCount() + i4) - 1;
            int i5 = AbsHListView.this.mListPadding.left;
            int width = AbsHListView.this.getWidth() - AbsHListView.this.mListPadding.right;
            i2 = (i2 < i4 || i2 > childCount) ? -1 : -1;
            View childAt = AbsHListView.this.getChildAt(i - i4);
            int left = childAt.getLeft();
            int right = childAt.getRight();
            int i6 = right > width ? right - width : 0;
            if (left < i5) {
                i6 = left - i5;
            }
            if (i6 != 0) {
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
        }

        public void stop() {
            AbsHListView.this.removeCallbacks(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            int left;
            int i = 0;
            int width = AbsHListView.this.getWidth();
            int i2 = AbsHListView.this.mFirstPosition;
            switch (this.mMode) {
                case 1:
                    int childCount = AbsHListView.this.getChildCount() - 1;
                    if (childCount >= 0) {
                        int i3 = i2 + childCount;
                        View childAt = AbsHListView.this.getChildAt(childCount);
                        AbsHListView.this.e((i3 < AbsHListView.this.mItemCount + (-1) ? Math.max(AbsHListView.this.mListPadding.right, this.cYB) : AbsHListView.this.mListPadding.right) + (childAt.getWidth() - (width - childAt.getLeft())), this.cYA, true);
                        this.cYz = i3;
                        if (i3 < this.cYx) {
                            AbsHListView.this.cXo.k(this);
                            return;
                        }
                        return;
                    }
                    return;
                case 2:
                    if (i2 == this.cYz) {
                        AbsHListView.this.cXo.k(this);
                        return;
                    }
                    View childAt2 = AbsHListView.this.getChildAt(0);
                    if (childAt2 != null) {
                        AbsHListView.this.e(childAt2.getLeft() - (i2 > 0 ? Math.max(this.cYB, AbsHListView.this.mListPadding.left) : AbsHListView.this.mListPadding.left), this.cYA, true);
                        this.cYz = i2;
                        if (i2 > this.cYx) {
                            AbsHListView.this.cXo.k(this);
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    int childCount2 = AbsHListView.this.getChildCount();
                    if (i2 != this.cYy && childCount2 > 1 && childCount2 + i2 < AbsHListView.this.mItemCount) {
                        int i4 = i2 + 1;
                        if (i4 == this.cYz) {
                            AbsHListView.this.cXo.k(this);
                            return;
                        }
                        View childAt3 = AbsHListView.this.getChildAt(1);
                        int width2 = childAt3.getWidth();
                        int left2 = childAt3.getLeft();
                        int max = Math.max(AbsHListView.this.mListPadding.right, this.cYB);
                        if (i4 < this.cYy) {
                            AbsHListView.this.e(Math.max(0, (left2 + width2) - max), this.cYA, true);
                            this.cYz = i4;
                            AbsHListView.this.cXo.k(this);
                            return;
                        } else if (left2 > max) {
                            AbsHListView.this.e(left2 - max, this.cYA, true);
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                case 4:
                    int childCount3 = AbsHListView.this.getChildCount() - 2;
                    if (childCount3 >= 0) {
                        int i5 = i2 + childCount3;
                        if (i5 == this.cYz) {
                            AbsHListView.this.cXo.k(this);
                            return;
                        }
                        View childAt4 = AbsHListView.this.getChildAt(childCount3);
                        int width3 = childAt4.getWidth();
                        int left3 = childAt4.getLeft();
                        int i6 = width - left3;
                        int max2 = Math.max(AbsHListView.this.mListPadding.left, this.cYB);
                        this.cYz = i5;
                        if (i5 > this.cYy) {
                            AbsHListView.this.e(-(i6 - max2), this.cYA, true);
                            AbsHListView.this.cXo.k(this);
                            return;
                        }
                        int i7 = width - max2;
                        int i8 = left3 + width3;
                        if (i7 > i8) {
                            AbsHListView.this.e(-(i7 - i8), this.cYA, true);
                            return;
                        }
                        return;
                    }
                    return;
                case 5:
                    if (this.cYz == i2) {
                        AbsHListView.this.cXo.k(this);
                        return;
                    }
                    this.cYz = i2;
                    int childCount4 = AbsHListView.this.getChildCount();
                    int i9 = this.cYx;
                    int i10 = (i2 + childCount4) - 1;
                    if (i9 < i2) {
                        i = (i2 - i9) + 1;
                    } else if (i9 > i10) {
                        i = i9 - i10;
                    }
                    float min = Math.min(Math.abs(i / childCount4), 1.0f);
                    if (i9 < i2) {
                        AbsHListView.this.e((int) ((-AbsHListView.this.getWidth()) * min), (int) (min * this.cYA), true);
                        AbsHListView.this.cXo.k(this);
                        return;
                    } else if (i9 > i10) {
                        AbsHListView.this.e((int) (AbsHListView.this.getWidth() * min), (int) (min * this.cYA), true);
                        AbsHListView.this.cXo.k(this);
                        return;
                    } else {
                        AbsHListView.this.e(AbsHListView.this.getChildAt(i9 - i2).getLeft() - this.cYC, (int) (this.cYA * (Math.abs(left) / AbsHListView.this.getWidth())), true);
                        return;
                    }
                default:
                    return;
            }
        }
    }

    public void setFriction(float f2) {
        if (this.cXG == null) {
            this.cXG = new e();
        }
        this.cXG.cYn.setFriction(f2);
    }

    public void setVelocityScale(float f2) {
        this.cXR = f2;
    }

    public void smoothScrollToPosition(int i2, int i3) {
        if (this.cXH == null) {
            this.cXH = new j();
        }
        this.cXH.aJ(i2, i3);
    }

    public void smoothScrollBy(int i2, int i3) {
        e(i2, i3, false);
    }

    public void e(int i2, int i3, boolean z) {
        if (this.cXG == null) {
            this.cXG = new e();
        }
        int i4 = this.mFirstPosition;
        int childCount = getChildCount();
        int i5 = i4 + childCount;
        int paddingLeft = getPaddingLeft();
        int width = getWidth() - getPaddingRight();
        if (i2 == 0 || this.mItemCount == 0 || childCount == 0 || ((i4 == 0 && getChildAt(0).getLeft() == paddingLeft && i2 < 0) || (i5 == this.mItemCount && getChildAt(childCount - 1).getRight() == width && i2 > 0))) {
            this.cXG.apI();
            if (this.cXH != null) {
                this.cXH.stop();
                return;
            }
            return;
        }
        reportScrollStateChange(2);
        this.cXG.f(i2, i3, z);
    }

    private void createScrollingCache() {
        if (this.mScrollingCacheEnabled && !this.mCachingStarted && !this.cXo.isHardwareAccelerated()) {
            setChildrenDrawnWithCacheEnabled(true);
            setChildrenDrawingCacheEnabled(true);
            this.cXC = true;
            this.mCachingStarted = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearScrollingCache() {
        if (!this.cXo.isHardwareAccelerated()) {
            if (this.mClearScrollingCache == null) {
                this.mClearScrollingCache = new Runnable() { // from class: com.baidu.tieba.horizonalList.widget.AbsHListView.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AbsHListView.this.mCachingStarted) {
                            AbsHListView absHListView = AbsHListView.this;
                            AbsHListView.this.cXC = false;
                            absHListView.mCachingStarted = false;
                            AbsHListView.this.setChildrenDrawnWithCacheEnabled(false);
                            if ((AbsHListView.this.getPersistentDrawingCache() & 2) == 0) {
                                AbsHListView.this.setChildrenDrawingCacheEnabled(false);
                            }
                            if (!AbsHListView.this.isAlwaysDrawnWithCacheEnabled()) {
                                AbsHListView.this.invalidate();
                            }
                        }
                    }
                };
            }
            post(this.mClearScrollingCache);
        }
    }

    boolean trackMotionScroll(int i2, int i3) {
        int min;
        int min2;
        int i4;
        int childCount = getChildCount();
        if (childCount == 0) {
            return true;
        }
        int left = getChildAt(0).getLeft();
        int right = getChildAt(childCount - 1).getRight();
        Rect rect = this.mListPadding;
        int i5 = 0 - left;
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
        int i6 = this.mFirstPosition;
        if (i6 == 0) {
            this.cXW = left - rect.left;
        } else {
            this.cXW += min2;
        }
        if (i6 + childCount == this.mItemCount) {
            this.cXX = rect.right + right;
        } else {
            this.cXX += min2;
        }
        boolean z = i6 == 0 && left >= rect.left && min2 >= 0;
        boolean z2 = i6 + childCount == this.mItemCount && right <= getWidth() - rect.right && min2 <= 0;
        if (z || z2) {
            return min2 != 0;
        }
        boolean z3 = min2 < 0;
        boolean isInTouchMode = isInTouchMode();
        if (isInTouchMode) {
            apC();
        }
        int headerViewsCount = getHeaderViewsCount();
        int footerViewsCount = this.mItemCount - getFooterViewsCount();
        int i7 = 0;
        if (z3) {
            int i8 = -min2;
            i4 = 0;
            int i9 = 0;
            while (i9 < childCount) {
                View childAt = getChildAt(i9);
                if (childAt.getRight() >= i8) {
                    break;
                }
                int i10 = i4 + 1;
                int i11 = i6 + i9;
                if (i11 >= headerViewsCount && i11 < footerViewsCount) {
                    this.cXy.r(childAt, i11);
                }
                i9++;
                i4 = i10;
            }
        } else {
            int width3 = getWidth() - min2;
            i4 = 0;
            for (int i12 = childCount - 1; i12 >= 0; i12--) {
                View childAt2 = getChildAt(i12);
                if (childAt2.getLeft() <= width3) {
                    break;
                }
                int i13 = i4 + 1;
                int i14 = i6 + i12;
                if (i14 >= headerViewsCount && i14 < footerViewsCount) {
                    this.cXy.r(childAt2, i14);
                }
                i4 = i13;
                i7 = i12;
            }
        }
        this.cXE = this.cXD + min;
        this.mBlockLayoutRequests = true;
        if (i4 > 0) {
            detachViewsFromParent(i7, i4);
            this.cXy.apM();
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        kV(min2);
        if (z3) {
            this.mFirstPosition = i4 + this.mFirstPosition;
        }
        int abs = Math.abs(min2);
        if (i5 < abs || width < abs) {
            fillGap(z3);
        }
        if (!isInTouchMode && this.mSelectedPosition != -1) {
            int i15 = this.mSelectedPosition - this.mFirstPosition;
            if (i15 >= 0 && i15 < getChildCount()) {
                d(this.mSelectedPosition, getChildAt(i15));
            }
        } else if (this.cXx != -1) {
            int i16 = this.cXx - this.mFirstPosition;
            if (i16 >= 0 && i16 < getChildCount()) {
                d(-1, getChildAt(i16));
            }
        } else {
            this.mSelectorRect.setEmpty();
        }
        this.mBlockLayoutRequests = false;
        invokeOnItemScrollListener();
        return false;
    }

    public void kV(int i2) {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            getChildAt(i3).offsetLeftAndRight(i2);
        }
    }

    protected int getHeaderViewsCount() {
        return 0;
    }

    protected int getFooterViewsCount() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void apC() {
        if (this.mSelectedPosition != -1) {
            if (this.mLayoutMode != 4) {
                this.mResurrectToPosition = this.mSelectedPosition;
            }
            if (this.cZc >= 0 && this.cZc != this.mSelectedPosition) {
                this.mResurrectToPosition = this.cZc;
            }
            setSelectedPositionInt(-1);
            setNextSelectedPositionInt(-1);
            this.cXI = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int reconcileSelectedPosition() {
        int i2 = this.mSelectedPosition;
        if (i2 < 0) {
            i2 = this.mResurrectToPosition;
        }
        return Math.min(Math.max(0, i2), this.mItemCount - 1);
    }

    protected int kX(int i2) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return -1;
        }
        int kW = kW(i2);
        return kW == -1 ? (this.mFirstPosition + childCount) - 1 : kW;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean apD() {
        if (this.mSelectedPosition >= 0 || !apE()) {
            return false;
        }
        apx();
        return true;
    }

    boolean apE() {
        int i2;
        boolean z;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int childCount = getChildCount();
        if (childCount <= 0) {
            return false;
        }
        int i9 = this.mListPadding.left;
        int right = (getRight() - getLeft()) - this.mListPadding.right;
        int i10 = this.mFirstPosition;
        int i11 = this.mResurrectToPosition;
        if (i11 >= i10 && i11 < i10 + childCount) {
            View childAt = getChildAt(i11 - this.mFirstPosition);
            int left = childAt.getLeft();
            int right2 = childAt.getRight();
            if (left < i9) {
                left = getHorizontalFadingEdgeLength() + i9;
            } else if (right2 > right) {
                left = (right - childAt.getMeasuredWidth()) - getHorizontalFadingEdgeLength();
            }
            i2 = left;
            z = true;
        } else if (i11 >= i10) {
            int i12 = this.mItemCount;
            int i13 = (i10 + childCount) - 1;
            int i14 = childCount - 1;
            i2 = 0;
            while (true) {
                if (i14 < 0) {
                    i11 = i13;
                    z = false;
                    break;
                }
                View childAt2 = getChildAt(i14);
                int left2 = childAt2.getLeft();
                int right3 = childAt2.getRight();
                if (i14 != childCount - 1) {
                    int i15 = right;
                    i3 = i2;
                    i4 = i15;
                } else if (i10 + childCount < i12 || right3 > right) {
                    i4 = right - getHorizontalFadingEdgeLength();
                    i3 = left2;
                } else {
                    i4 = right;
                    i3 = left2;
                }
                if (right3 > i4) {
                    i14--;
                    int i16 = i4;
                    i2 = i3;
                    right = i16;
                } else {
                    i2 = left2;
                    i11 = i10 + i14;
                    z = false;
                    break;
                }
            }
        } else {
            int i17 = 0;
            int i18 = 0;
            while (true) {
                if (i17 >= childCount) {
                    i5 = i18;
                    i6 = i10;
                    break;
                }
                i5 = getChildAt(i17).getLeft();
                if (i17 != 0) {
                    int i19 = i9;
                    i7 = i18;
                    i8 = i19;
                } else if (i10 > 0 || i5 < i9) {
                    i8 = getHorizontalFadingEdgeLength() + i9;
                    i7 = i5;
                } else {
                    i8 = i9;
                    i7 = i5;
                }
                if (i5 >= i8) {
                    i6 = i10 + i17;
                    break;
                }
                i17++;
                int i20 = i8;
                i18 = i7;
                i9 = i20;
            }
            i2 = i5;
            i11 = i6;
            z = true;
        }
        this.mResurrectToPosition = -1;
        removeCallbacks(this.cXG);
        if (this.cXH != null) {
            this.cXH.stop();
        }
        this.mTouchMode = -1;
        clearScrollingCache();
        this.cYW = i2;
        int lookForSelectablePosition = lookForSelectablePosition(i11, z);
        if (lookForSelectablePosition < i10 || lookForSelectablePosition > getLastVisiblePosition()) {
            lookForSelectablePosition = -1;
        } else {
            this.mLayoutMode = 4;
            apx();
            setSelectionInt(lookForSelectablePosition);
            invokeOnItemScrollListener();
        }
        reportScrollStateChange(0);
        return lookForSelectablePosition >= 0;
    }

    void apF() {
        boolean z;
        this.cXt.clear();
        int i2 = 0;
        boolean z2 = false;
        while (i2 < this.cXu.size()) {
            long keyAt = this.cXu.keyAt(i2);
            int intValue = this.cXu.valueAt(i2).intValue();
            if (keyAt != this.mAdapter.getItemId(intValue)) {
                int max = Math.max(0, intValue - 20);
                int min = Math.min(intValue + 20, this.mItemCount);
                while (true) {
                    if (max >= min) {
                        z = false;
                        break;
                    } else if (keyAt != this.mAdapter.getItemId(max)) {
                        max++;
                    } else {
                        this.cXt.put(max, true);
                        this.cXu.setValueAt(i2, Integer.valueOf(max));
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    this.cXu.delete(keyAt);
                    int i3 = i2 - 1;
                    this.cXs--;
                    if (Build.VERSION.SDK_INT > 11 && this.cXq != null && this.cXr != null) {
                        ((com.baidu.tieba.horizonalList.a.a.b) this.cXr).onItemCheckedStateChanged((ActionMode) this.cXq, intValue, keyAt, false);
                    }
                    i2 = i3;
                    z2 = true;
                }
            } else {
                this.cXt.put(intValue, true);
            }
            z2 = z2;
            i2++;
        }
        if (z2 && this.cXq != null && Build.VERSION.SDK_INT > 11) {
            ((ActionMode) this.cXq).invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.a
    public void handleDataChanged() {
        int i2 = this.mItemCount;
        int i3 = this.cYf;
        this.cYf = this.mItemCount;
        if (this.cXp != 0 && this.mAdapter != null && this.mAdapter.hasStableIds()) {
            apF();
        }
        this.cXy.apL();
        if (i2 > 0) {
            if (this.mNeedSync) {
                this.mNeedSync = false;
                this.cYh = null;
                if (this.mTranscriptMode == 2) {
                    this.mLayoutMode = 3;
                    return;
                }
                if (this.mTranscriptMode == 1) {
                    if (this.cXY) {
                        this.cXY = false;
                        this.mLayoutMode = 3;
                        return;
                    }
                    int childCount = getChildCount();
                    int width = getWidth() - getPaddingRight();
                    View childAt = getChildAt(childCount - 1);
                    int bottom = childAt != null ? childAt.getBottom() : width;
                    if (childCount + this.mFirstPosition >= i3 && bottom <= width) {
                        this.mLayoutMode = 3;
                        return;
                    }
                    awakenScrollBars();
                }
                switch (this.mSyncMode) {
                    case 1:
                        this.mLayoutMode = 5;
                        this.mSyncPosition = Math.min(Math.max(0, this.mSyncPosition), i2 - 1);
                        return;
                    case 0:
                        if (isInTouchMode()) {
                            this.mLayoutMode = 5;
                            this.mSyncPosition = Math.min(Math.max(0, this.mSyncPosition), i2 - 1);
                            return;
                        }
                        int findSyncPosition = findSyncPosition();
                        if (findSyncPosition >= 0 && lookForSelectablePosition(findSyncPosition, true) == findSyncPosition) {
                            this.mSyncPosition = findSyncPosition;
                            if (this.cYY == getWidth()) {
                                this.mLayoutMode = 5;
                            } else {
                                this.mLayoutMode = 2;
                            }
                            setNextSelectedPositionInt(findSyncPosition);
                            return;
                        }
                        break;
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
        this.mLayoutMode = this.cXJ ? 3 : 1;
        this.mSelectedPosition = -1;
        this.cZe = Long.MIN_VALUE;
        this.cZc = -1;
        this.cZd = Long.MIN_VALUE;
        this.mNeedSync = false;
        this.cYh = null;
        this.cXx = -1;
        checkSelectionChanged();
    }

    public static int getDistance(Rect rect, Rect rect2, int i2) {
        int width;
        int height;
        int width2;
        int height2;
        switch (i2) {
            case 1:
            case 2:
                width = rect.right + (rect.width() / 2);
                height = rect.top + (rect.height() / 2);
                width2 = (rect2.width() / 2) + rect2.left;
                height2 = rect2.top + (rect2.height() / 2);
                break;
            case 17:
                width = rect.left;
                height = rect.top + (rect.height() / 2);
                width2 = rect2.right;
                height2 = rect2.top + (rect2.height() / 2);
                break;
            case 33:
                width = rect.left + (rect.width() / 2);
                height = rect.top;
                width2 = (rect2.width() / 2) + rect2.left;
                height2 = rect2.bottom;
                break;
            case 66:
                width = rect.right;
                height = rect.top + (rect.height() / 2);
                width2 = rect2.left;
                height2 = rect2.top + (rect2.height() / 2);
                break;
            case TransportMediator.KEYCODE_MEDIA_RECORD /* 130 */:
                width = rect.left + (rect.width() / 2);
                height = rect.bottom;
                width2 = (rect2.width() / 2) + rect2.left;
                height2 = rect2.top;
                break;
            default:
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT, FOCUS_FORWARD, FOCUS_BACKWARD}.");
        }
        int i3 = width2 - width;
        int i4 = height2 - height;
        return (i4 * i4) + (i3 * i3);
    }

    @Override // android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return null;
    }

    @Override // android.view.View
    public boolean checkInputConnectionProxy(View view) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new f(-2, -1, 0);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new f(layoutParams);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    /* renamed from: f */
    public f generateLayoutParams(AttributeSet attributeSet) {
        return new f(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof f;
    }

    public void setTranscriptMode(int i2) {
        this.mTranscriptMode = i2;
    }

    public int getTranscriptMode() {
        return this.mTranscriptMode;
    }

    @Override // android.view.View
    public int getSolidColor() {
        return this.mCacheColorHint;
    }

    public void setCacheColorHint(int i2) {
        if (i2 != this.mCacheColorHint) {
            this.mCacheColorHint = i2;
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                getChildAt(i3).setDrawingCacheBackgroundColor(i2);
            }
            this.cXy.setCacheColorHint(i2);
        }
    }

    @ViewDebug.ExportedProperty(category = "drawing")
    public int getCacheColorHint() {
        return this.mCacheColorHint;
    }

    private void apG() {
        if (this.cXU != null) {
            this.cXU.finish();
            this.cXV.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aI(int i2, int i3) {
    }

    public void setRecyclerListener(l lVar) {
        this.cXy.cYF = lVar;
    }

    /* loaded from: classes.dex */
    public class a extends com.baidu.tieba.horizonalList.widget.a<ListAdapter>.b {
        public a() {
            super();
        }

        @Override // com.baidu.tieba.horizonalList.widget.a.b, android.database.DataSetObserver
        public void onChanged() {
            super.onChanged();
        }

        @Override // com.baidu.tieba.horizonalList.widget.a.b, android.database.DataSetObserver
        public void onInvalidated() {
            super.onInvalidated();
        }
    }

    /* loaded from: classes.dex */
    public static class f extends ViewGroup.LayoutParams {
        public int cYr;
        public boolean cYs;
        public boolean cYt;
        public int cYu;
        public long cYv;

        public f(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.cYv = -1L;
        }

        public f(int i, int i2) {
            super(i, i2);
            this.cYv = -1L;
        }

        public f(int i, int i2, int i3) {
            super(i, i2);
            this.cYv = -1L;
            this.cYr = i3;
        }

        public f(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.cYv = -1L;
        }
    }

    /* loaded from: classes.dex */
    public class k {
        private l cYF;
        private int cYG;
        private View[] cYH = new View[0];
        private ArrayList<View>[] cYI;
        private int cYJ;
        private ArrayList<View> cYK;
        private ArrayList<View> cYL;
        private SparseArrayCompat<View> cYM;

        public k() {
        }

        public void la(int i) {
            if (i < 1) {
                throw new IllegalArgumentException("Can't have a viewTypeCount < 1");
            }
            ArrayList<View>[] arrayListArr = new ArrayList[i];
            for (int i2 = 0; i2 < i; i2++) {
                arrayListArr[i2] = new ArrayList<>();
            }
            this.cYJ = i;
            this.cYK = arrayListArr[0];
            this.cYI = arrayListArr;
        }

        public void apK() {
            if (this.cYJ == 1) {
                ArrayList<View> arrayList = this.cYK;
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    arrayList.get(i).forceLayout();
                }
            } else {
                int i2 = this.cYJ;
                for (int i3 = 0; i3 < i2; i3++) {
                    ArrayList<View> arrayList2 = this.cYI[i3];
                    int size2 = arrayList2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        arrayList2.get(i4).forceLayout();
                    }
                }
            }
            if (this.cYM != null) {
                int size3 = this.cYM.size();
                for (int i5 = 0; i5 < size3; i5++) {
                    this.cYM.valueAt(i5).forceLayout();
                }
            }
        }

        public boolean lb(int i) {
            return i >= 0;
        }

        public void clear() {
            if (this.cYJ == 1) {
                ArrayList<View> arrayList = this.cYK;
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    AbsHListView.this.removeDetachedView(arrayList.remove((size - 1) - i), false);
                }
            } else {
                int i2 = this.cYJ;
                for (int i3 = 0; i3 < i2; i3++) {
                    ArrayList<View> arrayList2 = this.cYI[i3];
                    int size2 = arrayList2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        AbsHListView.this.removeDetachedView(arrayList2.remove((size2 - 1) - i4), false);
                    }
                }
            }
            if (this.cYM != null) {
                this.cYM.clear();
            }
        }

        public void aK(int i, int i2) {
            if (this.cYH.length < i) {
                this.cYH = new View[i];
            }
            this.cYG = i2;
            View[] viewArr = this.cYH;
            for (int i3 = 0; i3 < i; i3++) {
                View childAt = AbsHListView.this.getChildAt(i3);
                f fVar = (f) childAt.getLayoutParams();
                if (fVar != null && fVar.cYr != -2) {
                    viewArr[i3] = childAt;
                }
            }
        }

        public View lc(int i) {
            int i2 = i - this.cYG;
            View[] viewArr = this.cYH;
            if (i2 < 0 || i2 >= viewArr.length) {
                return null;
            }
            View view = viewArr[i2];
            viewArr[i2] = null;
            return view;
        }

        View ld(int i) {
            int indexOfKey;
            if (this.cYM != null && (indexOfKey = this.cYM.indexOfKey(i)) >= 0) {
                View valueAt = this.cYM.valueAt(indexOfKey);
                this.cYM.removeAt(indexOfKey);
                return valueAt;
            }
            return null;
        }

        void apL() {
            if (this.cYM != null) {
                this.cYM.clear();
            }
        }

        View le(int i) {
            if (this.cYJ == 1) {
                return AbsHListView.a(this.cYK, i);
            }
            int itemViewType = AbsHListView.this.mAdapter.getItemViewType(i);
            if (itemViewType >= 0 && itemViewType < this.cYI.length) {
                return AbsHListView.a(this.cYI[itemViewType], i);
            }
            return null;
        }

        @SuppressLint({"NewApi"})
        public void r(View view, int i) {
            f fVar = (f) view.getLayoutParams();
            if (fVar != null) {
                fVar.cYu = i;
                int i2 = fVar.cYr;
                if (!lb(i2)) {
                    if (i2 != -2) {
                        if (this.cYL == null) {
                            this.cYL = new ArrayList<>();
                        }
                        this.cYL.add(view);
                        return;
                    }
                    return;
                }
                view.onStartTemporaryDetach();
                if (this.cYJ == 1) {
                    this.cYK.add(view);
                } else {
                    this.cYI[i2].add(view);
                }
                if (Build.VERSION.SDK_INT >= 14) {
                    view.setAccessibilityDelegate(null);
                }
                if (this.cYF != null) {
                    this.cYF.onMovedToScrapHeap(view);
                }
            }
        }

        public void apM() {
            if (this.cYL != null) {
                int size = this.cYL.size();
                for (int i = 0; i < size; i++) {
                    AbsHListView.this.removeDetachedView(this.cYL.get(i), false);
                }
                this.cYL.clear();
            }
        }

        @SuppressLint({"NewApi"})
        public void apN() {
            View[] viewArr = this.cYH;
            boolean z = this.cYF != null;
            boolean z2 = this.cYJ > 1;
            ArrayList<View> arrayList = this.cYK;
            for (int length = viewArr.length - 1; length >= 0; length--) {
                View view = viewArr[length];
                if (view != null) {
                    f fVar = (f) view.getLayoutParams();
                    int i = fVar.cYr;
                    viewArr[length] = null;
                    if (!lb(i)) {
                        if (i != -2) {
                            AbsHListView.this.removeDetachedView(view, false);
                        }
                    } else {
                        if (z2) {
                            arrayList = this.cYI[i];
                        }
                        view.onStartTemporaryDetach();
                        fVar.cYu = this.cYG + length;
                        arrayList.add(view);
                        if (Build.VERSION.SDK_INT >= 14) {
                            view.setAccessibilityDelegate(null);
                        }
                        if (z) {
                            this.cYF.onMovedToScrapHeap(view);
                        }
                    }
                }
            }
            apO();
        }

        @SuppressLint({"NewApi"})
        private void apO() {
            int length = this.cYH.length;
            int i = this.cYJ;
            ArrayList<View>[] arrayListArr = this.cYI;
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
            if (this.cYM != null) {
                for (int i6 = 0; i6 < this.cYM.size(); i6++) {
                    this.cYM.valueAt(i6);
                }
            }
        }

        void setCacheColorHint(int i) {
            View[] viewArr;
            if (this.cYJ == 1) {
                ArrayList<View> arrayList = this.cYK;
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    arrayList.get(i2).setDrawingCacheBackgroundColor(i);
                }
            } else {
                int i3 = this.cYJ;
                for (int i4 = 0; i4 < i3; i4++) {
                    ArrayList<View> arrayList2 = this.cYI[i4];
                    int size2 = arrayList2.size();
                    for (int i5 = 0; i5 < size2; i5++) {
                        arrayList2.get(i5).setDrawingCacheBackgroundColor(i);
                    }
                }
            }
            for (View view : this.cYH) {
                if (view != null) {
                    view.setDrawingCacheBackgroundColor(i);
                }
            }
        }
    }

    static View a(ArrayList<View> arrayList, int i2) {
        int size = arrayList.size();
        if (size > 0) {
            for (int i3 = 0; i3 < size; i3++) {
                View view = arrayList.get(i3);
                if (((f) view.getLayoutParams()).cYu == i2) {
                    arrayList.remove(i3);
                    return view;
                }
            }
            return arrayList.remove(size - 1);
        }
        return null;
    }
}
