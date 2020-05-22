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
    private static final int[] bbh = {16842920};
    private static final int[] bbi = {16842921};
    private static final int[] bbj = {16842920, 16842921};
    private static final int[][] bbk = {EMPTY_STATE_SET, bbh, bbi, bbj};
    private static final int[] bbl = {16842918};
    private ExpandableListAdapter baZ;
    private int bba;
    private int bbb;
    private int bbc;
    private int bbd;
    private int bbe;
    private Drawable bbf;
    private Drawable bbg;
    private Drawable bbm;
    private final Rect bbn;
    private int bbo;
    private int bbp;
    private int bbq;
    private int bbr;
    private ExpandableHListConnector ijU;
    private d ijV;
    private e ijW;
    private c ijX;
    private b ijY;
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
        void cX(int i);
    }

    /* loaded from: classes.dex */
    public interface e {
        void cY(int i);
    }

    public ExpandableHListView(Context context) {
        this(context, null);
    }

    public ExpandableHListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.hlv_expandableListViewStyle);
    }

    public ExpandableHListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bbn = new Rect();
        this.mTempRect = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandableHListView, i, 0);
        setGroupIndicator(obtainStyledAttributes.getDrawable(5));
        setChildIndicator(obtainStyledAttributes.getDrawable(1));
        this.mIndicatorLeft = obtainStyledAttributes.getDimensionPixelSize(7, 0);
        this.bba = obtainStyledAttributes.getDimensionPixelSize(8, 0);
        this.bbb = obtainStyledAttributes.getInt(2, 0);
        this.bbc = obtainStyledAttributes.getInt(3, 0);
        this.bbe = obtainStyledAttributes.getDimensionPixelSize(6, 0);
        this.bbd = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.bbm = obtainStyledAttributes.getDrawable(4);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        GN();
        GO();
    }

    private void GN() {
        if (this.bbf != null) {
            this.bbo = this.bbf.getIntrinsicWidth();
            this.bbp = this.bbf.getIntrinsicHeight();
            return;
        }
        this.bbo = 0;
        this.bbp = 0;
    }

    private void GO() {
        if (this.bbg != null) {
            this.bbq = this.bbg.getIntrinsicWidth();
            this.bbr = this.bbg.getIntrinsicHeight();
            return;
        }
        this.bbq = 0;
        this.bbr = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.bbg != null || this.bbf != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.mItemCount - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            Rect rect = this.bbn;
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
                            ExpandableHListConnector.b wJ = this.ijU.wJ(i4);
                            if (wJ.ijS.type != i2) {
                                if (wJ.ijS.type == 1) {
                                    rect.top = childAt.getTop() + this.bbd;
                                    rect.bottom = childAt.getBottom() + this.bbd;
                                } else {
                                    rect.top = childAt.getTop() + this.bba;
                                    rect.bottom = childAt.getBottom() + this.bba;
                                }
                                i2 = wJ.ijS.type;
                            }
                            if (rect.top != rect.bottom) {
                                if (wJ.ijS.type == 1) {
                                    rect.left = this.bbe + left;
                                    rect.right = this.bbe + right2;
                                } else {
                                    rect.left = this.mIndicatorLeft + left;
                                    rect.right = this.mIndicatorLeft + right2;
                                }
                                Drawable c2 = c(wJ);
                                if (c2 != null) {
                                    if (wJ.ijS.type == 1) {
                                        Gravity.apply(this.bbc, this.bbq, this.bbr, rect, this.mTempRect);
                                    } else {
                                        Gravity.apply(this.bbb, this.bbo, this.bbp, rect, this.mTempRect);
                                    }
                                    c2.setBounds(this.mTempRect);
                                    c2.draw(canvas);
                                }
                            }
                            wJ.recycle();
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
        if (bVar.ijS.type == 2) {
            Drawable drawable = this.bbf;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            drawable.setState(bbk[(bVar.GK() ? (char) 1 : (char) 0) | (bVar.ijT == null || bVar.ijT.baN == bVar.ijT.baM ? (char) 2 : (char) 0)]);
            return drawable;
        }
        Drawable drawable2 = this.bbg;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(bVar.ijS.baX == bVar.ijT.baN ? bbl : EMPTY_STATE_SET);
        }
        return drawable2;
    }

    public void setChildDivider(Drawable drawable) {
        this.bbm = drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tieba.horizonalList.widget.HListView
    public void drawDivider(Canvas canvas, Rect rect, int i) {
        int i2 = this.mFirstPosition + i;
        if (i2 >= 0) {
            ExpandableHListConnector.b wJ = this.ijU.wJ(cU(i2));
            if (wJ.ijS.type == 1 || (wJ.GK() && wJ.ijT.baN != wJ.ijT.baM)) {
                Drawable drawable = this.bbm;
                drawable.setBounds(rect);
                drawable.draw(canvas);
                wJ.recycle();
                return;
            }
            wJ.recycle();
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
        this.baZ = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.ijU = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.ijU = null;
        }
        super.setAdapter((ListAdapter) this.ijU);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.baZ;
    }

    private boolean isHeaderOrFooterPosition(int i) {
        return i < getHeaderViewsCount() || i >= this.mItemCount - getFooterViewsCount();
    }

    private int cU(int i) {
        return i - getHeaderViewsCount();
    }

    private int cV(int i) {
        return getHeaderViewsCount() + i;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.AdapterView
    public boolean performItemClick(View view, int i, long j) {
        if (isHeaderOrFooterPosition(i)) {
            return super.performItemClick(view, i, j);
        }
        return a(view, cU(i), j);
    }

    boolean a(View view, int i, long j) {
        boolean z;
        ExpandableHListConnector.b wJ = this.ijU.wJ(i);
        long b2 = b(wJ.ijS);
        if (wJ.ijS.type == 2) {
            if (this.ijX != null && this.ijX.a(this, view, wJ.ijS.baV, b2)) {
                wJ.recycle();
                return true;
            }
            if (wJ.GK()) {
                this.ijU.a(wJ);
                playSoundEffect(0);
                if (this.ijV != null) {
                    this.ijV.cX(wJ.ijS.baV);
                }
            } else {
                this.ijU.b(wJ);
                playSoundEffect(0);
                if (this.ijW != null) {
                    this.ijW.cY(wJ.ijS.baV);
                }
                int i2 = wJ.ijS.baV;
                int headerViewsCount = wJ.ijS.baX + getHeaderViewsCount();
                smoothScrollToPosition(this.baZ.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.ijY != null) {
            playSoundEffect(0);
            return this.ijY.a(this, view, wJ.ijS.baV, wJ.ijS.baW, b2);
        } else {
            z = false;
        }
        wJ.recycle();
        return z;
    }

    public void setOnGroupCollapseListener(d dVar) {
        this.ijV = dVar;
    }

    public void setOnGroupExpandListener(e eVar) {
        this.ijW = eVar;
    }

    public void setOnGroupClickListener(c cVar) {
        this.ijX = cVar;
    }

    public void setOnChildClickListener(b bVar) {
        this.ijY = bVar;
    }

    public long cW(int i) {
        if (isHeaderOrFooterPosition(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b wJ = this.ijU.wJ(cU(i));
        long GL = wJ.ijS.GL();
        wJ.recycle();
        return GL;
    }

    public long getSelectedPosition() {
        return cW(getSelectedItemPosition());
    }

    public long getSelectedId() {
        long selectedPosition = getSelectedPosition();
        if (selectedPosition == 4294967295L) {
            return -1L;
        }
        int ar = ar(selectedPosition);
        if (aq(selectedPosition) == 0) {
            return this.baZ.getGroupId(ar);
        }
        return this.baZ.getChildId(ar, as(selectedPosition));
    }

    public void setSelectedGroup(int i) {
        com.baidu.tieba.horizonalList.widget.a wL = com.baidu.tieba.horizonalList.widget.a.wL(i);
        ExpandableHListConnector.b a2 = this.ijU.a(wL);
        wL.recycle();
        super.setSelection(cV(a2.ijS.baX));
        a2.recycle();
    }

    public static int aq(long j) {
        if (j == 4294967295L) {
            return 2;
        }
        return (j & Long.MIN_VALUE) == Long.MIN_VALUE ? 1 : 0;
    }

    public static int ar(long j) {
        if (j == 4294967295L) {
            return -1;
        }
        return (int) ((9223372032559808512L & j) >> 32);
    }

    public static int as(long j) {
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
        ExpandableHListConnector.b wJ = this.ijU.wJ(cU(i));
        com.baidu.tieba.horizonalList.widget.a aVar = wJ.ijS;
        long b2 = b(aVar);
        long GL = aVar.GL();
        wJ.recycle();
        return new a(view, GL, b2);
    }

    private long b(com.baidu.tieba.horizonalList.widget.a aVar) {
        return aVar.type == 1 ? this.baZ.getChildId(aVar.baV, aVar.baW) : this.baZ.getGroupId(aVar.baV);
    }

    public void setChildIndicator(Drawable drawable) {
        this.bbg = drawable;
        GO();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.bbf = drawable;
        GN();
    }

    /* loaded from: classes.dex */
    public static class a implements ContextMenu.ContextMenuInfo {
        public long bbw;
        public long id;
        public View targetView;

        public a(View view, long j, long j2) {
            this.targetView = view;
            this.bbw = j;
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
            /* renamed from: wM */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        ArrayList<ExpandableHListConnector.GroupMetadata> bbx;

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.bbx = arrayList;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.bbx = new ArrayList<>();
            parcel.readList(this.bbx, ExpandableHListConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.bbx);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.ijU != null ? this.ijU.GI() : null);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.ijU != null && savedState.bbx != null) {
            this.ijU.k(savedState.bbx);
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
