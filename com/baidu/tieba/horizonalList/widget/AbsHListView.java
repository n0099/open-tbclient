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
import com.baidu.tieba.u;
import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class AbsHListView extends com.baidu.tieba.horizonalList.widget.g<ListAdapter> implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnTouchModeChangeListener {
    static final Interpolator cye = new LinearInterpolator();
    public static final int[] cyg = new int[1];
    a.AbstractC0062a cwN;
    protected int cwO;
    public Object cwP;
    Object cwQ;
    int cwR;
    protected SparseArrayCompat<Boolean> cwS;
    LongSparseArray<Integer> cwT;
    protected int cwU;
    protected a cwV;
    boolean cwW;
    boolean cwX;
    int cwY;
    protected Rect cwZ;
    private ContextMenu.ContextMenuInfo cxA;
    protected int cxB;
    private int cxC;
    private c cxD;
    private Runnable cxE;
    private b cxF;
    private i cxG;
    private Runnable cxH;
    private int cxI;
    private int cxJ;
    private boolean cxK;
    private int cxL;
    private Runnable cxM;
    protected Runnable cxN;
    private float cxO;
    protected final boolean[] cxP;
    int cxQ;
    int cxR;
    private EdgeEffectCompat cxS;
    private EdgeEffectCompat cxT;
    private int cxU;
    private int cxV;
    private boolean cxW;
    private int cxX;
    private int cxY;
    private g cxZ;
    protected final k cxa;
    int cxb;
    int cxc;
    int cxd;
    int cxe;
    protected Rect cxf;
    protected int cxg;
    View cxh;
    View cxi;
    protected boolean cxj;
    protected boolean cxk;
    protected int cxl;
    int cxm;
    int cxn;
    int cxo;
    int cxp;
    int cxq;
    int cxr;
    private e cxs;
    protected j cxt;
    protected int cxu;
    protected boolean cxv;
    private h cxw;
    private boolean cxx;
    private Rect cxy;
    protected int cxz;
    private int cya;
    private int cyb;
    protected boolean cyc;
    private int cyd;
    private SavedState cyf;
    private float cyh;
    private int mActivePointerId;
    protected ListAdapter mAdapter;
    private int mDirection;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    boolean mScrollingCacheEnabled;
    protected int mTouchMode;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    Drawable yt;

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

    protected abstract void eJ(boolean z);

    protected abstract int jK(int i2);

    public abstract void setSelectionInt(int i2);

    public AbsHListView(Context context) {
        super(context);
        this.cwO = 0;
        this.cwU = 0;
        this.cwX = false;
        this.cwY = -1;
        this.cwZ = new Rect();
        this.cxa = new k();
        this.cxb = 0;
        this.cxc = 0;
        this.cxd = 0;
        this.cxe = 0;
        this.cxf = new Rect();
        this.cxg = 0;
        this.mTouchMode = -1;
        this.cxu = 0;
        this.cxx = true;
        this.cxz = -1;
        this.cxA = null;
        this.cxC = -1;
        this.cxL = 0;
        this.cxO = 1.0f;
        this.cxP = new boolean[1];
        this.mActivePointerId = -1;
        this.mDirection = 0;
        aiq();
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
        this.cwO = 0;
        this.cwU = 0;
        this.cwX = false;
        this.cwY = -1;
        this.cwZ = new Rect();
        this.cxa = new k();
        this.cxb = 0;
        this.cxc = 0;
        this.cxd = 0;
        this.cxe = 0;
        this.cxf = new Rect();
        this.cxg = 0;
        this.mTouchMode = -1;
        this.cxu = 0;
        this.cxx = true;
        this.cxz = -1;
        this.cxA = null;
        this.cxC = -1;
        this.cxL = 0;
        this.cxO = 1.0f;
        this.cxP = new boolean[1];
        this.mActivePointerId = -1;
        this.mDirection = 0;
        aiq();
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
        this.cwX = z3;
        setStackFromRight(z2);
        setScrollingCacheEnabled(z);
        setTranscriptMode(i3);
        setCacheColorHint(i4);
        setSmoothScrollbarEnabled(z4);
        setChoiceMode(i5);
    }

    private void aiq() {
        setClickable(true);
        setFocusableInTouchMode(true);
        setWillNotDraw(false);
        setAlwaysDrawnWithCacheEnabled(false);
        setScrollingCacheEnabled(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.cxQ = viewConfiguration.getScaledOverscrollDistance();
        this.cxR = viewConfiguration.getScaledOverflingDistance();
        this.cwN = com.baidu.tieba.horizonalList.a.a.av(this);
    }

    @Override // android.view.View
    public void setOverScrollMode(int i2) {
        if (i2 != 2) {
            if (this.cxS == null) {
                Context context = getContext();
                this.cxS = new EdgeEffectCompat(context);
                this.cxT = new EdgeEffectCompat(context);
            }
        } else {
            this.cxS = null;
            this.cxT = null;
        }
        super.setOverScrollMode(i2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.horizonalList.widget.g
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            this.cwW = this.mAdapter.hasStableIds();
            if (this.cwO != 0 && this.cwW && this.cwT == null) {
                this.cwT = new LongSparseArray<>();
            }
        }
        if (this.cwS != null) {
            this.cwS.clear();
        }
        if (this.cwT != null) {
            this.cwT.clear();
        }
    }

    public int getCheckedItemCount() {
        return this.cwR;
    }

    public boolean isItemChecked(int i2) {
        if (this.cwO == 0 || this.cwS == null) {
            return false;
        }
        return this.cwS.get(i2, false).booleanValue();
    }

    public int getCheckedItemPosition() {
        if (this.cwO == 1 && this.cwS != null && this.cwS.size() == 1) {
            return this.cwS.keyAt(0);
        }
        return -1;
    }

    public SparseArrayCompat<Boolean> getCheckedItemPositions() {
        if (this.cwO != 0) {
            return this.cwS;
        }
        return null;
    }

    public long[] getCheckedItemIds() {
        if (this.cwO == 0 || this.cwT == null || this.mAdapter == null) {
            return new long[0];
        }
        LongSparseArray<Integer> longSparseArray = this.cwT;
        int size = longSparseArray.size();
        long[] jArr = new long[size];
        for (int i2 = 0; i2 < size; i2++) {
            jArr[i2] = longSparseArray.keyAt(i2);
        }
        return jArr;
    }

    public void clearChoices() {
        if (this.cwS != null) {
            this.cwS.clear();
        }
        if (this.cwT != null) {
            this.cwT.clear();
        }
        this.cwR = 0;
    }

    public void setItemChecked(int i2, boolean z) {
        if (this.cwO != 0) {
            if (Build.VERSION.SDK_INT >= 11 && z && this.cwO == 3 && this.cwP == null) {
                if (this.cwQ == null || !((com.baidu.tieba.horizonalList.a.a.b) this.cwQ).aip()) {
                    throw new IllegalStateException("AbsListView: attempted to start selection mode for CHOICE_MODE_MULTIPLE_MODAL but no choice mode callback was supplied. Call setMultiChoiceModeListener to set a callback.");
                }
                this.cwP = startActionMode((com.baidu.tieba.horizonalList.a.a.b) this.cwQ);
            }
            if (this.cwO == 2 || (Build.VERSION.SDK_INT >= 11 && this.cwO == 3)) {
                boolean booleanValue = this.cwS.get(i2, false).booleanValue();
                this.cwS.put(i2, Boolean.valueOf(z));
                if (this.cwT != null && this.mAdapter.hasStableIds()) {
                    if (z) {
                        this.cwT.put(this.mAdapter.getItemId(i2), Integer.valueOf(i2));
                    } else {
                        this.cwT.delete(this.mAdapter.getItemId(i2));
                    }
                }
                if (booleanValue != z) {
                    if (z) {
                        this.cwR++;
                    } else {
                        this.cwR--;
                    }
                }
                if (this.cwP != null) {
                    ((com.baidu.tieba.horizonalList.a.a.b) this.cwQ).onItemCheckedStateChanged((ActionMode) this.cwP, i2, this.mAdapter.getItemId(i2), z);
                }
            } else {
                boolean z2 = this.cwT != null && this.mAdapter.hasStableIds();
                if (z || isItemChecked(i2)) {
                    this.cwS.clear();
                    if (z2) {
                        this.cwT.clear();
                    }
                }
                if (z) {
                    this.cwS.put(i2, true);
                    if (z2) {
                        this.cwT.put(this.mAdapter.getItemId(i2), Integer.valueOf(i2));
                    }
                    this.cwR = 1;
                } else if (this.cwS.size() == 0 || !this.cwS.valueAt(0).booleanValue()) {
                    this.cwR = 0;
                }
            }
            if (!this.mInLayout && !this.czo) {
                this.abK = true;
                ajf();
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
        if (this.cwO != 0) {
            if (this.cwO == 2 || (Build.VERSION.SDK_INT >= 11 && this.cwO == 3 && this.cwP != null)) {
                boolean z5 = !this.cwS.get(i2, false).booleanValue();
                this.cwS.put(i2, Boolean.valueOf(z5));
                if (this.cwT != null && this.mAdapter.hasStableIds()) {
                    if (z5) {
                        this.cwT.put(this.mAdapter.getItemId(i2), Integer.valueOf(i2));
                    } else {
                        this.cwT.delete(this.mAdapter.getItemId(i2));
                    }
                }
                if (z5) {
                    this.cwR++;
                } else {
                    this.cwR--;
                }
                if (this.cwP != null) {
                    ((com.baidu.tieba.horizonalList.a.a.b) this.cwQ).onItemCheckedStateChanged((ActionMode) this.cwP, i2, j2, z5);
                } else {
                    z4 = true;
                }
                z2 = z4;
                z4 = true;
            } else if (this.cwO == 1) {
                if (!this.cwS.get(i2, false).booleanValue()) {
                    this.cwS.clear();
                    this.cwS.put(i2, true);
                    if (this.cwT != null && this.mAdapter.hasStableIds()) {
                        this.cwT.clear();
                        this.cwT.put(this.mAdapter.getItemId(i2), Integer.valueOf(i2));
                    }
                    this.cwR = 1;
                } else if (this.cwS.size() == 0 || !this.cwS.valueAt(0).booleanValue()) {
                    this.cwR = 0;
                }
                z4 = true;
                z2 = true;
            } else {
                z2 = true;
            }
            if (z4) {
                air();
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

    private void air() {
        int i2 = this.bml;
        int childCount = getChildCount();
        boolean z = Build.VERSION.SDK_INT >= 11;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            int i4 = i2 + i3;
            if (childAt instanceof Checkable) {
                ((Checkable) childAt).setChecked(this.cwS.get(i4, false).booleanValue());
            } else if (z) {
                childAt.setActivated(this.cwS.get(i4, false).booleanValue());
            }
        }
    }

    public int getChoiceMode() {
        return this.cwO;
    }

    public void setChoiceMode(int i2) {
        this.cwO = i2;
        if (Build.VERSION.SDK_INT >= 11 && this.cwP != null) {
            if (Build.VERSION.SDK_INT >= 11) {
                ((ActionMode) this.cwP).finish();
            }
            this.cwP = null;
        }
        if (this.cwO != 0) {
            if (this.cwS == null) {
                this.cwS = new SparseArrayCompat<>();
            }
            if (this.cwT == null && this.mAdapter != null && this.mAdapter.hasStableIds()) {
                this.cwT = new LongSparseArray<>();
            }
            if (Build.VERSION.SDK_INT >= 11 && this.cwO == 3) {
                clearChoices();
                setLongClickable(true);
            }
        }
    }

    public void setMultiChoiceModeListener(com.baidu.tieba.horizonalList.a.a.a aVar) {
        if (Build.VERSION.SDK_INT >= 11) {
            if (this.cwQ == null) {
                this.cwQ = new com.baidu.tieba.horizonalList.a.a.b(this);
            }
            ((com.baidu.tieba.horizonalList.a.a.b) this.cwQ).a(aVar);
            return;
        }
        Log.e("AbsListView", "setMultiChoiceModeListener not supported for this version of Android");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ais() {
        int childCount = getChildCount();
        if (childCount == 0) {
            return true;
        }
        if (childCount != this.czg) {
            return false;
        }
        return getChildAt(0).getLeft() >= this.cxf.left && getChildAt(childCount + (-1)).getRight() <= getWidth() - this.cxf.right;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public int getHorizontalScrollbarHeight() {
        return super.getHorizontalScrollbarHeight();
    }

    public void setSmoothScrollbarEnabled(boolean z) {
        this.cxx = z;
    }

    public void setOnScrollListener(h hVar) {
        this.cxw = hVar;
        ait();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ait() {
        if (this.cxw != null) {
            this.cxw.a(this, this.bml, getChildCount(), this.czg);
        }
        onScrollChanged(0, 0, 0, 0);
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEvent(int i2) {
        if (i2 == 4096) {
            int firstVisiblePosition = getFirstVisiblePosition();
            int lastVisiblePosition = getLastVisiblePosition();
            if (this.cya != firstVisiblePosition || this.cyb != lastVisiblePosition) {
                this.cya = firstVisiblePosition;
                this.cyb = lastVisiblePosition;
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
            aiH();
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

    private void aiu() {
        setSelector(getResources().getDrawable(17301602));
    }

    public void setStackFromRight(boolean z) {
        if (this.cxv != z) {
            this.cxv = z;
            aiv();
        }
    }

    void aiv() {
        if (getChildCount() > 0) {
            aiw();
            requestLayout();
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new com.baidu.tieba.horizonalList.widget.f();
        long cyL;
        long cyM;
        int cyN;
        String cyO;
        boolean cyP;
        int cyQ;
        SparseArrayCompat<Boolean> cyR;
        LongSparseArray<Integer> cyS;
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
            this.cyL = parcel.readLong();
            this.cyM = parcel.readLong();
            this.cyN = parcel.readInt();
            this.position = parcel.readInt();
            this.width = parcel.readInt();
            this.cyO = parcel.readString();
            this.cyP = parcel.readByte() != 0;
            this.cyQ = parcel.readInt();
            this.cyR = j(parcel);
            this.cyS = i(parcel);
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
            parcel.writeLong(this.cyL);
            parcel.writeLong(this.cyM);
            parcel.writeInt(this.cyN);
            parcel.writeInt(this.position);
            parcel.writeInt(this.width);
            parcel.writeString(this.cyO);
            parcel.writeByte((byte) (this.cyP ? 1 : 0));
            parcel.writeInt(this.cyQ);
            a(this.cyR, parcel);
            a(this.cyS, parcel);
        }

        public String toString() {
            return "AbsListView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " selectedId=" + this.cyL + " firstId=" + this.cyM + " viewLeft=" + this.cyN + " position=" + this.position + " width=" + this.width + " filter=" + this.cyO + " checkState=" + this.cyR + "}";
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        boolean z = true;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.cyf != null) {
            savedState.cyL = this.cyf.cyL;
            savedState.cyM = this.cyf.cyM;
            savedState.cyN = this.cyf.cyN;
            savedState.position = this.cyf.position;
            savedState.width = this.cyf.width;
            savedState.cyO = this.cyf.cyO;
            savedState.cyP = this.cyf.cyP;
            savedState.cyQ = this.cyf.cyQ;
            savedState.cyR = this.cyf.cyR;
            savedState.cyS = this.cyf.cyS;
            return savedState;
        }
        boolean z2 = getChildCount() > 0 && this.czg > 0;
        long selectedItemId = getSelectedItemId();
        savedState.cyL = selectedItemId;
        savedState.width = getWidth();
        if (selectedItemId >= 0) {
            savedState.cyN = this.cxu;
            savedState.position = getSelectedItemPosition();
            savedState.cyM = -1L;
        } else if (z2 && this.bml > 0) {
            savedState.cyN = getChildAt(0).getLeft();
            int i2 = this.bml;
            if (i2 >= this.czg) {
                i2 = this.czg - 1;
            }
            savedState.position = i2;
            savedState.cyM = this.mAdapter.getItemId(i2);
        } else {
            savedState.cyN = 0;
            savedState.cyM = -1L;
            savedState.position = 0;
        }
        savedState.cyO = null;
        savedState.cyP = (Build.VERSION.SDK_INT < 11 || this.cwO != 3 || this.cwP == null) ? false : false;
        if (this.cwS != null) {
            try {
                savedState.cyR = this.cwS.m1clone();
            } catch (NoSuchMethodError e2) {
                e2.printStackTrace();
                savedState.cyR = new SparseArrayCompat<>();
            }
        }
        if (this.cwT != null) {
            LongSparseArray<Integer> longSparseArray = new LongSparseArray<>();
            int size = this.cwT.size();
            for (int i3 = 0; i3 < size; i3++) {
                longSparseArray.put(this.cwT.keyAt(i3), this.cwT.valueAt(i3));
            }
            savedState.cyS = longSparseArray;
        }
        savedState.cyQ = this.cwR;
        return savedState;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.abK = true;
        this.cyX = savedState.width;
        if (savedState.cyL >= 0) {
            this.cyY = true;
            this.cyf = savedState;
            this.cyW = savedState.cyL;
            this.cyV = savedState.position;
            this.cyU = savedState.cyN;
            this.cyZ = 0;
        } else if (savedState.cyM >= 0) {
            setSelectedPositionInt(-1);
            setNextSelectedPositionInt(-1);
            this.cwY = -1;
            this.cyY = true;
            this.cyf = savedState;
            this.cyW = savedState.cyM;
            this.cyV = savedState.position;
            this.cyU = savedState.cyN;
            this.cyZ = 1;
        }
        if (savedState.cyR != null) {
            this.cwS = savedState.cyR;
        }
        if (savedState.cyS != null) {
            this.cwT = savedState.cyS;
        }
        this.cwR = savedState.cyQ;
        if (Build.VERSION.SDK_INT >= 11 && savedState.cyP && this.cwO == 3 && this.cwQ != null) {
            this.cwP = startActionMode((com.baidu.tieba.horizonalList.a.a.b) this.cwQ);
        }
        requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onFocusChanged(boolean z, int i2, Rect rect) {
        super.onFocusChanged(z, i2, rect);
        if (z && this.cgS < 0 && !isInTouchMode()) {
            if (!this.cyc && this.mAdapter != null) {
                this.abK = true;
                this.czh = this.czg;
                this.czg = this.mAdapter.getCount();
            }
            aiL();
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (!this.czo && !this.mInLayout) {
            super.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aiw() {
        removeAllViewsInLayout();
        this.bml = 0;
        this.abK = false;
        this.cxN = null;
        this.cyY = false;
        this.cyf = null;
        this.czj = -1;
        this.czk = Long.MIN_VALUE;
        setSelectedPositionInt(-1);
        setNextSelectedPositionInt(-1);
        this.cxu = 0;
        this.cwY = -1;
        this.cwZ.setEmpty();
        invalidate();
    }

    @Override // android.view.View
    protected int computeHorizontalScrollExtent() {
        int childCount = getChildCount();
        if (childCount > 0) {
            if (this.cxx) {
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
        int i3 = this.bml;
        int childCount = getChildCount();
        if (i3 < 0 || childCount <= 0) {
            return 0;
        }
        if (this.cxx) {
            View childAt = getChildAt(0);
            int left = childAt.getLeft();
            int width = childAt.getWidth();
            if (width > 0) {
                return Math.max(((i3 * 100) - ((left * 100) / width)) + ((int) ((getScrollX() / getWidth()) * this.czg * 100.0f)), 0);
            }
            return 0;
        }
        int i4 = this.czg;
        if (i3 != 0) {
            i2 = i3 + childCount == i4 ? i4 : (childCount / 2) + i3;
        }
        return (int) (((i2 / i4) * childCount) + i3);
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        if (this.cxx) {
            int max = Math.max(this.czg * 100, 0);
            if (getScrollX() != 0) {
                return max + Math.abs((int) ((getScrollX() / getWidth()) * this.czg * 100.0f));
            }
            return max;
        }
        return this.czg;
    }

    @Override // android.view.View
    protected float getLeftFadingEdgeStrength() {
        int childCount = getChildCount();
        float leftFadingEdgeStrength = super.getLeftFadingEdgeStrength();
        if (childCount != 0) {
            if (this.bml > 0) {
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
            if ((this.bml + childCount) - 1 < this.czg - 1) {
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
        if (this.yt == null) {
            aiu();
        }
        Rect rect = this.cxf;
        rect.left = this.cxb + getPaddingLeft();
        rect.top = this.cxc + getPaddingTop();
        rect.right = this.cxd + getPaddingRight();
        rect.bottom = this.cxe + getPaddingBottom();
        if (this.cxI == 1) {
            int childCount = getChildCount();
            int width = getWidth() - getPaddingRight();
            View childAt = getChildAt(childCount - 1);
            this.cxW = childCount + this.bml >= this.cyd && (childAt != null ? childAt.getRight() : width) <= width;
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
            this.cxa.aiR();
        }
        layoutChildren();
        this.mInLayout = false;
        this.cxB = (i4 - i2) / 3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void layoutChildren() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aix() {
        boolean z = true;
        if (this.cxh != null) {
            boolean z2 = this.bml > 0;
            if (!z2 && getChildCount() > 0) {
                z2 = getChildAt(0).getLeft() < this.cxf.left;
            }
            this.cxh.setVisibility(z2 ? 0 : 4);
        }
        if (this.cxi != null) {
            int childCount = getChildCount();
            boolean z3 = this.bml + childCount < this.czg;
            if (z3 || childCount <= 0) {
                z = z3;
            } else if (getChildAt(childCount - 1).getRight() <= getRight() - this.cxf.right) {
                z = false;
            }
            this.cxi.setVisibility(z ? 0 : 4);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.g
    @ViewDebug.ExportedProperty
    public View getSelectedView() {
        if (this.czg <= 0 || this.cgS < 0) {
            return null;
        }
        return getChildAt(this.cgS - this.bml);
    }

    public int getListPaddingTop() {
        return this.cxf.top;
    }

    public int getListPaddingBottom() {
        return this.cxf.bottom;
    }

    public int getListPaddingLeft() {
        return this.cxf.left;
    }

    public int getListPaddingRight() {
        return this.cxf.right;
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
        View jS = this.cxa.jS(i2);
        if (jS == null) {
            View jT = this.cxa.jT(i2);
            if (jT != null) {
                view = this.mAdapter.getView(i2, jT, this);
                if (view != jT) {
                    this.cxa.s(jT, i2);
                    if (this.cxJ != 0) {
                        view.setDrawingCacheBackgroundColor(this.cxJ);
                        jS = view;
                    }
                } else {
                    zArr[0] = true;
                    view.onFinishTemporaryDetach();
                    jS = view;
                }
                if (this.cwW) {
                    ViewGroup.LayoutParams layoutParams = jS.getLayoutParams();
                    if (layoutParams == null) {
                        fVar = (f) generateDefaultLayoutParams();
                    } else if (!checkLayoutParams(layoutParams)) {
                        fVar = (f) generateLayoutParams(layoutParams);
                    } else {
                        fVar = (f) layoutParams;
                    }
                    fVar.cyt = this.mAdapter.getItemId(i2);
                    jS.setLayoutParams(fVar);
                }
                if (this.czi.isEnabled() && this.cxZ == null) {
                    this.cxZ = new g();
                }
            } else {
                view = this.mAdapter.getView(i2, null, this);
                if (this.cxJ != 0) {
                    view.setDrawingCacheBackgroundColor(this.cxJ);
                }
            }
            jS = view;
            if (this.cwW) {
            }
            if (this.czi.isEnabled()) {
                this.cxZ = new g();
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
            this.cwY = i2;
        }
        Rect rect = this.cwZ;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        if (view instanceof m) {
            ((m) view).adjustListItemSelectionBounds(rect);
        }
        j(rect.left, rect.top, rect.right, rect.bottom);
        boolean z = this.cxK;
        if (view.isEnabled() != z) {
            this.cxK = !z;
            if (getSelectedItemPosition() != -1) {
                refreshDrawableState();
            }
        }
    }

    private void j(int i2, int i3, int i4, int i5) {
        this.cwZ.set(i2 - this.cxb, i3 - this.cxc, this.cxd + i4, this.cxe + i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        boolean z = this.cwX;
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
            this.abK = true;
            ajf();
        }
    }

    boolean aiy() {
        switch (this.mTouchMode) {
            case 1:
            case 2:
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aiz() {
        return (hasFocus() && !isInTouchMode()) || aiy();
    }

    private void l(Canvas canvas) {
        if (!this.cwZ.isEmpty()) {
            Drawable drawable = this.yt;
            drawable.setBounds(this.cwZ);
            drawable.draw(canvas);
        }
    }

    public void setDrawSelectorOnTop(boolean z) {
        this.cwX = z;
    }

    public void setSelector(int i2) {
        setSelector(getResources().getDrawable(i2));
    }

    public void setSelector(Drawable drawable) {
        if (this.yt != null) {
            this.yt.setCallback(null);
            unscheduleDrawable(this.yt);
        }
        this.yt = drawable;
        Rect rect = new Rect();
        drawable.getPadding(rect);
        this.cxb = rect.left;
        this.cxc = rect.top;
        this.cxd = rect.right;
        this.cxe = rect.bottom;
        drawable.setCallback(this);
        aiB();
    }

    public Drawable getSelector() {
        return this.yt;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aiA() {
        if (isEnabled() && isClickable()) {
            Drawable drawable = this.yt;
            Rect rect = this.cwZ;
            if (drawable != null) {
                if ((isFocused() || aiy()) && !rect.isEmpty()) {
                    View childAt = getChildAt(this.cgS - this.bml);
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
                    if (isLongClickable && !this.abK) {
                        if (this.cxF == null) {
                            this.cxF = new b(this, null);
                        }
                        this.cxF.aiW();
                        postDelayed(this.cxF, ViewConfiguration.getLongPressTimeout());
                    }
                }
            }
        }
    }

    void aiB() {
        if (this.yt != null) {
            if (aiz()) {
                this.yt.setState(getDrawableState());
            } else {
                this.yt.setState(cyg);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        aiB();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i2) {
        if (this.cxK) {
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
        return this.yt == drawable || super.verifyDrawable(drawable);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.yt != null) {
            this.yt.jumpToCurrentState();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnTouchModeChangeListener(this);
        if (this.mAdapter != null && this.cwV == null) {
            this.cwV = new a();
            this.mAdapter.registerDataSetObserver(this.cwV);
            this.abK = true;
            this.czh = this.czg;
            this.czg = this.mAdapter.getCount();
        }
        this.cyc = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.g, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.cxa.clear();
        getViewTreeObserver().removeOnTouchModeChangeListener(this);
        if (this.mAdapter != null && this.cwV != null) {
            this.mAdapter.unregisterDataSetObserver(this.cwV);
            this.cwV = null;
        }
        if (this.cxs != null) {
            removeCallbacks(this.cxs);
        }
        if (this.cxt != null) {
            this.cxt.stop();
        }
        if (this.cxM != null) {
            removeCallbacks(this.cxM);
        }
        if (this.cxG != null) {
            removeCallbacks(this.cxG);
        }
        if (this.cxH != null) {
            removeCallbacks(this.cxH);
            this.cxH = null;
        }
        this.cyc = false;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        int i2 = isInTouchMode() ? 0 : 1;
        if (!z) {
            setChildrenDrawingCacheEnabled(false);
            if (this.cxs != null) {
                removeCallbacks(this.cxs);
                this.cxs.aiP();
                if (this.cxt != null) {
                    this.cxt.stop();
                }
                if (getScrollX() != 0) {
                    this.cwN.setScrollX(0);
                    aiN();
                    invalidate();
                }
            }
            if (i2 == 1) {
                this.cxz = this.cgS;
            }
        } else if (i2 != this.cxC && this.cxC != -1) {
            if (i2 == 1) {
                aiL();
            } else {
                aiI();
                this.cwU = 0;
                layoutChildren();
            }
        }
        this.cxC = i2;
    }

    ContextMenu.ContextMenuInfo b(View view, int i2, long j2) {
        return new g.a(view, i2, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class n {
        private int cyT;

        private n() {
        }

        /* synthetic */ n(AbsHListView absHListView, n nVar) {
            this();
        }

        public void aiW() {
            this.cyT = AbsHListView.this.getWindowAttachCount();
        }

        public boolean aiX() {
            return AbsHListView.this.hasWindowFocus() && AbsHListView.this.getWindowAttachCount() == this.cyT;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class i extends n implements Runnable {
        int cyu;

        private i() {
            super(AbsHListView.this, null);
        }

        /* synthetic */ i(AbsHListView absHListView, i iVar) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            View childAt;
            if (!AbsHListView.this.abK) {
                ListAdapter listAdapter = AbsHListView.this.mAdapter;
                int i = this.cyu;
                if (listAdapter != null && AbsHListView.this.czg > 0 && i != -1 && i < listAdapter.getCount() && aiX() && (childAt = AbsHListView.this.getChildAt(i - AbsHListView.this.bml)) != null) {
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
            View childAt = AbsHListView.this.getChildAt(AbsHListView.this.cxl - AbsHListView.this.bml);
            if (childAt != null) {
                if ((!aiX() || AbsHListView.this.abK) ? false : AbsHListView.this.c(childAt, AbsHListView.this.cxl, AbsHListView.this.mAdapter.getItemId(AbsHListView.this.cxl))) {
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
            if (AbsHListView.this.isPressed() && AbsHListView.this.cgS >= 0) {
                View childAt = AbsHListView.this.getChildAt(AbsHListView.this.cgS - AbsHListView.this.bml);
                if (!AbsHListView.this.abK) {
                    if (aiX() ? AbsHListView.this.c(childAt, AbsHListView.this.cgS, AbsHListView.this.czf) : false) {
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
        if (Build.VERSION.SDK_INT >= 11 && this.cwO == 3) {
            if (this.cwP == null) {
                ActionMode startActionMode = startActionMode((com.baidu.tieba.horizonalList.a.a.b) this.cwQ);
                this.cwP = startActionMode;
                if (startActionMode != null) {
                    setItemChecked(i2, true);
                    performHapticFeedback(0);
                }
            }
            return true;
        }
        boolean b2 = this.czc != null ? this.czc.b(this, view, i2, j2) : false;
        if (!b2) {
            this.cxA = b(view, i2, j2);
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
        return this.cxA;
    }

    public boolean a(float f2, float f3, int i2) {
        int pointToPosition = pointToPosition((int) f2, (int) f3);
        if (pointToPosition != -1) {
            long itemId = this.mAdapter.getItemId(pointToPosition);
            View childAt = getChildAt(pointToPosition - this.bml);
            if (childAt != null) {
                this.cxA = b(childAt, pointToPosition, itemId);
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
            boolean b2 = this.czc != null ? this.czc.b(this, view, positionForView, itemId) : false;
            if (!b2) {
                this.cxA = b(getChildAt(positionForView - this.bml), positionForView, itemId);
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
                if (isClickable() && isPressed() && this.cgS >= 0 && this.mAdapter != null && this.cgS < this.mAdapter.getCount()) {
                    View childAt = getChildAt(this.cgS - this.bml);
                    if (childAt != null) {
                        performItemClick(childAt, this.cgS, this.czf);
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
        Rect rect = this.cxy;
        if (rect == null) {
            this.cxy = new Rect();
            rect = this.cxy;
        }
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt.getVisibility() == 0) {
                childAt.getHitRect(rect);
                if (rect.contains(i2, i3)) {
                    return this.bml + childCount;
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
                View childAt = AbsHListView.this.getChildAt(AbsHListView.this.cxl - AbsHListView.this.bml);
                if (childAt != null && !childAt.hasFocusable()) {
                    AbsHListView.this.cwU = 0;
                    if (!AbsHListView.this.abK) {
                        childAt.setPressed(true);
                        AbsHListView.this.setPressed(true);
                        AbsHListView.this.layoutChildren();
                        AbsHListView.this.b(AbsHListView.this.cxl, childAt);
                        AbsHListView.this.refreshDrawableState();
                        int longPressTimeout = ViewConfiguration.getLongPressTimeout();
                        boolean isLongClickable = AbsHListView.this.isLongClickable();
                        if (AbsHListView.this.yt != null && (current = AbsHListView.this.yt.getCurrent()) != null && (current instanceof TransitionDrawable)) {
                            if (isLongClickable) {
                                ((TransitionDrawable) current).startTransition(longPressTimeout);
                            } else {
                                ((TransitionDrawable) current).resetTransition();
                            }
                        }
                        if (isLongClickable) {
                            if (AbsHListView.this.cxD == null) {
                                AbsHListView.this.cxD = new c(AbsHListView.this, null);
                            }
                            AbsHListView.this.cxD.aiW();
                            AbsHListView.this.postDelayed(AbsHListView.this.cxD, longPressTimeout);
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

    private boolean jG(int i2) {
        int i3 = i2 - this.cxo;
        int abs = Math.abs(i3);
        boolean z = getScrollX() != 0;
        if (z || abs > this.mTouchSlop) {
            aiG();
            if (z) {
                this.mTouchMode = 5;
                this.cxr = 0;
            } else {
                this.mTouchMode = 3;
                this.cxr = i3 > 0 ? this.mTouchSlop : -this.mTouchSlop;
            }
            Handler handler = getHandler();
            if (handler != null) {
                handler.removeCallbacks(this.cxD);
            }
            setPressed(false);
            View childAt = getChildAt(this.cxl - this.bml);
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
        int i4 = i2 - this.cxo;
        int i5 = i4 - this.cxr;
        int i6 = this.cxq != Integer.MIN_VALUE ? i2 - this.cxq : i5;
        if (this.mTouchMode == 3) {
            if (i2 != this.cxq) {
                if (Math.abs(i4) > this.mTouchSlop && (parent = getParent()) != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
                if (this.cxl >= 0) {
                    childCount = this.cxl - this.bml;
                } else {
                    childCount = getChildCount() / 2;
                }
                View childAt = getChildAt(childCount);
                int left = childAt != null ? childAt.getLeft() : 0;
                boolean aw = i6 != 0 ? aw(i5, i6) : false;
                View childAt2 = getChildAt(childCount);
                if (childAt2 != null) {
                    int left2 = childAt2.getLeft();
                    if (aw) {
                        int i7 = (-i6) - (left2 - left);
                        overScrollBy(i7, 0, getScrollX(), 0, 0, 0, this.cxQ, 0, true);
                        if (Math.abs(this.cxQ) == Math.abs(getScrollX()) && this.mVelocityTracker != null) {
                            this.mVelocityTracker.clear();
                        }
                        int overScrollMode = getOverScrollMode();
                        if (overScrollMode == 0 || (overScrollMode == 1 && !ais())) {
                            this.mDirection = 0;
                            this.mTouchMode = 5;
                            if (i4 > 0) {
                                this.cxS.onPull(i7 / getWidth());
                                if (!this.cxT.isFinished()) {
                                    this.cxT.onRelease();
                                }
                                invalidate();
                            } else if (i4 < 0) {
                                this.cxT.onPull(i7 / getWidth());
                                if (!this.cxS.isFinished()) {
                                    this.cxS.onRelease();
                                }
                                invalidate();
                            }
                        }
                    }
                    this.cxo = i2;
                }
                this.cxq = i2;
            }
        } else if (this.mTouchMode == 5 && i2 != this.cxq) {
            int scrollX = getScrollX();
            int i8 = scrollX - i6;
            int i9 = i2 > this.cxq ? 1 : -1;
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
                overScrollBy(i10, 0, getScrollX(), 0, 0, 0, this.cxQ, 0, true);
                int overScrollMode2 = getOverScrollMode();
                if (overScrollMode2 == 0 || (overScrollMode2 == 1 && !ais())) {
                    if (i4 > 0) {
                        this.cxS.onPull(i10 / getWidth());
                        if (!this.cxT.isFinished()) {
                            this.cxT.onRelease();
                        }
                        invalidate();
                    } else if (i4 < 0) {
                        this.cxT.onPull(i10 / getWidth());
                        if (!this.cxS.isFinished()) {
                            this.cxS.onRelease();
                        }
                        invalidate();
                    }
                }
            }
            if (i3 != 0) {
                if (getScrollX() != 0) {
                    this.cwN.setScrollX(0);
                    aiC();
                }
                aw(i3, i3);
                this.mTouchMode = 3;
                int jL = jL(i2);
                this.cxr = 0;
                View childAt3 = getChildAt(jL - this.bml);
                this.cxm = childAt3 != null ? childAt3.getLeft() : 0;
                this.cxo = i2;
                this.cxl = jL;
            }
            this.cxq = i2;
            this.mDirection = i9;
        }
    }

    protected void aiC() {
        if (this.cwN.isHardwareAccelerated() && (getParent() instanceof View)) {
            ((View) getParent()).invalidate();
        }
    }

    @Override // android.view.ViewTreeObserver.OnTouchModeChangeListener
    public void onTouchModeChanged(boolean z) {
        if (z) {
            aiI();
            if (getWidth() > 0 && getChildCount() > 0) {
                layoutChildren();
            }
            aiB();
            return;
        }
        int i2 = this.mTouchMode;
        if (i2 == 5 || i2 == 6) {
            if (this.cxs != null) {
                this.cxs.aiP();
            }
            if (this.cxt != null) {
                this.cxt.stop();
            }
            if (getScrollX() != 0) {
                this.cwN.setScrollX(0);
                aiN();
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
        if (this.cxt != null) {
            this.cxt.stop();
        }
        if (this.cyc) {
            int action = motionEvent.getAction();
            aiE();
            this.mVelocityTracker.addMovement(motionEvent);
            switch (action & MotionEventCompat.ACTION_MASK) {
                case 0:
                    switch (this.mTouchMode) {
                        case 6:
                            this.cxs.aiP();
                            if (this.cxt != null) {
                                this.cxt.stop();
                            }
                            this.mTouchMode = 5;
                            this.cxp = (int) motionEvent.getY();
                            int x = (int) motionEvent.getX();
                            this.cxq = x;
                            this.cxo = x;
                            this.cxr = 0;
                            this.mActivePointerId = motionEvent.getPointerId(0);
                            this.mDirection = 0;
                            break;
                        default:
                            this.mActivePointerId = motionEvent.getPointerId(0);
                            int x2 = (int) motionEvent.getX();
                            int y = (int) motionEvent.getY();
                            int pointToPosition = pointToPosition(x2, y);
                            if (!this.abK) {
                                if (this.mTouchMode != 4 && pointToPosition >= 0 && getAdapter().isEnabled(pointToPosition)) {
                                    this.mTouchMode = 0;
                                    if (this.cxE == null) {
                                        this.cxE = new d();
                                    }
                                    postDelayed(this.cxE, ViewConfiguration.getTapTimeout());
                                    i2 = pointToPosition;
                                } else if (this.mTouchMode == 4) {
                                    aiG();
                                    this.mTouchMode = 3;
                                    this.cxr = 0;
                                    i2 = jK(x2);
                                    this.cxs.aiQ();
                                }
                                if (i2 >= 0) {
                                    this.cxm = getChildAt(i2 - this.bml).getLeft();
                                }
                                this.cxo = x2;
                                this.cxp = y;
                                this.cxl = i2;
                                this.cxq = ExploreByTouchHelper.INVALID_ID;
                                break;
                            }
                            i2 = pointToPosition;
                            if (i2 >= 0) {
                            }
                            this.cxo = x2;
                            this.cxp = y;
                            this.cxl = i2;
                            this.cxq = ExploreByTouchHelper.INVALID_ID;
                    }
                    if (h(motionEvent) && this.mTouchMode == 0) {
                        removeCallbacks(this.cxE);
                        break;
                    }
                    break;
                case 1:
                    switch (this.mTouchMode) {
                        case 0:
                        case 1:
                        case 2:
                            int i3 = this.cxl;
                            View childAt = getChildAt(i3 - this.bml);
                            float x3 = motionEvent.getX();
                            boolean z = x3 > ((float) this.cxf.left) && x3 < ((float) (getWidth() - this.cxf.right));
                            if (childAt != null && !childAt.hasFocusable() && z) {
                                if (this.mTouchMode != 0) {
                                    childAt.setPressed(false);
                                }
                                if (this.cxG == null) {
                                    this.cxG = new i(this, null);
                                }
                                i iVar = this.cxG;
                                iVar.cyu = i3;
                                iVar.aiW();
                                this.cxz = i3;
                                if (this.mTouchMode == 0 || this.mTouchMode == 1) {
                                    Handler handler = getHandler();
                                    if (handler != null) {
                                        handler.removeCallbacks(this.mTouchMode == 0 ? this.cxE : this.cxD);
                                    }
                                    this.cwU = 0;
                                    if (!this.abK && this.mAdapter.isEnabled(i3)) {
                                        this.mTouchMode = 1;
                                        setSelectedPositionInt(this.cxl);
                                        layoutChildren();
                                        childAt.setPressed(true);
                                        b(this.cxl, childAt);
                                        setPressed(true);
                                        if (this.yt != null && (current = this.yt.getCurrent()) != null && (current instanceof TransitionDrawable)) {
                                            ((TransitionDrawable) current).resetTransition();
                                        }
                                        if (this.cxH != null) {
                                            removeCallbacks(this.cxH);
                                        }
                                        this.cxH = new com.baidu.tieba.horizonalList.widget.a(this, childAt, iVar);
                                        postDelayed(this.cxH, ViewConfiguration.getPressedStateDuration());
                                    } else {
                                        this.mTouchMode = -1;
                                        aiB();
                                    }
                                    return true;
                                } else if (!this.abK && this.mAdapter.isEnabled(i3)) {
                                    iVar.run();
                                }
                            }
                            this.mTouchMode = -1;
                            aiB();
                            break;
                        case 3:
                            int childCount = getChildCount();
                            if (childCount > 0) {
                                int left = getChildAt(0).getLeft();
                                int right = getChildAt(childCount - 1).getRight();
                                int i4 = this.cxf.left;
                                int width = getWidth() - this.cxf.right;
                                if (this.bml == 0 && left >= i4 && this.bml + childCount < this.czg && right <= getWidth() - width) {
                                    this.mTouchMode = -1;
                                    jI(0);
                                    break;
                                } else {
                                    VelocityTracker velocityTracker = this.mVelocityTracker;
                                    velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                                    int xVelocity = (int) (velocityTracker.getXVelocity(this.mActivePointerId) * this.cxO);
                                    if (Math.abs(xVelocity) > this.mMinimumVelocity && ((this.bml != 0 || left != i4 - this.cxQ) && (childCount + this.bml != this.czg || right != this.cxQ + width))) {
                                        if (this.cxs == null) {
                                            this.cxs = new e();
                                        }
                                        jI(2);
                                        this.cxs.jM(-xVelocity);
                                        break;
                                    } else {
                                        this.mTouchMode = -1;
                                        jI(0);
                                        if (this.cxs != null) {
                                            this.cxs.aiP();
                                        }
                                        if (this.cxt != null) {
                                            this.cxt.stop();
                                            break;
                                        }
                                    }
                                }
                            } else {
                                this.mTouchMode = -1;
                                jI(0);
                                break;
                            }
                            break;
                        case 5:
                            if (this.cxs == null) {
                                this.cxs = new e();
                            }
                            VelocityTracker velocityTracker2 = this.mVelocityTracker;
                            velocityTracker2.computeCurrentVelocity(1000, this.mMaximumVelocity);
                            int xVelocity2 = (int) velocityTracker2.getXVelocity(this.mActivePointerId);
                            jI(2);
                            if (Math.abs(xVelocity2) > this.mMinimumVelocity) {
                                this.cxs.jN(-xVelocity2);
                                break;
                            } else {
                                this.cxs.aiO();
                                break;
                            }
                    }
                    setPressed(false);
                    if (this.cxS != null) {
                        this.cxS.onRelease();
                        this.cxT.onRelease();
                    }
                    invalidate();
                    Handler handler2 = getHandler();
                    if (handler2 != null) {
                        handler2.removeCallbacks(this.cxD);
                    }
                    aiF();
                    this.mActivePointerId = -1;
                    break;
                case 2:
                    int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                    if (findPointerIndex == -1) {
                        this.mActivePointerId = motionEvent.getPointerId(0);
                        findPointerIndex = 0;
                    }
                    int x4 = (int) motionEvent.getX(findPointerIndex);
                    if (this.abK) {
                        layoutChildren();
                    }
                    switch (this.mTouchMode) {
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
                    switch (this.mTouchMode) {
                        case 5:
                            if (this.cxs == null) {
                                this.cxs = new e();
                            }
                            this.cxs.aiO();
                            break;
                        case 6:
                            break;
                        default:
                            this.mTouchMode = -1;
                            setPressed(false);
                            View childAt2 = getChildAt(this.cxl - this.bml);
                            if (childAt2 != null) {
                                childAt2.setPressed(false);
                            }
                            aiH();
                            Handler handler3 = getHandler();
                            if (handler3 != null) {
                                handler3.removeCallbacks(this.cxD);
                            }
                            aiF();
                            break;
                    }
                    if (this.cxS != null) {
                        this.cxS.onRelease();
                        this.cxT.onRelease();
                    }
                    this.mActivePointerId = -1;
                    break;
                case 5:
                    int actionIndex = motionEvent.getActionIndex();
                    int pointerId = motionEvent.getPointerId(actionIndex);
                    int x5 = (int) motionEvent.getX(actionIndex);
                    int y2 = (int) motionEvent.getY(actionIndex);
                    this.cxr = 0;
                    this.mActivePointerId = pointerId;
                    this.cxo = x5;
                    this.cxp = y2;
                    int pointToPosition2 = pointToPosition(x5, y2);
                    if (pointToPosition2 >= 0) {
                        this.cxm = getChildAt(pointToPosition2 - this.bml).getLeft();
                        this.cxl = pointToPosition2;
                    }
                    this.cxq = x5;
                    break;
                case 6:
                    onSecondaryPointerUp(motionEvent);
                    int i5 = this.cxo;
                    int pointToPosition3 = pointToPosition(i5, this.cxp);
                    if (pointToPosition3 >= 0) {
                        this.cxm = getChildAt(pointToPosition3 - this.bml).getLeft();
                        this.cxl = pointToPosition3;
                    }
                    this.cxq = i5;
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
            this.cwN.setScrollX(i2);
            aiC();
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
                            if (!aw(horizontalScrollFactor, horizontalScrollFactor)) {
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
        if (this.cyh == 0.0f) {
            TypedValue typedValue = new TypedValue();
            if (getContext().getTheme().resolveAttribute(u.c.hlv_listPreferredItemWidth, typedValue, true)) {
                this.cyh = typedValue.getDimension(getContext().getResources().getDisplayMetrics());
            } else {
                throw new IllegalStateException("Expected theme to define hlv_listPreferredItemWidth.");
            }
        }
        return this.cyh;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.cxS != null) {
            int scrollX = getScrollX();
            if (!this.cxS.isFinished()) {
                int save = canvas.save();
                int i2 = this.cxf.top + this.cxX;
                int height = (getHeight() - i2) - (this.cxf.bottom + this.cxY);
                int min = Math.min(0, this.cxU + scrollX);
                canvas.rotate(-90.0f);
                canvas.translate(i2 + (-getHeight()), min);
                this.cxS.setSize(height, height);
                if (this.cxS.draw(canvas)) {
                    invalidate();
                }
                canvas.restoreToCount(save);
            }
            if (!this.cxT.isFinished()) {
                int save2 = canvas.save();
                int i3 = this.cxf.left + this.cxX;
                int height2 = (getHeight() - i3) - (this.cxf.right + this.cxY);
                int max = Math.max(getWidth(), scrollX + this.cxV);
                canvas.rotate(90.0f);
                canvas.translate(-i3, -max);
                this.cxT.setSize(height2, height2);
                if (this.cxT.draw(canvas)) {
                    invalidate();
                }
                canvas.restoreToCount(save2);
            }
        }
    }

    private void aiD() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        } else {
            this.mVelocityTracker.clear();
        }
    }

    private void aiE() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
    }

    private void aiF() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            aiF();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.cxt != null) {
            this.cxt.stop();
        }
        if (this.cyc) {
            switch (action & MotionEventCompat.ACTION_MASK) {
                case 0:
                    int i2 = this.mTouchMode;
                    if (i2 == 6 || i2 == 5) {
                        this.cxr = 0;
                        return true;
                    }
                    int x = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();
                    this.mActivePointerId = motionEvent.getPointerId(0);
                    int jK = jK(x);
                    if (i2 != 4 && jK >= 0) {
                        this.cxm = getChildAt(jK - this.bml).getLeft();
                        this.cxo = x;
                        this.cxp = y;
                        this.cxl = jK;
                        this.mTouchMode = 0;
                        aiH();
                    }
                    this.cxq = ExploreByTouchHelper.INVALID_ID;
                    aiD();
                    this.mVelocityTracker.addMovement(motionEvent);
                    return i2 == 4;
                case 1:
                case 3:
                    this.mTouchMode = -1;
                    this.mActivePointerId = -1;
                    aiF();
                    jI(0);
                    return false;
                case 2:
                    switch (this.mTouchMode) {
                        case 0:
                            int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                            if (findPointerIndex == -1) {
                                this.mActivePointerId = motionEvent.getPointerId(0);
                                findPointerIndex = 0;
                            }
                            aiE();
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
            this.cxo = (int) motionEvent.getX(i2);
            this.cxp = (int) motionEvent.getY(i2);
            this.cxr = 0;
            this.mActivePointerId = motionEvent.getPointerId(i2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        int childCount = getChildCount();
        int i2 = this.bml;
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
        if (i2 != this.cxL && this.cxw != null) {
            this.cxL = i2;
            this.cxw.a(this, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e implements Runnable {
        private final o cyl;
        private int cym;
        private final Runnable cyn = new com.baidu.tieba.horizonalList.widget.c(this);

        e() {
            this.cyl = new o(AbsHListView.this.getContext());
        }

        void jM(int i) {
            int i2 = i < 0 ? Integer.MAX_VALUE : 0;
            this.cym = i2;
            this.cyl.setInterpolator(null);
            this.cyl.fling(i2, 0, i, 0, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
            AbsHListView.this.mTouchMode = 4;
            AbsHListView.this.cwN.h(this);
        }

        void aiO() {
            if (this.cyl.springBack(AbsHListView.this.getScrollX(), 0, 0, 0, 0, 0)) {
                AbsHListView.this.mTouchMode = 6;
                AbsHListView.this.invalidate();
                AbsHListView.this.cwN.h(this);
                return;
            }
            AbsHListView.this.mTouchMode = -1;
            AbsHListView.this.jI(0);
        }

        void jN(int i) {
            this.cyl.setInterpolator(null);
            this.cyl.fling(AbsHListView.this.getScrollX(), 0, i, 0, ExploreByTouchHelper.INVALID_ID, Integer.MAX_VALUE, 0, 0, AbsHListView.this.getWidth(), 0);
            AbsHListView.this.mTouchMode = 6;
            AbsHListView.this.invalidate();
            AbsHListView.this.cwN.h(this);
        }

        void jO(int i) {
            this.cyl.notifyHorizontalEdgeReached(AbsHListView.this.getScrollX(), 0, AbsHListView.this.cxR);
            int overScrollMode = AbsHListView.this.getOverScrollMode();
            if (overScrollMode == 0 || (overScrollMode == 1 && !AbsHListView.this.ais())) {
                AbsHListView.this.mTouchMode = 6;
                int currVelocity = (int) this.cyl.getCurrVelocity();
                if (i > 0) {
                    AbsHListView.this.cxS.onAbsorb(currVelocity);
                } else {
                    AbsHListView.this.cxT.onAbsorb(currVelocity);
                }
            } else {
                AbsHListView.this.mTouchMode = -1;
                if (AbsHListView.this.cxt != null) {
                    AbsHListView.this.cxt.stop();
                }
            }
            AbsHListView.this.invalidate();
            AbsHListView.this.cwN.h(this);
        }

        void d(int i, int i2, boolean z) {
            int i3 = i < 0 ? Integer.MAX_VALUE : 0;
            this.cym = i3;
            this.cyl.setInterpolator(z ? AbsHListView.cye : null);
            this.cyl.startScroll(i3, 0, i, 0, i2);
            AbsHListView.this.mTouchMode = 4;
            AbsHListView.this.cwN.h(this);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void aiP() {
            AbsHListView.this.mTouchMode = -1;
            AbsHListView.this.removeCallbacks(this);
            AbsHListView.this.removeCallbacks(this.cyn);
            AbsHListView.this.jI(0);
            AbsHListView.this.aiH();
            this.cyl.abortAnimation();
            AbsHListView.this.overScrollBy(0, 0, 0, 0, 0, 0, 0, 0, false);
        }

        void aiQ() {
            AbsHListView.this.postDelayed(this.cyn, 40L);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // java.lang.Runnable
        public void run() {
            int max;
            boolean z = true;
            boolean z2 = false;
            switch (AbsHListView.this.mTouchMode) {
                case 3:
                    if (this.cyl.isFinished()) {
                        return;
                    }
                    break;
                case 4:
                    break;
                case 5:
                default:
                    aiP();
                    return;
                case 6:
                    o oVar = this.cyl;
                    if (oVar.computeScrollOffset()) {
                        int scrollX = AbsHListView.this.getScrollX();
                        int currX = oVar.getCurrX();
                        if (AbsHListView.this.overScrollBy(currX - scrollX, 0, scrollX, 0, 0, 0, AbsHListView.this.cxR, 0, false)) {
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
                            aiO();
                            return;
                        }
                        AbsHListView.this.invalidate();
                        AbsHListView.this.cwN.h(this);
                        return;
                    }
                    aiP();
                    return;
            }
            if (AbsHListView.this.abK) {
                AbsHListView.this.layoutChildren();
            }
            if (AbsHListView.this.czg == 0 || AbsHListView.this.getChildCount() == 0) {
                aiP();
                return;
            }
            o oVar2 = this.cyl;
            boolean computeScrollOffset = oVar2.computeScrollOffset();
            int currX2 = oVar2.getCurrX();
            int i = this.cym - currX2;
            if (i > 0) {
                AbsHListView.this.cxl = AbsHListView.this.bml;
                AbsHListView.this.cxm = AbsHListView.this.getChildAt(0).getLeft();
                max = Math.min(((AbsHListView.this.getWidth() - AbsHListView.this.getPaddingRight()) - AbsHListView.this.getPaddingLeft()) - 1, i);
            } else {
                int childCount = AbsHListView.this.getChildCount() - 1;
                AbsHListView.this.cxl = AbsHListView.this.bml + childCount;
                AbsHListView.this.cxm = AbsHListView.this.getChildAt(childCount).getLeft();
                max = Math.max(-(((AbsHListView.this.getWidth() - AbsHListView.this.getPaddingRight()) - AbsHListView.this.getPaddingLeft()) - 1), i);
            }
            View childAt = AbsHListView.this.getChildAt(AbsHListView.this.cxl - AbsHListView.this.bml);
            int left = childAt != null ? childAt.getLeft() : 0;
            boolean aw = AbsHListView.this.aw(max, max);
            if (!aw || max == 0) {
                z = false;
            }
            if (z) {
                if (childAt != null) {
                    AbsHListView.this.overScrollBy(-(max - (childAt.getLeft() - left)), 0, AbsHListView.this.getScrollX(), 0, 0, 0, AbsHListView.this.cxR, 0, false);
                }
                if (computeScrollOffset) {
                    jO(max);
                }
            } else if (computeScrollOffset && !z) {
                if (aw) {
                    AbsHListView.this.invalidate();
                }
                this.cym = currX2;
                AbsHListView.this.cwN.h(this);
            } else {
                aiP();
            }
        }
    }

    /* loaded from: classes.dex */
    public class j implements Runnable {
        private int cyA;
        private int cyv;
        private int cyw;
        private int cyx;
        private int cyy;
        private final int cyz;
        private int mMode;

        j() {
            this.cyz = ViewConfiguration.get(AbsHListView.this.getContext()).getScaledFadingEdgeLength();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void jM(int i) {
            int i2;
            stop();
            if (AbsHListView.this.abK) {
                AbsHListView.this.cxN = new com.baidu.tieba.horizonalList.widget.d(this, i);
                return;
            }
            int childCount = AbsHListView.this.getChildCount();
            if (childCount != 0) {
                int i3 = AbsHListView.this.bml;
                int i4 = (childCount + i3) - 1;
                int max = Math.max(0, Math.min(AbsHListView.this.getCount() - 1, i));
                if (max < i3) {
                    i2 = (i3 - max) + 1;
                    this.mMode = 2;
                } else if (max > i4) {
                    i2 = (max - i4) + 1;
                    this.mMode = 1;
                } else {
                    t(max, -1, 200);
                    return;
                }
                if (i2 > 0) {
                    this.cyy = 200 / i2;
                } else {
                    this.cyy = 200;
                }
                this.cyv = max;
                this.cyw = -1;
                this.cyx = -1;
                AbsHListView.this.cwN.h(this);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void ay(int i, int i2) {
            int i3;
            stop();
            if (i2 == -1) {
                jM(i);
            } else if (AbsHListView.this.abK) {
                AbsHListView.this.cxN = new com.baidu.tieba.horizonalList.widget.e(this, i, i2);
            } else {
                int childCount = AbsHListView.this.getChildCount();
                if (childCount != 0) {
                    int i4 = AbsHListView.this.bml;
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
                        t(max, i2, 200);
                        return;
                    }
                    if (i3 > 0) {
                        this.cyy = 200 / i3;
                    } else {
                        this.cyy = 200;
                    }
                    this.cyv = max;
                    this.cyw = i2;
                    this.cyx = -1;
                    AbsHListView.this.cwN.h(this);
                }
            }
        }

        void t(int i, int i2, int i3) {
            int i4 = AbsHListView.this.bml;
            int childCount = (AbsHListView.this.getChildCount() + i4) - 1;
            int i5 = AbsHListView.this.cxf.left;
            int width = AbsHListView.this.getWidth() - AbsHListView.this.cxf.right;
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
            int i2 = AbsHListView.this.bml;
            switch (this.mMode) {
                case 1:
                    int childCount = AbsHListView.this.getChildCount() - 1;
                    int i3 = i2 + childCount;
                    if (childCount >= 0) {
                        if (i3 == this.cyx) {
                            AbsHListView.this.cwN.h(this);
                            return;
                        }
                        View childAt = AbsHListView.this.getChildAt(childCount);
                        AbsHListView.this.c((i3 < AbsHListView.this.czg + (-1) ? Math.max(AbsHListView.this.cxf.right, this.cyz) : AbsHListView.this.cxf.right) + (childAt.getWidth() - (width - childAt.getLeft())), this.cyy, true);
                        this.cyx = i3;
                        if (i3 < this.cyv) {
                            AbsHListView.this.cwN.h(this);
                            return;
                        }
                        return;
                    }
                    return;
                case 2:
                    if (i2 == this.cyx) {
                        AbsHListView.this.cwN.h(this);
                        return;
                    }
                    View childAt2 = AbsHListView.this.getChildAt(0);
                    if (childAt2 != null) {
                        AbsHListView.this.c(childAt2.getLeft() - (i2 > 0 ? Math.max(this.cyz, AbsHListView.this.cxf.left) : AbsHListView.this.cxf.left), this.cyy, true);
                        this.cyx = i2;
                        if (i2 > this.cyv) {
                            AbsHListView.this.cwN.h(this);
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    int childCount2 = AbsHListView.this.getChildCount();
                    if (i2 != this.cyw && childCount2 > 1 && childCount2 + i2 < AbsHListView.this.czg) {
                        int i4 = i2 + 1;
                        if (i4 == this.cyx) {
                            AbsHListView.this.cwN.h(this);
                            return;
                        }
                        View childAt3 = AbsHListView.this.getChildAt(1);
                        int width2 = childAt3.getWidth();
                        int left2 = childAt3.getLeft();
                        int max = Math.max(AbsHListView.this.cxf.right, this.cyz);
                        if (i4 < this.cyw) {
                            AbsHListView.this.c(Math.max(0, (left2 + width2) - max), this.cyy, true);
                            this.cyx = i4;
                            AbsHListView.this.cwN.h(this);
                            return;
                        } else if (left2 > max) {
                            AbsHListView.this.c(left2 - max, this.cyy, true);
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
                        if (i5 == this.cyx) {
                            AbsHListView.this.cwN.h(this);
                            return;
                        }
                        View childAt4 = AbsHListView.this.getChildAt(childCount3);
                        int width3 = childAt4.getWidth();
                        int left3 = childAt4.getLeft();
                        int i6 = width - left3;
                        int max2 = Math.max(AbsHListView.this.cxf.left, this.cyz);
                        this.cyx = i5;
                        if (i5 > this.cyw) {
                            AbsHListView.this.c(-(i6 - max2), this.cyy, true);
                            AbsHListView.this.cwN.h(this);
                            return;
                        }
                        int i7 = width - max2;
                        int i8 = left3 + width3;
                        if (i7 > i8) {
                            AbsHListView.this.c(-(i7 - i8), this.cyy, true);
                            return;
                        }
                        return;
                    }
                    return;
                case 5:
                    if (this.cyx == i2) {
                        AbsHListView.this.cwN.h(this);
                        return;
                    }
                    this.cyx = i2;
                    int childCount4 = AbsHListView.this.getChildCount();
                    int i9 = this.cyv;
                    int i10 = (i2 + childCount4) - 1;
                    if (i9 < i2) {
                        i = (i2 - i9) + 1;
                    } else if (i9 > i10) {
                        i = i9 - i10;
                    }
                    float min = Math.min(Math.abs(i / childCount4), 1.0f);
                    if (i9 < i2) {
                        AbsHListView.this.c((int) ((-AbsHListView.this.getWidth()) * min), (int) (min * this.cyy), true);
                        AbsHListView.this.cwN.h(this);
                        return;
                    } else if (i9 > i10) {
                        AbsHListView.this.c((int) (AbsHListView.this.getWidth() * min), (int) (min * this.cyy), true);
                        AbsHListView.this.cwN.h(this);
                        return;
                    } else {
                        AbsHListView.this.c(AbsHListView.this.getChildAt(i9 - i2).getLeft() - this.cyA, (int) (this.cyy * (Math.abs(left) / AbsHListView.this.getWidth())), true);
                        return;
                    }
                default:
                    return;
            }
        }
    }

    public void setFriction(float f2) {
        if (this.cxs == null) {
            this.cxs = new e();
        }
        this.cxs.cyl.setFriction(f2);
    }

    public void setVelocityScale(float f2) {
        this.cxO = f2;
    }

    public void smoothScrollToPosition(int i2, int i3) {
        if (this.cxt == null) {
            this.cxt = new j();
        }
        this.cxt.ay(i2, i3);
    }

    public void smoothScrollBy(int i2, int i3) {
        c(i2, i3, false);
    }

    public void c(int i2, int i3, boolean z) {
        if (this.cxs == null) {
            this.cxs = new e();
        }
        int i4 = this.bml;
        int childCount = getChildCount();
        int i5 = i4 + childCount;
        int paddingLeft = getPaddingLeft();
        int width = getWidth() - getPaddingRight();
        if (i2 == 0 || this.czg == 0 || childCount == 0 || ((i4 == 0 && getChildAt(0).getLeft() == paddingLeft && i2 < 0) || (i5 == this.czg && getChildAt(childCount - 1).getRight() == width && i2 > 0))) {
            this.cxs.aiP();
            if (this.cxt != null) {
                this.cxt.stop();
                return;
            }
            return;
        }
        jI(2);
        this.cxs.d(i2, i3, z);
    }

    private void aiG() {
        if (this.mScrollingCacheEnabled && !this.cxj && !this.cwN.isHardwareAccelerated()) {
            setChildrenDrawnWithCacheEnabled(true);
            setChildrenDrawingCacheEnabled(true);
            this.cxk = true;
            this.cxj = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiH() {
        if (!this.cwN.isHardwareAccelerated()) {
            if (this.cxM == null) {
                this.cxM = new com.baidu.tieba.horizonalList.widget.b(this);
            }
            post(this.cxM);
        }
    }

    boolean aw(int i2, int i3) {
        int min;
        int min2;
        int i4;
        int childCount = getChildCount();
        if (childCount == 0) {
            return true;
        }
        int left = getChildAt(0).getLeft();
        int right = getChildAt(childCount - 1).getRight();
        Rect rect = this.cxf;
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
        int i6 = this.bml;
        if (i6 == 0) {
            this.cxU = left - rect.left;
        } else {
            this.cxU += min2;
        }
        if (i6 + childCount == this.czg) {
            this.cxV = rect.right + right;
        } else {
            this.cxV += min2;
        }
        boolean z = i6 == 0 && left >= rect.left && min2 >= 0;
        boolean z2 = i6 + childCount == this.czg && right <= getWidth() - rect.right && min2 <= 0;
        if (z || z2) {
            return min2 != 0;
        }
        boolean z3 = min2 < 0;
        boolean isInTouchMode = isInTouchMode();
        if (isInTouchMode) {
            aiI();
        }
        int headerViewsCount = getHeaderViewsCount();
        int footerViewsCount = this.czg - getFooterViewsCount();
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
                    this.cxa.s(childAt, i11);
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
                    this.cxa.s(childAt2, i14);
                }
                i4 = i13;
                i7 = i12;
            }
        }
        this.cxn = this.cxm + min;
        this.czo = true;
        if (i4 > 0) {
            detachViewsFromParent(i7, i4);
            this.cxa.aiT();
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        jJ(min2);
        if (z3) {
            this.bml = i4 + this.bml;
        }
        int abs = Math.abs(min2);
        if (i5 < abs || width < abs) {
            eJ(z3);
        }
        if (!isInTouchMode && this.cgS != -1) {
            int i15 = this.cgS - this.bml;
            if (i15 >= 0 && i15 < getChildCount()) {
                b(this.cgS, getChildAt(i15));
            }
        } else if (this.cwY != -1) {
            int i16 = this.cwY - this.bml;
            if (i16 >= 0 && i16 < getChildCount()) {
                b(-1, getChildAt(i16));
            }
        } else {
            this.cwZ.setEmpty();
        }
        this.czo = false;
        ait();
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
    public void aiI() {
        if (this.cgS != -1) {
            if (this.cwU != 4) {
                this.cxz = this.cgS;
            }
            if (this.czd >= 0 && this.czd != this.cgS) {
                this.cxz = this.czd;
            }
            setSelectedPositionInt(-1);
            setNextSelectedPositionInt(-1);
            this.cxu = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int aiJ() {
        int i2 = this.cgS;
        if (i2 < 0) {
            i2 = this.cxz;
        }
        return Math.min(Math.max(0, i2), this.czg - 1);
    }

    protected int jL(int i2) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return -1;
        }
        int jK = jK(i2);
        return jK == -1 ? (this.bml + childCount) - 1 : jK;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aiK() {
        if (this.cgS >= 0 || !aiL()) {
            return false;
        }
        aiB();
        return true;
    }

    boolean aiL() {
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
        int i8 = this.cxf.left;
        int right = (getRight() - getLeft()) - this.cxf.right;
        int i9 = this.bml;
        int i10 = this.cxz;
        if (i10 >= i9 && i10 < i9 + childCount) {
            View childAt = getChildAt(i10 - this.bml);
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
            int i15 = this.czg;
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
        this.cxz = -1;
        removeCallbacks(this.cxs);
        if (this.cxt != null) {
            this.cxt.stop();
        }
        this.mTouchMode = -1;
        aiH();
        this.cyU = i2;
        int C = C(i3, z);
        if (C < i9 || C > getLastVisiblePosition()) {
            C = -1;
        } else {
            this.cwU = 4;
            aiB();
            setSelectionInt(C);
            ait();
        }
        jI(0);
        return C >= 0;
    }

    void aiM() {
        int i2;
        boolean z;
        boolean z2;
        this.cwS.clear();
        int i3 = 0;
        boolean z3 = false;
        while (i3 < this.cwT.size()) {
            long keyAt = this.cwT.keyAt(i3);
            int intValue = this.cwT.valueAt(i3).intValue();
            if (keyAt != this.mAdapter.getItemId(intValue)) {
                int max = Math.max(0, intValue - 20);
                int min = Math.min(intValue + 20, this.czg);
                while (true) {
                    if (max >= min) {
                        z2 = false;
                        break;
                    } else if (keyAt != this.mAdapter.getItemId(max)) {
                        max++;
                    } else {
                        this.cwS.put(max, true);
                        this.cwT.setValueAt(i3, Integer.valueOf(max));
                        z2 = true;
                        break;
                    }
                }
                if (!z2) {
                    this.cwT.delete(keyAt);
                    int i4 = i3 - 1;
                    this.cwR--;
                    if (Build.VERSION.SDK_INT <= 11 || this.cwP == null || this.cwQ == null) {
                        i2 = i4;
                        z = true;
                    } else {
                        ((com.baidu.tieba.horizonalList.a.a.b) this.cwQ).onItemCheckedStateChanged((ActionMode) this.cwP, intValue, keyAt, false);
                        i2 = i4;
                        z = true;
                    }
                    z3 = z;
                    i3 = i2 + 1;
                }
            } else {
                this.cwS.put(intValue, true);
            }
            i2 = i3;
            z = z3;
            z3 = z;
            i3 = i2 + 1;
        }
        if (z3 && this.cwP != null && Build.VERSION.SDK_INT > 11) {
            ((ActionMode) this.cwP).invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.g
    public void handleDataChanged() {
        int i2 = this.czg;
        int i3 = this.cyd;
        this.cyd = this.czg;
        if (this.cwO != 0 && this.mAdapter != null && this.mAdapter.hasStableIds()) {
            aiM();
        }
        this.cxa.aiS();
        if (i2 > 0) {
            if (this.cyY) {
                this.cyY = false;
                this.cyf = null;
                if (this.cxI == 2) {
                    this.cwU = 3;
                    return;
                }
                if (this.cxI == 1) {
                    if (this.cxW) {
                        this.cxW = false;
                        this.cwU = 3;
                        return;
                    }
                    int childCount = getChildCount();
                    int width = getWidth() - getPaddingRight();
                    View childAt = getChildAt(childCount - 1);
                    int bottom = childAt != null ? childAt.getBottom() : width;
                    if (childCount + this.bml >= i3 && bottom <= width) {
                        this.cwU = 3;
                        return;
                    }
                    awakenScrollBars();
                }
                switch (this.cyZ) {
                    case 1:
                        this.cwU = 5;
                        this.cyV = Math.min(Math.max(0, this.cyV), i2 - 1);
                        return;
                    case 0:
                        if (isInTouchMode()) {
                            this.cwU = 5;
                            this.cyV = Math.min(Math.max(0, this.cyV), i2 - 1);
                            return;
                        }
                        int aje = aje();
                        if (aje >= 0 && C(aje, true) == aje) {
                            this.cyV = aje;
                            if (this.cyX == getWidth()) {
                                this.cwU = 5;
                            } else {
                                this.cwU = 2;
                            }
                            setNextSelectedPositionInt(aje);
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
                int C = C(selectedItemPosition, true);
                if (C >= 0) {
                    setNextSelectedPositionInt(C);
                    return;
                }
                int C2 = C(selectedItemPosition, false);
                if (C2 >= 0) {
                    setNextSelectedPositionInt(C2);
                    return;
                }
            } else if (this.cxz >= 0) {
                return;
            }
        }
        this.cwU = this.cxv ? 3 : 1;
        this.cgS = -1;
        this.czf = Long.MIN_VALUE;
        this.czd = -1;
        this.cze = Long.MIN_VALUE;
        this.cyY = false;
        this.cyf = null;
        this.cwY = -1;
        ajd();
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
    /* renamed from: e */
    public f generateLayoutParams(AttributeSet attributeSet) {
        return new f(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof f;
    }

    public void setTranscriptMode(int i2) {
        this.cxI = i2;
    }

    public int getTranscriptMode() {
        return this.cxI;
    }

    @Override // android.view.View
    public int getSolidColor() {
        return this.cxJ;
    }

    public void setCacheColorHint(int i2) {
        if (i2 != this.cxJ) {
            this.cxJ = i2;
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                getChildAt(i3).setDrawingCacheBackgroundColor(i2);
            }
            this.cxa.setCacheColorHint(i2);
        }
    }

    @ViewDebug.ExportedProperty(category = "drawing")
    public int getCacheColorHint() {
        return this.cxJ;
    }

    private void aiN() {
        if (this.cxS != null) {
            this.cxS.finish();
            this.cxT.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ax(int i2, int i3) {
    }

    public void setRecyclerListener(l lVar) {
        this.cxa.cyD = lVar;
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
        public int cyp;
        public boolean cyq;
        public boolean cyr;
        public int cys;
        public long cyt;

        public f(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.cyt = -1L;
        }

        public f(int i, int i2, int i3) {
            super(i, i2);
            this.cyt = -1L;
            this.cyp = i3;
        }

        public f(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.cyt = -1L;
        }
    }

    /* loaded from: classes.dex */
    public class k {
        private l cyD;
        private int cyE;
        private View[] cyF = new View[0];
        private ArrayList<View>[] cyG;
        private int cyH;
        private ArrayList<View> cyI;
        private ArrayList<View> cyJ;
        private SparseArrayCompat<View> cyK;

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
            this.cyH = i;
            this.cyI = arrayListArr[0];
            this.cyG = arrayListArr;
        }

        public void aiR() {
            if (this.cyH == 1) {
                ArrayList<View> arrayList = this.cyI;
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    arrayList.get(i).forceLayout();
                }
            } else {
                int i2 = this.cyH;
                for (int i3 = 0; i3 < i2; i3++) {
                    ArrayList<View> arrayList2 = this.cyG[i3];
                    int size2 = arrayList2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        arrayList2.get(i4).forceLayout();
                    }
                }
            }
            if (this.cyK != null) {
                int size3 = this.cyK.size();
                for (int i5 = 0; i5 < size3; i5++) {
                    this.cyK.valueAt(i5).forceLayout();
                }
            }
        }

        public boolean jQ(int i) {
            return i >= 0;
        }

        public void clear() {
            if (this.cyH == 1) {
                ArrayList<View> arrayList = this.cyI;
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    AbsHListView.this.removeDetachedView(arrayList.remove((size - 1) - i), false);
                }
            } else {
                int i2 = this.cyH;
                for (int i3 = 0; i3 < i2; i3++) {
                    ArrayList<View> arrayList2 = this.cyG[i3];
                    int size2 = arrayList2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        AbsHListView.this.removeDetachedView(arrayList2.remove((size2 - 1) - i4), false);
                    }
                }
            }
            if (this.cyK != null) {
                this.cyK.clear();
            }
        }

        public void az(int i, int i2) {
            if (this.cyF.length < i) {
                this.cyF = new View[i];
            }
            this.cyE = i2;
            View[] viewArr = this.cyF;
            for (int i3 = 0; i3 < i; i3++) {
                View childAt = AbsHListView.this.getChildAt(i3);
                f fVar = (f) childAt.getLayoutParams();
                if (fVar != null && fVar.cyp != -2) {
                    viewArr[i3] = childAt;
                }
            }
        }

        public View jR(int i) {
            int i2 = i - this.cyE;
            View[] viewArr = this.cyF;
            if (i2 < 0 || i2 >= viewArr.length) {
                return null;
            }
            View view = viewArr[i2];
            viewArr[i2] = null;
            return view;
        }

        View jS(int i) {
            int indexOfKey;
            if (this.cyK != null && (indexOfKey = this.cyK.indexOfKey(i)) >= 0) {
                View valueAt = this.cyK.valueAt(indexOfKey);
                this.cyK.removeAt(indexOfKey);
                return valueAt;
            }
            return null;
        }

        void aiS() {
            if (this.cyK != null) {
                this.cyK.clear();
            }
        }

        View jT(int i) {
            if (this.cyH == 1) {
                return AbsHListView.a(this.cyI, i);
            }
            int itemViewType = AbsHListView.this.mAdapter.getItemViewType(i);
            if (itemViewType >= 0 && itemViewType < this.cyG.length) {
                return AbsHListView.a(this.cyG[itemViewType], i);
            }
            return null;
        }

        public void s(View view, int i) {
            f fVar = (f) view.getLayoutParams();
            if (fVar != null) {
                fVar.cys = i;
                int i2 = fVar.cyp;
                if (!jQ(i2)) {
                    if (i2 != -2) {
                        if (this.cyJ == null) {
                            this.cyJ = new ArrayList<>();
                        }
                        this.cyJ.add(view);
                        return;
                    }
                    return;
                }
                view.onStartTemporaryDetach();
                if (this.cyH == 1) {
                    this.cyI.add(view);
                } else {
                    this.cyG[i2].add(view);
                }
                if (Build.VERSION.SDK_INT >= 14) {
                    view.setAccessibilityDelegate(null);
                }
                if (this.cyD != null) {
                    this.cyD.onMovedToScrapHeap(view);
                }
            }
        }

        public void aiT() {
            if (this.cyJ != null) {
                int size = this.cyJ.size();
                for (int i = 0; i < size; i++) {
                    AbsHListView.this.removeDetachedView(this.cyJ.get(i), false);
                }
                this.cyJ.clear();
            }
        }

        public void aiU() {
            View[] viewArr = this.cyF;
            boolean z = this.cyD != null;
            boolean z2 = this.cyH > 1;
            ArrayList<View> arrayList = this.cyI;
            for (int length = viewArr.length - 1; length >= 0; length--) {
                View view = viewArr[length];
                if (view != null) {
                    f fVar = (f) view.getLayoutParams();
                    int i = fVar.cyp;
                    viewArr[length] = null;
                    if (!jQ(i)) {
                        if (i != -2) {
                            AbsHListView.this.removeDetachedView(view, false);
                        }
                    } else {
                        if (z2) {
                            arrayList = this.cyG[i];
                        }
                        view.onStartTemporaryDetach();
                        fVar.cys = this.cyE + length;
                        arrayList.add(view);
                        if (Build.VERSION.SDK_INT >= 14) {
                            view.setAccessibilityDelegate(null);
                        }
                        if (z) {
                            this.cyD.onMovedToScrapHeap(view);
                        }
                    }
                }
            }
            aiV();
        }

        private void aiV() {
            int length = this.cyF.length;
            int i = this.cyH;
            ArrayList<View>[] arrayListArr = this.cyG;
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
            if (this.cyK != null) {
                for (int i6 = 0; i6 < this.cyK.size(); i6++) {
                    this.cyK.valueAt(i6);
                }
            }
        }

        void setCacheColorHint(int i) {
            View[] viewArr;
            if (this.cyH == 1) {
                ArrayList<View> arrayList = this.cyI;
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    arrayList.get(i2).setDrawingCacheBackgroundColor(i);
                }
            } else {
                int i3 = this.cyH;
                for (int i4 = 0; i4 < i3; i4++) {
                    ArrayList<View> arrayList2 = this.cyG[i4];
                    int size2 = arrayList2.size();
                    for (int i5 = 0; i5 < size2; i5++) {
                        arrayList2.get(i5).setDrawingCacheBackgroundColor(i);
                    }
                }
            }
            for (View view : this.cyF) {
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
                if (((f) view.getLayoutParams()).cys == i2) {
                    arrayList.remove(i3);
                    return view;
                }
            }
            return arrayList.remove(size - 1);
        }
        return null;
    }
}
