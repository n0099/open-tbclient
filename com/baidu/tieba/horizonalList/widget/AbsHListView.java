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
import com.baidu.tieba.horizonalList.a.a;
import com.baidu.tieba.horizonalList.widget.g;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class AbsHListView extends com.baidu.tieba.horizonalList.widget.g<ListAdapter> implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnTouchModeChangeListener {
    static final Interpolator cPQ = new LinearInterpolator();
    public static final int[] cPS = new int[1];
    Drawable AG;
    public Object cOA;
    Object cOB;
    int cOC;
    protected SparseArrayCompat<Boolean> cOD;
    LongSparseArray<Integer> cOE;
    protected int cOF;
    protected a cOG;
    boolean cOH;
    boolean cOI;
    int cOJ;
    protected Rect cOK;
    protected final k cOL;
    int cOM;
    int cON;
    int cOO;
    int cOP;
    protected Rect cOQ;
    protected int cOR;
    View cOS;
    View cOT;
    protected boolean cOU;
    protected boolean cOV;
    protected int cOW;
    int cOX;
    int cOY;
    int cOZ;
    a.AbstractC0065a cOy;
    protected int cOz;
    private float cPA;
    protected final boolean[] cPB;
    int cPC;
    int cPD;
    private EdgeEffectCompat cPE;
    private EdgeEffectCompat cPF;
    private int cPG;
    private int cPH;
    private boolean cPI;
    private int cPJ;
    private int cPK;
    private g cPL;
    private int cPM;
    private int cPN;
    protected boolean cPO;
    private int cPP;
    private SavedState cPR;
    private float cPT;
    int cPa;
    protected int cPb;
    int cPc;
    int cPd;
    private e cPe;
    protected j cPf;
    protected int cPg;
    protected boolean cPh;
    private h cPi;
    private boolean cPj;
    private Rect cPk;
    protected int cPl;
    private ContextMenu.ContextMenuInfo cPm;
    protected int cPn;
    private int cPo;
    private c cPp;
    private Runnable cPq;
    private b cPr;
    private i cPs;
    private Runnable cPt;
    private int cPu;
    private int cPv;
    private boolean cPw;
    private int cPx;
    private Runnable cPy;
    protected Runnable cPz;
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

    protected abstract void fv(boolean z);

    protected abstract int kA(int i2);

    public abstract void setSelectionInt(int i2);

    public AbsHListView(Context context) {
        super(context);
        this.cOz = 0;
        this.cOF = 0;
        this.cOI = false;
        this.cOJ = -1;
        this.cOK = new Rect();
        this.cOL = new k();
        this.cOM = 0;
        this.cON = 0;
        this.cOO = 0;
        this.cOP = 0;
        this.cOQ = new Rect();
        this.cOR = 0;
        this.cPb = -1;
        this.cPg = 0;
        this.cPj = true;
        this.cPl = -1;
        this.cPm = null;
        this.cPo = -1;
        this.cPx = 0;
        this.cPA = 1.0f;
        this.cPB = new boolean[1];
        this.mActivePointerId = -1;
        this.mDirection = 0;
        apm();
    }

    public AbsHListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, r.c.hlv_absHListViewStyle);
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
        this.cOz = 0;
        this.cOF = 0;
        this.cOI = false;
        this.cOJ = -1;
        this.cOK = new Rect();
        this.cOL = new k();
        this.cOM = 0;
        this.cON = 0;
        this.cOO = 0;
        this.cOP = 0;
        this.cOQ = new Rect();
        this.cOR = 0;
        this.cPb = -1;
        this.cPg = 0;
        this.cPj = true;
        this.cPl = -1;
        this.cPm = null;
        this.cPo = -1;
        this.cPx = 0;
        this.cPA = 1.0f;
        this.cPB = new boolean[1];
        this.mActivePointerId = -1;
        this.mDirection = 0;
        apm();
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, r.l.HListView, i2, 0);
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
        this.cOI = z3;
        setStackFromRight(z2);
        setScrollingCacheEnabled(z);
        setTranscriptMode(i3);
        setCacheColorHint(i4);
        setSmoothScrollbarEnabled(z4);
        setChoiceMode(i5);
    }

    private void apm() {
        setClickable(true);
        setFocusableInTouchMode(true);
        setWillNotDraw(false);
        setAlwaysDrawnWithCacheEnabled(false);
        setScrollingCacheEnabled(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.cPC = viewConfiguration.getScaledOverscrollDistance();
        this.cPD = viewConfiguration.getScaledOverflingDistance();
        this.cOy = com.baidu.tieba.horizonalList.a.a.au(this);
    }

    @Override // android.view.View
    public void setOverScrollMode(int i2) {
        if (i2 != 2) {
            if (this.cPE == null) {
                Context context = getContext();
                this.cPE = new EdgeEffectCompat(context);
                this.cPF = new EdgeEffectCompat(context);
            }
        } else {
            this.cPE = null;
            this.cPF = null;
        }
        super.setOverScrollMode(i2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.horizonalList.widget.g
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            this.cOH = this.mAdapter.hasStableIds();
            if (this.cOz != 0 && this.cOH && this.cOE == null) {
                this.cOE = new LongSparseArray<>();
            }
        }
        if (this.cOD != null) {
            this.cOD.clear();
        }
        if (this.cOE != null) {
            this.cOE.clear();
        }
    }

    public int getCheckedItemCount() {
        return this.cOC;
    }

    public boolean isItemChecked(int i2) {
        if (this.cOz == 0 || this.cOD == null) {
            return false;
        }
        return this.cOD.get(i2, false).booleanValue();
    }

    public int getCheckedItemPosition() {
        if (this.cOz == 1 && this.cOD != null && this.cOD.size() == 1) {
            return this.cOD.keyAt(0);
        }
        return -1;
    }

    public SparseArrayCompat<Boolean> getCheckedItemPositions() {
        if (this.cOz != 0) {
            return this.cOD;
        }
        return null;
    }

    public long[] getCheckedItemIds() {
        if (this.cOz == 0 || this.cOE == null || this.mAdapter == null) {
            return new long[0];
        }
        LongSparseArray<Integer> longSparseArray = this.cOE;
        int size = longSparseArray.size();
        long[] jArr = new long[size];
        for (int i2 = 0; i2 < size; i2++) {
            jArr[i2] = longSparseArray.keyAt(i2);
        }
        return jArr;
    }

    public void clearChoices() {
        if (this.cOD != null) {
            this.cOD.clear();
        }
        if (this.cOE != null) {
            this.cOE.clear();
        }
        this.cOC = 0;
    }

    public void setItemChecked(int i2, boolean z) {
        if (this.cOz != 0) {
            if (Build.VERSION.SDK_INT >= 11 && z && this.cOz == 3 && this.cOA == null) {
                if (this.cOB == null || !((com.baidu.tieba.horizonalList.a.a.b) this.cOB).apl()) {
                    throw new IllegalStateException("AbsListView: attempted to start selection mode for CHOICE_MODE_MULTIPLE_MODAL but no choice mode callback was supplied. Call setMultiChoiceModeListener to set a callback.");
                }
                this.cOA = startActionMode((com.baidu.tieba.horizonalList.a.a.b) this.cOB);
            }
            if (this.cOz == 2 || (Build.VERSION.SDK_INT >= 11 && this.cOz == 3)) {
                boolean booleanValue = this.cOD.get(i2, false).booleanValue();
                this.cOD.put(i2, Boolean.valueOf(z));
                if (this.cOE != null && this.mAdapter.hasStableIds()) {
                    if (z) {
                        this.cOE.put(this.mAdapter.getItemId(i2), Integer.valueOf(i2));
                    } else {
                        this.cOE.delete(this.mAdapter.getItemId(i2));
                    }
                }
                if (booleanValue != z) {
                    if (z) {
                        this.cOC++;
                    } else {
                        this.cOC--;
                    }
                }
                if (this.cOA != null) {
                    ((com.baidu.tieba.horizonalList.a.a.b) this.cOB).onItemCheckedStateChanged((ActionMode) this.cOA, i2, this.mAdapter.getItemId(i2), z);
                }
            } else {
                boolean z2 = this.cOE != null && this.mAdapter.hasStableIds();
                if (z || isItemChecked(i2)) {
                    this.cOD.clear();
                    if (z2) {
                        this.cOE.clear();
                    }
                }
                if (z) {
                    this.cOD.put(i2, true);
                    if (z2) {
                        this.cOE.put(this.mAdapter.getItemId(i2), Integer.valueOf(i2));
                    }
                    this.cOC = 1;
                } else if (this.cOD.size() == 0 || !this.cOD.valueAt(0).booleanValue()) {
                    this.cOC = 0;
                }
            }
            if (!this.mInLayout && !this.cRa) {
                this.afj = true;
                aqb();
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
        if (this.cOz != 0) {
            if (this.cOz == 2 || (Build.VERSION.SDK_INT >= 11 && this.cOz == 3 && this.cOA != null)) {
                boolean z5 = !this.cOD.get(i2, false).booleanValue();
                this.cOD.put(i2, Boolean.valueOf(z5));
                if (this.cOE != null && this.mAdapter.hasStableIds()) {
                    if (z5) {
                        this.cOE.put(this.mAdapter.getItemId(i2), Integer.valueOf(i2));
                    } else {
                        this.cOE.delete(this.mAdapter.getItemId(i2));
                    }
                }
                if (z5) {
                    this.cOC++;
                } else {
                    this.cOC--;
                }
                if (this.cOA != null) {
                    ((com.baidu.tieba.horizonalList.a.a.b) this.cOB).onItemCheckedStateChanged((ActionMode) this.cOA, i2, j2, z5);
                } else {
                    z4 = true;
                }
                z2 = z4;
                z4 = true;
            } else if (this.cOz == 1) {
                if (!this.cOD.get(i2, false).booleanValue()) {
                    this.cOD.clear();
                    this.cOD.put(i2, true);
                    if (this.cOE != null && this.mAdapter.hasStableIds()) {
                        this.cOE.clear();
                        this.cOE.put(this.mAdapter.getItemId(i2), Integer.valueOf(i2));
                    }
                    this.cOC = 1;
                } else if (this.cOD.size() == 0 || !this.cOD.valueAt(0).booleanValue()) {
                    this.cOC = 0;
                }
                z4 = true;
                z2 = true;
            } else {
                z2 = true;
            }
            if (z4) {
                apn();
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

    private void apn() {
        int i2 = this.bAH;
        int childCount = getChildCount();
        boolean z = Build.VERSION.SDK_INT >= 11;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            int i4 = i2 + i3;
            if (childAt instanceof Checkable) {
                ((Checkable) childAt).setChecked(this.cOD.get(i4, false).booleanValue());
            } else if (z) {
                childAt.setActivated(this.cOD.get(i4, false).booleanValue());
            }
        }
    }

    public int getChoiceMode() {
        return this.cOz;
    }

    public void setChoiceMode(int i2) {
        this.cOz = i2;
        if (Build.VERSION.SDK_INT >= 11 && this.cOA != null) {
            if (Build.VERSION.SDK_INT >= 11) {
                ((ActionMode) this.cOA).finish();
            }
            this.cOA = null;
        }
        if (this.cOz != 0) {
            if (this.cOD == null) {
                this.cOD = new SparseArrayCompat<>();
            }
            if (this.cOE == null && this.mAdapter != null && this.mAdapter.hasStableIds()) {
                this.cOE = new LongSparseArray<>();
            }
            if (Build.VERSION.SDK_INT >= 11 && this.cOz == 3) {
                clearChoices();
                setLongClickable(true);
            }
        }
    }

    public void setMultiChoiceModeListener(com.baidu.tieba.horizonalList.a.a.a aVar) {
        if (Build.VERSION.SDK_INT >= 11) {
            if (this.cOB == null) {
                this.cOB = new com.baidu.tieba.horizonalList.a.a.b(this);
            }
            ((com.baidu.tieba.horizonalList.a.a.b) this.cOB).a(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean apo() {
        int childCount = getChildCount();
        if (childCount == 0) {
            return true;
        }
        if (childCount != this.cQS) {
            return false;
        }
        return getChildAt(0).getLeft() >= this.cOQ.left && getChildAt(childCount + (-1)).getRight() <= getWidth() - this.cOQ.right;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public int getHorizontalScrollbarHeight() {
        return super.getHorizontalScrollbarHeight();
    }

    public void setSmoothScrollbarEnabled(boolean z) {
        this.cPj = z;
    }

    public void setOnScrollListener(h hVar) {
        this.cPi = hVar;
        app();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void app() {
        if (this.cPi != null) {
            this.cPi.a(this, this.bAH, getChildCount(), this.cQS);
        }
        onScrollChanged(0, 0, 0, 0);
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEvent(int i2) {
        if (i2 == 4096) {
            int firstVisiblePosition = getFirstVisiblePosition();
            int lastVisiblePosition = getLastVisiblePosition();
            if (this.cPM != firstVisiblePosition || this.cPN != lastVisiblePosition) {
                this.cPM = firstVisiblePosition;
                this.cPN = lastVisiblePosition;
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
            apD();
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

    private void apq() {
        setSelector(getResources().getDrawable(17301602));
    }

    public void setStackFromRight(boolean z) {
        if (this.cPh != z) {
            this.cPh = z;
            apr();
        }
    }

    void apr() {
        if (getChildCount() > 0) {
            aps();
            requestLayout();
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new com.baidu.tieba.horizonalList.widget.f();
        String cQA;
        boolean cQB;
        int cQC;
        SparseArrayCompat<Boolean> cQD;
        LongSparseArray<Integer> cQE;
        long cQx;
        long cQy;
        int cQz;
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
            this.cQx = parcel.readLong();
            this.cQy = parcel.readLong();
            this.cQz = parcel.readInt();
            this.position = parcel.readInt();
            this.width = parcel.readInt();
            this.cQA = parcel.readString();
            this.cQB = parcel.readByte() != 0;
            this.cQC = parcel.readInt();
            this.cQD = j(parcel);
            this.cQE = i(parcel);
        }

        private LongSparseArray<Integer> i(Parcel parcel) {
            int readInt = parcel.readInt();
            if (readInt <= 0) {
                return null;
            }
            LongSparseArray<Integer> longSparseArray = new LongSparseArray<>(readInt);
            a(longSparseArray, parcel, readInt);
            return longSparseArray;
        }

        private SparseArrayCompat<Boolean> j(Parcel parcel) {
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
            parcel.writeLong(this.cQx);
            parcel.writeLong(this.cQy);
            parcel.writeInt(this.cQz);
            parcel.writeInt(this.position);
            parcel.writeInt(this.width);
            parcel.writeString(this.cQA);
            parcel.writeByte((byte) (this.cQB ? 1 : 0));
            parcel.writeInt(this.cQC);
            a(this.cQD, parcel);
            a(this.cQE, parcel);
        }

        public String toString() {
            return "AbsListView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " selectedId=" + this.cQx + " firstId=" + this.cQy + " viewLeft=" + this.cQz + " position=" + this.position + " width=" + this.width + " filter=" + this.cQA + " checkState=" + this.cQD + "}";
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        boolean z = true;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.cPR != null) {
            savedState.cQx = this.cPR.cQx;
            savedState.cQy = this.cPR.cQy;
            savedState.cQz = this.cPR.cQz;
            savedState.position = this.cPR.position;
            savedState.width = this.cPR.width;
            savedState.cQA = this.cPR.cQA;
            savedState.cQB = this.cPR.cQB;
            savedState.cQC = this.cPR.cQC;
            savedState.cQD = this.cPR.cQD;
            savedState.cQE = this.cPR.cQE;
            return savedState;
        }
        boolean z2 = getChildCount() > 0 && this.cQS > 0;
        long selectedItemId = getSelectedItemId();
        savedState.cQx = selectedItemId;
        savedState.width = getWidth();
        if (selectedItemId >= 0) {
            savedState.cQz = this.cPg;
            savedState.position = getSelectedItemPosition();
            savedState.cQy = -1L;
        } else if (z2 && this.bAH > 0) {
            savedState.cQz = getChildAt(0).getLeft();
            int i2 = this.bAH;
            if (i2 >= this.cQS) {
                i2 = this.cQS - 1;
            }
            savedState.position = i2;
            savedState.cQy = this.mAdapter.getItemId(i2);
        } else {
            savedState.cQz = 0;
            savedState.cQy = -1L;
            savedState.position = 0;
        }
        savedState.cQA = null;
        savedState.cQB = (Build.VERSION.SDK_INT < 11 || this.cOz != 3 || this.cOA == null) ? false : false;
        if (this.cOD != null) {
            try {
                savedState.cQD = this.cOD.m1clone();
            } catch (NoSuchMethodError e2) {
                e2.printStackTrace();
                savedState.cQD = new SparseArrayCompat<>();
            }
        }
        if (this.cOE != null) {
            LongSparseArray<Integer> longSparseArray = new LongSparseArray<>();
            int size = this.cOE.size();
            for (int i3 = 0; i3 < size; i3++) {
                longSparseArray.put(this.cOE.keyAt(i3), this.cOE.valueAt(i3));
            }
            savedState.cQE = longSparseArray;
        }
        savedState.cQC = this.cOC;
        return savedState;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.afj = true;
        this.cQJ = savedState.width;
        if (savedState.cQx >= 0) {
            this.cQK = true;
            this.cPR = savedState;
            this.cQI = savedState.cQx;
            this.cQH = savedState.position;
            this.cQG = savedState.cQz;
            this.cQL = 0;
        } else if (savedState.cQy >= 0) {
            setSelectedPositionInt(-1);
            setNextSelectedPositionInt(-1);
            this.cOJ = -1;
            this.cQK = true;
            this.cPR = savedState;
            this.cQI = savedState.cQy;
            this.cQH = savedState.position;
            this.cQG = savedState.cQz;
            this.cQL = 1;
        }
        if (savedState.cQD != null) {
            this.cOD = savedState.cQD;
        }
        if (savedState.cQE != null) {
            this.cOE = savedState.cQE;
        }
        this.cOC = savedState.cQC;
        if (Build.VERSION.SDK_INT >= 11 && savedState.cQB && this.cOz == 3 && this.cOB != null) {
            this.cOA = startActionMode((com.baidu.tieba.horizonalList.a.a.b) this.cOB);
        }
        requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onFocusChanged(boolean z, int i2, Rect rect) {
        super.onFocusChanged(z, i2, rect);
        if (z && this.cxH < 0 && !isInTouchMode()) {
            if (!this.cPO && this.mAdapter != null) {
                this.afj = true;
                this.cQT = this.cQS;
                this.cQS = this.mAdapter.getCount();
            }
            apH();
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (!this.cRa && !this.mInLayout) {
            super.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aps() {
        removeAllViewsInLayout();
        this.bAH = 0;
        this.afj = false;
        this.cPz = null;
        this.cQK = false;
        this.cPR = null;
        this.cQV = -1;
        this.cQW = Long.MIN_VALUE;
        setSelectedPositionInt(-1);
        setNextSelectedPositionInt(-1);
        this.cPg = 0;
        this.cOJ = -1;
        this.cOK.setEmpty();
        invalidate();
    }

    @Override // android.view.View
    protected int computeHorizontalScrollExtent() {
        int childCount = getChildCount();
        if (childCount > 0) {
            if (this.cPj) {
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
        int i3 = this.bAH;
        int childCount = getChildCount();
        if (i3 < 0 || childCount <= 0) {
            return 0;
        }
        if (this.cPj) {
            View childAt = getChildAt(0);
            int left = childAt.getLeft();
            int width = childAt.getWidth();
            if (width > 0) {
                return Math.max(((i3 * 100) - ((left * 100) / width)) + ((int) ((getScrollX() / getWidth()) * this.cQS * 100.0f)), 0);
            }
            return 0;
        }
        int i4 = this.cQS;
        if (i3 != 0) {
            i2 = i3 + childCount == i4 ? i4 : (childCount / 2) + i3;
        }
        return (int) (((i2 / i4) * childCount) + i3);
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        if (this.cPj) {
            int max = Math.max(this.cQS * 100, 0);
            if (getScrollX() != 0) {
                return max + Math.abs((int) ((getScrollX() / getWidth()) * this.cQS * 100.0f));
            }
            return max;
        }
        return this.cQS;
    }

    @Override // android.view.View
    protected float getLeftFadingEdgeStrength() {
        int childCount = getChildCount();
        float leftFadingEdgeStrength = super.getLeftFadingEdgeStrength();
        if (childCount != 0) {
            if (this.bAH > 0) {
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
            if ((this.bAH + childCount) - 1 < this.cQS - 1) {
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
        if (this.AG == null) {
            apq();
        }
        Rect rect = this.cOQ;
        rect.left = this.cOM + getPaddingLeft();
        rect.top = this.cON + getPaddingTop();
        rect.right = this.cOO + getPaddingRight();
        rect.bottom = this.cOP + getPaddingBottom();
        if (this.cPu == 1) {
            int childCount = getChildCount();
            int width = getWidth() - getPaddingRight();
            View childAt = getChildAt(childCount - 1);
            this.cPI = childCount + this.bAH >= this.cPP && (childAt != null ? childAt.getRight() : width) <= width;
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
            this.cOL.apN();
        }
        layoutChildren();
        this.mInLayout = false;
        this.cPn = (i4 - i2) / 3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void layoutChildren() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void apt() {
        boolean z = true;
        if (this.cOS != null) {
            boolean z2 = this.bAH > 0;
            if (!z2 && getChildCount() > 0) {
                z2 = getChildAt(0).getLeft() < this.cOQ.left;
            }
            this.cOS.setVisibility(z2 ? 0 : 4);
        }
        if (this.cOT != null) {
            int childCount = getChildCount();
            boolean z3 = this.bAH + childCount < this.cQS;
            if (z3 || childCount <= 0) {
                z = z3;
            } else if (getChildAt(childCount - 1).getRight() <= getRight() - this.cOQ.right) {
                z = false;
            }
            this.cOT.setVisibility(z ? 0 : 4);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.g
    @ViewDebug.ExportedProperty
    public View getSelectedView() {
        if (this.cQS <= 0 || this.cxH < 0) {
            return null;
        }
        return getChildAt(this.cxH - this.bAH);
    }

    public int getListPaddingTop() {
        return this.cOQ.top;
    }

    public int getListPaddingBottom() {
        return this.cOQ.bottom;
    }

    public int getListPaddingLeft() {
        return this.cOQ.left;
    }

    public int getListPaddingRight() {
        return this.cOQ.right;
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
        View kI = this.cOL.kI(i2);
        if (kI == null) {
            View kJ = this.cOL.kJ(i2);
            if (kJ != null) {
                view = this.mAdapter.getView(i2, kJ, this);
                if (view != kJ) {
                    this.cOL.t(kJ, i2);
                    if (this.cPv != 0) {
                        view.setDrawingCacheBackgroundColor(this.cPv);
                        kI = view;
                    }
                } else {
                    zArr[0] = true;
                    view.onFinishTemporaryDetach();
                    kI = view;
                }
                if (this.cOH) {
                    ViewGroup.LayoutParams layoutParams = kI.getLayoutParams();
                    if (layoutParams == null) {
                        fVar = (f) generateDefaultLayoutParams();
                    } else if (!checkLayoutParams(layoutParams)) {
                        fVar = (f) generateLayoutParams(layoutParams);
                    } else {
                        fVar = (f) layoutParams;
                    }
                    fVar.cQf = this.mAdapter.getItemId(i2);
                    kI.setLayoutParams(fVar);
                }
                if (this.cQU.isEnabled() && this.cPL == null) {
                    this.cPL = new g();
                }
            } else {
                view = this.mAdapter.getView(i2, null, this);
                if (this.cPv != 0) {
                    view.setDrawingCacheBackgroundColor(this.cPv);
                }
            }
            kI = view;
            if (this.cOH) {
            }
            if (this.cQU.isEnabled()) {
                this.cPL = new g();
            }
        }
        return kI;
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
            this.cOJ = i2;
        }
        Rect rect = this.cOK;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        if (view instanceof m) {
            ((m) view).adjustListItemSelectionBounds(rect);
        }
        k(rect.left, rect.top, rect.right, rect.bottom);
        boolean z = this.cPw;
        if (view.isEnabled() != z) {
            this.cPw = !z;
            if (getSelectedItemPosition() != -1) {
                refreshDrawableState();
            }
        }
    }

    private void k(int i2, int i3, int i4, int i5) {
        this.cOK.set(i2 - this.cOM, i3 - this.cON, this.cOO + i4, this.cOP + i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        boolean z = this.cOI;
        if (!z) {
            s(canvas);
        }
        super.dispatchDraw(canvas);
        if (z) {
            s(canvas);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        if (getChildCount() > 0) {
            this.afj = true;
            aqb();
        }
    }

    boolean apu() {
        switch (this.cPb) {
            case 1:
            case 2:
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean apv() {
        return (hasFocus() && !isInTouchMode()) || apu();
    }

    private void s(Canvas canvas) {
        if (!this.cOK.isEmpty()) {
            Drawable drawable = this.AG;
            drawable.setBounds(this.cOK);
            drawable.draw(canvas);
        }
    }

    public void setDrawSelectorOnTop(boolean z) {
        this.cOI = z;
    }

    public void setSelector(int i2) {
        setSelector(getResources().getDrawable(i2));
    }

    public void setSelector(Drawable drawable) {
        if (this.AG != null) {
            this.AG.setCallback(null);
            unscheduleDrawable(this.AG);
        }
        this.AG = drawable;
        Rect rect = new Rect();
        drawable.getPadding(rect);
        this.cOM = rect.left;
        this.cON = rect.top;
        this.cOO = rect.right;
        this.cOP = rect.bottom;
        drawable.setCallback(this);
        apx();
    }

    public Drawable getSelector() {
        return this.AG;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void apw() {
        if (isEnabled() && isClickable()) {
            Drawable drawable = this.AG;
            Rect rect = this.cOK;
            if (drawable != null) {
                if ((isFocused() || apu()) && !rect.isEmpty()) {
                    View childAt = getChildAt(this.cxH - this.bAH);
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
                    if (isLongClickable && !this.afj) {
                        if (this.cPr == null) {
                            this.cPr = new b(this, null);
                        }
                        this.cPr.apS();
                        postDelayed(this.cPr, ViewConfiguration.getLongPressTimeout());
                    }
                }
            }
        }
    }

    void apx() {
        if (this.AG != null) {
            if (apv()) {
                this.AG.setState(getDrawableState());
            } else {
                this.AG.setState(cPS);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        apx();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i2) {
        if (this.cPw) {
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
        return this.AG == drawable || super.verifyDrawable(drawable);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.AG != null) {
            this.AG.jumpToCurrentState();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnTouchModeChangeListener(this);
        if (this.mAdapter != null && this.cOG == null) {
            this.cOG = new a();
            this.mAdapter.registerDataSetObserver(this.cOG);
            this.afj = true;
            this.cQT = this.cQS;
            this.cQS = this.mAdapter.getCount();
        }
        this.cPO = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.g, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.cOL.clear();
        getViewTreeObserver().removeOnTouchModeChangeListener(this);
        if (this.mAdapter != null && this.cOG != null) {
            this.mAdapter.unregisterDataSetObserver(this.cOG);
            this.cOG = null;
        }
        if (this.cPe != null) {
            removeCallbacks(this.cPe);
        }
        if (this.cPf != null) {
            this.cPf.stop();
        }
        if (this.cPy != null) {
            removeCallbacks(this.cPy);
        }
        if (this.cPs != null) {
            removeCallbacks(this.cPs);
        }
        if (this.cPt != null) {
            removeCallbacks(this.cPt);
            this.cPt = null;
        }
        this.cPO = false;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        int i2 = isInTouchMode() ? 0 : 1;
        if (!z) {
            setChildrenDrawingCacheEnabled(false);
            if (this.cPe != null) {
                removeCallbacks(this.cPe);
                this.cPe.apL();
                if (this.cPf != null) {
                    this.cPf.stop();
                }
                if (getScrollX() != 0) {
                    this.cOy.setScrollX(0);
                    apJ();
                    invalidate();
                }
            }
            if (i2 == 1) {
                this.cPl = this.cxH;
            }
        } else if (i2 != this.cPo && this.cPo != -1) {
            if (i2 == 1) {
                apH();
            } else {
                apE();
                this.cOF = 0;
                layoutChildren();
            }
        }
        this.cPo = i2;
    }

    ContextMenu.ContextMenuInfo b(View view, int i2, long j2) {
        return new g.a(view, i2, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class n {
        private int cQF;

        private n() {
        }

        /* synthetic */ n(AbsHListView absHListView, n nVar) {
            this();
        }

        public void apS() {
            this.cQF = AbsHListView.this.getWindowAttachCount();
        }

        public boolean apT() {
            return AbsHListView.this.hasWindowFocus() && AbsHListView.this.getWindowAttachCount() == this.cQF;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class i extends n implements Runnable {
        int cQg;

        private i() {
            super(AbsHListView.this, null);
        }

        /* synthetic */ i(AbsHListView absHListView, i iVar) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            View childAt;
            if (!AbsHListView.this.afj) {
                ListAdapter listAdapter = AbsHListView.this.mAdapter;
                int i = this.cQg;
                if (listAdapter != null && AbsHListView.this.cQS > 0 && i != -1 && i < listAdapter.getCount() && apT() && (childAt = AbsHListView.this.getChildAt(i - AbsHListView.this.bAH)) != null) {
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
            View childAt = AbsHListView.this.getChildAt(AbsHListView.this.cOW - AbsHListView.this.bAH);
            if (childAt != null) {
                if ((!apT() || AbsHListView.this.afj) ? false : AbsHListView.this.c(childAt, AbsHListView.this.cOW, AbsHListView.this.mAdapter.getItemId(AbsHListView.this.cOW))) {
                    AbsHListView.this.cPb = -1;
                    AbsHListView.this.setPressed(false);
                    childAt.setPressed(false);
                    return;
                }
                AbsHListView.this.cPb = 2;
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
            if (AbsHListView.this.isPressed() && AbsHListView.this.cxH >= 0) {
                View childAt = AbsHListView.this.getChildAt(AbsHListView.this.cxH - AbsHListView.this.bAH);
                if (!AbsHListView.this.afj) {
                    if (apT() ? AbsHListView.this.c(childAt, AbsHListView.this.cxH, AbsHListView.this.cQR) : false) {
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
        if (Build.VERSION.SDK_INT >= 11 && this.cOz == 3) {
            if (this.cOA == null) {
                ActionMode startActionMode = startActionMode((com.baidu.tieba.horizonalList.a.a.b) this.cOB);
                this.cOA = startActionMode;
                if (startActionMode != null) {
                    setItemChecked(i2, true);
                    performHapticFeedback(0);
                }
            }
            return true;
        }
        boolean b2 = this.cQO != null ? this.cQO.b(this, view, i2, j2) : false;
        if (!b2) {
            this.cPm = b(view, i2, j2);
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
        return this.cPm;
    }

    public boolean b(float f2, float f3, int i2) {
        int pointToPosition = pointToPosition((int) f2, (int) f3);
        if (pointToPosition != -1) {
            long itemId = this.mAdapter.getItemId(pointToPosition);
            View childAt = getChildAt(pointToPosition - this.bAH);
            if (childAt != null) {
                this.cPm = b(childAt, pointToPosition, itemId);
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
            boolean b2 = this.cQO != null ? this.cQO.b(this, view, positionForView, itemId) : false;
            if (!b2) {
                this.cPm = b(getChildAt(positionForView - this.bAH), positionForView, itemId);
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
                if (isClickable() && isPressed() && this.cxH >= 0 && this.mAdapter != null && this.cxH < this.mAdapter.getCount()) {
                    View childAt = getChildAt(this.cxH - this.bAH);
                    if (childAt != null) {
                        performItemClick(childAt, this.cxH, this.cQR);
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
        Rect rect = this.cPk;
        if (rect == null) {
            this.cPk = new Rect();
            rect = this.cPk;
        }
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt.getVisibility() == 0) {
                childAt.getHitRect(rect);
                if (rect.contains(i2, i3)) {
                    return this.bAH + childCount;
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
            if (AbsHListView.this.cPb == 0) {
                AbsHListView.this.cPb = 1;
                View childAt = AbsHListView.this.getChildAt(AbsHListView.this.cOW - AbsHListView.this.bAH);
                if (childAt != null && !childAt.hasFocusable()) {
                    AbsHListView.this.cOF = 0;
                    if (!AbsHListView.this.afj) {
                        childAt.setPressed(true);
                        AbsHListView.this.setPressed(true);
                        AbsHListView.this.layoutChildren();
                        AbsHListView.this.b(AbsHListView.this.cOW, childAt);
                        AbsHListView.this.refreshDrawableState();
                        int longPressTimeout = ViewConfiguration.getLongPressTimeout();
                        boolean isLongClickable = AbsHListView.this.isLongClickable();
                        if (AbsHListView.this.AG != null && (current = AbsHListView.this.AG.getCurrent()) != null && (current instanceof TransitionDrawable)) {
                            if (isLongClickable) {
                                ((TransitionDrawable) current).startTransition(longPressTimeout);
                            } else {
                                ((TransitionDrawable) current).resetTransition();
                            }
                        }
                        if (isLongClickable) {
                            if (AbsHListView.this.cPp == null) {
                                AbsHListView.this.cPp = new c(AbsHListView.this, null);
                            }
                            AbsHListView.this.cPp.apS();
                            AbsHListView.this.postDelayed(AbsHListView.this.cPp, longPressTimeout);
                            return;
                        }
                        AbsHListView.this.cPb = 2;
                        return;
                    }
                    AbsHListView.this.cPb = 2;
                }
            }
        }
    }

    private boolean kw(int i2) {
        int i3 = i2 - this.cOZ;
        int abs = Math.abs(i3);
        boolean z = getScrollX() != 0;
        if (z || abs > this.mTouchSlop) {
            apC();
            if (z) {
                this.cPb = 5;
                this.cPd = 0;
            } else {
                this.cPb = 3;
                this.cPd = i3 > 0 ? this.mTouchSlop : -this.mTouchSlop;
            }
            Handler handler = getHandler();
            if (handler != null) {
                handler.removeCallbacks(this.cPp);
            }
            setPressed(false);
            View childAt = getChildAt(this.cOW - this.bAH);
            if (childAt != null) {
                childAt.setPressed(false);
            }
            ky(1);
            ViewParent parent = getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            kx(i2);
            return true;
        }
        return false;
    }

    private void kx(int i2) {
        int i3;
        int childCount;
        ViewParent parent;
        int i4 = i2 - this.cOZ;
        int i5 = i4 - this.cPd;
        int i6 = this.cPc != Integer.MIN_VALUE ? i2 - this.cPc : i5;
        if (this.cPb == 3) {
            if (i2 != this.cPc) {
                if (Math.abs(i4) > this.mTouchSlop && (parent = getParent()) != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
                if (this.cOW >= 0) {
                    childCount = this.cOW - this.bAH;
                } else {
                    childCount = getChildCount() / 2;
                }
                View childAt = getChildAt(childCount);
                int left = childAt != null ? childAt.getLeft() : 0;
                boolean aC = i6 != 0 ? aC(i5, i6) : false;
                View childAt2 = getChildAt(childCount);
                if (childAt2 != null) {
                    int left2 = childAt2.getLeft();
                    if (aC) {
                        int i7 = (-i6) - (left2 - left);
                        overScrollBy(i7, 0, getScrollX(), 0, 0, 0, this.cPC, 0, true);
                        if (Math.abs(this.cPC) == Math.abs(getScrollX()) && this.mVelocityTracker != null) {
                            this.mVelocityTracker.clear();
                        }
                        int overScrollMode = getOverScrollMode();
                        if (overScrollMode == 0 || (overScrollMode == 1 && !apo())) {
                            this.mDirection = 0;
                            this.cPb = 5;
                            if (i4 > 0) {
                                this.cPE.onPull(i7 / getWidth());
                                if (!this.cPF.isFinished()) {
                                    this.cPF.onRelease();
                                }
                                invalidate();
                            } else if (i4 < 0) {
                                this.cPF.onPull(i7 / getWidth());
                                if (!this.cPE.isFinished()) {
                                    this.cPE.onRelease();
                                }
                                invalidate();
                            }
                        }
                    }
                    this.cOZ = i2;
                }
                this.cPc = i2;
            }
        } else if (this.cPb == 5 && i2 != this.cPc) {
            int scrollX = getScrollX();
            int i8 = scrollX - i6;
            int i9 = i2 > this.cPc ? 1 : -1;
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
                overScrollBy(i10, 0, getScrollX(), 0, 0, 0, this.cPC, 0, true);
                int overScrollMode2 = getOverScrollMode();
                if (overScrollMode2 == 0 || (overScrollMode2 == 1 && !apo())) {
                    if (i4 > 0) {
                        this.cPE.onPull(i10 / getWidth());
                        if (!this.cPF.isFinished()) {
                            this.cPF.onRelease();
                        }
                        invalidate();
                    } else if (i4 < 0) {
                        this.cPF.onPull(i10 / getWidth());
                        if (!this.cPE.isFinished()) {
                            this.cPE.onRelease();
                        }
                        invalidate();
                    }
                }
            }
            if (i3 != 0) {
                if (getScrollX() != 0) {
                    this.cOy.setScrollX(0);
                    apy();
                }
                aC(i3, i3);
                this.cPb = 3;
                int kB = kB(i2);
                this.cPd = 0;
                View childAt3 = getChildAt(kB - this.bAH);
                this.cOX = childAt3 != null ? childAt3.getLeft() : 0;
                this.cOZ = i2;
                this.cOW = kB;
            }
            this.cPc = i2;
            this.mDirection = i9;
        }
    }

    protected void apy() {
        if (this.cOy.isHardwareAccelerated() && (getParent() instanceof View)) {
            ((View) getParent()).invalidate();
        }
    }

    @Override // android.view.ViewTreeObserver.OnTouchModeChangeListener
    public void onTouchModeChanged(boolean z) {
        if (z) {
            apE();
            if (getWidth() > 0 && getChildCount() > 0) {
                layoutChildren();
            }
            apx();
            return;
        }
        int i2 = this.cPb;
        if (i2 == 5 || i2 == 6) {
            if (this.cPe != null) {
                this.cPe.apL();
            }
            if (this.cPf != null) {
                this.cPf.stop();
            }
            if (getScrollX() != 0) {
                this.cOy.setScrollX(0);
                apJ();
                invalidate();
            }
        }
    }

    protected boolean k(MotionEvent motionEvent) {
        return Build.VERSION.SDK_INT >= 14 && (motionEvent.getButtonState() & 2) != 0 && b(motionEvent.getX(), motionEvent.getY(), motionEvent.getMetaState());
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
        if (this.cPf != null) {
            this.cPf.stop();
        }
        if (this.cPO) {
            int action = motionEvent.getAction();
            apA();
            this.mVelocityTracker.addMovement(motionEvent);
            switch (action & MotionEventCompat.ACTION_MASK) {
                case 0:
                    switch (this.cPb) {
                        case 6:
                            this.cPe.apL();
                            if (this.cPf != null) {
                                this.cPf.stop();
                            }
                            this.cPb = 5;
                            this.cPa = (int) motionEvent.getY();
                            int x = (int) motionEvent.getX();
                            this.cPc = x;
                            this.cOZ = x;
                            this.cPd = 0;
                            this.mActivePointerId = motionEvent.getPointerId(0);
                            this.mDirection = 0;
                            break;
                        default:
                            this.mActivePointerId = motionEvent.getPointerId(0);
                            int x2 = (int) motionEvent.getX();
                            int y = (int) motionEvent.getY();
                            int pointToPosition = pointToPosition(x2, y);
                            if (!this.afj) {
                                if (this.cPb != 4 && pointToPosition >= 0 && getAdapter().isEnabled(pointToPosition)) {
                                    this.cPb = 0;
                                    if (this.cPq == null) {
                                        this.cPq = new d();
                                    }
                                    postDelayed(this.cPq, ViewConfiguration.getTapTimeout());
                                    i2 = pointToPosition;
                                } else if (this.cPb == 4) {
                                    apC();
                                    this.cPb = 3;
                                    this.cPd = 0;
                                    i2 = kA(x2);
                                    this.cPe.apM();
                                }
                                if (i2 >= 0) {
                                    this.cOX = getChildAt(i2 - this.bAH).getLeft();
                                }
                                this.cOZ = x2;
                                this.cPa = y;
                                this.cOW = i2;
                                this.cPc = ExploreByTouchHelper.INVALID_ID;
                                break;
                            }
                            i2 = pointToPosition;
                            if (i2 >= 0) {
                            }
                            this.cOZ = x2;
                            this.cPa = y;
                            this.cOW = i2;
                            this.cPc = ExploreByTouchHelper.INVALID_ID;
                    }
                    if (k(motionEvent) && this.cPb == 0) {
                        removeCallbacks(this.cPq);
                        break;
                    }
                    break;
                case 1:
                    switch (this.cPb) {
                        case 0:
                        case 1:
                        case 2:
                            int i3 = this.cOW;
                            View childAt = getChildAt(i3 - this.bAH);
                            float x3 = motionEvent.getX();
                            boolean z = x3 > ((float) this.cOQ.left) && x3 < ((float) (getWidth() - this.cOQ.right));
                            if (childAt != null && !childAt.hasFocusable() && z) {
                                if (this.cPb != 0) {
                                    childAt.setPressed(false);
                                }
                                if (this.cPs == null) {
                                    this.cPs = new i(this, null);
                                }
                                i iVar = this.cPs;
                                iVar.cQg = i3;
                                iVar.apS();
                                this.cPl = i3;
                                if (this.cPb == 0 || this.cPb == 1) {
                                    Handler handler = getHandler();
                                    if (handler != null) {
                                        handler.removeCallbacks(this.cPb == 0 ? this.cPq : this.cPp);
                                    }
                                    this.cOF = 0;
                                    if (!this.afj && this.mAdapter.isEnabled(i3)) {
                                        this.cPb = 1;
                                        setSelectedPositionInt(this.cOW);
                                        layoutChildren();
                                        childAt.setPressed(true);
                                        b(this.cOW, childAt);
                                        setPressed(true);
                                        if (this.AG != null && (current = this.AG.getCurrent()) != null && (current instanceof TransitionDrawable)) {
                                            ((TransitionDrawable) current).resetTransition();
                                        }
                                        if (this.cPt != null) {
                                            removeCallbacks(this.cPt);
                                        }
                                        this.cPt = new com.baidu.tieba.horizonalList.widget.a(this, childAt, iVar);
                                        postDelayed(this.cPt, ViewConfiguration.getPressedStateDuration());
                                    } else {
                                        this.cPb = -1;
                                        apx();
                                    }
                                    return true;
                                } else if (!this.afj && this.mAdapter.isEnabled(i3)) {
                                    iVar.run();
                                }
                            }
                            this.cPb = -1;
                            apx();
                            break;
                        case 3:
                            int childCount = getChildCount();
                            if (childCount > 0) {
                                int left = getChildAt(0).getLeft();
                                int right = getChildAt(childCount - 1).getRight();
                                int i4 = this.cOQ.left;
                                int width = getWidth() - this.cOQ.right;
                                if (this.bAH == 0 && left >= i4 && this.bAH + childCount < this.cQS && right <= getWidth() - width) {
                                    this.cPb = -1;
                                    ky(0);
                                    break;
                                } else {
                                    VelocityTracker velocityTracker = this.mVelocityTracker;
                                    velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                                    int xVelocity = (int) (velocityTracker.getXVelocity(this.mActivePointerId) * this.cPA);
                                    if (Math.abs(xVelocity) > this.mMinimumVelocity && ((this.bAH != 0 || left != i4 - this.cPC) && (childCount + this.bAH != this.cQS || right != this.cPC + width))) {
                                        if (this.cPe == null) {
                                            this.cPe = new e();
                                        }
                                        ky(2);
                                        this.cPe.kC(-xVelocity);
                                        break;
                                    } else {
                                        this.cPb = -1;
                                        ky(0);
                                        if (this.cPe != null) {
                                            this.cPe.apL();
                                        }
                                        if (this.cPf != null) {
                                            this.cPf.stop();
                                            break;
                                        }
                                    }
                                }
                            } else {
                                this.cPb = -1;
                                ky(0);
                                break;
                            }
                            break;
                        case 5:
                            if (this.cPe == null) {
                                this.cPe = new e();
                            }
                            VelocityTracker velocityTracker2 = this.mVelocityTracker;
                            velocityTracker2.computeCurrentVelocity(1000, this.mMaximumVelocity);
                            int xVelocity2 = (int) velocityTracker2.getXVelocity(this.mActivePointerId);
                            ky(2);
                            if (Math.abs(xVelocity2) > this.mMinimumVelocity) {
                                this.cPe.kD(-xVelocity2);
                                break;
                            } else {
                                this.cPe.apK();
                                break;
                            }
                    }
                    setPressed(false);
                    if (this.cPE != null) {
                        this.cPE.onRelease();
                        this.cPF.onRelease();
                    }
                    invalidate();
                    Handler handler2 = getHandler();
                    if (handler2 != null) {
                        handler2.removeCallbacks(this.cPp);
                    }
                    apB();
                    this.mActivePointerId = -1;
                    break;
                case 2:
                    int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                    if (findPointerIndex == -1) {
                        this.mActivePointerId = motionEvent.getPointerId(0);
                        findPointerIndex = 0;
                    }
                    int x4 = (int) motionEvent.getX(findPointerIndex);
                    if (this.afj) {
                        layoutChildren();
                    }
                    switch (this.cPb) {
                        case 0:
                        case 1:
                        case 2:
                            kw(x4);
                            break;
                        case 3:
                        case 5:
                            kx(x4);
                            break;
                    }
                case 3:
                    switch (this.cPb) {
                        case 5:
                            if (this.cPe == null) {
                                this.cPe = new e();
                            }
                            this.cPe.apK();
                            break;
                        case 6:
                            break;
                        default:
                            this.cPb = -1;
                            setPressed(false);
                            View childAt2 = getChildAt(this.cOW - this.bAH);
                            if (childAt2 != null) {
                                childAt2.setPressed(false);
                            }
                            apD();
                            Handler handler3 = getHandler();
                            if (handler3 != null) {
                                handler3.removeCallbacks(this.cPp);
                            }
                            apB();
                            break;
                    }
                    if (this.cPE != null) {
                        this.cPE.onRelease();
                        this.cPF.onRelease();
                    }
                    this.mActivePointerId = -1;
                    break;
                case 5:
                    int actionIndex = motionEvent.getActionIndex();
                    int pointerId = motionEvent.getPointerId(actionIndex);
                    int x5 = (int) motionEvent.getX(actionIndex);
                    int y2 = (int) motionEvent.getY(actionIndex);
                    this.cPd = 0;
                    this.mActivePointerId = pointerId;
                    this.cOZ = x5;
                    this.cPa = y2;
                    int pointToPosition2 = pointToPosition(x5, y2);
                    if (pointToPosition2 >= 0) {
                        this.cOX = getChildAt(pointToPosition2 - this.bAH).getLeft();
                        this.cOW = pointToPosition2;
                    }
                    this.cPc = x5;
                    break;
                case 6:
                    onSecondaryPointerUp(motionEvent);
                    int i5 = this.cOZ;
                    int pointToPosition3 = pointToPosition(i5, this.cPa);
                    if (pointToPosition3 >= 0) {
                        this.cOX = getChildAt(pointToPosition3 - this.bAH).getLeft();
                        this.cOW = pointToPosition3;
                    }
                    this.cPc = i5;
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
            this.cOy.setScrollX(i2);
            apy();
            awakenScrollBars();
        }
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) != 0) {
            switch (motionEvent.getAction()) {
                case 8:
                    if (this.cPb == -1) {
                        float axisValue = motionEvent.getAxisValue(10);
                        if (axisValue != 0.0f) {
                            int horizontalScrollFactor = (int) (axisValue * getHorizontalScrollFactor());
                            if (!aC(horizontalScrollFactor, horizontalScrollFactor)) {
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
        if (this.cPT == 0.0f) {
            TypedValue typedValue = new TypedValue();
            if (getContext().getTheme().resolveAttribute(r.c.hlv_listPreferredItemWidth, typedValue, true)) {
                this.cPT = typedValue.getDimension(getContext().getResources().getDisplayMetrics());
            }
        }
        return this.cPT;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.cPE != null) {
            int scrollX = getScrollX();
            if (!this.cPE.isFinished()) {
                int save = canvas.save();
                int i2 = this.cOQ.top + this.cPJ;
                int height = (getHeight() - i2) - (this.cOQ.bottom + this.cPK);
                int min = Math.min(0, this.cPG + scrollX);
                canvas.rotate(-90.0f);
                canvas.translate(i2 + (-getHeight()), min);
                this.cPE.setSize(height, height);
                if (this.cPE.draw(canvas)) {
                    invalidate();
                }
                canvas.restoreToCount(save);
            }
            if (!this.cPF.isFinished()) {
                int save2 = canvas.save();
                int i3 = this.cOQ.left + this.cPJ;
                int height2 = (getHeight() - i3) - (this.cOQ.right + this.cPK);
                int max = Math.max(getWidth(), scrollX + this.cPH);
                canvas.rotate(90.0f);
                canvas.translate(-i3, -max);
                this.cPF.setSize(height2, height2);
                if (this.cPF.draw(canvas)) {
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
        if (this.cPf != null) {
            this.cPf.stop();
        }
        if (this.cPO) {
            switch (action & MotionEventCompat.ACTION_MASK) {
                case 0:
                    int i2 = this.cPb;
                    if (i2 == 6 || i2 == 5) {
                        this.cPd = 0;
                        return true;
                    }
                    int x = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();
                    this.mActivePointerId = motionEvent.getPointerId(0);
                    int kA = kA(x);
                    if (i2 != 4 && kA >= 0) {
                        this.cOX = getChildAt(kA - this.bAH).getLeft();
                        this.cOZ = x;
                        this.cPa = y;
                        this.cOW = kA;
                        this.cPb = 0;
                        apD();
                    }
                    this.cPc = ExploreByTouchHelper.INVALID_ID;
                    apz();
                    this.mVelocityTracker.addMovement(motionEvent);
                    return i2 == 4;
                case 1:
                case 3:
                    this.cPb = -1;
                    this.mActivePointerId = -1;
                    apB();
                    ky(0);
                    return false;
                case 2:
                    switch (this.cPb) {
                        case 0:
                            int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                            if (findPointerIndex == -1) {
                                this.mActivePointerId = motionEvent.getPointerId(0);
                                findPointerIndex = 0;
                            }
                            apA();
                            this.mVelocityTracker.addMovement(motionEvent);
                            return kw((int) motionEvent.getX(findPointerIndex));
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
            this.cOZ = (int) motionEvent.getX(i2);
            this.cPa = (int) motionEvent.getY(i2);
            this.cPd = 0;
            this.mActivePointerId = motionEvent.getPointerId(i2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        int childCount = getChildCount();
        int i2 = this.bAH;
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
    public void ky(int i2) {
        if (i2 != this.cPx && this.cPi != null) {
            this.cPx = i2;
            this.cPi.a(this, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e implements Runnable {
        private final o cPX;
        private int cPY;
        private final Runnable cPZ = new com.baidu.tieba.horizonalList.widget.c(this);

        e() {
            this.cPX = new o(AbsHListView.this.getContext());
        }

        void kC(int i) {
            int i2 = i < 0 ? Integer.MAX_VALUE : 0;
            this.cPY = i2;
            this.cPX.setInterpolator(null);
            this.cPX.fling(i2, 0, i, 0, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
            AbsHListView.this.cPb = 4;
            AbsHListView.this.cOy.k(this);
        }

        void apK() {
            if (this.cPX.springBack(AbsHListView.this.getScrollX(), 0, 0, 0, 0, 0)) {
                AbsHListView.this.cPb = 6;
                AbsHListView.this.invalidate();
                AbsHListView.this.cOy.k(this);
                return;
            }
            AbsHListView.this.cPb = -1;
            AbsHListView.this.ky(0);
        }

        void kD(int i) {
            this.cPX.setInterpolator(null);
            this.cPX.fling(AbsHListView.this.getScrollX(), 0, i, 0, ExploreByTouchHelper.INVALID_ID, Integer.MAX_VALUE, 0, 0, AbsHListView.this.getWidth(), 0);
            AbsHListView.this.cPb = 6;
            AbsHListView.this.invalidate();
            AbsHListView.this.cOy.k(this);
        }

        void kE(int i) {
            this.cPX.notifyHorizontalEdgeReached(AbsHListView.this.getScrollX(), 0, AbsHListView.this.cPD);
            int overScrollMode = AbsHListView.this.getOverScrollMode();
            if (overScrollMode == 0 || (overScrollMode == 1 && !AbsHListView.this.apo())) {
                AbsHListView.this.cPb = 6;
                int currVelocity = (int) this.cPX.getCurrVelocity();
                if (i > 0) {
                    AbsHListView.this.cPE.onAbsorb(currVelocity);
                } else {
                    AbsHListView.this.cPF.onAbsorb(currVelocity);
                }
            } else {
                AbsHListView.this.cPb = -1;
                if (AbsHListView.this.cPf != null) {
                    AbsHListView.this.cPf.stop();
                }
            }
            AbsHListView.this.invalidate();
            AbsHListView.this.cOy.k(this);
        }

        void d(int i, int i2, boolean z) {
            int i3 = i < 0 ? Integer.MAX_VALUE : 0;
            this.cPY = i3;
            this.cPX.setInterpolator(z ? AbsHListView.cPQ : null);
            this.cPX.startScroll(i3, 0, i, 0, i2);
            AbsHListView.this.cPb = 4;
            AbsHListView.this.cOy.k(this);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void apL() {
            AbsHListView.this.cPb = -1;
            AbsHListView.this.removeCallbacks(this);
            AbsHListView.this.removeCallbacks(this.cPZ);
            AbsHListView.this.ky(0);
            AbsHListView.this.apD();
            this.cPX.abortAnimation();
            AbsHListView.this.overScrollBy(0, 0, 0, 0, 0, 0, 0, 0, false);
        }

        void apM() {
            AbsHListView.this.postDelayed(this.cPZ, 40L);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // java.lang.Runnable
        public void run() {
            int max;
            boolean z = true;
            boolean z2 = false;
            switch (AbsHListView.this.cPb) {
                case 3:
                    if (this.cPX.isFinished()) {
                        return;
                    }
                    break;
                case 4:
                    break;
                case 5:
                default:
                    apL();
                    return;
                case 6:
                    o oVar = this.cPX;
                    if (oVar.computeScrollOffset()) {
                        int scrollX = AbsHListView.this.getScrollX();
                        int currX = oVar.getCurrX();
                        if (AbsHListView.this.overScrollBy(currX - scrollX, 0, scrollX, 0, 0, 0, AbsHListView.this.cPD, 0, false)) {
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
                                kC(currVelocity);
                                return;
                            }
                            apK();
                            return;
                        }
                        AbsHListView.this.invalidate();
                        AbsHListView.this.cOy.k(this);
                        return;
                    }
                    apL();
                    return;
            }
            if (AbsHListView.this.afj) {
                AbsHListView.this.layoutChildren();
            }
            if (AbsHListView.this.cQS == 0 || AbsHListView.this.getChildCount() == 0) {
                apL();
                return;
            }
            o oVar2 = this.cPX;
            boolean computeScrollOffset = oVar2.computeScrollOffset();
            int currX2 = oVar2.getCurrX();
            int i = this.cPY - currX2;
            if (i > 0) {
                AbsHListView.this.cOW = AbsHListView.this.bAH;
                AbsHListView.this.cOX = AbsHListView.this.getChildAt(0).getLeft();
                max = Math.min(((AbsHListView.this.getWidth() - AbsHListView.this.getPaddingRight()) - AbsHListView.this.getPaddingLeft()) - 1, i);
            } else {
                int childCount = AbsHListView.this.getChildCount() - 1;
                AbsHListView.this.cOW = AbsHListView.this.bAH + childCount;
                AbsHListView.this.cOX = AbsHListView.this.getChildAt(childCount).getLeft();
                max = Math.max(-(((AbsHListView.this.getWidth() - AbsHListView.this.getPaddingRight()) - AbsHListView.this.getPaddingLeft()) - 1), i);
            }
            View childAt = AbsHListView.this.getChildAt(AbsHListView.this.cOW - AbsHListView.this.bAH);
            int left = childAt != null ? childAt.getLeft() : 0;
            boolean aC = AbsHListView.this.aC(max, max);
            if (!aC || max == 0) {
                z = false;
            }
            if (z) {
                if (childAt != null) {
                    AbsHListView.this.overScrollBy(-(max - (childAt.getLeft() - left)), 0, AbsHListView.this.getScrollX(), 0, 0, 0, AbsHListView.this.cPD, 0, false);
                }
                if (computeScrollOffset) {
                    kE(max);
                }
            } else if (computeScrollOffset && !z) {
                if (aC) {
                    AbsHListView.this.invalidate();
                }
                this.cPY = currX2;
                AbsHListView.this.cOy.k(this);
            } else {
                apL();
            }
        }
    }

    /* loaded from: classes.dex */
    public class j implements Runnable {
        private int cQh;
        private int cQi;
        private int cQj;
        private int cQk;
        private final int cQl;
        private int cQm;
        private int mMode;

        j() {
            this.cQl = ViewConfiguration.get(AbsHListView.this.getContext()).getScaledFadingEdgeLength();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void kC(int i) {
            int i2;
            stop();
            if (AbsHListView.this.afj) {
                AbsHListView.this.cPz = new com.baidu.tieba.horizonalList.widget.d(this, i);
                return;
            }
            int childCount = AbsHListView.this.getChildCount();
            if (childCount != 0) {
                int i3 = AbsHListView.this.bAH;
                int i4 = (childCount + i3) - 1;
                int max = Math.max(0, Math.min(AbsHListView.this.getCount() - 1, i));
                if (max < i3) {
                    i2 = (i3 - max) + 1;
                    this.mMode = 2;
                } else if (max > i4) {
                    i2 = (max - i4) + 1;
                    this.mMode = 1;
                } else {
                    v(max, -1, 200);
                    return;
                }
                if (i2 > 0) {
                    this.cQk = 200 / i2;
                } else {
                    this.cQk = 200;
                }
                this.cQh = max;
                this.cQi = -1;
                this.cQj = -1;
                AbsHListView.this.cOy.k(this);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void aE(int i, int i2) {
            int i3;
            stop();
            if (i2 == -1) {
                kC(i);
            } else if (AbsHListView.this.afj) {
                AbsHListView.this.cPz = new com.baidu.tieba.horizonalList.widget.e(this, i, i2);
            } else {
                int childCount = AbsHListView.this.getChildCount();
                if (childCount != 0) {
                    int i4 = AbsHListView.this.bAH;
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
                        v(max, i2, 200);
                        return;
                    }
                    if (i3 > 0) {
                        this.cQk = 200 / i3;
                    } else {
                        this.cQk = 200;
                    }
                    this.cQh = max;
                    this.cQi = i2;
                    this.cQj = -1;
                    AbsHListView.this.cOy.k(this);
                }
            }
        }

        void v(int i, int i2, int i3) {
            int i4 = AbsHListView.this.bAH;
            int childCount = (AbsHListView.this.getChildCount() + i4) - 1;
            int i5 = AbsHListView.this.cOQ.left;
            int width = AbsHListView.this.getWidth() - AbsHListView.this.cOQ.right;
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
            int i2 = AbsHListView.this.bAH;
            switch (this.mMode) {
                case 1:
                    int childCount = AbsHListView.this.getChildCount() - 1;
                    int i3 = i2 + childCount;
                    if (childCount >= 0) {
                        if (i3 == this.cQj) {
                            AbsHListView.this.cOy.k(this);
                            return;
                        }
                        View childAt = AbsHListView.this.getChildAt(childCount);
                        AbsHListView.this.c((i3 < AbsHListView.this.cQS + (-1) ? Math.max(AbsHListView.this.cOQ.right, this.cQl) : AbsHListView.this.cOQ.right) + (childAt.getWidth() - (width - childAt.getLeft())), this.cQk, true);
                        this.cQj = i3;
                        if (i3 < this.cQh) {
                            AbsHListView.this.cOy.k(this);
                            return;
                        }
                        return;
                    }
                    return;
                case 2:
                    if (i2 == this.cQj) {
                        AbsHListView.this.cOy.k(this);
                        return;
                    }
                    View childAt2 = AbsHListView.this.getChildAt(0);
                    if (childAt2 != null) {
                        AbsHListView.this.c(childAt2.getLeft() - (i2 > 0 ? Math.max(this.cQl, AbsHListView.this.cOQ.left) : AbsHListView.this.cOQ.left), this.cQk, true);
                        this.cQj = i2;
                        if (i2 > this.cQh) {
                            AbsHListView.this.cOy.k(this);
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    int childCount2 = AbsHListView.this.getChildCount();
                    if (i2 != this.cQi && childCount2 > 1 && childCount2 + i2 < AbsHListView.this.cQS) {
                        int i4 = i2 + 1;
                        if (i4 == this.cQj) {
                            AbsHListView.this.cOy.k(this);
                            return;
                        }
                        View childAt3 = AbsHListView.this.getChildAt(1);
                        int width2 = childAt3.getWidth();
                        int left2 = childAt3.getLeft();
                        int max = Math.max(AbsHListView.this.cOQ.right, this.cQl);
                        if (i4 < this.cQi) {
                            AbsHListView.this.c(Math.max(0, (left2 + width2) - max), this.cQk, true);
                            this.cQj = i4;
                            AbsHListView.this.cOy.k(this);
                            return;
                        } else if (left2 > max) {
                            AbsHListView.this.c(left2 - max, this.cQk, true);
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
                        if (i5 == this.cQj) {
                            AbsHListView.this.cOy.k(this);
                            return;
                        }
                        View childAt4 = AbsHListView.this.getChildAt(childCount3);
                        int width3 = childAt4.getWidth();
                        int left3 = childAt4.getLeft();
                        int i6 = width - left3;
                        int max2 = Math.max(AbsHListView.this.cOQ.left, this.cQl);
                        this.cQj = i5;
                        if (i5 > this.cQi) {
                            AbsHListView.this.c(-(i6 - max2), this.cQk, true);
                            AbsHListView.this.cOy.k(this);
                            return;
                        }
                        int i7 = width - max2;
                        int i8 = left3 + width3;
                        if (i7 > i8) {
                            AbsHListView.this.c(-(i7 - i8), this.cQk, true);
                            return;
                        }
                        return;
                    }
                    return;
                case 5:
                    if (this.cQj == i2) {
                        AbsHListView.this.cOy.k(this);
                        return;
                    }
                    this.cQj = i2;
                    int childCount4 = AbsHListView.this.getChildCount();
                    int i9 = this.cQh;
                    int i10 = (i2 + childCount4) - 1;
                    if (i9 < i2) {
                        i = (i2 - i9) + 1;
                    } else if (i9 > i10) {
                        i = i9 - i10;
                    }
                    float min = Math.min(Math.abs(i / childCount4), 1.0f);
                    if (i9 < i2) {
                        AbsHListView.this.c((int) ((-AbsHListView.this.getWidth()) * min), (int) (min * this.cQk), true);
                        AbsHListView.this.cOy.k(this);
                        return;
                    } else if (i9 > i10) {
                        AbsHListView.this.c((int) (AbsHListView.this.getWidth() * min), (int) (min * this.cQk), true);
                        AbsHListView.this.cOy.k(this);
                        return;
                    } else {
                        AbsHListView.this.c(AbsHListView.this.getChildAt(i9 - i2).getLeft() - this.cQm, (int) (this.cQk * (Math.abs(left) / AbsHListView.this.getWidth())), true);
                        return;
                    }
                default:
                    return;
            }
        }
    }

    public void setFriction(float f2) {
        if (this.cPe == null) {
            this.cPe = new e();
        }
        this.cPe.cPX.setFriction(f2);
    }

    public void setVelocityScale(float f2) {
        this.cPA = f2;
    }

    public void smoothScrollToPosition(int i2, int i3) {
        if (this.cPf == null) {
            this.cPf = new j();
        }
        this.cPf.aE(i2, i3);
    }

    public void smoothScrollBy(int i2, int i3) {
        c(i2, i3, false);
    }

    public void c(int i2, int i3, boolean z) {
        if (this.cPe == null) {
            this.cPe = new e();
        }
        int i4 = this.bAH;
        int childCount = getChildCount();
        int i5 = i4 + childCount;
        int paddingLeft = getPaddingLeft();
        int width = getWidth() - getPaddingRight();
        if (i2 == 0 || this.cQS == 0 || childCount == 0 || ((i4 == 0 && getChildAt(0).getLeft() == paddingLeft && i2 < 0) || (i5 == this.cQS && getChildAt(childCount - 1).getRight() == width && i2 > 0))) {
            this.cPe.apL();
            if (this.cPf != null) {
                this.cPf.stop();
                return;
            }
            return;
        }
        ky(2);
        this.cPe.d(i2, i3, z);
    }

    private void apC() {
        if (this.mScrollingCacheEnabled && !this.cOU && !this.cOy.isHardwareAccelerated()) {
            setChildrenDrawnWithCacheEnabled(true);
            setChildrenDrawingCacheEnabled(true);
            this.cOV = true;
            this.cOU = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apD() {
        if (!this.cOy.isHardwareAccelerated()) {
            if (this.cPy == null) {
                this.cPy = new com.baidu.tieba.horizonalList.widget.b(this);
            }
            post(this.cPy);
        }
    }

    boolean aC(int i2, int i3) {
        int min;
        int min2;
        int i4;
        int childCount = getChildCount();
        if (childCount == 0) {
            return true;
        }
        int left = getChildAt(0).getLeft();
        int right = getChildAt(childCount - 1).getRight();
        Rect rect = this.cOQ;
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
        int i6 = this.bAH;
        if (i6 == 0) {
            this.cPG = left - rect.left;
        } else {
            this.cPG += min2;
        }
        if (i6 + childCount == this.cQS) {
            this.cPH = rect.right + right;
        } else {
            this.cPH += min2;
        }
        boolean z = i6 == 0 && left >= rect.left && min2 >= 0;
        boolean z2 = i6 + childCount == this.cQS && right <= getWidth() - rect.right && min2 <= 0;
        if (z || z2) {
            return min2 != 0;
        }
        boolean z3 = min2 < 0;
        boolean isInTouchMode = isInTouchMode();
        if (isInTouchMode) {
            apE();
        }
        int headerViewsCount = getHeaderViewsCount();
        int footerViewsCount = this.cQS - getFooterViewsCount();
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
                    this.cOL.t(childAt, i11);
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
                    this.cOL.t(childAt2, i14);
                }
                i4 = i13;
                i7 = i12;
            }
        }
        this.cOY = this.cOX + min;
        this.cRa = true;
        if (i4 > 0) {
            detachViewsFromParent(i7, i4);
            this.cOL.apP();
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        kz(min2);
        if (z3) {
            this.bAH = i4 + this.bAH;
        }
        int abs = Math.abs(min2);
        if (i5 < abs || width < abs) {
            fv(z3);
        }
        if (!isInTouchMode && this.cxH != -1) {
            int i15 = this.cxH - this.bAH;
            if (i15 >= 0 && i15 < getChildCount()) {
                b(this.cxH, getChildAt(i15));
            }
        } else if (this.cOJ != -1) {
            int i16 = this.cOJ - this.bAH;
            if (i16 >= 0 && i16 < getChildCount()) {
                b(-1, getChildAt(i16));
            }
        } else {
            this.cOK.setEmpty();
        }
        this.cRa = false;
        app();
        return false;
    }

    public void kz(int i2) {
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
    public void apE() {
        if (this.cxH != -1) {
            if (this.cOF != 4) {
                this.cPl = this.cxH;
            }
            if (this.cQP >= 0 && this.cQP != this.cxH) {
                this.cPl = this.cQP;
            }
            setSelectedPositionInt(-1);
            setNextSelectedPositionInt(-1);
            this.cPg = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int apF() {
        int i2 = this.cxH;
        if (i2 < 0) {
            i2 = this.cPl;
        }
        return Math.min(Math.max(0, i2), this.cQS - 1);
    }

    protected int kB(int i2) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return -1;
        }
        int kA = kA(i2);
        return kA == -1 ? (this.bAH + childCount) - 1 : kA;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean apG() {
        if (this.cxH >= 0 || !apH()) {
            return false;
        }
        apx();
        return true;
    }

    boolean apH() {
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
        int i8 = this.cOQ.left;
        int right = (getRight() - getLeft()) - this.cOQ.right;
        int i9 = this.bAH;
        int i10 = this.cPl;
        if (i10 >= i9 && i10 < i9 + childCount) {
            View childAt = getChildAt(i10 - this.bAH);
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
            int i15 = this.cQS;
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
        this.cPl = -1;
        removeCallbacks(this.cPe);
        if (this.cPf != null) {
            this.cPf.stop();
        }
        this.cPb = -1;
        apD();
        this.cQG = i2;
        int E = E(i3, z);
        if (E < i9 || E > getLastVisiblePosition()) {
            E = -1;
        } else {
            this.cOF = 4;
            apx();
            setSelectionInt(E);
            app();
        }
        ky(0);
        return E >= 0;
    }

    void apI() {
        int i2;
        boolean z;
        boolean z2;
        this.cOD.clear();
        int i3 = 0;
        boolean z3 = false;
        while (i3 < this.cOE.size()) {
            long keyAt = this.cOE.keyAt(i3);
            int intValue = this.cOE.valueAt(i3).intValue();
            if (keyAt != this.mAdapter.getItemId(intValue)) {
                int max = Math.max(0, intValue - 20);
                int min = Math.min(intValue + 20, this.cQS);
                while (true) {
                    if (max >= min) {
                        z2 = false;
                        break;
                    } else if (keyAt != this.mAdapter.getItemId(max)) {
                        max++;
                    } else {
                        this.cOD.put(max, true);
                        this.cOE.setValueAt(i3, Integer.valueOf(max));
                        z2 = true;
                        break;
                    }
                }
                if (!z2) {
                    this.cOE.delete(keyAt);
                    int i4 = i3 - 1;
                    this.cOC--;
                    if (Build.VERSION.SDK_INT <= 11 || this.cOA == null || this.cOB == null) {
                        i2 = i4;
                        z = true;
                    } else {
                        ((com.baidu.tieba.horizonalList.a.a.b) this.cOB).onItemCheckedStateChanged((ActionMode) this.cOA, intValue, keyAt, false);
                        i2 = i4;
                        z = true;
                    }
                    z3 = z;
                    i3 = i2 + 1;
                }
            } else {
                this.cOD.put(intValue, true);
            }
            i2 = i3;
            z = z3;
            z3 = z;
            i3 = i2 + 1;
        }
        if (z3 && this.cOA != null && Build.VERSION.SDK_INT > 11) {
            ((ActionMode) this.cOA).invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.g
    public void handleDataChanged() {
        int i2 = this.cQS;
        int i3 = this.cPP;
        this.cPP = this.cQS;
        if (this.cOz != 0 && this.mAdapter != null && this.mAdapter.hasStableIds()) {
            apI();
        }
        this.cOL.apO();
        if (i2 > 0) {
            if (this.cQK) {
                this.cQK = false;
                this.cPR = null;
                if (this.cPu == 2) {
                    this.cOF = 3;
                    return;
                }
                if (this.cPu == 1) {
                    if (this.cPI) {
                        this.cPI = false;
                        this.cOF = 3;
                        return;
                    }
                    int childCount = getChildCount();
                    int width = getWidth() - getPaddingRight();
                    View childAt = getChildAt(childCount - 1);
                    int bottom = childAt != null ? childAt.getBottom() : width;
                    if (childCount + this.bAH >= i3 && bottom <= width) {
                        this.cOF = 3;
                        return;
                    }
                    awakenScrollBars();
                }
                switch (this.cQL) {
                    case 1:
                        this.cOF = 5;
                        this.cQH = Math.min(Math.max(0, this.cQH), i2 - 1);
                        return;
                    case 0:
                        if (isInTouchMode()) {
                            this.cOF = 5;
                            this.cQH = Math.min(Math.max(0, this.cQH), i2 - 1);
                            return;
                        }
                        int aqa = aqa();
                        if (aqa >= 0 && E(aqa, true) == aqa) {
                            this.cQH = aqa;
                            if (this.cQJ == getWidth()) {
                                this.cOF = 5;
                            } else {
                                this.cOF = 2;
                            }
                            setNextSelectedPositionInt(aqa);
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
                int E = E(selectedItemPosition, true);
                if (E >= 0) {
                    setNextSelectedPositionInt(E);
                    return;
                }
                int E2 = E(selectedItemPosition, false);
                if (E2 >= 0) {
                    setNextSelectedPositionInt(E2);
                    return;
                }
            } else if (this.cPl >= 0) {
                return;
            }
        }
        this.cOF = this.cPh ? 3 : 1;
        this.cxH = -1;
        this.cQR = Long.MIN_VALUE;
        this.cQP = -1;
        this.cQQ = Long.MIN_VALUE;
        this.cQK = false;
        this.cPR = null;
        this.cOJ = -1;
        apZ();
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
        this.cPu = i2;
    }

    public int getTranscriptMode() {
        return this.cPu;
    }

    @Override // android.view.View
    public int getSolidColor() {
        return this.cPv;
    }

    public void setCacheColorHint(int i2) {
        if (i2 != this.cPv) {
            this.cPv = i2;
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                getChildAt(i3).setDrawingCacheBackgroundColor(i2);
            }
            this.cOL.setCacheColorHint(i2);
        }
    }

    @ViewDebug.ExportedProperty(category = "drawing")
    public int getCacheColorHint() {
        return this.cPv;
    }

    private void apJ() {
        if (this.cPE != null) {
            this.cPE.finish();
            this.cPF.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aD(int i2, int i3) {
    }

    public void setRecyclerListener(l lVar) {
        this.cOL.cQp = lVar;
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
        public int cQb;
        public boolean cQc;
        public boolean cQd;
        public int cQe;
        public long cQf;

        public f(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.cQf = -1L;
        }

        public f(int i, int i2, int i3) {
            super(i, i2);
            this.cQf = -1L;
            this.cQb = i3;
        }

        public f(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.cQf = -1L;
        }
    }

    /* loaded from: classes.dex */
    public class k {
        private l cQp;
        private int cQq;
        private View[] cQr = new View[0];
        private ArrayList<View>[] cQs;
        private int cQt;
        private ArrayList<View> cQu;
        private ArrayList<View> cQv;
        private SparseArrayCompat<View> cQw;

        public k() {
        }

        public void kF(int i) {
            if (i < 1) {
                throw new IllegalArgumentException("Can't have a viewTypeCount < 1");
            }
            ArrayList<View>[] arrayListArr = new ArrayList[i];
            for (int i2 = 0; i2 < i; i2++) {
                arrayListArr[i2] = new ArrayList<>();
            }
            this.cQt = i;
            this.cQu = arrayListArr[0];
            this.cQs = arrayListArr;
        }

        public void apN() {
            if (this.cQt == 1) {
                ArrayList<View> arrayList = this.cQu;
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    arrayList.get(i).forceLayout();
                }
            } else {
                int i2 = this.cQt;
                for (int i3 = 0; i3 < i2; i3++) {
                    ArrayList<View> arrayList2 = this.cQs[i3];
                    int size2 = arrayList2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        arrayList2.get(i4).forceLayout();
                    }
                }
            }
            if (this.cQw != null) {
                int size3 = this.cQw.size();
                for (int i5 = 0; i5 < size3; i5++) {
                    this.cQw.valueAt(i5).forceLayout();
                }
            }
        }

        public boolean kG(int i) {
            return i >= 0;
        }

        public void clear() {
            if (this.cQt == 1) {
                ArrayList<View> arrayList = this.cQu;
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    AbsHListView.this.removeDetachedView(arrayList.remove((size - 1) - i), false);
                }
            } else {
                int i2 = this.cQt;
                for (int i3 = 0; i3 < i2; i3++) {
                    ArrayList<View> arrayList2 = this.cQs[i3];
                    int size2 = arrayList2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        AbsHListView.this.removeDetachedView(arrayList2.remove((size2 - 1) - i4), false);
                    }
                }
            }
            if (this.cQw != null) {
                this.cQw.clear();
            }
        }

        public void aF(int i, int i2) {
            if (this.cQr.length < i) {
                this.cQr = new View[i];
            }
            this.cQq = i2;
            View[] viewArr = this.cQr;
            for (int i3 = 0; i3 < i; i3++) {
                View childAt = AbsHListView.this.getChildAt(i3);
                f fVar = (f) childAt.getLayoutParams();
                if (fVar != null && fVar.cQb != -2) {
                    viewArr[i3] = childAt;
                }
            }
        }

        public View kH(int i) {
            int i2 = i - this.cQq;
            View[] viewArr = this.cQr;
            if (i2 < 0 || i2 >= viewArr.length) {
                return null;
            }
            View view = viewArr[i2];
            viewArr[i2] = null;
            return view;
        }

        View kI(int i) {
            int indexOfKey;
            if (this.cQw != null && (indexOfKey = this.cQw.indexOfKey(i)) >= 0) {
                View valueAt = this.cQw.valueAt(indexOfKey);
                this.cQw.removeAt(indexOfKey);
                return valueAt;
            }
            return null;
        }

        void apO() {
            if (this.cQw != null) {
                this.cQw.clear();
            }
        }

        View kJ(int i) {
            if (this.cQt == 1) {
                return AbsHListView.a(this.cQu, i);
            }
            int itemViewType = AbsHListView.this.mAdapter.getItemViewType(i);
            if (itemViewType >= 0 && itemViewType < this.cQs.length) {
                return AbsHListView.a(this.cQs[itemViewType], i);
            }
            return null;
        }

        public void t(View view, int i) {
            f fVar = (f) view.getLayoutParams();
            if (fVar != null) {
                fVar.cQe = i;
                int i2 = fVar.cQb;
                if (!kG(i2)) {
                    if (i2 != -2) {
                        if (this.cQv == null) {
                            this.cQv = new ArrayList<>();
                        }
                        this.cQv.add(view);
                        return;
                    }
                    return;
                }
                view.onStartTemporaryDetach();
                if (this.cQt == 1) {
                    this.cQu.add(view);
                } else {
                    this.cQs[i2].add(view);
                }
                if (Build.VERSION.SDK_INT >= 14) {
                    view.setAccessibilityDelegate(null);
                }
                if (this.cQp != null) {
                    this.cQp.onMovedToScrapHeap(view);
                }
            }
        }

        public void apP() {
            if (this.cQv != null) {
                int size = this.cQv.size();
                for (int i = 0; i < size; i++) {
                    AbsHListView.this.removeDetachedView(this.cQv.get(i), false);
                }
                this.cQv.clear();
            }
        }

        public void apQ() {
            View[] viewArr = this.cQr;
            boolean z = this.cQp != null;
            boolean z2 = this.cQt > 1;
            ArrayList<View> arrayList = this.cQu;
            for (int length = viewArr.length - 1; length >= 0; length--) {
                View view = viewArr[length];
                if (view != null) {
                    f fVar = (f) view.getLayoutParams();
                    int i = fVar.cQb;
                    viewArr[length] = null;
                    if (!kG(i)) {
                        if (i != -2) {
                            AbsHListView.this.removeDetachedView(view, false);
                        }
                    } else {
                        if (z2) {
                            arrayList = this.cQs[i];
                        }
                        view.onStartTemporaryDetach();
                        fVar.cQe = this.cQq + length;
                        arrayList.add(view);
                        if (Build.VERSION.SDK_INT >= 14) {
                            view.setAccessibilityDelegate(null);
                        }
                        if (z) {
                            this.cQp.onMovedToScrapHeap(view);
                        }
                    }
                }
            }
            apR();
        }

        private void apR() {
            int length = this.cQr.length;
            int i = this.cQt;
            ArrayList<View>[] arrayListArr = this.cQs;
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
            if (this.cQw != null) {
                for (int i6 = 0; i6 < this.cQw.size(); i6++) {
                    this.cQw.valueAt(i6);
                }
            }
        }

        void setCacheColorHint(int i) {
            View[] viewArr;
            if (this.cQt == 1) {
                ArrayList<View> arrayList = this.cQu;
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    arrayList.get(i2).setDrawingCacheBackgroundColor(i);
                }
            } else {
                int i3 = this.cQt;
                for (int i4 = 0; i4 < i3; i4++) {
                    ArrayList<View> arrayList2 = this.cQs[i4];
                    int size2 = arrayList2.size();
                    for (int i5 = 0; i5 < size2; i5++) {
                        arrayList2.get(i5).setDrawingCacheBackgroundColor(i);
                    }
                }
            }
            for (View view : this.cQr) {
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
                if (((f) view.getLayoutParams()).cQe == i2) {
                    arrayList.remove(i3);
                    return view;
                }
            }
            return arrayList.remove(size - 1);
        }
        return null;
    }
}
