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
import com.baidu.tieba.u;
import java.util.ArrayList;
@RemoteViews.RemoteView
/* loaded from: classes.dex */
public class HListView extends AbsHListView {
    private boolean cxA;
    private boolean cxB;
    private boolean cxC;
    private Paint cxD;
    private final a cxE;
    private c cxF;
    Drawable cxs;
    int cxt;
    int cxu;
    Drawable cxv;
    Drawable cxw;
    private boolean cxx;
    private boolean cxy;
    private boolean cxz;
    private GestureDetector mGestureDetector;
    private final Rect mTempRect;
    private ArrayList<b> yI;
    private ArrayList<b> yJ;

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
        this(context, attributeSet, u.c.hlv_listViewStyle);
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
        this.yI = new ArrayList<>();
        this.yJ = new ArrayList<>();
        this.cxB = true;
        this.cxC = false;
        this.mTempRect = new Rect();
        this.cxE = new a(null);
        this.mGestureDetector = new GestureDetector(new d(this, null));
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, u.l.HListView, i, 0);
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
        this.cxz = z;
        this.cxA = z2;
        this.cxu = i3;
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
    private void aiF() {
        int right;
        int i = 0;
        int childCount = getChildCount();
        if (childCount > 0) {
            if (!this.cuG) {
                right = getChildAt(0).getLeft() - this.cuq.left;
                if (this.bkE != 0) {
                    right -= this.cxt;
                }
            } else {
                right = getChildAt(childCount - 1).getRight() - (getWidth() - this.cuq.right);
                if (childCount + this.bkE < this.cwr) {
                    right += this.cxt;
                }
            }
            if (i != 0) {
                jD(-i);
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
        this.yI.add(bVar);
        if (this.mAdapter != null && this.cug != null) {
            this.cug.onChanged();
        }
    }

    public void addHeaderView(View view) {
        addHeaderView(view, null, true);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView
    public int getHeaderViewsCount() {
        return this.yI.size();
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView
    public int getFooterViewsCount() {
        return this.yJ.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.horizonalList.widget.g
    public ListAdapter getAdapter() {
        return this.mAdapter;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView
    public void setAdapter(ListAdapter listAdapter) {
        int B;
        if (this.mAdapter != null && this.cug != null) {
            this.mAdapter.unregisterDataSetObserver(this.cug);
        }
        ahM();
        this.cul.clear();
        if (this.yI.size() > 0 || this.yJ.size() > 0) {
            this.mAdapter = new m(this.yI, this.yJ, listAdapter);
        } else {
            this.mAdapter = listAdapter;
        }
        this.cwu = -1;
        this.cwv = Long.MIN_VALUE;
        super.setAdapter(listAdapter);
        if (this.mAdapter != null) {
            this.cxB = this.mAdapter.areAllItemsEnabled();
            this.cws = this.cwr;
            this.cwr = this.mAdapter.getCount();
            aio();
            this.cug = new AbsHListView.a();
            this.mAdapter.registerDataSetObserver(this.cug);
            this.cul.jJ(this.mAdapter.getViewTypeCount());
            if (this.cuG) {
                B = B(this.cwr - 1, false);
            } else {
                B = B(0, true);
            }
            setSelectedPositionInt(B);
            setNextSelectedPositionInt(B);
            if (this.cwr == 0) {
                ait();
            }
        } else {
            this.cxB = true;
            aio();
            ait();
        }
        requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView
    public void ahM() {
        T(this.yI);
        T(this.yJ);
        super.ahM();
        this.cuf = 0;
    }

    private void T(ArrayList<b> arrayList) {
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                AbsHListView.f fVar = (AbsHListView.f) arrayList.get(i).view.getLayoutParams();
                if (fVar != null) {
                    fVar.cvB = false;
                }
            }
        }
    }

    private boolean aiG() {
        return this.bkE > 0 || getChildAt(0).getLeft() > getScrollX() + this.cuq.left;
    }

    private boolean aiH() {
        int childCount = getChildCount();
        return (childCount + this.bkE) + (-1) < this.cwr + (-1) || getChildAt(childCount + (-1)).getRight() < (getScrollX() + getWidth()) - this.cuq.right;
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
        if (aiG() && (this.ceR > 0 || i4 > horizontalFadingEdgeLength)) {
            scrollX += horizontalFadingEdgeLength;
        }
        int right = getChildAt(getChildCount() - 1).getRight();
        if (aiH() && (this.ceR < this.cwr - 1 || rect.right < right - horizontalFadingEdgeLength)) {
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
            kd(-i);
            b(-1, view);
            this.cuF = view.getTop();
            invalidate();
        }
        return z2;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView
    protected void eI(boolean z) {
        int childCount = getChildCount();
        if (z) {
            ax(childCount + this.bkE, childCount > 0 ? getChildAt(childCount - 1).getRight() + this.cxt : 0);
            jX(getChildCount());
            return;
        }
        ay(this.bkE - 1, childCount > 0 ? getChildAt(0).getLeft() - this.cxt : getWidth() - 0);
        jY(getChildCount());
    }

    private View ax(int i, int i2) {
        View view = null;
        int right = getRight() - getLeft();
        int i3 = i2;
        int i4 = i;
        while (i3 < right && i4 < this.cwr) {
            boolean z = i4 == this.ceR;
            View a2 = a(i4, i3, true, this.cuq.top, z);
            i3 = a2.getRight() + this.cxt;
            if (!z) {
                a2 = view;
            }
            i4++;
            view = a2;
        }
        au(this.bkE, (this.bkE + getChildCount()) - 1);
        return view;
    }

    private View ay(int i, int i2) {
        View view = null;
        int i3 = i2;
        int i4 = i;
        while (i3 > 0 && i4 >= 0) {
            boolean z = i4 == this.ceR;
            View a2 = a(i4, i3, false, this.cuq.top, z);
            i3 = a2.getLeft() - this.cxt;
            if (!z) {
                a2 = view;
            }
            i4--;
            view = a2;
        }
        this.bkE = i4 + 1;
        au(this.bkE, (this.bkE + getChildCount()) - 1);
        return view;
    }

    private View jW(int i) {
        this.bkE = Math.min(this.bkE, this.ceR);
        this.bkE = Math.min(this.bkE, this.cwr - 1);
        if (this.bkE < 0) {
            this.bkE = 0;
        }
        return ax(this.bkE, i);
    }

    private View az(int i, int i2) {
        int i3 = i2 - i;
        int ahZ = ahZ();
        View a2 = a(ahZ, i, true, this.cuq.top, true);
        this.bkE = ahZ;
        int measuredWidth = a2.getMeasuredWidth();
        if (measuredWidth <= i3) {
            a2.offsetLeftAndRight((i3 - measuredWidth) / 2);
        }
        u(a2, ahZ);
        if (!this.cuG) {
            jX(getChildCount());
        } else {
            jY(getChildCount());
        }
        return a2;
    }

    private void u(View view, int i) {
        int i2 = this.cxt;
        if (!this.cuG) {
            ay(i - 1, view.getLeft() - i2);
            aiF();
            ax(i + 1, i2 + view.getRight());
            return;
        }
        ax(i + 1, view.getRight() + i2);
        aiF();
        ay(i - 1, view.getLeft() - i2);
    }

    private View t(int i, int i2, int i3) {
        int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
        int i4 = this.ceR;
        int v = v(i2, horizontalFadingEdgeLength, i4);
        int u = u(i3, horizontalFadingEdgeLength, i4);
        View a2 = a(i4, i, true, this.cuq.top, true);
        if (a2.getRight() > u) {
            a2.offsetLeftAndRight(-Math.min(a2.getLeft() - v, a2.getRight() - u));
        } else if (a2.getLeft() < v) {
            a2.offsetLeftAndRight(Math.min(v - a2.getLeft(), u - a2.getRight()));
        }
        u(a2, i4);
        if (!this.cuG) {
            jX(getChildCount());
        } else {
            jY(getChildCount());
        }
        return a2;
    }

    private int u(int i, int i2, int i3) {
        if (i3 != this.cwr - 1) {
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
        int i4 = this.ceR;
        int v = v(i2, horizontalFadingEdgeLength, i4);
        int u = u(i2, horizontalFadingEdgeLength, i4);
        if (i > 0) {
            View a3 = a(i4 - 1, view.getLeft(), true, this.cuq.top, false);
            int i5 = this.cxt;
            a2 = a(i4, a3.getRight() + i5, true, this.cuq.top, true);
            if (a2.getRight() > u) {
                int min = Math.min(Math.min(a2.getLeft() - v, a2.getRight() - u), (i3 - i2) / 2);
                a3.offsetLeftAndRight(-min);
                a2.offsetLeftAndRight(-min);
            }
            if (!this.cuG) {
                ay(this.ceR - 2, a2.getLeft() - i5);
                aiF();
                ax(this.ceR + 1, a2.getRight() + i5);
            } else {
                ax(this.ceR + 1, a2.getRight() + i5);
                aiF();
                ay(this.ceR - 2, a2.getLeft() - i5);
            }
        } else if (i < 0) {
            if (view2 != null) {
                a2 = a(i4, view2.getLeft(), true, this.cuq.top, true);
            } else {
                a2 = a(i4, view.getLeft(), false, this.cuq.top, true);
            }
            if (a2.getLeft() < v) {
                a2.offsetLeftAndRight(Math.min(Math.min(v - a2.getLeft(), u - a2.getRight()), (i3 - i2) / 2));
            }
            u(a2, i4);
        } else {
            int left = view.getLeft();
            a2 = a(i4, left, true, this.cuq.top, true);
            if (left < i2 && a2.getRight() < i2 + 20) {
                a2.offsetLeftAndRight(i2 - a2.getLeft());
            }
            u(a2, i4);
        }
        return a2;
    }

    /* loaded from: classes.dex */
    private class c implements Runnable {
        private int akG;
        private int cxH;

        private c() {
        }

        /* synthetic */ c(HListView hListView, c cVar) {
            this();
        }

        public c aE(int i, int i2) {
            this.akG = i;
            this.cxH = i2;
            return this;
        }

        @Override // java.lang.Runnable
        public void run() {
            HListView.this.aB(this.akG, this.cxH);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        View focusedChild;
        if (getChildCount() > 0 && (focusedChild = getFocusedChild()) != null) {
            int indexOfChild = this.bkE + indexOfChild(focusedChild);
            int left = focusedChild.getLeft() - Math.max(0, focusedChild.getRight() - (i - getPaddingLeft()));
            if (this.cxF == null) {
                this.cxF = new c(this, null);
            }
            post(this.cxF.aE(indexOfChild, left));
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
        this.cwr = this.mAdapter == null ? 0 : this.mAdapter.getCount();
        if (this.cwr > 0 && (mode == 0 || mode2 == 0)) {
            View b2 = b(0, this.cva);
            h(b2, 0, i2);
            i4 = b2.getMeasuredWidth();
            i5 = b2.getMeasuredHeight();
            r1 = Build.VERSION.SDK_INT >= 11 ? combineMeasuredStates(0, b2.getMeasuredState()) : 0;
            if (aiI() && this.cul.jK(((AbsHListView.f) b2.getLayoutParams()).cvA)) {
                this.cul.t(b2, -1);
            }
        }
        int i6 = i5;
        int i7 = i4;
        if (mode2 == 0) {
            i3 = i6 + this.cuq.top + this.cuq.bottom + getHorizontalScrollbarHeight();
        } else if (mode2 == Integer.MIN_VALUE && this.cwr > 0 && this.cxu > -1) {
            i3 = d(i2, this.cxu, this.cxu, size, size2, -1)[1];
        } else {
            i3 = Build.VERSION.SDK_INT >= 11 ? size2 | ((-16777216) & r1) : size2;
        }
        if (mode == 0) {
            size = this.cuq.left + this.cuq.right + i7 + (getHorizontalFadingEdgeLength() * 2);
        }
        if (mode == Integer.MIN_VALUE) {
            size = b(i2, 0, -1, size, -1);
        }
        setMeasuredDimension(size, i3);
        this.cur = i2;
    }

    private void h(View view, int i, int i2) {
        int makeMeasureSpec;
        AbsHListView.f fVar = (AbsHListView.f) view.getLayoutParams();
        if (fVar == null) {
            fVar = (AbsHListView.f) generateDefaultLayoutParams();
            view.setLayoutParams(fVar);
        }
        fVar.cvA = this.mAdapter.getItemViewType(i);
        fVar.cvC = true;
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, this.cuq.top + this.cuq.bottom, fVar.height);
        int i3 = fVar.width;
        if (i3 > 0) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(makeMeasureSpec, childMeasureSpec);
    }

    @ViewDebug.ExportedProperty(category = IntentConfig.LIST)
    protected boolean aiI() {
        return true;
    }

    final int b(int i, int i2, int i3, int i4, int i5) {
        int i6 = 0;
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter == null) {
            return this.cuq.left + this.cuq.right;
        }
        int i7 = this.cuq.left + this.cuq.right;
        int i8 = (this.cxt <= 0 || this.cxs == null) ? 0 : this.cxt;
        if (i3 == -1) {
            i3 = listAdapter.getCount() - 1;
        }
        AbsHListView.k kVar = this.cul;
        boolean aiI = aiI();
        boolean[] zArr = this.cva;
        while (i2 <= i3) {
            View b2 = b(i2, zArr);
            h(b2, i2, i);
            int i9 = i2 > 0 ? i7 + i8 : i7;
            if (aiI && kVar.jK(((AbsHListView.f) b2.getLayoutParams()).cvA)) {
                kVar.t(b2, -1);
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
            return new int[]{this.cuq.left + this.cuq.right, this.cuq.top + this.cuq.bottom};
        }
        int i7 = this.cuq.left + this.cuq.right;
        int i8 = this.cuq.top + this.cuq.bottom;
        int i9 = (this.cxt <= 0 || this.cxs == null) ? 0 : this.cxt;
        if (i3 == -1) {
            i3 = listAdapter.getCount() - 1;
        }
        AbsHListView.k kVar = this.cul;
        boolean aiI = aiI();
        boolean[] zArr = this.cva;
        int i10 = 0;
        int i11 = 0;
        while (i2 <= i3) {
            View b2 = b(i2, zArr);
            h(b2, i2, i);
            if (aiI && kVar.jK(((AbsHListView.f) b2.getLayoutParams()).cvA)) {
                kVar.t(b2, -1);
            }
            i10 = Math.max(i10, b2.getMeasuredWidth() + i9);
            i2++;
            i11 = Math.max(i11, b2.getMeasuredHeight());
        }
        return new int[]{Math.min(i10 + i7, i4), Math.min(i11 + i8, i5)};
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView
    protected int jE(int i) {
        int childCount = getChildCount();
        if (childCount > 0) {
            if (this.cuG) {
                for (int i2 = childCount - 1; i2 >= 0; i2--) {
                    if (i >= getChildAt(i2).getLeft()) {
                        return i2 + this.bkE;
                    }
                }
            } else {
                for (int i3 = 0; i3 < childCount; i3++) {
                    if (i <= getChildAt(i3).getRight()) {
                        return i3 + this.bkE;
                    }
                }
            }
        }
        return -1;
    }

    private View aA(int i, int i2) {
        View ax;
        View ay;
        boolean z = i == this.ceR;
        View a2 = a(i, i2, true, this.cuq.top, z);
        this.bkE = i;
        int i3 = this.cxt;
        if (!this.cuG) {
            ay = ay(i - 1, a2.getLeft() - i3);
            aiF();
            ax = ax(i + 1, i3 + a2.getRight());
            int childCount = getChildCount();
            if (childCount > 0) {
                jX(childCount);
            }
        } else {
            ax = ax(i + 1, a2.getRight() + i3);
            aiF();
            ay = ay(i - 1, a2.getLeft() - i3);
            int childCount2 = getChildCount();
            if (childCount2 > 0) {
                jY(childCount2);
            }
        }
        if (z) {
            return a2;
        }
        return ay != null ? ay : ax;
    }

    private void jX(int i) {
        if ((this.bkE + i) - 1 == this.cwr - 1 && i > 0) {
            int right = ((getRight() - getLeft()) - this.cuq.right) - getChildAt(i - 1).getRight();
            View childAt = getChildAt(0);
            int left = childAt.getLeft();
            if (right > 0) {
                if (this.bkE > 0 || left < this.cuq.top) {
                    if (this.bkE == 0) {
                        right = Math.min(right, this.cuq.top - left);
                    }
                    jD(right);
                    if (this.bkE > 0) {
                        ay(this.bkE - 1, childAt.getLeft() - this.cxt);
                        aiF();
                    }
                }
            }
        }
    }

    private void jY(int i) {
        if (this.bkE == 0 && i > 0) {
            int left = getChildAt(0).getLeft();
            int i2 = this.cuq.left;
            int right = (getRight() - getLeft()) - this.cuq.right;
            int i3 = left - i2;
            View childAt = getChildAt(i - 1);
            int right2 = childAt.getRight();
            int i4 = (this.bkE + i) - 1;
            if (i3 > 0) {
                if (i4 < this.cwr - 1 || right2 > right) {
                    if (i4 == this.cwr - 1) {
                        i3 = Math.min(i3, right2 - right);
                    }
                    jD(-i3);
                    if (i4 < this.cwr - 1) {
                        ax(i4 + 1, childAt.getRight() + this.cxt);
                        aiF();
                    }
                } else if (i4 == this.cwr - 1) {
                    aiF();
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
        boolean z = this.cwz;
        if (z) {
            return;
        }
        this.cwz = true;
        try {
            super.layoutChildren();
            invalidate();
            if (this.mAdapter == null) {
                ahM();
                ahJ();
                if (z) {
                    return;
                }
                return;
            }
            int i = this.cuq.left;
            int right = (getRight() - getLeft()) - this.cuq.right;
            int childCount = getChildCount();
            View view4 = null;
            View view5 = null;
            View view6 = null;
            switch (this.cuf) {
                case 1:
                case 3:
                case 4:
                case 5:
                    view = null;
                    break;
                case 2:
                    int i2 = this.cwo - this.bkE;
                    if (i2 < 0 || i2 >= childCount) {
                        view = null;
                        break;
                    } else {
                        view5 = getChildAt(i2);
                        view = null;
                        break;
                    }
                default:
                    int i3 = this.ceR - this.bkE;
                    if (i3 >= 0 && i3 < childCount) {
                        view4 = getChildAt(i3);
                    }
                    View childAt = getChildAt(0);
                    r4 = this.cwo >= 0 ? this.cwo - this.ceR : 0;
                    view5 = getChildAt(i3 + r4);
                    view = childAt;
                    break;
            }
            boolean z2 = this.aaZ;
            if (z2) {
                handleDataChanged();
            }
            if (this.cwr == 0) {
                ahM();
                ahJ();
                if (z) {
                    return;
                }
                this.cwz = false;
            } else if (this.cwr != this.mAdapter.getCount()) {
                throw new IllegalStateException("The content of the adapter has changed but ListView did not receive a notification. Make sure the content of your adapter is not modified from a background thread, but only from the UI thread. [in ListView(" + getId() + ", " + getClass() + ") with Adapter(" + this.mAdapter.getClass() + ")]");
            } else {
                setSelectedPositionInt(this.cwo);
                int i4 = this.bkE;
                AbsHListView.k kVar = this.cul;
                View view7 = null;
                if (z2) {
                    for (int i5 = 0; i5 < childCount; i5++) {
                        kVar.t(getChildAt(i5), i4 + i5);
                    }
                } else {
                    kVar.aw(childCount, i4);
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
                kVar.aij();
                switch (this.cuf) {
                    case 1:
                        this.bkE = 0;
                        View jW = jW(i);
                        aiF();
                        a2 = jW;
                        break;
                    case 2:
                        if (view5 != null) {
                            a2 = t(view5.getLeft(), i, right);
                            break;
                        } else {
                            a2 = az(i, right);
                            break;
                        }
                    case 3:
                        View ay = ay(this.cwr - 1, right);
                        aiF();
                        a2 = ay;
                        break;
                    case 4:
                        a2 = aA(ahZ(), this.cwf);
                        break;
                    case 5:
                        a2 = aA(this.cwg, this.cwf);
                        break;
                    case 6:
                        a2 = a(view4, view5, r4, i, right);
                        break;
                    default:
                        if (childCount == 0) {
                            if (this.cuG) {
                                setSelectedPositionInt(B(this.cwr - 1, false));
                                a2 = ay(this.cwr - 1, right);
                                break;
                            } else {
                                setSelectedPositionInt(B(0, true));
                                a2 = jW(i);
                                break;
                            }
                        } else if (this.ceR < 0 || this.ceR >= this.cwr) {
                            if (this.bkE < this.cwr) {
                                int i6 = this.bkE;
                                if (view != null) {
                                    i = view.getLeft();
                                }
                                a2 = aA(i6, i);
                                break;
                            } else {
                                a2 = aA(0, i);
                                break;
                            }
                        } else {
                            int i7 = this.ceR;
                            if (view4 != null) {
                                i = view4.getLeft();
                            }
                            a2 = aA(i7, i);
                            break;
                        }
                }
                kVar.aik();
                if (a2 != null) {
                    if (!this.cxC || !hasFocus() || a2.hasFocus()) {
                        b(-1, a2);
                    } else if ((a2 == view3 && view2 != null && view2.requestFocus()) || a2.requestFocus()) {
                        a2.setSelected(false);
                        this.cuk.setEmpty();
                    } else {
                        View focusedChild2 = getFocusedChild();
                        if (focusedChild2 != null) {
                            focusedChild2.clearFocus();
                        }
                        b(-1, a2);
                    }
                    this.cuF = a2.getLeft();
                } else {
                    if (this.mTouchMode <= 0 || this.mTouchMode >= 3) {
                        this.cuF = 0;
                        this.cuk.setEmpty();
                    } else {
                        View childAt2 = getChildAt(this.cuw - this.bkE);
                        if (childAt2 != null) {
                            b(this.cuw, childAt2);
                        }
                    }
                    if (hasFocus() && view2 != null) {
                        view2.requestFocus();
                    }
                }
                if (view2 != null && view2.getWindowToken() != null) {
                    view2.onFinishTemporaryDetach();
                }
                this.cuf = 0;
                this.aaZ = false;
                if (this.cuY != null) {
                    post(this.cuY);
                    this.cuY = null;
                }
                this.cwj = false;
                setNextSelectedPositionInt(this.ceR);
                ahN();
                if (this.cwr > 0) {
                    ait();
                }
                ahJ();
                if (z) {
                    return;
                }
                this.cwz = false;
            }
        } finally {
            if (!z) {
                this.cwz = false;
            }
        }
    }

    private boolean ay(View view) {
        ArrayList<b> arrayList = this.yI;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (view == arrayList.get(i).view) {
                return true;
            }
        }
        ArrayList<b> arrayList2 = this.yJ;
        int size2 = arrayList2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            if (view == arrayList2.get(i2).view) {
                return true;
            }
        }
        return false;
    }

    private View a(int i, int i2, boolean z, int i3, boolean z2) {
        View jL;
        if (!this.aaZ && (jL = this.cul.jL(i)) != null) {
            a(jL, i, i2, z, i3, z2, true);
            return jL;
        }
        View b2 = b(i, this.cva);
        a(b2, i, i2, z, i3, z2, this.cva[0]);
        return b2;
    }

    private void a(View view, int i, int i2, boolean z, int i3, boolean z2, boolean z3) {
        int makeMeasureSpec;
        boolean z4 = z2 && ahP();
        boolean isSelected = z4 ^ view.isSelected();
        int i4 = this.mTouchMode;
        boolean z5 = i4 > 0 && i4 < 3 && this.cuw == i;
        boolean isPressed = z5 ^ view.isPressed();
        boolean z6 = !z3 || isSelected || view.isLayoutRequested();
        AbsHListView.f fVar = (AbsHListView.f) view.getLayoutParams();
        AbsHListView.f fVar2 = fVar == null ? (AbsHListView.f) generateDefaultLayoutParams() : fVar;
        fVar2.cvA = this.mAdapter.getItemViewType(i);
        if ((z3 && !fVar2.cvC) || (fVar2.cvB && fVar2.cvA == -2)) {
            attachViewToParent(view, z ? -1 : 0, fVar2);
        } else {
            fVar2.cvC = false;
            if (fVar2.cvA == -2) {
                fVar2.cvB = true;
            }
            addViewInLayout(view, z ? -1 : 0, fVar2, true);
        }
        if (isSelected) {
            view.setSelected(z4);
        }
        if (isPressed) {
            view.setPressed(z5);
        }
        if (this.ctZ != 0 && this.cud != null) {
            if (view instanceof Checkable) {
                ((Checkable) view).setChecked(this.cud.get(i, false).booleanValue());
            } else if (Build.VERSION.SDK_INT >= 11) {
                view.setActivated(this.cud.get(i, false).booleanValue());
            }
        }
        if (z6) {
            int childMeasureSpec = ViewGroup.getChildMeasureSpec(this.cur, this.cuq.top + this.cuq.bottom, fVar2.height);
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
        if (this.cuu && !view.isDrawingCacheEnabled()) {
            view.setDrawingCacheEnabled(true);
        }
        if (Build.VERSION.SDK_INT >= 11 && z3 && ((AbsHListView.f) view.getLayoutParams()).cvD != i) {
            view.jumpDrawablesToCurrentState();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.g, android.view.ViewGroup
    public boolean canAnimate() {
        return super.canAnimate() && this.cwr > 0;
    }

    @Override // com.baidu.tieba.horizonalList.widget.g
    public void setSelection(int i) {
        aB(i, 0);
    }

    public void aB(int i, int i2) {
        if (this.mAdapter != null) {
            if (!isInTouchMode()) {
                i = B(i, true);
                if (i >= 0) {
                    setNextSelectedPositionInt(i);
                }
            } else {
                this.cuK = i;
            }
            if (i >= 0) {
                this.cuf = 4;
                this.cwf = this.cuq.left + i2;
                if (this.cwj) {
                    this.cwg = i;
                    this.cwh = this.mAdapter.getItemId(i);
                }
                if (this.cuE != null) {
                    this.cuE.stop();
                }
                requestLayout();
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView
    public void setSelectionInt(int i) {
        boolean z = true;
        setNextSelectedPositionInt(i);
        int i2 = this.ceR;
        if (i2 < 0 || (i != i2 - 1 && i != i2 + 1)) {
            z = false;
        }
        if (this.cuE != null) {
            this.cuE.stop();
        }
        layoutChildren();
        if (z) {
            awakenScrollBars();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.g
    public int B(int i, boolean z) {
        int min;
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter == null || isInTouchMode()) {
            return -1;
        }
        int count = listAdapter.getCount();
        if (!this.cxB) {
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
        if (this.mAdapter == null || !this.cvn) {
            return false;
        }
        if (this.aaZ) {
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
                        z = jZ(33);
                        break;
                    }
                    break;
                case 20:
                    if (keyEvent.hasNoModifiers()) {
                        z = jZ(TransportMediator.KEYCODE_MEDIA_RECORD);
                        break;
                    }
                    break;
                case 21:
                    if (keyEvent.hasNoModifiers()) {
                        z = aia();
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
                        if (!aia() && !fullScroll(33)) {
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
                        z = aia();
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
                        if (!aia() && !fullScroll(TransportMediator.KEYCODE_MEDIA_RECORD)) {
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
                        z = aia();
                        if (!z && keyEvent.getRepeatCount() == 0 && getChildCount() > 0) {
                            ahQ();
                            z = true;
                            break;
                        }
                    }
                    break;
                case BDLocation.TypeCriteriaException /* 62 */:
                    if (!keyEvent.hasNoModifiers() ? !keyEvent.hasModifiers(1) || aia() || !pageScroll(33) : aia() || !pageScroll(TransportMediator.KEYCODE_MEDIA_RECORD)) {
                    }
                    z = true;
                    break;
                case 92:
                    if (keyEvent.hasNoModifiers()) {
                        if (!aia() && !pageScroll(33)) {
                            z = false;
                            break;
                        } else {
                            z = true;
                            break;
                        }
                    } else if (keyEvent.hasModifiers(2)) {
                        if (!aia() && !fullScroll(33)) {
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
                        if (!aia() && !pageScroll(TransportMediator.KEYCODE_MEDIA_RECORD)) {
                            z = false;
                            break;
                        } else {
                            z = true;
                            break;
                        }
                    } else if (keyEvent.hasModifiers(2)) {
                        if (!aia() && !fullScroll(TransportMediator.KEYCODE_MEDIA_RECORD)) {
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
                        if (!aia() && !fullScroll(33)) {
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
                        if (!aia() && !fullScroll(TransportMediator.KEYCODE_MEDIA_RECORD)) {
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
        int B;
        if (i == 33) {
            i2 = Math.max(0, (this.ceR - getChildCount()) - 1);
            z = false;
        } else if (i != 130) {
            i2 = -1;
            z = false;
        } else {
            i2 = Math.min(this.cwr - 1, (this.ceR + getChildCount()) - 1);
            z = true;
        }
        if (i2 < 0 || (B = B(i2, z)) < 0) {
            return false;
        }
        this.cuf = 4;
        this.cwf = getPaddingLeft() + getHorizontalFadingEdgeLength();
        if (z && B > this.cwr - getChildCount()) {
            this.cuf = 3;
        }
        if (!z && B < getChildCount()) {
            this.cuf = 1;
        }
        setSelectionInt(B);
        ahJ();
        if (awakenScrollBars()) {
            return true;
        }
        invalidate();
        return true;
    }

    boolean fullScroll(int i) {
        boolean z = true;
        if (i == 33) {
            if (this.ceR != 0) {
                int B = B(0, true);
                if (B >= 0) {
                    this.cuf = 1;
                    setSelectionInt(B);
                    ahJ();
                }
            }
            z = false;
        } else {
            if (i == 130 && this.ceR < this.cwr - 1) {
                int B2 = B(this.cwr - 1, true);
                if (B2 >= 0) {
                    this.cuf = 3;
                    setSelectionInt(B2);
                    ahJ();
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

    private boolean jZ(int i) {
        View selectedView;
        if (i != 33 && i != 130) {
            throw new IllegalArgumentException("direction must be one of {View.FOCUS_UP, View.FOCUS_DOWN}");
        }
        int childCount = getChildCount();
        if (this.cxC && childCount > 0 && this.ceR != -1 && (selectedView = getSelectedView()) != null && selectedView.hasFocus() && (selectedView instanceof ViewGroup)) {
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
            boolean ka = ka(i);
            if (ka) {
                playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
            }
            return ka;
        } finally {
            this.mInLayout = false;
        }
    }

    private boolean ka(int i) {
        View view;
        int i2;
        View view2;
        View focusedChild;
        if (getChildCount() <= 0) {
            return false;
        }
        View selectedView = getSelectedView();
        int i3 = this.ceR;
        int kb = kb(i);
        int aC = aC(i, kb);
        a kc = this.cxC ? kc(i) : null;
        if (kc != null) {
            kb = kc.adH();
            aC = kc.aiJ();
        }
        boolean z = kc != null;
        if (kb != -1) {
            a(selectedView, i, kb, kc != null);
            setSelectedPositionInt(kb);
            setNextSelectedPositionInt(kb);
            view = getSelectedView();
            if (this.cxC && kc == null && (focusedChild = getFocusedChild()) != null) {
                focusedChild.clearFocus();
            }
            ait();
            z = true;
            i2 = kb;
        } else {
            view = selectedView;
            i2 = i3;
        }
        if (aC > 0) {
            kd(i == 33 ? aC : -aC);
            z = true;
        }
        if (this.cxC && kc == null && view != null && view.hasFocus()) {
            View findFocus = view.findFocus();
            if (!a(findFocus, this) || aC(findFocus) > 0) {
                findFocus.clearFocus();
            }
        }
        if (kb != -1 || view == null || a(view, this)) {
            view2 = view;
        } else {
            ahY();
            this.cuK = -1;
            view2 = null;
        }
        if (z) {
            if (view2 != null) {
                b(i2, view2);
                this.cuF = view2.getLeft();
            }
            if (!awakenScrollBars()) {
                invalidate();
            }
            ahJ();
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
        int i4 = this.ceR - this.bkE;
        int i5 = i2 - this.bkE;
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
            i(view2, i3, childCount);
        }
        if (view != null) {
            if (z || z2) {
                z3 = false;
            }
            view.setSelected(z3);
            i(view, i5, childCount);
        }
    }

    private void i(View view, int i, int i2) {
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
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(this.cur, this.cuq.top + this.cuq.bottom, layoutParams.height);
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
        int i = this.cuq.top;
        int left = view.getLeft();
        view.layout(left, i, measuredWidth + left, measuredHeight + i);
    }

    private int getArrowScrollPreviewLength() {
        return Math.max(2, getHorizontalFadingEdgeLength());
    }

    private int aC(int i, int i2) {
        int width = getWidth() - this.cuq.right;
        int i3 = this.cuq.left;
        int childCount = getChildCount();
        if (i == 130) {
            int i4 = childCount - 1;
            if (i2 != -1) {
                i4 = i2 - this.bkE;
            }
            int i5 = this.bkE + i4;
            View childAt = getChildAt(i4);
            int arrowScrollPreviewLength = i5 < this.cwr + (-1) ? width - getArrowScrollPreviewLength() : width;
            if (childAt.getRight() <= arrowScrollPreviewLength) {
                return 0;
            }
            if (i2 == -1 || arrowScrollPreviewLength - childAt.getLeft() < getMaxScrollAmount()) {
                int right = childAt.getRight() - arrowScrollPreviewLength;
                if (this.bkE + childCount == this.cwr) {
                    right = Math.min(right, getChildAt(childCount - 1).getRight() - width);
                }
                return Math.min(right, getMaxScrollAmount());
            }
            return 0;
        }
        int i6 = i2 != -1 ? i2 - this.bkE : 0;
        int i7 = this.bkE + i6;
        View childAt2 = getChildAt(i6);
        int arrowScrollPreviewLength2 = i7 > 0 ? getArrowScrollPreviewLength() + i3 : i3;
        if (childAt2.getLeft() < arrowScrollPreviewLength2) {
            if (i2 == -1 || childAt2.getRight() - arrowScrollPreviewLength2 < getMaxScrollAmount()) {
                int left = arrowScrollPreviewLength2 - childAt2.getLeft();
                if (this.bkE == 0) {
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
        private int ceR;
        private int cxG;

        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }

        void aD(int i, int i2) {
            this.ceR = i;
            this.cxG = i2;
        }

        public int adH() {
            return this.ceR;
        }

        public int aiJ() {
            return this.cxG;
        }
    }

    private int kb(int i) {
        int i2 = this.bkE;
        if (i == 130) {
            int i3 = this.ceR != -1 ? this.ceR + 1 : i2;
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
            int childCount2 = this.ceR != -1 ? this.ceR - 1 : (getChildCount() + i2) - 1;
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

    private a kc(int i) {
        View findNextFocusFromRect;
        int kb;
        View selectedView = getSelectedView();
        if (selectedView != null && selectedView.hasFocus()) {
            findNextFocusFromRect = FocusFinder.getInstance().findNextFocus(this, selectedView.findFocus(), i);
        } else {
            if (i == 130) {
                int arrowScrollPreviewLength = (this.bkE > 0 ? getArrowScrollPreviewLength() : 0) + this.cuq.left;
                if (selectedView != null && selectedView.getLeft() > arrowScrollPreviewLength) {
                    arrowScrollPreviewLength = selectedView.getLeft();
                }
                this.mTempRect.set(arrowScrollPreviewLength, 0, arrowScrollPreviewLength, 0);
            } else {
                int width = (getWidth() - this.cuq.right) - ((this.bkE + getChildCount()) + (-1) < this.cwr ? getArrowScrollPreviewLength() : 0);
                if (selectedView != null && selectedView.getRight() < width) {
                    width = selectedView.getRight();
                }
                this.mTempRect.set(width, 0, width, 0);
            }
            findNextFocusFromRect = FocusFinder.getInstance().findNextFocusFromRect(this, this.mTempRect, i);
        }
        if (findNextFocusFromRect != null) {
            int aB = aB(findNextFocusFromRect);
            if (this.ceR != -1 && aB != this.ceR && (kb = kb(i)) != -1 && ((i == 130 && kb < aB) || (i == 33 && kb > aB))) {
                return null;
            }
            int b2 = b(i, findNextFocusFromRect, aB);
            int maxScrollAmount = getMaxScrollAmount();
            if (b2 < maxScrollAmount) {
                findNextFocusFromRect.requestFocus(i);
                this.cxE.aD(aB, b2);
                return this.cxE;
            } else if (aC(findNextFocusFromRect) < maxScrollAmount) {
                findNextFocusFromRect.requestFocus(i);
                this.cxE.aD(aB, maxScrollAmount);
                return this.cxE;
            }
        }
        return null;
    }

    private int aB(View view) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (a(view, getChildAt(i))) {
                return i + this.bkE;
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
            if (this.mTempRect.left >= this.cuq.left) {
                return 0;
            }
            int i3 = this.cuq.left - this.mTempRect.left;
            if (i2 > 0) {
                return i3 + getArrowScrollPreviewLength();
            }
            return i3;
        }
        int width = getWidth() - this.cuq.right;
        if (this.mTempRect.bottom <= width) {
            return 0;
        }
        int i4 = this.mTempRect.right - width;
        if (i2 < this.cwr - 1) {
            return i4 + getArrowScrollPreviewLength();
        }
        return i4;
    }

    private int aC(View view) {
        view.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(view, this.mTempRect);
        int right = (getRight() - getLeft()) - this.cuq.right;
        if (this.mTempRect.right < this.cuq.left) {
            return this.cuq.left - this.mTempRect.right;
        }
        if (this.mTempRect.left <= right) {
            return 0;
        }
        return this.mTempRect.left - right;
    }

    private void kd(int i) {
        int i2;
        jD(i);
        int width = getWidth() - this.cuq.right;
        int i3 = this.cuq.left;
        AbsHListView.k kVar = this.cul;
        if (i < 0) {
            int childCount = getChildCount();
            View childAt = getChildAt(childCount - 1);
            while (childAt.getRight() < width && (this.bkE + childCount) - 1 < this.cwr - 1) {
                childAt = w(childAt, i2);
                childCount++;
            }
            if (childAt.getBottom() < width) {
                jD(width - childAt.getRight());
            }
            View childAt2 = getChildAt(0);
            while (true) {
                View view = childAt2;
                if (view.getRight() < i3) {
                    if (kVar.jK(((AbsHListView.f) view.getLayoutParams()).cvA)) {
                        detachViewFromParent(view);
                        kVar.t(view, this.bkE);
                    } else {
                        removeViewInLayout(view);
                    }
                    childAt2 = getChildAt(0);
                    this.bkE++;
                } else {
                    return;
                }
            }
        } else {
            View childAt3 = getChildAt(0);
            while (childAt3.getLeft() > i3 && this.bkE > 0) {
                childAt3 = v(childAt3, this.bkE);
                this.bkE--;
            }
            if (childAt3.getLeft() > i3) {
                jD(i3 - childAt3.getLeft());
            }
            int childCount2 = getChildCount() - 1;
            View childAt4 = getChildAt(childCount2);
            while (true) {
                int i4 = childCount2;
                View view2 = childAt4;
                if (view2.getLeft() > width) {
                    if (kVar.jK(((AbsHListView.f) view2.getLayoutParams()).cvA)) {
                        detachViewFromParent(view2);
                        kVar.t(view2, this.bkE + i4);
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

    private View v(View view, int i) {
        int i2 = i - 1;
        View b2 = b(i2, this.cva);
        a(b2, i2, view.getLeft() - this.cxt, false, this.cuq.top, false, this.cva[0]);
        return b2;
    }

    private View w(View view, int i) {
        int i2 = i + 1;
        View b2 = b(i2, this.cva);
        a(b2, i2, this.cxt + view.getRight(), true, this.cuq.top, false, this.cva[0]);
        return b2;
    }

    public void setItemsCanFocus(boolean z) {
        this.cxC = z;
        if (!z) {
            setDescendantFocusability(393216);
        }
    }

    public boolean getItemsCanFocus() {
        return this.cxC;
    }

    @Override // android.view.View
    public boolean isOpaque() {
        boolean z = (this.cuv && this.cxx && this.cxy) || super.isOpaque();
        if (z) {
            int paddingLeft = this.cuq != null ? this.cuq.left : getPaddingLeft();
            View childAt = getChildAt(0);
            if (childAt == null || childAt.getLeft() > paddingLeft) {
                return false;
            }
            int width = getWidth() - (this.cuq != null ? this.cuq.right : getPaddingRight());
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
        this.cxx = z;
        if (z) {
            if (this.cxD == null) {
                this.cxD = new Paint();
            }
            this.cxD.setColor(i);
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
        if (this.cuu) {
            this.cuv = true;
        }
        int i = this.cxt;
        Drawable drawable = this.cxv;
        Drawable drawable2 = this.cxw;
        boolean z = drawable != null;
        boolean z2 = drawable2 != null;
        boolean z3 = i > 0 && this.cxs != null;
        if (z3 || z || z2) {
            Rect rect = this.mTempRect;
            rect.top = getPaddingTop();
            rect.bottom = (getBottom() - getTop()) - getPaddingBottom();
            int childCount = getChildCount();
            int size = this.yI.size();
            int i2 = this.cwr;
            int size2 = (i2 - this.yJ.size()) - 1;
            boolean z4 = this.cxz;
            boolean z5 = this.cxA;
            int i3 = this.bkE;
            boolean z6 = this.cxB;
            ListAdapter listAdapter = this.mAdapter;
            boolean z7 = isOpaque() && !super.isOpaque();
            if (z7 && this.cxD == null && this.cxx) {
                this.cxD = new Paint();
                this.cxD.setColor(getCacheColorHint());
            }
            Paint paint = this.cxD;
            int scrollX = getScrollX() + ((getRight() - getLeft()) - 0);
            if (!this.cuG) {
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
        if (this.cuv) {
            this.cuv = false;
        }
        return drawChild;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Canvas canvas, Rect rect, int i) {
        Drawable drawable = this.cxs;
        drawable.setBounds(rect);
        drawable.draw(canvas);
    }

    public Drawable getDivider() {
        return this.cxs;
    }

    public void setDivider(Drawable drawable) {
        boolean z = false;
        if (drawable != null) {
            this.cxt = drawable.getIntrinsicWidth();
        } else {
            this.cxt = 0;
        }
        this.cxs = drawable;
        this.cxy = (drawable == null || drawable.getOpacity() == -1) ? true : true;
        requestLayout();
        invalidate();
    }

    public int getDividerWidth() {
        return this.cxt;
    }

    public void setDividerWidth(int i) {
        this.cxt = i;
        requestLayout();
        invalidate();
    }

    public void setHeaderDividersEnabled(boolean z) {
        this.cxz = z;
        invalidate();
    }

    public void setFooterDividersEnabled(boolean z) {
        this.cxA = z;
        invalidate();
    }

    public void setOverscrollHeader(Drawable drawable) {
        this.cxv = drawable;
        if (getScrollX() < 0) {
            invalidate();
        }
    }

    public Drawable getOverscrollHeader() {
        return this.cxv;
    }

    public void setOverscrollFooter(Drawable drawable) {
        this.cxw = drawable;
        invalidate();
    }

    public Drawable getOverscrollFooter() {
        return this.cxw;
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
            if (listAdapter.getCount() < getChildCount() + this.bkE) {
                this.cuf = 0;
                layoutChildren();
            }
            Rect rect2 = this.mTempRect;
            int i6 = Integer.MAX_VALUE;
            int childCount = getChildCount();
            int i7 = this.bkE;
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
            aB(this.bkE + i5, i4);
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
        if (this.ctZ != 0 && this.cud != null && this.mAdapter != null) {
            SparseArrayCompat<Boolean> sparseArrayCompat = this.cud;
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
