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
    private static final int[] bgK = {16842920};
    private static final int[] bgL = {16842921};
    private static final int[] bgM = {16842920, 16842921};
    private static final int[][] bgN = {EMPTY_STATE_SET, bgK, bgL, bgM};
    private static final int[] bgO = {16842918};
    private ExpandableListAdapter bgC;
    private int bgD;
    private int bgE;
    private int bgF;
    private int bgG;
    private int bgH;
    private Drawable bgI;
    private Drawable bgJ;
    private Drawable bgP;
    private final Rect bgQ;
    private int bgR;
    private int bgS;
    private int bgT;
    private int bgU;
    private ExpandableHListConnector iHP;
    private d iHQ;
    private e iHR;
    private c iHS;
    private b iHT;
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
        this.bgQ = new Rect();
        this.mTempRect = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandableHListView, i, 0);
        setGroupIndicator(obtainStyledAttributes.getDrawable(R.styleable.ExpandableHListView_hlv_groupIndicator));
        setChildIndicator(obtainStyledAttributes.getDrawable(R.styleable.ExpandableHListView_hlv_childIndicator));
        this.mIndicatorLeft = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandableHListView_hlv_indicatorPaddingLeft, 0);
        this.bgD = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandableHListView_hlv_indicatorPaddingTop, 0);
        this.bgE = obtainStyledAttributes.getInt(R.styleable.ExpandableHListView_hlv_indicatorGravity, 0);
        this.bgF = obtainStyledAttributes.getInt(R.styleable.ExpandableHListView_hlv_childIndicatorGravity, 0);
        this.bgH = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandableHListView_hlv_childIndicatorPaddingLeft, 0);
        this.bgG = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandableHListView_hlv_childIndicatorPaddingTop, 0);
        this.bgP = obtainStyledAttributes.getDrawable(R.styleable.ExpandableHListView_hlv_childDivider);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        Ig();
        Ih();
    }

    private void Ig() {
        if (this.bgI != null) {
            this.bgR = this.bgI.getIntrinsicWidth();
            this.bgS = this.bgI.getIntrinsicHeight();
            return;
        }
        this.bgR = 0;
        this.bgS = 0;
    }

    private void Ih() {
        if (this.bgJ != null) {
            this.bgT = this.bgJ.getIntrinsicWidth();
            this.bgU = this.bgJ.getIntrinsicHeight();
            return;
        }
        this.bgT = 0;
        this.bgU = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.bgJ != null || this.bgI != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.mItemCount - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            Rect rect = this.bgQ;
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
                            ExpandableHListConnector.b xN = this.iHP.xN(i4);
                            if (xN.iHN.type != i2) {
                                if (xN.iHN.type == 1) {
                                    rect.top = childAt.getTop() + this.bgG;
                                    rect.bottom = childAt.getBottom() + this.bgG;
                                } else {
                                    rect.top = childAt.getTop() + this.bgD;
                                    rect.bottom = childAt.getBottom() + this.bgD;
                                }
                                i2 = xN.iHN.type;
                            }
                            if (rect.top != rect.bottom) {
                                if (xN.iHN.type == 1) {
                                    rect.left = this.bgH + left;
                                    rect.right = this.bgH + right2;
                                } else {
                                    rect.left = this.mIndicatorLeft + left;
                                    rect.right = this.mIndicatorLeft + right2;
                                }
                                Drawable c2 = c(xN);
                                if (c2 != null) {
                                    if (xN.iHN.type == 1) {
                                        Gravity.apply(this.bgF, this.bgT, this.bgU, rect, this.mTempRect);
                                    } else {
                                        Gravity.apply(this.bgE, this.bgR, this.bgS, rect, this.mTempRect);
                                    }
                                    c2.setBounds(this.mTempRect);
                                    c2.draw(canvas);
                                }
                            }
                            xN.recycle();
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
        if (bVar.iHN.type == 2) {
            Drawable drawable = this.bgI;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            drawable.setState(bgN[(bVar.Id() ? (char) 1 : (char) 0) | (bVar.iHO == null || bVar.iHO.bgp == bVar.iHO.bgo ? (char) 2 : (char) 0)]);
            return drawable;
        }
        Drawable drawable2 = this.bgJ;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(bVar.iHN.bgA == bVar.iHO.bgp ? bgO : EMPTY_STATE_SET);
        }
        return drawable2;
    }

    public void setChildDivider(Drawable drawable) {
        this.bgP = drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tieba.horizonalList.widget.HListView
    public void drawDivider(Canvas canvas, Rect rect, int i) {
        int i2 = this.mFirstPosition + i;
        if (i2 >= 0) {
            ExpandableHListConnector.b xN = this.iHP.xN(dg(i2));
            if (xN.iHN.type == 1 || (xN.Id() && xN.iHO.bgp != xN.iHO.bgo)) {
                Drawable drawable = this.bgP;
                drawable.setBounds(rect);
                drawable.draw(canvas);
                xN.recycle();
                return;
            }
            xN.recycle();
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
        this.bgC = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.iHP = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.iHP = null;
        }
        super.setAdapter((ListAdapter) this.iHP);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.bgC;
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
        ExpandableHListConnector.b xN = this.iHP.xN(i);
        long b2 = b(xN.iHN);
        if (xN.iHN.type == 2) {
            if (this.iHS != null && this.iHS.a(this, view, xN.iHN.bgy, b2)) {
                xN.recycle();
                return true;
            }
            if (xN.Id()) {
                this.iHP.a(xN);
                playSoundEffect(0);
                if (this.iHQ != null) {
                    this.iHQ.dj(xN.iHN.bgy);
                }
            } else {
                this.iHP.b(xN);
                playSoundEffect(0);
                if (this.iHR != null) {
                    this.iHR.dk(xN.iHN.bgy);
                }
                int i2 = xN.iHN.bgy;
                int headerViewsCount = xN.iHN.bgA + getHeaderViewsCount();
                smoothScrollToPosition(this.bgC.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.iHT != null) {
            playSoundEffect(0);
            return this.iHT.a(this, view, xN.iHN.bgy, xN.iHN.bgz, b2);
        } else {
            z = false;
        }
        xN.recycle();
        return z;
    }

    public void setOnGroupCollapseListener(d dVar) {
        this.iHQ = dVar;
    }

    public void setOnGroupExpandListener(e eVar) {
        this.iHR = eVar;
    }

    public void setOnGroupClickListener(c cVar) {
        this.iHS = cVar;
    }

    public void setOnChildClickListener(b bVar) {
        this.iHT = bVar;
    }

    public long di(int i) {
        if (isHeaderOrFooterPosition(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b xN = this.iHP.xN(dg(i));
        long Ie = xN.iHN.Ie();
        xN.recycle();
        return Ie;
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
            return this.bgC.getGroupId(ar);
        }
        return this.bgC.getChildId(ar, as(selectedPosition));
    }

    public void setSelectedGroup(int i) {
        com.baidu.tieba.horizonalList.widget.a xP = com.baidu.tieba.horizonalList.widget.a.xP(i);
        ExpandableHListConnector.b a2 = this.iHP.a(xP);
        xP.recycle();
        super.setSelection(dh(a2.iHN.bgA));
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
        ExpandableHListConnector.b xN = this.iHP.xN(dg(i));
        com.baidu.tieba.horizonalList.widget.a aVar = xN.iHN;
        long b2 = b(aVar);
        long Ie = aVar.Ie();
        xN.recycle();
        return new a(view, Ie, b2);
    }

    private long b(com.baidu.tieba.horizonalList.widget.a aVar) {
        return aVar.type == 1 ? this.bgC.getChildId(aVar.bgy, aVar.bgz) : this.bgC.getGroupId(aVar.bgy);
    }

    public void setChildIndicator(Drawable drawable) {
        this.bgJ = drawable;
        Ih();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.bgI = drawable;
        Ig();
    }

    /* loaded from: classes.dex */
    public static class a implements ContextMenu.ContextMenuInfo {
        public long bgZ;
        public long id;
        public View targetView;

        public a(View view, long j, long j2) {
            this.targetView = view;
            this.bgZ = j;
            this.id = j2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.tieba.horizonalList.widget.ExpandableHListView.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: ab */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: xQ */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        ArrayList<ExpandableHListConnector.GroupMetadata> bha;

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.bha = arrayList;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.bha = new ArrayList<>();
            parcel.readList(this.bha, ExpandableHListConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.bha);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.iHP != null ? this.iHP.Ib() : null);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.iHP != null && savedState.bha != null) {
            this.iHP.k(savedState.bha);
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
