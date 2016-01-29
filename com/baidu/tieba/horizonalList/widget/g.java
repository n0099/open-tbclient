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
public abstract class g<T extends Adapter> extends ViewGroup {
    public boolean afI;
    @ViewDebug.ExportedProperty(category = IntentConfig.LIST)
    protected int bBx;
    private g<T>.f bHA;
    protected boolean bHB;
    @ViewDebug.ExportedProperty(category = "scrolling")
    protected int bHg;
    protected int bHh;
    protected int bHi;
    protected long bHj;
    protected long bHk;
    protected boolean bHl;
    int bHm;
    e bHn;
    c bHo;
    d bHp;
    @ViewDebug.ExportedProperty(category = IntentConfig.LIST)
    protected int bHq;
    protected long bHr;
    protected long bHs;
    @ViewDebug.ExportedProperty(category = IntentConfig.LIST)
    protected int bHt;
    protected int bHu;
    AccessibilityManager bHv;
    protected int bHw;
    protected long bHx;
    private boolean bHy;
    private boolean bHz;
    private View mEmptyView;
    protected boolean mInLayout;
    private int mLayoutWidth;

    /* loaded from: classes.dex */
    public interface c {
        void a(g<?> gVar, View view, int i, long j);
    }

    /* loaded from: classes.dex */
    public interface d {
        boolean b(g<?> gVar, View view, int i, long j);
    }

    /* loaded from: classes.dex */
    public interface e {
        void c(g<?> gVar, View view, int i, long j);

        void d(g<?> gVar);
    }

    public abstract T getAdapter();

    public abstract View getSelectedView();

    public abstract void setAdapter(T t);

    public abstract void setSelection(int i);

    public g(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bHg = 0;
        this.bHj = Long.MIN_VALUE;
        this.bHl = false;
        this.mInLayout = false;
        this.bHq = -1;
        this.bHr = Long.MIN_VALUE;
        this.bBx = -1;
        this.bHs = Long.MIN_VALUE;
        this.bHw = -1;
        this.bHx = Long.MIN_VALUE;
        this.bHB = false;
        if (!isInEditMode()) {
            this.bHv = (AccessibilityManager) getContext().getSystemService("accessibility");
        }
    }

    public void setOnItemClickListener(c cVar) {
        this.bHo = cVar;
    }

    public final c getOnItemClickListener() {
        return this.bHo;
    }

    public boolean performItemClick(View view, int i, long j) {
        if (this.bHo != null) {
            playSoundEffect(0);
            if (view != null) {
                view.sendAccessibilityEvent(1);
            }
            this.bHo.a(this, view, i, j);
            return true;
        }
        return false;
    }

    public void setOnItemLongClickListener(d dVar) {
        if (!isLongClickable()) {
            setLongClickable(true);
        }
        this.bHp = dVar;
    }

    public final d getOnItemLongClickListener() {
        return this.bHp;
    }

    public void setOnItemSelectedListener(e eVar) {
        this.bHn = eVar;
    }

    public final e getOnItemSelectedListener() {
        return this.bHn;
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
        return this.bHq;
    }

