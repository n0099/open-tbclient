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
    private static final int[] EMPTY_STATE_SET = new int[0];
    private static final int[] cZM = {16842920};
    private static final int[] cZN = {16842921};
    private static final int[] cZO = {16842920, 16842921};
    private static final int[][] cZP = {EMPTY_STATE_SET, cZM, cZN, cZO};
    private static final int[] cZQ = {16842918};
    private ExpandableHListConnector cZC;
    private ExpandableListAdapter cZD;
    private int cZE;
    private int cZF;
    private int cZG;
    private int cZH;
    private int cZI;
    private int cZJ;
    private Drawable cZK;
    private Drawable cZL;
    private Drawable cZR;
    private final Rect cZS;
    private int cZT;
    private int cZU;
    private int cZV;
    private int cZW;
    private d cZX;
    private e cZY;
    private c cZZ;
    private b daa;
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

    private void apT() {
        if (this.cZK != null) {
            this.cZT = this.cZK.getIntrinsicWidth();
            this.cZU = this.cZK.getIntrinsicHeight();
            return;
        }
        this.cZT = 0;
        this.cZU = 0;
    }

    private void apU() {
        if (this.cZL != null) {
            this.cZV = this.cZL.getIntrinsicWidth();
            this.cZW = this.cZL.getIntrinsicHeight();
            return;
        }
        this.cZV = 0;
        this.cZW = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.cZL != null || this.cZK != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.mItemCount - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            Rect rect = this.cZS;
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
                            ExpandableHListConnector.b lg = this.cZC.lg(i4);
                            if (lg.cZw.type != i2) {
                                if (lg.cZw.type == 1) {
                                    rect.top = childAt.getTop() + this.cZI;
                                    rect.bottom = childAt.getBottom() + this.cZI;
                                } else {
                                    rect.top = childAt.getTop() + this.cZE;
                                    rect.bottom = childAt.getBottom() + this.cZE;
                                }
                                i2 = lg.cZw.type;
                            }
                            if (rect.top != rect.bottom) {
                                if (lg.cZw.type == 1) {
                                    rect.left = this.cZJ + left;
                                    rect.right = this.cZJ + right2;
                                } else {
                                    rect.left = this.cZF + left;
                                    rect.right = this.cZF + right2;
                                }
                                Drawable c2 = c(lg);
                                if (c2 != null) {
                                    if (lg.cZw.type == 1) {
                                        Gravity.apply(this.cZH, this.cZV, this.cZW, rect, this.mTempRect);
                                    } else {
                                        Gravity.apply(this.cZG, this.cZT, this.cZU, rect, this.mTempRect);
                                    }
                                    c2.setBounds(this.mTempRect);
                                    c2.draw(canvas);
                                }
                            }
                            lg.recycle();
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
        if (bVar.cZw.type == 2) {
            Drawable drawable = this.cZK;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            drawable.setState(cZP[(bVar.apQ() ? (char) 1 : (char) 0) | (bVar.cZx == null || bVar.cZx.cZr == bVar.cZx.cZq ? (char) 2 : (char) 0)]);
            return drawable;
        }
        Drawable drawable2 = this.cZL;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(bVar.cZw.cZB == bVar.cZx.cZr ? cZQ : EMPTY_STATE_SET);
        }
        return drawable2;
    }

    public void setChildDivider(Drawable drawable) {
        this.cZR = drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tieba.horizonalList.widget.HListView
    public void drawDivider(Canvas canvas, Rect rect, int i) {
        int i2 = this.mFirstPosition + i;
        if (i2 >= 0) {
            ExpandableHListConnector.b lg = this.cZC.lg(lj(i2));
            if (lg.cZw.type == 1 || (lg.apQ() && lg.cZx.cZr != lg.cZx.cZq)) {
                Drawable drawable = this.cZR;
                drawable.setBounds(rect);
                drawable.draw(canvas);
                lg.recycle();
                return;
            }
            lg.recycle();
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
        this.cZD = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.cZC = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.cZC = null;
        }
        super.setAdapter((ListAdapter) this.cZC);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.cZD;
    }

    private boolean isHeaderOrFooterPosition(int i) {
        return i < getHeaderViewsCount() || i >= this.mItemCount - getFooterViewsCount();
    }

    private int lj(int i) {
        return i - getHeaderViewsCount();
    }

    private int lk(int i) {
        return getHeaderViewsCount() + i;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.a
    public boolean performItemClick(View view, int i, long j) {
        if (isHeaderOrFooterPosition(i)) {
            return super.performItemClick(view, i, j);
        }
        return c(view, lj(i), j);
    }

    boolean c(View view, int i, long j) {
        boolean z;
        ExpandableHListConnector.b lg = this.cZC.lg(i);
        long b2 = b(lg.cZw);
        if (lg.cZw.type == 2) {
            if (this.cZZ != null && this.cZZ.a(this, view, lg.cZw.cZz, b2)) {
                lg.recycle();
                return true;
            }
            if (lg.apQ()) {
                this.cZC.a(lg);
                playSoundEffect(0);
                if (this.cZX != null) {
                    this.cZX.onGroupCollapse(lg.cZw.cZz);
                }
            } else {
                this.cZC.b(lg);
                playSoundEffect(0);
                if (this.cZY != null) {
                    this.cZY.onGroupExpand(lg.cZw.cZz);
                }
                int i2 = lg.cZw.cZz;
                int headerViewsCount = lg.cZw.cZB + getHeaderViewsCount();
                smoothScrollToPosition(this.cZD.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.daa != null) {
            playSoundEffect(0);
            return this.daa.a(this, view, lg.cZw.cZz, lg.cZw.cZA, b2);
        } else {
            z = false;
        }
        lg.recycle();
        return z;
    }

    public void setOnGroupCollapseListener(d dVar) {
        this.cZX = dVar;
    }

    public void setOnGroupExpandListener(e eVar) {
        this.cZY = eVar;
    }

    public void setOnGroupClickListener(c cVar) {
        this.cZZ = cVar;
    }

    public void setOnChildClickListener(b bVar) {
        this.daa = bVar;
    }

    public long getExpandableListPosition(int i) {
        if (isHeaderOrFooterPosition(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b lg = this.cZC.lg(lj(i));
        long apR = lg.cZw.apR();
        lg.recycle();
        return apR;
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
            return this.cZD.getGroupId(packedPositionGroup);
        }
        return this.cZD.getChildId(packedPositionGroup, getPackedPositionChild(selectedPosition));
    }

    public void setSelectedGroup(int i) {
        com.baidu.tieba.horizonalList.widget.b li = com.baidu.tieba.horizonalList.widget.b.li(i);
        ExpandableHListConnector.b a2 = this.cZC.a(li);
        li.recycle();
        super.setSelection(lk(a2.cZw.cZB));
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
            return new a.ContextMenu$ContextMenuInfoC0090a(view, i, j);
        }
        ExpandableHListConnector.b lg = this.cZC.lg(lj(i));
        com.baidu.tieba.horizonalList.widget.b bVar = lg.cZw;
        long b2 = b(bVar);
        long apR = bVar.apR();
        lg.recycle();
        return new a(view, apR, b2);
    }

    private long b(com.baidu.tieba.horizonalList.widget.b bVar) {
        return bVar.type == 1 ? this.cZD.getChildId(bVar.cZz, bVar.cZA) : this.cZD.getGroupId(bVar.cZz);
    }

    public void setChildIndicator(Drawable drawable) {
        this.cZL = drawable;
        apU();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.cZK = drawable;
        apT();
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
            /* renamed from: o */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: ll */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        ArrayList<ExpandableHListConnector.GroupMetadata> dab;

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.dab = arrayList;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.dab = new ArrayList<>();
            parcel.readList(this.dab, ExpandableHListConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.dab);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.cZC != null ? this.cZC.apO() : null);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.cZC != null && savedState.dab != null) {
            this.cZC.S(savedState.dab);
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
