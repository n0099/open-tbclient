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
    private static final int[] cRD = {16842920};
    private static final int[] cRE = {16842921};
    private static final int[] cRF = {16842920, 16842921};
    private static final int[][] cRG = {EMPTY_STATE_SET, cRD, cRE, cRF};
    private static final int[] cRH = {16842918};
    private int cRA;
    private Drawable cRB;
    private Drawable cRC;
    private Drawable cRI;
    private final Rect cRJ;
    private int cRK;
    private int cRL;
    private int cRM;
    private int cRN;
    private d cRO;
    private e cRP;
    private c cRQ;
    private b cRR;
    private ExpandableHListConnector cRt;
    private ExpandableListAdapter cRu;
    private int cRv;
    private int cRw;
    private int cRx;
    private int cRy;
    private int cRz;
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

    private void aqj() {
        if (this.cRB != null) {
            this.cRK = this.cRB.getIntrinsicWidth();
            this.cRL = this.cRB.getIntrinsicHeight();
            return;
        }
        this.cRK = 0;
        this.cRL = 0;
    }

    private void aqk() {
        if (this.cRC != null) {
            this.cRM = this.cRC.getIntrinsicWidth();
            this.cRN = this.cRC.getIntrinsicHeight();
            return;
        }
        this.cRM = 0;
        this.cRN = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.cRC != null || this.cRB != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.cQS - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            Rect rect = this.cRJ;
            int childCount = getChildCount();
            int i = this.bAH - headerViewsCount;
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
                            ExpandableHListConnector.b kL = this.cRt.kL(i4);
                            if (kL.cRn.type != i2) {
                                if (kL.cRn.type == 1) {
                                    rect.top = childAt.getTop() + this.cRz;
                                    rect.bottom = childAt.getBottom() + this.cRz;
                                } else {
                                    rect.top = childAt.getTop() + this.cRv;
                                    rect.bottom = childAt.getBottom() + this.cRv;
                                }
                                i2 = kL.cRn.type;
                            }
                            if (rect.top != rect.bottom) {
                                if (kL.cRn.type == 1) {
                                    rect.left = this.cRA + left;
                                    rect.right = this.cRA + right2;
                                } else {
                                    rect.left = this.cRw + left;
                                    rect.right = this.cRw + right2;
                                }
                                Drawable c2 = c(kL);
                                if (c2 != null) {
                                    if (kL.cRn.type == 1) {
                                        Gravity.apply(this.cRy, this.cRM, this.cRN, rect, this.mTempRect);
                                    } else {
                                        Gravity.apply(this.cRx, this.cRK, this.cRL, rect, this.mTempRect);
                                    }
                                    c2.setBounds(this.mTempRect);
                                    c2.draw(canvas);
                                }
                            }
                            kL.recycle();
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
        if (bVar.cRn.type == 2) {
            Drawable drawable = this.cRB;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            drawable.setState(cRG[(bVar.aqg() ? (char) 1 : (char) 0) | (bVar.cRo == null || bVar.cRo.cRi == bVar.cRo.cRh ? (char) 2 : (char) 0)]);
            return drawable;
        }
        Drawable drawable2 = this.cRC;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(bVar.cRn.cRs == bVar.cRo.cRi ? cRH : EMPTY_STATE_SET);
        }
        return drawable2;
    }

    public void setChildDivider(Drawable drawable) {
        this.cRI = drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tieba.horizonalList.widget.HListView
    public void a(Canvas canvas, Rect rect, int i) {
        int i2 = this.bAH + i;
        if (i2 >= 0) {
            ExpandableHListConnector.b kL = this.cRt.kL(kP(i2));
            if (kL.cRn.type == 1 || (kL.aqg() && kL.cRo.cRi != kL.cRo.cRh)) {
                Drawable drawable = this.cRI;
                drawable.setBounds(rect);
                drawable.draw(canvas);
                kL.recycle();
                return;
            }
            kL.recycle();
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
        this.cRu = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.cRt = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.cRt = null;
        }
        super.setAdapter((ListAdapter) this.cRt);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.cRu;
    }

    private boolean kO(int i) {
        return i < getHeaderViewsCount() || i >= this.cQS - getFooterViewsCount();
    }

    private int kP(int i) {
        return i - getHeaderViewsCount();
    }

    private int kQ(int i) {
        return getHeaderViewsCount() + i;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.g
    public boolean performItemClick(View view, int i, long j) {
        if (kO(i)) {
            return super.performItemClick(view, i, j);
        }
        return d(view, kP(i), j);
    }

    boolean d(View view, int i, long j) {
        boolean z;
        ExpandableHListConnector.b kL = this.cRt.kL(i);
        long b2 = b(kL.cRn);
        if (kL.cRn.type == 2) {
            if (this.cRQ != null && this.cRQ.a(this, view, kL.cRn.cRq, b2)) {
                kL.recycle();
                return true;
            }
            if (kL.aqg()) {
                this.cRt.a(kL);
                playSoundEffect(0);
                if (this.cRO != null) {
                    this.cRO.onGroupCollapse(kL.cRn.cRq);
                }
            } else {
                this.cRt.b(kL);
                playSoundEffect(0);
                if (this.cRP != null) {
                    this.cRP.onGroupExpand(kL.cRn.cRq);
                }
                int i2 = kL.cRn.cRq;
                int headerViewsCount = kL.cRn.cRs + getHeaderViewsCount();
                smoothScrollToPosition(this.cRu.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.cRR != null) {
            playSoundEffect(0);
            return this.cRR.a(this, view, kL.cRn.cRq, kL.cRn.cRr, b2);
        } else {
            z = false;
        }
        kL.recycle();
        return z;
    }

    public void setOnGroupCollapseListener(d dVar) {
        this.cRO = dVar;
    }

    public void setOnGroupExpandListener(e eVar) {
        this.cRP = eVar;
    }

    public void setOnGroupClickListener(c cVar) {
        this.cRQ = cVar;
    }

    public void setOnChildClickListener(b bVar) {
        this.cRR = bVar;
    }

    public long getExpandableListPosition(int i) {
        if (kO(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b kL = this.cRt.kL(kP(i));
        long aqh = kL.cRn.aqh();
        kL.recycle();
        return aqh;
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
            return this.cRu.getGroupId(packedPositionGroup);
        }
        return this.cRu.getChildId(packedPositionGroup, getPackedPositionChild(selectedPosition));
    }

    public void setSelectedGroup(int i) {
        i kN = i.kN(i);
        ExpandableHListConnector.b a2 = this.cRt.a(kN);
        kN.recycle();
        super.setSelection(kQ(a2.cRn.cRs));
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
        if (kO(i)) {
            return new g.a(view, i, j);
        }
        ExpandableHListConnector.b kL = this.cRt.kL(kP(i));
        i iVar = kL.cRn;
        long b2 = b(iVar);
        long aqh = iVar.aqh();
        kL.recycle();
        return new a(view, aqh, b2);
    }

    private long b(i iVar) {
        return iVar.type == 1 ? this.cRu.getChildId(iVar.cRq, iVar.cRr) : this.cRu.getGroupId(iVar.cRq);
    }

    public void setChildIndicator(Drawable drawable) {
        this.cRC = drawable;
        aqk();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.cRB = drawable;
        aqj();
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
        ArrayList<ExpandableHListConnector.GroupMetadata> cRS;

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.cRS = arrayList;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ SavedState(Parcel parcel, SavedState savedState) {
            this(parcel);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.cRS = new ArrayList<>();
            parcel.readList(this.cRS, ExpandableHListConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.cRS);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.cRt != null ? this.cRt.aqd() : null);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.cRt != null && savedState.cRS != null) {
            this.cRt.X(savedState.cRS);
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
