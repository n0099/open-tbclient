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
public class ExpandableHListView extends k {
    private static final int[] EMPTY_STATE_SET = new int[0];
    private static final int[] bES = {16842920};
    private static final int[] bET = {16842921};
    private static final int[] bEU = {16842920, 16842921};
    private static final int[][] bEV = {EMPTY_STATE_SET, bES, bET, bEU};
    private static final int[] bEW = {16842918};
    private ExpandableHListConnector bEI;
    private ExpandableListAdapter bEJ;
    private int bEK;
    private int bEL;
    private int bEM;
    private int bEN;
    private int bEO;
    private int bEP;
    private Drawable bEQ;
    private Drawable bER;
    private Drawable bEX;
    private final Rect bEY;
    private int bEZ;
    private int bFa;
    private int bFb;
    private int bFc;
    private d bFd;
    private e bFe;
    private c bFf;
    private b bFg;
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

    private void UX() {
        if (this.bEQ != null) {
            this.bEZ = this.bEQ.getIntrinsicWidth();
            this.bFa = this.bEQ.getIntrinsicHeight();
            return;
        }
        this.bEZ = 0;
        this.bFa = 0;
    }

    private void UY() {
        if (this.bER != null) {
            this.bFb = this.bER.getIntrinsicWidth();
            this.bFc = this.bER.getIntrinsicHeight();
            return;
        }
        this.bFb = 0;
        this.bFc = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.k, com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.bER != null || this.bEQ != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.bEh - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            Rect rect = this.bEY;
            int childCount = getChildCount();
            int i = this.bDU - headerViewsCount;
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
                            ExpandableHListConnector.b hJ = this.bEI.hJ(i4);
                            if (hJ.bEC.type != i2) {
                                if (hJ.bEC.type == 1) {
                                    rect.top = childAt.getTop() + this.bEO;
                                    rect.bottom = childAt.getBottom() + this.bEO;
                                } else {
                                    rect.top = childAt.getTop() + this.bEK;
                                    rect.bottom = childAt.getBottom() + this.bEK;
                                }
                                i2 = hJ.bEC.type;
                            }
                            if (rect.top != rect.bottom) {
                                if (hJ.bEC.type == 1) {
                                    rect.left = this.bEP + left;
                                    rect.right = this.bEP + right2;
                                } else {
                                    rect.left = this.bEL + left;
                                    rect.right = this.bEL + right2;
                                }
                                Drawable c2 = c(hJ);
                                if (c2 != null) {
                                    if (hJ.bEC.type == 1) {
                                        Gravity.apply(this.bEN, this.bFb, this.bFc, rect, this.mTempRect);
                                    } else {
                                        Gravity.apply(this.bEM, this.bEZ, this.bFa, rect, this.mTempRect);
                                    }
                                    c2.setBounds(this.mTempRect);
                                    c2.draw(canvas);
                                }
                            }
                            hJ.recycle();
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
        if (bVar.bEC.type == 2) {
            Drawable drawable = this.bEQ;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            drawable.setState(bEV[(bVar.pq() ? (char) 1 : (char) 0) | (bVar.bED == null || bVar.bED.bEx == bVar.bED.bEw ? (char) 2 : (char) 0)]);
            return drawable;
        }
        Drawable drawable2 = this.bER;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(bVar.bEC.bEH == bVar.bED.bEx ? bEW : EMPTY_STATE_SET);
        }
        return drawable2;
    }

    public void setChildDivider(Drawable drawable) {
        this.bEX = drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tieba.horizonalList.widget.k
    public void a(Canvas canvas, Rect rect, int i) {
        int i2 = this.bDU + i;
        if (i2 >= 0) {
            ExpandableHListConnector.b hJ = this.bEI.hJ(hN(i2));
            if (hJ.bEC.type == 1 || (hJ.pq() && hJ.bED.bEx != hJ.bED.bEw)) {
                Drawable drawable = this.bEX;
                drawable.setBounds(rect);
                drawable.draw(canvas);
                hJ.recycle();
                return;
            }
            hJ.recycle();
        }
        super.a(canvas, rect, i2);
    }

    @Override // com.baidu.tieba.horizonalList.widget.k, com.baidu.tieba.horizonalList.widget.AbsHListView
    public void setAdapter(ListAdapter listAdapter) {
        throw new RuntimeException("For ExpandableListView, use setAdapter(ExpandableListAdapter) instead of setAdapter(ListAdapter)");
    }

    @Override // com.baidu.tieba.horizonalList.widget.k, com.baidu.tieba.horizonalList.widget.g
    public ListAdapter getAdapter() {
        return super.getAdapter();
    }

    @Override // com.baidu.tieba.horizonalList.widget.g
    public void setOnItemClickListener(g.c cVar) {
        super.setOnItemClickListener(cVar);
    }

    public void setAdapter(ExpandableListAdapter expandableListAdapter) {
        this.bEJ = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.bEI = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.bEI = null;
        }
        super.setAdapter((ListAdapter) this.bEI);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.bEJ;
    }

    private boolean hM(int i) {
        return i < getHeaderViewsCount() || i >= this.bEh - getFooterViewsCount();
    }

    private int hN(int i) {
        return i - getHeaderViewsCount();
    }

    private int hO(int i) {
        return getHeaderViewsCount() + i;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.g
    public boolean performItemClick(View view, int i, long j) {
        if (hM(i)) {
            return super.performItemClick(view, i, j);
        }
        return c(view, hN(i), j);
    }

    boolean c(View view, int i, long j) {
        boolean z;
        ExpandableHListConnector.b hJ = this.bEI.hJ(i);
        long b2 = b(hJ.bEC);
        if (hJ.bEC.type == 2) {
            if (this.bFf != null && this.bFf.a(this, view, hJ.bEC.bEF, b2)) {
                hJ.recycle();
                return true;
            }
            if (hJ.pq()) {
                this.bEI.a(hJ);
                playSoundEffect(0);
                if (this.bFd != null) {
                    this.bFd.onGroupCollapse(hJ.bEC.bEF);
                }
            } else {
                this.bEI.b(hJ);
                playSoundEffect(0);
                if (this.bFe != null) {
                    this.bFe.onGroupExpand(hJ.bEC.bEF);
                }
                int i2 = hJ.bEC.bEF;
                int headerViewsCount = hJ.bEC.bEH + getHeaderViewsCount();
                smoothScrollToPosition(this.bEJ.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.bFg != null) {
            playSoundEffect(0);
            return this.bFg.a(this, view, hJ.bEC.bEF, hJ.bEC.bEG, b2);
        } else {
            z = false;
        }
        hJ.recycle();
        return z;
    }

    public void setOnGroupCollapseListener(d dVar) {
        this.bFd = dVar;
    }

    public void setOnGroupExpandListener(e eVar) {
        this.bFe = eVar;
    }

    public void setOnGroupClickListener(c cVar) {
        this.bFf = cVar;
    }

    public void setOnChildClickListener(b bVar) {
        this.bFg = bVar;
    }

    public long getExpandableListPosition(int i) {
        if (hM(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b hJ = this.bEI.hJ(hN(i));
        long UV = hJ.bEC.UV();
        hJ.recycle();
        return UV;
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
            return this.bEJ.getGroupId(packedPositionGroup);
        }
        return this.bEJ.getChildId(packedPositionGroup, getPackedPositionChild(selectedPosition));
    }

    public void setSelectedGroup(int i) {
        i hL = i.hL(i);
        ExpandableHListConnector.b a2 = this.bEI.a(hL);
        hL.recycle();
        super.setSelection(hO(a2.bEC.bEH));
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
    ContextMenu.ContextMenuInfo a(View view, int i, long j) {
        if (hM(i)) {
            return new g.a(view, i, j);
        }
        ExpandableHListConnector.b hJ = this.bEI.hJ(hN(i));
        i iVar = hJ.bEC;
        long b2 = b(iVar);
        long UV = iVar.UV();
        hJ.recycle();
        return new a(view, UV, b2);
    }

    private long b(i iVar) {
        return iVar.type == 1 ? this.bEJ.getChildId(iVar.bEF, iVar.bEG) : this.bEJ.getGroupId(iVar.bEF);
    }

    public void setChildIndicator(Drawable drawable) {
        this.bER = drawable;
        UY();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.bEQ = drawable;
        UX();
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
        ArrayList<ExpandableHListConnector.GroupMetadata> bFh;

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.bFh = arrayList;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ SavedState(Parcel parcel, SavedState savedState) {
            this(parcel);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.bFh = new ArrayList<>();
            parcel.readList(this.bFh, ExpandableHListConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.bFh);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.bEI != null ? this.bEI.US() : null);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.bEI != null && savedState.bFh != null) {
            this.bEI.H(savedState.bFh);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.k, com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.g, android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(ExpandableHListView.class.getName());
    }

    @Override // com.baidu.tieba.horizonalList.widget.k, com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.g, android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(ExpandableHListView.class.getName());
    }
}
