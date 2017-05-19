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
public abstract class f<T extends Adapter> extends ViewGroup {
    public boolean aiO;
    @ViewDebug.ExportedProperty(category = IntentConfig.LIST)
    protected int ciA;
    protected int czA;
    AccessibilityManager czB;
    protected int czC;
    protected long czD;
    private boolean czE;
    private boolean czF;
    private f<T>.RunnableC0066f czG;
    protected boolean czH;
    @ViewDebug.ExportedProperty(category = "scrolling")
    protected int czm;
    protected int czn;
    protected int czo;
    protected long czp;
    protected long czq;
    protected boolean czr;
    int czs;
    e czt;
    c czu;
    d czv;
    @ViewDebug.ExportedProperty(category = IntentConfig.LIST)
    protected int czw;
    protected long czx;
    protected long czy;
    @ViewDebug.ExportedProperty(category = IntentConfig.LIST)
    protected int czz;
    private View mEmptyView;
    protected boolean mInLayout;
    private int mLayoutWidth;

    /* loaded from: classes.dex */
    public interface c {
        void a(f<?> fVar, View view, int i, long j);
    }

    /* loaded from: classes.dex */
    public interface d {
        boolean b(f<?> fVar, View view, int i, long j);
    }

    /* loaded from: classes.dex */
    public interface e {
        void c(f<?> fVar, View view, int i, long j);

        void d(f<?> fVar);
    }

    public abstract T getAdapter();

    public abstract View getSelectedView();

    public abstract void setAdapter(T t);

    public abstract void setSelection(int i);

    public f(Context context) {
        super(context);
        this.czm = 0;
        this.czp = Long.MIN_VALUE;
        this.czr = false;
        this.mInLayout = false;
        this.czw = -1;
        this.czx = Long.MIN_VALUE;
        this.ciA = -1;
        this.czy = Long.MIN_VALUE;
        this.czC = -1;
        this.czD = Long.MIN_VALUE;
        this.czH = false;
    }

    public f(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.czm = 0;
        this.czp = Long.MIN_VALUE;
        this.czr = false;
        this.mInLayout = false;
        this.czw = -1;
        this.czx = Long.MIN_VALUE;
        this.ciA = -1;
        this.czy = Long.MIN_VALUE;
        this.czC = -1;
        this.czD = Long.MIN_VALUE;
        this.czH = false;
    }

    public f(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.czm = 0;
        this.czp = Long.MIN_VALUE;
        this.czr = false;
        this.mInLayout = false;
        this.czw = -1;
        this.czx = Long.MIN_VALUE;
        this.ciA = -1;
        this.czy = Long.MIN_VALUE;
        this.czC = -1;
        this.czD = Long.MIN_VALUE;
        this.czH = false;
        if (!isInEditMode()) {
            this.czB = (AccessibilityManager) getContext().getSystemService("accessibility");
        }
    }

    public void setOnItemClickListener(c cVar) {
        this.czu = cVar;
    }

    public final c getOnItemClickListener() {
        return this.czu;
    }

    public boolean performItemClick(View view, int i, long j) {
        if (this.czu != null) {
            playSoundEffect(0);
            if (view != null) {
                view.sendAccessibilityEvent(1);
            }
            this.czu.a(this, view, i, j);
            return true;
        }
        return false;
    }

    public void setOnItemLongClickListener(d dVar) {
        if (!isLongClickable()) {
            setLongClickable(true);
        }
        this.czv = dVar;
    }

    public final d getOnItemLongClickListener() {
        return this.czv;
    }

    public void setOnItemSelectedListener(e eVar) {
        this.czt = eVar;
    }

    public final e getOnItemSelectedListener() {
        return this.czt;
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
        return this.czw;
    }

