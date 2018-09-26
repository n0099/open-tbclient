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
    private Drawable eiD;
    private final Rect eiE;
    private int eiF;
    private int eiG;
    private int eiH;
    private int eiI;
    private d eiJ;
    private e eiK;
    private c eiL;
    private b eiM;
    private ExpandableHListConnector eip;
    private ExpandableListAdapter eiq;
    private int eir;
    private int eis;
    private int eit;
    private int eiu;
    private int eiv;
    private Drawable eiw;
    private Drawable eix;
    private int mIndicatorLeft;
    private final Rect mTempRect;
    private static final int[] EMPTY_STATE_SET = new int[0];
    private static final int[] eiy = {16842920};
    private static final int[] eiz = {16842921};
    private static final int[] eiA = {16842920, 16842921};
    private static final int[][] eiB = {EMPTY_STATE_SET, eiy, eiz, eiA};
    private static final int[] eiC = {16842918};

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
        this.eiE = new Rect();
        this.mTempRect = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.l.ExpandableHListView, i, 0);
        setGroupIndicator(obtainStyledAttributes.getDrawable(e.l.ExpandableHListView_hlv_groupIndicator));
        setChildIndicator(obtainStyledAttributes.getDrawable(e.l.ExpandableHListView_hlv_childIndicator));
        this.mIndicatorLeft = obtainStyledAttributes.getDimensionPixelSize(e.l.ExpandableHListView_hlv_indicatorPaddingLeft, 0);
        this.eir = obtainStyledAttributes.getDimensionPixelSize(e.l.ExpandableHListView_hlv_indicatorPaddingTop, 0);
        this.eis = obtainStyledAttributes.getInt(e.l.ExpandableHListView_hlv_indicatorGravity, 0);
        this.eit = obtainStyledAttributes.getInt(e.l.ExpandableHListView_hlv_childIndicatorGravity, 0);
        this.eiv = obtainStyledAttributes.getDimensionPixelSize(e.l.ExpandableHListView_hlv_childIndicatorPaddingLeft, 0);
        this.eiu = obtainStyledAttributes.getDimensionPixelSize(e.l.ExpandableHListView_hlv_childIndicatorPaddingTop, 0);
        this.eiD = obtainStyledAttributes.getDrawable(e.l.ExpandableHListView_hlv_childDivider);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        aHi();
        aHj();
    }

    private void aHi() {
        if (this.eiw != null) {
            this.eiF = this.eiw.getIntrinsicWidth();
            this.eiG = this.eiw.getIntrinsicHeight();
            return;
        }
        this.eiF = 0;
        this.eiG = 0;
    }

    private void aHj() {
        if (this.eix != null) {
            this.eiH = this.eix.getIntrinsicWidth();
            this.eiI = this.eix.getIntrinsicHeight();
            return;
        }
        this.eiH = 0;
        this.eiI = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.eix != null || this.eiw != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.mItemCount - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            Rect rect = this.eiE;
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
                            ExpandableHListConnector.b nH = this.eip.nH(i4);
                            if (nH.eij.type != i2) {
                                if (nH.eij.type == 1) {
                                    rect.top = childAt.getTop() + this.eiu;
                                    rect.bottom = childAt.getBottom() + this.eiu;
                                } else {
                                    rect.top = childAt.getTop() + this.eir;
                                    rect.bottom = childAt.getBottom() + this.eir;
                                }
                                i2 = nH.eij.type;
                            }
                            if (rect.top != rect.bottom) {
                                if (nH.eij.type == 1) {
                                    rect.left = this.eiv + left;
                                    rect.right = this.eiv + right2;
                                } else {
                                    rect.left = this.mIndicatorLeft + left;
                                    rect.right = this.mIndicatorLeft + right2;
                                }
                                Drawable c2 = c(nH);
                                if (c2 != null) {
                                    if (nH.eij.type == 1) {
                                        Gravity.apply(this.eit, this.eiH, this.eiI, rect, this.mTempRect);
                                    } else {
                                        Gravity.apply(this.eis, this.eiF, this.eiG, rect, this.mTempRect);
                                    }
                                    c2.setBounds(this.mTempRect);
                                    c2.draw(canvas);
                                }
                            }
                            nH.recycle();
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
        if (bVar.eij.type == 2) {
            Drawable drawable = this.eiw;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            drawable.setState(eiB[(bVar.atz() ? (char) 1 : (char) 0) | (bVar.eik == null || bVar.eik.eie == bVar.eik.eid ? (char) 2 : (char) 0)]);
            return drawable;
        }
        Drawable drawable2 = this.eix;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(bVar.eij.eio == bVar.eik.eie ? eiC : EMPTY_STATE_SET);
        }
        return drawable2;
    }

    public void setChildDivider(Drawable drawable) {
        this.eiD = drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tieba.horizonalList.widget.HListView
    public void drawDivider(Canvas canvas, Rect rect, int i) {
        int i2 = this.mFirstPosition + i;
        if (i2 >= 0) {
            ExpandableHListConnector.b nH = this.eip.nH(nK(i2));
            if (nH.eij.type == 1 || (nH.atz() && nH.eik.eie != nH.eik.eid)) {
                Drawable drawable = this.eiD;
                drawable.setBounds(rect);
                drawable.draw(canvas);
                nH.recycle();
                return;
            }
            nH.recycle();
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
        this.eiq = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.eip = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.eip = null;
        }
        super.setAdapter((ListAdapter) this.eip);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.eiq;
    }

    private boolean isHeaderOrFooterPosition(int i) {
        return i < getHeaderViewsCount() || i >= this.mItemCount - getFooterViewsCount();
    }

    private int nK(int i) {
        return i - getHeaderViewsCount();
    }

    private int nL(int i) {
        return getHeaderViewsCount() + i;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.AdapterView
    public boolean performItemClick(View view, int i, long j) {
        if (isHeaderOrFooterPosition(i)) {
            return super.performItemClick(view, i, j);
        }
        return b(view, nK(i), j);
    }

    boolean b(View view, int i, long j) {
        boolean z;
        ExpandableHListConnector.b nH = this.eip.nH(i);
        long b2 = b(nH.eij);
        if (nH.eij.type == 2) {
            if (this.eiL != null && this.eiL.a(this, view, nH.eij.eim, b2)) {
                nH.recycle();
                return true;
            }
            if (nH.atz()) {
                this.eip.a(nH);
                playSoundEffect(0);
                if (this.eiJ != null) {
                    this.eiJ.onGroupCollapse(nH.eij.eim);
                }
            } else {
                this.eip.b(nH);
                playSoundEffect(0);
                if (this.eiK != null) {
                    this.eiK.onGroupExpand(nH.eij.eim);
                }
                int i2 = nH.eij.eim;
                int headerViewsCount = nH.eij.eio + getHeaderViewsCount();
                smoothScrollToPosition(this.eiq.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.eiM != null) {
            playSoundEffect(0);
            return this.eiM.a(this, view, nH.eij.eim, nH.eij.ein, b2);
        } else {
            z = false;
        }
        nH.recycle();
        return z;
    }

    public void setOnGroupCollapseListener(d dVar) {
        this.eiJ = dVar;
    }

    public void setOnGroupExpandListener(e eVar) {
        this.eiK = eVar;
    }

    public void setOnGroupClickListener(c cVar) {
        this.eiL = cVar;
    }

    public void setOnChildClickListener(b bVar) {
        this.eiM = bVar;
    }

    public long getExpandableListPosition(int i) {
        if (isHeaderOrFooterPosition(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b nH = this.eip.nH(nK(i));
        long aHg = nH.eij.aHg();
        nH.recycle();
        return aHg;
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
            return this.eiq.getGroupId(packedPositionGroup);
        }
        return this.eiq.getChildId(packedPositionGroup, getPackedPositionChild(selectedPosition));
    }

    public void setSelectedGroup(int i) {
        com.baidu.tieba.horizonalList.widget.a nJ = com.baidu.tieba.horizonalList.widget.a.nJ(i);
        ExpandableHListConnector.b a2 = this.eip.a(nJ);
        nJ.recycle();
        super.setSelection(nL(a2.eij.eio));
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
        ExpandableHListConnector.b nH = this.eip.nH(nK(i));
        com.baidu.tieba.horizonalList.widget.a aVar = nH.eij;
        long b2 = b(aVar);
        long aHg = aVar.aHg();
        nH.recycle();
        return new a(view, aHg, b2);
    }

    private long b(com.baidu.tieba.horizonalList.widget.a aVar) {
        return aVar.type == 1 ? this.eiq.getChildId(aVar.eim, aVar.ein) : this.eiq.getGroupId(aVar.eim);
    }

    public void setChildIndicator(Drawable drawable) {
        this.eix = drawable;
        aHj();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.eiw = drawable;
        aHi();
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
            /* renamed from: nM */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        ArrayList<ExpandableHListConnector.GroupMetadata> eiN;

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.eiN = arrayList;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.eiN = new ArrayList<>();
            parcel.readList(this.eiN, ExpandableHListConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.eiN);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.eip != null ? this.eip.aHe() : null);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.eip != null && savedState.eiN != null) {
            this.eip.Y(savedState.eiN);
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
