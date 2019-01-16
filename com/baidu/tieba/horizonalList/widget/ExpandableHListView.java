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
    private static final int[] eCi = {16842920};
    private static final int[] eCj = {16842921};
    private static final int[] eCk = {16842920, 16842921};
    private static final int[][] eCl = {EMPTY_STATE_SET, eCi, eCj, eCk};
    private static final int[] eCm = {16842918};
    private ExpandableHListConnector eBZ;
    private ExpandableListAdapter eCa;
    private int eCb;
    private int eCc;
    private int eCd;
    private int eCe;
    private int eCf;
    private Drawable eCg;
    private Drawable eCh;
    private Drawable eCn;
    private final Rect eCo;
    private int eCp;
    private int eCq;
    private int eCr;
    private int eCs;
    private d eCt;
    private e eCu;
    private c eCv;
    private b eCw;
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
        this.eCo = new Rect();
        this.mTempRect = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.l.ExpandableHListView, i, 0);
        setGroupIndicator(obtainStyledAttributes.getDrawable(e.l.ExpandableHListView_hlv_groupIndicator));
        setChildIndicator(obtainStyledAttributes.getDrawable(e.l.ExpandableHListView_hlv_childIndicator));
        this.mIndicatorLeft = obtainStyledAttributes.getDimensionPixelSize(e.l.ExpandableHListView_hlv_indicatorPaddingLeft, 0);
        this.eCb = obtainStyledAttributes.getDimensionPixelSize(e.l.ExpandableHListView_hlv_indicatorPaddingTop, 0);
        this.eCc = obtainStyledAttributes.getInt(e.l.ExpandableHListView_hlv_indicatorGravity, 0);
        this.eCd = obtainStyledAttributes.getInt(e.l.ExpandableHListView_hlv_childIndicatorGravity, 0);
        this.eCf = obtainStyledAttributes.getDimensionPixelSize(e.l.ExpandableHListView_hlv_childIndicatorPaddingLeft, 0);
        this.eCe = obtainStyledAttributes.getDimensionPixelSize(e.l.ExpandableHListView_hlv_childIndicatorPaddingTop, 0);
        this.eCn = obtainStyledAttributes.getDrawable(e.l.ExpandableHListView_hlv_childDivider);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        aNd();
        aNe();
    }

    private void aNd() {
        if (this.eCg != null) {
            this.eCp = this.eCg.getIntrinsicWidth();
            this.eCq = this.eCg.getIntrinsicHeight();
            return;
        }
        this.eCp = 0;
        this.eCq = 0;
    }

    private void aNe() {
        if (this.eCh != null) {
            this.eCr = this.eCh.getIntrinsicWidth();
            this.eCs = this.eCh.getIntrinsicHeight();
            return;
        }
        this.eCr = 0;
        this.eCs = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.eCh != null || this.eCg != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.mItemCount - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            Rect rect = this.eCo;
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
                            ExpandableHListConnector.b pf = this.eBZ.pf(i4);
                            if (pf.eBT.type != i2) {
                                if (pf.eBT.type == 1) {
                                    rect.top = childAt.getTop() + this.eCe;
                                    rect.bottom = childAt.getBottom() + this.eCe;
                                } else {
                                    rect.top = childAt.getTop() + this.eCb;
                                    rect.bottom = childAt.getBottom() + this.eCb;
                                }
                                i2 = pf.eBT.type;
                            }
                            if (rect.top != rect.bottom) {
                                if (pf.eBT.type == 1) {
                                    rect.left = this.eCf + left;
                                    rect.right = this.eCf + right2;
                                } else {
                                    rect.left = this.mIndicatorLeft + left;
                                    rect.right = this.mIndicatorLeft + right2;
                                }
                                Drawable c2 = c(pf);
                                if (c2 != null) {
                                    if (pf.eBT.type == 1) {
                                        Gravity.apply(this.eCd, this.eCr, this.eCs, rect, this.mTempRect);
                                    } else {
                                        Gravity.apply(this.eCc, this.eCp, this.eCq, rect, this.mTempRect);
                                    }
                                    c2.setBounds(this.mTempRect);
                                    c2.draw(canvas);
                                }
                            }
                            pf.recycle();
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
        if (bVar.eBT.type == 2) {
            Drawable drawable = this.eCg;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            drawable.setState(eCl[(bVar.azr() ? (char) 1 : (char) 0) | (bVar.eBU == null || bVar.eBU.eBO == bVar.eBU.eBN ? (char) 2 : (char) 0)]);
            return drawable;
        }
        Drawable drawable2 = this.eCh;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(bVar.eBT.eBY == bVar.eBU.eBO ? eCm : EMPTY_STATE_SET);
        }
        return drawable2;
    }

    public void setChildDivider(Drawable drawable) {
        this.eCn = drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tieba.horizonalList.widget.HListView
    public void drawDivider(Canvas canvas, Rect rect, int i) {
        int i2 = this.mFirstPosition + i;
        if (i2 >= 0) {
            ExpandableHListConnector.b pf = this.eBZ.pf(pi(i2));
            if (pf.eBT.type == 1 || (pf.azr() && pf.eBU.eBO != pf.eBU.eBN)) {
                Drawable drawable = this.eCn;
                drawable.setBounds(rect);
                drawable.draw(canvas);
                pf.recycle();
                return;
            }
            pf.recycle();
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
        this.eCa = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.eBZ = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.eBZ = null;
        }
        super.setAdapter((ListAdapter) this.eBZ);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.eCa;
    }

    private boolean isHeaderOrFooterPosition(int i) {
        return i < getHeaderViewsCount() || i >= this.mItemCount - getFooterViewsCount();
    }

    private int pi(int i) {
        return i - getHeaderViewsCount();
    }

    private int pj(int i) {
        return getHeaderViewsCount() + i;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.AdapterView
    public boolean performItemClick(View view, int i, long j) {
        if (isHeaderOrFooterPosition(i)) {
            return super.performItemClick(view, i, j);
        }
        return b(view, pi(i), j);
    }

    boolean b(View view, int i, long j) {
        boolean z;
        ExpandableHListConnector.b pf = this.eBZ.pf(i);
        long b2 = b(pf.eBT);
        if (pf.eBT.type == 2) {
            if (this.eCv != null && this.eCv.a(this, view, pf.eBT.eBW, b2)) {
                pf.recycle();
                return true;
            }
            if (pf.azr()) {
                this.eBZ.a(pf);
                playSoundEffect(0);
                if (this.eCt != null) {
                    this.eCt.onGroupCollapse(pf.eBT.eBW);
                }
            } else {
                this.eBZ.b(pf);
                playSoundEffect(0);
                if (this.eCu != null) {
                    this.eCu.onGroupExpand(pf.eBT.eBW);
                }
                int i2 = pf.eBT.eBW;
                int headerViewsCount = pf.eBT.eBY + getHeaderViewsCount();
                smoothScrollToPosition(this.eCa.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.eCw != null) {
            playSoundEffect(0);
            return this.eCw.a(this, view, pf.eBT.eBW, pf.eBT.eBX, b2);
        } else {
            z = false;
        }
        pf.recycle();
        return z;
    }

    public void setOnGroupCollapseListener(d dVar) {
        this.eCt = dVar;
    }

    public void setOnGroupExpandListener(e eVar) {
        this.eCu = eVar;
    }

    public void setOnGroupClickListener(c cVar) {
        this.eCv = cVar;
    }

    public void setOnChildClickListener(b bVar) {
        this.eCw = bVar;
    }

    public long getExpandableListPosition(int i) {
        if (isHeaderOrFooterPosition(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b pf = this.eBZ.pf(pi(i));
        long aNb = pf.eBT.aNb();
        pf.recycle();
        return aNb;
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
            return this.eCa.getGroupId(packedPositionGroup);
        }
        return this.eCa.getChildId(packedPositionGroup, getPackedPositionChild(selectedPosition));
    }

    public void setSelectedGroup(int i) {
        com.baidu.tieba.horizonalList.widget.a ph = com.baidu.tieba.horizonalList.widget.a.ph(i);
        ExpandableHListConnector.b a2 = this.eBZ.a(ph);
        ph.recycle();
        super.setSelection(pj(a2.eBT.eBY));
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
        ExpandableHListConnector.b pf = this.eBZ.pf(pi(i));
        com.baidu.tieba.horizonalList.widget.a aVar = pf.eBT;
        long b2 = b(aVar);
        long aNb = aVar.aNb();
        pf.recycle();
        return new a(view, aNb, b2);
    }

    private long b(com.baidu.tieba.horizonalList.widget.a aVar) {
        return aVar.type == 1 ? this.eCa.getChildId(aVar.eBW, aVar.eBX) : this.eCa.getGroupId(aVar.eBW);
    }

    public void setChildIndicator(Drawable drawable) {
        this.eCh = drawable;
        aNe();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.eCg = drawable;
        aNd();
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
            /* renamed from: pk */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        ArrayList<ExpandableHListConnector.GroupMetadata> eCx;

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.eCx = arrayList;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.eCx = new ArrayList<>();
            parcel.readList(this.eCx, ExpandableHListConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.eCx);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.eBZ != null ? this.eBZ.aMZ() : null);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.eBZ != null && savedState.eCx != null) {
            this.eBZ.X(savedState.eCx);
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
