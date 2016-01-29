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
public class ExpandableHListView extends k {
    private static final int[] EMPTY_STATE_SET = new int[0];
    private static final int[] bIe = {16842920};
    private static final int[] bIf = {16842921};
    private static final int[] bIg = {16842920, 16842921};
    private static final int[][] bIh = {EMPTY_STATE_SET, bIe, bIf, bIg};
    private static final int[] bIi = {16842918};
    private ExpandableHListConnector bHU;
    private ExpandableListAdapter bHV;
    private int bHW;
    private int bHX;
    private int bHY;
    private int bHZ;
    private int bIa;
    private int bIb;
    private Drawable bIc;
    private Drawable bId;
    private Drawable bIj;
    private final Rect bIk;
    private int bIl;
    private int bIm;
    private int bIn;
    private int bIo;
    private d bIp;
    private e bIq;
    private c bIr;
    private b bIs;
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

    private void Xh() {
        if (this.bIc != null) {
            this.bIl = this.bIc.getIntrinsicWidth();
            this.bIm = this.bIc.getIntrinsicHeight();
            return;
        }
        this.bIl = 0;
        this.bIm = 0;
    }

    private void Xi() {
        if (this.bId != null) {
            this.bIn = this.bId.getIntrinsicWidth();
            this.bIo = this.bId.getIntrinsicHeight();
            return;
        }
        this.bIn = 0;
        this.bIo = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.k, com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.bId != null || this.bIc != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.bHt - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            Rect rect = this.bIk;
            int childCount = getChildCount();
            int i = this.bHg - headerViewsCount;
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
                            ExpandableHListConnector.b ig = this.bHU.ig(i4);
                            if (ig.bHO.type != i2) {
                                if (ig.bHO.type == 1) {
                                    rect.top = childAt.getTop() + this.bIa;
                                    rect.bottom = childAt.getBottom() + this.bIa;
                                } else {
                                    rect.top = childAt.getTop() + this.bHW;
                                    rect.bottom = childAt.getBottom() + this.bHW;
                                }
                                i2 = ig.bHO.type;
                            }
                            if (rect.top != rect.bottom) {
                                if (ig.bHO.type == 1) {
                                    rect.left = this.bIb + left;
                                    rect.right = this.bIb + right2;
                                } else {
                                    rect.left = this.bHX + left;
                                    rect.right = this.bHX + right2;
                                }
                                Drawable c2 = c(ig);
                                if (c2 != null) {
                                    if (ig.bHO.type == 1) {
                                        Gravity.apply(this.bHZ, this.bIn, this.bIo, rect, this.mTempRect);
                                    } else {
                                        Gravity.apply(this.bHY, this.bIl, this.bIm, rect, this.mTempRect);
                                    }
                                    c2.setBounds(this.mTempRect);
                                    c2.draw(canvas);
                                }
                            }
                            ig.recycle();
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
        if (bVar.bHO.type == 2) {
            Drawable drawable = this.bIc;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            drawable.setState(bIh[(bVar.pV() ? (char) 1 : (char) 0) | (bVar.bHP == null || bVar.bHP.bHJ == bVar.bHP.bHI ? (char) 2 : (char) 0)]);
            return drawable;
        }
        Drawable drawable2 = this.bId;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(bVar.bHO.bHT == bVar.bHP.bHJ ? bIi : EMPTY_STATE_SET);
        }
        return drawable2;
    }

    public void setChildDivider(Drawable drawable) {
        this.bIj = drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tieba.horizonalList.widget.k
    public void a(Canvas canvas, Rect rect, int i) {
        int i2 = this.bHg + i;
        if (i2 >= 0) {
            ExpandableHListConnector.b ig = this.bHU.ig(ik(i2));
            if (ig.bHO.type == 1 || (ig.pV() && ig.bHP.bHJ != ig.bHP.bHI)) {
                Drawable drawable = this.bIj;
                drawable.setBounds(rect);
                drawable.draw(canvas);
                ig.recycle();
                return;
            }
            ig.recycle();
        }
        super.a(canvas, rect, i2);
    }

    @Override // com.baidu.tieba.horizonalList.widget.k, com.baidu.tieba.horizonalList.widget.AbsHListView
    public void setAdapter(ListAdapter listAdapter) {
        throw new RuntimeException("For ExpandableListView, use setAdapter(ExpandableListAdapter) instead of setAdapter(ListAdapter)");
    }

    @Override // com.baidu.tieba.horizonalList.widget.k, com.baidu.tieba.horizonalList.widget.g
    public ListAdapter getAdapter() {
        return super.getAdapter();
    }

    @Override // com.baidu.tieba.horizonalList.widget.g
    public void setOnItemClickListener(g.c cVar) {
        super.setOnItemClickListener(cVar);
    }

    public void setAdapter(ExpandableListAdapter expandableListAdapter) {
        this.bHV = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.bHU = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.bHU = null;
        }
        super.setAdapter((ListAdapter) this.bHU);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.bHV;
    }

    private boolean ij(int i) {
        return i < getHeaderViewsCount() || i >= this.bHt - getFooterViewsCount();
    }

    private int ik(int i) {
        return i - getHeaderViewsCount();
    }

    private int il(int i) {
        return getHeaderViewsCount() + i;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.g
    public boolean performItemClick(View view, int i, long j) {
        if (ij(i)) {
            return super.performItemClick(view, i, j);
        }
        return c(view, ik(i), j);
    }

    boolean c(View view, int i, long j) {
        boolean z;
        ExpandableHListConnector.b ig = this.bHU.ig(i);
        long b2 = b(ig.bHO);
        if (ig.bHO.type == 2) {
            if (this.bIr != null && this.bIr.a(this, view, ig.bHO.bHR, b2)) {
                ig.recycle();
                return true;
            }
            if (ig.pV()) {
                this.bHU.a(ig);
                playSoundEffect(0);
                if (this.bIp != null) {
                    this.bIp.onGroupCollapse(ig.bHO.bHR);
                }
            } else {
                this.bHU.b(ig);
                playSoundEffect(0);
                if (this.bIq != null) {
                    this.bIq.onGroupExpand(ig.bHO.bHR);
                }
                int i2 = ig.bHO.bHR;
                int headerViewsCount = ig.bHO.bHT + getHeaderViewsCount();
                smoothScrollToPosition(this.bHV.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.bIs != null) {
            playSoundEffect(0);
            return this.bIs.a(this, view, ig.bHO.bHR, ig.bHO.bHS, b2);
        } else {
            z = false;
        }
        ig.recycle();
        return z;
    }

    public void setOnGroupCollapseListener(d dVar) {
        this.bIp = dVar;
    }

    public void setOnGroupExpandListener(e eVar) {
        this.bIq = eVar;
    }

    public void setOnGroupClickListener(c cVar) {
        this.bIr = cVar;
    }

    public void setOnChildClickListener(b bVar) {
        this.bIs = bVar;
    }

    public long getExpandableListPosition(int i) {
        if (ij(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b ig = this.bHU.ig(ik(i));
        long Xf = ig.bHO.Xf();
        ig.recycle();
        return Xf;
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
            return this.bHV.getGroupId(packedPositionGroup);
        }
        return this.bHV.getChildId(packedPositionGroup, getPackedPositionChild(selectedPosition));
    }

    public void setSelectedGroup(int i) {
        i ii = i.ii(i);
        ExpandableHListConnector.b a2 = this.bHU.a(ii);
        ii.recycle();
        super.setSelection(il(a2.bHO.bHT));
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
    ContextMenu.ContextMenuInfo a(View view, int i, long j) {
        if (ij(i)) {
            return new g.a(view, i, j);
        }
        ExpandableHListConnector.b ig = this.bHU.ig(ik(i));
        i iVar = ig.bHO;
        long b2 = b(iVar);
        long Xf = iVar.Xf();
        ig.recycle();
        return new a(view, Xf, b2);
    }

    private long b(i iVar) {
        return iVar.type == 1 ? this.bHV.getChildId(iVar.bHR, iVar.bHS) : this.bHV.getGroupId(iVar.bHR);
    }

    public void setChildIndicator(Drawable drawable) {
        this.bId = drawable;
        Xi();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.bIc = drawable;
        Xh();
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
        ArrayList<ExpandableHListConnector.GroupMetadata> bIt;

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.bIt = arrayList;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ SavedState(Parcel parcel, SavedState savedState) {
            this(parcel);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.bIt = new ArrayList<>();
            parcel.readList(this.bIt, ExpandableHListConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.bIt);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.bHU != null ? this.bHU.Xc() : null);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.bHU != null && savedState.bIt != null) {
            this.bHU.I(savedState.bIt);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.k, com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.g, android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(ExpandableHListView.class.getName());
    }

    @Override // com.baidu.tieba.horizonalList.widget.k, com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.g, android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(ExpandableHListView.class.getName());
    }
}
