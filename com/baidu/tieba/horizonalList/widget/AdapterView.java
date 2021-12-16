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
/* loaded from: classes12.dex */
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

    /* loaded from: classes12.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes12.dex */
    public static class b implements ContextMenu.ContextMenuInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        public b(View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view, Integer.valueOf(i2), Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = view;
        }
    }

    /* loaded from: classes12.dex */
    public class c extends DataSetObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Parcelable a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AdapterView f46099b;

        public c(AdapterView adapterView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adapterView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46099b = adapterView;
            this.a = null;
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            Parcelable parcelable;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                AdapterView adapterView = this.f46099b;
                adapterView.mDataChanged = true;
                adapterView.mOldItemCount = adapterView.mItemCount;
                adapterView.mItemCount = adapterView.getAdapter().getCount();
                if (this.f46099b.getAdapter().hasStableIds() && (parcelable = this.a) != null) {
                    AdapterView adapterView2 = this.f46099b;
                    if (adapterView2.mOldItemCount == 0 && adapterView2.mItemCount > 0) {
                        adapterView2.onRestoreInstanceState(parcelable);
                        this.a = null;
                        this.f46099b.checkFocus();
                        this.f46099b.requestLayout();
                    }
                }
                this.f46099b.rememberSyncState();
                this.f46099b.checkFocus();
                this.f46099b.requestLayout();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                AdapterView adapterView = this.f46099b;
                adapterView.mDataChanged = true;
                if (adapterView.getAdapter().hasStableIds()) {
                    this.a = this.f46099b.onSaveInstanceState();
                }
                AdapterView adapterView2 = this.f46099b;
                adapterView2.mOldItemCount = adapterView2.mItemCount;
                adapterView2.mItemCount = 0;
                adapterView2.mSelectedPosition = -1;
                adapterView2.mSelectedColId = Long.MIN_VALUE;
                adapterView2.mNextSelectedPosition = -1;
                adapterView2.mNextSelectedColId = Long.MIN_VALUE;
                adapterView2.mNeedSync = false;
                adapterView2.checkFocus();
                this.f46099b.requestLayout();
            }
        }
    }

    /* loaded from: classes12.dex */
    public interface d {
        void a(AdapterView<?> adapterView, View view, int i2, long j2);
    }

    /* loaded from: classes12.dex */
    public interface e {
        boolean a(AdapterView<?> adapterView, View view, int i2, long j2);
    }

    /* loaded from: classes12.dex */
    public interface f {
        void a(AdapterView<?> adapterView, View view, int i2, long j2);

        void b(AdapterView<?> adapterView);
    }

    /* loaded from: classes12.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdapterView f46100e;

        public g(AdapterView adapterView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adapterView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46100e = adapterView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                AdapterView adapterView = this.f46100e;
                if (!adapterView.mDataChanged) {
                    adapterView.fireOnSelected();
                    this.f46100e.performAccessibilityActionsOnSelected();
                } else if (adapterView.getAdapter() != null) {
                    this.f46100e.post(this);
                }
            }
        }

        public /* synthetic */ g(AdapterView adapterView, a aVar) {
            this(adapterView);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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

    /* JADX INFO: Access modifiers changed from: private */
    public void fireOnSelected() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65543, this) == null) || this.mOnItemSelectedListener == null) {
            return;
        }
        int selectedItemPosition = getSelectedItemPosition();
        if (selectedItemPosition >= 0) {
            this.mOnItemSelectedListener.a(this, getSelectedView(), selectedItemPosition, getAdapter().getItemId(selectedItemPosition));
            return;
        }
        this.mOnItemSelectedListener.b(this);
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
            return getFirstVisiblePosition() > 0 || getLastVisiblePosition() < count - 1;
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

    @SuppressLint({"WrongCall"})
    private void updateEmptyStatus(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65546, this, z) == null) {
            if (isInFilterMode()) {
                z = false;
            }
            if (z) {
                View view = this.mEmptyView;
                if (view != null) {
                    view.setVisibility(0);
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
            View view2 = this.mEmptyView;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            setVisibility(0);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            throw new UnsupportedOperationException("addView(View) is not supported in AdapterView");
        }
    }

    @Override // android.view.ViewGroup
    public boolean canAnimate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? super.canAnimate() && this.mItemCount > 0 : invokeV.booleanValue;
    }

    public void checkFocus() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            T adapter = getAdapter();
            boolean z = false;
            boolean z2 = !(adapter == null || adapter.getCount() == 0) || isInFilterMode();
            super.setFocusableInTouchMode(z2 && this.mDesiredFocusableInTouchModeState);
            super.setFocusable(z2 && this.mDesiredFocusableState);
            if (this.mEmptyView != null) {
                updateEmptyStatus((adapter == null || adapter.isEmpty()) ? true : true);
            }
        }
    }

    public void checkSelectionChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.mSelectedPosition == this.mOldSelectedPosition && this.mSelectedColId == this.mOldSelectedColId) {
                return;
            }
            selectionChanged();
            this.mOldSelectedPosition = this.mSelectedPosition;
            this.mOldSelectedColId = this.mSelectedColId;
        }
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, accessibilityEvent)) == null) {
            View selectedView = getSelectedView();
            return selectedView != null && selectedView.getVisibility() == 0 && selectedView.dispatchPopulateAccessibilityEvent(accessibilityEvent);
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

    public int findSyncPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            int i2 = this.mItemCount;
            if (i2 == 0) {
                return -1;
            }
            long j2 = this.mSyncColId;
            int i3 = this.mSyncPosition;
            if (j2 == Long.MIN_VALUE) {
                return -1;
            }
            int i4 = i2 - 1;
            int min = Math.min(i4, Math.max(0, i3));
            long uptimeMillis = SystemClock.uptimeMillis() + 100;
            T adapter = getAdapter();
            if (adapter == null) {
                return -1;
            }
            int i5 = min;
            int i6 = i5;
            loop0: while (true) {
                boolean z = false;
                while (SystemClock.uptimeMillis() <= uptimeMillis) {
                    if (adapter.getItemId(min) != j2) {
                        boolean z2 = i5 == i4;
                        boolean z3 = i6 == 0;
                        if (z2 && z3) {
                            break loop0;
                        } else if (z3 || (z && !z2)) {
                            i5++;
                            min = i5;
                        } else if (z2 || (!z && !z3)) {
                            i6--;
                            min = i6;
                            z = true;
                        }
                    } else {
                        return min;
                    }
                }
                break loop0;
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public abstract T getAdapter();

    @ViewDebug.CapturedViewProperty
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mItemCount : invokeV.intValue;
    }

    public View getEmptyView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mEmptyView : (View) invokeV.objValue;
    }

    public int getFirstVisiblePosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mFirstPosition : invokeV.intValue;
    }

    public Object getItemAtPosition(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) {
            T adapter = getAdapter();
            if (adapter == null || i2 < 0) {
                return null;
            }
            return adapter.getItem(i2);
        }
        return invokeI.objValue;
    }

    public long getItemIdAtPosition(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) {
            T adapter = getAdapter();
            if (adapter == null || i2 < 0) {
                return Long.MIN_VALUE;
            }
            return adapter.getItemId(i2);
        }
        return invokeI.longValue;
    }

    public int getLastVisiblePosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? (this.mFirstPosition + getChildCount()) - 1 : invokeV.intValue;
    }

    public final d getOnItemClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.mOnItemClickListener : (d) invokeV.objValue;
    }

    public final e getOnItemLongClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.mOnItemLongClickListener : (e) invokeV.objValue;
    }

    public final f getOnItemSelectedListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.mOnItemSelectedListener : (f) invokeV.objValue;
    }

    public int getPositionForView(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, view)) == null) {
            while (true) {
                try {
                    View view2 = (View) view.getParent();
                    if (view2.equals(this)) {
                        break;
                    }
                    view = view2;
                } catch (ClassCastException unused) {
                }
            }
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (getChildAt(i2).equals(view)) {
                    return this.mFirstPosition + i2;
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public Object getSelectedItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            T adapter = getAdapter();
            int selectedItemPosition = getSelectedItemPosition();
            if (adapter == null || adapter.getCount() <= 0 || selectedItemPosition < 0) {
                return null;
            }
            return adapter.getItem(selectedItemPosition);
        }
        return invokeV.objValue;
    }

    @ViewDebug.CapturedViewProperty
    public long getSelectedItemId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.mNextSelectedColId : invokeV.longValue;
    }

    @ViewDebug.CapturedViewProperty
    public int getSelectedItemPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.mNextSelectedPosition : invokeV.intValue;
    }

    public abstract View getSelectedView();

    /* JADX WARN: Removed duplicated region for block: B:15:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handleDataChanged() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            int i2 = this.mItemCount;
            boolean z2 = true;
            if (i2 > 0) {
                if (this.mNeedSync) {
                    this.mNeedSync = false;
                    int findSyncPosition = findSyncPosition();
                    if (findSyncPosition >= 0 && lookForSelectablePosition(findSyncPosition, true) == findSyncPosition) {
                        setNextSelectedPositionInt(findSyncPosition);
                        z = true;
                        if (!z) {
                            int selectedItemPosition = getSelectedItemPosition();
                            if (selectedItemPosition >= i2) {
                                selectedItemPosition = i2 - 1;
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
            if (z2) {
                return;
            }
            this.mSelectedPosition = -1;
            this.mSelectedColId = Long.MIN_VALUE;
            this.mNextSelectedPosition = -1;
            this.mNextSelectedColId = Long.MIN_VALUE;
            this.mNeedSync = false;
            checkSelectionChanged();
        }
    }

    public boolean isInFilterMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public int lookForSelectablePosition(int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048604, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) ? i2 : invokeCommon.intValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            super.onDetachedFromWindow();
            removeCallbacks(this.mSelectionNotifier);
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

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048608, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            this.mLayoutWidth = getWidth();
        }
    }

    @Override // android.view.ViewGroup
    @TargetApi(14)
    public boolean onRequestSendAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048609, this, view, accessibilityEvent)) == null) {
            if (super.onRequestSendAccessibilityEvent(view, accessibilityEvent)) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain();
                onInitializeAccessibilityEvent(obtain);
                view.dispatchPopulateAccessibilityEvent(obtain);
                accessibilityEvent.appendRecord(obtain);
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public boolean performItemClick(View view, int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048610, this, new Object[]{view, Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
            if (this.mOnItemClickListener != null) {
                playSoundEffect(0);
                if (view != null) {
                    view.sendAccessibilityEvent(1);
                }
                this.mOnItemClickListener.a(this, view, i2, j2);
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public void rememberSyncState() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048611, this) == null) || getChildCount() <= 0) {
            return;
        }
        this.mNeedSync = true;
        this.mSyncWidth = this.mLayoutWidth;
        int i2 = this.mSelectedPosition;
        if (i2 >= 0) {
            View childAt = getChildAt(i2 - this.mFirstPosition);
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
        int i3 = this.mFirstPosition;
        if (i3 >= 0 && i3 < adapter.getCount()) {
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

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            throw new UnsupportedOperationException("removeAllViews() is not supported in AdapterView");
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, view) == null) {
            throw new UnsupportedOperationException("removeView(View) is not supported in AdapterView");
        }
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i2) == null) {
            throw new UnsupportedOperationException("removeViewAt(int) is not supported in AdapterView");
        }
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

    public abstract void setAdapter(T t);

    @TargetApi(16)
    public void setEmptyView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, view) == null) {
            this.mEmptyView = view;
            T adapter = getAdapter();
            updateEmptyStatus(adapter == null || adapter.isEmpty());
        }
    }

    @Override // android.view.View
    public void setFocusable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048618, this, z) == null) {
            T adapter = getAdapter();
            boolean z2 = true;
            boolean z3 = adapter == null || adapter.getCount() == 0;
            this.mDesiredFocusableState = z;
            if (!z) {
                this.mDesiredFocusableInTouchModeState = false;
            }
            if (!z || (z3 && !isInFilterMode())) {
                z2 = false;
            }
            super.setFocusable(z2);
        }
    }

    @Override // android.view.View
    public void setFocusableInTouchMode(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048619, this, z) == null) {
            T adapter = getAdapter();
            boolean z2 = false;
            boolean z3 = adapter == null || adapter.getCount() == 0;
            this.mDesiredFocusableInTouchModeState = z;
            if (z) {
                this.mDesiredFocusableState = true;
            }
            if (z && (!z3 || isInFilterMode())) {
                z2 = true;
            }
            super.setFocusableInTouchMode(z2);
        }
    }

    public void setNextSelectedPositionInt(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048620, this, i2) == null) {
            this.mNextSelectedPosition = i2;
            long itemIdAtPosition = getItemIdAtPosition(i2);
            this.mNextSelectedColId = itemIdAtPosition;
            if (this.mNeedSync && this.mSyncMode == 0 && i2 >= 0) {
                this.mSyncPosition = i2;
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

    public void setSelectedPositionInt(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048625, this, i2) == null) {
            this.mSelectedPosition = i2;
            this.mSelectedColId = getItemIdAtPosition(i2);
        }
    }

    public abstract void setSelection(int i2);

    @Override // android.view.ViewGroup
    public void addView(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, i2) == null) {
            throw new UnsupportedOperationException("addView(View, int) is not supported in AdapterView");
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, view, layoutParams) == null) {
            throw new UnsupportedOperationException("addView(View, LayoutParams) is not supported in AdapterView");
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, view, i2, layoutParams) == null) {
            throw new UnsupportedOperationException("addView(View, int, LayoutParams) is not supported in AdapterView");
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
    public AdapterView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
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
        if (isInEditMode()) {
            return;
        }
        this.mAccessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
    }
}
