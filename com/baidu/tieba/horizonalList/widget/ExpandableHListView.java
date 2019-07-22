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
    private static final int[] gpF = {16842920};
    private static final int[] gpG = {16842921};
    private static final int[] gpH = {16842920, 16842921};
    private static final int[][] gpI = {EMPTY_STATE_SET, gpF, gpG, gpH};
    private static final int[] gpJ = {16842918};
    private int gpA;
    private int gpB;
    private int gpC;
    private Drawable gpD;
    private Drawable gpE;
    private Drawable gpK;
    private final Rect gpL;
    private int gpM;
    private int gpN;
    private int gpO;
    private int gpP;
    private d gpQ;
    private e gpR;
    private c gpS;
    private b gpT;
    private ExpandableHListConnector gpw;
    private ExpandableListAdapter gpx;
    private int gpy;
    private int gpz;
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
        void uy(int i);
    }

    /* loaded from: classes.dex */
    public interface e {
        void uz(int i);
    }

    public ExpandableHListView(Context context) {
        this(context, null);
    }

    public ExpandableHListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.hlv_expandableListViewStyle);
    }

    public ExpandableHListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gpL = new Rect();
        this.mTempRect = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.a.ExpandableHListView, i, 0);
        setGroupIndicator(obtainStyledAttributes.getDrawable(5));
        setChildIndicator(obtainStyledAttributes.getDrawable(1));
        this.mIndicatorLeft = obtainStyledAttributes.getDimensionPixelSize(7, 0);
        this.gpy = obtainStyledAttributes.getDimensionPixelSize(8, 0);
        this.gpz = obtainStyledAttributes.getInt(2, 0);
        this.gpA = obtainStyledAttributes.getInt(3, 0);
        this.gpC = obtainStyledAttributes.getDimensionPixelSize(6, 0);
        this.gpB = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.gpK = obtainStyledAttributes.getDrawable(4);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        bxS();
        bxT();
    }

    private void bxS() {
        if (this.gpD != null) {
            this.gpM = this.gpD.getIntrinsicWidth();
            this.gpN = this.gpD.getIntrinsicHeight();
            return;
        }
        this.gpM = 0;
        this.gpN = 0;
    }

    private void bxT() {
        if (this.gpE != null) {
            this.gpO = this.gpE.getIntrinsicWidth();
            this.gpP = this.gpE.getIntrinsicHeight();
            return;
        }
        this.gpO = 0;
        this.gpP = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.gpE != null || this.gpD != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.mItemCount - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            Rect rect = this.gpL;
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
                            ExpandableHListConnector.b ur = this.gpw.ur(i4);
                            if (ur.gpq.type != i2) {
                                if (ur.gpq.type == 1) {
                                    rect.top = childAt.getTop() + this.gpB;
                                    rect.bottom = childAt.getBottom() + this.gpB;
                                } else {
                                    rect.top = childAt.getTop() + this.gpy;
                                    rect.bottom = childAt.getBottom() + this.gpy;
                                }
                                i2 = ur.gpq.type;
                            }
                            if (rect.top != rect.bottom) {
                                if (ur.gpq.type == 1) {
                                    rect.left = this.gpC + left;
                                    rect.right = this.gpC + right2;
                                } else {
                                    rect.left = this.mIndicatorLeft + left;
                                    rect.right = this.mIndicatorLeft + right2;
                                }
                                Drawable c2 = c(ur);
                                if (c2 != null) {
                                    if (ur.gpq.type == 1) {
                                        Gravity.apply(this.gpA, this.gpO, this.gpP, rect, this.mTempRect);
                                    } else {
                                        Gravity.apply(this.gpz, this.gpM, this.gpN, rect, this.mTempRect);
                                    }
                                    c2.setBounds(this.mTempRect);
                                    c2.draw(canvas);
                                }
                            }
                            ur.recycle();
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
        if (bVar.gpq.type == 2) {
            Drawable drawable = this.gpD;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            drawable.setState(gpI[(bVar.bjn() ? (char) 1 : (char) 0) | (bVar.gpr == null || bVar.gpr.gpl == bVar.gpr.gpk ? (char) 2 : (char) 0)]);
            return drawable;
        }
        Drawable drawable2 = this.gpE;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(bVar.gpq.gpv == bVar.gpr.gpl ? gpJ : EMPTY_STATE_SET);
        }
        return drawable2;
    }

    public void setChildDivider(Drawable drawable) {
        this.gpK = drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tieba.horizonalList.widget.HListView
    public void drawDivider(Canvas canvas, Rect rect, int i) {
        int i2 = this.mFirstPosition + i;
        if (i2 >= 0) {
            ExpandableHListConnector.b ur = this.gpw.ur(uv(i2));
            if (ur.gpq.type == 1 || (ur.bjn() && ur.gpr.gpl != ur.gpr.gpk)) {
                Drawable drawable = this.gpK;
                drawable.setBounds(rect);
                drawable.draw(canvas);
                ur.recycle();
                return;
            }
            ur.recycle();
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
        this.gpx = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.gpw = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.gpw = null;
        }
        super.setAdapter((ListAdapter) this.gpw);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.gpx;
    }

    private boolean isHeaderOrFooterPosition(int i) {
        return i < getHeaderViewsCount() || i >= this.mItemCount - getFooterViewsCount();
    }

    private int uv(int i) {
        return i - getHeaderViewsCount();
    }

    private int uw(int i) {
        return getHeaderViewsCount() + i;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.AdapterView
    public boolean performItemClick(View view, int i, long j) {
        if (isHeaderOrFooterPosition(i)) {
            return super.performItemClick(view, i, j);
        }
        return d(view, uv(i), j);
    }

    boolean d(View view, int i, long j) {
        boolean z;
        ExpandableHListConnector.b ur = this.gpw.ur(i);
        long b2 = b(ur.gpq);
        if (ur.gpq.type == 2) {
            if (this.gpS != null && this.gpS.a(this, view, ur.gpq.gpt, b2)) {
                ur.recycle();
                return true;
            }
            if (ur.bjn()) {
                this.gpw.a(ur);
                playSoundEffect(0);
                if (this.gpQ != null) {
                    this.gpQ.uy(ur.gpq.gpt);
                }
            } else {
                this.gpw.b(ur);
                playSoundEffect(0);
                if (this.gpR != null) {
                    this.gpR.uz(ur.gpq.gpt);
                }
                int i2 = ur.gpq.gpt;
                int headerViewsCount = ur.gpq.gpv + getHeaderViewsCount();
                smoothScrollToPosition(this.gpx.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.gpT != null) {
            playSoundEffect(0);
            return this.gpT.a(this, view, ur.gpq.gpt, ur.gpq.gpu, b2);
        } else {
            z = false;
        }
        ur.recycle();
        return z;
    }

    public void setOnGroupCollapseListener(d dVar) {
        this.gpQ = dVar;
    }

    public void setOnGroupExpandListener(e eVar) {
        this.gpR = eVar;
    }

    public void setOnGroupClickListener(c cVar) {
        this.gpS = cVar;
    }

    public void setOnChildClickListener(b bVar) {
        this.gpT = bVar;
    }

    public long ux(int i) {
        if (isHeaderOrFooterPosition(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b ur = this.gpw.ur(uv(i));
        long bxQ = ur.gpq.bxQ();
        ur.recycle();
        return bxQ;
    }

    public long getSelectedPosition() {
        return ux(getSelectedItemPosition());
    }

    public long getSelectedId() {
        long selectedPosition = getSelectedPosition();
        if (selectedPosition == 4294967295L) {
            return -1L;
        }
        int du = du(selectedPosition);
        if (dt(selectedPosition) == 0) {
            return this.gpx.getGroupId(du);
        }
        return this.gpx.getChildId(du, dv(selectedPosition));
    }

    public void setSelectedGroup(int i) {
        com.baidu.tieba.horizonalList.widget.a uu = com.baidu.tieba.horizonalList.widget.a.uu(i);
        ExpandableHListConnector.b a2 = this.gpw.a(uu);
        uu.recycle();
        super.setSelection(uw(a2.gpq.gpv));
        a2.recycle();
    }

    public static int dt(long j) {
        if (j == 4294967295L) {
            return 2;
        }
        return (j & Long.MIN_VALUE) == Long.MIN_VALUE ? 1 : 0;
    }

    public static int du(long j) {
        if (j == 4294967295L) {
            return -1;
        }
        return (int) ((9223372032559808512L & j) >> 32);
    }

    public static int dv(long j) {
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
        ExpandableHListConnector.b ur = this.gpw.ur(uv(i));
        com.baidu.tieba.horizonalList.widget.a aVar = ur.gpq;
        long b2 = b(aVar);
        long bxQ = aVar.bxQ();
        ur.recycle();
        return new a(view, bxQ, b2);
    }

    private long b(com.baidu.tieba.horizonalList.widget.a aVar) {
        return aVar.type == 1 ? this.gpx.getChildId(aVar.gpt, aVar.gpu) : this.gpx.getGroupId(aVar.gpt);
    }

    public void setChildIndicator(Drawable drawable) {
        this.gpE = drawable;
        bxT();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.gpD = drawable;
        bxS();
    }

    /* loaded from: classes.dex */
    public static class a implements ContextMenu.ContextMenuInfo {
        public View aMO;
        public long gpU;
        public long id;

        public a(View view, long j, long j2) {
            this.aMO = view;
            this.gpU = j;
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
            /* renamed from: uA */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        ArrayList<ExpandableHListConnector.GroupMetadata> gpV;

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.gpV = arrayList;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.gpV = new ArrayList<>();
            parcel.readList(this.gpV, ExpandableHListConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.gpV);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.gpw != null ? this.gpw.bxO() : null);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.gpw != null && savedState.gpV != null) {
            this.gpw.af(savedState.gpV);
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
