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
    private static final int[] cFT = {16842920};
    private static final int[] cFU = {16842921};
    private static final int[] cFV = {16842920, 16842921};
    private static final int[][] cFW = {EMPTY_STATE_SET, cFT, cFU, cFV};
    private static final int[] cFX = {16842918};
    private ExpandableHListConnector cFJ;
    private ExpandableListAdapter cFK;
    private int cFL;
    private int cFM;
    private int cFN;
    private int cFO;
    private int cFP;
    private int cFQ;
    private Drawable cFR;
    private Drawable cFS;
    private Drawable cFY;
    private final Rect cFZ;
    private int cGa;
    private int cGb;
    private int cGc;
    private int cGd;
    private d cGe;
    private e cGf;
    private c cGg;
    private b cGh;
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

    private void ajP() {
        if (this.cFR != null) {
            this.cGa = this.cFR.getIntrinsicWidth();
            this.cGb = this.cFR.getIntrinsicHeight();
            return;
        }
        this.cGa = 0;
        this.cGb = 0;
    }

    private void ajQ() {
        if (this.cFS != null) {
            this.cGc = this.cFS.getIntrinsicWidth();
            this.cGd = this.cFS.getIntrinsicHeight();
            return;
        }
        this.cGc = 0;
        this.cGd = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.cFS != null || this.cFR != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.mItemCount - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            Rect rect = this.cFZ;
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
                            ExpandableHListConnector.b kC = this.cFJ.kC(i4);
                            if (kC.cFD.type != i2) {
                                if (kC.cFD.type == 1) {
                                    rect.top = childAt.getTop() + this.cFP;
                                    rect.bottom = childAt.getBottom() + this.cFP;
                                } else {
                                    rect.top = childAt.getTop() + this.cFL;
                                    rect.bottom = childAt.getBottom() + this.cFL;
                                }
                                i2 = kC.cFD.type;
                            }
                            if (rect.top != rect.bottom) {
                                if (kC.cFD.type == 1) {
                                    rect.left = this.cFQ + left;
                                    rect.right = this.cFQ + right2;
                                } else {
                                    rect.left = this.cFM + left;
                                    rect.right = this.cFM + right2;
                                }
                                Drawable c2 = c(kC);
                                if (c2 != null) {
                                    if (kC.cFD.type == 1) {
                                        Gravity.apply(this.cFO, this.cGc, this.cGd, rect, this.mTempRect);
                                    } else {
                                        Gravity.apply(this.cFN, this.cGa, this.cGb, rect, this.mTempRect);
                                    }
                                    c2.setBounds(this.mTempRect);
                                    c2.draw(canvas);
                                }
                            }
                            kC.recycle();
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
        if (bVar.cFD.type == 2) {
            Drawable drawable = this.cFR;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            drawable.setState(cFW[(bVar.ajM() ? (char) 1 : (char) 0) | (bVar.cFE == null || bVar.cFE.cFy == bVar.cFE.cFx ? (char) 2 : (char) 0)]);
            return drawable;
        }
        Drawable drawable2 = this.cFS;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(bVar.cFD.cFI == bVar.cFE.cFy ? cFX : EMPTY_STATE_SET);
        }
        return drawable2;
    }

    public void setChildDivider(Drawable drawable) {
        this.cFY = drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tieba.horizonalList.widget.HListView
    public void drawDivider(Canvas canvas, Rect rect, int i) {
        int i2 = this.mFirstPosition + i;
        if (i2 >= 0) {
            ExpandableHListConnector.b kC = this.cFJ.kC(kF(i2));
            if (kC.cFD.type == 1 || (kC.ajM() && kC.cFE.cFy != kC.cFE.cFx)) {
                Drawable drawable = this.cFY;
                drawable.setBounds(rect);
                drawable.draw(canvas);
                kC.recycle();
                return;
            }
            kC.recycle();
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
        this.cFK = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.cFJ = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.cFJ = null;
        }
        super.setAdapter((ListAdapter) this.cFJ);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.cFK;
    }

    private boolean isHeaderOrFooterPosition(int i) {
        return i < getHeaderViewsCount() || i >= this.mItemCount - getFooterViewsCount();
    }

    private int kF(int i) {
        return i - getHeaderViewsCount();
    }

    private int kG(int i) {
        return getHeaderViewsCount() + i;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.f
    public boolean performItemClick(View view, int i, long j) {
        if (isHeaderOrFooterPosition(i)) {
            return super.performItemClick(view, i, j);
        }
        return c(view, kF(i), j);
    }

    boolean c(View view, int i, long j) {
        boolean z;
        ExpandableHListConnector.b kC = this.cFJ.kC(i);
        long b2 = b(kC.cFD);
        if (kC.cFD.type == 2) {
            if (this.cGg != null && this.cGg.a(this, view, kC.cFD.cFG, b2)) {
                kC.recycle();
                return true;
            }
            if (kC.ajM()) {
                this.cFJ.a(kC);
                playSoundEffect(0);
                if (this.cGe != null) {
                    this.cGe.onGroupCollapse(kC.cFD.cFG);
                }
            } else {
                this.cFJ.b(kC);
                playSoundEffect(0);
                if (this.cGf != null) {
                    this.cGf.onGroupExpand(kC.cFD.cFG);
                }
                int i2 = kC.cFD.cFG;
                int headerViewsCount = kC.cFD.cFI + getHeaderViewsCount();
                smoothScrollToPosition(this.cFK.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.cGh != null) {
            playSoundEffect(0);
            return this.cGh.a(this, view, kC.cFD.cFG, kC.cFD.cFH, b2);
        } else {
            z = false;
        }
        kC.recycle();
        return z;
    }

    public void setOnGroupCollapseListener(d dVar) {
        this.cGe = dVar;
    }

    public void setOnGroupExpandListener(e eVar) {
        this.cGf = eVar;
    }

    public void setOnGroupClickListener(c cVar) {
        this.cGg = cVar;
    }

    public void setOnChildClickListener(b bVar) {
        this.cGh = bVar;
    }

    public long getExpandableListPosition(int i) {
        if (isHeaderOrFooterPosition(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b kC = this.cFJ.kC(kF(i));
        long ajN = kC.cFD.ajN();
        kC.recycle();
        return ajN;
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
            return this.cFK.getGroupId(packedPositionGroup);
        }
        return this.cFK.getChildId(packedPositionGroup, getPackedPositionChild(selectedPosition));
    }

    public void setSelectedGroup(int i) {
        h kE = h.kE(i);
        ExpandableHListConnector.b a2 = this.cFJ.a(kE);
        kE.recycle();
        super.setSelection(kG(a2.cFD.cFI));
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
        ExpandableHListConnector.b kC = this.cFJ.kC(kF(i));
        h hVar = kC.cFD;
        long b2 = b(hVar);
        long ajN = hVar.ajN();
        kC.recycle();
        return new a(view, ajN, b2);
    }

    private long b(h hVar) {
        return hVar.type == 1 ? this.cFK.getChildId(hVar.cFG, hVar.cFH) : this.cFK.getGroupId(hVar.cFG);
    }

    public void setChildIndicator(Drawable drawable) {
        this.cFS = drawable;
        ajQ();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.cFR = drawable;
        ajP();
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
        ArrayList<ExpandableHListConnector.GroupMetadata> cGi;

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.cGi = arrayList;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ SavedState(Parcel parcel, SavedState savedState) {
            this(parcel);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.cGi = new ArrayList<>();
            parcel.readList(this.cGi, ExpandableHListConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.cGi);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.cFJ != null ? this.cFJ.ajJ() : null);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.cFJ != null && savedState.cGi != null) {
            this.cFJ.Q(savedState.cGi);
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
