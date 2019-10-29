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
    private static final int[] anj = {16842920};
    private static final int[] ank = {16842921};
    private static final int[] anl = {16842920, 16842921};
    private static final int[][] anm = {EMPTY_STATE_SET, anj, ank, anl};
    private static final int[] ann = {16842918};
    private ExpandableListAdapter anb;
    private int anc;
    private int and;
    private int ane;
    private int anf;
    private int ang;
    private Drawable anh;
    private Drawable ani;
    private Drawable ano;
    private final Rect anp;
    private int anq;
    private int anr;
    private int ans;
    private int ant;
    private ExpandableHListConnector gqQ;
    private d gqR;
    private e gqS;
    private c gqT;
    private b gqU;
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
        void bS(int i);
    }

    /* loaded from: classes.dex */
    public interface e {
        void bT(int i);
    }

    public ExpandableHListView(Context context) {
        this(context, null);
    }

    public ExpandableHListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.hlv_expandableListViewStyle);
    }

    public ExpandableHListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.anp = new Rect();
        this.mTempRect = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandableHListView, i, 0);
        setGroupIndicator(obtainStyledAttributes.getDrawable(5));
        setChildIndicator(obtainStyledAttributes.getDrawable(1));
        this.mIndicatorLeft = obtainStyledAttributes.getDimensionPixelSize(7, 0);
        this.anc = obtainStyledAttributes.getDimensionPixelSize(8, 0);
        this.and = obtainStyledAttributes.getInt(2, 0);
        this.ane = obtainStyledAttributes.getInt(3, 0);
        this.ang = obtainStyledAttributes.getDimensionPixelSize(6, 0);
        this.anf = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.ano = obtainStyledAttributes.getDrawable(4);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        vk();
        vl();
    }

    private void vk() {
        if (this.anh != null) {
            this.anq = this.anh.getIntrinsicWidth();
            this.anr = this.anh.getIntrinsicHeight();
            return;
        }
        this.anq = 0;
        this.anr = 0;
    }

    private void vl() {
        if (this.ani != null) {
            this.ans = this.ani.getIntrinsicWidth();
            this.ant = this.ani.getIntrinsicHeight();
            return;
        }
        this.ans = 0;
        this.ant = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.ani != null || this.anh != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.mItemCount - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            Rect rect = this.anp;
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
                            ExpandableHListConnector.b tl = this.gqQ.tl(i4);
                            if (tl.gqO.type != i2) {
                                if (tl.gqO.type == 1) {
                                    rect.top = childAt.getTop() + this.anf;
                                    rect.bottom = childAt.getBottom() + this.anf;
                                } else {
                                    rect.top = childAt.getTop() + this.anc;
                                    rect.bottom = childAt.getBottom() + this.anc;
                                }
                                i2 = tl.gqO.type;
                            }
                            if (rect.top != rect.bottom) {
                                if (tl.gqO.type == 1) {
                                    rect.left = this.ang + left;
                                    rect.right = this.ang + right2;
                                } else {
                                    rect.left = this.mIndicatorLeft + left;
                                    rect.right = this.mIndicatorLeft + right2;
                                }
                                Drawable c2 = c(tl);
                                if (c2 != null) {
                                    if (tl.gqO.type == 1) {
                                        Gravity.apply(this.ane, this.ans, this.ant, rect, this.mTempRect);
                                    } else {
                                        Gravity.apply(this.and, this.anq, this.anr, rect, this.mTempRect);
                                    }
                                    c2.setBounds(this.mTempRect);
                                    c2.draw(canvas);
                                }
                            }
                            tl.recycle();
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
        if (bVar.gqO.type == 2) {
            Drawable drawable = this.anh;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            drawable.setState(anm[(bVar.vh() ? (char) 1 : (char) 0) | (bVar.gqP == null || bVar.gqP.amP == bVar.gqP.amO ? (char) 2 : (char) 0)]);
            return drawable;
        }
        Drawable drawable2 = this.ani;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(bVar.gqO.amZ == bVar.gqP.amP ? ann : EMPTY_STATE_SET);
        }
        return drawable2;
    }

    public void setChildDivider(Drawable drawable) {
        this.ano = drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tieba.horizonalList.widget.HListView
    public void drawDivider(Canvas canvas, Rect rect, int i) {
        int i2 = this.mFirstPosition + i;
        if (i2 >= 0) {
            ExpandableHListConnector.b tl = this.gqQ.tl(bP(i2));
            if (tl.gqO.type == 1 || (tl.vh() && tl.gqP.amP != tl.gqP.amO)) {
                Drawable drawable = this.ano;
                drawable.setBounds(rect);
                drawable.draw(canvas);
                tl.recycle();
                return;
            }
            tl.recycle();
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
        this.anb = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.gqQ = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.gqQ = null;
        }
        super.setAdapter((ListAdapter) this.gqQ);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.anb;
    }

    private boolean isHeaderOrFooterPosition(int i) {
        return i < getHeaderViewsCount() || i >= this.mItemCount - getFooterViewsCount();
    }

    private int bP(int i) {
        return i - getHeaderViewsCount();
    }

    private int bQ(int i) {
        return getHeaderViewsCount() + i;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.AdapterView
    public boolean performItemClick(View view, int i, long j) {
        if (isHeaderOrFooterPosition(i)) {
            return super.performItemClick(view, i, j);
        }
        return a(view, bP(i), j);
    }

    boolean a(View view, int i, long j) {
        boolean z;
        ExpandableHListConnector.b tl = this.gqQ.tl(i);
        long b2 = b(tl.gqO);
        if (tl.gqO.type == 2) {
            if (this.gqT != null && this.gqT.a(this, view, tl.gqO.amX, b2)) {
                tl.recycle();
                return true;
            }
            if (tl.vh()) {
                this.gqQ.a(tl);
                playSoundEffect(0);
                if (this.gqR != null) {
                    this.gqR.bS(tl.gqO.amX);
                }
            } else {
                this.gqQ.b(tl);
                playSoundEffect(0);
                if (this.gqS != null) {
                    this.gqS.bT(tl.gqO.amX);
                }
                int i2 = tl.gqO.amX;
                int headerViewsCount = tl.gqO.amZ + getHeaderViewsCount();
                smoothScrollToPosition(this.anb.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.gqU != null) {
            playSoundEffect(0);
            return this.gqU.a(this, view, tl.gqO.amX, tl.gqO.amY, b2);
        } else {
            z = false;
        }
        tl.recycle();
        return z;
    }

    public void setOnGroupCollapseListener(d dVar) {
        this.gqR = dVar;
    }

    public void setOnGroupExpandListener(e eVar) {
        this.gqS = eVar;
    }

    public void setOnGroupClickListener(c cVar) {
        this.gqT = cVar;
    }

    public void setOnChildClickListener(b bVar) {
        this.gqU = bVar;
    }

    public long bR(int i) {
        if (isHeaderOrFooterPosition(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b tl = this.gqQ.tl(bP(i));
        long vi = tl.gqO.vi();
        tl.recycle();
        return vi;
    }

    public long getSelectedPosition() {
        return bR(getSelectedItemPosition());
    }

    public long getSelectedId() {
        long selectedPosition = getSelectedPosition();
        if (selectedPosition == 4294967295L) {
            return -1L;
        }
        int F = F(selectedPosition);
        if (E(selectedPosition) == 0) {
            return this.anb.getGroupId(F);
        }
        return this.anb.getChildId(F, G(selectedPosition));
    }

    public void setSelectedGroup(int i) {
        com.baidu.tieba.horizonalList.widget.a tn = com.baidu.tieba.horizonalList.widget.a.tn(i);
        ExpandableHListConnector.b a2 = this.gqQ.a(tn);
        tn.recycle();
        super.setSelection(bQ(a2.gqO.amZ));
        a2.recycle();
    }

    public static int E(long j) {
        if (j == 4294967295L) {
            return 2;
        }
        return (j & Long.MIN_VALUE) == Long.MIN_VALUE ? 1 : 0;
    }

    public static int F(long j) {
        if (j == 4294967295L) {
            return -1;
        }
        return (int) ((9223372032559808512L & j) >> 32);
    }

    public static int G(long j) {
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
        ExpandableHListConnector.b tl = this.gqQ.tl(bP(i));
        com.baidu.tieba.horizonalList.widget.a aVar = tl.gqO;
        long b2 = b(aVar);
        long vi = aVar.vi();
        tl.recycle();
        return new a(view, vi, b2);
    }

    private long b(com.baidu.tieba.horizonalList.widget.a aVar) {
        return aVar.type == 1 ? this.anb.getChildId(aVar.amX, aVar.amY) : this.anb.getGroupId(aVar.amX);
    }

    public void setChildIndicator(Drawable drawable) {
        this.ani = drawable;
        vl();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.anh = drawable;
        vk();
    }

    /* loaded from: classes.dex */
    public static class a implements ContextMenu.ContextMenuInfo {
        public View amH;
        public long any;
        public long id;

        public a(View view, long j, long j2) {
            this.amH = view;
            this.any = j;
            this.id = j2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.tieba.horizonalList.widget.ExpandableHListView.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: S */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: to */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        ArrayList<ExpandableHListConnector.GroupMetadata> anz;

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.anz = arrayList;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.anz = new ArrayList<>();
            parcel.readList(this.anz, ExpandableHListConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.anz);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.gqQ != null ? this.gqQ.ve() : null);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.gqQ != null && savedState.anz != null) {
            this.gqQ.i(savedState.anz);
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
