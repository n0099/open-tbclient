package com.baidu.tieba.horizonalList.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ExpandableListAdapter;
import android.widget.ListAdapter;
import com.baidu.tieba.R;
import com.baidu.tieba.horizonalList.widget.AdapterView;
import com.baidu.tieba.horizonalList.widget.ExpandableHListConnector;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ExpandableHListView extends HListView {
    private static final int[] EMPTY_STATE_SET = new int[0];
    private static final int[] bBu = {16842920};
    private static final int[] bBv = {16842921};
    private static final int[] bBw = {16842920, 16842921};
    private static final int[][] bBx = {EMPTY_STATE_SET, bBu, bBv, bBw};
    private static final int[] bBy = {16842918};
    private final Rect bBA;
    private int bBB;
    private int bBC;
    private int bBD;
    private int bBE;
    private ExpandableListAdapter bBm;
    private int bBn;
    private int bBo;
    private int bBp;
    private int bBq;
    private int bBr;
    private Drawable bBs;
    private Drawable bBt;
    private Drawable bBz;
    private ExpandableHListConnector jMV;
    private d jMW;
    private e jMX;
    private c jMY;
    private b jMZ;
    private int mIndicatorLeft;
    private final Rect mTempRect;

    /* loaded from: classes.dex */
    public interface b {
        boolean a(ExpandableHListView expandableHListView, View view, int i, int i2, long j);
    }

    /* loaded from: classes.dex */
    public interface c {
        boolean a(ExpandableHListView expandableHListView, View view, int i, long j);
    }

    /* loaded from: classes.dex */
    public interface d {
        void fL(int i);
    }

    /* loaded from: classes.dex */
    public interface e {
        void fM(int i);
    }

    public ExpandableHListView(Context context) {
        this(context, null);
    }

    public ExpandableHListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.hlv_expandableListViewStyle);
    }

    public ExpandableHListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bBA = new Rect();
        this.mTempRect = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandableHListView, i, 0);
        setGroupIndicator(obtainStyledAttributes.getDrawable(R.styleable.ExpandableHListView_hlv_groupIndicator));
        setChildIndicator(obtainStyledAttributes.getDrawable(R.styleable.ExpandableHListView_hlv_childIndicator));
        this.mIndicatorLeft = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandableHListView_hlv_indicatorPaddingLeft, 0);
        this.bBn = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandableHListView_hlv_indicatorPaddingTop, 0);
        this.bBo = obtainStyledAttributes.getInt(R.styleable.ExpandableHListView_hlv_indicatorGravity, 0);
        this.bBp = obtainStyledAttributes.getInt(R.styleable.ExpandableHListView_hlv_childIndicatorGravity, 0);
        this.bBr = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandableHListView_hlv_childIndicatorPaddingLeft, 0);
        this.bBq = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandableHListView_hlv_childIndicatorPaddingTop, 0);
        this.bBz = obtainStyledAttributes.getDrawable(R.styleable.ExpandableHListView_hlv_childDivider);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        Tk();
        Tl();
    }

    private void Tk() {
        if (this.bBs != null) {
            this.bBB = this.bBs.getIntrinsicWidth();
            this.bBC = this.bBs.getIntrinsicHeight();
            return;
        }
        this.bBB = 0;
        this.bBC = 0;
    }

    private void Tl() {
        if (this.bBt != null) {
            this.bBD = this.bBt.getIntrinsicWidth();
            this.bBE = this.bBt.getIntrinsicHeight();
            return;
        }
        this.bBD = 0;
        this.bBE = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.bBt != null || this.bBs != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.mItemCount - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            Rect rect = this.bBA;
            int childCount = getChildCount();
            int i = this.mFirstPosition - headerViewsCount;
            int i2 = -4;
            int i3 = 0;
            int i4 = i;
            while (i3 < childCount) {
                if (i4 >= 0) {
                    if (i4 <= footerViewsCount) {
                        View childAt = getChildAt(i3);
                        int left = childAt.getLeft();
                        int right2 = childAt.getRight();
                        if (right2 >= 0 && left <= right) {
                            ExpandableHListConnector.b BU = this.jMV.BU(i4);
                            if (BU.jMT.type != i2) {
                                if (BU.jMT.type == 1) {
                                    rect.top = childAt.getTop() + this.bBq;
                                    rect.bottom = childAt.getBottom() + this.bBq;
                                } else {
                                    rect.top = childAt.getTop() + this.bBn;
                                    rect.bottom = childAt.getBottom() + this.bBn;
                                }
                                i2 = BU.jMT.type;
                            }
                            if (rect.top != rect.bottom) {
                                if (BU.jMT.type == 1) {
                                    rect.left = this.bBr + left;
                                    rect.right = this.bBr + right2;
                                } else {
                                    rect.left = this.mIndicatorLeft + left;
                                    rect.right = this.mIndicatorLeft + right2;
                                }
                                Drawable c2 = c(BU);
                                if (c2 != null) {
                                    if (BU.jMT.type == 1) {
                                        Gravity.apply(this.bBp, this.bBD, this.bBE, rect, this.mTempRect);
                                    } else {
                                        Gravity.apply(this.bBo, this.bBB, this.bBC, rect, this.mTempRect);
                                    }
                                    c2.setBounds(this.mTempRect);
                                    c2.draw(canvas);
                                }
                            }
                            BU.recycle();
                        }
                    } else {
                        return;
                    }
                }
                i3++;
                i4++;
            }
        }
    }

    private Drawable c(ExpandableHListConnector.b bVar) {
        if (bVar.jMT.type == 2) {
            Drawable drawable = this.bBs;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            drawable.setState(bBx[(bVar.Th() ? (char) 1 : (char) 0) | (bVar.jMU == null || bVar.jMU.bBa == bVar.jMU.bAZ ? (char) 2 : (char) 0)]);
            return drawable;
        }
        Drawable drawable2 = this.bBt;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(bVar.jMT.bBk == bVar.jMU.bBa ? bBy : EMPTY_STATE_SET);
        }
        return drawable2;
    }

    public void setChildDivider(Drawable drawable) {
        this.bBz = drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tieba.horizonalList.widget.HListView
    public void drawDivider(Canvas canvas, Rect rect, int i) {
        int i2 = this.mFirstPosition + i;
        if (i2 >= 0) {
            ExpandableHListConnector.b BU = this.jMV.BU(fI(i2));
            if (BU.jMT.type == 1 || (BU.Th() && BU.jMU.bBa != BU.jMU.bAZ)) {
                Drawable drawable = this.bBz;
                drawable.setBounds(rect);
                drawable.draw(canvas);
                BU.recycle();
                return;
            }
            BU.recycle();
        }
        super.drawDivider(canvas, rect, i2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        throw new RuntimeException("For ExpandableListView, use setAdapter(ExpandableListAdapter) instead of setAdapter(ListAdapter)");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AdapterView
    public ListAdapter getAdapter() {
        return super.getAdapter();
    }

    @Override // com.baidu.tieba.horizonalList.widget.AdapterView
    public void setOnItemClickListener(AdapterView.c cVar) {
        super.setOnItemClickListener(cVar);
    }

    public void setAdapter(ExpandableListAdapter expandableListAdapter) {
        this.bBm = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.jMV = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.jMV = null;
        }
        super.setAdapter((ListAdapter) this.jMV);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.bBm;
    }

    private boolean isHeaderOrFooterPosition(int i) {
        return i < getHeaderViewsCount() || i >= this.mItemCount - getFooterViewsCount();
    }

    private int fI(int i) {
        return i - getHeaderViewsCount();
    }

    private int fJ(int i) {
        return getHeaderViewsCount() + i;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.AdapterView
    public boolean performItemClick(View view, int i, long j) {
        if (isHeaderOrFooterPosition(i)) {
            return super.performItemClick(view, i, j);
        }
        return b(view, fI(i), j);
    }

    boolean b(View view, int i, long j) {
        boolean z;
        ExpandableHListConnector.b BU = this.jMV.BU(i);
        long b2 = b(BU.jMT);
        if (BU.jMT.type == 2) {
            if (this.jMY != null && this.jMY.a(this, view, BU.jMT.bBi, b2)) {
                BU.recycle();
                return true;
            }
            if (BU.Th()) {
                this.jMV.a(BU);
                playSoundEffect(0);
                if (this.jMW != null) {
                    this.jMW.fL(BU.jMT.bBi);
                }
            } else {
                this.jMV.b(BU);
                playSoundEffect(0);
                if (this.jMX != null) {
                    this.jMX.fM(BU.jMT.bBi);
                }
                int i2 = BU.jMT.bBi;
                int headerViewsCount = BU.jMT.bBk + getHeaderViewsCount();
                smoothScrollToPosition(this.bBm.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.jMZ != null) {
            playSoundEffect(0);
            return this.jMZ.a(this, view, BU.jMT.bBi, BU.jMT.bBj, b2);
        } else {
            z = false;
        }
        BU.recycle();
        return z;
    }

    public void setOnGroupCollapseListener(d dVar) {
        this.jMW = dVar;
    }

    public void setOnGroupExpandListener(e eVar) {
        this.jMX = eVar;
    }

    public void setOnGroupClickListener(c cVar) {
        this.jMY = cVar;
    }

    public void setOnChildClickListener(b bVar) {
        this.jMZ = bVar;
    }

    public long fK(int i) {
        if (isHeaderOrFooterPosition(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b BU = this.jMV.BU(fI(i));
        long Ti = BU.jMT.Ti();
        BU.recycle();
        return Ti;
    }

    public long getSelectedPosition() {
        return fK(getSelectedItemPosition());
    }

    public long getSelectedId() {
        long selectedPosition = getSelectedPosition();
        if (selectedPosition == 4294967295L) {
            return -1L;
        }
        int aS = aS(selectedPosition);
        if (aR(selectedPosition) == 0) {
            return this.bBm.getGroupId(aS);
        }
        return this.bBm.getChildId(aS, aT(selectedPosition));
    }

    public void setSelectedGroup(int i) {
        com.baidu.tieba.horizonalList.widget.a BW = com.baidu.tieba.horizonalList.widget.a.BW(i);
        ExpandableHListConnector.b a2 = this.jMV.a(BW);
        BW.recycle();
        super.setSelection(fJ(a2.jMT.bBk));
        a2.recycle();
    }

    public static int aR(long j) {
        if (j == 4294967295L) {
            return 2;
        }
        return (j & Long.MIN_VALUE) == Long.MIN_VALUE ? 1 : 0;
    }

    public static int aS(long j) {
        if (j == 4294967295L) {
            return -1;
        }
        return (int) ((9223372032559808512L & j) >> 32);
    }

    public static int aT(long j) {
        if (j != 4294967295L && (j & Long.MIN_VALUE) == Long.MIN_VALUE) {
            return (int) (j & 4294967295L);
        }
        return -1;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView
    ContextMenu.ContextMenuInfo createContextMenuInfo(View view, int i, long j) {
        if (isHeaderOrFooterPosition(i)) {
            return new AdapterView.a(view, i, j);
        }
        ExpandableHListConnector.b BU = this.jMV.BU(fI(i));
        com.baidu.tieba.horizonalList.widget.a aVar = BU.jMT;
        long b2 = b(aVar);
        long Ti = aVar.Ti();
        BU.recycle();
        return new a(view, Ti, b2);
    }

    private long b(com.baidu.tieba.horizonalList.widget.a aVar) {
        return aVar.type == 1 ? this.bBm.getChildId(aVar.bBi, aVar.bBj) : this.bBm.getGroupId(aVar.bBi);
    }

    public void setChildIndicator(Drawable drawable) {
        this.bBt = drawable;
        Tl();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.bBs = drawable;
        Tk();
    }

    /* loaded from: classes.dex */
    public static class a implements ContextMenu.ContextMenuInfo {
        public long bBJ;
        public long id;
        public View targetView;

        public a(View view, long j, long j2) {
            this.targetView = view;
            this.bBJ = j;
            this.id = j2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.tieba.horizonalList.widget.ExpandableHListView.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: ac */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: BX */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        ArrayList<ExpandableHListConnector.GroupMetadata> bBK;

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.bBK = arrayList;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.bBK = new ArrayList<>();
            parcel.readList(this.bBK, ExpandableHListConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.bBK);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.jMV != null ? this.jMV.Tf() : null);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.jMV != null && savedState.bBK != null) {
            this.jMV.p(savedState.bBK);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.AdapterView, android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(ExpandableHListView.class.getName());
    }

    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.AdapterView, android.view.View
    @TargetApi(14)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(ExpandableHListView.class.getName());
    }
}
