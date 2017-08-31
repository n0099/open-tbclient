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
    private static final int[] dgu = {16842920};
    private static final int[] dgv = {16842921};
    private static final int[] dgw = {16842920, 16842921};
    private static final int[][] dgx = {EMPTY_STATE_SET, dgu, dgv, dgw};
    private static final int[] dgy = {16842918};
    private final Rect dgA;
    private int dgB;
    private int dgC;
    private int dgD;
    private int dgE;
    private d dgF;
    private e dgG;
    private c dgH;
    private b dgI;
    private ExpandableHListConnector dgk;
    private ExpandableListAdapter dgl;
    private int dgm;
    private int dgn;
    private int dgo;
    private int dgp;
    private int dgq;
    private int dgr;
    private Drawable dgs;
    private Drawable dgt;
    private Drawable dgz;
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

    private void arD() {
        if (this.dgs != null) {
            this.dgB = this.dgs.getIntrinsicWidth();
            this.dgC = this.dgs.getIntrinsicHeight();
            return;
        }
        this.dgB = 0;
        this.dgC = 0;
    }

    private void arE() {
        if (this.dgt != null) {
            this.dgD = this.dgt.getIntrinsicWidth();
            this.dgE = this.dgt.getIntrinsicHeight();
            return;
        }
        this.dgD = 0;
        this.dgE = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.dgt != null || this.dgs != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.mItemCount - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            Rect rect = this.dgA;
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
                            ExpandableHListConnector.b ly = this.dgk.ly(i4);
                            if (ly.dge.type != i2) {
                                if (ly.dge.type == 1) {
                                    rect.top = childAt.getTop() + this.dgq;
                                    rect.bottom = childAt.getBottom() + this.dgq;
                                } else {
                                    rect.top = childAt.getTop() + this.dgm;
                                    rect.bottom = childAt.getBottom() + this.dgm;
                                }
                                i2 = ly.dge.type;
                            }
                            if (rect.top != rect.bottom) {
                                if (ly.dge.type == 1) {
                                    rect.left = this.dgr + left;
                                    rect.right = this.dgr + right2;
                                } else {
                                    rect.left = this.dgn + left;
                                    rect.right = this.dgn + right2;
                                }
                                Drawable c2 = c(ly);
                                if (c2 != null) {
                                    if (ly.dge.type == 1) {
                                        Gravity.apply(this.dgp, this.dgD, this.dgE, rect, this.mTempRect);
                                    } else {
                                        Gravity.apply(this.dgo, this.dgB, this.dgC, rect, this.mTempRect);
                                    }
                                    c2.setBounds(this.mTempRect);
                                    c2.draw(canvas);
                                }
                            }
                            ly.recycle();
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
        if (bVar.dge.type == 2) {
            Drawable drawable = this.dgs;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            drawable.setState(dgx[(bVar.arA() ? (char) 1 : (char) 0) | (bVar.dgf == null || bVar.dgf.dfZ == bVar.dgf.dfY ? (char) 2 : (char) 0)]);
            return drawable;
        }
        Drawable drawable2 = this.dgt;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(bVar.dge.dgj == bVar.dgf.dfZ ? dgy : EMPTY_STATE_SET);
        }
        return drawable2;
    }

    public void setChildDivider(Drawable drawable) {
        this.dgz = drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tieba.horizonalList.widget.HListView
    public void drawDivider(Canvas canvas, Rect rect, int i) {
        int i2 = this.mFirstPosition + i;
        if (i2 >= 0) {
            ExpandableHListConnector.b ly = this.dgk.ly(lB(i2));
            if (ly.dge.type == 1 || (ly.arA() && ly.dgf.dfZ != ly.dgf.dfY)) {
                Drawable drawable = this.dgz;
                drawable.setBounds(rect);
                drawable.draw(canvas);
                ly.recycle();
                return;
            }
            ly.recycle();
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
        this.dgl = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.dgk = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.dgk = null;
        }
        super.setAdapter((ListAdapter) this.dgk);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.dgl;
    }

    private boolean isHeaderOrFooterPosition(int i) {
        return i < getHeaderViewsCount() || i >= this.mItemCount - getFooterViewsCount();
    }

    private int lB(int i) {
        return i - getHeaderViewsCount();
    }

    private int lC(int i) {
        return getHeaderViewsCount() + i;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.a
    public boolean performItemClick(View view, int i, long j) {
        if (isHeaderOrFooterPosition(i)) {
            return super.performItemClick(view, i, j);
        }
        return c(view, lB(i), j);
    }

    boolean c(View view, int i, long j) {
        boolean z;
        ExpandableHListConnector.b ly = this.dgk.ly(i);
        long b2 = b(ly.dge);
        if (ly.dge.type == 2) {
            if (this.dgH != null && this.dgH.a(this, view, ly.dge.dgh, b2)) {
                ly.recycle();
                return true;
            }
            if (ly.arA()) {
                this.dgk.a(ly);
                playSoundEffect(0);
                if (this.dgF != null) {
                    this.dgF.onGroupCollapse(ly.dge.dgh);
                }
            } else {
                this.dgk.b(ly);
                playSoundEffect(0);
                if (this.dgG != null) {
                    this.dgG.onGroupExpand(ly.dge.dgh);
                }
                int i2 = ly.dge.dgh;
                int headerViewsCount = ly.dge.dgj + getHeaderViewsCount();
                smoothScrollToPosition(this.dgl.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.dgI != null) {
            playSoundEffect(0);
            return this.dgI.a(this, view, ly.dge.dgh, ly.dge.dgi, b2);
        } else {
            z = false;
        }
        ly.recycle();
        return z;
    }

    public void setOnGroupCollapseListener(d dVar) {
        this.dgF = dVar;
    }

    public void setOnGroupExpandListener(e eVar) {
        this.dgG = eVar;
    }

    public void setOnGroupClickListener(c cVar) {
        this.dgH = cVar;
    }

    public void setOnChildClickListener(b bVar) {
        this.dgI = bVar;
    }

    public long getExpandableListPosition(int i) {
        if (isHeaderOrFooterPosition(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b ly = this.dgk.ly(lB(i));
        long arB = ly.dge.arB();
        ly.recycle();
        return arB;
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
            return this.dgl.getGroupId(packedPositionGroup);
        }
        return this.dgl.getChildId(packedPositionGroup, getPackedPositionChild(selectedPosition));
    }

    public void setSelectedGroup(int i) {
        com.baidu.tieba.horizonalList.widget.b lA = com.baidu.tieba.horizonalList.widget.b.lA(i);
        ExpandableHListConnector.b a2 = this.dgk.a(lA);
        lA.recycle();
        super.setSelection(lC(a2.dge.dgj));
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
            return new a.ContextMenu$ContextMenuInfoC0092a(view, i, j);
        }
        ExpandableHListConnector.b ly = this.dgk.ly(lB(i));
        com.baidu.tieba.horizonalList.widget.b bVar = ly.dge;
        long b2 = b(bVar);
        long arB = bVar.arB();
        ly.recycle();
        return new a(view, arB, b2);
    }

    private long b(com.baidu.tieba.horizonalList.widget.b bVar) {
        return bVar.type == 1 ? this.dgl.getChildId(bVar.dgh, bVar.dgi) : this.dgl.getGroupId(bVar.dgh);
    }

    public void setChildIndicator(Drawable drawable) {
        this.dgt = drawable;
        arE();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.dgs = drawable;
        arD();
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
            /* renamed from: lD */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        ArrayList<ExpandableHListConnector.GroupMetadata> dgJ;

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.dgJ = arrayList;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.dgJ = new ArrayList<>();
            parcel.readList(this.dgJ, ExpandableHListConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.dgJ);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.dgk != null ? this.dgk.ary() : null);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.dgk != null && savedState.dgJ != null) {
            this.dgk.S(savedState.dgJ);
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
