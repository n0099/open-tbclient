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
    private static final int[] cDO = {16842920};
    private static final int[] cDP = {16842921};
    private static final int[] cDQ = {16842920, 16842921};
    private static final int[][] cDR = {EMPTY_STATE_SET, cDO, cDP, cDQ};
    private static final int[] cDS = {16842918};
    private ExpandableHListConnector cDE;
    private ExpandableListAdapter cDF;
    private int cDG;
    private int cDH;
    private int cDI;
    private int cDJ;
    private int cDK;
    private int cDL;
    private Drawable cDM;
    private Drawable cDN;
    private Drawable cDT;
    private final Rect cDU;
    private int cDV;
    private int cDW;
    private int cDX;
    private int cDY;
    private d cDZ;
    private e cEa;
    private c cEb;
    private b cEc;
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

    private void alS() {
        if (this.cDM != null) {
            this.cDV = this.cDM.getIntrinsicWidth();
            this.cDW = this.cDM.getIntrinsicHeight();
            return;
        }
        this.cDV = 0;
        this.cDW = 0;
    }

    private void alT() {
        if (this.cDN != null) {
            this.cDX = this.cDN.getIntrinsicWidth();
            this.cDY = this.cDN.getIntrinsicHeight();
            return;
        }
        this.cDX = 0;
        this.cDY = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.cDN != null || this.cDM != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.cDd - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            Rect rect = this.cDU;
            int childCount = getChildCount();
            int i = this.cCQ - headerViewsCount;
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
                            ExpandableHListConnector.b kI = this.cDE.kI(i4);
                            if (kI.cDy.type != i2) {
                                if (kI.cDy.type == 1) {
                                    rect.top = childAt.getTop() + this.cDK;
                                    rect.bottom = childAt.getBottom() + this.cDK;
                                } else {
                                    rect.top = childAt.getTop() + this.cDG;
                                    rect.bottom = childAt.getBottom() + this.cDG;
                                }
                                i2 = kI.cDy.type;
                            }
                            if (rect.top != rect.bottom) {
                                if (kI.cDy.type == 1) {
                                    rect.left = this.cDL + left;
                                    rect.right = this.cDL + right2;
                                } else {
                                    rect.left = this.cDH + left;
                                    rect.right = this.cDH + right2;
                                }
                                Drawable c2 = c(kI);
                                if (c2 != null) {
                                    if (kI.cDy.type == 1) {
                                        Gravity.apply(this.cDJ, this.cDX, this.cDY, rect, this.mTempRect);
                                    } else {
                                        Gravity.apply(this.cDI, this.cDV, this.cDW, rect, this.mTempRect);
                                    }
                                    c2.setBounds(this.mTempRect);
                                    c2.draw(canvas);
                                }
                            }
                            kI.recycle();
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
        if (bVar.cDy.type == 2) {
            Drawable drawable = this.cDM;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            drawable.setState(cDR[(bVar.alP() ? (char) 1 : (char) 0) | (bVar.cDz == null || bVar.cDz.cDt == bVar.cDz.cDs ? (char) 2 : (char) 0)]);
            return drawable;
        }
        Drawable drawable2 = this.cDN;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(bVar.cDy.cDD == bVar.cDz.cDt ? cDS : EMPTY_STATE_SET);
        }
        return drawable2;
    }

    public void setChildDivider(Drawable drawable) {
        this.cDT = drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tieba.horizonalList.widget.HListView
    public void a(Canvas canvas, Rect rect, int i) {
        int i2 = this.cCQ + i;
        if (i2 >= 0) {
            ExpandableHListConnector.b kI = this.cDE.kI(kM(i2));
            if (kI.cDy.type == 1 || (kI.alP() && kI.cDz.cDt != kI.cDz.cDs)) {
                Drawable drawable = this.cDT;
                drawable.setBounds(rect);
                drawable.draw(canvas);
                kI.recycle();
                return;
            }
            kI.recycle();
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
        this.cDF = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.cDE = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.cDE = null;
        }
        super.setAdapter((ListAdapter) this.cDE);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.cDF;
    }

    private boolean kL(int i) {
        return i < getHeaderViewsCount() || i >= this.cDd - getFooterViewsCount();
    }

    private int kM(int i) {
        return i - getHeaderViewsCount();
    }

    private int kN(int i) {
        return getHeaderViewsCount() + i;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.g
    public boolean performItemClick(View view, int i, long j) {
        if (kL(i)) {
            return super.performItemClick(view, i, j);
        }
        return d(view, kM(i), j);
    }

    boolean d(View view, int i, long j) {
        boolean z;
        ExpandableHListConnector.b kI = this.cDE.kI(i);
        long b2 = b(kI.cDy);
        if (kI.cDy.type == 2) {
            if (this.cEb != null && this.cEb.a(this, view, kI.cDy.cDB, b2)) {
                kI.recycle();
                return true;
            }
            if (kI.alP()) {
                this.cDE.a(kI);
                playSoundEffect(0);
                if (this.cDZ != null) {
                    this.cDZ.onGroupCollapse(kI.cDy.cDB);
                }
            } else {
                this.cDE.b(kI);
                playSoundEffect(0);
                if (this.cEa != null) {
                    this.cEa.onGroupExpand(kI.cDy.cDB);
                }
                int i2 = kI.cDy.cDB;
                int headerViewsCount = kI.cDy.cDD + getHeaderViewsCount();
                smoothScrollToPosition(this.cDF.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.cEc != null) {
            playSoundEffect(0);
            return this.cEc.a(this, view, kI.cDy.cDB, kI.cDy.cDC, b2);
        } else {
            z = false;
        }
        kI.recycle();
        return z;
    }

    public void setOnGroupCollapseListener(d dVar) {
        this.cDZ = dVar;
    }

    public void setOnGroupExpandListener(e eVar) {
        this.cEa = eVar;
    }

    public void setOnGroupClickListener(c cVar) {
        this.cEb = cVar;
    }

    public void setOnChildClickListener(b bVar) {
        this.cEc = bVar;
    }

    public long getExpandableListPosition(int i) {
        if (kL(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b kI = this.cDE.kI(kM(i));
        long alQ = kI.cDy.alQ();
        kI.recycle();
        return alQ;
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
            return this.cDF.getGroupId(packedPositionGroup);
        }
        return this.cDF.getChildId(packedPositionGroup, getPackedPositionChild(selectedPosition));
    }

    public void setSelectedGroup(int i) {
        i kK = i.kK(i);
        ExpandableHListConnector.b a2 = this.cDE.a(kK);
        kK.recycle();
        super.setSelection(kN(a2.cDy.cDD));
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
        if (kL(i)) {
            return new g.a(view, i, j);
        }
        ExpandableHListConnector.b kI = this.cDE.kI(kM(i));
        i iVar = kI.cDy;
        long b2 = b(iVar);
        long alQ = iVar.alQ();
        kI.recycle();
        return new a(view, alQ, b2);
    }

    private long b(i iVar) {
        return iVar.type == 1 ? this.cDF.getChildId(iVar.cDB, iVar.cDC) : this.cDF.getGroupId(iVar.cDB);
    }

    public void setChildIndicator(Drawable drawable) {
        this.cDN = drawable;
        alT();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.cDM = drawable;
        alS();
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
        ArrayList<ExpandableHListConnector.GroupMetadata> cEd;

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.cEd = arrayList;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ SavedState(Parcel parcel, SavedState savedState) {
            this(parcel);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.cEd = new ArrayList<>();
            parcel.readList(this.cEd, ExpandableHListConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.cEd);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.cDE != null ? this.cDE.alM() : null);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.cDE != null && savedState.cEd != null) {
            this.cDE.Q(savedState.cEd);
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
