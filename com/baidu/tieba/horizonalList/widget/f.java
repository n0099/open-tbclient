package com.baidu.tieba.horizonalList.widget;

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
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public abstract class f<T extends Adapter> extends ViewGroup {
    protected int cFd;
    protected long cFe;
    protected long cFf;
    e cFg;
    c cFh;
    d cFi;
    @ViewDebug.ExportedProperty(category = IntentConfig.LIST)
    protected int cFj;
    protected long cFk;
    protected long cFl;
    AccessibilityManager cFm;
    protected long cFn;
    private boolean cFo;
    private boolean cFp;
    private f<T>.RunnableC0064f cFq;
    protected boolean mBlockLayoutRequests;
    public boolean mDataChanged;
    private View mEmptyView;
    @ViewDebug.ExportedProperty(category = "scrolling")
    protected int mFirstPosition;
    protected boolean mInLayout;
    @ViewDebug.ExportedProperty(category = IntentConfig.LIST)
    protected int mItemCount;
    private int mLayoutWidth;
    protected boolean mNeedSync;
    protected int mOldItemCount;
    protected int mOldSelectedPosition;
    @ViewDebug.ExportedProperty(category = IntentConfig.LIST)
    protected int mSelectedPosition;
    int mSyncMode;
    protected int mSyncPosition;

    /* loaded from: classes.dex */
    public interface c {
        void a(f<?> fVar, View view, int i, long j);
    }

    /* loaded from: classes.dex */
    public interface d {
        boolean b(f<?> fVar, View view, int i, long j);
    }

    /* loaded from: classes.dex */
    public interface e {
        void c(f<?> fVar, View view, int i, long j);

        void d(f<?> fVar);
    }

    public abstract T getAdapter();

    public abstract View getSelectedView();

    public abstract void setAdapter(T t);

    public abstract void setSelection(int i);

    public f(Context context) {
        super(context);
        this.mFirstPosition = 0;
        this.cFe = Long.MIN_VALUE;
        this.mNeedSync = false;
        this.mInLayout = false;
        this.cFj = -1;
        this.cFk = Long.MIN_VALUE;
        this.mSelectedPosition = -1;
        this.cFl = Long.MIN_VALUE;
        this.mOldSelectedPosition = -1;
        this.cFn = Long.MIN_VALUE;
        this.mBlockLayoutRequests = false;
    }

    public f(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mFirstPosition = 0;
        this.cFe = Long.MIN_VALUE;
        this.mNeedSync = false;
        this.mInLayout = false;
        this.cFj = -1;
        this.cFk = Long.MIN_VALUE;
        this.mSelectedPosition = -1;
        this.cFl = Long.MIN_VALUE;
        this.mOldSelectedPosition = -1;
        this.cFn = Long.MIN_VALUE;
        this.mBlockLayoutRequests = false;
    }

    public f(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mFirstPosition = 0;
        this.cFe = Long.MIN_VALUE;
        this.mNeedSync = false;
        this.mInLayout = false;
        this.cFj = -1;
        this.cFk = Long.MIN_VALUE;
        this.mSelectedPosition = -1;
        this.cFl = Long.MIN_VALUE;
        this.mOldSelectedPosition = -1;
        this.cFn = Long.MIN_VALUE;
        this.mBlockLayoutRequests = false;
        if (!isInEditMode()) {
            this.cFm = (AccessibilityManager) getContext().getSystemService("accessibility");
        }
    }

    public void setOnItemClickListener(c cVar) {
        this.cFh = cVar;
    }

    public final c getOnItemClickListener() {
        return this.cFh;
    }

    public boolean performItemClick(View view, int i, long j) {
        if (this.cFh != null) {
            playSoundEffect(0);
            if (view != null) {
                view.sendAccessibilityEvent(1);
            }
            this.cFh.a(this, view, i, j);
            return true;
        }
        return false;
    }

    public void setOnItemLongClickListener(d dVar) {
        if (!isLongClickable()) {
            setLongClickable(true);
        }
        this.cFi = dVar;
    }

    public final d getOnItemLongClickListener() {
        return this.cFi;
    }

    public void setOnItemSelectedListener(e eVar) {
        this.cFg = eVar;
    }

    public final e getOnItemSelectedListener() {
        return this.cFg;
    }

    /* loaded from: classes.dex */
    public static class a implements ContextMenu.ContextMenuInfo {
        public long id;
        public int position;
        public View targetView;

        public a(View view, int i, long j) {
            this.targetView = view;
            this.position = i;
            this.id = j;
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        throw new UnsupportedOperationException("addView(View) is not supported in AdapterView");
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        throw new UnsupportedOperationException("addView(View, int) is not supported in AdapterView");
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        throw new UnsupportedOperationException("addView(View, LayoutParams) is not supported in AdapterView");
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        throw new UnsupportedOperationException("addView(View, int, LayoutParams) is not supported in AdapterView");
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        throw new UnsupportedOperationException("removeView(View) is not supported in AdapterView");
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i) {
        throw new UnsupportedOperationException("removeViewAt(int) is not supported in AdapterView");
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        throw new UnsupportedOperationException("removeAllViews() is not supported in AdapterView");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.mLayoutWidth = getWidth();
    }

    @ViewDebug.CapturedViewProperty
    public int getSelectedItemPosition() {
        return this.cFj;
    }

    @ViewDebug.CapturedViewProperty
    public long getSelectedItemId() {
        return this.cFk;
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
    public int getCount() {
        return this.mItemCount;
    }

    public int getPositionForView(View view) {
        while (true) {
            try {
                View view2 = (View) view.getParent();
                if (view2.equals(this)) {
                    break;
                }
                view = view2;
            } catch (ClassCastException e2) {
                return -1;
            }
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (getChildAt(i).equals(view)) {
                return i + this.mFirstPosition;
            }
        }
        return -1;
    }

    public int getFirstVisiblePosition() {
        return this.mFirstPosition;
    }

    public int getLastVisiblePosition() {
        return (this.mFirstPosition + getChildCount()) - 1;
    }

    public void setEmptyView(View view) {
        this.mEmptyView = view;
        T adapter = getAdapter();
        updateEmptyStatus(adapter == null || adapter.isEmpty());
    }

    public View getEmptyView() {
        return this.mEmptyView;
    }

    boolean isInFilterMode() {
        return false;
    }

    @Override // android.view.View
    public void setFocusable(boolean z) {
        boolean z2 = true;
        T adapter = getAdapter();
        boolean z3 = adapter == null || adapter.getCount() == 0;
        this.cFo = z;
        if (!z) {
            this.cFp = false;
        }
        if (!z || (z3 && !isInFilterMode())) {
            z2 = false;
        }
        super.setFocusable(z2);
    }

    @Override // android.view.View
    public void setFocusableInTouchMode(boolean z) {
        boolean z2 = true;
        T adapter = getAdapter();
        boolean z3 = adapter == null || adapter.getCount() == 0;
        this.cFp = z;
        if (z) {
            this.cFo = true;
        }
        if (!z || (z3 && !isInFilterMode())) {
            z2 = false;
        }
        super.setFocusableInTouchMode(z2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ajG() {
        boolean z = false;
        T adapter = getAdapter();
        boolean z2 = !(adapter == null || adapter.getCount() == 0) || isInFilterMode();
        super.setFocusableInTouchMode(z2 && this.cFp);
        super.setFocusable(z2 && this.cFo);
        if (this.mEmptyView != null) {
            if (adapter == null || adapter.isEmpty()) {
                z = true;
            }
            updateEmptyStatus(z);
        }
    }

    private void updateEmptyStatus(boolean z) {
        if (isInFilterMode()) {
            z = false;
        }
        if (z) {
            if (this.mEmptyView != null) {
                this.mEmptyView.setVisibility(0);
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
        if (this.mEmptyView != null) {
            this.mEmptyView.setVisibility(8);
        }
        setVisibility(0);
    }

    public long getItemIdAtPosition(int i) {
        T adapter = getAdapter();
        if (adapter == null || i < 0) {
            return Long.MIN_VALUE;
        }
        return adapter.getItemId(i);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        throw new RuntimeException("Don't call setOnClickListener for an AdapterView. You probably want setOnItemClickListener instead");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    /* loaded from: classes.dex */
    class b extends DataSetObserver {
        private Parcelable cFr = null;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            f.this.mDataChanged = true;
            f.this.mOldItemCount = f.this.mItemCount;
            f.this.mItemCount = f.this.getAdapter().getCount();
            if (f.this.getAdapter().hasStableIds() && this.cFr != null && f.this.mOldItemCount == 0 && f.this.mItemCount > 0) {
                f.this.onRestoreInstanceState(this.cFr);
                this.cFr = null;
            } else {
                f.this.rememberSyncState();
            }
            f.this.ajG();
            f.this.requestLayout();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            f.this.mDataChanged = true;
            if (f.this.getAdapter().hasStableIds()) {
                this.cFr = f.this.onSaveInstanceState();
            }
            f.this.mOldItemCount = f.this.mItemCount;
            f.this.mItemCount = 0;
            f.this.mSelectedPosition = -1;
            f.this.cFl = Long.MIN_VALUE;
            f.this.cFj = -1;
            f.this.cFk = Long.MIN_VALUE;
            f.this.mNeedSync = false;
            f.this.ajG();
            f.this.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.cFq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.horizonalList.widget.f$f  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0064f implements Runnable {
        private RunnableC0064f() {
        }

        /* synthetic */ RunnableC0064f(f fVar, RunnableC0064f runnableC0064f) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (f.this.mDataChanged) {
                if (f.this.getAdapter() != null) {
                    f.this.post(this);
                    return;
                }
                return;
            }
            f.this.fireOnSelected();
            f.this.performAccessibilityActionsOnSelected();
        }
    }

    void selectionChanged() {
        if (this.cFg != null || this.cFm.isEnabled()) {
            if (this.mInLayout || this.mBlockLayoutRequests) {
                if (this.cFq == null) {
                    this.cFq = new RunnableC0064f(this, null);
                }
                post(this.cFq);
                return;
            }
            fireOnSelected();
            performAccessibilityActionsOnSelected();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fireOnSelected() {
        if (this.cFg != null) {
            int selectedItemPosition = getSelectedItemPosition();
            if (selectedItemPosition >= 0) {
                this.cFg.c(this, getSelectedView(), selectedItemPosition, getAdapter().getItemId(selectedItemPosition));
                return;
            }
            this.cFg.d(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void performAccessibilityActionsOnSelected() {
        if (this.cFm.isEnabled() && getSelectedItemPosition() >= 0) {
            sendAccessibilityEvent(4);
        }
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        View selectedView = getSelectedView();
        return selectedView != null && selectedView.getVisibility() == 0 && selectedView.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Override // android.view.ViewGroup
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

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(f.class.getName());
        accessibilityNodeInfo.setScrollable(ajH());
        View selectedView = getSelectedView();
        if (selectedView != null) {
            accessibilityNodeInfo.setEnabled(selectedView.isEnabled());
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(f.class.getName());
        accessibilityEvent.setScrollable(ajH());
        View selectedView = getSelectedView();
        if (selectedView != null) {
            accessibilityEvent.setEnabled(selectedView.isEnabled());
        }
        accessibilityEvent.setCurrentItemIndex(getSelectedItemPosition());
        accessibilityEvent.setFromIndex(getFirstVisiblePosition());
        accessibilityEvent.setToIndex(getLastVisiblePosition());
        accessibilityEvent.setItemCount(getCount());
    }

    private boolean ajH() {
        int count;
        T adapter = getAdapter();
        if (adapter == null || (count = adapter.getCount()) <= 0) {
            return false;
        }
        return getFirstVisiblePosition() > 0 || getLastVisiblePosition() < count + (-1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public boolean canAnimate() {
        return super.canAnimate() && this.mItemCount > 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void handleDataChanged() {
        boolean z;
        boolean z2;
        int i = this.mItemCount;
        if (i > 0) {
            if (this.mNeedSync) {
                this.mNeedSync = false;
                int findSyncPosition = findSyncPosition();
                if (findSyncPosition >= 0 && lookForSelectablePosition(findSyncPosition, true) == findSyncPosition) {
                    setNextSelectedPositionInt(findSyncPosition);
                    z2 = true;
                    if (!z2) {
                        int selectedItemPosition = getSelectedItemPosition();
                        if (selectedItemPosition >= i) {
                            selectedItemPosition = i - 1;
                        }
                        if (selectedItemPosition < 0) {
                            selectedItemPosition = 0;
                        }
                        int lookForSelectablePosition = lookForSelectablePosition(selectedItemPosition, true);
                        int lookForSelectablePosition2 = lookForSelectablePosition < 0 ? lookForSelectablePosition(selectedItemPosition, false) : lookForSelectablePosition;
                        if (lookForSelectablePosition2 >= 0) {
                            setNextSelectedPositionInt(lookForSelectablePosition2);
                            checkSelectionChanged();
                            z = true;
                        }
                    }
                    z = z2;
                }
            }
            z2 = false;
            if (!z2) {
            }
            z = z2;
        } else {
            z = false;
        }
        if (!z) {
            this.mSelectedPosition = -1;
            this.cFl = Long.MIN_VALUE;
            this.cFj = -1;
            this.cFk = Long.MIN_VALUE;
            this.mNeedSync = false;
            checkSelectionChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void checkSelectionChanged() {
        if (this.mSelectedPosition != this.mOldSelectedPosition || this.cFl != this.cFn) {
            selectionChanged();
            this.mOldSelectedPosition = this.mSelectedPosition;
            this.cFn = this.cFl;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int findSyncPosition() {
        int i = this.mItemCount;
        if (i == 0) {
            return -1;
        }
        long j = this.cFe;
        int i2 = this.mSyncPosition;
        if (j == Long.MIN_VALUE) {
            return -1;
        }
        int min = Math.min(i - 1, Math.max(0, i2));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        T adapter = getAdapter();
        if (adapter == null) {
            return -1;
        }
        int i3 = min;
        int i4 = min;
        int i5 = min;
        boolean z = false;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (adapter.getItemId(i5) != j) {
                boolean z2 = i3 == i + (-1);
                boolean z3 = i4 == 0;
                if (z2 && z3) {
                    break;
                } else if (z3 || (z && !z2)) {
                    int i6 = i3 + 1;
                    i3 = i6;
                    i5 = i6;
                    z = false;
                } else if (z2 || (!z && !z3)) {
                    int i7 = i4 - 1;
                    i4 = i7;
                    i5 = i7;
                    z = true;
                }
            } else {
                return i5;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int lookForSelectablePosition(int i, boolean z) {
        return i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setSelectedPositionInt(int i) {
        this.mSelectedPosition = i;
        this.cFl = getItemIdAtPosition(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setNextSelectedPositionInt(int i) {
        this.cFj = i;
        this.cFk = getItemIdAtPosition(i);
        if (this.mNeedSync && this.mSyncMode == 0 && i >= 0) {
            this.mSyncPosition = i;
            this.cFe = this.cFk;
        }
    }

    public void rememberSyncState() {
        if (getChildCount() > 0) {
            this.mNeedSync = true;
            this.cFf = this.mLayoutWidth;
            if (this.mSelectedPosition >= 0) {
                View childAt = getChildAt(this.mSelectedPosition - this.mFirstPosition);
                this.cFe = this.cFk;
                this.mSyncPosition = this.cFj;
                if (childAt != null) {
                    this.cFd = childAt.getLeft();
                }
                this.mSyncMode = 0;
                return;
            }
            View childAt2 = getChildAt(0);
            T adapter = getAdapter();
            if (this.mFirstPosition >= 0 && this.mFirstPosition < adapter.getCount()) {
                this.cFe = adapter.getItemId(this.mFirstPosition);
            } else {
                this.cFe = -1L;
            }
            this.mSyncPosition = this.mFirstPosition;
            if (childAt2 != null) {
                this.cFd = childAt2.getLeft();
            }
            this.mSyncMode = 1;
        }
    }
}
