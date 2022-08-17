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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.n47;
import java.util.ArrayList;
@RemoteViews.RemoteView
/* loaded from: classes3.dex */
public class HListView extends AbsHListView {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String LOG_TAG = "HListView";
    public static final float MAX_SCROLL_FACTOR = 0.33f;
    public static final int MIN_SCROLL_PREVIEW_PIXELS = 2;
    public static final int NO_POSITION = -1;
    public transient /* synthetic */ FieldHolder $fh;
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

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b : invokeV.intValue;
        }

        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : invokeV.intValue;
        }

        public void c(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
                this.a = i;
                this.b = i2;
            }
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public Object b;
        public boolean c;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;
        public final /* synthetic */ HListView c;

        public d(HListView hListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = hListView;
        }

        public d a(int i, int i2) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i, i2)) == null) {
                this.a = i;
                this.b = i2;
                return this;
            }
            return (d) invokeII.objValue;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.c.setSelectionFromLeft(this.a, this.b);
            }
        }

        public /* synthetic */ d(HListView hListView, a aVar) {
            this(hListView);
        }
    }

    /* loaded from: classes3.dex */
    public class e extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HListView a;

        public e(HListView hListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hListView;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})) == null) ? Math.abs(f) > Math.abs(f2) : invokeCommon.booleanValue;
        }

        public /* synthetic */ e(HListView hListView, a aVar) {
            this(hListView);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HListView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private View addViewAfter(View view2, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, this, view2, i)) == null) {
            int i2 = i + 1;
            View obtainView = obtainView(i2, this.mIsScrap);
            setupChild(obtainView, i2, view2.getRight() + this.mDividerWidth, true, this.mListPadding.top, false, this.mIsScrap[0]);
            return obtainView;
        }
        return (View) invokeLI.objValue;
    }

    private View addViewBefore(View view2, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, this, view2, i)) == null) {
            int i2 = i - 1;
            View obtainView = obtainView(i2, this.mIsScrap);
            setupChild(obtainView, i2, view2.getLeft() - this.mDividerWidth, false, this.mListPadding.top, false, this.mIsScrap[0]);
            return obtainView;
        }
        return (View) invokeLI.objValue;
    }

    private void adjustViewsLeftOrRight() {
        int childCount;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65541, this) == null) || (childCount = getChildCount()) <= 0) {
            return;
        }
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

    private int amountToScroll(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65542, this, i, i2)) == null) {
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
        return invokeII.intValue;
    }

    private int amountToScrollToNewFocus(int i, View view2, int i2) {
        InterceptResult invokeCommon;
        int i3;
        int arrowScrollPreviewLength;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, this, new Object[]{Integer.valueOf(i), view2, Integer.valueOf(i2)})) == null) {
            view2.getDrawingRect(this.mTempRect);
            offsetDescendantRectToMyCoords(view2, this.mTempRect);
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
        return invokeCommon.intValue;
    }

    private b arrowScrollFocused(int i) {
        InterceptResult invokeI;
        View findNextFocusFromRect;
        int lookForSelectablePositionOnScreen;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65544, this, i)) == null) {
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
        return (b) invokeI.objValue;
    }

    private boolean arrowScrollImpl(int i) {
        InterceptResult invokeI;
        View focusedChild;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65545, this, i)) == null) {
            if (getChildCount() <= 0) {
                return false;
            }
            View selectedView = getSelectedView();
            int i2 = this.mSelectedPosition;
            int lookForSelectablePositionOnScreen = lookForSelectablePositionOnScreen(i);
            int amountToScroll = amountToScroll(i, lookForSelectablePositionOnScreen);
            View view2 = null;
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
                view2 = selectedView;
            } else {
                hideSelector();
                this.mResurrectToPosition = -1;
            }
            if (z) {
                if (view2 != null) {
                    positionSelector(i2, view2);
                    this.mSelectedLeft = view2.getLeft();
                }
                if (!awakenScrollBars()) {
                    invalidate();
                }
                invokeOnItemScrollListener();
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    private void clearRecycledState(ArrayList<c> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65546, this, arrayList) == null) || arrayList == null) {
            return;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            AbsHListView.LayoutParams layoutParams = (AbsHListView.LayoutParams) arrayList.get(i).a.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.b = false;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0072, code lost:
        if (fullScroll(130) != false) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00a2, code lost:
        if (fullScroll(33) != false) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00ce, code lost:
        if (fullScroll(130) != false) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x00e2, code lost:
        if (fullScroll(33) != false) goto L59;
     */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0175 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0176  */
    @TargetApi(11)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean commonKey(int i, int i2, KeyEvent keyEvent) {
        InterceptResult invokeIIL;
        boolean z;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeIIL = interceptable.invokeIIL(65547, this, i, i2, keyEvent)) != null) {
            return invokeIIL.booleanValue;
        }
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
                                                z = handleHorizontalFocusWithinListItem(130);
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
                                                        if (i2 > 0 && arrowScroll(130)) {
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
                    pageScroll(130);
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
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(65548, this, i) == null) && this.mFirstPosition == 0 && i > 0) {
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
    }

    private void correctTooWide(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(65549, this, i) == null) && (this.mFirstPosition + i) - 1 == this.mItemCount - 1 && i > 0) {
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
    }

    private int distanceToView(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, this, view2)) == null) {
            view2.getDrawingRect(this.mTempRect);
            offsetDescendantRectToMyCoords(view2, this.mTempRect);
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
        return invokeL.intValue;
    }

    private void fillBeforeAndAfter(View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65551, this, view2, i) == null) {
            int i2 = this.mDividerWidth;
            if (!this.mStackFromRight) {
                fillLeft(i - 1, view2.getLeft() - i2);
                adjustViewsLeftOrRight();
                fillRight(i + 1, view2.getRight() + i2);
                return;
            }
            fillRight(i + 1, view2.getRight() + i2);
            adjustViewsLeftOrRight();
            fillLeft(i - 1, view2.getLeft() - i2);
        }
    }

    private View fillFromLeft(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65552, this, i)) == null) {
            int min = Math.min(this.mFirstPosition, this.mSelectedPosition);
            this.mFirstPosition = min;
            int min2 = Math.min(min, this.mItemCount - 1);
            this.mFirstPosition = min2;
            if (min2 < 0) {
                this.mFirstPosition = 0;
            }
            return fillRight(this.mFirstPosition, i);
        }
        return (View) invokeI.objValue;
    }

    private View fillFromMiddle(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65553, this, i, i2)) == null) {
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
        return (View) invokeII.objValue;
    }

    private View fillFromSelection(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(65554, this, i, i2, i3)) == null) {
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
        return (View) invokeIII.objValue;
    }

    private View fillLeft(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65555, this, i, i2)) == null) {
            View view2 = null;
            int i3 = i2;
            while (true) {
                if (i3 <= 0 || i < 0) {
                    break;
                }
                boolean z = i == this.mSelectedPosition;
                View makeAndAddView = makeAndAddView(i, i3, false, this.mListPadding.top, z);
                i3 = makeAndAddView.getLeft() - this.mDividerWidth;
                if (z) {
                    view2 = makeAndAddView;
                }
                i--;
            }
            int i4 = i + 1;
            this.mFirstPosition = i4;
            setVisibleRangeHint(i4, (getChildCount() + i4) - 1);
            return view2;
        }
        return (View) invokeII.objValue;
    }

    private View fillRight(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65556, this, i, i2)) == null) {
            int right = getRight() - getLeft();
            View view2 = null;
            int i3 = i2;
            while (true) {
                if (i3 >= right || i >= this.mItemCount) {
                    break;
                }
                boolean z = i == this.mSelectedPosition;
                View makeAndAddView = makeAndAddView(i, i3, true, this.mListPadding.top, z);
                i3 = this.mDividerWidth + makeAndAddView.getRight();
                if (z) {
                    view2 = makeAndAddView;
                }
                i++;
            }
            int i4 = this.mFirstPosition;
            setVisibleRangeHint(i4, (getChildCount() + i4) - 1);
            return view2;
        }
        return (View) invokeII.objValue;
    }

    private View fillSpecific(int i, int i2) {
        InterceptResult invokeII;
        View view2;
        View view3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65557, this, i, i2)) == null) {
            boolean z = i == this.mSelectedPosition;
            View makeAndAddView = makeAndAddView(i, i2, true, this.mListPadding.top, z);
            this.mFirstPosition = i;
            int i3 = this.mDividerWidth;
            if (!this.mStackFromRight) {
                view2 = fillLeft(i - 1, makeAndAddView.getLeft() - i3);
                adjustViewsLeftOrRight();
                view3 = fillRight(i + 1, makeAndAddView.getRight() + i3);
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
                view2 = fillLeft;
                view3 = fillRight;
            }
            return z ? makeAndAddView : view2 != null ? view2 : view3;
        }
        return (View) invokeII.objValue;
    }

    private View findAccessibilityFocusedChild(View view2) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, this, view2)) == null) {
            ViewParent parent = view2.getParent();
            while (true) {
                z = parent instanceof View;
                if (!z || parent == this) {
                    break;
                }
                view2 = (View) parent;
                parent = parent.getParent();
            }
            if (z) {
                return view2;
            }
            return null;
        }
        return (View) invokeL.objValue;
    }

    private int getArrowScrollPreviewLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65559, this)) == null) ? Math.max(2, getHorizontalFadingEdgeLength()) : invokeV.intValue;
    }

    private int getLeftSelectionPixel(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIII = interceptable.invokeIII(65560, this, i, i2, i3)) == null) ? i3 > 0 ? i + i2 : i : invokeIII.intValue;
    }

    private int getRightSelectionPixel(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIII = interceptable.invokeIII(65561, this, i, i2, i3)) == null) ? i3 != this.mItemCount + (-1) ? i - i2 : i : invokeIII.intValue;
    }

    private boolean handleHorizontalFocusWithinListItem(int i) {
        InterceptResult invokeI;
        View selectedView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65562, this, i)) == null) {
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
        return invokeI.booleanValue;
    }

    private void handleNewSelectionChange(View view2, int i, int i2, boolean z) {
        View childAt;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65563, this, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (i2 != -1) {
                int i3 = this.mSelectedPosition;
                int i4 = this.mFirstPosition;
                int i5 = i3 - i4;
                int i6 = i2 - i4;
                boolean z3 = true;
                if (i == 33) {
                    z2 = true;
                    childAt = view2;
                    view2 = getChildAt(i6);
                    i5 = i6;
                    i6 = i5;
                } else {
                    childAt = getChildAt(i6);
                    z2 = false;
                }
                int childCount = getChildCount();
                if (view2 != null) {
                    view2.setSelected(!z && z2);
                    measureAndAdjustRight(view2, i5, childCount);
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
    }

    private boolean isDirectChildHeaderOrFooter(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, this, view2)) == null) {
            ArrayList<c> arrayList = this.mHeaderViewInfos;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (view2 == arrayList.get(i).a) {
                    return true;
                }
            }
            ArrayList<c> arrayList2 = this.mFooterViewInfos;
            int size2 = arrayList2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                if (view2 == arrayList2.get(i2).a) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private boolean isViewAncestorOf(View view2, View view3) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65565, this, view2, view3)) == null) {
            if (view2 == view3) {
                return true;
            }
            ViewParent parent = view2.getParent();
            return (parent instanceof ViewGroup) && isViewAncestorOf((View) parent, view3);
        }
        return invokeLL.booleanValue;
    }

    private int lookForSelectablePositionOnScreen(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65566, this, i)) == null) {
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
        return invokeI.intValue;
    }

    private View makeAndAddView(int i, int i2, boolean z, int i3, boolean z2) {
        InterceptResult invokeCommon;
        View g;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65567, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3), Boolean.valueOf(z2)})) == null) {
            if (!this.mDataChanged && (g = this.mRecycler.g(i)) != null) {
                setupChild(g, i, i2, z, i3, z2, true);
                return g;
            }
            View obtainView = obtainView(i, this.mIsScrap);
            setupChild(obtainView, i, i2, z, i3, z2, this.mIsScrap[0]);
            return obtainView;
        }
        return (View) invokeCommon.objValue;
    }

    private void measureAndAdjustRight(View view2, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLII(65568, this, view2, i, i2) != null) {
            return;
        }
        int width = view2.getWidth();
        measureItem(view2);
        if (view2.getMeasuredWidth() == width) {
            return;
        }
        relayoutMeasuredItem(view2);
        int measuredWidth = view2.getMeasuredWidth() - width;
        while (true) {
            i++;
            if (i >= i2) {
                return;
            }
            getChildAt(i).offsetLeftAndRight(measuredWidth);
        }
    }

    private void measureItem(View view2) {
        int makeMeasureSpec;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65569, this, view2) == null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
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
            view2.measure(makeMeasureSpec, childMeasureSpec);
        }
    }

    private void measureScrapChildWidth(View view2, int i, int i2) {
        int makeMeasureSpec;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65570, this, view2, i, i2) == null) {
            AbsHListView.LayoutParams layoutParams = (AbsHListView.LayoutParams) view2.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = (AbsHListView.LayoutParams) generateDefaultLayoutParams();
                view2.setLayoutParams(layoutParams);
            }
            layoutParams.a = this.mAdapter.getItemViewType(i);
            layoutParams.c = true;
            Rect rect = this.mListPadding;
            int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, rect.top + rect.bottom, ((ViewGroup.LayoutParams) layoutParams).height);
            int i3 = ((ViewGroup.LayoutParams) layoutParams).width;
            if (i3 > 0) {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
            } else {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            }
            view2.measure(makeMeasureSpec, childMeasureSpec);
        }
    }

    private View moveSelection(View view2, View view3, int i, int i2, int i3) {
        InterceptResult invokeCommon;
        View makeAndAddView;
        View makeAndAddView2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65571, this, new Object[]{view2, view3, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
            int i4 = this.mSelectedPosition;
            int leftSelectionPixel = getLeftSelectionPixel(i2, horizontalFadingEdgeLength, i4);
            int rightSelectionPixel = getRightSelectionPixel(i2, horizontalFadingEdgeLength, i4);
            if (i > 0) {
                View makeAndAddView3 = makeAndAddView(i4 - 1, view2.getLeft(), true, this.mListPadding.top, false);
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
                if (view3 != null) {
                    makeAndAddView2 = makeAndAddView(i4, view3.getLeft(), true, this.mListPadding.top, true);
                } else {
                    makeAndAddView2 = makeAndAddView(i4, view2.getLeft(), false, this.mListPadding.top, true);
                }
                makeAndAddView = makeAndAddView2;
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
        return (View) invokeCommon.objValue;
    }

    private int positionOfNewFocus(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65572, this, view2)) == null) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (isViewAncestorOf(view2, getChildAt(i))) {
                    return this.mFirstPosition + i;
                }
            }
            throw new IllegalArgumentException("newFocus is not a child of any of the children of the list!");
        }
        return invokeL.intValue;
    }

    private void relayoutMeasuredItem(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65573, this, view2) == null) {
            int measuredWidth = view2.getMeasuredWidth();
            int measuredHeight = view2.getMeasuredHeight();
            int i = this.mListPadding.top;
            int left = view2.getLeft();
            view2.layout(left, i, measuredWidth + left, measuredHeight + i);
        }
    }

    private void removeFixedViewInfo(View view2, ArrayList<c> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65574, this, view2, arrayList) == null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (arrayList.get(i).a == view2) {
                    arrayList.remove(i);
                    return;
                }
            }
        }
    }

    private void scrollListItemsBy(int i) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65575, this, i) == null) {
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
                    if (lVar.q(((AbsHListView.LayoutParams) childAt2.getLayoutParams()).a)) {
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
                if (lVar.q(((AbsHListView.LayoutParams) childAt4.getLayoutParams()).a)) {
                    detachViewFromParent(childAt4);
                    lVar.c(childAt4, this.mFirstPosition + childCount2);
                } else {
                    removeViewInLayout(childAt4);
                }
                childCount2--;
                childAt4 = getChildAt(childCount2);
            }
        }
    }

    @TargetApi(11)
    private void setupChild(View view2, int i, int i2, boolean z, int i3, boolean z2, boolean z3) {
        int makeMeasureSpec;
        SparseArrayCompat<Boolean> sparseArrayCompat;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65576, this, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            boolean z4 = z2 && shouldShowSelector();
            boolean z5 = z4 != view2.isSelected();
            int i4 = this.mTouchMode;
            boolean z6 = i4 > 0 && i4 < 3 && this.mMotionPosition == i;
            boolean z7 = z6 != view2.isPressed();
            boolean z8 = !z3 || z5 || view2.isLayoutRequested();
            AbsHListView.LayoutParams layoutParams = (AbsHListView.LayoutParams) view2.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = (AbsHListView.LayoutParams) generateDefaultLayoutParams();
            }
            layoutParams.a = this.mAdapter.getItemViewType(i);
            if ((z3 && !layoutParams.c) || (layoutParams.b && layoutParams.a == -2)) {
                attachViewToParent(view2, z ? -1 : 0, layoutParams);
            } else {
                layoutParams.c = false;
                if (layoutParams.a == -2) {
                    layoutParams.b = true;
                }
                addViewInLayout(view2, z ? -1 : 0, layoutParams, true);
            }
            if (z5) {
                view2.setSelected(z4);
            }
            if (z7) {
                view2.setPressed(z6);
            }
            if (this.mChoiceMode != 0 && (sparseArrayCompat = this.mCheckStates) != null) {
                if (view2 instanceof Checkable) {
                    ((Checkable) view2).setChecked(sparseArrayCompat.get(i, Boolean.FALSE).booleanValue());
                } else if (Build.VERSION.SDK_INT >= 11) {
                    view2.setActivated(sparseArrayCompat.get(i, Boolean.FALSE).booleanValue());
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
                view2.measure(makeMeasureSpec, childMeasureSpec);
            } else {
                cleanupLayoutState(view2);
            }
            int measuredWidth = view2.getMeasuredWidth();
            int measuredHeight = view2.getMeasuredHeight();
            int i7 = z ? i2 : i2 - measuredWidth;
            if (z8) {
                view2.layout(i7, i3, measuredWidth + i7, measuredHeight + i3);
            } else {
                view2.offsetLeftAndRight(i7 - view2.getLeft());
                view2.offsetTopAndBottom(i3 - view2.getTop());
            }
            if (this.mCachingStarted && !view2.isDrawingCacheEnabled()) {
                view2.setDrawingCacheEnabled(true);
            }
            if (Build.VERSION.SDK_INT < 11 || !z3 || ((AbsHListView.LayoutParams) view2.getLayoutParams()).d == i) {
                return;
            }
            view2.jumpDrawablesToCurrentState();
        }
    }

    private boolean showingLeftFadingEdge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65577, this)) == null) {
            return this.mFirstPosition > 0 || getChildAt(0).getLeft() > getScrollX() + this.mListPadding.left;
        }
        return invokeV.booleanValue;
    }

    private boolean showingRightFadingEdge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65578, this)) == null) {
            int childCount = getChildCount();
            return (this.mFirstPosition + childCount) - 1 < this.mItemCount - 1 || getChildAt(childCount + (-1)).getRight() < (getScrollX() + getWidth()) - this.mListPadding.right;
        }
        return invokeV.booleanValue;
    }

    public void addFooterView(View view2, Object obj, boolean z) {
        AbsHListView.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, obj, z) == null) {
            c cVar2 = new c();
            cVar2.a = view2;
            cVar2.b = obj;
            cVar2.c = z;
            this.mFooterViewInfos.add(cVar2);
            if (this.mAdapter == null || (cVar = this.mDataSetObserver) == null) {
                return;
            }
            cVar.onChanged();
        }
    }

    public void addHeaderView(View view2, Object obj, boolean z) {
        AbsHListView.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048579, this, view2, obj, z) == null) {
            ListAdapter listAdapter = this.mAdapter;
            if (listAdapter != null && !(listAdapter instanceof n47)) {
                throw new IllegalStateException("Cannot add header view to list -- setAdapter has already been called.");
            }
            c cVar2 = new c();
            cVar2.a = view2;
            cVar2.b = obj;
            cVar2.c = z;
            this.mHeaderViewInfos.add(cVar2);
            if (this.mAdapter == null || (cVar = this.mDataSetObserver) == null) {
                return;
            }
            cVar.onChanged();
        }
    }

    public boolean arrowScroll(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
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
        return invokeI.booleanValue;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AdapterView, android.view.ViewGroup
    public boolean canAnimate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? super.canAnimate() && this.mItemCount > 0 : invokeV.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:107:0x01c2, code lost:
        if (r8.isEnabled(r3 + 1) == false) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x011b, code lost:
        if (r8.isEnabled(r7 + 1) == false) goto L67;
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, canvas) == null) {
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
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, keyEvent)) == null) {
            boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
            return (dispatchKeyEvent || getFocusedChild() == null || keyEvent.getAction() != 0) ? dispatchKeyEvent : onKeyDown(keyEvent.getKeyCode(), keyEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, motionEvent)) == null) {
            try {
                return super.dispatchTouchEvent(motionEvent);
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{canvas, view2, Long.valueOf(j)})) == null) {
            boolean drawChild = super.drawChild(canvas, view2, j);
            if (this.mCachingActive) {
                this.mCachingActive = false;
            }
            return drawChild;
        }
        return invokeCommon.booleanValue;
    }

    public void drawDivider(Canvas canvas, Rect rect, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048586, this, canvas, rect, i) == null) {
            Drawable drawable = this.mDivider;
            drawable.setBounds(rect);
            drawable.draw(canvas);
        }
    }

    public void drawOverscrollFooter(Canvas canvas, Drawable drawable, Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, canvas, drawable, rect) == null) {
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
    }

    public void drawOverscrollHeader(Canvas canvas, Drawable drawable, Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048588, this, canvas, drawable, rect) == null) {
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
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView
    public void fillGap(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            int childCount = getChildCount();
            if (z) {
                fillRight(this.mFirstPosition + childCount, childCount > 0 ? this.mDividerWidth + getChildAt(childCount - 1).getRight() : 0);
                correctTooWide(getChildCount());
                return;
            }
            fillLeft(this.mFirstPosition - 1, childCount > 0 ? getChildAt(0).getLeft() - this.mDividerWidth : getWidth() - 0);
            correctTooSmall(getChildCount());
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView
    public int findMotionCol(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i)) == null) {
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
        return invokeI.intValue;
    }

    public boolean fullScroll(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i)) == null) {
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
                if (z && !awakenScrollBars()) {
                    awakenScrollBars();
                    invalidate();
                }
                return z;
            }
            if (i == 130) {
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
            if (z) {
                awakenScrollBars();
                invalidate();
            }
            return z;
        }
        return invokeI.booleanValue;
    }

    @Deprecated
    public long[] getCheckItemIds() {
        InterceptResult invokeV;
        SparseArrayCompat<Boolean> sparseArrayCompat;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
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
        return (long[]) invokeV.objValue;
    }

    public Drawable getDivider() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.mDivider : (Drawable) invokeV.objValue;
    }

    public int getDividerWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.mDividerWidth : invokeV.intValue;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView
    public int getFooterViewsCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.mFooterViewInfos.size() : invokeV.intValue;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView
    public int getHeaderViewsCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.mHeaderViewInfos.size() : invokeV.intValue;
    }

    public boolean getItemsCanFocus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.mItemsCanFocus : invokeV.booleanValue;
    }

    public int getMaxScrollAmount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? (int) ((getRight() - getLeft()) * 0.33f) : invokeV.intValue;
    }

    public Drawable getOverscrollFooter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.mOverScrollFooter : (Drawable) invokeV.objValue;
    }

    public Drawable getOverscrollHeader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.mOverScrollHeader : (Drawable) invokeV.objValue;
    }

    @Override // android.view.View
    public boolean isOpaque() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
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
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, CONST, IPUT] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x01bf, code lost:
        r0 = getFocusedChild();
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x01c3, code lost:
        if (r0 == null) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x01c5, code lost:
        r0.clearFocus();
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x01c8, code lost:
        positionSelector(-1, r1);
     */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0090 A[Catch: all -> 0x027e, TryCatch #0 {all -> 0x027e, blocks: (B:7:0x000e, B:9:0x0018, B:13:0x0023, B:22:0x004a, B:25:0x0053, B:27:0x0059, B:29:0x0061, B:31:0x0068, B:38:0x008c, B:40:0x0090, B:41:0x0093, B:43:0x0097, B:47:0x00a2, B:49:0x00ac, B:53:0x00ba, B:55:0x00cb, B:58:0x00d3, B:65:0x00e6, B:67:0x00ec, B:68:0x00f4, B:70:0x00f9, B:80:0x0143, B:99:0x0195, B:101:0x019a, B:103:0x019f, B:105:0x01a5, B:109:0x01af, B:116:0x01bf, B:118:0x01c5, B:119:0x01c8, B:122:0x01d9, B:136:0x020f, B:138:0x0215, B:139:0x0218, B:141:0x0221, B:142:0x0229, B:144:0x0238, B:145:0x023b, B:120:0x01cc, B:111:0x01b5, B:121:0x01d6, B:123:0x01e0, B:125:0x01e4, B:127:0x01e9, B:129:0x01f4, B:131:0x0202, B:134:0x020a, B:130:0x01fa, B:81:0x0150, B:82:0x0163, B:84:0x0167, B:86:0x016d, B:90:0x0176, B:89:0x0172, B:91:0x017b, B:93:0x0181, B:97:0x018a, B:96:0x0186, B:98:0x018f, B:71:0x00fc, B:72:0x0104, B:73:0x010e, B:74:0x011a, B:76:0x0128, B:77:0x0131, B:78:0x0136, B:62:0x00dd, B:64:0x00e3, B:54:0x00c8, B:149:0x0244, B:150:0x027d, B:32:0x0078, B:35:0x0081), top: B:159:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0097 A[Catch: all -> 0x027e, TRY_LEAVE, TryCatch #0 {all -> 0x027e, blocks: (B:7:0x000e, B:9:0x0018, B:13:0x0023, B:22:0x004a, B:25:0x0053, B:27:0x0059, B:29:0x0061, B:31:0x0068, B:38:0x008c, B:40:0x0090, B:41:0x0093, B:43:0x0097, B:47:0x00a2, B:49:0x00ac, B:53:0x00ba, B:55:0x00cb, B:58:0x00d3, B:65:0x00e6, B:67:0x00ec, B:68:0x00f4, B:70:0x00f9, B:80:0x0143, B:99:0x0195, B:101:0x019a, B:103:0x019f, B:105:0x01a5, B:109:0x01af, B:116:0x01bf, B:118:0x01c5, B:119:0x01c8, B:122:0x01d9, B:136:0x020f, B:138:0x0215, B:139:0x0218, B:141:0x0221, B:142:0x0229, B:144:0x0238, B:145:0x023b, B:120:0x01cc, B:111:0x01b5, B:121:0x01d6, B:123:0x01e0, B:125:0x01e4, B:127:0x01e9, B:129:0x01f4, B:131:0x0202, B:134:0x020a, B:130:0x01fa, B:81:0x0150, B:82:0x0163, B:84:0x0167, B:86:0x016d, B:90:0x0176, B:89:0x0172, B:91:0x017b, B:93:0x0181, B:97:0x018a, B:96:0x0186, B:98:0x018f, B:71:0x00fc, B:72:0x0104, B:73:0x010e, B:74:0x011a, B:76:0x0128, B:77:0x0131, B:78:0x0136, B:62:0x00dd, B:64:0x00e3, B:54:0x00c8, B:149:0x0244, B:150:0x027d, B:32:0x0078, B:35:0x0081), top: B:159:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00a2 A[Catch: all -> 0x027e, TRY_ENTER, TryCatch #0 {all -> 0x027e, blocks: (B:7:0x000e, B:9:0x0018, B:13:0x0023, B:22:0x004a, B:25:0x0053, B:27:0x0059, B:29:0x0061, B:31:0x0068, B:38:0x008c, B:40:0x0090, B:41:0x0093, B:43:0x0097, B:47:0x00a2, B:49:0x00ac, B:53:0x00ba, B:55:0x00cb, B:58:0x00d3, B:65:0x00e6, B:67:0x00ec, B:68:0x00f4, B:70:0x00f9, B:80:0x0143, B:99:0x0195, B:101:0x019a, B:103:0x019f, B:105:0x01a5, B:109:0x01af, B:116:0x01bf, B:118:0x01c5, B:119:0x01c8, B:122:0x01d9, B:136:0x020f, B:138:0x0215, B:139:0x0218, B:141:0x0221, B:142:0x0229, B:144:0x0238, B:145:0x023b, B:120:0x01cc, B:111:0x01b5, B:121:0x01d6, B:123:0x01e0, B:125:0x01e4, B:127:0x01e9, B:129:0x01f4, B:131:0x0202, B:134:0x020a, B:130:0x01fa, B:81:0x0150, B:82:0x0163, B:84:0x0167, B:86:0x016d, B:90:0x0176, B:89:0x0172, B:91:0x017b, B:93:0x0181, B:97:0x018a, B:96:0x0186, B:98:0x018f, B:71:0x00fc, B:72:0x0104, B:73:0x010e, B:74:0x011a, B:76:0x0128, B:77:0x0131, B:78:0x0136, B:62:0x00dd, B:64:0x00e3, B:54:0x00c8, B:149:0x0244, B:150:0x027d, B:32:0x0078, B:35:0x0081), top: B:159:0x000e }] */
    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void layoutChildren() {
        boolean z;
        View view2;
        View view3;
        int i;
        View view4;
        boolean z2;
        View view5;
        View fillFromLeft;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048604, this) == null) || (z = this.mBlockLayoutRequests)) {
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
                if (z) {
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
                        view3 = getChildAt(i4);
                        view2 = null;
                        i = 0;
                        view4 = null;
                        z2 = this.mDataChanged;
                        if (z2) {
                        }
                        if (this.mItemCount == 0) {
                        }
                    }
                } else if (i3 != 3 && i3 != 4 && i3 != 5) {
                    int i5 = this.mSelectedPosition - this.mFirstPosition;
                    View childAt = (i5 < 0 || i5 >= childCount) ? null : getChildAt(i5);
                    View childAt2 = getChildAt(0);
                    int i6 = this.mNextSelectedPosition >= 0 ? this.mNextSelectedPosition - this.mSelectedPosition : 0;
                    View view6 = childAt;
                    view3 = getChildAt(i5 + i6);
                    view2 = view6;
                    int i7 = i6;
                    view4 = childAt2;
                    i = i7;
                    z2 = this.mDataChanged;
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
                        return;
                    } else if (this.mItemCount == this.mAdapter.getCount()) {
                        setSelectedPositionInt(this.mNextSelectedPosition);
                        int i8 = this.mFirstPosition;
                        AbsHListView.l lVar = this.mRecycler;
                        if (z2) {
                            for (int i9 = 0; i9 < childCount; i9++) {
                                lVar.c(getChildAt(i9), i8 + i9);
                            }
                        } else {
                            lVar.f(childCount, i8);
                        }
                        View focusedChild = getFocusedChild();
                        if (focusedChild != null) {
                            if (z2 && !isDirectChildHeaderOrFooter(focusedChild)) {
                                focusedChild = null;
                                view5 = null;
                                requestFocus();
                            }
                            view5 = findFocus();
                            if (view5 != null) {
                                view5.onStartTemporaryDetach();
                            }
                            requestFocus();
                        } else {
                            focusedChild = null;
                            view5 = null;
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
                                if (view3 != null) {
                                    fillFromLeft = fillFromSelection(view3.getLeft(), i2, right);
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
                                fillFromLeft = moveSelection(view2, view3, i, i2, right);
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
                                    if (view2 != null) {
                                        i2 = view2.getLeft();
                                    }
                                    fillFromLeft = fillSpecific(i10, i2);
                                    break;
                                } else if (this.mFirstPosition < this.mItemCount) {
                                    int i11 = this.mFirstPosition;
                                    if (view4 != null) {
                                        i2 = view4.getLeft();
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
                                if ((fillFromLeft != focusedChild || view5 == null || !view5.requestFocus()) && !fillFromLeft.requestFocus()) {
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
                            if (hasFocus() && view5 != null) {
                                view5.requestFocus();
                            }
                        }
                        if (view5 != null && view5.getWindowToken() != null) {
                            view5.onFinishTemporaryDetach();
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
                        return;
                    } else {
                        throw new IllegalStateException("The content of the adapter has changed but ListView did not receive a notification. Make sure the content of your adapter is not modified from a background thread, but only from the UI thread. [in ListView(" + getId() + StringUtil.ARRAY_ELEMENT_SEPARATOR + getClass() + ") with Adapter(" + this.mAdapter.getClass() + ")]");
                    }
                }
            }
            view2 = null;
            view3 = null;
            i = 0;
            view4 = null;
            z2 = this.mDataChanged;
            if (z2) {
            }
            if (this.mItemCount == 0) {
            }
        } finally {
            if (!z) {
                this.mBlockLayoutRequests = false;
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AdapterView
    public int lookForSelectablePosition(int i, boolean z) {
        InterceptResult invokeCommon;
        int min;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048605, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
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
        return invokeCommon.intValue;
    }

    public int[] measureChild(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, view2)) == null) {
            measureItem(view2);
            return new int[]{view2.getMeasuredWidth(), view2.getMeasuredHeight()};
        }
        return (int[]) invokeL.objValue;
    }

    public final int measureWidthOfChildren(int i, int i2, int i3, int i4, int i5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048607, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)})) == null) {
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
                if (recycleOnMeasure && lVar.q(((AbsHListView.LayoutParams) obtainView.getLayoutParams()).a)) {
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
        return invokeCommon.intValue;
    }

    public final int[] measureWithLargeChildren(int i, int i2, int i3, int i4, int i5, int i6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048608, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)})) == null) {
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
                if (recycleOnMeasure && lVar.q(((AbsHListView.LayoutParams) obtainView.getLayoutParams()).a)) {
                    lVar.c(obtainView, -1);
                }
                i11 = Math.max(i11, obtainView.getMeasuredWidth() + i9);
                i12 = Math.max(i12, obtainView.getMeasuredHeight());
            }
            return new int[]{Math.min(i7 + i11, i4), Math.min(i8 + i12, i5)};
        }
        return (int[]) invokeCommon.objValue;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            super.onFinishInflate();
            int childCount = getChildCount();
            if (childCount > 0) {
                for (int i = 0; i < childCount; i++) {
                    addHeaderView(getChildAt(i));
                }
                removeAllViews();
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public void onFocusChanged(boolean z, int i, Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048610, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), rect}) == null) {
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
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.AdapterView, android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, accessibilityEvent) == null) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(HListView.class.getName());
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.AdapterView, android.view.View
    @TargetApi(14)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, accessibilityNodeInfo) == null) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(HListView.class.getName());
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, motionEvent)) == null) {
            boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
            if (getParent() == null || !this.mGestureDetector.onTouchEvent(motionEvent)) {
                return onInterceptTouchEvent;
            }
            requestDisallowInterceptTouchEvent(true);
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048615, this, i, keyEvent)) == null) ? commonKey(i, 1, keyEvent) : invokeIL.booleanValue;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048616, this, i, i2, keyEvent)) == null) ? commonKey(i, i2, keyEvent) : invokeIIL.booleanValue;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048617, this, i, keyEvent)) == null) ? commonKey(i, 1, keyEvent) : invokeIL.booleanValue;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    @TargetApi(11)
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048618, this, i, i2) == null) {
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
                if (recycleOnMeasure() && this.mRecycler.q(((AbsHListView.LayoutParams) obtainView.getLayoutParams()).a)) {
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
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        View focusedChild;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048619, this, i, i2, i3, i4) == null) {
            if (getChildCount() > 0 && (focusedChild = getFocusedChild()) != null) {
                int indexOfChild = this.mFirstPosition + indexOfChild(focusedChild);
                int left = focusedChild.getLeft() - Math.max(0, focusedChild.getRight() - (i - getPaddingLeft()));
                if (this.mFocusSelector == null) {
                    this.mFocusSelector = new d(this, null);
                }
                d dVar = this.mFocusSelector;
                dVar.a(indexOfChild, left);
                post(dVar);
            }
            super.onSizeChanged(i, i2, i3, i4);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048620, this, motionEvent)) == null) {
            motionEvent.getAction();
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public boolean pageScroll(int i) {
        InterceptResult invokeI;
        int i2;
        boolean z;
        int lookForSelectablePosition;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048621, this, i)) == null) {
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
        return invokeI.booleanValue;
    }

    @ViewDebug.ExportedProperty(category = "list")
    public boolean recycleOnMeasure() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean removeFooterView(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048623, this, view2)) == null) {
            boolean z = false;
            if (this.mFooterViewInfos.size() > 0) {
                ListAdapter listAdapter = this.mAdapter;
                if (listAdapter != null && ((n47) listAdapter).d(view2)) {
                    AbsHListView.c cVar = this.mDataSetObserver;
                    if (cVar != null) {
                        cVar.onChanged();
                    }
                    z = true;
                }
                removeFixedViewInfo(view2, this.mFooterViewInfos);
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public boolean removeHeaderView(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048624, this, view2)) == null) {
            boolean z = false;
            if (this.mHeaderViewInfos.size() > 0) {
                ListAdapter listAdapter = this.mAdapter;
                if (listAdapter != null && ((n47) listAdapter).e(view2)) {
                    AbsHListView.c cVar = this.mDataSetObserver;
                    if (cVar != null) {
                        cVar.onChanged();
                    }
                    z = true;
                }
                removeFixedViewInfo(view2, this.mHeaderViewInfos);
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view2, Rect rect, boolean z) {
        InterceptResult invokeLLZ;
        int i;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048625, this, view2, rect, z)) == null) {
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
                positionSelector(-1, view2);
                this.mSelectedLeft = view2.getTop();
                invalidate();
            }
            return z2;
        }
        return invokeLLZ.booleanValue;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView
    public void resetList() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            clearRecycledState(this.mHeaderViewInfos);
            clearRecycledState(this.mFooterViewInfos);
            super.resetList();
            this.mLayoutMode = 0;
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView
    public void setCacheColorHint(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048629, this, i) == null) {
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
    }

    public void setDivider(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, drawable) == null) {
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
    }

    public void setDividerWidth(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048631, this, i) == null) {
            this.mDividerWidth = i;
            requestLayout();
            invalidate();
        }
    }

    public void setFooterDividersEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048632, this, z) == null) {
            this.mFooterDividersEnabled = z;
            invalidate();
        }
    }

    public void setHeaderDividersEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048633, this, z) == null) {
            this.mHeaderDividersEnabled = z;
            invalidate();
        }
    }

    public void setItemsCanFocus(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048634, this, z) == null) {
            this.mItemsCanFocus = z;
            if (z) {
                return;
            }
            setDescendantFocusability(393216);
        }
    }

    public void setMaxWidth(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048635, this, i) == null) {
            this.mMaxWidth = i;
        }
    }

    public void setOverscrollFooter(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, drawable) == null) {
            this.mOverScrollFooter = drawable;
            invalidate();
        }
    }

    public void setOverscrollHeader(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, drawable) == null) {
            this.mOverScrollHeader = drawable;
            if (getScrollX() < 0) {
                invalidate();
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AdapterView
    public void setSelection(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048638, this, i) == null) {
            setSelectionFromLeft(i, 0);
        }
    }

    public void setSelectionAfterHeaderView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048639, this) == null) {
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
    }

    public void setSelectionFromLeft(int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048640, this, i, i2) == null) || this.mAdapter == null) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048641, this, i) == null) {
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
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView
    public void smoothScrollByOffset(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048642, this, i) == null) {
            super.smoothScrollByOffset(i);
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView
    public void smoothScrollToPosition(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048643, this, i) == null) {
            super.smoothScrollToPosition(i);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.obfuscated_res_0x7f04031c);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.horizonalList.widget.AdapterView
    public ListAdapter getAdapter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.mAdapter : (ListAdapter) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        int lookForSelectablePosition;
        AbsHListView.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, listAdapter) == null) {
            ListAdapter listAdapter2 = this.mAdapter;
            if (listAdapter2 != null && (cVar = this.mDataSetObserver) != null) {
                listAdapter2.unregisterDataSetObserver(cVar);
            }
            resetList();
            this.mRecycler.d();
            if (this.mHeaderViewInfos.size() <= 0 && this.mFooterViewInfos.size() <= 0) {
                this.mAdapter = listAdapter;
            } else {
                this.mAdapter = new n47(this.mHeaderViewInfos, this.mFooterViewInfos, listAdapter);
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
                AbsHListView.c cVar2 = new AbsHListView.c(this);
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
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Drawable drawable;
        Drawable drawable2;
        Drawable drawable3;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mHeaderViewInfos = new ArrayList<>();
        this.mFooterViewInfos = new ArrayList<>();
        boolean z2 = true;
        this.mAreAllItemsSelectable = true;
        int i4 = 0;
        this.mItemsCanFocus = false;
        this.mTempRect = new Rect();
        CharSequence[] charSequenceArr = null;
        this.mArrowScrollFocusResult = new b(null);
        this.mMaxWidth = 0;
        this.mGestureDetector = new GestureDetector(new e(this, null));
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, new int[]{16842930, 16843049, R.attr.obfuscated_res_0x7f040313, R.attr.obfuscated_res_0x7f040315, R.attr.obfuscated_res_0x7f040317, R.attr.obfuscated_res_0x7f04031d, R.attr.obfuscated_res_0x7f04031e, R.attr.obfuscated_res_0x7f04031f}, i, 0);
        int i5 = -1;
        if (obtainStyledAttributes != null) {
            charSequenceArr = obtainStyledAttributes.getTextArray(0);
            drawable = obtainStyledAttributes.getDrawable(1);
            drawable2 = obtainStyledAttributes.getDrawable(7);
            drawable3 = obtainStyledAttributes.getDrawable(6);
            i4 = obtainStyledAttributes.getDimensionPixelSize(2, 0);
            boolean z3 = obtainStyledAttributes.getBoolean(4, true);
            boolean z4 = obtainStyledAttributes.getBoolean(3, true);
            i5 = obtainStyledAttributes.getInteger(5, -1);
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
        if (i4 != 0) {
            setDividerWidth(i4);
        }
        this.mHeaderDividersEnabled = z2;
        this.mFooterDividersEnabled = z;
        this.mMeasureWithChild = i5;
    }

    public void addFooterView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            addFooterView(view2, null, true);
        }
    }

    public void addHeaderView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            addHeaderView(view2, null, true);
        }
    }
}
