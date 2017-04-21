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
    private static final int[] cGa = {16842920};
    private static final int[] cGb = {16842921};
    private static final int[] cGc = {16842920, 16842921};
    private static final int[][] cGd = {EMPTY_STATE_SET, cGa, cGb, cGc};
    private static final int[] cGe = {16842918};
    private ExpandableHListConnector cFQ;
    private ExpandableListAdapter cFR;
    private int cFS;
    private int cFT;
    private int cFU;
    private int cFV;
    private int cFW;
    private int cFX;
    private Drawable cFY;
    private Drawable cFZ;
    private Drawable cGf;
    private final Rect cGg;
    private int cGh;
    private int cGi;
    private int cGj;
    private int cGk;
    private d cGl;
    private e cGm;
    private c cGn;
    private b cGo;
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

    private void alZ() {
        if (this.cFY != null) {
            this.cGh = this.cFY.getIntrinsicWidth();
            this.cGi = this.cFY.getIntrinsicHeight();
            return;
        }
        this.cGh = 0;
        this.cGi = 0;
    }

    private void ama() {
        if (this.cFZ != null) {
            this.cGj = this.cFZ.getIntrinsicWidth();
            this.cGk = this.cFZ.getIntrinsicHeight();
            return;
        }
        this.cGj = 0;
        this.cGk = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.cFZ != null || this.cFY != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.cFp - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            Rect rect = this.cGg;
            int childCount = getChildCount();
            int i = this.cFc - headerViewsCount;
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
                            ExpandableHListConnector.b kt = this.cFQ.kt(i4);
                            if (kt.cFK.type != i2) {
                                if (kt.cFK.type == 1) {
                                    rect.top = childAt.getTop() + this.cFW;
                                    rect.bottom = childAt.getBottom() + this.cFW;
                                } else {
                                    rect.top = childAt.getTop() + this.cFS;
                                    rect.bottom = childAt.getBottom() + this.cFS;
                                }
                                i2 = kt.cFK.type;
                            }
                            if (rect.top != rect.bottom) {
                                if (kt.cFK.type == 1) {
                                    rect.left = this.cFX + left;
                                    rect.right = this.cFX + right2;
                                } else {
                                    rect.left = this.cFT + left;
                                    rect.right = this.cFT + right2;
                                }
                                Drawable c2 = c(kt);
                                if (c2 != null) {
                                    if (kt.cFK.type == 1) {
                                        Gravity.apply(this.cFV, this.cGj, this.cGk, rect, this.mTempRect);
                                    } else {
                                        Gravity.apply(this.cFU, this.cGh, this.cGi, rect, this.mTempRect);
                                    }
                                    c2.setBounds(this.mTempRect);
                                    c2.draw(canvas);
                                }
                            }
                            kt.recycle();
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
        if (bVar.cFK.type == 2) {
            Drawable drawable = this.cFY;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            drawable.setState(cGd[(bVar.alW() ? (char) 1 : (char) 0) | (bVar.cFL == null || bVar.cFL.cFF == bVar.cFL.cFE ? (char) 2 : (char) 0)]);
            return drawable;
        }
        Drawable drawable2 = this.cFZ;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(bVar.cFK.cFP == bVar.cFL.cFF ? cGe : EMPTY_STATE_SET);
        }
        return drawable2;
    }

    public void setChildDivider(Drawable drawable) {
        this.cGf = drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tieba.horizonalList.widget.HListView
    public void a(Canvas canvas, Rect rect, int i) {
        int i2 = this.cFc + i;
        if (i2 >= 0) {
            ExpandableHListConnector.b kt = this.cFQ.kt(kx(i2));
            if (kt.cFK.type == 1 || (kt.alW() && kt.cFL.cFF != kt.cFL.cFE)) {
                Drawable drawable = this.cGf;
                drawable.setBounds(rect);
                drawable.draw(canvas);
                kt.recycle();
                return;
            }
            kt.recycle();
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
        this.cFR = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.cFQ = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.cFQ = null;
        }
        super.setAdapter((ListAdapter) this.cFQ);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.cFR;
    }

    private boolean kw(int i) {
        return i < getHeaderViewsCount() || i >= this.cFp - getFooterViewsCount();
    }

    private int kx(int i) {
        return i - getHeaderViewsCount();
    }

    private int ky(int i) {
        return getHeaderViewsCount() + i;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.g
    public boolean performItemClick(View view, int i, long j) {
        if (kw(i)) {
            return super.performItemClick(view, i, j);
        }
        return d(view, kx(i), j);
    }

    boolean d(View view, int i, long j) {
        boolean z;
        ExpandableHListConnector.b kt = this.cFQ.kt(i);
        long b2 = b(kt.cFK);
        if (kt.cFK.type == 2) {
            if (this.cGn != null && this.cGn.a(this, view, kt.cFK.cFN, b2)) {
                kt.recycle();
                return true;
            }
            if (kt.alW()) {
                this.cFQ.a(kt);
                playSoundEffect(0);
                if (this.cGl != null) {
                    this.cGl.onGroupCollapse(kt.cFK.cFN);
                }
            } else {
                this.cFQ.b(kt);
                playSoundEffect(0);
                if (this.cGm != null) {
                    this.cGm.onGroupExpand(kt.cFK.cFN);
                }
                int i2 = kt.cFK.cFN;
                int headerViewsCount = kt.cFK.cFP + getHeaderViewsCount();
                smoothScrollToPosition(this.cFR.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.cGo != null) {
            playSoundEffect(0);
            return this.cGo.a(this, view, kt.cFK.cFN, kt.cFK.cFO, b2);
        } else {
            z = false;
        }
        kt.recycle();
        return z;
    }

    public void setOnGroupCollapseListener(d dVar) {
        this.cGl = dVar;
    }

    public void setOnGroupExpandListener(e eVar) {
        this.cGm = eVar;
    }

    public void setOnGroupClickListener(c cVar) {
        this.cGn = cVar;
    }

    public void setOnChildClickListener(b bVar) {
        this.cGo = bVar;
    }

    public long getExpandableListPosition(int i) {
        if (kw(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b kt = this.cFQ.kt(kx(i));
        long alX = kt.cFK.alX();
        kt.recycle();
        return alX;
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
            return this.cFR.getGroupId(packedPositionGroup);
        }
        return this.cFR.getChildId(packedPositionGroup, getPackedPositionChild(selectedPosition));
    }

    public void setSelectedGroup(int i) {
        i kv = i.kv(i);
        ExpandableHListConnector.b a2 = this.cFQ.a(kv);
        kv.recycle();
        super.setSelection(ky(a2.cFK.cFP));
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
        if (kw(i)) {
            return new g.a(view, i, j);
        }
        ExpandableHListConnector.b kt = this.cFQ.kt(kx(i));
        i iVar = kt.cFK;
        long b2 = b(iVar);
        long alX = iVar.alX();
        kt.recycle();
        return new a(view, alX, b2);
    }

    private long b(i iVar) {
        return iVar.type == 1 ? this.cFR.getChildId(iVar.cFN, iVar.cFO) : this.cFR.getGroupId(iVar.cFN);
    }

    public void setChildIndicator(Drawable drawable) {
        this.cFZ = drawable;
        ama();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.cFY = drawable;
        alZ();
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
        ArrayList<ExpandableHListConnector.GroupMetadata> cGp;

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.cGp = arrayList;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ SavedState(Parcel parcel, SavedState savedState) {
            this(parcel);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.cGp = new ArrayList<>();
            parcel.readList(this.cGp, ExpandableHListConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.cGp);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.cFQ != null ? this.cFQ.alT() : null);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.cFQ != null && savedState.cGp != null) {
            this.cFQ.Q(savedState.cGp);
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
