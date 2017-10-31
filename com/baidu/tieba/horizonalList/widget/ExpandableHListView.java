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
    private static final int[] dlc = {16842920};
    private static final int[] dld = {16842921};
    private static final int[] dle = {16842920, 16842921};
    private static final int[][] dlf = {EMPTY_STATE_SET, dlc, dld, dle};
    private static final int[] dlg = {16842918};
    private ExpandableHListConnector dkS;
    private ExpandableListAdapter dkT;
    private int dkU;
    private int dkV;
    private int dkW;
    private int dkX;
    private int dkY;
    private int dkZ;
    private Drawable dla;
    private Drawable dlb;
    private Drawable dlh;
    private final Rect dli;
    private int dlj;
    private int dlk;
    private int dll;
    private int dlm;
    private d dln;
    private e dlo;
    private c dlp;
    private b dlq;
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

    private void asL() {
        if (this.dla != null) {
            this.dlj = this.dla.getIntrinsicWidth();
            this.dlk = this.dla.getIntrinsicHeight();
            return;
        }
        this.dlj = 0;
        this.dlk = 0;
    }

    private void asM() {
        if (this.dlb != null) {
            this.dll = this.dlb.getIntrinsicWidth();
            this.dlm = this.dlb.getIntrinsicHeight();
            return;
        }
        this.dll = 0;
        this.dlm = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.dlb != null || this.dla != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.mItemCount - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            Rect rect = this.dli;
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
                            ExpandableHListConnector.b lL = this.dkS.lL(i4);
                            if (lL.dkM.type != i2) {
                                if (lL.dkM.type == 1) {
                                    rect.top = childAt.getTop() + this.dkY;
                                    rect.bottom = childAt.getBottom() + this.dkY;
                                } else {
                                    rect.top = childAt.getTop() + this.dkU;
                                    rect.bottom = childAt.getBottom() + this.dkU;
                                }
                                i2 = lL.dkM.type;
                            }
                            if (rect.top != rect.bottom) {
                                if (lL.dkM.type == 1) {
                                    rect.left = this.dkZ + left;
                                    rect.right = this.dkZ + right2;
                                } else {
                                    rect.left = this.dkV + left;
                                    rect.right = this.dkV + right2;
                                }
                                Drawable c2 = c(lL);
                                if (c2 != null) {
                                    if (lL.dkM.type == 1) {
                                        Gravity.apply(this.dkX, this.dll, this.dlm, rect, this.mTempRect);
                                    } else {
                                        Gravity.apply(this.dkW, this.dlj, this.dlk, rect, this.mTempRect);
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
        if (bVar.dkM.type == 2) {
            Drawable drawable = this.dla;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            drawable.setState(dlf[(bVar.asI() ? (char) 1 : (char) 0) | (bVar.dkN == null || bVar.dkN.dkH == bVar.dkN.dkG ? (char) 2 : (char) 0)]);
            return drawable;
        }
        Drawable drawable2 = this.dlb;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(bVar.dkM.dkR == bVar.dkN.dkH ? dlg : EMPTY_STATE_SET);
        }
        return drawable2;
    }

    public void setChildDivider(Drawable drawable) {
        this.dlh = drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tieba.horizonalList.widget.HListView
    public void drawDivider(Canvas canvas, Rect rect, int i) {
        int i2 = this.mFirstPosition + i;
        if (i2 >= 0) {
            ExpandableHListConnector.b lL = this.dkS.lL(lO(i2));
            if (lL.dkM.type == 1 || (lL.asI() && lL.dkN.dkH != lL.dkN.dkG)) {
                Drawable drawable = this.dlh;
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
        this.dkT = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.dkS = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.dkS = null;
        }
        super.setAdapter((ListAdapter) this.dkS);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.dkT;
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
        ExpandableHListConnector.b lL = this.dkS.lL(i);
        long b2 = b(lL.dkM);
        if (lL.dkM.type == 2) {
            if (this.dlp != null && this.dlp.a(this, view, lL.dkM.dkP, b2)) {
                lL.recycle();
                return true;
            }
            if (lL.asI()) {
                this.dkS.a(lL);
                playSoundEffect(0);
                if (this.dln != null) {
                    this.dln.onGroupCollapse(lL.dkM.dkP);
                }
            } else {
                this.dkS.b(lL);
                playSoundEffect(0);
                if (this.dlo != null) {
                    this.dlo.onGroupExpand(lL.dkM.dkP);
                }
                int i2 = lL.dkM.dkP;
                int headerViewsCount = lL.dkM.dkR + getHeaderViewsCount();
                smoothScrollToPosition(this.dkT.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.dlq != null) {
            playSoundEffect(0);
            return this.dlq.a(this, view, lL.dkM.dkP, lL.dkM.dkQ, b2);
        } else {
            z = false;
        }
        lL.recycle();
        return z;
    }

    public void setOnGroupCollapseListener(d dVar) {
        this.dln = dVar;
    }

    public void setOnGroupExpandListener(e eVar) {
        this.dlo = eVar;
    }

    public void setOnGroupClickListener(c cVar) {
        this.dlp = cVar;
    }

    public void setOnChildClickListener(b bVar) {
        this.dlq = bVar;
    }

    public long getExpandableListPosition(int i) {
        if (isHeaderOrFooterPosition(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b lL = this.dkS.lL(lO(i));
        long asJ = lL.dkM.asJ();
        lL.recycle();
        return asJ;
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
            return this.dkT.getGroupId(packedPositionGroup);
        }
        return this.dkT.getChildId(packedPositionGroup, getPackedPositionChild(selectedPosition));
    }

    public void setSelectedGroup(int i) {
        com.baidu.tieba.horizonalList.widget.b lN = com.baidu.tieba.horizonalList.widget.b.lN(i);
        ExpandableHListConnector.b a2 = this.dkS.a(lN);
        lN.recycle();
        super.setSelection(lP(a2.dkM.dkR));
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
        ExpandableHListConnector.b lL = this.dkS.lL(lO(i));
        com.baidu.tieba.horizonalList.widget.b bVar = lL.dkM;
        long b2 = b(bVar);
        long asJ = bVar.asJ();
        lL.recycle();
        return new a(view, asJ, b2);
    }

    private long b(com.baidu.tieba.horizonalList.widget.b bVar) {
        return bVar.type == 1 ? this.dkT.getChildId(bVar.dkP, bVar.dkQ) : this.dkT.getGroupId(bVar.dkP);
    }

    public void setChildIndicator(Drawable drawable) {
        this.dlb = drawable;
        asM();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.dla = drawable;
        asL();
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
        ArrayList<ExpandableHListConnector.GroupMetadata> dlr;

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.dlr = arrayList;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.dlr = new ArrayList<>();
            parcel.readList(this.dlr, ExpandableHListConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.dlr);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.dkS != null ? this.dkS.asG() : null);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.dkS != null && savedState.dlr != null) {
            this.dkS.Q(savedState.dlr);
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
