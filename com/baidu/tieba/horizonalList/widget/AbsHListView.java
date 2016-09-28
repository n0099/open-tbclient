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
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class AbsHListView extends com.baidu.tieba.horizonalList.widget.g<ListAdapter> implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnTouchModeChangeListener {
    static final Interpolator cKA = new LinearInterpolator();
    public static final int[] cKC = new int[1];
    Drawable AG;
    int cJA;
    protected Rect cJB;
    protected int cJC;
    View cJD;
    View cJE;
    protected boolean cJF;
    protected boolean cJG;
    protected int cJH;
    int cJI;
    int cJJ;
    int cJK;
    int cJL;
    int cJM;
    int cJN;
    private e cJO;
    protected j cJP;
    protected int cJQ;
    protected boolean cJR;
    private h cJS;
    private boolean cJT;
    private Rect cJU;
    protected int cJV;
    private ContextMenu.ContextMenuInfo cJW;
    protected int cJX;
    private int cJY;
    private c cJZ;
    a.AbstractC0066a cJj;
    protected int cJk;
    public Object cJl;
    Object cJm;
    int cJn;
    protected SparseArrayCompat<Boolean> cJo;
    LongSparseArray<Integer> cJp;
    protected int cJq;
    protected a cJr;
    boolean cJs;
    boolean cJt;
    int cJu;
    protected Rect cJv;
    protected final k cJw;
    int cJx;
    int cJy;
    int cJz;
    private SavedState cKB;
    private float cKD;
    private Runnable cKa;
    private b cKb;
    private i cKc;
    private Runnable cKd;
    private int cKe;
    private int cKf;
    private boolean cKg;
    private int cKh;
    private Runnable cKi;
    protected Runnable cKj;
    private float cKk;
    protected final boolean[] cKl;
    int cKm;
    int cKn;
    private EdgeEffectCompat cKo;
    private EdgeEffectCompat cKp;
    private int cKq;
    private int cKr;
    private boolean cKs;
    private int cKt;
    private int cKu;
    private g cKv;
    private int cKw;
    private int cKx;
    protected boolean cKy;
    private int cKz;
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

    protected abstract void fg(boolean z);

    protected abstract int kt(int i2);

    public abstract void setSelectionInt(int i2);

    public AbsHListView(Context context) {
        super(context);
        this.cJk = 0;
        this.cJq = 0;
        this.cJt = false;
        this.cJu = -1;
        this.cJv = new Rect();
        this.cJw = new k();
        this.cJx = 0;
        this.cJy = 0;
        this.cJz = 0;
        this.cJA = 0;
        this.cJB = new Rect();
        this.cJC = 0;
        this.mTouchMode = -1;
        this.cJQ = 0;
        this.cJT = true;
        this.cJV = -1;
        this.cJW = null;
        this.cJY = -1;
        this.cKh = 0;
        this.cKk = 1.0f;
        this.cKl = new boolean[1];
        this.mActivePointerId = -1;
        this.mDirection = 0;
        ans();
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
        this.cJk = 0;
        this.cJq = 0;
        this.cJt = false;
        this.cJu = -1;
        this.cJv = new Rect();
        this.cJw = new k();
        this.cJx = 0;
        this.cJy = 0;
        this.cJz = 0;
        this.cJA = 0;
        this.cJB = new Rect();
        this.cJC = 0;
        this.mTouchMode = -1;
        this.cJQ = 0;
        this.cJT = true;
        this.cJV = -1;
        this.cJW = null;
        this.cJY = -1;
        this.cKh = 0;
        this.cKk = 1.0f;
        this.cKl = new boolean[1];
        this.mActivePointerId = -1;
        this.mDirection = 0;
        ans();
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
        this.cJt = z3;
        setStackFromRight(z2);
        setScrollingCacheEnabled(z);
        setTranscriptMode(i3);
        setCacheColorHint(i4);
        setSmoothScrollbarEnabled(z4);
        setChoiceMode(i5);
    }

    private void ans() {
        setClickable(true);
        setFocusableInTouchMode(true);
        setWillNotDraw(false);
        setAlwaysDrawnWithCacheEnabled(false);
        setScrollingCacheEnabled(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.cKm = viewConfiguration.getScaledOverscrollDistance();
        this.cKn = viewConfiguration.getScaledOverflingDistance();
        this.cJj = com.baidu.tieba.horizonalList.a.a.au(this);
    }

    @Override // android.view.View
    public void setOverScrollMode(int i2) {
        if (i2 != 2) {
            if (this.cKo == null) {
                Context context = getContext();
                this.cKo = new EdgeEffectCompat(context);
                this.cKp = new EdgeEffectCompat(context);
            }
        } else {
            this.cKo = null;
            this.cKp = null;
        }
        super.setOverScrollMode(i2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.horizonalList.widget.g
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            this.cJs = this.mAdapter.hasStableIds();
            if (this.cJk != 0 && this.cJs && this.cJp == null) {
                this.cJp = new LongSparseArray<>();
            }
        }
        if (this.cJo != null) {
            this.cJo.clear();
        }
        if (this.cJp != null) {
            this.cJp.clear();
        }
    }

    public int getCheckedItemCount() {
        return this.cJn;
    }

    public boolean isItemChecked(int i2) {
        if (this.cJk == 0 || this.cJo == null) {
            return false;
        }
        return this.cJo.get(i2, false).booleanValue();
    }

    public int getCheckedItemPosition() {
        if (this.cJk == 1 && this.cJo != null && this.cJo.size() == 1) {
            return this.cJo.keyAt(0);
        }
        return -1;
    }

    public SparseArrayCompat<Boolean> getCheckedItemPositions() {
        if (this.cJk != 0) {
            return this.cJo;
        }
        return null;
    }

    public long[] getCheckedItemIds() {
        if (this.cJk == 0 || this.cJp == null || this.mAdapter == null) {
            return new long[0];
        }
        LongSparseArray<Integer> longSparseArray = this.cJp;
        int size = longSparseArray.size();
        long[] jArr = new long[size];
        for (int i2 = 0; i2 < size; i2++) {
            jArr[i2] = longSparseArray.keyAt(i2);
        }
        return jArr;
    }

    public void clearChoices() {
        if (this.cJo != null) {
            this.cJo.clear();
        }
        if (this.cJp != null) {
            this.cJp.clear();
        }
        this.cJn = 0;
    }

    public void setItemChecked(int i2, boolean z) {
        if (this.cJk != 0) {
            if (Build.VERSION.SDK_INT >= 11 && z && this.cJk == 3 && this.cJl == null) {
                if (this.cJm == null || !((com.baidu.tieba.horizonalList.a.a.b) this.cJm).anr()) {
                    throw new IllegalStateException("AbsListView: attempted to start selection mode for CHOICE_MODE_MULTIPLE_MODAL but no choice mode callback was supplied. Call setMultiChoiceModeListener to set a callback.");
                }
                this.cJl = startActionMode((com.baidu.tieba.horizonalList.a.a.b) this.cJm);
            }
            if (this.cJk == 2 || (Build.VERSION.SDK_INT >= 11 && this.cJk == 3)) {
                boolean booleanValue = this.cJo.get(i2, false).booleanValue();
                this.cJo.put(i2, Boolean.valueOf(z));
                if (this.cJp != null && this.mAdapter.hasStableIds()) {
                    if (z) {
                        this.cJp.put(this.mAdapter.getItemId(i2), Integer.valueOf(i2));
                    } else {
                        this.cJp.delete(this.mAdapter.getItemId(i2));
                    }
                }
                if (booleanValue != z) {
                    if (z) {
                        this.cJn++;
                    } else {
                        this.cJn--;
                    }
                }
                if (this.cJl != null) {
                    ((com.baidu.tieba.horizonalList.a.a.b) this.cJm).onItemCheckedStateChanged((ActionMode) this.cJl, i2, this.mAdapter.getItemId(i2), z);
                }
            } else {
                boolean z2 = this.cJp != null && this.mAdapter.hasStableIds();
                if (z || isItemChecked(i2)) {
                    this.cJo.clear();
                    if (z2) {
                        this.cJp.clear();
                    }
                }
                if (z) {
                    this.cJo.put(i2, true);
                    if (z2) {
                        this.cJp.put(this.mAdapter.getItemId(i2), Integer.valueOf(i2));
                    }
                    this.cJn = 1;
                } else if (this.cJo.size() == 0 || !this.cJo.valueAt(0).booleanValue()) {
                    this.cJn = 0;
                }
            }
            if (!this.mInLayout && !this.cLK) {
                this.aeL = true;
                aoh();
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
        if (this.cJk != 0) {
            if (this.cJk == 2 || (Build.VERSION.SDK_INT >= 11 && this.cJk == 3 && this.cJl != null)) {
                boolean z5 = !this.cJo.get(i2, false).booleanValue();
                this.cJo.put(i2, Boolean.valueOf(z5));
                if (this.cJp != null && this.mAdapter.hasStableIds()) {
                    if (z5) {
                        this.cJp.put(this.mAdapter.getItemId(i2), Integer.valueOf(i2));
                    } else {
                        this.cJp.delete(this.mAdapter.getItemId(i2));
                    }
                }
                if (z5) {
                    this.cJn++;
                } else {
                    this.cJn--;
                }
                if (this.cJl != null) {
                    ((com.baidu.tieba.horizonalList.a.a.b) this.cJm).onItemCheckedStateChanged((ActionMode) this.cJl, i2, j2, z5);
                } else {
                    z4 = true;
                }
                z2 = z4;
                z4 = true;
            } else if (this.cJk == 1) {
                if (!this.cJo.get(i2, false).booleanValue()) {
                    this.cJo.clear();
                    this.cJo.put(i2, true);
                    if (this.cJp != null && this.mAdapter.hasStableIds()) {
                        this.cJp.clear();
                        this.cJp.put(this.mAdapter.getItemId(i2), Integer.valueOf(i2));
                    }
                    this.cJn = 1;
                } else if (this.cJo.size() == 0 || !this.cJo.valueAt(0).booleanValue()) {
                    this.cJn = 0;
                }
                z4 = true;
                z2 = true;
            } else {
                z2 = true;
            }
            if (z4) {
                ant();
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

    private void ant() {
        int i2 = this.bxM;
        int childCount = getChildCount();
        boolean z = Build.VERSION.SDK_INT >= 11;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            int i4 = i2 + i3;
            if (childAt instanceof Checkable) {
                ((Checkable) childAt).setChecked(this.cJo.get(i4, false).booleanValue());
            } else if (z) {
                childAt.setActivated(this.cJo.get(i4, false).booleanValue());
            }
        }
    }

    public int getChoiceMode() {
        return this.cJk;
    }

    public void setChoiceMode(int i2) {
        this.cJk = i2;
        if (Build.VERSION.SDK_INT >= 11 && this.cJl != null) {
            if (Build.VERSION.SDK_INT >= 11) {
                ((ActionMode) this.cJl).finish();
            }
            this.cJl = null;
        }
        if (this.cJk != 0) {
            if (this.cJo == null) {
                this.cJo = new SparseArrayCompat<>();
            }
            if (this.cJp == null && this.mAdapter != null && this.mAdapter.hasStableIds()) {
                this.cJp = new LongSparseArray<>();
            }
            if (Build.VERSION.SDK_INT >= 11 && this.cJk == 3) {
                clearChoices();
                setLongClickable(true);
            }
        }
    }

    public void setMultiChoiceModeListener(com.baidu.tieba.horizonalList.a.a.a aVar) {
        if (Build.VERSION.SDK_INT >= 11) {
            if (this.cJm == null) {
                this.cJm = new com.baidu.tieba.horizonalList.a.a.b(this);
            }
            ((com.baidu.tieba.horizonalList.a.a.b) this.cJm).a(aVar);
            return;
        }
        Log.e("AbsListView", "setMultiChoiceModeListener not supported for this version of Android");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean anu() {
        int childCount = getChildCount();
        if (childCount == 0) {
            return true;
        }
        if (childCount != this.cLC) {
            return false;
        }
        return getChildAt(0).getLeft() >= this.cJB.left && getChildAt(childCount + (-1)).getRight() <= getWidth() - this.cJB.right;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public int getHorizontalScrollbarHeight() {
        return super.getHorizontalScrollbarHeight();
    }

    public void setSmoothScrollbarEnabled(boolean z) {
        this.cJT = z;
    }

    public void setOnScrollListener(h hVar) {
        this.cJS = hVar;
        anv();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void anv() {
        if (this.cJS != null) {
            this.cJS.a(this, this.bxM, getChildCount(), this.cLC);
        }
        onScrollChanged(0, 0, 0, 0);
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEvent(int i2) {
        if (i2 == 4096) {
            int firstVisiblePosition = getFirstVisiblePosition();
            int lastVisiblePosition = getLastVisiblePosition();
            if (this.cKw != firstVisiblePosition || this.cKx != lastVisiblePosition) {
                this.cKw = firstVisiblePosition;
                this.cKx = lastVisiblePosition;
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
            anJ();
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

    private void anw() {
        setSelector(getResources().getDrawable(17301602));
    }

    public void setStackFromRight(boolean z) {
        if (this.cJR != z) {
            this.cJR = z;
            anx();
        }
    }

    void anx() {
        if (getChildCount() > 0) {
            any();
            requestLayout();
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new com.baidu.tieba.horizonalList.widget.f();
        long cLh;
        long cLi;
        int cLj;
        String cLk;
        boolean cLl;
        int cLm;
        SparseArrayCompat<Boolean> cLn;
        LongSparseArray<Integer> cLo;
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
            this.cLh = parcel.readLong();
            this.cLi = parcel.readLong();
            this.cLj = parcel.readInt();
            this.position = parcel.readInt();
            this.width = parcel.readInt();
            this.cLk = parcel.readString();
            this.cLl = parcel.readByte() != 0;
            this.cLm = parcel.readInt();
            this.cLn = j(parcel);
            this.cLo = i(parcel);
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
            parcel.writeLong(this.cLh);
            parcel.writeLong(this.cLi);
            parcel.writeInt(this.cLj);
            parcel.writeInt(this.position);
            parcel.writeInt(this.width);
            parcel.writeString(this.cLk);
            parcel.writeByte((byte) (this.cLl ? 1 : 0));
            parcel.writeInt(this.cLm);
            a(this.cLn, parcel);
            a(this.cLo, parcel);
        }

        public String toString() {
            return "AbsListView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " selectedId=" + this.cLh + " firstId=" + this.cLi + " viewLeft=" + this.cLj + " position=" + this.position + " width=" + this.width + " filter=" + this.cLk + " checkState=" + this.cLn + "}";
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        boolean z = true;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.cKB != null) {
            savedState.cLh = this.cKB.cLh;
            savedState.cLi = this.cKB.cLi;
            savedState.cLj = this.cKB.cLj;
            savedState.position = this.cKB.position;
            savedState.width = this.cKB.width;
            savedState.cLk = this.cKB.cLk;
            savedState.cLl = this.cKB.cLl;
            savedState.cLm = this.cKB.cLm;
            savedState.cLn = this.cKB.cLn;
            savedState.cLo = this.cKB.cLo;
            return savedState;
        }
        boolean z2 = getChildCount() > 0 && this.cLC > 0;
        long selectedItemId = getSelectedItemId();
        savedState.cLh = selectedItemId;
        savedState.width = getWidth();
        if (selectedItemId >= 0) {
            savedState.cLj = this.cJQ;
            savedState.position = getSelectedItemPosition();
            savedState.cLi = -1L;
        } else if (z2 && this.bxM > 0) {
            savedState.cLj = getChildAt(0).getLeft();
            int i2 = this.bxM;
            if (i2 >= this.cLC) {
                i2 = this.cLC - 1;
            }
            savedState.position = i2;
            savedState.cLi = this.mAdapter.getItemId(i2);
        } else {
            savedState.cLj = 0;
            savedState.cLi = -1L;
            savedState.position = 0;
        }
        savedState.cLk = null;
        savedState.cLl = (Build.VERSION.SDK_INT < 11 || this.cJk != 3 || this.cJl == null) ? false : false;
        if (this.cJo != null) {
            try {
                savedState.cLn = this.cJo.m1clone();
            } catch (NoSuchMethodError e2) {
                e2.printStackTrace();
                savedState.cLn = new SparseArrayCompat<>();
            }
        }
        if (this.cJp != null) {
            LongSparseArray<Integer> longSparseArray = new LongSparseArray<>();
            int size = this.cJp.size();
            for (int i3 = 0; i3 < size; i3++) {
                longSparseArray.put(this.cJp.keyAt(i3), this.cJp.valueAt(i3));
            }
            savedState.cLo = longSparseArray;
        }
        savedState.cLm = this.cJn;
        return savedState;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.aeL = true;
        this.cLt = savedState.width;
        if (savedState.cLh >= 0) {
            this.cLu = true;
            this.cKB = savedState;
            this.cLs = savedState.cLh;
            this.cLr = savedState.position;
            this.cLq = savedState.cLj;
            this.cLv = 0;
        } else if (savedState.cLi >= 0) {
            setSelectedPositionInt(-1);
            setNextSelectedPositionInt(-1);
            this.cJu = -1;
            this.cLu = true;
            this.cKB = savedState;
            this.cLs = savedState.cLi;
            this.cLr = savedState.position;
            this.cLq = savedState.cLj;
            this.cLv = 1;
        }
        if (savedState.cLn != null) {
            this.cJo = savedState.cLn;
        }
        if (savedState.cLo != null) {
            this.cJp = savedState.cLo;
        }
        this.cJn = savedState.cLm;
        if (Build.VERSION.SDK_INT >= 11 && savedState.cLl && this.cJk == 3 && this.cJm != null) {
            this.cJl = startActionMode((com.baidu.tieba.horizonalList.a.a.b) this.cJm);
        }
        requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onFocusChanged(boolean z, int i2, Rect rect) {
        super.onFocusChanged(z, i2, rect);
        if (z && this.csC < 0 && !isInTouchMode()) {
            if (!this.cKy && this.mAdapter != null) {
                this.aeL = true;
                this.cLD = this.cLC;
                this.cLC = this.mAdapter.getCount();
            }
            anN();
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (!this.cLK && !this.mInLayout) {
            super.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void any() {
        removeAllViewsInLayout();
        this.bxM = 0;
        this.aeL = false;
        this.cKj = null;
        this.cLu = false;
        this.cKB = null;
        this.cLF = -1;
        this.cLG = Long.MIN_VALUE;
        setSelectedPositionInt(-1);
        setNextSelectedPositionInt(-1);
        this.cJQ = 0;
        this.cJu = -1;
        this.cJv.setEmpty();
        invalidate();
    }

    @Override // android.view.View
    protected int computeHorizontalScrollExtent() {
        int childCount = getChildCount();
        if (childCount > 0) {
            if (this.cJT) {
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
        int i3 = this.bxM;
        int childCount = getChildCount();
        if (i3 < 0 || childCount <= 0) {
            return 0;
        }
        if (this.cJT) {
            View childAt = getChildAt(0);
            int left = childAt.getLeft();
            int width = childAt.getWidth();
            if (width > 0) {
                return Math.max(((i3 * 100) - ((left * 100) / width)) + ((int) ((getScrollX() / getWidth()) * this.cLC * 100.0f)), 0);
            }
            return 0;
        }
        int i4 = this.cLC;
        if (i3 != 0) {
            i2 = i3 + childCount == i4 ? i4 : (childCount / 2) + i3;
        }
        return (int) (((i2 / i4) * childCount) + i3);
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        if (this.cJT) {
            int max = Math.max(this.cLC * 100, 0);
            if (getScrollX() != 0) {
                return max + Math.abs((int) ((getScrollX() / getWidth()) * this.cLC * 100.0f));
            }
            return max;
        }
        return this.cLC;
    }

    @Override // android.view.View
    protected float getLeftFadingEdgeStrength() {
        int childCount = getChildCount();
        float leftFadingEdgeStrength = super.getLeftFadingEdgeStrength();
        if (childCount != 0) {
            if (this.bxM > 0) {
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
            if ((this.bxM + childCount) - 1 < this.cLC - 1) {
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
            anw();
        }
        Rect rect = this.cJB;
        rect.left = this.cJx + getPaddingLeft();
        rect.top = this.cJy + getPaddingTop();
        rect.right = this.cJz + getPaddingRight();
        rect.bottom = this.cJA + getPaddingBottom();
        if (this.cKe == 1) {
            int childCount = getChildCount();
            int width = getWidth() - getPaddingRight();
            View childAt = getChildAt(childCount - 1);
            this.cKs = childCount + this.bxM >= this.cKz && (childAt != null ? childAt.getRight() : width) <= width;
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
            this.cJw.anT();
        }
        layoutChildren();
        this.mInLayout = false;
        this.cJX = (i4 - i2) / 3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void layoutChildren() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void anz() {
        boolean z = true;
        if (this.cJD != null) {
            boolean z2 = this.bxM > 0;
            if (!z2 && getChildCount() > 0) {
                z2 = getChildAt(0).getLeft() < this.cJB.left;
            }
            this.cJD.setVisibility(z2 ? 0 : 4);
        }
        if (this.cJE != null) {
            int childCount = getChildCount();
            boolean z3 = this.bxM + childCount < this.cLC;
            if (z3 || childCount <= 0) {
                z = z3;
            } else if (getChildAt(childCount - 1).getRight() <= getRight() - this.cJB.right) {
                z = false;
            }
            this.cJE.setVisibility(z ? 0 : 4);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.g
    @ViewDebug.ExportedProperty
    public View getSelectedView() {
        if (this.cLC <= 0 || this.csC < 0) {
            return null;
        }
        return getChildAt(this.csC - this.bxM);
    }

    public int getListPaddingTop() {
        return this.cJB.top;
    }

    public int getListPaddingBottom() {
        return this.cJB.bottom;
    }

    public int getListPaddingLeft() {
        return this.cJB.left;
    }

    public int getListPaddingRight() {
        return this.cJB.right;
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
        View kB = this.cJw.kB(i2);
        if (kB == null) {
            View kC = this.cJw.kC(i2);
            if (kC != null) {
                view = this.mAdapter.getView(i2, kC, this);
                if (view != kC) {
                    this.cJw.s(kC, i2);
                    if (this.cKf != 0) {
                        view.setDrawingCacheBackgroundColor(this.cKf);
                        kB = view;
                    }
                } else {
                    zArr[0] = true;
                    view.onFinishTemporaryDetach();
                    kB = view;
                }
                if (this.cJs) {
                    ViewGroup.LayoutParams layoutParams = kB.getLayoutParams();
                    if (layoutParams == null) {
                        fVar = (f) generateDefaultLayoutParams();
                    } else if (!checkLayoutParams(layoutParams)) {
                        fVar = (f) generateLayoutParams(layoutParams);
                    } else {
                        fVar = (f) layoutParams;
                    }
                    fVar.cKP = this.mAdapter.getItemId(i2);
                    kB.setLayoutParams(fVar);
                }
                if (this.cLE.isEnabled() && this.cKv == null) {
                    this.cKv = new g();
                }
            } else {
                view = this.mAdapter.getView(i2, null, this);
                if (this.cKf != 0) {
                    view.setDrawingCacheBackgroundColor(this.cKf);
                }
            }
            kB = view;
            if (this.cJs) {
            }
            if (this.cLE.isEnabled()) {
                this.cKv = new g();
            }
        }
        return kB;
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
            this.cJu = i2;
        }
        Rect rect = this.cJv;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        if (view instanceof m) {
            ((m) view).adjustListItemSelectionBounds(rect);
        }
        l(rect.left, rect.top, rect.right, rect.bottom);
        boolean z = this.cKg;
        if (view.isEnabled() != z) {
            this.cKg = !z;
            if (getSelectedItemPosition() != -1) {
                refreshDrawableState();
            }
        }
    }

    private void l(int i2, int i3, int i4, int i5) {
        this.cJv.set(i2 - this.cJx, i3 - this.cJy, this.cJz + i4, this.cJA + i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        boolean z = this.cJt;
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
            this.aeL = true;
            aoh();
        }
    }

    boolean anA() {
        switch (this.mTouchMode) {
            case 1:
            case 2:
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean anB() {
        return (hasFocus() && !isInTouchMode()) || anA();
    }

    private void s(Canvas canvas) {
        if (!this.cJv.isEmpty()) {
            Drawable drawable = this.AG;
            drawable.setBounds(this.cJv);
            drawable.draw(canvas);
        }
    }

    public void setDrawSelectorOnTop(boolean z) {
        this.cJt = z;
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
        this.cJx = rect.left;
        this.cJy = rect.top;
        this.cJz = rect.right;
        this.cJA = rect.bottom;
        drawable.setCallback(this);
        anD();
    }

    public Drawable getSelector() {
        return this.AG;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void anC() {
        if (isEnabled() && isClickable()) {
            Drawable drawable = this.AG;
            Rect rect = this.cJv;
            if (drawable != null) {
                if ((isFocused() || anA()) && !rect.isEmpty()) {
                    View childAt = getChildAt(this.csC - this.bxM);
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
                    if (isLongClickable && !this.aeL) {
                        if (this.cKb == null) {
                            this.cKb = new b(this, null);
                        }
                        this.cKb.anY();
                        postDelayed(this.cKb, ViewConfiguration.getLongPressTimeout());
                    }
                }
            }
        }
    }

    void anD() {
        if (this.AG != null) {
            if (anB()) {
                this.AG.setState(getDrawableState());
            } else {
                this.AG.setState(cKC);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        anD();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i2) {
        if (this.cKg) {
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
        if (this.mAdapter != null && this.cJr == null) {
            this.cJr = new a();
            this.mAdapter.registerDataSetObserver(this.cJr);
            this.aeL = true;
            this.cLD = this.cLC;
            this.cLC = this.mAdapter.getCount();
        }
        this.cKy = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.g, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.cJw.clear();
        getViewTreeObserver().removeOnTouchModeChangeListener(this);
        if (this.mAdapter != null && this.cJr != null) {
            this.mAdapter.unregisterDataSetObserver(this.cJr);
            this.cJr = null;
        }
        if (this.cJO != null) {
            removeCallbacks(this.cJO);
        }
        if (this.cJP != null) {
            this.cJP.stop();
        }
        if (this.cKi != null) {
            removeCallbacks(this.cKi);
        }
        if (this.cKc != null) {
            removeCallbacks(this.cKc);
        }
        if (this.cKd != null) {
            removeCallbacks(this.cKd);
            this.cKd = null;
        }
        this.cKy = false;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        int i2 = isInTouchMode() ? 0 : 1;
        if (!z) {
            setChildrenDrawingCacheEnabled(false);
            if (this.cJO != null) {
                removeCallbacks(this.cJO);
                this.cJO.anR();
                if (this.cJP != null) {
                    this.cJP.stop();
                }
                if (getScrollX() != 0) {
                    this.cJj.setScrollX(0);
                    anP();
                    invalidate();
                }
            }
            if (i2 == 1) {
                this.cJV = this.csC;
            }
        } else if (i2 != this.cJY && this.cJY != -1) {
            if (i2 == 1) {
                anN();
            } else {
                anK();
                this.cJq = 0;
                layoutChildren();
            }
        }
        this.cJY = i2;
    }

    ContextMenu.ContextMenuInfo b(View view, int i2, long j2) {
        return new g.a(view, i2, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class n {
        private int cLp;

        private n() {
        }

        /* synthetic */ n(AbsHListView absHListView, n nVar) {
            this();
        }

        public void anY() {
            this.cLp = AbsHListView.this.getWindowAttachCount();
        }

        public boolean anZ() {
            return AbsHListView.this.hasWindowFocus() && AbsHListView.this.getWindowAttachCount() == this.cLp;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class i extends n implements Runnable {
        int cKQ;

        private i() {
            super(AbsHListView.this, null);
        }

        /* synthetic */ i(AbsHListView absHListView, i iVar) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            View childAt;
            if (!AbsHListView.this.aeL) {
                ListAdapter listAdapter = AbsHListView.this.mAdapter;
                int i = this.cKQ;
                if (listAdapter != null && AbsHListView.this.cLC > 0 && i != -1 && i < listAdapter.getCount() && anZ() && (childAt = AbsHListView.this.getChildAt(i - AbsHListView.this.bxM)) != null) {
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
            View childAt = AbsHListView.this.getChildAt(AbsHListView.this.cJH - AbsHListView.this.bxM);
            if (childAt != null) {
                if ((!anZ() || AbsHListView.this.aeL) ? false : AbsHListView.this.c(childAt, AbsHListView.this.cJH, AbsHListView.this.mAdapter.getItemId(AbsHListView.this.cJH))) {
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
            if (AbsHListView.this.isPressed() && AbsHListView.this.csC >= 0) {
                View childAt = AbsHListView.this.getChildAt(AbsHListView.this.csC - AbsHListView.this.bxM);
                if (!AbsHListView.this.aeL) {
                    if (anZ() ? AbsHListView.this.c(childAt, AbsHListView.this.csC, AbsHListView.this.cLB) : false) {
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
        if (Build.VERSION.SDK_INT >= 11 && this.cJk == 3) {
            if (this.cJl == null) {
                ActionMode startActionMode = startActionMode((com.baidu.tieba.horizonalList.a.a.b) this.cJm);
                this.cJl = startActionMode;
                if (startActionMode != null) {
                    setItemChecked(i2, true);
                    performHapticFeedback(0);
                }
            }
            return true;
        }
        boolean b2 = this.cLy != null ? this.cLy.b(this, view, i2, j2) : false;
        if (!b2) {
            this.cJW = b(view, i2, j2);
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
        return this.cJW;
    }

    public boolean b(float f2, float f3, int i2) {
        int pointToPosition = pointToPosition((int) f2, (int) f3);
        if (pointToPosition != -1) {
            long itemId = this.mAdapter.getItemId(pointToPosition);
            View childAt = getChildAt(pointToPosition - this.bxM);
            if (childAt != null) {
                this.cJW = b(childAt, pointToPosition, itemId);
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
            boolean b2 = this.cLy != null ? this.cLy.b(this, view, positionForView, itemId) : false;
            if (!b2) {
                this.cJW = b(getChildAt(positionForView - this.bxM), positionForView, itemId);
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
                if (isClickable() && isPressed() && this.csC >= 0 && this.mAdapter != null && this.csC < this.mAdapter.getCount()) {
                    View childAt = getChildAt(this.csC - this.bxM);
                    if (childAt != null) {
                        performItemClick(childAt, this.csC, this.cLB);
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
        Rect rect = this.cJU;
        if (rect == null) {
            this.cJU = new Rect();
            rect = this.cJU;
        }
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt.getVisibility() == 0) {
                childAt.getHitRect(rect);
                if (rect.contains(i2, i3)) {
                    return this.bxM + childCount;
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
                View childAt = AbsHListView.this.getChildAt(AbsHListView.this.cJH - AbsHListView.this.bxM);
                if (childAt != null && !childAt.hasFocusable()) {
                    AbsHListView.this.cJq = 0;
                    if (!AbsHListView.this.aeL) {
                        childAt.setPressed(true);
                        AbsHListView.this.setPressed(true);
                        AbsHListView.this.layoutChildren();
                        AbsHListView.this.b(AbsHListView.this.cJH, childAt);
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
                            if (AbsHListView.this.cJZ == null) {
                                AbsHListView.this.cJZ = new c(AbsHListView.this, null);
                            }
                            AbsHListView.this.cJZ.anY();
                            AbsHListView.this.postDelayed(AbsHListView.this.cJZ, longPressTimeout);
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

    private boolean kp(int i2) {
        int i3 = i2 - this.cJK;
        int abs = Math.abs(i3);
        boolean z = getScrollX() != 0;
        if (z || abs > this.mTouchSlop) {
            anI();
            if (z) {
                this.mTouchMode = 5;
                this.cJN = 0;
            } else {
                this.mTouchMode = 3;
                this.cJN = i3 > 0 ? this.mTouchSlop : -this.mTouchSlop;
            }
            Handler handler = getHandler();
            if (handler != null) {
                handler.removeCallbacks(this.cJZ);
            }
            setPressed(false);
            View childAt = getChildAt(this.cJH - this.bxM);
            if (childAt != null) {
                childAt.setPressed(false);
            }
            kr(1);
            ViewParent parent = getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            kq(i2);
            return true;
        }
        return false;
    }

    private void kq(int i2) {
        int i3;
        int childCount;
        ViewParent parent;
        int i4 = i2 - this.cJK;
        int i5 = i4 - this.cJN;
        int i6 = this.cJM != Integer.MIN_VALUE ? i2 - this.cJM : i5;
        if (this.mTouchMode == 3) {
            if (i2 != this.cJM) {
                if (Math.abs(i4) > this.mTouchSlop && (parent = getParent()) != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
                if (this.cJH >= 0) {
                    childCount = this.cJH - this.bxM;
                } else {
                    childCount = getChildCount() / 2;
                }
                View childAt = getChildAt(childCount);
                int left = childAt != null ? childAt.getLeft() : 0;
                boolean aB = i6 != 0 ? aB(i5, i6) : false;
                View childAt2 = getChildAt(childCount);
                if (childAt2 != null) {
                    int left2 = childAt2.getLeft();
                    if (aB) {
                        int i7 = (-i6) - (left2 - left);
                        overScrollBy(i7, 0, getScrollX(), 0, 0, 0, this.cKm, 0, true);
                        if (Math.abs(this.cKm) == Math.abs(getScrollX()) && this.mVelocityTracker != null) {
                            this.mVelocityTracker.clear();
                        }
                        int overScrollMode = getOverScrollMode();
                        if (overScrollMode == 0 || (overScrollMode == 1 && !anu())) {
                            this.mDirection = 0;
                            this.mTouchMode = 5;
                            if (i4 > 0) {
                                this.cKo.onPull(i7 / getWidth());
                                if (!this.cKp.isFinished()) {
                                    this.cKp.onRelease();
                                }
                                invalidate();
                            } else if (i4 < 0) {
                                this.cKp.onPull(i7 / getWidth());
                                if (!this.cKo.isFinished()) {
                                    this.cKo.onRelease();
                                }
                                invalidate();
                            }
                        }
                    }
                    this.cJK = i2;
                }
                this.cJM = i2;
            }
        } else if (this.mTouchMode == 5 && i2 != this.cJM) {
            int scrollX = getScrollX();
            int i8 = scrollX - i6;
            int i9 = i2 > this.cJM ? 1 : -1;
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
                overScrollBy(i10, 0, getScrollX(), 0, 0, 0, this.cKm, 0, true);
                int overScrollMode2 = getOverScrollMode();
                if (overScrollMode2 == 0 || (overScrollMode2 == 1 && !anu())) {
                    if (i4 > 0) {
                        this.cKo.onPull(i10 / getWidth());
                        if (!this.cKp.isFinished()) {
                            this.cKp.onRelease();
                        }
                        invalidate();
                    } else if (i4 < 0) {
                        this.cKp.onPull(i10 / getWidth());
                        if (!this.cKo.isFinished()) {
                            this.cKo.onRelease();
                        }
                        invalidate();
                    }
                }
            }
            if (i3 != 0) {
                if (getScrollX() != 0) {
                    this.cJj.setScrollX(0);
                    anE();
                }
                aB(i3, i3);
                this.mTouchMode = 3;
                int ku = ku(i2);
                this.cJN = 0;
                View childAt3 = getChildAt(ku - this.bxM);
                this.cJI = childAt3 != null ? childAt3.getLeft() : 0;
                this.cJK = i2;
                this.cJH = ku;
            }
            this.cJM = i2;
            this.mDirection = i9;
        }
    }

    protected void anE() {
        if (this.cJj.isHardwareAccelerated() && (getParent() instanceof View)) {
            ((View) getParent()).invalidate();
        }
    }

    @Override // android.view.ViewTreeObserver.OnTouchModeChangeListener
    public void onTouchModeChanged(boolean z) {
        if (z) {
            anK();
            if (getWidth() > 0 && getChildCount() > 0) {
                layoutChildren();
            }
            anD();
            return;
        }
        int i2 = this.mTouchMode;
        if (i2 == 5 || i2 == 6) {
            if (this.cJO != null) {
                this.cJO.anR();
            }
            if (this.cJP != null) {
                this.cJP.stop();
            }
            if (getScrollX() != 0) {
                this.cJj.setScrollX(0);
                anP();
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
        if (this.cJP != null) {
            this.cJP.stop();
        }
        if (this.cKy) {
            int action = motionEvent.getAction();
            anG();
            this.mVelocityTracker.addMovement(motionEvent);
            switch (action & MotionEventCompat.ACTION_MASK) {
                case 0:
                    switch (this.mTouchMode) {
                        case 6:
                            this.cJO.anR();
                            if (this.cJP != null) {
                                this.cJP.stop();
                            }
                            this.mTouchMode = 5;
                            this.cJL = (int) motionEvent.getY();
                            int x = (int) motionEvent.getX();
                            this.cJM = x;
                            this.cJK = x;
                            this.cJN = 0;
                            this.mActivePointerId = motionEvent.getPointerId(0);
                            this.mDirection = 0;
                            break;
                        default:
                            this.mActivePointerId = motionEvent.getPointerId(0);
                            int x2 = (int) motionEvent.getX();
                            int y = (int) motionEvent.getY();
                            int pointToPosition = pointToPosition(x2, y);
                            if (!this.aeL) {
                                if (this.mTouchMode != 4 && pointToPosition >= 0 && getAdapter().isEnabled(pointToPosition)) {
                                    this.mTouchMode = 0;
                                    if (this.cKa == null) {
                                        this.cKa = new d();
                                    }
                                    postDelayed(this.cKa, ViewConfiguration.getTapTimeout());
                                    i2 = pointToPosition;
                                } else if (this.mTouchMode == 4) {
                                    anI();
                                    this.mTouchMode = 3;
                                    this.cJN = 0;
                                    i2 = kt(x2);
                                    this.cJO.anS();
                                }
                                if (i2 >= 0) {
                                    this.cJI = getChildAt(i2 - this.bxM).getLeft();
                                }
                                this.cJK = x2;
                                this.cJL = y;
                                this.cJH = i2;
                                this.cJM = ExploreByTouchHelper.INVALID_ID;
                                break;
                            }
                            i2 = pointToPosition;
                            if (i2 >= 0) {
                            }
                            this.cJK = x2;
                            this.cJL = y;
                            this.cJH = i2;
                            this.cJM = ExploreByTouchHelper.INVALID_ID;
                    }
                    if (j(motionEvent) && this.mTouchMode == 0) {
                        removeCallbacks(this.cKa);
                        break;
                    }
                    break;
                case 1:
                    switch (this.mTouchMode) {
                        case 0:
                        case 1:
                        case 2:
                            int i3 = this.cJH;
                            View childAt = getChildAt(i3 - this.bxM);
                            float x3 = motionEvent.getX();
                            boolean z = x3 > ((float) this.cJB.left) && x3 < ((float) (getWidth() - this.cJB.right));
                            if (childAt != null && !childAt.hasFocusable() && z) {
                                if (this.mTouchMode != 0) {
                                    childAt.setPressed(false);
                                }
                                if (this.cKc == null) {
                                    this.cKc = new i(this, null);
                                }
                                i iVar = this.cKc;
                                iVar.cKQ = i3;
                                iVar.anY();
                                this.cJV = i3;
                                if (this.mTouchMode == 0 || this.mTouchMode == 1) {
                                    Handler handler = getHandler();
                                    if (handler != null) {
                                        handler.removeCallbacks(this.mTouchMode == 0 ? this.cKa : this.cJZ);
                                    }
                                    this.cJq = 0;
                                    if (!this.aeL && this.mAdapter.isEnabled(i3)) {
                                        this.mTouchMode = 1;
                                        setSelectedPositionInt(this.cJH);
                                        layoutChildren();
                                        childAt.setPressed(true);
                                        b(this.cJH, childAt);
                                        setPressed(true);
                                        if (this.AG != null && (current = this.AG.getCurrent()) != null && (current instanceof TransitionDrawable)) {
                                            ((TransitionDrawable) current).resetTransition();
                                        }
                                        if (this.cKd != null) {
                                            removeCallbacks(this.cKd);
                                        }
                                        this.cKd = new com.baidu.tieba.horizonalList.widget.a(this, childAt, iVar);
                                        postDelayed(this.cKd, ViewConfiguration.getPressedStateDuration());
                                    } else {
                                        this.mTouchMode = -1;
                                        anD();
                                    }
                                    return true;
                                } else if (!this.aeL && this.mAdapter.isEnabled(i3)) {
                                    iVar.run();
                                }
                            }
                            this.mTouchMode = -1;
                            anD();
                            break;
                        case 3:
                            int childCount = getChildCount();
                            if (childCount > 0) {
                                int left = getChildAt(0).getLeft();
                                int right = getChildAt(childCount - 1).getRight();
                                int i4 = this.cJB.left;
                                int width = getWidth() - this.cJB.right;
                                if (this.bxM == 0 && left >= i4 && this.bxM + childCount < this.cLC && right <= getWidth() - width) {
                                    this.mTouchMode = -1;
                                    kr(0);
                                    break;
                                } else {
                                    VelocityTracker velocityTracker = this.mVelocityTracker;
                                    velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                                    int xVelocity = (int) (velocityTracker.getXVelocity(this.mActivePointerId) * this.cKk);
                                    if (Math.abs(xVelocity) > this.mMinimumVelocity && ((this.bxM != 0 || left != i4 - this.cKm) && (childCount + this.bxM != this.cLC || right != this.cKm + width))) {
                                        if (this.cJO == null) {
                                            this.cJO = new e();
                                        }
                                        kr(2);
                                        this.cJO.kv(-xVelocity);
                                        break;
                                    } else {
                                        this.mTouchMode = -1;
                                        kr(0);
                                        if (this.cJO != null) {
                                            this.cJO.anR();
                                        }
                                        if (this.cJP != null) {
                                            this.cJP.stop();
                                            break;
                                        }
                                    }
                                }
                            } else {
                                this.mTouchMode = -1;
                                kr(0);
                                break;
                            }
                            break;
                        case 5:
                            if (this.cJO == null) {
                                this.cJO = new e();
                            }
                            VelocityTracker velocityTracker2 = this.mVelocityTracker;
                            velocityTracker2.computeCurrentVelocity(1000, this.mMaximumVelocity);
                            int xVelocity2 = (int) velocityTracker2.getXVelocity(this.mActivePointerId);
                            kr(2);
                            if (Math.abs(xVelocity2) > this.mMinimumVelocity) {
                                this.cJO.kw(-xVelocity2);
                                break;
                            } else {
                                this.cJO.anQ();
                                break;
                            }
                    }
                    setPressed(false);
                    if (this.cKo != null) {
                        this.cKo.onRelease();
                        this.cKp.onRelease();
                    }
                    invalidate();
                    Handler handler2 = getHandler();
                    if (handler2 != null) {
                        handler2.removeCallbacks(this.cJZ);
                    }
                    anH();
                    this.mActivePointerId = -1;
                    break;
                case 2:
                    int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                    if (findPointerIndex == -1) {
                        this.mActivePointerId = motionEvent.getPointerId(0);
                        findPointerIndex = 0;
                    }
                    int x4 = (int) motionEvent.getX(findPointerIndex);
                    if (this.aeL) {
                        layoutChildren();
                    }
                    switch (this.mTouchMode) {
                        case 0:
                        case 1:
                        case 2:
                            kp(x4);
                            break;
                        case 3:
                        case 5:
                            kq(x4);
                            break;
                    }
                case 3:
                    switch (this.mTouchMode) {
                        case 5:
                            if (this.cJO == null) {
                                this.cJO = new e();
                            }
                            this.cJO.anQ();
                            break;
                        case 6:
                            break;
                        default:
                            this.mTouchMode = -1;
                            setPressed(false);
                            View childAt2 = getChildAt(this.cJH - this.bxM);
                            if (childAt2 != null) {
                                childAt2.setPressed(false);
                            }
                            anJ();
                            Handler handler3 = getHandler();
                            if (handler3 != null) {
                                handler3.removeCallbacks(this.cJZ);
                            }
                            anH();
                            break;
                    }
                    if (this.cKo != null) {
                        this.cKo.onRelease();
                        this.cKp.onRelease();
                    }
                    this.mActivePointerId = -1;
                    break;
                case 5:
                    int actionIndex = motionEvent.getActionIndex();
                    int pointerId = motionEvent.getPointerId(actionIndex);
                    int x5 = (int) motionEvent.getX(actionIndex);
                    int y2 = (int) motionEvent.getY(actionIndex);
                    this.cJN = 0;
                    this.mActivePointerId = pointerId;
                    this.cJK = x5;
                    this.cJL = y2;
                    int pointToPosition2 = pointToPosition(x5, y2);
                    if (pointToPosition2 >= 0) {
                        this.cJI = getChildAt(pointToPosition2 - this.bxM).getLeft();
                        this.cJH = pointToPosition2;
                    }
                    this.cJM = x5;
                    break;
                case 6:
                    onSecondaryPointerUp(motionEvent);
                    int i5 = this.cJK;
                    int pointToPosition3 = pointToPosition(i5, this.cJL);
                    if (pointToPosition3 >= 0) {
                        this.cJI = getChildAt(pointToPosition3 - this.bxM).getLeft();
                        this.cJH = pointToPosition3;
                    }
                    this.cJM = i5;
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
            this.cJj.setScrollX(i2);
            anE();
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
                            if (!aB(horizontalScrollFactor, horizontalScrollFactor)) {
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
        if (this.cKD == 0.0f) {
            TypedValue typedValue = new TypedValue();
            if (getContext().getTheme().resolveAttribute(r.c.hlv_listPreferredItemWidth, typedValue, true)) {
                this.cKD = typedValue.getDimension(getContext().getResources().getDisplayMetrics());
            } else {
                throw new IllegalStateException("Expected theme to define hlv_listPreferredItemWidth.");
            }
        }
        return this.cKD;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.cKo != null) {
            int scrollX = getScrollX();
            if (!this.cKo.isFinished()) {
                int save = canvas.save();
                int i2 = this.cJB.top + this.cKt;
                int height = (getHeight() - i2) - (this.cJB.bottom + this.cKu);
                int min = Math.min(0, this.cKq + scrollX);
                canvas.rotate(-90.0f);
                canvas.translate(i2 + (-getHeight()), min);
                this.cKo.setSize(height, height);
                if (this.cKo.draw(canvas)) {
                    invalidate();
                }
                canvas.restoreToCount(save);
            }
            if (!this.cKp.isFinished()) {
                int save2 = canvas.save();
                int i3 = this.cJB.left + this.cKt;
                int height2 = (getHeight() - i3) - (this.cJB.right + this.cKu);
                int max = Math.max(getWidth(), scrollX + this.cKr);
                canvas.rotate(90.0f);
                canvas.translate(-i3, -max);
                this.cKp.setSize(height2, height2);
                if (this.cKp.draw(canvas)) {
                    invalidate();
                }
                canvas.restoreToCount(save2);
            }
        }
    }

    private void anF() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        } else {
            this.mVelocityTracker.clear();
        }
    }

    private void anG() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
    }

    private void anH() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            anH();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.cJP != null) {
            this.cJP.stop();
        }
        if (this.cKy) {
            switch (action & MotionEventCompat.ACTION_MASK) {
                case 0:
                    int i2 = this.mTouchMode;
                    if (i2 == 6 || i2 == 5) {
                        this.cJN = 0;
                        return true;
                    }
                    int x = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();
                    this.mActivePointerId = motionEvent.getPointerId(0);
                    int kt = kt(x);
                    if (i2 != 4 && kt >= 0) {
                        this.cJI = getChildAt(kt - this.bxM).getLeft();
                        this.cJK = x;
                        this.cJL = y;
                        this.cJH = kt;
                        this.mTouchMode = 0;
                        anJ();
                    }
                    this.cJM = ExploreByTouchHelper.INVALID_ID;
                    anF();
                    this.mVelocityTracker.addMovement(motionEvent);
                    return i2 == 4;
                case 1:
                case 3:
                    this.mTouchMode = -1;
                    this.mActivePointerId = -1;
                    anH();
                    kr(0);
                    return false;
                case 2:
                    switch (this.mTouchMode) {
                        case 0:
                            int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                            if (findPointerIndex == -1) {
                                this.mActivePointerId = motionEvent.getPointerId(0);
                                findPointerIndex = 0;
                            }
                            anG();
                            this.mVelocityTracker.addMovement(motionEvent);
                            return kp((int) motionEvent.getX(findPointerIndex));
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
            this.cJK = (int) motionEvent.getX(i2);
            this.cJL = (int) motionEvent.getY(i2);
            this.cJN = 0;
            this.mActivePointerId = motionEvent.getPointerId(i2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        int childCount = getChildCount();
        int i2 = this.bxM;
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
    public void kr(int i2) {
        if (i2 != this.cKh && this.cJS != null) {
            this.cKh = i2;
            this.cJS.a(this, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e implements Runnable {
        private final o cKH;
        private int cKI;
        private final Runnable cKJ = new com.baidu.tieba.horizonalList.widget.c(this);

        e() {
            this.cKH = new o(AbsHListView.this.getContext());
        }

        void kv(int i) {
            int i2 = i < 0 ? Integer.MAX_VALUE : 0;
            this.cKI = i2;
            this.cKH.setInterpolator(null);
            this.cKH.fling(i2, 0, i, 0, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
            AbsHListView.this.mTouchMode = 4;
            AbsHListView.this.cJj.k(this);
        }

        void anQ() {
            if (this.cKH.springBack(AbsHListView.this.getScrollX(), 0, 0, 0, 0, 0)) {
                AbsHListView.this.mTouchMode = 6;
                AbsHListView.this.invalidate();
                AbsHListView.this.cJj.k(this);
                return;
            }
            AbsHListView.this.mTouchMode = -1;
            AbsHListView.this.kr(0);
        }

        void kw(int i) {
            this.cKH.setInterpolator(null);
            this.cKH.fling(AbsHListView.this.getScrollX(), 0, i, 0, ExploreByTouchHelper.INVALID_ID, Integer.MAX_VALUE, 0, 0, AbsHListView.this.getWidth(), 0);
            AbsHListView.this.mTouchMode = 6;
            AbsHListView.this.invalidate();
            AbsHListView.this.cJj.k(this);
        }

        void kx(int i) {
            this.cKH.notifyHorizontalEdgeReached(AbsHListView.this.getScrollX(), 0, AbsHListView.this.cKn);
            int overScrollMode = AbsHListView.this.getOverScrollMode();
            if (overScrollMode == 0 || (overScrollMode == 1 && !AbsHListView.this.anu())) {
                AbsHListView.this.mTouchMode = 6;
                int currVelocity = (int) this.cKH.getCurrVelocity();
                if (i > 0) {
                    AbsHListView.this.cKo.onAbsorb(currVelocity);
                } else {
                    AbsHListView.this.cKp.onAbsorb(currVelocity);
                }
            } else {
                AbsHListView.this.mTouchMode = -1;
                if (AbsHListView.this.cJP != null) {
                    AbsHListView.this.cJP.stop();
                }
            }
            AbsHListView.this.invalidate();
            AbsHListView.this.cJj.k(this);
        }

        void d(int i, int i2, boolean z) {
            int i3 = i < 0 ? Integer.MAX_VALUE : 0;
            this.cKI = i3;
            this.cKH.setInterpolator(z ? AbsHListView.cKA : null);
            this.cKH.startScroll(i3, 0, i, 0, i2);
            AbsHListView.this.mTouchMode = 4;
            AbsHListView.this.cJj.k(this);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void anR() {
            AbsHListView.this.mTouchMode = -1;
            AbsHListView.this.removeCallbacks(this);
            AbsHListView.this.removeCallbacks(this.cKJ);
            AbsHListView.this.kr(0);
            AbsHListView.this.anJ();
            this.cKH.abortAnimation();
            AbsHListView.this.overScrollBy(0, 0, 0, 0, 0, 0, 0, 0, false);
        }

        void anS() {
            AbsHListView.this.postDelayed(this.cKJ, 40L);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // java.lang.Runnable
        public void run() {
            int max;
            boolean z = true;
            boolean z2 = false;
            switch (AbsHListView.this.mTouchMode) {
                case 3:
                    if (this.cKH.isFinished()) {
                        return;
                    }
                    break;
                case 4:
                    break;
                case 5:
                default:
                    anR();
                    return;
                case 6:
                    o oVar = this.cKH;
                    if (oVar.computeScrollOffset()) {
                        int scrollX = AbsHListView.this.getScrollX();
                        int currX = oVar.getCurrX();
                        if (AbsHListView.this.overScrollBy(currX - scrollX, 0, scrollX, 0, 0, 0, AbsHListView.this.cKn, 0, false)) {
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
                                kv(currVelocity);
                                return;
                            }
                            anQ();
                            return;
                        }
                        AbsHListView.this.invalidate();
                        AbsHListView.this.cJj.k(this);
                        return;
                    }
                    anR();
                    return;
            }
            if (AbsHListView.this.aeL) {
                AbsHListView.this.layoutChildren();
            }
            if (AbsHListView.this.cLC == 0 || AbsHListView.this.getChildCount() == 0) {
                anR();
                return;
            }
            o oVar2 = this.cKH;
            boolean computeScrollOffset = oVar2.computeScrollOffset();
            int currX2 = oVar2.getCurrX();
            int i = this.cKI - currX2;
            if (i > 0) {
                AbsHListView.this.cJH = AbsHListView.this.bxM;
                AbsHListView.this.cJI = AbsHListView.this.getChildAt(0).getLeft();
                max = Math.min(((AbsHListView.this.getWidth() - AbsHListView.this.getPaddingRight()) - AbsHListView.this.getPaddingLeft()) - 1, i);
            } else {
                int childCount = AbsHListView.this.getChildCount() - 1;
                AbsHListView.this.cJH = AbsHListView.this.bxM + childCount;
                AbsHListView.this.cJI = AbsHListView.this.getChildAt(childCount).getLeft();
                max = Math.max(-(((AbsHListView.this.getWidth() - AbsHListView.this.getPaddingRight()) - AbsHListView.this.getPaddingLeft()) - 1), i);
            }
            View childAt = AbsHListView.this.getChildAt(AbsHListView.this.cJH - AbsHListView.this.bxM);
            int left = childAt != null ? childAt.getLeft() : 0;
            boolean aB = AbsHListView.this.aB(max, max);
            if (!aB || max == 0) {
                z = false;
            }
            if (z) {
                if (childAt != null) {
                    AbsHListView.this.overScrollBy(-(max - (childAt.getLeft() - left)), 0, AbsHListView.this.getScrollX(), 0, 0, 0, AbsHListView.this.cKn, 0, false);
                }
                if (computeScrollOffset) {
                    kx(max);
                }
            } else if (computeScrollOffset && !z) {
                if (aB) {
                    AbsHListView.this.invalidate();
                }
                this.cKI = currX2;
                AbsHListView.this.cJj.k(this);
            } else {
                anR();
            }
        }
    }

    /* loaded from: classes.dex */
    public class j implements Runnable {
        private int cKR;
        private int cKS;
        private int cKT;
        private int cKU;
        private final int cKV;
        private int cKW;
        private int mMode;

        j() {
            this.cKV = ViewConfiguration.get(AbsHListView.this.getContext()).getScaledFadingEdgeLength();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void kv(int i) {
            int i2;
            stop();
            if (AbsHListView.this.aeL) {
                AbsHListView.this.cKj = new com.baidu.tieba.horizonalList.widget.d(this, i);
                return;
            }
            int childCount = AbsHListView.this.getChildCount();
            if (childCount != 0) {
                int i3 = AbsHListView.this.bxM;
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
                    this.cKU = 200 / i2;
                } else {
                    this.cKU = 200;
                }
                this.cKR = max;
                this.cKS = -1;
                this.cKT = -1;
                AbsHListView.this.cJj.k(this);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void aD(int i, int i2) {
            int i3;
            stop();
            if (i2 == -1) {
                kv(i);
            } else if (AbsHListView.this.aeL) {
                AbsHListView.this.cKj = new com.baidu.tieba.horizonalList.widget.e(this, i, i2);
            } else {
                int childCount = AbsHListView.this.getChildCount();
                if (childCount != 0) {
                    int i4 = AbsHListView.this.bxM;
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
                        this.cKU = 200 / i3;
                    } else {
                        this.cKU = 200;
                    }
                    this.cKR = max;
                    this.cKS = i2;
                    this.cKT = -1;
                    AbsHListView.this.cJj.k(this);
                }
            }
        }

        void w(int i, int i2, int i3) {
            int i4 = AbsHListView.this.bxM;
            int childCount = (AbsHListView.this.getChildCount() + i4) - 1;
            int i5 = AbsHListView.this.cJB.left;
            int width = AbsHListView.this.getWidth() - AbsHListView.this.cJB.right;
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
            int i2 = AbsHListView.this.bxM;
            switch (this.mMode) {
                case 1:
                    int childCount = AbsHListView.this.getChildCount() - 1;
                    int i3 = i2 + childCount;
                    if (childCount >= 0) {
                        if (i3 == this.cKT) {
                            AbsHListView.this.cJj.k(this);
                            return;
                        }
                        View childAt = AbsHListView.this.getChildAt(childCount);
                        AbsHListView.this.c((i3 < AbsHListView.this.cLC + (-1) ? Math.max(AbsHListView.this.cJB.right, this.cKV) : AbsHListView.this.cJB.right) + (childAt.getWidth() - (width - childAt.getLeft())), this.cKU, true);
                        this.cKT = i3;
                        if (i3 < this.cKR) {
                            AbsHListView.this.cJj.k(this);
                            return;
                        }
                        return;
                    }
                    return;
                case 2:
                    if (i2 == this.cKT) {
                        AbsHListView.this.cJj.k(this);
                        return;
                    }
                    View childAt2 = AbsHListView.this.getChildAt(0);
                    if (childAt2 != null) {
                        AbsHListView.this.c(childAt2.getLeft() - (i2 > 0 ? Math.max(this.cKV, AbsHListView.this.cJB.left) : AbsHListView.this.cJB.left), this.cKU, true);
                        this.cKT = i2;
                        if (i2 > this.cKR) {
                            AbsHListView.this.cJj.k(this);
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    int childCount2 = AbsHListView.this.getChildCount();
                    if (i2 != this.cKS && childCount2 > 1 && childCount2 + i2 < AbsHListView.this.cLC) {
                        int i4 = i2 + 1;
                        if (i4 == this.cKT) {
                            AbsHListView.this.cJj.k(this);
                            return;
                        }
                        View childAt3 = AbsHListView.this.getChildAt(1);
                        int width2 = childAt3.getWidth();
                        int left2 = childAt3.getLeft();
                        int max = Math.max(AbsHListView.this.cJB.right, this.cKV);
                        if (i4 < this.cKS) {
                            AbsHListView.this.c(Math.max(0, (left2 + width2) - max), this.cKU, true);
                            this.cKT = i4;
                            AbsHListView.this.cJj.k(this);
                            return;
                        } else if (left2 > max) {
                            AbsHListView.this.c(left2 - max, this.cKU, true);
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
                        if (i5 == this.cKT) {
                            AbsHListView.this.cJj.k(this);
                            return;
                        }
                        View childAt4 = AbsHListView.this.getChildAt(childCount3);
                        int width3 = childAt4.getWidth();
                        int left3 = childAt4.getLeft();
                        int i6 = width - left3;
                        int max2 = Math.max(AbsHListView.this.cJB.left, this.cKV);
                        this.cKT = i5;
                        if (i5 > this.cKS) {
                            AbsHListView.this.c(-(i6 - max2), this.cKU, true);
                            AbsHListView.this.cJj.k(this);
                            return;
                        }
                        int i7 = width - max2;
                        int i8 = left3 + width3;
                        if (i7 > i8) {
                            AbsHListView.this.c(-(i7 - i8), this.cKU, true);
                            return;
                        }
                        return;
                    }
                    return;
                case 5:
                    if (this.cKT == i2) {
                        AbsHListView.this.cJj.k(this);
                        return;
                    }
                    this.cKT = i2;
                    int childCount4 = AbsHListView.this.getChildCount();
                    int i9 = this.cKR;
                    int i10 = (i2 + childCount4) - 1;
                    if (i9 < i2) {
                        i = (i2 - i9) + 1;
                    } else if (i9 > i10) {
                        i = i9 - i10;
                    }
                    float min = Math.min(Math.abs(i / childCount4), 1.0f);
                    if (i9 < i2) {
                        AbsHListView.this.c((int) ((-AbsHListView.this.getWidth()) * min), (int) (min * this.cKU), true);
                        AbsHListView.this.cJj.k(this);
                        return;
                    } else if (i9 > i10) {
                        AbsHListView.this.c((int) (AbsHListView.this.getWidth() * min), (int) (min * this.cKU), true);
                        AbsHListView.this.cJj.k(this);
                        return;
                    } else {
                        AbsHListView.this.c(AbsHListView.this.getChildAt(i9 - i2).getLeft() - this.cKW, (int) (this.cKU * (Math.abs(left) / AbsHListView.this.getWidth())), true);
                        return;
                    }
                default:
                    return;
            }
        }
    }

    public void setFriction(float f2) {
        if (this.cJO == null) {
            this.cJO = new e();
        }
        this.cJO.cKH.setFriction(f2);
    }

    public void setVelocityScale(float f2) {
        this.cKk = f2;
    }

    public void smoothScrollToPosition(int i2, int i3) {
        if (this.cJP == null) {
            this.cJP = new j();
        }
        this.cJP.aD(i2, i3);
    }

    public void smoothScrollBy(int i2, int i3) {
        c(i2, i3, false);
    }

    public void c(int i2, int i3, boolean z) {
        if (this.cJO == null) {
            this.cJO = new e();
        }
        int i4 = this.bxM;
        int childCount = getChildCount();
        int i5 = i4 + childCount;
        int paddingLeft = getPaddingLeft();
        int width = getWidth() - getPaddingRight();
        if (i2 == 0 || this.cLC == 0 || childCount == 0 || ((i4 == 0 && getChildAt(0).getLeft() == paddingLeft && i2 < 0) || (i5 == this.cLC && getChildAt(childCount - 1).getRight() == width && i2 > 0))) {
            this.cJO.anR();
            if (this.cJP != null) {
                this.cJP.stop();
                return;
            }
            return;
        }
        kr(2);
        this.cJO.d(i2, i3, z);
    }

    private void anI() {
        if (this.mScrollingCacheEnabled && !this.cJF && !this.cJj.isHardwareAccelerated()) {
            setChildrenDrawnWithCacheEnabled(true);
            setChildrenDrawingCacheEnabled(true);
            this.cJG = true;
            this.cJF = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anJ() {
        if (!this.cJj.isHardwareAccelerated()) {
            if (this.cKi == null) {
                this.cKi = new com.baidu.tieba.horizonalList.widget.b(this);
            }
            post(this.cKi);
        }
    }

    boolean aB(int i2, int i3) {
        int min;
        int min2;
        int i4;
        int childCount = getChildCount();
        if (childCount == 0) {
            return true;
        }
        int left = getChildAt(0).getLeft();
        int right = getChildAt(childCount - 1).getRight();
        Rect rect = this.cJB;
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
        int i6 = this.bxM;
        if (i6 == 0) {
            this.cKq = left - rect.left;
        } else {
            this.cKq += min2;
        }
        if (i6 + childCount == this.cLC) {
            this.cKr = rect.right + right;
        } else {
            this.cKr += min2;
        }
        boolean z = i6 == 0 && left >= rect.left && min2 >= 0;
        boolean z2 = i6 + childCount == this.cLC && right <= getWidth() - rect.right && min2 <= 0;
        if (z || z2) {
            return min2 != 0;
        }
        boolean z3 = min2 < 0;
        boolean isInTouchMode = isInTouchMode();
        if (isInTouchMode) {
            anK();
        }
        int headerViewsCount = getHeaderViewsCount();
        int footerViewsCount = this.cLC - getFooterViewsCount();
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
                    this.cJw.s(childAt, i11);
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
                    this.cJw.s(childAt2, i14);
                }
                i4 = i13;
                i7 = i12;
            }
        }
        this.cJJ = this.cJI + min;
        this.cLK = true;
        if (i4 > 0) {
            detachViewsFromParent(i7, i4);
            this.cJw.anV();
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        ks(min2);
        if (z3) {
            this.bxM = i4 + this.bxM;
        }
        int abs = Math.abs(min2);
        if (i5 < abs || width < abs) {
            fg(z3);
        }
        if (!isInTouchMode && this.csC != -1) {
            int i15 = this.csC - this.bxM;
            if (i15 >= 0 && i15 < getChildCount()) {
                b(this.csC, getChildAt(i15));
            }
        } else if (this.cJu != -1) {
            int i16 = this.cJu - this.bxM;
            if (i16 >= 0 && i16 < getChildCount()) {
                b(-1, getChildAt(i16));
            }
        } else {
            this.cJv.setEmpty();
        }
        this.cLK = false;
        anv();
        return false;
    }

    public void ks(int i2) {
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
    public void anK() {
        if (this.csC != -1) {
            if (this.cJq != 4) {
                this.cJV = this.csC;
            }
            if (this.cLz >= 0 && this.cLz != this.csC) {
                this.cJV = this.cLz;
            }
            setSelectedPositionInt(-1);
            setNextSelectedPositionInt(-1);
            this.cJQ = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int anL() {
        int i2 = this.csC;
        if (i2 < 0) {
            i2 = this.cJV;
        }
        return Math.min(Math.max(0, i2), this.cLC - 1);
    }

    protected int ku(int i2) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return -1;
        }
        int kt = kt(i2);
        return kt == -1 ? (this.bxM + childCount) - 1 : kt;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean anM() {
        if (this.csC >= 0 || !anN()) {
            return false;
        }
        anD();
        return true;
    }

    boolean anN() {
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
        int i8 = this.cJB.left;
        int right = (getRight() - getLeft()) - this.cJB.right;
        int i9 = this.bxM;
        int i10 = this.cJV;
        if (i10 >= i9 && i10 < i9 + childCount) {
            View childAt = getChildAt(i10 - this.bxM);
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
            int i15 = this.cLC;
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
        this.cJV = -1;
        removeCallbacks(this.cJO);
        if (this.cJP != null) {
            this.cJP.stop();
        }
        this.mTouchMode = -1;
        anJ();
        this.cLq = i2;
        int C = C(i3, z);
        if (C < i9 || C > getLastVisiblePosition()) {
            C = -1;
        } else {
            this.cJq = 4;
            anD();
            setSelectionInt(C);
            anv();
        }
        kr(0);
        return C >= 0;
    }

    void anO() {
        int i2;
        boolean z;
        boolean z2;
        this.cJo.clear();
        int i3 = 0;
        boolean z3 = false;
        while (i3 < this.cJp.size()) {
            long keyAt = this.cJp.keyAt(i3);
            int intValue = this.cJp.valueAt(i3).intValue();
            if (keyAt != this.mAdapter.getItemId(intValue)) {
                int max = Math.max(0, intValue - 20);
                int min = Math.min(intValue + 20, this.cLC);
                while (true) {
                    if (max >= min) {
                        z2 = false;
                        break;
                    } else if (keyAt != this.mAdapter.getItemId(max)) {
                        max++;
                    } else {
                        this.cJo.put(max, true);
                        this.cJp.setValueAt(i3, Integer.valueOf(max));
                        z2 = true;
                        break;
                    }
                }
                if (!z2) {
                    this.cJp.delete(keyAt);
                    int i4 = i3 - 1;
                    this.cJn--;
                    if (Build.VERSION.SDK_INT <= 11 || this.cJl == null || this.cJm == null) {
                        i2 = i4;
                        z = true;
                    } else {
                        ((com.baidu.tieba.horizonalList.a.a.b) this.cJm).onItemCheckedStateChanged((ActionMode) this.cJl, intValue, keyAt, false);
                        i2 = i4;
                        z = true;
                    }
                    z3 = z;
                    i3 = i2 + 1;
                }
            } else {
                this.cJo.put(intValue, true);
            }
            i2 = i3;
            z = z3;
            z3 = z;
            i3 = i2 + 1;
        }
        if (z3 && this.cJl != null && Build.VERSION.SDK_INT > 11) {
            ((ActionMode) this.cJl).invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.g
    public void handleDataChanged() {
        int i2 = this.cLC;
        int i3 = this.cKz;
        this.cKz = this.cLC;
        if (this.cJk != 0 && this.mAdapter != null && this.mAdapter.hasStableIds()) {
            anO();
        }
        this.cJw.anU();
        if (i2 > 0) {
            if (this.cLu) {
                this.cLu = false;
                this.cKB = null;
                if (this.cKe == 2) {
                    this.cJq = 3;
                    return;
                }
                if (this.cKe == 1) {
                    if (this.cKs) {
                        this.cKs = false;
                        this.cJq = 3;
                        return;
                    }
                    int childCount = getChildCount();
                    int width = getWidth() - getPaddingRight();
                    View childAt = getChildAt(childCount - 1);
                    int bottom = childAt != null ? childAt.getBottom() : width;
                    if (childCount + this.bxM >= i3 && bottom <= width) {
                        this.cJq = 3;
                        return;
                    }
                    awakenScrollBars();
                }
                switch (this.cLv) {
                    case 1:
                        this.cJq = 5;
                        this.cLr = Math.min(Math.max(0, this.cLr), i2 - 1);
                        return;
                    case 0:
                        if (isInTouchMode()) {
                            this.cJq = 5;
                            this.cLr = Math.min(Math.max(0, this.cLr), i2 - 1);
                            return;
                        }
                        int aog = aog();
                        if (aog >= 0 && C(aog, true) == aog) {
                            this.cLr = aog;
                            if (this.cLt == getWidth()) {
                                this.cJq = 5;
                            } else {
                                this.cJq = 2;
                            }
                            setNextSelectedPositionInt(aog);
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
            } else if (this.cJV >= 0) {
                return;
            }
        }
        this.cJq = this.cJR ? 3 : 1;
        this.csC = -1;
        this.cLB = Long.MIN_VALUE;
        this.cLz = -1;
        this.cLA = Long.MIN_VALUE;
        this.cLu = false;
        this.cKB = null;
        this.cJu = -1;
        aof();
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
        this.cKe = i2;
    }

    public int getTranscriptMode() {
        return this.cKe;
    }

    @Override // android.view.View
    public int getSolidColor() {
        return this.cKf;
    }

    public void setCacheColorHint(int i2) {
        if (i2 != this.cKf) {
            this.cKf = i2;
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                getChildAt(i3).setDrawingCacheBackgroundColor(i2);
            }
            this.cJw.setCacheColorHint(i2);
        }
    }

    @ViewDebug.ExportedProperty(category = "drawing")
    public int getCacheColorHint() {
        return this.cKf;
    }

    private void anP() {
        if (this.cKo != null) {
            this.cKo.finish();
            this.cKp.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aC(int i2, int i3) {
    }

    public void setRecyclerListener(l lVar) {
        this.cJw.cKZ = lVar;
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
        public int cKL;
        public boolean cKM;
        public boolean cKN;
        public int cKO;
        public long cKP;

        public f(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.cKP = -1L;
        }

        public f(int i, int i2, int i3) {
            super(i, i2);
            this.cKP = -1L;
            this.cKL = i3;
        }

        public f(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.cKP = -1L;
        }
    }

    /* loaded from: classes.dex */
    public class k {
        private l cKZ;
        private int cLa;
        private View[] cLb = new View[0];
        private ArrayList<View>[] cLc;
        private int cLd;
        private ArrayList<View> cLe;
        private ArrayList<View> cLf;
        private SparseArrayCompat<View> cLg;

        public k() {
        }

        public void ky(int i) {
            if (i < 1) {
                throw new IllegalArgumentException("Can't have a viewTypeCount < 1");
            }
            ArrayList<View>[] arrayListArr = new ArrayList[i];
            for (int i2 = 0; i2 < i; i2++) {
                arrayListArr[i2] = new ArrayList<>();
            }
            this.cLd = i;
            this.cLe = arrayListArr[0];
            this.cLc = arrayListArr;
        }

        public void anT() {
            if (this.cLd == 1) {
                ArrayList<View> arrayList = this.cLe;
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    arrayList.get(i).forceLayout();
                }
            } else {
                int i2 = this.cLd;
                for (int i3 = 0; i3 < i2; i3++) {
                    ArrayList<View> arrayList2 = this.cLc[i3];
                    int size2 = arrayList2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        arrayList2.get(i4).forceLayout();
                    }
                }
            }
            if (this.cLg != null) {
                int size3 = this.cLg.size();
                for (int i5 = 0; i5 < size3; i5++) {
                    this.cLg.valueAt(i5).forceLayout();
                }
            }
        }

        public boolean kz(int i) {
            return i >= 0;
        }

        public void clear() {
            if (this.cLd == 1) {
                ArrayList<View> arrayList = this.cLe;
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    AbsHListView.this.removeDetachedView(arrayList.remove((size - 1) - i), false);
                }
            } else {
                int i2 = this.cLd;
                for (int i3 = 0; i3 < i2; i3++) {
                    ArrayList<View> arrayList2 = this.cLc[i3];
                    int size2 = arrayList2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        AbsHListView.this.removeDetachedView(arrayList2.remove((size2 - 1) - i4), false);
                    }
                }
            }
            if (this.cLg != null) {
                this.cLg.clear();
            }
        }

        public void aE(int i, int i2) {
            if (this.cLb.length < i) {
                this.cLb = new View[i];
            }
            this.cLa = i2;
            View[] viewArr = this.cLb;
            for (int i3 = 0; i3 < i; i3++) {
                View childAt = AbsHListView.this.getChildAt(i3);
                f fVar = (f) childAt.getLayoutParams();
                if (fVar != null && fVar.cKL != -2) {
                    viewArr[i3] = childAt;
                }
            }
        }

        public View kA(int i) {
            int i2 = i - this.cLa;
            View[] viewArr = this.cLb;
            if (i2 < 0 || i2 >= viewArr.length) {
                return null;
            }
            View view = viewArr[i2];
            viewArr[i2] = null;
            return view;
        }

        View kB(int i) {
            int indexOfKey;
            if (this.cLg != null && (indexOfKey = this.cLg.indexOfKey(i)) >= 0) {
                View valueAt = this.cLg.valueAt(indexOfKey);
                this.cLg.removeAt(indexOfKey);
                return valueAt;
            }
            return null;
        }

        void anU() {
            if (this.cLg != null) {
                this.cLg.clear();
            }
        }

        View kC(int i) {
            if (this.cLd == 1) {
                return AbsHListView.a(this.cLe, i);
            }
            int itemViewType = AbsHListView.this.mAdapter.getItemViewType(i);
            if (itemViewType >= 0 && itemViewType < this.cLc.length) {
                return AbsHListView.a(this.cLc[itemViewType], i);
            }
            return null;
        }

        public void s(View view, int i) {
            f fVar = (f) view.getLayoutParams();
            if (fVar != null) {
                fVar.cKO = i;
                int i2 = fVar.cKL;
                if (!kz(i2)) {
                    if (i2 != -2) {
                        if (this.cLf == null) {
                            this.cLf = new ArrayList<>();
                        }
                        this.cLf.add(view);
                        return;
                    }
                    return;
                }
                view.onStartTemporaryDetach();
                if (this.cLd == 1) {
                    this.cLe.add(view);
                } else {
                    this.cLc[i2].add(view);
                }
                if (Build.VERSION.SDK_INT >= 14) {
                    view.setAccessibilityDelegate(null);
                }
                if (this.cKZ != null) {
                    this.cKZ.onMovedToScrapHeap(view);
                }
            }
        }

        public void anV() {
            if (this.cLf != null) {
                int size = this.cLf.size();
                for (int i = 0; i < size; i++) {
                    AbsHListView.this.removeDetachedView(this.cLf.get(i), false);
                }
                this.cLf.clear();
            }
        }

        public void anW() {
            View[] viewArr = this.cLb;
            boolean z = this.cKZ != null;
            boolean z2 = this.cLd > 1;
            ArrayList<View> arrayList = this.cLe;
            for (int length = viewArr.length - 1; length >= 0; length--) {
                View view = viewArr[length];
                if (view != null) {
                    f fVar = (f) view.getLayoutParams();
                    int i = fVar.cKL;
                    viewArr[length] = null;
                    if (!kz(i)) {
                        if (i != -2) {
                            AbsHListView.this.removeDetachedView(view, false);
                        }
                    } else {
                        if (z2) {
                            arrayList = this.cLc[i];
                        }
                        view.onStartTemporaryDetach();
                        fVar.cKO = this.cLa + length;
                        arrayList.add(view);
                        if (Build.VERSION.SDK_INT >= 14) {
                            view.setAccessibilityDelegate(null);
                        }
                        if (z) {
                            this.cKZ.onMovedToScrapHeap(view);
                        }
                    }
                }
            }
            anX();
        }

        private void anX() {
            int length = this.cLb.length;
            int i = this.cLd;
            ArrayList<View>[] arrayListArr = this.cLc;
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
            if (this.cLg != null) {
                for (int i6 = 0; i6 < this.cLg.size(); i6++) {
                    this.cLg.valueAt(i6);
                }
            }
        }

        void setCacheColorHint(int i) {
            View[] viewArr;
            if (this.cLd == 1) {
                ArrayList<View> arrayList = this.cLe;
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    arrayList.get(i2).setDrawingCacheBackgroundColor(i);
                }
            } else {
                int i3 = this.cLd;
                for (int i4 = 0; i4 < i3; i4++) {
                    ArrayList<View> arrayList2 = this.cLc[i4];
                    int size2 = arrayList2.size();
                    for (int i5 = 0; i5 < size2; i5++) {
                        arrayList2.get(i5).setDrawingCacheBackgroundColor(i);
                    }
                }
            }
            for (View view : this.cLb) {
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
                if (((f) view.getLayoutParams()).cKO == i2) {
                    arrayList.remove(i3);
                    return view;
                }
            }
            return arrayList.remove(size - 1);
        }
        return null;
    }
}
