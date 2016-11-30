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
    public boolean afj;
    @ViewDebug.ExportedProperty(category = "scrolling")
    protected int bAH;
    protected int cQG;
    protected int cQH;
    protected long cQI;
    protected long cQJ;
    protected boolean cQK;
    int cQL;
    e cQM;
    c cQN;
    d cQO;
    @ViewDebug.ExportedProperty(category = IntentConfig.LIST)
    protected int cQP;
    protected long cQQ;
    protected long cQR;
    @ViewDebug.ExportedProperty(category = IntentConfig.LIST)
    protected int cQS;
    protected int cQT;
    AccessibilityManager cQU;
    protected int cQV;
    protected long cQW;
    private boolean cQX;
    private boolean cQY;
    private g<T>.f cQZ;
    protected boolean cRa;
    @ViewDebug.ExportedProperty(category = IntentConfig.LIST)
    protected int cxH;
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
        this.bAH = 0;
        this.cQI = Long.MIN_VALUE;
        this.cQK = false;
        this.mInLayout = false;
        this.cQP = -1;
        this.cQQ = Long.MIN_VALUE;
        this.cxH = -1;
        this.cQR = Long.MIN_VALUE;
        this.cQV = -1;
        this.cQW = Long.MIN_VALUE;
        this.cRa = false;
    }

    public g(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bAH = 0;
        this.cQI = Long.MIN_VALUE;
        this.cQK = false;
        this.mInLayout = false;
        this.cQP = -1;
        this.cQQ = Long.MIN_VALUE;
        this.cxH = -1;
        this.cQR = Long.MIN_VALUE;
        this.cQV = -1;
        this.cQW = Long.MIN_VALUE;
        this.cRa = false;
    }

    public g(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bAH = 0;
        this.cQI = Long.MIN_VALUE;
        this.cQK = false;
        this.mInLayout = false;
        this.cQP = -1;
        this.cQQ = Long.MIN_VALUE;
        this.cxH = -1;
        this.cQR = Long.MIN_VALUE;
        this.cQV = -1;
        this.cQW = Long.MIN_VALUE;
        this.cRa = false;
        if (!isInEditMode()) {
            this.cQU = (AccessibilityManager) getContext().getSystemService("accessibility");
        }
    }

    public void setOnItemClickListener(c cVar) {
        this.cQN = cVar;
    }

    public final c getOnItemClickListener() {
        return this.cQN;
    }

    public boolean performItemClick(View view, int i, long j) {
        if (this.cQN != null) {
            playSoundEffect(0);
            if (view != null) {
                view.sendAccessibilityEvent(1);
            }
            this.cQN.a(this, view, i, j);
            return true;
        }
        return false;
    }

    public void setOnItemLongClickListener(d dVar) {
        if (!isLongClickable()) {
            setLongClickable(true);
        }
        this.cQO = dVar;
    }

    public final d getOnItemLongClickListener() {
        return this.cQO;
    }

    public void setOnItemSelectedListener(e eVar) {
        this.cQM = eVar;
    }

    public final e getOnItemSelectedListener() {
        return this.cQM;
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
        return this.cQP;
    }

    @ViewDebug.CapturedViewProperty
    public long getSelectedItemId() {
        return this.cQQ;
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
        return this.cQS;
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
                return i + this.bAH;
            }
        }
        return -1;
    }

    public int getFirstVisiblePosition() {
        return this.bAH;
    }

    public int getLastVisiblePosition() {
        return (this.bAH + getChildCount()) - 1;
    }

    public void setEmptyView(View view) {
        this.mEmptyView = view;
        T adapter = getAdapter();
        fw(adapter == null || adapter.isEmpty());
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
        this.cQX = z;
        if (!z) {
            this.cQY = false;
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
        this.cQY = z;
        if (z) {
            this.cQX = true;
        }
        if (!z || (z3 && !isInFilterMode())) {
            z2 = false;
        }
        super.setFocusableInTouchMode(z2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void apU() {
        boolean z = false;
        T adapter = getAdapter();
        boolean z2 = !(adapter == null || adapter.getCount() == 0) || isInFilterMode();
        super.setFocusableInTouchMode(z2 && this.cQY);
        super.setFocusable(z2 && this.cQX);
        if (this.mEmptyView != null) {
            if (adapter == null || adapter.isEmpty()) {
                z = true;
            }
            fw(z);
        }
    }

    private void fw(boolean z) {
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
            if (this.afj) {
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
        private Parcelable cRb = null;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            g.this.afj = true;
            g.this.cQT = g.this.cQS;
            g.this.cQS = g.this.getAdapter().getCount();
            if (g.this.getAdapter().hasStableIds() && this.cRb != null && g.this.cQT == 0 && g.this.cQS > 0) {
                g.this.onRestoreInstanceState(this.cRb);
                this.cRb = null;
            } else {
                g.this.aqb();
            }
            g.this.apU();
            g.this.requestLayout();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            g.this.afj = true;
            if (g.this.getAdapter().hasStableIds()) {
                this.cRb = g.this.onSaveInstanceState();
            }
            g.this.cQT = g.this.cQS;
            g.this.cQS = 0;
            g.this.cxH = -1;
            g.this.cQR = Long.MIN_VALUE;
            g.this.cQP = -1;
            g.this.cQQ = Long.MIN_VALUE;
            g.this.cQK = false;
            g.this.apU();
            g.this.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.cQZ);
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
            if (g.this.afj) {
                if (g.this.getAdapter() != null) {
                    g.this.post(this);
                    return;
                }
                return;
            }
            g.this.apW();
            g.this.apX();
        }
    }

    void apV() {
        if (this.cQM != null || this.cQU.isEnabled()) {
            if (this.mInLayout || this.cRa) {
                if (this.cQZ == null) {
                    this.cQZ = new f(this, null);
                }
                post(this.cQZ);
                return;
            }
            apW();
            apX();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apW() {
        if (this.cQM != null) {
            int selectedItemPosition = getSelectedItemPosition();
            if (selectedItemPosition >= 0) {
                this.cQM.c(this, getSelectedView(), selectedItemPosition, getAdapter().getItemId(selectedItemPosition));
                return;
            }
            this.cQM.d(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apX() {
        if (this.cQU.isEnabled() && getSelectedItemPosition() >= 0) {
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
        accessibilityNodeInfo.setScrollable(apY());
        View selectedView = getSelectedView();
        if (selectedView != null) {
            accessibilityNodeInfo.setEnabled(selectedView.isEnabled());
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(g.class.getName());
        accessibilityEvent.setScrollable(apY());
        View selectedView = getSelectedView();
        if (selectedView != null) {
            accessibilityEvent.setEnabled(selectedView.isEnabled());
        }
        accessibilityEvent.setCurrentItemIndex(getSelectedItemPosition());
        accessibilityEvent.setFromIndex(getFirstVisiblePosition());
        accessibilityEvent.setToIndex(getLastVisiblePosition());
        accessibilityEvent.setItemCount(getCount());
    }

    private boolean apY() {
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
        return super.canAnimate() && this.cQS > 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void handleDataChanged() {
        boolean z;
        boolean z2;
        int i = this.cQS;
        if (i > 0) {
            if (this.cQK) {
                this.cQK = false;
                int aqa = aqa();
                if (aqa >= 0 && E(aqa, true) == aqa) {
                    setNextSelectedPositionInt(aqa);
                    z2 = true;
                    if (!z2) {
                        int selectedItemPosition = getSelectedItemPosition();
                        if (selectedItemPosition >= i) {
                            selectedItemPosition = i - 1;
                        }
                        if (selectedItemPosition < 0) {
                            selectedItemPosition = 0;
                        }
                        int E = E(selectedItemPosition, true);
                        int E2 = E < 0 ? E(selectedItemPosition, false) : E;
                        if (E2 >= 0) {
                            setNextSelectedPositionInt(E2);
                            apZ();
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
            this.cxH = -1;
            this.cQR = Long.MIN_VALUE;
            this.cQP = -1;
            this.cQQ = Long.MIN_VALUE;
            this.cQK = false;
            apZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void apZ() {
        if (this.cxH != this.cQV || this.cQR != this.cQW) {
            apV();
            this.cQV = this.cxH;
            this.cQW = this.cQR;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int aqa() {
        int i = this.cQS;
        if (i == 0) {
            return -1;
        }
        long j = this.cQI;
        int i2 = this.cQH;
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
    public int E(int i, boolean z) {
        return i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setSelectedPositionInt(int i) {
        this.cxH = i;
        this.cQR = getItemIdAtPosition(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setNextSelectedPositionInt(int i) {
        this.cQP = i;
        this.cQQ = getItemIdAtPosition(i);
        if (this.cQK && this.cQL == 0 && i >= 0) {
            this.cQH = i;
            this.cQI = this.cQQ;
        }
    }

    public void aqb() {
        if (getChildCount() > 0) {
            this.cQK = true;
            this.cQJ = this.mLayoutWidth;
            if (this.cxH >= 0) {
                View childAt = getChildAt(this.cxH - this.bAH);
                this.cQI = this.cQQ;
                this.cQH = this.cQP;
                if (childAt != null) {
                    this.cQG = childAt.getLeft();
                }
                this.cQL = 0;
                return;
            }
            View childAt2 = getChildAt(0);
            T adapter = getAdapter();
            if (this.bAH >= 0 && this.bAH < adapter.getCount()) {
                this.cQI = adapter.getItemId(this.bAH);
            } else {
                this.cQI = -1L;
            }
            this.cQH = this.bAH;
            if (childAt2 != null) {
                this.cQG = childAt2.getLeft();
            }
            this.cQL = 1;
        }
    }
}
