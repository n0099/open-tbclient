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
    public boolean aaG;
    @ViewDebug.ExportedProperty(category = IntentConfig.LIST)
    protected int bHc;
    @ViewDebug.ExportedProperty(category = "scrolling")
    protected int bSe;
    protected int bSf;
    protected int bSg;
    protected long bSh;
    protected long bSi;
    protected boolean bSj;
    int bSk;
    e bSl;
    c bSm;
    d bSn;
    @ViewDebug.ExportedProperty(category = IntentConfig.LIST)
    protected int bSo;
    protected long bSp;
    protected long bSq;
    @ViewDebug.ExportedProperty(category = IntentConfig.LIST)
    protected int bSr;
    protected int bSs;
    AccessibilityManager bSt;
    protected int bSu;
    protected long bSv;
    private boolean bSw;
    private boolean bSx;
    private g<T>.f bSy;
    protected boolean bSz;
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
        this.bSe = 0;
        this.bSh = Long.MIN_VALUE;
        this.bSj = false;
        this.mInLayout = false;
        this.bSo = -1;
        this.bSp = Long.MIN_VALUE;
        this.bHc = -1;
        this.bSq = Long.MIN_VALUE;
        this.bSu = -1;
        this.bSv = Long.MIN_VALUE;
        this.bSz = false;
    }

    public g(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bSe = 0;
        this.bSh = Long.MIN_VALUE;
        this.bSj = false;
        this.mInLayout = false;
        this.bSo = -1;
        this.bSp = Long.MIN_VALUE;
        this.bHc = -1;
        this.bSq = Long.MIN_VALUE;
        this.bSu = -1;
        this.bSv = Long.MIN_VALUE;
        this.bSz = false;
    }

    public g(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bSe = 0;
        this.bSh = Long.MIN_VALUE;
        this.bSj = false;
        this.mInLayout = false;
        this.bSo = -1;
        this.bSp = Long.MIN_VALUE;
        this.bHc = -1;
        this.bSq = Long.MIN_VALUE;
        this.bSu = -1;
        this.bSv = Long.MIN_VALUE;
        this.bSz = false;
        if (!isInEditMode()) {
            this.bSt = (AccessibilityManager) getContext().getSystemService("accessibility");
        }
    }

    public void setOnItemClickListener(c cVar) {
        this.bSm = cVar;
    }

    public final c getOnItemClickListener() {
        return this.bSm;
    }

    public boolean performItemClick(View view, int i, long j) {
        if (this.bSm != null) {
            playSoundEffect(0);
            if (view != null) {
                view.sendAccessibilityEvent(1);
            }
            this.bSm.a(this, view, i, j);
            return true;
        }
        return false;
    }

    public void setOnItemLongClickListener(d dVar) {
        if (!isLongClickable()) {
            setLongClickable(true);
        }
        this.bSn = dVar;
    }

    public final d getOnItemLongClickListener() {
        return this.bSn;
    }

    public void setOnItemSelectedListener(e eVar) {
        this.bSl = eVar;
    }

    public final e getOnItemSelectedListener() {
        return this.bSl;
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
        return this.bSo;
    }

    @ViewDebug.CapturedViewProperty
    public long getSelectedItemId() {
        return this.bSp;
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
        return this.bSr;
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
                return i + this.bSe;
            }
        }
        return -1;
    }

    public int getFirstVisiblePosition() {
        return this.bSe;
    }

    public int getLastVisiblePosition() {
        return (this.bSe + getChildCount()) - 1;
    }

    public void setEmptyView(View view) {
        this.mEmptyView = view;
        T adapter = getAdapter();
        dW(adapter == null || adapter.isEmpty());
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
        this.bSw = z;
        if (!z) {
            this.bSx = false;
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
        this.bSx = z;
        if (z) {
            this.bSw = true;
        }
        if (!z || (z3 && !isInFilterMode())) {
            z2 = false;
        }
        super.setFocusableInTouchMode(z2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aat() {
        boolean z = false;
        T adapter = getAdapter();
        boolean z2 = !(adapter == null || adapter.getCount() == 0) || isInFilterMode();
        super.setFocusableInTouchMode(z2 && this.bSx);
        super.setFocusable(z2 && this.bSw);
        if (this.mEmptyView != null) {
            if (adapter == null || adapter.isEmpty()) {
                z = true;
            }
            dW(z);
        }
    }

    private void dW(boolean z) {
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
            if (this.aaG) {
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
        private Parcelable bSA = null;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            g.this.aaG = true;
            g.this.bSs = g.this.bSr;
            g.this.bSr = g.this.getAdapter().getCount();
            if (g.this.getAdapter().hasStableIds() && this.bSA != null && g.this.bSs == 0 && g.this.bSr > 0) {
                g.this.onRestoreInstanceState(this.bSA);
                this.bSA = null;
            } else {
                g.this.aaA();
            }
            g.this.aat();
            g.this.requestLayout();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            g.this.aaG = true;
            if (g.this.getAdapter().hasStableIds()) {
                this.bSA = g.this.onSaveInstanceState();
            }
            g.this.bSs = g.this.bSr;
            g.this.bSr = 0;
            g.this.bHc = -1;
            g.this.bSq = Long.MIN_VALUE;
            g.this.bSo = -1;
            g.this.bSp = Long.MIN_VALUE;
            g.this.bSj = false;
            g.this.aat();
            g.this.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.bSy);
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
            if (g.this.aaG) {
                if (g.this.getAdapter() != null) {
                    g.this.post(this);
                    return;
                }
                return;
            }
            g.this.aav();
            g.this.aaw();
        }
    }

    void aau() {
        if (this.bSl != null || this.bSt.isEnabled()) {
            if (this.mInLayout || this.bSz) {
                if (this.bSy == null) {
                    this.bSy = new f(this, null);
                }
                post(this.bSy);
                return;
            }
            aav();
            aaw();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aav() {
        if (this.bSl != null) {
            int selectedItemPosition = getSelectedItemPosition();
            if (selectedItemPosition >= 0) {
                this.bSl.c(this, getSelectedView(), selectedItemPosition, getAdapter().getItemId(selectedItemPosition));
                return;
            }
            this.bSl.d(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaw() {
        if (this.bSt.isEnabled() && getSelectedItemPosition() >= 0) {
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
        accessibilityNodeInfo.setScrollable(aax());
        View selectedView = getSelectedView();
        if (selectedView != null) {
            accessibilityNodeInfo.setEnabled(selectedView.isEnabled());
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(g.class.getName());
        accessibilityEvent.setScrollable(aax());
        View selectedView = getSelectedView();
        if (selectedView != null) {
            accessibilityEvent.setEnabled(selectedView.isEnabled());
        }
        accessibilityEvent.setCurrentItemIndex(getSelectedItemPosition());
        accessibilityEvent.setFromIndex(getFirstVisiblePosition());
        accessibilityEvent.setToIndex(getLastVisiblePosition());
        accessibilityEvent.setItemCount(getCount());
    }

    private boolean aax() {
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
        return super.canAnimate() && this.bSr > 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void handleDataChanged() {
        boolean z;
        boolean z2;
        int i = this.bSr;
        if (i > 0) {
            if (this.bSj) {
                this.bSj = false;
                int aaz = aaz();
                if (aaz >= 0 && n(aaz, true) == aaz) {
                    setNextSelectedPositionInt(aaz);
                    z2 = true;
                    if (!z2) {
                        int selectedItemPosition = getSelectedItemPosition();
                        if (selectedItemPosition >= i) {
                            selectedItemPosition = i - 1;
                        }
                        if (selectedItemPosition < 0) {
                            selectedItemPosition = 0;
                        }
                        int n = n(selectedItemPosition, true);
                        int n2 = n < 0 ? n(selectedItemPosition, false) : n;
                        if (n2 >= 0) {
                            setNextSelectedPositionInt(n2);
                            aay();
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
            this.bHc = -1;
            this.bSq = Long.MIN_VALUE;
            this.bSo = -1;
            this.bSp = Long.MIN_VALUE;
            this.bSj = false;
            aay();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aay() {
        if (this.bHc != this.bSu || this.bSq != this.bSv) {
            aau();
            this.bSu = this.bHc;
            this.bSv = this.bSq;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int aaz() {
        int i = this.bSr;
        if (i == 0) {
            return -1;
        }
        long j = this.bSh;
        int i2 = this.bSg;
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
    public int n(int i, boolean z) {
        return i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setSelectedPositionInt(int i) {
        this.bHc = i;
        this.bSq = getItemIdAtPosition(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setNextSelectedPositionInt(int i) {
        this.bSo = i;
        this.bSp = getItemIdAtPosition(i);
        if (this.bSj && this.bSk == 0 && i >= 0) {
            this.bSg = i;
            this.bSh = this.bSp;
        }
    }

    public void aaA() {
        if (getChildCount() > 0) {
            this.bSj = true;
            this.bSi = this.mLayoutWidth;
            if (this.bHc >= 0) {
                View childAt = getChildAt(this.bHc - this.bSe);
                this.bSh = this.bSp;
                this.bSg = this.bSo;
                if (childAt != null) {
                    this.bSf = childAt.getLeft();
                }
                this.bSk = 0;
                return;
            }
            View childAt2 = getChildAt(0);
            T adapter = getAdapter();
            if (this.bSe >= 0 && this.bSe < adapter.getCount()) {
                this.bSh = adapter.getItemId(this.bSe);
            } else {
                this.bSh = -1L;
            }
            this.bSg = this.bSe;
            if (childAt2 != null) {
                this.bSf = childAt2.getLeft();
            }
            this.bSk = 1;
        }
    }
}
