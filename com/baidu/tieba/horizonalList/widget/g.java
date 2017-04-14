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
    public boolean ajq;
    @ViewDebug.ExportedProperty(category = "scrolling")
    protected int cCL;
    protected int cCM;
    protected int cCN;
    protected long cCO;
    protected long cCP;
    protected boolean cCQ;
    int cCR;
    e cCS;
    c cCT;
    d cCU;
    @ViewDebug.ExportedProperty(category = IntentConfig.LIST)
    protected int cCV;
    protected long cCW;
    protected long cCX;
    @ViewDebug.ExportedProperty(category = IntentConfig.LIST)
    protected int cCY;
    protected int cCZ;
    AccessibilityManager cDa;
    protected int cDb;
    protected long cDc;
    private boolean cDd;
    private boolean cDe;
    private g<T>.f cDf;
    protected boolean cDg;
    @ViewDebug.ExportedProperty(category = IntentConfig.LIST)
    protected int cjm;
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
        this.cCL = 0;
        this.cCO = Long.MIN_VALUE;
        this.cCQ = false;
        this.mInLayout = false;
        this.cCV = -1;
        this.cCW = Long.MIN_VALUE;
        this.cjm = -1;
        this.cCX = Long.MIN_VALUE;
        this.cDb = -1;
        this.cDc = Long.MIN_VALUE;
        this.cDg = false;
    }

    public g(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cCL = 0;
        this.cCO = Long.MIN_VALUE;
        this.cCQ = false;
        this.mInLayout = false;
        this.cCV = -1;
        this.cCW = Long.MIN_VALUE;
        this.cjm = -1;
        this.cCX = Long.MIN_VALUE;
        this.cDb = -1;
        this.cDc = Long.MIN_VALUE;
        this.cDg = false;
    }

    public g(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cCL = 0;
        this.cCO = Long.MIN_VALUE;
        this.cCQ = false;
        this.mInLayout = false;
        this.cCV = -1;
        this.cCW = Long.MIN_VALUE;
        this.cjm = -1;
        this.cCX = Long.MIN_VALUE;
        this.cDb = -1;
        this.cDc = Long.MIN_VALUE;
        this.cDg = false;
        if (!isInEditMode()) {
            this.cDa = (AccessibilityManager) getContext().getSystemService("accessibility");
        }
    }

    public void setOnItemClickListener(c cVar) {
        this.cCT = cVar;
    }

    public final c getOnItemClickListener() {
        return this.cCT;
    }

    public boolean performItemClick(View view, int i, long j) {
        if (this.cCT != null) {
            playSoundEffect(0);
            if (view != null) {
                view.sendAccessibilityEvent(1);
            }
            this.cCT.a(this, view, i, j);
            return true;
        }
        return false;
    }

    public void setOnItemLongClickListener(d dVar) {
        if (!isLongClickable()) {
            setLongClickable(true);
        }
        this.cCU = dVar;
    }

    public final d getOnItemLongClickListener() {
        return this.cCU;
    }

    public void setOnItemSelectedListener(e eVar) {
        this.cCS = eVar;
    }

    public final e getOnItemSelectedListener() {
        return this.cCS;
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
        return this.cCV;
    }

    @ViewDebug.CapturedViewProperty
    public long getSelectedItemId() {
        return this.cCW;
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
        return this.cCY;
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
                return i + this.cCL;
            }
        }
        return -1;
    }

    public int getFirstVisiblePosition() {
        return this.cCL;
    }

    public int getLastVisiblePosition() {
        return (this.cCL + getChildCount()) - 1;
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
        this.cDd = z;
        if (!z) {
            this.cDe = false;
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
        this.cDe = z;
        if (z) {
            this.cDd = true;
        }
        if (!z || (z3 && !isInFilterMode())) {
            z2 = false;
        }
        super.setFocusableInTouchMode(z2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void akJ() {
        boolean z = false;
        T adapter = getAdapter();
        boolean z2 = !(adapter == null || adapter.getCount() == 0) || isInFilterMode();
        super.setFocusableInTouchMode(z2 && this.cDe);
        super.setFocusable(z2 && this.cDd);
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
            if (this.ajq) {
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
        private Parcelable cDh = null;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            g.this.ajq = true;
            g.this.cCZ = g.this.cCY;
            g.this.cCY = g.this.getAdapter().getCount();
            if (g.this.getAdapter().hasStableIds() && this.cDh != null && g.this.cCZ == 0 && g.this.cCY > 0) {
                g.this.onRestoreInstanceState(this.cDh);
                this.cDh = null;
            } else {
                g.this.akQ();
            }
            g.this.akJ();
            g.this.requestLayout();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            g.this.ajq = true;
            if (g.this.getAdapter().hasStableIds()) {
                this.cDh = g.this.onSaveInstanceState();
            }
            g.this.cCZ = g.this.cCY;
            g.this.cCY = 0;
            g.this.cjm = -1;
            g.this.cCX = Long.MIN_VALUE;
            g.this.cCV = -1;
            g.this.cCW = Long.MIN_VALUE;
            g.this.cCQ = false;
            g.this.akJ();
            g.this.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.cDf);
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
            if (g.this.ajq) {
                if (g.this.getAdapter() != null) {
                    g.this.post(this);
                    return;
                }
                return;
            }
            g.this.akL();
            g.this.akM();
        }
    }

    void akK() {
        if (this.cCS != null || this.cDa.isEnabled()) {
            if (this.mInLayout || this.cDg) {
                if (this.cDf == null) {
                    this.cDf = new f(this, null);
                }
                post(this.cDf);
                return;
            }
            akL();
            akM();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akL() {
        if (this.cCS != null) {
            int selectedItemPosition = getSelectedItemPosition();
            if (selectedItemPosition >= 0) {
                this.cCS.c(this, getSelectedView(), selectedItemPosition, getAdapter().getItemId(selectedItemPosition));
                return;
            }
            this.cCS.d(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akM() {
        if (this.cDa.isEnabled() && getSelectedItemPosition() >= 0) {
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
        accessibilityNodeInfo.setScrollable(akN());
        View selectedView = getSelectedView();
        if (selectedView != null) {
            accessibilityNodeInfo.setEnabled(selectedView.isEnabled());
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(g.class.getName());
        accessibilityEvent.setScrollable(akN());
        View selectedView = getSelectedView();
        if (selectedView != null) {
            accessibilityEvent.setEnabled(selectedView.isEnabled());
        }
        accessibilityEvent.setCurrentItemIndex(getSelectedItemPosition());
        accessibilityEvent.setFromIndex(getFirstVisiblePosition());
        accessibilityEvent.setToIndex(getLastVisiblePosition());
        accessibilityEvent.setItemCount(getCount());
    }

    private boolean akN() {
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
        return super.canAnimate() && this.cCY > 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void handleDataChanged() {
        boolean z;
        boolean z2;
        int i = this.cCY;
        if (i > 0) {
            if (this.cCQ) {
                this.cCQ = false;
                int akP = akP();
                if (akP >= 0 && q(akP, true) == akP) {
                    setNextSelectedPositionInt(akP);
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
                            akO();
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
            this.cjm = -1;
            this.cCX = Long.MIN_VALUE;
            this.cCV = -1;
            this.cCW = Long.MIN_VALUE;
            this.cCQ = false;
            akO();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void akO() {
        if (this.cjm != this.cDb || this.cCX != this.cDc) {
            akK();
            this.cDb = this.cjm;
            this.cDc = this.cCX;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int akP() {
        int i = this.cCY;
        if (i == 0) {
            return -1;
        }
        long j = this.cCO;
        int i2 = this.cCN;
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
        this.cjm = i;
        this.cCX = getItemIdAtPosition(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setNextSelectedPositionInt(int i) {
        this.cCV = i;
        this.cCW = getItemIdAtPosition(i);
        if (this.cCQ && this.cCR == 0 && i >= 0) {
            this.cCN = i;
            this.cCO = this.cCW;
        }
    }

    public void akQ() {
        if (getChildCount() > 0) {
            this.cCQ = true;
            this.cCP = this.mLayoutWidth;
            if (this.cjm >= 0) {
                View childAt = getChildAt(this.cjm - this.cCL);
                this.cCO = this.cCW;
                this.cCN = this.cCV;
                if (childAt != null) {
                    this.cCM = childAt.getLeft();
                }
                this.cCR = 0;
                return;
            }
            View childAt2 = getChildAt(0);
            T adapter = getAdapter();
            if (this.cCL >= 0 && this.cCL < adapter.getCount()) {
                this.cCO = adapter.getItemId(this.cCL);
            } else {
                this.cCO = -1L;
            }
            this.cCN = this.cCL;
            if (childAt2 != null) {
                this.cCM = childAt2.getLeft();
            }
            this.cCR = 1;
        }
    }
}
