package com.baidu.tieba.horizonalList.widget;

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
import com.baidu.tieba.horizonalList.widget.g;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ExpandableHListView extends HListView {
    private static final int[] EMPTY_STATE_SET = new int[0];
    private static final int[] cDJ = {16842920};
    private static final int[] cDK = {16842921};
    private static final int[] cDL = {16842920, 16842921};
    private static final int[][] cDM = {EMPTY_STATE_SET, cDJ, cDK, cDL};
    private static final int[] cDN = {16842918};
    private ExpandableListAdapter cDA;
    private int cDB;
    private int cDC;
    private int cDD;
    private int cDE;
    private int cDF;
    private int cDG;
    private Drawable cDH;
    private Drawable cDI;
    private Drawable cDO;
    private final Rect cDP;
    private int cDQ;
    private int cDR;
    private int cDS;
    private int cDT;
    private d cDU;
    private e cDV;
    private c cDW;
    private b cDX;
    private ExpandableHListConnector cDz;
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

    private void akY() {
        if (this.cDH != null) {
            this.cDQ = this.cDH.getIntrinsicWidth();
            this.cDR = this.cDH.getIntrinsicHeight();
            return;
        }
        this.cDQ = 0;
        this.cDR = 0;
    }

    private void akZ() {
        if (this.cDI != null) {
            this.cDS = this.cDI.getIntrinsicWidth();
            this.cDT = this.cDI.getIntrinsicHeight();
            return;
        }
        this.cDS = 0;
        this.cDT = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.cDI != null || this.cDH != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.cCY - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            Rect rect = this.cDP;
            int childCount = getChildCount();
            int i = this.cCL - headerViewsCount;
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
                            ExpandableHListConnector.b kn = this.cDz.kn(i4);
                            if (kn.cDt.type != i2) {
                                if (kn.cDt.type == 1) {
                                    rect.top = childAt.getTop() + this.cDF;
                                    rect.bottom = childAt.getBottom() + this.cDF;
                                } else {
                                    rect.top = childAt.getTop() + this.cDB;
                                    rect.bottom = childAt.getBottom() + this.cDB;
                                }
                                i2 = kn.cDt.type;
                            }
                            if (rect.top != rect.bottom) {
                                if (kn.cDt.type == 1) {
                                    rect.left = this.cDG + left;
                                    rect.right = this.cDG + right2;
                                } else {
                                    rect.left = this.cDC + left;
                                    rect.right = this.cDC + right2;
                                }
                                Drawable c2 = c(kn);
                                if (c2 != null) {
                                    if (kn.cDt.type == 1) {
                                        Gravity.apply(this.cDE, this.cDS, this.cDT, rect, this.mTempRect);
                                    } else {
                                        Gravity.apply(this.cDD, this.cDQ, this.cDR, rect, this.mTempRect);
                                    }
                                    c2.setBounds(this.mTempRect);
                                    c2.draw(canvas);
                                }
                            }
                            kn.recycle();
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
        if (bVar.cDt.type == 2) {
            Drawable drawable = this.cDH;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            drawable.setState(cDM[(bVar.akV() ? (char) 1 : (char) 0) | (bVar.cDu == null || bVar.cDu.cDo == bVar.cDu.cDn ? (char) 2 : (char) 0)]);
            return drawable;
        }
        Drawable drawable2 = this.cDI;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(bVar.cDt.cDy == bVar.cDu.cDo ? cDN : EMPTY_STATE_SET);
        }
        return drawable2;
    }

    public void setChildDivider(Drawable drawable) {
        this.cDO = drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tieba.horizonalList.widget.HListView
    public void a(Canvas canvas, Rect rect, int i) {
        int i2 = this.cCL + i;
        if (i2 >= 0) {
            ExpandableHListConnector.b kn = this.cDz.kn(kr(i2));
            if (kn.cDt.type == 1 || (kn.akV() && kn.cDu.cDo != kn.cDu.cDn)) {
                Drawable drawable = this.cDO;
                drawable.setBounds(rect);
                drawable.draw(canvas);
                kn.recycle();
                return;
            }
            kn.recycle();
        }
        super.a(canvas, rect, i2);
    }

    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView
    public void setAdapter(ListAdapter listAdapter) {
        throw new RuntimeException("For ExpandableListView, use setAdapter(ExpandableListAdapter) instead of setAdapter(ListAdapter)");
    }

    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.g
    public ListAdapter getAdapter() {
        return super.getAdapter();
    }

    @Override // com.baidu.tieba.horizonalList.widget.g
    public void setOnItemClickListener(g.c cVar) {
        super.setOnItemClickListener(cVar);
    }

    public void setAdapter(ExpandableListAdapter expandableListAdapter) {
        this.cDA = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.cDz = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.cDz = null;
        }
        super.setAdapter((ListAdapter) this.cDz);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.cDA;
    }

    private boolean kq(int i) {
        return i < getHeaderViewsCount() || i >= this.cCY - getFooterViewsCount();
    }

    private int kr(int i) {
        return i - getHeaderViewsCount();
    }

    private int ks(int i) {
        return getHeaderViewsCount() + i;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.g
    public boolean performItemClick(View view, int i, long j) {
        if (kq(i)) {
            return super.performItemClick(view, i, j);
        }
        return d(view, kr(i), j);
    }

    boolean d(View view, int i, long j) {
        boolean z;
        ExpandableHListConnector.b kn = this.cDz.kn(i);
        long b2 = b(kn.cDt);
        if (kn.cDt.type == 2) {
            if (this.cDW != null && this.cDW.a(this, view, kn.cDt.cDw, b2)) {
                kn.recycle();
                return true;
            }
            if (kn.akV()) {
                this.cDz.a(kn);
                playSoundEffect(0);
                if (this.cDU != null) {
                    this.cDU.onGroupCollapse(kn.cDt.cDw);
                }
            } else {
                this.cDz.b(kn);
                playSoundEffect(0);
                if (this.cDV != null) {
                    this.cDV.onGroupExpand(kn.cDt.cDw);
                }
                int i2 = kn.cDt.cDw;
                int headerViewsCount = kn.cDt.cDy + getHeaderViewsCount();
                smoothScrollToPosition(this.cDA.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.cDX != null) {
            playSoundEffect(0);
            return this.cDX.a(this, view, kn.cDt.cDw, kn.cDt.cDx, b2);
        } else {
            z = false;
        }
        kn.recycle();
        return z;
    }

    public void setOnGroupCollapseListener(d dVar) {
        this.cDU = dVar;
    }

    public void setOnGroupExpandListener(e eVar) {
        this.cDV = eVar;
    }

    public void setOnGroupClickListener(c cVar) {
        this.cDW = cVar;
    }

    public void setOnChildClickListener(b bVar) {
        this.cDX = bVar;
    }

    public long getExpandableListPosition(int i) {
        if (kq(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b kn = this.cDz.kn(kr(i));
        long akW = kn.cDt.akW();
        kn.recycle();
        return akW;
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
            return this.cDA.getGroupId(packedPositionGroup);
        }
        return this.cDA.getChildId(packedPositionGroup, getPackedPositionChild(selectedPosition));
    }

    public void setSelectedGroup(int i) {
        i kp = i.kp(i);
        ExpandableHListConnector.b a2 = this.cDz.a(kp);
        kp.recycle();
        super.setSelection(ks(a2.cDt.cDy));
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
    ContextMenu.ContextMenuInfo b(View view, int i, long j) {
        if (kq(i)) {
            return new g.a(view, i, j);
        }
        ExpandableHListConnector.b kn = this.cDz.kn(kr(i));
        i iVar = kn.cDt;
        long b2 = b(iVar);
        long akW = iVar.akW();
        kn.recycle();
        return new a(view, akW, b2);
    }

    private long b(i iVar) {
        return iVar.type == 1 ? this.cDA.getChildId(iVar.cDw, iVar.cDx) : this.cDA.getGroupId(iVar.cDw);
    }

    public void setChildIndicator(Drawable drawable) {
        this.cDI = drawable;
        akZ();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.cDH = drawable;
        akY();
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

    /* loaded from: classes.dex */
    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new j();
        ArrayList<ExpandableHListConnector.GroupMetadata> cDY;

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.cDY = arrayList;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ SavedState(Parcel parcel, SavedState savedState) {
            this(parcel);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.cDY = new ArrayList<>();
            parcel.readList(this.cDY, ExpandableHListConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.cDY);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.cDz != null ? this.cDz.akS() : null);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.cDz != null && savedState.cDY != null) {
            this.cDz.Q(savedState.cDY);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.g, android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(ExpandableHListView.class.getName());
    }

    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.g, android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(ExpandableHListView.class.getName());
    }
}
