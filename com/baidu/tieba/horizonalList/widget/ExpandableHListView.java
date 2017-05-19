package com.baidu.tieba.horizonalList.widget;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ExpandableListAdapter;
import android.widget.ListAdapter;
import com.baidu.tieba.horizonalList.widget.ExpandableHListConnector;
import com.baidu.tieba.horizonalList.widget.f;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ExpandableHListView extends HListView {
    private static final int[] EMPTY_STATE_SET = new int[0];
    private static final int[] cAk = {16842920};
    private static final int[] cAl = {16842921};
    private static final int[] cAm = {16842920, 16842921};
    private static final int[][] cAn = {EMPTY_STATE_SET, cAk, cAl, cAm};
    private static final int[] cAo = {16842918};
    private ExpandableHListConnector cAa;
    private ExpandableListAdapter cAb;
    private int cAc;
    private int cAd;
    private int cAe;
    private int cAf;
    private int cAg;
    private int cAh;
    private Drawable cAi;
    private Drawable cAj;
    private Drawable cAp;
    private final Rect cAq;
    private int cAr;
    private int cAs;
    private int cAt;
    private int cAu;
    private d cAv;
    private e cAw;
    private c cAx;
    private b cAy;
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
        void onGroupCollapse(int i);
    }

    /* loaded from: classes.dex */
    public interface e {
        void onGroupExpand(int i);
    }

    private void aiP() {
        if (this.cAi != null) {
            this.cAr = this.cAi.getIntrinsicWidth();
            this.cAs = this.cAi.getIntrinsicHeight();
            return;
        }
        this.cAr = 0;
        this.cAs = 0;
    }

    private void aiQ() {
        if (this.cAj != null) {
            this.cAt = this.cAj.getIntrinsicWidth();
            this.cAu = this.cAj.getIntrinsicHeight();
            return;
        }
        this.cAt = 0;
        this.cAu = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.cAj != null || this.cAi != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.czz - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            Rect rect = this.cAq;
            int childCount = getChildCount();
            int i = this.czm - headerViewsCount;
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
                            ExpandableHListConnector.b kg = this.cAa.kg(i4);
                            if (kg.czU.type != i2) {
                                if (kg.czU.type == 1) {
                                    rect.top = childAt.getTop() + this.cAg;
                                    rect.bottom = childAt.getBottom() + this.cAg;
                                } else {
                                    rect.top = childAt.getTop() + this.cAc;
                                    rect.bottom = childAt.getBottom() + this.cAc;
                                }
                                i2 = kg.czU.type;
                            }
                            if (rect.top != rect.bottom) {
                                if (kg.czU.type == 1) {
                                    rect.left = this.cAh + left;
                                    rect.right = this.cAh + right2;
                                } else {
                                    rect.left = this.cAd + left;
                                    rect.right = this.cAd + right2;
                                }
                                Drawable c2 = c(kg);
                                if (c2 != null) {
                                    if (kg.czU.type == 1) {
                                        Gravity.apply(this.cAf, this.cAt, this.cAu, rect, this.mTempRect);
                                    } else {
                                        Gravity.apply(this.cAe, this.cAr, this.cAs, rect, this.mTempRect);
                                    }
                                    c2.setBounds(this.mTempRect);
                                    c2.draw(canvas);
                                }
                            }
                            kg.recycle();
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
        if (bVar.czU.type == 2) {
            Drawable drawable = this.cAi;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            drawable.setState(cAn[(bVar.aiM() ? (char) 1 : (char) 0) | (bVar.czV == null || bVar.czV.czP == bVar.czV.czO ? (char) 2 : (char) 0)]);
            return drawable;
        }
        Drawable drawable2 = this.cAj;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(bVar.czU.czZ == bVar.czV.czP ? cAo : EMPTY_STATE_SET);
        }
        return drawable2;
    }

    public void setChildDivider(Drawable drawable) {
        this.cAp = drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tieba.horizonalList.widget.HListView
    public void a(Canvas canvas, Rect rect, int i) {
        int i2 = this.czm + i;
        if (i2 >= 0) {
            ExpandableHListConnector.b kg = this.cAa.kg(kk(i2));
            if (kg.czU.type == 1 || (kg.aiM() && kg.czV.czP != kg.czV.czO)) {
                Drawable drawable = this.cAp;
                drawable.setBounds(rect);
                drawable.draw(canvas);
                kg.recycle();
                return;
            }
            kg.recycle();
        }
        super.a(canvas, rect, i2);
    }

    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView
    public void setAdapter(ListAdapter listAdapter) {
        throw new RuntimeException("For ExpandableListView, use setAdapter(ExpandableListAdapter) instead of setAdapter(ListAdapter)");
    }

    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.f
    public ListAdapter getAdapter() {
        return super.getAdapter();
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public void setOnItemClickListener(f.c cVar) {
        super.setOnItemClickListener(cVar);
    }

    public void setAdapter(ExpandableListAdapter expandableListAdapter) {
        this.cAb = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.cAa = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.cAa = null;
        }
        super.setAdapter((ListAdapter) this.cAa);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.cAb;
    }

    private boolean kj(int i) {
        return i < getHeaderViewsCount() || i >= this.czz - getFooterViewsCount();
    }

    private int kk(int i) {
        return i - getHeaderViewsCount();
    }

    private int kl(int i) {
        return getHeaderViewsCount() + i;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.f
    public boolean performItemClick(View view, int i, long j) {
        if (kj(i)) {
            return super.performItemClick(view, i, j);
        }
        return d(view, kk(i), j);
    }

    boolean d(View view, int i, long j) {
        boolean z;
        ExpandableHListConnector.b kg = this.cAa.kg(i);
        long b2 = b(kg.czU);
        if (kg.czU.type == 2) {
            if (this.cAx != null && this.cAx.a(this, view, kg.czU.czX, b2)) {
                kg.recycle();
                return true;
            }
            if (kg.aiM()) {
                this.cAa.a(kg);
                playSoundEffect(0);
                if (this.cAv != null) {
                    this.cAv.onGroupCollapse(kg.czU.czX);
                }
            } else {
                this.cAa.b(kg);
                playSoundEffect(0);
                if (this.cAw != null) {
                    this.cAw.onGroupExpand(kg.czU.czX);
                }
                int i2 = kg.czU.czX;
                int headerViewsCount = kg.czU.czZ + getHeaderViewsCount();
                smoothScrollToPosition(this.cAb.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.cAy != null) {
            playSoundEffect(0);
            return this.cAy.a(this, view, kg.czU.czX, kg.czU.czY, b2);
        } else {
            z = false;
        }
        kg.recycle();
        return z;
    }

    public void setOnGroupCollapseListener(d dVar) {
        this.cAv = dVar;
    }

    public void setOnGroupExpandListener(e eVar) {
        this.cAw = eVar;
    }

    public void setOnGroupClickListener(c cVar) {
        this.cAx = cVar;
    }

    public void setOnChildClickListener(b bVar) {
        this.cAy = bVar;
    }

    public long getExpandableListPosition(int i) {
        if (kj(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b kg = this.cAa.kg(kk(i));
        long aiN = kg.czU.aiN();
        kg.recycle();
        return aiN;
    }

    public long getSelectedPosition() {
        return getExpandableListPosition(getSelectedItemPosition());
    }

    public long getSelectedId() {
        long selectedPosition = getSelectedPosition();
        if (selectedPosition == 4294967295L) {
            return -1L;
        }
        int packedPositionGroup = getPackedPositionGroup(selectedPosition);
        if (getPackedPositionType(selectedPosition) == 0) {
            return this.cAb.getGroupId(packedPositionGroup);
        }
        return this.cAb.getChildId(packedPositionGroup, getPackedPositionChild(selectedPosition));
    }

    public void setSelectedGroup(int i) {
        h ki = h.ki(i);
        ExpandableHListConnector.b a2 = this.cAa.a(ki);
        ki.recycle();
        super.setSelection(kl(a2.czU.czZ));
        a2.recycle();
    }

    public static int getPackedPositionType(long j) {
        if (j == 4294967295L) {
            return 2;
        }
        return (j & Long.MIN_VALUE) == Long.MIN_VALUE ? 1 : 0;
    }

    public static int getPackedPositionGroup(long j) {
        if (j == 4294967295L) {
            return -1;
        }
        return (int) ((9223372032559808512L & j) >> 32);
    }

    public static int getPackedPositionChild(long j) {
        if (j != 4294967295L && (j & Long.MIN_VALUE) == Long.MIN_VALUE) {
            return (int) (j & 4294967295L);
        }
        return -1;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView
    ContextMenu.ContextMenuInfo b(View view, int i, long j) {
        if (kj(i)) {
            return new f.a(view, i, j);
        }
        ExpandableHListConnector.b kg = this.cAa.kg(kk(i));
        h hVar = kg.czU;
        long b2 = b(hVar);
        long aiN = hVar.aiN();
        kg.recycle();
        return new a(view, aiN, b2);
    }

    private long b(h hVar) {
        return hVar.type == 1 ? this.cAb.getChildId(hVar.czX, hVar.czY) : this.cAb.getGroupId(hVar.czX);
    }

    public void setChildIndicator(Drawable drawable) {
        this.cAj = drawable;
        aiQ();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.cAi = drawable;
        aiP();
    }

    /* loaded from: classes.dex */
    public static class a implements ContextMenu.ContextMenuInfo {
        public long id;
        public long packedPosition;
        public View targetView;

        public a(View view, long j, long j2) {
            this.targetView = view;
            this.packedPosition = j;
            this.id = j2;
        }
    }

    /* loaded from: classes.dex */
    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new i();
        ArrayList<ExpandableHListConnector.GroupMetadata> cAz;

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.cAz = arrayList;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ SavedState(Parcel parcel, SavedState savedState) {
            this(parcel);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.cAz = new ArrayList<>();
            parcel.readList(this.cAz, ExpandableHListConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.cAz);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.cAa != null ? this.cAa.aiJ() : null);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.cAa != null && savedState.cAz != null) {
            this.cAa.P(savedState.cAz);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.f, android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(ExpandableHListView.class.getName());
    }

    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.f, android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(ExpandableHListView.class.getName());
    }
}
