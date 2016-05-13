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
    static final Interpolator bRo = new LinearInterpolator();
    public static final int[] bRq = new int[1];
    a.AbstractC0057a bPX;
    protected int bPY;
    public Object bPZ;
    int bQA;
    int bQB;
    private e bQC;
    protected j bQD;
    protected int bQE;
    protected boolean bQF;
    private h bQG;
    private boolean bQH;
    private Rect bQI;
    protected int bQJ;
    private ContextMenu.ContextMenuInfo bQK;
    protected int bQL;
    private int bQM;
    private c bQN;
    private Runnable bQO;
    private b bQP;
    private i bQQ;
    private Runnable bQR;
    private int bQS;
    private int bQT;
    private boolean bQU;
    private int bQV;
    private Runnable bQW;
    protected Runnable bQX;
    private float bQY;
    protected final boolean[] bQZ;
    Object bQa;
    int bQb;
    protected SparseArrayCompat<Boolean> bQc;
    LongSparseArray<Integer> bQd;
    protected int bQe;
    protected a bQf;
    boolean bQg;
    boolean bQh;
    int bQi;
    protected Rect bQj;
    protected final k bQk;
    int bQl;
    int bQm;
    int bQn;
    int bQo;
    protected Rect bQp;
    protected int bQq;
    View bQr;
    View bQs;
    protected boolean bQt;
    protected boolean bQu;
    protected int bQv;
    int bQw;
    int bQx;
    int bQy;
    int bQz;
    int bRa;
    int bRb;
    private EdgeEffectCompat bRc;
    private EdgeEffectCompat bRd;
    private int bRe;
    private int bRf;
    private boolean bRg;
    private int bRh;
    private int bRi;
    private g bRj;
    private int bRk;
    private int bRl;
    protected boolean bRm;
    private int bRn;
    private SavedState bRp;
    private float bRr;
    private int mActivePointerId;
    protected ListAdapter mAdapter;
    private int mDirection;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    boolean mScrollingCacheEnabled;
    protected int mTouchMode;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    Drawable xQ;

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

    protected abstract void dV(boolean z);

    /* renamed from: if  reason: not valid java name */
    protected abstract int mo18if(int i2);

    public abstract void setSelectionInt(int i2);

    public AbsHListView(Context context) {
        super(context);
        this.bPY = 0;
        this.bQe = 0;
        this.bQh = false;
        this.bQi = -1;
        this.bQj = new Rect();
        this.bQk = new k();
        this.bQl = 0;
        this.bQm = 0;
        this.bQn = 0;
        this.bQo = 0;
        this.bQp = new Rect();
        this.bQq = 0;
        this.mTouchMode = -1;
        this.bQE = 0;
        this.bQH = true;
        this.bQJ = -1;
        this.bQK = null;
        this.bQM = -1;
        this.bQV = 0;
        this.bQY = 1.0f;
        this.bQZ = new boolean[1];
        this.mActivePointerId = -1;
        this.mDirection = 0;
        ZL();
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
        this.bPY = 0;
        this.bQe = 0;
        this.bQh = false;
        this.bQi = -1;
        this.bQj = new Rect();
        this.bQk = new k();
        this.bQl = 0;
        this.bQm = 0;
        this.bQn = 0;
        this.bQo = 0;
        this.bQp = new Rect();
        this.bQq = 0;
        this.mTouchMode = -1;
        this.bQE = 0;
        this.bQH = true;
        this.bQJ = -1;
        this.bQK = null;
        this.bQM = -1;
        this.bQV = 0;
        this.bQY = 1.0f;
        this.bQZ = new boolean[1];
        this.mActivePointerId = -1;
        this.mDirection = 0;
        ZL();
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
        this.bQh = z3;
        setStackFromRight(z2);
        setScrollingCacheEnabled(z);
        setTranscriptMode(i3);
        setCacheColorHint(i4);
        setSmoothScrollbarEnabled(z4);
        setChoiceMode(i5);
    }

    private void ZL() {
        setClickable(true);
        setFocusableInTouchMode(true);
        setWillNotDraw(false);
        setAlwaysDrawnWithCacheEnabled(false);
        setScrollingCacheEnabled(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.bRa = viewConfiguration.getScaledOverscrollDistance();
        this.bRb = viewConfiguration.getScaledOverflingDistance();
        this.bPX = com.baidu.tieba.horizonalList.a.a.aq(this);
    }

    @Override // android.view.View
    public void setOverScrollMode(int i2) {
        if (i2 != 2) {
            if (this.bRc == null) {
                Context context = getContext();
                this.bRc = new EdgeEffectCompat(context);
                this.bRd = new EdgeEffectCompat(context);
            }
        } else {
            this.bRc = null;
            this.bRd = null;
        }
        super.setOverScrollMode(i2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.horizonalList.widget.g
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            this.bQg = this.mAdapter.hasStableIds();
            if (this.bPY != 0 && this.bQg && this.bQd == null) {
                this.bQd = new LongSparseArray<>();
            }
        }
        if (this.bQc != null) {
            this.bQc.clear();
        }
        if (this.bQd != null) {
            this.bQd.clear();
        }
    }

    public int getCheckedItemCount() {
        return this.bQb;
    }

    public boolean isItemChecked(int i2) {
        if (this.bPY == 0 || this.bQc == null) {
            return false;
        }
        return this.bQc.get(i2, false).booleanValue();
    }

    public int getCheckedItemPosition() {
        if (this.bPY == 1 && this.bQc != null && this.bQc.size() == 1) {
            return this.bQc.keyAt(0);
        }
        return -1;
    }

    public SparseArrayCompat<Boolean> getCheckedItemPositions() {
        if (this.bPY != 0) {
            return this.bQc;
        }
        return null;
    }

    public long[] getCheckedItemIds() {
        if (this.bPY == 0 || this.bQd == null || this.mAdapter == null) {
            return new long[0];
        }
        LongSparseArray<Integer> longSparseArray = this.bQd;
        int size = longSparseArray.size();
        long[] jArr = new long[size];
        for (int i2 = 0; i2 < size; i2++) {
            jArr[i2] = longSparseArray.keyAt(i2);
        }
        return jArr;
    }

    public void clearChoices() {
        if (this.bQc != null) {
            this.bQc.clear();
        }
        if (this.bQd != null) {
            this.bQd.clear();
        }
        this.bQb = 0;
    }

    public void setItemChecked(int i2, boolean z) {
        if (this.bPY != 0) {
            if (Build.VERSION.SDK_INT >= 11 && z && this.bPY == 3 && this.bPZ == null) {
                if (this.bQa == null || !((com.baidu.tieba.horizonalList.a.a.b) this.bQa).ZK()) {
                    throw new IllegalStateException("AbsListView: attempted to start selection mode for CHOICE_MODE_MULTIPLE_MODAL but no choice mode callback was supplied. Call setMultiChoiceModeListener to set a callback.");
                }
                this.bPZ = startActionMode((com.baidu.tieba.horizonalList.a.a.b) this.bQa);
            }
            if (this.bPY == 2 || (Build.VERSION.SDK_INT >= 11 && this.bPY == 3)) {
                boolean booleanValue = this.bQc.get(i2, false).booleanValue();
                this.bQc.put(i2, Boolean.valueOf(z));
                if (this.bQd != null && this.mAdapter.hasStableIds()) {
                    if (z) {
                        this.bQd.put(this.mAdapter.getItemId(i2), Integer.valueOf(i2));
                    } else {
                        this.bQd.delete(this.mAdapter.getItemId(i2));
                    }
                }
                if (booleanValue != z) {
                    if (z) {
                        this.bQb++;
                    } else {
                        this.bQb--;
                    }
                }
                if (this.bPZ != null) {
                    ((com.baidu.tieba.horizonalList.a.a.b) this.bQa).onItemCheckedStateChanged((ActionMode) this.bPZ, i2, this.mAdapter.getItemId(i2), z);
                }
            } else {
                boolean z2 = this.bQd != null && this.mAdapter.hasStableIds();
                if (z || isItemChecked(i2)) {
                    this.bQc.clear();
                    if (z2) {
                        this.bQd.clear();
                    }
                }
                if (z) {
                    this.bQc.put(i2, true);
                    if (z2) {
                        this.bQd.put(this.mAdapter.getItemId(i2), Integer.valueOf(i2));
                    }
                    this.bQb = 1;
                } else if (this.bQc.size() == 0 || !this.bQc.valueAt(0).booleanValue()) {
                    this.bQb = 0;
                }
            }
            if (!this.mInLayout && !this.bSz) {
                this.aaG = true;
                aaA();
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
        if (this.bPY != 0) {
            if (this.bPY == 2 || (Build.VERSION.SDK_INT >= 11 && this.bPY == 3 && this.bPZ != null)) {
                boolean z5 = !this.bQc.get(i2, false).booleanValue();
                this.bQc.put(i2, Boolean.valueOf(z5));
                if (this.bQd != null && this.mAdapter.hasStableIds()) {
                    if (z5) {
                        this.bQd.put(this.mAdapter.getItemId(i2), Integer.valueOf(i2));
                    } else {
                        this.bQd.delete(this.mAdapter.getItemId(i2));
                    }
                }
                if (z5) {
                    this.bQb++;
                } else {
                    this.bQb--;
                }
                if (this.bPZ != null) {
                    ((com.baidu.tieba.horizonalList.a.a.b) this.bQa).onItemCheckedStateChanged((ActionMode) this.bPZ, i2, j2, z5);
                } else {
                    z4 = true;
                }
                z2 = z4;
                z4 = true;
            } else if (this.bPY == 1) {
                if (!this.bQc.get(i2, false).booleanValue()) {
                    this.bQc.clear();
                    this.bQc.put(i2, true);
                    if (this.bQd != null && this.mAdapter.hasStableIds()) {
                        this.bQd.clear();
                        this.bQd.put(this.mAdapter.getItemId(i2), Integer.valueOf(i2));
                    }
                    this.bQb = 1;
                } else if (this.bQc.size() == 0 || !this.bQc.valueAt(0).booleanValue()) {
                    this.bQb = 0;
                }
                z4 = true;
                z2 = true;
            } else {
                z2 = true;
            }
            if (z4) {
                ZM();
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

    private void ZM() {
        int i2 = this.bSe;
        int childCount = getChildCount();
        boolean z = Build.VERSION.SDK_INT >= 11;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            int i4 = i2 + i3;
            if (childAt instanceof Checkable) {
                ((Checkable) childAt).setChecked(this.bQc.get(i4, false).booleanValue());
            } else if (z) {
                childAt.setActivated(this.bQc.get(i4, false).booleanValue());
            }
        }
    }

    public int getChoiceMode() {
        return this.bPY;
    }

    public void setChoiceMode(int i2) {
        this.bPY = i2;
        if (Build.VERSION.SDK_INT >= 11 && this.bPZ != null) {
            if (Build.VERSION.SDK_INT >= 11) {
                ((ActionMode) this.bPZ).finish();
            }
            this.bPZ = null;
        }
        if (this.bPY != 0) {
            if (this.bQc == null) {
                this.bQc = new SparseArrayCompat<>();
            }
            if (this.bQd == null && this.mAdapter != null && this.mAdapter.hasStableIds()) {
                this.bQd = new LongSparseArray<>();
            }
            if (Build.VERSION.SDK_INT >= 11 && this.bPY == 3) {
                clearChoices();
                setLongClickable(true);
            }
        }
    }

    public void setMultiChoiceModeListener(com.baidu.tieba.horizonalList.a.a.a aVar) {
        if (Build.VERSION.SDK_INT >= 11) {
            if (this.bQa == null) {
                this.bQa = new com.baidu.tieba.horizonalList.a.a.b(this);
            }
            ((com.baidu.tieba.horizonalList.a.a.b) this.bQa).a(aVar);
            return;
        }
        Log.e("AbsListView", "setMultiChoiceModeListener not supported for this version of Android");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ZN() {
        int childCount = getChildCount();
        if (childCount == 0) {
            return true;
        }
        if (childCount != this.bSr) {
            return false;
        }
        return getChildAt(0).getLeft() >= this.bQp.left && getChildAt(childCount + (-1)).getRight() <= getWidth() - this.bQp.right;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public int getHorizontalScrollbarHeight() {
        return super.getHorizontalScrollbarHeight();
    }

    public void setSmoothScrollbarEnabled(boolean z) {
        this.bQH = z;
    }

    public void setOnScrollListener(h hVar) {
        this.bQG = hVar;
        ZO();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ZO() {
        if (this.bQG != null) {
            this.bQG.a(this, this.bSe, getChildCount(), this.bSr);
        }
        onScrollChanged(0, 0, 0, 0);
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEvent(int i2) {
        if (i2 == 4096) {
            int firstVisiblePosition = getFirstVisiblePosition();
            int lastVisiblePosition = getLastVisiblePosition();
            if (this.bRk != firstVisiblePosition || this.bRl != lastVisiblePosition) {
                this.bRk = firstVisiblePosition;
                this.bRl = lastVisiblePosition;
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
            aac();
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

    private void ZP() {
        setSelector(getResources().getDrawable(17301602));
    }

    public void setStackFromRight(boolean z) {
        if (this.bQF != z) {
            this.bQF = z;
            ZQ();
        }
    }

    void ZQ() {
        if (getChildCount() > 0) {
            ZR();
            requestLayout();
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new com.baidu.tieba.horizonalList.widget.f();
        long bRV;
        long bRW;
        int bRX;
        String bRY;
        boolean bRZ;
        int bSa;
        SparseArrayCompat<Boolean> bSb;
        LongSparseArray<Integer> bSc;
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
            this.bRV = parcel.readLong();
            this.bRW = parcel.readLong();
            this.bRX = parcel.readInt();
            this.position = parcel.readInt();
            this.width = parcel.readInt();
            this.bRY = parcel.readString();
            this.bRZ = parcel.readByte() != 0;
            this.bSa = parcel.readInt();
            this.bSb = f(parcel);
            this.bSc = e(parcel);
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
            parcel.writeLong(this.bRV);
            parcel.writeLong(this.bRW);
            parcel.writeInt(this.bRX);
            parcel.writeInt(this.position);
            parcel.writeInt(this.width);
            parcel.writeString(this.bRY);
            parcel.writeByte((byte) (this.bRZ ? 1 : 0));
            parcel.writeInt(this.bSa);
            a(this.bSb, parcel);
            a(this.bSc, parcel);
        }

        public String toString() {
            return "AbsListView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " selectedId=" + this.bRV + " firstId=" + this.bRW + " viewLeft=" + this.bRX + " position=" + this.position + " width=" + this.width + " filter=" + this.bRY + " checkState=" + this.bSb + "}";
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        boolean z = true;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.bRp != null) {
            savedState.bRV = this.bRp.bRV;
            savedState.bRW = this.bRp.bRW;
            savedState.bRX = this.bRp.bRX;
            savedState.position = this.bRp.position;
            savedState.width = this.bRp.width;
            savedState.bRY = this.bRp.bRY;
            savedState.bRZ = this.bRp.bRZ;
            savedState.bSa = this.bRp.bSa;
            savedState.bSb = this.bRp.bSb;
            savedState.bSc = this.bRp.bSc;
            return savedState;
        }
        boolean z2 = getChildCount() > 0 && this.bSr > 0;
        long selectedItemId = getSelectedItemId();
        savedState.bRV = selectedItemId;
        savedState.width = getWidth();
        if (selectedItemId >= 0) {
            savedState.bRX = this.bQE;
            savedState.position = getSelectedItemPosition();
            savedState.bRW = -1L;
        } else if (z2 && this.bSe > 0) {
            savedState.bRX = getChildAt(0).getLeft();
            int i2 = this.bSe;
            if (i2 >= this.bSr) {
                i2 = this.bSr - 1;
            }
            savedState.position = i2;
            savedState.bRW = this.mAdapter.getItemId(i2);
        } else {
            savedState.bRX = 0;
            savedState.bRW = -1L;
            savedState.position = 0;
        }
        savedState.bRY = null;
        savedState.bRZ = (Build.VERSION.SDK_INT < 11 || this.bPY != 3 || this.bPZ == null) ? false : false;
        if (this.bQc != null) {
            try {
                savedState.bSb = this.bQc.m1clone();
            } catch (NoSuchMethodError e2) {
                e2.printStackTrace();
                savedState.bSb = new SparseArrayCompat<>();
            }
        }
        if (this.bQd != null) {
            LongSparseArray<Integer> longSparseArray = new LongSparseArray<>();
            int size = this.bQd.size();
            for (int i3 = 0; i3 < size; i3++) {
                longSparseArray.put(this.bQd.keyAt(i3), this.bQd.valueAt(i3));
            }
            savedState.bSc = longSparseArray;
        }
        savedState.bSa = this.bQb;
        return savedState;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.aaG = true;
        this.bSi = savedState.width;
        if (savedState.bRV >= 0) {
            this.bSj = true;
            this.bRp = savedState;
            this.bSh = savedState.bRV;
            this.bSg = savedState.position;
            this.bSf = savedState.bRX;
            this.bSk = 0;
        } else if (savedState.bRW >= 0) {
            setSelectedPositionInt(-1);
            setNextSelectedPositionInt(-1);
            this.bQi = -1;
            this.bSj = true;
            this.bRp = savedState;
            this.bSh = savedState.bRW;
            this.bSg = savedState.position;
            this.bSf = savedState.bRX;
            this.bSk = 1;
        }
        if (savedState.bSb != null) {
            this.bQc = savedState.bSb;
        }
        if (savedState.bSc != null) {
            this.bQd = savedState.bSc;
        }
        this.bQb = savedState.bSa;
        if (Build.VERSION.SDK_INT >= 11 && savedState.bRZ && this.bPY == 3 && this.bQa != null) {
            this.bPZ = startActionMode((com.baidu.tieba.horizonalList.a.a.b) this.bQa);
        }
        requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onFocusChanged(boolean z, int i2, Rect rect) {
        super.onFocusChanged(z, i2, rect);
        if (z && this.bHc < 0 && !isInTouchMode()) {
            if (!this.bRm && this.mAdapter != null) {
                this.aaG = true;
                this.bSs = this.bSr;
                this.bSr = this.mAdapter.getCount();
            }
            aag();
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (!this.bSz && !this.mInLayout) {
            super.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ZR() {
        removeAllViewsInLayout();
        this.bSe = 0;
        this.aaG = false;
        this.bQX = null;
        this.bSj = false;
        this.bRp = null;
        this.bSu = -1;
        this.bSv = Long.MIN_VALUE;
        setSelectedPositionInt(-1);
        setNextSelectedPositionInt(-1);
        this.bQE = 0;
        this.bQi = -1;
        this.bQj.setEmpty();
        invalidate();
    }

    @Override // android.view.View
    protected int computeHorizontalScrollExtent() {
        int childCount = getChildCount();
        if (childCount > 0) {
            if (this.bQH) {
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
        int i3 = this.bSe;
        int childCount = getChildCount();
        if (i3 < 0 || childCount <= 0) {
            return 0;
        }
        if (this.bQH) {
            View childAt = getChildAt(0);
            int left = childAt.getLeft();
            int width = childAt.getWidth();
            if (width > 0) {
                return Math.max(((i3 * 100) - ((left * 100) / width)) + ((int) ((getScrollX() / getWidth()) * this.bSr * 100.0f)), 0);
            }
            return 0;
        }
        int i4 = this.bSr;
        if (i3 != 0) {
            i2 = i3 + childCount == i4 ? i4 : (childCount / 2) + i3;
        }
        return (int) (((i2 / i4) * childCount) + i3);
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        if (this.bQH) {
            int max = Math.max(this.bSr * 100, 0);
            if (getScrollX() != 0) {
                return max + Math.abs((int) ((getScrollX() / getWidth()) * this.bSr * 100.0f));
            }
            return max;
        }
        return this.bSr;
    }

    @Override // android.view.View
    protected float getLeftFadingEdgeStrength() {
        int childCount = getChildCount();
        float leftFadingEdgeStrength = super.getLeftFadingEdgeStrength();
        if (childCount != 0) {
            if (this.bSe > 0) {
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
            if ((this.bSe + childCount) - 1 < this.bSr - 1) {
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
        if (this.xQ == null) {
            ZP();
        }
        Rect rect = this.bQp;
        rect.left = this.bQl + getPaddingLeft();
        rect.top = this.bQm + getPaddingTop();
        rect.right = this.bQn + getPaddingRight();
        rect.bottom = this.bQo + getPaddingBottom();
        if (this.bQS == 1) {
            int childCount = getChildCount();
            int width = getWidth() - getPaddingRight();
            View childAt = getChildAt(childCount - 1);
            this.bRg = childCount + this.bSe >= this.bRn && (childAt != null ? childAt.getRight() : width) <= width;
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
            this.bQk.aam();
        }
        layoutChildren();
        this.mInLayout = false;
        this.bQL = (i4 - i2) / 3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void layoutChildren() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ZS() {
        boolean z = true;
        if (this.bQr != null) {
            boolean z2 = this.bSe > 0;
            if (!z2 && getChildCount() > 0) {
                z2 = getChildAt(0).getLeft() < this.bQp.left;
            }
            this.bQr.setVisibility(z2 ? 0 : 4);
        }
        if (this.bQs != null) {
            int childCount = getChildCount();
            boolean z3 = this.bSe + childCount < this.bSr;
            if (z3 || childCount <= 0) {
                z = z3;
            } else if (getChildAt(childCount - 1).getRight() <= getRight() - this.bQp.right) {
                z = false;
            }
            this.bQs.setVisibility(z ? 0 : 4);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.g
    @ViewDebug.ExportedProperty
    public View getSelectedView() {
        if (this.bSr <= 0 || this.bHc < 0) {
            return null;
        }
        return getChildAt(this.bHc - this.bSe);
    }

    public int getListPaddingTop() {
        return this.bQp.top;
    }

    public int getListPaddingBottom() {
        return this.bQp.bottom;
    }

    public int getListPaddingLeft() {
        return this.bQp.left;
    }

    public int getListPaddingRight() {
        return this.bQp.right;
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
        View in = this.bQk.in(i2);
        if (in == null) {
            View io = this.bQk.io(i2);
            if (io != null) {
                view = this.mAdapter.getView(i2, io, this);
                if (view != io) {
                    this.bQk.s(io, i2);
                    if (this.bQT != 0) {
                        view.setDrawingCacheBackgroundColor(this.bQT);
                        in = view;
                    }
                } else {
                    zArr[0] = true;
                    view.onFinishTemporaryDetach();
                    in = view;
                }
                if (this.bQg) {
                    ViewGroup.LayoutParams layoutParams = in.getLayoutParams();
                    if (layoutParams == null) {
                        fVar = (f) generateDefaultLayoutParams();
                    } else if (!checkLayoutParams(layoutParams)) {
                        fVar = (f) generateLayoutParams(layoutParams);
                    } else {
                        fVar = (f) layoutParams;
                    }
                    fVar.bRD = this.mAdapter.getItemId(i2);
                    in.setLayoutParams(fVar);
                }
                if (this.bSt.isEnabled() && this.bRj == null) {
                    this.bRj = new g();
                }
            } else {
                view = this.mAdapter.getView(i2, null, this);
                if (this.bQT != 0) {
                    view.setDrawingCacheBackgroundColor(this.bQT);
                }
            }
            in = view;
            if (this.bQg) {
            }
            if (this.bSt.isEnabled()) {
                this.bRj = new g();
            }
        }
        return in;
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
            this.bQi = i2;
        }
        Rect rect = this.bQj;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        if (view instanceof m) {
            ((m) view).adjustListItemSelectionBounds(rect);
        }
        h(rect.left, rect.top, rect.right, rect.bottom);
        boolean z = this.bQU;
        if (view.isEnabled() != z) {
            this.bQU = !z;
            if (getSelectedItemPosition() != -1) {
                refreshDrawableState();
            }
        }
    }

    private void h(int i2, int i3, int i4, int i5) {
        this.bQj.set(i2 - this.bQl, i3 - this.bQm, this.bQn + i4, this.bQo + i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        boolean z = this.bQh;
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
            this.aaG = true;
            aaA();
        }
    }

    boolean ZT() {
        switch (this.mTouchMode) {
            case 1:
            case 2:
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean ZU() {
        return (hasFocus() && !isInTouchMode()) || ZT();
    }

    private void h(Canvas canvas) {
        if (!this.bQj.isEmpty()) {
            Drawable drawable = this.xQ;
            drawable.setBounds(this.bQj);
            drawable.draw(canvas);
        }
    }

    public void setDrawSelectorOnTop(boolean z) {
        this.bQh = z;
    }

    public void setSelector(int i2) {
        setSelector(getResources().getDrawable(i2));
    }

    public void setSelector(Drawable drawable) {
        if (this.xQ != null) {
            this.xQ.setCallback(null);
            unscheduleDrawable(this.xQ);
        }
        this.xQ = drawable;
        Rect rect = new Rect();
        drawable.getPadding(rect);
        this.bQl = rect.left;
        this.bQm = rect.top;
        this.bQn = rect.right;
        this.bQo = rect.bottom;
        drawable.setCallback(this);
        ZW();
    }

    public Drawable getSelector() {
        return this.xQ;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ZV() {
        if (isEnabled() && isClickable()) {
            Drawable drawable = this.xQ;
            Rect rect = this.bQj;
            if (drawable != null) {
                if ((isFocused() || ZT()) && !rect.isEmpty()) {
                    View childAt = getChildAt(this.bHc - this.bSe);
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
                    if (isLongClickable && !this.aaG) {
                        if (this.bQP == null) {
                            this.bQP = new b(this, null);
                        }
                        this.bQP.aar();
                        postDelayed(this.bQP, ViewConfiguration.getLongPressTimeout());
                    }
                }
            }
        }
    }

    void ZW() {
        if (this.xQ != null) {
            if (ZU()) {
                this.xQ.setState(getDrawableState());
            } else {
                this.xQ.setState(bRq);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        ZW();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i2) {
        if (this.bQU) {
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
        return this.xQ == drawable || super.verifyDrawable(drawable);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.xQ != null) {
            this.xQ.jumpToCurrentState();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnTouchModeChangeListener(this);
        if (this.mAdapter != null && this.bQf == null) {
            this.bQf = new a();
            this.mAdapter.registerDataSetObserver(this.bQf);
            this.aaG = true;
            this.bSs = this.bSr;
            this.bSr = this.mAdapter.getCount();
        }
        this.bRm = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.g, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.bQk.clear();
        getViewTreeObserver().removeOnTouchModeChangeListener(this);
        if (this.mAdapter != null && this.bQf != null) {
            this.mAdapter.unregisterDataSetObserver(this.bQf);
            this.bQf = null;
        }
        if (this.bQC != null) {
            removeCallbacks(this.bQC);
        }
        if (this.bQD != null) {
            this.bQD.stop();
        }
        if (this.bQW != null) {
            removeCallbacks(this.bQW);
        }
        if (this.bQQ != null) {
            removeCallbacks(this.bQQ);
        }
        if (this.bQR != null) {
            removeCallbacks(this.bQR);
            this.bQR = null;
        }
        this.bRm = false;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        int i2 = isInTouchMode() ? 0 : 1;
        if (!z) {
            setChildrenDrawingCacheEnabled(false);
            if (this.bQC != null) {
                removeCallbacks(this.bQC);
                this.bQC.aak();
                if (this.bQD != null) {
                    this.bQD.stop();
                }
                if (getScrollX() != 0) {
                    this.bPX.setScrollX(0);
                    aai();
                    invalidate();
                }
            }
            if (i2 == 1) {
                this.bQJ = this.bHc;
            }
        } else if (i2 != this.bQM && this.bQM != -1) {
            if (i2 == 1) {
                aag();
            } else {
                aad();
                this.bQe = 0;
                layoutChildren();
            }
        }
        this.bQM = i2;
    }

    ContextMenu.ContextMenuInfo b(View view, int i2, long j2) {
        return new g.a(view, i2, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class n {
        private int bSd;

        private n() {
        }

        /* synthetic */ n(AbsHListView absHListView, n nVar) {
            this();
        }

        public void aar() {
            this.bSd = AbsHListView.this.getWindowAttachCount();
        }

        public boolean aas() {
            return AbsHListView.this.hasWindowFocus() && AbsHListView.this.getWindowAttachCount() == this.bSd;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class i extends n implements Runnable {
        int bRE;

        private i() {
            super(AbsHListView.this, null);
        }

        /* synthetic */ i(AbsHListView absHListView, i iVar) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            View childAt;
            if (!AbsHListView.this.aaG) {
                ListAdapter listAdapter = AbsHListView.this.mAdapter;
                int i = this.bRE;
                if (listAdapter != null && AbsHListView.this.bSr > 0 && i != -1 && i < listAdapter.getCount() && aas() && (childAt = AbsHListView.this.getChildAt(i - AbsHListView.this.bSe)) != null) {
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
            View childAt = AbsHListView.this.getChildAt(AbsHListView.this.bQv - AbsHListView.this.bSe);
            if (childAt != null) {
                if ((!aas() || AbsHListView.this.aaG) ? false : AbsHListView.this.c(childAt, AbsHListView.this.bQv, AbsHListView.this.mAdapter.getItemId(AbsHListView.this.bQv))) {
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
            if (AbsHListView.this.isPressed() && AbsHListView.this.bHc >= 0) {
                View childAt = AbsHListView.this.getChildAt(AbsHListView.this.bHc - AbsHListView.this.bSe);
                if (!AbsHListView.this.aaG) {
                    if (aas() ? AbsHListView.this.c(childAt, AbsHListView.this.bHc, AbsHListView.this.bSq) : false) {
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
        if (Build.VERSION.SDK_INT >= 11 && this.bPY == 3) {
            if (this.bPZ == null) {
                ActionMode startActionMode = startActionMode((com.baidu.tieba.horizonalList.a.a.b) this.bQa);
                this.bPZ = startActionMode;
                if (startActionMode != null) {
                    setItemChecked(i2, true);
                    performHapticFeedback(0);
                }
            }
            return true;
        }
        boolean b2 = this.bSn != null ? this.bSn.b(this, view, i2, j2) : false;
        if (!b2) {
            this.bQK = b(view, i2, j2);
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
        return this.bQK;
    }

    public boolean a(float f2, float f3, int i2) {
        int pointToPosition = pointToPosition((int) f2, (int) f3);
        if (pointToPosition != -1) {
            long itemId = this.mAdapter.getItemId(pointToPosition);
            View childAt = getChildAt(pointToPosition - this.bSe);
            if (childAt != null) {
                this.bQK = b(childAt, pointToPosition, itemId);
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
            boolean b2 = this.bSn != null ? this.bSn.b(this, view, positionForView, itemId) : false;
            if (!b2) {
                this.bQK = b(getChildAt(positionForView - this.bSe), positionForView, itemId);
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
                if (isClickable() && isPressed() && this.bHc >= 0 && this.mAdapter != null && this.bHc < this.mAdapter.getCount()) {
                    View childAt = getChildAt(this.bHc - this.bSe);
                    if (childAt != null) {
                        performItemClick(childAt, this.bHc, this.bSq);
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
        Rect rect = this.bQI;
        if (rect == null) {
            this.bQI = new Rect();
            rect = this.bQI;
        }
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt.getVisibility() == 0) {
                childAt.getHitRect(rect);
                if (rect.contains(i2, i3)) {
                    return this.bSe + childCount;
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
                View childAt = AbsHListView.this.getChildAt(AbsHListView.this.bQv - AbsHListView.this.bSe);
                if (childAt != null && !childAt.hasFocusable()) {
                    AbsHListView.this.bQe = 0;
                    if (!AbsHListView.this.aaG) {
                        childAt.setPressed(true);
                        AbsHListView.this.setPressed(true);
                        AbsHListView.this.layoutChildren();
                        AbsHListView.this.b(AbsHListView.this.bQv, childAt);
                        AbsHListView.this.refreshDrawableState();
                        int longPressTimeout = ViewConfiguration.getLongPressTimeout();
                        boolean isLongClickable = AbsHListView.this.isLongClickable();
                        if (AbsHListView.this.xQ != null && (current = AbsHListView.this.xQ.getCurrent()) != null && (current instanceof TransitionDrawable)) {
                            if (isLongClickable) {
                                ((TransitionDrawable) current).startTransition(longPressTimeout);
                            } else {
                                ((TransitionDrawable) current).resetTransition();
                            }
                        }
                        if (isLongClickable) {
                            if (AbsHListView.this.bQN == null) {
                                AbsHListView.this.bQN = new c(AbsHListView.this, null);
                            }
                            AbsHListView.this.bQN.aar();
                            AbsHListView.this.postDelayed(AbsHListView.this.bQN, longPressTimeout);
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

    private boolean ib(int i2) {
        int i3 = i2 - this.bQy;
        int abs = Math.abs(i3);
        boolean z = getScrollX() != 0;
        if (z || abs > this.mTouchSlop) {
            aab();
            if (z) {
                this.mTouchMode = 5;
                this.bQB = 0;
            } else {
                this.mTouchMode = 3;
                this.bQB = i3 > 0 ? this.mTouchSlop : -this.mTouchSlop;
            }
            Handler handler = getHandler();
            if (handler != null) {
                handler.removeCallbacks(this.bQN);
            }
            setPressed(false);
            View childAt = getChildAt(this.bQv - this.bSe);
            if (childAt != null) {
                childAt.setPressed(false);
            }
            id(1);
            ViewParent parent = getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            ic(i2);
            return true;
        }
        return false;
    }

    private void ic(int i2) {
        int i3;
        int childCount;
        ViewParent parent;
        int i4 = i2 - this.bQy;
        int i5 = i4 - this.bQB;
        int i6 = this.bQA != Integer.MIN_VALUE ? i2 - this.bQA : i5;
        if (this.mTouchMode == 3) {
            if (i2 != this.bQA) {
                if (Math.abs(i4) > this.mTouchSlop && (parent = getParent()) != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
                if (this.bQv >= 0) {
                    childCount = this.bQv - this.bSe;
                } else {
                    childCount = getChildCount() / 2;
                }
                View childAt = getChildAt(childCount);
                int left = childAt != null ? childAt.getLeft() : 0;
                boolean ad = i6 != 0 ? ad(i5, i6) : false;
                View childAt2 = getChildAt(childCount);
                if (childAt2 != null) {
                    int left2 = childAt2.getLeft();
                    if (ad) {
                        int i7 = (-i6) - (left2 - left);
                        overScrollBy(i7, 0, getScrollX(), 0, 0, 0, this.bRa, 0, true);
                        if (Math.abs(this.bRa) == Math.abs(getScrollX()) && this.mVelocityTracker != null) {
                            this.mVelocityTracker.clear();
                        }
                        int overScrollMode = getOverScrollMode();
                        if (overScrollMode == 0 || (overScrollMode == 1 && !ZN())) {
                            this.mDirection = 0;
                            this.mTouchMode = 5;
                            if (i4 > 0) {
                                this.bRc.onPull(i7 / getWidth());
                                if (!this.bRd.isFinished()) {
                                    this.bRd.onRelease();
                                }
                                invalidate();
                            } else if (i4 < 0) {
                                this.bRd.onPull(i7 / getWidth());
                                if (!this.bRc.isFinished()) {
                                    this.bRc.onRelease();
                                }
                                invalidate();
                            }
                        }
                    }
                    this.bQy = i2;
                }
                this.bQA = i2;
            }
        } else if (this.mTouchMode == 5 && i2 != this.bQA) {
            int scrollX = getScrollX();
            int i8 = scrollX - i6;
            int i9 = i2 > this.bQA ? 1 : -1;
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
                overScrollBy(i10, 0, getScrollX(), 0, 0, 0, this.bRa, 0, true);
                int overScrollMode2 = getOverScrollMode();
                if (overScrollMode2 == 0 || (overScrollMode2 == 1 && !ZN())) {
                    if (i4 > 0) {
                        this.bRc.onPull(i10 / getWidth());
                        if (!this.bRd.isFinished()) {
                            this.bRd.onRelease();
                        }
                        invalidate();
                    } else if (i4 < 0) {
                        this.bRd.onPull(i10 / getWidth());
                        if (!this.bRc.isFinished()) {
                            this.bRc.onRelease();
                        }
                        invalidate();
                    }
                }
            }
            if (i3 != 0) {
                if (getScrollX() != 0) {
                    this.bPX.setScrollX(0);
                    ZX();
                }
                ad(i3, i3);
                this.mTouchMode = 3;
                int ig = ig(i2);
                this.bQB = 0;
                View childAt3 = getChildAt(ig - this.bSe);
                this.bQw = childAt3 != null ? childAt3.getLeft() : 0;
                this.bQy = i2;
                this.bQv = ig;
            }
            this.bQA = i2;
            this.mDirection = i9;
        }
    }

    protected void ZX() {
        if (this.bPX.isHardwareAccelerated() && (getParent() instanceof View)) {
            ((View) getParent()).invalidate();
        }
    }

    @Override // android.view.ViewTreeObserver.OnTouchModeChangeListener
    public void onTouchModeChanged(boolean z) {
        if (z) {
            aad();
            if (getWidth() > 0 && getChildCount() > 0) {
                layoutChildren();
            }
            ZW();
            return;
        }
        int i2 = this.mTouchMode;
        if (i2 == 5 || i2 == 6) {
            if (this.bQC != null) {
                this.bQC.aak();
            }
            if (this.bQD != null) {
                this.bQD.stop();
            }
            if (getScrollX() != 0) {
                this.bPX.setScrollX(0);
                aai();
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
        if (this.bQD != null) {
            this.bQD.stop();
        }
        if (this.bRm) {
            int action = motionEvent.getAction();
            ZZ();
            this.mVelocityTracker.addMovement(motionEvent);
            switch (action & MotionEventCompat.ACTION_MASK) {
                case 0:
                    switch (this.mTouchMode) {
                        case 6:
                            this.bQC.aak();
                            if (this.bQD != null) {
                                this.bQD.stop();
                            }
                            this.mTouchMode = 5;
                            this.bQz = (int) motionEvent.getY();
                            int x = (int) motionEvent.getX();
                            this.bQA = x;
                            this.bQy = x;
                            this.bQB = 0;
                            this.mActivePointerId = motionEvent.getPointerId(0);
                            this.mDirection = 0;
                            break;
                        default:
                            this.mActivePointerId = motionEvent.getPointerId(0);
                            int x2 = (int) motionEvent.getX();
                            int y = (int) motionEvent.getY();
                            int pointToPosition = pointToPosition(x2, y);
                            if (!this.aaG) {
                                if (this.mTouchMode != 4 && pointToPosition >= 0 && getAdapter().isEnabled(pointToPosition)) {
                                    this.mTouchMode = 0;
                                    if (this.bQO == null) {
                                        this.bQO = new d();
                                    }
                                    postDelayed(this.bQO, ViewConfiguration.getTapTimeout());
                                    i2 = pointToPosition;
                                } else if (this.mTouchMode == 4) {
                                    aab();
                                    this.mTouchMode = 3;
                                    this.bQB = 0;
                                    i2 = mo18if(x2);
                                    this.bQC.aal();
                                }
                                if (i2 >= 0) {
                                    this.bQw = getChildAt(i2 - this.bSe).getLeft();
                                }
                                this.bQy = x2;
                                this.bQz = y;
                                this.bQv = i2;
                                this.bQA = ExploreByTouchHelper.INVALID_ID;
                                break;
                            }
                            i2 = pointToPosition;
                            if (i2 >= 0) {
                            }
                            this.bQy = x2;
                            this.bQz = y;
                            this.bQv = i2;
                            this.bQA = ExploreByTouchHelper.INVALID_ID;
                    }
                    if (h(motionEvent) && this.mTouchMode == 0) {
                        removeCallbacks(this.bQO);
                        break;
                    }
                    break;
                case 1:
                    switch (this.mTouchMode) {
                        case 0:
                        case 1:
                        case 2:
                            int i3 = this.bQv;
                            View childAt = getChildAt(i3 - this.bSe);
                            float x3 = motionEvent.getX();
                            boolean z = x3 > ((float) this.bQp.left) && x3 < ((float) (getWidth() - this.bQp.right));
                            if (childAt != null && !childAt.hasFocusable() && z) {
                                if (this.mTouchMode != 0) {
                                    childAt.setPressed(false);
                                }
                                if (this.bQQ == null) {
                                    this.bQQ = new i(this, null);
                                }
                                i iVar = this.bQQ;
                                iVar.bRE = i3;
                                iVar.aar();
                                this.bQJ = i3;
                                if (this.mTouchMode == 0 || this.mTouchMode == 1) {
                                    Handler handler = getHandler();
                                    if (handler != null) {
                                        handler.removeCallbacks(this.mTouchMode == 0 ? this.bQO : this.bQN);
                                    }
                                    this.bQe = 0;
                                    if (!this.aaG && this.mAdapter.isEnabled(i3)) {
                                        this.mTouchMode = 1;
                                        setSelectedPositionInt(this.bQv);
                                        layoutChildren();
                                        childAt.setPressed(true);
                                        b(this.bQv, childAt);
                                        setPressed(true);
                                        if (this.xQ != null && (current = this.xQ.getCurrent()) != null && (current instanceof TransitionDrawable)) {
                                            ((TransitionDrawable) current).resetTransition();
                                        }
                                        if (this.bQR != null) {
                                            removeCallbacks(this.bQR);
                                        }
                                        this.bQR = new com.baidu.tieba.horizonalList.widget.a(this, childAt, iVar);
                                        postDelayed(this.bQR, ViewConfiguration.getPressedStateDuration());
                                    } else {
                                        this.mTouchMode = -1;
                                        ZW();
                                    }
                                    return true;
                                } else if (!this.aaG && this.mAdapter.isEnabled(i3)) {
                                    iVar.run();
                                }
                            }
                            this.mTouchMode = -1;
                            ZW();
                            break;
                        case 3:
                            int childCount = getChildCount();
                            if (childCount > 0) {
                                int left = getChildAt(0).getLeft();
                                int right = getChildAt(childCount - 1).getRight();
                                int i4 = this.bQp.left;
                                int width = getWidth() - this.bQp.right;
                                if (this.bSe == 0 && left >= i4 && this.bSe + childCount < this.bSr && right <= getWidth() - width) {
                                    this.mTouchMode = -1;
                                    id(0);
                                    break;
                                } else {
                                    VelocityTracker velocityTracker = this.mVelocityTracker;
                                    velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                                    int xVelocity = (int) (velocityTracker.getXVelocity(this.mActivePointerId) * this.bQY);
                                    if (Math.abs(xVelocity) > this.mMinimumVelocity && ((this.bSe != 0 || left != i4 - this.bRa) && (childCount + this.bSe != this.bSr || right != this.bRa + width))) {
                                        if (this.bQC == null) {
                                            this.bQC = new e();
                                        }
                                        id(2);
                                        this.bQC.ih(-xVelocity);
                                        break;
                                    } else {
                                        this.mTouchMode = -1;
                                        id(0);
                                        if (this.bQC != null) {
                                            this.bQC.aak();
                                        }
                                        if (this.bQD != null) {
                                            this.bQD.stop();
                                            break;
                                        }
                                    }
                                }
                            } else {
                                this.mTouchMode = -1;
                                id(0);
                                break;
                            }
                            break;
                        case 5:
                            if (this.bQC == null) {
                                this.bQC = new e();
                            }
                            VelocityTracker velocityTracker2 = this.mVelocityTracker;
                            velocityTracker2.computeCurrentVelocity(1000, this.mMaximumVelocity);
                            int xVelocity2 = (int) velocityTracker2.getXVelocity(this.mActivePointerId);
                            id(2);
                            if (Math.abs(xVelocity2) > this.mMinimumVelocity) {
                                this.bQC.ii(-xVelocity2);
                                break;
                            } else {
                                this.bQC.aaj();
                                break;
                            }
                    }
                    setPressed(false);
                    if (this.bRc != null) {
                        this.bRc.onRelease();
                        this.bRd.onRelease();
                    }
                    invalidate();
                    Handler handler2 = getHandler();
                    if (handler2 != null) {
                        handler2.removeCallbacks(this.bQN);
                    }
                    aaa();
                    this.mActivePointerId = -1;
                    break;
                case 2:
                    int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                    if (findPointerIndex == -1) {
                        this.mActivePointerId = motionEvent.getPointerId(0);
                        findPointerIndex = 0;
                    }
                    int x4 = (int) motionEvent.getX(findPointerIndex);
                    if (this.aaG) {
                        layoutChildren();
                    }
                    switch (this.mTouchMode) {
                        case 0:
                        case 1:
                        case 2:
                            ib(x4);
                            break;
                        case 3:
                        case 5:
                            ic(x4);
                            break;
                    }
                case 3:
                    switch (this.mTouchMode) {
                        case 5:
                            if (this.bQC == null) {
                                this.bQC = new e();
                            }
                            this.bQC.aaj();
                            break;
                        case 6:
                            break;
                        default:
                            this.mTouchMode = -1;
                            setPressed(false);
                            View childAt2 = getChildAt(this.bQv - this.bSe);
                            if (childAt2 != null) {
                                childAt2.setPressed(false);
                            }
                            aac();
                            Handler handler3 = getHandler();
                            if (handler3 != null) {
                                handler3.removeCallbacks(this.bQN);
                            }
                            aaa();
                            break;
                    }
                    if (this.bRc != null) {
                        this.bRc.onRelease();
                        this.bRd.onRelease();
                    }
                    this.mActivePointerId = -1;
                    break;
                case 5:
                    int actionIndex = motionEvent.getActionIndex();
                    int pointerId = motionEvent.getPointerId(actionIndex);
                    int x5 = (int) motionEvent.getX(actionIndex);
                    int y2 = (int) motionEvent.getY(actionIndex);
                    this.bQB = 0;
                    this.mActivePointerId = pointerId;
                    this.bQy = x5;
                    this.bQz = y2;
                    int pointToPosition2 = pointToPosition(x5, y2);
                    if (pointToPosition2 >= 0) {
                        this.bQw = getChildAt(pointToPosition2 - this.bSe).getLeft();
                        this.bQv = pointToPosition2;
                    }
                    this.bQA = x5;
                    break;
                case 6:
                    onSecondaryPointerUp(motionEvent);
                    int i5 = this.bQy;
                    int pointToPosition3 = pointToPosition(i5, this.bQz);
                    if (pointToPosition3 >= 0) {
                        this.bQw = getChildAt(pointToPosition3 - this.bSe).getLeft();
                        this.bQv = pointToPosition3;
                    }
                    this.bQA = i5;
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
            this.bPX.setScrollX(i2);
            ZX();
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
                            if (!ad(horizontalScrollFactor, horizontalScrollFactor)) {
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
        if (this.bRr == 0.0f) {
            TypedValue typedValue = new TypedValue();
            if (getContext().getTheme().resolveAttribute(t.c.hlv_listPreferredItemWidth, typedValue, true)) {
                this.bRr = typedValue.getDimension(getContext().getResources().getDisplayMetrics());
            } else {
                throw new IllegalStateException("Expected theme to define hlv_listPreferredItemWidth.");
            }
        }
        return this.bRr;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.bRc != null) {
            int scrollX = getScrollX();
            if (!this.bRc.isFinished()) {
                int save = canvas.save();
                int i2 = this.bQp.top + this.bRh;
                int height = (getHeight() - i2) - (this.bQp.bottom + this.bRi);
                int min = Math.min(0, this.bRe + scrollX);
                canvas.rotate(-90.0f);
                canvas.translate(i2 + (-getHeight()), min);
                this.bRc.setSize(height, height);
                if (this.bRc.draw(canvas)) {
                    invalidate();
                }
                canvas.restoreToCount(save);
            }
            if (!this.bRd.isFinished()) {
                int save2 = canvas.save();
                int i3 = this.bQp.left + this.bRh;
                int height2 = (getHeight() - i3) - (this.bQp.right + this.bRi);
                int max = Math.max(getWidth(), scrollX + this.bRf);
                canvas.rotate(90.0f);
                canvas.translate(-i3, -max);
                this.bRd.setSize(height2, height2);
                if (this.bRd.draw(canvas)) {
                    invalidate();
                }
                canvas.restoreToCount(save2);
            }
        }
    }

    private void ZY() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        } else {
            this.mVelocityTracker.clear();
        }
    }

    private void ZZ() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
    }

    private void aaa() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            aaa();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.bQD != null) {
            this.bQD.stop();
        }
        if (this.bRm) {
            switch (action & MotionEventCompat.ACTION_MASK) {
                case 0:
                    int i2 = this.mTouchMode;
                    if (i2 == 6 || i2 == 5) {
                        this.bQB = 0;
                        return true;
                    }
                    int x = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();
                    this.mActivePointerId = motionEvent.getPointerId(0);
                    int mo18if = mo18if(x);
                    if (i2 != 4 && mo18if >= 0) {
                        this.bQw = getChildAt(mo18if - this.bSe).getLeft();
                        this.bQy = x;
                        this.bQz = y;
                        this.bQv = mo18if;
                        this.mTouchMode = 0;
                        aac();
                    }
                    this.bQA = ExploreByTouchHelper.INVALID_ID;
                    ZY();
                    this.mVelocityTracker.addMovement(motionEvent);
                    return i2 == 4;
                case 1:
                case 3:
                    this.mTouchMode = -1;
                    this.mActivePointerId = -1;
                    aaa();
                    id(0);
                    return false;
                case 2:
                    switch (this.mTouchMode) {
                        case 0:
                            int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                            if (findPointerIndex == -1) {
                                this.mActivePointerId = motionEvent.getPointerId(0);
                                findPointerIndex = 0;
                            }
                            ZZ();
                            this.mVelocityTracker.addMovement(motionEvent);
                            return ib((int) motionEvent.getX(findPointerIndex));
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
            this.bQy = (int) motionEvent.getX(i2);
            this.bQz = (int) motionEvent.getY(i2);
            this.bQB = 0;
            this.mActivePointerId = motionEvent.getPointerId(i2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        int childCount = getChildCount();
        int i2 = this.bSe;
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
    public void id(int i2) {
        if (i2 != this.bQV && this.bQG != null) {
            this.bQV = i2;
            this.bQG.a(this, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e implements Runnable {
        private final o bRv;
        private int bRw;
        private final Runnable bRx = new com.baidu.tieba.horizonalList.widget.c(this);

        e() {
            this.bRv = new o(AbsHListView.this.getContext());
        }

        void ih(int i) {
            int i2 = i < 0 ? Integer.MAX_VALUE : 0;
            this.bRw = i2;
            this.bRv.setInterpolator(null);
            this.bRv.fling(i2, 0, i, 0, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
            AbsHListView.this.mTouchMode = 4;
            AbsHListView.this.bPX.e(this);
        }

        void aaj() {
            if (this.bRv.springBack(AbsHListView.this.getScrollX(), 0, 0, 0, 0, 0)) {
                AbsHListView.this.mTouchMode = 6;
                AbsHListView.this.invalidate();
                AbsHListView.this.bPX.e(this);
                return;
            }
            AbsHListView.this.mTouchMode = -1;
            AbsHListView.this.id(0);
        }

        void ii(int i) {
            this.bRv.setInterpolator(null);
            this.bRv.fling(AbsHListView.this.getScrollX(), 0, i, 0, ExploreByTouchHelper.INVALID_ID, Integer.MAX_VALUE, 0, 0, AbsHListView.this.getWidth(), 0);
            AbsHListView.this.mTouchMode = 6;
            AbsHListView.this.invalidate();
            AbsHListView.this.bPX.e(this);
        }

        void ij(int i) {
            this.bRv.notifyHorizontalEdgeReached(AbsHListView.this.getScrollX(), 0, AbsHListView.this.bRb);
            int overScrollMode = AbsHListView.this.getOverScrollMode();
            if (overScrollMode == 0 || (overScrollMode == 1 && !AbsHListView.this.ZN())) {
                AbsHListView.this.mTouchMode = 6;
                int currVelocity = (int) this.bRv.getCurrVelocity();
                if (i > 0) {
                    AbsHListView.this.bRc.onAbsorb(currVelocity);
                } else {
                    AbsHListView.this.bRd.onAbsorb(currVelocity);
                }
            } else {
                AbsHListView.this.mTouchMode = -1;
                if (AbsHListView.this.bQD != null) {
                    AbsHListView.this.bQD.stop();
                }
            }
            AbsHListView.this.invalidate();
            AbsHListView.this.bPX.e(this);
        }

        void d(int i, int i2, boolean z) {
            int i3 = i < 0 ? Integer.MAX_VALUE : 0;
            this.bRw = i3;
            this.bRv.setInterpolator(z ? AbsHListView.bRo : null);
            this.bRv.startScroll(i3, 0, i, 0, i2);
            AbsHListView.this.mTouchMode = 4;
            AbsHListView.this.bPX.e(this);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void aak() {
            AbsHListView.this.mTouchMode = -1;
            AbsHListView.this.removeCallbacks(this);
            AbsHListView.this.removeCallbacks(this.bRx);
            AbsHListView.this.id(0);
            AbsHListView.this.aac();
            this.bRv.abortAnimation();
            AbsHListView.this.overScrollBy(0, 0, 0, 0, 0, 0, 0, 0, false);
        }

        void aal() {
            AbsHListView.this.postDelayed(this.bRx, 40L);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // java.lang.Runnable
        public void run() {
            int max;
            boolean z = true;
            boolean z2 = false;
            switch (AbsHListView.this.mTouchMode) {
                case 3:
                    if (this.bRv.isFinished()) {
                        return;
                    }
                    break;
                case 4:
                    break;
                case 5:
                default:
                    aak();
                    return;
                case 6:
                    o oVar = this.bRv;
                    if (oVar.computeScrollOffset()) {
                        int scrollX = AbsHListView.this.getScrollX();
                        int currX = oVar.getCurrX();
                        if (AbsHListView.this.overScrollBy(currX - scrollX, 0, scrollX, 0, 0, 0, AbsHListView.this.bRb, 0, false)) {
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
                                ih(currVelocity);
                                return;
                            }
                            aaj();
                            return;
                        }
                        AbsHListView.this.invalidate();
                        AbsHListView.this.bPX.e(this);
                        return;
                    }
                    aak();
                    return;
            }
            if (AbsHListView.this.aaG) {
                AbsHListView.this.layoutChildren();
            }
            if (AbsHListView.this.bSr == 0 || AbsHListView.this.getChildCount() == 0) {
                aak();
                return;
            }
            o oVar2 = this.bRv;
            boolean computeScrollOffset = oVar2.computeScrollOffset();
            int currX2 = oVar2.getCurrX();
            int i = this.bRw - currX2;
            if (i > 0) {
                AbsHListView.this.bQv = AbsHListView.this.bSe;
                AbsHListView.this.bQw = AbsHListView.this.getChildAt(0).getLeft();
                max = Math.min(((AbsHListView.this.getWidth() - AbsHListView.this.getPaddingRight()) - AbsHListView.this.getPaddingLeft()) - 1, i);
            } else {
                int childCount = AbsHListView.this.getChildCount() - 1;
                AbsHListView.this.bQv = AbsHListView.this.bSe + childCount;
                AbsHListView.this.bQw = AbsHListView.this.getChildAt(childCount).getLeft();
                max = Math.max(-(((AbsHListView.this.getWidth() - AbsHListView.this.getPaddingRight()) - AbsHListView.this.getPaddingLeft()) - 1), i);
            }
            View childAt = AbsHListView.this.getChildAt(AbsHListView.this.bQv - AbsHListView.this.bSe);
            int left = childAt != null ? childAt.getLeft() : 0;
            boolean ad = AbsHListView.this.ad(max, max);
            if (!ad || max == 0) {
                z = false;
            }
            if (z) {
                if (childAt != null) {
                    AbsHListView.this.overScrollBy(-(max - (childAt.getLeft() - left)), 0, AbsHListView.this.getScrollX(), 0, 0, 0, AbsHListView.this.bRb, 0, false);
                }
                if (computeScrollOffset) {
                    ij(max);
                }
            } else if (computeScrollOffset && !z) {
                if (ad) {
                    AbsHListView.this.invalidate();
                }
                this.bRw = currX2;
                AbsHListView.this.bPX.e(this);
            } else {
                aak();
            }
        }
    }

    /* loaded from: classes.dex */
    public class j implements Runnable {
        private int bRF;
        private int bRG;
        private int bRH;
        private int bRI;
        private final int bRJ;
        private int bRK;
        private int mMode;

        j() {
            this.bRJ = ViewConfiguration.get(AbsHListView.this.getContext()).getScaledFadingEdgeLength();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void ih(int i) {
            int i2;
            stop();
            if (AbsHListView.this.aaG) {
                AbsHListView.this.bQX = new com.baidu.tieba.horizonalList.widget.d(this, i);
                return;
            }
            int childCount = AbsHListView.this.getChildCount();
            if (childCount != 0) {
                int i3 = AbsHListView.this.bSe;
                int i4 = (childCount + i3) - 1;
                int max = Math.max(0, Math.min(AbsHListView.this.getCount() - 1, i));
                if (max < i3) {
                    i2 = (i3 - max) + 1;
                    this.mMode = 2;
                } else if (max > i4) {
                    i2 = (max - i4) + 1;
                    this.mMode = 1;
                } else {
                    q(max, -1, 200);
                    return;
                }
                if (i2 > 0) {
                    this.bRI = 200 / i2;
                } else {
                    this.bRI = 200;
                }
                this.bRF = max;
                this.bRG = -1;
                this.bRH = -1;
                AbsHListView.this.bPX.e(this);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void af(int i, int i2) {
            int i3;
            stop();
            if (i2 == -1) {
                ih(i);
            } else if (AbsHListView.this.aaG) {
                AbsHListView.this.bQX = new com.baidu.tieba.horizonalList.widget.e(this, i, i2);
            } else {
                int childCount = AbsHListView.this.getChildCount();
                if (childCount != 0) {
                    int i4 = AbsHListView.this.bSe;
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
                        q(max, i2, 200);
                        return;
                    }
                    if (i3 > 0) {
                        this.bRI = 200 / i3;
                    } else {
                        this.bRI = 200;
                    }
                    this.bRF = max;
                    this.bRG = i2;
                    this.bRH = -1;
                    AbsHListView.this.bPX.e(this);
                }
            }
        }

        void q(int i, int i2, int i3) {
            int i4 = AbsHListView.this.bSe;
            int childCount = (AbsHListView.this.getChildCount() + i4) - 1;
            int i5 = AbsHListView.this.bQp.left;
            int width = AbsHListView.this.getWidth() - AbsHListView.this.bQp.right;
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
            int i2 = AbsHListView.this.bSe;
            switch (this.mMode) {
                case 1:
                    int childCount = AbsHListView.this.getChildCount() - 1;
                    int i3 = i2 + childCount;
                    if (childCount >= 0) {
                        if (i3 == this.bRH) {
                            AbsHListView.this.bPX.e(this);
                            return;
                        }
                        View childAt = AbsHListView.this.getChildAt(childCount);
                        AbsHListView.this.c((i3 < AbsHListView.this.bSr + (-1) ? Math.max(AbsHListView.this.bQp.right, this.bRJ) : AbsHListView.this.bQp.right) + (childAt.getWidth() - (width - childAt.getLeft())), this.bRI, true);
                        this.bRH = i3;
                        if (i3 < this.bRF) {
                            AbsHListView.this.bPX.e(this);
                            return;
                        }
                        return;
                    }
                    return;
                case 2:
                    if (i2 == this.bRH) {
                        AbsHListView.this.bPX.e(this);
                        return;
                    }
                    View childAt2 = AbsHListView.this.getChildAt(0);
                    if (childAt2 != null) {
                        AbsHListView.this.c(childAt2.getLeft() - (i2 > 0 ? Math.max(this.bRJ, AbsHListView.this.bQp.left) : AbsHListView.this.bQp.left), this.bRI, true);
                        this.bRH = i2;
                        if (i2 > this.bRF) {
                            AbsHListView.this.bPX.e(this);
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    int childCount2 = AbsHListView.this.getChildCount();
                    if (i2 != this.bRG && childCount2 > 1 && childCount2 + i2 < AbsHListView.this.bSr) {
                        int i4 = i2 + 1;
                        if (i4 == this.bRH) {
                            AbsHListView.this.bPX.e(this);
                            return;
                        }
                        View childAt3 = AbsHListView.this.getChildAt(1);
                        int width2 = childAt3.getWidth();
                        int left2 = childAt3.getLeft();
                        int max = Math.max(AbsHListView.this.bQp.right, this.bRJ);
                        if (i4 < this.bRG) {
                            AbsHListView.this.c(Math.max(0, (left2 + width2) - max), this.bRI, true);
                            this.bRH = i4;
                            AbsHListView.this.bPX.e(this);
                            return;
                        } else if (left2 > max) {
                            AbsHListView.this.c(left2 - max, this.bRI, true);
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
                        if (i5 == this.bRH) {
                            AbsHListView.this.bPX.e(this);
                            return;
                        }
                        View childAt4 = AbsHListView.this.getChildAt(childCount3);
                        int width3 = childAt4.getWidth();
                        int left3 = childAt4.getLeft();
                        int i6 = width - left3;
                        int max2 = Math.max(AbsHListView.this.bQp.left, this.bRJ);
                        this.bRH = i5;
                        if (i5 > this.bRG) {
                            AbsHListView.this.c(-(i6 - max2), this.bRI, true);
                            AbsHListView.this.bPX.e(this);
                            return;
                        }
                        int i7 = width - max2;
                        int i8 = left3 + width3;
                        if (i7 > i8) {
                            AbsHListView.this.c(-(i7 - i8), this.bRI, true);
                            return;
                        }
                        return;
                    }
                    return;
                case 5:
                    if (this.bRH == i2) {
                        AbsHListView.this.bPX.e(this);
                        return;
                    }
                    this.bRH = i2;
                    int childCount4 = AbsHListView.this.getChildCount();
                    int i9 = this.bRF;
                    int i10 = (i2 + childCount4) - 1;
                    if (i9 < i2) {
                        i = (i2 - i9) + 1;
                    } else if (i9 > i10) {
                        i = i9 - i10;
                    }
                    float min = Math.min(Math.abs(i / childCount4), 1.0f);
                    if (i9 < i2) {
                        AbsHListView.this.c((int) ((-AbsHListView.this.getWidth()) * min), (int) (min * this.bRI), true);
                        AbsHListView.this.bPX.e(this);
                        return;
                    } else if (i9 > i10) {
                        AbsHListView.this.c((int) (AbsHListView.this.getWidth() * min), (int) (min * this.bRI), true);
                        AbsHListView.this.bPX.e(this);
                        return;
                    } else {
                        AbsHListView.this.c(AbsHListView.this.getChildAt(i9 - i2).getLeft() - this.bRK, (int) (this.bRI * (Math.abs(left) / AbsHListView.this.getWidth())), true);
                        return;
                    }
                default:
                    return;
            }
        }
    }

    public void setFriction(float f2) {
        if (this.bQC == null) {
            this.bQC = new e();
        }
        this.bQC.bRv.setFriction(f2);
    }

    public void setVelocityScale(float f2) {
        this.bQY = f2;
    }

    public void smoothScrollToPosition(int i2, int i3) {
        if (this.bQD == null) {
            this.bQD = new j();
        }
        this.bQD.af(i2, i3);
    }

    public void smoothScrollBy(int i2, int i3) {
        c(i2, i3, false);
    }

    public void c(int i2, int i3, boolean z) {
        if (this.bQC == null) {
            this.bQC = new e();
        }
        int i4 = this.bSe;
        int childCount = getChildCount();
        int i5 = i4 + childCount;
        int paddingLeft = getPaddingLeft();
        int width = getWidth() - getPaddingRight();
        if (i2 == 0 || this.bSr == 0 || childCount == 0 || ((i4 == 0 && getChildAt(0).getLeft() == paddingLeft && i2 < 0) || (i5 == this.bSr && getChildAt(childCount - 1).getRight() == width && i2 > 0))) {
            this.bQC.aak();
            if (this.bQD != null) {
                this.bQD.stop();
                return;
            }
            return;
        }
        id(2);
        this.bQC.d(i2, i3, z);
    }

    private void aab() {
        if (this.mScrollingCacheEnabled && !this.bQt && !this.bPX.isHardwareAccelerated()) {
            setChildrenDrawnWithCacheEnabled(true);
            setChildrenDrawingCacheEnabled(true);
            this.bQu = true;
            this.bQt = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aac() {
        if (!this.bPX.isHardwareAccelerated()) {
            if (this.bQW == null) {
                this.bQW = new com.baidu.tieba.horizonalList.widget.b(this);
            }
            post(this.bQW);
        }
    }

    boolean ad(int i2, int i3) {
        int min;
        int min2;
        int i4;
        int childCount = getChildCount();
        if (childCount == 0) {
            return true;
        }
        int left = getChildAt(0).getLeft();
        int right = getChildAt(childCount - 1).getRight();
        Rect rect = this.bQp;
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
        int i6 = this.bSe;
        if (i6 == 0) {
            this.bRe = left - rect.left;
        } else {
            this.bRe += min2;
        }
        if (i6 + childCount == this.bSr) {
            this.bRf = rect.right + right;
        } else {
            this.bRf += min2;
        }
        boolean z = i6 == 0 && left >= rect.left && min2 >= 0;
        boolean z2 = i6 + childCount == this.bSr && right <= getWidth() - rect.right && min2 <= 0;
        if (z || z2) {
            return min2 != 0;
        }
        boolean z3 = min2 < 0;
        boolean isInTouchMode = isInTouchMode();
        if (isInTouchMode) {
            aad();
        }
        int headerViewsCount = getHeaderViewsCount();
        int footerViewsCount = this.bSr - getFooterViewsCount();
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
                    this.bQk.s(childAt, i11);
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
                    this.bQk.s(childAt2, i14);
                }
                i4 = i13;
                i7 = i12;
            }
        }
        this.bQx = this.bQw + min;
        this.bSz = true;
        if (i4 > 0) {
            detachViewsFromParent(i7, i4);
            this.bQk.aao();
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        ie(min2);
        if (z3) {
            this.bSe = i4 + this.bSe;
        }
        int abs = Math.abs(min2);
        if (i5 < abs || width < abs) {
            dV(z3);
        }
        if (!isInTouchMode && this.bHc != -1) {
            int i15 = this.bHc - this.bSe;
            if (i15 >= 0 && i15 < getChildCount()) {
                b(this.bHc, getChildAt(i15));
            }
        } else if (this.bQi != -1) {
            int i16 = this.bQi - this.bSe;
            if (i16 >= 0 && i16 < getChildCount()) {
                b(-1, getChildAt(i16));
            }
        } else {
            this.bQj.setEmpty();
        }
        this.bSz = false;
        ZO();
        return false;
    }

    public void ie(int i2) {
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
    public void aad() {
        if (this.bHc != -1) {
            if (this.bQe != 4) {
                this.bQJ = this.bHc;
            }
            if (this.bSo >= 0 && this.bSo != this.bHc) {
                this.bQJ = this.bSo;
            }
            setSelectedPositionInt(-1);
            setNextSelectedPositionInt(-1);
            this.bQE = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int aae() {
        int i2 = this.bHc;
        if (i2 < 0) {
            i2 = this.bQJ;
        }
        return Math.min(Math.max(0, i2), this.bSr - 1);
    }

    protected int ig(int i2) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return -1;
        }
        int mo18if = mo18if(i2);
        return mo18if == -1 ? (this.bSe + childCount) - 1 : mo18if;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aaf() {
        if (this.bHc >= 0 || !aag()) {
            return false;
        }
        ZW();
        return true;
    }

    boolean aag() {
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
        int i8 = this.bQp.left;
        int right = (getRight() - getLeft()) - this.bQp.right;
        int i9 = this.bSe;
        int i10 = this.bQJ;
        if (i10 >= i9 && i10 < i9 + childCount) {
            View childAt = getChildAt(i10 - this.bSe);
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
            int i15 = this.bSr;
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
        this.bQJ = -1;
        removeCallbacks(this.bQC);
        if (this.bQD != null) {
            this.bQD.stop();
        }
        this.mTouchMode = -1;
        aac();
        this.bSf = i2;
        int n2 = n(i3, z);
        if (n2 < i9 || n2 > getLastVisiblePosition()) {
            n2 = -1;
        } else {
            this.bQe = 4;
            ZW();
            setSelectionInt(n2);
            ZO();
        }
        id(0);
        return n2 >= 0;
    }

    void aah() {
        int i2;
        boolean z;
        boolean z2;
        this.bQc.clear();
        int i3 = 0;
        boolean z3 = false;
        while (i3 < this.bQd.size()) {
            long keyAt = this.bQd.keyAt(i3);
            int intValue = this.bQd.valueAt(i3).intValue();
            if (keyAt != this.mAdapter.getItemId(intValue)) {
                int max = Math.max(0, intValue - 20);
                int min = Math.min(intValue + 20, this.bSr);
                while (true) {
                    if (max >= min) {
                        z2 = false;
                        break;
                    } else if (keyAt != this.mAdapter.getItemId(max)) {
                        max++;
                    } else {
                        this.bQc.put(max, true);
                        this.bQd.setValueAt(i3, Integer.valueOf(max));
                        z2 = true;
                        break;
                    }
                }
                if (!z2) {
                    this.bQd.delete(keyAt);
                    int i4 = i3 - 1;
                    this.bQb--;
                    if (Build.VERSION.SDK_INT <= 11 || this.bPZ == null || this.bQa == null) {
                        i2 = i4;
                        z = true;
                    } else {
                        ((com.baidu.tieba.horizonalList.a.a.b) this.bQa).onItemCheckedStateChanged((ActionMode) this.bPZ, intValue, keyAt, false);
                        i2 = i4;
                        z = true;
                    }
                    z3 = z;
                    i3 = i2 + 1;
                }
            } else {
                this.bQc.put(intValue, true);
            }
            i2 = i3;
            z = z3;
            z3 = z;
            i3 = i2 + 1;
        }
        if (z3 && this.bPZ != null && Build.VERSION.SDK_INT > 11) {
            ((ActionMode) this.bPZ).invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.g
    public void handleDataChanged() {
        int i2 = this.bSr;
        int i3 = this.bRn;
        this.bRn = this.bSr;
        if (this.bPY != 0 && this.mAdapter != null && this.mAdapter.hasStableIds()) {
            aah();
        }
        this.bQk.aan();
        if (i2 > 0) {
            if (this.bSj) {
                this.bSj = false;
                this.bRp = null;
                if (this.bQS == 2) {
                    this.bQe = 3;
                    return;
                }
                if (this.bQS == 1) {
                    if (this.bRg) {
                        this.bRg = false;
                        this.bQe = 3;
                        return;
                    }
                    int childCount = getChildCount();
                    int width = getWidth() - getPaddingRight();
                    View childAt = getChildAt(childCount - 1);
                    int bottom = childAt != null ? childAt.getBottom() : width;
                    if (childCount + this.bSe >= i3 && bottom <= width) {
                        this.bQe = 3;
                        return;
                    }
                    awakenScrollBars();
                }
                switch (this.bSk) {
                    case 1:
                        this.bQe = 5;
                        this.bSg = Math.min(Math.max(0, this.bSg), i2 - 1);
                        return;
                    case 0:
                        if (isInTouchMode()) {
                            this.bQe = 5;
                            this.bSg = Math.min(Math.max(0, this.bSg), i2 - 1);
                            return;
                        }
                        int aaz = aaz();
                        if (aaz >= 0 && n(aaz, true) == aaz) {
                            this.bSg = aaz;
                            if (this.bSi == getWidth()) {
                                this.bQe = 5;
                            } else {
                                this.bQe = 2;
                            }
                            setNextSelectedPositionInt(aaz);
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
                int n2 = n(selectedItemPosition, true);
                if (n2 >= 0) {
                    setNextSelectedPositionInt(n2);
                    return;
                }
                int n3 = n(selectedItemPosition, false);
                if (n3 >= 0) {
                    setNextSelectedPositionInt(n3);
                    return;
                }
            } else if (this.bQJ >= 0) {
                return;
            }
        }
        this.bQe = this.bQF ? 3 : 1;
        this.bHc = -1;
        this.bSq = Long.MIN_VALUE;
        this.bSo = -1;
        this.bSp = Long.MIN_VALUE;
        this.bSj = false;
        this.bRp = null;
        this.bQi = -1;
        aay();
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
        this.bQS = i2;
    }

    public int getTranscriptMode() {
        return this.bQS;
    }

    @Override // android.view.View
    public int getSolidColor() {
        return this.bQT;
    }

    public void setCacheColorHint(int i2) {
        if (i2 != this.bQT) {
            this.bQT = i2;
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                getChildAt(i3).setDrawingCacheBackgroundColor(i2);
            }
            this.bQk.setCacheColorHint(i2);
        }
    }

    @ViewDebug.ExportedProperty(category = "drawing")
    public int getCacheColorHint() {
        return this.bQT;
    }

    private void aai() {
        if (this.bRc != null) {
            this.bRc.finish();
            this.bRd.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ae(int i2, int i3) {
    }

    public void setRecyclerListener(l lVar) {
        this.bQk.bRN = lVar;
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
        public boolean bRA;
        public boolean bRB;
        public int bRC;
        public long bRD;
        public int bRz;

        public f(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.bRD = -1L;
        }

        public f(int i, int i2, int i3) {
            super(i, i2);
            this.bRD = -1L;
            this.bRz = i3;
        }

        public f(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.bRD = -1L;
        }
    }

    /* loaded from: classes.dex */
    public class k {
        private l bRN;
        private int bRO;
        private View[] bRP = new View[0];
        private ArrayList<View>[] bRQ;
        private int bRR;
        private ArrayList<View> bRS;
        private ArrayList<View> bRT;
        private SparseArrayCompat<View> bRU;

        public k() {
        }

        public void ik(int i) {
            if (i < 1) {
                throw new IllegalArgumentException("Can't have a viewTypeCount < 1");
            }
            ArrayList<View>[] arrayListArr = new ArrayList[i];
            for (int i2 = 0; i2 < i; i2++) {
                arrayListArr[i2] = new ArrayList<>();
            }
            this.bRR = i;
            this.bRS = arrayListArr[0];
            this.bRQ = arrayListArr;
        }

        public void aam() {
            if (this.bRR == 1) {
                ArrayList<View> arrayList = this.bRS;
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    arrayList.get(i).forceLayout();
                }
            } else {
                int i2 = this.bRR;
                for (int i3 = 0; i3 < i2; i3++) {
                    ArrayList<View> arrayList2 = this.bRQ[i3];
                    int size2 = arrayList2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        arrayList2.get(i4).forceLayout();
                    }
                }
            }
            if (this.bRU != null) {
                int size3 = this.bRU.size();
                for (int i5 = 0; i5 < size3; i5++) {
                    this.bRU.valueAt(i5).forceLayout();
                }
            }
        }

        public boolean il(int i) {
            return i >= 0;
        }

        public void clear() {
            if (this.bRR == 1) {
                ArrayList<View> arrayList = this.bRS;
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    AbsHListView.this.removeDetachedView(arrayList.remove((size - 1) - i), false);
                }
            } else {
                int i2 = this.bRR;
                for (int i3 = 0; i3 < i2; i3++) {
                    ArrayList<View> arrayList2 = this.bRQ[i3];
                    int size2 = arrayList2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        AbsHListView.this.removeDetachedView(arrayList2.remove((size2 - 1) - i4), false);
                    }
                }
            }
            if (this.bRU != null) {
                this.bRU.clear();
            }
        }

        public void ag(int i, int i2) {
            if (this.bRP.length < i) {
                this.bRP = new View[i];
            }
            this.bRO = i2;
            View[] viewArr = this.bRP;
            for (int i3 = 0; i3 < i; i3++) {
                View childAt = AbsHListView.this.getChildAt(i3);
                f fVar = (f) childAt.getLayoutParams();
                if (fVar != null && fVar.bRz != -2) {
                    viewArr[i3] = childAt;
                }
            }
        }

        public View im(int i) {
            int i2 = i - this.bRO;
            View[] viewArr = this.bRP;
            if (i2 < 0 || i2 >= viewArr.length) {
                return null;
            }
            View view = viewArr[i2];
            viewArr[i2] = null;
            return view;
        }

        View in(int i) {
            int indexOfKey;
            if (this.bRU != null && (indexOfKey = this.bRU.indexOfKey(i)) >= 0) {
                View valueAt = this.bRU.valueAt(indexOfKey);
                this.bRU.removeAt(indexOfKey);
                return valueAt;
            }
            return null;
        }

        void aan() {
            if (this.bRU != null) {
                this.bRU.clear();
            }
        }

        View io(int i) {
            if (this.bRR == 1) {
                return AbsHListView.a(this.bRS, i);
            }
            int itemViewType = AbsHListView.this.mAdapter.getItemViewType(i);
            if (itemViewType >= 0 && itemViewType < this.bRQ.length) {
                return AbsHListView.a(this.bRQ[itemViewType], i);
            }
            return null;
        }

        public void s(View view, int i) {
            f fVar = (f) view.getLayoutParams();
            if (fVar != null) {
                fVar.bRC = i;
                int i2 = fVar.bRz;
                if (!il(i2)) {
                    if (i2 != -2) {
                        if (this.bRT == null) {
                            this.bRT = new ArrayList<>();
                        }
                        this.bRT.add(view);
                        return;
                    }
                    return;
                }
                view.onStartTemporaryDetach();
                if (this.bRR == 1) {
                    this.bRS.add(view);
                } else {
                    this.bRQ[i2].add(view);
                }
                if (Build.VERSION.SDK_INT >= 14) {
                    view.setAccessibilityDelegate(null);
                }
                if (this.bRN != null) {
                    this.bRN.onMovedToScrapHeap(view);
                }
            }
        }

        public void aao() {
            if (this.bRT != null) {
                int size = this.bRT.size();
                for (int i = 0; i < size; i++) {
                    AbsHListView.this.removeDetachedView(this.bRT.get(i), false);
                }
                this.bRT.clear();
            }
        }

        public void aap() {
            View[] viewArr = this.bRP;
            boolean z = this.bRN != null;
            boolean z2 = this.bRR > 1;
            ArrayList<View> arrayList = this.bRS;
            for (int length = viewArr.length - 1; length >= 0; length--) {
                View view = viewArr[length];
                if (view != null) {
                    f fVar = (f) view.getLayoutParams();
                    int i = fVar.bRz;
                    viewArr[length] = null;
                    if (!il(i)) {
                        if (i != -2) {
                            AbsHListView.this.removeDetachedView(view, false);
                        }
                    } else {
                        if (z2) {
                            arrayList = this.bRQ[i];
                        }
                        view.onStartTemporaryDetach();
                        fVar.bRC = this.bRO + length;
                        arrayList.add(view);
                        if (Build.VERSION.SDK_INT >= 14) {
                            view.setAccessibilityDelegate(null);
                        }
                        if (z) {
                            this.bRN.onMovedToScrapHeap(view);
                        }
                    }
                }
            }
            aaq();
        }

        private void aaq() {
            int length = this.bRP.length;
            int i = this.bRR;
            ArrayList<View>[] arrayListArr = this.bRQ;
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
            if (this.bRU != null) {
                for (int i6 = 0; i6 < this.bRU.size(); i6++) {
                    this.bRU.valueAt(i6);
                }
            }
        }

        void setCacheColorHint(int i) {
            View[] viewArr;
            if (this.bRR == 1) {
                ArrayList<View> arrayList = this.bRS;
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    arrayList.get(i2).setDrawingCacheBackgroundColor(i);
                }
            } else {
                int i3 = this.bRR;
                for (int i4 = 0; i4 < i3; i4++) {
                    ArrayList<View> arrayList2 = this.bRQ[i4];
                    int size2 = arrayList2.size();
                    for (int i5 = 0; i5 < size2; i5++) {
                        arrayList2.get(i5).setDrawingCacheBackgroundColor(i);
                    }
                }
            }
            for (View view : this.bRP) {
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
                if (((f) view.getLayoutParams()).bRC == i2) {
                    arrayList.remove(i3);
                    return view;
                }
            }
            return arrayList.remove(size - 1);
        }
        return null;
    }
}
