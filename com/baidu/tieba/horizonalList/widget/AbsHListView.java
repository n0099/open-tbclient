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
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class AbsHListView extends com.baidu.tieba.horizonalList.widget.g<ListAdapter> implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnTouchModeChangeListener {
    static final Interpolator cJJ = new LinearInterpolator();
    public static final int[] cJL = new int[1];
    Drawable AG;
    protected a cIA;
    boolean cIB;
    boolean cIC;
    int cID;
    protected Rect cIE;
    protected final k cIF;
    int cIG;
    int cIH;
    int cII;
    int cIJ;
    protected Rect cIK;
    protected int cIL;
    View cIM;
    View cIN;
    protected boolean cIO;
    protected boolean cIP;
    protected int cIQ;
    int cIR;
    int cIS;
    int cIT;
    int cIU;
    int cIV;
    int cIW;
    private e cIX;
    protected j cIY;
    protected int cIZ;
    a.AbstractC0063a cIs;
    protected int cIt;
    public Object cIu;
    Object cIv;
    int cIw;
    protected SparseArrayCompat<Boolean> cIx;
    LongSparseArray<Integer> cIy;
    protected int cIz;
    private int cJA;
    private boolean cJB;
    private int cJC;
    private int cJD;
    private g cJE;
    private int cJF;
    private int cJG;
    protected boolean cJH;
    private int cJI;
    private SavedState cJK;
    private float cJM;
    protected boolean cJa;
    private h cJb;
    private boolean cJc;
    private Rect cJd;
    protected int cJe;
    private ContextMenu.ContextMenuInfo cJf;
    protected int cJg;
    private int cJh;
    private c cJi;
    private Runnable cJj;
    private b cJk;
    private i cJl;
    private Runnable cJm;
    private int cJn;
    private int cJo;
    private boolean cJp;
    private int cJq;
    private Runnable cJr;
    protected Runnable cJs;
    private float cJt;
    protected final boolean[] cJu;
    int cJv;
    int cJw;
    private EdgeEffectCompat cJx;
    private EdgeEffectCompat cJy;
    private int cJz;
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

    protected abstract void ff(boolean z);

    protected abstract int kn(int i2);

    public abstract void setSelectionInt(int i2);

    public AbsHListView(Context context) {
        super(context);
        this.cIt = 0;
        this.cIz = 0;
        this.cIC = false;
        this.cID = -1;
        this.cIE = new Rect();
        this.cIF = new k();
        this.cIG = 0;
        this.cIH = 0;
        this.cII = 0;
        this.cIJ = 0;
        this.cIK = new Rect();
        this.cIL = 0;
        this.mTouchMode = -1;
        this.cIZ = 0;
        this.cJc = true;
        this.cJe = -1;
        this.cJf = null;
        this.cJh = -1;
        this.cJq = 0;
        this.cJt = 1.0f;
        this.cJu = new boolean[1];
        this.mActivePointerId = -1;
        this.mDirection = 0;
        ane();
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
        this.cIt = 0;
        this.cIz = 0;
        this.cIC = false;
        this.cID = -1;
        this.cIE = new Rect();
        this.cIF = new k();
        this.cIG = 0;
        this.cIH = 0;
        this.cII = 0;
        this.cIJ = 0;
        this.cIK = new Rect();
        this.cIL = 0;
        this.mTouchMode = -1;
        this.cIZ = 0;
        this.cJc = true;
        this.cJe = -1;
        this.cJf = null;
        this.cJh = -1;
        this.cJq = 0;
        this.cJt = 1.0f;
        this.cJu = new boolean[1];
        this.mActivePointerId = -1;
        this.mDirection = 0;
        ane();
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
        this.cIC = z3;
        setStackFromRight(z2);
        setScrollingCacheEnabled(z);
        setTranscriptMode(i3);
        setCacheColorHint(i4);
        setSmoothScrollbarEnabled(z4);
        setChoiceMode(i5);
    }

    private void ane() {
        setClickable(true);
        setFocusableInTouchMode(true);
        setWillNotDraw(false);
        setAlwaysDrawnWithCacheEnabled(false);
        setScrollingCacheEnabled(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.cJv = viewConfiguration.getScaledOverscrollDistance();
        this.cJw = viewConfiguration.getScaledOverflingDistance();
        this.cIs = com.baidu.tieba.horizonalList.a.a.av(this);
    }

    @Override // android.view.View
    public void setOverScrollMode(int i2) {
        if (i2 != 2) {
            if (this.cJx == null) {
                Context context = getContext();
                this.cJx = new EdgeEffectCompat(context);
                this.cJy = new EdgeEffectCompat(context);
            }
        } else {
            this.cJx = null;
            this.cJy = null;
        }
        super.setOverScrollMode(i2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.horizonalList.widget.g
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            this.cIB = this.mAdapter.hasStableIds();
            if (this.cIt != 0 && this.cIB && this.cIy == null) {
                this.cIy = new LongSparseArray<>();
            }
        }
        if (this.cIx != null) {
            this.cIx.clear();
        }
        if (this.cIy != null) {
            this.cIy.clear();
        }
    }

    public int getCheckedItemCount() {
        return this.cIw;
    }

    public boolean isItemChecked(int i2) {
        if (this.cIt == 0 || this.cIx == null) {
            return false;
        }
        return this.cIx.get(i2, false).booleanValue();
    }

    public int getCheckedItemPosition() {
        if (this.cIt == 1 && this.cIx != null && this.cIx.size() == 1) {
            return this.cIx.keyAt(0);
        }
        return -1;
    }

    public SparseArrayCompat<Boolean> getCheckedItemPositions() {
        if (this.cIt != 0) {
            return this.cIx;
        }
        return null;
    }

    public long[] getCheckedItemIds() {
        if (this.cIt == 0 || this.cIy == null || this.mAdapter == null) {
            return new long[0];
        }
        LongSparseArray<Integer> longSparseArray = this.cIy;
        int size = longSparseArray.size();
        long[] jArr = new long[size];
        for (int i2 = 0; i2 < size; i2++) {
            jArr[i2] = longSparseArray.keyAt(i2);
        }
        return jArr;
    }

    public void clearChoices() {
        if (this.cIx != null) {
            this.cIx.clear();
        }
        if (this.cIy != null) {
            this.cIy.clear();
        }
        this.cIw = 0;
    }

    public void setItemChecked(int i2, boolean z) {
        if (this.cIt != 0) {
            if (Build.VERSION.SDK_INT >= 11 && z && this.cIt == 3 && this.cIu == null) {
                if (this.cIv == null || !((com.baidu.tieba.horizonalList.a.a.b) this.cIv).and()) {
                    throw new IllegalStateException("AbsListView: attempted to start selection mode for CHOICE_MODE_MULTIPLE_MODAL but no choice mode callback was supplied. Call setMultiChoiceModeListener to set a callback.");
                }
                this.cIu = startActionMode((com.baidu.tieba.horizonalList.a.a.b) this.cIv);
            }
            if (this.cIt == 2 || (Build.VERSION.SDK_INT >= 11 && this.cIt == 3)) {
                boolean booleanValue = this.cIx.get(i2, false).booleanValue();
                this.cIx.put(i2, Boolean.valueOf(z));
                if (this.cIy != null && this.mAdapter.hasStableIds()) {
                    if (z) {
                        this.cIy.put(this.mAdapter.getItemId(i2), Integer.valueOf(i2));
                    } else {
                        this.cIy.delete(this.mAdapter.getItemId(i2));
                    }
                }
                if (booleanValue != z) {
                    if (z) {
                        this.cIw++;
                    } else {
                        this.cIw--;
                    }
                }
                if (this.cIu != null) {
                    ((com.baidu.tieba.horizonalList.a.a.b) this.cIv).onItemCheckedStateChanged((ActionMode) this.cIu, i2, this.mAdapter.getItemId(i2), z);
                }
            } else {
                boolean z2 = this.cIy != null && this.mAdapter.hasStableIds();
                if (z || isItemChecked(i2)) {
                    this.cIx.clear();
                    if (z2) {
                        this.cIy.clear();
                    }
                }
                if (z) {
                    this.cIx.put(i2, true);
                    if (z2) {
                        this.cIy.put(this.mAdapter.getItemId(i2), Integer.valueOf(i2));
                    }
                    this.cIw = 1;
                } else if (this.cIx.size() == 0 || !this.cIx.valueAt(0).booleanValue()) {
                    this.cIw = 0;
                }
            }
            if (!this.mInLayout && !this.cKT) {
                this.aeA = true;
                anT();
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
        if (this.cIt != 0) {
            if (this.cIt == 2 || (Build.VERSION.SDK_INT >= 11 && this.cIt == 3 && this.cIu != null)) {
                boolean z5 = !this.cIx.get(i2, false).booleanValue();
                this.cIx.put(i2, Boolean.valueOf(z5));
                if (this.cIy != null && this.mAdapter.hasStableIds()) {
                    if (z5) {
                        this.cIy.put(this.mAdapter.getItemId(i2), Integer.valueOf(i2));
                    } else {
                        this.cIy.delete(this.mAdapter.getItemId(i2));
                    }
                }
                if (z5) {
                    this.cIw++;
                } else {
                    this.cIw--;
                }
                if (this.cIu != null) {
                    ((com.baidu.tieba.horizonalList.a.a.b) this.cIv).onItemCheckedStateChanged((ActionMode) this.cIu, i2, j2, z5);
                } else {
                    z4 = true;
                }
                z2 = z4;
                z4 = true;
            } else if (this.cIt == 1) {
                if (!this.cIx.get(i2, false).booleanValue()) {
                    this.cIx.clear();
                    this.cIx.put(i2, true);
                    if (this.cIy != null && this.mAdapter.hasStableIds()) {
                        this.cIy.clear();
                        this.cIy.put(this.mAdapter.getItemId(i2), Integer.valueOf(i2));
                    }
                    this.cIw = 1;
                } else if (this.cIx.size() == 0 || !this.cIx.valueAt(0).booleanValue()) {
                    this.cIw = 0;
                }
                z4 = true;
                z2 = true;
            } else {
                z2 = true;
            }
            if (z4) {
                anf();
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

    private void anf() {
        int i2 = this.bxA;
        int childCount = getChildCount();
        boolean z = Build.VERSION.SDK_INT >= 11;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            int i4 = i2 + i3;
            if (childAt instanceof Checkable) {
                ((Checkable) childAt).setChecked(this.cIx.get(i4, false).booleanValue());
            } else if (z) {
                childAt.setActivated(this.cIx.get(i4, false).booleanValue());
            }
        }
    }

    public int getChoiceMode() {
        return this.cIt;
    }

    public void setChoiceMode(int i2) {
        this.cIt = i2;
        if (Build.VERSION.SDK_INT >= 11 && this.cIu != null) {
            if (Build.VERSION.SDK_INT >= 11) {
                ((ActionMode) this.cIu).finish();
            }
            this.cIu = null;
        }
        if (this.cIt != 0) {
            if (this.cIx == null) {
                this.cIx = new SparseArrayCompat<>();
            }
            if (this.cIy == null && this.mAdapter != null && this.mAdapter.hasStableIds()) {
                this.cIy = new LongSparseArray<>();
            }
            if (Build.VERSION.SDK_INT >= 11 && this.cIt == 3) {
                clearChoices();
                setLongClickable(true);
            }
        }
    }

    public void setMultiChoiceModeListener(com.baidu.tieba.horizonalList.a.a.a aVar) {
        if (Build.VERSION.SDK_INT >= 11) {
            if (this.cIv == null) {
                this.cIv = new com.baidu.tieba.horizonalList.a.a.b(this);
            }
            ((com.baidu.tieba.horizonalList.a.a.b) this.cIv).a(aVar);
            return;
        }
        Log.e("AbsListView", "setMultiChoiceModeListener not supported for this version of Android");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ang() {
        int childCount = getChildCount();
        if (childCount == 0) {
            return true;
        }
        if (childCount != this.cKL) {
            return false;
        }
        return getChildAt(0).getLeft() >= this.cIK.left && getChildAt(childCount + (-1)).getRight() <= getWidth() - this.cIK.right;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public int getHorizontalScrollbarHeight() {
        return super.getHorizontalScrollbarHeight();
    }

    public void setSmoothScrollbarEnabled(boolean z) {
        this.cJc = z;
    }

    public void setOnScrollListener(h hVar) {
        this.cJb = hVar;
        anh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void anh() {
        if (this.cJb != null) {
            this.cJb.a(this, this.bxA, getChildCount(), this.cKL);
        }
        onScrollChanged(0, 0, 0, 0);
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEvent(int i2) {
        if (i2 == 4096) {
            int firstVisiblePosition = getFirstVisiblePosition();
            int lastVisiblePosition = getLastVisiblePosition();
            if (this.cJF != firstVisiblePosition || this.cJG != lastVisiblePosition) {
                this.cJF = firstVisiblePosition;
                this.cJG = lastVisiblePosition;
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
            anv();
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

    private void ani() {
        setSelector(getResources().getDrawable(17301602));
    }

    public void setStackFromRight(boolean z) {
        if (this.cJa != z) {
            this.cJa = z;
            anj();
        }
    }

    void anj() {
        if (getChildCount() > 0) {
            ank();
            requestLayout();
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new com.baidu.tieba.horizonalList.widget.f();
        long cKq;
        long cKr;
        int cKs;
        String cKt;
        boolean cKu;
        int cKv;
        SparseArrayCompat<Boolean> cKw;
        LongSparseArray<Integer> cKx;
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
            this.cKq = parcel.readLong();
            this.cKr = parcel.readLong();
            this.cKs = parcel.readInt();
            this.position = parcel.readInt();
            this.width = parcel.readInt();
            this.cKt = parcel.readString();
            this.cKu = parcel.readByte() != 0;
            this.cKv = parcel.readInt();
            this.cKw = j(parcel);
            this.cKx = i(parcel);
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
            parcel.writeLong(this.cKq);
            parcel.writeLong(this.cKr);
            parcel.writeInt(this.cKs);
            parcel.writeInt(this.position);
            parcel.writeInt(this.width);
            parcel.writeString(this.cKt);
            parcel.writeByte((byte) (this.cKu ? 1 : 0));
            parcel.writeInt(this.cKv);
            a(this.cKw, parcel);
            a(this.cKx, parcel);
        }

        public String toString() {
            return "AbsListView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " selectedId=" + this.cKq + " firstId=" + this.cKr + " viewLeft=" + this.cKs + " position=" + this.position + " width=" + this.width + " filter=" + this.cKt + " checkState=" + this.cKw + "}";
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        boolean z = true;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.cJK != null) {
            savedState.cKq = this.cJK.cKq;
            savedState.cKr = this.cJK.cKr;
            savedState.cKs = this.cJK.cKs;
            savedState.position = this.cJK.position;
            savedState.width = this.cJK.width;
            savedState.cKt = this.cJK.cKt;
            savedState.cKu = this.cJK.cKu;
            savedState.cKv = this.cJK.cKv;
            savedState.cKw = this.cJK.cKw;
            savedState.cKx = this.cJK.cKx;
            return savedState;
        }
        boolean z2 = getChildCount() > 0 && this.cKL > 0;
        long selectedItemId = getSelectedItemId();
        savedState.cKq = selectedItemId;
        savedState.width = getWidth();
        if (selectedItemId >= 0) {
            savedState.cKs = this.cIZ;
            savedState.position = getSelectedItemPosition();
            savedState.cKr = -1L;
        } else if (z2 && this.bxA > 0) {
            savedState.cKs = getChildAt(0).getLeft();
            int i2 = this.bxA;
            if (i2 >= this.cKL) {
                i2 = this.cKL - 1;
            }
            savedState.position = i2;
            savedState.cKr = this.mAdapter.getItemId(i2);
        } else {
            savedState.cKs = 0;
            savedState.cKr = -1L;
            savedState.position = 0;
        }
        savedState.cKt = null;
        savedState.cKu = (Build.VERSION.SDK_INT < 11 || this.cIt != 3 || this.cIu == null) ? false : false;
        if (this.cIx != null) {
            try {
                savedState.cKw = this.cIx.m1clone();
            } catch (NoSuchMethodError e2) {
                e2.printStackTrace();
                savedState.cKw = new SparseArrayCompat<>();
            }
        }
        if (this.cIy != null) {
            LongSparseArray<Integer> longSparseArray = new LongSparseArray<>();
            int size = this.cIy.size();
            for (int i3 = 0; i3 < size; i3++) {
                longSparseArray.put(this.cIy.keyAt(i3), this.cIy.valueAt(i3));
            }
            savedState.cKx = longSparseArray;
        }
        savedState.cKv = this.cIw;
        return savedState;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.aeA = true;
        this.cKC = savedState.width;
        if (savedState.cKq >= 0) {
            this.cKD = true;
            this.cJK = savedState;
            this.cKB = savedState.cKq;
            this.cKA = savedState.position;
            this.cKz = savedState.cKs;
            this.cKE = 0;
        } else if (savedState.cKr >= 0) {
            setSelectedPositionInt(-1);
            setNextSelectedPositionInt(-1);
            this.cID = -1;
            this.cKD = true;
            this.cJK = savedState;
            this.cKB = savedState.cKr;
            this.cKA = savedState.position;
            this.cKz = savedState.cKs;
            this.cKE = 1;
        }
        if (savedState.cKw != null) {
            this.cIx = savedState.cKw;
        }
        if (savedState.cKx != null) {
            this.cIy = savedState.cKx;
        }
        this.cIw = savedState.cKv;
        if (Build.VERSION.SDK_INT >= 11 && savedState.cKu && this.cIt == 3 && this.cIv != null) {
            this.cIu = startActionMode((com.baidu.tieba.horizonalList.a.a.b) this.cIv);
        }
        requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onFocusChanged(boolean z, int i2, Rect rect) {
        super.onFocusChanged(z, i2, rect);
        if (z && this.csf < 0 && !isInTouchMode()) {
            if (!this.cJH && this.mAdapter != null) {
                this.aeA = true;
                this.cKM = this.cKL;
                this.cKL = this.mAdapter.getCount();
            }
            anz();
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (!this.cKT && !this.mInLayout) {
            super.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ank() {
        removeAllViewsInLayout();
        this.bxA = 0;
        this.aeA = false;
        this.cJs = null;
        this.cKD = false;
        this.cJK = null;
        this.cKO = -1;
        this.cKP = Long.MIN_VALUE;
        setSelectedPositionInt(-1);
        setNextSelectedPositionInt(-1);
        this.cIZ = 0;
        this.cID = -1;
        this.cIE.setEmpty();
        invalidate();
    }

    @Override // android.view.View
    protected int computeHorizontalScrollExtent() {
        int childCount = getChildCount();
        if (childCount > 0) {
            if (this.cJc) {
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
        int i3 = this.bxA;
        int childCount = getChildCount();
        if (i3 < 0 || childCount <= 0) {
            return 0;
        }
        if (this.cJc) {
            View childAt = getChildAt(0);
            int left = childAt.getLeft();
            int width = childAt.getWidth();
            if (width > 0) {
                return Math.max(((i3 * 100) - ((left * 100) / width)) + ((int) ((getScrollX() / getWidth()) * this.cKL * 100.0f)), 0);
            }
            return 0;
        }
        int i4 = this.cKL;
        if (i3 != 0) {
            i2 = i3 + childCount == i4 ? i4 : (childCount / 2) + i3;
        }
        return (int) (((i2 / i4) * childCount) + i3);
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        if (this.cJc) {
            int max = Math.max(this.cKL * 100, 0);
            if (getScrollX() != 0) {
                return max + Math.abs((int) ((getScrollX() / getWidth()) * this.cKL * 100.0f));
            }
            return max;
        }
        return this.cKL;
    }

    @Override // android.view.View
    protected float getLeftFadingEdgeStrength() {
        int childCount = getChildCount();
        float leftFadingEdgeStrength = super.getLeftFadingEdgeStrength();
        if (childCount != 0) {
            if (this.bxA > 0) {
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
            if ((this.bxA + childCount) - 1 < this.cKL - 1) {
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
            ani();
        }
        Rect rect = this.cIK;
        rect.left = this.cIG + getPaddingLeft();
        rect.top = this.cIH + getPaddingTop();
        rect.right = this.cII + getPaddingRight();
        rect.bottom = this.cIJ + getPaddingBottom();
        if (this.cJn == 1) {
            int childCount = getChildCount();
            int width = getWidth() - getPaddingRight();
            View childAt = getChildAt(childCount - 1);
            this.cJB = childCount + this.bxA >= this.cJI && (childAt != null ? childAt.getRight() : width) <= width;
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
            this.cIF.anF();
        }
        layoutChildren();
        this.mInLayout = false;
        this.cJg = (i4 - i2) / 3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void layoutChildren() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void anl() {
        boolean z = true;
        if (this.cIM != null) {
            boolean z2 = this.bxA > 0;
            if (!z2 && getChildCount() > 0) {
                z2 = getChildAt(0).getLeft() < this.cIK.left;
            }
            this.cIM.setVisibility(z2 ? 0 : 4);
        }
        if (this.cIN != null) {
            int childCount = getChildCount();
            boolean z3 = this.bxA + childCount < this.cKL;
            if (z3 || childCount <= 0) {
                z = z3;
            } else if (getChildAt(childCount - 1).getRight() <= getRight() - this.cIK.right) {
                z = false;
            }
            this.cIN.setVisibility(z ? 0 : 4);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.g
    @ViewDebug.ExportedProperty
    public View getSelectedView() {
        if (this.cKL <= 0 || this.csf < 0) {
            return null;
        }
        return getChildAt(this.csf - this.bxA);
    }

    public int getListPaddingTop() {
        return this.cIK.top;
    }

    public int getListPaddingBottom() {
        return this.cIK.bottom;
    }

    public int getListPaddingLeft() {
        return this.cIK.left;
    }

    public int getListPaddingRight() {
        return this.cIK.right;
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
        View kv = this.cIF.kv(i2);
        if (kv == null) {
            View kw = this.cIF.kw(i2);
            if (kw != null) {
                view = this.mAdapter.getView(i2, kw, this);
                if (view != kw) {
                    this.cIF.s(kw, i2);
                    if (this.cJo != 0) {
                        view.setDrawingCacheBackgroundColor(this.cJo);
                        kv = view;
                    }
                } else {
                    zArr[0] = true;
                    view.onFinishTemporaryDetach();
                    kv = view;
                }
                if (this.cIB) {
                    ViewGroup.LayoutParams layoutParams = kv.getLayoutParams();
                    if (layoutParams == null) {
                        fVar = (f) generateDefaultLayoutParams();
                    } else if (!checkLayoutParams(layoutParams)) {
                        fVar = (f) generateLayoutParams(layoutParams);
                    } else {
                        fVar = (f) layoutParams;
                    }
                    fVar.cJY = this.mAdapter.getItemId(i2);
                    kv.setLayoutParams(fVar);
                }
                if (this.cKN.isEnabled() && this.cJE == null) {
                    this.cJE = new g();
                }
            } else {
                view = this.mAdapter.getView(i2, null, this);
                if (this.cJo != 0) {
                    view.setDrawingCacheBackgroundColor(this.cJo);
                }
            }
            kv = view;
            if (this.cIB) {
            }
            if (this.cKN.isEnabled()) {
                this.cJE = new g();
            }
        }
        return kv;
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
            this.cID = i2;
        }
        Rect rect = this.cIE;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        if (view instanceof m) {
            ((m) view).adjustListItemSelectionBounds(rect);
        }
        k(rect.left, rect.top, rect.right, rect.bottom);
        boolean z = this.cJp;
        if (view.isEnabled() != z) {
            this.cJp = !z;
            if (getSelectedItemPosition() != -1) {
                refreshDrawableState();
            }
        }
    }

    private void k(int i2, int i3, int i4, int i5) {
        this.cIE.set(i2 - this.cIG, i3 - this.cIH, this.cII + i4, this.cIJ + i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        boolean z = this.cIC;
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
            this.aeA = true;
            anT();
        }
    }

    boolean anm() {
        switch (this.mTouchMode) {
            case 1:
            case 2:
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean ann() {
        return (hasFocus() && !isInTouchMode()) || anm();
    }

    private void s(Canvas canvas) {
        if (!this.cIE.isEmpty()) {
            Drawable drawable = this.AG;
            drawable.setBounds(this.cIE);
            drawable.draw(canvas);
        }
    }

    public void setDrawSelectorOnTop(boolean z) {
        this.cIC = z;
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
        this.cIG = rect.left;
        this.cIH = rect.top;
        this.cII = rect.right;
        this.cIJ = rect.bottom;
        drawable.setCallback(this);
        anp();
    }

    public Drawable getSelector() {
        return this.AG;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ano() {
        if (isEnabled() && isClickable()) {
            Drawable drawable = this.AG;
            Rect rect = this.cIE;
            if (drawable != null) {
                if ((isFocused() || anm()) && !rect.isEmpty()) {
                    View childAt = getChildAt(this.csf - this.bxA);
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
                    if (isLongClickable && !this.aeA) {
                        if (this.cJk == null) {
                            this.cJk = new b(this, null);
                        }
                        this.cJk.anK();
                        postDelayed(this.cJk, ViewConfiguration.getLongPressTimeout());
                    }
                }
            }
        }
    }

    void anp() {
        if (this.AG != null) {
            if (ann()) {
                this.AG.setState(getDrawableState());
            } else {
                this.AG.setState(cJL);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        anp();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i2) {
        if (this.cJp) {
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
        if (this.mAdapter != null && this.cIA == null) {
            this.cIA = new a();
            this.mAdapter.registerDataSetObserver(this.cIA);
            this.aeA = true;
            this.cKM = this.cKL;
            this.cKL = this.mAdapter.getCount();
        }
        this.cJH = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.g, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.cIF.clear();
        getViewTreeObserver().removeOnTouchModeChangeListener(this);
        if (this.mAdapter != null && this.cIA != null) {
            this.mAdapter.unregisterDataSetObserver(this.cIA);
            this.cIA = null;
        }
        if (this.cIX != null) {
            removeCallbacks(this.cIX);
        }
        if (this.cIY != null) {
            this.cIY.stop();
        }
        if (this.cJr != null) {
            removeCallbacks(this.cJr);
        }
        if (this.cJl != null) {
            removeCallbacks(this.cJl);
        }
        if (this.cJm != null) {
            removeCallbacks(this.cJm);
            this.cJm = null;
        }
        this.cJH = false;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        int i2 = isInTouchMode() ? 0 : 1;
        if (!z) {
            setChildrenDrawingCacheEnabled(false);
            if (this.cIX != null) {
                removeCallbacks(this.cIX);
                this.cIX.anD();
                if (this.cIY != null) {
                    this.cIY.stop();
                }
                if (getScrollX() != 0) {
                    this.cIs.setScrollX(0);
                    anB();
                    invalidate();
                }
            }
            if (i2 == 1) {
                this.cJe = this.csf;
            }
        } else if (i2 != this.cJh && this.cJh != -1) {
            if (i2 == 1) {
                anz();
            } else {
                anw();
                this.cIz = 0;
                layoutChildren();
            }
        }
        this.cJh = i2;
    }

    ContextMenu.ContextMenuInfo b(View view, int i2, long j2) {
        return new g.a(view, i2, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class n {
        private int cKy;

        private n() {
        }

        /* synthetic */ n(AbsHListView absHListView, n nVar) {
            this();
        }

        public void anK() {
            this.cKy = AbsHListView.this.getWindowAttachCount();
        }

        public boolean anL() {
            return AbsHListView.this.hasWindowFocus() && AbsHListView.this.getWindowAttachCount() == this.cKy;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class i extends n implements Runnable {
        int cJZ;

        private i() {
            super(AbsHListView.this, null);
        }

        /* synthetic */ i(AbsHListView absHListView, i iVar) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            View childAt;
            if (!AbsHListView.this.aeA) {
                ListAdapter listAdapter = AbsHListView.this.mAdapter;
                int i = this.cJZ;
                if (listAdapter != null && AbsHListView.this.cKL > 0 && i != -1 && i < listAdapter.getCount() && anL() && (childAt = AbsHListView.this.getChildAt(i - AbsHListView.this.bxA)) != null) {
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
            View childAt = AbsHListView.this.getChildAt(AbsHListView.this.cIQ - AbsHListView.this.bxA);
            if (childAt != null) {
                if ((!anL() || AbsHListView.this.aeA) ? false : AbsHListView.this.c(childAt, AbsHListView.this.cIQ, AbsHListView.this.mAdapter.getItemId(AbsHListView.this.cIQ))) {
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
            if (AbsHListView.this.isPressed() && AbsHListView.this.csf >= 0) {
                View childAt = AbsHListView.this.getChildAt(AbsHListView.this.csf - AbsHListView.this.bxA);
                if (!AbsHListView.this.aeA) {
                    if (anL() ? AbsHListView.this.c(childAt, AbsHListView.this.csf, AbsHListView.this.cKK) : false) {
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
        if (Build.VERSION.SDK_INT >= 11 && this.cIt == 3) {
            if (this.cIu == null) {
                ActionMode startActionMode = startActionMode((com.baidu.tieba.horizonalList.a.a.b) this.cIv);
                this.cIu = startActionMode;
                if (startActionMode != null) {
                    setItemChecked(i2, true);
                    performHapticFeedback(0);
                }
            }
            return true;
        }
        boolean b2 = this.cKH != null ? this.cKH.b(this, view, i2, j2) : false;
        if (!b2) {
            this.cJf = b(view, i2, j2);
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
        return this.cJf;
    }

    public boolean b(float f2, float f3, int i2) {
        int pointToPosition = pointToPosition((int) f2, (int) f3);
        if (pointToPosition != -1) {
            long itemId = this.mAdapter.getItemId(pointToPosition);
            View childAt = getChildAt(pointToPosition - this.bxA);
            if (childAt != null) {
                this.cJf = b(childAt, pointToPosition, itemId);
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
            boolean b2 = this.cKH != null ? this.cKH.b(this, view, positionForView, itemId) : false;
            if (!b2) {
                this.cJf = b(getChildAt(positionForView - this.bxA), positionForView, itemId);
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
                if (isClickable() && isPressed() && this.csf >= 0 && this.mAdapter != null && this.csf < this.mAdapter.getCount()) {
                    View childAt = getChildAt(this.csf - this.bxA);
                    if (childAt != null) {
                        performItemClick(childAt, this.csf, this.cKK);
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
        Rect rect = this.cJd;
        if (rect == null) {
            this.cJd = new Rect();
            rect = this.cJd;
        }
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt.getVisibility() == 0) {
                childAt.getHitRect(rect);
                if (rect.contains(i2, i3)) {
                    return this.bxA + childCount;
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
                View childAt = AbsHListView.this.getChildAt(AbsHListView.this.cIQ - AbsHListView.this.bxA);
                if (childAt != null && !childAt.hasFocusable()) {
                    AbsHListView.this.cIz = 0;
                    if (!AbsHListView.this.aeA) {
                        childAt.setPressed(true);
                        AbsHListView.this.setPressed(true);
                        AbsHListView.this.layoutChildren();
                        AbsHListView.this.b(AbsHListView.this.cIQ, childAt);
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
                            if (AbsHListView.this.cJi == null) {
                                AbsHListView.this.cJi = new c(AbsHListView.this, null);
                            }
                            AbsHListView.this.cJi.anK();
                            AbsHListView.this.postDelayed(AbsHListView.this.cJi, longPressTimeout);
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

    private boolean kj(int i2) {
        int i3 = i2 - this.cIT;
        int abs = Math.abs(i3);
        boolean z = getScrollX() != 0;
        if (z || abs > this.mTouchSlop) {
            anu();
            if (z) {
                this.mTouchMode = 5;
                this.cIW = 0;
            } else {
                this.mTouchMode = 3;
                this.cIW = i3 > 0 ? this.mTouchSlop : -this.mTouchSlop;
            }
            Handler handler = getHandler();
            if (handler != null) {
                handler.removeCallbacks(this.cJi);
            }
            setPressed(false);
            View childAt = getChildAt(this.cIQ - this.bxA);
            if (childAt != null) {
                childAt.setPressed(false);
            }
            kl(1);
            ViewParent parent = getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            kk(i2);
            return true;
        }
        return false;
    }

    private void kk(int i2) {
        int i3;
        int childCount;
        ViewParent parent;
        int i4 = i2 - this.cIT;
        int i5 = i4 - this.cIW;
        int i6 = this.cIV != Integer.MIN_VALUE ? i2 - this.cIV : i5;
        if (this.mTouchMode == 3) {
            if (i2 != this.cIV) {
                if (Math.abs(i4) > this.mTouchSlop && (parent = getParent()) != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
                if (this.cIQ >= 0) {
                    childCount = this.cIQ - this.bxA;
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
                        overScrollBy(i7, 0, getScrollX(), 0, 0, 0, this.cJv, 0, true);
                        if (Math.abs(this.cJv) == Math.abs(getScrollX()) && this.mVelocityTracker != null) {
                            this.mVelocityTracker.clear();
                        }
                        int overScrollMode = getOverScrollMode();
                        if (overScrollMode == 0 || (overScrollMode == 1 && !ang())) {
                            this.mDirection = 0;
                            this.mTouchMode = 5;
                            if (i4 > 0) {
                                this.cJx.onPull(i7 / getWidth());
                                if (!this.cJy.isFinished()) {
                                    this.cJy.onRelease();
                                }
                                invalidate();
                            } else if (i4 < 0) {
                                this.cJy.onPull(i7 / getWidth());
                                if (!this.cJx.isFinished()) {
                                    this.cJx.onRelease();
                                }
                                invalidate();
                            }
                        }
                    }
                    this.cIT = i2;
                }
                this.cIV = i2;
            }
        } else if (this.mTouchMode == 5 && i2 != this.cIV) {
            int scrollX = getScrollX();
            int i8 = scrollX - i6;
            int i9 = i2 > this.cIV ? 1 : -1;
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
                overScrollBy(i10, 0, getScrollX(), 0, 0, 0, this.cJv, 0, true);
                int overScrollMode2 = getOverScrollMode();
                if (overScrollMode2 == 0 || (overScrollMode2 == 1 && !ang())) {
                    if (i4 > 0) {
                        this.cJx.onPull(i10 / getWidth());
                        if (!this.cJy.isFinished()) {
                            this.cJy.onRelease();
                        }
                        invalidate();
                    } else if (i4 < 0) {
                        this.cJy.onPull(i10 / getWidth());
                        if (!this.cJx.isFinished()) {
                            this.cJx.onRelease();
                        }
                        invalidate();
                    }
                }
            }
            if (i3 != 0) {
                if (getScrollX() != 0) {
                    this.cIs.setScrollX(0);
                    anq();
                }
                aA(i3, i3);
                this.mTouchMode = 3;
                int ko = ko(i2);
                this.cIW = 0;
                View childAt3 = getChildAt(ko - this.bxA);
                this.cIR = childAt3 != null ? childAt3.getLeft() : 0;
                this.cIT = i2;
                this.cIQ = ko;
            }
            this.cIV = i2;
            this.mDirection = i9;
        }
    }

    protected void anq() {
        if (this.cIs.isHardwareAccelerated() && (getParent() instanceof View)) {
            ((View) getParent()).invalidate();
        }
    }

    @Override // android.view.ViewTreeObserver.OnTouchModeChangeListener
    public void onTouchModeChanged(boolean z) {
        if (z) {
            anw();
            if (getWidth() > 0 && getChildCount() > 0) {
                layoutChildren();
            }
            anp();
            return;
        }
        int i2 = this.mTouchMode;
        if (i2 == 5 || i2 == 6) {
            if (this.cIX != null) {
                this.cIX.anD();
            }
            if (this.cIY != null) {
                this.cIY.stop();
            }
            if (getScrollX() != 0) {
                this.cIs.setScrollX(0);
                anB();
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
        if (this.cIY != null) {
            this.cIY.stop();
        }
        if (this.cJH) {
            int action = motionEvent.getAction();
            ans();
            this.mVelocityTracker.addMovement(motionEvent);
            switch (action & MotionEventCompat.ACTION_MASK) {
                case 0:
                    switch (this.mTouchMode) {
                        case 6:
                            this.cIX.anD();
                            if (this.cIY != null) {
                                this.cIY.stop();
                            }
                            this.mTouchMode = 5;
                            this.cIU = (int) motionEvent.getY();
                            int x = (int) motionEvent.getX();
                            this.cIV = x;
                            this.cIT = x;
                            this.cIW = 0;
                            this.mActivePointerId = motionEvent.getPointerId(0);
                            this.mDirection = 0;
                            break;
                        default:
                            this.mActivePointerId = motionEvent.getPointerId(0);
                            int x2 = (int) motionEvent.getX();
                            int y = (int) motionEvent.getY();
                            int pointToPosition = pointToPosition(x2, y);
                            if (!this.aeA) {
                                if (this.mTouchMode != 4 && pointToPosition >= 0 && getAdapter().isEnabled(pointToPosition)) {
                                    this.mTouchMode = 0;
                                    if (this.cJj == null) {
                                        this.cJj = new d();
                                    }
                                    postDelayed(this.cJj, ViewConfiguration.getTapTimeout());
                                    i2 = pointToPosition;
                                } else if (this.mTouchMode == 4) {
                                    anu();
                                    this.mTouchMode = 3;
                                    this.cIW = 0;
                                    i2 = kn(x2);
                                    this.cIX.anE();
                                }
                                if (i2 >= 0) {
                                    this.cIR = getChildAt(i2 - this.bxA).getLeft();
                                }
                                this.cIT = x2;
                                this.cIU = y;
                                this.cIQ = i2;
                                this.cIV = ExploreByTouchHelper.INVALID_ID;
                                break;
                            }
                            i2 = pointToPosition;
                            if (i2 >= 0) {
                            }
                            this.cIT = x2;
                            this.cIU = y;
                            this.cIQ = i2;
                            this.cIV = ExploreByTouchHelper.INVALID_ID;
                    }
                    if (j(motionEvent) && this.mTouchMode == 0) {
                        removeCallbacks(this.cJj);
                        break;
                    }
                    break;
                case 1:
                    switch (this.mTouchMode) {
                        case 0:
                        case 1:
                        case 2:
                            int i3 = this.cIQ;
                            View childAt = getChildAt(i3 - this.bxA);
                            float x3 = motionEvent.getX();
                            boolean z = x3 > ((float) this.cIK.left) && x3 < ((float) (getWidth() - this.cIK.right));
                            if (childAt != null && !childAt.hasFocusable() && z) {
                                if (this.mTouchMode != 0) {
                                    childAt.setPressed(false);
                                }
                                if (this.cJl == null) {
                                    this.cJl = new i(this, null);
                                }
                                i iVar = this.cJl;
                                iVar.cJZ = i3;
                                iVar.anK();
                                this.cJe = i3;
                                if (this.mTouchMode == 0 || this.mTouchMode == 1) {
                                    Handler handler = getHandler();
                                    if (handler != null) {
                                        handler.removeCallbacks(this.mTouchMode == 0 ? this.cJj : this.cJi);
                                    }
                                    this.cIz = 0;
                                    if (!this.aeA && this.mAdapter.isEnabled(i3)) {
                                        this.mTouchMode = 1;
                                        setSelectedPositionInt(this.cIQ);
                                        layoutChildren();
                                        childAt.setPressed(true);
                                        b(this.cIQ, childAt);
                                        setPressed(true);
                                        if (this.AG != null && (current = this.AG.getCurrent()) != null && (current instanceof TransitionDrawable)) {
                                            ((TransitionDrawable) current).resetTransition();
                                        }
                                        if (this.cJm != null) {
                                            removeCallbacks(this.cJm);
                                        }
                                        this.cJm = new com.baidu.tieba.horizonalList.widget.a(this, childAt, iVar);
                                        postDelayed(this.cJm, ViewConfiguration.getPressedStateDuration());
                                    } else {
                                        this.mTouchMode = -1;
                                        anp();
                                    }
                                    return true;
                                } else if (!this.aeA && this.mAdapter.isEnabled(i3)) {
                                    iVar.run();
                                }
                            }
                            this.mTouchMode = -1;
                            anp();
                            break;
                        case 3:
                            int childCount = getChildCount();
                            if (childCount > 0) {
                                int left = getChildAt(0).getLeft();
                                int right = getChildAt(childCount - 1).getRight();
                                int i4 = this.cIK.left;
                                int width = getWidth() - this.cIK.right;
                                if (this.bxA == 0 && left >= i4 && this.bxA + childCount < this.cKL && right <= getWidth() - width) {
                                    this.mTouchMode = -1;
                                    kl(0);
                                    break;
                                } else {
                                    VelocityTracker velocityTracker = this.mVelocityTracker;
                                    velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                                    int xVelocity = (int) (velocityTracker.getXVelocity(this.mActivePointerId) * this.cJt);
                                    if (Math.abs(xVelocity) > this.mMinimumVelocity && ((this.bxA != 0 || left != i4 - this.cJv) && (childCount + this.bxA != this.cKL || right != this.cJv + width))) {
                                        if (this.cIX == null) {
                                            this.cIX = new e();
                                        }
                                        kl(2);
                                        this.cIX.kp(-xVelocity);
                                        break;
                                    } else {
                                        this.mTouchMode = -1;
                                        kl(0);
                                        if (this.cIX != null) {
                                            this.cIX.anD();
                                        }
                                        if (this.cIY != null) {
                                            this.cIY.stop();
                                            break;
                                        }
                                    }
                                }
                            } else {
                                this.mTouchMode = -1;
                                kl(0);
                                break;
                            }
                            break;
                        case 5:
                            if (this.cIX == null) {
                                this.cIX = new e();
                            }
                            VelocityTracker velocityTracker2 = this.mVelocityTracker;
                            velocityTracker2.computeCurrentVelocity(1000, this.mMaximumVelocity);
                            int xVelocity2 = (int) velocityTracker2.getXVelocity(this.mActivePointerId);
                            kl(2);
                            if (Math.abs(xVelocity2) > this.mMinimumVelocity) {
                                this.cIX.kq(-xVelocity2);
                                break;
                            } else {
                                this.cIX.anC();
                                break;
                            }
                    }
                    setPressed(false);
                    if (this.cJx != null) {
                        this.cJx.onRelease();
                        this.cJy.onRelease();
                    }
                    invalidate();
                    Handler handler2 = getHandler();
                    if (handler2 != null) {
                        handler2.removeCallbacks(this.cJi);
                    }
                    ant();
                    this.mActivePointerId = -1;
                    break;
                case 2:
                    int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                    if (findPointerIndex == -1) {
                        this.mActivePointerId = motionEvent.getPointerId(0);
                        findPointerIndex = 0;
                    }
                    int x4 = (int) motionEvent.getX(findPointerIndex);
                    if (this.aeA) {
                        layoutChildren();
                    }
                    switch (this.mTouchMode) {
                        case 0:
                        case 1:
                        case 2:
                            kj(x4);
                            break;
                        case 3:
                        case 5:
                            kk(x4);
                            break;
                    }
                case 3:
                    switch (this.mTouchMode) {
                        case 5:
                            if (this.cIX == null) {
                                this.cIX = new e();
                            }
                            this.cIX.anC();
                            break;
                        case 6:
                            break;
                        default:
                            this.mTouchMode = -1;
                            setPressed(false);
                            View childAt2 = getChildAt(this.cIQ - this.bxA);
                            if (childAt2 != null) {
                                childAt2.setPressed(false);
                            }
                            anv();
                            Handler handler3 = getHandler();
                            if (handler3 != null) {
                                handler3.removeCallbacks(this.cJi);
                            }
                            ant();
                            break;
                    }
                    if (this.cJx != null) {
                        this.cJx.onRelease();
                        this.cJy.onRelease();
                    }
                    this.mActivePointerId = -1;
                    break;
                case 5:
                    int actionIndex = motionEvent.getActionIndex();
                    int pointerId = motionEvent.getPointerId(actionIndex);
                    int x5 = (int) motionEvent.getX(actionIndex);
                    int y2 = (int) motionEvent.getY(actionIndex);
                    this.cIW = 0;
                    this.mActivePointerId = pointerId;
                    this.cIT = x5;
                    this.cIU = y2;
                    int pointToPosition2 = pointToPosition(x5, y2);
                    if (pointToPosition2 >= 0) {
                        this.cIR = getChildAt(pointToPosition2 - this.bxA).getLeft();
                        this.cIQ = pointToPosition2;
                    }
                    this.cIV = x5;
                    break;
                case 6:
                    onSecondaryPointerUp(motionEvent);
                    int i5 = this.cIT;
                    int pointToPosition3 = pointToPosition(i5, this.cIU);
                    if (pointToPosition3 >= 0) {
                        this.cIR = getChildAt(pointToPosition3 - this.bxA).getLeft();
                        this.cIQ = pointToPosition3;
                    }
                    this.cIV = i5;
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
            this.cIs.setScrollX(i2);
            anq();
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
        if (this.cJM == 0.0f) {
            TypedValue typedValue = new TypedValue();
            if (getContext().getTheme().resolveAttribute(t.c.hlv_listPreferredItemWidth, typedValue, true)) {
                this.cJM = typedValue.getDimension(getContext().getResources().getDisplayMetrics());
            } else {
                throw new IllegalStateException("Expected theme to define hlv_listPreferredItemWidth.");
            }
        }
        return this.cJM;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.cJx != null) {
            int scrollX = getScrollX();
            if (!this.cJx.isFinished()) {
                int save = canvas.save();
                int i2 = this.cIK.top + this.cJC;
                int height = (getHeight() - i2) - (this.cIK.bottom + this.cJD);
                int min = Math.min(0, this.cJz + scrollX);
                canvas.rotate(-90.0f);
                canvas.translate(i2 + (-getHeight()), min);
                this.cJx.setSize(height, height);
                if (this.cJx.draw(canvas)) {
                    invalidate();
                }
                canvas.restoreToCount(save);
            }
            if (!this.cJy.isFinished()) {
                int save2 = canvas.save();
                int i3 = this.cIK.left + this.cJC;
                int height2 = (getHeight() - i3) - (this.cIK.right + this.cJD);
                int max = Math.max(getWidth(), scrollX + this.cJA);
                canvas.rotate(90.0f);
                canvas.translate(-i3, -max);
                this.cJy.setSize(height2, height2);
                if (this.cJy.draw(canvas)) {
                    invalidate();
                }
                canvas.restoreToCount(save2);
            }
        }
    }

    private void anr() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        } else {
            this.mVelocityTracker.clear();
        }
    }

    private void ans() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
    }

    private void ant() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            ant();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.cIY != null) {
            this.cIY.stop();
        }
        if (this.cJH) {
            switch (action & MotionEventCompat.ACTION_MASK) {
                case 0:
                    int i2 = this.mTouchMode;
                    if (i2 == 6 || i2 == 5) {
                        this.cIW = 0;
                        return true;
                    }
                    int x = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();
                    this.mActivePointerId = motionEvent.getPointerId(0);
                    int kn = kn(x);
                    if (i2 != 4 && kn >= 0) {
                        this.cIR = getChildAt(kn - this.bxA).getLeft();
                        this.cIT = x;
                        this.cIU = y;
                        this.cIQ = kn;
                        this.mTouchMode = 0;
                        anv();
                    }
                    this.cIV = ExploreByTouchHelper.INVALID_ID;
                    anr();
                    this.mVelocityTracker.addMovement(motionEvent);
                    return i2 == 4;
                case 1:
                case 3:
                    this.mTouchMode = -1;
                    this.mActivePointerId = -1;
                    ant();
                    kl(0);
                    return false;
                case 2:
                    switch (this.mTouchMode) {
                        case 0:
                            int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                            if (findPointerIndex == -1) {
                                this.mActivePointerId = motionEvent.getPointerId(0);
                                findPointerIndex = 0;
                            }
                            ans();
                            this.mVelocityTracker.addMovement(motionEvent);
                            return kj((int) motionEvent.getX(findPointerIndex));
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
            this.cIT = (int) motionEvent.getX(i2);
            this.cIU = (int) motionEvent.getY(i2);
            this.cIW = 0;
            this.mActivePointerId = motionEvent.getPointerId(i2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        int childCount = getChildCount();
        int i2 = this.bxA;
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
    public void kl(int i2) {
        if (i2 != this.cJq && this.cJb != null) {
            this.cJq = i2;
            this.cJb.a(this, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e implements Runnable {
        private final o cJQ;
        private int cJR;
        private final Runnable cJS = new com.baidu.tieba.horizonalList.widget.c(this);

        e() {
            this.cJQ = new o(AbsHListView.this.getContext());
        }

        void kp(int i) {
            int i2 = i < 0 ? Integer.MAX_VALUE : 0;
            this.cJR = i2;
            this.cJQ.setInterpolator(null);
            this.cJQ.fling(i2, 0, i, 0, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
            AbsHListView.this.mTouchMode = 4;
            AbsHListView.this.cIs.k(this);
        }

        void anC() {
            if (this.cJQ.springBack(AbsHListView.this.getScrollX(), 0, 0, 0, 0, 0)) {
                AbsHListView.this.mTouchMode = 6;
                AbsHListView.this.invalidate();
                AbsHListView.this.cIs.k(this);
                return;
            }
            AbsHListView.this.mTouchMode = -1;
            AbsHListView.this.kl(0);
        }

        void kq(int i) {
            this.cJQ.setInterpolator(null);
            this.cJQ.fling(AbsHListView.this.getScrollX(), 0, i, 0, ExploreByTouchHelper.INVALID_ID, Integer.MAX_VALUE, 0, 0, AbsHListView.this.getWidth(), 0);
            AbsHListView.this.mTouchMode = 6;
            AbsHListView.this.invalidate();
            AbsHListView.this.cIs.k(this);
        }

        void kr(int i) {
            this.cJQ.notifyHorizontalEdgeReached(AbsHListView.this.getScrollX(), 0, AbsHListView.this.cJw);
            int overScrollMode = AbsHListView.this.getOverScrollMode();
            if (overScrollMode == 0 || (overScrollMode == 1 && !AbsHListView.this.ang())) {
                AbsHListView.this.mTouchMode = 6;
                int currVelocity = (int) this.cJQ.getCurrVelocity();
                if (i > 0) {
                    AbsHListView.this.cJx.onAbsorb(currVelocity);
                } else {
                    AbsHListView.this.cJy.onAbsorb(currVelocity);
                }
            } else {
                AbsHListView.this.mTouchMode = -1;
                if (AbsHListView.this.cIY != null) {
                    AbsHListView.this.cIY.stop();
                }
            }
            AbsHListView.this.invalidate();
            AbsHListView.this.cIs.k(this);
        }

        void d(int i, int i2, boolean z) {
            int i3 = i < 0 ? Integer.MAX_VALUE : 0;
            this.cJR = i3;
            this.cJQ.setInterpolator(z ? AbsHListView.cJJ : null);
            this.cJQ.startScroll(i3, 0, i, 0, i2);
            AbsHListView.this.mTouchMode = 4;
            AbsHListView.this.cIs.k(this);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void anD() {
            AbsHListView.this.mTouchMode = -1;
            AbsHListView.this.removeCallbacks(this);
            AbsHListView.this.removeCallbacks(this.cJS);
            AbsHListView.this.kl(0);
            AbsHListView.this.anv();
            this.cJQ.abortAnimation();
            AbsHListView.this.overScrollBy(0, 0, 0, 0, 0, 0, 0, 0, false);
        }

        void anE() {
            AbsHListView.this.postDelayed(this.cJS, 40L);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // java.lang.Runnable
        public void run() {
            int max;
            boolean z = true;
            boolean z2 = false;
            switch (AbsHListView.this.mTouchMode) {
                case 3:
                    if (this.cJQ.isFinished()) {
                        return;
                    }
                    break;
                case 4:
                    break;
                case 5:
                default:
                    anD();
                    return;
                case 6:
                    o oVar = this.cJQ;
                    if (oVar.computeScrollOffset()) {
                        int scrollX = AbsHListView.this.getScrollX();
                        int currX = oVar.getCurrX();
                        if (AbsHListView.this.overScrollBy(currX - scrollX, 0, scrollX, 0, 0, 0, AbsHListView.this.cJw, 0, false)) {
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
                                kp(currVelocity);
                                return;
                            }
                            anC();
                            return;
                        }
                        AbsHListView.this.invalidate();
                        AbsHListView.this.cIs.k(this);
                        return;
                    }
                    anD();
                    return;
            }
            if (AbsHListView.this.aeA) {
                AbsHListView.this.layoutChildren();
            }
            if (AbsHListView.this.cKL == 0 || AbsHListView.this.getChildCount() == 0) {
                anD();
                return;
            }
            o oVar2 = this.cJQ;
            boolean computeScrollOffset = oVar2.computeScrollOffset();
            int currX2 = oVar2.getCurrX();
            int i = this.cJR - currX2;
            if (i > 0) {
                AbsHListView.this.cIQ = AbsHListView.this.bxA;
                AbsHListView.this.cIR = AbsHListView.this.getChildAt(0).getLeft();
                max = Math.min(((AbsHListView.this.getWidth() - AbsHListView.this.getPaddingRight()) - AbsHListView.this.getPaddingLeft()) - 1, i);
            } else {
                int childCount = AbsHListView.this.getChildCount() - 1;
                AbsHListView.this.cIQ = AbsHListView.this.bxA + childCount;
                AbsHListView.this.cIR = AbsHListView.this.getChildAt(childCount).getLeft();
                max = Math.max(-(((AbsHListView.this.getWidth() - AbsHListView.this.getPaddingRight()) - AbsHListView.this.getPaddingLeft()) - 1), i);
            }
            View childAt = AbsHListView.this.getChildAt(AbsHListView.this.cIQ - AbsHListView.this.bxA);
            int left = childAt != null ? childAt.getLeft() : 0;
            boolean aA = AbsHListView.this.aA(max, max);
            if (!aA || max == 0) {
                z = false;
            }
            if (z) {
                if (childAt != null) {
                    AbsHListView.this.overScrollBy(-(max - (childAt.getLeft() - left)), 0, AbsHListView.this.getScrollX(), 0, 0, 0, AbsHListView.this.cJw, 0, false);
                }
                if (computeScrollOffset) {
                    kr(max);
                }
            } else if (computeScrollOffset && !z) {
                if (aA) {
                    AbsHListView.this.invalidate();
                }
                this.cJR = currX2;
                AbsHListView.this.cIs.k(this);
            } else {
                anD();
            }
        }
    }

    /* loaded from: classes.dex */
    public class j implements Runnable {
        private int cKa;
        private int cKb;
        private int cKc;
        private int cKd;
        private final int cKe;
        private int cKf;
        private int mMode;

        j() {
            this.cKe = ViewConfiguration.get(AbsHListView.this.getContext()).getScaledFadingEdgeLength();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void kp(int i) {
            int i2;
            stop();
            if (AbsHListView.this.aeA) {
                AbsHListView.this.cJs = new com.baidu.tieba.horizonalList.widget.d(this, i);
                return;
            }
            int childCount = AbsHListView.this.getChildCount();
            if (childCount != 0) {
                int i3 = AbsHListView.this.bxA;
                int i4 = (childCount + i3) - 1;
                int max = Math.max(0, Math.min(AbsHListView.this.getCount() - 1, i));
                if (max < i3) {
                    i2 = (i3 - max) + 1;
                    this.mMode = 2;
                } else if (max > i4) {
                    i2 = (max - i4) + 1;
                    this.mMode = 1;
                } else {
                    u(max, -1, 200);
                    return;
                }
                if (i2 > 0) {
                    this.cKd = 200 / i2;
                } else {
                    this.cKd = 200;
                }
                this.cKa = max;
                this.cKb = -1;
                this.cKc = -1;
                AbsHListView.this.cIs.k(this);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void aC(int i, int i2) {
            int i3;
            stop();
            if (i2 == -1) {
                kp(i);
            } else if (AbsHListView.this.aeA) {
                AbsHListView.this.cJs = new com.baidu.tieba.horizonalList.widget.e(this, i, i2);
            } else {
                int childCount = AbsHListView.this.getChildCount();
                if (childCount != 0) {
                    int i4 = AbsHListView.this.bxA;
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
                        u(max, i2, 200);
                        return;
                    }
                    if (i3 > 0) {
                        this.cKd = 200 / i3;
                    } else {
                        this.cKd = 200;
                    }
                    this.cKa = max;
                    this.cKb = i2;
                    this.cKc = -1;
                    AbsHListView.this.cIs.k(this);
                }
            }
        }

        void u(int i, int i2, int i3) {
            int i4 = AbsHListView.this.bxA;
            int childCount = (AbsHListView.this.getChildCount() + i4) - 1;
            int i5 = AbsHListView.this.cIK.left;
            int width = AbsHListView.this.getWidth() - AbsHListView.this.cIK.right;
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
            int i2 = AbsHListView.this.bxA;
            switch (this.mMode) {
                case 1:
                    int childCount = AbsHListView.this.getChildCount() - 1;
                    int i3 = i2 + childCount;
                    if (childCount >= 0) {
                        if (i3 == this.cKc) {
                            AbsHListView.this.cIs.k(this);
                            return;
                        }
                        View childAt = AbsHListView.this.getChildAt(childCount);
                        AbsHListView.this.c((i3 < AbsHListView.this.cKL + (-1) ? Math.max(AbsHListView.this.cIK.right, this.cKe) : AbsHListView.this.cIK.right) + (childAt.getWidth() - (width - childAt.getLeft())), this.cKd, true);
                        this.cKc = i3;
                        if (i3 < this.cKa) {
                            AbsHListView.this.cIs.k(this);
                            return;
                        }
                        return;
                    }
                    return;
                case 2:
                    if (i2 == this.cKc) {
                        AbsHListView.this.cIs.k(this);
                        return;
                    }
                    View childAt2 = AbsHListView.this.getChildAt(0);
                    if (childAt2 != null) {
                        AbsHListView.this.c(childAt2.getLeft() - (i2 > 0 ? Math.max(this.cKe, AbsHListView.this.cIK.left) : AbsHListView.this.cIK.left), this.cKd, true);
                        this.cKc = i2;
                        if (i2 > this.cKa) {
                            AbsHListView.this.cIs.k(this);
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    int childCount2 = AbsHListView.this.getChildCount();
                    if (i2 != this.cKb && childCount2 > 1 && childCount2 + i2 < AbsHListView.this.cKL) {
                        int i4 = i2 + 1;
                        if (i4 == this.cKc) {
                            AbsHListView.this.cIs.k(this);
                            return;
                        }
                        View childAt3 = AbsHListView.this.getChildAt(1);
                        int width2 = childAt3.getWidth();
                        int left2 = childAt3.getLeft();
                        int max = Math.max(AbsHListView.this.cIK.right, this.cKe);
                        if (i4 < this.cKb) {
                            AbsHListView.this.c(Math.max(0, (left2 + width2) - max), this.cKd, true);
                            this.cKc = i4;
                            AbsHListView.this.cIs.k(this);
                            return;
                        } else if (left2 > max) {
                            AbsHListView.this.c(left2 - max, this.cKd, true);
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
                        if (i5 == this.cKc) {
                            AbsHListView.this.cIs.k(this);
                            return;
                        }
                        View childAt4 = AbsHListView.this.getChildAt(childCount3);
                        int width3 = childAt4.getWidth();
                        int left3 = childAt4.getLeft();
                        int i6 = width - left3;
                        int max2 = Math.max(AbsHListView.this.cIK.left, this.cKe);
                        this.cKc = i5;
                        if (i5 > this.cKb) {
                            AbsHListView.this.c(-(i6 - max2), this.cKd, true);
                            AbsHListView.this.cIs.k(this);
                            return;
                        }
                        int i7 = width - max2;
                        int i8 = left3 + width3;
                        if (i7 > i8) {
                            AbsHListView.this.c(-(i7 - i8), this.cKd, true);
                            return;
                        }
                        return;
                    }
                    return;
                case 5:
                    if (this.cKc == i2) {
                        AbsHListView.this.cIs.k(this);
                        return;
                    }
                    this.cKc = i2;
                    int childCount4 = AbsHListView.this.getChildCount();
                    int i9 = this.cKa;
                    int i10 = (i2 + childCount4) - 1;
                    if (i9 < i2) {
                        i = (i2 - i9) + 1;
                    } else if (i9 > i10) {
                        i = i9 - i10;
                    }
                    float min = Math.min(Math.abs(i / childCount4), 1.0f);
                    if (i9 < i2) {
                        AbsHListView.this.c((int) ((-AbsHListView.this.getWidth()) * min), (int) (min * this.cKd), true);
                        AbsHListView.this.cIs.k(this);
                        return;
                    } else if (i9 > i10) {
                        AbsHListView.this.c((int) (AbsHListView.this.getWidth() * min), (int) (min * this.cKd), true);
                        AbsHListView.this.cIs.k(this);
                        return;
                    } else {
                        AbsHListView.this.c(AbsHListView.this.getChildAt(i9 - i2).getLeft() - this.cKf, (int) (this.cKd * (Math.abs(left) / AbsHListView.this.getWidth())), true);
                        return;
                    }
                default:
                    return;
            }
        }
    }

    public void setFriction(float f2) {
        if (this.cIX == null) {
            this.cIX = new e();
        }
        this.cIX.cJQ.setFriction(f2);
    }

    public void setVelocityScale(float f2) {
        this.cJt = f2;
    }

    public void smoothScrollToPosition(int i2, int i3) {
        if (this.cIY == null) {
            this.cIY = new j();
        }
        this.cIY.aC(i2, i3);
    }

    public void smoothScrollBy(int i2, int i3) {
        c(i2, i3, false);
    }

    public void c(int i2, int i3, boolean z) {
        if (this.cIX == null) {
            this.cIX = new e();
        }
        int i4 = this.bxA;
        int childCount = getChildCount();
        int i5 = i4 + childCount;
        int paddingLeft = getPaddingLeft();
        int width = getWidth() - getPaddingRight();
        if (i2 == 0 || this.cKL == 0 || childCount == 0 || ((i4 == 0 && getChildAt(0).getLeft() == paddingLeft && i2 < 0) || (i5 == this.cKL && getChildAt(childCount - 1).getRight() == width && i2 > 0))) {
            this.cIX.anD();
            if (this.cIY != null) {
                this.cIY.stop();
                return;
            }
            return;
        }
        kl(2);
        this.cIX.d(i2, i3, z);
    }

    private void anu() {
        if (this.mScrollingCacheEnabled && !this.cIO && !this.cIs.isHardwareAccelerated()) {
            setChildrenDrawnWithCacheEnabled(true);
            setChildrenDrawingCacheEnabled(true);
            this.cIP = true;
            this.cIO = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anv() {
        if (!this.cIs.isHardwareAccelerated()) {
            if (this.cJr == null) {
                this.cJr = new com.baidu.tieba.horizonalList.widget.b(this);
            }
            post(this.cJr);
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
        Rect rect = this.cIK;
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
        int i6 = this.bxA;
        if (i6 == 0) {
            this.cJz = left - rect.left;
        } else {
            this.cJz += min2;
        }
        if (i6 + childCount == this.cKL) {
            this.cJA = rect.right + right;
        } else {
            this.cJA += min2;
        }
        boolean z = i6 == 0 && left >= rect.left && min2 >= 0;
        boolean z2 = i6 + childCount == this.cKL && right <= getWidth() - rect.right && min2 <= 0;
        if (z || z2) {
            return min2 != 0;
        }
        boolean z3 = min2 < 0;
        boolean isInTouchMode = isInTouchMode();
        if (isInTouchMode) {
            anw();
        }
        int headerViewsCount = getHeaderViewsCount();
        int footerViewsCount = this.cKL - getFooterViewsCount();
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
                    this.cIF.s(childAt, i11);
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
                    this.cIF.s(childAt2, i14);
                }
                i4 = i13;
                i7 = i12;
            }
        }
        this.cIS = this.cIR + min;
        this.cKT = true;
        if (i4 > 0) {
            detachViewsFromParent(i7, i4);
            this.cIF.anH();
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        km(min2);
        if (z3) {
            this.bxA = i4 + this.bxA;
        }
        int abs = Math.abs(min2);
        if (i5 < abs || width < abs) {
            ff(z3);
        }
        if (!isInTouchMode && this.csf != -1) {
            int i15 = this.csf - this.bxA;
            if (i15 >= 0 && i15 < getChildCount()) {
                b(this.csf, getChildAt(i15));
            }
        } else if (this.cID != -1) {
            int i16 = this.cID - this.bxA;
            if (i16 >= 0 && i16 < getChildCount()) {
                b(-1, getChildAt(i16));
            }
        } else {
            this.cIE.setEmpty();
        }
        this.cKT = false;
        anh();
        return false;
    }

    public void km(int i2) {
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
    public void anw() {
        if (this.csf != -1) {
            if (this.cIz != 4) {
                this.cJe = this.csf;
            }
            if (this.cKI >= 0 && this.cKI != this.csf) {
                this.cJe = this.cKI;
            }
            setSelectedPositionInt(-1);
            setNextSelectedPositionInt(-1);
            this.cIZ = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int anx() {
        int i2 = this.csf;
        if (i2 < 0) {
            i2 = this.cJe;
        }
        return Math.min(Math.max(0, i2), this.cKL - 1);
    }

    protected int ko(int i2) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return -1;
        }
        int kn = kn(i2);
        return kn == -1 ? (this.bxA + childCount) - 1 : kn;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean any() {
        if (this.csf >= 0 || !anz()) {
            return false;
        }
        anp();
        return true;
    }

    boolean anz() {
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
        int i8 = this.cIK.left;
        int right = (getRight() - getLeft()) - this.cIK.right;
        int i9 = this.bxA;
        int i10 = this.cJe;
        if (i10 >= i9 && i10 < i9 + childCount) {
            View childAt = getChildAt(i10 - this.bxA);
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
            int i15 = this.cKL;
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
        this.cJe = -1;
        removeCallbacks(this.cIX);
        if (this.cIY != null) {
            this.cIY.stop();
        }
        this.mTouchMode = -1;
        anv();
        this.cKz = i2;
        int C = C(i3, z);
        if (C < i9 || C > getLastVisiblePosition()) {
            C = -1;
        } else {
            this.cIz = 4;
            anp();
            setSelectionInt(C);
            anh();
        }
        kl(0);
        return C >= 0;
    }

    void anA() {
        int i2;
        boolean z;
        boolean z2;
        this.cIx.clear();
        int i3 = 0;
        boolean z3 = false;
        while (i3 < this.cIy.size()) {
            long keyAt = this.cIy.keyAt(i3);
            int intValue = this.cIy.valueAt(i3).intValue();
            if (keyAt != this.mAdapter.getItemId(intValue)) {
                int max = Math.max(0, intValue - 20);
                int min = Math.min(intValue + 20, this.cKL);
                while (true) {
                    if (max >= min) {
                        z2 = false;
                        break;
                    } else if (keyAt != this.mAdapter.getItemId(max)) {
                        max++;
                    } else {
                        this.cIx.put(max, true);
                        this.cIy.setValueAt(i3, Integer.valueOf(max));
                        z2 = true;
                        break;
                    }
                }
                if (!z2) {
                    this.cIy.delete(keyAt);
                    int i4 = i3 - 1;
                    this.cIw--;
                    if (Build.VERSION.SDK_INT <= 11 || this.cIu == null || this.cIv == null) {
                        i2 = i4;
                        z = true;
                    } else {
                        ((com.baidu.tieba.horizonalList.a.a.b) this.cIv).onItemCheckedStateChanged((ActionMode) this.cIu, intValue, keyAt, false);
                        i2 = i4;
                        z = true;
                    }
                    z3 = z;
                    i3 = i2 + 1;
                }
            } else {
                this.cIx.put(intValue, true);
            }
            i2 = i3;
            z = z3;
            z3 = z;
            i3 = i2 + 1;
        }
        if (z3 && this.cIu != null && Build.VERSION.SDK_INT > 11) {
            ((ActionMode) this.cIu).invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.g
    public void handleDataChanged() {
        int i2 = this.cKL;
        int i3 = this.cJI;
        this.cJI = this.cKL;
        if (this.cIt != 0 && this.mAdapter != null && this.mAdapter.hasStableIds()) {
            anA();
        }
        this.cIF.anG();
        if (i2 > 0) {
            if (this.cKD) {
                this.cKD = false;
                this.cJK = null;
                if (this.cJn == 2) {
                    this.cIz = 3;
                    return;
                }
                if (this.cJn == 1) {
                    if (this.cJB) {
                        this.cJB = false;
                        this.cIz = 3;
                        return;
                    }
                    int childCount = getChildCount();
                    int width = getWidth() - getPaddingRight();
                    View childAt = getChildAt(childCount - 1);
                    int bottom = childAt != null ? childAt.getBottom() : width;
                    if (childCount + this.bxA >= i3 && bottom <= width) {
                        this.cIz = 3;
                        return;
                    }
                    awakenScrollBars();
                }
                switch (this.cKE) {
                    case 1:
                        this.cIz = 5;
                        this.cKA = Math.min(Math.max(0, this.cKA), i2 - 1);
                        return;
                    case 0:
                        if (isInTouchMode()) {
                            this.cIz = 5;
                            this.cKA = Math.min(Math.max(0, this.cKA), i2 - 1);
                            return;
                        }
                        int anS = anS();
                        if (anS >= 0 && C(anS, true) == anS) {
                            this.cKA = anS;
                            if (this.cKC == getWidth()) {
                                this.cIz = 5;
                            } else {
                                this.cIz = 2;
                            }
                            setNextSelectedPositionInt(anS);
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
            } else if (this.cJe >= 0) {
                return;
            }
        }
        this.cIz = this.cJa ? 3 : 1;
        this.csf = -1;
        this.cKK = Long.MIN_VALUE;
        this.cKI = -1;
        this.cKJ = Long.MIN_VALUE;
        this.cKD = false;
        this.cJK = null;
        this.cID = -1;
        anR();
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
        this.cJn = i2;
    }

    public int getTranscriptMode() {
        return this.cJn;
    }

    @Override // android.view.View
    public int getSolidColor() {
        return this.cJo;
    }

    public void setCacheColorHint(int i2) {
        if (i2 != this.cJo) {
            this.cJo = i2;
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                getChildAt(i3).setDrawingCacheBackgroundColor(i2);
            }
            this.cIF.setCacheColorHint(i2);
        }
    }

    @ViewDebug.ExportedProperty(category = "drawing")
    public int getCacheColorHint() {
        return this.cJo;
    }

    private void anB() {
        if (this.cJx != null) {
            this.cJx.finish();
            this.cJy.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aB(int i2, int i3) {
    }

    public void setRecyclerListener(l lVar) {
        this.cIF.cKi = lVar;
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
        public int cJU;
        public boolean cJV;
        public boolean cJW;
        public int cJX;
        public long cJY;

        public f(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.cJY = -1L;
        }

        public f(int i, int i2, int i3) {
            super(i, i2);
            this.cJY = -1L;
            this.cJU = i3;
        }

        public f(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.cJY = -1L;
        }
    }

    /* loaded from: classes.dex */
    public class k {
        private l cKi;
        private int cKj;
        private View[] cKk = new View[0];
        private ArrayList<View>[] cKl;
        private int cKm;
        private ArrayList<View> cKn;
        private ArrayList<View> cKo;
        private SparseArrayCompat<View> cKp;

        public k() {
        }

        public void ks(int i) {
            if (i < 1) {
                throw new IllegalArgumentException("Can't have a viewTypeCount < 1");
            }
            ArrayList<View>[] arrayListArr = new ArrayList[i];
            for (int i2 = 0; i2 < i; i2++) {
                arrayListArr[i2] = new ArrayList<>();
            }
            this.cKm = i;
            this.cKn = arrayListArr[0];
            this.cKl = arrayListArr;
        }

        public void anF() {
            if (this.cKm == 1) {
                ArrayList<View> arrayList = this.cKn;
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    arrayList.get(i).forceLayout();
                }
            } else {
                int i2 = this.cKm;
                for (int i3 = 0; i3 < i2; i3++) {
                    ArrayList<View> arrayList2 = this.cKl[i3];
                    int size2 = arrayList2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        arrayList2.get(i4).forceLayout();
                    }
                }
            }
            if (this.cKp != null) {
                int size3 = this.cKp.size();
                for (int i5 = 0; i5 < size3; i5++) {
                    this.cKp.valueAt(i5).forceLayout();
                }
            }
        }

        public boolean kt(int i) {
            return i >= 0;
        }

        public void clear() {
            if (this.cKm == 1) {
                ArrayList<View> arrayList = this.cKn;
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    AbsHListView.this.removeDetachedView(arrayList.remove((size - 1) - i), false);
                }
            } else {
                int i2 = this.cKm;
                for (int i3 = 0; i3 < i2; i3++) {
                    ArrayList<View> arrayList2 = this.cKl[i3];
                    int size2 = arrayList2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        AbsHListView.this.removeDetachedView(arrayList2.remove((size2 - 1) - i4), false);
                    }
                }
            }
            if (this.cKp != null) {
                this.cKp.clear();
            }
        }

        public void aD(int i, int i2) {
            if (this.cKk.length < i) {
                this.cKk = new View[i];
            }
            this.cKj = i2;
            View[] viewArr = this.cKk;
            for (int i3 = 0; i3 < i; i3++) {
                View childAt = AbsHListView.this.getChildAt(i3);
                f fVar = (f) childAt.getLayoutParams();
                if (fVar != null && fVar.cJU != -2) {
                    viewArr[i3] = childAt;
                }
            }
        }

        public View ku(int i) {
            int i2 = i - this.cKj;
            View[] viewArr = this.cKk;
            if (i2 < 0 || i2 >= viewArr.length) {
                return null;
            }
            View view = viewArr[i2];
            viewArr[i2] = null;
            return view;
        }

        View kv(int i) {
            int indexOfKey;
            if (this.cKp != null && (indexOfKey = this.cKp.indexOfKey(i)) >= 0) {
                View valueAt = this.cKp.valueAt(indexOfKey);
                this.cKp.removeAt(indexOfKey);
                return valueAt;
            }
            return null;
        }

        void anG() {
            if (this.cKp != null) {
                this.cKp.clear();
            }
        }

        View kw(int i) {
            if (this.cKm == 1) {
                return AbsHListView.a(this.cKn, i);
            }
            int itemViewType = AbsHListView.this.mAdapter.getItemViewType(i);
            if (itemViewType >= 0 && itemViewType < this.cKl.length) {
                return AbsHListView.a(this.cKl[itemViewType], i);
            }
            return null;
        }

        public void s(View view, int i) {
            f fVar = (f) view.getLayoutParams();
            if (fVar != null) {
                fVar.cJX = i;
                int i2 = fVar.cJU;
                if (!kt(i2)) {
                    if (i2 != -2) {
                        if (this.cKo == null) {
                            this.cKo = new ArrayList<>();
                        }
                        this.cKo.add(view);
                        return;
                    }
                    return;
                }
                view.onStartTemporaryDetach();
                if (this.cKm == 1) {
                    this.cKn.add(view);
                } else {
                    this.cKl[i2].add(view);
                }
                if (Build.VERSION.SDK_INT >= 14) {
                    view.setAccessibilityDelegate(null);
                }
                if (this.cKi != null) {
                    this.cKi.onMovedToScrapHeap(view);
                }
            }
        }

        public void anH() {
            if (this.cKo != null) {
                int size = this.cKo.size();
                for (int i = 0; i < size; i++) {
                    AbsHListView.this.removeDetachedView(this.cKo.get(i), false);
                }
                this.cKo.clear();
            }
        }

        public void anI() {
            View[] viewArr = this.cKk;
            boolean z = this.cKi != null;
            boolean z2 = this.cKm > 1;
            ArrayList<View> arrayList = this.cKn;
            for (int length = viewArr.length - 1; length >= 0; length--) {
                View view = viewArr[length];
                if (view != null) {
                    f fVar = (f) view.getLayoutParams();
                    int i = fVar.cJU;
                    viewArr[length] = null;
                    if (!kt(i)) {
                        if (i != -2) {
                            AbsHListView.this.removeDetachedView(view, false);
                        }
                    } else {
                        if (z2) {
                            arrayList = this.cKl[i];
                        }
                        view.onStartTemporaryDetach();
                        fVar.cJX = this.cKj + length;
                        arrayList.add(view);
                        if (Build.VERSION.SDK_INT >= 14) {
                            view.setAccessibilityDelegate(null);
                        }
                        if (z) {
                            this.cKi.onMovedToScrapHeap(view);
                        }
                    }
                }
            }
            anJ();
        }

        private void anJ() {
            int length = this.cKk.length;
            int i = this.cKm;
            ArrayList<View>[] arrayListArr = this.cKl;
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
            if (this.cKp != null) {
                for (int i6 = 0; i6 < this.cKp.size(); i6++) {
                    this.cKp.valueAt(i6);
                }
            }
        }

        void setCacheColorHint(int i) {
            View[] viewArr;
            if (this.cKm == 1) {
                ArrayList<View> arrayList = this.cKn;
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    arrayList.get(i2).setDrawingCacheBackgroundColor(i);
                }
            } else {
                int i3 = this.cKm;
                for (int i4 = 0; i4 < i3; i4++) {
                    ArrayList<View> arrayList2 = this.cKl[i4];
                    int size2 = arrayList2.size();
                    for (int i5 = 0; i5 < size2; i5++) {
                        arrayList2.get(i5).setDrawingCacheBackgroundColor(i);
                    }
                }
            }
            for (View view : this.cKk) {
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
                if (((f) view.getLayoutParams()).cJX == i2) {
                    arrayList.remove(i3);
                    return view;
                }
            }
            return arrayList.remove(size - 1);
        }
        return null;
    }
}
