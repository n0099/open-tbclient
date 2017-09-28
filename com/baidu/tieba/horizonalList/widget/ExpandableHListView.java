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
    private static final int[] ddC = {16842920};
    private static final int[] ddD = {16842921};
    private static final int[] ddE = {16842920, 16842921};
    private static final int[][] ddF = {EMPTY_STATE_SET, ddC, ddD, ddE};
    private static final int[] ddG = {16842918};
    private Drawable ddA;
    private Drawable ddB;
    private Drawable ddH;
    private final Rect ddI;
    private int ddJ;
    private int ddK;
    private int ddL;
    private int ddM;
    private d ddN;
    private e ddO;
    private c ddP;
    private b ddQ;
    private ExpandableHListConnector ddr;
    private ExpandableListAdapter dds;
    private int ddt;
    private int ddv;
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

    private void aqu() {
        if (this.ddA != null) {
            this.ddJ = this.ddA.getIntrinsicWidth();
            this.ddK = this.ddA.getIntrinsicHeight();
            return;
        }
        this.ddJ = 0;
        this.ddK = 0;
    }

    private void aqv() {
        if (this.ddB != null) {
            this.ddL = this.ddB.getIntrinsicWidth();
            this.ddM = this.ddB.getIntrinsicHeight();
            return;
        }
        this.ddL = 0;
        this.ddM = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.ddB != null || this.ddA != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.mItemCount - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            Rect rect = this.ddI;
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
                            ExpandableHListConnector.b lv = this.ddr.lv(i4);
                            if (lv.ddl.type != i2) {
                                if (lv.ddl.type == 1) {
                                    rect.top = childAt.getTop() + this.ddy;
                                    rect.bottom = childAt.getBottom() + this.ddy;
                                } else {
                                    rect.top = childAt.getTop() + this.ddt;
                                    rect.bottom = childAt.getBottom() + this.ddt;
                                }
                                i2 = lv.ddl.type;
                            }
                            if (rect.top != rect.bottom) {
                                if (lv.ddl.type == 1) {
                                    rect.left = this.ddz + left;
                                    rect.right = this.ddz + right2;
                                } else {
                                    rect.left = this.ddv + left;
                                    rect.right = this.ddv + right2;
                                }
                                Drawable c2 = c(lv);
                                if (c2 != null) {
                                    if (lv.ddl.type == 1) {
                                        Gravity.apply(this.ddx, this.ddL, this.ddM, rect, this.mTempRect);
                                    } else {
                                        Gravity.apply(this.ddw, this.ddJ, this.ddK, rect, this.mTempRect);
                                    }
                                    c2.setBounds(this.mTempRect);
                                    c2.draw(canvas);
                                }
                            }
                            lv.recycle();
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
        if (bVar.ddl.type == 2) {
            Drawable drawable = this.ddA;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            drawable.setState(ddF[(bVar.aqr() ? (char) 1 : (char) 0) | (bVar.ddm == null || bVar.ddm.ddg == bVar.ddm.ddf ? (char) 2 : (char) 0)]);
            return drawable;
        }
        Drawable drawable2 = this.ddB;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(bVar.ddl.ddq == bVar.ddm.ddg ? ddG : EMPTY_STATE_SET);
        }
        return drawable2;
    }

    public void setChildDivider(Drawable drawable) {
        this.ddH = drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tieba.horizonalList.widget.HListView
    public void drawDivider(Canvas canvas, Rect rect, int i) {
        int i2 = this.mFirstPosition + i;
        if (i2 >= 0) {
            ExpandableHListConnector.b lv = this.ddr.lv(ly(i2));
            if (lv.ddl.type == 1 || (lv.aqr() && lv.ddm.ddg != lv.ddm.ddf)) {
                Drawable drawable = this.ddH;
                drawable.setBounds(rect);
                drawable.draw(canvas);
                lv.recycle();
                return;
            }
            lv.recycle();
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
        this.dds = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.ddr = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.ddr = null;
        }
        super.setAdapter((ListAdapter) this.ddr);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.dds;
    }

    private boolean isHeaderOrFooterPosition(int i) {
        return i < getHeaderViewsCount() || i >= this.mItemCount - getFooterViewsCount();
    }

    private int ly(int i) {
        return i - getHeaderViewsCount();
    }

    private int lz(int i) {
        return getHeaderViewsCount() + i;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.a
    public boolean performItemClick(View view, int i, long j) {
        if (isHeaderOrFooterPosition(i)) {
            return super.performItemClick(view, i, j);
        }
        return c(view, ly(i), j);
    }

    boolean c(View view, int i, long j) {
        boolean z;
        ExpandableHListConnector.b lv = this.ddr.lv(i);
        long b2 = b(lv.ddl);
        if (lv.ddl.type == 2) {
            if (this.ddP != null && this.ddP.a(this, view, lv.ddl.ddo, b2)) {
                lv.recycle();
                return true;
            }
            if (lv.aqr()) {
                this.ddr.a(lv);
                playSoundEffect(0);
                if (this.ddN != null) {
                    this.ddN.onGroupCollapse(lv.ddl.ddo);
                }
            } else {
                this.ddr.b(lv);
                playSoundEffect(0);
                if (this.ddO != null) {
                    this.ddO.onGroupExpand(lv.ddl.ddo);
                }
                int i2 = lv.ddl.ddo;
                int headerViewsCount = lv.ddl.ddq + getHeaderViewsCount();
                smoothScrollToPosition(this.dds.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.ddQ != null) {
            playSoundEffect(0);
            return this.ddQ.a(this, view, lv.ddl.ddo, lv.ddl.ddp, b2);
        } else {
            z = false;
        }
        lv.recycle();
        return z;
    }

    public void setOnGroupCollapseListener(d dVar) {
        this.ddN = dVar;
    }

    public void setOnGroupExpandListener(e eVar) {
        this.ddO = eVar;
    }

    public void setOnGroupClickListener(c cVar) {
        this.ddP = cVar;
    }

    public void setOnChildClickListener(b bVar) {
        this.ddQ = bVar;
    }

    public long getExpandableListPosition(int i) {
        if (isHeaderOrFooterPosition(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b lv = this.ddr.lv(ly(i));
        long aqs = lv.ddl.aqs();
        lv.recycle();
        return aqs;
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
            return this.dds.getGroupId(packedPositionGroup);
        }
        return this.dds.getChildId(packedPositionGroup, getPackedPositionChild(selectedPosition));
    }

    public void setSelectedGroup(int i) {
        com.baidu.tieba.horizonalList.widget.b lx = com.baidu.tieba.horizonalList.widget.b.lx(i);
        ExpandableHListConnector.b a2 = this.ddr.a(lx);
        lx.recycle();
        super.setSelection(lz(a2.ddl.ddq));
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
        ExpandableHListConnector.b lv = this.ddr.lv(ly(i));
        com.baidu.tieba.horizonalList.widget.b bVar = lv.ddl;
        long b2 = b(bVar);
        long aqs = bVar.aqs();
        lv.recycle();
        return new a(view, aqs, b2);
    }

    private long b(com.baidu.tieba.horizonalList.widget.b bVar) {
        return bVar.type == 1 ? this.dds.getChildId(bVar.ddo, bVar.ddp) : this.dds.getGroupId(bVar.ddo);
    }

    public void setChildIndicator(Drawable drawable) {
        this.ddB = drawable;
        aqv();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.ddA = drawable;
        aqu();
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
            /* renamed from: lA */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        ArrayList<ExpandableHListConnector.GroupMetadata> ddR;

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.ddR = arrayList;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.ddR = new ArrayList<>();
            parcel.readList(this.ddR, ExpandableHListConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.ddR);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.ddr != null ? this.ddr.aqp() : null);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.ddr != null && savedState.ddR != null) {
            this.ddr.Q(savedState.ddR);
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
