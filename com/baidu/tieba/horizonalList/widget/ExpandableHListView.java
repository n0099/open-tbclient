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
    private static final int[] emn = {16842920};
    private static final int[] emo = {16842921};
    private static final int[] emp = {16842920, 16842921};
    private static final int[][] emq = {EMPTY_STATE_SET, emn, emo, emp};
    private static final int[] emr = {16842918};
    private c emA;
    private b emB;
    private ExpandableHListConnector eme;
    private ExpandableListAdapter emf;
    private int emg;
    private int emh;
    private int emi;
    private int emj;
    private int emk;
    private Drawable eml;
    private Drawable emm;
    private Drawable ems;
    private final Rect emt;
    private int emu;
    private int emv;
    private int emw;
    private int emx;
    private d emy;
    private e emz;
    private final Rect mTempRect;
    private int rh;

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
        aDu();
        aDv();
    }

    private void aDu() {
        if (this.eml != null) {
            this.emu = this.eml.getIntrinsicWidth();
            this.emv = this.eml.getIntrinsicHeight();
            return;
        }
        this.emu = 0;
        this.emv = 0;
    }

    private void aDv() {
        if (this.emm != null) {
            this.emw = this.emm.getIntrinsicWidth();
            this.emx = this.emm.getIntrinsicHeight();
            return;
        }
        this.emw = 0;
        this.emx = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.emm != null || this.eml != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.mItemCount - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            Rect rect = this.emt;
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
                            ExpandableHListConnector.b oY = this.eme.oY(i4);
                            if (oY.elY.type != i2) {
                                if (oY.elY.type == 1) {
                                    rect.top = childAt.getTop() + this.emj;
                                    rect.bottom = childAt.getBottom() + this.emj;
                                } else {
                                    rect.top = childAt.getTop() + this.emg;
                                    rect.bottom = childAt.getBottom() + this.emg;
                                }
                                i2 = oY.elY.type;
                            }
                            if (rect.top != rect.bottom) {
                                if (oY.elY.type == 1) {
                                    rect.left = this.emk + left;
                                    rect.right = this.emk + right2;
                                } else {
                                    rect.left = this.rh + left;
                                    rect.right = this.rh + right2;
                                }
                                Drawable c2 = c(oY);
                                if (c2 != null) {
                                    if (oY.elY.type == 1) {
                                        Gravity.apply(this.emi, this.emw, this.emx, rect, this.mTempRect);
                                    } else {
                                        Gravity.apply(this.emh, this.emu, this.emv, rect, this.mTempRect);
                                    }
                                    c2.setBounds(this.mTempRect);
                                    c2.draw(canvas);
                                }
                            }
                            oY.recycle();
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
        if (bVar.elY.type == 2) {
            Drawable drawable = this.eml;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            drawable.setState(emq[(bVar.atw() ? (char) 1 : (char) 0) | (bVar.elZ == null || bVar.elZ.elT == bVar.elZ.elS ? (char) 2 : (char) 0)]);
            return drawable;
        }
        Drawable drawable2 = this.emm;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(bVar.elY.emd == bVar.elZ.elT ? emr : EMPTY_STATE_SET);
        }
        return drawable2;
    }

    public void setChildDivider(Drawable drawable) {
        this.ems = drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tieba.horizonalList.widget.HListView
    public void drawDivider(Canvas canvas, Rect rect, int i) {
        int i2 = this.mFirstPosition + i;
        if (i2 >= 0) {
            ExpandableHListConnector.b oY = this.eme.oY(pb(i2));
            if (oY.elY.type == 1 || (oY.atw() && oY.elZ.elT != oY.elZ.elS)) {
                Drawable drawable = this.ems;
                drawable.setBounds(rect);
                drawable.draw(canvas);
                oY.recycle();
                return;
            }
            oY.recycle();
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
        this.emf = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.eme = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.eme = null;
        }
        super.setAdapter((ListAdapter) this.eme);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.emf;
    }

    private boolean isHeaderOrFooterPosition(int i) {
        return i < getHeaderViewsCount() || i >= this.mItemCount - getFooterViewsCount();
    }

    private int pb(int i) {
        return i - getHeaderViewsCount();
    }

    private int pc(int i) {
        return getHeaderViewsCount() + i;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.a
    public boolean performItemClick(View view, int i, long j) {
        if (isHeaderOrFooterPosition(i)) {
            return super.performItemClick(view, i, j);
        }
        return b(view, pb(i), j);
    }

    boolean b(View view, int i, long j) {
        boolean z;
        ExpandableHListConnector.b oY = this.eme.oY(i);
        long b2 = b(oY.elY);
        if (oY.elY.type == 2) {
            if (this.emA != null && this.emA.a(this, view, oY.elY.emb, b2)) {
                oY.recycle();
                return true;
            }
            if (oY.atw()) {
                this.eme.a(oY);
                playSoundEffect(0);
                if (this.emy != null) {
                    this.emy.onGroupCollapse(oY.elY.emb);
                }
            } else {
                this.eme.b(oY);
                playSoundEffect(0);
                if (this.emz != null) {
                    this.emz.onGroupExpand(oY.elY.emb);
                }
                int i2 = oY.elY.emb;
                int headerViewsCount = oY.elY.emd + getHeaderViewsCount();
                smoothScrollToPosition(this.emf.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.emB != null) {
            playSoundEffect(0);
            return this.emB.a(this, view, oY.elY.emb, oY.elY.emc, b2);
        } else {
            z = false;
        }
        oY.recycle();
        return z;
    }

    public void setOnGroupCollapseListener(d dVar) {
        this.emy = dVar;
    }

    public void setOnGroupExpandListener(e eVar) {
        this.emz = eVar;
    }

    public void setOnGroupClickListener(c cVar) {
        this.emA = cVar;
    }

    public void setOnChildClickListener(b bVar) {
        this.emB = bVar;
    }

    public long getExpandableListPosition(int i) {
        if (isHeaderOrFooterPosition(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b oY = this.eme.oY(pb(i));
        long aDs = oY.elY.aDs();
        oY.recycle();
        return aDs;
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
            return this.emf.getGroupId(packedPositionGroup);
        }
        return this.emf.getChildId(packedPositionGroup, getPackedPositionChild(selectedPosition));
    }

    public void setSelectedGroup(int i) {
        com.baidu.tieba.horizonalList.widget.b pa = com.baidu.tieba.horizonalList.widget.b.pa(i);
        ExpandableHListConnector.b a2 = this.eme.a(pa);
        pa.recycle();
        super.setSelection(pc(a2.elY.emd));
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
            return new a.ContextMenu$ContextMenuInfoC0164a(view, i, j);
        }
        ExpandableHListConnector.b oY = this.eme.oY(pb(i));
        com.baidu.tieba.horizonalList.widget.b bVar = oY.elY;
        long b2 = b(bVar);
        long aDs = bVar.aDs();
        oY.recycle();
        return new a(view, aDs, b2);
    }

    private long b(com.baidu.tieba.horizonalList.widget.b bVar) {
        return bVar.type == 1 ? this.emf.getChildId(bVar.emb, bVar.emc) : this.emf.getGroupId(bVar.emb);
    }

    public void setChildIndicator(Drawable drawable) {
        this.emm = drawable;
        aDv();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.eml = drawable;
        aDu();
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
            /* renamed from: F */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: pd */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        ArrayList<ExpandableHListConnector.GroupMetadata> emC;

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.emC = arrayList;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.emC = new ArrayList<>();
            parcel.readList(this.emC, ExpandableHListConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.emC);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.eme != null ? this.eme.aDq() : null);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.eme != null && savedState.emC != null) {
            this.eme.R(savedState.emC);
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
