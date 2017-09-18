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
    private static final int[] dhp = {16842920};
    private static final int[] dhq = {16842921};
    private static final int[] dhr = {16842920, 16842921};
    private static final int[][] dhs = {EMPTY_STATE_SET, dhp, dhq, dhr};
    private static final int[] dht = {16842918};
    private d dhA;
    private e dhB;
    private c dhC;
    private b dhD;
    private ExpandableHListConnector dhf;
    private ExpandableListAdapter dhg;
    private int dhh;
    private int dhi;
    private int dhj;
    private int dhk;
    private int dhl;
    private int dhm;
    private Drawable dhn;
    private Drawable dho;
    private Drawable dhu;
    private final Rect dhv;
    private int dhw;
    private int dhx;
    private int dhy;
    private int dhz;
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

    private void arO() {
        if (this.dhn != null) {
            this.dhw = this.dhn.getIntrinsicWidth();
            this.dhx = this.dhn.getIntrinsicHeight();
            return;
        }
        this.dhw = 0;
        this.dhx = 0;
    }

    private void arP() {
        if (this.dho != null) {
            this.dhy = this.dho.getIntrinsicWidth();
            this.dhz = this.dho.getIntrinsicHeight();
            return;
        }
        this.dhy = 0;
        this.dhz = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.dho != null || this.dhn != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.mItemCount - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            Rect rect = this.dhv;
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
                            ExpandableHListConnector.b lA = this.dhf.lA(i4);
                            if (lA.dgZ.type != i2) {
                                if (lA.dgZ.type == 1) {
                                    rect.top = childAt.getTop() + this.dhl;
                                    rect.bottom = childAt.getBottom() + this.dhl;
                                } else {
                                    rect.top = childAt.getTop() + this.dhh;
                                    rect.bottom = childAt.getBottom() + this.dhh;
                                }
                                i2 = lA.dgZ.type;
                            }
                            if (rect.top != rect.bottom) {
                                if (lA.dgZ.type == 1) {
                                    rect.left = this.dhm + left;
                                    rect.right = this.dhm + right2;
                                } else {
                                    rect.left = this.dhi + left;
                                    rect.right = this.dhi + right2;
                                }
                                Drawable c2 = c(lA);
                                if (c2 != null) {
                                    if (lA.dgZ.type == 1) {
                                        Gravity.apply(this.dhk, this.dhy, this.dhz, rect, this.mTempRect);
                                    } else {
                                        Gravity.apply(this.dhj, this.dhw, this.dhx, rect, this.mTempRect);
                                    }
                                    c2.setBounds(this.mTempRect);
                                    c2.draw(canvas);
                                }
                            }
                            lA.recycle();
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
        if (bVar.dgZ.type == 2) {
            Drawable drawable = this.dhn;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            drawable.setState(dhs[(bVar.arL() ? (char) 1 : (char) 0) | (bVar.dha == null || bVar.dha.dgU == bVar.dha.dgT ? (char) 2 : (char) 0)]);
            return drawable;
        }
        Drawable drawable2 = this.dho;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(bVar.dgZ.dhe == bVar.dha.dgU ? dht : EMPTY_STATE_SET);
        }
        return drawable2;
    }

    public void setChildDivider(Drawable drawable) {
        this.dhu = drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tieba.horizonalList.widget.HListView
    public void drawDivider(Canvas canvas, Rect rect, int i) {
        int i2 = this.mFirstPosition + i;
        if (i2 >= 0) {
            ExpandableHListConnector.b lA = this.dhf.lA(lD(i2));
            if (lA.dgZ.type == 1 || (lA.arL() && lA.dha.dgU != lA.dha.dgT)) {
                Drawable drawable = this.dhu;
                drawable.setBounds(rect);
                drawable.draw(canvas);
                lA.recycle();
                return;
            }
            lA.recycle();
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
        this.dhg = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.dhf = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.dhf = null;
        }
        super.setAdapter((ListAdapter) this.dhf);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.dhg;
    }

    private boolean isHeaderOrFooterPosition(int i) {
        return i < getHeaderViewsCount() || i >= this.mItemCount - getFooterViewsCount();
    }

    private int lD(int i) {
        return i - getHeaderViewsCount();
    }

    private int lE(int i) {
        return getHeaderViewsCount() + i;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.a
    public boolean performItemClick(View view, int i, long j) {
        if (isHeaderOrFooterPosition(i)) {
            return super.performItemClick(view, i, j);
        }
        return c(view, lD(i), j);
    }

    boolean c(View view, int i, long j) {
        boolean z;
        ExpandableHListConnector.b lA = this.dhf.lA(i);
        long b2 = b(lA.dgZ);
        if (lA.dgZ.type == 2) {
            if (this.dhC != null && this.dhC.a(this, view, lA.dgZ.dhc, b2)) {
                lA.recycle();
                return true;
            }
            if (lA.arL()) {
                this.dhf.a(lA);
                playSoundEffect(0);
                if (this.dhA != null) {
                    this.dhA.onGroupCollapse(lA.dgZ.dhc);
                }
            } else {
                this.dhf.b(lA);
                playSoundEffect(0);
                if (this.dhB != null) {
                    this.dhB.onGroupExpand(lA.dgZ.dhc);
                }
                int i2 = lA.dgZ.dhc;
                int headerViewsCount = lA.dgZ.dhe + getHeaderViewsCount();
                smoothScrollToPosition(this.dhg.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.dhD != null) {
            playSoundEffect(0);
            return this.dhD.a(this, view, lA.dgZ.dhc, lA.dgZ.dhd, b2);
        } else {
            z = false;
        }
        lA.recycle();
        return z;
    }

    public void setOnGroupCollapseListener(d dVar) {
        this.dhA = dVar;
    }

    public void setOnGroupExpandListener(e eVar) {
        this.dhB = eVar;
    }

    public void setOnGroupClickListener(c cVar) {
        this.dhC = cVar;
    }

    public void setOnChildClickListener(b bVar) {
        this.dhD = bVar;
    }

    public long getExpandableListPosition(int i) {
        if (isHeaderOrFooterPosition(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b lA = this.dhf.lA(lD(i));
        long arM = lA.dgZ.arM();
        lA.recycle();
        return arM;
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
            return this.dhg.getGroupId(packedPositionGroup);
        }
        return this.dhg.getChildId(packedPositionGroup, getPackedPositionChild(selectedPosition));
    }

    public void setSelectedGroup(int i) {
        com.baidu.tieba.horizonalList.widget.b lC = com.baidu.tieba.horizonalList.widget.b.lC(i);
        ExpandableHListConnector.b a2 = this.dhf.a(lC);
        lC.recycle();
        super.setSelection(lE(a2.dgZ.dhe));
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
        ExpandableHListConnector.b lA = this.dhf.lA(lD(i));
        com.baidu.tieba.horizonalList.widget.b bVar = lA.dgZ;
        long b2 = b(bVar);
        long arM = bVar.arM();
        lA.recycle();
        return new a(view, arM, b2);
    }

    private long b(com.baidu.tieba.horizonalList.widget.b bVar) {
        return bVar.type == 1 ? this.dhg.getChildId(bVar.dhc, bVar.dhd) : this.dhg.getGroupId(bVar.dhc);
    }

    public void setChildIndicator(Drawable drawable) {
        this.dho = drawable;
        arP();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.dhn = drawable;
        arO();
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
            /* renamed from: lF */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        ArrayList<ExpandableHListConnector.GroupMetadata> dhE;

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.dhE = arrayList;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.dhE = new ArrayList<>();
            parcel.readList(this.dhE, ExpandableHListConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.dhE);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.dhf != null ? this.dhf.arJ() : null);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.dhf != null && savedState.dhE != null) {
            this.dhf.S(savedState.dhE);
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
