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
    private static final int[] cwK = {16842920};
    private static final int[] cwL = {16842921};
    private static final int[] cwM = {16842920, 16842921};
    private static final int[][] cwN = {EMPTY_STATE_SET, cwK, cwL, cwM};
    private static final int[] cwO = {16842918};
    private ExpandableHListConnector cwA;
    private ExpandableListAdapter cwB;
    private int cwC;
    private int cwD;
    private int cwE;
    private int cwF;
    private int cwG;
    private int cwH;
    private Drawable cwI;
    private Drawable cwJ;
    private Drawable cwP;
    private final Rect cwQ;
    private int cwR;
    private int cwS;
    private int cwT;
    private int cwU;
    private d cwV;
    private e cwW;
    private c cwX;
    private b cwY;
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

    private void akL() {
        if (this.cwI != null) {
            this.cwR = this.cwI.getIntrinsicWidth();
            this.cwS = this.cwI.getIntrinsicHeight();
            return;
        }
        this.cwR = 0;
        this.cwS = 0;
    }

    private void akM() {
        if (this.cwJ != null) {
            this.cwT = this.cwJ.getIntrinsicWidth();
            this.cwU = this.cwJ.getIntrinsicHeight();
            return;
        }
        this.cwT = 0;
        this.cwU = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.cwJ != null || this.cwI != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.cvZ - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            Rect rect = this.cwQ;
            int childCount = getChildCount();
            int i = this.cvM - headerViewsCount;
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
                            ExpandableHListConnector.b jV = this.cwA.jV(i4);
                            if (jV.cwu.type != i2) {
                                if (jV.cwu.type == 1) {
                                    rect.top = childAt.getTop() + this.cwG;
                                    rect.bottom = childAt.getBottom() + this.cwG;
                                } else {
                                    rect.top = childAt.getTop() + this.cwC;
                                    rect.bottom = childAt.getBottom() + this.cwC;
                                }
                                i2 = jV.cwu.type;
                            }
                            if (rect.top != rect.bottom) {
                                if (jV.cwu.type == 1) {
                                    rect.left = this.cwH + left;
                                    rect.right = this.cwH + right2;
                                } else {
                                    rect.left = this.cwD + left;
                                    rect.right = this.cwD + right2;
                                }
                                Drawable c2 = c(jV);
                                if (c2 != null) {
                                    if (jV.cwu.type == 1) {
                                        Gravity.apply(this.cwF, this.cwT, this.cwU, rect, this.mTempRect);
                                    } else {
                                        Gravity.apply(this.cwE, this.cwR, this.cwS, rect, this.mTempRect);
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
        if (bVar.cwu.type == 2) {
            Drawable drawable = this.cwI;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            drawable.setState(cwN[(bVar.akI() ? (char) 1 : (char) 0) | (bVar.cwv == null || bVar.cwv.cwp == bVar.cwv.cwo ? (char) 2 : (char) 0)]);
            return drawable;
        }
        Drawable drawable2 = this.cwJ;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(bVar.cwu.cwz == bVar.cwv.cwp ? cwO : EMPTY_STATE_SET);
        }
        return drawable2;
    }

    public void setChildDivider(Drawable drawable) {
        this.cwP = drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tieba.horizonalList.widget.HListView
    public void a(Canvas canvas, Rect rect, int i) {
        int i2 = this.cvM + i;
        if (i2 >= 0) {
            ExpandableHListConnector.b jV = this.cwA.jV(jZ(i2));
            if (jV.cwu.type == 1 || (jV.akI() && jV.cwv.cwp != jV.cwv.cwo)) {
                Drawable drawable = this.cwP;
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
        this.cwB = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.cwA = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.cwA = null;
        }
        super.setAdapter((ListAdapter) this.cwA);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.cwB;
    }

    private boolean jY(int i) {
        return i < getHeaderViewsCount() || i >= this.cvZ - getFooterViewsCount();
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
        ExpandableHListConnector.b jV = this.cwA.jV(i);
        long b2 = b(jV.cwu);
        if (jV.cwu.type == 2) {
            if (this.cwX != null && this.cwX.a(this, view, jV.cwu.cwx, b2)) {
                jV.recycle();
                return true;
            }
            if (jV.akI()) {
                this.cwA.a(jV);
                playSoundEffect(0);
                if (this.cwV != null) {
                    this.cwV.onGroupCollapse(jV.cwu.cwx);
                }
            } else {
                this.cwA.b(jV);
                playSoundEffect(0);
                if (this.cwW != null) {
                    this.cwW.onGroupExpand(jV.cwu.cwx);
                }
                int i2 = jV.cwu.cwx;
                int headerViewsCount = jV.cwu.cwz + getHeaderViewsCount();
                smoothScrollToPosition(this.cwB.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.cwY != null) {
            playSoundEffect(0);
            return this.cwY.a(this, view, jV.cwu.cwx, jV.cwu.cwy, b2);
        } else {
            z = false;
        }
        jV.recycle();
        return z;
    }

    public void setOnGroupCollapseListener(d dVar) {
        this.cwV = dVar;
    }

    public void setOnGroupExpandListener(e eVar) {
        this.cwW = eVar;
    }

    public void setOnGroupClickListener(c cVar) {
        this.cwX = cVar;
    }

    public void setOnChildClickListener(b bVar) {
        this.cwY = bVar;
    }

    public long getExpandableListPosition(int i) {
        if (jY(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b jV = this.cwA.jV(jZ(i));
        long akJ = jV.cwu.akJ();
        jV.recycle();
        return akJ;
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
            return this.cwB.getGroupId(packedPositionGroup);
        }
        return this.cwB.getChildId(packedPositionGroup, getPackedPositionChild(selectedPosition));
    }

    public void setSelectedGroup(int i) {
        i jX = i.jX(i);
        ExpandableHListConnector.b a2 = this.cwA.a(jX);
        jX.recycle();
        super.setSelection(ka(a2.cwu.cwz));
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
        ExpandableHListConnector.b jV = this.cwA.jV(jZ(i));
        i iVar = jV.cwu;
        long b2 = b(iVar);
        long akJ = iVar.akJ();
        jV.recycle();
        return new a(view, akJ, b2);
    }

    private long b(i iVar) {
        return iVar.type == 1 ? this.cwB.getChildId(iVar.cwx, iVar.cwy) : this.cwB.getGroupId(iVar.cwx);
    }

    public void setChildIndicator(Drawable drawable) {
        this.cwJ = drawable;
        akM();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.cwI = drawable;
        akL();
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
        ArrayList<ExpandableHListConnector.GroupMetadata> cwZ;

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.cwZ = arrayList;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ SavedState(Parcel parcel, SavedState savedState) {
            this(parcel);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.cwZ = new ArrayList<>();
            parcel.readList(this.cwZ, ExpandableHListConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.cwZ);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.cwA != null ? this.cwA.akF() : null);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.cwA != null && savedState.cwZ != null) {
            this.cwA.O(savedState.cwZ);
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
