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
    private static final int[] dus = {16842920};
    private static final int[] dut = {16842921};
    private static final int[] duu = {16842920, 16842921};
    private static final int[][] duv = {EMPTY_STATE_SET, dus, dut, duu};
    private static final int[] duw = {16842918};
    private int duA;
    private int duB;
    private int duC;
    private d duD;
    private e duE;
    private c duF;
    private b duG;
    private ExpandableHListConnector dui;
    private ExpandableListAdapter duj;
    private int duk;
    private int dul;
    private int dum;
    private int dun;
    private int duo;
    private int dup;
    private Drawable duq;
    private Drawable dur;
    private Drawable dux;
    private final Rect duy;
    private int duz;
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

    private void auO() {
        if (this.duq != null) {
            this.duz = this.duq.getIntrinsicWidth();
            this.duA = this.duq.getIntrinsicHeight();
            return;
        }
        this.duz = 0;
        this.duA = 0;
    }

    private void auP() {
        if (this.dur != null) {
            this.duB = this.dur.getIntrinsicWidth();
            this.duC = this.dur.getIntrinsicHeight();
            return;
        }
        this.duB = 0;
        this.duC = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.dur != null || this.duq != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.mItemCount - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            Rect rect = this.duy;
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
                            ExpandableHListConnector.b mn = this.dui.mn(i4);
                            if (mn.duc.type != i2) {
                                if (mn.duc.type == 1) {
                                    rect.top = childAt.getTop() + this.duo;
                                    rect.bottom = childAt.getBottom() + this.duo;
                                } else {
                                    rect.top = childAt.getTop() + this.duk;
                                    rect.bottom = childAt.getBottom() + this.duk;
                                }
                                i2 = mn.duc.type;
                            }
                            if (rect.top != rect.bottom) {
                                if (mn.duc.type == 1) {
                                    rect.left = this.dup + left;
                                    rect.right = this.dup + right2;
                                } else {
                                    rect.left = this.dul + left;
                                    rect.right = this.dul + right2;
                                }
                                Drawable c2 = c(mn);
                                if (c2 != null) {
                                    if (mn.duc.type == 1) {
                                        Gravity.apply(this.dun, this.duB, this.duC, rect, this.mTempRect);
                                    } else {
                                        Gravity.apply(this.dum, this.duz, this.duA, rect, this.mTempRect);
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
        if (bVar.duc.type == 2) {
            Drawable drawable = this.duq;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            drawable.setState(duv[(bVar.auL() ? (char) 1 : (char) 0) | (bVar.dud == null || bVar.dud.dtX == bVar.dud.dtW ? (char) 2 : (char) 0)]);
            return drawable;
        }
        Drawable drawable2 = this.dur;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(bVar.duc.duh == bVar.dud.dtX ? duw : EMPTY_STATE_SET);
        }
        return drawable2;
    }

    public void setChildDivider(Drawable drawable) {
        this.dux = drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tieba.horizonalList.widget.HListView
    public void drawDivider(Canvas canvas, Rect rect, int i) {
        int i2 = this.mFirstPosition + i;
        if (i2 >= 0) {
            ExpandableHListConnector.b mn = this.dui.mn(mq(i2));
            if (mn.duc.type == 1 || (mn.auL() && mn.dud.dtX != mn.dud.dtW)) {
                Drawable drawable = this.dux;
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
        this.duj = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.dui = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.dui = null;
        }
        super.setAdapter((ListAdapter) this.dui);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.duj;
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
        ExpandableHListConnector.b mn = this.dui.mn(i);
        long b2 = b(mn.duc);
        if (mn.duc.type == 2) {
            if (this.duF != null && this.duF.a(this, view, mn.duc.duf, b2)) {
                mn.recycle();
                return true;
            }
            if (mn.auL()) {
                this.dui.a(mn);
                playSoundEffect(0);
                if (this.duD != null) {
                    this.duD.onGroupCollapse(mn.duc.duf);
                }
            } else {
                this.dui.b(mn);
                playSoundEffect(0);
                if (this.duE != null) {
                    this.duE.onGroupExpand(mn.duc.duf);
                }
                int i2 = mn.duc.duf;
                int headerViewsCount = mn.duc.duh + getHeaderViewsCount();
                smoothScrollToPosition(this.duj.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.duG != null) {
            playSoundEffect(0);
            return this.duG.a(this, view, mn.duc.duf, mn.duc.dug, b2);
        } else {
            z = false;
        }
        mn.recycle();
        return z;
    }

    public void setOnGroupCollapseListener(d dVar) {
        this.duD = dVar;
    }

    public void setOnGroupExpandListener(e eVar) {
        this.duE = eVar;
    }

    public void setOnGroupClickListener(c cVar) {
        this.duF = cVar;
    }

    public void setOnChildClickListener(b bVar) {
        this.duG = bVar;
    }

    public long getExpandableListPosition(int i) {
        if (isHeaderOrFooterPosition(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b mn = this.dui.mn(mq(i));
        long auM = mn.duc.auM();
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
            return this.duj.getGroupId(packedPositionGroup);
        }
        return this.duj.getChildId(packedPositionGroup, getPackedPositionChild(selectedPosition));
    }

    public void setSelectedGroup(int i) {
        com.baidu.tieba.horizonalList.widget.b mp = com.baidu.tieba.horizonalList.widget.b.mp(i);
        ExpandableHListConnector.b a2 = this.dui.a(mp);
        mp.recycle();
        super.setSelection(mr(a2.duc.duh));
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
            return new a.ContextMenu$ContextMenuInfoC0106a(view, i, j);
        }
        ExpandableHListConnector.b mn = this.dui.mn(mq(i));
        com.baidu.tieba.horizonalList.widget.b bVar = mn.duc;
        long b2 = b(bVar);
        long auM = bVar.auM();
        mn.recycle();
        return new a(view, auM, b2);
    }

    private long b(com.baidu.tieba.horizonalList.widget.b bVar) {
        return bVar.type == 1 ? this.duj.getChildId(bVar.duf, bVar.dug) : this.duj.getGroupId(bVar.duf);
    }

    public void setChildIndicator(Drawable drawable) {
        this.dur = drawable;
        auP();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.duq = drawable;
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
        ArrayList<ExpandableHListConnector.GroupMetadata> duH;

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.duH = arrayList;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.duH = new ArrayList<>();
            parcel.readList(this.duH, ExpandableHListConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.duH);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.dui != null ? this.dui.auJ() : null);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.dui != null && savedState.duH != null) {
            this.dui.R(savedState.duH);
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
