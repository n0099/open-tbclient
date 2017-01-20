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
    static final Interpolator cCa = new LinearInterpolator();
    public static final int[] cCc = new int[1];
    Drawable Aw;
    a.AbstractC0064a cAI;
    protected int cAJ;
    public Object cAK;
    Object cAL;
    int cAM;
    protected SparseArrayCompat<Boolean> cAN;
    LongSparseArray<Integer> cAO;
    protected int cAP;
    protected a cAQ;
    boolean cAR;
    boolean cAS;
    int cAT;
    protected Rect cAU;
    protected final k cAV;
    int cAW;
    int cAX;
    int cAY;
    int cAZ;
    private Runnable cBA;
    private b cBB;
    private i cBC;
    private Runnable cBD;
    private int cBE;
    private int cBF;
    private boolean cBG;
    private int cBH;
    private Runnable cBI;
    protected Runnable cBJ;
    private float cBK;
    protected final boolean[] cBL;
    int cBM;
    int cBN;
    private EdgeEffectCompat cBO;
    private EdgeEffectCompat cBP;
    private int cBQ;
    private int cBR;
    private boolean cBS;
    private int cBT;
    private int cBU;
    private g cBV;
    private int cBW;
    private int cBX;
    protected boolean cBY;
    private int cBZ;
    protected Rect cBa;
    protected int cBb;
    View cBc;
    View cBd;
    protected boolean cBe;
    protected boolean cBf;
    protected int cBg;
    int cBh;
    int cBi;
    int cBj;
    int cBk;
    protected int cBl;
    int cBm;
    int cBn;
    private e cBo;
    protected j cBp;
    protected int cBq;
    protected boolean cBr;
    private h cBs;
    private boolean cBt;
    private Rect cBu;
    protected int cBv;
    private ContextMenu.ContextMenuInfo cBw;
    protected int cBx;
    private int cBy;
    private c cBz;
    private SavedState cCb;
    private float cCd;
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

    protected abstract void fk(boolean z);

    protected abstract int kx(int i2);

    public abstract void setSelectionInt(int i2);

    public AbsHListView(Context context) {
        super(context);
        this.cAJ = 0;
        this.cAP = 0;
        this.cAS = false;
        this.cAT = -1;
        this.cAU = new Rect();
        this.cAV = new k();
        this.cAW = 0;
        this.cAX = 0;
        this.cAY = 0;
        this.cAZ = 0;
        this.cBa = new Rect();
        this.cBb = 0;
        this.cBl = -1;
        this.cBq = 0;
        this.cBt = true;
        this.cBv = -1;
        this.cBw = null;
        this.cBy = -1;
        this.cBH = 0;
        this.cBK = 1.0f;
        this.cBL = new boolean[1];
        this.mActivePointerId = -1;
        this.mDirection = 0;
        akV();
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
        this.cAJ = 0;
        this.cAP = 0;
        this.cAS = false;
        this.cAT = -1;
        this.cAU = new Rect();
        this.cAV = new k();
        this.cAW = 0;
        this.cAX = 0;
        this.cAY = 0;
        this.cAZ = 0;
        this.cBa = new Rect();
        this.cBb = 0;
        this.cBl = -1;
        this.cBq = 0;
        this.cBt = true;
        this.cBv = -1;
        this.cBw = null;
        this.cBy = -1;
        this.cBH = 0;
        this.cBK = 1.0f;
        this.cBL = new boolean[1];
        this.mActivePointerId = -1;
        this.mDirection = 0;
        akV();
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, r.n.HListView, i2, 0);
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
        this.cAS = z3;
        setStackFromRight(z2);
        setScrollingCacheEnabled(z);
        setTranscriptMode(i3);
        setCacheColorHint(i4);
        setSmoothScrollbarEnabled(z4);
        setChoiceMode(i5);
    }

    private void akV() {
        setClickable(true);
        setFocusableInTouchMode(true);
        setWillNotDraw(false);
        setAlwaysDrawnWithCacheEnabled(false);
        setScrollingCacheEnabled(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.cBM = viewConfiguration.getScaledOverscrollDistance();
        this.cBN = viewConfiguration.getScaledOverflingDistance();
        this.cAI = com.baidu.tieba.horizonalList.a.a.az(this);
    }

    @Override // android.view.View
    public void setOverScrollMode(int i2) {
        if (i2 != 2) {
            if (this.cBO == null) {
                Context context = getContext();
                this.cBO = new EdgeEffectCompat(context);
                this.cBP = new EdgeEffectCompat(context);
            }
        } else {
            this.cBO = null;
            this.cBP = null;
        }
        super.setOverScrollMode(i2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.horizonalList.widget.g
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            this.cAR = this.mAdapter.hasStableIds();
            if (this.cAJ != 0 && this.cAR && this.cAO == null) {
                this.cAO = new LongSparseArray<>();
            }
        }
        if (this.cAN != null) {
            this.cAN.clear();
        }
        if (this.cAO != null) {
            this.cAO.clear();
        }
    }

    public int getCheckedItemCount() {
        return this.cAM;
    }

    public boolean isItemChecked(int i2) {
        if (this.cAJ == 0 || this.cAN == null) {
            return false;
        }
        return this.cAN.get(i2, false).booleanValue();
    }

    public int getCheckedItemPosition() {
        if (this.cAJ == 1 && this.cAN != null && this.cAN.size() == 1) {
            return this.cAN.keyAt(0);
        }
        return -1;
    }

    public SparseArrayCompat<Boolean> getCheckedItemPositions() {
        if (this.cAJ != 0) {
            return this.cAN;
        }
        return null;
    }

    public long[] getCheckedItemIds() {
        if (this.cAJ == 0 || this.cAO == null || this.mAdapter == null) {
            return new long[0];
        }
        LongSparseArray<Integer> longSparseArray = this.cAO;
        int size = longSparseArray.size();
        long[] jArr = new long[size];
        for (int i2 = 0; i2 < size; i2++) {
            jArr[i2] = longSparseArray.keyAt(i2);
        }
        return jArr;
    }

    public void clearChoices() {
        if (this.cAN != null) {
            this.cAN.clear();
        }
        if (this.cAO != null) {
            this.cAO.clear();
        }
        this.cAM = 0;
    }

    public void setItemChecked(int i2, boolean z) {
        if (this.cAJ != 0) {
            if (Build.VERSION.SDK_INT >= 11 && z && this.cAJ == 3 && this.cAK == null) {
                if (this.cAL == null || !((com.baidu.tieba.horizonalList.a.a.b) this.cAL).akU()) {
                    throw new IllegalStateException("AbsListView: attempted to start selection mode for CHOICE_MODE_MULTIPLE_MODAL but no choice mode callback was supplied. Call setMultiChoiceModeListener to set a callback.");
                }
                this.cAK = startActionMode((com.baidu.tieba.horizonalList.a.a.b) this.cAL);
            }
            if (this.cAJ == 2 || (Build.VERSION.SDK_INT >= 11 && this.cAJ == 3)) {
                boolean booleanValue = this.cAN.get(i2, false).booleanValue();
                this.cAN.put(i2, Boolean.valueOf(z));
                if (this.cAO != null && this.mAdapter.hasStableIds()) {
                    if (z) {
                        this.cAO.put(this.mAdapter.getItemId(i2), Integer.valueOf(i2));
                    } else {
                        this.cAO.delete(this.mAdapter.getItemId(i2));
                    }
                }
                if (booleanValue != z) {
                    if (z) {
                        this.cAM++;
                    } else {
                        this.cAM--;
                    }
                }
                if (this.cAK != null) {
                    ((com.baidu.tieba.horizonalList.a.a.b) this.cAL).onItemCheckedStateChanged((ActionMode) this.cAK, i2, this.mAdapter.getItemId(i2), z);
                }
            } else {
                boolean z2 = this.cAO != null && this.mAdapter.hasStableIds();
                if (z || isItemChecked(i2)) {
                    this.cAN.clear();
                    if (z2) {
                        this.cAO.clear();
                    }
                }
                if (z) {
                    this.cAN.put(i2, true);
                    if (z2) {
                        this.cAO.put(this.mAdapter.getItemId(i2), Integer.valueOf(i2));
                    }
                    this.cAM = 1;
                } else if (this.cAN.size() == 0 || !this.cAN.valueAt(0).booleanValue()) {
                    this.cAM = 0;
                }
            }
            if (!this.mInLayout && !this.cDl) {
                this.adN = true;
                alK();
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
        if (this.cAJ != 0) {
            if (this.cAJ == 2 || (Build.VERSION.SDK_INT >= 11 && this.cAJ == 3 && this.cAK != null)) {
                boolean z5 = !this.cAN.get(i2, false).booleanValue();
                this.cAN.put(i2, Boolean.valueOf(z5));
                if (this.cAO != null && this.mAdapter.hasStableIds()) {
                    if (z5) {
                        this.cAO.put(this.mAdapter.getItemId(i2), Integer.valueOf(i2));
                    } else {
                        this.cAO.delete(this.mAdapter.getItemId(i2));
                    }
                }
                if (z5) {
                    this.cAM++;
                } else {
                    this.cAM--;
                }
                if (this.cAK != null) {
                    ((com.baidu.tieba.horizonalList.a.a.b) this.cAL).onItemCheckedStateChanged((ActionMode) this.cAK, i2, j2, z5);
                } else {
                    z4 = true;
                }
                z2 = z4;
                z4 = true;
            } else if (this.cAJ == 1) {
                if (!this.cAN.get(i2, false).booleanValue()) {
                    this.cAN.clear();
                    this.cAN.put(i2, true);
                    if (this.cAO != null && this.mAdapter.hasStableIds()) {
                        this.cAO.clear();
                        this.cAO.put(this.mAdapter.getItemId(i2), Integer.valueOf(i2));
                    }
                    this.cAM = 1;
                } else if (this.cAN.size() == 0 || !this.cAN.valueAt(0).booleanValue()) {
                    this.cAM = 0;
                }
                z4 = true;
                z2 = true;
            } else {
                z2 = true;
            }
            if (z4) {
                akW();
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

    private void akW() {
        int i2 = this.cCQ;
        int childCount = getChildCount();
        boolean z = Build.VERSION.SDK_INT >= 11;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            int i4 = i2 + i3;
            if (childAt instanceof Checkable) {
                ((Checkable) childAt).setChecked(this.cAN.get(i4, false).booleanValue());
            } else if (z) {
                childAt.setActivated(this.cAN.get(i4, false).booleanValue());
            }
        }
    }

    public int getChoiceMode() {
        return this.cAJ;
    }

    public void setChoiceMode(int i2) {
        this.cAJ = i2;
        if (Build.VERSION.SDK_INT >= 11 && this.cAK != null) {
            if (Build.VERSION.SDK_INT >= 11) {
                ((ActionMode) this.cAK).finish();
            }
            this.cAK = null;
        }
        if (this.cAJ != 0) {
            if (this.cAN == null) {
                this.cAN = new SparseArrayCompat<>();
            }
            if (this.cAO == null && this.mAdapter != null && this.mAdapter.hasStableIds()) {
                this.cAO = new LongSparseArray<>();
            }
            if (Build.VERSION.SDK_INT >= 11 && this.cAJ == 3) {
                clearChoices();
                setLongClickable(true);
            }
        }
    }

    public void setMultiChoiceModeListener(com.baidu.tieba.horizonalList.a.a.a aVar) {
        if (Build.VERSION.SDK_INT >= 11) {
            if (this.cAL == null) {
                this.cAL = new com.baidu.tieba.horizonalList.a.a.b(this);
            }
            ((com.baidu.tieba.horizonalList.a.a.b) this.cAL).a(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean akX() {
        int childCount = getChildCount();
        if (childCount == 0) {
            return true;
        }
        if (childCount != this.cDd) {
            return false;
        }
        return getChildAt(0).getLeft() >= this.cBa.left && getChildAt(childCount + (-1)).getRight() <= getWidth() - this.cBa.right;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public int getHorizontalScrollbarHeight() {
        return super.getHorizontalScrollbarHeight();
    }

    public void setSmoothScrollbarEnabled(boolean z) {
        this.cBt = z;
    }

    public void setOnScrollListener(h hVar) {
        this.cBs = hVar;
        akY();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void akY() {
        if (this.cBs != null) {
            this.cBs.a(this, this.cCQ, getChildCount(), this.cDd);
        }
        onScrollChanged(0, 0, 0, 0);
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEvent(int i2) {
        if (i2 == 4096) {
            int firstVisiblePosition = getFirstVisiblePosition();
            int lastVisiblePosition = getLastVisiblePosition();
            if (this.cBW != firstVisiblePosition || this.cBX != lastVisiblePosition) {
                this.cBW = firstVisiblePosition;
                this.cBX = lastVisiblePosition;
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
            alm();
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

    private void akZ() {
        setSelector(getResources().getDrawable(17301602));
    }

    public void setStackFromRight(boolean z) {
        if (this.cBr != z) {
            this.cBr = z;
            ala();
        }
    }

    void ala() {
        if (getChildCount() > 0) {
            alb();
            requestLayout();
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new com.baidu.tieba.horizonalList.widget.f();
        long cCH;
        long cCI;
        int cCJ;
        String cCK;
        boolean cCL;
        int cCM;
        SparseArrayCompat<Boolean> cCN;
        LongSparseArray<Integer> cCO;
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
            this.cCH = parcel.readLong();
            this.cCI = parcel.readLong();
            this.cCJ = parcel.readInt();
            this.position = parcel.readInt();
            this.width = parcel.readInt();
            this.cCK = parcel.readString();
            this.cCL = parcel.readByte() != 0;
            this.cCM = parcel.readInt();
            this.cCN = f(parcel);
            this.cCO = e(parcel);
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
            parcel.writeLong(this.cCH);
            parcel.writeLong(this.cCI);
            parcel.writeInt(this.cCJ);
            parcel.writeInt(this.position);
            parcel.writeInt(this.width);
            parcel.writeString(this.cCK);
            parcel.writeByte((byte) (this.cCL ? 1 : 0));
            parcel.writeInt(this.cCM);
            a(this.cCN, parcel);
            a(this.cCO, parcel);
        }

        public String toString() {
            return "AbsListView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " selectedId=" + this.cCH + " firstId=" + this.cCI + " viewLeft=" + this.cCJ + " position=" + this.position + " width=" + this.width + " filter=" + this.cCK + " checkState=" + this.cCN + "}";
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        boolean z = true;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.cCb != null) {
            savedState.cCH = this.cCb.cCH;
            savedState.cCI = this.cCb.cCI;
            savedState.cCJ = this.cCb.cCJ;
            savedState.position = this.cCb.position;
            savedState.width = this.cCb.width;
            savedState.cCK = this.cCb.cCK;
            savedState.cCL = this.cCb.cCL;
            savedState.cCM = this.cCb.cCM;
            savedState.cCN = this.cCb.cCN;
            savedState.cCO = this.cCb.cCO;
            return savedState;
        }
        boolean z2 = getChildCount() > 0 && this.cDd > 0;
        long selectedItemId = getSelectedItemId();
        savedState.cCH = selectedItemId;
        savedState.width = getWidth();
        if (selectedItemId >= 0) {
            savedState.cCJ = this.cBq;
            savedState.position = getSelectedItemPosition();
            savedState.cCI = -1L;
        } else if (z2 && this.cCQ > 0) {
            savedState.cCJ = getChildAt(0).getLeft();
            int i2 = this.cCQ;
            if (i2 >= this.cDd) {
                i2 = this.cDd - 1;
            }
            savedState.position = i2;
            savedState.cCI = this.mAdapter.getItemId(i2);
        } else {
            savedState.cCJ = 0;
            savedState.cCI = -1L;
            savedState.position = 0;
        }
        savedState.cCK = null;
        savedState.cCL = (Build.VERSION.SDK_INT < 11 || this.cAJ != 3 || this.cAK == null) ? false : false;
        if (this.cAN != null) {
            try {
                savedState.cCN = this.cAN.m1clone();
            } catch (NoSuchMethodError e2) {
                e2.printStackTrace();
                savedState.cCN = new SparseArrayCompat<>();
            }
        }
        if (this.cAO != null) {
            LongSparseArray<Integer> longSparseArray = new LongSparseArray<>();
            int size = this.cAO.size();
            for (int i3 = 0; i3 < size; i3++) {
                longSparseArray.put(this.cAO.keyAt(i3), this.cAO.valueAt(i3));
            }
            savedState.cCO = longSparseArray;
        }
        savedState.cCM = this.cAM;
        return savedState;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.adN = true;
        this.cCU = savedState.width;
        if (savedState.cCH >= 0) {
            this.cCV = true;
            this.cCb = savedState;
            this.cCT = savedState.cCH;
            this.cCS = savedState.position;
            this.cCR = savedState.cCJ;
            this.cCW = 0;
        } else if (savedState.cCI >= 0) {
            setSelectedPositionInt(-1);
            setNextSelectedPositionInt(-1);
            this.cAT = -1;
            this.cCV = true;
            this.cCb = savedState;
            this.cCT = savedState.cCI;
            this.cCS = savedState.position;
            this.cCR = savedState.cCJ;
            this.cCW = 1;
        }
        if (savedState.cCN != null) {
            this.cAN = savedState.cCN;
        }
        if (savedState.cCO != null) {
            this.cAO = savedState.cCO;
        }
        this.cAM = savedState.cCM;
        if (Build.VERSION.SDK_INT >= 11 && savedState.cCL && this.cAJ == 3 && this.cAL != null) {
            this.cAK = startActionMode((com.baidu.tieba.horizonalList.a.a.b) this.cAL);
        }
        requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onFocusChanged(boolean z, int i2, Rect rect) {
        super.onFocusChanged(z, i2, rect);
        if (z && this.cjp < 0 && !isInTouchMode()) {
            if (!this.cBY && this.mAdapter != null) {
                this.adN = true;
                this.cDe = this.cDd;
                this.cDd = this.mAdapter.getCount();
            }
            alq();
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (!this.cDl && !this.mInLayout) {
            super.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void alb() {
        removeAllViewsInLayout();
        this.cCQ = 0;
        this.adN = false;
        this.cBJ = null;
        this.cCV = false;
        this.cCb = null;
        this.cDg = -1;
        this.cDh = Long.MIN_VALUE;
        setSelectedPositionInt(-1);
        setNextSelectedPositionInt(-1);
        this.cBq = 0;
        this.cAT = -1;
        this.cAU.setEmpty();
        invalidate();
    }

    @Override // android.view.View
    protected int computeHorizontalScrollExtent() {
        int childCount = getChildCount();
        if (childCount > 0) {
            if (this.cBt) {
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
        int i3 = this.cCQ;
        int childCount = getChildCount();
        if (i3 < 0 || childCount <= 0) {
            return 0;
        }
        if (this.cBt) {
            View childAt = getChildAt(0);
            int left = childAt.getLeft();
            int width = childAt.getWidth();
            if (width > 0) {
                return Math.max(((i3 * 100) - ((left * 100) / width)) + ((int) ((getScrollX() / getWidth()) * this.cDd * 100.0f)), 0);
            }
            return 0;
        }
        int i4 = this.cDd;
        if (i3 != 0) {
            i2 = i3 + childCount == i4 ? i4 : (childCount / 2) + i3;
        }
        return (int) (((i2 / i4) * childCount) + i3);
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        if (this.cBt) {
            int max = Math.max(this.cDd * 100, 0);
            if (getScrollX() != 0) {
                return max + Math.abs((int) ((getScrollX() / getWidth()) * this.cDd * 100.0f));
            }
            return max;
        }
        return this.cDd;
    }

    @Override // android.view.View
    protected float getLeftFadingEdgeStrength() {
        int childCount = getChildCount();
        float leftFadingEdgeStrength = super.getLeftFadingEdgeStrength();
        if (childCount != 0) {
            if (this.cCQ > 0) {
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
            if ((this.cCQ + childCount) - 1 < this.cDd - 1) {
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
        if (this.Aw == null) {
            akZ();
        }
        Rect rect = this.cBa;
        rect.left = this.cAW + getPaddingLeft();
        rect.top = this.cAX + getPaddingTop();
        rect.right = this.cAY + getPaddingRight();
        rect.bottom = this.cAZ + getPaddingBottom();
        if (this.cBE == 1) {
            int childCount = getChildCount();
            int width = getWidth() - getPaddingRight();
            View childAt = getChildAt(childCount - 1);
            this.cBS = childCount + this.cCQ >= this.cBZ && (childAt != null ? childAt.getRight() : width) <= width;
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
            this.cAV.alw();
        }
        layoutChildren();
        this.mInLayout = false;
        this.cBx = (i4 - i2) / 3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void layoutChildren() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void alc() {
        boolean z = true;
        if (this.cBc != null) {
            boolean z2 = this.cCQ > 0;
            if (!z2 && getChildCount() > 0) {
                z2 = getChildAt(0).getLeft() < this.cBa.left;
            }
            this.cBc.setVisibility(z2 ? 0 : 4);
        }
        if (this.cBd != null) {
            int childCount = getChildCount();
            boolean z3 = this.cCQ + childCount < this.cDd;
            if (z3 || childCount <= 0) {
                z = z3;
            } else if (getChildAt(childCount - 1).getRight() <= getRight() - this.cBa.right) {
                z = false;
            }
            this.cBd.setVisibility(z ? 0 : 4);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.g
    @ViewDebug.ExportedProperty
    public View getSelectedView() {
        if (this.cDd <= 0 || this.cjp < 0) {
            return null;
        }
        return getChildAt(this.cjp - this.cCQ);
    }

    public int getListPaddingTop() {
        return this.cBa.top;
    }

    public int getListPaddingBottom() {
        return this.cBa.bottom;
    }

    public int getListPaddingLeft() {
        return this.cBa.left;
    }

    public int getListPaddingRight() {
        return this.cBa.right;
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
        View kF = this.cAV.kF(i2);
        if (kF == null) {
            View kG = this.cAV.kG(i2);
            if (kG != null) {
                view = this.mAdapter.getView(i2, kG, this);
                if (view != kG) {
                    this.cAV.r(kG, i2);
                    if (this.cBF != 0) {
                        view.setDrawingCacheBackgroundColor(this.cBF);
                        kF = view;
                    }
                } else {
                    zArr[0] = true;
                    view.onFinishTemporaryDetach();
                    kF = view;
                }
                if (this.cAR) {
                    ViewGroup.LayoutParams layoutParams = kF.getLayoutParams();
                    if (layoutParams == null) {
                        fVar = (f) generateDefaultLayoutParams();
                    } else if (!checkLayoutParams(layoutParams)) {
                        fVar = (f) generateLayoutParams(layoutParams);
                    } else {
                        fVar = (f) layoutParams;
                    }
                    fVar.cCp = this.mAdapter.getItemId(i2);
                    kF.setLayoutParams(fVar);
                }
                if (this.cDf.isEnabled() && this.cBV == null) {
                    this.cBV = new g();
                }
            } else {
                view = this.mAdapter.getView(i2, null, this);
                if (this.cBF != 0) {
                    view.setDrawingCacheBackgroundColor(this.cBF);
                }
            }
            kF = view;
            if (this.cAR) {
            }
            if (this.cDf.isEnabled()) {
                this.cBV = new g();
            }
        }
        return kF;
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
    public void d(int i2, View view) {
        if (i2 != -1) {
            this.cAT = i2;
        }
        Rect rect = this.cAU;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        if (view instanceof m) {
            ((m) view).adjustListItemSelectionBounds(rect);
        }
        j(rect.left, rect.top, rect.right, rect.bottom);
        boolean z = this.cBG;
        if (view.isEnabled() != z) {
            this.cBG = !z;
            if (getSelectedItemPosition() != -1) {
                refreshDrawableState();
            }
        }
    }

    private void j(int i2, int i3, int i4, int i5) {
        this.cAU.set(i2 - this.cAW, i3 - this.cAX, this.cAY + i4, this.cAZ + i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        boolean z = this.cAS;
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
            this.adN = true;
            alK();
        }
    }

    boolean ald() {
        switch (this.cBl) {
            case 1:
            case 2:
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean ale() {
        return (hasFocus() && !isInTouchMode()) || ald();
    }

    private void h(Canvas canvas) {
        if (!this.cAU.isEmpty()) {
            Drawable drawable = this.Aw;
            drawable.setBounds(this.cAU);
            drawable.draw(canvas);
        }
    }

    public void setDrawSelectorOnTop(boolean z) {
        this.cAS = z;
    }

    public void setSelector(int i2) {
        setSelector(getResources().getDrawable(i2));
    }

    public void setSelector(Drawable drawable) {
        if (this.Aw != null) {
            this.Aw.setCallback(null);
            unscheduleDrawable(this.Aw);
        }
        this.Aw = drawable;
        Rect rect = new Rect();
        drawable.getPadding(rect);
        this.cAW = rect.left;
        this.cAX = rect.top;
        this.cAY = rect.right;
        this.cAZ = rect.bottom;
        drawable.setCallback(this);
        alg();
    }

    public Drawable getSelector() {
        return this.Aw;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void alf() {
        if (isEnabled() && isClickable()) {
            Drawable drawable = this.Aw;
            Rect rect = this.cAU;
            if (drawable != null) {
                if ((isFocused() || ald()) && !rect.isEmpty()) {
                    View childAt = getChildAt(this.cjp - this.cCQ);
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
                    if (isLongClickable && !this.adN) {
                        if (this.cBB == null) {
                            this.cBB = new b(this, null);
                        }
                        this.cBB.alB();
                        postDelayed(this.cBB, ViewConfiguration.getLongPressTimeout());
                    }
                }
            }
        }
    }

    void alg() {
        if (this.Aw != null) {
            if (ale()) {
                this.Aw.setState(getDrawableState());
            } else {
                this.Aw.setState(cCc);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        alg();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i2) {
        if (this.cBG) {
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
        return this.Aw == drawable || super.verifyDrawable(drawable);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.Aw != null) {
            this.Aw.jumpToCurrentState();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnTouchModeChangeListener(this);
        if (this.mAdapter != null && this.cAQ == null) {
            this.cAQ = new a();
            this.mAdapter.registerDataSetObserver(this.cAQ);
            this.adN = true;
            this.cDe = this.cDd;
            this.cDd = this.mAdapter.getCount();
        }
        this.cBY = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.g, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.cAV.clear();
        getViewTreeObserver().removeOnTouchModeChangeListener(this);
        if (this.mAdapter != null && this.cAQ != null) {
            this.mAdapter.unregisterDataSetObserver(this.cAQ);
            this.cAQ = null;
        }
        if (this.cBo != null) {
            removeCallbacks(this.cBo);
        }
        if (this.cBp != null) {
            this.cBp.stop();
        }
        if (this.cBI != null) {
            removeCallbacks(this.cBI);
        }
        if (this.cBC != null) {
            removeCallbacks(this.cBC);
        }
        if (this.cBD != null) {
            removeCallbacks(this.cBD);
            this.cBD = null;
        }
        this.cBY = false;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        int i2 = isInTouchMode() ? 0 : 1;
        if (!z) {
            setChildrenDrawingCacheEnabled(false);
            if (this.cBo != null) {
                removeCallbacks(this.cBo);
                this.cBo.alu();
                if (this.cBp != null) {
                    this.cBp.stop();
                }
                if (getScrollX() != 0) {
                    this.cAI.setScrollX(0);
                    als();
                    invalidate();
                }
            }
            if (i2 == 1) {
                this.cBv = this.cjp;
            }
        } else if (i2 != this.cBy && this.cBy != -1) {
            if (i2 == 1) {
                alq();
            } else {
                aln();
                this.cAP = 0;
                layoutChildren();
            }
        }
        this.cBy = i2;
    }

    ContextMenu.ContextMenuInfo b(View view, int i2, long j2) {
        return new g.a(view, i2, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class n {
        private int cCP;

        private n() {
        }

        /* synthetic */ n(AbsHListView absHListView, n nVar) {
            this();
        }

        public void alB() {
            this.cCP = AbsHListView.this.getWindowAttachCount();
        }

        public boolean alC() {
            return AbsHListView.this.hasWindowFocus() && AbsHListView.this.getWindowAttachCount() == this.cCP;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class i extends n implements Runnable {
        int cCq;

        private i() {
            super(AbsHListView.this, null);
        }

        /* synthetic */ i(AbsHListView absHListView, i iVar) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            View childAt;
            if (!AbsHListView.this.adN) {
                ListAdapter listAdapter = AbsHListView.this.mAdapter;
                int i = this.cCq;
                if (listAdapter != null && AbsHListView.this.cDd > 0 && i != -1 && i < listAdapter.getCount() && alC() && (childAt = AbsHListView.this.getChildAt(i - AbsHListView.this.cCQ)) != null) {
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
            View childAt = AbsHListView.this.getChildAt(AbsHListView.this.cBg - AbsHListView.this.cCQ);
            if (childAt != null) {
                if ((!alC() || AbsHListView.this.adN) ? false : AbsHListView.this.c(childAt, AbsHListView.this.cBg, AbsHListView.this.mAdapter.getItemId(AbsHListView.this.cBg))) {
                    AbsHListView.this.cBl = -1;
                    AbsHListView.this.setPressed(false);
                    childAt.setPressed(false);
                    return;
                }
                AbsHListView.this.cBl = 2;
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
            if (AbsHListView.this.isPressed() && AbsHListView.this.cjp >= 0) {
                View childAt = AbsHListView.this.getChildAt(AbsHListView.this.cjp - AbsHListView.this.cCQ);
                if (!AbsHListView.this.adN) {
                    if (alC() ? AbsHListView.this.c(childAt, AbsHListView.this.cjp, AbsHListView.this.cDc) : false) {
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
        if (Build.VERSION.SDK_INT >= 11 && this.cAJ == 3) {
            if (this.cAK == null) {
                ActionMode startActionMode = startActionMode((com.baidu.tieba.horizonalList.a.a.b) this.cAL);
                this.cAK = startActionMode;
                if (startActionMode != null) {
                    setItemChecked(i2, true);
                    performHapticFeedback(0);
                }
            }
            return true;
        }
        boolean b2 = this.cCZ != null ? this.cCZ.b(this, view, i2, j2) : false;
        if (!b2) {
            this.cBw = b(view, i2, j2);
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
        return this.cBw;
    }

    public boolean a(float f2, float f3, int i2) {
        int pointToPosition = pointToPosition((int) f2, (int) f3);
        if (pointToPosition != -1) {
            long itemId = this.mAdapter.getItemId(pointToPosition);
            View childAt = getChildAt(pointToPosition - this.cCQ);
            if (childAt != null) {
                this.cBw = b(childAt, pointToPosition, itemId);
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
            boolean b2 = this.cCZ != null ? this.cCZ.b(this, view, positionForView, itemId) : false;
            if (!b2) {
                this.cBw = b(getChildAt(positionForView - this.cCQ), positionForView, itemId);
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
                if (isClickable() && isPressed() && this.cjp >= 0 && this.mAdapter != null && this.cjp < this.mAdapter.getCount()) {
                    View childAt = getChildAt(this.cjp - this.cCQ);
                    if (childAt != null) {
                        performItemClick(childAt, this.cjp, this.cDc);
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
        Rect rect = this.cBu;
        if (rect == null) {
            this.cBu = new Rect();
            rect = this.cBu;
        }
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt.getVisibility() == 0) {
                childAt.getHitRect(rect);
                if (rect.contains(i2, i3)) {
                    return this.cCQ + childCount;
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
            if (AbsHListView.this.cBl == 0) {
                AbsHListView.this.cBl = 1;
                View childAt = AbsHListView.this.getChildAt(AbsHListView.this.cBg - AbsHListView.this.cCQ);
                if (childAt != null && !childAt.hasFocusable()) {
                    AbsHListView.this.cAP = 0;
                    if (!AbsHListView.this.adN) {
                        childAt.setPressed(true);
                        AbsHListView.this.setPressed(true);
                        AbsHListView.this.layoutChildren();
                        AbsHListView.this.d(AbsHListView.this.cBg, childAt);
                        AbsHListView.this.refreshDrawableState();
                        int longPressTimeout = ViewConfiguration.getLongPressTimeout();
                        boolean isLongClickable = AbsHListView.this.isLongClickable();
                        if (AbsHListView.this.Aw != null && (current = AbsHListView.this.Aw.getCurrent()) != null && (current instanceof TransitionDrawable)) {
                            if (isLongClickable) {
                                ((TransitionDrawable) current).startTransition(longPressTimeout);
                            } else {
                                ((TransitionDrawable) current).resetTransition();
                            }
                        }
                        if (isLongClickable) {
                            if (AbsHListView.this.cBz == null) {
                                AbsHListView.this.cBz = new c(AbsHListView.this, null);
                            }
                            AbsHListView.this.cBz.alB();
                            AbsHListView.this.postDelayed(AbsHListView.this.cBz, longPressTimeout);
                            return;
                        }
                        AbsHListView.this.cBl = 2;
                        return;
                    }
                    AbsHListView.this.cBl = 2;
                }
            }
        }
    }

    private boolean kt(int i2) {
        int i3 = i2 - this.cBj;
        int abs = Math.abs(i3);
        boolean z = getScrollX() != 0;
        if (z || abs > this.mTouchSlop) {
            all();
            if (z) {
                this.cBl = 5;
                this.cBn = 0;
            } else {
                this.cBl = 3;
                this.cBn = i3 > 0 ? this.mTouchSlop : -this.mTouchSlop;
            }
            Handler handler = getHandler();
            if (handler != null) {
                handler.removeCallbacks(this.cBz);
            }
            setPressed(false);
            View childAt = getChildAt(this.cBg - this.cCQ);
            if (childAt != null) {
                childAt.setPressed(false);
            }
            kv(1);
            ViewParent parent = getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            ku(i2);
            return true;
        }
        return false;
    }

    private void ku(int i2) {
        int i3;
        int childCount;
        ViewParent parent;
        int i4 = i2 - this.cBj;
        int i5 = i4 - this.cBn;
        int i6 = this.cBm != Integer.MIN_VALUE ? i2 - this.cBm : i5;
        if (this.cBl == 3) {
            if (i2 != this.cBm) {
                if (Math.abs(i4) > this.mTouchSlop && (parent = getParent()) != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
                if (this.cBg >= 0) {
                    childCount = this.cBg - this.cCQ;
                } else {
                    childCount = getChildCount() / 2;
                }
                View childAt = getChildAt(childCount);
                int left = childAt != null ? childAt.getLeft() : 0;
                boolean ax = i6 != 0 ? ax(i5, i6) : false;
                View childAt2 = getChildAt(childCount);
                if (childAt2 != null) {
                    int left2 = childAt2.getLeft();
                    if (ax) {
                        int i7 = (-i6) - (left2 - left);
                        overScrollBy(i7, 0, getScrollX(), 0, 0, 0, this.cBM, 0, true);
                        if (Math.abs(this.cBM) == Math.abs(getScrollX()) && this.mVelocityTracker != null) {
                            this.mVelocityTracker.clear();
                        }
                        int overScrollMode = getOverScrollMode();
                        if (overScrollMode == 0 || (overScrollMode == 1 && !akX())) {
                            this.mDirection = 0;
                            this.cBl = 5;
                            if (i4 > 0) {
                                this.cBO.onPull(i7 / getWidth());
                                if (!this.cBP.isFinished()) {
                                    this.cBP.onRelease();
                                }
                                invalidate();
                            } else if (i4 < 0) {
                                this.cBP.onPull(i7 / getWidth());
                                if (!this.cBO.isFinished()) {
                                    this.cBO.onRelease();
                                }
                                invalidate();
                            }
                        }
                    }
                    this.cBj = i2;
                }
                this.cBm = i2;
            }
        } else if (this.cBl == 5 && i2 != this.cBm) {
            int scrollX = getScrollX();
            int i8 = scrollX - i6;
            int i9 = i2 > this.cBm ? 1 : -1;
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
                overScrollBy(i10, 0, getScrollX(), 0, 0, 0, this.cBM, 0, true);
                int overScrollMode2 = getOverScrollMode();
                if (overScrollMode2 == 0 || (overScrollMode2 == 1 && !akX())) {
                    if (i4 > 0) {
                        this.cBO.onPull(i10 / getWidth());
                        if (!this.cBP.isFinished()) {
                            this.cBP.onRelease();
                        }
                        invalidate();
                    } else if (i4 < 0) {
                        this.cBP.onPull(i10 / getWidth());
                        if (!this.cBO.isFinished()) {
                            this.cBO.onRelease();
                        }
                        invalidate();
                    }
                }
            }
            if (i3 != 0) {
                if (getScrollX() != 0) {
                    this.cAI.setScrollX(0);
                    alh();
                }
                ax(i3, i3);
                this.cBl = 3;
                int ky = ky(i2);
                this.cBn = 0;
                View childAt3 = getChildAt(ky - this.cCQ);
                this.cBh = childAt3 != null ? childAt3.getLeft() : 0;
                this.cBj = i2;
                this.cBg = ky;
            }
            this.cBm = i2;
            this.mDirection = i9;
        }
    }

    protected void alh() {
        if (this.cAI.isHardwareAccelerated() && (getParent() instanceof View)) {
            ((View) getParent()).invalidate();
        }
    }

    @Override // android.view.ViewTreeObserver.OnTouchModeChangeListener
    public void onTouchModeChanged(boolean z) {
        if (z) {
            aln();
            if (getWidth() > 0 && getChildCount() > 0) {
                layoutChildren();
            }
            alg();
            return;
        }
        int i2 = this.cBl;
        if (i2 == 5 || i2 == 6) {
            if (this.cBo != null) {
                this.cBo.alu();
            }
            if (this.cBp != null) {
                this.cBp.stop();
            }
            if (getScrollX() != 0) {
                this.cAI.setScrollX(0);
                als();
                invalidate();
            }
        }
    }

    protected boolean k(MotionEvent motionEvent) {
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
        if (this.cBp != null) {
            this.cBp.stop();
        }
        if (this.cBY) {
            int action = motionEvent.getAction();
            alj();
            this.mVelocityTracker.addMovement(motionEvent);
            switch (action & MotionEventCompat.ACTION_MASK) {
                case 0:
                    switch (this.cBl) {
                        case 6:
                            this.cBo.alu();
                            if (this.cBp != null) {
                                this.cBp.stop();
                            }
                            this.cBl = 5;
                            this.cBk = (int) motionEvent.getY();
                            int x = (int) motionEvent.getX();
                            this.cBm = x;
                            this.cBj = x;
                            this.cBn = 0;
                            this.mActivePointerId = motionEvent.getPointerId(0);
                            this.mDirection = 0;
                            break;
                        default:
                            this.mActivePointerId = motionEvent.getPointerId(0);
                            int x2 = (int) motionEvent.getX();
                            int y = (int) motionEvent.getY();
                            int pointToPosition = pointToPosition(x2, y);
                            if (!this.adN) {
                                if (this.cBl != 4 && pointToPosition >= 0 && getAdapter().isEnabled(pointToPosition)) {
                                    this.cBl = 0;
                                    if (this.cBA == null) {
                                        this.cBA = new d();
                                    }
                                    postDelayed(this.cBA, ViewConfiguration.getTapTimeout());
                                    i2 = pointToPosition;
                                } else if (this.cBl == 4) {
                                    all();
                                    this.cBl = 3;
                                    this.cBn = 0;
                                    i2 = kx(x2);
                                    this.cBo.alv();
                                }
                                if (i2 >= 0) {
                                    this.cBh = getChildAt(i2 - this.cCQ).getLeft();
                                }
                                this.cBj = x2;
                                this.cBk = y;
                                this.cBg = i2;
                                this.cBm = ExploreByTouchHelper.INVALID_ID;
                                break;
                            }
                            i2 = pointToPosition;
                            if (i2 >= 0) {
                            }
                            this.cBj = x2;
                            this.cBk = y;
                            this.cBg = i2;
                            this.cBm = ExploreByTouchHelper.INVALID_ID;
                    }
                    if (k(motionEvent) && this.cBl == 0) {
                        removeCallbacks(this.cBA);
                        break;
                    }
                    break;
                case 1:
                    switch (this.cBl) {
                        case 0:
                        case 1:
                        case 2:
                            int i3 = this.cBg;
                            View childAt = getChildAt(i3 - this.cCQ);
                            float x3 = motionEvent.getX();
                            boolean z = x3 > ((float) this.cBa.left) && x3 < ((float) (getWidth() - this.cBa.right));
                            if (childAt != null && !childAt.hasFocusable() && z) {
                                if (this.cBl != 0) {
                                    childAt.setPressed(false);
                                }
                                if (this.cBC == null) {
                                    this.cBC = new i(this, null);
                                }
                                i iVar = this.cBC;
                                iVar.cCq = i3;
                                iVar.alB();
                                this.cBv = i3;
                                if (this.cBl == 0 || this.cBl == 1) {
                                    Handler handler = getHandler();
                                    if (handler != null) {
                                        handler.removeCallbacks(this.cBl == 0 ? this.cBA : this.cBz);
                                    }
                                    this.cAP = 0;
                                    if (!this.adN && this.mAdapter.isEnabled(i3)) {
                                        this.cBl = 1;
                                        setSelectedPositionInt(this.cBg);
                                        layoutChildren();
                                        childAt.setPressed(true);
                                        d(this.cBg, childAt);
                                        setPressed(true);
                                        if (this.Aw != null && (current = this.Aw.getCurrent()) != null && (current instanceof TransitionDrawable)) {
                                            ((TransitionDrawable) current).resetTransition();
                                        }
                                        if (this.cBD != null) {
                                            removeCallbacks(this.cBD);
                                        }
                                        this.cBD = new com.baidu.tieba.horizonalList.widget.a(this, childAt, iVar);
                                        postDelayed(this.cBD, ViewConfiguration.getPressedStateDuration());
                                    } else {
                                        this.cBl = -1;
                                        alg();
                                    }
                                    return true;
                                } else if (!this.adN && this.mAdapter.isEnabled(i3)) {
                                    iVar.run();
                                }
                            }
                            this.cBl = -1;
                            alg();
                            break;
                        case 3:
                            int childCount = getChildCount();
                            if (childCount > 0) {
                                int left = getChildAt(0).getLeft();
                                int right = getChildAt(childCount - 1).getRight();
                                int i4 = this.cBa.left;
                                int width = getWidth() - this.cBa.right;
                                if (this.cCQ == 0 && left >= i4 && this.cCQ + childCount < this.cDd && right <= getWidth() - width) {
                                    this.cBl = -1;
                                    kv(0);
                                    break;
                                } else {
                                    VelocityTracker velocityTracker = this.mVelocityTracker;
                                    velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                                    int xVelocity = (int) (velocityTracker.getXVelocity(this.mActivePointerId) * this.cBK);
                                    if (Math.abs(xVelocity) > this.mMinimumVelocity && ((this.cCQ != 0 || left != i4 - this.cBM) && (childCount + this.cCQ != this.cDd || right != this.cBM + width))) {
                                        if (this.cBo == null) {
                                            this.cBo = new e();
                                        }
                                        kv(2);
                                        this.cBo.kz(-xVelocity);
                                        break;
                                    } else {
                                        this.cBl = -1;
                                        kv(0);
                                        if (this.cBo != null) {
                                            this.cBo.alu();
                                        }
                                        if (this.cBp != null) {
                                            this.cBp.stop();
                                            break;
                                        }
                                    }
                                }
                            } else {
                                this.cBl = -1;
                                kv(0);
                                break;
                            }
                            break;
                        case 5:
                            if (this.cBo == null) {
                                this.cBo = new e();
                            }
                            VelocityTracker velocityTracker2 = this.mVelocityTracker;
                            velocityTracker2.computeCurrentVelocity(1000, this.mMaximumVelocity);
                            int xVelocity2 = (int) velocityTracker2.getXVelocity(this.mActivePointerId);
                            kv(2);
                            if (Math.abs(xVelocity2) > this.mMinimumVelocity) {
                                this.cBo.kA(-xVelocity2);
                                break;
                            } else {
                                this.cBo.alt();
                                break;
                            }
                    }
                    setPressed(false);
                    if (this.cBO != null) {
                        this.cBO.onRelease();
                        this.cBP.onRelease();
                    }
                    invalidate();
                    Handler handler2 = getHandler();
                    if (handler2 != null) {
                        handler2.removeCallbacks(this.cBz);
                    }
                    alk();
                    this.mActivePointerId = -1;
                    break;
                case 2:
                    int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                    if (findPointerIndex == -1) {
                        this.mActivePointerId = motionEvent.getPointerId(0);
                        findPointerIndex = 0;
                    }
                    int x4 = (int) motionEvent.getX(findPointerIndex);
                    if (this.adN) {
                        layoutChildren();
                    }
                    switch (this.cBl) {
                        case 0:
                        case 1:
                        case 2:
                            kt(x4);
                            break;
                        case 3:
                        case 5:
                            ku(x4);
                            break;
                    }
                case 3:
                    switch (this.cBl) {
                        case 5:
                            if (this.cBo == null) {
                                this.cBo = new e();
                            }
                            this.cBo.alt();
                            break;
                        case 6:
                            break;
                        default:
                            this.cBl = -1;
                            setPressed(false);
                            View childAt2 = getChildAt(this.cBg - this.cCQ);
                            if (childAt2 != null) {
                                childAt2.setPressed(false);
                            }
                            alm();
                            Handler handler3 = getHandler();
                            if (handler3 != null) {
                                handler3.removeCallbacks(this.cBz);
                            }
                            alk();
                            break;
                    }
                    if (this.cBO != null) {
                        this.cBO.onRelease();
                        this.cBP.onRelease();
                    }
                    this.mActivePointerId = -1;
                    break;
                case 5:
                    int actionIndex = motionEvent.getActionIndex();
                    int pointerId = motionEvent.getPointerId(actionIndex);
                    int x5 = (int) motionEvent.getX(actionIndex);
                    int y2 = (int) motionEvent.getY(actionIndex);
                    this.cBn = 0;
                    this.mActivePointerId = pointerId;
                    this.cBj = x5;
                    this.cBk = y2;
                    int pointToPosition2 = pointToPosition(x5, y2);
                    if (pointToPosition2 >= 0) {
                        this.cBh = getChildAt(pointToPosition2 - this.cCQ).getLeft();
                        this.cBg = pointToPosition2;
                    }
                    this.cBm = x5;
                    break;
                case 6:
                    onSecondaryPointerUp(motionEvent);
                    int i5 = this.cBj;
                    int pointToPosition3 = pointToPosition(i5, this.cBk);
                    if (pointToPosition3 >= 0) {
                        this.cBh = getChildAt(pointToPosition3 - this.cCQ).getLeft();
                        this.cBg = pointToPosition3;
                    }
                    this.cBm = i5;
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
            this.cAI.setScrollX(i2);
            alh();
            awakenScrollBars();
        }
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) != 0) {
            switch (motionEvent.getAction()) {
                case 8:
                    if (this.cBl == -1) {
                        float axisValue = motionEvent.getAxisValue(10);
                        if (axisValue != 0.0f) {
                            int horizontalScrollFactor = (int) (axisValue * getHorizontalScrollFactor());
                            if (!ax(horizontalScrollFactor, horizontalScrollFactor)) {
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
        if (this.cCd == 0.0f) {
            TypedValue typedValue = new TypedValue();
            if (getContext().getTheme().resolveAttribute(r.c.hlv_listPreferredItemWidth, typedValue, true)) {
                this.cCd = typedValue.getDimension(getContext().getResources().getDisplayMetrics());
            }
        }
        return this.cCd;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.cBO != null) {
            int scrollX = getScrollX();
            if (!this.cBO.isFinished()) {
                int save = canvas.save();
                int i2 = this.cBa.top + this.cBT;
                int height = (getHeight() - i2) - (this.cBa.bottom + this.cBU);
                int min = Math.min(0, this.cBQ + scrollX);
                canvas.rotate(-90.0f);
                canvas.translate(i2 + (-getHeight()), min);
                this.cBO.setSize(height, height);
                if (this.cBO.draw(canvas)) {
                    invalidate();
                }
                canvas.restoreToCount(save);
            }
            if (!this.cBP.isFinished()) {
                int save2 = canvas.save();
                int i3 = this.cBa.left + this.cBT;
                int height2 = (getHeight() - i3) - (this.cBa.right + this.cBU);
                int max = Math.max(getWidth(), scrollX + this.cBR);
                canvas.rotate(90.0f);
                canvas.translate(-i3, -max);
                this.cBP.setSize(height2, height2);
                if (this.cBP.draw(canvas)) {
                    invalidate();
                }
                canvas.restoreToCount(save2);
            }
        }
    }

    private void ali() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        } else {
            this.mVelocityTracker.clear();
        }
    }

    private void alj() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
    }

    private void alk() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            alk();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.cBp != null) {
            this.cBp.stop();
        }
        if (this.cBY) {
            switch (action & MotionEventCompat.ACTION_MASK) {
                case 0:
                    int i2 = this.cBl;
                    if (i2 == 6 || i2 == 5) {
                        this.cBn = 0;
                        return true;
                    }
                    int x = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();
                    this.mActivePointerId = motionEvent.getPointerId(0);
                    int kx = kx(x);
                    if (i2 != 4 && kx >= 0) {
                        this.cBh = getChildAt(kx - this.cCQ).getLeft();
                        this.cBj = x;
                        this.cBk = y;
                        this.cBg = kx;
                        this.cBl = 0;
                        alm();
                    }
                    this.cBm = ExploreByTouchHelper.INVALID_ID;
                    ali();
                    this.mVelocityTracker.addMovement(motionEvent);
                    return i2 == 4;
                case 1:
                case 3:
                    this.cBl = -1;
                    this.mActivePointerId = -1;
                    alk();
                    kv(0);
                    return false;
                case 2:
                    switch (this.cBl) {
                        case 0:
                            int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                            if (findPointerIndex == -1) {
                                this.mActivePointerId = motionEvent.getPointerId(0);
                                findPointerIndex = 0;
                            }
                            alj();
                            this.mVelocityTracker.addMovement(motionEvent);
                            return kt((int) motionEvent.getX(findPointerIndex));
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
            this.cBj = (int) motionEvent.getX(i2);
            this.cBk = (int) motionEvent.getY(i2);
            this.cBn = 0;
            this.mActivePointerId = motionEvent.getPointerId(i2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        int childCount = getChildCount();
        int i2 = this.cCQ;
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
    public void kv(int i2) {
        if (i2 != this.cBH && this.cBs != null) {
            this.cBH = i2;
            this.cBs.a(this, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e implements Runnable {
        private final o cCh;
        private int cCi;
        private final Runnable cCj = new com.baidu.tieba.horizonalList.widget.c(this);

        e() {
            this.cCh = new o(AbsHListView.this.getContext());
        }

        void kz(int i) {
            int i2 = i < 0 ? Integer.MAX_VALUE : 0;
            this.cCi = i2;
            this.cCh.setInterpolator(null);
            this.cCh.fling(i2, 0, i, 0, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
            AbsHListView.this.cBl = 4;
            AbsHListView.this.cAI.i(this);
        }

        void alt() {
            if (this.cCh.springBack(AbsHListView.this.getScrollX(), 0, 0, 0, 0, 0)) {
                AbsHListView.this.cBl = 6;
                AbsHListView.this.invalidate();
                AbsHListView.this.cAI.i(this);
                return;
            }
            AbsHListView.this.cBl = -1;
            AbsHListView.this.kv(0);
        }

        void kA(int i) {
            this.cCh.setInterpolator(null);
            this.cCh.fling(AbsHListView.this.getScrollX(), 0, i, 0, ExploreByTouchHelper.INVALID_ID, Integer.MAX_VALUE, 0, 0, AbsHListView.this.getWidth(), 0);
            AbsHListView.this.cBl = 6;
            AbsHListView.this.invalidate();
            AbsHListView.this.cAI.i(this);
        }

        void kB(int i) {
            this.cCh.notifyHorizontalEdgeReached(AbsHListView.this.getScrollX(), 0, AbsHListView.this.cBN);
            int overScrollMode = AbsHListView.this.getOverScrollMode();
            if (overScrollMode == 0 || (overScrollMode == 1 && !AbsHListView.this.akX())) {
                AbsHListView.this.cBl = 6;
                int currVelocity = (int) this.cCh.getCurrVelocity();
                if (i > 0) {
                    AbsHListView.this.cBO.onAbsorb(currVelocity);
                } else {
                    AbsHListView.this.cBP.onAbsorb(currVelocity);
                }
            } else {
                AbsHListView.this.cBl = -1;
                if (AbsHListView.this.cBp != null) {
                    AbsHListView.this.cBp.stop();
                }
            }
            AbsHListView.this.invalidate();
            AbsHListView.this.cAI.i(this);
        }

        void d(int i, int i2, boolean z) {
            int i3 = i < 0 ? Integer.MAX_VALUE : 0;
            this.cCi = i3;
            this.cCh.setInterpolator(z ? AbsHListView.cCa : null);
            this.cCh.startScroll(i3, 0, i, 0, i2);
            AbsHListView.this.cBl = 4;
            AbsHListView.this.cAI.i(this);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void alu() {
            AbsHListView.this.cBl = -1;
            AbsHListView.this.removeCallbacks(this);
            AbsHListView.this.removeCallbacks(this.cCj);
            AbsHListView.this.kv(0);
            AbsHListView.this.alm();
            this.cCh.abortAnimation();
            AbsHListView.this.overScrollBy(0, 0, 0, 0, 0, 0, 0, 0, false);
        }

        void alv() {
            AbsHListView.this.postDelayed(this.cCj, 40L);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // java.lang.Runnable
        public void run() {
            int max;
            boolean z = true;
            boolean z2 = false;
            switch (AbsHListView.this.cBl) {
                case 3:
                    if (this.cCh.isFinished()) {
                        return;
                    }
                    break;
                case 4:
                    break;
                case 5:
                default:
                    alu();
                    return;
                case 6:
                    o oVar = this.cCh;
                    if (oVar.computeScrollOffset()) {
                        int scrollX = AbsHListView.this.getScrollX();
                        int currX = oVar.getCurrX();
                        if (AbsHListView.this.overScrollBy(currX - scrollX, 0, scrollX, 0, 0, 0, AbsHListView.this.cBN, 0, false)) {
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
                                kz(currVelocity);
                                return;
                            }
                            alt();
                            return;
                        }
                        AbsHListView.this.invalidate();
                        AbsHListView.this.cAI.i(this);
                        return;
                    }
                    alu();
                    return;
            }
            if (AbsHListView.this.adN) {
                AbsHListView.this.layoutChildren();
            }
            if (AbsHListView.this.cDd == 0 || AbsHListView.this.getChildCount() == 0) {
                alu();
                return;
            }
            o oVar2 = this.cCh;
            boolean computeScrollOffset = oVar2.computeScrollOffset();
            int currX2 = oVar2.getCurrX();
            int i = this.cCi - currX2;
            if (i > 0) {
                AbsHListView.this.cBg = AbsHListView.this.cCQ;
                AbsHListView.this.cBh = AbsHListView.this.getChildAt(0).getLeft();
                max = Math.min(((AbsHListView.this.getWidth() - AbsHListView.this.getPaddingRight()) - AbsHListView.this.getPaddingLeft()) - 1, i);
            } else {
                int childCount = AbsHListView.this.getChildCount() - 1;
                AbsHListView.this.cBg = AbsHListView.this.cCQ + childCount;
                AbsHListView.this.cBh = AbsHListView.this.getChildAt(childCount).getLeft();
                max = Math.max(-(((AbsHListView.this.getWidth() - AbsHListView.this.getPaddingRight()) - AbsHListView.this.getPaddingLeft()) - 1), i);
            }
            View childAt = AbsHListView.this.getChildAt(AbsHListView.this.cBg - AbsHListView.this.cCQ);
            int left = childAt != null ? childAt.getLeft() : 0;
            boolean ax = AbsHListView.this.ax(max, max);
            if (!ax || max == 0) {
                z = false;
            }
            if (z) {
                if (childAt != null) {
                    AbsHListView.this.overScrollBy(-(max - (childAt.getLeft() - left)), 0, AbsHListView.this.getScrollX(), 0, 0, 0, AbsHListView.this.cBN, 0, false);
                }
                if (computeScrollOffset) {
                    kB(max);
                }
            } else if (computeScrollOffset && !z) {
                if (ax) {
                    AbsHListView.this.invalidate();
                }
                this.cCi = currX2;
                AbsHListView.this.cAI.i(this);
            } else {
                alu();
            }
        }
    }

    /* loaded from: classes.dex */
    public class j implements Runnable {
        private int cCr;
        private int cCs;
        private int cCt;
        private int cCu;
        private final int cCv;
        private int cCw;
        private int mMode;

        j() {
            this.cCv = ViewConfiguration.get(AbsHListView.this.getContext()).getScaledFadingEdgeLength();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void kz(int i) {
            int i2;
            stop();
            if (AbsHListView.this.adN) {
                AbsHListView.this.cBJ = new com.baidu.tieba.horizonalList.widget.d(this, i);
                return;
            }
            int childCount = AbsHListView.this.getChildCount();
            if (childCount != 0) {
                int i3 = AbsHListView.this.cCQ;
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
                    this.cCu = 200 / i2;
                } else {
                    this.cCu = 200;
                }
                this.cCr = max;
                this.cCs = -1;
                this.cCt = -1;
                AbsHListView.this.cAI.i(this);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void az(int i, int i2) {
            int i3;
            stop();
            if (i2 == -1) {
                kz(i);
            } else if (AbsHListView.this.adN) {
                AbsHListView.this.cBJ = new com.baidu.tieba.horizonalList.widget.e(this, i, i2);
            } else {
                int childCount = AbsHListView.this.getChildCount();
                if (childCount != 0) {
                    int i4 = AbsHListView.this.cCQ;
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
                        this.cCu = 200 / i3;
                    } else {
                        this.cCu = 200;
                    }
                    this.cCr = max;
                    this.cCs = i2;
                    this.cCt = -1;
                    AbsHListView.this.cAI.i(this);
                }
            }
        }

        void w(int i, int i2, int i3) {
            int i4 = AbsHListView.this.cCQ;
            int childCount = (AbsHListView.this.getChildCount() + i4) - 1;
            int i5 = AbsHListView.this.cBa.left;
            int width = AbsHListView.this.getWidth() - AbsHListView.this.cBa.right;
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
            int i2 = AbsHListView.this.cCQ;
            switch (this.mMode) {
                case 1:
                    int childCount = AbsHListView.this.getChildCount() - 1;
                    int i3 = i2 + childCount;
                    if (childCount >= 0) {
                        if (i3 == this.cCt) {
                            AbsHListView.this.cAI.i(this);
                            return;
                        }
                        View childAt = AbsHListView.this.getChildAt(childCount);
                        AbsHListView.this.c((i3 < AbsHListView.this.cDd + (-1) ? Math.max(AbsHListView.this.cBa.right, this.cCv) : AbsHListView.this.cBa.right) + (childAt.getWidth() - (width - childAt.getLeft())), this.cCu, true);
                        this.cCt = i3;
                        if (i3 < this.cCr) {
                            AbsHListView.this.cAI.i(this);
                            return;
                        }
                        return;
                    }
                    return;
                case 2:
                    if (i2 == this.cCt) {
                        AbsHListView.this.cAI.i(this);
                        return;
                    }
                    View childAt2 = AbsHListView.this.getChildAt(0);
                    if (childAt2 != null) {
                        AbsHListView.this.c(childAt2.getLeft() - (i2 > 0 ? Math.max(this.cCv, AbsHListView.this.cBa.left) : AbsHListView.this.cBa.left), this.cCu, true);
                        this.cCt = i2;
                        if (i2 > this.cCr) {
                            AbsHListView.this.cAI.i(this);
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    int childCount2 = AbsHListView.this.getChildCount();
                    if (i2 != this.cCs && childCount2 > 1 && childCount2 + i2 < AbsHListView.this.cDd) {
                        int i4 = i2 + 1;
                        if (i4 == this.cCt) {
                            AbsHListView.this.cAI.i(this);
                            return;
                        }
                        View childAt3 = AbsHListView.this.getChildAt(1);
                        int width2 = childAt3.getWidth();
                        int left2 = childAt3.getLeft();
                        int max = Math.max(AbsHListView.this.cBa.right, this.cCv);
                        if (i4 < this.cCs) {
                            AbsHListView.this.c(Math.max(0, (left2 + width2) - max), this.cCu, true);
                            this.cCt = i4;
                            AbsHListView.this.cAI.i(this);
                            return;
                        } else if (left2 > max) {
                            AbsHListView.this.c(left2 - max, this.cCu, true);
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
                        if (i5 == this.cCt) {
                            AbsHListView.this.cAI.i(this);
                            return;
                        }
                        View childAt4 = AbsHListView.this.getChildAt(childCount3);
                        int width3 = childAt4.getWidth();
                        int left3 = childAt4.getLeft();
                        int i6 = width - left3;
                        int max2 = Math.max(AbsHListView.this.cBa.left, this.cCv);
                        this.cCt = i5;
                        if (i5 > this.cCs) {
                            AbsHListView.this.c(-(i6 - max2), this.cCu, true);
                            AbsHListView.this.cAI.i(this);
                            return;
                        }
                        int i7 = width - max2;
                        int i8 = left3 + width3;
                        if (i7 > i8) {
                            AbsHListView.this.c(-(i7 - i8), this.cCu, true);
                            return;
                        }
                        return;
                    }
                    return;
                case 5:
                    if (this.cCt == i2) {
                        AbsHListView.this.cAI.i(this);
                        return;
                    }
                    this.cCt = i2;
                    int childCount4 = AbsHListView.this.getChildCount();
                    int i9 = this.cCr;
                    int i10 = (i2 + childCount4) - 1;
                    if (i9 < i2) {
                        i = (i2 - i9) + 1;
                    } else if (i9 > i10) {
                        i = i9 - i10;
                    }
                    float min = Math.min(Math.abs(i / childCount4), 1.0f);
                    if (i9 < i2) {
                        AbsHListView.this.c((int) ((-AbsHListView.this.getWidth()) * min), (int) (min * this.cCu), true);
                        AbsHListView.this.cAI.i(this);
                        return;
                    } else if (i9 > i10) {
                        AbsHListView.this.c((int) (AbsHListView.this.getWidth() * min), (int) (min * this.cCu), true);
                        AbsHListView.this.cAI.i(this);
                        return;
                    } else {
                        AbsHListView.this.c(AbsHListView.this.getChildAt(i9 - i2).getLeft() - this.cCw, (int) (this.cCu * (Math.abs(left) / AbsHListView.this.getWidth())), true);
                        return;
                    }
                default:
                    return;
            }
        }
    }

    public void setFriction(float f2) {
        if (this.cBo == null) {
            this.cBo = new e();
        }
        this.cBo.cCh.setFriction(f2);
    }

    public void setVelocityScale(float f2) {
        this.cBK = f2;
    }

    public void smoothScrollToPosition(int i2, int i3) {
        if (this.cBp == null) {
            this.cBp = new j();
        }
        this.cBp.az(i2, i3);
    }

    public void smoothScrollBy(int i2, int i3) {
        c(i2, i3, false);
    }

    public void c(int i2, int i3, boolean z) {
        if (this.cBo == null) {
            this.cBo = new e();
        }
        int i4 = this.cCQ;
        int childCount = getChildCount();
        int i5 = i4 + childCount;
        int paddingLeft = getPaddingLeft();
        int width = getWidth() - getPaddingRight();
        if (i2 == 0 || this.cDd == 0 || childCount == 0 || ((i4 == 0 && getChildAt(0).getLeft() == paddingLeft && i2 < 0) || (i5 == this.cDd && getChildAt(childCount - 1).getRight() == width && i2 > 0))) {
            this.cBo.alu();
            if (this.cBp != null) {
                this.cBp.stop();
                return;
            }
            return;
        }
        kv(2);
        this.cBo.d(i2, i3, z);
    }

    private void all() {
        if (this.mScrollingCacheEnabled && !this.cBe && !this.cAI.isHardwareAccelerated()) {
            setChildrenDrawnWithCacheEnabled(true);
            setChildrenDrawingCacheEnabled(true);
            this.cBf = true;
            this.cBe = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alm() {
        if (!this.cAI.isHardwareAccelerated()) {
            if (this.cBI == null) {
                this.cBI = new com.baidu.tieba.horizonalList.widget.b(this);
            }
            post(this.cBI);
        }
    }

    boolean ax(int i2, int i3) {
        int min;
        int min2;
        int i4;
        int childCount = getChildCount();
        if (childCount == 0) {
            return true;
        }
        int left = getChildAt(0).getLeft();
        int right = getChildAt(childCount - 1).getRight();
        Rect rect = this.cBa;
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
        int i6 = this.cCQ;
        if (i6 == 0) {
            this.cBQ = left - rect.left;
        } else {
            this.cBQ += min2;
        }
        if (i6 + childCount == this.cDd) {
            this.cBR = rect.right + right;
        } else {
            this.cBR += min2;
        }
        boolean z = i6 == 0 && left >= rect.left && min2 >= 0;
        boolean z2 = i6 + childCount == this.cDd && right <= getWidth() - rect.right && min2 <= 0;
        if (z || z2) {
            return min2 != 0;
        }
        boolean z3 = min2 < 0;
        boolean isInTouchMode = isInTouchMode();
        if (isInTouchMode) {
            aln();
        }
        int headerViewsCount = getHeaderViewsCount();
        int footerViewsCount = this.cDd - getFooterViewsCount();
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
                    this.cAV.r(childAt, i11);
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
                    this.cAV.r(childAt2, i14);
                }
                i4 = i13;
                i7 = i12;
            }
        }
        this.cBi = this.cBh + min;
        this.cDl = true;
        if (i4 > 0) {
            detachViewsFromParent(i7, i4);
            this.cAV.aly();
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        kw(min2);
        if (z3) {
            this.cCQ = i4 + this.cCQ;
        }
        int abs = Math.abs(min2);
        if (i5 < abs || width < abs) {
            fk(z3);
        }
        if (!isInTouchMode && this.cjp != -1) {
            int i15 = this.cjp - this.cCQ;
            if (i15 >= 0 && i15 < getChildCount()) {
                d(this.cjp, getChildAt(i15));
            }
        } else if (this.cAT != -1) {
            int i16 = this.cAT - this.cCQ;
            if (i16 >= 0 && i16 < getChildCount()) {
                d(-1, getChildAt(i16));
            }
        } else {
            this.cAU.setEmpty();
        }
        this.cDl = false;
        akY();
        return false;
    }

    public void kw(int i2) {
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
    public void aln() {
        if (this.cjp != -1) {
            if (this.cAP != 4) {
                this.cBv = this.cjp;
            }
            if (this.cDa >= 0 && this.cDa != this.cjp) {
                this.cBv = this.cDa;
            }
            setSelectedPositionInt(-1);
            setNextSelectedPositionInt(-1);
            this.cBq = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int alo() {
        int i2 = this.cjp;
        if (i2 < 0) {
            i2 = this.cBv;
        }
        return Math.min(Math.max(0, i2), this.cDd - 1);
    }

    protected int ky(int i2) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return -1;
        }
        int kx = kx(i2);
        return kx == -1 ? (this.cCQ + childCount) - 1 : kx;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean alp() {
        if (this.cjp >= 0 || !alq()) {
            return false;
        }
        alg();
        return true;
    }

    boolean alq() {
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
        int i8 = this.cBa.left;
        int right = (getRight() - getLeft()) - this.cBa.right;
        int i9 = this.cCQ;
        int i10 = this.cBv;
        if (i10 >= i9 && i10 < i9 + childCount) {
            View childAt = getChildAt(i10 - this.cCQ);
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
            int i15 = this.cDd;
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
        this.cBv = -1;
        removeCallbacks(this.cBo);
        if (this.cBp != null) {
            this.cBp.stop();
        }
        this.cBl = -1;
        alm();
        this.cCR = i2;
        int q = q(i3, z);
        if (q < i9 || q > getLastVisiblePosition()) {
            q = -1;
        } else {
            this.cAP = 4;
            alg();
            setSelectionInt(q);
            akY();
        }
        kv(0);
        return q >= 0;
    }

    void alr() {
        int i2;
        boolean z;
        boolean z2;
        this.cAN.clear();
        int i3 = 0;
        boolean z3 = false;
        while (i3 < this.cAO.size()) {
            long keyAt = this.cAO.keyAt(i3);
            int intValue = this.cAO.valueAt(i3).intValue();
            if (keyAt != this.mAdapter.getItemId(intValue)) {
                int max = Math.max(0, intValue - 20);
                int min = Math.min(intValue + 20, this.cDd);
                while (true) {
                    if (max >= min) {
                        z2 = false;
                        break;
                    } else if (keyAt != this.mAdapter.getItemId(max)) {
                        max++;
                    } else {
                        this.cAN.put(max, true);
                        this.cAO.setValueAt(i3, Integer.valueOf(max));
                        z2 = true;
                        break;
                    }
                }
                if (!z2) {
                    this.cAO.delete(keyAt);
                    int i4 = i3 - 1;
                    this.cAM--;
                    if (Build.VERSION.SDK_INT <= 11 || this.cAK == null || this.cAL == null) {
                        i2 = i4;
                        z = true;
                    } else {
                        ((com.baidu.tieba.horizonalList.a.a.b) this.cAL).onItemCheckedStateChanged((ActionMode) this.cAK, intValue, keyAt, false);
                        i2 = i4;
                        z = true;
                    }
                    z3 = z;
                    i3 = i2 + 1;
                }
            } else {
                this.cAN.put(intValue, true);
            }
            i2 = i3;
            z = z3;
            z3 = z;
            i3 = i2 + 1;
        }
        if (z3 && this.cAK != null && Build.VERSION.SDK_INT > 11) {
            ((ActionMode) this.cAK).invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.g
    public void handleDataChanged() {
        int i2 = this.cDd;
        int i3 = this.cBZ;
        this.cBZ = this.cDd;
        if (this.cAJ != 0 && this.mAdapter != null && this.mAdapter.hasStableIds()) {
            alr();
        }
        this.cAV.alx();
        if (i2 > 0) {
            if (this.cCV) {
                this.cCV = false;
                this.cCb = null;
                if (this.cBE == 2) {
                    this.cAP = 3;
                    return;
                }
                if (this.cBE == 1) {
                    if (this.cBS) {
                        this.cBS = false;
                        this.cAP = 3;
                        return;
                    }
                    int childCount = getChildCount();
                    int width = getWidth() - getPaddingRight();
                    View childAt = getChildAt(childCount - 1);
                    int bottom = childAt != null ? childAt.getBottom() : width;
                    if (childCount + this.cCQ >= i3 && bottom <= width) {
                        this.cAP = 3;
                        return;
                    }
                    awakenScrollBars();
                }
                switch (this.cCW) {
                    case 1:
                        this.cAP = 5;
                        this.cCS = Math.min(Math.max(0, this.cCS), i2 - 1);
                        return;
                    case 0:
                        if (isInTouchMode()) {
                            this.cAP = 5;
                            this.cCS = Math.min(Math.max(0, this.cCS), i2 - 1);
                            return;
                        }
                        int alJ = alJ();
                        if (alJ >= 0 && q(alJ, true) == alJ) {
                            this.cCS = alJ;
                            if (this.cCU == getWidth()) {
                                this.cAP = 5;
                            } else {
                                this.cAP = 2;
                            }
                            setNextSelectedPositionInt(alJ);
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
            } else if (this.cBv >= 0) {
                return;
            }
        }
        this.cAP = this.cBr ? 3 : 1;
        this.cjp = -1;
        this.cDc = Long.MIN_VALUE;
        this.cDa = -1;
        this.cDb = Long.MIN_VALUE;
        this.cCV = false;
        this.cCb = null;
        this.cAT = -1;
        alI();
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
        this.cBE = i2;
    }

    public int getTranscriptMode() {
        return this.cBE;
    }

    @Override // android.view.View
    public int getSolidColor() {
        return this.cBF;
    }

    public void setCacheColorHint(int i2) {
        if (i2 != this.cBF) {
            this.cBF = i2;
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                getChildAt(i3).setDrawingCacheBackgroundColor(i2);
            }
            this.cAV.setCacheColorHint(i2);
        }
    }

    @ViewDebug.ExportedProperty(category = "drawing")
    public int getCacheColorHint() {
        return this.cBF;
    }

    private void als() {
        if (this.cBO != null) {
            this.cBO.finish();
            this.cBP.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ay(int i2, int i3) {
    }

    public void setRecyclerListener(l lVar) {
        this.cAV.cCz = lVar;
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
        public int cCl;
        public boolean cCm;
        public boolean cCn;
        public int cCo;
        public long cCp;

        public f(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.cCp = -1L;
        }

        public f(int i, int i2) {
            super(i, i2);
            this.cCp = -1L;
        }

        public f(int i, int i2, int i3) {
            super(i, i2);
            this.cCp = -1L;
            this.cCl = i3;
        }

        public f(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.cCp = -1L;
        }
    }

    /* loaded from: classes.dex */
    public class k {
        private int cCA;
        private View[] cCB = new View[0];
        private ArrayList<View>[] cCC;
        private int cCD;
        private ArrayList<View> cCE;
        private ArrayList<View> cCF;
        private SparseArrayCompat<View> cCG;
        private l cCz;

        public k() {
        }

        public void kC(int i) {
            if (i < 1) {
                throw new IllegalArgumentException("Can't have a viewTypeCount < 1");
            }
            ArrayList<View>[] arrayListArr = new ArrayList[i];
            for (int i2 = 0; i2 < i; i2++) {
                arrayListArr[i2] = new ArrayList<>();
            }
            this.cCD = i;
            this.cCE = arrayListArr[0];
            this.cCC = arrayListArr;
        }

        public void alw() {
            if (this.cCD == 1) {
                ArrayList<View> arrayList = this.cCE;
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    arrayList.get(i).forceLayout();
                }
            } else {
                int i2 = this.cCD;
                for (int i3 = 0; i3 < i2; i3++) {
                    ArrayList<View> arrayList2 = this.cCC[i3];
                    int size2 = arrayList2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        arrayList2.get(i4).forceLayout();
                    }
                }
            }
            if (this.cCG != null) {
                int size3 = this.cCG.size();
                for (int i5 = 0; i5 < size3; i5++) {
                    this.cCG.valueAt(i5).forceLayout();
                }
            }
        }

        public boolean kD(int i) {
            return i >= 0;
        }

        public void clear() {
            if (this.cCD == 1) {
                ArrayList<View> arrayList = this.cCE;
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    AbsHListView.this.removeDetachedView(arrayList.remove((size - 1) - i), false);
                }
            } else {
                int i2 = this.cCD;
                for (int i3 = 0; i3 < i2; i3++) {
                    ArrayList<View> arrayList2 = this.cCC[i3];
                    int size2 = arrayList2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        AbsHListView.this.removeDetachedView(arrayList2.remove((size2 - 1) - i4), false);
                    }
                }
            }
            if (this.cCG != null) {
                this.cCG.clear();
            }
        }

        public void aA(int i, int i2) {
            if (this.cCB.length < i) {
                this.cCB = new View[i];
            }
            this.cCA = i2;
            View[] viewArr = this.cCB;
            for (int i3 = 0; i3 < i; i3++) {
                View childAt = AbsHListView.this.getChildAt(i3);
                f fVar = (f) childAt.getLayoutParams();
                if (fVar != null && fVar.cCl != -2) {
                    viewArr[i3] = childAt;
                }
            }
        }

        public View kE(int i) {
            int i2 = i - this.cCA;
            View[] viewArr = this.cCB;
            if (i2 < 0 || i2 >= viewArr.length) {
                return null;
            }
            View view = viewArr[i2];
            viewArr[i2] = null;
            return view;
        }

        View kF(int i) {
            int indexOfKey;
            if (this.cCG != null && (indexOfKey = this.cCG.indexOfKey(i)) >= 0) {
                View valueAt = this.cCG.valueAt(indexOfKey);
                this.cCG.removeAt(indexOfKey);
                return valueAt;
            }
            return null;
        }

        void alx() {
            if (this.cCG != null) {
                this.cCG.clear();
            }
        }

        View kG(int i) {
            if (this.cCD == 1) {
                return AbsHListView.a(this.cCE, i);
            }
            int itemViewType = AbsHListView.this.mAdapter.getItemViewType(i);
            if (itemViewType >= 0 && itemViewType < this.cCC.length) {
                return AbsHListView.a(this.cCC[itemViewType], i);
            }
            return null;
        }

        public void r(View view, int i) {
            f fVar = (f) view.getLayoutParams();
            if (fVar != null) {
                fVar.cCo = i;
                int i2 = fVar.cCl;
                if (!kD(i2)) {
                    if (i2 != -2) {
                        if (this.cCF == null) {
                            this.cCF = new ArrayList<>();
                        }
                        this.cCF.add(view);
                        return;
                    }
                    return;
                }
                view.onStartTemporaryDetach();
                if (this.cCD == 1) {
                    this.cCE.add(view);
                } else {
                    this.cCC[i2].add(view);
                }
                if (Build.VERSION.SDK_INT >= 14) {
                    view.setAccessibilityDelegate(null);
                }
                if (this.cCz != null) {
                    this.cCz.onMovedToScrapHeap(view);
                }
            }
        }

        public void aly() {
            if (this.cCF != null) {
                int size = this.cCF.size();
                for (int i = 0; i < size; i++) {
                    AbsHListView.this.removeDetachedView(this.cCF.get(i), false);
                }
                this.cCF.clear();
            }
        }

        public void alz() {
            View[] viewArr = this.cCB;
            boolean z = this.cCz != null;
            boolean z2 = this.cCD > 1;
            ArrayList<View> arrayList = this.cCE;
            for (int length = viewArr.length - 1; length >= 0; length--) {
                View view = viewArr[length];
                if (view != null) {
                    f fVar = (f) view.getLayoutParams();
                    int i = fVar.cCl;
                    viewArr[length] = null;
                    if (!kD(i)) {
                        if (i != -2) {
                            AbsHListView.this.removeDetachedView(view, false);
                        }
                    } else {
                        if (z2) {
                            arrayList = this.cCC[i];
                        }
                        view.onStartTemporaryDetach();
                        fVar.cCo = this.cCA + length;
                        arrayList.add(view);
                        if (Build.VERSION.SDK_INT >= 14) {
                            view.setAccessibilityDelegate(null);
                        }
                        if (z) {
                            this.cCz.onMovedToScrapHeap(view);
                        }
                    }
                }
            }
            alA();
        }

        private void alA() {
            int length = this.cCB.length;
            int i = this.cCD;
            ArrayList<View>[] arrayListArr = this.cCC;
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
            if (this.cCG != null) {
                for (int i6 = 0; i6 < this.cCG.size(); i6++) {
                    this.cCG.valueAt(i6);
                }
            }
        }

        void setCacheColorHint(int i) {
            View[] viewArr;
            if (this.cCD == 1) {
                ArrayList<View> arrayList = this.cCE;
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    arrayList.get(i2).setDrawingCacheBackgroundColor(i);
                }
            } else {
                int i3 = this.cCD;
                for (int i4 = 0; i4 < i3; i4++) {
                    ArrayList<View> arrayList2 = this.cCC[i4];
                    int size2 = arrayList2.size();
                    for (int i5 = 0; i5 < size2; i5++) {
                        arrayList2.get(i5).setDrawingCacheBackgroundColor(i);
                    }
                }
            }
            for (View view : this.cCB) {
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
                if (((f) view.getLayoutParams()).cCo == i2) {
                    arrayList.remove(i3);
                    return view;
                }
            }
            return arrayList.remove(size - 1);
        }
        return null;
    }
}
