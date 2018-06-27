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
    private static final int[] dXo = {16842920};
    private static final int[] dXp = {16842921};
    private static final int[] dXq = {16842920, 16842921};
    private static final int[][] dXr = {EMPTY_STATE_SET, dXo, dXp, dXq};
    private static final int[] dXs = {16842918};
    private e dXA;
    private c dXB;
    private b dXC;
    private ExpandableHListConnector dXf;
    private ExpandableListAdapter dXg;
    private int dXh;
    private int dXi;
    private int dXj;
    private int dXk;
    private int dXl;
    private Drawable dXm;
    private Drawable dXn;
    private Drawable dXt;
    private final Rect dXu;
    private int dXv;
    private int dXw;
    private int dXx;
    private int dXy;
    private d dXz;
    private int mIndicatorLeft;
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

    public ExpandableHListView(Context context) {
        this(context, null);
    }

    public ExpandableHListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, d.c.hlv_expandableListViewStyle);
    }

    public ExpandableHListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dXu = new Rect();
        this.mTempRect = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.m.ExpandableHListView, i, 0);
        setGroupIndicator(obtainStyledAttributes.getDrawable(d.m.ExpandableHListView_hlv_groupIndicator));
        setChildIndicator(obtainStyledAttributes.getDrawable(d.m.ExpandableHListView_hlv_childIndicator));
        this.mIndicatorLeft = obtainStyledAttributes.getDimensionPixelSize(d.m.ExpandableHListView_hlv_indicatorPaddingLeft, 0);
        this.dXh = obtainStyledAttributes.getDimensionPixelSize(d.m.ExpandableHListView_hlv_indicatorPaddingTop, 0);
        this.dXi = obtainStyledAttributes.getInt(d.m.ExpandableHListView_hlv_indicatorGravity, 0);
        this.dXj = obtainStyledAttributes.getInt(d.m.ExpandableHListView_hlv_childIndicatorGravity, 0);
        this.dXl = obtainStyledAttributes.getDimensionPixelSize(d.m.ExpandableHListView_hlv_childIndicatorPaddingLeft, 0);
        this.dXk = obtainStyledAttributes.getDimensionPixelSize(d.m.ExpandableHListView_hlv_childIndicatorPaddingTop, 0);
        this.dXt = obtainStyledAttributes.getDrawable(d.m.ExpandableHListView_hlv_childDivider);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        aDW();
        aDX();
    }

    private void aDW() {
        if (this.dXm != null) {
            this.dXv = this.dXm.getIntrinsicWidth();
            this.dXw = this.dXm.getIntrinsicHeight();
            return;
        }
        this.dXv = 0;
        this.dXw = 0;
    }

    private void aDX() {
        if (this.dXn != null) {
            this.dXx = this.dXn.getIntrinsicWidth();
            this.dXy = this.dXn.getIntrinsicHeight();
            return;
        }
        this.dXx = 0;
        this.dXy = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.dXn != null || this.dXm != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.mItemCount - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            Rect rect = this.dXu;
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
                            ExpandableHListConnector.b mP = this.dXf.mP(i4);
                            if (mP.dWZ.type != i2) {
                                if (mP.dWZ.type == 1) {
                                    rect.top = childAt.getTop() + this.dXk;
                                    rect.bottom = childAt.getBottom() + this.dXk;
                                } else {
                                    rect.top = childAt.getTop() + this.dXh;
                                    rect.bottom = childAt.getBottom() + this.dXh;
                                }
                                i2 = mP.dWZ.type;
                            }
                            if (rect.top != rect.bottom) {
                                if (mP.dWZ.type == 1) {
                                    rect.left = this.dXl + left;
                                    rect.right = this.dXl + right2;
                                } else {
                                    rect.left = this.mIndicatorLeft + left;
                                    rect.right = this.mIndicatorLeft + right2;
                                }
                                Drawable c2 = c(mP);
                                if (c2 != null) {
                                    if (mP.dWZ.type == 1) {
                                        Gravity.apply(this.dXj, this.dXx, this.dXy, rect, this.mTempRect);
                                    } else {
                                        Gravity.apply(this.dXi, this.dXv, this.dXw, rect, this.mTempRect);
                                    }
                                    c2.setBounds(this.mTempRect);
                                    c2.draw(canvas);
                                }
                            }
                            mP.recycle();
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
        if (bVar.dWZ.type == 2) {
            Drawable drawable = this.dXm;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            drawable.setState(dXr[(bVar.arl() ? (char) 1 : (char) 0) | (bVar.dXa == null || bVar.dXa.dWU == bVar.dXa.dWT ? (char) 2 : (char) 0)]);
            return drawable;
        }
        Drawable drawable2 = this.dXn;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(bVar.dWZ.dXe == bVar.dXa.dWU ? dXs : EMPTY_STATE_SET);
        }
        return drawable2;
    }

    public void setChildDivider(Drawable drawable) {
        this.dXt = drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tieba.horizonalList.widget.HListView
    public void drawDivider(Canvas canvas, Rect rect, int i) {
        int i2 = this.mFirstPosition + i;
        if (i2 >= 0) {
            ExpandableHListConnector.b mP = this.dXf.mP(mS(i2));
            if (mP.dWZ.type == 1 || (mP.arl() && mP.dXa.dWU != mP.dXa.dWT)) {
                Drawable drawable = this.dXt;
                drawable.setBounds(rect);
                drawable.draw(canvas);
                mP.recycle();
                return;
            }
            mP.recycle();
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
        this.dXg = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.dXf = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.dXf = null;
        }
        super.setAdapter((ListAdapter) this.dXf);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.dXg;
    }

    private boolean isHeaderOrFooterPosition(int i) {
        return i < getHeaderViewsCount() || i >= this.mItemCount - getFooterViewsCount();
    }

    private int mS(int i) {
        return i - getHeaderViewsCount();
    }

    private int mT(int i) {
        return getHeaderViewsCount() + i;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.AdapterView
    public boolean performItemClick(View view, int i, long j) {
        if (isHeaderOrFooterPosition(i)) {
            return super.performItemClick(view, i, j);
        }
        return e(view, mS(i), j);
    }

    boolean e(View view, int i, long j) {
        boolean z;
        ExpandableHListConnector.b mP = this.dXf.mP(i);
        long b2 = b(mP.dWZ);
        if (mP.dWZ.type == 2) {
            if (this.dXB != null && this.dXB.a(this, view, mP.dWZ.dXc, b2)) {
                mP.recycle();
                return true;
            }
            if (mP.arl()) {
                this.dXf.a(mP);
                playSoundEffect(0);
                if (this.dXz != null) {
                    this.dXz.onGroupCollapse(mP.dWZ.dXc);
                }
            } else {
                this.dXf.b(mP);
                playSoundEffect(0);
                if (this.dXA != null) {
                    this.dXA.onGroupExpand(mP.dWZ.dXc);
                }
                int i2 = mP.dWZ.dXc;
                int headerViewsCount = mP.dWZ.dXe + getHeaderViewsCount();
                smoothScrollToPosition(this.dXg.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.dXC != null) {
            playSoundEffect(0);
            return this.dXC.a(this, view, mP.dWZ.dXc, mP.dWZ.dXd, b2);
        } else {
            z = false;
        }
        mP.recycle();
        return z;
    }

    public void setOnGroupCollapseListener(d dVar) {
        this.dXz = dVar;
    }

    public void setOnGroupExpandListener(e eVar) {
        this.dXA = eVar;
    }

    public void setOnGroupClickListener(c cVar) {
        this.dXB = cVar;
    }

    public void setOnChildClickListener(b bVar) {
        this.dXC = bVar;
    }

    public long getExpandableListPosition(int i) {
        if (isHeaderOrFooterPosition(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b mP = this.dXf.mP(mS(i));
        long aDU = mP.dWZ.aDU();
        mP.recycle();
        return aDU;
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
            return this.dXg.getGroupId(packedPositionGroup);
        }
        return this.dXg.getChildId(packedPositionGroup, getPackedPositionChild(selectedPosition));
    }

    public void setSelectedGroup(int i) {
        com.baidu.tieba.horizonalList.widget.a mR = com.baidu.tieba.horizonalList.widget.a.mR(i);
        ExpandableHListConnector.b a2 = this.dXf.a(mR);
        mR.recycle();
        super.setSelection(mT(a2.dWZ.dXe));
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
            return new AdapterView.a(view, i, j);
        }
        ExpandableHListConnector.b mP = this.dXf.mP(mS(i));
        com.baidu.tieba.horizonalList.widget.a aVar = mP.dWZ;
        long b2 = b(aVar);
        long aDU = aVar.aDU();
        mP.recycle();
        return new a(view, aDU, b2);
    }

    private long b(com.baidu.tieba.horizonalList.widget.a aVar) {
        return aVar.type == 1 ? this.dXg.getChildId(aVar.dXc, aVar.dXd) : this.dXg.getGroupId(aVar.dXc);
    }

    public void setChildIndicator(Drawable drawable) {
        this.dXn = drawable;
        aDX();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.dXm = drawable;
        aDW();
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
            /* renamed from: s */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: mU */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        ArrayList<ExpandableHListConnector.GroupMetadata> dXD;

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.dXD = arrayList;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.dXD = new ArrayList<>();
            parcel.readList(this.dXD, ExpandableHListConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.dXD);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.dXf != null ? this.dXf.aDS() : null);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.dXf != null && savedState.dXD != null) {
            this.dXf.Y(savedState.dXD);
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
