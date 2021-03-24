package com.baidu.tieba.horizonalList.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
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
import androidx.collection.SparseArrayCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.tieba.R;
import com.baidu.tieba.R$styleable;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
import java.util.ArrayList;
@RemoteViews.RemoteView
/* loaded from: classes4.dex */
public class HListView extends AbsHListView {
    public static final String LOG_TAG = "HListView";
    public static final float MAX_SCROLL_FACTOR = 0.33f;
    public static final int MIN_SCROLL_PREVIEW_PIXELS = 2;
    public static final int NO_POSITION = -1;
    public boolean mAreAllItemsSelectable;
    public final b mArrowScrollFocusResult;
    public Drawable mDivider;
    public boolean mDividerIsOpaque;
    public Paint mDividerPaint;
    public int mDividerWidth;
    public d mFocusSelector;
    public boolean mFooterDividersEnabled;
    public ArrayList<c> mFooterViewInfos;
    public GestureDetector mGestureDetector;
    public boolean mHeaderDividersEnabled;
    public ArrayList<c> mHeaderViewInfos;
    public boolean mIsCacheColorOpaque;
    public boolean mItemsCanFocus;
    public int mMaxWidth;
    public int mMeasureWithChild;
    public Drawable mOverScrollFooter;
    public Drawable mOverScrollHeader;
    public final Rect mTempRect;

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f17515a;

        /* renamed from: b  reason: collision with root package name */
        public int f17516b;

        public b() {
        }

        public int a() {
            return this.f17516b;
        }

        public int b() {
            return this.f17515a;
        }

