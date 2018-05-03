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
import android.support.v7.widget.ActivityChooserView;
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
import com.baidu.tieba.d;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
import java.util.ArrayList;
@RemoteViews.RemoteView
/* loaded from: classes.dex */
public class HListView extends AbsHListView {
    private static final String LOG_TAG = "HListView";
    private static final float MAX_SCROLL_FACTOR = 0.33f;
    private static final int MIN_SCROLL_PREVIEW_PIXELS = 2;
    static final int NO_POSITION = -1;
    private boolean mAreAllItemsSelectable;
    private final a mArrowScrollFocusResult;
    Drawable mDivider;
    private boolean mDividerIsOpaque;
    private Paint mDividerPaint;
    int mDividerWidth;
    private c mFocusSelector;
    private boolean mFooterDividersEnabled;
    private ArrayList<b> mFooterViewInfos;
    private GestureDetector mGestureDetector;
    private boolean mHeaderDividersEnabled;
    private ArrayList<b> mHeaderViewInfos;
    private boolean mIsCacheColorOpaque;
    private boolean mItemsCanFocus;
    private int mMaxWidth;
    int mMeasureWithChild;
    Drawable mOverScrollFooter;
    Drawable mOverScrollHeader;
    private final Rect mTempRect;

    /* loaded from: classes.dex */
    public static class b {
        public Object data;
        public boolean isSelectable;

        /* renamed from: view  reason: collision with root package name */
        public View f16view;
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
        this.mArrowScrollFocusResult = new a();
        this.mMaxWidth = 0;
        this.mGestureDetector = new GestureDetector(new d());
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, d.m.HListView, i, 0);
        if (obtainStyledAttributes != null) {
            charSequenceArr = obtainStyledAttributes.getTextArray(d.m.HListView_android_entries);
            drawable3 = obtainStyledAttributes.getDrawable(d.m.HListView_android_divider);
            drawable2 = obtainStyledAttributes.getDrawable(d.m.HListView_hlv_overScrollHeader);
            drawable = obtainStyledAttributes.getDrawable(d.m.HListView_hlv_overScrollFooter);
            i2 = obtainStyledAttributes.getDimensionPixelSize(d.m.HListView_hlv_dividerWidth, 0);
            z = obtainStyledAttributes.getBoolean(d.m.HListView_hlv_headerDividersEnabled, true);
            z2 = obtainStyledAttributes.getBoolean(d.m.HListView_hlv_footerDividersEnabled, true);
            i3 = obtainStyledAttributes.getInteger(d.m.HListView_hlv_measureWithChild, -1);
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
        this.mMeasureWithChild = i3;
    }

