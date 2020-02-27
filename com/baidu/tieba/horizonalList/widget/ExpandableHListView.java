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
    private static final int[] azR = {16842920};
    private static final int[] azS = {16842921};
    private static final int[] azT = {16842920, 16842921};
    private static final int[][] azU = {EMPTY_STATE_SET, azR, azS, azT};
    private static final int[] azV = {16842918};
    private int aAa;
    private int aAb;
    private ExpandableListAdapter azJ;
    private int azK;
    private int azL;
    private int azM;
    private int azN;
    private int azO;
    private Drawable azP;
    private Drawable azQ;
    private Drawable azW;
    private final Rect azX;
    private int azY;
    private int azZ;
    private ExpandableHListConnector hjG;
    private d hjH;
    private e hjI;
    private c hjJ;
    private b hjK;
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
        this.azX = new Rect();
        this.mTempRect = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandableHListView, i, 0);
        setGroupIndicator(obtainStyledAttributes.getDrawable(5));
        setChildIndicator(obtainStyledAttributes.getDrawable(1));
        this.mIndicatorLeft = obtainStyledAttributes.getDimensionPixelSize(7, 0);
        this.azK = obtainStyledAttributes.getDimensionPixelSize(8, 0);
        this.azL = obtainStyledAttributes.getInt(2, 0);
        this.azM = obtainStyledAttributes.getInt(3, 0);
        this.azO = obtainStyledAttributes.getDimensionPixelSize(6, 0);
        this.azN = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.azW = obtainStyledAttributes.getDrawable(4);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        zQ();
        zR();
    }

    private void zQ() {
        if (this.azP != null) {
            this.azY = this.azP.getIntrinsicWidth();
            this.azZ = this.azP.getIntrinsicHeight();
            return;
        }
        this.azY = 0;
        this.azZ = 0;
    }

    private void zR() {
        if (this.azQ != null) {
            this.aAa = this.azQ.getIntrinsicWidth();
            this.aAb = this.azQ.getIntrinsicHeight();
            return;
        }
        this.aAa = 0;
        this.aAb = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.azQ != null || this.azP != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.mItemCount - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            Rect rect = this.azX;
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
                            ExpandableHListConnector.b vx = this.hjG.vx(i4);
                            if (vx.hjE.type != i2) {
                                if (vx.hjE.type == 1) {
                                    rect.top = childAt.getTop() + this.azN;
                                    rect.bottom = childAt.getBottom() + this.azN;
                                } else {
                                    rect.top = childAt.getTop() + this.azK;
                                    rect.bottom = childAt.getBottom() + this.azK;
                                }
                                i2 = vx.hjE.type;
                            }
                            if (rect.top != rect.bottom) {
                                if (vx.hjE.type == 1) {
                                    rect.left = this.azO + left;
                                    rect.right = this.azO + right2;
                                } else {
                                    rect.left = this.mIndicatorLeft + left;
                                    rect.right = this.mIndicatorLeft + right2;
                                }
                                Drawable c2 = c(vx);
                                if (c2 != null) {
                                    if (vx.hjE.type == 1) {
                                        Gravity.apply(this.azM, this.aAa, this.aAb, rect, this.mTempRect);
                                    } else {
                                        Gravity.apply(this.azL, this.azY, this.azZ, rect, this.mTempRect);
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
        if (bVar.hjE.type == 2) {
            Drawable drawable = this.azP;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            drawable.setState(azU[(bVar.zN() ? (char) 1 : (char) 0) | (bVar.hjF == null || bVar.hjF.azx == bVar.hjF.azw ? (char) 2 : (char) 0)]);
            return drawable;
        }
        Drawable drawable2 = this.azQ;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(bVar.hjE.azH == bVar.hjF.azx ? azV : EMPTY_STATE_SET);
        }
        return drawable2;
    }

    public void setChildDivider(Drawable drawable) {
        this.azW = drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tieba.horizonalList.widget.HListView
    public void drawDivider(Canvas canvas, Rect rect, int i) {
        int i2 = this.mFirstPosition + i;
        if (i2 >= 0) {
            ExpandableHListConnector.b vx = this.hjG.vx(cy(i2));
            if (vx.hjE.type == 1 || (vx.zN() && vx.hjF.azx != vx.hjF.azw)) {
                Drawable drawable = this.azW;
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
        this.azJ = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.hjG = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.hjG = null;
        }
        super.setAdapter((ListAdapter) this.hjG);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.azJ;
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
        ExpandableHListConnector.b vx = this.hjG.vx(i);
        long b2 = b(vx.hjE);
        if (vx.hjE.type == 2) {
            if (this.hjJ != null && this.hjJ.a(this, view, vx.hjE.azF, b2)) {
                vx.recycle();
                return true;
            }
            if (vx.zN()) {
                this.hjG.a(vx);
                playSoundEffect(0);
                if (this.hjH != null) {
                    this.hjH.cB(vx.hjE.azF);
                }
            } else {
                this.hjG.b(vx);
                playSoundEffect(0);
                if (this.hjI != null) {
                    this.hjI.cC(vx.hjE.azF);
                }
                int i2 = vx.hjE.azF;
                int headerViewsCount = vx.hjE.azH + getHeaderViewsCount();
                smoothScrollToPosition(this.azJ.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.hjK != null) {
            playSoundEffect(0);
            return this.hjK.a(this, view, vx.hjE.azF, vx.hjE.azG, b2);
        } else {
            z = false;
        }
        vx.recycle();
        return z;
    }

    public void setOnGroupCollapseListener(d dVar) {
        this.hjH = dVar;
    }

    public void setOnGroupExpandListener(e eVar) {
        this.hjI = eVar;
    }

    public void setOnGroupClickListener(c cVar) {
        this.hjJ = cVar;
    }

    public void setOnChildClickListener(b bVar) {
        this.hjK = bVar;
    }

    public long cA(int i) {
        if (isHeaderOrFooterPosition(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b vx = this.hjG.vx(cy(i));
        long zO = vx.hjE.zO();
        vx.recycle();
        return zO;
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
            return this.azJ.getGroupId(K);
        }
        return this.azJ.getChildId(K, L(selectedPosition));
    }

    public void setSelectedGroup(int i) {
        com.baidu.tieba.horizonalList.widget.a vz = com.baidu.tieba.horizonalList.widget.a.vz(i);
        ExpandableHListConnector.b a2 = this.hjG.a(vz);
        vz.recycle();
        super.setSelection(cz(a2.hjE.azH));
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
        ExpandableHListConnector.b vx = this.hjG.vx(cy(i));
        com.baidu.tieba.horizonalList.widget.a aVar = vx.hjE;
        long b2 = b(aVar);
        long zO = aVar.zO();
        vx.recycle();
        return new a(view, zO, b2);
    }

    private long b(com.baidu.tieba.horizonalList.widget.a aVar) {
        return aVar.type == 1 ? this.azJ.getChildId(aVar.azF, aVar.azG) : this.azJ.getGroupId(aVar.azF);
    }

    public void setChildIndicator(Drawable drawable) {
        this.azQ = drawable;
        zR();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.azP = drawable;
        zQ();
    }

    /* loaded from: classes.dex */
    public static class a implements ContextMenu.ContextMenuInfo {
        public long aAg;
        public long id;
        public View targetView;

        public a(View view, long j, long j2) {
            this.targetView = view;
            this.aAg = j;
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
        ArrayList<ExpandableHListConnector.GroupMetadata> aAh;

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.aAh = arrayList;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.aAh = new ArrayList<>();
            parcel.readList(this.aAh, ExpandableHListConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.aAh);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.hjG != null ? this.hjG.zL() : null);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.hjG != null && savedState.aAh != null) {
            this.hjG.k(savedState.aAh);
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
