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
import com.baidu.tieba.t;
import java.util.ArrayList;
@RemoteViews.RemoteView
/* loaded from: classes.dex */
public class HListView extends AbsHListView {
    private ArrayList<b> By;
    private ArrayList<b> Bz;
    Drawable cLM;
    int cLN;
    int cLO;
    Drawable cLP;
    Drawable cLQ;
    private boolean cLR;
    private boolean cLS;
    private boolean cLT;
    private boolean cLU;
    private boolean cLV;
    private boolean cLW;
    private Paint cLX;
    private final a cLY;
    private c cLZ;
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
        this(context, attributeSet, t.c.hlv_listViewStyle);
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
        this.By = new ArrayList<>();
        this.Bz = new ArrayList<>();
        this.cLV = true;
        this.cLW = false;
        this.mTempRect = new Rect();
        this.cLY = new a(null);
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
        this.cLT = z;
        this.cLU = z2;
        this.cLO = i3;
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
    private void aod() {
        int right;
        int i = 0;
        int childCount = getChildCount();
        if (childCount > 0) {
            if (!this.cJa) {
                right = getChildAt(0).getLeft() - this.cIK.left;
                if (this.bxA != 0) {
                    right -= this.cLN;
                }
            } else {
                right = getChildAt(childCount - 1).getRight() - (getWidth() - this.cIK.right);
                if (childCount + this.bxA < this.cKL) {
                    right += this.cLN;
                }
            }
            if (i != 0) {
                km(-i);
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
        this.By.add(bVar);
        if (this.mAdapter != null && this.cIA != null) {
            this.cIA.onChanged();
        }
    }

    public void addHeaderView(View view) {
        addHeaderView(view, null, true);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView
    public int getHeaderViewsCount() {
        return this.By.size();
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView
    public int getFooterViewsCount() {
        return this.Bz.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.horizonalList.widget.g
    public ListAdapter getAdapter() {
        return this.mAdapter;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView
    public void setAdapter(ListAdapter listAdapter) {
        int C;
        if (this.mAdapter != null && this.cIA != null) {
            this.mAdapter.unregisterDataSetObserver(this.cIA);
        }
        ank();
        this.cIF.clear();
        if (this.By.size() > 0 || this.Bz.size() > 0) {
            this.mAdapter = new m(this.By, this.Bz, listAdapter);
        } else {
            this.mAdapter = listAdapter;
        }
        this.cKO = -1;
        this.cKP = Long.MIN_VALUE;
        super.setAdapter(listAdapter);
        if (this.mAdapter != null) {
            this.cLV = this.mAdapter.areAllItemsEnabled();
            this.cKM = this.cKL;
            this.cKL = this.mAdapter.getCount();
            anM();
            this.cIA = new AbsHListView.a();
            this.mAdapter.registerDataSetObserver(this.cIA);
            this.cIF.ks(this.mAdapter.getViewTypeCount());
            if (this.cJa) {
                C = C(this.cKL - 1, false);
            } else {
                C = C(0, true);
            }
            setSelectedPositionInt(C);
            setNextSelectedPositionInt(C);
            if (this.cKL == 0) {
                anR();
            }
        } else {
            this.cLV = true;
            anM();
            anR();
        }
        requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView
    public void ank() {
        V(this.By);
        V(this.Bz);
        super.ank();
        this.cIz = 0;
    }

    private void V(ArrayList<b> arrayList) {
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                AbsHListView.f fVar = (AbsHListView.f) arrayList.get(i).view.getLayoutParams();
                if (fVar != null) {
                    fVar.cJV = false;
                }
            }
        }
    }

    private boolean aoe() {
        return this.bxA > 0 || getChildAt(0).getLeft() > getScrollX() + this.cIK.left;
    }

    private boolean aof() {
        int childCount = getChildCount();
        return (childCount + this.bxA) + (-1) < this.cKL + (-1) || getChildAt(childCount + (-1)).getRight() < (getScrollX() + getWidth()) - this.cIK.right;
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
        if (aoe() && (this.csf > 0 || i4 > horizontalFadingEdgeLength)) {
            scrollX += horizontalFadingEdgeLength;
        }
        int right = getChildAt(getChildCount() - 1).getRight();
        if (aof() && (this.csf < this.cKL - 1 || rect.right < right - horizontalFadingEdgeLength)) {
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
            kM(-i);
            b(-1, view);
            this.cIZ = view.getTop();
            invalidate();
        }
        return z2;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView
    protected void ff(boolean z) {
        int childCount = getChildCount();
        if (z) {
            aE(childCount + this.bxA, childCount > 0 ? getChildAt(childCount - 1).getRight() + this.cLN : 0);
            kG(getChildCount());
            return;
        }
        aF(this.bxA - 1, childCount > 0 ? getChildAt(0).getLeft() - this.cLN : getWidth() - 0);
        kH(getChildCount());
    }

    private View aE(int i, int i2) {
        View view = null;
        int right = getRight() - getLeft();
        int i3 = i2;
        int i4 = i;
        while (i3 < right && i4 < this.cKL) {
            boolean z = i4 == this.csf;
            View a2 = a(i4, i3, true, this.cIK.top, z);
            i3 = a2.getRight() + this.cLN;
            if (!z) {
                a2 = view;
            }
            i4++;
            view = a2;
        }
        aB(this.bxA, (this.bxA + getChildCount()) - 1);
        return view;
    }

    private View aF(int i, int i2) {
        View view = null;
        int i3 = i2;
        int i4 = i;
        while (i3 > 0 && i4 >= 0) {
            boolean z = i4 == this.csf;
            View a2 = a(i4, i3, false, this.cIK.top, z);
            i3 = a2.getLeft() - this.cLN;
            if (!z) {
                a2 = view;
            }
            i4--;
            view = a2;
        }
        this.bxA = i4 + 1;
        aB(this.bxA, (this.bxA + getChildCount()) - 1);
        return view;
    }

    private View kF(int i) {
        this.bxA = Math.min(this.bxA, this.csf);
        this.bxA = Math.min(this.bxA, this.cKL - 1);
        if (this.bxA < 0) {
            this.bxA = 0;
        }
        return aE(this.bxA, i);
    }

    private View aG(int i, int i2) {
        int i3 = i2 - i;
        int anx = anx();
        View a2 = a(anx, i, true, this.cIK.top, true);
        this.bxA = anx;
        int measuredWidth = a2.getMeasuredWidth();
        if (measuredWidth <= i3) {
            a2.offsetLeftAndRight((i3 - measuredWidth) / 2);
        }
        t(a2, anx);
        if (!this.cJa) {
            kG(getChildCount());
        } else {
            kH(getChildCount());
        }
        return a2;
    }

    private void t(View view, int i) {
        int i2 = this.cLN;
        if (!this.cJa) {
            aF(i - 1, view.getLeft() - i2);
            aod();
            aE(i + 1, i2 + view.getRight());
            return;
        }
        aE(i + 1, view.getRight() + i2);
        aod();
        aF(i - 1, view.getLeft() - i2);
    }

    private View v(int i, int i2, int i3) {
        int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
        int i4 = this.csf;
        int x = x(i2, horizontalFadingEdgeLength, i4);
        int w = w(i3, horizontalFadingEdgeLength, i4);
        View a2 = a(i4, i, true, this.cIK.top, true);
        if (a2.getRight() > w) {
            a2.offsetLeftAndRight(-Math.min(a2.getLeft() - x, a2.getRight() - w));
        } else if (a2.getLeft() < x) {
            a2.offsetLeftAndRight(Math.min(x - a2.getLeft(), w - a2.getRight()));
        }
        t(a2, i4);
        if (!this.cJa) {
            kG(getChildCount());
        } else {
            kH(getChildCount());
        }
        return a2;
    }

    private int w(int i, int i2, int i3) {
        if (i3 != this.cKL - 1) {
            return i - i2;
        }
        return i;
    }

    private int x(int i, int i2, int i3) {
        if (i3 > 0) {
            return i + i2;
        }
        return i;
    }

    private View a(View view, View view2, int i, int i2, int i3) {
        View a2;
        int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
        int i4 = this.csf;
        int x = x(i2, horizontalFadingEdgeLength, i4);
        int w = w(i2, horizontalFadingEdgeLength, i4);
        if (i > 0) {
            View a3 = a(i4 - 1, view.getLeft(), true, this.cIK.top, false);
            int i5 = this.cLN;
            a2 = a(i4, a3.getRight() + i5, true, this.cIK.top, true);
            if (a2.getRight() > w) {
                int min = Math.min(Math.min(a2.getLeft() - x, a2.getRight() - w), (i3 - i2) / 2);
                a3.offsetLeftAndRight(-min);
                a2.offsetLeftAndRight(-min);
            }
            if (!this.cJa) {
                aF(this.csf - 2, a2.getLeft() - i5);
                aod();
                aE(this.csf + 1, a2.getRight() + i5);
            } else {
                aE(this.csf + 1, a2.getRight() + i5);
                aod();
                aF(this.csf - 2, a2.getLeft() - i5);
            }
        } else if (i < 0) {
            if (view2 != null) {
                a2 = a(i4, view2.getLeft(), true, this.cIK.top, true);
            } else {
                a2 = a(i4, view.getLeft(), false, this.cIK.top, true);
            }
            if (a2.getLeft() < x) {
                a2.offsetLeftAndRight(Math.min(Math.min(x - a2.getLeft(), w - a2.getRight()), (i3 - i2) / 2));
            }
            t(a2, i4);
        } else {
            int left = view.getLeft();
            a2 = a(i4, left, true, this.cIK.top, true);
            if (left < i2 && a2.getRight() < i2 + 20) {
                a2.offsetLeftAndRight(i2 - a2.getLeft());
            }
            t(a2, i4);
        }
        return a2;
    }

    /* loaded from: classes.dex */
    private class c implements Runnable {
        private int aoC;
        private int cMb;

        private c() {
        }

        /* synthetic */ c(HListView hListView, c cVar) {
            this();
        }

        public c aL(int i, int i2) {
            this.aoC = i;
            this.cMb = i2;
            return this;
        }

        @Override // java.lang.Runnable
        public void run() {
            HListView.this.aI(this.aoC, this.cMb);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        View focusedChild;
        if (getChildCount() > 0 && (focusedChild = getFocusedChild()) != null) {
            int indexOfChild = this.bxA + indexOfChild(focusedChild);
            int left = focusedChild.getLeft() - Math.max(0, focusedChild.getRight() - (i - getPaddingLeft()));
            if (this.cLZ == null) {
                this.cLZ = new c(this, null);
            }
            post(this.cLZ.aL(indexOfChild, left));
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
        this.cKL = this.mAdapter == null ? 0 : this.mAdapter.getCount();
        if (this.cKL > 0 && (mode == 0 || mode2 == 0)) {
            View b2 = b(0, this.cJu);
            h(b2, 0, i2);
            i4 = b2.getMeasuredWidth();
            i5 = b2.getMeasuredHeight();
            r1 = Build.VERSION.SDK_INT >= 11 ? combineMeasuredStates(0, b2.getMeasuredState()) : 0;
            if (aog() && this.cIF.kt(((AbsHListView.f) b2.getLayoutParams()).cJU)) {
                this.cIF.s(b2, -1);
            }
        }
        int i6 = i5;
        int i7 = i4;
        if (mode2 == 0) {
            i3 = i6 + this.cIK.top + this.cIK.bottom + getHorizontalScrollbarHeight();
        } else if (mode2 == Integer.MIN_VALUE && this.cKL > 0 && this.cLO > -1) {
            i3 = d(i2, this.cLO, this.cLO, size, size2, -1)[1];
        } else {
            i3 = Build.VERSION.SDK_INT >= 11 ? size2 | ((-16777216) & r1) : size2;
        }
        if (mode == 0) {
            size = this.cIK.left + this.cIK.right + i7 + (getHorizontalFadingEdgeLength() * 2);
        }
        if (mode == Integer.MIN_VALUE) {
            size = d(i2, 0, -1, size, -1);
        }
        setMeasuredDimension(size, i3);
        this.cIL = i2;
    }

    private void h(View view, int i, int i2) {
        int makeMeasureSpec;
        AbsHListView.f fVar = (AbsHListView.f) view.getLayoutParams();
        if (fVar == null) {
            fVar = (AbsHListView.f) generateDefaultLayoutParams();
            view.setLayoutParams(fVar);
        }
        fVar.cJU = this.mAdapter.getItemViewType(i);
        fVar.cJW = true;
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, this.cIK.top + this.cIK.bottom, fVar.height);
        int i3 = fVar.width;
        if (i3 > 0) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(makeMeasureSpec, childMeasureSpec);
    }

    @ViewDebug.ExportedProperty(category = IntentConfig.LIST)
    protected boolean aog() {
        return true;
    }

    final int d(int i, int i2, int i3, int i4, int i5) {
        int i6 = 0;
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter == null) {
            return this.cIK.left + this.cIK.right;
        }
        int i7 = this.cIK.left + this.cIK.right;
        int i8 = (this.cLN <= 0 || this.cLM == null) ? 0 : this.cLN;
        if (i3 == -1) {
            i3 = listAdapter.getCount() - 1;
        }
        AbsHListView.k kVar = this.cIF;
        boolean aog = aog();
        boolean[] zArr = this.cJu;
        while (i2 <= i3) {
            View b2 = b(i2, zArr);
            h(b2, i2, i);
            int i9 = i2 > 0 ? i7 + i8 : i7;
            if (aog && kVar.kt(((AbsHListView.f) b2.getLayoutParams()).cJU)) {
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
            return new int[]{this.cIK.left + this.cIK.right, this.cIK.top + this.cIK.bottom};
        }
        int i7 = this.cIK.left + this.cIK.right;
        int i8 = this.cIK.top + this.cIK.bottom;
        int i9 = (this.cLN <= 0 || this.cLM == null) ? 0 : this.cLN;
        if (i3 == -1) {
            i3 = listAdapter.getCount() - 1;
        }
        AbsHListView.k kVar = this.cIF;
        boolean aog = aog();
        boolean[] zArr = this.cJu;
        int i10 = 0;
        int i11 = 0;
        while (i2 <= i3) {
            View b2 = b(i2, zArr);
            h(b2, i2, i);
            if (aog && kVar.kt(((AbsHListView.f) b2.getLayoutParams()).cJU)) {
                kVar.s(b2, -1);
            }
            i10 = Math.max(i10, b2.getMeasuredWidth() + i9);
            i2++;
            i11 = Math.max(i11, b2.getMeasuredHeight());
        }
        return new int[]{Math.min(i10 + i7, i4), Math.min(i11 + i8, i5)};
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView
    protected int kn(int i) {
        int childCount = getChildCount();
        if (childCount > 0) {
            if (this.cJa) {
                for (int i2 = childCount - 1; i2 >= 0; i2--) {
                    if (i >= getChildAt(i2).getLeft()) {
                        return i2 + this.bxA;
                    }
                }
            } else {
                for (int i3 = 0; i3 < childCount; i3++) {
                    if (i <= getChildAt(i3).getRight()) {
                        return i3 + this.bxA;
                    }
                }
            }
        }
        return -1;
    }

    private View aH(int i, int i2) {
        View aE;
        View aF;
        boolean z = i == this.csf;
        View a2 = a(i, i2, true, this.cIK.top, z);
        this.bxA = i;
        int i3 = this.cLN;
        if (!this.cJa) {
            aF = aF(i - 1, a2.getLeft() - i3);
            aod();
            aE = aE(i + 1, i3 + a2.getRight());
            int childCount = getChildCount();
            if (childCount > 0) {
                kG(childCount);
            }
        } else {
            aE = aE(i + 1, a2.getRight() + i3);
            aod();
            aF = aF(i - 1, a2.getLeft() - i3);
            int childCount2 = getChildCount();
            if (childCount2 > 0) {
                kH(childCount2);
            }
        }
        if (z) {
            return a2;
        }
        return aF != null ? aF : aE;
    }

    private void kG(int i) {
        if ((this.bxA + i) - 1 == this.cKL - 1 && i > 0) {
            int right = ((getRight() - getLeft()) - this.cIK.right) - getChildAt(i - 1).getRight();
            View childAt = getChildAt(0);
            int left = childAt.getLeft();
            if (right > 0) {
                if (this.bxA > 0 || left < this.cIK.top) {
                    if (this.bxA == 0) {
                        right = Math.min(right, this.cIK.top - left);
                    }
                    km(right);
                    if (this.bxA > 0) {
                        aF(this.bxA - 1, childAt.getLeft() - this.cLN);
                        aod();
                    }
                }
            }
        }
    }

    private void kH(int i) {
        if (this.bxA == 0 && i > 0) {
            int left = getChildAt(0).getLeft();
            int i2 = this.cIK.left;
            int right = (getRight() - getLeft()) - this.cIK.right;
            int i3 = left - i2;
            View childAt = getChildAt(i - 1);
            int right2 = childAt.getRight();
            int i4 = (this.bxA + i) - 1;
            if (i3 > 0) {
                if (i4 < this.cKL - 1 || right2 > right) {
                    if (i4 == this.cKL - 1) {
                        i3 = Math.min(i3, right2 - right);
                    }
                    km(-i3);
                    if (i4 < this.cKL - 1) {
                        aE(i4 + 1, childAt.getRight() + this.cLN);
                        aod();
                    }
                } else if (i4 == this.cKL - 1) {
                    aod();
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
        boolean z = this.cKT;
        if (z) {
            return;
        }
        this.cKT = true;
        try {
            super.layoutChildren();
            invalidate();
            if (this.mAdapter == null) {
                ank();
                anh();
                if (z) {
                    return;
                }
                return;
            }
            int i = this.cIK.left;
            int right = (getRight() - getLeft()) - this.cIK.right;
            int childCount = getChildCount();
            View view4 = null;
            View view5 = null;
            View view6 = null;
            switch (this.cIz) {
                case 1:
                case 3:
                case 4:
                case 5:
                    view = null;
                    break;
                case 2:
                    int i2 = this.cKI - this.bxA;
                    if (i2 < 0 || i2 >= childCount) {
                        view = null;
                        break;
                    } else {
                        view5 = getChildAt(i2);
                        view = null;
                        break;
                    }
                default:
                    int i3 = this.csf - this.bxA;
                    if (i3 >= 0 && i3 < childCount) {
                        view4 = getChildAt(i3);
                    }
                    View childAt = getChildAt(0);
                    r4 = this.cKI >= 0 ? this.cKI - this.csf : 0;
                    view5 = getChildAt(i3 + r4);
                    view = childAt;
                    break;
            }
            boolean z2 = this.aeA;
            if (z2) {
                handleDataChanged();
            }
            if (this.cKL == 0) {
                ank();
                anh();
                if (z) {
                    return;
                }
                this.cKT = false;
            } else if (this.cKL != this.mAdapter.getCount()) {
                throw new IllegalStateException("The content of the adapter has changed but ListView did not receive a notification. Make sure the content of your adapter is not modified from a background thread, but only from the UI thread. [in ListView(" + getId() + ", " + getClass() + ") with Adapter(" + this.mAdapter.getClass() + ")]");
            } else {
                setSelectedPositionInt(this.cKI);
                int i4 = this.bxA;
                AbsHListView.k kVar = this.cIF;
                View view7 = null;
                if (z2) {
                    for (int i5 = 0; i5 < childCount; i5++) {
                        kVar.s(getChildAt(i5), i4 + i5);
                    }
                } else {
                    kVar.aD(childCount, i4);
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
                kVar.anH();
                switch (this.cIz) {
                    case 1:
                        this.bxA = 0;
                        View kF = kF(i);
                        aod();
                        a2 = kF;
                        break;
                    case 2:
                        if (view5 != null) {
                            a2 = v(view5.getLeft(), i, right);
                            break;
                        } else {
                            a2 = aG(i, right);
                            break;
                        }
                    case 3:
                        View aF = aF(this.cKL - 1, right);
                        aod();
                        a2 = aF;
                        break;
                    case 4:
                        a2 = aH(anx(), this.cKz);
                        break;
                    case 5:
                        a2 = aH(this.cKA, this.cKz);
                        break;
                    case 6:
                        a2 = a(view4, view5, r4, i, right);
                        break;
                    default:
                        if (childCount == 0) {
                            if (this.cJa) {
                                setSelectedPositionInt(C(this.cKL - 1, false));
                                a2 = aF(this.cKL - 1, right);
                                break;
                            } else {
                                setSelectedPositionInt(C(0, true));
                                a2 = kF(i);
                                break;
                            }
                        } else if (this.csf < 0 || this.csf >= this.cKL) {
                            if (this.bxA < this.cKL) {
                                int i6 = this.bxA;
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
                            int i7 = this.csf;
                            if (view4 != null) {
                                i = view4.getLeft();
                            }
                            a2 = aH(i7, i);
                            break;
                        }
                }
                kVar.anI();
                if (a2 != null) {
                    if (!this.cLW || !hasFocus() || a2.hasFocus()) {
                        b(-1, a2);
                    } else if ((a2 == view3 && view2 != null && view2.requestFocus()) || a2.requestFocus()) {
                        a2.setSelected(false);
                        this.cIE.setEmpty();
                    } else {
                        View focusedChild2 = getFocusedChild();
                        if (focusedChild2 != null) {
                            focusedChild2.clearFocus();
                        }
                        b(-1, a2);
                    }
                    this.cIZ = a2.getLeft();
                } else {
                    if (this.mTouchMode <= 0 || this.mTouchMode >= 3) {
                        this.cIZ = 0;
                        this.cIE.setEmpty();
                    } else {
                        View childAt2 = getChildAt(this.cIQ - this.bxA);
                        if (childAt2 != null) {
                            b(this.cIQ, childAt2);
                        }
                    }
                    if (hasFocus() && view2 != null) {
                        view2.requestFocus();
                    }
                }
                if (view2 != null && view2.getWindowToken() != null) {
                    view2.onFinishTemporaryDetach();
                }
                this.cIz = 0;
                this.aeA = false;
                if (this.cJs != null) {
                    post(this.cJs);
                    this.cJs = null;
                }
                this.cKD = false;
                setNextSelectedPositionInt(this.csf);
                anl();
                if (this.cKL > 0) {
                    anR();
                }
                anh();
                if (z) {
                    return;
                }
                this.cKT = false;
            }
        } finally {
            if (!z) {
                this.cKT = false;
            }
        }
    }

    private boolean aw(View view) {
        ArrayList<b> arrayList = this.By;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (view == arrayList.get(i).view) {
                return true;
            }
        }
        ArrayList<b> arrayList2 = this.Bz;
        int size2 = arrayList2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            if (view == arrayList2.get(i2).view) {
                return true;
            }
        }
        return false;
    }

    private View a(int i, int i2, boolean z, int i3, boolean z2) {
        View ku;
        if (!this.aeA && (ku = this.cIF.ku(i)) != null) {
            a(ku, i, i2, z, i3, z2, true);
            return ku;
        }
        View b2 = b(i, this.cJu);
        a(b2, i, i2, z, i3, z2, this.cJu[0]);
        return b2;
    }

    private void a(View view, int i, int i2, boolean z, int i3, boolean z2, boolean z3) {
        int makeMeasureSpec;
        boolean z4 = z2 && ann();
        boolean isSelected = z4 ^ view.isSelected();
        int i4 = this.mTouchMode;
        boolean z5 = i4 > 0 && i4 < 3 && this.cIQ == i;
        boolean isPressed = z5 ^ view.isPressed();
        boolean z6 = !z3 || isSelected || view.isLayoutRequested();
        AbsHListView.f fVar = (AbsHListView.f) view.getLayoutParams();
        AbsHListView.f fVar2 = fVar == null ? (AbsHListView.f) generateDefaultLayoutParams() : fVar;
        fVar2.cJU = this.mAdapter.getItemViewType(i);
        if ((z3 && !fVar2.cJW) || (fVar2.cJV && fVar2.cJU == -2)) {
            attachViewToParent(view, z ? -1 : 0, fVar2);
        } else {
            fVar2.cJW = false;
            if (fVar2.cJU == -2) {
                fVar2.cJV = true;
            }
            addViewInLayout(view, z ? -1 : 0, fVar2, true);
        }
        if (isSelected) {
            view.setSelected(z4);
        }
        if (isPressed) {
            view.setPressed(z5);
        }
        if (this.cIt != 0 && this.cIx != null) {
            if (view instanceof Checkable) {
                ((Checkable) view).setChecked(this.cIx.get(i, false).booleanValue());
            } else if (Build.VERSION.SDK_INT >= 11) {
                view.setActivated(this.cIx.get(i, false).booleanValue());
            }
        }
        if (z6) {
            int childMeasureSpec = ViewGroup.getChildMeasureSpec(this.cIL, this.cIK.top + this.cIK.bottom, fVar2.height);
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
        if (this.cIO && !view.isDrawingCacheEnabled()) {
            view.setDrawingCacheEnabled(true);
        }
        if (Build.VERSION.SDK_INT >= 11 && z3 && ((AbsHListView.f) view.getLayoutParams()).cJX != i) {
            view.jumpDrawablesToCurrentState();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.g, android.view.ViewGroup
    public boolean canAnimate() {
        return super.canAnimate() && this.cKL > 0;
    }

    @Override // com.baidu.tieba.horizonalList.widget.g
    public void setSelection(int i) {
        aI(i, 0);
    }

    public void aI(int i, int i2) {
        if (this.mAdapter != null) {
            if (!isInTouchMode()) {
                i = C(i, true);
                if (i >= 0) {
                    setNextSelectedPositionInt(i);
                }
            } else {
                this.cJe = i;
            }
            if (i >= 0) {
                this.cIz = 4;
                this.cKz = this.cIK.left + i2;
                if (this.cKD) {
                    this.cKA = i;
                    this.cKB = this.mAdapter.getItemId(i);
                }
                if (this.cIY != null) {
                    this.cIY.stop();
                }
                requestLayout();
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView
    public void setSelectionInt(int i) {
        boolean z = true;
        setNextSelectedPositionInt(i);
        int i2 = this.csf;
        if (i2 < 0 || (i != i2 - 1 && i != i2 + 1)) {
            z = false;
        }
        if (this.cIY != null) {
            this.cIY.stop();
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
        if (!this.cLV) {
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
        if (this.mAdapter == null || !this.cJH) {
            return false;
        }
        if (this.aeA) {
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
                        z = kI(33);
                        break;
                    }
                    break;
                case 20:
                    if (keyEvent.hasNoModifiers()) {
                        z = kI(TransportMediator.KEYCODE_MEDIA_RECORD);
                        break;
                    }
                    break;
                case 21:
                    if (keyEvent.hasNoModifiers()) {
                        z = any();
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
                        if (!any() && !fullScroll(33)) {
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
                        z = any();
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
                        if (!any() && !fullScroll(TransportMediator.KEYCODE_MEDIA_RECORD)) {
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
                        z = any();
                        if (!z && keyEvent.getRepeatCount() == 0 && getChildCount() > 0) {
                            ano();
                            z = true;
                            break;
                        }
                    }
                    break;
                case BDLocation.TypeCriteriaException /* 62 */:
                    if (!keyEvent.hasNoModifiers() ? !keyEvent.hasModifiers(1) || any() || !pageScroll(33) : any() || !pageScroll(TransportMediator.KEYCODE_MEDIA_RECORD)) {
                    }
                    z = true;
                    break;
                case 92:
                    if (keyEvent.hasNoModifiers()) {
                        if (!any() && !pageScroll(33)) {
                            z = false;
                            break;
                        } else {
                            z = true;
                            break;
                        }
                    } else if (keyEvent.hasModifiers(2)) {
                        if (!any() && !fullScroll(33)) {
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
                        if (!any() && !pageScroll(TransportMediator.KEYCODE_MEDIA_RECORD)) {
                            z = false;
                            break;
                        } else {
                            z = true;
                            break;
                        }
                    } else if (keyEvent.hasModifiers(2)) {
                        if (!any() && !fullScroll(TransportMediator.KEYCODE_MEDIA_RECORD)) {
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
                        if (!any() && !fullScroll(33)) {
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
                        if (!any() && !fullScroll(TransportMediator.KEYCODE_MEDIA_RECORD)) {
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
            i2 = Math.max(0, (this.csf - getChildCount()) - 1);
            z = false;
        } else if (i != 130) {
            i2 = -1;
            z = false;
        } else {
            i2 = Math.min(this.cKL - 1, (this.csf + getChildCount()) - 1);
            z = true;
        }
        if (i2 < 0 || (C = C(i2, z)) < 0) {
            return false;
        }
        this.cIz = 4;
        this.cKz = getPaddingLeft() + getHorizontalFadingEdgeLength();
        if (z && C > this.cKL - getChildCount()) {
            this.cIz = 3;
        }
        if (!z && C < getChildCount()) {
            this.cIz = 1;
        }
        setSelectionInt(C);
        anh();
        if (awakenScrollBars()) {
            return true;
        }
        invalidate();
        return true;
    }

    boolean fullScroll(int i) {
        boolean z = true;
        if (i == 33) {
            if (this.csf != 0) {
                int C = C(0, true);
                if (C >= 0) {
                    this.cIz = 1;
                    setSelectionInt(C);
                    anh();
                }
            }
            z = false;
        } else {
            if (i == 130 && this.csf < this.cKL - 1) {
                int C2 = C(this.cKL - 1, true);
                if (C2 >= 0) {
                    this.cIz = 3;
                    setSelectionInt(C2);
                    anh();
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

    private boolean kI(int i) {
        View selectedView;
        if (i != 33 && i != 130) {
            throw new IllegalArgumentException("direction must be one of {View.FOCUS_UP, View.FOCUS_DOWN}");
        }
        int childCount = getChildCount();
        if (this.cLW && childCount > 0 && this.csf != -1 && (selectedView = getSelectedView()) != null && selectedView.hasFocus() && (selectedView instanceof ViewGroup)) {
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
            boolean kJ = kJ(i);
            if (kJ) {
                playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
            }
            return kJ;
        } finally {
            this.mInLayout = false;
        }
    }

    private boolean kJ(int i) {
        View view;
        int i2;
        View view2;
        View focusedChild;
        if (getChildCount() <= 0) {
            return false;
        }
        View selectedView = getSelectedView();
        int i3 = this.csf;
        int kK = kK(i);
        int aJ = aJ(i, kK);
        a kL = this.cLW ? kL(i) : null;
        if (kL != null) {
            kK = kL.aiU();
            aJ = kL.aoh();
        }
        boolean z = kL != null;
        if (kK != -1) {
            a(selectedView, i, kK, kL != null);
            setSelectedPositionInt(kK);
            setNextSelectedPositionInt(kK);
            view = getSelectedView();
            if (this.cLW && kL == null && (focusedChild = getFocusedChild()) != null) {
                focusedChild.clearFocus();
            }
            anR();
            z = true;
            i2 = kK;
        } else {
            view = selectedView;
            i2 = i3;
        }
        if (aJ > 0) {
            kM(i == 33 ? aJ : -aJ);
            z = true;
        }
        if (this.cLW && kL == null && view != null && view.hasFocus()) {
            View findFocus = view.findFocus();
            if (!a(findFocus, this) || aA(findFocus) > 0) {
                findFocus.clearFocus();
            }
        }
        if (kK != -1 || view == null || a(view, this)) {
            view2 = view;
        } else {
            anw();
            this.cJe = -1;
            view2 = null;
        }
        if (z) {
            if (view2 != null) {
                b(i2, view2);
                this.cIZ = view2.getLeft();
            }
            if (!awakenScrollBars()) {
                invalidate();
            }
            anh();
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
        int i4 = this.csf - this.bxA;
        int i5 = i2 - this.bxA;
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
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(this.cIL, this.cIK.top + this.cIK.bottom, layoutParams.height);
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
        int i = this.cIK.top;
        int left = view.getLeft();
        view.layout(left, i, measuredWidth + left, measuredHeight + i);
    }

    private int getArrowScrollPreviewLength() {
        return Math.max(2, getHorizontalFadingEdgeLength());
    }

    private int aJ(int i, int i2) {
        int width = getWidth() - this.cIK.right;
        int i3 = this.cIK.left;
        int childCount = getChildCount();
        if (i == 130) {
            int i4 = childCount - 1;
            if (i2 != -1) {
                i4 = i2 - this.bxA;
            }
            int i5 = this.bxA + i4;
            View childAt = getChildAt(i4);
            int arrowScrollPreviewLength = i5 < this.cKL + (-1) ? width - getArrowScrollPreviewLength() : width;
            if (childAt.getRight() <= arrowScrollPreviewLength) {
                return 0;
            }
            if (i2 == -1 || arrowScrollPreviewLength - childAt.getLeft() < getMaxScrollAmount()) {
                int right = childAt.getRight() - arrowScrollPreviewLength;
                if (this.bxA + childCount == this.cKL) {
                    right = Math.min(right, getChildAt(childCount - 1).getRight() - width);
                }
                return Math.min(right, getMaxScrollAmount());
            }
            return 0;
        }
        int i6 = i2 != -1 ? i2 - this.bxA : 0;
        int i7 = this.bxA + i6;
        View childAt2 = getChildAt(i6);
        int arrowScrollPreviewLength2 = i7 > 0 ? getArrowScrollPreviewLength() + i3 : i3;
        if (childAt2.getLeft() < arrowScrollPreviewLength2) {
            if (i2 == -1 || childAt2.getRight() - arrowScrollPreviewLength2 < getMaxScrollAmount()) {
                int left = arrowScrollPreviewLength2 - childAt2.getLeft();
                if (this.bxA == 0) {
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
        private int cMa;
        private int csf;

        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }

        void aK(int i, int i2) {
            this.csf = i;
            this.cMa = i2;
        }

        public int aiU() {
            return this.csf;
        }

        public int aoh() {
            return this.cMa;
        }
    }

    private int kK(int i) {
        int i2 = this.bxA;
        if (i == 130) {
            int i3 = this.csf != -1 ? this.csf + 1 : i2;
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
            int childCount2 = this.csf != -1 ? this.csf - 1 : (getChildCount() + i2) - 1;
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

    private a kL(int i) {
        View findNextFocusFromRect;
        int kK;
        View selectedView = getSelectedView();
        if (selectedView != null && selectedView.hasFocus()) {
            findNextFocusFromRect = FocusFinder.getInstance().findNextFocus(this, selectedView.findFocus(), i);
        } else {
            if (i == 130) {
                int arrowScrollPreviewLength = (this.bxA > 0 ? getArrowScrollPreviewLength() : 0) + this.cIK.left;
                if (selectedView != null && selectedView.getLeft() > arrowScrollPreviewLength) {
                    arrowScrollPreviewLength = selectedView.getLeft();
                }
                this.mTempRect.set(arrowScrollPreviewLength, 0, arrowScrollPreviewLength, 0);
            } else {
                int width = (getWidth() - this.cIK.right) - ((this.bxA + getChildCount()) + (-1) < this.cKL ? getArrowScrollPreviewLength() : 0);
                if (selectedView != null && selectedView.getRight() < width) {
                    width = selectedView.getRight();
                }
                this.mTempRect.set(width, 0, width, 0);
            }
            findNextFocusFromRect = FocusFinder.getInstance().findNextFocusFromRect(this, this.mTempRect, i);
        }
        if (findNextFocusFromRect != null) {
            int az = az(findNextFocusFromRect);
            if (this.csf != -1 && az != this.csf && (kK = kK(i)) != -1 && ((i == 130 && kK < az) || (i == 33 && kK > az))) {
                return null;
            }
            int a2 = a(i, findNextFocusFromRect, az);
            int maxScrollAmount = getMaxScrollAmount();
            if (a2 < maxScrollAmount) {
                findNextFocusFromRect.requestFocus(i);
                this.cLY.aK(az, a2);
                return this.cLY;
            } else if (aA(findNextFocusFromRect) < maxScrollAmount) {
                findNextFocusFromRect.requestFocus(i);
                this.cLY.aK(az, maxScrollAmount);
                return this.cLY;
            }
        }
        return null;
    }

    private int az(View view) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (a(view, getChildAt(i))) {
                return i + this.bxA;
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
            if (this.mTempRect.left >= this.cIK.left) {
                return 0;
            }
            int i3 = this.cIK.left - this.mTempRect.left;
            if (i2 > 0) {
                return i3 + getArrowScrollPreviewLength();
            }
            return i3;
        }
        int width = getWidth() - this.cIK.right;
        if (this.mTempRect.bottom <= width) {
            return 0;
        }
        int i4 = this.mTempRect.right - width;
        if (i2 < this.cKL - 1) {
            return i4 + getArrowScrollPreviewLength();
        }
        return i4;
    }

    private int aA(View view) {
        view.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(view, this.mTempRect);
        int right = (getRight() - getLeft()) - this.cIK.right;
        if (this.mTempRect.right < this.cIK.left) {
            return this.cIK.left - this.mTempRect.right;
        }
        if (this.mTempRect.left <= right) {
            return 0;
        }
        return this.mTempRect.left - right;
    }

    private void kM(int i) {
        int i2;
        km(i);
        int width = getWidth() - this.cIK.right;
        int i3 = this.cIK.left;
        AbsHListView.k kVar = this.cIF;
        if (i < 0) {
            int childCount = getChildCount();
            View childAt = getChildAt(childCount - 1);
            while (childAt.getRight() < width && (this.bxA + childCount) - 1 < this.cKL - 1) {
                childAt = v(childAt, i2);
                childCount++;
            }
            if (childAt.getBottom() < width) {
                km(width - childAt.getRight());
            }
            View childAt2 = getChildAt(0);
            while (true) {
                View view = childAt2;
                if (view.getRight() < i3) {
                    if (kVar.kt(((AbsHListView.f) view.getLayoutParams()).cJU)) {
                        detachViewFromParent(view);
                        kVar.s(view, this.bxA);
                    } else {
                        removeViewInLayout(view);
                    }
                    childAt2 = getChildAt(0);
                    this.bxA++;
                } else {
                    return;
                }
            }
        } else {
            View childAt3 = getChildAt(0);
            while (childAt3.getLeft() > i3 && this.bxA > 0) {
                childAt3 = u(childAt3, this.bxA);
                this.bxA--;
            }
            if (childAt3.getLeft() > i3) {
                km(i3 - childAt3.getLeft());
            }
            int childCount2 = getChildCount() - 1;
            View childAt4 = getChildAt(childCount2);
            while (true) {
                int i4 = childCount2;
                View view2 = childAt4;
                if (view2.getLeft() > width) {
                    if (kVar.kt(((AbsHListView.f) view2.getLayoutParams()).cJU)) {
                        detachViewFromParent(view2);
                        kVar.s(view2, this.bxA + i4);
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
        View b2 = b(i2, this.cJu);
        a(b2, i2, view.getLeft() - this.cLN, false, this.cIK.top, false, this.cJu[0]);
        return b2;
    }

    private View v(View view, int i) {
        int i2 = i + 1;
        View b2 = b(i2, this.cJu);
        a(b2, i2, this.cLN + view.getRight(), true, this.cIK.top, false, this.cJu[0]);
        return b2;
    }

    public void setItemsCanFocus(boolean z) {
        this.cLW = z;
        if (!z) {
            setDescendantFocusability(393216);
        }
    }

    public boolean getItemsCanFocus() {
        return this.cLW;
    }

    @Override // android.view.View
    public boolean isOpaque() {
        boolean z = (this.cIP && this.cLR && this.cLS) || super.isOpaque();
        if (z) {
            int paddingLeft = this.cIK != null ? this.cIK.left : getPaddingLeft();
            View childAt = getChildAt(0);
            if (childAt == null || childAt.getLeft() > paddingLeft) {
                return false;
            }
            int width = getWidth() - (this.cIK != null ? this.cIK.right : getPaddingRight());
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
        this.cLR = z;
        if (z) {
            if (this.cLX == null) {
                this.cLX = new Paint();
            }
            this.cLX.setColor(i);
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
        if (this.cIO) {
            this.cIP = true;
        }
        int i = this.cLN;
        Drawable drawable = this.cLP;
        Drawable drawable2 = this.cLQ;
        boolean z = drawable != null;
        boolean z2 = drawable2 != null;
        boolean z3 = i > 0 && this.cLM != null;
        if (z3 || z || z2) {
            Rect rect = this.mTempRect;
            rect.top = getPaddingTop();
            rect.bottom = (getBottom() - getTop()) - getPaddingBottom();
            int childCount = getChildCount();
            int size = this.By.size();
            int i2 = this.cKL;
            int size2 = (i2 - this.Bz.size()) - 1;
            boolean z4 = this.cLT;
            boolean z5 = this.cLU;
            int i3 = this.bxA;
            boolean z6 = this.cLV;
            ListAdapter listAdapter = this.mAdapter;
            boolean z7 = isOpaque() && !super.isOpaque();
            if (z7 && this.cLX == null && this.cLR) {
                this.cLX = new Paint();
                this.cLX.setColor(getCacheColorHint());
            }
            Paint paint = this.cLX;
            int scrollX = getScrollX() + ((getRight() - getLeft()) - 0);
            if (!this.cJa) {
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
        if (this.cIP) {
            this.cIP = false;
        }
        return drawChild;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Canvas canvas, Rect rect, int i) {
        Drawable drawable = this.cLM;
        drawable.setBounds(rect);
        drawable.draw(canvas);
    }

    public Drawable getDivider() {
        return this.cLM;
    }

    public void setDivider(Drawable drawable) {
        boolean z = false;
        if (drawable != null) {
            this.cLN = drawable.getIntrinsicWidth();
        } else {
            this.cLN = 0;
        }
        this.cLM = drawable;
        this.cLS = (drawable == null || drawable.getOpacity() == -1) ? true : true;
        requestLayout();
        invalidate();
    }

    public int getDividerWidth() {
        return this.cLN;
    }

    public void setDividerWidth(int i) {
        this.cLN = i;
        requestLayout();
        invalidate();
    }

    public void setHeaderDividersEnabled(boolean z) {
        this.cLT = z;
        invalidate();
    }

    public void setFooterDividersEnabled(boolean z) {
        this.cLU = z;
        invalidate();
    }

    public void setOverscrollHeader(Drawable drawable) {
        this.cLP = drawable;
        if (getScrollX() < 0) {
            invalidate();
        }
    }

    public Drawable getOverscrollHeader() {
        return this.cLP;
    }

    public void setOverscrollFooter(Drawable drawable) {
        this.cLQ = drawable;
        invalidate();
    }

    public Drawable getOverscrollFooter() {
        return this.cLQ;
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
            if (listAdapter.getCount() < getChildCount() + this.bxA) {
                this.cIz = 0;
                layoutChildren();
            }
            Rect rect2 = this.mTempRect;
            int i6 = Integer.MAX_VALUE;
            int childCount = getChildCount();
            int i7 = this.bxA;
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
            aI(this.bxA + i5, i4);
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
        if (this.cIt != 0 && this.cIx != null && this.mAdapter != null) {
            SparseArrayCompat<Boolean> sparseArrayCompat = this.cIx;
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
