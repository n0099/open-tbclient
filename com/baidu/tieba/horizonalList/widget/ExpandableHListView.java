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
    private static final int[] eip = {16842920};
    private static final int[] eiq = {16842921};
    private static final int[] eir = {16842920, 16842921};
    private static final int[][] eis = {EMPTY_STATE_SET, eip, eiq, eir};
    private static final int[] eit = {16842918};
    private d eiA;
    private e eiB;
    private c eiC;
    private b eiD;
    private ExpandableHListConnector eig;
    private ExpandableListAdapter eih;
    private int eii;
    private int eij;
    private int eik;
    private int eil;
    private int eim;
    private Drawable ein;
    private Drawable eio;
    private Drawable eiu;
    private final Rect eiv;
    private int eiw;
    private int eix;
    private int eiy;
    private int eiz;
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
        aCb();
        aCc();
    }

    private void aCb() {
        if (this.ein != null) {
            this.eiw = this.ein.getIntrinsicWidth();
            this.eix = this.ein.getIntrinsicHeight();
            return;
        }
        this.eiw = 0;
        this.eix = 0;
    }

    private void aCc() {
        if (this.eio != null) {
            this.eiy = this.eio.getIntrinsicWidth();
            this.eiz = this.eio.getIntrinsicHeight();
            return;
        }
        this.eiy = 0;
        this.eiz = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.eio != null || this.ein != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.mItemCount - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            Rect rect = this.eiv;
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
                            ExpandableHListConnector.b oX = this.eig.oX(i4);
                            if (oX.eia.type != i2) {
                                if (oX.eia.type == 1) {
                                    rect.top = childAt.getTop() + this.eil;
                                    rect.bottom = childAt.getBottom() + this.eil;
                                } else {
                                    rect.top = childAt.getTop() + this.eii;
                                    rect.bottom = childAt.getBottom() + this.eii;
                                }
                                i2 = oX.eia.type;
                            }
                            if (rect.top != rect.bottom) {
                                if (oX.eia.type == 1) {
                                    rect.left = this.eim + left;
                                    rect.right = this.eim + right2;
                                } else {
                                    rect.left = this.ri + left;
                                    rect.right = this.ri + right2;
                                }
                                Drawable c2 = c(oX);
                                if (c2 != null) {
                                    if (oX.eia.type == 1) {
                                        Gravity.apply(this.eik, this.eiy, this.eiz, rect, this.mTempRect);
                                    } else {
                                        Gravity.apply(this.eij, this.eiw, this.eix, rect, this.mTempRect);
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
        if (bVar.eia.type == 2) {
            Drawable drawable = this.ein;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            drawable.setState(eis[(bVar.asH() ? (char) 1 : (char) 0) | (bVar.eib == null || bVar.eib.ehV == bVar.eib.ehU ? (char) 2 : (char) 0)]);
            return drawable;
        }
        Drawable drawable2 = this.eio;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(bVar.eia.eif == bVar.eib.ehV ? eit : EMPTY_STATE_SET);
        }
        return drawable2;
    }

    public void setChildDivider(Drawable drawable) {
        this.eiu = drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tieba.horizonalList.widget.HListView
    public void drawDivider(Canvas canvas, Rect rect, int i) {
        int i2 = this.mFirstPosition + i;
        if (i2 >= 0) {
            ExpandableHListConnector.b oX = this.eig.oX(pa(i2));
            if (oX.eia.type == 1 || (oX.asH() && oX.eib.ehV != oX.eib.ehU)) {
                Drawable drawable = this.eiu;
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
        this.eih = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.eig = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.eig = null;
        }
        super.setAdapter((ListAdapter) this.eig);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.eih;
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
        ExpandableHListConnector.b oX = this.eig.oX(i);
        long b2 = b(oX.eia);
        if (oX.eia.type == 2) {
            if (this.eiC != null && this.eiC.a(this, view, oX.eia.eid, b2)) {
                oX.recycle();
                return true;
            }
            if (oX.asH()) {
                this.eig.a(oX);
                playSoundEffect(0);
                if (this.eiA != null) {
                    this.eiA.onGroupCollapse(oX.eia.eid);
                }
            } else {
                this.eig.b(oX);
                playSoundEffect(0);
                if (this.eiB != null) {
                    this.eiB.onGroupExpand(oX.eia.eid);
                }
                int i2 = oX.eia.eid;
                int headerViewsCount = oX.eia.eif + getHeaderViewsCount();
                smoothScrollToPosition(this.eih.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.eiD != null) {
            playSoundEffect(0);
            return this.eiD.a(this, view, oX.eia.eid, oX.eia.eie, b2);
        } else {
            z = false;
        }
        oX.recycle();
        return z;
    }

    public void setOnGroupCollapseListener(d dVar) {
        this.eiA = dVar;
    }

    public void setOnGroupExpandListener(e eVar) {
        this.eiB = eVar;
    }

    public void setOnGroupClickListener(c cVar) {
        this.eiC = cVar;
    }

    public void setOnChildClickListener(b bVar) {
        this.eiD = bVar;
    }

    public long getExpandableListPosition(int i) {
        if (isHeaderOrFooterPosition(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b oX = this.eig.oX(pa(i));
        long aBZ = oX.eia.aBZ();
        oX.recycle();
        return aBZ;
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
            return this.eih.getGroupId(packedPositionGroup);
        }
        return this.eih.getChildId(packedPositionGroup, getPackedPositionChild(selectedPosition));
    }

    public void setSelectedGroup(int i) {
        com.baidu.tieba.horizonalList.widget.b oZ = com.baidu.tieba.horizonalList.widget.b.oZ(i);
        ExpandableHListConnector.b a2 = this.eig.a(oZ);
        oZ.recycle();
        super.setSelection(pb(a2.eia.eif));
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
            return new a.ContextMenu$ContextMenuInfoC0117a(view, i, j);
        }
        ExpandableHListConnector.b oX = this.eig.oX(pa(i));
        com.baidu.tieba.horizonalList.widget.b bVar = oX.eia;
        long b2 = b(bVar);
        long aBZ = bVar.aBZ();
        oX.recycle();
        return new a(view, aBZ, b2);
    }

    private long b(com.baidu.tieba.horizonalList.widget.b bVar) {
        return bVar.type == 1 ? this.eih.getChildId(bVar.eid, bVar.eie) : this.eih.getGroupId(bVar.eid);
    }

    public void setChildIndicator(Drawable drawable) {
        this.eio = drawable;
        aCc();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.ein = drawable;
        aCb();
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
        ArrayList<ExpandableHListConnector.GroupMetadata> eiE;

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.eiE = arrayList;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.eiE = new ArrayList<>();
            parcel.readList(this.eiE, ExpandableHListConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.eiE);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.eig != null ? this.eig.aBX() : null);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.eig != null && savedState.eiE != null) {
            this.eig.R(savedState.eiE);
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
