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
    private int dwl;
    private View fPS;
    private int fPV;
    private int fPZ;
    private MotionEvent fQC;
    private C0583a fQG;
    private e fQI;
    private k fQL;
    private j fQM;
    private f fQN;
    private boolean fQO;
    private com.baidu.tbadk.widget.dragsort.d fQQ;
    private com.baidu.tbadk.widget.dragsort.b fQR;
    private int fQa;
    private int fQb;
    private int fQd;
    private int fQe;
    private int fQf;
    private b fQg;
    private g fQh;
    private l fQi;
    private int fQk;
    private d fQm;
    private int fQp;
    private int fQq;
    private float fQr;
    private float fQs;
    private float fQt;
    private float fQu;
    private int fQx;
    private int mLastX;
    private int mLastY;
    private ListView mListView;
    private DataSetObserver mObserver;
    private int mOffsetX;
    private int mOffsetY;
    private int mX;
    private int mY;
    private Point fPT = new Point();
    private Point fPU = new Point();
    private boolean fPW = false;
    private float fPX = 1.0f;
    private float fPY = 1.0f;
    private boolean fQc = false;
    private boolean dQO = true;
    private int mDragState = 0;
    private int fQj = 1;
    private int mWidthMeasureSpec = 0;
    private View[] fQl = new View[1];
    private float fQn = 0.33333334f;
    private float fQo = 0.33333334f;
    private float fQv = 0.5f;
    private c fQw = new c() { // from class: com.baidu.tbadk.widget.dragsort.a.1
        @Override // com.baidu.tbadk.widget.dragsort.a.c
        public float b(float f2, long j2) {
            return a.this.fQv * f2;
        }
    };
    private int fQy = 0;
    private boolean fQz = false;
    private boolean fQA = false;
    private h fQB = null;
    private int fQD = 0;
    private float fQE = 0.25f;
    private float fQF = 0.0f;
    private boolean fQH = false;
    private boolean mBlockLayoutRequests = false;
    private boolean fQJ = false;
    private i fQK = new i(3);
    private float fQP = 0.0f;
    private boolean fQS = false;
    private boolean fQT = false;

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

        View rO(int i);
    }

    /* loaded from: classes.dex */
    public interface l {
        void remove(int i);
    }

    public a(ListView listView, com.baidu.tbadk.widget.dragsort.d dVar) {
        this.fQQ = dVar;
        this.mListView = listView;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            this.fQG = new C0583a(listAdapter);
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
            this.fQG = null;
        }
        this.fQQ.setAdapter(this.fQG);
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
            if (i2 > this.fQd) {
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
    public int rK(int i2) {
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        return childAt != null ? childAt.getHeight() : bj(i2, rM(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bh(int i2, int i3) {
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        if (i2 <= headerViewsCount || i2 >= this.mListView.getCount() - footerViewsCount) {
            return i3;
        }
        int dividerHeight = this.mListView.getDividerHeight();
        int i4 = this.dwl - this.fQj;
        int rM = rM(i2);
        int rK = rK(i2);
        if (this.fQb <= this.fQd) {
            if (i2 == this.fQb && this.fQa != this.fQb) {
                if (i2 == this.fQd) {
                    i3 = (i3 + rK) - this.dwl;
                } else {
                    i3 = ((rK - rM) + i3) - i4;
                }
            } else if (i2 > this.fQb && i2 <= this.fQd) {
                i3 -= i4;
            }
        } else if (i2 > this.fQd && i2 <= this.fQa) {
            i3 += i4;
        } else if (i2 == this.fQb && this.fQa != this.fQb) {
            i3 += rK - rM;
        }
        if (i2 <= this.fQd) {
            return (((this.dwl - dividerHeight) - rM(i2 - 1)) / 2) + i3;
        }
        return (((rM - dividerHeight) - this.dwl) / 2) + i3;
    }

    private boolean bGw() {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int i9 = this.fQa;
        View childAt = this.mListView.getChildAt(i9 - firstVisiblePosition);
        if (childAt == null) {
            i9 = firstVisiblePosition + (this.mListView.getChildCount() / 2);
            childAt = this.mListView.getChildAt(i9 - firstVisiblePosition);
        }
        int top = childAt.getTop();
        int height = childAt.getHeight();
        int bh = bh(i9, top);
        int dividerHeight = this.mListView.getDividerHeight();
        if (this.fPV < bh) {
            int i10 = top;
            i2 = i9;
            i3 = bh;
            i4 = bh;
            while (i2 >= 0) {
                i2--;
                int rK = rK(i2);
                if (i2 == 0) {
                    i5 = (i10 - dividerHeight) - rK;
                    i6 = i3;
                    break;
                }
                int i11 = i10 - (rK + dividerHeight);
                i5 = bh(i2, i11);
                if (this.fPV >= i5) {
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
                int rK2 = rK(i2 + 1);
                i5 = bh(i2 + 1, i13);
                if (this.fPV < i5) {
                    i6 = i3;
                    break;
                }
                i2++;
                i12 = i13;
                i3 = i5;
                i4 = i5;
                height = rK2;
            }
            i6 = i3;
            i5 = i4;
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int i14 = this.fQa;
        int i15 = this.fQb;
        float f2 = this.fQF;
        if (this.fQc) {
            int abs = Math.abs(i5 - i6);
            if (this.fPV < i5) {
                i7 = i5;
                i8 = i6;
            } else {
                i7 = i6;
                i8 = i5;
            }
            int i16 = (int) (this.fQE * 0.5f * abs);
            float f3 = i16;
            int i17 = i8 + i16;
            int i18 = i7 - i16;
            if (this.fPV < i17) {
                this.fQa = i2 - 1;
                this.fQb = i2;
                this.fQF = ((i17 - this.fPV) * 0.5f) / f3;
            } else if (this.fPV < i18) {
                this.fQa = i2;
                this.fQb = i2;
            } else {
                this.fQa = i2;
                this.fQb = i2 + 1;
                this.fQF = (1.0f + ((i7 - this.fPV) / f3)) * 0.5f;
            }
        } else {
            this.fQa = i2;
            this.fQb = i2;
        }
        if (this.fQa < headerViewsCount) {
            this.fQa = headerViewsCount;
            this.fQb = headerViewsCount;
            i2 = headerViewsCount;
        } else if (this.fQb >= this.mListView.getCount() - footerViewsCount) {
            i2 = (this.mListView.getCount() - footerViewsCount) - 1;
            this.fQa = i2;
            this.fQb = i2;
        }
        boolean z = (this.fQa == i14 && this.fQb == i15 && this.fQF == f2) ? false : true;
        if (i2 != this.fPZ) {
            if (this.fQg != null) {
                this.fQg.drag(this.fPZ - headerViewsCount, i2 - headerViewsCount);
            }
            this.fPZ = i2;
            return true;
        }
        return z;
    }

    public void removeItem(int i2) {
        this.fQO = false;
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
            this.fQj = Math.max(1, obtainStyledAttributes.getDimensionPixelSize(R.styleable.DragSort_collapsed_height, 1));
            this.fQH = obtainStyledAttributes.getBoolean(R.styleable.DragSort_track_drag_sort, false);
            if (this.fQH) {
                this.fQI = new e();
            }
            this.fPX = obtainStyledAttributes.getFloat(R.styleable.DragSort_float_alpha, this.fPX);
            this.fPY = this.fPX;
            this.dQO = obtainStyledAttributes.getBoolean(R.styleable.DragSort_drag_enabled, this.dQO);
            this.fQE = Math.max(0.0f, Math.min(1.0f, 1.0f - obtainStyledAttributes.getFloat(R.styleable.DragSort_slide_shuffle_speed, 0.75f)));
            this.fQc = this.fQE > 0.0f;
            setDragScrollStart(obtainStyledAttributes.getFloat(R.styleable.DragSort_drag_scroll_start, this.fQn));
            this.fQv = obtainStyledAttributes.getFloat(R.styleable.DragSort_max_drag_scroll_speed, this.fQv);
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
                this.fQB = bVar;
                a(bVar);
            }
            obtainStyledAttributes.recycle();
            i2 = i5;
            i3 = i4;
        }
        this.fQm = new d();
        if (i3 > 0) {
            this.fQL = new k(0.5f, i3);
        }
        if (i2 > 0) {
            this.fQN = new f(0.5f, i2);
        }
        this.fQC = MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
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
        this.fQR = bVar;
        this.mListView.setOnTouchListener(bVar);
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void dispatchDraw(Canvas canvas) {
        float f2;
        this.fQQ.dispatchDraw(canvas);
        if (this.mDragState != 0) {
            if (this.fQa != this.fQd) {
                c(this.fQa, canvas);
            }
            if (this.fQb != this.fQa && this.fQb != this.fQd) {
                c(this.fQb, canvas);
            }
        }
        if (this.fPS != null) {
            int width = this.fPS.getWidth();
            int height = this.fPS.getHeight();
            int i2 = this.fPT.x;
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
            int i3 = (int) (f2 * 255.0f * this.fPY);
            canvas.save();
            canvas.translate(this.fPT.x, this.fPT.y);
            canvas.clipRect(0, 0, width, height);
            canvas.saveLayerAlpha(0.0f, 0.0f, width, height, i3, 31);
            this.fPS.draw(canvas);
            canvas.restore();
            canvas.restore();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onDraw(Canvas canvas) {
        this.fQQ.onDraw(canvas);
        if (this.fQH) {
            this.fQI.bGK();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.fQJ) {
            this.fQJ = false;
            return false;
        } else if (!this.dQO) {
            return this.fQQ.onTouchEvent(motionEvent);
        } else {
            boolean z2 = this.fQz;
            this.fQz = false;
            if (!z2) {
                G(motionEvent);
            }
            if (this.mDragState == 4) {
                onDragTouchEvent(motionEvent);
                return true;
            }
            if (this.mDragState == 0 && this.fQQ.onTouchEvent(motionEvent)) {
                z = true;
            }
            switch (motionEvent.getAction() & 255) {
                case 1:
                case 3:
                    bGB();
                    return z;
                case 2:
                default:
                    if (z) {
                        this.fQD = 1;
                        return z;
                    }
                    return z;
            }
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (!this.dQO) {
            return this.fQQ.onInterceptTouchEvent(motionEvent);
        }
        if (this.fQR != null) {
            this.fQR.bGM().onTouchEvent(motionEvent);
        }
        G(motionEvent);
        this.fQz = true;
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            if (this.mDragState != 0) {
                this.fQJ = true;
                return true;
            }
            this.fQA = true;
        }
        if (this.fPS == null) {
            if (this.fQQ.onInterceptTouchEvent(motionEvent)) {
                this.fQS = true;
                z = true;
            } else {
                z = false;
            }
            switch (action) {
                case 1:
                case 3:
                    bGB();
                    break;
                case 2:
                default:
                    if (z) {
                        this.fQD = 1;
                        break;
                    } else {
                        this.fQD = 2;
                        break;
                    }
            }
        } else {
            z = true;
        }
        if (action == 1 || action == 3) {
            this.fQA = false;
        }
        return z;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        this.fQQ.onSizeChanged(i2, i3, i4, i5);
        bGC();
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void requestLayout() {
        if (!this.mBlockLayoutRequests) {
            this.fQQ.requestLayout();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onMeasure(int i2, int i3) {
        this.fQQ.onMeasure(i2, i3);
        if (this.fPS != null) {
            if (this.fPS.isLayoutRequested()) {
                bGE();
            }
            this.fPW = true;
        }
        this.mWidthMeasureSpec = i2;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void layoutChildren() {
        this.fQQ.layoutChildren();
        if (this.fPS != null) {
            if (this.fPS.isLayoutRequested() && !this.fPW) {
                bGE();
            }
            this.fPS.layout(0, 0, this.fPS.getMeasuredWidth(), this.fPS.getMeasuredHeight());
            this.fPW = false;
        }
    }

    public void removeItem(int i2, float f2) {
        if (this.mDragState == 0 || this.mDragState == 4) {
            if (this.mDragState == 0) {
                this.fQd = this.mListView.getHeaderViewsCount() + i2;
                this.fQa = this.fQd;
                this.fQb = this.fQd;
                this.fPZ = this.fQd;
                View childAt = this.mListView.getChildAt(this.fQd - this.mListView.getFirstVisiblePosition());
                if (childAt != null) {
                    childAt.setVisibility(4);
                }
            }
            this.mDragState = 1;
            this.fQP = f2;
            if (this.fQA) {
                switch (this.fQD) {
                    case 1:
                        this.fQQ.onTouchEvent(this.fQC);
                        break;
                    case 2:
                        this.fQQ.onInterceptTouchEvent(this.fQC);
                        break;
                }
            }
            if (this.fQL != null) {
                this.fQL.start();
            } else {
                rL(i2);
            }
        }
    }

    public void cancelDrag() {
        if (this.mDragState == 4) {
            this.fQm.lD(true);
            bGG();
            bGx();
            bGD();
            if (this.fQA) {
                this.mDragState = 3;
            } else {
                this.mDragState = 0;
            }
        }
    }

    private void bGx() {
        this.fQd = -1;
        this.fQa = -1;
        this.fQb = -1;
        this.fPZ = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGy() {
        this.mDragState = 2;
        if (this.fQh != null && this.fPZ >= 0 && this.fPZ < this.mListView.getCount()) {
            int headerViewsCount = this.mListView.getHeaderViewsCount();
            this.fQh.drop(this.fQd - headerViewsCount, this.fPZ - headerViewsCount);
        }
        bGG();
        bGA();
        bGx();
        bGD();
        if (this.fQA) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGz() {
        rL(this.fQd - this.mListView.getHeaderViewsCount());
    }

    private void rL(int i2) {
        this.mDragState = 1;
        if (this.fQi != null) {
            this.fQi.remove(i2);
        }
        bGG();
        bGA();
        bGx();
        if (this.fQA) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    private void bGA() {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        if (this.fQd < firstVisiblePosition) {
            View childAt = this.mListView.getChildAt(0);
            this.mListView.setSelectionFromTop(firstVisiblePosition - 1, (childAt != null ? childAt.getTop() : 0) - this.mListView.getPaddingTop());
        }
    }

    public boolean stopDrag(boolean z) {
        this.fQO = false;
        return stopDrag(z, 0.0f);
    }

    public boolean stopDragWithVelocity(boolean z, float f2) {
        this.fQO = true;
        return stopDrag(z, f2);
    }

    public boolean stopDrag(boolean z, float f2) {
        if (this.fPS != null) {
            this.fQm.lD(true);
            if (z) {
                removeItem(this.fQd - this.mListView.getHeaderViewsCount(), f2);
            } else if (this.fQN != null) {
                this.fQN.start();
            } else {
                bGy();
            }
            if (this.fQH) {
                this.fQI.stopTracking();
                return true;
            }
            return true;
        }
        return false;
    }

    private void bGB() {
        this.fQD = 0;
        this.fQA = false;
        if (this.mDragState == 3) {
            this.mDragState = 0;
        }
        this.fPY = this.fPX;
        this.fQS = false;
        this.fQK.clear();
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
        return this.fQS;
    }

    public void setDragScrollStart(float f2) {
        setDragScrollStarts(f2, f2);
    }

    public void setDragScrollStarts(float f2, float f3) {
        if (f3 > 0.5f) {
            this.fQo = 0.5f;
        } else {
            this.fQo = f3;
        }
        if (f2 > 0.5f) {
            this.fQn = 0.5f;
        } else {
            this.fQn = f2;
        }
        if (this.mListView.getHeight() != 0) {
            bGC();
        }
    }

    private void bi(int i2, int i3) {
        this.fPT.x = i2 - this.fQe;
        this.fPT.y = i3 - this.fQf;
        lC(true);
        int min = Math.min(i3, this.fPV + this.fQk);
        int max = Math.max(i3, this.fPV - this.fQk);
        int bGI = this.fQm.bGI();
        if (min > this.mLastY && min > this.fQq && bGI != 1) {
            if (bGI != -1) {
                this.fQm.lD(true);
            }
            this.fQm.rN(1);
        } else if (max < this.mLastY && max < this.fQp && bGI != 0) {
            if (bGI != -1) {
                this.fQm.lD(true);
            }
            this.fQm.rN(0);
        } else if (max >= this.fQp && min <= this.fQq && this.fQm.bGH()) {
            this.fQm.lD(true);
        }
    }

    private void bGC() {
        int height;
        int paddingTop = this.mListView.getPaddingTop();
        float height2 = (this.mListView.getHeight() - paddingTop) - this.mListView.getPaddingBottom();
        this.fQs = paddingTop + (this.fQn * height2);
        this.fQr = (height2 * (1.0f - this.fQo)) + paddingTop;
        this.fQp = (int) this.fQs;
        this.fQq = (int) this.fQr;
        this.fQt = this.fQs - paddingTop;
        this.fQu = (paddingTop + height) - this.fQr;
    }

    private void bGD() {
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
        if (i2 != this.fQd && i2 != this.fQa && i2 != this.fQb) {
            g2 = -2;
        } else {
            g2 = g(i2, view, z);
        }
        if (g2 != layoutParams.height) {
            layoutParams.height = g2;
            view.setLayoutParams(layoutParams);
        }
        if (i2 == this.fQa || i2 == this.fQb) {
            if (i2 < this.fQd) {
                ((DragSortItemView) view).setGravity(80);
            } else if (i2 > this.fQd) {
                ((DragSortItemView) view).setGravity(48);
            }
        }
        int visibility = view.getVisibility();
        int i3 = 0;
        if (i2 == this.fQd && this.fPS != null) {
            i3 = 4;
        }
        if (i3 != visibility) {
            view.setVisibility(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int rM(int i2) {
        View view;
        if (i2 == this.fQd) {
            return 0;
        }
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        if (childAt != null) {
            return f(i2, childAt, false);
        }
        int i3 = this.fQK.get(i2);
        if (i3 == -1) {
            ListAdapter adapter = this.mListView.getAdapter();
            int itemViewType = adapter.getItemViewType(i2);
            int viewTypeCount = adapter.getViewTypeCount();
            if (viewTypeCount != this.fQl.length) {
                this.fQl = new View[viewTypeCount];
            }
            if (itemViewType >= 0) {
                if (this.fQl[itemViewType] == null) {
                    view = adapter.getView(i2, null, this.mListView);
                    this.fQl[itemViewType] = view;
                } else {
                    view = adapter.getView(i2, this.fQl[itemViewType], this.mListView);
                }
            } else {
                view = adapter.getView(i2, null, this.mListView);
            }
            int f2 = f(i2, view, true);
            this.fQK.bk(i2, f2);
            return f2;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(int i2, View view, boolean z) {
        if (i2 == this.fQd) {
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
        boolean z = this.fQc && this.fQa != this.fQb;
        int i4 = this.dwl - this.fQj;
        int i5 = (int) (this.fQF * i4);
        if (i2 == this.fQd) {
            if (this.fQd == this.fQa) {
                if (z) {
                    return i5 + this.fQj;
                }
                return this.dwl;
            } else if (this.fQd == this.fQb) {
                return this.dwl - i5;
            } else {
                return this.fQj;
            }
        } else if (i2 == this.fQa) {
            if (z) {
                return i3 + i5;
            }
            return i3 + i4;
        } else if (i2 == this.fQb) {
            return (i3 + i4) - i5;
        } else {
            return i3;
        }
    }

    private int b(int i2, View view, int i3, int i4) {
        int i5;
        int i6;
        int rM = rM(i2);
        int height = view.getHeight();
        int bj = bj(i2, rM);
        if (i2 != this.fQd) {
            i6 = height - rM;
            i5 = bj - rM;
        } else {
            i5 = bj;
            i6 = height;
        }
        int i7 = this.dwl;
        if (this.fQd != this.fQa && this.fQd != this.fQb) {
            i7 -= this.fQj;
        }
        if (i2 <= i3) {
            if (i2 > this.fQa) {
                return (i7 - i5) + 0;
            }
        } else if (i2 == i4) {
            if (i2 <= this.fQa) {
                return (i6 - i7) + 0;
            }
            if (i2 == this.fQb) {
                return (height - bj) + 0;
            }
            return 0 + i6;
        } else if (i2 <= this.fQa) {
            return 0 - i7;
        } else {
            if (i2 == this.fQb) {
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

    private void bGE() {
        if (this.fPS != null) {
            measureItem(this.fPS);
            this.dwl = this.fPS.getMeasuredHeight();
            this.fQk = this.dwl / 2;
        }
    }

    protected boolean onDragTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        switch (motionEvent.getAction() & 255) {
            case 1:
                if (this.mDragState == 4) {
                    stopDrag(false);
                }
                bGB();
                return true;
            case 2:
                bi((int) motionEvent.getX(), (int) motionEvent.getY());
                return true;
            case 3:
                if (this.mDragState == 4) {
                    cancelDrag();
                }
                bGB();
                return true;
            default:
                return true;
        }
    }

    public boolean startDrag(int i2, int i3, int i4, int i5) {
        View rO;
        if (!this.fQA || this.fQB == null || (rO = this.fQB.rO(i2)) == null) {
            return false;
        }
        return startDrag(i2, rO, i3, i4, i5);
    }

    public boolean startDrag(int i2, View view, int i3, int i4, int i5) {
        if (this.mDragState == 0 && this.fQA && this.fPS == null && view != null && this.dQO) {
            if (this.mListView.getParent() != null) {
                this.mListView.getParent().requestDisallowInterceptTouchEvent(true);
            }
            int headerViewsCount = this.mListView.getHeaderViewsCount() + i2;
            this.fQa = headerViewsCount;
            this.fQb = headerViewsCount;
            this.fQd = headerViewsCount;
            this.fPZ = headerViewsCount;
            this.mDragState = 4;
            this.fQy = 0;
            this.fQy |= i3;
            this.fPS = view;
            bGE();
            this.fQe = i4;
            this.fQf = i5;
            this.fQx = this.mY;
            this.fPT.x = this.mX - this.fQe;
            this.fPT.y = this.mY - this.fQf;
            View childAt = this.mListView.getChildAt(this.fQd - this.mListView.getFirstVisiblePosition());
            if (childAt != null) {
                childAt.setVisibility(4);
            }
            if (this.fQH) {
                this.fQI.bGJ();
            }
            switch (this.fQD) {
                case 1:
                    this.fQQ.onTouchEvent(this.fQC);
                    break;
                case 2:
                    this.fQQ.onInterceptTouchEvent(this.fQC);
                    break;
            }
            this.mListView.requestLayout();
            if (this.fQM != null) {
                this.fQM.start();
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
        bGF();
        int i3 = this.fQa;
        int i4 = this.fQb;
        boolean bGw = bGw();
        if (bGw) {
            bGD();
            this.mListView.setSelectionFromTop(i2, (b(i2, view, i3, i4) + view.getTop()) - this.mListView.getPaddingTop());
            layoutChildren();
        }
        if (bGw || z) {
            this.mListView.invalidate();
        }
        this.mBlockLayoutRequests = false;
    }

    private void bGF() {
        if (this.fQB != null) {
            this.fPU.set(this.mX, this.mY);
            this.fQB.b(this.fPS, this.fPT, this.fPU);
        }
        int i2 = this.fPT.x;
        int i3 = this.fPT.y;
        int paddingLeft = this.mListView.getPaddingLeft();
        if ((this.fQy & 1) == 0 && i2 > paddingLeft) {
            this.fPT.x = paddingLeft;
        } else if ((this.fQy & 2) == 0 && i2 < paddingLeft) {
            this.fPT.x = paddingLeft;
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int lastVisiblePosition = this.mListView.getLastVisiblePosition();
        int paddingTop = this.mListView.getPaddingTop();
        if (firstVisiblePosition < headerViewsCount) {
            paddingTop = this.mListView.getChildAt((headerViewsCount - firstVisiblePosition) - 1).getBottom();
        }
        if ((this.fQy & 8) == 0 && firstVisiblePosition <= this.fQd) {
            paddingTop = Math.max(this.mListView.getChildAt(this.fQd - firstVisiblePosition).getTop(), paddingTop);
        }
        int height = this.mListView.getHeight() - this.mListView.getPaddingBottom();
        if (lastVisiblePosition >= (this.mListView.getCount() - footerViewsCount) - 1) {
            height = this.mListView.getChildAt(((this.mListView.getCount() - footerViewsCount) - 1) - firstVisiblePosition).getBottom();
        }
        if ((this.fQy & 4) == 0 && lastVisiblePosition >= this.fQd) {
            height = Math.min(this.mListView.getChildAt(this.fQd - firstVisiblePosition).getBottom(), height);
        }
        if (i3 < paddingTop) {
            this.fPT.y = paddingTop;
        } else if (this.dwl + i3 > height) {
            this.fPT.y = height - this.dwl;
        }
        this.fPV = this.fPT.y + this.fQk;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGG() {
        if (this.fPS != null) {
            this.fPS.setVisibility(8);
            if (this.fQB != null) {
                this.fQB.bW(this.fPS);
            }
            this.fPS = null;
            this.mListView.invalidate();
        }
    }

    public void a(h hVar) {
        this.fQB = hVar;
    }

    public void a(b bVar) {
        this.fQg = bVar;
    }

    public void setDragEnabled(boolean z) {
        this.dQO = z;
    }

    public boolean isDragEnabled() {
        return this.dQO;
    }

    public void a(g gVar) {
        this.fQh = gVar;
    }

    public void a(l lVar) {
        this.fQi = lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class i {
        private SparseIntArray fRn;
        private ArrayList<Integer> fRo;
        private int mMaxSize;

        public i(int i) {
            this.fRn = new SparseIntArray(i);
            this.fRo = new ArrayList<>(i);
            this.mMaxSize = i;
        }

        public void bk(int i, int i2) {
            int i3 = this.fRn.get(i, -1);
            if (i3 != i2) {
                if (i3 == -1) {
                    if (this.fRn.size() == this.mMaxSize) {
                        this.fRn.delete(this.fRo.remove(0).intValue());
                    }
                } else {
                    this.fRo.remove(Integer.valueOf(i));
                }
                this.fRn.put(i, i2);
                this.fRo.add(Integer.valueOf(i));
            }
        }

        public int get(int i) {
            return this.fRn.get(i, -1);
        }

        public void clear() {
            this.fRn.clear();
            this.fRo.clear();
        }
    }

    /* renamed from: com.baidu.tbadk.widget.dragsort.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0583a extends BaseAdapter {
        private ListAdapter mAdapter;

        public C0583a(ListAdapter listAdapter) {
            this.mAdapter = listAdapter;
            this.mAdapter.registerDataSetObserver(new DataSetObserver() { // from class: com.baidu.tbadk.widget.dragsort.a.a.1
                @Override // android.database.DataSetObserver
                public void onChanged() {
                    C0583a.this.notifyDataSetChanged();
                }

                @Override // android.database.DataSetObserver
                public void onInvalidated() {
                    C0583a.this.notifyDataSetInvalidated();
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
        private float cKp;
        private float cKq;
        private float cKr;
        private float cKs;
        private float fRy;
        private float mAlpha;
        private boolean mCanceled;
        protected long mStartTime;

        public m(float f, int i) {
            this.mAlpha = f;
            this.fRy = i;
            float f2 = 1.0f / ((this.mAlpha * 2.0f) * (1.0f - this.mAlpha));
            this.cKs = f2;
            this.cKp = f2;
            this.cKq = this.mAlpha / ((this.mAlpha - 1.0f) * 2.0f);
            this.cKr = 1.0f / (1.0f - this.mAlpha);
        }

        public float ar(float f) {
            if (f < this.mAlpha) {
                return this.cKp * f * f;
            }
            if (f < 1.0f - this.mAlpha) {
                return this.cKq + (this.cKr * f);
            }
            return 1.0f - ((this.cKs * (f - 1.0f)) * (f - 1.0f));
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
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / this.fRy;
                if (uptimeMillis >= 1.0f) {
                    y(1.0f, 1.0f);
                    onStop();
                    return;
                }
                y(uptimeMillis, ar(uptimeMillis));
                a.this.mListView.post(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class f extends m {
        private int fRj;
        private int fRk;
        private float fRl;
        private float fRm;

        public f(float f, int i) {
            super(f, i);
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.fRj = a.this.fPZ;
            this.fRk = a.this.fQd;
            a.this.mDragState = 2;
            this.fRl = a.this.fPT.y - bGL();
            this.fRm = a.this.fPT.x - a.this.mListView.getPaddingLeft();
        }

        private int bGL() {
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            int dividerHeight = (a.this.fQj + a.this.mListView.getDividerHeight()) / 2;
            View childAt = a.this.mListView.getChildAt(this.fRj - firstVisiblePosition);
            if (childAt != null) {
                if (this.fRj == this.fRk) {
                    return childAt.getTop();
                }
                if (this.fRj >= this.fRk) {
                    return (childAt.getBottom() + dividerHeight) - a.this.dwl;
                }
                return childAt.getTop() - dividerHeight;
            }
            cancel();
            return -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void y(float f, float f2) {
            int bGL = bGL();
            float paddingLeft = a.this.fPT.x - a.this.mListView.getPaddingLeft();
            float f3 = 1.0f - f2;
            if (f3 < Math.abs((a.this.fPT.y - bGL) / this.fRl) || f3 < Math.abs(paddingLeft / this.fRm)) {
                a.this.fPT.y = bGL + ((int) (this.fRl * f3));
                a.this.fPT.x = a.this.mListView.getPaddingLeft() + ((int) (this.fRm * f3));
                a.this.lC(true);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.bGy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class k extends m {
        private int fRk;
        private float fRr;
        private float fRs;
        private float fRt;
        private int fRu;
        private int fRv;
        private int fRw;
        private int fRx;

        public k(float f, int i) {
            super(f, i);
            this.fRu = -1;
            this.fRv = -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.fRu = -1;
            this.fRv = -1;
            this.fRw = a.this.fQa;
            this.fRx = a.this.fQb;
            this.fRk = a.this.fQd;
            a.this.mDragState = 1;
            this.fRr = a.this.fPT.x;
            if (a.this.fQO) {
                float width = a.this.mListView.getWidth() * 2.0f;
                if (a.this.fQP == 0.0f) {
                    a.this.fQP = (this.fRr >= 0.0f ? 1 : -1) * width;
                    return;
                }
                float f = width * 2.0f;
                if (a.this.fQP >= 0.0f || a.this.fQP <= (-f)) {
                    if (a.this.fQP > 0.0f && a.this.fQP < f) {
                        a.this.fQP = f;
                        return;
                    }
                    return;
                }
                a.this.fQP = -f;
                return;
            }
            a.this.bGG();
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void y(float f, float f2) {
            View childAt;
            float f3 = 1.0f - f2;
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            View childAt2 = a.this.mListView.getChildAt(this.fRw - firstVisiblePosition);
            if (a.this.fQO) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / 1000.0f;
                if (uptimeMillis != 0.0f) {
                    float f4 = a.this.fQP * uptimeMillis;
                    int width = a.this.mListView.getWidth();
                    a.this.fQP = ((a.this.fQP > 0.0f ? 1 : -1) * uptimeMillis * width) + a.this.fQP;
                    this.fRr += f4;
                    a.this.fPT.x = (int) this.fRr;
                    if (this.fRr < width && this.fRr > (-width)) {
                        this.mStartTime = SystemClock.uptimeMillis();
                        a.this.lC(true);
                        return;
                    }
                } else {
                    return;
                }
            }
            if (childAt2 != null) {
                if (this.fRu == -1) {
                    this.fRu = a.this.f(this.fRw, childAt2, false);
                    this.fRs = childAt2.getHeight() - this.fRu;
                }
                int max = Math.max((int) (this.fRs * f3), 1);
                ViewGroup.LayoutParams layoutParams = childAt2.getLayoutParams();
                layoutParams.height = max + this.fRu;
                childAt2.setLayoutParams(layoutParams);
            }
            if (this.fRx != this.fRw && (childAt = a.this.mListView.getChildAt(this.fRx - firstVisiblePosition)) != null) {
                if (this.fRv == -1) {
                    this.fRv = a.this.f(this.fRx, childAt, false);
                    this.fRt = childAt.getHeight() - this.fRv;
                }
                int max2 = Math.max((int) (this.fRt * f3), 1);
                ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
                layoutParams2.height = max2 + this.fRv;
                childAt.setLayoutParams(layoutParams2);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.bGz();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class j extends m {
        final /* synthetic */ a fQU;
        private float fRp;
        private float fRq;

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.fRp = this.fQU.fQf;
            this.fRq = this.fQU.fQk;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void y(float f, float f2) {
            if (this.fQU.mDragState != 4) {
                cancel();
                return;
            }
            this.fQU.fQf = (int) ((this.fRq * f2) + ((1.0f - f2) * this.fRp));
            this.fQU.fPT.y = this.fQU.mY - this.fQU.fQf;
            this.fQU.lC(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e {
        StringBuilder mBuilder = new StringBuilder();
        private int fRg = 0;
        private int fRh = 0;
        private boolean fRi = false;
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

        public void bGJ() {
            this.mBuilder.append("<DSLVStates>\n");
            this.fRh = 0;
            this.fRi = true;
        }

        public void bGK() {
            if (this.fRi) {
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
                this.mBuilder.append("    <FirstExpPos>").append(a.this.fQa).append("</FirstExpPos>\n");
                this.mBuilder.append("    <FirstExpBlankHeight>").append(a.this.rK(a.this.fQa) - a.this.rM(a.this.fQa)).append("</FirstExpBlankHeight>\n");
                this.mBuilder.append("    <SecondExpPos>").append(a.this.fQb).append("</SecondExpPos>\n");
                this.mBuilder.append("    <SecondExpBlankHeight>").append(a.this.rK(a.this.fQb) - a.this.rM(a.this.fQb)).append("</SecondExpBlankHeight>\n");
                this.mBuilder.append("    <SrcPos>").append(a.this.fQd).append("</SrcPos>\n");
                this.mBuilder.append("    <SrcHeight>").append(a.this.dwl + a.this.mListView.getDividerHeight()).append("</SrcHeight>\n");
                this.mBuilder.append("    <ViewHeight>").append(a.this.mListView.getHeight()).append("</ViewHeight>\n");
                this.mBuilder.append("    <LastY>").append(a.this.mLastY).append("</LastY>\n");
                this.mBuilder.append("    <FloatY>").append(a.this.fPV).append("</FloatY>\n");
                this.mBuilder.append("    <ShuffleEdges>");
                for (int i4 = 0; i4 < childCount; i4++) {
                    this.mBuilder.append(a.this.bh(firstVisiblePosition + i4, a.this.mListView.getChildAt(i4).getTop())).append(",");
                }
                this.mBuilder.append("</ShuffleEdges>\n");
                this.mBuilder.append("</DSLVState>\n");
                this.fRg++;
                if (this.fRg > 1000) {
                    flush();
                    this.fRg = 0;
                }
            }
        }

        public void flush() {
            if (this.fRi) {
                try {
                    FileWriter fileWriter = new FileWriter(this.mFile, this.fRh != 0);
                    fileWriter.write(this.mBuilder.toString());
                    this.mBuilder.delete(0, this.mBuilder.length());
                    fileWriter.flush();
                    fileWriter.close();
                    this.fRh++;
                } catch (IOException e) {
                }
            }
        }

        public void stopTracking() {
            if (this.fRi) {
                this.mBuilder.append("</DSLVStates>\n");
                flush();
                this.fRi = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements Runnable {
        private boolean fQX;
        private long fQY;
        private long fQZ;
        private int fRa;
        private float fRb;
        private long fRc;
        private int fRd;
        private float fRe;
        private boolean fRf = false;

        public boolean bGH() {
            return this.fRf;
        }

        public int bGI() {
            if (this.fRf) {
                return this.fRd;
            }
            return -1;
        }

        public d() {
        }

        public void rN(int i) {
            if (!this.fRf) {
                this.fQX = false;
                this.fRf = true;
                this.fRc = SystemClock.uptimeMillis();
                this.fQY = this.fRc;
                this.fRd = i;
                a.this.mListView.post(this);
            }
        }

        public void lD(boolean z) {
            if (z) {
                a.this.mListView.removeCallbacks(this);
                this.fRf = false;
                return;
            }
            this.fQX = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.fQX) {
                int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
                int lastVisiblePosition = a.this.mListView.getLastVisiblePosition();
                int count = a.this.mListView.getCount();
                int paddingTop = a.this.mListView.getPaddingTop();
                int height = (a.this.mListView.getHeight() - paddingTop) - a.this.mListView.getPaddingBottom();
                int min = Math.min(a.this.mY, a.this.fPV + a.this.fQk);
                int max = Math.max(a.this.mY, a.this.fPV - a.this.fQk);
                if (this.fRd == 0) {
                    View childAt = a.this.mListView.getChildAt(0);
                    if (childAt == null) {
                        this.fRf = false;
                        return;
                    } else if (firstVisiblePosition == 0 && childAt.getTop() == paddingTop) {
                        this.fRf = false;
                        return;
                    } else {
                        this.fRe = a.this.fQw.b((a.this.fQs - max) / a.this.fQt, this.fQY);
                    }
                } else {
                    View childAt2 = a.this.mListView.getChildAt(lastVisiblePosition - firstVisiblePosition);
                    if (childAt2 == null) {
                        this.fRf = false;
                        return;
                    } else if (lastVisiblePosition == count - 1 && childAt2.getBottom() <= height + paddingTop) {
                        this.fRf = false;
                        return;
                    } else {
                        this.fRe = -a.this.fQw.b((min - a.this.fQr) / a.this.fQu, this.fQY);
                    }
                }
                this.fQZ = SystemClock.uptimeMillis();
                this.fRb = (float) (this.fQZ - this.fQY);
                this.fRa = Math.round(this.fRe * this.fRb);
                if (this.fRa >= 0) {
                    this.fRa = Math.min(height, this.fRa);
                    lastVisiblePosition = firstVisiblePosition;
                } else {
                    this.fRa = Math.max(-height, this.fRa);
                }
                View childAt3 = a.this.mListView.getChildAt(lastVisiblePosition - firstVisiblePosition);
                int top = childAt3.getTop() + this.fRa;
                if (lastVisiblePosition == 0 && top > paddingTop) {
                    top = paddingTop;
                }
                a.this.mBlockLayoutRequests = true;
                a.this.mListView.setSelectionFromTop(lastVisiblePosition, top - paddingTop);
                a.this.layoutChildren();
                a.this.mListView.invalidate();
                a.this.mBlockLayoutRequests = false;
                a.this.h(lastVisiblePosition, childAt3, false);
                this.fQY = this.fQZ;
                a.this.mListView.post(this);
                return;
            }
            this.fRf = false;
        }
    }
}
