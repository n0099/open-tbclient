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
    private static final int[] czR = {16842920};
    private static final int[] czS = {16842921};
    private static final int[] czT = {16842920, 16842921};
    private static final int[][] czU = {EMPTY_STATE_SET, czR, czS, czT};
    private static final int[] czV = {16842918};
    private int cAa;
    private int cAb;
    private d cAc;
    private e cAd;
    private c cAe;
    private b cAf;
    private ExpandableHListConnector czH;
    private ExpandableListAdapter czI;
    private int czJ;
    private int czK;
    private int czL;
    private int czM;
    private int czN;
    private int czO;
    private Drawable czP;
    private Drawable czQ;
    private Drawable czW;
    private final Rect czX;
    private int czY;
    private int czZ;
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

    private void ajn() {
        if (this.czP != null) {
            this.czY = this.czP.getIntrinsicWidth();
            this.czZ = this.czP.getIntrinsicHeight();
            return;
        }
        this.czY = 0;
        this.czZ = 0;
    }

    private void ajo() {
        if (this.czQ != null) {
            this.cAa = this.czQ.getIntrinsicWidth();
            this.cAb = this.czQ.getIntrinsicHeight();
            return;
        }
        this.cAa = 0;
        this.cAb = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.czQ != null || this.czP != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.czg - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            Rect rect = this.czX;
            int childCount = getChildCount();
            int i = this.bml - headerViewsCount;
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
                            ExpandableHListConnector.b jV = this.czH.jV(i4);
                            if (jV.czB.type != i2) {
                                if (jV.czB.type == 1) {
                                    rect.top = childAt.getTop() + this.czN;
                                    rect.bottom = childAt.getBottom() + this.czN;
                                } else {
                                    rect.top = childAt.getTop() + this.czJ;
                                    rect.bottom = childAt.getBottom() + this.czJ;
                                }
                                i2 = jV.czB.type;
                            }
                            if (rect.top != rect.bottom) {
                                if (jV.czB.type == 1) {
                                    rect.left = this.czO + left;
                                    rect.right = this.czO + right2;
                                } else {
                                    rect.left = this.czK + left;
                                    rect.right = this.czK + right2;
                                }
                                Drawable c2 = c(jV);
                                if (c2 != null) {
                                    if (jV.czB.type == 1) {
                                        Gravity.apply(this.czM, this.cAa, this.cAb, rect, this.mTempRect);
                                    } else {
                                        Gravity.apply(this.czL, this.czY, this.czZ, rect, this.mTempRect);
                                    }
                                    c2.setBounds(this.mTempRect);
                                    c2.draw(canvas);
                                }
                            }
                            jV.recycle();
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
        if (bVar.czB.type == 2) {
            Drawable drawable = this.czP;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            drawable.setState(czU[(bVar.ajk() ? (char) 1 : (char) 0) | (bVar.czC == null || bVar.czC.czw == bVar.czC.czv ? (char) 2 : (char) 0)]);
            return drawable;
        }
        Drawable drawable2 = this.czQ;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(bVar.czB.czG == bVar.czC.czw ? czV : EMPTY_STATE_SET);
        }
        return drawable2;
    }

    public void setChildDivider(Drawable drawable) {
        this.czW = drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tieba.horizonalList.widget.HListView
    public void a(Canvas canvas, Rect rect, int i) {
        int i2 = this.bml + i;
        if (i2 >= 0) {
            ExpandableHListConnector.b jV = this.czH.jV(jZ(i2));
            if (jV.czB.type == 1 || (jV.ajk() && jV.czC.czw != jV.czC.czv)) {
                Drawable drawable = this.czW;
                drawable.setBounds(rect);
                drawable.draw(canvas);
                jV.recycle();
                return;
            }
            jV.recycle();
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
        this.czI = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.czH = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.czH = null;
        }
        super.setAdapter((ListAdapter) this.czH);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.czI;
    }

    private boolean jY(int i) {
        return i < getHeaderViewsCount() || i >= this.czg - getFooterViewsCount();
    }

    private int jZ(int i) {
        return i - getHeaderViewsCount();
    }

    private int ka(int i) {
        return getHeaderViewsCount() + i;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.g
    public boolean performItemClick(View view, int i, long j) {
        if (jY(i)) {
            return super.performItemClick(view, i, j);
        }
        return d(view, jZ(i), j);
    }

    boolean d(View view, int i, long j) {
        boolean z;
        ExpandableHListConnector.b jV = this.czH.jV(i);
        long b2 = b(jV.czB);
        if (jV.czB.type == 2) {
            if (this.cAe != null && this.cAe.a(this, view, jV.czB.czE, b2)) {
                jV.recycle();
                return true;
            }
            if (jV.ajk()) {
                this.czH.a(jV);
                playSoundEffect(0);
                if (this.cAc != null) {
                    this.cAc.onGroupCollapse(jV.czB.czE);
                }
            } else {
                this.czH.b(jV);
                playSoundEffect(0);
                if (this.cAd != null) {
                    this.cAd.onGroupExpand(jV.czB.czE);
                }
                int i2 = jV.czB.czE;
                int headerViewsCount = jV.czB.czG + getHeaderViewsCount();
                smoothScrollToPosition(this.czI.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.cAf != null) {
            playSoundEffect(0);
            return this.cAf.a(this, view, jV.czB.czE, jV.czB.czF, b2);
        } else {
            z = false;
        }
        jV.recycle();
        return z;
    }

    public void setOnGroupCollapseListener(d dVar) {
        this.cAc = dVar;
    }

    public void setOnGroupExpandListener(e eVar) {
        this.cAd = eVar;
    }

    public void setOnGroupClickListener(c cVar) {
        this.cAe = cVar;
    }

    public void setOnChildClickListener(b bVar) {
        this.cAf = bVar;
    }

    public long getExpandableListPosition(int i) {
        if (jY(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b jV = this.czH.jV(jZ(i));
        long ajl = jV.czB.ajl();
        jV.recycle();
        return ajl;
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
            return this.czI.getGroupId(packedPositionGroup);
        }
        return this.czI.getChildId(packedPositionGroup, getPackedPositionChild(selectedPosition));
    }

    public void setSelectedGroup(int i) {
        i jX = i.jX(i);
        ExpandableHListConnector.b a2 = this.czH.a(jX);
        jX.recycle();
        super.setSelection(ka(a2.czB.czG));
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
        if (jY(i)) {
            return new g.a(view, i, j);
        }
        ExpandableHListConnector.b jV = this.czH.jV(jZ(i));
        i iVar = jV.czB;
        long b2 = b(iVar);
        long ajl = iVar.ajl();
        jV.recycle();
        return new a(view, ajl, b2);
    }

    private long b(i iVar) {
        return iVar.type == 1 ? this.czI.getChildId(iVar.czE, iVar.czF) : this.czI.getGroupId(iVar.czE);
    }

    public void setChildIndicator(Drawable drawable) {
        this.czQ = drawable;
        ajo();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.czP = drawable;
        ajn();
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
        ArrayList<ExpandableHListConnector.GroupMetadata> cAg;

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.cAg = arrayList;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ SavedState(Parcel parcel, SavedState savedState) {
            this(parcel);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.cAg = new ArrayList<>();
            parcel.readList(this.cAg, ExpandableHListConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.cAg);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.czH != null ? this.czH.ajh() : null);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.czH != null && savedState.cAg != null) {
            this.czH.U(savedState.cAg);
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
