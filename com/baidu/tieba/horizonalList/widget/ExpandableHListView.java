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
    private Drawable emE;
    private final Rect emF;
    private int emG;
    private int emH;
    private int emI;
    private int emJ;
    private d emK;
    private e emL;
    private c emM;
    private b emN;
    private ExpandableHListConnector emq;
    private ExpandableListAdapter emr;
    private int ems;
    private int emt;
    private int emu;
    private int emv;
    private int emw;
    private Drawable emx;
    private Drawable emy;
    private final Rect mTempRect;
    private int ri;
    private static final int[] EMPTY_STATE_SET = new int[0];
    private static final int[] emz = {16842920};
    private static final int[] emA = {16842921};
    private static final int[] emB = {16842920, 16842921};
    private static final int[][] emC = {EMPTY_STATE_SET, emz, emA, emB};
    private static final int[] emD = {16842918};

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
        aDv();
        aDw();
    }

    private void aDv() {
        if (this.emx != null) {
            this.emG = this.emx.getIntrinsicWidth();
            this.emH = this.emx.getIntrinsicHeight();
            return;
        }
        this.emG = 0;
        this.emH = 0;
    }

    private void aDw() {
        if (this.emy != null) {
            this.emI = this.emy.getIntrinsicWidth();
            this.emJ = this.emy.getIntrinsicHeight();
            return;
        }
        this.emI = 0;
        this.emJ = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.emy != null || this.emx != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.mItemCount - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            Rect rect = this.emF;
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
                            ExpandableHListConnector.b oY = this.emq.oY(i4);
                            if (oY.emk.type != i2) {
                                if (oY.emk.type == 1) {
                                    rect.top = childAt.getTop() + this.emv;
                                    rect.bottom = childAt.getBottom() + this.emv;
                                } else {
                                    rect.top = childAt.getTop() + this.ems;
                                    rect.bottom = childAt.getBottom() + this.ems;
                                }
                                i2 = oY.emk.type;
                            }
                            if (rect.top != rect.bottom) {
                                if (oY.emk.type == 1) {
                                    rect.left = this.emw + left;
                                    rect.right = this.emw + right2;
                                } else {
                                    rect.left = this.ri + left;
                                    rect.right = this.ri + right2;
                                }
                                Drawable c2 = c(oY);
                                if (c2 != null) {
                                    if (oY.emk.type == 1) {
                                        Gravity.apply(this.emu, this.emI, this.emJ, rect, this.mTempRect);
                                    } else {
                                        Gravity.apply(this.emt, this.emG, this.emH, rect, this.mTempRect);
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
        if (bVar.emk.type == 2) {
            Drawable drawable = this.emx;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            drawable.setState(emC[(bVar.atx() ? (char) 1 : (char) 0) | (bVar.eml == null || bVar.eml.emf == bVar.eml.eme ? (char) 2 : (char) 0)]);
            return drawable;
        }
        Drawable drawable2 = this.emy;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(bVar.emk.emp == bVar.eml.emf ? emD : EMPTY_STATE_SET);
        }
        return drawable2;
    }

    public void setChildDivider(Drawable drawable) {
        this.emE = drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tieba.horizonalList.widget.HListView
    public void drawDivider(Canvas canvas, Rect rect, int i) {
        int i2 = this.mFirstPosition + i;
        if (i2 >= 0) {
            ExpandableHListConnector.b oY = this.emq.oY(pb(i2));
            if (oY.emk.type == 1 || (oY.atx() && oY.eml.emf != oY.eml.eme)) {
                Drawable drawable = this.emE;
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
        this.emr = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.emq = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.emq = null;
        }
        super.setAdapter((ListAdapter) this.emq);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.emr;
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
        ExpandableHListConnector.b oY = this.emq.oY(i);
        long b2 = b(oY.emk);
        if (oY.emk.type == 2) {
            if (this.emM != null && this.emM.a(this, view, oY.emk.emn, b2)) {
                oY.recycle();
                return true;
            }
            if (oY.atx()) {
                this.emq.a(oY);
                playSoundEffect(0);
                if (this.emK != null) {
                    this.emK.onGroupCollapse(oY.emk.emn);
                }
            } else {
                this.emq.b(oY);
                playSoundEffect(0);
                if (this.emL != null) {
                    this.emL.onGroupExpand(oY.emk.emn);
                }
                int i2 = oY.emk.emn;
                int headerViewsCount = oY.emk.emp + getHeaderViewsCount();
                smoothScrollToPosition(this.emr.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.emN != null) {
            playSoundEffect(0);
            return this.emN.a(this, view, oY.emk.emn, oY.emk.emo, b2);
        } else {
            z = false;
        }
        oY.recycle();
        return z;
    }

    public void setOnGroupCollapseListener(d dVar) {
        this.emK = dVar;
    }

    public void setOnGroupExpandListener(e eVar) {
        this.emL = eVar;
    }

    public void setOnGroupClickListener(c cVar) {
        this.emM = cVar;
    }

    public void setOnChildClickListener(b bVar) {
        this.emN = bVar;
    }

    public long getExpandableListPosition(int i) {
        if (isHeaderOrFooterPosition(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b oY = this.emq.oY(pb(i));
        long aDt = oY.emk.aDt();
        oY.recycle();
        return aDt;
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
            return this.emr.getGroupId(packedPositionGroup);
        }
        return this.emr.getChildId(packedPositionGroup, getPackedPositionChild(selectedPosition));
    }

    public void setSelectedGroup(int i) {
        com.baidu.tieba.horizonalList.widget.b pa = com.baidu.tieba.horizonalList.widget.b.pa(i);
        ExpandableHListConnector.b a2 = this.emq.a(pa);
        pa.recycle();
        super.setSelection(pc(a2.emk.emp));
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
            return new a.ContextMenu$ContextMenuInfoC0163a(view, i, j);
        }
        ExpandableHListConnector.b oY = this.emq.oY(pb(i));
        com.baidu.tieba.horizonalList.widget.b bVar = oY.emk;
        long b2 = b(bVar);
        long aDt = bVar.aDt();
        oY.recycle();
        return new a(view, aDt, b2);
    }

    private long b(com.baidu.tieba.horizonalList.widget.b bVar) {
        return bVar.type == 1 ? this.emr.getChildId(bVar.emn, bVar.emo) : this.emr.getGroupId(bVar.emn);
    }

    public void setChildIndicator(Drawable drawable) {
        this.emy = drawable;
        aDw();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.emx = drawable;
        aDv();
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
        ArrayList<ExpandableHListConnector.GroupMetadata> emO;

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.emO = arrayList;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.emO = new ArrayList<>();
            parcel.readList(this.emO, ExpandableHListConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.emO);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.emq != null ? this.emq.aDr() : null);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.emq != null && savedState.emO != null) {
            this.emq.R(savedState.emO);
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
