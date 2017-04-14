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
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class AbsHListView extends com.baidu.tieba.horizonalList.widget.g<ListAdapter> implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnTouchModeChangeListener {
    static final Interpolator cBV = new LinearInterpolator();
    public static final int[] cBX = new int[1];
    Drawable Hk;
    a.AbstractC0062a cAD;
    protected int cAE;
    public Object cAF;
    Object cAG;
    int cAH;
    protected SparseArrayCompat<Boolean> cAI;
    LongSparseArray<Integer> cAJ;
    protected int cAK;
    protected a cAL;
    boolean cAM;
    boolean cAN;
    int cAO;
    protected Rect cAP;
    protected final k cAQ;
    int cAR;
    int cAS;
    int cAT;
    int cAU;
    protected Rect cAV;
    protected int cAW;
    View cAX;
    View cAY;
    protected boolean cAZ;
    private int cBA;
    private boolean cBB;
    private int cBC;
    private Runnable cBD;
    protected Runnable cBE;
    private float cBF;
    protected final boolean[] cBG;
    int cBH;
    int cBI;
    private EdgeEffectCompat cBJ;
    private EdgeEffectCompat cBK;
    private int cBL;
    private int cBM;
    private boolean cBN;
    private int cBO;
    private int cBP;
    private g cBQ;
    private int cBR;
    private int cBS;
    protected boolean cBT;
    private int cBU;
    private SavedState cBW;
    private float cBY;
    protected boolean cBa;
    protected int cBb;
    int cBc;
    int cBd;
    int cBe;
    int cBf;
    protected int cBg;
    int cBh;
    int cBi;
    private e cBj;
    protected j cBk;
    protected int cBl;
    protected boolean cBm;
    private h cBn;
    private boolean cBo;
    private Rect cBp;
    protected int cBq;
    private ContextMenu.ContextMenuInfo cBr;
    protected int cBs;
    private int cBt;
    private c cBu;
    private Runnable cBv;
    private b cBw;
    private i cBx;
    private Runnable cBy;
    private int cBz;
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

    protected abstract void fb(boolean z);

    protected abstract int kc(int i2);

    public abstract void setSelectionInt(int i2);

    public AbsHListView(Context context) {
        super(context);
        this.cAE = 0;
        this.cAK = 0;
        this.cAN = false;
        this.cAO = -1;
        this.cAP = new Rect();
        this.cAQ = new k();
        this.cAR = 0;
        this.cAS = 0;
        this.cAT = 0;
        this.cAU = 0;
        this.cAV = new Rect();
        this.cAW = 0;
        this.cBg = -1;
        this.cBl = 0;
        this.cBo = true;
        this.cBq = -1;
        this.cBr = null;
        this.cBt = -1;
        this.cBC = 0;
        this.cBF = 1.0f;
        this.cBG = new boolean[1];
        this.mActivePointerId = -1;
        this.mDirection = 0;
        akb();
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
        this.cAE = 0;
        this.cAK = 0;
        this.cAN = false;
        this.cAO = -1;
        this.cAP = new Rect();
        this.cAQ = new k();
        this.cAR = 0;
        this.cAS = 0;
        this.cAT = 0;
        this.cAU = 0;
        this.cAV = new Rect();
        this.cAW = 0;
        this.cBg = -1;
        this.cBl = 0;
        this.cBo = true;
        this.cBq = -1;
        this.cBr = null;
        this.cBt = -1;
        this.cBC = 0;
        this.cBF = 1.0f;
        this.cBG = new boolean[1];
        this.mActivePointerId = -1;
        this.mDirection = 0;
        akb();
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
        this.cAN = z3;
        setStackFromRight(z2);
        setScrollingCacheEnabled(z);
        setTranscriptMode(i3);
        setCacheColorHint(i4);
        setSmoothScrollbarEnabled(z4);
        setChoiceMode(i5);
    }

    private void akb() {
        setClickable(true);
        setFocusableInTouchMode(true);
        setWillNotDraw(false);
        setAlwaysDrawnWithCacheEnabled(false);
        setScrollingCacheEnabled(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.cBH = viewConfiguration.getScaledOverscrollDistance();
        this.cBI = viewConfiguration.getScaledOverflingDistance();
        this.cAD = com.baidu.tieba.horizonalList.a.a.av(this);
    }

    @Override // android.view.View
    public void setOverScrollMode(int i2) {
        if (i2 != 2) {
            if (this.cBJ == null) {
                Context context = getContext();
                this.cBJ = new EdgeEffectCompat(context);
                this.cBK = new EdgeEffectCompat(context);
            }
        } else {
            this.cBJ = null;
            this.cBK = null;
        }
        super.setOverScrollMode(i2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.horizonalList.widget.g
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            this.cAM = this.mAdapter.hasStableIds();
            if (this.cAE != 0 && this.cAM && this.cAJ == null) {
                this.cAJ = new LongSparseArray<>();
            }
        }
        if (this.cAI != null) {
            this.cAI.clear();
        }
        if (this.cAJ != null) {
            this.cAJ.clear();
        }
    }

    public int getCheckedItemCount() {
        return this.cAH;
    }

    public boolean isItemChecked(int i2) {
        if (this.cAE == 0 || this.cAI == null) {
            return false;
        }
        return this.cAI.get(i2, false).booleanValue();
    }

    public int getCheckedItemPosition() {
        if (this.cAE == 1 && this.cAI != null && this.cAI.size() == 1) {
            return this.cAI.keyAt(0);
        }
        return -1;
    }

    public SparseArrayCompat<Boolean> getCheckedItemPositions() {
        if (this.cAE != 0) {
            return this.cAI;
        }
        return null;
    }

    public long[] getCheckedItemIds() {
        if (this.cAE == 0 || this.cAJ == null || this.mAdapter == null) {
            return new long[0];
        }
        LongSparseArray<Integer> longSparseArray = this.cAJ;
        int size = longSparseArray.size();
        long[] jArr = new long[size];
        for (int i2 = 0; i2 < size; i2++) {
            jArr[i2] = longSparseArray.keyAt(i2);
        }
        return jArr;
    }

    public void clearChoices() {
        if (this.cAI != null) {
            this.cAI.clear();
        }
        if (this.cAJ != null) {
            this.cAJ.clear();
        }
        this.cAH = 0;
    }

    public void setItemChecked(int i2, boolean z) {
        if (this.cAE != 0) {
            if (Build.VERSION.SDK_INT >= 11 && z && this.cAE == 3 && this.cAF == null) {
                if (this.cAG == null || !((com.baidu.tieba.horizonalList.a.a.b) this.cAG).aka()) {
                    throw new IllegalStateException("AbsListView: attempted to start selection mode for CHOICE_MODE_MULTIPLE_MODAL but no choice mode callback was supplied. Call setMultiChoiceModeListener to set a callback.");
                }
                this.cAF = startActionMode((com.baidu.tieba.horizonalList.a.a.b) this.cAG);
            }
            if (this.cAE == 2 || (Build.VERSION.SDK_INT >= 11 && this.cAE == 3)) {
                boolean booleanValue = this.cAI.get(i2, false).booleanValue();
                this.cAI.put(i2, Boolean.valueOf(z));
                if (this.cAJ != null && this.mAdapter.hasStableIds()) {
                    if (z) {
                        this.cAJ.put(this.mAdapter.getItemId(i2), Integer.valueOf(i2));
                    } else {
                        this.cAJ.delete(this.mAdapter.getItemId(i2));
                    }
                }
                if (booleanValue != z) {
                    if (z) {
                        this.cAH++;
                    } else {
                        this.cAH--;
                    }
                }
                if (this.cAF != null) {
                    ((com.baidu.tieba.horizonalList.a.a.b) this.cAG).onItemCheckedStateChanged((ActionMode) this.cAF, i2, this.mAdapter.getItemId(i2), z);
                }
            } else {
                boolean z2 = this.cAJ != null && this.mAdapter.hasStableIds();
                if (z || isItemChecked(i2)) {
                    this.cAI.clear();
                    if (z2) {
                        this.cAJ.clear();
                    }
                }
                if (z) {
                    this.cAI.put(i2, true);
                    if (z2) {
                        this.cAJ.put(this.mAdapter.getItemId(i2), Integer.valueOf(i2));
                    }
                    this.cAH = 1;
                } else if (this.cAI.size() == 0 || !this.cAI.valueAt(0).booleanValue()) {
                    this.cAH = 0;
                }
            }
            if (!this.mInLayout && !this.cDg) {
                this.ajq = true;
                akQ();
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
        if (this.cAE != 0) {
            if (this.cAE == 2 || (Build.VERSION.SDK_INT >= 11 && this.cAE == 3 && this.cAF != null)) {
                boolean z5 = !this.cAI.get(i2, false).booleanValue();
                this.cAI.put(i2, Boolean.valueOf(z5));
                if (this.cAJ != null && this.mAdapter.hasStableIds()) {
                    if (z5) {
                        this.cAJ.put(this.mAdapter.getItemId(i2), Integer.valueOf(i2));
                    } else {
                        this.cAJ.delete(this.mAdapter.getItemId(i2));
                    }
                }
                if (z5) {
                    this.cAH++;
                } else {
                    this.cAH--;
                }
                if (this.cAF != null) {
                    ((com.baidu.tieba.horizonalList.a.a.b) this.cAG).onItemCheckedStateChanged((ActionMode) this.cAF, i2, j2, z5);
                } else {
                    z4 = true;
                }
                z2 = z4;
                z4 = true;
            } else if (this.cAE == 1) {
                if (!this.cAI.get(i2, false).booleanValue()) {
                    this.cAI.clear();
                    this.cAI.put(i2, true);
                    if (this.cAJ != null && this.mAdapter.hasStableIds()) {
                        this.cAJ.clear();
                        this.cAJ.put(this.mAdapter.getItemId(i2), Integer.valueOf(i2));
                    }
                    this.cAH = 1;
                } else if (this.cAI.size() == 0 || !this.cAI.valueAt(0).booleanValue()) {
                    this.cAH = 0;
                }
                z4 = true;
                z2 = true;
            } else {
                z2 = true;
            }
            if (z4) {
                akc();
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

    private void akc() {
        int i2 = this.cCL;
        int childCount = getChildCount();
        boolean z = Build.VERSION.SDK_INT >= 11;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            int i4 = i2 + i3;
            if (childAt instanceof Checkable) {
                ((Checkable) childAt).setChecked(this.cAI.get(i4, false).booleanValue());
            } else if (z) {
                childAt.setActivated(this.cAI.get(i4, false).booleanValue());
            }
        }
    }

    public int getChoiceMode() {
        return this.cAE;
    }

    public void setChoiceMode(int i2) {
        this.cAE = i2;
        if (Build.VERSION.SDK_INT >= 11 && this.cAF != null) {
            if (Build.VERSION.SDK_INT >= 11) {
                ((ActionMode) this.cAF).finish();
            }
            this.cAF = null;
        }
        if (this.cAE != 0) {
            if (this.cAI == null) {
                this.cAI = new SparseArrayCompat<>();
            }
            if (this.cAJ == null && this.mAdapter != null && this.mAdapter.hasStableIds()) {
                this.cAJ = new LongSparseArray<>();
            }
            if (Build.VERSION.SDK_INT >= 11 && this.cAE == 3) {
                clearChoices();
                setLongClickable(true);
            }
        }
    }

    public void setMultiChoiceModeListener(com.baidu.tieba.horizonalList.a.a.a aVar) {
        if (Build.VERSION.SDK_INT >= 11) {
            if (this.cAG == null) {
                this.cAG = new com.baidu.tieba.horizonalList.a.a.b(this);
            }
            ((com.baidu.tieba.horizonalList.a.a.b) this.cAG).a(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean akd() {
        int childCount = getChildCount();
        if (childCount == 0) {
            return true;
        }
        if (childCount != this.cCY) {
            return false;
        }
        return getChildAt(0).getLeft() >= this.cAV.left && getChildAt(childCount + (-1)).getRight() <= getWidth() - this.cAV.right;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public int getHorizontalScrollbarHeight() {
        return super.getHorizontalScrollbarHeight();
    }

    public void setSmoothScrollbarEnabled(boolean z) {
        this.cBo = z;
    }

    public void setOnScrollListener(h hVar) {
        this.cBn = hVar;
        ake();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ake() {
        if (this.cBn != null) {
            this.cBn.a(this, this.cCL, getChildCount(), this.cCY);
        }
        onScrollChanged(0, 0, 0, 0);
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEvent(int i2) {
        if (i2 == 4096) {
            int firstVisiblePosition = getFirstVisiblePosition();
            int lastVisiblePosition = getLastVisiblePosition();
            if (this.cBR != firstVisiblePosition || this.cBS != lastVisiblePosition) {
                this.cBR = firstVisiblePosition;
                this.cBS = lastVisiblePosition;
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
            aks();
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

    private void akf() {
        setSelector(getResources().getDrawable(17301602));
    }

    public void setStackFromRight(boolean z) {
        if (this.cBm != z) {
            this.cBm = z;
            akg();
        }
    }

    void akg() {
        if (getChildCount() > 0) {
            akh();
            requestLayout();
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new com.baidu.tieba.horizonalList.widget.f();
        long cCC;
        long cCD;
        int cCE;
        String cCF;
        boolean cCG;
        int cCH;
        SparseArrayCompat<Boolean> cCI;
        LongSparseArray<Integer> cCJ;
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
            this.cCC = parcel.readLong();
            this.cCD = parcel.readLong();
            this.cCE = parcel.readInt();
            this.position = parcel.readInt();
            this.width = parcel.readInt();
            this.cCF = parcel.readString();
            this.cCG = parcel.readByte() != 0;
            this.cCH = parcel.readInt();
            this.cCI = h(parcel);
            this.cCJ = g(parcel);
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
            parcel.writeLong(this.cCC);
            parcel.writeLong(this.cCD);
            parcel.writeInt(this.cCE);
            parcel.writeInt(this.position);
            parcel.writeInt(this.width);
            parcel.writeString(this.cCF);
            parcel.writeByte((byte) (this.cCG ? 1 : 0));
            parcel.writeInt(this.cCH);
            a(this.cCI, parcel);
            a(this.cCJ, parcel);
        }

        public String toString() {
            return "AbsListView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " selectedId=" + this.cCC + " firstId=" + this.cCD + " viewLeft=" + this.cCE + " position=" + this.position + " width=" + this.width + " filter=" + this.cCF + " checkState=" + this.cCI + "}";
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        boolean z = true;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.cBW != null) {
            savedState.cCC = this.cBW.cCC;
            savedState.cCD = this.cBW.cCD;
            savedState.cCE = this.cBW.cCE;
            savedState.position = this.cBW.position;
            savedState.width = this.cBW.width;
            savedState.cCF = this.cBW.cCF;
            savedState.cCG = this.cBW.cCG;
            savedState.cCH = this.cBW.cCH;
            savedState.cCI = this.cBW.cCI;
            savedState.cCJ = this.cBW.cCJ;
            return savedState;
        }
        boolean z2 = getChildCount() > 0 && this.cCY > 0;
        long selectedItemId = getSelectedItemId();
        savedState.cCC = selectedItemId;
        savedState.width = getWidth();
        if (selectedItemId >= 0) {
            savedState.cCE = this.cBl;
            savedState.position = getSelectedItemPosition();
            savedState.cCD = -1L;
        } else if (z2 && this.cCL > 0) {
            savedState.cCE = getChildAt(0).getLeft();
            int i2 = this.cCL;
            if (i2 >= this.cCY) {
                i2 = this.cCY - 1;
            }
            savedState.position = i2;
            savedState.cCD = this.mAdapter.getItemId(i2);
        } else {
            savedState.cCE = 0;
            savedState.cCD = -1L;
            savedState.position = 0;
        }
        savedState.cCF = null;
        savedState.cCG = (Build.VERSION.SDK_INT < 11 || this.cAE != 3 || this.cAF == null) ? false : false;
        if (this.cAI != null) {
            try {
                savedState.cCI = this.cAI.m1clone();
            } catch (NoSuchMethodError e2) {
                e2.printStackTrace();
                savedState.cCI = new SparseArrayCompat<>();
            }
        }
        if (this.cAJ != null) {
            LongSparseArray<Integer> longSparseArray = new LongSparseArray<>();
            int size = this.cAJ.size();
            for (int i3 = 0; i3 < size; i3++) {
                longSparseArray.put(this.cAJ.keyAt(i3), this.cAJ.valueAt(i3));
            }
            savedState.cCJ = longSparseArray;
        }
        savedState.cCH = this.cAH;
        return savedState;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.ajq = true;
        this.cCP = savedState.width;
        if (savedState.cCC >= 0) {
            this.cCQ = true;
            this.cBW = savedState;
            this.cCO = savedState.cCC;
            this.cCN = savedState.position;
            this.cCM = savedState.cCE;
            this.cCR = 0;
        } else if (savedState.cCD >= 0) {
            setSelectedPositionInt(-1);
            setNextSelectedPositionInt(-1);
            this.cAO = -1;
            this.cCQ = true;
            this.cBW = savedState;
            this.cCO = savedState.cCD;
            this.cCN = savedState.position;
            this.cCM = savedState.cCE;
            this.cCR = 1;
        }
        if (savedState.cCI != null) {
            this.cAI = savedState.cCI;
        }
        if (savedState.cCJ != null) {
            this.cAJ = savedState.cCJ;
        }
        this.cAH = savedState.cCH;
        if (Build.VERSION.SDK_INT >= 11 && savedState.cCG && this.cAE == 3 && this.cAG != null) {
            this.cAF = startActionMode((com.baidu.tieba.horizonalList.a.a.b) this.cAG);
        }
        requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onFocusChanged(boolean z, int i2, Rect rect) {
        super.onFocusChanged(z, i2, rect);
        if (z && this.cjm < 0 && !isInTouchMode()) {
            if (!this.cBT && this.mAdapter != null) {
                this.ajq = true;
                this.cCZ = this.cCY;
                this.cCY = this.mAdapter.getCount();
            }
            akw();
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (!this.cDg && !this.mInLayout) {
            super.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void akh() {
        removeAllViewsInLayout();
        this.cCL = 0;
        this.ajq = false;
        this.cBE = null;
        this.cCQ = false;
        this.cBW = null;
        this.cDb = -1;
        this.cDc = Long.MIN_VALUE;
        setSelectedPositionInt(-1);
        setNextSelectedPositionInt(-1);
        this.cBl = 0;
        this.cAO = -1;
        this.cAP.setEmpty();
        invalidate();
    }

    @Override // android.view.View
    protected int computeHorizontalScrollExtent() {
        int childCount = getChildCount();
        if (childCount > 0) {
            if (this.cBo) {
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
        int i3 = this.cCL;
        int childCount = getChildCount();
        if (i3 < 0 || childCount <= 0) {
            return 0;
        }
        if (this.cBo) {
            View childAt = getChildAt(0);
            int left = childAt.getLeft();
            int width = childAt.getWidth();
            if (width > 0) {
                return Math.max(((i3 * 100) - ((left * 100) / width)) + ((int) ((getScrollX() / getWidth()) * this.cCY * 100.0f)), 0);
            }
            return 0;
        }
        int i4 = this.cCY;
        if (i3 != 0) {
            i2 = i3 + childCount == i4 ? i4 : (childCount / 2) + i3;
        }
        return (int) (((i2 / i4) * childCount) + i3);
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        if (this.cBo) {
            int max = Math.max(this.cCY * 100, 0);
            if (getScrollX() != 0) {
                return max + Math.abs((int) ((getScrollX() / getWidth()) * this.cCY * 100.0f));
            }
            return max;
        }
        return this.cCY;
    }

    @Override // android.view.View
    protected float getLeftFadingEdgeStrength() {
        int childCount = getChildCount();
        float leftFadingEdgeStrength = super.getLeftFadingEdgeStrength();
        if (childCount != 0) {
            if (this.cCL > 0) {
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
            if ((this.cCL + childCount) - 1 < this.cCY - 1) {
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
        if (this.Hk == null) {
            akf();
        }
        Rect rect = this.cAV;
        rect.left = this.cAR + getPaddingLeft();
        rect.top = this.cAS + getPaddingTop();
        rect.right = this.cAT + getPaddingRight();
        rect.bottom = this.cAU + getPaddingBottom();
        if (this.cBz == 1) {
            int childCount = getChildCount();
            int width = getWidth() - getPaddingRight();
            View childAt = getChildAt(childCount - 1);
            this.cBN = childCount + this.cCL >= this.cBU && (childAt != null ? childAt.getRight() : width) <= width;
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
            this.cAQ.akC();
        }
        layoutChildren();
        this.mInLayout = false;
        this.cBs = (i4 - i2) / 3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void layoutChildren() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aki() {
        boolean z = true;
        if (this.cAX != null) {
            boolean z2 = this.cCL > 0;
            if (!z2 && getChildCount() > 0) {
                z2 = getChildAt(0).getLeft() < this.cAV.left;
            }
            this.cAX.setVisibility(z2 ? 0 : 4);
        }
        if (this.cAY != null) {
            int childCount = getChildCount();
            boolean z3 = this.cCL + childCount < this.cCY;
            if (z3 || childCount <= 0) {
                z = z3;
            } else if (getChildAt(childCount - 1).getRight() <= getRight() - this.cAV.right) {
                z = false;
            }
            this.cAY.setVisibility(z ? 0 : 4);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.g
    @ViewDebug.ExportedProperty
    public View getSelectedView() {
        if (this.cCY <= 0 || this.cjm < 0) {
            return null;
        }
        return getChildAt(this.cjm - this.cCL);
    }

    public int getListPaddingTop() {
        return this.cAV.top;
    }

    public int getListPaddingBottom() {
        return this.cAV.bottom;
    }

    public int getListPaddingLeft() {
        return this.cAV.left;
    }

    public int getListPaddingRight() {
        return this.cAV.right;
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
        View kk = this.cAQ.kk(i2);
        if (kk == null) {
            View kl = this.cAQ.kl(i2);
            if (kl != null) {
                view = this.mAdapter.getView(i2, kl, this);
                if (view != kl) {
                    this.cAQ.r(kl, i2);
                    if (this.cBA != 0) {
                        view.setDrawingCacheBackgroundColor(this.cBA);
                        kk = view;
                    }
                } else {
                    zArr[0] = true;
                    view.onFinishTemporaryDetach();
                    kk = view;
                }
                if (this.cAM) {
                    ViewGroup.LayoutParams layoutParams = kk.getLayoutParams();
                    if (layoutParams == null) {
                        fVar = (f) generateDefaultLayoutParams();
                    } else if (!checkLayoutParams(layoutParams)) {
                        fVar = (f) generateLayoutParams(layoutParams);
                    } else {
                        fVar = (f) layoutParams;
                    }
                    fVar.cCk = this.mAdapter.getItemId(i2);
                    kk.setLayoutParams(fVar);
                }
                if (this.cDa.isEnabled() && this.cBQ == null) {
                    this.cBQ = new g();
                }
            } else {
                view = this.mAdapter.getView(i2, null, this);
                if (this.cBA != 0) {
                    view.setDrawingCacheBackgroundColor(this.cBA);
                }
            }
            kk = view;
            if (this.cAM) {
            }
            if (this.cDa.isEnabled()) {
                this.cBQ = new g();
            }
        }
        return kk;
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
            this.cAO = i2;
        }
        Rect rect = this.cAP;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        if (view instanceof m) {
            ((m) view).adjustListItemSelectionBounds(rect);
        }
        j(rect.left, rect.top, rect.right, rect.bottom);
        boolean z = this.cBB;
        if (view.isEnabled() != z) {
            this.cBB = !z;
            if (getSelectedItemPosition() != -1) {
                refreshDrawableState();
            }
        }
    }

    private void j(int i2, int i3, int i4, int i5) {
        this.cAP.set(i2 - this.cAR, i3 - this.cAS, this.cAT + i4, this.cAU + i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        boolean z = this.cAN;
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
            this.ajq = true;
            akQ();
        }
    }

    boolean akj() {
        switch (this.cBg) {
            case 1:
            case 2:
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean akk() {
        return (hasFocus() && !isInTouchMode()) || akj();
    }

    private void e(Canvas canvas) {
        if (!this.cAP.isEmpty()) {
            Drawable drawable = this.Hk;
            drawable.setBounds(this.cAP);
            drawable.draw(canvas);
        }
    }

    public void setDrawSelectorOnTop(boolean z) {
        this.cAN = z;
    }

    public void setSelector(int i2) {
        setSelector(getResources().getDrawable(i2));
    }

    public void setSelector(Drawable drawable) {
        if (this.Hk != null) {
            this.Hk.setCallback(null);
            unscheduleDrawable(this.Hk);
        }
        this.Hk = drawable;
        Rect rect = new Rect();
        drawable.getPadding(rect);
        this.cAR = rect.left;
        this.cAS = rect.top;
        this.cAT = rect.right;
        this.cAU = rect.bottom;
        drawable.setCallback(this);
        akm();
    }

    public Drawable getSelector() {
        return this.Hk;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void akl() {
        if (isEnabled() && isClickable()) {
            Drawable drawable = this.Hk;
            Rect rect = this.cAP;
            if (drawable != null) {
                if ((isFocused() || akj()) && !rect.isEmpty()) {
                    View childAt = getChildAt(this.cjm - this.cCL);
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
                    if (isLongClickable && !this.ajq) {
                        if (this.cBw == null) {
                            this.cBw = new b(this, null);
                        }
                        this.cBw.akH();
                        postDelayed(this.cBw, ViewConfiguration.getLongPressTimeout());
                    }
                }
            }
        }
    }

    void akm() {
        if (this.Hk != null) {
            if (akk()) {
                this.Hk.setState(getDrawableState());
            } else {
                this.Hk.setState(cBX);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        akm();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i2) {
        if (this.cBB) {
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
        return this.Hk == drawable || super.verifyDrawable(drawable);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.Hk != null) {
            this.Hk.jumpToCurrentState();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnTouchModeChangeListener(this);
        if (this.mAdapter != null && this.cAL == null) {
            this.cAL = new a();
            this.mAdapter.registerDataSetObserver(this.cAL);
            this.ajq = true;
            this.cCZ = this.cCY;
            this.cCY = this.mAdapter.getCount();
        }
        this.cBT = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.g, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.cAQ.clear();
        getViewTreeObserver().removeOnTouchModeChangeListener(this);
        if (this.mAdapter != null && this.cAL != null) {
            this.mAdapter.unregisterDataSetObserver(this.cAL);
            this.cAL = null;
        }
        if (this.cBj != null) {
            removeCallbacks(this.cBj);
        }
        if (this.cBk != null) {
            this.cBk.stop();
        }
        if (this.cBD != null) {
            removeCallbacks(this.cBD);
        }
        if (this.cBx != null) {
            removeCallbacks(this.cBx);
        }
        if (this.cBy != null) {
            removeCallbacks(this.cBy);
            this.cBy = null;
        }
        this.cBT = false;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        int i2 = isInTouchMode() ? 0 : 1;
        if (!z) {
            setChildrenDrawingCacheEnabled(false);
            if (this.cBj != null) {
                removeCallbacks(this.cBj);
                this.cBj.akA();
                if (this.cBk != null) {
                    this.cBk.stop();
                }
                if (getScrollX() != 0) {
                    this.cAD.setScrollX(0);
                    aky();
                    invalidate();
                }
            }
            if (i2 == 1) {
                this.cBq = this.cjm;
            }
        } else if (i2 != this.cBt && this.cBt != -1) {
            if (i2 == 1) {
                akw();
            } else {
                akt();
                this.cAK = 0;
                layoutChildren();
            }
        }
        this.cBt = i2;
    }

    ContextMenu.ContextMenuInfo b(View view, int i2, long j2) {
        return new g.a(view, i2, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class n {
        private int cCK;

        private n() {
        }

        /* synthetic */ n(AbsHListView absHListView, n nVar) {
            this();
        }

        public void akH() {
            this.cCK = AbsHListView.this.getWindowAttachCount();
        }

        public boolean akI() {
            return AbsHListView.this.hasWindowFocus() && AbsHListView.this.getWindowAttachCount() == this.cCK;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class i extends n implements Runnable {
        int cCl;

        private i() {
            super(AbsHListView.this, null);
        }

        /* synthetic */ i(AbsHListView absHListView, i iVar) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            View childAt;
            if (!AbsHListView.this.ajq) {
                ListAdapter listAdapter = AbsHListView.this.mAdapter;
                int i = this.cCl;
                if (listAdapter != null && AbsHListView.this.cCY > 0 && i != -1 && i < listAdapter.getCount() && akI() && (childAt = AbsHListView.this.getChildAt(i - AbsHListView.this.cCL)) != null) {
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
            View childAt = AbsHListView.this.getChildAt(AbsHListView.this.cBb - AbsHListView.this.cCL);
            if (childAt != null) {
                if ((!akI() || AbsHListView.this.ajq) ? false : AbsHListView.this.c(childAt, AbsHListView.this.cBb, AbsHListView.this.mAdapter.getItemId(AbsHListView.this.cBb))) {
                    AbsHListView.this.cBg = -1;
                    AbsHListView.this.setPressed(false);
                    childAt.setPressed(false);
                    return;
                }
                AbsHListView.this.cBg = 2;
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
            if (AbsHListView.this.isPressed() && AbsHListView.this.cjm >= 0) {
                View childAt = AbsHListView.this.getChildAt(AbsHListView.this.cjm - AbsHListView.this.cCL);
                if (!AbsHListView.this.ajq) {
                    if (akI() ? AbsHListView.this.c(childAt, AbsHListView.this.cjm, AbsHListView.this.cCX) : false) {
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
        if (Build.VERSION.SDK_INT >= 11 && this.cAE == 3) {
            if (this.cAF == null) {
                ActionMode startActionMode = startActionMode((com.baidu.tieba.horizonalList.a.a.b) this.cAG);
                this.cAF = startActionMode;
                if (startActionMode != null) {
                    setItemChecked(i2, true);
                    performHapticFeedback(0);
                }
            }
            return true;
        }
        boolean b2 = this.cCU != null ? this.cCU.b(this, view, i2, j2) : false;
        if (!b2) {
            this.cBr = b(view, i2, j2);
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
        return this.cBr;
    }

    public boolean a(float f2, float f3, int i2) {
        int pointToPosition = pointToPosition((int) f2, (int) f3);
        if (pointToPosition != -1) {
            long itemId = this.mAdapter.getItemId(pointToPosition);
            View childAt = getChildAt(pointToPosition - this.cCL);
            if (childAt != null) {
                this.cBr = b(childAt, pointToPosition, itemId);
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
            boolean b2 = this.cCU != null ? this.cCU.b(this, view, positionForView, itemId) : false;
            if (!b2) {
                this.cBr = b(getChildAt(positionForView - this.cCL), positionForView, itemId);
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
                if (isClickable() && isPressed() && this.cjm >= 0 && this.mAdapter != null && this.cjm < this.mAdapter.getCount()) {
                    View childAt = getChildAt(this.cjm - this.cCL);
                    if (childAt != null) {
                        performItemClick(childAt, this.cjm, this.cCX);
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
        Rect rect = this.cBp;
        if (rect == null) {
            this.cBp = new Rect();
            rect = this.cBp;
        }
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt.getVisibility() == 0) {
                childAt.getHitRect(rect);
                if (rect.contains(i2, i3)) {
                    return this.cCL + childCount;
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
            if (AbsHListView.this.cBg == 0) {
                AbsHListView.this.cBg = 1;
                View childAt = AbsHListView.this.getChildAt(AbsHListView.this.cBb - AbsHListView.this.cCL);
                if (childAt != null && !childAt.hasFocusable()) {
                    AbsHListView.this.cAK = 0;
                    if (!AbsHListView.this.ajq) {
                        childAt.setPressed(true);
                        AbsHListView.this.setPressed(true);
                        AbsHListView.this.layoutChildren();
                        AbsHListView.this.c(AbsHListView.this.cBb, childAt);
                        AbsHListView.this.refreshDrawableState();
                        int longPressTimeout = ViewConfiguration.getLongPressTimeout();
                        boolean isLongClickable = AbsHListView.this.isLongClickable();
                        if (AbsHListView.this.Hk != null && (current = AbsHListView.this.Hk.getCurrent()) != null && (current instanceof TransitionDrawable)) {
                            if (isLongClickable) {
                                ((TransitionDrawable) current).startTransition(longPressTimeout);
                            } else {
                                ((TransitionDrawable) current).resetTransition();
                            }
                        }
                        if (isLongClickable) {
                            if (AbsHListView.this.cBu == null) {
                                AbsHListView.this.cBu = new c(AbsHListView.this, null);
                            }
                            AbsHListView.this.cBu.akH();
                            AbsHListView.this.postDelayed(AbsHListView.this.cBu, longPressTimeout);
                            return;
                        }
                        AbsHListView.this.cBg = 2;
                        return;
                    }
                    AbsHListView.this.cBg = 2;
                }
            }
        }
    }

    private boolean jY(int i2) {
        int i3 = i2 - this.cBe;
        int abs = Math.abs(i3);
        boolean z = getScrollX() != 0;
        if (z || abs > this.mTouchSlop) {
            akr();
            if (z) {
                this.cBg = 5;
                this.cBi = 0;
            } else {
                this.cBg = 3;
                this.cBi = i3 > 0 ? this.mTouchSlop : -this.mTouchSlop;
            }
            Handler handler = getHandler();
            if (handler != null) {
                handler.removeCallbacks(this.cBu);
            }
            setPressed(false);
            View childAt = getChildAt(this.cBb - this.cCL);
            if (childAt != null) {
                childAt.setPressed(false);
            }
            ka(1);
            ViewParent parent = getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            jZ(i2);
            return true;
        }
        return false;
    }

    private void jZ(int i2) {
        int i3;
        int childCount;
        ViewParent parent;
        int i4 = i2 - this.cBe;
        int i5 = i4 - this.cBi;
        int i6 = this.cBh != Integer.MIN_VALUE ? i2 - this.cBh : i5;
        if (this.cBg == 3) {
            if (i2 != this.cBh) {
                if (Math.abs(i4) > this.mTouchSlop && (parent = getParent()) != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
                if (this.cBb >= 0) {
                    childCount = this.cBb - this.cCL;
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
                        overScrollBy(i7, 0, getScrollX(), 0, 0, 0, this.cBH, 0, true);
                        if (Math.abs(this.cBH) == Math.abs(getScrollX()) && this.mVelocityTracker != null) {
                            this.mVelocityTracker.clear();
                        }
                        int overScrollMode = getOverScrollMode();
                        if (overScrollMode == 0 || (overScrollMode == 1 && !akd())) {
                            this.mDirection = 0;
                            this.cBg = 5;
                            if (i4 > 0) {
                                this.cBJ.onPull(i7 / getWidth());
                                if (!this.cBK.isFinished()) {
                                    this.cBK.onRelease();
                                }
                                invalidate();
                            } else if (i4 < 0) {
                                this.cBK.onPull(i7 / getWidth());
                                if (!this.cBJ.isFinished()) {
                                    this.cBJ.onRelease();
                                }
                                invalidate();
                            }
                        }
                    }
                    this.cBe = i2;
                }
                this.cBh = i2;
            }
        } else if (this.cBg == 5 && i2 != this.cBh) {
            int scrollX = getScrollX();
            int i8 = scrollX - i6;
            int i9 = i2 > this.cBh ? 1 : -1;
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
                overScrollBy(i10, 0, getScrollX(), 0, 0, 0, this.cBH, 0, true);
                int overScrollMode2 = getOverScrollMode();
                if (overScrollMode2 == 0 || (overScrollMode2 == 1 && !akd())) {
                    if (i4 > 0) {
                        this.cBJ.onPull(i10 / getWidth());
                        if (!this.cBK.isFinished()) {
                            this.cBK.onRelease();
                        }
                        invalidate();
                    } else if (i4 < 0) {
                        this.cBK.onPull(i10 / getWidth());
                        if (!this.cBJ.isFinished()) {
                            this.cBJ.onRelease();
                        }
                        invalidate();
                    }
                }
            }
            if (i3 != 0) {
                if (getScrollX() != 0) {
                    this.cAD.setScrollX(0);
                    akn();
                }
                ay(i3, i3);
                this.cBg = 3;
                int kd = kd(i2);
                this.cBi = 0;
                View childAt3 = getChildAt(kd - this.cCL);
                this.cBc = childAt3 != null ? childAt3.getLeft() : 0;
                this.cBe = i2;
                this.cBb = kd;
            }
            this.cBh = i2;
            this.mDirection = i9;
        }
    }

    protected void akn() {
        if (this.cAD.isHardwareAccelerated() && (getParent() instanceof View)) {
            ((View) getParent()).invalidate();
        }
    }

    @Override // android.view.ViewTreeObserver.OnTouchModeChangeListener
    public void onTouchModeChanged(boolean z) {
        if (z) {
            akt();
            if (getWidth() > 0 && getChildCount() > 0) {
                layoutChildren();
            }
            akm();
            return;
        }
        int i2 = this.cBg;
        if (i2 == 5 || i2 == 6) {
            if (this.cBj != null) {
                this.cBj.akA();
            }
            if (this.cBk != null) {
                this.cBk.stop();
            }
            if (getScrollX() != 0) {
                this.cAD.setScrollX(0);
                aky();
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
        if (this.cBk != null) {
            this.cBk.stop();
        }
        if (this.cBT) {
            int action = motionEvent.getAction();
            akp();
            this.mVelocityTracker.addMovement(motionEvent);
            switch (action & MotionEventCompat.ACTION_MASK) {
                case 0:
                    switch (this.cBg) {
                        case 6:
                            this.cBj.akA();
                            if (this.cBk != null) {
                                this.cBk.stop();
                            }
                            this.cBg = 5;
                            this.cBf = (int) motionEvent.getY();
                            int x = (int) motionEvent.getX();
                            this.cBh = x;
                            this.cBe = x;
                            this.cBi = 0;
                            this.mActivePointerId = motionEvent.getPointerId(0);
                            this.mDirection = 0;
                            break;
                        default:
                            this.mActivePointerId = motionEvent.getPointerId(0);
                            int x2 = (int) motionEvent.getX();
                            int y = (int) motionEvent.getY();
                            int pointToPosition = pointToPosition(x2, y);
                            if (!this.ajq) {
                                if (this.cBg != 4 && pointToPosition >= 0 && getAdapter().isEnabled(pointToPosition)) {
                                    this.cBg = 0;
                                    if (this.cBv == null) {
                                        this.cBv = new d();
                                    }
                                    postDelayed(this.cBv, ViewConfiguration.getTapTimeout());
                                    i2 = pointToPosition;
                                } else if (this.cBg == 4) {
                                    akr();
                                    this.cBg = 3;
                                    this.cBi = 0;
                                    i2 = kc(x2);
                                    this.cBj.akB();
                                }
                                if (i2 >= 0) {
                                    this.cBc = getChildAt(i2 - this.cCL).getLeft();
                                }
                                this.cBe = x2;
                                this.cBf = y;
                                this.cBb = i2;
                                this.cBh = ExploreByTouchHelper.INVALID_ID;
                                break;
                            }
                            i2 = pointToPosition;
                            if (i2 >= 0) {
                            }
                            this.cBe = x2;
                            this.cBf = y;
                            this.cBb = i2;
                            this.cBh = ExploreByTouchHelper.INVALID_ID;
                    }
                    if (o(motionEvent) && this.cBg == 0) {
                        removeCallbacks(this.cBv);
                        break;
                    }
                    break;
                case 1:
                    switch (this.cBg) {
                        case 0:
                        case 1:
                        case 2:
                            int i3 = this.cBb;
                            View childAt = getChildAt(i3 - this.cCL);
                            float x3 = motionEvent.getX();
                            boolean z = x3 > ((float) this.cAV.left) && x3 < ((float) (getWidth() - this.cAV.right));
                            if (childAt != null && !childAt.hasFocusable() && z) {
                                if (this.cBg != 0) {
                                    childAt.setPressed(false);
                                }
                                if (this.cBx == null) {
                                    this.cBx = new i(this, null);
                                }
                                i iVar = this.cBx;
                                iVar.cCl = i3;
                                iVar.akH();
                                this.cBq = i3;
                                if (this.cBg == 0 || this.cBg == 1) {
                                    Handler handler = getHandler();
                                    if (handler != null) {
                                        handler.removeCallbacks(this.cBg == 0 ? this.cBv : this.cBu);
                                    }
                                    this.cAK = 0;
                                    if (!this.ajq && this.mAdapter.isEnabled(i3)) {
                                        this.cBg = 1;
                                        setSelectedPositionInt(this.cBb);
                                        layoutChildren();
                                        childAt.setPressed(true);
                                        c(this.cBb, childAt);
                                        setPressed(true);
                                        if (this.Hk != null && (current = this.Hk.getCurrent()) != null && (current instanceof TransitionDrawable)) {
                                            ((TransitionDrawable) current).resetTransition();
                                        }
                                        if (this.cBy != null) {
                                            removeCallbacks(this.cBy);
                                        }
                                        this.cBy = new com.baidu.tieba.horizonalList.widget.a(this, childAt, iVar);
                                        postDelayed(this.cBy, ViewConfiguration.getPressedStateDuration());
                                    } else {
                                        this.cBg = -1;
                                        akm();
                                    }
                                    return true;
                                } else if (!this.ajq && this.mAdapter.isEnabled(i3)) {
                                    iVar.run();
                                }
                            }
                            this.cBg = -1;
                            akm();
                            break;
                        case 3:
                            int childCount = getChildCount();
                            if (childCount > 0) {
                                int left = getChildAt(0).getLeft();
                                int right = getChildAt(childCount - 1).getRight();
                                int i4 = this.cAV.left;
                                int width = getWidth() - this.cAV.right;
                                if (this.cCL == 0 && left >= i4 && this.cCL + childCount < this.cCY && right <= getWidth() - width) {
                                    this.cBg = -1;
                                    ka(0);
                                    break;
                                } else {
                                    VelocityTracker velocityTracker = this.mVelocityTracker;
                                    velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                                    int xVelocity = (int) (velocityTracker.getXVelocity(this.mActivePointerId) * this.cBF);
                                    if (Math.abs(xVelocity) > this.mMinimumVelocity && ((this.cCL != 0 || left != i4 - this.cBH) && (childCount + this.cCL != this.cCY || right != this.cBH + width))) {
                                        if (this.cBj == null) {
                                            this.cBj = new e();
                                        }
                                        ka(2);
                                        this.cBj.ke(-xVelocity);
                                        break;
                                    } else {
                                        this.cBg = -1;
                                        ka(0);
                                        if (this.cBj != null) {
                                            this.cBj.akA();
                                        }
                                        if (this.cBk != null) {
                                            this.cBk.stop();
                                            break;
                                        }
                                    }
                                }
                            } else {
                                this.cBg = -1;
                                ka(0);
                                break;
                            }
                            break;
                        case 5:
                            if (this.cBj == null) {
                                this.cBj = new e();
                            }
                            VelocityTracker velocityTracker2 = this.mVelocityTracker;
                            velocityTracker2.computeCurrentVelocity(1000, this.mMaximumVelocity);
                            int xVelocity2 = (int) velocityTracker2.getXVelocity(this.mActivePointerId);
                            ka(2);
                            if (Math.abs(xVelocity2) > this.mMinimumVelocity) {
                                this.cBj.kf(-xVelocity2);
                                break;
                            } else {
                                this.cBj.akz();
                                break;
                            }
                    }
                    setPressed(false);
                    if (this.cBJ != null) {
                        this.cBJ.onRelease();
                        this.cBK.onRelease();
                    }
                    invalidate();
                    Handler handler2 = getHandler();
                    if (handler2 != null) {
                        handler2.removeCallbacks(this.cBu);
                    }
                    akq();
                    this.mActivePointerId = -1;
                    break;
                case 2:
                    int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                    if (findPointerIndex == -1) {
                        this.mActivePointerId = motionEvent.getPointerId(0);
                        findPointerIndex = 0;
                    }
                    int x4 = (int) motionEvent.getX(findPointerIndex);
                    if (this.ajq) {
                        layoutChildren();
                    }
                    switch (this.cBg) {
                        case 0:
                        case 1:
                        case 2:
                            jY(x4);
                            break;
                        case 3:
                        case 5:
                            jZ(x4);
                            break;
                    }
                case 3:
                    switch (this.cBg) {
                        case 5:
                            if (this.cBj == null) {
                                this.cBj = new e();
                            }
                            this.cBj.akz();
                            break;
                        case 6:
                            break;
                        default:
                            this.cBg = -1;
                            setPressed(false);
                            View childAt2 = getChildAt(this.cBb - this.cCL);
                            if (childAt2 != null) {
                                childAt2.setPressed(false);
                            }
                            aks();
                            Handler handler3 = getHandler();
                            if (handler3 != null) {
                                handler3.removeCallbacks(this.cBu);
                            }
                            akq();
                            break;
                    }
                    if (this.cBJ != null) {
                        this.cBJ.onRelease();
                        this.cBK.onRelease();
                    }
                    this.mActivePointerId = -1;
                    break;
                case 5:
                    int actionIndex = motionEvent.getActionIndex();
                    int pointerId = motionEvent.getPointerId(actionIndex);
                    int x5 = (int) motionEvent.getX(actionIndex);
                    int y2 = (int) motionEvent.getY(actionIndex);
                    this.cBi = 0;
                    this.mActivePointerId = pointerId;
                    this.cBe = x5;
                    this.cBf = y2;
                    int pointToPosition2 = pointToPosition(x5, y2);
                    if (pointToPosition2 >= 0) {
                        this.cBc = getChildAt(pointToPosition2 - this.cCL).getLeft();
                        this.cBb = pointToPosition2;
                    }
                    this.cBh = x5;
                    break;
                case 6:
                    onSecondaryPointerUp(motionEvent);
                    int i5 = this.cBe;
                    int pointToPosition3 = pointToPosition(i5, this.cBf);
                    if (pointToPosition3 >= 0) {
                        this.cBc = getChildAt(pointToPosition3 - this.cCL).getLeft();
                        this.cBb = pointToPosition3;
                    }
                    this.cBh = i5;
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
            this.cAD.setScrollX(i2);
            akn();
            awakenScrollBars();
        }
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) != 0) {
            switch (motionEvent.getAction()) {
                case 8:
                    if (this.cBg == -1) {
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
        if (this.cBY == 0.0f) {
            TypedValue typedValue = new TypedValue();
            if (getContext().getTheme().resolveAttribute(w.c.hlv_listPreferredItemWidth, typedValue, true)) {
                this.cBY = typedValue.getDimension(getContext().getResources().getDisplayMetrics());
            }
        }
        return this.cBY;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.cBJ != null) {
            int scrollX = getScrollX();
            if (!this.cBJ.isFinished()) {
                int save = canvas.save();
                int i2 = this.cAV.top + this.cBO;
                int height = (getHeight() - i2) - (this.cAV.bottom + this.cBP);
                int min = Math.min(0, this.cBL + scrollX);
                canvas.rotate(-90.0f);
                canvas.translate(i2 + (-getHeight()), min);
                this.cBJ.setSize(height, height);
                if (this.cBJ.draw(canvas)) {
                    invalidate();
                }
                canvas.restoreToCount(save);
            }
            if (!this.cBK.isFinished()) {
                int save2 = canvas.save();
                int i3 = this.cAV.left + this.cBO;
                int height2 = (getHeight() - i3) - (this.cAV.right + this.cBP);
                int max = Math.max(getWidth(), scrollX + this.cBM);
                canvas.rotate(90.0f);
                canvas.translate(-i3, -max);
                this.cBK.setSize(height2, height2);
                if (this.cBK.draw(canvas)) {
                    invalidate();
                }
                canvas.restoreToCount(save2);
            }
        }
    }

    private void ako() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        } else {
            this.mVelocityTracker.clear();
        }
    }

    private void akp() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
    }

    private void akq() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            akq();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.cBk != null) {
            this.cBk.stop();
        }
        if (this.cBT) {
            switch (action & MotionEventCompat.ACTION_MASK) {
                case 0:
                    int i2 = this.cBg;
                    if (i2 == 6 || i2 == 5) {
                        this.cBi = 0;
                        return true;
                    }
                    int x = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();
                    this.mActivePointerId = motionEvent.getPointerId(0);
                    int kc = kc(x);
                    if (i2 != 4 && kc >= 0) {
                        this.cBc = getChildAt(kc - this.cCL).getLeft();
                        this.cBe = x;
                        this.cBf = y;
                        this.cBb = kc;
                        this.cBg = 0;
                        aks();
                    }
                    this.cBh = ExploreByTouchHelper.INVALID_ID;
                    ako();
                    this.mVelocityTracker.addMovement(motionEvent);
                    return i2 == 4;
                case 1:
                case 3:
                    this.cBg = -1;
                    this.mActivePointerId = -1;
                    akq();
                    ka(0);
                    return false;
                case 2:
                    switch (this.cBg) {
                        case 0:
                            int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                            if (findPointerIndex == -1) {
                                this.mActivePointerId = motionEvent.getPointerId(0);
                                findPointerIndex = 0;
                            }
                            akp();
                            this.mVelocityTracker.addMovement(motionEvent);
                            return jY((int) motionEvent.getX(findPointerIndex));
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
            this.cBe = (int) motionEvent.getX(i2);
            this.cBf = (int) motionEvent.getY(i2);
            this.cBi = 0;
            this.mActivePointerId = motionEvent.getPointerId(i2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        int childCount = getChildCount();
        int i2 = this.cCL;
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
    public void ka(int i2) {
        if (i2 != this.cBC && this.cBn != null) {
            this.cBC = i2;
            this.cBn.a(this, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e implements Runnable {
        private final o cCc;
        private int cCd;
        private final Runnable cCe = new com.baidu.tieba.horizonalList.widget.c(this);

        e() {
            this.cCc = new o(AbsHListView.this.getContext());
        }

        void ke(int i) {
            int i2 = i < 0 ? Integer.MAX_VALUE : 0;
            this.cCd = i2;
            this.cCc.setInterpolator(null);
            this.cCc.fling(i2, 0, i, 0, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
            AbsHListView.this.cBg = 4;
            AbsHListView.this.cAD.i(this);
        }

        void akz() {
            if (this.cCc.springBack(AbsHListView.this.getScrollX(), 0, 0, 0, 0, 0)) {
                AbsHListView.this.cBg = 6;
                AbsHListView.this.invalidate();
                AbsHListView.this.cAD.i(this);
                return;
            }
            AbsHListView.this.cBg = -1;
            AbsHListView.this.ka(0);
        }

        void kf(int i) {
            this.cCc.setInterpolator(null);
            this.cCc.fling(AbsHListView.this.getScrollX(), 0, i, 0, ExploreByTouchHelper.INVALID_ID, Integer.MAX_VALUE, 0, 0, AbsHListView.this.getWidth(), 0);
            AbsHListView.this.cBg = 6;
            AbsHListView.this.invalidate();
            AbsHListView.this.cAD.i(this);
        }

        void kg(int i) {
            this.cCc.notifyHorizontalEdgeReached(AbsHListView.this.getScrollX(), 0, AbsHListView.this.cBI);
            int overScrollMode = AbsHListView.this.getOverScrollMode();
            if (overScrollMode == 0 || (overScrollMode == 1 && !AbsHListView.this.akd())) {
                AbsHListView.this.cBg = 6;
                int currVelocity = (int) this.cCc.getCurrVelocity();
                if (i > 0) {
                    AbsHListView.this.cBJ.onAbsorb(currVelocity);
                } else {
                    AbsHListView.this.cBK.onAbsorb(currVelocity);
                }
            } else {
                AbsHListView.this.cBg = -1;
                if (AbsHListView.this.cBk != null) {
                    AbsHListView.this.cBk.stop();
                }
            }
            AbsHListView.this.invalidate();
            AbsHListView.this.cAD.i(this);
        }

        void d(int i, int i2, boolean z) {
            int i3 = i < 0 ? Integer.MAX_VALUE : 0;
            this.cCd = i3;
            this.cCc.setInterpolator(z ? AbsHListView.cBV : null);
            this.cCc.startScroll(i3, 0, i, 0, i2);
            AbsHListView.this.cBg = 4;
            AbsHListView.this.cAD.i(this);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void akA() {
            AbsHListView.this.cBg = -1;
            AbsHListView.this.removeCallbacks(this);
            AbsHListView.this.removeCallbacks(this.cCe);
            AbsHListView.this.ka(0);
            AbsHListView.this.aks();
            this.cCc.abortAnimation();
            AbsHListView.this.overScrollBy(0, 0, 0, 0, 0, 0, 0, 0, false);
        }

        void akB() {
            AbsHListView.this.postDelayed(this.cCe, 40L);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // java.lang.Runnable
        public void run() {
            int max;
            boolean z = true;
            boolean z2 = false;
            switch (AbsHListView.this.cBg) {
                case 3:
                    if (this.cCc.isFinished()) {
                        return;
                    }
                    break;
                case 4:
                    break;
                case 5:
                default:
                    akA();
                    return;
                case 6:
                    o oVar = this.cCc;
                    if (oVar.computeScrollOffset()) {
                        int scrollX = AbsHListView.this.getScrollX();
                        int currX = oVar.getCurrX();
                        if (AbsHListView.this.overScrollBy(currX - scrollX, 0, scrollX, 0, 0, 0, AbsHListView.this.cBI, 0, false)) {
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
                                ke(currVelocity);
                                return;
                            }
                            akz();
                            return;
                        }
                        AbsHListView.this.invalidate();
                        AbsHListView.this.cAD.i(this);
                        return;
                    }
                    akA();
                    return;
            }
            if (AbsHListView.this.ajq) {
                AbsHListView.this.layoutChildren();
            }
            if (AbsHListView.this.cCY == 0 || AbsHListView.this.getChildCount() == 0) {
                akA();
                return;
            }
            o oVar2 = this.cCc;
            boolean computeScrollOffset = oVar2.computeScrollOffset();
            int currX2 = oVar2.getCurrX();
            int i = this.cCd - currX2;
            if (i > 0) {
                AbsHListView.this.cBb = AbsHListView.this.cCL;
                AbsHListView.this.cBc = AbsHListView.this.getChildAt(0).getLeft();
                max = Math.min(((AbsHListView.this.getWidth() - AbsHListView.this.getPaddingRight()) - AbsHListView.this.getPaddingLeft()) - 1, i);
            } else {
                int childCount = AbsHListView.this.getChildCount() - 1;
                AbsHListView.this.cBb = AbsHListView.this.cCL + childCount;
                AbsHListView.this.cBc = AbsHListView.this.getChildAt(childCount).getLeft();
                max = Math.max(-(((AbsHListView.this.getWidth() - AbsHListView.this.getPaddingRight()) - AbsHListView.this.getPaddingLeft()) - 1), i);
            }
            View childAt = AbsHListView.this.getChildAt(AbsHListView.this.cBb - AbsHListView.this.cCL);
            int left = childAt != null ? childAt.getLeft() : 0;
            boolean ay = AbsHListView.this.ay(max, max);
            if (!ay || max == 0) {
                z = false;
            }
            if (z) {
                if (childAt != null) {
                    AbsHListView.this.overScrollBy(-(max - (childAt.getLeft() - left)), 0, AbsHListView.this.getScrollX(), 0, 0, 0, AbsHListView.this.cBI, 0, false);
                }
                if (computeScrollOffset) {
                    kg(max);
                }
            } else if (computeScrollOffset && !z) {
                if (ay) {
                    AbsHListView.this.invalidate();
                }
                this.cCd = currX2;
                AbsHListView.this.cAD.i(this);
            } else {
                akA();
            }
        }
    }

    /* loaded from: classes.dex */
    public class j implements Runnable {
        private int cCm;
        private int cCn;
        private int cCo;
        private int cCp;
        private final int cCq;
        private int cCr;
        private int mMode;

        j() {
            this.cCq = ViewConfiguration.get(AbsHListView.this.getContext()).getScaledFadingEdgeLength();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void ke(int i) {
            int i2;
            stop();
            if (AbsHListView.this.ajq) {
                AbsHListView.this.cBE = new com.baidu.tieba.horizonalList.widget.d(this, i);
                return;
            }
            int childCount = AbsHListView.this.getChildCount();
            if (childCount != 0) {
                int i3 = AbsHListView.this.cCL;
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
                    this.cCp = 200 / i2;
                } else {
                    this.cCp = 200;
                }
                this.cCm = max;
                this.cCn = -1;
                this.cCo = -1;
                AbsHListView.this.cAD.i(this);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void aA(int i, int i2) {
            int i3;
            stop();
            if (i2 == -1) {
                ke(i);
            } else if (AbsHListView.this.ajq) {
                AbsHListView.this.cBE = new com.baidu.tieba.horizonalList.widget.e(this, i, i2);
            } else {
                int childCount = AbsHListView.this.getChildCount();
                if (childCount != 0) {
                    int i4 = AbsHListView.this.cCL;
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
                        this.cCp = 200 / i3;
                    } else {
                        this.cCp = 200;
                    }
                    this.cCm = max;
                    this.cCn = i2;
                    this.cCo = -1;
                    AbsHListView.this.cAD.i(this);
                }
            }
        }

        void w(int i, int i2, int i3) {
            int i4 = AbsHListView.this.cCL;
            int childCount = (AbsHListView.this.getChildCount() + i4) - 1;
            int i5 = AbsHListView.this.cAV.left;
            int width = AbsHListView.this.getWidth() - AbsHListView.this.cAV.right;
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
            int i2 = AbsHListView.this.cCL;
            switch (this.mMode) {
                case 1:
                    int childCount = AbsHListView.this.getChildCount() - 1;
                    int i3 = i2 + childCount;
                    if (childCount >= 0) {
                        if (i3 == this.cCo) {
                            AbsHListView.this.cAD.i(this);
                            return;
                        }
                        View childAt = AbsHListView.this.getChildAt(childCount);
                        AbsHListView.this.c((i3 < AbsHListView.this.cCY + (-1) ? Math.max(AbsHListView.this.cAV.right, this.cCq) : AbsHListView.this.cAV.right) + (childAt.getWidth() - (width - childAt.getLeft())), this.cCp, true);
                        this.cCo = i3;
                        if (i3 < this.cCm) {
                            AbsHListView.this.cAD.i(this);
                            return;
                        }
                        return;
                    }
                    return;
                case 2:
                    if (i2 == this.cCo) {
                        AbsHListView.this.cAD.i(this);
                        return;
                    }
                    View childAt2 = AbsHListView.this.getChildAt(0);
                    if (childAt2 != null) {
                        AbsHListView.this.c(childAt2.getLeft() - (i2 > 0 ? Math.max(this.cCq, AbsHListView.this.cAV.left) : AbsHListView.this.cAV.left), this.cCp, true);
                        this.cCo = i2;
                        if (i2 > this.cCm) {
                            AbsHListView.this.cAD.i(this);
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    int childCount2 = AbsHListView.this.getChildCount();
                    if (i2 != this.cCn && childCount2 > 1 && childCount2 + i2 < AbsHListView.this.cCY) {
                        int i4 = i2 + 1;
                        if (i4 == this.cCo) {
                            AbsHListView.this.cAD.i(this);
                            return;
                        }
                        View childAt3 = AbsHListView.this.getChildAt(1);
                        int width2 = childAt3.getWidth();
                        int left2 = childAt3.getLeft();
                        int max = Math.max(AbsHListView.this.cAV.right, this.cCq);
                        if (i4 < this.cCn) {
                            AbsHListView.this.c(Math.max(0, (left2 + width2) - max), this.cCp, true);
                            this.cCo = i4;
                            AbsHListView.this.cAD.i(this);
                            return;
                        } else if (left2 > max) {
                            AbsHListView.this.c(left2 - max, this.cCp, true);
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
                        if (i5 == this.cCo) {
                            AbsHListView.this.cAD.i(this);
                            return;
                        }
                        View childAt4 = AbsHListView.this.getChildAt(childCount3);
                        int width3 = childAt4.getWidth();
                        int left3 = childAt4.getLeft();
                        int i6 = width - left3;
                        int max2 = Math.max(AbsHListView.this.cAV.left, this.cCq);
                        this.cCo = i5;
                        if (i5 > this.cCn) {
                            AbsHListView.this.c(-(i6 - max2), this.cCp, true);
                            AbsHListView.this.cAD.i(this);
                            return;
                        }
                        int i7 = width - max2;
                        int i8 = left3 + width3;
                        if (i7 > i8) {
                            AbsHListView.this.c(-(i7 - i8), this.cCp, true);
                            return;
                        }
                        return;
                    }
                    return;
                case 5:
                    if (this.cCo == i2) {
                        AbsHListView.this.cAD.i(this);
                        return;
                    }
                    this.cCo = i2;
                    int childCount4 = AbsHListView.this.getChildCount();
                    int i9 = this.cCm;
                    int i10 = (i2 + childCount4) - 1;
                    if (i9 < i2) {
                        i = (i2 - i9) + 1;
                    } else if (i9 > i10) {
                        i = i9 - i10;
                    }
                    float min = Math.min(Math.abs(i / childCount4), 1.0f);
                    if (i9 < i2) {
                        AbsHListView.this.c((int) ((-AbsHListView.this.getWidth()) * min), (int) (min * this.cCp), true);
                        AbsHListView.this.cAD.i(this);
                        return;
                    } else if (i9 > i10) {
                        AbsHListView.this.c((int) (AbsHListView.this.getWidth() * min), (int) (min * this.cCp), true);
                        AbsHListView.this.cAD.i(this);
                        return;
                    } else {
                        AbsHListView.this.c(AbsHListView.this.getChildAt(i9 - i2).getLeft() - this.cCr, (int) (this.cCp * (Math.abs(left) / AbsHListView.this.getWidth())), true);
                        return;
                    }
                default:
                    return;
            }
        }
    }

    public void setFriction(float f2) {
        if (this.cBj == null) {
            this.cBj = new e();
        }
        this.cBj.cCc.setFriction(f2);
    }

    public void setVelocityScale(float f2) {
        this.cBF = f2;
    }

    public void smoothScrollToPosition(int i2, int i3) {
        if (this.cBk == null) {
            this.cBk = new j();
        }
        this.cBk.aA(i2, i3);
    }

    public void smoothScrollBy(int i2, int i3) {
        c(i2, i3, false);
    }

    public void c(int i2, int i3, boolean z) {
        if (this.cBj == null) {
            this.cBj = new e();
        }
        int i4 = this.cCL;
        int childCount = getChildCount();
        int i5 = i4 + childCount;
        int paddingLeft = getPaddingLeft();
        int width = getWidth() - getPaddingRight();
        if (i2 == 0 || this.cCY == 0 || childCount == 0 || ((i4 == 0 && getChildAt(0).getLeft() == paddingLeft && i2 < 0) || (i5 == this.cCY && getChildAt(childCount - 1).getRight() == width && i2 > 0))) {
            this.cBj.akA();
            if (this.cBk != null) {
                this.cBk.stop();
                return;
            }
            return;
        }
        ka(2);
        this.cBj.d(i2, i3, z);
    }

    private void akr() {
        if (this.mScrollingCacheEnabled && !this.cAZ && !this.cAD.isHardwareAccelerated()) {
            setChildrenDrawnWithCacheEnabled(true);
            setChildrenDrawingCacheEnabled(true);
            this.cBa = true;
            this.cAZ = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aks() {
        if (!this.cAD.isHardwareAccelerated()) {
            if (this.cBD == null) {
                this.cBD = new com.baidu.tieba.horizonalList.widget.b(this);
            }
            post(this.cBD);
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
        Rect rect = this.cAV;
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
        int i6 = this.cCL;
        if (i6 == 0) {
            this.cBL = left - rect.left;
        } else {
            this.cBL += min2;
        }
        if (i6 + childCount == this.cCY) {
            this.cBM = rect.right + right;
        } else {
            this.cBM += min2;
        }
        boolean z = i6 == 0 && left >= rect.left && min2 >= 0;
        boolean z2 = i6 + childCount == this.cCY && right <= getWidth() - rect.right && min2 <= 0;
        if (z || z2) {
            return min2 != 0;
        }
        boolean z3 = min2 < 0;
        boolean isInTouchMode = isInTouchMode();
        if (isInTouchMode) {
            akt();
        }
        int headerViewsCount = getHeaderViewsCount();
        int footerViewsCount = this.cCY - getFooterViewsCount();
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
                    this.cAQ.r(childAt, i11);
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
                    this.cAQ.r(childAt2, i14);
                }
                i4 = i13;
                i7 = i12;
            }
        }
        this.cBd = this.cBc + min;
        this.cDg = true;
        if (i4 > 0) {
            detachViewsFromParent(i7, i4);
            this.cAQ.akE();
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        kb(min2);
        if (z3) {
            this.cCL = i4 + this.cCL;
        }
        int abs = Math.abs(min2);
        if (i5 < abs || width < abs) {
            fb(z3);
        }
        if (!isInTouchMode && this.cjm != -1) {
            int i15 = this.cjm - this.cCL;
            if (i15 >= 0 && i15 < getChildCount()) {
                c(this.cjm, getChildAt(i15));
            }
        } else if (this.cAO != -1) {
            int i16 = this.cAO - this.cCL;
            if (i16 >= 0 && i16 < getChildCount()) {
                c(-1, getChildAt(i16));
            }
        } else {
            this.cAP.setEmpty();
        }
        this.cDg = false;
        ake();
        return false;
    }

    public void kb(int i2) {
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
    public void akt() {
        if (this.cjm != -1) {
            if (this.cAK != 4) {
                this.cBq = this.cjm;
            }
            if (this.cCV >= 0 && this.cCV != this.cjm) {
                this.cBq = this.cCV;
            }
            setSelectedPositionInt(-1);
            setNextSelectedPositionInt(-1);
            this.cBl = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int aku() {
        int i2 = this.cjm;
        if (i2 < 0) {
            i2 = this.cBq;
        }
        return Math.min(Math.max(0, i2), this.cCY - 1);
    }

    protected int kd(int i2) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return -1;
        }
        int kc = kc(i2);
        return kc == -1 ? (this.cCL + childCount) - 1 : kc;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean akv() {
        if (this.cjm >= 0 || !akw()) {
            return false;
        }
        akm();
        return true;
    }

    boolean akw() {
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
        int i8 = this.cAV.left;
        int right = (getRight() - getLeft()) - this.cAV.right;
        int i9 = this.cCL;
        int i10 = this.cBq;
        if (i10 >= i9 && i10 < i9 + childCount) {
            View childAt = getChildAt(i10 - this.cCL);
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
            int i15 = this.cCY;
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
        this.cBq = -1;
        removeCallbacks(this.cBj);
        if (this.cBk != null) {
            this.cBk.stop();
        }
        this.cBg = -1;
        aks();
        this.cCM = i2;
        int q = q(i3, z);
        if (q < i9 || q > getLastVisiblePosition()) {
            q = -1;
        } else {
            this.cAK = 4;
            akm();
            setSelectionInt(q);
            ake();
        }
        ka(0);
        return q >= 0;
    }

    void akx() {
        int i2;
        boolean z;
        boolean z2;
        this.cAI.clear();
        int i3 = 0;
        boolean z3 = false;
        while (i3 < this.cAJ.size()) {
            long keyAt = this.cAJ.keyAt(i3);
            int intValue = this.cAJ.valueAt(i3).intValue();
            if (keyAt != this.mAdapter.getItemId(intValue)) {
                int max = Math.max(0, intValue - 20);
                int min = Math.min(intValue + 20, this.cCY);
                while (true) {
                    if (max >= min) {
                        z2 = false;
                        break;
                    } else if (keyAt != this.mAdapter.getItemId(max)) {
                        max++;
                    } else {
                        this.cAI.put(max, true);
                        this.cAJ.setValueAt(i3, Integer.valueOf(max));
                        z2 = true;
                        break;
                    }
                }
                if (!z2) {
                    this.cAJ.delete(keyAt);
                    int i4 = i3 - 1;
                    this.cAH--;
                    if (Build.VERSION.SDK_INT <= 11 || this.cAF == null || this.cAG == null) {
                        i2 = i4;
                        z = true;
                    } else {
                        ((com.baidu.tieba.horizonalList.a.a.b) this.cAG).onItemCheckedStateChanged((ActionMode) this.cAF, intValue, keyAt, false);
                        i2 = i4;
                        z = true;
                    }
                    z3 = z;
                    i3 = i2 + 1;
                }
            } else {
                this.cAI.put(intValue, true);
            }
            i2 = i3;
            z = z3;
            z3 = z;
            i3 = i2 + 1;
        }
        if (z3 && this.cAF != null && Build.VERSION.SDK_INT > 11) {
            ((ActionMode) this.cAF).invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.g
    public void handleDataChanged() {
        int i2 = this.cCY;
        int i3 = this.cBU;
        this.cBU = this.cCY;
        if (this.cAE != 0 && this.mAdapter != null && this.mAdapter.hasStableIds()) {
            akx();
        }
        this.cAQ.akD();
        if (i2 > 0) {
            if (this.cCQ) {
                this.cCQ = false;
                this.cBW = null;
                if (this.cBz == 2) {
                    this.cAK = 3;
                    return;
                }
                if (this.cBz == 1) {
                    if (this.cBN) {
                        this.cBN = false;
                        this.cAK = 3;
                        return;
                    }
                    int childCount = getChildCount();
                    int width = getWidth() - getPaddingRight();
                    View childAt = getChildAt(childCount - 1);
                    int bottom = childAt != null ? childAt.getBottom() : width;
                    if (childCount + this.cCL >= i3 && bottom <= width) {
                        this.cAK = 3;
                        return;
                    }
                    awakenScrollBars();
                }
                switch (this.cCR) {
                    case 1:
                        this.cAK = 5;
                        this.cCN = Math.min(Math.max(0, this.cCN), i2 - 1);
                        return;
                    case 0:
                        if (isInTouchMode()) {
                            this.cAK = 5;
                            this.cCN = Math.min(Math.max(0, this.cCN), i2 - 1);
                            return;
                        }
                        int akP = akP();
                        if (akP >= 0 && q(akP, true) == akP) {
                            this.cCN = akP;
                            if (this.cCP == getWidth()) {
                                this.cAK = 5;
                            } else {
                                this.cAK = 2;
                            }
                            setNextSelectedPositionInt(akP);
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
            } else if (this.cBq >= 0) {
                return;
            }
        }
        this.cAK = this.cBm ? 3 : 1;
        this.cjm = -1;
        this.cCX = Long.MIN_VALUE;
        this.cCV = -1;
        this.cCW = Long.MIN_VALUE;
        this.cCQ = false;
        this.cBW = null;
        this.cAO = -1;
        akO();
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
        this.cBz = i2;
    }

    public int getTranscriptMode() {
        return this.cBz;
    }

    @Override // android.view.View
    public int getSolidColor() {
        return this.cBA;
    }

    public void setCacheColorHint(int i2) {
        if (i2 != this.cBA) {
            this.cBA = i2;
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                getChildAt(i3).setDrawingCacheBackgroundColor(i2);
            }
            this.cAQ.setCacheColorHint(i2);
        }
    }

    @ViewDebug.ExportedProperty(category = "drawing")
    public int getCacheColorHint() {
        return this.cBA;
    }

    private void aky() {
        if (this.cBJ != null) {
            this.cBJ.finish();
            this.cBK.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void az(int i2, int i3) {
    }

    public void setRecyclerListener(l lVar) {
        this.cAQ.cCu = lVar;
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
        public int cCg;
        public boolean cCh;
        public boolean cCi;
        public int cCj;
        public long cCk;

        public f(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.cCk = -1L;
        }

        public f(int i, int i2) {
            super(i, i2);
            this.cCk = -1L;
        }

        public f(int i, int i2, int i3) {
            super(i, i2);
            this.cCk = -1L;
            this.cCg = i3;
        }

        public f(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.cCk = -1L;
        }
    }

    /* loaded from: classes.dex */
    public class k {
        private ArrayList<View> cCA;
        private SparseArrayCompat<View> cCB;
        private l cCu;
        private int cCv;
        private View[] cCw = new View[0];
        private ArrayList<View>[] cCx;
        private int cCy;
        private ArrayList<View> cCz;

        public k() {
        }

        public void kh(int i) {
            if (i < 1) {
                throw new IllegalArgumentException("Can't have a viewTypeCount < 1");
            }
            ArrayList<View>[] arrayListArr = new ArrayList[i];
            for (int i2 = 0; i2 < i; i2++) {
                arrayListArr[i2] = new ArrayList<>();
            }
            this.cCy = i;
            this.cCz = arrayListArr[0];
            this.cCx = arrayListArr;
        }

        public void akC() {
            if (this.cCy == 1) {
                ArrayList<View> arrayList = this.cCz;
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    arrayList.get(i).forceLayout();
                }
            } else {
                int i2 = this.cCy;
                for (int i3 = 0; i3 < i2; i3++) {
                    ArrayList<View> arrayList2 = this.cCx[i3];
                    int size2 = arrayList2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        arrayList2.get(i4).forceLayout();
                    }
                }
            }
            if (this.cCB != null) {
                int size3 = this.cCB.size();
                for (int i5 = 0; i5 < size3; i5++) {
                    this.cCB.valueAt(i5).forceLayout();
                }
            }
        }

        public boolean ki(int i) {
            return i >= 0;
        }

        public void clear() {
            if (this.cCy == 1) {
                ArrayList<View> arrayList = this.cCz;
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    AbsHListView.this.removeDetachedView(arrayList.remove((size - 1) - i), false);
                }
            } else {
                int i2 = this.cCy;
                for (int i3 = 0; i3 < i2; i3++) {
                    ArrayList<View> arrayList2 = this.cCx[i3];
                    int size2 = arrayList2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        AbsHListView.this.removeDetachedView(arrayList2.remove((size2 - 1) - i4), false);
                    }
                }
            }
            if (this.cCB != null) {
                this.cCB.clear();
            }
        }

        public void aB(int i, int i2) {
            if (this.cCw.length < i) {
                this.cCw = new View[i];
            }
            this.cCv = i2;
            View[] viewArr = this.cCw;
            for (int i3 = 0; i3 < i; i3++) {
                View childAt = AbsHListView.this.getChildAt(i3);
                f fVar = (f) childAt.getLayoutParams();
                if (fVar != null && fVar.cCg != -2) {
                    viewArr[i3] = childAt;
                }
            }
        }

        public View kj(int i) {
            int i2 = i - this.cCv;
            View[] viewArr = this.cCw;
            if (i2 < 0 || i2 >= viewArr.length) {
                return null;
            }
            View view = viewArr[i2];
            viewArr[i2] = null;
            return view;
        }

        View kk(int i) {
            int indexOfKey;
            if (this.cCB != null && (indexOfKey = this.cCB.indexOfKey(i)) >= 0) {
                View valueAt = this.cCB.valueAt(indexOfKey);
                this.cCB.removeAt(indexOfKey);
                return valueAt;
            }
            return null;
        }

        void akD() {
            if (this.cCB != null) {
                this.cCB.clear();
            }
        }

        View kl(int i) {
            if (this.cCy == 1) {
                return AbsHListView.a(this.cCz, i);
            }
            int itemViewType = AbsHListView.this.mAdapter.getItemViewType(i);
            if (itemViewType >= 0 && itemViewType < this.cCx.length) {
                return AbsHListView.a(this.cCx[itemViewType], i);
            }
            return null;
        }

        public void r(View view, int i) {
            f fVar = (f) view.getLayoutParams();
            if (fVar != null) {
                fVar.cCj = i;
                int i2 = fVar.cCg;
                if (!ki(i2)) {
                    if (i2 != -2) {
                        if (this.cCA == null) {
                            this.cCA = new ArrayList<>();
                        }
                        this.cCA.add(view);
                        return;
                    }
                    return;
                }
                view.onStartTemporaryDetach();
                if (this.cCy == 1) {
                    this.cCz.add(view);
                } else {
                    this.cCx[i2].add(view);
                }
                if (Build.VERSION.SDK_INT >= 14) {
                    view.setAccessibilityDelegate(null);
                }
                if (this.cCu != null) {
                    this.cCu.onMovedToScrapHeap(view);
                }
            }
        }

        public void akE() {
            if (this.cCA != null) {
                int size = this.cCA.size();
                for (int i = 0; i < size; i++) {
                    AbsHListView.this.removeDetachedView(this.cCA.get(i), false);
                }
                this.cCA.clear();
            }
        }

        public void akF() {
            View[] viewArr = this.cCw;
            boolean z = this.cCu != null;
            boolean z2 = this.cCy > 1;
            ArrayList<View> arrayList = this.cCz;
            for (int length = viewArr.length - 1; length >= 0; length--) {
                View view = viewArr[length];
                if (view != null) {
                    f fVar = (f) view.getLayoutParams();
                    int i = fVar.cCg;
                    viewArr[length] = null;
                    if (!ki(i)) {
                        if (i != -2) {
                            AbsHListView.this.removeDetachedView(view, false);
                        }
                    } else {
                        if (z2) {
                            arrayList = this.cCx[i];
                        }
                        view.onStartTemporaryDetach();
                        fVar.cCj = this.cCv + length;
                        arrayList.add(view);
                        if (Build.VERSION.SDK_INT >= 14) {
                            view.setAccessibilityDelegate(null);
                        }
                        if (z) {
                            this.cCu.onMovedToScrapHeap(view);
                        }
                    }
                }
            }
            akG();
        }

        private void akG() {
            int length = this.cCw.length;
            int i = this.cCy;
            ArrayList<View>[] arrayListArr = this.cCx;
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
            if (this.cCB != null) {
                for (int i6 = 0; i6 < this.cCB.size(); i6++) {
                    this.cCB.valueAt(i6);
                }
            }
        }

        void setCacheColorHint(int i) {
            View[] viewArr;
            if (this.cCy == 1) {
                ArrayList<View> arrayList = this.cCz;
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    arrayList.get(i2).setDrawingCacheBackgroundColor(i);
                }
            } else {
                int i3 = this.cCy;
                for (int i4 = 0; i4 < i3; i4++) {
                    ArrayList<View> arrayList2 = this.cCx[i4];
                    int size2 = arrayList2.size();
                    for (int i5 = 0; i5 < size2; i5++) {
                        arrayList2.get(i5).setDrawingCacheBackgroundColor(i);
                    }
                }
            }
            for (View view : this.cCw) {
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
                if (((f) view.getLayoutParams()).cCj == i2) {
                    arrayList.remove(i3);
                    return view;
                }
            }
            return arrayList.remove(size - 1);
        }
        return null;
    }
}
