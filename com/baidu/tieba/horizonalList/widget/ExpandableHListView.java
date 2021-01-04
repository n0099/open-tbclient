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
    private static final int[] bJF = {16842920};
    private static final int[] bJG = {16842921};
    private static final int[] bJH = {16842920, 16842921};
    private static final int[][] bJI = {EMPTY_STATE_SET, bJF, bJG, bJH};
    private static final int[] bJJ = {16842918};
    private int ZA;
    private int bJA;
    private int bJB;
    private int bJC;
    private Drawable bJD;
    private Drawable bJE;
    private Drawable bJK;
    private final Rect bJL;
    private int bJM;
    private int bJN;
    private int bJO;
    private int bJP;
    private ExpandableListAdapter bJx;
    private int bJy;
    private int bJz;
    private b koA;
    private ExpandableHListConnector kow;
    private d kox;
    private e koy;
    private c koz;
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
        void gg(int i);
    }

    /* loaded from: classes.dex */
    public interface e {
        void gh(int i);
    }

    public ExpandableHListView(Context context) {
        this(context, null);
    }

    public ExpandableHListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.hlv_expandableListViewStyle);
    }

    public ExpandableHListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bJL = new Rect();
        this.mTempRect = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandableHListView, i, 0);
        setGroupIndicator(obtainStyledAttributes.getDrawable(R.styleable.ExpandableHListView_hlv_groupIndicator));
        setChildIndicator(obtainStyledAttributes.getDrawable(R.styleable.ExpandableHListView_hlv_childIndicator));
        this.ZA = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandableHListView_hlv_indicatorPaddingLeft, 0);
        this.bJy = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandableHListView_hlv_indicatorPaddingTop, 0);
        this.bJz = obtainStyledAttributes.getInt(R.styleable.ExpandableHListView_hlv_indicatorGravity, 0);
        this.bJA = obtainStyledAttributes.getInt(R.styleable.ExpandableHListView_hlv_childIndicatorGravity, 0);
        this.bJC = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandableHListView_hlv_childIndicatorPaddingLeft, 0);
        this.bJB = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandableHListView_hlv_childIndicatorPaddingTop, 0);
        this.bJK = obtainStyledAttributes.getDrawable(R.styleable.ExpandableHListView_hlv_childDivider);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        Wf();
        Wg();
    }

    private void Wf() {
        if (this.bJD != null) {
            this.bJM = this.bJD.getIntrinsicWidth();
            this.bJN = this.bJD.getIntrinsicHeight();
            return;
        }
        this.bJM = 0;
        this.bJN = 0;
    }

    private void Wg() {
        if (this.bJE != null) {
            this.bJO = this.bJE.getIntrinsicWidth();
            this.bJP = this.bJE.getIntrinsicHeight();
            return;
        }
        this.bJO = 0;
        this.bJP = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.bJE != null || this.bJD != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.mItemCount - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            int i = -4;
            Rect rect = this.bJL;
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
                            ExpandableHListConnector.b Dv = this.kow.Dv(i3);
                            if (Dv.kou.type != i) {
                                if (Dv.kou.type == 1) {
                                    rect.top = childAt.getTop() + this.bJB;
                                    rect.bottom = childAt.getBottom() + this.bJB;
                                } else {
                                    rect.top = childAt.getTop() + this.bJy;
                                    rect.bottom = childAt.getBottom() + this.bJy;
                                }
                                i = Dv.kou.type;
                            }
                            if (rect.top != rect.bottom) {
                                if (Dv.kou.type == 1) {
                                    rect.left = this.bJC + left;
                                    rect.right = this.bJC + right2;
                                } else {
                                    rect.left = this.ZA + left;
                                    rect.right = this.ZA + right2;
                                }
                                Drawable c2 = c(Dv);
                                if (c2 != null) {
                                    if (Dv.kou.type == 1) {
                                        Gravity.apply(this.bJA, this.bJO, this.bJP, rect, this.mTempRect);
                                    } else {
                                        Gravity.apply(this.bJz, this.bJM, this.bJN, rect, this.mTempRect);
                                    }
                                    c2.setBounds(this.mTempRect);
                                    c2.draw(canvas);
                                }
                            }
                            Dv.recycle();
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
        if (bVar.kou.type == 2) {
            Drawable drawable = this.bJD;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            drawable.setState(bJI[(bVar.isExpanded() ? (char) 1 : (char) 0) | (bVar.kov == null || bVar.kov.bJl == bVar.kov.bJk ? (char) 2 : (char) 0)]);
            return drawable;
        }
        Drawable drawable2 = this.bJE;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(bVar.kou.bJv == bVar.kov.bJl ? bJJ : EMPTY_STATE_SET);
        }
        return drawable2;
    }

    public void setChildDivider(Drawable drawable) {
        this.bJK = drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tieba.horizonalList.widget.HListView
    public void drawDivider(Canvas canvas, Rect rect, int i) {
        int i2 = this.mFirstPosition + i;
        if (i2 >= 0) {
            ExpandableHListConnector.b Dv = this.kow.Dv(gd(i2));
            if (Dv.kou.type == 1 || (Dv.isExpanded() && Dv.kov.bJl != Dv.kov.bJk)) {
                Drawable drawable = this.bJK;
                drawable.setBounds(rect);
                drawable.draw(canvas);
                Dv.recycle();
                return;
            }
            Dv.recycle();
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
        this.bJx = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.kow = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.kow = null;
        }
        super.setAdapter((ListAdapter) this.kow);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.bJx;
    }

    private boolean isHeaderOrFooterPosition(int i) {
        return i < getHeaderViewsCount() || i >= this.mItemCount - getFooterViewsCount();
    }

    private int gd(int i) {
        return i - getHeaderViewsCount();
    }

    private int ge(int i) {
        return getHeaderViewsCount() + i;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.AdapterView
    public boolean performItemClick(View view, int i, long j) {
        if (isHeaderOrFooterPosition(i)) {
            return super.performItemClick(view, i, j);
        }
        return b(view, gd(i), j);
    }

    boolean b(View view, int i, long j) {
        boolean z;
        ExpandableHListConnector.b Dv = this.kow.Dv(i);
        long b2 = b(Dv.kou);
        if (Dv.kou.type == 2) {
            if (this.koz != null && this.koz.a(this, view, Dv.kou.bJt, b2)) {
                Dv.recycle();
                return true;
            }
            if (Dv.isExpanded()) {
                this.kow.a(Dv);
                playSoundEffect(0);
                if (this.kox != null) {
                    this.kox.gg(Dv.kou.bJt);
                }
            } else {
                this.kow.b(Dv);
                playSoundEffect(0);
                if (this.koy != null) {
                    this.koy.gh(Dv.kou.bJt);
                }
                int i2 = Dv.kou.bJt;
                int headerViewsCount = Dv.kou.bJv + getHeaderViewsCount();
                smoothScrollToPosition(this.bJx.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.koA != null) {
            playSoundEffect(0);
            return this.koA.a(this, view, Dv.kou.bJt, Dv.kou.bJu, b2);
        } else {
            z = false;
        }
        Dv.recycle();
        return z;
    }

    public void setOnGroupCollapseListener(d dVar) {
        this.kox = dVar;
    }

    public void setOnGroupExpandListener(e eVar) {
        this.koy = eVar;
    }

    public void setOnGroupClickListener(c cVar) {
        this.koz = cVar;
    }

    public void setOnChildClickListener(b bVar) {
        this.koA = bVar;
    }

    public long gf(int i) {
        if (isHeaderOrFooterPosition(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b Dv = this.kow.Dv(gd(i));
        long Wd = Dv.kou.Wd();
        Dv.recycle();
        return Wd;
    }

    public long getSelectedPosition() {
        return gf(getSelectedItemPosition());
    }

    public long getSelectedId() {
        long selectedPosition = getSelectedPosition();
        if (selectedPosition == 4294967295L) {
            return -1L;
        }
        int bq = bq(selectedPosition);
        if (bp(selectedPosition) == 0) {
            return this.bJx.getGroupId(bq);
        }
        return this.bJx.getChildId(bq, br(selectedPosition));
    }

    public void setSelectedGroup(int i) {
        com.baidu.tieba.horizonalList.widget.a Dx = com.baidu.tieba.horizonalList.widget.a.Dx(i);
        ExpandableHListConnector.b a2 = this.kow.a(Dx);
        Dx.recycle();
        super.setSelection(ge(a2.kou.bJv));
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
        ExpandableHListConnector.b Dv = this.kow.Dv(gd(i));
        com.baidu.tieba.horizonalList.widget.a aVar = Dv.kou;
        long b2 = b(aVar);
        long Wd = aVar.Wd();
        Dv.recycle();
        return new a(view, Wd, b2);
    }

    private long b(com.baidu.tieba.horizonalList.widget.a aVar) {
        return aVar.type == 1 ? this.bJx.getChildId(aVar.bJt, aVar.bJu) : this.bJx.getGroupId(aVar.bJt);
    }

    public void setChildIndicator(Drawable drawable) {
        this.bJE = drawable;
        Wg();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.bJD = drawable;
        Wf();
    }

    /* loaded from: classes.dex */
    public static class a implements ContextMenu.ContextMenuInfo {
        public long bJU;
        public long id;
        public View targetView;

        public a(View view, long j, long j2) {
            this.targetView = view;
            this.bJU = j;
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
            /* renamed from: Dy */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        ArrayList<ExpandableHListConnector.GroupMetadata> bJV;

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.bJV = arrayList;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.bJV = new ArrayList<>();
            parcel.readList(this.bJV, ExpandableHListConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.bJV);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.kow != null ? this.kow.Wa() : null);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.kow != null && savedState.bJV != null) {
            this.kow.p(savedState.bJV);
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
