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
    private static final int[] auP = {16842920};
    private static final int[] auQ = {16842921};
    private static final int[] auR = {16842920, 16842921};
    private static final int[][] auS = {EMPTY_STATE_SET, auP, auQ, auR};
    private static final int[] auT = {16842918};
    private ExpandableListAdapter auH;
    private int auI;
    private int auJ;
    private int auK;
    private int auL;
    private int auM;
    private Drawable auN;
    private Drawable auO;
    private Drawable auU;
    private final Rect auV;
    private int auW;
    private int auX;
    private int auY;
    private int auZ;
    private ExpandableHListConnector hec;
    private d hed;
    private e hee;
    private c hef;
    private b heg;
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
        void ck(int i);
    }

    /* loaded from: classes.dex */
    public interface e {
        void cl(int i);
    }

    public ExpandableHListView(Context context) {
        this(context, null);
    }

    public ExpandableHListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.hlv_expandableListViewStyle);
    }

    public ExpandableHListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.auV = new Rect();
        this.mTempRect = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandableHListView, i, 0);
        setGroupIndicator(obtainStyledAttributes.getDrawable(5));
        setChildIndicator(obtainStyledAttributes.getDrawable(1));
        this.mIndicatorLeft = obtainStyledAttributes.getDimensionPixelSize(7, 0);
        this.auI = obtainStyledAttributes.getDimensionPixelSize(8, 0);
        this.auJ = obtainStyledAttributes.getInt(2, 0);
        this.auK = obtainStyledAttributes.getInt(3, 0);
        this.auM = obtainStyledAttributes.getDimensionPixelSize(6, 0);
        this.auL = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.auU = obtainStyledAttributes.getDrawable(4);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        xj();
        xk();
    }

    private void xj() {
        if (this.auN != null) {
            this.auW = this.auN.getIntrinsicWidth();
            this.auX = this.auN.getIntrinsicHeight();
            return;
        }
        this.auW = 0;
        this.auX = 0;
    }

    private void xk() {
        if (this.auO != null) {
            this.auY = this.auO.getIntrinsicWidth();
            this.auZ = this.auO.getIntrinsicHeight();
            return;
        }
        this.auY = 0;
        this.auZ = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.auO != null || this.auN != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.mItemCount - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            Rect rect = this.auV;
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
                            ExpandableHListConnector.b vm = this.hec.vm(i4);
                            if (vm.hea.type != i2) {
                                if (vm.hea.type == 1) {
                                    rect.top = childAt.getTop() + this.auL;
                                    rect.bottom = childAt.getBottom() + this.auL;
                                } else {
                                    rect.top = childAt.getTop() + this.auI;
                                    rect.bottom = childAt.getBottom() + this.auI;
                                }
                                i2 = vm.hea.type;
                            }
                            if (rect.top != rect.bottom) {
                                if (vm.hea.type == 1) {
                                    rect.left = this.auM + left;
                                    rect.right = this.auM + right2;
                                } else {
                                    rect.left = this.mIndicatorLeft + left;
                                    rect.right = this.mIndicatorLeft + right2;
                                }
                                Drawable c2 = c(vm);
                                if (c2 != null) {
                                    if (vm.hea.type == 1) {
                                        Gravity.apply(this.auK, this.auY, this.auZ, rect, this.mTempRect);
                                    } else {
                                        Gravity.apply(this.auJ, this.auW, this.auX, rect, this.mTempRect);
                                    }
                                    c2.setBounds(this.mTempRect);
                                    c2.draw(canvas);
                                }
                            }
                            vm.recycle();
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
        if (bVar.hea.type == 2) {
            Drawable drawable = this.auN;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            drawable.setState(auS[(bVar.xg() ? (char) 1 : (char) 0) | (bVar.heb == null || bVar.heb.auv == bVar.heb.auu ? (char) 2 : (char) 0)]);
            return drawable;
        }
        Drawable drawable2 = this.auO;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(bVar.hea.auF == bVar.heb.auv ? auT : EMPTY_STATE_SET);
        }
        return drawable2;
    }

    public void setChildDivider(Drawable drawable) {
        this.auU = drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tieba.horizonalList.widget.HListView
    public void drawDivider(Canvas canvas, Rect rect, int i) {
        int i2 = this.mFirstPosition + i;
        if (i2 >= 0) {
            ExpandableHListConnector.b vm = this.hec.vm(ch(i2));
            if (vm.hea.type == 1 || (vm.xg() && vm.heb.auv != vm.heb.auu)) {
                Drawable drawable = this.auU;
                drawable.setBounds(rect);
                drawable.draw(canvas);
                vm.recycle();
                return;
            }
            vm.recycle();
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
        this.auH = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.hec = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.hec = null;
        }
        super.setAdapter((ListAdapter) this.hec);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.auH;
    }

    private boolean isHeaderOrFooterPosition(int i) {
        return i < getHeaderViewsCount() || i >= this.mItemCount - getFooterViewsCount();
    }

    private int ch(int i) {
        return i - getHeaderViewsCount();
    }

    private int ci(int i) {
        return getHeaderViewsCount() + i;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.AdapterView
    public boolean performItemClick(View view, int i, long j) {
        if (isHeaderOrFooterPosition(i)) {
            return super.performItemClick(view, i, j);
        }
        return a(view, ch(i), j);
    }

    boolean a(View view, int i, long j) {
        boolean z;
        ExpandableHListConnector.b vm = this.hec.vm(i);
        long b2 = b(vm.hea);
        if (vm.hea.type == 2) {
            if (this.hef != null && this.hef.a(this, view, vm.hea.auD, b2)) {
                vm.recycle();
                return true;
            }
            if (vm.xg()) {
                this.hec.a(vm);
                playSoundEffect(0);
                if (this.hed != null) {
                    this.hed.ck(vm.hea.auD);
                }
            } else {
                this.hec.b(vm);
                playSoundEffect(0);
                if (this.hee != null) {
                    this.hee.cl(vm.hea.auD);
                }
                int i2 = vm.hea.auD;
                int headerViewsCount = vm.hea.auF + getHeaderViewsCount();
                smoothScrollToPosition(this.auH.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.heg != null) {
            playSoundEffect(0);
            return this.heg.a(this, view, vm.hea.auD, vm.hea.auE, b2);
        } else {
            z = false;
        }
        vm.recycle();
        return z;
    }

    public void setOnGroupCollapseListener(d dVar) {
        this.hed = dVar;
    }

    public void setOnGroupExpandListener(e eVar) {
        this.hee = eVar;
    }

    public void setOnGroupClickListener(c cVar) {
        this.hef = cVar;
    }

    public void setOnChildClickListener(b bVar) {
        this.heg = bVar;
    }

    public long cj(int i) {
        if (isHeaderOrFooterPosition(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b vm = this.hec.vm(ch(i));
        long xh = vm.hea.xh();
        vm.recycle();
        return xh;
    }

    public long getSelectedPosition() {
        return cj(getSelectedItemPosition());
    }

    public long getSelectedId() {
        long selectedPosition = getSelectedPosition();
        if (selectedPosition == 4294967295L) {
            return -1L;
        }
        int G = G(selectedPosition);
        if (F(selectedPosition) == 0) {
            return this.auH.getGroupId(G);
        }
        return this.auH.getChildId(G, H(selectedPosition));
    }

    public void setSelectedGroup(int i) {
        com.baidu.tieba.horizonalList.widget.a vo = com.baidu.tieba.horizonalList.widget.a.vo(i);
        ExpandableHListConnector.b a2 = this.hec.a(vo);
        vo.recycle();
        super.setSelection(ci(a2.hea.auF));
        a2.recycle();
    }

    public static int F(long j) {
        if (j == 4294967295L) {
            return 2;
        }
        return (j & Long.MIN_VALUE) == Long.MIN_VALUE ? 1 : 0;
    }

    public static int G(long j) {
        if (j == 4294967295L) {
            return -1;
        }
        return (int) ((9223372032559808512L & j) >> 32);
    }

    public static int H(long j) {
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
        ExpandableHListConnector.b vm = this.hec.vm(ch(i));
        com.baidu.tieba.horizonalList.widget.a aVar = vm.hea;
        long b2 = b(aVar);
        long xh = aVar.xh();
        vm.recycle();
        return new a(view, xh, b2);
    }

    private long b(com.baidu.tieba.horizonalList.widget.a aVar) {
        return aVar.type == 1 ? this.auH.getChildId(aVar.auD, aVar.auE) : this.auH.getGroupId(aVar.auD);
    }

    public void setChildIndicator(Drawable drawable) {
        this.auO = drawable;
        xk();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.auN = drawable;
        xj();
    }

    /* loaded from: classes.dex */
    public static class a implements ContextMenu.ContextMenuInfo {
        public long ave;
        public long id;
        public View targetView;

        public a(View view, long j, long j2) {
            this.targetView = view;
            this.ave = j;
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
            /* renamed from: vp */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        ArrayList<ExpandableHListConnector.GroupMetadata> avf;

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.avf = arrayList;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.avf = new ArrayList<>();
            parcel.readList(this.avf, ExpandableHListConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.avf);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.hec != null ? this.hec.xe() : null);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.hec != null && savedState.avf != null) {
            this.hec.i(savedState.avf);
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
