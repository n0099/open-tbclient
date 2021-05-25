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
    public ExpandableHListConnector f16712e;

    /* renamed from: f  reason: collision with root package name */
    public ExpandableListAdapter f16713f;

    /* renamed from: g  reason: collision with root package name */
    public int f16714g;

    /* renamed from: h  reason: collision with root package name */
    public int f16715h;

    /* renamed from: i  reason: collision with root package name */
    public int f16716i;
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
        public ArrayList<ExpandableHListConnector.GroupMetadata> f16717e;

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
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeList(this.f16717e);
        }

        public SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.f16717e = arrayList;
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            ArrayList<ExpandableHListConnector.GroupMetadata> arrayList = new ArrayList<>();
            this.f16717e = arrayList;
            parcel.readList(arrayList, ExpandableHListConnector.class.getClassLoader());
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements ContextMenu.ContextMenuInfo {

        /* renamed from: a  reason: collision with root package name */
        public View f16718a;

        public b(View view, long j, long j2) {
            this.f16718a = view;
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        boolean a(ExpandableHListView expandableHListView, View view, int i2, int i3, long j);
    }

    /* loaded from: classes4.dex */
    public interface d {
        boolean a(ExpandableHListView expandableHListView, View view, int i2, long j);
    }

    /* loaded from: classes4.dex */
    public interface e {
        void a(int i2);
    }

    /* loaded from: classes4.dex */
    public interface f {
        void a(int i2);
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

    public final int a(int i2) {
        return i2 + getHeaderViewsCount();
    }

    public final long b(d.a.n0.c1.b.a aVar) {
        if (aVar.f52319d == 1) {
            return this.f16713f.getChildId(aVar.f52316a, aVar.f52317b);
        }
        return this.f16713f.getGroupId(aVar.f52316a);
    }

    public long c(int i2) {
        if (j(i2)) {
            return 4294967295L;
        }
        ExpandableHListConnector.b i3 = this.f16712e.i(d(i2));
        long a2 = i3.f16709a.a();
        i3.d();
        return a2;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView
    public ContextMenu.ContextMenuInfo createContextMenuInfo(View view, int i2, long j) {
        if (j(i2)) {
            return new AdapterView.b(view, i2, j);
        }
        ExpandableHListConnector.b i3 = this.f16712e.i(d(i2));
        d.a.n0.c1.b.a aVar = i3.f16709a;
        long b2 = b(aVar);
        long a2 = aVar.a();
        i3.d();
        return new b(view, a2, b2);
    }

    public final int d(int i2) {
        return i2 - getHeaderViewsCount();
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
        int i2 = -4;
        Rect rect = this.p;
        int childCount = getChildCount();
        int i3 = 0;
        int i4 = this.mFirstPosition - headerViewsCount;
        while (i3 < childCount) {
            if (i4 >= 0) {
                if (i4 > footerViewsCount) {
                    return;
                }
                View childAt = getChildAt(i3);
                int left = childAt.getLeft();
                int right2 = childAt.getRight();
                if (right2 >= 0 && left <= right) {
                    ExpandableHListConnector.b i5 = this.f16712e.i(i4);
                    int i6 = i5.f16709a.f52319d;
                    if (i6 != i2) {
                        if (i6 == 1) {
                            rect.top = childAt.getTop() + this.k;
                            rect.bottom = childAt.getBottom() + this.k;
                        } else {
                            rect.top = childAt.getTop() + this.f16714g;
                            rect.bottom = childAt.getBottom() + this.f16714g;
                        }
                        i2 = i5.f16709a.f52319d;
                    }
                    if (rect.top != rect.bottom) {
                        if (i5.f16709a.f52319d == 1) {
                            int i7 = this.l;
                            rect.left = left + i7;
                            rect.right = right2 + i7;
                        } else {
                            int i8 = this.f16715h;
                            rect.left = left + i8;
                            rect.right = right2 + i8;
                        }
                        Drawable e2 = e(i5);
                        if (e2 != null) {
                            if (i5.f16709a.f52319d == 1) {
                                Gravity.apply(this.j, this.t, this.u, rect, this.q);
                            } else {
                                Gravity.apply(this.f16716i, this.r, this.s, rect, this.q);
                            }
                            e2.setBounds(this.q);
                            e2.draw(canvas);
                        }
                    }
                    i5.d();
                }
            }
            i3++;
            i4++;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0022, code lost:
        if (r1.f16704f != r1.f16703e) goto L10;
     */
    @Override // com.baidu.tieba.horizonalList.widget.HListView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void drawDivider(Canvas canvas, Rect rect, int i2) {
        int i3 = i2 + this.mFirstPosition;
        if (i3 >= 0) {
            ExpandableHListConnector.b i4 = this.f16712e.i(d(i3));
            if (i4.f16709a.f52319d != 1) {
                if (i4.b()) {
                    ExpandableHListConnector.GroupMetadata groupMetadata = i4.f16710b;
                }
                i4.d();
            }
            Drawable drawable = this.o;
            drawable.setBounds(rect);
            drawable.draw(canvas);
            i4.d();
            return;
        }
        super.drawDivider(canvas, rect, i3);
    }

    public final Drawable e(ExpandableHListConnector.b bVar) {
        Drawable drawable;
        if (bVar.f16709a.f52319d == 2) {
            drawable = this.m;
            if (drawable != null && drawable.isStateful()) {
                ExpandableHListConnector.GroupMetadata groupMetadata = bVar.f16710b;
                drawable.setState(D[bVar.b() | (groupMetadata == null || groupMetadata.f16704f == groupMetadata.f16703e ? (char) 2 : (char) 0)]);
            }
        } else {
            drawable = this.n;
            if (drawable != null && drawable.isStateful()) {
                drawable.setState(bVar.f16709a.f52318c == bVar.f16710b.f16704f ? E : z);
            }
        }
        return drawable;
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.f16713f;
    }

    public long getSelectedId() {
        long selectedPosition = getSelectedPosition();
        if (selectedPosition == 4294967295L) {
            return -1L;
        }
        int g2 = g(selectedPosition);
        if (h(selectedPosition) == 0) {
            return this.f16713f.getGroupId(g2);
        }
        return this.f16713f.getChildId(g2, f(selectedPosition));
    }

    public long getSelectedPosition() {
        return c(getSelectedItemPosition());
    }

    public boolean i(View view, int i2, long j) {
        ExpandableHListConnector.b i3 = this.f16712e.i(i2);
        long b2 = b(i3.f16709a);
        d.a.n0.c1.b.a aVar = i3.f16709a;
        boolean z2 = true;
        if (aVar.f52319d == 2) {
            d dVar = this.x;
            if (dVar != null && dVar.a(this, view, aVar.f52316a, b2)) {
                i3.d();
                return true;
            } else if (i3.b()) {
                this.f16712e.c(i3);
                playSoundEffect(0);
                e eVar = this.v;
                if (eVar != null) {
                    eVar.a(i3.f16709a.f52316a);
                }
            } else {
                this.f16712e.d(i3);
                playSoundEffect(0);
                f fVar = this.w;
                if (fVar != null) {
                    fVar.a(i3.f16709a.f52316a);
                }
                d.a.n0.c1.b.a aVar2 = i3.f16709a;
                int i4 = aVar2.f52316a;
                int headerViewsCount = aVar2.f52318c + getHeaderViewsCount();
                smoothScrollToPosition(this.f16713f.getChildrenCount(i4) + headerViewsCount, headerViewsCount);
            }
        } else if (this.y != null) {
            playSoundEffect(0);
            c cVar = this.y;
            d.a.n0.c1.b.a aVar3 = i3.f16709a;
            return cVar.a(this, view, aVar3.f52316a, aVar3.f52317b, b2);
        } else {
            z2 = false;
        }
        i3.d();
        return z2;
    }

    public final boolean j(int i2) {
        return i2 < getHeaderViewsCount() || i2 >= this.mItemCount - getFooterViewsCount();
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
        ExpandableHListConnector expandableHListConnector = this.f16712e;
        if (expandableHListConnector == null || (arrayList = savedState.f16717e) == null) {
            return;
        }
        expandableHListConnector.l(arrayList);
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i2) {
        l();
        k();
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        ExpandableHListConnector expandableHListConnector = this.f16712e;
        return new SavedState(onSaveInstanceState, expandableHListConnector != null ? expandableHListConnector.g() : null);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.AdapterView
    public boolean performItemClick(View view, int i2, long j) {
        if (j(i2)) {
            return super.performItemClick(view, i2, j);
        }
        return i(view, d(i2), j);
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

    public void setSelectedGroup(int i2) {
        d.a.n0.c1.b.a d2 = d.a.n0.c1.b.a.d(i2);
        ExpandableHListConnector.b h2 = this.f16712e.h(d2);
        d2.e();
        super.setSelection(a(h2.f16709a.f52318c));
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

    public ExpandableHListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.p = new Rect();
        this.q = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ExpandableHListView, i2, 0);
        setGroupIndicator(obtainStyledAttributes.getDrawable(R$styleable.ExpandableHListView_hlv_groupIndicator));
        setChildIndicator(obtainStyledAttributes.getDrawable(R$styleable.ExpandableHListView_hlv_childIndicator));
        this.f16715h = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ExpandableHListView_hlv_indicatorPaddingLeft, 0);
        this.f16714g = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ExpandableHListView_hlv_indicatorPaddingTop, 0);
        this.f16716i = obtainStyledAttributes.getInt(R$styleable.ExpandableHListView_hlv_indicatorGravity, 0);
        this.j = obtainStyledAttributes.getInt(R$styleable.ExpandableHListView_hlv_childIndicatorGravity, 0);
        this.l = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ExpandableHListView_hlv_childIndicatorPaddingLeft, 0);
        this.k = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ExpandableHListView_hlv_childIndicatorPaddingTop, 0);
        this.o = obtainStyledAttributes.getDrawable(R$styleable.ExpandableHListView_hlv_childDivider);
        obtainStyledAttributes.recycle();
    }

    public void setAdapter(ExpandableListAdapter expandableListAdapter) {
        this.f16713f = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.f16712e = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.f16712e = null;
        }
        super.setAdapter((ListAdapter) this.f16712e);
    }
}
