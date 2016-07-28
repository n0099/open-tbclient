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
    Drawable cAh;
    int cAi;
    int cAj;
    Drawable cAk;
    Drawable cAl;
    private boolean cAm;
    private boolean cAn;
    private boolean cAo;
    private boolean cAp;
    private boolean cAq;
    private boolean cAr;
    private Paint cAs;
    private final a cAt;
    private c cAu;
    private GestureDetector mGestureDetector;
    private final Rect mTempRect;
    private ArrayList<b> zj;
    private ArrayList<b> zk;

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
        this.zj = new ArrayList<>();
        this.zk = new ArrayList<>();
        this.cAq = true;
        this.cAr = false;
        this.mTempRect = new Rect();
        this.cAt = new a(null);
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
        this.cAo = z;
        this.cAp = z2;
        this.cAj = i3;
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
    private void ajp() {
        int right;
        int i = 0;
        int childCount = getChildCount();
        if (childCount > 0) {
            if (!this.cxv) {
                right = getChildAt(0).getLeft() - this.cxf.left;
                if (this.bml != 0) {
                    right -= this.cAi;
                }
            } else {
                right = getChildAt(childCount - 1).getRight() - (getWidth() - this.cxf.right);
                if (childCount + this.bml < this.czg) {
                    right += this.cAi;
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
        this.zj.add(bVar);
        if (this.mAdapter != null && this.cwV != null) {
            this.cwV.onChanged();
        }
    }

    public void addHeaderView(View view) {
        addHeaderView(view, null, true);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView
    public int getHeaderViewsCount() {
        return this.zj.size();
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView
    public int getFooterViewsCount() {
        return this.zk.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.horizonalList.widget.g
    public ListAdapter getAdapter() {
        return this.mAdapter;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView
    public void setAdapter(ListAdapter listAdapter) {
        int C;
        if (this.mAdapter != null && this.cwV != null) {
            this.mAdapter.unregisterDataSetObserver(this.cwV);
        }
        aiw();
        this.cxa.clear();
        if (this.zj.size() > 0 || this.zk.size() > 0) {
            this.mAdapter = new m(this.zj, this.zk, listAdapter);
        } else {
            this.mAdapter = listAdapter;
        }
        this.czj = -1;
        this.czk = Long.MIN_VALUE;
        super.setAdapter(listAdapter);
        if (this.mAdapter != null) {
            this.cAq = this.mAdapter.areAllItemsEnabled();
            this.czh = this.czg;
            this.czg = this.mAdapter.getCount();
            aiY();
            this.cwV = new AbsHListView.a();
            this.mAdapter.registerDataSetObserver(this.cwV);
            this.cxa.jP(this.mAdapter.getViewTypeCount());
            if (this.cxv) {
                C = C(this.czg - 1, false);
            } else {
                C = C(0, true);
            }
            setSelectedPositionInt(C);
            setNextSelectedPositionInt(C);
            if (this.czg == 0) {
                ajd();
            }
        } else {
            this.cAq = true;
            aiY();
            ajd();
        }
        requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView
    public void aiw() {
        V(this.zj);
        V(this.zk);
        super.aiw();
        this.cwU = 0;
    }

    private void V(ArrayList<b> arrayList) {
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                AbsHListView.f fVar = (AbsHListView.f) arrayList.get(i).view.getLayoutParams();
                if (fVar != null) {
                    fVar.cyq = false;
                }
            }
        }
    }

    private boolean ajq() {
        return this.bml > 0 || getChildAt(0).getLeft() > getScrollX() + this.cxf.left;
    }

    private boolean ajr() {
        int childCount = getChildCount();
        return (childCount + this.bml) + (-1) < this.czg + (-1) || getChildAt(childCount + (-1)).getRight() < (getScrollX() + getWidth()) - this.cxf.right;
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
        if (ajq() && (this.cgS > 0 || i4 > horizontalFadingEdgeLength)) {
            scrollX += horizontalFadingEdgeLength;
        }
        int right = getChildAt(getChildCount() - 1).getRight();
        if (ajr() && (this.cgS < this.czg - 1 || rect.right < right - horizontalFadingEdgeLength)) {
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
            this.cxu = view.getTop();
            invalidate();
        }
        return z2;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView
    protected void eJ(boolean z) {
        int childCount = getChildCount();
        if (z) {
            aA(childCount + this.bml, childCount > 0 ? getChildAt(childCount - 1).getRight() + this.cAi : 0);
            kd(getChildCount());
            return;
        }
        aB(this.bml - 1, childCount > 0 ? getChildAt(0).getLeft() - this.cAi : getWidth() - 0);
        ke(getChildCount());
    }

    private View aA(int i, int i2) {
        View view = null;
        int right = getRight() - getLeft();
        int i3 = i2;
        int i4 = i;
        while (i3 < right && i4 < this.czg) {
            boolean z = i4 == this.cgS;
            View a2 = a(i4, i3, true, this.cxf.top, z);
            i3 = a2.getRight() + this.cAi;
            if (!z) {
                a2 = view;
            }
            i4++;
            view = a2;
        }
        ax(this.bml, (this.bml + getChildCount()) - 1);
        return view;
    }

    private View aB(int i, int i2) {
        View view = null;
        int i3 = i2;
        int i4 = i;
        while (i3 > 0 && i4 >= 0) {
            boolean z = i4 == this.cgS;
            View a2 = a(i4, i3, false, this.cxf.top, z);
            i3 = a2.getLeft() - this.cAi;
            if (!z) {
                a2 = view;
            }
            i4--;
            view = a2;
        }
        this.bml = i4 + 1;
        ax(this.bml, (this.bml + getChildCount()) - 1);
        return view;
    }

    private View kc(int i) {
        this.bml = Math.min(this.bml, this.cgS);
        this.bml = Math.min(this.bml, this.czg - 1);
        if (this.bml < 0) {
            this.bml = 0;
        }
        return aA(this.bml, i);
    }

    private View aC(int i, int i2) {
        int i3 = i2 - i;
        int aiJ = aiJ();
        View a2 = a(aiJ, i, true, this.cxf.top, true);
        this.bml = aiJ;
        int measuredWidth = a2.getMeasuredWidth();
        if (measuredWidth <= i3) {
            a2.offsetLeftAndRight((i3 - measuredWidth) / 2);
        }
        t(a2, aiJ);
        if (!this.cxv) {
            kd(getChildCount());
        } else {
            ke(getChildCount());
        }
        return a2;
    }

    private void t(View view, int i) {
        int i2 = this.cAi;
        if (!this.cxv) {
            aB(i - 1, view.getLeft() - i2);
            ajp();
            aA(i + 1, i2 + view.getRight());
            return;
        }
        aA(i + 1, view.getRight() + i2);
        ajp();
        aB(i - 1, view.getLeft() - i2);
    }

    private View u(int i, int i2, int i3) {
        int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
        int i4 = this.cgS;
        int w = w(i2, horizontalFadingEdgeLength, i4);
        int v = v(i3, horizontalFadingEdgeLength, i4);
        View a2 = a(i4, i, true, this.cxf.top, true);
        if (a2.getRight() > v) {
            a2.offsetLeftAndRight(-Math.min(a2.getLeft() - w, a2.getRight() - v));
        } else if (a2.getLeft() < w) {
            a2.offsetLeftAndRight(Math.min(w - a2.getLeft(), v - a2.getRight()));
        }
        t(a2, i4);
        if (!this.cxv) {
            kd(getChildCount());
        } else {
            ke(getChildCount());
        }
        return a2;
    }

    private int v(int i, int i2, int i3) {
        if (i3 != this.czg - 1) {
            return i - i2;
        }
        return i;
    }

    private int w(int i, int i2, int i3) {
        if (i3 > 0) {
            return i + i2;
        }
        return i;
    }

    private View a(View view, View view2, int i, int i2, int i3) {
        View a2;
        int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
        int i4 = this.cgS;
        int w = w(i2, horizontalFadingEdgeLength, i4);
        int v = v(i2, horizontalFadingEdgeLength, i4);
        if (i > 0) {
            View a3 = a(i4 - 1, view.getLeft(), true, this.cxf.top, false);
            int i5 = this.cAi;
            a2 = a(i4, a3.getRight() + i5, true, this.cxf.top, true);
            if (a2.getRight() > v) {
                int min = Math.min(Math.min(a2.getLeft() - w, a2.getRight() - v), (i3 - i2) / 2);
                a3.offsetLeftAndRight(-min);
                a2.offsetLeftAndRight(-min);
            }
            if (!this.cxv) {
                aB(this.cgS - 2, a2.getLeft() - i5);
                ajp();
                aA(this.cgS + 1, a2.getRight() + i5);
            } else {
                aA(this.cgS + 1, a2.getRight() + i5);
                ajp();
                aB(this.cgS - 2, a2.getLeft() - i5);
            }
        } else if (i < 0) {
            if (view2 != null) {
                a2 = a(i4, view2.getLeft(), true, this.cxf.top, true);
            } else {
                a2 = a(i4, view.getLeft(), false, this.cxf.top, true);
            }
            if (a2.getLeft() < w) {
                a2.offsetLeftAndRight(Math.min(Math.min(w - a2.getLeft(), v - a2.getRight()), (i3 - i2) / 2));
            }
            t(a2, i4);
        } else {
            int left = view.getLeft();
            a2 = a(i4, left, true, this.cxf.top, true);
            if (left < i2 && a2.getRight() < i2 + 20) {
                a2.offsetLeftAndRight(i2 - a2.getLeft());
            }
            t(a2, i4);
        }
        return a2;
    }

    /* loaded from: classes.dex */
    private class c implements Runnable {
        private int alw;
        private int cAw;

        private c() {
        }

        /* synthetic */ c(HListView hListView, c cVar) {
            this();
        }

        public c aH(int i, int i2) {
            this.alw = i;
            this.cAw = i2;
            return this;
        }

        @Override // java.lang.Runnable
        public void run() {
            HListView.this.aE(this.alw, this.cAw);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        View focusedChild;
        if (getChildCount() > 0 && (focusedChild = getFocusedChild()) != null) {
            int indexOfChild = this.bml + indexOfChild(focusedChild);
            int left = focusedChild.getLeft() - Math.max(0, focusedChild.getRight() - (i - getPaddingLeft()));
            if (this.cAu == null) {
                this.cAu = new c(this, null);
            }
            post(this.cAu.aH(indexOfChild, left));
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
        this.czg = this.mAdapter == null ? 0 : this.mAdapter.getCount();
        if (this.czg > 0 && (mode == 0 || mode2 == 0)) {
            View b2 = b(0, this.cxP);
            h(b2, 0, i2);
            i4 = b2.getMeasuredWidth();
            i5 = b2.getMeasuredHeight();
            r1 = Build.VERSION.SDK_INT >= 11 ? combineMeasuredStates(0, b2.getMeasuredState()) : 0;
            if (ajs() && this.cxa.jQ(((AbsHListView.f) b2.getLayoutParams()).cyp)) {
                this.cxa.s(b2, -1);
            }
        }
        int i6 = i5;
        int i7 = i4;
        if (mode2 == 0) {
            i3 = i6 + this.cxf.top + this.cxf.bottom + getHorizontalScrollbarHeight();
        } else if (mode2 == Integer.MIN_VALUE && this.czg > 0 && this.cAj > -1) {
            i3 = d(i2, this.cAj, this.cAj, size, size2, -1)[1];
        } else {
            i3 = Build.VERSION.SDK_INT >= 11 ? size2 | ((-16777216) & r1) : size2;
        }
        if (mode == 0) {
            size = this.cxf.left + this.cxf.right + i7 + (getHorizontalFadingEdgeLength() * 2);
        }
        if (mode == Integer.MIN_VALUE) {
            size = d(i2, 0, -1, size, -1);
        }
        setMeasuredDimension(size, i3);
        this.cxg = i2;
    }

    private void h(View view, int i, int i2) {
        int makeMeasureSpec;
        AbsHListView.f fVar = (AbsHListView.f) view.getLayoutParams();
        if (fVar == null) {
            fVar = (AbsHListView.f) generateDefaultLayoutParams();
            view.setLayoutParams(fVar);
        }
        fVar.cyp = this.mAdapter.getItemViewType(i);
        fVar.cyr = true;
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, this.cxf.top + this.cxf.bottom, fVar.height);
        int i3 = fVar.width;
        if (i3 > 0) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(makeMeasureSpec, childMeasureSpec);
    }

    @ViewDebug.ExportedProperty(category = IntentConfig.LIST)
    protected boolean ajs() {
        return true;
    }

    final int d(int i, int i2, int i3, int i4, int i5) {
        int i6 = 0;
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter == null) {
            return this.cxf.left + this.cxf.right;
        }
        int i7 = this.cxf.left + this.cxf.right;
        int i8 = (this.cAi <= 0 || this.cAh == null) ? 0 : this.cAi;
        if (i3 == -1) {
            i3 = listAdapter.getCount() - 1;
        }
        AbsHListView.k kVar = this.cxa;
        boolean ajs = ajs();
        boolean[] zArr = this.cxP;
        while (i2 <= i3) {
            View b2 = b(i2, zArr);
            h(b2, i2, i);
            int i9 = i2 > 0 ? i7 + i8 : i7;
            if (ajs && kVar.jQ(((AbsHListView.f) b2.getLayoutParams()).cyp)) {
                kVar.s(b2, -1);
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
            return new int[]{this.cxf.left + this.cxf.right, this.cxf.top + this.cxf.bottom};
        }
        int i7 = this.cxf.left + this.cxf.right;
        int i8 = this.cxf.top + this.cxf.bottom;
        int i9 = (this.cAi <= 0 || this.cAh == null) ? 0 : this.cAi;
        if (i3 == -1) {
            i3 = listAdapter.getCount() - 1;
        }
        AbsHListView.k kVar = this.cxa;
        boolean ajs = ajs();
        boolean[] zArr = this.cxP;
        int i10 = 0;
        int i11 = 0;
        while (i2 <= i3) {
            View b2 = b(i2, zArr);
            h(b2, i2, i);
            if (ajs && kVar.jQ(((AbsHListView.f) b2.getLayoutParams()).cyp)) {
                kVar.s(b2, -1);
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
            if (this.cxv) {
                for (int i2 = childCount - 1; i2 >= 0; i2--) {
                    if (i >= getChildAt(i2).getLeft()) {
                        return i2 + this.bml;
                    }
                }
            } else {
                for (int i3 = 0; i3 < childCount; i3++) {
                    if (i <= getChildAt(i3).getRight()) {
                        return i3 + this.bml;
                    }
                }
            }
        }
        return -1;
    }

    private View aD(int i, int i2) {
        View aA;
        View aB;
        boolean z = i == this.cgS;
        View a2 = a(i, i2, true, this.cxf.top, z);
        this.bml = i;
        int i3 = this.cAi;
        if (!this.cxv) {
            aB = aB(i - 1, a2.getLeft() - i3);
            ajp();
            aA = aA(i + 1, i3 + a2.getRight());
            int childCount = getChildCount();
            if (childCount > 0) {
                kd(childCount);
            }
        } else {
            aA = aA(i + 1, a2.getRight() + i3);
            ajp();
            aB = aB(i - 1, a2.getLeft() - i3);
            int childCount2 = getChildCount();
            if (childCount2 > 0) {
                ke(childCount2);
            }
        }
        if (z) {
            return a2;
        }
        return aB != null ? aB : aA;
    }

    private void kd(int i) {
        if ((this.bml + i) - 1 == this.czg - 1 && i > 0) {
            int right = ((getRight() - getLeft()) - this.cxf.right) - getChildAt(i - 1).getRight();
            View childAt = getChildAt(0);
            int left = childAt.getLeft();
            if (right > 0) {
                if (this.bml > 0 || left < this.cxf.top) {
                    if (this.bml == 0) {
                        right = Math.min(right, this.cxf.top - left);
                    }
                    jJ(right);
                    if (this.bml > 0) {
                        aB(this.bml - 1, childAt.getLeft() - this.cAi);
                        ajp();
                    }
                }
            }
        }
    }

    private void ke(int i) {
        if (this.bml == 0 && i > 0) {
            int left = getChildAt(0).getLeft();
            int i2 = this.cxf.left;
            int right = (getRight() - getLeft()) - this.cxf.right;
            int i3 = left - i2;
            View childAt = getChildAt(i - 1);
            int right2 = childAt.getRight();
            int i4 = (this.bml + i) - 1;
            if (i3 > 0) {
                if (i4 < this.czg - 1 || right2 > right) {
                    if (i4 == this.czg - 1) {
                        i3 = Math.min(i3, right2 - right);
                    }
                    jJ(-i3);
                    if (i4 < this.czg - 1) {
                        aA(i4 + 1, childAt.getRight() + this.cAi);
                        ajp();
                    }
                } else if (i4 == this.czg - 1) {
                    ajp();
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
        boolean z = this.czo;
        if (z) {
            return;
        }
        this.czo = true;
        try {
            super.layoutChildren();
            invalidate();
            if (this.mAdapter == null) {
                aiw();
                ait();
                if (z) {
                    return;
                }
                return;
            }
            int i = this.cxf.left;
            int right = (getRight() - getLeft()) - this.cxf.right;
            int childCount = getChildCount();
            View view4 = null;
            View view5 = null;
            View view6 = null;
            switch (this.cwU) {
                case 1:
                case 3:
                case 4:
                case 5:
                    view = null;
                    break;
                case 2:
                    int i2 = this.czd - this.bml;
                    if (i2 < 0 || i2 >= childCount) {
                        view = null;
                        break;
                    } else {
                        view5 = getChildAt(i2);
                        view = null;
                        break;
                    }
                default:
                    int i3 = this.cgS - this.bml;
                    if (i3 >= 0 && i3 < childCount) {
                        view4 = getChildAt(i3);
                    }
                    View childAt = getChildAt(0);
                    r4 = this.czd >= 0 ? this.czd - this.cgS : 0;
                    view5 = getChildAt(i3 + r4);
                    view = childAt;
                    break;
            }
            boolean z2 = this.abK;
            if (z2) {
                handleDataChanged();
            }
            if (this.czg == 0) {
                aiw();
                ait();
                if (z) {
                    return;
                }
                this.czo = false;
            } else if (this.czg != this.mAdapter.getCount()) {
                throw new IllegalStateException("The content of the adapter has changed but ListView did not receive a notification. Make sure the content of your adapter is not modified from a background thread, but only from the UI thread. [in ListView(" + getId() + ", " + getClass() + ") with Adapter(" + this.mAdapter.getClass() + ")]");
            } else {
                setSelectedPositionInt(this.czd);
                int i4 = this.bml;
                AbsHListView.k kVar = this.cxa;
                View view7 = null;
                if (z2) {
                    for (int i5 = 0; i5 < childCount; i5++) {
                        kVar.s(getChildAt(i5), i4 + i5);
                    }
                } else {
                    kVar.az(childCount, i4);
                }
                View focusedChild = getFocusedChild();
                if (focusedChild != null) {
                    if (!z2 || aw(focusedChild)) {
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
                kVar.aiT();
                switch (this.cwU) {
                    case 1:
                        this.bml = 0;
                        View kc = kc(i);
                        ajp();
                        a2 = kc;
                        break;
                    case 2:
                        if (view5 != null) {
                            a2 = u(view5.getLeft(), i, right);
                            break;
                        } else {
                            a2 = aC(i, right);
                            break;
                        }
                    case 3:
                        View aB = aB(this.czg - 1, right);
                        ajp();
                        a2 = aB;
                        break;
                    case 4:
                        a2 = aD(aiJ(), this.cyU);
                        break;
                    case 5:
                        a2 = aD(this.cyV, this.cyU);
                        break;
                    case 6:
                        a2 = a(view4, view5, r4, i, right);
                        break;
                    default:
                        if (childCount == 0) {
                            if (this.cxv) {
                                setSelectedPositionInt(C(this.czg - 1, false));
                                a2 = aB(this.czg - 1, right);
                                break;
                            } else {
                                setSelectedPositionInt(C(0, true));
                                a2 = kc(i);
                                break;
                            }
                        } else if (this.cgS < 0 || this.cgS >= this.czg) {
                            if (this.bml < this.czg) {
                                int i6 = this.bml;
                                if (view != null) {
                                    i = view.getLeft();
                                }
                                a2 = aD(i6, i);
                                break;
                            } else {
                                a2 = aD(0, i);
                                break;
                            }
                        } else {
                            int i7 = this.cgS;
                            if (view4 != null) {
                                i = view4.getLeft();
                            }
                            a2 = aD(i7, i);
                            break;
                        }
                }
                kVar.aiU();
                if (a2 != null) {
                    if (!this.cAr || !hasFocus() || a2.hasFocus()) {
                        b(-1, a2);
                    } else if ((a2 == view3 && view2 != null && view2.requestFocus()) || a2.requestFocus()) {
                        a2.setSelected(false);
                        this.cwZ.setEmpty();
                    } else {
                        View focusedChild2 = getFocusedChild();
                        if (focusedChild2 != null) {
                            focusedChild2.clearFocus();
                        }
                        b(-1, a2);
                    }
                    this.cxu = a2.getLeft();
                } else {
                    if (this.mTouchMode <= 0 || this.mTouchMode >= 3) {
                        this.cxu = 0;
                        this.cwZ.setEmpty();
                    } else {
                        View childAt2 = getChildAt(this.cxl - this.bml);
                        if (childAt2 != null) {
                            b(this.cxl, childAt2);
                        }
                    }
                    if (hasFocus() && view2 != null) {
                        view2.requestFocus();
                    }
                }
                if (view2 != null && view2.getWindowToken() != null) {
                    view2.onFinishTemporaryDetach();
                }
                this.cwU = 0;
                this.abK = false;
                if (this.cxN != null) {
                    post(this.cxN);
                    this.cxN = null;
                }
                this.cyY = false;
                setNextSelectedPositionInt(this.cgS);
                aix();
                if (this.czg > 0) {
                    ajd();
                }
                ait();
                if (z) {
                    return;
                }
                this.czo = false;
            }
        } finally {
            if (!z) {
                this.czo = false;
            }
        }
    }

    private boolean aw(View view) {
        ArrayList<b> arrayList = this.zj;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (view == arrayList.get(i).view) {
                return true;
            }
        }
        ArrayList<b> arrayList2 = this.zk;
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
        if (!this.abK && (jR = this.cxa.jR(i)) != null) {
            a(jR, i, i2, z, i3, z2, true);
            return jR;
        }
        View b2 = b(i, this.cxP);
        a(b2, i, i2, z, i3, z2, this.cxP[0]);
        return b2;
    }

    private void a(View view, int i, int i2, boolean z, int i3, boolean z2, boolean z3) {
        int makeMeasureSpec;
        boolean z4 = z2 && aiz();
        boolean isSelected = z4 ^ view.isSelected();
        int i4 = this.mTouchMode;
        boolean z5 = i4 > 0 && i4 < 3 && this.cxl == i;
        boolean isPressed = z5 ^ view.isPressed();
        boolean z6 = !z3 || isSelected || view.isLayoutRequested();
        AbsHListView.f fVar = (AbsHListView.f) view.getLayoutParams();
        AbsHListView.f fVar2 = fVar == null ? (AbsHListView.f) generateDefaultLayoutParams() : fVar;
        fVar2.cyp = this.mAdapter.getItemViewType(i);
        if ((z3 && !fVar2.cyr) || (fVar2.cyq && fVar2.cyp == -2)) {
            attachViewToParent(view, z ? -1 : 0, fVar2);
        } else {
            fVar2.cyr = false;
            if (fVar2.cyp == -2) {
                fVar2.cyq = true;
            }
            addViewInLayout(view, z ? -1 : 0, fVar2, true);
        }
        if (isSelected) {
            view.setSelected(z4);
        }
        if (isPressed) {
            view.setPressed(z5);
        }
        if (this.cwO != 0 && this.cwS != null) {
            if (view instanceof Checkable) {
                ((Checkable) view).setChecked(this.cwS.get(i, false).booleanValue());
            } else if (Build.VERSION.SDK_INT >= 11) {
                view.setActivated(this.cwS.get(i, false).booleanValue());
            }
        }
        if (z6) {
            int childMeasureSpec = ViewGroup.getChildMeasureSpec(this.cxg, this.cxf.top + this.cxf.bottom, fVar2.height);
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
        if (this.cxj && !view.isDrawingCacheEnabled()) {
            view.setDrawingCacheEnabled(true);
        }
        if (Build.VERSION.SDK_INT >= 11 && z3 && ((AbsHListView.f) view.getLayoutParams()).cys != i) {
            view.jumpDrawablesToCurrentState();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.g, android.view.ViewGroup
    public boolean canAnimate() {
        return super.canAnimate() && this.czg > 0;
    }

    @Override // com.baidu.tieba.horizonalList.widget.g
    public void setSelection(int i) {
        aE(i, 0);
    }

    public void aE(int i, int i2) {
        if (this.mAdapter != null) {
            if (!isInTouchMode()) {
                i = C(i, true);
                if (i >= 0) {
                    setNextSelectedPositionInt(i);
                }
            } else {
                this.cxz = i;
            }
            if (i >= 0) {
                this.cwU = 4;
                this.cyU = this.cxf.left + i2;
                if (this.cyY) {
                    this.cyV = i;
                    this.cyW = this.mAdapter.getItemId(i);
                }
                if (this.cxt != null) {
                    this.cxt.stop();
                }
                requestLayout();
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView
    public void setSelectionInt(int i) {
        boolean z = true;
        setNextSelectedPositionInt(i);
        int i2 = this.cgS;
        if (i2 < 0 || (i != i2 - 1 && i != i2 + 1)) {
            z = false;
        }
        if (this.cxt != null) {
            this.cxt.stop();
        }
        layoutChildren();
        if (z) {
            awakenScrollBars();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.g
    public int C(int i, boolean z) {
        int min;
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter == null || isInTouchMode()) {
            return -1;
        }
        int count = listAdapter.getCount();
        if (!this.cAq) {
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
        if (this.mAdapter == null || !this.cyc) {
            return false;
        }
        if (this.abK) {
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
                        z = aiK();
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
                        if (!aiK() && !fullScroll(33)) {
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
                        z = aiK();
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
                        if (!aiK() && !fullScroll(TransportMediator.KEYCODE_MEDIA_RECORD)) {
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
                        z = aiK();
                        if (!z && keyEvent.getRepeatCount() == 0 && getChildCount() > 0) {
                            aiA();
                            z = true;
                            break;
                        }
                    }
                    break;
                case BDLocation.TypeCriteriaException /* 62 */:
                    if (!keyEvent.hasNoModifiers() ? !keyEvent.hasModifiers(1) || aiK() || !pageScroll(33) : aiK() || !pageScroll(TransportMediator.KEYCODE_MEDIA_RECORD)) {
                    }
                    z = true;
                    break;
                case 92:
                    if (keyEvent.hasNoModifiers()) {
                        if (!aiK() && !pageScroll(33)) {
                            z = false;
                            break;
                        } else {
                            z = true;
                            break;
                        }
                    } else if (keyEvent.hasModifiers(2)) {
                        if (!aiK() && !fullScroll(33)) {
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
                        if (!aiK() && !pageScroll(TransportMediator.KEYCODE_MEDIA_RECORD)) {
                            z = false;
                            break;
                        } else {
                            z = true;
                            break;
                        }
                    } else if (keyEvent.hasModifiers(2)) {
                        if (!aiK() && !fullScroll(TransportMediator.KEYCODE_MEDIA_RECORD)) {
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
                        if (!aiK() && !fullScroll(33)) {
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
                        if (!aiK() && !fullScroll(TransportMediator.KEYCODE_MEDIA_RECORD)) {
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
        int C;
        if (i == 33) {
            i2 = Math.max(0, (this.cgS - getChildCount()) - 1);
            z = false;
        } else if (i != 130) {
            i2 = -1;
            z = false;
        } else {
            i2 = Math.min(this.czg - 1, (this.cgS + getChildCount()) - 1);
            z = true;
        }
        if (i2 < 0 || (C = C(i2, z)) < 0) {
            return false;
        }
        this.cwU = 4;
        this.cyU = getPaddingLeft() + getHorizontalFadingEdgeLength();
        if (z && C > this.czg - getChildCount()) {
            this.cwU = 3;
        }
        if (!z && C < getChildCount()) {
            this.cwU = 1;
        }
        setSelectionInt(C);
        ait();
        if (awakenScrollBars()) {
            return true;
        }
        invalidate();
        return true;
    }

    boolean fullScroll(int i) {
        boolean z = true;
        if (i == 33) {
            if (this.cgS != 0) {
                int C = C(0, true);
                if (C >= 0) {
                    this.cwU = 1;
                    setSelectionInt(C);
                    ait();
                }
            }
            z = false;
        } else {
            if (i == 130 && this.cgS < this.czg - 1) {
                int C2 = C(this.czg - 1, true);
                if (C2 >= 0) {
                    this.cwU = 3;
                    setSelectionInt(C2);
                    ait();
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
        if (this.cAr && childCount > 0 && this.cgS != -1 && (selectedView = getSelectedView()) != null && selectedView.hasFocus() && (selectedView instanceof ViewGroup)) {
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
        int i3 = this.cgS;
        int kh = kh(i);
        int aF = aF(i, kh);
        a ki = this.cAr ? ki(i) : null;
        if (ki != null) {
            kh = ki.aej();
            aF = ki.ajt();
        }
        boolean z = ki != null;
        if (kh != -1) {
            a(selectedView, i, kh, ki != null);
            setSelectedPositionInt(kh);
            setNextSelectedPositionInt(kh);
            view = getSelectedView();
            if (this.cAr && ki == null && (focusedChild = getFocusedChild()) != null) {
                focusedChild.clearFocus();
            }
            ajd();
            z = true;
            i2 = kh;
        } else {
            view = selectedView;
            i2 = i3;
        }
        if (aF > 0) {
            kj(i == 33 ? aF : -aF);
            z = true;
        }
        if (this.cAr && ki == null && view != null && view.hasFocus()) {
            View findFocus = view.findFocus();
            if (!a(findFocus, this) || aA(findFocus) > 0) {
                findFocus.clearFocus();
            }
        }
        if (kh != -1 || view == null || a(view, this)) {
            view2 = view;
        } else {
            aiI();
            this.cxz = -1;
            view2 = null;
        }
        if (z) {
            if (view2 != null) {
                b(i2, view2);
                this.cxu = view2.getLeft();
            }
            if (!awakenScrollBars()) {
                invalidate();
            }
            ait();
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
        int i4 = this.cgS - this.bml;
        int i5 = i2 - this.bml;
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
        ax(view);
        if (view.getMeasuredWidth() != width) {
            ay(view);
            int measuredWidth = view.getMeasuredWidth() - width;
            for (int i3 = i + 1; i3 < i2; i3++) {
                getChildAt(i3).offsetLeftAndRight(measuredWidth);
            }
        }
    }

    private void ax(View view) {
        int makeMeasureSpec;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-2, -1);
        }
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(this.cxg, this.cxf.top + this.cxf.bottom, layoutParams.height);
        int i = layoutParams.width;
        if (i > 0) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(makeMeasureSpec, childMeasureSpec);
    }

    private void ay(View view) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i = this.cxf.top;
        int left = view.getLeft();
        view.layout(left, i, measuredWidth + left, measuredHeight + i);
    }

    private int getArrowScrollPreviewLength() {
        return Math.max(2, getHorizontalFadingEdgeLength());
    }

    private int aF(int i, int i2) {
        int width = getWidth() - this.cxf.right;
        int i3 = this.cxf.left;
        int childCount = getChildCount();
        if (i == 130) {
            int i4 = childCount - 1;
            if (i2 != -1) {
                i4 = i2 - this.bml;
            }
            int i5 = this.bml + i4;
            View childAt = getChildAt(i4);
            int arrowScrollPreviewLength = i5 < this.czg + (-1) ? width - getArrowScrollPreviewLength() : width;
            if (childAt.getRight() <= arrowScrollPreviewLength) {
                return 0;
            }
            if (i2 == -1 || arrowScrollPreviewLength - childAt.getLeft() < getMaxScrollAmount()) {
                int right = childAt.getRight() - arrowScrollPreviewLength;
                if (this.bml + childCount == this.czg) {
                    right = Math.min(right, getChildAt(childCount - 1).getRight() - width);
                }
                return Math.min(right, getMaxScrollAmount());
            }
            return 0;
        }
        int i6 = i2 != -1 ? i2 - this.bml : 0;
        int i7 = this.bml + i6;
        View childAt2 = getChildAt(i6);
        int arrowScrollPreviewLength2 = i7 > 0 ? getArrowScrollPreviewLength() + i3 : i3;
        if (childAt2.getLeft() < arrowScrollPreviewLength2) {
            if (i2 == -1 || childAt2.getRight() - arrowScrollPreviewLength2 < getMaxScrollAmount()) {
                int left = arrowScrollPreviewLength2 - childAt2.getLeft();
                if (this.bml == 0) {
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
        private int cAv;
        private int cgS;

        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }

        void aG(int i, int i2) {
            this.cgS = i;
            this.cAv = i2;
        }

        public int aej() {
            return this.cgS;
        }

        public int ajt() {
            return this.cAv;
        }
    }

    private int kh(int i) {
        int i2 = this.bml;
        if (i == 130) {
            int i3 = this.cgS != -1 ? this.cgS + 1 : i2;
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
            int childCount2 = this.cgS != -1 ? this.cgS - 1 : (getChildCount() + i2) - 1;
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
                int arrowScrollPreviewLength = (this.bml > 0 ? getArrowScrollPreviewLength() : 0) + this.cxf.left;
                if (selectedView != null && selectedView.getLeft() > arrowScrollPreviewLength) {
                    arrowScrollPreviewLength = selectedView.getLeft();
                }
                this.mTempRect.set(arrowScrollPreviewLength, 0, arrowScrollPreviewLength, 0);
            } else {
                int width = (getWidth() - this.cxf.right) - ((this.bml + getChildCount()) + (-1) < this.czg ? getArrowScrollPreviewLength() : 0);
                if (selectedView != null && selectedView.getRight() < width) {
                    width = selectedView.getRight();
                }
                this.mTempRect.set(width, 0, width, 0);
            }
            findNextFocusFromRect = FocusFinder.getInstance().findNextFocusFromRect(this, this.mTempRect, i);
        }
        if (findNextFocusFromRect != null) {
            int az = az(findNextFocusFromRect);
            if (this.cgS != -1 && az != this.cgS && (kh = kh(i)) != -1 && ((i == 130 && kh < az) || (i == 33 && kh > az))) {
                return null;
            }
            int a2 = a(i, findNextFocusFromRect, az);
            int maxScrollAmount = getMaxScrollAmount();
            if (a2 < maxScrollAmount) {
                findNextFocusFromRect.requestFocus(i);
                this.cAt.aG(az, a2);
                return this.cAt;
            } else if (aA(findNextFocusFromRect) < maxScrollAmount) {
                findNextFocusFromRect.requestFocus(i);
                this.cAt.aG(az, maxScrollAmount);
                return this.cAt;
            }
        }
        return null;
    }

    private int az(View view) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (a(view, getChildAt(i))) {
                return i + this.bml;
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
            if (this.mTempRect.left >= this.cxf.left) {
                return 0;
            }
            int i3 = this.cxf.left - this.mTempRect.left;
            if (i2 > 0) {
                return i3 + getArrowScrollPreviewLength();
            }
            return i3;
        }
        int width = getWidth() - this.cxf.right;
        if (this.mTempRect.bottom <= width) {
            return 0;
        }
        int i4 = this.mTempRect.right - width;
        if (i2 < this.czg - 1) {
            return i4 + getArrowScrollPreviewLength();
        }
        return i4;
    }

    private int aA(View view) {
        view.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(view, this.mTempRect);
        int right = (getRight() - getLeft()) - this.cxf.right;
        if (this.mTempRect.right < this.cxf.left) {
            return this.cxf.left - this.mTempRect.right;
        }
        if (this.mTempRect.left <= right) {
            return 0;
        }
        return this.mTempRect.left - right;
    }

    private void kj(int i) {
        int i2;
        jJ(i);
        int width = getWidth() - this.cxf.right;
        int i3 = this.cxf.left;
        AbsHListView.k kVar = this.cxa;
        if (i < 0) {
            int childCount = getChildCount();
            View childAt = getChildAt(childCount - 1);
            while (childAt.getRight() < width && (this.bml + childCount) - 1 < this.czg - 1) {
                childAt = v(childAt, i2);
                childCount++;
            }
            if (childAt.getBottom() < width) {
                jJ(width - childAt.getRight());
            }
            View childAt2 = getChildAt(0);
            while (true) {
                View view = childAt2;
                if (view.getRight() < i3) {
                    if (kVar.jQ(((AbsHListView.f) view.getLayoutParams()).cyp)) {
                        detachViewFromParent(view);
                        kVar.s(view, this.bml);
                    } else {
                        removeViewInLayout(view);
                    }
                    childAt2 = getChildAt(0);
                    this.bml++;
                } else {
                    return;
                }
            }
        } else {
            View childAt3 = getChildAt(0);
            while (childAt3.getLeft() > i3 && this.bml > 0) {
                childAt3 = u(childAt3, this.bml);
                this.bml--;
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
                    if (kVar.jQ(((AbsHListView.f) view2.getLayoutParams()).cyp)) {
                        detachViewFromParent(view2);
                        kVar.s(view2, this.bml + i4);
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

    private View u(View view, int i) {
        int i2 = i - 1;
        View b2 = b(i2, this.cxP);
        a(b2, i2, view.getLeft() - this.cAi, false, this.cxf.top, false, this.cxP[0]);
        return b2;
    }

    private View v(View view, int i) {
        int i2 = i + 1;
        View b2 = b(i2, this.cxP);
        a(b2, i2, this.cAi + view.getRight(), true, this.cxf.top, false, this.cxP[0]);
        return b2;
    }

    public void setItemsCanFocus(boolean z) {
        this.cAr = z;
        if (!z) {
            setDescendantFocusability(393216);
        }
    }

    public boolean getItemsCanFocus() {
        return this.cAr;
    }

    @Override // android.view.View
    public boolean isOpaque() {
        boolean z = (this.cxk && this.cAm && this.cAn) || super.isOpaque();
        if (z) {
            int paddingLeft = this.cxf != null ? this.cxf.left : getPaddingLeft();
            View childAt = getChildAt(0);
            if (childAt == null || childAt.getLeft() > paddingLeft) {
                return false;
            }
            int width = getWidth() - (this.cxf != null ? this.cxf.right : getPaddingRight());
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
        this.cAm = z;
        if (z) {
            if (this.cAs == null) {
                this.cAs = new Paint();
            }
            this.cAs.setColor(i);
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
        if (this.cxj) {
            this.cxk = true;
        }
        int i = this.cAi;
        Drawable drawable = this.cAk;
        Drawable drawable2 = this.cAl;
        boolean z = drawable != null;
        boolean z2 = drawable2 != null;
        boolean z3 = i > 0 && this.cAh != null;
        if (z3 || z || z2) {
            Rect rect = this.mTempRect;
            rect.top = getPaddingTop();
            rect.bottom = (getBottom() - getTop()) - getPaddingBottom();
            int childCount = getChildCount();
            int size = this.zj.size();
            int i2 = this.czg;
            int size2 = (i2 - this.zk.size()) - 1;
            boolean z4 = this.cAo;
            boolean z5 = this.cAp;
            int i3 = this.bml;
            boolean z6 = this.cAq;
            ListAdapter listAdapter = this.mAdapter;
            boolean z7 = isOpaque() && !super.isOpaque();
            if (z7 && this.cAs == null && this.cAm) {
                this.cAs = new Paint();
                this.cAs.setColor(getCacheColorHint());
            }
            Paint paint = this.cAs;
            int scrollX = getScrollX() + ((getRight() - getLeft()) - 0);
            if (!this.cxv) {
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
        if (this.cxk) {
            this.cxk = false;
        }
        return drawChild;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Canvas canvas, Rect rect, int i) {
        Drawable drawable = this.cAh;
        drawable.setBounds(rect);
        drawable.draw(canvas);
    }

    public Drawable getDivider() {
        return this.cAh;
    }

    public void setDivider(Drawable drawable) {
        boolean z = false;
        if (drawable != null) {
            this.cAi = drawable.getIntrinsicWidth();
        } else {
            this.cAi = 0;
        }
        this.cAh = drawable;
        this.cAn = (drawable == null || drawable.getOpacity() == -1) ? true : true;
        requestLayout();
        invalidate();
    }

    public int getDividerWidth() {
        return this.cAi;
    }

    public void setDividerWidth(int i) {
        this.cAi = i;
        requestLayout();
        invalidate();
    }

    public void setHeaderDividersEnabled(boolean z) {
        this.cAo = z;
        invalidate();
    }

    public void setFooterDividersEnabled(boolean z) {
        this.cAp = z;
        invalidate();
    }

    public void setOverscrollHeader(Drawable drawable) {
        this.cAk = drawable;
        if (getScrollX() < 0) {
            invalidate();
        }
    }

    public Drawable getOverscrollHeader() {
        return this.cAk;
    }

    public void setOverscrollFooter(Drawable drawable) {
        this.cAl = drawable;
        invalidate();
    }

    public Drawable getOverscrollFooter() {
        return this.cAl;
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
            if (listAdapter.getCount() < getChildCount() + this.bml) {
                this.cwU = 0;
                layoutChildren();
            }
            Rect rect2 = this.mTempRect;
            int i6 = Integer.MAX_VALUE;
            int childCount = getChildCount();
            int i7 = this.bml;
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
            aE(this.bml + i5, i4);
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
        if (this.cwO != 0 && this.cwS != null && this.mAdapter != null) {
            SparseArrayCompat<Boolean> sparseArrayCompat = this.cwS;
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
