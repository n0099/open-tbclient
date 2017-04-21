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
    public boolean ajr;
    @ViewDebug.ExportedProperty(category = "scrolling")
    protected int cFc;
    protected int cFd;
    protected int cFe;
    protected long cFf;
    protected long cFg;
    protected boolean cFh;
    int cFi;
    e cFj;
    c cFk;
    d cFl;
    @ViewDebug.ExportedProperty(category = IntentConfig.LIST)
    protected int cFm;
    protected long cFn;
    protected long cFo;
    @ViewDebug.ExportedProperty(category = IntentConfig.LIST)
    protected int cFp;
    protected int cFq;
    AccessibilityManager cFr;
    protected int cFs;
    protected long cFt;
    private boolean cFu;
    private boolean cFv;
    private g<T>.f cFw;
    protected boolean cFx;
    @ViewDebug.ExportedProperty(category = IntentConfig.LIST)
    protected int clD;
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
        this.cFc = 0;
        this.cFf = Long.MIN_VALUE;
        this.cFh = false;
        this.mInLayout = false;
        this.cFm = -1;
        this.cFn = Long.MIN_VALUE;
        this.clD = -1;
        this.cFo = Long.MIN_VALUE;
        this.cFs = -1;
        this.cFt = Long.MIN_VALUE;
        this.cFx = false;
    }

    public g(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cFc = 0;
        this.cFf = Long.MIN_VALUE;
        this.cFh = false;
        this.mInLayout = false;
        this.cFm = -1;
        this.cFn = Long.MIN_VALUE;
        this.clD = -1;
        this.cFo = Long.MIN_VALUE;
        this.cFs = -1;
        this.cFt = Long.MIN_VALUE;
        this.cFx = false;
    }

    public g(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cFc = 0;
        this.cFf = Long.MIN_VALUE;
        this.cFh = false;
        this.mInLayout = false;
        this.cFm = -1;
        this.cFn = Long.MIN_VALUE;
        this.clD = -1;
        this.cFo = Long.MIN_VALUE;
        this.cFs = -1;
        this.cFt = Long.MIN_VALUE;
        this.cFx = false;
        if (!isInEditMode()) {
            this.cFr = (AccessibilityManager) getContext().getSystemService("accessibility");
        }
    }

    public void setOnItemClickListener(c cVar) {
        this.cFk = cVar;
    }

    public final c getOnItemClickListener() {
        return this.cFk;
    }

    public boolean performItemClick(View view, int i, long j) {
        if (this.cFk != null) {
            playSoundEffect(0);
            if (view != null) {
                view.sendAccessibilityEvent(1);
            }
            this.cFk.a(this, view, i, j);
            return true;
        }
        return false;
    }

    public void setOnItemLongClickListener(d dVar) {
        if (!isLongClickable()) {
            setLongClickable(true);
        }
        this.cFl = dVar;
    }

    public final d getOnItemLongClickListener() {
        return this.cFl;
    }

    public void setOnItemSelectedListener(e eVar) {
        this.cFj = eVar;
    }

    public final e getOnItemSelectedListener() {
        return this.cFj;
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
        return this.cFm;
    }

    @ViewDebug.CapturedViewProperty
    public long getSelectedItemId() {
        return this.cFn;
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
        return this.cFp;
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
                return i + this.cFc;
            }
        }
        return -1;
    }

    public int getFirstVisiblePosition() {
        return this.cFc;
    }

    public int getLastVisiblePosition() {
        return (this.cFc + getChildCount()) - 1;
    }

    public void setEmptyView(View view) {
        this.mEmptyView = view;
        T adapter = getAdapter();
        fm(adapter == null || adapter.isEmpty());
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
        this.cFu = z;
        if (!z) {
            this.cFv = false;
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
        this.cFv = z;
        if (z) {
            this.cFu = true;
        }
        if (!z || (z3 && !isInFilterMode())) {
            z2 = false;
        }
        super.setFocusableInTouchMode(z2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void alK() {
        boolean z = false;
        T adapter = getAdapter();
        boolean z2 = !(adapter == null || adapter.getCount() == 0) || isInFilterMode();
        super.setFocusableInTouchMode(z2 && this.cFv);
        super.setFocusable(z2 && this.cFu);
        if (this.mEmptyView != null) {
            if (adapter == null || adapter.isEmpty()) {
                z = true;
            }
            fm(z);
        }
    }

    private void fm(boolean z) {
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
            if (this.ajr) {
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
        private Parcelable cFy = null;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            g.this.ajr = true;
            g.this.cFq = g.this.cFp;
            g.this.cFp = g.this.getAdapter().getCount();
            if (g.this.getAdapter().hasStableIds() && this.cFy != null && g.this.cFq == 0 && g.this.cFp > 0) {
                g.this.onRestoreInstanceState(this.cFy);
                this.cFy = null;
            } else {
                g.this.alR();
            }
            g.this.alK();
            g.this.requestLayout();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            g.this.ajr = true;
            if (g.this.getAdapter().hasStableIds()) {
                this.cFy = g.this.onSaveInstanceState();
            }
            g.this.cFq = g.this.cFp;
            g.this.cFp = 0;
            g.this.clD = -1;
            g.this.cFo = Long.MIN_VALUE;
            g.this.cFm = -1;
            g.this.cFn = Long.MIN_VALUE;
            g.this.cFh = false;
            g.this.alK();
            g.this.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.cFw);
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
            if (g.this.ajr) {
                if (g.this.getAdapter() != null) {
                    g.this.post(this);
                    return;
                }
                return;
            }
            g.this.alM();
            g.this.alN();
        }
    }

    void alL() {
        if (this.cFj != null || this.cFr.isEnabled()) {
            if (this.mInLayout || this.cFx) {
                if (this.cFw == null) {
                    this.cFw = new f(this, null);
                }
                post(this.cFw);
                return;
            }
            alM();
            alN();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alM() {
        if (this.cFj != null) {
            int selectedItemPosition = getSelectedItemPosition();
            if (selectedItemPosition >= 0) {
                this.cFj.c(this, getSelectedView(), selectedItemPosition, getAdapter().getItemId(selectedItemPosition));
                return;
            }
            this.cFj.d(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alN() {
        if (this.cFr.isEnabled() && getSelectedItemPosition() >= 0) {
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
        accessibilityNodeInfo.setScrollable(alO());
        View selectedView = getSelectedView();
        if (selectedView != null) {
            accessibilityNodeInfo.setEnabled(selectedView.isEnabled());
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(g.class.getName());
        accessibilityEvent.setScrollable(alO());
        View selectedView = getSelectedView();
        if (selectedView != null) {
            accessibilityEvent.setEnabled(selectedView.isEnabled());
        }
        accessibilityEvent.setCurrentItemIndex(getSelectedItemPosition());
        accessibilityEvent.setFromIndex(getFirstVisiblePosition());
        accessibilityEvent.setToIndex(getLastVisiblePosition());
        accessibilityEvent.setItemCount(getCount());
    }

    private boolean alO() {
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
        return super.canAnimate() && this.cFp > 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void handleDataChanged() {
        boolean z;
        boolean z2;
        int i = this.cFp;
        if (i > 0) {
            if (this.cFh) {
                this.cFh = false;
                int alQ = alQ();
                if (alQ >= 0 && q(alQ, true) == alQ) {
                    setNextSelectedPositionInt(alQ);
                    z2 = true;
                    if (!z2) {
                        int selectedItemPosition = getSelectedItemPosition();
                        if (selectedItemPosition >= i) {
                            selectedItemPosition = i - 1;
                        }
                        if (selectedItemPosition < 0) {
                            selectedItemPosition = 0;
                        }
                        int q = q(selectedItemPosition, true);
                        int q2 = q < 0 ? q(selectedItemPosition, false) : q;
                        if (q2 >= 0) {
                            setNextSelectedPositionInt(q2);
                            alP();
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
            this.clD = -1;
            this.cFo = Long.MIN_VALUE;
            this.cFm = -1;
            this.cFn = Long.MIN_VALUE;
            this.cFh = false;
            alP();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void alP() {
        if (this.clD != this.cFs || this.cFo != this.cFt) {
            alL();
            this.cFs = this.clD;
            this.cFt = this.cFo;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int alQ() {
        int i = this.cFp;
        if (i == 0) {
            return -1;
        }
        long j = this.cFf;
        int i2 = this.cFe;
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
    public int q(int i, boolean z) {
        return i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setSelectedPositionInt(int i) {
        this.clD = i;
        this.cFo = getItemIdAtPosition(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setNextSelectedPositionInt(int i) {
        this.cFm = i;
        this.cFn = getItemIdAtPosition(i);
        if (this.cFh && this.cFi == 0 && i >= 0) {
            this.cFe = i;
            this.cFf = this.cFn;
        }
    }

    public void alR() {
        if (getChildCount() > 0) {
            this.cFh = true;
            this.cFg = this.mLayoutWidth;
            if (this.clD >= 0) {
                View childAt = getChildAt(this.clD - this.cFc);
                this.cFf = this.cFn;
                this.cFe = this.cFm;
                if (childAt != null) {
                    this.cFd = childAt.getLeft();
                }
                this.cFi = 0;
                return;
            }
            View childAt2 = getChildAt(0);
            T adapter = getAdapter();
            if (this.cFc >= 0 && this.cFc < adapter.getCount()) {
                this.cFf = adapter.getItemId(this.cFc);
            } else {
                this.cFf = -1L;
            }
            this.cFe = this.cFc;
            if (childAt2 != null) {
                this.cFd = childAt2.getLeft();
            }
            this.cFi = 1;
        }
    }
}
