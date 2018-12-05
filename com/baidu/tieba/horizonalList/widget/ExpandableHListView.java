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
    private static final int[] eyF = {16842920};
    private static final int[] eyG = {16842921};
    private static final int[] eyH = {16842920, 16842921};
    private static final int[][] eyI = {EMPTY_STATE_SET, eyF, eyG, eyH};
    private static final int[] eyJ = {16842918};
    private int eyA;
    private int eyB;
    private int eyC;
    private Drawable eyD;
    private Drawable eyE;
    private Drawable eyK;
    private final Rect eyL;
    private int eyM;
    private int eyN;
    private int eyO;
    private int eyP;
    private d eyQ;
    private e eyR;
    private c eyS;
    private b eyT;
    private ExpandableHListConnector eyw;
    private ExpandableListAdapter eyx;
    private int eyy;
    private int eyz;
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
        this.eyL = new Rect();
        this.mTempRect = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.l.ExpandableHListView, i, 0);
        setGroupIndicator(obtainStyledAttributes.getDrawable(e.l.ExpandableHListView_hlv_groupIndicator));
        setChildIndicator(obtainStyledAttributes.getDrawable(e.l.ExpandableHListView_hlv_childIndicator));
        this.mIndicatorLeft = obtainStyledAttributes.getDimensionPixelSize(e.l.ExpandableHListView_hlv_indicatorPaddingLeft, 0);
        this.eyy = obtainStyledAttributes.getDimensionPixelSize(e.l.ExpandableHListView_hlv_indicatorPaddingTop, 0);
        this.eyz = obtainStyledAttributes.getInt(e.l.ExpandableHListView_hlv_indicatorGravity, 0);
        this.eyA = obtainStyledAttributes.getInt(e.l.ExpandableHListView_hlv_childIndicatorGravity, 0);
        this.eyC = obtainStyledAttributes.getDimensionPixelSize(e.l.ExpandableHListView_hlv_childIndicatorPaddingLeft, 0);
        this.eyB = obtainStyledAttributes.getDimensionPixelSize(e.l.ExpandableHListView_hlv_childIndicatorPaddingTop, 0);
        this.eyK = obtainStyledAttributes.getDrawable(e.l.ExpandableHListView_hlv_childDivider);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        aLQ();
        aLR();
    }

    private void aLQ() {
        if (this.eyD != null) {
            this.eyM = this.eyD.getIntrinsicWidth();
            this.eyN = this.eyD.getIntrinsicHeight();
            return;
        }
        this.eyM = 0;
        this.eyN = 0;
    }

    private void aLR() {
        if (this.eyE != null) {
            this.eyO = this.eyE.getIntrinsicWidth();
            this.eyP = this.eyE.getIntrinsicHeight();
            return;
        }
        this.eyO = 0;
        this.eyP = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.eyE != null || this.eyD != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.mItemCount - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            Rect rect = this.eyL;
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
                            ExpandableHListConnector.b oR = this.eyw.oR(i4);
                            if (oR.eyq.type != i2) {
                                if (oR.eyq.type == 1) {
                                    rect.top = childAt.getTop() + this.eyB;
                                    rect.bottom = childAt.getBottom() + this.eyB;
                                } else {
                                    rect.top = childAt.getTop() + this.eyy;
                                    rect.bottom = childAt.getBottom() + this.eyy;
                                }
                                i2 = oR.eyq.type;
                            }
                            if (rect.top != rect.bottom) {
                                if (oR.eyq.type == 1) {
                                    rect.left = this.eyC + left;
                                    rect.right = this.eyC + right2;
                                } else {
                                    rect.left = this.mIndicatorLeft + left;
                                    rect.right = this.mIndicatorLeft + right2;
                                }
                                Drawable c2 = c(oR);
                                if (c2 != null) {
                                    if (oR.eyq.type == 1) {
                                        Gravity.apply(this.eyA, this.eyO, this.eyP, rect, this.mTempRect);
                                    } else {
                                        Gravity.apply(this.eyz, this.eyM, this.eyN, rect, this.mTempRect);
                                    }
                                    c2.setBounds(this.mTempRect);
                                    c2.draw(canvas);
                                }
                            }
                            oR.recycle();
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
        if (bVar.eyq.type == 2) {
            Drawable drawable = this.eyD;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            drawable.setState(eyI[(bVar.ayf() ? (char) 1 : (char) 0) | (bVar.eyr == null || bVar.eyr.eyk == bVar.eyr.eyj ? (char) 2 : (char) 0)]);
            return drawable;
        }
        Drawable drawable2 = this.eyE;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(bVar.eyq.eyv == bVar.eyr.eyk ? eyJ : EMPTY_STATE_SET);
        }
        return drawable2;
    }

    public void setChildDivider(Drawable drawable) {
        this.eyK = drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tieba.horizonalList.widget.HListView
    public void drawDivider(Canvas canvas, Rect rect, int i) {
        int i2 = this.mFirstPosition + i;
        if (i2 >= 0) {
            ExpandableHListConnector.b oR = this.eyw.oR(oU(i2));
            if (oR.eyq.type == 1 || (oR.ayf() && oR.eyr.eyk != oR.eyr.eyj)) {
                Drawable drawable = this.eyK;
                drawable.setBounds(rect);
                drawable.draw(canvas);
                oR.recycle();
                return;
            }
            oR.recycle();
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
        this.eyx = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.eyw = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.eyw = null;
        }
        super.setAdapter((ListAdapter) this.eyw);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.eyx;
    }

    private boolean isHeaderOrFooterPosition(int i) {
        return i < getHeaderViewsCount() || i >= this.mItemCount - getFooterViewsCount();
    }

    private int oU(int i) {
        return i - getHeaderViewsCount();
    }

    private int oV(int i) {
        return getHeaderViewsCount() + i;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.AdapterView
    public boolean performItemClick(View view, int i, long j) {
        if (isHeaderOrFooterPosition(i)) {
            return super.performItemClick(view, i, j);
        }
        return b(view, oU(i), j);
    }

    boolean b(View view, int i, long j) {
        boolean z;
        ExpandableHListConnector.b oR = this.eyw.oR(i);
        long b2 = b(oR.eyq);
        if (oR.eyq.type == 2) {
            if (this.eyS != null && this.eyS.a(this, view, oR.eyq.eyt, b2)) {
                oR.recycle();
                return true;
            }
            if (oR.ayf()) {
                this.eyw.a(oR);
                playSoundEffect(0);
                if (this.eyQ != null) {
                    this.eyQ.onGroupCollapse(oR.eyq.eyt);
                }
            } else {
                this.eyw.b(oR);
                playSoundEffect(0);
                if (this.eyR != null) {
                    this.eyR.onGroupExpand(oR.eyq.eyt);
                }
                int i2 = oR.eyq.eyt;
                int headerViewsCount = oR.eyq.eyv + getHeaderViewsCount();
                smoothScrollToPosition(this.eyx.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.eyT != null) {
            playSoundEffect(0);
            return this.eyT.a(this, view, oR.eyq.eyt, oR.eyq.eyu, b2);
        } else {
            z = false;
        }
        oR.recycle();
        return z;
    }

    public void setOnGroupCollapseListener(d dVar) {
        this.eyQ = dVar;
    }

    public void setOnGroupExpandListener(e eVar) {
        this.eyR = eVar;
    }

    public void setOnGroupClickListener(c cVar) {
        this.eyS = cVar;
    }

    public void setOnChildClickListener(b bVar) {
        this.eyT = bVar;
    }

    public long getExpandableListPosition(int i) {
        if (isHeaderOrFooterPosition(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b oR = this.eyw.oR(oU(i));
        long aLO = oR.eyq.aLO();
        oR.recycle();
        return aLO;
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
            return this.eyx.getGroupId(packedPositionGroup);
        }
        return this.eyx.getChildId(packedPositionGroup, getPackedPositionChild(selectedPosition));
    }

    public void setSelectedGroup(int i) {
        com.baidu.tieba.horizonalList.widget.a oT = com.baidu.tieba.horizonalList.widget.a.oT(i);
        ExpandableHListConnector.b a2 = this.eyw.a(oT);
        oT.recycle();
        super.setSelection(oV(a2.eyq.eyv));
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
        ExpandableHListConnector.b oR = this.eyw.oR(oU(i));
        com.baidu.tieba.horizonalList.widget.a aVar = oR.eyq;
        long b2 = b(aVar);
        long aLO = aVar.aLO();
        oR.recycle();
        return new a(view, aLO, b2);
    }

    private long b(com.baidu.tieba.horizonalList.widget.a aVar) {
        return aVar.type == 1 ? this.eyx.getChildId(aVar.eyt, aVar.eyu) : this.eyx.getGroupId(aVar.eyt);
    }

    public void setChildIndicator(Drawable drawable) {
        this.eyE = drawable;
        aLR();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.eyD = drawable;
        aLQ();
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
            /* renamed from: oW */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        ArrayList<ExpandableHListConnector.GroupMetadata> eyU;

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.eyU = arrayList;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.eyU = new ArrayList<>();
            parcel.readList(this.eyU, ExpandableHListConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.eyU);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.eyw != null ? this.eyw.aLM() : null);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.eyw != null && savedState.eyU != null) {
            this.eyw.X(savedState.eyU);
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
