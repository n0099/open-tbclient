package com.baidu.tieba.horizonalList.widget;

import android.annotation.TargetApi;
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
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.d;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
import java.util.ArrayList;
@RemoteViews.RemoteView
/* loaded from: classes.dex */
public class HListView extends AbsHListView {
    private int BS;
    int bdO;
    int cWK;
    private final a cWL;
    private c cWM;
    private boolean mAreAllItemsSelectable;
    Drawable mDivider;
    private boolean mDividerIsOpaque;
    private Paint mDividerPaint;
    private boolean mFooterDividersEnabled;
    private ArrayList<b> mFooterViewInfos;
    private GestureDetector mGestureDetector;
    private boolean mHeaderDividersEnabled;
    private ArrayList<b> mHeaderViewInfos;
    private boolean mIsCacheColorOpaque;
    private boolean mItemsCanFocus;
    Drawable mOverScrollFooter;
    Drawable mOverScrollHeader;
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
        this(context, attributeSet, d.c.hlv_listViewStyle);
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
        this.mHeaderViewInfos = new ArrayList<>();
        this.mFooterViewInfos = new ArrayList<>();
        this.mAreAllItemsSelectable = true;
        this.mItemsCanFocus = false;
        this.mTempRect = new Rect();
        this.cWL = new a();
        this.BS = 0;
        this.mGestureDetector = new GestureDetector(new d());
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, d.n.HListView, i, 0);
        if (obtainStyledAttributes != null) {
            charSequenceArr = obtainStyledAttributes.getTextArray(d.n.HListView_android_entries);
            drawable3 = obtainStyledAttributes.getDrawable(d.n.HListView_android_divider);
            drawable2 = obtainStyledAttributes.getDrawable(d.n.HListView_hlv_overScrollHeader);
            drawable = obtainStyledAttributes.getDrawable(d.n.HListView_hlv_overScrollFooter);
            i2 = obtainStyledAttributes.getDimensionPixelSize(d.n.HListView_hlv_dividerWidth, 0);
            z = obtainStyledAttributes.getBoolean(d.n.HListView_hlv_headerDividersEnabled, true);
            z2 = obtainStyledAttributes.getBoolean(d.n.HListView_hlv_footerDividersEnabled, true);
            i3 = obtainStyledAttributes.getInteger(d.n.HListView_hlv_measureWithChild, -1);
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
        this.mHeaderDividersEnabled = z;
        this.mFooterDividersEnabled = z2;
        this.cWK = i3;
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
    private void api() {
        int right;
        int i = 0;
        int childCount = getChildCount();
        if (childCount > 0) {
            if (!this.cUr) {
                right = getChildAt(0).getLeft() - this.mListPadding.left;
                if (this.mFirstPosition != 0) {
                    right -= this.bdO;
                }
            } else {
                right = getChildAt(childCount - 1).getRight() - (getWidth() - this.mListPadding.right);
                if (childCount + this.mFirstPosition < this.mItemCount) {
                    right += this.bdO;
                }
            }
            if (i != 0) {
                kL(-i);
            }
        }
    }

    public void addHeaderView(View view, Object obj, boolean z) {
        if (this.mAdapter != null && !(this.mAdapter instanceof e)) {
            throw new IllegalStateException("Cannot add header view to list -- setAdapter has already been called.");
        }
        b bVar = new b();
        bVar.view = view;
        bVar.data = obj;
        bVar.isSelectable = z;
        this.mHeaderViewInfos.add(bVar);
        if (this.mAdapter != null && this.cUd != null) {
            this.cUd.onChanged();
        }
    }

    public void addHeaderView(View view) {
        addHeaderView(view, null, true);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView
    public int getHeaderViewsCount() {
        return this.mHeaderViewInfos.size();
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView
    public int getFooterViewsCount() {
        return this.mFooterViewInfos.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.horizonalList.widget.a
    public ListAdapter getAdapter() {
        return this.mAdapter;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.a
    public void setAdapter(ListAdapter listAdapter) {
        int lookForSelectablePosition;
        if (this.mAdapter != null && this.cUd != null) {
            this.mAdapter.unregisterDataSetObserver(this.cUd);
        }
        resetList();
        this.cUg.clear();
        if (this.mHeaderViewInfos.size() > 0 || this.mFooterViewInfos.size() > 0) {
            this.mAdapter = new e(this.mHeaderViewInfos, this.mFooterViewInfos, listAdapter);
        } else {
            this.mAdapter = listAdapter;
        }
        this.mOldSelectedPosition = -1;
        this.cVO = Long.MIN_VALUE;
        super.setAdapter(listAdapter);
        if (this.mAdapter != null) {
            this.mAreAllItemsSelectable = this.mAdapter.areAllItemsEnabled();
            this.mOldItemCount = this.mItemCount;
            this.mItemCount = this.mAdapter.getCount();
            aoY();
            this.cUd = new AbsHListView.a();
            this.mAdapter.registerDataSetObserver(this.cUd);
            this.cUg.kQ(this.mAdapter.getViewTypeCount());
            if (this.cUr) {
                lookForSelectablePosition = lookForSelectablePosition(this.mItemCount - 1, false);
            } else {
                lookForSelectablePosition = lookForSelectablePosition(0, true);
            }
            setSelectedPositionInt(lookForSelectablePosition);
            setNextSelectedPositionInt(lookForSelectablePosition);
            if (this.mItemCount == 0) {
                checkSelectionChanged();
            }
        } else {
            this.mAreAllItemsSelectable = true;
            aoY();
            checkSelectionChanged();
        }
        requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView
    public void resetList() {
        clearRecycledState(this.mHeaderViewInfos);
        clearRecycledState(this.mFooterViewInfos);
        super.resetList();
        this.mLayoutMode = 0;
    }

    private void clearRecycledState(ArrayList<b> arrayList) {
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                AbsHListView.f fVar = (AbsHListView.f) arrayList.get(i).view.getLayoutParams();
                if (fVar != null) {
                    fVar.cVa = false;
                }
            }
        }
    }

    private boolean apj() {
        return this.mFirstPosition > 0 || getChildAt(0).getLeft() > getScrollX() + this.mListPadding.left;
    }

    private boolean apk() {
        int childCount = getChildCount();
        return (childCount + this.mFirstPosition) + (-1) < this.mItemCount + (-1) || getChildAt(childCount + (-1)).getRight() < (getScrollX() + getWidth()) - this.mListPadding.right;
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
        if (apj() && (this.mSelectedPosition > 0 || i4 > horizontalFadingEdgeLength)) {
            scrollX += horizontalFadingEdgeLength;
        }
        int right = getChildAt(getChildCount() - 1).getRight();
        if (apk() && (this.mSelectedPosition < this.mItemCount - 1 || rect.right < right - horizontalFadingEdgeLength)) {
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
            scrollListItemsBy(-i);
            d(-1, view);
            this.cUq = view.getTop();
            invalidate();
        }
        return z2;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView
    protected void fillGap(boolean z) {
        int childCount = getChildCount();
        if (z) {
            aC(childCount + this.mFirstPosition, childCount > 0 ? getChildAt(childCount - 1).getRight() + this.bdO : 0);
            ld(getChildCount());
            return;
        }
        aD(this.mFirstPosition - 1, childCount > 0 ? getChildAt(0).getLeft() - this.bdO : getWidth() - 0);
        le(getChildCount());
    }

    private View aC(int i, int i2) {
        View view = null;
        int right = getRight() - getLeft();
        int i3 = i2;
        int i4 = i;
        while (i3 < right && i4 < this.mItemCount) {
            boolean z = i4 == this.mSelectedPosition;
            View a2 = a(i4, i3, true, this.mListPadding.top, z);
            i3 = a2.getRight() + this.bdO;
            if (!z) {
                a2 = view;
            }
            i4++;
            view = a2;
        }
        az(this.mFirstPosition, (this.mFirstPosition + getChildCount()) - 1);
        return view;
    }

    private View aD(int i, int i2) {
        View view = null;
        int i3 = i2;
        int i4 = i;
        while (i3 > 0 && i4 >= 0) {
            boolean z = i4 == this.mSelectedPosition;
            View a2 = a(i4, i3, false, this.mListPadding.top, z);
            i3 = a2.getLeft() - this.bdO;
            if (!z) {
                a2 = view;
            }
            i4--;
            view = a2;
        }
        this.mFirstPosition = i4 + 1;
        az(this.mFirstPosition, (this.mFirstPosition + getChildCount()) - 1);
        return view;
    }

    private View lc(int i) {
        this.mFirstPosition = Math.min(this.mFirstPosition, this.mSelectedPosition);
        this.mFirstPosition = Math.min(this.mFirstPosition, this.mItemCount - 1);
        if (this.mFirstPosition < 0) {
            this.mFirstPosition = 0;
        }
        return aC(this.mFirstPosition, i);
    }

    private View aE(int i, int i2) {
        int i3 = i2 - i;
        int reconcileSelectedPosition = reconcileSelectedPosition();
        View a2 = a(reconcileSelectedPosition, i, true, this.mListPadding.top, true);
        this.mFirstPosition = reconcileSelectedPosition;
        int measuredWidth = a2.getMeasuredWidth();
        if (measuredWidth <= i3) {
            a2.offsetLeftAndRight((i3 - measuredWidth) / 2);
        }
        s(a2, reconcileSelectedPosition);
        if (!this.cUr) {
            ld(getChildCount());
        } else {
            le(getChildCount());
        }
        return a2;
    }

    private void s(View view, int i) {
        int i2 = this.bdO;
        if (!this.cUr) {
            aD(i - 1, view.getLeft() - i2);
            api();
            aC(i + 1, i2 + view.getRight());
            return;
        }
        aC(i + 1, view.getRight() + i2);
        api();
        aD(i - 1, view.getLeft() - i2);
    }

    private View x(int i, int i2, int i3) {
        int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
        int i4 = this.mSelectedPosition;
        int z = z(i2, horizontalFadingEdgeLength, i4);
        int y = y(i3, horizontalFadingEdgeLength, i4);
        View a2 = a(i4, i, true, this.mListPadding.top, true);
        if (a2.getRight() > y) {
            a2.offsetLeftAndRight(-Math.min(a2.getLeft() - z, a2.getRight() - y));
        } else if (a2.getLeft() < z) {
            a2.offsetLeftAndRight(Math.min(z - a2.getLeft(), y - a2.getRight()));
        }
        s(a2, i4);
        if (!this.cUr) {
            ld(getChildCount());
        } else {
            le(getChildCount());
        }
        return a2;
    }

    private int y(int i, int i2, int i3) {
        if (i3 != this.mItemCount - 1) {
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
        int i4 = this.mSelectedPosition;
        int z = z(i2, horizontalFadingEdgeLength, i4);
        int y = y(i2, horizontalFadingEdgeLength, i4);
        if (i > 0) {
            View a3 = a(i4 - 1, view.getLeft(), true, this.mListPadding.top, false);
            int i5 = this.bdO;
            a2 = a(i4, a3.getRight() + i5, true, this.mListPadding.top, true);
            if (a2.getRight() > y) {
                int min = Math.min(Math.min(a2.getLeft() - z, a2.getRight() - y), (i3 - i2) / 2);
                a3.offsetLeftAndRight(-min);
                a2.offsetLeftAndRight(-min);
            }
            if (!this.cUr) {
                aD(this.mSelectedPosition - 2, a2.getLeft() - i5);
                api();
                aC(this.mSelectedPosition + 1, a2.getRight() + i5);
            } else {
                aC(this.mSelectedPosition + 1, a2.getRight() + i5);
                api();
                aD(this.mSelectedPosition - 2, a2.getLeft() - i5);
            }
        } else if (i < 0) {
            if (view2 != null) {
                a2 = a(i4, view2.getLeft(), true, this.mListPadding.top, true);
            } else {
                a2 = a(i4, view.getLeft(), false, this.mListPadding.top, true);
            }
            if (a2.getLeft() < z) {
                a2.offsetLeftAndRight(Math.min(Math.min(z - a2.getLeft(), y - a2.getRight()), (i3 - i2) / 2));
            }
            s(a2, i4);
        } else {
            int left = view.getLeft();
            a2 = a(i4, left, true, this.mListPadding.top, true);
            if (left < i2 && a2.getRight() < i2 + 20) {
                a2.offsetLeftAndRight(i2 - a2.getLeft());
            }
            s(a2, i4);
        }
        return a2;
    }

    /* loaded from: classes.dex */
    private class c implements Runnable {
        private int avi;
        private int cWO;

        private c() {
        }

        public c aI(int i, int i2) {
            this.avi = i;
            this.cWO = i2;
            return this;
        }

        @Override // java.lang.Runnable
        public void run() {
            HListView.this.aF(this.avi, this.cWO);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        View focusedChild;
        if (getChildCount() > 0 && (focusedChild = getFocusedChild()) != null) {
            int indexOfChild = this.mFirstPosition + indexOfChild(focusedChild);
            int left = focusedChild.getLeft() - Math.max(0, focusedChild.getRight() - (i - getPaddingLeft()));
            if (this.cWM == null) {
                this.cWM = new c();
            }
            post(this.cWM.aI(indexOfChild, left));
        }
        super.onSizeChanged(i, i2, i3, i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    @TargetApi(11)
    public void onMeasure(int i, int i2) {
        int i3;
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int i4 = 0;
        int i5 = 0;
        this.mItemCount = this.mAdapter == null ? 0 : this.mAdapter.getCount();
        if (this.mItemCount > 0 && (mode == 0 || mode2 == 0)) {
            View obtainView = obtainView(0, this.mIsScrap);
            g(obtainView, 0, i2);
            i4 = obtainView.getMeasuredWidth();
            i5 = obtainView.getMeasuredHeight();
            r1 = Build.VERSION.SDK_INT >= 11 ? combineMeasuredStates(0, obtainView.getMeasuredState()) : 0;
            if (recycleOnMeasure() && this.cUg.kR(((AbsHListView.f) obtainView.getLayoutParams()).cUZ)) {
                this.cUg.r(obtainView, -1);
            }
        }
        int i6 = i5;
        int i7 = i4;
        if (mode2 == 0) {
            i3 = i6 + this.mListPadding.top + this.mListPadding.bottom + getHorizontalScrollbarHeight();
        } else if (mode2 == Integer.MIN_VALUE && this.mItemCount > 0 && this.cWK > -1) {
            i3 = d(i2, this.cWK, this.cWK, size, size2, -1)[1];
        } else {
            i3 = Build.VERSION.SDK_INT >= 11 ? size2 | ((-16777216) & r1) : size2;
        }
        if (mode == 0) {
            size = this.mListPadding.left + this.mListPadding.right + i7 + (getHorizontalFadingEdgeLength() * 2);
        }
        if (mode == Integer.MIN_VALUE) {
            if (this.BS > 0 && this.BS < size) {
                size = this.BS;
            }
            size = e(i2, 0, -1, size, -1);
        }
        setMeasuredDimension(size, i3);
        this.cUh = i2;
    }

    private void g(View view, int i, int i2) {
        int makeMeasureSpec;
        AbsHListView.f fVar = (AbsHListView.f) view.getLayoutParams();
        if (fVar == null) {
            fVar = (AbsHListView.f) generateDefaultLayoutParams();
            view.setLayoutParams(fVar);
        }
        fVar.cUZ = this.mAdapter.getItemViewType(i);
        fVar.cVb = true;
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, this.mListPadding.top + this.mListPadding.bottom, fVar.height);
        int i3 = fVar.width;
        if (i3 > 0) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(makeMeasureSpec, childMeasureSpec);
    }

    @ViewDebug.ExportedProperty(category = IntentConfig.LIST)
    protected boolean recycleOnMeasure() {
        return true;
    }

    final int e(int i, int i2, int i3, int i4, int i5) {
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter == null) {
            return this.mListPadding.left + this.mListPadding.right;
        }
        int i6 = this.mListPadding.left + this.mListPadding.right;
        int i7 = this.bdO;
        int i8 = 0;
        if (i3 == -1) {
            i3 = listAdapter.getCount() - 1;
        }
        AbsHListView.k kVar = this.cUg;
        boolean recycleOnMeasure = recycleOnMeasure();
        boolean[] zArr = this.mIsScrap;
        while (i2 <= i3) {
            View obtainView = obtainView(i2, zArr);
            g(obtainView, i2, i);
            int i9 = i2 > 0 ? i6 + i7 : i6;
            if (recycleOnMeasure && kVar.kR(((AbsHListView.f) obtainView.getLayoutParams()).cUZ)) {
                kVar.r(obtainView, -1);
            }
            i6 = obtainView.getMeasuredWidth() + i9;
            if (i6 >= i4) {
                return (i5 < 0 || i2 <= i5 || i8 <= 0 || i6 == i4) ? i4 : i8;
            }
            if (i5 >= 0 && i2 >= i5) {
                i8 = i6;
            }
            i2++;
        }
        return i6;
    }

    final int[] d(int i, int i2, int i3, int i4, int i5, int i6) {
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter == null) {
            return new int[]{this.mListPadding.left + this.mListPadding.right, this.mListPadding.top + this.mListPadding.bottom};
        }
        int i7 = this.mListPadding.left + this.mListPadding.right;
        int i8 = this.mListPadding.top + this.mListPadding.bottom;
        int i9 = this.bdO;
        if (i3 == -1) {
            i3 = listAdapter.getCount() - 1;
        }
        AbsHListView.k kVar = this.cUg;
        boolean recycleOnMeasure = recycleOnMeasure();
        boolean[] zArr = this.mIsScrap;
        int i10 = 0;
        int i11 = 0;
        while (i2 <= i3) {
            View obtainView = obtainView(i2, zArr);
            g(obtainView, i2, i);
            if (recycleOnMeasure && kVar.kR(((AbsHListView.f) obtainView.getLayoutParams()).cUZ)) {
                kVar.r(obtainView, -1);
            }
            i10 = Math.max(i10, obtainView.getMeasuredWidth() + i9);
            i2++;
            i11 = Math.max(i11, obtainView.getMeasuredHeight());
        }
        return new int[]{Math.min(i10 + i7, i4), Math.min(i11 + i8, i5)};
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView
    protected int kM(int i) {
        int childCount = getChildCount();
        if (childCount > 0) {
            if (this.cUr) {
                for (int i2 = childCount - 1; i2 >= 0; i2--) {
                    if (i >= getChildAt(i2).getLeft()) {
                        return i2 + this.mFirstPosition;
                    }
                }
            } else {
                for (int i3 = 0; i3 < childCount; i3++) {
                    if (i <= getChildAt(i3).getRight()) {
                        return i3 + this.mFirstPosition;
                    }
                }
            }
        }
        return -1;
    }

    private View fillSpecific(int i, int i2) {
        View aC;
        View aD;
        boolean z = i == this.mSelectedPosition;
        View a2 = a(i, i2, true, this.mListPadding.top, z);
        this.mFirstPosition = i;
        int i3 = this.bdO;
        if (!this.cUr) {
            aD = aD(i - 1, a2.getLeft() - i3);
            api();
            aC = aC(i + 1, i3 + a2.getRight());
            int childCount = getChildCount();
            if (childCount > 0) {
                ld(childCount);
            }
        } else {
            aC = aC(i + 1, a2.getRight() + i3);
            api();
            aD = aD(i - 1, a2.getLeft() - i3);
            int childCount2 = getChildCount();
            if (childCount2 > 0) {
                le(childCount2);
            }
        }
        if (z) {
            return a2;
        }
        return aD != null ? aD : aC;
    }

    private void ld(int i) {
        if ((this.mFirstPosition + i) - 1 == this.mItemCount - 1 && i > 0) {
            int right = ((getRight() - getLeft()) - this.mListPadding.right) - getChildAt(i - 1).getRight();
            View childAt = getChildAt(0);
            int left = childAt.getLeft();
            if (right > 0) {
                if (this.mFirstPosition > 0 || left < this.mListPadding.top) {
                    if (this.mFirstPosition == 0) {
                        right = Math.min(right, this.mListPadding.top - left);
                    }
                    kL(right);
                    if (this.mFirstPosition > 0) {
                        aD(this.mFirstPosition - 1, childAt.getLeft() - this.bdO);
                        api();
                    }
                }
            }
        }
    }

    private void le(int i) {
        if (this.mFirstPosition == 0 && i > 0) {
            int left = getChildAt(0).getLeft();
            int i2 = this.mListPadding.left;
            int right = (getRight() - getLeft()) - this.mListPadding.right;
            int i3 = left - i2;
            View childAt = getChildAt(i - 1);
            int right2 = childAt.getRight();
            int i4 = (this.mFirstPosition + i) - 1;
            if (i3 > 0) {
                if (i4 < this.mItemCount - 1 || right2 > right) {
                    if (i4 == this.mItemCount - 1) {
                        i3 = Math.min(i3, right2 - right);
                    }
                    kL(-i3);
                    if (i4 < this.mItemCount - 1) {
                        aC(i4 + 1, childAt.getRight() + this.bdO);
                        api();
                    }
                } else if (i4 == this.mItemCount - 1) {
                    api();
                }
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, CONST, IPUT] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1921=4, 1922=4] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView
    public void layoutChildren() {
        View view;
        View view2;
        View view3;
        View a2;
        boolean z = this.mBlockLayoutRequests;
        if (z) {
            return;
        }
        this.mBlockLayoutRequests = true;
        try {
            super.layoutChildren();
            invalidate();
            if (this.mAdapter == null) {
                resetList();
                invokeOnItemScrollListener();
                if (z) {
                    return;
                }
                return;
            }
            int i = this.mListPadding.left;
            int right = (getRight() - getLeft()) - this.mListPadding.right;
            int childCount = getChildCount();
            View view4 = null;
            View view5 = null;
            View view6 = null;
            switch (this.mLayoutMode) {
                case 1:
                case 3:
                case 4:
                case 5:
                    view = null;
                    break;
                case 2:
                    int i2 = this.cVK - this.mFirstPosition;
                    if (i2 < 0 || i2 >= childCount) {
                        view = null;
                        break;
                    } else {
                        view5 = getChildAt(i2);
                        view = null;
                        break;
                    }
                default:
                    int i3 = this.mSelectedPosition - this.mFirstPosition;
                    if (i3 >= 0 && i3 < childCount) {
                        view4 = getChildAt(i3);
                    }
                    View childAt = getChildAt(0);
                    r4 = this.cVK >= 0 ? this.cVK - this.mSelectedPosition : 0;
                    view5 = getChildAt(i3 + r4);
                    view = childAt;
                    break;
            }
            boolean z2 = this.mDataChanged;
            if (z2) {
                handleDataChanged();
            }
            if (this.mItemCount == 0) {
                resetList();
                invokeOnItemScrollListener();
                if (z) {
                    return;
                }
                this.mBlockLayoutRequests = false;
            } else if (this.mItemCount != this.mAdapter.getCount()) {
                throw new IllegalStateException("The content of the adapter has changed but ListView did not receive a notification. Make sure the content of your adapter is not modified from a background thread, but only from the UI thread. [in ListView(" + getId() + ", " + getClass() + ") with Adapter(" + this.mAdapter.getClass() + ")]");
            } else {
                setSelectedPositionInt(this.cVK);
                int i4 = this.mFirstPosition;
                AbsHListView.k kVar = this.cUg;
                View view7 = null;
                if (z2) {
                    for (int i5 = 0; i5 < childCount; i5++) {
                        kVar.r(getChildAt(i5), i4 + i5);
                    }
                } else {
                    kVar.aB(childCount, i4);
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
                kVar.aoT();
                switch (this.mLayoutMode) {
                    case 1:
                        this.mFirstPosition = 0;
                        View lc = lc(i);
                        api();
                        a2 = lc;
                        break;
                    case 2:
                        if (view5 != null) {
                            a2 = x(view5.getLeft(), i, right);
                            break;
                        } else {
                            a2 = aE(i, right);
                            break;
                        }
                    case 3:
                        View aD = aD(this.mItemCount - 1, right);
                        api();
                        a2 = aD;
                        break;
                    case 4:
                        a2 = fillSpecific(reconcileSelectedPosition(), this.cVE);
                        break;
                    case 5:
                        a2 = fillSpecific(this.mSyncPosition, this.cVE);
                        break;
                    case 6:
                        a2 = a(view4, view5, r4, i, right);
                        break;
                    default:
                        if (childCount == 0) {
                            if (this.cUr) {
                                setSelectedPositionInt(lookForSelectablePosition(this.mItemCount - 1, false));
                                a2 = aD(this.mItemCount - 1, right);
                                break;
                            } else {
                                setSelectedPositionInt(lookForSelectablePosition(0, true));
                                a2 = lc(i);
                                break;
                            }
                        } else if (this.mSelectedPosition < 0 || this.mSelectedPosition >= this.mItemCount) {
                            if (this.mFirstPosition < this.mItemCount) {
                                int i6 = this.mFirstPosition;
                                if (view != null) {
                                    i = view.getLeft();
                                }
                                a2 = fillSpecific(i6, i);
                                break;
                            } else {
                                a2 = fillSpecific(0, i);
                                break;
                            }
                        } else {
                            int i7 = this.mSelectedPosition;
                            if (view4 != null) {
                                i = view4.getLeft();
                            }
                            a2 = fillSpecific(i7, i);
                            break;
                        }
                }
                kVar.aoU();
                if (a2 != null) {
                    if (!this.mItemsCanFocus || !hasFocus() || a2.hasFocus()) {
                        d(-1, a2);
                    } else if ((a2 == view3 && view2 != null && view2.requestFocus()) || a2.requestFocus()) {
                        a2.setSelected(false);
                        this.mSelectorRect.setEmpty();
                    } else {
                        View focusedChild2 = getFocusedChild();
                        if (focusedChild2 != null) {
                            focusedChild2.clearFocus();
                        }
                        d(-1, a2);
                    }
                    this.cUq = a2.getLeft();
                } else {
                    if (this.mTouchMode <= 0 || this.mTouchMode >= 3) {
                        this.cUq = 0;
                        this.mSelectorRect.setEmpty();
                    } else {
                        View childAt2 = getChildAt(this.mMotionPosition - this.mFirstPosition);
                        if (childAt2 != null) {
                            d(this.mMotionPosition, childAt2);
                        }
                    }
                    if (hasFocus() && view2 != null) {
                        view2.requestFocus();
                    }
                }
                if (view2 != null && view2.getWindowToken() != null) {
                    view2.onFinishTemporaryDetach();
                }
                this.mLayoutMode = 0;
                this.mDataChanged = false;
                if (this.cUy != null) {
                    post(this.cUy);
                    this.cUy = null;
                }
                this.mNeedSync = false;
                setNextSelectedPositionInt(this.mSelectedPosition);
                aoC();
                if (this.mItemCount > 0) {
                    checkSelectionChanged();
                }
                invokeOnItemScrollListener();
                if (z) {
                    return;
                }
                this.mBlockLayoutRequests = false;
            }
        } finally {
            if (!z) {
                this.mBlockLayoutRequests = false;
            }
        }
    }

    private boolean ay(View view) {
        ArrayList<b> arrayList = this.mHeaderViewInfos;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (view == arrayList.get(i).view) {
                return true;
            }
        }
        ArrayList<b> arrayList2 = this.mFooterViewInfos;
        int size2 = arrayList2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            if (view == arrayList2.get(i2).view) {
                return true;
            }
        }
        return false;
    }

    private View a(int i, int i2, boolean z, int i3, boolean z2) {
        View kS;
        if (!this.mDataChanged && (kS = this.cUg.kS(i)) != null) {
            setupChild(kS, i, i2, z, i3, z2, true);
            return kS;
        }
        View obtainView = obtainView(i, this.mIsScrap);
        setupChild(obtainView, i, i2, z, i3, z2, this.mIsScrap[0]);
        return obtainView;
    }

    @TargetApi(11)
    private void setupChild(View view, int i, int i2, boolean z, int i3, boolean z2, boolean z3) {
        int makeMeasureSpec;
        boolean z4 = z2 && shouldShowSelector();
        boolean z5 = z4 != view.isSelected();
        int i4 = this.mTouchMode;
        boolean z6 = i4 > 0 && i4 < 3 && this.mMotionPosition == i;
        boolean z7 = z6 != view.isPressed();
        boolean z8 = !z3 || z5 || view.isLayoutRequested();
        AbsHListView.f fVar = (AbsHListView.f) view.getLayoutParams();
        AbsHListView.f fVar2 = fVar == null ? (AbsHListView.f) generateDefaultLayoutParams() : fVar;
        fVar2.cUZ = this.mAdapter.getItemViewType(i);
        if ((z3 && !fVar2.cVb) || (fVar2.cVa && fVar2.cUZ == -2)) {
            attachViewToParent(view, z ? -1 : 0, fVar2);
        } else {
            fVar2.cVb = false;
            if (fVar2.cUZ == -2) {
                fVar2.cVa = true;
            }
            addViewInLayout(view, z ? -1 : 0, fVar2, true);
        }
        if (z5) {
            view.setSelected(z4);
        }
        if (z7) {
            view.setPressed(z6);
        }
        if (this.cTX != 0 && this.cUb != null) {
            if (view instanceof Checkable) {
                ((Checkable) view).setChecked(this.cUb.get(i, false).booleanValue());
            } else if (Build.VERSION.SDK_INT >= 11) {
                view.setActivated(this.cUb.get(i, false).booleanValue());
            }
        }
        if (z8) {
            int childMeasureSpec = ViewGroup.getChildMeasureSpec(this.cUh, this.mListPadding.top + this.mListPadding.bottom, fVar2.height);
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
        if (z8) {
            view.layout(i2, i3, measuredWidth + i2, measuredHeight + i3);
        } else {
            view.offsetLeftAndRight(i2 - view.getLeft());
            view.offsetTopAndBottom(i3 - view.getTop());
        }
        if (this.mCachingStarted && !view.isDrawingCacheEnabled()) {
            view.setDrawingCacheEnabled(true);
        }
        if (Build.VERSION.SDK_INT >= 11 && z3 && ((AbsHListView.f) view.getLayoutParams()).cVc != i) {
            view.jumpDrawablesToCurrentState();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.a, android.view.ViewGroup
    public boolean canAnimate() {
        return super.canAnimate() && this.mItemCount > 0;
    }

    @Override // com.baidu.tieba.horizonalList.widget.a
    public void setSelection(int i) {
        aF(i, 0);
    }

    public void aF(int i, int i2) {
        if (this.mAdapter != null) {
            if (!isInTouchMode()) {
                i = lookForSelectablePosition(i, true);
                if (i >= 0) {
                    setNextSelectedPositionInt(i);
                }
            } else {
                this.mResurrectToPosition = i;
            }
            if (i >= 0) {
                this.mLayoutMode = 4;
                this.cVE = this.mListPadding.left + i2;
                if (this.mNeedSync) {
                    this.mSyncPosition = i;
                    this.cVF = this.mAdapter.getItemId(i);
                }
                if (this.cUp != null) {
                    this.cUp.stop();
                }
                requestLayout();
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView
    public void setSelectionInt(int i) {
        boolean z = true;
        setNextSelectedPositionInt(i);
        int i2 = this.mSelectedPosition;
        if (i2 < 0 || (i != i2 - 1 && i != i2 + 1)) {
            z = false;
        }
        if (this.cUp != null) {
            this.cUp.stop();
        }
        layoutChildren();
        if (z) {
            awakenScrollBars();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.a
    public int lookForSelectablePosition(int i, boolean z) {
        int min;
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter == null || isInTouchMode()) {
            return -1;
        }
        int count = listAdapter.getCount();
        if (!this.mAreAllItemsSelectable) {
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
    @TargetApi(11)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(int i, int i2, KeyEvent keyEvent) {
        boolean z;
        if (this.mAdapter == null || !this.cUM) {
            return false;
        }
        if (this.mDataChanged) {
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
                        z = lf(33);
                        break;
                    }
                    break;
                case 20:
                    if (keyEvent.hasNoModifiers()) {
                        z = lf(TransportMediator.KEYCODE_MEDIA_RECORD);
                        break;
                    }
                    break;
                case 21:
                    if (keyEvent.hasNoModifiers()) {
                        z = aoK();
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
                        if (!aoK() && !fullScroll(33)) {
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
                        z = aoK();
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
                        if (!aoK() && !fullScroll(TransportMediator.KEYCODE_MEDIA_RECORD)) {
                            z = false;
                            break;
                        } else {
                            z = true;
                            break;
                        }
                    }
                    break;
                case 23:
                case 66:
                    if (keyEvent.hasNoModifiers()) {
                        z = aoK();
                        if (!z && keyEvent.getRepeatCount() == 0 && getChildCount() > 0) {
                            aoD();
                            z = true;
                            break;
                        }
                    }
                    break;
                case 62:
                    if (!keyEvent.hasNoModifiers() ? !keyEvent.hasModifiers(1) || aoK() || pageScroll(33) : aoK() || pageScroll(TransportMediator.KEYCODE_MEDIA_RECORD)) {
                    }
                    z = true;
                    break;
                case 92:
                    if (keyEvent.hasNoModifiers()) {
                        if (!aoK() && !pageScroll(33)) {
                            z = false;
                            break;
                        } else {
                            z = true;
                            break;
                        }
                    } else if (keyEvent.hasModifiers(2)) {
                        if (!aoK() && !fullScroll(33)) {
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
                        if (!aoK() && !pageScroll(TransportMediator.KEYCODE_MEDIA_RECORD)) {
                            z = false;
                            break;
                        } else {
                            z = true;
                            break;
                        }
                    } else if (keyEvent.hasModifiers(2)) {
                        if (!aoK() && !fullScroll(TransportMediator.KEYCODE_MEDIA_RECORD)) {
                            z = false;
                            break;
                        } else {
                            z = true;
                            break;
                        }
                    }
                    break;
                case 122:
                    if (keyEvent.hasNoModifiers()) {
                        if (!aoK() && !fullScroll(33)) {
                            z = false;
                            break;
                        } else {
                            z = true;
                            break;
                        }
                    }
                    break;
                case 123:
                    if (keyEvent.hasNoModifiers()) {
                        if (!aoK() && !fullScroll(TransportMediator.KEYCODE_MEDIA_RECORD)) {
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
        int lookForSelectablePosition;
        if (i == 33) {
            i2 = Math.max(0, (this.mSelectedPosition - getChildCount()) - 1);
            z = false;
        } else if (i != 130) {
            i2 = -1;
            z = false;
        } else {
            i2 = Math.min(this.mItemCount - 1, (this.mSelectedPosition + getChildCount()) - 1);
            z = true;
        }
        if (i2 < 0 || (lookForSelectablePosition = lookForSelectablePosition(i2, z)) < 0) {
            return false;
        }
        this.mLayoutMode = 4;
        this.cVE = getPaddingLeft() + getHorizontalFadingEdgeLength();
        if (z && lookForSelectablePosition > this.mItemCount - getChildCount()) {
            this.mLayoutMode = 3;
        }
        if (!z && lookForSelectablePosition < getChildCount()) {
            this.mLayoutMode = 1;
        }
        setSelectionInt(lookForSelectablePosition);
        invokeOnItemScrollListener();
        if (awakenScrollBars()) {
            return true;
        }
        invalidate();
        return true;
    }

    boolean fullScroll(int i) {
        boolean z = true;
        if (i == 33) {
            if (this.mSelectedPosition != 0) {
                int lookForSelectablePosition = lookForSelectablePosition(0, true);
                if (lookForSelectablePosition >= 0) {
                    this.mLayoutMode = 1;
                    setSelectionInt(lookForSelectablePosition);
                    invokeOnItemScrollListener();
                }
            }
            z = false;
        } else {
            if (i == 130 && this.mSelectedPosition < this.mItemCount - 1) {
                int lookForSelectablePosition2 = lookForSelectablePosition(this.mItemCount - 1, true);
                if (lookForSelectablePosition2 >= 0) {
                    this.mLayoutMode = 3;
                    setSelectionInt(lookForSelectablePosition2);
                    invokeOnItemScrollListener();
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

    private boolean lf(int i) {
        View selectedView;
        if (i != 33 && i != 130) {
            throw new IllegalArgumentException("direction must be one of {View.FOCUS_UP, View.FOCUS_DOWN}");
        }
        int childCount = getChildCount();
        if (this.mItemsCanFocus && childCount > 0 && this.mSelectedPosition != -1 && (selectedView = getSelectedView()) != null && selectedView.hasFocus() && (selectedView instanceof ViewGroup)) {
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
                return c(findNextFocus2, this);
            }
        }
        return false;
    }

    boolean arrowScroll(int i) {
        try {
            this.mInLayout = true;
            boolean lg = lg(i);
            if (lg) {
                playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
            }
            return lg;
        } finally {
            this.mInLayout = false;
        }
    }

    private boolean lg(int i) {
        View view;
        int i2;
        View view2;
        View focusedChild;
        if (getChildCount() <= 0) {
            return false;
        }
        View selectedView = getSelectedView();
        int i3 = this.mSelectedPosition;
        int lh = lh(i);
        int aG = aG(i, lh);
        a li = this.mItemsCanFocus ? li(i) : null;
        if (li != null) {
            lh = li.akX();
            aG = li.apl();
        }
        boolean z = li != null;
        if (lh != -1) {
            a(selectedView, i, lh, li != null);
            setSelectedPositionInt(lh);
            setNextSelectedPositionInt(lh);
            view = getSelectedView();
            if (this.mItemsCanFocus && li == null && (focusedChild = getFocusedChild()) != null) {
                focusedChild.clearFocus();
            }
            checkSelectionChanged();
            z = true;
            i2 = lh;
        } else {
            view = selectedView;
            i2 = i3;
        }
        if (aG > 0) {
            scrollListItemsBy(i == 33 ? aG : -aG);
            z = true;
        }
        if (this.mItemsCanFocus && li == null && view != null && view.hasFocus()) {
            View findFocus = view.findFocus();
            if (!c(findFocus, this) || aC(findFocus) > 0) {
                findFocus.clearFocus();
            }
        }
        if (lh != -1 || view == null || c(view, this)) {
            view2 = view;
        } else {
            aoJ();
            this.mResurrectToPosition = -1;
            view2 = null;
        }
        if (z) {
            if (view2 != null) {
                d(i2, view2);
                this.cUq = view2.getLeft();
            }
            if (!awakenScrollBars()) {
                invalidate();
            }
            invokeOnItemScrollListener();
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
        int i4 = this.mSelectedPosition - this.mFirstPosition;
        int i5 = i2 - this.mFirstPosition;
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
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(this.cUh, this.mListPadding.top + this.mListPadding.bottom, layoutParams.height);
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
        int i = this.mListPadding.top;
        int left = view.getLeft();
        view.layout(left, i, measuredWidth + left, measuredHeight + i);
    }

    private int getArrowScrollPreviewLength() {
        return Math.max(2, getHorizontalFadingEdgeLength());
    }

    private int aG(int i, int i2) {
        int width = getWidth() - this.mListPadding.right;
        int i3 = this.mListPadding.left;
        int childCount = getChildCount();
        if (i == 130) {
            int i4 = childCount - 1;
            if (i2 != -1) {
                i4 = i2 - this.mFirstPosition;
            }
            int i5 = this.mFirstPosition + i4;
            View childAt = getChildAt(i4);
            int arrowScrollPreviewLength = i5 < this.mItemCount + (-1) ? width - getArrowScrollPreviewLength() : width;
            if (childAt.getRight() <= arrowScrollPreviewLength) {
                return 0;
            }
            if (i2 == -1 || arrowScrollPreviewLength - childAt.getLeft() < getMaxScrollAmount()) {
                int right = childAt.getRight() - arrowScrollPreviewLength;
                if (this.mFirstPosition + childCount == this.mItemCount) {
                    right = Math.min(right, getChildAt(childCount - 1).getRight() - width);
                }
                return Math.min(right, getMaxScrollAmount());
            }
            return 0;
        }
        int i6 = i2 != -1 ? i2 - this.mFirstPosition : 0;
        int i7 = this.mFirstPosition + i6;
        View childAt2 = getChildAt(i6);
        int arrowScrollPreviewLength2 = i7 > 0 ? getArrowScrollPreviewLength() + i3 : i3;
        if (childAt2.getLeft() < arrowScrollPreviewLength2) {
            if (i2 == -1 || childAt2.getRight() - arrowScrollPreviewLength2 < getMaxScrollAmount()) {
                int left = arrowScrollPreviewLength2 - childAt2.getLeft();
                if (this.mFirstPosition == 0) {
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
        private int cWN;
        private int mSelectedPosition;

        private a() {
        }

        void aH(int i, int i2) {
            this.mSelectedPosition = i;
            this.cWN = i2;
        }

        public int akX() {
            return this.mSelectedPosition;
        }

        public int apl() {
            return this.cWN;
        }
    }

    private int lh(int i) {
        int i2 = this.mFirstPosition;
        if (i == 130) {
            int i3 = this.mSelectedPosition != -1 ? this.mSelectedPosition + 1 : i2;
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
            int childCount2 = this.mSelectedPosition != -1 ? this.mSelectedPosition - 1 : (getChildCount() + i2) - 1;
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

    private a li(int i) {
        View findNextFocusFromRect;
        int lh;
        View selectedView = getSelectedView();
        if (selectedView != null && selectedView.hasFocus()) {
            findNextFocusFromRect = FocusFinder.getInstance().findNextFocus(this, selectedView.findFocus(), i);
        } else {
            if (i == 130) {
                int arrowScrollPreviewLength = (this.mFirstPosition > 0 ? getArrowScrollPreviewLength() : 0) + this.mListPadding.left;
                if (selectedView != null && selectedView.getLeft() > arrowScrollPreviewLength) {
                    arrowScrollPreviewLength = selectedView.getLeft();
                }
                this.mTempRect.set(arrowScrollPreviewLength, 0, arrowScrollPreviewLength, 0);
            } else {
                int width = (getWidth() - this.mListPadding.right) - ((this.mFirstPosition + getChildCount()) + (-1) < this.mItemCount ? getArrowScrollPreviewLength() : 0);
                if (selectedView != null && selectedView.getRight() < width) {
                    width = selectedView.getRight();
                }
                this.mTempRect.set(width, 0, width, 0);
            }
            findNextFocusFromRect = FocusFinder.getInstance().findNextFocusFromRect(this, this.mTempRect, i);
        }
        if (findNextFocusFromRect != null) {
            int aB = aB(findNextFocusFromRect);
            if (this.mSelectedPosition != -1 && aB != this.mSelectedPosition && (lh = lh(i)) != -1 && ((i == 130 && lh < aB) || (i == 33 && lh > aB))) {
                return null;
            }
            int a2 = a(i, findNextFocusFromRect, aB);
            int maxScrollAmount = getMaxScrollAmount();
            if (a2 < maxScrollAmount) {
                findNextFocusFromRect.requestFocus(i);
                this.cWL.aH(aB, a2);
                return this.cWL;
            } else if (aC(findNextFocusFromRect) < maxScrollAmount) {
                findNextFocusFromRect.requestFocus(i);
                this.cWL.aH(aB, maxScrollAmount);
                return this.cWL;
            }
        }
        return null;
    }

    private int aB(View view) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (c(view, getChildAt(i))) {
                return i + this.mFirstPosition;
            }
        }
        throw new IllegalArgumentException("newFocus is not a child of any of the children of the list!");
    }

    private boolean c(View view, View view2) {
        if (view == view2) {
            return true;
        }
        ViewParent parent = view.getParent();
        return (parent instanceof ViewGroup) && c((View) parent, view2);
    }

    private int a(int i, View view, int i2) {
        view.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(view, this.mTempRect);
        if (i == 33) {
            if (this.mTempRect.left >= this.mListPadding.left) {
                return 0;
            }
            int i3 = this.mListPadding.left - this.mTempRect.left;
            if (i2 > 0) {
                return i3 + getArrowScrollPreviewLength();
            }
            return i3;
        }
        int width = getWidth() - this.mListPadding.right;
        if (this.mTempRect.bottom <= width) {
            return 0;
        }
        int i4 = this.mTempRect.right - width;
        if (i2 < this.mItemCount - 1) {
            return i4 + getArrowScrollPreviewLength();
        }
        return i4;
    }

    private int aC(View view) {
        view.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(view, this.mTempRect);
        int right = (getRight() - getLeft()) - this.mListPadding.right;
        if (this.mTempRect.right < this.mListPadding.left) {
            return this.mListPadding.left - this.mTempRect.right;
        }
        if (this.mTempRect.left <= right) {
            return 0;
        }
        return this.mTempRect.left - right;
    }

    private void scrollListItemsBy(int i) {
        int i2;
        kL(i);
        int width = getWidth() - this.mListPadding.right;
        int i3 = this.mListPadding.left;
        AbsHListView.k kVar = this.cUg;
        if (i < 0) {
            int childCount = getChildCount();
            View childAt = getChildAt(childCount - 1);
            while (childAt.getRight() < width && (this.mFirstPosition + childCount) - 1 < this.mItemCount - 1) {
                childAt = u(childAt, i2);
                childCount++;
            }
            if (childAt.getBottom() < width) {
                kL(width - childAt.getRight());
            }
            View childAt2 = getChildAt(0);
            while (true) {
                View view = childAt2;
                if (view.getRight() < i3) {
                    if (kVar.kR(((AbsHListView.f) view.getLayoutParams()).cUZ)) {
                        detachViewFromParent(view);
                        kVar.r(view, this.mFirstPosition);
                    } else {
                        removeViewInLayout(view);
                    }
                    childAt2 = getChildAt(0);
                    this.mFirstPosition++;
                } else {
                    return;
                }
            }
        } else {
            View childAt3 = getChildAt(0);
            while (childAt3.getLeft() > i3 && this.mFirstPosition > 0) {
                childAt3 = t(childAt3, this.mFirstPosition);
                this.mFirstPosition--;
            }
            if (childAt3.getLeft() > i3) {
                kL(i3 - childAt3.getLeft());
            }
            int childCount2 = getChildCount() - 1;
            View childAt4 = getChildAt(childCount2);
            while (true) {
                int i4 = childCount2;
                View view2 = childAt4;
                if (view2.getLeft() > width) {
                    if (kVar.kR(((AbsHListView.f) view2.getLayoutParams()).cUZ)) {
                        detachViewFromParent(view2);
                        kVar.r(view2, this.mFirstPosition + i4);
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
        View obtainView = obtainView(i2, this.mIsScrap);
        setupChild(obtainView, i2, view.getLeft() - this.bdO, false, this.mListPadding.top, false, this.mIsScrap[0]);
        return obtainView;
    }

    private View u(View view, int i) {
        int i2 = i + 1;
        View obtainView = obtainView(i2, this.mIsScrap);
        setupChild(obtainView, i2, this.bdO + view.getRight(), true, this.mListPadding.top, false, this.mIsScrap[0]);
        return obtainView;
    }

    public void setItemsCanFocus(boolean z) {
        this.mItemsCanFocus = z;
        if (!z) {
            setDescendantFocusability(393216);
        }
    }

    public boolean getItemsCanFocus() {
        return this.mItemsCanFocus;
    }

    @Override // android.view.View
    public boolean isOpaque() {
        boolean z = (this.cUk && this.mIsCacheColorOpaque && this.mDividerIsOpaque) || super.isOpaque();
        if (z) {
            int paddingLeft = this.mListPadding != null ? this.mListPadding.left : getPaddingLeft();
            View childAt = getChildAt(0);
            if (childAt == null || childAt.getLeft() > paddingLeft) {
                return false;
            }
            int width = getWidth() - (this.mListPadding != null ? this.mListPadding.right : getPaddingRight());
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
        this.mIsCacheColorOpaque = z;
        if (z) {
            if (this.mDividerPaint == null) {
                this.mDividerPaint = new Paint();
            }
            this.mDividerPaint.setColor(i);
        }
        super.setCacheColorHint(i);
    }

    void drawOverscrollHeader(Canvas canvas, Drawable drawable, Rect rect) {
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

    void drawOverscrollFooter(Canvas canvas, Drawable drawable, Rect rect) {
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
        if (this.mCachingStarted) {
            this.cUk = true;
        }
        int i = this.bdO;
        Drawable drawable = this.mOverScrollHeader;
        Drawable drawable2 = this.mOverScrollFooter;
        boolean z = drawable != null;
        boolean z2 = drawable2 != null;
        boolean z3 = i > 0 && this.mDivider != null;
        if (z3 || z || z2) {
            Rect rect = this.mTempRect;
            rect.top = getPaddingTop();
            rect.bottom = (getBottom() - getTop()) - getPaddingBottom();
            int childCount = getChildCount();
            int size = this.mHeaderViewInfos.size();
            int i2 = this.mItemCount;
            int size2 = (i2 - this.mFooterViewInfos.size()) - 1;
            boolean z4 = this.mHeaderDividersEnabled;
            boolean z5 = this.mFooterDividersEnabled;
            int i3 = this.mFirstPosition;
            boolean z6 = this.mAreAllItemsSelectable;
            ListAdapter listAdapter = this.mAdapter;
            boolean z7 = isOpaque() && !super.isOpaque();
            if (z7 && this.mDividerPaint == null && this.mIsCacheColorOpaque) {
                this.mDividerPaint = new Paint();
                this.mDividerPaint.setColor(getCacheColorHint());
            }
            Paint paint = this.mDividerPaint;
            int scrollX = getScrollX() + ((getRight() - getLeft()) - 0);
            if (!this.cUr) {
                int scrollX2 = getScrollX();
                if (childCount > 0 && scrollX2 < 0) {
                    if (z) {
                        rect.right = 0;
                        rect.left = scrollX2;
                        drawOverscrollHeader(canvas, drawable, rect);
                    } else if (z3) {
                        rect.right = 0;
                        rect.left = -i;
                        drawDivider(canvas, rect, -1);
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
                                drawDivider(canvas, rect, i5);
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
                    drawOverscrollFooter(canvas, drawable2, rect);
                }
            } else {
                int scrollX3 = getScrollX();
                if (childCount > 0 && z) {
                    rect.left = scrollX3;
                    rect.right = getChildAt(0).getLeft();
                    drawOverscrollHeader(canvas, drawable, rect);
                }
                for (int i6 = z ? 1 : 0; i6 < childCount; i6++) {
                    if ((z4 || i3 + i6 >= size) && ((z5 || i3 + i6 < size2) && (left = getChildAt(i6).getLeft()) > 0)) {
                        if (z6 || (listAdapter.isEnabled(i3 + i6) && (i6 == childCount - 1 || listAdapter.isEnabled(i3 + i6 + 1)))) {
                            rect.left = left - i;
                            rect.right = left;
                            drawDivider(canvas, rect, i6 - 1);
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
                        drawOverscrollFooter(canvas, drawable2, rect);
                    } else if (z3) {
                        rect.left = scrollX;
                        rect.right = scrollX + i;
                        drawDivider(canvas, rect, -1);
                    }
                }
            }
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        boolean drawChild = super.drawChild(canvas, view, j);
        if (this.cUk) {
            this.cUk = false;
        }
        return drawChild;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void drawDivider(Canvas canvas, Rect rect, int i) {
        Drawable drawable = this.mDivider;
        drawable.setBounds(rect);
        drawable.draw(canvas);
    }

    public Drawable getDivider() {
        return this.mDivider;
    }

    public void setDivider(Drawable drawable) {
        boolean z = false;
        if (drawable != null) {
            this.bdO = drawable.getIntrinsicWidth();
        } else {
            this.bdO = 0;
        }
        this.mDivider = drawable;
        this.mDividerIsOpaque = (drawable == null || drawable.getOpacity() == -1) ? true : true;
        requestLayout();
        invalidate();
    }

    public int getDividerWidth() {
        return this.bdO;
    }

    public void setDividerWidth(int i) {
        this.bdO = i;
        requestLayout();
        invalidate();
    }

    public void setHeaderDividersEnabled(boolean z) {
        this.mHeaderDividersEnabled = z;
        invalidate();
    }

    public void setFooterDividersEnabled(boolean z) {
        this.mFooterDividersEnabled = z;
        invalidate();
    }

    public void setOverscrollHeader(Drawable drawable) {
        this.mOverScrollHeader = drawable;
        if (getScrollX() < 0) {
            invalidate();
        }
    }

    public Drawable getOverscrollHeader() {
        return this.mOverScrollHeader;
    }

    public void setOverscrollFooter(Drawable drawable) {
        this.mOverScrollFooter = drawable;
        invalidate();
    }

    public Drawable getOverscrollFooter() {
        return this.mOverScrollFooter;
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
            if (listAdapter.getCount() < getChildCount() + this.mFirstPosition) {
                this.mLayoutMode = 0;
                layoutChildren();
            }
            Rect rect2 = this.mTempRect;
            int i6 = Integer.MAX_VALUE;
            int childCount = getChildCount();
            int i7 = this.mFirstPosition;
            int i8 = 0;
            while (i8 < childCount) {
                if (listAdapter.isEnabled(i7 + i8)) {
                    View childAt = getChildAt(i8);
                    childAt.getDrawingRect(rect2);
                    offsetDescendantRectToMyCoords(childAt, rect2);
                    int distance = getDistance(rect, rect2, i);
                    if (distance < i6) {
                        i3 = i8;
                        i6 = distance;
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
            aF(this.mFirstPosition + i5, i4);
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
        if (this.cTX != 0 && this.cUb != null && this.mAdapter != null) {
            SparseArrayCompat<Boolean> sparseArrayCompat = this.cUb;
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

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.a, android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(HListView.class.getName());
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.a, android.view.View
    @TargetApi(14)
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
            default:
                return super.onTouchEvent(motionEvent);
        }
    }

    public void setMaxWidth(int i) {
        this.BS = i;
    }

    /* loaded from: classes.dex */
    private class d extends GestureDetector.SimpleOnGestureListener {
        private d() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return Math.abs(f) > Math.abs(f2);
        }
    }
}
