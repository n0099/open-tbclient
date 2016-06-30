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
import com.baidu.tieba.u;
import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class AbsHListView extends com.baidu.tieba.horizonalList.widget.g<ListAdapter> implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnTouchModeChangeListener {
    static final Interpolator cvp = new LinearInterpolator();
    public static final int[] cvr = new int[1];
    a.AbstractC0062a ctY;
    protected int ctZ;
    int cuA;
    int cuB;
    int cuC;
    private e cuD;
    protected j cuE;
    protected int cuF;
    protected boolean cuG;
    private h cuH;
    private boolean cuI;
    private Rect cuJ;
    protected int cuK;
    private ContextMenu.ContextMenuInfo cuL;
    protected int cuM;
    private int cuN;
    private c cuO;
    private Runnable cuP;
    private b cuQ;
    private i cuR;
    private Runnable cuS;
    private int cuT;
    private int cuU;
    private boolean cuV;
    private int cuW;
    private Runnable cuX;
    protected Runnable cuY;
    private float cuZ;
    public Object cua;
    Object cub;
    int cuc;
    protected SparseArrayCompat<Boolean> cud;
    LongSparseArray<Integer> cue;
    protected int cuf;
    protected a cug;
    boolean cuh;
    boolean cui;
    int cuj;
    protected Rect cuk;
    protected final k cul;
    int cum;
    int cun;
    int cuo;
    int cup;
    protected Rect cuq;
    protected int cur;
    View cus;
    View cut;
    protected boolean cuu;
    protected boolean cuv;
    protected int cuw;
    int cux;
    int cuy;
    int cuz;
    protected final boolean[] cva;
    int cvb;
    int cvc;
    private EdgeEffectCompat cvd;
    private EdgeEffectCompat cve;
    private int cvf;
    private int cvg;
    private boolean cvh;
    private int cvi;
    private int cvj;
    private g cvk;
    private int cvl;
    private int cvm;
    protected boolean cvn;
    private int cvo;
    private SavedState cvq;
    private float cvs;
    private int mActivePointerId;
    protected ListAdapter mAdapter;
    private int mDirection;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    boolean mScrollingCacheEnabled;
    protected int mTouchMode;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    Drawable xS;

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

    protected abstract void eI(boolean z);

    protected abstract int jE(int i2);

    public abstract void setSelectionInt(int i2);

    public AbsHListView(Context context) {
        super(context);
        this.ctZ = 0;
        this.cuf = 0;
        this.cui = false;
        this.cuj = -1;
        this.cuk = new Rect();
        this.cul = new k();
        this.cum = 0;
        this.cun = 0;
        this.cuo = 0;
        this.cup = 0;
        this.cuq = new Rect();
        this.cur = 0;
        this.mTouchMode = -1;
        this.cuF = 0;
        this.cuI = true;
        this.cuK = -1;
        this.cuL = null;
        this.cuN = -1;
        this.cuW = 0;
        this.cuZ = 1.0f;
        this.cva = new boolean[1];
        this.mActivePointerId = -1;
        this.mDirection = 0;
        ahG();
    }

    public AbsHListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, u.c.hlv_absHListViewStyle);
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
        this.ctZ = 0;
        this.cuf = 0;
        this.cui = false;
        this.cuj = -1;
        this.cuk = new Rect();
        this.cul = new k();
        this.cum = 0;
        this.cun = 0;
        this.cuo = 0;
        this.cup = 0;
        this.cuq = new Rect();
        this.cur = 0;
        this.mTouchMode = -1;
        this.cuF = 0;
        this.cuI = true;
        this.cuK = -1;
        this.cuL = null;
        this.cuN = -1;
        this.cuW = 0;
        this.cuZ = 1.0f;
        this.cva = new boolean[1];
        this.mActivePointerId = -1;
        this.mDirection = 0;
        ahG();
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, u.l.HListView, i2, 0);
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
        this.cui = z3;
        setStackFromRight(z2);
        setScrollingCacheEnabled(z);
        setTranscriptMode(i3);
        setCacheColorHint(i4);
        setSmoothScrollbarEnabled(z4);
        setChoiceMode(i5);
    }

    private void ahG() {
        setClickable(true);
        setFocusableInTouchMode(true);
        setWillNotDraw(false);
        setAlwaysDrawnWithCacheEnabled(false);
        setScrollingCacheEnabled(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.cvb = viewConfiguration.getScaledOverscrollDistance();
        this.cvc = viewConfiguration.getScaledOverflingDistance();
        this.ctY = com.baidu.tieba.horizonalList.a.a.ax(this);
    }

    @Override // android.view.View
    public void setOverScrollMode(int i2) {
        if (i2 != 2) {
            if (this.cvd == null) {
                Context context = getContext();
                this.cvd = new EdgeEffectCompat(context);
                this.cve = new EdgeEffectCompat(context);
            }
        } else {
            this.cvd = null;
            this.cve = null;
        }
        super.setOverScrollMode(i2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.horizonalList.widget.g
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            this.cuh = this.mAdapter.hasStableIds();
            if (this.ctZ != 0 && this.cuh && this.cue == null) {
                this.cue = new LongSparseArray<>();
            }
        }
        if (this.cud != null) {
            this.cud.clear();
        }
        if (this.cue != null) {
            this.cue.clear();
        }
    }

    public int getCheckedItemCount() {
        return this.cuc;
    }

    public boolean isItemChecked(int i2) {
        if (this.ctZ == 0 || this.cud == null) {
            return false;
        }
        return this.cud.get(i2, false).booleanValue();
    }

    public int getCheckedItemPosition() {
        if (this.ctZ == 1 && this.cud != null && this.cud.size() == 1) {
            return this.cud.keyAt(0);
        }
        return -1;
    }

    public SparseArrayCompat<Boolean> getCheckedItemPositions() {
        if (this.ctZ != 0) {
            return this.cud;
        }
        return null;
    }

    public long[] getCheckedItemIds() {
        if (this.ctZ == 0 || this.cue == null || this.mAdapter == null) {
            return new long[0];
        }
        LongSparseArray<Integer> longSparseArray = this.cue;
        int size = longSparseArray.size();
        long[] jArr = new long[size];
        for (int i2 = 0; i2 < size; i2++) {
            jArr[i2] = longSparseArray.keyAt(i2);
        }
        return jArr;
    }

    public void clearChoices() {
        if (this.cud != null) {
            this.cud.clear();
        }
        if (this.cue != null) {
            this.cue.clear();
        }
        this.cuc = 0;
    }

    public void setItemChecked(int i2, boolean z) {
        if (this.ctZ != 0) {
            if (Build.VERSION.SDK_INT >= 11 && z && this.ctZ == 3 && this.cua == null) {
                if (this.cub == null || !((com.baidu.tieba.horizonalList.a.a.b) this.cub).ahF()) {
                    throw new IllegalStateException("AbsListView: attempted to start selection mode for CHOICE_MODE_MULTIPLE_MODAL but no choice mode callback was supplied. Call setMultiChoiceModeListener to set a callback.");
                }
                this.cua = startActionMode((com.baidu.tieba.horizonalList.a.a.b) this.cub);
            }
            if (this.ctZ == 2 || (Build.VERSION.SDK_INT >= 11 && this.ctZ == 3)) {
                boolean booleanValue = this.cud.get(i2, false).booleanValue();
                this.cud.put(i2, Boolean.valueOf(z));
                if (this.cue != null && this.mAdapter.hasStableIds()) {
                    if (z) {
                        this.cue.put(this.mAdapter.getItemId(i2), Integer.valueOf(i2));
                    } else {
                        this.cue.delete(this.mAdapter.getItemId(i2));
                    }
                }
                if (booleanValue != z) {
                    if (z) {
                        this.cuc++;
                    } else {
                        this.cuc--;
                    }
                }
                if (this.cua != null) {
                    ((com.baidu.tieba.horizonalList.a.a.b) this.cub).onItemCheckedStateChanged((ActionMode) this.cua, i2, this.mAdapter.getItemId(i2), z);
                }
            } else {
                boolean z2 = this.cue != null && this.mAdapter.hasStableIds();
                if (z || isItemChecked(i2)) {
                    this.cud.clear();
                    if (z2) {
                        this.cue.clear();
                    }
                }
                if (z) {
                    this.cud.put(i2, true);
                    if (z2) {
                        this.cue.put(this.mAdapter.getItemId(i2), Integer.valueOf(i2));
                    }
                    this.cuc = 1;
                } else if (this.cud.size() == 0 || !this.cud.valueAt(0).booleanValue()) {
                    this.cuc = 0;
                }
            }
            if (!this.mInLayout && !this.cwz) {
                this.aaZ = true;
                aiv();
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
        if (this.ctZ != 0) {
            if (this.ctZ == 2 || (Build.VERSION.SDK_INT >= 11 && this.ctZ == 3 && this.cua != null)) {
                boolean z5 = !this.cud.get(i2, false).booleanValue();
                this.cud.put(i2, Boolean.valueOf(z5));
                if (this.cue != null && this.mAdapter.hasStableIds()) {
                    if (z5) {
                        this.cue.put(this.mAdapter.getItemId(i2), Integer.valueOf(i2));
                    } else {
                        this.cue.delete(this.mAdapter.getItemId(i2));
                    }
                }
                if (z5) {
                    this.cuc++;
                } else {
                    this.cuc--;
                }
                if (this.cua != null) {
                    ((com.baidu.tieba.horizonalList.a.a.b) this.cub).onItemCheckedStateChanged((ActionMode) this.cua, i2, j2, z5);
                } else {
                    z4 = true;
                }
                z2 = z4;
                z4 = true;
            } else if (this.ctZ == 1) {
                if (!this.cud.get(i2, false).booleanValue()) {
                    this.cud.clear();
                    this.cud.put(i2, true);
                    if (this.cue != null && this.mAdapter.hasStableIds()) {
                        this.cue.clear();
                        this.cue.put(this.mAdapter.getItemId(i2), Integer.valueOf(i2));
                    }
                    this.cuc = 1;
                } else if (this.cud.size() == 0 || !this.cud.valueAt(0).booleanValue()) {
                    this.cuc = 0;
                }
                z4 = true;
                z2 = true;
            } else {
                z2 = true;
            }
            if (z4) {
                ahH();
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

    private void ahH() {
        int i2 = this.bkE;
        int childCount = getChildCount();
        boolean z = Build.VERSION.SDK_INT >= 11;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            int i4 = i2 + i3;
            if (childAt instanceof Checkable) {
                ((Checkable) childAt).setChecked(this.cud.get(i4, false).booleanValue());
            } else if (z) {
                childAt.setActivated(this.cud.get(i4, false).booleanValue());
            }
        }
    }

    public int getChoiceMode() {
        return this.ctZ;
    }

    public void setChoiceMode(int i2) {
        this.ctZ = i2;
        if (Build.VERSION.SDK_INT >= 11 && this.cua != null) {
            if (Build.VERSION.SDK_INT >= 11) {
                ((ActionMode) this.cua).finish();
            }
            this.cua = null;
        }
        if (this.ctZ != 0) {
            if (this.cud == null) {
                this.cud = new SparseArrayCompat<>();
            }
            if (this.cue == null && this.mAdapter != null && this.mAdapter.hasStableIds()) {
                this.cue = new LongSparseArray<>();
            }
            if (Build.VERSION.SDK_INT >= 11 && this.ctZ == 3) {
                clearChoices();
                setLongClickable(true);
            }
        }
    }

    public void setMultiChoiceModeListener(com.baidu.tieba.horizonalList.a.a.a aVar) {
        if (Build.VERSION.SDK_INT >= 11) {
            if (this.cub == null) {
                this.cub = new com.baidu.tieba.horizonalList.a.a.b(this);
            }
            ((com.baidu.tieba.horizonalList.a.a.b) this.cub).a(aVar);
            return;
        }
        Log.e("AbsListView", "setMultiChoiceModeListener not supported for this version of Android");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ahI() {
        int childCount = getChildCount();
        if (childCount == 0) {
            return true;
        }
        if (childCount != this.cwr) {
            return false;
        }
        return getChildAt(0).getLeft() >= this.cuq.left && getChildAt(childCount + (-1)).getRight() <= getWidth() - this.cuq.right;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public int getHorizontalScrollbarHeight() {
        return super.getHorizontalScrollbarHeight();
    }

    public void setSmoothScrollbarEnabled(boolean z) {
        this.cuI = z;
    }

    public void setOnScrollListener(h hVar) {
        this.cuH = hVar;
        ahJ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ahJ() {
        if (this.cuH != null) {
            this.cuH.a(this, this.bkE, getChildCount(), this.cwr);
        }
        onScrollChanged(0, 0, 0, 0);
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEvent(int i2) {
        if (i2 == 4096) {
            int firstVisiblePosition = getFirstVisiblePosition();
            int lastVisiblePosition = getLastVisiblePosition();
            if (this.cvl != firstVisiblePosition || this.cvm != lastVisiblePosition) {
                this.cvl = firstVisiblePosition;
                this.cvm = lastVisiblePosition;
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
            ahX();
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

    private void ahK() {
        setSelector(getResources().getDrawable(17301602));
    }

    public void setStackFromRight(boolean z) {
        if (this.cuG != z) {
            this.cuG = z;
            ahL();
        }
    }

    void ahL() {
        if (getChildCount() > 0) {
            ahM();
            requestLayout();
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new com.baidu.tieba.horizonalList.widget.f();
        long cvW;
        long cvX;
        int cvY;
        String cvZ;
        boolean cwa;
        int cwb;
        SparseArrayCompat<Boolean> cwc;
        LongSparseArray<Integer> cwd;
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
            this.cvW = parcel.readLong();
            this.cvX = parcel.readLong();
            this.cvY = parcel.readInt();
            this.position = parcel.readInt();
            this.width = parcel.readInt();
            this.cvZ = parcel.readString();
            this.cwa = parcel.readByte() != 0;
            this.cwb = parcel.readInt();
            this.cwc = j(parcel);
            this.cwd = i(parcel);
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
            parcel.writeLong(this.cvW);
            parcel.writeLong(this.cvX);
            parcel.writeInt(this.cvY);
            parcel.writeInt(this.position);
            parcel.writeInt(this.width);
            parcel.writeString(this.cvZ);
            parcel.writeByte((byte) (this.cwa ? 1 : 0));
            parcel.writeInt(this.cwb);
            a(this.cwc, parcel);
            a(this.cwd, parcel);
        }

        public String toString() {
            return "AbsListView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " selectedId=" + this.cvW + " firstId=" + this.cvX + " viewLeft=" + this.cvY + " position=" + this.position + " width=" + this.width + " filter=" + this.cvZ + " checkState=" + this.cwc + "}";
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        boolean z = true;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.cvq != null) {
            savedState.cvW = this.cvq.cvW;
            savedState.cvX = this.cvq.cvX;
            savedState.cvY = this.cvq.cvY;
            savedState.position = this.cvq.position;
            savedState.width = this.cvq.width;
            savedState.cvZ = this.cvq.cvZ;
            savedState.cwa = this.cvq.cwa;
            savedState.cwb = this.cvq.cwb;
            savedState.cwc = this.cvq.cwc;
            savedState.cwd = this.cvq.cwd;
            return savedState;
        }
        boolean z2 = getChildCount() > 0 && this.cwr > 0;
        long selectedItemId = getSelectedItemId();
        savedState.cvW = selectedItemId;
        savedState.width = getWidth();
        if (selectedItemId >= 0) {
            savedState.cvY = this.cuF;
            savedState.position = getSelectedItemPosition();
            savedState.cvX = -1L;
        } else if (z2 && this.bkE > 0) {
            savedState.cvY = getChildAt(0).getLeft();
            int i2 = this.bkE;
            if (i2 >= this.cwr) {
                i2 = this.cwr - 1;
            }
            savedState.position = i2;
            savedState.cvX = this.mAdapter.getItemId(i2);
        } else {
            savedState.cvY = 0;
            savedState.cvX = -1L;
            savedState.position = 0;
        }
        savedState.cvZ = null;
        savedState.cwa = (Build.VERSION.SDK_INT < 11 || this.ctZ != 3 || this.cua == null) ? false : false;
        if (this.cud != null) {
            try {
                savedState.cwc = this.cud.m1clone();
            } catch (NoSuchMethodError e2) {
                e2.printStackTrace();
                savedState.cwc = new SparseArrayCompat<>();
            }
        }
        if (this.cue != null) {
            LongSparseArray<Integer> longSparseArray = new LongSparseArray<>();
            int size = this.cue.size();
            for (int i3 = 0; i3 < size; i3++) {
                longSparseArray.put(this.cue.keyAt(i3), this.cue.valueAt(i3));
            }
            savedState.cwd = longSparseArray;
        }
        savedState.cwb = this.cuc;
        return savedState;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.aaZ = true;
        this.cwi = savedState.width;
        if (savedState.cvW >= 0) {
            this.cwj = true;
            this.cvq = savedState;
            this.cwh = savedState.cvW;
            this.cwg = savedState.position;
            this.cwf = savedState.cvY;
            this.cwk = 0;
        } else if (savedState.cvX >= 0) {
            setSelectedPositionInt(-1);
            setNextSelectedPositionInt(-1);
            this.cuj = -1;
            this.cwj = true;
            this.cvq = savedState;
            this.cwh = savedState.cvX;
            this.cwg = savedState.position;
            this.cwf = savedState.cvY;
            this.cwk = 1;
        }
        if (savedState.cwc != null) {
            this.cud = savedState.cwc;
        }
        if (savedState.cwd != null) {
            this.cue = savedState.cwd;
        }
        this.cuc = savedState.cwb;
        if (Build.VERSION.SDK_INT >= 11 && savedState.cwa && this.ctZ == 3 && this.cub != null) {
            this.cua = startActionMode((com.baidu.tieba.horizonalList.a.a.b) this.cub);
        }
        requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onFocusChanged(boolean z, int i2, Rect rect) {
        super.onFocusChanged(z, i2, rect);
        if (z && this.ceR < 0 && !isInTouchMode()) {
            if (!this.cvn && this.mAdapter != null) {
                this.aaZ = true;
                this.cws = this.cwr;
                this.cwr = this.mAdapter.getCount();
            }
            aib();
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (!this.cwz && !this.mInLayout) {
            super.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ahM() {
        removeAllViewsInLayout();
        this.bkE = 0;
        this.aaZ = false;
        this.cuY = null;
        this.cwj = false;
        this.cvq = null;
        this.cwu = -1;
        this.cwv = Long.MIN_VALUE;
        setSelectedPositionInt(-1);
        setNextSelectedPositionInt(-1);
        this.cuF = 0;
        this.cuj = -1;
        this.cuk.setEmpty();
        invalidate();
    }

    @Override // android.view.View
    protected int computeHorizontalScrollExtent() {
        int childCount = getChildCount();
        if (childCount > 0) {
            if (this.cuI) {
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
        int i3 = this.bkE;
        int childCount = getChildCount();
        if (i3 < 0 || childCount <= 0) {
            return 0;
        }
        if (this.cuI) {
            View childAt = getChildAt(0);
            int left = childAt.getLeft();
            int width = childAt.getWidth();
            if (width > 0) {
                return Math.max(((i3 * 100) - ((left * 100) / width)) + ((int) ((getScrollX() / getWidth()) * this.cwr * 100.0f)), 0);
            }
            return 0;
        }
        int i4 = this.cwr;
        if (i3 != 0) {
            i2 = i3 + childCount == i4 ? i4 : (childCount / 2) + i3;
        }
        return (int) (((i2 / i4) * childCount) + i3);
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        if (this.cuI) {
            int max = Math.max(this.cwr * 100, 0);
            if (getScrollX() != 0) {
                return max + Math.abs((int) ((getScrollX() / getWidth()) * this.cwr * 100.0f));
            }
            return max;
        }
        return this.cwr;
    }

    @Override // android.view.View
    protected float getLeftFadingEdgeStrength() {
        int childCount = getChildCount();
        float leftFadingEdgeStrength = super.getLeftFadingEdgeStrength();
        if (childCount != 0) {
            if (this.bkE > 0) {
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
            if ((this.bkE + childCount) - 1 < this.cwr - 1) {
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
        if (this.xS == null) {
            ahK();
        }
        Rect rect = this.cuq;
        rect.left = this.cum + getPaddingLeft();
        rect.top = this.cun + getPaddingTop();
        rect.right = this.cuo + getPaddingRight();
        rect.bottom = this.cup + getPaddingBottom();
        if (this.cuT == 1) {
            int childCount = getChildCount();
            int width = getWidth() - getPaddingRight();
            View childAt = getChildAt(childCount - 1);
            this.cvh = childCount + this.bkE >= this.cvo && (childAt != null ? childAt.getRight() : width) <= width;
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
            this.cul.aih();
        }
        layoutChildren();
        this.mInLayout = false;
        this.cuM = (i4 - i2) / 3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void layoutChildren() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ahN() {
        boolean z = true;
        if (this.cus != null) {
            boolean z2 = this.bkE > 0;
            if (!z2 && getChildCount() > 0) {
                z2 = getChildAt(0).getLeft() < this.cuq.left;
            }
            this.cus.setVisibility(z2 ? 0 : 4);
        }
        if (this.cut != null) {
            int childCount = getChildCount();
            boolean z3 = this.bkE + childCount < this.cwr;
            if (z3 || childCount <= 0) {
                z = z3;
            } else if (getChildAt(childCount - 1).getRight() <= getRight() - this.cuq.right) {
                z = false;
            }
            this.cut.setVisibility(z ? 0 : 4);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.g
    @ViewDebug.ExportedProperty
    public View getSelectedView() {
        if (this.cwr <= 0 || this.ceR < 0) {
            return null;
        }
        return getChildAt(this.ceR - this.bkE);
    }

    public int getListPaddingTop() {
        return this.cuq.top;
    }

    public int getListPaddingBottom() {
        return this.cuq.bottom;
    }

    public int getListPaddingLeft() {
        return this.cuq.left;
    }

    public int getListPaddingRight() {
        return this.cuq.right;
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
        View jM = this.cul.jM(i2);
        if (jM == null) {
            View jN = this.cul.jN(i2);
            if (jN != null) {
                view = this.mAdapter.getView(i2, jN, this);
                if (view != jN) {
                    this.cul.t(jN, i2);
                    if (this.cuU != 0) {
                        view.setDrawingCacheBackgroundColor(this.cuU);
                        jM = view;
                    }
                } else {
                    zArr[0] = true;
                    view.onFinishTemporaryDetach();
                    jM = view;
                }
                if (this.cuh) {
                    ViewGroup.LayoutParams layoutParams = jM.getLayoutParams();
                    if (layoutParams == null) {
                        fVar = (f) generateDefaultLayoutParams();
                    } else if (!checkLayoutParams(layoutParams)) {
                        fVar = (f) generateLayoutParams(layoutParams);
                    } else {
                        fVar = (f) layoutParams;
                    }
                    fVar.cvE = this.mAdapter.getItemId(i2);
                    jM.setLayoutParams(fVar);
                }
                if (this.cwt.isEnabled() && this.cvk == null) {
                    this.cvk = new g();
                }
            } else {
                view = this.mAdapter.getView(i2, null, this);
                if (this.cuU != 0) {
                    view.setDrawingCacheBackgroundColor(this.cuU);
                }
            }
            jM = view;
            if (this.cuh) {
            }
            if (this.cwt.isEnabled()) {
                this.cvk = new g();
            }
        }
        return jM;
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
            this.cuj = i2;
        }
        Rect rect = this.cuk;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        if (view instanceof m) {
            ((m) view).adjustListItemSelectionBounds(rect);
        }
        i(rect.left, rect.top, rect.right, rect.bottom);
        boolean z = this.cuV;
        if (view.isEnabled() != z) {
            this.cuV = !z;
            if (getSelectedItemPosition() != -1) {
                refreshDrawableState();
            }
        }
    }

    private void i(int i2, int i3, int i4, int i5) {
        this.cuk.set(i2 - this.cum, i3 - this.cun, this.cuo + i4, this.cup + i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        boolean z = this.cui;
        if (!z) {
            l(canvas);
        }
        super.dispatchDraw(canvas);
        if (z) {
            l(canvas);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        if (getChildCount() > 0) {
            this.aaZ = true;
            aiv();
        }
    }

    boolean ahO() {
        switch (this.mTouchMode) {
            case 1:
            case 2:
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean ahP() {
        return (hasFocus() && !isInTouchMode()) || ahO();
    }

    private void l(Canvas canvas) {
        if (!this.cuk.isEmpty()) {
            Drawable drawable = this.xS;
            drawable.setBounds(this.cuk);
            drawable.draw(canvas);
        }
    }

    public void setDrawSelectorOnTop(boolean z) {
        this.cui = z;
    }

    public void setSelector(int i2) {
        setSelector(getResources().getDrawable(i2));
    }

    public void setSelector(Drawable drawable) {
        if (this.xS != null) {
            this.xS.setCallback(null);
            unscheduleDrawable(this.xS);
        }
        this.xS = drawable;
        Rect rect = new Rect();
        drawable.getPadding(rect);
        this.cum = rect.left;
        this.cun = rect.top;
        this.cuo = rect.right;
        this.cup = rect.bottom;
        drawable.setCallback(this);
        ahR();
    }

    public Drawable getSelector() {
        return this.xS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ahQ() {
        if (isEnabled() && isClickable()) {
            Drawable drawable = this.xS;
            Rect rect = this.cuk;
            if (drawable != null) {
                if ((isFocused() || ahO()) && !rect.isEmpty()) {
                    View childAt = getChildAt(this.ceR - this.bkE);
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
                    if (isLongClickable && !this.aaZ) {
                        if (this.cuQ == null) {
                            this.cuQ = new b(this, null);
                        }
                        this.cuQ.aim();
                        postDelayed(this.cuQ, ViewConfiguration.getLongPressTimeout());
                    }
                }
            }
        }
    }

    void ahR() {
        if (this.xS != null) {
            if (ahP()) {
                this.xS.setState(getDrawableState());
            } else {
                this.xS.setState(cvr);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        ahR();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i2) {
        if (this.cuV) {
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
        return this.xS == drawable || super.verifyDrawable(drawable);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.xS != null) {
            this.xS.jumpToCurrentState();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnTouchModeChangeListener(this);
        if (this.mAdapter != null && this.cug == null) {
            this.cug = new a();
            this.mAdapter.registerDataSetObserver(this.cug);
            this.aaZ = true;
            this.cws = this.cwr;
            this.cwr = this.mAdapter.getCount();
        }
        this.cvn = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.g, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.cul.clear();
        getViewTreeObserver().removeOnTouchModeChangeListener(this);
        if (this.mAdapter != null && this.cug != null) {
            this.mAdapter.unregisterDataSetObserver(this.cug);
            this.cug = null;
        }
        if (this.cuD != null) {
            removeCallbacks(this.cuD);
        }
        if (this.cuE != null) {
            this.cuE.stop();
        }
        if (this.cuX != null) {
            removeCallbacks(this.cuX);
        }
        if (this.cuR != null) {
            removeCallbacks(this.cuR);
        }
        if (this.cuS != null) {
            removeCallbacks(this.cuS);
            this.cuS = null;
        }
        this.cvn = false;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        int i2 = isInTouchMode() ? 0 : 1;
        if (!z) {
            setChildrenDrawingCacheEnabled(false);
            if (this.cuD != null) {
                removeCallbacks(this.cuD);
                this.cuD.aif();
                if (this.cuE != null) {
                    this.cuE.stop();
                }
                if (getScrollX() != 0) {
                    this.ctY.setScrollX(0);
                    aid();
                    invalidate();
                }
            }
            if (i2 == 1) {
                this.cuK = this.ceR;
            }
        } else if (i2 != this.cuN && this.cuN != -1) {
            if (i2 == 1) {
                aib();
            } else {
                ahY();
                this.cuf = 0;
                layoutChildren();
            }
        }
        this.cuN = i2;
    }

    ContextMenu.ContextMenuInfo b(View view, int i2, long j2) {
        return new g.a(view, i2, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class n {
        private int cwe;

        private n() {
        }

        /* synthetic */ n(AbsHListView absHListView, n nVar) {
            this();
        }

        public void aim() {
            this.cwe = AbsHListView.this.getWindowAttachCount();
        }

        public boolean ain() {
            return AbsHListView.this.hasWindowFocus() && AbsHListView.this.getWindowAttachCount() == this.cwe;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class i extends n implements Runnable {
        int cvF;

        private i() {
            super(AbsHListView.this, null);
        }

        /* synthetic */ i(AbsHListView absHListView, i iVar) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            View childAt;
            if (!AbsHListView.this.aaZ) {
                ListAdapter listAdapter = AbsHListView.this.mAdapter;
                int i = this.cvF;
                if (listAdapter != null && AbsHListView.this.cwr > 0 && i != -1 && i < listAdapter.getCount() && ain() && (childAt = AbsHListView.this.getChildAt(i - AbsHListView.this.bkE)) != null) {
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
            View childAt = AbsHListView.this.getChildAt(AbsHListView.this.cuw - AbsHListView.this.bkE);
            if (childAt != null) {
                if ((!ain() || AbsHListView.this.aaZ) ? false : AbsHListView.this.c(childAt, AbsHListView.this.cuw, AbsHListView.this.mAdapter.getItemId(AbsHListView.this.cuw))) {
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
            if (AbsHListView.this.isPressed() && AbsHListView.this.ceR >= 0) {
                View childAt = AbsHListView.this.getChildAt(AbsHListView.this.ceR - AbsHListView.this.bkE);
                if (!AbsHListView.this.aaZ) {
                    if (ain() ? AbsHListView.this.c(childAt, AbsHListView.this.ceR, AbsHListView.this.cwq) : false) {
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
        if (Build.VERSION.SDK_INT >= 11 && this.ctZ == 3) {
            if (this.cua == null) {
                ActionMode startActionMode = startActionMode((com.baidu.tieba.horizonalList.a.a.b) this.cub);
                this.cua = startActionMode;
                if (startActionMode != null) {
                    setItemChecked(i2, true);
                    performHapticFeedback(0);
                }
            }
            return true;
        }
        boolean b2 = this.cwn != null ? this.cwn.b(this, view, i2, j2) : false;
        if (!b2) {
            this.cuL = b(view, i2, j2);
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
        return this.cuL;
    }

    public boolean a(float f2, float f3, int i2) {
        int pointToPosition = pointToPosition((int) f2, (int) f3);
        if (pointToPosition != -1) {
            long itemId = this.mAdapter.getItemId(pointToPosition);
            View childAt = getChildAt(pointToPosition - this.bkE);
            if (childAt != null) {
                this.cuL = b(childAt, pointToPosition, itemId);
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
            boolean b2 = this.cwn != null ? this.cwn.b(this, view, positionForView, itemId) : false;
            if (!b2) {
                this.cuL = b(getChildAt(positionForView - this.bkE), positionForView, itemId);
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
                if (isClickable() && isPressed() && this.ceR >= 0 && this.mAdapter != null && this.ceR < this.mAdapter.getCount()) {
                    View childAt = getChildAt(this.ceR - this.bkE);
                    if (childAt != null) {
                        performItemClick(childAt, this.ceR, this.cwq);
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
        Rect rect = this.cuJ;
        if (rect == null) {
            this.cuJ = new Rect();
            rect = this.cuJ;
        }
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt.getVisibility() == 0) {
                childAt.getHitRect(rect);
                if (rect.contains(i2, i3)) {
                    return this.bkE + childCount;
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
                View childAt = AbsHListView.this.getChildAt(AbsHListView.this.cuw - AbsHListView.this.bkE);
                if (childAt != null && !childAt.hasFocusable()) {
                    AbsHListView.this.cuf = 0;
                    if (!AbsHListView.this.aaZ) {
                        childAt.setPressed(true);
                        AbsHListView.this.setPressed(true);
                        AbsHListView.this.layoutChildren();
                        AbsHListView.this.b(AbsHListView.this.cuw, childAt);
                        AbsHListView.this.refreshDrawableState();
                        int longPressTimeout = ViewConfiguration.getLongPressTimeout();
                        boolean isLongClickable = AbsHListView.this.isLongClickable();
                        if (AbsHListView.this.xS != null && (current = AbsHListView.this.xS.getCurrent()) != null && (current instanceof TransitionDrawable)) {
                            if (isLongClickable) {
                                ((TransitionDrawable) current).startTransition(longPressTimeout);
                            } else {
                                ((TransitionDrawable) current).resetTransition();
                            }
                        }
                        if (isLongClickable) {
                            if (AbsHListView.this.cuO == null) {
                                AbsHListView.this.cuO = new c(AbsHListView.this, null);
                            }
                            AbsHListView.this.cuO.aim();
                            AbsHListView.this.postDelayed(AbsHListView.this.cuO, longPressTimeout);
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

    private boolean jA(int i2) {
        int i3 = i2 - this.cuz;
        int abs = Math.abs(i3);
        boolean z = getScrollX() != 0;
        if (z || abs > this.mTouchSlop) {
            ahW();
            if (z) {
                this.mTouchMode = 5;
                this.cuC = 0;
            } else {
                this.mTouchMode = 3;
                this.cuC = i3 > 0 ? this.mTouchSlop : -this.mTouchSlop;
            }
            Handler handler = getHandler();
            if (handler != null) {
                handler.removeCallbacks(this.cuO);
            }
            setPressed(false);
            View childAt = getChildAt(this.cuw - this.bkE);
            if (childAt != null) {
                childAt.setPressed(false);
            }
            jC(1);
            ViewParent parent = getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            jB(i2);
            return true;
        }
        return false;
    }

    private void jB(int i2) {
        int i3;
        int childCount;
        ViewParent parent;
        int i4 = i2 - this.cuz;
        int i5 = i4 - this.cuC;
        int i6 = this.cuB != Integer.MIN_VALUE ? i2 - this.cuB : i5;
        if (this.mTouchMode == 3) {
            if (i2 != this.cuB) {
                if (Math.abs(i4) > this.mTouchSlop && (parent = getParent()) != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
                if (this.cuw >= 0) {
                    childCount = this.cuw - this.bkE;
                } else {
                    childCount = getChildCount() / 2;
                }
                View childAt = getChildAt(childCount);
                int left = childAt != null ? childAt.getLeft() : 0;
                boolean at = i6 != 0 ? at(i5, i6) : false;
                View childAt2 = getChildAt(childCount);
                if (childAt2 != null) {
                    int left2 = childAt2.getLeft();
                    if (at) {
                        int i7 = (-i6) - (left2 - left);
                        overScrollBy(i7, 0, getScrollX(), 0, 0, 0, this.cvb, 0, true);
                        if (Math.abs(this.cvb) == Math.abs(getScrollX()) && this.mVelocityTracker != null) {
                            this.mVelocityTracker.clear();
                        }
                        int overScrollMode = getOverScrollMode();
                        if (overScrollMode == 0 || (overScrollMode == 1 && !ahI())) {
                            this.mDirection = 0;
                            this.mTouchMode = 5;
                            if (i4 > 0) {
                                this.cvd.onPull(i7 / getWidth());
                                if (!this.cve.isFinished()) {
                                    this.cve.onRelease();
                                }
                                invalidate();
                            } else if (i4 < 0) {
                                this.cve.onPull(i7 / getWidth());
                                if (!this.cvd.isFinished()) {
                                    this.cvd.onRelease();
                                }
                                invalidate();
                            }
                        }
                    }
                    this.cuz = i2;
                }
                this.cuB = i2;
            }
        } else if (this.mTouchMode == 5 && i2 != this.cuB) {
            int scrollX = getScrollX();
            int i8 = scrollX - i6;
            int i9 = i2 > this.cuB ? 1 : -1;
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
                overScrollBy(i10, 0, getScrollX(), 0, 0, 0, this.cvb, 0, true);
                int overScrollMode2 = getOverScrollMode();
                if (overScrollMode2 == 0 || (overScrollMode2 == 1 && !ahI())) {
                    if (i4 > 0) {
                        this.cvd.onPull(i10 / getWidth());
                        if (!this.cve.isFinished()) {
                            this.cve.onRelease();
                        }
                        invalidate();
                    } else if (i4 < 0) {
                        this.cve.onPull(i10 / getWidth());
                        if (!this.cvd.isFinished()) {
                            this.cvd.onRelease();
                        }
                        invalidate();
                    }
                }
            }
            if (i3 != 0) {
                if (getScrollX() != 0) {
                    this.ctY.setScrollX(0);
                    ahS();
                }
                at(i3, i3);
                this.mTouchMode = 3;
                int jF = jF(i2);
                this.cuC = 0;
                View childAt3 = getChildAt(jF - this.bkE);
                this.cux = childAt3 != null ? childAt3.getLeft() : 0;
                this.cuz = i2;
                this.cuw = jF;
            }
            this.cuB = i2;
            this.mDirection = i9;
        }
    }

    protected void ahS() {
        if (this.ctY.isHardwareAccelerated() && (getParent() instanceof View)) {
            ((View) getParent()).invalidate();
        }
    }

    @Override // android.view.ViewTreeObserver.OnTouchModeChangeListener
    public void onTouchModeChanged(boolean z) {
        if (z) {
            ahY();
            if (getWidth() > 0 && getChildCount() > 0) {
                layoutChildren();
            }
            ahR();
            return;
        }
        int i2 = this.mTouchMode;
        if (i2 == 5 || i2 == 6) {
            if (this.cuD != null) {
                this.cuD.aif();
            }
            if (this.cuE != null) {
                this.cuE.stop();
            }
            if (getScrollX() != 0) {
                this.ctY.setScrollX(0);
                aid();
                invalidate();
            }
        }
    }

    protected boolean h(MotionEvent motionEvent) {
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
        if (this.cuE != null) {
            this.cuE.stop();
        }
        if (this.cvn) {
            int action = motionEvent.getAction();
            ahU();
            this.mVelocityTracker.addMovement(motionEvent);
            switch (action & MotionEventCompat.ACTION_MASK) {
                case 0:
                    switch (this.mTouchMode) {
                        case 6:
                            this.cuD.aif();
                            if (this.cuE != null) {
                                this.cuE.stop();
                            }
                            this.mTouchMode = 5;
                            this.cuA = (int) motionEvent.getY();
                            int x = (int) motionEvent.getX();
                            this.cuB = x;
                            this.cuz = x;
                            this.cuC = 0;
                            this.mActivePointerId = motionEvent.getPointerId(0);
                            this.mDirection = 0;
                            break;
                        default:
                            this.mActivePointerId = motionEvent.getPointerId(0);
                            int x2 = (int) motionEvent.getX();
                            int y = (int) motionEvent.getY();
                            int pointToPosition = pointToPosition(x2, y);
                            if (!this.aaZ) {
                                if (this.mTouchMode != 4 && pointToPosition >= 0 && getAdapter().isEnabled(pointToPosition)) {
                                    this.mTouchMode = 0;
                                    if (this.cuP == null) {
                                        this.cuP = new d();
                                    }
                                    postDelayed(this.cuP, ViewConfiguration.getTapTimeout());
                                    i2 = pointToPosition;
                                } else if (this.mTouchMode == 4) {
                                    ahW();
                                    this.mTouchMode = 3;
                                    this.cuC = 0;
                                    i2 = jE(x2);
                                    this.cuD.aig();
                                }
                                if (i2 >= 0) {
                                    this.cux = getChildAt(i2 - this.bkE).getLeft();
                                }
                                this.cuz = x2;
                                this.cuA = y;
                                this.cuw = i2;
                                this.cuB = ExploreByTouchHelper.INVALID_ID;
                                break;
                            }
                            i2 = pointToPosition;
                            if (i2 >= 0) {
                            }
                            this.cuz = x2;
                            this.cuA = y;
                            this.cuw = i2;
                            this.cuB = ExploreByTouchHelper.INVALID_ID;
                    }
                    if (h(motionEvent) && this.mTouchMode == 0) {
                        removeCallbacks(this.cuP);
                        break;
                    }
                    break;
                case 1:
                    switch (this.mTouchMode) {
                        case 0:
                        case 1:
                        case 2:
                            int i3 = this.cuw;
                            View childAt = getChildAt(i3 - this.bkE);
                            float x3 = motionEvent.getX();
                            boolean z = x3 > ((float) this.cuq.left) && x3 < ((float) (getWidth() - this.cuq.right));
                            if (childAt != null && !childAt.hasFocusable() && z) {
                                if (this.mTouchMode != 0) {
                                    childAt.setPressed(false);
                                }
                                if (this.cuR == null) {
                                    this.cuR = new i(this, null);
                                }
                                i iVar = this.cuR;
                                iVar.cvF = i3;
                                iVar.aim();
                                this.cuK = i3;
                                if (this.mTouchMode == 0 || this.mTouchMode == 1) {
                                    Handler handler = getHandler();
                                    if (handler != null) {
                                        handler.removeCallbacks(this.mTouchMode == 0 ? this.cuP : this.cuO);
                                    }
                                    this.cuf = 0;
                                    if (!this.aaZ && this.mAdapter.isEnabled(i3)) {
                                        this.mTouchMode = 1;
                                        setSelectedPositionInt(this.cuw);
                                        layoutChildren();
                                        childAt.setPressed(true);
                                        b(this.cuw, childAt);
                                        setPressed(true);
                                        if (this.xS != null && (current = this.xS.getCurrent()) != null && (current instanceof TransitionDrawable)) {
                                            ((TransitionDrawable) current).resetTransition();
                                        }
                                        if (this.cuS != null) {
                                            removeCallbacks(this.cuS);
                                        }
                                        this.cuS = new com.baidu.tieba.horizonalList.widget.a(this, childAt, iVar);
                                        postDelayed(this.cuS, ViewConfiguration.getPressedStateDuration());
                                    } else {
                                        this.mTouchMode = -1;
                                        ahR();
                                    }
                                    return true;
                                } else if (!this.aaZ && this.mAdapter.isEnabled(i3)) {
                                    iVar.run();
                                }
                            }
                            this.mTouchMode = -1;
                            ahR();
                            break;
                        case 3:
                            int childCount = getChildCount();
                            if (childCount > 0) {
                                int left = getChildAt(0).getLeft();
                                int right = getChildAt(childCount - 1).getRight();
                                int i4 = this.cuq.left;
                                int width = getWidth() - this.cuq.right;
                                if (this.bkE == 0 && left >= i4 && this.bkE + childCount < this.cwr && right <= getWidth() - width) {
                                    this.mTouchMode = -1;
                                    jC(0);
                                    break;
                                } else {
                                    VelocityTracker velocityTracker = this.mVelocityTracker;
                                    velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                                    int xVelocity = (int) (velocityTracker.getXVelocity(this.mActivePointerId) * this.cuZ);
                                    if (Math.abs(xVelocity) > this.mMinimumVelocity && ((this.bkE != 0 || left != i4 - this.cvb) && (childCount + this.bkE != this.cwr || right != this.cvb + width))) {
                                        if (this.cuD == null) {
                                            this.cuD = new e();
                                        }
                                        jC(2);
                                        this.cuD.jG(-xVelocity);
                                        break;
                                    } else {
                                        this.mTouchMode = -1;
                                        jC(0);
                                        if (this.cuD != null) {
                                            this.cuD.aif();
                                        }
                                        if (this.cuE != null) {
                                            this.cuE.stop();
                                            break;
                                        }
                                    }
                                }
                            } else {
                                this.mTouchMode = -1;
                                jC(0);
                                break;
                            }
                            break;
                        case 5:
                            if (this.cuD == null) {
                                this.cuD = new e();
                            }
                            VelocityTracker velocityTracker2 = this.mVelocityTracker;
                            velocityTracker2.computeCurrentVelocity(1000, this.mMaximumVelocity);
                            int xVelocity2 = (int) velocityTracker2.getXVelocity(this.mActivePointerId);
                            jC(2);
                            if (Math.abs(xVelocity2) > this.mMinimumVelocity) {
                                this.cuD.jH(-xVelocity2);
                                break;
                            } else {
                                this.cuD.aie();
                                break;
                            }
                    }
                    setPressed(false);
                    if (this.cvd != null) {
                        this.cvd.onRelease();
                        this.cve.onRelease();
                    }
                    invalidate();
                    Handler handler2 = getHandler();
                    if (handler2 != null) {
                        handler2.removeCallbacks(this.cuO);
                    }
                    ahV();
                    this.mActivePointerId = -1;
                    break;
                case 2:
                    int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                    if (findPointerIndex == -1) {
                        this.mActivePointerId = motionEvent.getPointerId(0);
                        findPointerIndex = 0;
                    }
                    int x4 = (int) motionEvent.getX(findPointerIndex);
                    if (this.aaZ) {
                        layoutChildren();
                    }
                    switch (this.mTouchMode) {
                        case 0:
                        case 1:
                        case 2:
                            jA(x4);
                            break;
                        case 3:
                        case 5:
                            jB(x4);
                            break;
                    }
                case 3:
                    switch (this.mTouchMode) {
                        case 5:
                            if (this.cuD == null) {
                                this.cuD = new e();
                            }
                            this.cuD.aie();
                            break;
                        case 6:
                            break;
                        default:
                            this.mTouchMode = -1;
                            setPressed(false);
                            View childAt2 = getChildAt(this.cuw - this.bkE);
                            if (childAt2 != null) {
                                childAt2.setPressed(false);
                            }
                            ahX();
                            Handler handler3 = getHandler();
                            if (handler3 != null) {
                                handler3.removeCallbacks(this.cuO);
                            }
                            ahV();
                            break;
                    }
                    if (this.cvd != null) {
                        this.cvd.onRelease();
                        this.cve.onRelease();
                    }
                    this.mActivePointerId = -1;
                    break;
                case 5:
                    int actionIndex = motionEvent.getActionIndex();
                    int pointerId = motionEvent.getPointerId(actionIndex);
                    int x5 = (int) motionEvent.getX(actionIndex);
                    int y2 = (int) motionEvent.getY(actionIndex);
                    this.cuC = 0;
                    this.mActivePointerId = pointerId;
                    this.cuz = x5;
                    this.cuA = y2;
                    int pointToPosition2 = pointToPosition(x5, y2);
                    if (pointToPosition2 >= 0) {
                        this.cux = getChildAt(pointToPosition2 - this.bkE).getLeft();
                        this.cuw = pointToPosition2;
                    }
                    this.cuB = x5;
                    break;
                case 6:
                    onSecondaryPointerUp(motionEvent);
                    int i5 = this.cuz;
                    int pointToPosition3 = pointToPosition(i5, this.cuA);
                    if (pointToPosition3 >= 0) {
                        this.cux = getChildAt(pointToPosition3 - this.bkE).getLeft();
                        this.cuw = pointToPosition3;
                    }
                    this.cuB = i5;
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
            this.ctY.setScrollX(i2);
            ahS();
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
                            if (!at(horizontalScrollFactor, horizontalScrollFactor)) {
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
        if (this.cvs == 0.0f) {
            TypedValue typedValue = new TypedValue();
            if (getContext().getTheme().resolveAttribute(u.c.hlv_listPreferredItemWidth, typedValue, true)) {
                this.cvs = typedValue.getDimension(getContext().getResources().getDisplayMetrics());
            } else {
                throw new IllegalStateException("Expected theme to define hlv_listPreferredItemWidth.");
            }
        }
        return this.cvs;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.cvd != null) {
            int scrollX = getScrollX();
            if (!this.cvd.isFinished()) {
                int save = canvas.save();
                int i2 = this.cuq.top + this.cvi;
                int height = (getHeight() - i2) - (this.cuq.bottom + this.cvj);
                int min = Math.min(0, this.cvf + scrollX);
                canvas.rotate(-90.0f);
                canvas.translate(i2 + (-getHeight()), min);
                this.cvd.setSize(height, height);
                if (this.cvd.draw(canvas)) {
                    invalidate();
                }
                canvas.restoreToCount(save);
            }
            if (!this.cve.isFinished()) {
                int save2 = canvas.save();
                int i3 = this.cuq.left + this.cvi;
                int height2 = (getHeight() - i3) - (this.cuq.right + this.cvj);
                int max = Math.max(getWidth(), scrollX + this.cvg);
                canvas.rotate(90.0f);
                canvas.translate(-i3, -max);
                this.cve.setSize(height2, height2);
                if (this.cve.draw(canvas)) {
                    invalidate();
                }
                canvas.restoreToCount(save2);
            }
        }
    }

    private void ahT() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        } else {
            this.mVelocityTracker.clear();
        }
    }

    private void ahU() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
    }

    private void ahV() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            ahV();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.cuE != null) {
            this.cuE.stop();
        }
        if (this.cvn) {
            switch (action & MotionEventCompat.ACTION_MASK) {
                case 0:
                    int i2 = this.mTouchMode;
                    if (i2 == 6 || i2 == 5) {
                        this.cuC = 0;
                        return true;
                    }
                    int x = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();
                    this.mActivePointerId = motionEvent.getPointerId(0);
                    int jE = jE(x);
                    if (i2 != 4 && jE >= 0) {
                        this.cux = getChildAt(jE - this.bkE).getLeft();
                        this.cuz = x;
                        this.cuA = y;
                        this.cuw = jE;
                        this.mTouchMode = 0;
                        ahX();
                    }
                    this.cuB = ExploreByTouchHelper.INVALID_ID;
                    ahT();
                    this.mVelocityTracker.addMovement(motionEvent);
                    return i2 == 4;
                case 1:
                case 3:
                    this.mTouchMode = -1;
                    this.mActivePointerId = -1;
                    ahV();
                    jC(0);
                    return false;
                case 2:
                    switch (this.mTouchMode) {
                        case 0:
                            int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                            if (findPointerIndex == -1) {
                                this.mActivePointerId = motionEvent.getPointerId(0);
                                findPointerIndex = 0;
                            }
                            ahU();
                            this.mVelocityTracker.addMovement(motionEvent);
                            return jA((int) motionEvent.getX(findPointerIndex));
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
            this.cuz = (int) motionEvent.getX(i2);
            this.cuA = (int) motionEvent.getY(i2);
            this.cuC = 0;
            this.mActivePointerId = motionEvent.getPointerId(i2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        int childCount = getChildCount();
        int i2 = this.bkE;
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
    public void jC(int i2) {
        if (i2 != this.cuW && this.cuH != null) {
            this.cuW = i2;
            this.cuH.a(this, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e implements Runnable {
        private final o cvw;
        private int cvx;
        private final Runnable cvy = new com.baidu.tieba.horizonalList.widget.c(this);

        e() {
            this.cvw = new o(AbsHListView.this.getContext());
        }

        void jG(int i) {
            int i2 = i < 0 ? Integer.MAX_VALUE : 0;
            this.cvx = i2;
            this.cvw.setInterpolator(null);
            this.cvw.fling(i2, 0, i, 0, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
            AbsHListView.this.mTouchMode = 4;
            AbsHListView.this.ctY.e(this);
        }

        void aie() {
            if (this.cvw.springBack(AbsHListView.this.getScrollX(), 0, 0, 0, 0, 0)) {
                AbsHListView.this.mTouchMode = 6;
                AbsHListView.this.invalidate();
                AbsHListView.this.ctY.e(this);
                return;
            }
            AbsHListView.this.mTouchMode = -1;
            AbsHListView.this.jC(0);
        }

        void jH(int i) {
            this.cvw.setInterpolator(null);
            this.cvw.fling(AbsHListView.this.getScrollX(), 0, i, 0, ExploreByTouchHelper.INVALID_ID, Integer.MAX_VALUE, 0, 0, AbsHListView.this.getWidth(), 0);
            AbsHListView.this.mTouchMode = 6;
            AbsHListView.this.invalidate();
            AbsHListView.this.ctY.e(this);
        }

        void jI(int i) {
            this.cvw.notifyHorizontalEdgeReached(AbsHListView.this.getScrollX(), 0, AbsHListView.this.cvc);
            int overScrollMode = AbsHListView.this.getOverScrollMode();
            if (overScrollMode == 0 || (overScrollMode == 1 && !AbsHListView.this.ahI())) {
                AbsHListView.this.mTouchMode = 6;
                int currVelocity = (int) this.cvw.getCurrVelocity();
                if (i > 0) {
                    AbsHListView.this.cvd.onAbsorb(currVelocity);
                } else {
                    AbsHListView.this.cve.onAbsorb(currVelocity);
                }
            } else {
                AbsHListView.this.mTouchMode = -1;
                if (AbsHListView.this.cuE != null) {
                    AbsHListView.this.cuE.stop();
                }
            }
            AbsHListView.this.invalidate();
            AbsHListView.this.ctY.e(this);
        }

        void d(int i, int i2, boolean z) {
            int i3 = i < 0 ? Integer.MAX_VALUE : 0;
            this.cvx = i3;
            this.cvw.setInterpolator(z ? AbsHListView.cvp : null);
            this.cvw.startScroll(i3, 0, i, 0, i2);
            AbsHListView.this.mTouchMode = 4;
            AbsHListView.this.ctY.e(this);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void aif() {
            AbsHListView.this.mTouchMode = -1;
            AbsHListView.this.removeCallbacks(this);
            AbsHListView.this.removeCallbacks(this.cvy);
            AbsHListView.this.jC(0);
            AbsHListView.this.ahX();
            this.cvw.abortAnimation();
            AbsHListView.this.overScrollBy(0, 0, 0, 0, 0, 0, 0, 0, false);
        }

        void aig() {
            AbsHListView.this.postDelayed(this.cvy, 40L);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // java.lang.Runnable
        public void run() {
            int max;
            boolean z = true;
            boolean z2 = false;
            switch (AbsHListView.this.mTouchMode) {
                case 3:
                    if (this.cvw.isFinished()) {
                        return;
                    }
                    break;
                case 4:
                    break;
                case 5:
                default:
                    aif();
                    return;
                case 6:
                    o oVar = this.cvw;
                    if (oVar.computeScrollOffset()) {
                        int scrollX = AbsHListView.this.getScrollX();
                        int currX = oVar.getCurrX();
                        if (AbsHListView.this.overScrollBy(currX - scrollX, 0, scrollX, 0, 0, 0, AbsHListView.this.cvc, 0, false)) {
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
                                jG(currVelocity);
                                return;
                            }
                            aie();
                            return;
                        }
                        AbsHListView.this.invalidate();
                        AbsHListView.this.ctY.e(this);
                        return;
                    }
                    aif();
                    return;
            }
            if (AbsHListView.this.aaZ) {
                AbsHListView.this.layoutChildren();
            }
            if (AbsHListView.this.cwr == 0 || AbsHListView.this.getChildCount() == 0) {
                aif();
                return;
            }
            o oVar2 = this.cvw;
            boolean computeScrollOffset = oVar2.computeScrollOffset();
            int currX2 = oVar2.getCurrX();
            int i = this.cvx - currX2;
            if (i > 0) {
                AbsHListView.this.cuw = AbsHListView.this.bkE;
                AbsHListView.this.cux = AbsHListView.this.getChildAt(0).getLeft();
                max = Math.min(((AbsHListView.this.getWidth() - AbsHListView.this.getPaddingRight()) - AbsHListView.this.getPaddingLeft()) - 1, i);
            } else {
                int childCount = AbsHListView.this.getChildCount() - 1;
                AbsHListView.this.cuw = AbsHListView.this.bkE + childCount;
                AbsHListView.this.cux = AbsHListView.this.getChildAt(childCount).getLeft();
                max = Math.max(-(((AbsHListView.this.getWidth() - AbsHListView.this.getPaddingRight()) - AbsHListView.this.getPaddingLeft()) - 1), i);
            }
            View childAt = AbsHListView.this.getChildAt(AbsHListView.this.cuw - AbsHListView.this.bkE);
            int left = childAt != null ? childAt.getLeft() : 0;
            boolean at = AbsHListView.this.at(max, max);
            if (!at || max == 0) {
                z = false;
            }
            if (z) {
                if (childAt != null) {
                    AbsHListView.this.overScrollBy(-(max - (childAt.getLeft() - left)), 0, AbsHListView.this.getScrollX(), 0, 0, 0, AbsHListView.this.cvc, 0, false);
                }
                if (computeScrollOffset) {
                    jI(max);
                }
            } else if (computeScrollOffset && !z) {
                if (at) {
                    AbsHListView.this.invalidate();
                }
                this.cvx = currX2;
                AbsHListView.this.ctY.e(this);
            } else {
                aif();
            }
        }
    }

    /* loaded from: classes.dex */
    public class j implements Runnable {
        private int cvG;
        private int cvH;
        private int cvI;
        private int cvJ;
        private final int cvK;
        private int cvL;
        private int mMode;

        j() {
            this.cvK = ViewConfiguration.get(AbsHListView.this.getContext()).getScaledFadingEdgeLength();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void jG(int i) {
            int i2;
            stop();
            if (AbsHListView.this.aaZ) {
                AbsHListView.this.cuY = new com.baidu.tieba.horizonalList.widget.d(this, i);
                return;
            }
            int childCount = AbsHListView.this.getChildCount();
            if (childCount != 0) {
                int i3 = AbsHListView.this.bkE;
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
                    this.cvJ = 200 / i2;
                } else {
                    this.cvJ = 200;
                }
                this.cvG = max;
                this.cvH = -1;
                this.cvI = -1;
                AbsHListView.this.ctY.e(this);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void av(int i, int i2) {
            int i3;
            stop();
            if (i2 == -1) {
                jG(i);
            } else if (AbsHListView.this.aaZ) {
                AbsHListView.this.cuY = new com.baidu.tieba.horizonalList.widget.e(this, i, i2);
            } else {
                int childCount = AbsHListView.this.getChildCount();
                if (childCount != 0) {
                    int i4 = AbsHListView.this.bkE;
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
                        this.cvJ = 200 / i3;
                    } else {
                        this.cvJ = 200;
                    }
                    this.cvG = max;
                    this.cvH = i2;
                    this.cvI = -1;
                    AbsHListView.this.ctY.e(this);
                }
            }
        }

        void s(int i, int i2, int i3) {
            int i4 = AbsHListView.this.bkE;
            int childCount = (AbsHListView.this.getChildCount() + i4) - 1;
            int i5 = AbsHListView.this.cuq.left;
            int width = AbsHListView.this.getWidth() - AbsHListView.this.cuq.right;
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
            int i2 = AbsHListView.this.bkE;
            switch (this.mMode) {
                case 1:
                    int childCount = AbsHListView.this.getChildCount() - 1;
                    int i3 = i2 + childCount;
                    if (childCount >= 0) {
                        if (i3 == this.cvI) {
                            AbsHListView.this.ctY.e(this);
                            return;
                        }
                        View childAt = AbsHListView.this.getChildAt(childCount);
                        AbsHListView.this.c((i3 < AbsHListView.this.cwr + (-1) ? Math.max(AbsHListView.this.cuq.right, this.cvK) : AbsHListView.this.cuq.right) + (childAt.getWidth() - (width - childAt.getLeft())), this.cvJ, true);
                        this.cvI = i3;
                        if (i3 < this.cvG) {
                            AbsHListView.this.ctY.e(this);
                            return;
                        }
                        return;
                    }
                    return;
                case 2:
                    if (i2 == this.cvI) {
                        AbsHListView.this.ctY.e(this);
                        return;
                    }
                    View childAt2 = AbsHListView.this.getChildAt(0);
                    if (childAt2 != null) {
                        AbsHListView.this.c(childAt2.getLeft() - (i2 > 0 ? Math.max(this.cvK, AbsHListView.this.cuq.left) : AbsHListView.this.cuq.left), this.cvJ, true);
                        this.cvI = i2;
                        if (i2 > this.cvG) {
                            AbsHListView.this.ctY.e(this);
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    int childCount2 = AbsHListView.this.getChildCount();
                    if (i2 != this.cvH && childCount2 > 1 && childCount2 + i2 < AbsHListView.this.cwr) {
                        int i4 = i2 + 1;
                        if (i4 == this.cvI) {
                            AbsHListView.this.ctY.e(this);
                            return;
                        }
                        View childAt3 = AbsHListView.this.getChildAt(1);
                        int width2 = childAt3.getWidth();
                        int left2 = childAt3.getLeft();
                        int max = Math.max(AbsHListView.this.cuq.right, this.cvK);
                        if (i4 < this.cvH) {
                            AbsHListView.this.c(Math.max(0, (left2 + width2) - max), this.cvJ, true);
                            this.cvI = i4;
                            AbsHListView.this.ctY.e(this);
                            return;
                        } else if (left2 > max) {
                            AbsHListView.this.c(left2 - max, this.cvJ, true);
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
                        if (i5 == this.cvI) {
                            AbsHListView.this.ctY.e(this);
                            return;
                        }
                        View childAt4 = AbsHListView.this.getChildAt(childCount3);
                        int width3 = childAt4.getWidth();
                        int left3 = childAt4.getLeft();
                        int i6 = width - left3;
                        int max2 = Math.max(AbsHListView.this.cuq.left, this.cvK);
                        this.cvI = i5;
                        if (i5 > this.cvH) {
                            AbsHListView.this.c(-(i6 - max2), this.cvJ, true);
                            AbsHListView.this.ctY.e(this);
                            return;
                        }
                        int i7 = width - max2;
                        int i8 = left3 + width3;
                        if (i7 > i8) {
                            AbsHListView.this.c(-(i7 - i8), this.cvJ, true);
                            return;
                        }
                        return;
                    }
                    return;
                case 5:
                    if (this.cvI == i2) {
                        AbsHListView.this.ctY.e(this);
                        return;
                    }
                    this.cvI = i2;
                    int childCount4 = AbsHListView.this.getChildCount();
                    int i9 = this.cvG;
                    int i10 = (i2 + childCount4) - 1;
                    if (i9 < i2) {
                        i = (i2 - i9) + 1;
                    } else if (i9 > i10) {
                        i = i9 - i10;
                    }
                    float min = Math.min(Math.abs(i / childCount4), 1.0f);
                    if (i9 < i2) {
                        AbsHListView.this.c((int) ((-AbsHListView.this.getWidth()) * min), (int) (min * this.cvJ), true);
                        AbsHListView.this.ctY.e(this);
                        return;
                    } else if (i9 > i10) {
                        AbsHListView.this.c((int) (AbsHListView.this.getWidth() * min), (int) (min * this.cvJ), true);
                        AbsHListView.this.ctY.e(this);
                        return;
                    } else {
                        AbsHListView.this.c(AbsHListView.this.getChildAt(i9 - i2).getLeft() - this.cvL, (int) (this.cvJ * (Math.abs(left) / AbsHListView.this.getWidth())), true);
                        return;
                    }
                default:
                    return;
            }
        }
    }

    public void setFriction(float f2) {
        if (this.cuD == null) {
            this.cuD = new e();
        }
        this.cuD.cvw.setFriction(f2);
    }

    public void setVelocityScale(float f2) {
        this.cuZ = f2;
    }

    public void smoothScrollToPosition(int i2, int i3) {
        if (this.cuE == null) {
            this.cuE = new j();
        }
        this.cuE.av(i2, i3);
    }

    public void smoothScrollBy(int i2, int i3) {
        c(i2, i3, false);
    }

    public void c(int i2, int i3, boolean z) {
        if (this.cuD == null) {
            this.cuD = new e();
        }
        int i4 = this.bkE;
        int childCount = getChildCount();
        int i5 = i4 + childCount;
        int paddingLeft = getPaddingLeft();
        int width = getWidth() - getPaddingRight();
        if (i2 == 0 || this.cwr == 0 || childCount == 0 || ((i4 == 0 && getChildAt(0).getLeft() == paddingLeft && i2 < 0) || (i5 == this.cwr && getChildAt(childCount - 1).getRight() == width && i2 > 0))) {
            this.cuD.aif();
            if (this.cuE != null) {
                this.cuE.stop();
                return;
            }
            return;
        }
        jC(2);
        this.cuD.d(i2, i3, z);
    }

    private void ahW() {
        if (this.mScrollingCacheEnabled && !this.cuu && !this.ctY.isHardwareAccelerated()) {
            setChildrenDrawnWithCacheEnabled(true);
            setChildrenDrawingCacheEnabled(true);
            this.cuv = true;
            this.cuu = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahX() {
        if (!this.ctY.isHardwareAccelerated()) {
            if (this.cuX == null) {
                this.cuX = new com.baidu.tieba.horizonalList.widget.b(this);
            }
            post(this.cuX);
        }
    }

    boolean at(int i2, int i3) {
        int min;
        int min2;
        int i4;
        int childCount = getChildCount();
        if (childCount == 0) {
            return true;
        }
        int left = getChildAt(0).getLeft();
        int right = getChildAt(childCount - 1).getRight();
        Rect rect = this.cuq;
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
        int i6 = this.bkE;
        if (i6 == 0) {
            this.cvf = left - rect.left;
        } else {
            this.cvf += min2;
        }
        if (i6 + childCount == this.cwr) {
            this.cvg = rect.right + right;
        } else {
            this.cvg += min2;
        }
        boolean z = i6 == 0 && left >= rect.left && min2 >= 0;
        boolean z2 = i6 + childCount == this.cwr && right <= getWidth() - rect.right && min2 <= 0;
        if (z || z2) {
            return min2 != 0;
        }
        boolean z3 = min2 < 0;
        boolean isInTouchMode = isInTouchMode();
        if (isInTouchMode) {
            ahY();
        }
        int headerViewsCount = getHeaderViewsCount();
        int footerViewsCount = this.cwr - getFooterViewsCount();
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
                    this.cul.t(childAt, i11);
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
                    this.cul.t(childAt2, i14);
                }
                i4 = i13;
                i7 = i12;
            }
        }
        this.cuy = this.cux + min;
        this.cwz = true;
        if (i4 > 0) {
            detachViewsFromParent(i7, i4);
            this.cul.aij();
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        jD(min2);
        if (z3) {
            this.bkE = i4 + this.bkE;
        }
        int abs = Math.abs(min2);
        if (i5 < abs || width < abs) {
            eI(z3);
        }
        if (!isInTouchMode && this.ceR != -1) {
            int i15 = this.ceR - this.bkE;
            if (i15 >= 0 && i15 < getChildCount()) {
                b(this.ceR, getChildAt(i15));
            }
        } else if (this.cuj != -1) {
            int i16 = this.cuj - this.bkE;
            if (i16 >= 0 && i16 < getChildCount()) {
                b(-1, getChildAt(i16));
            }
        } else {
            this.cuk.setEmpty();
        }
        this.cwz = false;
        ahJ();
        return false;
    }

    public void jD(int i2) {
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
    public void ahY() {
        if (this.ceR != -1) {
            if (this.cuf != 4) {
                this.cuK = this.ceR;
            }
            if (this.cwo >= 0 && this.cwo != this.ceR) {
                this.cuK = this.cwo;
            }
            setSelectedPositionInt(-1);
            setNextSelectedPositionInt(-1);
            this.cuF = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int ahZ() {
        int i2 = this.ceR;
        if (i2 < 0) {
            i2 = this.cuK;
        }
        return Math.min(Math.max(0, i2), this.cwr - 1);
    }

    protected int jF(int i2) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return -1;
        }
        int jE = jE(i2);
        return jE == -1 ? (this.bkE + childCount) - 1 : jE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aia() {
        if (this.ceR >= 0 || !aib()) {
            return false;
        }
        ahR();
        return true;
    }

    boolean aib() {
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
        int i8 = this.cuq.left;
        int right = (getRight() - getLeft()) - this.cuq.right;
        int i9 = this.bkE;
        int i10 = this.cuK;
        if (i10 >= i9 && i10 < i9 + childCount) {
            View childAt = getChildAt(i10 - this.bkE);
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
            int i15 = this.cwr;
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
        this.cuK = -1;
        removeCallbacks(this.cuD);
        if (this.cuE != null) {
            this.cuE.stop();
        }
        this.mTouchMode = -1;
        ahX();
        this.cwf = i2;
        int B = B(i3, z);
        if (B < i9 || B > getLastVisiblePosition()) {
            B = -1;
        } else {
            this.cuf = 4;
            ahR();
            setSelectionInt(B);
            ahJ();
        }
        jC(0);
        return B >= 0;
    }

    void aic() {
        int i2;
        boolean z;
        boolean z2;
        this.cud.clear();
        int i3 = 0;
        boolean z3 = false;
        while (i3 < this.cue.size()) {
            long keyAt = this.cue.keyAt(i3);
            int intValue = this.cue.valueAt(i3).intValue();
            if (keyAt != this.mAdapter.getItemId(intValue)) {
                int max = Math.max(0, intValue - 20);
                int min = Math.min(intValue + 20, this.cwr);
                while (true) {
                    if (max >= min) {
                        z2 = false;
                        break;
                    } else if (keyAt != this.mAdapter.getItemId(max)) {
                        max++;
                    } else {
                        this.cud.put(max, true);
                        this.cue.setValueAt(i3, Integer.valueOf(max));
                        z2 = true;
                        break;
                    }
                }
                if (!z2) {
                    this.cue.delete(keyAt);
                    int i4 = i3 - 1;
                    this.cuc--;
                    if (Build.VERSION.SDK_INT <= 11 || this.cua == null || this.cub == null) {
                        i2 = i4;
                        z = true;
                    } else {
                        ((com.baidu.tieba.horizonalList.a.a.b) this.cub).onItemCheckedStateChanged((ActionMode) this.cua, intValue, keyAt, false);
                        i2 = i4;
                        z = true;
                    }
                    z3 = z;
                    i3 = i2 + 1;
                }
            } else {
                this.cud.put(intValue, true);
            }
            i2 = i3;
            z = z3;
            z3 = z;
            i3 = i2 + 1;
        }
        if (z3 && this.cua != null && Build.VERSION.SDK_INT > 11) {
            ((ActionMode) this.cua).invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.g
    public void handleDataChanged() {
        int i2 = this.cwr;
        int i3 = this.cvo;
        this.cvo = this.cwr;
        if (this.ctZ != 0 && this.mAdapter != null && this.mAdapter.hasStableIds()) {
            aic();
        }
        this.cul.aii();
        if (i2 > 0) {
            if (this.cwj) {
                this.cwj = false;
                this.cvq = null;
                if (this.cuT == 2) {
                    this.cuf = 3;
                    return;
                }
                if (this.cuT == 1) {
                    if (this.cvh) {
                        this.cvh = false;
                        this.cuf = 3;
                        return;
                    }
                    int childCount = getChildCount();
                    int width = getWidth() - getPaddingRight();
                    View childAt = getChildAt(childCount - 1);
                    int bottom = childAt != null ? childAt.getBottom() : width;
                    if (childCount + this.bkE >= i3 && bottom <= width) {
                        this.cuf = 3;
                        return;
                    }
                    awakenScrollBars();
                }
                switch (this.cwk) {
                    case 1:
                        this.cuf = 5;
                        this.cwg = Math.min(Math.max(0, this.cwg), i2 - 1);
                        return;
                    case 0:
                        if (isInTouchMode()) {
                            this.cuf = 5;
                            this.cwg = Math.min(Math.max(0, this.cwg), i2 - 1);
                            return;
                        }
                        int aiu = aiu();
                        if (aiu >= 0 && B(aiu, true) == aiu) {
                            this.cwg = aiu;
                            if (this.cwi == getWidth()) {
                                this.cuf = 5;
                            } else {
                                this.cuf = 2;
                            }
                            setNextSelectedPositionInt(aiu);
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
                int B = B(selectedItemPosition, true);
                if (B >= 0) {
                    setNextSelectedPositionInt(B);
                    return;
                }
                int B2 = B(selectedItemPosition, false);
                if (B2 >= 0) {
                    setNextSelectedPositionInt(B2);
                    return;
                }
            } else if (this.cuK >= 0) {
                return;
            }
        }
        this.cuf = this.cuG ? 3 : 1;
        this.ceR = -1;
        this.cwq = Long.MIN_VALUE;
        this.cwo = -1;
        this.cwp = Long.MIN_VALUE;
        this.cwj = false;
        this.cvq = null;
        this.cuj = -1;
        ait();
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
        this.cuT = i2;
    }

    public int getTranscriptMode() {
        return this.cuT;
    }

    @Override // android.view.View
    public int getSolidColor() {
        return this.cuU;
    }

    public void setCacheColorHint(int i2) {
        if (i2 != this.cuU) {
            this.cuU = i2;
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                getChildAt(i3).setDrawingCacheBackgroundColor(i2);
            }
            this.cul.setCacheColorHint(i2);
        }
    }

    @ViewDebug.ExportedProperty(category = "drawing")
    public int getCacheColorHint() {
        return this.cuU;
    }

    private void aid() {
        if (this.cvd != null) {
            this.cvd.finish();
            this.cve.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void au(int i2, int i3) {
    }

    public void setRecyclerListener(l lVar) {
        this.cul.cvO = lVar;
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
        public int cvA;
        public boolean cvB;
        public boolean cvC;
        public int cvD;
        public long cvE;

        public f(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.cvE = -1L;
        }

        public f(int i, int i2, int i3) {
            super(i, i2);
            this.cvE = -1L;
            this.cvA = i3;
        }

        public f(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.cvE = -1L;
        }
    }

    /* loaded from: classes.dex */
    public class k {
        private l cvO;
        private int cvP;
        private View[] cvQ = new View[0];
        private ArrayList<View>[] cvR;
        private int cvS;
        private ArrayList<View> cvT;
        private ArrayList<View> cvU;
        private SparseArrayCompat<View> cvV;

        public k() {
        }

        public void jJ(int i) {
            if (i < 1) {
                throw new IllegalArgumentException("Can't have a viewTypeCount < 1");
            }
            ArrayList<View>[] arrayListArr = new ArrayList[i];
            for (int i2 = 0; i2 < i; i2++) {
                arrayListArr[i2] = new ArrayList<>();
            }
            this.cvS = i;
            this.cvT = arrayListArr[0];
            this.cvR = arrayListArr;
        }

        public void aih() {
            if (this.cvS == 1) {
                ArrayList<View> arrayList = this.cvT;
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    arrayList.get(i).forceLayout();
                }
            } else {
                int i2 = this.cvS;
                for (int i3 = 0; i3 < i2; i3++) {
                    ArrayList<View> arrayList2 = this.cvR[i3];
                    int size2 = arrayList2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        arrayList2.get(i4).forceLayout();
                    }
                }
            }
            if (this.cvV != null) {
                int size3 = this.cvV.size();
                for (int i5 = 0; i5 < size3; i5++) {
                    this.cvV.valueAt(i5).forceLayout();
                }
            }
        }

        public boolean jK(int i) {
            return i >= 0;
        }

        public void clear() {
            if (this.cvS == 1) {
                ArrayList<View> arrayList = this.cvT;
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    AbsHListView.this.removeDetachedView(arrayList.remove((size - 1) - i), false);
                }
            } else {
                int i2 = this.cvS;
                for (int i3 = 0; i3 < i2; i3++) {
                    ArrayList<View> arrayList2 = this.cvR[i3];
                    int size2 = arrayList2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        AbsHListView.this.removeDetachedView(arrayList2.remove((size2 - 1) - i4), false);
                    }
                }
            }
            if (this.cvV != null) {
                this.cvV.clear();
            }
        }

        public void aw(int i, int i2) {
            if (this.cvQ.length < i) {
                this.cvQ = new View[i];
            }
            this.cvP = i2;
            View[] viewArr = this.cvQ;
            for (int i3 = 0; i3 < i; i3++) {
                View childAt = AbsHListView.this.getChildAt(i3);
                f fVar = (f) childAt.getLayoutParams();
                if (fVar != null && fVar.cvA != -2) {
                    viewArr[i3] = childAt;
                }
            }
        }

        public View jL(int i) {
            int i2 = i - this.cvP;
            View[] viewArr = this.cvQ;
            if (i2 < 0 || i2 >= viewArr.length) {
                return null;
            }
            View view = viewArr[i2];
            viewArr[i2] = null;
            return view;
        }

        View jM(int i) {
            int indexOfKey;
            if (this.cvV != null && (indexOfKey = this.cvV.indexOfKey(i)) >= 0) {
                View valueAt = this.cvV.valueAt(indexOfKey);
                this.cvV.removeAt(indexOfKey);
                return valueAt;
            }
            return null;
        }

        void aii() {
            if (this.cvV != null) {
                this.cvV.clear();
            }
        }

        View jN(int i) {
            if (this.cvS == 1) {
                return AbsHListView.a(this.cvT, i);
            }
            int itemViewType = AbsHListView.this.mAdapter.getItemViewType(i);
            if (itemViewType >= 0 && itemViewType < this.cvR.length) {
                return AbsHListView.a(this.cvR[itemViewType], i);
            }
            return null;
        }

        public void t(View view, int i) {
            f fVar = (f) view.getLayoutParams();
            if (fVar != null) {
                fVar.cvD = i;
                int i2 = fVar.cvA;
                if (!jK(i2)) {
                    if (i2 != -2) {
                        if (this.cvU == null) {
                            this.cvU = new ArrayList<>();
                        }
                        this.cvU.add(view);
                        return;
                    }
                    return;
                }
                view.onStartTemporaryDetach();
                if (this.cvS == 1) {
                    this.cvT.add(view);
                } else {
                    this.cvR[i2].add(view);
                }
                if (Build.VERSION.SDK_INT >= 14) {
                    view.setAccessibilityDelegate(null);
                }
                if (this.cvO != null) {
                    this.cvO.onMovedToScrapHeap(view);
                }
            }
        }

        public void aij() {
            if (this.cvU != null) {
                int size = this.cvU.size();
                for (int i = 0; i < size; i++) {
                    AbsHListView.this.removeDetachedView(this.cvU.get(i), false);
                }
                this.cvU.clear();
            }
        }

        public void aik() {
            View[] viewArr = this.cvQ;
            boolean z = this.cvO != null;
            boolean z2 = this.cvS > 1;
            ArrayList<View> arrayList = this.cvT;
            for (int length = viewArr.length - 1; length >= 0; length--) {
                View view = viewArr[length];
                if (view != null) {
                    f fVar = (f) view.getLayoutParams();
                    int i = fVar.cvA;
                    viewArr[length] = null;
                    if (!jK(i)) {
                        if (i != -2) {
                            AbsHListView.this.removeDetachedView(view, false);
                        }
                    } else {
                        if (z2) {
                            arrayList = this.cvR[i];
                        }
                        view.onStartTemporaryDetach();
                        fVar.cvD = this.cvP + length;
                        arrayList.add(view);
                        if (Build.VERSION.SDK_INT >= 14) {
                            view.setAccessibilityDelegate(null);
                        }
                        if (z) {
                            this.cvO.onMovedToScrapHeap(view);
                        }
                    }
                }
            }
            ail();
        }

        private void ail() {
            int length = this.cvQ.length;
            int i = this.cvS;
            ArrayList<View>[] arrayListArr = this.cvR;
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
            if (this.cvV != null) {
                for (int i6 = 0; i6 < this.cvV.size(); i6++) {
                    this.cvV.valueAt(i6);
                }
            }
        }

        void setCacheColorHint(int i) {
            View[] viewArr;
            if (this.cvS == 1) {
                ArrayList<View> arrayList = this.cvT;
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    arrayList.get(i2).setDrawingCacheBackgroundColor(i);
                }
            } else {
                int i3 = this.cvS;
                for (int i4 = 0; i4 < i3; i4++) {
                    ArrayList<View> arrayList2 = this.cvR[i4];
                    int size2 = arrayList2.size();
                    for (int i5 = 0; i5 < size2; i5++) {
                        arrayList2.get(i5).setDrawingCacheBackgroundColor(i);
                    }
                }
            }
            for (View view : this.cvQ) {
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
                if (((f) view.getLayoutParams()).cvD == i2) {
                    arrayList.remove(i3);
                    return view;
                }
            }
            return arrayList.remove(size - 1);
        }
        return null;
    }
}
