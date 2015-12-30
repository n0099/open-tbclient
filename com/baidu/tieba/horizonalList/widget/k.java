package com.baidu.tieba.horizonalList.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.media.TransportMediator;
import android.support.v4.util.SparseArrayCompat;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.view.FocusFinder;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ArrayAdapter;
import android.widget.Checkable;
import android.widget.ListAdapter;
import android.widget.RemoteViews;
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
import com.baidu.location.BDLocation;
import com.baidu.location.a0;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
import com.baidu.tieba.n;
import java.util.ArrayList;
@RemoteViews.RemoteView
/* loaded from: classes.dex */
public class k extends AbsHListView {
    private ArrayList<b> HX;
    private ArrayList<b> HY;
    Drawable bFi;
    int bFj;
    int bFk;
    Drawable bFl;
    Drawable bFm;
    private boolean bFn;
    private boolean bFo;
    private boolean bFp;
    private boolean bFq;
    private boolean bFr;
    private boolean bFs;
    private Paint bFt;
    private final a bFu;
    private c bFv;
    private GestureDetector mGestureDetector;
    private final Rect mTempRect;

    /* loaded from: classes.dex */
    public static class b {
        public Object data;
        public boolean isSelectable;
        public View view;
    }

    public k(Context context) {
        this(context, null);
    }

