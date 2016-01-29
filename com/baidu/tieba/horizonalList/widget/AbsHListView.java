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
    static final Interpolator bGq = new LinearInterpolator();
    public static final int[] bGs = new int[1];
    Drawable Hs;
    a.AbstractC0062a bEZ;
    int bFA;
    int bFB;
    int bFC;
    int bFD;
    private e bFE;
    protected j bFF;
    protected int bFG;
    protected boolean bFH;
    private h bFI;
    private boolean bFJ;
    private Rect bFK;
    protected int bFL;
    private ContextMenu.ContextMenuInfo bFM;
    protected int bFN;
    private int bFO;
    private c bFP;
    private Runnable bFQ;
    private b bFR;
    private i bFS;
    private Runnable bFT;
    private int bFU;
    private int bFV;
    private boolean bFW;
    private int bFX;
    private Runnable bFY;
    protected Runnable bFZ;
    protected int bFa;
    public Object bFb;
    Object bFc;
    int bFd;
    protected SparseArrayCompat<Boolean> bFe;
    LongSparseArray<Integer> bFf;
    protected int bFg;
    protected a bFh;
    boolean bFi;
    boolean bFj;
    int bFk;
    protected Rect bFl;
    protected final k bFm;
    int bFn;
    int bFo;
    int bFp;
    int bFq;
    protected Rect bFr;
    protected int bFs;
    View bFt;
    View bFu;
    protected boolean bFv;
    protected boolean bFw;
    protected int bFx;
    int bFy;
    int bFz;
    private float bGa;
    protected final boolean[] bGb;
    int bGc;
    int bGd;
    private EdgeEffectCompat bGe;
    private EdgeEffectCompat bGf;
    private int bGg;
    private int bGh;
    private boolean bGi;
    private int bGj;
    private int bGk;
    private g bGl;
    private int bGm;
    private int bGn;
    protected boolean bGo;
    private int bGp;
    private SavedState bGr;
    private float bGt;
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

    protected abstract void db(boolean z);

    protected abstract int hU(int i2);

    public abstract void setSelectionInt(int i2);

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
        this.bFa = 0;
        this.bFg = 0;
        this.bFj = false;
        this.bFk = -1;
        this.bFl = new Rect();
        this.bFm = new k();
        this.bFn = 0;
        this.bFo = 0;
        this.bFp = 0;
        this.bFq = 0;
        this.bFr = new Rect();
        this.bFs = 0;
        this.mTouchMode = -1;
        this.bFG = 0;
        this.bFJ = true;
        this.bFL = -1;
        this.bFM = null;
        this.bFO = -1;
        this.bFX = 0;
        this.bGa = 1.0f;
        this.bGb = new boolean[1];
        this.mActivePointerId = -1;
        this.mDirection = 0;
        Wl();
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
        this.bFj = z3;
        setStackFromRight(z2);
        setScrollingCacheEnabled(z);
        setTranscriptMode(i3);
        setCacheColorHint(i4);
        setSmoothScrollbarEnabled(z4);
        setChoiceMode(i5);
    }

    private void Wl() {
        setClickable(true);
        setFocusableInTouchMode(true);
        setWillNotDraw(false);
        setAlwaysDrawnWithCacheEnabled(false);
        setScrollingCacheEnabled(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.bGc = viewConfiguration.getScaledOverscrollDistance();
        this.bGd = viewConfiguration.getScaledOverflingDistance();
        this.bEZ = com.baidu.tieba.horizonalList.a.a.ab(this);
    }

    @Override // android.view.View
    public void setOverScrollMode(int i2) {
        if (i2 != 2) {
            if (this.bGe == null) {
                Context context = getContext();
                this.bGe = new EdgeEffectCompat(context);
                this.bGf = new EdgeEffectCompat(context);
            }
        } else {
            this.bGe = null;
            this.bGf = null;
        }
        super.setOverScrollMode(i2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.horizonalList.widget.g
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            this.bFi = this.mAdapter.hasStableIds();
            if (this.bFa != 0 && this.bFi && this.bFf == null) {
                this.bFf = new LongSparseArray<>();
            }
        }
        if (this.bFe != null) {
            this.bFe.clear();
        }
        if (this.bFf != null) {
            this.bFf.clear();
        }
    }

    public int getCheckedItemCount() {
        return this.bFd;
    }

    public boolean isItemChecked(int i2) {
        if (this.bFa == 0 || this.bFe == null) {
            return false;
        }
        return this.bFe.get(i2, false).booleanValue();
    }

    public int getCheckedItemPosition() {
        if (this.bFa == 1 && this.bFe != null && this.bFe.size() == 1) {
            return this.bFe.keyAt(0);
        }
        return -1;
    }

    public SparseArrayCompat<Boolean> getCheckedItemPositions() {
        if (this.bFa != 0) {
            return this.bFe;
        }
        return null;
    }

    public long[] getCheckedItemIds() {
        if (this.bFa == 0 || this.bFf == null || this.mAdapter == null) {
            return new long[0];
        }
        LongSparseArray<Integer> longSparseArray = this.bFf;
        int size = longSparseArray.size();
        long[] jArr = new long[size];
        for (int i2 = 0; i2 < size; i2++) {
            jArr[i2] = longSparseArray.keyAt(i2);
        }
        return jArr;
    }

    public void clearChoices() {
        if (this.bFe != null) {
            this.bFe.clear();
        }
        if (this.bFf != null) {
            this.bFf.clear();
        }
        this.bFd = 0;
    }

    public void setItemChecked(int i2, boolean z) {
        if (this.bFa != 0) {
            if (Build.VERSION.SDK_INT >= 11 && z && this.bFa == 3 && this.bFb == null) {
                if (this.bFc == null || !((com.baidu.tieba.horizonalList.a.a.b) this.bFc).Wk()) {
                    throw new IllegalStateException("AbsListView: attempted to start selection mode for CHOICE_MODE_MULTIPLE_MODAL but no choice mode callback was supplied. Call setMultiChoiceModeListener to set a callback.");
                }
                this.bFb = startActionMode((com.baidu.tieba.horizonalList.a.a.b) this.bFc);
            }
            if (this.bFa == 2 || (Build.VERSION.SDK_INT >= 11 && this.bFa == 3)) {
                boolean booleanValue = this.bFe.get(i2, false).booleanValue();
                this.bFe.put(i2, Boolean.valueOf(z));
                if (this.bFf != null && this.mAdapter.hasStableIds()) {
                    if (z) {
                        this.bFf.put(this.mAdapter.getItemId(i2), Integer.valueOf(i2));
                    } else {
                        this.bFf.delete(this.mAdapter.getItemId(i2));
                    }
                }
                if (booleanValue != z) {
                    if (z) {
                        this.bFd++;
                    } else {
                        this.bFd--;
                    }
                }
                if (this.bFb != null) {
                    ((com.baidu.tieba.horizonalList.a.a.b) this.bFc).onItemCheckedStateChanged((ActionMode) this.bFb, i2, this.mAdapter.getItemId(i2), z);
                }
            } else {
                boolean z2 = this.bFf != null && this.mAdapter.hasStableIds();
                if (z || isItemChecked(i2)) {
                    this.bFe.clear();
                    if (z2) {
                        this.bFf.clear();
                    }
                }
                if (z) {
                    this.bFe.put(i2, true);
                    if (z2) {
                        this.bFf.put(this.mAdapter.getItemId(i2), Integer.valueOf(i2));
                    }
                    this.bFd = 1;
                } else if (this.bFe.size() == 0 || !this.bFe.valueAt(0).booleanValue()) {
                    this.bFd = 0;
                }
            }
            if (!this.mInLayout && !this.bHB) {
                this.afI = true;
                Xa();
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
        if (this.bFa != 0) {
            if (this.bFa == 2 || (Build.VERSION.SDK_INT >= 11 && this.bFa == 3 && this.bFb != null)) {
                boolean z5 = !this.bFe.get(i2, false).booleanValue();
                this.bFe.put(i2, Boolean.valueOf(z5));
                if (this.bFf != null && this.mAdapter.hasStableIds()) {
                    if (z5) {
                        this.bFf.put(this.mAdapter.getItemId(i2), Integer.valueOf(i2));
                    } else {
                        this.bFf.delete(this.mAdapter.getItemId(i2));
                    }
                }
                if (z5) {
                    this.bFd++;
                } else {
                    this.bFd--;
                }
                if (this.bFb != null) {
                    ((com.baidu.tieba.horizonalList.a.a.b) this.bFc).onItemCheckedStateChanged((ActionMode) this.bFb, i2, j2, z5);
                } else {
                    z4 = true;
                }
                z2 = z4;
                z4 = true;
            } else if (this.bFa == 1) {
                if (!this.bFe.get(i2, false).booleanValue()) {
                    this.bFe.clear();
                    this.bFe.put(i2, true);
                    if (this.bFf != null && this.mAdapter.hasStableIds()) {
                        this.bFf.clear();
                        this.bFf.put(this.mAdapter.getItemId(i2), Integer.valueOf(i2));
                    }
                    this.bFd = 1;
                } else if (this.bFe.size() == 0 || !this.bFe.valueAt(0).booleanValue()) {
                    this.bFd = 0;
                }
                z4 = true;
                z2 = true;
            } else {
                z2 = true;
            }
            if (z4) {
                Wm();
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

    private void Wm() {
        int i2 = this.bHg;
        int childCount = getChildCount();
        boolean z = Build.VERSION.SDK_INT >= 11;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            int i4 = i2 + i3;
            if (childAt instanceof Checkable) {
                ((Checkable) childAt).setChecked(this.bFe.get(i4, false).booleanValue());
            } else if (z) {
                childAt.setActivated(this.bFe.get(i4, false).booleanValue());
            }
        }
    }

    public int getChoiceMode() {
        return this.bFa;
    }

    public void setChoiceMode(int i2) {
        this.bFa = i2;
        if (Build.VERSION.SDK_INT >= 11 && this.bFb != null) {
            if (Build.VERSION.SDK_INT >= 11) {
                ((ActionMode) this.bFb).finish();
            }
            this.bFb = null;
        }
        if (this.bFa != 0) {
            if (this.bFe == null) {
                this.bFe = new SparseArrayCompat<>();
            }
            if (this.bFf == null && this.mAdapter != null && this.mAdapter.hasStableIds()) {
                this.bFf = new LongSparseArray<>();
            }
            if (Build.VERSION.SDK_INT >= 11 && this.bFa == 3) {
                clearChoices();
                setLongClickable(true);
            }
        }
    }

    public void setMultiChoiceModeListener(com.baidu.tieba.horizonalList.a.a.a aVar) {
        if (Build.VERSION.SDK_INT >= 11) {
            if (this.bFc == null) {
                this.bFc = new com.baidu.tieba.horizonalList.a.a.b(this);
            }
            ((com.baidu.tieba.horizonalList.a.a.b) this.bFc).a(aVar);
            return;
        }
        Log.e("AbsListView", "setMultiChoiceModeListener not supported for this version of Android");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Wn() {
        int childCount = getChildCount();
        if (childCount == 0) {
            return true;
        }
        if (childCount != this.bHt) {
            return false;
        }
        return getChildAt(0).getLeft() >= this.bFr.left && getChildAt(childCount + (-1)).getRight() <= getWidth() - this.bFr.right;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public int getHorizontalScrollbarHeight() {
        return super.getHorizontalScrollbarHeight();
    }

    public void setSmoothScrollbarEnabled(boolean z) {
        this.bFJ = z;
    }

    public void setOnScrollListener(h hVar) {
        this.bFI = hVar;
        Wo();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Wo() {
        if (this.bFI != null) {
            this.bFI.a(this, this.bHg, getChildCount(), this.bHt);
        }
        onScrollChanged(0, 0, 0, 0);
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEvent(int i2) {
        if (i2 == 4096) {
            int firstVisiblePosition = getFirstVisiblePosition();
            int lastVisiblePosition = getLastVisiblePosition();
            if (this.bGm != firstVisiblePosition || this.bGn != lastVisiblePosition) {
                this.bGm = firstVisiblePosition;
                this.bGn = lastVisiblePosition;
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
            WC();
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

    private void Wp() {
        setSelector(getResources().getDrawable(17301602));
    }

    public void setStackFromRight(boolean z) {
        if (this.bFH != z) {
            this.bFH = z;
            Wq();
        }
    }

    void Wq() {
        if (getChildCount() > 0) {
            Wr();
            requestLayout();
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new com.baidu.tieba.horizonalList.widget.f();
        long bGX;
        long bGY;
        int bGZ;
        String bHa;
        boolean bHb;
        int bHc;
        SparseArrayCompat<Boolean> bHd;
        LongSparseArray<Integer> bHe;
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
            this.bGX = parcel.readLong();
            this.bGY = parcel.readLong();
            this.bGZ = parcel.readInt();
            this.position = parcel.readInt();
            this.width = parcel.readInt();
            this.bHa = parcel.readString();
            this.bHb = parcel.readByte() != 0;
            this.bHc = parcel.readInt();
            this.bHd = f(parcel);
            this.bHe = e(parcel);
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
            parcel.writeLong(this.bGX);
            parcel.writeLong(this.bGY);
            parcel.writeInt(this.bGZ);
            parcel.writeInt(this.position);
            parcel.writeInt(this.width);
            parcel.writeString(this.bHa);
            parcel.writeByte((byte) (this.bHb ? 1 : 0));
            parcel.writeInt(this.bHc);
            a(this.bHd, parcel);
            a(this.bHe, parcel);
        }

        public String toString() {
            return "AbsListView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " selectedId=" + this.bGX + " firstId=" + this.bGY + " viewLeft=" + this.bGZ + " position=" + this.position + " width=" + this.width + " filter=" + this.bHa + " checkState=" + this.bHd + "}";
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        boolean z = true;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.bGr != null) {
            savedState.bGX = this.bGr.bGX;
            savedState.bGY = this.bGr.bGY;
            savedState.bGZ = this.bGr.bGZ;
            savedState.position = this.bGr.position;
            savedState.width = this.bGr.width;
            savedState.bHa = this.bGr.bHa;
            savedState.bHb = this.bGr.bHb;
            savedState.bHc = this.bGr.bHc;
            savedState.bHd = this.bGr.bHd;
            savedState.bHe = this.bGr.bHe;
            return savedState;
        }
        boolean z2 = getChildCount() > 0 && this.bHt > 0;
        long selectedItemId = getSelectedItemId();
        savedState.bGX = selectedItemId;
        savedState.width = getWidth();
        if (selectedItemId >= 0) {
            savedState.bGZ = this.bFG;
            savedState.position = getSelectedItemPosition();
            savedState.bGY = -1L;
        } else if (z2 && this.bHg > 0) {
            savedState.bGZ = getChildAt(0).getLeft();
            int i2 = this.bHg;
            if (i2 >= this.bHt) {
                i2 = this.bHt - 1;
            }
            savedState.position = i2;
            savedState.bGY = this.mAdapter.getItemId(i2);
        } else {
            savedState.bGZ = 0;
            savedState.bGY = -1L;
            savedState.position = 0;
        }
        savedState.bHa = null;
        savedState.bHb = (Build.VERSION.SDK_INT < 11 || this.bFa != 3 || this.bFb == null) ? false : false;
        if (this.bFe != null) {
            try {
                savedState.bHd = this.bFe.m1clone();
            } catch (NoSuchMethodError e2) {
                e2.printStackTrace();
                savedState.bHd = new SparseArrayCompat<>();
            }
        }
        if (this.bFf != null) {
            LongSparseArray<Integer> longSparseArray = new LongSparseArray<>();
            int size = this.bFf.size();
            for (int i3 = 0; i3 < size; i3++) {
                longSparseArray.put(this.bFf.keyAt(i3), this.bFf.valueAt(i3));
            }
            savedState.bHe = longSparseArray;
        }
        savedState.bHc = this.bFd;
        return savedState;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.afI = true;
        this.bHk = savedState.width;
        if (savedState.bGX >= 0) {
            this.bHl = true;
            this.bGr = savedState;
            this.bHj = savedState.bGX;
            this.bHi = savedState.position;
            this.bHh = savedState.bGZ;
            this.bHm = 0;
        } else if (savedState.bGY >= 0) {
            setSelectedPositionInt(-1);
            setNextSelectedPositionInt(-1);
            this.bFk = -1;
            this.bHl = true;
            this.bGr = savedState;
            this.bHj = savedState.bGY;
            this.bHi = savedState.position;
            this.bHh = savedState.bGZ;
            this.bHm = 1;
        }
        if (savedState.bHd != null) {
            this.bFe = savedState.bHd;
        }
        if (savedState.bHe != null) {
            this.bFf = savedState.bHe;
        }
        this.bFd = savedState.bHc;
        if (Build.VERSION.SDK_INT >= 11 && savedState.bHb && this.bFa == 3 && this.bFc != null) {
            this.bFb = startActionMode((com.baidu.tieba.horizonalList.a.a.b) this.bFc);
        }
        requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onFocusChanged(boolean z, int i2, Rect rect) {
        super.onFocusChanged(z, i2, rect);
        if (z && this.bBx < 0 && !isInTouchMode()) {
            if (!this.bGo && this.mAdapter != null) {
                this.afI = true;
                this.bHu = this.bHt;
                this.bHt = this.mAdapter.getCount();
            }
            WG();
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (!this.bHB && !this.mInLayout) {
            super.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Wr() {
        removeAllViewsInLayout();
        this.bHg = 0;
        this.afI = false;
        this.bFZ = null;
        this.bHl = false;
        this.bGr = null;
        this.bHw = -1;
        this.bHx = Long.MIN_VALUE;
        setSelectedPositionInt(-1);
        setNextSelectedPositionInt(-1);
        this.bFG = 0;
        this.bFk = -1;
        this.bFl.setEmpty();
        invalidate();
    }

    @Override // android.view.View
    protected int computeHorizontalScrollExtent() {
        int childCount = getChildCount();
        if (childCount > 0) {
            if (this.bFJ) {
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
        int i3 = this.bHg;
        int childCount = getChildCount();
        if (i3 < 0 || childCount <= 0) {
            return 0;
        }
        if (this.bFJ) {
            View childAt = getChildAt(0);
            int left = childAt.getLeft();
            int width = childAt.getWidth();
            if (width > 0) {
                return Math.max(((i3 * 100) - ((left * 100) / width)) + ((int) ((getScrollX() / getWidth()) * this.bHt * 100.0f)), 0);
            }
            return 0;
        }
        int i4 = this.bHt;
        if (i3 != 0) {
            i2 = i3 + childCount == i4 ? i4 : (childCount / 2) + i3;
        }
        return (int) (((i2 / i4) * childCount) + i3);
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        if (this.bFJ) {
            int max = Math.max(this.bHt * 100, 0);
            if (getScrollX() != 0) {
                return max + Math.abs((int) ((getScrollX() / getWidth()) * this.bHt * 100.0f));
            }
            return max;
        }
        return this.bHt;
    }

    @Override // android.view.View
    protected float getLeftFadingEdgeStrength() {
        int childCount = getChildCount();
        float leftFadingEdgeStrength = super.getLeftFadingEdgeStrength();
        if (childCount != 0) {
            if (this.bHg > 0) {
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
            if ((this.bHg + childCount) - 1 < this.bHt - 1) {
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
        if (this.Hs == null) {
            Wp();
        }
        Rect rect = this.bFr;
        rect.left = this.bFn + getPaddingLeft();
        rect.top = this.bFo + getPaddingTop();
        rect.right = this.bFp + getPaddingRight();
        rect.bottom = this.bFq + getPaddingBottom();
        if (this.bFU == 1) {
            int childCount = getChildCount();
            int width = getWidth() - getPaddingRight();
            View childAt = getChildAt(childCount - 1);
            this.bGi = childCount + this.bHg >= this.bGp && (childAt != null ? childAt.getRight() : width) <= width;
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
            this.bFm.WM();
        }
        layoutChildren();
        this.mInLayout = false;
        this.bFN = (i4 - i2) / 3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void layoutChildren() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ws() {
        boolean z = true;
        if (this.bFt != null) {
            boolean z2 = this.bHg > 0;
            if (!z2 && getChildCount() > 0) {
                z2 = getChildAt(0).getLeft() < this.bFr.left;
            }
            this.bFt.setVisibility(z2 ? 0 : 4);
        }
        if (this.bFu != null) {
            int childCount = getChildCount();
            boolean z3 = this.bHg + childCount < this.bHt;
            if (z3 || childCount <= 0) {
                z = z3;
            } else if (getChildAt(childCount - 1).getRight() <= getRight() - this.bFr.right) {
                z = false;
            }
            this.bFu.setVisibility(z ? 0 : 4);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.g
    @ViewDebug.ExportedProperty
    public View getSelectedView() {
        if (this.bHt <= 0 || this.bBx < 0) {
            return null;
        }
        return getChildAt(this.bBx - this.bHg);
    }

    public int getListPaddingTop() {
        return this.bFr.top;
    }

    public int getListPaddingBottom() {
        return this.bFr.bottom;
    }

    public int getListPaddingLeft() {
        return this.bFr.left;
    }

    public int getListPaddingRight() {
        return this.bFr.right;
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
        View ib = this.bFm.ib(i2);
        if (ib == null) {
            View ic = this.bFm.ic(i2);
            if (ic != null) {
                view = this.mAdapter.getView(i2, ic, this);
                if (view != ic) {
                    this.bFm.q(ic, i2);
                    if (this.bFV != 0) {
                        view.setDrawingCacheBackgroundColor(this.bFV);
                        ib = view;
                    }
                } else {
                    zArr[0] = true;
                    view.onFinishTemporaryDetach();
                    ib = view;
                }
                if (this.bFi) {
                    ViewGroup.LayoutParams layoutParams = ib.getLayoutParams();
                    if (layoutParams == null) {
                        fVar = (f) generateDefaultLayoutParams();
                    } else if (!checkLayoutParams(layoutParams)) {
                        fVar = (f) generateLayoutParams(layoutParams);
                    } else {
                        fVar = (f) layoutParams;
                    }
                    fVar.bGF = this.mAdapter.getItemId(i2);
                    ib.setLayoutParams(fVar);
                }
                if (this.bHv.isEnabled() && this.bGl == null) {
                    this.bGl = new g();
                }
            } else {
                view = this.mAdapter.getView(i2, null, this);
                if (this.bFV != 0) {
                    view.setDrawingCacheBackgroundColor(this.bFV);
                }
            }
            ib = view;
            if (this.bFi) {
            }
            if (this.bHv.isEnabled()) {
                this.bGl = new g();
            }
        }
        return ib;
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
                            return AbsHListView.this.b(view, positionForView, itemIdAtPosition);
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
            this.bFk = i2;
        }
        Rect rect = this.bFl;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        if (view instanceof m) {
            ((m) view).adjustListItemSelectionBounds(rect);
        }
        i(rect.left, rect.top, rect.right, rect.bottom);
        boolean z = this.bFW;
        if (view.isEnabled() != z) {
            this.bFW = !z;
            if (getSelectedItemPosition() != -1) {
                refreshDrawableState();
            }
        }
    }

    private void i(int i2, int i3, int i4, int i5) {
        this.bFl.set(i2 - this.bFn, i3 - this.bFo, this.bFp + i4, this.bFq + i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        boolean z = this.bFj;
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
            this.afI = true;
            Xa();
        }
    }

    boolean Wt() {
        switch (this.mTouchMode) {
            case 1:
            case 2:
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Wu() {
        return (hasFocus() && !isInTouchMode()) || Wt();
    }

    private void h(Canvas canvas) {
        if (!this.bFl.isEmpty()) {
            Drawable drawable = this.Hs;
            drawable.setBounds(this.bFl);
            drawable.draw(canvas);
        }
    }

    public void setDrawSelectorOnTop(boolean z) {
        this.bFj = z;
    }

    public void setSelector(int i2) {
        setSelector(getResources().getDrawable(i2));
    }

    public void setSelector(Drawable drawable) {
        if (this.Hs != null) {
            this.Hs.setCallback(null);
            unscheduleDrawable(this.Hs);
        }
        this.Hs = drawable;
        Rect rect = new Rect();
        drawable.getPadding(rect);
        this.bFn = rect.left;
        this.bFo = rect.top;
        this.bFp = rect.right;
        this.bFq = rect.bottom;
        drawable.setCallback(this);
        Ww();
    }

    public Drawable getSelector() {
        return this.Hs;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Wv() {
        if (isEnabled() && isClickable()) {
            Drawable drawable = this.Hs;
            Rect rect = this.bFl;
            if (drawable != null) {
                if ((isFocused() || Wt()) && !rect.isEmpty()) {
                    View childAt = getChildAt(this.bBx - this.bHg);
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
                    if (isLongClickable && !this.afI) {
                        if (this.bFR == null) {
                            this.bFR = new b(this, null);
                        }
                        this.bFR.WR();
                        postDelayed(this.bFR, ViewConfiguration.getLongPressTimeout());
                    }
                }
            }
        }
    }

    void Ww() {
        if (this.Hs != null) {
            if (Wu()) {
                this.Hs.setState(getDrawableState());
            } else {
                this.Hs.setState(bGs);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Ww();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i2) {
        if (this.bFW) {
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
        return this.Hs == drawable || super.verifyDrawable(drawable);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.Hs != null) {
            this.Hs.jumpToCurrentState();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnTouchModeChangeListener(this);
        if (this.mAdapter != null && this.bFh == null) {
            this.bFh = new a();
            this.mAdapter.registerDataSetObserver(this.bFh);
            this.afI = true;
            this.bHu = this.bHt;
            this.bHt = this.mAdapter.getCount();
        }
        this.bGo = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.g, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.bFm.clear();
        getViewTreeObserver().removeOnTouchModeChangeListener(this);
        if (this.mAdapter != null && this.bFh != null) {
            this.mAdapter.unregisterDataSetObserver(this.bFh);
            this.bFh = null;
        }
        if (this.bFE != null) {
            removeCallbacks(this.bFE);
        }
        if (this.bFF != null) {
            this.bFF.stop();
        }
        if (this.bFY != null) {
            removeCallbacks(this.bFY);
        }
        if (this.bFS != null) {
            removeCallbacks(this.bFS);
        }
        if (this.bFT != null) {
            removeCallbacks(this.bFT);
            this.bFT = null;
        }
        this.bGo = false;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        int i2 = isInTouchMode() ? 0 : 1;
        if (!z) {
            setChildrenDrawingCacheEnabled(false);
            if (this.bFE != null) {
                removeCallbacks(this.bFE);
                this.bFE.WK();
                if (this.bFF != null) {
                    this.bFF.stop();
                }
                if (getScrollX() != 0) {
                    this.bEZ.setScrollX(0);
                    WI();
                    invalidate();
                }
            }
            if (i2 == 1) {
                this.bFL = this.bBx;
            }
        } else if (i2 != this.bFO && this.bFO != -1) {
            if (i2 == 1) {
                WG();
            } else {
                WD();
                this.bFg = 0;
                layoutChildren();
            }
        }
        this.bFO = i2;
    }

    ContextMenu.ContextMenuInfo a(View view, int i2, long j2) {
        return new g.a(view, i2, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class n {
        private int bHf;

        private n() {
        }

        /* synthetic */ n(AbsHListView absHListView, n nVar) {
            this();
        }

        public void WR() {
            this.bHf = AbsHListView.this.getWindowAttachCount();
        }

        public boolean WS() {
            return AbsHListView.this.hasWindowFocus() && AbsHListView.this.getWindowAttachCount() == this.bHf;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class i extends n implements Runnable {
        int bGG;

        private i() {
            super(AbsHListView.this, null);
        }

        /* synthetic */ i(AbsHListView absHListView, i iVar) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            View childAt;
            if (!AbsHListView.this.afI) {
                ListAdapter listAdapter = AbsHListView.this.mAdapter;
                int i = this.bGG;
                if (listAdapter != null && AbsHListView.this.bHt > 0 && i != -1 && i < listAdapter.getCount() && WS() && (childAt = AbsHListView.this.getChildAt(i - AbsHListView.this.bHg)) != null) {
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
            View childAt = AbsHListView.this.getChildAt(AbsHListView.this.bFx - AbsHListView.this.bHg);
            if (childAt != null) {
                if ((!WS() || AbsHListView.this.afI) ? false : AbsHListView.this.b(childAt, AbsHListView.this.bFx, AbsHListView.this.mAdapter.getItemId(AbsHListView.this.bFx))) {
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
            if (AbsHListView.this.isPressed() && AbsHListView.this.bBx >= 0) {
                View childAt = AbsHListView.this.getChildAt(AbsHListView.this.bBx - AbsHListView.this.bHg);
                if (!AbsHListView.this.afI) {
                    if (WS() ? AbsHListView.this.b(childAt, AbsHListView.this.bBx, AbsHListView.this.bHs) : false) {
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

    boolean b(View view, int i2, long j2) {
        if (Build.VERSION.SDK_INT >= 11 && this.bFa == 3) {
            if (this.bFb == null) {
                ActionMode startActionMode = startActionMode((com.baidu.tieba.horizonalList.a.a.b) this.bFc);
                this.bFb = startActionMode;
                if (startActionMode != null) {
                    setItemChecked(i2, true);
                    performHapticFeedback(0);
                }
            }
            return true;
        }
        boolean b2 = this.bHp != null ? this.bHp.b(this, view, i2, j2) : false;
        if (!b2) {
            this.bFM = a(view, i2, j2);
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
        return this.bFM;
    }

    public boolean a(float f2, float f3, int i2) {
        int pointToPosition = pointToPosition((int) f2, (int) f3);
        if (pointToPosition != -1) {
            long itemId = this.mAdapter.getItemId(pointToPosition);
            View childAt = getChildAt(pointToPosition - this.bHg);
            if (childAt != null) {
                this.bFM = a(childAt, pointToPosition, itemId);
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
            boolean b2 = this.bHp != null ? this.bHp.b(this, view, positionForView, itemId) : false;
            if (!b2) {
                this.bFM = a(getChildAt(positionForView - this.bHg), positionForView, itemId);
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
                if (isClickable() && isPressed() && this.bBx >= 0 && this.mAdapter != null && this.bBx < this.mAdapter.getCount()) {
                    View childAt = getChildAt(this.bBx - this.bHg);
                    if (childAt != null) {
                        performItemClick(childAt, this.bBx, this.bHs);
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
        Rect rect = this.bFK;
        if (rect == null) {
            this.bFK = new Rect();
            rect = this.bFK;
        }
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt.getVisibility() == 0) {
                childAt.getHitRect(rect);
                if (rect.contains(i2, i3)) {
                    return this.bHg + childCount;
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
                View childAt = AbsHListView.this.getChildAt(AbsHListView.this.bFx - AbsHListView.this.bHg);
                if (childAt != null && !childAt.hasFocusable()) {
                    AbsHListView.this.bFg = 0;
                    if (!AbsHListView.this.afI) {
                        childAt.setPressed(true);
                        AbsHListView.this.setPressed(true);
                        AbsHListView.this.layoutChildren();
                        AbsHListView.this.c(AbsHListView.this.bFx, childAt);
                        AbsHListView.this.refreshDrawableState();
                        int longPressTimeout = ViewConfiguration.getLongPressTimeout();
                        boolean isLongClickable = AbsHListView.this.isLongClickable();
                        if (AbsHListView.this.Hs != null && (current = AbsHListView.this.Hs.getCurrent()) != null && (current instanceof TransitionDrawable)) {
                            if (isLongClickable) {
                                ((TransitionDrawable) current).startTransition(longPressTimeout);
                            } else {
                                ((TransitionDrawable) current).resetTransition();
                            }
                        }
                        if (isLongClickable) {
                            if (AbsHListView.this.bFP == null) {
                                AbsHListView.this.bFP = new c(AbsHListView.this, null);
                            }
                            AbsHListView.this.bFP.WR();
                            AbsHListView.this.postDelayed(AbsHListView.this.bFP, longPressTimeout);
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

    private boolean hQ(int i2) {
        int i3 = i2 - this.bFA;
        int abs = Math.abs(i3);
        boolean z = getScrollX() != 0;
        if (z || abs > this.mTouchSlop) {
            WB();
            if (z) {
                this.mTouchMode = 5;
                this.bFD = 0;
            } else {
                this.mTouchMode = 3;
                this.bFD = i3 > 0 ? this.mTouchSlop : -this.mTouchSlop;
            }
            Handler handler = getHandler();
            if (handler != null) {
                handler.removeCallbacks(this.bFP);
            }
            setPressed(false);
            View childAt = getChildAt(this.bFx - this.bHg);
            if (childAt != null) {
                childAt.setPressed(false);
            }
            hS(1);
            ViewParent parent = getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            hR(i2);
            return true;
        }
        return false;
    }

    private void hR(int i2) {
        int i3;
        int childCount;
        ViewParent parent;
        int i4 = i2 - this.bFA;
        int i5 = i4 - this.bFD;
        int i6 = this.bFC != Integer.MIN_VALUE ? i2 - this.bFC : i5;
        if (this.mTouchMode == 3) {
            if (i2 != this.bFC) {
                if (Math.abs(i4) > this.mTouchSlop && (parent = getParent()) != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
                if (this.bFx >= 0) {
                    childCount = this.bFx - this.bHg;
                } else {
                    childCount = getChildCount() / 2;
                }
                View childAt = getChildAt(childCount);
                int left = childAt != null ? childAt.getLeft() : 0;
                boolean ah = i6 != 0 ? ah(i5, i6) : false;
                View childAt2 = getChildAt(childCount);
                if (childAt2 != null) {
                    int left2 = childAt2.getLeft();
                    if (ah) {
                        int i7 = (-i6) - (left2 - left);
                        overScrollBy(i7, 0, getScrollX(), 0, 0, 0, this.bGc, 0, true);
                        if (Math.abs(this.bGc) == Math.abs(getScrollX()) && this.mVelocityTracker != null) {
                            this.mVelocityTracker.clear();
                        }
                        int overScrollMode = getOverScrollMode();
                        if (overScrollMode == 0 || (overScrollMode == 1 && !Wn())) {
                            this.mDirection = 0;
                            this.mTouchMode = 5;
                            if (i4 > 0) {
                                this.bGe.onPull(i7 / getWidth());
                                if (!this.bGf.isFinished()) {
                                    this.bGf.onRelease();
                                }
                                invalidate();
                            } else if (i4 < 0) {
                                this.bGf.onPull(i7 / getWidth());
                                if (!this.bGe.isFinished()) {
                                    this.bGe.onRelease();
                                }
                                invalidate();
                            }
                        }
                    }
                    this.bFA = i2;
                }
                this.bFC = i2;
            }
        } else if (this.mTouchMode == 5 && i2 != this.bFC) {
            int scrollX = getScrollX();
            int i8 = scrollX - i6;
            int i9 = i2 > this.bFC ? 1 : -1;
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
                overScrollBy(i10, 0, getScrollX(), 0, 0, 0, this.bGc, 0, true);
                int overScrollMode2 = getOverScrollMode();
                if (overScrollMode2 == 0 || (overScrollMode2 == 1 && !Wn())) {
                    if (i4 > 0) {
                        this.bGe.onPull(i10 / getWidth());
                        if (!this.bGf.isFinished()) {
                            this.bGf.onRelease();
                        }
                        invalidate();
                    } else if (i4 < 0) {
                        this.bGf.onPull(i10 / getWidth());
                        if (!this.bGe.isFinished()) {
                            this.bGe.onRelease();
                        }
                        invalidate();
                    }
                }
            }
            if (i3 != 0) {
                if (getScrollX() != 0) {
                    this.bEZ.setScrollX(0);
                    Wx();
                }
                ah(i3, i3);
                this.mTouchMode = 3;
                int hV = hV(i2);
                this.bFD = 0;
                View childAt3 = getChildAt(hV - this.bHg);
                this.bFy = childAt3 != null ? childAt3.getLeft() : 0;
                this.bFA = i2;
                this.bFx = hV;
            }
            this.bFC = i2;
            this.mDirection = i9;
        }
    }

    protected void Wx() {
        if (this.bEZ.isHardwareAccelerated() && (getParent() instanceof View)) {
            ((View) getParent()).invalidate();
        }
    }

    @Override // android.view.ViewTreeObserver.OnTouchModeChangeListener
    public void onTouchModeChanged(boolean z) {
        if (z) {
            WD();
            if (getWidth() > 0 && getChildCount() > 0) {
                layoutChildren();
            }
            Ww();
            return;
        }
        int i2 = this.mTouchMode;
        if (i2 == 5 || i2 == 6) {
            if (this.bFE != null) {
                this.bFE.WK();
            }
            if (this.bFF != null) {
                this.bFF.stop();
            }
            if (getScrollX() != 0) {
                this.bEZ.setScrollX(0);
                WI();
                invalidate();
            }
        }
    }

    protected boolean f(MotionEvent motionEvent) {
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
        if (this.bFF != null) {
            this.bFF.stop();
        }
        if (this.bGo) {
            int action = motionEvent.getAction();
            Wz();
            this.mVelocityTracker.addMovement(motionEvent);
            switch (action & MotionEventCompat.ACTION_MASK) {
                case 0:
                    switch (this.mTouchMode) {
                        case 6:
                            this.bFE.WK();
                            if (this.bFF != null) {
                                this.bFF.stop();
                            }
                            this.mTouchMode = 5;
                            this.bFB = (int) motionEvent.getY();
                            int x = (int) motionEvent.getX();
                            this.bFC = x;
                            this.bFA = x;
                            this.bFD = 0;
                            this.mActivePointerId = motionEvent.getPointerId(0);
                            this.mDirection = 0;
                            break;
                        default:
                            this.mActivePointerId = motionEvent.getPointerId(0);
                            int x2 = (int) motionEvent.getX();
                            int y = (int) motionEvent.getY();
                            int pointToPosition = pointToPosition(x2, y);
                            if (!this.afI) {
                                if (this.mTouchMode != 4 && pointToPosition >= 0 && getAdapter().isEnabled(pointToPosition)) {
                                    this.mTouchMode = 0;
                                    if (this.bFQ == null) {
                                        this.bFQ = new d();
                                    }
                                    postDelayed(this.bFQ, ViewConfiguration.getTapTimeout());
                                    i2 = pointToPosition;
                                } else if (this.mTouchMode == 4) {
                                    WB();
                                    this.mTouchMode = 3;
                                    this.bFD = 0;
                                    i2 = hU(x2);
                                    this.bFE.WL();
                                }
                                if (i2 >= 0) {
                                    this.bFy = getChildAt(i2 - this.bHg).getLeft();
                                }
                                this.bFA = x2;
                                this.bFB = y;
                                this.bFx = i2;
                                this.bFC = ExploreByTouchHelper.INVALID_ID;
                                break;
                            }
                            i2 = pointToPosition;
                            if (i2 >= 0) {
                            }
                            this.bFA = x2;
                            this.bFB = y;
                            this.bFx = i2;
                            this.bFC = ExploreByTouchHelper.INVALID_ID;
                    }
                    if (f(motionEvent) && this.mTouchMode == 0) {
                        removeCallbacks(this.bFQ);
                        break;
                    }
                    break;
                case 1:
                    switch (this.mTouchMode) {
                        case 0:
                        case 1:
                        case 2:
                            int i3 = this.bFx;
                            View childAt = getChildAt(i3 - this.bHg);
                            float x3 = motionEvent.getX();
                            boolean z = x3 > ((float) this.bFr.left) && x3 < ((float) (getWidth() - this.bFr.right));
                            if (childAt != null && !childAt.hasFocusable() && z) {
                                if (this.mTouchMode != 0) {
                                    childAt.setPressed(false);
                                }
                                if (this.bFS == null) {
                                    this.bFS = new i(this, null);
                                }
                                i iVar = this.bFS;
                                iVar.bGG = i3;
                                iVar.WR();
                                this.bFL = i3;
                                if (this.mTouchMode == 0 || this.mTouchMode == 1) {
                                    Handler handler = getHandler();
                                    if (handler != null) {
                                        handler.removeCallbacks(this.mTouchMode == 0 ? this.bFQ : this.bFP);
                                    }
                                    this.bFg = 0;
                                    if (!this.afI && this.mAdapter.isEnabled(i3)) {
                                        this.mTouchMode = 1;
                                        setSelectedPositionInt(this.bFx);
                                        layoutChildren();
                                        childAt.setPressed(true);
                                        c(this.bFx, childAt);
                                        setPressed(true);
                                        if (this.Hs != null && (current = this.Hs.getCurrent()) != null && (current instanceof TransitionDrawable)) {
                                            ((TransitionDrawable) current).resetTransition();
                                        }
                                        if (this.bFT != null) {
                                            removeCallbacks(this.bFT);
                                        }
                                        this.bFT = new com.baidu.tieba.horizonalList.widget.a(this, childAt, iVar);
                                        postDelayed(this.bFT, ViewConfiguration.getPressedStateDuration());
                                    } else {
                                        this.mTouchMode = -1;
                                        Ww();
                                    }
                                    return true;
                                } else if (!this.afI && this.mAdapter.isEnabled(i3)) {
                                    iVar.run();
                                }
                            }
                            this.mTouchMode = -1;
                            Ww();
                            break;
                        case 3:
                            int childCount = getChildCount();
                            if (childCount > 0) {
                                int left = getChildAt(0).getLeft();
                                int right = getChildAt(childCount - 1).getRight();
                                int i4 = this.bFr.left;
                                int width = getWidth() - this.bFr.right;
                                if (this.bHg == 0 && left >= i4 && this.bHg + childCount < this.bHt && right <= getWidth() - width) {
                                    this.mTouchMode = -1;
                                    hS(0);
                                    break;
                                } else {
                                    VelocityTracker velocityTracker = this.mVelocityTracker;
                                    velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                                    int xVelocity = (int) (velocityTracker.getXVelocity(this.mActivePointerId) * this.bGa);
                                    if (Math.abs(xVelocity) > this.mMinimumVelocity && ((this.bHg != 0 || left != i4 - this.bGc) && (childCount + this.bHg != this.bHt || right != this.bGc + width))) {
                                        if (this.bFE == null) {
                                            this.bFE = new e();
                                        }
                                        hS(2);
                                        this.bFE.start(-xVelocity);
                                        break;
                                    } else {
                                        this.mTouchMode = -1;
                                        hS(0);
                                        if (this.bFE != null) {
                                            this.bFE.WK();
                                        }
                                        if (this.bFF != null) {
                                            this.bFF.stop();
                                            break;
                                        }
                                    }
                                }
                            } else {
                                this.mTouchMode = -1;
                                hS(0);
                                break;
                            }
                            break;
                        case 5:
                            if (this.bFE == null) {
                                this.bFE = new e();
                            }
                            VelocityTracker velocityTracker2 = this.mVelocityTracker;
                            velocityTracker2.computeCurrentVelocity(1000, this.mMaximumVelocity);
                            int xVelocity2 = (int) velocityTracker2.getXVelocity(this.mActivePointerId);
                            hS(2);
                            if (Math.abs(xVelocity2) > this.mMinimumVelocity) {
                                this.bFE.hW(-xVelocity2);
                                break;
                            } else {
                                this.bFE.WJ();
                                break;
                            }
                    }
                    setPressed(false);
                    if (this.bGe != null) {
                        this.bGe.onRelease();
                        this.bGf.onRelease();
                    }
                    invalidate();
                    Handler handler2 = getHandler();
                    if (handler2 != null) {
                        handler2.removeCallbacks(this.bFP);
                    }
                    WA();
                    this.mActivePointerId = -1;
                    break;
                case 2:
                    int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                    if (findPointerIndex == -1) {
                        this.mActivePointerId = motionEvent.getPointerId(0);
                        findPointerIndex = 0;
                    }
                    int x4 = (int) motionEvent.getX(findPointerIndex);
                    if (this.afI) {
                        layoutChildren();
                    }
                    switch (this.mTouchMode) {
                        case 0:
                        case 1:
                        case 2:
                            hQ(x4);
                            break;
                        case 3:
                        case 5:
                            hR(x4);
                            break;
                    }
                case 3:
                    switch (this.mTouchMode) {
                        case 5:
                            if (this.bFE == null) {
                                this.bFE = new e();
                            }
                            this.bFE.WJ();
                            break;
                        case 6:
                            break;
                        default:
                            this.mTouchMode = -1;
                            setPressed(false);
                            View childAt2 = getChildAt(this.bFx - this.bHg);
                            if (childAt2 != null) {
                                childAt2.setPressed(false);
                            }
                            WC();
                            Handler handler3 = getHandler();
                            if (handler3 != null) {
                                handler3.removeCallbacks(this.bFP);
                            }
                            WA();
                            break;
                    }
                    if (this.bGe != null) {
                        this.bGe.onRelease();
                        this.bGf.onRelease();
                    }
                    this.mActivePointerId = -1;
                    break;
                case 5:
                    int actionIndex = motionEvent.getActionIndex();
                    int pointerId = motionEvent.getPointerId(actionIndex);
                    int x5 = (int) motionEvent.getX(actionIndex);
                    int y2 = (int) motionEvent.getY(actionIndex);
                    this.bFD = 0;
                    this.mActivePointerId = pointerId;
                    this.bFA = x5;
                    this.bFB = y2;
                    int pointToPosition2 = pointToPosition(x5, y2);
                    if (pointToPosition2 >= 0) {
                        this.bFy = getChildAt(pointToPosition2 - this.bHg).getLeft();
                        this.bFx = pointToPosition2;
                    }
                    this.bFC = x5;
                    break;
                case 6:
                    onSecondaryPointerUp(motionEvent);
                    int i5 = this.bFA;
                    int pointToPosition3 = pointToPosition(i5, this.bFB);
                    if (pointToPosition3 >= 0) {
                        this.bFy = getChildAt(pointToPosition3 - this.bHg).getLeft();
                        this.bFx = pointToPosition3;
                    }
                    this.bFC = i5;
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
            this.bEZ.setScrollX(i2);
            Wx();
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
                            if (!ah(horizontalScrollFactor, horizontalScrollFactor)) {
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
        if (this.bGt == 0.0f) {
            TypedValue typedValue = new TypedValue();
            if (getContext().getTheme().resolveAttribute(t.c.hlv_listPreferredItemWidth, typedValue, true)) {
                this.bGt = typedValue.getDimension(getContext().getResources().getDisplayMetrics());
            } else {
                throw new IllegalStateException("Expected theme to define hlv_listPreferredItemWidth.");
            }
        }
        return this.bGt;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.bGe != null) {
            int scrollX = getScrollX();
            if (!this.bGe.isFinished()) {
                int save = canvas.save();
                int i2 = this.bFr.top + this.bGj;
                int height = (getHeight() - i2) - (this.bFr.bottom + this.bGk);
                int min = Math.min(0, this.bGg + scrollX);
                canvas.rotate(-90.0f);
                canvas.translate(i2 + (-getHeight()), min);
                this.bGe.setSize(height, height);
                if (this.bGe.draw(canvas)) {
                    invalidate();
                }
                canvas.restoreToCount(save);
            }
            if (!this.bGf.isFinished()) {
                int save2 = canvas.save();
                int i3 = this.bFr.left + this.bGj;
                int height2 = (getHeight() - i3) - (this.bFr.right + this.bGk);
                int max = Math.max(getWidth(), scrollX + this.bGh);
                canvas.rotate(90.0f);
                canvas.translate(-i3, -max);
                this.bGf.setSize(height2, height2);
                if (this.bGf.draw(canvas)) {
                    invalidate();
                }
                canvas.restoreToCount(save2);
            }
        }
    }

    private void Wy() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        } else {
            this.mVelocityTracker.clear();
        }
    }

    private void Wz() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
    }

    private void WA() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            WA();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.bFF != null) {
            this.bFF.stop();
        }
        if (this.bGo) {
            switch (action & MotionEventCompat.ACTION_MASK) {
                case 0:
                    int i2 = this.mTouchMode;
                    if (i2 == 6 || i2 == 5) {
                        this.bFD = 0;
                        return true;
                    }
                    int x = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();
                    this.mActivePointerId = motionEvent.getPointerId(0);
                    int hU = hU(x);
                    if (i2 != 4 && hU >= 0) {
                        this.bFy = getChildAt(hU - this.bHg).getLeft();
                        this.bFA = x;
                        this.bFB = y;
                        this.bFx = hU;
                        this.mTouchMode = 0;
                        WC();
                    }
                    this.bFC = ExploreByTouchHelper.INVALID_ID;
                    Wy();
                    this.mVelocityTracker.addMovement(motionEvent);
                    return i2 == 4;
                case 1:
                case 3:
                    this.mTouchMode = -1;
                    this.mActivePointerId = -1;
                    WA();
                    hS(0);
                    return false;
                case 2:
                    switch (this.mTouchMode) {
                        case 0:
                            int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                            if (findPointerIndex == -1) {
                                this.mActivePointerId = motionEvent.getPointerId(0);
                                findPointerIndex = 0;
                            }
                            Wz();
                            this.mVelocityTracker.addMovement(motionEvent);
                            return hQ((int) motionEvent.getX(findPointerIndex));
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
            this.bFA = (int) motionEvent.getX(i2);
            this.bFB = (int) motionEvent.getY(i2);
            this.bFD = 0;
            this.mActivePointerId = motionEvent.getPointerId(i2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        int childCount = getChildCount();
        int i2 = this.bHg;
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
    public void hS(int i2) {
        if (i2 != this.bFX && this.bFI != null) {
            this.bFX = i2;
            this.bFI.a(this, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e implements Runnable {
        private final p bGx;
        private int bGy;
        private final Runnable bGz = new com.baidu.tieba.horizonalList.widget.c(this);

        e() {
            this.bGx = new p(AbsHListView.this.getContext());
        }

        void start(int i) {
            int i2 = i < 0 ? Integer.MAX_VALUE : 0;
            this.bGy = i2;
            this.bGx.setInterpolator(null);
            this.bGx.fling(i2, 0, i, 0, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
            AbsHListView.this.mTouchMode = 4;
            AbsHListView.this.bEZ.d(this);
        }

        void WJ() {
            if (this.bGx.springBack(AbsHListView.this.getScrollX(), 0, 0, 0, 0, 0)) {
                AbsHListView.this.mTouchMode = 6;
                AbsHListView.this.invalidate();
                AbsHListView.this.bEZ.d(this);
                return;
            }
            AbsHListView.this.mTouchMode = -1;
            AbsHListView.this.hS(0);
        }

        void hW(int i) {
            this.bGx.setInterpolator(null);
            this.bGx.fling(AbsHListView.this.getScrollX(), 0, i, 0, ExploreByTouchHelper.INVALID_ID, Integer.MAX_VALUE, 0, 0, AbsHListView.this.getWidth(), 0);
            AbsHListView.this.mTouchMode = 6;
            AbsHListView.this.invalidate();
            AbsHListView.this.bEZ.d(this);
        }

        void hX(int i) {
            this.bGx.notifyHorizontalEdgeReached(AbsHListView.this.getScrollX(), 0, AbsHListView.this.bGd);
            int overScrollMode = AbsHListView.this.getOverScrollMode();
            if (overScrollMode == 0 || (overScrollMode == 1 && !AbsHListView.this.Wn())) {
                AbsHListView.this.mTouchMode = 6;
                int currVelocity = (int) this.bGx.getCurrVelocity();
                if (i > 0) {
                    AbsHListView.this.bGe.onAbsorb(currVelocity);
                } else {
                    AbsHListView.this.bGf.onAbsorb(currVelocity);
                }
            } else {
                AbsHListView.this.mTouchMode = -1;
                if (AbsHListView.this.bFF != null) {
                    AbsHListView.this.bFF.stop();
                }
            }
            AbsHListView.this.invalidate();
            AbsHListView.this.bEZ.d(this);
        }

        void g(int i, int i2, boolean z) {
            int i3 = i < 0 ? Integer.MAX_VALUE : 0;
            this.bGy = i3;
            this.bGx.setInterpolator(z ? AbsHListView.bGq : null);
            this.bGx.startScroll(i3, 0, i, 0, i2);
            AbsHListView.this.mTouchMode = 4;
            AbsHListView.this.bEZ.d(this);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void WK() {
            AbsHListView.this.mTouchMode = -1;
            AbsHListView.this.removeCallbacks(this);
            AbsHListView.this.removeCallbacks(this.bGz);
            AbsHListView.this.hS(0);
            AbsHListView.this.WC();
            this.bGx.abortAnimation();
            AbsHListView.this.overScrollBy(0, 0, 0, 0, 0, 0, 0, 0, false);
        }

        void WL() {
            AbsHListView.this.postDelayed(this.bGz, 40L);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // java.lang.Runnable
        public void run() {
            int max;
            boolean z = true;
            boolean z2 = false;
            switch (AbsHListView.this.mTouchMode) {
                case 3:
                    if (this.bGx.isFinished()) {
                        return;
                    }
                    break;
                case 4:
                    break;
                case 5:
                default:
                    WK();
                    return;
                case 6:
                    p pVar = this.bGx;
                    if (pVar.computeScrollOffset()) {
                        int scrollX = AbsHListView.this.getScrollX();
                        int currX = pVar.getCurrX();
                        if (AbsHListView.this.overScrollBy(currX - scrollX, 0, scrollX, 0, 0, 0, AbsHListView.this.bGd, 0, false)) {
                            boolean z3 = scrollX <= 0 && currX > 0;
                            if (scrollX >= 0 && currX < 0) {
                                z2 = true;
                            }
                            if (z3 || z2) {
                                int currVelocity = (int) pVar.getCurrVelocity();
                                if (z2) {
                                    currVelocity = -currVelocity;
                                }
                                pVar.abortAnimation();
                                start(currVelocity);
                                return;
                            }
                            WJ();
                            return;
                        }
                        AbsHListView.this.invalidate();
                        AbsHListView.this.bEZ.d(this);
                        return;
                    }
                    WK();
                    return;
            }
            if (AbsHListView.this.afI) {
                AbsHListView.this.layoutChildren();
            }
            if (AbsHListView.this.bHt == 0 || AbsHListView.this.getChildCount() == 0) {
                WK();
                return;
            }
            p pVar2 = this.bGx;
            boolean computeScrollOffset = pVar2.computeScrollOffset();
            int currX2 = pVar2.getCurrX();
            int i = this.bGy - currX2;
            if (i > 0) {
                AbsHListView.this.bFx = AbsHListView.this.bHg;
                AbsHListView.this.bFy = AbsHListView.this.getChildAt(0).getLeft();
                max = Math.min(((AbsHListView.this.getWidth() - AbsHListView.this.getPaddingRight()) - AbsHListView.this.getPaddingLeft()) - 1, i);
            } else {
                int childCount = AbsHListView.this.getChildCount() - 1;
                AbsHListView.this.bFx = AbsHListView.this.bHg + childCount;
                AbsHListView.this.bFy = AbsHListView.this.getChildAt(childCount).getLeft();
                max = Math.max(-(((AbsHListView.this.getWidth() - AbsHListView.this.getPaddingRight()) - AbsHListView.this.getPaddingLeft()) - 1), i);
            }
            View childAt = AbsHListView.this.getChildAt(AbsHListView.this.bFx - AbsHListView.this.bHg);
            int left = childAt != null ? childAt.getLeft() : 0;
            boolean ah = AbsHListView.this.ah(max, max);
            if (!ah || max == 0) {
                z = false;
            }
            if (z) {
                if (childAt != null) {
                    AbsHListView.this.overScrollBy(-(max - (childAt.getLeft() - left)), 0, AbsHListView.this.getScrollX(), 0, 0, 0, AbsHListView.this.bGd, 0, false);
                }
                if (computeScrollOffset) {
                    hX(max);
                }
            } else if (computeScrollOffset && !z) {
                if (ah) {
                    AbsHListView.this.invalidate();
                }
                this.bGy = currX2;
                AbsHListView.this.bEZ.d(this);
            } else {
                WK();
            }
        }
    }

    /* loaded from: classes.dex */
    public class j implements Runnable {
        private int bGH;
        private int bGI;
        private int bGJ;
        private int bGK;
        private final int bGL;
        private int bGM;
        private int mMode;

        j() {
            this.bGL = ViewConfiguration.get(AbsHListView.this.getContext()).getScaledFadingEdgeLength();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void start(int i) {
            int i2;
            stop();
            if (AbsHListView.this.afI) {
                AbsHListView.this.bFZ = new com.baidu.tieba.horizonalList.widget.d(this, i);
                return;
            }
            int childCount = AbsHListView.this.getChildCount();
            if (childCount != 0) {
                int i3 = AbsHListView.this.bHg;
                int i4 = (childCount + i3) - 1;
                int max = Math.max(0, Math.min(AbsHListView.this.getCount() - 1, i));
                if (max < i3) {
                    i2 = (i3 - max) + 1;
                    this.mMode = 2;
                } else if (max > i4) {
                    i2 = (max - i4) + 1;
                    this.mMode = 1;
                } else {
                    r(max, -1, 200);
                    return;
                }
                if (i2 > 0) {
                    this.bGK = 200 / i2;
                } else {
                    this.bGK = 200;
                }
                this.bGH = max;
                this.bGI = -1;
                this.bGJ = -1;
                AbsHListView.this.bEZ.d(this);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void aj(int i, int i2) {
            int i3;
            stop();
            if (i2 == -1) {
                start(i);
            } else if (AbsHListView.this.afI) {
                AbsHListView.this.bFZ = new com.baidu.tieba.horizonalList.widget.e(this, i, i2);
            } else {
                int childCount = AbsHListView.this.getChildCount();
                if (childCount != 0) {
                    int i4 = AbsHListView.this.bHg;
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
                        r(max, i2, 200);
                        return;
                    }
                    if (i3 > 0) {
                        this.bGK = 200 / i3;
                    } else {
                        this.bGK = 200;
                    }
                    this.bGH = max;
                    this.bGI = i2;
                    this.bGJ = -1;
                    AbsHListView.this.bEZ.d(this);
                }
            }
        }

        void r(int i, int i2, int i3) {
            int i4 = AbsHListView.this.bHg;
            int childCount = (AbsHListView.this.getChildCount() + i4) - 1;
            int i5 = AbsHListView.this.bFr.left;
            int width = AbsHListView.this.getWidth() - AbsHListView.this.bFr.right;
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
            int i2 = AbsHListView.this.bHg;
            switch (this.mMode) {
                case 1:
                    int childCount = AbsHListView.this.getChildCount() - 1;
                    int i3 = i2 + childCount;
                    if (childCount >= 0) {
                        if (i3 == this.bGJ) {
                            AbsHListView.this.bEZ.d(this);
                            return;
                        }
                        View childAt = AbsHListView.this.getChildAt(childCount);
                        AbsHListView.this.f((i3 < AbsHListView.this.bHt + (-1) ? Math.max(AbsHListView.this.bFr.right, this.bGL) : AbsHListView.this.bFr.right) + (childAt.getWidth() - (width - childAt.getLeft())), this.bGK, true);
                        this.bGJ = i3;
                        if (i3 < this.bGH) {
                            AbsHListView.this.bEZ.d(this);
                            return;
                        }
                        return;
                    }
                    return;
                case 2:
                    if (i2 == this.bGJ) {
                        AbsHListView.this.bEZ.d(this);
                        return;
                    }
                    View childAt2 = AbsHListView.this.getChildAt(0);
                    if (childAt2 != null) {
                        AbsHListView.this.f(childAt2.getLeft() - (i2 > 0 ? Math.max(this.bGL, AbsHListView.this.bFr.left) : AbsHListView.this.bFr.left), this.bGK, true);
                        this.bGJ = i2;
                        if (i2 > this.bGH) {
                            AbsHListView.this.bEZ.d(this);
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    int childCount2 = AbsHListView.this.getChildCount();
                    if (i2 != this.bGI && childCount2 > 1 && childCount2 + i2 < AbsHListView.this.bHt) {
                        int i4 = i2 + 1;
                        if (i4 == this.bGJ) {
                            AbsHListView.this.bEZ.d(this);
                            return;
                        }
                        View childAt3 = AbsHListView.this.getChildAt(1);
                        int width2 = childAt3.getWidth();
                        int left2 = childAt3.getLeft();
                        int max = Math.max(AbsHListView.this.bFr.right, this.bGL);
                        if (i4 < this.bGI) {
                            AbsHListView.this.f(Math.max(0, (left2 + width2) - max), this.bGK, true);
                            this.bGJ = i4;
                            AbsHListView.this.bEZ.d(this);
                            return;
                        } else if (left2 > max) {
                            AbsHListView.this.f(left2 - max, this.bGK, true);
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
                        if (i5 == this.bGJ) {
                            AbsHListView.this.bEZ.d(this);
                            return;
                        }
                        View childAt4 = AbsHListView.this.getChildAt(childCount3);
                        int width3 = childAt4.getWidth();
                        int left3 = childAt4.getLeft();
                        int i6 = width - left3;
                        int max2 = Math.max(AbsHListView.this.bFr.left, this.bGL);
                        this.bGJ = i5;
                        if (i5 > this.bGI) {
                            AbsHListView.this.f(-(i6 - max2), this.bGK, true);
                            AbsHListView.this.bEZ.d(this);
                            return;
                        }
                        int i7 = width - max2;
                        int i8 = left3 + width3;
                        if (i7 > i8) {
                            AbsHListView.this.f(-(i7 - i8), this.bGK, true);
                            return;
                        }
                        return;
                    }
                    return;
                case 5:
                    if (this.bGJ == i2) {
                        AbsHListView.this.bEZ.d(this);
                        return;
                    }
                    this.bGJ = i2;
                    int childCount4 = AbsHListView.this.getChildCount();
                    int i9 = this.bGH;
                    int i10 = (i2 + childCount4) - 1;
                    if (i9 < i2) {
                        i = (i2 - i9) + 1;
                    } else if (i9 > i10) {
                        i = i9 - i10;
                    }
                    float min = Math.min(Math.abs(i / childCount4), 1.0f);
                    if (i9 < i2) {
                        AbsHListView.this.f((int) ((-AbsHListView.this.getWidth()) * min), (int) (min * this.bGK), true);
                        AbsHListView.this.bEZ.d(this);
                        return;
                    } else if (i9 > i10) {
                        AbsHListView.this.f((int) (AbsHListView.this.getWidth() * min), (int) (min * this.bGK), true);
                        AbsHListView.this.bEZ.d(this);
                        return;
                    } else {
                        AbsHListView.this.f(AbsHListView.this.getChildAt(i9 - i2).getLeft() - this.bGM, (int) (this.bGK * (Math.abs(left) / AbsHListView.this.getWidth())), true);
                        return;
                    }
                default:
                    return;
            }
        }
    }

    public void setFriction(float f2) {
        if (this.bFE == null) {
            this.bFE = new e();
        }
        this.bFE.bGx.setFriction(f2);
    }

    public void setVelocityScale(float f2) {
        this.bGa = f2;
    }

    public void smoothScrollToPosition(int i2, int i3) {
        if (this.bFF == null) {
            this.bFF = new j();
        }
        this.bFF.aj(i2, i3);
    }

    public void smoothScrollBy(int i2, int i3) {
        f(i2, i3, false);
    }

    public void f(int i2, int i3, boolean z) {
        if (this.bFE == null) {
            this.bFE = new e();
        }
        int i4 = this.bHg;
        int childCount = getChildCount();
        int i5 = i4 + childCount;
        int paddingLeft = getPaddingLeft();
        int width = getWidth() - getPaddingRight();
        if (i2 == 0 || this.bHt == 0 || childCount == 0 || ((i4 == 0 && getChildAt(0).getLeft() == paddingLeft && i2 < 0) || (i5 == this.bHt && getChildAt(childCount - 1).getRight() == width && i2 > 0))) {
            this.bFE.WK();
            if (this.bFF != null) {
                this.bFF.stop();
                return;
            }
            return;
        }
        hS(2);
        this.bFE.g(i2, i3, z);
    }

    private void WB() {
        if (this.mScrollingCacheEnabled && !this.bFv && !this.bEZ.isHardwareAccelerated()) {
            setChildrenDrawnWithCacheEnabled(true);
            setChildrenDrawingCacheEnabled(true);
            this.bFw = true;
            this.bFv = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WC() {
        if (!this.bEZ.isHardwareAccelerated()) {
            if (this.bFY == null) {
                this.bFY = new com.baidu.tieba.horizonalList.widget.b(this);
            }
            post(this.bFY);
        }
    }

    boolean ah(int i2, int i3) {
        int min;
        int min2;
        int i4;
        int childCount = getChildCount();
        if (childCount == 0) {
            return true;
        }
        int left = getChildAt(0).getLeft();
        int right = getChildAt(childCount - 1).getRight();
        Rect rect = this.bFr;
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
        int i6 = this.bHg;
        if (i6 == 0) {
            this.bGg = left - rect.left;
        } else {
            this.bGg += min2;
        }
        if (i6 + childCount == this.bHt) {
            this.bGh = rect.right + right;
        } else {
            this.bGh += min2;
        }
        boolean z = i6 == 0 && left >= rect.left && min2 >= 0;
        boolean z2 = i6 + childCount == this.bHt && right <= getWidth() - rect.right && min2 <= 0;
        if (z || z2) {
            return min2 != 0;
        }
        boolean z3 = min2 < 0;
        boolean isInTouchMode = isInTouchMode();
        if (isInTouchMode) {
            WD();
        }
        int headerViewsCount = getHeaderViewsCount();
        int footerViewsCount = this.bHt - getFooterViewsCount();
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
                    this.bFm.q(childAt, i11);
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
                    this.bFm.q(childAt2, i14);
                }
                i4 = i13;
                i7 = i12;
            }
        }
        this.bFz = this.bFy + min;
        this.bHB = true;
        if (i4 > 0) {
            detachViewsFromParent(i7, i4);
            this.bFm.WO();
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        hT(min2);
        if (z3) {
            this.bHg = i4 + this.bHg;
        }
        int abs = Math.abs(min2);
        if (i5 < abs || width < abs) {
            db(z3);
        }
        if (!isInTouchMode && this.bBx != -1) {
            int i15 = this.bBx - this.bHg;
            if (i15 >= 0 && i15 < getChildCount()) {
                c(this.bBx, getChildAt(i15));
            }
        } else if (this.bFk != -1) {
            int i16 = this.bFk - this.bHg;
            if (i16 >= 0 && i16 < getChildCount()) {
                c(-1, getChildAt(i16));
            }
        } else {
            this.bFl.setEmpty();
        }
        this.bHB = false;
        Wo();
        return false;
    }

    public void hT(int i2) {
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
    public void WD() {
        if (this.bBx != -1) {
            if (this.bFg != 4) {
                this.bFL = this.bBx;
            }
            if (this.bHq >= 0 && this.bHq != this.bBx) {
                this.bFL = this.bHq;
            }
            setSelectedPositionInt(-1);
            setNextSelectedPositionInt(-1);
            this.bFG = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int WE() {
        int i2 = this.bBx;
        if (i2 < 0) {
            i2 = this.bFL;
        }
        return Math.min(Math.max(0, i2), this.bHt - 1);
    }

    protected int hV(int i2) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return -1;
        }
        int hU = hU(i2);
        return hU == -1 ? (this.bHg + childCount) - 1 : hU;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean WF() {
        if (this.bBx >= 0 || !WG()) {
            return false;
        }
        Ww();
        return true;
    }

    boolean WG() {
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
        int i8 = this.bFr.left;
        int right = (getRight() - getLeft()) - this.bFr.right;
        int i9 = this.bHg;
        int i10 = this.bFL;
        if (i10 >= i9 && i10 < i9 + childCount) {
            View childAt = getChildAt(i10 - this.bHg);
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
            int i15 = this.bHt;
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
        this.bFL = -1;
        removeCallbacks(this.bFE);
        if (this.bFF != null) {
            this.bFF.stop();
        }
        this.mTouchMode = -1;
        WC();
        this.bHh = i2;
        int k2 = k(i3, z);
        if (k2 < i9 || k2 > getLastVisiblePosition()) {
            k2 = -1;
        } else {
            this.bFg = 4;
            Ww();
            setSelectionInt(k2);
            Wo();
        }
        hS(0);
        return k2 >= 0;
    }

    void WH() {
        int i2;
        boolean z;
        boolean z2;
        this.bFe.clear();
        int i3 = 0;
        boolean z3 = false;
        while (i3 < this.bFf.size()) {
            long keyAt = this.bFf.keyAt(i3);
            int intValue = this.bFf.valueAt(i3).intValue();
            if (keyAt != this.mAdapter.getItemId(intValue)) {
                int max = Math.max(0, intValue - 20);
                int min = Math.min(intValue + 20, this.bHt);
                while (true) {
                    if (max >= min) {
                        z2 = false;
                        break;
                    } else if (keyAt != this.mAdapter.getItemId(max)) {
                        max++;
                    } else {
                        this.bFe.put(max, true);
                        this.bFf.setValueAt(i3, Integer.valueOf(max));
                        z2 = true;
                        break;
                    }
                }
                if (!z2) {
                    this.bFf.delete(keyAt);
                    int i4 = i3 - 1;
                    this.bFd--;
                    if (Build.VERSION.SDK_INT <= 11 || this.bFb == null || this.bFc == null) {
                        i2 = i4;
                        z = true;
                    } else {
                        ((com.baidu.tieba.horizonalList.a.a.b) this.bFc).onItemCheckedStateChanged((ActionMode) this.bFb, intValue, keyAt, false);
                        i2 = i4;
                        z = true;
                    }
                    z3 = z;
                    i3 = i2 + 1;
                }
            } else {
                this.bFe.put(intValue, true);
            }
            i2 = i3;
            z = z3;
            z3 = z;
            i3 = i2 + 1;
        }
        if (z3 && this.bFb != null && Build.VERSION.SDK_INT > 11) {
            ((ActionMode) this.bFb).invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.g
    public void handleDataChanged() {
        int i2 = this.bHt;
        int i3 = this.bGp;
        this.bGp = this.bHt;
        if (this.bFa != 0 && this.mAdapter != null && this.mAdapter.hasStableIds()) {
            WH();
        }
        this.bFm.WN();
        if (i2 > 0) {
            if (this.bHl) {
                this.bHl = false;
                this.bGr = null;
                if (this.bFU == 2) {
                    this.bFg = 3;
                    return;
                }
                if (this.bFU == 1) {
                    if (this.bGi) {
                        this.bGi = false;
                        this.bFg = 3;
                        return;
                    }
                    int childCount = getChildCount();
                    int width = getWidth() - getPaddingRight();
                    View childAt = getChildAt(childCount - 1);
                    int bottom = childAt != null ? childAt.getBottom() : width;
                    if (childCount + this.bHg >= i3 && bottom <= width) {
                        this.bFg = 3;
                        return;
                    }
                    awakenScrollBars();
                }
                switch (this.bHm) {
                    case 1:
                        this.bFg = 5;
                        this.bHi = Math.min(Math.max(0, this.bHi), i2 - 1);
                        return;
                    case 0:
                        if (isInTouchMode()) {
                            this.bFg = 5;
                            this.bHi = Math.min(Math.max(0, this.bHi), i2 - 1);
                            return;
                        }
                        int WZ = WZ();
                        if (WZ >= 0 && k(WZ, true) == WZ) {
                            this.bHi = WZ;
                            if (this.bHk == getWidth()) {
                                this.bFg = 5;
                            } else {
                                this.bFg = 2;
                            }
                            setNextSelectedPositionInt(WZ);
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
                int k2 = k(selectedItemPosition, true);
                if (k2 >= 0) {
                    setNextSelectedPositionInt(k2);
                    return;
                }
                int k3 = k(selectedItemPosition, false);
                if (k3 >= 0) {
                    setNextSelectedPositionInt(k3);
                    return;
                }
            } else if (this.bFL >= 0) {
                return;
            }
        }
        this.bFg = this.bFH ? 3 : 1;
        this.bBx = -1;
        this.bHs = Long.MIN_VALUE;
        this.bHq = -1;
        this.bHr = Long.MIN_VALUE;
        this.bHl = false;
        this.bGr = null;
        this.bFk = -1;
        WY();
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
        this.bFU = i2;
    }

    public int getTranscriptMode() {
        return this.bFU;
    }

    @Override // android.view.View
    public int getSolidColor() {
        return this.bFV;
    }

    public void setCacheColorHint(int i2) {
        if (i2 != this.bFV) {
            this.bFV = i2;
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                getChildAt(i3).setDrawingCacheBackgroundColor(i2);
            }
            this.bFm.setCacheColorHint(i2);
        }
    }

    @ViewDebug.ExportedProperty(category = "drawing")
    public int getCacheColorHint() {
        return this.bFV;
    }

    private void WI() {
        if (this.bGe != null) {
            this.bGe.finish();
            this.bGf.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ai(int i2, int i3) {
    }

    public void setRecyclerListener(l lVar) {
        this.bFm.bGP = lVar;
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
        public int bGB;
        public boolean bGC;
        public boolean bGD;
        public int bGE;
        public long bGF;

        public f(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.bGF = -1L;
        }

        public f(int i, int i2, int i3) {
            super(i, i2);
            this.bGF = -1L;
            this.bGB = i3;
        }

        public f(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.bGF = -1L;
        }
    }

    /* loaded from: classes.dex */
    public class k {
        private l bGP;
        private int bGQ;
        private View[] bGR = new View[0];
        private ArrayList<View>[] bGS;
        private int bGT;
        private ArrayList<View> bGU;
        private ArrayList<View> bGV;
        private SparseArrayCompat<View> bGW;

        public k() {
        }

        public void hY(int i) {
            if (i < 1) {
                throw new IllegalArgumentException("Can't have a viewTypeCount < 1");
            }
            ArrayList<View>[] arrayListArr = new ArrayList[i];
            for (int i2 = 0; i2 < i; i2++) {
                arrayListArr[i2] = new ArrayList<>();
            }
            this.bGT = i;
            this.bGU = arrayListArr[0];
            this.bGS = arrayListArr;
        }

        public void WM() {
            if (this.bGT == 1) {
                ArrayList<View> arrayList = this.bGU;
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    arrayList.get(i).forceLayout();
                }
            } else {
                int i2 = this.bGT;
                for (int i3 = 0; i3 < i2; i3++) {
                    ArrayList<View> arrayList2 = this.bGS[i3];
                    int size2 = arrayList2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        arrayList2.get(i4).forceLayout();
                    }
                }
            }
            if (this.bGW != null) {
                int size3 = this.bGW.size();
                for (int i5 = 0; i5 < size3; i5++) {
                    this.bGW.valueAt(i5).forceLayout();
                }
            }
        }

        public boolean hZ(int i) {
            return i >= 0;
        }

        public void clear() {
            if (this.bGT == 1) {
                ArrayList<View> arrayList = this.bGU;
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    AbsHListView.this.removeDetachedView(arrayList.remove((size - 1) - i), false);
                }
            } else {
                int i2 = this.bGT;
                for (int i3 = 0; i3 < i2; i3++) {
                    ArrayList<View> arrayList2 = this.bGS[i3];
                    int size2 = arrayList2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        AbsHListView.this.removeDetachedView(arrayList2.remove((size2 - 1) - i4), false);
                    }
                }
            }
            if (this.bGW != null) {
                this.bGW.clear();
            }
        }

        public void ak(int i, int i2) {
            if (this.bGR.length < i) {
                this.bGR = new View[i];
            }
            this.bGQ = i2;
            View[] viewArr = this.bGR;
            for (int i3 = 0; i3 < i; i3++) {
                View childAt = AbsHListView.this.getChildAt(i3);
                f fVar = (f) childAt.getLayoutParams();
                if (fVar != null && fVar.bGB != -2) {
                    viewArr[i3] = childAt;
                }
            }
        }

        public View ia(int i) {
            int i2 = i - this.bGQ;
            View[] viewArr = this.bGR;
            if (i2 < 0 || i2 >= viewArr.length) {
                return null;
            }
            View view = viewArr[i2];
            viewArr[i2] = null;
            return view;
        }

        View ib(int i) {
            int indexOfKey;
            if (this.bGW != null && (indexOfKey = this.bGW.indexOfKey(i)) >= 0) {
                View valueAt = this.bGW.valueAt(indexOfKey);
                this.bGW.removeAt(indexOfKey);
                return valueAt;
            }
            return null;
        }

        void WN() {
            if (this.bGW != null) {
                this.bGW.clear();
            }
        }

        View ic(int i) {
            if (this.bGT == 1) {
                return AbsHListView.a(this.bGU, i);
            }
            int itemViewType = AbsHListView.this.mAdapter.getItemViewType(i);
            if (itemViewType >= 0 && itemViewType < this.bGS.length) {
                return AbsHListView.a(this.bGS[itemViewType], i);
            }
            return null;
        }

        public void q(View view, int i) {
            f fVar = (f) view.getLayoutParams();
            if (fVar != null) {
                fVar.bGE = i;
                int i2 = fVar.bGB;
                if (!hZ(i2)) {
                    if (i2 != -2) {
                        if (this.bGV == null) {
                            this.bGV = new ArrayList<>();
                        }
                        this.bGV.add(view);
                        return;
                    }
                    return;
                }
                view.onStartTemporaryDetach();
                if (this.bGT == 1) {
                    this.bGU.add(view);
                } else {
                    this.bGS[i2].add(view);
                }
                if (Build.VERSION.SDK_INT >= 14) {
                    view.setAccessibilityDelegate(null);
                }
                if (this.bGP != null) {
                    this.bGP.onMovedToScrapHeap(view);
                }
            }
        }

        public void WO() {
            if (this.bGV != null) {
                int size = this.bGV.size();
                for (int i = 0; i < size; i++) {
                    AbsHListView.this.removeDetachedView(this.bGV.get(i), false);
                }
                this.bGV.clear();
            }
        }

        public void WP() {
            View[] viewArr = this.bGR;
            boolean z = this.bGP != null;
            boolean z2 = this.bGT > 1;
            ArrayList<View> arrayList = this.bGU;
            for (int length = viewArr.length - 1; length >= 0; length--) {
                View view = viewArr[length];
                if (view != null) {
                    f fVar = (f) view.getLayoutParams();
                    int i = fVar.bGB;
                    viewArr[length] = null;
                    if (!hZ(i)) {
                        if (i != -2) {
                            AbsHListView.this.removeDetachedView(view, false);
                        }
                    } else {
                        if (z2) {
                            arrayList = this.bGS[i];
                        }
                        view.onStartTemporaryDetach();
                        fVar.bGE = this.bGQ + length;
                        arrayList.add(view);
                        if (Build.VERSION.SDK_INT >= 14) {
                            view.setAccessibilityDelegate(null);
                        }
                        if (z) {
                            this.bGP.onMovedToScrapHeap(view);
                        }
                    }
                }
            }
            WQ();
        }

        private void WQ() {
            int length = this.bGR.length;
            int i = this.bGT;
            ArrayList<View>[] arrayListArr = this.bGS;
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
            if (this.bGW != null) {
                for (int i6 = 0; i6 < this.bGW.size(); i6++) {
                    this.bGW.valueAt(i6);
                }
            }
        }

        void setCacheColorHint(int i) {
            View[] viewArr;
            if (this.bGT == 1) {
                ArrayList<View> arrayList = this.bGU;
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    arrayList.get(i2).setDrawingCacheBackgroundColor(i);
                }
            } else {
                int i3 = this.bGT;
                for (int i4 = 0; i4 < i3; i4++) {
                    ArrayList<View> arrayList2 = this.bGS[i4];
                    int size2 = arrayList2.size();
                    for (int i5 = 0; i5 < size2; i5++) {
                        arrayList2.get(i5).setDrawingCacheBackgroundColor(i);
                    }
                }
            }
            for (View view : this.bGR) {
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
                if (((f) view.getLayoutParams()).bGE == i2) {
                    arrayList.remove(i3);
                    return view;
                }
            }
            return arrayList.remove(size - 1);
        }
        return null;
    }
}
