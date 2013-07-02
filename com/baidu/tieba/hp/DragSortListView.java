package com.baidu.tieba.hp;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.Checkable;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.baidu.tieba.al;
import com.baidu.zeus.WebChromeClient;
import com.mofamulu.tieba.dslv.a;
import com.mofamulu.tieba.dslv.c;
import com.mofamulu.tieba.dslv.d;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class DragSortListView extends ListView {
    private View[] A;
    private DragScroller B;
    private float C;
    private float D;
    private int E;
    private int F;
    private float G;
    private float H;
    private float I;
    private float J;
    private float K;
    private DragScrollProfile L;
    private int M;
    private int N;
    private int O;
    private int P;
    private int Q;
    private int R;
    private boolean S;
    private boolean T;
    private FloatViewManager U;
    private MotionEvent V;
    private int W;
    private float X;
    private float Y;
    private AdapterWrapper Z;
    private View a;
    private boolean aa;
    private DragSortTracker ab;
    private boolean ac;
    private boolean ad;
    private HeightCache ae;
    private RemoveAnimator af;
    private LiftAnimator ag;
    private DropAnimator ah;
    private boolean ai;
    private float aj;
    private boolean ak;
    private boolean al;
    private Point b;
    private Point c;
    private int d;
    private boolean e;
    private DataSetObserver f;
    private float g;
    private float h;
    private int i;
    private int j;
    private int k;
    private boolean l;
    private int m;
    private int n;
    private int o;
    private int p;
    private int q;
    private DragListener r;
    private DropListener s;
    private RemoveListener t;
    private boolean u;
    private int v;
    private int w;
    private int x;
    private int y;
    private int z;

    /* loaded from: classes.dex */
    public interface DragListener {
        void a(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface DragScrollProfile {
        float a(float f, long j);
    }

    /* loaded from: classes.dex */
    public interface DragSortListener extends DragListener, DropListener, RemoveListener {
    }

    /* loaded from: classes.dex */
    public interface DropListener {
        void a_(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface FloatViewManager {
        View a(int i);

        void a(View view);

        void a(View view, Point point, Point point2);
    }

    /* loaded from: classes.dex */
    public interface RemoveListener {
        void a(int i);
    }

    public DragSortListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int i;
        this.b = new Point();
        this.c = new Point();
        this.e = false;
        this.g = 1.0f;
        this.h = 1.0f;
        this.l = false;
        this.u = true;
        this.v = 0;
        this.w = 1;
        this.z = 0;
        this.A = new View[1];
        this.C = 0.33333334f;
        this.D = 0.33333334f;
        this.K = 0.5f;
        this.L = new DragScrollProfile() { // from class: com.baidu.tieba.hp.DragSortListView.1
            @Override // com.baidu.tieba.hp.DragSortListView.DragScrollProfile
            public float a(float f, long j) {
                return DragSortListView.this.K * f;
            }
        };
        this.R = 0;
        this.S = false;
        this.T = false;
        this.U = null;
        this.W = 0;
        this.X = 0.25f;
        this.Y = 0.0f;
        this.aa = false;
        this.ac = false;
        this.ad = false;
        this.ae = new HeightCache(3);
        this.aj = 0.0f;
        this.ak = false;
        this.al = false;
        int i2 = WebChromeClient.STRING_DLG_BTN_SET;
        if (attributeSet == null) {
            i = 150;
        } else {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, al.DragSortListView, 0, 0);
            this.w = Math.max(1, obtainStyledAttributes.getDimensionPixelSize(0, 1));
            this.aa = obtainStyledAttributes.getBoolean(5, false);
            if (this.aa) {
                this.ab = new DragSortTracker();
            }
            this.g = obtainStyledAttributes.getFloat(6, this.g);
            this.h = this.g;
            this.u = obtainStyledAttributes.getBoolean(10, this.u);
            this.X = Math.max(0.0f, Math.min(1.0f, 1.0f - obtainStyledAttributes.getFloat(7, 0.75f)));
            this.l = this.X > 0.0f;
            setDragScrollStart(obtainStyledAttributes.getFloat(1, this.C));
            this.K = obtainStyledAttributes.getFloat(2, this.K);
            int i3 = obtainStyledAttributes.getInt(8, WebChromeClient.STRING_DLG_BTN_SET);
            int i4 = obtainStyledAttributes.getInt(9, WebChromeClient.STRING_DLG_BTN_SET);
            if (obtainStyledAttributes.getBoolean(17, true)) {
                boolean z = obtainStyledAttributes.getBoolean(12, false);
                int i5 = obtainStyledAttributes.getInt(4, 1);
                boolean z2 = obtainStyledAttributes.getBoolean(11, true);
                int i6 = obtainStyledAttributes.getInt(13, 0);
                int resourceId = obtainStyledAttributes.getResourceId(14, 0);
                int resourceId2 = obtainStyledAttributes.getResourceId(15, 0);
                int resourceId3 = obtainStyledAttributes.getResourceId(16, 0);
                int color = obtainStyledAttributes.getColor(3, -16777216);
                a aVar = new a(this, resourceId, i6, i5, resourceId3, resourceId2);
                aVar.b(z);
                aVar.a(z2);
                aVar.d(color);
                this.U = aVar;
                setOnTouchListener(aVar);
            }
            obtainStyledAttributes.recycle();
            i = i4;
            i2 = i3;
        }
        this.B = new DragScroller();
        if (i2 > 0) {
            this.af = new RemoveAnimator(0.5f, i2);
        }
        if (i > 0) {
            this.ah = new DropAnimator(0.5f, i);
        }
        this.V = MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        this.f = new DataSetObserver() { // from class: com.baidu.tieba.hp.DragSortListView.2
            private void a() {
                if (DragSortListView.this.v == 4) {
                    DragSortListView.this.a();
                }
            }

            @Override // android.database.DataSetObserver
            public void onChanged() {
                a();
            }

            @Override // android.database.DataSetObserver
            public void onInvalidated() {
                a();
            }
        };
    }

    public void setFloatAlpha(float f) {
        this.h = f;
    }

    public float getFloatAlpha() {
        return this.h;
    }

    public void setMaxScrollSpeed(float f) {
        this.K = f;
    }

    @Override // android.widget.ListView, android.widget.AbsListView
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            this.Z = new AdapterWrapper(listAdapter);
            listAdapter.registerDataSetObserver(this.f);
            if (listAdapter instanceof DropListener) {
                setDropListener((DropListener) listAdapter);
            }
            if (listAdapter instanceof DragListener) {
                setDragListener((DragListener) listAdapter);
            }
            if (listAdapter instanceof RemoveListener) {
                setRemoveListener((RemoveListener) listAdapter);
            }
        } else {
            this.Z = null;
        }
        super.setAdapter((ListAdapter) this.Z);
    }

    public ListAdapter getInputAdapter() {
        if (this.Z == null) {
            return null;
        }
        return this.Z.a();
    }

    /* loaded from: classes.dex */
    class AdapterWrapper extends BaseAdapter {
        private ListAdapter b;

        public AdapterWrapper(ListAdapter listAdapter) {
            this.b = listAdapter;
            this.b.registerDataSetObserver(new DataSetObserver() { // from class: com.baidu.tieba.hp.DragSortListView.AdapterWrapper.1
                @Override // android.database.DataSetObserver
                public void onChanged() {
                    AdapterWrapper.this.notifyDataSetChanged();
                }

                @Override // android.database.DataSetObserver
                public void onInvalidated() {
                    AdapterWrapper.this.notifyDataSetInvalidated();
                }
            });
        }

        public ListAdapter a() {
            return this.b;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return this.b.getItemId(i);
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.b.getItem(i);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.b.getCount();
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            return this.b.areAllItemsEnabled();
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean isEnabled(int i) {
            return this.b.isEnabled(i);
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i) {
            return this.b.getItemViewType(i);
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return this.b.getViewTypeCount();
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return this.b.hasStableIds();
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean isEmpty() {
            return this.b.isEmpty();
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            c cVar;
            c cVar2;
            if (view != null) {
                cVar2 = (c) view;
                View childAt = cVar2.getChildAt(0);
                View view2 = this.b.getView(i, childAt, DragSortListView.this);
                if (view2 != childAt) {
                    if (childAt != null) {
                        cVar2.removeViewAt(0);
                    }
                    cVar2.addView(view2);
                }
            } else {
                View view3 = this.b.getView(i, null, DragSortListView.this);
                if (view3 instanceof Checkable) {
                    cVar = new d(DragSortListView.this.getContext());
                } else {
                    cVar = new c(DragSortListView.this.getContext());
                }
                cVar.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
                cVar.addView(view3);
                cVar2 = cVar;
            }
            DragSortListView.this.a(DragSortListView.this.getHeaderViewsCount() + i, (View) cVar2, true);
            return cVar2;
        }
    }

    private void a(int i, Canvas canvas) {
        ViewGroup viewGroup;
        int bottom;
        int i2;
        Drawable divider = getDivider();
        int dividerHeight = getDividerHeight();
        if (divider != null && dividerHeight != 0 && (viewGroup = (ViewGroup) getChildAt(i - getFirstVisiblePosition())) != null) {
            int paddingLeft = getPaddingLeft();
            int width = getWidth() - getPaddingRight();
            int height = viewGroup.getChildAt(0).getHeight();
            if (i > this.m) {
                i2 = height + viewGroup.getTop();
                bottom = i2 + dividerHeight;
            } else {
                bottom = viewGroup.getBottom() - height;
                i2 = bottom - dividerHeight;
            }
            canvas.save();
            canvas.clipRect(paddingLeft, i2, width, bottom);
            divider.setBounds(paddingLeft, i2, width, bottom);
            divider.draw(canvas);
            canvas.restore();
        }
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        float f;
        super.dispatchDraw(canvas);
        if (this.v != 0) {
            if (this.j != this.m) {
                a(this.j, canvas);
            }
            if (this.k != this.j && this.k != this.m) {
                a(this.k, canvas);
            }
        }
        if (this.a != null) {
            int width = this.a.getWidth();
            int height = this.a.getHeight();
            int i = this.b.x;
            int width2 = getWidth();
            if (i < 0) {
                i = -i;
            }
            if (i < width2) {
                float f2 = (width2 - i) / width2;
                f = f2 * f2;
            } else {
                f = 0.0f;
            }
            int i2 = (int) (f * 255.0f * this.h);
            canvas.save();
            canvas.translate(this.b.x, this.b.y);
            canvas.clipRect(0, 0, width, height);
            canvas.saveLayerAlpha(0.0f, 0.0f, width, height, i2, 31);
            this.a.draw(canvas);
            canvas.restore();
            canvas.restore();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b(int i) {
        View childAt = getChildAt(i - getFirstVisiblePosition());
        return childAt != null ? childAt.getHeight() : c(i, d(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class HeightCache {
        private SparseIntArray b;
        private ArrayList c;
        private int d;

        public HeightCache(int i) {
            this.b = new SparseIntArray(i);
            this.c = new ArrayList(i);
            this.d = i;
        }

        public void a(int i, int i2) {
            int i3 = this.b.get(i, -1);
            if (i3 != i2) {
                if (i3 == -1) {
                    if (this.b.size() == this.d) {
                        this.b.delete(((Integer) this.c.remove(0)).intValue());
                    }
                } else {
                    this.c.remove(Integer.valueOf(i));
                }
                this.b.put(i, i2);
                this.c.add(Integer.valueOf(i));
            }
        }

        public int a(int i) {
            return this.b.get(i, -1);
        }

        public void a() {
            this.b.clear();
            this.c.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(int i, int i2) {
        int headerViewsCount = getHeaderViewsCount();
        int footerViewsCount = getFooterViewsCount();
        if (i <= headerViewsCount || i >= getCount() - footerViewsCount) {
            return i2;
        }
        int dividerHeight = getDividerHeight();
        int i3 = this.x - this.w;
        int d = d(i);
        int b = b(i);
        if (this.k <= this.m) {
            if (i != this.k || this.j == this.k) {
                if (i > this.k && i <= this.m) {
                    i2 -= i3;
                }
            } else if (i == this.m) {
                i2 = (i2 + b) - this.x;
            } else {
                i2 = ((b - d) + i2) - i3;
            }
        } else if (i > this.m && i <= this.j) {
            i2 += i3;
        } else if (i == this.k && this.j != this.k) {
            i2 += b - d;
        }
        if (i <= this.m) {
            return (((this.x - dividerHeight) - d(i - 1)) / 2) + i2;
        }
        return (((d - dividerHeight) - this.x) / 2) + i2;
    }

    private boolean d() {
        int i;
        int i2;
        int i3;
        int firstVisiblePosition = getFirstVisiblePosition();
        int i4 = this.j;
        View childAt = getChildAt(i4 - firstVisiblePosition);
        if (childAt == null) {
            i4 = firstVisiblePosition + (getChildCount() / 2);
            childAt = getChildAt(i4 - firstVisiblePosition);
        }
        int top = childAt.getTop();
        int height = childAt.getHeight();
        int a = a(i4, top);
        int dividerHeight = getDividerHeight();
        if (this.d >= a) {
            int count = getCount();
            int i5 = height;
            int i6 = top;
            i = a;
            i2 = i4;
            i3 = a;
            while (true) {
                if (i2 < count) {
                    if (i2 == count - 1) {
                        i = i6 + dividerHeight + i5;
                        break;
                    }
                    i6 += dividerHeight + i5;
                    i5 = b(i2 + 1);
                    i = a(i2 + 1, i6);
                    if (this.d < i) {
                        break;
                    }
                    i2++;
                    i3 = i;
                } else {
                    break;
                }
            }
        } else {
            int i7 = top;
            i = a;
            i2 = i4;
            i3 = a;
            while (true) {
                if (i2 >= 0) {
                    i2--;
                    int b = b(i2);
                    if (i2 == 0) {
                        i = (i7 - dividerHeight) - b;
                        break;
                    }
                    i7 -= b + dividerHeight;
                    i = a(i2, i7);
                    if (this.d >= i) {
                        break;
                    }
                    i3 = i;
                } else {
                    break;
                }
            }
        }
        int headerViewsCount = getHeaderViewsCount();
        int footerViewsCount = getFooterViewsCount();
        int i8 = this.j;
        int i9 = this.k;
        float f = this.Y;
        if (this.l) {
            int abs = Math.abs(i - i3);
            if (this.d >= i) {
                int i10 = i3;
                i3 = i;
                i = i10;
            }
            int i11 = (int) (abs * this.X * 0.5f);
            float f2 = i11;
            int i12 = i3 + i11;
            int i13 = i - i11;
            if (this.d < i12) {
                this.j = i2 - 1;
                this.k = i2;
                this.Y = ((i12 - this.d) * 0.5f) / f2;
            } else if (this.d < i13) {
                this.j = i2;
                this.k = i2;
            } else {
                this.j = i2;
                this.k = i2 + 1;
                this.Y = (1.0f + ((i - this.d) / f2)) * 0.5f;
            }
        } else {
            this.j = i2;
            this.k = i2;
        }
        if (this.j < headerViewsCount) {
            this.j = headerViewsCount;
            this.k = headerViewsCount;
            i2 = headerViewsCount;
        } else if (this.k >= getCount() - footerViewsCount) {
            i2 = (getCount() - footerViewsCount) - 1;
            this.j = i2;
            this.k = i2;
        }
        boolean z = (this.j == i8 && this.k == i9 && this.Y == f) ? false : true;
        if (i2 != this.i) {
            if (this.r != null) {
                this.r.a(this.i - headerViewsCount, i2 - headerViewsCount);
            }
            this.i = i2;
            return true;
        }
        return z;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.aa) {
            this.ab.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class SmoothAnimator implements Runnable {
        private float a;
        protected long b;
        private float d;
        private float e;
        private float f;
        private float g;
        private float h;
        private boolean i;

        public SmoothAnimator(float f, int i) {
            this.d = f;
            this.a = i;
            float f2 = 1.0f / ((this.d * 2.0f) * (1.0f - this.d));
            this.h = f2;
            this.e = f2;
            this.f = this.d / ((this.d - 1.0f) * 2.0f);
            this.g = 1.0f / (1.0f - this.d);
        }

        public float a(float f) {
            if (f < this.d) {
                return this.e * f * f;
            }
            if (f < 1.0f - this.d) {
                return this.f + (this.g * f);
            }
            return 1.0f - ((this.h * (f - 1.0f)) * (f - 1.0f));
        }

        public void c() {
            this.b = SystemClock.uptimeMillis();
            this.i = false;
            a();
            DragSortListView.this.post(this);
        }

        public void d() {
            this.i = true;
        }

        public void a() {
        }

        public void a(float f, float f2) {
        }

        public void b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.i) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.b)) / this.a;
                if (uptimeMillis >= 1.0f) {
                    a(1.0f, 1.0f);
                    b();
                    return;
                }
                a(uptimeMillis, a(uptimeMillis));
                DragSortListView.this.post(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class LiftAnimator extends SmoothAnimator {
        final /* synthetic */ DragSortListView a;
        private float d;
        private float e;

        @Override // com.baidu.tieba.hp.DragSortListView.SmoothAnimator
        public void a() {
            this.d = this.a.o;
            this.e = this.a.y;
        }

        @Override // com.baidu.tieba.hp.DragSortListView.SmoothAnimator
        public void a(float f, float f2) {
            if (this.a.v != 4) {
                d();
                return;
            }
            this.a.o = (int) ((this.e * f2) + ((1.0f - f2) * this.d));
            this.a.b.y = this.a.N - this.a.o;
            this.a.b(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class DropAnimator extends SmoothAnimator {
        private int d;
        private int e;
        private float f;
        private float g;

        public DropAnimator(float f, int i) {
            super(f, i);
        }

        @Override // com.baidu.tieba.hp.DragSortListView.SmoothAnimator
        public void a() {
            this.d = DragSortListView.this.i;
            this.e = DragSortListView.this.m;
            DragSortListView.this.v = 2;
            this.f = DragSortListView.this.b.y - e();
            this.g = DragSortListView.this.b.x - DragSortListView.this.getPaddingLeft();
        }

        private int e() {
            int firstVisiblePosition = DragSortListView.this.getFirstVisiblePosition();
            int dividerHeight = (DragSortListView.this.w + DragSortListView.this.getDividerHeight()) / 2;
            View childAt = DragSortListView.this.getChildAt(this.d - firstVisiblePosition);
            if (childAt != null) {
                if (this.d == this.e) {
                    return childAt.getTop();
                }
                if (this.d >= this.e) {
                    return (childAt.getBottom() + dividerHeight) - DragSortListView.this.x;
                }
                return childAt.getTop() - dividerHeight;
            }
            d();
            return -1;
        }

        @Override // com.baidu.tieba.hp.DragSortListView.SmoothAnimator
        public void a(float f, float f2) {
            int e = e();
            float paddingLeft = DragSortListView.this.b.x - DragSortListView.this.getPaddingLeft();
            float f3 = 1.0f - f2;
            if (f3 < Math.abs((DragSortListView.this.b.y - e) / this.f) || f3 < Math.abs(paddingLeft / this.g)) {
                DragSortListView.this.b.y = e + ((int) (this.f * f3));
                DragSortListView.this.b.x = DragSortListView.this.getPaddingLeft() + ((int) (this.g * f3));
                DragSortListView.this.b(true);
            }
        }

        @Override // com.baidu.tieba.hp.DragSortListView.SmoothAnimator
        public void b() {
            DragSortListView.this.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class RemoveAnimator extends SmoothAnimator {
        private float d;
        private float e;
        private float f;
        private int g;
        private int h;
        private int i;
        private int j;
        private int k;

        public RemoveAnimator(float f, int i) {
            super(f, i);
            this.g = -1;
            this.h = -1;
        }

        @Override // com.baidu.tieba.hp.DragSortListView.SmoothAnimator
        public void a() {
            this.g = -1;
            this.h = -1;
            this.i = DragSortListView.this.j;
            this.j = DragSortListView.this.k;
            this.k = DragSortListView.this.m;
            DragSortListView.this.v = 1;
            this.d = DragSortListView.this.b.x;
            if (DragSortListView.this.ai) {
                float width = DragSortListView.this.getWidth() * 2.0f;
                if (DragSortListView.this.aj == 0.0f) {
                    DragSortListView.this.aj = (this.d >= 0.0f ? 1 : -1) * width;
                    return;
                }
                float f = width * 2.0f;
                if (DragSortListView.this.aj >= 0.0f || DragSortListView.this.aj <= (-f)) {
                    if (DragSortListView.this.aj > 0.0f && DragSortListView.this.aj < f) {
                        DragSortListView.this.aj = f;
                        return;
                    }
                    return;
                }
                DragSortListView.this.aj = -f;
                return;
            }
            DragSortListView.this.n();
        }

        @Override // com.baidu.tieba.hp.DragSortListView.SmoothAnimator
        public void a(float f, float f2) {
            View childAt;
            float f3 = 1.0f - f2;
            int firstVisiblePosition = DragSortListView.this.getFirstVisiblePosition();
            View childAt2 = DragSortListView.this.getChildAt(this.i - firstVisiblePosition);
            if (DragSortListView.this.ai) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.b)) / 1000.0f;
                if (uptimeMillis != 0.0f) {
                    float f4 = DragSortListView.this.aj * uptimeMillis;
                    int width = DragSortListView.this.getWidth();
                    DragSortListView dragSortListView = DragSortListView.this;
                    dragSortListView.aj = ((DragSortListView.this.aj > 0.0f ? 1 : -1) * uptimeMillis * width) + dragSortListView.aj;
                    this.d += f4;
                    DragSortListView.this.b.x = (int) this.d;
                    if (this.d < width && this.d > (-width)) {
                        this.b = SystemClock.uptimeMillis();
                        DragSortListView.this.b(true);
                        return;
                    }
                } else {
                    return;
                }
            }
            if (childAt2 != null) {
                if (this.g == -1) {
                    this.g = DragSortListView.this.b(this.i, childAt2, false);
                    this.e = childAt2.getHeight() - this.g;
                }
                int max = Math.max((int) (this.e * f3), 1);
                ViewGroup.LayoutParams layoutParams = childAt2.getLayoutParams();
                layoutParams.height = max + this.g;
                childAt2.setLayoutParams(layoutParams);
            }
            if (this.j != this.i && (childAt = DragSortListView.this.getChildAt(this.j - firstVisiblePosition)) != null) {
                if (this.h == -1) {
                    this.h = DragSortListView.this.b(this.j, childAt, false);
                    this.f = childAt.getHeight() - this.h;
                }
                int max2 = Math.max((int) (this.f * f3), 1);
                ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
                layoutParams2.height = max2 + this.h;
                childAt.setLayoutParams(layoutParams2);
            }
        }

        @Override // com.baidu.tieba.hp.DragSortListView.SmoothAnimator
        public void b() {
            DragSortListView.this.g();
        }
    }

    public void a(int i) {
        this.ai = false;
        a(i, 0.0f);
    }

    public void a(int i, float f) {
        if (this.v == 0 || this.v == 4) {
            if (this.v == 0) {
                this.m = getHeaderViewsCount() + i;
                this.j = this.m;
                this.k = this.m;
                this.i = this.m;
                View childAt = getChildAt(this.m - getFirstVisiblePosition());
                if (childAt != null) {
                    childAt.setVisibility(4);
                }
            }
            this.v = 1;
            this.aj = f;
            if (this.T) {
                switch (this.W) {
                    case 1:
                        super.onTouchEvent(this.V);
                        break;
                    case 2:
                        super.onInterceptTouchEvent(this.V);
                        break;
                }
            }
            if (this.af != null) {
                this.af.c();
            } else {
                c(i);
            }
        }
    }

    public void a() {
        if (this.v == 4) {
            this.B.a(true);
            n();
            e();
            k();
            if (this.T) {
                this.v = 3;
            } else {
                this.v = 0;
            }
        }
    }

    private void e() {
        this.m = -1;
        this.j = -1;
        this.k = -1;
        this.i = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.v = 2;
        if (this.s != null && this.i >= 0 && this.i < getCount()) {
            int headerViewsCount = getHeaderViewsCount();
            this.s.a_(this.m - headerViewsCount, this.i - headerViewsCount);
        }
        n();
        h();
        e();
        k();
        if (this.T) {
            this.v = 3;
        } else {
            this.v = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        c(this.m - getHeaderViewsCount());
    }

    private void c(int i) {
        this.v = 1;
        if (this.t != null) {
            this.t.a(i);
        }
        n();
        h();
        e();
        if (this.T) {
            this.v = 3;
        } else {
            this.v = 0;
        }
    }

    private void h() {
        int firstVisiblePosition = getFirstVisiblePosition();
        if (this.m < firstVisiblePosition) {
            View childAt = getChildAt(0);
            setSelectionFromTop(firstVisiblePosition - 1, (childAt != null ? childAt.getTop() : 0) - getPaddingTop());
        }
    }

    public boolean a(boolean z) {
        this.ai = false;
        return b(z, 0.0f);
    }

    public boolean a(boolean z, float f) {
        this.ai = true;
        return b(z, f);
    }

    public boolean b(boolean z, float f) {
        if (this.a != null) {
            this.B.a(true);
            if (z) {
                a(this.m - getHeaderViewsCount(), f);
            } else if (this.ah != null) {
                this.ah.c();
            } else {
                f();
            }
            if (this.aa) {
                this.ab.d();
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.ad) {
            this.ad = false;
            return false;
        } else if (!this.u) {
            return super.onTouchEvent(motionEvent);
        } else {
            boolean z2 = this.S;
            this.S = false;
            if (!z2) {
                b(motionEvent);
            }
            if (this.v == 4) {
                a(motionEvent);
                return true;
            }
            if (this.v == 0 && super.onTouchEvent(motionEvent)) {
                z = true;
            }
            switch (motionEvent.getAction() & 255) {
                case 1:
                case 3:
                    i();
                    return z;
                case 2:
                default:
                    if (z) {
                        this.W = 1;
                        return z;
                    }
                    return z;
            }
        }
    }

    private void i() {
        this.W = 0;
        this.T = false;
        if (this.v == 3) {
            this.v = 0;
        }
        this.h = this.g;
        this.ak = false;
        this.ae.a();
    }

    private void b(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            this.O = this.M;
            this.P = this.N;
        }
        this.M = (int) motionEvent.getX();
        this.N = (int) motionEvent.getY();
        if (action == 0) {
            this.O = this.M;
            this.P = this.N;
        }
        this.p = ((int) motionEvent.getRawX()) - this.M;
        this.q = ((int) motionEvent.getRawY()) - this.N;
    }

    public boolean b() {
        return this.ak;
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (!this.u) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        b(motionEvent);
        this.S = true;
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            if (this.v != 0) {
                this.ad = true;
                return true;
            }
            this.T = true;
        }
        if (this.a == null) {
            if (super.onInterceptTouchEvent(motionEvent)) {
                this.ak = true;
                z = true;
            } else {
                z = false;
            }
            switch (action) {
                case 1:
                case 3:
                    i();
                    break;
                case 2:
                default:
                    if (z) {
                        this.W = 1;
                        break;
                    } else {
                        this.W = 2;
                        break;
                    }
            }
        } else {
            z = true;
        }
        if (action == 1 || action == 3) {
            this.T = false;
        }
        return z;
    }

    public void setDragScrollStart(float f) {
        a(f, f);
    }

    public void a(float f, float f2) {
        if (f2 > 0.5f) {
            this.D = 0.5f;
        } else {
            this.D = f2;
        }
        if (f > 0.5f) {
            this.C = 0.5f;
        } else {
            this.C = f;
        }
        if (getHeight() != 0) {
            j();
        }
    }

    private void b(int i, int i2) {
        this.b.x = i - this.n;
        this.b.y = i2 - this.o;
        b(true);
        int min = Math.min(i2, this.d + this.y);
        int max = Math.max(i2, this.d - this.y);
        int b = this.B.b();
        if (min > this.P && min > this.F && b != 1) {
            if (b != -1) {
                this.B.a(true);
            }
            this.B.a(1);
        } else if (max < this.P && max < this.E && b != 0) {
            if (b != -1) {
                this.B.a(true);
            }
            this.B.a(0);
        } else if (max >= this.E && min <= this.F && this.B.a()) {
            this.B.a(true);
        }
    }

    private void j() {
        int height;
        int paddingTop = getPaddingTop();
        float height2 = (getHeight() - paddingTop) - getPaddingBottom();
        this.H = paddingTop + (this.C * height2);
        this.G = (height2 * (1.0f - this.D)) + paddingTop;
        this.E = (int) this.H;
        this.F = (int) this.G;
        this.I = this.H - paddingTop;
        this.J = (paddingTop + height) - this.G;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        j();
    }

    private void k() {
        int firstVisiblePosition = getFirstVisiblePosition();
        int lastVisiblePosition = getLastVisiblePosition();
        int min = Math.min(lastVisiblePosition - firstVisiblePosition, ((getCount() - 1) - getFooterViewsCount()) - firstVisiblePosition);
        for (int max = Math.max(0, getHeaderViewsCount() - firstVisiblePosition); max <= min; max++) {
            View childAt = getChildAt(max);
            if (childAt != null) {
                a(firstVisiblePosition + max, childAt, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, View view, boolean z) {
        int c;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (i != this.m && i != this.j && i != this.k) {
            c = -2;
        } else {
            c = c(i, view, z);
        }
        if (c != layoutParams.height) {
            layoutParams.height = c;
            view.setLayoutParams(layoutParams);
        }
        if (i == this.j || i == this.k) {
            if (i < this.m) {
                ((c) view).setGravity(80);
            } else if (i > this.m) {
                ((c) view).setGravity(48);
            }
        }
        int visibility = view.getVisibility();
        int i2 = 0;
        if (i == this.m && this.a != null) {
            i2 = 4;
        }
        if (i2 != visibility) {
            view.setVisibility(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int d(int i) {
        View view;
        if (i == this.m) {
            return 0;
        }
        View childAt = getChildAt(i - getFirstVisiblePosition());
        if (childAt != null) {
            return b(i, childAt, false);
        }
        int a = this.ae.a(i);
        if (a == -1) {
            ListAdapter adapter = getAdapter();
            int itemViewType = adapter.getItemViewType(i);
            int viewTypeCount = adapter.getViewTypeCount();
            if (viewTypeCount != this.A.length) {
                this.A = new View[viewTypeCount];
            }
            if (itemViewType >= 0) {
                if (this.A[itemViewType] == null) {
                    view = adapter.getView(i, null, this);
                    this.A[itemViewType] = view;
                } else {
                    view = adapter.getView(i, this.A[itemViewType], this);
                }
            } else {
                view = adapter.getView(i, null, this);
            }
            int b = b(i, view, true);
            this.ae.a(i, b);
            return b;
        }
        return a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b(int i, View view, boolean z) {
        if (i == this.m) {
            return 0;
        }
        if (i >= getHeaderViewsCount() && i < getCount() - getFooterViewsCount()) {
            view = ((ViewGroup) view).getChildAt(0);
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null && layoutParams.height > 0) {
            return layoutParams.height;
        }
        int height = view.getHeight();
        if (height == 0 || z) {
            a(view);
            return view.getMeasuredHeight();
        }
        return height;
    }

    private int c(int i, View view, boolean z) {
        return c(i, b(i, view, z));
    }

    private int c(int i, int i2) {
        getDividerHeight();
        boolean z = this.l && this.j != this.k;
        int i3 = this.x - this.w;
        int i4 = (int) (this.Y * i3);
        if (i == this.m) {
            if (this.m == this.j) {
                if (z) {
                    return i4 + this.w;
                }
                return this.x;
            } else if (this.m == this.k) {
                return this.x - i4;
            } else {
                return this.w;
            }
        } else if (i == this.j) {
            if (z) {
                return i2 + i4;
            }
            return i2 + i3;
        } else if (i == this.k) {
            return (i2 + i3) - i4;
        } else {
            return i2;
        }
    }

    @Override // android.widget.AbsListView, android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (!this.ac) {
            super.requestLayout();
        }
    }

    private int a(int i, View view, int i2, int i3) {
        int i4;
        int i5;
        int d = d(i);
        int height = view.getHeight();
        int c = c(i, d);
        if (i != this.m) {
            i5 = height - d;
            i4 = c - d;
        } else {
            i4 = c;
            i5 = height;
        }
        int i6 = this.x;
        if (this.m != this.j && this.m != this.k) {
            i6 -= this.w;
        }
        if (i <= i2) {
            if (i > this.j) {
                return (i6 - i4) + 0;
            }
        } else if (i == i3) {
            if (i <= this.j) {
                return (i5 - i6) + 0;
            }
            if (i == this.k) {
                return (height - c) + 0;
            }
            return 0 + i5;
        } else if (i <= this.j) {
            return 0 - i6;
        } else {
            if (i == this.k) {
                return 0 - i4;
            }
        }
        return 0;
    }

    private void a(View view) {
        int makeMeasureSpec;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new AbsListView.LayoutParams(-1, -2);
            view.setLayoutParams(layoutParams);
        }
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(this.z, getListPaddingLeft() + getListPaddingRight(), layoutParams.width);
        if (layoutParams.height > 0) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(childMeasureSpec, makeMeasureSpec);
    }

    private void l() {
        if (this.a != null) {
            a(this.a);
            this.x = this.a.getMeasuredHeight();
            this.y = this.x / 2;
        }
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.a != null) {
            if (this.a.isLayoutRequested()) {
                l();
            }
            this.e = true;
        }
        this.z = i;
    }

    @Override // android.widget.ListView, android.widget.AbsListView
    protected void layoutChildren() {
        super.layoutChildren();
        if (this.a != null) {
            if (this.a.isLayoutRequested() && !this.e) {
                l();
            }
            this.a.layout(0, 0, this.a.getMeasuredWidth(), this.a.getMeasuredHeight());
            this.e = false;
        }
    }

    protected boolean a(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        switch (motionEvent.getAction() & 255) {
            case 1:
                if (this.v == 4) {
                    a(false);
                }
                i();
                return true;
            case 2:
                b((int) motionEvent.getX(), (int) motionEvent.getY());
                return true;
            case 3:
                if (this.v == 4) {
                    a();
                }
                i();
                return true;
            default:
                return true;
        }
    }

    public boolean a(int i, int i2, int i3, int i4) {
        View a;
        if (!this.T || this.U == null || (a = this.U.a(i)) == null) {
            return false;
        }
        return a(i, a, i2, i3, i4);
    }

    public boolean a(int i, View view, int i2, int i3, int i4) {
        if (this.v == 0 && this.T && this.a == null && view != null && this.u) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            int headerViewsCount = getHeaderViewsCount() + i;
            this.j = headerViewsCount;
            this.k = headerViewsCount;
            this.m = headerViewsCount;
            this.i = headerViewsCount;
            this.v = 4;
            this.R = 0;
            this.R |= i2;
            this.a = view;
            l();
            this.n = i3;
            this.o = i4;
            this.Q = this.N;
            this.b.x = this.M - this.n;
            this.b.y = this.N - this.o;
            View childAt = getChildAt(this.m - getFirstVisiblePosition());
            if (childAt != null) {
                childAt.setVisibility(4);
            }
            if (this.aa) {
                this.ab.a();
            }
            switch (this.W) {
                case 1:
                    super.onTouchEvent(this.V);
                    break;
                case 2:
                    super.onInterceptTouchEvent(this.V);
                    break;
            }
            requestLayout();
            if (this.ag != null) {
                this.ag.c();
                return true;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        int firstVisiblePosition = getFirstVisiblePosition() + (getChildCount() / 2);
        View childAt = getChildAt(getChildCount() / 2);
        if (childAt != null) {
            d(firstVisiblePosition, childAt, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i, View view, boolean z) {
        this.ac = true;
        m();
        int i2 = this.j;
        int i3 = this.k;
        boolean d = d();
        if (d) {
            k();
            setSelectionFromTop(i, (a(i, view, i2, i3) + view.getTop()) - getPaddingTop());
            layoutChildren();
        }
        if (d || z) {
            invalidate();
        }
        this.ac = false;
    }

    private void m() {
        if (this.U != null) {
            this.c.set(this.M, this.N);
            this.U.a(this.a, this.b, this.c);
        }
        int i = this.b.x;
        int i2 = this.b.y;
        int paddingLeft = getPaddingLeft();
        if ((this.R & 1) == 0 && i > paddingLeft) {
            this.b.x = paddingLeft;
        } else if ((this.R & 2) == 0 && i < paddingLeft) {
            this.b.x = paddingLeft;
        }
        int headerViewsCount = getHeaderViewsCount();
        int footerViewsCount = getFooterViewsCount();
        int firstVisiblePosition = getFirstVisiblePosition();
        int lastVisiblePosition = getLastVisiblePosition();
        int paddingTop = getPaddingTop();
        if (firstVisiblePosition < headerViewsCount) {
            paddingTop = getChildAt((headerViewsCount - firstVisiblePosition) - 1).getBottom();
        }
        if ((this.R & 8) == 0 && firstVisiblePosition <= this.m) {
            paddingTop = Math.max(getChildAt(this.m - firstVisiblePosition).getTop(), paddingTop);
        }
        int height = getHeight() - getPaddingBottom();
        if (lastVisiblePosition >= (getCount() - footerViewsCount) - 1) {
            height = getChildAt(((getCount() - footerViewsCount) - 1) - firstVisiblePosition).getBottom();
        }
        if ((this.R & 4) == 0 && lastVisiblePosition >= this.m) {
            height = Math.min(getChildAt(this.m - firstVisiblePosition).getBottom(), height);
        }
        if (i2 < paddingTop) {
            this.b.y = paddingTop;
        } else if (this.x + i2 > height) {
            this.b.y = height - this.x;
        }
        this.d = this.b.y + this.y;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        if (this.a != null) {
            this.a.setVisibility(8);
            if (this.U != null) {
                this.U.a(this.a);
            }
            this.a = null;
            invalidate();
        }
    }

    public void setFloatViewManager(FloatViewManager floatViewManager) {
        this.U = floatViewManager;
    }

    public void setDragListener(DragListener dragListener) {
        this.r = dragListener;
    }

    public void setDragEnabled(boolean z) {
        this.u = z;
    }

    public boolean c() {
        return this.u;
    }

    public void setDropListener(DropListener dropListener) {
        this.s = dropListener;
    }

    public void setRemoveListener(RemoveListener removeListener) {
        this.t = removeListener;
    }

    public void setDragSortListener(DragSortListener dragSortListener) {
        setDropListener(dragSortListener);
        setDragListener(dragSortListener);
        setRemoveListener(dragSortListener);
    }

    public void setDragScrollProfile(DragScrollProfile dragScrollProfile) {
        if (dragScrollProfile != null) {
            this.L = dragScrollProfile;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class DragScroller implements Runnable {
        private boolean b;
        private long c;
        private long d;
        private int e;
        private float f;
        private long g;
        private int h;
        private float i;
        private boolean j = false;

        public boolean a() {
            return this.j;
        }

        public int b() {
            if (this.j) {
                return this.h;
            }
            return -1;
        }

        public DragScroller() {
        }

        public void a(int i) {
            if (!this.j) {
                this.b = false;
                this.j = true;
                this.g = SystemClock.uptimeMillis();
                this.c = this.g;
                this.h = i;
                DragSortListView.this.post(this);
            }
        }

        public void a(boolean z) {
            if (z) {
                DragSortListView.this.removeCallbacks(this);
                this.j = false;
                return;
            }
            this.b = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.b) {
                this.j = false;
                return;
            }
            int firstVisiblePosition = DragSortListView.this.getFirstVisiblePosition();
            int lastVisiblePosition = DragSortListView.this.getLastVisiblePosition();
            int count = DragSortListView.this.getCount();
            int paddingTop = DragSortListView.this.getPaddingTop();
            int height = (DragSortListView.this.getHeight() - paddingTop) - DragSortListView.this.getPaddingBottom();
            int min = Math.min(DragSortListView.this.N, DragSortListView.this.d + DragSortListView.this.y);
            int max = Math.max(DragSortListView.this.N, DragSortListView.this.d - DragSortListView.this.y);
            if (this.h == 0) {
                View childAt = DragSortListView.this.getChildAt(0);
                if (childAt == null) {
                    this.j = false;
                    return;
                } else if (firstVisiblePosition == 0 && childAt.getTop() == paddingTop) {
                    this.j = false;
                    return;
                } else {
                    this.i = DragSortListView.this.L.a((DragSortListView.this.H - max) / DragSortListView.this.I, this.c);
                }
            } else {
                View childAt2 = DragSortListView.this.getChildAt(lastVisiblePosition - firstVisiblePosition);
                if (childAt2 == null) {
                    this.j = false;
                    return;
                } else if (lastVisiblePosition == count - 1 && childAt2.getBottom() <= height + paddingTop) {
                    this.j = false;
                    return;
                } else {
                    this.i = -DragSortListView.this.L.a((min - DragSortListView.this.G) / DragSortListView.this.J, this.c);
                }
            }
            this.d = SystemClock.uptimeMillis();
            this.f = (float) (this.d - this.c);
            this.e = Math.round(this.i * this.f);
            if (this.e >= 0) {
                this.e = Math.min(height, this.e);
                lastVisiblePosition = firstVisiblePosition;
            } else {
                this.e = Math.max(-height, this.e);
            }
            View childAt3 = DragSortListView.this.getChildAt(lastVisiblePosition - firstVisiblePosition);
            int top = childAt3.getTop() + this.e;
            if (lastVisiblePosition == 0 && top > paddingTop) {
                top = paddingTop;
            }
            DragSortListView.this.ac = true;
            DragSortListView.this.setSelectionFromTop(lastVisiblePosition, top - paddingTop);
            DragSortListView.this.layoutChildren();
            DragSortListView.this.invalidate();
            DragSortListView.this.ac = false;
            DragSortListView.this.d(lastVisiblePosition, childAt3, false);
            this.c = this.d;
            DragSortListView.this.post(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class DragSortTracker {
        StringBuilder a = new StringBuilder();
        private int d = 0;
        private int e = 0;
        private boolean f = false;
        File b = new File(Environment.getExternalStorageDirectory(), "dslv_state.txt");

        public DragSortTracker() {
            if (!this.b.exists()) {
                try {
                    this.b.createNewFile();
                    Log.d("mobeta", "file created");
                } catch (IOException e) {
                    Log.w("mobeta", "Could not create dslv_state.txt");
                    Log.d("mobeta", e.getMessage());
                }
            }
        }

        public void a() {
            this.a.append("<DSLVStates>\n");
            this.e = 0;
            this.f = true;
        }

        public void b() {
            if (this.f) {
                this.a.append("<DSLVState>\n");
                int childCount = DragSortListView.this.getChildCount();
                int firstVisiblePosition = DragSortListView.this.getFirstVisiblePosition();
                this.a.append("    <Positions>");
                for (int i = 0; i < childCount; i++) {
                    this.a.append(firstVisiblePosition + i).append(",");
                }
                this.a.append("</Positions>\n");
                this.a.append("    <Tops>");
                for (int i2 = 0; i2 < childCount; i2++) {
                    this.a.append(DragSortListView.this.getChildAt(i2).getTop()).append(",");
                }
                this.a.append("</Tops>\n");
                this.a.append("    <Bottoms>");
                for (int i3 = 0; i3 < childCount; i3++) {
                    this.a.append(DragSortListView.this.getChildAt(i3).getBottom()).append(",");
                }
                this.a.append("</Bottoms>\n");
                this.a.append("    <FirstExpPos>").append(DragSortListView.this.j).append("</FirstExpPos>\n");
                this.a.append("    <FirstExpBlankHeight>").append(DragSortListView.this.b(DragSortListView.this.j) - DragSortListView.this.d(DragSortListView.this.j)).append("</FirstExpBlankHeight>\n");
                this.a.append("    <SecondExpPos>").append(DragSortListView.this.k).append("</SecondExpPos>\n");
                this.a.append("    <SecondExpBlankHeight>").append(DragSortListView.this.b(DragSortListView.this.k) - DragSortListView.this.d(DragSortListView.this.k)).append("</SecondExpBlankHeight>\n");
                this.a.append("    <SrcPos>").append(DragSortListView.this.m).append("</SrcPos>\n");
                this.a.append("    <SrcHeight>").append(DragSortListView.this.x + DragSortListView.this.getDividerHeight()).append("</SrcHeight>\n");
                this.a.append("    <ViewHeight>").append(DragSortListView.this.getHeight()).append("</ViewHeight>\n");
                this.a.append("    <LastY>").append(DragSortListView.this.P).append("</LastY>\n");
                this.a.append("    <FloatY>").append(DragSortListView.this.d).append("</FloatY>\n");
                this.a.append("    <ShuffleEdges>");
                for (int i4 = 0; i4 < childCount; i4++) {
                    this.a.append(DragSortListView.this.a(firstVisiblePosition + i4, DragSortListView.this.getChildAt(i4).getTop())).append(",");
                }
                this.a.append("</ShuffleEdges>\n");
                this.a.append("</DSLVState>\n");
                this.d++;
                if (this.d > 1000) {
                    c();
                    this.d = 0;
                }
            }
        }

        public void c() {
            if (this.f) {
                try {
                    FileWriter fileWriter = new FileWriter(this.b, this.e != 0);
                    fileWriter.write(this.a.toString());
                    this.a.delete(0, this.a.length());
                    fileWriter.flush();
                    fileWriter.close();
                    this.e++;
                } catch (IOException e) {
                }
            }
        }

        public void d() {
            if (this.f) {
                this.a.append("</DSLVStates>\n");
                c();
                this.f = false;
            }
        }
    }
}
