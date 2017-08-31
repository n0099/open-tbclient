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
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public abstract class a<T extends Adapter> extends ViewGroup {
    protected int dfE;
    protected long dfF;
    protected long dfG;
    e dfH;
    c dfI;
    d dfJ;
    @ViewDebug.ExportedProperty(category = IntentConfig.LIST)
    protected int dfK;
    protected long dfL;
    protected long dfM;
    AccessibilityManager dfN;
    protected long dfO;
    private boolean dfP;
    private boolean dfQ;
    private a<T>.f dfR;
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
        void a(a<?> aVar, View view, int i, long j);
    }

    /* loaded from: classes.dex */
    public interface d {
        boolean b(a<?> aVar, View view, int i, long j);
    }

    /* loaded from: classes.dex */
    public interface e {
        void c(a<?> aVar, View view, int i, long j);

        void d(a<?> aVar);
    }

    public abstract T getAdapter();

    public abstract View getSelectedView();

    public abstract void setAdapter(T t);

    public abstract void setSelection(int i);

    public a(Context context) {
        super(context);
        this.mFirstPosition = 0;
        this.dfF = Long.MIN_VALUE;
        this.mNeedSync = false;
        this.mInLayout = false;
        this.dfK = -1;
        this.dfL = Long.MIN_VALUE;
        this.mSelectedPosition = -1;
        this.dfM = Long.MIN_VALUE;
        this.mOldSelectedPosition = -1;
        this.dfO = Long.MIN_VALUE;
        this.mBlockLayoutRequests = false;
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mFirstPosition = 0;
        this.dfF = Long.MIN_VALUE;
        this.mNeedSync = false;
        this.mInLayout = false;
        this.dfK = -1;
        this.dfL = Long.MIN_VALUE;
        this.mSelectedPosition = -1;
        this.dfM = Long.MIN_VALUE;
        this.mOldSelectedPosition = -1;
        this.dfO = Long.MIN_VALUE;
        this.mBlockLayoutRequests = false;
    }

    @TargetApi(16)
    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mFirstPosition = 0;
        this.dfF = Long.MIN_VALUE;
        this.mNeedSync = false;
        this.mInLayout = false;
        this.dfK = -1;
        this.dfL = Long.MIN_VALUE;
        this.mSelectedPosition = -1;
        this.dfM = Long.MIN_VALUE;
        this.mOldSelectedPosition = -1;
        this.dfO = Long.MIN_VALUE;
        this.mBlockLayoutRequests = false;
        if (!isInEditMode()) {
            this.dfN = (AccessibilityManager) getContext().getSystemService("accessibility");
        }
    }

    public void setOnItemClickListener(c cVar) {
        this.dfI = cVar;
    }

    public final c getOnItemClickListener() {
        return this.dfI;
    }

    public boolean performItemClick(View view, int i, long j) {
        if (this.dfI != null) {
            playSoundEffect(0);
            if (view != null) {
                view.sendAccessibilityEvent(1);
            }
            this.dfI.a(this, view, i, j);
            return true;
        }
        return false;
    }

    public void setOnItemLongClickListener(d dVar) {
        if (!isLongClickable()) {
            setLongClickable(true);
        }
        this.dfJ = dVar;
    }

    public final d getOnItemLongClickListener() {
        return this.dfJ;
    }

    public void setOnItemSelectedListener(e eVar) {
        this.dfH = eVar;
    }

    public final e getOnItemSelectedListener() {
        return this.dfH;
    }

    /* renamed from: com.baidu.tieba.horizonalList.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class ContextMenu$ContextMenuInfoC0092a implements ContextMenu.ContextMenuInfo {
        public long id;
        public int position;
        public View targetView;

        public ContextMenu$ContextMenuInfoC0092a(View view, int i, long j) {
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
        return this.dfK;
    }

    @ViewDebug.CapturedViewProperty
    public long getSelectedItemId() {
        return this.dfL;
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

    @TargetApi(16)
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
        this.dfP = z;
        if (!z) {
            this.dfQ = false;
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
        this.dfQ = z;
        if (z) {
            this.dfP = true;
        }
        if (!z || (z3 && !isInFilterMode())) {
            z2 = false;
        }
        super.setFocusableInTouchMode(z2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void arv() {
        boolean z = false;
        T adapter = getAdapter();
        boolean z2 = !(adapter == null || adapter.getCount() == 0) || isInFilterMode();
        super.setFocusableInTouchMode(z2 && this.dfQ);
        super.setFocusable(z2 && this.dfP);
        if (this.mEmptyView != null) {
            if (adapter == null || adapter.isEmpty()) {
                z = true;
            }
            updateEmptyStatus(z);
        }
    }

    @SuppressLint({"WrongCall"})
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
        private Parcelable dfS = null;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            a.this.mDataChanged = true;
            a.this.mOldItemCount = a.this.mItemCount;
            a.this.mItemCount = a.this.getAdapter().getCount();
            if (a.this.getAdapter().hasStableIds() && this.dfS != null && a.this.mOldItemCount == 0 && a.this.mItemCount > 0) {
                a.this.onRestoreInstanceState(this.dfS);
                this.dfS = null;
            } else {
                a.this.rememberSyncState();
            }
            a.this.arv();
            a.this.requestLayout();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            a.this.mDataChanged = true;
            if (a.this.getAdapter().hasStableIds()) {
                this.dfS = a.this.onSaveInstanceState();
            }
            a.this.mOldItemCount = a.this.mItemCount;
            a.this.mItemCount = 0;
            a.this.mSelectedPosition = -1;
            a.this.dfM = Long.MIN_VALUE;
            a.this.dfK = -1;
            a.this.dfL = Long.MIN_VALUE;
            a.this.mNeedSync = false;
            a.this.arv();
            a.this.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.dfR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class f implements Runnable {
        private f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!a.this.mDataChanged) {
                a.this.fireOnSelected();
                a.this.performAccessibilityActionsOnSelected();
            } else if (a.this.getAdapter() != null) {
                a.this.post(this);
            }
        }
    }

    void selectionChanged() {
        if (this.dfH != null || this.dfN.isEnabled()) {
            if (this.mInLayout || this.mBlockLayoutRequests) {
                if (this.dfR == null) {
                    this.dfR = new f();
                }
                post(this.dfR);
                return;
            }
            fireOnSelected();
            performAccessibilityActionsOnSelected();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fireOnSelected() {
        if (this.dfH != null) {
            int selectedItemPosition = getSelectedItemPosition();
            if (selectedItemPosition >= 0) {
                this.dfH.c(this, getSelectedView(), selectedItemPosition, getAdapter().getItemId(selectedItemPosition));
                return;
            }
            this.dfH.d(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void performAccessibilityActionsOnSelected() {
        if (this.dfN.isEnabled() && getSelectedItemPosition() >= 0) {
            sendAccessibilityEvent(4);
        }
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        View selectedView = getSelectedView();
        return selectedView != null && selectedView.getVisibility() == 0 && selectedView.dispatchPopulateAccessibilityEvent(accessibilityEvent);
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

    @Override // android.view.View
    @TargetApi(14)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(a.class.getName());
        accessibilityNodeInfo.setScrollable(arw());
        View selectedView = getSelectedView();
        if (selectedView != null) {
            accessibilityNodeInfo.setEnabled(selectedView.isEnabled());
        }
    }

    @Override // android.view.View
    @TargetApi(14)
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(a.class.getName());
        accessibilityEvent.setScrollable(arw());
        View selectedView = getSelectedView();
        if (selectedView != null) {
            accessibilityEvent.setEnabled(selectedView.isEnabled());
        }
        accessibilityEvent.setCurrentItemIndex(getSelectedItemPosition());
        accessibilityEvent.setFromIndex(getFirstVisiblePosition());
        accessibilityEvent.setToIndex(getLastVisiblePosition());
        accessibilityEvent.setItemCount(getCount());
    }

    private boolean arw() {
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
            this.dfM = Long.MIN_VALUE;
            this.dfK = -1;
            this.dfL = Long.MIN_VALUE;
            this.mNeedSync = false;
            checkSelectionChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void checkSelectionChanged() {
        if (this.mSelectedPosition != this.mOldSelectedPosition || this.dfM != this.dfO) {
            selectionChanged();
            this.mOldSelectedPosition = this.mSelectedPosition;
            this.dfO = this.dfM;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int findSyncPosition() {
        int i = this.mItemCount;
        if (i == 0) {
            return -1;
        }
        long j = this.dfF;
        int i2 = this.mSyncPosition;
        if (j == Long.MIN_VALUE) {
            return -1;
        }
        int min = Math.min(i - 1, Math.max(0, i2));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        boolean z = false;
        T adapter = getAdapter();
        if (adapter == null) {
            return -1;
        }
        int i3 = min;
        int i4 = min;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (adapter.getItemId(i4) != j) {
                boolean z2 = min == i + (-1);
                boolean z3 = i3 == 0;
                if (z2 && z3) {
                    break;
                } else if (z3 || (z && !z2)) {
                    min++;
                    z = false;
                    i4 = min;
                } else if (z2 || (!z && !z3)) {
                    i3--;
                    z = true;
                    i4 = i3;
                }
            } else {
                return i4;
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
        this.dfM = getItemIdAtPosition(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setNextSelectedPositionInt(int i) {
        this.dfK = i;
        this.dfL = getItemIdAtPosition(i);
        if (this.mNeedSync && this.mSyncMode == 0 && i >= 0) {
            this.mSyncPosition = i;
            this.dfF = this.dfL;
        }
    }

    public void rememberSyncState() {
        if (getChildCount() > 0) {
            this.mNeedSync = true;
            this.dfG = this.mLayoutWidth;
            if (this.mSelectedPosition >= 0) {
                View childAt = getChildAt(this.mSelectedPosition - this.mFirstPosition);
                this.dfF = this.dfL;
                this.mSyncPosition = this.dfK;
                if (childAt != null) {
                    this.dfE = childAt.getLeft();
                }
                this.mSyncMode = 0;
                return;
            }
            View childAt2 = getChildAt(0);
            T adapter = getAdapter();
            if (this.mFirstPosition >= 0 && this.mFirstPosition < adapter.getCount()) {
                this.dfF = adapter.getItemId(this.mFirstPosition);
            } else {
                this.dfF = -1L;
            }
            this.mSyncPosition = this.mFirstPosition;
            if (childAt2 != null) {
                this.dfE = childAt2.getLeft();
            }
            this.mSyncMode = 1;
        }
    }
}
