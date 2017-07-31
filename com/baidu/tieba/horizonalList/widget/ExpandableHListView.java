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
    private static final int[] cXN = {16842920};
    private static final int[] cXO = {16842921};
    private static final int[] cXP = {16842920, 16842921};
    private static final int[][] cXQ = {EMPTY_STATE_SET, cXN, cXO, cXP};
    private static final int[] cXR = {16842918};
    private ExpandableHListConnector cXD;
    private ExpandableListAdapter cXE;
    private int cXF;
    private int cXG;
    private int cXH;
    private int cXI;
    private int cXJ;
    private int cXK;
    private Drawable cXL;
    private Drawable cXM;
    private Drawable cXS;
    private final Rect cXT;
    private int cXU;
    private int cXV;
    private int cXW;
    private int cXX;
    private d cXY;
    private e cXZ;
    private c cYa;
    private b cYb;
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

    private void aps() {
        if (this.cXL != null) {
            this.cXU = this.cXL.getIntrinsicWidth();
            this.cXV = this.cXL.getIntrinsicHeight();
            return;
        }
        this.cXU = 0;
        this.cXV = 0;
    }

    private void apt() {
        if (this.cXM != null) {
            this.cXW = this.cXM.getIntrinsicWidth();
            this.cXX = this.cXM.getIntrinsicHeight();
            return;
        }
        this.cXW = 0;
        this.cXX = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.cXM != null || this.cXL != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.mItemCount - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            Rect rect = this.cXT;
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
                            ExpandableHListConnector.b kW = this.cXD.kW(i4);
                            if (kW.cXx.type != i2) {
                                if (kW.cXx.type == 1) {
                                    rect.top = childAt.getTop() + this.cXJ;
                                    rect.bottom = childAt.getBottom() + this.cXJ;
                                } else {
                                    rect.top = childAt.getTop() + this.cXF;
                                    rect.bottom = childAt.getBottom() + this.cXF;
                                }
                                i2 = kW.cXx.type;
                            }
                            if (rect.top != rect.bottom) {
                                if (kW.cXx.type == 1) {
                                    rect.left = this.cXK + left;
                                    rect.right = this.cXK + right2;
                                } else {
                                    rect.left = this.cXG + left;
                                    rect.right = this.cXG + right2;
                                }
                                Drawable c2 = c(kW);
                                if (c2 != null) {
                                    if (kW.cXx.type == 1) {
                                        Gravity.apply(this.cXI, this.cXW, this.cXX, rect, this.mTempRect);
                                    } else {
                                        Gravity.apply(this.cXH, this.cXU, this.cXV, rect, this.mTempRect);
                                    }
                                    c2.setBounds(this.mTempRect);
                                    c2.draw(canvas);
                                }
                            }
                            kW.recycle();
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
        if (bVar.cXx.type == 2) {
            Drawable drawable = this.cXL;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            drawable.setState(cXQ[(bVar.app() ? (char) 1 : (char) 0) | (bVar.cXy == null || bVar.cXy.cXs == bVar.cXy.cXr ? (char) 2 : (char) 0)]);
            return drawable;
        }
        Drawable drawable2 = this.cXM;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(bVar.cXx.cXC == bVar.cXy.cXs ? cXR : EMPTY_STATE_SET);
        }
        return drawable2;
    }

    public void setChildDivider(Drawable drawable) {
        this.cXS = drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tieba.horizonalList.widget.HListView
    public void drawDivider(Canvas canvas, Rect rect, int i) {
        int i2 = this.mFirstPosition + i;
        if (i2 >= 0) {
            ExpandableHListConnector.b kW = this.cXD.kW(kZ(i2));
            if (kW.cXx.type == 1 || (kW.app() && kW.cXy.cXs != kW.cXy.cXr)) {
                Drawable drawable = this.cXS;
                drawable.setBounds(rect);
                drawable.draw(canvas);
                kW.recycle();
                return;
            }
            kW.recycle();
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
        this.cXE = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.cXD = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.cXD = null;
        }
        super.setAdapter((ListAdapter) this.cXD);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.cXE;
    }

    private boolean isHeaderOrFooterPosition(int i) {
        return i < getHeaderViewsCount() || i >= this.mItemCount - getFooterViewsCount();
    }

    private int kZ(int i) {
        return i - getHeaderViewsCount();
    }

    private int la(int i) {
        return getHeaderViewsCount() + i;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.a
    public boolean performItemClick(View view, int i, long j) {
        if (isHeaderOrFooterPosition(i)) {
            return super.performItemClick(view, i, j);
        }
        return c(view, kZ(i), j);
    }

    boolean c(View view, int i, long j) {
        boolean z;
        ExpandableHListConnector.b kW = this.cXD.kW(i);
        long b2 = b(kW.cXx);
        if (kW.cXx.type == 2) {
            if (this.cYa != null && this.cYa.a(this, view, kW.cXx.cXA, b2)) {
                kW.recycle();
                return true;
            }
            if (kW.app()) {
                this.cXD.a(kW);
                playSoundEffect(0);
                if (this.cXY != null) {
                    this.cXY.onGroupCollapse(kW.cXx.cXA);
                }
            } else {
                this.cXD.b(kW);
                playSoundEffect(0);
                if (this.cXZ != null) {
                    this.cXZ.onGroupExpand(kW.cXx.cXA);
                }
                int i2 = kW.cXx.cXA;
                int headerViewsCount = kW.cXx.cXC + getHeaderViewsCount();
                smoothScrollToPosition(this.cXE.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.cYb != null) {
            playSoundEffect(0);
            return this.cYb.a(this, view, kW.cXx.cXA, kW.cXx.cXB, b2);
        } else {
            z = false;
        }
        kW.recycle();
        return z;
    }

    public void setOnGroupCollapseListener(d dVar) {
        this.cXY = dVar;
    }

    public void setOnGroupExpandListener(e eVar) {
        this.cXZ = eVar;
    }

    public void setOnGroupClickListener(c cVar) {
        this.cYa = cVar;
    }

    public void setOnChildClickListener(b bVar) {
        this.cYb = bVar;
    }

    public long getExpandableListPosition(int i) {
        if (isHeaderOrFooterPosition(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b kW = this.cXD.kW(kZ(i));
        long apq = kW.cXx.apq();
        kW.recycle();
        return apq;
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
            return this.cXE.getGroupId(packedPositionGroup);
        }
        return this.cXE.getChildId(packedPositionGroup, getPackedPositionChild(selectedPosition));
    }

    public void setSelectedGroup(int i) {
        com.baidu.tieba.horizonalList.widget.b kY = com.baidu.tieba.horizonalList.widget.b.kY(i);
        ExpandableHListConnector.b a2 = this.cXD.a(kY);
        kY.recycle();
        super.setSelection(la(a2.cXx.cXC));
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
            return new a.ContextMenu$ContextMenuInfoC0089a(view, i, j);
        }
        ExpandableHListConnector.b kW = this.cXD.kW(kZ(i));
        com.baidu.tieba.horizonalList.widget.b bVar = kW.cXx;
        long b2 = b(bVar);
        long apq = bVar.apq();
        kW.recycle();
        return new a(view, apq, b2);
    }

    private long b(com.baidu.tieba.horizonalList.widget.b bVar) {
        return bVar.type == 1 ? this.cXE.getChildId(bVar.cXA, bVar.cXB) : this.cXE.getGroupId(bVar.cXA);
    }

    public void setChildIndicator(Drawable drawable) {
        this.cXM = drawable;
        apt();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.cXL = drawable;
        aps();
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
            /* renamed from: n */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: lb */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        ArrayList<ExpandableHListConnector.GroupMetadata> cYc;

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.cYc = arrayList;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.cYc = new ArrayList<>();
            parcel.readList(this.cYc, ExpandableHListConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.cYc);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.cXD != null ? this.cXD.apn() : null);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.cXD != null && savedState.cYc != null) {
            this.cXD.S(savedState.cYc);
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
