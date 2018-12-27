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
import com.baidu.tieba.e;
import com.baidu.tieba.horizonalList.widget.AdapterView;
import com.baidu.tieba.horizonalList.widget.ExpandableHListConnector;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ExpandableHListView extends HListView {
    private Drawable eBB;
    private final Rect eBC;
    private int eBD;
    private int eBE;
    private int eBF;
    private int eBG;
    private d eBH;
    private e eBI;
    private c eBJ;
    private b eBK;
    private ExpandableHListConnector eBn;
    private ExpandableListAdapter eBo;
    private int eBp;
    private int eBq;
    private int eBr;
    private int eBs;
    private int eBt;
    private Drawable eBu;
    private Drawable eBv;
    private int mIndicatorLeft;
    private final Rect mTempRect;
    private static final int[] EMPTY_STATE_SET = new int[0];
    private static final int[] eBw = {16842920};
    private static final int[] eBx = {16842921};
    private static final int[] eBy = {16842920, 16842921};
    private static final int[][] eBz = {EMPTY_STATE_SET, eBw, eBx, eBy};
    private static final int[] eBA = {16842918};

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
        void onGroupCollapse(int i);
    }

    /* loaded from: classes.dex */
    public interface e {
        void onGroupExpand(int i);
    }

    public ExpandableHListView(Context context) {
        this(context, null);
    }

    public ExpandableHListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, e.c.hlv_expandableListViewStyle);
    }

    public ExpandableHListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eBC = new Rect();
        this.mTempRect = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.l.ExpandableHListView, i, 0);
        setGroupIndicator(obtainStyledAttributes.getDrawable(e.l.ExpandableHListView_hlv_groupIndicator));
        setChildIndicator(obtainStyledAttributes.getDrawable(e.l.ExpandableHListView_hlv_childIndicator));
        this.mIndicatorLeft = obtainStyledAttributes.getDimensionPixelSize(e.l.ExpandableHListView_hlv_indicatorPaddingLeft, 0);
        this.eBp = obtainStyledAttributes.getDimensionPixelSize(e.l.ExpandableHListView_hlv_indicatorPaddingTop, 0);
        this.eBq = obtainStyledAttributes.getInt(e.l.ExpandableHListView_hlv_indicatorGravity, 0);
        this.eBr = obtainStyledAttributes.getInt(e.l.ExpandableHListView_hlv_childIndicatorGravity, 0);
        this.eBt = obtainStyledAttributes.getDimensionPixelSize(e.l.ExpandableHListView_hlv_childIndicatorPaddingLeft, 0);
        this.eBs = obtainStyledAttributes.getDimensionPixelSize(e.l.ExpandableHListView_hlv_childIndicatorPaddingTop, 0);
        this.eBB = obtainStyledAttributes.getDrawable(e.l.ExpandableHListView_hlv_childDivider);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        aMD();
        aME();
    }

    private void aMD() {
        if (this.eBu != null) {
            this.eBD = this.eBu.getIntrinsicWidth();
            this.eBE = this.eBu.getIntrinsicHeight();
            return;
        }
        this.eBD = 0;
        this.eBE = 0;
    }

    private void aME() {
        if (this.eBv != null) {
            this.eBF = this.eBv.getIntrinsicWidth();
            this.eBG = this.eBv.getIntrinsicHeight();
            return;
        }
        this.eBF = 0;
        this.eBG = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.eBv != null || this.eBu != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.mItemCount - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            Rect rect = this.eBC;
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
                            ExpandableHListConnector.b pe = this.eBn.pe(i4);
                            if (pe.eBh.type != i2) {
                                if (pe.eBh.type == 1) {
                                    rect.top = childAt.getTop() + this.eBs;
                                    rect.bottom = childAt.getBottom() + this.eBs;
                                } else {
                                    rect.top = childAt.getTop() + this.eBp;
                                    rect.bottom = childAt.getBottom() + this.eBp;
                                }
                                i2 = pe.eBh.type;
                            }
                            if (rect.top != rect.bottom) {
                                if (pe.eBh.type == 1) {
                                    rect.left = this.eBt + left;
                                    rect.right = this.eBt + right2;
                                } else {
                                    rect.left = this.mIndicatorLeft + left;
                                    rect.right = this.mIndicatorLeft + right2;
                                }
                                Drawable c2 = c(pe);
                                if (c2 != null) {
                                    if (pe.eBh.type == 1) {
                                        Gravity.apply(this.eBr, this.eBF, this.eBG, rect, this.mTempRect);
                                    } else {
                                        Gravity.apply(this.eBq, this.eBD, this.eBE, rect, this.mTempRect);
                                    }
                                    c2.setBounds(this.mTempRect);
                                    c2.draw(canvas);
                                }
                            }
                            pe.recycle();
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
        if (bVar.eBh.type == 2) {
            Drawable drawable = this.eBu;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            drawable.setState(eBz[(bVar.ayU() ? (char) 1 : (char) 0) | (bVar.eBi == null || bVar.eBi.eBc == bVar.eBi.eBb ? (char) 2 : (char) 0)]);
            return drawable;
        }
        Drawable drawable2 = this.eBv;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(bVar.eBh.eBm == bVar.eBi.eBc ? eBA : EMPTY_STATE_SET);
        }
        return drawable2;
    }

    public void setChildDivider(Drawable drawable) {
        this.eBB = drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tieba.horizonalList.widget.HListView
    public void drawDivider(Canvas canvas, Rect rect, int i) {
        int i2 = this.mFirstPosition + i;
        if (i2 >= 0) {
            ExpandableHListConnector.b pe = this.eBn.pe(ph(i2));
            if (pe.eBh.type == 1 || (pe.ayU() && pe.eBi.eBc != pe.eBi.eBb)) {
                Drawable drawable = this.eBB;
                drawable.setBounds(rect);
                drawable.draw(canvas);
                pe.recycle();
                return;
            }
            pe.recycle();
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
        this.eBo = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.eBn = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.eBn = null;
        }
        super.setAdapter((ListAdapter) this.eBn);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.eBo;
    }

    private boolean isHeaderOrFooterPosition(int i) {
        return i < getHeaderViewsCount() || i >= this.mItemCount - getFooterViewsCount();
    }

    private int ph(int i) {
        return i - getHeaderViewsCount();
    }

    private int pi(int i) {
        return getHeaderViewsCount() + i;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.AdapterView
    public boolean performItemClick(View view, int i, long j) {
        if (isHeaderOrFooterPosition(i)) {
            return super.performItemClick(view, i, j);
        }
        return b(view, ph(i), j);
    }

    boolean b(View view, int i, long j) {
        boolean z;
        ExpandableHListConnector.b pe = this.eBn.pe(i);
        long b2 = b(pe.eBh);
        if (pe.eBh.type == 2) {
            if (this.eBJ != null && this.eBJ.a(this, view, pe.eBh.eBk, b2)) {
                pe.recycle();
                return true;
            }
            if (pe.ayU()) {
                this.eBn.a(pe);
                playSoundEffect(0);
                if (this.eBH != null) {
                    this.eBH.onGroupCollapse(pe.eBh.eBk);
                }
            } else {
                this.eBn.b(pe);
                playSoundEffect(0);
                if (this.eBI != null) {
                    this.eBI.onGroupExpand(pe.eBh.eBk);
                }
                int i2 = pe.eBh.eBk;
                int headerViewsCount = pe.eBh.eBm + getHeaderViewsCount();
                smoothScrollToPosition(this.eBo.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.eBK != null) {
            playSoundEffect(0);
            return this.eBK.a(this, view, pe.eBh.eBk, pe.eBh.eBl, b2);
        } else {
            z = false;
        }
        pe.recycle();
        return z;
    }

    public void setOnGroupCollapseListener(d dVar) {
        this.eBH = dVar;
    }

    public void setOnGroupExpandListener(e eVar) {
        this.eBI = eVar;
    }

    public void setOnGroupClickListener(c cVar) {
        this.eBJ = cVar;
    }

    public void setOnChildClickListener(b bVar) {
        this.eBK = bVar;
    }

    public long getExpandableListPosition(int i) {
        if (isHeaderOrFooterPosition(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b pe = this.eBn.pe(ph(i));
        long aMB = pe.eBh.aMB();
        pe.recycle();
        return aMB;
    }

    public long getSelectedPosition() {
        return getExpandableListPosition(getSelectedItemPosition());
    }

    public long getSelectedId() {
        long selectedPosition = getSelectedPosition();
        if (selectedPosition == 4294967295L) {
            return -1L;
        }
        int packedPositionGroup = getPackedPositionGroup(selectedPosition);
        if (getPackedPositionType(selectedPosition) == 0) {
            return this.eBo.getGroupId(packedPositionGroup);
        }
        return this.eBo.getChildId(packedPositionGroup, getPackedPositionChild(selectedPosition));
    }

    public void setSelectedGroup(int i) {
        com.baidu.tieba.horizonalList.widget.a pg = com.baidu.tieba.horizonalList.widget.a.pg(i);
        ExpandableHListConnector.b a2 = this.eBn.a(pg);
        pg.recycle();
        super.setSelection(pi(a2.eBh.eBm));
        a2.recycle();
    }

    public static int getPackedPositionType(long j) {
        if (j == 4294967295L) {
            return 2;
        }
        return (j & Long.MIN_VALUE) == Long.MIN_VALUE ? 1 : 0;
    }

    public static int getPackedPositionGroup(long j) {
        if (j == 4294967295L) {
            return -1;
        }
        return (int) ((9223372032559808512L & j) >> 32);
    }

    public static int getPackedPositionChild(long j) {
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
        ExpandableHListConnector.b pe = this.eBn.pe(ph(i));
        com.baidu.tieba.horizonalList.widget.a aVar = pe.eBh;
        long b2 = b(aVar);
        long aMB = aVar.aMB();
        pe.recycle();
        return new a(view, aMB, b2);
    }

    private long b(com.baidu.tieba.horizonalList.widget.a aVar) {
        return aVar.type == 1 ? this.eBo.getChildId(aVar.eBk, aVar.eBl) : this.eBo.getGroupId(aVar.eBk);
    }

    public void setChildIndicator(Drawable drawable) {
        this.eBv = drawable;
        aME();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.eBu = drawable;
        aMD();
    }

    /* loaded from: classes.dex */
    public static class a implements ContextMenu.ContextMenuInfo {
        public long id;
        public long packedPosition;
        public View targetView;

        public a(View view, long j, long j2) {
            this.targetView = view;
            this.packedPosition = j;
            this.id = j2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.tieba.horizonalList.widget.ExpandableHListView.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: t */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: pj */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        ArrayList<ExpandableHListConnector.GroupMetadata> eBL;

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.eBL = arrayList;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.eBL = new ArrayList<>();
            parcel.readList(this.eBL, ExpandableHListConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.eBL);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.eBn != null ? this.eBn.aMz() : null);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.eBn != null && savedState.eBL != null) {
            this.eBn.X(savedState.eBL);
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
