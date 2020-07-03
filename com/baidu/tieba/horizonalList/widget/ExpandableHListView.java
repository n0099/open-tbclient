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
import com.baidu.tieba.R;
import com.baidu.tieba.horizonalList.widget.AdapterView;
import com.baidu.tieba.horizonalList.widget.ExpandableHListConnector;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ExpandableHListView extends HListView {
    private static final int[] EMPTY_STATE_SET = new int[0];
    private static final int[] bgq = {16842920};
    private static final int[] bgr = {16842921};
    private static final int[] bgt = {16842920, 16842921};
    private static final int[][] bgu = {EMPTY_STATE_SET, bgq, bgr, bgt};
    private static final int[] bgv = {16842918};
    private int bgA;
    private int bgB;
    private ExpandableListAdapter bgi;
    private int bgj;
    private int bgk;
    private int bgl;
    private int bgm;
    private int bgn;
    private Drawable bgo;
    private Drawable bgp;
    private Drawable bgw;
    private final Rect bgx;
    private int bgy;
    private int bgz;
    private ExpandableHListConnector iBJ;
    private d iBK;
    private e iBL;
    private c iBM;
    private b iBN;
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
        void dj(int i);
    }

    /* loaded from: classes.dex */
    public interface e {
        void dk(int i);
    }

    public ExpandableHListView(Context context) {
        this(context, null);
    }

    public ExpandableHListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.hlv_expandableListViewStyle);
    }

    public ExpandableHListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bgx = new Rect();
        this.mTempRect = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandableHListView, i, 0);
        setGroupIndicator(obtainStyledAttributes.getDrawable(5));
        setChildIndicator(obtainStyledAttributes.getDrawable(1));
        this.mIndicatorLeft = obtainStyledAttributes.getDimensionPixelSize(7, 0);
        this.bgj = obtainStyledAttributes.getDimensionPixelSize(8, 0);
        this.bgk = obtainStyledAttributes.getInt(2, 0);
        this.bgl = obtainStyledAttributes.getInt(3, 0);
        this.bgn = obtainStyledAttributes.getDimensionPixelSize(6, 0);
        this.bgm = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.bgw = obtainStyledAttributes.getDrawable(4);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        Ia();
        Ib();
    }

    private void Ia() {
        if (this.bgo != null) {
            this.bgy = this.bgo.getIntrinsicWidth();
            this.bgz = this.bgo.getIntrinsicHeight();
            return;
        }
        this.bgy = 0;
        this.bgz = 0;
    }

    private void Ib() {
        if (this.bgp != null) {
            this.bgA = this.bgp.getIntrinsicWidth();
            this.bgB = this.bgp.getIntrinsicHeight();
            return;
        }
        this.bgA = 0;
        this.bgB = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.bgp != null || this.bgo != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.mItemCount - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            Rect rect = this.bgx;
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
                            ExpandableHListConnector.b xv = this.iBJ.xv(i4);
                            if (xv.iBH.type != i2) {
                                if (xv.iBH.type == 1) {
                                    rect.top = childAt.getTop() + this.bgm;
                                    rect.bottom = childAt.getBottom() + this.bgm;
                                } else {
                                    rect.top = childAt.getTop() + this.bgj;
                                    rect.bottom = childAt.getBottom() + this.bgj;
                                }
                                i2 = xv.iBH.type;
                            }
                            if (rect.top != rect.bottom) {
                                if (xv.iBH.type == 1) {
                                    rect.left = this.bgn + left;
                                    rect.right = this.bgn + right2;
                                } else {
                                    rect.left = this.mIndicatorLeft + left;
                                    rect.right = this.mIndicatorLeft + right2;
                                }
                                Drawable c2 = c(xv);
                                if (c2 != null) {
                                    if (xv.iBH.type == 1) {
                                        Gravity.apply(this.bgl, this.bgA, this.bgB, rect, this.mTempRect);
                                    } else {
                                        Gravity.apply(this.bgk, this.bgy, this.bgz, rect, this.mTempRect);
                                    }
                                    c2.setBounds(this.mTempRect);
                                    c2.draw(canvas);
                                }
                            }
                            xv.recycle();
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
        if (bVar.iBH.type == 2) {
            Drawable drawable = this.bgo;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            drawable.setState(bgu[(bVar.HX() ? (char) 1 : (char) 0) | (bVar.iBI == null || bVar.iBI.bfW == bVar.iBI.bfV ? (char) 2 : (char) 0)]);
            return drawable;
        }
        Drawable drawable2 = this.bgp;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(bVar.iBH.bgg == bVar.iBI.bfW ? bgv : EMPTY_STATE_SET);
        }
        return drawable2;
    }

    public void setChildDivider(Drawable drawable) {
        this.bgw = drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tieba.horizonalList.widget.HListView
    public void drawDivider(Canvas canvas, Rect rect, int i) {
        int i2 = this.mFirstPosition + i;
        if (i2 >= 0) {
            ExpandableHListConnector.b xv = this.iBJ.xv(dg(i2));
            if (xv.iBH.type == 1 || (xv.HX() && xv.iBI.bfW != xv.iBI.bfV)) {
                Drawable drawable = this.bgw;
                drawable.setBounds(rect);
                drawable.draw(canvas);
                xv.recycle();
                return;
            }
            xv.recycle();
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
        this.bgi = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.iBJ = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.iBJ = null;
        }
        super.setAdapter((ListAdapter) this.iBJ);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.bgi;
    }

    private boolean isHeaderOrFooterPosition(int i) {
        return i < getHeaderViewsCount() || i >= this.mItemCount - getFooterViewsCount();
    }

    private int dg(int i) {
        return i - getHeaderViewsCount();
    }

    private int dh(int i) {
        return getHeaderViewsCount() + i;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.AdapterView
    public boolean performItemClick(View view, int i, long j) {
        if (isHeaderOrFooterPosition(i)) {
            return super.performItemClick(view, i, j);
        }
        return a(view, dg(i), j);
    }

    boolean a(View view, int i, long j) {
        boolean z;
        ExpandableHListConnector.b xv = this.iBJ.xv(i);
        long b2 = b(xv.iBH);
        if (xv.iBH.type == 2) {
            if (this.iBM != null && this.iBM.a(this, view, xv.iBH.bge, b2)) {
                xv.recycle();
                return true;
            }
            if (xv.HX()) {
                this.iBJ.a(xv);
                playSoundEffect(0);
                if (this.iBK != null) {
                    this.iBK.dj(xv.iBH.bge);
                }
            } else {
                this.iBJ.b(xv);
                playSoundEffect(0);
                if (this.iBL != null) {
                    this.iBL.dk(xv.iBH.bge);
                }
                int i2 = xv.iBH.bge;
                int headerViewsCount = xv.iBH.bgg + getHeaderViewsCount();
                smoothScrollToPosition(this.bgi.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.iBN != null) {
            playSoundEffect(0);
            return this.iBN.a(this, view, xv.iBH.bge, xv.iBH.bgf, b2);
        } else {
            z = false;
        }
        xv.recycle();
        return z;
    }

    public void setOnGroupCollapseListener(d dVar) {
        this.iBK = dVar;
    }

    public void setOnGroupExpandListener(e eVar) {
        this.iBL = eVar;
    }

    public void setOnGroupClickListener(c cVar) {
        this.iBM = cVar;
    }

    public void setOnChildClickListener(b bVar) {
        this.iBN = bVar;
    }

    public long di(int i) {
        if (isHeaderOrFooterPosition(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b xv = this.iBJ.xv(dg(i));
        long HY = xv.iBH.HY();
        xv.recycle();
        return HY;
    }

    public long getSelectedPosition() {
        return di(getSelectedItemPosition());
    }

    public long getSelectedId() {
        long selectedPosition = getSelectedPosition();
        if (selectedPosition == 4294967295L) {
            return -1L;
        }
        int ar = ar(selectedPosition);
        if (aq(selectedPosition) == 0) {
            return this.bgi.getGroupId(ar);
        }
        return this.bgi.getChildId(ar, as(selectedPosition));
    }

    public void setSelectedGroup(int i) {
        com.baidu.tieba.horizonalList.widget.a xx = com.baidu.tieba.horizonalList.widget.a.xx(i);
        ExpandableHListConnector.b a2 = this.iBJ.a(xx);
        xx.recycle();
        super.setSelection(dh(a2.iBH.bgg));
        a2.recycle();
    }

    public static int aq(long j) {
        if (j == 4294967295L) {
            return 2;
        }
        return (j & Long.MIN_VALUE) == Long.MIN_VALUE ? 1 : 0;
    }

    public static int ar(long j) {
        if (j == 4294967295L) {
            return -1;
        }
        return (int) ((9223372032559808512L & j) >> 32);
    }

    public static int as(long j) {
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
        ExpandableHListConnector.b xv = this.iBJ.xv(dg(i));
        com.baidu.tieba.horizonalList.widget.a aVar = xv.iBH;
        long b2 = b(aVar);
        long HY = aVar.HY();
        xv.recycle();
        return new a(view, HY, b2);
    }

    private long b(com.baidu.tieba.horizonalList.widget.a aVar) {
        return aVar.type == 1 ? this.bgi.getChildId(aVar.bge, aVar.bgf) : this.bgi.getGroupId(aVar.bge);
    }

    public void setChildIndicator(Drawable drawable) {
        this.bgp = drawable;
        Ib();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.bgo = drawable;
        Ia();
    }

    /* loaded from: classes.dex */
    public static class a implements ContextMenu.ContextMenuInfo {
        public long bgG;
        public long id;
        public View targetView;

        public a(View view, long j, long j2) {
            this.targetView = view;
            this.bgG = j;
            this.id = j2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.tieba.horizonalList.widget.ExpandableHListView.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: Z */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: xy */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        ArrayList<ExpandableHListConnector.GroupMetadata> bgH;

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.bgH = arrayList;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.bgH = new ArrayList<>();
            parcel.readList(this.bgH, ExpandableHListConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.bgH);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.iBJ != null ? this.iBJ.HV() : null);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.iBJ != null && savedState.bgH != null) {
            this.iBJ.k(savedState.bgH);
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
