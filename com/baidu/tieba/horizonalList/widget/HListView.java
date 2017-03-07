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
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
import com.baidu.tieba.w;
import java.util.ArrayList;
@RemoteViews.RemoteView
/* loaded from: classes.dex */
public class HListView extends AbsHListView {
    private ArrayList<b> Ix;
    private ArrayList<b> Iy;
    Drawable cFA;
    int cFB;
    int cFC;
    Drawable cFD;
    Drawable cFE;
    private boolean cFF;
    private boolean cFG;
    private boolean cFH;
    private boolean cFI;
    private boolean cFJ;
    private boolean cFK;
    private Paint cFL;
    private final a cFM;
    private c cFN;
    private GestureDetector mGestureDetector;
    private final Rect mTempRect;

    /* loaded from: classes.dex */
    public static class b {
        public Object data;
        public boolean isSelectable;
        public View view;
    }

    public HListView(Context context) {
        this(context, null);
    }

    public HListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, w.c.hlv_listViewStyle);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Drawable drawable;
        Drawable drawable2;
        Drawable drawable3;
        CharSequence[] charSequenceArr;
        int i2;
        boolean z;
        int i3 = -1;
        boolean z2 = true;
        this.Ix = new ArrayList<>();
        this.Iy = new ArrayList<>();
        this.cFJ = true;
        this.cFK = false;
        this.mTempRect = new Rect();
        this.cFM = new a(null);
        this.mGestureDetector = new GestureDetector(new d(this, null));
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, w.n.HListView, i, 0);
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
        this.cFH = z;
        this.cFI = z2;
        this.cFC = i3;
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
    private void alg() {
        int right;
        int i = 0;
        int childCount = getChildCount();
        if (childCount > 0) {
            if (!this.cCN) {
                right = getChildAt(0).getLeft() - this.cCw.left;
                if (this.cEm != 0) {
                    right -= this.cFB;
                }
            } else {
                right = getChildAt(childCount - 1).getRight() - (getWidth() - this.cCw.right);
                if (childCount + this.cEm < this.cEz) {
                    right += this.cFB;
                }
            }
            if (i != 0) {
                ka(-i);
            }
        }
    }

    public void addHeaderView(View view, Object obj, boolean z) {
        if (this.mAdapter != null && !(this.mAdapter instanceof m)) {
            throw new IllegalStateException("Cannot add header view to list -- setAdapter has already been called.");
        }
        b bVar = new b();
        bVar.view = view;
        bVar.data = obj;
        bVar.isSelectable = z;
        this.Ix.add(bVar);
        if (this.mAdapter != null && this.cCm != null) {
            this.cCm.onChanged();
        }
    }

    public void addHeaderView(View view) {
        addHeaderView(view, null, true);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView
    public int getHeaderViewsCount() {
        return this.Ix.size();
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView
    public int getFooterViewsCount() {
        return this.Iy.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.horizonalList.widget.g
    public ListAdapter getAdapter() {
        return this.mAdapter;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView
    public void setAdapter(ListAdapter listAdapter) {
        int q;
        if (this.mAdapter != null && this.cCm != null) {
            this.mAdapter.unregisterDataSetObserver(this.cCm);
        }
        akn();
        this.cCr.clear();
        if (this.Ix.size() > 0 || this.Iy.size() > 0) {
            this.mAdapter = new m(this.Ix, this.Iy, listAdapter);
        } else {
            this.mAdapter = listAdapter;
        }
        this.cEC = -1;
        this.cED = Long.MIN_VALUE;
        super.setAdapter(listAdapter);
        if (this.mAdapter != null) {
            this.cFJ = this.mAdapter.areAllItemsEnabled();
            this.cEA = this.cEz;
            this.cEz = this.mAdapter.getCount();
            akP();
            this.cCm = new AbsHListView.a();
            this.mAdapter.registerDataSetObserver(this.cCm);
            this.cCr.kg(this.mAdapter.getViewTypeCount());
            if (this.cCN) {
                q = q(this.cEz - 1, false);
            } else {
                q = q(0, true);
            }
            setSelectedPositionInt(q);
            setNextSelectedPositionInt(q);
            if (this.cEz == 0) {
                akU();
            }
        } else {
            this.cFJ = true;
            akP();
            akU();
        }
        requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView
    public void akn() {
        R(this.Ix);
        R(this.Iy);
        super.akn();
        this.cCl = 0;
    }

    private void R(ArrayList<b> arrayList) {
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                AbsHListView.f fVar = (AbsHListView.f) arrayList.get(i).view.getLayoutParams();
                if (fVar != null) {
                    fVar.cDI = false;
                }
            }
        }
    }

    private boolean alh() {
        return this.cEm > 0 || getChildAt(0).getLeft() > getScrollX() + this.cCw.left;
    }

    private boolean ali() {
        int childCount = getChildCount();
        return (childCount + this.cEm) + (-1) < this.cEz + (-1) || getChildAt(childCount + (-1)).getRight() < (getScrollX() + getWidth()) - this.cCw.right;
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
        if (alh() && (this.ckM > 0 || i4 > horizontalFadingEdgeLength)) {
            scrollX += horizontalFadingEdgeLength;
        }
        int right = getChildAt(getChildCount() - 1).getRight();
        if (ali() && (this.ckM < this.cEz - 1 || rect.right < right - horizontalFadingEdgeLength)) {
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
            kA(-i);
            c(-1, view);
            this.cCM = view.getTop();
            invalidate();
        }
        return z2;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView
    protected void fb(boolean z) {
        int childCount = getChildCount();
        if (z) {
            aE(childCount + this.cEm, childCount > 0 ? getChildAt(childCount - 1).getRight() + this.cFB : 0);
            ku(getChildCount());
            return;
        }
        aF(this.cEm - 1, childCount > 0 ? getChildAt(0).getLeft() - this.cFB : getWidth() - 0);
        kv(getChildCount());
    }

    private View aE(int i, int i2) {
        View view = null;
        int right = getRight() - getLeft();
        int i3 = i2;
        int i4 = i;
        while (i3 < right && i4 < this.cEz) {
            boolean z = i4 == this.ckM;
            View a2 = a(i4, i3, true, this.cCw.top, z);
            i3 = a2.getRight() + this.cFB;
            if (!z) {
                a2 = view;
            }
            i4++;
            view = a2;
        }
        aB(this.cEm, (this.cEm + getChildCount()) - 1);
        return view;
    }

    private View aF(int i, int i2) {
        View view = null;
        int i3 = i2;
        int i4 = i;
        while (i3 > 0 && i4 >= 0) {
            boolean z = i4 == this.ckM;
            View a2 = a(i4, i3, false, this.cCw.top, z);
            i3 = a2.getLeft() - this.cFB;
            if (!z) {
                a2 = view;
            }
            i4--;
            view = a2;
        }
        this.cEm = i4 + 1;
        aB(this.cEm, (this.cEm + getChildCount()) - 1);
        return view;
    }

    private View kt(int i) {
        this.cEm = Math.min(this.cEm, this.ckM);
        this.cEm = Math.min(this.cEm, this.cEz - 1);
        if (this.cEm < 0) {
            this.cEm = 0;
        }
        return aE(this.cEm, i);
    }

    private View aG(int i, int i2) {
        int i3 = i2 - i;
        int akA = akA();
        View a2 = a(akA, i, true, this.cCw.top, true);
        this.cEm = akA;
        int measuredWidth = a2.getMeasuredWidth();
        if (measuredWidth <= i3) {
            a2.offsetLeftAndRight((i3 - measuredWidth) / 2);
        }
        s(a2, akA);
        if (!this.cCN) {
            ku(getChildCount());
        } else {
            kv(getChildCount());
        }
        return a2;
    }

    private void s(View view, int i) {
        int i2 = this.cFB;
        if (!this.cCN) {
            aF(i - 1, view.getLeft() - i2);
            alg();
            aE(i + 1, i2 + view.getRight());
            return;
        }
        aE(i + 1, view.getRight() + i2);
        alg();
        aF(i - 1, view.getLeft() - i2);
    }

    private View x(int i, int i2, int i3) {
        int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
        int i4 = this.ckM;
        int z = z(i2, horizontalFadingEdgeLength, i4);
        int y = y(i3, horizontalFadingEdgeLength, i4);
        View a2 = a(i4, i, true, this.cCw.top, true);
        if (a2.getRight() > y) {
            a2.offsetLeftAndRight(-Math.min(a2.getLeft() - z, a2.getRight() - y));
        } else if (a2.getLeft() < z) {
            a2.offsetLeftAndRight(Math.min(z - a2.getLeft(), y - a2.getRight()));
        }
        s(a2, i4);
        if (!this.cCN) {
            ku(getChildCount());
        } else {
            kv(getChildCount());
        }
        return a2;
    }

    private int y(int i, int i2, int i3) {
        if (i3 != this.cEz - 1) {
            return i - i2;
        }
        return i;
    }

    private int z(int i, int i2, int i3) {
        if (i3 > 0) {
            return i + i2;
        }
        return i;
    }

    private View a(View view, View view2, int i, int i2, int i3) {
        View a2;
        int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
        int i4 = this.ckM;
        int z = z(i2, horizontalFadingEdgeLength, i4);
        int y = y(i2, horizontalFadingEdgeLength, i4);
        if (i > 0) {
            View a3 = a(i4 - 1, view.getLeft(), true, this.cCw.top, false);
            int i5 = this.cFB;
            a2 = a(i4, a3.getRight() + i5, true, this.cCw.top, true);
            if (a2.getRight() > y) {
                int min = Math.min(Math.min(a2.getLeft() - z, a2.getRight() - y), (i3 - i2) / 2);
                a3.offsetLeftAndRight(-min);
                a2.offsetLeftAndRight(-min);
            }
            if (!this.cCN) {
                aF(this.ckM - 2, a2.getLeft() - i5);
                alg();
                aE(this.ckM + 1, a2.getRight() + i5);
            } else {
                aE(this.ckM + 1, a2.getRight() + i5);
                alg();
                aF(this.ckM - 2, a2.getLeft() - i5);
            }
        } else if (i < 0) {
            if (view2 != null) {
                a2 = a(i4, view2.getLeft(), true, this.cCw.top, true);
            } else {
                a2 = a(i4, view.getLeft(), false, this.cCw.top, true);
            }
            if (a2.getLeft() < z) {
                a2.offsetLeftAndRight(Math.min(Math.min(z - a2.getLeft(), y - a2.getRight()), (i3 - i2) / 2));
            }
            s(a2, i4);
        } else {
            int left = view.getLeft();
            a2 = a(i4, left, true, this.cCw.top, true);
            if (left < i2 && a2.getRight() < i2 + 20) {
                a2.offsetLeftAndRight(i2 - a2.getLeft());
            }
            s(a2, i4);
        }
        return a2;
    }

    /* loaded from: classes.dex */
    private class c implements Runnable {
        private int ath;
        private int cFP;

        private c() {
        }

        /* synthetic */ c(HListView hListView, c cVar) {
            this();
        }

        public c aL(int i, int i2) {
            this.ath = i;
            this.cFP = i2;
            return this;
        }

        @Override // java.lang.Runnable
        public void run() {
            HListView.this.aI(this.ath, this.cFP);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        View focusedChild;
        if (getChildCount() > 0 && (focusedChild = getFocusedChild()) != null) {
            int indexOfChild = this.cEm + indexOfChild(focusedChild);
            int left = focusedChild.getLeft() - Math.max(0, focusedChild.getRight() - (i - getPaddingLeft()));
            if (this.cFN == null) {
                this.cFN = new c(this, null);
            }
            post(this.cFN.aL(indexOfChild, left));
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
        this.cEz = this.mAdapter == null ? 0 : this.mAdapter.getCount();
        if (this.cEz > 0 && (mode == 0 || mode2 == 0)) {
            View b2 = b(0, this.cDh);
            g(b2, 0, i2);
            i4 = b2.getMeasuredWidth();
            i5 = b2.getMeasuredHeight();
            r1 = Build.VERSION.SDK_INT >= 11 ? combineMeasuredStates(0, b2.getMeasuredState()) : 0;
            if (alj() && this.cCr.kh(((AbsHListView.f) b2.getLayoutParams()).cDH)) {
                this.cCr.r(b2, -1);
            }
        }
        int i6 = i5;
        int i7 = i4;
        if (mode2 == 0) {
            i3 = i6 + this.cCw.top + this.cCw.bottom + getHorizontalScrollbarHeight();
        } else if (mode2 == Integer.MIN_VALUE && this.cEz > 0 && this.cFC > -1) {
            i3 = d(i2, this.cFC, this.cFC, size, size2, -1)[1];
        } else {
            i3 = Build.VERSION.SDK_INT >= 11 ? size2 | ((-16777216) & r1) : size2;
        }
        if (mode == 0) {
            size = this.cCw.left + this.cCw.right + i7 + (getHorizontalFadingEdgeLength() * 2);
        }
        if (mode == Integer.MIN_VALUE) {
            size = d(i2, 0, -1, size, -1);
        }
        setMeasuredDimension(size, i3);
        this.cCx = i2;
    }

    private void g(View view, int i, int i2) {
        int makeMeasureSpec;
        AbsHListView.f fVar = (AbsHListView.f) view.getLayoutParams();
        if (fVar == null) {
            fVar = (AbsHListView.f) generateDefaultLayoutParams();
            view.setLayoutParams(fVar);
        }
        fVar.cDH = this.mAdapter.getItemViewType(i);
        fVar.cDJ = true;
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, this.cCw.top + this.cCw.bottom, fVar.height);
        int i3 = fVar.width;
        if (i3 > 0) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(makeMeasureSpec, childMeasureSpec);
    }

    @ViewDebug.ExportedProperty(category = IntentConfig.LIST)
    protected boolean alj() {
        return true;
    }

    final int d(int i, int i2, int i3, int i4, int i5) {
        int i6 = 0;
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter == null) {
            return this.cCw.left + this.cCw.right;
        }
        int i7 = this.cCw.left + this.cCw.right;
        int i8 = (this.cFB <= 0 || this.cFA == null) ? 0 : this.cFB;
        if (i3 == -1) {
            i3 = listAdapter.getCount() - 1;
        }
        AbsHListView.k kVar = this.cCr;
        boolean alj = alj();
        boolean[] zArr = this.cDh;
        while (i2 <= i3) {
            View b2 = b(i2, zArr);
            g(b2, i2, i);
            int i9 = i2 > 0 ? i7 + i8 : i7;
            if (alj && kVar.kh(((AbsHListView.f) b2.getLayoutParams()).cDH)) {
                kVar.r(b2, -1);
            }
            i7 = b2.getMeasuredWidth() + i9;
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

    final int[] d(int i, int i2, int i3, int i4, int i5, int i6) {
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter == null) {
            return new int[]{this.cCw.left + this.cCw.right, this.cCw.top + this.cCw.bottom};
        }
        int i7 = this.cCw.left + this.cCw.right;
        int i8 = this.cCw.top + this.cCw.bottom;
        int i9 = (this.cFB <= 0 || this.cFA == null) ? 0 : this.cFB;
        if (i3 == -1) {
            i3 = listAdapter.getCount() - 1;
        }
        AbsHListView.k kVar = this.cCr;
        boolean alj = alj();
        boolean[] zArr = this.cDh;
        int i10 = 0;
        int i11 = 0;
        while (i2 <= i3) {
            View b2 = b(i2, zArr);
            g(b2, i2, i);
            if (alj && kVar.kh(((AbsHListView.f) b2.getLayoutParams()).cDH)) {
                kVar.r(b2, -1);
            }
            i10 = Math.max(i10, b2.getMeasuredWidth() + i9);
            i2++;
            i11 = Math.max(i11, b2.getMeasuredHeight());
        }
        return new int[]{Math.min(i10 + i7, i4), Math.min(i11 + i8, i5)};
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView
    protected int kb(int i) {
        int childCount = getChildCount();
        if (childCount > 0) {
            if (this.cCN) {
                for (int i2 = childCount - 1; i2 >= 0; i2--) {
                    if (i >= getChildAt(i2).getLeft()) {
                        return i2 + this.cEm;
                    }
                }
            } else {
                for (int i3 = 0; i3 < childCount; i3++) {
                    if (i <= getChildAt(i3).getRight()) {
                        return i3 + this.cEm;
                    }
                }
            }
        }
        return -1;
    }

    private View aH(int i, int i2) {
        View aE;
        View aF;
        boolean z = i == this.ckM;
        View a2 = a(i, i2, true, this.cCw.top, z);
        this.cEm = i;
        int i3 = this.cFB;
        if (!this.cCN) {
            aF = aF(i - 1, a2.getLeft() - i3);
            alg();
            aE = aE(i + 1, i3 + a2.getRight());
            int childCount = getChildCount();
            if (childCount > 0) {
                ku(childCount);
            }
        } else {
            aE = aE(i + 1, a2.getRight() + i3);
            alg();
            aF = aF(i - 1, a2.getLeft() - i3);
            int childCount2 = getChildCount();
            if (childCount2 > 0) {
                kv(childCount2);
            }
        }
        if (z) {
            return a2;
        }
        return aF != null ? aF : aE;
    }

    private void ku(int i) {
        if ((this.cEm + i) - 1 == this.cEz - 1 && i > 0) {
            int right = ((getRight() - getLeft()) - this.cCw.right) - getChildAt(i - 1).getRight();
            View childAt = getChildAt(0);
            int left = childAt.getLeft();
            if (right > 0) {
                if (this.cEm > 0 || left < this.cCw.top) {
                    if (this.cEm == 0) {
                        right = Math.min(right, this.cCw.top - left);
                    }
                    ka(right);
                    if (this.cEm > 0) {
                        aF(this.cEm - 1, childAt.getLeft() - this.cFB);
                        alg();
                    }
                }
            }
        }
    }

    private void kv(int i) {
        if (this.cEm == 0 && i > 0) {
            int left = getChildAt(0).getLeft();
            int i2 = this.cCw.left;
            int right = (getRight() - getLeft()) - this.cCw.right;
            int i3 = left - i2;
            View childAt = getChildAt(i - 1);
            int right2 = childAt.getRight();
            int i4 = (this.cEm + i) - 1;
            if (i3 > 0) {
                if (i4 < this.cEz - 1 || right2 > right) {
                    if (i4 == this.cEz - 1) {
                        i3 = Math.min(i3, right2 - right);
                    }
                    ka(-i3);
                    if (i4 < this.cEz - 1) {
                        aE(i4 + 1, childAt.getRight() + this.cFB);
                        alg();
                    }
                } else if (i4 == this.cEz - 1) {
                    alg();
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
        boolean z = this.cEH;
        if (z) {
            return;
        }
        this.cEH = true;
        try {
            super.layoutChildren();
            invalidate();
            if (this.mAdapter == null) {
                akn();
                akk();
                if (z) {
                    return;
                }
                return;
            }
            int i = this.cCw.left;
            int right = (getRight() - getLeft()) - this.cCw.right;
            int childCount = getChildCount();
            View view4 = null;
            View view5 = null;
            View view6 = null;
            switch (this.cCl) {
                case 1:
                case 3:
                case 4:
                case 5:
                    view = null;
                    break;
                case 2:
                    int i2 = this.cEw - this.cEm;
                    if (i2 < 0 || i2 >= childCount) {
                        view = null;
                        break;
                    } else {
                        view5 = getChildAt(i2);
                        view = null;
                        break;
                    }
                default:
                    int i3 = this.ckM - this.cEm;
                    if (i3 >= 0 && i3 < childCount) {
                        view4 = getChildAt(i3);
                    }
                    View childAt = getChildAt(0);
                    r4 = this.cEw >= 0 ? this.cEw - this.ckM : 0;
                    view5 = getChildAt(i3 + r4);
                    view = childAt;
                    break;
            }
            boolean z2 = this.ajc;
            if (z2) {
                handleDataChanged();
            }
            if (this.cEz == 0) {
                akn();
                akk();
                if (z) {
                    return;
                }
                this.cEH = false;
            } else if (this.cEz != this.mAdapter.getCount()) {
                throw new IllegalStateException("The content of the adapter has changed but ListView did not receive a notification. Make sure the content of your adapter is not modified from a background thread, but only from the UI thread. [in ListView(" + getId() + ", " + getClass() + ") with Adapter(" + this.mAdapter.getClass() + ")]");
            } else {
                setSelectedPositionInt(this.cEw);
                int i4 = this.cEm;
                AbsHListView.k kVar = this.cCr;
                View view7 = null;
                if (z2) {
                    for (int i5 = 0; i5 < childCount; i5++) {
                        kVar.r(getChildAt(i5), i4 + i5);
                    }
                } else {
                    kVar.aD(childCount, i4);
                }
                View focusedChild = getFocusedChild();
                if (focusedChild != null) {
                    if (!z2 || ay(focusedChild)) {
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
                kVar.akK();
                switch (this.cCl) {
                    case 1:
                        this.cEm = 0;
                        View kt = kt(i);
                        alg();
                        a2 = kt;
                        break;
                    case 2:
                        if (view5 != null) {
                            a2 = x(view5.getLeft(), i, right);
                            break;
                        } else {
                            a2 = aG(i, right);
                            break;
                        }
                    case 3:
                        View aF = aF(this.cEz - 1, right);
                        alg();
                        a2 = aF;
                        break;
                    case 4:
                        a2 = aH(akA(), this.cEn);
                        break;
                    case 5:
                        a2 = aH(this.cEo, this.cEn);
                        break;
                    case 6:
                        a2 = a(view4, view5, r4, i, right);
                        break;
                    default:
                        if (childCount == 0) {
                            if (this.cCN) {
                                setSelectedPositionInt(q(this.cEz - 1, false));
                                a2 = aF(this.cEz - 1, right);
                                break;
                            } else {
                                setSelectedPositionInt(q(0, true));
                                a2 = kt(i);
                                break;
                            }
                        } else if (this.ckM < 0 || this.ckM >= this.cEz) {
                            if (this.cEm < this.cEz) {
                                int i6 = this.cEm;
                                if (view != null) {
                                    i = view.getLeft();
                                }
                                a2 = aH(i6, i);
                                break;
                            } else {
                                a2 = aH(0, i);
                                break;
                            }
                        } else {
                            int i7 = this.ckM;
                            if (view4 != null) {
                                i = view4.getLeft();
                            }
                            a2 = aH(i7, i);
                            break;
                        }
                }
                kVar.akL();
                if (a2 != null) {
                    if (!this.cFK || !hasFocus() || a2.hasFocus()) {
                        c(-1, a2);
                    } else if ((a2 == view3 && view2 != null && view2.requestFocus()) || a2.requestFocus()) {
                        a2.setSelected(false);
                        this.cCq.setEmpty();
                    } else {
                        View focusedChild2 = getFocusedChild();
                        if (focusedChild2 != null) {
                            focusedChild2.clearFocus();
                        }
                        c(-1, a2);
                    }
                    this.cCM = a2.getLeft();
                } else {
                    if (this.cCH <= 0 || this.cCH >= 3) {
                        this.cCM = 0;
                        this.cCq.setEmpty();
                    } else {
                        View childAt2 = getChildAt(this.cCC - this.cEm);
                        if (childAt2 != null) {
                            c(this.cCC, childAt2);
                        }
                    }
                    if (hasFocus() && view2 != null) {
                        view2.requestFocus();
                    }
                }
                if (view2 != null && view2.getWindowToken() != null) {
                    view2.onFinishTemporaryDetach();
                }
                this.cCl = 0;
                this.ajc = false;
                if (this.cDf != null) {
                    post(this.cDf);
                    this.cDf = null;
                }
                this.cEr = false;
                setNextSelectedPositionInt(this.ckM);
                ako();
                if (this.cEz > 0) {
                    akU();
                }
                akk();
                if (z) {
                    return;
                }
                this.cEH = false;
            }
        } finally {
            if (!z) {
                this.cEH = false;
            }
        }
    }

    private boolean ay(View view) {
        ArrayList<b> arrayList = this.Ix;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (view == arrayList.get(i).view) {
                return true;
            }
        }
        ArrayList<b> arrayList2 = this.Iy;
        int size2 = arrayList2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            if (view == arrayList2.get(i2).view) {
                return true;
            }
        }
        return false;
    }

    private View a(int i, int i2, boolean z, int i3, boolean z2) {
        View ki;
        if (!this.ajc && (ki = this.cCr.ki(i)) != null) {
            a(ki, i, i2, z, i3, z2, true);
            return ki;
        }
        View b2 = b(i, this.cDh);
        a(b2, i, i2, z, i3, z2, this.cDh[0]);
        return b2;
    }

    private void a(View view, int i, int i2, boolean z, int i3, boolean z2, boolean z3) {
        int makeMeasureSpec;
        boolean z4 = z2 && akq();
        boolean isSelected = z4 ^ view.isSelected();
        int i4 = this.cCH;
        boolean z5 = i4 > 0 && i4 < 3 && this.cCC == i;
        boolean isPressed = z5 ^ view.isPressed();
        boolean z6 = !z3 || isSelected || view.isLayoutRequested();
        AbsHListView.f fVar = (AbsHListView.f) view.getLayoutParams();
        AbsHListView.f fVar2 = fVar == null ? (AbsHListView.f) generateDefaultLayoutParams() : fVar;
        fVar2.cDH = this.mAdapter.getItemViewType(i);
        if ((z3 && !fVar2.cDJ) || (fVar2.cDI && fVar2.cDH == -2)) {
            attachViewToParent(view, z ? -1 : 0, fVar2);
        } else {
            fVar2.cDJ = false;
            if (fVar2.cDH == -2) {
                fVar2.cDI = true;
            }
            addViewInLayout(view, z ? -1 : 0, fVar2, true);
        }
        if (isSelected) {
            view.setSelected(z4);
        }
        if (isPressed) {
            view.setPressed(z5);
        }
        if (this.cCf != 0 && this.cCj != null) {
            if (view instanceof Checkable) {
                ((Checkable) view).setChecked(this.cCj.get(i, false).booleanValue());
            } else if (Build.VERSION.SDK_INT >= 11) {
                view.setActivated(this.cCj.get(i, false).booleanValue());
            }
        }
        if (z6) {
            int childMeasureSpec = ViewGroup.getChildMeasureSpec(this.cCx, this.cCw.top + this.cCw.bottom, fVar2.height);
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
        if (this.cCA && !view.isDrawingCacheEnabled()) {
            view.setDrawingCacheEnabled(true);
        }
        if (Build.VERSION.SDK_INT >= 11 && z3 && ((AbsHListView.f) view.getLayoutParams()).cDK != i) {
            view.jumpDrawablesToCurrentState();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.g, android.view.ViewGroup
    public boolean canAnimate() {
        return super.canAnimate() && this.cEz > 0;
    }

    @Override // com.baidu.tieba.horizonalList.widget.g
    public void setSelection(int i) {
        aI(i, 0);
    }

    public void aI(int i, int i2) {
        if (this.mAdapter != null) {
            if (!isInTouchMode()) {
                i = q(i, true);
                if (i >= 0) {
                    setNextSelectedPositionInt(i);
                }
            } else {
                this.cCR = i;
            }
            if (i >= 0) {
                this.cCl = 4;
                this.cEn = this.cCw.left + i2;
                if (this.cEr) {
                    this.cEo = i;
                    this.cEp = this.mAdapter.getItemId(i);
                }
                if (this.cCL != null) {
                    this.cCL.stop();
                }
                requestLayout();
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView
    public void setSelectionInt(int i) {
        boolean z = true;
        setNextSelectedPositionInt(i);
        int i2 = this.ckM;
        if (i2 < 0 || (i != i2 - 1 && i != i2 + 1)) {
            z = false;
        }
        if (this.cCL != null) {
            this.cCL.stop();
        }
        layoutChildren();
        if (z) {
            awakenScrollBars();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.g
    public int q(int i, boolean z) {
        int min;
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter == null || isInTouchMode()) {
            return -1;
        }
        int count = listAdapter.getCount();
        if (!this.cFJ) {
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
        if (this.mAdapter == null || !this.cDu) {
            return false;
        }
        if (this.ajc) {
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
                        z = kw(33);
                        break;
                    }
                    break;
                case 20:
                    if (keyEvent.hasNoModifiers()) {
                        z = kw(TransportMediator.KEYCODE_MEDIA_RECORD);
                        break;
                    }
                    break;
                case 21:
                    if (keyEvent.hasNoModifiers()) {
                        z = akB();
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
                        if (!akB() && !fullScroll(33)) {
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
                        z = akB();
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
                        if (!akB() && !fullScroll(TransportMediator.KEYCODE_MEDIA_RECORD)) {
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
                        z = akB();
                        if (!z && keyEvent.getRepeatCount() == 0 && getChildCount() > 0) {
                            akr();
                            z = true;
                            break;
                        }
                    }
                    break;
                case BDLocation.TypeCriteriaException /* 62 */:
                    if (!keyEvent.hasNoModifiers() ? !keyEvent.hasModifiers(1) || akB() || !pageScroll(33) : akB() || !pageScroll(TransportMediator.KEYCODE_MEDIA_RECORD)) {
                    }
                    z = true;
                    break;
                case 92:
                    if (keyEvent.hasNoModifiers()) {
                        if (!akB() && !pageScroll(33)) {
                            z = false;
                            break;
                        } else {
                            z = true;
                            break;
                        }
                    } else if (keyEvent.hasModifiers(2)) {
                        if (!akB() && !fullScroll(33)) {
                            z = false;
                            break;
                        } else {
                            z = true;
                            break;
                        }
                    }
                    break;
                case SapiAccountManager.VERSION_CODE /* 93 */:
                    if (keyEvent.hasNoModifiers()) {
                        if (!akB() && !pageScroll(TransportMediator.KEYCODE_MEDIA_RECORD)) {
                            z = false;
                            break;
                        } else {
                            z = true;
                            break;
                        }
                    } else if (keyEvent.hasModifiers(2)) {
                        if (!akB() && !fullScroll(TransportMediator.KEYCODE_MEDIA_RECORD)) {
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
                        if (!akB() && !fullScroll(33)) {
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
                        if (!akB() && !fullScroll(TransportMediator.KEYCODE_MEDIA_RECORD)) {
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
        int q;
        if (i == 33) {
            i2 = Math.max(0, (this.ckM - getChildCount()) - 1);
            z = false;
        } else if (i != 130) {
            i2 = -1;
            z = false;
        } else {
            i2 = Math.min(this.cEz - 1, (this.ckM + getChildCount()) - 1);
            z = true;
        }
        if (i2 < 0 || (q = q(i2, z)) < 0) {
            return false;
        }
        this.cCl = 4;
        this.cEn = getPaddingLeft() + getHorizontalFadingEdgeLength();
        if (z && q > this.cEz - getChildCount()) {
            this.cCl = 3;
        }
        if (!z && q < getChildCount()) {
            this.cCl = 1;
        }
        setSelectionInt(q);
        akk();
        if (awakenScrollBars()) {
            return true;
        }
        invalidate();
        return true;
    }

    boolean fullScroll(int i) {
        boolean z = true;
        if (i == 33) {
            if (this.ckM != 0) {
                int q = q(0, true);
                if (q >= 0) {
                    this.cCl = 1;
                    setSelectionInt(q);
                    akk();
                }
            }
            z = false;
        } else {
            if (i == 130 && this.ckM < this.cEz - 1) {
                int q2 = q(this.cEz - 1, true);
                if (q2 >= 0) {
                    this.cCl = 3;
                    setSelectionInt(q2);
                    akk();
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

    private boolean kw(int i) {
        View selectedView;
        if (i != 33 && i != 130) {
            throw new IllegalArgumentException("direction must be one of {View.FOCUS_UP, View.FOCUS_DOWN}");
        }
        int childCount = getChildCount();
        if (this.cFK && childCount > 0 && this.ckM != -1 && (selectedView = getSelectedView()) != null && selectedView.hasFocus() && (selectedView instanceof ViewGroup)) {
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
            boolean kx = kx(i);
            if (kx) {
                playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
            }
            return kx;
        } finally {
            this.mInLayout = false;
        }
    }

    private boolean kx(int i) {
        View view;
        int i2;
        View view2;
        View focusedChild;
        if (getChildCount() <= 0) {
            return false;
        }
        View selectedView = getSelectedView();
        int i3 = this.ckM;
        int ky = ky(i);
        int aJ = aJ(i, ky);
        a kz = this.cFK ? kz(i) : null;
        if (kz != null) {
            ky = kz.afX();
            aJ = kz.alk();
        }
        boolean z = kz != null;
        if (ky != -1) {
            a(selectedView, i, ky, kz != null);
            setSelectedPositionInt(ky);
            setNextSelectedPositionInt(ky);
            view = getSelectedView();
            if (this.cFK && kz == null && (focusedChild = getFocusedChild()) != null) {
                focusedChild.clearFocus();
            }
            akU();
            z = true;
            i2 = ky;
        } else {
            view = selectedView;
            i2 = i3;
        }
        if (aJ > 0) {
            kA(i == 33 ? aJ : -aJ);
            z = true;
        }
        if (this.cFK && kz == null && view != null && view.hasFocus()) {
            View findFocus = view.findFocus();
            if (!a(findFocus, this) || aC(findFocus) > 0) {
                findFocus.clearFocus();
            }
        }
        if (ky != -1 || view == null || a(view, this)) {
            view2 = view;
        } else {
            akz();
            this.cCR = -1;
            view2 = null;
        }
        if (z) {
            if (view2 != null) {
                c(i2, view2);
                this.cCM = view2.getLeft();
            }
            if (!awakenScrollBars()) {
                invalidate();
            }
            akk();
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
        int i4 = this.ckM - this.cEm;
        int i5 = i2 - this.cEm;
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
            h(view2, i3, childCount);
        }
        if (view != null) {
            if (z || z2) {
                z3 = false;
            }
            view.setSelected(z3);
            h(view, i5, childCount);
        }
    }

    private void h(View view, int i, int i2) {
        int width = view.getWidth();
        az(view);
        if (view.getMeasuredWidth() != width) {
            aA(view);
            int measuredWidth = view.getMeasuredWidth() - width;
            for (int i3 = i + 1; i3 < i2; i3++) {
                getChildAt(i3).offsetLeftAndRight(measuredWidth);
            }
        }
    }

    private void az(View view) {
        int makeMeasureSpec;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-2, -1);
        }
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(this.cCx, this.cCw.top + this.cCw.bottom, layoutParams.height);
        int i = layoutParams.width;
        if (i > 0) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(makeMeasureSpec, childMeasureSpec);
    }

    private void aA(View view) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i = this.cCw.top;
        int left = view.getLeft();
        view.layout(left, i, measuredWidth + left, measuredHeight + i);
    }

    private int getArrowScrollPreviewLength() {
        return Math.max(2, getHorizontalFadingEdgeLength());
    }

    private int aJ(int i, int i2) {
        int width = getWidth() - this.cCw.right;
        int i3 = this.cCw.left;
        int childCount = getChildCount();
        if (i == 130) {
            int i4 = childCount - 1;
            if (i2 != -1) {
                i4 = i2 - this.cEm;
            }
            int i5 = this.cEm + i4;
            View childAt = getChildAt(i4);
            int arrowScrollPreviewLength = i5 < this.cEz + (-1) ? width - getArrowScrollPreviewLength() : width;
            if (childAt.getRight() <= arrowScrollPreviewLength) {
                return 0;
            }
            if (i2 == -1 || arrowScrollPreviewLength - childAt.getLeft() < getMaxScrollAmount()) {
                int right = childAt.getRight() - arrowScrollPreviewLength;
                if (this.cEm + childCount == this.cEz) {
                    right = Math.min(right, getChildAt(childCount - 1).getRight() - width);
                }
                return Math.min(right, getMaxScrollAmount());
            }
            return 0;
        }
        int i6 = i2 != -1 ? i2 - this.cEm : 0;
        int i7 = this.cEm + i6;
        View childAt2 = getChildAt(i6);
        int arrowScrollPreviewLength2 = i7 > 0 ? getArrowScrollPreviewLength() + i3 : i3;
        if (childAt2.getLeft() < arrowScrollPreviewLength2) {
            if (i2 == -1 || childAt2.getRight() - arrowScrollPreviewLength2 < getMaxScrollAmount()) {
                int left = arrowScrollPreviewLength2 - childAt2.getLeft();
                if (this.cEm == 0) {
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
        private int cFO;
        private int ckM;

        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }

        void aK(int i, int i2) {
            this.ckM = i;
            this.cFO = i2;
        }

        public int afX() {
            return this.ckM;
        }

        public int alk() {
            return this.cFO;
        }
    }

    private int ky(int i) {
        int i2 = this.cEm;
        if (i == 130) {
            int i3 = this.ckM != -1 ? this.ckM + 1 : i2;
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
            int childCount2 = this.ckM != -1 ? this.ckM - 1 : (getChildCount() + i2) - 1;
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

    private a kz(int i) {
        View findNextFocusFromRect;
        int ky;
        View selectedView = getSelectedView();
        if (selectedView != null && selectedView.hasFocus()) {
            findNextFocusFromRect = FocusFinder.getInstance().findNextFocus(this, selectedView.findFocus(), i);
        } else {
            if (i == 130) {
                int arrowScrollPreviewLength = (this.cEm > 0 ? getArrowScrollPreviewLength() : 0) + this.cCw.left;
                if (selectedView != null && selectedView.getLeft() > arrowScrollPreviewLength) {
                    arrowScrollPreviewLength = selectedView.getLeft();
                }
                this.mTempRect.set(arrowScrollPreviewLength, 0, arrowScrollPreviewLength, 0);
            } else {
                int width = (getWidth() - this.cCw.right) - ((this.cEm + getChildCount()) + (-1) < this.cEz ? getArrowScrollPreviewLength() : 0);
                if (selectedView != null && selectedView.getRight() < width) {
                    width = selectedView.getRight();
                }
                this.mTempRect.set(width, 0, width, 0);
            }
            findNextFocusFromRect = FocusFinder.getInstance().findNextFocusFromRect(this, this.mTempRect, i);
        }
        if (findNextFocusFromRect != null) {
            int aB = aB(findNextFocusFromRect);
            if (this.ckM != -1 && aB != this.ckM && (ky = ky(i)) != -1 && ((i == 130 && ky < aB) || (i == 33 && ky > aB))) {
                return null;
            }
            int a2 = a(i, findNextFocusFromRect, aB);
            int maxScrollAmount = getMaxScrollAmount();
            if (a2 < maxScrollAmount) {
                findNextFocusFromRect.requestFocus(i);
                this.cFM.aK(aB, a2);
                return this.cFM;
            } else if (aC(findNextFocusFromRect) < maxScrollAmount) {
                findNextFocusFromRect.requestFocus(i);
                this.cFM.aK(aB, maxScrollAmount);
                return this.cFM;
            }
        }
        return null;
    }

    private int aB(View view) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (a(view, getChildAt(i))) {
                return i + this.cEm;
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

    private int a(int i, View view, int i2) {
        view.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(view, this.mTempRect);
        if (i == 33) {
            if (this.mTempRect.left >= this.cCw.left) {
                return 0;
            }
            int i3 = this.cCw.left - this.mTempRect.left;
            if (i2 > 0) {
                return i3 + getArrowScrollPreviewLength();
            }
            return i3;
        }
        int width = getWidth() - this.cCw.right;
        if (this.mTempRect.bottom <= width) {
            return 0;
        }
        int i4 = this.mTempRect.right - width;
        if (i2 < this.cEz - 1) {
            return i4 + getArrowScrollPreviewLength();
        }
        return i4;
    }

    private int aC(View view) {
        view.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(view, this.mTempRect);
        int right = (getRight() - getLeft()) - this.cCw.right;
        if (this.mTempRect.right < this.cCw.left) {
            return this.cCw.left - this.mTempRect.right;
        }
        if (this.mTempRect.left <= right) {
            return 0;
        }
        return this.mTempRect.left - right;
    }

    private void kA(int i) {
        int i2;
        ka(i);
        int width = getWidth() - this.cCw.right;
        int i3 = this.cCw.left;
        AbsHListView.k kVar = this.cCr;
        if (i < 0) {
            int childCount = getChildCount();
            View childAt = getChildAt(childCount - 1);
            while (childAt.getRight() < width && (this.cEm + childCount) - 1 < this.cEz - 1) {
                childAt = u(childAt, i2);
                childCount++;
            }
            if (childAt.getBottom() < width) {
                ka(width - childAt.getRight());
            }
            View childAt2 = getChildAt(0);
            while (true) {
                View view = childAt2;
                if (view.getRight() < i3) {
                    if (kVar.kh(((AbsHListView.f) view.getLayoutParams()).cDH)) {
                        detachViewFromParent(view);
                        kVar.r(view, this.cEm);
                    } else {
                        removeViewInLayout(view);
                    }
                    childAt2 = getChildAt(0);
                    this.cEm++;
                } else {
                    return;
                }
            }
        } else {
            View childAt3 = getChildAt(0);
            while (childAt3.getLeft() > i3 && this.cEm > 0) {
                childAt3 = t(childAt3, this.cEm);
                this.cEm--;
            }
            if (childAt3.getLeft() > i3) {
                ka(i3 - childAt3.getLeft());
            }
            int childCount2 = getChildCount() - 1;
            View childAt4 = getChildAt(childCount2);
            while (true) {
                int i4 = childCount2;
                View view2 = childAt4;
                if (view2.getLeft() > width) {
                    if (kVar.kh(((AbsHListView.f) view2.getLayoutParams()).cDH)) {
                        detachViewFromParent(view2);
                        kVar.r(view2, this.cEm + i4);
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

    private View t(View view, int i) {
        int i2 = i - 1;
        View b2 = b(i2, this.cDh);
        a(b2, i2, view.getLeft() - this.cFB, false, this.cCw.top, false, this.cDh[0]);
        return b2;
    }

    private View u(View view, int i) {
        int i2 = i + 1;
        View b2 = b(i2, this.cDh);
        a(b2, i2, this.cFB + view.getRight(), true, this.cCw.top, false, this.cDh[0]);
        return b2;
    }

    public void setItemsCanFocus(boolean z) {
        this.cFK = z;
        if (!z) {
            setDescendantFocusability(393216);
        }
    }

    public boolean getItemsCanFocus() {
        return this.cFK;
    }

    @Override // android.view.View
    public boolean isOpaque() {
        boolean z = (this.cCB && this.cFF && this.cFG) || super.isOpaque();
        if (z) {
            int paddingLeft = this.cCw != null ? this.cCw.left : getPaddingLeft();
            View childAt = getChildAt(0);
            if (childAt == null || childAt.getLeft() > paddingLeft) {
                return false;
            }
            int width = getWidth() - (this.cCw != null ? this.cCw.right : getPaddingRight());
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
        this.cFF = z;
        if (z) {
            if (this.cFL == null) {
                this.cFL = new Paint();
            }
            this.cFL.setColor(i);
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
        if (this.cCA) {
            this.cCB = true;
        }
        int i = this.cFB;
        Drawable drawable = this.cFD;
        Drawable drawable2 = this.cFE;
        boolean z = drawable != null;
        boolean z2 = drawable2 != null;
        boolean z3 = i > 0 && this.cFA != null;
        if (z3 || z || z2) {
            Rect rect = this.mTempRect;
            rect.top = getPaddingTop();
            rect.bottom = (getBottom() - getTop()) - getPaddingBottom();
            int childCount = getChildCount();
            int size = this.Ix.size();
            int i2 = this.cEz;
            int size2 = (i2 - this.Iy.size()) - 1;
            boolean z4 = this.cFH;
            boolean z5 = this.cFI;
            int i3 = this.cEm;
            boolean z6 = this.cFJ;
            ListAdapter listAdapter = this.mAdapter;
            boolean z7 = isOpaque() && !super.isOpaque();
            if (z7 && this.cFL == null && this.cFF) {
                this.cFL = new Paint();
                this.cFL.setColor(getCacheColorHint());
            }
            Paint paint = this.cFL;
            int scrollX = getScrollX() + ((getRight() - getLeft()) - 0);
            if (!this.cCN) {
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
        if (this.cCB) {
            this.cCB = false;
        }
        return drawChild;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Canvas canvas, Rect rect, int i) {
        Drawable drawable = this.cFA;
        drawable.setBounds(rect);
        drawable.draw(canvas);
    }

    public Drawable getDivider() {
        return this.cFA;
    }

    public void setDivider(Drawable drawable) {
        boolean z = false;
        if (drawable != null) {
            this.cFB = drawable.getIntrinsicWidth();
        } else {
            this.cFB = 0;
        }
        this.cFA = drawable;
        this.cFG = (drawable == null || drawable.getOpacity() == -1) ? true : true;
        requestLayout();
        invalidate();
    }

    public int getDividerWidth() {
        return this.cFB;
    }

    public void setDividerWidth(int i) {
        this.cFB = i;
        requestLayout();
        invalidate();
    }

    public void setHeaderDividersEnabled(boolean z) {
        this.cFH = z;
        invalidate();
    }

    public void setFooterDividersEnabled(boolean z) {
        this.cFI = z;
        invalidate();
    }

    public void setOverscrollHeader(Drawable drawable) {
        this.cFD = drawable;
        if (getScrollX() < 0) {
            invalidate();
        }
    }

    public Drawable getOverscrollHeader() {
        return this.cFD;
    }

    public void setOverscrollFooter(Drawable drawable) {
        this.cFE = drawable;
        invalidate();
    }

    public Drawable getOverscrollFooter() {
        return this.cFE;
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
            if (listAdapter.getCount() < getChildCount() + this.cEm) {
                this.cCl = 0;
                layoutChildren();
            }
            Rect rect2 = this.mTempRect;
            int i6 = Integer.MAX_VALUE;
            int childCount = getChildCount();
            int i7 = this.cEm;
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
            aI(this.cEm + i5, i4);
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
        if (this.cCf != 0 && this.cCj != null && this.mAdapter != null) {
            SparseArrayCompat<Boolean> sparseArrayCompat = this.cCj;
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
        accessibilityEvent.setClassName(HListView.class.getName());
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.g, android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(HListView.class.getName());
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

        /* synthetic */ d(HListView hListView, d dVar) {
            this();
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return Math.abs(f) > Math.abs(f2);
        }
    }
}
