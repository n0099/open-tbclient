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
    public boolean aeL;
    @ViewDebug.ExportedProperty(category = "scrolling")
    protected int bxM;
    protected long cLA;
    protected long cLB;
    @ViewDebug.ExportedProperty(category = IntentConfig.LIST)
    protected int cLC;
    protected int cLD;
    AccessibilityManager cLE;
    protected int cLF;
    protected long cLG;
    private boolean cLH;
    private boolean cLI;
    private g<T>.f cLJ;
    protected boolean cLK;
    protected int cLq;
    protected int cLr;
    protected long cLs;
    protected long cLt;
    protected boolean cLu;
    int cLv;
    e cLw;
    c cLx;
    d cLy;
    @ViewDebug.ExportedProperty(category = IntentConfig.LIST)
    protected int cLz;
    @ViewDebug.ExportedProperty(category = IntentConfig.LIST)
    protected int csC;
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
        this.bxM = 0;
        this.cLs = Long.MIN_VALUE;
        this.cLu = false;
        this.mInLayout = false;
        this.cLz = -1;
        this.cLA = Long.MIN_VALUE;
        this.csC = -1;
        this.cLB = Long.MIN_VALUE;
        this.cLF = -1;
        this.cLG = Long.MIN_VALUE;
        this.cLK = false;
    }

    public g(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bxM = 0;
        this.cLs = Long.MIN_VALUE;
        this.cLu = false;
        this.mInLayout = false;
        this.cLz = -1;
        this.cLA = Long.MIN_VALUE;
        this.csC = -1;
        this.cLB = Long.MIN_VALUE;
        this.cLF = -1;
        this.cLG = Long.MIN_VALUE;
        this.cLK = false;
    }

    public g(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bxM = 0;
        this.cLs = Long.MIN_VALUE;
        this.cLu = false;
        this.mInLayout = false;
        this.cLz = -1;
        this.cLA = Long.MIN_VALUE;
        this.csC = -1;
        this.cLB = Long.MIN_VALUE;
        this.cLF = -1;
        this.cLG = Long.MIN_VALUE;
        this.cLK = false;
        if (!isInEditMode()) {
            this.cLE = (AccessibilityManager) getContext().getSystemService("accessibility");
        }
    }

    public void setOnItemClickListener(c cVar) {
        this.cLx = cVar;
    }

    public final c getOnItemClickListener() {
        return this.cLx;
    }

    public boolean performItemClick(View view, int i, long j) {
        if (this.cLx != null) {
            playSoundEffect(0);
            if (view != null) {
                view.sendAccessibilityEvent(1);
            }
            this.cLx.a(this, view, i, j);
            return true;
        }
        return false;
    }

    public void setOnItemLongClickListener(d dVar) {
        if (!isLongClickable()) {
            setLongClickable(true);
        }
        this.cLy = dVar;
    }

    public final d getOnItemLongClickListener() {
        return this.cLy;
    }

    public void setOnItemSelectedListener(e eVar) {
        this.cLw = eVar;
    }

    public final e getOnItemSelectedListener() {
        return this.cLw;
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
        return this.cLz;
    }

    @ViewDebug.CapturedViewProperty
    public long getSelectedItemId() {
        return this.cLA;
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
        return this.cLC;
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
                return i + this.bxM;
            }
        }
        return -1;
    }

    public int getFirstVisiblePosition() {
        return this.bxM;
    }

    public int getLastVisiblePosition() {
        return (this.bxM + getChildCount()) - 1;
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
        this.cLH = z;
        if (!z) {
            this.cLI = false;
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
        this.cLI = z;
        if (z) {
            this.cLH = true;
        }
        if (!z || (z3 && !isInFilterMode())) {
            z2 = false;
        }
        super.setFocusableInTouchMode(z2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aoa() {
        boolean z = false;
        T adapter = getAdapter();
        boolean z2 = !(adapter == null || adapter.getCount() == 0) || isInFilterMode();
        super.setFocusableInTouchMode(z2 && this.cLI);
        super.setFocusable(z2 && this.cLH);
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
            if (this.aeL) {
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
        private Parcelable cLL = null;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            g.this.aeL = true;
            g.this.cLD = g.this.cLC;
            g.this.cLC = g.this.getAdapter().getCount();
            if (g.this.getAdapter().hasStableIds() && this.cLL != null && g.this.cLD == 0 && g.this.cLC > 0) {
                g.this.onRestoreInstanceState(this.cLL);
                this.cLL = null;
            } else {
                g.this.aoh();
            }
            g.this.aoa();
            g.this.requestLayout();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            g.this.aeL = true;
            if (g.this.getAdapter().hasStableIds()) {
                this.cLL = g.this.onSaveInstanceState();
            }
            g.this.cLD = g.this.cLC;
            g.this.cLC = 0;
            g.this.csC = -1;
            g.this.cLB = Long.MIN_VALUE;
            g.this.cLz = -1;
            g.this.cLA = Long.MIN_VALUE;
            g.this.cLu = false;
            g.this.aoa();
            g.this.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.cLJ);
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
            if (g.this.aeL) {
                if (g.this.getAdapter() != null) {
                    g.this.post(this);
                    return;
                }
                return;
            }
            g.this.aoc();
            g.this.aod();
        }
    }

    void aob() {
        if (this.cLw != null || this.cLE.isEnabled()) {
            if (this.mInLayout || this.cLK) {
                if (this.cLJ == null) {
                    this.cLJ = new f(this, null);
                }
                post(this.cLJ);
                return;
            }
            aoc();
            aod();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoc() {
        if (this.cLw != null) {
            int selectedItemPosition = getSelectedItemPosition();
            if (selectedItemPosition >= 0) {
                this.cLw.c(this, getSelectedView(), selectedItemPosition, getAdapter().getItemId(selectedItemPosition));
                return;
            }
            this.cLw.d(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aod() {
        if (this.cLE.isEnabled() && getSelectedItemPosition() >= 0) {
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
        accessibilityNodeInfo.setScrollable(aoe());
        View selectedView = getSelectedView();
        if (selectedView != null) {
            accessibilityNodeInfo.setEnabled(selectedView.isEnabled());
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(g.class.getName());
        accessibilityEvent.setScrollable(aoe());
        View selectedView = getSelectedView();
        if (selectedView != null) {
            accessibilityEvent.setEnabled(selectedView.isEnabled());
        }
        accessibilityEvent.setCurrentItemIndex(getSelectedItemPosition());
        accessibilityEvent.setFromIndex(getFirstVisiblePosition());
        accessibilityEvent.setToIndex(getLastVisiblePosition());
        accessibilityEvent.setItemCount(getCount());
    }

    private boolean aoe() {
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
        return super.canAnimate() && this.cLC > 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void handleDataChanged() {
        boolean z;
        boolean z2;
        int i = this.cLC;
        if (i > 0) {
            if (this.cLu) {
                this.cLu = false;
                int aog = aog();
                if (aog >= 0 && C(aog, true) == aog) {
                    setNextSelectedPositionInt(aog);
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
                            aof();
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
            this.csC = -1;
            this.cLB = Long.MIN_VALUE;
            this.cLz = -1;
            this.cLA = Long.MIN_VALUE;
            this.cLu = false;
            aof();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aof() {
        if (this.csC != this.cLF || this.cLB != this.cLG) {
            aob();
            this.cLF = this.csC;
            this.cLG = this.cLB;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int aog() {
        int i = this.cLC;
        if (i == 0) {
            return -1;
        }
        long j = this.cLs;
        int i2 = this.cLr;
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
        this.csC = i;
        this.cLB = getItemIdAtPosition(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setNextSelectedPositionInt(int i) {
        this.cLz = i;
        this.cLA = getItemIdAtPosition(i);
        if (this.cLu && this.cLv == 0 && i >= 0) {
            this.cLr = i;
            this.cLs = this.cLA;
        }
    }

    public void aoh() {
        if (getChildCount() > 0) {
            this.cLu = true;
            this.cLt = this.mLayoutWidth;
            if (this.csC >= 0) {
                View childAt = getChildAt(this.csC - this.bxM);
                this.cLs = this.cLA;
                this.cLr = this.cLz;
                if (childAt != null) {
                    this.cLq = childAt.getLeft();
                }
                this.cLv = 0;
                return;
            }
            View childAt2 = getChildAt(0);
            T adapter = getAdapter();
            if (this.bxM >= 0 && this.bxM < adapter.getCount()) {
                this.cLs = adapter.getItemId(this.bxM);
            } else {
                this.cLs = -1L;
            }
            this.cLr = this.bxM;
            if (childAt2 != null) {
                this.cLq = childAt2.getLeft();
            }
            this.cLv = 1;
        }
    }
}
