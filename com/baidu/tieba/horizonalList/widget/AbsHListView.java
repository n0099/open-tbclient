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
    static final Interpolator cuW = new LinearInterpolator();
    public static final int[] cuY = new int[1];
    Drawable AG;
    a.AbstractC0062a ctE;
    protected int ctF;
    public Object ctG;
    Object ctH;
    int ctI;
    protected SparseArrayCompat<Boolean> ctJ;
    LongSparseArray<Integer> ctK;
    protected int ctL;
    protected a ctM;
    boolean ctN;
    boolean ctO;
    int ctP;
    protected Rect ctQ;
    protected final k ctR;
    int ctS;
    int ctT;
    int ctU;
    int ctV;
    protected Rect ctW;
    protected int ctX;
    View ctY;
    View ctZ;
    private int cuA;
    private int cuB;
    private boolean cuC;
    private int cuD;
    private Runnable cuE;
    protected Runnable cuF;
    private float cuG;
    protected final boolean[] cuH;
    int cuI;
    int cuJ;
    private EdgeEffectCompat cuK;
    private EdgeEffectCompat cuL;
    private int cuM;
    private int cuN;
    private boolean cuO;
    private int cuP;
    private int cuQ;
    private g cuR;
    private int cuS;
    private int cuT;
    protected boolean cuU;
    private int cuV;
    private SavedState cuX;
    private float cuZ;
    protected boolean cua;
    protected boolean cub;
    protected int cuc;
    int cud;
    int cue;
    int cuf;
    int cug;
    protected int cuh;
    int cui;
    int cuj;
    private e cuk;
    protected j cul;
    protected int cum;
    protected boolean cun;
    private h cuo;
    private boolean cup;
    private Rect cuq;
    protected int cur;
    private ContextMenu.ContextMenuInfo cus;
    protected int cut;
    private int cuu;
    private c cuv;
    private Runnable cuw;
    private b cux;
    private i cuy;
    private Runnable cuz;
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

    protected abstract void fg(boolean z);

    protected abstract int jK(int i2);

    public abstract void setSelectionInt(int i2);

    public AbsHListView(Context context) {
        super(context);
        this.ctF = 0;
        this.ctL = 0;
        this.ctO = false;
        this.ctP = -1;
        this.ctQ = new Rect();
        this.ctR = new k();
        this.ctS = 0;
        this.ctT = 0;
        this.ctU = 0;
        this.ctV = 0;
        this.ctW = new Rect();
        this.ctX = 0;
        this.cuh = -1;
        this.cum = 0;
        this.cup = true;
        this.cur = -1;
        this.cus = null;
        this.cuu = -1;
        this.cuD = 0;
        this.cuG = 1.0f;
        this.cuH = new boolean[1];
        this.mActivePointerId = -1;
        this.mDirection = 0;
        ajO();
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
        this.ctF = 0;
        this.ctL = 0;
        this.ctO = false;
        this.ctP = -1;
        this.ctQ = new Rect();
        this.ctR = new k();
        this.ctS = 0;
        this.ctT = 0;
        this.ctU = 0;
        this.ctV = 0;
        this.ctW = new Rect();
        this.ctX = 0;
        this.cuh = -1;
        this.cum = 0;
        this.cup = true;
        this.cur = -1;
        this.cus = null;
        this.cuu = -1;
        this.cuD = 0;
        this.cuG = 1.0f;
        this.cuH = new boolean[1];
        this.mActivePointerId = -1;
        this.mDirection = 0;
        ajO();
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
        this.ctO = z3;
        setStackFromRight(z2);
        setScrollingCacheEnabled(z);
        setTranscriptMode(i3);
        setCacheColorHint(i4);
        setSmoothScrollbarEnabled(z4);
        setChoiceMode(i5);
    }

    private void ajO() {
        setClickable(true);
        setFocusableInTouchMode(true);
        setWillNotDraw(false);
        setAlwaysDrawnWithCacheEnabled(false);
        setScrollingCacheEnabled(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.cuI = viewConfiguration.getScaledOverscrollDistance();
        this.cuJ = viewConfiguration.getScaledOverflingDistance();
        this.ctE = com.baidu.tieba.horizonalList.a.a.au(this);
    }

    @Override // android.view.View
    public void setOverScrollMode(int i2) {
        if (i2 != 2) {
            if (this.cuK == null) {
                Context context = getContext();
                this.cuK = new EdgeEffectCompat(context);
                this.cuL = new EdgeEffectCompat(context);
            }
        } else {
            this.cuK = null;
            this.cuL = null;
        }
        super.setOverScrollMode(i2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.horizonalList.widget.g
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            this.ctN = this.mAdapter.hasStableIds();
            if (this.ctF != 0 && this.ctN && this.ctK == null) {
                this.ctK = new LongSparseArray<>();
            }
        }
        if (this.ctJ != null) {
            this.ctJ.clear();
        }
        if (this.ctK != null) {
            this.ctK.clear();
        }
    }

    public int getCheckedItemCount() {
        return this.ctI;
    }

    public boolean isItemChecked(int i2) {
        if (this.ctF == 0 || this.ctJ == null) {
            return false;
        }
        return this.ctJ.get(i2, false).booleanValue();
    }

    public int getCheckedItemPosition() {
        if (this.ctF == 1 && this.ctJ != null && this.ctJ.size() == 1) {
            return this.ctJ.keyAt(0);
        }
        return -1;
    }

    public SparseArrayCompat<Boolean> getCheckedItemPositions() {
        if (this.ctF != 0) {
            return this.ctJ;
        }
        return null;
    }

    public long[] getCheckedItemIds() {
        if (this.ctF == 0 || this.ctK == null || this.mAdapter == null) {
            return new long[0];
        }
        LongSparseArray<Integer> longSparseArray = this.ctK;
        int size = longSparseArray.size();
        long[] jArr = new long[size];
        for (int i2 = 0; i2 < size; i2++) {
            jArr[i2] = longSparseArray.keyAt(i2);
        }
        return jArr;
    }

    public void clearChoices() {
        if (this.ctJ != null) {
            this.ctJ.clear();
        }
        if (this.ctK != null) {
            this.ctK.clear();
        }
        this.ctI = 0;
    }

    public void setItemChecked(int i2, boolean z) {
        if (this.ctF != 0) {
            if (Build.VERSION.SDK_INT >= 11 && z && this.ctF == 3 && this.ctG == null) {
                if (this.ctH == null || !((com.baidu.tieba.horizonalList.a.a.b) this.ctH).ajN()) {
                    throw new IllegalStateException("AbsListView: attempted to start selection mode for CHOICE_MODE_MULTIPLE_MODAL but no choice mode callback was supplied. Call setMultiChoiceModeListener to set a callback.");
                }
                this.ctG = startActionMode((com.baidu.tieba.horizonalList.a.a.b) this.ctH);
            }
            if (this.ctF == 2 || (Build.VERSION.SDK_INT >= 11 && this.ctF == 3)) {
                boolean booleanValue = this.ctJ.get(i2, false).booleanValue();
                this.ctJ.put(i2, Boolean.valueOf(z));
                if (this.ctK != null && this.mAdapter.hasStableIds()) {
                    if (z) {
                        this.ctK.put(this.mAdapter.getItemId(i2), Integer.valueOf(i2));
                    } else {
                        this.ctK.delete(this.mAdapter.getItemId(i2));
                    }
                }
                if (booleanValue != z) {
                    if (z) {
                        this.ctI++;
                    } else {
                        this.ctI--;
                    }
                }
                if (this.ctG != null) {
                    ((com.baidu.tieba.horizonalList.a.a.b) this.ctH).onItemCheckedStateChanged((ActionMode) this.ctG, i2, this.mAdapter.getItemId(i2), z);
                }
            } else {
                boolean z2 = this.ctK != null && this.mAdapter.hasStableIds();
                if (z || isItemChecked(i2)) {
                    this.ctJ.clear();
                    if (z2) {
                        this.ctK.clear();
                    }
                }
                if (z) {
                    this.ctJ.put(i2, true);
                    if (z2) {
                        this.ctK.put(this.mAdapter.getItemId(i2), Integer.valueOf(i2));
                    }
                    this.ctI = 1;
                } else if (this.ctJ.size() == 0 || !this.ctJ.valueAt(0).booleanValue()) {
                    this.ctI = 0;
                }
            }
            if (!this.mInLayout && !this.cwh) {
                this.aeC = true;
                akD();
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
        if (this.ctF != 0) {
            if (this.ctF == 2 || (Build.VERSION.SDK_INT >= 11 && this.ctF == 3 && this.ctG != null)) {
                boolean z5 = !this.ctJ.get(i2, false).booleanValue();
                this.ctJ.put(i2, Boolean.valueOf(z5));
                if (this.ctK != null && this.mAdapter.hasStableIds()) {
                    if (z5) {
                        this.ctK.put(this.mAdapter.getItemId(i2), Integer.valueOf(i2));
                    } else {
                        this.ctK.delete(this.mAdapter.getItemId(i2));
                    }
                }
                if (z5) {
                    this.ctI++;
                } else {
                    this.ctI--;
                }
                if (this.ctG != null) {
                    ((com.baidu.tieba.horizonalList.a.a.b) this.ctH).onItemCheckedStateChanged((ActionMode) this.ctG, i2, j2, z5);
                } else {
                    z4 = true;
                }
                z2 = z4;
                z4 = true;
            } else if (this.ctF == 1) {
                if (!this.ctJ.get(i2, false).booleanValue()) {
                    this.ctJ.clear();
                    this.ctJ.put(i2, true);
                    if (this.ctK != null && this.mAdapter.hasStableIds()) {
                        this.ctK.clear();
                        this.ctK.put(this.mAdapter.getItemId(i2), Integer.valueOf(i2));
                    }
                    this.ctI = 1;
                } else if (this.ctJ.size() == 0 || !this.ctJ.valueAt(0).booleanValue()) {
                    this.ctI = 0;
                }
                z4 = true;
                z2 = true;
            } else {
                z2 = true;
            }
            if (z4) {
                ajP();
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

    private void ajP() {
        int i2 = this.cvM;
        int childCount = getChildCount();
        boolean z = Build.VERSION.SDK_INT >= 11;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            int i4 = i2 + i3;
            if (childAt instanceof Checkable) {
                ((Checkable) childAt).setChecked(this.ctJ.get(i4, false).booleanValue());
            } else if (z) {
                childAt.setActivated(this.ctJ.get(i4, false).booleanValue());
            }
        }
    }

    public int getChoiceMode() {
        return this.ctF;
    }

    public void setChoiceMode(int i2) {
        this.ctF = i2;
        if (Build.VERSION.SDK_INT >= 11 && this.ctG != null) {
            if (Build.VERSION.SDK_INT >= 11) {
                ((ActionMode) this.ctG).finish();
            }
            this.ctG = null;
        }
        if (this.ctF != 0) {
            if (this.ctJ == null) {
                this.ctJ = new SparseArrayCompat<>();
            }
            if (this.ctK == null && this.mAdapter != null && this.mAdapter.hasStableIds()) {
                this.ctK = new LongSparseArray<>();
            }
            if (Build.VERSION.SDK_INT >= 11 && this.ctF == 3) {
                clearChoices();
                setLongClickable(true);
            }
        }
    }

    public void setMultiChoiceModeListener(com.baidu.tieba.horizonalList.a.a.a aVar) {
        if (Build.VERSION.SDK_INT >= 11) {
            if (this.ctH == null) {
                this.ctH = new com.baidu.tieba.horizonalList.a.a.b(this);
            }
            ((com.baidu.tieba.horizonalList.a.a.b) this.ctH).a(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ajQ() {
        int childCount = getChildCount();
        if (childCount == 0) {
            return true;
        }
        if (childCount != this.cvZ) {
            return false;
        }
        return getChildAt(0).getLeft() >= this.ctW.left && getChildAt(childCount + (-1)).getRight() <= getWidth() - this.ctW.right;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public int getHorizontalScrollbarHeight() {
        return super.getHorizontalScrollbarHeight();
    }

    public void setSmoothScrollbarEnabled(boolean z) {
        this.cup = z;
    }

    public void setOnScrollListener(h hVar) {
        this.cuo = hVar;
        ajR();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ajR() {
        if (this.cuo != null) {
            this.cuo.a(this, this.cvM, getChildCount(), this.cvZ);
        }
        onScrollChanged(0, 0, 0, 0);
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEvent(int i2) {
        if (i2 == 4096) {
            int firstVisiblePosition = getFirstVisiblePosition();
            int lastVisiblePosition = getLastVisiblePosition();
            if (this.cuS != firstVisiblePosition || this.cuT != lastVisiblePosition) {
                this.cuS = firstVisiblePosition;
                this.cuT = lastVisiblePosition;
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
            akf();
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

    private void ajS() {
        setSelector(getResources().getDrawable(17301602));
    }

    public void setStackFromRight(boolean z) {
        if (this.cun != z) {
            this.cun = z;
            ajT();
        }
    }

    void ajT() {
        if (getChildCount() > 0) {
            ajU();
            requestLayout();
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new com.baidu.tieba.horizonalList.widget.f();
        long cvD;
        long cvE;
        int cvF;
        String cvG;
        boolean cvH;
        int cvI;
        SparseArrayCompat<Boolean> cvJ;
        LongSparseArray<Integer> cvK;
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
            this.cvD = parcel.readLong();
            this.cvE = parcel.readLong();
            this.cvF = parcel.readInt();
            this.position = parcel.readInt();
            this.width = parcel.readInt();
            this.cvG = parcel.readString();
            this.cvH = parcel.readByte() != 0;
            this.cvI = parcel.readInt();
            this.cvJ = f(parcel);
            this.cvK = e(parcel);
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
            parcel.writeLong(this.cvD);
            parcel.writeLong(this.cvE);
            parcel.writeInt(this.cvF);
            parcel.writeInt(this.position);
            parcel.writeInt(this.width);
            parcel.writeString(this.cvG);
            parcel.writeByte((byte) (this.cvH ? 1 : 0));
            parcel.writeInt(this.cvI);
            a(this.cvJ, parcel);
            a(this.cvK, parcel);
        }

        public String toString() {
            return "AbsListView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " selectedId=" + this.cvD + " firstId=" + this.cvE + " viewLeft=" + this.cvF + " position=" + this.position + " width=" + this.width + " filter=" + this.cvG + " checkState=" + this.cvJ + "}";
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        boolean z = true;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.cuX != null) {
            savedState.cvD = this.cuX.cvD;
            savedState.cvE = this.cuX.cvE;
            savedState.cvF = this.cuX.cvF;
            savedState.position = this.cuX.position;
            savedState.width = this.cuX.width;
            savedState.cvG = this.cuX.cvG;
            savedState.cvH = this.cuX.cvH;
            savedState.cvI = this.cuX.cvI;
            savedState.cvJ = this.cuX.cvJ;
            savedState.cvK = this.cuX.cvK;
            return savedState;
        }
        boolean z2 = getChildCount() > 0 && this.cvZ > 0;
        long selectedItemId = getSelectedItemId();
        savedState.cvD = selectedItemId;
        savedState.width = getWidth();
        if (selectedItemId >= 0) {
            savedState.cvF = this.cum;
            savedState.position = getSelectedItemPosition();
            savedState.cvE = -1L;
        } else if (z2 && this.cvM > 0) {
            savedState.cvF = getChildAt(0).getLeft();
            int i2 = this.cvM;
            if (i2 >= this.cvZ) {
                i2 = this.cvZ - 1;
            }
            savedState.position = i2;
            savedState.cvE = this.mAdapter.getItemId(i2);
        } else {
            savedState.cvF = 0;
            savedState.cvE = -1L;
            savedState.position = 0;
        }
        savedState.cvG = null;
        savedState.cvH = (Build.VERSION.SDK_INT < 11 || this.ctF != 3 || this.ctG == null) ? false : false;
        if (this.ctJ != null) {
            try {
                savedState.cvJ = this.ctJ.m1clone();
            } catch (NoSuchMethodError e2) {
                e2.printStackTrace();
                savedState.cvJ = new SparseArrayCompat<>();
            }
        }
        if (this.ctK != null) {
            LongSparseArray<Integer> longSparseArray = new LongSparseArray<>();
            int size = this.ctK.size();
            for (int i3 = 0; i3 < size; i3++) {
                longSparseArray.put(this.ctK.keyAt(i3), this.ctK.valueAt(i3));
            }
            savedState.cvK = longSparseArray;
        }
        savedState.cvI = this.ctI;
        return savedState;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.aeC = true;
        this.cvQ = savedState.width;
        if (savedState.cvD >= 0) {
            this.cvR = true;
            this.cuX = savedState;
            this.cvP = savedState.cvD;
            this.cvO = savedState.position;
            this.cvN = savedState.cvF;
            this.cvS = 0;
        } else if (savedState.cvE >= 0) {
            setSelectedPositionInt(-1);
            setNextSelectedPositionInt(-1);
            this.ctP = -1;
            this.cvR = true;
            this.cuX = savedState;
            this.cvP = savedState.cvE;
            this.cvO = savedState.position;
            this.cvN = savedState.cvF;
            this.cvS = 1;
        }
        if (savedState.cvJ != null) {
            this.ctJ = savedState.cvJ;
        }
        if (savedState.cvK != null) {
            this.ctK = savedState.cvK;
        }
        this.ctI = savedState.cvI;
        if (Build.VERSION.SDK_INT >= 11 && savedState.cvH && this.ctF == 3 && this.ctH != null) {
            this.ctG = startActionMode((com.baidu.tieba.horizonalList.a.a.b) this.ctH);
        }
        requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onFocusChanged(boolean z, int i2, Rect rect) {
        super.onFocusChanged(z, i2, rect);
        if (z && this.ccS < 0 && !isInTouchMode()) {
            if (!this.cuU && this.mAdapter != null) {
                this.aeC = true;
                this.cwa = this.cvZ;
                this.cvZ = this.mAdapter.getCount();
            }
            akj();
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (!this.cwh && !this.mInLayout) {
            super.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ajU() {
        removeAllViewsInLayout();
        this.cvM = 0;
        this.aeC = false;
        this.cuF = null;
        this.cvR = false;
        this.cuX = null;
        this.cwc = -1;
        this.cwd = Long.MIN_VALUE;
        setSelectedPositionInt(-1);
        setNextSelectedPositionInt(-1);
        this.cum = 0;
        this.ctP = -1;
        this.ctQ.setEmpty();
        invalidate();
    }

    @Override // android.view.View
    protected int computeHorizontalScrollExtent() {
        int childCount = getChildCount();
        if (childCount > 0) {
            if (this.cup) {
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
        int i3 = this.cvM;
        int childCount = getChildCount();
        if (i3 < 0 || childCount <= 0) {
            return 0;
        }
        if (this.cup) {
            View childAt = getChildAt(0);
            int left = childAt.getLeft();
            int width = childAt.getWidth();
            if (width > 0) {
                return Math.max(((i3 * 100) - ((left * 100) / width)) + ((int) ((getScrollX() / getWidth()) * this.cvZ * 100.0f)), 0);
            }
            return 0;
        }
        int i4 = this.cvZ;
        if (i3 != 0) {
            i2 = i3 + childCount == i4 ? i4 : (childCount / 2) + i3;
        }
        return (int) (((i2 / i4) * childCount) + i3);
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        if (this.cup) {
            int max = Math.max(this.cvZ * 100, 0);
            if (getScrollX() != 0) {
                return max + Math.abs((int) ((getScrollX() / getWidth()) * this.cvZ * 100.0f));
            }
            return max;
        }
        return this.cvZ;
    }

    @Override // android.view.View
    protected float getLeftFadingEdgeStrength() {
        int childCount = getChildCount();
        float leftFadingEdgeStrength = super.getLeftFadingEdgeStrength();
        if (childCount != 0) {
            if (this.cvM > 0) {
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
            if ((this.cvM + childCount) - 1 < this.cvZ - 1) {
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
            ajS();
        }
        Rect rect = this.ctW;
        rect.left = this.ctS + getPaddingLeft();
        rect.top = this.ctT + getPaddingTop();
        rect.right = this.ctU + getPaddingRight();
        rect.bottom = this.ctV + getPaddingBottom();
        if (this.cuA == 1) {
            int childCount = getChildCount();
            int width = getWidth() - getPaddingRight();
            View childAt = getChildAt(childCount - 1);
            this.cuO = childCount + this.cvM >= this.cuV && (childAt != null ? childAt.getRight() : width) <= width;
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
            this.ctR.akp();
        }
        layoutChildren();
        this.mInLayout = false;
        this.cut = (i4 - i2) / 3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void layoutChildren() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ajV() {
        boolean z = true;
        if (this.ctY != null) {
            boolean z2 = this.cvM > 0;
            if (!z2 && getChildCount() > 0) {
                z2 = getChildAt(0).getLeft() < this.ctW.left;
            }
            this.ctY.setVisibility(z2 ? 0 : 4);
        }
        if (this.ctZ != null) {
            int childCount = getChildCount();
            boolean z3 = this.cvM + childCount < this.cvZ;
            if (z3 || childCount <= 0) {
                z = z3;
            } else if (getChildAt(childCount - 1).getRight() <= getRight() - this.ctW.right) {
                z = false;
            }
            this.ctZ.setVisibility(z ? 0 : 4);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.g
    @ViewDebug.ExportedProperty
    public View getSelectedView() {
        if (this.cvZ <= 0 || this.ccS < 0) {
            return null;
        }
        return getChildAt(this.ccS - this.cvM);
    }

    public int getListPaddingTop() {
        return this.ctW.top;
    }

    public int getListPaddingBottom() {
        return this.ctW.bottom;
    }

    public int getListPaddingLeft() {
        return this.ctW.left;
    }

    public int getListPaddingRight() {
        return this.ctW.right;
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
        View jS = this.ctR.jS(i2);
        if (jS == null) {
            View jT = this.ctR.jT(i2);
            if (jT != null) {
                view = this.mAdapter.getView(i2, jT, this);
                if (view != jT) {
                    this.ctR.r(jT, i2);
                    if (this.cuB != 0) {
                        view.setDrawingCacheBackgroundColor(this.cuB);
                        jS = view;
                    }
                } else {
                    zArr[0] = true;
                    view.onFinishTemporaryDetach();
                    jS = view;
                }
                if (this.ctN) {
                    ViewGroup.LayoutParams layoutParams = jS.getLayoutParams();
                    if (layoutParams == null) {
                        fVar = (f) generateDefaultLayoutParams();
                    } else if (!checkLayoutParams(layoutParams)) {
                        fVar = (f) generateLayoutParams(layoutParams);
                    } else {
                        fVar = (f) layoutParams;
                    }
                    fVar.cvl = this.mAdapter.getItemId(i2);
                    jS.setLayoutParams(fVar);
                }
                if (this.cwb.isEnabled() && this.cuR == null) {
                    this.cuR = new g();
                }
            } else {
                view = this.mAdapter.getView(i2, null, this);
                if (this.cuB != 0) {
                    view.setDrawingCacheBackgroundColor(this.cuB);
                }
            }
            jS = view;
            if (this.ctN) {
            }
            if (this.cwb.isEnabled()) {
                this.cuR = new g();
            }
        }
        return jS;
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
            this.ctP = i2;
        }
        Rect rect = this.ctQ;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        if (view instanceof m) {
            ((m) view).adjustListItemSelectionBounds(rect);
        }
        k(rect.left, rect.top, rect.right, rect.bottom);
        boolean z = this.cuC;
        if (view.isEnabled() != z) {
            this.cuC = !z;
            if (getSelectedItemPosition() != -1) {
                refreshDrawableState();
            }
        }
    }

    private void k(int i2, int i3, int i4, int i5) {
        this.ctQ.set(i2 - this.ctS, i3 - this.ctT, this.ctU + i4, this.ctV + i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        boolean z = this.ctO;
        if (!z) {
            p(canvas);
        }
        super.dispatchDraw(canvas);
        if (z) {
            p(canvas);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        if (getChildCount() > 0) {
            this.aeC = true;
            akD();
        }
    }

    boolean ajW() {
        switch (this.cuh) {
            case 1:
            case 2:
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean ajX() {
        return (hasFocus() && !isInTouchMode()) || ajW();
    }

    private void p(Canvas canvas) {
        if (!this.ctQ.isEmpty()) {
            Drawable drawable = this.AG;
            drawable.setBounds(this.ctQ);
            drawable.draw(canvas);
        }
    }

    public void setDrawSelectorOnTop(boolean z) {
        this.ctO = z;
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
        this.ctS = rect.left;
        this.ctT = rect.top;
        this.ctU = rect.right;
        this.ctV = rect.bottom;
        drawable.setCallback(this);
        ajZ();
    }

    public Drawable getSelector() {
        return this.AG;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ajY() {
        if (isEnabled() && isClickable()) {
            Drawable drawable = this.AG;
            Rect rect = this.ctQ;
            if (drawable != null) {
                if ((isFocused() || ajW()) && !rect.isEmpty()) {
                    View childAt = getChildAt(this.ccS - this.cvM);
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
                    if (isLongClickable && !this.aeC) {
                        if (this.cux == null) {
                            this.cux = new b(this, null);
                        }
                        this.cux.aku();
                        postDelayed(this.cux, ViewConfiguration.getLongPressTimeout());
                    }
                }
            }
        }
    }

    void ajZ() {
        if (this.AG != null) {
            if (ajX()) {
                this.AG.setState(getDrawableState());
            } else {
                this.AG.setState(cuY);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        ajZ();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i2) {
        if (this.cuC) {
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
        if (this.mAdapter != null && this.ctM == null) {
            this.ctM = new a();
            this.mAdapter.registerDataSetObserver(this.ctM);
            this.aeC = true;
            this.cwa = this.cvZ;
            this.cvZ = this.mAdapter.getCount();
        }
        this.cuU = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.g, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.ctR.clear();
        getViewTreeObserver().removeOnTouchModeChangeListener(this);
        if (this.mAdapter != null && this.ctM != null) {
            this.mAdapter.unregisterDataSetObserver(this.ctM);
            this.ctM = null;
        }
        if (this.cuk != null) {
            removeCallbacks(this.cuk);
        }
        if (this.cul != null) {
            this.cul.stop();
        }
        if (this.cuE != null) {
            removeCallbacks(this.cuE);
        }
        if (this.cuy != null) {
            removeCallbacks(this.cuy);
        }
        if (this.cuz != null) {
            removeCallbacks(this.cuz);
            this.cuz = null;
        }
        this.cuU = false;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        int i2 = isInTouchMode() ? 0 : 1;
        if (!z) {
            setChildrenDrawingCacheEnabled(false);
            if (this.cuk != null) {
                removeCallbacks(this.cuk);
                this.cuk.akn();
                if (this.cul != null) {
                    this.cul.stop();
                }
                if (getScrollX() != 0) {
                    this.ctE.setScrollX(0);
                    akl();
                    invalidate();
                }
            }
            if (i2 == 1) {
                this.cur = this.ccS;
            }
        } else if (i2 != this.cuu && this.cuu != -1) {
            if (i2 == 1) {
                akj();
            } else {
                akg();
                this.ctL = 0;
                layoutChildren();
            }
        }
        this.cuu = i2;
    }

    ContextMenu.ContextMenuInfo b(View view, int i2, long j2) {
        return new g.a(view, i2, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class n {
        private int cvL;

        private n() {
        }

        /* synthetic */ n(AbsHListView absHListView, n nVar) {
            this();
        }

        public void aku() {
            this.cvL = AbsHListView.this.getWindowAttachCount();
        }

        public boolean akv() {
            return AbsHListView.this.hasWindowFocus() && AbsHListView.this.getWindowAttachCount() == this.cvL;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class i extends n implements Runnable {
        int cvm;

        private i() {
            super(AbsHListView.this, null);
        }

        /* synthetic */ i(AbsHListView absHListView, i iVar) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            View childAt;
            if (!AbsHListView.this.aeC) {
                ListAdapter listAdapter = AbsHListView.this.mAdapter;
                int i = this.cvm;
                if (listAdapter != null && AbsHListView.this.cvZ > 0 && i != -1 && i < listAdapter.getCount() && akv() && (childAt = AbsHListView.this.getChildAt(i - AbsHListView.this.cvM)) != null) {
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
            View childAt = AbsHListView.this.getChildAt(AbsHListView.this.cuc - AbsHListView.this.cvM);
            if (childAt != null) {
                if ((!akv() || AbsHListView.this.aeC) ? false : AbsHListView.this.c(childAt, AbsHListView.this.cuc, AbsHListView.this.mAdapter.getItemId(AbsHListView.this.cuc))) {
                    AbsHListView.this.cuh = -1;
                    AbsHListView.this.setPressed(false);
                    childAt.setPressed(false);
                    return;
                }
                AbsHListView.this.cuh = 2;
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
            if (AbsHListView.this.isPressed() && AbsHListView.this.ccS >= 0) {
                View childAt = AbsHListView.this.getChildAt(AbsHListView.this.ccS - AbsHListView.this.cvM);
                if (!AbsHListView.this.aeC) {
                    if (akv() ? AbsHListView.this.c(childAt, AbsHListView.this.ccS, AbsHListView.this.cvY) : false) {
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
        if (Build.VERSION.SDK_INT >= 11 && this.ctF == 3) {
            if (this.ctG == null) {
                ActionMode startActionMode = startActionMode((com.baidu.tieba.horizonalList.a.a.b) this.ctH);
                this.ctG = startActionMode;
                if (startActionMode != null) {
                    setItemChecked(i2, true);
                    performHapticFeedback(0);
                }
            }
            return true;
        }
        boolean b2 = this.cvV != null ? this.cvV.b(this, view, i2, j2) : false;
        if (!b2) {
            this.cus = b(view, i2, j2);
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
        return this.cus;
    }

    public boolean b(float f2, float f3, int i2) {
        int pointToPosition = pointToPosition((int) f2, (int) f3);
        if (pointToPosition != -1) {
            long itemId = this.mAdapter.getItemId(pointToPosition);
            View childAt = getChildAt(pointToPosition - this.cvM);
            if (childAt != null) {
                this.cus = b(childAt, pointToPosition, itemId);
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
            boolean b2 = this.cvV != null ? this.cvV.b(this, view, positionForView, itemId) : false;
            if (!b2) {
                this.cus = b(getChildAt(positionForView - this.cvM), positionForView, itemId);
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
                if (isClickable() && isPressed() && this.ccS >= 0 && this.mAdapter != null && this.ccS < this.mAdapter.getCount()) {
                    View childAt = getChildAt(this.ccS - this.cvM);
                    if (childAt != null) {
                        performItemClick(childAt, this.ccS, this.cvY);
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
        Rect rect = this.cuq;
        if (rect == null) {
            this.cuq = new Rect();
            rect = this.cuq;
        }
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt.getVisibility() == 0) {
                childAt.getHitRect(rect);
                if (rect.contains(i2, i3)) {
                    return this.cvM + childCount;
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
            if (AbsHListView.this.cuh == 0) {
                AbsHListView.this.cuh = 1;
                View childAt = AbsHListView.this.getChildAt(AbsHListView.this.cuc - AbsHListView.this.cvM);
                if (childAt != null && !childAt.hasFocusable()) {
                    AbsHListView.this.ctL = 0;
                    if (!AbsHListView.this.aeC) {
                        childAt.setPressed(true);
                        AbsHListView.this.setPressed(true);
                        AbsHListView.this.layoutChildren();
                        AbsHListView.this.b(AbsHListView.this.cuc, childAt);
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
                            if (AbsHListView.this.cuv == null) {
                                AbsHListView.this.cuv = new c(AbsHListView.this, null);
                            }
                            AbsHListView.this.cuv.aku();
                            AbsHListView.this.postDelayed(AbsHListView.this.cuv, longPressTimeout);
                            return;
                        }
                        AbsHListView.this.cuh = 2;
                        return;
                    }
                    AbsHListView.this.cuh = 2;
                }
            }
        }
    }

    private boolean jG(int i2) {
        int i3 = i2 - this.cuf;
        int abs = Math.abs(i3);
        boolean z = getScrollX() != 0;
        if (z || abs > this.mTouchSlop) {
            ake();
            if (z) {
                this.cuh = 5;
                this.cuj = 0;
            } else {
                this.cuh = 3;
                this.cuj = i3 > 0 ? this.mTouchSlop : -this.mTouchSlop;
            }
            Handler handler = getHandler();
            if (handler != null) {
                handler.removeCallbacks(this.cuv);
            }
            setPressed(false);
            View childAt = getChildAt(this.cuc - this.cvM);
            if (childAt != null) {
                childAt.setPressed(false);
            }
            jI(1);
            ViewParent parent = getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            jH(i2);
            return true;
        }
        return false;
    }

    private void jH(int i2) {
        int i3;
        int childCount;
        ViewParent parent;
        int i4 = i2 - this.cuf;
        int i5 = i4 - this.cuj;
        int i6 = this.cui != Integer.MIN_VALUE ? i2 - this.cui : i5;
        if (this.cuh == 3) {
            if (i2 != this.cui) {
                if (Math.abs(i4) > this.mTouchSlop && (parent = getParent()) != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
                if (this.cuc >= 0) {
                    childCount = this.cuc - this.cvM;
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
                        overScrollBy(i7, 0, getScrollX(), 0, 0, 0, this.cuI, 0, true);
                        if (Math.abs(this.cuI) == Math.abs(getScrollX()) && this.mVelocityTracker != null) {
                            this.mVelocityTracker.clear();
                        }
                        int overScrollMode = getOverScrollMode();
                        if (overScrollMode == 0 || (overScrollMode == 1 && !ajQ())) {
                            this.mDirection = 0;
                            this.cuh = 5;
                            if (i4 > 0) {
                                this.cuK.onPull(i7 / getWidth());
                                if (!this.cuL.isFinished()) {
                                    this.cuL.onRelease();
                                }
                                invalidate();
                            } else if (i4 < 0) {
                                this.cuL.onPull(i7 / getWidth());
                                if (!this.cuK.isFinished()) {
                                    this.cuK.onRelease();
                                }
                                invalidate();
                            }
                        }
                    }
                    this.cuf = i2;
                }
                this.cui = i2;
            }
        } else if (this.cuh == 5 && i2 != this.cui) {
            int scrollX = getScrollX();
            int i8 = scrollX - i6;
            int i9 = i2 > this.cui ? 1 : -1;
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
                overScrollBy(i10, 0, getScrollX(), 0, 0, 0, this.cuI, 0, true);
                int overScrollMode2 = getOverScrollMode();
                if (overScrollMode2 == 0 || (overScrollMode2 == 1 && !ajQ())) {
                    if (i4 > 0) {
                        this.cuK.onPull(i10 / getWidth());
                        if (!this.cuL.isFinished()) {
                            this.cuL.onRelease();
                        }
                        invalidate();
                    } else if (i4 < 0) {
                        this.cuL.onPull(i10 / getWidth());
                        if (!this.cuK.isFinished()) {
                            this.cuK.onRelease();
                        }
                        invalidate();
                    }
                }
            }
            if (i3 != 0) {
                if (getScrollX() != 0) {
                    this.ctE.setScrollX(0);
                    aka();
                }
                ax(i3, i3);
                this.cuh = 3;
                int jL = jL(i2);
                this.cuj = 0;
                View childAt3 = getChildAt(jL - this.cvM);
                this.cud = childAt3 != null ? childAt3.getLeft() : 0;
                this.cuf = i2;
                this.cuc = jL;
            }
            this.cui = i2;
            this.mDirection = i9;
        }
    }

    protected void aka() {
        if (this.ctE.isHardwareAccelerated() && (getParent() instanceof View)) {
            ((View) getParent()).invalidate();
        }
    }

    @Override // android.view.ViewTreeObserver.OnTouchModeChangeListener
    public void onTouchModeChanged(boolean z) {
        if (z) {
            akg();
            if (getWidth() > 0 && getChildCount() > 0) {
                layoutChildren();
            }
            ajZ();
            return;
        }
        int i2 = this.cuh;
        if (i2 == 5 || i2 == 6) {
            if (this.cuk != null) {
                this.cuk.akn();
            }
            if (this.cul != null) {
                this.cul.stop();
            }
            if (getScrollX() != 0) {
                this.ctE.setScrollX(0);
                akl();
                invalidate();
            }
        }
    }

    protected boolean j(MotionEvent motionEvent) {
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
        if (this.cul != null) {
            this.cul.stop();
        }
        if (this.cuU) {
            int action = motionEvent.getAction();
            akc();
            this.mVelocityTracker.addMovement(motionEvent);
            switch (action & MotionEventCompat.ACTION_MASK) {
                case 0:
                    switch (this.cuh) {
                        case 6:
                            this.cuk.akn();
                            if (this.cul != null) {
                                this.cul.stop();
                            }
                            this.cuh = 5;
                            this.cug = (int) motionEvent.getY();
                            int x = (int) motionEvent.getX();
                            this.cui = x;
                            this.cuf = x;
                            this.cuj = 0;
                            this.mActivePointerId = motionEvent.getPointerId(0);
                            this.mDirection = 0;
                            break;
                        default:
                            this.mActivePointerId = motionEvent.getPointerId(0);
                            int x2 = (int) motionEvent.getX();
                            int y = (int) motionEvent.getY();
                            int pointToPosition = pointToPosition(x2, y);
                            if (!this.aeC) {
                                if (this.cuh != 4 && pointToPosition >= 0 && getAdapter().isEnabled(pointToPosition)) {
                                    this.cuh = 0;
                                    if (this.cuw == null) {
                                        this.cuw = new d();
                                    }
                                    postDelayed(this.cuw, ViewConfiguration.getTapTimeout());
                                    i2 = pointToPosition;
                                } else if (this.cuh == 4) {
                                    ake();
                                    this.cuh = 3;
                                    this.cuj = 0;
                                    i2 = jK(x2);
                                    this.cuk.ako();
                                }
                                if (i2 >= 0) {
                                    this.cud = getChildAt(i2 - this.cvM).getLeft();
                                }
                                this.cuf = x2;
                                this.cug = y;
                                this.cuc = i2;
                                this.cui = ExploreByTouchHelper.INVALID_ID;
                                break;
                            }
                            i2 = pointToPosition;
                            if (i2 >= 0) {
                            }
                            this.cuf = x2;
                            this.cug = y;
                            this.cuc = i2;
                            this.cui = ExploreByTouchHelper.INVALID_ID;
                    }
                    if (j(motionEvent) && this.cuh == 0) {
                        removeCallbacks(this.cuw);
                        break;
                    }
                    break;
                case 1:
                    switch (this.cuh) {
                        case 0:
                        case 1:
                        case 2:
                            int i3 = this.cuc;
                            View childAt = getChildAt(i3 - this.cvM);
                            float x3 = motionEvent.getX();
                            boolean z = x3 > ((float) this.ctW.left) && x3 < ((float) (getWidth() - this.ctW.right));
                            if (childAt != null && !childAt.hasFocusable() && z) {
                                if (this.cuh != 0) {
                                    childAt.setPressed(false);
                                }
                                if (this.cuy == null) {
                                    this.cuy = new i(this, null);
                                }
                                i iVar = this.cuy;
                                iVar.cvm = i3;
                                iVar.aku();
                                this.cur = i3;
                                if (this.cuh == 0 || this.cuh == 1) {
                                    Handler handler = getHandler();
                                    if (handler != null) {
                                        handler.removeCallbacks(this.cuh == 0 ? this.cuw : this.cuv);
                                    }
                                    this.ctL = 0;
                                    if (!this.aeC && this.mAdapter.isEnabled(i3)) {
                                        this.cuh = 1;
                                        setSelectedPositionInt(this.cuc);
                                        layoutChildren();
                                        childAt.setPressed(true);
                                        b(this.cuc, childAt);
                                        setPressed(true);
                                        if (this.AG != null && (current = this.AG.getCurrent()) != null && (current instanceof TransitionDrawable)) {
                                            ((TransitionDrawable) current).resetTransition();
                                        }
                                        if (this.cuz != null) {
                                            removeCallbacks(this.cuz);
                                        }
                                        this.cuz = new com.baidu.tieba.horizonalList.widget.a(this, childAt, iVar);
                                        postDelayed(this.cuz, ViewConfiguration.getPressedStateDuration());
                                    } else {
                                        this.cuh = -1;
                                        ajZ();
                                    }
                                    return true;
                                } else if (!this.aeC && this.mAdapter.isEnabled(i3)) {
                                    iVar.run();
                                }
                            }
                            this.cuh = -1;
                            ajZ();
                            break;
                        case 3:
                            int childCount = getChildCount();
                            if (childCount > 0) {
                                int left = getChildAt(0).getLeft();
                                int right = getChildAt(childCount - 1).getRight();
                                int i4 = this.ctW.left;
                                int width = getWidth() - this.ctW.right;
                                if (this.cvM == 0 && left >= i4 && this.cvM + childCount < this.cvZ && right <= getWidth() - width) {
                                    this.cuh = -1;
                                    jI(0);
                                    break;
                                } else {
                                    VelocityTracker velocityTracker = this.mVelocityTracker;
                                    velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                                    int xVelocity = (int) (velocityTracker.getXVelocity(this.mActivePointerId) * this.cuG);
                                    if (Math.abs(xVelocity) > this.mMinimumVelocity && ((this.cvM != 0 || left != i4 - this.cuI) && (childCount + this.cvM != this.cvZ || right != this.cuI + width))) {
                                        if (this.cuk == null) {
                                            this.cuk = new e();
                                        }
                                        jI(2);
                                        this.cuk.jM(-xVelocity);
                                        break;
                                    } else {
                                        this.cuh = -1;
                                        jI(0);
                                        if (this.cuk != null) {
                                            this.cuk.akn();
                                        }
                                        if (this.cul != null) {
                                            this.cul.stop();
                                            break;
                                        }
                                    }
                                }
                            } else {
                                this.cuh = -1;
                                jI(0);
                                break;
                            }
                            break;
                        case 5:
                            if (this.cuk == null) {
                                this.cuk = new e();
                            }
                            VelocityTracker velocityTracker2 = this.mVelocityTracker;
                            velocityTracker2.computeCurrentVelocity(1000, this.mMaximumVelocity);
                            int xVelocity2 = (int) velocityTracker2.getXVelocity(this.mActivePointerId);
                            jI(2);
                            if (Math.abs(xVelocity2) > this.mMinimumVelocity) {
                                this.cuk.jN(-xVelocity2);
                                break;
                            } else {
                                this.cuk.akm();
                                break;
                            }
                    }
                    setPressed(false);
                    if (this.cuK != null) {
                        this.cuK.onRelease();
                        this.cuL.onRelease();
                    }
                    invalidate();
                    Handler handler2 = getHandler();
                    if (handler2 != null) {
                        handler2.removeCallbacks(this.cuv);
                    }
                    akd();
                    this.mActivePointerId = -1;
                    break;
                case 2:
                    int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                    if (findPointerIndex == -1) {
                        this.mActivePointerId = motionEvent.getPointerId(0);
                        findPointerIndex = 0;
                    }
                    int x4 = (int) motionEvent.getX(findPointerIndex);
                    if (this.aeC) {
                        layoutChildren();
                    }
                    switch (this.cuh) {
                        case 0:
                        case 1:
                        case 2:
                            jG(x4);
                            break;
                        case 3:
                        case 5:
                            jH(x4);
                            break;
                    }
                case 3:
                    switch (this.cuh) {
                        case 5:
                            if (this.cuk == null) {
                                this.cuk = new e();
                            }
                            this.cuk.akm();
                            break;
                        case 6:
                            break;
                        default:
                            this.cuh = -1;
                            setPressed(false);
                            View childAt2 = getChildAt(this.cuc - this.cvM);
                            if (childAt2 != null) {
                                childAt2.setPressed(false);
                            }
                            akf();
                            Handler handler3 = getHandler();
                            if (handler3 != null) {
                                handler3.removeCallbacks(this.cuv);
                            }
                            akd();
                            break;
                    }
                    if (this.cuK != null) {
                        this.cuK.onRelease();
                        this.cuL.onRelease();
                    }
                    this.mActivePointerId = -1;
                    break;
                case 5:
                    int actionIndex = motionEvent.getActionIndex();
                    int pointerId = motionEvent.getPointerId(actionIndex);
                    int x5 = (int) motionEvent.getX(actionIndex);
                    int y2 = (int) motionEvent.getY(actionIndex);
                    this.cuj = 0;
                    this.mActivePointerId = pointerId;
                    this.cuf = x5;
                    this.cug = y2;
                    int pointToPosition2 = pointToPosition(x5, y2);
                    if (pointToPosition2 >= 0) {
                        this.cud = getChildAt(pointToPosition2 - this.cvM).getLeft();
                        this.cuc = pointToPosition2;
                    }
                    this.cui = x5;
                    break;
                case 6:
                    onSecondaryPointerUp(motionEvent);
                    int i5 = this.cuf;
                    int pointToPosition3 = pointToPosition(i5, this.cug);
                    if (pointToPosition3 >= 0) {
                        this.cud = getChildAt(pointToPosition3 - this.cvM).getLeft();
                        this.cuc = pointToPosition3;
                    }
                    this.cui = i5;
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
            this.ctE.setScrollX(i2);
            aka();
            awakenScrollBars();
        }
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) != 0) {
            switch (motionEvent.getAction()) {
                case 8:
                    if (this.cuh == -1) {
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
        if (this.cuZ == 0.0f) {
            TypedValue typedValue = new TypedValue();
            if (getContext().getTheme().resolveAttribute(r.c.hlv_listPreferredItemWidth, typedValue, true)) {
                this.cuZ = typedValue.getDimension(getContext().getResources().getDisplayMetrics());
            }
        }
        return this.cuZ;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.cuK != null) {
            int scrollX = getScrollX();
            if (!this.cuK.isFinished()) {
                int save = canvas.save();
                int i2 = this.ctW.top + this.cuP;
                int height = (getHeight() - i2) - (this.ctW.bottom + this.cuQ);
                int min = Math.min(0, this.cuM + scrollX);
                canvas.rotate(-90.0f);
                canvas.translate(i2 + (-getHeight()), min);
                this.cuK.setSize(height, height);
                if (this.cuK.draw(canvas)) {
                    invalidate();
                }
                canvas.restoreToCount(save);
            }
            if (!this.cuL.isFinished()) {
                int save2 = canvas.save();
                int i3 = this.ctW.left + this.cuP;
                int height2 = (getHeight() - i3) - (this.ctW.right + this.cuQ);
                int max = Math.max(getWidth(), scrollX + this.cuN);
                canvas.rotate(90.0f);
                canvas.translate(-i3, -max);
                this.cuL.setSize(height2, height2);
                if (this.cuL.draw(canvas)) {
                    invalidate();
                }
                canvas.restoreToCount(save2);
            }
        }
    }

    private void akb() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        } else {
            this.mVelocityTracker.clear();
        }
    }

    private void akc() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
    }

    private void akd() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            akd();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.cul != null) {
            this.cul.stop();
        }
        if (this.cuU) {
            switch (action & MotionEventCompat.ACTION_MASK) {
                case 0:
                    int i2 = this.cuh;
                    if (i2 == 6 || i2 == 5) {
                        this.cuj = 0;
                        return true;
                    }
                    int x = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();
                    this.mActivePointerId = motionEvent.getPointerId(0);
                    int jK = jK(x);
                    if (i2 != 4 && jK >= 0) {
                        this.cud = getChildAt(jK - this.cvM).getLeft();
                        this.cuf = x;
                        this.cug = y;
                        this.cuc = jK;
                        this.cuh = 0;
                        akf();
                    }
                    this.cui = ExploreByTouchHelper.INVALID_ID;
                    akb();
                    this.mVelocityTracker.addMovement(motionEvent);
                    return i2 == 4;
                case 1:
                case 3:
                    this.cuh = -1;
                    this.mActivePointerId = -1;
                    akd();
                    jI(0);
                    return false;
                case 2:
                    switch (this.cuh) {
                        case 0:
                            int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                            if (findPointerIndex == -1) {
                                this.mActivePointerId = motionEvent.getPointerId(0);
                                findPointerIndex = 0;
                            }
                            akc();
                            this.mVelocityTracker.addMovement(motionEvent);
                            return jG((int) motionEvent.getX(findPointerIndex));
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
            this.cuf = (int) motionEvent.getX(i2);
            this.cug = (int) motionEvent.getY(i2);
            this.cuj = 0;
            this.mActivePointerId = motionEvent.getPointerId(i2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        int childCount = getChildCount();
        int i2 = this.cvM;
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
    public void jI(int i2) {
        if (i2 != this.cuD && this.cuo != null) {
            this.cuD = i2;
            this.cuo.a(this, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e implements Runnable {
        private final o cvd;
        private int cve;
        private final Runnable cvf = new com.baidu.tieba.horizonalList.widget.c(this);

        e() {
            this.cvd = new o(AbsHListView.this.getContext());
        }

        void jM(int i) {
            int i2 = i < 0 ? Integer.MAX_VALUE : 0;
            this.cve = i2;
            this.cvd.setInterpolator(null);
            this.cvd.fling(i2, 0, i, 0, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
            AbsHListView.this.cuh = 4;
            AbsHListView.this.ctE.k(this);
        }

        void akm() {
            if (this.cvd.springBack(AbsHListView.this.getScrollX(), 0, 0, 0, 0, 0)) {
                AbsHListView.this.cuh = 6;
                AbsHListView.this.invalidate();
                AbsHListView.this.ctE.k(this);
                return;
            }
            AbsHListView.this.cuh = -1;
            AbsHListView.this.jI(0);
        }

        void jN(int i) {
            this.cvd.setInterpolator(null);
            this.cvd.fling(AbsHListView.this.getScrollX(), 0, i, 0, ExploreByTouchHelper.INVALID_ID, Integer.MAX_VALUE, 0, 0, AbsHListView.this.getWidth(), 0);
            AbsHListView.this.cuh = 6;
            AbsHListView.this.invalidate();
            AbsHListView.this.ctE.k(this);
        }

        void jO(int i) {
            this.cvd.notifyHorizontalEdgeReached(AbsHListView.this.getScrollX(), 0, AbsHListView.this.cuJ);
            int overScrollMode = AbsHListView.this.getOverScrollMode();
            if (overScrollMode == 0 || (overScrollMode == 1 && !AbsHListView.this.ajQ())) {
                AbsHListView.this.cuh = 6;
                int currVelocity = (int) this.cvd.getCurrVelocity();
                if (i > 0) {
                    AbsHListView.this.cuK.onAbsorb(currVelocity);
                } else {
                    AbsHListView.this.cuL.onAbsorb(currVelocity);
                }
            } else {
                AbsHListView.this.cuh = -1;
                if (AbsHListView.this.cul != null) {
                    AbsHListView.this.cul.stop();
                }
            }
            AbsHListView.this.invalidate();
            AbsHListView.this.ctE.k(this);
        }

        void d(int i, int i2, boolean z) {
            int i3 = i < 0 ? Integer.MAX_VALUE : 0;
            this.cve = i3;
            this.cvd.setInterpolator(z ? AbsHListView.cuW : null);
            this.cvd.startScroll(i3, 0, i, 0, i2);
            AbsHListView.this.cuh = 4;
            AbsHListView.this.ctE.k(this);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void akn() {
            AbsHListView.this.cuh = -1;
            AbsHListView.this.removeCallbacks(this);
            AbsHListView.this.removeCallbacks(this.cvf);
            AbsHListView.this.jI(0);
            AbsHListView.this.akf();
            this.cvd.abortAnimation();
            AbsHListView.this.overScrollBy(0, 0, 0, 0, 0, 0, 0, 0, false);
        }

        void ako() {
            AbsHListView.this.postDelayed(this.cvf, 40L);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // java.lang.Runnable
        public void run() {
            int max;
            boolean z = true;
            boolean z2 = false;
            switch (AbsHListView.this.cuh) {
                case 3:
                    if (this.cvd.isFinished()) {
                        return;
                    }
                    break;
                case 4:
                    break;
                case 5:
                default:
                    akn();
                    return;
                case 6:
                    o oVar = this.cvd;
                    if (oVar.computeScrollOffset()) {
                        int scrollX = AbsHListView.this.getScrollX();
                        int currX = oVar.getCurrX();
                        if (AbsHListView.this.overScrollBy(currX - scrollX, 0, scrollX, 0, 0, 0, AbsHListView.this.cuJ, 0, false)) {
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
                                jM(currVelocity);
                                return;
                            }
                            akm();
                            return;
                        }
                        AbsHListView.this.invalidate();
                        AbsHListView.this.ctE.k(this);
                        return;
                    }
                    akn();
                    return;
            }
            if (AbsHListView.this.aeC) {
                AbsHListView.this.layoutChildren();
            }
            if (AbsHListView.this.cvZ == 0 || AbsHListView.this.getChildCount() == 0) {
                akn();
                return;
            }
            o oVar2 = this.cvd;
            boolean computeScrollOffset = oVar2.computeScrollOffset();
            int currX2 = oVar2.getCurrX();
            int i = this.cve - currX2;
            if (i > 0) {
                AbsHListView.this.cuc = AbsHListView.this.cvM;
                AbsHListView.this.cud = AbsHListView.this.getChildAt(0).getLeft();
                max = Math.min(((AbsHListView.this.getWidth() - AbsHListView.this.getPaddingRight()) - AbsHListView.this.getPaddingLeft()) - 1, i);
            } else {
                int childCount = AbsHListView.this.getChildCount() - 1;
                AbsHListView.this.cuc = AbsHListView.this.cvM + childCount;
                AbsHListView.this.cud = AbsHListView.this.getChildAt(childCount).getLeft();
                max = Math.max(-(((AbsHListView.this.getWidth() - AbsHListView.this.getPaddingRight()) - AbsHListView.this.getPaddingLeft()) - 1), i);
            }
            View childAt = AbsHListView.this.getChildAt(AbsHListView.this.cuc - AbsHListView.this.cvM);
            int left = childAt != null ? childAt.getLeft() : 0;
            boolean ax = AbsHListView.this.ax(max, max);
            if (!ax || max == 0) {
                z = false;
            }
            if (z) {
                if (childAt != null) {
                    AbsHListView.this.overScrollBy(-(max - (childAt.getLeft() - left)), 0, AbsHListView.this.getScrollX(), 0, 0, 0, AbsHListView.this.cuJ, 0, false);
                }
                if (computeScrollOffset) {
                    jO(max);
                }
            } else if (computeScrollOffset && !z) {
                if (ax) {
                    AbsHListView.this.invalidate();
                }
                this.cve = currX2;
                AbsHListView.this.ctE.k(this);
            } else {
                akn();
            }
        }
    }

    /* loaded from: classes.dex */
    public class j implements Runnable {
        private int cvn;
        private int cvo;
        private int cvp;
        private int cvq;
        private final int cvr;
        private int cvs;
        private int mMode;

        j() {
            this.cvr = ViewConfiguration.get(AbsHListView.this.getContext()).getScaledFadingEdgeLength();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void jM(int i) {
            int i2;
            stop();
            if (AbsHListView.this.aeC) {
                AbsHListView.this.cuF = new com.baidu.tieba.horizonalList.widget.d(this, i);
                return;
            }
            int childCount = AbsHListView.this.getChildCount();
            if (childCount != 0) {
                int i3 = AbsHListView.this.cvM;
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
                    this.cvq = 200 / i2;
                } else {
                    this.cvq = 200;
                }
                this.cvn = max;
                this.cvo = -1;
                this.cvp = -1;
                AbsHListView.this.ctE.k(this);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void az(int i, int i2) {
            int i3;
            stop();
            if (i2 == -1) {
                jM(i);
            } else if (AbsHListView.this.aeC) {
                AbsHListView.this.cuF = new com.baidu.tieba.horizonalList.widget.e(this, i, i2);
            } else {
                int childCount = AbsHListView.this.getChildCount();
                if (childCount != 0) {
                    int i4 = AbsHListView.this.cvM;
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
                        this.cvq = 200 / i3;
                    } else {
                        this.cvq = 200;
                    }
                    this.cvn = max;
                    this.cvo = i2;
                    this.cvp = -1;
                    AbsHListView.this.ctE.k(this);
                }
            }
        }

        void v(int i, int i2, int i3) {
            int i4 = AbsHListView.this.cvM;
            int childCount = (AbsHListView.this.getChildCount() + i4) - 1;
            int i5 = AbsHListView.this.ctW.left;
            int width = AbsHListView.this.getWidth() - AbsHListView.this.ctW.right;
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
            int i2 = AbsHListView.this.cvM;
            switch (this.mMode) {
                case 1:
                    int childCount = AbsHListView.this.getChildCount() - 1;
                    int i3 = i2 + childCount;
                    if (childCount >= 0) {
                        if (i3 == this.cvp) {
                            AbsHListView.this.ctE.k(this);
                            return;
                        }
                        View childAt = AbsHListView.this.getChildAt(childCount);
                        AbsHListView.this.c((i3 < AbsHListView.this.cvZ + (-1) ? Math.max(AbsHListView.this.ctW.right, this.cvr) : AbsHListView.this.ctW.right) + (childAt.getWidth() - (width - childAt.getLeft())), this.cvq, true);
                        this.cvp = i3;
                        if (i3 < this.cvn) {
                            AbsHListView.this.ctE.k(this);
                            return;
                        }
                        return;
                    }
                    return;
                case 2:
                    if (i2 == this.cvp) {
                        AbsHListView.this.ctE.k(this);
                        return;
                    }
                    View childAt2 = AbsHListView.this.getChildAt(0);
                    if (childAt2 != null) {
                        AbsHListView.this.c(childAt2.getLeft() - (i2 > 0 ? Math.max(this.cvr, AbsHListView.this.ctW.left) : AbsHListView.this.ctW.left), this.cvq, true);
                        this.cvp = i2;
                        if (i2 > this.cvn) {
                            AbsHListView.this.ctE.k(this);
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    int childCount2 = AbsHListView.this.getChildCount();
                    if (i2 != this.cvo && childCount2 > 1 && childCount2 + i2 < AbsHListView.this.cvZ) {
                        int i4 = i2 + 1;
                        if (i4 == this.cvp) {
                            AbsHListView.this.ctE.k(this);
                            return;
                        }
                        View childAt3 = AbsHListView.this.getChildAt(1);
                        int width2 = childAt3.getWidth();
                        int left2 = childAt3.getLeft();
                        int max = Math.max(AbsHListView.this.ctW.right, this.cvr);
                        if (i4 < this.cvo) {
                            AbsHListView.this.c(Math.max(0, (left2 + width2) - max), this.cvq, true);
                            this.cvp = i4;
                            AbsHListView.this.ctE.k(this);
                            return;
                        } else if (left2 > max) {
                            AbsHListView.this.c(left2 - max, this.cvq, true);
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
                        if (i5 == this.cvp) {
                            AbsHListView.this.ctE.k(this);
                            return;
                        }
                        View childAt4 = AbsHListView.this.getChildAt(childCount3);
                        int width3 = childAt4.getWidth();
                        int left3 = childAt4.getLeft();
                        int i6 = width - left3;
                        int max2 = Math.max(AbsHListView.this.ctW.left, this.cvr);
                        this.cvp = i5;
                        if (i5 > this.cvo) {
                            AbsHListView.this.c(-(i6 - max2), this.cvq, true);
                            AbsHListView.this.ctE.k(this);
                            return;
                        }
                        int i7 = width - max2;
                        int i8 = left3 + width3;
                        if (i7 > i8) {
                            AbsHListView.this.c(-(i7 - i8), this.cvq, true);
                            return;
                        }
                        return;
                    }
                    return;
                case 5:
                    if (this.cvp == i2) {
                        AbsHListView.this.ctE.k(this);
                        return;
                    }
                    this.cvp = i2;
                    int childCount4 = AbsHListView.this.getChildCount();
                    int i9 = this.cvn;
                    int i10 = (i2 + childCount4) - 1;
                    if (i9 < i2) {
                        i = (i2 - i9) + 1;
                    } else if (i9 > i10) {
                        i = i9 - i10;
                    }
                    float min = Math.min(Math.abs(i / childCount4), 1.0f);
                    if (i9 < i2) {
                        AbsHListView.this.c((int) ((-AbsHListView.this.getWidth()) * min), (int) (min * this.cvq), true);
                        AbsHListView.this.ctE.k(this);
                        return;
                    } else if (i9 > i10) {
                        AbsHListView.this.c((int) (AbsHListView.this.getWidth() * min), (int) (min * this.cvq), true);
                        AbsHListView.this.ctE.k(this);
                        return;
                    } else {
                        AbsHListView.this.c(AbsHListView.this.getChildAt(i9 - i2).getLeft() - this.cvs, (int) (this.cvq * (Math.abs(left) / AbsHListView.this.getWidth())), true);
                        return;
                    }
                default:
                    return;
            }
        }
    }

    public void setFriction(float f2) {
        if (this.cuk == null) {
            this.cuk = new e();
        }
        this.cuk.cvd.setFriction(f2);
    }

    public void setVelocityScale(float f2) {
        this.cuG = f2;
    }

    public void smoothScrollToPosition(int i2, int i3) {
        if (this.cul == null) {
            this.cul = new j();
        }
        this.cul.az(i2, i3);
    }

    public void smoothScrollBy(int i2, int i3) {
        c(i2, i3, false);
    }

    public void c(int i2, int i3, boolean z) {
        if (this.cuk == null) {
            this.cuk = new e();
        }
        int i4 = this.cvM;
        int childCount = getChildCount();
        int i5 = i4 + childCount;
        int paddingLeft = getPaddingLeft();
        int width = getWidth() - getPaddingRight();
        if (i2 == 0 || this.cvZ == 0 || childCount == 0 || ((i4 == 0 && getChildAt(0).getLeft() == paddingLeft && i2 < 0) || (i5 == this.cvZ && getChildAt(childCount - 1).getRight() == width && i2 > 0))) {
            this.cuk.akn();
            if (this.cul != null) {
                this.cul.stop();
                return;
            }
            return;
        }
        jI(2);
        this.cuk.d(i2, i3, z);
    }

    private void ake() {
        if (this.mScrollingCacheEnabled && !this.cua && !this.ctE.isHardwareAccelerated()) {
            setChildrenDrawnWithCacheEnabled(true);
            setChildrenDrawingCacheEnabled(true);
            this.cub = true;
            this.cua = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akf() {
        if (!this.ctE.isHardwareAccelerated()) {
            if (this.cuE == null) {
                this.cuE = new com.baidu.tieba.horizonalList.widget.b(this);
            }
            post(this.cuE);
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
        Rect rect = this.ctW;
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
        int i6 = this.cvM;
        if (i6 == 0) {
            this.cuM = left - rect.left;
        } else {
            this.cuM += min2;
        }
        if (i6 + childCount == this.cvZ) {
            this.cuN = rect.right + right;
        } else {
            this.cuN += min2;
        }
        boolean z = i6 == 0 && left >= rect.left && min2 >= 0;
        boolean z2 = i6 + childCount == this.cvZ && right <= getWidth() - rect.right && min2 <= 0;
        if (z || z2) {
            return min2 != 0;
        }
        boolean z3 = min2 < 0;
        boolean isInTouchMode = isInTouchMode();
        if (isInTouchMode) {
            akg();
        }
        int headerViewsCount = getHeaderViewsCount();
        int footerViewsCount = this.cvZ - getFooterViewsCount();
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
                    this.ctR.r(childAt, i11);
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
                    this.ctR.r(childAt2, i14);
                }
                i4 = i13;
                i7 = i12;
            }
        }
        this.cue = this.cud + min;
        this.cwh = true;
        if (i4 > 0) {
            detachViewsFromParent(i7, i4);
            this.ctR.akr();
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        jJ(min2);
        if (z3) {
            this.cvM = i4 + this.cvM;
        }
        int abs = Math.abs(min2);
        if (i5 < abs || width < abs) {
            fg(z3);
        }
        if (!isInTouchMode && this.ccS != -1) {
            int i15 = this.ccS - this.cvM;
            if (i15 >= 0 && i15 < getChildCount()) {
                b(this.ccS, getChildAt(i15));
            }
        } else if (this.ctP != -1) {
            int i16 = this.ctP - this.cvM;
            if (i16 >= 0 && i16 < getChildCount()) {
                b(-1, getChildAt(i16));
            }
        } else {
            this.ctQ.setEmpty();
        }
        this.cwh = false;
        ajR();
        return false;
    }

    public void jJ(int i2) {
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
    public void akg() {
        if (this.ccS != -1) {
            if (this.ctL != 4) {
                this.cur = this.ccS;
            }
            if (this.cvW >= 0 && this.cvW != this.ccS) {
                this.cur = this.cvW;
            }
            setSelectedPositionInt(-1);
            setNextSelectedPositionInt(-1);
            this.cum = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int akh() {
        int i2 = this.ccS;
        if (i2 < 0) {
            i2 = this.cur;
        }
        return Math.min(Math.max(0, i2), this.cvZ - 1);
    }

    protected int jL(int i2) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return -1;
        }
        int jK = jK(i2);
        return jK == -1 ? (this.cvM + childCount) - 1 : jK;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aki() {
        if (this.ccS >= 0 || !akj()) {
            return false;
        }
        ajZ();
        return true;
    }

    boolean akj() {
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
        int i8 = this.ctW.left;
        int right = (getRight() - getLeft()) - this.ctW.right;
        int i9 = this.cvM;
        int i10 = this.cur;
        if (i10 >= i9 && i10 < i9 + childCount) {
            View childAt = getChildAt(i10 - this.cvM);
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
            int i15 = this.cvZ;
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
        this.cur = -1;
        removeCallbacks(this.cuk);
        if (this.cul != null) {
            this.cul.stop();
        }
        this.cuh = -1;
        akf();
        this.cvN = i2;
        int r = r(i3, z);
        if (r < i9 || r > getLastVisiblePosition()) {
            r = -1;
        } else {
            this.ctL = 4;
            ajZ();
            setSelectionInt(r);
            ajR();
        }
        jI(0);
        return r >= 0;
    }

    void akk() {
        int i2;
        boolean z;
        boolean z2;
        this.ctJ.clear();
        int i3 = 0;
        boolean z3 = false;
        while (i3 < this.ctK.size()) {
            long keyAt = this.ctK.keyAt(i3);
            int intValue = this.ctK.valueAt(i3).intValue();
            if (keyAt != this.mAdapter.getItemId(intValue)) {
                int max = Math.max(0, intValue - 20);
                int min = Math.min(intValue + 20, this.cvZ);
                while (true) {
                    if (max >= min) {
                        z2 = false;
                        break;
                    } else if (keyAt != this.mAdapter.getItemId(max)) {
                        max++;
                    } else {
                        this.ctJ.put(max, true);
                        this.ctK.setValueAt(i3, Integer.valueOf(max));
                        z2 = true;
                        break;
                    }
                }
                if (!z2) {
                    this.ctK.delete(keyAt);
                    int i4 = i3 - 1;
                    this.ctI--;
                    if (Build.VERSION.SDK_INT <= 11 || this.ctG == null || this.ctH == null) {
                        i2 = i4;
                        z = true;
                    } else {
                        ((com.baidu.tieba.horizonalList.a.a.b) this.ctH).onItemCheckedStateChanged((ActionMode) this.ctG, intValue, keyAt, false);
                        i2 = i4;
                        z = true;
                    }
                    z3 = z;
                    i3 = i2 + 1;
                }
            } else {
                this.ctJ.put(intValue, true);
            }
            i2 = i3;
            z = z3;
            z3 = z;
            i3 = i2 + 1;
        }
        if (z3 && this.ctG != null && Build.VERSION.SDK_INT > 11) {
            ((ActionMode) this.ctG).invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.g
    public void handleDataChanged() {
        int i2 = this.cvZ;
        int i3 = this.cuV;
        this.cuV = this.cvZ;
        if (this.ctF != 0 && this.mAdapter != null && this.mAdapter.hasStableIds()) {
            akk();
        }
        this.ctR.akq();
        if (i2 > 0) {
            if (this.cvR) {
                this.cvR = false;
                this.cuX = null;
                if (this.cuA == 2) {
                    this.ctL = 3;
                    return;
                }
                if (this.cuA == 1) {
                    if (this.cuO) {
                        this.cuO = false;
                        this.ctL = 3;
                        return;
                    }
                    int childCount = getChildCount();
                    int width = getWidth() - getPaddingRight();
                    View childAt = getChildAt(childCount - 1);
                    int bottom = childAt != null ? childAt.getBottom() : width;
                    if (childCount + this.cvM >= i3 && bottom <= width) {
                        this.ctL = 3;
                        return;
                    }
                    awakenScrollBars();
                }
                switch (this.cvS) {
                    case 1:
                        this.ctL = 5;
                        this.cvO = Math.min(Math.max(0, this.cvO), i2 - 1);
                        return;
                    case 0:
                        if (isInTouchMode()) {
                            this.ctL = 5;
                            this.cvO = Math.min(Math.max(0, this.cvO), i2 - 1);
                            return;
                        }
                        int akC = akC();
                        if (akC >= 0 && r(akC, true) == akC) {
                            this.cvO = akC;
                            if (this.cvQ == getWidth()) {
                                this.ctL = 5;
                            } else {
                                this.ctL = 2;
                            }
                            setNextSelectedPositionInt(akC);
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
                int r = r(selectedItemPosition, true);
                if (r >= 0) {
                    setNextSelectedPositionInt(r);
                    return;
                }
                int r2 = r(selectedItemPosition, false);
                if (r2 >= 0) {
                    setNextSelectedPositionInt(r2);
                    return;
                }
            } else if (this.cur >= 0) {
                return;
            }
        }
        this.ctL = this.cun ? 3 : 1;
        this.ccS = -1;
        this.cvY = Long.MIN_VALUE;
        this.cvW = -1;
        this.cvX = Long.MIN_VALUE;
        this.cvR = false;
        this.cuX = null;
        this.ctP = -1;
        akB();
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
        this.cuA = i2;
    }

    public int getTranscriptMode() {
        return this.cuA;
    }

    @Override // android.view.View
    public int getSolidColor() {
        return this.cuB;
    }

    public void setCacheColorHint(int i2) {
        if (i2 != this.cuB) {
            this.cuB = i2;
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                getChildAt(i3).setDrawingCacheBackgroundColor(i2);
            }
            this.ctR.setCacheColorHint(i2);
        }
    }

    @ViewDebug.ExportedProperty(category = "drawing")
    public int getCacheColorHint() {
        return this.cuB;
    }

    private void akl() {
        if (this.cuK != null) {
            this.cuK.finish();
            this.cuL.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ay(int i2, int i3) {
    }

    public void setRecyclerListener(l lVar) {
        this.ctR.cvv = lVar;
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
        public int cvh;
        public boolean cvi;
        public boolean cvj;
        public int cvk;
        public long cvl;

        public f(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.cvl = -1L;
        }

        public f(int i, int i2, int i3) {
            super(i, i2);
            this.cvl = -1L;
            this.cvh = i3;
        }

        public f(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.cvl = -1L;
        }
    }

    /* loaded from: classes.dex */
    public class k {
        private ArrayList<View> cvA;
        private ArrayList<View> cvB;
        private SparseArrayCompat<View> cvC;
        private l cvv;
        private int cvw;
        private View[] cvx = new View[0];
        private ArrayList<View>[] cvy;
        private int cvz;

        public k() {
        }

        public void jP(int i) {
            if (i < 1) {
                throw new IllegalArgumentException("Can't have a viewTypeCount < 1");
            }
            ArrayList<View>[] arrayListArr = new ArrayList[i];
            for (int i2 = 0; i2 < i; i2++) {
                arrayListArr[i2] = new ArrayList<>();
            }
            this.cvz = i;
            this.cvA = arrayListArr[0];
            this.cvy = arrayListArr;
        }

        public void akp() {
            if (this.cvz == 1) {
                ArrayList<View> arrayList = this.cvA;
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    arrayList.get(i).forceLayout();
                }
            } else {
                int i2 = this.cvz;
                for (int i3 = 0; i3 < i2; i3++) {
                    ArrayList<View> arrayList2 = this.cvy[i3];
                    int size2 = arrayList2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        arrayList2.get(i4).forceLayout();
                    }
                }
            }
            if (this.cvC != null) {
                int size3 = this.cvC.size();
                for (int i5 = 0; i5 < size3; i5++) {
                    this.cvC.valueAt(i5).forceLayout();
                }
            }
        }

        public boolean jQ(int i) {
            return i >= 0;
        }

        public void clear() {
            if (this.cvz == 1) {
                ArrayList<View> arrayList = this.cvA;
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    AbsHListView.this.removeDetachedView(arrayList.remove((size - 1) - i), false);
                }
            } else {
                int i2 = this.cvz;
                for (int i3 = 0; i3 < i2; i3++) {
                    ArrayList<View> arrayList2 = this.cvy[i3];
                    int size2 = arrayList2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        AbsHListView.this.removeDetachedView(arrayList2.remove((size2 - 1) - i4), false);
                    }
                }
            }
            if (this.cvC != null) {
                this.cvC.clear();
            }
        }

        public void aA(int i, int i2) {
            if (this.cvx.length < i) {
                this.cvx = new View[i];
            }
            this.cvw = i2;
            View[] viewArr = this.cvx;
            for (int i3 = 0; i3 < i; i3++) {
                View childAt = AbsHListView.this.getChildAt(i3);
                f fVar = (f) childAt.getLayoutParams();
                if (fVar != null && fVar.cvh != -2) {
                    viewArr[i3] = childAt;
                }
            }
        }

        public View jR(int i) {
            int i2 = i - this.cvw;
            View[] viewArr = this.cvx;
            if (i2 < 0 || i2 >= viewArr.length) {
                return null;
            }
            View view = viewArr[i2];
            viewArr[i2] = null;
            return view;
        }

        View jS(int i) {
            int indexOfKey;
            if (this.cvC != null && (indexOfKey = this.cvC.indexOfKey(i)) >= 0) {
                View valueAt = this.cvC.valueAt(indexOfKey);
                this.cvC.removeAt(indexOfKey);
                return valueAt;
            }
            return null;
        }

        void akq() {
            if (this.cvC != null) {
                this.cvC.clear();
            }
        }

        View jT(int i) {
            if (this.cvz == 1) {
                return AbsHListView.a(this.cvA, i);
            }
            int itemViewType = AbsHListView.this.mAdapter.getItemViewType(i);
            if (itemViewType >= 0 && itemViewType < this.cvy.length) {
                return AbsHListView.a(this.cvy[itemViewType], i);
            }
            return null;
        }

        public void r(View view, int i) {
            f fVar = (f) view.getLayoutParams();
            if (fVar != null) {
                fVar.cvk = i;
                int i2 = fVar.cvh;
                if (!jQ(i2)) {
                    if (i2 != -2) {
                        if (this.cvB == null) {
                            this.cvB = new ArrayList<>();
                        }
                        this.cvB.add(view);
                        return;
                    }
                    return;
                }
                view.onStartTemporaryDetach();
                if (this.cvz == 1) {
                    this.cvA.add(view);
                } else {
                    this.cvy[i2].add(view);
                }
                if (Build.VERSION.SDK_INT >= 14) {
                    view.setAccessibilityDelegate(null);
                }
                if (this.cvv != null) {
                    this.cvv.onMovedToScrapHeap(view);
                }
            }
        }

        public void akr() {
            if (this.cvB != null) {
                int size = this.cvB.size();
                for (int i = 0; i < size; i++) {
                    AbsHListView.this.removeDetachedView(this.cvB.get(i), false);
                }
                this.cvB.clear();
            }
        }

        public void aks() {
            View[] viewArr = this.cvx;
            boolean z = this.cvv != null;
            boolean z2 = this.cvz > 1;
            ArrayList<View> arrayList = this.cvA;
            for (int length = viewArr.length - 1; length >= 0; length--) {
                View view = viewArr[length];
                if (view != null) {
                    f fVar = (f) view.getLayoutParams();
                    int i = fVar.cvh;
                    viewArr[length] = null;
                    if (!jQ(i)) {
                        if (i != -2) {
                            AbsHListView.this.removeDetachedView(view, false);
                        }
                    } else {
                        if (z2) {
                            arrayList = this.cvy[i];
                        }
                        view.onStartTemporaryDetach();
                        fVar.cvk = this.cvw + length;
                        arrayList.add(view);
                        if (Build.VERSION.SDK_INT >= 14) {
                            view.setAccessibilityDelegate(null);
                        }
                        if (z) {
                            this.cvv.onMovedToScrapHeap(view);
                        }
                    }
                }
            }
            akt();
        }

        private void akt() {
            int length = this.cvx.length;
            int i = this.cvz;
            ArrayList<View>[] arrayListArr = this.cvy;
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
            if (this.cvC != null) {
                for (int i6 = 0; i6 < this.cvC.size(); i6++) {
                    this.cvC.valueAt(i6);
                }
            }
        }

        void setCacheColorHint(int i) {
            View[] viewArr;
            if (this.cvz == 1) {
                ArrayList<View> arrayList = this.cvA;
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    arrayList.get(i2).setDrawingCacheBackgroundColor(i);
                }
            } else {
                int i3 = this.cvz;
                for (int i4 = 0; i4 < i3; i4++) {
                    ArrayList<View> arrayList2 = this.cvy[i4];
                    int size2 = arrayList2.size();
                    for (int i5 = 0; i5 < size2; i5++) {
                        arrayList2.get(i5).setDrawingCacheBackgroundColor(i);
                    }
                }
            }
            for (View view : this.cvx) {
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
                if (((f) view.getLayoutParams()).cvk == i2) {
                    arrayList.remove(i3);
                    return view;
                }
            }
            return arrayList.remove(size - 1);
        }
        return null;
    }
}
