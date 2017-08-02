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
    static final Interpolator cUO = new LinearInterpolator();
    public static final int[] cUQ = {0};
    b.a cTW;
    protected int cTX;
    public Object cTY;
    Object cTZ;
    int cUA;
    int cUB;
    private EdgeEffectCompat cUC;
    private EdgeEffectCompat cUD;
    private int cUE;
    private int cUF;
    private boolean cUG;
    private int cUH;
    private int cUI;
    private g cUJ;
    private int cUK;
    private int cUL;
    protected boolean cUM;
    private int cUN;
    private SavedState cUP;
    private float cUR;
    int cUa;
    protected SparseArrayCompat<Boolean> cUb;
    LongSparseArray<Integer> cUc;
    protected a cUd;
    boolean cUe;
    int cUf;
    protected final k cUg;
    protected int cUh;
    View cUi;
    View cUj;
    protected boolean cUk;
    int cUl;
    int cUm;
    int cUn;
    private e cUo;
    protected j cUp;
    protected int cUq;
    protected boolean cUr;
    private h cUs;
    protected int cUt;
    private c cUu;
    private b cUv;
    private i cUw;
    private Runnable cUx;
    protected Runnable cUy;
    private float cUz;
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

    protected abstract int kN(int i2);

    public abstract void setSelectionInt(int i2);

    public AbsHListView(Context context) {
        super(context);
        this.cTX = 0;
        this.mLayoutMode = 0;
        this.mDrawSelectorOnTop = false;
        this.cUf = -1;
        this.mSelectorRect = new Rect();
        this.cUg = new k();
        this.mSelectionLeftPadding = 0;
        this.mSelectionTopPadding = 0;
        this.mSelectionRightPadding = 0;
        this.mSelectionBottomPadding = 0;
        this.mListPadding = new Rect();
        this.cUh = 0;
        this.mTouchMode = -1;
        this.cUq = 0;
        this.mSmoothScrollbarEnabled = true;
        this.mResurrectToPosition = -1;
        this.mContextMenuInfo = null;
        this.mLastTouchMode = -1;
        this.mLastScrollState = 0;
        this.cUz = 1.0f;
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
        this.cTX = 0;
        this.mLayoutMode = 0;
        this.mDrawSelectorOnTop = false;
        this.cUf = -1;
        this.mSelectorRect = new Rect();
        this.cUg = new k();
        this.mSelectionLeftPadding = 0;
        this.mSelectionTopPadding = 0;
        this.mSelectionRightPadding = 0;
        this.mSelectionBottomPadding = 0;
        this.mListPadding = new Rect();
        this.cUh = 0;
        this.mTouchMode = -1;
        this.cUq = 0;
        this.mSmoothScrollbarEnabled = true;
        this.mResurrectToPosition = -1;
        this.mContextMenuInfo = null;
        this.mLastTouchMode = -1;
        this.mLastScrollState = 0;
        this.cUz = 1.0f;
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
        this.cUA = viewConfiguration.getScaledOverscrollDistance();
        this.cUB = viewConfiguration.getScaledOverflingDistance();
        this.cTW = com.baidu.tieba.horizonalList.a.b.ax(this);
    }

    @Override // android.view.View
    public void setOverScrollMode(int i2) {
        if (i2 != 2) {
            if (this.cUC == null) {
                Context context = getContext();
                this.cUC = new EdgeEffectCompat(context);
                this.cUD = new EdgeEffectCompat(context);
            }
        } else {
            this.cUC = null;
            this.cUD = null;
        }
        super.setOverScrollMode(i2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.horizonalList.widget.a
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            this.cUe = this.mAdapter.hasStableIds();
            if (this.cTX != 0 && this.cUe && this.cUc == null) {
                this.cUc = new LongSparseArray<>();
            }
        }
        if (this.cUb != null) {
            this.cUb.clear();
        }
        if (this.cUc != null) {
            this.cUc.clear();
        }
    }

    public int getCheckedItemCount() {
        return this.cUa;
    }

    public boolean isItemChecked(int i2) {
        if (this.cTX == 0 || this.cUb == null) {
            return false;
        }
        return this.cUb.get(i2, false).booleanValue();
    }

    public int getCheckedItemPosition() {
        if (this.cTX == 1 && this.cUb != null && this.cUb.size() == 1) {
            return this.cUb.keyAt(0);
        }
        return -1;
    }

    public SparseArrayCompat<Boolean> getCheckedItemPositions() {
        if (this.cTX != 0) {
            return this.cUb;
        }
        return null;
    }

    public long[] getCheckedItemIds() {
        if (this.cTX == 0 || this.cUc == null || this.mAdapter == null) {
            return new long[0];
        }
        LongSparseArray<Integer> longSparseArray = this.cUc;
        int size = longSparseArray.size();
        long[] jArr = new long[size];
        for (int i2 = 0; i2 < size; i2++) {
            jArr[i2] = longSparseArray.keyAt(i2);
        }
        return jArr;
    }

    public void clearChoices() {
        if (this.cUb != null) {
            this.cUb.clear();
        }
        if (this.cUc != null) {
            this.cUc.clear();
        }
        this.cUa = 0;
    }

    public void setItemChecked(int i2, boolean z) {
        if (this.cTX != 0) {
            if (Build.VERSION.SDK_INT >= 11 && z && this.cTX == 3 && this.cTY == null) {
                if (this.cTZ == null || !((com.baidu.tieba.horizonalList.a.a.b) this.cTZ).aoz()) {
                    throw new IllegalStateException("AbsListView: attempted to start selection mode for CHOICE_MODE_MULTIPLE_MODAL but no choice mode callback was supplied. Call setMultiChoiceModeListener to set a callback.");
                }
                this.cTY = startActionMode((com.baidu.tieba.horizonalList.a.a.b) this.cTZ);
            }
            if (this.cTX == 2 || (Build.VERSION.SDK_INT >= 11 && this.cTX == 3)) {
                boolean booleanValue = this.cUb.get(i2, false).booleanValue();
                this.cUb.put(i2, Boolean.valueOf(z));
                if (this.cUc != null && this.mAdapter.hasStableIds()) {
                    if (z) {
                        this.cUc.put(this.mAdapter.getItemId(i2), Integer.valueOf(i2));
                    } else {
                        this.cUc.delete(this.mAdapter.getItemId(i2));
                    }
                }
                if (booleanValue != z) {
                    if (z) {
                        this.cUa++;
                    } else {
                        this.cUa--;
                    }
                }
                if (this.cTY != null) {
                    ((com.baidu.tieba.horizonalList.a.a.b) this.cTZ).onItemCheckedStateChanged((ActionMode) this.cTY, i2, this.mAdapter.getItemId(i2), z);
                }
            } else {
                boolean z2 = this.cUc != null && this.mAdapter.hasStableIds();
                if (z || isItemChecked(i2)) {
                    this.cUb.clear();
                    if (z2) {
                        this.cUc.clear();
                    }
                }
                if (z) {
                    this.cUb.put(i2, true);
                    if (z2) {
                        this.cUc.put(this.mAdapter.getItemId(i2), Integer.valueOf(i2));
                    }
                    this.cUa = 1;
                } else if (this.cUb.size() == 0 || !this.cUb.valueAt(0).booleanValue()) {
                    this.cUa = 0;
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
        if (this.cTX != 0) {
            if (this.cTX == 2 || (Build.VERSION.SDK_INT >= 11 && this.cTX == 3 && this.cTY != null)) {
                boolean z5 = !this.cUb.get(i2, false).booleanValue();
                this.cUb.put(i2, Boolean.valueOf(z5));
                if (this.cUc != null && this.mAdapter.hasStableIds()) {
                    if (z5) {
                        this.cUc.put(this.mAdapter.getItemId(i2), Integer.valueOf(i2));
                    } else {
                        this.cUc.delete(this.mAdapter.getItemId(i2));
                    }
                }
                if (z5) {
                    this.cUa++;
                } else {
                    this.cUa--;
                }
                if (this.cTY != null) {
                    ((com.baidu.tieba.horizonalList.a.a.b) this.cTZ).onItemCheckedStateChanged((ActionMode) this.cTY, i2, j2, z5);
                } else {
                    z4 = true;
                }
                z2 = z4;
                z4 = true;
            } else if (this.cTX == 1) {
                if (!this.cUb.get(i2, false).booleanValue()) {
                    this.cUb.clear();
                    this.cUb.put(i2, true);
                    if (this.cUc != null && this.mAdapter.hasStableIds()) {
                        this.cUc.clear();
                        this.cUc.put(this.mAdapter.getItemId(i2), Integer.valueOf(i2));
                    }
                    this.cUa = 1;
                } else if (this.cUb.size() == 0 || !this.cUb.valueAt(0).booleanValue()) {
                    this.cUa = 0;
                }
                z4 = true;
                z2 = true;
            } else {
                z2 = true;
            }
            if (z4) {
                aoA();
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

    private void aoA() {
        int i2 = this.mFirstPosition;
        int childCount = getChildCount();
        boolean z = Build.VERSION.SDK_INT >= 11;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            int i4 = i2 + i3;
            if (childAt instanceof Checkable) {
                ((Checkable) childAt).setChecked(this.cUb.get(i4, false).booleanValue());
            } else if (z) {
                childAt.setActivated(this.cUb.get(i4, false).booleanValue());
            }
        }
    }

    public int getChoiceMode() {
        return this.cTX;
    }

    @TargetApi(11)
    public void setChoiceMode(int i2) {
        this.cTX = i2;
        if (Build.VERSION.SDK_INT >= 11 && this.cTY != null) {
            if (Build.VERSION.SDK_INT >= 11) {
                ((ActionMode) this.cTY).finish();
            }
            this.cTY = null;
        }
        if (this.cTX != 0) {
            if (this.cUb == null) {
                this.cUb = new SparseArrayCompat<>();
            }
            if (this.cUc == null && this.mAdapter != null && this.mAdapter.hasStableIds()) {
                this.cUc = new LongSparseArray<>();
            }
            if (Build.VERSION.SDK_INT >= 11 && this.cTX == 3) {
                clearChoices();
                setLongClickable(true);
            }
        }
    }

    @TargetApi(11)
    public void setMultiChoiceModeListener(com.baidu.tieba.horizonalList.a.a.a aVar) {
        if (Build.VERSION.SDK_INT >= 11) {
            if (this.cTZ == null) {
                this.cTZ = new com.baidu.tieba.horizonalList.a.a.b(this);
            }
            ((com.baidu.tieba.horizonalList.a.a.b) this.cTZ).a(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aoB() {
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
        this.cUs = hVar;
        invokeOnItemScrollListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void invokeOnItemScrollListener() {
        if (this.cUs != null) {
            this.cUs.a(this, this.mFirstPosition, getChildCount(), this.mItemCount);
        }
        onScrollChanged(0, 0, 0, 0);
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEvent(int i2) {
        if (i2 == 4096) {
            int firstVisiblePosition = getFirstVisiblePosition();
            int lastVisiblePosition = getLastVisiblePosition();
            if (this.cUK != firstVisiblePosition || this.cUL != lastVisiblePosition) {
                this.cUK = firstVisiblePosition;
                this.cUL = lastVisiblePosition;
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
        if (this.cUr != z) {
            this.cUr = z;
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
            /* renamed from: l */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: kW */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int cVA;
        SparseArrayCompat<Boolean> cVB;
        LongSparseArray<Integer> cVC;
        long cVv;
        long cVw;
        int cVx;
        String cVy;
        boolean cVz;
        int position;
        int width;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.cVv = parcel.readLong();
            this.cVw = parcel.readLong();
            this.cVx = parcel.readInt();
            this.position = parcel.readInt();
            this.width = parcel.readInt();
            this.cVy = parcel.readString();
            this.cVz = parcel.readByte() != 0;
            this.cVA = parcel.readInt();
            this.cVB = k(parcel);
            this.cVC = j(parcel);
        }

        private LongSparseArray<Integer> j(Parcel parcel) {
            int readInt = parcel.readInt();
            if (readInt <= 0) {
                return null;
            }
            LongSparseArray<Integer> longSparseArray = new LongSparseArray<>(readInt);
            a(longSparseArray, parcel, readInt);
            return longSparseArray;
        }

        private SparseArrayCompat<Boolean> k(Parcel parcel) {
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
            parcel.writeLong(this.cVv);
            parcel.writeLong(this.cVw);
            parcel.writeInt(this.cVx);
            parcel.writeInt(this.position);
            parcel.writeInt(this.width);
            parcel.writeString(this.cVy);
            parcel.writeByte((byte) (this.cVz ? 1 : 0));
            parcel.writeInt(this.cVA);
            a(this.cVB, parcel);
            a(this.cVC, parcel);
        }

        public String toString() {
            return "AbsListView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " selectedId=" + this.cVv + " firstId=" + this.cVw + " viewLeft=" + this.cVx + " position=" + this.position + " width=" + this.width + " filter=" + this.cVy + " checkState=" + this.cVB + "}";
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        boolean z = true;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.cUP != null) {
            savedState.cVv = this.cUP.cVv;
            savedState.cVw = this.cUP.cVw;
            savedState.cVx = this.cUP.cVx;
            savedState.position = this.cUP.position;
            savedState.width = this.cUP.width;
            savedState.cVy = this.cUP.cVy;
            savedState.cVz = this.cUP.cVz;
            savedState.cVA = this.cUP.cVA;
            savedState.cVB = this.cUP.cVB;
            savedState.cVC = this.cUP.cVC;
            return savedState;
        }
        boolean z2 = getChildCount() > 0 && this.mItemCount > 0;
        long selectedItemId = getSelectedItemId();
        savedState.cVv = selectedItemId;
        savedState.width = getWidth();
        if (selectedItemId >= 0) {
            savedState.cVx = this.cUq;
            savedState.position = getSelectedItemPosition();
            savedState.cVw = -1L;
        } else if (z2 && this.mFirstPosition > 0) {
            savedState.cVx = getChildAt(0).getLeft();
            int i2 = this.mFirstPosition;
            if (i2 >= this.mItemCount) {
                i2 = this.mItemCount - 1;
            }
            savedState.position = i2;
            savedState.cVw = this.mAdapter.getItemId(i2);
        } else {
            savedState.cVx = 0;
            savedState.cVw = -1L;
            savedState.position = 0;
        }
        savedState.cVy = null;
        savedState.cVz = (Build.VERSION.SDK_INT < 11 || this.cTX != 3 || this.cTY == null) ? false : false;
        if (this.cUb != null) {
            try {
                savedState.cVB = this.cUb.m1clone();
            } catch (NoSuchMethodError e2) {
                e2.printStackTrace();
                savedState.cVB = new SparseArrayCompat<>();
            }
        }
        if (this.cUc != null) {
            LongSparseArray<Integer> longSparseArray = new LongSparseArray<>();
            int size = this.cUc.size();
            for (int i3 = 0; i3 < size; i3++) {
                longSparseArray.put(this.cUc.keyAt(i3), this.cUc.valueAt(i3));
            }
            savedState.cVC = longSparseArray;
        }
        savedState.cVA = this.cUa;
        return savedState;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mDataChanged = true;
        this.cVG = savedState.width;
        if (savedState.cVv >= 0) {
            this.mNeedSync = true;
            this.cUP = savedState;
            this.cVF = savedState.cVv;
            this.mSyncPosition = savedState.position;
            this.cVE = savedState.cVx;
            this.mSyncMode = 0;
        } else if (savedState.cVw >= 0) {
            setSelectedPositionInt(-1);
            setNextSelectedPositionInt(-1);
            this.cUf = -1;
            this.mNeedSync = true;
            this.cUP = savedState;
            this.cVF = savedState.cVw;
            this.mSyncPosition = savedState.position;
            this.cVE = savedState.cVx;
            this.mSyncMode = 1;
        }
        if (savedState.cVB != null) {
            this.cUb = savedState.cVB;
        }
        if (savedState.cVC != null) {
            this.cUc = savedState.cVC;
        }
        this.cUa = savedState.cVA;
        if (Build.VERSION.SDK_INT >= 11 && savedState.cVz && this.cTX == 3 && this.cTZ != null) {
            this.cTY = startActionMode((com.baidu.tieba.horizonalList.a.a.b) this.cTZ);
        }
        requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onFocusChanged(boolean z, int i2, Rect rect) {
        super.onFocusChanged(z, i2, rect);
        if (z && this.mSelectedPosition < 0 && !isInTouchMode()) {
            if (!this.cUM && this.mAdapter != null) {
                this.mDataChanged = true;
                this.mOldItemCount = this.mItemCount;
                this.mItemCount = this.mAdapter.getCount();
            }
            aoL();
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
        this.cUy = null;
        this.mNeedSync = false;
        this.cUP = null;
        this.mOldSelectedPosition = -1;
        this.cVO = Long.MIN_VALUE;
        setSelectedPositionInt(-1);
        setNextSelectedPositionInt(-1);
        this.cUq = 0;
        this.cUf = -1;
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
            this.cUG = childCount + this.mFirstPosition >= this.cUN && (childAt != null ? childAt.getRight() : width) <= width;
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
            this.cUg.aoR();
        }
        layoutChildren();
        this.mInLayout = false;
        this.cUt = (i4 - i2) / 3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void layoutChildren() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aoC() {
        boolean z = true;
        if (this.cUi != null) {
            boolean z2 = this.mFirstPosition > 0;
            if (!z2 && getChildCount() > 0) {
                z2 = getChildAt(0).getLeft() < this.mListPadding.left;
            }
            this.cUi.setVisibility(z2 ? 0 : 4);
        }
        if (this.cUj != null) {
            int childCount = getChildCount();
            boolean z3 = this.mFirstPosition + childCount < this.mItemCount;
            if (z3 || childCount <= 0) {
                z = z3;
            } else if (getChildAt(childCount - 1).getRight() <= getRight() - this.mListPadding.right) {
                z = false;
            }
            this.cUj.setVisibility(z ? 0 : 4);
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
        View kU = this.cUg.kU(i2);
        if (kU == null) {
            View kV = this.cUg.kV(i2);
            if (kV != null) {
                view = this.mAdapter.getView(i2, kV, this);
                if (view != kV) {
                    this.cUg.r(kV, i2);
                    if (this.mCacheColorHint != 0) {
                        view.setDrawingCacheBackgroundColor(this.mCacheColorHint);
                        kU = view;
                    }
                } else {
                    zArr[0] = true;
                    view.onFinishTemporaryDetach();
                    kU = view;
                }
                if (this.cUe) {
                    ViewGroup.LayoutParams layoutParams = kU.getLayoutParams();
                    if (layoutParams == null) {
                        fVar = (f) generateDefaultLayoutParams();
                    } else if (!checkLayoutParams(layoutParams)) {
                        fVar = (f) generateLayoutParams(layoutParams);
                    } else {
                        fVar = (f) layoutParams;
                    }
                    fVar.cVd = this.mAdapter.getItemId(i2);
                    kU.setLayoutParams(fVar);
                }
                if (this.cVN.isEnabled() && this.cUJ == null) {
                    this.cUJ = new g();
                }
            } else {
                view = this.mAdapter.getView(i2, null, this);
                if (this.mCacheColorHint != 0) {
                    view.setDrawingCacheBackgroundColor(this.mCacheColorHint);
                }
            }
            kU = view;
            if (this.cUe) {
            }
            if (this.cVN.isEnabled()) {
                this.cUJ = new g();
            }
        }
        return kU;
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
            this.cUf = i2;
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
        aoE();
    }

    public Drawable getSelector() {
        return this.mSelector;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aoD() {
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
                        if (this.cUv == null) {
                            this.cUv = new b();
                        }
                        this.cUv.aoW();
                        postDelayed(this.cUv, ViewConfiguration.getLongPressTimeout());
                    }
                }
            }
        }
    }

    void aoE() {
        if (this.mSelector != null) {
            if (shouldShowSelector()) {
                this.mSelector.setState(getDrawableState());
            } else {
                this.mSelector.setState(cUQ);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        aoE();
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
        if (this.mAdapter != null && this.cUd == null) {
            this.cUd = new a();
            this.mAdapter.registerDataSetObserver(this.cUd);
            this.mDataChanged = true;
            this.mOldItemCount = this.mItemCount;
            this.mItemCount = this.mAdapter.getCount();
        }
        this.cUM = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.a, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.cUg.clear();
        getViewTreeObserver().removeOnTouchModeChangeListener(this);
        if (this.mAdapter != null && this.cUd != null) {
            this.mAdapter.unregisterDataSetObserver(this.cUd);
            this.cUd = null;
        }
        if (this.cUo != null) {
            removeCallbacks(this.cUo);
        }
        if (this.cUp != null) {
            this.cUp.stop();
        }
        if (this.mClearScrollingCache != null) {
            removeCallbacks(this.mClearScrollingCache);
        }
        if (this.cUw != null) {
            removeCallbacks(this.cUw);
        }
        if (this.cUx != null) {
            removeCallbacks(this.cUx);
            this.cUx = null;
        }
        this.cUM = false;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        int i2 = isInTouchMode() ? 0 : 1;
        if (!z) {
            setChildrenDrawingCacheEnabled(false);
            if (this.cUo != null) {
                removeCallbacks(this.cUo);
                this.cUo.aoP();
                if (this.cUp != null) {
                    this.cUp.stop();
                }
                if (getScrollX() != 0) {
                    this.cTW.setScrollX(0);
                    aoN();
                    invalidate();
                }
            }
            if (i2 == 1) {
                this.mResurrectToPosition = this.mSelectedPosition;
            }
        } else if (i2 != this.mLastTouchMode && this.mLastTouchMode != -1) {
            if (i2 == 1) {
                aoL();
            } else {
                aoJ();
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
        private int cVD;

        private n() {
        }

        public void aoW() {
            this.cVD = AbsHListView.this.getWindowAttachCount();
        }

        public boolean aoX() {
            return AbsHListView.this.hasWindowFocus() && AbsHListView.this.getWindowAttachCount() == this.cVD;
        }
    }

    /* loaded from: classes.dex */
    private class i extends n implements Runnable {
        int cVe;

        private i() {
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            View childAt;
            if (!AbsHListView.this.mDataChanged) {
                ListAdapter listAdapter = AbsHListView.this.mAdapter;
                int i = this.cVe;
                if (listAdapter != null && AbsHListView.this.mItemCount > 0 && i != -1 && i < listAdapter.getCount() && aoX() && (childAt = AbsHListView.this.getChildAt(i - AbsHListView.this.mFirstPosition)) != null) {
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
                if ((!aoX() || AbsHListView.this.mDataChanged) ? false : AbsHListView.this.b(childAt, AbsHListView.this.mMotionPosition, AbsHListView.this.mAdapter.getItemId(AbsHListView.this.mMotionPosition))) {
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
                    if (aoX() ? AbsHListView.this.b(childAt, AbsHListView.this.mSelectedPosition, AbsHListView.this.cVM) : false) {
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
        if (Build.VERSION.SDK_INT >= 11 && this.cTX == 3) {
            if (this.cTY == null) {
                ActionMode startActionMode = startActionMode((com.baidu.tieba.horizonalList.a.a.b) this.cTZ);
                this.cTY = startActionMode;
                if (startActionMode != null) {
                    setItemChecked(i2, true);
                    performHapticFeedback(0);
                }
            }
            return true;
        }
        boolean b2 = this.cVJ != null ? this.cVJ.b(this, view, i2, j2) : false;
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
            boolean b2 = this.cVJ != null ? this.cVJ.b(this, view, positionForView, itemId) : false;
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
                        performItemClick(childAt, this.mSelectedPosition, this.cVM);
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
                            if (AbsHListView.this.cUu == null) {
                                AbsHListView.this.cUu = new c();
                            }
                            AbsHListView.this.cUu.aoW();
                            AbsHListView.this.postDelayed(AbsHListView.this.cUu, longPressTimeout);
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
                handler.removeCallbacks(this.cUu);
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
            kL(i2);
            return true;
        }
        return false;
    }

    private void kL(int i2) {
        int i3;
        int childCount;
        ViewParent parent;
        int i4 = i2 - this.mMotionX;
        int i5 = i4 - this.mMotionCorrection;
        int i6 = this.cUn != Integer.MIN_VALUE ? i2 - this.cUn : i5;
        if (this.mTouchMode == 3) {
            if (i2 != this.cUn) {
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
                        overScrollBy(i7, 0, getScrollX(), 0, 0, 0, this.cUA, 0, true);
                        if (Math.abs(this.cUA) == Math.abs(getScrollX()) && this.mVelocityTracker != null) {
                            this.mVelocityTracker.clear();
                        }
                        int overScrollMode = getOverScrollMode();
                        if (overScrollMode == 0 || (overScrollMode == 1 && !aoB())) {
                            this.mDirection = 0;
                            this.mTouchMode = 5;
                            if (i4 > 0) {
                                this.cUC.onPull(i7 / getWidth());
                                if (!this.cUD.isFinished()) {
                                    this.cUD.onRelease();
                                }
                                invalidate();
                            } else if (i4 < 0) {
                                this.cUD.onPull(i7 / getWidth());
                                if (!this.cUC.isFinished()) {
                                    this.cUC.onRelease();
                                }
                                invalidate();
                            }
                        }
                    }
                    this.mMotionX = i2;
                }
                this.cUn = i2;
            }
        } else if (this.mTouchMode == 5 && i2 != this.cUn) {
            int scrollX = getScrollX();
            int i8 = scrollX - i6;
            int i9 = i2 > this.cUn ? 1 : -1;
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
                overScrollBy(i10, 0, getScrollX(), 0, 0, 0, this.cUA, 0, true);
                int overScrollMode2 = getOverScrollMode();
                if (overScrollMode2 == 0 || (overScrollMode2 == 1 && !aoB())) {
                    if (i4 > 0) {
                        this.cUC.onPull(i10 / getWidth());
                        if (!this.cUD.isFinished()) {
                            this.cUD.onRelease();
                        }
                        invalidate();
                    } else if (i4 < 0) {
                        this.cUD.onPull(i10 / getWidth());
                        if (!this.cUC.isFinished()) {
                            this.cUC.onRelease();
                        }
                        invalidate();
                    }
                }
            }
            if (i3 != 0) {
                if (getScrollX() != 0) {
                    this.cTW.setScrollX(0);
                    aoF();
                }
                trackMotionScroll(i3, i3);
                this.mTouchMode = 3;
                int kO = kO(i2);
                this.mMotionCorrection = 0;
                View childAt3 = getChildAt(kO - this.mFirstPosition);
                this.cUl = childAt3 != null ? childAt3.getLeft() : 0;
                this.mMotionX = i2;
                this.mMotionPosition = kO;
            }
            this.cUn = i2;
            this.mDirection = i9;
        }
    }

    @TargetApi(11)
    protected void aoF() {
        if (this.cTW.isHardwareAccelerated() && (getParent() instanceof View)) {
            ((View) getParent()).invalidate();
        }
    }

    @Override // android.view.ViewTreeObserver.OnTouchModeChangeListener
    public void onTouchModeChanged(boolean z) {
        if (z) {
            aoJ();
            if (getWidth() > 0 && getChildCount() > 0) {
                layoutChildren();
            }
            aoE();
            return;
        }
        int i2 = this.mTouchMode;
        if (i2 == 5 || i2 == 6) {
            if (this.cUo != null) {
                this.cUo.aoP();
            }
            if (this.cUp != null) {
                this.cUp.stop();
            }
            if (getScrollX() != 0) {
                this.cTW.setScrollX(0);
                aoN();
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
        if (this.cUp != null) {
            this.cUp.stop();
        }
        if (this.cUM) {
            int action = motionEvent.getAction();
            aoH();
            this.mVelocityTracker.addMovement(motionEvent);
            switch (action & MotionEventCompat.ACTION_MASK) {
                case 0:
                    switch (this.mTouchMode) {
                        case 6:
                            this.cUo.aoP();
                            if (this.cUp != null) {
                                this.cUp.stop();
                            }
                            this.mTouchMode = 5;
                            this.mMotionY = (int) motionEvent.getY();
                            int x = (int) motionEvent.getX();
                            this.cUn = x;
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
                                    i2 = kN(x2);
                                    this.cUo.aoQ();
                                }
                                if (i2 >= 0) {
                                    this.cUl = getChildAt(i2 - this.mFirstPosition).getLeft();
                                }
                                this.mMotionX = x2;
                                this.mMotionY = y;
                                this.mMotionPosition = i2;
                                this.cUn = ExploreByTouchHelper.INVALID_ID;
                                break;
                            }
                            i2 = pointToPosition;
                            if (i2 >= 0) {
                            }
                            this.mMotionX = x2;
                            this.mMotionY = y;
                            this.mMotionPosition = i2;
                            this.cUn = ExploreByTouchHelper.INVALID_ID;
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
                                if (this.cUw == null) {
                                    this.cUw = new i();
                                }
                                final i iVar = this.cUw;
                                iVar.cVe = i4;
                                iVar.aoW();
                                this.mResurrectToPosition = i4;
                                if (this.mTouchMode == 0 || this.mTouchMode == 1) {
                                    Handler handler = getHandler();
                                    if (handler != null) {
                                        handler.removeCallbacks(this.mTouchMode == 0 ? this.mPendingCheckForTap : this.cUu);
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
                                        if (this.cUx != null) {
                                            removeCallbacks(this.cUx);
                                        }
                                        this.cUx = new Runnable() { // from class: com.baidu.tieba.horizonalList.widget.AbsHListView.1
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
                                        postDelayed(this.cUx, ViewConfiguration.getPressedStateDuration());
                                        return true;
                                    }
                                    this.mTouchMode = -1;
                                    aoE();
                                    return true;
                                } else if (!this.mDataChanged && this.mAdapter.isEnabled(i4)) {
                                    iVar.run();
                                }
                            }
                            this.mTouchMode = -1;
                            aoE();
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
                                    int xVelocity = (int) (velocityTracker.getXVelocity(this.mActivePointerId) * this.cUz);
                                    if (Math.abs(xVelocity) > this.mMinimumVelocity && ((this.mFirstPosition != 0 || left != i5 - this.cUA) && (childCount + this.mFirstPosition != this.mItemCount || right != this.cUA + width))) {
                                        if (this.cUo == null) {
                                            this.cUo = new e();
                                        }
                                        reportScrollStateChange(2);
                                        this.cUo.start(-xVelocity);
                                        break;
                                    } else {
                                        this.mTouchMode = -1;
                                        reportScrollStateChange(0);
                                        if (this.cUo != null) {
                                            this.cUo.aoP();
                                        }
                                        if (this.cUp != null) {
                                            this.cUp.stop();
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
                            if (this.cUo == null) {
                                this.cUo = new e();
                            }
                            VelocityTracker velocityTracker2 = this.mVelocityTracker;
                            velocityTracker2.computeCurrentVelocity(1000, this.mMaximumVelocity);
                            int xVelocity2 = (int) velocityTracker2.getXVelocity(this.mActivePointerId);
                            reportScrollStateChange(2);
                            if (Math.abs(xVelocity2) > this.mMinimumVelocity) {
                                this.cUo.kP(-xVelocity2);
                                break;
                            } else {
                                this.cUo.aoO();
                                break;
                            }
                    }
                    setPressed(false);
                    if (this.cUC != null) {
                        this.cUC.onRelease();
                        this.cUD.onRelease();
                    }
                    invalidate();
                    Handler handler2 = getHandler();
                    if (handler2 != null) {
                        handler2.removeCallbacks(this.cUu);
                    }
                    aoI();
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
                            kL(x4);
                            return true;
                        case 4:
                        default:
                            return true;
                    }
                case 3:
                    switch (this.mTouchMode) {
                        case 5:
                            if (this.cUo == null) {
                                this.cUo = new e();
                            }
                            this.cUo.aoO();
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
                                handler3.removeCallbacks(this.cUu);
                            }
                            aoI();
                            break;
                    }
                    if (this.cUC != null) {
                        this.cUC.onRelease();
                        this.cUD.onRelease();
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
                        this.cUl = getChildAt(pointToPosition2 - this.mFirstPosition).getLeft();
                        this.mMotionPosition = pointToPosition2;
                    }
                    this.cUn = x5;
                    return true;
                case 6:
                    onSecondaryPointerUp(motionEvent);
                    int i6 = this.mMotionX;
                    int pointToPosition3 = pointToPosition(i6, this.mMotionY);
                    if (pointToPosition3 >= 0) {
                        this.cUl = getChildAt(pointToPosition3 - this.mFirstPosition).getLeft();
                        this.mMotionPosition = pointToPosition3;
                    }
                    this.cUn = i6;
                    return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    protected void onOverScrolled(int i2, int i3, boolean z, boolean z2) {
        if (getScrollX() != i2) {
            onScrollChanged(i2, getScrollY(), getScrollX(), getScrollY());
            this.cTW.setScrollX(i2);
            aoF();
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
        if (this.cUR == 0.0f) {
            TypedValue typedValue = new TypedValue();
            if (getContext().getTheme().resolveAttribute(d.c.hlv_listPreferredItemWidth, typedValue, true)) {
                this.cUR = typedValue.getDimension(getContext().getResources().getDisplayMetrics());
            }
        }
        return this.cUR;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.cUC != null) {
            int scrollX = getScrollX();
            if (!this.cUC.isFinished()) {
                int save = canvas.save();
                int i2 = this.mListPadding.top + this.cUH;
                int height = (getHeight() - i2) - (this.mListPadding.bottom + this.cUI);
                int min = Math.min(0, this.cUE + scrollX);
                canvas.rotate(-90.0f);
                canvas.translate(i2 + (-getHeight()), min);
                this.cUC.setSize(height, height);
                if (this.cUC.draw(canvas)) {
                    invalidate();
                }
                canvas.restoreToCount(save);
            }
            if (!this.cUD.isFinished()) {
                int save2 = canvas.save();
                int i3 = this.mListPadding.left + this.cUH;
                int height2 = (getHeight() - i3) - (this.mListPadding.right + this.cUI);
                int max = Math.max(getWidth(), scrollX + this.cUF);
                canvas.rotate(90.0f);
                canvas.translate(-i3, -max);
                this.cUD.setSize(height2, height2);
                if (this.cUD.draw(canvas)) {
                    invalidate();
                }
                canvas.restoreToCount(save2);
            }
        }
    }

    private void aoG() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        } else {
            this.mVelocityTracker.clear();
        }
    }

    private void aoH() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
    }

    private void aoI() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            aoI();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.cUp != null) {
            this.cUp.stop();
        }
        if (this.cUM) {
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
                    int kN = kN(x);
                    if (i2 != 4 && kN >= 0) {
                        this.cUl = getChildAt(kN - this.mFirstPosition).getLeft();
                        this.mMotionX = x;
                        this.mMotionY = y;
                        this.mMotionPosition = kN;
                        this.mTouchMode = 0;
                        clearScrollingCache();
                    }
                    this.cUn = ExploreByTouchHelper.INVALID_ID;
                    aoG();
                    this.mVelocityTracker.addMovement(motionEvent);
                    return i2 == 4;
                case 1:
                case 3:
                    this.mTouchMode = -1;
                    this.mActivePointerId = -1;
                    aoI();
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
                            aoH();
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
        if (i2 != this.mLastScrollState && this.cUs != null) {
            this.mLastScrollState = i2;
            this.cUs.a(this, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e implements Runnable {
        private final com.baidu.tieba.horizonalList.widget.g cUV;
        private int cUW;
        private final Runnable cUX = new Runnable() { // from class: com.baidu.tieba.horizonalList.widget.AbsHListView.e.1
            @Override // java.lang.Runnable
            public void run() {
                int i = AbsHListView.this.mActivePointerId;
                VelocityTracker velocityTracker = AbsHListView.this.mVelocityTracker;
                com.baidu.tieba.horizonalList.widget.g gVar = e.this.cUV;
                if (velocityTracker != null && i != -1) {
                    velocityTracker.computeCurrentVelocity(1000, AbsHListView.this.mMaximumVelocity);
                    float f = -velocityTracker.getXVelocity(i);
                    if (Math.abs(f) >= AbsHListView.this.mMinimumVelocity && gVar.k(f, 0.0f)) {
                        AbsHListView.this.postDelayed(this, 40L);
                        return;
                    }
                    e.this.aoP();
                    AbsHListView.this.mTouchMode = 3;
                    AbsHListView.this.reportScrollStateChange(1);
                }
            }
        };

        e() {
            this.cUV = new com.baidu.tieba.horizonalList.widget.g(AbsHListView.this.getContext());
        }

        void start(int i) {
            int i2 = i < 0 ? Integer.MAX_VALUE : 0;
            this.cUW = i2;
            this.cUV.setInterpolator(null);
            this.cUV.fling(i2, 0, i, 0, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
            AbsHListView.this.mTouchMode = 4;
            AbsHListView.this.cTW.k(this);
        }

        void aoO() {
            if (this.cUV.springBack(AbsHListView.this.getScrollX(), 0, 0, 0, 0, 0)) {
                AbsHListView.this.mTouchMode = 6;
                AbsHListView.this.invalidate();
                AbsHListView.this.cTW.k(this);
                return;
            }
            AbsHListView.this.mTouchMode = -1;
            AbsHListView.this.reportScrollStateChange(0);
        }

        void kP(int i) {
            this.cUV.setInterpolator(null);
            this.cUV.fling(AbsHListView.this.getScrollX(), 0, i, 0, ExploreByTouchHelper.INVALID_ID, Integer.MAX_VALUE, 0, 0, AbsHListView.this.getWidth(), 0);
            AbsHListView.this.mTouchMode = 6;
            AbsHListView.this.invalidate();
            AbsHListView.this.cTW.k(this);
        }

        void kQ(int i) {
            this.cUV.notifyHorizontalEdgeReached(AbsHListView.this.getScrollX(), 0, AbsHListView.this.cUB);
            int overScrollMode = AbsHListView.this.getOverScrollMode();
            if (overScrollMode == 0 || (overScrollMode == 1 && !AbsHListView.this.aoB())) {
                AbsHListView.this.mTouchMode = 6;
                int currVelocity = (int) this.cUV.getCurrVelocity();
                if (i > 0) {
                    AbsHListView.this.cUC.onAbsorb(currVelocity);
                } else {
                    AbsHListView.this.cUD.onAbsorb(currVelocity);
                }
            } else {
                AbsHListView.this.mTouchMode = -1;
                if (AbsHListView.this.cUp != null) {
                    AbsHListView.this.cUp.stop();
                }
            }
            AbsHListView.this.invalidate();
            AbsHListView.this.cTW.k(this);
        }

        void f(int i, int i2, boolean z) {
            int i3 = i < 0 ? Integer.MAX_VALUE : 0;
            this.cUW = i3;
            this.cUV.setInterpolator(z ? AbsHListView.cUO : null);
            this.cUV.startScroll(i3, 0, i, 0, i2);
            AbsHListView.this.mTouchMode = 4;
            AbsHListView.this.cTW.k(this);
        }

        void aoP() {
            AbsHListView.this.mTouchMode = -1;
            AbsHListView.this.removeCallbacks(this);
            AbsHListView.this.removeCallbacks(this.cUX);
            AbsHListView.this.reportScrollStateChange(0);
            AbsHListView.this.clearScrollingCache();
            this.cUV.abortAnimation();
            AbsHListView.this.overScrollBy(0, 0, 0, 0, 0, 0, 0, 0, false);
        }

        void aoQ() {
            AbsHListView.this.postDelayed(this.cUX, 40L);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // java.lang.Runnable
        public void run() {
            int max;
            boolean z = true;
            boolean z2 = false;
            switch (AbsHListView.this.mTouchMode) {
                case 3:
                    if (this.cUV.isFinished()) {
                        return;
                    }
                    break;
                case 4:
                    break;
                case 5:
                default:
                    aoP();
                    return;
                case 6:
                    com.baidu.tieba.horizonalList.widget.g gVar = this.cUV;
                    if (gVar.computeScrollOffset()) {
                        int scrollX = AbsHListView.this.getScrollX();
                        int currX = gVar.getCurrX();
                        if (AbsHListView.this.overScrollBy(currX - scrollX, 0, scrollX, 0, 0, 0, AbsHListView.this.cUB, 0, false)) {
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
                            aoO();
                            return;
                        }
                        AbsHListView.this.invalidate();
                        AbsHListView.this.cTW.k(this);
                        return;
                    }
                    aoP();
                    return;
            }
            if (AbsHListView.this.mDataChanged) {
                AbsHListView.this.layoutChildren();
            }
            if (AbsHListView.this.mItemCount == 0 || AbsHListView.this.getChildCount() == 0) {
                aoP();
                return;
            }
            com.baidu.tieba.horizonalList.widget.g gVar2 = this.cUV;
            boolean computeScrollOffset = gVar2.computeScrollOffset();
            int currX2 = gVar2.getCurrX();
            int i = this.cUW - currX2;
            if (i > 0) {
                AbsHListView.this.mMotionPosition = AbsHListView.this.mFirstPosition;
                AbsHListView.this.cUl = AbsHListView.this.getChildAt(0).getLeft();
                max = Math.min(((AbsHListView.this.getWidth() - AbsHListView.this.getPaddingRight()) - AbsHListView.this.getPaddingLeft()) - 1, i);
            } else {
                int childCount = AbsHListView.this.getChildCount() - 1;
                AbsHListView.this.mMotionPosition = AbsHListView.this.mFirstPosition + childCount;
                AbsHListView.this.cUl = AbsHListView.this.getChildAt(childCount).getLeft();
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
                    AbsHListView.this.overScrollBy(-(max - (childAt.getLeft() - left)), 0, AbsHListView.this.getScrollX(), 0, 0, 0, AbsHListView.this.cUB, 0, false);
                }
                if (computeScrollOffset) {
                    kQ(max);
                }
            } else if (computeScrollOffset && !z) {
                if (trackMotionScroll) {
                    AbsHListView.this.invalidate();
                }
                this.cUW = currX2;
                AbsHListView.this.cTW.k(this);
            } else {
                aoP();
            }
        }
    }

    /* loaded from: classes.dex */
    public class j implements Runnable {
        private int cVf;
        private int cVg;
        private int cVh;
        private int cVi;
        private final int cVj;
        private int cVk;
        private int mMode;

        j() {
            this.cVj = ViewConfiguration.get(AbsHListView.this.getContext()).getScaledFadingEdgeLength();
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
            this.cVi = 200;
            this.cVf = i;
            this.cVg = -1;
            this.cVh = -1;
            AbsHListView.this.cTW.k(this);
        }

        void aA(final int i, final int i2) {
            int i3;
            int i4;
            stop();
            if (i2 == -1) {
                start(i);
            } else if (AbsHListView.this.mDataChanged) {
                AbsHListView.this.cUy = new Runnable() { // from class: com.baidu.tieba.horizonalList.widget.AbsHListView.j.1
                    @Override // java.lang.Runnable
                    public void run() {
                        j.this.aA(i, i2);
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
                        this.cVi = 200 / i4;
                    } else {
                        this.cVi = 200;
                    }
                    this.cVf = max;
                    this.cVg = i2;
                    this.cVh = -1;
                    AbsHListView.this.cTW.k(this);
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
                        AbsHListView.this.e((i3 < AbsHListView.this.mItemCount + (-1) ? Math.max(AbsHListView.this.mListPadding.right, this.cVj) : AbsHListView.this.mListPadding.right) + (childAt.getWidth() - (width - childAt.getLeft())), this.cVi, true);
                        this.cVh = i3;
                        if (i3 < this.cVf) {
                            AbsHListView.this.cTW.k(this);
                            return;
                        }
                        return;
                    }
                    return;
                case 2:
                    if (i2 == this.cVh) {
                        AbsHListView.this.cTW.k(this);
                        return;
                    }
                    View childAt2 = AbsHListView.this.getChildAt(0);
                    if (childAt2 != null) {
                        AbsHListView.this.e(childAt2.getLeft() - (i2 > 0 ? Math.max(this.cVj, AbsHListView.this.mListPadding.left) : AbsHListView.this.mListPadding.left), this.cVi, true);
                        this.cVh = i2;
                        if (i2 > this.cVf) {
                            AbsHListView.this.cTW.k(this);
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    int childCount2 = AbsHListView.this.getChildCount();
                    if (i2 != this.cVg && childCount2 > 1 && childCount2 + i2 < AbsHListView.this.mItemCount) {
                        int i4 = i2 + 1;
                        if (i4 == this.cVh) {
                            AbsHListView.this.cTW.k(this);
                            return;
                        }
                        View childAt3 = AbsHListView.this.getChildAt(1);
                        int width2 = childAt3.getWidth();
                        int left2 = childAt3.getLeft();
                        int max = Math.max(AbsHListView.this.mListPadding.right, this.cVj);
                        if (i4 < this.cVg) {
                            AbsHListView.this.e(Math.max(0, (left2 + width2) - max), this.cVi, true);
                            this.cVh = i4;
                            AbsHListView.this.cTW.k(this);
                            return;
                        } else if (left2 > max) {
                            AbsHListView.this.e(left2 - max, this.cVi, true);
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
                        if (i5 == this.cVh) {
                            AbsHListView.this.cTW.k(this);
                            return;
                        }
                        View childAt4 = AbsHListView.this.getChildAt(childCount3);
                        int width3 = childAt4.getWidth();
                        int left3 = childAt4.getLeft();
                        int i6 = width - left3;
                        int max2 = Math.max(AbsHListView.this.mListPadding.left, this.cVj);
                        this.cVh = i5;
                        if (i5 > this.cVg) {
                            AbsHListView.this.e(-(i6 - max2), this.cVi, true);
                            AbsHListView.this.cTW.k(this);
                            return;
                        }
                        int i7 = width - max2;
                        int i8 = left3 + width3;
                        if (i7 > i8) {
                            AbsHListView.this.e(-(i7 - i8), this.cVi, true);
                            return;
                        }
                        return;
                    }
                    return;
                case 5:
                    if (this.cVh == i2) {
                        AbsHListView.this.cTW.k(this);
                        return;
                    }
                    this.cVh = i2;
                    int childCount4 = AbsHListView.this.getChildCount();
                    int i9 = this.cVf;
                    int i10 = (i2 + childCount4) - 1;
                    if (i9 < i2) {
                        i = (i2 - i9) + 1;
                    } else if (i9 > i10) {
                        i = i9 - i10;
                    }
                    float min = Math.min(Math.abs(i / childCount4), 1.0f);
                    if (i9 < i2) {
                        AbsHListView.this.e((int) ((-AbsHListView.this.getWidth()) * min), (int) (min * this.cVi), true);
                        AbsHListView.this.cTW.k(this);
                        return;
                    } else if (i9 > i10) {
                        AbsHListView.this.e((int) (AbsHListView.this.getWidth() * min), (int) (min * this.cVi), true);
                        AbsHListView.this.cTW.k(this);
                        return;
                    } else {
                        AbsHListView.this.e(AbsHListView.this.getChildAt(i9 - i2).getLeft() - this.cVk, (int) (this.cVi * (Math.abs(left) / AbsHListView.this.getWidth())), true);
                        return;
                    }
                default:
                    return;
            }
        }
    }

    public void setFriction(float f2) {
        if (this.cUo == null) {
            this.cUo = new e();
        }
        this.cUo.cUV.setFriction(f2);
    }

    public void setVelocityScale(float f2) {
        this.cUz = f2;
    }

    public void smoothScrollToPosition(int i2, int i3) {
        if (this.cUp == null) {
            this.cUp = new j();
        }
        this.cUp.aA(i2, i3);
    }

    public void smoothScrollBy(int i2, int i3) {
        e(i2, i3, false);
    }

    public void e(int i2, int i3, boolean z) {
        if (this.cUo == null) {
            this.cUo = new e();
        }
        int i4 = this.mFirstPosition;
        int childCount = getChildCount();
        int i5 = i4 + childCount;
        int paddingLeft = getPaddingLeft();
        int width = getWidth() - getPaddingRight();
        if (i2 == 0 || this.mItemCount == 0 || childCount == 0 || ((i4 == 0 && getChildAt(0).getLeft() == paddingLeft && i2 < 0) || (i5 == this.mItemCount && getChildAt(childCount - 1).getRight() == width && i2 > 0))) {
            this.cUo.aoP();
            if (this.cUp != null) {
                this.cUp.stop();
                return;
            }
            return;
        }
        reportScrollStateChange(2);
        this.cUo.f(i2, i3, z);
    }

    private void createScrollingCache() {
        if (this.mScrollingCacheEnabled && !this.mCachingStarted && !this.cTW.isHardwareAccelerated()) {
            setChildrenDrawnWithCacheEnabled(true);
            setChildrenDrawingCacheEnabled(true);
            this.cUk = true;
            this.mCachingStarted = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearScrollingCache() {
        if (!this.cTW.isHardwareAccelerated()) {
            if (this.mClearScrollingCache == null) {
                this.mClearScrollingCache = new Runnable() { // from class: com.baidu.tieba.horizonalList.widget.AbsHListView.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AbsHListView.this.mCachingStarted) {
                            AbsHListView absHListView = AbsHListView.this;
                            AbsHListView.this.cUk = false;
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
            this.cUE = left - rect.left;
        } else {
            this.cUE += min2;
        }
        if (i6 + childCount == this.mItemCount) {
            this.cUF = rect.right + right;
        } else {
            this.cUF += min2;
        }
        boolean z = i6 == 0 && left >= rect.left && min2 >= 0;
        boolean z2 = i6 + childCount == this.mItemCount && right <= getWidth() - rect.right && min2 <= 0;
        if (z || z2) {
            return min2 != 0;
        }
        boolean z3 = min2 < 0;
        boolean isInTouchMode = isInTouchMode();
        if (isInTouchMode) {
            aoJ();
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
                    this.cUg.r(childAt, i11);
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
                    this.cUg.r(childAt2, i14);
                }
                i4 = i13;
                i7 = i12;
            }
        }
        this.cUm = this.cUl + min;
        this.mBlockLayoutRequests = true;
        if (i4 > 0) {
            detachViewsFromParent(i7, i4);
            this.cUg.aoT();
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        kM(min2);
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
        } else if (this.cUf != -1) {
            int i16 = this.cUf - this.mFirstPosition;
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

    public void kM(int i2) {
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
    public void aoJ() {
        if (this.mSelectedPosition != -1) {
            if (this.mLayoutMode != 4) {
                this.mResurrectToPosition = this.mSelectedPosition;
            }
            if (this.cVK >= 0 && this.cVK != this.mSelectedPosition) {
                this.mResurrectToPosition = this.cVK;
            }
            setSelectedPositionInt(-1);
            setNextSelectedPositionInt(-1);
            this.cUq = 0;
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

    protected int kO(int i2) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return -1;
        }
        int kN = kN(i2);
        return kN == -1 ? (this.mFirstPosition + childCount) - 1 : kN;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aoK() {
        if (this.mSelectedPosition >= 0 || !aoL()) {
            return false;
        }
        aoE();
        return true;
    }

    boolean aoL() {
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
        removeCallbacks(this.cUo);
        if (this.cUp != null) {
            this.cUp.stop();
        }
        this.mTouchMode = -1;
        clearScrollingCache();
        this.cVE = i2;
        int lookForSelectablePosition = lookForSelectablePosition(i11, z);
        if (lookForSelectablePosition < i10 || lookForSelectablePosition > getLastVisiblePosition()) {
            lookForSelectablePosition = -1;
        } else {
            this.mLayoutMode = 4;
            aoE();
            setSelectionInt(lookForSelectablePosition);
            invokeOnItemScrollListener();
        }
        reportScrollStateChange(0);
        return lookForSelectablePosition >= 0;
    }

    void aoM() {
        boolean z;
        this.cUb.clear();
        int i2 = 0;
        boolean z2 = false;
        while (i2 < this.cUc.size()) {
            long keyAt = this.cUc.keyAt(i2);
            int intValue = this.cUc.valueAt(i2).intValue();
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
                        this.cUb.put(max, true);
                        this.cUc.setValueAt(i2, Integer.valueOf(max));
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    this.cUc.delete(keyAt);
                    int i3 = i2 - 1;
                    this.cUa--;
                    if (Build.VERSION.SDK_INT > 11 && this.cTY != null && this.cTZ != null) {
                        ((com.baidu.tieba.horizonalList.a.a.b) this.cTZ).onItemCheckedStateChanged((ActionMode) this.cTY, intValue, keyAt, false);
                    }
                    i2 = i3;
                    z2 = true;
                }
            } else {
                this.cUb.put(intValue, true);
            }
            z2 = z2;
            i2++;
        }
        if (z2 && this.cTY != null && Build.VERSION.SDK_INT > 11) {
            ((ActionMode) this.cTY).invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.a
    public void handleDataChanged() {
        int i2 = this.mItemCount;
        int i3 = this.cUN;
        this.cUN = this.mItemCount;
        if (this.cTX != 0 && this.mAdapter != null && this.mAdapter.hasStableIds()) {
            aoM();
        }
        this.cUg.aoS();
        if (i2 > 0) {
            if (this.mNeedSync) {
                this.mNeedSync = false;
                this.cUP = null;
                if (this.mTranscriptMode == 2) {
                    this.mLayoutMode = 3;
                    return;
                }
                if (this.mTranscriptMode == 1) {
                    if (this.cUG) {
                        this.cUG = false;
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
                            if (this.cVG == getWidth()) {
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
        this.mLayoutMode = this.cUr ? 3 : 1;
        this.mSelectedPosition = -1;
        this.cVM = Long.MIN_VALUE;
        this.cVK = -1;
        this.cVL = Long.MIN_VALUE;
        this.mNeedSync = false;
        this.cUP = null;
        this.cUf = -1;
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
            this.cUg.setCacheColorHint(i2);
        }
    }

    @ViewDebug.ExportedProperty(category = "drawing")
    public int getCacheColorHint() {
        return this.mCacheColorHint;
    }

    private void aoN() {
        if (this.cUC != null) {
            this.cUC.finish();
            this.cUD.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void az(int i2, int i3) {
    }

    public void setRecyclerListener(l lVar) {
        this.cUg.cVn = lVar;
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
        public int cUZ;
        public boolean cVa;
        public boolean cVb;
        public int cVc;
        public long cVd;

        public f(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.cVd = -1L;
        }

        public f(int i, int i2) {
            super(i, i2);
            this.cVd = -1L;
        }

        public f(int i, int i2, int i3) {
            super(i, i2);
            this.cVd = -1L;
            this.cUZ = i3;
        }

        public f(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.cVd = -1L;
        }
    }

    /* loaded from: classes.dex */
    public class k {
        private l cVn;
        private int cVo;
        private View[] cVp = new View[0];
        private ArrayList<View>[] cVq;
        private int cVr;
        private ArrayList<View> cVs;
        private ArrayList<View> cVt;
        private SparseArrayCompat<View> cVu;

        public k() {
        }

        public void kR(int i) {
            if (i < 1) {
                throw new IllegalArgumentException("Can't have a viewTypeCount < 1");
            }
            ArrayList<View>[] arrayListArr = new ArrayList[i];
            for (int i2 = 0; i2 < i; i2++) {
                arrayListArr[i2] = new ArrayList<>();
            }
            this.cVr = i;
            this.cVs = arrayListArr[0];
            this.cVq = arrayListArr;
        }

        public void aoR() {
            if (this.cVr == 1) {
                ArrayList<View> arrayList = this.cVs;
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    arrayList.get(i).forceLayout();
                }
            } else {
                int i2 = this.cVr;
                for (int i3 = 0; i3 < i2; i3++) {
                    ArrayList<View> arrayList2 = this.cVq[i3];
                    int size2 = arrayList2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        arrayList2.get(i4).forceLayout();
                    }
                }
            }
            if (this.cVu != null) {
                int size3 = this.cVu.size();
                for (int i5 = 0; i5 < size3; i5++) {
                    this.cVu.valueAt(i5).forceLayout();
                }
            }
        }

        public boolean kS(int i) {
            return i >= 0;
        }

        public void clear() {
            if (this.cVr == 1) {
                ArrayList<View> arrayList = this.cVs;
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    AbsHListView.this.removeDetachedView(arrayList.remove((size - 1) - i), false);
                }
            } else {
                int i2 = this.cVr;
                for (int i3 = 0; i3 < i2; i3++) {
                    ArrayList<View> arrayList2 = this.cVq[i3];
                    int size2 = arrayList2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        AbsHListView.this.removeDetachedView(arrayList2.remove((size2 - 1) - i4), false);
                    }
                }
            }
            if (this.cVu != null) {
                this.cVu.clear();
            }
        }

        public void aB(int i, int i2) {
            if (this.cVp.length < i) {
                this.cVp = new View[i];
            }
            this.cVo = i2;
            View[] viewArr = this.cVp;
            for (int i3 = 0; i3 < i; i3++) {
                View childAt = AbsHListView.this.getChildAt(i3);
                f fVar = (f) childAt.getLayoutParams();
                if (fVar != null && fVar.cUZ != -2) {
                    viewArr[i3] = childAt;
                }
            }
        }

        public View kT(int i) {
            int i2 = i - this.cVo;
            View[] viewArr = this.cVp;
            if (i2 < 0 || i2 >= viewArr.length) {
                return null;
            }
            View view = viewArr[i2];
            viewArr[i2] = null;
            return view;
        }

        View kU(int i) {
            int indexOfKey;
            if (this.cVu != null && (indexOfKey = this.cVu.indexOfKey(i)) >= 0) {
                View valueAt = this.cVu.valueAt(indexOfKey);
                this.cVu.removeAt(indexOfKey);
                return valueAt;
            }
            return null;
        }

        void aoS() {
            if (this.cVu != null) {
                this.cVu.clear();
            }
        }

        View kV(int i) {
            if (this.cVr == 1) {
                return AbsHListView.a(this.cVs, i);
            }
            int itemViewType = AbsHListView.this.mAdapter.getItemViewType(i);
            if (itemViewType >= 0 && itemViewType < this.cVq.length) {
                return AbsHListView.a(this.cVq[itemViewType], i);
            }
            return null;
        }

        @SuppressLint({"NewApi"})
        public void r(View view, int i) {
            f fVar = (f) view.getLayoutParams();
            if (fVar != null) {
                fVar.cVc = i;
                int i2 = fVar.cUZ;
                if (!kS(i2)) {
                    if (i2 != -2) {
                        if (this.cVt == null) {
                            this.cVt = new ArrayList<>();
                        }
                        this.cVt.add(view);
                        return;
                    }
                    return;
                }
                view.onStartTemporaryDetach();
                if (this.cVr == 1) {
                    this.cVs.add(view);
                } else {
                    this.cVq[i2].add(view);
                }
                if (Build.VERSION.SDK_INT >= 14) {
                    view.setAccessibilityDelegate(null);
                }
                if (this.cVn != null) {
                    this.cVn.onMovedToScrapHeap(view);
                }
            }
        }

        public void aoT() {
            if (this.cVt != null) {
                int size = this.cVt.size();
                for (int i = 0; i < size; i++) {
                    AbsHListView.this.removeDetachedView(this.cVt.get(i), false);
                }
                this.cVt.clear();
            }
        }

        @SuppressLint({"NewApi"})
        public void aoU() {
            View[] viewArr = this.cVp;
            boolean z = this.cVn != null;
            boolean z2 = this.cVr > 1;
            ArrayList<View> arrayList = this.cVs;
            for (int length = viewArr.length - 1; length >= 0; length--) {
                View view = viewArr[length];
                if (view != null) {
                    f fVar = (f) view.getLayoutParams();
                    int i = fVar.cUZ;
                    viewArr[length] = null;
                    if (!kS(i)) {
                        if (i != -2) {
                            AbsHListView.this.removeDetachedView(view, false);
                        }
                    } else {
                        if (z2) {
                            arrayList = this.cVq[i];
                        }
                        view.onStartTemporaryDetach();
                        fVar.cVc = this.cVo + length;
                        arrayList.add(view);
                        if (Build.VERSION.SDK_INT >= 14) {
                            view.setAccessibilityDelegate(null);
                        }
                        if (z) {
                            this.cVn.onMovedToScrapHeap(view);
                        }
                    }
                }
            }
            aoV();
        }

        @SuppressLint({"NewApi"})
        private void aoV() {
            int length = this.cVp.length;
            int i = this.cVr;
            ArrayList<View>[] arrayListArr = this.cVq;
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
            if (this.cVu != null) {
                for (int i6 = 0; i6 < this.cVu.size(); i6++) {
                    this.cVu.valueAt(i6);
                }
            }
        }

        void setCacheColorHint(int i) {
            View[] viewArr;
            if (this.cVr == 1) {
                ArrayList<View> arrayList = this.cVs;
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    arrayList.get(i2).setDrawingCacheBackgroundColor(i);
                }
            } else {
                int i3 = this.cVr;
                for (int i4 = 0; i4 < i3; i4++) {
                    ArrayList<View> arrayList2 = this.cVq[i4];
                    int size2 = arrayList2.size();
                    for (int i5 = 0; i5 < size2; i5++) {
                        arrayList2.get(i5).setDrawingCacheBackgroundColor(i);
                    }
                }
            }
            for (View view : this.cVp) {
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
                if (((f) view.getLayoutParams()).cVc == i2) {
                    arrayList.remove(i3);
                    return view;
                }
            }
            return arrayList.remove(size - 1);
        }
        return null;
    }
}
