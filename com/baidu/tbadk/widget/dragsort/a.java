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
    private d aPB;
    private int aPE;
    private int aPF;
    private float aPG;
    private float aPH;
    private float aPI;
    private float aPJ;
    private int aPM;
    private int aPN;
    private int aPO;
    private MotionEvent aPT;
    private C0082a aPX;
    private e aPZ;
    private View aPc;
    private int aPf;
    private DataSetObserver aPh;
    private int aPk;
    private int aPl;
    private int aPm;
    private int aPo;
    private int aPp;
    private int aPq;
    private int aPr;
    private int aPs;
    private b aPt;
    private g aPu;
    private l aPv;
    private int aPy;
    private int aPz;
    private k aQc;
    private j aQd;
    private f aQe;
    private boolean aQf;
    private com.baidu.tbadk.widget.dragsort.f aQh;
    private com.baidu.tbadk.widget.dragsort.b aQi;
    private int mLastX;
    private int mLastY;
    private ListView mListView;
    private Point aPd = new Point();
    private Point aPe = new Point();
    private boolean aPg = false;
    private float aPi = 1.0f;
    private float aPj = 1.0f;
    private boolean aPn = false;
    private boolean aPw = true;
    private int mDragState = 0;
    private int aPx = 1;
    private int mWidthMeasureSpec = 0;
    private View[] aPA = new View[1];
    private float aPC = 0.33333334f;
    private float aPD = 0.33333334f;
    private float aPK = 0.5f;
    private c aPL = new c() { // from class: com.baidu.tbadk.widget.dragsort.a.1
        @Override // com.baidu.tbadk.widget.dragsort.a.c
        public float b(float f2, long j2) {
            return a.this.aPK * f2;
        }
    };
    private int aPP = 0;
    private boolean aPQ = false;
    private boolean aPR = false;
    private h aPS = null;
    private int aPU = 0;
    private float aPV = 0.25f;
    private float aPW = 0.0f;
    private boolean aPY = false;
    private boolean mBlockLayoutRequests = false;
    private boolean aQa = false;
    private i aQb = new i(3);
    private float aQg = 0.0f;
    private boolean aQj = false;
    private boolean aQk = false;

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
        this.aQh = fVar;
        this.mListView = listView;
    }

    @Override // com.baidu.tbadk.widget.dragsort.e
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            this.aPX = new C0082a(listAdapter);
            listAdapter.registerDataSetObserver(this.aPh);
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
            this.aPX = null;
        }
        this.aQh.setAdapter(this.aPX);
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
            if (i2 > this.aPo) {
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
        int i4 = this.aPy - this.aPx;
        int fE = fE(i2);
        int fC = fC(i2);
        if (this.aPm <= this.aPo) {
            if (i2 == this.aPm && this.aPl != this.aPm) {
                if (i2 == this.aPo) {
                    i3 = (i3 + fC) - this.aPy;
                } else {
                    i3 = ((fC - fE) + i3) - i4;
                }
            } else if (i2 > this.aPm && i2 <= this.aPo) {
                i3 -= i4;
            }
        } else if (i2 > this.aPo && i2 <= this.aPl) {
            i3 += i4;
        } else if (i2 == this.aPm && this.aPl != this.aPm) {
            i3 += fC - fE;
        }
        if (i2 <= this.aPo) {
            return (((this.aPy - dividerHeight) - fE(i2 - 1)) / 2) + i3;
        }
        return (((fE - dividerHeight) - this.aPy) / 2) + i3;
    }

    private boolean Ia() {
        int i2;
        int i3;
        int i4;
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int i5 = this.aPl;
        View childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        if (childAt == null) {
            i5 = firstVisiblePosition + (this.mListView.getChildCount() / 2);
            childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        }
        int top = childAt.getTop();
        int height = childAt.getHeight();
        int P = P(i5, top);
        int dividerHeight = this.mListView.getDividerHeight();
        if (this.aPf >= P) {
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
                    if (this.aPf < i2) {
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
                if (this.aPf >= i2) {
                    break;
                }
                i4 = i2;
            }
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int i9 = this.aPl;
        int i10 = this.aPm;
        float f2 = this.aPW;
        if (this.aPn) {
            int abs = Math.abs(i2 - i4);
            if (this.aPf >= i2) {
                int i11 = i4;
                i4 = i2;
                i2 = i11;
            }
            int i12 = (int) (abs * this.aPV * 0.5f);
            float f3 = i12;
            int i13 = i4 + i12;
            int i14 = i2 - i12;
            if (this.aPf < i13) {
                this.aPl = i3 - 1;
                this.aPm = i3;
                this.aPW = ((i13 - this.aPf) * 0.5f) / f3;
            } else if (this.aPf < i14) {
                this.aPl = i3;
                this.aPm = i3;
            } else {
                this.aPl = i3;
                this.aPm = i3 + 1;
                this.aPW = (1.0f + ((i2 - this.aPf) / f3)) * 0.5f;
            }
        } else {
            this.aPl = i3;
            this.aPm = i3;
        }
        if (this.aPl < headerViewsCount) {
            this.aPl = headerViewsCount;
            this.aPm = headerViewsCount;
            i3 = headerViewsCount;
        } else if (this.aPm >= this.mListView.getCount() - footerViewsCount) {
            i3 = (this.mListView.getCount() - footerViewsCount) - 1;
            this.aPl = i3;
            this.aPm = i3;
        }
        boolean z = (this.aPl == i9 && this.aPm == i10 && this.aPW == f2) ? false : true;
        if (i3 != this.aPk) {
            if (this.aPt != null) {
                this.aPt.drag(this.aPk - headerViewsCount, i3 - headerViewsCount);
            }
            this.aPk = i3;
            return true;
        }
        return z;
    }

    public void removeItem(int i2) {
        this.aQf = false;
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
            this.aPx = Math.max(1, obtainStyledAttributes.getDimensionPixelSize(d.l.DragSort_collapsed_height, 1));
            this.aPY = obtainStyledAttributes.getBoolean(d.l.DragSort_track_drag_sort, false);
            if (this.aPY) {
                this.aPZ = new e();
            }
            this.aPi = obtainStyledAttributes.getFloat(d.l.DragSort_float_alpha, this.aPi);
            this.aPj = this.aPi;
            this.aPw = obtainStyledAttributes.getBoolean(d.l.DragSort_drag_enabled, this.aPw);
            this.aPV = Math.max(0.0f, Math.min(1.0f, 1.0f - obtainStyledAttributes.getFloat(d.l.DragSort_slide_shuffle_speed, 0.75f)));
            this.aPn = this.aPV > 0.0f;
            setDragScrollStart(obtainStyledAttributes.getFloat(d.l.DragSort_drag_scroll_start, this.aPC));
            this.aPK = obtainStyledAttributes.getFloat(d.l.DragSort_max_drag_scroll_speed, this.aPK);
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
                this.aPS = bVar;
                a(bVar);
            }
            obtainStyledAttributes.recycle();
            i2 = i5;
            i3 = i4;
        }
        this.aPB = new d();
        if (i3 > 0) {
            this.aQc = new k(0.5f, i3);
        }
        if (i2 > 0) {
            this.aQe = new f(0.5f, i2);
        }
        this.aPT = MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        this.aPh = new DataSetObserver() { // from class: com.baidu.tbadk.widget.dragsort.a.2
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
        this.aQi = bVar;
        this.mListView.setOnTouchListener(bVar);
    }

    @Override // com.baidu.tbadk.widget.dragsort.e
    public void dispatchDraw(Canvas canvas) {
        float f2;
        this.aQh.dispatchDraw(canvas);
        if (this.mDragState != 0) {
            if (this.aPl != this.aPo) {
                b(this.aPl, canvas);
            }
            if (this.aPm != this.aPl && this.aPm != this.aPo) {
                b(this.aPm, canvas);
            }
        }
        if (this.aPc != null) {
            int width = this.aPc.getWidth();
            int height = this.aPc.getHeight();
            int i2 = this.aPd.x;
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
            int i3 = (int) (f2 * 255.0f * this.aPj);
            canvas.save();
            canvas.translate(this.aPd.x, this.aPd.y);
            canvas.clipRect(0, 0, width, height);
            canvas.saveLayerAlpha(0.0f, 0.0f, width, height, i3, 31);
            this.aPc.draw(canvas);
            canvas.restore();
            canvas.restore();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.e
    public void onDraw(Canvas canvas) {
        this.aQh.onDraw(canvas);
        if (this.aPY) {
            this.aPZ.In();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.e
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.aQa) {
            this.aQa = false;
            return false;
        } else if (!this.aPw) {
            return this.aQh.onTouchEvent(motionEvent);
        } else {
            boolean z2 = this.aPQ;
            this.aPQ = false;
            if (!z2) {
                n(motionEvent);
            }
            if (this.mDragState == 4) {
                onDragTouchEvent(motionEvent);
                return true;
            }
            if (this.mDragState == 0 && this.aQh.onTouchEvent(motionEvent)) {
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
                        this.aPU = 1;
                        return z;
                    }
                    return z;
            }
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.e
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (!this.aPw) {
            return this.aQh.onInterceptTouchEvent(motionEvent);
        }
        if (this.aQi != null) {
            this.aQi.Ip().onTouchEvent(motionEvent);
        }
        n(motionEvent);
        this.aPQ = true;
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        if (action == 0) {
            if (this.mDragState != 0) {
                this.aQa = true;
                return true;
            }
            this.aPR = true;
        }
        if (this.aPc == null) {
            if (this.aQh.onInterceptTouchEvent(motionEvent)) {
                this.aQj = true;
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
                        this.aPU = 1;
                        break;
                    } else {
                        this.aPU = 2;
                        break;
                    }
            }
        } else {
            z = true;
        }
        if (action == 1 || action == 3) {
            this.aPR = false;
        }
        return z;
    }

    @Override // com.baidu.tbadk.widget.dragsort.e
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        this.aQh.onSizeChanged(i2, i3, i4, i5);
        Ig();
    }

    @Override // com.baidu.tbadk.widget.dragsort.e
    public void requestLayout() {
        if (!this.mBlockLayoutRequests) {
            this.aQh.requestLayout();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.e
    public void onMeasure(int i2, int i3) {
        this.aQh.onMeasure(i2, i3);
        if (this.aPc != null) {
            if (this.aPc.isLayoutRequested()) {
                Ii();
            }
            this.aPg = true;
        }
        this.mWidthMeasureSpec = i2;
    }

    @Override // com.baidu.tbadk.widget.dragsort.e
    public void layoutChildren() {
        this.aQh.layoutChildren();
        if (this.aPc != null) {
            if (this.aPc.isLayoutRequested() && !this.aPg) {
                Ii();
            }
            this.aPc.layout(0, 0, this.aPc.getMeasuredWidth(), this.aPc.getMeasuredHeight());
            this.aPg = false;
        }
    }

    public void removeItem(int i2, float f2) {
        if (this.mDragState == 0 || this.mDragState == 4) {
            if (this.mDragState == 0) {
                this.aPo = this.mListView.getHeaderViewsCount() + i2;
                this.aPl = this.aPo;
                this.aPm = this.aPo;
                this.aPk = this.aPo;
                View childAt = this.mListView.getChildAt(this.aPo - this.mListView.getFirstVisiblePosition());
                if (childAt != null) {
                    childAt.setVisibility(4);
                }
            }
            this.mDragState = 1;
            this.aQg = f2;
            if (this.aPR) {
                switch (this.aPU) {
                    case 1:
                        this.aQh.onTouchEvent(this.aPT);
                        break;
                    case 2:
                        this.aQh.onInterceptTouchEvent(this.aPT);
                        break;
                }
            }
            if (this.aQc != null) {
                this.aQc.start();
            } else {
                fD(i2);
            }
        }
    }

    public void cancelDrag() {
        if (this.mDragState == 4) {
            this.aPB.cc(true);
            Ik();
            Ib();
            Ih();
            if (this.aPR) {
                this.mDragState = 3;
            } else {
                this.mDragState = 0;
            }
        }
    }

    private void Ib() {
        this.aPo = -1;
        this.aPl = -1;
        this.aPm = -1;
        this.aPk = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ic() {
        this.mDragState = 2;
        if (this.aPu != null && this.aPk >= 0 && this.aPk < this.mListView.getCount()) {
            int headerViewsCount = this.mListView.getHeaderViewsCount();
            this.aPu.drop(this.aPo - headerViewsCount, this.aPk - headerViewsCount);
        }
        Ik();
        Ie();
        Ib();
        Ih();
        if (this.aPR) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Id() {
        fD(this.aPo - this.mListView.getHeaderViewsCount());
    }

    private void fD(int i2) {
        this.mDragState = 1;
        if (this.aPv != null) {
            this.aPv.remove(i2);
        }
        Ik();
        Ie();
        Ib();
        if (this.aPR) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    private void Ie() {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        if (this.aPo < firstVisiblePosition) {
            View childAt = this.mListView.getChildAt(0);
            this.mListView.setSelectionFromTop(firstVisiblePosition - 1, (childAt != null ? childAt.getTop() : 0) - this.mListView.getPaddingTop());
        }
    }

    public boolean stopDrag(boolean z) {
        this.aQf = false;
        return stopDrag(z, 0.0f);
    }

    public boolean stopDragWithVelocity(boolean z, float f2) {
        this.aQf = true;
        return stopDrag(z, f2);
    }

    public boolean stopDrag(boolean z, float f2) {
        if (this.aPc != null) {
            this.aPB.cc(true);
            if (z) {
                removeItem(this.aPo - this.mListView.getHeaderViewsCount(), f2);
            } else if (this.aQe != null) {
                this.aQe.start();
            } else {
                Ic();
            }
            if (this.aPY) {
                this.aPZ.kF();
                return true;
            }
            return true;
        }
        return false;
    }

    private void If() {
        this.aPU = 0;
        this.aPR = false;
        if (this.mDragState == 3) {
            this.mDragState = 0;
        }
        this.aPj = this.aPi;
        this.aQj = false;
        this.aQb.clear();
    }

    private void n(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        if (action != 0) {
            this.mLastX = this.aPM;
            this.mLastY = this.aPN;
        }
        this.aPM = (int) motionEvent.getX();
        this.aPN = (int) motionEvent.getY();
        if (action == 0) {
            this.mLastX = this.aPM;
            this.mLastY = this.aPN;
        }
        this.aPr = ((int) motionEvent.getRawX()) - this.aPM;
        this.aPs = ((int) motionEvent.getRawY()) - this.aPN;
    }

    public boolean listViewIntercepted() {
        return this.aQj;
    }

    public void setDragScrollStart(float f2) {
        setDragScrollStarts(f2, f2);
    }

    public void setDragScrollStarts(float f2, float f3) {
        if (f3 > 0.5f) {
            this.aPD = 0.5f;
        } else {
            this.aPD = f3;
        }
        if (f2 > 0.5f) {
            this.aPC = 0.5f;
        } else {
            this.aPC = f2;
        }
        if (this.mListView.getHeight() != 0) {
            Ig();
        }
    }

    private void Q(int i2, int i3) {
        this.aPd.x = i2 - this.aPp;
        this.aPd.y = i3 - this.aPq;
        cb(true);
        int min = Math.min(i3, this.aPf + this.aPz);
        int max = Math.max(i3, this.aPf - this.aPz);
        int Im = this.aPB.Im();
        if (min > this.mLastY && min > this.aPF && Im != 1) {
            if (Im != -1) {
                this.aPB.cc(true);
            }
            this.aPB.fF(1);
        } else if (max < this.mLastY && max < this.aPE && Im != 0) {
            if (Im != -1) {
                this.aPB.cc(true);
            }
            this.aPB.fF(0);
        } else if (max >= this.aPE && min <= this.aPF && this.aPB.Il()) {
            this.aPB.cc(true);
        }
    }

    private void Ig() {
        int height;
        int paddingTop = this.mListView.getPaddingTop();
        float height2 = (this.mListView.getHeight() - paddingTop) - this.mListView.getPaddingBottom();
        this.aPH = paddingTop + (this.aPC * height2);
        this.aPG = (height2 * (1.0f - this.aPD)) + paddingTop;
        this.aPE = (int) this.aPH;
        this.aPF = (int) this.aPG;
        this.aPI = this.aPH - paddingTop;
        this.aPJ = (paddingTop + height) - this.aPG;
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
        if (i2 != this.aPo && i2 != this.aPl && i2 != this.aPm) {
            g2 = -2;
        } else {
            g2 = g(i2, view, z);
        }
        if (g2 != layoutParams.height) {
            layoutParams.height = g2;
            view.setLayoutParams(layoutParams);
        }
        if (i2 == this.aPl || i2 == this.aPm) {
            if (i2 < this.aPo) {
                ((com.baidu.tbadk.widget.dragsort.c) view).setGravity(80);
            } else if (i2 > this.aPo) {
                ((com.baidu.tbadk.widget.dragsort.c) view).setGravity(48);
            }
        }
        int visibility = view.getVisibility();
        int i3 = 0;
        if (i2 == this.aPo && this.aPc != null) {
            i3 = 4;
        }
        if (i3 != visibility) {
            view.setVisibility(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int fE(int i2) {
        View view;
        if (i2 == this.aPo) {
            return 0;
        }
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        if (childAt != null) {
            return f(i2, childAt, false);
        }
        int i3 = this.aQb.get(i2);
        if (i3 == -1) {
            ListAdapter adapter = this.mListView.getAdapter();
            int itemViewType = adapter.getItemViewType(i2);
            int viewTypeCount = adapter.getViewTypeCount();
            if (viewTypeCount != this.aPA.length) {
                this.aPA = new View[viewTypeCount];
            }
            if (itemViewType >= 0) {
                if (this.aPA[itemViewType] == null) {
                    view = adapter.getView(i2, null, this.mListView);
                    this.aPA[itemViewType] = view;
                } else {
                    view = adapter.getView(i2, this.aPA[itemViewType], this.mListView);
                }
            } else {
                view = adapter.getView(i2, null, this.mListView);
            }
            int f2 = f(i2, view, true);
            this.aQb.add(i2, f2);
            return f2;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(int i2, View view, boolean z) {
        if (i2 == this.aPo) {
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
        boolean z = this.aPn && this.aPl != this.aPm;
        int i4 = this.aPy - this.aPx;
        int i5 = (int) (this.aPW * i4);
        if (i2 == this.aPo) {
            if (this.aPo == this.aPl) {
                if (z) {
                    return i5 + this.aPx;
                }
                return this.aPy;
            } else if (this.aPo == this.aPm) {
                return this.aPy - i5;
            } else {
                return this.aPx;
            }
        } else if (i2 == this.aPl) {
            if (z) {
                return i3 + i5;
            }
            return i3 + i4;
        } else if (i2 == this.aPm) {
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
        if (i2 != this.aPo) {
            i6 = height - fE;
            i5 = R - fE;
        } else {
            i5 = R;
            i6 = height;
        }
        int i7 = this.aPy;
        if (this.aPo != this.aPl && this.aPo != this.aPm) {
            i7 -= this.aPx;
        }
        if (i2 <= i3) {
            if (i2 > this.aPl) {
                return (i7 - i5) + 0;
            }
        } else if (i2 == i4) {
            if (i2 <= this.aPl) {
                return (i6 - i7) + 0;
            }
            if (i2 == this.aPm) {
                return (height - R) + 0;
            }
            return 0 + i6;
        } else if (i2 <= this.aPl) {
            return 0 - i7;
        } else {
            if (i2 == this.aPm) {
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
        if (this.aPc != null) {
            measureItem(this.aPc);
            this.aPy = this.aPc.getMeasuredHeight();
            this.aPz = this.aPy / 2;
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
        if (!this.aPR || this.aPS == null || (fG = this.aPS.fG(i2)) == null) {
            return false;
        }
        return startDrag(i2, fG, i3, i4, i5);
    }

    public boolean startDrag(int i2, View view, int i3, int i4, int i5) {
        if (this.mDragState == 0 && this.aPR && this.aPc == null && view != null && this.aPw) {
            if (this.mListView.getParent() != null) {
                this.mListView.getParent().requestDisallowInterceptTouchEvent(true);
            }
            int headerViewsCount = this.mListView.getHeaderViewsCount() + i2;
            this.aPl = headerViewsCount;
            this.aPm = headerViewsCount;
            this.aPo = headerViewsCount;
            this.aPk = headerViewsCount;
            this.mDragState = 4;
            this.aPP = 0;
            this.aPP |= i3;
            this.aPc = view;
            Ii();
            this.aPp = i4;
            this.aPq = i5;
            this.aPO = this.aPN;
            this.aPd.x = this.aPM - this.aPp;
            this.aPd.y = this.aPN - this.aPq;
            View childAt = this.mListView.getChildAt(this.aPo - this.mListView.getFirstVisiblePosition());
            if (childAt != null) {
                childAt.setVisibility(4);
            }
            if (this.aPY) {
                this.aPZ.startTracking();
            }
            switch (this.aPU) {
                case 1:
                    this.aQh.onTouchEvent(this.aPT);
                    break;
                case 2:
                    this.aQh.onInterceptTouchEvent(this.aPT);
                    break;
            }
            this.mListView.requestLayout();
            if (this.aQd != null) {
                this.aQd.start();
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
        int i3 = this.aPl;
        int i4 = this.aPm;
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
        if (this.aPS != null) {
            this.aPe.set(this.aPM, this.aPN);
            this.aPS.b(this.aPc, this.aPd, this.aPe);
        }
        int i2 = this.aPd.x;
        int i3 = this.aPd.y;
        int paddingLeft = this.mListView.getPaddingLeft();
        if ((this.aPP & 1) == 0 && i2 > paddingLeft) {
            this.aPd.x = paddingLeft;
        } else if ((this.aPP & 2) == 0 && i2 < paddingLeft) {
            this.aPd.x = paddingLeft;
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int lastVisiblePosition = this.mListView.getLastVisiblePosition();
        int paddingTop = this.mListView.getPaddingTop();
        if (firstVisiblePosition < headerViewsCount) {
            paddingTop = this.mListView.getChildAt((headerViewsCount - firstVisiblePosition) - 1).getBottom();
        }
        if ((this.aPP & 8) == 0 && firstVisiblePosition <= this.aPo) {
            paddingTop = Math.max(this.mListView.getChildAt(this.aPo - firstVisiblePosition).getTop(), paddingTop);
        }
        int height = this.mListView.getHeight() - this.mListView.getPaddingBottom();
        if (lastVisiblePosition >= (this.mListView.getCount() - footerViewsCount) - 1) {
            height = this.mListView.getChildAt(((this.mListView.getCount() - footerViewsCount) - 1) - firstVisiblePosition).getBottom();
        }
        if ((this.aPP & 4) == 0 && lastVisiblePosition >= this.aPo) {
            height = Math.min(this.mListView.getChildAt(this.aPo - firstVisiblePosition).getBottom(), height);
        }
        if (i3 < paddingTop) {
            this.aPd.y = paddingTop;
        } else if (this.aPy + i3 > height) {
            this.aPd.y = height - this.aPy;
        }
        this.aPf = this.aPd.y + this.aPz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ik() {
        if (this.aPc != null) {
            this.aPc.setVisibility(8);
            if (this.aPS != null) {
                this.aPS.T(this.aPc);
            }
            this.aPc = null;
            this.mListView.invalidate();
        }
    }

    public void a(h hVar) {
        this.aPS = hVar;
    }

    public void a(b bVar) {
        this.aPt = bVar;
    }

    public void setDragEnabled(boolean z) {
        this.aPw = z;
    }

    public boolean isDragEnabled() {
        return this.aPw;
    }

    public void a(g gVar) {
        this.aPu = gVar;
    }

    public void a(l lVar) {
        this.aPv = lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class i {
        private SparseIntArray aQD;
        private ArrayList<Integer> aQE;
        private int mMaxSize;

        public i(int i) {
            this.aQD = new SparseIntArray(i);
            this.aQE = new ArrayList<>(i);
            this.mMaxSize = i;
        }

        public void add(int i, int i2) {
            int i3 = this.aQD.get(i, -1);
            if (i3 != i2) {
                if (i3 == -1) {
                    if (this.aQD.size() == this.mMaxSize) {
                        this.aQD.delete(this.aQE.remove(0).intValue());
                    }
                } else {
                    this.aQE.remove(Integer.valueOf(i));
                }
                this.aQD.put(i, i2);
                this.aQE.add(Integer.valueOf(i));
            }
        }

        public int get(int i) {
            return this.aQD.get(i, -1);
        }

        public void clear() {
            this.aQD.clear();
            this.aQE.clear();
        }
    }

    /* renamed from: com.baidu.tbadk.widget.dragsort.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0082a extends BaseAdapter {
        private ListAdapter mAdapter;

        public C0082a(ListAdapter listAdapter) {
            this.mAdapter = listAdapter;
            this.mAdapter.registerDataSetObserver(new DataSetObserver() { // from class: com.baidu.tbadk.widget.dragsort.a.a.1
                @Override // android.database.DataSetObserver
                public void onChanged() {
                    C0082a.this.notifyDataSetChanged();
                }

                @Override // android.database.DataSetObserver
                public void onInvalidated() {
                    C0082a.this.notifyDataSetInvalidated();
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
        private float aQO;
        private float aQP;
        private float aQQ;
        private float aQR;
        private float aQS;
        private float mAlpha;
        private boolean mCanceled;
        protected long mStartTime;

        public m(float f, int i) {
            this.mAlpha = f;
            this.aQO = i;
            float f2 = 1.0f / ((this.mAlpha * 2.0f) * (1.0f - this.mAlpha));
            this.aQS = f2;
            this.aQP = f2;
            this.aQQ = this.mAlpha / ((this.mAlpha - 1.0f) * 2.0f);
            this.aQR = 1.0f / (1.0f - this.mAlpha);
        }

        public float F(float f) {
            if (f < this.mAlpha) {
                return this.aQP * f * f;
            }
            if (f < 1.0f - this.mAlpha) {
                return this.aQQ + (this.aQR * f);
            }
            return 1.0f - ((this.aQS * (f - 1.0f)) * (f - 1.0f));
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
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / this.aQO;
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
        private int aQA;
        private float aQB;
        private float aQC;
        private int aQz;

        public f(float f, int i) {
            super(f, i);
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.aQz = a.this.aPk;
            this.aQA = a.this.aPo;
            a.this.mDragState = 2;
            this.aQB = a.this.aPd.y - Io();
            this.aQC = a.this.aPd.x - a.this.mListView.getPaddingLeft();
        }

        private int Io() {
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            int dividerHeight = (a.this.aPx + a.this.mListView.getDividerHeight()) / 2;
            View childAt = a.this.mListView.getChildAt(this.aQz - firstVisiblePosition);
            if (childAt != null) {
                if (this.aQz == this.aQA) {
                    return childAt.getTop();
                }
                if (this.aQz >= this.aQA) {
                    return (childAt.getBottom() + dividerHeight) - a.this.aPy;
                }
                return childAt.getTop() - dividerHeight;
            }
            cancel();
            return -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void f(float f, float f2) {
            int Io = Io();
            float paddingLeft = a.this.aPd.x - a.this.mListView.getPaddingLeft();
            float f3 = 1.0f - f2;
            if (f3 < Math.abs((a.this.aPd.y - Io) / this.aQB) || f3 < Math.abs(paddingLeft / this.aQC)) {
                a.this.aPd.y = Io + ((int) (this.aQB * f3));
                a.this.aPd.x = a.this.mListView.getPaddingLeft() + ((int) (this.aQC * f3));
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
        private int aQA;
        private float aQH;
        private float aQI;
        private float aQJ;
        private int aQK;
        private int aQL;
        private int aQM;
        private int aQN;

        public k(float f, int i) {
            super(f, i);
            this.aQK = -1;
            this.aQL = -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.aQK = -1;
            this.aQL = -1;
            this.aQM = a.this.aPl;
            this.aQN = a.this.aPm;
            this.aQA = a.this.aPo;
            a.this.mDragState = 1;
            this.aQH = a.this.aPd.x;
            if (a.this.aQf) {
                float width = a.this.mListView.getWidth() * 2.0f;
                if (a.this.aQg == 0.0f) {
                    a.this.aQg = (this.aQH >= 0.0f ? 1 : -1) * width;
                    return;
                }
                float f = width * 2.0f;
                if (a.this.aQg >= 0.0f || a.this.aQg <= (-f)) {
                    if (a.this.aQg > 0.0f && a.this.aQg < f) {
                        a.this.aQg = f;
                        return;
                    }
                    return;
                }
                a.this.aQg = -f;
                return;
            }
            a.this.Ik();
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void f(float f, float f2) {
            View childAt;
            float f3 = 1.0f - f2;
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            View childAt2 = a.this.mListView.getChildAt(this.aQM - firstVisiblePosition);
            if (a.this.aQf) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / 1000.0f;
                if (uptimeMillis != 0.0f) {
                    float f4 = a.this.aQg * uptimeMillis;
                    int width = a.this.mListView.getWidth();
                    a.this.aQg = ((a.this.aQg > 0.0f ? 1 : -1) * uptimeMillis * width) + a.this.aQg;
                    this.aQH += f4;
                    a.this.aPd.x = (int) this.aQH;
                    if (this.aQH < width && this.aQH > (-width)) {
                        this.mStartTime = SystemClock.uptimeMillis();
                        a.this.cb(true);
                        return;
                    }
                } else {
                    return;
                }
            }
            if (childAt2 != null) {
                if (this.aQK == -1) {
                    this.aQK = a.this.f(this.aQM, childAt2, false);
                    this.aQI = childAt2.getHeight() - this.aQK;
                }
                int max = Math.max((int) (this.aQI * f3), 1);
                ViewGroup.LayoutParams layoutParams = childAt2.getLayoutParams();
                layoutParams.height = max + this.aQK;
                childAt2.setLayoutParams(layoutParams);
            }
            if (this.aQN != this.aQM && (childAt = a.this.mListView.getChildAt(this.aQN - firstVisiblePosition)) != null) {
                if (this.aQL == -1) {
                    this.aQL = a.this.f(this.aQN, childAt, false);
                    this.aQJ = childAt.getHeight() - this.aQL;
                }
                int max2 = Math.max((int) (this.aQJ * f3), 1);
                ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
                layoutParams2.height = max2 + this.aQL;
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
        private float aQF;
        private float aQG;
        final /* synthetic */ a aQl;

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.aQF = this.aQl.aPq;
            this.aQG = this.aQl.aPz;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void f(float f, float f2) {
            if (this.aQl.mDragState != 4) {
                cancel();
                return;
            }
            this.aQl.aPq = (int) ((this.aQG * f2) + ((1.0f - f2) * this.aQF));
            this.aQl.aPd.y = this.aQl.aPN - this.aQl.aPq;
            this.aQl.cb(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e {
        StringBuilder mBuilder = new StringBuilder();
        private int aQw = 0;
        private int aQx = 0;
        private boolean aQy = false;
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
            this.aQx = 0;
            this.aQy = true;
        }

        public void In() {
            if (this.aQy) {
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
                this.mBuilder.append("    <FirstExpPos>").append(a.this.aPl).append("</FirstExpPos>\n");
                this.mBuilder.append("    <FirstExpBlankHeight>").append(a.this.fC(a.this.aPl) - a.this.fE(a.this.aPl)).append("</FirstExpBlankHeight>\n");
                this.mBuilder.append("    <SecondExpPos>").append(a.this.aPm).append("</SecondExpPos>\n");
                this.mBuilder.append("    <SecondExpBlankHeight>").append(a.this.fC(a.this.aPm) - a.this.fE(a.this.aPm)).append("</SecondExpBlankHeight>\n");
                this.mBuilder.append("    <SrcPos>").append(a.this.aPo).append("</SrcPos>\n");
                this.mBuilder.append("    <SrcHeight>").append(a.this.aPy + a.this.mListView.getDividerHeight()).append("</SrcHeight>\n");
                this.mBuilder.append("    <ViewHeight>").append(a.this.mListView.getHeight()).append("</ViewHeight>\n");
                this.mBuilder.append("    <LastY>").append(a.this.mLastY).append("</LastY>\n");
                this.mBuilder.append("    <FloatY>").append(a.this.aPf).append("</FloatY>\n");
                this.mBuilder.append("    <ShuffleEdges>");
                for (int i4 = 0; i4 < childCount; i4++) {
                    this.mBuilder.append(a.this.P(firstVisiblePosition + i4, a.this.mListView.getChildAt(i4).getTop())).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                this.mBuilder.append("</ShuffleEdges>\n");
                this.mBuilder.append("</DSLVState>\n");
                this.aQw++;
                if (this.aQw > 1000) {
                    flush();
                    this.aQw = 0;
                }
            }
        }

        public void flush() {
            if (this.aQy) {
                try {
                    FileWriter fileWriter = new FileWriter(this.mFile, this.aQx != 0);
                    fileWriter.write(this.mBuilder.toString());
                    this.mBuilder.delete(0, this.mBuilder.length());
                    fileWriter.flush();
                    fileWriter.close();
                    this.aQx++;
                } catch (IOException e) {
                }
            }
        }

        public void kF() {
            if (this.aQy) {
                this.mBuilder.append("</DSLVStates>\n");
                flush();
                this.aQy = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements Runnable {
        private boolean aQo;
        private long aQp;
        private long aQq;
        private float aQr;
        private long aQs;
        private int aQt;
        private float aQu;
        private boolean aQv = false;
        private int dy;

        public boolean Il() {
            return this.aQv;
        }

        public int Im() {
            if (this.aQv) {
                return this.aQt;
            }
            return -1;
        }

        public d() {
        }

        public void fF(int i) {
            if (!this.aQv) {
                this.aQo = false;
                this.aQv = true;
                this.aQs = SystemClock.uptimeMillis();
                this.aQp = this.aQs;
                this.aQt = i;
                a.this.mListView.post(this);
            }
        }

        public void cc(boolean z) {
            if (z) {
                a.this.mListView.removeCallbacks(this);
                this.aQv = false;
                return;
            }
            this.aQo = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.aQo) {
                int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
                int lastVisiblePosition = a.this.mListView.getLastVisiblePosition();
                int count = a.this.mListView.getCount();
                int paddingTop = a.this.mListView.getPaddingTop();
                int height = (a.this.mListView.getHeight() - paddingTop) - a.this.mListView.getPaddingBottom();
                int min = Math.min(a.this.aPN, a.this.aPf + a.this.aPz);
                int max = Math.max(a.this.aPN, a.this.aPf - a.this.aPz);
                if (this.aQt == 0) {
                    View childAt = a.this.mListView.getChildAt(0);
                    if (childAt == null) {
                        this.aQv = false;
                        return;
                    } else if (firstVisiblePosition == 0 && childAt.getTop() == paddingTop) {
                        this.aQv = false;
                        return;
                    } else {
                        this.aQu = a.this.aPL.b((a.this.aPH - max) / a.this.aPI, this.aQp);
                    }
                } else {
                    View childAt2 = a.this.mListView.getChildAt(lastVisiblePosition - firstVisiblePosition);
                    if (childAt2 == null) {
                        this.aQv = false;
                        return;
                    } else if (lastVisiblePosition == count - 1 && childAt2.getBottom() <= height + paddingTop) {
                        this.aQv = false;
                        return;
                    } else {
                        this.aQu = -a.this.aPL.b((min - a.this.aPG) / a.this.aPJ, this.aQp);
                    }
                }
                this.aQq = SystemClock.uptimeMillis();
                this.aQr = (float) (this.aQq - this.aQp);
                this.dy = Math.round(this.aQu * this.aQr);
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
                this.aQp = this.aQq;
                a.this.mListView.post(this);
                return;
            }
            this.aQv = false;
        }
    }
}
