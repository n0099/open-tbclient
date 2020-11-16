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
    private static final int[] bzJ = {16842920};
    private static final int[] bzK = {16842921};
    private static final int[] bzL = {16842920, 16842921};
    private static final int[][] bzM = {EMPTY_STATE_SET, bzJ, bzK, bzL};
    private static final int[] bzN = {16842918};
    private ExpandableListAdapter bzB;
    private int bzC;
    private int bzD;
    private int bzE;
    private int bzF;
    private int bzG;
    private Drawable bzH;
    private Drawable bzI;
    private Drawable bzO;
    private final Rect bzP;
    private int bzQ;
    private int bzR;
    private int bzS;
    private int bzT;
    private ExpandableHListConnector jNF;
    private d jNG;
    private e jNH;
    private c jNI;
    private b jNJ;
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
        void fH(int i);
    }

    /* loaded from: classes.dex */
    public interface e {
        void fI(int i);
    }

    public ExpandableHListView(Context context) {
        this(context, null);
    }

    public ExpandableHListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.hlv_expandableListViewStyle);
    }

    public ExpandableHListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bzP = new Rect();
        this.mTempRect = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandableHListView, i, 0);
        setGroupIndicator(obtainStyledAttributes.getDrawable(R.styleable.ExpandableHListView_hlv_groupIndicator));
        setChildIndicator(obtainStyledAttributes.getDrawable(R.styleable.ExpandableHListView_hlv_childIndicator));
        this.mIndicatorLeft = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandableHListView_hlv_indicatorPaddingLeft, 0);
        this.bzC = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandableHListView_hlv_indicatorPaddingTop, 0);
        this.bzD = obtainStyledAttributes.getInt(R.styleable.ExpandableHListView_hlv_indicatorGravity, 0);
        this.bzE = obtainStyledAttributes.getInt(R.styleable.ExpandableHListView_hlv_childIndicatorGravity, 0);
        this.bzG = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandableHListView_hlv_childIndicatorPaddingLeft, 0);
        this.bzF = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandableHListView_hlv_childIndicatorPaddingTop, 0);
        this.bzO = obtainStyledAttributes.getDrawable(R.styleable.ExpandableHListView_hlv_childDivider);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        SB();
        SC();
    }

    private void SB() {
        if (this.bzH != null) {
            this.bzQ = this.bzH.getIntrinsicWidth();
            this.bzR = this.bzH.getIntrinsicHeight();
            return;
        }
        this.bzQ = 0;
        this.bzR = 0;
    }

    private void SC() {
        if (this.bzI != null) {
            this.bzS = this.bzI.getIntrinsicWidth();
            this.bzT = this.bzI.getIntrinsicHeight();
            return;
        }
        this.bzS = 0;
        this.bzT = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.bzI != null || this.bzH != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.mItemCount - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            Rect rect = this.bzP;
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
                            ExpandableHListConnector.b Cs = this.jNF.Cs(i4);
                            if (Cs.jND.type != i2) {
                                if (Cs.jND.type == 1) {
                                    rect.top = childAt.getTop() + this.bzF;
                                    rect.bottom = childAt.getBottom() + this.bzF;
                                } else {
                                    rect.top = childAt.getTop() + this.bzC;
                                    rect.bottom = childAt.getBottom() + this.bzC;
                                }
                                i2 = Cs.jND.type;
                            }
                            if (rect.top != rect.bottom) {
                                if (Cs.jND.type == 1) {
                                    rect.left = this.bzG + left;
                                    rect.right = this.bzG + right2;
                                } else {
                                    rect.left = this.mIndicatorLeft + left;
                                    rect.right = this.mIndicatorLeft + right2;
                                }
                                Drawable c2 = c(Cs);
                                if (c2 != null) {
                                    if (Cs.jND.type == 1) {
                                        Gravity.apply(this.bzE, this.bzS, this.bzT, rect, this.mTempRect);
                                    } else {
                                        Gravity.apply(this.bzD, this.bzQ, this.bzR, rect, this.mTempRect);
                                    }
                                    c2.setBounds(this.mTempRect);
                                    c2.draw(canvas);
                                }
                            }
                            Cs.recycle();
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
        if (bVar.jND.type == 2) {
            Drawable drawable = this.bzH;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            drawable.setState(bzM[(bVar.Sy() ? (char) 1 : (char) 0) | (bVar.jNE == null || bVar.jNE.bzp == bVar.jNE.bzo ? (char) 2 : (char) 0)]);
            return drawable;
        }
        Drawable drawable2 = this.bzI;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(bVar.jND.bzz == bVar.jNE.bzp ? bzN : EMPTY_STATE_SET);
        }
        return drawable2;
    }

    public void setChildDivider(Drawable drawable) {
        this.bzO = drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tieba.horizonalList.widget.HListView
    public void drawDivider(Canvas canvas, Rect rect, int i) {
        int i2 = this.mFirstPosition + i;
        if (i2 >= 0) {
            ExpandableHListConnector.b Cs = this.jNF.Cs(fE(i2));
            if (Cs.jND.type == 1 || (Cs.Sy() && Cs.jNE.bzp != Cs.jNE.bzo)) {
                Drawable drawable = this.bzO;
                drawable.setBounds(rect);
                drawable.draw(canvas);
                Cs.recycle();
                return;
            }
            Cs.recycle();
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
        this.bzB = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.jNF = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.jNF = null;
        }
        super.setAdapter((ListAdapter) this.jNF);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.bzB;
    }

    private boolean isHeaderOrFooterPosition(int i) {
        return i < getHeaderViewsCount() || i >= this.mItemCount - getFooterViewsCount();
    }

    private int fE(int i) {
        return i - getHeaderViewsCount();
    }

    private int fF(int i) {
        return getHeaderViewsCount() + i;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.AdapterView
    public boolean performItemClick(View view, int i, long j) {
        if (isHeaderOrFooterPosition(i)) {
            return super.performItemClick(view, i, j);
        }
        return b(view, fE(i), j);
    }

    boolean b(View view, int i, long j) {
        boolean z;
        ExpandableHListConnector.b Cs = this.jNF.Cs(i);
        long b2 = b(Cs.jND);
        if (Cs.jND.type == 2) {
            if (this.jNI != null && this.jNI.a(this, view, Cs.jND.bzx, b2)) {
                Cs.recycle();
                return true;
            }
            if (Cs.Sy()) {
                this.jNF.a(Cs);
                playSoundEffect(0);
                if (this.jNG != null) {
                    this.jNG.fH(Cs.jND.bzx);
                }
            } else {
                this.jNF.b(Cs);
                playSoundEffect(0);
                if (this.jNH != null) {
                    this.jNH.fI(Cs.jND.bzx);
                }
                int i2 = Cs.jND.bzx;
                int headerViewsCount = Cs.jND.bzz + getHeaderViewsCount();
                smoothScrollToPosition(this.bzB.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.jNJ != null) {
            playSoundEffect(0);
            return this.jNJ.a(this, view, Cs.jND.bzx, Cs.jND.bzy, b2);
        } else {
            z = false;
        }
        Cs.recycle();
        return z;
    }

    public void setOnGroupCollapseListener(d dVar) {
        this.jNG = dVar;
    }

    public void setOnGroupExpandListener(e eVar) {
        this.jNH = eVar;
    }

    public void setOnGroupClickListener(c cVar) {
        this.jNI = cVar;
    }

    public void setOnChildClickListener(b bVar) {
        this.jNJ = bVar;
    }

    public long fG(int i) {
        if (isHeaderOrFooterPosition(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b Cs = this.jNF.Cs(fE(i));
        long Sz = Cs.jND.Sz();
        Cs.recycle();
        return Sz;
    }

    public long getSelectedPosition() {
        return fG(getSelectedItemPosition());
    }

    public long getSelectedId() {
        long selectedPosition = getSelectedPosition();
        if (selectedPosition == 4294967295L) {
            return -1L;
        }
        int aS = aS(selectedPosition);
        if (aR(selectedPosition) == 0) {
            return this.bzB.getGroupId(aS);
        }
        return this.bzB.getChildId(aS, aT(selectedPosition));
    }

    public void setSelectedGroup(int i) {
        com.baidu.tieba.horizonalList.widget.a Cu = com.baidu.tieba.horizonalList.widget.a.Cu(i);
        ExpandableHListConnector.b a2 = this.jNF.a(Cu);
        Cu.recycle();
        super.setSelection(fF(a2.jND.bzz));
        a2.recycle();
    }

    public static int aR(long j) {
        if (j == 4294967295L) {
            return 2;
        }
        return (j & Long.MIN_VALUE) == Long.MIN_VALUE ? 1 : 0;
    }

    public static int aS(long j) {
        if (j == 4294967295L) {
            return -1;
        }
        return (int) ((9223372032559808512L & j) >> 32);
    }

    public static int aT(long j) {
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
        ExpandableHListConnector.b Cs = this.jNF.Cs(fE(i));
        com.baidu.tieba.horizonalList.widget.a aVar = Cs.jND;
        long b2 = b(aVar);
        long Sz = aVar.Sz();
        Cs.recycle();
        return new a(view, Sz, b2);
    }

    private long b(com.baidu.tieba.horizonalList.widget.a aVar) {
        return aVar.type == 1 ? this.bzB.getChildId(aVar.bzx, aVar.bzy) : this.bzB.getGroupId(aVar.bzx);
    }

    public void setChildIndicator(Drawable drawable) {
        this.bzI = drawable;
        SC();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.bzH = drawable;
        SB();
    }

    /* loaded from: classes.dex */
    public static class a implements ContextMenu.ContextMenuInfo {
        public long bzY;
        public long id;
        public View targetView;

        public a(View view, long j, long j2) {
            this.targetView = view;
            this.bzY = j;
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
            /* renamed from: Cv */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        ArrayList<ExpandableHListConnector.GroupMetadata> bzZ;

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.bzZ = arrayList;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.bzZ = new ArrayList<>();
            parcel.readList(this.bzZ, ExpandableHListConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.bzZ);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.jNF != null ? this.jNF.Sw() : null);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.jNF != null && savedState.bzZ != null) {
            this.jNF.p(savedState.bzZ);
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
