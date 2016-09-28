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
    private static final int[] cMn = {16842920};
    private static final int[] cMo = {16842921};
    private static final int[] cMp = {16842920, 16842921};
    private static final int[][] cMq = {EMPTY_STATE_SET, cMn, cMo, cMp};
    private static final int[] cMr = {16842918};
    private c cMA;
    private b cMB;
    private ExpandableHListConnector cMd;
    private ExpandableListAdapter cMe;
    private int cMf;
    private int cMg;
    private int cMh;
    private int cMi;
    private int cMj;
    private int cMk;
    private Drawable cMl;
    private Drawable cMm;
    private Drawable cMs;
    private final Rect cMt;
    private int cMu;
    private int cMv;
    private int cMw;
    private int cMx;
    private d cMy;
    private e cMz;
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

    private void aop() {
        if (this.cMl != null) {
            this.cMu = this.cMl.getIntrinsicWidth();
            this.cMv = this.cMl.getIntrinsicHeight();
            return;
        }
        this.cMu = 0;
        this.cMv = 0;
    }

    private void aoq() {
        if (this.cMm != null) {
            this.cMw = this.cMm.getIntrinsicWidth();
            this.cMx = this.cMm.getIntrinsicHeight();
            return;
        }
        this.cMw = 0;
        this.cMx = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.cMm != null || this.cMl != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.cLC - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            Rect rect = this.cMt;
            int childCount = getChildCount();
            int i = this.bxM - headerViewsCount;
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
                            ExpandableHListConnector.b kE = this.cMd.kE(i4);
                            if (kE.cLX.type != i2) {
                                if (kE.cLX.type == 1) {
                                    rect.top = childAt.getTop() + this.cMj;
                                    rect.bottom = childAt.getBottom() + this.cMj;
                                } else {
                                    rect.top = childAt.getTop() + this.cMf;
                                    rect.bottom = childAt.getBottom() + this.cMf;
                                }
                                i2 = kE.cLX.type;
                            }
                            if (rect.top != rect.bottom) {
                                if (kE.cLX.type == 1) {
                                    rect.left = this.cMk + left;
                                    rect.right = this.cMk + right2;
                                } else {
                                    rect.left = this.cMg + left;
                                    rect.right = this.cMg + right2;
                                }
                                Drawable c2 = c(kE);
                                if (c2 != null) {
                                    if (kE.cLX.type == 1) {
                                        Gravity.apply(this.cMi, this.cMw, this.cMx, rect, this.mTempRect);
                                    } else {
                                        Gravity.apply(this.cMh, this.cMu, this.cMv, rect, this.mTempRect);
                                    }
                                    c2.setBounds(this.mTempRect);
                                    c2.draw(canvas);
                                }
                            }
                            kE.recycle();
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
        if (bVar.cLX.type == 2) {
            Drawable drawable = this.cMl;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            drawable.setState(cMq[(bVar.aom() ? (char) 1 : (char) 0) | (bVar.cLY == null || bVar.cLY.cLS == bVar.cLY.cLR ? (char) 2 : (char) 0)]);
            return drawable;
        }
        Drawable drawable2 = this.cMm;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(bVar.cLX.cMc == bVar.cLY.cLS ? cMr : EMPTY_STATE_SET);
        }
        return drawable2;
    }

    public void setChildDivider(Drawable drawable) {
        this.cMs = drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tieba.horizonalList.widget.HListView
    public void a(Canvas canvas, Rect rect, int i) {
        int i2 = this.bxM + i;
        if (i2 >= 0) {
            ExpandableHListConnector.b kE = this.cMd.kE(kI(i2));
            if (kE.cLX.type == 1 || (kE.aom() && kE.cLY.cLS != kE.cLY.cLR)) {
                Drawable drawable = this.cMs;
                drawable.setBounds(rect);
                drawable.draw(canvas);
                kE.recycle();
                return;
            }
            kE.recycle();
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
        this.cMe = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.cMd = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.cMd = null;
        }
        super.setAdapter((ListAdapter) this.cMd);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.cMe;
    }

    private boolean kH(int i) {
        return i < getHeaderViewsCount() || i >= this.cLC - getFooterViewsCount();
    }

    private int kI(int i) {
        return i - getHeaderViewsCount();
    }

    private int kJ(int i) {
        return getHeaderViewsCount() + i;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.g
    public boolean performItemClick(View view, int i, long j) {
        if (kH(i)) {
            return super.performItemClick(view, i, j);
        }
        return d(view, kI(i), j);
    }

    boolean d(View view, int i, long j) {
        boolean z;
        ExpandableHListConnector.b kE = this.cMd.kE(i);
        long b2 = b(kE.cLX);
        if (kE.cLX.type == 2) {
            if (this.cMA != null && this.cMA.a(this, view, kE.cLX.cMa, b2)) {
                kE.recycle();
                return true;
            }
            if (kE.aom()) {
                this.cMd.a(kE);
                playSoundEffect(0);
                if (this.cMy != null) {
                    this.cMy.onGroupCollapse(kE.cLX.cMa);
                }
            } else {
                this.cMd.b(kE);
                playSoundEffect(0);
                if (this.cMz != null) {
                    this.cMz.onGroupExpand(kE.cLX.cMa);
                }
                int i2 = kE.cLX.cMa;
                int headerViewsCount = kE.cLX.cMc + getHeaderViewsCount();
                smoothScrollToPosition(this.cMe.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.cMB != null) {
            playSoundEffect(0);
            return this.cMB.a(this, view, kE.cLX.cMa, kE.cLX.cMb, b2);
        } else {
            z = false;
        }
        kE.recycle();
        return z;
    }

    public void setOnGroupCollapseListener(d dVar) {
        this.cMy = dVar;
    }

    public void setOnGroupExpandListener(e eVar) {
        this.cMz = eVar;
    }

    public void setOnGroupClickListener(c cVar) {
        this.cMA = cVar;
    }

    public void setOnChildClickListener(b bVar) {
        this.cMB = bVar;
    }

    public long getExpandableListPosition(int i) {
        if (kH(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b kE = this.cMd.kE(kI(i));
        long aon = kE.cLX.aon();
        kE.recycle();
        return aon;
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
            return this.cMe.getGroupId(packedPositionGroup);
        }
        return this.cMe.getChildId(packedPositionGroup, getPackedPositionChild(selectedPosition));
    }

    public void setSelectedGroup(int i) {
        i kG = i.kG(i);
        ExpandableHListConnector.b a2 = this.cMd.a(kG);
        kG.recycle();
        super.setSelection(kJ(a2.cLX.cMc));
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
        if (kH(i)) {
            return new g.a(view, i, j);
        }
        ExpandableHListConnector.b kE = this.cMd.kE(kI(i));
        i iVar = kE.cLX;
        long b2 = b(iVar);
        long aon = iVar.aon();
        kE.recycle();
        return new a(view, aon, b2);
    }

    private long b(i iVar) {
        return iVar.type == 1 ? this.cMe.getChildId(iVar.cMa, iVar.cMb) : this.cMe.getGroupId(iVar.cMa);
    }

    public void setChildIndicator(Drawable drawable) {
        this.cMm = drawable;
        aoq();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.cMl = drawable;
        aop();
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
        ArrayList<ExpandableHListConnector.GroupMetadata> cMC;

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.cMC = arrayList;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ SavedState(Parcel parcel, SavedState savedState) {
            this(parcel);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.cMC = new ArrayList<>();
            parcel.readList(this.cMC, ExpandableHListConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.cMC);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.cMd != null ? this.cMd.aoj() : null);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.cMd != null && savedState.cMC != null) {
            this.cMd.U(savedState.cMC);
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
