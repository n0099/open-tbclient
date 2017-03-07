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
import com.baidu.tieba.horizonalList.widget.g;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ExpandableHListView extends HListView {
    private static final int[] EMPTY_STATE_SET = new int[0];
    private static final int[] cFk = {16842920};
    private static final int[] cFl = {16842921};
    private static final int[] cFm = {16842920, 16842921};
    private static final int[][] cFn = {EMPTY_STATE_SET, cFk, cFl, cFm};
    private static final int[] cFo = {16842918};
    private ExpandableHListConnector cFa;
    private ExpandableListAdapter cFb;
    private int cFc;
    private int cFd;
    private int cFe;
    private int cFf;
    private int cFg;
    private int cFh;
    private Drawable cFi;
    private Drawable cFj;
    private Drawable cFp;
    private final Rect cFq;
    private int cFr;
    private int cFs;
    private int cFt;
    private int cFu;
    private d cFv;
    private e cFw;
    private c cFx;
    private b cFy;
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

    private void ale() {
        if (this.cFi != null) {
            this.cFr = this.cFi.getIntrinsicWidth();
            this.cFs = this.cFi.getIntrinsicHeight();
            return;
        }
        this.cFr = 0;
        this.cFs = 0;
    }

    private void alf() {
        if (this.cFj != null) {
            this.cFt = this.cFj.getIntrinsicWidth();
            this.cFu = this.cFj.getIntrinsicHeight();
            return;
        }
        this.cFt = 0;
        this.cFu = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.cFj != null || this.cFi != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.cEz - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            Rect rect = this.cFq;
            int childCount = getChildCount();
            int i = this.cEm - headerViewsCount;
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
                            ExpandableHListConnector.b km = this.cFa.km(i4);
                            if (km.cEU.type != i2) {
                                if (km.cEU.type == 1) {
                                    rect.top = childAt.getTop() + this.cFg;
                                    rect.bottom = childAt.getBottom() + this.cFg;
                                } else {
                                    rect.top = childAt.getTop() + this.cFc;
                                    rect.bottom = childAt.getBottom() + this.cFc;
                                }
                                i2 = km.cEU.type;
                            }
                            if (rect.top != rect.bottom) {
                                if (km.cEU.type == 1) {
                                    rect.left = this.cFh + left;
                                    rect.right = this.cFh + right2;
                                } else {
                                    rect.left = this.cFd + left;
                                    rect.right = this.cFd + right2;
                                }
                                Drawable c2 = c(km);
                                if (c2 != null) {
                                    if (km.cEU.type == 1) {
                                        Gravity.apply(this.cFf, this.cFt, this.cFu, rect, this.mTempRect);
                                    } else {
                                        Gravity.apply(this.cFe, this.cFr, this.cFs, rect, this.mTempRect);
                                    }
                                    c2.setBounds(this.mTempRect);
                                    c2.draw(canvas);
                                }
                            }
                            km.recycle();
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
        if (bVar.cEU.type == 2) {
            Drawable drawable = this.cFi;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            drawable.setState(cFn[(bVar.alb() ? (char) 1 : (char) 0) | (bVar.cEV == null || bVar.cEV.cEP == bVar.cEV.cEO ? (char) 2 : (char) 0)]);
            return drawable;
        }
        Drawable drawable2 = this.cFj;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(bVar.cEU.cEZ == bVar.cEV.cEP ? cFo : EMPTY_STATE_SET);
        }
        return drawable2;
    }

    public void setChildDivider(Drawable drawable) {
        this.cFp = drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tieba.horizonalList.widget.HListView
    public void a(Canvas canvas, Rect rect, int i) {
        int i2 = this.cEm + i;
        if (i2 >= 0) {
            ExpandableHListConnector.b km = this.cFa.km(kq(i2));
            if (km.cEU.type == 1 || (km.alb() && km.cEV.cEP != km.cEV.cEO)) {
                Drawable drawable = this.cFp;
                drawable.setBounds(rect);
                drawable.draw(canvas);
                km.recycle();
                return;
            }
            km.recycle();
        }
        super.a(canvas, rect, i2);
    }

    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView
    public void setAdapter(ListAdapter listAdapter) {
        throw new RuntimeException("For ExpandableListView, use setAdapter(ExpandableListAdapter) instead of setAdapter(ListAdapter)");
    }

    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.g
    public ListAdapter getAdapter() {
        return super.getAdapter();
    }

    @Override // com.baidu.tieba.horizonalList.widget.g
    public void setOnItemClickListener(g.c cVar) {
        super.setOnItemClickListener(cVar);
    }

    public void setAdapter(ExpandableListAdapter expandableListAdapter) {
        this.cFb = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.cFa = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.cFa = null;
        }
        super.setAdapter((ListAdapter) this.cFa);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.cFb;
    }

    private boolean kp(int i) {
        return i < getHeaderViewsCount() || i >= this.cEz - getFooterViewsCount();
    }

    private int kq(int i) {
        return i - getHeaderViewsCount();
    }

    private int kr(int i) {
        return getHeaderViewsCount() + i;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.g
    public boolean performItemClick(View view, int i, long j) {
        if (kp(i)) {
            return super.performItemClick(view, i, j);
        }
        return d(view, kq(i), j);
    }

    boolean d(View view, int i, long j) {
        boolean z;
        ExpandableHListConnector.b km = this.cFa.km(i);
        long b2 = b(km.cEU);
        if (km.cEU.type == 2) {
            if (this.cFx != null && this.cFx.a(this, view, km.cEU.cEX, b2)) {
                km.recycle();
                return true;
            }
            if (km.alb()) {
                this.cFa.a(km);
                playSoundEffect(0);
                if (this.cFv != null) {
                    this.cFv.onGroupCollapse(km.cEU.cEX);
                }
            } else {
                this.cFa.b(km);
                playSoundEffect(0);
                if (this.cFw != null) {
                    this.cFw.onGroupExpand(km.cEU.cEX);
                }
                int i2 = km.cEU.cEX;
                int headerViewsCount = km.cEU.cEZ + getHeaderViewsCount();
                smoothScrollToPosition(this.cFb.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.cFy != null) {
            playSoundEffect(0);
            return this.cFy.a(this, view, km.cEU.cEX, km.cEU.cEY, b2);
        } else {
            z = false;
        }
        km.recycle();
        return z;
    }

    public void setOnGroupCollapseListener(d dVar) {
        this.cFv = dVar;
    }

    public void setOnGroupExpandListener(e eVar) {
        this.cFw = eVar;
    }

    public void setOnGroupClickListener(c cVar) {
        this.cFx = cVar;
    }

    public void setOnChildClickListener(b bVar) {
        this.cFy = bVar;
    }

    public long getExpandableListPosition(int i) {
        if (kp(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b km = this.cFa.km(kq(i));
        long alc = km.cEU.alc();
        km.recycle();
        return alc;
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
            return this.cFb.getGroupId(packedPositionGroup);
        }
        return this.cFb.getChildId(packedPositionGroup, getPackedPositionChild(selectedPosition));
    }

    public void setSelectedGroup(int i) {
        i ko = i.ko(i);
        ExpandableHListConnector.b a2 = this.cFa.a(ko);
        ko.recycle();
        super.setSelection(kr(a2.cEU.cEZ));
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
        if (kp(i)) {
            return new g.a(view, i, j);
        }
        ExpandableHListConnector.b km = this.cFa.km(kq(i));
        i iVar = km.cEU;
        long b2 = b(iVar);
        long alc = iVar.alc();
        km.recycle();
        return new a(view, alc, b2);
    }

    private long b(i iVar) {
        return iVar.type == 1 ? this.cFb.getChildId(iVar.cEX, iVar.cEY) : this.cFb.getGroupId(iVar.cEX);
    }

    public void setChildIndicator(Drawable drawable) {
        this.cFj = drawable;
        alf();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.cFi = drawable;
        ale();
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
        public static final Parcelable.Creator<SavedState> CREATOR = new j();
        ArrayList<ExpandableHListConnector.GroupMetadata> cFz;

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.cFz = arrayList;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ SavedState(Parcel parcel, SavedState savedState) {
            this(parcel);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.cFz = new ArrayList<>();
            parcel.readList(this.cFz, ExpandableHListConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.cFz);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.cFa != null ? this.cFa.akY() : null);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.cFa != null && savedState.cFz != null) {
            this.cFa.Q(savedState.cFz);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.g, android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(ExpandableHListView.class.getName());
    }

    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.g, android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(ExpandableHListView.class.getName());
    }
}
