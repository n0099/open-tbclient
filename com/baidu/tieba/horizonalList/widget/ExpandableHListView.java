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
    private static final int[] bTc = {16842920};
    private static final int[] bTd = {16842921};
    private static final int[] bTe = {16842920, 16842921};
    private static final int[][] bTf = {EMPTY_STATE_SET, bTc, bTd, bTe};
    private static final int[] bTg = {16842918};
    private ExpandableHListConnector bSS;
    private ExpandableListAdapter bST;
    private int bSU;
    private int bSV;
    private int bSW;
    private int bSX;
    private int bSY;
    private int bSZ;
    private Drawable bTa;
    private Drawable bTb;
    private Drawable bTh;
    private final Rect bTi;
    private int bTj;
    private int bTk;
    private int bTl;
    private int bTm;
    private d bTn;
    private e bTo;
    private c bTp;
    private b bTq;
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

    private void aaG() {
        if (this.bTa != null) {
            this.bTj = this.bTa.getIntrinsicWidth();
            this.bTk = this.bTa.getIntrinsicHeight();
            return;
        }
        this.bTj = 0;
        this.bTk = 0;
    }

    private void aaH() {
        if (this.bTb != null) {
            this.bTl = this.bTb.getIntrinsicWidth();
            this.bTm = this.bTb.getIntrinsicHeight();
            return;
        }
        this.bTl = 0;
        this.bTm = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.bTb != null || this.bTa != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.bSr - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            Rect rect = this.bTi;
            int childCount = getChildCount();
            int i = this.bSe - headerViewsCount;
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
                            ExpandableHListConnector.b ir = this.bSS.ir(i4);
                            if (ir.bSM.type != i2) {
                                if (ir.bSM.type == 1) {
                                    rect.top = childAt.getTop() + this.bSY;
                                    rect.bottom = childAt.getBottom() + this.bSY;
                                } else {
                                    rect.top = childAt.getTop() + this.bSU;
                                    rect.bottom = childAt.getBottom() + this.bSU;
                                }
                                i2 = ir.bSM.type;
                            }
                            if (rect.top != rect.bottom) {
                                if (ir.bSM.type == 1) {
                                    rect.left = this.bSZ + left;
                                    rect.right = this.bSZ + right2;
                                } else {
                                    rect.left = this.bSV + left;
                                    rect.right = this.bSV + right2;
                                }
                                Drawable c2 = c(ir);
                                if (c2 != null) {
                                    if (ir.bSM.type == 1) {
                                        Gravity.apply(this.bSX, this.bTl, this.bTm, rect, this.mTempRect);
                                    } else {
                                        Gravity.apply(this.bSW, this.bTj, this.bTk, rect, this.mTempRect);
                                    }
                                    c2.setBounds(this.mTempRect);
                                    c2.draw(canvas);
                                }
                            }
                            ir.recycle();
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
        if (bVar.bSM.type == 2) {
            Drawable drawable = this.bTa;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            drawable.setState(bTf[(bVar.aaD() ? (char) 1 : (char) 0) | (bVar.bSN == null || bVar.bSN.bSH == bVar.bSN.bSG ? (char) 2 : (char) 0)]);
            return drawable;
        }
        Drawable drawable2 = this.bTb;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(bVar.bSM.bSR == bVar.bSN.bSH ? bTg : EMPTY_STATE_SET);
        }
        return drawable2;
    }

    public void setChildDivider(Drawable drawable) {
        this.bTh = drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tieba.horizonalList.widget.HListView
    public void a(Canvas canvas, Rect rect, int i) {
        int i2 = this.bSe + i;
        if (i2 >= 0) {
            ExpandableHListConnector.b ir = this.bSS.ir(iv(i2));
            if (ir.bSM.type == 1 || (ir.aaD() && ir.bSN.bSH != ir.bSN.bSG)) {
                Drawable drawable = this.bTh;
                drawable.setBounds(rect);
                drawable.draw(canvas);
                ir.recycle();
                return;
            }
            ir.recycle();
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
        this.bST = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.bSS = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.bSS = null;
        }
        super.setAdapter((ListAdapter) this.bSS);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.bST;
    }

    private boolean iu(int i) {
        return i < getHeaderViewsCount() || i >= this.bSr - getFooterViewsCount();
    }

    private int iv(int i) {
        return i - getHeaderViewsCount();
    }

    private int iw(int i) {
        return getHeaderViewsCount() + i;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.g
    public boolean performItemClick(View view, int i, long j) {
        if (iu(i)) {
            return super.performItemClick(view, i, j);
        }
        return d(view, iv(i), j);
    }

    boolean d(View view, int i, long j) {
        boolean z;
        ExpandableHListConnector.b ir = this.bSS.ir(i);
        long b2 = b(ir.bSM);
        if (ir.bSM.type == 2) {
            if (this.bTp != null && this.bTp.a(this, view, ir.bSM.bSP, b2)) {
                ir.recycle();
                return true;
            }
            if (ir.aaD()) {
                this.bSS.a(ir);
                playSoundEffect(0);
                if (this.bTn != null) {
                    this.bTn.onGroupCollapse(ir.bSM.bSP);
                }
            } else {
                this.bSS.b(ir);
                playSoundEffect(0);
                if (this.bTo != null) {
                    this.bTo.onGroupExpand(ir.bSM.bSP);
                }
                int i2 = ir.bSM.bSP;
                int headerViewsCount = ir.bSM.bSR + getHeaderViewsCount();
                smoothScrollToPosition(this.bST.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.bTq != null) {
            playSoundEffect(0);
            return this.bTq.a(this, view, ir.bSM.bSP, ir.bSM.bSQ, b2);
        } else {
            z = false;
        }
        ir.recycle();
        return z;
    }

    public void setOnGroupCollapseListener(d dVar) {
        this.bTn = dVar;
    }

    public void setOnGroupExpandListener(e eVar) {
        this.bTo = eVar;
    }

    public void setOnGroupClickListener(c cVar) {
        this.bTp = cVar;
    }

    public void setOnChildClickListener(b bVar) {
        this.bTq = bVar;
    }

    public long getExpandableListPosition(int i) {
        if (iu(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b ir = this.bSS.ir(iv(i));
        long aaE = ir.bSM.aaE();
        ir.recycle();
        return aaE;
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
            return this.bST.getGroupId(packedPositionGroup);
        }
        return this.bST.getChildId(packedPositionGroup, getPackedPositionChild(selectedPosition));
    }

    public void setSelectedGroup(int i) {
        i it = i.it(i);
        ExpandableHListConnector.b a2 = this.bSS.a(it);
        it.recycle();
        super.setSelection(iw(a2.bSM.bSR));
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
        if (iu(i)) {
            return new g.a(view, i, j);
        }
        ExpandableHListConnector.b ir = this.bSS.ir(iv(i));
        i iVar = ir.bSM;
        long b2 = b(iVar);
        long aaE = iVar.aaE();
        ir.recycle();
        return new a(view, aaE, b2);
    }

    private long b(i iVar) {
        return iVar.type == 1 ? this.bST.getChildId(iVar.bSP, iVar.bSQ) : this.bST.getGroupId(iVar.bSP);
    }

    public void setChildIndicator(Drawable drawable) {
        this.bTb = drawable;
        aaH();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.bTa = drawable;
        aaG();
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
        ArrayList<ExpandableHListConnector.GroupMetadata> bTr;

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.bTr = arrayList;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ SavedState(Parcel parcel, SavedState savedState) {
            this(parcel);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.bTr = new ArrayList<>();
            parcel.readList(this.bTr, ExpandableHListConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.bTr);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.bSS != null ? this.bSS.aaA() : null);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.bSS != null && savedState.bTr != null) {
            this.bSS.I(savedState.bTr);
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
