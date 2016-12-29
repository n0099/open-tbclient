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
import com.baidu.tieba.r;
import java.util.ArrayList;
@RemoteViews.RemoteView
/* loaded from: classes.dex */
public class HListView extends AbsHListView {
    private ArrayList<b> BA;
    private ArrayList<b> Bz;
    Drawable cxa;
    int cxb;
    int cxc;
    Drawable cxd;
    Drawable cxe;
    private boolean cxf;
    private boolean cxg;
    private boolean cxh;
    private boolean cxi;
    private boolean cxj;
    private boolean cxk;
    private Paint cxl;
    private final a cxm;
    private c cxn;
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
        this(context, attributeSet, r.c.hlv_listViewStyle);
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
        this.Bz = new ArrayList<>();
        this.BA = new ArrayList<>();
        this.cxj = true;
        this.cxk = false;
        this.mTempRect = new Rect();
        this.cxm = new a(null);
        this.mGestureDetector = new GestureDetector(new d(this, null));
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, r.l.HListView, i, 0);
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
        this.cxh = z;
        this.cxi = z2;
        this.cxc = i3;
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
    private void akN() {
        int right;
        int i = 0;
        int childCount = getChildCount();
        if (childCount > 0) {
            if (!this.cun) {
                right = getChildAt(0).getLeft() - this.ctW.left;
                if (this.cvM != 0) {
                    right -= this.cxb;
                }
            } else {
                right = getChildAt(childCount - 1).getRight() - (getWidth() - this.ctW.right);
                if (childCount + this.cvM < this.cvZ) {
                    right += this.cxb;
                }
            }
            if (i != 0) {
                jJ(-i);
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
        this.Bz.add(bVar);
        if (this.mAdapter != null && this.ctM != null) {
            this.ctM.onChanged();
        }
    }

    public void addHeaderView(View view) {
        addHeaderView(view, null, true);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView
    public int getHeaderViewsCount() {
        return this.Bz.size();
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView
    public int getFooterViewsCount() {
        return this.BA.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.horizonalList.widget.g
    public ListAdapter getAdapter() {
        return this.mAdapter;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView
    public void setAdapter(ListAdapter listAdapter) {
        int r;
        if (this.mAdapter != null && this.ctM != null) {
            this.mAdapter.unregisterDataSetObserver(this.ctM);
        }
        ajU();
        this.ctR.clear();
        if (this.Bz.size() > 0 || this.BA.size() > 0) {
            this.mAdapter = new m(this.Bz, this.BA, listAdapter);
        } else {
            this.mAdapter = listAdapter;
        }
        this.cwc = -1;
        this.cwd = Long.MIN_VALUE;
        super.setAdapter(listAdapter);
        if (this.mAdapter != null) {
            this.cxj = this.mAdapter.areAllItemsEnabled();
            this.cwa = this.cvZ;
            this.cvZ = this.mAdapter.getCount();
            akw();
            this.ctM = new AbsHListView.a();
            this.mAdapter.registerDataSetObserver(this.ctM);
            this.ctR.jP(this.mAdapter.getViewTypeCount());
            if (this.cun) {
                r = r(this.cvZ - 1, false);
            } else {
                r = r(0, true);
            }
            setSelectedPositionInt(r);
            setNextSelectedPositionInt(r);
            if (this.cvZ == 0) {
                akB();
            }
        } else {
            this.cxj = true;
            akw();
            akB();
        }
        requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView
    public void ajU() {
        P(this.Bz);
        P(this.BA);
        super.ajU();
        this.ctL = 0;
    }

    private void P(ArrayList<b> arrayList) {
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                AbsHListView.f fVar = (AbsHListView.f) arrayList.get(i).view.getLayoutParams();
                if (fVar != null) {
                    fVar.cvi = false;
                }
            }
        }
    }

    private boolean akO() {
        return this.cvM > 0 || getChildAt(0).getLeft() > getScrollX() + this.ctW.left;
    }

    private boolean akP() {
        int childCount = getChildCount();
        return (childCount + this.cvM) + (-1) < this.cvZ + (-1) || getChildAt(childCount + (-1)).getRight() < (getScrollX() + getWidth()) - this.ctW.right;
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
        if (akO() && (this.ccS > 0 || i4 > horizontalFadingEdgeLength)) {
            scrollX += horizontalFadingEdgeLength;
        }
        int right = getChildAt(getChildCount() - 1).getRight();
        if (akP() && (this.ccS < this.cvZ - 1 || rect.right < right - horizontalFadingEdgeLength)) {
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
            kj(-i);
            b(-1, view);
            this.cum = view.getTop();
            invalidate();
        }
        return z2;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView
    protected void fg(boolean z) {
        int childCount = getChildCount();
        if (z) {
            aB(childCount + this.cvM, childCount > 0 ? getChildAt(childCount - 1).getRight() + this.cxb : 0);
            kd(getChildCount());
            return;
        }
        aC(this.cvM - 1, childCount > 0 ? getChildAt(0).getLeft() - this.cxb : getWidth() - 0);
        ke(getChildCount());
    }

    private View aB(int i, int i2) {
        View view = null;
        int right = getRight() - getLeft();
        int i3 = i2;
        int i4 = i;
        while (i3 < right && i4 < this.cvZ) {
            boolean z = i4 == this.ccS;
            View a2 = a(i4, i3, true, this.ctW.top, z);
            i3 = a2.getRight() + this.cxb;
            if (!z) {
                a2 = view;
            }
            i4++;
            view = a2;
        }
        ay(this.cvM, (this.cvM + getChildCount()) - 1);
        return view;
    }

    private View aC(int i, int i2) {
        View view = null;
        int i3 = i2;
        int i4 = i;
        while (i3 > 0 && i4 >= 0) {
            boolean z = i4 == this.ccS;
            View a2 = a(i4, i3, false, this.ctW.top, z);
            i3 = a2.getLeft() - this.cxb;
            if (!z) {
                a2 = view;
            }
            i4--;
            view = a2;
        }
        this.cvM = i4 + 1;
        ay(this.cvM, (this.cvM + getChildCount()) - 1);
        return view;
    }

    private View kc(int i) {
        this.cvM = Math.min(this.cvM, this.ccS);
        this.cvM = Math.min(this.cvM, this.cvZ - 1);
        if (this.cvM < 0) {
            this.cvM = 0;
        }
        return aB(this.cvM, i);
    }

    private View aD(int i, int i2) {
        int i3 = i2 - i;
        int akh = akh();
        View a2 = a(akh, i, true, this.ctW.top, true);
        this.cvM = akh;
        int measuredWidth = a2.getMeasuredWidth();
        if (measuredWidth <= i3) {
            a2.offsetLeftAndRight((i3 - measuredWidth) / 2);
        }
        s(a2, akh);
        if (!this.cun) {
            kd(getChildCount());
        } else {
            ke(getChildCount());
        }
        return a2;
    }

    private void s(View view, int i) {
        int i2 = this.cxb;
        if (!this.cun) {
            aC(i - 1, view.getLeft() - i2);
            akN();
            aB(i + 1, i2 + view.getRight());
            return;
        }
        aB(i + 1, view.getRight() + i2);
        akN();
        aC(i - 1, view.getLeft() - i2);
    }

    private View w(int i, int i2, int i3) {
        int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
        int i4 = this.ccS;
        int y = y(i2, horizontalFadingEdgeLength, i4);
        int x = x(i3, horizontalFadingEdgeLength, i4);
        View a2 = a(i4, i, true, this.ctW.top, true);
        if (a2.getRight() > x) {
            a2.offsetLeftAndRight(-Math.min(a2.getLeft() - y, a2.getRight() - x));
        } else if (a2.getLeft() < y) {
            a2.offsetLeftAndRight(Math.min(y - a2.getLeft(), x - a2.getRight()));
        }
        s(a2, i4);
        if (!this.cun) {
            kd(getChildCount());
        } else {
            ke(getChildCount());
        }
        return a2;
    }

    private int x(int i, int i2, int i3) {
        if (i3 != this.cvZ - 1) {
            return i - i2;
        }
        return i;
    }

    private int y(int i, int i2, int i3) {
        if (i3 > 0) {
            return i + i2;
        }
        return i;
    }

    private View a(View view, View view2, int i, int i2, int i3) {
        View a2;
        int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
        int i4 = this.ccS;
        int y = y(i2, horizontalFadingEdgeLength, i4);
        int x = x(i2, horizontalFadingEdgeLength, i4);
        if (i > 0) {
            View a3 = a(i4 - 1, view.getLeft(), true, this.ctW.top, false);
            int i5 = this.cxb;
            a2 = a(i4, a3.getRight() + i5, true, this.ctW.top, true);
            if (a2.getRight() > x) {
                int min = Math.min(Math.min(a2.getLeft() - y, a2.getRight() - x), (i3 - i2) / 2);
                a3.offsetLeftAndRight(-min);
                a2.offsetLeftAndRight(-min);
            }
            if (!this.cun) {
                aC(this.ccS - 2, a2.getLeft() - i5);
                akN();
                aB(this.ccS + 1, a2.getRight() + i5);
            } else {
                aB(this.ccS + 1, a2.getRight() + i5);
                akN();
                aC(this.ccS - 2, a2.getLeft() - i5);
            }
        } else if (i < 0) {
            if (view2 != null) {
                a2 = a(i4, view2.getLeft(), true, this.ctW.top, true);
            } else {
                a2 = a(i4, view.getLeft(), false, this.ctW.top, true);
            }
            if (a2.getLeft() < y) {
                a2.offsetLeftAndRight(Math.min(Math.min(y - a2.getLeft(), x - a2.getRight()), (i3 - i2) / 2));
            }
            s(a2, i4);
        } else {
            int left = view.getLeft();
            a2 = a(i4, left, true, this.ctW.top, true);
            if (left < i2 && a2.getRight() < i2 + 20) {
                a2.offsetLeftAndRight(i2 - a2.getLeft());
            }
            s(a2, i4);
        }
        return a2;
    }

    /* loaded from: classes.dex */
    private class c implements Runnable {
        private int aoG;
        private int cxp;

        private c() {
        }

        /* synthetic */ c(HListView hListView, c cVar) {
            this();
        }

        public c aI(int i, int i2) {
            this.aoG = i;
            this.cxp = i2;
            return this;
        }

        @Override // java.lang.Runnable
        public void run() {
            HListView.this.aF(this.aoG, this.cxp);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        View focusedChild;
        if (getChildCount() > 0 && (focusedChild = getFocusedChild()) != null) {
            int indexOfChild = this.cvM + indexOfChild(focusedChild);
            int left = focusedChild.getLeft() - Math.max(0, focusedChild.getRight() - (i - getPaddingLeft()));
            if (this.cxn == null) {
                this.cxn = new c(this, null);
            }
            post(this.cxn.aI(indexOfChild, left));
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
        this.cvZ = this.mAdapter == null ? 0 : this.mAdapter.getCount();
        if (this.cvZ > 0 && (mode == 0 || mode2 == 0)) {
            View b2 = b(0, this.cuH);
            g(b2, 0, i2);
            i4 = b2.getMeasuredWidth();
            i5 = b2.getMeasuredHeight();
            r1 = Build.VERSION.SDK_INT >= 11 ? combineMeasuredStates(0, b2.getMeasuredState()) : 0;
            if (akQ() && this.ctR.jQ(((AbsHListView.f) b2.getLayoutParams()).cvh)) {
                this.ctR.r(b2, -1);
            }
        }
        int i6 = i5;
        int i7 = i4;
        if (mode2 == 0) {
            i3 = i6 + this.ctW.top + this.ctW.bottom + getHorizontalScrollbarHeight();
        } else if (mode2 == Integer.MIN_VALUE && this.cvZ > 0 && this.cxc > -1) {
            i3 = d(i2, this.cxc, this.cxc, size, size2, -1)[1];
        } else {
            i3 = Build.VERSION.SDK_INT >= 11 ? size2 | ((-16777216) & r1) : size2;
        }
        if (mode == 0) {
            size = this.ctW.left + this.ctW.right + i7 + (getHorizontalFadingEdgeLength() * 2);
        }
        if (mode == Integer.MIN_VALUE) {
            size = d(i2, 0, -1, size, -1);
        }
        setMeasuredDimension(size, i3);
        this.ctX = i2;
    }

    private void g(View view, int i, int i2) {
        int makeMeasureSpec;
        AbsHListView.f fVar = (AbsHListView.f) view.getLayoutParams();
        if (fVar == null) {
            fVar = (AbsHListView.f) generateDefaultLayoutParams();
            view.setLayoutParams(fVar);
        }
        fVar.cvh = this.mAdapter.getItemViewType(i);
        fVar.cvj = true;
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, this.ctW.top + this.ctW.bottom, fVar.height);
        int i3 = fVar.width;
        if (i3 > 0) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(makeMeasureSpec, childMeasureSpec);
    }

    @ViewDebug.ExportedProperty(category = IntentConfig.LIST)
    protected boolean akQ() {
        return true;
    }

    final int d(int i, int i2, int i3, int i4, int i5) {
        int i6 = 0;
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter == null) {
            return this.ctW.left + this.ctW.right;
        }
        int i7 = this.ctW.left + this.ctW.right;
        int i8 = (this.cxb <= 0 || this.cxa == null) ? 0 : this.cxb;
        if (i3 == -1) {
            i3 = listAdapter.getCount() - 1;
        }
        AbsHListView.k kVar = this.ctR;
        boolean akQ = akQ();
        boolean[] zArr = this.cuH;
        while (i2 <= i3) {
            View b2 = b(i2, zArr);
            g(b2, i2, i);
            int i9 = i2 > 0 ? i7 + i8 : i7;
            if (akQ && kVar.jQ(((AbsHListView.f) b2.getLayoutParams()).cvh)) {
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
            return new int[]{this.ctW.left + this.ctW.right, this.ctW.top + this.ctW.bottom};
        }
        int i7 = this.ctW.left + this.ctW.right;
        int i8 = this.ctW.top + this.ctW.bottom;
        int i9 = (this.cxb <= 0 || this.cxa == null) ? 0 : this.cxb;
        if (i3 == -1) {
            i3 = listAdapter.getCount() - 1;
        }
        AbsHListView.k kVar = this.ctR;
        boolean akQ = akQ();
        boolean[] zArr = this.cuH;
        int i10 = 0;
        int i11 = 0;
        while (i2 <= i3) {
            View b2 = b(i2, zArr);
            g(b2, i2, i);
            if (akQ && kVar.jQ(((AbsHListView.f) b2.getLayoutParams()).cvh)) {
                kVar.r(b2, -1);
            }
            i10 = Math.max(i10, b2.getMeasuredWidth() + i9);
            i2++;
            i11 = Math.max(i11, b2.getMeasuredHeight());
        }
        return new int[]{Math.min(i10 + i7, i4), Math.min(i11 + i8, i5)};
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView
    protected int jK(int i) {
        int childCount = getChildCount();
        if (childCount > 0) {
            if (this.cun) {
                for (int i2 = childCount - 1; i2 >= 0; i2--) {
                    if (i >= getChildAt(i2).getLeft()) {
                        return i2 + this.cvM;
                    }
                }
            } else {
                for (int i3 = 0; i3 < childCount; i3++) {
                    if (i <= getChildAt(i3).getRight()) {
                        return i3 + this.cvM;
                    }
                }
            }
        }
        return -1;
    }

    private View aE(int i, int i2) {
        View aB;
        View aC;
        boolean z = i == this.ccS;
        View a2 = a(i, i2, true, this.ctW.top, z);
        this.cvM = i;
        int i3 = this.cxb;
        if (!this.cun) {
            aC = aC(i - 1, a2.getLeft() - i3);
            akN();
            aB = aB(i + 1, i3 + a2.getRight());
            int childCount = getChildCount();
            if (childCount > 0) {
                kd(childCount);
            }
        } else {
            aB = aB(i + 1, a2.getRight() + i3);
            akN();
            aC = aC(i - 1, a2.getLeft() - i3);
            int childCount2 = getChildCount();
            if (childCount2 > 0) {
                ke(childCount2);
            }
        }
        if (z) {
            return a2;
        }
        return aC != null ? aC : aB;
    }

    private void kd(int i) {
        if ((this.cvM + i) - 1 == this.cvZ - 1 && i > 0) {
            int right = ((getRight() - getLeft()) - this.ctW.right) - getChildAt(i - 1).getRight();
            View childAt = getChildAt(0);
            int left = childAt.getLeft();
            if (right > 0) {
                if (this.cvM > 0 || left < this.ctW.top) {
                    if (this.cvM == 0) {
                        right = Math.min(right, this.ctW.top - left);
                    }
                    jJ(right);
                    if (this.cvM > 0) {
                        aC(this.cvM - 1, childAt.getLeft() - this.cxb);
                        akN();
                    }
                }
            }
        }
    }

    private void ke(int i) {
        if (this.cvM == 0 && i > 0) {
            int left = getChildAt(0).getLeft();
            int i2 = this.ctW.left;
            int right = (getRight() - getLeft()) - this.ctW.right;
            int i3 = left - i2;
            View childAt = getChildAt(i - 1);
            int right2 = childAt.getRight();
            int i4 = (this.cvM + i) - 1;
            if (i3 > 0) {
                if (i4 < this.cvZ - 1 || right2 > right) {
                    if (i4 == this.cvZ - 1) {
                        i3 = Math.min(i3, right2 - right);
                    }
                    jJ(-i3);
                    if (i4 < this.cvZ - 1) {
                        aB(i4 + 1, childAt.getRight() + this.cxb);
                        akN();
                    }
                } else if (i4 == this.cvZ - 1) {
                    akN();
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
        boolean z = this.cwh;
        if (z) {
            return;
        }
        this.cwh = true;
        try {
            super.layoutChildren();
            invalidate();
            if (this.mAdapter == null) {
                ajU();
                ajR();
                if (z) {
                    return;
                }
                return;
            }
            int i = this.ctW.left;
            int right = (getRight() - getLeft()) - this.ctW.right;
            int childCount = getChildCount();
            View view4 = null;
            View view5 = null;
            View view6 = null;
            switch (this.ctL) {
                case 1:
                case 3:
                case 4:
                case 5:
                    view = null;
                    break;
                case 2:
                    int i2 = this.cvW - this.cvM;
                    if (i2 < 0 || i2 >= childCount) {
                        view = null;
                        break;
                    } else {
                        view5 = getChildAt(i2);
                        view = null;
                        break;
                    }
                default:
                    int i3 = this.ccS - this.cvM;
                    if (i3 >= 0 && i3 < childCount) {
                        view4 = getChildAt(i3);
                    }
                    View childAt = getChildAt(0);
                    r4 = this.cvW >= 0 ? this.cvW - this.ccS : 0;
                    view5 = getChildAt(i3 + r4);
                    view = childAt;
                    break;
            }
            boolean z2 = this.aeC;
            if (z2) {
                handleDataChanged();
            }
            if (this.cvZ == 0) {
                ajU();
                ajR();
                if (z) {
                    return;
                }
                this.cwh = false;
            } else if (this.cvZ != this.mAdapter.getCount()) {
                throw new IllegalStateException("The content of the adapter has changed but ListView did not receive a notification. Make sure the content of your adapter is not modified from a background thread, but only from the UI thread. [in ListView(" + getId() + ", " + getClass() + ") with Adapter(" + this.mAdapter.getClass() + ")]");
            } else {
                setSelectedPositionInt(this.cvW);
                int i4 = this.cvM;
                AbsHListView.k kVar = this.ctR;
                View view7 = null;
                if (z2) {
                    for (int i5 = 0; i5 < childCount; i5++) {
                        kVar.r(getChildAt(i5), i4 + i5);
                    }
                } else {
                    kVar.aA(childCount, i4);
                }
                View focusedChild = getFocusedChild();
                if (focusedChild != null) {
                    if (!z2 || av(focusedChild)) {
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
                kVar.akr();
                switch (this.ctL) {
                    case 1:
                        this.cvM = 0;
                        View kc = kc(i);
                        akN();
                        a2 = kc;
                        break;
                    case 2:
                        if (view5 != null) {
                            a2 = w(view5.getLeft(), i, right);
                            break;
                        } else {
                            a2 = aD(i, right);
                            break;
                        }
                    case 3:
                        View aC = aC(this.cvZ - 1, right);
                        akN();
                        a2 = aC;
                        break;
                    case 4:
                        a2 = aE(akh(), this.cvN);
                        break;
                    case 5:
                        a2 = aE(this.cvO, this.cvN);
                        break;
                    case 6:
                        a2 = a(view4, view5, r4, i, right);
                        break;
                    default:
                        if (childCount == 0) {
                            if (this.cun) {
                                setSelectedPositionInt(r(this.cvZ - 1, false));
                                a2 = aC(this.cvZ - 1, right);
                                break;
                            } else {
                                setSelectedPositionInt(r(0, true));
                                a2 = kc(i);
                                break;
                            }
                        } else if (this.ccS < 0 || this.ccS >= this.cvZ) {
                            if (this.cvM < this.cvZ) {
                                int i6 = this.cvM;
                                if (view != null) {
                                    i = view.getLeft();
                                }
                                a2 = aE(i6, i);
                                break;
                            } else {
                                a2 = aE(0, i);
                                break;
                            }
                        } else {
                            int i7 = this.ccS;
                            if (view4 != null) {
                                i = view4.getLeft();
                            }
                            a2 = aE(i7, i);
                            break;
                        }
                }
                kVar.aks();
                if (a2 != null) {
                    if (!this.cxk || !hasFocus() || a2.hasFocus()) {
                        b(-1, a2);
                    } else if ((a2 == view3 && view2 != null && view2.requestFocus()) || a2.requestFocus()) {
                        a2.setSelected(false);
                        this.ctQ.setEmpty();
                    } else {
                        View focusedChild2 = getFocusedChild();
                        if (focusedChild2 != null) {
                            focusedChild2.clearFocus();
                        }
                        b(-1, a2);
                    }
                    this.cum = a2.getLeft();
                } else {
                    if (this.cuh <= 0 || this.cuh >= 3) {
                        this.cum = 0;
                        this.ctQ.setEmpty();
                    } else {
                        View childAt2 = getChildAt(this.cuc - this.cvM);
                        if (childAt2 != null) {
                            b(this.cuc, childAt2);
                        }
                    }
                    if (hasFocus() && view2 != null) {
                        view2.requestFocus();
                    }
                }
                if (view2 != null && view2.getWindowToken() != null) {
                    view2.onFinishTemporaryDetach();
                }
                this.ctL = 0;
                this.aeC = false;
                if (this.cuF != null) {
                    post(this.cuF);
                    this.cuF = null;
                }
                this.cvR = false;
                setNextSelectedPositionInt(this.ccS);
                ajV();
                if (this.cvZ > 0) {
                    akB();
                }
                ajR();
                if (z) {
                    return;
                }
                this.cwh = false;
            }
        } finally {
            if (!z) {
                this.cwh = false;
            }
        }
    }

    private boolean av(View view) {
        ArrayList<b> arrayList = this.Bz;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (view == arrayList.get(i).view) {
                return true;
            }
        }
        ArrayList<b> arrayList2 = this.BA;
        int size2 = arrayList2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            if (view == arrayList2.get(i2).view) {
                return true;
            }
        }
        return false;
    }

    private View a(int i, int i2, boolean z, int i3, boolean z2) {
        View jR;
        if (!this.aeC && (jR = this.ctR.jR(i)) != null) {
            a(jR, i, i2, z, i3, z2, true);
            return jR;
        }
        View b2 = b(i, this.cuH);
        a(b2, i, i2, z, i3, z2, this.cuH[0]);
        return b2;
    }

    private void a(View view, int i, int i2, boolean z, int i3, boolean z2, boolean z3) {
        int makeMeasureSpec;
        boolean z4 = z2 && ajX();
        boolean isSelected = z4 ^ view.isSelected();
        int i4 = this.cuh;
        boolean z5 = i4 > 0 && i4 < 3 && this.cuc == i;
        boolean isPressed = z5 ^ view.isPressed();
        boolean z6 = !z3 || isSelected || view.isLayoutRequested();
        AbsHListView.f fVar = (AbsHListView.f) view.getLayoutParams();
        AbsHListView.f fVar2 = fVar == null ? (AbsHListView.f) generateDefaultLayoutParams() : fVar;
        fVar2.cvh = this.mAdapter.getItemViewType(i);
        if ((z3 && !fVar2.cvj) || (fVar2.cvi && fVar2.cvh == -2)) {
            attachViewToParent(view, z ? -1 : 0, fVar2);
        } else {
            fVar2.cvj = false;
            if (fVar2.cvh == -2) {
                fVar2.cvi = true;
            }
            addViewInLayout(view, z ? -1 : 0, fVar2, true);
        }
        if (isSelected) {
            view.setSelected(z4);
        }
        if (isPressed) {
            view.setPressed(z5);
        }
        if (this.ctF != 0 && this.ctJ != null) {
            if (view instanceof Checkable) {
                ((Checkable) view).setChecked(this.ctJ.get(i, false).booleanValue());
            } else if (Build.VERSION.SDK_INT >= 11) {
                view.setActivated(this.ctJ.get(i, false).booleanValue());
            }
        }
        if (z6) {
            int childMeasureSpec = ViewGroup.getChildMeasureSpec(this.ctX, this.ctW.top + this.ctW.bottom, fVar2.height);
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
        if (this.cua && !view.isDrawingCacheEnabled()) {
            view.setDrawingCacheEnabled(true);
        }
        if (Build.VERSION.SDK_INT >= 11 && z3 && ((AbsHListView.f) view.getLayoutParams()).cvk != i) {
            view.jumpDrawablesToCurrentState();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.g, android.view.ViewGroup
    public boolean canAnimate() {
        return super.canAnimate() && this.cvZ > 0;
    }

    @Override // com.baidu.tieba.horizonalList.widget.g
    public void setSelection(int i) {
        aF(i, 0);
    }

    public void aF(int i, int i2) {
        if (this.mAdapter != null) {
            if (!isInTouchMode()) {
                i = r(i, true);
                if (i >= 0) {
                    setNextSelectedPositionInt(i);
                }
            } else {
                this.cur = i;
            }
            if (i >= 0) {
                this.ctL = 4;
                this.cvN = this.ctW.left + i2;
                if (this.cvR) {
                    this.cvO = i;
                    this.cvP = this.mAdapter.getItemId(i);
                }
                if (this.cul != null) {
                    this.cul.stop();
                }
                requestLayout();
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView
    public void setSelectionInt(int i) {
        boolean z = true;
        setNextSelectedPositionInt(i);
        int i2 = this.ccS;
        if (i2 < 0 || (i != i2 - 1 && i != i2 + 1)) {
            z = false;
        }
        if (this.cul != null) {
            this.cul.stop();
        }
        layoutChildren();
        if (z) {
            awakenScrollBars();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.g
    public int r(int i, boolean z) {
        int min;
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter == null || isInTouchMode()) {
            return -1;
        }
        int count = listAdapter.getCount();
        if (!this.cxj) {
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
        if (this.mAdapter == null || !this.cuU) {
            return false;
        }
        if (this.aeC) {
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
                        z = kf(33);
                        break;
                    }
                    break;
                case 20:
                    if (keyEvent.hasNoModifiers()) {
                        z = kf(TransportMediator.KEYCODE_MEDIA_RECORD);
                        break;
                    }
                    break;
                case 21:
                    if (keyEvent.hasNoModifiers()) {
                        z = aki();
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
                        if (!aki() && !fullScroll(33)) {
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
                        z = aki();
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
                        if (!aki() && !fullScroll(TransportMediator.KEYCODE_MEDIA_RECORD)) {
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
                        z = aki();
                        if (!z && keyEvent.getRepeatCount() == 0 && getChildCount() > 0) {
                            ajY();
                            z = true;
                            break;
                        }
                    }
                    break;
                case BDLocation.TypeCriteriaException /* 62 */:
                    if (!keyEvent.hasNoModifiers() ? !keyEvent.hasModifiers(1) || aki() || !pageScroll(33) : aki() || !pageScroll(TransportMediator.KEYCODE_MEDIA_RECORD)) {
                    }
                    z = true;
                    break;
                case 92:
                    if (keyEvent.hasNoModifiers()) {
                        if (!aki() && !pageScroll(33)) {
                            z = false;
                            break;
                        } else {
                            z = true;
                            break;
                        }
                    } else if (keyEvent.hasModifiers(2)) {
                        if (!aki() && !fullScroll(33)) {
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
                        if (!aki() && !pageScroll(TransportMediator.KEYCODE_MEDIA_RECORD)) {
                            z = false;
                            break;
                        } else {
                            z = true;
                            break;
                        }
                    } else if (keyEvent.hasModifiers(2)) {
                        if (!aki() && !fullScroll(TransportMediator.KEYCODE_MEDIA_RECORD)) {
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
                        if (!aki() && !fullScroll(33)) {
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
                        if (!aki() && !fullScroll(TransportMediator.KEYCODE_MEDIA_RECORD)) {
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
        int r;
        if (i == 33) {
            i2 = Math.max(0, (this.ccS - getChildCount()) - 1);
            z = false;
        } else if (i != 130) {
            i2 = -1;
            z = false;
        } else {
            i2 = Math.min(this.cvZ - 1, (this.ccS + getChildCount()) - 1);
            z = true;
        }
        if (i2 < 0 || (r = r(i2, z)) < 0) {
            return false;
        }
        this.ctL = 4;
        this.cvN = getPaddingLeft() + getHorizontalFadingEdgeLength();
        if (z && r > this.cvZ - getChildCount()) {
            this.ctL = 3;
        }
        if (!z && r < getChildCount()) {
            this.ctL = 1;
        }
        setSelectionInt(r);
        ajR();
        if (awakenScrollBars()) {
            return true;
        }
        invalidate();
        return true;
    }

    boolean fullScroll(int i) {
        boolean z = true;
        if (i == 33) {
            if (this.ccS != 0) {
                int r = r(0, true);
                if (r >= 0) {
                    this.ctL = 1;
                    setSelectionInt(r);
                    ajR();
                }
            }
            z = false;
        } else {
            if (i == 130 && this.ccS < this.cvZ - 1) {
                int r2 = r(this.cvZ - 1, true);
                if (r2 >= 0) {
                    this.ctL = 3;
                    setSelectionInt(r2);
                    ajR();
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

    private boolean kf(int i) {
        View selectedView;
        if (i != 33 && i != 130) {
            throw new IllegalArgumentException("direction must be one of {View.FOCUS_UP, View.FOCUS_DOWN}");
        }
        int childCount = getChildCount();
        if (this.cxk && childCount > 0 && this.ccS != -1 && (selectedView = getSelectedView()) != null && selectedView.hasFocus() && (selectedView instanceof ViewGroup)) {
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
            boolean kg = kg(i);
            if (kg) {
                playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
            }
            return kg;
        } finally {
            this.mInLayout = false;
        }
    }

    private boolean kg(int i) {
        View view;
        int i2;
        View view2;
        View focusedChild;
        if (getChildCount() <= 0) {
            return false;
        }
        View selectedView = getSelectedView();
        int i3 = this.ccS;
        int kh = kh(i);
        int aG = aG(i, kh);
        a ki = this.cxk ? ki(i) : null;
        if (ki != null) {
            kh = ki.afD();
            aG = ki.akR();
        }
        boolean z = ki != null;
        if (kh != -1) {
            a(selectedView, i, kh, ki != null);
            setSelectedPositionInt(kh);
            setNextSelectedPositionInt(kh);
            view = getSelectedView();
            if (this.cxk && ki == null && (focusedChild = getFocusedChild()) != null) {
                focusedChild.clearFocus();
            }
            akB();
            z = true;
            i2 = kh;
        } else {
            view = selectedView;
            i2 = i3;
        }
        if (aG > 0) {
            kj(i == 33 ? aG : -aG);
            z = true;
        }
        if (this.cxk && ki == null && view != null && view.hasFocus()) {
            View findFocus = view.findFocus();
            if (!a(findFocus, this) || az(findFocus) > 0) {
                findFocus.clearFocus();
            }
        }
        if (kh != -1 || view == null || a(view, this)) {
            view2 = view;
        } else {
            akg();
            this.cur = -1;
            view2 = null;
        }
        if (z) {
            if (view2 != null) {
                b(i2, view2);
                this.cum = view2.getLeft();
            }
            if (!awakenScrollBars()) {
                invalidate();
            }
            ajR();
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
        int i4 = this.ccS - this.cvM;
        int i5 = i2 - this.cvM;
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
        aw(view);
        if (view.getMeasuredWidth() != width) {
            ax(view);
            int measuredWidth = view.getMeasuredWidth() - width;
            for (int i3 = i + 1; i3 < i2; i3++) {
                getChildAt(i3).offsetLeftAndRight(measuredWidth);
            }
        }
    }

    private void aw(View view) {
        int makeMeasureSpec;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-2, -1);
        }
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(this.ctX, this.ctW.top + this.ctW.bottom, layoutParams.height);
        int i = layoutParams.width;
        if (i > 0) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(makeMeasureSpec, childMeasureSpec);
    }

    private void ax(View view) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i = this.ctW.top;
        int left = view.getLeft();
        view.layout(left, i, measuredWidth + left, measuredHeight + i);
    }

    private int getArrowScrollPreviewLength() {
        return Math.max(2, getHorizontalFadingEdgeLength());
    }

    private int aG(int i, int i2) {
        int width = getWidth() - this.ctW.right;
        int i3 = this.ctW.left;
        int childCount = getChildCount();
        if (i == 130) {
            int i4 = childCount - 1;
            if (i2 != -1) {
                i4 = i2 - this.cvM;
            }
            int i5 = this.cvM + i4;
            View childAt = getChildAt(i4);
            int arrowScrollPreviewLength = i5 < this.cvZ + (-1) ? width - getArrowScrollPreviewLength() : width;
            if (childAt.getRight() <= arrowScrollPreviewLength) {
                return 0;
            }
            if (i2 == -1 || arrowScrollPreviewLength - childAt.getLeft() < getMaxScrollAmount()) {
                int right = childAt.getRight() - arrowScrollPreviewLength;
                if (this.cvM + childCount == this.cvZ) {
                    right = Math.min(right, getChildAt(childCount - 1).getRight() - width);
                }
                return Math.min(right, getMaxScrollAmount());
            }
            return 0;
        }
        int i6 = i2 != -1 ? i2 - this.cvM : 0;
        int i7 = this.cvM + i6;
        View childAt2 = getChildAt(i6);
        int arrowScrollPreviewLength2 = i7 > 0 ? getArrowScrollPreviewLength() + i3 : i3;
        if (childAt2.getLeft() < arrowScrollPreviewLength2) {
            if (i2 == -1 || childAt2.getRight() - arrowScrollPreviewLength2 < getMaxScrollAmount()) {
                int left = arrowScrollPreviewLength2 - childAt2.getLeft();
                if (this.cvM == 0) {
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
        private int ccS;
        private int cxo;

        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }

        void aH(int i, int i2) {
            this.ccS = i;
            this.cxo = i2;
        }

        public int afD() {
            return this.ccS;
        }

        public int akR() {
            return this.cxo;
        }
    }

    private int kh(int i) {
        int i2 = this.cvM;
        if (i == 130) {
            int i3 = this.ccS != -1 ? this.ccS + 1 : i2;
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
            int childCount2 = this.ccS != -1 ? this.ccS - 1 : (getChildCount() + i2) - 1;
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

    private a ki(int i) {
        View findNextFocusFromRect;
        int kh;
        View selectedView = getSelectedView();
        if (selectedView != null && selectedView.hasFocus()) {
            findNextFocusFromRect = FocusFinder.getInstance().findNextFocus(this, selectedView.findFocus(), i);
        } else {
            if (i == 130) {
                int arrowScrollPreviewLength = (this.cvM > 0 ? getArrowScrollPreviewLength() : 0) + this.ctW.left;
                if (selectedView != null && selectedView.getLeft() > arrowScrollPreviewLength) {
                    arrowScrollPreviewLength = selectedView.getLeft();
                }
                this.mTempRect.set(arrowScrollPreviewLength, 0, arrowScrollPreviewLength, 0);
            } else {
                int width = (getWidth() - this.ctW.right) - ((this.cvM + getChildCount()) + (-1) < this.cvZ ? getArrowScrollPreviewLength() : 0);
                if (selectedView != null && selectedView.getRight() < width) {
                    width = selectedView.getRight();
                }
                this.mTempRect.set(width, 0, width, 0);
            }
            findNextFocusFromRect = FocusFinder.getInstance().findNextFocusFromRect(this, this.mTempRect, i);
        }
        if (findNextFocusFromRect != null) {
            int ay = ay(findNextFocusFromRect);
            if (this.ccS != -1 && ay != this.ccS && (kh = kh(i)) != -1 && ((i == 130 && kh < ay) || (i == 33 && kh > ay))) {
                return null;
            }
            int a2 = a(i, findNextFocusFromRect, ay);
            int maxScrollAmount = getMaxScrollAmount();
            if (a2 < maxScrollAmount) {
                findNextFocusFromRect.requestFocus(i);
                this.cxm.aH(ay, a2);
                return this.cxm;
            } else if (az(findNextFocusFromRect) < maxScrollAmount) {
                findNextFocusFromRect.requestFocus(i);
                this.cxm.aH(ay, maxScrollAmount);
                return this.cxm;
            }
        }
        return null;
    }

    private int ay(View view) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (a(view, getChildAt(i))) {
                return i + this.cvM;
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
            if (this.mTempRect.left >= this.ctW.left) {
                return 0;
            }
            int i3 = this.ctW.left - this.mTempRect.left;
            if (i2 > 0) {
                return i3 + getArrowScrollPreviewLength();
            }
            return i3;
        }
        int width = getWidth() - this.ctW.right;
        if (this.mTempRect.bottom <= width) {
            return 0;
        }
        int i4 = this.mTempRect.right - width;
        if (i2 < this.cvZ - 1) {
            return i4 + getArrowScrollPreviewLength();
        }
        return i4;
    }

    private int az(View view) {
        view.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(view, this.mTempRect);
        int right = (getRight() - getLeft()) - this.ctW.right;
        if (this.mTempRect.right < this.ctW.left) {
            return this.ctW.left - this.mTempRect.right;
        }
        if (this.mTempRect.left <= right) {
            return 0;
        }
        return this.mTempRect.left - right;
    }

    private void kj(int i) {
        int i2;
        jJ(i);
        int width = getWidth() - this.ctW.right;
        int i3 = this.ctW.left;
        AbsHListView.k kVar = this.ctR;
        if (i < 0) {
            int childCount = getChildCount();
            View childAt = getChildAt(childCount - 1);
            while (childAt.getRight() < width && (this.cvM + childCount) - 1 < this.cvZ - 1) {
                childAt = u(childAt, i2);
                childCount++;
            }
            if (childAt.getBottom() < width) {
                jJ(width - childAt.getRight());
            }
            View childAt2 = getChildAt(0);
            while (true) {
                View view = childAt2;
                if (view.getRight() < i3) {
                    if (kVar.jQ(((AbsHListView.f) view.getLayoutParams()).cvh)) {
                        detachViewFromParent(view);
                        kVar.r(view, this.cvM);
                    } else {
                        removeViewInLayout(view);
                    }
                    childAt2 = getChildAt(0);
                    this.cvM++;
                } else {
                    return;
                }
            }
        } else {
            View childAt3 = getChildAt(0);
            while (childAt3.getLeft() > i3 && this.cvM > 0) {
                childAt3 = t(childAt3, this.cvM);
                this.cvM--;
            }
            if (childAt3.getLeft() > i3) {
                jJ(i3 - childAt3.getLeft());
            }
            int childCount2 = getChildCount() - 1;
            View childAt4 = getChildAt(childCount2);
            while (true) {
                int i4 = childCount2;
                View view2 = childAt4;
                if (view2.getLeft() > width) {
                    if (kVar.jQ(((AbsHListView.f) view2.getLayoutParams()).cvh)) {
                        detachViewFromParent(view2);
                        kVar.r(view2, this.cvM + i4);
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
        View b2 = b(i2, this.cuH);
        a(b2, i2, view.getLeft() - this.cxb, false, this.ctW.top, false, this.cuH[0]);
        return b2;
    }

    private View u(View view, int i) {
        int i2 = i + 1;
        View b2 = b(i2, this.cuH);
        a(b2, i2, this.cxb + view.getRight(), true, this.ctW.top, false, this.cuH[0]);
        return b2;
    }

    public void setItemsCanFocus(boolean z) {
        this.cxk = z;
        if (!z) {
            setDescendantFocusability(393216);
        }
    }

    public boolean getItemsCanFocus() {
        return this.cxk;
    }

    @Override // android.view.View
    public boolean isOpaque() {
        boolean z = (this.cub && this.cxf && this.cxg) || super.isOpaque();
        if (z) {
            int paddingLeft = this.ctW != null ? this.ctW.left : getPaddingLeft();
            View childAt = getChildAt(0);
            if (childAt == null || childAt.getLeft() > paddingLeft) {
                return false;
            }
            int width = getWidth() - (this.ctW != null ? this.ctW.right : getPaddingRight());
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
        this.cxf = z;
        if (z) {
            if (this.cxl == null) {
                this.cxl = new Paint();
            }
            this.cxl.setColor(i);
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
        if (this.cua) {
            this.cub = true;
        }
        int i = this.cxb;
        Drawable drawable = this.cxd;
        Drawable drawable2 = this.cxe;
        boolean z = drawable != null;
        boolean z2 = drawable2 != null;
        boolean z3 = i > 0 && this.cxa != null;
        if (z3 || z || z2) {
            Rect rect = this.mTempRect;
            rect.top = getPaddingTop();
            rect.bottom = (getBottom() - getTop()) - getPaddingBottom();
            int childCount = getChildCount();
            int size = this.Bz.size();
            int i2 = this.cvZ;
            int size2 = (i2 - this.BA.size()) - 1;
            boolean z4 = this.cxh;
            boolean z5 = this.cxi;
            int i3 = this.cvM;
            boolean z6 = this.cxj;
            ListAdapter listAdapter = this.mAdapter;
            boolean z7 = isOpaque() && !super.isOpaque();
            if (z7 && this.cxl == null && this.cxf) {
                this.cxl = new Paint();
                this.cxl.setColor(getCacheColorHint());
            }
            Paint paint = this.cxl;
            int scrollX = getScrollX() + ((getRight() - getLeft()) - 0);
            if (!this.cun) {
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
        if (this.cub) {
            this.cub = false;
        }
        return drawChild;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Canvas canvas, Rect rect, int i) {
        Drawable drawable = this.cxa;
        drawable.setBounds(rect);
        drawable.draw(canvas);
    }

    public Drawable getDivider() {
        return this.cxa;
    }

    public void setDivider(Drawable drawable) {
        boolean z = false;
        if (drawable != null) {
            this.cxb = drawable.getIntrinsicWidth();
        } else {
            this.cxb = 0;
        }
        this.cxa = drawable;
        this.cxg = (drawable == null || drawable.getOpacity() == -1) ? true : true;
        requestLayout();
        invalidate();
    }

    public int getDividerWidth() {
        return this.cxb;
    }

    public void setDividerWidth(int i) {
        this.cxb = i;
        requestLayout();
        invalidate();
    }

    public void setHeaderDividersEnabled(boolean z) {
        this.cxh = z;
        invalidate();
    }

    public void setFooterDividersEnabled(boolean z) {
        this.cxi = z;
        invalidate();
    }

    public void setOverscrollHeader(Drawable drawable) {
        this.cxd = drawable;
        if (getScrollX() < 0) {
            invalidate();
        }
    }

    public Drawable getOverscrollHeader() {
        return this.cxd;
    }

    public void setOverscrollFooter(Drawable drawable) {
        this.cxe = drawable;
        invalidate();
    }

    public Drawable getOverscrollFooter() {
        return this.cxe;
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
            if (listAdapter.getCount() < getChildCount() + this.cvM) {
                this.ctL = 0;
                layoutChildren();
            }
            Rect rect2 = this.mTempRect;
            int i6 = Integer.MAX_VALUE;
            int childCount = getChildCount();
            int i7 = this.cvM;
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
            aF(this.cvM + i5, i4);
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
        if (this.ctF != 0 && this.ctJ != null && this.mAdapter != null) {
            SparseArrayCompat<Boolean> sparseArrayCompat = this.ctJ;
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