    public k(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, n.c.hlv_listViewStyle);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Drawable drawable;
        Drawable drawable2;
        Drawable drawable3;
        CharSequence[] charSequenceArr;
        int i2;
        boolean z;
        int i3 = -1;
        boolean z2 = true;
        this.HX = new ArrayList<>();
        this.HY = new ArrayList<>();
        this.bFr = true;
        this.bFs = false;
        this.mTempRect = new Rect();
        this.bFu = new a(null);
        this.mGestureDetector = new GestureDetector(new d(this, null));
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, n.l.HListView, i, 0);
        if (obtainStyledAttributes != null) {
            charSequenceArr = obtainStyledAttributes.getTextArray(0);
            drawable3 = obtainStyledAttributes.getDrawable(1);
            drawable2 = obtainStyledAttributes.getDrawable(5);
            drawable = obtainStyledAttributes.getDrawable(6);
            i2 = obtainStyledAttributes.getDimensionPixelSize(2, 0);
            z = obtainStyledAttributes.getBoolean(3, true);
            z2 = obtainStyledAttributes.getBoolean(4, true);
            i3 = obtainStyledAttributes.getInteger(7, -1);
            obtainStyledAttributes.recycle();
        } else {
            drawable = null;
            drawable2 = null;
            drawable3 = null;
            charSequenceArr = null;
            i2 = 0;
            z = true;
        }
        if (charSequenceArr != null) {
            setAdapter((ListAdapter) new ArrayAdapter(context, 17367043, charSequenceArr));
        }
        if (drawable3 != null) {
            setDivider(drawable3);
        }
        if (drawable2 != null) {
            setOverscrollHeader(drawable2);
        }
        if (drawable != null) {
            setOverscrollFooter(drawable);
        }
        if (i2 != 0) {
            setDividerWidth(i2);
        }
        this.bFp = z;
        this.bFq = z2;
        this.bFk = i3;
    }

    public int getMaxScrollAmount() {
        return (int) (0.33f * (getRight() - getLeft()));
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0046, code lost:
        if (r1 <= 0) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0048, code lost:
        r0 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001f, code lost:
        if (r1 < 0) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void UZ() {
        int right;
        int i = 0;
        int childCount = getChildCount();
        if (childCount > 0) {
            if (!this.bCv) {
                right = getChildAt(0).getLeft() - this.bCf.left;
                if (this.bDU != 0) {
                    right -= this.bFj;
                }
            } else {
                right = getChildAt(childCount - 1).getRight() - (getWidth() - this.bCf.right);
                if (childCount + this.bDU < this.bEh) {
                    right += this.bFj;
                }
            }
            if (i != 0) {
                hx(-i);
            }
        }
    }

    public void addHeaderView(View view, Object obj, boolean z) {
        if (this.mAdapter != null && !(this.mAdapter instanceof o)) {
            throw new IllegalStateException("Cannot add header view to list -- setAdapter has already been called.");
        }
        b bVar = new b();
        bVar.view = view;
        bVar.data = obj;
        bVar.isSelectable = z;
        this.HX.add(bVar);
        if (this.mAdapter != null && this.bBV != null) {
            this.bBV.onChanged();
        }
    }

    public void addHeaderView(View view) {
        addHeaderView(view, null, true);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView
    public int getHeaderViewsCount() {
        return this.HX.size();
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView
    public int getFooterViewsCount() {
        return this.HY.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.horizonalList.widget.g
    public ListAdapter getAdapter() {
        return this.mAdapter;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView
    public void setAdapter(ListAdapter listAdapter) {
        int k;
        if (this.mAdapter != null && this.bBV != null) {
            this.mAdapter.unregisterDataSetObserver(this.bBV);
        }
        Uh();
        this.bCa.clear();
        if (this.HX.size() > 0 || this.HY.size() > 0) {
            this.mAdapter = new o(this.HX, this.HY, listAdapter);
        } else {
            this.mAdapter = listAdapter;
        }
        this.bEk = -1;
        this.bEl = Long.MIN_VALUE;
        super.setAdapter(listAdapter);
        if (this.mAdapter != null) {
            this.bFr = this.mAdapter.areAllItemsEnabled();
            this.bEi = this.bEh;
            this.bEh = this.mAdapter.getCount();
            UJ();
            this.bBV = new AbsHListView.a();
            this.mAdapter.registerDataSetObserver(this.bBV);
            this.bCa.hD(this.mAdapter.getViewTypeCount());
            if (this.bCv) {
                k = k(this.bEh - 1, false);
            } else {
                k = k(0, true);
            }
            setSelectedPositionInt(k);
            setNextSelectedPositionInt(k);
            if (this.bEh == 0) {
                UO();
            }
        } else {
            this.bFr = true;
            UJ();
            UO();
        }
        requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView
    public void Uh() {
        I(this.HX);
        I(this.HY);
        super.Uh();
        this.bBU = 0;
    }

    private void I(ArrayList<b> arrayList) {
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                AbsHListView.f fVar = (AbsHListView.f) arrayList.get(i).view.getLayoutParams();
                if (fVar != null) {
                    fVar.bDq = false;
                }
            }
        }
    }

    private boolean Va() {
        return this.bDU > 0 || getChildAt(0).getLeft() > getScrollX() + this.bCf.left;
    }

    private boolean Vb() {
        int childCount = getChildCount();
        return (childCount + this.bDU) + (-1) < this.bEh + (-1) || getChildAt(childCount + (-1)).getRight() < (getScrollX() + getWidth()) - this.bCf.right;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        int i;
        int i2;
        int i3;
        int i4 = rect.left;
        rect.offset(view.getLeft(), view.getTop());
        rect.offset(-view.getScrollX(), -view.getScrollY());
        int width = getWidth();
        int scrollX = getScrollX();
        int i5 = scrollX + width;
        int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
        if (Va() && (this.bym > 0 || i4 > horizontalFadingEdgeLength)) {
            scrollX += horizontalFadingEdgeLength;
        }
        int right = getChildAt(getChildCount() - 1).getRight();
        if (Vb() && (this.bym < this.bEh - 1 || rect.right < right - horizontalFadingEdgeLength)) {
            i5 -= horizontalFadingEdgeLength;
        }
        if (rect.right > i5 && rect.left > scrollX) {
            if (rect.width() > width) {
                i3 = (rect.left - scrollX) + 0;
            } else {
                i3 = (rect.right - i5) + 0;
            }
            i = Math.min(i3, right - i5);
        } else if (rect.left >= scrollX || rect.right >= i5) {
            i = 0;
        } else {
            if (rect.width() > width) {
                i2 = 0 - (i5 - rect.right);
            } else {
                i2 = 0 - (scrollX - rect.left);
            }
            i = Math.max(i2, getChildAt(0).getLeft() - scrollX);
        }
        boolean z2 = i != 0;
        if (z2) {
            hX(-i);
            c(-1, view);
            this.bCu = view.getTop();
            invalidate();
        }
        return z2;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView
    protected void cZ(boolean z) {
        int childCount = getChildCount();
        if (z) {
            al(childCount + this.bDU, childCount > 0 ? getChildAt(childCount - 1).getRight() + this.bFj : 0);
            hR(getChildCount());
            return;
        }
        am(this.bDU - 1, childCount > 0 ? getChildAt(0).getLeft() - this.bFj : getWidth() - 0);
        hS(getChildCount());
    }

    private View al(int i, int i2) {
        View view = null;
        int right = getRight() - getLeft();
        int i3 = i2;
        int i4 = i;
        while (i3 < right && i4 < this.bEh) {
            boolean z = i4 == this.bym;
            View a2 = a(i4, i3, true, this.bCf.top, z);
            i3 = a2.getRight() + this.bFj;
            if (!z) {
                a2 = view;
            }
            i4++;
            view = a2;
        }
        ai(this.bDU, (this.bDU + getChildCount()) - 1);
        return view;
    }

    private View am(int i, int i2) {
        View view = null;
        int i3 = i2;
        int i4 = i;
        while (i3 > 0 && i4 >= 0) {
            boolean z = i4 == this.bym;
            View a2 = a(i4, i3, false, this.bCf.top, z);
            i3 = a2.getLeft() - this.bFj;
            if (!z) {
                a2 = view;
            }
            i4--;
            view = a2;
        }
        this.bDU = i4 + 1;
        ai(this.bDU, (this.bDU + getChildCount()) - 1);
        return view;
    }

    private View hQ(int i) {
        this.bDU = Math.min(this.bDU, this.bym);
        this.bDU = Math.min(this.bDU, this.bEh - 1);
        if (this.bDU < 0) {
            this.bDU = 0;
        }
        return al(this.bDU, i);
    }

    private View an(int i, int i2) {
        int i3 = i2 - i;
        int Uu = Uu();
        View a2 = a(Uu, i, true, this.bCf.top, true);
        this.bDU = Uu;
        int measuredWidth = a2.getMeasuredWidth();
        if (measuredWidth <= i3) {
            a2.offsetLeftAndRight((i3 - measuredWidth) / 2);
        }
        p(a2, Uu);
        if (!this.bCv) {
            hR(getChildCount());
        } else {
            hS(getChildCount());
        }
        return a2;
    }

    private void p(View view, int i) {
        int i2 = this.bFj;
        if (!this.bCv) {
            am(i - 1, view.getLeft() - i2);
            UZ();
            al(i + 1, i2 + view.getRight());
            return;
        }
        al(i + 1, view.getRight() + i2);
        UZ();
        am(i - 1, view.getLeft() - i2);
    }

    private View t(int i, int i2, int i3) {
        int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
        int i4 = this.bym;
        int v = v(i2, horizontalFadingEdgeLength, i4);
        int u = u(i3, horizontalFadingEdgeLength, i4);
        View a2 = a(i4, i, true, this.bCf.top, true);
        if (a2.getRight() > u) {
            a2.offsetLeftAndRight(-Math.min(a2.getLeft() - v, a2.getRight() - u));
        } else if (a2.getLeft() < v) {
            a2.offsetLeftAndRight(Math.min(v - a2.getLeft(), u - a2.getRight()));
        }
        p(a2, i4);
        if (!this.bCv) {
            hR(getChildCount());
        } else {
            hS(getChildCount());
        }
        return a2;
    }

    private int u(int i, int i2, int i3) {
        if (i3 != this.bEh - 1) {
            return i - i2;
        }
        return i;
    }

    private int v(int i, int i2, int i3) {
        if (i3 > 0) {
            return i + i2;
        }
        return i;
    }

    private View a(View view, View view2, int i, int i2, int i3) {
        View a2;
        int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
        int i4 = this.bym;
        int v = v(i2, horizontalFadingEdgeLength, i4);
        int u = u(i2, horizontalFadingEdgeLength, i4);
        if (i > 0) {
            View a3 = a(i4 - 1, view.getLeft(), true, this.bCf.top, false);
            int i5 = this.bFj;
            a2 = a(i4, a3.getRight() + i5, true, this.bCf.top, true);
            if (a2.getRight() > u) {
                int min = Math.min(Math.min(a2.getLeft() - v, a2.getRight() - u), (i3 - i2) / 2);
                a3.offsetLeftAndRight(-min);
                a2.offsetLeftAndRight(-min);
            }
            if (!this.bCv) {
                am(this.bym - 2, a2.getLeft() - i5);
                UZ();
                al(this.bym + 1, a2.getRight() + i5);
            } else {
                al(this.bym + 1, a2.getRight() + i5);
                UZ();
                am(this.bym - 2, a2.getLeft() - i5);
            }
        } else if (i < 0) {
            if (view2 != null) {
                a2 = a(i4, view2.getLeft(), true, this.bCf.top, true);
            } else {
                a2 = a(i4, view.getLeft(), false, this.bCf.top, true);
            }
            if (a2.getLeft() < v) {
                a2.offsetLeftAndRight(Math.min(Math.min(v - a2.getLeft(), u - a2.getRight()), (i3 - i2) / 2));
            }
            p(a2, i4);
        } else {
            int left = view.getLeft();
            a2 = a(i4, left, true, this.bCf.top, true);
            if (left < i2 && a2.getRight() < i2 + 20) {
                a2.offsetLeftAndRight(i2 - a2.getLeft());
            }
            p(a2, i4);
        }
        return a2;
    }

    /* loaded from: classes.dex */
    private class c implements Runnable {
        private int anc;
        private int bFx;

        private c() {
        }

        /* synthetic */ c(k kVar, c cVar) {
            this();
        }

        public c as(int i, int i2) {
            this.anc = i;
            this.bFx = i2;
            return this;
        }

        @Override // java.lang.Runnable
        public void run() {
            k.this.ap(this.anc, this.bFx);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        View focusedChild;
        if (getChildCount() > 0 && (focusedChild = getFocusedChild()) != null) {
            int indexOfChild = this.bDU + indexOfChild(focusedChild);
            int left = focusedChild.getLeft() - Math.max(0, focusedChild.getRight() - (i - getPaddingLeft()));
            if (this.bFv == null) {
                this.bFv = new c(this, null);
            }
            post(this.bFv.as(indexOfChild, left));
        }
        super.onSizeChanged(i, i2, i3, i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int i4 = 0;
        int i5 = 0;
        this.bEh = this.mAdapter == null ? 0 : this.mAdapter.getCount();
        if (this.bEh > 0 && (mode == 0 || mode2 == 0)) {
            View a2 = a(0, this.bCP);
            e(a2, 0, i2);
            i4 = a2.getMeasuredWidth();
            i5 = a2.getMeasuredHeight();
            r1 = Build.VERSION.SDK_INT >= 11 ? combineMeasuredStates(0, a2.getMeasuredState()) : 0;
            if (Vc() && this.bCa.hE(((AbsHListView.f) a2.getLayoutParams()).bDp)) {
                this.bCa.o(a2, -1);
            }
        }
        int i6 = i5;
        int i7 = i4;
        if (mode2 == 0) {
            i3 = i6 + this.bCf.top + this.bCf.bottom + getHorizontalScrollbarHeight();
        } else if (mode2 == Integer.MIN_VALUE && this.bEh > 0 && this.bFk > -1) {
            i3 = b(i2, this.bFk, this.bFk, size, size2, -1)[1];
        } else {
            i3 = Build.VERSION.SDK_INT >= 11 ? size2 | ((-16777216) & r1) : size2;
        }
        if (mode == 0) {
            size = this.bCf.left + this.bCf.right + i7 + (getHorizontalFadingEdgeLength() * 2);
        }
        if (mode == Integer.MIN_VALUE) {
            size = b(i2, 0, -1, size, -1);
        }
        setMeasuredDimension(size, i3);
        this.bCg = i2;
    }

    private void e(View view, int i, int i2) {
        int makeMeasureSpec;
        AbsHListView.f fVar = (AbsHListView.f) view.getLayoutParams();
        if (fVar == null) {
            fVar = (AbsHListView.f) generateDefaultLayoutParams();
            view.setLayoutParams(fVar);
        }
        fVar.bDp = this.mAdapter.getItemViewType(i);
        fVar.bDr = true;
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, this.bCf.top + this.bCf.bottom, fVar.height);
        int i3 = fVar.width;
        if (i3 > 0) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(makeMeasureSpec, childMeasureSpec);
    }

    @ViewDebug.ExportedProperty(category = IntentConfig.LIST)
    protected boolean Vc() {
        return true;
    }

    final int b(int i, int i2, int i3, int i4, int i5) {
        int i6 = 0;
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter == null) {
            return this.bCf.left + this.bCf.right;
        }
        int i7 = this.bCf.left + this.bCf.right;
        int i8 = (this.bFj <= 0 || this.bFi == null) ? 0 : this.bFj;
        if (i3 == -1) {
            i3 = listAdapter.getCount() - 1;
        }
        AbsHListView.k kVar = this.bCa;
        boolean Vc = Vc();
        boolean[] zArr = this.bCP;
        while (i2 <= i3) {
            View a2 = a(i2, zArr);
            e(a2, i2, i);
            int i9 = i2 > 0 ? i7 + i8 : i7;
            if (Vc && kVar.hE(((AbsHListView.f) a2.getLayoutParams()).bDp)) {
                kVar.o(a2, -1);
            }
            i7 = a2.getMeasuredWidth() + i9;
            if (i7 >= i4) {
                return (i5 < 0 || i2 <= i5 || i6 <= 0 || i7 == i4) ? i4 : i6;
            }
            if (i5 >= 0 && i2 >= i5) {
                i6 = i7;
            }
            i2++;
        }
        return i7;
    }

    final int[] b(int i, int i2, int i3, int i4, int i5, int i6) {
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter == null) {
            return new int[]{this.bCf.left + this.bCf.right, this.bCf.top + this.bCf.bottom};
        }
        int i7 = this.bCf.left + this.bCf.right;
        int i8 = this.bCf.top + this.bCf.bottom;
        int i9 = (this.bFj <= 0 || this.bFi == null) ? 0 : this.bFj;
        if (i3 == -1) {
            i3 = listAdapter.getCount() - 1;
        }
        AbsHListView.k kVar = this.bCa;
        boolean Vc = Vc();
        boolean[] zArr = this.bCP;
        int i10 = 0;
        int i11 = 0;
        while (i2 <= i3) {
            View a2 = a(i2, zArr);
            e(a2, i2, i);
            if (Vc && kVar.hE(((AbsHListView.f) a2.getLayoutParams()).bDp)) {
                kVar.o(a2, -1);
            }
            i10 = Math.max(i10, a2.getMeasuredWidth() + i9);
            i2++;
            i11 = Math.max(i11, a2.getMeasuredHeight());
        }
        return new int[]{Math.min(i10 + i7, i4), Math.min(i11 + i8, i5)};
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView
    protected int hy(int i) {
        int childCount = getChildCount();
        if (childCount > 0) {
            if (this.bCv) {
                for (int i2 = childCount - 1; i2 >= 0; i2--) {
                    if (i >= getChildAt(i2).getLeft()) {
                        return i2 + this.bDU;
                    }
                }
            } else {
                for (int i3 = 0; i3 < childCount; i3++) {
                    if (i <= getChildAt(i3).getRight()) {
                        return i3 + this.bDU;
                    }
                }
            }
        }
        return -1;
    }

    private View ao(int i, int i2) {
        View al;
        View am;
        boolean z = i == this.bym;
        View a2 = a(i, i2, true, this.bCf.top, z);
        this.bDU = i;
        int i3 = this.bFj;
        if (!this.bCv) {
            am = am(i - 1, a2.getLeft() - i3);
            UZ();
            al = al(i + 1, i3 + a2.getRight());
            int childCount = getChildCount();
            if (childCount > 0) {
                hR(childCount);
            }
        } else {
            al = al(i + 1, a2.getRight() + i3);
            UZ();
            am = am(i - 1, a2.getLeft() - i3);
            int childCount2 = getChildCount();
            if (childCount2 > 0) {
                hS(childCount2);
            }
        }
        if (z) {
            return a2;
        }
        return am != null ? am : al;
    }

    private void hR(int i) {
        if ((this.bDU + i) - 1 == this.bEh - 1 && i > 0) {
            int right = ((getRight() - getLeft()) - this.bCf.right) - getChildAt(i - 1).getRight();
            View childAt = getChildAt(0);
            int left = childAt.getLeft();
            if (right > 0) {
                if (this.bDU > 0 || left < this.bCf.top) {
                    if (this.bDU == 0) {
                        right = Math.min(right, this.bCf.top - left);
                    }
                    hx(right);
                    if (this.bDU > 0) {
                        am(this.bDU - 1, childAt.getLeft() - this.bFj);
                        UZ();
                    }
                }
            }
        }
    }

    private void hS(int i) {
        if (this.bDU == 0 && i > 0) {
            int left = getChildAt(0).getLeft();
            int i2 = this.bCf.left;
            int right = (getRight() - getLeft()) - this.bCf.right;
            int i3 = left - i2;
            View childAt = getChildAt(i - 1);
            int right2 = childAt.getRight();
            int i4 = (this.bDU + i) - 1;
            if (i3 > 0) {
                if (i4 < this.bEh - 1 || right2 > right) {
                    if (i4 == this.bEh - 1) {
                        i3 = Math.min(i3, right2 - right);
                    }
                    hx(-i3);
                    if (i4 < this.bEh - 1) {
                        al(i4 + 1, childAt.getRight() + this.bFj);
                        UZ();
                    }
                } else if (i4 == this.bEh - 1) {
                    UZ();
                }
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, CONST, IPUT] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1916=4, 1917=4] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView
    public void layoutChildren() {
        View view;
        View view2;
        View view3;
        View a2;
        boolean z = this.bEp;
        if (z) {
            return;
        }
        this.bEp = true;
        try {
            super.layoutChildren();
            invalidate();
            if (this.mAdapter == null) {
                Uh();
                Ue();
                if (z) {
                    return;
                }
                return;
            }
            int i = this.bCf.left;
            int right = (getRight() - getLeft()) - this.bCf.right;
            int childCount = getChildCount();
            View view4 = null;
            View view5 = null;
            View view6 = null;
            switch (this.bBU) {
                case 1:
                case 3:
                case 4:
                case 5:
                    view = null;
                    break;
                case 2:
                    int i2 = this.bEe - this.bDU;
                    if (i2 < 0 || i2 >= childCount) {
                        view = null;
                        break;
                    } else {
                        view5 = getChildAt(i2);
                        view = null;
                        break;
                    }
                default:
                    int i3 = this.bym - this.bDU;
                    if (i3 >= 0 && i3 < childCount) {
                        view4 = getChildAt(i3);
                    }
                    View childAt = getChildAt(0);
                    r4 = this.bEe >= 0 ? this.bEe - this.bym : 0;
                    view5 = getChildAt(i3 + r4);
                    view = childAt;
                    break;
            }
            boolean z2 = this.aeW;
            if (z2) {
                handleDataChanged();
            }
            if (this.bEh == 0) {
                Uh();
                Ue();
                if (z) {
                    return;
                }
                this.bEp = false;
            } else if (this.bEh != this.mAdapter.getCount()) {
                throw new IllegalStateException("The content of the adapter has changed but ListView did not receive a notification. Make sure the content of your adapter is not modified from a background thread, but only from the UI thread. [in ListView(" + getId() + ", " + getClass() + ") with Adapter(" + this.mAdapter.getClass() + ")]");
            } else {
                setSelectedPositionInt(this.bEe);
                int i4 = this.bDU;
                AbsHListView.k kVar = this.bCa;
                View view7 = null;
                if (z2) {
                    for (int i5 = 0; i5 < childCount; i5++) {
                        kVar.o(getChildAt(i5), i4 + i5);
                    }
                } else {
                    kVar.ak(childCount, i4);
                }
                View focusedChild = getFocusedChild();
                if (focusedChild != null) {
                    if (!z2 || O(focusedChild)) {
                        view6 = findFocus();
                        if (view6 != null) {
                            view6.onStartTemporaryDetach();
                        }
                        view7 = focusedChild;
                    }
                    requestFocus();
                    view2 = view6;
                    view3 = view7;
                } else {
                    view2 = null;
                    view3 = null;
                }
                detachAllViewsFromParent();
                kVar.UE();
                switch (this.bBU) {
                    case 1:
                        this.bDU = 0;
                        View hQ = hQ(i);
                        UZ();
                        a2 = hQ;
                        break;
                    case 2:
                        if (view5 != null) {
                            a2 = t(view5.getLeft(), i, right);
                            break;
                        } else {
                            a2 = an(i, right);
                            break;
                        }
                    case 3:
                        View am = am(this.bEh - 1, right);
                        UZ();
                        a2 = am;
                        break;
                    case 4:
                        a2 = ao(Uu(), this.bDV);
                        break;
                    case 5:
                        a2 = ao(this.bDW, this.bDV);
                        break;
                    case 6:
                        a2 = a(view4, view5, r4, i, right);
                        break;
                    default:
                        if (childCount == 0) {
                            if (this.bCv) {
                                setSelectedPositionInt(k(this.bEh - 1, false));
                                a2 = am(this.bEh - 1, right);
                                break;
                            } else {
                                setSelectedPositionInt(k(0, true));
                                a2 = hQ(i);
                                break;
                            }
                        } else if (this.bym < 0 || this.bym >= this.bEh) {
                            if (this.bDU < this.bEh) {
                                int i6 = this.bDU;
                                if (view != null) {
                                    i = view.getLeft();
                                }
                                a2 = ao(i6, i);
                                break;
                            } else {
                                a2 = ao(0, i);
                                break;
                            }
                        } else {
                            int i7 = this.bym;
                            if (view4 != null) {
                                i = view4.getLeft();
                            }
                            a2 = ao(i7, i);
                            break;
                        }
                }
                kVar.UF();
                if (a2 != null) {
                    if (!this.bFs || !hasFocus() || a2.hasFocus()) {
                        c(-1, a2);
                    } else if ((a2 == view3 && view2 != null && view2.requestFocus()) || a2.requestFocus()) {
                        a2.setSelected(false);
                        this.bBZ.setEmpty();
                    } else {
                        View focusedChild2 = getFocusedChild();
                        if (focusedChild2 != null) {
                            focusedChild2.clearFocus();
                        }
                        c(-1, a2);
                    }
                    this.bCu = a2.getLeft();
                } else {
                    if (this.mTouchMode <= 0 || this.mTouchMode >= 3) {
                        this.bCu = 0;
                        this.bBZ.setEmpty();
                    } else {
                        View childAt2 = getChildAt(this.bCl - this.bDU);
                        if (childAt2 != null) {
                            c(this.bCl, childAt2);
                        }
                    }
                    if (hasFocus() && view2 != null) {
                        view2.requestFocus();
                    }
                }
                if (view2 != null && view2.getWindowToken() != null) {
                    view2.onFinishTemporaryDetach();
                }
                this.bBU = 0;
                this.aeW = false;
                if (this.bCN != null) {
                    post(this.bCN);
                    this.bCN = null;
                }
                this.bDZ = false;
                setNextSelectedPositionInt(this.bym);
                Ui();
                if (this.bEh > 0) {
                    UO();
                }
                Ue();
                if (z) {
                    return;
                }
                this.bEp = false;
            }
        } finally {
            if (!z) {
                this.bEp = false;
            }
        }
    }

    private boolean O(View view) {
        ArrayList<b> arrayList = this.HX;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (view == arrayList.get(i).view) {
                return true;
            }
        }
        ArrayList<b> arrayList2 = this.HY;
        int size2 = arrayList2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            if (view == arrayList2.get(i2).view) {
                return true;
            }
        }
        return false;
    }

    private View a(int i, int i2, boolean z, int i3, boolean z2) {
        View hF;
        if (!this.aeW && (hF = this.bCa.hF(i)) != null) {
            a(hF, i, i2, z, i3, z2, true);
            return hF;
        }
        View a2 = a(i, this.bCP);
        a(a2, i, i2, z, i3, z2, this.bCP[0]);
        return a2;
    }

    private void a(View view, int i, int i2, boolean z, int i3, boolean z2, boolean z3) {
        int makeMeasureSpec;
        boolean z4 = z2 && Uk();
        boolean isSelected = z4 ^ view.isSelected();
        int i4 = this.mTouchMode;
        boolean z5 = i4 > 0 && i4 < 3 && this.bCl == i;
        boolean isPressed = z5 ^ view.isPressed();
        boolean z6 = !z3 || isSelected || view.isLayoutRequested();
        AbsHListView.f fVar = (AbsHListView.f) view.getLayoutParams();
        AbsHListView.f fVar2 = fVar == null ? (AbsHListView.f) generateDefaultLayoutParams() : fVar;
        fVar2.bDp = this.mAdapter.getItemViewType(i);
        if ((z3 && !fVar2.bDr) || (fVar2.bDq && fVar2.bDp == -2)) {
            attachViewToParent(view, z ? -1 : 0, fVar2);
        } else {
            fVar2.bDr = false;
            if (fVar2.bDp == -2) {
                fVar2.bDq = true;
            }
            addViewInLayout(view, z ? -1 : 0, fVar2, true);
        }
        if (isSelected) {
            view.setSelected(z4);
        }
        if (isPressed) {
            view.setPressed(z5);
        }
        if (this.bBO != 0 && this.bBS != null) {
            if (view instanceof Checkable) {
                ((Checkable) view).setChecked(this.bBS.get(i, false).booleanValue());
            } else if (Build.VERSION.SDK_INT >= 11) {
                view.setActivated(this.bBS.get(i, false).booleanValue());
            }
        }
        if (z6) {
            int childMeasureSpec = ViewGroup.getChildMeasureSpec(this.bCg, this.bCf.top + this.bCf.bottom, fVar2.height);
            int i5 = fVar2.width;
            if (i5 > 0) {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i5, 1073741824);
            } else {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            }
            view.measure(makeMeasureSpec, childMeasureSpec);
        } else {
            cleanupLayoutState(view);
        }
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (!z) {
            i2 -= measuredWidth;
        }
        if (z6) {
            view.layout(i2, i3, measuredWidth + i2, measuredHeight + i3);
        } else {
            view.offsetLeftAndRight(i2 - view.getLeft());
            view.offsetTopAndBottom(i3 - view.getTop());
        }
        if (this.bCj && !view.isDrawingCacheEnabled()) {
            view.setDrawingCacheEnabled(true);
        }
        if (Build.VERSION.SDK_INT >= 11 && z3 && ((AbsHListView.f) view.getLayoutParams()).bDs != i) {
            view.jumpDrawablesToCurrentState();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.g, android.view.ViewGroup
    public boolean canAnimate() {
        return super.canAnimate() && this.bEh > 0;
    }

    @Override // com.baidu.tieba.horizonalList.widget.g
    public void setSelection(int i) {
        ap(i, 0);
    }

    public void ap(int i, int i2) {
        if (this.mAdapter != null) {
            if (!isInTouchMode()) {
                i = k(i, true);
                if (i >= 0) {
                    setNextSelectedPositionInt(i);
                }
            } else {
                this.bCz = i;
            }
            if (i >= 0) {
                this.bBU = 4;
                this.bDV = this.bCf.left + i2;
                if (this.bDZ) {
                    this.bDW = i;
                    this.bDX = this.mAdapter.getItemId(i);
                }
                if (this.bCt != null) {
                    this.bCt.stop();
                }
                requestLayout();
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView
    public void setSelectionInt(int i) {
        boolean z = true;
        setNextSelectedPositionInt(i);
        int i2 = this.bym;
        if (i2 < 0 || (i != i2 - 1 && i != i2 + 1)) {
            z = false;
        }
        if (this.bCt != null) {
            this.bCt.stop();
        }
        layoutChildren();
        if (z) {
            awakenScrollBars();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.g
    public int k(int i, boolean z) {
        int min;
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter == null || isInTouchMode()) {
            return -1;
        }
        int count = listAdapter.getCount();
        if (!this.bFr) {
            if (z) {
                min = Math.max(0, i);
                while (min < count && !listAdapter.isEnabled(min)) {
                    min++;
                }
            } else {
                min = Math.min(i, count - 1);
                while (min >= 0 && !listAdapter.isEnabled(min)) {
                    min--;
                }
            }
            if (min < 0 || min >= count) {
                return -1;
            }
            return min;
        } else if (i < 0 || i >= count) {
            return -1;
        } else {
            return i;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        if (!dispatchKeyEvent && getFocusedChild() != null && keyEvent.getAction() == 0) {
            return onKeyDown(keyEvent.getKeyCode(), keyEvent);
        }
        return dispatchKeyEvent;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return a(i, 1, keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
        return a(i, i2, keyEvent);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return a(i, 1, keyEvent);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(int i, int i2, KeyEvent keyEvent) {
        boolean z;
        if (this.mAdapter == null || !this.bDc) {
            return false;
        }
        if (this.aeW) {
            layoutChildren();
        }
        if (Build.VERSION.SDK_INT < 11) {
            return false;
        }
        int action = keyEvent.getAction();
        if (action != 1) {
            switch (i) {
                case 19:
                    if (keyEvent.hasNoModifiers()) {
                        z = hT(33);
                        break;
                    }
                    break;
                case 20:
                    if (keyEvent.hasNoModifiers()) {
                        z = hT(TransportMediator.KEYCODE_MEDIA_RECORD);
                        break;
                    }
                    break;
                case 21:
                    if (keyEvent.hasNoModifiers()) {
                        z = Uv();
                        if (!z) {
                            while (true) {
                                int i3 = i2;
                                i2 = i3 - 1;
                                if (i3 > 0 && arrowScroll(33)) {
                                    z = true;
                                }
                            }
                        }
                    } else if (keyEvent.hasModifiers(2)) {
                        if (!Uv() && !fullScroll(33)) {
                            z = false;
                            break;
                        } else {
                            z = true;
                            break;
                        }
                    }
                    break;
                case 22:
                    if (keyEvent.hasNoModifiers()) {
                        z = Uv();
                        if (!z) {
                            while (true) {
                                int i4 = i2;
                                i2 = i4 - 1;
                                if (i4 > 0 && arrowScroll(TransportMediator.KEYCODE_MEDIA_RECORD)) {
                                    z = true;
                                }
                            }
                        }
                    } else if (keyEvent.hasModifiers(2)) {
                        if (!Uv() && !fullScroll(TransportMediator.KEYCODE_MEDIA_RECORD)) {
                            z = false;
                            break;
                        } else {
                            z = true;
                            break;
                        }
                    }
                    break;
                case 23:
                case BDLocation.TypeOffLineLocation /* 66 */:
                    if (keyEvent.hasNoModifiers()) {
                        z = Uv();
                        if (!z && keyEvent.getRepeatCount() == 0 && getChildCount() > 0) {
                            Ul();
                            z = true;
                            break;
                        }
                    }
                    break;
                case 62:
                    if (!keyEvent.hasNoModifiers() ? !keyEvent.hasModifiers(1) || Uv() || !pageScroll(33) : Uv() || !pageScroll(TransportMediator.KEYCODE_MEDIA_RECORD)) {
                    }
                    z = true;
                    break;
                case a0.f39try /* 92 */:
                    if (keyEvent.hasNoModifiers()) {
                        if (!Uv() && !pageScroll(33)) {
                            z = false;
                            break;
                        } else {
                            z = true;
                            break;
                        }
                    } else if (keyEvent.hasModifiers(2)) {
                        if (!Uv() && !fullScroll(33)) {
                            z = false;
                            break;
                        } else {
                            z = true;
                            break;
                        }
                    }
                    break;
                case 93:
                    if (keyEvent.hasNoModifiers()) {
                        if (!Uv() && !pageScroll(TransportMediator.KEYCODE_MEDIA_RECORD)) {
                            z = false;
                            break;
                        } else {
                            z = true;
                            break;
                        }
                    } else if (keyEvent.hasModifiers(2)) {
                        if (!Uv() && !fullScroll(TransportMediator.KEYCODE_MEDIA_RECORD)) {
                            z = false;
                            break;
                        } else {
                            z = true;
                            break;
                        }
                    }
                    break;
                case SocialAPIErrorCodes.ERROR_SESSION_EXPIRED /* 122 */:
                    if (keyEvent.hasNoModifiers()) {
                        if (!Uv() && !fullScroll(33)) {
                            z = false;
                            break;
                        } else {
                            z = true;
                            break;
                        }
                    }
                    break;
                case SocialAPIErrorCodes.ERROR_INVALID_BDUSS /* 123 */:
                    if (keyEvent.hasNoModifiers()) {
                        if (!Uv() && !fullScroll(TransportMediator.KEYCODE_MEDIA_RECORD)) {
                            z = false;
                            break;
                        } else {
                            z = true;
                            break;
                        }
                    }
                    break;
            }
            if (z) {
                switch (action) {
                    case 0:
                        return super.onKeyDown(i, keyEvent);
                    case 1:
                        return super.onKeyUp(i, keyEvent);
                    case 2:
                        return super.onKeyMultiple(i, i2, keyEvent);
                    default:
                        return false;
                }
            }
            return true;
        }
        z = false;
        if (z) {
        }
    }

    boolean pageScroll(int i) {
        int i2;
        boolean z;
        int k;
        if (i == 33) {
            i2 = Math.max(0, (this.bym - getChildCount()) - 1);
            z = false;
        } else if (i != 130) {
            i2 = -1;
            z = false;
        } else {
            i2 = Math.min(this.bEh - 1, (this.bym + getChildCount()) - 1);
            z = true;
        }
        if (i2 < 0 || (k = k(i2, z)) < 0) {
            return false;
        }
        this.bBU = 4;
        this.bDV = getPaddingLeft() + getHorizontalFadingEdgeLength();
        if (z && k > this.bEh - getChildCount()) {
            this.bBU = 3;
        }
        if (!z && k < getChildCount()) {
            this.bBU = 1;
        }
        setSelectionInt(k);
        Ue();
        if (awakenScrollBars()) {
            return true;
        }
        invalidate();
        return true;
    }

    boolean fullScroll(int i) {
        boolean z = true;
        if (i == 33) {
            if (this.bym != 0) {
                int k = k(0, true);
                if (k >= 0) {
                    this.bBU = 1;
                    setSelectionInt(k);
                    Ue();
                }
            }
            z = false;
        } else {
            if (i == 130 && this.bym < this.bEh - 1) {
                int k2 = k(this.bEh - 1, true);
                if (k2 >= 0) {
                    this.bBU = 3;
                    setSelectionInt(k2);
                    Ue();
                }
            }
            z = false;
        }
        if (z && !awakenScrollBars()) {
            awakenScrollBars();
            invalidate();
        }
        return z;
    }

    private boolean hT(int i) {
        View selectedView;
        if (i != 33 && i != 130) {
            throw new IllegalArgumentException("direction must be one of {View.FOCUS_UP, View.FOCUS_DOWN}");
        }
        int childCount = getChildCount();
        if (this.bFs && childCount > 0 && this.bym != -1 && (selectedView = getSelectedView()) != null && selectedView.hasFocus() && (selectedView instanceof ViewGroup)) {
            View findFocus = selectedView.findFocus();
            View findNextFocus = FocusFinder.getInstance().findNextFocus((ViewGroup) selectedView, findFocus, i);
            if (findNextFocus != null) {
                findFocus.getFocusedRect(this.mTempRect);
                offsetDescendantRectToMyCoords(findFocus, this.mTempRect);
                offsetRectIntoDescendantCoords(findNextFocus, this.mTempRect);
                if (findNextFocus.requestFocus(i, this.mTempRect)) {
                    return true;
                }
            }
            View findNextFocus2 = FocusFinder.getInstance().findNextFocus((ViewGroup) getRootView(), findFocus, i);
            if (findNextFocus2 != null) {
                return a(findNextFocus2, this);
            }
        }
        return false;
    }

    boolean arrowScroll(int i) {
        try {
            this.mInLayout = true;
            boolean hU = hU(i);
            if (hU) {
                playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
            }
            return hU;
        } finally {
            this.mInLayout = false;
        }
    }

    private boolean hU(int i) {
        View view;
        int i2;
        View view2;
        View focusedChild;
        if (getChildCount() <= 0) {
            return false;
        }
        View selectedView = getSelectedView();
        int i3 = this.bym;
        int hV = hV(i);
        int aq = aq(i, hV);
        a hW = this.bFs ? hW(i) : null;
        if (hW != null) {
            hV = hW.Tt();
            aq = hW.Vd();
        }
        boolean z = hW != null;
        if (hV != -1) {
            a(selectedView, i, hV, hW != null);
            setSelectedPositionInt(hV);
            setNextSelectedPositionInt(hV);
            view = getSelectedView();
            if (this.bFs && hW == null && (focusedChild = getFocusedChild()) != null) {
                focusedChild.clearFocus();
            }
            UO();
            z = true;
            i2 = hV;
        } else {
            view = selectedView;
            i2 = i3;
        }
        if (aq > 0) {
            hX(i == 33 ? aq : -aq);
            z = true;
        }
        if (this.bFs && hW == null && view != null && view.hasFocus()) {
            View findFocus = view.findFocus();
            if (!a(findFocus, this) || S(findFocus) > 0) {
                findFocus.clearFocus();
            }
        }
        if (hV != -1 || view == null || a(view, this)) {
            view2 = view;
        } else {
            Ut();
            this.bCz = -1;
            view2 = null;
        }
        if (z) {
            if (view2 != null) {
                c(i2, view2);
                this.bCu = view2.getLeft();
            }
            if (!awakenScrollBars()) {
                invalidate();
            }
            Ue();
            return true;
        }
        return false;
    }

    private void a(View view, int i, int i2, boolean z) {
        View view2;
        int i3;
        boolean z2;
        boolean z3 = true;
        if (i2 == -1) {
            throw new IllegalArgumentException("newSelectedPosition needs to be valid");
        }
        int i4 = this.bym - this.bDU;
        int i5 = i2 - this.bDU;
        if (i == 33) {
            view2 = getChildAt(i5);
            i3 = i5;
            i5 = i4;
            z2 = true;
        } else {
            view2 = view;
            view = getChildAt(i5);
            i3 = i4;
            z2 = false;
        }
        int childCount = getChildCount();
        if (view2 != null) {
            view2.setSelected(!z && z2);
            f(view2, i3, childCount);
        }
        if (view != null) {
            if (z || z2) {
                z3 = false;
            }
            view.setSelected(z3);
            f(view, i5, childCount);
        }
    }

    private void f(View view, int i, int i2) {
        int width = view.getWidth();
        P(view);
        if (view.getMeasuredWidth() != width) {
            Q(view);
            int measuredWidth = view.getMeasuredWidth() - width;
            for (int i3 = i + 1; i3 < i2; i3++) {
                getChildAt(i3).offsetLeftAndRight(measuredWidth);
            }
        }
    }

    private void P(View view) {
        int makeMeasureSpec;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-2, -1);
        }
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(this.bCg, this.bCf.top + this.bCf.bottom, layoutParams.height);
        int i = layoutParams.width;
        if (i > 0) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(makeMeasureSpec, childMeasureSpec);
    }

    private void Q(View view) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i = this.bCf.top;
        int left = view.getLeft();
        view.layout(left, i, measuredWidth + left, measuredHeight + i);
    }

    private int getArrowScrollPreviewLength() {
        return Math.max(2, getHorizontalFadingEdgeLength());
    }

    private int aq(int i, int i2) {
        int width = getWidth() - this.bCf.right;
        int i3 = this.bCf.left;
        int childCount = getChildCount();
        if (i == 130) {
            int i4 = childCount - 1;
            if (i2 != -1) {
                i4 = i2 - this.bDU;
            }
            int i5 = this.bDU + i4;
            View childAt = getChildAt(i4);
            int arrowScrollPreviewLength = i5 < this.bEh + (-1) ? width - getArrowScrollPreviewLength() : width;
            if (childAt.getRight() <= arrowScrollPreviewLength) {
                return 0;
            }
            if (i2 == -1 || arrowScrollPreviewLength - childAt.getLeft() < getMaxScrollAmount()) {
                int right = childAt.getRight() - arrowScrollPreviewLength;
                if (this.bDU + childCount == this.bEh) {
                    right = Math.min(right, getChildAt(childCount - 1).getRight() - width);
                }
                return Math.min(right, getMaxScrollAmount());
            }
            return 0;
        }
        int i6 = i2 != -1 ? i2 - this.bDU : 0;
        int i7 = this.bDU + i6;
        View childAt2 = getChildAt(i6);
        int arrowScrollPreviewLength2 = i7 > 0 ? getArrowScrollPreviewLength() + i3 : i3;
        if (childAt2.getLeft() < arrowScrollPreviewLength2) {
            if (i2 == -1 || childAt2.getRight() - arrowScrollPreviewLength2 < getMaxScrollAmount()) {
                int left = arrowScrollPreviewLength2 - childAt2.getLeft();
                if (this.bDU == 0) {
                    left = Math.min(left, i3 - getChildAt(0).getLeft());
                }
                return Math.min(left, getMaxScrollAmount());
            }
            return 0;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private int bFw;
        private int bym;

        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }

        void ar(int i, int i2) {
            this.bym = i;
            this.bFw = i2;
        }

        public int Tt() {
            return this.bym;
        }

        public int Vd() {
            return this.bFw;
        }
    }

    private int hV(int i) {
        int i2 = this.bDU;
        if (i == 130) {
            int i3 = this.bym != -1 ? this.bym + 1 : i2;
            if (i3 >= this.mAdapter.getCount()) {
                return -1;
            }
            if (i3 < i2) {
                i3 = i2;
            }
            int lastVisiblePosition = getLastVisiblePosition();
            ListAdapter adapter = getAdapter();
            while (i3 <= lastVisiblePosition) {
                if (!adapter.isEnabled(i3) || getChildAt(i3 - i2).getVisibility() != 0) {
                    i3++;
                } else {
                    return i3;
                }
            }
        } else {
            int childCount = (getChildCount() + i2) - 1;
            int childCount2 = this.bym != -1 ? this.bym - 1 : (getChildCount() + i2) - 1;
            if (childCount2 < 0 || childCount2 >= this.mAdapter.getCount()) {
                return -1;
            }
            if (childCount2 <= childCount) {
                childCount = childCount2;
            }
            ListAdapter adapter2 = getAdapter();
            while (childCount >= i2) {
                if (!adapter2.isEnabled(childCount) || getChildAt(childCount - i2).getVisibility() != 0) {
                    childCount--;
                } else {
                    return childCount;
                }
            }
        }
        return -1;
    }

    private a hW(int i) {
        View findNextFocusFromRect;
        int hV;
        View selectedView = getSelectedView();
        if (selectedView != null && selectedView.hasFocus()) {
            findNextFocusFromRect = FocusFinder.getInstance().findNextFocus(this, selectedView.findFocus(), i);
        } else {
            if (i == 130) {
                int arrowScrollPreviewLength = (this.bDU > 0 ? getArrowScrollPreviewLength() : 0) + this.bCf.left;
                if (selectedView != null && selectedView.getLeft() > arrowScrollPreviewLength) {
                    arrowScrollPreviewLength = selectedView.getLeft();
                }
                this.mTempRect.set(arrowScrollPreviewLength, 0, arrowScrollPreviewLength, 0);
            } else {
                int width = (getWidth() - this.bCf.right) - ((this.bDU + getChildCount()) + (-1) < this.bEh ? getArrowScrollPreviewLength() : 0);
                if (selectedView != null && selectedView.getRight() < width) {
                    width = selectedView.getRight();
                }
                this.mTempRect.set(width, 0, width, 0);
            }
            findNextFocusFromRect = FocusFinder.getInstance().findNextFocusFromRect(this, this.mTempRect, i);
        }
        if (findNextFocusFromRect != null) {
            int R = R(findNextFocusFromRect);
            if (this.bym != -1 && R != this.bym && (hV = hV(i)) != -1 && ((i == 130 && hV < R) || (i == 33 && hV > R))) {
                return null;
            }
            int b2 = b(i, findNextFocusFromRect, R);
            int maxScrollAmount = getMaxScrollAmount();
            if (b2 < maxScrollAmount) {
                findNextFocusFromRect.requestFocus(i);
                this.bFu.ar(R, b2);
                return this.bFu;
            } else if (S(findNextFocusFromRect) < maxScrollAmount) {
                findNextFocusFromRect.requestFocus(i);
                this.bFu.ar(R, maxScrollAmount);
                return this.bFu;
            }
        }
        return null;
    }

    private int R(View view) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (a(view, getChildAt(i))) {
                return i + this.bDU;
            }
        }
        throw new IllegalArgumentException("newFocus is not a child of any of the children of the list!");
    }

    private boolean a(View view, View view2) {
        if (view == view2) {
            return true;
        }
        ViewParent parent = view.getParent();
        return (parent instanceof ViewGroup) && a((View) parent, view2);
    }

    private int b(int i, View view, int i2) {
        view.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(view, this.mTempRect);
        if (i == 33) {
            if (this.mTempRect.left >= this.bCf.left) {
                return 0;
            }
            int i3 = this.bCf.left - this.mTempRect.left;
            if (i2 > 0) {
                return i3 + getArrowScrollPreviewLength();
            }
            return i3;
        }
        int width = getWidth() - this.bCf.right;
        if (this.mTempRect.bottom <= width) {
            return 0;
        }
        int i4 = this.mTempRect.right - width;
        if (i2 < this.bEh - 1) {
            return i4 + getArrowScrollPreviewLength();
        }
        return i4;
    }

    private int S(View view) {
        view.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(view, this.mTempRect);
        int right = (getRight() - getLeft()) - this.bCf.right;
        if (this.mTempRect.right < this.bCf.left) {
            return this.bCf.left - this.mTempRect.right;
        }
        if (this.mTempRect.left <= right) {
            return 0;
        }
        return this.mTempRect.left - right;
    }

    private void hX(int i) {
        int i2;
        hx(i);
        int width = getWidth() - this.bCf.right;
        int i3 = this.bCf.left;
        AbsHListView.k kVar = this.bCa;
        if (i < 0) {
            int childCount = getChildCount();
            View childAt = getChildAt(childCount - 1);
            while (childAt.getRight() < width && (this.bDU + childCount) - 1 < this.bEh - 1) {
                childAt = r(childAt, i2);
                childCount++;
            }
            if (childAt.getBottom() < width) {
                hx(width - childAt.getRight());
            }
            View childAt2 = getChildAt(0);
            while (true) {
                View view = childAt2;
                if (view.getRight() < i3) {
                    if (kVar.hE(((AbsHListView.f) view.getLayoutParams()).bDp)) {
                        detachViewFromParent(view);
                        kVar.o(view, this.bDU);
                    } else {
                        removeViewInLayout(view);
                    }
                    childAt2 = getChildAt(0);
                    this.bDU++;
                } else {
                    return;
                }
            }
        } else {
            View childAt3 = getChildAt(0);
            while (childAt3.getLeft() > i3 && this.bDU > 0) {
                childAt3 = q(childAt3, this.bDU);
                this.bDU--;
            }
            if (childAt3.getLeft() > i3) {
                hx(i3 - childAt3.getLeft());
            }
            int childCount2 = getChildCount() - 1;
            View childAt4 = getChildAt(childCount2);
            while (true) {
                int i4 = childCount2;
                View view2 = childAt4;
                if (view2.getLeft() > width) {
                    if (kVar.hE(((AbsHListView.f) view2.getLayoutParams()).bDp)) {
                        detachViewFromParent(view2);
                        kVar.o(view2, this.bDU + i4);
                    } else {
                        removeViewInLayout(view2);
                    }
                    childCount2 = i4 - 1;
                    childAt4 = getChildAt(childCount2);
                } else {
                    return;
                }
            }
        }
    }

    private View q(View view, int i) {
        int i2 = i - 1;
        View a2 = a(i2, this.bCP);
        a(a2, i2, view.getLeft() - this.bFj, false, this.bCf.top, false, this.bCP[0]);
        return a2;
    }

    private View r(View view, int i) {
        int i2 = i + 1;
        View a2 = a(i2, this.bCP);
        a(a2, i2, this.bFj + view.getRight(), true, this.bCf.top, false, this.bCP[0]);
        return a2;
    }

    public void setItemsCanFocus(boolean z) {
        this.bFs = z;
        if (!z) {
            setDescendantFocusability(393216);
        }
    }

    public boolean getItemsCanFocus() {
        return this.bFs;
    }

    @Override // android.view.View
    public boolean isOpaque() {
        boolean z = (this.bCk && this.bFn && this.bFo) || super.isOpaque();
        if (z) {
            int paddingLeft = this.bCf != null ? this.bCf.left : getPaddingLeft();
            View childAt = getChildAt(0);
            if (childAt == null || childAt.getLeft() > paddingLeft) {
                return false;
            }
            int width = getWidth() - (this.bCf != null ? this.bCf.right : getPaddingRight());
            View childAt2 = getChildAt(getChildCount() - 1);
            if (childAt2 == null || childAt2.getRight() < width) {
                return false;
            }
        }
        return z;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView
    public void setCacheColorHint(int i) {
        boolean z = (i >>> 24) == 255;
        this.bFn = z;
        if (z) {
            if (this.bFt == null) {
                this.bFt = new Paint();
            }
            this.bFt.setColor(i);
        }
        super.setCacheColorHint(i);
    }

    void a(Canvas canvas, Drawable drawable, Rect rect) {
        int minimumWidth = drawable.getMinimumWidth();
        canvas.save();
        canvas.clipRect(rect);
        if (rect.right - rect.left < minimumWidth) {
            rect.left = rect.right - minimumWidth;
        }
        drawable.setBounds(rect);
        drawable.draw(canvas);
        canvas.restore();
    }

    void b(Canvas canvas, Drawable drawable, Rect rect) {
        int minimumWidth = drawable.getMinimumWidth();
        canvas.save();
        canvas.clipRect(rect);
        if (rect.right - rect.left < minimumWidth) {
            rect.right = minimumWidth + rect.left;
        }
        drawable.setBounds(rect);
        drawable.draw(canvas);
        canvas.restore();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        int left;
        if (this.bCj) {
            this.bCk = true;
        }
        int i = this.bFj;
        Drawable drawable = this.bFl;
        Drawable drawable2 = this.bFm;
        boolean z = drawable != null;
        boolean z2 = drawable2 != null;
        boolean z3 = i > 0 && this.bFi != null;
        if (z3 || z || z2) {
            Rect rect = this.mTempRect;
            rect.top = getPaddingTop();
            rect.bottom = (getBottom() - getTop()) - getPaddingBottom();
            int childCount = getChildCount();
            int size = this.HX.size();
            int i2 = this.bEh;
            int size2 = (i2 - this.HY.size()) - 1;
            boolean z4 = this.bFp;
            boolean z5 = this.bFq;
            int i3 = this.bDU;
            boolean z6 = this.bFr;
            ListAdapter listAdapter = this.mAdapter;
            boolean z7 = isOpaque() && !super.isOpaque();
            if (z7 && this.bFt == null && this.bFn) {
                this.bFt = new Paint();
                this.bFt.setColor(getCacheColorHint());
            }
            Paint paint = this.bFt;
            int scrollX = getScrollX() + ((getRight() - getLeft()) - 0);
            if (!this.bCv) {
                int scrollX2 = getScrollX();
                if (childCount > 0 && scrollX2 < 0) {
                    if (z) {
                        rect.right = 0;
                        rect.left = scrollX2;
                        a(canvas, drawable, rect);
                    } else if (z3) {
                        rect.right = 0;
                        rect.left = -i;
                        a(canvas, rect, -1);
                    }
                }
                int i4 = 0;
                for (int i5 = 0; i5 < childCount; i5++) {
                    if ((z4 || i3 + i5 >= size) && (z5 || i3 + i5 < size2)) {
                        i4 = getChildAt(i5).getRight();
                        if (z3 && i4 < scrollX && (!z2 || i5 != childCount - 1)) {
                            if (z6 || (listAdapter.isEnabled(i3 + i5) && (i5 == childCount - 1 || listAdapter.isEnabled(i3 + i5 + 1)))) {
                                rect.left = i4;
                                rect.right = i4 + i;
                                a(canvas, rect, i5);
                            } else if (z7) {
                                rect.left = i4;
                                rect.right = i4 + i;
                                canvas.drawRect(rect, paint);
                            }
                        }
                    }
                }
                int right = getRight() + getScrollX();
                if (z2 && i3 + childCount == i2 && right > i4) {
                    rect.left = i4;
                    rect.right = right;
                    b(canvas, drawable2, rect);
                }
            } else {
                int scrollX3 = getScrollX();
                if (childCount > 0 && z) {
                    rect.left = scrollX3;
                    rect.right = getChildAt(0).getLeft();
                    a(canvas, drawable, rect);
                }
                for (int i6 = z ? 1 : 0; i6 < childCount; i6++) {
                    if ((z4 || i3 + i6 >= size) && ((z5 || i3 + i6 < size2) && (left = getChildAt(i6).getLeft()) > 0)) {
                        if (z6 || (listAdapter.isEnabled(i3 + i6) && (i6 == childCount - 1 || listAdapter.isEnabled(i3 + i6 + 1)))) {
                            rect.left = left - i;
                            rect.right = left;
                            a(canvas, rect, i6 - 1);
                        } else if (z7) {
                            rect.left = left - i;
                            rect.right = left;
                            canvas.drawRect(rect, paint);
                        }
                    }
                }
                if (childCount > 0 && scrollX3 > 0) {
                    if (z2) {
                        int right2 = getRight();
                        rect.left = right2;
                        rect.right = right2 + scrollX3;
                        b(canvas, drawable2, rect);
                    } else if (z3) {
                        rect.left = scrollX;
                        rect.right = scrollX + i;
                        a(canvas, rect, -1);
                    }
                }
            }
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        boolean drawChild = super.drawChild(canvas, view, j);
        if (this.bCk) {
            this.bCk = false;
        }
        return drawChild;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Canvas canvas, Rect rect, int i) {
        Drawable drawable = this.bFi;
        drawable.setBounds(rect);
        drawable.draw(canvas);
    }

    public Drawable getDivider() {
        return this.bFi;
    }

    public void setDivider(Drawable drawable) {
        boolean z = false;
        if (drawable != null) {
            this.bFj = drawable.getIntrinsicWidth();
        } else {
            this.bFj = 0;
        }
        this.bFi = drawable;
        this.bFo = (drawable == null || drawable.getOpacity() == -1) ? true : true;
        requestLayout();
        invalidate();
    }

    public int getDividerWidth() {
        return this.bFj;
    }

    public void setDividerWidth(int i) {
        this.bFj = i;
        requestLayout();
        invalidate();
    }

    public void setHeaderDividersEnabled(boolean z) {
        this.bFp = z;
        invalidate();
    }

    public void setFooterDividersEnabled(boolean z) {
        this.bFq = z;
        invalidate();
    }

    public void setOverscrollHeader(Drawable drawable) {
        this.bFl = drawable;
        if (getScrollX() < 0) {
            invalidate();
        }
    }

    public Drawable getOverscrollHeader() {
        return this.bFl;
    }

    public void setOverscrollFooter(Drawable drawable) {
        this.bFm = drawable;
        invalidate();
    }

    public Drawable getOverscrollFooter() {
        return this.bFm;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public void onFocusChanged(boolean z, int i, Rect rect) {
        int i2;
        int i3;
        int i4 = 0;
        super.onFocusChanged(z, i, rect);
        ListAdapter listAdapter = this.mAdapter;
        int i5 = -1;
        if (listAdapter != null && z && rect != null) {
            rect.offset(getScrollX(), getScrollY());
            if (listAdapter.getCount() < getChildCount() + this.bDU) {
                this.bBU = 0;
                layoutChildren();
            }
            Rect rect2 = this.mTempRect;
            int i6 = Integer.MAX_VALUE;
            int childCount = getChildCount();
            int i7 = this.bDU;
            int i8 = 0;
            while (i8 < childCount) {
                if (listAdapter.isEnabled(i7 + i8)) {
                    View childAt = getChildAt(i8);
                    childAt.getDrawingRect(rect2);
                    offsetDescendantRectToMyCoords(childAt, rect2);
                    int a2 = a(rect, rect2, i);
                    if (a2 < i6) {
                        i3 = i8;
                        i6 = a2;
                        i2 = childAt.getLeft();
                    } else {
                        i2 = i4;
                        i3 = i5;
                    }
                } else {
                    i2 = i4;
                    i3 = i5;
                }
                i8++;
                i5 = i3;
                i4 = i2;
            }
        }
        if (i5 >= 0) {
            ap(this.bDU + i5, i4);
        } else {
            requestLayout();
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                addHeaderView(getChildAt(i));
            }
            removeAllViews();
        }
    }

    @Deprecated
    public long[] getCheckItemIds() {
        int i;
        if (this.mAdapter != null && this.mAdapter.hasStableIds()) {
            return getCheckedItemIds();
        }
        if (this.bBO != 0 && this.bBS != null && this.mAdapter != null) {
            SparseArrayCompat<Boolean> sparseArrayCompat = this.bBS;
            int size = sparseArrayCompat.size();
            long[] jArr = new long[size];
            ListAdapter listAdapter = this.mAdapter;
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                if (sparseArrayCompat.valueAt(i2).booleanValue()) {
                    i = i3 + 1;
                    jArr[i3] = listAdapter.getItemId(sparseArrayCompat.keyAt(i2));
                } else {
                    i = i3;
                }
                i2++;
                i3 = i;
            }
            if (i3 == size) {
                return jArr;
            }
            long[] jArr2 = new long[i3];
            System.arraycopy(jArr, 0, jArr2, 0, i3);
            return jArr2;
        }
        return new long[0];
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.g, android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(k.class.getName());
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.g, android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(k.class.getName());
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() > 1) {
            requestDisallowInterceptTouchEvent(true);
            return false;
        }
        try {
            return super.dispatchTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        if (getParent() != null && this.mGestureDetector.onTouchEvent(motionEvent)) {
            requestDisallowInterceptTouchEvent(true);
            return true;
        } else if (motionEvent.getPointerCount() > 1) {
            requestDisallowInterceptTouchEvent(true);
            return true;
        } else {
            return onInterceptTouchEvent;
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() > 1) {
            requestDisallowInterceptTouchEvent(true);
            return true;
        }
        switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
            case 0:
            case 5:
                requestDisallowInterceptTouchEvent(true);
                break;
            case 1:
            case 3:
                requestDisallowInterceptTouchEvent(false);
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    /* loaded from: classes.dex */
    private class d extends GestureDetector.SimpleOnGestureListener {
        private d() {
        }

        /* synthetic */ d(k kVar, d dVar) {
            this();
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return Math.abs(f) > Math.abs(f2);
        }
    }
}
