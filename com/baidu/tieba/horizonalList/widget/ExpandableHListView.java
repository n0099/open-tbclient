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
    private Drawable dlB;
    private final Rect dlC;
    private int dlD;
    private int dlE;
    private int dlF;
    private int dlG;
    private d dlH;
    private e dlI;
    private c dlJ;
    private b dlK;
    private ExpandableHListConnector dlm;
    private ExpandableListAdapter dln;
    private int dlo;
    private int dlp;
    private int dlq;
    private int dlr;
    private int dls;
    private int dlt;
    private Drawable dlu;
    private Drawable dlv;
    private final Rect mTempRect;
    private static final int[] EMPTY_STATE_SET = new int[0];
    private static final int[] dlw = {16842920};
    private static final int[] dlx = {16842921};
    private static final int[] dly = {16842920, 16842921};
    private static final int[][] dlz = {EMPTY_STATE_SET, dlw, dlx, dly};
    private static final int[] dlA = {16842918};

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

    private void atc() {
        if (this.dlu != null) {
            this.dlD = this.dlu.getIntrinsicWidth();
            this.dlE = this.dlu.getIntrinsicHeight();
            return;
        }
        this.dlD = 0;
        this.dlE = 0;
    }

    private void atd() {
        if (this.dlv != null) {
            this.dlF = this.dlv.getIntrinsicWidth();
            this.dlG = this.dlv.getIntrinsicHeight();
            return;
        }
        this.dlF = 0;
        this.dlG = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.dlv != null || this.dlu != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.mItemCount - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            Rect rect = this.dlC;
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
                            ExpandableHListConnector.b lL = this.dlm.lL(i4);
                            if (lL.dlg.type != i2) {
                                if (lL.dlg.type == 1) {
                                    rect.top = childAt.getTop() + this.dls;
                                    rect.bottom = childAt.getBottom() + this.dls;
                                } else {
                                    rect.top = childAt.getTop() + this.dlo;
                                    rect.bottom = childAt.getBottom() + this.dlo;
                                }
                                i2 = lL.dlg.type;
                            }
                            if (rect.top != rect.bottom) {
                                if (lL.dlg.type == 1) {
                                    rect.left = this.dlt + left;
                                    rect.right = this.dlt + right2;
                                } else {
                                    rect.left = this.dlp + left;
                                    rect.right = this.dlp + right2;
                                }
                                Drawable c2 = c(lL);
                                if (c2 != null) {
                                    if (lL.dlg.type == 1) {
                                        Gravity.apply(this.dlr, this.dlF, this.dlG, rect, this.mTempRect);
                                    } else {
                                        Gravity.apply(this.dlq, this.dlD, this.dlE, rect, this.mTempRect);
                                    }
                                    c2.setBounds(this.mTempRect);
                                    c2.draw(canvas);
                                }
                            }
                            lL.recycle();
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
        if (bVar.dlg.type == 2) {
            Drawable drawable = this.dlu;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            drawable.setState(dlz[(bVar.asZ() ? (char) 1 : (char) 0) | (bVar.dlh == null || bVar.dlh.dlb == bVar.dlh.dla ? (char) 2 : (char) 0)]);
            return drawable;
        }
        Drawable drawable2 = this.dlv;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(bVar.dlg.dll == bVar.dlh.dlb ? dlA : EMPTY_STATE_SET);
        }
        return drawable2;
    }

    public void setChildDivider(Drawable drawable) {
        this.dlB = drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tieba.horizonalList.widget.HListView
    public void drawDivider(Canvas canvas, Rect rect, int i) {
        int i2 = this.mFirstPosition + i;
        if (i2 >= 0) {
            ExpandableHListConnector.b lL = this.dlm.lL(lO(i2));
            if (lL.dlg.type == 1 || (lL.asZ() && lL.dlh.dlb != lL.dlh.dla)) {
                Drawable drawable = this.dlB;
                drawable.setBounds(rect);
                drawable.draw(canvas);
                lL.recycle();
                return;
            }
            lL.recycle();
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
        this.dln = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.dlm = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.dlm = null;
        }
        super.setAdapter((ListAdapter) this.dlm);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.dln;
    }

    private boolean isHeaderOrFooterPosition(int i) {
        return i < getHeaderViewsCount() || i >= this.mItemCount - getFooterViewsCount();
    }

    private int lO(int i) {
        return i - getHeaderViewsCount();
    }

    private int lP(int i) {
        return getHeaderViewsCount() + i;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.a
    public boolean performItemClick(View view, int i, long j) {
        if (isHeaderOrFooterPosition(i)) {
            return super.performItemClick(view, i, j);
        }
        return c(view, lO(i), j);
    }

    boolean c(View view, int i, long j) {
        boolean z;
        ExpandableHListConnector.b lL = this.dlm.lL(i);
        long b2 = b(lL.dlg);
        if (lL.dlg.type == 2) {
            if (this.dlJ != null && this.dlJ.a(this, view, lL.dlg.dlj, b2)) {
                lL.recycle();
                return true;
            }
            if (lL.asZ()) {
                this.dlm.a(lL);
                playSoundEffect(0);
                if (this.dlH != null) {
                    this.dlH.onGroupCollapse(lL.dlg.dlj);
                }
            } else {
                this.dlm.b(lL);
                playSoundEffect(0);
                if (this.dlI != null) {
                    this.dlI.onGroupExpand(lL.dlg.dlj);
                }
                int i2 = lL.dlg.dlj;
                int headerViewsCount = lL.dlg.dll + getHeaderViewsCount();
                smoothScrollToPosition(this.dln.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.dlK != null) {
            playSoundEffect(0);
            return this.dlK.a(this, view, lL.dlg.dlj, lL.dlg.dlk, b2);
        } else {
            z = false;
        }
        lL.recycle();
        return z;
    }

    public void setOnGroupCollapseListener(d dVar) {
        this.dlH = dVar;
    }

    public void setOnGroupExpandListener(e eVar) {
        this.dlI = eVar;
    }

    public void setOnGroupClickListener(c cVar) {
        this.dlJ = cVar;
    }

    public void setOnChildClickListener(b bVar) {
        this.dlK = bVar;
    }

    public long getExpandableListPosition(int i) {
        if (isHeaderOrFooterPosition(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b lL = this.dlm.lL(lO(i));
        long ata = lL.dlg.ata();
        lL.recycle();
        return ata;
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
            return this.dln.getGroupId(packedPositionGroup);
        }
        return this.dln.getChildId(packedPositionGroup, getPackedPositionChild(selectedPosition));
    }

    public void setSelectedGroup(int i) {
        com.baidu.tieba.horizonalList.widget.b lN = com.baidu.tieba.horizonalList.widget.b.lN(i);
        ExpandableHListConnector.b a2 = this.dlm.a(lN);
        lN.recycle();
        super.setSelection(lP(a2.dlg.dll));
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
        ExpandableHListConnector.b lL = this.dlm.lL(lO(i));
        com.baidu.tieba.horizonalList.widget.b bVar = lL.dlg;
        long b2 = b(bVar);
        long ata = bVar.ata();
        lL.recycle();
        return new a(view, ata, b2);
    }

    private long b(com.baidu.tieba.horizonalList.widget.b bVar) {
        return bVar.type == 1 ? this.dln.getChildId(bVar.dlj, bVar.dlk) : this.dln.getGroupId(bVar.dlj);
    }

    public void setChildIndicator(Drawable drawable) {
        this.dlv = drawable;
        atd();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.dlu = drawable;
        atc();
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
            /* renamed from: lQ */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        ArrayList<ExpandableHListConnector.GroupMetadata> dlL;

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.dlL = arrayList;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.dlL = new ArrayList<>();
            parcel.readList(this.dlL, ExpandableHListConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.dlL);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.dlm != null ? this.dlm.asX() : null);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.dlm != null && savedState.dlL != null) {
            this.dlm.Q(savedState.dlL);
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
