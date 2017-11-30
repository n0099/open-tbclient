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
    private static final int[] dtn = {16842920};
    private static final int[] dto = {16842921};
    private static final int[] dtp = {16842920, 16842921};
    private static final int[][] dtq = {EMPTY_STATE_SET, dtn, dto, dtp};
    private static final int[] dtr = {16842918};
    private c dtA;
    private b dtB;
    private ExpandableHListConnector dtd;
    private ExpandableListAdapter dte;
    private int dtf;
    private int dtg;
    private int dth;
    private int dti;
    private int dtj;
    private int dtk;
    private Drawable dtl;
    private Drawable dtm;
    private Drawable dts;
    private final Rect dtt;
    private int dtu;
    private int dtv;
    private int dtw;
    private int dtx;
    private d dty;
    private e dtz;
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

    private void auF() {
        if (this.dtl != null) {
            this.dtu = this.dtl.getIntrinsicWidth();
            this.dtv = this.dtl.getIntrinsicHeight();
            return;
        }
        this.dtu = 0;
        this.dtv = 0;
    }

    private void auG() {
        if (this.dtm != null) {
            this.dtw = this.dtm.getIntrinsicWidth();
            this.dtx = this.dtm.getIntrinsicHeight();
            return;
        }
        this.dtw = 0;
        this.dtx = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.dtm != null || this.dtl != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.mItemCount - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            Rect rect = this.dtt;
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
                            ExpandableHListConnector.b mg = this.dtd.mg(i4);
                            if (mg.dsX.type != i2) {
                                if (mg.dsX.type == 1) {
                                    rect.top = childAt.getTop() + this.dtj;
                                    rect.bottom = childAt.getBottom() + this.dtj;
                                } else {
                                    rect.top = childAt.getTop() + this.dtf;
                                    rect.bottom = childAt.getBottom() + this.dtf;
                                }
                                i2 = mg.dsX.type;
                            }
                            if (rect.top != rect.bottom) {
                                if (mg.dsX.type == 1) {
                                    rect.left = this.dtk + left;
                                    rect.right = this.dtk + right2;
                                } else {
                                    rect.left = this.dtg + left;
                                    rect.right = this.dtg + right2;
                                }
                                Drawable c2 = c(mg);
                                if (c2 != null) {
                                    if (mg.dsX.type == 1) {
                                        Gravity.apply(this.dti, this.dtw, this.dtx, rect, this.mTempRect);
                                    } else {
                                        Gravity.apply(this.dth, this.dtu, this.dtv, rect, this.mTempRect);
                                    }
                                    c2.setBounds(this.mTempRect);
                                    c2.draw(canvas);
                                }
                            }
                            mg.recycle();
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
        if (bVar.dsX.type == 2) {
            Drawable drawable = this.dtl;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            drawable.setState(dtq[(bVar.auC() ? (char) 1 : (char) 0) | (bVar.dsY == null || bVar.dsY.dsS == bVar.dsY.dsR ? (char) 2 : (char) 0)]);
            return drawable;
        }
        Drawable drawable2 = this.dtm;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(bVar.dsX.dtc == bVar.dsY.dsS ? dtr : EMPTY_STATE_SET);
        }
        return drawable2;
    }

    public void setChildDivider(Drawable drawable) {
        this.dts = drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tieba.horizonalList.widget.HListView
    public void drawDivider(Canvas canvas, Rect rect, int i) {
        int i2 = this.mFirstPosition + i;
        if (i2 >= 0) {
            ExpandableHListConnector.b mg = this.dtd.mg(mj(i2));
            if (mg.dsX.type == 1 || (mg.auC() && mg.dsY.dsS != mg.dsY.dsR)) {
                Drawable drawable = this.dts;
                drawable.setBounds(rect);
                drawable.draw(canvas);
                mg.recycle();
                return;
            }
            mg.recycle();
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
        this.dte = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.dtd = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.dtd = null;
        }
        super.setAdapter((ListAdapter) this.dtd);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.dte;
    }

    private boolean isHeaderOrFooterPosition(int i) {
        return i < getHeaderViewsCount() || i >= this.mItemCount - getFooterViewsCount();
    }

    private int mj(int i) {
        return i - getHeaderViewsCount();
    }

    private int mk(int i) {
        return getHeaderViewsCount() + i;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.a
    public boolean performItemClick(View view, int i, long j) {
        if (isHeaderOrFooterPosition(i)) {
            return super.performItemClick(view, i, j);
        }
        return b(view, mj(i), j);
    }

    boolean b(View view, int i, long j) {
        boolean z;
        ExpandableHListConnector.b mg = this.dtd.mg(i);
        long b2 = b(mg.dsX);
        if (mg.dsX.type == 2) {
            if (this.dtA != null && this.dtA.a(this, view, mg.dsX.dta, b2)) {
                mg.recycle();
                return true;
            }
            if (mg.auC()) {
                this.dtd.a(mg);
                playSoundEffect(0);
                if (this.dty != null) {
                    this.dty.onGroupCollapse(mg.dsX.dta);
                }
            } else {
                this.dtd.b(mg);
                playSoundEffect(0);
                if (this.dtz != null) {
                    this.dtz.onGroupExpand(mg.dsX.dta);
                }
                int i2 = mg.dsX.dta;
                int headerViewsCount = mg.dsX.dtc + getHeaderViewsCount();
                smoothScrollToPosition(this.dte.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.dtB != null) {
            playSoundEffect(0);
            return this.dtB.a(this, view, mg.dsX.dta, mg.dsX.dtb, b2);
        } else {
            z = false;
        }
        mg.recycle();
        return z;
    }

    public void setOnGroupCollapseListener(d dVar) {
        this.dty = dVar;
    }

    public void setOnGroupExpandListener(e eVar) {
        this.dtz = eVar;
    }

    public void setOnGroupClickListener(c cVar) {
        this.dtA = cVar;
    }

    public void setOnChildClickListener(b bVar) {
        this.dtB = bVar;
    }

    public long getExpandableListPosition(int i) {
        if (isHeaderOrFooterPosition(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b mg = this.dtd.mg(mj(i));
        long auD = mg.dsX.auD();
        mg.recycle();
        return auD;
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
            return this.dte.getGroupId(packedPositionGroup);
        }
        return this.dte.getChildId(packedPositionGroup, getPackedPositionChild(selectedPosition));
    }

    public void setSelectedGroup(int i) {
        com.baidu.tieba.horizonalList.widget.b mi = com.baidu.tieba.horizonalList.widget.b.mi(i);
        ExpandableHListConnector.b a2 = this.dtd.a(mi);
        mi.recycle();
        super.setSelection(mk(a2.dsX.dtc));
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
        ExpandableHListConnector.b mg = this.dtd.mg(mj(i));
        com.baidu.tieba.horizonalList.widget.b bVar = mg.dsX;
        long b2 = b(bVar);
        long auD = bVar.auD();
        mg.recycle();
        return new a(view, auD, b2);
    }

    private long b(com.baidu.tieba.horizonalList.widget.b bVar) {
        return bVar.type == 1 ? this.dte.getChildId(bVar.dta, bVar.dtb) : this.dte.getGroupId(bVar.dta);
    }

    public void setChildIndicator(Drawable drawable) {
        this.dtm = drawable;
        auG();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.dtl = drawable;
        auF();
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
            /* renamed from: ml */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        ArrayList<ExpandableHListConnector.GroupMetadata> dtC;

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.dtC = arrayList;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.dtC = new ArrayList<>();
            parcel.readList(this.dtC, ExpandableHListConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.dtC);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.dtd != null ? this.dtd.auA() : null);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.dtd != null && savedState.dtC != null) {
            this.dtd.Q(savedState.dtC);
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