    public int getMaxScrollAmount() {
        return (int) (MAX_SCROLL_FACTOR * (getRight() - getLeft()));
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
    private void adjustViewsLeftOrRight() {
        int right;
        int i = 0;
        int childCount = getChildCount();
        if (childCount > 0) {
            if (!this.mStackFromRight) {
                right = getChildAt(0).getLeft() - this.mListPadding.left;
                if (this.mFirstPosition != 0) {
                    right -= this.mDividerWidth;
                }
            } else {
                right = getChildAt(childCount - 1).getRight() - (getWidth() - this.mListPadding.right);
                if (childCount + this.mFirstPosition < this.mItemCount) {
                    right += this.mDividerWidth;
                }
            }
            if (i != 0) {
                offsetChildrenLeftAndRight(-i);
            }
        }
    }

    public void addHeaderView(View view2, Object obj, boolean z) {
        if (this.mAdapter != null && !(this.mAdapter instanceof com.baidu.tieba.horizonalList.widget.d)) {
            throw new IllegalStateException("Cannot add header view to list -- setAdapter has already been called.");
        }
        b bVar = new b();
        bVar.f16view = view2;
        bVar.data = obj;
        bVar.isSelectable = z;
        this.mHeaderViewInfos.add(bVar);
        if (this.mAdapter != null && this.mDataSetObserver != null) {
            this.mDataSetObserver.onChanged();
        }
    }

    public void addHeaderView(View view2) {
        addHeaderView(view2, null, true);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView
    public int getHeaderViewsCount() {
        return this.mHeaderViewInfos.size();
    }

    public boolean removeHeaderView(View view2) {
        boolean z;
        if (this.mHeaderViewInfos.size() > 0) {
            if (this.mAdapter == null || !((com.baidu.tieba.horizonalList.widget.d) this.mAdapter).removeHeader(view2)) {
                z = false;
            } else {
                if (this.mDataSetObserver != null) {
                    this.mDataSetObserver.onChanged();
                }
                z = true;
            }
            removeFixedViewInfo(view2, this.mHeaderViewInfos);
            return z;
        }
        return false;
    }

    private void removeFixedViewInfo(View view2, ArrayList<b> arrayList) {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (arrayList.get(i).f16view == view2) {
                arrayList.remove(i);
                return;
            }
        }
    }

    public void addFooterView(View view2, Object obj, boolean z) {
        b bVar = new b();
        bVar.f16view = view2;
        bVar.data = obj;
        bVar.isSelectable = z;
        this.mFooterViewInfos.add(bVar);
        if (this.mAdapter != null && this.mDataSetObserver != null) {
            this.mDataSetObserver.onChanged();
        }
    }

    public void addFooterView(View view2) {
        addFooterView(view2, null, true);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView
    public int getFooterViewsCount() {
        return this.mFooterViewInfos.size();
    }

    public boolean removeFooterView(View view2) {
        boolean z;
        if (this.mFooterViewInfos.size() > 0) {
            if (this.mAdapter == null || !((com.baidu.tieba.horizonalList.widget.d) this.mAdapter).removeFooter(view2)) {
                z = false;
            } else {
                if (this.mDataSetObserver != null) {
                    this.mDataSetObserver.onChanged();
                }
                z = true;
            }
            removeFixedViewInfo(view2, this.mFooterViewInfos);
            return z;
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.horizonalList.widget.AdapterView
    public ListAdapter getAdapter() {
        return this.mAdapter;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        int lookForSelectablePosition;
        if (this.mAdapter != null && this.mDataSetObserver != null) {
            this.mAdapter.unregisterDataSetObserver(this.mDataSetObserver);
        }
        resetList();
        this.mRecycler.clear();
        if (this.mHeaderViewInfos.size() > 0 || this.mFooterViewInfos.size() > 0) {
            this.mAdapter = new com.baidu.tieba.horizonalList.widget.d(this.mHeaderViewInfos, this.mFooterViewInfos, listAdapter);
        } else {
            this.mAdapter = listAdapter;
        }
        this.mOldSelectedPosition = -1;
        this.mOldSelectedColId = Long.MIN_VALUE;
        super.setAdapter(listAdapter);
        if (this.mAdapter != null) {
            this.mAreAllItemsSelectable = this.mAdapter.areAllItemsEnabled();
            this.mOldItemCount = this.mItemCount;
            this.mItemCount = this.mAdapter.getCount();
            checkFocus();
            this.mDataSetObserver = new AbsHListView.a();
            this.mAdapter.registerDataSetObserver(this.mDataSetObserver);
            this.mRecycler.mr(this.mAdapter.getViewTypeCount());
            if (this.mStackFromRight) {
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
            checkFocus();
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
                AbsHListView.f fVar = (AbsHListView.f) arrayList.get(i).f16view.getLayoutParams();
                if (fVar != null) {
                    fVar.dFX = false;
                }
            }
        }
    }

    private boolean showingLeftFadingEdge() {
        return this.mFirstPosition > 0 || getChildAt(0).getLeft() > getScrollX() + this.mListPadding.left;
    }

    private boolean showingRightFadingEdge() {
        int childCount = getChildCount();
        return (childCount + this.mFirstPosition) + (-1) < this.mItemCount + (-1) || getChildAt(childCount + (-1)).getRight() < (getScrollX() + getWidth()) - this.mListPadding.right;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view2, Rect rect, boolean z) {
        int i;
        int i2;
        int i3;
        int i4 = rect.left;
        rect.offset(view2.getLeft(), view2.getTop());
        rect.offset(-view2.getScrollX(), -view2.getScrollY());
        int width = getWidth();
        int scrollX = getScrollX();
        int i5 = scrollX + width;
        int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
        if (showingLeftFadingEdge() && (this.mSelectedPosition > 0 || i4 > horizontalFadingEdgeLength)) {
            scrollX += horizontalFadingEdgeLength;
        }
        int right = getChildAt(getChildCount() - 1).getRight();
        if (showingRightFadingEdge() && (this.mSelectedPosition < this.mItemCount - 1 || rect.right < right - horizontalFadingEdgeLength)) {
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
            positionSelector(-1, view2);
            this.mSelectedLeft = view2.getTop();
            invalidate();
        }
        return z2;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView
    protected void fillGap(boolean z) {
        int childCount = getChildCount();
        if (z) {
            fillRight(childCount + this.mFirstPosition, childCount > 0 ? getChildAt(childCount - 1).getRight() + this.mDividerWidth : 0);
            correctTooWide(getChildCount());
            return;
        }
        fillLeft(this.mFirstPosition - 1, childCount > 0 ? getChildAt(0).getLeft() - this.mDividerWidth : getWidth() - 0);
        correctTooSmall(getChildCount());
    }

    private View fillRight(int i, int i2) {
        View view2 = null;
        int right = getRight() - getLeft();
        int i3 = i2;
        int i4 = i;
        while (i3 < right && i4 < this.mItemCount) {
            boolean z = i4 == this.mSelectedPosition;
            View makeAndAddView = makeAndAddView(i4, i3, true, this.mListPadding.top, z);
            i3 = makeAndAddView.getRight() + this.mDividerWidth;
            if (!z) {
                makeAndAddView = view2;
            }
            i4++;
            view2 = makeAndAddView;
        }
        setVisibleRangeHint(this.mFirstPosition, (this.mFirstPosition + getChildCount()) - 1);
        return view2;
    }

    private View fillLeft(int i, int i2) {
        View view2 = null;
        int i3 = i2;
        int i4 = i;
        while (i3 > 0 && i4 >= 0) {
            boolean z = i4 == this.mSelectedPosition;
            View makeAndAddView = makeAndAddView(i4, i3, false, this.mListPadding.top, z);
            i3 = makeAndAddView.getLeft() - this.mDividerWidth;
            if (!z) {
                makeAndAddView = view2;
            }
            i4--;
            view2 = makeAndAddView;
        }
        this.mFirstPosition = i4 + 1;
        setVisibleRangeHint(this.mFirstPosition, (this.mFirstPosition + getChildCount()) - 1);
        return view2;
    }

    private View fillFromLeft(int i) {
        this.mFirstPosition = Math.min(this.mFirstPosition, this.mSelectedPosition);
        this.mFirstPosition = Math.min(this.mFirstPosition, this.mItemCount - 1);
        if (this.mFirstPosition < 0) {
            this.mFirstPosition = 0;
        }
        return fillRight(this.mFirstPosition, i);
    }

    private View fillFromMiddle(int i, int i2) {
        int i3 = i2 - i;
        int reconcileSelectedPosition = reconcileSelectedPosition();
        View makeAndAddView = makeAndAddView(reconcileSelectedPosition, i, true, this.mListPadding.top, true);
        this.mFirstPosition = reconcileSelectedPosition;
        int measuredWidth = makeAndAddView.getMeasuredWidth();
        if (measuredWidth <= i3) {
            makeAndAddView.offsetLeftAndRight((i3 - measuredWidth) / 2);
        }
        fillBeforeAndAfter(makeAndAddView, reconcileSelectedPosition);
        if (!this.mStackFromRight) {
            correctTooWide(getChildCount());
        } else {
            correctTooSmall(getChildCount());
        }
        return makeAndAddView;
    }

    private void fillBeforeAndAfter(View view2, int i) {
        int i2 = this.mDividerWidth;
        if (!this.mStackFromRight) {
            fillLeft(i - 1, view2.getLeft() - i2);
            adjustViewsLeftOrRight();
            fillRight(i + 1, i2 + view2.getRight());
            return;
        }
        fillRight(i + 1, view2.getRight() + i2);
        adjustViewsLeftOrRight();
        fillLeft(i - 1, view2.getLeft() - i2);
    }

    private View fillFromSelection(int i, int i2, int i3) {
        int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
        int i4 = this.mSelectedPosition;
        int leftSelectionPixel = getLeftSelectionPixel(i2, horizontalFadingEdgeLength, i4);
        int rightSelectionPixel = getRightSelectionPixel(i3, horizontalFadingEdgeLength, i4);
        View makeAndAddView = makeAndAddView(i4, i, true, this.mListPadding.top, true);
        if (makeAndAddView.getRight() > rightSelectionPixel) {
            makeAndAddView.offsetLeftAndRight(-Math.min(makeAndAddView.getLeft() - leftSelectionPixel, makeAndAddView.getRight() - rightSelectionPixel));
        } else if (makeAndAddView.getLeft() < leftSelectionPixel) {
            makeAndAddView.offsetLeftAndRight(Math.min(leftSelectionPixel - makeAndAddView.getLeft(), rightSelectionPixel - makeAndAddView.getRight()));
        }
        fillBeforeAndAfter(makeAndAddView, i4);
        if (!this.mStackFromRight) {
            correctTooWide(getChildCount());
        } else {
            correctTooSmall(getChildCount());
        }
        return makeAndAddView;
    }

    private int getRightSelectionPixel(int i, int i2, int i3) {
        if (i3 != this.mItemCount - 1) {
            return i - i2;
        }
        return i;
    }

    private int getLeftSelectionPixel(int i, int i2, int i3) {
        if (i3 > 0) {
            return i + i2;
        }
        return i;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView
    public void smoothScrollToPosition(int i) {
        super.smoothScrollToPosition(i);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView
    public void smoothScrollByOffset(int i) {
        super.smoothScrollByOffset(i);
    }

    private View moveSelection(View view2, View view3, int i, int i2, int i3) {
        View makeAndAddView;
        int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
        int i4 = this.mSelectedPosition;
        int leftSelectionPixel = getLeftSelectionPixel(i2, horizontalFadingEdgeLength, i4);
        int rightSelectionPixel = getRightSelectionPixel(i2, horizontalFadingEdgeLength, i4);
        if (i > 0) {
            View makeAndAddView2 = makeAndAddView(i4 - 1, view2.getLeft(), true, this.mListPadding.top, false);
            int i5 = this.mDividerWidth;
            makeAndAddView = makeAndAddView(i4, makeAndAddView2.getRight() + i5, true, this.mListPadding.top, true);
            if (makeAndAddView.getRight() > rightSelectionPixel) {
                int min = Math.min(Math.min(makeAndAddView.getLeft() - leftSelectionPixel, makeAndAddView.getRight() - rightSelectionPixel), (i3 - i2) / 2);
                makeAndAddView2.offsetLeftAndRight(-min);
                makeAndAddView.offsetLeftAndRight(-min);
            }
            if (!this.mStackFromRight) {
                fillLeft(this.mSelectedPosition - 2, makeAndAddView.getLeft() - i5);
                adjustViewsLeftOrRight();
                fillRight(this.mSelectedPosition + 1, makeAndAddView.getRight() + i5);
            } else {
                fillRight(this.mSelectedPosition + 1, makeAndAddView.getRight() + i5);
                adjustViewsLeftOrRight();
                fillLeft(this.mSelectedPosition - 2, makeAndAddView.getLeft() - i5);
            }
        } else if (i < 0) {
            if (view3 != null) {
                makeAndAddView = makeAndAddView(i4, view3.getLeft(), true, this.mListPadding.top, true);
            } else {
                makeAndAddView = makeAndAddView(i4, view2.getLeft(), false, this.mListPadding.top, true);
            }
            if (makeAndAddView.getLeft() < leftSelectionPixel) {
                makeAndAddView.offsetLeftAndRight(Math.min(Math.min(leftSelectionPixel - makeAndAddView.getLeft(), rightSelectionPixel - makeAndAddView.getRight()), (i3 - i2) / 2));
            }
            fillBeforeAndAfter(makeAndAddView, i4);
        } else {
            int left = view2.getLeft();
            makeAndAddView = makeAndAddView(i4, left, true, this.mListPadding.top, true);
            if (left < i2 && makeAndAddView.getRight() < i2 + 20) {
                makeAndAddView.offsetLeftAndRight(i2 - makeAndAddView.getLeft());
            }
            fillBeforeAndAfter(makeAndAddView, i4);
        }
        return makeAndAddView;
    }

    /* loaded from: classes.dex */
    private class c implements Runnable {
        private int dHu;
        private int mPosition;

        private c() {
        }

        public c aU(int i, int i2) {
            this.mPosition = i;
            this.dHu = i2;
            return this;
        }

        @Override // java.lang.Runnable
        public void run() {
            HListView.this.setSelectionFromLeft(this.mPosition, this.dHu);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        View focusedChild;
        if (getChildCount() > 0 && (focusedChild = getFocusedChild()) != null) {
            int indexOfChild = this.mFirstPosition + indexOfChild(focusedChild);
            int left = focusedChild.getLeft() - Math.max(0, focusedChild.getRight() - (i - getPaddingLeft()));
            if (this.mFocusSelector == null) {
                this.mFocusSelector = new c();
            }
            post(this.mFocusSelector.aU(indexOfChild, left));
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
            measureScrapChildWidth(obtainView, 0, i2);
            i4 = obtainView.getMeasuredWidth();
            i5 = obtainView.getMeasuredHeight();
            r1 = Build.VERSION.SDK_INT >= 11 ? combineMeasuredStates(0, obtainView.getMeasuredState()) : 0;
            if (recycleOnMeasure() && this.mRecycler.ms(((AbsHListView.f) obtainView.getLayoutParams()).dFW)) {
                this.mRecycler.p(obtainView, -1);
            }
        }
        int i6 = i5;
        int i7 = i4;
        if (mode2 == 0) {
            i3 = i6 + this.mListPadding.top + this.mListPadding.bottom + getHorizontalScrollbarHeight();
        } else if (mode2 == Integer.MIN_VALUE && this.mItemCount > 0 && this.mMeasureWithChild > -1) {
            i3 = measureWithLargeChildren(i2, this.mMeasureWithChild, this.mMeasureWithChild, size, size2, -1)[1];
        } else {
            i3 = Build.VERSION.SDK_INT >= 11 ? size2 | ((-16777216) & r1) : size2;
        }
        if (mode == 0) {
            size = this.mListPadding.left + this.mListPadding.right + i7 + (getHorizontalFadingEdgeLength() * 2);
        }
        if (mode == Integer.MIN_VALUE) {
            if (this.mMaxWidth > 0 && this.mMaxWidth < size) {
                size = this.mMaxWidth;
            }
            size = measureWidthOfChildren(i2, 0, -1, size, -1);
        }
        setMeasuredDimension(size, i3);
        this.mHeightMeasureSpec = i2;
    }

    private void measureScrapChildWidth(View view2, int i, int i2) {
        int makeMeasureSpec;
        AbsHListView.f fVar = (AbsHListView.f) view2.getLayoutParams();
        if (fVar == null) {
            fVar = (AbsHListView.f) generateDefaultLayoutParams();
            view2.setLayoutParams(fVar);
        }
        fVar.dFW = this.mAdapter.getItemViewType(i);
        fVar.dFY = true;
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, this.mListPadding.top + this.mListPadding.bottom, fVar.height);
        int i3 = fVar.width;
        if (i3 > 0) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view2.measure(makeMeasureSpec, childMeasureSpec);
    }

    public int[] measureChild(View view2) {
        measureItem(view2);
        return new int[]{view2.getMeasuredWidth(), view2.getMeasuredHeight()};
    }

    @ViewDebug.ExportedProperty(category = "list")
    protected boolean recycleOnMeasure() {
        return true;
    }

    final int measureWidthOfChildren(int i, int i2, int i3, int i4, int i5) {
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter == null) {
            return this.mListPadding.left + this.mListPadding.right;
        }
        int i6 = this.mListPadding.left + this.mListPadding.right;
        int i7 = this.mDividerWidth;
        int i8 = 0;
        if (i3 == -1) {
            i3 = listAdapter.getCount() - 1;
        }
        AbsHListView.k kVar = this.mRecycler;
        boolean recycleOnMeasure = recycleOnMeasure();
        boolean[] zArr = this.mIsScrap;
        while (i2 <= i3) {
            View obtainView = obtainView(i2, zArr);
            measureScrapChildWidth(obtainView, i2, i);
            int i9 = i2 > 0 ? i6 + i7 : i6;
            if (recycleOnMeasure && kVar.ms(((AbsHListView.f) obtainView.getLayoutParams()).dFW)) {
                kVar.p(obtainView, -1);
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

    final int[] measureWithLargeChildren(int i, int i2, int i3, int i4, int i5, int i6) {
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter == null) {
            return new int[]{this.mListPadding.left + this.mListPadding.right, this.mListPadding.top + this.mListPadding.bottom};
        }
        int i7 = this.mListPadding.left + this.mListPadding.right;
        int i8 = this.mListPadding.top + this.mListPadding.bottom;
        int i9 = this.mDividerWidth;
        if (i3 == -1) {
            i3 = listAdapter.getCount() - 1;
        }
        AbsHListView.k kVar = this.mRecycler;
        boolean recycleOnMeasure = recycleOnMeasure();
        boolean[] zArr = this.mIsScrap;
        int i10 = 0;
        int i11 = 0;
        while (i2 <= i3) {
            View obtainView = obtainView(i2, zArr);
            measureScrapChildWidth(obtainView, i2, i);
            if (recycleOnMeasure && kVar.ms(((AbsHListView.f) obtainView.getLayoutParams()).dFW)) {
                kVar.p(obtainView, -1);
            }
            i10 = Math.max(i10, obtainView.getMeasuredWidth() + i9);
            i2++;
            i11 = Math.max(i11, obtainView.getMeasuredHeight());
        }
        return new int[]{Math.min(i10 + i7, i4), Math.min(i11 + i8, i5)};
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView
    protected int findMotionCol(int i) {
        int childCount = getChildCount();
        if (childCount > 0) {
            if (this.mStackFromRight) {
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
        View fillRight;
        View fillLeft;
        boolean z = i == this.mSelectedPosition;
        View makeAndAddView = makeAndAddView(i, i2, true, this.mListPadding.top, z);
        this.mFirstPosition = i;
        int i3 = this.mDividerWidth;
        if (!this.mStackFromRight) {
            fillLeft = fillLeft(i - 1, makeAndAddView.getLeft() - i3);
            adjustViewsLeftOrRight();
            fillRight = fillRight(i + 1, i3 + makeAndAddView.getRight());
            int childCount = getChildCount();
            if (childCount > 0) {
                correctTooWide(childCount);
            }
        } else {
            fillRight = fillRight(i + 1, makeAndAddView.getRight() + i3);
            adjustViewsLeftOrRight();
            fillLeft = fillLeft(i - 1, makeAndAddView.getLeft() - i3);
            int childCount2 = getChildCount();
            if (childCount2 > 0) {
                correctTooSmall(childCount2);
            }
        }
        if (z) {
            return makeAndAddView;
        }
        return fillLeft != null ? fillLeft : fillRight;
    }

    private void correctTooWide(int i) {
        if ((this.mFirstPosition + i) - 1 == this.mItemCount - 1 && i > 0) {
            int right = ((getRight() - getLeft()) - this.mListPadding.right) - getChildAt(i - 1).getRight();
            View childAt = getChildAt(0);
            int left = childAt.getLeft();
            if (right > 0) {
                if (this.mFirstPosition > 0 || left < this.mListPadding.top) {
                    if (this.mFirstPosition == 0) {
                        right = Math.min(right, this.mListPadding.top - left);
                    }
                    offsetChildrenLeftAndRight(right);
                    if (this.mFirstPosition > 0) {
                        fillLeft(this.mFirstPosition - 1, childAt.getLeft() - this.mDividerWidth);
                        adjustViewsLeftOrRight();
                    }
                }
            }
        }
    }

    private void correctTooSmall(int i) {
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
                    offsetChildrenLeftAndRight(-i3);
                    if (i4 < this.mItemCount - 1) {
                        fillRight(i4 + 1, childAt.getRight() + this.mDividerWidth);
                        adjustViewsLeftOrRight();
                    }
                } else if (i4 == this.mItemCount - 1) {
                    adjustViewsLeftOrRight();
                }
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, CONST, IPUT] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1921=4, 1922=4] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView
    public void layoutChildren() {
        View view2;
        View view3;
        View view4;
        View moveSelection;
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
            View view5 = null;
            View view6 = null;
            View view7 = null;
            switch (this.mLayoutMode) {
                case 1:
                case 3:
                case 4:
                case 5:
                    view2 = null;
                    break;
                case 2:
                    int i2 = this.mNextSelectedPosition - this.mFirstPosition;
                    if (i2 < 0 || i2 >= childCount) {
                        view2 = null;
                        break;
                    } else {
                        view6 = getChildAt(i2);
                        view2 = null;
                        break;
                    }
                default:
                    int i3 = this.mSelectedPosition - this.mFirstPosition;
                    if (i3 >= 0 && i3 < childCount) {
                        view5 = getChildAt(i3);
                    }
                    View childAt = getChildAt(0);
                    r4 = this.mNextSelectedPosition >= 0 ? this.mNextSelectedPosition - this.mSelectedPosition : 0;
                    view6 = getChildAt(i3 + r4);
                    view2 = childAt;
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
                setSelectedPositionInt(this.mNextSelectedPosition);
                int i4 = this.mFirstPosition;
                AbsHListView.k kVar = this.mRecycler;
                View view8 = null;
                if (z2) {
                    for (int i5 = 0; i5 < childCount; i5++) {
                        kVar.p(getChildAt(i5), i4 + i5);
                    }
                } else {
                    kVar.aS(childCount, i4);
                }
                View focusedChild = getFocusedChild();
                if (focusedChild != null) {
                    if (!z2 || isDirectChildHeaderOrFooter(focusedChild)) {
                        view7 = findFocus();
                        if (view7 != null) {
                            view7.onStartTemporaryDetach();
                        }
                        view8 = focusedChild;
                    }
                    requestFocus();
                    view3 = view7;
                    view4 = view8;
                } else {
                    view3 = null;
                    view4 = null;
                }
                detachAllViewsFromParent();
                kVar.ayj();
                switch (this.mLayoutMode) {
                    case 1:
                        this.mFirstPosition = 0;
                        View fillFromLeft = fillFromLeft(i);
                        adjustViewsLeftOrRight();
                        moveSelection = fillFromLeft;
                        break;
                    case 2:
                        if (view6 != null) {
                            moveSelection = fillFromSelection(view6.getLeft(), i, right);
                            break;
                        } else {
                            moveSelection = fillFromMiddle(i, right);
                            break;
                        }
                    case 3:
                        View fillLeft = fillLeft(this.mItemCount - 1, right);
                        adjustViewsLeftOrRight();
                        moveSelection = fillLeft;
                        break;
                    case 4:
                        moveSelection = fillSpecific(reconcileSelectedPosition(), this.mSpecificLeft);
                        break;
                    case 5:
                        moveSelection = fillSpecific(this.mSyncPosition, this.mSpecificLeft);
                        break;
                    case 6:
                        moveSelection = moveSelection(view5, view6, r4, i, right);
                        break;
                    default:
                        if (childCount == 0) {
                            if (this.mStackFromRight) {
                                setSelectedPositionInt(lookForSelectablePosition(this.mItemCount - 1, false));
                                moveSelection = fillLeft(this.mItemCount - 1, right);
                                break;
                            } else {
                                setSelectedPositionInt(lookForSelectablePosition(0, true));
                                moveSelection = fillFromLeft(i);
                                break;
                            }
                        } else if (this.mSelectedPosition < 0 || this.mSelectedPosition >= this.mItemCount) {
                            if (this.mFirstPosition < this.mItemCount) {
                                int i6 = this.mFirstPosition;
                                if (view2 != null) {
                                    i = view2.getLeft();
                                }
                                moveSelection = fillSpecific(i6, i);
                                break;
                            } else {
                                moveSelection = fillSpecific(0, i);
                                break;
                            }
                        } else {
                            int i7 = this.mSelectedPosition;
                            if (view5 != null) {
                                i = view5.getLeft();
                            }
                            moveSelection = fillSpecific(i7, i);
                            break;
                        }
                }
                kVar.ayk();
                if (moveSelection != null) {
                    if (!this.mItemsCanFocus || !hasFocus() || moveSelection.hasFocus()) {
                        positionSelector(-1, moveSelection);
                    } else if ((moveSelection == view4 && view3 != null && view3.requestFocus()) || moveSelection.requestFocus()) {
                        moveSelection.setSelected(false);
                        this.mSelectorRect.setEmpty();
                    } else {
                        View focusedChild2 = getFocusedChild();
                        if (focusedChild2 != null) {
                            focusedChild2.clearFocus();
                        }
                        positionSelector(-1, moveSelection);
                    }
                    this.mSelectedLeft = moveSelection.getLeft();
                } else {
                    if (this.mTouchMode <= 0 || this.mTouchMode >= 3) {
                        this.mSelectedLeft = 0;
                        this.mSelectorRect.setEmpty();
                    } else {
                        View childAt2 = getChildAt(this.mMotionPosition - this.mFirstPosition);
                        if (childAt2 != null) {
                            positionSelector(this.mMotionPosition, childAt2);
                        }
                    }
                    if (hasFocus() && view3 != null) {
                        view3.requestFocus();
                    }
                }
                if (view3 != null && view3.getWindowToken() != null) {
                    view3.onFinishTemporaryDetach();
                }
                this.mLayoutMode = 0;
                this.mDataChanged = false;
                if (this.mPositionScrollAfterLayout != null) {
                    post(this.mPositionScrollAfterLayout);
                    this.mPositionScrollAfterLayout = null;
                }
                this.mNeedSync = false;
                setNextSelectedPositionInt(this.mSelectedPosition);
                updateScrollIndicators();
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

    private View findAccessibilityFocusedChild(View view2) {
        ViewParent parent = view2.getParent();
        while ((parent instanceof View) && parent != this) {
            parent = parent.getParent();
            view2 = (View) parent;
        }
        if (!(parent instanceof View)) {
            return null;
        }
        return view2;
    }

    private boolean isDirectChildHeaderOrFooter(View view2) {
        ArrayList<b> arrayList = this.mHeaderViewInfos;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (view2 == arrayList.get(i).f16view) {
                return true;
            }
        }
        ArrayList<b> arrayList2 = this.mFooterViewInfos;
        int size2 = arrayList2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            if (view2 == arrayList2.get(i2).f16view) {
                return true;
            }
        }
        return false;
    }

    private View makeAndAddView(int i, int i2, boolean z, int i3, boolean z2) {
        View mt;
        if (!this.mDataChanged && (mt = this.mRecycler.mt(i)) != null) {
            setupChild(mt, i, i2, z, i3, z2, true);
            return mt;
        }
        View obtainView = obtainView(i, this.mIsScrap);
        setupChild(obtainView, i, i2, z, i3, z2, this.mIsScrap[0]);
        return obtainView;
    }

    @TargetApi(11)
    private void setupChild(View view2, int i, int i2, boolean z, int i3, boolean z2, boolean z3) {
        int makeMeasureSpec;
        boolean z4 = z2 && shouldShowSelector();
        boolean z5 = z4 != view2.isSelected();
        int i4 = this.mTouchMode;
        boolean z6 = i4 > 0 && i4 < 3 && this.mMotionPosition == i;
        boolean z7 = z6 != view2.isPressed();
        boolean z8 = !z3 || z5 || view2.isLayoutRequested();
        AbsHListView.f fVar = (AbsHListView.f) view2.getLayoutParams();
        AbsHListView.f fVar2 = fVar == null ? (AbsHListView.f) generateDefaultLayoutParams() : fVar;
        fVar2.dFW = this.mAdapter.getItemViewType(i);
        if ((z3 && !fVar2.dFY) || (fVar2.dFX && fVar2.dFW == -2)) {
            attachViewToParent(view2, z ? -1 : 0, fVar2);
        } else {
            fVar2.dFY = false;
            if (fVar2.dFW == -2) {
                fVar2.dFX = true;
            }
            addViewInLayout(view2, z ? -1 : 0, fVar2, true);
        }
        if (z5) {
            view2.setSelected(z4);
        }
        if (z7) {
            view2.setPressed(z6);
        }
        if (this.mChoiceMode != 0 && this.mCheckStates != null) {
            if (view2 instanceof Checkable) {
                ((Checkable) view2).setChecked(this.mCheckStates.get(i, false).booleanValue());
            } else if (Build.VERSION.SDK_INT >= 11) {
                view2.setActivated(this.mCheckStates.get(i, false).booleanValue());
            }
        }
        if (z8) {
            int childMeasureSpec = ViewGroup.getChildMeasureSpec(this.mHeightMeasureSpec, this.mListPadding.top + this.mListPadding.bottom, fVar2.height);
            int i5 = fVar2.width;
            if (i5 > 0) {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i5, 1073741824);
            } else {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            }
            view2.measure(makeMeasureSpec, childMeasureSpec);
        } else {
            cleanupLayoutState(view2);
        }
        int measuredWidth = view2.getMeasuredWidth();
        int measuredHeight = view2.getMeasuredHeight();
        if (!z) {
            i2 -= measuredWidth;
        }
        if (z8) {
            view2.layout(i2, i3, measuredWidth + i2, measuredHeight + i3);
        } else {
            view2.offsetLeftAndRight(i2 - view2.getLeft());
            view2.offsetTopAndBottom(i3 - view2.getTop());
        }
        if (this.mCachingStarted && !view2.isDrawingCacheEnabled()) {
            view2.setDrawingCacheEnabled(true);
        }
        if (Build.VERSION.SDK_INT >= 11 && z3 && ((AbsHListView.f) view2.getLayoutParams()).dFZ != i) {
            view2.jumpDrawablesToCurrentState();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.AdapterView, android.view.ViewGroup
    public boolean canAnimate() {
        return super.canAnimate() && this.mItemCount > 0;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AdapterView
    public void setSelection(int i) {
        setSelectionFromLeft(i, 0);
    }

    public void setSelectionFromLeft(int i, int i2) {
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
                this.mSpecificLeft = this.mListPadding.left + i2;
                if (this.mNeedSync) {
                    this.mSyncPosition = i;
                    this.mSyncColId = this.mAdapter.getItemId(i);
                }
                if (this.mPositionScroller != null) {
                    this.mPositionScroller.stop();
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
        if (this.mPositionScroller != null) {
            this.mPositionScroller.stop();
        }
        layoutChildren();
        if (z) {
            awakenScrollBars();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.horizonalList.widget.AdapterView
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

    public void setSelectionAfterHeaderView() {
        int size = this.mHeaderViewInfos.size();
        if (size > 0) {
            this.mNextSelectedPosition = 0;
        } else if (this.mAdapter != null) {
            setSelection(size);
        } else {
            this.mNextSelectedPosition = size;
            this.mLayoutMode = 2;
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
        return commonKey(i, 1, keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
        return commonKey(i, i2, keyEvent);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return commonKey(i, 1, keyEvent);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0029  */
    @TargetApi(11)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean commonKey(int i, int i2, KeyEvent keyEvent) {
        boolean z;
        if (this.mAdapter == null || !this.mIsAttached) {
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
                        z = handleHorizontalFocusWithinListItem(33);
                        break;
                    }
                    break;
                case 20:
                    if (keyEvent.hasNoModifiers()) {
                        z = handleHorizontalFocusWithinListItem(TransportMediator.KEYCODE_MEDIA_RECORD);
                        break;
                    }
                    break;
                case 21:
                    if (keyEvent.hasNoModifiers()) {
                        z = resurrectSelectionIfNeeded();
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
                        if (!resurrectSelectionIfNeeded() && !fullScroll(33)) {
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
                        z = resurrectSelectionIfNeeded();
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
                        if (!resurrectSelectionIfNeeded() && !fullScroll(TransportMediator.KEYCODE_MEDIA_RECORD)) {
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
                        z = resurrectSelectionIfNeeded();
                        if (!z && keyEvent.getRepeatCount() == 0 && getChildCount() > 0) {
                            keyPressed();
                            z = true;
                            break;
                        }
                    }
                    break;
                case 62:
                    if (!keyEvent.hasNoModifiers() ? !keyEvent.hasModifiers(1) || resurrectSelectionIfNeeded() || pageScroll(33) : resurrectSelectionIfNeeded() || pageScroll(TransportMediator.KEYCODE_MEDIA_RECORD)) {
                    }
                    z = true;
                    break;
                case 92:
                    if (keyEvent.hasNoModifiers()) {
                        if (!resurrectSelectionIfNeeded() && !pageScroll(33)) {
                            z = false;
                            break;
                        } else {
                            z = true;
                            break;
                        }
                    } else if (keyEvent.hasModifiers(2)) {
                        if (!resurrectSelectionIfNeeded() && !fullScroll(33)) {
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
                        if (!resurrectSelectionIfNeeded() && !pageScroll(TransportMediator.KEYCODE_MEDIA_RECORD)) {
                            z = false;
                            break;
                        } else {
                            z = true;
                            break;
                        }
                    } else if (keyEvent.hasModifiers(2)) {
                        if (!resurrectSelectionIfNeeded() && !fullScroll(TransportMediator.KEYCODE_MEDIA_RECORD)) {
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
                        if (!resurrectSelectionIfNeeded() && !fullScroll(33)) {
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
                        if (!resurrectSelectionIfNeeded() && !fullScroll(TransportMediator.KEYCODE_MEDIA_RECORD)) {
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
        this.mSpecificLeft = getPaddingLeft() + getHorizontalFadingEdgeLength();
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

    private boolean handleHorizontalFocusWithinListItem(int i) {
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
                return isViewAncestorOf(findNextFocus2, this);
            }
        }
        return false;
    }

    boolean arrowScroll(int i) {
        try {
            this.mInLayout = true;
            boolean arrowScrollImpl = arrowScrollImpl(i);
            if (arrowScrollImpl) {
                playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
            }
            return arrowScrollImpl;
        } finally {
            this.mInLayout = false;
        }
    }

    private boolean arrowScrollImpl(int i) {
        View view2;
        int i2;
        View view3;
        View focusedChild;
        if (getChildCount() <= 0) {
            return false;
        }
        View selectedView = getSelectedView();
        int i3 = this.mSelectedPosition;
        int lookForSelectablePositionOnScreen = lookForSelectablePositionOnScreen(i);
        int amountToScroll = amountToScroll(i, lookForSelectablePositionOnScreen);
        a arrowScrollFocused = this.mItemsCanFocus ? arrowScrollFocused(i) : null;
        if (arrowScrollFocused != null) {
            lookForSelectablePositionOnScreen = arrowScrollFocused.getSelectedPosition();
            amountToScroll = arrowScrollFocused.ayv();
        }
        boolean z = arrowScrollFocused != null;
        if (lookForSelectablePositionOnScreen != -1) {
            handleNewSelectionChange(selectedView, i, lookForSelectablePositionOnScreen, arrowScrollFocused != null);
            setSelectedPositionInt(lookForSelectablePositionOnScreen);
            setNextSelectedPositionInt(lookForSelectablePositionOnScreen);
            view2 = getSelectedView();
            if (this.mItemsCanFocus && arrowScrollFocused == null && (focusedChild = getFocusedChild()) != null) {
                focusedChild.clearFocus();
            }
            checkSelectionChanged();
            z = true;
            i2 = lookForSelectablePositionOnScreen;
        } else {
            view2 = selectedView;
            i2 = i3;
        }
        if (amountToScroll > 0) {
            scrollListItemsBy(i == 33 ? amountToScroll : -amountToScroll);
            z = true;
        }
        if (this.mItemsCanFocus && arrowScrollFocused == null && view2 != null && view2.hasFocus()) {
            View findFocus = view2.findFocus();
            if (!isViewAncestorOf(findFocus, this) || distanceToView(findFocus) > 0) {
                findFocus.clearFocus();
            }
        }
        if (lookForSelectablePositionOnScreen != -1 || view2 == null || isViewAncestorOf(view2, this)) {
            view3 = view2;
        } else {
            hideSelector();
            this.mResurrectToPosition = -1;
            view3 = null;
        }
        if (z) {
            if (view3 != null) {
                positionSelector(i2, view3);
                this.mSelectedLeft = view3.getLeft();
            }
            if (!awakenScrollBars()) {
                invalidate();
            }
            invokeOnItemScrollListener();
            return true;
        }
        return false;
    }

    private void handleNewSelectionChange(View view2, int i, int i2, boolean z) {
        View view3;
        int i3;
        boolean z2;
        boolean z3 = true;
        if (i2 == -1) {
            throw new IllegalArgumentException("newSelectedPosition needs to be valid");
        }
        int i4 = this.mSelectedPosition - this.mFirstPosition;
        int i5 = i2 - this.mFirstPosition;
        if (i == 33) {
            view3 = getChildAt(i5);
            i3 = i5;
            i5 = i4;
            z2 = true;
        } else {
            view3 = view2;
            view2 = getChildAt(i5);
            i3 = i4;
            z2 = false;
        }
        int childCount = getChildCount();
        if (view3 != null) {
            view3.setSelected(!z && z2);
            measureAndAdjustRight(view3, i3, childCount);
        }
        if (view2 != null) {
            if (z || z2) {
                z3 = false;
            }
            view2.setSelected(z3);
            measureAndAdjustRight(view2, i5, childCount);
        }
    }

    private void measureAndAdjustRight(View view2, int i, int i2) {
        int width = view2.getWidth();
        measureItem(view2);
        if (view2.getMeasuredWidth() != width) {
            relayoutMeasuredItem(view2);
            int measuredWidth = view2.getMeasuredWidth() - width;
            for (int i3 = i + 1; i3 < i2; i3++) {
                getChildAt(i3).offsetLeftAndRight(measuredWidth);
            }
        }
    }

    private void measureItem(View view2) {
        int makeMeasureSpec;
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-2, -1);
        }
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(this.mHeightMeasureSpec, this.mListPadding.top + this.mListPadding.bottom, layoutParams.height);
        int i = layoutParams.width;
        if (i > 0) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view2.measure(makeMeasureSpec, childMeasureSpec);
    }

    private void relayoutMeasuredItem(View view2) {
        int measuredWidth = view2.getMeasuredWidth();
        int measuredHeight = view2.getMeasuredHeight();
        int i = this.mListPadding.top;
        int left = view2.getLeft();
        view2.layout(left, i, measuredWidth + left, measuredHeight + i);
    }

    private int getArrowScrollPreviewLength() {
        return Math.max(2, getHorizontalFadingEdgeLength());
    }

    private int amountToScroll(int i, int i2) {
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
        private int dHt;
        private int mSelectedPosition;

        private a() {
        }

        void aT(int i, int i2) {
            this.mSelectedPosition = i;
            this.dHt = i2;
        }

        public int getSelectedPosition() {
            return this.mSelectedPosition;
        }

        public int ayv() {
            return this.dHt;
        }
    }

    private int lookForSelectablePositionOnScreen(int i) {
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

    private a arrowScrollFocused(int i) {
        View findNextFocusFromRect;
        int lookForSelectablePositionOnScreen;
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
            int positionOfNewFocus = positionOfNewFocus(findNextFocusFromRect);
            if (this.mSelectedPosition != -1 && positionOfNewFocus != this.mSelectedPosition && (lookForSelectablePositionOnScreen = lookForSelectablePositionOnScreen(i)) != -1 && ((i == 130 && lookForSelectablePositionOnScreen < positionOfNewFocus) || (i == 33 && lookForSelectablePositionOnScreen > positionOfNewFocus))) {
                return null;
            }
            int amountToScrollToNewFocus = amountToScrollToNewFocus(i, findNextFocusFromRect, positionOfNewFocus);
            int maxScrollAmount = getMaxScrollAmount();
            if (amountToScrollToNewFocus < maxScrollAmount) {
                findNextFocusFromRect.requestFocus(i);
                this.mArrowScrollFocusResult.aT(positionOfNewFocus, amountToScrollToNewFocus);
                return this.mArrowScrollFocusResult;
            } else if (distanceToView(findNextFocusFromRect) < maxScrollAmount) {
                findNextFocusFromRect.requestFocus(i);
                this.mArrowScrollFocusResult.aT(positionOfNewFocus, maxScrollAmount);
                return this.mArrowScrollFocusResult;
            }
        }
        return null;
    }

    private int positionOfNewFocus(View view2) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (isViewAncestorOf(view2, getChildAt(i))) {
                return i + this.mFirstPosition;
            }
        }
        throw new IllegalArgumentException("newFocus is not a child of any of the children of the list!");
    }

    private boolean isViewAncestorOf(View view2, View view3) {
        if (view2 == view3) {
            return true;
        }
        ViewParent parent = view2.getParent();
        return (parent instanceof ViewGroup) && isViewAncestorOf((View) parent, view3);
    }

    private int amountToScrollToNewFocus(int i, View view2, int i2) {
        view2.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(view2, this.mTempRect);
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

    private int distanceToView(View view2) {
        view2.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(view2, this.mTempRect);
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
        offsetChildrenLeftAndRight(i);
        int width = getWidth() - this.mListPadding.right;
        int i3 = this.mListPadding.left;
        AbsHListView.k kVar = this.mRecycler;
        if (i < 0) {
            int childCount = getChildCount();
            View childAt = getChildAt(childCount - 1);
            while (childAt.getRight() < width && (this.mFirstPosition + childCount) - 1 < this.mItemCount - 1) {
                childAt = addViewAfter(childAt, i2);
                childCount++;
            }
            if (childAt.getBottom() < width) {
                offsetChildrenLeftAndRight(width - childAt.getRight());
            }
            View childAt2 = getChildAt(0);
            while (true) {
                View view2 = childAt2;
                if (view2.getRight() < i3) {
                    if (kVar.ms(((AbsHListView.f) view2.getLayoutParams()).dFW)) {
                        detachViewFromParent(view2);
                        kVar.p(view2, this.mFirstPosition);
                    } else {
                        removeViewInLayout(view2);
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
                childAt3 = addViewBefore(childAt3, this.mFirstPosition);
                this.mFirstPosition--;
            }
            if (childAt3.getLeft() > i3) {
                offsetChildrenLeftAndRight(i3 - childAt3.getLeft());
            }
            int childCount2 = getChildCount() - 1;
            View childAt4 = getChildAt(childCount2);
            while (true) {
                int i4 = childCount2;
                View view3 = childAt4;
                if (view3.getLeft() > width) {
                    if (kVar.ms(((AbsHListView.f) view3.getLayoutParams()).dFW)) {
                        detachViewFromParent(view3);
                        kVar.p(view3, this.mFirstPosition + i4);
                    } else {
                        removeViewInLayout(view3);
                    }
                    childCount2 = i4 - 1;
                    childAt4 = getChildAt(childCount2);
                } else {
                    return;
                }
            }
        }
    }

    private View addViewBefore(View view2, int i) {
        int i2 = i - 1;
        View obtainView = obtainView(i2, this.mIsScrap);
        setupChild(obtainView, i2, view2.getLeft() - this.mDividerWidth, false, this.mListPadding.top, false, this.mIsScrap[0]);
        return obtainView;
    }

    private View addViewAfter(View view2, int i) {
        int i2 = i + 1;
        View obtainView = obtainView(i2, this.mIsScrap);
        setupChild(obtainView, i2, this.mDividerWidth + view2.getRight(), true, this.mListPadding.top, false, this.mIsScrap[0]);
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
        boolean z = (this.mCachingActive && this.mIsCacheColorOpaque && this.mDividerIsOpaque) || super.isOpaque();
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
            this.mCachingActive = true;
        }
        int i = this.mDividerWidth;
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
            if (!this.mStackFromRight) {
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
    protected boolean drawChild(Canvas canvas, View view2, long j) {
        boolean drawChild = super.drawChild(canvas, view2, j);
        if (this.mCachingActive) {
            this.mCachingActive = false;
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
            this.mDividerWidth = drawable.getIntrinsicWidth();
        } else {
            this.mDividerWidth = 0;
        }
        this.mDivider = drawable;
        this.mDividerIsOpaque = (drawable == null || drawable.getOpacity() == -1) ? true : true;
        requestLayout();
        invalidate();
    }

    public int getDividerWidth() {
        return this.mDividerWidth;
    }

    public void setDividerWidth(int i) {
        this.mDividerWidth = i;
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
            int i6 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
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
            setSelectionFromLeft(this.mFirstPosition + i5, i4);
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
        if (this.mChoiceMode != 0 && this.mCheckStates != null && this.mAdapter != null) {
            SparseArrayCompat<Boolean> sparseArrayCompat = this.mCheckStates;
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

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.AdapterView, android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(HListView.class.getName());
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.AdapterView, android.view.View
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
        try {
            return super.dispatchTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        if (getParent() == null || !this.mGestureDetector.onTouchEvent(motionEvent)) {
            return onInterceptTouchEvent;
        }
        requestDisallowInterceptTouchEvent(true);
        return true;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
            case 5:
            default:
                return super.onTouchEvent(motionEvent);
        }
    }

    public void setMaxWidth(int i) {
        this.mMaxWidth = i;
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
