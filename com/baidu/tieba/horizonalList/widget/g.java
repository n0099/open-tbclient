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
    public boolean adN;
    @ViewDebug.ExportedProperty(category = "scrolling")
    protected int cCQ;
    protected int cCR;
    protected int cCS;
    protected long cCT;
    protected long cCU;
    protected boolean cCV;
    int cCW;
    e cCX;
    c cCY;
    d cCZ;
    @ViewDebug.ExportedProperty(category = IntentConfig.LIST)
    protected int cDa;
    protected long cDb;
    protected long cDc;
    @ViewDebug.ExportedProperty(category = IntentConfig.LIST)
    protected int cDd;
    protected int cDe;
    AccessibilityManager cDf;
    protected int cDg;
    protected long cDh;
    private boolean cDi;
    private boolean cDj;
    private g<T>.f cDk;
    protected boolean cDl;
    @ViewDebug.ExportedProperty(category = IntentConfig.LIST)
    protected int cjp;
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
        this.cCQ = 0;
        this.cCT = Long.MIN_VALUE;
        this.cCV = false;
        this.mInLayout = false;
        this.cDa = -1;
        this.cDb = Long.MIN_VALUE;
        this.cjp = -1;
        this.cDc = Long.MIN_VALUE;
        this.cDg = -1;
        this.cDh = Long.MIN_VALUE;
        this.cDl = false;
    }

    public g(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cCQ = 0;
        this.cCT = Long.MIN_VALUE;
        this.cCV = false;
        this.mInLayout = false;
        this.cDa = -1;
        this.cDb = Long.MIN_VALUE;
        this.cjp = -1;
        this.cDc = Long.MIN_VALUE;
        this.cDg = -1;
        this.cDh = Long.MIN_VALUE;
        this.cDl = false;
    }

    public g(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cCQ = 0;
        this.cCT = Long.MIN_VALUE;
        this.cCV = false;
        this.mInLayout = false;
        this.cDa = -1;
        this.cDb = Long.MIN_VALUE;
        this.cjp = -1;
        this.cDc = Long.MIN_VALUE;
        this.cDg = -1;
        this.cDh = Long.MIN_VALUE;
        this.cDl = false;
        if (!isInEditMode()) {
            this.cDf = (AccessibilityManager) getContext().getSystemService("accessibility");
        }
    }

    public void setOnItemClickListener(c cVar) {
        this.cCY = cVar;
    }

    public final c getOnItemClickListener() {
        return this.cCY;
    }

    public boolean performItemClick(View view, int i, long j) {
        if (this.cCY != null) {
            playSoundEffect(0);
            if (view != null) {
                view.sendAccessibilityEvent(1);
            }
            this.cCY.a(this, view, i, j);
            return true;
        }
        return false;
    }

    public void setOnItemLongClickListener(d dVar) {
        if (!isLongClickable()) {
            setLongClickable(true);
        }
        this.cCZ = dVar;
    }

    public final d getOnItemLongClickListener() {
        return this.cCZ;
    }

    public void setOnItemSelectedListener(e eVar) {
        this.cCX = eVar;
    }

    public final e getOnItemSelectedListener() {
        return this.cCX;
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
        return this.cDa;
    }

    @ViewDebug.CapturedViewProperty
    public long getSelectedItemId() {
        return this.cDb;
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
        return this.cDd;
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
                return i + this.cCQ;
            }
        }
        return -1;
    }

    public int getFirstVisiblePosition() {
        return this.cCQ;
    }

    public int getLastVisiblePosition() {
        return (this.cCQ + getChildCount()) - 1;
    }

    public void setEmptyView(View view) {
        this.mEmptyView = view;
        T adapter = getAdapter();
        fl(adapter == null || adapter.isEmpty());
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
        this.cDi = z;
        if (!z) {
            this.cDj = false;
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
        this.cDj = z;
        if (z) {
            this.cDi = true;
        }
        if (!z || (z3 && !isInFilterMode())) {
            z2 = false;
        }
        super.setFocusableInTouchMode(z2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void alD() {
        boolean z = false;
        T adapter = getAdapter();
        boolean z2 = !(adapter == null || adapter.getCount() == 0) || isInFilterMode();
        super.setFocusableInTouchMode(z2 && this.cDj);
        super.setFocusable(z2 && this.cDi);
        if (this.mEmptyView != null) {
            if (adapter == null || adapter.isEmpty()) {
                z = true;
            }
            fl(z);
        }
    }

    private void fl(boolean z) {
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
            if (this.adN) {
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
        private Parcelable cDm = null;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            g.this.adN = true;
            g.this.cDe = g.this.cDd;
            g.this.cDd = g.this.getAdapter().getCount();
            if (g.this.getAdapter().hasStableIds() && this.cDm != null && g.this.cDe == 0 && g.this.cDd > 0) {
                g.this.onRestoreInstanceState(this.cDm);
                this.cDm = null;
            } else {
                g.this.alK();
            }
            g.this.alD();
            g.this.requestLayout();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            g.this.adN = true;
            if (g.this.getAdapter().hasStableIds()) {
                this.cDm = g.this.onSaveInstanceState();
            }
            g.this.cDe = g.this.cDd;
            g.this.cDd = 0;
            g.this.cjp = -1;
            g.this.cDc = Long.MIN_VALUE;
            g.this.cDa = -1;
            g.this.cDb = Long.MIN_VALUE;
            g.this.cCV = false;
            g.this.alD();
            g.this.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.cDk);
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
            if (g.this.adN) {
                if (g.this.getAdapter() != null) {
                    g.this.post(this);
                    return;
                }
                return;
            }
            g.this.alF();
            g.this.alG();
        }
    }

    void alE() {
        if (this.cCX != null || this.cDf.isEnabled()) {
            if (this.mInLayout || this.cDl) {
                if (this.cDk == null) {
                    this.cDk = new f(this, null);
                }
                post(this.cDk);
                return;
            }
            alF();
            alG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alF() {
        if (this.cCX != null) {
            int selectedItemPosition = getSelectedItemPosition();
            if (selectedItemPosition >= 0) {
                this.cCX.c(this, getSelectedView(), selectedItemPosition, getAdapter().getItemId(selectedItemPosition));
                return;
            }
            this.cCX.d(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alG() {
        if (this.cDf.isEnabled() && getSelectedItemPosition() >= 0) {
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
        accessibilityNodeInfo.setScrollable(alH());
        View selectedView = getSelectedView();
        if (selectedView != null) {
            accessibilityNodeInfo.setEnabled(selectedView.isEnabled());
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(g.class.getName());
        accessibilityEvent.setScrollable(alH());
        View selectedView = getSelectedView();
        if (selectedView != null) {
            accessibilityEvent.setEnabled(selectedView.isEnabled());
        }
        accessibilityEvent.setCurrentItemIndex(getSelectedItemPosition());
        accessibilityEvent.setFromIndex(getFirstVisiblePosition());
        accessibilityEvent.setToIndex(getLastVisiblePosition());
        accessibilityEvent.setItemCount(getCount());
    }

    private boolean alH() {
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
        return super.canAnimate() && this.cDd > 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void handleDataChanged() {
        boolean z;
        boolean z2;
        int i = this.cDd;
        if (i > 0) {
            if (this.cCV) {
                this.cCV = false;
                int alJ = alJ();
                if (alJ >= 0 && q(alJ, true) == alJ) {
                    setNextSelectedPositionInt(alJ);
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
                            alI();
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
            this.cjp = -1;
            this.cDc = Long.MIN_VALUE;
            this.cDa = -1;
            this.cDb = Long.MIN_VALUE;
            this.cCV = false;
            alI();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void alI() {
        if (this.cjp != this.cDg || this.cDc != this.cDh) {
            alE();
            this.cDg = this.cjp;
            this.cDh = this.cDc;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int alJ() {
        int i = this.cDd;
        if (i == 0) {
            return -1;
        }
        long j = this.cCT;
        int i2 = this.cCS;
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
        this.cjp = i;
        this.cDc = getItemIdAtPosition(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setNextSelectedPositionInt(int i) {
        this.cDa = i;
        this.cDb = getItemIdAtPosition(i);
        if (this.cCV && this.cCW == 0 && i >= 0) {
            this.cCS = i;
            this.cCT = this.cDb;
        }
    }

    public void alK() {
        if (getChildCount() > 0) {
            this.cCV = true;
            this.cCU = this.mLayoutWidth;
            if (this.cjp >= 0) {
                View childAt = getChildAt(this.cjp - this.cCQ);
                this.cCT = this.cDb;
                this.cCS = this.cDa;
                if (childAt != null) {
                    this.cCR = childAt.getLeft();
                }
                this.cCW = 0;
                return;
            }
            View childAt2 = getChildAt(0);
            T adapter = getAdapter();
            if (this.cCQ >= 0 && this.cCQ < adapter.getCount()) {
                this.cCT = adapter.getItemId(this.cCQ);
            } else {
                this.cCT = -1L;
            }
            this.cCS = this.cCQ;
            if (childAt2 != null) {
                this.cCR = childAt2.getLeft();
            }
            this.cCW = 1;
        }
    }
}
