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
    private static final int[] azT = {16842920};
    private static final int[] azU = {16842921};
    private static final int[] azV = {16842920, 16842921};
    private static final int[][] azW = {EMPTY_STATE_SET, azT, azU, azV};
    private static final int[] azX = {16842918};
    private int aAa;
    private int aAb;
    private int aAc;
    private int aAd;
    private ExpandableListAdapter azL;
    private int azM;
    private int azN;
    private int azO;
    private int azP;
    private int azQ;
    private Drawable azR;
    private Drawable azS;
    private Drawable azY;
    private final Rect azZ;
    private ExpandableHListConnector hjU;
    private d hjV;
    private e hjW;
    private c hjX;
    private b hjY;
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
        void cB(int i);
    }

    /* loaded from: classes.dex */
    public interface e {
        void cC(int i);
    }

    public ExpandableHListView(Context context) {
        this(context, null);
    }

    public ExpandableHListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.hlv_expandableListViewStyle);
    }

    public ExpandableHListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.azZ = new Rect();
        this.mTempRect = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandableHListView, i, 0);
        setGroupIndicator(obtainStyledAttributes.getDrawable(5));
        setChildIndicator(obtainStyledAttributes.getDrawable(1));
        this.mIndicatorLeft = obtainStyledAttributes.getDimensionPixelSize(7, 0);
        this.azM = obtainStyledAttributes.getDimensionPixelSize(8, 0);
        this.azN = obtainStyledAttributes.getInt(2, 0);
        this.azO = obtainStyledAttributes.getInt(3, 0);
        this.azQ = obtainStyledAttributes.getDimensionPixelSize(6, 0);
        this.azP = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.azY = obtainStyledAttributes.getDrawable(4);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        zS();
        zT();
    }

    private void zS() {
        if (this.azR != null) {
            this.aAa = this.azR.getIntrinsicWidth();
            this.aAb = this.azR.getIntrinsicHeight();
            return;
        }
        this.aAa = 0;
        this.aAb = 0;
    }

    private void zT() {
        if (this.azS != null) {
            this.aAc = this.azS.getIntrinsicWidth();
            this.aAd = this.azS.getIntrinsicHeight();
            return;
        }
        this.aAc = 0;
        this.aAd = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.azS != null || this.azR != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.mItemCount - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            Rect rect = this.azZ;
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
                            ExpandableHListConnector.b vx = this.hjU.vx(i4);
                            if (vx.hjS.type != i2) {
                                if (vx.hjS.type == 1) {
                                    rect.top = childAt.getTop() + this.azP;
                                    rect.bottom = childAt.getBottom() + this.azP;
                                } else {
                                    rect.top = childAt.getTop() + this.azM;
                                    rect.bottom = childAt.getBottom() + this.azM;
                                }
                                i2 = vx.hjS.type;
                            }
                            if (rect.top != rect.bottom) {
                                if (vx.hjS.type == 1) {
                                    rect.left = this.azQ + left;
                                    rect.right = this.azQ + right2;
                                } else {
                                    rect.left = this.mIndicatorLeft + left;
                                    rect.right = this.mIndicatorLeft + right2;
                                }
                                Drawable c2 = c(vx);
                                if (c2 != null) {
                                    if (vx.hjS.type == 1) {
                                        Gravity.apply(this.azO, this.aAc, this.aAd, rect, this.mTempRect);
                                    } else {
                                        Gravity.apply(this.azN, this.aAa, this.aAb, rect, this.mTempRect);
                                    }
                                    c2.setBounds(this.mTempRect);
                                    c2.draw(canvas);
                                }
                            }
                            vx.recycle();
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
        if (bVar.hjS.type == 2) {
            Drawable drawable = this.azR;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            drawable.setState(azW[(bVar.zP() ? (char) 1 : (char) 0) | (bVar.hjT == null || bVar.hjT.azz == bVar.hjT.azy ? (char) 2 : (char) 0)]);
            return drawable;
        }
        Drawable drawable2 = this.azS;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(bVar.hjS.azJ == bVar.hjT.azz ? azX : EMPTY_STATE_SET);
        }
        return drawable2;
    }

    public void setChildDivider(Drawable drawable) {
        this.azY = drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tieba.horizonalList.widget.HListView
    public void drawDivider(Canvas canvas, Rect rect, int i) {
        int i2 = this.mFirstPosition + i;
        if (i2 >= 0) {
            ExpandableHListConnector.b vx = this.hjU.vx(cy(i2));
            if (vx.hjS.type == 1 || (vx.zP() && vx.hjT.azz != vx.hjT.azy)) {
                Drawable drawable = this.azY;
                drawable.setBounds(rect);
                drawable.draw(canvas);
                vx.recycle();
                return;
            }
            vx.recycle();
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
        this.azL = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.hjU = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.hjU = null;
        }
        super.setAdapter((ListAdapter) this.hjU);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.azL;
    }

    private boolean isHeaderOrFooterPosition(int i) {
        return i < getHeaderViewsCount() || i >= this.mItemCount - getFooterViewsCount();
    }

    private int cy(int i) {
        return i - getHeaderViewsCount();
    }

    private int cz(int i) {
        return getHeaderViewsCount() + i;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.AdapterView
    public boolean performItemClick(View view, int i, long j) {
        if (isHeaderOrFooterPosition(i)) {
            return super.performItemClick(view, i, j);
        }
        return a(view, cy(i), j);
    }

    boolean a(View view, int i, long j) {
        boolean z;
        ExpandableHListConnector.b vx = this.hjU.vx(i);
        long b2 = b(vx.hjS);
        if (vx.hjS.type == 2) {
            if (this.hjX != null && this.hjX.a(this, view, vx.hjS.azH, b2)) {
                vx.recycle();
                return true;
            }
            if (vx.zP()) {
                this.hjU.a(vx);
                playSoundEffect(0);
                if (this.hjV != null) {
                    this.hjV.cB(vx.hjS.azH);
                }
            } else {
                this.hjU.b(vx);
                playSoundEffect(0);
                if (this.hjW != null) {
                    this.hjW.cC(vx.hjS.azH);
                }
                int i2 = vx.hjS.azH;
                int headerViewsCount = vx.hjS.azJ + getHeaderViewsCount();
                smoothScrollToPosition(this.azL.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.hjY != null) {
            playSoundEffect(0);
            return this.hjY.a(this, view, vx.hjS.azH, vx.hjS.azI, b2);
        } else {
            z = false;
        }
        vx.recycle();
        return z;
    }

    public void setOnGroupCollapseListener(d dVar) {
        this.hjV = dVar;
    }

    public void setOnGroupExpandListener(e eVar) {
        this.hjW = eVar;
    }

    public void setOnGroupClickListener(c cVar) {
        this.hjX = cVar;
    }

    public void setOnChildClickListener(b bVar) {
        this.hjY = bVar;
    }

    public long cA(int i) {
        if (isHeaderOrFooterPosition(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b vx = this.hjU.vx(cy(i));
        long zQ = vx.hjS.zQ();
        vx.recycle();
        return zQ;
    }

    public long getSelectedPosition() {
        return cA(getSelectedItemPosition());
    }

    public long getSelectedId() {
        long selectedPosition = getSelectedPosition();
        if (selectedPosition == 4294967295L) {
            return -1L;
        }
        int K = K(selectedPosition);
        if (J(selectedPosition) == 0) {
            return this.azL.getGroupId(K);
        }
        return this.azL.getChildId(K, L(selectedPosition));
    }

    public void setSelectedGroup(int i) {
        com.baidu.tieba.horizonalList.widget.a vz = com.baidu.tieba.horizonalList.widget.a.vz(i);
        ExpandableHListConnector.b a2 = this.hjU.a(vz);
        vz.recycle();
        super.setSelection(cz(a2.hjS.azJ));
        a2.recycle();
    }

    public static int J(long j) {
        if (j == 4294967295L) {
            return 2;
        }
        return (j & Long.MIN_VALUE) == Long.MIN_VALUE ? 1 : 0;
    }

    public static int K(long j) {
        if (j == 4294967295L) {
            return -1;
        }
        return (int) ((9223372032559808512L & j) >> 32);
    }

    public static int L(long j) {
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
        ExpandableHListConnector.b vx = this.hjU.vx(cy(i));
        com.baidu.tieba.horizonalList.widget.a aVar = vx.hjS;
        long b2 = b(aVar);
        long zQ = aVar.zQ();
        vx.recycle();
        return new a(view, zQ, b2);
    }

    private long b(com.baidu.tieba.horizonalList.widget.a aVar) {
        return aVar.type == 1 ? this.azL.getChildId(aVar.azH, aVar.azI) : this.azL.getGroupId(aVar.azH);
    }

    public void setChildIndicator(Drawable drawable) {
        this.azS = drawable;
        zT();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.azR = drawable;
        zS();
    }

    /* loaded from: classes.dex */
    public static class a implements ContextMenu.ContextMenuInfo {
        public long aAi;
        public long id;
        public View targetView;

        public a(View view, long j, long j2) {
            this.targetView = view;
            this.aAi = j;
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
            /* renamed from: vA */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        ArrayList<ExpandableHListConnector.GroupMetadata> aAj;

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.aAj = arrayList;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.aAj = new ArrayList<>();
            parcel.readList(this.aAj, ExpandableHListConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.aAj);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.hjU != null ? this.hjU.zN() : null);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.hjU != null && savedState.aAj != null) {
            this.hjU.k(savedState.aAj);
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
