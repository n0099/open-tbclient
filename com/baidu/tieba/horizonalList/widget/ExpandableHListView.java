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
    private static final int[] cxc = {16842920};
    private static final int[] cxd = {16842921};
    private static final int[] cxe = {16842920, 16842921};
    private static final int[][] cxf = {EMPTY_STATE_SET, cxc, cxd, cxe};
    private static final int[] cxg = {16842918};
    private ExpandableHListConnector cwS;
    private ExpandableListAdapter cwT;
    private int cwU;
    private int cwV;
    private int cwW;
    private int cwX;
    private int cwY;
    private int cwZ;
    private Drawable cxa;
    private Drawable cxb;
    private Drawable cxh;
    private final Rect cxi;
    private int cxj;
    private int cxk;
    private int cxl;
    private int cxm;
    private d cxn;
    private e cxo;
    private c cxp;
    private b cxq;
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

    private void aiD() {
        if (this.cxa != null) {
            this.cxj = this.cxa.getIntrinsicWidth();
            this.cxk = this.cxa.getIntrinsicHeight();
            return;
        }
        this.cxj = 0;
        this.cxk = 0;
    }

    private void aiE() {
        if (this.cxb != null) {
            this.cxl = this.cxb.getIntrinsicWidth();
            this.cxm = this.cxb.getIntrinsicHeight();
            return;
        }
        this.cxl = 0;
        this.cxm = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.cxb != null || this.cxa != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.cwr - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            Rect rect = this.cxi;
            int childCount = getChildCount();
            int i = this.bkE - headerViewsCount;
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
                            ExpandableHListConnector.b jP = this.cwS.jP(i4);
                            if (jP.cwM.type != i2) {
                                if (jP.cwM.type == 1) {
                                    rect.top = childAt.getTop() + this.cwY;
                                    rect.bottom = childAt.getBottom() + this.cwY;
                                } else {
                                    rect.top = childAt.getTop() + this.cwU;
                                    rect.bottom = childAt.getBottom() + this.cwU;
                                }
                                i2 = jP.cwM.type;
                            }
                            if (rect.top != rect.bottom) {
                                if (jP.cwM.type == 1) {
                                    rect.left = this.cwZ + left;
                                    rect.right = this.cwZ + right2;
                                } else {
                                    rect.left = this.cwV + left;
                                    rect.right = this.cwV + right2;
                                }
                                Drawable c2 = c(jP);
                                if (c2 != null) {
                                    if (jP.cwM.type == 1) {
                                        Gravity.apply(this.cwX, this.cxl, this.cxm, rect, this.mTempRect);
                                    } else {
                                        Gravity.apply(this.cwW, this.cxj, this.cxk, rect, this.mTempRect);
                                    }
                                    c2.setBounds(this.mTempRect);
                                    c2.draw(canvas);
                                }
                            }
                            jP.recycle();
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
        if (bVar.cwM.type == 2) {
            Drawable drawable = this.cxa;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            drawable.setState(cxf[(bVar.aiA() ? (char) 1 : (char) 0) | (bVar.cwN == null || bVar.cwN.cwH == bVar.cwN.cwG ? (char) 2 : (char) 0)]);
            return drawable;
        }
        Drawable drawable2 = this.cxb;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(bVar.cwM.cwR == bVar.cwN.cwH ? cxg : EMPTY_STATE_SET);
        }
        return drawable2;
    }

    public void setChildDivider(Drawable drawable) {
        this.cxh = drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tieba.horizonalList.widget.HListView
    public void a(Canvas canvas, Rect rect, int i) {
        int i2 = this.bkE + i;
        if (i2 >= 0) {
            ExpandableHListConnector.b jP = this.cwS.jP(jT(i2));
            if (jP.cwM.type == 1 || (jP.aiA() && jP.cwN.cwH != jP.cwN.cwG)) {
                Drawable drawable = this.cxh;
                drawable.setBounds(rect);
                drawable.draw(canvas);
                jP.recycle();
                return;
            }
            jP.recycle();
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
        this.cwT = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.cwS = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.cwS = null;
        }
        super.setAdapter((ListAdapter) this.cwS);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.cwT;
    }

    private boolean jS(int i) {
        return i < getHeaderViewsCount() || i >= this.cwr - getFooterViewsCount();
    }

    private int jT(int i) {
        return i - getHeaderViewsCount();
    }

    private int jU(int i) {
        return getHeaderViewsCount() + i;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.g
    public boolean performItemClick(View view, int i, long j) {
        if (jS(i)) {
            return super.performItemClick(view, i, j);
        }
        return d(view, jT(i), j);
    }

    boolean d(View view, int i, long j) {
        boolean z;
        ExpandableHListConnector.b jP = this.cwS.jP(i);
        long b2 = b(jP.cwM);
        if (jP.cwM.type == 2) {
            if (this.cxp != null && this.cxp.a(this, view, jP.cwM.cwP, b2)) {
                jP.recycle();
                return true;
            }
            if (jP.aiA()) {
                this.cwS.a(jP);
                playSoundEffect(0);
                if (this.cxn != null) {
                    this.cxn.onGroupCollapse(jP.cwM.cwP);
                }
            } else {
                this.cwS.b(jP);
                playSoundEffect(0);
                if (this.cxo != null) {
                    this.cxo.onGroupExpand(jP.cwM.cwP);
                }
                int i2 = jP.cwM.cwP;
                int headerViewsCount = jP.cwM.cwR + getHeaderViewsCount();
                smoothScrollToPosition(this.cwT.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.cxq != null) {
            playSoundEffect(0);
            return this.cxq.a(this, view, jP.cwM.cwP, jP.cwM.cwQ, b2);
        } else {
            z = false;
        }
        jP.recycle();
        return z;
    }

    public void setOnGroupCollapseListener(d dVar) {
        this.cxn = dVar;
    }

    public void setOnGroupExpandListener(e eVar) {
        this.cxo = eVar;
    }

    public void setOnGroupClickListener(c cVar) {
        this.cxp = cVar;
    }

    public void setOnChildClickListener(b bVar) {
        this.cxq = bVar;
    }

    public long getExpandableListPosition(int i) {
        if (jS(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b jP = this.cwS.jP(jT(i));
        long aiB = jP.cwM.aiB();
        jP.recycle();
        return aiB;
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
            return this.cwT.getGroupId(packedPositionGroup);
        }
        return this.cwT.getChildId(packedPositionGroup, getPackedPositionChild(selectedPosition));
    }

    public void setSelectedGroup(int i) {
        i jR = i.jR(i);
        ExpandableHListConnector.b a2 = this.cwS.a(jR);
        jR.recycle();
        super.setSelection(jU(a2.cwM.cwR));
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
        if (jS(i)) {
            return new g.a(view, i, j);
        }
        ExpandableHListConnector.b jP = this.cwS.jP(jT(i));
        i iVar = jP.cwM;
        long b2 = b(iVar);
        long aiB = iVar.aiB();
        jP.recycle();
        return new a(view, aiB, b2);
    }

    private long b(i iVar) {
        return iVar.type == 1 ? this.cwT.getChildId(iVar.cwP, iVar.cwQ) : this.cwT.getGroupId(iVar.cwP);
    }

    public void setChildIndicator(Drawable drawable) {
        this.cxb = drawable;
        aiE();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.cxa = drawable;
        aiD();
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
        ArrayList<ExpandableHListConnector.GroupMetadata> cxr;

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.cxr = arrayList;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ SavedState(Parcel parcel, SavedState savedState) {
            this(parcel);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.cxr = new ArrayList<>();
            parcel.readList(this.cxr, ExpandableHListConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.cxr);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.cwS != null ? this.cwS.aix() : null);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.cwS != null && savedState.cxr != null) {
            this.cwS.S(savedState.cxr);
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
