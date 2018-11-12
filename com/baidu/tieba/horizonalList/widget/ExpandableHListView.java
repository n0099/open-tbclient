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
import com.baidu.tieba.e;
import com.baidu.tieba.horizonalList.widget.AdapterView;
import com.baidu.tieba.horizonalList.widget.ExpandableHListConnector;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ExpandableHListView extends HListView {
    private static final int[] EMPTY_STATE_SET = new int[0];
    private static final int[] erK = {16842920};
    private static final int[] erL = {16842921};
    private static final int[] erM = {16842920, 16842921};
    private static final int[][] erN = {EMPTY_STATE_SET, erK, erL, erM};
    private static final int[] erO = {16842918};
    private ExpandableHListConnector erB;
    private ExpandableListAdapter erC;
    private int erD;
    private int erE;
    private int erF;
    private int erG;
    private int erH;
    private Drawable erI;
    private Drawable erJ;
    private Drawable erP;
    private final Rect erQ;
    private int erR;
    private int erS;
    private int erT;
    private int erU;
    private d erV;
    private e erW;
    private c erX;
    private b erY;
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
        this(context, attributeSet, e.c.hlv_expandableListViewStyle);
    }

    public ExpandableHListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.erQ = new Rect();
        this.mTempRect = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.l.ExpandableHListView, i, 0);
        setGroupIndicator(obtainStyledAttributes.getDrawable(e.l.ExpandableHListView_hlv_groupIndicator));
        setChildIndicator(obtainStyledAttributes.getDrawable(e.l.ExpandableHListView_hlv_childIndicator));
        this.mIndicatorLeft = obtainStyledAttributes.getDimensionPixelSize(e.l.ExpandableHListView_hlv_indicatorPaddingLeft, 0);
        this.erD = obtainStyledAttributes.getDimensionPixelSize(e.l.ExpandableHListView_hlv_indicatorPaddingTop, 0);
        this.erE = obtainStyledAttributes.getInt(e.l.ExpandableHListView_hlv_indicatorGravity, 0);
        this.erF = obtainStyledAttributes.getInt(e.l.ExpandableHListView_hlv_childIndicatorGravity, 0);
        this.erH = obtainStyledAttributes.getDimensionPixelSize(e.l.ExpandableHListView_hlv_childIndicatorPaddingLeft, 0);
        this.erG = obtainStyledAttributes.getDimensionPixelSize(e.l.ExpandableHListView_hlv_childIndicatorPaddingTop, 0);
        this.erP = obtainStyledAttributes.getDrawable(e.l.ExpandableHListView_hlv_childDivider);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        aJY();
        aJZ();
    }

    private void aJY() {
        if (this.erI != null) {
            this.erR = this.erI.getIntrinsicWidth();
            this.erS = this.erI.getIntrinsicHeight();
            return;
        }
        this.erR = 0;
        this.erS = 0;
    }

    private void aJZ() {
        if (this.erJ != null) {
            this.erT = this.erJ.getIntrinsicWidth();
            this.erU = this.erJ.getIntrinsicHeight();
            return;
        }
        this.erT = 0;
        this.erU = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.erJ != null || this.erI != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.mItemCount - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            Rect rect = this.erQ;
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
                            ExpandableHListConnector.b ox = this.erB.ox(i4);
                            if (ox.erv.type != i2) {
                                if (ox.erv.type == 1) {
                                    rect.top = childAt.getTop() + this.erG;
                                    rect.bottom = childAt.getBottom() + this.erG;
                                } else {
                                    rect.top = childAt.getTop() + this.erD;
                                    rect.bottom = childAt.getBottom() + this.erD;
                                }
                                i2 = ox.erv.type;
                            }
                            if (rect.top != rect.bottom) {
                                if (ox.erv.type == 1) {
                                    rect.left = this.erH + left;
                                    rect.right = this.erH + right2;
                                } else {
                                    rect.left = this.mIndicatorLeft + left;
                                    rect.right = this.mIndicatorLeft + right2;
                                }
                                Drawable c2 = c(ox);
                                if (c2 != null) {
                                    if (ox.erv.type == 1) {
                                        Gravity.apply(this.erF, this.erT, this.erU, rect, this.mTempRect);
                                    } else {
                                        Gravity.apply(this.erE, this.erR, this.erS, rect, this.mTempRect);
                                    }
                                    c2.setBounds(this.mTempRect);
                                    c2.draw(canvas);
                                }
                            }
                            ox.recycle();
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
        if (bVar.erv.type == 2) {
            Drawable drawable = this.erI;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            drawable.setState(erN[(bVar.awu() ? (char) 1 : (char) 0) | (bVar.erw == null || bVar.erw.erp == bVar.erw.ero ? (char) 2 : (char) 0)]);
            return drawable;
        }
        Drawable drawable2 = this.erJ;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(bVar.erv.erA == bVar.erw.erp ? erO : EMPTY_STATE_SET);
        }
        return drawable2;
    }

    public void setChildDivider(Drawable drawable) {
        this.erP = drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tieba.horizonalList.widget.HListView
    public void drawDivider(Canvas canvas, Rect rect, int i) {
        int i2 = this.mFirstPosition + i;
        if (i2 >= 0) {
            ExpandableHListConnector.b ox = this.erB.ox(oA(i2));
            if (ox.erv.type == 1 || (ox.awu() && ox.erw.erp != ox.erw.ero)) {
                Drawable drawable = this.erP;
                drawable.setBounds(rect);
                drawable.draw(canvas);
                ox.recycle();
                return;
            }
            ox.recycle();
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
        this.erC = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.erB = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.erB = null;
        }
        super.setAdapter((ListAdapter) this.erB);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.erC;
    }

    private boolean isHeaderOrFooterPosition(int i) {
        return i < getHeaderViewsCount() || i >= this.mItemCount - getFooterViewsCount();
    }

    private int oA(int i) {
        return i - getHeaderViewsCount();
    }

    private int oB(int i) {
        return getHeaderViewsCount() + i;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.AdapterView
    public boolean performItemClick(View view, int i, long j) {
        if (isHeaderOrFooterPosition(i)) {
            return super.performItemClick(view, i, j);
        }
        return b(view, oA(i), j);
    }

    boolean b(View view, int i, long j) {
        boolean z;
        ExpandableHListConnector.b ox = this.erB.ox(i);
        long b2 = b(ox.erv);
        if (ox.erv.type == 2) {
            if (this.erX != null && this.erX.a(this, view, ox.erv.ery, b2)) {
                ox.recycle();
                return true;
            }
            if (ox.awu()) {
                this.erB.a(ox);
                playSoundEffect(0);
                if (this.erV != null) {
                    this.erV.onGroupCollapse(ox.erv.ery);
                }
            } else {
                this.erB.b(ox);
                playSoundEffect(0);
                if (this.erW != null) {
                    this.erW.onGroupExpand(ox.erv.ery);
                }
                int i2 = ox.erv.ery;
                int headerViewsCount = ox.erv.erA + getHeaderViewsCount();
                smoothScrollToPosition(this.erC.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.erY != null) {
            playSoundEffect(0);
            return this.erY.a(this, view, ox.erv.ery, ox.erv.erz, b2);
        } else {
            z = false;
        }
        ox.recycle();
        return z;
    }

    public void setOnGroupCollapseListener(d dVar) {
        this.erV = dVar;
    }

    public void setOnGroupExpandListener(e eVar) {
        this.erW = eVar;
    }

    public void setOnGroupClickListener(c cVar) {
        this.erX = cVar;
    }

    public void setOnChildClickListener(b bVar) {
        this.erY = bVar;
    }

    public long getExpandableListPosition(int i) {
        if (isHeaderOrFooterPosition(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b ox = this.erB.ox(oA(i));
        long aJW = ox.erv.aJW();
        ox.recycle();
        return aJW;
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
            return this.erC.getGroupId(packedPositionGroup);
        }
        return this.erC.getChildId(packedPositionGroup, getPackedPositionChild(selectedPosition));
    }

    public void setSelectedGroup(int i) {
        com.baidu.tieba.horizonalList.widget.a oz = com.baidu.tieba.horizonalList.widget.a.oz(i);
        ExpandableHListConnector.b a2 = this.erB.a(oz);
        oz.recycle();
        super.setSelection(oB(a2.erv.erA));
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
        ExpandableHListConnector.b ox = this.erB.ox(oA(i));
        com.baidu.tieba.horizonalList.widget.a aVar = ox.erv;
        long b2 = b(aVar);
        long aJW = aVar.aJW();
        ox.recycle();
        return new a(view, aJW, b2);
    }

    private long b(com.baidu.tieba.horizonalList.widget.a aVar) {
        return aVar.type == 1 ? this.erC.getChildId(aVar.ery, aVar.erz) : this.erC.getGroupId(aVar.ery);
    }

    public void setChildIndicator(Drawable drawable) {
        this.erJ = drawable;
        aJZ();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.erI = drawable;
        aJY();
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
            /* renamed from: t */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: oC */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        ArrayList<ExpandableHListConnector.GroupMetadata> erZ;

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.erZ = arrayList;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.erZ = new ArrayList<>();
            parcel.readList(this.erZ, ExpandableHListConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.erZ);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.erB != null ? this.erB.aJU() : null);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.erB != null && savedState.erZ != null) {
            this.erB.X(savedState.erZ);
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
