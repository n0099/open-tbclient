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
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tieba.horizonalList.a.a;
import com.baidu.tieba.horizonalList.widget.g;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class AbsHListView extends com.baidu.tieba.horizonalList.widget.g<ListAdapter> implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnTouchModeChangeListener {
    static final Interpolator bQN = new LinearInterpolator();
    public static final int[] bQP = new int[1];
    Drawable Hy;
    int bPA;
    protected SparseArrayCompat<Boolean> bPB;
    LongSparseArray<Integer> bPC;
    protected int bPD;
    protected a bPE;
    boolean bPF;
    boolean bPG;
    int bPH;
    protected Rect bPI;
    protected final k bPJ;
    int bPK;
    int bPL;
    int bPM;
    int bPN;
    protected Rect bPO;
    protected int bPP;
    View bPQ;
    View bPR;
    protected boolean bPS;
    protected boolean bPT;
    protected int bPU;
    int bPV;
    int bPW;
    int bPX;
    int bPY;
    int bPZ;
    a.AbstractC0063a bPw;
    protected int bPx;
    public Object bPy;
    Object bPz;
    int bQA;
    private EdgeEffectCompat bQB;
    private EdgeEffectCompat bQC;
    private int bQD;
    private int bQE;
    private boolean bQF;
    private int bQG;
    private int bQH;
    private g bQI;
    private int bQJ;
    private int bQK;
    protected boolean bQL;
    private int bQM;
    private SavedState bQO;
    private float bQQ;
    int bQa;
    private e bQb;
    protected j bQc;
    protected int bQd;
    protected boolean bQe;
    private h bQf;
    private boolean bQg;
    private Rect bQh;
    protected int bQi;
    private ContextMenu.ContextMenuInfo bQj;
    protected int bQk;
    private int bQl;
    private c bQm;
    private Runnable bQn;
    private b bQo;
    private i bQp;
    private Runnable bQq;
    private int bQr;
    private int bQs;
    private boolean bQt;
    private int bQu;
    private Runnable bQv;
    protected Runnable bQw;
    private float bQx;
    protected final boolean[] bQy;
    int bQz;
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

    protected abstract void dv(boolean z);

    protected abstract int iE(int i2);

    public abstract void setSelectionInt(int i2);

    public AbsHListView(Context context) {
        super(context);
        this.bPx = 0;
        this.bPD = 0;
        this.bPG = false;
        this.bPH = -1;
        this.bPI = new Rect();
        this.bPJ = new k();
        this.bPK = 0;
        this.bPL = 0;
        this.bPM = 0;
        this.bPN = 0;
        this.bPO = new Rect();
        this.bPP = 0;
        this.mTouchMode = -1;
        this.bQd = 0;
        this.bQg = true;
        this.bQi = -1;
        this.bQj = null;
        this.bQl = -1;
        this.bQu = 0;
        this.bQx = 1.0f;
        this.bQy = new boolean[1];
        this.mActivePointerId = -1;
        this.mDirection = 0;
        ZK();
    }

    public AbsHListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, t.c.hlv_absHListViewStyle);
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
        this.bPx = 0;
        this.bPD = 0;
        this.bPG = false;
        this.bPH = -1;
        this.bPI = new Rect();
        this.bPJ = new k();
        this.bPK = 0;
        this.bPL = 0;
        this.bPM = 0;
        this.bPN = 0;
        this.bPO = new Rect();
        this.bPP = 0;
        this.mTouchMode = -1;
        this.bQd = 0;
        this.bQg = true;
        this.bQi = -1;
        this.bQj = null;
        this.bQl = -1;
        this.bQu = 0;
        this.bQx = 1.0f;
        this.bQy = new boolean[1];
        this.mActivePointerId = -1;
        this.mDirection = 0;
        ZK();
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, t.l.HListView, i2, 0);
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
        this.bPG = z3;
        setStackFromRight(z2);
        setScrollingCacheEnabled(z);
        setTranscriptMode(i3);
        setCacheColorHint(i4);
        setSmoothScrollbarEnabled(z4);
        setChoiceMode(i5);
    }

    private void ZK() {
        setClickable(true);
        setFocusableInTouchMode(true);
        setWillNotDraw(false);
        setAlwaysDrawnWithCacheEnabled(false);
        setScrollingCacheEnabled(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.bQz = viewConfiguration.getScaledOverscrollDistance();
        this.bQA = viewConfiguration.getScaledOverflingDistance();
        this.bPw = com.baidu.tieba.horizonalList.a.a.am(this);
    }

    @Override // android.view.View
    public void setOverScrollMode(int i2) {
        if (i2 != 2) {
            if (this.bQB == null) {
                Context context = getContext();
                this.bQB = new EdgeEffectCompat(context);
                this.bQC = new EdgeEffectCompat(context);
            }
        } else {
            this.bQB = null;
            this.bQC = null;
        }
        super.setOverScrollMode(i2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.horizonalList.widget.g
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            this.bPF = this.mAdapter.hasStableIds();
            if (this.bPx != 0 && this.bPF && this.bPC == null) {
                this.bPC = new LongSparseArray<>();
            }
        }
        if (this.bPB != null) {
            this.bPB.clear();
        }
        if (this.bPC != null) {
            this.bPC.clear();
        }
    }

    public int getCheckedItemCount() {
        return this.bPA;
    }

    public boolean isItemChecked(int i2) {
        if (this.bPx == 0 || this.bPB == null) {
            return false;
        }
        return this.bPB.get(i2, false).booleanValue();
    }

    public int getCheckedItemPosition() {
        if (this.bPx == 1 && this.bPB != null && this.bPB.size() == 1) {
            return this.bPB.keyAt(0);
        }
        return -1;
    }

    public SparseArrayCompat<Boolean> getCheckedItemPositions() {
        if (this.bPx != 0) {
            return this.bPB;
        }
        return null;
    }

    public long[] getCheckedItemIds() {
        if (this.bPx == 0 || this.bPC == null || this.mAdapter == null) {
            return new long[0];
        }
        LongSparseArray<Integer> longSparseArray = this.bPC;
        int size = longSparseArray.size();
        long[] jArr = new long[size];
        for (int i2 = 0; i2 < size; i2++) {
            jArr[i2] = longSparseArray.keyAt(i2);
        }
        return jArr;
    }

    public void clearChoices() {
        if (this.bPB != null) {
            this.bPB.clear();
        }
        if (this.bPC != null) {
            this.bPC.clear();
        }
        this.bPA = 0;
    }

    public void setItemChecked(int i2, boolean z) {
        if (this.bPx != 0) {
            if (Build.VERSION.SDK_INT >= 11 && z && this.bPx == 3 && this.bPy == null) {
                if (this.bPz == null || !((com.baidu.tieba.horizonalList.a.a.b) this.bPz).ZJ()) {
                    throw new IllegalStateException("AbsListView: attempted to start selection mode for CHOICE_MODE_MULTIPLE_MODAL but no choice mode callback was supplied. Call setMultiChoiceModeListener to set a callback.");
                }
                this.bPy = startActionMode((com.baidu.tieba.horizonalList.a.a.b) this.bPz);
            }
            if (this.bPx == 2 || (Build.VERSION.SDK_INT >= 11 && this.bPx == 3)) {
                boolean booleanValue = this.bPB.get(i2, false).booleanValue();
                this.bPB.put(i2, Boolean.valueOf(z));
                if (this.bPC != null && this.mAdapter.hasStableIds()) {
                    if (z) {
                        this.bPC.put(this.mAdapter.getItemId(i2), Integer.valueOf(i2));
                    } else {
                        this.bPC.delete(this.mAdapter.getItemId(i2));
                    }
                }
                if (booleanValue != z) {
                    if (z) {
                        this.bPA++;
                    } else {
                        this.bPA--;
                    }
                }
                if (this.bPy != null) {
                    ((com.baidu.tieba.horizonalList.a.a.b) this.bPz).onItemCheckedStateChanged((ActionMode) this.bPy, i2, this.mAdapter.getItemId(i2), z);
                }
            } else {
                boolean z2 = this.bPC != null && this.mAdapter.hasStableIds();
                if (z || isItemChecked(i2)) {
                    this.bPB.clear();
                    if (z2) {
                        this.bPC.clear();
                    }
                }
                if (z) {
                    this.bPB.put(i2, true);
                    if (z2) {
                        this.bPC.put(this.mAdapter.getItemId(i2), Integer.valueOf(i2));
                    }
                    this.bPA = 1;
                } else if (this.bPB.size() == 0 || !this.bPB.valueAt(0).booleanValue()) {
                    this.bPA = 0;
                }
            }
            if (!this.mInLayout && !this.bRY) {
                this.afh = true;
                aaz();
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
        if (this.bPx != 0) {
            if (this.bPx == 2 || (Build.VERSION.SDK_INT >= 11 && this.bPx == 3 && this.bPy != null)) {
                boolean z5 = !this.bPB.get(i2, false).booleanValue();
                this.bPB.put(i2, Boolean.valueOf(z5));
                if (this.bPC != null && this.mAdapter.hasStableIds()) {
                    if (z5) {
                        this.bPC.put(this.mAdapter.getItemId(i2), Integer.valueOf(i2));
                    } else {
                        this.bPC.delete(this.mAdapter.getItemId(i2));
                    }
                }
                if (z5) {
                    this.bPA++;
                } else {
                    this.bPA--;
                }
                if (this.bPy != null) {
                    ((com.baidu.tieba.horizonalList.a.a.b) this.bPz).onItemCheckedStateChanged((ActionMode) this.bPy, i2, j2, z5);
                } else {
                    z4 = true;
                }
                z2 = z4;
                z4 = true;
            } else if (this.bPx == 1) {
                if (!this.bPB.get(i2, false).booleanValue()) {
                    this.bPB.clear();
                    this.bPB.put(i2, true);
                    if (this.bPC != null && this.mAdapter.hasStableIds()) {
                        this.bPC.clear();
                        this.bPC.put(this.mAdapter.getItemId(i2), Integer.valueOf(i2));
                    }
                    this.bPA = 1;
                } else if (this.bPB.size() == 0 || !this.bPB.valueAt(0).booleanValue()) {
                    this.bPA = 0;
                }
                z4 = true;
                z2 = true;
            } else {
                z2 = true;
            }
            if (z4) {
                ZL();
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

    private void ZL() {
        int i2 = this.bRD;
        int childCount = getChildCount();
        boolean z = Build.VERSION.SDK_INT >= 11;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            int i4 = i2 + i3;
            if (childAt instanceof Checkable) {
                ((Checkable) childAt).setChecked(this.bPB.get(i4, false).booleanValue());
            } else if (z) {
                childAt.setActivated(this.bPB.get(i4, false).booleanValue());
            }
        }
    }

    public int getChoiceMode() {
        return this.bPx;
    }

    public void setChoiceMode(int i2) {
        this.bPx = i2;
        if (Build.VERSION.SDK_INT >= 11 && this.bPy != null) {
            if (Build.VERSION.SDK_INT >= 11) {
                ((ActionMode) this.bPy).finish();
            }
            this.bPy = null;
        }
        if (this.bPx != 0) {
            if (this.bPB == null) {
                this.bPB = new SparseArrayCompat<>();
            }
            if (this.bPC == null && this.mAdapter != null && this.mAdapter.hasStableIds()) {
                this.bPC = new LongSparseArray<>();
            }
            if (Build.VERSION.SDK_INT >= 11 && this.bPx == 3) {
                clearChoices();
                setLongClickable(true);
            }
        }
    }

    public void setMultiChoiceModeListener(com.baidu.tieba.horizonalList.a.a.a aVar) {
        if (Build.VERSION.SDK_INT >= 11) {
            if (this.bPz == null) {
                this.bPz = new com.baidu.tieba.horizonalList.a.a.b(this);
            }
            ((com.baidu.tieba.horizonalList.a.a.b) this.bPz).a(aVar);
            return;
        }
        Log.e("AbsListView", "setMultiChoiceModeListener not supported for this version of Android");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ZM() {
        int childCount = getChildCount();
        if (childCount == 0) {
            return true;
        }
        if (childCount != this.bRQ) {
            return false;
        }
        return getChildAt(0).getLeft() >= this.bPO.left && getChildAt(childCount + (-1)).getRight() <= getWidth() - this.bPO.right;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public int getHorizontalScrollbarHeight() {
        return super.getHorizontalScrollbarHeight();
    }

    public void setSmoothScrollbarEnabled(boolean z) {
        this.bQg = z;
    }

    public void setOnScrollListener(h hVar) {
        this.bQf = hVar;
        ZN();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ZN() {
        if (this.bQf != null) {
            this.bQf.a(this, this.bRD, getChildCount(), this.bRQ);
        }
        onScrollChanged(0, 0, 0, 0);
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEvent(int i2) {
        if (i2 == 4096) {
            int firstVisiblePosition = getFirstVisiblePosition();
            int lastVisiblePosition = getLastVisiblePosition();
            if (this.bQJ != firstVisiblePosition || this.bQK != lastVisiblePosition) {
                this.bQJ = firstVisiblePosition;
                this.bQK = lastVisiblePosition;
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
            aab();
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

    private void ZO() {
        setSelector(getResources().getDrawable(17301602));
    }

    public void setStackFromRight(boolean z) {
        if (this.bQe != z) {
            this.bQe = z;
            ZP();
        }
    }

    void ZP() {
        if (getChildCount() > 0) {
            ZQ();
            requestLayout();
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new com.baidu.tieba.horizonalList.widget.f();
        SparseArrayCompat<Boolean> bRA;
        LongSparseArray<Integer> bRB;
        long bRu;
        long bRv;
        int bRw;
        String bRx;
        boolean bRy;
        int bRz;
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
            this.bRu = parcel.readLong();
            this.bRv = parcel.readLong();
            this.bRw = parcel.readInt();
            this.position = parcel.readInt();
            this.width = parcel.readInt();
            this.bRx = parcel.readString();
            this.bRy = parcel.readByte() != 0;
            this.bRz = parcel.readInt();
            this.bRA = f(parcel);
            this.bRB = e(parcel);
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
            parcel.writeLong(this.bRu);
            parcel.writeLong(this.bRv);
            parcel.writeInt(this.bRw);
            parcel.writeInt(this.position);
            parcel.writeInt(this.width);
            parcel.writeString(this.bRx);
            parcel.writeByte((byte) (this.bRy ? 1 : 0));
            parcel.writeInt(this.bRz);
            a(this.bRA, parcel);
            a(this.bRB, parcel);
        }

        public String toString() {
            return "AbsListView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " selectedId=" + this.bRu + " firstId=" + this.bRv + " viewLeft=" + this.bRw + " position=" + this.position + " width=" + this.width + " filter=" + this.bRx + " checkState=" + this.bRA + "}";
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        boolean z = true;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.bQO != null) {
            savedState.bRu = this.bQO.bRu;
            savedState.bRv = this.bQO.bRv;
            savedState.bRw = this.bQO.bRw;
            savedState.position = this.bQO.position;
            savedState.width = this.bQO.width;
            savedState.bRx = this.bQO.bRx;
            savedState.bRy = this.bQO.bRy;
            savedState.bRz = this.bQO.bRz;
            savedState.bRA = this.bQO.bRA;
            savedState.bRB = this.bQO.bRB;
            return savedState;
        }
        boolean z2 = getChildCount() > 0 && this.bRQ > 0;
        long selectedItemId = getSelectedItemId();
        savedState.bRu = selectedItemId;
        savedState.width = getWidth();
        if (selectedItemId >= 0) {
            savedState.bRw = this.bQd;
            savedState.position = getSelectedItemPosition();
            savedState.bRv = -1L;
        } else if (z2 && this.bRD > 0) {
            savedState.bRw = getChildAt(0).getLeft();
            int i2 = this.bRD;
            if (i2 >= this.bRQ) {
                i2 = this.bRQ - 1;
            }
            savedState.position = i2;
            savedState.bRv = this.mAdapter.getItemId(i2);
        } else {
            savedState.bRw = 0;
            savedState.bRv = -1L;
            savedState.position = 0;
        }
        savedState.bRx = null;
        savedState.bRy = (Build.VERSION.SDK_INT < 11 || this.bPx != 3 || this.bPy == null) ? false : false;
        if (this.bPB != null) {
            try {
                savedState.bRA = this.bPB.m1clone();
            } catch (NoSuchMethodError e2) {
                e2.printStackTrace();
                savedState.bRA = new SparseArrayCompat<>();
            }
        }
        if (this.bPC != null) {
            LongSparseArray<Integer> longSparseArray = new LongSparseArray<>();
            int size = this.bPC.size();
            for (int i3 = 0; i3 < size; i3++) {
                longSparseArray.put(this.bPC.keyAt(i3), this.bPC.valueAt(i3));
            }
            savedState.bRB = longSparseArray;
        }
        savedState.bRz = this.bPA;
        return savedState;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.afh = true;
        this.bRH = savedState.width;
        if (savedState.bRu >= 0) {
            this.bRI = true;
            this.bQO = savedState;
            this.bRG = savedState.bRu;
            this.bRF = savedState.position;
            this.bRE = savedState.bRw;
            this.bRJ = 0;
        } else if (savedState.bRv >= 0) {
            setSelectedPositionInt(-1);
            setNextSelectedPositionInt(-1);
            this.bPH = -1;
            this.bRI = true;
            this.bQO = savedState;
            this.bRG = savedState.bRv;
            this.bRF = savedState.position;
            this.bRE = savedState.bRw;
            this.bRJ = 1;
        }
        if (savedState.bRA != null) {
            this.bPB = savedState.bRA;
        }
        if (savedState.bRB != null) {
            this.bPC = savedState.bRB;
        }
        this.bPA = savedState.bRz;
        if (Build.VERSION.SDK_INT >= 11 && savedState.bRy && this.bPx == 3 && this.bPz != null) {
            this.bPy = startActionMode((com.baidu.tieba.horizonalList.a.a.b) this.bPz);
        }
        requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onFocusChanged(boolean z, int i2, Rect rect) {
        super.onFocusChanged(z, i2, rect);
        if (z && this.bGW < 0 && !isInTouchMode()) {
            if (!this.bQL && this.mAdapter != null) {
                this.afh = true;
                this.bRR = this.bRQ;
                this.bRQ = this.mAdapter.getCount();
            }
            aaf();
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (!this.bRY && !this.mInLayout) {
            super.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ZQ() {
        removeAllViewsInLayout();
        this.bRD = 0;
        this.afh = false;
        this.bQw = null;
        this.bRI = false;
        this.bQO = null;
        this.bRT = -1;
        this.bRU = Long.MIN_VALUE;
        setSelectedPositionInt(-1);
        setNextSelectedPositionInt(-1);
        this.bQd = 0;
        this.bPH = -1;
        this.bPI.setEmpty();
        invalidate();
    }

    @Override // android.view.View
    protected int computeHorizontalScrollExtent() {
        int childCount = getChildCount();
        if (childCount > 0) {
            if (this.bQg) {
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
        int i3 = this.bRD;
        int childCount = getChildCount();
        if (i3 < 0 || childCount <= 0) {
            return 0;
        }
        if (this.bQg) {
            View childAt = getChildAt(0);
            int left = childAt.getLeft();
            int width = childAt.getWidth();
            if (width > 0) {
                return Math.max(((i3 * 100) - ((left * 100) / width)) + ((int) ((getScrollX() / getWidth()) * this.bRQ * 100.0f)), 0);
            }
            return 0;
        }
        int i4 = this.bRQ;
        if (i3 != 0) {
            i2 = i3 + childCount == i4 ? i4 : (childCount / 2) + i3;
        }
        return (int) (((i2 / i4) * childCount) + i3);
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        if (this.bQg) {
            int max = Math.max(this.bRQ * 100, 0);
            if (getScrollX() != 0) {
                return max + Math.abs((int) ((getScrollX() / getWidth()) * this.bRQ * 100.0f));
            }
            return max;
        }
        return this.bRQ;
    }

    @Override // android.view.View
    protected float getLeftFadingEdgeStrength() {
        int childCount = getChildCount();
        float leftFadingEdgeStrength = super.getLeftFadingEdgeStrength();
        if (childCount != 0) {
            if (this.bRD > 0) {
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
            if ((this.bRD + childCount) - 1 < this.bRQ - 1) {
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
        if (this.Hy == null) {
            ZO();
        }
        Rect rect = this.bPO;
        rect.left = this.bPK + getPaddingLeft();
        rect.top = this.bPL + getPaddingTop();
        rect.right = this.bPM + getPaddingRight();
        rect.bottom = this.bPN + getPaddingBottom();
        if (this.bQr == 1) {
            int childCount = getChildCount();
            int width = getWidth() - getPaddingRight();
            View childAt = getChildAt(childCount - 1);
            this.bQF = childCount + this.bRD >= this.bQM && (childAt != null ? childAt.getRight() : width) <= width;
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
            this.bPJ.aal();
        }
        layoutChildren();
        this.mInLayout = false;
        this.bQk = (i4 - i2) / 3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void layoutChildren() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ZR() {
        boolean z = true;
        if (this.bPQ != null) {
            boolean z2 = this.bRD > 0;
            if (!z2 && getChildCount() > 0) {
                z2 = getChildAt(0).getLeft() < this.bPO.left;
            }
            this.bPQ.setVisibility(z2 ? 0 : 4);
        }
        if (this.bPR != null) {
            int childCount = getChildCount();
            boolean z3 = this.bRD + childCount < this.bRQ;
            if (z3 || childCount <= 0) {
                z = z3;
            } else if (getChildAt(childCount - 1).getRight() <= getRight() - this.bPO.right) {
                z = false;
            }
            this.bPR.setVisibility(z ? 0 : 4);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.g
    @ViewDebug.ExportedProperty
    public View getSelectedView() {
        if (this.bRQ <= 0 || this.bGW < 0) {
            return null;
        }
        return getChildAt(this.bGW - this.bRD);
    }

    public int getListPaddingTop() {
        return this.bPO.top;
    }

    public int getListPaddingBottom() {
        return this.bPO.bottom;
    }

    public int getListPaddingLeft() {
        return this.bPO.left;
    }

    public int getListPaddingRight() {
        return this.bPO.right;
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
        View iL = this.bPJ.iL(i2);
        if (iL == null) {
            View iM = this.bPJ.iM(i2);
            if (iM != null) {
                view = this.mAdapter.getView(i2, iM, this);
                if (view != iM) {
                    this.bPJ.r(iM, i2);
                    if (this.bQs != 0) {
                        view.setDrawingCacheBackgroundColor(this.bQs);
                        iL = view;
                    }
                } else {
                    zArr[0] = true;
                    view.onFinishTemporaryDetach();
                    iL = view;
                }
                if (this.bPF) {
                    ViewGroup.LayoutParams layoutParams = iL.getLayoutParams();
                    if (layoutParams == null) {
                        fVar = (f) generateDefaultLayoutParams();
                    } else if (!checkLayoutParams(layoutParams)) {
                        fVar = (f) generateLayoutParams(layoutParams);
                    } else {
                        fVar = (f) layoutParams;
                    }
                    fVar.bRc = this.mAdapter.getItemId(i2);
                    iL.setLayoutParams(fVar);
                }
                if (this.bRS.isEnabled() && this.bQI == null) {
                    this.bQI = new g();
                }
            } else {
                view = this.mAdapter.getView(i2, null, this);
                if (this.bQs != 0) {
                    view.setDrawingCacheBackgroundColor(this.bQs);
                }
            }
            iL = view;
            if (this.bPF) {
            }
            if (this.bRS.isEnabled()) {
                this.bQI = new g();
            }
        }
        return iL;
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
    public void b(int i2, View view) {
        if (i2 != -1) {
            this.bPH = i2;
        }
        Rect rect = this.bPI;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        if (view instanceof m) {
            ((m) view).adjustListItemSelectionBounds(rect);
        }
        g(rect.left, rect.top, rect.right, rect.bottom);
        boolean z = this.bQt;
        if (view.isEnabled() != z) {
            this.bQt = !z;
            if (getSelectedItemPosition() != -1) {
                refreshDrawableState();
            }
        }
    }

    private void g(int i2, int i3, int i4, int i5) {
        this.bPI.set(i2 - this.bPK, i3 - this.bPL, this.bPM + i4, this.bPN + i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        boolean z = this.bPG;
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
            this.afh = true;
            aaz();
        }
    }

    boolean ZS() {
        switch (this.mTouchMode) {
            case 1:
            case 2:
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean ZT() {
        return (hasFocus() && !isInTouchMode()) || ZS();
    }

    private void h(Canvas canvas) {
        if (!this.bPI.isEmpty()) {
            Drawable drawable = this.Hy;
            drawable.setBounds(this.bPI);
            drawable.draw(canvas);
        }
    }

    public void setDrawSelectorOnTop(boolean z) {
        this.bPG = z;
    }

    public void setSelector(int i2) {
        setSelector(getResources().getDrawable(i2));
    }

    public void setSelector(Drawable drawable) {
        if (this.Hy != null) {
            this.Hy.setCallback(null);
            unscheduleDrawable(this.Hy);
        }
        this.Hy = drawable;
        Rect rect = new Rect();
        drawable.getPadding(rect);
        this.bPK = rect.left;
        this.bPL = rect.top;
        this.bPM = rect.right;
        this.bPN = rect.bottom;
        drawable.setCallback(this);
        ZV();
    }

    public Drawable getSelector() {
        return this.Hy;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ZU() {
        if (isEnabled() && isClickable()) {
            Drawable drawable = this.Hy;
            Rect rect = this.bPI;
            if (drawable != null) {
                if ((isFocused() || ZS()) && !rect.isEmpty()) {
                    View childAt = getChildAt(this.bGW - this.bRD);
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
                    if (isLongClickable && !this.afh) {
                        if (this.bQo == null) {
                            this.bQo = new b(this, null);
                        }
                        this.bQo.aaq();
                        postDelayed(this.bQo, ViewConfiguration.getLongPressTimeout());
                    }
                }
            }
        }
    }

    void ZV() {
        if (this.Hy != null) {
            if (ZT()) {
                this.Hy.setState(getDrawableState());
            } else {
                this.Hy.setState(bQP);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        ZV();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i2) {
        if (this.bQt) {
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
        return this.Hy == drawable || super.verifyDrawable(drawable);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.Hy != null) {
            this.Hy.jumpToCurrentState();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnTouchModeChangeListener(this);
        if (this.mAdapter != null && this.bPE == null) {
            this.bPE = new a();
            this.mAdapter.registerDataSetObserver(this.bPE);
            this.afh = true;
            this.bRR = this.bRQ;
            this.bRQ = this.mAdapter.getCount();
        }
        this.bQL = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.g, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.bPJ.clear();
        getViewTreeObserver().removeOnTouchModeChangeListener(this);
        if (this.mAdapter != null && this.bPE != null) {
            this.mAdapter.unregisterDataSetObserver(this.bPE);
            this.bPE = null;
        }
        if (this.bQb != null) {
            removeCallbacks(this.bQb);
        }
        if (this.bQc != null) {
            this.bQc.stop();
        }
        if (this.bQv != null) {
            removeCallbacks(this.bQv);
        }
        if (this.bQp != null) {
            removeCallbacks(this.bQp);
        }
        if (this.bQq != null) {
            removeCallbacks(this.bQq);
            this.bQq = null;
        }
        this.bQL = false;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        int i2 = isInTouchMode() ? 0 : 1;
        if (!z) {
            setChildrenDrawingCacheEnabled(false);
            if (this.bQb != null) {
                removeCallbacks(this.bQb);
                this.bQb.aaj();
                if (this.bQc != null) {
                    this.bQc.stop();
                }
                if (getScrollX() != 0) {
                    this.bPw.setScrollX(0);
                    aah();
                    invalidate();
                }
            }
            if (i2 == 1) {
                this.bQi = this.bGW;
            }
        } else if (i2 != this.bQl && this.bQl != -1) {
            if (i2 == 1) {
                aaf();
            } else {
                aac();
                this.bPD = 0;
                layoutChildren();
            }
        }
        this.bQl = i2;
    }

    ContextMenu.ContextMenuInfo b(View view, int i2, long j2) {
        return new g.a(view, i2, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class n {
        private int bRC;

        private n() {
        }

        /* synthetic */ n(AbsHListView absHListView, n nVar) {
            this();
        }

        public void aaq() {
            this.bRC = AbsHListView.this.getWindowAttachCount();
        }

        public boolean aar() {
            return AbsHListView.this.hasWindowFocus() && AbsHListView.this.getWindowAttachCount() == this.bRC;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class i extends n implements Runnable {
        int bRd;

        private i() {
            super(AbsHListView.this, null);
        }

        /* synthetic */ i(AbsHListView absHListView, i iVar) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            View childAt;
            if (!AbsHListView.this.afh) {
                ListAdapter listAdapter = AbsHListView.this.mAdapter;
                int i = this.bRd;
                if (listAdapter != null && AbsHListView.this.bRQ > 0 && i != -1 && i < listAdapter.getCount() && aar() && (childAt = AbsHListView.this.getChildAt(i - AbsHListView.this.bRD)) != null) {
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
            View childAt = AbsHListView.this.getChildAt(AbsHListView.this.bPU - AbsHListView.this.bRD);
            if (childAt != null) {
                if ((!aar() || AbsHListView.this.afh) ? false : AbsHListView.this.c(childAt, AbsHListView.this.bPU, AbsHListView.this.mAdapter.getItemId(AbsHListView.this.bPU))) {
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
            if (AbsHListView.this.isPressed() && AbsHListView.this.bGW >= 0) {
                View childAt = AbsHListView.this.getChildAt(AbsHListView.this.bGW - AbsHListView.this.bRD);
                if (!AbsHListView.this.afh) {
                    if (aar() ? AbsHListView.this.c(childAt, AbsHListView.this.bGW, AbsHListView.this.bRP) : false) {
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
        if (Build.VERSION.SDK_INT >= 11 && this.bPx == 3) {
            if (this.bPy == null) {
                ActionMode startActionMode = startActionMode((com.baidu.tieba.horizonalList.a.a.b) this.bPz);
                this.bPy = startActionMode;
                if (startActionMode != null) {
                    setItemChecked(i2, true);
                    performHapticFeedback(0);
                }
            }
            return true;
        }
        boolean b2 = this.bRM != null ? this.bRM.b(this, view, i2, j2) : false;
        if (!b2) {
            this.bQj = b(view, i2, j2);
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
        return this.bQj;
    }

    public boolean a(float f2, float f3, int i2) {
        int pointToPosition = pointToPosition((int) f2, (int) f3);
        if (pointToPosition != -1) {
            long itemId = this.mAdapter.getItemId(pointToPosition);
            View childAt = getChildAt(pointToPosition - this.bRD);
            if (childAt != null) {
                this.bQj = b(childAt, pointToPosition, itemId);
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
            boolean b2 = this.bRM != null ? this.bRM.b(this, view, positionForView, itemId) : false;
            if (!b2) {
                this.bQj = b(getChildAt(positionForView - this.bRD), positionForView, itemId);
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
                if (isClickable() && isPressed() && this.bGW >= 0 && this.mAdapter != null && this.bGW < this.mAdapter.getCount()) {
                    View childAt = getChildAt(this.bGW - this.bRD);
                    if (childAt != null) {
                        performItemClick(childAt, this.bGW, this.bRP);
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
        Rect rect = this.bQh;
        if (rect == null) {
            this.bQh = new Rect();
            rect = this.bQh;
        }
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt.getVisibility() == 0) {
                childAt.getHitRect(rect);
                if (rect.contains(i2, i3)) {
                    return this.bRD + childCount;
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
                View childAt = AbsHListView.this.getChildAt(AbsHListView.this.bPU - AbsHListView.this.bRD);
                if (childAt != null && !childAt.hasFocusable()) {
                    AbsHListView.this.bPD = 0;
                    if (!AbsHListView.this.afh) {
                        childAt.setPressed(true);
                        AbsHListView.this.setPressed(true);
                        AbsHListView.this.layoutChildren();
                        AbsHListView.this.b(AbsHListView.this.bPU, childAt);
                        AbsHListView.this.refreshDrawableState();
                        int longPressTimeout = ViewConfiguration.getLongPressTimeout();
                        boolean isLongClickable = AbsHListView.this.isLongClickable();
                        if (AbsHListView.this.Hy != null && (current = AbsHListView.this.Hy.getCurrent()) != null && (current instanceof TransitionDrawable)) {
                            if (isLongClickable) {
                                ((TransitionDrawable) current).startTransition(longPressTimeout);
                            } else {
                                ((TransitionDrawable) current).resetTransition();
                            }
                        }
                        if (isLongClickable) {
                            if (AbsHListView.this.bQm == null) {
                                AbsHListView.this.bQm = new c(AbsHListView.this, null);
                            }
                            AbsHListView.this.bQm.aaq();
                            AbsHListView.this.postDelayed(AbsHListView.this.bQm, longPressTimeout);
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

    private boolean iA(int i2) {
        int i3 = i2 - this.bPX;
        int abs = Math.abs(i3);
        boolean z = getScrollX() != 0;
        if (z || abs > this.mTouchSlop) {
            aaa();
            if (z) {
                this.mTouchMode = 5;
                this.bQa = 0;
            } else {
                this.mTouchMode = 3;
                this.bQa = i3 > 0 ? this.mTouchSlop : -this.mTouchSlop;
            }
            Handler handler = getHandler();
            if (handler != null) {
                handler.removeCallbacks(this.bQm);
            }
            setPressed(false);
            View childAt = getChildAt(this.bPU - this.bRD);
            if (childAt != null) {
                childAt.setPressed(false);
            }
            iC(1);
            ViewParent parent = getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            iB(i2);
            return true;
        }
        return false;
    }

    private void iB(int i2) {
        int i3;
        int childCount;
        ViewParent parent;
        int i4 = i2 - this.bPX;
        int i5 = i4 - this.bQa;
        int i6 = this.bPZ != Integer.MIN_VALUE ? i2 - this.bPZ : i5;
        if (this.mTouchMode == 3) {
            if (i2 != this.bPZ) {
                if (Math.abs(i4) > this.mTouchSlop && (parent = getParent()) != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
                if (this.bPU >= 0) {
                    childCount = this.bPU - this.bRD;
                } else {
                    childCount = getChildCount() / 2;
                }
                View childAt = getChildAt(childCount);
                int left = childAt != null ? childAt.getLeft() : 0;
                boolean ae = i6 != 0 ? ae(i5, i6) : false;
                View childAt2 = getChildAt(childCount);
                if (childAt2 != null) {
                    int left2 = childAt2.getLeft();
                    if (ae) {
                        int i7 = (-i6) - (left2 - left);
                        overScrollBy(i7, 0, getScrollX(), 0, 0, 0, this.bQz, 0, true);
                        if (Math.abs(this.bQz) == Math.abs(getScrollX()) && this.mVelocityTracker != null) {
                            this.mVelocityTracker.clear();
                        }
                        int overScrollMode = getOverScrollMode();
                        if (overScrollMode == 0 || (overScrollMode == 1 && !ZM())) {
                            this.mDirection = 0;
                            this.mTouchMode = 5;
                            if (i4 > 0) {
                                this.bQB.onPull(i7 / getWidth());
                                if (!this.bQC.isFinished()) {
                                    this.bQC.onRelease();
                                }
                                invalidate();
                            } else if (i4 < 0) {
                                this.bQC.onPull(i7 / getWidth());
                                if (!this.bQB.isFinished()) {
                                    this.bQB.onRelease();
                                }
                                invalidate();
                            }
                        }
                    }
                    this.bPX = i2;
                }
                this.bPZ = i2;
            }
        } else if (this.mTouchMode == 5 && i2 != this.bPZ) {
            int scrollX = getScrollX();
            int i8 = scrollX - i6;
            int i9 = i2 > this.bPZ ? 1 : -1;
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
                overScrollBy(i10, 0, getScrollX(), 0, 0, 0, this.bQz, 0, true);
                int overScrollMode2 = getOverScrollMode();
                if (overScrollMode2 == 0 || (overScrollMode2 == 1 && !ZM())) {
                    if (i4 > 0) {
                        this.bQB.onPull(i10 / getWidth());
                        if (!this.bQC.isFinished()) {
                            this.bQC.onRelease();
                        }
                        invalidate();
                    } else if (i4 < 0) {
                        this.bQC.onPull(i10 / getWidth());
                        if (!this.bQB.isFinished()) {
                            this.bQB.onRelease();
                        }
                        invalidate();
                    }
                }
            }
            if (i3 != 0) {
                if (getScrollX() != 0) {
                    this.bPw.setScrollX(0);
                    ZW();
                }
                ae(i3, i3);
                this.mTouchMode = 3;
                int iF = iF(i2);
                this.bQa = 0;
                View childAt3 = getChildAt(iF - this.bRD);
                this.bPV = childAt3 != null ? childAt3.getLeft() : 0;
                this.bPX = i2;
                this.bPU = iF;
            }
            this.bPZ = i2;
            this.mDirection = i9;
        }
    }

    protected void ZW() {
        if (this.bPw.isHardwareAccelerated() && (getParent() instanceof View)) {
            ((View) getParent()).invalidate();
        }
    }

    @Override // android.view.ViewTreeObserver.OnTouchModeChangeListener
    public void onTouchModeChanged(boolean z) {
        if (z) {
            aac();
            if (getWidth() > 0 && getChildCount() > 0) {
                layoutChildren();
            }
            ZV();
            return;
        }
        int i2 = this.mTouchMode;
        if (i2 == 5 || i2 == 6) {
            if (this.bQb != null) {
                this.bQb.aaj();
            }
            if (this.bQc != null) {
                this.bQc.stop();
            }
            if (getScrollX() != 0) {
                this.bPw.setScrollX(0);
                aah();
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
        if (this.bQc != null) {
            this.bQc.stop();
        }
        if (this.bQL) {
            int action = motionEvent.getAction();
            ZY();
            this.mVelocityTracker.addMovement(motionEvent);
            switch (action & MotionEventCompat.ACTION_MASK) {
                case 0:
                    switch (this.mTouchMode) {
                        case 6:
                            this.bQb.aaj();
                            if (this.bQc != null) {
                                this.bQc.stop();
                            }
                            this.mTouchMode = 5;
                            this.bPY = (int) motionEvent.getY();
                            int x = (int) motionEvent.getX();
                            this.bPZ = x;
                            this.bPX = x;
                            this.bQa = 0;
                            this.mActivePointerId = motionEvent.getPointerId(0);
                            this.mDirection = 0;
                            break;
                        default:
                            this.mActivePointerId = motionEvent.getPointerId(0);
                            int x2 = (int) motionEvent.getX();
                            int y = (int) motionEvent.getY();
                            int pointToPosition = pointToPosition(x2, y);
                            if (!this.afh) {
                                if (this.mTouchMode != 4 && pointToPosition >= 0 && getAdapter().isEnabled(pointToPosition)) {
                                    this.mTouchMode = 0;
                                    if (this.bQn == null) {
                                        this.bQn = new d();
                                    }
                                    postDelayed(this.bQn, ViewConfiguration.getTapTimeout());
                                    i2 = pointToPosition;
                                } else if (this.mTouchMode == 4) {
                                    aaa();
                                    this.mTouchMode = 3;
                                    this.bQa = 0;
                                    i2 = iE(x2);
                                    this.bQb.aak();
                                }
                                if (i2 >= 0) {
                                    this.bPV = getChildAt(i2 - this.bRD).getLeft();
                                }
                                this.bPX = x2;
                                this.bPY = y;
                                this.bPU = i2;
                                this.bPZ = ExploreByTouchHelper.INVALID_ID;
                                break;
                            }
                            i2 = pointToPosition;
                            if (i2 >= 0) {
                            }
                            this.bPX = x2;
                            this.bPY = y;
                            this.bPU = i2;
                            this.bPZ = ExploreByTouchHelper.INVALID_ID;
                    }
                    if (f(motionEvent) && this.mTouchMode == 0) {
                        removeCallbacks(this.bQn);
                        break;
                    }
                    break;
                case 1:
                    switch (this.mTouchMode) {
                        case 0:
                        case 1:
                        case 2:
                            int i3 = this.bPU;
                            View childAt = getChildAt(i3 - this.bRD);
                            float x3 = motionEvent.getX();
                            boolean z = x3 > ((float) this.bPO.left) && x3 < ((float) (getWidth() - this.bPO.right));
                            if (childAt != null && !childAt.hasFocusable() && z) {
                                if (this.mTouchMode != 0) {
                                    childAt.setPressed(false);
                                }
                                if (this.bQp == null) {
                                    this.bQp = new i(this, null);
                                }
                                i iVar = this.bQp;
                                iVar.bRd = i3;
                                iVar.aaq();
                                this.bQi = i3;
                                if (this.mTouchMode == 0 || this.mTouchMode == 1) {
                                    Handler handler = getHandler();
                                    if (handler != null) {
                                        handler.removeCallbacks(this.mTouchMode == 0 ? this.bQn : this.bQm);
                                    }
                                    this.bPD = 0;
                                    if (!this.afh && this.mAdapter.isEnabled(i3)) {
                                        this.mTouchMode = 1;
                                        setSelectedPositionInt(this.bPU);
                                        layoutChildren();
                                        childAt.setPressed(true);
                                        b(this.bPU, childAt);
                                        setPressed(true);
                                        if (this.Hy != null && (current = this.Hy.getCurrent()) != null && (current instanceof TransitionDrawable)) {
                                            ((TransitionDrawable) current).resetTransition();
                                        }
                                        if (this.bQq != null) {
                                            removeCallbacks(this.bQq);
                                        }
                                        this.bQq = new com.baidu.tieba.horizonalList.widget.a(this, childAt, iVar);
                                        postDelayed(this.bQq, ViewConfiguration.getPressedStateDuration());
                                    } else {
                                        this.mTouchMode = -1;
                                        ZV();
                                    }
                                    return true;
                                } else if (!this.afh && this.mAdapter.isEnabled(i3)) {
                                    iVar.run();
                                }
                            }
                            this.mTouchMode = -1;
                            ZV();
                            break;
                        case 3:
                            int childCount = getChildCount();
                            if (childCount > 0) {
                                int left = getChildAt(0).getLeft();
                                int right = getChildAt(childCount - 1).getRight();
                                int i4 = this.bPO.left;
                                int width = getWidth() - this.bPO.right;
                                if (this.bRD == 0 && left >= i4 && this.bRD + childCount < this.bRQ && right <= getWidth() - width) {
                                    this.mTouchMode = -1;
                                    iC(0);
                                    break;
                                } else {
                                    VelocityTracker velocityTracker = this.mVelocityTracker;
                                    velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                                    int xVelocity = (int) (velocityTracker.getXVelocity(this.mActivePointerId) * this.bQx);
                                    if (Math.abs(xVelocity) > this.mMinimumVelocity && ((this.bRD != 0 || left != i4 - this.bQz) && (childCount + this.bRD != this.bRQ || right != this.bQz + width))) {
                                        if (this.bQb == null) {
                                            this.bQb = new e();
                                        }
                                        iC(2);
                                        this.bQb.start(-xVelocity);
                                        break;
                                    } else {
                                        this.mTouchMode = -1;
                                        iC(0);
                                        if (this.bQb != null) {
                                            this.bQb.aaj();
                                        }
                                        if (this.bQc != null) {
                                            this.bQc.stop();
                                            break;
                                        }
                                    }
                                }
                            } else {
                                this.mTouchMode = -1;
                                iC(0);
                                break;
                            }
                            break;
                        case 5:
                            if (this.bQb == null) {
                                this.bQb = new e();
                            }
                            VelocityTracker velocityTracker2 = this.mVelocityTracker;
                            velocityTracker2.computeCurrentVelocity(1000, this.mMaximumVelocity);
                            int xVelocity2 = (int) velocityTracker2.getXVelocity(this.mActivePointerId);
                            iC(2);
                            if (Math.abs(xVelocity2) > this.mMinimumVelocity) {
                                this.bQb.iG(-xVelocity2);
                                break;
                            } else {
                                this.bQb.aai();
                                break;
                            }
                    }
                    setPressed(false);
                    if (this.bQB != null) {
                        this.bQB.onRelease();
                        this.bQC.onRelease();
                    }
                    invalidate();
                    Handler handler2 = getHandler();
                    if (handler2 != null) {
                        handler2.removeCallbacks(this.bQm);
                    }
                    ZZ();
                    this.mActivePointerId = -1;
                    break;
                case 2:
                    int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                    if (findPointerIndex == -1) {
                        this.mActivePointerId = motionEvent.getPointerId(0);
                        findPointerIndex = 0;
                    }
                    int x4 = (int) motionEvent.getX(findPointerIndex);
                    if (this.afh) {
                        layoutChildren();
                    }
                    switch (this.mTouchMode) {
                        case 0:
                        case 1:
                        case 2:
                            iA(x4);
                            break;
                        case 3:
                        case 5:
                            iB(x4);
                            break;
                    }
                case 3:
                    switch (this.mTouchMode) {
                        case 5:
                            if (this.bQb == null) {
                                this.bQb = new e();
                            }
                            this.bQb.aai();
                            break;
                        case 6:
                            break;
                        default:
                            this.mTouchMode = -1;
                            setPressed(false);
                            View childAt2 = getChildAt(this.bPU - this.bRD);
                            if (childAt2 != null) {
                                childAt2.setPressed(false);
                            }
                            aab();
                            Handler handler3 = getHandler();
                            if (handler3 != null) {
                                handler3.removeCallbacks(this.bQm);
                            }
                            ZZ();
                            break;
                    }
                    if (this.bQB != null) {
                        this.bQB.onRelease();
                        this.bQC.onRelease();
                    }
                    this.mActivePointerId = -1;
                    break;
                case 5:
                    int actionIndex = motionEvent.getActionIndex();
                    int pointerId = motionEvent.getPointerId(actionIndex);
                    int x5 = (int) motionEvent.getX(actionIndex);
                    int y2 = (int) motionEvent.getY(actionIndex);
                    this.bQa = 0;
                    this.mActivePointerId = pointerId;
                    this.bPX = x5;
                    this.bPY = y2;
                    int pointToPosition2 = pointToPosition(x5, y2);
                    if (pointToPosition2 >= 0) {
                        this.bPV = getChildAt(pointToPosition2 - this.bRD).getLeft();
                        this.bPU = pointToPosition2;
                    }
                    this.bPZ = x5;
                    break;
                case 6:
                    onSecondaryPointerUp(motionEvent);
                    int i5 = this.bPX;
                    int pointToPosition3 = pointToPosition(i5, this.bPY);
                    if (pointToPosition3 >= 0) {
                        this.bPV = getChildAt(pointToPosition3 - this.bRD).getLeft();
                        this.bPU = pointToPosition3;
                    }
                    this.bPZ = i5;
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
            this.bPw.setScrollX(i2);
            ZW();
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
                            if (!ae(horizontalScrollFactor, horizontalScrollFactor)) {
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
        if (this.bQQ == 0.0f) {
            TypedValue typedValue = new TypedValue();
            if (getContext().getTheme().resolveAttribute(t.c.hlv_listPreferredItemWidth, typedValue, true)) {
                this.bQQ = typedValue.getDimension(getContext().getResources().getDisplayMetrics());
            } else {
                throw new IllegalStateException("Expected theme to define hlv_listPreferredItemWidth.");
            }
        }
        return this.bQQ;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.bQB != null) {
            int scrollX = getScrollX();
            if (!this.bQB.isFinished()) {
                int save = canvas.save();
                int i2 = this.bPO.top + this.bQG;
                int height = (getHeight() - i2) - (this.bPO.bottom + this.bQH);
                int min = Math.min(0, this.bQD + scrollX);
                canvas.rotate(-90.0f);
                canvas.translate(i2 + (-getHeight()), min);
                this.bQB.setSize(height, height);
                if (this.bQB.draw(canvas)) {
                    invalidate();
                }
                canvas.restoreToCount(save);
            }
            if (!this.bQC.isFinished()) {
                int save2 = canvas.save();
                int i3 = this.bPO.left + this.bQG;
                int height2 = (getHeight() - i3) - (this.bPO.right + this.bQH);
                int max = Math.max(getWidth(), scrollX + this.bQE);
                canvas.rotate(90.0f);
                canvas.translate(-i3, -max);
                this.bQC.setSize(height2, height2);
                if (this.bQC.draw(canvas)) {
                    invalidate();
                }
                canvas.restoreToCount(save2);
            }
        }
    }

    private void ZX() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        } else {
            this.mVelocityTracker.clear();
        }
    }

    private void ZY() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
    }

    private void ZZ() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            ZZ();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.bQc != null) {
            this.bQc.stop();
        }
        if (this.bQL) {
            switch (action & MotionEventCompat.ACTION_MASK) {
                case 0:
                    int i2 = this.mTouchMode;
                    if (i2 == 6 || i2 == 5) {
                        this.bQa = 0;
                        return true;
                    }
                    int x = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();
                    this.mActivePointerId = motionEvent.getPointerId(0);
                    int iE = iE(x);
                    if (i2 != 4 && iE >= 0) {
                        this.bPV = getChildAt(iE - this.bRD).getLeft();
                        this.bPX = x;
                        this.bPY = y;
                        this.bPU = iE;
                        this.mTouchMode = 0;
                        aab();
                    }
                    this.bPZ = ExploreByTouchHelper.INVALID_ID;
                    ZX();
                    this.mVelocityTracker.addMovement(motionEvent);
                    return i2 == 4;
                case 1:
                case 3:
                    this.mTouchMode = -1;
                    this.mActivePointerId = -1;
                    ZZ();
                    iC(0);
                    return false;
                case 2:
                    switch (this.mTouchMode) {
                        case 0:
                            int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                            if (findPointerIndex == -1) {
                                this.mActivePointerId = motionEvent.getPointerId(0);
                                findPointerIndex = 0;
                            }
                            ZY();
                            this.mVelocityTracker.addMovement(motionEvent);
                            return iA((int) motionEvent.getX(findPointerIndex));
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
            this.bPX = (int) motionEvent.getX(i2);
            this.bPY = (int) motionEvent.getY(i2);
            this.bQa = 0;
            this.mActivePointerId = motionEvent.getPointerId(i2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        int childCount = getChildCount();
        int i2 = this.bRD;
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
    public void iC(int i2) {
        if (i2 != this.bQu && this.bQf != null) {
            this.bQu = i2;
            this.bQf.a(this, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e implements Runnable {
        private final o bQU;
        private int bQV;
        private final Runnable bQW = new com.baidu.tieba.horizonalList.widget.c(this);

        e() {
            this.bQU = new o(AbsHListView.this.getContext());
        }

        void start(int i) {
            int i2 = i < 0 ? Integer.MAX_VALUE : 0;
            this.bQV = i2;
            this.bQU.setInterpolator(null);
            this.bQU.fling(i2, 0, i, 0, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
            AbsHListView.this.mTouchMode = 4;
            AbsHListView.this.bPw.e(this);
        }

        void aai() {
            if (this.bQU.springBack(AbsHListView.this.getScrollX(), 0, 0, 0, 0, 0)) {
                AbsHListView.this.mTouchMode = 6;
                AbsHListView.this.invalidate();
                AbsHListView.this.bPw.e(this);
                return;
            }
            AbsHListView.this.mTouchMode = -1;
            AbsHListView.this.iC(0);
        }

        void iG(int i) {
            this.bQU.setInterpolator(null);
            this.bQU.fling(AbsHListView.this.getScrollX(), 0, i, 0, ExploreByTouchHelper.INVALID_ID, Integer.MAX_VALUE, 0, 0, AbsHListView.this.getWidth(), 0);
            AbsHListView.this.mTouchMode = 6;
            AbsHListView.this.invalidate();
            AbsHListView.this.bPw.e(this);
        }

        void iH(int i) {
            this.bQU.notifyHorizontalEdgeReached(AbsHListView.this.getScrollX(), 0, AbsHListView.this.bQA);
            int overScrollMode = AbsHListView.this.getOverScrollMode();
            if (overScrollMode == 0 || (overScrollMode == 1 && !AbsHListView.this.ZM())) {
                AbsHListView.this.mTouchMode = 6;
                int currVelocity = (int) this.bQU.getCurrVelocity();
                if (i > 0) {
                    AbsHListView.this.bQB.onAbsorb(currVelocity);
                } else {
                    AbsHListView.this.bQC.onAbsorb(currVelocity);
                }
            } else {
                AbsHListView.this.mTouchMode = -1;
                if (AbsHListView.this.bQc != null) {
                    AbsHListView.this.bQc.stop();
                }
            }
            AbsHListView.this.invalidate();
            AbsHListView.this.bPw.e(this);
        }

        void f(int i, int i2, boolean z) {
            int i3 = i < 0 ? Integer.MAX_VALUE : 0;
            this.bQV = i3;
            this.bQU.setInterpolator(z ? AbsHListView.bQN : null);
            this.bQU.startScroll(i3, 0, i, 0, i2);
            AbsHListView.this.mTouchMode = 4;
            AbsHListView.this.bPw.e(this);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void aaj() {
            AbsHListView.this.mTouchMode = -1;
            AbsHListView.this.removeCallbacks(this);
            AbsHListView.this.removeCallbacks(this.bQW);
            AbsHListView.this.iC(0);
            AbsHListView.this.aab();
            this.bQU.abortAnimation();
            AbsHListView.this.overScrollBy(0, 0, 0, 0, 0, 0, 0, 0, false);
        }

        void aak() {
            AbsHListView.this.postDelayed(this.bQW, 40L);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // java.lang.Runnable
        public void run() {
            int max;
            boolean z = true;
            boolean z2 = false;
            switch (AbsHListView.this.mTouchMode) {
                case 3:
                    if (this.bQU.isFinished()) {
                        return;
                    }
                    break;
                case 4:
                    break;
                case 5:
                default:
                    aaj();
                    return;
                case 6:
                    o oVar = this.bQU;
                    if (oVar.computeScrollOffset()) {
                        int scrollX = AbsHListView.this.getScrollX();
                        int currX = oVar.getCurrX();
                        if (AbsHListView.this.overScrollBy(currX - scrollX, 0, scrollX, 0, 0, 0, AbsHListView.this.bQA, 0, false)) {
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
                                start(currVelocity);
                                return;
                            }
                            aai();
                            return;
                        }
                        AbsHListView.this.invalidate();
                        AbsHListView.this.bPw.e(this);
                        return;
                    }
                    aaj();
                    return;
            }
            if (AbsHListView.this.afh) {
                AbsHListView.this.layoutChildren();
            }
            if (AbsHListView.this.bRQ == 0 || AbsHListView.this.getChildCount() == 0) {
                aaj();
                return;
            }
            o oVar2 = this.bQU;
            boolean computeScrollOffset = oVar2.computeScrollOffset();
            int currX2 = oVar2.getCurrX();
            int i = this.bQV - currX2;
            if (i > 0) {
                AbsHListView.this.bPU = AbsHListView.this.bRD;
                AbsHListView.this.bPV = AbsHListView.this.getChildAt(0).getLeft();
                max = Math.min(((AbsHListView.this.getWidth() - AbsHListView.this.getPaddingRight()) - AbsHListView.this.getPaddingLeft()) - 1, i);
            } else {
                int childCount = AbsHListView.this.getChildCount() - 1;
                AbsHListView.this.bPU = AbsHListView.this.bRD + childCount;
                AbsHListView.this.bPV = AbsHListView.this.getChildAt(childCount).getLeft();
                max = Math.max(-(((AbsHListView.this.getWidth() - AbsHListView.this.getPaddingRight()) - AbsHListView.this.getPaddingLeft()) - 1), i);
            }
            View childAt = AbsHListView.this.getChildAt(AbsHListView.this.bPU - AbsHListView.this.bRD);
            int left = childAt != null ? childAt.getLeft() : 0;
            boolean ae = AbsHListView.this.ae(max, max);
            if (!ae || max == 0) {
                z = false;
            }
            if (z) {
                if (childAt != null) {
                    AbsHListView.this.overScrollBy(-(max - (childAt.getLeft() - left)), 0, AbsHListView.this.getScrollX(), 0, 0, 0, AbsHListView.this.bQA, 0, false);
                }
                if (computeScrollOffset) {
                    iH(max);
                }
            } else if (computeScrollOffset && !z) {
                if (ae) {
                    AbsHListView.this.invalidate();
                }
                this.bQV = currX2;
                AbsHListView.this.bPw.e(this);
            } else {
                aaj();
            }
        }
    }

    /* loaded from: classes.dex */
    public class j implements Runnable {
        private int bRe;
        private int bRf;
        private int bRg;
        private int bRh;
        private final int bRi;
        private int bRj;
        private int mMode;

        j() {
            this.bRi = ViewConfiguration.get(AbsHListView.this.getContext()).getScaledFadingEdgeLength();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void start(int i) {
            int i2;
            stop();
            if (AbsHListView.this.afh) {
                AbsHListView.this.bQw = new com.baidu.tieba.horizonalList.widget.d(this, i);
                return;
            }
            int childCount = AbsHListView.this.getChildCount();
            if (childCount != 0) {
                int i3 = AbsHListView.this.bRD;
                int i4 = (childCount + i3) - 1;
                int max = Math.max(0, Math.min(AbsHListView.this.getCount() - 1, i));
                if (max < i3) {
                    i2 = (i3 - max) + 1;
                    this.mMode = 2;
                } else if (max > i4) {
                    i2 = (max - i4) + 1;
                    this.mMode = 1;
                } else {
                    r(max, -1, 200);
                    return;
                }
                if (i2 > 0) {
                    this.bRh = 200 / i2;
                } else {
                    this.bRh = 200;
                }
                this.bRe = max;
                this.bRf = -1;
                this.bRg = -1;
                AbsHListView.this.bPw.e(this);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void ag(int i, int i2) {
            int i3;
            stop();
            if (i2 == -1) {
                start(i);
            } else if (AbsHListView.this.afh) {
                AbsHListView.this.bQw = new com.baidu.tieba.horizonalList.widget.e(this, i, i2);
            } else {
                int childCount = AbsHListView.this.getChildCount();
                if (childCount != 0) {
                    int i4 = AbsHListView.this.bRD;
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
                        r(max, i2, 200);
                        return;
                    }
                    if (i3 > 0) {
                        this.bRh = 200 / i3;
                    } else {
                        this.bRh = 200;
                    }
                    this.bRe = max;
                    this.bRf = i2;
                    this.bRg = -1;
                    AbsHListView.this.bPw.e(this);
                }
            }
        }

        void r(int i, int i2, int i3) {
            int i4 = AbsHListView.this.bRD;
            int childCount = (AbsHListView.this.getChildCount() + i4) - 1;
            int i5 = AbsHListView.this.bPO.left;
            int width = AbsHListView.this.getWidth() - AbsHListView.this.bPO.right;
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
            int i2 = AbsHListView.this.bRD;
            switch (this.mMode) {
                case 1:
                    int childCount = AbsHListView.this.getChildCount() - 1;
                    int i3 = i2 + childCount;
                    if (childCount >= 0) {
                        if (i3 == this.bRg) {
                            AbsHListView.this.bPw.e(this);
                            return;
                        }
                        View childAt = AbsHListView.this.getChildAt(childCount);
                        AbsHListView.this.e((i3 < AbsHListView.this.bRQ + (-1) ? Math.max(AbsHListView.this.bPO.right, this.bRi) : AbsHListView.this.bPO.right) + (childAt.getWidth() - (width - childAt.getLeft())), this.bRh, true);
                        this.bRg = i3;
                        if (i3 < this.bRe) {
                            AbsHListView.this.bPw.e(this);
                            return;
                        }
                        return;
                    }
                    return;
                case 2:
                    if (i2 == this.bRg) {
                        AbsHListView.this.bPw.e(this);
                        return;
                    }
                    View childAt2 = AbsHListView.this.getChildAt(0);
                    if (childAt2 != null) {
                        AbsHListView.this.e(childAt2.getLeft() - (i2 > 0 ? Math.max(this.bRi, AbsHListView.this.bPO.left) : AbsHListView.this.bPO.left), this.bRh, true);
                        this.bRg = i2;
                        if (i2 > this.bRe) {
                            AbsHListView.this.bPw.e(this);
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    int childCount2 = AbsHListView.this.getChildCount();
                    if (i2 != this.bRf && childCount2 > 1 && childCount2 + i2 < AbsHListView.this.bRQ) {
                        int i4 = i2 + 1;
                        if (i4 == this.bRg) {
                            AbsHListView.this.bPw.e(this);
                            return;
                        }
                        View childAt3 = AbsHListView.this.getChildAt(1);
                        int width2 = childAt3.getWidth();
                        int left2 = childAt3.getLeft();
                        int max = Math.max(AbsHListView.this.bPO.right, this.bRi);
                        if (i4 < this.bRf) {
                            AbsHListView.this.e(Math.max(0, (left2 + width2) - max), this.bRh, true);
                            this.bRg = i4;
                            AbsHListView.this.bPw.e(this);
                            return;
                        } else if (left2 > max) {
                            AbsHListView.this.e(left2 - max, this.bRh, true);
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
                        if (i5 == this.bRg) {
                            AbsHListView.this.bPw.e(this);
                            return;
                        }
                        View childAt4 = AbsHListView.this.getChildAt(childCount3);
                        int width3 = childAt4.getWidth();
                        int left3 = childAt4.getLeft();
                        int i6 = width - left3;
                        int max2 = Math.max(AbsHListView.this.bPO.left, this.bRi);
                        this.bRg = i5;
                        if (i5 > this.bRf) {
                            AbsHListView.this.e(-(i6 - max2), this.bRh, true);
                            AbsHListView.this.bPw.e(this);
                            return;
                        }
                        int i7 = width - max2;
                        int i8 = left3 + width3;
                        if (i7 > i8) {
                            AbsHListView.this.e(-(i7 - i8), this.bRh, true);
                            return;
                        }
                        return;
                    }
                    return;
                case 5:
                    if (this.bRg == i2) {
                        AbsHListView.this.bPw.e(this);
                        return;
                    }
                    this.bRg = i2;
                    int childCount4 = AbsHListView.this.getChildCount();
                    int i9 = this.bRe;
                    int i10 = (i2 + childCount4) - 1;
                    if (i9 < i2) {
                        i = (i2 - i9) + 1;
                    } else if (i9 > i10) {
                        i = i9 - i10;
                    }
                    float min = Math.min(Math.abs(i / childCount4), 1.0f);
                    if (i9 < i2) {
                        AbsHListView.this.e((int) ((-AbsHListView.this.getWidth()) * min), (int) (min * this.bRh), true);
                        AbsHListView.this.bPw.e(this);
                        return;
                    } else if (i9 > i10) {
                        AbsHListView.this.e((int) (AbsHListView.this.getWidth() * min), (int) (min * this.bRh), true);
                        AbsHListView.this.bPw.e(this);
                        return;
                    } else {
                        AbsHListView.this.e(AbsHListView.this.getChildAt(i9 - i2).getLeft() - this.bRj, (int) (this.bRh * (Math.abs(left) / AbsHListView.this.getWidth())), true);
                        return;
                    }
                default:
                    return;
            }
        }
    }

    public void setFriction(float f2) {
        if (this.bQb == null) {
            this.bQb = new e();
        }
        this.bQb.bQU.setFriction(f2);
    }

    public void setVelocityScale(float f2) {
        this.bQx = f2;
    }

    public void smoothScrollToPosition(int i2, int i3) {
        if (this.bQc == null) {
            this.bQc = new j();
        }
        this.bQc.ag(i2, i3);
    }

    public void smoothScrollBy(int i2, int i3) {
        e(i2, i3, false);
    }

    public void e(int i2, int i3, boolean z) {
        if (this.bQb == null) {
            this.bQb = new e();
        }
        int i4 = this.bRD;
        int childCount = getChildCount();
        int i5 = i4 + childCount;
        int paddingLeft = getPaddingLeft();
        int width = getWidth() - getPaddingRight();
        if (i2 == 0 || this.bRQ == 0 || childCount == 0 || ((i4 == 0 && getChildAt(0).getLeft() == paddingLeft && i2 < 0) || (i5 == this.bRQ && getChildAt(childCount - 1).getRight() == width && i2 > 0))) {
            this.bQb.aaj();
            if (this.bQc != null) {
                this.bQc.stop();
                return;
            }
            return;
        }
        iC(2);
        this.bQb.f(i2, i3, z);
    }

    private void aaa() {
        if (this.mScrollingCacheEnabled && !this.bPS && !this.bPw.isHardwareAccelerated()) {
            setChildrenDrawnWithCacheEnabled(true);
            setChildrenDrawingCacheEnabled(true);
            this.bPT = true;
            this.bPS = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aab() {
        if (!this.bPw.isHardwareAccelerated()) {
            if (this.bQv == null) {
                this.bQv = new com.baidu.tieba.horizonalList.widget.b(this);
            }
            post(this.bQv);
        }
    }

    boolean ae(int i2, int i3) {
        int min;
        int min2;
        int i4;
        int childCount = getChildCount();
        if (childCount == 0) {
            return true;
        }
        int left = getChildAt(0).getLeft();
        int right = getChildAt(childCount - 1).getRight();
        Rect rect = this.bPO;
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
        int i6 = this.bRD;
        if (i6 == 0) {
            this.bQD = left - rect.left;
        } else {
            this.bQD += min2;
        }
        if (i6 + childCount == this.bRQ) {
            this.bQE = rect.right + right;
        } else {
            this.bQE += min2;
        }
        boolean z = i6 == 0 && left >= rect.left && min2 >= 0;
        boolean z2 = i6 + childCount == this.bRQ && right <= getWidth() - rect.right && min2 <= 0;
        if (z || z2) {
            return min2 != 0;
        }
        boolean z3 = min2 < 0;
        boolean isInTouchMode = isInTouchMode();
        if (isInTouchMode) {
            aac();
        }
        int headerViewsCount = getHeaderViewsCount();
        int footerViewsCount = this.bRQ - getFooterViewsCount();
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
                    this.bPJ.r(childAt, i11);
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
                    this.bPJ.r(childAt2, i14);
                }
                i4 = i13;
                i7 = i12;
            }
        }
        this.bPW = this.bPV + min;
        this.bRY = true;
        if (i4 > 0) {
            detachViewsFromParent(i7, i4);
            this.bPJ.aan();
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        iD(min2);
        if (z3) {
            this.bRD = i4 + this.bRD;
        }
        int abs = Math.abs(min2);
        if (i5 < abs || width < abs) {
            dv(z3);
        }
        if (!isInTouchMode && this.bGW != -1) {
            int i15 = this.bGW - this.bRD;
            if (i15 >= 0 && i15 < getChildCount()) {
                b(this.bGW, getChildAt(i15));
            }
        } else if (this.bPH != -1) {
            int i16 = this.bPH - this.bRD;
            if (i16 >= 0 && i16 < getChildCount()) {
                b(-1, getChildAt(i16));
            }
        } else {
            this.bPI.setEmpty();
        }
        this.bRY = false;
        ZN();
        return false;
    }

    public void iD(int i2) {
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
    public void aac() {
        if (this.bGW != -1) {
            if (this.bPD != 4) {
                this.bQi = this.bGW;
            }
            if (this.bRN >= 0 && this.bRN != this.bGW) {
                this.bQi = this.bRN;
            }
            setSelectedPositionInt(-1);
            setNextSelectedPositionInt(-1);
            this.bQd = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int aad() {
        int i2 = this.bGW;
        if (i2 < 0) {
            i2 = this.bQi;
        }
        return Math.min(Math.max(0, i2), this.bRQ - 1);
    }

    protected int iF(int i2) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return -1;
        }
        int iE = iE(i2);
        return iE == -1 ? (this.bRD + childCount) - 1 : iE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aae() {
        if (this.bGW >= 0 || !aaf()) {
            return false;
        }
        ZV();
        return true;
    }

    boolean aaf() {
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
        int i8 = this.bPO.left;
        int right = (getRight() - getLeft()) - this.bPO.right;
        int i9 = this.bRD;
        int i10 = this.bQi;
        if (i10 >= i9 && i10 < i9 + childCount) {
            View childAt = getChildAt(i10 - this.bRD);
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
            int i15 = this.bRQ;
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
        this.bQi = -1;
        removeCallbacks(this.bQb);
        if (this.bQc != null) {
            this.bQc.stop();
        }
        this.mTouchMode = -1;
        aab();
        this.bRE = i2;
        int k2 = k(i3, z);
        if (k2 < i9 || k2 > getLastVisiblePosition()) {
            k2 = -1;
        } else {
            this.bPD = 4;
            ZV();
            setSelectionInt(k2);
            ZN();
        }
        iC(0);
        return k2 >= 0;
    }

    void aag() {
        int i2;
        boolean z;
        boolean z2;
        this.bPB.clear();
        int i3 = 0;
        boolean z3 = false;
        while (i3 < this.bPC.size()) {
            long keyAt = this.bPC.keyAt(i3);
            int intValue = this.bPC.valueAt(i3).intValue();
            if (keyAt != this.mAdapter.getItemId(intValue)) {
                int max = Math.max(0, intValue - 20);
                int min = Math.min(intValue + 20, this.bRQ);
                while (true) {
                    if (max >= min) {
                        z2 = false;
                        break;
                    } else if (keyAt != this.mAdapter.getItemId(max)) {
                        max++;
                    } else {
                        this.bPB.put(max, true);
                        this.bPC.setValueAt(i3, Integer.valueOf(max));
                        z2 = true;
                        break;
                    }
                }
                if (!z2) {
                    this.bPC.delete(keyAt);
                    int i4 = i3 - 1;
                    this.bPA--;
                    if (Build.VERSION.SDK_INT <= 11 || this.bPy == null || this.bPz == null) {
                        i2 = i4;
                        z = true;
                    } else {
                        ((com.baidu.tieba.horizonalList.a.a.b) this.bPz).onItemCheckedStateChanged((ActionMode) this.bPy, intValue, keyAt, false);
                        i2 = i4;
                        z = true;
                    }
                    z3 = z;
                    i3 = i2 + 1;
                }
            } else {
                this.bPB.put(intValue, true);
            }
            i2 = i3;
            z = z3;
            z3 = z;
            i3 = i2 + 1;
        }
        if (z3 && this.bPy != null && Build.VERSION.SDK_INT > 11) {
            ((ActionMode) this.bPy).invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.g
    public void handleDataChanged() {
        int i2 = this.bRQ;
        int i3 = this.bQM;
        this.bQM = this.bRQ;
        if (this.bPx != 0 && this.mAdapter != null && this.mAdapter.hasStableIds()) {
            aag();
        }
        this.bPJ.aam();
        if (i2 > 0) {
            if (this.bRI) {
                this.bRI = false;
                this.bQO = null;
                if (this.bQr == 2) {
                    this.bPD = 3;
                    return;
                }
                if (this.bQr == 1) {
                    if (this.bQF) {
                        this.bQF = false;
                        this.bPD = 3;
                        return;
                    }
                    int childCount = getChildCount();
                    int width = getWidth() - getPaddingRight();
                    View childAt = getChildAt(childCount - 1);
                    int bottom = childAt != null ? childAt.getBottom() : width;
                    if (childCount + this.bRD >= i3 && bottom <= width) {
                        this.bPD = 3;
                        return;
                    }
                    awakenScrollBars();
                }
                switch (this.bRJ) {
                    case 1:
                        this.bPD = 5;
                        this.bRF = Math.min(Math.max(0, this.bRF), i2 - 1);
                        return;
                    case 0:
                        if (isInTouchMode()) {
                            this.bPD = 5;
                            this.bRF = Math.min(Math.max(0, this.bRF), i2 - 1);
                            return;
                        }
                        int aay = aay();
                        if (aay >= 0 && k(aay, true) == aay) {
                            this.bRF = aay;
                            if (this.bRH == getWidth()) {
                                this.bPD = 5;
                            } else {
                                this.bPD = 2;
                            }
                            setNextSelectedPositionInt(aay);
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
            } else if (this.bQi >= 0) {
                return;
            }
        }
        this.bPD = this.bQe ? 3 : 1;
        this.bGW = -1;
        this.bRP = Long.MIN_VALUE;
        this.bRN = -1;
        this.bRO = Long.MIN_VALUE;
        this.bRI = false;
        this.bQO = null;
        this.bPH = -1;
        aax();
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
            case DealIntentService.CLASS_TYPE_MY_COLLECT_UPDATE /* 33 */:
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
    /* renamed from: e */
    public f generateLayoutParams(AttributeSet attributeSet) {
        return new f(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof f;
    }

    public void setTranscriptMode(int i2) {
        this.bQr = i2;
    }

    public int getTranscriptMode() {
        return this.bQr;
    }

    @Override // android.view.View
    public int getSolidColor() {
        return this.bQs;
    }

    public void setCacheColorHint(int i2) {
        if (i2 != this.bQs) {
            this.bQs = i2;
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                getChildAt(i3).setDrawingCacheBackgroundColor(i2);
            }
            this.bPJ.setCacheColorHint(i2);
        }
    }

    @ViewDebug.ExportedProperty(category = "drawing")
    public int getCacheColorHint() {
        return this.bQs;
    }

    private void aah() {
        if (this.bQB != null) {
            this.bQB.finish();
            this.bQC.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void af(int i2, int i3) {
    }

    public void setRecyclerListener(l lVar) {
        this.bPJ.bRm = lVar;
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
        public int bQY;
        public boolean bQZ;
        public boolean bRa;
        public int bRb;
        public long bRc;

        public f(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.bRc = -1L;
        }

        public f(int i, int i2, int i3) {
            super(i, i2);
            this.bRc = -1L;
            this.bQY = i3;
        }

        public f(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.bRc = -1L;
        }
    }

    /* loaded from: classes.dex */
    public class k {
        private l bRm;
        private int bRn;
        private View[] bRo = new View[0];
        private ArrayList<View>[] bRp;
        private int bRq;
        private ArrayList<View> bRr;
        private ArrayList<View> bRs;
        private SparseArrayCompat<View> bRt;

        public k() {
        }

        public void iI(int i) {
            if (i < 1) {
                throw new IllegalArgumentException("Can't have a viewTypeCount < 1");
            }
            ArrayList<View>[] arrayListArr = new ArrayList[i];
            for (int i2 = 0; i2 < i; i2++) {
                arrayListArr[i2] = new ArrayList<>();
            }
            this.bRq = i;
            this.bRr = arrayListArr[0];
            this.bRp = arrayListArr;
        }

        public void aal() {
            if (this.bRq == 1) {
                ArrayList<View> arrayList = this.bRr;
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    arrayList.get(i).forceLayout();
                }
            } else {
                int i2 = this.bRq;
                for (int i3 = 0; i3 < i2; i3++) {
                    ArrayList<View> arrayList2 = this.bRp[i3];
                    int size2 = arrayList2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        arrayList2.get(i4).forceLayout();
                    }
                }
            }
            if (this.bRt != null) {
                int size3 = this.bRt.size();
                for (int i5 = 0; i5 < size3; i5++) {
                    this.bRt.valueAt(i5).forceLayout();
                }
            }
        }

        public boolean iJ(int i) {
            return i >= 0;
        }

        public void clear() {
            if (this.bRq == 1) {
                ArrayList<View> arrayList = this.bRr;
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    AbsHListView.this.removeDetachedView(arrayList.remove((size - 1) - i), false);
                }
            } else {
                int i2 = this.bRq;
                for (int i3 = 0; i3 < i2; i3++) {
                    ArrayList<View> arrayList2 = this.bRp[i3];
                    int size2 = arrayList2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        AbsHListView.this.removeDetachedView(arrayList2.remove((size2 - 1) - i4), false);
                    }
                }
            }
            if (this.bRt != null) {
                this.bRt.clear();
            }
        }

        public void ah(int i, int i2) {
            if (this.bRo.length < i) {
                this.bRo = new View[i];
            }
            this.bRn = i2;
            View[] viewArr = this.bRo;
            for (int i3 = 0; i3 < i; i3++) {
                View childAt = AbsHListView.this.getChildAt(i3);
                f fVar = (f) childAt.getLayoutParams();
                if (fVar != null && fVar.bQY != -2) {
                    viewArr[i3] = childAt;
                }
            }
        }

        public View iK(int i) {
            int i2 = i - this.bRn;
            View[] viewArr = this.bRo;
            if (i2 < 0 || i2 >= viewArr.length) {
                return null;
            }
            View view = viewArr[i2];
            viewArr[i2] = null;
            return view;
        }

        View iL(int i) {
            int indexOfKey;
            if (this.bRt != null && (indexOfKey = this.bRt.indexOfKey(i)) >= 0) {
                View valueAt = this.bRt.valueAt(indexOfKey);
                this.bRt.removeAt(indexOfKey);
                return valueAt;
            }
            return null;
        }

        void aam() {
            if (this.bRt != null) {
                this.bRt.clear();
            }
        }

        View iM(int i) {
            if (this.bRq == 1) {
                return AbsHListView.a(this.bRr, i);
            }
            int itemViewType = AbsHListView.this.mAdapter.getItemViewType(i);
            if (itemViewType >= 0 && itemViewType < this.bRp.length) {
                return AbsHListView.a(this.bRp[itemViewType], i);
            }
            return null;
        }

        public void r(View view, int i) {
            f fVar = (f) view.getLayoutParams();
            if (fVar != null) {
                fVar.bRb = i;
                int i2 = fVar.bQY;
                if (!iJ(i2)) {
                    if (i2 != -2) {
                        if (this.bRs == null) {
                            this.bRs = new ArrayList<>();
                        }
                        this.bRs.add(view);
                        return;
                    }
                    return;
                }
                view.onStartTemporaryDetach();
                if (this.bRq == 1) {
                    this.bRr.add(view);
                } else {
                    this.bRp[i2].add(view);
                }
                if (Build.VERSION.SDK_INT >= 14) {
                    view.setAccessibilityDelegate(null);
                }
                if (this.bRm != null) {
                    this.bRm.onMovedToScrapHeap(view);
                }
            }
        }

        public void aan() {
            if (this.bRs != null) {
                int size = this.bRs.size();
                for (int i = 0; i < size; i++) {
                    AbsHListView.this.removeDetachedView(this.bRs.get(i), false);
                }
                this.bRs.clear();
            }
        }

        public void aao() {
            View[] viewArr = this.bRo;
            boolean z = this.bRm != null;
            boolean z2 = this.bRq > 1;
            ArrayList<View> arrayList = this.bRr;
            for (int length = viewArr.length - 1; length >= 0; length--) {
                View view = viewArr[length];
                if (view != null) {
                    f fVar = (f) view.getLayoutParams();
                    int i = fVar.bQY;
                    viewArr[length] = null;
                    if (!iJ(i)) {
                        if (i != -2) {
                            AbsHListView.this.removeDetachedView(view, false);
                        }
                    } else {
                        if (z2) {
                            arrayList = this.bRp[i];
                        }
                        view.onStartTemporaryDetach();
                        fVar.bRb = this.bRn + length;
                        arrayList.add(view);
                        if (Build.VERSION.SDK_INT >= 14) {
                            view.setAccessibilityDelegate(null);
                        }
                        if (z) {
                            this.bRm.onMovedToScrapHeap(view);
                        }
                    }
                }
            }
            aap();
        }

        private void aap() {
            int length = this.bRo.length;
            int i = this.bRq;
            ArrayList<View>[] arrayListArr = this.bRp;
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
            if (this.bRt != null) {
                for (int i6 = 0; i6 < this.bRt.size(); i6++) {
                    this.bRt.valueAt(i6);
                }
            }
        }

        void setCacheColorHint(int i) {
            View[] viewArr;
            if (this.bRq == 1) {
                ArrayList<View> arrayList = this.bRr;
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    arrayList.get(i2).setDrawingCacheBackgroundColor(i);
                }
            } else {
                int i3 = this.bRq;
                for (int i4 = 0; i4 < i3; i4++) {
                    ArrayList<View> arrayList2 = this.bRp[i4];
                    int size2 = arrayList2.size();
                    for (int i5 = 0; i5 < size2; i5++) {
                        arrayList2.get(i5).setDrawingCacheBackgroundColor(i);
                    }
                }
            }
            for (View view : this.bRo) {
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
                if (((f) view.getLayoutParams()).bRb == i2) {
                    arrayList.remove(i3);
                    return view;
                }
            }
            return arrayList.remove(size - 1);
        }
        return null;
    }
}
