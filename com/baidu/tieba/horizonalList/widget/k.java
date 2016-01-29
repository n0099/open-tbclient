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
import com.baidu.tieba.t;
import java.util.ArrayList;
@RemoteViews.RemoteView
/* loaded from: classes.dex */
public class k extends AbsHListView {
    private ArrayList<b> Ik;
    private ArrayList<b> Il;
    private boolean bIA;
    private boolean bIB;
    private boolean bIC;
    private boolean bID;
    private boolean bIE;
    private Paint bIF;
    private final a bIG;
    private c bIH;
    Drawable bIu;
    int bIv;
    int bIw;
    Drawable bIx;
    Drawable bIy;
    private boolean bIz;
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
        this(context, attributeSet, t.c.hlv_listViewStyle);
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
        this.Ik = new ArrayList<>();
        this.Il = new ArrayList<>();
        this.bID = true;
        this.bIE = false;
        this.mTempRect = new Rect();
        this.bIG = new a(null);
        this.mGestureDetector = new GestureDetector(new d(this, null));
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, t.l.HListView, i, 0);
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
        this.bIB = z;
        this.bIC = z2;
        this.bIw = i3;
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
    private void Xj() {
        int right;
        int i = 0;
        int childCount = getChildCount();
        if (childCount > 0) {
            if (!this.bFH) {
                right = getChildAt(0).getLeft() - this.bFr.left;
                if (this.bHg != 0) {
                    right -= this.bIv;
                }
            } else {
                right = getChildAt(childCount - 1).getRight() - (getWidth() - this.bFr.right);
                if (childCount + this.bHg < this.bHt) {
                    right += this.bIv;
                }
            }
            if (i != 0) {
                hT(-i);
            }
        }
    }

    public void addHeaderView(View view, Object obj, boolean z) {
        if (this.mAdapter != null && !(this.mAdapter instanceof n)) {
            throw new IllegalStateException("Cannot add header view to list -- setAdapter has already been called.");
        }
        b bVar = new b();
        bVar.view = view;
        bVar.data = obj;
        bVar.isSelectable = z;
        this.Ik.add(bVar);
        if (this.mAdapter != null && this.bFh != null) {
            this.bFh.onChanged();
        }
    }

    public void addHeaderView(View view) {
        addHeaderView(view, null, true);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView
    public int getHeaderViewsCount() {
        return this.Ik.size();
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView
    public int getFooterViewsCount() {
        return this.Il.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.horizonalList.widget.g
    public ListAdapter getAdapter() {
        return this.mAdapter;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView
    public void setAdapter(ListAdapter listAdapter) {
        int k;
        if (this.mAdapter != null && this.bFh != null) {
            this.mAdapter.unregisterDataSetObserver(this.bFh);
        }
        Wr();
        this.bFm.clear();
        if (this.Ik.size() > 0 || this.Il.size() > 0) {
            this.mAdapter = new n(this.Ik, this.Il, listAdapter);
        } else {
            this.mAdapter = listAdapter;
        }
        this.bHw = -1;
        this.bHx = Long.MIN_VALUE;
        super.setAdapter(listAdapter);
        if (this.mAdapter != null) {
            this.bID = this.mAdapter.areAllItemsEnabled();
            this.bHu = this.bHt;
            this.bHt = this.mAdapter.getCount();
            WT();
            this.bFh = new AbsHListView.a();
            this.mAdapter.registerDataSetObserver(this.bFh);
            this.bFm.hY(this.mAdapter.getViewTypeCount());
            if (this.bFH) {
                k = k(this.bHt - 1, false);
            } else {
                k = k(0, true);
            }
            setSelectedPositionInt(k);
            setNextSelectedPositionInt(k);
            if (this.bHt == 0) {
                WY();
            }
        } else {
            this.bID = true;
            WT();
            WY();
        }
        requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView
    public void Wr() {
        J(this.Ik);
        J(this.Il);
        super.Wr();
        this.bFg = 0;
    }

    private void J(ArrayList<b> arrayList) {
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                AbsHListView.f fVar = (AbsHListView.f) arrayList.get(i).view.getLayoutParams();
                if (fVar != null) {
                    fVar.bGC = false;
                }
            }
        }
    }

    private boolean Xk() {
        return this.bHg > 0 || getChildAt(0).getLeft() > getScrollX() + this.bFr.left;
    }

    private boolean Xl() {
        int childCount = getChildCount();
        return (childCount + this.bHg) + (-1) < this.bHt + (-1) || getChildAt(childCount + (-1)).getRight() < (getScrollX() + getWidth()) - this.bFr.right;
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
        if (Xk() && (this.bBx > 0 || i4 > horizontalFadingEdgeLength)) {
            scrollX += horizontalFadingEdgeLength;
        }
        int right = getChildAt(getChildCount() - 1).getRight();
        if (Xl() && (this.bBx < this.bHt - 1 || rect.right < right - horizontalFadingEdgeLength)) {
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
            iu(-i);
            c(-1, view);
            this.bFG = view.getTop();
            invalidate();
        }
        return z2;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView
    protected void db(boolean z) {
        int childCount = getChildCount();
        if (z) {
            al(childCount + this.bHg, childCount > 0 ? getChildAt(childCount - 1).getRight() + this.bIv : 0);
            io(getChildCount());
            return;
        }
        am(this.bHg - 1, childCount > 0 ? getChildAt(0).getLeft() - this.bIv : getWidth() - 0);
        ip(getChildCount());
    }

    private View al(int i, int i2) {
        View view = null;
        int right = getRight() - getLeft();
        int i3 = i2;
        int i4 = i;
        while (i3 < right && i4 < this.bHt) {
            boolean z = i4 == this.bBx;
            View a2 = a(i4, i3, true, this.bFr.top, z);
            i3 = a2.getRight() + this.bIv;
            if (!z) {
                a2 = view;
            }
            i4++;
            view = a2;
        }
        ai(this.bHg, (this.bHg + getChildCount()) - 1);
        return view;
    }

    private View am(int i, int i2) {
        View view = null;
        int i3 = i2;
        int i4 = i;
        while (i3 > 0 && i4 >= 0) {
            boolean z = i4 == this.bBx;
            View a2 = a(i4, i3, false, this.bFr.top, z);
            i3 = a2.getLeft() - this.bIv;
            if (!z) {
                a2 = view;
            }
            i4--;
            view = a2;
        }
        this.bHg = i4 + 1;
        ai(this.bHg, (this.bHg + getChildCount()) - 1);
        return view;
    }

    private View in(int i) {
        this.bHg = Math.min(this.bHg, this.bBx);
        this.bHg = Math.min(this.bHg, this.bHt - 1);
        if (this.bHg < 0) {
            this.bHg = 0;
        }
        return al(this.bHg, i);
    }

    private View an(int i, int i2) {
        int i3 = i2 - i;
        int WE = WE();
        View a2 = a(WE, i, true, this.bFr.top, true);
        this.bHg = WE;
        int measuredWidth = a2.getMeasuredWidth();
        if (measuredWidth <= i3) {
            a2.offsetLeftAndRight((i3 - measuredWidth) / 2);
        }
        r(a2, WE);
        if (!this.bFH) {
            io(getChildCount());
        } else {
            ip(getChildCount());
        }
        return a2;
    }

    private void r(View view, int i) {
        int i2 = this.bIv;
        if (!this.bFH) {
            am(i - 1, view.getLeft() - i2);
            Xj();
            al(i + 1, i2 + view.getRight());
            return;
        }
        al(i + 1, view.getRight() + i2);
        Xj();
        am(i - 1, view.getLeft() - i2);
    }

    private View s(int i, int i2, int i3) {
        int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
        int i4 = this.bBx;
        int u = u(i2, horizontalFadingEdgeLength, i4);
        int t = t(i3, horizontalFadingEdgeLength, i4);
        View a2 = a(i4, i, true, this.bFr.top, true);
        if (a2.getRight() > t) {
            a2.offsetLeftAndRight(-Math.min(a2.getLeft() - u, a2.getRight() - t));
        } else if (a2.getLeft() < u) {
            a2.offsetLeftAndRight(Math.min(u - a2.getLeft(), t - a2.getRight()));
        }
        r(a2, i4);
        if (!this.bFH) {
            io(getChildCount());
        } else {
            ip(getChildCount());
        }
        return a2;
    }

    private int t(int i, int i2, int i3) {
        if (i3 != this.bHt - 1) {
            return i - i2;
        }
        return i;
    }

    private int u(int i, int i2, int i3) {
        if (i3 > 0) {
            return i + i2;
        }
        return i;
    }

    private View a(View view, View view2, int i, int i2, int i3) {
        View a2;
        int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
        int i4 = this.bBx;
        int u = u(i2, horizontalFadingEdgeLength, i4);
        int t = t(i2, horizontalFadingEdgeLength, i4);
        if (i > 0) {
            View a3 = a(i4 - 1, view.getLeft(), true, this.bFr.top, false);
            int i5 = this.bIv;
            a2 = a(i4, a3.getRight() + i5, true, this.bFr.top, true);
            if (a2.getRight() > t) {
                int min = Math.min(Math.min(a2.getLeft() - u, a2.getRight() - t), (i3 - i2) / 2);
                a3.offsetLeftAndRight(-min);
                a2.offsetLeftAndRight(-min);
            }
            if (!this.bFH) {
                am(this.bBx - 2, a2.getLeft() - i5);
                Xj();
                al(this.bBx + 1, a2.getRight() + i5);
            } else {
                al(this.bBx + 1, a2.getRight() + i5);
                Xj();
                am(this.bBx - 2, a2.getLeft() - i5);
            }
        } else if (i < 0) {
            if (view2 != null) {
                a2 = a(i4, view2.getLeft(), true, this.bFr.top, true);
            } else {
                a2 = a(i4, view.getLeft(), false, this.bFr.top, true);
            }
            if (a2.getLeft() < u) {
                a2.offsetLeftAndRight(Math.min(Math.min(u - a2.getLeft(), t - a2.getRight()), (i3 - i2) / 2));
            }
            r(a2, i4);
        } else {
            int left = view.getLeft();
            a2 = a(i4, left, true, this.bFr.top, true);
            if (left < i2 && a2.getRight() < i2 + 20) {
                a2.offsetLeftAndRight(i2 - a2.getLeft());
            }
            r(a2, i4);
        }
        return a2;
    }

    /* loaded from: classes.dex */
    private class c implements Runnable {
        private int anV;
        private int bIJ;

        private c() {
        }

        /* synthetic */ c(k kVar, c cVar) {
            this();
        }

        public c as(int i, int i2) {
            this.anV = i;
            this.bIJ = i2;
            return this;
        }

        @Override // java.lang.Runnable
        public void run() {
            k.this.ap(this.anV, this.bIJ);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        View focusedChild;
        if (getChildCount() > 0 && (focusedChild = getFocusedChild()) != null) {
            int indexOfChild = this.bHg + indexOfChild(focusedChild);
            int left = focusedChild.getLeft() - Math.max(0, focusedChild.getRight() - (i - getPaddingLeft()));
            if (this.bIH == null) {
                this.bIH = new c(this, null);
            }
            post(this.bIH.as(indexOfChild, left));
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
        this.bHt = this.mAdapter == null ? 0 : this.mAdapter.getCount();
        if (this.bHt > 0 && (mode == 0 || mode2 == 0)) {
            View b2 = b(0, this.bGb);
            e(b2, 0, i2);
            i4 = b2.getMeasuredWidth();
            i5 = b2.getMeasuredHeight();
            r1 = Build.VERSION.SDK_INT >= 11 ? combineMeasuredStates(0, b2.getMeasuredState()) : 0;
            if (Xm() && this.bFm.hZ(((AbsHListView.f) b2.getLayoutParams()).bGB)) {
                this.bFm.q(b2, -1);
            }
        }
        int i6 = i5;
        int i7 = i4;
        if (mode2 == 0) {
            i3 = i6 + this.bFr.top + this.bFr.bottom + getHorizontalScrollbarHeight();
        } else if (mode2 == Integer.MIN_VALUE && this.bHt > 0 && this.bIw > -1) {
            i3 = b(i2, this.bIw, this.bIw, size, size2, -1)[1];
        } else {
            i3 = Build.VERSION.SDK_INT >= 11 ? size2 | ((-16777216) & r1) : size2;
        }
        if (mode == 0) {
            size = this.bFr.left + this.bFr.right + i7 + (getHorizontalFadingEdgeLength() * 2);
        }
        if (mode == Integer.MIN_VALUE) {
            size = b(i2, 0, -1, size, -1);
        }
        setMeasuredDimension(size, i3);
        this.bFs = i2;
    }

    private void e(View view, int i, int i2) {
        int makeMeasureSpec;
        AbsHListView.f fVar = (AbsHListView.f) view.getLayoutParams();
        if (fVar == null) {
            fVar = (AbsHListView.f) generateDefaultLayoutParams();
            view.setLayoutParams(fVar);
        }
        fVar.bGB = this.mAdapter.getItemViewType(i);
        fVar.bGD = true;
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, this.bFr.top + this.bFr.bottom, fVar.height);
        int i3 = fVar.width;
        if (i3 > 0) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(makeMeasureSpec, childMeasureSpec);
    }

    @ViewDebug.ExportedProperty(category = IntentConfig.LIST)
    protected boolean Xm() {
        return true;
    }

    final int b(int i, int i2, int i3, int i4, int i5) {
        int i6 = 0;
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter == null) {
            return this.bFr.left + this.bFr.right;
        }
        int i7 = this.bFr.left + this.bFr.right;
        int i8 = (this.bIv <= 0 || this.bIu == null) ? 0 : this.bIv;
        if (i3 == -1) {
            i3 = listAdapter.getCount() - 1;
        }
        AbsHListView.k kVar = this.bFm;
        boolean Xm = Xm();
        boolean[] zArr = this.bGb;
        while (i2 <= i3) {
            View b2 = b(i2, zArr);
            e(b2, i2, i);
            int i9 = i2 > 0 ? i7 + i8 : i7;
            if (Xm && kVar.hZ(((AbsHListView.f) b2.getLayoutParams()).bGB)) {
                kVar.q(b2, -1);
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

    final int[] b(int i, int i2, int i3, int i4, int i5, int i6) {
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter == null) {
            return new int[]{this.bFr.left + this.bFr.right, this.bFr.top + this.bFr.bottom};
        }
        int i7 = this.bFr.left + this.bFr.right;
        int i8 = this.bFr.top + this.bFr.bottom;
        int i9 = (this.bIv <= 0 || this.bIu == null) ? 0 : this.bIv;
        if (i3 == -1) {
            i3 = listAdapter.getCount() - 1;
        }
        AbsHListView.k kVar = this.bFm;
        boolean Xm = Xm();
        boolean[] zArr = this.bGb;
        int i10 = 0;
        int i11 = 0;
        while (i2 <= i3) {
            View b2 = b(i2, zArr);
            e(b2, i2, i);
            if (Xm && kVar.hZ(((AbsHListView.f) b2.getLayoutParams()).bGB)) {
                kVar.q(b2, -1);
            }
            i10 = Math.max(i10, b2.getMeasuredWidth() + i9);
            i2++;
            i11 = Math.max(i11, b2.getMeasuredHeight());
        }
        return new int[]{Math.min(i10 + i7, i4), Math.min(i11 + i8, i5)};
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView
    protected int hU(int i) {
        int childCount = getChildCount();
        if (childCount > 0) {
            if (this.bFH) {
                for (int i2 = childCount - 1; i2 >= 0; i2--) {
                    if (i >= getChildAt(i2).getLeft()) {
                        return i2 + this.bHg;
                    }
                }
            } else {
                for (int i3 = 0; i3 < childCount; i3++) {
                    if (i <= getChildAt(i3).getRight()) {
                        return i3 + this.bHg;
                    }
                }
            }
        }
        return -1;
    }

    private View ao(int i, int i2) {
        View al;
        View am;
        boolean z = i == this.bBx;
        View a2 = a(i, i2, true, this.bFr.top, z);
        this.bHg = i;
        int i3 = this.bIv;
        if (!this.bFH) {
            am = am(i - 1, a2.getLeft() - i3);
            Xj();
            al = al(i + 1, i3 + a2.getRight());
            int childCount = getChildCount();
            if (childCount > 0) {
                io(childCount);
            }
        } else {
            al = al(i + 1, a2.getRight() + i3);
            Xj();
            am = am(i - 1, a2.getLeft() - i3);
            int childCount2 = getChildCount();
            if (childCount2 > 0) {
                ip(childCount2);
            }
        }
        if (z) {
            return a2;
        }
        return am != null ? am : al;
    }

    private void io(int i) {
        if ((this.bHg + i) - 1 == this.bHt - 1 && i > 0) {
            int right = ((getRight() - getLeft()) - this.bFr.right) - getChildAt(i - 1).getRight();
            View childAt = getChildAt(0);
            int left = childAt.getLeft();
            if (right > 0) {
                if (this.bHg > 0 || left < this.bFr.top) {
                    if (this.bHg == 0) {
                        right = Math.min(right, this.bFr.top - left);
                    }
                    hT(right);
                    if (this.bHg > 0) {
                        am(this.bHg - 1, childAt.getLeft() - this.bIv);
                        Xj();
                    }
                }
            }
        }
    }

    private void ip(int i) {
        if (this.bHg == 0 && i > 0) {
            int left = getChildAt(0).getLeft();
            int i2 = this.bFr.left;
            int right = (getRight() - getLeft()) - this.bFr.right;
            int i3 = left - i2;
            View childAt = getChildAt(i - 1);
            int right2 = childAt.getRight();
            int i4 = (this.bHg + i) - 1;
            if (i3 > 0) {
                if (i4 < this.bHt - 1 || right2 > right) {
                    if (i4 == this.bHt - 1) {
                        i3 = Math.min(i3, right2 - right);
                    }
                    hT(-i3);
                    if (i4 < this.bHt - 1) {
                        al(i4 + 1, childAt.getRight() + this.bIv);
                        Xj();
                    }
                } else if (i4 == this.bHt - 1) {
                    Xj();
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
        boolean z = this.bHB;
        if (z) {
            return;
        }
        this.bHB = true;
        try {
            super.layoutChildren();
            invalidate();
            if (this.mAdapter == null) {
                Wr();
                Wo();
                if (z) {
                    return;
                }
                return;
            }
            int i = this.bFr.left;
            int right = (getRight() - getLeft()) - this.bFr.right;
            int childCount = getChildCount();
            View view4 = null;
            View view5 = null;
            View view6 = null;
            switch (this.bFg) {
                case 1:
                case 3:
                case 4:
                case 5:
                    view = null;
                    break;
                case 2:
                    int i2 = this.bHq - this.bHg;
                    if (i2 < 0 || i2 >= childCount) {
                        view = null;
                        break;
                    } else {
                        view5 = getChildAt(i2);
                        view = null;
                        break;
                    }
                default:
                    int i3 = this.bBx - this.bHg;
                    if (i3 >= 0 && i3 < childCount) {
                        view4 = getChildAt(i3);
                    }
                    View childAt = getChildAt(0);
                    r4 = this.bHq >= 0 ? this.bHq - this.bBx : 0;
                    view5 = getChildAt(i3 + r4);
                    view = childAt;
                    break;
            }
            boolean z2 = this.afI;
            if (z2) {
                handleDataChanged();
            }
            if (this.bHt == 0) {
                Wr();
                Wo();
                if (z) {
                    return;
                }
                this.bHB = false;
            } else if (this.bHt != this.mAdapter.getCount()) {
                throw new IllegalStateException("The content of the adapter has changed but ListView did not receive a notification. Make sure the content of your adapter is not modified from a background thread, but only from the UI thread. [in ListView(" + getId() + ", " + getClass() + ") with Adapter(" + this.mAdapter.getClass() + ")]");
            } else {
                setSelectedPositionInt(this.bHq);
                int i4 = this.bHg;
                AbsHListView.k kVar = this.bFm;
                View view7 = null;
                if (z2) {
                    for (int i5 = 0; i5 < childCount; i5++) {
                        kVar.q(getChildAt(i5), i4 + i5);
                    }
                } else {
                    kVar.ak(childCount, i4);
                }
                View focusedChild = getFocusedChild();
                if (focusedChild != null) {
                    if (!z2 || ac(focusedChild)) {
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
                kVar.WO();
                switch (this.bFg) {
                    case 1:
                        this.bHg = 0;
                        View in = in(i);
                        Xj();
                        a2 = in;
                        break;
                    case 2:
                        if (view5 != null) {
                            a2 = s(view5.getLeft(), i, right);
                            break;
                        } else {
                            a2 = an(i, right);
                            break;
                        }
                    case 3:
                        View am = am(this.bHt - 1, right);
                        Xj();
                        a2 = am;
                        break;
                    case 4:
                        a2 = ao(WE(), this.bHh);
                        break;
                    case 5:
                        a2 = ao(this.bHi, this.bHh);
                        break;
                    case 6:
                        a2 = a(view4, view5, r4, i, right);
                        break;
                    default:
                        if (childCount == 0) {
                            if (this.bFH) {
                                setSelectedPositionInt(k(this.bHt - 1, false));
                                a2 = am(this.bHt - 1, right);
                                break;
                            } else {
                                setSelectedPositionInt(k(0, true));
                                a2 = in(i);
                                break;
                            }
                        } else if (this.bBx < 0 || this.bBx >= this.bHt) {
                            if (this.bHg < this.bHt) {
                                int i6 = this.bHg;
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
                            int i7 = this.bBx;
                            if (view4 != null) {
                                i = view4.getLeft();
                            }
                            a2 = ao(i7, i);
                            break;
                        }
                }
                kVar.WP();
                if (a2 != null) {
                    if (!this.bIE || !hasFocus() || a2.hasFocus()) {
                        c(-1, a2);
                    } else if ((a2 == view3 && view2 != null && view2.requestFocus()) || a2.requestFocus()) {
                        a2.setSelected(false);
                        this.bFl.setEmpty();
                    } else {
                        View focusedChild2 = getFocusedChild();
                        if (focusedChild2 != null) {
                            focusedChild2.clearFocus();
                        }
                        c(-1, a2);
                    }
                    this.bFG = a2.getLeft();
                } else {
                    if (this.mTouchMode <= 0 || this.mTouchMode >= 3) {
                        this.bFG = 0;
                        this.bFl.setEmpty();
                    } else {
                        View childAt2 = getChildAt(this.bFx - this.bHg);
                        if (childAt2 != null) {
                            c(this.bFx, childAt2);
                        }
                    }
                    if (hasFocus() && view2 != null) {
                        view2.requestFocus();
                    }
                }
                if (view2 != null && view2.getWindowToken() != null) {
                    view2.onFinishTemporaryDetach();
                }
                this.bFg = 0;
                this.afI = false;
                if (this.bFZ != null) {
                    post(this.bFZ);
                    this.bFZ = null;
                }
                this.bHl = false;
                setNextSelectedPositionInt(this.bBx);
                Ws();
                if (this.bHt > 0) {
                    WY();
                }
                Wo();
                if (z) {
                    return;
                }
                this.bHB = false;
            }
        } finally {
            if (!z) {
                this.bHB = false;
            }
        }
    }

    private boolean ac(View view) {
        ArrayList<b> arrayList = this.Ik;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (view == arrayList.get(i).view) {
                return true;
            }
        }
        ArrayList<b> arrayList2 = this.Il;
        int size2 = arrayList2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            if (view == arrayList2.get(i2).view) {
                return true;
            }
        }
        return false;
    }

    private View a(int i, int i2, boolean z, int i3, boolean z2) {
        View ia;
        if (!this.afI && (ia = this.bFm.ia(i)) != null) {
            a(ia, i, i2, z, i3, z2, true);
            return ia;
        }
        View b2 = b(i, this.bGb);
        a(b2, i, i2, z, i3, z2, this.bGb[0]);
        return b2;
    }

    private void a(View view, int i, int i2, boolean z, int i3, boolean z2, boolean z3) {
        int makeMeasureSpec;
        boolean z4 = z2 && Wu();
        boolean isSelected = z4 ^ view.isSelected();
        int i4 = this.mTouchMode;
        boolean z5 = i4 > 0 && i4 < 3 && this.bFx == i;
        boolean isPressed = z5 ^ view.isPressed();
        boolean z6 = !z3 || isSelected || view.isLayoutRequested();
        AbsHListView.f fVar = (AbsHListView.f) view.getLayoutParams();
        AbsHListView.f fVar2 = fVar == null ? (AbsHListView.f) generateDefaultLayoutParams() : fVar;
        fVar2.bGB = this.mAdapter.getItemViewType(i);
        if ((z3 && !fVar2.bGD) || (fVar2.bGC && fVar2.bGB == -2)) {
            attachViewToParent(view, z ? -1 : 0, fVar2);
        } else {
            fVar2.bGD = false;
            if (fVar2.bGB == -2) {
                fVar2.bGC = true;
            }
            addViewInLayout(view, z ? -1 : 0, fVar2, true);
        }
        if (isSelected) {
            view.setSelected(z4);
        }
        if (isPressed) {
            view.setPressed(z5);
        }
        if (this.bFa != 0 && this.bFe != null) {
            if (view instanceof Checkable) {
                ((Checkable) view).setChecked(this.bFe.get(i, false).booleanValue());
            } else if (Build.VERSION.SDK_INT >= 11) {
                view.setActivated(this.bFe.get(i, false).booleanValue());
            }
        }
        if (z6) {
            int childMeasureSpec = ViewGroup.getChildMeasureSpec(this.bFs, this.bFr.top + this.bFr.bottom, fVar2.height);
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
        if (this.bFv && !view.isDrawingCacheEnabled()) {
            view.setDrawingCacheEnabled(true);
        }
        if (Build.VERSION.SDK_INT >= 11 && z3 && ((AbsHListView.f) view.getLayoutParams()).bGE != i) {
            view.jumpDrawablesToCurrentState();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.g, android.view.ViewGroup
    public boolean canAnimate() {
        return super.canAnimate() && this.bHt > 0;
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
                this.bFL = i;
            }
            if (i >= 0) {
                this.bFg = 4;
                this.bHh = this.bFr.left + i2;
                if (this.bHl) {
                    this.bHi = i;
                    this.bHj = this.mAdapter.getItemId(i);
                }
                if (this.bFF != null) {
                    this.bFF.stop();
                }
                requestLayout();
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView
    public void setSelectionInt(int i) {
        boolean z = true;
        setNextSelectedPositionInt(i);
        int i2 = this.bBx;
        if (i2 < 0 || (i != i2 - 1 && i != i2 + 1)) {
            z = false;
        }
        if (this.bFF != null) {
            this.bFF.stop();
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
        if (!this.bID) {
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
        if (this.mAdapter == null || !this.bGo) {
            return false;
        }
        if (this.afI) {
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
                        z = iq(33);
                        break;
                    }
                    break;
                case 20:
                    if (keyEvent.hasNoModifiers()) {
                        z = iq(TransportMediator.KEYCODE_MEDIA_RECORD);
                        break;
                    }
                    break;
                case 21:
                    if (keyEvent.hasNoModifiers()) {
                        z = WF();
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
                        if (!WF() && !fullScroll(33)) {
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
                        z = WF();
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
                        if (!WF() && !fullScroll(TransportMediator.KEYCODE_MEDIA_RECORD)) {
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
                        z = WF();
                        if (!z && keyEvent.getRepeatCount() == 0 && getChildCount() > 0) {
                            Wv();
                            z = true;
                            break;
                        }
                    }
                    break;
                case 62:
                    if (!keyEvent.hasNoModifiers() ? !keyEvent.hasModifiers(1) || WF() || !pageScroll(33) : WF() || !pageScroll(TransportMediator.KEYCODE_MEDIA_RECORD)) {
                    }
                    z = true;
                    break;
                case a0.f39try /* 92 */:
                    if (keyEvent.hasNoModifiers()) {
                        if (!WF() && !pageScroll(33)) {
                            z = false;
                            break;
                        } else {
                            z = true;
                            break;
                        }
                    } else if (keyEvent.hasModifiers(2)) {
                        if (!WF() && !fullScroll(33)) {
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
                        if (!WF() && !pageScroll(TransportMediator.KEYCODE_MEDIA_RECORD)) {
                            z = false;
                            break;
                        } else {
                            z = true;
                            break;
                        }
                    } else if (keyEvent.hasModifiers(2)) {
                        if (!WF() && !fullScroll(TransportMediator.KEYCODE_MEDIA_RECORD)) {
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
                        if (!WF() && !fullScroll(33)) {
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
                        if (!WF() && !fullScroll(TransportMediator.KEYCODE_MEDIA_RECORD)) {
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
            i2 = Math.max(0, (this.bBx - getChildCount()) - 1);
            z = false;
        } else if (i != 130) {
            i2 = -1;
            z = false;
        } else {
            i2 = Math.min(this.bHt - 1, (this.bBx + getChildCount()) - 1);
            z = true;
        }
        if (i2 < 0 || (k = k(i2, z)) < 0) {
            return false;
        }
        this.bFg = 4;
        this.bHh = getPaddingLeft() + getHorizontalFadingEdgeLength();
        if (z && k > this.bHt - getChildCount()) {
            this.bFg = 3;
        }
        if (!z && k < getChildCount()) {
            this.bFg = 1;
        }
        setSelectionInt(k);
        Wo();
        if (awakenScrollBars()) {
            return true;
        }
        invalidate();
        return true;
    }

    boolean fullScroll(int i) {
        boolean z = true;
        if (i == 33) {
            if (this.bBx != 0) {
                int k = k(0, true);
                if (k >= 0) {
                    this.bFg = 1;
                    setSelectionInt(k);
                    Wo();
                }
            }
            z = false;
        } else {
            if (i == 130 && this.bBx < this.bHt - 1) {
                int k2 = k(this.bHt - 1, true);
                if (k2 >= 0) {
                    this.bFg = 3;
                    setSelectionInt(k2);
                    Wo();
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

    private boolean iq(int i) {
        View selectedView;
        if (i != 33 && i != 130) {
            throw new IllegalArgumentException("direction must be one of {View.FOCUS_UP, View.FOCUS_DOWN}");
        }
        int childCount = getChildCount();
        if (this.bIE && childCount > 0 && this.bBx != -1 && (selectedView = getSelectedView()) != null && selectedView.hasFocus() && (selectedView instanceof ViewGroup)) {
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
            boolean ir = ir(i);
            if (ir) {
                playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
            }
            return ir;
        } finally {
            this.mInLayout = false;
        }
    }

    private boolean ir(int i) {
        View view;
        int i2;
        View view2;
        View focusedChild;
        if (getChildCount() <= 0) {
            return false;
        }
        View selectedView = getSelectedView();
        int i3 = this.bBx;
        int is = is(i);
        int aq = aq(i, is);
        a it = this.bIE ? it(i) : null;
        if (it != null) {
            is = it.VC();
            aq = it.Xn();
        }
        boolean z = it != null;
        if (is != -1) {
            a(selectedView, i, is, it != null);
            setSelectedPositionInt(is);
            setNextSelectedPositionInt(is);
            view = getSelectedView();
            if (this.bIE && it == null && (focusedChild = getFocusedChild()) != null) {
                focusedChild.clearFocus();
            }
            WY();
            z = true;
            i2 = is;
        } else {
            view = selectedView;
            i2 = i3;
        }
        if (aq > 0) {
            iu(i == 33 ? aq : -aq);
            z = true;
        }
        if (this.bIE && it == null && view != null && view.hasFocus()) {
            View findFocus = view.findFocus();
            if (!a(findFocus, this) || ag(findFocus) > 0) {
                findFocus.clearFocus();
            }
        }
        if (is != -1 || view == null || a(view, this)) {
            view2 = view;
        } else {
            WD();
            this.bFL = -1;
            view2 = null;
        }
        if (z) {
            if (view2 != null) {
                c(i2, view2);
                this.bFG = view2.getLeft();
            }
            if (!awakenScrollBars()) {
                invalidate();
            }
            Wo();
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
        int i4 = this.bBx - this.bHg;
        int i5 = i2 - this.bHg;
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
        ad(view);
        if (view.getMeasuredWidth() != width) {
            ae(view);
            int measuredWidth = view.getMeasuredWidth() - width;
            for (int i3 = i + 1; i3 < i2; i3++) {
                getChildAt(i3).offsetLeftAndRight(measuredWidth);
            }
        }
    }

    private void ad(View view) {
        int makeMeasureSpec;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-2, -1);
        }
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(this.bFs, this.bFr.top + this.bFr.bottom, layoutParams.height);
        int i = layoutParams.width;
        if (i > 0) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(makeMeasureSpec, childMeasureSpec);
    }

    private void ae(View view) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i = this.bFr.top;
        int left = view.getLeft();
        view.layout(left, i, measuredWidth + left, measuredHeight + i);
    }

    private int getArrowScrollPreviewLength() {
        return Math.max(2, getHorizontalFadingEdgeLength());
    }

    private int aq(int i, int i2) {
        int width = getWidth() - this.bFr.right;
        int i3 = this.bFr.left;
        int childCount = getChildCount();
        if (i == 130) {
            int i4 = childCount - 1;
            if (i2 != -1) {
                i4 = i2 - this.bHg;
            }
            int i5 = this.bHg + i4;
            View childAt = getChildAt(i4);
            int arrowScrollPreviewLength = i5 < this.bHt + (-1) ? width - getArrowScrollPreviewLength() : width;
            if (childAt.getRight() <= arrowScrollPreviewLength) {
                return 0;
            }
            if (i2 == -1 || arrowScrollPreviewLength - childAt.getLeft() < getMaxScrollAmount()) {
                int right = childAt.getRight() - arrowScrollPreviewLength;
                if (this.bHg + childCount == this.bHt) {
                    right = Math.min(right, getChildAt(childCount - 1).getRight() - width);
                }
                return Math.min(right, getMaxScrollAmount());
            }
            return 0;
        }
        int i6 = i2 != -1 ? i2 - this.bHg : 0;
        int i7 = this.bHg + i6;
        View childAt2 = getChildAt(i6);
        int arrowScrollPreviewLength2 = i7 > 0 ? getArrowScrollPreviewLength() + i3 : i3;
        if (childAt2.getLeft() < arrowScrollPreviewLength2) {
            if (i2 == -1 || childAt2.getRight() - arrowScrollPreviewLength2 < getMaxScrollAmount()) {
                int left = arrowScrollPreviewLength2 - childAt2.getLeft();
                if (this.bHg == 0) {
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
        private int bBx;
        private int bII;

        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }

        void ar(int i, int i2) {
            this.bBx = i;
            this.bII = i2;
        }

        public int VC() {
            return this.bBx;
        }

        public int Xn() {
            return this.bII;
        }
    }

    private int is(int i) {
        int i2 = this.bHg;
        if (i == 130) {
            int i3 = this.bBx != -1 ? this.bBx + 1 : i2;
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
            int childCount2 = this.bBx != -1 ? this.bBx - 1 : (getChildCount() + i2) - 1;
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

    private a it(int i) {
        View findNextFocusFromRect;
        int is;
        View selectedView = getSelectedView();
        if (selectedView != null && selectedView.hasFocus()) {
            findNextFocusFromRect = FocusFinder.getInstance().findNextFocus(this, selectedView.findFocus(), i);
        } else {
            if (i == 130) {
                int arrowScrollPreviewLength = (this.bHg > 0 ? getArrowScrollPreviewLength() : 0) + this.bFr.left;
                if (selectedView != null && selectedView.getLeft() > arrowScrollPreviewLength) {
                    arrowScrollPreviewLength = selectedView.getLeft();
                }
                this.mTempRect.set(arrowScrollPreviewLength, 0, arrowScrollPreviewLength, 0);
            } else {
                int width = (getWidth() - this.bFr.right) - ((this.bHg + getChildCount()) + (-1) < this.bHt ? getArrowScrollPreviewLength() : 0);
                if (selectedView != null && selectedView.getRight() < width) {
                    width = selectedView.getRight();
                }
                this.mTempRect.set(width, 0, width, 0);
            }
            findNextFocusFromRect = FocusFinder.getInstance().findNextFocusFromRect(this, this.mTempRect, i);
        }
        if (findNextFocusFromRect != null) {
            int af = af(findNextFocusFromRect);
            if (this.bBx != -1 && af != this.bBx && (is = is(i)) != -1 && ((i == 130 && is < af) || (i == 33 && is > af))) {
                return null;
            }
            int b2 = b(i, findNextFocusFromRect, af);
            int maxScrollAmount = getMaxScrollAmount();
            if (b2 < maxScrollAmount) {
                findNextFocusFromRect.requestFocus(i);
                this.bIG.ar(af, b2);
                return this.bIG;
            } else if (ag(findNextFocusFromRect) < maxScrollAmount) {
                findNextFocusFromRect.requestFocus(i);
                this.bIG.ar(af, maxScrollAmount);
                return this.bIG;
            }
        }
        return null;
    }

    private int af(View view) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (a(view, getChildAt(i))) {
                return i + this.bHg;
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
            if (this.mTempRect.left >= this.bFr.left) {
                return 0;
            }
            int i3 = this.bFr.left - this.mTempRect.left;
            if (i2 > 0) {
                return i3 + getArrowScrollPreviewLength();
            }
            return i3;
        }
        int width = getWidth() - this.bFr.right;
        if (this.mTempRect.bottom <= width) {
            return 0;
        }
        int i4 = this.mTempRect.right - width;
        if (i2 < this.bHt - 1) {
            return i4 + getArrowScrollPreviewLength();
        }
        return i4;
    }

    private int ag(View view) {
        view.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(view, this.mTempRect);
        int right = (getRight() - getLeft()) - this.bFr.right;
        if (this.mTempRect.right < this.bFr.left) {
            return this.bFr.left - this.mTempRect.right;
        }
        if (this.mTempRect.left <= right) {
            return 0;
        }
        return this.mTempRect.left - right;
    }

    private void iu(int i) {
        int i2;
        hT(i);
        int width = getWidth() - this.bFr.right;
        int i3 = this.bFr.left;
        AbsHListView.k kVar = this.bFm;
        if (i < 0) {
            int childCount = getChildCount();
            View childAt = getChildAt(childCount - 1);
            while (childAt.getRight() < width && (this.bHg + childCount) - 1 < this.bHt - 1) {
                childAt = t(childAt, i2);
                childCount++;
            }
            if (childAt.getBottom() < width) {
                hT(width - childAt.getRight());
            }
            View childAt2 = getChildAt(0);
            while (true) {
                View view = childAt2;
                if (view.getRight() < i3) {
                    if (kVar.hZ(((AbsHListView.f) view.getLayoutParams()).bGB)) {
                        detachViewFromParent(view);
                        kVar.q(view, this.bHg);
                    } else {
                        removeViewInLayout(view);
                    }
                    childAt2 = getChildAt(0);
                    this.bHg++;
                } else {
                    return;
                }
            }
        } else {
            View childAt3 = getChildAt(0);
            while (childAt3.getLeft() > i3 && this.bHg > 0) {
                childAt3 = s(childAt3, this.bHg);
                this.bHg--;
            }
            if (childAt3.getLeft() > i3) {
                hT(i3 - childAt3.getLeft());
            }
            int childCount2 = getChildCount() - 1;
            View childAt4 = getChildAt(childCount2);
            while (true) {
                int i4 = childCount2;
                View view2 = childAt4;
                if (view2.getLeft() > width) {
                    if (kVar.hZ(((AbsHListView.f) view2.getLayoutParams()).bGB)) {
                        detachViewFromParent(view2);
                        kVar.q(view2, this.bHg + i4);
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

    private View s(View view, int i) {
        int i2 = i - 1;
        View b2 = b(i2, this.bGb);
        a(b2, i2, view.getLeft() - this.bIv, false, this.bFr.top, false, this.bGb[0]);
        return b2;
    }

    private View t(View view, int i) {
        int i2 = i + 1;
        View b2 = b(i2, this.bGb);
        a(b2, i2, this.bIv + view.getRight(), true, this.bFr.top, false, this.bGb[0]);
        return b2;
    }

    public void setItemsCanFocus(boolean z) {
        this.bIE = z;
        if (!z) {
            setDescendantFocusability(393216);
        }
    }

    public boolean getItemsCanFocus() {
        return this.bIE;
    }

    @Override // android.view.View
    public boolean isOpaque() {
        boolean z = (this.bFw && this.bIz && this.bIA) || super.isOpaque();
        if (z) {
            int paddingLeft = this.bFr != null ? this.bFr.left : getPaddingLeft();
            View childAt = getChildAt(0);
            if (childAt == null || childAt.getLeft() > paddingLeft) {
                return false;
            }
            int width = getWidth() - (this.bFr != null ? this.bFr.right : getPaddingRight());
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
        this.bIz = z;
        if (z) {
            if (this.bIF == null) {
                this.bIF = new Paint();
            }
            this.bIF.setColor(i);
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
        if (this.bFv) {
            this.bFw = true;
        }
        int i = this.bIv;
        Drawable drawable = this.bIx;
        Drawable drawable2 = this.bIy;
        boolean z = drawable != null;
        boolean z2 = drawable2 != null;
        boolean z3 = i > 0 && this.bIu != null;
        if (z3 || z || z2) {
            Rect rect = this.mTempRect;
            rect.top = getPaddingTop();
            rect.bottom = (getBottom() - getTop()) - getPaddingBottom();
            int childCount = getChildCount();
            int size = this.Ik.size();
            int i2 = this.bHt;
            int size2 = (i2 - this.Il.size()) - 1;
            boolean z4 = this.bIB;
            boolean z5 = this.bIC;
            int i3 = this.bHg;
            boolean z6 = this.bID;
            ListAdapter listAdapter = this.mAdapter;
            boolean z7 = isOpaque() && !super.isOpaque();
            if (z7 && this.bIF == null && this.bIz) {
                this.bIF = new Paint();
                this.bIF.setColor(getCacheColorHint());
            }
            Paint paint = this.bIF;
            int scrollX = getScrollX() + ((getRight() - getLeft()) - 0);
            if (!this.bFH) {
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
        if (this.bFw) {
            this.bFw = false;
        }
        return drawChild;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Canvas canvas, Rect rect, int i) {
        Drawable drawable = this.bIu;
        drawable.setBounds(rect);
        drawable.draw(canvas);
    }

    public Drawable getDivider() {
        return this.bIu;
    }

    public void setDivider(Drawable drawable) {
        boolean z = false;
        if (drawable != null) {
            this.bIv = drawable.getIntrinsicWidth();
        } else {
            this.bIv = 0;
        }
        this.bIu = drawable;
        this.bIA = (drawable == null || drawable.getOpacity() == -1) ? true : true;
        requestLayout();
        invalidate();
    }

    public int getDividerWidth() {
        return this.bIv;
    }

    public void setDividerWidth(int i) {
        this.bIv = i;
        requestLayout();
        invalidate();
    }

    public void setHeaderDividersEnabled(boolean z) {
        this.bIB = z;
        invalidate();
    }

    public void setFooterDividersEnabled(boolean z) {
        this.bIC = z;
        invalidate();
    }

    public void setOverscrollHeader(Drawable drawable) {
        this.bIx = drawable;
        if (getScrollX() < 0) {
            invalidate();
        }
    }

    public Drawable getOverscrollHeader() {
        return this.bIx;
    }

    public void setOverscrollFooter(Drawable drawable) {
        this.bIy = drawable;
        invalidate();
    }

    public Drawable getOverscrollFooter() {
        return this.bIy;
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
            if (listAdapter.getCount() < getChildCount() + this.bHg) {
                this.bFg = 0;
                layoutChildren();
            }
            Rect rect2 = this.mTempRect;
            int i6 = Integer.MAX_VALUE;
            int childCount = getChildCount();
            int i7 = this.bHg;
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
            ap(this.bHg + i5, i4);
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
        if (this.bFa != 0 && this.bFe != null && this.mAdapter != null) {
            SparseArrayCompat<Boolean> sparseArrayCompat = this.bFe;
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
