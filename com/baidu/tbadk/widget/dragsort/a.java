package com.baidu.tbadk.widget.dragsort;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.os.SystemClock;
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
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a implements com.baidu.tbadk.widget.dragsort.c {
    private View aXA;
    private int aXD;
    private int aXH;
    private int aXI;
    private int aXJ;
    private int aXL;
    private int aXM;
    private int aXN;
    private int aXO;
    private b aXP;
    private g aXQ;
    private l aXR;
    private int aXU;
    private int aXV;
    private d aXX;
    private f aYA;
    private boolean aYB;
    private com.baidu.tbadk.widget.dragsort.d aYD;
    private com.baidu.tbadk.widget.dragsort.b aYE;
    private int aYa;
    private int aYb;
    private float aYc;
    private float aYd;
    private float aYe;
    private float aYf;
    private int aYi;
    private int aYj;
    private int aYk;
    private MotionEvent aYp;
    private C0121a aYt;
    private e aYv;
    private k aYy;
    private j aYz;
    private int axS;
    private int mLastX;
    private int mLastY;
    private ListView mListView;
    private DataSetObserver mObserver;
    private Point aXB = new Point();
    private Point aXC = new Point();
    private boolean aXE = false;
    private float aXF = 1.0f;
    private float aXG = 1.0f;
    private boolean aXK = false;
    private boolean aXS = true;
    private int mDragState = 0;
    private int aXT = 1;
    private int mWidthMeasureSpec = 0;
    private View[] aXW = new View[1];
    private float aXY = 0.33333334f;
    private float aXZ = 0.33333334f;
    private float aYg = 0.5f;
    private c aYh = new c() { // from class: com.baidu.tbadk.widget.dragsort.a.1
        @Override // com.baidu.tbadk.widget.dragsort.a.c
        public float b(float f2, long j2) {
            return a.this.aYg * f2;
        }
    };
    private int aYl = 0;
    private boolean aYm = false;
    private boolean aYn = false;
    private h aYo = null;
    private int aYq = 0;
    private float aYr = 0.25f;
    private float aYs = 0.0f;
    private boolean aYu = false;
    private boolean mBlockLayoutRequests = false;
    private boolean aYw = false;
    private i aYx = new i(3);
    private float aYC = 0.0f;
    private boolean aYF = false;
    private boolean aYG = false;

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
        void S(View view);

        void b(View view, Point point, Point point2);

        View fA(int i);
    }

    /* loaded from: classes.dex */
    public interface l {
        void remove(int i);
    }

    public a(ListView listView, com.baidu.tbadk.widget.dragsort.d dVar) {
        this.aYD = dVar;
        this.mListView = listView;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            this.aYt = new C0121a(listAdapter);
            listAdapter.registerDataSetObserver(this.mObserver);
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
            this.aYt = null;
        }
        this.aYD.setAdapter(this.aYt);
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
            if (i2 > this.aXL) {
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
    public int fw(int i2) {
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        return childAt != null ? childAt.getHeight() : N(i2, fy(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int L(int i2, int i3) {
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        if (i2 <= headerViewsCount || i2 >= this.mListView.getCount() - footerViewsCount) {
            return i3;
        }
        int dividerHeight = this.mListView.getDividerHeight();
        int i4 = this.aXU - this.aXT;
        int fy = fy(i2);
        int fw = fw(i2);
        if (this.aXJ <= this.aXL) {
            if (i2 == this.aXJ && this.aXI != this.aXJ) {
                if (i2 == this.aXL) {
                    i3 = (i3 + fw) - this.aXU;
                } else {
                    i3 = ((fw - fy) + i3) - i4;
                }
            } else if (i2 > this.aXJ && i2 <= this.aXL) {
                i3 -= i4;
            }
        } else if (i2 > this.aXL && i2 <= this.aXI) {
            i3 += i4;
        } else if (i2 == this.aXJ && this.aXI != this.aXJ) {
            i3 += fw - fy;
        }
        if (i2 <= this.aXL) {
            return (((this.aXU - dividerHeight) - fy(i2 - 1)) / 2) + i3;
        }
        return (((fy - dividerHeight) - this.aXU) / 2) + i3;
    }

    private boolean LP() {
        int i2;
        int i3;
        int i4;
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int i5 = this.aXI;
        View childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        if (childAt == null) {
            i5 = firstVisiblePosition + (this.mListView.getChildCount() / 2);
            childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        }
        int top = childAt.getTop();
        int height = childAt.getHeight();
        int L = L(i5, top);
        int dividerHeight = this.mListView.getDividerHeight();
        if (this.aXD >= L) {
            int count = this.mListView.getCount();
            int i6 = height;
            int i7 = top;
            i2 = L;
            i3 = i5;
            i4 = L;
            while (true) {
                if (i3 < count) {
                    if (i3 == count - 1) {
                        i2 = i7 + dividerHeight + i6;
                        break;
                    }
                    i7 += dividerHeight + i6;
                    i6 = fw(i3 + 1);
                    i2 = L(i3 + 1, i7);
                    if (this.aXD < i2) {
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
            i2 = L;
            i3 = i5;
            i4 = L;
            while (true) {
                if (i3 < 0) {
                    break;
                }
                i3--;
                int fw = fw(i3);
                if (i3 == 0) {
                    i2 = (i8 - dividerHeight) - fw;
                    break;
                }
                i8 -= fw + dividerHeight;
                i2 = L(i3, i8);
                if (this.aXD >= i2) {
                    break;
                }
                i4 = i2;
            }
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int i9 = this.aXI;
        int i10 = this.aXJ;
        float f2 = this.aYs;
        if (this.aXK) {
            int abs = Math.abs(i2 - i4);
            if (this.aXD >= i2) {
                int i11 = i4;
                i4 = i2;
                i2 = i11;
            }
            int i12 = (int) (abs * this.aYr * 0.5f);
            float f3 = i12;
            int i13 = i4 + i12;
            int i14 = i2 - i12;
            if (this.aXD < i13) {
                this.aXI = i3 - 1;
                this.aXJ = i3;
                this.aYs = ((i13 - this.aXD) * 0.5f) / f3;
            } else if (this.aXD < i14) {
                this.aXI = i3;
                this.aXJ = i3;
            } else {
                this.aXI = i3;
                this.aXJ = i3 + 1;
                this.aYs = (1.0f + ((i2 - this.aXD) / f3)) * 0.5f;
            }
        } else {
            this.aXI = i3;
            this.aXJ = i3;
        }
        if (this.aXI < headerViewsCount) {
            this.aXI = headerViewsCount;
            this.aXJ = headerViewsCount;
            i3 = headerViewsCount;
        } else if (this.aXJ >= this.mListView.getCount() - footerViewsCount) {
            i3 = (this.mListView.getCount() - footerViewsCount) - 1;
            this.aXI = i3;
            this.aXJ = i3;
        }
        boolean z = (this.aXI == i9 && this.aXJ == i10 && this.aYs == f2) ? false : true;
        if (i3 != this.aXH) {
            if (this.aXP != null) {
                this.aXP.drag(this.aXH - headerViewsCount, i3 - headerViewsCount);
            }
            this.aXH = i3;
            return true;
        }
        return z;
    }

    public void removeItem(int i2) {
        this.aYB = false;
        removeItem(i2, 0.0f);
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void a(ListView listView, Context context, AttributeSet attributeSet) {
        int i2;
        int i3 = BaseActivity.SHOW_SOFT_KEYBOARD_DELAY;
        if (attributeSet == null) {
            i2 = 150;
        } else {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.m.DragSort, 0, 0);
            this.aXT = Math.max(1, obtainStyledAttributes.getDimensionPixelSize(d.m.DragSort_collapsed_height, 1));
            this.aYu = obtainStyledAttributes.getBoolean(d.m.DragSort_track_drag_sort, false);
            if (this.aYu) {
                this.aYv = new e();
            }
            this.aXF = obtainStyledAttributes.getFloat(d.m.DragSort_float_alpha, this.aXF);
            this.aXG = this.aXF;
            this.aXS = obtainStyledAttributes.getBoolean(d.m.DragSort_drag_enabled, this.aXS);
            this.aYr = Math.max(0.0f, Math.min(1.0f, 1.0f - obtainStyledAttributes.getFloat(d.m.DragSort_slide_shuffle_speed, 0.75f)));
            this.aXK = this.aYr > 0.0f;
            setDragScrollStart(obtainStyledAttributes.getFloat(d.m.DragSort_drag_scroll_start, this.aXY));
            this.aYg = obtainStyledAttributes.getFloat(d.m.DragSort_max_drag_scroll_speed, this.aYg);
            int i4 = obtainStyledAttributes.getInt(d.m.DragSort_remove_animation_duration, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
            int i5 = obtainStyledAttributes.getInt(d.m.DragSort_drop_animation_duration, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
            if (obtainStyledAttributes.getBoolean(d.m.DragSort_use_default_controller, true)) {
                boolean z = obtainStyledAttributes.getBoolean(d.m.DragSort_remove_enabled, false);
                int i6 = obtainStyledAttributes.getInt(d.m.DragSort_remove_mode, 1);
                boolean z2 = obtainStyledAttributes.getBoolean(d.m.DragSort_sort_enabled, true);
                int resourceId = obtainStyledAttributes.getResourceId(d.m.DragSort_drag_handle_id, 0);
                int resourceId2 = obtainStyledAttributes.getResourceId(d.m.DragSort_fling_handle_id, 0);
                int resourceId3 = obtainStyledAttributes.getResourceId(d.m.DragSort_click_remove_id, 0);
                int color = obtainStyledAttributes.getColor(d.m.DragSort_float_background_color, ViewCompat.MEASURED_STATE_MASK);
                com.baidu.tbadk.widget.dragsort.b bVar = new com.baidu.tbadk.widget.dragsort.b(this, listView, resourceId, 2, i6, resourceId3, resourceId2);
                bVar.ch(z);
                bVar.cg(z2);
                bVar.setBackgroundColor(color);
                this.aYo = bVar;
                a(bVar);
            }
            obtainStyledAttributes.recycle();
            i2 = i5;
            i3 = i4;
        }
        this.aXX = new d();
        if (i3 > 0) {
            this.aYy = new k(0.5f, i3);
        }
        if (i2 > 0) {
            this.aYA = new f(0.5f, i2);
        }
        this.aYp = MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        this.mObserver = new DataSetObserver() { // from class: com.baidu.tbadk.widget.dragsort.a.2
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
        this.aYE = bVar;
        this.mListView.setOnTouchListener(bVar);
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void dispatchDraw(Canvas canvas) {
        float f2;
        this.aYD.dispatchDraw(canvas);
        if (this.mDragState != 0) {
            if (this.aXI != this.aXL) {
                b(this.aXI, canvas);
            }
            if (this.aXJ != this.aXI && this.aXJ != this.aXL) {
                b(this.aXJ, canvas);
            }
        }
        if (this.aXA != null) {
            int width = this.aXA.getWidth();
            int height = this.aXA.getHeight();
            int i2 = this.aXB.x;
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
            int i3 = (int) (f2 * 255.0f * this.aXG);
            canvas.save();
            canvas.translate(this.aXB.x, this.aXB.y);
            canvas.clipRect(0, 0, width, height);
            canvas.saveLayerAlpha(0.0f, 0.0f, width, height, i3, 31);
            this.aXA.draw(canvas);
            canvas.restore();
            canvas.restore();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onDraw(Canvas canvas) {
        this.aYD.onDraw(canvas);
        if (this.aYu) {
            this.aYv.Mc();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.aYw) {
            this.aYw = false;
            return false;
        } else if (!this.aXS) {
            return this.aYD.onTouchEvent(motionEvent);
        } else {
            boolean z2 = this.aYm;
            this.aYm = false;
            if (!z2) {
                t(motionEvent);
            }
            if (this.mDragState == 4) {
                onDragTouchEvent(motionEvent);
                return true;
            }
            if (this.mDragState == 0 && this.aYD.onTouchEvent(motionEvent)) {
                z = true;
            }
            switch (motionEvent.getAction() & 255) {
                case 1:
                case 3:
                    LU();
                    return z;
                case 2:
                default:
                    if (z) {
                        this.aYq = 1;
                        return z;
                    }
                    return z;
            }
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (!this.aXS) {
            return this.aYD.onInterceptTouchEvent(motionEvent);
        }
        if (this.aYE != null) {
            this.aYE.Me().onTouchEvent(motionEvent);
        }
        t(motionEvent);
        this.aYm = true;
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            if (this.mDragState != 0) {
                this.aYw = true;
                return true;
            }
            this.aYn = true;
        }
        if (this.aXA == null) {
            if (this.aYD.onInterceptTouchEvent(motionEvent)) {
                this.aYF = true;
                z = true;
            } else {
                z = false;
            }
            switch (action) {
                case 1:
                case 3:
                    LU();
                    break;
                case 2:
                default:
                    if (z) {
                        this.aYq = 1;
                        break;
                    } else {
                        this.aYq = 2;
                        break;
                    }
            }
        } else {
            z = true;
        }
        if (action == 1 || action == 3) {
            this.aYn = false;
        }
        return z;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        this.aYD.onSizeChanged(i2, i3, i4, i5);
        LV();
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void requestLayout() {
        if (!this.mBlockLayoutRequests) {
            this.aYD.requestLayout();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onMeasure(int i2, int i3) {
        this.aYD.onMeasure(i2, i3);
        if (this.aXA != null) {
            if (this.aXA.isLayoutRequested()) {
                LX();
            }
            this.aXE = true;
        }
        this.mWidthMeasureSpec = i2;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void layoutChildren() {
        this.aYD.layoutChildren();
        if (this.aXA != null) {
            if (this.aXA.isLayoutRequested() && !this.aXE) {
                LX();
            }
            this.aXA.layout(0, 0, this.aXA.getMeasuredWidth(), this.aXA.getMeasuredHeight());
            this.aXE = false;
        }
    }

    public void removeItem(int i2, float f2) {
        if (this.mDragState == 0 || this.mDragState == 4) {
            if (this.mDragState == 0) {
                this.aXL = this.mListView.getHeaderViewsCount() + i2;
                this.aXI = this.aXL;
                this.aXJ = this.aXL;
                this.aXH = this.aXL;
                View childAt = this.mListView.getChildAt(this.aXL - this.mListView.getFirstVisiblePosition());
                if (childAt != null) {
                    childAt.setVisibility(4);
                }
            }
            this.mDragState = 1;
            this.aYC = f2;
            if (this.aYn) {
                switch (this.aYq) {
                    case 1:
                        this.aYD.onTouchEvent(this.aYp);
                        break;
                    case 2:
                        this.aYD.onInterceptTouchEvent(this.aYp);
                        break;
                }
            }
            if (this.aYy != null) {
                this.aYy.start();
            } else {
                fx(i2);
            }
        }
    }

    public void cancelDrag() {
        if (this.mDragState == 4) {
            this.aXX.cf(true);
            LZ();
            LQ();
            LW();
            if (this.aYn) {
                this.mDragState = 3;
            } else {
                this.mDragState = 0;
            }
        }
    }

    private void LQ() {
        this.aXL = -1;
        this.aXI = -1;
        this.aXJ = -1;
        this.aXH = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LR() {
        this.mDragState = 2;
        if (this.aXQ != null && this.aXH >= 0 && this.aXH < this.mListView.getCount()) {
            int headerViewsCount = this.mListView.getHeaderViewsCount();
            this.aXQ.drop(this.aXL - headerViewsCount, this.aXH - headerViewsCount);
        }
        LZ();
        LT();
        LQ();
        LW();
        if (this.aYn) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LS() {
        fx(this.aXL - this.mListView.getHeaderViewsCount());
    }

    private void fx(int i2) {
        this.mDragState = 1;
        if (this.aXR != null) {
            this.aXR.remove(i2);
        }
        LZ();
        LT();
        LQ();
        if (this.aYn) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    private void LT() {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        if (this.aXL < firstVisiblePosition) {
            View childAt = this.mListView.getChildAt(0);
            this.mListView.setSelectionFromTop(firstVisiblePosition - 1, (childAt != null ? childAt.getTop() : 0) - this.mListView.getPaddingTop());
        }
    }

    public boolean stopDrag(boolean z) {
        this.aYB = false;
        return stopDrag(z, 0.0f);
    }

    public boolean stopDragWithVelocity(boolean z, float f2) {
        this.aYB = true;
        return stopDrag(z, f2);
    }

    public boolean stopDrag(boolean z, float f2) {
        if (this.aXA != null) {
            this.aXX.cf(true);
            if (z) {
                removeItem(this.aXL - this.mListView.getHeaderViewsCount(), f2);
            } else if (this.aYA != null) {
                this.aYA.start();
            } else {
                LR();
            }
            if (this.aYu) {
                this.aYv.mU();
                return true;
            }
            return true;
        }
        return false;
    }

    private void LU() {
        this.aYq = 0;
        this.aYn = false;
        if (this.mDragState == 3) {
            this.mDragState = 0;
        }
        this.aXG = this.aXF;
        this.aYF = false;
        this.aYx.clear();
    }

    private void t(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            this.mLastX = this.aYi;
            this.mLastY = this.aYj;
        }
        this.aYi = (int) motionEvent.getX();
        this.aYj = (int) motionEvent.getY();
        if (action == 0) {
            this.mLastX = this.aYi;
            this.mLastY = this.aYj;
        }
        this.aXO = ((int) motionEvent.getRawX()) - this.aYi;
        this.axS = ((int) motionEvent.getRawY()) - this.aYj;
    }

    public boolean listViewIntercepted() {
        return this.aYF;
    }

    public void setDragScrollStart(float f2) {
        setDragScrollStarts(f2, f2);
    }

    public void setDragScrollStarts(float f2, float f3) {
        if (f3 > 0.5f) {
            this.aXZ = 0.5f;
        } else {
            this.aXZ = f3;
        }
        if (f2 > 0.5f) {
            this.aXY = 0.5f;
        } else {
            this.aXY = f2;
        }
        if (this.mListView.getHeight() != 0) {
            LV();
        }
    }

    private void M(int i2, int i3) {
        this.aXB.x = i2 - this.aXM;
        this.aXB.y = i3 - this.aXN;
        ce(true);
        int min = Math.min(i3, this.aXD + this.aXV);
        int max = Math.max(i3, this.aXD - this.aXV);
        int Mb = this.aXX.Mb();
        if (min > this.mLastY && min > this.aYb && Mb != 1) {
            if (Mb != -1) {
                this.aXX.cf(true);
            }
            this.aXX.fz(1);
        } else if (max < this.mLastY && max < this.aYa && Mb != 0) {
            if (Mb != -1) {
                this.aXX.cf(true);
            }
            this.aXX.fz(0);
        } else if (max >= this.aYa && min <= this.aYb && this.aXX.Ma()) {
            this.aXX.cf(true);
        }
    }

    private void LV() {
        int height;
        int paddingTop = this.mListView.getPaddingTop();
        float height2 = (this.mListView.getHeight() - paddingTop) - this.mListView.getPaddingBottom();
        this.aYd = paddingTop + (this.aXY * height2);
        this.aYc = (height2 * (1.0f - this.aXZ)) + paddingTop;
        this.aYa = (int) this.aYd;
        this.aYb = (int) this.aYc;
        this.aYe = this.aYd - paddingTop;
        this.aYf = (paddingTop + height) - this.aYc;
    }

    private void LW() {
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
        if (i2 != this.aXL && i2 != this.aXI && i2 != this.aXJ) {
            g2 = -2;
        } else {
            g2 = g(i2, view, z);
        }
        if (g2 != layoutParams.height) {
            layoutParams.height = g2;
            view.setLayoutParams(layoutParams);
        }
        if (i2 == this.aXI || i2 == this.aXJ) {
            if (i2 < this.aXL) {
                ((DragSortItemView) view).setGravity(80);
            } else if (i2 > this.aXL) {
                ((DragSortItemView) view).setGravity(48);
            }
        }
        int visibility = view.getVisibility();
        int i3 = 0;
        if (i2 == this.aXL && this.aXA != null) {
            i3 = 4;
        }
        if (i3 != visibility) {
            view.setVisibility(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int fy(int i2) {
        View view;
        if (i2 == this.aXL) {
            return 0;
        }
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        if (childAt != null) {
            return f(i2, childAt, false);
        }
        int i3 = this.aYx.get(i2);
        if (i3 == -1) {
            ListAdapter adapter = this.mListView.getAdapter();
            int itemViewType = adapter.getItemViewType(i2);
            int viewTypeCount = adapter.getViewTypeCount();
            if (viewTypeCount != this.aXW.length) {
                this.aXW = new View[viewTypeCount];
            }
            if (itemViewType >= 0) {
                if (this.aXW[itemViewType] == null) {
                    view = adapter.getView(i2, null, this.mListView);
                    this.aXW[itemViewType] = view;
                } else {
                    view = adapter.getView(i2, this.aXW[itemViewType], this.mListView);
                }
            } else {
                view = adapter.getView(i2, null, this.mListView);
            }
            int f2 = f(i2, view, true);
            this.aYx.add(i2, f2);
            return f2;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(int i2, View view, boolean z) {
        if (i2 == this.aXL) {
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
        return N(i2, f(i2, view, z));
    }

    private int N(int i2, int i3) {
        this.mListView.getDividerHeight();
        boolean z = this.aXK && this.aXI != this.aXJ;
        int i4 = this.aXU - this.aXT;
        int i5 = (int) (this.aYs * i4);
        if (i2 == this.aXL) {
            if (this.aXL == this.aXI) {
                if (z) {
                    return i5 + this.aXT;
                }
                return this.aXU;
            } else if (this.aXL == this.aXJ) {
                return this.aXU - i5;
            } else {
                return this.aXT;
            }
        } else if (i2 == this.aXI) {
            if (z) {
                return i3 + i5;
            }
            return i3 + i4;
        } else if (i2 == this.aXJ) {
            return (i3 + i4) - i5;
        } else {
            return i3;
        }
    }

    private int b(int i2, View view, int i3, int i4) {
        int i5;
        int i6;
        int fy = fy(i2);
        int height = view.getHeight();
        int N = N(i2, fy);
        if (i2 != this.aXL) {
            i6 = height - fy;
            i5 = N - fy;
        } else {
            i5 = N;
            i6 = height;
        }
        int i7 = this.aXU;
        if (this.aXL != this.aXI && this.aXL != this.aXJ) {
            i7 -= this.aXT;
        }
        if (i2 <= i3) {
            if (i2 > this.aXI) {
                return (i7 - i5) + 0;
            }
        } else if (i2 == i4) {
            if (i2 <= this.aXI) {
                return (i6 - i7) + 0;
            }
            if (i2 == this.aXJ) {
                return (height - N) + 0;
            }
            return 0 + i6;
        } else if (i2 <= this.aXI) {
            return 0 - i7;
        } else {
            if (i2 == this.aXJ) {
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

    private void LX() {
        if (this.aXA != null) {
            measureItem(this.aXA);
            this.aXU = this.aXA.getMeasuredHeight();
            this.aXV = this.aXU / 2;
        }
    }

    protected boolean onDragTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        switch (motionEvent.getAction() & 255) {
            case 1:
                if (this.mDragState == 4) {
                    stopDrag(false);
                }
                LU();
                return true;
            case 2:
                M((int) motionEvent.getX(), (int) motionEvent.getY());
                return true;
            case 3:
                if (this.mDragState == 4) {
                    cancelDrag();
                }
                LU();
                return true;
            default:
                return true;
        }
    }

    public boolean startDrag(int i2, int i3, int i4, int i5) {
        View fA;
        if (!this.aYn || this.aYo == null || (fA = this.aYo.fA(i2)) == null) {
            return false;
        }
        return startDrag(i2, fA, i3, i4, i5);
    }

    public boolean startDrag(int i2, View view, int i3, int i4, int i5) {
        if (this.mDragState == 0 && this.aYn && this.aXA == null && view != null && this.aXS) {
            if (this.mListView.getParent() != null) {
                this.mListView.getParent().requestDisallowInterceptTouchEvent(true);
            }
            int headerViewsCount = this.mListView.getHeaderViewsCount() + i2;
            this.aXI = headerViewsCount;
            this.aXJ = headerViewsCount;
            this.aXL = headerViewsCount;
            this.aXH = headerViewsCount;
            this.mDragState = 4;
            this.aYl = 0;
            this.aYl |= i3;
            this.aXA = view;
            LX();
            this.aXM = i4;
            this.aXN = i5;
            this.aYk = this.aYj;
            this.aXB.x = this.aYi - this.aXM;
            this.aXB.y = this.aYj - this.aXN;
            View childAt = this.mListView.getChildAt(this.aXL - this.mListView.getFirstVisiblePosition());
            if (childAt != null) {
                childAt.setVisibility(4);
            }
            if (this.aYu) {
                this.aYv.startTracking();
            }
            switch (this.aYq) {
                case 1:
                    this.aYD.onTouchEvent(this.aYp);
                    break;
                case 2:
                    this.aYD.onInterceptTouchEvent(this.aYp);
                    break;
            }
            this.mListView.requestLayout();
            if (this.aYz != null) {
                this.aYz.start();
                return true;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ce(boolean z) {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition() + (this.mListView.getChildCount() / 2);
        View childAt = this.mListView.getChildAt(this.mListView.getChildCount() / 2);
        if (childAt != null) {
            h(firstVisiblePosition, childAt, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i2, View view, boolean z) {
        this.mBlockLayoutRequests = true;
        LY();
        int i3 = this.aXI;
        int i4 = this.aXJ;
        boolean LP = LP();
        if (LP) {
            LW();
            this.mListView.setSelectionFromTop(i2, (b(i2, view, i3, i4) + view.getTop()) - this.mListView.getPaddingTop());
            layoutChildren();
        }
        if (LP || z) {
            this.mListView.invalidate();
        }
        this.mBlockLayoutRequests = false;
    }

    private void LY() {
        if (this.aYo != null) {
            this.aXC.set(this.aYi, this.aYj);
            this.aYo.b(this.aXA, this.aXB, this.aXC);
        }
        int i2 = this.aXB.x;
        int i3 = this.aXB.y;
        int paddingLeft = this.mListView.getPaddingLeft();
        if ((this.aYl & 1) == 0 && i2 > paddingLeft) {
            this.aXB.x = paddingLeft;
        } else if ((this.aYl & 2) == 0 && i2 < paddingLeft) {
            this.aXB.x = paddingLeft;
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int lastVisiblePosition = this.mListView.getLastVisiblePosition();
        int paddingTop = this.mListView.getPaddingTop();
        if (firstVisiblePosition < headerViewsCount) {
            paddingTop = this.mListView.getChildAt((headerViewsCount - firstVisiblePosition) - 1).getBottom();
        }
        if ((this.aYl & 8) == 0 && firstVisiblePosition <= this.aXL) {
            paddingTop = Math.max(this.mListView.getChildAt(this.aXL - firstVisiblePosition).getTop(), paddingTop);
        }
        int height = this.mListView.getHeight() - this.mListView.getPaddingBottom();
        if (lastVisiblePosition >= (this.mListView.getCount() - footerViewsCount) - 1) {
            height = this.mListView.getChildAt(((this.mListView.getCount() - footerViewsCount) - 1) - firstVisiblePosition).getBottom();
        }
        if ((this.aYl & 4) == 0 && lastVisiblePosition >= this.aXL) {
            height = Math.min(this.mListView.getChildAt(this.aXL - firstVisiblePosition).getBottom(), height);
        }
        if (i3 < paddingTop) {
            this.aXB.y = paddingTop;
        } else if (this.aXU + i3 > height) {
            this.aXB.y = height - this.aXU;
        }
        this.aXD = this.aXB.y + this.aXV;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LZ() {
        if (this.aXA != null) {
            this.aXA.setVisibility(8);
            if (this.aYo != null) {
                this.aYo.S(this.aXA);
            }
            this.aXA = null;
            this.mListView.invalidate();
        }
    }

    public void a(h hVar) {
        this.aYo = hVar;
    }

    public void a(b bVar) {
        this.aXP = bVar;
    }

    public void setDragEnabled(boolean z) {
        this.aXS = z;
    }

    public boolean isDragEnabled() {
        return this.aXS;
    }

    public void a(g gVar) {
        this.aXQ = gVar;
    }

    public void a(l lVar) {
        this.aXR = lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class i {
        private SparseIntArray aYZ;
        private ArrayList<Integer> aZa;
        private int mMaxSize;

        public i(int i) {
            this.aYZ = new SparseIntArray(i);
            this.aZa = new ArrayList<>(i);
            this.mMaxSize = i;
        }

        public void add(int i, int i2) {
            int i3 = this.aYZ.get(i, -1);
            if (i3 != i2) {
                if (i3 == -1) {
                    if (this.aYZ.size() == this.mMaxSize) {
                        this.aYZ.delete(this.aZa.remove(0).intValue());
                    }
                } else {
                    this.aZa.remove(Integer.valueOf(i));
                }
                this.aYZ.put(i, i2);
                this.aZa.add(Integer.valueOf(i));
            }
        }

        public int get(int i) {
            return this.aYZ.get(i, -1);
        }

        public void clear() {
            this.aYZ.clear();
            this.aZa.clear();
        }
    }

    /* renamed from: com.baidu.tbadk.widget.dragsort.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0121a extends BaseAdapter {
        private ListAdapter mAdapter;

        public C0121a(ListAdapter listAdapter) {
            this.mAdapter = listAdapter;
            this.mAdapter.registerDataSetObserver(new DataSetObserver() { // from class: com.baidu.tbadk.widget.dragsort.a.a.1
                @Override // android.database.DataSetObserver
                public void onChanged() {
                    C0121a.this.notifyDataSetChanged();
                }

                @Override // android.database.DataSetObserver
                public void onInvalidated() {
                    C0121a.this.notifyDataSetInvalidated();
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
            DragSortItemView dragSortItemView;
            DragSortItemView dragSortItemView2;
            if (view == null) {
                View view2 = this.mAdapter.getView(i, null, a.this.mListView);
                if (view2 instanceof Checkable) {
                    dragSortItemView = new DragSortItemViewCheckable(a.this.mListView.getContext());
                } else {
                    dragSortItemView = new DragSortItemView(a.this.mListView.getContext());
                }
                dragSortItemView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
                dragSortItemView.addView(view2);
                dragSortItemView2 = dragSortItemView;
            } else {
                dragSortItemView2 = (DragSortItemView) view;
                View childAt = dragSortItemView2.getChildAt(0);
                View view3 = this.mAdapter.getView(i, childAt, a.this.mListView);
                if (view3 != childAt) {
                    if (childAt != null) {
                        dragSortItemView2.removeViewAt(0);
                    }
                    dragSortItemView2.addView(view3);
                }
            }
            a.this.e(a.this.mListView.getHeaderViewsCount() + i, dragSortItemView2, true);
            return dragSortItemView2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class m implements Runnable {
        private float aZk;
        private float aZl;
        private float aZm;
        private float aZn;
        private float aZo;
        private float mAlpha;
        private boolean mCanceled;
        protected long mStartTime;

        public m(float f, int i) {
            this.mAlpha = f;
            this.aZk = i;
            float f2 = 1.0f / ((this.mAlpha * 2.0f) * (1.0f - this.mAlpha));
            this.aZo = f2;
            this.aZl = f2;
            this.aZm = this.mAlpha / ((this.mAlpha - 1.0f) * 2.0f);
            this.aZn = 1.0f / (1.0f - this.mAlpha);
        }

        public float Z(float f) {
            if (f < this.mAlpha) {
                return this.aZl * f * f;
            }
            if (f < 1.0f - this.mAlpha) {
                return this.aZm + (this.aZn * f);
            }
            return 1.0f - ((this.aZo * (f - 1.0f)) * (f - 1.0f));
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

        public void n(float f, float f2) {
        }

        public void onStop() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.mCanceled) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / this.aZk;
                if (uptimeMillis >= 1.0f) {
                    n(1.0f, 1.0f);
                    onStop();
                    return;
                }
                n(uptimeMillis, Z(uptimeMillis));
                a.this.mListView.post(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class f extends m {
        private int aYV;
        private int aYW;
        private float aYX;
        private float aYY;

        public f(float f, int i) {
            super(f, i);
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.aYV = a.this.aXH;
            this.aYW = a.this.aXL;
            a.this.mDragState = 2;
            this.aYX = a.this.aXB.y - Md();
            this.aYY = a.this.aXB.x - a.this.mListView.getPaddingLeft();
        }

        private int Md() {
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            int dividerHeight = (a.this.aXT + a.this.mListView.getDividerHeight()) / 2;
            View childAt = a.this.mListView.getChildAt(this.aYV - firstVisiblePosition);
            if (childAt != null) {
                if (this.aYV == this.aYW) {
                    return childAt.getTop();
                }
                if (this.aYV >= this.aYW) {
                    return (childAt.getBottom() + dividerHeight) - a.this.aXU;
                }
                return childAt.getTop() - dividerHeight;
            }
            cancel();
            return -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void n(float f, float f2) {
            int Md = Md();
            float paddingLeft = a.this.aXB.x - a.this.mListView.getPaddingLeft();
            float f3 = 1.0f - f2;
            if (f3 < Math.abs((a.this.aXB.y - Md) / this.aYX) || f3 < Math.abs(paddingLeft / this.aYY)) {
                a.this.aXB.y = Md + ((int) (this.aYX * f3));
                a.this.aXB.x = a.this.mListView.getPaddingLeft() + ((int) (this.aYY * f3));
                a.this.ce(true);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.LR();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class k extends m {
        private int aYW;
        private float aZd;
        private float aZe;
        private float aZf;
        private int aZg;
        private int aZh;
        private int aZi;
        private int aZj;

        public k(float f, int i) {
            super(f, i);
            this.aZg = -1;
            this.aZh = -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.aZg = -1;
            this.aZh = -1;
            this.aZi = a.this.aXI;
            this.aZj = a.this.aXJ;
            this.aYW = a.this.aXL;
            a.this.mDragState = 1;
            this.aZd = a.this.aXB.x;
            if (a.this.aYB) {
                float width = a.this.mListView.getWidth() * 2.0f;
                if (a.this.aYC == 0.0f) {
                    a.this.aYC = (this.aZd >= 0.0f ? 1 : -1) * width;
                    return;
                }
                float f = width * 2.0f;
                if (a.this.aYC >= 0.0f || a.this.aYC <= (-f)) {
                    if (a.this.aYC > 0.0f && a.this.aYC < f) {
                        a.this.aYC = f;
                        return;
                    }
                    return;
                }
                a.this.aYC = -f;
                return;
            }
            a.this.LZ();
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void n(float f, float f2) {
            View childAt;
            float f3 = 1.0f - f2;
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            View childAt2 = a.this.mListView.getChildAt(this.aZi - firstVisiblePosition);
            if (a.this.aYB) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / 1000.0f;
                if (uptimeMillis != 0.0f) {
                    float f4 = a.this.aYC * uptimeMillis;
                    int width = a.this.mListView.getWidth();
                    a.this.aYC = ((a.this.aYC > 0.0f ? 1 : -1) * uptimeMillis * width) + a.this.aYC;
                    this.aZd += f4;
                    a.this.aXB.x = (int) this.aZd;
                    if (this.aZd < width && this.aZd > (-width)) {
                        this.mStartTime = SystemClock.uptimeMillis();
                        a.this.ce(true);
                        return;
                    }
                } else {
                    return;
                }
            }
            if (childAt2 != null) {
                if (this.aZg == -1) {
                    this.aZg = a.this.f(this.aZi, childAt2, false);
                    this.aZe = childAt2.getHeight() - this.aZg;
                }
                int max = Math.max((int) (this.aZe * f3), 1);
                ViewGroup.LayoutParams layoutParams = childAt2.getLayoutParams();
                layoutParams.height = max + this.aZg;
                childAt2.setLayoutParams(layoutParams);
            }
            if (this.aZj != this.aZi && (childAt = a.this.mListView.getChildAt(this.aZj - firstVisiblePosition)) != null) {
                if (this.aZh == -1) {
                    this.aZh = a.this.f(this.aZj, childAt, false);
                    this.aZf = childAt.getHeight() - this.aZh;
                }
                int max2 = Math.max((int) (this.aZf * f3), 1);
                ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
                layoutParams2.height = max2 + this.aZh;
                childAt.setLayoutParams(layoutParams2);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.LS();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class j extends m {
        final /* synthetic */ a aYH;
        private float aZb;
        private float aZc;

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.aZb = this.aYH.aXN;
            this.aZc = this.aYH.aXV;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void n(float f, float f2) {
            if (this.aYH.mDragState != 4) {
                cancel();
                return;
            }
            this.aYH.aXN = (int) ((this.aZc * f2) + ((1.0f - f2) * this.aZb));
            this.aYH.aXB.y = this.aYH.aYj - this.aYH.aXN;
            this.aYH.ce(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e {
        StringBuilder mBuilder = new StringBuilder();
        private int aYS = 0;
        private int aYT = 0;
        private boolean aYU = false;
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
            this.aYT = 0;
            this.aYU = true;
        }

        public void Mc() {
            if (this.aYU) {
                this.mBuilder.append("<DSLVState>\n");
                int childCount = a.this.mListView.getChildCount();
                int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
                this.mBuilder.append("    <Positions>");
                for (int i = 0; i < childCount; i++) {
                    this.mBuilder.append(firstVisiblePosition + i).append(",");
                }
                this.mBuilder.append("</Positions>\n");
                this.mBuilder.append("    <Tops>");
                for (int i2 = 0; i2 < childCount; i2++) {
                    this.mBuilder.append(a.this.mListView.getChildAt(i2).getTop()).append(",");
                }
                this.mBuilder.append("</Tops>\n");
                this.mBuilder.append("    <Bottoms>");
                for (int i3 = 0; i3 < childCount; i3++) {
                    this.mBuilder.append(a.this.mListView.getChildAt(i3).getBottom()).append(",");
                }
                this.mBuilder.append("</Bottoms>\n");
                this.mBuilder.append("    <FirstExpPos>").append(a.this.aXI).append("</FirstExpPos>\n");
                this.mBuilder.append("    <FirstExpBlankHeight>").append(a.this.fw(a.this.aXI) - a.this.fy(a.this.aXI)).append("</FirstExpBlankHeight>\n");
                this.mBuilder.append("    <SecondExpPos>").append(a.this.aXJ).append("</SecondExpPos>\n");
                this.mBuilder.append("    <SecondExpBlankHeight>").append(a.this.fw(a.this.aXJ) - a.this.fy(a.this.aXJ)).append("</SecondExpBlankHeight>\n");
                this.mBuilder.append("    <SrcPos>").append(a.this.aXL).append("</SrcPos>\n");
                this.mBuilder.append("    <SrcHeight>").append(a.this.aXU + a.this.mListView.getDividerHeight()).append("</SrcHeight>\n");
                this.mBuilder.append("    <ViewHeight>").append(a.this.mListView.getHeight()).append("</ViewHeight>\n");
                this.mBuilder.append("    <LastY>").append(a.this.mLastY).append("</LastY>\n");
                this.mBuilder.append("    <FloatY>").append(a.this.aXD).append("</FloatY>\n");
                this.mBuilder.append("    <ShuffleEdges>");
                for (int i4 = 0; i4 < childCount; i4++) {
                    this.mBuilder.append(a.this.L(firstVisiblePosition + i4, a.this.mListView.getChildAt(i4).getTop())).append(",");
                }
                this.mBuilder.append("</ShuffleEdges>\n");
                this.mBuilder.append("</DSLVState>\n");
                this.aYS++;
                if (this.aYS > 1000) {
                    flush();
                    this.aYS = 0;
                }
            }
        }

        public void flush() {
            if (this.aYU) {
                try {
                    FileWriter fileWriter = new FileWriter(this.mFile, this.aYT != 0);
                    fileWriter.write(this.mBuilder.toString());
                    this.mBuilder.delete(0, this.mBuilder.length());
                    fileWriter.flush();
                    fileWriter.close();
                    this.aYT++;
                } catch (IOException e) {
                }
            }
        }

        public void mU() {
            if (this.aYU) {
                this.mBuilder.append("</DSLVStates>\n");
                flush();
                this.aYU = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements Runnable {
        private boolean aYK;
        private long aYL;
        private long aYM;
        private float aYN;
        private long aYO;
        private int aYP;
        private float aYQ;
        private boolean aYR = false;
        private int dy;

        public boolean Ma() {
            return this.aYR;
        }

        public int Mb() {
            if (this.aYR) {
                return this.aYP;
            }
            return -1;
        }

        public d() {
        }

        public void fz(int i) {
            if (!this.aYR) {
                this.aYK = false;
                this.aYR = true;
                this.aYO = SystemClock.uptimeMillis();
                this.aYL = this.aYO;
                this.aYP = i;
                a.this.mListView.post(this);
            }
        }

        public void cf(boolean z) {
            if (z) {
                a.this.mListView.removeCallbacks(this);
                this.aYR = false;
                return;
            }
            this.aYK = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.aYK) {
                int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
                int lastVisiblePosition = a.this.mListView.getLastVisiblePosition();
                int count = a.this.mListView.getCount();
                int paddingTop = a.this.mListView.getPaddingTop();
                int height = (a.this.mListView.getHeight() - paddingTop) - a.this.mListView.getPaddingBottom();
                int min = Math.min(a.this.aYj, a.this.aXD + a.this.aXV);
                int max = Math.max(a.this.aYj, a.this.aXD - a.this.aXV);
                if (this.aYP == 0) {
                    View childAt = a.this.mListView.getChildAt(0);
                    if (childAt == null) {
                        this.aYR = false;
                        return;
                    } else if (firstVisiblePosition == 0 && childAt.getTop() == paddingTop) {
                        this.aYR = false;
                        return;
                    } else {
                        this.aYQ = a.this.aYh.b((a.this.aYd - max) / a.this.aYe, this.aYL);
                    }
                } else {
                    View childAt2 = a.this.mListView.getChildAt(lastVisiblePosition - firstVisiblePosition);
                    if (childAt2 == null) {
                        this.aYR = false;
                        return;
                    } else if (lastVisiblePosition == count - 1 && childAt2.getBottom() <= height + paddingTop) {
                        this.aYR = false;
                        return;
                    } else {
                        this.aYQ = -a.this.aYh.b((min - a.this.aYc) / a.this.aYf, this.aYL);
                    }
                }
                this.aYM = SystemClock.uptimeMillis();
                this.aYN = (float) (this.aYM - this.aYL);
                this.dy = Math.round(this.aYQ * this.aYN);
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
                this.aYL = this.aYM;
                a.this.mListView.post(this);
                return;
            }
            this.aYR = false;
        }
    }
}
