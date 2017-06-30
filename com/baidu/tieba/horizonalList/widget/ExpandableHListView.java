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
import com.baidu.tieba.horizonalList.widget.f;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ExpandableHListView extends HListView {
    private static final int[] EMPTY_STATE_SET = new int[0];
    private static final int[] cNQ = {16842920};
    private static final int[] cNR = {16842921};
    private static final int[] cNS = {16842920, 16842921};
    private static final int[][] cNT = {EMPTY_STATE_SET, cNQ, cNR, cNS};
    private static final int[] cNU = {16842918};
    private ExpandableHListConnector cNG;
    private ExpandableListAdapter cNH;
    private int cNI;
    private int cNJ;
    private int cNK;
    private int cNL;
    private int cNM;
    private int cNN;
    private Drawable cNO;
    private Drawable cNP;
    private Drawable cNV;
    private final Rect cNW;
    private int cNX;
    private int cNY;
    private int cNZ;
    private int cOa;
    private d cOb;
    private e cOc;
    private c cOd;
    private b cOe;
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

    private void anA() {
        if (this.cNO != null) {
            this.cNX = this.cNO.getIntrinsicWidth();
            this.cNY = this.cNO.getIntrinsicHeight();
            return;
        }
        this.cNX = 0;
        this.cNY = 0;
    }

    private void anB() {
        if (this.cNP != null) {
            this.cNZ = this.cNP.getIntrinsicWidth();
            this.cOa = this.cNP.getIntrinsicHeight();
            return;
        }
        this.cNZ = 0;
        this.cOa = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.cNP != null || this.cNO != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.mItemCount - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            Rect rect = this.cNW;
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
                            ExpandableHListConnector.b kN = this.cNG.kN(i4);
                            if (kN.cNA.type != i2) {
                                if (kN.cNA.type == 1) {
                                    rect.top = childAt.getTop() + this.cNM;
                                    rect.bottom = childAt.getBottom() + this.cNM;
                                } else {
                                    rect.top = childAt.getTop() + this.cNI;
                                    rect.bottom = childAt.getBottom() + this.cNI;
                                }
                                i2 = kN.cNA.type;
                            }
                            if (rect.top != rect.bottom) {
                                if (kN.cNA.type == 1) {
                                    rect.left = this.cNN + left;
                                    rect.right = this.cNN + right2;
                                } else {
                                    rect.left = this.cNJ + left;
                                    rect.right = this.cNJ + right2;
                                }
                                Drawable c2 = c(kN);
                                if (c2 != null) {
                                    if (kN.cNA.type == 1) {
                                        Gravity.apply(this.cNL, this.cNZ, this.cOa, rect, this.mTempRect);
                                    } else {
                                        Gravity.apply(this.cNK, this.cNX, this.cNY, rect, this.mTempRect);
                                    }
                                    c2.setBounds(this.mTempRect);
                                    c2.draw(canvas);
                                }
                            }
                            kN.recycle();
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
        if (bVar.cNA.type == 2) {
            Drawable drawable = this.cNO;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            drawable.setState(cNT[(bVar.anx() ? (char) 1 : (char) 0) | (bVar.cNB == null || bVar.cNB.cNv == bVar.cNB.cNu ? (char) 2 : (char) 0)]);
            return drawable;
        }
        Drawable drawable2 = this.cNP;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(bVar.cNA.cNF == bVar.cNB.cNv ? cNU : EMPTY_STATE_SET);
        }
        return drawable2;
    }

    public void setChildDivider(Drawable drawable) {
        this.cNV = drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tieba.horizonalList.widget.HListView
    public void drawDivider(Canvas canvas, Rect rect, int i) {
        int i2 = this.mFirstPosition + i;
        if (i2 >= 0) {
            ExpandableHListConnector.b kN = this.cNG.kN(kQ(i2));
            if (kN.cNA.type == 1 || (kN.anx() && kN.cNB.cNv != kN.cNB.cNu)) {
                Drawable drawable = this.cNV;
                drawable.setBounds(rect);
                drawable.draw(canvas);
                kN.recycle();
                return;
            }
            kN.recycle();
        }
        super.drawDivider(canvas, rect, i2);
    }

    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView
    public void setAdapter(ListAdapter listAdapter) {
        throw new RuntimeException("For ExpandableListView, use setAdapter(ExpandableListAdapter) instead of setAdapter(ListAdapter)");
    }

    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.f
    public ListAdapter getAdapter() {
        return super.getAdapter();
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public void setOnItemClickListener(f.c cVar) {
        super.setOnItemClickListener(cVar);
    }

    public void setAdapter(ExpandableListAdapter expandableListAdapter) {
        this.cNH = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.cNG = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.cNG = null;
        }
        super.setAdapter((ListAdapter) this.cNG);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.cNH;
    }

    private boolean isHeaderOrFooterPosition(int i) {
        return i < getHeaderViewsCount() || i >= this.mItemCount - getFooterViewsCount();
    }

    private int kQ(int i) {
        return i - getHeaderViewsCount();
    }

    private int kR(int i) {
        return getHeaderViewsCount() + i;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.f
    public boolean performItemClick(View view, int i, long j) {
        if (isHeaderOrFooterPosition(i)) {
            return super.performItemClick(view, i, j);
        }
        return c(view, kQ(i), j);
    }

    boolean c(View view, int i, long j) {
        boolean z;
        ExpandableHListConnector.b kN = this.cNG.kN(i);
        long b2 = b(kN.cNA);
        if (kN.cNA.type == 2) {
            if (this.cOd != null && this.cOd.a(this, view, kN.cNA.cND, b2)) {
                kN.recycle();
                return true;
            }
            if (kN.anx()) {
                this.cNG.a(kN);
                playSoundEffect(0);
                if (this.cOb != null) {
                    this.cOb.onGroupCollapse(kN.cNA.cND);
                }
            } else {
                this.cNG.b(kN);
                playSoundEffect(0);
                if (this.cOc != null) {
                    this.cOc.onGroupExpand(kN.cNA.cND);
                }
                int i2 = kN.cNA.cND;
                int headerViewsCount = kN.cNA.cNF + getHeaderViewsCount();
                smoothScrollToPosition(this.cNH.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.cOe != null) {
            playSoundEffect(0);
            return this.cOe.a(this, view, kN.cNA.cND, kN.cNA.cNE, b2);
        } else {
            z = false;
        }
        kN.recycle();
        return z;
    }

    public void setOnGroupCollapseListener(d dVar) {
        this.cOb = dVar;
    }

    public void setOnGroupExpandListener(e eVar) {
        this.cOc = eVar;
    }

    public void setOnGroupClickListener(c cVar) {
        this.cOd = cVar;
    }

    public void setOnChildClickListener(b bVar) {
        this.cOe = bVar;
    }

    public long getExpandableListPosition(int i) {
        if (isHeaderOrFooterPosition(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b kN = this.cNG.kN(kQ(i));
        long any = kN.cNA.any();
        kN.recycle();
        return any;
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
            return this.cNH.getGroupId(packedPositionGroup);
        }
        return this.cNH.getChildId(packedPositionGroup, getPackedPositionChild(selectedPosition));
    }

    public void setSelectedGroup(int i) {
        h kP = h.kP(i);
        ExpandableHListConnector.b a2 = this.cNG.a(kP);
        kP.recycle();
        super.setSelection(kR(a2.cNA.cNF));
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
            return new f.a(view, i, j);
        }
        ExpandableHListConnector.b kN = this.cNG.kN(kQ(i));
        h hVar = kN.cNA;
        long b2 = b(hVar);
        long any = hVar.any();
        kN.recycle();
        return new a(view, any, b2);
    }

    private long b(h hVar) {
        return hVar.type == 1 ? this.cNH.getChildId(hVar.cND, hVar.cNE) : this.cNH.getGroupId(hVar.cND);
    }

    public void setChildIndicator(Drawable drawable) {
        this.cNP = drawable;
        anB();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.cNO = drawable;
        anA();
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
        public static final Parcelable.Creator<SavedState> CREATOR = new i();
        ArrayList<ExpandableHListConnector.GroupMetadata> cOf;

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.cOf = arrayList;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ SavedState(Parcel parcel, SavedState savedState) {
            this(parcel);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.cOf = new ArrayList<>();
            parcel.readList(this.cOf, ExpandableHListConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.cOf);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.cNG != null ? this.cNG.anu() : null);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.cNG != null && savedState.cOf != null) {
            this.cNG.S(savedState.cOf);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.f, android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(ExpandableHListView.class.getName());
    }

    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.f, android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(ExpandableHListView.class.getName());
    }
}
