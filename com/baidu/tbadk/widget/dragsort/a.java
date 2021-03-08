package com.baidu.tbadk.widget.dragsort;

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
import androidx.core.view.ViewCompat;
import com.baidu.tieba.R;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a implements com.baidu.tbadk.widget.dragsort.c {
    private int dxM;
    private int fRA;
    private int fRB;
    private int fRD;
    private int fRE;
    private int fRF;
    private b fRG;
    private g fRH;
    private l fRI;
    private int fRK;
    private d fRM;
    private int fRP;
    private int fRQ;
    private float fRR;
    private float fRS;
    private float fRT;
    private float fRU;
    private int fRX;
    private View fRs;
    private int fRv;
    private int fRz;
    private MotionEvent fSc;
    private C0589a fSg;
    private e fSi;
    private k fSl;
    private j fSm;
    private f fSn;
    private boolean fSo;
    private com.baidu.tbadk.widget.dragsort.d fSq;
    private com.baidu.tbadk.widget.dragsort.b fSr;
    private int mLastX;
    private int mLastY;
    private ListView mListView;
    private DataSetObserver mObserver;
    private int mOffsetX;
    private int mOffsetY;
    private int mX;
    private int mY;
    private Point fRt = new Point();
    private Point fRu = new Point();
    private boolean fRw = false;
    private float fRx = 1.0f;
    private float fRy = 1.0f;
    private boolean fRC = false;
    private boolean dSp = true;
    private int mDragState = 0;
    private int fRJ = 1;
    private int mWidthMeasureSpec = 0;
    private View[] fRL = new View[1];
    private float fRN = 0.33333334f;
    private float fRO = 0.33333334f;
    private float fRV = 0.5f;
    private c fRW = new c() { // from class: com.baidu.tbadk.widget.dragsort.a.1
        @Override // com.baidu.tbadk.widget.dragsort.a.c
        public float b(float f2, long j2) {
            return a.this.fRV * f2;
        }
    };
    private int fRY = 0;
    private boolean fRZ = false;
    private boolean fSa = false;
    private h fSb = null;
    private int fSd = 0;
    private float fSe = 0.25f;
    private float fSf = 0.0f;
    private boolean fSh = false;
    private boolean mBlockLayoutRequests = false;
    private boolean fSj = false;
    private i fSk = new i(3);
    private float fSp = 0.0f;
    private boolean fSs = false;
    private boolean fSt = false;

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
        void b(View view, Point point, Point point2);

        void bW(View view);

        View rQ(int i);
    }

    /* loaded from: classes.dex */
    public interface l {
        void remove(int i);
    }

    public a(ListView listView, com.baidu.tbadk.widget.dragsort.d dVar) {
        this.fSq = dVar;
        this.mListView = listView;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            this.fSg = new C0589a(listAdapter);
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
            this.fSg = null;
        }
        this.fSq.setAdapter(this.fSg);
    }

    private void c(int i2, Canvas canvas) {
        ViewGroup viewGroup;
        int bottom;
        int i3;
        Drawable divider = this.mListView.getDivider();
        int dividerHeight = this.mListView.getDividerHeight();
        if (divider != null && dividerHeight != 0 && (viewGroup = (ViewGroup) this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition())) != null) {
            int paddingLeft = this.mListView.getPaddingLeft();
            int width = this.mListView.getWidth() - this.mListView.getPaddingRight();
            int height = viewGroup.getChildAt(0).getHeight();
            if (i2 > this.fRD) {
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
    public int rM(int i2) {
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        return childAt != null ? childAt.getHeight() : bj(i2, rO(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bh(int i2, int i3) {
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        if (i2 <= headerViewsCount || i2 >= this.mListView.getCount() - footerViewsCount) {
            return i3;
        }
        int dividerHeight = this.mListView.getDividerHeight();
        int i4 = this.dxM - this.fRJ;
        int rO = rO(i2);
        int rM = rM(i2);
        if (this.fRB <= this.fRD) {
            if (i2 == this.fRB && this.fRA != this.fRB) {
                if (i2 == this.fRD) {
                    i3 = (i3 + rM) - this.dxM;
                } else {
                    i3 = ((rM - rO) + i3) - i4;
                }
            } else if (i2 > this.fRB && i2 <= this.fRD) {
                i3 -= i4;
            }
        } else if (i2 > this.fRD && i2 <= this.fRA) {
            i3 += i4;
        } else if (i2 == this.fRB && this.fRA != this.fRB) {
            i3 += rM - rO;
        }
        if (i2 <= this.fRD) {
            return (((this.dxM - dividerHeight) - rO(i2 - 1)) / 2) + i3;
        }
        return (((rO - dividerHeight) - this.dxM) / 2) + i3;
    }

    private boolean bGA() {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int i9 = this.fRA;
        View childAt = this.mListView.getChildAt(i9 - firstVisiblePosition);
        if (childAt == null) {
            i9 = firstVisiblePosition + (this.mListView.getChildCount() / 2);
            childAt = this.mListView.getChildAt(i9 - firstVisiblePosition);
        }
        int top = childAt.getTop();
        int height = childAt.getHeight();
        int bh = bh(i9, top);
        int dividerHeight = this.mListView.getDividerHeight();
        if (this.fRv < bh) {
            int i10 = top;
            i2 = i9;
            i3 = bh;
            i4 = bh;
            while (i2 >= 0) {
                i2--;
                int rM = rM(i2);
                if (i2 == 0) {
                    i5 = (i10 - dividerHeight) - rM;
                    i6 = i3;
                    break;
                }
                int i11 = i10 - (rM + dividerHeight);
                i5 = bh(i2, i11);
                if (this.fRv >= i5) {
                    i6 = i3;
                    break;
                }
                i10 = i11;
                i3 = i5;
                i4 = i5;
            }
            i6 = i3;
            i5 = i4;
        } else {
            int count = this.mListView.getCount();
            int i12 = top;
            i2 = i9;
            i3 = bh;
            i4 = bh;
            while (i2 < count) {
                if (i2 == count - 1) {
                    i5 = i12 + dividerHeight + height;
                    i6 = i3;
                    break;
                }
                int i13 = dividerHeight + height + i12;
                int rM2 = rM(i2 + 1);
                i5 = bh(i2 + 1, i13);
                if (this.fRv < i5) {
                    i6 = i3;
                    break;
                }
                i2++;
                i12 = i13;
                i3 = i5;
                i4 = i5;
                height = rM2;
            }
            i6 = i3;
            i5 = i4;
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int i14 = this.fRA;
        int i15 = this.fRB;
        float f2 = this.fSf;
        if (this.fRC) {
            int abs = Math.abs(i5 - i6);
            if (this.fRv < i5) {
                i7 = i5;
                i8 = i6;
            } else {
                i7 = i6;
                i8 = i5;
            }
            int i16 = (int) (this.fSe * 0.5f * abs);
            float f3 = i16;
            int i17 = i8 + i16;
            int i18 = i7 - i16;
            if (this.fRv < i17) {
                this.fRA = i2 - 1;
                this.fRB = i2;
                this.fSf = ((i17 - this.fRv) * 0.5f) / f3;
            } else if (this.fRv < i18) {
                this.fRA = i2;
                this.fRB = i2;
            } else {
                this.fRA = i2;
                this.fRB = i2 + 1;
                this.fSf = (1.0f + ((i7 - this.fRv) / f3)) * 0.5f;
            }
        } else {
            this.fRA = i2;
            this.fRB = i2;
        }
        if (this.fRA < headerViewsCount) {
            this.fRA = headerViewsCount;
            this.fRB = headerViewsCount;
            i2 = headerViewsCount;
        } else if (this.fRB >= this.mListView.getCount() - footerViewsCount) {
            i2 = (this.mListView.getCount() - footerViewsCount) - 1;
            this.fRA = i2;
            this.fRB = i2;
        }
        boolean z = (this.fRA == i14 && this.fRB == i15 && this.fSf == f2) ? false : true;
        if (i2 != this.fRz) {
            if (this.fRG != null) {
                this.fRG.drag(this.fRz - headerViewsCount, i2 - headerViewsCount);
            }
            this.fRz = i2;
            return true;
        }
        return z;
    }

    public void removeItem(int i2) {
        this.fSo = false;
        removeItem(i2, 0.0f);
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void a(ListView listView, Context context, AttributeSet attributeSet) {
        int i2;
        int i3;
        if (attributeSet == null) {
            i2 = 150;
            i3 = 150;
        } else {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DragSort, 0, 0);
            this.fRJ = Math.max(1, obtainStyledAttributes.getDimensionPixelSize(R.styleable.DragSort_collapsed_height, 1));
            this.fSh = obtainStyledAttributes.getBoolean(R.styleable.DragSort_track_drag_sort, false);
            if (this.fSh) {
                this.fSi = new e();
            }
            this.fRx = obtainStyledAttributes.getFloat(R.styleable.DragSort_float_alpha, this.fRx);
            this.fRy = this.fRx;
            this.dSp = obtainStyledAttributes.getBoolean(R.styleable.DragSort_drag_enabled, this.dSp);
            this.fSe = Math.max(0.0f, Math.min(1.0f, 1.0f - obtainStyledAttributes.getFloat(R.styleable.DragSort_slide_shuffle_speed, 0.75f)));
            this.fRC = this.fSe > 0.0f;
            setDragScrollStart(obtainStyledAttributes.getFloat(R.styleable.DragSort_drag_scroll_start, this.fRN));
            this.fRV = obtainStyledAttributes.getFloat(R.styleable.DragSort_max_drag_scroll_speed, this.fRV);
            int i4 = obtainStyledAttributes.getInt(R.styleable.DragSort_remove_animation_duration, 150);
            int i5 = obtainStyledAttributes.getInt(R.styleable.DragSort_drop_animation_duration, 150);
            if (obtainStyledAttributes.getBoolean(R.styleable.DragSort_use_default_controller, true)) {
                boolean z = obtainStyledAttributes.getBoolean(R.styleable.DragSort_remove_enabled, false);
                int i6 = obtainStyledAttributes.getInt(R.styleable.DragSort_tb_drag_remove_mode, 1);
                boolean z2 = obtainStyledAttributes.getBoolean(R.styleable.DragSort_sort_enabled, true);
                int resourceId = obtainStyledAttributes.getResourceId(R.styleable.DragSort_drag_handle_id, 0);
                int resourceId2 = obtainStyledAttributes.getResourceId(R.styleable.DragSort_fling_handle_id, 0);
                int resourceId3 = obtainStyledAttributes.getResourceId(R.styleable.DragSort_click_remove_id, 0);
                int color = obtainStyledAttributes.getColor(R.styleable.DragSort_float_background_color, ViewCompat.MEASURED_STATE_MASK);
                com.baidu.tbadk.widget.dragsort.b bVar = new com.baidu.tbadk.widget.dragsort.b(this, listView, resourceId, 2, i6, resourceId3, resourceId2);
                bVar.lF(z);
                bVar.lE(z2);
                bVar.setBackgroundColor(color);
                this.fSb = bVar;
                a(bVar);
            }
            obtainStyledAttributes.recycle();
            i2 = i5;
            i3 = i4;
        }
        this.fRM = new d();
        if (i3 > 0) {
            this.fSl = new k(0.5f, i3);
        }
        if (i2 > 0) {
            this.fSn = new f(0.5f, i2);
        }
        this.fSc = MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
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
        this.fSr = bVar;
        this.mListView.setOnTouchListener(bVar);
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void dispatchDraw(Canvas canvas) {
        float f2;
        this.fSq.dispatchDraw(canvas);
        if (this.mDragState != 0) {
            if (this.fRA != this.fRD) {
                c(this.fRA, canvas);
            }
            if (this.fRB != this.fRA && this.fRB != this.fRD) {
                c(this.fRB, canvas);
            }
        }
        if (this.fRs != null) {
            int width = this.fRs.getWidth();
            int height = this.fRs.getHeight();
            int i2 = this.fRt.x;
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
            int i3 = (int) (f2 * 255.0f * this.fRy);
            canvas.save();
            canvas.translate(this.fRt.x, this.fRt.y);
            canvas.clipRect(0, 0, width, height);
            canvas.saveLayerAlpha(0.0f, 0.0f, width, height, i3, 31);
            this.fRs.draw(canvas);
            canvas.restore();
            canvas.restore();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onDraw(Canvas canvas) {
        this.fSq.onDraw(canvas);
        if (this.fSh) {
            this.fSi.bGO();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.fSj) {
            this.fSj = false;
            return false;
        } else if (!this.dSp) {
            return this.fSq.onTouchEvent(motionEvent);
        } else {
            boolean z2 = this.fRZ;
            this.fRZ = false;
            if (!z2) {
                G(motionEvent);
            }
            if (this.mDragState == 4) {
                onDragTouchEvent(motionEvent);
                return true;
            }
            if (this.mDragState == 0 && this.fSq.onTouchEvent(motionEvent)) {
                z = true;
            }
            switch (motionEvent.getAction() & 255) {
                case 1:
                case 3:
                    bGF();
                    return z;
                case 2:
                default:
                    if (z) {
                        this.fSd = 1;
                        return z;
                    }
                    return z;
            }
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (!this.dSp) {
            return this.fSq.onInterceptTouchEvent(motionEvent);
        }
        if (this.fSr != null) {
            this.fSr.bGQ().onTouchEvent(motionEvent);
        }
        G(motionEvent);
        this.fRZ = true;
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            if (this.mDragState != 0) {
                this.fSj = true;
                return true;
            }
            this.fSa = true;
        }
        if (this.fRs == null) {
            if (this.fSq.onInterceptTouchEvent(motionEvent)) {
                this.fSs = true;
                z = true;
            } else {
                z = false;
            }
            switch (action) {
                case 1:
                case 3:
                    bGF();
                    break;
                case 2:
                default:
                    if (z) {
                        this.fSd = 1;
                        break;
                    } else {
                        this.fSd = 2;
                        break;
                    }
            }
        } else {
            z = true;
        }
        if (action == 1 || action == 3) {
            this.fSa = false;
        }
        return z;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        this.fSq.onSizeChanged(i2, i3, i4, i5);
        bGG();
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void requestLayout() {
        if (!this.mBlockLayoutRequests) {
            this.fSq.requestLayout();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onMeasure(int i2, int i3) {
        this.fSq.onMeasure(i2, i3);
        if (this.fRs != null) {
            if (this.fRs.isLayoutRequested()) {
                bGI();
            }
            this.fRw = true;
        }
        this.mWidthMeasureSpec = i2;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void layoutChildren() {
        this.fSq.layoutChildren();
        if (this.fRs != null) {
            if (this.fRs.isLayoutRequested() && !this.fRw) {
                bGI();
            }
            this.fRs.layout(0, 0, this.fRs.getMeasuredWidth(), this.fRs.getMeasuredHeight());
            this.fRw = false;
        }
    }

    public void removeItem(int i2, float f2) {
        if (this.mDragState == 0 || this.mDragState == 4) {
            if (this.mDragState == 0) {
                this.fRD = this.mListView.getHeaderViewsCount() + i2;
                this.fRA = this.fRD;
                this.fRB = this.fRD;
                this.fRz = this.fRD;
                View childAt = this.mListView.getChildAt(this.fRD - this.mListView.getFirstVisiblePosition());
                if (childAt != null) {
                    childAt.setVisibility(4);
                }
            }
            this.mDragState = 1;
            this.fSp = f2;
            if (this.fSa) {
                switch (this.fSd) {
                    case 1:
                        this.fSq.onTouchEvent(this.fSc);
                        break;
                    case 2:
                        this.fSq.onInterceptTouchEvent(this.fSc);
                        break;
                }
            }
            if (this.fSl != null) {
                this.fSl.start();
            } else {
                rN(i2);
            }
        }
    }

    public void cancelDrag() {
        if (this.mDragState == 4) {
            this.fRM.lD(true);
            bGK();
            bGB();
            bGH();
            if (this.fSa) {
                this.mDragState = 3;
            } else {
                this.mDragState = 0;
            }
        }
    }

    private void bGB() {
        this.fRD = -1;
        this.fRA = -1;
        this.fRB = -1;
        this.fRz = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGC() {
        this.mDragState = 2;
        if (this.fRH != null && this.fRz >= 0 && this.fRz < this.mListView.getCount()) {
            int headerViewsCount = this.mListView.getHeaderViewsCount();
            this.fRH.drop(this.fRD - headerViewsCount, this.fRz - headerViewsCount);
        }
        bGK();
        bGE();
        bGB();
        bGH();
        if (this.fSa) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGD() {
        rN(this.fRD - this.mListView.getHeaderViewsCount());
    }

    private void rN(int i2) {
        this.mDragState = 1;
        if (this.fRI != null) {
            this.fRI.remove(i2);
        }
        bGK();
        bGE();
        bGB();
        if (this.fSa) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    private void bGE() {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        if (this.fRD < firstVisiblePosition) {
            View childAt = this.mListView.getChildAt(0);
            this.mListView.setSelectionFromTop(firstVisiblePosition - 1, (childAt != null ? childAt.getTop() : 0) - this.mListView.getPaddingTop());
        }
    }

    public boolean stopDrag(boolean z) {
        this.fSo = false;
        return stopDrag(z, 0.0f);
    }

    public boolean stopDragWithVelocity(boolean z, float f2) {
        this.fSo = true;
        return stopDrag(z, f2);
    }

    public boolean stopDrag(boolean z, float f2) {
        if (this.fRs != null) {
            this.fRM.lD(true);
            if (z) {
                removeItem(this.fRD - this.mListView.getHeaderViewsCount(), f2);
            } else if (this.fSn != null) {
                this.fSn.start();
            } else {
                bGC();
            }
            if (this.fSh) {
                this.fSi.stopTracking();
                return true;
            }
            return true;
        }
        return false;
    }

    private void bGF() {
        this.fSd = 0;
        this.fSa = false;
        if (this.mDragState == 3) {
            this.mDragState = 0;
        }
        this.fRy = this.fRx;
        this.fSs = false;
        this.fSk.clear();
    }

    private void G(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            this.mLastX = this.mX;
            this.mLastY = this.mY;
        }
        this.mX = (int) motionEvent.getX();
        this.mY = (int) motionEvent.getY();
        if (action == 0) {
            this.mLastX = this.mX;
            this.mLastY = this.mY;
        }
        this.mOffsetX = ((int) motionEvent.getRawX()) - this.mX;
        this.mOffsetY = ((int) motionEvent.getRawY()) - this.mY;
    }

    public boolean listViewIntercepted() {
        return this.fSs;
    }

    public void setDragScrollStart(float f2) {
        setDragScrollStarts(f2, f2);
    }

    public void setDragScrollStarts(float f2, float f3) {
        if (f3 > 0.5f) {
            this.fRO = 0.5f;
        } else {
            this.fRO = f3;
        }
        if (f2 > 0.5f) {
            this.fRN = 0.5f;
        } else {
            this.fRN = f2;
        }
        if (this.mListView.getHeight() != 0) {
            bGG();
        }
    }

    private void bi(int i2, int i3) {
        this.fRt.x = i2 - this.fRE;
        this.fRt.y = i3 - this.fRF;
        lC(true);
        int min = Math.min(i3, this.fRv + this.fRK);
        int max = Math.max(i3, this.fRv - this.fRK);
        int bGM = this.fRM.bGM();
        if (min > this.mLastY && min > this.fRQ && bGM != 1) {
            if (bGM != -1) {
                this.fRM.lD(true);
            }
            this.fRM.rP(1);
        } else if (max < this.mLastY && max < this.fRP && bGM != 0) {
            if (bGM != -1) {
                this.fRM.lD(true);
            }
            this.fRM.rP(0);
        } else if (max >= this.fRP && min <= this.fRQ && this.fRM.bGL()) {
            this.fRM.lD(true);
        }
    }

    private void bGG() {
        int height;
        int paddingTop = this.mListView.getPaddingTop();
        float height2 = (this.mListView.getHeight() - paddingTop) - this.mListView.getPaddingBottom();
        this.fRS = paddingTop + (this.fRN * height2);
        this.fRR = (height2 * (1.0f - this.fRO)) + paddingTop;
        this.fRP = (int) this.fRS;
        this.fRQ = (int) this.fRR;
        this.fRT = this.fRS - paddingTop;
        this.fRU = (paddingTop + height) - this.fRR;
    }

    private void bGH() {
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
        if (i2 != this.fRD && i2 != this.fRA && i2 != this.fRB) {
            g2 = -2;
        } else {
            g2 = g(i2, view, z);
        }
        if (g2 != layoutParams.height) {
            layoutParams.height = g2;
            view.setLayoutParams(layoutParams);
        }
        if (i2 == this.fRA || i2 == this.fRB) {
            if (i2 < this.fRD) {
                ((DragSortItemView) view).setGravity(80);
            } else if (i2 > this.fRD) {
                ((DragSortItemView) view).setGravity(48);
            }
        }
        int visibility = view.getVisibility();
        int i3 = 0;
        if (i2 == this.fRD && this.fRs != null) {
            i3 = 4;
        }
        if (i3 != visibility) {
            view.setVisibility(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int rO(int i2) {
        View view;
        if (i2 == this.fRD) {
            return 0;
        }
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        if (childAt != null) {
            return f(i2, childAt, false);
        }
        int i3 = this.fSk.get(i2);
        if (i3 == -1) {
            ListAdapter adapter = this.mListView.getAdapter();
            int itemViewType = adapter.getItemViewType(i2);
            int viewTypeCount = adapter.getViewTypeCount();
            if (viewTypeCount != this.fRL.length) {
                this.fRL = new View[viewTypeCount];
            }
            if (itemViewType >= 0) {
                if (this.fRL[itemViewType] == null) {
                    view = adapter.getView(i2, null, this.mListView);
                    this.fRL[itemViewType] = view;
                } else {
                    view = adapter.getView(i2, this.fRL[itemViewType], this.mListView);
                }
            } else {
                view = adapter.getView(i2, null, this.mListView);
            }
            int f2 = f(i2, view, true);
            this.fSk.bk(i2, f2);
            return f2;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(int i2, View view, boolean z) {
        if (i2 == this.fRD) {
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
        return bj(i2, f(i2, view, z));
    }

    private int bj(int i2, int i3) {
        this.mListView.getDividerHeight();
        boolean z = this.fRC && this.fRA != this.fRB;
        int i4 = this.dxM - this.fRJ;
        int i5 = (int) (this.fSf * i4);
        if (i2 == this.fRD) {
            if (this.fRD == this.fRA) {
                if (z) {
                    return i5 + this.fRJ;
                }
                return this.dxM;
            } else if (this.fRD == this.fRB) {
                return this.dxM - i5;
            } else {
                return this.fRJ;
            }
        } else if (i2 == this.fRA) {
            if (z) {
                return i3 + i5;
            }
            return i3 + i4;
        } else if (i2 == this.fRB) {
            return (i3 + i4) - i5;
        } else {
            return i3;
        }
    }

    private int b(int i2, View view, int i3, int i4) {
        int i5;
        int i6;
        int rO = rO(i2);
        int height = view.getHeight();
        int bj = bj(i2, rO);
        if (i2 != this.fRD) {
            i6 = height - rO;
            i5 = bj - rO;
        } else {
            i5 = bj;
            i6 = height;
        }
        int i7 = this.dxM;
        if (this.fRD != this.fRA && this.fRD != this.fRB) {
            i7 -= this.fRJ;
        }
        if (i2 <= i3) {
            if (i2 > this.fRA) {
                return (i7 - i5) + 0;
            }
        } else if (i2 == i4) {
            if (i2 <= this.fRA) {
                return (i6 - i7) + 0;
            }
            if (i2 == this.fRB) {
                return (height - bj) + 0;
            }
            return 0 + i6;
        } else if (i2 <= this.fRA) {
            return 0 - i7;
        } else {
            if (i2 == this.fRB) {
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

    private void bGI() {
        if (this.fRs != null) {
            measureItem(this.fRs);
            this.dxM = this.fRs.getMeasuredHeight();
            this.fRK = this.dxM / 2;
        }
    }

    protected boolean onDragTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        switch (motionEvent.getAction() & 255) {
            case 1:
                if (this.mDragState == 4) {
                    stopDrag(false);
                }
                bGF();
                return true;
            case 2:
                bi((int) motionEvent.getX(), (int) motionEvent.getY());
                return true;
            case 3:
                if (this.mDragState == 4) {
                    cancelDrag();
                }
                bGF();
                return true;
            default:
                return true;
        }
    }

    public boolean startDrag(int i2, int i3, int i4, int i5) {
        View rQ;
        if (!this.fSa || this.fSb == null || (rQ = this.fSb.rQ(i2)) == null) {
            return false;
        }
        return startDrag(i2, rQ, i3, i4, i5);
    }

    public boolean startDrag(int i2, View view, int i3, int i4, int i5) {
        if (this.mDragState == 0 && this.fSa && this.fRs == null && view != null && this.dSp) {
            if (this.mListView.getParent() != null) {
                this.mListView.getParent().requestDisallowInterceptTouchEvent(true);
            }
            int headerViewsCount = this.mListView.getHeaderViewsCount() + i2;
            this.fRA = headerViewsCount;
            this.fRB = headerViewsCount;
            this.fRD = headerViewsCount;
            this.fRz = headerViewsCount;
            this.mDragState = 4;
            this.fRY = 0;
            this.fRY |= i3;
            this.fRs = view;
            bGI();
            this.fRE = i4;
            this.fRF = i5;
            this.fRX = this.mY;
            this.fRt.x = this.mX - this.fRE;
            this.fRt.y = this.mY - this.fRF;
            View childAt = this.mListView.getChildAt(this.fRD - this.mListView.getFirstVisiblePosition());
            if (childAt != null) {
                childAt.setVisibility(4);
            }
            if (this.fSh) {
                this.fSi.bGN();
            }
            switch (this.fSd) {
                case 1:
                    this.fSq.onTouchEvent(this.fSc);
                    break;
                case 2:
                    this.fSq.onInterceptTouchEvent(this.fSc);
                    break;
            }
            this.mListView.requestLayout();
            if (this.fSm != null) {
                this.fSm.start();
                return true;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lC(boolean z) {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition() + (this.mListView.getChildCount() / 2);
        View childAt = this.mListView.getChildAt(this.mListView.getChildCount() / 2);
        if (childAt != null) {
            h(firstVisiblePosition, childAt, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i2, View view, boolean z) {
        this.mBlockLayoutRequests = true;
        bGJ();
        int i3 = this.fRA;
        int i4 = this.fRB;
        boolean bGA = bGA();
        if (bGA) {
            bGH();
            this.mListView.setSelectionFromTop(i2, (b(i2, view, i3, i4) + view.getTop()) - this.mListView.getPaddingTop());
            layoutChildren();
        }
        if (bGA || z) {
            this.mListView.invalidate();
        }
        this.mBlockLayoutRequests = false;
    }

    private void bGJ() {
        if (this.fSb != null) {
            this.fRu.set(this.mX, this.mY);
            this.fSb.b(this.fRs, this.fRt, this.fRu);
        }
        int i2 = this.fRt.x;
        int i3 = this.fRt.y;
        int paddingLeft = this.mListView.getPaddingLeft();
        if ((this.fRY & 1) == 0 && i2 > paddingLeft) {
            this.fRt.x = paddingLeft;
        } else if ((this.fRY & 2) == 0 && i2 < paddingLeft) {
            this.fRt.x = paddingLeft;
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int lastVisiblePosition = this.mListView.getLastVisiblePosition();
        int paddingTop = this.mListView.getPaddingTop();
        if (firstVisiblePosition < headerViewsCount) {
            paddingTop = this.mListView.getChildAt((headerViewsCount - firstVisiblePosition) - 1).getBottom();
        }
        if ((this.fRY & 8) == 0 && firstVisiblePosition <= this.fRD) {
            paddingTop = Math.max(this.mListView.getChildAt(this.fRD - firstVisiblePosition).getTop(), paddingTop);
        }
        int height = this.mListView.getHeight() - this.mListView.getPaddingBottom();
        if (lastVisiblePosition >= (this.mListView.getCount() - footerViewsCount) - 1) {
            height = this.mListView.getChildAt(((this.mListView.getCount() - footerViewsCount) - 1) - firstVisiblePosition).getBottom();
        }
        if ((this.fRY & 4) == 0 && lastVisiblePosition >= this.fRD) {
            height = Math.min(this.mListView.getChildAt(this.fRD - firstVisiblePosition).getBottom(), height);
        }
        if (i3 < paddingTop) {
            this.fRt.y = paddingTop;
        } else if (this.dxM + i3 > height) {
            this.fRt.y = height - this.dxM;
        }
        this.fRv = this.fRt.y + this.fRK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGK() {
        if (this.fRs != null) {
            this.fRs.setVisibility(8);
            if (this.fSb != null) {
                this.fSb.bW(this.fRs);
            }
            this.fRs = null;
            this.mListView.invalidate();
        }
    }

    public void a(h hVar) {
        this.fSb = hVar;
    }

    public void a(b bVar) {
        this.fRG = bVar;
    }

    public void setDragEnabled(boolean z) {
        this.dSp = z;
    }

    public boolean isDragEnabled() {
        return this.dSp;
    }

    public void a(g gVar) {
        this.fRH = gVar;
    }

    public void a(l lVar) {
        this.fRI = lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class i {
        private SparseIntArray fSN;
        private ArrayList<Integer> fSO;
        private int mMaxSize;

        public i(int i) {
            this.fSN = new SparseIntArray(i);
            this.fSO = new ArrayList<>(i);
            this.mMaxSize = i;
        }

        public void bk(int i, int i2) {
            int i3 = this.fSN.get(i, -1);
            if (i3 != i2) {
                if (i3 == -1) {
                    if (this.fSN.size() == this.mMaxSize) {
                        this.fSN.delete(this.fSO.remove(0).intValue());
                    }
                } else {
                    this.fSO.remove(Integer.valueOf(i));
                }
                this.fSN.put(i, i2);
                this.fSO.add(Integer.valueOf(i));
            }
        }

        public int get(int i) {
            return this.fSN.get(i, -1);
        }

        public void clear() {
            this.fSN.clear();
            this.fSO.clear();
        }
    }

    /* renamed from: com.baidu.tbadk.widget.dragsort.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0589a extends BaseAdapter {
        private ListAdapter mAdapter;

        public C0589a(ListAdapter listAdapter) {
            this.mAdapter = listAdapter;
            this.mAdapter.registerDataSetObserver(new DataSetObserver() { // from class: com.baidu.tbadk.widget.dragsort.a.a.1
                @Override // android.database.DataSetObserver
                public void onChanged() {
                    C0589a.this.notifyDataSetChanged();
                }

                @Override // android.database.DataSetObserver
                public void onInvalidated() {
                    C0589a.this.notifyDataSetInvalidated();
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
        private float cLP;
        private float cLQ;
        private float cLR;
        private float cLS;
        private float fSY;
        private float mAlpha;
        private boolean mCanceled;
        protected long mStartTime;

        public m(float f, int i) {
            this.mAlpha = f;
            this.fSY = i;
            float f2 = 1.0f / ((this.mAlpha * 2.0f) * (1.0f - this.mAlpha));
            this.cLS = f2;
            this.cLP = f2;
            this.cLQ = this.mAlpha / ((this.mAlpha - 1.0f) * 2.0f);
            this.cLR = 1.0f / (1.0f - this.mAlpha);
        }

        public float av(float f) {
            if (f < this.mAlpha) {
                return this.cLP * f * f;
            }
            if (f < 1.0f - this.mAlpha) {
                return this.cLQ + (this.cLR * f);
            }
            return 1.0f - ((this.cLS * (f - 1.0f)) * (f - 1.0f));
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

        public void y(float f, float f2) {
        }

        public void onStop() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.mCanceled) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / this.fSY;
                if (uptimeMillis >= 1.0f) {
                    y(1.0f, 1.0f);
                    onStop();
                    return;
                }
                y(uptimeMillis, av(uptimeMillis));
                a.this.mListView.post(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class f extends m {
        private int fSJ;
        private int fSK;
        private float fSL;
        private float fSM;

        public f(float f, int i) {
            super(f, i);
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.fSJ = a.this.fRz;
            this.fSK = a.this.fRD;
            a.this.mDragState = 2;
            this.fSL = a.this.fRt.y - bGP();
            this.fSM = a.this.fRt.x - a.this.mListView.getPaddingLeft();
        }

        private int bGP() {
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            int dividerHeight = (a.this.fRJ + a.this.mListView.getDividerHeight()) / 2;
            View childAt = a.this.mListView.getChildAt(this.fSJ - firstVisiblePosition);
            if (childAt != null) {
                if (this.fSJ == this.fSK) {
                    return childAt.getTop();
                }
                if (this.fSJ >= this.fSK) {
                    return (childAt.getBottom() + dividerHeight) - a.this.dxM;
                }
                return childAt.getTop() - dividerHeight;
            }
            cancel();
            return -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void y(float f, float f2) {
            int bGP = bGP();
            float paddingLeft = a.this.fRt.x - a.this.mListView.getPaddingLeft();
            float f3 = 1.0f - f2;
            if (f3 < Math.abs((a.this.fRt.y - bGP) / this.fSL) || f3 < Math.abs(paddingLeft / this.fSM)) {
                a.this.fRt.y = bGP + ((int) (this.fSL * f3));
                a.this.fRt.x = a.this.mListView.getPaddingLeft() + ((int) (this.fSM * f3));
                a.this.lC(true);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.bGC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class k extends m {
        private int fSK;
        private float fSR;
        private float fSS;
        private float fST;
        private int fSU;
        private int fSV;
        private int fSW;
        private int fSX;

        public k(float f, int i) {
            super(f, i);
            this.fSU = -1;
            this.fSV = -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.fSU = -1;
            this.fSV = -1;
            this.fSW = a.this.fRA;
            this.fSX = a.this.fRB;
            this.fSK = a.this.fRD;
            a.this.mDragState = 1;
            this.fSR = a.this.fRt.x;
            if (a.this.fSo) {
                float width = a.this.mListView.getWidth() * 2.0f;
                if (a.this.fSp == 0.0f) {
                    a.this.fSp = (this.fSR >= 0.0f ? 1 : -1) * width;
                    return;
                }
                float f = width * 2.0f;
                if (a.this.fSp >= 0.0f || a.this.fSp <= (-f)) {
                    if (a.this.fSp > 0.0f && a.this.fSp < f) {
                        a.this.fSp = f;
                        return;
                    }
                    return;
                }
                a.this.fSp = -f;
                return;
            }
            a.this.bGK();
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void y(float f, float f2) {
            View childAt;
            float f3 = 1.0f - f2;
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            View childAt2 = a.this.mListView.getChildAt(this.fSW - firstVisiblePosition);
            if (a.this.fSo) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / 1000.0f;
                if (uptimeMillis != 0.0f) {
                    float f4 = a.this.fSp * uptimeMillis;
                    int width = a.this.mListView.getWidth();
                    a.this.fSp = ((a.this.fSp > 0.0f ? 1 : -1) * uptimeMillis * width) + a.this.fSp;
                    this.fSR += f4;
                    a.this.fRt.x = (int) this.fSR;
                    if (this.fSR < width && this.fSR > (-width)) {
                        this.mStartTime = SystemClock.uptimeMillis();
                        a.this.lC(true);
                        return;
                    }
                } else {
                    return;
                }
            }
            if (childAt2 != null) {
                if (this.fSU == -1) {
                    this.fSU = a.this.f(this.fSW, childAt2, false);
                    this.fSS = childAt2.getHeight() - this.fSU;
                }
                int max = Math.max((int) (this.fSS * f3), 1);
                ViewGroup.LayoutParams layoutParams = childAt2.getLayoutParams();
                layoutParams.height = max + this.fSU;
                childAt2.setLayoutParams(layoutParams);
            }
            if (this.fSX != this.fSW && (childAt = a.this.mListView.getChildAt(this.fSX - firstVisiblePosition)) != null) {
                if (this.fSV == -1) {
                    this.fSV = a.this.f(this.fSX, childAt, false);
                    this.fST = childAt.getHeight() - this.fSV;
                }
                int max2 = Math.max((int) (this.fST * f3), 1);
                ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
                layoutParams2.height = max2 + this.fSV;
                childAt.setLayoutParams(layoutParams2);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.bGD();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class j extends m {
        private float fSP;
        private float fSQ;
        final /* synthetic */ a fSu;

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.fSP = this.fSu.fRF;
            this.fSQ = this.fSu.fRK;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void y(float f, float f2) {
            if (this.fSu.mDragState != 4) {
                cancel();
                return;
            }
            this.fSu.fRF = (int) ((this.fSQ * f2) + ((1.0f - f2) * this.fSP));
            this.fSu.fRt.y = this.fSu.mY - this.fSu.fRF;
            this.fSu.lC(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e {
        StringBuilder mBuilder = new StringBuilder();
        private int fSG = 0;
        private int fSH = 0;
        private boolean fSI = false;
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

        public void bGN() {
            this.mBuilder.append("<DSLVStates>\n");
            this.fSH = 0;
            this.fSI = true;
        }

        public void bGO() {
            if (this.fSI) {
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
                this.mBuilder.append("    <FirstExpPos>").append(a.this.fRA).append("</FirstExpPos>\n");
                this.mBuilder.append("    <FirstExpBlankHeight>").append(a.this.rM(a.this.fRA) - a.this.rO(a.this.fRA)).append("</FirstExpBlankHeight>\n");
                this.mBuilder.append("    <SecondExpPos>").append(a.this.fRB).append("</SecondExpPos>\n");
                this.mBuilder.append("    <SecondExpBlankHeight>").append(a.this.rM(a.this.fRB) - a.this.rO(a.this.fRB)).append("</SecondExpBlankHeight>\n");
                this.mBuilder.append("    <SrcPos>").append(a.this.fRD).append("</SrcPos>\n");
                this.mBuilder.append("    <SrcHeight>").append(a.this.dxM + a.this.mListView.getDividerHeight()).append("</SrcHeight>\n");
                this.mBuilder.append("    <ViewHeight>").append(a.this.mListView.getHeight()).append("</ViewHeight>\n");
                this.mBuilder.append("    <LastY>").append(a.this.mLastY).append("</LastY>\n");
                this.mBuilder.append("    <FloatY>").append(a.this.fRv).append("</FloatY>\n");
                this.mBuilder.append("    <ShuffleEdges>");
                for (int i4 = 0; i4 < childCount; i4++) {
                    this.mBuilder.append(a.this.bh(firstVisiblePosition + i4, a.this.mListView.getChildAt(i4).getTop())).append(",");
                }
                this.mBuilder.append("</ShuffleEdges>\n");
                this.mBuilder.append("</DSLVState>\n");
                this.fSG++;
                if (this.fSG > 1000) {
                    flush();
                    this.fSG = 0;
                }
            }
        }

        public void flush() {
            if (this.fSI) {
                try {
                    FileWriter fileWriter = new FileWriter(this.mFile, this.fSH != 0);
                    fileWriter.write(this.mBuilder.toString());
                    this.mBuilder.delete(0, this.mBuilder.length());
                    fileWriter.flush();
                    fileWriter.close();
                    this.fSH++;
                } catch (IOException e) {
                }
            }
        }

        public void stopTracking() {
            if (this.fSI) {
                this.mBuilder.append("</DSLVStates>\n");
                flush();
                this.fSI = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements Runnable {
        private int fSA;
        private float fSB;
        private long fSC;
        private int fSD;
        private float fSE;
        private boolean fSF = false;
        private boolean fSx;
        private long fSy;
        private long fSz;

        public boolean bGL() {
            return this.fSF;
        }

        public int bGM() {
            if (this.fSF) {
                return this.fSD;
            }
            return -1;
        }

        public d() {
        }

        public void rP(int i) {
            if (!this.fSF) {
                this.fSx = false;
                this.fSF = true;
                this.fSC = SystemClock.uptimeMillis();
                this.fSy = this.fSC;
                this.fSD = i;
                a.this.mListView.post(this);
            }
        }

        public void lD(boolean z) {
            if (z) {
                a.this.mListView.removeCallbacks(this);
                this.fSF = false;
                return;
            }
            this.fSx = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.fSx) {
                int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
                int lastVisiblePosition = a.this.mListView.getLastVisiblePosition();
                int count = a.this.mListView.getCount();
                int paddingTop = a.this.mListView.getPaddingTop();
                int height = (a.this.mListView.getHeight() - paddingTop) - a.this.mListView.getPaddingBottom();
                int min = Math.min(a.this.mY, a.this.fRv + a.this.fRK);
                int max = Math.max(a.this.mY, a.this.fRv - a.this.fRK);
                if (this.fSD == 0) {
                    View childAt = a.this.mListView.getChildAt(0);
                    if (childAt == null) {
                        this.fSF = false;
                        return;
                    } else if (firstVisiblePosition == 0 && childAt.getTop() == paddingTop) {
                        this.fSF = false;
                        return;
                    } else {
                        this.fSE = a.this.fRW.b((a.this.fRS - max) / a.this.fRT, this.fSy);
                    }
                } else {
                    View childAt2 = a.this.mListView.getChildAt(lastVisiblePosition - firstVisiblePosition);
                    if (childAt2 == null) {
                        this.fSF = false;
                        return;
                    } else if (lastVisiblePosition == count - 1 && childAt2.getBottom() <= height + paddingTop) {
                        this.fSF = false;
                        return;
                    } else {
                        this.fSE = -a.this.fRW.b((min - a.this.fRR) / a.this.fRU, this.fSy);
                    }
                }
                this.fSz = SystemClock.uptimeMillis();
                this.fSB = (float) (this.fSz - this.fSy);
                this.fSA = Math.round(this.fSE * this.fSB);
                if (this.fSA >= 0) {
                    this.fSA = Math.min(height, this.fSA);
                    lastVisiblePosition = firstVisiblePosition;
                } else {
                    this.fSA = Math.max(-height, this.fSA);
                }
                View childAt3 = a.this.mListView.getChildAt(lastVisiblePosition - firstVisiblePosition);
                int top = childAt3.getTop() + this.fSA;
                if (lastVisiblePosition == 0 && top > paddingTop) {
                    top = paddingTop;
                }
                a.this.mBlockLayoutRequests = true;
                a.this.mListView.setSelectionFromTop(lastVisiblePosition, top - paddingTop);
                a.this.layoutChildren();
                a.this.mListView.invalidate();
                a.this.mBlockLayoutRequests = false;
                a.this.h(lastVisiblePosition, childAt3, false);
                this.fSy = this.fSz;
                a.this.mListView.post(this);
                return;
            }
            this.fSF = false;
        }
    }
}
