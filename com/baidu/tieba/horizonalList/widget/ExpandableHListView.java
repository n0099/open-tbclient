package com.baidu.tieba.horizonalList.widget;

import android.annotation.TargetApi;
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
import com.baidu.tieba.horizonalList.widget.a;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ExpandableHListView extends HListView {
    private Drawable egE;
    private final Rect egF;
    private int egG;
    private int egH;
    private int egI;
    private int egJ;
    private d egK;
    private e egL;
    private c egM;
    private b egN;
    private ExpandableHListConnector egq;
    private ExpandableListAdapter egr;
    private int egs;
    private int egt;
    private int egu;
    private int egv;
    private int egw;
    private Drawable egx;
    private Drawable egy;
    private final Rect mTempRect;
    private int ri;
    private static final int[] EMPTY_STATE_SET = new int[0];
    private static final int[] egz = {16842920};
    private static final int[] egA = {16842921};
    private static final int[] egB = {16842920, 16842921};
    private static final int[][] egC = {EMPTY_STATE_SET, egz, egA, egB};
    private static final int[] egD = {16842918};

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

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        aBR();
        aBS();
    }

    private void aBR() {
        if (this.egx != null) {
            this.egG = this.egx.getIntrinsicWidth();
            this.egH = this.egx.getIntrinsicHeight();
            return;
        }
        this.egG = 0;
        this.egH = 0;
    }

    private void aBS() {
        if (this.egy != null) {
            this.egI = this.egy.getIntrinsicWidth();
            this.egJ = this.egy.getIntrinsicHeight();
            return;
        }
        this.egI = 0;
        this.egJ = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.egy != null || this.egx != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.mItemCount - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            Rect rect = this.egF;
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
                            ExpandableHListConnector.b pe = this.egq.pe(i4);
                            if (pe.egk.type != i2) {
                                if (pe.egk.type == 1) {
                                    rect.top = childAt.getTop() + this.egv;
                                    rect.bottom = childAt.getBottom() + this.egv;
                                } else {
                                    rect.top = childAt.getTop() + this.egs;
                                    rect.bottom = childAt.getBottom() + this.egs;
                                }
                                i2 = pe.egk.type;
                            }
                            if (rect.top != rect.bottom) {
                                if (pe.egk.type == 1) {
                                    rect.left = this.egw + left;
                                    rect.right = this.egw + right2;
                                } else {
                                    rect.left = this.ri + left;
                                    rect.right = this.ri + right2;
                                }
                                Drawable c2 = c(pe);
                                if (c2 != null) {
                                    if (pe.egk.type == 1) {
                                        Gravity.apply(this.egu, this.egI, this.egJ, rect, this.mTempRect);
                                    } else {
                                        Gravity.apply(this.egt, this.egG, this.egH, rect, this.mTempRect);
                                    }
                                    c2.setBounds(this.mTempRect);
                                    c2.draw(canvas);
                                }
                            }
                            pe.recycle();
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
        if (bVar.egk.type == 2) {
            Drawable drawable = this.egx;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            drawable.setState(egC[(bVar.arz() ? (char) 1 : (char) 0) | (bVar.egl == null || bVar.egl.egf == bVar.egl.ege ? (char) 2 : (char) 0)]);
            return drawable;
        }
        Drawable drawable2 = this.egy;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(bVar.egk.egp == bVar.egl.egf ? egD : EMPTY_STATE_SET);
        }
        return drawable2;
    }

    public void setChildDivider(Drawable drawable) {
        this.egE = drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tieba.horizonalList.widget.HListView
    public void drawDivider(Canvas canvas, Rect rect, int i) {
        int i2 = this.mFirstPosition + i;
        if (i2 >= 0) {
            ExpandableHListConnector.b pe = this.egq.pe(ph(i2));
            if (pe.egk.type == 1 || (pe.arz() && pe.egl.egf != pe.egl.ege)) {
                Drawable drawable = this.egE;
                drawable.setBounds(rect);
                drawable.draw(canvas);
                pe.recycle();
                return;
            }
            pe.recycle();
        }
        super.drawDivider(canvas, rect, i2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.a
    public void setAdapter(ListAdapter listAdapter) {
        throw new RuntimeException("For ExpandableListView, use setAdapter(ExpandableListAdapter) instead of setAdapter(ListAdapter)");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.a
    public ListAdapter getAdapter() {
        return super.getAdapter();
    }

    @Override // com.baidu.tieba.horizonalList.widget.a
    public void setOnItemClickListener(a.c cVar) {
        super.setOnItemClickListener(cVar);
    }

    public void setAdapter(ExpandableListAdapter expandableListAdapter) {
        this.egr = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.egq = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.egq = null;
        }
        super.setAdapter((ListAdapter) this.egq);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.egr;
    }

    private boolean isHeaderOrFooterPosition(int i) {
        return i < getHeaderViewsCount() || i >= this.mItemCount - getFooterViewsCount();
    }

    private int ph(int i) {
        return i - getHeaderViewsCount();
    }

    private int pi(int i) {
        return getHeaderViewsCount() + i;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.a
    public boolean performItemClick(View view, int i, long j) {
        if (isHeaderOrFooterPosition(i)) {
            return super.performItemClick(view, i, j);
        }
        return b(view, ph(i), j);
    }

    boolean b(View view, int i, long j) {
        boolean z;
        ExpandableHListConnector.b pe = this.egq.pe(i);
        long b2 = b(pe.egk);
        if (pe.egk.type == 2) {
            if (this.egM != null && this.egM.a(this, view, pe.egk.egn, b2)) {
                pe.recycle();
                return true;
            }
            if (pe.arz()) {
                this.egq.a(pe);
                playSoundEffect(0);
                if (this.egK != null) {
                    this.egK.onGroupCollapse(pe.egk.egn);
                }
            } else {
                this.egq.b(pe);
                playSoundEffect(0);
                if (this.egL != null) {
                    this.egL.onGroupExpand(pe.egk.egn);
                }
                int i2 = pe.egk.egn;
                int headerViewsCount = pe.egk.egp + getHeaderViewsCount();
                smoothScrollToPosition(this.egr.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.egN != null) {
            playSoundEffect(0);
            return this.egN.a(this, view, pe.egk.egn, pe.egk.ego, b2);
        } else {
            z = false;
        }
        pe.recycle();
        return z;
    }

    public void setOnGroupCollapseListener(d dVar) {
        this.egK = dVar;
    }

    public void setOnGroupExpandListener(e eVar) {
        this.egL = eVar;
    }

    public void setOnGroupClickListener(c cVar) {
        this.egM = cVar;
    }

    public void setOnChildClickListener(b bVar) {
        this.egN = bVar;
    }

    public long getExpandableListPosition(int i) {
        if (isHeaderOrFooterPosition(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b pe = this.egq.pe(ph(i));
        long aBP = pe.egk.aBP();
        pe.recycle();
        return aBP;
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
            return this.egr.getGroupId(packedPositionGroup);
        }
        return this.egr.getChildId(packedPositionGroup, getPackedPositionChild(selectedPosition));
    }

    public void setSelectedGroup(int i) {
        com.baidu.tieba.horizonalList.widget.b pg = com.baidu.tieba.horizonalList.widget.b.pg(i);
        ExpandableHListConnector.b a2 = this.egq.a(pg);
        pg.recycle();
        super.setSelection(pi(a2.egk.egp));
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
            return new a.ContextMenu$ContextMenuInfoC0117a(view, i, j);
        }
        ExpandableHListConnector.b pe = this.egq.pe(ph(i));
        com.baidu.tieba.horizonalList.widget.b bVar = pe.egk;
        long b2 = b(bVar);
        long aBP = bVar.aBP();
        pe.recycle();
        return new a(view, aBP, b2);
    }

    private long b(com.baidu.tieba.horizonalList.widget.b bVar) {
        return bVar.type == 1 ? this.egr.getChildId(bVar.egn, bVar.ego) : this.egr.getGroupId(bVar.egn);
    }

    public void setChildIndicator(Drawable drawable) {
        this.egy = drawable;
        aBS();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.egx = drawable;
        aBR();
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.tieba.horizonalList.widget.ExpandableHListView.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: E */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: pj */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        ArrayList<ExpandableHListConnector.GroupMetadata> egO;

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.egO = arrayList;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.egO = new ArrayList<>();
            parcel.readList(this.egO, ExpandableHListConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.egO);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.egq != null ? this.egq.aBN() : null);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.egq != null && savedState.egO != null) {
            this.egq.R(savedState.egO);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.a, android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(ExpandableHListView.class.getName());
    }

    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.a, android.view.View
    @TargetApi(14)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(ExpandableHListView.class.getName());
    }
}
