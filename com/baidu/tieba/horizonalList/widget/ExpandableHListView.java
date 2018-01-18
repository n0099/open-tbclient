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
    private static final int[] ehU = {16842920};
    private static final int[] ehV = {16842921};
    private static final int[] ehW = {16842920, 16842921};
    private static final int[][] ehX = {EMPTY_STATE_SET, ehU, ehV, ehW};
    private static final int[] ehY = {16842918};
    private ExpandableHListConnector ehL;
    private ExpandableListAdapter ehM;
    private int ehN;
    private int ehO;
    private int ehP;
    private int ehQ;
    private int ehR;
    private Drawable ehS;
    private Drawable ehT;
    private Drawable ehZ;
    private final Rect eia;
    private int eib;
    private int eic;
    private int eid;
    private int eie;
    private d eif;
    private e eig;
    private c eih;
    private b eii;
    private final Rect mTempRect;
    private int ri;

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

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        aBW();
        aBX();
    }

    private void aBW() {
        if (this.ehS != null) {
            this.eib = this.ehS.getIntrinsicWidth();
            this.eic = this.ehS.getIntrinsicHeight();
            return;
        }
        this.eib = 0;
        this.eic = 0;
    }

    private void aBX() {
        if (this.ehT != null) {
            this.eid = this.ehT.getIntrinsicWidth();
            this.eie = this.ehT.getIntrinsicHeight();
            return;
        }
        this.eid = 0;
        this.eie = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.ehT != null || this.ehS != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.mItemCount - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            Rect rect = this.eia;
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
                            ExpandableHListConnector.b oX = this.ehL.oX(i4);
                            if (oX.ehF.type != i2) {
                                if (oX.ehF.type == 1) {
                                    rect.top = childAt.getTop() + this.ehQ;
                                    rect.bottom = childAt.getBottom() + this.ehQ;
                                } else {
                                    rect.top = childAt.getTop() + this.ehN;
                                    rect.bottom = childAt.getBottom() + this.ehN;
                                }
                                i2 = oX.ehF.type;
                            }
                            if (rect.top != rect.bottom) {
                                if (oX.ehF.type == 1) {
                                    rect.left = this.ehR + left;
                                    rect.right = this.ehR + right2;
                                } else {
                                    rect.left = this.ri + left;
                                    rect.right = this.ri + right2;
                                }
                                Drawable c2 = c(oX);
                                if (c2 != null) {
                                    if (oX.ehF.type == 1) {
                                        Gravity.apply(this.ehP, this.eid, this.eie, rect, this.mTempRect);
                                    } else {
                                        Gravity.apply(this.ehO, this.eib, this.eic, rect, this.mTempRect);
                                    }
                                    c2.setBounds(this.mTempRect);
                                    c2.draw(canvas);
                                }
                            }
                            oX.recycle();
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
        if (bVar.ehF.type == 2) {
            Drawable drawable = this.ehS;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            drawable.setState(ehX[(bVar.asC() ? (char) 1 : (char) 0) | (bVar.ehG == null || bVar.ehG.ehA == bVar.ehG.ehz ? (char) 2 : (char) 0)]);
            return drawable;
        }
        Drawable drawable2 = this.ehT;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(bVar.ehF.ehK == bVar.ehG.ehA ? ehY : EMPTY_STATE_SET);
        }
        return drawable2;
    }

    public void setChildDivider(Drawable drawable) {
        this.ehZ = drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tieba.horizonalList.widget.HListView
    public void drawDivider(Canvas canvas, Rect rect, int i) {
        int i2 = this.mFirstPosition + i;
        if (i2 >= 0) {
            ExpandableHListConnector.b oX = this.ehL.oX(pa(i2));
            if (oX.ehF.type == 1 || (oX.asC() && oX.ehG.ehA != oX.ehG.ehz)) {
                Drawable drawable = this.ehZ;
                drawable.setBounds(rect);
                drawable.draw(canvas);
                oX.recycle();
                return;
            }
            oX.recycle();
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
        this.ehM = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.ehL = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.ehL = null;
        }
        super.setAdapter((ListAdapter) this.ehL);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.ehM;
    }

    private boolean isHeaderOrFooterPosition(int i) {
        return i < getHeaderViewsCount() || i >= this.mItemCount - getFooterViewsCount();
    }

    private int pa(int i) {
        return i - getHeaderViewsCount();
    }

    private int pb(int i) {
        return getHeaderViewsCount() + i;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.a
    public boolean performItemClick(View view, int i, long j) {
        if (isHeaderOrFooterPosition(i)) {
            return super.performItemClick(view, i, j);
        }
        return b(view, pa(i), j);
    }

    boolean b(View view, int i, long j) {
        boolean z;
        ExpandableHListConnector.b oX = this.ehL.oX(i);
        long b2 = b(oX.ehF);
        if (oX.ehF.type == 2) {
            if (this.eih != null && this.eih.a(this, view, oX.ehF.ehI, b2)) {
                oX.recycle();
                return true;
            }
            if (oX.asC()) {
                this.ehL.a(oX);
                playSoundEffect(0);
                if (this.eif != null) {
                    this.eif.onGroupCollapse(oX.ehF.ehI);
                }
            } else {
                this.ehL.b(oX);
                playSoundEffect(0);
                if (this.eig != null) {
                    this.eig.onGroupExpand(oX.ehF.ehI);
                }
                int i2 = oX.ehF.ehI;
                int headerViewsCount = oX.ehF.ehK + getHeaderViewsCount();
                smoothScrollToPosition(this.ehM.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.eii != null) {
            playSoundEffect(0);
            return this.eii.a(this, view, oX.ehF.ehI, oX.ehF.ehJ, b2);
        } else {
            z = false;
        }
        oX.recycle();
        return z;
    }

    public void setOnGroupCollapseListener(d dVar) {
        this.eif = dVar;
    }

    public void setOnGroupExpandListener(e eVar) {
        this.eig = eVar;
    }

    public void setOnGroupClickListener(c cVar) {
        this.eih = cVar;
    }

    public void setOnChildClickListener(b bVar) {
        this.eii = bVar;
    }

    public long getExpandableListPosition(int i) {
        if (isHeaderOrFooterPosition(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b oX = this.ehL.oX(pa(i));
        long aBU = oX.ehF.aBU();
        oX.recycle();
        return aBU;
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
            return this.ehM.getGroupId(packedPositionGroup);
        }
        return this.ehM.getChildId(packedPositionGroup, getPackedPositionChild(selectedPosition));
    }

    public void setSelectedGroup(int i) {
        com.baidu.tieba.horizonalList.widget.b oZ = com.baidu.tieba.horizonalList.widget.b.oZ(i);
        ExpandableHListConnector.b a2 = this.ehL.a(oZ);
        oZ.recycle();
        super.setSelection(pb(a2.ehF.ehK));
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
            return new a.ContextMenu$ContextMenuInfoC0116a(view, i, j);
        }
        ExpandableHListConnector.b oX = this.ehL.oX(pa(i));
        com.baidu.tieba.horizonalList.widget.b bVar = oX.ehF;
        long b2 = b(bVar);
        long aBU = bVar.aBU();
        oX.recycle();
        return new a(view, aBU, b2);
    }

    private long b(com.baidu.tieba.horizonalList.widget.b bVar) {
        return bVar.type == 1 ? this.ehM.getChildId(bVar.ehI, bVar.ehJ) : this.ehM.getGroupId(bVar.ehI);
    }

    public void setChildIndicator(Drawable drawable) {
        this.ehT = drawable;
        aBX();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.ehS = drawable;
        aBW();
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
            /* renamed from: E */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: pc */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        ArrayList<ExpandableHListConnector.GroupMetadata> eij;

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.eij = arrayList;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.eij = new ArrayList<>();
            parcel.readList(this.eij, ExpandableHListConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.eij);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.ehL != null ? this.ehL.aBS() : null);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.ehL != null && savedState.eij != null) {
            this.ehL.R(savedState.eij);
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
