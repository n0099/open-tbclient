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
    public boolean aeC;
    @ViewDebug.ExportedProperty(category = IntentConfig.LIST)
    protected int ccS;
    @ViewDebug.ExportedProperty(category = "scrolling")
    protected int cvM;
    protected int cvN;
    protected int cvO;
    protected long cvP;
    protected long cvQ;
    protected boolean cvR;
    int cvS;
    e cvT;
    c cvU;
    d cvV;
    @ViewDebug.ExportedProperty(category = IntentConfig.LIST)
    protected int cvW;
    protected long cvX;
    protected long cvY;
    @ViewDebug.ExportedProperty(category = IntentConfig.LIST)
    protected int cvZ;
    protected int cwa;
    AccessibilityManager cwb;
    protected int cwc;
    protected long cwd;
    private boolean cwe;
    private boolean cwf;
    private g<T>.f cwg;
    protected boolean cwh;
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
        this.cvM = 0;
        this.cvP = Long.MIN_VALUE;
        this.cvR = false;
        this.mInLayout = false;
        this.cvW = -1;
        this.cvX = Long.MIN_VALUE;
        this.ccS = -1;
        this.cvY = Long.MIN_VALUE;
        this.cwc = -1;
        this.cwd = Long.MIN_VALUE;
        this.cwh = false;
    }

    public g(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cvM = 0;
        this.cvP = Long.MIN_VALUE;
        this.cvR = false;
        this.mInLayout = false;
        this.cvW = -1;
        this.cvX = Long.MIN_VALUE;
        this.ccS = -1;
        this.cvY = Long.MIN_VALUE;
        this.cwc = -1;
        this.cwd = Long.MIN_VALUE;
        this.cwh = false;
    }

    public g(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cvM = 0;
        this.cvP = Long.MIN_VALUE;
        this.cvR = false;
        this.mInLayout = false;
        this.cvW = -1;
        this.cvX = Long.MIN_VALUE;
        this.ccS = -1;
        this.cvY = Long.MIN_VALUE;
        this.cwc = -1;
        this.cwd = Long.MIN_VALUE;
        this.cwh = false;
        if (!isInEditMode()) {
            this.cwb = (AccessibilityManager) getContext().getSystemService("accessibility");
        }
    }

    public void setOnItemClickListener(c cVar) {
        this.cvU = cVar;
    }

    public final c getOnItemClickListener() {
        return this.cvU;
    }

    public boolean performItemClick(View view, int i, long j) {
        if (this.cvU != null) {
            playSoundEffect(0);
            if (view != null) {
                view.sendAccessibilityEvent(1);
            }
            this.cvU.a(this, view, i, j);
            return true;
        }
        return false;
    }

    public void setOnItemLongClickListener(d dVar) {
        if (!isLongClickable()) {
            setLongClickable(true);
        }
        this.cvV = dVar;
    }

    public final d getOnItemLongClickListener() {
        return this.cvV;
    }

    public void setOnItemSelectedListener(e eVar) {
        this.cvT = eVar;
    }

    public final e getOnItemSelectedListener() {
        return this.cvT;
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
        return this.cvW;
    }

    @ViewDebug.CapturedViewProperty
    public long getSelectedItemId() {
        return this.cvX;
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
        return this.cvZ;
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
                return i + this.cvM;
            }
        }
        return -1;
    }

    public int getFirstVisiblePosition() {
        return this.cvM;
    }

    public int getLastVisiblePosition() {
        return (this.cvM + getChildCount()) - 1;
    }

    public void setEmptyView(View view) {
        this.mEmptyView = view;
        T adapter = getAdapter();
        fh(adapter == null || adapter.isEmpty());
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
        this.cwe = z;
        if (!z) {
            this.cwf = false;
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
        this.cwf = z;
        if (z) {
            this.cwe = true;
        }
        if (!z || (z3 && !isInFilterMode())) {
            z2 = false;
        }
        super.setFocusableInTouchMode(z2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void akw() {
        boolean z = false;
        T adapter = getAdapter();
        boolean z2 = !(adapter == null || adapter.getCount() == 0) || isInFilterMode();
        super.setFocusableInTouchMode(z2 && this.cwf);
        super.setFocusable(z2 && this.cwe);
        if (this.mEmptyView != null) {
            if (adapter == null || adapter.isEmpty()) {
                z = true;
            }
            fh(z);
        }
    }

    private void fh(boolean z) {
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
            if (this.aeC) {
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
        private Parcelable cwi = null;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            g.this.aeC = true;
            g.this.cwa = g.this.cvZ;
            g.this.cvZ = g.this.getAdapter().getCount();
            if (g.this.getAdapter().hasStableIds() && this.cwi != null && g.this.cwa == 0 && g.this.cvZ > 0) {
                g.this.onRestoreInstanceState(this.cwi);
                this.cwi = null;
            } else {
                g.this.akD();
            }
            g.this.akw();
            g.this.requestLayout();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            g.this.aeC = true;
            if (g.this.getAdapter().hasStableIds()) {
                this.cwi = g.this.onSaveInstanceState();
            }
            g.this.cwa = g.this.cvZ;
            g.this.cvZ = 0;
            g.this.ccS = -1;
            g.this.cvY = Long.MIN_VALUE;
            g.this.cvW = -1;
            g.this.cvX = Long.MIN_VALUE;
            g.this.cvR = false;
            g.this.akw();
            g.this.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.cwg);
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
            if (g.this.aeC) {
                if (g.this.getAdapter() != null) {
                    g.this.post(this);
                    return;
                }
                return;
            }
            g.this.aky();
            g.this.akz();
        }
    }

    void akx() {
        if (this.cvT != null || this.cwb.isEnabled()) {
            if (this.mInLayout || this.cwh) {
                if (this.cwg == null) {
                    this.cwg = new f(this, null);
                }
                post(this.cwg);
                return;
            }
            aky();
            akz();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aky() {
        if (this.cvT != null) {
            int selectedItemPosition = getSelectedItemPosition();
            if (selectedItemPosition >= 0) {
                this.cvT.c(this, getSelectedView(), selectedItemPosition, getAdapter().getItemId(selectedItemPosition));
                return;
            }
            this.cvT.d(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akz() {
        if (this.cwb.isEnabled() && getSelectedItemPosition() >= 0) {
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
        accessibilityNodeInfo.setScrollable(akA());
        View selectedView = getSelectedView();
        if (selectedView != null) {
            accessibilityNodeInfo.setEnabled(selectedView.isEnabled());
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(g.class.getName());
        accessibilityEvent.setScrollable(akA());
        View selectedView = getSelectedView();
        if (selectedView != null) {
            accessibilityEvent.setEnabled(selectedView.isEnabled());
        }
        accessibilityEvent.setCurrentItemIndex(getSelectedItemPosition());
        accessibilityEvent.setFromIndex(getFirstVisiblePosition());
        accessibilityEvent.setToIndex(getLastVisiblePosition());
        accessibilityEvent.setItemCount(getCount());
    }

    private boolean akA() {
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
        return super.canAnimate() && this.cvZ > 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void handleDataChanged() {
        boolean z;
        boolean z2;
        int i = this.cvZ;
        if (i > 0) {
            if (this.cvR) {
                this.cvR = false;
                int akC = akC();
                if (akC >= 0 && r(akC, true) == akC) {
                    setNextSelectedPositionInt(akC);
                    z2 = true;
                    if (!z2) {
                        int selectedItemPosition = getSelectedItemPosition();
                        if (selectedItemPosition >= i) {
                            selectedItemPosition = i - 1;
                        }
                        if (selectedItemPosition < 0) {
                            selectedItemPosition = 0;
                        }
                        int r = r(selectedItemPosition, true);
                        int r2 = r < 0 ? r(selectedItemPosition, false) : r;
                        if (r2 >= 0) {
                            setNextSelectedPositionInt(r2);
                            akB();
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
            this.ccS = -1;
            this.cvY = Long.MIN_VALUE;
            this.cvW = -1;
            this.cvX = Long.MIN_VALUE;
            this.cvR = false;
            akB();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void akB() {
        if (this.ccS != this.cwc || this.cvY != this.cwd) {
            akx();
            this.cwc = this.ccS;
            this.cwd = this.cvY;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int akC() {
        int i = this.cvZ;
        if (i == 0) {
            return -1;
        }
        long j = this.cvP;
        int i2 = this.cvO;
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
    public int r(int i, boolean z) {
        return i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setSelectedPositionInt(int i) {
        this.ccS = i;
        this.cvY = getItemIdAtPosition(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setNextSelectedPositionInt(int i) {
        this.cvW = i;
        this.cvX = getItemIdAtPosition(i);
        if (this.cvR && this.cvS == 0 && i >= 0) {
            this.cvO = i;
            this.cvP = this.cvX;
        }
    }

    public void akD() {
        if (getChildCount() > 0) {
            this.cvR = true;
            this.cvQ = this.mLayoutWidth;
            if (this.ccS >= 0) {
                View childAt = getChildAt(this.ccS - this.cvM);
                this.cvP = this.cvX;
                this.cvO = this.cvW;
                if (childAt != null) {
                    this.cvN = childAt.getLeft();
                }
                this.cvS = 0;
                return;
            }
            View childAt2 = getChildAt(0);
            T adapter = getAdapter();
            if (this.cvM >= 0 && this.cvM < adapter.getCount()) {
                this.cvP = adapter.getItemId(this.cvM);
            } else {
                this.cvP = -1L;
            }
            this.cvO = this.cvM;
            if (childAt2 != null) {
                this.cvN = childAt2.getLeft();
            }
            this.cvS = 1;
        }
    }
}
