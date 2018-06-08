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
    private static final int[] dTu = {16842920};
    private static final int[] dTv = {16842921};
    private static final int[] dTw = {16842920, 16842921};
    private static final int[][] dTx = {EMPTY_STATE_SET, dTu, dTv, dTw};
    private static final int[] dTy = {16842918};
    private final Rect dTA;
    private int dTB;
    private int dTC;
    private int dTD;
    private int dTE;
    private d dTF;
    private e dTG;
    private c dTH;
    private b dTI;
    private ExpandableHListConnector dTl;
    private ExpandableListAdapter dTm;
    private int dTn;
    private int dTo;
    private int dTp;
    private int dTq;
    private int dTr;
    private Drawable dTs;
    private Drawable dTt;
    private Drawable dTz;
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
        this.dTA = new Rect();
        this.mTempRect = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.m.ExpandableHListView, i, 0);
        setGroupIndicator(obtainStyledAttributes.getDrawable(d.m.ExpandableHListView_hlv_groupIndicator));
        setChildIndicator(obtainStyledAttributes.getDrawable(d.m.ExpandableHListView_hlv_childIndicator));
        this.mIndicatorLeft = obtainStyledAttributes.getDimensionPixelSize(d.m.ExpandableHListView_hlv_indicatorPaddingLeft, 0);
        this.dTn = obtainStyledAttributes.getDimensionPixelSize(d.m.ExpandableHListView_hlv_indicatorPaddingTop, 0);
        this.dTo = obtainStyledAttributes.getInt(d.m.ExpandableHListView_hlv_indicatorGravity, 0);
        this.dTp = obtainStyledAttributes.getInt(d.m.ExpandableHListView_hlv_childIndicatorGravity, 0);
        this.dTr = obtainStyledAttributes.getDimensionPixelSize(d.m.ExpandableHListView_hlv_childIndicatorPaddingLeft, 0);
        this.dTq = obtainStyledAttributes.getDimensionPixelSize(d.m.ExpandableHListView_hlv_childIndicatorPaddingTop, 0);
        this.dTz = obtainStyledAttributes.getDrawable(d.m.ExpandableHListView_hlv_childDivider);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        aDm();
        aDn();
    }

    private void aDm() {
        if (this.dTs != null) {
            this.dTB = this.dTs.getIntrinsicWidth();
            this.dTC = this.dTs.getIntrinsicHeight();
            return;
        }
        this.dTB = 0;
        this.dTC = 0;
    }

    private void aDn() {
        if (this.dTt != null) {
            this.dTD = this.dTt.getIntrinsicWidth();
            this.dTE = this.dTt.getIntrinsicHeight();
            return;
        }
        this.dTD = 0;
        this.dTE = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.dTt != null || this.dTs != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.mItemCount - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            Rect rect = this.dTA;
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
                            ExpandableHListConnector.b mI = this.dTl.mI(i4);
                            if (mI.dTf.type != i2) {
                                if (mI.dTf.type == 1) {
                                    rect.top = childAt.getTop() + this.dTq;
                                    rect.bottom = childAt.getBottom() + this.dTq;
                                } else {
                                    rect.top = childAt.getTop() + this.dTn;
                                    rect.bottom = childAt.getBottom() + this.dTn;
                                }
                                i2 = mI.dTf.type;
                            }
                            if (rect.top != rect.bottom) {
                                if (mI.dTf.type == 1) {
                                    rect.left = this.dTr + left;
                                    rect.right = this.dTr + right2;
                                } else {
                                    rect.left = this.mIndicatorLeft + left;
                                    rect.right = this.mIndicatorLeft + right2;
                                }
                                Drawable c2 = c(mI);
                                if (c2 != null) {
                                    if (mI.dTf.type == 1) {
                                        Gravity.apply(this.dTp, this.dTD, this.dTE, rect, this.mTempRect);
                                    } else {
                                        Gravity.apply(this.dTo, this.dTB, this.dTC, rect, this.mTempRect);
                                    }
                                    c2.setBounds(this.mTempRect);
                                    c2.draw(canvas);
                                }
                            }
                            mI.recycle();
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
        if (bVar.dTf.type == 2) {
            Drawable drawable = this.dTs;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            drawable.setState(dTx[(bVar.arQ() ? (char) 1 : (char) 0) | (bVar.dTg == null || bVar.dTg.dTa == bVar.dTg.dSZ ? (char) 2 : (char) 0)]);
            return drawable;
        }
        Drawable drawable2 = this.dTt;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(bVar.dTf.dTk == bVar.dTg.dTa ? dTy : EMPTY_STATE_SET);
        }
        return drawable2;
    }

    public void setChildDivider(Drawable drawable) {
        this.dTz = drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tieba.horizonalList.widget.HListView
    public void drawDivider(Canvas canvas, Rect rect, int i) {
        int i2 = this.mFirstPosition + i;
        if (i2 >= 0) {
            ExpandableHListConnector.b mI = this.dTl.mI(mL(i2));
            if (mI.dTf.type == 1 || (mI.arQ() && mI.dTg.dTa != mI.dTg.dSZ)) {
                Drawable drawable = this.dTz;
                drawable.setBounds(rect);
                drawable.draw(canvas);
                mI.recycle();
                return;
            }
            mI.recycle();
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
        this.dTm = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.dTl = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.dTl = null;
        }
        super.setAdapter((ListAdapter) this.dTl);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.dTm;
    }

    private boolean isHeaderOrFooterPosition(int i) {
        return i < getHeaderViewsCount() || i >= this.mItemCount - getFooterViewsCount();
    }

    private int mL(int i) {
        return i - getHeaderViewsCount();
    }

    private int mM(int i) {
        return getHeaderViewsCount() + i;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.AdapterView
    public boolean performItemClick(View view, int i, long j) {
        if (isHeaderOrFooterPosition(i)) {
            return super.performItemClick(view, i, j);
        }
        return e(view, mL(i), j);
    }

    boolean e(View view, int i, long j) {
        boolean z;
        ExpandableHListConnector.b mI = this.dTl.mI(i);
        long b2 = b(mI.dTf);
        if (mI.dTf.type == 2) {
            if (this.dTH != null && this.dTH.a(this, view, mI.dTf.dTi, b2)) {
                mI.recycle();
                return true;
            }
            if (mI.arQ()) {
                this.dTl.a(mI);
                playSoundEffect(0);
                if (this.dTF != null) {
                    this.dTF.onGroupCollapse(mI.dTf.dTi);
                }
            } else {
                this.dTl.b(mI);
                playSoundEffect(0);
                if (this.dTG != null) {
                    this.dTG.onGroupExpand(mI.dTf.dTi);
                }
                int i2 = mI.dTf.dTi;
                int headerViewsCount = mI.dTf.dTk + getHeaderViewsCount();
                smoothScrollToPosition(this.dTm.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.dTI != null) {
            playSoundEffect(0);
            return this.dTI.a(this, view, mI.dTf.dTi, mI.dTf.dTj, b2);
        } else {
            z = false;
        }
        mI.recycle();
        return z;
    }

    public void setOnGroupCollapseListener(d dVar) {
        this.dTF = dVar;
    }

    public void setOnGroupExpandListener(e eVar) {
        this.dTG = eVar;
    }

    public void setOnGroupClickListener(c cVar) {
        this.dTH = cVar;
    }

    public void setOnChildClickListener(b bVar) {
        this.dTI = bVar;
    }

    public long getExpandableListPosition(int i) {
        if (isHeaderOrFooterPosition(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b mI = this.dTl.mI(mL(i));
        long aDk = mI.dTf.aDk();
        mI.recycle();
        return aDk;
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
            return this.dTm.getGroupId(packedPositionGroup);
        }
        return this.dTm.getChildId(packedPositionGroup, getPackedPositionChild(selectedPosition));
    }

    public void setSelectedGroup(int i) {
        com.baidu.tieba.horizonalList.widget.a mK = com.baidu.tieba.horizonalList.widget.a.mK(i);
        ExpandableHListConnector.b a2 = this.dTl.a(mK);
        mK.recycle();
        super.setSelection(mM(a2.dTf.dTk));
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
        ExpandableHListConnector.b mI = this.dTl.mI(mL(i));
        com.baidu.tieba.horizonalList.widget.a aVar = mI.dTf;
        long b2 = b(aVar);
        long aDk = aVar.aDk();
        mI.recycle();
        return new a(view, aDk, b2);
    }

    private long b(com.baidu.tieba.horizonalList.widget.a aVar) {
        return aVar.type == 1 ? this.dTm.getChildId(aVar.dTi, aVar.dTj) : this.dTm.getGroupId(aVar.dTi);
    }

    public void setChildIndicator(Drawable drawable) {
        this.dTt = drawable;
        aDn();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.dTs = drawable;
        aDm();
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
            /* renamed from: mN */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        ArrayList<ExpandableHListConnector.GroupMetadata> dTJ;

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.dTJ = arrayList;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.dTJ = new ArrayList<>();
            parcel.readList(this.dTJ, ExpandableHListConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.dTJ);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.dTl != null ? this.dTl.aDi() : null);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.dTl != null && savedState.dTJ != null) {
            this.dTl.S(savedState.dTJ);
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
