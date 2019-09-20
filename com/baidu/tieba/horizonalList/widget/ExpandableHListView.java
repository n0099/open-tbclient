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
import com.baidu.tieba.d;
import com.baidu.tieba.horizonalList.widget.AdapterView;
import com.baidu.tieba.horizonalList.widget.ExpandableHListConnector;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ExpandableHListView extends HListView {
    private static final int[] EMPTY_STATE_SET = new int[0];
    private static final int[] gso = {16842920};
    private static final int[] gsp = {16842921};
    private static final int[] gsq = {16842920, 16842921};
    private static final int[][] gsr = {EMPTY_STATE_SET, gso, gsp, gsq};
    private static final int[] gss = {16842918};
    private e gsA;
    private c gsB;
    private b gsC;
    private ExpandableHListConnector gsf;
    private ExpandableListAdapter gsg;
    private int gsh;
    private int gsi;
    private int gsj;
    private int gsk;
    private int gsl;
    private Drawable gsm;
    private Drawable gsn;
    private Drawable gst;
    private final Rect gsu;
    private int gsv;
    private int gsw;
    private int gsx;
    private int gsy;
    private d gsz;
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
        void uE(int i);
    }

    /* loaded from: classes.dex */
    public interface e {
        void uF(int i);
    }

    public ExpandableHListView(Context context) {
        this(context, null);
    }

    public ExpandableHListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.hlv_expandableListViewStyle);
    }

    public ExpandableHListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gsu = new Rect();
        this.mTempRect = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.a.ExpandableHListView, i, 0);
        setGroupIndicator(obtainStyledAttributes.getDrawable(5));
        setChildIndicator(obtainStyledAttributes.getDrawable(1));
        this.mIndicatorLeft = obtainStyledAttributes.getDimensionPixelSize(7, 0);
        this.gsh = obtainStyledAttributes.getDimensionPixelSize(8, 0);
        this.gsi = obtainStyledAttributes.getInt(2, 0);
        this.gsj = obtainStyledAttributes.getInt(3, 0);
        this.gsl = obtainStyledAttributes.getDimensionPixelSize(6, 0);
        this.gsk = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.gst = obtainStyledAttributes.getDrawable(4);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        byU();
        byV();
    }

    private void byU() {
        if (this.gsm != null) {
            this.gsv = this.gsm.getIntrinsicWidth();
            this.gsw = this.gsm.getIntrinsicHeight();
            return;
        }
        this.gsv = 0;
        this.gsw = 0;
    }

    private void byV() {
        if (this.gsn != null) {
            this.gsx = this.gsn.getIntrinsicWidth();
            this.gsy = this.gsn.getIntrinsicHeight();
            return;
        }
        this.gsx = 0;
        this.gsy = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.gsn != null || this.gsm != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.mItemCount - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            Rect rect = this.gsu;
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
                            ExpandableHListConnector.b ux = this.gsf.ux(i4);
                            if (ux.grZ.type != i2) {
                                if (ux.grZ.type == 1) {
                                    rect.top = childAt.getTop() + this.gsk;
                                    rect.bottom = childAt.getBottom() + this.gsk;
                                } else {
                                    rect.top = childAt.getTop() + this.gsh;
                                    rect.bottom = childAt.getBottom() + this.gsh;
                                }
                                i2 = ux.grZ.type;
                            }
                            if (rect.top != rect.bottom) {
                                if (ux.grZ.type == 1) {
                                    rect.left = this.gsl + left;
                                    rect.right = this.gsl + right2;
                                } else {
                                    rect.left = this.mIndicatorLeft + left;
                                    rect.right = this.mIndicatorLeft + right2;
                                }
                                Drawable c2 = c(ux);
                                if (c2 != null) {
                                    if (ux.grZ.type == 1) {
                                        Gravity.apply(this.gsj, this.gsx, this.gsy, rect, this.mTempRect);
                                    } else {
                                        Gravity.apply(this.gsi, this.gsv, this.gsw, rect, this.mTempRect);
                                    }
                                    c2.setBounds(this.mTempRect);
                                    c2.draw(canvas);
                                }
                            }
                            ux.recycle();
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
        if (bVar.grZ.type == 2) {
            Drawable drawable = this.gsm;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            drawable.setState(gsr[(bVar.bkf() ? (char) 1 : (char) 0) | (bVar.gsa == null || bVar.gsa.grU == bVar.gsa.grT ? (char) 2 : (char) 0)]);
            return drawable;
        }
        Drawable drawable2 = this.gsn;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(bVar.grZ.gse == bVar.gsa.grU ? gss : EMPTY_STATE_SET);
        }
        return drawable2;
    }

    public void setChildDivider(Drawable drawable) {
        this.gst = drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tieba.horizonalList.widget.HListView
    public void drawDivider(Canvas canvas, Rect rect, int i) {
        int i2 = this.mFirstPosition + i;
        if (i2 >= 0) {
            ExpandableHListConnector.b ux = this.gsf.ux(uB(i2));
            if (ux.grZ.type == 1 || (ux.bkf() && ux.gsa.grU != ux.gsa.grT)) {
                Drawable drawable = this.gst;
                drawable.setBounds(rect);
                drawable.draw(canvas);
                ux.recycle();
                return;
            }
            ux.recycle();
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
        this.gsg = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.gsf = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.gsf = null;
        }
        super.setAdapter((ListAdapter) this.gsf);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.gsg;
    }

    private boolean isHeaderOrFooterPosition(int i) {
        return i < getHeaderViewsCount() || i >= this.mItemCount - getFooterViewsCount();
    }

    private int uB(int i) {
        return i - getHeaderViewsCount();
    }

    private int uC(int i) {
        return getHeaderViewsCount() + i;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.AdapterView
    public boolean performItemClick(View view, int i, long j) {
        if (isHeaderOrFooterPosition(i)) {
            return super.performItemClick(view, i, j);
        }
        return d(view, uB(i), j);
    }

    boolean d(View view, int i, long j) {
        boolean z;
        ExpandableHListConnector.b ux = this.gsf.ux(i);
        long b2 = b(ux.grZ);
        if (ux.grZ.type == 2) {
            if (this.gsB != null && this.gsB.a(this, view, ux.grZ.gsc, b2)) {
                ux.recycle();
                return true;
            }
            if (ux.bkf()) {
                this.gsf.a(ux);
                playSoundEffect(0);
                if (this.gsz != null) {
                    this.gsz.uE(ux.grZ.gsc);
                }
            } else {
                this.gsf.b(ux);
                playSoundEffect(0);
                if (this.gsA != null) {
                    this.gsA.uF(ux.grZ.gsc);
                }
                int i2 = ux.grZ.gsc;
                int headerViewsCount = ux.grZ.gse + getHeaderViewsCount();
                smoothScrollToPosition(this.gsg.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.gsC != null) {
            playSoundEffect(0);
            return this.gsC.a(this, view, ux.grZ.gsc, ux.grZ.gsd, b2);
        } else {
            z = false;
        }
        ux.recycle();
        return z;
    }

    public void setOnGroupCollapseListener(d dVar) {
        this.gsz = dVar;
    }

    public void setOnGroupExpandListener(e eVar) {
        this.gsA = eVar;
    }

    public void setOnGroupClickListener(c cVar) {
        this.gsB = cVar;
    }

    public void setOnChildClickListener(b bVar) {
        this.gsC = bVar;
    }

    public long uD(int i) {
        if (isHeaderOrFooterPosition(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b ux = this.gsf.ux(uB(i));
        long byS = ux.grZ.byS();
        ux.recycle();
        return byS;
    }

    public long getSelectedPosition() {
        return uD(getSelectedItemPosition());
    }

    public long getSelectedId() {
        long selectedPosition = getSelectedPosition();
        if (selectedPosition == 4294967295L) {
            return -1L;
        }
        int dx = dx(selectedPosition);
        if (dw(selectedPosition) == 0) {
            return this.gsg.getGroupId(dx);
        }
        return this.gsg.getChildId(dx, dy(selectedPosition));
    }

    public void setSelectedGroup(int i) {
        com.baidu.tieba.horizonalList.widget.a uA = com.baidu.tieba.horizonalList.widget.a.uA(i);
        ExpandableHListConnector.b a2 = this.gsf.a(uA);
        uA.recycle();
        super.setSelection(uC(a2.grZ.gse));
        a2.recycle();
    }

    public static int dw(long j) {
        if (j == 4294967295L) {
            return 2;
        }
        return (j & Long.MIN_VALUE) == Long.MIN_VALUE ? 1 : 0;
    }

    public static int dx(long j) {
        if (j == 4294967295L) {
            return -1;
        }
        return (int) ((9223372032559808512L & j) >> 32);
    }

    public static int dy(long j) {
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
        ExpandableHListConnector.b ux = this.gsf.ux(uB(i));
        com.baidu.tieba.horizonalList.widget.a aVar = ux.grZ;
        long b2 = b(aVar);
        long byS = aVar.byS();
        ux.recycle();
        return new a(view, byS, b2);
    }

    private long b(com.baidu.tieba.horizonalList.widget.a aVar) {
        return aVar.type == 1 ? this.gsg.getChildId(aVar.gsc, aVar.gsd) : this.gsg.getGroupId(aVar.gsc);
    }

    public void setChildIndicator(Drawable drawable) {
        this.gsn = drawable;
        byV();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.gsm = drawable;
        byU();
    }

    /* loaded from: classes.dex */
    public static class a implements ContextMenu.ContextMenuInfo {
        public View aNm;
        public long gsD;
        public long id;

        public a(View view, long j, long j2) {
            this.aNm = view;
            this.gsD = j;
            this.id = j2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.tieba.horizonalList.widget.ExpandableHListView.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: P */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: uG */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        ArrayList<ExpandableHListConnector.GroupMetadata> gsE;

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.gsE = arrayList;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.gsE = new ArrayList<>();
            parcel.readList(this.gsE, ExpandableHListConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.gsE);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.gsf != null ? this.gsf.byQ() : null);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.gsf != null && savedState.gsE != null) {
            this.gsf.af(savedState.gsE);
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
