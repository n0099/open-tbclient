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
    private static final int[] eqq = {16842920};
    private static final int[] eqr = {16842921};
    private static final int[] eqs = {16842920, 16842921};
    private static final int[][] eqt = {EMPTY_STATE_SET, eqq, eqr, eqs};
    private static final int[] equ = {16842918};
    private int eqA;
    private d eqB;
    private e eqC;
    private c eqD;
    private b eqE;
    private ExpandableHListConnector eqh;
    private ExpandableListAdapter eqi;
    private int eqj;
    private int eqk;
    private int eql;
    private int eqm;
    private int eqn;
    private Drawable eqo;
    private Drawable eqp;
    private Drawable eqv;
    private final Rect eqw;
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
        this.eqw = new Rect();
        this.mTempRect = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.l.ExpandableHListView, i, 0);
        setGroupIndicator(obtainStyledAttributes.getDrawable(e.l.ExpandableHListView_hlv_groupIndicator));
        setChildIndicator(obtainStyledAttributes.getDrawable(e.l.ExpandableHListView_hlv_childIndicator));
        this.mIndicatorLeft = obtainStyledAttributes.getDimensionPixelSize(e.l.ExpandableHListView_hlv_indicatorPaddingLeft, 0);
        this.eqj = obtainStyledAttributes.getDimensionPixelSize(e.l.ExpandableHListView_hlv_indicatorPaddingTop, 0);
        this.eqk = obtainStyledAttributes.getInt(e.l.ExpandableHListView_hlv_indicatorGravity, 0);
        this.eql = obtainStyledAttributes.getInt(e.l.ExpandableHListView_hlv_childIndicatorGravity, 0);
        this.eqn = obtainStyledAttributes.getDimensionPixelSize(e.l.ExpandableHListView_hlv_childIndicatorPaddingLeft, 0);
        this.eqm = obtainStyledAttributes.getDimensionPixelSize(e.l.ExpandableHListView_hlv_childIndicatorPaddingTop, 0);
        this.eqv = obtainStyledAttributes.getDrawable(e.l.ExpandableHListView_hlv_childDivider);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        aKA();
        aKB();
    }

    private void aKA() {
        if (this.eqo != null) {
            this.eqx = this.eqo.getIntrinsicWidth();
            this.eqy = this.eqo.getIntrinsicHeight();
            return;
        }
        this.eqx = 0;
        this.eqy = 0;
    }

    private void aKB() {
        if (this.eqp != null) {
            this.eqz = this.eqp.getIntrinsicWidth();
            this.eqA = this.eqp.getIntrinsicHeight();
            return;
        }
        this.eqz = 0;
        this.eqA = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.eqp != null || this.eqo != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.mItemCount - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            Rect rect = this.eqw;
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
                            ExpandableHListConnector.b of = this.eqh.of(i4);
                            if (of.eqb.type != i2) {
                                if (of.eqb.type == 1) {
                                    rect.top = childAt.getTop() + this.eqm;
                                    rect.bottom = childAt.getBottom() + this.eqm;
                                } else {
                                    rect.top = childAt.getTop() + this.eqj;
                                    rect.bottom = childAt.getBottom() + this.eqj;
                                }
                                i2 = of.eqb.type;
                            }
                            if (rect.top != rect.bottom) {
                                if (of.eqb.type == 1) {
                                    rect.left = this.eqn + left;
                                    rect.right = this.eqn + right2;
                                } else {
                                    rect.left = this.mIndicatorLeft + left;
                                    rect.right = this.mIndicatorLeft + right2;
                                }
                                Drawable c2 = c(of);
                                if (c2 != null) {
                                    if (of.eqb.type == 1) {
                                        Gravity.apply(this.eql, this.eqz, this.eqA, rect, this.mTempRect);
                                    } else {
                                        Gravity.apply(this.eqk, this.eqx, this.eqy, rect, this.mTempRect);
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
        if (bVar.eqb.type == 2) {
            Drawable drawable = this.eqo;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            drawable.setState(eqt[(bVar.awW() ? (char) 1 : (char) 0) | (bVar.eqc == null || bVar.eqc.epW == bVar.eqc.epV ? (char) 2 : (char) 0)]);
            return drawable;
        }
        Drawable drawable2 = this.eqp;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(bVar.eqb.eqg == bVar.eqc.epW ? equ : EMPTY_STATE_SET);
        }
        return drawable2;
    }

    public void setChildDivider(Drawable drawable) {
        this.eqv = drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tieba.horizonalList.widget.HListView
    public void drawDivider(Canvas canvas, Rect rect, int i) {
        int i2 = this.mFirstPosition + i;
        if (i2 >= 0) {
            ExpandableHListConnector.b of = this.eqh.of(oi(i2));
            if (of.eqb.type == 1 || (of.awW() && of.eqc.epW != of.eqc.epV)) {
                Drawable drawable = this.eqv;
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
        this.eqi = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.eqh = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.eqh = null;
        }
        super.setAdapter((ListAdapter) this.eqh);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.eqi;
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
        ExpandableHListConnector.b of = this.eqh.of(i);
        long b2 = b(of.eqb);
        if (of.eqb.type == 2) {
            if (this.eqD != null && this.eqD.a(this, view, of.eqb.eqe, b2)) {
                of.recycle();
                return true;
            }
            if (of.awW()) {
                this.eqh.a(of);
                playSoundEffect(0);
                if (this.eqB != null) {
                    this.eqB.onGroupCollapse(of.eqb.eqe);
                }
            } else {
                this.eqh.b(of);
                playSoundEffect(0);
                if (this.eqC != null) {
                    this.eqC.onGroupExpand(of.eqb.eqe);
                }
                int i2 = of.eqb.eqe;
                int headerViewsCount = of.eqb.eqg + getHeaderViewsCount();
                smoothScrollToPosition(this.eqi.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.eqE != null) {
            playSoundEffect(0);
            return this.eqE.a(this, view, of.eqb.eqe, of.eqb.eqf, b2);
        } else {
            z = false;
        }
        of.recycle();
        return z;
    }

    public void setOnGroupCollapseListener(d dVar) {
        this.eqB = dVar;
    }

    public void setOnGroupExpandListener(e eVar) {
        this.eqC = eVar;
    }

    public void setOnGroupClickListener(c cVar) {
        this.eqD = cVar;
    }

    public void setOnChildClickListener(b bVar) {
        this.eqE = bVar;
    }

    public long getExpandableListPosition(int i) {
        if (isHeaderOrFooterPosition(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b of = this.eqh.of(oi(i));
        long aKy = of.eqb.aKy();
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
            return this.eqi.getGroupId(packedPositionGroup);
        }
        return this.eqi.getChildId(packedPositionGroup, getPackedPositionChild(selectedPosition));
    }

    public void setSelectedGroup(int i) {
        com.baidu.tieba.horizonalList.widget.a oh = com.baidu.tieba.horizonalList.widget.a.oh(i);
        ExpandableHListConnector.b a2 = this.eqh.a(oh);
        oh.recycle();
        super.setSelection(oj(a2.eqb.eqg));
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
        ExpandableHListConnector.b of = this.eqh.of(oi(i));
        com.baidu.tieba.horizonalList.widget.a aVar = of.eqb;
        long b2 = b(aVar);
        long aKy = aVar.aKy();
        of.recycle();
        return new a(view, aKy, b2);
    }

    private long b(com.baidu.tieba.horizonalList.widget.a aVar) {
        return aVar.type == 1 ? this.eqi.getChildId(aVar.eqe, aVar.eqf) : this.eqi.getGroupId(aVar.eqe);
    }

    public void setChildIndicator(Drawable drawable) {
        this.eqp = drawable;
        aKB();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.eqo = drawable;
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
        ArrayList<ExpandableHListConnector.GroupMetadata> eqF;

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.eqF = arrayList;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.eqF = new ArrayList<>();
            parcel.readList(this.eqF, ExpandableHListConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.eqF);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.eqh != null ? this.eqh.aKw() : null);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.eqh != null && savedState.eqF != null) {
            this.eqh.Y(savedState.eqF);
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
