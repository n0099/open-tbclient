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
    private static final int[] bID = {16842920};
    private static final int[] bIE = {16842921};
    private static final int[] bIF = {16842920, 16842921};
    private static final int[][] bIG = {EMPTY_STATE_SET, bID, bIE, bIF};
    private static final int[] bIH = {16842918};
    private int Zu;
    private int bIA;
    private Drawable bIB;
    private Drawable bIC;
    private Drawable bII;
    private final Rect bIJ;
    private int bIK;
    private int bIL;
    private int bIM;
    private int bIN;
    private ExpandableListAdapter bIv;
    private int bIw;
    private int bIx;
    private int bIy;
    private int bIz;
    private ExpandableHListConnector ksm;
    private d ksn;
    private e kso;
    private c ksp;
    private b ksq;
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
        void eE(int i);
    }

    /* loaded from: classes.dex */
    public interface e {
        void eF(int i);
    }

    public ExpandableHListView(Context context) {
        this(context, null);
    }

    public ExpandableHListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.hlv_expandableListViewStyle);
    }

    public ExpandableHListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bIJ = new Rect();
        this.mTempRect = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandableHListView, i, 0);
        setGroupIndicator(obtainStyledAttributes.getDrawable(R.styleable.ExpandableHListView_hlv_groupIndicator));
        setChildIndicator(obtainStyledAttributes.getDrawable(R.styleable.ExpandableHListView_hlv_childIndicator));
        this.Zu = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandableHListView_hlv_indicatorPaddingLeft, 0);
        this.bIw = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandableHListView_hlv_indicatorPaddingTop, 0);
        this.bIx = obtainStyledAttributes.getInt(R.styleable.ExpandableHListView_hlv_indicatorGravity, 0);
        this.bIy = obtainStyledAttributes.getInt(R.styleable.ExpandableHListView_hlv_childIndicatorGravity, 0);
        this.bIA = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandableHListView_hlv_childIndicatorPaddingLeft, 0);
        this.bIz = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandableHListView_hlv_childIndicatorPaddingTop, 0);
        this.bII = obtainStyledAttributes.getDrawable(R.styleable.ExpandableHListView_hlv_childDivider);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        TT();
        TU();
    }

    private void TT() {
        if (this.bIB != null) {
            this.bIK = this.bIB.getIntrinsicWidth();
            this.bIL = this.bIB.getIntrinsicHeight();
            return;
        }
        this.bIK = 0;
        this.bIL = 0;
    }

    private void TU() {
        if (this.bIC != null) {
            this.bIM = this.bIC.getIntrinsicWidth();
            this.bIN = this.bIC.getIntrinsicHeight();
            return;
        }
        this.bIM = 0;
        this.bIN = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.bIC != null || this.bIB != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.mItemCount - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            int i = -4;
            Rect rect = this.bIJ;
            int childCount = getChildCount();
            int i2 = 0;
            int i3 = this.mFirstPosition - headerViewsCount;
            while (i2 < childCount) {
                if (i3 >= 0) {
                    if (i3 <= footerViewsCount) {
                        View childAt = getChildAt(i2);
                        int left = childAt.getLeft();
                        int right2 = childAt.getRight();
                        if (right2 >= 0 && left <= right) {
                            ExpandableHListConnector.b Cg = this.ksm.Cg(i3);
                            if (Cg.ksk.type != i) {
                                if (Cg.ksk.type == 1) {
                                    rect.top = childAt.getTop() + this.bIz;
                                    rect.bottom = childAt.getBottom() + this.bIz;
                                } else {
                                    rect.top = childAt.getTop() + this.bIw;
                                    rect.bottom = childAt.getBottom() + this.bIw;
                                }
                                i = Cg.ksk.type;
                            }
                            if (rect.top != rect.bottom) {
                                if (Cg.ksk.type == 1) {
                                    rect.left = this.bIA + left;
                                    rect.right = this.bIA + right2;
                                } else {
                                    rect.left = this.Zu + left;
                                    rect.right = this.Zu + right2;
                                }
                                Drawable c2 = c(Cg);
                                if (c2 != null) {
                                    if (Cg.ksk.type == 1) {
                                        Gravity.apply(this.bIy, this.bIM, this.bIN, rect, this.mTempRect);
                                    } else {
                                        Gravity.apply(this.bIx, this.bIK, this.bIL, rect, this.mTempRect);
                                    }
                                    c2.setBounds(this.mTempRect);
                                    c2.draw(canvas);
                                }
                            }
                            Cg.recycle();
                        }
                    } else {
                        return;
                    }
                }
                i2++;
                i3++;
            }
        }
    }

    private Drawable c(ExpandableHListConnector.b bVar) {
        if (bVar.ksk.type == 2) {
            Drawable drawable = this.bIB;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            drawable.setState(bIG[(bVar.isExpanded() ? (char) 1 : (char) 0) | (bVar.ksl == null || bVar.ksl.bIj == bVar.ksl.bIi ? (char) 2 : (char) 0)]);
            return drawable;
        }
        Drawable drawable2 = this.bIC;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(bVar.ksk.bIt == bVar.ksl.bIj ? bIH : EMPTY_STATE_SET);
        }
        return drawable2;
    }

    public void setChildDivider(Drawable drawable) {
        this.bII = drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tieba.horizonalList.widget.HListView
    public void drawDivider(Canvas canvas, Rect rect, int i) {
        int i2 = this.mFirstPosition + i;
        if (i2 >= 0) {
            ExpandableHListConnector.b Cg = this.ksm.Cg(eB(i2));
            if (Cg.ksk.type == 1 || (Cg.isExpanded() && Cg.ksl.bIj != Cg.ksl.bIi)) {
                Drawable drawable = this.bII;
                drawable.setBounds(rect);
                drawable.draw(canvas);
                Cg.recycle();
                return;
            }
            Cg.recycle();
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
        this.bIv = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.ksm = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.ksm = null;
        }
        super.setAdapter((ListAdapter) this.ksm);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.bIv;
    }

    private boolean isHeaderOrFooterPosition(int i) {
        return i < getHeaderViewsCount() || i >= this.mItemCount - getFooterViewsCount();
    }

    private int eB(int i) {
        return i - getHeaderViewsCount();
    }

    private int eC(int i) {
        return getHeaderViewsCount() + i;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.AdapterView
    public boolean performItemClick(View view, int i, long j) {
        if (isHeaderOrFooterPosition(i)) {
            return super.performItemClick(view, i, j);
        }
        return b(view, eB(i), j);
    }

    boolean b(View view, int i, long j) {
        boolean z;
        ExpandableHListConnector.b Cg = this.ksm.Cg(i);
        long b2 = b(Cg.ksk);
        if (Cg.ksk.type == 2) {
            if (this.ksp != null && this.ksp.a(this, view, Cg.ksk.bIr, b2)) {
                Cg.recycle();
                return true;
            }
            if (Cg.isExpanded()) {
                this.ksm.a(Cg);
                playSoundEffect(0);
                if (this.ksn != null) {
                    this.ksn.eE(Cg.ksk.bIr);
                }
            } else {
                this.ksm.b(Cg);
                playSoundEffect(0);
                if (this.kso != null) {
                    this.kso.eF(Cg.ksk.bIr);
                }
                int i2 = Cg.ksk.bIr;
                int headerViewsCount = Cg.ksk.bIt + getHeaderViewsCount();
                smoothScrollToPosition(this.bIv.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.ksq != null) {
            playSoundEffect(0);
            return this.ksq.a(this, view, Cg.ksk.bIr, Cg.ksk.bIs, b2);
        } else {
            z = false;
        }
        Cg.recycle();
        return z;
    }

    public void setOnGroupCollapseListener(d dVar) {
        this.ksn = dVar;
    }

    public void setOnGroupExpandListener(e eVar) {
        this.kso = eVar;
    }

    public void setOnGroupClickListener(c cVar) {
        this.ksp = cVar;
    }

    public void setOnChildClickListener(b bVar) {
        this.ksq = bVar;
    }

    public long eD(int i) {
        if (isHeaderOrFooterPosition(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b Cg = this.ksm.Cg(eB(i));
        long TR = Cg.ksk.TR();
        Cg.recycle();
        return TR;
    }

    public long getSelectedPosition() {
        return eD(getSelectedItemPosition());
    }

    public long getSelectedId() {
        long selectedPosition = getSelectedPosition();
        if (selectedPosition == 4294967295L) {
            return -1L;
        }
        int bu = bu(selectedPosition);
        if (bt(selectedPosition) == 0) {
            return this.bIv.getGroupId(bu);
        }
        return this.bIv.getChildId(bu, bv(selectedPosition));
    }

    public void setSelectedGroup(int i) {
        com.baidu.tieba.horizonalList.widget.a Ci = com.baidu.tieba.horizonalList.widget.a.Ci(i);
        ExpandableHListConnector.b a2 = this.ksm.a(Ci);
        Ci.recycle();
        super.setSelection(eC(a2.ksk.bIt));
        a2.recycle();
    }

    public static int bt(long j) {
        if (j == 4294967295L) {
            return 2;
        }
        return (j & Long.MIN_VALUE) == Long.MIN_VALUE ? 1 : 0;
    }

    public static int bu(long j) {
        if (j == 4294967295L) {
            return -1;
        }
        return (int) ((9223372032559808512L & j) >> 32);
    }

    public static int bv(long j) {
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
        ExpandableHListConnector.b Cg = this.ksm.Cg(eB(i));
        com.baidu.tieba.horizonalList.widget.a aVar = Cg.ksk;
        long b2 = b(aVar);
        long TR = aVar.TR();
        Cg.recycle();
        return new a(view, TR, b2);
    }

    private long b(com.baidu.tieba.horizonalList.widget.a aVar) {
        return aVar.type == 1 ? this.bIv.getChildId(aVar.bIr, aVar.bIs) : this.bIv.getGroupId(aVar.bIr);
    }

    public void setChildIndicator(Drawable drawable) {
        this.bIC = drawable;
        TU();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.bIB = drawable;
        TT();
    }

    /* loaded from: classes.dex */
    public static class a implements ContextMenu.ContextMenuInfo {
        public long bIS;
        public long id;
        public View targetView;

        public a(View view, long j, long j2) {
            this.targetView = view;
            this.bIS = j;
            this.id = j2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.tieba.horizonalList.widget.ExpandableHListView.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: ad */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: Cj */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        ArrayList<ExpandableHListConnector.GroupMetadata> bIT;

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.bIT = arrayList;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.bIT = new ArrayList<>();
            parcel.readList(this.bIT, ExpandableHListConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.bIT);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.ksm != null ? this.ksm.TO() : null);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.ksm != null && savedState.bIT != null) {
            this.ksm.k(savedState.bIT);
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
