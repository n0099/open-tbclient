package com.baidu.tieba.horizonalList.widget;

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
import com.baidu.location.BDLocation;
import com.baidu.tieba.horizonalList.a.b;
import com.baidu.tieba.horizonalList.widget.g;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class AbsHListView extends com.baidu.tieba.horizonalList.widget.g<ListAdapter> implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnTouchModeChangeListener {
    static final Interpolator cEm = new LinearInterpolator();
    public static final int[] cEo = new int[1];
    Drawable Hm;
    b.a cCU;
    protected int cCV;
    public Object cCW;
    Object cCX;
    int cCY;
    protected SparseArrayCompat<Boolean> cCZ;
    private e cDA;
    protected j cDB;
    protected int cDC;
    protected boolean cDD;
    private h cDE;
    private boolean cDF;
    private Rect cDG;
    protected int cDH;
    private ContextMenu.ContextMenuInfo cDI;
    protected int cDJ;
    private int cDK;
    private c cDL;
    private Runnable cDM;
    private b cDN;
    private i cDO;
    private Runnable cDP;
    private int cDQ;
    private int cDR;
    private boolean cDS;
    private int cDT;
    private Runnable cDU;
    protected Runnable cDV;
    private float cDW;
    protected final boolean[] cDX;
    int cDY;
    int cDZ;
    LongSparseArray<Integer> cDa;
    protected int cDb;
    protected a cDc;
    boolean cDd;
    boolean cDe;
    int cDf;
    protected Rect cDg;
    protected final k cDh;
    int cDi;
    int cDj;
    int cDk;
    int cDl;
    protected Rect cDm;
    protected int cDn;
    View cDo;
    View cDp;
    protected boolean cDq;
    protected boolean cDr;
    protected int cDs;
    int cDt;
    int cDu;
    int cDv;
    int cDw;
    protected int cDx;
    int cDy;
    int cDz;
    private EdgeEffectCompat cEa;
    private EdgeEffectCompat cEb;
    private int cEc;
    private int cEd;
    private boolean cEe;
    private int cEf;
    private int cEg;
    private g cEh;
    private int cEi;
    private int cEj;
    protected boolean cEk;
    private int cEl;
    private SavedState cEn;
    private float cEp;
    private int mActivePointerId;
    protected ListAdapter mAdapter;
    private int mDirection;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    boolean mScrollingCacheEnabled;
    private int mTouchSlop;
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

    protected abstract void fl(boolean z);

    protected abstract int ki(int i2);

    public abstract void setSelectionInt(int i2);

    public AbsHListView(Context context) {
        super(context);
        this.cCV = 0;
        this.cDb = 0;
        this.cDe = false;
        this.cDf = -1;
        this.cDg = new Rect();
        this.cDh = new k();
        this.cDi = 0;
        this.cDj = 0;
        this.cDk = 0;
        this.cDl = 0;
        this.cDm = new Rect();
        this.cDn = 0;
        this.cDx = -1;
        this.cDC = 0;
        this.cDF = true;
        this.cDH = -1;
        this.cDI = null;
        this.cDK = -1;
        this.cDT = 0;
        this.cDW = 1.0f;
        this.cDX = new boolean[1];
        this.mActivePointerId = -1;
        this.mDirection = 0;
        alc();
    }

    public AbsHListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, w.c.hlv_absHListViewStyle);
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
        this.cCV = 0;
        this.cDb = 0;
        this.cDe = false;
        this.cDf = -1;
        this.cDg = new Rect();
        this.cDh = new k();
        this.cDi = 0;
        this.cDj = 0;
        this.cDk = 0;
        this.cDl = 0;
        this.cDm = new Rect();
        this.cDn = 0;
        this.cDx = -1;
        this.cDC = 0;
        this.cDF = true;
        this.cDH = -1;
        this.cDI = null;
        this.cDK = -1;
        this.cDT = 0;
        this.cDW = 1.0f;
        this.cDX = new boolean[1];
        this.mActivePointerId = -1;
        this.mDirection = 0;
        alc();
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, w.n.HListView, i2, 0);
        if (obtainStyledAttributes != null) {
            drawable = obtainStyledAttributes.getDrawable(0);
            z3 = obtainStyledAttributes.getBoolean(1, false);
            z2 = obtainStyledAttributes.getBoolean(6, false);
            z = obtainStyledAttributes.getBoolean(2, true);
            i3 = obtainStyledAttributes.getInt(7, 0);
            i4 = obtainStyledAttributes.getColor(3, 0);
            z4 = obtainStyledAttributes.getBoolean(5, true);
            i5 = obtainStyledAttributes.getInt(4, 0);
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
        this.cDe = z3;
        setStackFromRight(z2);
        setScrollingCacheEnabled(z);
        setTranscriptMode(i3);
        setCacheColorHint(i4);
        setSmoothScrollbarEnabled(z4);
        setChoiceMode(i5);
    }

    private void alc() {
        setClickable(true);
        setFocusableInTouchMode(true);
        setWillNotDraw(false);
        setAlwaysDrawnWithCacheEnabled(false);
        setScrollingCacheEnabled(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.cDY = viewConfiguration.getScaledOverscrollDistance();
        this.cDZ = viewConfiguration.getScaledOverflingDistance();
        this.cCU = com.baidu.tieba.horizonalList.a.b.av(this);
    }

    @Override // android.view.View
    public void setOverScrollMode(int i2) {
        if (i2 != 2) {
            if (this.cEa == null) {
                Context context = getContext();
                this.cEa = new EdgeEffectCompat(context);
                this.cEb = new EdgeEffectCompat(context);
            }
        } else {
            this.cEa = null;
            this.cEb = null;
        }
        super.setOverScrollMode(i2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.horizonalList.widget.g
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            this.cDd = this.mAdapter.hasStableIds();
            if (this.cCV != 0 && this.cDd && this.cDa == null) {
                this.cDa = new LongSparseArray<>();
            }
        }
        if (this.cCZ != null) {
            this.cCZ.clear();
        }
        if (this.cDa != null) {
            this.cDa.clear();
        }
    }

    public int getCheckedItemCount() {
        return this.cCY;
    }

    public boolean isItemChecked(int i2) {
        if (this.cCV == 0 || this.cCZ == null) {
            return false;
        }
        return this.cCZ.get(i2, false).booleanValue();
    }

    public int getCheckedItemPosition() {
        if (this.cCV == 1 && this.cCZ != null && this.cCZ.size() == 1) {
            return this.cCZ.keyAt(0);
        }
        return -1;
    }

    public SparseArrayCompat<Boolean> getCheckedItemPositions() {
        if (this.cCV != 0) {
            return this.cCZ;
        }
        return null;
    }

    public long[] getCheckedItemIds() {
        if (this.cCV == 0 || this.cDa == null || this.mAdapter == null) {
            return new long[0];
        }
        LongSparseArray<Integer> longSparseArray = this.cDa;
        int size = longSparseArray.size();
        long[] jArr = new long[size];
        for (int i2 = 0; i2 < size; i2++) {
            jArr[i2] = longSparseArray.keyAt(i2);
        }
        return jArr;
    }

    public void clearChoices() {
        if (this.cCZ != null) {
            this.cCZ.clear();
        }
        if (this.cDa != null) {
            this.cDa.clear();
        }
        this.cCY = 0;
    }

    public void setItemChecked(int i2, boolean z) {
        if (this.cCV != 0) {
            if (Build.VERSION.SDK_INT >= 11 && z && this.cCV == 3 && this.cCW == null) {
                if (this.cCX == null || !((com.baidu.tieba.horizonalList.a.a.b) this.cCX).alb()) {
                    throw new IllegalStateException("AbsListView: attempted to start selection mode for CHOICE_MODE_MULTIPLE_MODAL but no choice mode callback was supplied. Call setMultiChoiceModeListener to set a callback.");
                }
                this.cCW = startActionMode((com.baidu.tieba.horizonalList.a.a.b) this.cCX);
            }
            if (this.cCV == 2 || (Build.VERSION.SDK_INT >= 11 && this.cCV == 3)) {
                boolean booleanValue = this.cCZ.get(i2, false).booleanValue();
                this.cCZ.put(i2, Boolean.valueOf(z));
                if (this.cDa != null && this.mAdapter.hasStableIds()) {
                    if (z) {
                        this.cDa.put(this.mAdapter.getItemId(i2), Integer.valueOf(i2));
                    } else {
                        this.cDa.delete(this.mAdapter.getItemId(i2));
                    }
                }
                if (booleanValue != z) {
                    if (z) {
                        this.cCY++;
                    } else {
                        this.cCY--;
                    }
                }
                if (this.cCW != null) {
                    ((com.baidu.tieba.horizonalList.a.a.b) this.cCX).onItemCheckedStateChanged((ActionMode) this.cCW, i2, this.mAdapter.getItemId(i2), z);
                }
            } else {
                boolean z2 = this.cDa != null && this.mAdapter.hasStableIds();
                if (z || isItemChecked(i2)) {
                    this.cCZ.clear();
                    if (z2) {
                        this.cDa.clear();
                    }
                }
                if (z) {
                    this.cCZ.put(i2, true);
                    if (z2) {
                        this.cDa.put(this.mAdapter.getItemId(i2), Integer.valueOf(i2));
                    }
                    this.cCY = 1;
                } else if (this.cCZ.size() == 0 || !this.cCZ.valueAt(0).booleanValue()) {
                    this.cCY = 0;
                }
            }
            if (!this.mInLayout && !this.cFx) {
                this.ajr = true;
                alR();
                requestLayout();
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.g
    public boolean performItemClick(View view, int i2, long j2) {
        boolean z;
        boolean z2;
        boolean z3 = true;
        boolean z4 = false;
        if (this.cCV != 0) {
            if (this.cCV == 2 || (Build.VERSION.SDK_INT >= 11 && this.cCV == 3 && this.cCW != null)) {
                boolean z5 = !this.cCZ.get(i2, false).booleanValue();
                this.cCZ.put(i2, Boolean.valueOf(z5));
                if (this.cDa != null && this.mAdapter.hasStableIds()) {
                    if (z5) {
                        this.cDa.put(this.mAdapter.getItemId(i2), Integer.valueOf(i2));
                    } else {
                        this.cDa.delete(this.mAdapter.getItemId(i2));
                    }
                }
                if (z5) {
                    this.cCY++;
                } else {
                    this.cCY--;
                }
                if (this.cCW != null) {
                    ((com.baidu.tieba.horizonalList.a.a.b) this.cCX).onItemCheckedStateChanged((ActionMode) this.cCW, i2, j2, z5);
                } else {
                    z4 = true;
                }
                z2 = z4;
                z4 = true;
            } else if (this.cCV == 1) {
                if (!this.cCZ.get(i2, false).booleanValue()) {
                    this.cCZ.clear();
                    this.cCZ.put(i2, true);
                    if (this.cDa != null && this.mAdapter.hasStableIds()) {
                        this.cDa.clear();
                        this.cDa.put(this.mAdapter.getItemId(i2), Integer.valueOf(i2));
                    }
                    this.cCY = 1;
                } else if (this.cCZ.size() == 0 || !this.cCZ.valueAt(0).booleanValue()) {
                    this.cCY = 0;
                }
                z4 = true;
                z2 = true;
            } else {
                z2 = true;
            }
            if (z4) {
                ald();
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

    private void ald() {
        int i2 = this.cFc;
        int childCount = getChildCount();
        boolean z = Build.VERSION.SDK_INT >= 11;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            int i4 = i2 + i3;
            if (childAt instanceof Checkable) {
                ((Checkable) childAt).setChecked(this.cCZ.get(i4, false).booleanValue());
            } else if (z) {
                childAt.setActivated(this.cCZ.get(i4, false).booleanValue());
            }
        }
    }

    public int getChoiceMode() {
        return this.cCV;
    }

    public void setChoiceMode(int i2) {
        this.cCV = i2;
        if (Build.VERSION.SDK_INT >= 11 && this.cCW != null) {
            if (Build.VERSION.SDK_INT >= 11) {
                ((ActionMode) this.cCW).finish();
            }
            this.cCW = null;
        }
        if (this.cCV != 0) {
            if (this.cCZ == null) {
                this.cCZ = new SparseArrayCompat<>();
            }
            if (this.cDa == null && this.mAdapter != null && this.mAdapter.hasStableIds()) {
                this.cDa = new LongSparseArray<>();
            }
            if (Build.VERSION.SDK_INT >= 11 && this.cCV == 3) {
                clearChoices();
                setLongClickable(true);
            }
        }
    }

    public void setMultiChoiceModeListener(com.baidu.tieba.horizonalList.a.a.a aVar) {
        if (Build.VERSION.SDK_INT >= 11) {
            if (this.cCX == null) {
                this.cCX = new com.baidu.tieba.horizonalList.a.a.b(this);
            }
            ((com.baidu.tieba.horizonalList.a.a.b) this.cCX).a(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ale() {
        int childCount = getChildCount();
        if (childCount == 0) {
            return true;
        }
        if (childCount != this.cFp) {
            return false;
        }
        return getChildAt(0).getLeft() >= this.cDm.left && getChildAt(childCount + (-1)).getRight() <= getWidth() - this.cDm.right;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public int getHorizontalScrollbarHeight() {
        return super.getHorizontalScrollbarHeight();
    }

    public void setSmoothScrollbarEnabled(boolean z) {
        this.cDF = z;
    }

    public void setOnScrollListener(h hVar) {
        this.cDE = hVar;
        alf();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void alf() {
        if (this.cDE != null) {
            this.cDE.a(this, this.cFc, getChildCount(), this.cFp);
        }
        onScrollChanged(0, 0, 0, 0);
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEvent(int i2) {
        if (i2 == 4096) {
            int firstVisiblePosition = getFirstVisiblePosition();
            int lastVisiblePosition = getLastVisiblePosition();
            if (this.cEi != firstVisiblePosition || this.cEj != lastVisiblePosition) {
                this.cEi = firstVisiblePosition;
                this.cEj = lastVisiblePosition;
            } else {
                return;
            }
        }
        super.sendAccessibilityEvent(i2);
    }

    @Override // com.baidu.tieba.horizonalList.widget.g, android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(AbsHListView.class.getName());
    }

    @Override // com.baidu.tieba.horizonalList.widget.g, android.view.View
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
            alt();
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

    private void alg() {
        setSelector(getResources().getDrawable(17301602));
    }

    public void setStackFromRight(boolean z) {
        if (this.cDD != z) {
            this.cDD = z;
            alh();
        }
    }

    void alh() {
        if (getChildCount() > 0) {
            ali();
            requestLayout();
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new com.baidu.tieba.horizonalList.widget.f();
        long cET;
        long cEU;
        int cEV;
        String cEW;
        boolean cEX;
        int cEY;
        SparseArrayCompat<Boolean> cEZ;
        LongSparseArray<Integer> cFa;
        int position;
        int width;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ SavedState(Parcel parcel, SavedState savedState) {
            this(parcel);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.cET = parcel.readLong();
            this.cEU = parcel.readLong();
            this.cEV = parcel.readInt();
            this.position = parcel.readInt();
            this.width = parcel.readInt();
            this.cEW = parcel.readString();
            this.cEX = parcel.readByte() != 0;
            this.cEY = parcel.readInt();
            this.cEZ = h(parcel);
            this.cFa = g(parcel);
        }

        private LongSparseArray<Integer> g(Parcel parcel) {
            int readInt = parcel.readInt();
            if (readInt <= 0) {
                return null;
            }
            LongSparseArray<Integer> longSparseArray = new LongSparseArray<>(readInt);
            a(longSparseArray, parcel, readInt);
            return longSparseArray;
        }

        private SparseArrayCompat<Boolean> h(Parcel parcel) {
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
            parcel.writeLong(this.cET);
            parcel.writeLong(this.cEU);
            parcel.writeInt(this.cEV);
            parcel.writeInt(this.position);
            parcel.writeInt(this.width);
            parcel.writeString(this.cEW);
            parcel.writeByte((byte) (this.cEX ? 1 : 0));
            parcel.writeInt(this.cEY);
            a(this.cEZ, parcel);
            a(this.cFa, parcel);
        }

        public String toString() {
            return "AbsListView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " selectedId=" + this.cET + " firstId=" + this.cEU + " viewLeft=" + this.cEV + " position=" + this.position + " width=" + this.width + " filter=" + this.cEW + " checkState=" + this.cEZ + "}";
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        boolean z = true;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.cEn != null) {
            savedState.cET = this.cEn.cET;
            savedState.cEU = this.cEn.cEU;
            savedState.cEV = this.cEn.cEV;
            savedState.position = this.cEn.position;
            savedState.width = this.cEn.width;
            savedState.cEW = this.cEn.cEW;
            savedState.cEX = this.cEn.cEX;
            savedState.cEY = this.cEn.cEY;
            savedState.cEZ = this.cEn.cEZ;
            savedState.cFa = this.cEn.cFa;
            return savedState;
        }
        boolean z2 = getChildCount() > 0 && this.cFp > 0;
        long selectedItemId = getSelectedItemId();
        savedState.cET = selectedItemId;
        savedState.width = getWidth();
        if (selectedItemId >= 0) {
            savedState.cEV = this.cDC;
            savedState.position = getSelectedItemPosition();
            savedState.cEU = -1L;
        } else if (z2 && this.cFc > 0) {
            savedState.cEV = getChildAt(0).getLeft();
            int i2 = this.cFc;
            if (i2 >= this.cFp) {
                i2 = this.cFp - 1;
            }
            savedState.position = i2;
            savedState.cEU = this.mAdapter.getItemId(i2);
        } else {
            savedState.cEV = 0;
            savedState.cEU = -1L;
            savedState.position = 0;
        }
        savedState.cEW = null;
        savedState.cEX = (Build.VERSION.SDK_INT < 11 || this.cCV != 3 || this.cCW == null) ? false : false;
        if (this.cCZ != null) {
            try {
                savedState.cEZ = this.cCZ.m1clone();
            } catch (NoSuchMethodError e2) {
                e2.printStackTrace();
                savedState.cEZ = new SparseArrayCompat<>();
            }
        }
        if (this.cDa != null) {
            LongSparseArray<Integer> longSparseArray = new LongSparseArray<>();
            int size = this.cDa.size();
            for (int i3 = 0; i3 < size; i3++) {
                longSparseArray.put(this.cDa.keyAt(i3), this.cDa.valueAt(i3));
            }
            savedState.cFa = longSparseArray;
        }
        savedState.cEY = this.cCY;
        return savedState;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.ajr = true;
        this.cFg = savedState.width;
        if (savedState.cET >= 0) {
            this.cFh = true;
            this.cEn = savedState;
            this.cFf = savedState.cET;
            this.cFe = savedState.position;
            this.cFd = savedState.cEV;
            this.cFi = 0;
        } else if (savedState.cEU >= 0) {
            setSelectedPositionInt(-1);
            setNextSelectedPositionInt(-1);
            this.cDf = -1;
            this.cFh = true;
            this.cEn = savedState;
            this.cFf = savedState.cEU;
            this.cFe = savedState.position;
            this.cFd = savedState.cEV;
            this.cFi = 1;
        }
        if (savedState.cEZ != null) {
            this.cCZ = savedState.cEZ;
        }
        if (savedState.cFa != null) {
            this.cDa = savedState.cFa;
        }
        this.cCY = savedState.cEY;
        if (Build.VERSION.SDK_INT >= 11 && savedState.cEX && this.cCV == 3 && this.cCX != null) {
            this.cCW = startActionMode((com.baidu.tieba.horizonalList.a.a.b) this.cCX);
        }
        requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onFocusChanged(boolean z, int i2, Rect rect) {
        super.onFocusChanged(z, i2, rect);
        if (z && this.clD < 0 && !isInTouchMode()) {
            if (!this.cEk && this.mAdapter != null) {
                this.ajr = true;
                this.cFq = this.cFp;
                this.cFp = this.mAdapter.getCount();
            }
            alx();
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (!this.cFx && !this.mInLayout) {
            super.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ali() {
        removeAllViewsInLayout();
        this.cFc = 0;
        this.ajr = false;
        this.cDV = null;
        this.cFh = false;
        this.cEn = null;
        this.cFs = -1;
        this.cFt = Long.MIN_VALUE;
        setSelectedPositionInt(-1);
        setNextSelectedPositionInt(-1);
        this.cDC = 0;
        this.cDf = -1;
        this.cDg.setEmpty();
        invalidate();
    }

    @Override // android.view.View
    protected int computeHorizontalScrollExtent() {
        int childCount = getChildCount();
        if (childCount > 0) {
            if (this.cDF) {
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
        int i3 = this.cFc;
        int childCount = getChildCount();
        if (i3 < 0 || childCount <= 0) {
            return 0;
        }
        if (this.cDF) {
            View childAt = getChildAt(0);
            int left = childAt.getLeft();
            int width = childAt.getWidth();
            if (width > 0) {
                return Math.max(((i3 * 100) - ((left * 100) / width)) + ((int) ((getScrollX() / getWidth()) * this.cFp * 100.0f)), 0);
            }
            return 0;
        }
        int i4 = this.cFp;
        if (i3 != 0) {
            i2 = i3 + childCount == i4 ? i4 : (childCount / 2) + i3;
        }
        return (int) (((i2 / i4) * childCount) + i3);
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        if (this.cDF) {
            int max = Math.max(this.cFp * 100, 0);
            if (getScrollX() != 0) {
                return max + Math.abs((int) ((getScrollX() / getWidth()) * this.cFp * 100.0f));
            }
            return max;
        }
        return this.cFp;
    }

    @Override // android.view.View
    protected float getLeftFadingEdgeStrength() {
        int childCount = getChildCount();
        float leftFadingEdgeStrength = super.getLeftFadingEdgeStrength();
        if (childCount != 0) {
            if (this.cFc > 0) {
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
            if ((this.cFc + childCount) - 1 < this.cFp - 1) {
                return 1.0f;
            }
            int right = getChildAt(childCount - 1).getRight();
            int width = getWidth();
            float horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
            if (right <= width - getPaddingRight()) {
                return rightFadingEdgeStrength;
            }
            return ((right - width) + getPaddingRight()) / horizontalFadingEdgeLength;
        }
        return rightFadingEdgeStrength;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        if (this.Hm == null) {
            alg();
        }
        Rect rect = this.cDm;
        rect.left = this.cDi + getPaddingLeft();
        rect.top = this.cDj + getPaddingTop();
        rect.right = this.cDk + getPaddingRight();
        rect.bottom = this.cDl + getPaddingBottom();
        if (this.cDQ == 1) {
            int childCount = getChildCount();
            int width = getWidth() - getPaddingRight();
            View childAt = getChildAt(childCount - 1);
            this.cEe = childCount + this.cFc >= this.cEl && (childAt != null ? childAt.getRight() : width) <= width;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.g, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        this.mInLayout = true;
        if (z) {
            int childCount = getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                getChildAt(i6).forceLayout();
            }
            this.cDh.alD();
        }
        layoutChildren();
        this.mInLayout = false;
        this.cDJ = (i4 - i2) / 3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void layoutChildren() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void alj() {
        boolean z = true;
        if (this.cDo != null) {
            boolean z2 = this.cFc > 0;
            if (!z2 && getChildCount() > 0) {
                z2 = getChildAt(0).getLeft() < this.cDm.left;
            }
            this.cDo.setVisibility(z2 ? 0 : 4);
        }
        if (this.cDp != null) {
            int childCount = getChildCount();
            boolean z3 = this.cFc + childCount < this.cFp;
            if (z3 || childCount <= 0) {
                z = z3;
            } else if (getChildAt(childCount - 1).getRight() <= getRight() - this.cDm.right) {
                z = false;
            }
            this.cDp.setVisibility(z ? 0 : 4);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.g
    @ViewDebug.ExportedProperty
    public View getSelectedView() {
        if (this.cFp <= 0 || this.clD < 0) {
            return null;
        }
        return getChildAt(this.clD - this.cFc);
    }

    public int getListPaddingTop() {
        return this.cDm.top;
    }

    public int getListPaddingBottom() {
        return this.cDm.bottom;
    }

    public int getListPaddingLeft() {
        return this.cDm.left;
    }

    public int getListPaddingRight() {
        return this.cDm.right;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View b(int i2, boolean[] zArr) {
        View view;
        f fVar;
        zArr[0] = false;
        View kq = this.cDh.kq(i2);
        if (kq == null) {
            View kr = this.cDh.kr(i2);
            if (kr != null) {
                view = this.mAdapter.getView(i2, kr, this);
                if (view != kr) {
                    this.cDh.r(kr, i2);
                    if (this.cDR != 0) {
                        view.setDrawingCacheBackgroundColor(this.cDR);
                        kq = view;
                    }
                } else {
                    zArr[0] = true;
                    view.onFinishTemporaryDetach();
                    kq = view;
                }
                if (this.cDd) {
                    ViewGroup.LayoutParams layoutParams = kq.getLayoutParams();
                    if (layoutParams == null) {
                        fVar = (f) generateDefaultLayoutParams();
                    } else if (!checkLayoutParams(layoutParams)) {
                        fVar = (f) generateLayoutParams(layoutParams);
                    } else {
                        fVar = (f) layoutParams;
                    }
                    fVar.cEB = this.mAdapter.getItemId(i2);
                    kq.setLayoutParams(fVar);
                }
                if (this.cFr.isEnabled() && this.cEh == null) {
                    this.cEh = new g();
                }
            } else {
                view = this.mAdapter.getView(i2, null, this);
                if (this.cDR != 0) {
                    view.setDrawingCacheBackgroundColor(this.cDR);
                }
            }
            kq = view;
            if (this.cDd) {
            }
            if (this.cFr.isEnabled()) {
                this.cEh = new g();
            }
        }
        return kq;
    }

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
                            return AbsHListView.this.c(view, positionForView, itemIdAtPosition);
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
    public void c(int i2, View view) {
        if (i2 != -1) {
            this.cDf = i2;
        }
        Rect rect = this.cDg;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        if (view instanceof m) {
            ((m) view).adjustListItemSelectionBounds(rect);
        }
        j(rect.left, rect.top, rect.right, rect.bottom);
        boolean z = this.cDS;
        if (view.isEnabled() != z) {
            this.cDS = !z;
            if (getSelectedItemPosition() != -1) {
                refreshDrawableState();
            }
        }
    }

    private void j(int i2, int i3, int i4, int i5) {
        this.cDg.set(i2 - this.cDi, i3 - this.cDj, this.cDk + i4, this.cDl + i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        boolean z = this.cDe;
        if (!z) {
            e(canvas);
        }
        super.dispatchDraw(canvas);
        if (z) {
            e(canvas);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        if (getChildCount() > 0) {
            this.ajr = true;
            alR();
        }
    }

    boolean alk() {
        switch (this.cDx) {
            case 1:
            case 2:
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean all() {
        return (hasFocus() && !isInTouchMode()) || alk();
    }

    private void e(Canvas canvas) {
        if (!this.cDg.isEmpty()) {
            Drawable drawable = this.Hm;
            drawable.setBounds(this.cDg);
            drawable.draw(canvas);
        }
    }

    public void setDrawSelectorOnTop(boolean z) {
        this.cDe = z;
    }

    public void setSelector(int i2) {
        setSelector(getResources().getDrawable(i2));
    }

    public void setSelector(Drawable drawable) {
        if (this.Hm != null) {
            this.Hm.setCallback(null);
            unscheduleDrawable(this.Hm);
        }
        this.Hm = drawable;
        Rect rect = new Rect();
        drawable.getPadding(rect);
        this.cDi = rect.left;
        this.cDj = rect.top;
        this.cDk = rect.right;
        this.cDl = rect.bottom;
        drawable.setCallback(this);
        aln();
    }

    public Drawable getSelector() {
        return this.Hm;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void alm() {
        if (isEnabled() && isClickable()) {
            Drawable drawable = this.Hm;
            Rect rect = this.cDg;
            if (drawable != null) {
                if ((isFocused() || alk()) && !rect.isEmpty()) {
                    View childAt = getChildAt(this.clD - this.cFc);
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
                    if (isLongClickable && !this.ajr) {
                        if (this.cDN == null) {
                            this.cDN = new b(this, null);
                        }
                        this.cDN.alI();
                        postDelayed(this.cDN, ViewConfiguration.getLongPressTimeout());
                    }
                }
            }
        }
    }

    void aln() {
        if (this.Hm != null) {
            if (all()) {
                this.Hm.setState(getDrawableState());
            } else {
                this.Hm.setState(cEo);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        aln();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i2) {
        if (this.cDS) {
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
        return this.Hm == drawable || super.verifyDrawable(drawable);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.Hm != null) {
            this.Hm.jumpToCurrentState();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnTouchModeChangeListener(this);
        if (this.mAdapter != null && this.cDc == null) {
            this.cDc = new a();
            this.mAdapter.registerDataSetObserver(this.cDc);
            this.ajr = true;
            this.cFq = this.cFp;
            this.cFp = this.mAdapter.getCount();
        }
        this.cEk = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.g, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.cDh.clear();
        getViewTreeObserver().removeOnTouchModeChangeListener(this);
        if (this.mAdapter != null && this.cDc != null) {
            this.mAdapter.unregisterDataSetObserver(this.cDc);
            this.cDc = null;
        }
        if (this.cDA != null) {
            removeCallbacks(this.cDA);
        }
        if (this.cDB != null) {
            this.cDB.stop();
        }
        if (this.cDU != null) {
            removeCallbacks(this.cDU);
        }
        if (this.cDO != null) {
            removeCallbacks(this.cDO);
        }
        if (this.cDP != null) {
            removeCallbacks(this.cDP);
            this.cDP = null;
        }
        this.cEk = false;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        int i2 = isInTouchMode() ? 0 : 1;
        if (!z) {
            setChildrenDrawingCacheEnabled(false);
            if (this.cDA != null) {
                removeCallbacks(this.cDA);
                this.cDA.alB();
                if (this.cDB != null) {
                    this.cDB.stop();
                }
                if (getScrollX() != 0) {
                    this.cCU.setScrollX(0);
                    alz();
                    invalidate();
                }
            }
            if (i2 == 1) {
                this.cDH = this.clD;
            }
        } else if (i2 != this.cDK && this.cDK != -1) {
            if (i2 == 1) {
                alx();
            } else {
                alu();
                this.cDb = 0;
                layoutChildren();
            }
        }
        this.cDK = i2;
    }

    ContextMenu.ContextMenuInfo b(View view, int i2, long j2) {
        return new g.a(view, i2, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class n {
        private int cFb;

        private n() {
        }

        /* synthetic */ n(AbsHListView absHListView, n nVar) {
            this();
        }

        public void alI() {
            this.cFb = AbsHListView.this.getWindowAttachCount();
        }

        public boolean alJ() {
            return AbsHListView.this.hasWindowFocus() && AbsHListView.this.getWindowAttachCount() == this.cFb;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class i extends n implements Runnable {
        int cEC;

        private i() {
            super(AbsHListView.this, null);
        }

        /* synthetic */ i(AbsHListView absHListView, i iVar) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            View childAt;
            if (!AbsHListView.this.ajr) {
                ListAdapter listAdapter = AbsHListView.this.mAdapter;
                int i = this.cEC;
                if (listAdapter != null && AbsHListView.this.cFp > 0 && i != -1 && i < listAdapter.getCount() && alJ() && (childAt = AbsHListView.this.getChildAt(i - AbsHListView.this.cFc)) != null) {
                    AbsHListView.this.performItemClick(childAt, i, listAdapter.getItemId(i));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends n implements Runnable {
        private c() {
            super(AbsHListView.this, null);
        }

        /* synthetic */ c(AbsHListView absHListView, c cVar) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            View childAt = AbsHListView.this.getChildAt(AbsHListView.this.cDs - AbsHListView.this.cFc);
            if (childAt != null) {
                if ((!alJ() || AbsHListView.this.ajr) ? false : AbsHListView.this.c(childAt, AbsHListView.this.cDs, AbsHListView.this.mAdapter.getItemId(AbsHListView.this.cDs))) {
                    AbsHListView.this.cDx = -1;
                    AbsHListView.this.setPressed(false);
                    childAt.setPressed(false);
                    return;
                }
                AbsHListView.this.cDx = 2;
            }
        }
    }

    /* loaded from: classes.dex */
    private class b extends n implements Runnable {
        private b() {
            super(AbsHListView.this, null);
        }

        /* synthetic */ b(AbsHListView absHListView, b bVar) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AbsHListView.this.isPressed() && AbsHListView.this.clD >= 0) {
                View childAt = AbsHListView.this.getChildAt(AbsHListView.this.clD - AbsHListView.this.cFc);
                if (!AbsHListView.this.ajr) {
                    if (alJ() ? AbsHListView.this.c(childAt, AbsHListView.this.clD, AbsHListView.this.cFo) : false) {
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

    boolean c(View view, int i2, long j2) {
        if (Build.VERSION.SDK_INT >= 11 && this.cCV == 3) {
            if (this.cCW == null) {
                ActionMode startActionMode = startActionMode((com.baidu.tieba.horizonalList.a.a.b) this.cCX);
                this.cCW = startActionMode;
                if (startActionMode != null) {
                    setItemChecked(i2, true);
                    performHapticFeedback(0);
                }
            }
            return true;
        }
        boolean b2 = this.cFl != null ? this.cFl.b(this, view, i2, j2) : false;
        if (!b2) {
            this.cDI = b(view, i2, j2);
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
        return this.cDI;
    }

    public boolean a(float f2, float f3, int i2) {
        int pointToPosition = pointToPosition((int) f2, (int) f3);
        if (pointToPosition != -1) {
            long itemId = this.mAdapter.getItemId(pointToPosition);
            View childAt = getChildAt(pointToPosition - this.cFc);
            if (childAt != null) {
                this.cDI = b(childAt, pointToPosition, itemId);
                return super.showContextMenuForChild(this);
            }
        }
        return a(f2, f3, i2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean showContextMenuForChild(View view) {
        int positionForView = getPositionForView(view);
        if (positionForView >= 0) {
            long itemId = this.mAdapter.getItemId(positionForView);
            boolean b2 = this.cFl != null ? this.cFl.b(this, view, positionForView, itemId) : false;
            if (!b2) {
                this.cDI = b(getChildAt(positionForView - this.cFc), positionForView, itemId);
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
            case BDLocation.TypeOffLineLocation /* 66 */:
                if (!isEnabled()) {
                    return true;
                }
                if (isClickable() && isPressed() && this.clD >= 0 && this.mAdapter != null && this.clD < this.mAdapter.getCount()) {
                    View childAt = getChildAt(this.clD - this.cFc);
                    if (childAt != null) {
                        performItemClick(childAt, this.clD, this.cFo);
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
        Rect rect = this.cDG;
        if (rect == null) {
            this.cDG = new Rect();
            rect = this.cDG;
        }
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt.getVisibility() == 0) {
                childAt.getHitRect(rect);
                if (rect.contains(i2, i3)) {
                    return this.cFc + childCount;
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
            if (AbsHListView.this.cDx == 0) {
                AbsHListView.this.cDx = 1;
                View childAt = AbsHListView.this.getChildAt(AbsHListView.this.cDs - AbsHListView.this.cFc);
                if (childAt != null && !childAt.hasFocusable()) {
                    AbsHListView.this.cDb = 0;
                    if (!AbsHListView.this.ajr) {
                        childAt.setPressed(true);
                        AbsHListView.this.setPressed(true);
                        AbsHListView.this.layoutChildren();
                        AbsHListView.this.c(AbsHListView.this.cDs, childAt);
                        AbsHListView.this.refreshDrawableState();
                        int longPressTimeout = ViewConfiguration.getLongPressTimeout();
                        boolean isLongClickable = AbsHListView.this.isLongClickable();
                        if (AbsHListView.this.Hm != null && (current = AbsHListView.this.Hm.getCurrent()) != null && (current instanceof TransitionDrawable)) {
                            if (isLongClickable) {
                                ((TransitionDrawable) current).startTransition(longPressTimeout);
                            } else {
                                ((TransitionDrawable) current).resetTransition();
                            }
                        }
                        if (isLongClickable) {
                            if (AbsHListView.this.cDL == null) {
                                AbsHListView.this.cDL = new c(AbsHListView.this, null);
                            }
                            AbsHListView.this.cDL.alI();
                            AbsHListView.this.postDelayed(AbsHListView.this.cDL, longPressTimeout);
                            return;
                        }
                        AbsHListView.this.cDx = 2;
                        return;
                    }
                    AbsHListView.this.cDx = 2;
                }
            }
        }
    }

    private boolean ke(int i2) {
        int i3 = i2 - this.cDv;
        int abs = Math.abs(i3);
        boolean z = getScrollX() != 0;
        if (z || abs > this.mTouchSlop) {
            als();
            if (z) {
                this.cDx = 5;
                this.cDz = 0;
            } else {
                this.cDx = 3;
                this.cDz = i3 > 0 ? this.mTouchSlop : -this.mTouchSlop;
            }
            Handler handler = getHandler();
            if (handler != null) {
                handler.removeCallbacks(this.cDL);
            }
            setPressed(false);
            View childAt = getChildAt(this.cDs - this.cFc);
            if (childAt != null) {
                childAt.setPressed(false);
            }
            kg(1);
            ViewParent parent = getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            kf(i2);
            return true;
        }
        return false;
    }

    private void kf(int i2) {
        int i3;
        int childCount;
        ViewParent parent;
        int i4 = i2 - this.cDv;
        int i5 = i4 - this.cDz;
        int i6 = this.cDy != Integer.MIN_VALUE ? i2 - this.cDy : i5;
        if (this.cDx == 3) {
            if (i2 != this.cDy) {
                if (Math.abs(i4) > this.mTouchSlop && (parent = getParent()) != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
                if (this.cDs >= 0) {
                    childCount = this.cDs - this.cFc;
                } else {
                    childCount = getChildCount() / 2;
                }
                View childAt = getChildAt(childCount);
                int left = childAt != null ? childAt.getLeft() : 0;
                boolean ay = i6 != 0 ? ay(i5, i6) : false;
                View childAt2 = getChildAt(childCount);
                if (childAt2 != null) {
                    int left2 = childAt2.getLeft();
                    if (ay) {
                        int i7 = (-i6) - (left2 - left);
                        overScrollBy(i7, 0, getScrollX(), 0, 0, 0, this.cDY, 0, true);
                        if (Math.abs(this.cDY) == Math.abs(getScrollX()) && this.mVelocityTracker != null) {
                            this.mVelocityTracker.clear();
                        }
                        int overScrollMode = getOverScrollMode();
                        if (overScrollMode == 0 || (overScrollMode == 1 && !ale())) {
                            this.mDirection = 0;
                            this.cDx = 5;
                            if (i4 > 0) {
                                this.cEa.onPull(i7 / getWidth());
                                if (!this.cEb.isFinished()) {
                                    this.cEb.onRelease();
                                }
                                invalidate();
                            } else if (i4 < 0) {
                                this.cEb.onPull(i7 / getWidth());
                                if (!this.cEa.isFinished()) {
                                    this.cEa.onRelease();
                                }
                                invalidate();
                            }
                        }
                    }
                    this.cDv = i2;
                }
                this.cDy = i2;
            }
        } else if (this.cDx == 5 && i2 != this.cDy) {
            int scrollX = getScrollX();
            int i8 = scrollX - i6;
            int i9 = i2 > this.cDy ? 1 : -1;
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
                overScrollBy(i10, 0, getScrollX(), 0, 0, 0, this.cDY, 0, true);
                int overScrollMode2 = getOverScrollMode();
                if (overScrollMode2 == 0 || (overScrollMode2 == 1 && !ale())) {
                    if (i4 > 0) {
                        this.cEa.onPull(i10 / getWidth());
                        if (!this.cEb.isFinished()) {
                            this.cEb.onRelease();
                        }
                        invalidate();
                    } else if (i4 < 0) {
                        this.cEb.onPull(i10 / getWidth());
                        if (!this.cEa.isFinished()) {
                            this.cEa.onRelease();
                        }
                        invalidate();
                    }
                }
            }
            if (i3 != 0) {
                if (getScrollX() != 0) {
                    this.cCU.setScrollX(0);
                    alo();
                }
                ay(i3, i3);
                this.cDx = 3;
                int kj = kj(i2);
                this.cDz = 0;
                View childAt3 = getChildAt(kj - this.cFc);
                this.cDt = childAt3 != null ? childAt3.getLeft() : 0;
                this.cDv = i2;
                this.cDs = kj;
            }
            this.cDy = i2;
            this.mDirection = i9;
        }
    }

    protected void alo() {
        if (this.cCU.isHardwareAccelerated() && (getParent() instanceof View)) {
            ((View) getParent()).invalidate();
        }
    }

    @Override // android.view.ViewTreeObserver.OnTouchModeChangeListener
    public void onTouchModeChanged(boolean z) {
        if (z) {
            alu();
            if (getWidth() > 0 && getChildCount() > 0) {
                layoutChildren();
            }
            aln();
            return;
        }
        int i2 = this.cDx;
        if (i2 == 5 || i2 == 6) {
            if (this.cDA != null) {
                this.cDA.alB();
            }
            if (this.cDB != null) {
                this.cDB.stop();
            }
            if (getScrollX() != 0) {
                this.cCU.setScrollX(0);
                alz();
                invalidate();
            }
        }
    }

    protected boolean o(MotionEvent motionEvent) {
        return Build.VERSION.SDK_INT >= 14 && (motionEvent.getButtonState() & 2) != 0 && a(motionEvent.getX(), motionEvent.getY(), motionEvent.getMetaState());
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0083  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        Drawable current;
        int i2;
        if (!isEnabled()) {
            return isClickable() || isLongClickable();
        }
        if (this.cDB != null) {
            this.cDB.stop();
        }
        if (this.cEk) {
            int action = motionEvent.getAction();
            alq();
            this.mVelocityTracker.addMovement(motionEvent);
            switch (action & MotionEventCompat.ACTION_MASK) {
                case 0:
                    switch (this.cDx) {
                        case 6:
                            this.cDA.alB();
                            if (this.cDB != null) {
                                this.cDB.stop();
                            }
                            this.cDx = 5;
                            this.cDw = (int) motionEvent.getY();
                            int x = (int) motionEvent.getX();
                            this.cDy = x;
                            this.cDv = x;
                            this.cDz = 0;
                            this.mActivePointerId = motionEvent.getPointerId(0);
                            this.mDirection = 0;
                            break;
                        default:
                            this.mActivePointerId = motionEvent.getPointerId(0);
                            int x2 = (int) motionEvent.getX();
                            int y = (int) motionEvent.getY();
                            int pointToPosition = pointToPosition(x2, y);
                            if (!this.ajr) {
                                if (this.cDx != 4 && pointToPosition >= 0 && getAdapter().isEnabled(pointToPosition)) {
                                    this.cDx = 0;
                                    if (this.cDM == null) {
                                        this.cDM = new d();
                                    }
                                    postDelayed(this.cDM, ViewConfiguration.getTapTimeout());
                                    i2 = pointToPosition;
                                } else if (this.cDx == 4) {
                                    als();
                                    this.cDx = 3;
                                    this.cDz = 0;
                                    i2 = ki(x2);
                                    this.cDA.alC();
                                }
                                if (i2 >= 0) {
                                    this.cDt = getChildAt(i2 - this.cFc).getLeft();
                                }
                                this.cDv = x2;
                                this.cDw = y;
                                this.cDs = i2;
                                this.cDy = ExploreByTouchHelper.INVALID_ID;
                                break;
                            }
                            i2 = pointToPosition;
                            if (i2 >= 0) {
                            }
                            this.cDv = x2;
                            this.cDw = y;
                            this.cDs = i2;
                            this.cDy = ExploreByTouchHelper.INVALID_ID;
                    }
                    if (o(motionEvent) && this.cDx == 0) {
                        removeCallbacks(this.cDM);
                        break;
                    }
                    break;
                case 1:
                    switch (this.cDx) {
                        case 0:
                        case 1:
                        case 2:
                            int i3 = this.cDs;
                            View childAt = getChildAt(i3 - this.cFc);
                            float x3 = motionEvent.getX();
                            boolean z = x3 > ((float) this.cDm.left) && x3 < ((float) (getWidth() - this.cDm.right));
                            if (childAt != null && !childAt.hasFocusable() && z) {
                                if (this.cDx != 0) {
                                    childAt.setPressed(false);
                                }
                                if (this.cDO == null) {
                                    this.cDO = new i(this, null);
                                }
                                i iVar = this.cDO;
                                iVar.cEC = i3;
                                iVar.alI();
                                this.cDH = i3;
                                if (this.cDx == 0 || this.cDx == 1) {
                                    Handler handler = getHandler();
                                    if (handler != null) {
                                        handler.removeCallbacks(this.cDx == 0 ? this.cDM : this.cDL);
                                    }
                                    this.cDb = 0;
                                    if (!this.ajr && this.mAdapter.isEnabled(i3)) {
                                        this.cDx = 1;
                                        setSelectedPositionInt(this.cDs);
                                        layoutChildren();
                                        childAt.setPressed(true);
                                        c(this.cDs, childAt);
                                        setPressed(true);
                                        if (this.Hm != null && (current = this.Hm.getCurrent()) != null && (current instanceof TransitionDrawable)) {
                                            ((TransitionDrawable) current).resetTransition();
                                        }
                                        if (this.cDP != null) {
                                            removeCallbacks(this.cDP);
                                        }
                                        this.cDP = new com.baidu.tieba.horizonalList.widget.a(this, childAt, iVar);
                                        postDelayed(this.cDP, ViewConfiguration.getPressedStateDuration());
                                    } else {
                                        this.cDx = -1;
                                        aln();
                                    }
                                    return true;
                                } else if (!this.ajr && this.mAdapter.isEnabled(i3)) {
                                    iVar.run();
                                }
                            }
                            this.cDx = -1;
                            aln();
                            break;
                        case 3:
                            int childCount = getChildCount();
                            if (childCount > 0) {
                                int left = getChildAt(0).getLeft();
                                int right = getChildAt(childCount - 1).getRight();
                                int i4 = this.cDm.left;
                                int width = getWidth() - this.cDm.right;
                                if (this.cFc == 0 && left >= i4 && this.cFc + childCount < this.cFp && right <= getWidth() - width) {
                                    this.cDx = -1;
                                    kg(0);
                                    break;
                                } else {
                                    VelocityTracker velocityTracker = this.mVelocityTracker;
                                    velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                                    int xVelocity = (int) (velocityTracker.getXVelocity(this.mActivePointerId) * this.cDW);
                                    if (Math.abs(xVelocity) > this.mMinimumVelocity && ((this.cFc != 0 || left != i4 - this.cDY) && (childCount + this.cFc != this.cFp || right != this.cDY + width))) {
                                        if (this.cDA == null) {
                                            this.cDA = new e();
                                        }
                                        kg(2);
                                        this.cDA.kk(-xVelocity);
                                        break;
                                    } else {
                                        this.cDx = -1;
                                        kg(0);
                                        if (this.cDA != null) {
                                            this.cDA.alB();
                                        }
                                        if (this.cDB != null) {
                                            this.cDB.stop();
                                            break;
                                        }
                                    }
                                }
                            } else {
                                this.cDx = -1;
                                kg(0);
                                break;
                            }
                            break;
                        case 5:
                            if (this.cDA == null) {
                                this.cDA = new e();
                            }
                            VelocityTracker velocityTracker2 = this.mVelocityTracker;
                            velocityTracker2.computeCurrentVelocity(1000, this.mMaximumVelocity);
                            int xVelocity2 = (int) velocityTracker2.getXVelocity(this.mActivePointerId);
                            kg(2);
                            if (Math.abs(xVelocity2) > this.mMinimumVelocity) {
                                this.cDA.kl(-xVelocity2);
                                break;
                            } else {
                                this.cDA.alA();
                                break;
                            }
                    }
                    setPressed(false);
                    if (this.cEa != null) {
                        this.cEa.onRelease();
                        this.cEb.onRelease();
                    }
                    invalidate();
                    Handler handler2 = getHandler();
                    if (handler2 != null) {
                        handler2.removeCallbacks(this.cDL);
                    }
                    alr();
                    this.mActivePointerId = -1;
                    break;
                case 2:
                    int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                    if (findPointerIndex == -1) {
                        this.mActivePointerId = motionEvent.getPointerId(0);
                        findPointerIndex = 0;
                    }
                    int x4 = (int) motionEvent.getX(findPointerIndex);
                    if (this.ajr) {
                        layoutChildren();
                    }
                    switch (this.cDx) {
                        case 0:
                        case 1:
                        case 2:
                            ke(x4);
                            break;
                        case 3:
                        case 5:
                            kf(x4);
                            break;
                    }
                case 3:
                    switch (this.cDx) {
                        case 5:
                            if (this.cDA == null) {
                                this.cDA = new e();
                            }
                            this.cDA.alA();
                            break;
                        case 6:
                            break;
                        default:
                            this.cDx = -1;
                            setPressed(false);
                            View childAt2 = getChildAt(this.cDs - this.cFc);
                            if (childAt2 != null) {
                                childAt2.setPressed(false);
                            }
                            alt();
                            Handler handler3 = getHandler();
                            if (handler3 != null) {
                                handler3.removeCallbacks(this.cDL);
                            }
                            alr();
                            break;
                    }
                    if (this.cEa != null) {
                        this.cEa.onRelease();
                        this.cEb.onRelease();
                    }
                    this.mActivePointerId = -1;
                    break;
                case 5:
                    int actionIndex = motionEvent.getActionIndex();
                    int pointerId = motionEvent.getPointerId(actionIndex);
                    int x5 = (int) motionEvent.getX(actionIndex);
                    int y2 = (int) motionEvent.getY(actionIndex);
                    this.cDz = 0;
                    this.mActivePointerId = pointerId;
                    this.cDv = x5;
                    this.cDw = y2;
                    int pointToPosition2 = pointToPosition(x5, y2);
                    if (pointToPosition2 >= 0) {
                        this.cDt = getChildAt(pointToPosition2 - this.cFc).getLeft();
                        this.cDs = pointToPosition2;
                    }
                    this.cDy = x5;
                    break;
                case 6:
                    onSecondaryPointerUp(motionEvent);
                    int i5 = this.cDv;
                    int pointToPosition3 = pointToPosition(i5, this.cDw);
                    if (pointToPosition3 >= 0) {
                        this.cDt = getChildAt(pointToPosition3 - this.cFc).getLeft();
                        this.cDs = pointToPosition3;
                    }
                    this.cDy = i5;
                    break;
            }
            return true;
        }
        return false;
    }

    @Override // android.view.View
    protected void onOverScrolled(int i2, int i3, boolean z, boolean z2) {
        if (getScrollX() != i2) {
            onScrollChanged(i2, getScrollY(), getScrollX(), getScrollY());
            this.cCU.setScrollX(i2);
            alo();
            awakenScrollBars();
        }
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) != 0) {
            switch (motionEvent.getAction()) {
                case 8:
                    if (this.cDx == -1) {
                        float axisValue = motionEvent.getAxisValue(10);
                        if (axisValue != 0.0f) {
                            int horizontalScrollFactor = (int) (axisValue * getHorizontalScrollFactor());
                            if (!ay(horizontalScrollFactor, horizontalScrollFactor)) {
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
        if (this.cEp == 0.0f) {
            TypedValue typedValue = new TypedValue();
            if (getContext().getTheme().resolveAttribute(w.c.hlv_listPreferredItemWidth, typedValue, true)) {
                this.cEp = typedValue.getDimension(getContext().getResources().getDisplayMetrics());
            }
        }
        return this.cEp;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.cEa != null) {
            int scrollX = getScrollX();
            if (!this.cEa.isFinished()) {
                int save = canvas.save();
                int i2 = this.cDm.top + this.cEf;
                int height = (getHeight() - i2) - (this.cDm.bottom + this.cEg);
                int min = Math.min(0, this.cEc + scrollX);
                canvas.rotate(-90.0f);
                canvas.translate(i2 + (-getHeight()), min);
                this.cEa.setSize(height, height);
                if (this.cEa.draw(canvas)) {
                    invalidate();
                }
                canvas.restoreToCount(save);
            }
            if (!this.cEb.isFinished()) {
                int save2 = canvas.save();
                int i3 = this.cDm.left + this.cEf;
                int height2 = (getHeight() - i3) - (this.cDm.right + this.cEg);
                int max = Math.max(getWidth(), scrollX + this.cEd);
                canvas.rotate(90.0f);
                canvas.translate(-i3, -max);
                this.cEb.setSize(height2, height2);
                if (this.cEb.draw(canvas)) {
                    invalidate();
                }
                canvas.restoreToCount(save2);
            }
        }
    }

    private void alp() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        } else {
            this.mVelocityTracker.clear();
        }
    }

    private void alq() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
    }

    private void alr() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            alr();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.cDB != null) {
            this.cDB.stop();
        }
        if (this.cEk) {
            switch (action & MotionEventCompat.ACTION_MASK) {
                case 0:
                    int i2 = this.cDx;
                    if (i2 == 6 || i2 == 5) {
                        this.cDz = 0;
                        return true;
                    }
                    int x = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();
                    this.mActivePointerId = motionEvent.getPointerId(0);
                    int ki = ki(x);
                    if (i2 != 4 && ki >= 0) {
                        this.cDt = getChildAt(ki - this.cFc).getLeft();
                        this.cDv = x;
                        this.cDw = y;
                        this.cDs = ki;
                        this.cDx = 0;
                        alt();
                    }
                    this.cDy = ExploreByTouchHelper.INVALID_ID;
                    alp();
                    this.mVelocityTracker.addMovement(motionEvent);
                    return i2 == 4;
                case 1:
                case 3:
                    this.cDx = -1;
                    this.mActivePointerId = -1;
                    alr();
                    kg(0);
                    return false;
                case 2:
                    switch (this.cDx) {
                        case 0:
                            int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                            if (findPointerIndex == -1) {
                                this.mActivePointerId = motionEvent.getPointerId(0);
                                findPointerIndex = 0;
                            }
                            alq();
                            this.mVelocityTracker.addMovement(motionEvent);
                            return ke((int) motionEvent.getX(findPointerIndex));
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
            this.cDv = (int) motionEvent.getX(i2);
            this.cDw = (int) motionEvent.getY(i2);
            this.cDz = 0;
            this.mActivePointerId = motionEvent.getPointerId(i2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        int childCount = getChildCount();
        int i2 = this.cFc;
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public void kg(int i2) {
        if (i2 != this.cDT && this.cDE != null) {
            this.cDT = i2;
            this.cDE.a(this, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e implements Runnable {
        private final o cEt;
        private int cEu;
        private final Runnable cEv = new com.baidu.tieba.horizonalList.widget.c(this);

        e() {
            this.cEt = new o(AbsHListView.this.getContext());
        }

        void kk(int i) {
            int i2 = i < 0 ? Integer.MAX_VALUE : 0;
            this.cEu = i2;
            this.cEt.setInterpolator(null);
            this.cEt.fling(i2, 0, i, 0, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
            AbsHListView.this.cDx = 4;
            AbsHListView.this.cCU.i(this);
        }

        void alA() {
            if (this.cEt.springBack(AbsHListView.this.getScrollX(), 0, 0, 0, 0, 0)) {
                AbsHListView.this.cDx = 6;
                AbsHListView.this.invalidate();
                AbsHListView.this.cCU.i(this);
                return;
            }
            AbsHListView.this.cDx = -1;
            AbsHListView.this.kg(0);
        }

        void kl(int i) {
            this.cEt.setInterpolator(null);
            this.cEt.fling(AbsHListView.this.getScrollX(), 0, i, 0, ExploreByTouchHelper.INVALID_ID, Integer.MAX_VALUE, 0, 0, AbsHListView.this.getWidth(), 0);
            AbsHListView.this.cDx = 6;
            AbsHListView.this.invalidate();
            AbsHListView.this.cCU.i(this);
        }

        void km(int i) {
            this.cEt.notifyHorizontalEdgeReached(AbsHListView.this.getScrollX(), 0, AbsHListView.this.cDZ);
            int overScrollMode = AbsHListView.this.getOverScrollMode();
            if (overScrollMode == 0 || (overScrollMode == 1 && !AbsHListView.this.ale())) {
                AbsHListView.this.cDx = 6;
                int currVelocity = (int) this.cEt.getCurrVelocity();
                if (i > 0) {
                    AbsHListView.this.cEa.onAbsorb(currVelocity);
                } else {
                    AbsHListView.this.cEb.onAbsorb(currVelocity);
                }
            } else {
                AbsHListView.this.cDx = -1;
                if (AbsHListView.this.cDB != null) {
                    AbsHListView.this.cDB.stop();
                }
            }
            AbsHListView.this.invalidate();
            AbsHListView.this.cCU.i(this);
        }

        void d(int i, int i2, boolean z) {
            int i3 = i < 0 ? Integer.MAX_VALUE : 0;
            this.cEu = i3;
            this.cEt.setInterpolator(z ? AbsHListView.cEm : null);
            this.cEt.startScroll(i3, 0, i, 0, i2);
            AbsHListView.this.cDx = 4;
            AbsHListView.this.cCU.i(this);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void alB() {
            AbsHListView.this.cDx = -1;
            AbsHListView.this.removeCallbacks(this);
            AbsHListView.this.removeCallbacks(this.cEv);
            AbsHListView.this.kg(0);
            AbsHListView.this.alt();
            this.cEt.abortAnimation();
            AbsHListView.this.overScrollBy(0, 0, 0, 0, 0, 0, 0, 0, false);
        }

        void alC() {
            AbsHListView.this.postDelayed(this.cEv, 40L);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // java.lang.Runnable
        public void run() {
            int max;
            boolean z = true;
            boolean z2 = false;
            switch (AbsHListView.this.cDx) {
                case 3:
                    if (this.cEt.isFinished()) {
                        return;
                    }
                    break;
                case 4:
                    break;
                case 5:
                default:
                    alB();
                    return;
                case 6:
                    o oVar = this.cEt;
                    if (oVar.computeScrollOffset()) {
                        int scrollX = AbsHListView.this.getScrollX();
                        int currX = oVar.getCurrX();
                        if (AbsHListView.this.overScrollBy(currX - scrollX, 0, scrollX, 0, 0, 0, AbsHListView.this.cDZ, 0, false)) {
                            boolean z3 = scrollX <= 0 && currX > 0;
                            if (scrollX >= 0 && currX < 0) {
                                z2 = true;
                            }
                            if (z3 || z2) {
                                int currVelocity = (int) oVar.getCurrVelocity();
                                if (z2) {
                                    currVelocity = -currVelocity;
                                }
                                oVar.abortAnimation();
                                kk(currVelocity);
                                return;
                            }
                            alA();
                            return;
                        }
                        AbsHListView.this.invalidate();
                        AbsHListView.this.cCU.i(this);
                        return;
                    }
                    alB();
                    return;
            }
            if (AbsHListView.this.ajr) {
                AbsHListView.this.layoutChildren();
            }
            if (AbsHListView.this.cFp == 0 || AbsHListView.this.getChildCount() == 0) {
                alB();
                return;
            }
            o oVar2 = this.cEt;
            boolean computeScrollOffset = oVar2.computeScrollOffset();
            int currX2 = oVar2.getCurrX();
            int i = this.cEu - currX2;
            if (i > 0) {
                AbsHListView.this.cDs = AbsHListView.this.cFc;
                AbsHListView.this.cDt = AbsHListView.this.getChildAt(0).getLeft();
                max = Math.min(((AbsHListView.this.getWidth() - AbsHListView.this.getPaddingRight()) - AbsHListView.this.getPaddingLeft()) - 1, i);
            } else {
                int childCount = AbsHListView.this.getChildCount() - 1;
                AbsHListView.this.cDs = AbsHListView.this.cFc + childCount;
                AbsHListView.this.cDt = AbsHListView.this.getChildAt(childCount).getLeft();
                max = Math.max(-(((AbsHListView.this.getWidth() - AbsHListView.this.getPaddingRight()) - AbsHListView.this.getPaddingLeft()) - 1), i);
            }
            View childAt = AbsHListView.this.getChildAt(AbsHListView.this.cDs - AbsHListView.this.cFc);
            int left = childAt != null ? childAt.getLeft() : 0;
            boolean ay = AbsHListView.this.ay(max, max);
            if (!ay || max == 0) {
                z = false;
            }
            if (z) {
                if (childAt != null) {
                    AbsHListView.this.overScrollBy(-(max - (childAt.getLeft() - left)), 0, AbsHListView.this.getScrollX(), 0, 0, 0, AbsHListView.this.cDZ, 0, false);
                }
                if (computeScrollOffset) {
                    km(max);
                }
            } else if (computeScrollOffset && !z) {
                if (ay) {
                    AbsHListView.this.invalidate();
                }
                this.cEu = currX2;
                AbsHListView.this.cCU.i(this);
            } else {
                alB();
            }
        }
    }

    /* loaded from: classes.dex */
    public class j implements Runnable {
        private int cED;
        private int cEE;
        private int cEF;
        private int cEG;
        private final int cEH;
        private int cEI;
        private int mMode;

        j() {
            this.cEH = ViewConfiguration.get(AbsHListView.this.getContext()).getScaledFadingEdgeLength();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void kk(int i) {
            int i2;
            stop();
            if (AbsHListView.this.ajr) {
                AbsHListView.this.cDV = new com.baidu.tieba.horizonalList.widget.d(this, i);
                return;
            }
            int childCount = AbsHListView.this.getChildCount();
            if (childCount != 0) {
                int i3 = AbsHListView.this.cFc;
                int i4 = (childCount + i3) - 1;
                int max = Math.max(0, Math.min(AbsHListView.this.getCount() - 1, i));
                if (max < i3) {
                    i2 = (i3 - max) + 1;
                    this.mMode = 2;
                } else if (max > i4) {
                    i2 = (max - i4) + 1;
                    this.mMode = 1;
                } else {
                    w(max, -1, 200);
                    return;
                }
                if (i2 > 0) {
                    this.cEG = 200 / i2;
                } else {
                    this.cEG = 200;
                }
                this.cED = max;
                this.cEE = -1;
                this.cEF = -1;
                AbsHListView.this.cCU.i(this);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void aA(int i, int i2) {
            int i3;
            stop();
            if (i2 == -1) {
                kk(i);
            } else if (AbsHListView.this.ajr) {
                AbsHListView.this.cDV = new com.baidu.tieba.horizonalList.widget.e(this, i, i2);
            } else {
                int childCount = AbsHListView.this.getChildCount();
                if (childCount != 0) {
                    int i4 = AbsHListView.this.cFc;
                    int i5 = (childCount + i4) - 1;
                    int max = Math.max(0, Math.min(AbsHListView.this.getCount() - 1, i));
                    if (max < i4) {
                        int i6 = i5 - i2;
                        if (i6 >= 1) {
                            int i7 = (i4 - max) + 1;
                            i3 = i6 - 1;
                            if (i3 < i7) {
                                this.mMode = 4;
                            } else {
                                this.mMode = 2;
                                i3 = i7;
                            }
                        } else {
                            return;
                        }
                    } else if (max > i5) {
                        int i8 = i2 - i4;
                        if (i8 >= 1) {
                            int i9 = (max - i5) + 1;
                            i3 = i8 - 1;
                            if (i3 < i9) {
                                this.mMode = 3;
                            } else {
                                this.mMode = 1;
                                i3 = i9;
                            }
                        } else {
                            return;
                        }
                    } else {
                        w(max, i2, 200);
                        return;
                    }
                    if (i3 > 0) {
                        this.cEG = 200 / i3;
                    } else {
                        this.cEG = 200;
                    }
                    this.cED = max;
                    this.cEE = i2;
                    this.cEF = -1;
                    AbsHListView.this.cCU.i(this);
                }
            }
        }

        void w(int i, int i2, int i3) {
            int i4 = AbsHListView.this.cFc;
            int childCount = (AbsHListView.this.getChildCount() + i4) - 1;
            int i5 = AbsHListView.this.cDm.left;
            int width = AbsHListView.this.getWidth() - AbsHListView.this.cDm.right;
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
            int i2 = AbsHListView.this.cFc;
            switch (this.mMode) {
                case 1:
                    int childCount = AbsHListView.this.getChildCount() - 1;
                    int i3 = i2 + childCount;
                    if (childCount >= 0) {
                        if (i3 == this.cEF) {
                            AbsHListView.this.cCU.i(this);
                            return;
                        }
                        View childAt = AbsHListView.this.getChildAt(childCount);
                        AbsHListView.this.c((i3 < AbsHListView.this.cFp + (-1) ? Math.max(AbsHListView.this.cDm.right, this.cEH) : AbsHListView.this.cDm.right) + (childAt.getWidth() - (width - childAt.getLeft())), this.cEG, true);
                        this.cEF = i3;
                        if (i3 < this.cED) {
                            AbsHListView.this.cCU.i(this);
                            return;
                        }
                        return;
                    }
                    return;
                case 2:
                    if (i2 == this.cEF) {
                        AbsHListView.this.cCU.i(this);
                        return;
                    }
                    View childAt2 = AbsHListView.this.getChildAt(0);
                    if (childAt2 != null) {
                        AbsHListView.this.c(childAt2.getLeft() - (i2 > 0 ? Math.max(this.cEH, AbsHListView.this.cDm.left) : AbsHListView.this.cDm.left), this.cEG, true);
                        this.cEF = i2;
                        if (i2 > this.cED) {
                            AbsHListView.this.cCU.i(this);
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    int childCount2 = AbsHListView.this.getChildCount();
                    if (i2 != this.cEE && childCount2 > 1 && childCount2 + i2 < AbsHListView.this.cFp) {
                        int i4 = i2 + 1;
                        if (i4 == this.cEF) {
                            AbsHListView.this.cCU.i(this);
                            return;
                        }
                        View childAt3 = AbsHListView.this.getChildAt(1);
                        int width2 = childAt3.getWidth();
                        int left2 = childAt3.getLeft();
                        int max = Math.max(AbsHListView.this.cDm.right, this.cEH);
                        if (i4 < this.cEE) {
                            AbsHListView.this.c(Math.max(0, (left2 + width2) - max), this.cEG, true);
                            this.cEF = i4;
                            AbsHListView.this.cCU.i(this);
                            return;
                        } else if (left2 > max) {
                            AbsHListView.this.c(left2 - max, this.cEG, true);
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
                        if (i5 == this.cEF) {
                            AbsHListView.this.cCU.i(this);
                            return;
                        }
                        View childAt4 = AbsHListView.this.getChildAt(childCount3);
                        int width3 = childAt4.getWidth();
                        int left3 = childAt4.getLeft();
                        int i6 = width - left3;
                        int max2 = Math.max(AbsHListView.this.cDm.left, this.cEH);
                        this.cEF = i5;
                        if (i5 > this.cEE) {
                            AbsHListView.this.c(-(i6 - max2), this.cEG, true);
                            AbsHListView.this.cCU.i(this);
                            return;
                        }
                        int i7 = width - max2;
                        int i8 = left3 + width3;
                        if (i7 > i8) {
                            AbsHListView.this.c(-(i7 - i8), this.cEG, true);
                            return;
                        }
                        return;
                    }
                    return;
                case 5:
                    if (this.cEF == i2) {
                        AbsHListView.this.cCU.i(this);
                        return;
                    }
                    this.cEF = i2;
                    int childCount4 = AbsHListView.this.getChildCount();
                    int i9 = this.cED;
                    int i10 = (i2 + childCount4) - 1;
                    if (i9 < i2) {
                        i = (i2 - i9) + 1;
                    } else if (i9 > i10) {
                        i = i9 - i10;
                    }
                    float min = Math.min(Math.abs(i / childCount4), 1.0f);
                    if (i9 < i2) {
                        AbsHListView.this.c((int) ((-AbsHListView.this.getWidth()) * min), (int) (min * this.cEG), true);
                        AbsHListView.this.cCU.i(this);
                        return;
                    } else if (i9 > i10) {
                        AbsHListView.this.c((int) (AbsHListView.this.getWidth() * min), (int) (min * this.cEG), true);
                        AbsHListView.this.cCU.i(this);
                        return;
                    } else {
                        AbsHListView.this.c(AbsHListView.this.getChildAt(i9 - i2).getLeft() - this.cEI, (int) (this.cEG * (Math.abs(left) / AbsHListView.this.getWidth())), true);
                        return;
                    }
                default:
                    return;
            }
        }
    }

    public void setFriction(float f2) {
        if (this.cDA == null) {
            this.cDA = new e();
        }
        this.cDA.cEt.setFriction(f2);
    }

    public void setVelocityScale(float f2) {
        this.cDW = f2;
    }

    public void smoothScrollToPosition(int i2, int i3) {
        if (this.cDB == null) {
            this.cDB = new j();
        }
        this.cDB.aA(i2, i3);
    }

    public void smoothScrollBy(int i2, int i3) {
        c(i2, i3, false);
    }

    public void c(int i2, int i3, boolean z) {
        if (this.cDA == null) {
            this.cDA = new e();
        }
        int i4 = this.cFc;
        int childCount = getChildCount();
        int i5 = i4 + childCount;
        int paddingLeft = getPaddingLeft();
        int width = getWidth() - getPaddingRight();
        if (i2 == 0 || this.cFp == 0 || childCount == 0 || ((i4 == 0 && getChildAt(0).getLeft() == paddingLeft && i2 < 0) || (i5 == this.cFp && getChildAt(childCount - 1).getRight() == width && i2 > 0))) {
            this.cDA.alB();
            if (this.cDB != null) {
                this.cDB.stop();
                return;
            }
            return;
        }
        kg(2);
        this.cDA.d(i2, i3, z);
    }

    private void als() {
        if (this.mScrollingCacheEnabled && !this.cDq && !this.cCU.isHardwareAccelerated()) {
            setChildrenDrawnWithCacheEnabled(true);
            setChildrenDrawingCacheEnabled(true);
            this.cDr = true;
            this.cDq = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alt() {
        if (!this.cCU.isHardwareAccelerated()) {
            if (this.cDU == null) {
                this.cDU = new com.baidu.tieba.horizonalList.widget.b(this);
            }
            post(this.cDU);
        }
    }

    boolean ay(int i2, int i3) {
        int min;
        int min2;
        int i4;
        int childCount = getChildCount();
        if (childCount == 0) {
            return true;
        }
        int left = getChildAt(0).getLeft();
        int right = getChildAt(childCount - 1).getRight();
        Rect rect = this.cDm;
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
        int i6 = this.cFc;
        if (i6 == 0) {
            this.cEc = left - rect.left;
        } else {
            this.cEc += min2;
        }
        if (i6 + childCount == this.cFp) {
            this.cEd = rect.right + right;
        } else {
            this.cEd += min2;
        }
        boolean z = i6 == 0 && left >= rect.left && min2 >= 0;
        boolean z2 = i6 + childCount == this.cFp && right <= getWidth() - rect.right && min2 <= 0;
        if (z || z2) {
            return min2 != 0;
        }
        boolean z3 = min2 < 0;
        boolean isInTouchMode = isInTouchMode();
        if (isInTouchMode) {
            alu();
        }
        int headerViewsCount = getHeaderViewsCount();
        int footerViewsCount = this.cFp - getFooterViewsCount();
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
                    this.cDh.r(childAt, i11);
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
                    this.cDh.r(childAt2, i14);
                }
                i4 = i13;
                i7 = i12;
            }
        }
        this.cDu = this.cDt + min;
        this.cFx = true;
        if (i4 > 0) {
            detachViewsFromParent(i7, i4);
            this.cDh.alF();
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        kh(min2);
        if (z3) {
            this.cFc = i4 + this.cFc;
        }
        int abs = Math.abs(min2);
        if (i5 < abs || width < abs) {
            fl(z3);
        }
        if (!isInTouchMode && this.clD != -1) {
            int i15 = this.clD - this.cFc;
            if (i15 >= 0 && i15 < getChildCount()) {
                c(this.clD, getChildAt(i15));
            }
        } else if (this.cDf != -1) {
            int i16 = this.cDf - this.cFc;
            if (i16 >= 0 && i16 < getChildCount()) {
                c(-1, getChildAt(i16));
            }
        } else {
            this.cDg.setEmpty();
        }
        this.cFx = false;
        alf();
        return false;
    }

    public void kh(int i2) {
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
    public void alu() {
        if (this.clD != -1) {
            if (this.cDb != 4) {
                this.cDH = this.clD;
            }
            if (this.cFm >= 0 && this.cFm != this.clD) {
                this.cDH = this.cFm;
            }
            setSelectedPositionInt(-1);
            setNextSelectedPositionInt(-1);
            this.cDC = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int alv() {
        int i2 = this.clD;
        if (i2 < 0) {
            i2 = this.cDH;
        }
        return Math.min(Math.max(0, i2), this.cFp - 1);
    }

    protected int kj(int i2) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return -1;
        }
        int ki = ki(i2);
        return ki == -1 ? (this.cFc + childCount) - 1 : ki;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean alw() {
        if (this.clD >= 0 || !alx()) {
            return false;
        }
        aln();
        return true;
    }

    boolean alx() {
        int i2;
        int i3;
        boolean z;
        int i4;
        int i5;
        int i6;
        int i7;
        int childCount = getChildCount();
        if (childCount <= 0) {
            return false;
        }
        int i8 = this.cDm.left;
        int right = (getRight() - getLeft()) - this.cDm.right;
        int i9 = this.cFc;
        int i10 = this.cDH;
        if (i10 >= i9 && i10 < i9 + childCount) {
            View childAt = getChildAt(i10 - this.cFc);
            int left = childAt.getLeft();
            int right2 = childAt.getRight();
            if (left < i8) {
                i2 = getHorizontalFadingEdgeLength() + i8;
                i3 = i10;
                z = true;
            } else if (right2 > right) {
                i2 = (right - childAt.getMeasuredWidth()) - getHorizontalFadingEdgeLength();
                i3 = i10;
                z = true;
            } else {
                i2 = left;
                i3 = i10;
                z = true;
            }
        } else if (i10 < i9) {
            int i11 = 0;
            int i12 = 0;
            while (true) {
                if (i11 >= childCount) {
                    i3 = i9;
                    i2 = i12;
                    z = true;
                    break;
                }
                int left2 = getChildAt(i11).getLeft();
                if (i11 != 0) {
                    int i13 = i8;
                    i6 = i12;
                    i7 = i13;
                } else if (i9 > 0 || left2 < i8) {
                    i7 = getHorizontalFadingEdgeLength() + i8;
                    i6 = left2;
                } else {
                    i7 = i8;
                    i6 = left2;
                }
                if (left2 < i7) {
                    i11++;
                    int i14 = i7;
                    i12 = i6;
                    i8 = i14;
                } else {
                    i2 = left2;
                    i3 = i9 + i11;
                    z = true;
                    break;
                }
            }
        } else {
            int i15 = this.cFp;
            int i16 = (i9 + childCount) - 1;
            int i17 = childCount - 1;
            i2 = 0;
            while (true) {
                if (i17 < 0) {
                    i3 = i16;
                    z = false;
                    break;
                }
                View childAt2 = getChildAt(i17);
                int left3 = childAt2.getLeft();
                int right3 = childAt2.getRight();
                if (i17 != childCount - 1) {
                    int i18 = right;
                    i4 = i2;
                    i5 = i18;
                } else if (i9 + childCount < i15 || right3 > right) {
                    i5 = right - getHorizontalFadingEdgeLength();
                    i4 = left3;
                } else {
                    i5 = right;
                    i4 = left3;
                }
                if (right3 > i5) {
                    i17--;
                    int i19 = i5;
                    i2 = i4;
                    right = i19;
                } else {
                    i2 = left3;
                    i3 = i9 + i17;
                    z = false;
                    break;
                }
            }
        }
        this.cDH = -1;
        removeCallbacks(this.cDA);
        if (this.cDB != null) {
            this.cDB.stop();
        }
        this.cDx = -1;
        alt();
        this.cFd = i2;
        int q = q(i3, z);
        if (q < i9 || q > getLastVisiblePosition()) {
            q = -1;
        } else {
            this.cDb = 4;
            aln();
            setSelectionInt(q);
            alf();
        }
        kg(0);
        return q >= 0;
    }

    void aly() {
        int i2;
        boolean z;
        boolean z2;
        this.cCZ.clear();
        int i3 = 0;
        boolean z3 = false;
        while (i3 < this.cDa.size()) {
            long keyAt = this.cDa.keyAt(i3);
            int intValue = this.cDa.valueAt(i3).intValue();
            if (keyAt != this.mAdapter.getItemId(intValue)) {
                int max = Math.max(0, intValue - 20);
                int min = Math.min(intValue + 20, this.cFp);
                while (true) {
                    if (max >= min) {
                        z2 = false;
                        break;
                    } else if (keyAt != this.mAdapter.getItemId(max)) {
                        max++;
                    } else {
                        this.cCZ.put(max, true);
                        this.cDa.setValueAt(i3, Integer.valueOf(max));
                        z2 = true;
                        break;
                    }
                }
                if (!z2) {
                    this.cDa.delete(keyAt);
                    int i4 = i3 - 1;
                    this.cCY--;
                    if (Build.VERSION.SDK_INT <= 11 || this.cCW == null || this.cCX == null) {
                        i2 = i4;
                        z = true;
                    } else {
                        ((com.baidu.tieba.horizonalList.a.a.b) this.cCX).onItemCheckedStateChanged((ActionMode) this.cCW, intValue, keyAt, false);
                        i2 = i4;
                        z = true;
                    }
                    z3 = z;
                    i3 = i2 + 1;
                }
            } else {
                this.cCZ.put(intValue, true);
            }
            i2 = i3;
            z = z3;
            z3 = z;
            i3 = i2 + 1;
        }
        if (z3 && this.cCW != null && Build.VERSION.SDK_INT > 11) {
            ((ActionMode) this.cCW).invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.g
    public void handleDataChanged() {
        int i2 = this.cFp;
        int i3 = this.cEl;
        this.cEl = this.cFp;
        if (this.cCV != 0 && this.mAdapter != null && this.mAdapter.hasStableIds()) {
            aly();
        }
        this.cDh.alE();
        if (i2 > 0) {
            if (this.cFh) {
                this.cFh = false;
                this.cEn = null;
                if (this.cDQ == 2) {
                    this.cDb = 3;
                    return;
                }
                if (this.cDQ == 1) {
                    if (this.cEe) {
                        this.cEe = false;
                        this.cDb = 3;
                        return;
                    }
                    int childCount = getChildCount();
                    int width = getWidth() - getPaddingRight();
                    View childAt = getChildAt(childCount - 1);
                    int bottom = childAt != null ? childAt.getBottom() : width;
                    if (childCount + this.cFc >= i3 && bottom <= width) {
                        this.cDb = 3;
                        return;
                    }
                    awakenScrollBars();
                }
                switch (this.cFi) {
                    case 1:
                        this.cDb = 5;
                        this.cFe = Math.min(Math.max(0, this.cFe), i2 - 1);
                        return;
                    case 0:
                        if (isInTouchMode()) {
                            this.cDb = 5;
                            this.cFe = Math.min(Math.max(0, this.cFe), i2 - 1);
                            return;
                        }
                        int alQ = alQ();
                        if (alQ >= 0 && q(alQ, true) == alQ) {
                            this.cFe = alQ;
                            if (this.cFg == getWidth()) {
                                this.cDb = 5;
                            } else {
                                this.cDb = 2;
                            }
                            setNextSelectedPositionInt(alQ);
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
                int q = q(selectedItemPosition, true);
                if (q >= 0) {
                    setNextSelectedPositionInt(q);
                    return;
                }
                int q2 = q(selectedItemPosition, false);
                if (q2 >= 0) {
                    setNextSelectedPositionInt(q2);
                    return;
                }
            } else if (this.cDH >= 0) {
                return;
            }
        }
        this.cDb = this.cDD ? 3 : 1;
        this.clD = -1;
        this.cFo = Long.MIN_VALUE;
        this.cFm = -1;
        this.cFn = Long.MIN_VALUE;
        this.cFh = false;
        this.cEn = null;
        this.cDf = -1;
        alP();
    }

    public static int a(Rect rect, Rect rect2, int i2) {
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
            case BDLocation.TypeOffLineLocation /* 66 */:
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
        this.cDQ = i2;
    }

    public int getTranscriptMode() {
        return this.cDQ;
    }

    @Override // android.view.View
    public int getSolidColor() {
        return this.cDR;
    }

    public void setCacheColorHint(int i2) {
        if (i2 != this.cDR) {
            this.cDR = i2;
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                getChildAt(i3).setDrawingCacheBackgroundColor(i2);
            }
            this.cDh.setCacheColorHint(i2);
        }
    }

    @ViewDebug.ExportedProperty(category = "drawing")
    public int getCacheColorHint() {
        return this.cDR;
    }

    private void alz() {
        if (this.cEa != null) {
            this.cEa.finish();
            this.cEb.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void az(int i2, int i3) {
    }

    public void setRecyclerListener(l lVar) {
        this.cDh.cEL = lVar;
    }

    /* loaded from: classes.dex */
    public class a extends com.baidu.tieba.horizonalList.widget.g<ListAdapter>.b {
        public a() {
            super();
        }

        @Override // com.baidu.tieba.horizonalList.widget.g.b, android.database.DataSetObserver
        public void onChanged() {
            super.onChanged();
        }

        @Override // com.baidu.tieba.horizonalList.widget.g.b, android.database.DataSetObserver
        public void onInvalidated() {
            super.onInvalidated();
        }
    }

    /* loaded from: classes.dex */
    public static class f extends ViewGroup.LayoutParams {
        public int cEA;
        public long cEB;
        public int cEx;
        public boolean cEy;
        public boolean cEz;

        public f(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.cEB = -1L;
        }

        public f(int i, int i2) {
            super(i, i2);
            this.cEB = -1L;
        }

        public f(int i, int i2, int i3) {
            super(i, i2);
            this.cEB = -1L;
            this.cEx = i3;
        }

        public f(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.cEB = -1L;
        }
    }

    /* loaded from: classes.dex */
    public class k {
        private l cEL;
        private int cEM;
        private View[] cEN = new View[0];
        private ArrayList<View>[] cEO;
        private int cEP;
        private ArrayList<View> cEQ;
        private ArrayList<View> cER;
        private SparseArrayCompat<View> cES;

        public k() {
        }

        public void kn(int i) {
            if (i < 1) {
                throw new IllegalArgumentException("Can't have a viewTypeCount < 1");
            }
            ArrayList<View>[] arrayListArr = new ArrayList[i];
            for (int i2 = 0; i2 < i; i2++) {
                arrayListArr[i2] = new ArrayList<>();
            }
            this.cEP = i;
            this.cEQ = arrayListArr[0];
            this.cEO = arrayListArr;
        }

        public void alD() {
            if (this.cEP == 1) {
                ArrayList<View> arrayList = this.cEQ;
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    arrayList.get(i).forceLayout();
                }
            } else {
                int i2 = this.cEP;
                for (int i3 = 0; i3 < i2; i3++) {
                    ArrayList<View> arrayList2 = this.cEO[i3];
                    int size2 = arrayList2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        arrayList2.get(i4).forceLayout();
                    }
                }
            }
            if (this.cES != null) {
                int size3 = this.cES.size();
                for (int i5 = 0; i5 < size3; i5++) {
                    this.cES.valueAt(i5).forceLayout();
                }
            }
        }

        public boolean ko(int i) {
            return i >= 0;
        }

        public void clear() {
            if (this.cEP == 1) {
                ArrayList<View> arrayList = this.cEQ;
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    AbsHListView.this.removeDetachedView(arrayList.remove((size - 1) - i), false);
                }
            } else {
                int i2 = this.cEP;
                for (int i3 = 0; i3 < i2; i3++) {
                    ArrayList<View> arrayList2 = this.cEO[i3];
                    int size2 = arrayList2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        AbsHListView.this.removeDetachedView(arrayList2.remove((size2 - 1) - i4), false);
                    }
                }
            }
            if (this.cES != null) {
                this.cES.clear();
            }
        }

        public void aB(int i, int i2) {
            if (this.cEN.length < i) {
                this.cEN = new View[i];
            }
            this.cEM = i2;
            View[] viewArr = this.cEN;
            for (int i3 = 0; i3 < i; i3++) {
                View childAt = AbsHListView.this.getChildAt(i3);
                f fVar = (f) childAt.getLayoutParams();
                if (fVar != null && fVar.cEx != -2) {
                    viewArr[i3] = childAt;
                }
            }
        }

        public View kp(int i) {
            int i2 = i - this.cEM;
            View[] viewArr = this.cEN;
            if (i2 < 0 || i2 >= viewArr.length) {
                return null;
            }
            View view = viewArr[i2];
            viewArr[i2] = null;
            return view;
        }

        View kq(int i) {
            int indexOfKey;
            if (this.cES != null && (indexOfKey = this.cES.indexOfKey(i)) >= 0) {
                View valueAt = this.cES.valueAt(indexOfKey);
                this.cES.removeAt(indexOfKey);
                return valueAt;
            }
            return null;
        }

        void alE() {
            if (this.cES != null) {
                this.cES.clear();
            }
        }

        View kr(int i) {
            if (this.cEP == 1) {
                return AbsHListView.a(this.cEQ, i);
            }
            int itemViewType = AbsHListView.this.mAdapter.getItemViewType(i);
            if (itemViewType >= 0 && itemViewType < this.cEO.length) {
                return AbsHListView.a(this.cEO[itemViewType], i);
            }
            return null;
        }

        public void r(View view, int i) {
            f fVar = (f) view.getLayoutParams();
            if (fVar != null) {
                fVar.cEA = i;
                int i2 = fVar.cEx;
                if (!ko(i2)) {
                    if (i2 != -2) {
                        if (this.cER == null) {
                            this.cER = new ArrayList<>();
                        }
                        this.cER.add(view);
                        return;
                    }
                    return;
                }
                view.onStartTemporaryDetach();
                if (this.cEP == 1) {
                    this.cEQ.add(view);
                } else {
                    this.cEO[i2].add(view);
                }
                if (Build.VERSION.SDK_INT >= 14) {
                    view.setAccessibilityDelegate(null);
                }
                if (this.cEL != null) {
                    this.cEL.onMovedToScrapHeap(view);
                }
            }
        }

        public void alF() {
            if (this.cER != null) {
                int size = this.cER.size();
                for (int i = 0; i < size; i++) {
                    AbsHListView.this.removeDetachedView(this.cER.get(i), false);
                }
                this.cER.clear();
            }
        }

        public void alG() {
            View[] viewArr = this.cEN;
            boolean z = this.cEL != null;
            boolean z2 = this.cEP > 1;
            ArrayList<View> arrayList = this.cEQ;
            for (int length = viewArr.length - 1; length >= 0; length--) {
                View view = viewArr[length];
                if (view != null) {
                    f fVar = (f) view.getLayoutParams();
                    int i = fVar.cEx;
                    viewArr[length] = null;
                    if (!ko(i)) {
                        if (i != -2) {
                            AbsHListView.this.removeDetachedView(view, false);
                        }
                    } else {
                        if (z2) {
                            arrayList = this.cEO[i];
                        }
                        view.onStartTemporaryDetach();
                        fVar.cEA = this.cEM + length;
                        arrayList.add(view);
                        if (Build.VERSION.SDK_INT >= 14) {
                            view.setAccessibilityDelegate(null);
                        }
                        if (z) {
                            this.cEL.onMovedToScrapHeap(view);
                        }
                    }
                }
            }
            alH();
        }

        private void alH() {
            int length = this.cEN.length;
            int i = this.cEP;
            ArrayList<View>[] arrayListArr = this.cEO;
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
            if (this.cES != null) {
                for (int i6 = 0; i6 < this.cES.size(); i6++) {
                    this.cES.valueAt(i6);
                }
            }
        }

        void setCacheColorHint(int i) {
            View[] viewArr;
            if (this.cEP == 1) {
                ArrayList<View> arrayList = this.cEQ;
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    arrayList.get(i2).setDrawingCacheBackgroundColor(i);
                }
            } else {
                int i3 = this.cEP;
                for (int i4 = 0; i4 < i3; i4++) {
                    ArrayList<View> arrayList2 = this.cEO[i4];
                    int size2 = arrayList2.size();
                    for (int i5 = 0; i5 < size2; i5++) {
                        arrayList2.get(i5).setDrawingCacheBackgroundColor(i);
                    }
                }
            }
            for (View view : this.cEN) {
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
                if (((f) view.getLayoutParams()).cEA == i2) {
                    arrayList.remove(i3);
                    return view;
                }
            }
            return arrayList.remove(size - 1);
        }
        return null;
    }
}
