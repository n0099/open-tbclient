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
    private static final int[] cWu = {16842920};
    private static final int[] cWv = {16842921};
    private static final int[] cWw = {16842920, 16842921};
    private static final int[][] cWx = {EMPTY_STATE_SET, cWu, cWv, cWw};
    private static final int[] cWy = {16842918};
    private final Rect cWA;
    private int cWB;
    private int cWC;
    private int cWD;
    private int cWE;
    private d cWF;
    private e cWG;
    private c cWH;
    private b cWI;
    private ExpandableHListConnector cWk;
    private ExpandableListAdapter cWl;
    private int cWm;
    private int cWn;
    private int cWo;
    private int cWp;
    private int cWq;
    private int cWr;
    private Drawable cWs;
    private Drawable cWt;
    private Drawable cWz;
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

    private void apg() {
        if (this.cWs != null) {
            this.cWB = this.cWs.getIntrinsicWidth();
            this.cWC = this.cWs.getIntrinsicHeight();
            return;
        }
        this.cWB = 0;
        this.cWC = 0;
    }

    private void aph() {
        if (this.cWt != null) {
            this.cWD = this.cWt.getIntrinsicWidth();
            this.cWE = this.cWt.getIntrinsicHeight();
            return;
        }
        this.cWD = 0;
        this.cWE = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.cWt != null || this.cWs != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.mItemCount - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            Rect rect = this.cWA;
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
                            ExpandableHListConnector.b kX = this.cWk.kX(i4);
                            if (kX.cWe.type != i2) {
                                if (kX.cWe.type == 1) {
                                    rect.top = childAt.getTop() + this.cWq;
                                    rect.bottom = childAt.getBottom() + this.cWq;
                                } else {
                                    rect.top = childAt.getTop() + this.cWm;
                                    rect.bottom = childAt.getBottom() + this.cWm;
                                }
                                i2 = kX.cWe.type;
                            }
                            if (rect.top != rect.bottom) {
                                if (kX.cWe.type == 1) {
                                    rect.left = this.cWr + left;
                                    rect.right = this.cWr + right2;
                                } else {
                                    rect.left = this.cWn + left;
                                    rect.right = this.cWn + right2;
                                }
                                Drawable c2 = c(kX);
                                if (c2 != null) {
                                    if (kX.cWe.type == 1) {
                                        Gravity.apply(this.cWp, this.cWD, this.cWE, rect, this.mTempRect);
                                    } else {
                                        Gravity.apply(this.cWo, this.cWB, this.cWC, rect, this.mTempRect);
                                    }
                                    c2.setBounds(this.mTempRect);
                                    c2.draw(canvas);
                                }
                            }
                            kX.recycle();
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
        if (bVar.cWe.type == 2) {
            Drawable drawable = this.cWs;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            drawable.setState(cWx[(bVar.apd() ? (char) 1 : (char) 0) | (bVar.cWf == null || bVar.cWf.cVZ == bVar.cWf.cVY ? (char) 2 : (char) 0)]);
            return drawable;
        }
        Drawable drawable2 = this.cWt;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(bVar.cWe.cWj == bVar.cWf.cVZ ? cWy : EMPTY_STATE_SET);
        }
        return drawable2;
    }

    public void setChildDivider(Drawable drawable) {
        this.cWz = drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tieba.horizonalList.widget.HListView
    public void drawDivider(Canvas canvas, Rect rect, int i) {
        int i2 = this.mFirstPosition + i;
        if (i2 >= 0) {
            ExpandableHListConnector.b kX = this.cWk.kX(la(i2));
            if (kX.cWe.type == 1 || (kX.apd() && kX.cWf.cVZ != kX.cWf.cVY)) {
                Drawable drawable = this.cWz;
                drawable.setBounds(rect);
                drawable.draw(canvas);
                kX.recycle();
                return;
            }
            kX.recycle();
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
        this.cWl = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.cWk = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.cWk = null;
        }
        super.setAdapter((ListAdapter) this.cWk);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.cWl;
    }

    private boolean isHeaderOrFooterPosition(int i) {
        return i < getHeaderViewsCount() || i >= this.mItemCount - getFooterViewsCount();
    }

    private int la(int i) {
        return i - getHeaderViewsCount();
    }

    private int lb(int i) {
        return getHeaderViewsCount() + i;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.a
    public boolean performItemClick(View view, int i, long j) {
        if (isHeaderOrFooterPosition(i)) {
            return super.performItemClick(view, i, j);
        }
        return c(view, la(i), j);
    }

    boolean c(View view, int i, long j) {
        boolean z;
        ExpandableHListConnector.b kX = this.cWk.kX(i);
        long b2 = b(kX.cWe);
        if (kX.cWe.type == 2) {
            if (this.cWH != null && this.cWH.a(this, view, kX.cWe.cWh, b2)) {
                kX.recycle();
                return true;
            }
            if (kX.apd()) {
                this.cWk.a(kX);
                playSoundEffect(0);
                if (this.cWF != null) {
                    this.cWF.onGroupCollapse(kX.cWe.cWh);
                }
            } else {
                this.cWk.b(kX);
                playSoundEffect(0);
                if (this.cWG != null) {
                    this.cWG.onGroupExpand(kX.cWe.cWh);
                }
                int i2 = kX.cWe.cWh;
                int headerViewsCount = kX.cWe.cWj + getHeaderViewsCount();
                smoothScrollToPosition(this.cWl.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.cWI != null) {
            playSoundEffect(0);
            return this.cWI.a(this, view, kX.cWe.cWh, kX.cWe.cWi, b2);
        } else {
            z = false;
        }
        kX.recycle();
        return z;
    }

    public void setOnGroupCollapseListener(d dVar) {
        this.cWF = dVar;
    }

    public void setOnGroupExpandListener(e eVar) {
        this.cWG = eVar;
    }

    public void setOnGroupClickListener(c cVar) {
        this.cWH = cVar;
    }

    public void setOnChildClickListener(b bVar) {
        this.cWI = bVar;
    }

    public long getExpandableListPosition(int i) {
        if (isHeaderOrFooterPosition(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b kX = this.cWk.kX(la(i));
        long ape = kX.cWe.ape();
        kX.recycle();
        return ape;
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
            return this.cWl.getGroupId(packedPositionGroup);
        }
        return this.cWl.getChildId(packedPositionGroup, getPackedPositionChild(selectedPosition));
    }

    public void setSelectedGroup(int i) {
        com.baidu.tieba.horizonalList.widget.b kZ = com.baidu.tieba.horizonalList.widget.b.kZ(i);
        ExpandableHListConnector.b a2 = this.cWk.a(kZ);
        kZ.recycle();
        super.setSelection(lb(a2.cWe.cWj));
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
            return new a.ContextMenu$ContextMenuInfoC0090a(view, i, j);
        }
        ExpandableHListConnector.b kX = this.cWk.kX(la(i));
        com.baidu.tieba.horizonalList.widget.b bVar = kX.cWe;
        long b2 = b(bVar);
        long ape = bVar.ape();
        kX.recycle();
        return new a(view, ape, b2);
    }

    private long b(com.baidu.tieba.horizonalList.widget.b bVar) {
        return bVar.type == 1 ? this.cWl.getChildId(bVar.cWh, bVar.cWi) : this.cWl.getGroupId(bVar.cWh);
    }

    public void setChildIndicator(Drawable drawable) {
        this.cWt = drawable;
        aph();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.cWs = drawable;
        apg();
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
            /* renamed from: lc */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        ArrayList<ExpandableHListConnector.GroupMetadata> cWJ;

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.cWJ = arrayList;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.cWJ = new ArrayList<>();
            parcel.readList(this.cWJ, ExpandableHListConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.cWJ);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.cWk != null ? this.cWk.apb() : null);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.cWk != null && savedState.cWJ != null) {
            this.cWk.S(savedState.cWJ);
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
