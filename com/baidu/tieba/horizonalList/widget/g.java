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
    public boolean abK;
    @ViewDebug.ExportedProperty(category = "scrolling")
    protected int bml;
    @ViewDebug.ExportedProperty(category = IntentConfig.LIST)
    protected int cgS;
    protected int cyU;
    protected int cyV;
    protected long cyW;
    protected long cyX;
    protected boolean cyY;
    int cyZ;
    e cza;
    c czb;
    d czc;
    @ViewDebug.ExportedProperty(category = IntentConfig.LIST)
    protected int czd;
    protected long cze;
    protected long czf;
    @ViewDebug.ExportedProperty(category = IntentConfig.LIST)
    protected int czg;
    protected int czh;
    AccessibilityManager czi;
    protected int czj;
    protected long czk;
    private boolean czl;
    private boolean czm;
    private g<T>.f czn;
    protected boolean czo;
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
        this.bml = 0;
        this.cyW = Long.MIN_VALUE;
        this.cyY = false;
        this.mInLayout = false;
        this.czd = -1;
        this.cze = Long.MIN_VALUE;
        this.cgS = -1;
        this.czf = Long.MIN_VALUE;
        this.czj = -1;
        this.czk = Long.MIN_VALUE;
        this.czo = false;
    }

    public g(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bml = 0;
        this.cyW = Long.MIN_VALUE;
        this.cyY = false;
        this.mInLayout = false;
        this.czd = -1;
        this.cze = Long.MIN_VALUE;
        this.cgS = -1;
        this.czf = Long.MIN_VALUE;
        this.czj = -1;
        this.czk = Long.MIN_VALUE;
        this.czo = false;
    }

    public g(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bml = 0;
        this.cyW = Long.MIN_VALUE;
        this.cyY = false;
        this.mInLayout = false;
        this.czd = -1;
        this.cze = Long.MIN_VALUE;
        this.cgS = -1;
        this.czf = Long.MIN_VALUE;
        this.czj = -1;
        this.czk = Long.MIN_VALUE;
        this.czo = false;
        if (!isInEditMode()) {
            this.czi = (AccessibilityManager) getContext().getSystemService("accessibility");
        }
    }

    public void setOnItemClickListener(c cVar) {
        this.czb = cVar;
    }

    public final c getOnItemClickListener() {
        return this.czb;
    }

    public boolean performItemClick(View view, int i, long j) {
        if (this.czb != null) {
            playSoundEffect(0);
            if (view != null) {
                view.sendAccessibilityEvent(1);
            }
            this.czb.a(this, view, i, j);
            return true;
        }
        return false;
    }

    public void setOnItemLongClickListener(d dVar) {
        if (!isLongClickable()) {
            setLongClickable(true);
        }
        this.czc = dVar;
    }

    public final d getOnItemLongClickListener() {
        return this.czc;
    }

    public void setOnItemSelectedListener(e eVar) {
        this.cza = eVar;
    }

    public final e getOnItemSelectedListener() {
        return this.cza;
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
        return this.czd;
    }

    @ViewDebug.CapturedViewProperty
    public long getSelectedItemId() {
        return this.cze;
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
        return this.czg;
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
                return i + this.bml;
            }
        }
        return -1;
    }

    public int getFirstVisiblePosition() {
        return this.bml;
    }

    public int getLastVisiblePosition() {
        return (this.bml + getChildCount()) - 1;
    }

    public void setEmptyView(View view) {
        this.mEmptyView = view;
        T adapter = getAdapter();
        eK(adapter == null || adapter.isEmpty());
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
        this.czl = z;
        if (!z) {
            this.czm = false;
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
        this.czm = z;
        if (z) {
            this.czl = true;
        }
        if (!z || (z3 && !isInFilterMode())) {
            z2 = false;
        }
        super.setFocusableInTouchMode(z2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aiY() {
        boolean z = false;
        T adapter = getAdapter();
        boolean z2 = !(adapter == null || adapter.getCount() == 0) || isInFilterMode();
        super.setFocusableInTouchMode(z2 && this.czm);
        super.setFocusable(z2 && this.czl);
        if (this.mEmptyView != null) {
            if (adapter == null || adapter.isEmpty()) {
                z = true;
            }
            eK(z);
        }
    }

    private void eK(boolean z) {
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
            if (this.abK) {
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
        private Parcelable czp = null;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            g.this.abK = true;
            g.this.czh = g.this.czg;
            g.this.czg = g.this.getAdapter().getCount();
            if (g.this.getAdapter().hasStableIds() && this.czp != null && g.this.czh == 0 && g.this.czg > 0) {
                g.this.onRestoreInstanceState(this.czp);
                this.czp = null;
            } else {
                g.this.ajf();
            }
            g.this.aiY();
            g.this.requestLayout();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            g.this.abK = true;
            if (g.this.getAdapter().hasStableIds()) {
                this.czp = g.this.onSaveInstanceState();
            }
            g.this.czh = g.this.czg;
            g.this.czg = 0;
            g.this.cgS = -1;
            g.this.czf = Long.MIN_VALUE;
            g.this.czd = -1;
            g.this.cze = Long.MIN_VALUE;
            g.this.cyY = false;
            g.this.aiY();
            g.this.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.czn);
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
            if (g.this.abK) {
                if (g.this.getAdapter() != null) {
                    g.this.post(this);
                    return;
                }
                return;
            }
            g.this.aja();
            g.this.ajb();
        }
    }

    void aiZ() {
        if (this.cza != null || this.czi.isEnabled()) {
            if (this.mInLayout || this.czo) {
                if (this.czn == null) {
                    this.czn = new f(this, null);
                }
                post(this.czn);
                return;
            }
            aja();
            ajb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aja() {
        if (this.cza != null) {
            int selectedItemPosition = getSelectedItemPosition();
            if (selectedItemPosition >= 0) {
                this.cza.c(this, getSelectedView(), selectedItemPosition, getAdapter().getItemId(selectedItemPosition));
                return;
            }
            this.cza.d(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajb() {
        if (this.czi.isEnabled() && getSelectedItemPosition() >= 0) {
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
        accessibilityNodeInfo.setScrollable(ajc());
        View selectedView = getSelectedView();
        if (selectedView != null) {
            accessibilityNodeInfo.setEnabled(selectedView.isEnabled());
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(g.class.getName());
        accessibilityEvent.setScrollable(ajc());
        View selectedView = getSelectedView();
        if (selectedView != null) {
            accessibilityEvent.setEnabled(selectedView.isEnabled());
        }
        accessibilityEvent.setCurrentItemIndex(getSelectedItemPosition());
        accessibilityEvent.setFromIndex(getFirstVisiblePosition());
        accessibilityEvent.setToIndex(getLastVisiblePosition());
        accessibilityEvent.setItemCount(getCount());
    }

    private boolean ajc() {
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
        return super.canAnimate() && this.czg > 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void handleDataChanged() {
        boolean z;
        boolean z2;
        int i = this.czg;
        if (i > 0) {
            if (this.cyY) {
                this.cyY = false;
                int aje = aje();
                if (aje >= 0 && C(aje, true) == aje) {
                    setNextSelectedPositionInt(aje);
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
                            ajd();
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
            this.cgS = -1;
            this.czf = Long.MIN_VALUE;
            this.czd = -1;
            this.cze = Long.MIN_VALUE;
            this.cyY = false;
            ajd();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ajd() {
        if (this.cgS != this.czj || this.czf != this.czk) {
            aiZ();
            this.czj = this.cgS;
            this.czk = this.czf;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int aje() {
        int i = this.czg;
        if (i == 0) {
            return -1;
        }
        long j = this.cyW;
        int i2 = this.cyV;
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
        this.cgS = i;
        this.czf = getItemIdAtPosition(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setNextSelectedPositionInt(int i) {
        this.czd = i;
        this.cze = getItemIdAtPosition(i);
        if (this.cyY && this.cyZ == 0 && i >= 0) {
            this.cyV = i;
            this.cyW = this.cze;
        }
    }

    public void ajf() {
        if (getChildCount() > 0) {
            this.cyY = true;
            this.cyX = this.mLayoutWidth;
            if (this.cgS >= 0) {
                View childAt = getChildAt(this.cgS - this.bml);
                this.cyW = this.cze;
                this.cyV = this.czd;
                if (childAt != null) {
                    this.cyU = childAt.getLeft();
                }
                this.cyZ = 0;
                return;
            }
            View childAt2 = getChildAt(0);
            T adapter = getAdapter();
            if (this.bml >= 0 && this.bml < adapter.getCount()) {
                this.cyW = adapter.getItemId(this.bml);
            } else {
                this.cyW = -1L;
            }
            this.cyV = this.bml;
            if (childAt2 != null) {
                this.cyU = childAt2.getLeft();
            }
            this.cyZ = 1;
        }
    }
}
