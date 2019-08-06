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
    private Drawable gqC;
    private final Rect gqD;
    private int gqE;
    private int gqF;
    private int gqG;
    private int gqH;
    private d gqI;
    private e gqJ;
    private c gqK;
    private b gqL;
    private ExpandableHListConnector gqo;
    private ExpandableListAdapter gqp;
    private int gqq;
    private int gqr;
    private int gqs;
    private int gqt;
    private int gqu;
    private Drawable gqv;
    private Drawable gqw;
    private int mIndicatorLeft;
    private final Rect mTempRect;
    private static final int[] EMPTY_STATE_SET = new int[0];
    private static final int[] gqx = {16842920};
    private static final int[] gqy = {16842921};
    private static final int[] gqz = {16842920, 16842921};
    private static final int[][] gqA = {EMPTY_STATE_SET, gqx, gqy, gqz};
    private static final int[] gqB = {16842918};

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
        void uA(int i);
    }

    /* loaded from: classes.dex */
    public interface e {
        void uB(int i);
    }

    public ExpandableHListView(Context context) {
        this(context, null);
    }

    public ExpandableHListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.hlv_expandableListViewStyle);
    }

    public ExpandableHListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gqD = new Rect();
        this.mTempRect = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.a.ExpandableHListView, i, 0);
        setGroupIndicator(obtainStyledAttributes.getDrawable(5));
        setChildIndicator(obtainStyledAttributes.getDrawable(1));
        this.mIndicatorLeft = obtainStyledAttributes.getDimensionPixelSize(7, 0);
        this.gqq = obtainStyledAttributes.getDimensionPixelSize(8, 0);
        this.gqr = obtainStyledAttributes.getInt(2, 0);
        this.gqs = obtainStyledAttributes.getInt(3, 0);
        this.gqu = obtainStyledAttributes.getDimensionPixelSize(6, 0);
        this.gqt = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.gqC = obtainStyledAttributes.getDrawable(4);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        byg();
        byh();
    }

    private void byg() {
        if (this.gqv != null) {
            this.gqE = this.gqv.getIntrinsicWidth();
            this.gqF = this.gqv.getIntrinsicHeight();
            return;
        }
        this.gqE = 0;
        this.gqF = 0;
    }

    private void byh() {
        if (this.gqw != null) {
            this.gqG = this.gqw.getIntrinsicWidth();
            this.gqH = this.gqw.getIntrinsicHeight();
            return;
        }
        this.gqG = 0;
        this.gqH = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.gqw != null || this.gqv != null) {
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.mItemCount - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            Rect rect = this.gqD;
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
                            ExpandableHListConnector.b ut = this.gqo.ut(i4);
                            if (ut.gqi.type != i2) {
                                if (ut.gqi.type == 1) {
                                    rect.top = childAt.getTop() + this.gqt;
                                    rect.bottom = childAt.getBottom() + this.gqt;
                                } else {
                                    rect.top = childAt.getTop() + this.gqq;
                                    rect.bottom = childAt.getBottom() + this.gqq;
                                }
                                i2 = ut.gqi.type;
                            }
                            if (rect.top != rect.bottom) {
                                if (ut.gqi.type == 1) {
                                    rect.left = this.gqu + left;
                                    rect.right = this.gqu + right2;
                                } else {
                                    rect.left = this.mIndicatorLeft + left;
                                    rect.right = this.mIndicatorLeft + right2;
                                }
                                Drawable c2 = c(ut);
                                if (c2 != null) {
                                    if (ut.gqi.type == 1) {
                                        Gravity.apply(this.gqs, this.gqG, this.gqH, rect, this.mTempRect);
                                    } else {
                                        Gravity.apply(this.gqr, this.gqE, this.gqF, rect, this.mTempRect);
                                    }
                                    c2.setBounds(this.mTempRect);
                                    c2.draw(canvas);
                                }
                            }
                            ut.recycle();
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
        if (bVar.gqi.type == 2) {
            Drawable drawable = this.gqv;
            if (drawable == null || !drawable.isStateful()) {
                return drawable;
            }
            drawable.setState(gqA[(bVar.bju() ? (char) 1 : (char) 0) | (bVar.gqj == null || bVar.gqj.gqd == bVar.gqj.gqc ? (char) 2 : (char) 0)]);
            return drawable;
        }
        Drawable drawable2 = this.gqw;
        if (drawable2 != null && drawable2.isStateful()) {
            drawable2.setState(bVar.gqi.gqn == bVar.gqj.gqd ? gqB : EMPTY_STATE_SET);
        }
        return drawable2;
    }

    public void setChildDivider(Drawable drawable) {
        this.gqC = drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.tieba.horizonalList.widget.HListView
    public void drawDivider(Canvas canvas, Rect rect, int i) {
        int i2 = this.mFirstPosition + i;
        if (i2 >= 0) {
            ExpandableHListConnector.b ut = this.gqo.ut(ux(i2));
            if (ut.gqi.type == 1 || (ut.bju() && ut.gqj.gqd != ut.gqj.gqc)) {
                Drawable drawable = this.gqC;
                drawable.setBounds(rect);
                drawable.draw(canvas);
                ut.recycle();
                return;
            }
            ut.recycle();
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
        this.gqp = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.gqo = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.gqo = null;
        }
        super.setAdapter((ListAdapter) this.gqo);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.gqp;
    }

    private boolean isHeaderOrFooterPosition(int i) {
        return i < getHeaderViewsCount() || i >= this.mItemCount - getFooterViewsCount();
    }

    private int ux(int i) {
        return i - getHeaderViewsCount();
    }

    private int uy(int i) {
        return getHeaderViewsCount() + i;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.AdapterView
    public boolean performItemClick(View view, int i, long j) {
        if (isHeaderOrFooterPosition(i)) {
            return super.performItemClick(view, i, j);
        }
        return d(view, ux(i), j);
    }

    boolean d(View view, int i, long j) {
        boolean z;
        ExpandableHListConnector.b ut = this.gqo.ut(i);
        long b2 = b(ut.gqi);
        if (ut.gqi.type == 2) {
            if (this.gqK != null && this.gqK.a(this, view, ut.gqi.gql, b2)) {
                ut.recycle();
                return true;
            }
            if (ut.bju()) {
                this.gqo.a(ut);
                playSoundEffect(0);
                if (this.gqI != null) {
                    this.gqI.uA(ut.gqi.gql);
                }
            } else {
                this.gqo.b(ut);
                playSoundEffect(0);
                if (this.gqJ != null) {
                    this.gqJ.uB(ut.gqi.gql);
                }
                int i2 = ut.gqi.gql;
                int headerViewsCount = ut.gqi.gqn + getHeaderViewsCount();
                smoothScrollToPosition(this.gqp.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.gqL != null) {
            playSoundEffect(0);
            return this.gqL.a(this, view, ut.gqi.gql, ut.gqi.gqm, b2);
        } else {
            z = false;
        }
        ut.recycle();
        return z;
    }

    public void setOnGroupCollapseListener(d dVar) {
        this.gqI = dVar;
    }

    public void setOnGroupExpandListener(e eVar) {
        this.gqJ = eVar;
    }

    public void setOnGroupClickListener(c cVar) {
        this.gqK = cVar;
    }

    public void setOnChildClickListener(b bVar) {
        this.gqL = bVar;
    }

    public long uz(int i) {
        if (isHeaderOrFooterPosition(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b ut = this.gqo.ut(ux(i));
        long bye = ut.gqi.bye();
        ut.recycle();
        return bye;
    }

    public long getSelectedPosition() {
        return uz(getSelectedItemPosition());
    }

    public long getSelectedId() {
        long selectedPosition = getSelectedPosition();
        if (selectedPosition == 4294967295L) {
            return -1L;
        }
        int du = du(selectedPosition);
        if (dt(selectedPosition) == 0) {
            return this.gqp.getGroupId(du);
        }
        return this.gqp.getChildId(du, dv(selectedPosition));
    }

    public void setSelectedGroup(int i) {
        com.baidu.tieba.horizonalList.widget.a uw = com.baidu.tieba.horizonalList.widget.a.uw(i);
        ExpandableHListConnector.b a2 = this.gqo.a(uw);
        uw.recycle();
        super.setSelection(uy(a2.gqi.gqn));
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
        ExpandableHListConnector.b ut = this.gqo.ut(ux(i));
        com.baidu.tieba.horizonalList.widget.a aVar = ut.gqi;
        long b2 = b(aVar);
        long bye = aVar.bye();
        ut.recycle();
        return new a(view, bye, b2);
    }

    private long b(com.baidu.tieba.horizonalList.widget.a aVar) {
        return aVar.type == 1 ? this.gqp.getChildId(aVar.gql, aVar.gqm) : this.gqp.getGroupId(aVar.gql);
    }

    public void setChildIndicator(Drawable drawable) {
        this.gqw = drawable;
        byh();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.gqv = drawable;
        byg();
    }

    /* loaded from: classes.dex */
    public static class a implements ContextMenu.ContextMenuInfo {
        public View aMO;
        public long gqM;
        public long id;

        public a(View view, long j, long j2) {
            this.aMO = view;
            this.gqM = j;
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
            /* renamed from: uC */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        ArrayList<ExpandableHListConnector.GroupMetadata> gqN;

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.gqN = arrayList;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.gqN = new ArrayList<>();
            parcel.readList(this.gqN, ExpandableHListConnector.class.getClassLoader());
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.gqN);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.gqo != null ? this.gqo.byc() : null);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.gqo != null && savedState.gqN != null) {
            this.gqo.af(savedState.gqN);
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
