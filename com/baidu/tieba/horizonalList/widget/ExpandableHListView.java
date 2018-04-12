package com.baidu.tieba.horizonalList.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ExpandableListAdapter;
import android.widget.ListAdapter;
import com.baidu.tieba.d;
import com.baidu.tieba.horizonalList.widget.AdapterView;
import com.baidu.tieba.horizonalList.widget.ExpandableHListConnector;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ExpandableHListView extends HListView {
    private static final int[] EMPTY_STATE_SET = new int[0];
    private static final int[] dHg = {16842920};
    private static final int[] dHh = {16842921};
    private static final int[] dHi = {16842920, 16842921};
    private static final int[][] dHj = {EMPTY_STATE_SET, dHg, dHh, dHi};
    private static final int[] dHk = {16842918};
    private ExpandableHListConnector dGX;
    private ExpandableListAdapter dGY;
    private int dGZ;
    private int dHa;
    private int dHb;
    private int dHc;
    private int dHd;
    private Drawable dHe;
    private Drawable dHf;
    private Drawable dHl;
    private final Rect dHm;
    private int dHn;
    private int dHo;
    private int dHp;
    private int dHq;
    private d dHr;
    private e dHs;
    private c dHt;
    private b dHu;
    private int mIndicatorLeft;
    private final Rect mTempRect;

    /* loaded from: classes.dex */
    public interface b {
        boolean a(ExpandableHListView expandableHListView, View view2, int i, int i2, long j);
    }

    /* loaded from: classes.dex */
    public interface c {
        boolean a(ExpandableHListView expandableHListView, View view2, int i, long j);
    }

    /* loaded from: classes.dex */
    public interface d {
        void onGroupCollapse(int i);
    }

    /* loaded from: classes.dex */
    public interface e {
        void onGroupExpand(int i);
    }

    public ExpandableHListView(Context context) {
        this(context, null);
    }

    public ExpandableHListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, d.c.hlv_expandableListViewStyle);
    }

    public ExpandableHListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dHm = new Rect();
        this.mTempRect = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.m.ExpandableHListView, i, 0);
        setGroupIndicator(obtainStyledAttributes.getDrawable(d.m.ExpandableHListView_hlv_groupIndicator));
        setChildIndicator(obtainStyledAttributes.getDrawable(d.m.ExpandableHListView_hlv_childIndicator));
        this.mIndicatorLeft = obtainStyledAttributes.getDimensionPixelSize(d.m.ExpandableHListView_hlv_indicatorPaddingLeft, 0);
        this.dGZ = obtainStyledAttributes.getDimensionPixelSize(d.m.ExpandableHListView_hlv_indicatorPaddingTop, 0);
        this.dHa = obtainStyledAttributes.getInt(d.m.ExpandableHListView_hlv_indicatorGravity, 0);
        this.dHb = obtainStyledAttributes.getInt(d.m.ExpandableHListView_hlv_childIndicatorGravity, 0);
        this.dHd = obtainStyledAttributes.getDimensionPixelSize(d.m.ExpandableHListView_hlv_childIndicatorPaddingLeft, 0);
        this.dHc = obtainStyledAttributes.getDimensionPixelSize(d.m.ExpandableHListView_hlv_childIndicatorPaddingTop, 0);
        this.dHl = obtainStyledAttributes.getDrawable(d.m.ExpandableHListView_hlv_childDivider);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        ayt();
        ayu();
    }

    private void ayt() {
        if (this.dHe != null) {
            this.dHn = this.dHe.getIntrinsicWidth();
            this.dHo = this.dHe.getIntrinsicHeight();
            return;
        }
        this.dHn = 0;
        this.dHo = 0;
    }

    private void ayu() {
        if (this.dHf != null) {
            this.dHp = this.dHf.getIntrinsicWidth();
            this.dHq = this.dHf.getIntrinsicHeight();
            return;
        }
        this.dHp = 0;
        this.dHq = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.dHf != null || this.dHe != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.mItemCount - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            Rect rect = this.dHm;
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
                            ExpandableHListConnector.b my = this.dGX.my(i4);
                            if (my.dGR.type != i2) {
                                if (my.dGR.type == 1) {
                                    rect.top = childAt.getTop() + this.dHc;
                                    rect.bottom = childAt.getBottom() + this.dHc;
                                } else {
                                    rect.top = childAt.getTop() + this.dGZ;
                                    rect.bottom = childAt.getBottom() + this.dGZ;
                                }
                                i2 = my.dGR.type;
                            }
                            if (rect.top != rect.bottom) {
                                if (my.dGR.type == 1) {
                                    rect.left = this.dHd + left;
                                    rect.right = this.dHd + right2;
                                } else {
                                    rect.left = this.mIndicatorLeft + left;
                                    rect.right = this.mIndicatorLeft + right2;
                                }
                                Drawable c2 = c(my);
                                if (c2 != null) {
                                    if (my.dGR.type == 1) {
                                        Gravity.apply(this.dHb, this.dHp, this.dHq, rect, this.mTempRect);
                                    } else {
                                        Gravity.apply(this.dHa, this.dHn, this.dHo, rect, this.mTempRect);
                                    }
                                    c2.setBounds(this.mTempRect);
                                    c2.draw(canvas);
                                }
                            }
                            my.recycle();
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
        if (bVar.dGR.type == 2) {
            Drawable drawable = this.dHe;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            drawable.setState(dHj[(bVar.anM() ? (char) 1 : (char) 0) | (bVar.dGS == null || bVar.dGS.dGM == bVar.dGS.dGL ? (char) 2 : (char) 0)]);
            return drawable;
        }
        Drawable drawable2 = this.dHf;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(bVar.dGR.dGW == bVar.dGS.dGM ? dHk : EMPTY_STATE_SET);
        }
        return drawable2;
    }

    public void setChildDivider(Drawable drawable) {
        this.dHl = drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tieba.horizonalList.widget.HListView
    public void drawDivider(Canvas canvas, Rect rect, int i) {
        int i2 = this.mFirstPosition + i;
        if (i2 >= 0) {
            ExpandableHListConnector.b my = this.dGX.my(mB(i2));
            if (my.dGR.type == 1 || (my.anM() && my.dGS.dGM != my.dGS.dGL)) {
                Drawable drawable = this.dHl;
                drawable.setBounds(rect);
                drawable.draw(canvas);
                my.recycle();
                return;
            }
            my.recycle();
        }
        super.drawDivider(canvas, rect, i2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        throw new RuntimeException("For ExpandableListView, use setAdapter(ExpandableListAdapter) instead of setAdapter(ListAdapter)");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AdapterView
    public ListAdapter getAdapter() {
        return super.getAdapter();
    }

    @Override // com.baidu.tieba.horizonalList.widget.AdapterView
    public void setOnItemClickListener(AdapterView.c cVar) {
        super.setOnItemClickListener(cVar);
    }

    public void setAdapter(ExpandableListAdapter expandableListAdapter) {
        this.dGY = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.dGX = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.dGX = null;
        }
        super.setAdapter((ListAdapter) this.dGX);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.dGY;
    }

    private boolean isHeaderOrFooterPosition(int i) {
        return i < getHeaderViewsCount() || i >= this.mItemCount - getFooterViewsCount();
    }

    private int mB(int i) {
        return i - getHeaderViewsCount();
    }

    private int mC(int i) {
        return getHeaderViewsCount() + i;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.AdapterView
    public boolean performItemClick(View view2, int i, long j) {
        if (isHeaderOrFooterPosition(i)) {
            return super.performItemClick(view2, i, j);
        }
        return e(view2, mB(i), j);
    }

    boolean e(View view2, int i, long j) {
        boolean z;
        ExpandableHListConnector.b my = this.dGX.my(i);
        long b2 = b(my.dGR);
        if (my.dGR.type == 2) {
            if (this.dHt != null && this.dHt.a(this, view2, my.dGR.dGU, b2)) {
                my.recycle();
                return true;
            }
            if (my.anM()) {
                this.dGX.a(my);
                playSoundEffect(0);
                if (this.dHr != null) {
                    this.dHr.onGroupCollapse(my.dGR.dGU);
                }
            } else {
                this.dGX.b(my);
                playSoundEffect(0);
                if (this.dHs != null) {
                    this.dHs.onGroupExpand(my.dGR.dGU);
                }
                int i2 = my.dGR.dGU;
                int headerViewsCount = my.dGR.dGW + getHeaderViewsCount();
                smoothScrollToPosition(this.dGY.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.dHu != null) {
            playSoundEffect(0);
            return this.dHu.a(this, view2, my.dGR.dGU, my.dGR.dGV, b2);
        } else {
            z = false;
        }
        my.recycle();
        return z;
    }

    public void setOnGroupCollapseListener(d dVar) {
        this.dHr = dVar;
    }

    public void setOnGroupExpandListener(e eVar) {
        this.dHs = eVar;
    }

    public void setOnGroupClickListener(c cVar) {
        this.dHt = cVar;
    }

    public void setOnChildClickListener(b bVar) {
        this.dHu = bVar;
    }

    public long getExpandableListPosition(int i) {
        if (isHeaderOrFooterPosition(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b my = this.dGX.my(mB(i));
        long ayr = my.dGR.ayr();
        my.recycle();
        return ayr;
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
            return this.dGY.getGroupId(packedPositionGroup);
        }
        return this.dGY.getChildId(packedPositionGroup, getPackedPositionChild(selectedPosition));
    }

    public void setSelectedGroup(int i) {
        com.baidu.tieba.horizonalList.widget.a mA = com.baidu.tieba.horizonalList.widget.a.mA(i);
        ExpandableHListConnector.b a2 = this.dGX.a(mA);
        mA.recycle();
        super.setSelection(mC(a2.dGR.dGW));
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
    ContextMenu.ContextMenuInfo createContextMenuInfo(View view2, int i, long j) {
        if (isHeaderOrFooterPosition(i)) {
            return new AdapterView.a(view2, i, j);
        }
        ExpandableHListConnector.b my = this.dGX.my(mB(i));
        com.baidu.tieba.horizonalList.widget.a aVar = my.dGR;
        long b2 = b(aVar);
        long ayr = aVar.ayr();
        my.recycle();
        return new a(view2, ayr, b2);
    }

    private long b(com.baidu.tieba.horizonalList.widget.a aVar) {
        return aVar.type == 1 ? this.dGY.getChildId(aVar.dGU, aVar.dGV) : this.dGY.getGroupId(aVar.dGU);
    }

    public void setChildIndicator(Drawable drawable) {
        this.dHf = drawable;
        ayu();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.dHe = drawable;
        ayt();
    }

    /* loaded from: classes.dex */
    public static class a implements ContextMenu.ContextMenuInfo {
        public long id;
        public long packedPosition;
        public View targetView;

        public a(View view2, long j, long j2) {
            this.targetView = view2;
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
            /* renamed from: q */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: mD */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        ArrayList<ExpandableHListConnector.GroupMetadata> dHv;

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.dHv = arrayList;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.dHv = new ArrayList<>();
            parcel.readList(this.dHv, ExpandableHListConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.dHv);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.dGX != null ? this.dGX.ayp() : null);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.dGX != null && savedState.dHv != null) {
            this.dGX.S(savedState.dHv);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.AdapterView, android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(ExpandableHListView.class.getName());
    }

    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.AdapterView, android.view.View
    @TargetApi(14)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(ExpandableHListView.class.getName());
    }
}