    @ViewDebug.CapturedViewProperty
    public long getSelectedItemId() {
        return this.bHr;
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
        return this.bHt;
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
                return i + this.bHg;
            }
        }
        return -1;
    }

    public int getFirstVisiblePosition() {
        return this.bHg;
    }

    public int getLastVisiblePosition() {
        return (this.bHg + getChildCount()) - 1;
    }

    public void setEmptyView(View view) {
        this.mEmptyView = view;
        T adapter = getAdapter();
        dc(adapter == null || adapter.isEmpty());
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
        this.bHy = z;
        if (!z) {
            this.bHz = false;
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
        this.bHz = z;
        if (z) {
            this.bHy = true;
        }
        if (!z || (z3 && !isInFilterMode())) {
            z2 = false;
        }
        super.setFocusableInTouchMode(z2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void WT() {
        boolean z = false;
        T adapter = getAdapter();
        boolean z2 = !(adapter == null || adapter.getCount() == 0) || isInFilterMode();
        super.setFocusableInTouchMode(z2 && this.bHz);
        super.setFocusable(z2 && this.bHy);
        if (this.mEmptyView != null) {
            if (adapter == null || adapter.isEmpty()) {
                z = true;
            }
            dc(z);
        }
    }

    private void dc(boolean z) {
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
            if (this.afI) {
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
        private Parcelable bHC = null;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            g.this.afI = true;
            g.this.bHu = g.this.bHt;
            g.this.bHt = g.this.getAdapter().getCount();
            if (g.this.getAdapter().hasStableIds() && this.bHC != null && g.this.bHu == 0 && g.this.bHt > 0) {
                g.this.onRestoreInstanceState(this.bHC);
                this.bHC = null;
            } else {
                g.this.Xa();
            }
            g.this.WT();
            g.this.requestLayout();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            g.this.afI = true;
            if (g.this.getAdapter().hasStableIds()) {
                this.bHC = g.this.onSaveInstanceState();
            }
            g.this.bHu = g.this.bHt;
            g.this.bHt = 0;
            g.this.bBx = -1;
            g.this.bHs = Long.MIN_VALUE;
            g.this.bHq = -1;
            g.this.bHr = Long.MIN_VALUE;
            g.this.bHl = false;
            g.this.WT();
            g.this.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.bHA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class f implements Runnable {
        private f() {
        }

        /* synthetic */ f(g gVar, f fVar) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (g.this.afI) {
                if (g.this.getAdapter() != null) {
                    g.this.post(this);
                    return;
                }
                return;
            }
            g.this.WV();
            g.this.WW();
        }
    }

    void WU() {
        if (this.bHn != null || this.bHv.isEnabled()) {
            if (this.mInLayout || this.bHB) {
                if (this.bHA == null) {
                    this.bHA = new f(this, null);
                }
                post(this.bHA);
                return;
            }
            WV();
            WW();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WV() {
        if (this.bHn != null) {
            int selectedItemPosition = getSelectedItemPosition();
            if (selectedItemPosition >= 0) {
                this.bHn.c(this, getSelectedView(), selectedItemPosition, getAdapter().getItemId(selectedItemPosition));
                return;
            }
            this.bHn.d(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WW() {
        if (this.bHv.isEnabled() && getSelectedItemPosition() >= 0) {
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
        accessibilityNodeInfo.setClassName(g.class.getName());
        accessibilityNodeInfo.setScrollable(WX());
        View selectedView = getSelectedView();
        if (selectedView != null) {
            accessibilityNodeInfo.setEnabled(selectedView.isEnabled());
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(g.class.getName());
        accessibilityEvent.setScrollable(WX());
        View selectedView = getSelectedView();
        if (selectedView != null) {
            accessibilityEvent.setEnabled(selectedView.isEnabled());
        }
        accessibilityEvent.setCurrentItemIndex(getSelectedItemPosition());
        accessibilityEvent.setFromIndex(getFirstVisiblePosition());
        accessibilityEvent.setToIndex(getLastVisiblePosition());
        accessibilityEvent.setItemCount(getCount());
    }

    private boolean WX() {
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
        return super.canAnimate() && this.bHt > 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void handleDataChanged() {
        boolean z;
        boolean z2;
        int i = this.bHt;
        if (i > 0) {
            if (this.bHl) {
                this.bHl = false;
                int WZ = WZ();
                if (WZ >= 0 && k(WZ, true) == WZ) {
                    setNextSelectedPositionInt(WZ);
                    z2 = true;
                    if (!z2) {
                        int selectedItemPosition = getSelectedItemPosition();
                        if (selectedItemPosition >= i) {
                            selectedItemPosition = i - 1;
                        }
                        if (selectedItemPosition < 0) {
                            selectedItemPosition = 0;
                        }
                        int k = k(selectedItemPosition, true);
                        int k2 = k < 0 ? k(selectedItemPosition, false) : k;
                        if (k2 >= 0) {
                            setNextSelectedPositionInt(k2);
                            WY();
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
            this.bBx = -1;
            this.bHs = Long.MIN_VALUE;
            this.bHq = -1;
            this.bHr = Long.MIN_VALUE;
            this.bHl = false;
            WY();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void WY() {
        if (this.bBx != this.bHw || this.bHs != this.bHx) {
            WU();
            this.bHw = this.bBx;
            this.bHx = this.bHs;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int WZ() {
        int i = this.bHt;
        if (i == 0) {
            return -1;
        }
        long j = this.bHj;
        int i2 = this.bHi;
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
    public int k(int i, boolean z) {
        return i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setSelectedPositionInt(int i) {
        this.bBx = i;
        this.bHs = getItemIdAtPosition(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setNextSelectedPositionInt(int i) {
        this.bHq = i;
        this.bHr = getItemIdAtPosition(i);
        if (this.bHl && this.bHm == 0 && i >= 0) {
            this.bHi = i;
            this.bHj = this.bHr;
        }
    }

    public void Xa() {
        if (getChildCount() > 0) {
            this.bHl = true;
            this.bHk = this.mLayoutWidth;
            if (this.bBx >= 0) {
                View childAt = getChildAt(this.bBx - this.bHg);
                this.bHj = this.bHr;
                this.bHi = this.bHq;
                if (childAt != null) {
                    this.bHh = childAt.getLeft();
                }
                this.bHm = 0;
                return;
            }
            View childAt2 = getChildAt(0);
            T adapter = getAdapter();
            if (this.bHg >= 0 && this.bHg < adapter.getCount()) {
                this.bHj = adapter.getItemId(this.bHg);
            } else {
                this.bHj = -1L;
            }
            this.bHi = this.bHg;
            if (childAt2 != null) {
                this.bHh = childAt2.getLeft();
            }
            this.bHm = 1;
        }
    }
}
