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
    private static final int[] aTT = {16842920};
    private static final int[] aTU = {16842921};
    private static final int[] aTV = {16842920, 16842921};
    private static final int[][] aTW = {EMPTY_STATE_SET, aTT, aTU, aTV};
    private static final int[] aTX = {16842918};
    private ExpandableListAdapter aTL;
    private int aTM;
    private int aTN;
    private int aTO;
    private int aTP;
    private int aTQ;
    private Drawable aTR;
    private Drawable aTS;
    private Drawable aTY;
    private final Rect aTZ;
    private int aUa;
    private int aUb;
    private int aUc;
    private int aUd;
    private ExpandableHListConnector hVj;
    private d hVk;
    private e hVl;
    private c hVm;
    private b hVn;
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
        void cQ(int i);
    }

    /* loaded from: classes.dex */
    public interface e {
        void cR(int i);
    }

    public ExpandableHListView(Context context) {
        this(context, null);
    }

    public ExpandableHListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.hlv_expandableListViewStyle);
    }

    public ExpandableHListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aTZ = new Rect();
        this.mTempRect = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandableHListView, i, 0);
        setGroupIndicator(obtainStyledAttributes.getDrawable(5));
        setChildIndicator(obtainStyledAttributes.getDrawable(1));
        this.mIndicatorLeft = obtainStyledAttributes.getDimensionPixelSize(7, 0);
        this.aTM = obtainStyledAttributes.getDimensionPixelSize(8, 0);
        this.aTN = obtainStyledAttributes.getInt(2, 0);
        this.aTO = obtainStyledAttributes.getInt(3, 0);
        this.aTQ = obtainStyledAttributes.getDimensionPixelSize(6, 0);
        this.aTP = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.aTY = obtainStyledAttributes.getDrawable(4);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        EW();
        EX();
    }

    private void EW() {
        if (this.aTR != null) {
            this.aUa = this.aTR.getIntrinsicWidth();
            this.aUb = this.aTR.getIntrinsicHeight();
            return;
        }
        this.aUa = 0;
        this.aUb = 0;
    }

    private void EX() {
        if (this.aTS != null) {
            this.aUc = this.aTS.getIntrinsicWidth();
            this.aUd = this.aTS.getIntrinsicHeight();
            return;
        }
        this.aUc = 0;
        this.aUd = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.aTS != null || this.aTR != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.mItemCount - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            Rect rect = this.aTZ;
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
                            ExpandableHListConnector.b wd = this.hVj.wd(i4);
                            if (wd.hVh.type != i2) {
                                if (wd.hVh.type == 1) {
                                    rect.top = childAt.getTop() + this.aTP;
                                    rect.bottom = childAt.getBottom() + this.aTP;
                                } else {
                                    rect.top = childAt.getTop() + this.aTM;
                                    rect.bottom = childAt.getBottom() + this.aTM;
                                }
                                i2 = wd.hVh.type;
                            }
                            if (rect.top != rect.bottom) {
                                if (wd.hVh.type == 1) {
                                    rect.left = this.aTQ + left;
                                    rect.right = this.aTQ + right2;
                                } else {
                                    rect.left = this.mIndicatorLeft + left;
                                    rect.right = this.mIndicatorLeft + right2;
                                }
                                Drawable c2 = c(wd);
                                if (c2 != null) {
                                    if (wd.hVh.type == 1) {
                                        Gravity.apply(this.aTO, this.aUc, this.aUd, rect, this.mTempRect);
                                    } else {
                                        Gravity.apply(this.aTN, this.aUa, this.aUb, rect, this.mTempRect);
                                    }
                                    c2.setBounds(this.mTempRect);
                                    c2.draw(canvas);
                                }
                            }
                            wd.recycle();
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
        if (bVar.hVh.type == 2) {
            Drawable drawable = this.aTR;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            drawable.setState(aTW[(bVar.ET() ? (char) 1 : (char) 0) | (bVar.hVi == null || bVar.hVi.aTz == bVar.hVi.aTy ? (char) 2 : (char) 0)]);
            return drawable;
        }
        Drawable drawable2 = this.aTS;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(bVar.hVh.aTJ == bVar.hVi.aTz ? aTX : EMPTY_STATE_SET);
        }
        return drawable2;
    }

    public void setChildDivider(Drawable drawable) {
        this.aTY = drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tieba.horizonalList.widget.HListView
    public void drawDivider(Canvas canvas, Rect rect, int i) {
        int i2 = this.mFirstPosition + i;
        if (i2 >= 0) {
            ExpandableHListConnector.b wd = this.hVj.wd(cN(i2));
            if (wd.hVh.type == 1 || (wd.ET() && wd.hVi.aTz != wd.hVi.aTy)) {
                Drawable drawable = this.aTY;
                drawable.setBounds(rect);
                drawable.draw(canvas);
                wd.recycle();
                return;
            }
            wd.recycle();
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
        this.aTL = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.hVj = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.hVj = null;
        }
        super.setAdapter((ListAdapter) this.hVj);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.aTL;
    }

    private boolean isHeaderOrFooterPosition(int i) {
        return i < getHeaderViewsCount() || i >= this.mItemCount - getFooterViewsCount();
    }

    private int cN(int i) {
        return i - getHeaderViewsCount();
    }

    private int cO(int i) {
        return getHeaderViewsCount() + i;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.AdapterView
    public boolean performItemClick(View view, int i, long j) {
        if (isHeaderOrFooterPosition(i)) {
            return super.performItemClick(view, i, j);
        }
        return a(view, cN(i), j);
    }

    boolean a(View view, int i, long j) {
        boolean z;
        ExpandableHListConnector.b wd = this.hVj.wd(i);
        long b2 = b(wd.hVh);
        if (wd.hVh.type == 2) {
            if (this.hVm != null && this.hVm.a(this, view, wd.hVh.aTH, b2)) {
                wd.recycle();
                return true;
            }
            if (wd.ET()) {
                this.hVj.a(wd);
                playSoundEffect(0);
                if (this.hVk != null) {
                    this.hVk.cQ(wd.hVh.aTH);
                }
            } else {
                this.hVj.b(wd);
                playSoundEffect(0);
                if (this.hVl != null) {
                    this.hVl.cR(wd.hVh.aTH);
                }
                int i2 = wd.hVh.aTH;
                int headerViewsCount = wd.hVh.aTJ + getHeaderViewsCount();
                smoothScrollToPosition(this.aTL.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.hVn != null) {
            playSoundEffect(0);
            return this.hVn.a(this, view, wd.hVh.aTH, wd.hVh.aTI, b2);
        } else {
            z = false;
        }
        wd.recycle();
        return z;
    }

    public void setOnGroupCollapseListener(d dVar) {
        this.hVk = dVar;
    }

    public void setOnGroupExpandListener(e eVar) {
        this.hVl = eVar;
    }

    public void setOnGroupClickListener(c cVar) {
        this.hVm = cVar;
    }

    public void setOnChildClickListener(b bVar) {
        this.hVn = bVar;
    }

    public long cP(int i) {
        if (isHeaderOrFooterPosition(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b wd = this.hVj.wd(cN(i));
        long EU = wd.hVh.EU();
        wd.recycle();
        return EU;
    }

    public long getSelectedPosition() {
        return cP(getSelectedItemPosition());
    }

    public long getSelectedId() {
        long selectedPosition = getSelectedPosition();
        if (selectedPosition == 4294967295L) {
            return -1L;
        }
        int am = am(selectedPosition);
        if (al(selectedPosition) == 0) {
            return this.aTL.getGroupId(am);
        }
        return this.aTL.getChildId(am, an(selectedPosition));
    }

    public void setSelectedGroup(int i) {
        com.baidu.tieba.horizonalList.widget.a wf = com.baidu.tieba.horizonalList.widget.a.wf(i);
        ExpandableHListConnector.b a2 = this.hVj.a(wf);
        wf.recycle();
        super.setSelection(cO(a2.hVh.aTJ));
        a2.recycle();
    }

    public static int al(long j) {
        if (j == 4294967295L) {
            return 2;
        }
        return (j & Long.MIN_VALUE) == Long.MIN_VALUE ? 1 : 0;
    }

    public static int am(long j) {
        if (j == 4294967295L) {
            return -1;
        }
        return (int) ((9223372032559808512L & j) >> 32);
    }

    public static int an(long j) {
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
        ExpandableHListConnector.b wd = this.hVj.wd(cN(i));
        com.baidu.tieba.horizonalList.widget.a aVar = wd.hVh;
        long b2 = b(aVar);
        long EU = aVar.EU();
        wd.recycle();
        return new a(view, EU, b2);
    }

    private long b(com.baidu.tieba.horizonalList.widget.a aVar) {
        return aVar.type == 1 ? this.aTL.getChildId(aVar.aTH, aVar.aTI) : this.aTL.getGroupId(aVar.aTH);
    }

    public void setChildIndicator(Drawable drawable) {
        this.aTS = drawable;
        EX();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.aTR = drawable;
        EW();
    }

    /* loaded from: classes.dex */
    public static class a implements ContextMenu.ContextMenuInfo {
        public long aUi;
        public long id;
        public View targetView;

        public a(View view, long j, long j2) {
            this.targetView = view;
            this.aUi = j;
            this.id = j2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.tieba.horizonalList.widget.ExpandableHListView.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: W */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: wg */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        ArrayList<ExpandableHListConnector.GroupMetadata> aUj;

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.aUj = arrayList;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.aUj = new ArrayList<>();
            parcel.readList(this.aUj, ExpandableHListConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.aUj);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.hVj != null ? this.hVj.ER() : null);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.hVj != null && savedState.aUj != null) {
            this.hVj.k(savedState.aUj);
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
