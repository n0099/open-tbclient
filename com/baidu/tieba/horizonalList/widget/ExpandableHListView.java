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
    private static final int[] ebg = {16842920};
    private static final int[] ebh = {16842921};
    private static final int[] ebi = {16842920, 16842921};
    private static final int[][] ebj = {EMPTY_STATE_SET, ebg, ebh, ebi};
    private static final int[] ebk = {16842918};
    private ExpandableHListConnector eaX;
    private ExpandableListAdapter eaY;
    private int eaZ;
    private int eba;
    private int ebb;
    private int ebc;
    private int ebd;
    private Drawable ebe;
    private Drawable ebf;
    private Drawable ebl;
    private final Rect ebm;
    private int ebn;
    private int ebo;
    private int ebp;
    private int ebq;
    private d ebr;
    private e ebs;
    private c ebt;
    private b ebu;
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
        this.ebm = new Rect();
        this.mTempRect = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.ExpandableHListView, i, 0);
        setGroupIndicator(obtainStyledAttributes.getDrawable(d.l.ExpandableHListView_hlv_groupIndicator));
        setChildIndicator(obtainStyledAttributes.getDrawable(d.l.ExpandableHListView_hlv_childIndicator));
        this.mIndicatorLeft = obtainStyledAttributes.getDimensionPixelSize(d.l.ExpandableHListView_hlv_indicatorPaddingLeft, 0);
        this.eaZ = obtainStyledAttributes.getDimensionPixelSize(d.l.ExpandableHListView_hlv_indicatorPaddingTop, 0);
        this.eba = obtainStyledAttributes.getInt(d.l.ExpandableHListView_hlv_indicatorGravity, 0);
        this.ebb = obtainStyledAttributes.getInt(d.l.ExpandableHListView_hlv_childIndicatorGravity, 0);
        this.ebd = obtainStyledAttributes.getDimensionPixelSize(d.l.ExpandableHListView_hlv_childIndicatorPaddingLeft, 0);
        this.ebc = obtainStyledAttributes.getDimensionPixelSize(d.l.ExpandableHListView_hlv_childIndicatorPaddingTop, 0);
        this.ebl = obtainStyledAttributes.getDrawable(d.l.ExpandableHListView_hlv_childDivider);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        aEW();
        aEX();
    }

    private void aEW() {
        if (this.ebe != null) {
            this.ebn = this.ebe.getIntrinsicWidth();
            this.ebo = this.ebe.getIntrinsicHeight();
            return;
        }
        this.ebn = 0;
        this.ebo = 0;
    }

    private void aEX() {
        if (this.ebf != null) {
            this.ebp = this.ebf.getIntrinsicWidth();
            this.ebq = this.ebf.getIntrinsicHeight();
            return;
        }
        this.ebp = 0;
        this.ebq = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.ebf != null || this.ebe != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.mItemCount - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            Rect rect = this.ebm;
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
                            ExpandableHListConnector.b nd = this.eaX.nd(i4);
                            if (nd.eaR.type != i2) {
                                if (nd.eaR.type == 1) {
                                    rect.top = childAt.getTop() + this.ebc;
                                    rect.bottom = childAt.getBottom() + this.ebc;
                                } else {
                                    rect.top = childAt.getTop() + this.eaZ;
                                    rect.bottom = childAt.getBottom() + this.eaZ;
                                }
                                i2 = nd.eaR.type;
                            }
                            if (rect.top != rect.bottom) {
                                if (nd.eaR.type == 1) {
                                    rect.left = this.ebd + left;
                                    rect.right = this.ebd + right2;
                                } else {
                                    rect.left = this.mIndicatorLeft + left;
                                    rect.right = this.mIndicatorLeft + right2;
                                }
                                Drawable c2 = c(nd);
                                if (c2 != null) {
                                    if (nd.eaR.type == 1) {
                                        Gravity.apply(this.ebb, this.ebp, this.ebq, rect, this.mTempRect);
                                    } else {
                                        Gravity.apply(this.eba, this.ebn, this.ebo, rect, this.mTempRect);
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
        if (bVar.eaR.type == 2) {
            Drawable drawable = this.ebe;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            drawable.setState(ebj[(bVar.arL() ? (char) 1 : (char) 0) | (bVar.eaS == null || bVar.eaS.eaM == bVar.eaS.eaL ? (char) 2 : (char) 0)]);
            return drawable;
        }
        Drawable drawable2 = this.ebf;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(bVar.eaR.eaW == bVar.eaS.eaM ? ebk : EMPTY_STATE_SET);
        }
        return drawable2;
    }

    public void setChildDivider(Drawable drawable) {
        this.ebl = drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tieba.horizonalList.widget.HListView
    public void drawDivider(Canvas canvas, Rect rect, int i) {
        int i2 = this.mFirstPosition + i;
        if (i2 >= 0) {
            ExpandableHListConnector.b nd = this.eaX.nd(ng(i2));
            if (nd.eaR.type == 1 || (nd.arL() && nd.eaS.eaM != nd.eaS.eaL)) {
                Drawable drawable = this.ebl;
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
        this.eaY = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.eaX = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.eaX = null;
        }
        super.setAdapter((ListAdapter) this.eaX);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.eaY;
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
        ExpandableHListConnector.b nd = this.eaX.nd(i);
        long b2 = b(nd.eaR);
        if (nd.eaR.type == 2) {
            if (this.ebt != null && this.ebt.a(this, view, nd.eaR.eaU, b2)) {
                nd.recycle();
                return true;
            }
            if (nd.arL()) {
                this.eaX.a(nd);
                playSoundEffect(0);
                if (this.ebr != null) {
                    this.ebr.onGroupCollapse(nd.eaR.eaU);
                }
            } else {
                this.eaX.b(nd);
                playSoundEffect(0);
                if (this.ebs != null) {
                    this.ebs.onGroupExpand(nd.eaR.eaU);
                }
                int i2 = nd.eaR.eaU;
                int headerViewsCount = nd.eaR.eaW + getHeaderViewsCount();
                smoothScrollToPosition(this.eaY.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.ebu != null) {
            playSoundEffect(0);
            return this.ebu.a(this, view, nd.eaR.eaU, nd.eaR.eaV, b2);
        } else {
            z = false;
        }
        nd.recycle();
        return z;
    }

    public void setOnGroupCollapseListener(d dVar) {
        this.ebr = dVar;
    }

    public void setOnGroupExpandListener(e eVar) {
        this.ebs = eVar;
    }

    public void setOnGroupClickListener(c cVar) {
        this.ebt = cVar;
    }

    public void setOnChildClickListener(b bVar) {
        this.ebu = bVar;
    }

    public long getExpandableListPosition(int i) {
        if (isHeaderOrFooterPosition(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b nd = this.eaX.nd(ng(i));
        long aEU = nd.eaR.aEU();
        nd.recycle();
        return aEU;
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
            return this.eaY.getGroupId(packedPositionGroup);
        }
        return this.eaY.getChildId(packedPositionGroup, getPackedPositionChild(selectedPosition));
    }

    public void setSelectedGroup(int i) {
        com.baidu.tieba.horizonalList.widget.a nf = com.baidu.tieba.horizonalList.widget.a.nf(i);
        ExpandableHListConnector.b a2 = this.eaX.a(nf);
        nf.recycle();
        super.setSelection(nh(a2.eaR.eaW));
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
        ExpandableHListConnector.b nd = this.eaX.nd(ng(i));
        com.baidu.tieba.horizonalList.widget.a aVar = nd.eaR;
        long b2 = b(aVar);
        long aEU = aVar.aEU();
        nd.recycle();
        return new a(view, aEU, b2);
    }

    private long b(com.baidu.tieba.horizonalList.widget.a aVar) {
        return aVar.type == 1 ? this.eaY.getChildId(aVar.eaU, aVar.eaV) : this.eaY.getGroupId(aVar.eaU);
    }

    public void setChildIndicator(Drawable drawable) {
        this.ebf = drawable;
        aEX();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.ebe = drawable;
        aEW();
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
        ArrayList<ExpandableHListConnector.GroupMetadata> ebv;

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.ebv = arrayList;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.ebv = new ArrayList<>();
            parcel.readList(this.ebv, ExpandableHListConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.ebv);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.eaX != null ? this.eaX.aES() : null);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.eaX != null && savedState.ebv != null) {
            this.eaX.Y(savedState.ebv);
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
