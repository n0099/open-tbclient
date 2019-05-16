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
    private static final int[] gjq = {16842920};
    private static final int[] gjr = {16842921};
    private static final int[] gjs = {16842920, 16842921};
    private static final int[][] gjt = {EMPTY_STATE_SET, gjq, gjr, gjs};
    private static final int[] gju = {16842918};
    private int gjA;
    private d gjB;
    private e gjC;
    private c gjD;
    private b gjE;
    private ExpandableHListConnector gjh;
    private ExpandableListAdapter gji;
    private int gjj;
    private int gjk;
    private int gjl;
    private int gjm;
    private int gjn;
    private Drawable gjo;
    private Drawable gjp;
    private Drawable gjv;
    private final Rect gjw;
    private int gjx;
    private int gjy;
    private int gjz;
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
        this.gjw = new Rect();
        this.mTempRect = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.a.ExpandableHListView, i, 0);
        setGroupIndicator(obtainStyledAttributes.getDrawable(5));
        setChildIndicator(obtainStyledAttributes.getDrawable(1));
        this.mIndicatorLeft = obtainStyledAttributes.getDimensionPixelSize(7, 0);
        this.gjj = obtainStyledAttributes.getDimensionPixelSize(8, 0);
        this.gjk = obtainStyledAttributes.getInt(2, 0);
        this.gjl = obtainStyledAttributes.getInt(3, 0);
        this.gjn = obtainStyledAttributes.getDimensionPixelSize(6, 0);
        this.gjm = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.gjv = obtainStyledAttributes.getDrawable(4);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        bvj();
        bvk();
    }

    private void bvj() {
        if (this.gjo != null) {
            this.gjx = this.gjo.getIntrinsicWidth();
            this.gjy = this.gjo.getIntrinsicHeight();
            return;
        }
        this.gjx = 0;
        this.gjy = 0;
    }

    private void bvk() {
        if (this.gjp != null) {
            this.gjz = this.gjp.getIntrinsicWidth();
            this.gjA = this.gjp.getIntrinsicHeight();
            return;
        }
        this.gjz = 0;
        this.gjA = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.gjp != null || this.gjo != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.mItemCount - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            Rect rect = this.gjw;
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
                            ExpandableHListConnector.b tT = this.gjh.tT(i4);
                            if (tT.gjb.type != i2) {
                                if (tT.gjb.type == 1) {
                                    rect.top = childAt.getTop() + this.gjm;
                                    rect.bottom = childAt.getBottom() + this.gjm;
                                } else {
                                    rect.top = childAt.getTop() + this.gjj;
                                    rect.bottom = childAt.getBottom() + this.gjj;
                                }
                                i2 = tT.gjb.type;
                            }
                            if (rect.top != rect.bottom) {
                                if (tT.gjb.type == 1) {
                                    rect.left = this.gjn + left;
                                    rect.right = this.gjn + right2;
                                } else {
                                    rect.left = this.mIndicatorLeft + left;
                                    rect.right = this.mIndicatorLeft + right2;
                                }
                                Drawable c2 = c(tT);
                                if (c2 != null) {
                                    if (tT.gjb.type == 1) {
                                        Gravity.apply(this.gjl, this.gjz, this.gjA, rect, this.mTempRect);
                                    } else {
                                        Gravity.apply(this.gjk, this.gjx, this.gjy, rect, this.mTempRect);
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
        if (bVar.gjb.type == 2) {
            Drawable drawable = this.gjo;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            drawable.setState(gjt[(bVar.bhh() ? (char) 1 : (char) 0) | (bVar.gjc == null || bVar.gjc.giW == bVar.gjc.giV ? (char) 2 : (char) 0)]);
            return drawable;
        }
        Drawable drawable2 = this.gjp;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(bVar.gjb.gjg == bVar.gjc.giW ? gju : EMPTY_STATE_SET);
        }
        return drawable2;
    }

    public void setChildDivider(Drawable drawable) {
        this.gjv = drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tieba.horizonalList.widget.HListView
    public void drawDivider(Canvas canvas, Rect rect, int i) {
        int i2 = this.mFirstPosition + i;
        if (i2 >= 0) {
            ExpandableHListConnector.b tT = this.gjh.tT(tW(i2));
            if (tT.gjb.type == 1 || (tT.bhh() && tT.gjc.giW != tT.gjc.giV)) {
                Drawable drawable = this.gjv;
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
        this.gji = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.gjh = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.gjh = null;
        }
        super.setAdapter((ListAdapter) this.gjh);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.gji;
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
        ExpandableHListConnector.b tT = this.gjh.tT(i);
        long b2 = b(tT.gjb);
        if (tT.gjb.type == 2) {
            if (this.gjD != null && this.gjD.a(this, view, tT.gjb.gje, b2)) {
                tT.recycle();
                return true;
            }
            if (tT.bhh()) {
                this.gjh.a(tT);
                playSoundEffect(0);
                if (this.gjB != null) {
                    this.gjB.onGroupCollapse(tT.gjb.gje);
                }
            } else {
                this.gjh.b(tT);
                playSoundEffect(0);
                if (this.gjC != null) {
                    this.gjC.onGroupExpand(tT.gjb.gje);
                }
                int i2 = tT.gjb.gje;
                int headerViewsCount = tT.gjb.gjg + getHeaderViewsCount();
                smoothScrollToPosition(this.gji.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.gjE != null) {
            playSoundEffect(0);
            return this.gjE.a(this, view, tT.gjb.gje, tT.gjb.gjf, b2);
        } else {
            z = false;
        }
        tT.recycle();
        return z;
    }

    public void setOnGroupCollapseListener(d dVar) {
        this.gjB = dVar;
    }

    public void setOnGroupExpandListener(e eVar) {
        this.gjC = eVar;
    }

    public void setOnGroupClickListener(c cVar) {
        this.gjD = cVar;
    }

    public void setOnChildClickListener(b bVar) {
        this.gjE = bVar;
    }

    public long getExpandableListPosition(int i) {
        if (isHeaderOrFooterPosition(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b tT = this.gjh.tT(tW(i));
        long bvh = tT.gjb.bvh();
        tT.recycle();
        return bvh;
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
            return this.gji.getGroupId(packedPositionGroup);
        }
        return this.gji.getChildId(packedPositionGroup, getPackedPositionChild(selectedPosition));
    }

    public void setSelectedGroup(int i) {
        com.baidu.tieba.horizonalList.widget.a tV = com.baidu.tieba.horizonalList.widget.a.tV(i);
        ExpandableHListConnector.b a2 = this.gjh.a(tV);
        tV.recycle();
        super.setSelection(tX(a2.gjb.gjg));
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
        ExpandableHListConnector.b tT = this.gjh.tT(tW(i));
        com.baidu.tieba.horizonalList.widget.a aVar = tT.gjb;
        long b2 = b(aVar);
        long bvh = aVar.bvh();
        tT.recycle();
        return new a(view, bvh, b2);
    }

    private long b(com.baidu.tieba.horizonalList.widget.a aVar) {
        return aVar.type == 1 ? this.gji.getChildId(aVar.gje, aVar.gjf) : this.gji.getGroupId(aVar.gje);
    }

    public void setChildIndicator(Drawable drawable) {
        this.gjp = drawable;
        bvk();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.gjo = drawable;
        bvj();
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
        ArrayList<ExpandableHListConnector.GroupMetadata> gjF;

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.gjF = arrayList;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.gjF = new ArrayList<>();
            parcel.readList(this.gjF, ExpandableHListConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.gjF);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.gjh != null ? this.gjh.bvf() : null);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.gjh != null && savedState.gjF != null) {
            this.gjh.af(savedState.gjF);
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
