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
    private static final int[] btb = {16842920};
    private static final int[] btc = {16842921};
    private static final int[] btd = {16842920, 16842921};
    private static final int[][] bte = {EMPTY_STATE_SET, btb, btc, btd};
    private static final int[] btf = {16842918};
    private ExpandableListAdapter bsT;
    private int bsU;
    private int bsV;
    private int bsW;
    private int bsX;
    private int bsY;
    private Drawable bsZ;
    private Drawable bta;
    private Drawable btg;
    private final Rect bth;
    private int bti;
    private int btj;
    private int btk;
    private int btl;
    private e juA;
    private c juB;
    private b juC;
    private ExpandableHListConnector juy;
    private d juz;
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
        void fw(int i);
    }

    /* loaded from: classes.dex */
    public interface e {
        void fx(int i);
    }

    public ExpandableHListView(Context context) {
        this(context, null);
    }

    public ExpandableHListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.hlv_expandableListViewStyle);
    }

    public ExpandableHListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bth = new Rect();
        this.mTempRect = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandableHListView, i, 0);
        setGroupIndicator(obtainStyledAttributes.getDrawable(R.styleable.ExpandableHListView_hlv_groupIndicator));
        setChildIndicator(obtainStyledAttributes.getDrawable(R.styleable.ExpandableHListView_hlv_childIndicator));
        this.mIndicatorLeft = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandableHListView_hlv_indicatorPaddingLeft, 0);
        this.bsU = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandableHListView_hlv_indicatorPaddingTop, 0);
        this.bsV = obtainStyledAttributes.getInt(R.styleable.ExpandableHListView_hlv_indicatorGravity, 0);
        this.bsW = obtainStyledAttributes.getInt(R.styleable.ExpandableHListView_hlv_childIndicatorGravity, 0);
        this.bsY = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandableHListView_hlv_childIndicatorPaddingLeft, 0);
        this.bsX = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandableHListView_hlv_childIndicatorPaddingTop, 0);
        this.btg = obtainStyledAttributes.getDrawable(R.styleable.ExpandableHListView_hlv_childDivider);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        PH();
        PI();
    }

    private void PH() {
        if (this.bsZ != null) {
            this.bti = this.bsZ.getIntrinsicWidth();
            this.btj = this.bsZ.getIntrinsicHeight();
            return;
        }
        this.bti = 0;
        this.btj = 0;
    }

    private void PI() {
        if (this.bta != null) {
            this.btk = this.bta.getIntrinsicWidth();
            this.btl = this.bta.getIntrinsicHeight();
            return;
        }
        this.btk = 0;
        this.btl = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.bta != null || this.bsZ != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.mItemCount - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            Rect rect = this.bth;
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
                            ExpandableHListConnector.b Bo = this.juy.Bo(i4);
                            if (Bo.juw.type != i2) {
                                if (Bo.juw.type == 1) {
                                    rect.top = childAt.getTop() + this.bsX;
                                    rect.bottom = childAt.getBottom() + this.bsX;
                                } else {
                                    rect.top = childAt.getTop() + this.bsU;
                                    rect.bottom = childAt.getBottom() + this.bsU;
                                }
                                i2 = Bo.juw.type;
                            }
                            if (rect.top != rect.bottom) {
                                if (Bo.juw.type == 1) {
                                    rect.left = this.bsY + left;
                                    rect.right = this.bsY + right2;
                                } else {
                                    rect.left = this.mIndicatorLeft + left;
                                    rect.right = this.mIndicatorLeft + right2;
                                }
                                Drawable c2 = c(Bo);
                                if (c2 != null) {
                                    if (Bo.juw.type == 1) {
                                        Gravity.apply(this.bsW, this.btk, this.btl, rect, this.mTempRect);
                                    } else {
                                        Gravity.apply(this.bsV, this.bti, this.btj, rect, this.mTempRect);
                                    }
                                    c2.setBounds(this.mTempRect);
                                    c2.draw(canvas);
                                }
                            }
                            Bo.recycle();
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
        if (bVar.juw.type == 2) {
            Drawable drawable = this.bsZ;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            drawable.setState(bte[(bVar.PE() ? (char) 1 : (char) 0) | (bVar.jux == null || bVar.jux.bsH == bVar.jux.bsG ? (char) 2 : (char) 0)]);
            return drawable;
        }
        Drawable drawable2 = this.bta;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(bVar.juw.bsR == bVar.jux.bsH ? btf : EMPTY_STATE_SET);
        }
        return drawable2;
    }

    public void setChildDivider(Drawable drawable) {
        this.btg = drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tieba.horizonalList.widget.HListView
    public void drawDivider(Canvas canvas, Rect rect, int i) {
        int i2 = this.mFirstPosition + i;
        if (i2 >= 0) {
            ExpandableHListConnector.b Bo = this.juy.Bo(ft(i2));
            if (Bo.juw.type == 1 || (Bo.PE() && Bo.jux.bsH != Bo.jux.bsG)) {
                Drawable drawable = this.btg;
                drawable.setBounds(rect);
                drawable.draw(canvas);
                Bo.recycle();
                return;
            }
            Bo.recycle();
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
        this.bsT = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.juy = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.juy = null;
        }
        super.setAdapter((ListAdapter) this.juy);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.bsT;
    }

    private boolean isHeaderOrFooterPosition(int i) {
        return i < getHeaderViewsCount() || i >= this.mItemCount - getFooterViewsCount();
    }

    private int ft(int i) {
        return i - getHeaderViewsCount();
    }

    private int fu(int i) {
        return getHeaderViewsCount() + i;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.AdapterView
    public boolean performItemClick(View view, int i, long j) {
        if (isHeaderOrFooterPosition(i)) {
            return super.performItemClick(view, i, j);
        }
        return a(view, ft(i), j);
    }

    boolean a(View view, int i, long j) {
        boolean z;
        ExpandableHListConnector.b Bo = this.juy.Bo(i);
        long b2 = b(Bo.juw);
        if (Bo.juw.type == 2) {
            if (this.juB != null && this.juB.a(this, view, Bo.juw.bsP, b2)) {
                Bo.recycle();
                return true;
            }
            if (Bo.PE()) {
                this.juy.a(Bo);
                playSoundEffect(0);
                if (this.juz != null) {
                    this.juz.fw(Bo.juw.bsP);
                }
            } else {
                this.juy.b(Bo);
                playSoundEffect(0);
                if (this.juA != null) {
                    this.juA.fx(Bo.juw.bsP);
                }
                int i2 = Bo.juw.bsP;
                int headerViewsCount = Bo.juw.bsR + getHeaderViewsCount();
                smoothScrollToPosition(this.bsT.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.juC != null) {
            playSoundEffect(0);
            return this.juC.a(this, view, Bo.juw.bsP, Bo.juw.bsQ, b2);
        } else {
            z = false;
        }
        Bo.recycle();
        return z;
    }

    public void setOnGroupCollapseListener(d dVar) {
        this.juz = dVar;
    }

    public void setOnGroupExpandListener(e eVar) {
        this.juA = eVar;
    }

    public void setOnGroupClickListener(c cVar) {
        this.juB = cVar;
    }

    public void setOnChildClickListener(b bVar) {
        this.juC = bVar;
    }

    public long fv(int i) {
        if (isHeaderOrFooterPosition(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b Bo = this.juy.Bo(ft(i));
        long PF = Bo.juw.PF();
        Bo.recycle();
        return PF;
    }

    public long getSelectedPosition() {
        return fv(getSelectedItemPosition());
    }

    public long getSelectedId() {
        long selectedPosition = getSelectedPosition();
        if (selectedPosition == 4294967295L) {
            return -1L;
        }
        int au = au(selectedPosition);
        if (at(selectedPosition) == 0) {
            return this.bsT.getGroupId(au);
        }
        return this.bsT.getChildId(au, av(selectedPosition));
    }

    public void setSelectedGroup(int i) {
        com.baidu.tieba.horizonalList.widget.a Bq = com.baidu.tieba.horizonalList.widget.a.Bq(i);
        ExpandableHListConnector.b a2 = this.juy.a(Bq);
        Bq.recycle();
        super.setSelection(fu(a2.juw.bsR));
        a2.recycle();
    }

    public static int at(long j) {
        if (j == 4294967295L) {
            return 2;
        }
        return (j & Long.MIN_VALUE) == Long.MIN_VALUE ? 1 : 0;
    }

    public static int au(long j) {
        if (j == 4294967295L) {
            return -1;
        }
        return (int) ((9223372032559808512L & j) >> 32);
    }

    public static int av(long j) {
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
        ExpandableHListConnector.b Bo = this.juy.Bo(ft(i));
        com.baidu.tieba.horizonalList.widget.a aVar = Bo.juw;
        long b2 = b(aVar);
        long PF = aVar.PF();
        Bo.recycle();
        return new a(view, PF, b2);
    }

    private long b(com.baidu.tieba.horizonalList.widget.a aVar) {
        return aVar.type == 1 ? this.bsT.getChildId(aVar.bsP, aVar.bsQ) : this.bsT.getGroupId(aVar.bsP);
    }

    public void setChildIndicator(Drawable drawable) {
        this.bta = drawable;
        PI();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.bsZ = drawable;
        PH();
    }

    /* loaded from: classes.dex */
    public static class a implements ContextMenu.ContextMenuInfo {
        public long btr;
        public long id;
        public View targetView;

        public a(View view, long j, long j2) {
            this.targetView = view;
            this.btr = j;
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
            /* renamed from: Br */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        ArrayList<ExpandableHListConnector.GroupMetadata> bts;

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.bts = arrayList;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.bts = new ArrayList<>();
            parcel.readList(this.bts, ExpandableHListConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.bts);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.juy != null ? this.juy.PC() : null);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.juy != null && savedState.bts != null) {
            this.juy.p(savedState.bts);
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
