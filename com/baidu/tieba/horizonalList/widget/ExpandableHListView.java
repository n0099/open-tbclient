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
    private static final int[] eCj = {16842920};
    private static final int[] eCk = {16842921};
    private static final int[] eCl = {16842920, 16842921};
    private static final int[][] eCm = {EMPTY_STATE_SET, eCj, eCk, eCl};
    private static final int[] eCn = {16842918};
    private ExpandableHListConnector eCa;
    private ExpandableListAdapter eCb;
    private int eCc;
    private int eCd;
    private int eCe;
    private int eCf;
    private int eCg;
    private Drawable eCh;
    private Drawable eCi;
    private Drawable eCo;
    private final Rect eCp;
    private int eCq;
    private int eCr;
    private int eCs;
    private int eCt;
    private d eCu;
    private e eCv;
    private c eCw;
    private b eCx;
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
        this.eCp = new Rect();
        this.mTempRect = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.l.ExpandableHListView, i, 0);
        setGroupIndicator(obtainStyledAttributes.getDrawable(e.l.ExpandableHListView_hlv_groupIndicator));
        setChildIndicator(obtainStyledAttributes.getDrawable(e.l.ExpandableHListView_hlv_childIndicator));
        this.mIndicatorLeft = obtainStyledAttributes.getDimensionPixelSize(e.l.ExpandableHListView_hlv_indicatorPaddingLeft, 0);
        this.eCc = obtainStyledAttributes.getDimensionPixelSize(e.l.ExpandableHListView_hlv_indicatorPaddingTop, 0);
        this.eCd = obtainStyledAttributes.getInt(e.l.ExpandableHListView_hlv_indicatorGravity, 0);
        this.eCe = obtainStyledAttributes.getInt(e.l.ExpandableHListView_hlv_childIndicatorGravity, 0);
        this.eCg = obtainStyledAttributes.getDimensionPixelSize(e.l.ExpandableHListView_hlv_childIndicatorPaddingLeft, 0);
        this.eCf = obtainStyledAttributes.getDimensionPixelSize(e.l.ExpandableHListView_hlv_childIndicatorPaddingTop, 0);
        this.eCo = obtainStyledAttributes.getDrawable(e.l.ExpandableHListView_hlv_childDivider);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        aNd();
        aNe();
    }

    private void aNd() {
        if (this.eCh != null) {
            this.eCq = this.eCh.getIntrinsicWidth();
            this.eCr = this.eCh.getIntrinsicHeight();
            return;
        }
        this.eCq = 0;
        this.eCr = 0;
    }

    private void aNe() {
        if (this.eCi != null) {
            this.eCs = this.eCi.getIntrinsicWidth();
            this.eCt = this.eCi.getIntrinsicHeight();
            return;
        }
        this.eCs = 0;
        this.eCt = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.eCi != null || this.eCh != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.mItemCount - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            Rect rect = this.eCp;
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
                            ExpandableHListConnector.b pf = this.eCa.pf(i4);
                            if (pf.eBU.type != i2) {
                                if (pf.eBU.type == 1) {
                                    rect.top = childAt.getTop() + this.eCf;
                                    rect.bottom = childAt.getBottom() + this.eCf;
                                } else {
                                    rect.top = childAt.getTop() + this.eCc;
                                    rect.bottom = childAt.getBottom() + this.eCc;
                                }
                                i2 = pf.eBU.type;
                            }
                            if (rect.top != rect.bottom) {
                                if (pf.eBU.type == 1) {
                                    rect.left = this.eCg + left;
                                    rect.right = this.eCg + right2;
                                } else {
                                    rect.left = this.mIndicatorLeft + left;
                                    rect.right = this.mIndicatorLeft + right2;
                                }
                                Drawable c2 = c(pf);
                                if (c2 != null) {
                                    if (pf.eBU.type == 1) {
                                        Gravity.apply(this.eCe, this.eCs, this.eCt, rect, this.mTempRect);
                                    } else {
                                        Gravity.apply(this.eCd, this.eCq, this.eCr, rect, this.mTempRect);
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
        if (bVar.eBU.type == 2) {
            Drawable drawable = this.eCh;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            drawable.setState(eCm[(bVar.azr() ? (char) 1 : (char) 0) | (bVar.eBV == null || bVar.eBV.eBP == bVar.eBV.eBO ? (char) 2 : (char) 0)]);
            return drawable;
        }
        Drawable drawable2 = this.eCi;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(bVar.eBU.eBZ == bVar.eBV.eBP ? eCn : EMPTY_STATE_SET);
        }
        return drawable2;
    }

    public void setChildDivider(Drawable drawable) {
        this.eCo = drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tieba.horizonalList.widget.HListView
    public void drawDivider(Canvas canvas, Rect rect, int i) {
        int i2 = this.mFirstPosition + i;
        if (i2 >= 0) {
            ExpandableHListConnector.b pf = this.eCa.pf(pi(i2));
            if (pf.eBU.type == 1 || (pf.azr() && pf.eBV.eBP != pf.eBV.eBO)) {
                Drawable drawable = this.eCo;
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
        this.eCb = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.eCa = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.eCa = null;
        }
        super.setAdapter((ListAdapter) this.eCa);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.eCb;
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
        ExpandableHListConnector.b pf = this.eCa.pf(i);
        long b2 = b(pf.eBU);
        if (pf.eBU.type == 2) {
            if (this.eCw != null && this.eCw.a(this, view, pf.eBU.eBX, b2)) {
                pf.recycle();
                return true;
            }
            if (pf.azr()) {
                this.eCa.a(pf);
                playSoundEffect(0);
                if (this.eCu != null) {
                    this.eCu.onGroupCollapse(pf.eBU.eBX);
                }
            } else {
                this.eCa.b(pf);
                playSoundEffect(0);
                if (this.eCv != null) {
                    this.eCv.onGroupExpand(pf.eBU.eBX);
                }
                int i2 = pf.eBU.eBX;
                int headerViewsCount = pf.eBU.eBZ + getHeaderViewsCount();
                smoothScrollToPosition(this.eCb.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.eCx != null) {
            playSoundEffect(0);
            return this.eCx.a(this, view, pf.eBU.eBX, pf.eBU.eBY, b2);
        } else {
            z = false;
        }
        pf.recycle();
        return z;
    }

    public void setOnGroupCollapseListener(d dVar) {
        this.eCu = dVar;
    }

    public void setOnGroupExpandListener(e eVar) {
        this.eCv = eVar;
    }

    public void setOnGroupClickListener(c cVar) {
        this.eCw = cVar;
    }

    public void setOnChildClickListener(b bVar) {
        this.eCx = bVar;
    }

    public long getExpandableListPosition(int i) {
        if (isHeaderOrFooterPosition(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b pf = this.eCa.pf(pi(i));
        long aNb = pf.eBU.aNb();
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
            return this.eCb.getGroupId(packedPositionGroup);
        }
        return this.eCb.getChildId(packedPositionGroup, getPackedPositionChild(selectedPosition));
    }

    public void setSelectedGroup(int i) {
        com.baidu.tieba.horizonalList.widget.a ph = com.baidu.tieba.horizonalList.widget.a.ph(i);
        ExpandableHListConnector.b a2 = this.eCa.a(ph);
        ph.recycle();
        super.setSelection(pj(a2.eBU.eBZ));
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
        ExpandableHListConnector.b pf = this.eCa.pf(pi(i));
        com.baidu.tieba.horizonalList.widget.a aVar = pf.eBU;
        long b2 = b(aVar);
        long aNb = aVar.aNb();
        pf.recycle();
        return new a(view, aNb, b2);
    }

    private long b(com.baidu.tieba.horizonalList.widget.a aVar) {
        return aVar.type == 1 ? this.eCb.getChildId(aVar.eBX, aVar.eBY) : this.eCb.getGroupId(aVar.eBX);
    }

    public void setChildIndicator(Drawable drawable) {
        this.eCi = drawable;
        aNe();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.eCh = drawable;
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
        ArrayList<ExpandableHListConnector.GroupMetadata> eCy;

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.eCy = arrayList;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.eCy = new ArrayList<>();
            parcel.readList(this.eCy, ExpandableHListConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.eCy);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.eCa != null ? this.eCa.aMZ() : null);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.eCa != null && savedState.eCy != null) {
            this.eCa.X(savedState.eCy);
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
