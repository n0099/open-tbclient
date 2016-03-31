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
    private static final int[] bSB = {16842920};
    private static final int[] bSC = {16842921};
    private static final int[] bSD = {16842920, 16842921};
    private static final int[][] bSE = {EMPTY_STATE_SET, bSB, bSC, bSD};
    private static final int[] bSF = {16842918};
    private Drawable bSA;
    private Drawable bSG;
    private final Rect bSH;
    private int bSI;
    private int bSJ;
    private int bSK;
    private int bSL;
    private d bSM;
    private e bSN;
    private c bSO;
    private b bSP;
    private ExpandableHListConnector bSr;
    private ExpandableListAdapter bSs;
    private int bSt;
    private int bSu;
    private int bSv;
    private int bSw;
    private int bSx;
    private int bSy;
    private Drawable bSz;
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

    private void aaH() {
        if (this.bSz != null) {
            this.bSI = this.bSz.getIntrinsicWidth();
            this.bSJ = this.bSz.getIntrinsicHeight();
            return;
        }
        this.bSI = 0;
        this.bSJ = 0;
    }

    private void aaI() {
        if (this.bSA != null) {
            this.bSK = this.bSA.getIntrinsicWidth();
            this.bSL = this.bSA.getIntrinsicHeight();
            return;
        }
        this.bSK = 0;
        this.bSL = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.bSA != null || this.bSz != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.bRQ - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            Rect rect = this.bSH;
            int childCount = getChildCount();
            int i = this.bRD - headerViewsCount;
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
                            ExpandableHListConnector.b iO = this.bSr.iO(i4);
                            if (iO.bSl.type != i2) {
                                if (iO.bSl.type == 1) {
                                    rect.top = childAt.getTop() + this.bSx;
                                    rect.bottom = childAt.getBottom() + this.bSx;
                                } else {
                                    rect.top = childAt.getTop() + this.bSt;
                                    rect.bottom = childAt.getBottom() + this.bSt;
                                }
                                i2 = iO.bSl.type;
                            }
                            if (rect.top != rect.bottom) {
                                if (iO.bSl.type == 1) {
                                    rect.left = this.bSy + left;
                                    rect.right = this.bSy + right2;
                                } else {
                                    rect.left = this.bSu + left;
                                    rect.right = this.bSu + right2;
                                }
                                Drawable c2 = c(iO);
                                if (c2 != null) {
                                    if (iO.bSl.type == 1) {
                                        Gravity.apply(this.bSw, this.bSK, this.bSL, rect, this.mTempRect);
                                    } else {
                                        Gravity.apply(this.bSv, this.bSI, this.bSJ, rect, this.mTempRect);
                                    }
                                    c2.setBounds(this.mTempRect);
                                    c2.draw(canvas);
                                }
                            }
                            iO.recycle();
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
        if (bVar.bSl.type == 2) {
            Drawable drawable = this.bSz;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            drawable.setState(bSE[(bVar.aaE() ? (char) 1 : (char) 0) | (bVar.bSm == null || bVar.bSm.bSg == bVar.bSm.bSf ? (char) 2 : (char) 0)]);
            return drawable;
        }
        Drawable drawable2 = this.bSA;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(bVar.bSl.bSq == bVar.bSm.bSg ? bSF : EMPTY_STATE_SET);
        }
        return drawable2;
    }

    public void setChildDivider(Drawable drawable) {
        this.bSG = drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tieba.horizonalList.widget.HListView
    public void a(Canvas canvas, Rect rect, int i) {
        int i2 = this.bRD + i;
        if (i2 >= 0) {
            ExpandableHListConnector.b iO = this.bSr.iO(iS(i2));
            if (iO.bSl.type == 1 || (iO.aaE() && iO.bSm.bSg != iO.bSm.bSf)) {
                Drawable drawable = this.bSG;
                drawable.setBounds(rect);
                drawable.draw(canvas);
                iO.recycle();
                return;
            }
            iO.recycle();
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
        this.bSs = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.bSr = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.bSr = null;
        }
        super.setAdapter((ListAdapter) this.bSr);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.bSs;
    }

    private boolean iR(int i) {
        return i < getHeaderViewsCount() || i >= this.bRQ - getFooterViewsCount();
    }

    private int iS(int i) {
        return i - getHeaderViewsCount();
    }

    private int iT(int i) {
        return getHeaderViewsCount() + i;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.g
    public boolean performItemClick(View view, int i, long j) {
        if (iR(i)) {
            return super.performItemClick(view, i, j);
        }
        return d(view, iS(i), j);
    }

    boolean d(View view, int i, long j) {
        boolean z;
        ExpandableHListConnector.b iO = this.bSr.iO(i);
        long b2 = b(iO.bSl);
        if (iO.bSl.type == 2) {
            if (this.bSO != null && this.bSO.a(this, view, iO.bSl.bSo, b2)) {
                iO.recycle();
                return true;
            }
            if (iO.aaE()) {
                this.bSr.a(iO);
                playSoundEffect(0);
                if (this.bSM != null) {
                    this.bSM.onGroupCollapse(iO.bSl.bSo);
                }
            } else {
                this.bSr.b(iO);
                playSoundEffect(0);
                if (this.bSN != null) {
                    this.bSN.onGroupExpand(iO.bSl.bSo);
                }
                int i2 = iO.bSl.bSo;
                int headerViewsCount = iO.bSl.bSq + getHeaderViewsCount();
                smoothScrollToPosition(this.bSs.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.bSP != null) {
            playSoundEffect(0);
            return this.bSP.a(this, view, iO.bSl.bSo, iO.bSl.bSp, b2);
        } else {
            z = false;
        }
        iO.recycle();
        return z;
    }

    public void setOnGroupCollapseListener(d dVar) {
        this.bSM = dVar;
    }

    public void setOnGroupExpandListener(e eVar) {
        this.bSN = eVar;
    }

    public void setOnGroupClickListener(c cVar) {
        this.bSO = cVar;
    }

    public void setOnChildClickListener(b bVar) {
        this.bSP = bVar;
    }

    public long getExpandableListPosition(int i) {
        if (iR(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b iO = this.bSr.iO(iS(i));
        long aaF = iO.bSl.aaF();
        iO.recycle();
        return aaF;
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
            return this.bSs.getGroupId(packedPositionGroup);
        }
        return this.bSs.getChildId(packedPositionGroup, getPackedPositionChild(selectedPosition));
    }

    public void setSelectedGroup(int i) {
        i iQ = i.iQ(i);
        ExpandableHListConnector.b a2 = this.bSr.a(iQ);
        iQ.recycle();
        super.setSelection(iT(a2.bSl.bSq));
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
        if (iR(i)) {
            return new g.a(view, i, j);
        }
        ExpandableHListConnector.b iO = this.bSr.iO(iS(i));
        i iVar = iO.bSl;
        long b2 = b(iVar);
        long aaF = iVar.aaF();
        iO.recycle();
        return new a(view, aaF, b2);
    }

    private long b(i iVar) {
        return iVar.type == 1 ? this.bSs.getChildId(iVar.bSo, iVar.bSp) : this.bSs.getGroupId(iVar.bSo);
    }

    public void setChildIndicator(Drawable drawable) {
        this.bSA = drawable;
        aaI();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.bSz = drawable;
        aaH();
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
        ArrayList<ExpandableHListConnector.GroupMetadata> bSQ;

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.bSQ = arrayList;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ SavedState(Parcel parcel, SavedState savedState) {
            this(parcel);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.bSQ = new ArrayList<>();
            parcel.readList(this.bSQ, ExpandableHListConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.bSQ);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.bSr != null ? this.bSr.aaB() : null);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.bSr != null && savedState.bSQ != null) {
            this.bSr.H(savedState.bSQ);
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
