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
    public boolean ajc;
    protected int cEA;
    AccessibilityManager cEB;
    protected int cEC;
    protected long cED;
    private boolean cEE;
    private boolean cEF;
    private g<T>.f cEG;
    protected boolean cEH;
    @ViewDebug.ExportedProperty(category = "scrolling")
    protected int cEm;
    protected int cEn;
    protected int cEo;
    protected long cEp;
    protected long cEq;
    protected boolean cEr;
    int cEs;
    e cEt;
    c cEu;
    d cEv;
    @ViewDebug.ExportedProperty(category = IntentConfig.LIST)
    protected int cEw;
    protected long cEx;
    protected long cEy;
    @ViewDebug.ExportedProperty(category = IntentConfig.LIST)
    protected int cEz;
    @ViewDebug.ExportedProperty(category = IntentConfig.LIST)
    protected int ckM;
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
        this.cEm = 0;
        this.cEp = Long.MIN_VALUE;
        this.cEr = false;
        this.mInLayout = false;
        this.cEw = -1;
        this.cEx = Long.MIN_VALUE;
        this.ckM = -1;
        this.cEy = Long.MIN_VALUE;
        this.cEC = -1;
        this.cED = Long.MIN_VALUE;
        this.cEH = false;
    }

    public g(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cEm = 0;
        this.cEp = Long.MIN_VALUE;
        this.cEr = false;
        this.mInLayout = false;
        this.cEw = -1;
        this.cEx = Long.MIN_VALUE;
        this.ckM = -1;
        this.cEy = Long.MIN_VALUE;
        this.cEC = -1;
        this.cED = Long.MIN_VALUE;
        this.cEH = false;
    }

    public g(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cEm = 0;
        this.cEp = Long.MIN_VALUE;
        this.cEr = false;
        this.mInLayout = false;
        this.cEw = -1;
        this.cEx = Long.MIN_VALUE;
        this.ckM = -1;
        this.cEy = Long.MIN_VALUE;
        this.cEC = -1;
        this.cED = Long.MIN_VALUE;
        this.cEH = false;
        if (!isInEditMode()) {
            this.cEB = (AccessibilityManager) getContext().getSystemService("accessibility");
        }
    }

    public void setOnItemClickListener(c cVar) {
        this.cEu = cVar;
    }

    public final c getOnItemClickListener() {
        return this.cEu;
    }

    public boolean performItemClick(View view, int i, long j) {
        if (this.cEu != null) {
            playSoundEffect(0);
            if (view != null) {
                view.sendAccessibilityEvent(1);
            }
            this.cEu.a(this, view, i, j);
            return true;
        }
        return false;
    }

    public void setOnItemLongClickListener(d dVar) {
        if (!isLongClickable()) {
            setLongClickable(true);
        }
        this.cEv = dVar;
    }

    public final d getOnItemLongClickListener() {
        return this.cEv;
    }

    public void setOnItemSelectedListener(e eVar) {
        this.cEt = eVar;
    }

    public final e getOnItemSelectedListener() {
        return this.cEt;
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
        return this.cEw;
    }

    @ViewDebug.CapturedViewProperty
    public long getSelectedItemId() {
        return this.cEx;
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
        return this.cEz;
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
                return i + this.cEm;
            }
        }
        return -1;
    }

    public int getFirstVisiblePosition() {
        return this.cEm;
    }

    public int getLastVisiblePosition() {
        return (this.cEm + getChildCount()) - 1;
    }

    public void setEmptyView(View view) {
        this.mEmptyView = view;
        T adapter = getAdapter();
        fc(adapter == null || adapter.isEmpty());
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
        this.cEE = z;
        if (!z) {
            this.cEF = false;
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
        this.cEF = z;
        if (z) {
            this.cEE = true;
        }
        if (!z || (z3 && !isInFilterMode())) {
            z2 = false;
        }
        super.setFocusableInTouchMode(z2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void akP() {
        boolean z = false;
        T adapter = getAdapter();
        boolean z2 = !(adapter == null || adapter.getCount() == 0) || isInFilterMode();
        super.setFocusableInTouchMode(z2 && this.cEF);
        super.setFocusable(z2 && this.cEE);
        if (this.mEmptyView != null) {
            if (adapter == null || adapter.isEmpty()) {
                z = true;
            }
            fc(z);
        }
    }

    private void fc(boolean z) {
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
            if (this.ajc) {
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
        private Parcelable cEI = null;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            g.this.ajc = true;
            g.this.cEA = g.this.cEz;
            g.this.cEz = g.this.getAdapter().getCount();
            if (g.this.getAdapter().hasStableIds() && this.cEI != null && g.this.cEA == 0 && g.this.cEz > 0) {
                g.this.onRestoreInstanceState(this.cEI);
                this.cEI = null;
            } else {
                g.this.akW();
            }
            g.this.akP();
            g.this.requestLayout();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            g.this.ajc = true;
            if (g.this.getAdapter().hasStableIds()) {
                this.cEI = g.this.onSaveInstanceState();
            }
            g.this.cEA = g.this.cEz;
            g.this.cEz = 0;
            g.this.ckM = -1;
            g.this.cEy = Long.MIN_VALUE;
            g.this.cEw = -1;
            g.this.cEx = Long.MIN_VALUE;
            g.this.cEr = false;
            g.this.akP();
            g.this.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.cEG);
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
            if (g.this.ajc) {
                if (g.this.getAdapter() != null) {
                    g.this.post(this);
                    return;
                }
                return;
            }
            g.this.akR();
            g.this.akS();
        }
    }

    void akQ() {
        if (this.cEt != null || this.cEB.isEnabled()) {
            if (this.mInLayout || this.cEH) {
                if (this.cEG == null) {
                    this.cEG = new f(this, null);
                }
                post(this.cEG);
                return;
            }
            akR();
            akS();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akR() {
        if (this.cEt != null) {
            int selectedItemPosition = getSelectedItemPosition();
            if (selectedItemPosition >= 0) {
                this.cEt.c(this, getSelectedView(), selectedItemPosition, getAdapter().getItemId(selectedItemPosition));
                return;
            }
            this.cEt.d(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akS() {
        if (this.cEB.isEnabled() && getSelectedItemPosition() >= 0) {
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
        accessibilityNodeInfo.setScrollable(akT());
        View selectedView = getSelectedView();
        if (selectedView != null) {
            accessibilityNodeInfo.setEnabled(selectedView.isEnabled());
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(g.class.getName());
        accessibilityEvent.setScrollable(akT());
        View selectedView = getSelectedView();
        if (selectedView != null) {
            accessibilityEvent.setEnabled(selectedView.isEnabled());
        }
        accessibilityEvent.setCurrentItemIndex(getSelectedItemPosition());
        accessibilityEvent.setFromIndex(getFirstVisiblePosition());
        accessibilityEvent.setToIndex(getLastVisiblePosition());
        accessibilityEvent.setItemCount(getCount());
    }

    private boolean akT() {
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
        return super.canAnimate() && this.cEz > 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void handleDataChanged() {
        boolean z;
        boolean z2;
        int i = this.cEz;
        if (i > 0) {
            if (this.cEr) {
                this.cEr = false;
                int akV = akV();
                if (akV >= 0 && q(akV, true) == akV) {
                    setNextSelectedPositionInt(akV);
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
                            akU();
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
            this.ckM = -1;
            this.cEy = Long.MIN_VALUE;
            this.cEw = -1;
            this.cEx = Long.MIN_VALUE;
            this.cEr = false;
            akU();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void akU() {
        if (this.ckM != this.cEC || this.cEy != this.cED) {
            akQ();
            this.cEC = this.ckM;
            this.cED = this.cEy;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int akV() {
        int i = this.cEz;
        if (i == 0) {
            return -1;
        }
        long j = this.cEp;
        int i2 = this.cEo;
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
        this.ckM = i;
        this.cEy = getItemIdAtPosition(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setNextSelectedPositionInt(int i) {
        this.cEw = i;
        this.cEx = getItemIdAtPosition(i);
        if (this.cEr && this.cEs == 0 && i >= 0) {
            this.cEo = i;
            this.cEp = this.cEx;
        }
    }

    public void akW() {
        if (getChildCount() > 0) {
            this.cEr = true;
            this.cEq = this.mLayoutWidth;
            if (this.ckM >= 0) {
                View childAt = getChildAt(this.ckM - this.cEm);
                this.cEp = this.cEx;
                this.cEo = this.cEw;
                if (childAt != null) {
                    this.cEn = childAt.getLeft();
                }
                this.cEs = 0;
                return;
            }
            View childAt2 = getChildAt(0);
            T adapter = getAdapter();
            if (this.cEm >= 0 && this.cEm < adapter.getCount()) {
                this.cEp = adapter.getItemId(this.cEm);
            } else {
                this.cEp = -1L;
            }
            this.cEo = this.cEm;
            if (childAt2 != null) {
                this.cEn = childAt2.getLeft();
            }
            this.cEs = 1;
        }
    }
}
