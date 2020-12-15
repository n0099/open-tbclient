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
    private static final int[] bER = {16842920};
    private static final int[] bES = {16842921};
    private static final int[] bET = {16842920, 16842921};
    private static final int[][] bEU = {EMPTY_STATE_SET, bER, bES, bET};
    private static final int[] bEV = {16842918};
    private ExpandableListAdapter bEJ;
    private int bEK;
    private int bEL;
    private int bEM;
    private int bEN;
    private int bEO;
    private Drawable bEP;
    private Drawable bEQ;
    private Drawable bEW;
    private final Rect bEX;
    private int bEY;
    private int bEZ;
    private int bFa;
    private int bFb;
    private ExpandableHListConnector kbk;
    private d kbl;
    private e kbm;
    private c kbn;
    private b kbo;
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
        void gf(int i);
    }

    /* loaded from: classes.dex */
    public interface e {
        void gg(int i);
    }

    public ExpandableHListView(Context context) {
        this(context, null);
    }

    public ExpandableHListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.hlv_expandableListViewStyle);
    }

    public ExpandableHListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bEX = new Rect();
        this.mTempRect = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandableHListView, i, 0);
        setGroupIndicator(obtainStyledAttributes.getDrawable(R.styleable.ExpandableHListView_hlv_groupIndicator));
        setChildIndicator(obtainStyledAttributes.getDrawable(R.styleable.ExpandableHListView_hlv_childIndicator));
        this.mIndicatorLeft = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandableHListView_hlv_indicatorPaddingLeft, 0);
        this.bEK = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandableHListView_hlv_indicatorPaddingTop, 0);
        this.bEL = obtainStyledAttributes.getInt(R.styleable.ExpandableHListView_hlv_indicatorGravity, 0);
        this.bEM = obtainStyledAttributes.getInt(R.styleable.ExpandableHListView_hlv_childIndicatorGravity, 0);
        this.bEO = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandableHListView_hlv_childIndicatorPaddingLeft, 0);
        this.bEN = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandableHListView_hlv_childIndicatorPaddingTop, 0);
        this.bEW = obtainStyledAttributes.getDrawable(R.styleable.ExpandableHListView_hlv_childDivider);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        Vb();
        Vc();
    }

    private void Vb() {
        if (this.bEP != null) {
            this.bEY = this.bEP.getIntrinsicWidth();
            this.bEZ = this.bEP.getIntrinsicHeight();
            return;
        }
        this.bEY = 0;
        this.bEZ = 0;
    }

    private void Vc() {
        if (this.bEQ != null) {
            this.bFa = this.bEQ.getIntrinsicWidth();
            this.bFb = this.bEQ.getIntrinsicHeight();
            return;
        }
        this.bFa = 0;
        this.bFb = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.bEQ != null || this.bEP != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.mItemCount - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            Rect rect = this.bEX;
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
                            ExpandableHListConnector.b Dh = this.kbk.Dh(i4);
                            if (Dh.kbi.type != i2) {
                                if (Dh.kbi.type == 1) {
                                    rect.top = childAt.getTop() + this.bEN;
                                    rect.bottom = childAt.getBottom() + this.bEN;
                                } else {
                                    rect.top = childAt.getTop() + this.bEK;
                                    rect.bottom = childAt.getBottom() + this.bEK;
                                }
                                i2 = Dh.kbi.type;
                            }
                            if (rect.top != rect.bottom) {
                                if (Dh.kbi.type == 1) {
                                    rect.left = this.bEO + left;
                                    rect.right = this.bEO + right2;
                                } else {
                                    rect.left = this.mIndicatorLeft + left;
                                    rect.right = this.mIndicatorLeft + right2;
                                }
                                Drawable c2 = c(Dh);
                                if (c2 != null) {
                                    if (Dh.kbi.type == 1) {
                                        Gravity.apply(this.bEM, this.bFa, this.bFb, rect, this.mTempRect);
                                    } else {
                                        Gravity.apply(this.bEL, this.bEY, this.bEZ, rect, this.mTempRect);
                                    }
                                    c2.setBounds(this.mTempRect);
                                    c2.draw(canvas);
                                }
                            }
                            Dh.recycle();
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
        if (bVar.kbi.type == 2) {
            Drawable drawable = this.bEP;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            drawable.setState(bEU[(bVar.UY() ? (char) 1 : (char) 0) | (bVar.kbj == null || bVar.kbj.bEx == bVar.kbj.bEw ? (char) 2 : (char) 0)]);
            return drawable;
        }
        Drawable drawable2 = this.bEQ;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(bVar.kbi.bEH == bVar.kbj.bEx ? bEV : EMPTY_STATE_SET);
        }
        return drawable2;
    }

    public void setChildDivider(Drawable drawable) {
        this.bEW = drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tieba.horizonalList.widget.HListView
    public void drawDivider(Canvas canvas, Rect rect, int i) {
        int i2 = this.mFirstPosition + i;
        if (i2 >= 0) {
            ExpandableHListConnector.b Dh = this.kbk.Dh(gc(i2));
            if (Dh.kbi.type == 1 || (Dh.UY() && Dh.kbj.bEx != Dh.kbj.bEw)) {
                Drawable drawable = this.bEW;
                drawable.setBounds(rect);
                drawable.draw(canvas);
                Dh.recycle();
                return;
            }
            Dh.recycle();
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
        this.bEJ = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.kbk = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.kbk = null;
        }
        super.setAdapter((ListAdapter) this.kbk);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.bEJ;
    }

    private boolean isHeaderOrFooterPosition(int i) {
        return i < getHeaderViewsCount() || i >= this.mItemCount - getFooterViewsCount();
    }

    private int gc(int i) {
        return i - getHeaderViewsCount();
    }

    private int gd(int i) {
        return getHeaderViewsCount() + i;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.AdapterView
    public boolean performItemClick(View view, int i, long j) {
        if (isHeaderOrFooterPosition(i)) {
            return super.performItemClick(view, i, j);
        }
        return b(view, gc(i), j);
    }

    boolean b(View view, int i, long j) {
        boolean z;
        ExpandableHListConnector.b Dh = this.kbk.Dh(i);
        long b2 = b(Dh.kbi);
        if (Dh.kbi.type == 2) {
            if (this.kbn != null && this.kbn.a(this, view, Dh.kbi.bEF, b2)) {
                Dh.recycle();
                return true;
            }
            if (Dh.UY()) {
                this.kbk.a(Dh);
                playSoundEffect(0);
                if (this.kbl != null) {
                    this.kbl.gf(Dh.kbi.bEF);
                }
            } else {
                this.kbk.b(Dh);
                playSoundEffect(0);
                if (this.kbm != null) {
                    this.kbm.gg(Dh.kbi.bEF);
                }
                int i2 = Dh.kbi.bEF;
                int headerViewsCount = Dh.kbi.bEH + getHeaderViewsCount();
                smoothScrollToPosition(this.bEJ.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.kbo != null) {
            playSoundEffect(0);
            return this.kbo.a(this, view, Dh.kbi.bEF, Dh.kbi.bEG, b2);
        } else {
            z = false;
        }
        Dh.recycle();
        return z;
    }

    public void setOnGroupCollapseListener(d dVar) {
        this.kbl = dVar;
    }

    public void setOnGroupExpandListener(e eVar) {
        this.kbm = eVar;
    }

    public void setOnGroupClickListener(c cVar) {
        this.kbn = cVar;
    }

    public void setOnChildClickListener(b bVar) {
        this.kbo = bVar;
    }

    public long ge(int i) {
        if (isHeaderOrFooterPosition(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b Dh = this.kbk.Dh(gc(i));
        long UZ = Dh.kbi.UZ();
        Dh.recycle();
        return UZ;
    }

    public long getSelectedPosition() {
        return ge(getSelectedItemPosition());
    }

    public long getSelectedId() {
        long selectedPosition = getSelectedPosition();
        if (selectedPosition == 4294967295L) {
            return -1L;
        }
        int bq = bq(selectedPosition);
        if (bp(selectedPosition) == 0) {
            return this.bEJ.getGroupId(bq);
        }
        return this.bEJ.getChildId(bq, br(selectedPosition));
    }

    public void setSelectedGroup(int i) {
        com.baidu.tieba.horizonalList.widget.a Dj = com.baidu.tieba.horizonalList.widget.a.Dj(i);
        ExpandableHListConnector.b a2 = this.kbk.a(Dj);
        Dj.recycle();
        super.setSelection(gd(a2.kbi.bEH));
        a2.recycle();
    }

    public static int bp(long j) {
        if (j == 4294967295L) {
            return 2;
        }
        return (j & Long.MIN_VALUE) == Long.MIN_VALUE ? 1 : 0;
    }

    public static int bq(long j) {
        if (j == 4294967295L) {
            return -1;
        }
        return (int) ((9223372032559808512L & j) >> 32);
    }

    public static int br(long j) {
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
        ExpandableHListConnector.b Dh = this.kbk.Dh(gc(i));
        com.baidu.tieba.horizonalList.widget.a aVar = Dh.kbi;
        long b2 = b(aVar);
        long UZ = aVar.UZ();
        Dh.recycle();
        return new a(view, UZ, b2);
    }

    private long b(com.baidu.tieba.horizonalList.widget.a aVar) {
        return aVar.type == 1 ? this.bEJ.getChildId(aVar.bEF, aVar.bEG) : this.bEJ.getGroupId(aVar.bEF);
    }

    public void setChildIndicator(Drawable drawable) {
        this.bEQ = drawable;
        Vc();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.bEP = drawable;
        Vb();
    }

    /* loaded from: classes.dex */
    public static class a implements ContextMenu.ContextMenuInfo {
        public long bFg;
        public long id;
        public View targetView;

        public a(View view, long j, long j2) {
            this.targetView = view;
            this.bFg = j;
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
            /* renamed from: Dk */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        ArrayList<ExpandableHListConnector.GroupMetadata> bFh;

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.bFh = arrayList;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.bFh = new ArrayList<>();
            parcel.readList(this.bFh, ExpandableHListConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.bFh);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.kbk != null ? this.kbk.UV() : null);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.kbk != null && savedState.bFh != null) {
            this.kbk.p(savedState.bFh);
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
