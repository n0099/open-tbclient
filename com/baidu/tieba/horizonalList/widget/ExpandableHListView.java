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
    private static final int[] fSd = {16842920};
    private static final int[] fSe = {16842921};
    private static final int[] fSf = {16842920, 16842921};
    private static final int[][] fSg = {EMPTY_STATE_SET, fSd, fSe, fSf};
    private static final int[] fSh = {16842918};
    private ExpandableHListConnector fRU;
    private ExpandableListAdapter fRV;
    private int fRW;
    private int fRX;
    private int fRY;
    private int fRZ;
    private int fSa;
    private Drawable fSb;
    private Drawable fSc;
    private Drawable fSi;
    private final Rect fSj;
    private int fSk;
    private int fSl;
    private int fSm;
    private int fSn;
    private d fSo;
    private e fSp;
    private c fSq;
    private b fSr;
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
        this.fSj = new Rect();
        this.mTempRect = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.ExpandableHListView, i, 0);
        setGroupIndicator(obtainStyledAttributes.getDrawable(d.l.ExpandableHListView_hlv_groupIndicator));
        setChildIndicator(obtainStyledAttributes.getDrawable(d.l.ExpandableHListView_hlv_childIndicator));
        this.mIndicatorLeft = obtainStyledAttributes.getDimensionPixelSize(d.l.ExpandableHListView_hlv_indicatorPaddingLeft, 0);
        this.fRW = obtainStyledAttributes.getDimensionPixelSize(d.l.ExpandableHListView_hlv_indicatorPaddingTop, 0);
        this.fRX = obtainStyledAttributes.getInt(d.l.ExpandableHListView_hlv_indicatorGravity, 0);
        this.fRY = obtainStyledAttributes.getInt(d.l.ExpandableHListView_hlv_childIndicatorGravity, 0);
        this.fSa = obtainStyledAttributes.getDimensionPixelSize(d.l.ExpandableHListView_hlv_childIndicatorPaddingLeft, 0);
        this.fRZ = obtainStyledAttributes.getDimensionPixelSize(d.l.ExpandableHListView_hlv_childIndicatorPaddingTop, 0);
        this.fSi = obtainStyledAttributes.getDrawable(d.l.ExpandableHListView_hlv_childDivider);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        bnG();
        bnH();
    }

    private void bnG() {
        if (this.fSb != null) {
            this.fSk = this.fSb.getIntrinsicWidth();
            this.fSl = this.fSb.getIntrinsicHeight();
            return;
        }
        this.fSk = 0;
        this.fSl = 0;
    }

    private void bnH() {
        if (this.fSc != null) {
            this.fSm = this.fSc.getIntrinsicWidth();
            this.fSn = this.fSc.getIntrinsicHeight();
            return;
        }
        this.fSm = 0;
        this.fSn = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.fSc != null || this.fSb != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.mItemCount - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            Rect rect = this.fSj;
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
                            ExpandableHListConnector.b sM = this.fRU.sM(i4);
                            if (sM.fRO.type != i2) {
                                if (sM.fRO.type == 1) {
                                    rect.top = childAt.getTop() + this.fRZ;
                                    rect.bottom = childAt.getBottom() + this.fRZ;
                                } else {
                                    rect.top = childAt.getTop() + this.fRW;
                                    rect.bottom = childAt.getBottom() + this.fRW;
                                }
                                i2 = sM.fRO.type;
                            }
                            if (rect.top != rect.bottom) {
                                if (sM.fRO.type == 1) {
                                    rect.left = this.fSa + left;
                                    rect.right = this.fSa + right2;
                                } else {
                                    rect.left = this.mIndicatorLeft + left;
                                    rect.right = this.mIndicatorLeft + right2;
                                }
                                Drawable c2 = c(sM);
                                if (c2 != null) {
                                    if (sM.fRO.type == 1) {
                                        Gravity.apply(this.fRY, this.fSm, this.fSn, rect, this.mTempRect);
                                    } else {
                                        Gravity.apply(this.fRX, this.fSk, this.fSl, rect, this.mTempRect);
                                    }
                                    c2.setBounds(this.mTempRect);
                                    c2.draw(canvas);
                                }
                            }
                            sM.recycle();
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
        if (bVar.fRO.type == 2) {
            Drawable drawable = this.fSb;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            drawable.setState(fSg[(bVar.aZO() ? (char) 1 : (char) 0) | (bVar.fRP == null || bVar.fRP.fRJ == bVar.fRP.fRI ? (char) 2 : (char) 0)]);
            return drawable;
        }
        Drawable drawable2 = this.fSc;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(bVar.fRO.fRT == bVar.fRP.fRJ ? fSh : EMPTY_STATE_SET);
        }
        return drawable2;
    }

    public void setChildDivider(Drawable drawable) {
        this.fSi = drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tieba.horizonalList.widget.HListView
    public void drawDivider(Canvas canvas, Rect rect, int i) {
        int i2 = this.mFirstPosition + i;
        if (i2 >= 0) {
            ExpandableHListConnector.b sM = this.fRU.sM(sP(i2));
            if (sM.fRO.type == 1 || (sM.aZO() && sM.fRP.fRJ != sM.fRP.fRI)) {
                Drawable drawable = this.fSi;
                drawable.setBounds(rect);
                drawable.draw(canvas);
                sM.recycle();
                return;
            }
            sM.recycle();
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
        this.fRV = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.fRU = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.fRU = null;
        }
        super.setAdapter((ListAdapter) this.fRU);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.fRV;
    }

    private boolean isHeaderOrFooterPosition(int i) {
        return i < getHeaderViewsCount() || i >= this.mItemCount - getFooterViewsCount();
    }

    private int sP(int i) {
        return i - getHeaderViewsCount();
    }

    private int sQ(int i) {
        return getHeaderViewsCount() + i;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.AdapterView
    public boolean performItemClick(View view, int i, long j) {
        if (isHeaderOrFooterPosition(i)) {
            return super.performItemClick(view, i, j);
        }
        return d(view, sP(i), j);
    }

    boolean d(View view, int i, long j) {
        boolean z;
        ExpandableHListConnector.b sM = this.fRU.sM(i);
        long b2 = b(sM.fRO);
        if (sM.fRO.type == 2) {
            if (this.fSq != null && this.fSq.a(this, view, sM.fRO.fRR, b2)) {
                sM.recycle();
                return true;
            }
            if (sM.aZO()) {
                this.fRU.a(sM);
                playSoundEffect(0);
                if (this.fSo != null) {
                    this.fSo.onGroupCollapse(sM.fRO.fRR);
                }
            } else {
                this.fRU.b(sM);
                playSoundEffect(0);
                if (this.fSp != null) {
                    this.fSp.onGroupExpand(sM.fRO.fRR);
                }
                int i2 = sM.fRO.fRR;
                int headerViewsCount = sM.fRO.fRT + getHeaderViewsCount();
                smoothScrollToPosition(this.fRV.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.fSr != null) {
            playSoundEffect(0);
            return this.fSr.a(this, view, sM.fRO.fRR, sM.fRO.fRS, b2);
        } else {
            z = false;
        }
        sM.recycle();
        return z;
    }

    public void setOnGroupCollapseListener(d dVar) {
        this.fSo = dVar;
    }

    public void setOnGroupExpandListener(e eVar) {
        this.fSp = eVar;
    }

    public void setOnGroupClickListener(c cVar) {
        this.fSq = cVar;
    }

    public void setOnChildClickListener(b bVar) {
        this.fSr = bVar;
    }

    public long getExpandableListPosition(int i) {
        if (isHeaderOrFooterPosition(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b sM = this.fRU.sM(sP(i));
        long bnE = sM.fRO.bnE();
        sM.recycle();
        return bnE;
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
            return this.fRV.getGroupId(packedPositionGroup);
        }
        return this.fRV.getChildId(packedPositionGroup, getPackedPositionChild(selectedPosition));
    }

    public void setSelectedGroup(int i) {
        com.baidu.tieba.horizonalList.widget.a sO = com.baidu.tieba.horizonalList.widget.a.sO(i);
        ExpandableHListConnector.b a2 = this.fRU.a(sO);
        sO.recycle();
        super.setSelection(sQ(a2.fRO.fRT));
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
        ExpandableHListConnector.b sM = this.fRU.sM(sP(i));
        com.baidu.tieba.horizonalList.widget.a aVar = sM.fRO;
        long b2 = b(aVar);
        long bnE = aVar.bnE();
        sM.recycle();
        return new a(view, bnE, b2);
    }

    private long b(com.baidu.tieba.horizonalList.widget.a aVar) {
        return aVar.type == 1 ? this.fRV.getChildId(aVar.fRR, aVar.fRS) : this.fRV.getGroupId(aVar.fRR);
    }

    public void setChildIndicator(Drawable drawable) {
        this.fSc = drawable;
        bnH();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.fSb = drawable;
        bnG();
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
            /* renamed from: K */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: sR */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        ArrayList<ExpandableHListConnector.GroupMetadata> fSs;

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.fSs = arrayList;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.fSs = new ArrayList<>();
            parcel.readList(this.fSs, ExpandableHListConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.fSs);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.fRU != null ? this.fRU.bnC() : null);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.fRU != null && savedState.fSs != null) {
            this.fRU.ab(savedState.fSs);
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
