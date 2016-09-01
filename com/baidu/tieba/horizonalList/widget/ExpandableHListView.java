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
    private Drawable cLB;
    private final Rect cLC;
    private int cLD;
    private int cLE;
    private int cLF;
    private int cLG;
    private d cLH;
    private e cLI;
    private c cLJ;
    private b cLK;
    private ExpandableHListConnector cLm;
    private ExpandableListAdapter cLn;
    private int cLo;
    private int cLp;
    private int cLq;
    private int cLr;
    private int cLs;
    private int cLt;
    private Drawable cLu;
    private Drawable cLv;
    private final Rect mTempRect;
    private static final int[] EMPTY_STATE_SET = new int[0];
    private static final int[] cLw = {16842920};
    private static final int[] cLx = {16842921};
    private static final int[] cLy = {16842920, 16842921};
    private static final int[][] cLz = {EMPTY_STATE_SET, cLw, cLx, cLy};
    private static final int[] cLA = {16842918};

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

    private void aob() {
        if (this.cLu != null) {
            this.cLD = this.cLu.getIntrinsicWidth();
            this.cLE = this.cLu.getIntrinsicHeight();
            return;
        }
        this.cLD = 0;
        this.cLE = 0;
    }

    private void aoc() {
        if (this.cLv != null) {
            this.cLF = this.cLv.getIntrinsicWidth();
            this.cLG = this.cLv.getIntrinsicHeight();
            return;
        }
        this.cLF = 0;
        this.cLG = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.cLv != null || this.cLu != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.cKL - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            Rect rect = this.cLC;
            int childCount = getChildCount();
            int i = this.bxA - headerViewsCount;
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
                            ExpandableHListConnector.b ky = this.cLm.ky(i4);
                            if (ky.cLg.type != i2) {
                                if (ky.cLg.type == 1) {
                                    rect.top = childAt.getTop() + this.cLs;
                                    rect.bottom = childAt.getBottom() + this.cLs;
                                } else {
                                    rect.top = childAt.getTop() + this.cLo;
                                    rect.bottom = childAt.getBottom() + this.cLo;
                                }
                                i2 = ky.cLg.type;
                            }
                            if (rect.top != rect.bottom) {
                                if (ky.cLg.type == 1) {
                                    rect.left = this.cLt + left;
                                    rect.right = this.cLt + right2;
                                } else {
                                    rect.left = this.cLp + left;
                                    rect.right = this.cLp + right2;
                                }
                                Drawable c2 = c(ky);
                                if (c2 != null) {
                                    if (ky.cLg.type == 1) {
                                        Gravity.apply(this.cLr, this.cLF, this.cLG, rect, this.mTempRect);
                                    } else {
                                        Gravity.apply(this.cLq, this.cLD, this.cLE, rect, this.mTempRect);
                                    }
                                    c2.setBounds(this.mTempRect);
                                    c2.draw(canvas);
                                }
                            }
                            ky.recycle();
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
        if (bVar.cLg.type == 2) {
            Drawable drawable = this.cLu;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            drawable.setState(cLz[(bVar.anY() ? (char) 1 : (char) 0) | (bVar.cLh == null || bVar.cLh.cLb == bVar.cLh.cLa ? (char) 2 : (char) 0)]);
            return drawable;
        }
        Drawable drawable2 = this.cLv;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(bVar.cLg.cLl == bVar.cLh.cLb ? cLA : EMPTY_STATE_SET);
        }
        return drawable2;
    }

    public void setChildDivider(Drawable drawable) {
        this.cLB = drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tieba.horizonalList.widget.HListView
    public void a(Canvas canvas, Rect rect, int i) {
        int i2 = this.bxA + i;
        if (i2 >= 0) {
            ExpandableHListConnector.b ky = this.cLm.ky(kC(i2));
            if (ky.cLg.type == 1 || (ky.anY() && ky.cLh.cLb != ky.cLh.cLa)) {
                Drawable drawable = this.cLB;
                drawable.setBounds(rect);
                drawable.draw(canvas);
                ky.recycle();
                return;
            }
            ky.recycle();
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
        this.cLn = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.cLm = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.cLm = null;
        }
        super.setAdapter((ListAdapter) this.cLm);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.cLn;
    }

    private boolean kB(int i) {
        return i < getHeaderViewsCount() || i >= this.cKL - getFooterViewsCount();
    }

    private int kC(int i) {
        return i - getHeaderViewsCount();
    }

    private int kD(int i) {
        return getHeaderViewsCount() + i;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.g
    public boolean performItemClick(View view, int i, long j) {
        if (kB(i)) {
            return super.performItemClick(view, i, j);
        }
        return d(view, kC(i), j);
    }

    boolean d(View view, int i, long j) {
        boolean z;
        ExpandableHListConnector.b ky = this.cLm.ky(i);
        long b2 = b(ky.cLg);
        if (ky.cLg.type == 2) {
            if (this.cLJ != null && this.cLJ.a(this, view, ky.cLg.cLj, b2)) {
                ky.recycle();
                return true;
            }
            if (ky.anY()) {
                this.cLm.a(ky);
                playSoundEffect(0);
                if (this.cLH != null) {
                    this.cLH.onGroupCollapse(ky.cLg.cLj);
                }
            } else {
                this.cLm.b(ky);
                playSoundEffect(0);
                if (this.cLI != null) {
                    this.cLI.onGroupExpand(ky.cLg.cLj);
                }
                int i2 = ky.cLg.cLj;
                int headerViewsCount = ky.cLg.cLl + getHeaderViewsCount();
                smoothScrollToPosition(this.cLn.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.cLK != null) {
            playSoundEffect(0);
            return this.cLK.a(this, view, ky.cLg.cLj, ky.cLg.cLk, b2);
        } else {
            z = false;
        }
        ky.recycle();
        return z;
    }

    public void setOnGroupCollapseListener(d dVar) {
        this.cLH = dVar;
    }

    public void setOnGroupExpandListener(e eVar) {
        this.cLI = eVar;
    }

    public void setOnGroupClickListener(c cVar) {
        this.cLJ = cVar;
    }

    public void setOnChildClickListener(b bVar) {
        this.cLK = bVar;
    }

    public long getExpandableListPosition(int i) {
        if (kB(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b ky = this.cLm.ky(kC(i));
        long anZ = ky.cLg.anZ();
        ky.recycle();
        return anZ;
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
            return this.cLn.getGroupId(packedPositionGroup);
        }
        return this.cLn.getChildId(packedPositionGroup, getPackedPositionChild(selectedPosition));
    }

    public void setSelectedGroup(int i) {
        i kA = i.kA(i);
        ExpandableHListConnector.b a2 = this.cLm.a(kA);
        kA.recycle();
        super.setSelection(kD(a2.cLg.cLl));
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
        if (kB(i)) {
            return new g.a(view, i, j);
        }
        ExpandableHListConnector.b ky = this.cLm.ky(kC(i));
        i iVar = ky.cLg;
        long b2 = b(iVar);
        long anZ = iVar.anZ();
        ky.recycle();
        return new a(view, anZ, b2);
    }

    private long b(i iVar) {
        return iVar.type == 1 ? this.cLn.getChildId(iVar.cLj, iVar.cLk) : this.cLn.getGroupId(iVar.cLj);
    }

    public void setChildIndicator(Drawable drawable) {
        this.cLv = drawable;
        aoc();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.cLu = drawable;
        aob();
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
        ArrayList<ExpandableHListConnector.GroupMetadata> cLL;

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.cLL = arrayList;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ SavedState(Parcel parcel, SavedState savedState) {
            this(parcel);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.cLL = new ArrayList<>();
            parcel.readList(this.cLL, ExpandableHListConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.cLL);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.cLm != null ? this.cLm.anV() : null);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.cLm != null && savedState.cLL != null) {
            this.cLm.U(savedState.cLL);
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
