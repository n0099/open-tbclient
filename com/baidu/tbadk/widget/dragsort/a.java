package com.baidu.tbadk.widget.dragsort;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.os.SystemClock;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.d;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a implements com.baidu.tbadk.widget.dragsort.e {
    private int aPB;
    private int aPC;
    private d aPE;
    private int aPH;
    private int aPI;
    private float aPJ;
    private float aPK;
    private float aPL;
    private float aPM;
    private int aPP;
    private int aPQ;
    private int aPR;
    private MotionEvent aPW;
    private View aPf;
    private int aPi;
    private DataSetObserver aPk;
    private int aPn;
    private int aPo;
    private int aPp;
    private int aPr;
    private int aPs;
    private int aPt;
    private int aPu;
    private int aPv;
    private b aPw;
    private g aPx;
    private l aPy;
    private C0081a aQa;
    private e aQc;
    private k aQf;
    private j aQg;
    private f aQh;
    private boolean aQi;
    private com.baidu.tbadk.widget.dragsort.f aQk;
    private com.baidu.tbadk.widget.dragsort.b aQl;
    private int mLastX;
    private int mLastY;
    private ListView mListView;
    private Point aPg = new Point();
    private Point aPh = new Point();
    private boolean aPj = false;
    private float aPl = 1.0f;
    private float aPm = 1.0f;
    private boolean aPq = false;
    private boolean aPz = true;
    private int mDragState = 0;
    private int aPA = 1;
    private int mWidthMeasureSpec = 0;
    private View[] aPD = new View[1];
    private float aPF = 0.33333334f;
    private float aPG = 0.33333334f;
    private float aPN = 0.5f;
    private c aPO = new c() { // from class: com.baidu.tbadk.widget.dragsort.a.1
        @Override // com.baidu.tbadk.widget.dragsort.a.c
        public float b(float f2, long j2) {
            return a.this.aPN * f2;
        }
    };
    private int aPS = 0;
    private boolean aPT = false;
    private boolean aPU = false;
    private h aPV = null;
    private int aPX = 0;
    private float aPY = 0.25f;
    private float aPZ = 0.0f;
    private boolean aQb = false;
    private boolean mBlockLayoutRequests = false;
    private boolean aQd = false;
    private i aQe = new i(3);
    private float aQj = 0.0f;
    private boolean aQm = false;
    private boolean aQn = false;

    /* loaded from: classes.dex */
    public interface b {
        void drag(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface c {
        float b(float f, long j);
    }

    /* loaded from: classes.dex */
    public interface g {
        void drop(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface h {
        void T(View view);

        void b(View view, Point point, Point point2);

        View fG(int i);
    }

    /* loaded from: classes.dex */
    public interface l {
        void remove(int i);
    }

    public a(ListView listView, com.baidu.tbadk.widget.dragsort.f fVar) {
        this.aQk = fVar;
        this.mListView = listView;
    }

    @Override // com.baidu.tbadk.widget.dragsort.e
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            this.aQa = new C0081a(listAdapter);
            listAdapter.registerDataSetObserver(this.aPk);
            if (listAdapter instanceof g) {
                a((g) listAdapter);
            }
            if (listAdapter instanceof b) {
                a((b) listAdapter);
            }
            if (listAdapter instanceof l) {
                a((l) listAdapter);
            }
        } else {
            this.aQa = null;
        }
        this.aQk.setAdapter(this.aQa);
    }

    private void b(int i2, Canvas canvas) {
        ViewGroup viewGroup;
        int bottom;
        int i3;
        Drawable divider = this.mListView.getDivider();
        int dividerHeight = this.mListView.getDividerHeight();
        if (divider != null && dividerHeight != 0 && (viewGroup = (ViewGroup) this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition())) != null) {
            int paddingLeft = this.mListView.getPaddingLeft();
            int width = this.mListView.getWidth() - this.mListView.getPaddingRight();
            int height = viewGroup.getChildAt(0).getHeight();
            if (i2 > this.aPr) {
                i3 = height + viewGroup.getTop();
                bottom = i3 + dividerHeight;
            } else {
                bottom = viewGroup.getBottom() - height;
                i3 = bottom - dividerHeight;
            }
            canvas.save();
            canvas.clipRect(paddingLeft, i3, width, bottom);
            divider.setBounds(paddingLeft, i3, width, bottom);
            divider.draw(canvas);
            canvas.restore();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int fC(int i2) {
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        return childAt != null ? childAt.getHeight() : R(i2, fE(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int P(int i2, int i3) {
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        if (i2 <= headerViewsCount || i2 >= this.mListView.getCount() - footerViewsCount) {
            return i3;
        }
        int dividerHeight = this.mListView.getDividerHeight();
        int i4 = this.aPB - this.aPA;
        int fE = fE(i2);
        int fC = fC(i2);
        if (this.aPp <= this.aPr) {
            if (i2 == this.aPp && this.aPo != this.aPp) {
                if (i2 == this.aPr) {
                    i3 = (i3 + fC) - this.aPB;
                } else {
                    i3 = ((fC - fE) + i3) - i4;
                }
            } else if (i2 > this.aPp && i2 <= this.aPr) {
                i3 -= i4;
            }
        } else if (i2 > this.aPr && i2 <= this.aPo) {
            i3 += i4;
        } else if (i2 == this.aPp && this.aPo != this.aPp) {
            i3 += fC - fE;
        }
        if (i2 <= this.aPr) {
            return (((this.aPB - dividerHeight) - fE(i2 - 1)) / 2) + i3;
        }
        return (((fE - dividerHeight) - this.aPB) / 2) + i3;
    }

    private boolean Ia() {
        int i2;
        int i3;
        int i4;
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int i5 = this.aPo;
        View childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        if (childAt == null) {
            i5 = firstVisiblePosition + (this.mListView.getChildCount() / 2);
            childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        }
        int top = childAt.getTop();
        int height = childAt.getHeight();
        int P = P(i5, top);
        int dividerHeight = this.mListView.getDividerHeight();
        if (this.aPi >= P) {
            int count = this.mListView.getCount();
            int i6 = height;
            int i7 = top;
            i2 = P;
            i3 = i5;
            i4 = P;
            while (true) {
                if (i3 < count) {
                    if (i3 == count - 1) {
                        i2 = i7 + dividerHeight + i6;
                        break;
                    }
                    i7 += dividerHeight + i6;
                    i6 = fC(i3 + 1);
                    i2 = P(i3 + 1, i7);
                    if (this.aPi < i2) {
                        break;
                    }
                    i3++;
                    i4 = i2;
                } else {
                    break;
                }
            }
        } else {
            int i8 = top;
            i2 = P;
            i3 = i5;
            i4 = P;
            while (true) {
                if (i3 < 0) {
                    break;
                }
                i3--;
                int fC = fC(i3);
                if (i3 == 0) {
                    i2 = (i8 - dividerHeight) - fC;
                    break;
                }
                i8 -= fC + dividerHeight;
                i2 = P(i3, i8);
                if (this.aPi >= i2) {
                    break;
                }
                i4 = i2;
            }
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int i9 = this.aPo;
        int i10 = this.aPp;
        float f2 = this.aPZ;
        if (this.aPq) {
            int abs = Math.abs(i2 - i4);
            if (this.aPi >= i2) {
                int i11 = i4;
                i4 = i2;
                i2 = i11;
            }
            int i12 = (int) (abs * this.aPY * 0.5f);
            float f3 = i12;
            int i13 = i4 + i12;
            int i14 = i2 - i12;
            if (this.aPi < i13) {
                this.aPo = i3 - 1;
                this.aPp = i3;
                this.aPZ = ((i13 - this.aPi) * 0.5f) / f3;
            } else if (this.aPi < i14) {
                this.aPo = i3;
                this.aPp = i3;
            } else {
                this.aPo = i3;
                this.aPp = i3 + 1;
                this.aPZ = (1.0f + ((i2 - this.aPi) / f3)) * 0.5f;
            }
        } else {
            this.aPo = i3;
            this.aPp = i3;
        }
        if (this.aPo < headerViewsCount) {
            this.aPo = headerViewsCount;
            this.aPp = headerViewsCount;
            i3 = headerViewsCount;
        } else if (this.aPp >= this.mListView.getCount() - footerViewsCount) {
            i3 = (this.mListView.getCount() - footerViewsCount) - 1;
            this.aPo = i3;
            this.aPp = i3;
        }
        boolean z = (this.aPo == i9 && this.aPp == i10 && this.aPZ == f2) ? false : true;
        if (i3 != this.aPn) {
            if (this.aPw != null) {
                this.aPw.drag(this.aPn - headerViewsCount, i3 - headerViewsCount);
            }
            this.aPn = i3;
            return true;
        }
        return z;
    }

    public void removeItem(int i2) {
        this.aQi = false;
        removeItem(i2, 0.0f);
    }

    @Override // com.baidu.tbadk.widget.dragsort.e
    public void a(ListView listView, Context context, AttributeSet attributeSet) {
        int i2;
        int i3 = BaseActivity.SHOW_SOFT_KEYBOARD_DELAY;
        if (attributeSet == null) {
            i2 = 150;
        } else {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.DragSort, 0, 0);
            this.aPA = Math.max(1, obtainStyledAttributes.getDimensionPixelSize(d.l.DragSort_collapsed_height, 1));
            this.aQb = obtainStyledAttributes.getBoolean(d.l.DragSort_track_drag_sort, false);
            if (this.aQb) {
                this.aQc = new e();
            }
            this.aPl = obtainStyledAttributes.getFloat(d.l.DragSort_float_alpha, this.aPl);
            this.aPm = this.aPl;
            this.aPz = obtainStyledAttributes.getBoolean(d.l.DragSort_drag_enabled, this.aPz);
            this.aPY = Math.max(0.0f, Math.min(1.0f, 1.0f - obtainStyledAttributes.getFloat(d.l.DragSort_slide_shuffle_speed, 0.75f)));
            this.aPq = this.aPY > 0.0f;
            setDragScrollStart(obtainStyledAttributes.getFloat(d.l.DragSort_drag_scroll_start, this.aPF));
            this.aPN = obtainStyledAttributes.getFloat(d.l.DragSort_max_drag_scroll_speed, this.aPN);
            int i4 = obtainStyledAttributes.getInt(d.l.DragSort_remove_animation_duration, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
            int i5 = obtainStyledAttributes.getInt(d.l.DragSort_drop_animation_duration, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
            if (obtainStyledAttributes.getBoolean(d.l.DragSort_use_default_controller, true)) {
                boolean z = obtainStyledAttributes.getBoolean(d.l.DragSort_remove_enabled, false);
                int i6 = obtainStyledAttributes.getInt(d.l.DragSort_remove_mode, 1);
                boolean z2 = obtainStyledAttributes.getBoolean(d.l.DragSort_sort_enabled, true);
                int resourceId = obtainStyledAttributes.getResourceId(d.l.DragSort_drag_handle_id, 0);
                int resourceId2 = obtainStyledAttributes.getResourceId(d.l.DragSort_fling_handle_id, 0);
                int resourceId3 = obtainStyledAttributes.getResourceId(d.l.DragSort_click_remove_id, 0);
                int color = obtainStyledAttributes.getColor(d.l.DragSort_float_background_color, ViewCompat.MEASURED_STATE_MASK);
                com.baidu.tbadk.widget.dragsort.b bVar = new com.baidu.tbadk.widget.dragsort.b(this, listView, resourceId, 2, i6, resourceId3, resourceId2);
                bVar.ce(z);
                bVar.cd(z2);
                bVar.setBackgroundColor(color);
                this.aPV = bVar;
                a(bVar);
            }
            obtainStyledAttributes.recycle();
            i2 = i5;
            i3 = i4;
        }
        this.aPE = new d();
        if (i3 > 0) {
            this.aQf = new k(0.5f, i3);
        }
        if (i2 > 0) {
            this.aQh = new f(0.5f, i2);
        }
        this.aPW = MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        this.aPk = new DataSetObserver() { // from class: com.baidu.tbadk.widget.dragsort.a.2
            private void cancel() {
                if (a.this.mDragState == 4) {
                    a.this.cancelDrag();
                }
            }

            @Override // android.database.DataSetObserver
            public void onChanged() {
                cancel();
            }

            @Override // android.database.DataSetObserver
            public void onInvalidated() {
                cancel();
            }
        };
    }

    public void a(com.baidu.tbadk.widget.dragsort.b bVar) {
        this.aQl = bVar;
        this.mListView.setOnTouchListener(bVar);
    }

    @Override // com.baidu.tbadk.widget.dragsort.e
    public void dispatchDraw(Canvas canvas) {
        float f2;
        this.aQk.dispatchDraw(canvas);
        if (this.mDragState != 0) {
            if (this.aPo != this.aPr) {
                b(this.aPo, canvas);
            }
            if (this.aPp != this.aPo && this.aPp != this.aPr) {
                b(this.aPp, canvas);
            }
        }
        if (this.aPf != null) {
            int width = this.aPf.getWidth();
            int height = this.aPf.getHeight();
            int i2 = this.aPg.x;
            int width2 = this.mListView.getWidth();
            if (i2 < 0) {
                i2 = -i2;
            }
            if (i2 < width2) {
                float f3 = (width2 - i2) / width2;
                f2 = f3 * f3;
            } else {
                f2 = 0.0f;
            }
            int i3 = (int) (f2 * 255.0f * this.aPm);
            canvas.save();
            canvas.translate(this.aPg.x, this.aPg.y);
            canvas.clipRect(0, 0, width, height);
            canvas.saveLayerAlpha(0.0f, 0.0f, width, height, i3, 31);
            this.aPf.draw(canvas);
            canvas.restore();
            canvas.restore();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.e
    public void onDraw(Canvas canvas) {
        this.aQk.onDraw(canvas);
        if (this.aQb) {
            this.aQc.In();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.e
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.aQd) {
            this.aQd = false;
            return false;
        } else if (!this.aPz) {
            return this.aQk.onTouchEvent(motionEvent);
        } else {
            boolean z2 = this.aPT;
            this.aPT = false;
            if (!z2) {
                n(motionEvent);
            }
            if (this.mDragState == 4) {
                onDragTouchEvent(motionEvent);
                return true;
            }
            if (this.mDragState == 0 && this.aQk.onTouchEvent(motionEvent)) {
                z = true;
            }
            switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
                case 1:
                case 3:
                    If();
                    return z;
                case 2:
                default:
                    if (z) {
                        this.aPX = 1;
                        return z;
                    }
                    return z;
            }
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.e
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (!this.aPz) {
            return this.aQk.onInterceptTouchEvent(motionEvent);
        }
        if (this.aQl != null) {
            this.aQl.Ip().onTouchEvent(motionEvent);
        }
        n(motionEvent);
        this.aPT = true;
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        if (action == 0) {
            if (this.mDragState != 0) {
                this.aQd = true;
                return true;
            }
            this.aPU = true;
        }
        if (this.aPf == null) {
            if (this.aQk.onInterceptTouchEvent(motionEvent)) {
                this.aQm = true;
                z = true;
            } else {
                z = false;
            }
            switch (action) {
                case 1:
                case 3:
                    If();
                    break;
                case 2:
                default:
                    if (z) {
                        this.aPX = 1;
                        break;
                    } else {
                        this.aPX = 2;
                        break;
                    }
            }
        } else {
            z = true;
        }
        if (action == 1 || action == 3) {
            this.aPU = false;
        }
        return z;
    }

    @Override // com.baidu.tbadk.widget.dragsort.e
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        this.aQk.onSizeChanged(i2, i3, i4, i5);
        Ig();
    }

    @Override // com.baidu.tbadk.widget.dragsort.e
    public void requestLayout() {
        if (!this.mBlockLayoutRequests) {
            this.aQk.requestLayout();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.e
    public void onMeasure(int i2, int i3) {
        this.aQk.onMeasure(i2, i3);
        if (this.aPf != null) {
            if (this.aPf.isLayoutRequested()) {
                Ii();
            }
            this.aPj = true;
        }
        this.mWidthMeasureSpec = i2;
    }

    @Override // com.baidu.tbadk.widget.dragsort.e
    public void layoutChildren() {
        this.aQk.layoutChildren();
        if (this.aPf != null) {
            if (this.aPf.isLayoutRequested() && !this.aPj) {
                Ii();
            }
            this.aPf.layout(0, 0, this.aPf.getMeasuredWidth(), this.aPf.getMeasuredHeight());
            this.aPj = false;
        }
    }

    public void removeItem(int i2, float f2) {
        if (this.mDragState == 0 || this.mDragState == 4) {
            if (this.mDragState == 0) {
                this.aPr = this.mListView.getHeaderViewsCount() + i2;
                this.aPo = this.aPr;
                this.aPp = this.aPr;
                this.aPn = this.aPr;
                View childAt = this.mListView.getChildAt(this.aPr - this.mListView.getFirstVisiblePosition());
                if (childAt != null) {
                    childAt.setVisibility(4);
                }
            }
            this.mDragState = 1;
            this.aQj = f2;
            if (this.aPU) {
                switch (this.aPX) {
                    case 1:
                        this.aQk.onTouchEvent(this.aPW);
                        break;
                    case 2:
                        this.aQk.onInterceptTouchEvent(this.aPW);
                        break;
                }
            }
            if (this.aQf != null) {
                this.aQf.start();
            } else {
                fD(i2);
            }
        }
    }

    public void cancelDrag() {
        if (this.mDragState == 4) {
            this.aPE.cc(true);
            Ik();
            Ib();
            Ih();
            if (this.aPU) {
                this.mDragState = 3;
            } else {
                this.mDragState = 0;
            }
        }
    }

    private void Ib() {
        this.aPr = -1;
        this.aPo = -1;
        this.aPp = -1;
        this.aPn = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ic() {
        this.mDragState = 2;
        if (this.aPx != null && this.aPn >= 0 && this.aPn < this.mListView.getCount()) {
            int headerViewsCount = this.mListView.getHeaderViewsCount();
            this.aPx.drop(this.aPr - headerViewsCount, this.aPn - headerViewsCount);
        }
        Ik();
        Ie();
        Ib();
        Ih();
        if (this.aPU) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Id() {
        fD(this.aPr - this.mListView.getHeaderViewsCount());
    }

    private void fD(int i2) {
        this.mDragState = 1;
        if (this.aPy != null) {
            this.aPy.remove(i2);
        }
        Ik();
        Ie();
        Ib();
        if (this.aPU) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    private void Ie() {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        if (this.aPr < firstVisiblePosition) {
            View childAt = this.mListView.getChildAt(0);
            this.mListView.setSelectionFromTop(firstVisiblePosition - 1, (childAt != null ? childAt.getTop() : 0) - this.mListView.getPaddingTop());
        }
    }

    public boolean stopDrag(boolean z) {
        this.aQi = false;
        return stopDrag(z, 0.0f);
    }

    public boolean stopDragWithVelocity(boolean z, float f2) {
        this.aQi = true;
        return stopDrag(z, f2);
    }

    public boolean stopDrag(boolean z, float f2) {
        if (this.aPf != null) {
            this.aPE.cc(true);
            if (z) {
                removeItem(this.aPr - this.mListView.getHeaderViewsCount(), f2);
            } else if (this.aQh != null) {
                this.aQh.start();
            } else {
                Ic();
            }
            if (this.aQb) {
                this.aQc.kF();
                return true;
            }
            return true;
        }
        return false;
    }

    private void If() {
        this.aPX = 0;
        this.aPU = false;
        if (this.mDragState == 3) {
            this.mDragState = 0;
        }
        this.aPm = this.aPl;
        this.aQm = false;
        this.aQe.clear();
    }

    private void n(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        if (action != 0) {
            this.mLastX = this.aPP;
            this.mLastY = this.aPQ;
        }
        this.aPP = (int) motionEvent.getX();
        this.aPQ = (int) motionEvent.getY();
        if (action == 0) {
            this.mLastX = this.aPP;
            this.mLastY = this.aPQ;
        }
        this.aPu = ((int) motionEvent.getRawX()) - this.aPP;
        this.aPv = ((int) motionEvent.getRawY()) - this.aPQ;
    }

    public boolean listViewIntercepted() {
        return this.aQm;
    }

    public void setDragScrollStart(float f2) {
        setDragScrollStarts(f2, f2);
    }

    public void setDragScrollStarts(float f2, float f3) {
        if (f3 > 0.5f) {
            this.aPG = 0.5f;
        } else {
            this.aPG = f3;
        }
        if (f2 > 0.5f) {
            this.aPF = 0.5f;
        } else {
            this.aPF = f2;
        }
        if (this.mListView.getHeight() != 0) {
            Ig();
        }
    }

    private void Q(int i2, int i3) {
        this.aPg.x = i2 - this.aPs;
        this.aPg.y = i3 - this.aPt;
        cb(true);
        int min = Math.min(i3, this.aPi + this.aPC);
        int max = Math.max(i3, this.aPi - this.aPC);
        int Im = this.aPE.Im();
        if (min > this.mLastY && min > this.aPI && Im != 1) {
            if (Im != -1) {
                this.aPE.cc(true);
            }
            this.aPE.fF(1);
        } else if (max < this.mLastY && max < this.aPH && Im != 0) {
            if (Im != -1) {
                this.aPE.cc(true);
            }
            this.aPE.fF(0);
        } else if (max >= this.aPH && min <= this.aPI && this.aPE.Il()) {
            this.aPE.cc(true);
        }
    }

    private void Ig() {
        int height;
        int paddingTop = this.mListView.getPaddingTop();
        float height2 = (this.mListView.getHeight() - paddingTop) - this.mListView.getPaddingBottom();
        this.aPK = paddingTop + (this.aPF * height2);
        this.aPJ = (height2 * (1.0f - this.aPG)) + paddingTop;
        this.aPH = (int) this.aPK;
        this.aPI = (int) this.aPJ;
        this.aPL = this.aPK - paddingTop;
        this.aPM = (paddingTop + height) - this.aPJ;
    }

    private void Ih() {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int lastVisiblePosition = this.mListView.getLastVisiblePosition();
        int min = Math.min(lastVisiblePosition - firstVisiblePosition, ((this.mListView.getCount() - 1) - this.mListView.getFooterViewsCount()) - firstVisiblePosition);
        for (int max = Math.max(0, this.mListView.getHeaderViewsCount() - firstVisiblePosition); max <= min; max++) {
            View childAt = this.mListView.getChildAt(max);
            if (childAt != null) {
                e(firstVisiblePosition + max, childAt, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i2, View view, boolean z) {
        int g2;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (i2 != this.aPr && i2 != this.aPo && i2 != this.aPp) {
            g2 = -2;
        } else {
            g2 = g(i2, view, z);
        }
        if (g2 != layoutParams.height) {
            layoutParams.height = g2;
            view.setLayoutParams(layoutParams);
        }
        if (i2 == this.aPo || i2 == this.aPp) {
            if (i2 < this.aPr) {
                ((com.baidu.tbadk.widget.dragsort.c) view).setGravity(80);
            } else if (i2 > this.aPr) {
                ((com.baidu.tbadk.widget.dragsort.c) view).setGravity(48);
            }
        }
        int visibility = view.getVisibility();
        int i3 = 0;
        if (i2 == this.aPr && this.aPf != null) {
            i3 = 4;
        }
        if (i3 != visibility) {
            view.setVisibility(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int fE(int i2) {
        View view;
        if (i2 == this.aPr) {
            return 0;
        }
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        if (childAt != null) {
            return f(i2, childAt, false);
        }
        int i3 = this.aQe.get(i2);
        if (i3 == -1) {
            ListAdapter adapter = this.mListView.getAdapter();
            int itemViewType = adapter.getItemViewType(i2);
            int viewTypeCount = adapter.getViewTypeCount();
            if (viewTypeCount != this.aPD.length) {
                this.aPD = new View[viewTypeCount];
            }
            if (itemViewType >= 0) {
                if (this.aPD[itemViewType] == null) {
                    view = adapter.getView(i2, null, this.mListView);
                    this.aPD[itemViewType] = view;
                } else {
                    view = adapter.getView(i2, this.aPD[itemViewType], this.mListView);
                }
            } else {
                view = adapter.getView(i2, null, this.mListView);
            }
            int f2 = f(i2, view, true);
            this.aQe.add(i2, f2);
            return f2;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(int i2, View view, boolean z) {
        if (i2 == this.aPr) {
            return 0;
        }
        if (i2 >= this.mListView.getHeaderViewsCount() && i2 < this.mListView.getCount() - this.mListView.getFooterViewsCount()) {
            view = ((ViewGroup) view).getChildAt(0);
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null && layoutParams.height > 0) {
            return layoutParams.height;
        }
        int height = view.getHeight();
        if (height == 0 || z) {
            measureItem(view);
            return view.getMeasuredHeight();
        }
        return height;
    }

    private int g(int i2, View view, boolean z) {
        return R(i2, f(i2, view, z));
    }

    private int R(int i2, int i3) {
        this.mListView.getDividerHeight();
        boolean z = this.aPq && this.aPo != this.aPp;
        int i4 = this.aPB - this.aPA;
        int i5 = (int) (this.aPZ * i4);
        if (i2 == this.aPr) {
            if (this.aPr == this.aPo) {
                if (z) {
                    return i5 + this.aPA;
                }
                return this.aPB;
            } else if (this.aPr == this.aPp) {
                return this.aPB - i5;
            } else {
                return this.aPA;
            }
        } else if (i2 == this.aPo) {
            if (z) {
                return i3 + i5;
            }
            return i3 + i4;
        } else if (i2 == this.aPp) {
            return (i3 + i4) - i5;
        } else {
            return i3;
        }
    }

    private int b(int i2, View view, int i3, int i4) {
        int i5;
        int i6;
        int fE = fE(i2);
        int height = view.getHeight();
        int R = R(i2, fE);
        if (i2 != this.aPr) {
            i6 = height - fE;
            i5 = R - fE;
        } else {
            i5 = R;
            i6 = height;
        }
        int i7 = this.aPB;
        if (this.aPr != this.aPo && this.aPr != this.aPp) {
            i7 -= this.aPA;
        }
        if (i2 <= i3) {
            if (i2 > this.aPo) {
                return (i7 - i5) + 0;
            }
        } else if (i2 == i4) {
            if (i2 <= this.aPo) {
                return (i6 - i7) + 0;
            }
            if (i2 == this.aPp) {
                return (height - R) + 0;
            }
            return 0 + i6;
        } else if (i2 <= this.aPo) {
            return 0 - i7;
        } else {
            if (i2 == this.aPp) {
                return 0 - i5;
            }
        }
        return 0;
    }

    private void measureItem(View view) {
        int makeMeasureSpec;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new AbsListView.LayoutParams(-1, -2);
            view.setLayoutParams(layoutParams);
        }
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(this.mWidthMeasureSpec, this.mListView.getListPaddingLeft() + this.mListView.getListPaddingRight(), layoutParams.width);
        if (layoutParams.height > 0) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(childMeasureSpec, makeMeasureSpec);
    }

    private void Ii() {
        if (this.aPf != null) {
            measureItem(this.aPf);
            this.aPB = this.aPf.getMeasuredHeight();
            this.aPC = this.aPB / 2;
        }
    }

    protected boolean onDragTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
            case 1:
                if (this.mDragState == 4) {
                    stopDrag(false);
                }
                If();
                return true;
            case 2:
                Q((int) motionEvent.getX(), (int) motionEvent.getY());
                return true;
            case 3:
                if (this.mDragState == 4) {
                    cancelDrag();
                }
                If();
                return true;
            default:
                return true;
        }
    }

    public boolean startDrag(int i2, int i3, int i4, int i5) {
        View fG;
        if (!this.aPU || this.aPV == null || (fG = this.aPV.fG(i2)) == null) {
            return false;
        }
        return startDrag(i2, fG, i3, i4, i5);
    }

    public boolean startDrag(int i2, View view, int i3, int i4, int i5) {
        if (this.mDragState == 0 && this.aPU && this.aPf == null && view != null && this.aPz) {
            if (this.mListView.getParent() != null) {
                this.mListView.getParent().requestDisallowInterceptTouchEvent(true);
            }
            int headerViewsCount = this.mListView.getHeaderViewsCount() + i2;
            this.aPo = headerViewsCount;
            this.aPp = headerViewsCount;
            this.aPr = headerViewsCount;
            this.aPn = headerViewsCount;
            this.mDragState = 4;
            this.aPS = 0;
            this.aPS |= i3;
            this.aPf = view;
            Ii();
            this.aPs = i4;
            this.aPt = i5;
            this.aPR = this.aPQ;
            this.aPg.x = this.aPP - this.aPs;
            this.aPg.y = this.aPQ - this.aPt;
            View childAt = this.mListView.getChildAt(this.aPr - this.mListView.getFirstVisiblePosition());
            if (childAt != null) {
                childAt.setVisibility(4);
            }
            if (this.aQb) {
                this.aQc.startTracking();
            }
            switch (this.aPX) {
                case 1:
                    this.aQk.onTouchEvent(this.aPW);
                    break;
                case 2:
                    this.aQk.onInterceptTouchEvent(this.aPW);
                    break;
            }
            this.mListView.requestLayout();
            if (this.aQg != null) {
                this.aQg.start();
                return true;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cb(boolean z) {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition() + (this.mListView.getChildCount() / 2);
        View childAt = this.mListView.getChildAt(this.mListView.getChildCount() / 2);
        if (childAt != null) {
            h(firstVisiblePosition, childAt, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i2, View view, boolean z) {
        this.mBlockLayoutRequests = true;
        Ij();
        int i3 = this.aPo;
        int i4 = this.aPp;
        boolean Ia = Ia();
        if (Ia) {
            Ih();
            this.mListView.setSelectionFromTop(i2, (b(i2, view, i3, i4) + view.getTop()) - this.mListView.getPaddingTop());
            layoutChildren();
        }
        if (Ia || z) {
            this.mListView.invalidate();
        }
        this.mBlockLayoutRequests = false;
    }

    private void Ij() {
        if (this.aPV != null) {
            this.aPh.set(this.aPP, this.aPQ);
            this.aPV.b(this.aPf, this.aPg, this.aPh);
        }
        int i2 = this.aPg.x;
        int i3 = this.aPg.y;
        int paddingLeft = this.mListView.getPaddingLeft();
        if ((this.aPS & 1) == 0 && i2 > paddingLeft) {
            this.aPg.x = paddingLeft;
        } else if ((this.aPS & 2) == 0 && i2 < paddingLeft) {
            this.aPg.x = paddingLeft;
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int lastVisiblePosition = this.mListView.getLastVisiblePosition();
        int paddingTop = this.mListView.getPaddingTop();
        if (firstVisiblePosition < headerViewsCount) {
            paddingTop = this.mListView.getChildAt((headerViewsCount - firstVisiblePosition) - 1).getBottom();
        }
        if ((this.aPS & 8) == 0 && firstVisiblePosition <= this.aPr) {
            paddingTop = Math.max(this.mListView.getChildAt(this.aPr - firstVisiblePosition).getTop(), paddingTop);
        }
        int height = this.mListView.getHeight() - this.mListView.getPaddingBottom();
        if (lastVisiblePosition >= (this.mListView.getCount() - footerViewsCount) - 1) {
            height = this.mListView.getChildAt(((this.mListView.getCount() - footerViewsCount) - 1) - firstVisiblePosition).getBottom();
        }
        if ((this.aPS & 4) == 0 && lastVisiblePosition >= this.aPr) {
            height = Math.min(this.mListView.getChildAt(this.aPr - firstVisiblePosition).getBottom(), height);
        }
        if (i3 < paddingTop) {
            this.aPg.y = paddingTop;
        } else if (this.aPB + i3 > height) {
            this.aPg.y = height - this.aPB;
        }
        this.aPi = this.aPg.y + this.aPC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ik() {
        if (this.aPf != null) {
            this.aPf.setVisibility(8);
            if (this.aPV != null) {
                this.aPV.T(this.aPf);
            }
            this.aPf = null;
            this.mListView.invalidate();
        }
    }

    public void a(h hVar) {
        this.aPV = hVar;
    }

    public void a(b bVar) {
        this.aPw = bVar;
    }

    public void setDragEnabled(boolean z) {
        this.aPz = z;
    }

    public boolean isDragEnabled() {
        return this.aPz;
    }

    public void a(g gVar) {
        this.aPx = gVar;
    }

    public void a(l lVar) {
        this.aPy = lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class i {
        private SparseIntArray aQG;
        private ArrayList<Integer> aQH;
        private int mMaxSize;

        public i(int i) {
            this.aQG = new SparseIntArray(i);
            this.aQH = new ArrayList<>(i);
            this.mMaxSize = i;
        }

        public void add(int i, int i2) {
            int i3 = this.aQG.get(i, -1);
            if (i3 != i2) {
                if (i3 == -1) {
                    if (this.aQG.size() == this.mMaxSize) {
                        this.aQG.delete(this.aQH.remove(0).intValue());
                    }
                } else {
                    this.aQH.remove(Integer.valueOf(i));
                }
                this.aQG.put(i, i2);
                this.aQH.add(Integer.valueOf(i));
            }
        }

        public int get(int i) {
            return this.aQG.get(i, -1);
        }

        public void clear() {
            this.aQG.clear();
            this.aQH.clear();
        }
    }

    /* renamed from: com.baidu.tbadk.widget.dragsort.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0081a extends BaseAdapter {
        private ListAdapter mAdapter;

        public C0081a(ListAdapter listAdapter) {
            this.mAdapter = listAdapter;
            this.mAdapter.registerDataSetObserver(new DataSetObserver() { // from class: com.baidu.tbadk.widget.dragsort.a.a.1
                @Override // android.database.DataSetObserver
                public void onChanged() {
                    C0081a.this.notifyDataSetChanged();
                }

                @Override // android.database.DataSetObserver
                public void onInvalidated() {
                    C0081a.this.notifyDataSetInvalidated();
                }
            });
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return this.mAdapter.getItemId(i);
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.mAdapter.getItem(i);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.mAdapter.getCount();
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            return this.mAdapter.areAllItemsEnabled();
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean isEnabled(int i) {
            return this.mAdapter.isEnabled(i);
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i) {
            return this.mAdapter.getItemViewType(i);
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return this.mAdapter.getViewTypeCount();
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return this.mAdapter.hasStableIds();
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean isEmpty() {
            return this.mAdapter.isEmpty();
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            com.baidu.tbadk.widget.dragsort.c cVar;
            com.baidu.tbadk.widget.dragsort.c cVar2;
            if (view == null) {
                View view2 = this.mAdapter.getView(i, null, a.this.mListView);
                if (view2 instanceof Checkable) {
                    cVar = new com.baidu.tbadk.widget.dragsort.d(a.this.mListView.getContext());
                } else {
                    cVar = new com.baidu.tbadk.widget.dragsort.c(a.this.mListView.getContext());
                }
                cVar.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
                cVar.addView(view2);
                cVar2 = cVar;
            } else {
                cVar2 = (com.baidu.tbadk.widget.dragsort.c) view;
                View childAt = cVar2.getChildAt(0);
                View view3 = this.mAdapter.getView(i, childAt, a.this.mListView);
                if (view3 != childAt) {
                    if (childAt != null) {
                        cVar2.removeViewAt(0);
                    }
                    cVar2.addView(view3);
                }
            }
            a.this.e(a.this.mListView.getHeaderViewsCount() + i, cVar2, true);
            return cVar2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class m implements Runnable {
        private float aQR;
        private float aQS;
        private float aQT;
        private float aQU;
        private float aQV;
        private float mAlpha;
        private boolean mCanceled;
        protected long mStartTime;

        public m(float f, int i) {
            this.mAlpha = f;
            this.aQR = i;
            float f2 = 1.0f / ((this.mAlpha * 2.0f) * (1.0f - this.mAlpha));
            this.aQV = f2;
            this.aQS = f2;
            this.aQT = this.mAlpha / ((this.mAlpha - 1.0f) * 2.0f);
            this.aQU = 1.0f / (1.0f - this.mAlpha);
        }

        public float F(float f) {
            if (f < this.mAlpha) {
                return this.aQS * f * f;
            }
            if (f < 1.0f - this.mAlpha) {
                return this.aQT + (this.aQU * f);
            }
            return 1.0f - ((this.aQV * (f - 1.0f)) * (f - 1.0f));
        }

        public void start() {
            this.mStartTime = SystemClock.uptimeMillis();
            this.mCanceled = false;
            onStart();
            a.this.mListView.post(this);
        }

        public void cancel() {
            this.mCanceled = true;
        }

        public void onStart() {
        }

        public void f(float f, float f2) {
        }

        public void onStop() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.mCanceled) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / this.aQR;
                if (uptimeMillis >= 1.0f) {
                    f(1.0f, 1.0f);
                    onStop();
                    return;
                }
                f(uptimeMillis, F(uptimeMillis));
                a.this.mListView.post(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class f extends m {
        private int aQC;
        private int aQD;
        private float aQE;
        private float aQF;

        public f(float f, int i) {
            super(f, i);
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.aQC = a.this.aPn;
            this.aQD = a.this.aPr;
            a.this.mDragState = 2;
            this.aQE = a.this.aPg.y - Io();
            this.aQF = a.this.aPg.x - a.this.mListView.getPaddingLeft();
        }

        private int Io() {
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            int dividerHeight = (a.this.aPA + a.this.mListView.getDividerHeight()) / 2;
            View childAt = a.this.mListView.getChildAt(this.aQC - firstVisiblePosition);
            if (childAt != null) {
                if (this.aQC == this.aQD) {
                    return childAt.getTop();
                }
                if (this.aQC >= this.aQD) {
                    return (childAt.getBottom() + dividerHeight) - a.this.aPB;
                }
                return childAt.getTop() - dividerHeight;
            }
            cancel();
            return -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void f(float f, float f2) {
            int Io = Io();
            float paddingLeft = a.this.aPg.x - a.this.mListView.getPaddingLeft();
            float f3 = 1.0f - f2;
            if (f3 < Math.abs((a.this.aPg.y - Io) / this.aQE) || f3 < Math.abs(paddingLeft / this.aQF)) {
                a.this.aPg.y = Io + ((int) (this.aQE * f3));
                a.this.aPg.x = a.this.mListView.getPaddingLeft() + ((int) (this.aQF * f3));
                a.this.cb(true);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.Ic();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class k extends m {
        private int aQD;
        private float aQK;
        private float aQL;
        private float aQM;
        private int aQN;
        private int aQO;
        private int aQP;
        private int aQQ;

        public k(float f, int i) {
            super(f, i);
            this.aQN = -1;
            this.aQO = -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.aQN = -1;
            this.aQO = -1;
            this.aQP = a.this.aPo;
            this.aQQ = a.this.aPp;
            this.aQD = a.this.aPr;
            a.this.mDragState = 1;
            this.aQK = a.this.aPg.x;
            if (a.this.aQi) {
                float width = a.this.mListView.getWidth() * 2.0f;
                if (a.this.aQj == 0.0f) {
                    a.this.aQj = (this.aQK >= 0.0f ? 1 : -1) * width;
                    return;
                }
                float f = width * 2.0f;
                if (a.this.aQj >= 0.0f || a.this.aQj <= (-f)) {
                    if (a.this.aQj > 0.0f && a.this.aQj < f) {
                        a.this.aQj = f;
                        return;
                    }
                    return;
                }
                a.this.aQj = -f;
                return;
            }
            a.this.Ik();
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void f(float f, float f2) {
            View childAt;
            float f3 = 1.0f - f2;
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            View childAt2 = a.this.mListView.getChildAt(this.aQP - firstVisiblePosition);
            if (a.this.aQi) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / 1000.0f;
                if (uptimeMillis != 0.0f) {
                    float f4 = a.this.aQj * uptimeMillis;
                    int width = a.this.mListView.getWidth();
                    a.this.aQj = ((a.this.aQj > 0.0f ? 1 : -1) * uptimeMillis * width) + a.this.aQj;
                    this.aQK += f4;
                    a.this.aPg.x = (int) this.aQK;
                    if (this.aQK < width && this.aQK > (-width)) {
                        this.mStartTime = SystemClock.uptimeMillis();
                        a.this.cb(true);
                        return;
                    }
                } else {
                    return;
                }
            }
            if (childAt2 != null) {
                if (this.aQN == -1) {
                    this.aQN = a.this.f(this.aQP, childAt2, false);
                    this.aQL = childAt2.getHeight() - this.aQN;
                }
                int max = Math.max((int) (this.aQL * f3), 1);
                ViewGroup.LayoutParams layoutParams = childAt2.getLayoutParams();
                layoutParams.height = max + this.aQN;
                childAt2.setLayoutParams(layoutParams);
            }
            if (this.aQQ != this.aQP && (childAt = a.this.mListView.getChildAt(this.aQQ - firstVisiblePosition)) != null) {
                if (this.aQO == -1) {
                    this.aQO = a.this.f(this.aQQ, childAt, false);
                    this.aQM = childAt.getHeight() - this.aQO;
                }
                int max2 = Math.max((int) (this.aQM * f3), 1);
                ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
                layoutParams2.height = max2 + this.aQO;
                childAt.setLayoutParams(layoutParams2);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.Id();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class j extends m {
        private float aQI;
        private float aQJ;
        final /* synthetic */ a aQo;

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.aQI = this.aQo.aPt;
            this.aQJ = this.aQo.aPC;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void f(float f, float f2) {
            if (this.aQo.mDragState != 4) {
                cancel();
                return;
            }
            this.aQo.aPt = (int) ((this.aQJ * f2) + ((1.0f - f2) * this.aQI));
            this.aQo.aPg.y = this.aQo.aPQ - this.aQo.aPt;
            this.aQo.cb(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e {
        StringBuilder mBuilder = new StringBuilder();
        private int aQz = 0;
        private int aQA = 0;
        private boolean aQB = false;
        File mFile = new File(Environment.getExternalStorageDirectory(), "dslv_state.txt");

        public e() {
            if (!this.mFile.exists()) {
                try {
                    this.mFile.createNewFile();
                    Log.d("mobeta", "file created");
                } catch (IOException e) {
                    Log.w("mobeta", "Could not create dslv_state.txt");
                    Log.d("mobeta", e.getMessage());
                }
            }
        }

        public void startTracking() {
            this.mBuilder.append("<DSLVStates>\n");
            this.aQA = 0;
            this.aQB = true;
        }

        public void In() {
            if (this.aQB) {
                this.mBuilder.append("<DSLVState>\n");
                int childCount = a.this.mListView.getChildCount();
                int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
                this.mBuilder.append("    <Positions>");
                for (int i = 0; i < childCount; i++) {
                    this.mBuilder.append(firstVisiblePosition + i).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                this.mBuilder.append("</Positions>\n");
                this.mBuilder.append("    <Tops>");
                for (int i2 = 0; i2 < childCount; i2++) {
                    this.mBuilder.append(a.this.mListView.getChildAt(i2).getTop()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                this.mBuilder.append("</Tops>\n");
                this.mBuilder.append("    <Bottoms>");
                for (int i3 = 0; i3 < childCount; i3++) {
                    this.mBuilder.append(a.this.mListView.getChildAt(i3).getBottom()).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                this.mBuilder.append("</Bottoms>\n");
                this.mBuilder.append("    <FirstExpPos>").append(a.this.aPo).append("</FirstExpPos>\n");
                this.mBuilder.append("    <FirstExpBlankHeight>").append(a.this.fC(a.this.aPo) - a.this.fE(a.this.aPo)).append("</FirstExpBlankHeight>\n");
                this.mBuilder.append("    <SecondExpPos>").append(a.this.aPp).append("</SecondExpPos>\n");
                this.mBuilder.append("    <SecondExpBlankHeight>").append(a.this.fC(a.this.aPp) - a.this.fE(a.this.aPp)).append("</SecondExpBlankHeight>\n");
                this.mBuilder.append("    <SrcPos>").append(a.this.aPr).append("</SrcPos>\n");
                this.mBuilder.append("    <SrcHeight>").append(a.this.aPB + a.this.mListView.getDividerHeight()).append("</SrcHeight>\n");
                this.mBuilder.append("    <ViewHeight>").append(a.this.mListView.getHeight()).append("</ViewHeight>\n");
                this.mBuilder.append("    <LastY>").append(a.this.mLastY).append("</LastY>\n");
                this.mBuilder.append("    <FloatY>").append(a.this.aPi).append("</FloatY>\n");
                this.mBuilder.append("    <ShuffleEdges>");
                for (int i4 = 0; i4 < childCount; i4++) {
                    this.mBuilder.append(a.this.P(firstVisiblePosition + i4, a.this.mListView.getChildAt(i4).getTop())).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                this.mBuilder.append("</ShuffleEdges>\n");
                this.mBuilder.append("</DSLVState>\n");
                this.aQz++;
                if (this.aQz > 1000) {
                    flush();
                    this.aQz = 0;
                }
            }
        }

        public void flush() {
            if (this.aQB) {
                try {
                    FileWriter fileWriter = new FileWriter(this.mFile, this.aQA != 0);
                    fileWriter.write(this.mBuilder.toString());
                    this.mBuilder.delete(0, this.mBuilder.length());
                    fileWriter.flush();
                    fileWriter.close();
                    this.aQA++;
                } catch (IOException e) {
                }
            }
        }

        public void kF() {
            if (this.aQB) {
                this.mBuilder.append("</DSLVStates>\n");
                flush();
                this.aQB = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements Runnable {
        private boolean aQr;
        private long aQs;
        private long aQt;
        private float aQu;
        private long aQv;
        private int aQw;
        private float aQx;
        private boolean aQy = false;
        private int dy;

        public boolean Il() {
            return this.aQy;
        }

        public int Im() {
            if (this.aQy) {
                return this.aQw;
            }
            return -1;
        }

        public d() {
        }

        public void fF(int i) {
            if (!this.aQy) {
                this.aQr = false;
                this.aQy = true;
                this.aQv = SystemClock.uptimeMillis();
                this.aQs = this.aQv;
                this.aQw = i;
                a.this.mListView.post(this);
            }
        }

        public void cc(boolean z) {
            if (z) {
                a.this.mListView.removeCallbacks(this);
                this.aQy = false;
                return;
            }
            this.aQr = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.aQr) {
                int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
                int lastVisiblePosition = a.this.mListView.getLastVisiblePosition();
                int count = a.this.mListView.getCount();
                int paddingTop = a.this.mListView.getPaddingTop();
                int height = (a.this.mListView.getHeight() - paddingTop) - a.this.mListView.getPaddingBottom();
                int min = Math.min(a.this.aPQ, a.this.aPi + a.this.aPC);
                int max = Math.max(a.this.aPQ, a.this.aPi - a.this.aPC);
                if (this.aQw == 0) {
                    View childAt = a.this.mListView.getChildAt(0);
                    if (childAt == null) {
                        this.aQy = false;
                        return;
                    } else if (firstVisiblePosition == 0 && childAt.getTop() == paddingTop) {
                        this.aQy = false;
                        return;
                    } else {
                        this.aQx = a.this.aPO.b((a.this.aPK - max) / a.this.aPL, this.aQs);
                    }
                } else {
                    View childAt2 = a.this.mListView.getChildAt(lastVisiblePosition - firstVisiblePosition);
                    if (childAt2 == null) {
                        this.aQy = false;
                        return;
                    } else if (lastVisiblePosition == count - 1 && childAt2.getBottom() <= height + paddingTop) {
                        this.aQy = false;
                        return;
                    } else {
                        this.aQx = -a.this.aPO.b((min - a.this.aPJ) / a.this.aPM, this.aQs);
                    }
                }
                this.aQt = SystemClock.uptimeMillis();
                this.aQu = (float) (this.aQt - this.aQs);
                this.dy = Math.round(this.aQx * this.aQu);
                if (this.dy >= 0) {
                    this.dy = Math.min(height, this.dy);
                    lastVisiblePosition = firstVisiblePosition;
                } else {
                    this.dy = Math.max(-height, this.dy);
                }
                View childAt3 = a.this.mListView.getChildAt(lastVisiblePosition - firstVisiblePosition);
                int top = childAt3.getTop() + this.dy;
                if (lastVisiblePosition == 0 && top > paddingTop) {
                    top = paddingTop;
                }
                a.this.mBlockLayoutRequests = true;
                a.this.mListView.setSelectionFromTop(lastVisiblePosition, top - paddingTop);
                a.this.layoutChildren();
                a.this.mListView.invalidate();
                a.this.mBlockLayoutRequests = false;
                a.this.h(lastVisiblePosition, childAt3, false);
                this.aQs = this.aQt;
                a.this.mListView.post(this);
                return;
            }
            this.aQy = false;
        }
    }
}
