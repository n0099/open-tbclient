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
import com.baidu.tieba.horizonalList.widget.f;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class AbsHListView extends com.baidu.tieba.horizonalList.widget.f<ListAdapter> implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnTouchModeChangeListener {
    static final Interpolator cyw = new LinearInterpolator();
    public static final int[] cyy = new int[1];
    Drawable Hm;
    protected boolean cxA;
    protected boolean cxB;
    protected int cxC;
    int cxD;
    int cxE;
    int cxF;
    int cxG;
    protected int cxH;
    int cxI;
    int cxJ;
    private e cxK;
    protected j cxL;
    protected int cxM;
    protected boolean cxN;
    private h cxO;
    private boolean cxP;
    private Rect cxQ;
    protected int cxR;
    private ContextMenu.ContextMenuInfo cxS;
    protected int cxT;
    private int cxU;
    private c cxV;
    private Runnable cxW;
    private b cxX;
    private i cxY;
    private Runnable cxZ;
    b.a cxe;
    protected int cxf;
    public Object cxg;
    Object cxh;
    int cxi;
    protected SparseArrayCompat<Boolean> cxj;
    LongSparseArray<Integer> cxk;
    protected int cxl;
    protected a cxm;
    boolean cxn;
    boolean cxo;
    int cxp;
    protected Rect cxq;
    protected final k cxr;
    int cxs;
    int cxt;
    int cxu;
    int cxv;
    protected Rect cxw;
    protected int cxx;
    View cxy;
    View cxz;
    private int cya;
    private int cyb;
    private boolean cyc;
    private int cyd;
    private Runnable cye;
    protected Runnable cyf;
    private float cyg;
    protected final boolean[] cyh;
    int cyi;
    int cyj;
    private EdgeEffectCompat cyk;
    private EdgeEffectCompat cyl;
    private int cym;
    private int cyn;
    private boolean cyo;
    private int cyp;
    private int cyq;
    private g cyr;
    private int cys;
    private int cyt;
    protected boolean cyu;
    private int cyv;
    private SavedState cyx;
    private float cyz;
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

    protected abstract void eN(boolean z);

    protected abstract int jW(int i2);

    public abstract void setSelectionInt(int i2);

    public AbsHListView(Context context) {
        super(context);
        this.cxf = 0;
        this.cxl = 0;
        this.cxo = false;
        this.cxp = -1;
        this.cxq = new Rect();
        this.cxr = new k();
        this.cxs = 0;
        this.cxt = 0;
        this.cxu = 0;
        this.cxv = 0;
        this.cxw = new Rect();
        this.cxx = 0;
        this.cxH = -1;
        this.cxM = 0;
        this.cxP = true;
        this.cxR = -1;
        this.cxS = null;
        this.cxU = -1;
        this.cyd = 0;
        this.cyg = 1.0f;
        this.cyh = new boolean[1];
        this.mActivePointerId = -1;
        this.mDirection = 0;
        ahS();
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
        this.cxf = 0;
        this.cxl = 0;
        this.cxo = false;
        this.cxp = -1;
        this.cxq = new Rect();
        this.cxr = new k();
        this.cxs = 0;
        this.cxt = 0;
        this.cxu = 0;
        this.cxv = 0;
        this.cxw = new Rect();
        this.cxx = 0;
        this.cxH = -1;
        this.cxM = 0;
        this.cxP = true;
        this.cxR = -1;
        this.cxS = null;
        this.cxU = -1;
        this.cyd = 0;
        this.cyg = 1.0f;
        this.cyh = new boolean[1];
        this.mActivePointerId = -1;
        this.mDirection = 0;
        ahS();
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
        this.cxo = z3;
        setStackFromRight(z2);
        setScrollingCacheEnabled(z);
        setTranscriptMode(i3);
        setCacheColorHint(i4);
        setSmoothScrollbarEnabled(z4);
        setChoiceMode(i5);
    }

    private void ahS() {
        setClickable(true);
        setFocusableInTouchMode(true);
        setWillNotDraw(false);
        setAlwaysDrawnWithCacheEnabled(false);
        setScrollingCacheEnabled(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.cyi = viewConfiguration.getScaledOverscrollDistance();
        this.cyj = viewConfiguration.getScaledOverflingDistance();
        this.cxe = com.baidu.tieba.horizonalList.a.b.aq(this);
    }

    @Override // android.view.View
    public void setOverScrollMode(int i2) {
        if (i2 != 2) {
            if (this.cyk == null) {
                Context context = getContext();
                this.cyk = new EdgeEffectCompat(context);
                this.cyl = new EdgeEffectCompat(context);
            }
        } else {
            this.cyk = null;
            this.cyl = null;
        }
        super.setOverScrollMode(i2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.horizonalList.widget.f
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            this.cxn = this.mAdapter.hasStableIds();
            if (this.cxf != 0 && this.cxn && this.cxk == null) {
                this.cxk = new LongSparseArray<>();
            }
        }
        if (this.cxj != null) {
            this.cxj.clear();
        }
        if (this.cxk != null) {
            this.cxk.clear();
        }
    }

    public int getCheckedItemCount() {
        return this.cxi;
    }

    public boolean isItemChecked(int i2) {
        if (this.cxf == 0 || this.cxj == null) {
            return false;
        }
        return this.cxj.get(i2, false).booleanValue();
    }

    public int getCheckedItemPosition() {
        if (this.cxf == 1 && this.cxj != null && this.cxj.size() == 1) {
            return this.cxj.keyAt(0);
        }
        return -1;
    }

    public SparseArrayCompat<Boolean> getCheckedItemPositions() {
        if (this.cxf != 0) {
            return this.cxj;
        }
        return null;
    }

    public long[] getCheckedItemIds() {
        if (this.cxf == 0 || this.cxk == null || this.mAdapter == null) {
            return new long[0];
        }
        LongSparseArray<Integer> longSparseArray = this.cxk;
        int size = longSparseArray.size();
        long[] jArr = new long[size];
        for (int i2 = 0; i2 < size; i2++) {
            jArr[i2] = longSparseArray.keyAt(i2);
        }
        return jArr;
    }

    public void clearChoices() {
        if (this.cxj != null) {
            this.cxj.clear();
        }
        if (this.cxk != null) {
            this.cxk.clear();
        }
        this.cxi = 0;
    }

    public void setItemChecked(int i2, boolean z) {
        if (this.cxf != 0) {
            if (Build.VERSION.SDK_INT >= 11 && z && this.cxf == 3 && this.cxg == null) {
                if (this.cxh == null || !((com.baidu.tieba.horizonalList.a.a.b) this.cxh).ahR()) {
                    throw new IllegalStateException("AbsListView: attempted to start selection mode for CHOICE_MODE_MULTIPLE_MODAL but no choice mode callback was supplied. Call setMultiChoiceModeListener to set a callback.");
                }
                this.cxg = startActionMode((com.baidu.tieba.horizonalList.a.a.b) this.cxh);
            }
            if (this.cxf == 2 || (Build.VERSION.SDK_INT >= 11 && this.cxf == 3)) {
                boolean booleanValue = this.cxj.get(i2, false).booleanValue();
                this.cxj.put(i2, Boolean.valueOf(z));
                if (this.cxk != null && this.mAdapter.hasStableIds()) {
                    if (z) {
                        this.cxk.put(this.mAdapter.getItemId(i2), Integer.valueOf(i2));
                    } else {
                        this.cxk.delete(this.mAdapter.getItemId(i2));
                    }
                }
                if (booleanValue != z) {
                    if (z) {
                        this.cxi++;
                    } else {
                        this.cxi--;
                    }
                }
                if (this.cxg != null) {
                    ((com.baidu.tieba.horizonalList.a.a.b) this.cxh).onItemCheckedStateChanged((ActionMode) this.cxg, i2, this.mAdapter.getItemId(i2), z);
                }
            } else {
                boolean z2 = this.cxk != null && this.mAdapter.hasStableIds();
                if (z || isItemChecked(i2)) {
                    this.cxj.clear();
                    if (z2) {
                        this.cxk.clear();
                    }
                }
                if (z) {
                    this.cxj.put(i2, true);
                    if (z2) {
                        this.cxk.put(this.mAdapter.getItemId(i2), Integer.valueOf(i2));
                    }
                    this.cxi = 1;
                } else if (this.cxj.size() == 0 || !this.cxj.valueAt(0).booleanValue()) {
                    this.cxi = 0;
                }
            }
            if (!this.mInLayout && !this.czH) {
                this.aiO = true;
                aiH();
                requestLayout();
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public boolean performItemClick(View view, int i2, long j2) {
        boolean z;
        boolean z2;
        boolean z3 = true;
        boolean z4 = false;
        if (this.cxf != 0) {
            if (this.cxf == 2 || (Build.VERSION.SDK_INT >= 11 && this.cxf == 3 && this.cxg != null)) {
                boolean z5 = !this.cxj.get(i2, false).booleanValue();
                this.cxj.put(i2, Boolean.valueOf(z5));
                if (this.cxk != null && this.mAdapter.hasStableIds()) {
                    if (z5) {
                        this.cxk.put(this.mAdapter.getItemId(i2), Integer.valueOf(i2));
                    } else {
                        this.cxk.delete(this.mAdapter.getItemId(i2));
                    }
                }
                if (z5) {
                    this.cxi++;
                } else {
                    this.cxi--;
                }
                if (this.cxg != null) {
                    ((com.baidu.tieba.horizonalList.a.a.b) this.cxh).onItemCheckedStateChanged((ActionMode) this.cxg, i2, j2, z5);
                } else {
                    z4 = true;
                }
                z2 = z4;
                z4 = true;
            } else if (this.cxf == 1) {
                if (!this.cxj.get(i2, false).booleanValue()) {
                    this.cxj.clear();
                    this.cxj.put(i2, true);
                    if (this.cxk != null && this.mAdapter.hasStableIds()) {
                        this.cxk.clear();
                        this.cxk.put(this.mAdapter.getItemId(i2), Integer.valueOf(i2));
                    }
                    this.cxi = 1;
                } else if (this.cxj.size() == 0 || !this.cxj.valueAt(0).booleanValue()) {
                    this.cxi = 0;
                }
                z4 = true;
                z2 = true;
            } else {
                z2 = true;
            }
            if (z4) {
                ahT();
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

    private void ahT() {
        int i2 = this.czm;
        int childCount = getChildCount();
        boolean z = Build.VERSION.SDK_INT >= 11;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            int i4 = i2 + i3;
            if (childAt instanceof Checkable) {
                ((Checkable) childAt).setChecked(this.cxj.get(i4, false).booleanValue());
            } else if (z) {
                childAt.setActivated(this.cxj.get(i4, false).booleanValue());
            }
        }
    }

    public int getChoiceMode() {
        return this.cxf;
    }

    public void setChoiceMode(int i2) {
        this.cxf = i2;
        if (Build.VERSION.SDK_INT >= 11 && this.cxg != null) {
            if (Build.VERSION.SDK_INT >= 11) {
                ((ActionMode) this.cxg).finish();
            }
            this.cxg = null;
        }
        if (this.cxf != 0) {
            if (this.cxj == null) {
                this.cxj = new SparseArrayCompat<>();
            }
            if (this.cxk == null && this.mAdapter != null && this.mAdapter.hasStableIds()) {
                this.cxk = new LongSparseArray<>();
            }
            if (Build.VERSION.SDK_INT >= 11 && this.cxf == 3) {
                clearChoices();
                setLongClickable(true);
            }
        }
    }

    public void setMultiChoiceModeListener(com.baidu.tieba.horizonalList.a.a.a aVar) {
        if (Build.VERSION.SDK_INT >= 11) {
            if (this.cxh == null) {
                this.cxh = new com.baidu.tieba.horizonalList.a.a.b(this);
            }
            ((com.baidu.tieba.horizonalList.a.a.b) this.cxh).a(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ahU() {
        int childCount = getChildCount();
        if (childCount == 0) {
            return true;
        }
        if (childCount != this.czz) {
            return false;
        }
        return getChildAt(0).getLeft() >= this.cxw.left && getChildAt(childCount + (-1)).getRight() <= getWidth() - this.cxw.right;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public int getHorizontalScrollbarHeight() {
        return super.getHorizontalScrollbarHeight();
    }

    public void setSmoothScrollbarEnabled(boolean z) {
        this.cxP = z;
    }

    public void setOnScrollListener(h hVar) {
        this.cxO = hVar;
        ahV();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ahV() {
        if (this.cxO != null) {
            this.cxO.a(this, this.czm, getChildCount(), this.czz);
        }
        onScrollChanged(0, 0, 0, 0);
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEvent(int i2) {
        if (i2 == 4096) {
            int firstVisiblePosition = getFirstVisiblePosition();
            int lastVisiblePosition = getLastVisiblePosition();
            if (this.cys != firstVisiblePosition || this.cyt != lastVisiblePosition) {
                this.cys = firstVisiblePosition;
                this.cyt = lastVisiblePosition;
            } else {
                return;
            }
        }
        super.sendAccessibilityEvent(i2);
    }

    @Override // com.baidu.tieba.horizonalList.widget.f, android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(AbsHListView.class.getName());
    }

    @Override // com.baidu.tieba.horizonalList.widget.f, android.view.View
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
            aij();
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

    private void ahW() {
        setSelector(getResources().getDrawable(17301602));
    }

    public void setStackFromRight(boolean z) {
        if (this.cxN != z) {
            this.cxN = z;
            ahX();
        }
    }

    void ahX() {
        if (getChildCount() > 0) {
            ahY();
            requestLayout();
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new com.baidu.tieba.horizonalList.widget.e();
        long czd;
        long cze;
        int czf;
        String czg;
        boolean czh;
        int czi;
        SparseArrayCompat<Boolean> czj;
        LongSparseArray<Integer> czk;
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
            this.czd = parcel.readLong();
            this.cze = parcel.readLong();
            this.czf = parcel.readInt();
            this.position = parcel.readInt();
            this.width = parcel.readInt();
            this.czg = parcel.readString();
            this.czh = parcel.readByte() != 0;
            this.czi = parcel.readInt();
            this.czj = j(parcel);
            this.czk = i(parcel);
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
            parcel.writeLong(this.czd);
            parcel.writeLong(this.cze);
            parcel.writeInt(this.czf);
            parcel.writeInt(this.position);
            parcel.writeInt(this.width);
            parcel.writeString(this.czg);
            parcel.writeByte((byte) (this.czh ? 1 : 0));
            parcel.writeInt(this.czi);
            a(this.czj, parcel);
            a(this.czk, parcel);
        }

        public String toString() {
            return "AbsListView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " selectedId=" + this.czd + " firstId=" + this.cze + " viewLeft=" + this.czf + " position=" + this.position + " width=" + this.width + " filter=" + this.czg + " checkState=" + this.czj + "}";
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        boolean z = true;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.cyx != null) {
            savedState.czd = this.cyx.czd;
            savedState.cze = this.cyx.cze;
            savedState.czf = this.cyx.czf;
            savedState.position = this.cyx.position;
            savedState.width = this.cyx.width;
            savedState.czg = this.cyx.czg;
            savedState.czh = this.cyx.czh;
            savedState.czi = this.cyx.czi;
            savedState.czj = this.cyx.czj;
            savedState.czk = this.cyx.czk;
            return savedState;
        }
        boolean z2 = getChildCount() > 0 && this.czz > 0;
        long selectedItemId = getSelectedItemId();
        savedState.czd = selectedItemId;
        savedState.width = getWidth();
        if (selectedItemId >= 0) {
            savedState.czf = this.cxM;
            savedState.position = getSelectedItemPosition();
            savedState.cze = -1L;
        } else if (z2 && this.czm > 0) {
            savedState.czf = getChildAt(0).getLeft();
            int i2 = this.czm;
            if (i2 >= this.czz) {
                i2 = this.czz - 1;
            }
            savedState.position = i2;
            savedState.cze = this.mAdapter.getItemId(i2);
        } else {
            savedState.czf = 0;
            savedState.cze = -1L;
            savedState.position = 0;
        }
        savedState.czg = null;
        savedState.czh = (Build.VERSION.SDK_INT < 11 || this.cxf != 3 || this.cxg == null) ? false : false;
        if (this.cxj != null) {
            try {
                savedState.czj = this.cxj.m1clone();
            } catch (NoSuchMethodError e2) {
                e2.printStackTrace();
                savedState.czj = new SparseArrayCompat<>();
            }
        }
        if (this.cxk != null) {
            LongSparseArray<Integer> longSparseArray = new LongSparseArray<>();
            int size = this.cxk.size();
            for (int i3 = 0; i3 < size; i3++) {
                longSparseArray.put(this.cxk.keyAt(i3), this.cxk.valueAt(i3));
            }
            savedState.czk = longSparseArray;
        }
        savedState.czi = this.cxi;
        return savedState;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.aiO = true;
        this.czq = savedState.width;
        if (savedState.czd >= 0) {
            this.czr = true;
            this.cyx = savedState;
            this.czp = savedState.czd;
            this.czo = savedState.position;
            this.czn = savedState.czf;
            this.czs = 0;
        } else if (savedState.cze >= 0) {
            setSelectedPositionInt(-1);
            setNextSelectedPositionInt(-1);
            this.cxp = -1;
            this.czr = true;
            this.cyx = savedState;
            this.czp = savedState.cze;
            this.czo = savedState.position;
            this.czn = savedState.czf;
            this.czs = 1;
        }
        if (savedState.czj != null) {
            this.cxj = savedState.czj;
        }
        if (savedState.czk != null) {
            this.cxk = savedState.czk;
        }
        this.cxi = savedState.czi;
        if (Build.VERSION.SDK_INT >= 11 && savedState.czh && this.cxf == 3 && this.cxh != null) {
            this.cxg = startActionMode((com.baidu.tieba.horizonalList.a.a.b) this.cxh);
        }
        requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onFocusChanged(boolean z, int i2, Rect rect) {
        super.onFocusChanged(z, i2, rect);
        if (z && this.ciA < 0 && !isInTouchMode()) {
            if (!this.cyu && this.mAdapter != null) {
                this.aiO = true;
                this.czA = this.czz;
                this.czz = this.mAdapter.getCount();
            }
            ain();
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (!this.czH && !this.mInLayout) {
            super.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ahY() {
        removeAllViewsInLayout();
        this.czm = 0;
        this.aiO = false;
        this.cyf = null;
        this.czr = false;
        this.cyx = null;
        this.czC = -1;
        this.czD = Long.MIN_VALUE;
        setSelectedPositionInt(-1);
        setNextSelectedPositionInt(-1);
        this.cxM = 0;
        this.cxp = -1;
        this.cxq.setEmpty();
        invalidate();
    }

    @Override // android.view.View
    protected int computeHorizontalScrollExtent() {
        int childCount = getChildCount();
        if (childCount > 0) {
            if (this.cxP) {
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
        int i3 = this.czm;
        int childCount = getChildCount();
        if (i3 < 0 || childCount <= 0) {
            return 0;
        }
        if (this.cxP) {
            View childAt = getChildAt(0);
            int left = childAt.getLeft();
            int width = childAt.getWidth();
            if (width > 0) {
                return Math.max(((i3 * 100) - ((left * 100) / width)) + ((int) ((getScrollX() / getWidth()) * this.czz * 100.0f)), 0);
            }
            return 0;
        }
        int i4 = this.czz;
        if (i3 != 0) {
            i2 = i3 + childCount == i4 ? i4 : (childCount / 2) + i3;
        }
        return (int) (((i2 / i4) * childCount) + i3);
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        if (this.cxP) {
            int max = Math.max(this.czz * 100, 0);
            if (getScrollX() != 0) {
                return max + Math.abs((int) ((getScrollX() / getWidth()) * this.czz * 100.0f));
            }
            return max;
        }
        return this.czz;
    }

    @Override // android.view.View
    protected float getLeftFadingEdgeStrength() {
        int childCount = getChildCount();
        float leftFadingEdgeStrength = super.getLeftFadingEdgeStrength();
        if (childCount != 0) {
            if (this.czm > 0) {
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
            if ((this.czm + childCount) - 1 < this.czz - 1) {
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
            ahW();
        }
        Rect rect = this.cxw;
        rect.left = this.cxs + getPaddingLeft();
        rect.top = this.cxt + getPaddingTop();
        rect.right = this.cxu + getPaddingRight();
        rect.bottom = this.cxv + getPaddingBottom();
        if (this.cya == 1) {
            int childCount = getChildCount();
            int width = getWidth() - getPaddingRight();
            View childAt = getChildAt(childCount - 1);
            this.cyo = childCount + this.czm >= this.cyv && (childAt != null ? childAt.getRight() : width) <= width;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.f, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        this.mInLayout = true;
        if (z) {
            int childCount = getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                getChildAt(i6).forceLayout();
            }
            this.cxr.ait();
        }
        layoutChildren();
        this.mInLayout = false;
        this.cxT = (i4 - i2) / 3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void layoutChildren() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ahZ() {
        boolean z = true;
        if (this.cxy != null) {
            boolean z2 = this.czm > 0;
            if (!z2 && getChildCount() > 0) {
                z2 = getChildAt(0).getLeft() < this.cxw.left;
            }
            this.cxy.setVisibility(z2 ? 0 : 4);
        }
        if (this.cxz != null) {
            int childCount = getChildCount();
            boolean z3 = this.czm + childCount < this.czz;
            if (z3 || childCount <= 0) {
                z = z3;
            } else if (getChildAt(childCount - 1).getRight() <= getRight() - this.cxw.right) {
                z = false;
            }
            this.cxz.setVisibility(z ? 0 : 4);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    @ViewDebug.ExportedProperty
    public View getSelectedView() {
        if (this.czz <= 0 || this.ciA < 0) {
            return null;
        }
        return getChildAt(this.ciA - this.czm);
    }

    public int getListPaddingTop() {
        return this.cxw.top;
    }

    public int getListPaddingBottom() {
        return this.cxw.bottom;
    }

    public int getListPaddingLeft() {
        return this.cxw.left;
    }

    public int getListPaddingRight() {
        return this.cxw.right;
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
        View kd = this.cxr.kd(i2);
        if (kd == null) {
            View ke = this.cxr.ke(i2);
            if (ke != null) {
                view = this.mAdapter.getView(i2, ke, this);
                if (view != ke) {
                    this.cxr.q(ke, i2);
                    if (this.cyb != 0) {
                        view.setDrawingCacheBackgroundColor(this.cyb);
                        kd = view;
                    }
                } else {
                    zArr[0] = true;
                    view.onFinishTemporaryDetach();
                    kd = view;
                }
                if (this.cxn) {
                    ViewGroup.LayoutParams layoutParams = kd.getLayoutParams();
                    if (layoutParams == null) {
                        fVar = (f) generateDefaultLayoutParams();
                    } else if (!checkLayoutParams(layoutParams)) {
                        fVar = (f) generateLayoutParams(layoutParams);
                    } else {
                        fVar = (f) layoutParams;
                    }
                    fVar.cyL = this.mAdapter.getItemId(i2);
                    kd.setLayoutParams(fVar);
                }
                if (this.czB.isEnabled() && this.cyr == null) {
                    this.cyr = new g();
                }
            } else {
                view = this.mAdapter.getView(i2, null, this);
                if (this.cyb != 0) {
                    view.setDrawingCacheBackgroundColor(this.cyb);
                }
            }
            kd = view;
            if (this.cxn) {
            }
            if (this.czB.isEnabled()) {
                this.cyr = new g();
            }
        }
        return kd;
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
            this.cxp = i2;
        }
        Rect rect = this.cxq;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        if (view instanceof m) {
            ((m) view).adjustListItemSelectionBounds(rect);
        }
        i(rect.left, rect.top, rect.right, rect.bottom);
        boolean z = this.cyc;
        if (view.isEnabled() != z) {
            this.cyc = !z;
            if (getSelectedItemPosition() != -1) {
                refreshDrawableState();
            }
        }
    }

    private void i(int i2, int i3, int i4, int i5) {
        this.cxq.set(i2 - this.cxs, i3 - this.cxt, this.cxu + i4, this.cxv + i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        boolean z = this.cxo;
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
            this.aiO = true;
            aiH();
        }
    }

    boolean aia() {
        switch (this.cxH) {
            case 1:
            case 2:
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aib() {
        return (hasFocus() && !isInTouchMode()) || aia();
    }

    private void e(Canvas canvas) {
        if (!this.cxq.isEmpty()) {
            Drawable drawable = this.Hm;
            drawable.setBounds(this.cxq);
            drawable.draw(canvas);
        }
    }

    public void setDrawSelectorOnTop(boolean z) {
        this.cxo = z;
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
        this.cxs = rect.left;
        this.cxt = rect.top;
        this.cxu = rect.right;
        this.cxv = rect.bottom;
        drawable.setCallback(this);
        aid();
    }

    public Drawable getSelector() {
        return this.Hm;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aic() {
        if (isEnabled() && isClickable()) {
            Drawable drawable = this.Hm;
            Rect rect = this.cxq;
            if (drawable != null) {
                if ((isFocused() || aia()) && !rect.isEmpty()) {
                    View childAt = getChildAt(this.ciA - this.czm);
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
                    if (isLongClickable && !this.aiO) {
                        if (this.cxX == null) {
                            this.cxX = new b(this, null);
                        }
                        this.cxX.aiy();
                        postDelayed(this.cxX, ViewConfiguration.getLongPressTimeout());
                    }
                }
            }
        }
    }

    void aid() {
        if (this.Hm != null) {
            if (aib()) {
                this.Hm.setState(getDrawableState());
            } else {
                this.Hm.setState(cyy);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        aid();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i2) {
        if (this.cyc) {
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
        if (this.mAdapter != null && this.cxm == null) {
            this.cxm = new a();
            this.mAdapter.registerDataSetObserver(this.cxm);
            this.aiO = true;
            this.czA = this.czz;
            this.czz = this.mAdapter.getCount();
        }
        this.cyu = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.f, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.cxr.clear();
        getViewTreeObserver().removeOnTouchModeChangeListener(this);
        if (this.mAdapter != null && this.cxm != null) {
            this.mAdapter.unregisterDataSetObserver(this.cxm);
            this.cxm = null;
        }
        if (this.cxK != null) {
            removeCallbacks(this.cxK);
        }
        if (this.cxL != null) {
            this.cxL.stop();
        }
        if (this.cye != null) {
            removeCallbacks(this.cye);
        }
        if (this.cxY != null) {
            removeCallbacks(this.cxY);
        }
        if (this.cxZ != null) {
            removeCallbacks(this.cxZ);
            this.cxZ = null;
        }
        this.cyu = false;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        int i2 = isInTouchMode() ? 0 : 1;
        if (!z) {
            setChildrenDrawingCacheEnabled(false);
            if (this.cxK != null) {
                removeCallbacks(this.cxK);
                this.cxK.air();
                if (this.cxL != null) {
                    this.cxL.stop();
                }
                if (getScrollX() != 0) {
                    this.cxe.setScrollX(0);
                    aip();
                    invalidate();
                }
            }
            if (i2 == 1) {
                this.cxR = this.ciA;
            }
        } else if (i2 != this.cxU && this.cxU != -1) {
            if (i2 == 1) {
                ain();
            } else {
                aik();
                this.cxl = 0;
                layoutChildren();
            }
        }
        this.cxU = i2;
    }

    ContextMenu.ContextMenuInfo b(View view, int i2, long j2) {
        return new f.a(view, i2, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class n {
        private int czl;

        private n() {
        }

        /* synthetic */ n(AbsHListView absHListView, n nVar) {
            this();
        }

        public void aiy() {
            this.czl = AbsHListView.this.getWindowAttachCount();
        }

        public boolean aiz() {
            return AbsHListView.this.hasWindowFocus() && AbsHListView.this.getWindowAttachCount() == this.czl;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class i extends n implements Runnable {
        int cyM;

        private i() {
            super(AbsHListView.this, null);
        }

        /* synthetic */ i(AbsHListView absHListView, i iVar) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            View childAt;
            if (!AbsHListView.this.aiO) {
                ListAdapter listAdapter = AbsHListView.this.mAdapter;
                int i = this.cyM;
                if (listAdapter != null && AbsHListView.this.czz > 0 && i != -1 && i < listAdapter.getCount() && aiz() && (childAt = AbsHListView.this.getChildAt(i - AbsHListView.this.czm)) != null) {
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
            View childAt = AbsHListView.this.getChildAt(AbsHListView.this.cxC - AbsHListView.this.czm);
            if (childAt != null) {
                if ((!aiz() || AbsHListView.this.aiO) ? false : AbsHListView.this.c(childAt, AbsHListView.this.cxC, AbsHListView.this.mAdapter.getItemId(AbsHListView.this.cxC))) {
                    AbsHListView.this.cxH = -1;
                    AbsHListView.this.setPressed(false);
                    childAt.setPressed(false);
                    return;
                }
                AbsHListView.this.cxH = 2;
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
            if (AbsHListView.this.isPressed() && AbsHListView.this.ciA >= 0) {
                View childAt = AbsHListView.this.getChildAt(AbsHListView.this.ciA - AbsHListView.this.czm);
                if (!AbsHListView.this.aiO) {
                    if (aiz() ? AbsHListView.this.c(childAt, AbsHListView.this.ciA, AbsHListView.this.czy) : false) {
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
        if (Build.VERSION.SDK_INT >= 11 && this.cxf == 3) {
            if (this.cxg == null) {
                ActionMode startActionMode = startActionMode((com.baidu.tieba.horizonalList.a.a.b) this.cxh);
                this.cxg = startActionMode;
                if (startActionMode != null) {
                    setItemChecked(i2, true);
                    performHapticFeedback(0);
                }
            }
            return true;
        }
        boolean b2 = this.czv != null ? this.czv.b(this, view, i2, j2) : false;
        if (!b2) {
            this.cxS = b(view, i2, j2);
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
        return this.cxS;
    }

    public boolean a(float f2, float f3, int i2) {
        int pointToPosition = pointToPosition((int) f2, (int) f3);
        if (pointToPosition != -1) {
            long itemId = this.mAdapter.getItemId(pointToPosition);
            View childAt = getChildAt(pointToPosition - this.czm);
            if (childAt != null) {
                this.cxS = b(childAt, pointToPosition, itemId);
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
            boolean b2 = this.czv != null ? this.czv.b(this, view, positionForView, itemId) : false;
            if (!b2) {
                this.cxS = b(getChildAt(positionForView - this.czm), positionForView, itemId);
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
                if (isClickable() && isPressed() && this.ciA >= 0 && this.mAdapter != null && this.ciA < this.mAdapter.getCount()) {
                    View childAt = getChildAt(this.ciA - this.czm);
                    if (childAt != null) {
                        performItemClick(childAt, this.ciA, this.czy);
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
        Rect rect = this.cxQ;
        if (rect == null) {
            this.cxQ = new Rect();
            rect = this.cxQ;
        }
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt.getVisibility() == 0) {
                childAt.getHitRect(rect);
                if (rect.contains(i2, i3)) {
                    return this.czm + childCount;
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
            if (AbsHListView.this.cxH == 0) {
                AbsHListView.this.cxH = 1;
                View childAt = AbsHListView.this.getChildAt(AbsHListView.this.cxC - AbsHListView.this.czm);
                if (childAt != null && !childAt.hasFocusable()) {
                    AbsHListView.this.cxl = 0;
                    if (!AbsHListView.this.aiO) {
                        childAt.setPressed(true);
                        AbsHListView.this.setPressed(true);
                        AbsHListView.this.layoutChildren();
                        AbsHListView.this.d(AbsHListView.this.cxC, childAt);
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
                            if (AbsHListView.this.cxV == null) {
                                AbsHListView.this.cxV = new c(AbsHListView.this, null);
                            }
                            AbsHListView.this.cxV.aiy();
                            AbsHListView.this.postDelayed(AbsHListView.this.cxV, longPressTimeout);
                            return;
                        }
                        AbsHListView.this.cxH = 2;
                        return;
                    }
                    AbsHListView.this.cxH = 2;
                }
            }
        }
    }

    private boolean jS(int i2) {
        int i3 = i2 - this.cxF;
        int abs = Math.abs(i3);
        boolean z = getScrollX() != 0;
        if (z || abs > this.mTouchSlop) {
            aii();
            if (z) {
                this.cxH = 5;
                this.cxJ = 0;
            } else {
                this.cxH = 3;
                this.cxJ = i3 > 0 ? this.mTouchSlop : -this.mTouchSlop;
            }
            Handler handler = getHandler();
            if (handler != null) {
                handler.removeCallbacks(this.cxV);
            }
            setPressed(false);
            View childAt = getChildAt(this.cxC - this.czm);
            if (childAt != null) {
                childAt.setPressed(false);
            }
            jU(1);
            ViewParent parent = getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            jT(i2);
            return true;
        }
        return false;
    }

    private void jT(int i2) {
        int i3;
        int childCount;
        ViewParent parent;
        int i4 = i2 - this.cxF;
        int i5 = i4 - this.cxJ;
        int i6 = this.cxI != Integer.MIN_VALUE ? i2 - this.cxI : i5;
        if (this.cxH == 3) {
            if (i2 != this.cxI) {
                if (Math.abs(i4) > this.mTouchSlop && (parent = getParent()) != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
                if (this.cxC >= 0) {
                    childCount = this.cxC - this.czm;
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
                        overScrollBy(i7, 0, getScrollX(), 0, 0, 0, this.cyi, 0, true);
                        if (Math.abs(this.cyi) == Math.abs(getScrollX()) && this.mVelocityTracker != null) {
                            this.mVelocityTracker.clear();
                        }
                        int overScrollMode = getOverScrollMode();
                        if (overScrollMode == 0 || (overScrollMode == 1 && !ahU())) {
                            this.mDirection = 0;
                            this.cxH = 5;
                            if (i4 > 0) {
                                this.cyk.onPull(i7 / getWidth());
                                if (!this.cyl.isFinished()) {
                                    this.cyl.onRelease();
                                }
                                invalidate();
                            } else if (i4 < 0) {
                                this.cyl.onPull(i7 / getWidth());
                                if (!this.cyk.isFinished()) {
                                    this.cyk.onRelease();
                                }
                                invalidate();
                            }
                        }
                    }
                    this.cxF = i2;
                }
                this.cxI = i2;
            }
        } else if (this.cxH == 5 && i2 != this.cxI) {
            int scrollX = getScrollX();
            int i8 = scrollX - i6;
            int i9 = i2 > this.cxI ? 1 : -1;
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
                overScrollBy(i10, 0, getScrollX(), 0, 0, 0, this.cyi, 0, true);
                int overScrollMode2 = getOverScrollMode();
                if (overScrollMode2 == 0 || (overScrollMode2 == 1 && !ahU())) {
                    if (i4 > 0) {
                        this.cyk.onPull(i10 / getWidth());
                        if (!this.cyl.isFinished()) {
                            this.cyl.onRelease();
                        }
                        invalidate();
                    } else if (i4 < 0) {
                        this.cyl.onPull(i10 / getWidth());
                        if (!this.cyk.isFinished()) {
                            this.cyk.onRelease();
                        }
                        invalidate();
                    }
                }
            }
            if (i3 != 0) {
                if (getScrollX() != 0) {
                    this.cxe.setScrollX(0);
                    aie();
                }
                at(i3, i3);
                this.cxH = 3;
                int jX = jX(i2);
                this.cxJ = 0;
                View childAt3 = getChildAt(jX - this.czm);
                this.cxD = childAt3 != null ? childAt3.getLeft() : 0;
                this.cxF = i2;
                this.cxC = jX;
            }
            this.cxI = i2;
            this.mDirection = i9;
        }
    }

    protected void aie() {
        if (this.cxe.isHardwareAccelerated() && (getParent() instanceof View)) {
            ((View) getParent()).invalidate();
        }
    }

    @Override // android.view.ViewTreeObserver.OnTouchModeChangeListener
    public void onTouchModeChanged(boolean z) {
        if (z) {
            aik();
            if (getWidth() > 0 && getChildCount() > 0) {
                layoutChildren();
            }
            aid();
            return;
        }
        int i2 = this.cxH;
        if (i2 == 5 || i2 == 6) {
            if (this.cxK != null) {
                this.cxK.air();
            }
            if (this.cxL != null) {
                this.cxL.stop();
            }
            if (getScrollX() != 0) {
                this.cxe.setScrollX(0);
                aip();
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
        if (this.cxL != null) {
            this.cxL.stop();
        }
        if (this.cyu) {
            int action = motionEvent.getAction();
            aig();
            this.mVelocityTracker.addMovement(motionEvent);
            switch (action & MotionEventCompat.ACTION_MASK) {
                case 0:
                    switch (this.cxH) {
                        case 6:
                            this.cxK.air();
                            if (this.cxL != null) {
                                this.cxL.stop();
                            }
                            this.cxH = 5;
                            this.cxG = (int) motionEvent.getY();
                            int x = (int) motionEvent.getX();
                            this.cxI = x;
                            this.cxF = x;
                            this.cxJ = 0;
                            this.mActivePointerId = motionEvent.getPointerId(0);
                            this.mDirection = 0;
                            break;
                        default:
                            this.mActivePointerId = motionEvent.getPointerId(0);
                            int x2 = (int) motionEvent.getX();
                            int y = (int) motionEvent.getY();
                            int pointToPosition = pointToPosition(x2, y);
                            if (!this.aiO) {
                                if (this.cxH != 4 && pointToPosition >= 0 && getAdapter().isEnabled(pointToPosition)) {
                                    this.cxH = 0;
                                    if (this.cxW == null) {
                                        this.cxW = new d();
                                    }
                                    postDelayed(this.cxW, ViewConfiguration.getTapTimeout());
                                    i2 = pointToPosition;
                                } else if (this.cxH == 4) {
                                    aii();
                                    this.cxH = 3;
                                    this.cxJ = 0;
                                    i2 = jW(x2);
                                    this.cxK.ais();
                                }
                                if (i2 >= 0) {
                                    this.cxD = getChildAt(i2 - this.czm).getLeft();
                                }
                                this.cxF = x2;
                                this.cxG = y;
                                this.cxC = i2;
                                this.cxI = ExploreByTouchHelper.INVALID_ID;
                                break;
                            }
                            i2 = pointToPosition;
                            if (i2 >= 0) {
                            }
                            this.cxF = x2;
                            this.cxG = y;
                            this.cxC = i2;
                            this.cxI = ExploreByTouchHelper.INVALID_ID;
                    }
                    if (o(motionEvent) && this.cxH == 0) {
                        removeCallbacks(this.cxW);
                        break;
                    }
                    break;
                case 1:
                    switch (this.cxH) {
                        case 0:
                        case 1:
                        case 2:
                            int i3 = this.cxC;
                            View childAt = getChildAt(i3 - this.czm);
                            float x3 = motionEvent.getX();
                            boolean z = x3 > ((float) this.cxw.left) && x3 < ((float) (getWidth() - this.cxw.right));
                            if (childAt != null && !childAt.hasFocusable() && z) {
                                if (this.cxH != 0) {
                                    childAt.setPressed(false);
                                }
                                if (this.cxY == null) {
                                    this.cxY = new i(this, null);
                                }
                                i iVar = this.cxY;
                                iVar.cyM = i3;
                                iVar.aiy();
                                this.cxR = i3;
                                if (this.cxH == 0 || this.cxH == 1) {
                                    Handler handler = getHandler();
                                    if (handler != null) {
                                        handler.removeCallbacks(this.cxH == 0 ? this.cxW : this.cxV);
                                    }
                                    this.cxl = 0;
                                    if (!this.aiO && this.mAdapter.isEnabled(i3)) {
                                        this.cxH = 1;
                                        setSelectedPositionInt(this.cxC);
                                        layoutChildren();
                                        childAt.setPressed(true);
                                        d(this.cxC, childAt);
                                        setPressed(true);
                                        if (this.Hm != null && (current = this.Hm.getCurrent()) != null && (current instanceof TransitionDrawable)) {
                                            ((TransitionDrawable) current).resetTransition();
                                        }
                                        if (this.cxZ != null) {
                                            removeCallbacks(this.cxZ);
                                        }
                                        this.cxZ = new com.baidu.tieba.horizonalList.widget.a(this, childAt, iVar);
                                        postDelayed(this.cxZ, ViewConfiguration.getPressedStateDuration());
                                    } else {
                                        this.cxH = -1;
                                        aid();
                                    }
                                    return true;
                                } else if (!this.aiO && this.mAdapter.isEnabled(i3)) {
                                    iVar.run();
                                }
                            }
                            this.cxH = -1;
                            aid();
                            break;
                        case 3:
                            int childCount = getChildCount();
                            if (childCount > 0) {
                                int left = getChildAt(0).getLeft();
                                int right = getChildAt(childCount - 1).getRight();
                                int i4 = this.cxw.left;
                                int width = getWidth() - this.cxw.right;
                                if (this.czm == 0 && left >= i4 && this.czm + childCount < this.czz && right <= getWidth() - width) {
                                    this.cxH = -1;
                                    jU(0);
                                    break;
                                } else {
                                    VelocityTracker velocityTracker = this.mVelocityTracker;
                                    velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                                    int xVelocity = (int) (velocityTracker.getXVelocity(this.mActivePointerId) * this.cyg);
                                    if (Math.abs(xVelocity) > this.mMinimumVelocity && ((this.czm != 0 || left != i4 - this.cyi) && (childCount + this.czm != this.czz || right != this.cyi + width))) {
                                        if (this.cxK == null) {
                                            this.cxK = new e();
                                        }
                                        jU(2);
                                        this.cxK.start(-xVelocity);
                                        break;
                                    } else {
                                        this.cxH = -1;
                                        jU(0);
                                        if (this.cxK != null) {
                                            this.cxK.air();
                                        }
                                        if (this.cxL != null) {
                                            this.cxL.stop();
                                            break;
                                        }
                                    }
                                }
                            } else {
                                this.cxH = -1;
                                jU(0);
                                break;
                            }
                            break;
                        case 5:
                            if (this.cxK == null) {
                                this.cxK = new e();
                            }
                            VelocityTracker velocityTracker2 = this.mVelocityTracker;
                            velocityTracker2.computeCurrentVelocity(1000, this.mMaximumVelocity);
                            int xVelocity2 = (int) velocityTracker2.getXVelocity(this.mActivePointerId);
                            jU(2);
                            if (Math.abs(xVelocity2) > this.mMinimumVelocity) {
                                this.cxK.jY(-xVelocity2);
                                break;
                            } else {
                                this.cxK.aiq();
                                break;
                            }
                    }
                    setPressed(false);
                    if (this.cyk != null) {
                        this.cyk.onRelease();
                        this.cyl.onRelease();
                    }
                    invalidate();
                    Handler handler2 = getHandler();
                    if (handler2 != null) {
                        handler2.removeCallbacks(this.cxV);
                    }
                    aih();
                    this.mActivePointerId = -1;
                    break;
                case 2:
                    int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                    if (findPointerIndex == -1) {
                        this.mActivePointerId = motionEvent.getPointerId(0);
                        findPointerIndex = 0;
                    }
                    int x4 = (int) motionEvent.getX(findPointerIndex);
                    if (this.aiO) {
                        layoutChildren();
                    }
                    switch (this.cxH) {
                        case 0:
                        case 1:
                        case 2:
                            jS(x4);
                            break;
                        case 3:
                        case 5:
                            jT(x4);
                            break;
                    }
                case 3:
                    switch (this.cxH) {
                        case 5:
                            if (this.cxK == null) {
                                this.cxK = new e();
                            }
                            this.cxK.aiq();
                            break;
                        case 6:
                            break;
                        default:
                            this.cxH = -1;
                            setPressed(false);
                            View childAt2 = getChildAt(this.cxC - this.czm);
                            if (childAt2 != null) {
                                childAt2.setPressed(false);
                            }
                            aij();
                            Handler handler3 = getHandler();
                            if (handler3 != null) {
                                handler3.removeCallbacks(this.cxV);
                            }
                            aih();
                            break;
                    }
                    if (this.cyk != null) {
                        this.cyk.onRelease();
                        this.cyl.onRelease();
                    }
                    this.mActivePointerId = -1;
                    break;
                case 5:
                    int actionIndex = motionEvent.getActionIndex();
                    int pointerId = motionEvent.getPointerId(actionIndex);
                    int x5 = (int) motionEvent.getX(actionIndex);
                    int y2 = (int) motionEvent.getY(actionIndex);
                    this.cxJ = 0;
                    this.mActivePointerId = pointerId;
                    this.cxF = x5;
                    this.cxG = y2;
                    int pointToPosition2 = pointToPosition(x5, y2);
                    if (pointToPosition2 >= 0) {
                        this.cxD = getChildAt(pointToPosition2 - this.czm).getLeft();
                        this.cxC = pointToPosition2;
                    }
                    this.cxI = x5;
                    break;
                case 6:
                    onSecondaryPointerUp(motionEvent);
                    int i5 = this.cxF;
                    int pointToPosition3 = pointToPosition(i5, this.cxG);
                    if (pointToPosition3 >= 0) {
                        this.cxD = getChildAt(pointToPosition3 - this.czm).getLeft();
                        this.cxC = pointToPosition3;
                    }
                    this.cxI = i5;
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
            this.cxe.setScrollX(i2);
            aie();
            awakenScrollBars();
        }
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) != 0) {
            switch (motionEvent.getAction()) {
                case 8:
                    if (this.cxH == -1) {
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
        if (this.cyz == 0.0f) {
            TypedValue typedValue = new TypedValue();
            if (getContext().getTheme().resolveAttribute(w.c.hlv_listPreferredItemWidth, typedValue, true)) {
                this.cyz = typedValue.getDimension(getContext().getResources().getDisplayMetrics());
            }
        }
        return this.cyz;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.cyk != null) {
            int scrollX = getScrollX();
            if (!this.cyk.isFinished()) {
                int save = canvas.save();
                int i2 = this.cxw.top + this.cyp;
                int height = (getHeight() - i2) - (this.cxw.bottom + this.cyq);
                int min = Math.min(0, this.cym + scrollX);
                canvas.rotate(-90.0f);
                canvas.translate(i2 + (-getHeight()), min);
                this.cyk.setSize(height, height);
                if (this.cyk.draw(canvas)) {
                    invalidate();
                }
                canvas.restoreToCount(save);
            }
            if (!this.cyl.isFinished()) {
                int save2 = canvas.save();
                int i3 = this.cxw.left + this.cyp;
                int height2 = (getHeight() - i3) - (this.cxw.right + this.cyq);
                int max = Math.max(getWidth(), scrollX + this.cyn);
                canvas.rotate(90.0f);
                canvas.translate(-i3, -max);
                this.cyl.setSize(height2, height2);
                if (this.cyl.draw(canvas)) {
                    invalidate();
                }
                canvas.restoreToCount(save2);
            }
        }
    }

    private void aif() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        } else {
            this.mVelocityTracker.clear();
        }
    }

    private void aig() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
    }

    private void aih() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            aih();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.cxL != null) {
            this.cxL.stop();
        }
        if (this.cyu) {
            switch (action & MotionEventCompat.ACTION_MASK) {
                case 0:
                    int i2 = this.cxH;
                    if (i2 == 6 || i2 == 5) {
                        this.cxJ = 0;
                        return true;
                    }
                    int x = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();
                    this.mActivePointerId = motionEvent.getPointerId(0);
                    int jW = jW(x);
                    if (i2 != 4 && jW >= 0) {
                        this.cxD = getChildAt(jW - this.czm).getLeft();
                        this.cxF = x;
                        this.cxG = y;
                        this.cxC = jW;
                        this.cxH = 0;
                        aij();
                    }
                    this.cxI = ExploreByTouchHelper.INVALID_ID;
                    aif();
                    this.mVelocityTracker.addMovement(motionEvent);
                    return i2 == 4;
                case 1:
                case 3:
                    this.cxH = -1;
                    this.mActivePointerId = -1;
                    aih();
                    jU(0);
                    return false;
                case 2:
                    switch (this.cxH) {
                        case 0:
                            int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                            if (findPointerIndex == -1) {
                                this.mActivePointerId = motionEvent.getPointerId(0);
                                findPointerIndex = 0;
                            }
                            aig();
                            this.mVelocityTracker.addMovement(motionEvent);
                            return jS((int) motionEvent.getX(findPointerIndex));
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
            this.cxF = (int) motionEvent.getX(i2);
            this.cxG = (int) motionEvent.getY(i2);
            this.cxJ = 0;
            this.mActivePointerId = motionEvent.getPointerId(i2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        int childCount = getChildCount();
        int i2 = this.czm;
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
    public void jU(int i2) {
        if (i2 != this.cyd && this.cxO != null) {
            this.cyd = i2;
            this.cxO.a(this, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e implements Runnable {
        private final com.baidu.tieba.horizonalList.widget.n cyD;
        private int cyE;
        private final Runnable cyF = new com.baidu.tieba.horizonalList.widget.c(this);

        e() {
            this.cyD = new com.baidu.tieba.horizonalList.widget.n(AbsHListView.this.getContext());
        }

        void start(int i) {
            int i2 = i < 0 ? Integer.MAX_VALUE : 0;
            this.cyE = i2;
            this.cyD.setInterpolator(null);
            this.cyD.fling(i2, 0, i, 0, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
            AbsHListView.this.cxH = 4;
            AbsHListView.this.cxe.i(this);
        }

        void aiq() {
            if (this.cyD.springBack(AbsHListView.this.getScrollX(), 0, 0, 0, 0, 0)) {
                AbsHListView.this.cxH = 6;
                AbsHListView.this.invalidate();
                AbsHListView.this.cxe.i(this);
                return;
            }
            AbsHListView.this.cxH = -1;
            AbsHListView.this.jU(0);
        }

        void jY(int i) {
            this.cyD.setInterpolator(null);
            this.cyD.fling(AbsHListView.this.getScrollX(), 0, i, 0, ExploreByTouchHelper.INVALID_ID, Integer.MAX_VALUE, 0, 0, AbsHListView.this.getWidth(), 0);
            AbsHListView.this.cxH = 6;
            AbsHListView.this.invalidate();
            AbsHListView.this.cxe.i(this);
        }

        void jZ(int i) {
            this.cyD.notifyHorizontalEdgeReached(AbsHListView.this.getScrollX(), 0, AbsHListView.this.cyj);
            int overScrollMode = AbsHListView.this.getOverScrollMode();
            if (overScrollMode == 0 || (overScrollMode == 1 && !AbsHListView.this.ahU())) {
                AbsHListView.this.cxH = 6;
                int currVelocity = (int) this.cyD.getCurrVelocity();
                if (i > 0) {
                    AbsHListView.this.cyk.onAbsorb(currVelocity);
                } else {
                    AbsHListView.this.cyl.onAbsorb(currVelocity);
                }
            } else {
                AbsHListView.this.cxH = -1;
                if (AbsHListView.this.cxL != null) {
                    AbsHListView.this.cxL.stop();
                }
            }
            AbsHListView.this.invalidate();
            AbsHListView.this.cxe.i(this);
        }

        void e(int i, int i2, boolean z) {
            int i3 = i < 0 ? Integer.MAX_VALUE : 0;
            this.cyE = i3;
            this.cyD.setInterpolator(z ? AbsHListView.cyw : null);
            this.cyD.startScroll(i3, 0, i, 0, i2);
            AbsHListView.this.cxH = 4;
            AbsHListView.this.cxe.i(this);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void air() {
            AbsHListView.this.cxH = -1;
            AbsHListView.this.removeCallbacks(this);
            AbsHListView.this.removeCallbacks(this.cyF);
            AbsHListView.this.jU(0);
            AbsHListView.this.aij();
            this.cyD.abortAnimation();
            AbsHListView.this.overScrollBy(0, 0, 0, 0, 0, 0, 0, 0, false);
        }

        void ais() {
            AbsHListView.this.postDelayed(this.cyF, 40L);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // java.lang.Runnable
        public void run() {
            int max;
            boolean z = true;
            boolean z2 = false;
            switch (AbsHListView.this.cxH) {
                case 3:
                    if (this.cyD.isFinished()) {
                        return;
                    }
                    break;
                case 4:
                    break;
                case 5:
                default:
                    air();
                    return;
                case 6:
                    com.baidu.tieba.horizonalList.widget.n nVar = this.cyD;
                    if (nVar.computeScrollOffset()) {
                        int scrollX = AbsHListView.this.getScrollX();
                        int currX = nVar.getCurrX();
                        if (AbsHListView.this.overScrollBy(currX - scrollX, 0, scrollX, 0, 0, 0, AbsHListView.this.cyj, 0, false)) {
                            boolean z3 = scrollX <= 0 && currX > 0;
                            if (scrollX >= 0 && currX < 0) {
                                z2 = true;
                            }
                            if (z3 || z2) {
                                int currVelocity = (int) nVar.getCurrVelocity();
                                if (z2) {
                                    currVelocity = -currVelocity;
                                }
                                nVar.abortAnimation();
                                start(currVelocity);
                                return;
                            }
                            aiq();
                            return;
                        }
                        AbsHListView.this.invalidate();
                        AbsHListView.this.cxe.i(this);
                        return;
                    }
                    air();
                    return;
            }
            if (AbsHListView.this.aiO) {
                AbsHListView.this.layoutChildren();
            }
            if (AbsHListView.this.czz == 0 || AbsHListView.this.getChildCount() == 0) {
                air();
                return;
            }
            com.baidu.tieba.horizonalList.widget.n nVar2 = this.cyD;
            boolean computeScrollOffset = nVar2.computeScrollOffset();
            int currX2 = nVar2.getCurrX();
            int i = this.cyE - currX2;
            if (i > 0) {
                AbsHListView.this.cxC = AbsHListView.this.czm;
                AbsHListView.this.cxD = AbsHListView.this.getChildAt(0).getLeft();
                max = Math.min(((AbsHListView.this.getWidth() - AbsHListView.this.getPaddingRight()) - AbsHListView.this.getPaddingLeft()) - 1, i);
            } else {
                int childCount = AbsHListView.this.getChildCount() - 1;
                AbsHListView.this.cxC = AbsHListView.this.czm + childCount;
                AbsHListView.this.cxD = AbsHListView.this.getChildAt(childCount).getLeft();
                max = Math.max(-(((AbsHListView.this.getWidth() - AbsHListView.this.getPaddingRight()) - AbsHListView.this.getPaddingLeft()) - 1), i);
            }
            View childAt = AbsHListView.this.getChildAt(AbsHListView.this.cxC - AbsHListView.this.czm);
            int left = childAt != null ? childAt.getLeft() : 0;
            boolean at = AbsHListView.this.at(max, max);
            if (!at || max == 0) {
                z = false;
            }
            if (z) {
                if (childAt != null) {
                    AbsHListView.this.overScrollBy(-(max - (childAt.getLeft() - left)), 0, AbsHListView.this.getScrollX(), 0, 0, 0, AbsHListView.this.cyj, 0, false);
                }
                if (computeScrollOffset) {
                    jZ(max);
                }
            } else if (computeScrollOffset && !z) {
                if (at) {
                    AbsHListView.this.invalidate();
                }
                this.cyE = currX2;
                AbsHListView.this.cxe.i(this);
            } else {
                air();
            }
        }
    }

    /* loaded from: classes.dex */
    public class j implements Runnable {
        private int cyN;
        private int cyO;
        private int cyP;
        private int cyQ;
        private final int cyR;
        private int cyS;
        private int mMode;

        j() {
            this.cyR = ViewConfiguration.get(AbsHListView.this.getContext()).getScaledFadingEdgeLength();
        }

        void start(int i) {
            stop();
            int childCount = (AbsHListView.this.getChildCount() + AbsHListView.this.czm) - 1;
            if (i < AbsHListView.this.czm) {
                this.mMode = 2;
            } else if (i > childCount) {
                this.mMode = 1;
            } else {
                w(i, -1, 200);
                return;
            }
            this.cyQ = 200;
            this.cyN = i;
            this.cyO = -1;
            this.cyP = -1;
            AbsHListView.this.cxe.i(this);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void av(int i, int i2) {
            int i3;
            stop();
            if (i2 == -1) {
                start(i);
            } else if (AbsHListView.this.aiO) {
                AbsHListView.this.cyf = new com.baidu.tieba.horizonalList.widget.d(this, i, i2);
            } else {
                int childCount = AbsHListView.this.getChildCount();
                if (childCount != 0) {
                    int i4 = AbsHListView.this.czm;
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
                        this.cyQ = 200 / i3;
                    } else {
                        this.cyQ = 200;
                    }
                    this.cyN = max;
                    this.cyO = i2;
                    this.cyP = -1;
                    AbsHListView.this.cxe.i(this);
                }
            }
        }

        void w(int i, int i2, int i3) {
            int i4 = AbsHListView.this.czm;
            int childCount = (AbsHListView.this.getChildCount() + i4) - 1;
            int i5 = AbsHListView.this.cxw.left;
            int width = AbsHListView.this.getWidth() - AbsHListView.this.cxw.right;
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
            int i2 = AbsHListView.this.czm;
            switch (this.mMode) {
                case 1:
                    int childCount = AbsHListView.this.getChildCount() - 1;
                    if (childCount >= 0) {
                        int i3 = i2 + childCount;
                        View childAt = AbsHListView.this.getChildAt(childCount);
                        AbsHListView.this.d((i3 < AbsHListView.this.czz + (-1) ? Math.max(AbsHListView.this.cxw.right, this.cyR) : AbsHListView.this.cxw.right) + (childAt.getWidth() - (width - childAt.getLeft())), this.cyQ, true);
                        this.cyP = i3;
                        if (i3 < this.cyN) {
                            AbsHListView.this.cxe.i(this);
                            return;
                        }
                        return;
                    }
                    return;
                case 2:
                    if (i2 == this.cyP) {
                        AbsHListView.this.cxe.i(this);
                        return;
                    }
                    View childAt2 = AbsHListView.this.getChildAt(0);
                    if (childAt2 != null) {
                        AbsHListView.this.d(childAt2.getLeft() - (i2 > 0 ? Math.max(this.cyR, AbsHListView.this.cxw.left) : AbsHListView.this.cxw.left), this.cyQ, true);
                        this.cyP = i2;
                        if (i2 > this.cyN) {
                            AbsHListView.this.cxe.i(this);
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    int childCount2 = AbsHListView.this.getChildCount();
                    if (i2 != this.cyO && childCount2 > 1 && childCount2 + i2 < AbsHListView.this.czz) {
                        int i4 = i2 + 1;
                        if (i4 == this.cyP) {
                            AbsHListView.this.cxe.i(this);
                            return;
                        }
                        View childAt3 = AbsHListView.this.getChildAt(1);
                        int width2 = childAt3.getWidth();
                        int left2 = childAt3.getLeft();
                        int max = Math.max(AbsHListView.this.cxw.right, this.cyR);
                        if (i4 < this.cyO) {
                            AbsHListView.this.d(Math.max(0, (left2 + width2) - max), this.cyQ, true);
                            this.cyP = i4;
                            AbsHListView.this.cxe.i(this);
                            return;
                        } else if (left2 > max) {
                            AbsHListView.this.d(left2 - max, this.cyQ, true);
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
                        if (i5 == this.cyP) {
                            AbsHListView.this.cxe.i(this);
                            return;
                        }
                        View childAt4 = AbsHListView.this.getChildAt(childCount3);
                        int width3 = childAt4.getWidth();
                        int left3 = childAt4.getLeft();
                        int i6 = width - left3;
                        int max2 = Math.max(AbsHListView.this.cxw.left, this.cyR);
                        this.cyP = i5;
                        if (i5 > this.cyO) {
                            AbsHListView.this.d(-(i6 - max2), this.cyQ, true);
                            AbsHListView.this.cxe.i(this);
                            return;
                        }
                        int i7 = width - max2;
                        int i8 = left3 + width3;
                        if (i7 > i8) {
                            AbsHListView.this.d(-(i7 - i8), this.cyQ, true);
                            return;
                        }
                        return;
                    }
                    return;
                case 5:
                    if (this.cyP == i2) {
                        AbsHListView.this.cxe.i(this);
                        return;
                    }
                    this.cyP = i2;
                    int childCount4 = AbsHListView.this.getChildCount();
                    int i9 = this.cyN;
                    int i10 = (i2 + childCount4) - 1;
                    if (i9 < i2) {
                        i = (i2 - i9) + 1;
                    } else if (i9 > i10) {
                        i = i9 - i10;
                    }
                    float min = Math.min(Math.abs(i / childCount4), 1.0f);
                    if (i9 < i2) {
                        AbsHListView.this.d((int) ((-AbsHListView.this.getWidth()) * min), (int) (min * this.cyQ), true);
                        AbsHListView.this.cxe.i(this);
                        return;
                    } else if (i9 > i10) {
                        AbsHListView.this.d((int) (AbsHListView.this.getWidth() * min), (int) (min * this.cyQ), true);
                        AbsHListView.this.cxe.i(this);
                        return;
                    } else {
                        AbsHListView.this.d(AbsHListView.this.getChildAt(i9 - i2).getLeft() - this.cyS, (int) (this.cyQ * (Math.abs(left) / AbsHListView.this.getWidth())), true);
                        return;
                    }
                default:
                    return;
            }
        }
    }

    public void setFriction(float f2) {
        if (this.cxK == null) {
            this.cxK = new e();
        }
        this.cxK.cyD.setFriction(f2);
    }

    public void setVelocityScale(float f2) {
        this.cyg = f2;
    }

    public void smoothScrollToPosition(int i2, int i3) {
        if (this.cxL == null) {
            this.cxL = new j();
        }
        this.cxL.av(i2, i3);
    }

    public void smoothScrollBy(int i2, int i3) {
        d(i2, i3, false);
    }

    public void d(int i2, int i3, boolean z) {
        if (this.cxK == null) {
            this.cxK = new e();
        }
        int i4 = this.czm;
        int childCount = getChildCount();
        int i5 = i4 + childCount;
        int paddingLeft = getPaddingLeft();
        int width = getWidth() - getPaddingRight();
        if (i2 == 0 || this.czz == 0 || childCount == 0 || ((i4 == 0 && getChildAt(0).getLeft() == paddingLeft && i2 < 0) || (i5 == this.czz && getChildAt(childCount - 1).getRight() == width && i2 > 0))) {
            this.cxK.air();
            if (this.cxL != null) {
                this.cxL.stop();
                return;
            }
            return;
        }
        jU(2);
        this.cxK.e(i2, i3, z);
    }

    private void aii() {
        if (this.mScrollingCacheEnabled && !this.cxA && !this.cxe.isHardwareAccelerated()) {
            setChildrenDrawnWithCacheEnabled(true);
            setChildrenDrawingCacheEnabled(true);
            this.cxB = true;
            this.cxA = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aij() {
        if (!this.cxe.isHardwareAccelerated()) {
            if (this.cye == null) {
                this.cye = new com.baidu.tieba.horizonalList.widget.b(this);
            }
            post(this.cye);
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
        Rect rect = this.cxw;
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
        int i6 = this.czm;
        if (i6 == 0) {
            this.cym = left - rect.left;
        } else {
            this.cym += min2;
        }
        if (i6 + childCount == this.czz) {
            this.cyn = rect.right + right;
        } else {
            this.cyn += min2;
        }
        boolean z = i6 == 0 && left >= rect.left && min2 >= 0;
        boolean z2 = i6 + childCount == this.czz && right <= getWidth() - rect.right && min2 <= 0;
        if (z || z2) {
            return min2 != 0;
        }
        boolean z3 = min2 < 0;
        boolean isInTouchMode = isInTouchMode();
        if (isInTouchMode) {
            aik();
        }
        int headerViewsCount = getHeaderViewsCount();
        int footerViewsCount = this.czz - getFooterViewsCount();
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
                    this.cxr.q(childAt, i11);
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
                    this.cxr.q(childAt2, i14);
                }
                i4 = i13;
                i7 = i12;
            }
        }
        this.cxE = this.cxD + min;
        this.czH = true;
        if (i4 > 0) {
            detachViewsFromParent(i7, i4);
            this.cxr.aiv();
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        jV(min2);
        if (z3) {
            this.czm = i4 + this.czm;
        }
        int abs = Math.abs(min2);
        if (i5 < abs || width < abs) {
            eN(z3);
        }
        if (!isInTouchMode && this.ciA != -1) {
            int i15 = this.ciA - this.czm;
            if (i15 >= 0 && i15 < getChildCount()) {
                d(this.ciA, getChildAt(i15));
            }
        } else if (this.cxp != -1) {
            int i16 = this.cxp - this.czm;
            if (i16 >= 0 && i16 < getChildCount()) {
                d(-1, getChildAt(i16));
            }
        } else {
            this.cxq.setEmpty();
        }
        this.czH = false;
        ahV();
        return false;
    }

    public void jV(int i2) {
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
    public void aik() {
        if (this.ciA != -1) {
            if (this.cxl != 4) {
                this.cxR = this.ciA;
            }
            if (this.czw >= 0 && this.czw != this.ciA) {
                this.cxR = this.czw;
            }
            setSelectedPositionInt(-1);
            setNextSelectedPositionInt(-1);
            this.cxM = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int ail() {
        int i2 = this.ciA;
        if (i2 < 0) {
            i2 = this.cxR;
        }
        return Math.min(Math.max(0, i2), this.czz - 1);
    }

    protected int jX(int i2) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return -1;
        }
        int jW = jW(i2);
        return jW == -1 ? (this.czm + childCount) - 1 : jW;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aim() {
        if (this.ciA >= 0 || !ain()) {
            return false;
        }
        aid();
        return true;
    }

    boolean ain() {
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
        int i8 = this.cxw.left;
        int right = (getRight() - getLeft()) - this.cxw.right;
        int i9 = this.czm;
        int i10 = this.cxR;
        if (i10 >= i9 && i10 < i9 + childCount) {
            View childAt = getChildAt(i10 - this.czm);
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
            int i15 = this.czz;
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
        this.cxR = -1;
        removeCallbacks(this.cxK);
        if (this.cxL != null) {
            this.cxL.stop();
        }
        this.cxH = -1;
        aij();
        this.czn = i2;
        int p = p(i3, z);
        if (p < i9 || p > getLastVisiblePosition()) {
            p = -1;
        } else {
            this.cxl = 4;
            aid();
            setSelectionInt(p);
            ahV();
        }
        jU(0);
        return p >= 0;
    }

    void aio() {
        int i2;
        boolean z;
        boolean z2;
        this.cxj.clear();
        int i3 = 0;
        boolean z3 = false;
        while (i3 < this.cxk.size()) {
            long keyAt = this.cxk.keyAt(i3);
            int intValue = this.cxk.valueAt(i3).intValue();
            if (keyAt != this.mAdapter.getItemId(intValue)) {
                int max = Math.max(0, intValue - 20);
                int min = Math.min(intValue + 20, this.czz);
                while (true) {
                    if (max >= min) {
                        z2 = false;
                        break;
                    } else if (keyAt != this.mAdapter.getItemId(max)) {
                        max++;
                    } else {
                        this.cxj.put(max, true);
                        this.cxk.setValueAt(i3, Integer.valueOf(max));
                        z2 = true;
                        break;
                    }
                }
                if (!z2) {
                    this.cxk.delete(keyAt);
                    int i4 = i3 - 1;
                    this.cxi--;
                    if (Build.VERSION.SDK_INT <= 11 || this.cxg == null || this.cxh == null) {
                        i2 = i4;
                        z = true;
                    } else {
                        ((com.baidu.tieba.horizonalList.a.a.b) this.cxh).onItemCheckedStateChanged((ActionMode) this.cxg, intValue, keyAt, false);
                        i2 = i4;
                        z = true;
                    }
                    z3 = z;
                    i3 = i2 + 1;
                }
            } else {
                this.cxj.put(intValue, true);
            }
            i2 = i3;
            z = z3;
            z3 = z;
            i3 = i2 + 1;
        }
        if (z3 && this.cxg != null && Build.VERSION.SDK_INT > 11) {
            ((ActionMode) this.cxg).invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.f
    public void handleDataChanged() {
        int i2 = this.czz;
        int i3 = this.cyv;
        this.cyv = this.czz;
        if (this.cxf != 0 && this.mAdapter != null && this.mAdapter.hasStableIds()) {
            aio();
        }
        this.cxr.aiu();
        if (i2 > 0) {
            if (this.czr) {
                this.czr = false;
                this.cyx = null;
                if (this.cya == 2) {
                    this.cxl = 3;
                    return;
                }
                if (this.cya == 1) {
                    if (this.cyo) {
                        this.cyo = false;
                        this.cxl = 3;
                        return;
                    }
                    int childCount = getChildCount();
                    int width = getWidth() - getPaddingRight();
                    View childAt = getChildAt(childCount - 1);
                    int bottom = childAt != null ? childAt.getBottom() : width;
                    if (childCount + this.czm >= i3 && bottom <= width) {
                        this.cxl = 3;
                        return;
                    }
                    awakenScrollBars();
                }
                switch (this.czs) {
                    case 1:
                        this.cxl = 5;
                        this.czo = Math.min(Math.max(0, this.czo), i2 - 1);
                        return;
                    case 0:
                        if (isInTouchMode()) {
                            this.cxl = 5;
                            this.czo = Math.min(Math.max(0, this.czo), i2 - 1);
                            return;
                        }
                        int aiG = aiG();
                        if (aiG >= 0 && p(aiG, true) == aiG) {
                            this.czo = aiG;
                            if (this.czq == getWidth()) {
                                this.cxl = 5;
                            } else {
                                this.cxl = 2;
                            }
                            setNextSelectedPositionInt(aiG);
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
                int p = p(selectedItemPosition, true);
                if (p >= 0) {
                    setNextSelectedPositionInt(p);
                    return;
                }
                int p2 = p(selectedItemPosition, false);
                if (p2 >= 0) {
                    setNextSelectedPositionInt(p2);
                    return;
                }
            } else if (this.cxR >= 0) {
                return;
            }
        }
        this.cxl = this.cxN ? 3 : 1;
        this.ciA = -1;
        this.czy = Long.MIN_VALUE;
        this.czw = -1;
        this.czx = Long.MIN_VALUE;
        this.czr = false;
        this.cyx = null;
        this.cxp = -1;
        aiF();
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
        this.cya = i2;
    }

    public int getTranscriptMode() {
        return this.cya;
    }

    @Override // android.view.View
    public int getSolidColor() {
        return this.cyb;
    }

    public void setCacheColorHint(int i2) {
        if (i2 != this.cyb) {
            this.cyb = i2;
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                getChildAt(i3).setDrawingCacheBackgroundColor(i2);
            }
            this.cxr.setCacheColorHint(i2);
        }
    }

    @ViewDebug.ExportedProperty(category = "drawing")
    public int getCacheColorHint() {
        return this.cyb;
    }

    private void aip() {
        if (this.cyk != null) {
            this.cyk.finish();
            this.cyl.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void au(int i2, int i3) {
    }

    public void setRecyclerListener(l lVar) {
        this.cxr.cyV = lVar;
    }

    /* loaded from: classes.dex */
    public class a extends com.baidu.tieba.horizonalList.widget.f<ListAdapter>.b {
        public a() {
            super();
        }

        @Override // com.baidu.tieba.horizonalList.widget.f.b, android.database.DataSetObserver
        public void onChanged() {
            super.onChanged();
        }

        @Override // com.baidu.tieba.horizonalList.widget.f.b, android.database.DataSetObserver
        public void onInvalidated() {
            super.onInvalidated();
        }
    }

    /* loaded from: classes.dex */
    public static class f extends ViewGroup.LayoutParams {
        public int cyH;
        public boolean cyI;
        public boolean cyJ;
        public int cyK;
        public long cyL;

        public f(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.cyL = -1L;
        }

        public f(int i, int i2) {
            super(i, i2);
            this.cyL = -1L;
        }

        public f(int i, int i2, int i3) {
            super(i, i2);
            this.cyL = -1L;
            this.cyH = i3;
        }

        public f(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.cyL = -1L;
        }
    }

    /* loaded from: classes.dex */
    public class k {
        private l cyV;
        private int cyW;
        private View[] cyX = new View[0];
        private ArrayList<View>[] cyY;
        private int cyZ;
        private ArrayList<View> cza;
        private ArrayList<View> czb;
        private SparseArrayCompat<View> czc;

        public k() {
        }

        public void ka(int i) {
            if (i < 1) {
                throw new IllegalArgumentException("Can't have a viewTypeCount < 1");
            }
            ArrayList<View>[] arrayListArr = new ArrayList[i];
            for (int i2 = 0; i2 < i; i2++) {
                arrayListArr[i2] = new ArrayList<>();
            }
            this.cyZ = i;
            this.cza = arrayListArr[0];
            this.cyY = arrayListArr;
        }

        public void ait() {
            if (this.cyZ == 1) {
                ArrayList<View> arrayList = this.cza;
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    arrayList.get(i).forceLayout();
                }
            } else {
                int i2 = this.cyZ;
                for (int i3 = 0; i3 < i2; i3++) {
                    ArrayList<View> arrayList2 = this.cyY[i3];
                    int size2 = arrayList2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        arrayList2.get(i4).forceLayout();
                    }
                }
            }
            if (this.czc != null) {
                int size3 = this.czc.size();
                for (int i5 = 0; i5 < size3; i5++) {
                    this.czc.valueAt(i5).forceLayout();
                }
            }
        }

        public boolean kb(int i) {
            return i >= 0;
        }

        public void clear() {
            if (this.cyZ == 1) {
                ArrayList<View> arrayList = this.cza;
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    AbsHListView.this.removeDetachedView(arrayList.remove((size - 1) - i), false);
                }
            } else {
                int i2 = this.cyZ;
                for (int i3 = 0; i3 < i2; i3++) {
                    ArrayList<View> arrayList2 = this.cyY[i3];
                    int size2 = arrayList2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        AbsHListView.this.removeDetachedView(arrayList2.remove((size2 - 1) - i4), false);
                    }
                }
            }
            if (this.czc != null) {
                this.czc.clear();
            }
        }

        public void aw(int i, int i2) {
            if (this.cyX.length < i) {
                this.cyX = new View[i];
            }
            this.cyW = i2;
            View[] viewArr = this.cyX;
            for (int i3 = 0; i3 < i; i3++) {
                View childAt = AbsHListView.this.getChildAt(i3);
                f fVar = (f) childAt.getLayoutParams();
                if (fVar != null && fVar.cyH != -2) {
                    viewArr[i3] = childAt;
                }
            }
        }

        public View kc(int i) {
            int i2 = i - this.cyW;
            View[] viewArr = this.cyX;
            if (i2 < 0 || i2 >= viewArr.length) {
                return null;
            }
            View view = viewArr[i2];
            viewArr[i2] = null;
            return view;
        }

        View kd(int i) {
            int indexOfKey;
            if (this.czc != null && (indexOfKey = this.czc.indexOfKey(i)) >= 0) {
                View valueAt = this.czc.valueAt(indexOfKey);
                this.czc.removeAt(indexOfKey);
                return valueAt;
            }
            return null;
        }

        void aiu() {
            if (this.czc != null) {
                this.czc.clear();
            }
        }

        View ke(int i) {
            if (this.cyZ == 1) {
                return AbsHListView.a(this.cza, i);
            }
            int itemViewType = AbsHListView.this.mAdapter.getItemViewType(i);
            if (itemViewType >= 0 && itemViewType < this.cyY.length) {
                return AbsHListView.a(this.cyY[itemViewType], i);
            }
            return null;
        }

        public void q(View view, int i) {
            f fVar = (f) view.getLayoutParams();
            if (fVar != null) {
                fVar.cyK = i;
                int i2 = fVar.cyH;
                if (!kb(i2)) {
                    if (i2 != -2) {
                        if (this.czb == null) {
                            this.czb = new ArrayList<>();
                        }
                        this.czb.add(view);
                        return;
                    }
                    return;
                }
                view.onStartTemporaryDetach();
                if (this.cyZ == 1) {
                    this.cza.add(view);
                } else {
                    this.cyY[i2].add(view);
                }
                if (Build.VERSION.SDK_INT >= 14) {
                    view.setAccessibilityDelegate(null);
                }
                if (this.cyV != null) {
                    this.cyV.onMovedToScrapHeap(view);
                }
            }
        }

        public void aiv() {
            if (this.czb != null) {
                int size = this.czb.size();
                for (int i = 0; i < size; i++) {
                    AbsHListView.this.removeDetachedView(this.czb.get(i), false);
                }
                this.czb.clear();
            }
        }

        public void aiw() {
            View[] viewArr = this.cyX;
            boolean z = this.cyV != null;
            boolean z2 = this.cyZ > 1;
            ArrayList<View> arrayList = this.cza;
            for (int length = viewArr.length - 1; length >= 0; length--) {
                View view = viewArr[length];
                if (view != null) {
                    f fVar = (f) view.getLayoutParams();
                    int i = fVar.cyH;
                    viewArr[length] = null;
                    if (!kb(i)) {
                        if (i != -2) {
                            AbsHListView.this.removeDetachedView(view, false);
                        }
                    } else {
                        if (z2) {
                            arrayList = this.cyY[i];
                        }
                        view.onStartTemporaryDetach();
                        fVar.cyK = this.cyW + length;
                        arrayList.add(view);
                        if (Build.VERSION.SDK_INT >= 14) {
                            view.setAccessibilityDelegate(null);
                        }
                        if (z) {
                            this.cyV.onMovedToScrapHeap(view);
                        }
                    }
                }
            }
            aix();
        }

        private void aix() {
            int length = this.cyX.length;
            int i = this.cyZ;
            ArrayList<View>[] arrayListArr = this.cyY;
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
            if (this.czc != null) {
                for (int i6 = 0; i6 < this.czc.size(); i6++) {
                    this.czc.valueAt(i6);
                }
            }
        }

        void setCacheColorHint(int i) {
            View[] viewArr;
            if (this.cyZ == 1) {
                ArrayList<View> arrayList = this.cza;
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    arrayList.get(i2).setDrawingCacheBackgroundColor(i);
                }
            } else {
                int i3 = this.cyZ;
                for (int i4 = 0; i4 < i3; i4++) {
                    ArrayList<View> arrayList2 = this.cyY[i4];
                    int size2 = arrayList2.size();
                    for (int i5 = 0; i5 < size2; i5++) {
                        arrayList2.get(i5).setDrawingCacheBackgroundColor(i);
                    }
                }
            }
            for (View view : this.cyX) {
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
                if (((f) view.getLayoutParams()).cyK == i2) {
                    arrayList.remove(i3);
                    return view;
                }
            }
            return arrayList.remove(size - 1);
        }
        return null;
    }
}
