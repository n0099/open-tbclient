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
    private static final int[] eqp = {16842920};
    private static final int[] eqq = {16842921};
    private static final int[] eqr = {16842920, 16842921};
    private static final int[][] eqs = {EMPTY_STATE_SET, eqp, eqq, eqr};
    private static final int[] eqt = {16842918};
    private d eqA;
    private e eqB;
    private c eqC;
    private b eqD;
    private ExpandableHListConnector eqg;
    private ExpandableListAdapter eqh;
    private int eqi;
    private int eqj;
    private int eqk;
    private int eql;
    private int eqm;
    private Drawable eqn;
    private Drawable eqo;
    private Drawable equ;
    private final Rect eqv;
    private int eqw;
    private int eqx;
    private int eqy;
    private int eqz;
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
        this.eqv = new Rect();
        this.mTempRect = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.l.ExpandableHListView, i, 0);
        setGroupIndicator(obtainStyledAttributes.getDrawable(e.l.ExpandableHListView_hlv_groupIndicator));
        setChildIndicator(obtainStyledAttributes.getDrawable(e.l.ExpandableHListView_hlv_childIndicator));
        this.mIndicatorLeft = obtainStyledAttributes.getDimensionPixelSize(e.l.ExpandableHListView_hlv_indicatorPaddingLeft, 0);
        this.eqi = obtainStyledAttributes.getDimensionPixelSize(e.l.ExpandableHListView_hlv_indicatorPaddingTop, 0);
        this.eqj = obtainStyledAttributes.getInt(e.l.ExpandableHListView_hlv_indicatorGravity, 0);
        this.eqk = obtainStyledAttributes.getInt(e.l.ExpandableHListView_hlv_childIndicatorGravity, 0);
        this.eqm = obtainStyledAttributes.getDimensionPixelSize(e.l.ExpandableHListView_hlv_childIndicatorPaddingLeft, 0);
        this.eql = obtainStyledAttributes.getDimensionPixelSize(e.l.ExpandableHListView_hlv_childIndicatorPaddingTop, 0);
        this.equ = obtainStyledAttributes.getDrawable(e.l.ExpandableHListView_hlv_childDivider);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        aKA();
        aKB();
    }

    private void aKA() {
        if (this.eqn != null) {
            this.eqw = this.eqn.getIntrinsicWidth();
            this.eqx = this.eqn.getIntrinsicHeight();
            return;
        }
        this.eqw = 0;
        this.eqx = 0;
    }

    private void aKB() {
        if (this.eqo != null) {
            this.eqy = this.eqo.getIntrinsicWidth();
            this.eqz = this.eqo.getIntrinsicHeight();
            return;
        }
        this.eqy = 0;
        this.eqz = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.eqo != null || this.eqn != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.mItemCount - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            Rect rect = this.eqv;
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
                            ExpandableHListConnector.b of = this.eqg.of(i4);
                            if (of.eqa.type != i2) {
                                if (of.eqa.type == 1) {
                                    rect.top = childAt.getTop() + this.eql;
                                    rect.bottom = childAt.getBottom() + this.eql;
                                } else {
                                    rect.top = childAt.getTop() + this.eqi;
                                    rect.bottom = childAt.getBottom() + this.eqi;
                                }
                                i2 = of.eqa.type;
                            }
                            if (rect.top != rect.bottom) {
                                if (of.eqa.type == 1) {
                                    rect.left = this.eqm + left;
                                    rect.right = this.eqm + right2;
                                } else {
                                    rect.left = this.mIndicatorLeft + left;
                                    rect.right = this.mIndicatorLeft + right2;
                                }
                                Drawable c2 = c(of);
                                if (c2 != null) {
                                    if (of.eqa.type == 1) {
                                        Gravity.apply(this.eqk, this.eqy, this.eqz, rect, this.mTempRect);
                                    } else {
                                        Gravity.apply(this.eqj, this.eqw, this.eqx, rect, this.mTempRect);
                                    }
                                    c2.setBounds(this.mTempRect);
                                    c2.draw(canvas);
                                }
                            }
                            of.recycle();
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
        if (bVar.eqa.type == 2) {
            Drawable drawable = this.eqn;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            drawable.setState(eqs[(bVar.awV() ? (char) 1 : (char) 0) | (bVar.eqb == null || bVar.eqb.epV == bVar.eqb.epU ? (char) 2 : (char) 0)]);
            return drawable;
        }
        Drawable drawable2 = this.eqo;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(bVar.eqa.eqf == bVar.eqb.epV ? eqt : EMPTY_STATE_SET);
        }
        return drawable2;
    }

    public void setChildDivider(Drawable drawable) {
        this.equ = drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tieba.horizonalList.widget.HListView
    public void drawDivider(Canvas canvas, Rect rect, int i) {
        int i2 = this.mFirstPosition + i;
        if (i2 >= 0) {
            ExpandableHListConnector.b of = this.eqg.of(oi(i2));
            if (of.eqa.type == 1 || (of.awV() && of.eqb.epV != of.eqb.epU)) {
                Drawable drawable = this.equ;
                drawable.setBounds(rect);
                drawable.draw(canvas);
                of.recycle();
                return;
            }
            of.recycle();
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
        this.eqh = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.eqg = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.eqg = null;
        }
        super.setAdapter((ListAdapter) this.eqg);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.eqh;
    }

    private boolean isHeaderOrFooterPosition(int i) {
        return i < getHeaderViewsCount() || i >= this.mItemCount - getFooterViewsCount();
    }

    private int oi(int i) {
        return i - getHeaderViewsCount();
    }

    private int oj(int i) {
        return getHeaderViewsCount() + i;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.AdapterView
    public boolean performItemClick(View view, int i, long j) {
        if (isHeaderOrFooterPosition(i)) {
            return super.performItemClick(view, i, j);
        }
        return b(view, oi(i), j);
    }

    boolean b(View view, int i, long j) {
        boolean z;
        ExpandableHListConnector.b of = this.eqg.of(i);
        long b2 = b(of.eqa);
        if (of.eqa.type == 2) {
            if (this.eqC != null && this.eqC.a(this, view, of.eqa.eqd, b2)) {
                of.recycle();
                return true;
            }
            if (of.awV()) {
                this.eqg.a(of);
                playSoundEffect(0);
                if (this.eqA != null) {
                    this.eqA.onGroupCollapse(of.eqa.eqd);
                }
            } else {
                this.eqg.b(of);
                playSoundEffect(0);
                if (this.eqB != null) {
                    this.eqB.onGroupExpand(of.eqa.eqd);
                }
                int i2 = of.eqa.eqd;
                int headerViewsCount = of.eqa.eqf + getHeaderViewsCount();
                smoothScrollToPosition(this.eqh.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.eqD != null) {
            playSoundEffect(0);
            return this.eqD.a(this, view, of.eqa.eqd, of.eqa.eqe, b2);
        } else {
            z = false;
        }
        of.recycle();
        return z;
    }

    public void setOnGroupCollapseListener(d dVar) {
        this.eqA = dVar;
    }

    public void setOnGroupExpandListener(e eVar) {
        this.eqB = eVar;
    }

    public void setOnGroupClickListener(c cVar) {
        this.eqC = cVar;
    }

    public void setOnChildClickListener(b bVar) {
        this.eqD = bVar;
    }

    public long getExpandableListPosition(int i) {
        if (isHeaderOrFooterPosition(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b of = this.eqg.of(oi(i));
        long aKy = of.eqa.aKy();
        of.recycle();
        return aKy;
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
            return this.eqh.getGroupId(packedPositionGroup);
        }
        return this.eqh.getChildId(packedPositionGroup, getPackedPositionChild(selectedPosition));
    }

    public void setSelectedGroup(int i) {
        com.baidu.tieba.horizonalList.widget.a oh = com.baidu.tieba.horizonalList.widget.a.oh(i);
        ExpandableHListConnector.b a2 = this.eqg.a(oh);
        oh.recycle();
        super.setSelection(oj(a2.eqa.eqf));
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
        ExpandableHListConnector.b of = this.eqg.of(oi(i));
        com.baidu.tieba.horizonalList.widget.a aVar = of.eqa;
        long b2 = b(aVar);
        long aKy = aVar.aKy();
        of.recycle();
        return new a(view, aKy, b2);
    }

    private long b(com.baidu.tieba.horizonalList.widget.a aVar) {
        return aVar.type == 1 ? this.eqh.getChildId(aVar.eqd, aVar.eqe) : this.eqh.getGroupId(aVar.eqd);
    }

    public void setChildIndicator(Drawable drawable) {
        this.eqo = drawable;
        aKB();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.eqn = drawable;
        aKA();
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
            /* renamed from: ok */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        ArrayList<ExpandableHListConnector.GroupMetadata> eqE;

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.eqE = arrayList;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.eqE = new ArrayList<>();
            parcel.readList(this.eqE, ExpandableHListConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.eqE);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.eqg != null ? this.eqg.aKw() : null);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.eqg != null && savedState.eqE != null) {
            this.eqg.Y(savedState.eqE);
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
