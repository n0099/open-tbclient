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
import com.baidu.tieba.R$styleable;
import com.baidu.tieba.horizonalList.widget.AdapterView;
import com.baidu.tieba.horizonalList.widget.ExpandableHListConnector;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class ExpandableHListView extends HListView {
    public static final int[] A;
    public static final int[] B;
    public static final int[] C;
    public static final int[][] D;
    public static final int[] E = {16842918};
    public static final int[] z;

    /* renamed from: e  reason: collision with root package name */
    public ExpandableHListConnector f17195e;

    /* renamed from: f  reason: collision with root package name */
    public ExpandableListAdapter f17196f;

    /* renamed from: g  reason: collision with root package name */
    public int f17197g;

    /* renamed from: h  reason: collision with root package name */
    public int f17198h;
    public int i;
    public int j;
    public int k;
    public int l;
    public Drawable m;
    public Drawable n;
    public Drawable o;
    public final Rect p;
    public final Rect q;
    public int r;
    public int s;
    public int t;
    public int u;
    public e v;
    public f w;
    public d x;
    public c y;

    /* loaded from: classes4.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: e  reason: collision with root package name */
        public ArrayList<ExpandableHListConnector.GroupMetadata> f17199e;

        /* loaded from: classes4.dex */
        public static class a implements Parcelable.Creator<SavedState> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.f17199e);
        }

        public SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.f17199e = arrayList;
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            ArrayList<ExpandableHListConnector.GroupMetadata> arrayList = new ArrayList<>();
            this.f17199e = arrayList;
            parcel.readList(arrayList, ExpandableHListConnector.class.getClassLoader());
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements ContextMenu.ContextMenuInfo {

        /* renamed from: a  reason: collision with root package name */
        public View f17200a;

        public b(View view, long j, long j2) {
            this.f17200a = view;
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        boolean a(ExpandableHListView expandableHListView, View view, int i, int i2, long j);
    }

    /* loaded from: classes4.dex */
    public interface d {
        boolean a(ExpandableHListView expandableHListView, View view, int i, long j);
    }

    /* loaded from: classes4.dex */
    public interface e {
        void a(int i);
    }

    /* loaded from: classes4.dex */
    public interface f {
        void a(int i);
    }

    static {
        int[] iArr = new int[0];
        z = iArr;
        int[] iArr2 = {16842920};
        A = iArr2;
        int[] iArr3 = {16842921};
        B = iArr3;
        int[] iArr4 = {16842920, 16842921};
        C = iArr4;
        D = new int[][]{iArr, iArr2, iArr3, iArr4};
    }

    public ExpandableHListView(Context context) {
        this(context, null);
    }

    public static int f(long j) {
        if (j != 4294967295L && (j & Long.MIN_VALUE) == Long.MIN_VALUE) {
            return (int) (j & 4294967295L);
        }
        return -1;
    }

    public static int g(long j) {
        if (j == 4294967295L) {
            return -1;
        }
        return (int) ((j & 9223372032559808512L) >> 32);
    }

    public static int h(long j) {
        if (j == 4294967295L) {
            return 2;
        }
        return (j & Long.MIN_VALUE) == Long.MIN_VALUE ? 1 : 0;
    }

    public final int a(int i) {
        return i + getHeaderViewsCount();
    }

    public final long b(d.b.j0.b1.b.a aVar) {
        if (aVar.f53716d == 1) {
            return this.f17196f.getChildId(aVar.f53713a, aVar.f53714b);
        }
        return this.f17196f.getGroupId(aVar.f53713a);
    }

    public long c(int i) {
        if (j(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b i2 = this.f17195e.i(d(i));
        long a2 = i2.f17192a.a();
        i2.d();
        return a2;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView
    public ContextMenu.ContextMenuInfo createContextMenuInfo(View view, int i, long j) {
        if (j(i)) {
            return new AdapterView.b(view, i, j);
        }
        ExpandableHListConnector.b i2 = this.f17195e.i(d(i));
        d.b.j0.b1.b.a aVar = i2.f17192a;
        long b2 = b(aVar);
        long a2 = aVar.a();
        i2.d();
        return new b(view, a2, b2);
    }

    public final int d(int i) {
        return i - getHeaderViewsCount();
    }

    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.n == null && this.m == null) {
            return;
        }
        int headerViewsCount = getHeaderViewsCount();
        int footerViewsCount = ((this.mItemCount - getFooterViewsCount()) - headerViewsCount) - 1;
        int right = getRight();
        int i = -4;
        Rect rect = this.p;
        int childCount = getChildCount();
        int i2 = 0;
        int i3 = this.mFirstPosition - headerViewsCount;
        while (i2 < childCount) {
            if (i3 >= 0) {
                if (i3 > footerViewsCount) {
                    return;
                }
                View childAt = getChildAt(i2);
                int left = childAt.getLeft();
                int right2 = childAt.getRight();
                if (right2 >= 0 && left <= right) {
                    ExpandableHListConnector.b i4 = this.f17195e.i(i3);
                    int i5 = i4.f17192a.f53716d;
                    if (i5 != i) {
                        if (i5 == 1) {
                            rect.top = childAt.getTop() + this.k;
                            rect.bottom = childAt.getBottom() + this.k;
                        } else {
                            rect.top = childAt.getTop() + this.f17197g;
                            rect.bottom = childAt.getBottom() + this.f17197g;
                        }
                        i = i4.f17192a.f53716d;
                    }
                    if (rect.top != rect.bottom) {
                        if (i4.f17192a.f53716d == 1) {
                            int i6 = this.l;
                            rect.left = left + i6;
                            rect.right = right2 + i6;
                        } else {
                            int i7 = this.f17198h;
                            rect.left = left + i7;
                            rect.right = right2 + i7;
                        }
                        Drawable e2 = e(i4);
                        if (e2 != null) {
                            if (i4.f17192a.f53716d == 1) {
                                Gravity.apply(this.j, this.t, this.u, rect, this.q);
                            } else {
                                Gravity.apply(this.i, this.r, this.s, rect, this.q);
                            }
                            e2.setBounds(this.q);
                            e2.draw(canvas);
                        }
                    }
                    i4.d();
                }
            }
            i2++;
            i3++;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0022, code lost:
        if (r1.f17187f != r1.f17186e) goto L10;
     */
    @Override // com.baidu.tieba.horizonalList.widget.HListView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void drawDivider(Canvas canvas, Rect rect, int i) {
        int i2 = i + this.mFirstPosition;
        if (i2 >= 0) {
            ExpandableHListConnector.b i3 = this.f17195e.i(d(i2));
            if (i3.f17192a.f53716d != 1) {
                if (i3.b()) {
                    ExpandableHListConnector.GroupMetadata groupMetadata = i3.f17193b;
                }
                i3.d();
            }
            Drawable drawable = this.o;
            drawable.setBounds(rect);
            drawable.draw(canvas);
            i3.d();
            return;
        }
        super.drawDivider(canvas, rect, i2);
    }

    public final Drawable e(ExpandableHListConnector.b bVar) {
        Drawable drawable;
        if (bVar.f17192a.f53716d == 2) {
            drawable = this.m;
            if (drawable != null && drawable.isStateful()) {
                ExpandableHListConnector.GroupMetadata groupMetadata = bVar.f17193b;
                drawable.setState(D[bVar.b() | (groupMetadata == null || groupMetadata.f17187f == groupMetadata.f17186e ? (char) 2 : (char) 0)]);
            }
        } else {
            drawable = this.n;
            if (drawable != null && drawable.isStateful()) {
                drawable.setState(bVar.f17192a.f53715c == bVar.f17193b.f17187f ? E : z);
            }
        }
        return drawable;
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.f17196f;
    }

    public long getSelectedId() {
        long selectedPosition = getSelectedPosition();
        if (selectedPosition == 4294967295L) {
            return -1L;
        }
        int g2 = g(selectedPosition);
        if (h(selectedPosition) == 0) {
            return this.f17196f.getGroupId(g2);
        }
        return this.f17196f.getChildId(g2, f(selectedPosition));
    }

    public long getSelectedPosition() {
        return c(getSelectedItemPosition());
    }

    public boolean i(View view, int i, long j) {
        ExpandableHListConnector.b i2 = this.f17195e.i(i);
        long b2 = b(i2.f17192a);
        d.b.j0.b1.b.a aVar = i2.f17192a;
        boolean z2 = true;
        if (aVar.f53716d == 2) {
            d dVar = this.x;
            if (dVar != null && dVar.a(this, view, aVar.f53713a, b2)) {
                i2.d();
                return true;
            } else if (i2.b()) {
                this.f17195e.c(i2);
                playSoundEffect(0);
                e eVar = this.v;
                if (eVar != null) {
                    eVar.a(i2.f17192a.f53713a);
                }
            } else {
                this.f17195e.d(i2);
                playSoundEffect(0);
                f fVar = this.w;
                if (fVar != null) {
                    fVar.a(i2.f17192a.f53713a);
                }
                d.b.j0.b1.b.a aVar2 = i2.f17192a;
                int i3 = aVar2.f53713a;
                int headerViewsCount = aVar2.f53715c + getHeaderViewsCount();
                smoothScrollToPosition(this.f17196f.getChildrenCount(i3) + headerViewsCount, headerViewsCount);
            }
        } else if (this.y != null) {
            playSoundEffect(0);
            c cVar = this.y;
            d.b.j0.b1.b.a aVar3 = i2.f17192a;
            return cVar.a(this, view, aVar3.f53713a, aVar3.f53714b, b2);
        } else {
            z2 = false;
        }
        i2.d();
        return z2;
    }

    public final boolean j(int i) {
        return i < getHeaderViewsCount() || i >= this.mItemCount - getFooterViewsCount();
    }

    public final void k() {
        Drawable drawable = this.n;
        if (drawable != null) {
            this.t = drawable.getIntrinsicWidth();
            this.u = this.n.getIntrinsicHeight();
            return;
        }
        this.t = 0;
        this.u = 0;
    }

    public final void l() {
        Drawable drawable = this.m;
        if (drawable != null) {
            this.r = drawable.getIntrinsicWidth();
            this.s = this.m.getIntrinsicHeight();
            return;
        }
        this.r = 0;
        this.s = 0;
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

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        ArrayList<ExpandableHListConnector.GroupMetadata> arrayList;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        ExpandableHListConnector expandableHListConnector = this.f17195e;
        if (expandableHListConnector == null || (arrayList = savedState.f17199e) == null) {
            return;
        }
        expandableHListConnector.l(arrayList);
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        l();
        k();
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        ExpandableHListConnector expandableHListConnector = this.f17195e;
        return new SavedState(onSaveInstanceState, expandableHListConnector != null ? expandableHListConnector.g() : null);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.AdapterView
    public boolean performItemClick(View view, int i, long j) {
        if (j(i)) {
            return super.performItemClick(view, i, j);
        }
        return i(view, d(i), j);
    }

    public void setChildDivider(Drawable drawable) {
        this.o = drawable;
    }

    public void setChildIndicator(Drawable drawable) {
        this.n = drawable;
        k();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.m = drawable;
        l();
    }

    public void setOnChildClickListener(c cVar) {
        this.y = cVar;
    }

    public void setOnGroupClickListener(d dVar) {
        this.x = dVar;
    }

    public void setOnGroupCollapseListener(e eVar) {
        this.v = eVar;
    }

    public void setOnGroupExpandListener(f fVar) {
        this.w = fVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AdapterView
    public void setOnItemClickListener(AdapterView.d dVar) {
        super.setOnItemClickListener(dVar);
    }

    public void setSelectedGroup(int i) {
        d.b.j0.b1.b.a d2 = d.b.j0.b1.b.a.d(i);
        ExpandableHListConnector.b h2 = this.f17195e.h(d2);
        d2.e();
        super.setSelection(a(h2.f17192a.f53715c));
        h2.d();
    }

    public ExpandableHListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.hlv_expandableListViewStyle);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AdapterView
    public ListAdapter getAdapter() {
        return super.getAdapter();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        throw new RuntimeException("For ExpandableListView, use setAdapter(ExpandableListAdapter) instead of setAdapter(ListAdapter)");
    }

    public ExpandableHListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.p = new Rect();
        this.q = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ExpandableHListView, i, 0);
        setGroupIndicator(obtainStyledAttributes.getDrawable(R$styleable.ExpandableHListView_hlv_groupIndicator));
        setChildIndicator(obtainStyledAttributes.getDrawable(R$styleable.ExpandableHListView_hlv_childIndicator));
        this.f17198h = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ExpandableHListView_hlv_indicatorPaddingLeft, 0);
        this.f17197g = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ExpandableHListView_hlv_indicatorPaddingTop, 0);
        this.i = obtainStyledAttributes.getInt(R$styleable.ExpandableHListView_hlv_indicatorGravity, 0);
        this.j = obtainStyledAttributes.getInt(R$styleable.ExpandableHListView_hlv_childIndicatorGravity, 0);
        this.l = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ExpandableHListView_hlv_childIndicatorPaddingLeft, 0);
        this.k = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ExpandableHListView_hlv_childIndicatorPaddingTop, 0);
        this.o = obtainStyledAttributes.getDrawable(R$styleable.ExpandableHListView_hlv_childDivider);
        obtainStyledAttributes.recycle();
    }

    public void setAdapter(ExpandableListAdapter expandableListAdapter) {
        this.f17196f = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.f17195e = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.f17195e = null;
        }
        super.setAdapter((ListAdapter) this.f17195e);
    }
}
