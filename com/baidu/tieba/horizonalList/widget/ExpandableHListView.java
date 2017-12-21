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
    private Drawable duB;
    private final Rect duC;
    private int duD;
    private int duE;
    private int duF;
    private int duG;
    private d duH;
    private e duI;
    private c duJ;
    private b duK;
    private ExpandableHListConnector dum;
    private ExpandableListAdapter dun;
    private int duo;
    private int dup;
    private int duq;
    private int dur;
    private int dus;
    private int dut;
    private Drawable duu;
    private Drawable duv;
    private final Rect mTempRect;
    private static final int[] EMPTY_STATE_SET = new int[0];
    private static final int[] duw = {16842920};
    private static final int[] dux = {16842921};
    private static final int[] duy = {16842920, 16842921};
    private static final int[][] duz = {EMPTY_STATE_SET, duw, dux, duy};
    private static final int[] duA = {16842918};

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

    private void auO() {
        if (this.duu != null) {
            this.duD = this.duu.getIntrinsicWidth();
            this.duE = this.duu.getIntrinsicHeight();
            return;
        }
        this.duD = 0;
        this.duE = 0;
    }

    private void auP() {
        if (this.duv != null) {
            this.duF = this.duv.getIntrinsicWidth();
            this.duG = this.duv.getIntrinsicHeight();
            return;
        }
        this.duF = 0;
        this.duG = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.duv != null || this.duu != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.mItemCount - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            Rect rect = this.duC;
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
                            ExpandableHListConnector.b mn = this.dum.mn(i4);
                            if (mn.dug.type != i2) {
                                if (mn.dug.type == 1) {
                                    rect.top = childAt.getTop() + this.dus;
                                    rect.bottom = childAt.getBottom() + this.dus;
                                } else {
                                    rect.top = childAt.getTop() + this.duo;
                                    rect.bottom = childAt.getBottom() + this.duo;
                                }
                                i2 = mn.dug.type;
                            }
                            if (rect.top != rect.bottom) {
                                if (mn.dug.type == 1) {
                                    rect.left = this.dut + left;
                                    rect.right = this.dut + right2;
                                } else {
                                    rect.left = this.dup + left;
                                    rect.right = this.dup + right2;
                                }
                                Drawable c2 = c(mn);
                                if (c2 != null) {
                                    if (mn.dug.type == 1) {
                                        Gravity.apply(this.dur, this.duF, this.duG, rect, this.mTempRect);
                                    } else {
                                        Gravity.apply(this.duq, this.duD, this.duE, rect, this.mTempRect);
                                    }
                                    c2.setBounds(this.mTempRect);
                                    c2.draw(canvas);
                                }
                            }
                            mn.recycle();
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
        if (bVar.dug.type == 2) {
            Drawable drawable = this.duu;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            drawable.setState(duz[(bVar.auL() ? (char) 1 : (char) 0) | (bVar.duh == null || bVar.duh.dub == bVar.duh.dua ? (char) 2 : (char) 0)]);
            return drawable;
        }
        Drawable drawable2 = this.duv;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(bVar.dug.dul == bVar.duh.dub ? duA : EMPTY_STATE_SET);
        }
        return drawable2;
    }

    public void setChildDivider(Drawable drawable) {
        this.duB = drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tieba.horizonalList.widget.HListView
    public void drawDivider(Canvas canvas, Rect rect, int i) {
        int i2 = this.mFirstPosition + i;
        if (i2 >= 0) {
            ExpandableHListConnector.b mn = this.dum.mn(mq(i2));
            if (mn.dug.type == 1 || (mn.auL() && mn.duh.dub != mn.duh.dua)) {
                Drawable drawable = this.duB;
                drawable.setBounds(rect);
                drawable.draw(canvas);
                mn.recycle();
                return;
            }
            mn.recycle();
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
        this.dun = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.dum = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.dum = null;
        }
        super.setAdapter((ListAdapter) this.dum);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.dun;
    }

    private boolean isHeaderOrFooterPosition(int i) {
        return i < getHeaderViewsCount() || i >= this.mItemCount - getFooterViewsCount();
    }

    private int mq(int i) {
        return i - getHeaderViewsCount();
    }

    private int mr(int i) {
        return getHeaderViewsCount() + i;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.a
    public boolean performItemClick(View view, int i, long j) {
        if (isHeaderOrFooterPosition(i)) {
            return super.performItemClick(view, i, j);
        }
        return b(view, mq(i), j);
    }

    boolean b(View view, int i, long j) {
        boolean z;
        ExpandableHListConnector.b mn = this.dum.mn(i);
        long b2 = b(mn.dug);
        if (mn.dug.type == 2) {
            if (this.duJ != null && this.duJ.a(this, view, mn.dug.duj, b2)) {
                mn.recycle();
                return true;
            }
            if (mn.auL()) {
                this.dum.a(mn);
                playSoundEffect(0);
                if (this.duH != null) {
                    this.duH.onGroupCollapse(mn.dug.duj);
                }
            } else {
                this.dum.b(mn);
                playSoundEffect(0);
                if (this.duI != null) {
                    this.duI.onGroupExpand(mn.dug.duj);
                }
                int i2 = mn.dug.duj;
                int headerViewsCount = mn.dug.dul + getHeaderViewsCount();
                smoothScrollToPosition(this.dun.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.duK != null) {
            playSoundEffect(0);
            return this.duK.a(this, view, mn.dug.duj, mn.dug.duk, b2);
        } else {
            z = false;
        }
        mn.recycle();
        return z;
    }

    public void setOnGroupCollapseListener(d dVar) {
        this.duH = dVar;
    }

    public void setOnGroupExpandListener(e eVar) {
        this.duI = eVar;
    }

    public void setOnGroupClickListener(c cVar) {
        this.duJ = cVar;
    }

    public void setOnChildClickListener(b bVar) {
        this.duK = bVar;
    }

    public long getExpandableListPosition(int i) {
        if (isHeaderOrFooterPosition(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b mn = this.dum.mn(mq(i));
        long auM = mn.dug.auM();
        mn.recycle();
        return auM;
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
            return this.dun.getGroupId(packedPositionGroup);
        }
        return this.dun.getChildId(packedPositionGroup, getPackedPositionChild(selectedPosition));
    }

    public void setSelectedGroup(int i) {
        com.baidu.tieba.horizonalList.widget.b mp = com.baidu.tieba.horizonalList.widget.b.mp(i);
        ExpandableHListConnector.b a2 = this.dum.a(mp);
        mp.recycle();
        super.setSelection(mr(a2.dug.dul));
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
            return new a.ContextMenu$ContextMenuInfoC0105a(view, i, j);
        }
        ExpandableHListConnector.b mn = this.dum.mn(mq(i));
        com.baidu.tieba.horizonalList.widget.b bVar = mn.dug;
        long b2 = b(bVar);
        long auM = bVar.auM();
        mn.recycle();
        return new a(view, auM, b2);
    }

    private long b(com.baidu.tieba.horizonalList.widget.b bVar) {
        return bVar.type == 1 ? this.dun.getChildId(bVar.duj, bVar.duk) : this.dun.getGroupId(bVar.duj);
    }

    public void setChildIndicator(Drawable drawable) {
        this.duv = drawable;
        auP();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.duu = drawable;
        auO();
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
            /* renamed from: ms */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        ArrayList<ExpandableHListConnector.GroupMetadata> duL;

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.duL = arrayList;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.duL = new ArrayList<>();
            parcel.readList(this.duL, ExpandableHListConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.duL);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.dum != null ? this.dum.auJ() : null);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.dum != null && savedState.duL != null) {
            this.dum.R(savedState.duL);
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
