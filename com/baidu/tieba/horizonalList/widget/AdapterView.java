package com.baidu.tieba.horizonalList.widget;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Adapter;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public abstract class AdapterView<T extends Adapter> extends ViewGroup {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long INVALID_COL_ID = Long.MIN_VALUE;
    public static final int INVALID_POSITION = -1;
    public static final int ITEM_VIEW_TYPE_HEADER_OR_FOOTER = -2;
    public static final int ITEM_VIEW_TYPE_IGNORE = -1;
    public static final boolean LOG_ENABLED = false;
    public static final String LOG_TAG = "AdapterView";
    public static final int SYNC_FIRST_POSITION = 1;
    public static final int SYNC_MAX_DURATION_MILLIS = 100;
    public static final int SYNC_SELECTED_POSITION = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public AccessibilityManager mAccessibilityManager;
    public boolean mBlockLayoutRequests;
    public boolean mDataChanged;
    public boolean mDesiredFocusableInTouchModeState;
    public boolean mDesiredFocusableState;
    public View mEmptyView;
    @ViewDebug.ExportedProperty(category = "scrolling")
    public int mFirstPosition;
    public boolean mInLayout;
    @ViewDebug.ExportedProperty(category = "list")
    public int mItemCount;
    public int mLayoutWidth;
    public boolean mNeedSync;
    public long mNextSelectedColId;
    @ViewDebug.ExportedProperty(category = "list")
    public int mNextSelectedPosition;
    public int mOldItemCount;
    public long mOldSelectedColId;
    public int mOldSelectedPosition;
    public d mOnItemClickListener;
    public e mOnItemLongClickListener;
    public f mOnItemSelectedListener;
    public long mSelectedColId;
    @ViewDebug.ExportedProperty(category = "list")
    public int mSelectedPosition;
    public AdapterView<T>.g mSelectionNotifier;
    public int mSpecificLeft;
    public long mSyncColId;
    public int mSyncMode;
    public int mSyncPosition;
    public long mSyncWidth;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public interface d {
        void a(AdapterView<?> adapterView, View view2, int i, long j);
    }

    /* loaded from: classes4.dex */
    public interface e {
        boolean a(AdapterView<?> adapterView, View view2, int i, long j);
    }

    /* loaded from: classes4.dex */
    public interface f {
        void a(AdapterView<?> adapterView, View view2, int i, long j);

        void b(AdapterView<?> adapterView);
    }

    public abstract T getAdapter();

    public abstract View getSelectedView();

    public boolean isInFilterMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public int lookForSelectablePosition(int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048604, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)})) == null) ? i : invokeCommon.intValue;
    }

    public abstract void setAdapter(T t);

    public abstract void setSelection(int i);

    /* loaded from: classes4.dex */
    public static class b implements ContextMenu.ContextMenuInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        public b(View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2, Integer.valueOf(i), Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = view2;
        }
    }

    /* loaded from: classes4.dex */
    public class c extends DataSetObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Parcelable a;
        public final /* synthetic */ AdapterView b;

        public c(AdapterView adapterView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adapterView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = adapterView;
            this.a = null;
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            Parcelable parcelable;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                AdapterView adapterView = this.b;
                adapterView.mDataChanged = true;
                adapterView.mOldItemCount = adapterView.mItemCount;
                adapterView.mItemCount = adapterView.getAdapter().getCount();
                if (this.b.getAdapter().hasStableIds() && (parcelable = this.a) != null) {
                    AdapterView adapterView2 = this.b;
                    if (adapterView2.mOldItemCount == 0 && adapterView2.mItemCount > 0) {
                        adapterView2.onRestoreInstanceState(parcelable);
                        this.a = null;
                        this.b.checkFocus();
                        this.b.requestLayout();
                    }
                }
                this.b.rememberSyncState();
                this.b.checkFocus();
                this.b.requestLayout();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                AdapterView adapterView = this.b;
                adapterView.mDataChanged = true;
                if (adapterView.getAdapter().hasStableIds()) {
                    this.a = this.b.onSaveInstanceState();
                }
                AdapterView adapterView2 = this.b;
                adapterView2.mOldItemCount = adapterView2.mItemCount;
                adapterView2.mItemCount = 0;
                adapterView2.mSelectedPosition = -1;
                adapterView2.mSelectedColId = Long.MIN_VALUE;
                adapterView2.mNextSelectedPosition = -1;
                adapterView2.mNextSelectedColId = Long.MIN_VALUE;
                adapterView2.mNeedSync = false;
                adapterView2.checkFocus();
                this.b.requestLayout();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdapterView a;

        public g(AdapterView adapterView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adapterView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = adapterView;
        }

        public /* synthetic */ g(AdapterView adapterView, a aVar) {
            this(adapterView);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                AdapterView adapterView = this.a;
                if (adapterView.mDataChanged) {
                    if (adapterView.getAdapter() != null) {
                        this.a.post(this);
                        return;
                    }
                    return;
                }
                adapterView.fireOnSelected();
                this.a.performAccessibilityActionsOnSelected();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdapterView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mFirstPosition = 0;
        this.mSyncColId = Long.MIN_VALUE;
        this.mNeedSync = false;
        this.mInLayout = false;
        this.mNextSelectedPosition = -1;
        this.mNextSelectedColId = Long.MIN_VALUE;
        this.mSelectedPosition = -1;
        this.mSelectedColId = Long.MIN_VALUE;
        this.mOldSelectedPosition = -1;
        this.mOldSelectedColId = Long.MIN_VALUE;
        this.mBlockLayoutRequests = false;
    }

    @SuppressLint({"WrongCall"})
    private void updateEmptyStatus(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65546, this, z) == null) {
            if (isInFilterMode()) {
                z = false;
            }
            if (z) {
                View view2 = this.mEmptyView;
                if (view2 != null) {
                    view2.setVisibility(0);
                    setVisibility(8);
                } else {
                    setVisibility(0);
                }
                if (this.mDataChanged) {
                    onLayout(false, getLeft(), getTop(), getRight(), getBottom());
                    return;
                }
                return;
            }
            View view3 = this.mEmptyView;
            if (view3 != null) {
                view3.setVisibility(8);
            }
            setVisibility(0);
        }
    }

    @Override // android.view.View
    @TargetApi(14)
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, accessibilityEvent) == null) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(AdapterView.class.getName());
            accessibilityEvent.setScrollable(isScrollableForAccessibility());
            View selectedView = getSelectedView();
            if (selectedView != null) {
                accessibilityEvent.setEnabled(selectedView.isEnabled());
            }
            accessibilityEvent.setCurrentItemIndex(getSelectedItemPosition());
            accessibilityEvent.setFromIndex(getFirstVisiblePosition());
            accessibilityEvent.setToIndex(getLastVisiblePosition());
            accessibilityEvent.setItemCount(getCount());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdapterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mFirstPosition = 0;
        this.mSyncColId = Long.MIN_VALUE;
        this.mNeedSync = false;
        this.mInLayout = false;
        this.mNextSelectedPosition = -1;
        this.mNextSelectedColId = Long.MIN_VALUE;
        this.mSelectedPosition = -1;
        this.mSelectedColId = Long.MIN_VALUE;
        this.mOldSelectedPosition = -1;
        this.mOldSelectedColId = Long.MIN_VALUE;
        this.mBlockLayoutRequests = false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @TargetApi(16)
    public AdapterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
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
        this.mFirstPosition = 0;
        this.mSyncColId = Long.MIN_VALUE;
        this.mNeedSync = false;
        this.mInLayout = false;
        this.mNextSelectedPosition = -1;
        this.mNextSelectedColId = Long.MIN_VALUE;
        this.mSelectedPosition = -1;
        this.mSelectedColId = Long.MIN_VALUE;
        this.mOldSelectedPosition = -1;
        this.mOldSelectedColId = Long.MIN_VALUE;
        this.mBlockLayoutRequests = false;
        if (!isInEditMode()) {
            this.mAccessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, i) == null) {
            throw new UnsupportedOperationException("addView(View, int) is not supported in AdapterView");
        }
    }

    @Override // android.view.ViewGroup
    @TargetApi(14)
    public boolean onRequestSendAccessibilityEvent(View view2, AccessibilityEvent accessibilityEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048609, this, view2, accessibilityEvent)) == null) {
            if (super.onRequestSendAccessibilityEvent(view2, accessibilityEvent)) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain();
                onInitializeAccessibilityEvent(obtain);
                view2.dispatchPopulateAccessibilityEvent(obtain);
                accessibilityEvent.appendRecord(obtain);
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // android.view.ViewGroup
    public void addView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            throw new UnsupportedOperationException("addView(View) is not supported in AdapterView");
        }
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, accessibilityEvent)) == null) {
            View selectedView = getSelectedView();
            if (selectedView != null && selectedView.getVisibility() == 0 && selectedView.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sparseArray) == null) {
            dispatchThawSelfOnly(sparseArray);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, sparseArray) == null) {
            dispatchFreezeSelfOnly(sparseArray);
        }
    }

    public Object getItemAtPosition(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i)) == null) {
            T adapter = getAdapter();
            if (adapter != null && i >= 0) {
                return adapter.getItem(i);
            }
            return null;
        }
        return invokeI.objValue;
    }

    public long getItemIdAtPosition(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i)) == null) {
            T adapter = getAdapter();
            if (adapter != null && i >= 0) {
                return adapter.getItemId(i);
            }
            return Long.MIN_VALUE;
        }
        return invokeI.longValue;
    }

    @Override // android.view.View
    @TargetApi(14)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, accessibilityNodeInfo) == null) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(AdapterView.class.getName());
            accessibilityNodeInfo.setScrollable(isScrollableForAccessibility());
            View selectedView = getSelectedView();
            if (selectedView != null) {
                accessibilityNodeInfo.setEnabled(selectedView.isEnabled());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, view2) == null) {
            throw new UnsupportedOperationException("removeView(View) is not supported in AdapterView");
        }
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i) == null) {
            throw new UnsupportedOperationException("removeViewAt(int) is not supported in AdapterView");
        }
    }

    @TargetApi(16)
    public void setEmptyView(View view2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, view2) == null) {
            this.mEmptyView = view2;
            T adapter = getAdapter();
            if (adapter != null && !adapter.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            updateEmptyStatus(z);
        }
    }

    public void setNextSelectedPositionInt(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048620, this, i) == null) {
            this.mNextSelectedPosition = i;
            long itemIdAtPosition = getItemIdAtPosition(i);
            this.mNextSelectedColId = itemIdAtPosition;
            if (this.mNeedSync && this.mSyncMode == 0 && i >= 0) {
                this.mSyncPosition = i;
                this.mSyncColId = itemIdAtPosition;
            }
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, onClickListener) == null) {
            throw new RuntimeException("Don't call setOnClickListener for an AdapterView. You probably want setOnItemClickListener instead");
        }
    }

    public void setOnItemClickListener(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, dVar) == null) {
            this.mOnItemClickListener = dVar;
        }
    }

    public void setOnItemLongClickListener(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, eVar) == null) {
            if (!isLongClickable()) {
                setLongClickable(true);
            }
            this.mOnItemLongClickListener = eVar;
        }
    }

    public void setOnItemSelectedListener(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, fVar) == null) {
            this.mOnItemSelectedListener = fVar;
        }
    }

    public void setSelectedPositionInt(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048625, this, i) == null) {
            this.mSelectedPosition = i;
            this.mSelectedColId = getItemIdAtPosition(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fireOnSelected() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65543, this) != null) || this.mOnItemSelectedListener == null) {
            return;
        }
        int selectedItemPosition = getSelectedItemPosition();
        if (selectedItemPosition >= 0) {
            this.mOnItemSelectedListener.a(this, getSelectedView(), selectedItemPosition, getAdapter().getItemId(selectedItemPosition));
            return;
        }
        this.mOnItemSelectedListener.b(this);
    }

    public void selectionChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            if (this.mOnItemSelectedListener != null || this.mAccessibilityManager.isEnabled()) {
                if (!this.mInLayout && !this.mBlockLayoutRequests) {
                    fireOnSelected();
                    performAccessibilityActionsOnSelected();
                    return;
                }
                if (this.mSelectionNotifier == null) {
                    this.mSelectionNotifier = new g(this, null);
                }
                post(this.mSelectionNotifier);
            }
        }
    }

    private boolean isScrollableForAccessibility() {
        InterceptResult invokeV;
        int count;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            T adapter = getAdapter();
            if (adapter == null || (count = adapter.getCount()) <= 0) {
                return false;
            }
            if (getFirstVisiblePosition() <= 0 && getLastVisiblePosition() >= count - 1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void performAccessibilityActionsOnSelected() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65545, this) == null) && this.mAccessibilityManager.isEnabled() && getSelectedItemPosition() >= 0) {
            sendAccessibilityEvent(4);
        }
    }

    @Override // android.view.ViewGroup
    public boolean canAnimate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (super.canAnimate() && this.mItemCount > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void checkSelectionChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.mSelectedPosition != this.mOldSelectedPosition || this.mSelectedColId != this.mOldSelectedColId) {
                selectionChanged();
                this.mOldSelectedPosition = this.mSelectedPosition;
                this.mOldSelectedColId = this.mSelectedColId;
            }
        }
    }

    @ViewDebug.CapturedViewProperty
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.mItemCount;
        }
        return invokeV.intValue;
    }

    public View getEmptyView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.mEmptyView;
        }
        return (View) invokeV.objValue;
    }

    public int getFirstVisiblePosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.mFirstPosition;
        }
        return invokeV.intValue;
    }

    public int getLastVisiblePosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return (this.mFirstPosition + getChildCount()) - 1;
        }
        return invokeV.intValue;
    }

    public final d getOnItemClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.mOnItemClickListener;
        }
        return (d) invokeV.objValue;
    }

    public final e getOnItemLongClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.mOnItemLongClickListener;
        }
        return (e) invokeV.objValue;
    }

    public final f getOnItemSelectedListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.mOnItemSelectedListener;
        }
        return (f) invokeV.objValue;
    }

    public Object getSelectedItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            T adapter = getAdapter();
            int selectedItemPosition = getSelectedItemPosition();
            if (adapter != null && adapter.getCount() > 0 && selectedItemPosition >= 0) {
                return adapter.getItem(selectedItemPosition);
            }
            return null;
        }
        return invokeV.objValue;
    }

    @ViewDebug.CapturedViewProperty
    public long getSelectedItemId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.mNextSelectedColId;
        }
        return invokeV.longValue;
    }

    @ViewDebug.CapturedViewProperty
    public int getSelectedItemPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.mNextSelectedPosition;
        }
        return invokeV.intValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            super.onDetachedFromWindow();
            removeCallbacks(this.mSelectionNotifier);
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            throw new UnsupportedOperationException("removeAllViews() is not supported in AdapterView");
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view2, int i, ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, view2, i, layoutParams) == null) {
            throw new UnsupportedOperationException("addView(View, int, LayoutParams) is not supported in AdapterView");
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view2, ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, view2, layoutParams) == null) {
            throw new UnsupportedOperationException("addView(View, LayoutParams) is not supported in AdapterView");
        }
    }

    public void checkFocus() {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            T adapter = getAdapter();
            boolean z5 = false;
            if (adapter != null && adapter.getCount() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (z && !isInFilterMode()) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2 && this.mDesiredFocusableInTouchModeState) {
                z3 = true;
            } else {
                z3 = false;
            }
            super.setFocusableInTouchMode(z3);
            if (z2 && this.mDesiredFocusableState) {
                z4 = true;
            } else {
                z4 = false;
            }
            super.setFocusable(z4);
            if (this.mEmptyView != null) {
                updateEmptyStatus((adapter == null || adapter.isEmpty()) ? true : true);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handleDataChanged() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            int i = this.mItemCount;
            boolean z2 = true;
            if (i > 0) {
                if (this.mNeedSync) {
                    this.mNeedSync = false;
                    int findSyncPosition = findSyncPosition();
                    if (findSyncPosition >= 0 && lookForSelectablePosition(findSyncPosition, true) == findSyncPosition) {
                        setNextSelectedPositionInt(findSyncPosition);
                        z = true;
                        if (!z) {
                            int selectedItemPosition = getSelectedItemPosition();
                            if (selectedItemPosition >= i) {
                                selectedItemPosition = i - 1;
                            }
                            if (selectedItemPosition < 0) {
                                selectedItemPosition = 0;
                            }
                            int lookForSelectablePosition = lookForSelectablePosition(selectedItemPosition, true);
                            if (lookForSelectablePosition < 0) {
                                lookForSelectablePosition = lookForSelectablePosition(selectedItemPosition, false);
                            }
                            if (lookForSelectablePosition >= 0) {
                                setNextSelectedPositionInt(lookForSelectablePosition);
                                checkSelectionChanged();
                            }
                        }
                        z2 = z;
                    }
                }
                z = false;
                if (!z) {
                }
                z2 = z;
            } else {
                z2 = false;
            }
            if (!z2) {
                this.mSelectedPosition = -1;
                this.mSelectedColId = Long.MIN_VALUE;
                this.mNextSelectedPosition = -1;
                this.mNextSelectedColId = Long.MIN_VALUE;
                this.mNeedSync = false;
                checkSelectionChanged();
            }
        }
    }

    public int findSyncPosition() {
        InterceptResult invokeV;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            int i = this.mItemCount;
            if (i == 0) {
                return -1;
            }
            long j = this.mSyncColId;
            int i2 = this.mSyncPosition;
            if (j == Long.MIN_VALUE) {
                return -1;
            }
            int i3 = i - 1;
            int min = Math.min(i3, Math.max(0, i2));
            long uptimeMillis = SystemClock.uptimeMillis() + 100;
            T adapter = getAdapter();
            if (adapter == null) {
                return -1;
            }
            int i4 = min;
            int i5 = i4;
            loop0: while (true) {
                boolean z3 = false;
                while (SystemClock.uptimeMillis() <= uptimeMillis) {
                    if (adapter.getItemId(min) == j) {
                        return min;
                    }
                    if (i4 == i3) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (i5 == 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z && z2) {
                        break loop0;
                    } else if (!z2 && (!z3 || z)) {
                        if (z || (!z3 && !z2)) {
                            i5--;
                            min = i5;
                            z3 = true;
                        }
                    } else {
                        i4++;
                        min = i4;
                    }
                }
                break loop0;
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public void rememberSyncState() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048611, this) == null) && getChildCount() > 0) {
            this.mNeedSync = true;
            this.mSyncWidth = this.mLayoutWidth;
            int i = this.mSelectedPosition;
            if (i >= 0) {
                View childAt = getChildAt(i - this.mFirstPosition);
                this.mSyncColId = this.mNextSelectedColId;
                this.mSyncPosition = this.mNextSelectedPosition;
                if (childAt != null) {
                    this.mSpecificLeft = childAt.getLeft();
                }
                this.mSyncMode = 0;
                return;
            }
            View childAt2 = getChildAt(0);
            T adapter = getAdapter();
            int i2 = this.mFirstPosition;
            if (i2 >= 0 && i2 < adapter.getCount()) {
                this.mSyncColId = adapter.getItemId(this.mFirstPosition);
            } else {
                this.mSyncColId = -1L;
            }
            this.mSyncPosition = this.mFirstPosition;
            if (childAt2 != null) {
                this.mSpecificLeft = childAt2.getLeft();
            }
            this.mSyncMode = 1;
        }
    }

    public int getPositionForView(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, view2)) == null) {
            while (true) {
                try {
                    View view3 = (View) view2.getParent();
                    if (view3.equals(this)) {
                        break;
                    }
                    view2 = view3;
                } catch (ClassCastException unused) {
                }
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (getChildAt(i).equals(view2)) {
                    return this.mFirstPosition + i;
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    @Override // android.view.View
    public void setFocusable(boolean z) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048618, this, z) == null) {
            T adapter = getAdapter();
            boolean z3 = true;
            if (adapter != null && adapter.getCount() != 0) {
                z2 = false;
            } else {
                z2 = true;
            }
            this.mDesiredFocusableState = z;
            if (!z) {
                this.mDesiredFocusableInTouchModeState = false;
            }
            if (!z || (z2 && !isInFilterMode())) {
                z3 = false;
            }
            super.setFocusable(z3);
        }
    }

    @Override // android.view.View
    public void setFocusableInTouchMode(boolean z) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048619, this, z) == null) {
            T adapter = getAdapter();
            boolean z3 = false;
            if (adapter != null && adapter.getCount() != 0) {
                z2 = false;
            } else {
                z2 = true;
            }
            this.mDesiredFocusableInTouchModeState = z;
            if (z) {
                this.mDesiredFocusableState = true;
            }
            if (z && (!z2 || isInFilterMode())) {
                z3 = true;
            }
            super.setFocusableInTouchMode(z3);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048608, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            this.mLayoutWidth = getWidth();
        }
    }

    public boolean performItemClick(View view2, int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048610, this, new Object[]{view2, Integer.valueOf(i), Long.valueOf(j)})) == null) {
            if (this.mOnItemClickListener == null) {
                return false;
            }
            playSoundEffect(0);
            if (view2 != null) {
                view2.sendAccessibilityEvent(1);
            }
            this.mOnItemClickListener.a(this, view2, i, j);
            return true;
        }
        return invokeCommon.booleanValue;
    }
}