        public void c(int i, int i2) {
            this.f17515a = i;
            this.f17516b = i2;
        }
    }

    /* loaded from: classes4.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public View f17517a;

        /* renamed from: b  reason: collision with root package name */
        public Object f17518b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f17519c;
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public int f17520e;

        /* renamed from: f  reason: collision with root package name */
        public int f17521f;

        public d() {
        }

        public d a(int i, int i2) {
            this.f17520e = i;
            this.f17521f = i2;
            return this;
        }

        @Override // java.lang.Runnable
        public void run() {
            HListView.this.setSelectionFromLeft(this.f17520e, this.f17521f);
        }
    }

    /* loaded from: classes4.dex */
    public class e extends GestureDetector.SimpleOnGestureListener {
        public e() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            return Math.abs(f2) > Math.abs(f3);
        }
    }

    public HListView(Context context) {
        this(context, null);
    }

    private View addViewAfter(View view, int i) {
        int i2 = i + 1;
        View obtainView = obtainView(i2, this.mIsScrap);
        setupChild(obtainView, i2, view.getRight() + this.mDividerWidth, true, this.mListPadding.top, false, this.mIsScrap[0]);
        return obtainView;
    }

    private View addViewBefore(View view, int i) {
        int i2 = i - 1;
        View obtainView = obtainView(i2, this.mIsScrap);
        setupChild(obtainView, i2, view.getLeft() - this.mDividerWidth, false, this.mListPadding.top, false, this.mIsScrap[0]);
        return obtainView;
    }

    private void adjustViewsLeftOrRight() {
        int childCount = getChildCount();
        if (childCount > 0) {
            int i = 0;
            if (!this.mStackFromRight) {
                int left = getChildAt(0).getLeft() - this.mListPadding.left;
                if (this.mFirstPosition != 0) {
                    left -= this.mDividerWidth;
                }
                if (left >= 0) {
                    i = left;
                }
            } else {
                int right = getChildAt(childCount - 1).getRight() - (getWidth() - this.mListPadding.right);
                if (this.mFirstPosition + childCount < this.mItemCount) {
                    right += this.mDividerWidth;
                }
                if (right <= 0) {
                    i = right;
                }
            }
            if (i != 0) {
                offsetChildrenLeftAndRight(-i);
            }
        }
    }

    private int amountToScroll(int i, int i2) {
        int width = getWidth();
        Rect rect = this.mListPadding;
        int i3 = width - rect.right;
        int i4 = rect.left;
        int childCount = getChildCount();
        if (i == 130) {
            int i5 = childCount - 1;
            int i6 = i2 != -1 ? i2 - this.mFirstPosition : i5;
            int i7 = this.mFirstPosition + i6;
            View childAt = getChildAt(i6);
            int arrowScrollPreviewLength = i7 < this.mItemCount + (-1) ? i3 - getArrowScrollPreviewLength() : i3;
            if (childAt.getRight() <= arrowScrollPreviewLength) {
                return 0;
            }
            if (i2 == -1 || arrowScrollPreviewLength - childAt.getLeft() < getMaxScrollAmount()) {
                int right = childAt.getRight() - arrowScrollPreviewLength;
                if (this.mFirstPosition + childCount == this.mItemCount) {
                    right = Math.min(right, getChildAt(i5).getRight() - i3);
                }
                return Math.min(right, getMaxScrollAmount());
            }
            return 0;
        }
        int i8 = i2 != -1 ? i2 - this.mFirstPosition : 0;
        int i9 = this.mFirstPosition + i8;
        View childAt2 = getChildAt(i8);
        int arrowScrollPreviewLength2 = i9 > 0 ? getArrowScrollPreviewLength() + i4 : i4;
        if (childAt2.getLeft() >= arrowScrollPreviewLength2) {
            return 0;
        }
        if (i2 == -1 || childAt2.getRight() - arrowScrollPreviewLength2 < getMaxScrollAmount()) {
            int left = arrowScrollPreviewLength2 - childAt2.getLeft();
            if (this.mFirstPosition == 0) {
                left = Math.min(left, i4 - getChildAt(0).getLeft());
            }
            return Math.min(left, getMaxScrollAmount());
        }
        return 0;
    }

    private int amountToScrollToNewFocus(int i, View view, int i2) {
        int i3;
        int arrowScrollPreviewLength;
        view.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(view, this.mTempRect);
        if (i == 33) {
            int i4 = this.mTempRect.left;
            int i5 = this.mListPadding.left;
            if (i4 < i5) {
                i3 = i5 - i4;
                if (i2 > 0) {
                    arrowScrollPreviewLength = getArrowScrollPreviewLength();
                    return i3 + arrowScrollPreviewLength;
                }
                return i3;
            }
            return 0;
        }
        int width = getWidth() - this.mListPadding.right;
        Rect rect = this.mTempRect;
        if (rect.bottom > width) {
            i3 = rect.right - width;
            if (i2 < this.mItemCount - 1) {
                arrowScrollPreviewLength = getArrowScrollPreviewLength();
                return i3 + arrowScrollPreviewLength;
            }
            return i3;
        }
        return 0;
    }

    private b arrowScrollFocused(int i) {
        View findNextFocusFromRect;
        int lookForSelectablePositionOnScreen;
        View selectedView = getSelectedView();
        if (selectedView != null && selectedView.hasFocus()) {
            findNextFocusFromRect = FocusFinder.getInstance().findNextFocus(this, selectedView.findFocus(), i);
        } else {
            if (i == 130) {
                int arrowScrollPreviewLength = this.mListPadding.left + (this.mFirstPosition > 0 ? getArrowScrollPreviewLength() : 0);
                if (selectedView != null && selectedView.getLeft() > arrowScrollPreviewLength) {
                    arrowScrollPreviewLength = selectedView.getLeft();
                }
                this.mTempRect.set(arrowScrollPreviewLength, 0, arrowScrollPreviewLength, 0);
            } else {
                int width = (getWidth() - this.mListPadding.right) - ((this.mFirstPosition + getChildCount()) - 1 < this.mItemCount ? getArrowScrollPreviewLength() : 0);
                if (selectedView != null && selectedView.getRight() < width) {
                    width = selectedView.getRight();
                }
                this.mTempRect.set(width, 0, width, 0);
            }
            findNextFocusFromRect = FocusFinder.getInstance().findNextFocusFromRect(this, this.mTempRect, i);
        }
        if (findNextFocusFromRect != null) {
            int positionOfNewFocus = positionOfNewFocus(findNextFocusFromRect);
            int i2 = this.mSelectedPosition;
            if (i2 != -1 && positionOfNewFocus != i2 && (lookForSelectablePositionOnScreen = lookForSelectablePositionOnScreen(i)) != -1 && ((i == 130 && lookForSelectablePositionOnScreen < positionOfNewFocus) || (i == 33 && lookForSelectablePositionOnScreen > positionOfNewFocus))) {
                return null;
            }
            int amountToScrollToNewFocus = amountToScrollToNewFocus(i, findNextFocusFromRect, positionOfNewFocus);
            int maxScrollAmount = getMaxScrollAmount();
            if (amountToScrollToNewFocus < maxScrollAmount) {
                findNextFocusFromRect.requestFocus(i);
                this.mArrowScrollFocusResult.c(positionOfNewFocus, amountToScrollToNewFocus);
                return this.mArrowScrollFocusResult;
            } else if (distanceToView(findNextFocusFromRect) < maxScrollAmount) {
                findNextFocusFromRect.requestFocus(i);
                this.mArrowScrollFocusResult.c(positionOfNewFocus, maxScrollAmount);
                return this.mArrowScrollFocusResult;
            }
        }
        return null;
    }

    private boolean arrowScrollImpl(int i) {
        View focusedChild;
        if (getChildCount() <= 0) {
            return false;
        }
        View selectedView = getSelectedView();
        int i2 = this.mSelectedPosition;
        int lookForSelectablePositionOnScreen = lookForSelectablePositionOnScreen(i);
        int amountToScroll = amountToScroll(i, lookForSelectablePositionOnScreen);
        View view = null;
        b arrowScrollFocused = this.mItemsCanFocus ? arrowScrollFocused(i) : null;
        if (arrowScrollFocused != null) {
            lookForSelectablePositionOnScreen = arrowScrollFocused.b();
            amountToScroll = arrowScrollFocused.a();
        }
        boolean z = arrowScrollFocused != null;
        if (lookForSelectablePositionOnScreen != -1) {
            handleNewSelectionChange(selectedView, i, lookForSelectablePositionOnScreen, arrowScrollFocused != null);
            setSelectedPositionInt(lookForSelectablePositionOnScreen);
            setNextSelectedPositionInt(lookForSelectablePositionOnScreen);
            selectedView = getSelectedView();
            if (this.mItemsCanFocus && arrowScrollFocused == null && (focusedChild = getFocusedChild()) != null) {
                focusedChild.clearFocus();
            }
            checkSelectionChanged();
            i2 = lookForSelectablePositionOnScreen;
            z = true;
        }
        if (amountToScroll > 0) {
            if (i != 33) {
                amountToScroll = -amountToScroll;
            }
            scrollListItemsBy(amountToScroll);
            z = true;
        }
        if (this.mItemsCanFocus && arrowScrollFocused == null && selectedView != null && selectedView.hasFocus()) {
            View findFocus = selectedView.findFocus();
            if (!isViewAncestorOf(findFocus, this) || distanceToView(findFocus) > 0) {
                findFocus.clearFocus();
            }
        }
        if (lookForSelectablePositionOnScreen != -1 || selectedView == null || isViewAncestorOf(selectedView, this)) {
            view = selectedView;
        } else {
            hideSelector();
            this.mResurrectToPosition = -1;
        }
        if (z) {
            if (view != null) {
                positionSelector(i2, view);
                this.mSelectedLeft = view.getLeft();
            }
            if (!awakenScrollBars()) {
                invalidate();
            }
            invokeOnItemScrollListener();
            return true;
        }
        return false;
    }

    private void clearRecycledState(ArrayList<c> arrayList) {
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                AbsHListView.LayoutParams layoutParams = (AbsHListView.LayoutParams) arrayList.get(i).f17517a.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.f17447b = false;
                }
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x006e, code lost:
        if (fullScroll(com.baidu.android.imsdk.upload.action.pb.IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER) != false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x009e, code lost:
        if (fullScroll(33) != false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00ca, code lost:
        if (fullScroll(com.baidu.android.imsdk.upload.action.pb.IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER) != false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x00de, code lost:
        if (fullScroll(33) != false) goto L57;
     */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0171 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0172  */
    @TargetApi(11)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean commonKey(int i, int i2, KeyEvent keyEvent) {
        boolean z;
        int i3;
        int i4;
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
            if (i != 62) {
                if (i != 66) {
                    if (i != 92) {
                        if (i != 93) {
                            if (i != 122) {
                                if (i != 123) {
                                    switch (i) {
                                        case 19:
                                            if (keyEvent.hasNoModifiers()) {
                                                z = handleHorizontalFocusWithinListItem(33);
                                                break;
                                            }
                                            break;
                                        case 20:
                                            if (keyEvent.hasNoModifiers()) {
                                                z = handleHorizontalFocusWithinListItem(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER);
                                                break;
                                            }
                                            break;
                                        case 21:
                                            if (keyEvent.hasNoModifiers()) {
                                                z = resurrectSelectionIfNeeded();
                                                if (!z) {
                                                    while (true) {
                                                        i3 = i2 - 1;
                                                        if (i2 > 0 && arrowScroll(33)) {
                                                            i2 = i3;
                                                            z = true;
                                                        }
                                                    }
                                                    i2 = i3;
                                                    break;
                                                }
                                            } else if (keyEvent.hasModifiers(2)) {
                                                if (!resurrectSelectionIfNeeded()) {
                                                    break;
                                                }
                                            }
                                            break;
                                        case 22:
                                            if (keyEvent.hasNoModifiers()) {
                                                z = resurrectSelectionIfNeeded();
                                                if (!z) {
                                                    while (true) {
                                                        i4 = i2 - 1;
                                                        if (i2 > 0 && arrowScroll(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER)) {
                                                            i2 = i4;
                                                            z = true;
                                                        }
                                                    }
                                                    i2 = i4;
                                                    break;
                                                }
                                            } else if (keyEvent.hasModifiers(2)) {
                                                if (!resurrectSelectionIfNeeded()) {
                                                    break;
                                                }
                                            }
                                            break;
                                    }
                                } else if (keyEvent.hasNoModifiers()) {
                                    if (!resurrectSelectionIfNeeded()) {
                                    }
                                }
                            } else if (keyEvent.hasNoModifiers()) {
                                if (!resurrectSelectionIfNeeded()) {
                                }
                            }
                        } else if (!keyEvent.hasNoModifiers()) {
                        }
                    } else if (!keyEvent.hasNoModifiers()) {
                    }
                    if (z) {
                        if (action != 0) {
                            if (action != 1) {
                                if (action != 2) {
                                    return false;
                                }
                                return super.onKeyMultiple(i, i2, keyEvent);
                            }
                            return super.onKeyUp(i, keyEvent);
                        }
                        return super.onKeyDown(i, keyEvent);
                    }
                    return true;
                }
                if (keyEvent.hasNoModifiers()) {
                    z = resurrectSelectionIfNeeded();
                    if (!z && keyEvent.getRepeatCount() == 0 && getChildCount() > 0) {
                        keyPressed();
                    }
                    if (z) {
                    }
                }
            } else if (keyEvent.hasNoModifiers()) {
                if (!resurrectSelectionIfNeeded()) {
                    pageScroll(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER);
                }
            } else if (keyEvent.hasModifiers(1) && !resurrectSelectionIfNeeded()) {
                pageScroll(33);
            }
            z = true;
            if (z) {
            }
        }
        z = false;
        if (z) {
        }
    }

    private void correctTooSmall(int i) {
        if (this.mFirstPosition != 0 || i <= 0) {
            return;
        }
        int left = getChildAt(0).getLeft();
        int i2 = this.mListPadding.left;
        int right = (getRight() - getLeft()) - this.mListPadding.right;
        int i3 = left - i2;
        View childAt = getChildAt(i - 1);
        int right2 = childAt.getRight();
        int i4 = (this.mFirstPosition + i) - 1;
        if (i3 > 0) {
            int i5 = this.mItemCount;
            if (i4 >= i5 - 1 && right2 <= right) {
                if (i4 == i5 - 1) {
                    adjustViewsLeftOrRight();
                    return;
                }
                return;
            }
            if (i4 == this.mItemCount - 1) {
                i3 = Math.min(i3, right2 - right);
            }
            offsetChildrenLeftAndRight(-i3);
            if (i4 < this.mItemCount - 1) {
                fillRight(i4 + 1, childAt.getRight() + this.mDividerWidth);
                adjustViewsLeftOrRight();
            }
        }
    }

    private void correctTooWide(int i) {
        if ((this.mFirstPosition + i) - 1 != this.mItemCount - 1 || i <= 0) {
            return;
        }
        int right = ((getRight() - getLeft()) - this.mListPadding.right) - getChildAt(i - 1).getRight();
        View childAt = getChildAt(0);
        int left = childAt.getLeft();
        if (right > 0) {
            if (this.mFirstPosition > 0 || left < this.mListPadding.top) {
                if (this.mFirstPosition == 0) {
                    right = Math.min(right, this.mListPadding.top - left);
                }
                offsetChildrenLeftAndRight(right);
                int i2 = this.mFirstPosition;
                if (i2 > 0) {
                    fillLeft(i2 - 1, childAt.getLeft() - this.mDividerWidth);
                    adjustViewsLeftOrRight();
                }
            }
        }
    }

    private int distanceToView(View view) {
        view.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(view, this.mTempRect);
        int right = getRight() - getLeft();
        Rect rect = this.mListPadding;
        int i = right - rect.right;
        Rect rect2 = this.mTempRect;
        int i2 = rect2.right;
        int i3 = rect.left;
        if (i2 < i3) {
            return i3 - i2;
        }
        int i4 = rect2.left;
        if (i4 > i) {
            return i4 - i;
        }
        return 0;
    }

    private void fillBeforeAndAfter(View view, int i) {
        int i2 = this.mDividerWidth;
        if (!this.mStackFromRight) {
            fillLeft(i - 1, view.getLeft() - i2);
            adjustViewsLeftOrRight();
            fillRight(i + 1, view.getRight() + i2);
            return;
        }
        fillRight(i + 1, view.getRight() + i2);
        adjustViewsLeftOrRight();
        fillLeft(i - 1, view.getLeft() - i2);
    }

    private View fillFromLeft(int i) {
        int min = Math.min(this.mFirstPosition, this.mSelectedPosition);
        this.mFirstPosition = min;
        int min2 = Math.min(min, this.mItemCount - 1);
        this.mFirstPosition = min2;
        if (min2 < 0) {
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

    private View fillLeft(int i, int i2) {
        View view = null;
        int i3 = i2;
        while (true) {
            if (i3 <= 0 || i < 0) {
                break;
            }
            boolean z = i == this.mSelectedPosition;
            View makeAndAddView = makeAndAddView(i, i3, false, this.mListPadding.top, z);
            i3 = makeAndAddView.getLeft() - this.mDividerWidth;
            if (z) {
                view = makeAndAddView;
            }
            i--;
        }
        int i4 = i + 1;
        this.mFirstPosition = i4;
        setVisibleRangeHint(i4, (getChildCount() + i4) - 1);
        return view;
    }

    private View fillRight(int i, int i2) {
        int right = getRight() - getLeft();
        View view = null;
        int i3 = i2;
        while (true) {
            if (i3 >= right || i >= this.mItemCount) {
                break;
            }
            boolean z = i == this.mSelectedPosition;
            View makeAndAddView = makeAndAddView(i, i3, true, this.mListPadding.top, z);
            i3 = this.mDividerWidth + makeAndAddView.getRight();
            if (z) {
                view = makeAndAddView;
            }
            i++;
        }
        int i4 = this.mFirstPosition;
        setVisibleRangeHint(i4, (getChildCount() + i4) - 1);
        return view;
    }

    private View fillSpecific(int i, int i2) {
        View view;
        View view2;
        boolean z = i == this.mSelectedPosition;
        View makeAndAddView = makeAndAddView(i, i2, true, this.mListPadding.top, z);
        this.mFirstPosition = i;
        int i3 = this.mDividerWidth;
        if (!this.mStackFromRight) {
            view = fillLeft(i - 1, makeAndAddView.getLeft() - i3);
            adjustViewsLeftOrRight();
            view2 = fillRight(i + 1, makeAndAddView.getRight() + i3);
            int childCount = getChildCount();
            if (childCount > 0) {
                correctTooWide(childCount);
            }
        } else {
            View fillRight = fillRight(i + 1, makeAndAddView.getRight() + i3);
            adjustViewsLeftOrRight();
            View fillLeft = fillLeft(i - 1, makeAndAddView.getLeft() - i3);
            int childCount2 = getChildCount();
            if (childCount2 > 0) {
                correctTooSmall(childCount2);
            }
            view = fillLeft;
            view2 = fillRight;
        }
        return z ? makeAndAddView : view != null ? view : view2;
    }

    private View findAccessibilityFocusedChild(View view) {
        boolean z;
        ViewParent parent = view.getParent();
        while (true) {
            z = parent instanceof View;
            if (!z || parent == this) {
                break;
            }
            view = (View) parent;
            parent = parent.getParent();
        }
        if (z) {
            return view;
        }
        return null;
    }

    private int getArrowScrollPreviewLength() {
        return Math.max(2, getHorizontalFadingEdgeLength());
    }

    private int getLeftSelectionPixel(int i, int i2, int i3) {
        return i3 > 0 ? i + i2 : i;
    }

    private int getRightSelectionPixel(int i, int i2, int i3) {
        return i3 != this.mItemCount + (-1) ? i - i2 : i;
    }

    private boolean handleHorizontalFocusWithinListItem(int i) {
        View selectedView;
        if (i != 33 && i != 130) {
            throw new IllegalArgumentException("direction must be one of {View.FOCUS_UP, View.FOCUS_DOWN}");
        }
        int childCount = getChildCount();
        if (!this.mItemsCanFocus || childCount <= 0 || this.mSelectedPosition == -1 || (selectedView = getSelectedView()) == null || !selectedView.hasFocus() || !(selectedView instanceof ViewGroup)) {
            return false;
        }
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
        return false;
    }

    private void handleNewSelectionChange(View view, int i, int i2, boolean z) {
        View childAt;
        boolean z2;
        if (i2 != -1) {
            int i3 = this.mSelectedPosition;
            int i4 = this.mFirstPosition;
            int i5 = i3 - i4;
            int i6 = i2 - i4;
            boolean z3 = true;
            if (i == 33) {
                z2 = true;
                childAt = view;
                view = getChildAt(i6);
                i5 = i6;
                i6 = i5;
            } else {
                childAt = getChildAt(i6);
                z2 = false;
            }
            int childCount = getChildCount();
            if (view != null) {
                view.setSelected(!z && z2);
                measureAndAdjustRight(view, i5, childCount);
            }
            if (childAt != null) {
                childAt.setSelected((z || z2) ? false : false);
                measureAndAdjustRight(childAt, i6, childCount);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("newSelectedPosition needs to be valid");
    }

    private boolean isDirectChildHeaderOrFooter(View view) {
        ArrayList<c> arrayList = this.mHeaderViewInfos;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (view == arrayList.get(i).f17517a) {
                return true;
            }
        }
        ArrayList<c> arrayList2 = this.mFooterViewInfos;
        int size2 = arrayList2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            if (view == arrayList2.get(i2).f17517a) {
                return true;
            }
        }
        return false;
    }

    private boolean isViewAncestorOf(View view, View view2) {
        if (view == view2) {
            return true;
        }
        ViewParent parent = view.getParent();
        return (parent instanceof ViewGroup) && isViewAncestorOf((View) parent, view2);
    }

    private int lookForSelectablePositionOnScreen(int i) {
        int i2 = this.mFirstPosition;
        if (i == 130) {
            int i3 = this.mSelectedPosition;
            int i4 = i3 != -1 ? i3 + 1 : i2;
            if (i4 >= this.mAdapter.getCount()) {
                return -1;
            }
            if (i4 < i2) {
                i4 = i2;
            }
            int lastVisiblePosition = getLastVisiblePosition();
            ListAdapter adapter = getAdapter();
            while (i4 <= lastVisiblePosition) {
                if (adapter.isEnabled(i4) && getChildAt(i4 - i2).getVisibility() == 0) {
                    return i4;
                }
                i4++;
            }
        } else {
            int childCount = (getChildCount() + i2) - 1;
            int i5 = this.mSelectedPosition;
            if (i5 == -1) {
                i5 = getChildCount() + i2;
            }
            int i6 = i5 - 1;
            if (i6 >= 0 && i6 < this.mAdapter.getCount()) {
                if (i6 <= childCount) {
                    childCount = i6;
                }
                ListAdapter adapter2 = getAdapter();
                while (childCount >= i2) {
                    if (adapter2.isEnabled(childCount) && getChildAt(childCount - i2).getVisibility() == 0) {
                        return childCount;
                    }
                    childCount--;
                }
            }
        }
        return -1;
    }

    private View makeAndAddView(int i, int i2, boolean z, int i3, boolean z2) {
        View g2;
        if (!this.mDataChanged && (g2 = this.mRecycler.g(i)) != null) {
            setupChild(g2, i, i2, z, i3, z2, true);
            return g2;
        }
        View obtainView = obtainView(i, this.mIsScrap);
        setupChild(obtainView, i, i2, z, i3, z2, this.mIsScrap[0]);
        return obtainView;
    }

    private void measureAndAdjustRight(View view, int i, int i2) {
        int width = view.getWidth();
        measureItem(view);
        if (view.getMeasuredWidth() == width) {
            return;
        }
        relayoutMeasuredItem(view);
        int measuredWidth = view.getMeasuredWidth() - width;
        while (true) {
            i++;
            if (i >= i2) {
                return;
            }
            getChildAt(i).offsetLeftAndRight(measuredWidth);
        }
    }

    private void measureItem(View view) {
        int makeMeasureSpec;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-2, -1);
        }
        int i = this.mHeightMeasureSpec;
        Rect rect = this.mListPadding;
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i, rect.top + rect.bottom, layoutParams.height);
        int i2 = layoutParams.width;
        if (i2 > 0) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i2, 1073741824);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(makeMeasureSpec, childMeasureSpec);
    }

    private void measureScrapChildWidth(View view, int i, int i2) {
        int makeMeasureSpec;
        AbsHListView.LayoutParams layoutParams = (AbsHListView.LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = (AbsHListView.LayoutParams) generateDefaultLayoutParams();
            view.setLayoutParams(layoutParams);
        }
        layoutParams.f17446a = this.mAdapter.getItemViewType(i);
        layoutParams.f17448c = true;
        Rect rect = this.mListPadding;
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, rect.top + rect.bottom, ((ViewGroup.LayoutParams) layoutParams).height);
        int i3 = ((ViewGroup.LayoutParams) layoutParams).width;
        if (i3 > 0) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(makeMeasureSpec, childMeasureSpec);
    }

    private View moveSelection(View view, View view2, int i, int i2, int i3) {
        View makeAndAddView;
        View makeAndAddView2;
        int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
        int i4 = this.mSelectedPosition;
        int leftSelectionPixel = getLeftSelectionPixel(i2, horizontalFadingEdgeLength, i4);
        int rightSelectionPixel = getRightSelectionPixel(i2, horizontalFadingEdgeLength, i4);
        if (i > 0) {
            View makeAndAddView3 = makeAndAddView(i4 - 1, view.getLeft(), true, this.mListPadding.top, false);
            int i5 = this.mDividerWidth;
            makeAndAddView = makeAndAddView(i4, makeAndAddView3.getRight() + i5, true, this.mListPadding.top, true);
            if (makeAndAddView.getRight() > rightSelectionPixel) {
                int i6 = -Math.min(Math.min(makeAndAddView.getLeft() - leftSelectionPixel, makeAndAddView.getRight() - rightSelectionPixel), (i3 - i2) / 2);
                makeAndAddView3.offsetLeftAndRight(i6);
                makeAndAddView.offsetLeftAndRight(i6);
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
            if (view2 != null) {
                makeAndAddView2 = makeAndAddView(i4, view2.getLeft(), true, this.mListPadding.top, true);
            } else {
                makeAndAddView2 = makeAndAddView(i4, view.getLeft(), false, this.mListPadding.top, true);
            }
            makeAndAddView = makeAndAddView2;
            if (makeAndAddView.getLeft() < leftSelectionPixel) {
                makeAndAddView.offsetLeftAndRight(Math.min(Math.min(leftSelectionPixel - makeAndAddView.getLeft(), rightSelectionPixel - makeAndAddView.getRight()), (i3 - i2) / 2));
            }
            fillBeforeAndAfter(makeAndAddView, i4);
        } else {
            int left = view.getLeft();
            makeAndAddView = makeAndAddView(i4, left, true, this.mListPadding.top, true);
            if (left < i2 && makeAndAddView.getRight() < i2 + 20) {
                makeAndAddView.offsetLeftAndRight(i2 - makeAndAddView.getLeft());
            }
            fillBeforeAndAfter(makeAndAddView, i4);
        }
        return makeAndAddView;
    }

    private int positionOfNewFocus(View view) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (isViewAncestorOf(view, getChildAt(i))) {
                return this.mFirstPosition + i;
            }
        }
        throw new IllegalArgumentException("newFocus is not a child of any of the children of the list!");
    }

    private void relayoutMeasuredItem(View view) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i = this.mListPadding.top;
        int left = view.getLeft();
        view.layout(left, i, measuredWidth + left, measuredHeight + i);
    }

    private void removeFixedViewInfo(View view, ArrayList<c> arrayList) {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (arrayList.get(i).f17517a == view) {
                arrayList.remove(i);
                return;
            }
        }
    }

    private void scrollListItemsBy(int i) {
        int i2;
        int i3;
        offsetChildrenLeftAndRight(i);
        int width = getWidth();
        Rect rect = this.mListPadding;
        int i4 = width - rect.right;
        int i5 = rect.left;
        AbsHListView.l lVar = this.mRecycler;
        if (i < 0) {
            int childCount = getChildCount();
            View childAt = getChildAt(childCount - 1);
            while (childAt.getRight() < i4 && (this.mFirstPosition + childCount) - 1 < this.mItemCount - 1) {
                childAt = addViewAfter(childAt, i3);
                childCount++;
            }
            if (childAt.getBottom() < i4) {
                offsetChildrenLeftAndRight(i4 - childAt.getRight());
            }
            View childAt2 = getChildAt(0);
            while (childAt2.getRight() < i5) {
                if (lVar.q(((AbsHListView.LayoutParams) childAt2.getLayoutParams()).f17446a)) {
                    detachViewFromParent(childAt2);
                    lVar.c(childAt2, this.mFirstPosition);
                } else {
                    removeViewInLayout(childAt2);
                }
                childAt2 = getChildAt(0);
                this.mFirstPosition++;
            }
            return;
        }
        View childAt3 = getChildAt(0);
        while (childAt3.getLeft() > i5 && (i2 = this.mFirstPosition) > 0) {
            childAt3 = addViewBefore(childAt3, i2);
            this.mFirstPosition--;
        }
        if (childAt3.getLeft() > i5) {
            offsetChildrenLeftAndRight(i5 - childAt3.getLeft());
        }
        int childCount2 = getChildCount() - 1;
        View childAt4 = getChildAt(childCount2);
        while (childAt4.getLeft() > i4) {
            if (lVar.q(((AbsHListView.LayoutParams) childAt4.getLayoutParams()).f17446a)) {
                detachViewFromParent(childAt4);
                lVar.c(childAt4, this.mFirstPosition + childCount2);
            } else {
                removeViewInLayout(childAt4);
            }
            childCount2--;
            childAt4 = getChildAt(childCount2);
        }
    }

    @TargetApi(11)
    private void setupChild(View view, int i, int i2, boolean z, int i3, boolean z2, boolean z3) {
        int makeMeasureSpec;
        SparseArrayCompat<Boolean> sparseArrayCompat;
        boolean z4 = z2 && shouldShowSelector();
        boolean z5 = z4 != view.isSelected();
        int i4 = this.mTouchMode;
        boolean z6 = i4 > 0 && i4 < 3 && this.mMotionPosition == i;
        boolean z7 = z6 != view.isPressed();
        boolean z8 = !z3 || z5 || view.isLayoutRequested();
        AbsHListView.LayoutParams layoutParams = (AbsHListView.LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = (AbsHListView.LayoutParams) generateDefaultLayoutParams();
        }
        layoutParams.f17446a = this.mAdapter.getItemViewType(i);
        if ((z3 && !layoutParams.f17448c) || (layoutParams.f17447b && layoutParams.f17446a == -2)) {
            attachViewToParent(view, z ? -1 : 0, layoutParams);
        } else {
            layoutParams.f17448c = false;
            if (layoutParams.f17446a == -2) {
                layoutParams.f17447b = true;
            }
            addViewInLayout(view, z ? -1 : 0, layoutParams, true);
        }
        if (z5) {
            view.setSelected(z4);
        }
        if (z7) {
            view.setPressed(z6);
        }
        if (this.mChoiceMode != 0 && (sparseArrayCompat = this.mCheckStates) != null) {
            if (view instanceof Checkable) {
                ((Checkable) view).setChecked(sparseArrayCompat.get(i, Boolean.FALSE).booleanValue());
            } else if (Build.VERSION.SDK_INT >= 11) {
                view.setActivated(sparseArrayCompat.get(i, Boolean.FALSE).booleanValue());
            }
        }
        if (z8) {
            int i5 = this.mHeightMeasureSpec;
            Rect rect = this.mListPadding;
            int childMeasureSpec = ViewGroup.getChildMeasureSpec(i5, rect.top + rect.bottom, ((ViewGroup.LayoutParams) layoutParams).height);
            int i6 = ((ViewGroup.LayoutParams) layoutParams).width;
            if (i6 > 0) {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i6, 1073741824);
            } else {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            }
            view.measure(makeMeasureSpec, childMeasureSpec);
        } else {
            cleanupLayoutState(view);
        }
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i7 = z ? i2 : i2 - measuredWidth;
        if (z8) {
            view.layout(i7, i3, measuredWidth + i7, measuredHeight + i3);
        } else {
            view.offsetLeftAndRight(i7 - view.getLeft());
            view.offsetTopAndBottom(i3 - view.getTop());
        }
        if (this.mCachingStarted && !view.isDrawingCacheEnabled()) {
            view.setDrawingCacheEnabled(true);
        }
        if (Build.VERSION.SDK_INT < 11 || !z3 || ((AbsHListView.LayoutParams) view.getLayoutParams()).f17449d == i) {
            return;
        }
        view.jumpDrawablesToCurrentState();
    }

    private boolean showingLeftFadingEdge() {
        return this.mFirstPosition > 0 || getChildAt(0).getLeft() > getScrollX() + this.mListPadding.left;
    }

    private boolean showingRightFadingEdge() {
        int childCount = getChildCount();
        return (this.mFirstPosition + childCount) - 1 < this.mItemCount - 1 || getChildAt(childCount + (-1)).getRight() < (getScrollX() + getWidth()) - this.mListPadding.right;
    }

    public void addFooterView(View view, Object obj, boolean z) {
        AbsHListView.c cVar;
        c cVar2 = new c();
        cVar2.f17517a = view;
        cVar2.f17518b = obj;
        cVar2.f17519c = z;
        this.mFooterViewInfos.add(cVar2);
        if (this.mAdapter == null || (cVar = this.mDataSetObserver) == null) {
            return;
        }
        cVar.onChanged();
    }

    public void addHeaderView(View view, Object obj, boolean z) {
        AbsHListView.c cVar;
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter != null && !(listAdapter instanceof d.b.i0.a1.b.d)) {
            throw new IllegalStateException("Cannot add header view to list -- setAdapter has already been called.");
        }
        c cVar2 = new c();
        cVar2.f17517a = view;
        cVar2.f17518b = obj;
        cVar2.f17519c = z;
        this.mHeaderViewInfos.add(cVar2);
        if (this.mAdapter == null || (cVar = this.mDataSetObserver) == null) {
            return;
        }
        cVar.onChanged();
    }

    public boolean arrowScroll(int i) {
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

    @Override // com.baidu.tieba.horizonalList.widget.AdapterView, android.view.ViewGroup
    public boolean canAnimate() {
        return super.canAnimate() && this.mItemCount > 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:105:0x01be, code lost:
        if (r8.isEnabled(r3 + 1) == false) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0117, code lost:
        if (r8.isEnabled(r7 + 1) == false) goto L65;
     */
    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void dispatchDraw(Canvas canvas) {
        boolean z;
        ListAdapter listAdapter;
        int i;
        int left;
        boolean z2;
        int i2;
        ListAdapter listAdapter2;
        int i3;
        Paint paint;
        if (this.mCachingStarted) {
            this.mCachingActive = true;
        }
        int i4 = this.mDividerWidth;
        Drawable drawable = this.mOverScrollHeader;
        Drawable drawable2 = this.mOverScrollFooter;
        int i5 = drawable != null ? 1 : 0;
        boolean z3 = drawable2 != null;
        boolean z4 = i4 > 0 && this.mDivider != null;
        if (z4 || i5 != 0 || z3) {
            Rect rect = this.mTempRect;
            rect.top = getPaddingTop();
            rect.bottom = (getBottom() - getTop()) - getPaddingBottom();
            int childCount = getChildCount();
            int size = this.mHeaderViewInfos.size();
            int i6 = this.mItemCount;
            int size2 = (i6 - this.mFooterViewInfos.size()) - 1;
            boolean z5 = this.mHeaderDividersEnabled;
            boolean z6 = this.mFooterDividersEnabled;
            int i7 = this.mFirstPosition;
            boolean z7 = this.mAreAllItemsSelectable;
            ListAdapter listAdapter3 = this.mAdapter;
            boolean z8 = isOpaque() && !super.isOpaque();
            if (z8) {
                listAdapter = listAdapter3;
                if (this.mDividerPaint == null && this.mIsCacheColorOpaque) {
                    Paint paint2 = new Paint();
                    this.mDividerPaint = paint2;
                    z = z7;
                    paint2.setColor(getCacheColorHint());
                } else {
                    z = z7;
                }
            } else {
                z = z7;
                listAdapter = listAdapter3;
            }
            Paint paint3 = this.mDividerPaint;
            int right = ((getRight() - getLeft()) - 0) + getScrollX();
            boolean z9 = z3;
            if (!this.mStackFromRight) {
                int scrollX = getScrollX();
                if (childCount > 0 && scrollX < 0) {
                    if (i5 != 0) {
                        rect.right = 0;
                        rect.left = scrollX;
                        drawOverscrollHeader(canvas, drawable, rect);
                    } else if (z4) {
                        rect.right = 0;
                        rect.left = -i4;
                        drawDivider(canvas, rect, -1);
                    }
                }
                int i8 = 0;
                int i9 = 0;
                while (i8 < childCount) {
                    if ((z5 || i7 + i8 >= size) && (z6 || i7 + i8 < size2)) {
                        i9 = getChildAt(i8).getRight();
                        if (z4 && i9 < right && (!z9 || i8 != childCount - 1)) {
                            if (z) {
                                listAdapter2 = listAdapter;
                                i3 = right;
                            } else {
                                int i10 = i7 + i8;
                                listAdapter2 = listAdapter;
                                if (listAdapter2.isEnabled(i10)) {
                                    i3 = right;
                                    if (i8 != childCount - 1) {
                                    }
                                } else {
                                    i3 = right;
                                }
                                if (z8) {
                                    rect.left = i9;
                                    rect.right = i9 + i4;
                                    paint = paint3;
                                    canvas.drawRect(rect, paint);
                                    i8++;
                                    paint3 = paint;
                                    right = i3;
                                    listAdapter = listAdapter2;
                                }
                                paint = paint3;
                                i8++;
                                paint3 = paint;
                                right = i3;
                                listAdapter = listAdapter2;
                            }
                            paint = paint3;
                            rect.left = i9;
                            rect.right = i9 + i4;
                            drawDivider(canvas, rect, i8);
                            i8++;
                            paint3 = paint;
                            right = i3;
                            listAdapter = listAdapter2;
                        }
                    }
                    listAdapter2 = listAdapter;
                    i3 = right;
                    paint = paint3;
                    i8++;
                    paint3 = paint;
                    right = i3;
                    listAdapter = listAdapter2;
                }
                int right2 = getRight() + getScrollX();
                if (z9 && i7 + childCount == i6 && right2 > i9) {
                    rect.left = i9;
                    rect.right = right2;
                    drawOverscrollFooter(canvas, drawable2, rect);
                }
            } else {
                boolean z10 = z4;
                ListAdapter listAdapter4 = listAdapter;
                int scrollX2 = getScrollX();
                if (childCount <= 0 || i5 == 0) {
                    i = i5;
                } else {
                    rect.left = scrollX2;
                    i = i5;
                    rect.right = getChildAt(0).getLeft();
                    drawOverscrollHeader(canvas, drawable, rect);
                }
                int i11 = i;
                while (i11 < childCount) {
                    if ((z5 || i7 + i11 >= size) && ((z6 || i7 + i11 < size2) && (left = getChildAt(i11).getLeft()) > 0)) {
                        z2 = z6;
                        if (z) {
                            i2 = i7;
                        } else {
                            int i12 = i7 + i11;
                            if (listAdapter4.isEnabled(i12)) {
                                i2 = i7;
                                if (i11 != childCount - 1) {
                                }
                            } else {
                                i2 = i7;
                            }
                            if (z8) {
                                rect.left = left - i4;
                                rect.right = left;
                                canvas.drawRect(rect, paint3);
                            }
                        }
                        rect.left = left - i4;
                        rect.right = left;
                        drawDivider(canvas, rect, i11 - 1);
                    } else {
                        z2 = z6;
                        i2 = i7;
                    }
                    i11++;
                    z6 = z2;
                    i7 = i2;
                }
                if (childCount > 0 && scrollX2 > 0) {
                    if (z9) {
                        int right3 = getRight();
                        rect.left = right3;
                        rect.right = right3 + scrollX2;
                        drawOverscrollFooter(canvas, drawable2, rect);
                    } else if (z10) {
                        rect.left = right;
                        rect.right = right + i4;
                        drawDivider(canvas, rect, -1);
                    }
                }
            }
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        return (dispatchKeyEvent || getFocusedChild() == null || keyEvent.getAction() != 0) ? dispatchKeyEvent : onKeyDown(keyEvent.getKeyCode(), keyEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        try {
            return super.dispatchTouchEvent(motionEvent);
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j) {
        boolean drawChild = super.drawChild(canvas, view, j);
        if (this.mCachingActive) {
            this.mCachingActive = false;
        }
        return drawChild;
    }

    public void drawDivider(Canvas canvas, Rect rect, int i) {
        Drawable drawable = this.mDivider;
        drawable.setBounds(rect);
        drawable.draw(canvas);
    }

    public void drawOverscrollFooter(Canvas canvas, Drawable drawable, Rect rect) {
        int minimumWidth = drawable.getMinimumWidth();
        canvas.save();
        canvas.clipRect(rect);
        int i = rect.right;
        int i2 = rect.left;
        if (i - i2 < minimumWidth) {
            rect.right = i2 + minimumWidth;
        }
        drawable.setBounds(rect);
        drawable.draw(canvas);
        canvas.restore();
    }

    public void drawOverscrollHeader(Canvas canvas, Drawable drawable, Rect rect) {
        int minimumWidth = drawable.getMinimumWidth();
        canvas.save();
        canvas.clipRect(rect);
        int i = rect.right;
        if (i - rect.left < minimumWidth) {
            rect.left = i - minimumWidth;
        }
        drawable.setBounds(rect);
        drawable.draw(canvas);
        canvas.restore();
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView
    public void fillGap(boolean z) {
        int childCount = getChildCount();
        if (z) {
            fillRight(this.mFirstPosition + childCount, childCount > 0 ? this.mDividerWidth + getChildAt(childCount - 1).getRight() : 0);
            correctTooWide(getChildCount());
            return;
        }
        fillLeft(this.mFirstPosition - 1, childCount > 0 ? getChildAt(0).getLeft() - this.mDividerWidth : getWidth() - 0);
        correctTooSmall(getChildCount());
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView
    public int findMotionCol(int i) {
        int childCount = getChildCount();
        if (childCount > 0) {
            if (this.mStackFromRight) {
                for (int i2 = childCount - 1; i2 >= 0; i2--) {
                    if (i >= getChildAt(i2).getLeft()) {
                        return this.mFirstPosition + i2;
                    }
                }
                return -1;
            }
            for (int i3 = 0; i3 < childCount; i3++) {
                if (i <= getChildAt(i3).getRight()) {
                    return this.mFirstPosition + i3;
                }
            }
            return -1;
        }
        return -1;
    }

    public boolean fullScroll(int i) {
        boolean z = false;
        if (i == 33) {
            if (this.mSelectedPosition != 0) {
                int lookForSelectablePosition = lookForSelectablePosition(0, true);
                if (lookForSelectablePosition >= 0) {
                    this.mLayoutMode = 1;
                    setSelectionInt(lookForSelectablePosition);
                    invokeOnItemScrollListener();
                }
                z = true;
            }
        } else if (i == 130) {
            int i2 = this.mSelectedPosition;
            int i3 = this.mItemCount;
            if (i2 < i3 - 1) {
                int lookForSelectablePosition2 = lookForSelectablePosition(i3 - 1, true);
                if (lookForSelectablePosition2 >= 0) {
                    this.mLayoutMode = 3;
                    setSelectionInt(lookForSelectablePosition2);
                    invokeOnItemScrollListener();
                }
                z = true;
            }
        }
        if (z && !awakenScrollBars()) {
            awakenScrollBars();
            invalidate();
        }
        return z;
    }

    @Deprecated
    public long[] getCheckItemIds() {
        SparseArrayCompat<Boolean> sparseArrayCompat;
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter != null && listAdapter.hasStableIds()) {
            return getCheckedItemIds();
        }
        if (this.mChoiceMode == 0 || (sparseArrayCompat = this.mCheckStates) == null || this.mAdapter == null) {
            return new long[0];
        }
        int size = sparseArrayCompat.size();
        long[] jArr = new long[size];
        ListAdapter listAdapter2 = this.mAdapter;
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            if (sparseArrayCompat.valueAt(i2).booleanValue()) {
                jArr[i] = listAdapter2.getItemId(sparseArrayCompat.keyAt(i2));
                i++;
            }
        }
        if (i == size) {
            return jArr;
        }
        long[] jArr2 = new long[i];
        System.arraycopy(jArr, 0, jArr2, 0, i);
        return jArr2;
    }

    public Drawable getDivider() {
        return this.mDivider;
    }

    public int getDividerWidth() {
        return this.mDividerWidth;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView
    public int getFooterViewsCount() {
        return this.mFooterViewInfos.size();
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView
    public int getHeaderViewsCount() {
        return this.mHeaderViewInfos.size();
    }

    public boolean getItemsCanFocus() {
        return this.mItemsCanFocus;
    }

    public int getMaxScrollAmount() {
        return (int) ((getRight() - getLeft()) * 0.33f);
    }

    public Drawable getOverscrollFooter() {
        return this.mOverScrollFooter;
    }

    public Drawable getOverscrollHeader() {
        return this.mOverScrollHeader;
    }

    @Override // android.view.View
    public boolean isOpaque() {
        boolean z = (this.mCachingActive && this.mIsCacheColorOpaque && this.mDividerIsOpaque) || super.isOpaque();
        if (z) {
            Rect rect = this.mListPadding;
            int paddingLeft = rect != null ? rect.left : getPaddingLeft();
            View childAt = getChildAt(0);
            if (childAt != null && childAt.getLeft() <= paddingLeft) {
                int width = getWidth();
                Rect rect2 = this.mListPadding;
                int paddingRight = width - (rect2 != null ? rect2.right : getPaddingRight());
                View childAt2 = getChildAt(getChildCount() - 1);
                if (childAt2 == null || childAt2.getRight() < paddingRight) {
                }
            }
            return false;
        }
        return z;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, CONST, IPUT] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x01bb, code lost:
        r0 = getFocusedChild();
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x01bf, code lost:
        if (r0 == null) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x01c1, code lost:
        r0.clearFocus();
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x01c4, code lost:
        positionSelector(-1, r1);
     */
    /* JADX WARN: Removed duplicated region for block: B:38:0x008c A[Catch: all -> 0x027a, TryCatch #0 {all -> 0x027a, blocks: (B:5:0x000a, B:7:0x0014, B:11:0x001f, B:20:0x0046, B:23:0x004f, B:25:0x0055, B:27:0x005d, B:29:0x0064, B:36:0x0088, B:38:0x008c, B:39:0x008f, B:41:0x0093, B:45:0x009e, B:47:0x00a8, B:51:0x00b6, B:53:0x00c7, B:56:0x00cf, B:63:0x00e2, B:65:0x00e8, B:66:0x00f0, B:68:0x00f5, B:78:0x013f, B:97:0x0191, B:99:0x0196, B:101:0x019b, B:103:0x01a1, B:107:0x01ab, B:114:0x01bb, B:116:0x01c1, B:117:0x01c4, B:120:0x01d5, B:134:0x020b, B:136:0x0211, B:137:0x0214, B:139:0x021d, B:140:0x0225, B:142:0x0234, B:143:0x0237, B:118:0x01c8, B:109:0x01b1, B:119:0x01d2, B:121:0x01dc, B:123:0x01e0, B:125:0x01e5, B:127:0x01f0, B:129:0x01fe, B:132:0x0206, B:128:0x01f6, B:79:0x014c, B:80:0x015f, B:82:0x0163, B:84:0x0169, B:88:0x0172, B:87:0x016e, B:89:0x0177, B:91:0x017d, B:95:0x0186, B:94:0x0182, B:96:0x018b, B:69:0x00f8, B:70:0x0100, B:71:0x010a, B:72:0x0116, B:74:0x0124, B:75:0x012d, B:76:0x0132, B:60:0x00d9, B:62:0x00df, B:52:0x00c4, B:147:0x0240, B:148:0x0279, B:30:0x0074, B:33:0x007d), top: B:154:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0093 A[Catch: all -> 0x027a, TRY_LEAVE, TryCatch #0 {all -> 0x027a, blocks: (B:5:0x000a, B:7:0x0014, B:11:0x001f, B:20:0x0046, B:23:0x004f, B:25:0x0055, B:27:0x005d, B:29:0x0064, B:36:0x0088, B:38:0x008c, B:39:0x008f, B:41:0x0093, B:45:0x009e, B:47:0x00a8, B:51:0x00b6, B:53:0x00c7, B:56:0x00cf, B:63:0x00e2, B:65:0x00e8, B:66:0x00f0, B:68:0x00f5, B:78:0x013f, B:97:0x0191, B:99:0x0196, B:101:0x019b, B:103:0x01a1, B:107:0x01ab, B:114:0x01bb, B:116:0x01c1, B:117:0x01c4, B:120:0x01d5, B:134:0x020b, B:136:0x0211, B:137:0x0214, B:139:0x021d, B:140:0x0225, B:142:0x0234, B:143:0x0237, B:118:0x01c8, B:109:0x01b1, B:119:0x01d2, B:121:0x01dc, B:123:0x01e0, B:125:0x01e5, B:127:0x01f0, B:129:0x01fe, B:132:0x0206, B:128:0x01f6, B:79:0x014c, B:80:0x015f, B:82:0x0163, B:84:0x0169, B:88:0x0172, B:87:0x016e, B:89:0x0177, B:91:0x017d, B:95:0x0186, B:94:0x0182, B:96:0x018b, B:69:0x00f8, B:70:0x0100, B:71:0x010a, B:72:0x0116, B:74:0x0124, B:75:0x012d, B:76:0x0132, B:60:0x00d9, B:62:0x00df, B:52:0x00c4, B:147:0x0240, B:148:0x0279, B:30:0x0074, B:33:0x007d), top: B:154:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x009e A[Catch: all -> 0x027a, TRY_ENTER, TryCatch #0 {all -> 0x027a, blocks: (B:5:0x000a, B:7:0x0014, B:11:0x001f, B:20:0x0046, B:23:0x004f, B:25:0x0055, B:27:0x005d, B:29:0x0064, B:36:0x0088, B:38:0x008c, B:39:0x008f, B:41:0x0093, B:45:0x009e, B:47:0x00a8, B:51:0x00b6, B:53:0x00c7, B:56:0x00cf, B:63:0x00e2, B:65:0x00e8, B:66:0x00f0, B:68:0x00f5, B:78:0x013f, B:97:0x0191, B:99:0x0196, B:101:0x019b, B:103:0x01a1, B:107:0x01ab, B:114:0x01bb, B:116:0x01c1, B:117:0x01c4, B:120:0x01d5, B:134:0x020b, B:136:0x0211, B:137:0x0214, B:139:0x021d, B:140:0x0225, B:142:0x0234, B:143:0x0237, B:118:0x01c8, B:109:0x01b1, B:119:0x01d2, B:121:0x01dc, B:123:0x01e0, B:125:0x01e5, B:127:0x01f0, B:129:0x01fe, B:132:0x0206, B:128:0x01f6, B:79:0x014c, B:80:0x015f, B:82:0x0163, B:84:0x0169, B:88:0x0172, B:87:0x016e, B:89:0x0177, B:91:0x017d, B:95:0x0186, B:94:0x0182, B:96:0x018b, B:69:0x00f8, B:70:0x0100, B:71:0x010a, B:72:0x0116, B:74:0x0124, B:75:0x012d, B:76:0x0132, B:60:0x00d9, B:62:0x00df, B:52:0x00c4, B:147:0x0240, B:148:0x0279, B:30:0x0074, B:33:0x007d), top: B:154:0x000a }] */
    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void layoutChildren() {
        View view;
        View view2;
        int i;
        View view3;
        boolean z;
        View view4;
        View fillFromLeft;
        boolean z2 = this.mBlockLayoutRequests;
        if (z2) {
            return;
        }
        boolean z3 = true;
        this.mBlockLayoutRequests = true;
        try {
            super.layoutChildren();
            invalidate();
            if (this.mAdapter == null) {
                resetList();
                invokeOnItemScrollListener();
                if (z2) {
                    return;
                }
                this.mBlockLayoutRequests = false;
                return;
            }
            int i2 = this.mListPadding.left;
            int right = (getRight() - getLeft()) - this.mListPadding.right;
            int childCount = getChildCount();
            int i3 = this.mLayoutMode;
            if (i3 != 1) {
                if (i3 == 2) {
                    int i4 = this.mNextSelectedPosition - this.mFirstPosition;
                    if (i4 >= 0 && i4 < childCount) {
                        view2 = getChildAt(i4);
                        view = null;
                        i = 0;
                        view3 = null;
                        z = this.mDataChanged;
                        if (z) {
                        }
                        if (this.mItemCount == 0) {
                        }
                    }
                } else if (i3 != 3 && i3 != 4 && i3 != 5) {
                    int i5 = this.mSelectedPosition - this.mFirstPosition;
                    View childAt = (i5 < 0 || i5 >= childCount) ? null : getChildAt(i5);
                    View childAt2 = getChildAt(0);
                    int i6 = this.mNextSelectedPosition >= 0 ? this.mNextSelectedPosition - this.mSelectedPosition : 0;
                    View view5 = childAt;
                    view2 = getChildAt(i5 + i6);
                    view = view5;
                    int i7 = i6;
                    view3 = childAt2;
                    i = i7;
                    z = this.mDataChanged;
                    if (z) {
                        handleDataChanged();
                    }
                    if (this.mItemCount == 0) {
                        resetList();
                        invokeOnItemScrollListener();
                        if (z2) {
                            return;
                        }
                        this.mBlockLayoutRequests = false;
                        return;
                    } else if (this.mItemCount == this.mAdapter.getCount()) {
                        setSelectedPositionInt(this.mNextSelectedPosition);
                        int i8 = this.mFirstPosition;
                        AbsHListView.l lVar = this.mRecycler;
                        if (z) {
                            for (int i9 = 0; i9 < childCount; i9++) {
                                lVar.c(getChildAt(i9), i8 + i9);
                            }
                        } else {
                            lVar.f(childCount, i8);
                        }
                        View focusedChild = getFocusedChild();
                        if (focusedChild != null) {
                            if (z && !isDirectChildHeaderOrFooter(focusedChild)) {
                                focusedChild = null;
                                view4 = null;
                                requestFocus();
                            }
                            view4 = findFocus();
                            if (view4 != null) {
                                view4.onStartTemporaryDetach();
                            }
                            requestFocus();
                        } else {
                            focusedChild = null;
                            view4 = null;
                        }
                        detachAllViewsFromParent();
                        lVar.m();
                        switch (this.mLayoutMode) {
                            case 1:
                                this.mFirstPosition = 0;
                                fillFromLeft = fillFromLeft(i2);
                                adjustViewsLeftOrRight();
                                break;
                            case 2:
                                if (view2 != null) {
                                    fillFromLeft = fillFromSelection(view2.getLeft(), i2, right);
                                    break;
                                } else {
                                    fillFromLeft = fillFromMiddle(i2, right);
                                    break;
                                }
                            case 3:
                                fillFromLeft = fillLeft(this.mItemCount - 1, right);
                                adjustViewsLeftOrRight();
                                break;
                            case 4:
                                fillFromLeft = fillSpecific(reconcileSelectedPosition(), this.mSpecificLeft);
                                break;
                            case 5:
                                fillFromLeft = fillSpecific(this.mSyncPosition, this.mSpecificLeft);
                                break;
                            case 6:
                                fillFromLeft = moveSelection(view, view2, i, i2, right);
                                break;
                            default:
                                if (childCount == 0) {
                                    if (!this.mStackFromRight) {
                                        setSelectedPositionInt(lookForSelectablePosition(0, true));
                                        fillFromLeft = fillFromLeft(i2);
                                        break;
                                    } else {
                                        setSelectedPositionInt(lookForSelectablePosition(this.mItemCount - 1, false));
                                        fillFromLeft = fillLeft(this.mItemCount - 1, right);
                                        break;
                                    }
                                } else if (this.mSelectedPosition >= 0 && this.mSelectedPosition < this.mItemCount) {
                                    int i10 = this.mSelectedPosition;
                                    if (view != null) {
                                        i2 = view.getLeft();
                                    }
                                    fillFromLeft = fillSpecific(i10, i2);
                                    break;
                                } else if (this.mFirstPosition < this.mItemCount) {
                                    int i11 = this.mFirstPosition;
                                    if (view3 != null) {
                                        i2 = view3.getLeft();
                                    }
                                    fillFromLeft = fillSpecific(i11, i2);
                                    break;
                                } else {
                                    fillFromLeft = fillSpecific(0, i2);
                                    break;
                                }
                                break;
                        }
                        lVar.n();
                        if (fillFromLeft != null) {
                            if (this.mItemsCanFocus && hasFocus() && !fillFromLeft.hasFocus()) {
                                if ((fillFromLeft != focusedChild || view4 == null || !view4.requestFocus()) && !fillFromLeft.requestFocus()) {
                                    z3 = false;
                                }
                                fillFromLeft.setSelected(false);
                                this.mSelectorRect.setEmpty();
                            } else {
                                positionSelector(-1, fillFromLeft);
                            }
                            this.mSelectedLeft = fillFromLeft.getLeft();
                        } else {
                            if (this.mTouchMode > 0 && this.mTouchMode < 3) {
                                View childAt3 = getChildAt(this.mMotionPosition - this.mFirstPosition);
                                if (childAt3 != null) {
                                    positionSelector(this.mMotionPosition, childAt3);
                                }
                            } else {
                                this.mSelectedLeft = 0;
                                this.mSelectorRect.setEmpty();
                            }
                            if (hasFocus() && view4 != null) {
                                view4.requestFocus();
                            }
                        }
                        if (view4 != null && view4.getWindowToken() != null) {
                            view4.onFinishTemporaryDetach();
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
                        if (z2) {
                            return;
                        }
                        return;
                    } else {
                        throw new IllegalStateException("The content of the adapter has changed but ListView did not receive a notification. Make sure the content of your adapter is not modified from a background thread, but only from the UI thread. [in ListView(" + getId() + StringUtil.ARRAY_ELEMENT_SEPARATOR + getClass() + ") with Adapter(" + this.mAdapter.getClass() + ")]");
                    }
                }
            }
            view = null;
            view2 = null;
            i = 0;
            view3 = null;
            z = this.mDataChanged;
            if (z) {
            }
            if (this.mItemCount == 0) {
            }
        } finally {
            if (!z2) {
                this.mBlockLayoutRequests = false;
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AdapterView
    public int lookForSelectablePosition(int i, boolean z) {
        int min;
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter != null && !isInTouchMode()) {
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
            } else if (i >= 0 && i < count) {
                return i;
            }
        }
        return -1;
    }

    public int[] measureChild(View view) {
        measureItem(view);
        return new int[]{view.getMeasuredWidth(), view.getMeasuredHeight()};
    }

    public final int measureWidthOfChildren(int i, int i2, int i3, int i4, int i5) {
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter == null) {
            Rect rect = this.mListPadding;
            return rect.left + rect.right;
        }
        Rect rect2 = this.mListPadding;
        int i6 = rect2.left + rect2.right;
        int i7 = this.mDividerWidth;
        int i8 = 0;
        if (i3 == -1) {
            i3 = listAdapter.getCount() - 1;
        }
        AbsHListView.l lVar = this.mRecycler;
        boolean recycleOnMeasure = recycleOnMeasure();
        boolean[] zArr = this.mIsScrap;
        while (i2 <= i3) {
            View obtainView = obtainView(i2, zArr);
            measureScrapChildWidth(obtainView, i2, i);
            if (i2 > 0) {
                i6 += i7;
            }
            if (recycleOnMeasure && lVar.q(((AbsHListView.LayoutParams) obtainView.getLayoutParams()).f17446a)) {
                lVar.c(obtainView, -1);
            }
            i6 += obtainView.getMeasuredWidth();
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

    public final int[] measureWithLargeChildren(int i, int i2, int i3, int i4, int i5, int i6) {
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter == null) {
            Rect rect = this.mListPadding;
            return new int[]{rect.left + rect.right, rect.top + rect.bottom};
        }
        Rect rect2 = this.mListPadding;
        int i7 = rect2.left + rect2.right;
        int i8 = rect2.top + rect2.bottom;
        int i9 = this.mDividerWidth;
        int i10 = i3;
        if (i10 == -1) {
            i10 = listAdapter.getCount() - 1;
        }
        AbsHListView.l lVar = this.mRecycler;
        boolean recycleOnMeasure = recycleOnMeasure();
        boolean[] zArr = this.mIsScrap;
        int i11 = 0;
        int i12 = 0;
        for (int i13 = i2; i13 <= i10; i13++) {
            View obtainView = obtainView(i13, zArr);
            measureScrapChildWidth(obtainView, i13, i);
            if (recycleOnMeasure && lVar.q(((AbsHListView.LayoutParams) obtainView.getLayoutParams()).f17446a)) {
                lVar.c(obtainView, -1);
            }
            i11 = Math.max(i11, obtainView.getMeasuredWidth() + i9);
            i12 = Math.max(i12, obtainView.getMeasuredHeight());
        }
        return new int[]{Math.min(i7 + i11, i4), Math.min(i8 + i12, i5)};
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                addHeaderView(getChildAt(i));
            }
            removeAllViews();
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        ListAdapter listAdapter = this.mAdapter;
        int i2 = 0;
        int i3 = -1;
        if (listAdapter != null && z && rect != null) {
            rect.offset(getScrollX(), getScrollY());
            if (listAdapter.getCount() < getChildCount() + this.mFirstPosition) {
                this.mLayoutMode = 0;
                layoutChildren();
            }
            Rect rect2 = this.mTempRect;
            int childCount = getChildCount();
            int i4 = this.mFirstPosition;
            int i5 = 0;
            int i6 = -1;
            int i7 = Integer.MAX_VALUE;
            while (i2 < childCount) {
                if (listAdapter.isEnabled(i4 + i2)) {
                    View childAt = getChildAt(i2);
                    childAt.getDrawingRect(rect2);
                    offsetDescendantRectToMyCoords(childAt, rect2);
                    int distance = AbsHListView.getDistance(rect, rect2, i);
                    if (distance < i7) {
                        i5 = childAt.getLeft();
                        i6 = i2;
                        i7 = distance;
                    }
                }
                i2++;
            }
            i2 = i5;
            i3 = i6;
        }
        if (i3 >= 0) {
            setSelectionFromLeft(i3 + this.mFirstPosition, i2);
        } else {
            requestLayout();
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
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

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        if (getParent() == null || !this.mGestureDetector.onTouchEvent(motionEvent)) {
            return onInterceptTouchEvent;
        }
        requestDisallowInterceptTouchEvent(true);
        return true;
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

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    @TargetApi(11)
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        ListAdapter listAdapter = this.mAdapter;
        int count = listAdapter == null ? 0 : listAdapter.getCount();
        this.mItemCount = count;
        if (count <= 0 || !(mode == 0 || mode2 == 0)) {
            i3 = 0;
            i4 = 0;
        } else {
            View obtainView = obtainView(0, this.mIsScrap);
            measureScrapChildWidth(obtainView, 0, i2);
            int measuredWidth = obtainView.getMeasuredWidth();
            int measuredHeight = obtainView.getMeasuredHeight();
            r3 = Build.VERSION.SDK_INT >= 11 ? ViewGroup.combineMeasuredStates(0, obtainView.getMeasuredState()) : 0;
            if (recycleOnMeasure() && this.mRecycler.q(((AbsHListView.LayoutParams) obtainView.getLayoutParams()).f17446a)) {
                this.mRecycler.c(obtainView, -1);
            }
            i3 = r3;
            i4 = measuredWidth;
            r3 = measuredHeight;
        }
        if (mode2 == 0) {
            Rect rect = this.mListPadding;
            size2 = rect.top + rect.bottom + r3 + getHorizontalScrollbarHeight();
        } else if (mode2 == Integer.MIN_VALUE && this.mItemCount > 0 && (i5 = this.mMeasureWithChild) > -1) {
            size2 = measureWithLargeChildren(i2, i5, i5, size, size2, -1)[1];
        } else if (Build.VERSION.SDK_INT >= 11) {
            size2 |= (-16777216) & i3;
        }
        if (mode == 0) {
            Rect rect2 = this.mListPadding;
            size = (getHorizontalFadingEdgeLength() * 2) + rect2.left + rect2.right + i4;
        }
        if (mode == Integer.MIN_VALUE) {
            int i6 = this.mMaxWidth;
            size = measureWidthOfChildren(i2, 0, -1, (i6 <= 0 || i6 >= size) ? size : i6, -1);
        }
        setMeasuredDimension(size, size2);
        this.mHeightMeasureSpec = i2;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        View focusedChild;
        if (getChildCount() > 0 && (focusedChild = getFocusedChild()) != null) {
            int indexOfChild = this.mFirstPosition + indexOfChild(focusedChild);
            int left = focusedChild.getLeft() - Math.max(0, focusedChild.getRight() - (i - getPaddingLeft()));
            if (this.mFocusSelector == null) {
                this.mFocusSelector = new d();
            }
            d dVar = this.mFocusSelector;
            dVar.a(indexOfChild, left);
            post(dVar);
        }
        super.onSizeChanged(i, i2, i3, i4);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        motionEvent.getAction();
        return super.onTouchEvent(motionEvent);
    }

    public boolean pageScroll(int i) {
        int i2;
        boolean z;
        int lookForSelectablePosition;
        if (i == 33) {
            i2 = Math.max(0, (this.mSelectedPosition - getChildCount()) - 1);
        } else if (i == 130) {
            i2 = Math.min(this.mItemCount - 1, (this.mSelectedPosition + getChildCount()) - 1);
            z = true;
            if (i2 >= 0 || (lookForSelectablePosition = lookForSelectablePosition(i2, z)) < 0) {
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
            if (!awakenScrollBars()) {
                invalidate();
            }
            return true;
        } else {
            i2 = -1;
        }
        z = false;
        if (i2 >= 0) {
        }
        return false;
    }

    @ViewDebug.ExportedProperty(category = "list")
    public boolean recycleOnMeasure() {
        return true;
    }

    public boolean removeFooterView(View view) {
        boolean z = false;
        if (this.mFooterViewInfos.size() > 0) {
            ListAdapter listAdapter = this.mAdapter;
            if (listAdapter != null && ((d.b.i0.a1.b.d) listAdapter).d(view)) {
                AbsHListView.c cVar = this.mDataSetObserver;
                if (cVar != null) {
                    cVar.onChanged();
                }
                z = true;
            }
            removeFixedViewInfo(view, this.mFooterViewInfos);
        }
        return z;
    }

    public boolean removeHeaderView(View view) {
        boolean z = false;
        if (this.mHeaderViewInfos.size() > 0) {
            ListAdapter listAdapter = this.mAdapter;
            if (listAdapter != null && ((d.b.i0.a1.b.d) listAdapter).e(view)) {
                AbsHListView.c cVar = this.mDataSetObserver;
                if (cVar != null) {
                    cVar.onChanged();
                }
                z = true;
            }
            removeFixedViewInfo(view, this.mHeaderViewInfos);
        }
        return z;
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
        if (showingLeftFadingEdge() && (this.mSelectedPosition > 0 || i4 > horizontalFadingEdgeLength)) {
            scrollX += horizontalFadingEdgeLength;
        }
        int right = getChildAt(getChildCount() - 1).getRight();
        if (showingRightFadingEdge() && (this.mSelectedPosition < this.mItemCount - 1 || rect.right < right - horizontalFadingEdgeLength)) {
            i5 -= horizontalFadingEdgeLength;
        }
        if (rect.right > i5 && rect.left > scrollX) {
            if (rect.width() > width) {
                i3 = rect.left - scrollX;
            } else {
                i3 = rect.right - i5;
            }
            i = Math.min(i3 + 0, right - i5);
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
            positionSelector(-1, view);
            this.mSelectedLeft = view.getTop();
            invalidate();
        }
        return z2;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView
    public void resetList() {
        clearRecycledState(this.mHeaderViewInfos);
        clearRecycledState(this.mFooterViewInfos);
        super.resetList();
        this.mLayoutMode = 0;
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

    public void setDividerWidth(int i) {
        this.mDividerWidth = i;
        requestLayout();
        invalidate();
    }

    public void setFooterDividersEnabled(boolean z) {
        this.mFooterDividersEnabled = z;
        invalidate();
    }

    public void setHeaderDividersEnabled(boolean z) {
        this.mHeaderDividersEnabled = z;
        invalidate();
    }

    public void setItemsCanFocus(boolean z) {
        this.mItemsCanFocus = z;
        if (z) {
            return;
        }
        setDescendantFocusability(393216);
    }

    public void setMaxWidth(int i) {
        this.mMaxWidth = i;
    }

    public void setOverscrollFooter(Drawable drawable) {
        this.mOverScrollFooter = drawable;
        invalidate();
    }

    public void setOverscrollHeader(Drawable drawable) {
        this.mOverScrollHeader = drawable;
        if (getScrollX() < 0) {
            invalidate();
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AdapterView
    public void setSelection(int i) {
        setSelectionFromLeft(i, 0);
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

    public void setSelectionFromLeft(int i, int i2) {
        if (this.mAdapter == null) {
            return;
        }
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
            AbsHListView.k kVar = this.mPositionScroller;
            if (kVar != null) {
                kVar.f();
            }
            requestLayout();
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView
    public void setSelectionInt(int i) {
        setNextSelectedPositionInt(i);
        int i2 = this.mSelectedPosition;
        boolean z = true;
        if (i2 < 0 || (i != i2 - 1 && i != i2 + 1)) {
            z = false;
        }
        AbsHListView.k kVar = this.mPositionScroller;
        if (kVar != null) {
            kVar.f();
        }
        layoutChildren();
        if (z) {
            awakenScrollBars();
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView
    public void smoothScrollByOffset(int i) {
        super.smoothScrollByOffset(i);
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView
    public void smoothScrollToPosition(int i) {
        super.smoothScrollToPosition(i);
    }

    public HListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.hlv_listViewStyle);
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
        AbsHListView.c cVar;
        ListAdapter listAdapter2 = this.mAdapter;
        if (listAdapter2 != null && (cVar = this.mDataSetObserver) != null) {
            listAdapter2.unregisterDataSetObserver(cVar);
        }
        resetList();
        this.mRecycler.d();
        if (this.mHeaderViewInfos.size() <= 0 && this.mFooterViewInfos.size() <= 0) {
            this.mAdapter = listAdapter;
        } else {
            this.mAdapter = new d.b.i0.a1.b.d(this.mHeaderViewInfos, this.mFooterViewInfos, listAdapter);
        }
        this.mOldSelectedPosition = -1;
        this.mOldSelectedColId = Long.MIN_VALUE;
        super.setAdapter(listAdapter);
        ListAdapter listAdapter3 = this.mAdapter;
        if (listAdapter3 != null) {
            this.mAreAllItemsSelectable = listAdapter3.areAllItemsEnabled();
            this.mOldItemCount = this.mItemCount;
            this.mItemCount = this.mAdapter.getCount();
            checkFocus();
            AbsHListView.c cVar2 = new AbsHListView.c();
            this.mDataSetObserver = cVar2;
            this.mAdapter.registerDataSetObserver(cVar2);
            this.mRecycler.p(this.mAdapter.getViewTypeCount());
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

    public HListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Drawable drawable;
        Drawable drawable2;
        Drawable drawable3;
        boolean z;
        this.mHeaderViewInfos = new ArrayList<>();
        this.mFooterViewInfos = new ArrayList<>();
        boolean z2 = true;
        this.mAreAllItemsSelectable = true;
        int i2 = 0;
        this.mItemsCanFocus = false;
        this.mTempRect = new Rect();
        CharSequence[] charSequenceArr = null;
        this.mArrowScrollFocusResult = new b();
        this.mMaxWidth = 0;
        this.mGestureDetector = new GestureDetector(new e());
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.HListView, i, 0);
        int i3 = -1;
        if (obtainStyledAttributes != null) {
            charSequenceArr = obtainStyledAttributes.getTextArray(R$styleable.HListView_android_entries);
            drawable = obtainStyledAttributes.getDrawable(R$styleable.HListView_android_divider);
            drawable2 = obtainStyledAttributes.getDrawable(R$styleable.HListView_hlv_overScrollHeader);
            drawable3 = obtainStyledAttributes.getDrawable(R$styleable.HListView_hlv_overScrollFooter);
            i2 = obtainStyledAttributes.getDimensionPixelSize(R$styleable.HListView_hlv_dividerWidth, 0);
            boolean z3 = obtainStyledAttributes.getBoolean(R$styleable.HListView_hlv_headerDividersEnabled, true);
            boolean z4 = obtainStyledAttributes.getBoolean(R$styleable.HListView_hlv_footerDividersEnabled, true);
            i3 = obtainStyledAttributes.getInteger(R$styleable.HListView_hlv_measureWithChild, -1);
            obtainStyledAttributes.recycle();
            z = z4;
            z2 = z3;
        } else {
            drawable = null;
            drawable2 = null;
            drawable3 = null;
            z = true;
        }
        if (charSequenceArr != null) {
            setAdapter((ListAdapter) new ArrayAdapter(context, 17367043, charSequenceArr));
        }
        if (drawable != null) {
            setDivider(drawable);
        }
        if (drawable2 != null) {
            setOverscrollHeader(drawable2);
        }
        if (drawable3 != null) {
            setOverscrollFooter(drawable3);
        }
        if (i2 != 0) {
            setDividerWidth(i2);
        }
        this.mHeaderDividersEnabled = z2;
        this.mFooterDividersEnabled = z;
        this.mMeasureWithChild = i3;
    }

    public void addFooterView(View view) {
        addFooterView(view, null, true);
    }

    public void addHeaderView(View view) {
        addHeaderView(view, null, true);
    }
}
