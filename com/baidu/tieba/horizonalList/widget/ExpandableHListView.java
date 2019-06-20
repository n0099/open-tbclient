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
import com.baidu.tieba.c;
import com.baidu.tieba.horizonalList.widget.AdapterView;
import com.baidu.tieba.horizonalList.widget.ExpandableHListConnector;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ExpandableHListView extends HListView {
    private static final int[] EMPTY_STATE_SET = new int[0];
    private static final int[] gjt = {16842920};
    private static final int[] gju = {16842921};
    private static final int[] gjv = {16842920, 16842921};
    private static final int[][] gjw = {EMPTY_STATE_SET, gjt, gju, gjv};
    private static final int[] gjx = {16842918};
    private int gjA;
    private int gjB;
    private int gjC;
    private int gjD;
    private d gjE;
    private e gjF;
    private c gjG;
    private b gjH;
    private ExpandableHListConnector gjk;
    private ExpandableListAdapter gjl;
    private int gjm;
    private int gjn;
    private int gjo;
    private int gjp;
    private int gjq;
    private Drawable gjr;
    private Drawable gjs;
    private Drawable gjy;
    private final Rect gjz;
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
        this(context, attributeSet, R.attr.hlv_expandableListViewStyle);
    }

    public ExpandableHListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gjz = new Rect();
        this.mTempRect = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.a.ExpandableHListView, i, 0);
        setGroupIndicator(obtainStyledAttributes.getDrawable(5));
        setChildIndicator(obtainStyledAttributes.getDrawable(1));
        this.mIndicatorLeft = obtainStyledAttributes.getDimensionPixelSize(7, 0);
        this.gjm = obtainStyledAttributes.getDimensionPixelSize(8, 0);
        this.gjn = obtainStyledAttributes.getInt(2, 0);
        this.gjo = obtainStyledAttributes.getInt(3, 0);
        this.gjq = obtainStyledAttributes.getDimensionPixelSize(6, 0);
        this.gjp = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.gjy = obtainStyledAttributes.getDrawable(4);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        bvn();
        bvo();
    }

    private void bvn() {
        if (this.gjr != null) {
            this.gjA = this.gjr.getIntrinsicWidth();
            this.gjB = this.gjr.getIntrinsicHeight();
            return;
        }
        this.gjA = 0;
        this.gjB = 0;
    }

    private void bvo() {
        if (this.gjs != null) {
            this.gjC = this.gjs.getIntrinsicWidth();
            this.gjD = this.gjs.getIntrinsicHeight();
            return;
        }
        this.gjC = 0;
        this.gjD = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.gjs != null || this.gjr != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.mItemCount - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            Rect rect = this.gjz;
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
                            ExpandableHListConnector.b tT = this.gjk.tT(i4);
                            if (tT.gje.type != i2) {
                                if (tT.gje.type == 1) {
                                    rect.top = childAt.getTop() + this.gjp;
                                    rect.bottom = childAt.getBottom() + this.gjp;
                                } else {
                                    rect.top = childAt.getTop() + this.gjm;
                                    rect.bottom = childAt.getBottom() + this.gjm;
                                }
                                i2 = tT.gje.type;
                            }
                            if (rect.top != rect.bottom) {
                                if (tT.gje.type == 1) {
                                    rect.left = this.gjq + left;
                                    rect.right = this.gjq + right2;
                                } else {
                                    rect.left = this.mIndicatorLeft + left;
                                    rect.right = this.mIndicatorLeft + right2;
                                }
                                Drawable c2 = c(tT);
                                if (c2 != null) {
                                    if (tT.gje.type == 1) {
                                        Gravity.apply(this.gjo, this.gjC, this.gjD, rect, this.mTempRect);
                                    } else {
                                        Gravity.apply(this.gjn, this.gjA, this.gjB, rect, this.mTempRect);
                                    }
                                    c2.setBounds(this.mTempRect);
                                    c2.draw(canvas);
                                }
                            }
                            tT.recycle();
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
        if (bVar.gje.type == 2) {
            Drawable drawable = this.gjr;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            drawable.setState(gjw[(bVar.bhk() ? (char) 1 : (char) 0) | (bVar.gjf == null || bVar.gjf.giZ == bVar.gjf.giY ? (char) 2 : (char) 0)]);
            return drawable;
        }
        Drawable drawable2 = this.gjs;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(bVar.gje.gjj == bVar.gjf.giZ ? gjx : EMPTY_STATE_SET);
        }
        return drawable2;
    }

    public void setChildDivider(Drawable drawable) {
        this.gjy = drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tieba.horizonalList.widget.HListView
    public void drawDivider(Canvas canvas, Rect rect, int i) {
        int i2 = this.mFirstPosition + i;
        if (i2 >= 0) {
            ExpandableHListConnector.b tT = this.gjk.tT(tW(i2));
            if (tT.gje.type == 1 || (tT.bhk() && tT.gjf.giZ != tT.gjf.giY)) {
                Drawable drawable = this.gjy;
                drawable.setBounds(rect);
                drawable.draw(canvas);
                tT.recycle();
                return;
            }
            tT.recycle();
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
        this.gjl = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.gjk = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.gjk = null;
        }
        super.setAdapter((ListAdapter) this.gjk);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.gjl;
    }

    private boolean isHeaderOrFooterPosition(int i) {
        return i < getHeaderViewsCount() || i >= this.mItemCount - getFooterViewsCount();
    }

    private int tW(int i) {
        return i - getHeaderViewsCount();
    }

    private int tX(int i) {
        return getHeaderViewsCount() + i;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.AdapterView
    public boolean performItemClick(View view, int i, long j) {
        if (isHeaderOrFooterPosition(i)) {
            return super.performItemClick(view, i, j);
        }
        return d(view, tW(i), j);
    }

    boolean d(View view, int i, long j) {
        boolean z;
        ExpandableHListConnector.b tT = this.gjk.tT(i);
        long b2 = b(tT.gje);
        if (tT.gje.type == 2) {
            if (this.gjG != null && this.gjG.a(this, view, tT.gje.gjh, b2)) {
                tT.recycle();
                return true;
            }
            if (tT.bhk()) {
                this.gjk.a(tT);
                playSoundEffect(0);
                if (this.gjE != null) {
                    this.gjE.onGroupCollapse(tT.gje.gjh);
                }
            } else {
                this.gjk.b(tT);
                playSoundEffect(0);
                if (this.gjF != null) {
                    this.gjF.onGroupExpand(tT.gje.gjh);
                }
                int i2 = tT.gje.gjh;
                int headerViewsCount = tT.gje.gjj + getHeaderViewsCount();
                smoothScrollToPosition(this.gjl.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.gjH != null) {
            playSoundEffect(0);
            return this.gjH.a(this, view, tT.gje.gjh, tT.gje.gji, b2);
        } else {
            z = false;
        }
        tT.recycle();
        return z;
    }

    public void setOnGroupCollapseListener(d dVar) {
        this.gjE = dVar;
    }

    public void setOnGroupExpandListener(e eVar) {
        this.gjF = eVar;
    }

    public void setOnGroupClickListener(c cVar) {
        this.gjG = cVar;
    }

    public void setOnChildClickListener(b bVar) {
        this.gjH = bVar;
    }

    public long getExpandableListPosition(int i) {
        if (isHeaderOrFooterPosition(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b tT = this.gjk.tT(tW(i));
        long bvl = tT.gje.bvl();
        tT.recycle();
        return bvl;
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
            return this.gjl.getGroupId(packedPositionGroup);
        }
        return this.gjl.getChildId(packedPositionGroup, getPackedPositionChild(selectedPosition));
    }

    public void setSelectedGroup(int i) {
        com.baidu.tieba.horizonalList.widget.a tV = com.baidu.tieba.horizonalList.widget.a.tV(i);
        ExpandableHListConnector.b a2 = this.gjk.a(tV);
        tV.recycle();
        super.setSelection(tX(a2.gje.gjj));
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
        ExpandableHListConnector.b tT = this.gjk.tT(tW(i));
        com.baidu.tieba.horizonalList.widget.a aVar = tT.gje;
        long b2 = b(aVar);
        long bvl = aVar.bvl();
        tT.recycle();
        return new a(view, bvl, b2);
    }

    private long b(com.baidu.tieba.horizonalList.widget.a aVar) {
        return aVar.type == 1 ? this.gjl.getChildId(aVar.gjh, aVar.gji) : this.gjl.getGroupId(aVar.gjh);
    }

    public void setChildIndicator(Drawable drawable) {
        this.gjs = drawable;
        bvo();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.gjr = drawable;
        bvn();
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
            /* renamed from: N */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: tY */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        ArrayList<ExpandableHListConnector.GroupMetadata> gjI;

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.gjI = arrayList;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.gjI = new ArrayList<>();
            parcel.readList(this.gjI, ExpandableHListConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.gjI);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.gjk != null ? this.gjk.bvj() : null);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.gjk != null && savedState.gjI != null) {
            this.gjk.af(savedState.gjI);
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
