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
import com.baidu.tieba.f;
import com.baidu.tieba.horizonalList.widget.AdapterView;
import com.baidu.tieba.horizonalList.widget.ExpandableHListConnector;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ExpandableHListView extends HListView {
    private static final int[] EMPTY_STATE_SET = new int[0];
    private static final int[] ebd = {16842920};
    private static final int[] ebe = {16842921};
    private static final int[] ebf = {16842920, 16842921};
    private static final int[][] ebg = {EMPTY_STATE_SET, ebd, ebe, ebf};
    private static final int[] ebh = {16842918};
    private ExpandableHListConnector eaU;
    private ExpandableListAdapter eaV;
    private int eaW;
    private int eaX;
    private int eaY;
    private int eaZ;
    private int eba;
    private Drawable ebb;
    private Drawable ebc;
    private Drawable ebi;
    private final Rect ebj;
    private int ebk;
    private int ebl;
    private int ebm;
    private int ebn;
    private d ebo;
    private e ebp;
    private c ebq;
    private b ebr;
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
        this(context, attributeSet, f.c.hlv_expandableListViewStyle);
    }

    public ExpandableHListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ebj = new Rect();
        this.mTempRect = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f.l.ExpandableHListView, i, 0);
        setGroupIndicator(obtainStyledAttributes.getDrawable(f.l.ExpandableHListView_hlv_groupIndicator));
        setChildIndicator(obtainStyledAttributes.getDrawable(f.l.ExpandableHListView_hlv_childIndicator));
        this.mIndicatorLeft = obtainStyledAttributes.getDimensionPixelSize(f.l.ExpandableHListView_hlv_indicatorPaddingLeft, 0);
        this.eaW = obtainStyledAttributes.getDimensionPixelSize(f.l.ExpandableHListView_hlv_indicatorPaddingTop, 0);
        this.eaX = obtainStyledAttributes.getInt(f.l.ExpandableHListView_hlv_indicatorGravity, 0);
        this.eaY = obtainStyledAttributes.getInt(f.l.ExpandableHListView_hlv_childIndicatorGravity, 0);
        this.eba = obtainStyledAttributes.getDimensionPixelSize(f.l.ExpandableHListView_hlv_childIndicatorPaddingLeft, 0);
        this.eaZ = obtainStyledAttributes.getDimensionPixelSize(f.l.ExpandableHListView_hlv_childIndicatorPaddingTop, 0);
        this.ebi = obtainStyledAttributes.getDrawable(f.l.ExpandableHListView_hlv_childDivider);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        aET();
        aEU();
    }

    private void aET() {
        if (this.ebb != null) {
            this.ebk = this.ebb.getIntrinsicWidth();
            this.ebl = this.ebb.getIntrinsicHeight();
            return;
        }
        this.ebk = 0;
        this.ebl = 0;
    }

    private void aEU() {
        if (this.ebc != null) {
            this.ebm = this.ebc.getIntrinsicWidth();
            this.ebn = this.ebc.getIntrinsicHeight();
            return;
        }
        this.ebm = 0;
        this.ebn = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.ebc != null || this.ebb != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.mItemCount - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            Rect rect = this.ebj;
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
                            ExpandableHListConnector.b nd = this.eaU.nd(i4);
                            if (nd.eaO.type != i2) {
                                if (nd.eaO.type == 1) {
                                    rect.top = childAt.getTop() + this.eaZ;
                                    rect.bottom = childAt.getBottom() + this.eaZ;
                                } else {
                                    rect.top = childAt.getTop() + this.eaW;
                                    rect.bottom = childAt.getBottom() + this.eaW;
                                }
                                i2 = nd.eaO.type;
                            }
                            if (rect.top != rect.bottom) {
                                if (nd.eaO.type == 1) {
                                    rect.left = this.eba + left;
                                    rect.right = this.eba + right2;
                                } else {
                                    rect.left = this.mIndicatorLeft + left;
                                    rect.right = this.mIndicatorLeft + right2;
                                }
                                Drawable c2 = c(nd);
                                if (c2 != null) {
                                    if (nd.eaO.type == 1) {
                                        Gravity.apply(this.eaY, this.ebm, this.ebn, rect, this.mTempRect);
                                    } else {
                                        Gravity.apply(this.eaX, this.ebk, this.ebl, rect, this.mTempRect);
                                    }
                                    c2.setBounds(this.mTempRect);
                                    c2.draw(canvas);
                                }
                            }
                            nd.recycle();
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
        if (bVar.eaO.type == 2) {
            Drawable drawable = this.ebb;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            drawable.setState(ebg[(bVar.arL() ? (char) 1 : (char) 0) | (bVar.eaP == null || bVar.eaP.eaJ == bVar.eaP.eaI ? (char) 2 : (char) 0)]);
            return drawable;
        }
        Drawable drawable2 = this.ebc;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(bVar.eaO.eaT == bVar.eaP.eaJ ? ebh : EMPTY_STATE_SET);
        }
        return drawable2;
    }

    public void setChildDivider(Drawable drawable) {
        this.ebi = drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tieba.horizonalList.widget.HListView
    public void drawDivider(Canvas canvas, Rect rect, int i) {
        int i2 = this.mFirstPosition + i;
        if (i2 >= 0) {
            ExpandableHListConnector.b nd = this.eaU.nd(ng(i2));
            if (nd.eaO.type == 1 || (nd.arL() && nd.eaP.eaJ != nd.eaP.eaI)) {
                Drawable drawable = this.ebi;
                drawable.setBounds(rect);
                drawable.draw(canvas);
                nd.recycle();
                return;
            }
            nd.recycle();
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
        this.eaV = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.eaU = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.eaU = null;
        }
        super.setAdapter((ListAdapter) this.eaU);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.eaV;
    }

    private boolean isHeaderOrFooterPosition(int i) {
        return i < getHeaderViewsCount() || i >= this.mItemCount - getFooterViewsCount();
    }

    private int ng(int i) {
        return i - getHeaderViewsCount();
    }

    private int nh(int i) {
        return getHeaderViewsCount() + i;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.AdapterView
    public boolean performItemClick(View view, int i, long j) {
        if (isHeaderOrFooterPosition(i)) {
            return super.performItemClick(view, i, j);
        }
        return b(view, ng(i), j);
    }

    boolean b(View view, int i, long j) {
        boolean z;
        ExpandableHListConnector.b nd = this.eaU.nd(i);
        long b2 = b(nd.eaO);
        if (nd.eaO.type == 2) {
            if (this.ebq != null && this.ebq.a(this, view, nd.eaO.eaR, b2)) {
                nd.recycle();
                return true;
            }
            if (nd.arL()) {
                this.eaU.a(nd);
                playSoundEffect(0);
                if (this.ebo != null) {
                    this.ebo.onGroupCollapse(nd.eaO.eaR);
                }
            } else {
                this.eaU.b(nd);
                playSoundEffect(0);
                if (this.ebp != null) {
                    this.ebp.onGroupExpand(nd.eaO.eaR);
                }
                int i2 = nd.eaO.eaR;
                int headerViewsCount = nd.eaO.eaT + getHeaderViewsCount();
                smoothScrollToPosition(this.eaV.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.ebr != null) {
            playSoundEffect(0);
            return this.ebr.a(this, view, nd.eaO.eaR, nd.eaO.eaS, b2);
        } else {
            z = false;
        }
        nd.recycle();
        return z;
    }

    public void setOnGroupCollapseListener(d dVar) {
        this.ebo = dVar;
    }

    public void setOnGroupExpandListener(e eVar) {
        this.ebp = eVar;
    }

    public void setOnGroupClickListener(c cVar) {
        this.ebq = cVar;
    }

    public void setOnChildClickListener(b bVar) {
        this.ebr = bVar;
    }

    public long getExpandableListPosition(int i) {
        if (isHeaderOrFooterPosition(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b nd = this.eaU.nd(ng(i));
        long aER = nd.eaO.aER();
        nd.recycle();
        return aER;
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
            return this.eaV.getGroupId(packedPositionGroup);
        }
        return this.eaV.getChildId(packedPositionGroup, getPackedPositionChild(selectedPosition));
    }

    public void setSelectedGroup(int i) {
        com.baidu.tieba.horizonalList.widget.a nf = com.baidu.tieba.horizonalList.widget.a.nf(i);
        ExpandableHListConnector.b a2 = this.eaU.a(nf);
        nf.recycle();
        super.setSelection(nh(a2.eaO.eaT));
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
        ExpandableHListConnector.b nd = this.eaU.nd(ng(i));
        com.baidu.tieba.horizonalList.widget.a aVar = nd.eaO;
        long b2 = b(aVar);
        long aER = aVar.aER();
        nd.recycle();
        return new a(view, aER, b2);
    }

    private long b(com.baidu.tieba.horizonalList.widget.a aVar) {
        return aVar.type == 1 ? this.eaV.getChildId(aVar.eaR, aVar.eaS) : this.eaV.getGroupId(aVar.eaR);
    }

    public void setChildIndicator(Drawable drawable) {
        this.ebc = drawable;
        aEU();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.ebb = drawable;
        aET();
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
            /* renamed from: ni */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        ArrayList<ExpandableHListConnector.GroupMetadata> ebs;

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.ebs = arrayList;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.ebs = new ArrayList<>();
            parcel.readList(this.ebs, ExpandableHListConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.ebs);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.eaU != null ? this.eaU.aEP() : null);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.eaU != null && savedState.ebs != null) {
            this.eaU.Y(savedState.ebs);
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
