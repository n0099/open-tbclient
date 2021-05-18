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
/* loaded from: classes4.dex */
public abstract class AdapterView<T extends Adapter> extends ViewGroup {
    public static final long INVALID_COL_ID = Long.MIN_VALUE;
    public static final int INVALID_POSITION = -1;
    public static final int ITEM_VIEW_TYPE_HEADER_OR_FOOTER = -2;
    public static final int ITEM_VIEW_TYPE_IGNORE = -1;
    public static final boolean LOG_ENABLED = false;
    public static final String LOG_TAG = "AdapterView";
    public static final int SYNC_FIRST_POSITION = 1;
    public static final int SYNC_MAX_DURATION_MILLIS = 100;
    public static final int SYNC_SELECTED_POSITION = 0;
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
    public static class b implements ContextMenu.ContextMenuInfo {

        /* renamed from: a  reason: collision with root package name */
        public View f16784a;

        public b(View view, int i2, long j) {
            this.f16784a = view;
        }
    }

    /* loaded from: classes4.dex */
    public class c extends DataSetObserver {

        /* renamed from: a  reason: collision with root package name */
        public Parcelable f16785a = null;

        public c() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            Parcelable parcelable;
            AdapterView adapterView = AdapterView.this;
            adapterView.mDataChanged = true;
            adapterView.mOldItemCount = adapterView.mItemCount;
            adapterView.mItemCount = adapterView.getAdapter().getCount();
            if (AdapterView.this.getAdapter().hasStableIds() && (parcelable = this.f16785a) != null) {
                AdapterView adapterView2 = AdapterView.this;
                if (adapterView2.mOldItemCount == 0 && adapterView2.mItemCount > 0) {
                    adapterView2.onRestoreInstanceState(parcelable);
                    this.f16785a = null;
                    AdapterView.this.checkFocus();
                    AdapterView.this.requestLayout();
                }
            }
            AdapterView.this.rememberSyncState();
            AdapterView.this.checkFocus();
            AdapterView.this.requestLayout();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            AdapterView adapterView = AdapterView.this;
            adapterView.mDataChanged = true;
            if (adapterView.getAdapter().hasStableIds()) {
                this.f16785a = AdapterView.this.onSaveInstanceState();
            }
            AdapterView adapterView2 = AdapterView.this;
            adapterView2.mOldItemCount = adapterView2.mItemCount;
            adapterView2.mItemCount = 0;
            adapterView2.mSelectedPosition = -1;
            adapterView2.mSelectedColId = Long.MIN_VALUE;
            adapterView2.mNextSelectedPosition = -1;
            adapterView2.mNextSelectedColId = Long.MIN_VALUE;
            adapterView2.mNeedSync = false;
            adapterView2.checkFocus();
            AdapterView.this.requestLayout();
        }
    }

    /* loaded from: classes4.dex */
    public interface d {
        void a(AdapterView<?> adapterView, View view, int i2, long j);
    }

    /* loaded from: classes4.dex */
    public interface e {
        boolean a(AdapterView<?> adapterView, View view, int i2, long j);
    }

    /* loaded from: classes4.dex */
    public interface f {
        void a(AdapterView<?> adapterView, View view, int i2, long j);

        void b(AdapterView<?> adapterView);
    }

    /* loaded from: classes4.dex */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AdapterView adapterView = AdapterView.this;
            if (!adapterView.mDataChanged) {
                adapterView.fireOnSelected();
                AdapterView.this.performAccessibilityActionsOnSelected();
            } else if (adapterView.getAdapter() != null) {
                AdapterView.this.post(this);
            }
        }
    }

    public AdapterView(Context context) {
        super(context);
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
        if (this.mOnItemSelectedListener == null) {
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
        int count;
        T adapter = getAdapter();
        if (adapter == null || (count = adapter.getCount()) <= 0) {
            return false;
        }
        return getFirstVisiblePosition() > 0 || getLastVisiblePosition() < count - 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void performAccessibilityActionsOnSelected() {
        if (this.mAccessibilityManager.isEnabled() && getSelectedItemPosition() >= 0) {
            sendAccessibilityEvent(4);
        }
    }

    @SuppressLint({"WrongCall"})
    private void updateEmptyStatus(boolean z) {
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

    @Override // android.view.ViewGroup
    public void addView(View view) {
        throw new UnsupportedOperationException("addView(View) is not supported in AdapterView");
    }

    @Override // android.view.ViewGroup
    public boolean canAnimate() {
        return super.canAnimate() && this.mItemCount > 0;
    }

    public void checkFocus() {
        T adapter = getAdapter();
        boolean z = false;
        boolean z2 = !(adapter == null || adapter.getCount() == 0) || isInFilterMode();
        super.setFocusableInTouchMode(z2 && this.mDesiredFocusableInTouchModeState);
        super.setFocusable(z2 && this.mDesiredFocusableState);
        if (this.mEmptyView != null) {
            updateEmptyStatus((adapter == null || adapter.isEmpty()) ? true : true);
        }
    }

    public void checkSelectionChanged() {
        if (this.mSelectedPosition == this.mOldSelectedPosition && this.mSelectedColId == this.mOldSelectedColId) {
            return;
        }
        selectionChanged();
        this.mOldSelectedPosition = this.mSelectedPosition;
        this.mOldSelectedColId = this.mSelectedColId;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        View selectedView = getSelectedView();
        return selectedView != null && selectedView.getVisibility() == 0 && selectedView.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0065, code lost:
        return -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int findSyncPosition() {
        int i2 = this.mItemCount;
        if (i2 != 0) {
            long j = this.mSyncColId;
            int i3 = this.mSyncPosition;
            if (j != Long.MIN_VALUE) {
                int i4 = i2 - 1;
                int min = Math.min(i4, Math.max(0, i3));
                long uptimeMillis = SystemClock.uptimeMillis() + 100;
                T adapter = getAdapter();
                if (adapter != null) {
                    int i5 = min;
                    int i6 = i5;
                    loop0: while (true) {
                        boolean z = false;
                        while (SystemClock.uptimeMillis() <= uptimeMillis) {
                            if (adapter.getItemId(min) != j) {
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
                } else {
                    return -1;
                }
            } else {
                return -1;
            }
        } else {
            return -1;
        }
    }

    public abstract T getAdapter();

    @ViewDebug.CapturedViewProperty
    public int getCount() {
        return this.mItemCount;
    }

    public View getEmptyView() {
        return this.mEmptyView;
    }

    public int getFirstVisiblePosition() {
        return this.mFirstPosition;
    }

    public Object getItemAtPosition(int i2) {
        T adapter = getAdapter();
        if (adapter == null || i2 < 0) {
            return null;
        }
        return adapter.getItem(i2);
    }

    public long getItemIdAtPosition(int i2) {
        T adapter = getAdapter();
        if (adapter == null || i2 < 0) {
            return Long.MIN_VALUE;
        }
        return adapter.getItemId(i2);
    }

    public int getLastVisiblePosition() {
        return (this.mFirstPosition + getChildCount()) - 1;
    }

    public final d getOnItemClickListener() {
        return this.mOnItemClickListener;
    }

    public final e getOnItemLongClickListener() {
        return this.mOnItemLongClickListener;
    }

    public final f getOnItemSelectedListener() {
        return this.mOnItemSelectedListener;
    }

    public int getPositionForView(View view) {
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

    public Object getSelectedItem() {
        T adapter = getAdapter();
        int selectedItemPosition = getSelectedItemPosition();
        if (adapter == null || adapter.getCount() <= 0 || selectedItemPosition < 0) {
            return null;
        }
        return adapter.getItem(selectedItemPosition);
    }

    @ViewDebug.CapturedViewProperty
    public long getSelectedItemId() {
        return this.mNextSelectedColId;
    }

    @ViewDebug.CapturedViewProperty
    public int getSelectedItemPosition() {
        return this.mNextSelectedPosition;
    }

    public abstract View getSelectedView();

    /* JADX WARN: Removed duplicated region for block: B:13:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handleDataChanged() {
        boolean z;
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

    public boolean isInFilterMode() {
        return false;
    }

    public int lookForSelectablePosition(int i2, boolean z) {
        return i2;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.mSelectionNotifier);
    }

    @Override // android.view.View
    @TargetApi(14)
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
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

    @Override // android.view.View
    @TargetApi(14)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(AdapterView.class.getName());
        accessibilityNodeInfo.setScrollable(isScrollableForAccessibility());
        View selectedView = getSelectedView();
        if (selectedView != null) {
            accessibilityNodeInfo.setEnabled(selectedView.isEnabled());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        this.mLayoutWidth = getWidth();
    }

    @Override // android.view.ViewGroup
    @TargetApi(14)
    public boolean onRequestSendAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        if (super.onRequestSendAccessibilityEvent(view, accessibilityEvent)) {
            AccessibilityEvent obtain = AccessibilityEvent.obtain();
            onInitializeAccessibilityEvent(obtain);
            view.dispatchPopulateAccessibilityEvent(obtain);
            accessibilityEvent.appendRecord(obtain);
            return true;
        }
        return false;
    }

    public boolean performItemClick(View view, int i2, long j) {
        if (this.mOnItemClickListener != null) {
            playSoundEffect(0);
            if (view != null) {
                view.sendAccessibilityEvent(1);
            }
            this.mOnItemClickListener.a(this, view, i2, j);
            return true;
        }
        return false;
    }

    public void rememberSyncState() {
        if (getChildCount() > 0) {
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
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        throw new UnsupportedOperationException("removeAllViews() is not supported in AdapterView");
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        throw new UnsupportedOperationException("removeView(View) is not supported in AdapterView");
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i2) {
        throw new UnsupportedOperationException("removeViewAt(int) is not supported in AdapterView");
    }

    public void selectionChanged() {
        if (this.mOnItemSelectedListener != null || this.mAccessibilityManager.isEnabled()) {
            if (!this.mInLayout && !this.mBlockLayoutRequests) {
                fireOnSelected();
                performAccessibilityActionsOnSelected();
                return;
            }
            if (this.mSelectionNotifier == null) {
                this.mSelectionNotifier = new g();
            }
            post(this.mSelectionNotifier);
        }
    }

    public abstract void setAdapter(T t);

    @TargetApi(16)
    public void setEmptyView(View view) {
        this.mEmptyView = view;
        T adapter = getAdapter();
        updateEmptyStatus(adapter == null || adapter.isEmpty());
    }

    @Override // android.view.View
    public void setFocusable(boolean z) {
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

    @Override // android.view.View
    public void setFocusableInTouchMode(boolean z) {
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

    public void setNextSelectedPositionInt(int i2) {
        this.mNextSelectedPosition = i2;
        long itemIdAtPosition = getItemIdAtPosition(i2);
        this.mNextSelectedColId = itemIdAtPosition;
        if (this.mNeedSync && this.mSyncMode == 0 && i2 >= 0) {
            this.mSyncPosition = i2;
            this.mSyncColId = itemIdAtPosition;
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        throw new RuntimeException("Don't call setOnClickListener for an AdapterView. You probably want setOnItemClickListener instead");
    }

    public void setOnItemClickListener(d dVar) {
        this.mOnItemClickListener = dVar;
    }

    public void setOnItemLongClickListener(e eVar) {
        if (!isLongClickable()) {
            setLongClickable(true);
        }
        this.mOnItemLongClickListener = eVar;
    }

    public void setOnItemSelectedListener(f fVar) {
        this.mOnItemSelectedListener = fVar;
    }

    public void setSelectedPositionInt(int i2) {
        this.mSelectedPosition = i2;
        this.mSelectedColId = getItemIdAtPosition(i2);
    }

    public abstract void setSelection(int i2);

    @Override // android.view.ViewGroup
    public void addView(View view, int i2) {
        throw new UnsupportedOperationException("addView(View, int) is not supported in AdapterView");
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        throw new UnsupportedOperationException("addView(View, LayoutParams) is not supported in AdapterView");
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        throw new UnsupportedOperationException("addView(View, int, LayoutParams) is not supported in AdapterView");
    }

    public AdapterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
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

    @TargetApi(16)
    public AdapterView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
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
