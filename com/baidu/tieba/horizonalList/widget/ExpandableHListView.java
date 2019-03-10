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
    private static final int[] fSq = {16842920};
    private static final int[] fSr = {16842921};
    private static final int[] fSs = {16842920, 16842921};
    private static final int[][] fSt = {EMPTY_STATE_SET, fSq, fSr, fSs};
    private static final int[] fSu = {16842918};
    private int fSA;
    private d fSB;
    private e fSC;
    private c fSD;
    private b fSE;
    private ExpandableHListConnector fSh;
    private ExpandableListAdapter fSi;
    private int fSj;
    private int fSk;
    private int fSl;
    private int fSm;
    private int fSn;
    private Drawable fSo;
    private Drawable fSp;
    private Drawable fSv;
    private final Rect fSw;
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
        this.fSw = new Rect();
        this.mTempRect = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.ExpandableHListView, i, 0);
        setGroupIndicator(obtainStyledAttributes.getDrawable(d.l.ExpandableHListView_hlv_groupIndicator));
        setChildIndicator(obtainStyledAttributes.getDrawable(d.l.ExpandableHListView_hlv_childIndicator));
        this.mIndicatorLeft = obtainStyledAttributes.getDimensionPixelSize(d.l.ExpandableHListView_hlv_indicatorPaddingLeft, 0);
        this.fSj = obtainStyledAttributes.getDimensionPixelSize(d.l.ExpandableHListView_hlv_indicatorPaddingTop, 0);
        this.fSk = obtainStyledAttributes.getInt(d.l.ExpandableHListView_hlv_indicatorGravity, 0);
        this.fSl = obtainStyledAttributes.getInt(d.l.ExpandableHListView_hlv_childIndicatorGravity, 0);
        this.fSn = obtainStyledAttributes.getDimensionPixelSize(d.l.ExpandableHListView_hlv_childIndicatorPaddingLeft, 0);
        this.fSm = obtainStyledAttributes.getDimensionPixelSize(d.l.ExpandableHListView_hlv_childIndicatorPaddingTop, 0);
        this.fSv = obtainStyledAttributes.getDrawable(d.l.ExpandableHListView_hlv_childDivider);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        bnK();
        bnL();
    }

    private void bnK() {
        if (this.fSo != null) {
            this.fSx = this.fSo.getIntrinsicWidth();
            this.fSy = this.fSo.getIntrinsicHeight();
            return;
        }
        this.fSx = 0;
        this.fSy = 0;
    }

    private void bnL() {
        if (this.fSp != null) {
            this.fSz = this.fSp.getIntrinsicWidth();
            this.fSA = this.fSp.getIntrinsicHeight();
            return;
        }
        this.fSz = 0;
        this.fSA = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.fSp != null || this.fSo != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.mItemCount - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            Rect rect = this.fSw;
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
                            ExpandableHListConnector.b sQ = this.fSh.sQ(i4);
                            if (sQ.fSb.type != i2) {
                                if (sQ.fSb.type == 1) {
                                    rect.top = childAt.getTop() + this.fSm;
                                    rect.bottom = childAt.getBottom() + this.fSm;
                                } else {
                                    rect.top = childAt.getTop() + this.fSj;
                                    rect.bottom = childAt.getBottom() + this.fSj;
                                }
                                i2 = sQ.fSb.type;
                            }
                            if (rect.top != rect.bottom) {
                                if (sQ.fSb.type == 1) {
                                    rect.left = this.fSn + left;
                                    rect.right = this.fSn + right2;
                                } else {
                                    rect.left = this.mIndicatorLeft + left;
                                    rect.right = this.mIndicatorLeft + right2;
                                }
                                Drawable c2 = c(sQ);
                                if (c2 != null) {
                                    if (sQ.fSb.type == 1) {
                                        Gravity.apply(this.fSl, this.fSz, this.fSA, rect, this.mTempRect);
                                    } else {
                                        Gravity.apply(this.fSk, this.fSx, this.fSy, rect, this.mTempRect);
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
        if (bVar.fSb.type == 2) {
            Drawable drawable = this.fSo;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            drawable.setState(fSt[(bVar.aZS() ? (char) 1 : (char) 0) | (bVar.fSc == null || bVar.fSc.fRW == bVar.fSc.fRV ? (char) 2 : (char) 0)]);
            return drawable;
        }
        Drawable drawable2 = this.fSp;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(bVar.fSb.fSg == bVar.fSc.fRW ? fSu : EMPTY_STATE_SET);
        }
        return drawable2;
    }

    public void setChildDivider(Drawable drawable) {
        this.fSv = drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tieba.horizonalList.widget.HListView
    public void drawDivider(Canvas canvas, Rect rect, int i) {
        int i2 = this.mFirstPosition + i;
        if (i2 >= 0) {
            ExpandableHListConnector.b sQ = this.fSh.sQ(sT(i2));
            if (sQ.fSb.type == 1 || (sQ.aZS() && sQ.fSc.fRW != sQ.fSc.fRV)) {
                Drawable drawable = this.fSv;
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
        this.fSi = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.fSh = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.fSh = null;
        }
        super.setAdapter((ListAdapter) this.fSh);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.fSi;
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
        ExpandableHListConnector.b sQ = this.fSh.sQ(i);
        long b2 = b(sQ.fSb);
        if (sQ.fSb.type == 2) {
            if (this.fSD != null && this.fSD.a(this, view, sQ.fSb.fSe, b2)) {
                sQ.recycle();
                return true;
            }
            if (sQ.aZS()) {
                this.fSh.a(sQ);
                playSoundEffect(0);
                if (this.fSB != null) {
                    this.fSB.onGroupCollapse(sQ.fSb.fSe);
                }
            } else {
                this.fSh.b(sQ);
                playSoundEffect(0);
                if (this.fSC != null) {
                    this.fSC.onGroupExpand(sQ.fSb.fSe);
                }
                int i2 = sQ.fSb.fSe;
                int headerViewsCount = sQ.fSb.fSg + getHeaderViewsCount();
                smoothScrollToPosition(this.fSi.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.fSE != null) {
            playSoundEffect(0);
            return this.fSE.a(this, view, sQ.fSb.fSe, sQ.fSb.fSf, b2);
        } else {
            z = false;
        }
        sQ.recycle();
        return z;
    }

    public void setOnGroupCollapseListener(d dVar) {
        this.fSB = dVar;
    }

    public void setOnGroupExpandListener(e eVar) {
        this.fSC = eVar;
    }

    public void setOnGroupClickListener(c cVar) {
        this.fSD = cVar;
    }

    public void setOnChildClickListener(b bVar) {
        this.fSE = bVar;
    }

    public long getExpandableListPosition(int i) {
        if (isHeaderOrFooterPosition(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b sQ = this.fSh.sQ(sT(i));
        long bnI = sQ.fSb.bnI();
        sQ.recycle();
        return bnI;
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
            return this.fSi.getGroupId(packedPositionGroup);
        }
        return this.fSi.getChildId(packedPositionGroup, getPackedPositionChild(selectedPosition));
    }

    public void setSelectedGroup(int i) {
        com.baidu.tieba.horizonalList.widget.a sS = com.baidu.tieba.horizonalList.widget.a.sS(i);
        ExpandableHListConnector.b a2 = this.fSh.a(sS);
        sS.recycle();
        super.setSelection(sU(a2.fSb.fSg));
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
        ExpandableHListConnector.b sQ = this.fSh.sQ(sT(i));
        com.baidu.tieba.horizonalList.widget.a aVar = sQ.fSb;
        long b2 = b(aVar);
        long bnI = aVar.bnI();
        sQ.recycle();
        return new a(view, bnI, b2);
    }

    private long b(com.baidu.tieba.horizonalList.widget.a aVar) {
        return aVar.type == 1 ? this.fSi.getChildId(aVar.fSe, aVar.fSf) : this.fSi.getGroupId(aVar.fSe);
    }

    public void setChildIndicator(Drawable drawable) {
        this.fSp = drawable;
        bnL();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.fSo = drawable;
        bnK();
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
        ArrayList<ExpandableHListConnector.GroupMetadata> fSF;

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.fSF = arrayList;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.fSF = new ArrayList<>();
            parcel.readList(this.fSF, ExpandableHListConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.fSF);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.fSh != null ? this.fSh.bnG() : null);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.fSh != null && savedState.fSF != null) {
            this.fSh.ab(savedState.fSF);
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
