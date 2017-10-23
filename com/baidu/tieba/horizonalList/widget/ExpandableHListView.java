package com.baidu.tieba.horizonalList.widget;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ExpandableListAdapter;
import android.widget.ListAdapter;
import com.baidu.tieba.horizonalList.widget.ExpandableHListConnector;
import com.baidu.tieba.horizonalList.widget.a;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ExpandableHListView extends HListView {
    private static final int[] EMPTY_STATE_SET = new int[0];
    private static final int[] ddo = {16842920};
    private static final int[] ddp = {16842921};
    private static final int[] ddq = {16842920, 16842921};
    private static final int[][] ddr = {EMPTY_STATE_SET, ddo, ddp, ddq};
    private static final int[] dds = {16842918};
    private d ddA;
    private e ddB;
    private c ddC;
    private b ddD;
    private ExpandableHListConnector dde;
    private ExpandableListAdapter ddf;
    private int ddg;
    private int ddh;
    private int ddi;
    private int ddj;
    private int ddk;
    private int ddl;
    private Drawable ddm;
    private Drawable ddn;
    private Drawable ddt;
    private final Rect ddv;
    private int ddw;
    private int ddx;
    private int ddy;
    private int ddz;
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
        void onGroupCollapse(int i);
    }

    /* loaded from: classes.dex */
    public interface e {
        void onGroupExpand(int i);
    }

    private void aqp() {
        if (this.ddm != null) {
            this.ddw = this.ddm.getIntrinsicWidth();
            this.ddx = this.ddm.getIntrinsicHeight();
            return;
        }
        this.ddw = 0;
        this.ddx = 0;
    }

    private void aqq() {
        if (this.ddn != null) {
            this.ddy = this.ddn.getIntrinsicWidth();
            this.ddz = this.ddn.getIntrinsicHeight();
            return;
        }
        this.ddy = 0;
        this.ddz = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.ddn != null || this.ddm != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.mItemCount - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            Rect rect = this.ddv;
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
                            ExpandableHListConnector.b lu = this.dde.lu(i4);
                            if (lu.dcY.type != i2) {
                                if (lu.dcY.type == 1) {
                                    rect.top = childAt.getTop() + this.ddk;
                                    rect.bottom = childAt.getBottom() + this.ddk;
                                } else {
                                    rect.top = childAt.getTop() + this.ddg;
                                    rect.bottom = childAt.getBottom() + this.ddg;
                                }
                                i2 = lu.dcY.type;
                            }
                            if (rect.top != rect.bottom) {
                                if (lu.dcY.type == 1) {
                                    rect.left = this.ddl + left;
                                    rect.right = this.ddl + right2;
                                } else {
                                    rect.left = this.ddh + left;
                                    rect.right = this.ddh + right2;
                                }
                                Drawable c2 = c(lu);
                                if (c2 != null) {
                                    if (lu.dcY.type == 1) {
                                        Gravity.apply(this.ddj, this.ddy, this.ddz, rect, this.mTempRect);
                                    } else {
                                        Gravity.apply(this.ddi, this.ddw, this.ddx, rect, this.mTempRect);
                                    }
                                    c2.setBounds(this.mTempRect);
                                    c2.draw(canvas);
                                }
                            }
                            lu.recycle();
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
        if (bVar.dcY.type == 2) {
            Drawable drawable = this.ddm;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            drawable.setState(ddr[(bVar.aqm() ? (char) 1 : (char) 0) | (bVar.dcZ == null || bVar.dcZ.dcT == bVar.dcZ.dcS ? (char) 2 : (char) 0)]);
            return drawable;
        }
        Drawable drawable2 = this.ddn;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(bVar.dcY.ddd == bVar.dcZ.dcT ? dds : EMPTY_STATE_SET);
        }
        return drawable2;
    }

    public void setChildDivider(Drawable drawable) {
        this.ddt = drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tieba.horizonalList.widget.HListView
    public void drawDivider(Canvas canvas, Rect rect, int i) {
        int i2 = this.mFirstPosition + i;
        if (i2 >= 0) {
            ExpandableHListConnector.b lu = this.dde.lu(lx(i2));
            if (lu.dcY.type == 1 || (lu.aqm() && lu.dcZ.dcT != lu.dcZ.dcS)) {
                Drawable drawable = this.ddt;
                drawable.setBounds(rect);
                drawable.draw(canvas);
                lu.recycle();
                return;
            }
            lu.recycle();
        }
        super.drawDivider(canvas, rect, i2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.a
    public void setAdapter(ListAdapter listAdapter) {
        throw new RuntimeException("For ExpandableListView, use setAdapter(ExpandableListAdapter) instead of setAdapter(ListAdapter)");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.a
    public ListAdapter getAdapter() {
        return super.getAdapter();
    }

    @Override // com.baidu.tieba.horizonalList.widget.a
    public void setOnItemClickListener(a.c cVar) {
        super.setOnItemClickListener(cVar);
    }

    public void setAdapter(ExpandableListAdapter expandableListAdapter) {
        this.ddf = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.dde = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.dde = null;
        }
        super.setAdapter((ListAdapter) this.dde);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.ddf;
    }

    private boolean isHeaderOrFooterPosition(int i) {
        return i < getHeaderViewsCount() || i >= this.mItemCount - getFooterViewsCount();
    }

    private int lx(int i) {
        return i - getHeaderViewsCount();
    }

    private int ly(int i) {
        return getHeaderViewsCount() + i;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.a
    public boolean performItemClick(View view, int i, long j) {
        if (isHeaderOrFooterPosition(i)) {
            return super.performItemClick(view, i, j);
        }
        return c(view, lx(i), j);
    }

    boolean c(View view, int i, long j) {
        boolean z;
        ExpandableHListConnector.b lu = this.dde.lu(i);
        long b2 = b(lu.dcY);
        if (lu.dcY.type == 2) {
            if (this.ddC != null && this.ddC.a(this, view, lu.dcY.ddb, b2)) {
                lu.recycle();
                return true;
            }
            if (lu.aqm()) {
                this.dde.a(lu);
                playSoundEffect(0);
                if (this.ddA != null) {
                    this.ddA.onGroupCollapse(lu.dcY.ddb);
                }
            } else {
                this.dde.b(lu);
                playSoundEffect(0);
                if (this.ddB != null) {
                    this.ddB.onGroupExpand(lu.dcY.ddb);
                }
                int i2 = lu.dcY.ddb;
                int headerViewsCount = lu.dcY.ddd + getHeaderViewsCount();
                smoothScrollToPosition(this.ddf.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.ddD != null) {
            playSoundEffect(0);
            return this.ddD.a(this, view, lu.dcY.ddb, lu.dcY.ddc, b2);
        } else {
            z = false;
        }
        lu.recycle();
        return z;
    }

    public void setOnGroupCollapseListener(d dVar) {
        this.ddA = dVar;
    }

    public void setOnGroupExpandListener(e eVar) {
        this.ddB = eVar;
    }

    public void setOnGroupClickListener(c cVar) {
        this.ddC = cVar;
    }

    public void setOnChildClickListener(b bVar) {
        this.ddD = bVar;
    }

    public long getExpandableListPosition(int i) {
        if (isHeaderOrFooterPosition(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b lu = this.dde.lu(lx(i));
        long aqn = lu.dcY.aqn();
        lu.recycle();
        return aqn;
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
            return this.ddf.getGroupId(packedPositionGroup);
        }
        return this.ddf.getChildId(packedPositionGroup, getPackedPositionChild(selectedPosition));
    }

    public void setSelectedGroup(int i) {
        com.baidu.tieba.horizonalList.widget.b lw = com.baidu.tieba.horizonalList.widget.b.lw(i);
        ExpandableHListConnector.b a2 = this.dde.a(lw);
        lw.recycle();
        super.setSelection(ly(a2.dcY.ddd));
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
            return new a.ContextMenu$ContextMenuInfoC0091a(view, i, j);
        }
        ExpandableHListConnector.b lu = this.dde.lu(lx(i));
        com.baidu.tieba.horizonalList.widget.b bVar = lu.dcY;
        long b2 = b(bVar);
        long aqn = bVar.aqn();
        lu.recycle();
        return new a(view, aqn, b2);
    }

    private long b(com.baidu.tieba.horizonalList.widget.b bVar) {
        return bVar.type == 1 ? this.ddf.getChildId(bVar.ddb, bVar.ddc) : this.ddf.getGroupId(bVar.ddb);
    }

    public void setChildIndicator(Drawable drawable) {
        this.ddn = drawable;
        aqq();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.ddm = drawable;
        aqp();
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
            /* renamed from: o */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: lz */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        ArrayList<ExpandableHListConnector.GroupMetadata> ddE;

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.ddE = arrayList;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.ddE = new ArrayList<>();
            parcel.readList(this.ddE, ExpandableHListConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.ddE);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.dde != null ? this.dde.aqk() : null);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.dde != null && savedState.ddE != null) {
            this.dde.Q(savedState.ddE);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.a, android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(ExpandableHListView.class.getName());
    }

    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.a, android.view.View
    @TargetApi(14)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(ExpandableHListView.class.getName());
    }
}