    @ViewDebug.CapturedViewProperty
    public long getSelectedItemId() {
        return this.czx;
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
        return this.czz;
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
                return i + this.czm;
            }
        }
        return -1;
    }

    public int getFirstVisiblePosition() {
        return this.czm;
    }

    public int getLastVisiblePosition() {
        return (this.czm + getChildCount()) - 1;
    }

    public void setEmptyView(View view) {
        this.mEmptyView = view;
        T adapter = getAdapter();
        eO(adapter == null || adapter.isEmpty());
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
        this.czE = z;
        if (!z) {
            this.czF = false;
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
        this.czF = z;
        if (z) {
            this.czE = true;
        }
        if (!z || (z3 && !isInFilterMode())) {
            z2 = false;
        }
        super.setFocusableInTouchMode(z2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aiA() {
        boolean z = false;
        T adapter = getAdapter();
        boolean z2 = !(adapter == null || adapter.getCount() == 0) || isInFilterMode();
        super.setFocusableInTouchMode(z2 && this.czF);
        super.setFocusable(z2 && this.czE);
        if (this.mEmptyView != null) {
            if (adapter == null || adapter.isEmpty()) {
                z = true;
            }
            eO(z);
        }
    }

    private void eO(boolean z) {
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
            if (this.aiO) {
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
        private Parcelable czI = null;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            f.this.aiO = true;
            f.this.czA = f.this.czz;
            f.this.czz = f.this.getAdapter().getCount();
            if (f.this.getAdapter().hasStableIds() && this.czI != null && f.this.czA == 0 && f.this.czz > 0) {
                f.this.onRestoreInstanceState(this.czI);
                this.czI = null;
            } else {
                f.this.aiH();
            }
            f.this.aiA();
            f.this.requestLayout();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            f.this.aiO = true;
            if (f.this.getAdapter().hasStableIds()) {
                this.czI = f.this.onSaveInstanceState();
            }
            f.this.czA = f.this.czz;
            f.this.czz = 0;
            f.this.ciA = -1;
            f.this.czy = Long.MIN_VALUE;
            f.this.czw = -1;
            f.this.czx = Long.MIN_VALUE;
            f.this.czr = false;
            f.this.aiA();
            f.this.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.czG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.horizonalList.widget.f$f  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0066f implements Runnable {
        private RunnableC0066f() {
        }

        /* synthetic */ RunnableC0066f(f fVar, RunnableC0066f runnableC0066f) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (f.this.aiO) {
                if (f.this.getAdapter() != null) {
                    f.this.post(this);
                    return;
                }
                return;
            }
            f.this.aiC();
            f.this.aiD();
        }
    }

    void aiB() {
        if (this.czt != null || this.czB.isEnabled()) {
            if (this.mInLayout || this.czH) {
                if (this.czG == null) {
                    this.czG = new RunnableC0066f(this, null);
                }
                post(this.czG);
                return;
            }
            aiC();
            aiD();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiC() {
        if (this.czt != null) {
            int selectedItemPosition = getSelectedItemPosition();
            if (selectedItemPosition >= 0) {
                this.czt.c(this, getSelectedView(), selectedItemPosition, getAdapter().getItemId(selectedItemPosition));
                return;
            }
            this.czt.d(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiD() {
        if (this.czB.isEnabled() && getSelectedItemPosition() >= 0) {
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
        accessibilityNodeInfo.setClassName(f.class.getName());
        accessibilityNodeInfo.setScrollable(aiE());
        View selectedView = getSelectedView();
        if (selectedView != null) {
            accessibilityNodeInfo.setEnabled(selectedView.isEnabled());
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(f.class.getName());
        accessibilityEvent.setScrollable(aiE());
        View selectedView = getSelectedView();
        if (selectedView != null) {
            accessibilityEvent.setEnabled(selectedView.isEnabled());
        }
        accessibilityEvent.setCurrentItemIndex(getSelectedItemPosition());
        accessibilityEvent.setFromIndex(getFirstVisiblePosition());
        accessibilityEvent.setToIndex(getLastVisiblePosition());
        accessibilityEvent.setItemCount(getCount());
    }

    private boolean aiE() {
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
        return super.canAnimate() && this.czz > 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void handleDataChanged() {
        boolean z;
        boolean z2;
        int i = this.czz;
        if (i > 0) {
            if (this.czr) {
                this.czr = false;
                int aiG = aiG();
                if (aiG >= 0 && p(aiG, true) == aiG) {
                    setNextSelectedPositionInt(aiG);
                    z2 = true;
                    if (!z2) {
                        int selectedItemPosition = getSelectedItemPosition();
                        if (selectedItemPosition >= i) {
                            selectedItemPosition = i - 1;
                        }
                        if (selectedItemPosition < 0) {
                            selectedItemPosition = 0;
                        }
                        int p = p(selectedItemPosition, true);
                        int p2 = p < 0 ? p(selectedItemPosition, false) : p;
                        if (p2 >= 0) {
                            setNextSelectedPositionInt(p2);
                            aiF();
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
            this.ciA = -1;
            this.czy = Long.MIN_VALUE;
            this.czw = -1;
            this.czx = Long.MIN_VALUE;
            this.czr = false;
            aiF();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aiF() {
        if (this.ciA != this.czC || this.czy != this.czD) {
            aiB();
            this.czC = this.ciA;
            this.czD = this.czy;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int aiG() {
        int i = this.czz;
        if (i == 0) {
            return -1;
        }
        long j = this.czp;
        int i2 = this.czo;
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
    public int p(int i, boolean z) {
        return i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setSelectedPositionInt(int i) {
        this.ciA = i;
        this.czy = getItemIdAtPosition(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setNextSelectedPositionInt(int i) {
        this.czw = i;
        this.czx = getItemIdAtPosition(i);
        if (this.czr && this.czs == 0 && i >= 0) {
            this.czo = i;
            this.czp = this.czx;
        }
    }

    public void aiH() {
        if (getChildCount() > 0) {
            this.czr = true;
            this.czq = this.mLayoutWidth;
            if (this.ciA >= 0) {
                View childAt = getChildAt(this.ciA - this.czm);
                this.czp = this.czx;
                this.czo = this.czw;
                if (childAt != null) {
                    this.czn = childAt.getLeft();
                }
                this.czs = 0;
                return;
            }
            View childAt2 = getChildAt(0);
            T adapter = getAdapter();
            if (this.czm >= 0 && this.czm < adapter.getCount()) {
                this.czp = adapter.getItemId(this.czm);
            } else {
                this.czp = -1L;
            }
            this.czo = this.czm;
            if (childAt2 != null) {
                this.czn = childAt2.getLeft();
            }
            this.czs = 1;
        }
    }
}
