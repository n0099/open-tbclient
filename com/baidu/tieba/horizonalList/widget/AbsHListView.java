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
    static final Interpolator cDw = new LinearInterpolator();
    public static final int[] cDy = new int[1];
    Drawable HJ;
    protected boolean cCA;
    protected boolean cCB;
    protected int cCC;
    int cCD;
    int cCE;
    int cCF;
    int cCG;
    protected int cCH;
    int cCI;
    int cCJ;
    private e cCK;
    protected j cCL;
    protected int cCM;
    protected boolean cCN;
    private h cCO;
    private boolean cCP;
    private Rect cCQ;
    protected int cCR;
    private ContextMenu.ContextMenuInfo cCS;
    protected int cCT;
    private int cCU;
    private c cCV;
    private Runnable cCW;
    private b cCX;
    private i cCY;
    private Runnable cCZ;
    a.AbstractC0063a cCe;
    protected int cCf;
    public Object cCg;
    Object cCh;
    int cCi;
    protected SparseArrayCompat<Boolean> cCj;
    LongSparseArray<Integer> cCk;
    protected int cCl;
    protected a cCm;
    boolean cCn;
    boolean cCo;
    int cCp;
    protected Rect cCq;
    protected final k cCr;
    int cCs;
    int cCt;
    int cCu;
    int cCv;
    protected Rect cCw;
    protected int cCx;
    View cCy;
    View cCz;
    private int cDa;
    private int cDb;
    private boolean cDc;
    private int cDd;
    private Runnable cDe;
    protected Runnable cDf;
    private float cDg;
    protected final boolean[] cDh;
    int cDi;
    int cDj;
    private EdgeEffectCompat cDk;
    private EdgeEffectCompat cDl;
    private int cDm;
    private int cDn;
    private boolean cDo;
    private int cDp;
    private int cDq;
    private g cDr;
    private int cDs;
    private int cDt;
    protected boolean cDu;
    private int cDv;
    private SavedState cDx;
    private float cDz;
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

    protected abstract int kb(int i2);

    public abstract void setSelectionInt(int i2);

    public AbsHListView(Context context) {
        super(context);
        this.cCf = 0;
        this.cCl = 0;
        this.cCo = false;
        this.cCp = -1;
        this.cCq = new Rect();
        this.cCr = new k();
        this.cCs = 0;
        this.cCt = 0;
        this.cCu = 0;
        this.cCv = 0;
        this.cCw = new Rect();
        this.cCx = 0;
        this.cCH = -1;
        this.cCM = 0;
        this.cCP = true;
        this.cCR = -1;
        this.cCS = null;
        this.cCU = -1;
        this.cDd = 0;
        this.cDg = 1.0f;
        this.cDh = new boolean[1];
        this.mActivePointerId = -1;
        this.mDirection = 0;
        akh();
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
        this.cCf = 0;
        this.cCl = 0;
        this.cCo = false;
        this.cCp = -1;
        this.cCq = new Rect();
        this.cCr = new k();
        this.cCs = 0;
        this.cCt = 0;
        this.cCu = 0;
        this.cCv = 0;
        this.cCw = new Rect();
        this.cCx = 0;
        this.cCH = -1;
        this.cCM = 0;
        this.cCP = true;
        this.cCR = -1;
        this.cCS = null;
        this.cCU = -1;
        this.cDd = 0;
        this.cDg = 1.0f;
        this.cDh = new boolean[1];
        this.mActivePointerId = -1;
        this.mDirection = 0;
        akh();
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
        this.cCo = z3;
        setStackFromRight(z2);
        setScrollingCacheEnabled(z);
        setTranscriptMode(i3);
        setCacheColorHint(i4);
        setSmoothScrollbarEnabled(z4);
        setChoiceMode(i5);
    }

    private void akh() {
        setClickable(true);
        setFocusableInTouchMode(true);
        setWillNotDraw(false);
        setAlwaysDrawnWithCacheEnabled(false);
        setScrollingCacheEnabled(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.cDi = viewConfiguration.getScaledOverscrollDistance();
        this.cDj = viewConfiguration.getScaledOverflingDistance();
        this.cCe = com.baidu.tieba.horizonalList.a.a.ax(this);
    }

    @Override // android.view.View
    public void setOverScrollMode(int i2) {
        if (i2 != 2) {
            if (this.cDk == null) {
                Context context = getContext();
                this.cDk = new EdgeEffectCompat(context);
                this.cDl = new EdgeEffectCompat(context);
            }
        } else {
            this.cDk = null;
            this.cDl = null;
        }
        super.setOverScrollMode(i2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.horizonalList.widget.g
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            this.cCn = this.mAdapter.hasStableIds();
            if (this.cCf != 0 && this.cCn && this.cCk == null) {
                this.cCk = new LongSparseArray<>();
            }
        }
        if (this.cCj != null) {
            this.cCj.clear();
        }
        if (this.cCk != null) {
            this.cCk.clear();
        }
    }

    public int getCheckedItemCount() {
        return this.cCi;
    }

    public boolean isItemChecked(int i2) {
        if (this.cCf == 0 || this.cCj == null) {
            return false;
        }
        return this.cCj.get(i2, false).booleanValue();
    }

    public int getCheckedItemPosition() {
        if (this.cCf == 1 && this.cCj != null && this.cCj.size() == 1) {
            return this.cCj.keyAt(0);
        }
        return -1;
    }

    public SparseArrayCompat<Boolean> getCheckedItemPositions() {
        if (this.cCf != 0) {
            return this.cCj;
        }
        return null;
    }

    public long[] getCheckedItemIds() {
        if (this.cCf == 0 || this.cCk == null || this.mAdapter == null) {
            return new long[0];
        }
        LongSparseArray<Integer> longSparseArray = this.cCk;
        int size = longSparseArray.size();
        long[] jArr = new long[size];
        for (int i2 = 0; i2 < size; i2++) {
            jArr[i2] = longSparseArray.keyAt(i2);
        }
        return jArr;
    }

    public void clearChoices() {
        if (this.cCj != null) {
            this.cCj.clear();
        }
        if (this.cCk != null) {
            this.cCk.clear();
        }
        this.cCi = 0;
    }

    public void setItemChecked(int i2, boolean z) {
        if (this.cCf != 0) {
            if (Build.VERSION.SDK_INT >= 11 && z && this.cCf == 3 && this.cCg == null) {
                if (this.cCh == null || !((com.baidu.tieba.horizonalList.a.a.b) this.cCh).akg()) {
                    throw new IllegalStateException("AbsListView: attempted to start selection mode for CHOICE_MODE_MULTIPLE_MODAL but no choice mode callback was supplied. Call setMultiChoiceModeListener to set a callback.");
                }
                this.cCg = startActionMode((com.baidu.tieba.horizonalList.a.a.b) this.cCh);
            }
            if (this.cCf == 2 || (Build.VERSION.SDK_INT >= 11 && this.cCf == 3)) {
                boolean booleanValue = this.cCj.get(i2, false).booleanValue();
                this.cCj.put(i2, Boolean.valueOf(z));
                if (this.cCk != null && this.mAdapter.hasStableIds()) {
                    if (z) {
                        this.cCk.put(this.mAdapter.getItemId(i2), Integer.valueOf(i2));
                    } else {
                        this.cCk.delete(this.mAdapter.getItemId(i2));
                    }
                }
                if (booleanValue != z) {
                    if (z) {
                        this.cCi++;
                    } else {
                        this.cCi--;
                    }
                }
                if (this.cCg != null) {
                    ((com.baidu.tieba.horizonalList.a.a.b) this.cCh).onItemCheckedStateChanged((ActionMode) this.cCg, i2, this.mAdapter.getItemId(i2), z);
                }
            } else {
                boolean z2 = this.cCk != null && this.mAdapter.hasStableIds();
                if (z || isItemChecked(i2)) {
                    this.cCj.clear();
                    if (z2) {
                        this.cCk.clear();
                    }
                }
                if (z) {
                    this.cCj.put(i2, true);
                    if (z2) {
                        this.cCk.put(this.mAdapter.getItemId(i2), Integer.valueOf(i2));
                    }
                    this.cCi = 1;
                } else if (this.cCj.size() == 0 || !this.cCj.valueAt(0).booleanValue()) {
                    this.cCi = 0;
                }
            }
            if (!this.mInLayout && !this.cEH) {
                this.ajc = true;
                akW();
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
        if (this.cCf != 0) {
            if (this.cCf == 2 || (Build.VERSION.SDK_INT >= 11 && this.cCf == 3 && this.cCg != null)) {
                boolean z5 = !this.cCj.get(i2, false).booleanValue();
                this.cCj.put(i2, Boolean.valueOf(z5));
                if (this.cCk != null && this.mAdapter.hasStableIds()) {
                    if (z5) {
                        this.cCk.put(this.mAdapter.getItemId(i2), Integer.valueOf(i2));
                    } else {
                        this.cCk.delete(this.mAdapter.getItemId(i2));
                    }
                }
                if (z5) {
                    this.cCi++;
                } else {
                    this.cCi--;
                }
                if (this.cCg != null) {
                    ((com.baidu.tieba.horizonalList.a.a.b) this.cCh).onItemCheckedStateChanged((ActionMode) this.cCg, i2, j2, z5);
                } else {
                    z4 = true;
                }
                z2 = z4;
                z4 = true;
            } else if (this.cCf == 1) {
                if (!this.cCj.get(i2, false).booleanValue()) {
                    this.cCj.clear();
                    this.cCj.put(i2, true);
                    if (this.cCk != null && this.mAdapter.hasStableIds()) {
                        this.cCk.clear();
                        this.cCk.put(this.mAdapter.getItemId(i2), Integer.valueOf(i2));
                    }
                    this.cCi = 1;
                } else if (this.cCj.size() == 0 || !this.cCj.valueAt(0).booleanValue()) {
                    this.cCi = 0;
                }
                z4 = true;
                z2 = true;
            } else {
                z2 = true;
            }
            if (z4) {
                aki();
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

    private void aki() {
        int i2 = this.cEm;
        int childCount = getChildCount();
        boolean z = Build.VERSION.SDK_INT >= 11;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            int i4 = i2 + i3;
            if (childAt instanceof Checkable) {
                ((Checkable) childAt).setChecked(this.cCj.get(i4, false).booleanValue());
            } else if (z) {
                childAt.setActivated(this.cCj.get(i4, false).booleanValue());
            }
        }
    }

    public int getChoiceMode() {
        return this.cCf;
    }

    public void setChoiceMode(int i2) {
        this.cCf = i2;
        if (Build.VERSION.SDK_INT >= 11 && this.cCg != null) {
            if (Build.VERSION.SDK_INT >= 11) {
                ((ActionMode) this.cCg).finish();
            }
            this.cCg = null;
        }
        if (this.cCf != 0) {
            if (this.cCj == null) {
                this.cCj = new SparseArrayCompat<>();
            }
            if (this.cCk == null && this.mAdapter != null && this.mAdapter.hasStableIds()) {
                this.cCk = new LongSparseArray<>();
            }
            if (Build.VERSION.SDK_INT >= 11 && this.cCf == 3) {
                clearChoices();
                setLongClickable(true);
            }
        }
    }

    public void setMultiChoiceModeListener(com.baidu.tieba.horizonalList.a.a.a aVar) {
        if (Build.VERSION.SDK_INT >= 11) {
            if (this.cCh == null) {
                this.cCh = new com.baidu.tieba.horizonalList.a.a.b(this);
            }
            ((com.baidu.tieba.horizonalList.a.a.b) this.cCh).a(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean akj() {
        int childCount = getChildCount();
        if (childCount == 0) {
            return true;
        }
        if (childCount != this.cEz) {
            return false;
        }
        return getChildAt(0).getLeft() >= this.cCw.left && getChildAt(childCount + (-1)).getRight() <= getWidth() - this.cCw.right;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public int getHorizontalScrollbarHeight() {
        return super.getHorizontalScrollbarHeight();
    }

    public void setSmoothScrollbarEnabled(boolean z) {
        this.cCP = z;
    }

    public void setOnScrollListener(h hVar) {
        this.cCO = hVar;
        akk();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void akk() {
        if (this.cCO != null) {
            this.cCO.a(this, this.cEm, getChildCount(), this.cEz);
        }
        onScrollChanged(0, 0, 0, 0);
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEvent(int i2) {
        if (i2 == 4096) {
            int firstVisiblePosition = getFirstVisiblePosition();
            int lastVisiblePosition = getLastVisiblePosition();
            if (this.cDs != firstVisiblePosition || this.cDt != lastVisiblePosition) {
                this.cDs = firstVisiblePosition;
                this.cDt = lastVisiblePosition;
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
            aky();
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

    private void akl() {
        setSelector(getResources().getDrawable(17301602));
    }

    public void setStackFromRight(boolean z) {
        if (this.cCN != z) {
            this.cCN = z;
            akm();
        }
    }

    void akm() {
        if (getChildCount() > 0) {
            akn();
            requestLayout();
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new com.baidu.tieba.horizonalList.widget.f();
        long cEd;
        long cEe;
        int cEf;
        String cEg;
        boolean cEh;
        int cEi;
        SparseArrayCompat<Boolean> cEj;
        LongSparseArray<Integer> cEk;
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
            this.cEd = parcel.readLong();
            this.cEe = parcel.readLong();
            this.cEf = parcel.readInt();
            this.position = parcel.readInt();
            this.width = parcel.readInt();
            this.cEg = parcel.readString();
            this.cEh = parcel.readByte() != 0;
            this.cEi = parcel.readInt();
            this.cEj = f(parcel);
            this.cEk = e(parcel);
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
            parcel.writeLong(this.cEd);
            parcel.writeLong(this.cEe);
            parcel.writeInt(this.cEf);
            parcel.writeInt(this.position);
            parcel.writeInt(this.width);
            parcel.writeString(this.cEg);
            parcel.writeByte((byte) (this.cEh ? 1 : 0));
            parcel.writeInt(this.cEi);
            a(this.cEj, parcel);
            a(this.cEk, parcel);
        }

        public String toString() {
            return "AbsListView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " selectedId=" + this.cEd + " firstId=" + this.cEe + " viewLeft=" + this.cEf + " position=" + this.position + " width=" + this.width + " filter=" + this.cEg + " checkState=" + this.cEj + "}";
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        boolean z = true;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.cDx != null) {
            savedState.cEd = this.cDx.cEd;
            savedState.cEe = this.cDx.cEe;
            savedState.cEf = this.cDx.cEf;
            savedState.position = this.cDx.position;
            savedState.width = this.cDx.width;
            savedState.cEg = this.cDx.cEg;
            savedState.cEh = this.cDx.cEh;
            savedState.cEi = this.cDx.cEi;
            savedState.cEj = this.cDx.cEj;
            savedState.cEk = this.cDx.cEk;
            return savedState;
        }
        boolean z2 = getChildCount() > 0 && this.cEz > 0;
        long selectedItemId = getSelectedItemId();
        savedState.cEd = selectedItemId;
        savedState.width = getWidth();
        if (selectedItemId >= 0) {
            savedState.cEf = this.cCM;
            savedState.position = getSelectedItemPosition();
            savedState.cEe = -1L;
        } else if (z2 && this.cEm > 0) {
            savedState.cEf = getChildAt(0).getLeft();
            int i2 = this.cEm;
            if (i2 >= this.cEz) {
                i2 = this.cEz - 1;
            }
            savedState.position = i2;
            savedState.cEe = this.mAdapter.getItemId(i2);
        } else {
            savedState.cEf = 0;
            savedState.cEe = -1L;
            savedState.position = 0;
        }
        savedState.cEg = null;
        savedState.cEh = (Build.VERSION.SDK_INT < 11 || this.cCf != 3 || this.cCg == null) ? false : false;
        if (this.cCj != null) {
            try {
                savedState.cEj = this.cCj.m1clone();
            } catch (NoSuchMethodError e2) {
                e2.printStackTrace();
                savedState.cEj = new SparseArrayCompat<>();
            }
        }
        if (this.cCk != null) {
            LongSparseArray<Integer> longSparseArray = new LongSparseArray<>();
            int size = this.cCk.size();
            for (int i3 = 0; i3 < size; i3++) {
                longSparseArray.put(this.cCk.keyAt(i3), this.cCk.valueAt(i3));
            }
            savedState.cEk = longSparseArray;
        }
        savedState.cEi = this.cCi;
        return savedState;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.ajc = true;
        this.cEq = savedState.width;
        if (savedState.cEd >= 0) {
            this.cEr = true;
            this.cDx = savedState;
            this.cEp = savedState.cEd;
            this.cEo = savedState.position;
            this.cEn = savedState.cEf;
            this.cEs = 0;
        } else if (savedState.cEe >= 0) {
            setSelectedPositionInt(-1);
            setNextSelectedPositionInt(-1);
            this.cCp = -1;
            this.cEr = true;
            this.cDx = savedState;
            this.cEp = savedState.cEe;
            this.cEo = savedState.position;
            this.cEn = savedState.cEf;
            this.cEs = 1;
        }
        if (savedState.cEj != null) {
            this.cCj = savedState.cEj;
        }
        if (savedState.cEk != null) {
            this.cCk = savedState.cEk;
        }
        this.cCi = savedState.cEi;
        if (Build.VERSION.SDK_INT >= 11 && savedState.cEh && this.cCf == 3 && this.cCh != null) {
            this.cCg = startActionMode((com.baidu.tieba.horizonalList.a.a.b) this.cCh);
        }
        requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onFocusChanged(boolean z, int i2, Rect rect) {
        super.onFocusChanged(z, i2, rect);
        if (z && this.ckM < 0 && !isInTouchMode()) {
            if (!this.cDu && this.mAdapter != null) {
                this.ajc = true;
                this.cEA = this.cEz;
                this.cEz = this.mAdapter.getCount();
            }
            akC();
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (!this.cEH && !this.mInLayout) {
            super.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void akn() {
        removeAllViewsInLayout();
        this.cEm = 0;
        this.ajc = false;
        this.cDf = null;
        this.cEr = false;
        this.cDx = null;
        this.cEC = -1;
        this.cED = Long.MIN_VALUE;
        setSelectedPositionInt(-1);
        setNextSelectedPositionInt(-1);
        this.cCM = 0;
        this.cCp = -1;
        this.cCq.setEmpty();
        invalidate();
    }

    @Override // android.view.View
    protected int computeHorizontalScrollExtent() {
        int childCount = getChildCount();
        if (childCount > 0) {
            if (this.cCP) {
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
        int i3 = this.cEm;
        int childCount = getChildCount();
        if (i3 < 0 || childCount <= 0) {
            return 0;
        }
        if (this.cCP) {
            View childAt = getChildAt(0);
            int left = childAt.getLeft();
            int width = childAt.getWidth();
            if (width > 0) {
                return Math.max(((i3 * 100) - ((left * 100) / width)) + ((int) ((getScrollX() / getWidth()) * this.cEz * 100.0f)), 0);
            }
            return 0;
        }
        int i4 = this.cEz;
        if (i3 != 0) {
            i2 = i3 + childCount == i4 ? i4 : (childCount / 2) + i3;
        }
        return (int) (((i2 / i4) * childCount) + i3);
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        if (this.cCP) {
            int max = Math.max(this.cEz * 100, 0);
            if (getScrollX() != 0) {
                return max + Math.abs((int) ((getScrollX() / getWidth()) * this.cEz * 100.0f));
            }
            return max;
        }
        return this.cEz;
    }

    @Override // android.view.View
    protected float getLeftFadingEdgeStrength() {
        int childCount = getChildCount();
        float leftFadingEdgeStrength = super.getLeftFadingEdgeStrength();
        if (childCount != 0) {
            if (this.cEm > 0) {
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
            if ((this.cEm + childCount) - 1 < this.cEz - 1) {
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
        if (this.HJ == null) {
            akl();
        }
        Rect rect = this.cCw;
        rect.left = this.cCs + getPaddingLeft();
        rect.top = this.cCt + getPaddingTop();
        rect.right = this.cCu + getPaddingRight();
        rect.bottom = this.cCv + getPaddingBottom();
        if (this.cDa == 1) {
            int childCount = getChildCount();
            int width = getWidth() - getPaddingRight();
            View childAt = getChildAt(childCount - 1);
            this.cDo = childCount + this.cEm >= this.cDv && (childAt != null ? childAt.getRight() : width) <= width;
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
            this.cCr.akI();
        }
        layoutChildren();
        this.mInLayout = false;
        this.cCT = (i4 - i2) / 3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void layoutChildren() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ako() {
        boolean z = true;
        if (this.cCy != null) {
            boolean z2 = this.cEm > 0;
            if (!z2 && getChildCount() > 0) {
                z2 = getChildAt(0).getLeft() < this.cCw.left;
            }
            this.cCy.setVisibility(z2 ? 0 : 4);
        }
        if (this.cCz != null) {
            int childCount = getChildCount();
            boolean z3 = this.cEm + childCount < this.cEz;
            if (z3 || childCount <= 0) {
                z = z3;
            } else if (getChildAt(childCount - 1).getRight() <= getRight() - this.cCw.right) {
                z = false;
            }
            this.cCz.setVisibility(z ? 0 : 4);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.g
    @ViewDebug.ExportedProperty
    public View getSelectedView() {
        if (this.cEz <= 0 || this.ckM < 0) {
            return null;
        }
        return getChildAt(this.ckM - this.cEm);
    }

    public int getListPaddingTop() {
        return this.cCw.top;
    }

    public int getListPaddingBottom() {
        return this.cCw.bottom;
    }

    public int getListPaddingLeft() {
        return this.cCw.left;
    }

    public int getListPaddingRight() {
        return this.cCw.right;
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
        View kj = this.cCr.kj(i2);
        if (kj == null) {
            View kk = this.cCr.kk(i2);
            if (kk != null) {
                view = this.mAdapter.getView(i2, kk, this);
                if (view != kk) {
                    this.cCr.r(kk, i2);
                    if (this.cDb != 0) {
                        view.setDrawingCacheBackgroundColor(this.cDb);
                        kj = view;
                    }
                } else {
                    zArr[0] = true;
                    view.onFinishTemporaryDetach();
                    kj = view;
                }
                if (this.cCn) {
                    ViewGroup.LayoutParams layoutParams = kj.getLayoutParams();
                    if (layoutParams == null) {
                        fVar = (f) generateDefaultLayoutParams();
                    } else if (!checkLayoutParams(layoutParams)) {
                        fVar = (f) generateLayoutParams(layoutParams);
                    } else {
                        fVar = (f) layoutParams;
                    }
                    fVar.cDL = this.mAdapter.getItemId(i2);
                    kj.setLayoutParams(fVar);
                }
                if (this.cEB.isEnabled() && this.cDr == null) {
                    this.cDr = new g();
                }
            } else {
                view = this.mAdapter.getView(i2, null, this);
                if (this.cDb != 0) {
                    view.setDrawingCacheBackgroundColor(this.cDb);
                }
            }
            kj = view;
            if (this.cCn) {
            }
            if (this.cEB.isEnabled()) {
                this.cDr = new g();
            }
        }
        return kj;
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
            this.cCp = i2;
        }
        Rect rect = this.cCq;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        if (view instanceof m) {
            ((m) view).adjustListItemSelectionBounds(rect);
        }
        j(rect.left, rect.top, rect.right, rect.bottom);
        boolean z = this.cDc;
        if (view.isEnabled() != z) {
            this.cDc = !z;
            if (getSelectedItemPosition() != -1) {
                refreshDrawableState();
            }
        }
    }

    private void j(int i2, int i3, int i4, int i5) {
        this.cCq.set(i2 - this.cCs, i3 - this.cCt, this.cCu + i4, this.cCv + i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        boolean z = this.cCo;
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
            this.ajc = true;
            akW();
        }
    }

    boolean akp() {
        switch (this.cCH) {
            case 1:
            case 2:
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean akq() {
        return (hasFocus() && !isInTouchMode()) || akp();
    }

    private void e(Canvas canvas) {
        if (!this.cCq.isEmpty()) {
            Drawable drawable = this.HJ;
            drawable.setBounds(this.cCq);
            drawable.draw(canvas);
        }
    }

    public void setDrawSelectorOnTop(boolean z) {
        this.cCo = z;
    }

    public void setSelector(int i2) {
        setSelector(getResources().getDrawable(i2));
    }

    public void setSelector(Drawable drawable) {
        if (this.HJ != null) {
            this.HJ.setCallback(null);
            unscheduleDrawable(this.HJ);
        }
        this.HJ = drawable;
        Rect rect = new Rect();
        drawable.getPadding(rect);
        this.cCs = rect.left;
        this.cCt = rect.top;
        this.cCu = rect.right;
        this.cCv = rect.bottom;
        drawable.setCallback(this);
        aks();
    }

    public Drawable getSelector() {
        return this.HJ;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void akr() {
        if (isEnabled() && isClickable()) {
            Drawable drawable = this.HJ;
            Rect rect = this.cCq;
            if (drawable != null) {
                if ((isFocused() || akp()) && !rect.isEmpty()) {
                    View childAt = getChildAt(this.ckM - this.cEm);
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
                    if (isLongClickable && !this.ajc) {
                        if (this.cCX == null) {
                            this.cCX = new b(this, null);
                        }
                        this.cCX.akN();
                        postDelayed(this.cCX, ViewConfiguration.getLongPressTimeout());
                    }
                }
            }
        }
    }

    void aks() {
        if (this.HJ != null) {
            if (akq()) {
                this.HJ.setState(getDrawableState());
            } else {
                this.HJ.setState(cDy);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        aks();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i2) {
        if (this.cDc) {
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
        return this.HJ == drawable || super.verifyDrawable(drawable);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.HJ != null) {
            this.HJ.jumpToCurrentState();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnTouchModeChangeListener(this);
        if (this.mAdapter != null && this.cCm == null) {
            this.cCm = new a();
            this.mAdapter.registerDataSetObserver(this.cCm);
            this.ajc = true;
            this.cEA = this.cEz;
            this.cEz = this.mAdapter.getCount();
        }
        this.cDu = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.g, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.cCr.clear();
        getViewTreeObserver().removeOnTouchModeChangeListener(this);
        if (this.mAdapter != null && this.cCm != null) {
            this.mAdapter.unregisterDataSetObserver(this.cCm);
            this.cCm = null;
        }
        if (this.cCK != null) {
            removeCallbacks(this.cCK);
        }
        if (this.cCL != null) {
            this.cCL.stop();
        }
        if (this.cDe != null) {
            removeCallbacks(this.cDe);
        }
        if (this.cCY != null) {
            removeCallbacks(this.cCY);
        }
        if (this.cCZ != null) {
            removeCallbacks(this.cCZ);
            this.cCZ = null;
        }
        this.cDu = false;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        int i2 = isInTouchMode() ? 0 : 1;
        if (!z) {
            setChildrenDrawingCacheEnabled(false);
            if (this.cCK != null) {
                removeCallbacks(this.cCK);
                this.cCK.akG();
                if (this.cCL != null) {
                    this.cCL.stop();
                }
                if (getScrollX() != 0) {
                    this.cCe.setScrollX(0);
                    akE();
                    invalidate();
                }
            }
            if (i2 == 1) {
                this.cCR = this.ckM;
            }
        } else if (i2 != this.cCU && this.cCU != -1) {
            if (i2 == 1) {
                akC();
            } else {
                akz();
                this.cCl = 0;
                layoutChildren();
            }
        }
        this.cCU = i2;
    }

    ContextMenu.ContextMenuInfo b(View view, int i2, long j2) {
        return new g.a(view, i2, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class n {
        private int cEl;

        private n() {
        }

        /* synthetic */ n(AbsHListView absHListView, n nVar) {
            this();
        }

        public void akN() {
            this.cEl = AbsHListView.this.getWindowAttachCount();
        }

        public boolean akO() {
            return AbsHListView.this.hasWindowFocus() && AbsHListView.this.getWindowAttachCount() == this.cEl;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class i extends n implements Runnable {
        int cDM;

        private i() {
            super(AbsHListView.this, null);
        }

        /* synthetic */ i(AbsHListView absHListView, i iVar) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            View childAt;
            if (!AbsHListView.this.ajc) {
                ListAdapter listAdapter = AbsHListView.this.mAdapter;
                int i = this.cDM;
                if (listAdapter != null && AbsHListView.this.cEz > 0 && i != -1 && i < listAdapter.getCount() && akO() && (childAt = AbsHListView.this.getChildAt(i - AbsHListView.this.cEm)) != null) {
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
            View childAt = AbsHListView.this.getChildAt(AbsHListView.this.cCC - AbsHListView.this.cEm);
            if (childAt != null) {
                if ((!akO() || AbsHListView.this.ajc) ? false : AbsHListView.this.c(childAt, AbsHListView.this.cCC, AbsHListView.this.mAdapter.getItemId(AbsHListView.this.cCC))) {
                    AbsHListView.this.cCH = -1;
                    AbsHListView.this.setPressed(false);
                    childAt.setPressed(false);
                    return;
                }
                AbsHListView.this.cCH = 2;
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
            if (AbsHListView.this.isPressed() && AbsHListView.this.ckM >= 0) {
                View childAt = AbsHListView.this.getChildAt(AbsHListView.this.ckM - AbsHListView.this.cEm);
                if (!AbsHListView.this.ajc) {
                    if (akO() ? AbsHListView.this.c(childAt, AbsHListView.this.ckM, AbsHListView.this.cEy) : false) {
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
        if (Build.VERSION.SDK_INT >= 11 && this.cCf == 3) {
            if (this.cCg == null) {
                ActionMode startActionMode = startActionMode((com.baidu.tieba.horizonalList.a.a.b) this.cCh);
                this.cCg = startActionMode;
                if (startActionMode != null) {
                    setItemChecked(i2, true);
                    performHapticFeedback(0);
                }
            }
            return true;
        }
        boolean b2 = this.cEv != null ? this.cEv.b(this, view, i2, j2) : false;
        if (!b2) {
            this.cCS = b(view, i2, j2);
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
        return this.cCS;
    }

    public boolean a(float f2, float f3, int i2) {
        int pointToPosition = pointToPosition((int) f2, (int) f3);
        if (pointToPosition != -1) {
            long itemId = this.mAdapter.getItemId(pointToPosition);
            View childAt = getChildAt(pointToPosition - this.cEm);
            if (childAt != null) {
                this.cCS = b(childAt, pointToPosition, itemId);
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
            boolean b2 = this.cEv != null ? this.cEv.b(this, view, positionForView, itemId) : false;
            if (!b2) {
                this.cCS = b(getChildAt(positionForView - this.cEm), positionForView, itemId);
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
                if (isClickable() && isPressed() && this.ckM >= 0 && this.mAdapter != null && this.ckM < this.mAdapter.getCount()) {
                    View childAt = getChildAt(this.ckM - this.cEm);
                    if (childAt != null) {
                        performItemClick(childAt, this.ckM, this.cEy);
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
        Rect rect = this.cCQ;
        if (rect == null) {
            this.cCQ = new Rect();
            rect = this.cCQ;
        }
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt.getVisibility() == 0) {
                childAt.getHitRect(rect);
                if (rect.contains(i2, i3)) {
                    return this.cEm + childCount;
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
            if (AbsHListView.this.cCH == 0) {
                AbsHListView.this.cCH = 1;
                View childAt = AbsHListView.this.getChildAt(AbsHListView.this.cCC - AbsHListView.this.cEm);
                if (childAt != null && !childAt.hasFocusable()) {
                    AbsHListView.this.cCl = 0;
                    if (!AbsHListView.this.ajc) {
                        childAt.setPressed(true);
                        AbsHListView.this.setPressed(true);
                        AbsHListView.this.layoutChildren();
                        AbsHListView.this.c(AbsHListView.this.cCC, childAt);
                        AbsHListView.this.refreshDrawableState();
                        int longPressTimeout = ViewConfiguration.getLongPressTimeout();
                        boolean isLongClickable = AbsHListView.this.isLongClickable();
                        if (AbsHListView.this.HJ != null && (current = AbsHListView.this.HJ.getCurrent()) != null && (current instanceof TransitionDrawable)) {
                            if (isLongClickable) {
                                ((TransitionDrawable) current).startTransition(longPressTimeout);
                            } else {
                                ((TransitionDrawable) current).resetTransition();
                            }
                        }
                        if (isLongClickable) {
                            if (AbsHListView.this.cCV == null) {
                                AbsHListView.this.cCV = new c(AbsHListView.this, null);
                            }
                            AbsHListView.this.cCV.akN();
                            AbsHListView.this.postDelayed(AbsHListView.this.cCV, longPressTimeout);
                            return;
                        }
                        AbsHListView.this.cCH = 2;
                        return;
                    }
                    AbsHListView.this.cCH = 2;
                }
            }
        }
    }

    private boolean jX(int i2) {
        int i3 = i2 - this.cCF;
        int abs = Math.abs(i3);
        boolean z = getScrollX() != 0;
        if (z || abs > this.mTouchSlop) {
            akx();
            if (z) {
                this.cCH = 5;
                this.cCJ = 0;
            } else {
                this.cCH = 3;
                this.cCJ = i3 > 0 ? this.mTouchSlop : -this.mTouchSlop;
            }
            Handler handler = getHandler();
            if (handler != null) {
                handler.removeCallbacks(this.cCV);
            }
            setPressed(false);
            View childAt = getChildAt(this.cCC - this.cEm);
            if (childAt != null) {
                childAt.setPressed(false);
            }
            jZ(1);
            ViewParent parent = getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            jY(i2);
            return true;
        }
        return false;
    }

    private void jY(int i2) {
        int i3;
        int childCount;
        ViewParent parent;
        int i4 = i2 - this.cCF;
        int i5 = i4 - this.cCJ;
        int i6 = this.cCI != Integer.MIN_VALUE ? i2 - this.cCI : i5;
        if (this.cCH == 3) {
            if (i2 != this.cCI) {
                if (Math.abs(i4) > this.mTouchSlop && (parent = getParent()) != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
                if (this.cCC >= 0) {
                    childCount = this.cCC - this.cEm;
                } else {
                    childCount = getChildCount() / 2;
                }
                View childAt = getChildAt(childCount);
                int left = childAt != null ? childAt.getLeft() : 0;
                boolean aA = i6 != 0 ? aA(i5, i6) : false;
                View childAt2 = getChildAt(childCount);
                if (childAt2 != null) {
                    int left2 = childAt2.getLeft();
                    if (aA) {
                        int i7 = (-i6) - (left2 - left);
                        overScrollBy(i7, 0, getScrollX(), 0, 0, 0, this.cDi, 0, true);
                        if (Math.abs(this.cDi) == Math.abs(getScrollX()) && this.mVelocityTracker != null) {
                            this.mVelocityTracker.clear();
                        }
                        int overScrollMode = getOverScrollMode();
                        if (overScrollMode == 0 || (overScrollMode == 1 && !akj())) {
                            this.mDirection = 0;
                            this.cCH = 5;
                            if (i4 > 0) {
                                this.cDk.onPull(i7 / getWidth());
                                if (!this.cDl.isFinished()) {
                                    this.cDl.onRelease();
                                }
                                invalidate();
                            } else if (i4 < 0) {
                                this.cDl.onPull(i7 / getWidth());
                                if (!this.cDk.isFinished()) {
                                    this.cDk.onRelease();
                                }
                                invalidate();
                            }
                        }
                    }
                    this.cCF = i2;
                }
                this.cCI = i2;
            }
        } else if (this.cCH == 5 && i2 != this.cCI) {
            int scrollX = getScrollX();
            int i8 = scrollX - i6;
            int i9 = i2 > this.cCI ? 1 : -1;
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
                overScrollBy(i10, 0, getScrollX(), 0, 0, 0, this.cDi, 0, true);
                int overScrollMode2 = getOverScrollMode();
                if (overScrollMode2 == 0 || (overScrollMode2 == 1 && !akj())) {
                    if (i4 > 0) {
                        this.cDk.onPull(i10 / getWidth());
                        if (!this.cDl.isFinished()) {
                            this.cDl.onRelease();
                        }
                        invalidate();
                    } else if (i4 < 0) {
                        this.cDl.onPull(i10 / getWidth());
                        if (!this.cDk.isFinished()) {
                            this.cDk.onRelease();
                        }
                        invalidate();
                    }
                }
            }
            if (i3 != 0) {
                if (getScrollX() != 0) {
                    this.cCe.setScrollX(0);
                    akt();
                }
                aA(i3, i3);
                this.cCH = 3;
                int kc = kc(i2);
                this.cCJ = 0;
                View childAt3 = getChildAt(kc - this.cEm);
                this.cCD = childAt3 != null ? childAt3.getLeft() : 0;
                this.cCF = i2;
                this.cCC = kc;
            }
            this.cCI = i2;
            this.mDirection = i9;
        }
    }

    protected void akt() {
        if (this.cCe.isHardwareAccelerated() && (getParent() instanceof View)) {
            ((View) getParent()).invalidate();
        }
    }

    @Override // android.view.ViewTreeObserver.OnTouchModeChangeListener
    public void onTouchModeChanged(boolean z) {
        if (z) {
            akz();
            if (getWidth() > 0 && getChildCount() > 0) {
                layoutChildren();
            }
            aks();
            return;
        }
        int i2 = this.cCH;
        if (i2 == 5 || i2 == 6) {
            if (this.cCK != null) {
                this.cCK.akG();
            }
            if (this.cCL != null) {
                this.cCL.stop();
            }
            if (getScrollX() != 0) {
                this.cCe.setScrollX(0);
                akE();
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
        if (this.cCL != null) {
            this.cCL.stop();
        }
        if (this.cDu) {
            int action = motionEvent.getAction();
            akv();
            this.mVelocityTracker.addMovement(motionEvent);
            switch (action & MotionEventCompat.ACTION_MASK) {
                case 0:
                    switch (this.cCH) {
                        case 6:
                            this.cCK.akG();
                            if (this.cCL != null) {
                                this.cCL.stop();
                            }
                            this.cCH = 5;
                            this.cCG = (int) motionEvent.getY();
                            int x = (int) motionEvent.getX();
                            this.cCI = x;
                            this.cCF = x;
                            this.cCJ = 0;
                            this.mActivePointerId = motionEvent.getPointerId(0);
                            this.mDirection = 0;
                            break;
                        default:
                            this.mActivePointerId = motionEvent.getPointerId(0);
                            int x2 = (int) motionEvent.getX();
                            int y = (int) motionEvent.getY();
                            int pointToPosition = pointToPosition(x2, y);
                            if (!this.ajc) {
                                if (this.cCH != 4 && pointToPosition >= 0 && getAdapter().isEnabled(pointToPosition)) {
                                    this.cCH = 0;
                                    if (this.cCW == null) {
                                        this.cCW = new d();
                                    }
                                    postDelayed(this.cCW, ViewConfiguration.getTapTimeout());
                                    i2 = pointToPosition;
                                } else if (this.cCH == 4) {
                                    akx();
                                    this.cCH = 3;
                                    this.cCJ = 0;
                                    i2 = kb(x2);
                                    this.cCK.akH();
                                }
                                if (i2 >= 0) {
                                    this.cCD = getChildAt(i2 - this.cEm).getLeft();
                                }
                                this.cCF = x2;
                                this.cCG = y;
                                this.cCC = i2;
                                this.cCI = ExploreByTouchHelper.INVALID_ID;
                                break;
                            }
                            i2 = pointToPosition;
                            if (i2 >= 0) {
                            }
                            this.cCF = x2;
                            this.cCG = y;
                            this.cCC = i2;
                            this.cCI = ExploreByTouchHelper.INVALID_ID;
                    }
                    if (k(motionEvent) && this.cCH == 0) {
                        removeCallbacks(this.cCW);
                        break;
                    }
                    break;
                case 1:
                    switch (this.cCH) {
                        case 0:
                        case 1:
                        case 2:
                            int i3 = this.cCC;
                            View childAt = getChildAt(i3 - this.cEm);
                            float x3 = motionEvent.getX();
                            boolean z = x3 > ((float) this.cCw.left) && x3 < ((float) (getWidth() - this.cCw.right));
                            if (childAt != null && !childAt.hasFocusable() && z) {
                                if (this.cCH != 0) {
                                    childAt.setPressed(false);
                                }
                                if (this.cCY == null) {
                                    this.cCY = new i(this, null);
                                }
                                i iVar = this.cCY;
                                iVar.cDM = i3;
                                iVar.akN();
                                this.cCR = i3;
                                if (this.cCH == 0 || this.cCH == 1) {
                                    Handler handler = getHandler();
                                    if (handler != null) {
                                        handler.removeCallbacks(this.cCH == 0 ? this.cCW : this.cCV);
                                    }
                                    this.cCl = 0;
                                    if (!this.ajc && this.mAdapter.isEnabled(i3)) {
                                        this.cCH = 1;
                                        setSelectedPositionInt(this.cCC);
                                        layoutChildren();
                                        childAt.setPressed(true);
                                        c(this.cCC, childAt);
                                        setPressed(true);
                                        if (this.HJ != null && (current = this.HJ.getCurrent()) != null && (current instanceof TransitionDrawable)) {
                                            ((TransitionDrawable) current).resetTransition();
                                        }
                                        if (this.cCZ != null) {
                                            removeCallbacks(this.cCZ);
                                        }
                                        this.cCZ = new com.baidu.tieba.horizonalList.widget.a(this, childAt, iVar);
                                        postDelayed(this.cCZ, ViewConfiguration.getPressedStateDuration());
                                    } else {
                                        this.cCH = -1;
                                        aks();
                                    }
                                    return true;
                                } else if (!this.ajc && this.mAdapter.isEnabled(i3)) {
                                    iVar.run();
                                }
                            }
                            this.cCH = -1;
                            aks();
                            break;
                        case 3:
                            int childCount = getChildCount();
                            if (childCount > 0) {
                                int left = getChildAt(0).getLeft();
                                int right = getChildAt(childCount - 1).getRight();
                                int i4 = this.cCw.left;
                                int width = getWidth() - this.cCw.right;
                                if (this.cEm == 0 && left >= i4 && this.cEm + childCount < this.cEz && right <= getWidth() - width) {
                                    this.cCH = -1;
                                    jZ(0);
                                    break;
                                } else {
                                    VelocityTracker velocityTracker = this.mVelocityTracker;
                                    velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                                    int xVelocity = (int) (velocityTracker.getXVelocity(this.mActivePointerId) * this.cDg);
                                    if (Math.abs(xVelocity) > this.mMinimumVelocity && ((this.cEm != 0 || left != i4 - this.cDi) && (childCount + this.cEm != this.cEz || right != this.cDi + width))) {
                                        if (this.cCK == null) {
                                            this.cCK = new e();
                                        }
                                        jZ(2);
                                        this.cCK.kd(-xVelocity);
                                        break;
                                    } else {
                                        this.cCH = -1;
                                        jZ(0);
                                        if (this.cCK != null) {
                                            this.cCK.akG();
                                        }
                                        if (this.cCL != null) {
                                            this.cCL.stop();
                                            break;
                                        }
                                    }
                                }
                            } else {
                                this.cCH = -1;
                                jZ(0);
                                break;
                            }
                            break;
                        case 5:
                            if (this.cCK == null) {
                                this.cCK = new e();
                            }
                            VelocityTracker velocityTracker2 = this.mVelocityTracker;
                            velocityTracker2.computeCurrentVelocity(1000, this.mMaximumVelocity);
                            int xVelocity2 = (int) velocityTracker2.getXVelocity(this.mActivePointerId);
                            jZ(2);
                            if (Math.abs(xVelocity2) > this.mMinimumVelocity) {
                                this.cCK.ke(-xVelocity2);
                                break;
                            } else {
                                this.cCK.akF();
                                break;
                            }
                    }
                    setPressed(false);
                    if (this.cDk != null) {
                        this.cDk.onRelease();
                        this.cDl.onRelease();
                    }
                    invalidate();
                    Handler handler2 = getHandler();
                    if (handler2 != null) {
                        handler2.removeCallbacks(this.cCV);
                    }
                    akw();
                    this.mActivePointerId = -1;
                    break;
                case 2:
                    int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                    if (findPointerIndex == -1) {
                        this.mActivePointerId = motionEvent.getPointerId(0);
                        findPointerIndex = 0;
                    }
                    int x4 = (int) motionEvent.getX(findPointerIndex);
                    if (this.ajc) {
                        layoutChildren();
                    }
                    switch (this.cCH) {
                        case 0:
                        case 1:
                        case 2:
                            jX(x4);
                            break;
                        case 3:
                        case 5:
                            jY(x4);
                            break;
                    }
                case 3:
                    switch (this.cCH) {
                        case 5:
                            if (this.cCK == null) {
                                this.cCK = new e();
                            }
                            this.cCK.akF();
                            break;
                        case 6:
                            break;
                        default:
                            this.cCH = -1;
                            setPressed(false);
                            View childAt2 = getChildAt(this.cCC - this.cEm);
                            if (childAt2 != null) {
                                childAt2.setPressed(false);
                            }
                            aky();
                            Handler handler3 = getHandler();
                            if (handler3 != null) {
                                handler3.removeCallbacks(this.cCV);
                            }
                            akw();
                            break;
                    }
                    if (this.cDk != null) {
                        this.cDk.onRelease();
                        this.cDl.onRelease();
                    }
                    this.mActivePointerId = -1;
                    break;
                case 5:
                    int actionIndex = motionEvent.getActionIndex();
                    int pointerId = motionEvent.getPointerId(actionIndex);
                    int x5 = (int) motionEvent.getX(actionIndex);
                    int y2 = (int) motionEvent.getY(actionIndex);
                    this.cCJ = 0;
                    this.mActivePointerId = pointerId;
                    this.cCF = x5;
                    this.cCG = y2;
                    int pointToPosition2 = pointToPosition(x5, y2);
                    if (pointToPosition2 >= 0) {
                        this.cCD = getChildAt(pointToPosition2 - this.cEm).getLeft();
                        this.cCC = pointToPosition2;
                    }
                    this.cCI = x5;
                    break;
                case 6:
                    onSecondaryPointerUp(motionEvent);
                    int i5 = this.cCF;
                    int pointToPosition3 = pointToPosition(i5, this.cCG);
                    if (pointToPosition3 >= 0) {
                        this.cCD = getChildAt(pointToPosition3 - this.cEm).getLeft();
                        this.cCC = pointToPosition3;
                    }
                    this.cCI = i5;
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
            this.cCe.setScrollX(i2);
            akt();
            awakenScrollBars();
        }
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) != 0) {
            switch (motionEvent.getAction()) {
                case 8:
                    if (this.cCH == -1) {
                        float axisValue = motionEvent.getAxisValue(10);
                        if (axisValue != 0.0f) {
                            int horizontalScrollFactor = (int) (axisValue * getHorizontalScrollFactor());
                            if (!aA(horizontalScrollFactor, horizontalScrollFactor)) {
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
        if (this.cDz == 0.0f) {
            TypedValue typedValue = new TypedValue();
            if (getContext().getTheme().resolveAttribute(w.c.hlv_listPreferredItemWidth, typedValue, true)) {
                this.cDz = typedValue.getDimension(getContext().getResources().getDisplayMetrics());
            }
        }
        return this.cDz;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.cDk != null) {
            int scrollX = getScrollX();
            if (!this.cDk.isFinished()) {
                int save = canvas.save();
                int i2 = this.cCw.top + this.cDp;
                int height = (getHeight() - i2) - (this.cCw.bottom + this.cDq);
                int min = Math.min(0, this.cDm + scrollX);
                canvas.rotate(-90.0f);
                canvas.translate(i2 + (-getHeight()), min);
                this.cDk.setSize(height, height);
                if (this.cDk.draw(canvas)) {
                    invalidate();
                }
                canvas.restoreToCount(save);
            }
            if (!this.cDl.isFinished()) {
                int save2 = canvas.save();
                int i3 = this.cCw.left + this.cDp;
                int height2 = (getHeight() - i3) - (this.cCw.right + this.cDq);
                int max = Math.max(getWidth(), scrollX + this.cDn);
                canvas.rotate(90.0f);
                canvas.translate(-i3, -max);
                this.cDl.setSize(height2, height2);
                if (this.cDl.draw(canvas)) {
                    invalidate();
                }
                canvas.restoreToCount(save2);
            }
        }
    }

    private void aku() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        } else {
            this.mVelocityTracker.clear();
        }
    }

    private void akv() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
    }

    private void akw() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            akw();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.cCL != null) {
            this.cCL.stop();
        }
        if (this.cDu) {
            switch (action & MotionEventCompat.ACTION_MASK) {
                case 0:
                    int i2 = this.cCH;
                    if (i2 == 6 || i2 == 5) {
                        this.cCJ = 0;
                        return true;
                    }
                    int x = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();
                    this.mActivePointerId = motionEvent.getPointerId(0);
                    int kb = kb(x);
                    if (i2 != 4 && kb >= 0) {
                        this.cCD = getChildAt(kb - this.cEm).getLeft();
                        this.cCF = x;
                        this.cCG = y;
                        this.cCC = kb;
                        this.cCH = 0;
                        aky();
                    }
                    this.cCI = ExploreByTouchHelper.INVALID_ID;
                    aku();
                    this.mVelocityTracker.addMovement(motionEvent);
                    return i2 == 4;
                case 1:
                case 3:
                    this.cCH = -1;
                    this.mActivePointerId = -1;
                    akw();
                    jZ(0);
                    return false;
                case 2:
                    switch (this.cCH) {
                        case 0:
                            int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                            if (findPointerIndex == -1) {
                                this.mActivePointerId = motionEvent.getPointerId(0);
                                findPointerIndex = 0;
                            }
                            akv();
                            this.mVelocityTracker.addMovement(motionEvent);
                            return jX((int) motionEvent.getX(findPointerIndex));
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
            this.cCF = (int) motionEvent.getX(i2);
            this.cCG = (int) motionEvent.getY(i2);
            this.cCJ = 0;
            this.mActivePointerId = motionEvent.getPointerId(i2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        int childCount = getChildCount();
        int i2 = this.cEm;
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
    public void jZ(int i2) {
        if (i2 != this.cDd && this.cCO != null) {
            this.cDd = i2;
            this.cCO.a(this, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e implements Runnable {
        private final o cDD;
        private int cDE;
        private final Runnable cDF = new com.baidu.tieba.horizonalList.widget.c(this);

        e() {
            this.cDD = new o(AbsHListView.this.getContext());
        }

        void kd(int i) {
            int i2 = i < 0 ? Integer.MAX_VALUE : 0;
            this.cDE = i2;
            this.cDD.setInterpolator(null);
            this.cDD.fling(i2, 0, i, 0, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
            AbsHListView.this.cCH = 4;
            AbsHListView.this.cCe.i(this);
        }

        void akF() {
            if (this.cDD.springBack(AbsHListView.this.getScrollX(), 0, 0, 0, 0, 0)) {
                AbsHListView.this.cCH = 6;
                AbsHListView.this.invalidate();
                AbsHListView.this.cCe.i(this);
                return;
            }
            AbsHListView.this.cCH = -1;
            AbsHListView.this.jZ(0);
        }

        void ke(int i) {
            this.cDD.setInterpolator(null);
            this.cDD.fling(AbsHListView.this.getScrollX(), 0, i, 0, ExploreByTouchHelper.INVALID_ID, Integer.MAX_VALUE, 0, 0, AbsHListView.this.getWidth(), 0);
            AbsHListView.this.cCH = 6;
            AbsHListView.this.invalidate();
            AbsHListView.this.cCe.i(this);
        }

        void kf(int i) {
            this.cDD.notifyHorizontalEdgeReached(AbsHListView.this.getScrollX(), 0, AbsHListView.this.cDj);
            int overScrollMode = AbsHListView.this.getOverScrollMode();
            if (overScrollMode == 0 || (overScrollMode == 1 && !AbsHListView.this.akj())) {
                AbsHListView.this.cCH = 6;
                int currVelocity = (int) this.cDD.getCurrVelocity();
                if (i > 0) {
                    AbsHListView.this.cDk.onAbsorb(currVelocity);
                } else {
                    AbsHListView.this.cDl.onAbsorb(currVelocity);
                }
            } else {
                AbsHListView.this.cCH = -1;
                if (AbsHListView.this.cCL != null) {
                    AbsHListView.this.cCL.stop();
                }
            }
            AbsHListView.this.invalidate();
            AbsHListView.this.cCe.i(this);
        }

        void d(int i, int i2, boolean z) {
            int i3 = i < 0 ? Integer.MAX_VALUE : 0;
            this.cDE = i3;
            this.cDD.setInterpolator(z ? AbsHListView.cDw : null);
            this.cDD.startScroll(i3, 0, i, 0, i2);
            AbsHListView.this.cCH = 4;
            AbsHListView.this.cCe.i(this);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void akG() {
            AbsHListView.this.cCH = -1;
            AbsHListView.this.removeCallbacks(this);
            AbsHListView.this.removeCallbacks(this.cDF);
            AbsHListView.this.jZ(0);
            AbsHListView.this.aky();
            this.cDD.abortAnimation();
            AbsHListView.this.overScrollBy(0, 0, 0, 0, 0, 0, 0, 0, false);
        }

        void akH() {
            AbsHListView.this.postDelayed(this.cDF, 40L);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // java.lang.Runnable
        public void run() {
            int max;
            boolean z = true;
            boolean z2 = false;
            switch (AbsHListView.this.cCH) {
                case 3:
                    if (this.cDD.isFinished()) {
                        return;
                    }
                    break;
                case 4:
                    break;
                case 5:
                default:
                    akG();
                    return;
                case 6:
                    o oVar = this.cDD;
                    if (oVar.computeScrollOffset()) {
                        int scrollX = AbsHListView.this.getScrollX();
                        int currX = oVar.getCurrX();
                        if (AbsHListView.this.overScrollBy(currX - scrollX, 0, scrollX, 0, 0, 0, AbsHListView.this.cDj, 0, false)) {
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
                                kd(currVelocity);
                                return;
                            }
                            akF();
                            return;
                        }
                        AbsHListView.this.invalidate();
                        AbsHListView.this.cCe.i(this);
                        return;
                    }
                    akG();
                    return;
            }
            if (AbsHListView.this.ajc) {
                AbsHListView.this.layoutChildren();
            }
            if (AbsHListView.this.cEz == 0 || AbsHListView.this.getChildCount() == 0) {
                akG();
                return;
            }
            o oVar2 = this.cDD;
            boolean computeScrollOffset = oVar2.computeScrollOffset();
            int currX2 = oVar2.getCurrX();
            int i = this.cDE - currX2;
            if (i > 0) {
                AbsHListView.this.cCC = AbsHListView.this.cEm;
                AbsHListView.this.cCD = AbsHListView.this.getChildAt(0).getLeft();
                max = Math.min(((AbsHListView.this.getWidth() - AbsHListView.this.getPaddingRight()) - AbsHListView.this.getPaddingLeft()) - 1, i);
            } else {
                int childCount = AbsHListView.this.getChildCount() - 1;
                AbsHListView.this.cCC = AbsHListView.this.cEm + childCount;
                AbsHListView.this.cCD = AbsHListView.this.getChildAt(childCount).getLeft();
                max = Math.max(-(((AbsHListView.this.getWidth() - AbsHListView.this.getPaddingRight()) - AbsHListView.this.getPaddingLeft()) - 1), i);
            }
            View childAt = AbsHListView.this.getChildAt(AbsHListView.this.cCC - AbsHListView.this.cEm);
            int left = childAt != null ? childAt.getLeft() : 0;
            boolean aA = AbsHListView.this.aA(max, max);
            if (!aA || max == 0) {
                z = false;
            }
            if (z) {
                if (childAt != null) {
                    AbsHListView.this.overScrollBy(-(max - (childAt.getLeft() - left)), 0, AbsHListView.this.getScrollX(), 0, 0, 0, AbsHListView.this.cDj, 0, false);
                }
                if (computeScrollOffset) {
                    kf(max);
                }
            } else if (computeScrollOffset && !z) {
                if (aA) {
                    AbsHListView.this.invalidate();
                }
                this.cDE = currX2;
                AbsHListView.this.cCe.i(this);
            } else {
                akG();
            }
        }
    }

    /* loaded from: classes.dex */
    public class j implements Runnable {
        private int cDN;
        private int cDO;
        private int cDP;
        private int cDQ;
        private final int cDR;
        private int cDS;
        private int mMode;

        j() {
            this.cDR = ViewConfiguration.get(AbsHListView.this.getContext()).getScaledFadingEdgeLength();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void kd(int i) {
            int i2;
            stop();
            if (AbsHListView.this.ajc) {
                AbsHListView.this.cDf = new com.baidu.tieba.horizonalList.widget.d(this, i);
                return;
            }
            int childCount = AbsHListView.this.getChildCount();
            if (childCount != 0) {
                int i3 = AbsHListView.this.cEm;
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
                    this.cDQ = 200 / i2;
                } else {
                    this.cDQ = 200;
                }
                this.cDN = max;
                this.cDO = -1;
                this.cDP = -1;
                AbsHListView.this.cCe.i(this);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void aC(int i, int i2) {
            int i3;
            stop();
            if (i2 == -1) {
                kd(i);
            } else if (AbsHListView.this.ajc) {
                AbsHListView.this.cDf = new com.baidu.tieba.horizonalList.widget.e(this, i, i2);
            } else {
                int childCount = AbsHListView.this.getChildCount();
                if (childCount != 0) {
                    int i4 = AbsHListView.this.cEm;
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
                        this.cDQ = 200 / i3;
                    } else {
                        this.cDQ = 200;
                    }
                    this.cDN = max;
                    this.cDO = i2;
                    this.cDP = -1;
                    AbsHListView.this.cCe.i(this);
                }
            }
        }

        void w(int i, int i2, int i3) {
            int i4 = AbsHListView.this.cEm;
            int childCount = (AbsHListView.this.getChildCount() + i4) - 1;
            int i5 = AbsHListView.this.cCw.left;
            int width = AbsHListView.this.getWidth() - AbsHListView.this.cCw.right;
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
            int i2 = AbsHListView.this.cEm;
            switch (this.mMode) {
                case 1:
                    int childCount = AbsHListView.this.getChildCount() - 1;
                    int i3 = i2 + childCount;
                    if (childCount >= 0) {
                        if (i3 == this.cDP) {
                            AbsHListView.this.cCe.i(this);
                            return;
                        }
                        View childAt = AbsHListView.this.getChildAt(childCount);
                        AbsHListView.this.c((i3 < AbsHListView.this.cEz + (-1) ? Math.max(AbsHListView.this.cCw.right, this.cDR) : AbsHListView.this.cCw.right) + (childAt.getWidth() - (width - childAt.getLeft())), this.cDQ, true);
                        this.cDP = i3;
                        if (i3 < this.cDN) {
                            AbsHListView.this.cCe.i(this);
                            return;
                        }
                        return;
                    }
                    return;
                case 2:
                    if (i2 == this.cDP) {
                        AbsHListView.this.cCe.i(this);
                        return;
                    }
                    View childAt2 = AbsHListView.this.getChildAt(0);
                    if (childAt2 != null) {
                        AbsHListView.this.c(childAt2.getLeft() - (i2 > 0 ? Math.max(this.cDR, AbsHListView.this.cCw.left) : AbsHListView.this.cCw.left), this.cDQ, true);
                        this.cDP = i2;
                        if (i2 > this.cDN) {
                            AbsHListView.this.cCe.i(this);
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    int childCount2 = AbsHListView.this.getChildCount();
                    if (i2 != this.cDO && childCount2 > 1 && childCount2 + i2 < AbsHListView.this.cEz) {
                        int i4 = i2 + 1;
                        if (i4 == this.cDP) {
                            AbsHListView.this.cCe.i(this);
                            return;
                        }
                        View childAt3 = AbsHListView.this.getChildAt(1);
                        int width2 = childAt3.getWidth();
                        int left2 = childAt3.getLeft();
                        int max = Math.max(AbsHListView.this.cCw.right, this.cDR);
                        if (i4 < this.cDO) {
                            AbsHListView.this.c(Math.max(0, (left2 + width2) - max), this.cDQ, true);
                            this.cDP = i4;
                            AbsHListView.this.cCe.i(this);
                            return;
                        } else if (left2 > max) {
                            AbsHListView.this.c(left2 - max, this.cDQ, true);
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
                        if (i5 == this.cDP) {
                            AbsHListView.this.cCe.i(this);
                            return;
                        }
                        View childAt4 = AbsHListView.this.getChildAt(childCount3);
                        int width3 = childAt4.getWidth();
                        int left3 = childAt4.getLeft();
                        int i6 = width - left3;
                        int max2 = Math.max(AbsHListView.this.cCw.left, this.cDR);
                        this.cDP = i5;
                        if (i5 > this.cDO) {
                            AbsHListView.this.c(-(i6 - max2), this.cDQ, true);
                            AbsHListView.this.cCe.i(this);
                            return;
                        }
                        int i7 = width - max2;
                        int i8 = left3 + width3;
                        if (i7 > i8) {
                            AbsHListView.this.c(-(i7 - i8), this.cDQ, true);
                            return;
                        }
                        return;
                    }
                    return;
                case 5:
                    if (this.cDP == i2) {
                        AbsHListView.this.cCe.i(this);
                        return;
                    }
                    this.cDP = i2;
                    int childCount4 = AbsHListView.this.getChildCount();
                    int i9 = this.cDN;
                    int i10 = (i2 + childCount4) - 1;
                    if (i9 < i2) {
                        i = (i2 - i9) + 1;
                    } else if (i9 > i10) {
                        i = i9 - i10;
                    }
                    float min = Math.min(Math.abs(i / childCount4), 1.0f);
                    if (i9 < i2) {
                        AbsHListView.this.c((int) ((-AbsHListView.this.getWidth()) * min), (int) (min * this.cDQ), true);
                        AbsHListView.this.cCe.i(this);
                        return;
                    } else if (i9 > i10) {
                        AbsHListView.this.c((int) (AbsHListView.this.getWidth() * min), (int) (min * this.cDQ), true);
                        AbsHListView.this.cCe.i(this);
                        return;
                    } else {
                        AbsHListView.this.c(AbsHListView.this.getChildAt(i9 - i2).getLeft() - this.cDS, (int) (this.cDQ * (Math.abs(left) / AbsHListView.this.getWidth())), true);
                        return;
                    }
                default:
                    return;
            }
        }
    }

    public void setFriction(float f2) {
        if (this.cCK == null) {
            this.cCK = new e();
        }
        this.cCK.cDD.setFriction(f2);
    }

    public void setVelocityScale(float f2) {
        this.cDg = f2;
    }

    public void smoothScrollToPosition(int i2, int i3) {
        if (this.cCL == null) {
            this.cCL = new j();
        }
        this.cCL.aC(i2, i3);
    }

    public void smoothScrollBy(int i2, int i3) {
        c(i2, i3, false);
    }

    public void c(int i2, int i3, boolean z) {
        if (this.cCK == null) {
            this.cCK = new e();
        }
        int i4 = this.cEm;
        int childCount = getChildCount();
        int i5 = i4 + childCount;
        int paddingLeft = getPaddingLeft();
        int width = getWidth() - getPaddingRight();
        if (i2 == 0 || this.cEz == 0 || childCount == 0 || ((i4 == 0 && getChildAt(0).getLeft() == paddingLeft && i2 < 0) || (i5 == this.cEz && getChildAt(childCount - 1).getRight() == width && i2 > 0))) {
            this.cCK.akG();
            if (this.cCL != null) {
                this.cCL.stop();
                return;
            }
            return;
        }
        jZ(2);
        this.cCK.d(i2, i3, z);
    }

    private void akx() {
        if (this.mScrollingCacheEnabled && !this.cCA && !this.cCe.isHardwareAccelerated()) {
            setChildrenDrawnWithCacheEnabled(true);
            setChildrenDrawingCacheEnabled(true);
            this.cCB = true;
            this.cCA = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aky() {
        if (!this.cCe.isHardwareAccelerated()) {
            if (this.cDe == null) {
                this.cDe = new com.baidu.tieba.horizonalList.widget.b(this);
            }
            post(this.cDe);
        }
    }

    boolean aA(int i2, int i3) {
        int min;
        int min2;
        int i4;
        int childCount = getChildCount();
        if (childCount == 0) {
            return true;
        }
        int left = getChildAt(0).getLeft();
        int right = getChildAt(childCount - 1).getRight();
        Rect rect = this.cCw;
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
        int i6 = this.cEm;
        if (i6 == 0) {
            this.cDm = left - rect.left;
        } else {
            this.cDm += min2;
        }
        if (i6 + childCount == this.cEz) {
            this.cDn = rect.right + right;
        } else {
            this.cDn += min2;
        }
        boolean z = i6 == 0 && left >= rect.left && min2 >= 0;
        boolean z2 = i6 + childCount == this.cEz && right <= getWidth() - rect.right && min2 <= 0;
        if (z || z2) {
            return min2 != 0;
        }
        boolean z3 = min2 < 0;
        boolean isInTouchMode = isInTouchMode();
        if (isInTouchMode) {
            akz();
        }
        int headerViewsCount = getHeaderViewsCount();
        int footerViewsCount = this.cEz - getFooterViewsCount();
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
                    this.cCr.r(childAt, i11);
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
                    this.cCr.r(childAt2, i14);
                }
                i4 = i13;
                i7 = i12;
            }
        }
        this.cCE = this.cCD + min;
        this.cEH = true;
        if (i4 > 0) {
            detachViewsFromParent(i7, i4);
            this.cCr.akK();
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        ka(min2);
        if (z3) {
            this.cEm = i4 + this.cEm;
        }
        int abs = Math.abs(min2);
        if (i5 < abs || width < abs) {
            fb(z3);
        }
        if (!isInTouchMode && this.ckM != -1) {
            int i15 = this.ckM - this.cEm;
            if (i15 >= 0 && i15 < getChildCount()) {
                c(this.ckM, getChildAt(i15));
            }
        } else if (this.cCp != -1) {
            int i16 = this.cCp - this.cEm;
            if (i16 >= 0 && i16 < getChildCount()) {
                c(-1, getChildAt(i16));
            }
        } else {
            this.cCq.setEmpty();
        }
        this.cEH = false;
        akk();
        return false;
    }

    public void ka(int i2) {
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
    public void akz() {
        if (this.ckM != -1) {
            if (this.cCl != 4) {
                this.cCR = this.ckM;
            }
            if (this.cEw >= 0 && this.cEw != this.ckM) {
                this.cCR = this.cEw;
            }
            setSelectedPositionInt(-1);
            setNextSelectedPositionInt(-1);
            this.cCM = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int akA() {
        int i2 = this.ckM;
        if (i2 < 0) {
            i2 = this.cCR;
        }
        return Math.min(Math.max(0, i2), this.cEz - 1);
    }

    protected int kc(int i2) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return -1;
        }
        int kb = kb(i2);
        return kb == -1 ? (this.cEm + childCount) - 1 : kb;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean akB() {
        if (this.ckM >= 0 || !akC()) {
            return false;
        }
        aks();
        return true;
    }

    boolean akC() {
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
        int i8 = this.cCw.left;
        int right = (getRight() - getLeft()) - this.cCw.right;
        int i9 = this.cEm;
        int i10 = this.cCR;
        if (i10 >= i9 && i10 < i9 + childCount) {
            View childAt = getChildAt(i10 - this.cEm);
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
            int i15 = this.cEz;
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
        this.cCR = -1;
        removeCallbacks(this.cCK);
        if (this.cCL != null) {
            this.cCL.stop();
        }
        this.cCH = -1;
        aky();
        this.cEn = i2;
        int q = q(i3, z);
        if (q < i9 || q > getLastVisiblePosition()) {
            q = -1;
        } else {
            this.cCl = 4;
            aks();
            setSelectionInt(q);
            akk();
        }
        jZ(0);
        return q >= 0;
    }

    void akD() {
        int i2;
        boolean z;
        boolean z2;
        this.cCj.clear();
        int i3 = 0;
        boolean z3 = false;
        while (i3 < this.cCk.size()) {
            long keyAt = this.cCk.keyAt(i3);
            int intValue = this.cCk.valueAt(i3).intValue();
            if (keyAt != this.mAdapter.getItemId(intValue)) {
                int max = Math.max(0, intValue - 20);
                int min = Math.min(intValue + 20, this.cEz);
                while (true) {
                    if (max >= min) {
                        z2 = false;
                        break;
                    } else if (keyAt != this.mAdapter.getItemId(max)) {
                        max++;
                    } else {
                        this.cCj.put(max, true);
                        this.cCk.setValueAt(i3, Integer.valueOf(max));
                        z2 = true;
                        break;
                    }
                }
                if (!z2) {
                    this.cCk.delete(keyAt);
                    int i4 = i3 - 1;
                    this.cCi--;
                    if (Build.VERSION.SDK_INT <= 11 || this.cCg == null || this.cCh == null) {
                        i2 = i4;
                        z = true;
                    } else {
                        ((com.baidu.tieba.horizonalList.a.a.b) this.cCh).onItemCheckedStateChanged((ActionMode) this.cCg, intValue, keyAt, false);
                        i2 = i4;
                        z = true;
                    }
                    z3 = z;
                    i3 = i2 + 1;
                }
            } else {
                this.cCj.put(intValue, true);
            }
            i2 = i3;
            z = z3;
            z3 = z;
            i3 = i2 + 1;
        }
        if (z3 && this.cCg != null && Build.VERSION.SDK_INT > 11) {
            ((ActionMode) this.cCg).invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.g
    public void handleDataChanged() {
        int i2 = this.cEz;
        int i3 = this.cDv;
        this.cDv = this.cEz;
        if (this.cCf != 0 && this.mAdapter != null && this.mAdapter.hasStableIds()) {
            akD();
        }
        this.cCr.akJ();
        if (i2 > 0) {
            if (this.cEr) {
                this.cEr = false;
                this.cDx = null;
                if (this.cDa == 2) {
                    this.cCl = 3;
                    return;
                }
                if (this.cDa == 1) {
                    if (this.cDo) {
                        this.cDo = false;
                        this.cCl = 3;
                        return;
                    }
                    int childCount = getChildCount();
                    int width = getWidth() - getPaddingRight();
                    View childAt = getChildAt(childCount - 1);
                    int bottom = childAt != null ? childAt.getBottom() : width;
                    if (childCount + this.cEm >= i3 && bottom <= width) {
                        this.cCl = 3;
                        return;
                    }
                    awakenScrollBars();
                }
                switch (this.cEs) {
                    case 1:
                        this.cCl = 5;
                        this.cEo = Math.min(Math.max(0, this.cEo), i2 - 1);
                        return;
                    case 0:
                        if (isInTouchMode()) {
                            this.cCl = 5;
                            this.cEo = Math.min(Math.max(0, this.cEo), i2 - 1);
                            return;
                        }
                        int akV = akV();
                        if (akV >= 0 && q(akV, true) == akV) {
                            this.cEo = akV;
                            if (this.cEq == getWidth()) {
                                this.cCl = 5;
                            } else {
                                this.cCl = 2;
                            }
                            setNextSelectedPositionInt(akV);
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
            } else if (this.cCR >= 0) {
                return;
            }
        }
        this.cCl = this.cCN ? 3 : 1;
        this.ckM = -1;
        this.cEy = Long.MIN_VALUE;
        this.cEw = -1;
        this.cEx = Long.MIN_VALUE;
        this.cEr = false;
        this.cDx = null;
        this.cCp = -1;
        akU();
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
        this.cDa = i2;
    }

    public int getTranscriptMode() {
        return this.cDa;
    }

    @Override // android.view.View
    public int getSolidColor() {
        return this.cDb;
    }

    public void setCacheColorHint(int i2) {
        if (i2 != this.cDb) {
            this.cDb = i2;
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                getChildAt(i3).setDrawingCacheBackgroundColor(i2);
            }
            this.cCr.setCacheColorHint(i2);
        }
    }

    @ViewDebug.ExportedProperty(category = "drawing")
    public int getCacheColorHint() {
        return this.cDb;
    }

    private void akE() {
        if (this.cDk != null) {
            this.cDk.finish();
            this.cDl.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aB(int i2, int i3) {
    }

    public void setRecyclerListener(l lVar) {
        this.cCr.cDV = lVar;
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
        public int cDH;
        public boolean cDI;
        public boolean cDJ;
        public int cDK;
        public long cDL;

        public f(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.cDL = -1L;
        }

        public f(int i, int i2) {
            super(i, i2);
            this.cDL = -1L;
        }

        public f(int i, int i2, int i3) {
            super(i, i2);
            this.cDL = -1L;
            this.cDH = i3;
        }

        public f(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.cDL = -1L;
        }
    }

    /* loaded from: classes.dex */
    public class k {
        private l cDV;
        private int cDW;
        private View[] cDX = new View[0];
        private ArrayList<View>[] cDY;
        private int cDZ;
        private ArrayList<View> cEa;
        private ArrayList<View> cEb;
        private SparseArrayCompat<View> cEc;

        public k() {
        }

        public void kg(int i) {
            if (i < 1) {
                throw new IllegalArgumentException("Can't have a viewTypeCount < 1");
            }
            ArrayList<View>[] arrayListArr = new ArrayList[i];
            for (int i2 = 0; i2 < i; i2++) {
                arrayListArr[i2] = new ArrayList<>();
            }
            this.cDZ = i;
            this.cEa = arrayListArr[0];
            this.cDY = arrayListArr;
        }

        public void akI() {
            if (this.cDZ == 1) {
                ArrayList<View> arrayList = this.cEa;
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    arrayList.get(i).forceLayout();
                }
            } else {
                int i2 = this.cDZ;
                for (int i3 = 0; i3 < i2; i3++) {
                    ArrayList<View> arrayList2 = this.cDY[i3];
                    int size2 = arrayList2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        arrayList2.get(i4).forceLayout();
                    }
                }
            }
            if (this.cEc != null) {
                int size3 = this.cEc.size();
                for (int i5 = 0; i5 < size3; i5++) {
                    this.cEc.valueAt(i5).forceLayout();
                }
            }
        }

        public boolean kh(int i) {
            return i >= 0;
        }

        public void clear() {
            if (this.cDZ == 1) {
                ArrayList<View> arrayList = this.cEa;
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    AbsHListView.this.removeDetachedView(arrayList.remove((size - 1) - i), false);
                }
            } else {
                int i2 = this.cDZ;
                for (int i3 = 0; i3 < i2; i3++) {
                    ArrayList<View> arrayList2 = this.cDY[i3];
                    int size2 = arrayList2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        AbsHListView.this.removeDetachedView(arrayList2.remove((size2 - 1) - i4), false);
                    }
                }
            }
            if (this.cEc != null) {
                this.cEc.clear();
            }
        }

        public void aD(int i, int i2) {
            if (this.cDX.length < i) {
                this.cDX = new View[i];
            }
            this.cDW = i2;
            View[] viewArr = this.cDX;
            for (int i3 = 0; i3 < i; i3++) {
                View childAt = AbsHListView.this.getChildAt(i3);
                f fVar = (f) childAt.getLayoutParams();
                if (fVar != null && fVar.cDH != -2) {
                    viewArr[i3] = childAt;
                }
            }
        }

        public View ki(int i) {
            int i2 = i - this.cDW;
            View[] viewArr = this.cDX;
            if (i2 < 0 || i2 >= viewArr.length) {
                return null;
            }
            View view = viewArr[i2];
            viewArr[i2] = null;
            return view;
        }

        View kj(int i) {
            int indexOfKey;
            if (this.cEc != null && (indexOfKey = this.cEc.indexOfKey(i)) >= 0) {
                View valueAt = this.cEc.valueAt(indexOfKey);
                this.cEc.removeAt(indexOfKey);
                return valueAt;
            }
            return null;
        }

        void akJ() {
            if (this.cEc != null) {
                this.cEc.clear();
            }
        }

        View kk(int i) {
            if (this.cDZ == 1) {
                return AbsHListView.a(this.cEa, i);
            }
            int itemViewType = AbsHListView.this.mAdapter.getItemViewType(i);
            if (itemViewType >= 0 && itemViewType < this.cDY.length) {
                return AbsHListView.a(this.cDY[itemViewType], i);
            }
            return null;
        }

        public void r(View view, int i) {
            f fVar = (f) view.getLayoutParams();
            if (fVar != null) {
                fVar.cDK = i;
                int i2 = fVar.cDH;
                if (!kh(i2)) {
                    if (i2 != -2) {
                        if (this.cEb == null) {
                            this.cEb = new ArrayList<>();
                        }
                        this.cEb.add(view);
                        return;
                    }
                    return;
                }
                view.onStartTemporaryDetach();
                if (this.cDZ == 1) {
                    this.cEa.add(view);
                } else {
                    this.cDY[i2].add(view);
                }
                if (Build.VERSION.SDK_INT >= 14) {
                    view.setAccessibilityDelegate(null);
                }
                if (this.cDV != null) {
                    this.cDV.onMovedToScrapHeap(view);
                }
            }
        }

        public void akK() {
            if (this.cEb != null) {
                int size = this.cEb.size();
                for (int i = 0; i < size; i++) {
                    AbsHListView.this.removeDetachedView(this.cEb.get(i), false);
                }
                this.cEb.clear();
            }
        }

        public void akL() {
            View[] viewArr = this.cDX;
            boolean z = this.cDV != null;
            boolean z2 = this.cDZ > 1;
            ArrayList<View> arrayList = this.cEa;
            for (int length = viewArr.length - 1; length >= 0; length--) {
                View view = viewArr[length];
                if (view != null) {
                    f fVar = (f) view.getLayoutParams();
                    int i = fVar.cDH;
                    viewArr[length] = null;
                    if (!kh(i)) {
                        if (i != -2) {
                            AbsHListView.this.removeDetachedView(view, false);
                        }
                    } else {
                        if (z2) {
                            arrayList = this.cDY[i];
                        }
                        view.onStartTemporaryDetach();
                        fVar.cDK = this.cDW + length;
                        arrayList.add(view);
                        if (Build.VERSION.SDK_INT >= 14) {
                            view.setAccessibilityDelegate(null);
                        }
                        if (z) {
                            this.cDV.onMovedToScrapHeap(view);
                        }
                    }
                }
            }
            akM();
        }

        private void akM() {
            int length = this.cDX.length;
            int i = this.cDZ;
            ArrayList<View>[] arrayListArr = this.cDY;
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
            if (this.cEc != null) {
                for (int i6 = 0; i6 < this.cEc.size(); i6++) {
                    this.cEc.valueAt(i6);
                }
            }
        }

        void setCacheColorHint(int i) {
            View[] viewArr;
            if (this.cDZ == 1) {
                ArrayList<View> arrayList = this.cEa;
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    arrayList.get(i2).setDrawingCacheBackgroundColor(i);
                }
            } else {
                int i3 = this.cDZ;
                for (int i4 = 0; i4 < i3; i4++) {
                    ArrayList<View> arrayList2 = this.cDY[i4];
                    int size2 = arrayList2.size();
                    for (int i5 = 0; i5 < size2; i5++) {
                        arrayList2.get(i5).setDrawingCacheBackgroundColor(i);
                    }
                }
            }
            for (View view : this.cDX) {
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
                if (((f) view.getLayoutParams()).cDK == i2) {
                    arrayList.remove(i3);
                    return view;
                }
            }
            return arrayList.remove(size - 1);
        }
        return null;
    }
}
