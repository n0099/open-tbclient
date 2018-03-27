package com.baidu.tieba.horizonalList.widget;

import android.annotation.TargetApi;
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
import com.baidu.tieba.horizonalList.widget.a;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ExpandableHListView extends HListView {
    private static final int[] EMPTY_STATE_SET = new int[0];
    private static final int[] emD = {16842920};
    private static final int[] emE = {16842921};
    private static final int[] emF = {16842920, 16842921};
    private static final int[][] emG = {EMPTY_STATE_SET, emD, emE, emF};
    private static final int[] emH = {16842918};
    private int emA;
    private Drawable emB;
    private Drawable emC;
    private Drawable emI;
    private final Rect emJ;
    private int emK;
    private int emL;
    private int emM;
    private int emN;
    private d emO;
    private e emP;
    private c emQ;
    private b emR;
    private ExpandableHListConnector emu;
    private ExpandableListAdapter emv;
    private int emw;
    private int emx;
    private int emy;
    private int emz;
    private final Rect mTempRect;
    private int rh;

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

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        aDv();
        aDw();
    }

    private void aDv() {
        if (this.emB != null) {
            this.emK = this.emB.getIntrinsicWidth();
            this.emL = this.emB.getIntrinsicHeight();
            return;
        }
        this.emK = 0;
        this.emL = 0;
    }

    private void aDw() {
        if (this.emC != null) {
            this.emM = this.emC.getIntrinsicWidth();
            this.emN = this.emC.getIntrinsicHeight();
            return;
        }
        this.emM = 0;
        this.emN = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.emC != null || this.emB != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.mItemCount - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            Rect rect = this.emJ;
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
                            ExpandableHListConnector.b oZ = this.emu.oZ(i4);
                            if (oZ.emo.type != i2) {
                                if (oZ.emo.type == 1) {
                                    rect.top = childAt.getTop() + this.emz;
                                    rect.bottom = childAt.getBottom() + this.emz;
                                } else {
                                    rect.top = childAt.getTop() + this.emw;
                                    rect.bottom = childAt.getBottom() + this.emw;
                                }
                                i2 = oZ.emo.type;
                            }
                            if (rect.top != rect.bottom) {
                                if (oZ.emo.type == 1) {
                                    rect.left = this.emA + left;
                                    rect.right = this.emA + right2;
                                } else {
                                    rect.left = this.rh + left;
                                    rect.right = this.rh + right2;
                                }
                                Drawable c2 = c(oZ);
                                if (c2 != null) {
                                    if (oZ.emo.type == 1) {
                                        Gravity.apply(this.emy, this.emM, this.emN, rect, this.mTempRect);
                                    } else {
                                        Gravity.apply(this.emx, this.emK, this.emL, rect, this.mTempRect);
                                    }
                                    c2.setBounds(this.mTempRect);
                                    c2.draw(canvas);
                                }
                            }
                            oZ.recycle();
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
        if (bVar.emo.type == 2) {
            Drawable drawable = this.emB;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            drawable.setState(emG[(bVar.atx() ? (char) 1 : (char) 0) | (bVar.emp == null || bVar.emp.emj == bVar.emp.emi ? (char) 2 : (char) 0)]);
            return drawable;
        }
        Drawable drawable2 = this.emC;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(bVar.emo.emt == bVar.emp.emj ? emH : EMPTY_STATE_SET);
        }
        return drawable2;
    }

    public void setChildDivider(Drawable drawable) {
        this.emI = drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tieba.horizonalList.widget.HListView
    public void drawDivider(Canvas canvas, Rect rect, int i) {
        int i2 = this.mFirstPosition + i;
        if (i2 >= 0) {
            ExpandableHListConnector.b oZ = this.emu.oZ(pc(i2));
            if (oZ.emo.type == 1 || (oZ.atx() && oZ.emp.emj != oZ.emp.emi)) {
                Drawable drawable = this.emI;
                drawable.setBounds(rect);
                drawable.draw(canvas);
                oZ.recycle();
                return;
            }
            oZ.recycle();
        }
        super.drawDivider(canvas, rect, i2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.a
    public void setAdapter(ListAdapter listAdapter) {
        throw new RuntimeException("For ExpandableListView, use setAdapter(ExpandableListAdapter) instead of setAdapter(ListAdapter)");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.a
    public ListAdapter getAdapter() {
        return super.getAdapter();
    }

    @Override // com.baidu.tieba.horizonalList.widget.a
    public void setOnItemClickListener(a.c cVar) {
        super.setOnItemClickListener(cVar);
    }

    public void setAdapter(ExpandableListAdapter expandableListAdapter) {
        this.emv = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.emu = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.emu = null;
        }
        super.setAdapter((ListAdapter) this.emu);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.emv;
    }

    private boolean isHeaderOrFooterPosition(int i) {
        return i < getHeaderViewsCount() || i >= this.mItemCount - getFooterViewsCount();
    }

    private int pc(int i) {
        return i - getHeaderViewsCount();
    }

    private int pd(int i) {
        return getHeaderViewsCount() + i;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.a
    public boolean performItemClick(View view, int i, long j) {
        if (isHeaderOrFooterPosition(i)) {
            return super.performItemClick(view, i, j);
        }
        return b(view, pc(i), j);
    }

    boolean b(View view, int i, long j) {
        boolean z;
        ExpandableHListConnector.b oZ = this.emu.oZ(i);
        long b2 = b(oZ.emo);
        if (oZ.emo.type == 2) {
            if (this.emQ != null && this.emQ.a(this, view, oZ.emo.emr, b2)) {
                oZ.recycle();
                return true;
            }
            if (oZ.atx()) {
                this.emu.a(oZ);
                playSoundEffect(0);
                if (this.emO != null) {
                    this.emO.onGroupCollapse(oZ.emo.emr);
                }
            } else {
                this.emu.b(oZ);
                playSoundEffect(0);
                if (this.emP != null) {
                    this.emP.onGroupExpand(oZ.emo.emr);
                }
                int i2 = oZ.emo.emr;
                int headerViewsCount = oZ.emo.emt + getHeaderViewsCount();
                smoothScrollToPosition(this.emv.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.emR != null) {
            playSoundEffect(0);
            return this.emR.a(this, view, oZ.emo.emr, oZ.emo.ems, b2);
        } else {
            z = false;
        }
        oZ.recycle();
        return z;
    }

    public void setOnGroupCollapseListener(d dVar) {
        this.emO = dVar;
    }

    public void setOnGroupExpandListener(e eVar) {
        this.emP = eVar;
    }

    public void setOnGroupClickListener(c cVar) {
        this.emQ = cVar;
    }

    public void setOnChildClickListener(b bVar) {
        this.emR = bVar;
    }

    public long getExpandableListPosition(int i) {
        if (isHeaderOrFooterPosition(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b oZ = this.emu.oZ(pc(i));
        long aDt = oZ.emo.aDt();
        oZ.recycle();
        return aDt;
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
            return this.emv.getGroupId(packedPositionGroup);
        }
        return this.emv.getChildId(packedPositionGroup, getPackedPositionChild(selectedPosition));
    }

    public void setSelectedGroup(int i) {
        com.baidu.tieba.horizonalList.widget.b pb = com.baidu.tieba.horizonalList.widget.b.pb(i);
        ExpandableHListConnector.b a2 = this.emu.a(pb);
        pb.recycle();
        super.setSelection(pd(a2.emo.emt));
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
    ContextMenu.ContextMenuInfo createContextMenuInfo(View view, int i, long j) {
        if (isHeaderOrFooterPosition(i)) {
            return new a.ContextMenu$ContextMenuInfoC0164a(view, i, j);
        }
        ExpandableHListConnector.b oZ = this.emu.oZ(pc(i));
        com.baidu.tieba.horizonalList.widget.b bVar = oZ.emo;
        long b2 = b(bVar);
        long aDt = bVar.aDt();
        oZ.recycle();
        return new a(view, aDt, b2);
    }

    private long b(com.baidu.tieba.horizonalList.widget.b bVar) {
        return bVar.type == 1 ? this.emv.getChildId(bVar.emr, bVar.ems) : this.emv.getGroupId(bVar.emr);
    }

    public void setChildIndicator(Drawable drawable) {
        this.emC = drawable;
        aDw();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.emB = drawable;
        aDv();
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.tieba.horizonalList.widget.ExpandableHListView.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: F */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: pe */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        ArrayList<ExpandableHListConnector.GroupMetadata> emS;

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.emS = arrayList;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.emS = new ArrayList<>();
            parcel.readList(this.emS, ExpandableHListConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.emS);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.emu != null ? this.emu.aDr() : null);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.emu != null && savedState.emS != null) {
            this.emu.R(savedState.emS);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.a, android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(ExpandableHListView.class.getName());
    }

    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.a, android.view.View
    @TargetApi(14)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(ExpandableHListView.class.getName());
    }
}
