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
    public boolean aeA;
    @ViewDebug.ExportedProperty(category = "scrolling")
    protected int bxA;
    protected int cKA;
    protected long cKB;
    protected long cKC;
    protected boolean cKD;
    int cKE;
    e cKF;
    c cKG;
    d cKH;
    @ViewDebug.ExportedProperty(category = IntentConfig.LIST)
    protected int cKI;
    protected long cKJ;
    protected long cKK;
    @ViewDebug.ExportedProperty(category = IntentConfig.LIST)
    protected int cKL;
    protected int cKM;
    AccessibilityManager cKN;
    protected int cKO;
    protected long cKP;
    private boolean cKQ;
    private boolean cKR;
    private g<T>.f cKS;
    protected boolean cKT;
    protected int cKz;
    @ViewDebug.ExportedProperty(category = IntentConfig.LIST)
    protected int csf;
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
        this.bxA = 0;
        this.cKB = Long.MIN_VALUE;
        this.cKD = false;
        this.mInLayout = false;
        this.cKI = -1;
        this.cKJ = Long.MIN_VALUE;
        this.csf = -1;
        this.cKK = Long.MIN_VALUE;
        this.cKO = -1;
        this.cKP = Long.MIN_VALUE;
        this.cKT = false;
    }

    public g(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bxA = 0;
        this.cKB = Long.MIN_VALUE;
        this.cKD = false;
        this.mInLayout = false;
        this.cKI = -1;
        this.cKJ = Long.MIN_VALUE;
        this.csf = -1;
        this.cKK = Long.MIN_VALUE;
        this.cKO = -1;
        this.cKP = Long.MIN_VALUE;
        this.cKT = false;
    }

    public g(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bxA = 0;
        this.cKB = Long.MIN_VALUE;
        this.cKD = false;
        this.mInLayout = false;
        this.cKI = -1;
        this.cKJ = Long.MIN_VALUE;
        this.csf = -1;
        this.cKK = Long.MIN_VALUE;
        this.cKO = -1;
        this.cKP = Long.MIN_VALUE;
        this.cKT = false;
        if (!isInEditMode()) {
            this.cKN = (AccessibilityManager) getContext().getSystemService("accessibility");
        }
    }

    public void setOnItemClickListener(c cVar) {
        this.cKG = cVar;
    }

    public final c getOnItemClickListener() {
        return this.cKG;
    }

    public boolean performItemClick(View view, int i, long j) {
        if (this.cKG != null) {
            playSoundEffect(0);
            if (view != null) {
                view.sendAccessibilityEvent(1);
            }
            this.cKG.a(this, view, i, j);
            return true;
        }
        return false;
    }

    public void setOnItemLongClickListener(d dVar) {
        if (!isLongClickable()) {
            setLongClickable(true);
        }
        this.cKH = dVar;
    }

    public final d getOnItemLongClickListener() {
        return this.cKH;
    }

    public void setOnItemSelectedListener(e eVar) {
        this.cKF = eVar;
    }

    public final e getOnItemSelectedListener() {
        return this.cKF;
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
        return this.cKI;
    }

    @ViewDebug.CapturedViewProperty
    public long getSelectedItemId() {
        return this.cKJ;
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
        return this.cKL;
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
                return i + this.bxA;
            }
        }
        return -1;
    }

    public int getFirstVisiblePosition() {
        return this.bxA;
    }

    public int getLastVisiblePosition() {
        return (this.bxA + getChildCount()) - 1;
    }

    public void setEmptyView(View view) {
        this.mEmptyView = view;
        T adapter = getAdapter();
        fg(adapter == null || adapter.isEmpty());
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
        this.cKQ = z;
        if (!z) {
            this.cKR = false;
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
        this.cKR = z;
        if (z) {
            this.cKQ = true;
        }
        if (!z || (z3 && !isInFilterMode())) {
            z2 = false;
        }
        super.setFocusableInTouchMode(z2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void anM() {
        boolean z = false;
        T adapter = getAdapter();
        boolean z2 = !(adapter == null || adapter.getCount() == 0) || isInFilterMode();
        super.setFocusableInTouchMode(z2 && this.cKR);
        super.setFocusable(z2 && this.cKQ);
        if (this.mEmptyView != null) {
            if (adapter == null || adapter.isEmpty()) {
                z = true;
            }
            fg(z);
        }
    }

    private void fg(boolean z) {
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
            if (this.aeA) {
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
        private Parcelable cKU = null;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            g.this.aeA = true;
            g.this.cKM = g.this.cKL;
            g.this.cKL = g.this.getAdapter().getCount();
            if (g.this.getAdapter().hasStableIds() && this.cKU != null && g.this.cKM == 0 && g.this.cKL > 0) {
                g.this.onRestoreInstanceState(this.cKU);
                this.cKU = null;
            } else {
                g.this.anT();
            }
            g.this.anM();
            g.this.requestLayout();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            g.this.aeA = true;
            if (g.this.getAdapter().hasStableIds()) {
                this.cKU = g.this.onSaveInstanceState();
            }
            g.this.cKM = g.this.cKL;
            g.this.cKL = 0;
            g.this.csf = -1;
            g.this.cKK = Long.MIN_VALUE;
            g.this.cKI = -1;
            g.this.cKJ = Long.MIN_VALUE;
            g.this.cKD = false;
            g.this.anM();
            g.this.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.cKS);
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
            if (g.this.aeA) {
                if (g.this.getAdapter() != null) {
                    g.this.post(this);
                    return;
                }
                return;
            }
            g.this.anO();
            g.this.anP();
        }
    }

    void anN() {
        if (this.cKF != null || this.cKN.isEnabled()) {
            if (this.mInLayout || this.cKT) {
                if (this.cKS == null) {
                    this.cKS = new f(this, null);
                }
                post(this.cKS);
                return;
            }
            anO();
            anP();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anO() {
        if (this.cKF != null) {
            int selectedItemPosition = getSelectedItemPosition();
            if (selectedItemPosition >= 0) {
                this.cKF.c(this, getSelectedView(), selectedItemPosition, getAdapter().getItemId(selectedItemPosition));
                return;
            }
            this.cKF.d(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anP() {
        if (this.cKN.isEnabled() && getSelectedItemPosition() >= 0) {
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
        accessibilityNodeInfo.setScrollable(anQ());
        View selectedView = getSelectedView();
        if (selectedView != null) {
            accessibilityNodeInfo.setEnabled(selectedView.isEnabled());
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(g.class.getName());
        accessibilityEvent.setScrollable(anQ());
        View selectedView = getSelectedView();
        if (selectedView != null) {
            accessibilityEvent.setEnabled(selectedView.isEnabled());
        }
        accessibilityEvent.setCurrentItemIndex(getSelectedItemPosition());
        accessibilityEvent.setFromIndex(getFirstVisiblePosition());
        accessibilityEvent.setToIndex(getLastVisiblePosition());
        accessibilityEvent.setItemCount(getCount());
    }

    private boolean anQ() {
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
        return super.canAnimate() && this.cKL > 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void handleDataChanged() {
        boolean z;
        boolean z2;
        int i = this.cKL;
        if (i > 0) {
            if (this.cKD) {
                this.cKD = false;
                int anS = anS();
                if (anS >= 0 && C(anS, true) == anS) {
                    setNextSelectedPositionInt(anS);
                    z2 = true;
                    if (!z2) {
                        int selectedItemPosition = getSelectedItemPosition();
                        if (selectedItemPosition >= i) {
                            selectedItemPosition = i - 1;
                        }
                        if (selectedItemPosition < 0) {
                            selectedItemPosition = 0;
                        }
                        int C = C(selectedItemPosition, true);
                        int C2 = C < 0 ? C(selectedItemPosition, false) : C;
                        if (C2 >= 0) {
                            setNextSelectedPositionInt(C2);
                            anR();
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
            this.csf = -1;
            this.cKK = Long.MIN_VALUE;
            this.cKI = -1;
            this.cKJ = Long.MIN_VALUE;
            this.cKD = false;
            anR();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void anR() {
        if (this.csf != this.cKO || this.cKK != this.cKP) {
            anN();
            this.cKO = this.csf;
            this.cKP = this.cKK;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int anS() {
        int i = this.cKL;
        if (i == 0) {
            return -1;
        }
        long j = this.cKB;
        int i2 = this.cKA;
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
    public int C(int i, boolean z) {
        return i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setSelectedPositionInt(int i) {
        this.csf = i;
        this.cKK = getItemIdAtPosition(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setNextSelectedPositionInt(int i) {
        this.cKI = i;
        this.cKJ = getItemIdAtPosition(i);
        if (this.cKD && this.cKE == 0 && i >= 0) {
            this.cKA = i;
            this.cKB = this.cKJ;
        }
    }

    public void anT() {
        if (getChildCount() > 0) {
            this.cKD = true;
            this.cKC = this.mLayoutWidth;
            if (this.csf >= 0) {
                View childAt = getChildAt(this.csf - this.bxA);
                this.cKB = this.cKJ;
                this.cKA = this.cKI;
                if (childAt != null) {
                    this.cKz = childAt.getLeft();
                }
                this.cKE = 0;
                return;
            }
            View childAt2 = getChildAt(0);
            T adapter = getAdapter();
            if (this.bxA >= 0 && this.bxA < adapter.getCount()) {
                this.cKB = adapter.getItemId(this.bxA);
            } else {
                this.cKB = -1L;
            }
            this.cKA = this.bxA;
            if (childAt2 != null) {
                this.cKz = childAt2.getLeft();
            }
            this.cKE = 1;
        }
    }
}
