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
    private static final int[] fSp = {16842920};
    private static final int[] fSq = {16842921};
    private static final int[] fSr = {16842920, 16842921};
    private static final int[][] fSs = {EMPTY_STATE_SET, fSp, fSq, fSr};
    private static final int[] fSt = {16842918};
    private d fSA;
    private e fSB;
    private c fSC;
    private b fSD;
    private ExpandableHListConnector fSg;
    private ExpandableListAdapter fSh;
    private int fSi;
    private int fSj;
    private int fSk;
    private int fSl;
    private int fSm;
    private Drawable fSn;
    private Drawable fSo;
    private Drawable fSu;
    private final Rect fSv;
    private int fSw;
    private int fSx;
    private int fSy;
    private int fSz;
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
        this.fSv = new Rect();
        this.mTempRect = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.ExpandableHListView, i, 0);
        setGroupIndicator(obtainStyledAttributes.getDrawable(d.l.ExpandableHListView_hlv_groupIndicator));
        setChildIndicator(obtainStyledAttributes.getDrawable(d.l.ExpandableHListView_hlv_childIndicator));
        this.mIndicatorLeft = obtainStyledAttributes.getDimensionPixelSize(d.l.ExpandableHListView_hlv_indicatorPaddingLeft, 0);
        this.fSi = obtainStyledAttributes.getDimensionPixelSize(d.l.ExpandableHListView_hlv_indicatorPaddingTop, 0);
        this.fSj = obtainStyledAttributes.getInt(d.l.ExpandableHListView_hlv_indicatorGravity, 0);
        this.fSk = obtainStyledAttributes.getInt(d.l.ExpandableHListView_hlv_childIndicatorGravity, 0);
        this.fSm = obtainStyledAttributes.getDimensionPixelSize(d.l.ExpandableHListView_hlv_childIndicatorPaddingLeft, 0);
        this.fSl = obtainStyledAttributes.getDimensionPixelSize(d.l.ExpandableHListView_hlv_childIndicatorPaddingTop, 0);
        this.fSu = obtainStyledAttributes.getDrawable(d.l.ExpandableHListView_hlv_childDivider);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        bnJ();
        bnK();
    }

    private void bnJ() {
        if (this.fSn != null) {
            this.fSw = this.fSn.getIntrinsicWidth();
            this.fSx = this.fSn.getIntrinsicHeight();
            return;
        }
        this.fSw = 0;
        this.fSx = 0;
    }

    private void bnK() {
        if (this.fSo != null) {
            this.fSy = this.fSo.getIntrinsicWidth();
            this.fSz = this.fSo.getIntrinsicHeight();
            return;
        }
        this.fSy = 0;
        this.fSz = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.fSo != null || this.fSn != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.mItemCount - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            Rect rect = this.fSv;
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
                            ExpandableHListConnector.b sQ = this.fSg.sQ(i4);
                            if (sQ.fSa.type != i2) {
                                if (sQ.fSa.type == 1) {
                                    rect.top = childAt.getTop() + this.fSl;
                                    rect.bottom = childAt.getBottom() + this.fSl;
                                } else {
                                    rect.top = childAt.getTop() + this.fSi;
                                    rect.bottom = childAt.getBottom() + this.fSi;
                                }
                                i2 = sQ.fSa.type;
                            }
                            if (rect.top != rect.bottom) {
                                if (sQ.fSa.type == 1) {
                                    rect.left = this.fSm + left;
                                    rect.right = this.fSm + right2;
                                } else {
                                    rect.left = this.mIndicatorLeft + left;
                                    rect.right = this.mIndicatorLeft + right2;
                                }
                                Drawable c2 = c(sQ);
                                if (c2 != null) {
                                    if (sQ.fSa.type == 1) {
                                        Gravity.apply(this.fSk, this.fSy, this.fSz, rect, this.mTempRect);
                                    } else {
                                        Gravity.apply(this.fSj, this.fSw, this.fSx, rect, this.mTempRect);
                                    }
                                    c2.setBounds(this.mTempRect);
                                    c2.draw(canvas);
                                }
                            }
                            sQ.recycle();
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
        if (bVar.fSa.type == 2) {
            Drawable drawable = this.fSn;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            drawable.setState(fSs[(bVar.aZR() ? (char) 1 : (char) 0) | (bVar.fSb == null || bVar.fSb.fRV == bVar.fSb.fRU ? (char) 2 : (char) 0)]);
            return drawable;
        }
        Drawable drawable2 = this.fSo;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(bVar.fSa.fSf == bVar.fSb.fRV ? fSt : EMPTY_STATE_SET);
        }
        return drawable2;
    }

    public void setChildDivider(Drawable drawable) {
        this.fSu = drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tieba.horizonalList.widget.HListView
    public void drawDivider(Canvas canvas, Rect rect, int i) {
        int i2 = this.mFirstPosition + i;
        if (i2 >= 0) {
            ExpandableHListConnector.b sQ = this.fSg.sQ(sT(i2));
            if (sQ.fSa.type == 1 || (sQ.aZR() && sQ.fSb.fRV != sQ.fSb.fRU)) {
                Drawable drawable = this.fSu;
                drawable.setBounds(rect);
                drawable.draw(canvas);
                sQ.recycle();
                return;
            }
            sQ.recycle();
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
        this.fSh = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.fSg = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.fSg = null;
        }
        super.setAdapter((ListAdapter) this.fSg);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.fSh;
    }

    private boolean isHeaderOrFooterPosition(int i) {
        return i < getHeaderViewsCount() || i >= this.mItemCount - getFooterViewsCount();
    }

    private int sT(int i) {
        return i - getHeaderViewsCount();
    }

    private int sU(int i) {
        return getHeaderViewsCount() + i;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.AdapterView
    public boolean performItemClick(View view, int i, long j) {
        if (isHeaderOrFooterPosition(i)) {
            return super.performItemClick(view, i, j);
        }
        return d(view, sT(i), j);
    }

    boolean d(View view, int i, long j) {
        boolean z;
        ExpandableHListConnector.b sQ = this.fSg.sQ(i);
        long b2 = b(sQ.fSa);
        if (sQ.fSa.type == 2) {
            if (this.fSC != null && this.fSC.a(this, view, sQ.fSa.fSd, b2)) {
                sQ.recycle();
                return true;
            }
            if (sQ.aZR()) {
                this.fSg.a(sQ);
                playSoundEffect(0);
                if (this.fSA != null) {
                    this.fSA.onGroupCollapse(sQ.fSa.fSd);
                }
            } else {
                this.fSg.b(sQ);
                playSoundEffect(0);
                if (this.fSB != null) {
                    this.fSB.onGroupExpand(sQ.fSa.fSd);
                }
                int i2 = sQ.fSa.fSd;
                int headerViewsCount = sQ.fSa.fSf + getHeaderViewsCount();
                smoothScrollToPosition(this.fSh.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.fSD != null) {
            playSoundEffect(0);
            return this.fSD.a(this, view, sQ.fSa.fSd, sQ.fSa.fSe, b2);
        } else {
            z = false;
        }
        sQ.recycle();
        return z;
    }

    public void setOnGroupCollapseListener(d dVar) {
        this.fSA = dVar;
    }

    public void setOnGroupExpandListener(e eVar) {
        this.fSB = eVar;
    }

    public void setOnGroupClickListener(c cVar) {
        this.fSC = cVar;
    }

    public void setOnChildClickListener(b bVar) {
        this.fSD = bVar;
    }

    public long getExpandableListPosition(int i) {
        if (isHeaderOrFooterPosition(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b sQ = this.fSg.sQ(sT(i));
        long bnH = sQ.fSa.bnH();
        sQ.recycle();
        return bnH;
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
            return this.fSh.getGroupId(packedPositionGroup);
        }
        return this.fSh.getChildId(packedPositionGroup, getPackedPositionChild(selectedPosition));
    }

    public void setSelectedGroup(int i) {
        com.baidu.tieba.horizonalList.widget.a sS = com.baidu.tieba.horizonalList.widget.a.sS(i);
        ExpandableHListConnector.b a2 = this.fSg.a(sS);
        sS.recycle();
        super.setSelection(sU(a2.fSa.fSf));
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
        ExpandableHListConnector.b sQ = this.fSg.sQ(sT(i));
        com.baidu.tieba.horizonalList.widget.a aVar = sQ.fSa;
        long b2 = b(aVar);
        long bnH = aVar.bnH();
        sQ.recycle();
        return new a(view, bnH, b2);
    }

    private long b(com.baidu.tieba.horizonalList.widget.a aVar) {
        return aVar.type == 1 ? this.fSh.getChildId(aVar.fSd, aVar.fSe) : this.fSh.getGroupId(aVar.fSd);
    }

    public void setChildIndicator(Drawable drawable) {
        this.fSo = drawable;
        bnK();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.fSn = drawable;
        bnJ();
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
            /* renamed from: sV */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        ArrayList<ExpandableHListConnector.GroupMetadata> fSE;

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.fSE = arrayList;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.fSE = new ArrayList<>();
            parcel.readList(this.fSE, ExpandableHListConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.fSE);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.fSg != null ? this.fSg.bnF() : null);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.fSg != null && savedState.fSE != null) {
            this.fSg.ab(savedState.fSE);
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
