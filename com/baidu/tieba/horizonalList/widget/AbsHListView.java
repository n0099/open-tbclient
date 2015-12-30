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
import android.util.Log;
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
import com.baidu.tieba.horizonalList.a.a;
import com.baidu.tieba.horizonalList.widget.g;
import com.baidu.tieba.n;
import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class AbsHListView extends com.baidu.tieba.horizonalList.widget.g<ListAdapter> implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnTouchModeChangeListener {
    static final Interpolator bDe = new LinearInterpolator();
    public static final int[] bDg = new int[1];
    Drawable Hg;
    a.AbstractC0060a bBN;
    protected int bBO;
    public Object bBP;
    Object bBQ;
    int bBR;
    protected SparseArrayCompat<Boolean> bBS;
    LongSparseArray<Integer> bBT;
    protected int bBU;
    protected a bBV;
    boolean bBW;
    boolean bBX;
    int bBY;
    protected Rect bBZ;
    private ContextMenu.ContextMenuInfo bCA;
    protected int bCB;
    private int bCC;
    private c bCD;
    private Runnable bCE;
    private b bCF;
    private i bCG;
    private Runnable bCH;
    private int bCI;
    private int bCJ;
    private boolean bCK;
    private int bCL;
    private Runnable bCM;
    protected Runnable bCN;
    private float bCO;
    protected final boolean[] bCP;
    int bCQ;
    int bCR;
    private EdgeEffectCompat bCS;
    private EdgeEffectCompat bCT;
    private int bCU;
    private int bCV;
    private boolean bCW;
    private int bCX;
    private int bCY;
    private g bCZ;
    protected final k bCa;
    int bCb;
    int bCc;
    int bCd;
    int bCe;
    protected Rect bCf;
    protected int bCg;
    View bCh;
    View bCi;
    protected boolean bCj;
    protected boolean bCk;
    protected int bCl;
    int bCm;
    int bCn;
    int bCo;
    int bCp;
    int bCq;
    int bCr;
    private e bCs;
    protected j bCt;
    protected int bCu;
    protected boolean bCv;
    private h bCw;
    private boolean bCx;
    private Rect bCy;
    protected int bCz;
    private int bDa;
    private int bDb;
    protected boolean bDc;
    private int bDd;
    private SavedState bDf;
    private float bDh;
    private int mActivePointerId;
    protected ListAdapter mAdapter;
    private int mDirection;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    boolean mScrollingCacheEnabled;
    protected int mTouchMode;
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

    protected abstract void cZ(boolean z);

    protected abstract int hy(int i2);

    public abstract void setSelectionInt(int i2);

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
        this.bBO = 0;
        this.bBU = 0;
        this.bBX = false;
        this.bBY = -1;
        this.bBZ = new Rect();
        this.bCa = new k();
        this.bCb = 0;
        this.bCc = 0;
        this.bCd = 0;
        this.bCe = 0;
        this.bCf = new Rect();
        this.bCg = 0;
        this.mTouchMode = -1;
        this.bCu = 0;
        this.bCx = true;
        this.bCz = -1;
        this.bCA = null;
        this.bCC = -1;
        this.bCL = 0;
        this.bCO = 1.0f;
        this.bCP = new boolean[1];
        this.mActivePointerId = -1;
        this.mDirection = 0;
        Ub();
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, n.l.HListView, i2, 0);
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
        this.bBX = z3;
        setStackFromRight(z2);
        setScrollingCacheEnabled(z);
        setTranscriptMode(i3);
        setCacheColorHint(i4);
        setSmoothScrollbarEnabled(z4);
        setChoiceMode(i5);
    }

    private void Ub() {
        setClickable(true);
        setFocusableInTouchMode(true);
        setWillNotDraw(false);
        setAlwaysDrawnWithCacheEnabled(false);
        setScrollingCacheEnabled(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.bCQ = viewConfiguration.getScaledOverscrollDistance();
        this.bCR = viewConfiguration.getScaledOverflingDistance();
        this.bBN = com.baidu.tieba.horizonalList.a.a.N(this);
    }

    @Override // android.view.View
    public void setOverScrollMode(int i2) {
        if (i2 != 2) {
            if (this.bCS == null) {
                Context context = getContext();
                this.bCS = new EdgeEffectCompat(context);
                this.bCT = new EdgeEffectCompat(context);
            }
        } else {
            this.bCS = null;
            this.bCT = null;
        }
        super.setOverScrollMode(i2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.horizonalList.widget.g
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            this.bBW = this.mAdapter.hasStableIds();
            if (this.bBO != 0 && this.bBW && this.bBT == null) {
                this.bBT = new LongSparseArray<>();
            }
        }
        if (this.bBS != null) {
            this.bBS.clear();
        }
        if (this.bBT != null) {
            this.bBT.clear();
        }
    }

    public int getCheckedItemCount() {
        return this.bBR;
    }

    public boolean isItemChecked(int i2) {
        if (this.bBO == 0 || this.bBS == null) {
            return false;
        }
        return this.bBS.get(i2, false).booleanValue();
    }

    public int getCheckedItemPosition() {
        if (this.bBO == 1 && this.bBS != null && this.bBS.size() == 1) {
            return this.bBS.keyAt(0);
        }
        return -1;
    }

    public SparseArrayCompat<Boolean> getCheckedItemPositions() {
        if (this.bBO != 0) {
            return this.bBS;
        }
        return null;
    }

    public long[] getCheckedItemIds() {
        if (this.bBO == 0 || this.bBT == null || this.mAdapter == null) {
            return new long[0];
        }
        LongSparseArray<Integer> longSparseArray = this.bBT;
        int size = longSparseArray.size();
        long[] jArr = new long[size];
        for (int i2 = 0; i2 < size; i2++) {
            jArr[i2] = longSparseArray.keyAt(i2);
        }
        return jArr;
    }

    public void clearChoices() {
        if (this.bBS != null) {
            this.bBS.clear();
        }
        if (this.bBT != null) {
            this.bBT.clear();
        }
        this.bBR = 0;
    }

    public void setItemChecked(int i2, boolean z) {
        if (this.bBO != 0) {
            if (Build.VERSION.SDK_INT >= 11 && z && this.bBO == 3 && this.bBP == null) {
                if (this.bBQ == null || !((com.baidu.tieba.horizonalList.a.a.b) this.bBQ).Ua()) {
                    throw new IllegalStateException("AbsListView: attempted to start selection mode for CHOICE_MODE_MULTIPLE_MODAL but no choice mode callback was supplied. Call setMultiChoiceModeListener to set a callback.");
                }
                this.bBP = startActionMode((com.baidu.tieba.horizonalList.a.a.b) this.bBQ);
            }
            if (this.bBO == 2 || (Build.VERSION.SDK_INT >= 11 && this.bBO == 3)) {
                boolean booleanValue = this.bBS.get(i2, false).booleanValue();
                this.bBS.put(i2, Boolean.valueOf(z));
                if (this.bBT != null && this.mAdapter.hasStableIds()) {
                    if (z) {
                        this.bBT.put(this.mAdapter.getItemId(i2), Integer.valueOf(i2));
                    } else {
                        this.bBT.delete(this.mAdapter.getItemId(i2));
                    }
                }
                if (booleanValue != z) {
                    if (z) {
                        this.bBR++;
                    } else {
                        this.bBR--;
                    }
                }
                if (this.bBP != null) {
                    ((com.baidu.tieba.horizonalList.a.a.b) this.bBQ).onItemCheckedStateChanged((ActionMode) this.bBP, i2, this.mAdapter.getItemId(i2), z);
                }
            } else {
                boolean z2 = this.bBT != null && this.mAdapter.hasStableIds();
                if (z || isItemChecked(i2)) {
                    this.bBS.clear();
                    if (z2) {
                        this.bBT.clear();
                    }
                }
                if (z) {
                    this.bBS.put(i2, true);
                    if (z2) {
                        this.bBT.put(this.mAdapter.getItemId(i2), Integer.valueOf(i2));
                    }
                    this.bBR = 1;
                } else if (this.bBS.size() == 0 || !this.bBS.valueAt(0).booleanValue()) {
                    this.bBR = 0;
                }
            }
            if (!this.mInLayout && !this.bEp) {
                this.aeW = true;
                UQ();
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
        if (this.bBO != 0) {
            if (this.bBO == 2 || (Build.VERSION.SDK_INT >= 11 && this.bBO == 3 && this.bBP != null)) {
                boolean z5 = !this.bBS.get(i2, false).booleanValue();
                this.bBS.put(i2, Boolean.valueOf(z5));
                if (this.bBT != null && this.mAdapter.hasStableIds()) {
                    if (z5) {
                        this.bBT.put(this.mAdapter.getItemId(i2), Integer.valueOf(i2));
                    } else {
                        this.bBT.delete(this.mAdapter.getItemId(i2));
                    }
                }
                if (z5) {
                    this.bBR++;
                } else {
                    this.bBR--;
                }
                if (this.bBP != null) {
                    ((com.baidu.tieba.horizonalList.a.a.b) this.bBQ).onItemCheckedStateChanged((ActionMode) this.bBP, i2, j2, z5);
                } else {
                    z4 = true;
                }
                z2 = z4;
                z4 = true;
            } else if (this.bBO == 1) {
                if (!this.bBS.get(i2, false).booleanValue()) {
                    this.bBS.clear();
                    this.bBS.put(i2, true);
                    if (this.bBT != null && this.mAdapter.hasStableIds()) {
                        this.bBT.clear();
                        this.bBT.put(this.mAdapter.getItemId(i2), Integer.valueOf(i2));
                    }
                    this.bBR = 1;
                } else if (this.bBS.size() == 0 || !this.bBS.valueAt(0).booleanValue()) {
                    this.bBR = 0;
                }
                z4 = true;
                z2 = true;
            } else {
                z2 = true;
            }
            if (z4) {
                Uc();
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

    private void Uc() {
        int i2 = this.bDU;
        int childCount = getChildCount();
        boolean z = Build.VERSION.SDK_INT >= 11;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            int i4 = i2 + i3;
            if (childAt instanceof Checkable) {
                ((Checkable) childAt).setChecked(this.bBS.get(i4, false).booleanValue());
            } else if (z) {
                childAt.setActivated(this.bBS.get(i4, false).booleanValue());
            }
        }
    }

    public int getChoiceMode() {
        return this.bBO;
    }

    public void setChoiceMode(int i2) {
        this.bBO = i2;
        if (Build.VERSION.SDK_INT >= 11 && this.bBP != null) {
            if (Build.VERSION.SDK_INT >= 11) {
                ((ActionMode) this.bBP).finish();
            }
            this.bBP = null;
        }
        if (this.bBO != 0) {
            if (this.bBS == null) {
                this.bBS = new SparseArrayCompat<>();
            }
            if (this.bBT == null && this.mAdapter != null && this.mAdapter.hasStableIds()) {
                this.bBT = new LongSparseArray<>();
            }
            if (Build.VERSION.SDK_INT >= 11 && this.bBO == 3) {
                clearChoices();
                setLongClickable(true);
            }
        }
    }

    public void setMultiChoiceModeListener(com.baidu.tieba.horizonalList.a.a.a aVar) {
        if (Build.VERSION.SDK_INT >= 11) {
            if (this.bBQ == null) {
                this.bBQ = new com.baidu.tieba.horizonalList.a.a.b(this);
            }
            ((com.baidu.tieba.horizonalList.a.a.b) this.bBQ).a(aVar);
            return;
        }
        Log.e("AbsListView", "setMultiChoiceModeListener not supported for this version of Android");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Ud() {
        int childCount = getChildCount();
        if (childCount == 0) {
            return true;
        }
        if (childCount != this.bEh) {
            return false;
        }
        return getChildAt(0).getLeft() >= this.bCf.left && getChildAt(childCount + (-1)).getRight() <= getWidth() - this.bCf.right;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public int getHorizontalScrollbarHeight() {
        return super.getHorizontalScrollbarHeight();
    }

    public void setSmoothScrollbarEnabled(boolean z) {
        this.bCx = z;
    }

    public void setOnScrollListener(h hVar) {
        this.bCw = hVar;
        Ue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ue() {
        if (this.bCw != null) {
            this.bCw.a(this, this.bDU, getChildCount(), this.bEh);
        }
        onScrollChanged(0, 0, 0, 0);
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEvent(int i2) {
        if (i2 == 4096) {
            int firstVisiblePosition = getFirstVisiblePosition();
            int lastVisiblePosition = getLastVisiblePosition();
            if (this.bDa != firstVisiblePosition || this.bDb != lastVisiblePosition) {
                this.bDa = firstVisiblePosition;
                this.bDb = lastVisiblePosition;
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
            Us();
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

    private void Uf() {
        setSelector(getResources().getDrawable(17301602));
    }

    public void setStackFromRight(boolean z) {
        if (this.bCv != z) {
            this.bCv = z;
            Ug();
        }
    }

    void Ug() {
        if (getChildCount() > 0) {
            Uh();
            requestLayout();
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new com.baidu.tieba.horizonalList.widget.f();
        long bDL;
        long bDM;
        int bDN;
        String bDO;
        boolean bDP;
        int bDQ;
        SparseArrayCompat<Boolean> bDR;
        LongSparseArray<Integer> bDS;
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
            this.bDL = parcel.readLong();
            this.bDM = parcel.readLong();
            this.bDN = parcel.readInt();
            this.position = parcel.readInt();
            this.width = parcel.readInt();
            this.bDO = parcel.readString();
            this.bDP = parcel.readByte() != 0;
            this.bDQ = parcel.readInt();
            this.bDR = f(parcel);
            this.bDS = e(parcel);
        }

        private LongSparseArray<Integer> e(Parcel parcel) {
            int readInt = parcel.readInt();
            if (readInt <= 0) {
                return null;
            }
            LongSparseArray<Integer> longSparseArray = new LongSparseArray<>(readInt);
            a(longSparseArray, parcel, readInt);
            return longSparseArray;
        }

        private SparseArrayCompat<Boolean> f(Parcel parcel) {
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
            parcel.writeLong(this.bDL);
            parcel.writeLong(this.bDM);
            parcel.writeInt(this.bDN);
            parcel.writeInt(this.position);
            parcel.writeInt(this.width);
            parcel.writeString(this.bDO);
            parcel.writeByte((byte) (this.bDP ? 1 : 0));
            parcel.writeInt(this.bDQ);
            a(this.bDR, parcel);
            a(this.bDS, parcel);
        }

        public String toString() {
            return "AbsListView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " selectedId=" + this.bDL + " firstId=" + this.bDM + " viewLeft=" + this.bDN + " position=" + this.position + " width=" + this.width + " filter=" + this.bDO + " checkState=" + this.bDR + "}";
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        boolean z = true;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.bDf != null) {
            savedState.bDL = this.bDf.bDL;
            savedState.bDM = this.bDf.bDM;
            savedState.bDN = this.bDf.bDN;
            savedState.position = this.bDf.position;
            savedState.width = this.bDf.width;
            savedState.bDO = this.bDf.bDO;
            savedState.bDP = this.bDf.bDP;
            savedState.bDQ = this.bDf.bDQ;
            savedState.bDR = this.bDf.bDR;
            savedState.bDS = this.bDf.bDS;
            return savedState;
        }
        boolean z2 = getChildCount() > 0 && this.bEh > 0;
        long selectedItemId = getSelectedItemId();
        savedState.bDL = selectedItemId;
        savedState.width = getWidth();
        if (selectedItemId >= 0) {
            savedState.bDN = this.bCu;
            savedState.position = getSelectedItemPosition();
            savedState.bDM = -1L;
        } else if (z2 && this.bDU > 0) {
            savedState.bDN = getChildAt(0).getLeft();
            int i2 = this.bDU;
            if (i2 >= this.bEh) {
                i2 = this.bEh - 1;
            }
            savedState.position = i2;
            savedState.bDM = this.mAdapter.getItemId(i2);
        } else {
            savedState.bDN = 0;
            savedState.bDM = -1L;
            savedState.position = 0;
        }
        savedState.bDO = null;
        savedState.bDP = (Build.VERSION.SDK_INT < 11 || this.bBO != 3 || this.bBP == null) ? false : false;
        if (this.bBS != null) {
            try {
                savedState.bDR = this.bBS.m1clone();
            } catch (NoSuchMethodError e2) {
                e2.printStackTrace();
                savedState.bDR = new SparseArrayCompat<>();
            }
        }
        if (this.bBT != null) {
            LongSparseArray<Integer> longSparseArray = new LongSparseArray<>();
            int size = this.bBT.size();
            for (int i3 = 0; i3 < size; i3++) {
                longSparseArray.put(this.bBT.keyAt(i3), this.bBT.valueAt(i3));
            }
            savedState.bDS = longSparseArray;
        }
        savedState.bDQ = this.bBR;
        return savedState;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.aeW = true;
        this.bDY = savedState.width;
        if (savedState.bDL >= 0) {
            this.bDZ = true;
            this.bDf = savedState;
            this.bDX = savedState.bDL;
            this.bDW = savedState.position;
            this.bDV = savedState.bDN;
            this.bEa = 0;
        } else if (savedState.bDM >= 0) {
            setSelectedPositionInt(-1);
            setNextSelectedPositionInt(-1);
            this.bBY = -1;
            this.bDZ = true;
            this.bDf = savedState;
            this.bDX = savedState.bDM;
            this.bDW = savedState.position;
            this.bDV = savedState.bDN;
            this.bEa = 1;
        }
        if (savedState.bDR != null) {
            this.bBS = savedState.bDR;
        }
        if (savedState.bDS != null) {
            this.bBT = savedState.bDS;
        }
        this.bBR = savedState.bDQ;
        if (Build.VERSION.SDK_INT >= 11 && savedState.bDP && this.bBO == 3 && this.bBQ != null) {
            this.bBP = startActionMode((com.baidu.tieba.horizonalList.a.a.b) this.bBQ);
        }
        requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onFocusChanged(boolean z, int i2, Rect rect) {
        super.onFocusChanged(z, i2, rect);
        if (z && this.bym < 0 && !isInTouchMode()) {
            if (!this.bDc && this.mAdapter != null) {
                this.aeW = true;
                this.bEi = this.bEh;
                this.bEh = this.mAdapter.getCount();
            }
            Uw();
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (!this.bEp && !this.mInLayout) {
            super.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Uh() {
        removeAllViewsInLayout();
        this.bDU = 0;
        this.aeW = false;
        this.bCN = null;
        this.bDZ = false;
        this.bDf = null;
        this.bEk = -1;
        this.bEl = Long.MIN_VALUE;
        setSelectedPositionInt(-1);
        setNextSelectedPositionInt(-1);
        this.bCu = 0;
        this.bBY = -1;
        this.bBZ.setEmpty();
        invalidate();
    }

    @Override // android.view.View
    protected int computeHorizontalScrollExtent() {
        int childCount = getChildCount();
        if (childCount > 0) {
            if (this.bCx) {
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
        int i3 = this.bDU;
        int childCount = getChildCount();
        if (i3 < 0 || childCount <= 0) {
            return 0;
        }
        if (this.bCx) {
            View childAt = getChildAt(0);
            int left = childAt.getLeft();
            int width = childAt.getWidth();
            if (width > 0) {
                return Math.max(((i3 * 100) - ((left * 100) / width)) + ((int) ((getScrollX() / getWidth()) * this.bEh * 100.0f)), 0);
            }
            return 0;
        }
        int i4 = this.bEh;
        if (i3 != 0) {
            i2 = i3 + childCount == i4 ? i4 : (childCount / 2) + i3;
        }
        return (int) (((i2 / i4) * childCount) + i3);
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        if (this.bCx) {
            int max = Math.max(this.bEh * 100, 0);
            if (getScrollX() != 0) {
                return max + Math.abs((int) ((getScrollX() / getWidth()) * this.bEh * 100.0f));
            }
            return max;
        }
        return this.bEh;
    }

    @Override // android.view.View
    protected float getLeftFadingEdgeStrength() {
        int childCount = getChildCount();
        float leftFadingEdgeStrength = super.getLeftFadingEdgeStrength();
        if (childCount != 0) {
            if (this.bDU > 0) {
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
            if ((this.bDU + childCount) - 1 < this.bEh - 1) {
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
        if (this.Hg == null) {
            Uf();
        }
        Rect rect = this.bCf;
        rect.left = this.bCb + getPaddingLeft();
        rect.top = this.bCc + getPaddingTop();
        rect.right = this.bCd + getPaddingRight();
        rect.bottom = this.bCe + getPaddingBottom();
        if (this.bCI == 1) {
            int childCount = getChildCount();
            int width = getWidth() - getPaddingRight();
            View childAt = getChildAt(childCount - 1);
            this.bCW = childCount + this.bDU >= this.bDd && (childAt != null ? childAt.getRight() : width) <= width;
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
            this.bCa.UC();
        }
        layoutChildren();
        this.mInLayout = false;
        this.bCB = (i4 - i2) / 3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void layoutChildren() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ui() {
        boolean z = true;
        if (this.bCh != null) {
            boolean z2 = this.bDU > 0;
            if (!z2 && getChildCount() > 0) {
                z2 = getChildAt(0).getLeft() < this.bCf.left;
            }
            this.bCh.setVisibility(z2 ? 0 : 4);
        }
        if (this.bCi != null) {
            int childCount = getChildCount();
            boolean z3 = this.bDU + childCount < this.bEh;
            if (z3 || childCount <= 0) {
                z = z3;
            } else if (getChildAt(childCount - 1).getRight() <= getRight() - this.bCf.right) {
                z = false;
            }
            this.bCi.setVisibility(z ? 0 : 4);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.g
    @ViewDebug.ExportedProperty
    public View getSelectedView() {
        if (this.bEh <= 0 || this.bym < 0) {
            return null;
        }
        return getChildAt(this.bym - this.bDU);
    }

    public int getListPaddingTop() {
        return this.bCf.top;
    }

    public int getListPaddingBottom() {
        return this.bCf.bottom;
    }

    public int getListPaddingLeft() {
        return this.bCf.left;
    }

    public int getListPaddingRight() {
        return this.bCf.right;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View a(int i2, boolean[] zArr) {
        View view;
        f fVar;
        zArr[0] = false;
        View hG = this.bCa.hG(i2);
        if (hG == null) {
            View hH = this.bCa.hH(i2);
            if (hH != null) {
                view = this.mAdapter.getView(i2, hH, this);
                if (view != hH) {
                    this.bCa.o(hH, i2);
                    if (this.bCJ != 0) {
                        view.setDrawingCacheBackgroundColor(this.bCJ);
                        hG = view;
                    }
                } else {
                    zArr[0] = true;
                    view.onFinishTemporaryDetach();
                    hG = view;
                }
                if (this.bBW) {
                    ViewGroup.LayoutParams layoutParams = hG.getLayoutParams();
                    if (layoutParams == null) {
                        fVar = (f) generateDefaultLayoutParams();
                    } else if (!checkLayoutParams(layoutParams)) {
                        fVar = (f) generateLayoutParams(layoutParams);
                    } else {
                        fVar = (f) layoutParams;
                    }
                    fVar.bDt = this.mAdapter.getItemId(i2);
                    hG.setLayoutParams(fVar);
                }
                if (this.bEj.isEnabled() && this.bCZ == null) {
                    this.bCZ = new g();
                }
            } else {
                view = this.mAdapter.getView(i2, null, this);
                if (this.bCJ != 0) {
                    view.setDrawingCacheBackgroundColor(this.bCJ);
                }
            }
            hG = view;
            if (this.bBW) {
            }
            if (this.bEj.isEnabled()) {
                this.bCZ = new g();
            }
        }
        return hG;
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
    public void c(int i2, View view) {
        if (i2 != -1) {
            this.bBY = i2;
        }
        Rect rect = this.bBZ;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        if (view instanceof m) {
            ((m) view).adjustListItemSelectionBounds(rect);
        }
        j(rect.left, rect.top, rect.right, rect.bottom);
        boolean z = this.bCK;
        if (view.isEnabled() != z) {
            this.bCK = !z;
            if (getSelectedItemPosition() != -1) {
                refreshDrawableState();
            }
        }
    }

    private void j(int i2, int i3, int i4, int i5) {
        this.bBZ.set(i2 - this.bCb, i3 - this.bCc, this.bCd + i4, this.bCe + i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        boolean z = this.bBX;
        if (!z) {
            h(canvas);
        }
        super.dispatchDraw(canvas);
        if (z) {
            h(canvas);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        if (getChildCount() > 0) {
            this.aeW = true;
            UQ();
        }
    }

    boolean Uj() {
        switch (this.mTouchMode) {
            case 1:
            case 2:
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Uk() {
        return (hasFocus() && !isInTouchMode()) || Uj();
    }

    private void h(Canvas canvas) {
        if (!this.bBZ.isEmpty()) {
            Drawable drawable = this.Hg;
            drawable.setBounds(this.bBZ);
            drawable.draw(canvas);
        }
    }

    public void setDrawSelectorOnTop(boolean z) {
        this.bBX = z;
    }

    public void setSelector(int i2) {
        setSelector(getResources().getDrawable(i2));
    }

    public void setSelector(Drawable drawable) {
        if (this.Hg != null) {
            this.Hg.setCallback(null);
            unscheduleDrawable(this.Hg);
        }
        this.Hg = drawable;
        Rect rect = new Rect();
        drawable.getPadding(rect);
        this.bCb = rect.left;
        this.bCc = rect.top;
        this.bCd = rect.right;
        this.bCe = rect.bottom;
        drawable.setCallback(this);
        Um();
    }

    public Drawable getSelector() {
        return this.Hg;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ul() {
        if (isEnabled() && isClickable()) {
            Drawable drawable = this.Hg;
            Rect rect = this.bBZ;
            if (drawable != null) {
                if ((isFocused() || Uj()) && !rect.isEmpty()) {
                    View childAt = getChildAt(this.bym - this.bDU);
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
                    if (isLongClickable && !this.aeW) {
                        if (this.bCF == null) {
                            this.bCF = new b(this, null);
                        }
                        this.bCF.UH();
                        postDelayed(this.bCF, ViewConfiguration.getLongPressTimeout());
                    }
                }
            }
        }
    }

    void Um() {
        if (this.Hg != null) {
            if (Uk()) {
                this.Hg.setState(getDrawableState());
            } else {
                this.Hg.setState(bDg);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Um();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i2) {
        if (this.bCK) {
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
        return this.Hg == drawable || super.verifyDrawable(drawable);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.Hg != null) {
            this.Hg.jumpToCurrentState();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnTouchModeChangeListener(this);
        if (this.mAdapter != null && this.bBV == null) {
            this.bBV = new a();
            this.mAdapter.registerDataSetObserver(this.bBV);
            this.aeW = true;
            this.bEi = this.bEh;
            this.bEh = this.mAdapter.getCount();
        }
        this.bDc = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.g, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.bCa.clear();
        getViewTreeObserver().removeOnTouchModeChangeListener(this);
        if (this.mAdapter != null && this.bBV != null) {
            this.mAdapter.unregisterDataSetObserver(this.bBV);
            this.bBV = null;
        }
        if (this.bCs != null) {
            removeCallbacks(this.bCs);
        }
        if (this.bCt != null) {
            this.bCt.stop();
        }
        if (this.bCM != null) {
            removeCallbacks(this.bCM);
        }
        if (this.bCG != null) {
            removeCallbacks(this.bCG);
        }
        if (this.bCH != null) {
            removeCallbacks(this.bCH);
            this.bCH = null;
        }
        this.bDc = false;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        int i2 = isInTouchMode() ? 0 : 1;
        if (!z) {
            setChildrenDrawingCacheEnabled(false);
            if (this.bCs != null) {
                removeCallbacks(this.bCs);
                this.bCs.UA();
                if (this.bCt != null) {
                    this.bCt.stop();
                }
                if (getScrollX() != 0) {
                    this.bBN.setScrollX(0);
                    Uy();
                    invalidate();
                }
            }
            if (i2 == 1) {
                this.bCz = this.bym;
            }
        } else if (i2 != this.bCC && this.bCC != -1) {
            if (i2 == 1) {
                Uw();
            } else {
                Ut();
                this.bBU = 0;
                layoutChildren();
            }
        }
        this.bCC = i2;
    }

    ContextMenu.ContextMenuInfo a(View view, int i2, long j2) {
        return new g.a(view, i2, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class n {
        private int bDT;

        private n() {
        }

        /* synthetic */ n(AbsHListView absHListView, n nVar) {
            this();
        }

        public void UH() {
            this.bDT = AbsHListView.this.getWindowAttachCount();
        }

        public boolean UI() {
            return AbsHListView.this.hasWindowFocus() && AbsHListView.this.getWindowAttachCount() == this.bDT;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class i extends n implements Runnable {
        int bDu;

        private i() {
            super(AbsHListView.this, null);
        }

        /* synthetic */ i(AbsHListView absHListView, i iVar) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            View childAt;
            if (!AbsHListView.this.aeW) {
                ListAdapter listAdapter = AbsHListView.this.mAdapter;
                int i = this.bDu;
                if (listAdapter != null && AbsHListView.this.bEh > 0 && i != -1 && i < listAdapter.getCount() && UI() && (childAt = AbsHListView.this.getChildAt(i - AbsHListView.this.bDU)) != null) {
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
            View childAt = AbsHListView.this.getChildAt(AbsHListView.this.bCl - AbsHListView.this.bDU);
            if (childAt != null) {
                if ((!UI() || AbsHListView.this.aeW) ? false : AbsHListView.this.b(childAt, AbsHListView.this.bCl, AbsHListView.this.mAdapter.getItemId(AbsHListView.this.bCl))) {
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
            super(AbsHListView.this, null);
        }

        /* synthetic */ b(AbsHListView absHListView, b bVar) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AbsHListView.this.isPressed() && AbsHListView.this.bym >= 0) {
                View childAt = AbsHListView.this.getChildAt(AbsHListView.this.bym - AbsHListView.this.bDU);
                if (!AbsHListView.this.aeW) {
                    if (UI() ? AbsHListView.this.b(childAt, AbsHListView.this.bym, AbsHListView.this.bEg) : false) {
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
        if (Build.VERSION.SDK_INT >= 11 && this.bBO == 3) {
            if (this.bBP == null) {
                ActionMode startActionMode = startActionMode((com.baidu.tieba.horizonalList.a.a.b) this.bBQ);
                this.bBP = startActionMode;
                if (startActionMode != null) {
                    setItemChecked(i2, true);
                    performHapticFeedback(0);
                }
            }
            return true;
        }
        boolean b2 = this.bEd != null ? this.bEd.b(this, view, i2, j2) : false;
        if (!b2) {
            this.bCA = a(view, i2, j2);
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
        return this.bCA;
    }

    public boolean a(float f2, float f3, int i2) {
        int pointToPosition = pointToPosition((int) f2, (int) f3);
        if (pointToPosition != -1) {
            long itemId = this.mAdapter.getItemId(pointToPosition);
            View childAt = getChildAt(pointToPosition - this.bDU);
            if (childAt != null) {
                this.bCA = a(childAt, pointToPosition, itemId);
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
            boolean b2 = this.bEd != null ? this.bEd.b(this, view, positionForView, itemId) : false;
            if (!b2) {
                this.bCA = a(getChildAt(positionForView - this.bDU), positionForView, itemId);
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
                if (isClickable() && isPressed() && this.bym >= 0 && this.mAdapter != null && this.bym < this.mAdapter.getCount()) {
                    View childAt = getChildAt(this.bym - this.bDU);
                    if (childAt != null) {
                        performItemClick(childAt, this.bym, this.bEg);
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
        Rect rect = this.bCy;
        if (rect == null) {
            this.bCy = new Rect();
            rect = this.bCy;
        }
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt.getVisibility() == 0) {
                childAt.getHitRect(rect);
                if (rect.contains(i2, i3)) {
                    return this.bDU + childCount;
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
                View childAt = AbsHListView.this.getChildAt(AbsHListView.this.bCl - AbsHListView.this.bDU);
                if (childAt != null && !childAt.hasFocusable()) {
                    AbsHListView.this.bBU = 0;
                    if (!AbsHListView.this.aeW) {
                        childAt.setPressed(true);
                        AbsHListView.this.setPressed(true);
                        AbsHListView.this.layoutChildren();
                        AbsHListView.this.c(AbsHListView.this.bCl, childAt);
                        AbsHListView.this.refreshDrawableState();
                        int longPressTimeout = ViewConfiguration.getLongPressTimeout();
                        boolean isLongClickable = AbsHListView.this.isLongClickable();
                        if (AbsHListView.this.Hg != null && (current = AbsHListView.this.Hg.getCurrent()) != null && (current instanceof TransitionDrawable)) {
                            if (isLongClickable) {
                                ((TransitionDrawable) current).startTransition(longPressTimeout);
                            } else {
                                ((TransitionDrawable) current).resetTransition();
                            }
                        }
                        if (isLongClickable) {
                            if (AbsHListView.this.bCD == null) {
                                AbsHListView.this.bCD = new c(AbsHListView.this, null);
                            }
                            AbsHListView.this.bCD.UH();
                            AbsHListView.this.postDelayed(AbsHListView.this.bCD, longPressTimeout);
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

    private boolean hu(int i2) {
        int i3 = i2 - this.bCo;
        int abs = Math.abs(i3);
        boolean z = getScrollX() != 0;
        if (z || abs > this.mTouchSlop) {
            Ur();
            if (z) {
                this.mTouchMode = 5;
                this.bCr = 0;
            } else {
                this.mTouchMode = 3;
                this.bCr = i3 > 0 ? this.mTouchSlop : -this.mTouchSlop;
            }
            Handler handler = getHandler();
            if (handler != null) {
                handler.removeCallbacks(this.bCD);
            }
            setPressed(false);
            View childAt = getChildAt(this.bCl - this.bDU);
            if (childAt != null) {
                childAt.setPressed(false);
            }
            hw(1);
            ViewParent parent = getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            hv(i2);
            return true;
        }
        return false;
    }

    private void hv(int i2) {
        int i3;
        int childCount;
        ViewParent parent;
        int i4 = i2 - this.bCo;
        int i5 = i4 - this.bCr;
        int i6 = this.bCq != Integer.MIN_VALUE ? i2 - this.bCq : i5;
        if (this.mTouchMode == 3) {
            if (i2 != this.bCq) {
                if (Math.abs(i4) > this.mTouchSlop && (parent = getParent()) != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
                if (this.bCl >= 0) {
                    childCount = this.bCl - this.bDU;
                } else {
                    childCount = getChildCount() / 2;
                }
                View childAt = getChildAt(childCount);
                int left = childAt != null ? childAt.getLeft() : 0;
                boolean ah = i6 != 0 ? ah(i5, i6) : false;
                View childAt2 = getChildAt(childCount);
                if (childAt2 != null) {
                    int left2 = childAt2.getLeft();
                    if (ah) {
                        int i7 = (-i6) - (left2 - left);
                        overScrollBy(i7, 0, getScrollX(), 0, 0, 0, this.bCQ, 0, true);
                        if (Math.abs(this.bCQ) == Math.abs(getScrollX()) && this.mVelocityTracker != null) {
                            this.mVelocityTracker.clear();
                        }
                        int overScrollMode = getOverScrollMode();
                        if (overScrollMode == 0 || (overScrollMode == 1 && !Ud())) {
                            this.mDirection = 0;
                            this.mTouchMode = 5;
                            if (i4 > 0) {
                                this.bCS.onPull(i7 / getWidth());
                                if (!this.bCT.isFinished()) {
                                    this.bCT.onRelease();
                                }
                                invalidate();
                            } else if (i4 < 0) {
                                this.bCT.onPull(i7 / getWidth());
                                if (!this.bCS.isFinished()) {
                                    this.bCS.onRelease();
                                }
                                invalidate();
                            }
                        }
                    }
                    this.bCo = i2;
                }
                this.bCq = i2;
            }
        } else if (this.mTouchMode == 5 && i2 != this.bCq) {
            int scrollX = getScrollX();
            int i8 = scrollX - i6;
            int i9 = i2 > this.bCq ? 1 : -1;
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
                overScrollBy(i10, 0, getScrollX(), 0, 0, 0, this.bCQ, 0, true);
                int overScrollMode2 = getOverScrollMode();
                if (overScrollMode2 == 0 || (overScrollMode2 == 1 && !Ud())) {
                    if (i4 > 0) {
                        this.bCS.onPull(i10 / getWidth());
                        if (!this.bCT.isFinished()) {
                            this.bCT.onRelease();
                        }
                        invalidate();
                    } else if (i4 < 0) {
                        this.bCT.onPull(i10 / getWidth());
                        if (!this.bCS.isFinished()) {
                            this.bCS.onRelease();
                        }
                        invalidate();
                    }
                }
            }
            if (i3 != 0) {
                if (getScrollX() != 0) {
                    this.bBN.setScrollX(0);
                    Un();
                }
                ah(i3, i3);
                this.mTouchMode = 3;
                int hz = hz(i2);
                this.bCr = 0;
                View childAt3 = getChildAt(hz - this.bDU);
                this.bCm = childAt3 != null ? childAt3.getLeft() : 0;
                this.bCo = i2;
                this.bCl = hz;
            }
            this.bCq = i2;
            this.mDirection = i9;
        }
    }

    protected void Un() {
        if (this.bBN.isHardwareAccelerated() && (getParent() instanceof View)) {
            ((View) getParent()).invalidate();
        }
    }

    @Override // android.view.ViewTreeObserver.OnTouchModeChangeListener
    public void onTouchModeChanged(boolean z) {
        if (z) {
            Ut();
            if (getWidth() > 0 && getChildCount() > 0) {
                layoutChildren();
            }
            Um();
            return;
        }
        int i2 = this.mTouchMode;
        if (i2 == 5 || i2 == 6) {
            if (this.bCs != null) {
                this.bCs.UA();
            }
            if (this.bCt != null) {
                this.bCt.stop();
            }
            if (getScrollX() != 0) {
                this.bBN.setScrollX(0);
                Uy();
                invalidate();
            }
        }
    }

    protected boolean f(MotionEvent motionEvent) {
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
        if (this.bCt != null) {
            this.bCt.stop();
        }
        if (this.bDc) {
            int action = motionEvent.getAction();
            Up();
            this.mVelocityTracker.addMovement(motionEvent);
            switch (action & MotionEventCompat.ACTION_MASK) {
                case 0:
                    switch (this.mTouchMode) {
                        case 6:
                            this.bCs.UA();
                            if (this.bCt != null) {
                                this.bCt.stop();
                            }
                            this.mTouchMode = 5;
                            this.bCp = (int) motionEvent.getY();
                            int x = (int) motionEvent.getX();
                            this.bCq = x;
                            this.bCo = x;
                            this.bCr = 0;
                            this.mActivePointerId = motionEvent.getPointerId(0);
                            this.mDirection = 0;
                            break;
                        default:
                            this.mActivePointerId = motionEvent.getPointerId(0);
                            int x2 = (int) motionEvent.getX();
                            int y = (int) motionEvent.getY();
                            int pointToPosition = pointToPosition(x2, y);
                            if (!this.aeW) {
                                if (this.mTouchMode != 4 && pointToPosition >= 0 && getAdapter().isEnabled(pointToPosition)) {
                                    this.mTouchMode = 0;
                                    if (this.bCE == null) {
                                        this.bCE = new d();
                                    }
                                    postDelayed(this.bCE, ViewConfiguration.getTapTimeout());
                                    i2 = pointToPosition;
                                } else if (this.mTouchMode == 4) {
                                    Ur();
                                    this.mTouchMode = 3;
                                    this.bCr = 0;
                                    i2 = hy(x2);
                                    this.bCs.UB();
                                }
                                if (i2 >= 0) {
                                    this.bCm = getChildAt(i2 - this.bDU).getLeft();
                                }
                                this.bCo = x2;
                                this.bCp = y;
                                this.bCl = i2;
                                this.bCq = ExploreByTouchHelper.INVALID_ID;
                                break;
                            }
                            i2 = pointToPosition;
                            if (i2 >= 0) {
                            }
                            this.bCo = x2;
                            this.bCp = y;
                            this.bCl = i2;
                            this.bCq = ExploreByTouchHelper.INVALID_ID;
                    }
                    if (f(motionEvent) && this.mTouchMode == 0) {
                        removeCallbacks(this.bCE);
                        break;
                    }
                    break;
                case 1:
                    switch (this.mTouchMode) {
                        case 0:
                        case 1:
                        case 2:
                            int i3 = this.bCl;
                            View childAt = getChildAt(i3 - this.bDU);
                            float x3 = motionEvent.getX();
                            boolean z = x3 > ((float) this.bCf.left) && x3 < ((float) (getWidth() - this.bCf.right));
                            if (childAt != null && !childAt.hasFocusable() && z) {
                                if (this.mTouchMode != 0) {
                                    childAt.setPressed(false);
                                }
                                if (this.bCG == null) {
                                    this.bCG = new i(this, null);
                                }
                                i iVar = this.bCG;
                                iVar.bDu = i3;
                                iVar.UH();
                                this.bCz = i3;
                                if (this.mTouchMode == 0 || this.mTouchMode == 1) {
                                    Handler handler = getHandler();
                                    if (handler != null) {
                                        handler.removeCallbacks(this.mTouchMode == 0 ? this.bCE : this.bCD);
                                    }
                                    this.bBU = 0;
                                    if (!this.aeW && this.mAdapter.isEnabled(i3)) {
                                        this.mTouchMode = 1;
                                        setSelectedPositionInt(this.bCl);
                                        layoutChildren();
                                        childAt.setPressed(true);
                                        c(this.bCl, childAt);
                                        setPressed(true);
                                        if (this.Hg != null && (current = this.Hg.getCurrent()) != null && (current instanceof TransitionDrawable)) {
                                            ((TransitionDrawable) current).resetTransition();
                                        }
                                        if (this.bCH != null) {
                                            removeCallbacks(this.bCH);
                                        }
                                        this.bCH = new com.baidu.tieba.horizonalList.widget.a(this, childAt, iVar);
                                        postDelayed(this.bCH, ViewConfiguration.getPressedStateDuration());
                                    } else {
                                        this.mTouchMode = -1;
                                        Um();
                                    }
                                    return true;
                                } else if (!this.aeW && this.mAdapter.isEnabled(i3)) {
                                    iVar.run();
                                }
                            }
                            this.mTouchMode = -1;
                            Um();
                            break;
                        case 3:
                            int childCount = getChildCount();
                            if (childCount > 0) {
                                int left = getChildAt(0).getLeft();
                                int right = getChildAt(childCount - 1).getRight();
                                int i4 = this.bCf.left;
                                int width = getWidth() - this.bCf.right;
                                if (this.bDU == 0 && left >= i4 && this.bDU + childCount < this.bEh && right <= getWidth() - width) {
                                    this.mTouchMode = -1;
                                    hw(0);
                                    break;
                                } else {
                                    VelocityTracker velocityTracker = this.mVelocityTracker;
                                    velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                                    int xVelocity = (int) (velocityTracker.getXVelocity(this.mActivePointerId) * this.bCO);
                                    if (Math.abs(xVelocity) > this.mMinimumVelocity && ((this.bDU != 0 || left != i4 - this.bCQ) && (childCount + this.bDU != this.bEh || right != this.bCQ + width))) {
                                        if (this.bCs == null) {
                                            this.bCs = new e();
                                        }
                                        hw(2);
                                        this.bCs.hA(-xVelocity);
                                        break;
                                    } else {
                                        this.mTouchMode = -1;
                                        hw(0);
                                        if (this.bCs != null) {
                                            this.bCs.UA();
                                        }
                                        if (this.bCt != null) {
                                            this.bCt.stop();
                                            break;
                                        }
                                    }
                                }
                            } else {
                                this.mTouchMode = -1;
                                hw(0);
                                break;
                            }
                            break;
                        case 5:
                            if (this.bCs == null) {
                                this.bCs = new e();
                            }
                            VelocityTracker velocityTracker2 = this.mVelocityTracker;
                            velocityTracker2.computeCurrentVelocity(1000, this.mMaximumVelocity);
                            int xVelocity2 = (int) velocityTracker2.getXVelocity(this.mActivePointerId);
                            hw(2);
                            if (Math.abs(xVelocity2) > this.mMinimumVelocity) {
                                this.bCs.hB(-xVelocity2);
                                break;
                            } else {
                                this.bCs.Uz();
                                break;
                            }
                    }
                    setPressed(false);
                    if (this.bCS != null) {
                        this.bCS.onRelease();
                        this.bCT.onRelease();
                    }
                    invalidate();
                    Handler handler2 = getHandler();
                    if (handler2 != null) {
                        handler2.removeCallbacks(this.bCD);
                    }
                    Uq();
                    this.mActivePointerId = -1;
                    break;
                case 2:
                    int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                    if (findPointerIndex == -1) {
                        this.mActivePointerId = motionEvent.getPointerId(0);
                        findPointerIndex = 0;
                    }
                    int x4 = (int) motionEvent.getX(findPointerIndex);
                    if (this.aeW) {
                        layoutChildren();
                    }
                    switch (this.mTouchMode) {
                        case 0:
                        case 1:
                        case 2:
                            hu(x4);
                            break;
                        case 3:
                        case 5:
                            hv(x4);
                            break;
                    }
                case 3:
                    switch (this.mTouchMode) {
                        case 5:
                            if (this.bCs == null) {
                                this.bCs = new e();
                            }
                            this.bCs.Uz();
                            break;
                        case 6:
                            break;
                        default:
                            this.mTouchMode = -1;
                            setPressed(false);
                            View childAt2 = getChildAt(this.bCl - this.bDU);
                            if (childAt2 != null) {
                                childAt2.setPressed(false);
                            }
                            Us();
                            Handler handler3 = getHandler();
                            if (handler3 != null) {
                                handler3.removeCallbacks(this.bCD);
                            }
                            Uq();
                            break;
                    }
                    if (this.bCS != null) {
                        this.bCS.onRelease();
                        this.bCT.onRelease();
                    }
                    this.mActivePointerId = -1;
                    break;
                case 5:
                    int actionIndex = motionEvent.getActionIndex();
                    int pointerId = motionEvent.getPointerId(actionIndex);
                    int x5 = (int) motionEvent.getX(actionIndex);
                    int y2 = (int) motionEvent.getY(actionIndex);
                    this.bCr = 0;
                    this.mActivePointerId = pointerId;
                    this.bCo = x5;
                    this.bCp = y2;
                    int pointToPosition2 = pointToPosition(x5, y2);
                    if (pointToPosition2 >= 0) {
                        this.bCm = getChildAt(pointToPosition2 - this.bDU).getLeft();
                        this.bCl = pointToPosition2;
                    }
                    this.bCq = x5;
                    break;
                case 6:
                    onSecondaryPointerUp(motionEvent);
                    int i5 = this.bCo;
                    int pointToPosition3 = pointToPosition(i5, this.bCp);
                    if (pointToPosition3 >= 0) {
                        this.bCm = getChildAt(pointToPosition3 - this.bDU).getLeft();
                        this.bCl = pointToPosition3;
                    }
                    this.bCq = i5;
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
            this.bBN.setScrollX(i2);
            Un();
            awakenScrollBars();
        }
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) != 0) {
            switch (motionEvent.getAction()) {
                case 8:
                    if (this.mTouchMode == -1) {
                        float axisValue = motionEvent.getAxisValue(10);
                        if (axisValue != 0.0f) {
                            int horizontalScrollFactor = (int) (axisValue * getHorizontalScrollFactor());
                            if (!ah(horizontalScrollFactor, horizontalScrollFactor)) {
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
        if (this.bDh == 0.0f) {
            TypedValue typedValue = new TypedValue();
            if (getContext().getTheme().resolveAttribute(n.c.hlv_listPreferredItemWidth, typedValue, true)) {
                this.bDh = typedValue.getDimension(getContext().getResources().getDisplayMetrics());
            } else {
                throw new IllegalStateException("Expected theme to define hlv_listPreferredItemWidth.");
            }
        }
        return this.bDh;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.bCS != null) {
            int scrollX = getScrollX();
            if (!this.bCS.isFinished()) {
                int save = canvas.save();
                int i2 = this.bCf.top + this.bCX;
                int height = (getHeight() - i2) - (this.bCf.bottom + this.bCY);
                int min = Math.min(0, this.bCU + scrollX);
                canvas.rotate(-90.0f);
                canvas.translate(i2 + (-getHeight()), min);
                this.bCS.setSize(height, height);
                if (this.bCS.draw(canvas)) {
                    invalidate();
                }
                canvas.restoreToCount(save);
            }
            if (!this.bCT.isFinished()) {
                int save2 = canvas.save();
                int i3 = this.bCf.left + this.bCX;
                int height2 = (getHeight() - i3) - (this.bCf.right + this.bCY);
                int max = Math.max(getWidth(), scrollX + this.bCV);
                canvas.rotate(90.0f);
                canvas.translate(-i3, -max);
                this.bCT.setSize(height2, height2);
                if (this.bCT.draw(canvas)) {
                    invalidate();
                }
                canvas.restoreToCount(save2);
            }
        }
    }

    private void Uo() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        } else {
            this.mVelocityTracker.clear();
        }
    }

    private void Up() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
    }

    private void Uq() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            Uq();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.bCt != null) {
            this.bCt.stop();
        }
        if (this.bDc) {
            switch (action & MotionEventCompat.ACTION_MASK) {
                case 0:
                    int i2 = this.mTouchMode;
                    if (i2 == 6 || i2 == 5) {
                        this.bCr = 0;
                        return true;
                    }
                    int x = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();
                    this.mActivePointerId = motionEvent.getPointerId(0);
                    int hy = hy(x);
                    if (i2 != 4 && hy >= 0) {
                        this.bCm = getChildAt(hy - this.bDU).getLeft();
                        this.bCo = x;
                        this.bCp = y;
                        this.bCl = hy;
                        this.mTouchMode = 0;
                        Us();
                    }
                    this.bCq = ExploreByTouchHelper.INVALID_ID;
                    Uo();
                    this.mVelocityTracker.addMovement(motionEvent);
                    return i2 == 4;
                case 1:
                case 3:
                    this.mTouchMode = -1;
                    this.mActivePointerId = -1;
                    Uq();
                    hw(0);
                    return false;
                case 2:
                    switch (this.mTouchMode) {
                        case 0:
                            int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                            if (findPointerIndex == -1) {
                                this.mActivePointerId = motionEvent.getPointerId(0);
                                findPointerIndex = 0;
                            }
                            Up();
                            this.mVelocityTracker.addMovement(motionEvent);
                            return hu((int) motionEvent.getX(findPointerIndex));
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
            this.bCo = (int) motionEvent.getX(i2);
            this.bCp = (int) motionEvent.getY(i2);
            this.bCr = 0;
            this.mActivePointerId = motionEvent.getPointerId(i2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        int childCount = getChildCount();
        int i2 = this.bDU;
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
    public void hw(int i2) {
        if (i2 != this.bCL && this.bCw != null) {
            this.bCL = i2;
            this.bCw.a(this, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e implements Runnable {
        private final q bDl;
        private int bDm;
        private final Runnable bDn = new com.baidu.tieba.horizonalList.widget.c(this);

        e() {
            this.bDl = new q(AbsHListView.this.getContext());
        }

        void hA(int i) {
            int i2 = i < 0 ? Integer.MAX_VALUE : 0;
            this.bDm = i2;
            this.bDl.setInterpolator(null);
            this.bDl.fling(i2, 0, i, 0, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
            AbsHListView.this.mTouchMode = 4;
            AbsHListView.this.bBN.d(this);
        }

        void Uz() {
            if (this.bDl.springBack(AbsHListView.this.getScrollX(), 0, 0, 0, 0, 0)) {
                AbsHListView.this.mTouchMode = 6;
                AbsHListView.this.invalidate();
                AbsHListView.this.bBN.d(this);
                return;
            }
            AbsHListView.this.mTouchMode = -1;
            AbsHListView.this.hw(0);
        }

        void hB(int i) {
            this.bDl.setInterpolator(null);
            this.bDl.fling(AbsHListView.this.getScrollX(), 0, i, 0, ExploreByTouchHelper.INVALID_ID, Integer.MAX_VALUE, 0, 0, AbsHListView.this.getWidth(), 0);
            AbsHListView.this.mTouchMode = 6;
            AbsHListView.this.invalidate();
            AbsHListView.this.bBN.d(this);
        }

        void hC(int i) {
            this.bDl.notifyHorizontalEdgeReached(AbsHListView.this.getScrollX(), 0, AbsHListView.this.bCR);
            int overScrollMode = AbsHListView.this.getOverScrollMode();
            if (overScrollMode == 0 || (overScrollMode == 1 && !AbsHListView.this.Ud())) {
                AbsHListView.this.mTouchMode = 6;
                int currVelocity = (int) this.bDl.getCurrVelocity();
                if (i > 0) {
                    AbsHListView.this.bCS.onAbsorb(currVelocity);
                } else {
                    AbsHListView.this.bCT.onAbsorb(currVelocity);
                }
            } else {
                AbsHListView.this.mTouchMode = -1;
                if (AbsHListView.this.bCt != null) {
                    AbsHListView.this.bCt.stop();
                }
            }
            AbsHListView.this.invalidate();
            AbsHListView.this.bBN.d(this);
        }

        void f(int i, int i2, boolean z) {
            int i3 = i < 0 ? Integer.MAX_VALUE : 0;
            this.bDm = i3;
            this.bDl.setInterpolator(z ? AbsHListView.bDe : null);
            this.bDl.startScroll(i3, 0, i, 0, i2);
            AbsHListView.this.mTouchMode = 4;
            AbsHListView.this.bBN.d(this);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void UA() {
            AbsHListView.this.mTouchMode = -1;
            AbsHListView.this.removeCallbacks(this);
            AbsHListView.this.removeCallbacks(this.bDn);
            AbsHListView.this.hw(0);
            AbsHListView.this.Us();
            this.bDl.abortAnimation();
            AbsHListView.this.overScrollBy(0, 0, 0, 0, 0, 0, 0, 0, false);
        }

        void UB() {
            AbsHListView.this.postDelayed(this.bDn, 40L);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // java.lang.Runnable
        public void run() {
            int max;
            boolean z = true;
            boolean z2 = false;
            switch (AbsHListView.this.mTouchMode) {
                case 3:
                    if (this.bDl.isFinished()) {
                        return;
                    }
                    break;
                case 4:
                    break;
                case 5:
                default:
                    UA();
                    return;
                case 6:
                    q qVar = this.bDl;
                    if (qVar.computeScrollOffset()) {
                        int scrollX = AbsHListView.this.getScrollX();
                        int currX = qVar.getCurrX();
                        if (AbsHListView.this.overScrollBy(currX - scrollX, 0, scrollX, 0, 0, 0, AbsHListView.this.bCR, 0, false)) {
                            boolean z3 = scrollX <= 0 && currX > 0;
                            if (scrollX >= 0 && currX < 0) {
                                z2 = true;
                            }
                            if (z3 || z2) {
                                int currVelocity = (int) qVar.getCurrVelocity();
                                if (z2) {
                                    currVelocity = -currVelocity;
                                }
                                qVar.abortAnimation();
                                hA(currVelocity);
                                return;
                            }
                            Uz();
                            return;
                        }
                        AbsHListView.this.invalidate();
                        AbsHListView.this.bBN.d(this);
                        return;
                    }
                    UA();
                    return;
            }
            if (AbsHListView.this.aeW) {
                AbsHListView.this.layoutChildren();
            }
            if (AbsHListView.this.bEh == 0 || AbsHListView.this.getChildCount() == 0) {
                UA();
                return;
            }
            q qVar2 = this.bDl;
            boolean computeScrollOffset = qVar2.computeScrollOffset();
            int currX2 = qVar2.getCurrX();
            int i = this.bDm - currX2;
            if (i > 0) {
                AbsHListView.this.bCl = AbsHListView.this.bDU;
                AbsHListView.this.bCm = AbsHListView.this.getChildAt(0).getLeft();
                max = Math.min(((AbsHListView.this.getWidth() - AbsHListView.this.getPaddingRight()) - AbsHListView.this.getPaddingLeft()) - 1, i);
            } else {
                int childCount = AbsHListView.this.getChildCount() - 1;
                AbsHListView.this.bCl = AbsHListView.this.bDU + childCount;
                AbsHListView.this.bCm = AbsHListView.this.getChildAt(childCount).getLeft();
                max = Math.max(-(((AbsHListView.this.getWidth() - AbsHListView.this.getPaddingRight()) - AbsHListView.this.getPaddingLeft()) - 1), i);
            }
            View childAt = AbsHListView.this.getChildAt(AbsHListView.this.bCl - AbsHListView.this.bDU);
            int left = childAt != null ? childAt.getLeft() : 0;
            boolean ah = AbsHListView.this.ah(max, max);
            if (!ah || max == 0) {
                z = false;
            }
            if (z) {
                if (childAt != null) {
                    AbsHListView.this.overScrollBy(-(max - (childAt.getLeft() - left)), 0, AbsHListView.this.getScrollX(), 0, 0, 0, AbsHListView.this.bCR, 0, false);
                }
                if (computeScrollOffset) {
                    hC(max);
                }
            } else if (computeScrollOffset && !z) {
                if (ah) {
                    AbsHListView.this.invalidate();
                }
                this.bDm = currX2;
                AbsHListView.this.bBN.d(this);
            } else {
                UA();
            }
        }
    }

    /* loaded from: classes.dex */
    public class j implements Runnable {
        private int bDA;
        private int bDv;
        private int bDw;
        private int bDx;
        private int bDy;
        private final int bDz;
        private int mMode;

        j() {
            this.bDz = ViewConfiguration.get(AbsHListView.this.getContext()).getScaledFadingEdgeLength();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void hA(int i) {
            int i2;
            stop();
            if (AbsHListView.this.aeW) {
                AbsHListView.this.bCN = new com.baidu.tieba.horizonalList.widget.d(this, i);
                return;
            }
            int childCount = AbsHListView.this.getChildCount();
            if (childCount != 0) {
                int i3 = AbsHListView.this.bDU;
                int i4 = (childCount + i3) - 1;
                int max = Math.max(0, Math.min(AbsHListView.this.getCount() - 1, i));
                if (max < i3) {
                    i2 = (i3 - max) + 1;
                    this.mMode = 2;
                } else if (max > i4) {
                    i2 = (max - i4) + 1;
                    this.mMode = 1;
                } else {
                    s(max, -1, 200);
                    return;
                }
                if (i2 > 0) {
                    this.bDy = 200 / i2;
                } else {
                    this.bDy = 200;
                }
                this.bDv = max;
                this.bDw = -1;
                this.bDx = -1;
                AbsHListView.this.bBN.d(this);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void aj(int i, int i2) {
            int i3;
            stop();
            if (i2 == -1) {
                hA(i);
            } else if (AbsHListView.this.aeW) {
                AbsHListView.this.bCN = new com.baidu.tieba.horizonalList.widget.e(this, i, i2);
            } else {
                int childCount = AbsHListView.this.getChildCount();
                if (childCount != 0) {
                    int i4 = AbsHListView.this.bDU;
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
                        s(max, i2, 200);
                        return;
                    }
                    if (i3 > 0) {
                        this.bDy = 200 / i3;
                    } else {
                        this.bDy = 200;
                    }
                    this.bDv = max;
                    this.bDw = i2;
                    this.bDx = -1;
                    AbsHListView.this.bBN.d(this);
                }
            }
        }

        void s(int i, int i2, int i3) {
            int i4 = AbsHListView.this.bDU;
            int childCount = (AbsHListView.this.getChildCount() + i4) - 1;
            int i5 = AbsHListView.this.bCf.left;
            int width = AbsHListView.this.getWidth() - AbsHListView.this.bCf.right;
            if (i < i4 || i > childCount) {
                Log.w("AbsListView", "scrollToVisible called with targetPos " + i + " not visible [" + i4 + ", " + childCount + "]");
            }
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
            int i2 = AbsHListView.this.bDU;
            switch (this.mMode) {
                case 1:
                    int childCount = AbsHListView.this.getChildCount() - 1;
                    int i3 = i2 + childCount;
                    if (childCount >= 0) {
                        if (i3 == this.bDx) {
                            AbsHListView.this.bBN.d(this);
                            return;
                        }
                        View childAt = AbsHListView.this.getChildAt(childCount);
                        AbsHListView.this.e((i3 < AbsHListView.this.bEh + (-1) ? Math.max(AbsHListView.this.bCf.right, this.bDz) : AbsHListView.this.bCf.right) + (childAt.getWidth() - (width - childAt.getLeft())), this.bDy, true);
                        this.bDx = i3;
                        if (i3 < this.bDv) {
                            AbsHListView.this.bBN.d(this);
                            return;
                        }
                        return;
                    }
                    return;
                case 2:
                    if (i2 == this.bDx) {
                        AbsHListView.this.bBN.d(this);
                        return;
                    }
                    View childAt2 = AbsHListView.this.getChildAt(0);
                    if (childAt2 != null) {
                        AbsHListView.this.e(childAt2.getLeft() - (i2 > 0 ? Math.max(this.bDz, AbsHListView.this.bCf.left) : AbsHListView.this.bCf.left), this.bDy, true);
                        this.bDx = i2;
                        if (i2 > this.bDv) {
                            AbsHListView.this.bBN.d(this);
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    int childCount2 = AbsHListView.this.getChildCount();
                    if (i2 != this.bDw && childCount2 > 1 && childCount2 + i2 < AbsHListView.this.bEh) {
                        int i4 = i2 + 1;
                        if (i4 == this.bDx) {
                            AbsHListView.this.bBN.d(this);
                            return;
                        }
                        View childAt3 = AbsHListView.this.getChildAt(1);
                        int width2 = childAt3.getWidth();
                        int left2 = childAt3.getLeft();
                        int max = Math.max(AbsHListView.this.bCf.right, this.bDz);
                        if (i4 < this.bDw) {
                            AbsHListView.this.e(Math.max(0, (left2 + width2) - max), this.bDy, true);
                            this.bDx = i4;
                            AbsHListView.this.bBN.d(this);
                            return;
                        } else if (left2 > max) {
                            AbsHListView.this.e(left2 - max, this.bDy, true);
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
                        if (i5 == this.bDx) {
                            AbsHListView.this.bBN.d(this);
                            return;
                        }
                        View childAt4 = AbsHListView.this.getChildAt(childCount3);
                        int width3 = childAt4.getWidth();
                        int left3 = childAt4.getLeft();
                        int i6 = width - left3;
                        int max2 = Math.max(AbsHListView.this.bCf.left, this.bDz);
                        this.bDx = i5;
                        if (i5 > this.bDw) {
                            AbsHListView.this.e(-(i6 - max2), this.bDy, true);
                            AbsHListView.this.bBN.d(this);
                            return;
                        }
                        int i7 = width - max2;
                        int i8 = left3 + width3;
                        if (i7 > i8) {
                            AbsHListView.this.e(-(i7 - i8), this.bDy, true);
                            return;
                        }
                        return;
                    }
                    return;
                case 5:
                    if (this.bDx == i2) {
                        AbsHListView.this.bBN.d(this);
                        return;
                    }
                    this.bDx = i2;
                    int childCount4 = AbsHListView.this.getChildCount();
                    int i9 = this.bDv;
                    int i10 = (i2 + childCount4) - 1;
                    if (i9 < i2) {
                        i = (i2 - i9) + 1;
                    } else if (i9 > i10) {
                        i = i9 - i10;
                    }
                    float min = Math.min(Math.abs(i / childCount4), 1.0f);
                    if (i9 < i2) {
                        AbsHListView.this.e((int) ((-AbsHListView.this.getWidth()) * min), (int) (min * this.bDy), true);
                        AbsHListView.this.bBN.d(this);
                        return;
                    } else if (i9 > i10) {
                        AbsHListView.this.e((int) (AbsHListView.this.getWidth() * min), (int) (min * this.bDy), true);
                        AbsHListView.this.bBN.d(this);
                        return;
                    } else {
                        AbsHListView.this.e(AbsHListView.this.getChildAt(i9 - i2).getLeft() - this.bDA, (int) (this.bDy * (Math.abs(left) / AbsHListView.this.getWidth())), true);
                        return;
                    }
                default:
                    return;
            }
        }
    }

    public void setFriction(float f2) {
        if (this.bCs == null) {
            this.bCs = new e();
        }
        this.bCs.bDl.setFriction(f2);
    }

    public void setVelocityScale(float f2) {
        this.bCO = f2;
    }

    public void smoothScrollToPosition(int i2, int i3) {
        if (this.bCt == null) {
            this.bCt = new j();
        }
        this.bCt.aj(i2, i3);
    }

    public void smoothScrollBy(int i2, int i3) {
        e(i2, i3, false);
    }

    public void e(int i2, int i3, boolean z) {
        if (this.bCs == null) {
            this.bCs = new e();
        }
        int i4 = this.bDU;
        int childCount = getChildCount();
        int i5 = i4 + childCount;
        int paddingLeft = getPaddingLeft();
        int width = getWidth() - getPaddingRight();
        if (i2 == 0 || this.bEh == 0 || childCount == 0 || ((i4 == 0 && getChildAt(0).getLeft() == paddingLeft && i2 < 0) || (i5 == this.bEh && getChildAt(childCount - 1).getRight() == width && i2 > 0))) {
            this.bCs.UA();
            if (this.bCt != null) {
                this.bCt.stop();
                return;
            }
            return;
        }
        hw(2);
        this.bCs.f(i2, i3, z);
    }

    private void Ur() {
        if (this.mScrollingCacheEnabled && !this.bCj && !this.bBN.isHardwareAccelerated()) {
            setChildrenDrawnWithCacheEnabled(true);
            setChildrenDrawingCacheEnabled(true);
            this.bCk = true;
            this.bCj = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Us() {
        if (!this.bBN.isHardwareAccelerated()) {
            if (this.bCM == null) {
                this.bCM = new com.baidu.tieba.horizonalList.widget.b(this);
            }
            post(this.bCM);
        }
    }

    boolean ah(int i2, int i3) {
        int min;
        int min2;
        int i4;
        int childCount = getChildCount();
        if (childCount == 0) {
            return true;
        }
        int left = getChildAt(0).getLeft();
        int right = getChildAt(childCount - 1).getRight();
        Rect rect = this.bCf;
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
        int i6 = this.bDU;
        if (i6 == 0) {
            this.bCU = left - rect.left;
        } else {
            this.bCU += min2;
        }
        if (i6 + childCount == this.bEh) {
            this.bCV = rect.right + right;
        } else {
            this.bCV += min2;
        }
        boolean z = i6 == 0 && left >= rect.left && min2 >= 0;
        boolean z2 = i6 + childCount == this.bEh && right <= getWidth() - rect.right && min2 <= 0;
        if (z || z2) {
            return min2 != 0;
        }
        boolean z3 = min2 < 0;
        boolean isInTouchMode = isInTouchMode();
        if (isInTouchMode) {
            Ut();
        }
        int headerViewsCount = getHeaderViewsCount();
        int footerViewsCount = this.bEh - getFooterViewsCount();
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
                    this.bCa.o(childAt, i11);
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
                    this.bCa.o(childAt2, i14);
                }
                i4 = i13;
                i7 = i12;
            }
        }
        this.bCn = this.bCm + min;
        this.bEp = true;
        if (i4 > 0) {
            detachViewsFromParent(i7, i4);
            this.bCa.UE();
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        hx(min2);
        if (z3) {
            this.bDU = i4 + this.bDU;
        }
        int abs = Math.abs(min2);
        if (i5 < abs || width < abs) {
            cZ(z3);
        }
        if (!isInTouchMode && this.bym != -1) {
            int i15 = this.bym - this.bDU;
            if (i15 >= 0 && i15 < getChildCount()) {
                c(this.bym, getChildAt(i15));
            }
        } else if (this.bBY != -1) {
            int i16 = this.bBY - this.bDU;
            if (i16 >= 0 && i16 < getChildCount()) {
                c(-1, getChildAt(i16));
            }
        } else {
            this.bBZ.setEmpty();
        }
        this.bEp = false;
        Ue();
        return false;
    }

    public void hx(int i2) {
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
    public void Ut() {
        if (this.bym != -1) {
            if (this.bBU != 4) {
                this.bCz = this.bym;
            }
            if (this.bEe >= 0 && this.bEe != this.bym) {
                this.bCz = this.bEe;
            }
            setSelectedPositionInt(-1);
            setNextSelectedPositionInt(-1);
            this.bCu = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int Uu() {
        int i2 = this.bym;
        if (i2 < 0) {
            i2 = this.bCz;
        }
        return Math.min(Math.max(0, i2), this.bEh - 1);
    }

    protected int hz(int i2) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return -1;
        }
        int hy = hy(i2);
        return hy == -1 ? (this.bDU + childCount) - 1 : hy;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Uv() {
        if (this.bym >= 0 || !Uw()) {
            return false;
        }
        Um();
        return true;
    }

    boolean Uw() {
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
        int i8 = this.bCf.left;
        int right = (getRight() - getLeft()) - this.bCf.right;
        int i9 = this.bDU;
        int i10 = this.bCz;
        if (i10 >= i9 && i10 < i9 + childCount) {
            View childAt = getChildAt(i10 - this.bDU);
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
            int i15 = this.bEh;
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
        this.bCz = -1;
        removeCallbacks(this.bCs);
        if (this.bCt != null) {
            this.bCt.stop();
        }
        this.mTouchMode = -1;
        Us();
        this.bDV = i2;
        int k2 = k(i3, z);
        if (k2 < i9 || k2 > getLastVisiblePosition()) {
            k2 = -1;
        } else {
            this.bBU = 4;
            Um();
            setSelectionInt(k2);
            Ue();
        }
        hw(0);
        return k2 >= 0;
    }

    void Ux() {
        int i2;
        boolean z;
        boolean z2;
        this.bBS.clear();
        int i3 = 0;
        boolean z3 = false;
        while (i3 < this.bBT.size()) {
            long keyAt = this.bBT.keyAt(i3);
            int intValue = this.bBT.valueAt(i3).intValue();
            if (keyAt != this.mAdapter.getItemId(intValue)) {
                int max = Math.max(0, intValue - 20);
                int min = Math.min(intValue + 20, this.bEh);
                while (true) {
                    if (max >= min) {
                        z2 = false;
                        break;
                    } else if (keyAt != this.mAdapter.getItemId(max)) {
                        max++;
                    } else {
                        this.bBS.put(max, true);
                        this.bBT.setValueAt(i3, Integer.valueOf(max));
                        z2 = true;
                        break;
                    }
                }
                if (!z2) {
                    this.bBT.delete(keyAt);
                    int i4 = i3 - 1;
                    this.bBR--;
                    if (Build.VERSION.SDK_INT <= 11 || this.bBP == null || this.bBQ == null) {
                        i2 = i4;
                        z = true;
                    } else {
                        ((com.baidu.tieba.horizonalList.a.a.b) this.bBQ).onItemCheckedStateChanged((ActionMode) this.bBP, intValue, keyAt, false);
                        i2 = i4;
                        z = true;
                    }
                    z3 = z;
                    i3 = i2 + 1;
                }
            } else {
                this.bBS.put(intValue, true);
            }
            i2 = i3;
            z = z3;
            z3 = z;
            i3 = i2 + 1;
        }
        if (z3 && this.bBP != null && Build.VERSION.SDK_INT > 11) {
            ((ActionMode) this.bBP).invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.g
    public void handleDataChanged() {
        int i2 = this.bEh;
        int i3 = this.bDd;
        this.bDd = this.bEh;
        if (this.bBO != 0 && this.mAdapter != null && this.mAdapter.hasStableIds()) {
            Ux();
        }
        this.bCa.UD();
        if (i2 > 0) {
            if (this.bDZ) {
                this.bDZ = false;
                this.bDf = null;
                if (this.bCI == 2) {
                    this.bBU = 3;
                    return;
                }
                if (this.bCI == 1) {
                    if (this.bCW) {
                        this.bCW = false;
                        this.bBU = 3;
                        return;
                    }
                    int childCount = getChildCount();
                    int width = getWidth() - getPaddingRight();
                    View childAt = getChildAt(childCount - 1);
                    int bottom = childAt != null ? childAt.getBottom() : width;
                    if (childCount + this.bDU >= i3 && bottom <= width) {
                        this.bBU = 3;
                        return;
                    }
                    awakenScrollBars();
                }
                switch (this.bEa) {
                    case 1:
                        this.bBU = 5;
                        this.bDW = Math.min(Math.max(0, this.bDW), i2 - 1);
                        return;
                    case 0:
                        if (isInTouchMode()) {
                            this.bBU = 5;
                            this.bDW = Math.min(Math.max(0, this.bDW), i2 - 1);
                            return;
                        }
                        int UP = UP();
                        if (UP >= 0 && k(UP, true) == UP) {
                            this.bDW = UP;
                            if (this.bDY == getWidth()) {
                                this.bBU = 5;
                            } else {
                                this.bBU = 2;
                            }
                            setNextSelectedPositionInt(UP);
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
                int k2 = k(selectedItemPosition, true);
                if (k2 >= 0) {
                    setNextSelectedPositionInt(k2);
                    return;
                }
                int k3 = k(selectedItemPosition, false);
                if (k3 >= 0) {
                    setNextSelectedPositionInt(k3);
                    return;
                }
            } else if (this.bCz >= 0) {
                return;
            }
        }
        this.bBU = this.bCv ? 3 : 1;
        this.bym = -1;
        this.bEg = Long.MIN_VALUE;
        this.bEe = -1;
        this.bEf = Long.MIN_VALUE;
        this.bDZ = false;
        this.bDf = null;
        this.bBY = -1;
        UO();
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
    /* renamed from: d */
    public f generateLayoutParams(AttributeSet attributeSet) {
        return new f(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof f;
    }

    public void setTranscriptMode(int i2) {
        this.bCI = i2;
    }

    public int getTranscriptMode() {
        return this.bCI;
    }

    @Override // android.view.View
    public int getSolidColor() {
        return this.bCJ;
    }

    public void setCacheColorHint(int i2) {
        if (i2 != this.bCJ) {
            this.bCJ = i2;
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                getChildAt(i3).setDrawingCacheBackgroundColor(i2);
            }
            this.bCa.setCacheColorHint(i2);
        }
    }

    @ViewDebug.ExportedProperty(category = "drawing")
    public int getCacheColorHint() {
        return this.bCJ;
    }

    private void Uy() {
        if (this.bCS != null) {
            this.bCS.finish();
            this.bCT.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ai(int i2, int i3) {
    }

    public void setRecyclerListener(l lVar) {
        this.bCa.bDD = lVar;
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
        public int bDp;
        public boolean bDq;
        public boolean bDr;
        public int bDs;
        public long bDt;

        public f(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.bDt = -1L;
        }

        public f(int i, int i2, int i3) {
            super(i, i2);
            this.bDt = -1L;
            this.bDp = i3;
        }

        public f(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.bDt = -1L;
        }
    }

    /* loaded from: classes.dex */
    public class k {
        private l bDD;
        private int bDE;
        private View[] bDF = new View[0];
        private ArrayList<View>[] bDG;
        private int bDH;
        private ArrayList<View> bDI;
        private ArrayList<View> bDJ;
        private SparseArrayCompat<View> bDK;

        public k() {
        }

        public void hD(int i) {
            if (i < 1) {
                throw new IllegalArgumentException("Can't have a viewTypeCount < 1");
            }
            ArrayList<View>[] arrayListArr = new ArrayList[i];
            for (int i2 = 0; i2 < i; i2++) {
                arrayListArr[i2] = new ArrayList<>();
            }
            this.bDH = i;
            this.bDI = arrayListArr[0];
            this.bDG = arrayListArr;
        }

        public void UC() {
            if (this.bDH == 1) {
                ArrayList<View> arrayList = this.bDI;
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    arrayList.get(i).forceLayout();
                }
            } else {
                int i2 = this.bDH;
                for (int i3 = 0; i3 < i2; i3++) {
                    ArrayList<View> arrayList2 = this.bDG[i3];
                    int size2 = arrayList2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        arrayList2.get(i4).forceLayout();
                    }
                }
            }
            if (this.bDK != null) {
                int size3 = this.bDK.size();
                for (int i5 = 0; i5 < size3; i5++) {
                    this.bDK.valueAt(i5).forceLayout();
                }
            }
        }

        public boolean hE(int i) {
            return i >= 0;
        }

        public void clear() {
            if (this.bDH == 1) {
                ArrayList<View> arrayList = this.bDI;
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    AbsHListView.this.removeDetachedView(arrayList.remove((size - 1) - i), false);
                }
            } else {
                int i2 = this.bDH;
                for (int i3 = 0; i3 < i2; i3++) {
                    ArrayList<View> arrayList2 = this.bDG[i3];
                    int size2 = arrayList2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        AbsHListView.this.removeDetachedView(arrayList2.remove((size2 - 1) - i4), false);
                    }
                }
            }
            if (this.bDK != null) {
                this.bDK.clear();
            }
        }

        public void ak(int i, int i2) {
            if (this.bDF.length < i) {
                this.bDF = new View[i];
            }
            this.bDE = i2;
            View[] viewArr = this.bDF;
            for (int i3 = 0; i3 < i; i3++) {
                View childAt = AbsHListView.this.getChildAt(i3);
                f fVar = (f) childAt.getLayoutParams();
                if (fVar != null && fVar.bDp != -2) {
                    viewArr[i3] = childAt;
                }
            }
        }

        public View hF(int i) {
            int i2 = i - this.bDE;
            View[] viewArr = this.bDF;
            if (i2 < 0 || i2 >= viewArr.length) {
                return null;
            }
            View view = viewArr[i2];
            viewArr[i2] = null;
            return view;
        }

        View hG(int i) {
            int indexOfKey;
            if (this.bDK != null && (indexOfKey = this.bDK.indexOfKey(i)) >= 0) {
                View valueAt = this.bDK.valueAt(indexOfKey);
                this.bDK.removeAt(indexOfKey);
                return valueAt;
            }
            return null;
        }

        void UD() {
            if (this.bDK != null) {
                this.bDK.clear();
            }
        }

        View hH(int i) {
            if (this.bDH == 1) {
                return AbsHListView.a(this.bDI, i);
            }
            int itemViewType = AbsHListView.this.mAdapter.getItemViewType(i);
            if (itemViewType >= 0 && itemViewType < this.bDG.length) {
                return AbsHListView.a(this.bDG[itemViewType], i);
            }
            return null;
        }

        public void o(View view, int i) {
            f fVar = (f) view.getLayoutParams();
            if (fVar != null) {
                fVar.bDs = i;
                int i2 = fVar.bDp;
                if (!hE(i2)) {
                    if (i2 != -2) {
                        if (this.bDJ == null) {
                            this.bDJ = new ArrayList<>();
                        }
                        this.bDJ.add(view);
                        return;
                    }
                    return;
                }
                view.onStartTemporaryDetach();
                if (this.bDH == 1) {
                    this.bDI.add(view);
                } else {
                    this.bDG[i2].add(view);
                }
                if (Build.VERSION.SDK_INT >= 14) {
                    view.setAccessibilityDelegate(null);
                }
                if (this.bDD != null) {
                    this.bDD.onMovedToScrapHeap(view);
                }
            }
        }

        public void UE() {
            if (this.bDJ != null) {
                int size = this.bDJ.size();
                for (int i = 0; i < size; i++) {
                    AbsHListView.this.removeDetachedView(this.bDJ.get(i), false);
                }
                this.bDJ.clear();
            }
        }

        public void UF() {
            View[] viewArr = this.bDF;
            boolean z = this.bDD != null;
            boolean z2 = this.bDH > 1;
            ArrayList<View> arrayList = this.bDI;
            for (int length = viewArr.length - 1; length >= 0; length--) {
                View view = viewArr[length];
                if (view != null) {
                    f fVar = (f) view.getLayoutParams();
                    int i = fVar.bDp;
                    viewArr[length] = null;
                    if (!hE(i)) {
                        if (i != -2) {
                            AbsHListView.this.removeDetachedView(view, false);
                        }
                    } else {
                        if (z2) {
                            arrayList = this.bDG[i];
                        }
                        view.onStartTemporaryDetach();
                        fVar.bDs = this.bDE + length;
                        arrayList.add(view);
                        if (Build.VERSION.SDK_INT >= 14) {
                            view.setAccessibilityDelegate(null);
                        }
                        if (z) {
                            this.bDD.onMovedToScrapHeap(view);
                        }
                    }
                }
            }
            UG();
        }

        private void UG() {
            int length = this.bDF.length;
            int i = this.bDH;
            ArrayList<View>[] arrayListArr = this.bDG;
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
            if (this.bDK != null) {
                for (int i6 = 0; i6 < this.bDK.size(); i6++) {
                    this.bDK.valueAt(i6);
                }
            }
        }

        void setCacheColorHint(int i) {
            View[] viewArr;
            if (this.bDH == 1) {
                ArrayList<View> arrayList = this.bDI;
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    arrayList.get(i2).setDrawingCacheBackgroundColor(i);
                }
            } else {
                int i3 = this.bDH;
                for (int i4 = 0; i4 < i3; i4++) {
                    ArrayList<View> arrayList2 = this.bDG[i4];
                    int size2 = arrayList2.size();
                    for (int i5 = 0; i5 < size2; i5++) {
                        arrayList2.get(i5).setDrawingCacheBackgroundColor(i);
                    }
                }
            }
            for (View view : this.bDF) {
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
                if (((f) view.getLayoutParams()).bDs == i2) {
                    arrayList.remove(i3);
                    return view;
                }
            }
            return arrayList.remove(size - 1);
        }
        return null;
    }
}
