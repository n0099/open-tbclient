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
    public boolean afh;
    @ViewDebug.ExportedProperty(category = IntentConfig.LIST)
    protected int bGW;
    @ViewDebug.ExportedProperty(category = "scrolling")
    protected int bRD;
    protected int bRE;
    protected int bRF;
    protected long bRG;
    protected long bRH;
    protected boolean bRI;
    int bRJ;
    e bRK;
    c bRL;
    d bRM;
    @ViewDebug.ExportedProperty(category = IntentConfig.LIST)
    protected int bRN;
    protected long bRO;
    protected long bRP;
    @ViewDebug.ExportedProperty(category = IntentConfig.LIST)
    protected int bRQ;
    protected int bRR;
    AccessibilityManager bRS;
    protected int bRT;
    protected long bRU;
    private boolean bRV;
    private boolean bRW;
    private g<T>.f bRX;
    protected boolean bRY;
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

    public g(Context context) {
        super(context);
        this.bRD = 0;
        this.bRG = Long.MIN_VALUE;
        this.bRI = false;
        this.mInLayout = false;
        this.bRN = -1;
        this.bRO = Long.MIN_VALUE;
        this.bGW = -1;
        this.bRP = Long.MIN_VALUE;
        this.bRT = -1;
        this.bRU = Long.MIN_VALUE;
        this.bRY = false;
    }

    public g(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bRD = 0;
        this.bRG = Long.MIN_VALUE;
        this.bRI = false;
        this.mInLayout = false;
        this.bRN = -1;
        this.bRO = Long.MIN_VALUE;
        this.bGW = -1;
        this.bRP = Long.MIN_VALUE;
        this.bRT = -1;
        this.bRU = Long.MIN_VALUE;
        this.bRY = false;
    }

    public g(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bRD = 0;
        this.bRG = Long.MIN_VALUE;
        this.bRI = false;
        this.mInLayout = false;
        this.bRN = -1;
        this.bRO = Long.MIN_VALUE;
        this.bGW = -1;
        this.bRP = Long.MIN_VALUE;
        this.bRT = -1;
        this.bRU = Long.MIN_VALUE;
        this.bRY = false;
        if (!isInEditMode()) {
            this.bRS = (AccessibilityManager) getContext().getSystemService("accessibility");
        }
    }

    public void setOnItemClickListener(c cVar) {
        this.bRL = cVar;
    }

    public final c getOnItemClickListener() {
        return this.bRL;
    }

    public boolean performItemClick(View view, int i, long j) {
        if (this.bRL != null) {
            playSoundEffect(0);
            if (view != null) {
                view.sendAccessibilityEvent(1);
            }
            this.bRL.a(this, view, i, j);
            return true;
        }
        return false;
    }

    public void setOnItemLongClickListener(d dVar) {
        if (!isLongClickable()) {
            setLongClickable(true);
        }
        this.bRM = dVar;
    }

    public final d getOnItemLongClickListener() {
        return this.bRM;
    }

    public void setOnItemSelectedListener(e eVar) {
        this.bRK = eVar;
    }

    public final e getOnItemSelectedListener() {
        return this.bRK;
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
        return this.bRN;
    }

    @ViewDebug.CapturedViewProperty
    public long getSelectedItemId() {
        return this.bRO;
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
        return this.bRQ;
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
                return i + this.bRD;
            }
        }
        return -1;
    }

    public int getFirstVisiblePosition() {
        return this.bRD;
    }

    public int getLastVisiblePosition() {
        return (this.bRD + getChildCount()) - 1;
    }

    public void setEmptyView(View view) {
        this.mEmptyView = view;
        T adapter = getAdapter();
        dw(adapter == null || adapter.isEmpty());
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
        this.bRV = z;
        if (!z) {
            this.bRW = false;
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
        this.bRW = z;
        if (z) {
            this.bRV = true;
        }
        if (!z || (z3 && !isInFilterMode())) {
            z2 = false;
        }
        super.setFocusableInTouchMode(z2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aas() {
        boolean z = false;
        T adapter = getAdapter();
        boolean z2 = !(adapter == null || adapter.getCount() == 0) || isInFilterMode();
        super.setFocusableInTouchMode(z2 && this.bRW);
        super.setFocusable(z2 && this.bRV);
        if (this.mEmptyView != null) {
            if (adapter == null || adapter.isEmpty()) {
                z = true;
            }
            dw(z);
        }
    }

    private void dw(boolean z) {
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
            if (this.afh) {
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
        private Parcelable bRZ = null;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            g.this.afh = true;
            g.this.bRR = g.this.bRQ;
            g.this.bRQ = g.this.getAdapter().getCount();
            if (g.this.getAdapter().hasStableIds() && this.bRZ != null && g.this.bRR == 0 && g.this.bRQ > 0) {
                g.this.onRestoreInstanceState(this.bRZ);
                this.bRZ = null;
            } else {
                g.this.aaz();
            }
            g.this.aas();
            g.this.requestLayout();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            g.this.afh = true;
            if (g.this.getAdapter().hasStableIds()) {
                this.bRZ = g.this.onSaveInstanceState();
            }
            g.this.bRR = g.this.bRQ;
            g.this.bRQ = 0;
            g.this.bGW = -1;
            g.this.bRP = Long.MIN_VALUE;
            g.this.bRN = -1;
            g.this.bRO = Long.MIN_VALUE;
            g.this.bRI = false;
            g.this.aas();
            g.this.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.bRX);
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
            if (g.this.afh) {
                if (g.this.getAdapter() != null) {
                    g.this.post(this);
                    return;
                }
                return;
            }
            g.this.aau();
            g.this.aav();
        }
    }

    void aat() {
        if (this.bRK != null || this.bRS.isEnabled()) {
            if (this.mInLayout || this.bRY) {
                if (this.bRX == null) {
                    this.bRX = new f(this, null);
                }
                post(this.bRX);
                return;
            }
            aau();
            aav();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aau() {
        if (this.bRK != null) {
            int selectedItemPosition = getSelectedItemPosition();
            if (selectedItemPosition >= 0) {
                this.bRK.c(this, getSelectedView(), selectedItemPosition, getAdapter().getItemId(selectedItemPosition));
                return;
            }
            this.bRK.d(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aav() {
        if (this.bRS.isEnabled() && getSelectedItemPosition() >= 0) {
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
        accessibilityNodeInfo.setScrollable(aaw());
        View selectedView = getSelectedView();
        if (selectedView != null) {
            accessibilityNodeInfo.setEnabled(selectedView.isEnabled());
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(g.class.getName());
        accessibilityEvent.setScrollable(aaw());
        View selectedView = getSelectedView();
        if (selectedView != null) {
            accessibilityEvent.setEnabled(selectedView.isEnabled());
        }
        accessibilityEvent.setCurrentItemIndex(getSelectedItemPosition());
        accessibilityEvent.setFromIndex(getFirstVisiblePosition());
        accessibilityEvent.setToIndex(getLastVisiblePosition());
        accessibilityEvent.setItemCount(getCount());
    }

    private boolean aaw() {
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
        return super.canAnimate() && this.bRQ > 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void handleDataChanged() {
        boolean z;
        boolean z2;
        int i = this.bRQ;
        if (i > 0) {
            if (this.bRI) {
                this.bRI = false;
                int aay = aay();
                if (aay >= 0 && k(aay, true) == aay) {
                    setNextSelectedPositionInt(aay);
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
                            aax();
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
            this.bGW = -1;
            this.bRP = Long.MIN_VALUE;
            this.bRN = -1;
            this.bRO = Long.MIN_VALUE;
            this.bRI = false;
            aax();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aax() {
        if (this.bGW != this.bRT || this.bRP != this.bRU) {
            aat();
            this.bRT = this.bGW;
            this.bRU = this.bRP;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int aay() {
        int i = this.bRQ;
        if (i == 0) {
            return -1;
        }
        long j = this.bRG;
        int i2 = this.bRF;
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
        this.bGW = i;
        this.bRP = getItemIdAtPosition(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setNextSelectedPositionInt(int i) {
        this.bRN = i;
        this.bRO = getItemIdAtPosition(i);
        if (this.bRI && this.bRJ == 0 && i >= 0) {
            this.bRF = i;
            this.bRG = this.bRO;
        }
    }

    public void aaz() {
        if (getChildCount() > 0) {
            this.bRI = true;
            this.bRH = this.mLayoutWidth;
            if (this.bGW >= 0) {
                View childAt = getChildAt(this.bGW - this.bRD);
                this.bRG = this.bRO;
                this.bRF = this.bRN;
                if (childAt != null) {
                    this.bRE = childAt.getLeft();
                }
                this.bRJ = 0;
                return;
            }
            View childAt2 = getChildAt(0);
            T adapter = getAdapter();
            if (this.bRD >= 0 && this.bRD < adapter.getCount()) {
                this.bRG = adapter.getItemId(this.bRD);
            } else {
                this.bRG = -1L;
            }
            this.bRF = this.bRD;
            if (childAt2 != null) {
                this.bRE = childAt2.getLeft();
            }
            this.bRJ = 1;
        }
    }
}
