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
    private static final int[] bvj = {16842920};
    private static final int[] bvk = {16842921};
    private static final int[] bvl = {16842920, 16842921};
    private static final int[][] bvm = {EMPTY_STATE_SET, bvj, bvk, bvl};
    private static final int[] bvn = {16842918};
    private ExpandableListAdapter bvb;
    private int bvc;
    private int bvd;
    private int bve;
    private int bvf;
    private int bvg;
    private Drawable bvh;
    private Drawable bvi;
    private Drawable bvo;
    private final Rect bvp;
    private int bvq;
    private int bvr;
    private int bvs;
    private int bvt;
    private ExpandableHListConnector jGX;
    private d jGY;
    private e jGZ;
    private c jHa;
    private b jHb;
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
        void fy(int i);
    }

    /* loaded from: classes.dex */
    public interface e {
        void fz(int i);
    }

    public ExpandableHListView(Context context) {
        this(context, null);
    }

    public ExpandableHListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.hlv_expandableListViewStyle);
    }

    public ExpandableHListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bvp = new Rect();
        this.mTempRect = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandableHListView, i, 0);
        setGroupIndicator(obtainStyledAttributes.getDrawable(R.styleable.ExpandableHListView_hlv_groupIndicator));
        setChildIndicator(obtainStyledAttributes.getDrawable(R.styleable.ExpandableHListView_hlv_childIndicator));
        this.mIndicatorLeft = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandableHListView_hlv_indicatorPaddingLeft, 0);
        this.bvc = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandableHListView_hlv_indicatorPaddingTop, 0);
        this.bvd = obtainStyledAttributes.getInt(R.styleable.ExpandableHListView_hlv_indicatorGravity, 0);
        this.bve = obtainStyledAttributes.getInt(R.styleable.ExpandableHListView_hlv_childIndicatorGravity, 0);
        this.bvg = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandableHListView_hlv_childIndicatorPaddingLeft, 0);
        this.bvf = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandableHListView_hlv_childIndicatorPaddingTop, 0);
        this.bvo = obtainStyledAttributes.getDrawable(R.styleable.ExpandableHListView_hlv_childDivider);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        QA();
        QB();
    }

    private void QA() {
        if (this.bvh != null) {
            this.bvq = this.bvh.getIntrinsicWidth();
            this.bvr = this.bvh.getIntrinsicHeight();
            return;
        }
        this.bvq = 0;
        this.bvr = 0;
    }

    private void QB() {
        if (this.bvi != null) {
            this.bvs = this.bvi.getIntrinsicWidth();
            this.bvt = this.bvi.getIntrinsicHeight();
            return;
        }
        this.bvs = 0;
        this.bvt = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.bvi != null || this.bvh != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.mItemCount - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            Rect rect = this.bvp;
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
                            ExpandableHListConnector.b BH = this.jGX.BH(i4);
                            if (BH.jGV.type != i2) {
                                if (BH.jGV.type == 1) {
                                    rect.top = childAt.getTop() + this.bvf;
                                    rect.bottom = childAt.getBottom() + this.bvf;
                                } else {
                                    rect.top = childAt.getTop() + this.bvc;
                                    rect.bottom = childAt.getBottom() + this.bvc;
                                }
                                i2 = BH.jGV.type;
                            }
                            if (rect.top != rect.bottom) {
                                if (BH.jGV.type == 1) {
                                    rect.left = this.bvg + left;
                                    rect.right = this.bvg + right2;
                                } else {
                                    rect.left = this.mIndicatorLeft + left;
                                    rect.right = this.mIndicatorLeft + right2;
                                }
                                Drawable c2 = c(BH);
                                if (c2 != null) {
                                    if (BH.jGV.type == 1) {
                                        Gravity.apply(this.bve, this.bvs, this.bvt, rect, this.mTempRect);
                                    } else {
                                        Gravity.apply(this.bvd, this.bvq, this.bvr, rect, this.mTempRect);
                                    }
                                    c2.setBounds(this.mTempRect);
                                    c2.draw(canvas);
                                }
                            }
                            BH.recycle();
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
        if (bVar.jGV.type == 2) {
            Drawable drawable = this.bvh;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            drawable.setState(bvm[(bVar.Qx() ? (char) 1 : (char) 0) | (bVar.jGW == null || bVar.jGW.buP == bVar.jGW.buO ? (char) 2 : (char) 0)]);
            return drawable;
        }
        Drawable drawable2 = this.bvi;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(bVar.jGV.buZ == bVar.jGW.buP ? bvn : EMPTY_STATE_SET);
        }
        return drawable2;
    }

    public void setChildDivider(Drawable drawable) {
        this.bvo = drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tieba.horizonalList.widget.HListView
    public void drawDivider(Canvas canvas, Rect rect, int i) {
        int i2 = this.mFirstPosition + i;
        if (i2 >= 0) {
            ExpandableHListConnector.b BH = this.jGX.BH(fv(i2));
            if (BH.jGV.type == 1 || (BH.Qx() && BH.jGW.buP != BH.jGW.buO)) {
                Drawable drawable = this.bvo;
                drawable.setBounds(rect);
                drawable.draw(canvas);
                BH.recycle();
                return;
            }
            BH.recycle();
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
        this.bvb = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.jGX = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.jGX = null;
        }
        super.setAdapter((ListAdapter) this.jGX);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.bvb;
    }

    private boolean isHeaderOrFooterPosition(int i) {
        return i < getHeaderViewsCount() || i >= this.mItemCount - getFooterViewsCount();
    }

    private int fv(int i) {
        return i - getHeaderViewsCount();
    }

    private int fw(int i) {
        return getHeaderViewsCount() + i;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.AdapterView
    public boolean performItemClick(View view, int i, long j) {
        if (isHeaderOrFooterPosition(i)) {
            return super.performItemClick(view, i, j);
        }
        return a(view, fv(i), j);
    }

    boolean a(View view, int i, long j) {
        boolean z;
        ExpandableHListConnector.b BH = this.jGX.BH(i);
        long b2 = b(BH.jGV);
        if (BH.jGV.type == 2) {
            if (this.jHa != null && this.jHa.a(this, view, BH.jGV.buX, b2)) {
                BH.recycle();
                return true;
            }
            if (BH.Qx()) {
                this.jGX.a(BH);
                playSoundEffect(0);
                if (this.jGY != null) {
                    this.jGY.fy(BH.jGV.buX);
                }
            } else {
                this.jGX.b(BH);
                playSoundEffect(0);
                if (this.jGZ != null) {
                    this.jGZ.fz(BH.jGV.buX);
                }
                int i2 = BH.jGV.buX;
                int headerViewsCount = BH.jGV.buZ + getHeaderViewsCount();
                smoothScrollToPosition(this.bvb.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.jHb != null) {
            playSoundEffect(0);
            return this.jHb.a(this, view, BH.jGV.buX, BH.jGV.buY, b2);
        } else {
            z = false;
        }
        BH.recycle();
        return z;
    }

    public void setOnGroupCollapseListener(d dVar) {
        this.jGY = dVar;
    }

    public void setOnGroupExpandListener(e eVar) {
        this.jGZ = eVar;
    }

    public void setOnGroupClickListener(c cVar) {
        this.jHa = cVar;
    }

    public void setOnChildClickListener(b bVar) {
        this.jHb = bVar;
    }

    public long fx(int i) {
        if (isHeaderOrFooterPosition(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b BH = this.jGX.BH(fv(i));
        long Qy = BH.jGV.Qy();
        BH.recycle();
        return Qy;
    }

    public long getSelectedPosition() {
        return fx(getSelectedItemPosition());
    }

    public long getSelectedId() {
        long selectedPosition = getSelectedPosition();
        if (selectedPosition == 4294967295L) {
            return -1L;
        }
        int aw = aw(selectedPosition);
        if (av(selectedPosition) == 0) {
            return this.bvb.getGroupId(aw);
        }
        return this.bvb.getChildId(aw, ax(selectedPosition));
    }

    public void setSelectedGroup(int i) {
        com.baidu.tieba.horizonalList.widget.a BJ = com.baidu.tieba.horizonalList.widget.a.BJ(i);
        ExpandableHListConnector.b a2 = this.jGX.a(BJ);
        BJ.recycle();
        super.setSelection(fw(a2.jGV.buZ));
        a2.recycle();
    }

    public static int av(long j) {
        if (j == 4294967295L) {
            return 2;
        }
        return (j & Long.MIN_VALUE) == Long.MIN_VALUE ? 1 : 0;
    }

    public static int aw(long j) {
        if (j == 4294967295L) {
            return -1;
        }
        return (int) ((9223372032559808512L & j) >> 32);
    }

    public static int ax(long j) {
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
        ExpandableHListConnector.b BH = this.jGX.BH(fv(i));
        com.baidu.tieba.horizonalList.widget.a aVar = BH.jGV;
        long b2 = b(aVar);
        long Qy = aVar.Qy();
        BH.recycle();
        return new a(view, Qy, b2);
    }

    private long b(com.baidu.tieba.horizonalList.widget.a aVar) {
        return aVar.type == 1 ? this.bvb.getChildId(aVar.buX, aVar.buY) : this.bvb.getGroupId(aVar.buX);
    }

    public void setChildIndicator(Drawable drawable) {
        this.bvi = drawable;
        QB();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.bvh = drawable;
        QA();
    }

    /* loaded from: classes.dex */
    public static class a implements ContextMenu.ContextMenuInfo {
        public long bvy;
        public long id;
        public View targetView;

        public a(View view, long j, long j2) {
            this.targetView = view;
            this.bvy = j;
            this.id = j2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.tieba.horizonalList.widget.ExpandableHListView.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: ac */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: BK */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        ArrayList<ExpandableHListConnector.GroupMetadata> bvz;

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.bvz = arrayList;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.bvz = new ArrayList<>();
            parcel.readList(this.bvz, ExpandableHListConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.bvz);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.jGX != null ? this.jGX.Qv() : null);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.jGX != null && savedState.bvz != null) {
            this.jGX.p(savedState.bvz);
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
