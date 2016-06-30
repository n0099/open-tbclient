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
    public boolean aaZ;
    @ViewDebug.ExportedProperty(category = "scrolling")
    protected int bkE;
    @ViewDebug.ExportedProperty(category = IntentConfig.LIST)
    protected int ceR;
    protected int cwf;
    protected int cwg;
    protected long cwh;
    protected long cwi;
    protected boolean cwj;
    int cwk;
    e cwl;
    c cwm;
    d cwn;
    @ViewDebug.ExportedProperty(category = IntentConfig.LIST)
    protected int cwo;
    protected long cwp;
    protected long cwq;
    @ViewDebug.ExportedProperty(category = IntentConfig.LIST)
    protected int cwr;
    protected int cws;
    AccessibilityManager cwt;
    protected int cwu;
    protected long cwv;
    private boolean cww;
    private boolean cwx;
    private g<T>.f cwy;
    protected boolean cwz;
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
        this.bkE = 0;
        this.cwh = Long.MIN_VALUE;
        this.cwj = false;
        this.mInLayout = false;
        this.cwo = -1;
        this.cwp = Long.MIN_VALUE;
        this.ceR = -1;
        this.cwq = Long.MIN_VALUE;
        this.cwu = -1;
        this.cwv = Long.MIN_VALUE;
        this.cwz = false;
    }

    public g(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bkE = 0;
        this.cwh = Long.MIN_VALUE;
        this.cwj = false;
        this.mInLayout = false;
        this.cwo = -1;
        this.cwp = Long.MIN_VALUE;
        this.ceR = -1;
        this.cwq = Long.MIN_VALUE;
        this.cwu = -1;
        this.cwv = Long.MIN_VALUE;
        this.cwz = false;
    }

    public g(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bkE = 0;
        this.cwh = Long.MIN_VALUE;
        this.cwj = false;
        this.mInLayout = false;
        this.cwo = -1;
        this.cwp = Long.MIN_VALUE;
        this.ceR = -1;
        this.cwq = Long.MIN_VALUE;
        this.cwu = -1;
        this.cwv = Long.MIN_VALUE;
        this.cwz = false;
        if (!isInEditMode()) {
            this.cwt = (AccessibilityManager) getContext().getSystemService("accessibility");
        }
    }

    public void setOnItemClickListener(c cVar) {
        this.cwm = cVar;
    }

    public final c getOnItemClickListener() {
        return this.cwm;
    }

    public boolean performItemClick(View view, int i, long j) {
        if (this.cwm != null) {
            playSoundEffect(0);
            if (view != null) {
                view.sendAccessibilityEvent(1);
            }
            this.cwm.a(this, view, i, j);
            return true;
        }
        return false;
    }

    public void setOnItemLongClickListener(d dVar) {
        if (!isLongClickable()) {
            setLongClickable(true);
        }
        this.cwn = dVar;
    }

    public final d getOnItemLongClickListener() {
        return this.cwn;
    }

    public void setOnItemSelectedListener(e eVar) {
        this.cwl = eVar;
    }

    public final e getOnItemSelectedListener() {
        return this.cwl;
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
        return this.cwo;
    }

    @ViewDebug.CapturedViewProperty
    public long getSelectedItemId() {
        return this.cwp;
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
        return this.cwr;
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
                return i + this.bkE;
            }
        }
        return -1;
    }

    public int getFirstVisiblePosition() {
        return this.bkE;
    }

    public int getLastVisiblePosition() {
        return (this.bkE + getChildCount()) - 1;
    }

    public void setEmptyView(View view) {
        this.mEmptyView = view;
        T adapter = getAdapter();
        eJ(adapter == null || adapter.isEmpty());
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
        this.cww = z;
        if (!z) {
            this.cwx = false;
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
        this.cwx = z;
        if (z) {
            this.cww = true;
        }
        if (!z || (z3 && !isInFilterMode())) {
            z2 = false;
        }
        super.setFocusableInTouchMode(z2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aio() {
        boolean z = false;
        T adapter = getAdapter();
        boolean z2 = !(adapter == null || adapter.getCount() == 0) || isInFilterMode();
        super.setFocusableInTouchMode(z2 && this.cwx);
        super.setFocusable(z2 && this.cww);
        if (this.mEmptyView != null) {
            if (adapter == null || adapter.isEmpty()) {
                z = true;
            }
            eJ(z);
        }
    }

    private void eJ(boolean z) {
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
            if (this.aaZ) {
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
        private Parcelable cwA = null;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            g.this.aaZ = true;
            g.this.cws = g.this.cwr;
            g.this.cwr = g.this.getAdapter().getCount();
            if (g.this.getAdapter().hasStableIds() && this.cwA != null && g.this.cws == 0 && g.this.cwr > 0) {
                g.this.onRestoreInstanceState(this.cwA);
                this.cwA = null;
            } else {
                g.this.aiv();
            }
            g.this.aio();
            g.this.requestLayout();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            g.this.aaZ = true;
            if (g.this.getAdapter().hasStableIds()) {
                this.cwA = g.this.onSaveInstanceState();
            }
            g.this.cws = g.this.cwr;
            g.this.cwr = 0;
            g.this.ceR = -1;
            g.this.cwq = Long.MIN_VALUE;
            g.this.cwo = -1;
            g.this.cwp = Long.MIN_VALUE;
            g.this.cwj = false;
            g.this.aio();
            g.this.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.cwy);
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
            if (g.this.aaZ) {
                if (g.this.getAdapter() != null) {
                    g.this.post(this);
                    return;
                }
                return;
            }
            g.this.aiq();
            g.this.air();
        }
    }

    void aip() {
        if (this.cwl != null || this.cwt.isEnabled()) {
            if (this.mInLayout || this.cwz) {
                if (this.cwy == null) {
                    this.cwy = new f(this, null);
                }
                post(this.cwy);
                return;
            }
            aiq();
            air();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiq() {
        if (this.cwl != null) {
            int selectedItemPosition = getSelectedItemPosition();
            if (selectedItemPosition >= 0) {
                this.cwl.c(this, getSelectedView(), selectedItemPosition, getAdapter().getItemId(selectedItemPosition));
                return;
            }
            this.cwl.d(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void air() {
        if (this.cwt.isEnabled() && getSelectedItemPosition() >= 0) {
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
        accessibilityNodeInfo.setScrollable(ais());
        View selectedView = getSelectedView();
        if (selectedView != null) {
            accessibilityNodeInfo.setEnabled(selectedView.isEnabled());
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(g.class.getName());
        accessibilityEvent.setScrollable(ais());
        View selectedView = getSelectedView();
        if (selectedView != null) {
            accessibilityEvent.setEnabled(selectedView.isEnabled());
        }
        accessibilityEvent.setCurrentItemIndex(getSelectedItemPosition());
        accessibilityEvent.setFromIndex(getFirstVisiblePosition());
        accessibilityEvent.setToIndex(getLastVisiblePosition());
        accessibilityEvent.setItemCount(getCount());
    }

    private boolean ais() {
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
        return super.canAnimate() && this.cwr > 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void handleDataChanged() {
        boolean z;
        boolean z2;
        int i = this.cwr;
        if (i > 0) {
            if (this.cwj) {
                this.cwj = false;
                int aiu = aiu();
                if (aiu >= 0 && B(aiu, true) == aiu) {
                    setNextSelectedPositionInt(aiu);
                    z2 = true;
                    if (!z2) {
                        int selectedItemPosition = getSelectedItemPosition();
                        if (selectedItemPosition >= i) {
                            selectedItemPosition = i - 1;
                        }
                        if (selectedItemPosition < 0) {
                            selectedItemPosition = 0;
                        }
                        int B = B(selectedItemPosition, true);
                        int B2 = B < 0 ? B(selectedItemPosition, false) : B;
                        if (B2 >= 0) {
                            setNextSelectedPositionInt(B2);
                            ait();
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
            this.ceR = -1;
            this.cwq = Long.MIN_VALUE;
            this.cwo = -1;
            this.cwp = Long.MIN_VALUE;
            this.cwj = false;
            ait();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ait() {
        if (this.ceR != this.cwu || this.cwq != this.cwv) {
            aip();
            this.cwu = this.ceR;
            this.cwv = this.cwq;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int aiu() {
        int i = this.cwr;
        if (i == 0) {
            return -1;
        }
        long j = this.cwh;
        int i2 = this.cwg;
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
    public int B(int i, boolean z) {
        return i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setSelectedPositionInt(int i) {
        this.ceR = i;
        this.cwq = getItemIdAtPosition(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setNextSelectedPositionInt(int i) {
        this.cwo = i;
        this.cwp = getItemIdAtPosition(i);
        if (this.cwj && this.cwk == 0 && i >= 0) {
            this.cwg = i;
            this.cwh = this.cwp;
        }
    }

    public void aiv() {
        if (getChildCount() > 0) {
            this.cwj = true;
            this.cwi = this.mLayoutWidth;
            if (this.ceR >= 0) {
                View childAt = getChildAt(this.ceR - this.bkE);
                this.cwh = this.cwp;
                this.cwg = this.cwo;
                if (childAt != null) {
                    this.cwf = childAt.getLeft();
                }
                this.cwk = 0;
                return;
            }
            View childAt2 = getChildAt(0);
            T adapter = getAdapter();
            if (this.bkE >= 0 && this.bkE < adapter.getCount()) {
                this.cwh = adapter.getItemId(this.bkE);
            } else {
                this.cwh = -1L;
            }
            this.cwg = this.bkE;
            if (childAt2 != null) {
                this.cwf = childAt2.getLeft();
            }
            this.cwk = 1;
        }
    }
}
