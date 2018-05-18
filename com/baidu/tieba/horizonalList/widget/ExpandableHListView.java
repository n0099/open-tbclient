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
    private static final int[] dIj = {16842920};
    private static final int[] dIk = {16842921};
    private static final int[] dIl = {16842920, 16842921};
    private static final int[][] dIm = {EMPTY_STATE_SET, dIj, dIk, dIl};
    private static final int[] dIn = {16842918};
    private ExpandableHListConnector dIa;
    private ExpandableListAdapter dIb;
    private int dIc;
    private int dId;
    private int dIe;
    private int dIf;
    private int dIg;
    private Drawable dIh;
    private Drawable dIi;
    private Drawable dIo;
    private final Rect dIp;
    private int dIq;
    private int dIr;
    private int dIs;
    private int dIt;
    private d dIu;
    private e dIv;
    private c dIw;
    private b dIx;
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
        this.dIp = new Rect();
        this.mTempRect = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.m.ExpandableHListView, i, 0);
        setGroupIndicator(obtainStyledAttributes.getDrawable(d.m.ExpandableHListView_hlv_groupIndicator));
        setChildIndicator(obtainStyledAttributes.getDrawable(d.m.ExpandableHListView_hlv_childIndicator));
        this.mIndicatorLeft = obtainStyledAttributes.getDimensionPixelSize(d.m.ExpandableHListView_hlv_indicatorPaddingLeft, 0);
        this.dIc = obtainStyledAttributes.getDimensionPixelSize(d.m.ExpandableHListView_hlv_indicatorPaddingTop, 0);
        this.dId = obtainStyledAttributes.getInt(d.m.ExpandableHListView_hlv_indicatorGravity, 0);
        this.dIe = obtainStyledAttributes.getInt(d.m.ExpandableHListView_hlv_childIndicatorGravity, 0);
        this.dIg = obtainStyledAttributes.getDimensionPixelSize(d.m.ExpandableHListView_hlv_childIndicatorPaddingLeft, 0);
        this.dIf = obtainStyledAttributes.getDimensionPixelSize(d.m.ExpandableHListView_hlv_childIndicatorPaddingTop, 0);
        this.dIo = obtainStyledAttributes.getDrawable(d.m.ExpandableHListView_hlv_childDivider);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        ayr();
        ays();
    }

    private void ayr() {
        if (this.dIh != null) {
            this.dIq = this.dIh.getIntrinsicWidth();
            this.dIr = this.dIh.getIntrinsicHeight();
            return;
        }
        this.dIq = 0;
        this.dIr = 0;
    }

    private void ays() {
        if (this.dIi != null) {
            this.dIs = this.dIi.getIntrinsicWidth();
            this.dIt = this.dIi.getIntrinsicHeight();
            return;
        }
        this.dIs = 0;
        this.dIt = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.dIi != null || this.dIh != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.mItemCount - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            Rect rect = this.dIp;
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
                            ExpandableHListConnector.b mw = this.dIa.mw(i4);
                            if (mw.dHU.type != i2) {
                                if (mw.dHU.type == 1) {
                                    rect.top = childAt.getTop() + this.dIf;
                                    rect.bottom = childAt.getBottom() + this.dIf;
                                } else {
                                    rect.top = childAt.getTop() + this.dIc;
                                    rect.bottom = childAt.getBottom() + this.dIc;
                                }
                                i2 = mw.dHU.type;
                            }
                            if (rect.top != rect.bottom) {
                                if (mw.dHU.type == 1) {
                                    rect.left = this.dIg + left;
                                    rect.right = this.dIg + right2;
                                } else {
                                    rect.left = this.mIndicatorLeft + left;
                                    rect.right = this.mIndicatorLeft + right2;
                                }
                                Drawable c2 = c(mw);
                                if (c2 != null) {
                                    if (mw.dHU.type == 1) {
                                        Gravity.apply(this.dIe, this.dIs, this.dIt, rect, this.mTempRect);
                                    } else {
                                        Gravity.apply(this.dId, this.dIq, this.dIr, rect, this.mTempRect);
                                    }
                                    c2.setBounds(this.mTempRect);
                                    c2.draw(canvas);
                                }
                            }
                            mw.recycle();
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
        if (bVar.dHU.type == 2) {
            Drawable drawable = this.dIh;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            drawable.setState(dIm[(bVar.anL() ? (char) 1 : (char) 0) | (bVar.dHV == null || bVar.dHV.dHP == bVar.dHV.dHO ? (char) 2 : (char) 0)]);
            return drawable;
        }
        Drawable drawable2 = this.dIi;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(bVar.dHU.dHZ == bVar.dHV.dHP ? dIn : EMPTY_STATE_SET);
        }
        return drawable2;
    }

    public void setChildDivider(Drawable drawable) {
        this.dIo = drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tieba.horizonalList.widget.HListView
    public void drawDivider(Canvas canvas, Rect rect, int i) {
        int i2 = this.mFirstPosition + i;
        if (i2 >= 0) {
            ExpandableHListConnector.b mw = this.dIa.mw(mz(i2));
            if (mw.dHU.type == 1 || (mw.anL() && mw.dHV.dHP != mw.dHV.dHO)) {
                Drawable drawable = this.dIo;
                drawable.setBounds(rect);
                drawable.draw(canvas);
                mw.recycle();
                return;
            }
            mw.recycle();
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
        this.dIb = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.dIa = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.dIa = null;
        }
        super.setAdapter((ListAdapter) this.dIa);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.dIb;
    }

    private boolean isHeaderOrFooterPosition(int i) {
        return i < getHeaderViewsCount() || i >= this.mItemCount - getFooterViewsCount();
    }

    private int mz(int i) {
        return i - getHeaderViewsCount();
    }

    private int mA(int i) {
        return getHeaderViewsCount() + i;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.AdapterView
    public boolean performItemClick(View view2, int i, long j) {
        if (isHeaderOrFooterPosition(i)) {
            return super.performItemClick(view2, i, j);
        }
        return e(view2, mz(i), j);
    }

    boolean e(View view2, int i, long j) {
        boolean z;
        ExpandableHListConnector.b mw = this.dIa.mw(i);
        long b2 = b(mw.dHU);
        if (mw.dHU.type == 2) {
            if (this.dIw != null && this.dIw.a(this, view2, mw.dHU.dHX, b2)) {
                mw.recycle();
                return true;
            }
            if (mw.anL()) {
                this.dIa.a(mw);
                playSoundEffect(0);
                if (this.dIu != null) {
                    this.dIu.onGroupCollapse(mw.dHU.dHX);
                }
            } else {
                this.dIa.b(mw);
                playSoundEffect(0);
                if (this.dIv != null) {
                    this.dIv.onGroupExpand(mw.dHU.dHX);
                }
                int i2 = mw.dHU.dHX;
                int headerViewsCount = mw.dHU.dHZ + getHeaderViewsCount();
                smoothScrollToPosition(this.dIb.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.dIx != null) {
            playSoundEffect(0);
            return this.dIx.a(this, view2, mw.dHU.dHX, mw.dHU.dHY, b2);
        } else {
            z = false;
        }
        mw.recycle();
        return z;
    }

    public void setOnGroupCollapseListener(d dVar) {
        this.dIu = dVar;
    }

    public void setOnGroupExpandListener(e eVar) {
        this.dIv = eVar;
    }

    public void setOnGroupClickListener(c cVar) {
        this.dIw = cVar;
    }

    public void setOnChildClickListener(b bVar) {
        this.dIx = bVar;
    }

    public long getExpandableListPosition(int i) {
        if (isHeaderOrFooterPosition(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b mw = this.dIa.mw(mz(i));
        long ayp = mw.dHU.ayp();
        mw.recycle();
        return ayp;
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
            return this.dIb.getGroupId(packedPositionGroup);
        }
        return this.dIb.getChildId(packedPositionGroup, getPackedPositionChild(selectedPosition));
    }

    public void setSelectedGroup(int i) {
        com.baidu.tieba.horizonalList.widget.a my = com.baidu.tieba.horizonalList.widget.a.my(i);
        ExpandableHListConnector.b a2 = this.dIa.a(my);
        my.recycle();
        super.setSelection(mA(a2.dHU.dHZ));
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
        ExpandableHListConnector.b mw = this.dIa.mw(mz(i));
        com.baidu.tieba.horizonalList.widget.a aVar = mw.dHU;
        long b2 = b(aVar);
        long ayp = aVar.ayp();
        mw.recycle();
        return new a(view2, ayp, b2);
    }

    private long b(com.baidu.tieba.horizonalList.widget.a aVar) {
        return aVar.type == 1 ? this.dIb.getChildId(aVar.dHX, aVar.dHY) : this.dIb.getGroupId(aVar.dHX);
    }

    public void setChildIndicator(Drawable drawable) {
        this.dIi = drawable;
        ays();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.dIh = drawable;
        ayr();
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
            /* renamed from: r */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: mB */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        ArrayList<ExpandableHListConnector.GroupMetadata> dIy;

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.dIy = arrayList;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.dIy = new ArrayList<>();
            parcel.readList(this.dIy, ExpandableHListConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.dIy);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.dIa != null ? this.dIa.ayn() : null);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.dIa != null && savedState.dIy != null) {
            this.dIa.S(savedState.dIy);
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
