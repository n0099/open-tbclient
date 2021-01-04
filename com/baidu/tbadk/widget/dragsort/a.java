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
    private int cMO;
    private int cMP;
    private int cMr;
    private int cMs;
    private int dyN;
    private b fSA;
    private g fSB;
    private l fSC;
    private int fSE;
    private d fSG;
    private int fSJ;
    private int fSK;
    private float fSL;
    private float fSM;
    private float fSN;
    private float fSO;
    private int fSR;
    private MotionEvent fSW;
    private View fSm;
    private int fSp;
    private int fSt;
    private int fSu;
    private int fSv;
    private int fSx;
    private int fSy;
    private int fSz;
    private C0603a fTa;
    private e fTc;
    private k fTf;
    private j fTg;
    private f fTh;
    private boolean fTi;
    private com.baidu.tbadk.widget.dragsort.d fTk;
    private com.baidu.tbadk.widget.dragsort.b fTl;
    private int mLastX;
    private int mLastY;
    private ListView mListView;
    private DataSetObserver mObserver;
    private Point fSn = new Point();
    private Point fSo = new Point();
    private boolean fSq = false;
    private float fSr = 1.0f;
    private float fSs = 1.0f;
    private boolean fSw = false;
    private boolean dTu = true;
    private int mDragState = 0;
    private int fSD = 1;
    private int mWidthMeasureSpec = 0;
    private View[] fSF = new View[1];
    private float fSH = 0.33333334f;
    private float fSI = 0.33333334f;
    private float fSP = 0.5f;
    private c fSQ = new c() { // from class: com.baidu.tbadk.widget.dragsort.a.1
        @Override // com.baidu.tbadk.widget.dragsort.a.c
        public float b(float f2, long j2) {
            return a.this.fSP * f2;
        }
    };
    private int fSS = 0;
    private boolean fST = false;
    private boolean fSU = false;
    private h fSV = null;
    private int fSX = 0;
    private float fSY = 0.25f;
    private float fSZ = 0.0f;
    private boolean fTb = false;
    private boolean mBlockLayoutRequests = false;
    private boolean fTd = false;
    private i fTe = new i(3);
    private float fTj = 0.0f;
    private boolean fTm = false;
    private boolean fTn = false;

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

        void ca(View view);

        View tp(int i);
    }

    /* loaded from: classes.dex */
    public interface l {
        void remove(int i);
    }

    public a(ListView listView, com.baidu.tbadk.widget.dragsort.d dVar) {
        this.fTk = dVar;
        this.mListView = listView;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            this.fTa = new C0603a(listAdapter);
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
            this.fTa = null;
        }
        this.fTk.setAdapter(this.fTa);
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
            if (i2 > this.fSx) {
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
    public int tl(int i2) {
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        return childAt != null ? childAt.getHeight() : bm(i2, tn(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bk(int i2, int i3) {
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        if (i2 <= headerViewsCount || i2 >= this.mListView.getCount() - footerViewsCount) {
            return i3;
        }
        int dividerHeight = this.mListView.getDividerHeight();
        int i4 = this.dyN - this.fSD;
        int tn = tn(i2);
        int tl = tl(i2);
        if (this.fSv <= this.fSx) {
            if (i2 == this.fSv && this.fSu != this.fSv) {
                if (i2 == this.fSx) {
                    i3 = (i3 + tl) - this.dyN;
                } else {
                    i3 = ((tl - tn) + i3) - i4;
                }
            } else if (i2 > this.fSv && i2 <= this.fSx) {
                i3 -= i4;
            }
        } else if (i2 > this.fSx && i2 <= this.fSu) {
            i3 += i4;
        } else if (i2 == this.fSv && this.fSu != this.fSv) {
            i3 += tl - tn;
        }
        if (i2 <= this.fSx) {
            return (((this.dyN - dividerHeight) - tn(i2 - 1)) / 2) + i3;
        }
        return (((tn - dividerHeight) - this.dyN) / 2) + i3;
    }

    private boolean bJT() {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int i9 = this.fSu;
        View childAt = this.mListView.getChildAt(i9 - firstVisiblePosition);
        if (childAt == null) {
            i9 = firstVisiblePosition + (this.mListView.getChildCount() / 2);
            childAt = this.mListView.getChildAt(i9 - firstVisiblePosition);
        }
        int top = childAt.getTop();
        int height = childAt.getHeight();
        int bk = bk(i9, top);
        int dividerHeight = this.mListView.getDividerHeight();
        if (this.fSp < bk) {
            int i10 = top;
            i2 = i9;
            i3 = bk;
            i4 = bk;
            while (i2 >= 0) {
                i2--;
                int tl = tl(i2);
                if (i2 == 0) {
                    i5 = (i10 - dividerHeight) - tl;
                    i6 = i3;
                    break;
                }
                int i11 = i10 - (tl + dividerHeight);
                i5 = bk(i2, i11);
                if (this.fSp >= i5) {
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
            i3 = bk;
            i4 = bk;
            while (i2 < count) {
                if (i2 == count - 1) {
                    i5 = i12 + dividerHeight + height;
                    i6 = i3;
                    break;
                }
                int i13 = dividerHeight + height + i12;
                int tl2 = tl(i2 + 1);
                i5 = bk(i2 + 1, i13);
                if (this.fSp < i5) {
                    i6 = i3;
                    break;
                }
                i2++;
                i12 = i13;
                i3 = i5;
                i4 = i5;
                height = tl2;
            }
            i6 = i3;
            i5 = i4;
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int i14 = this.fSu;
        int i15 = this.fSv;
        float f2 = this.fSZ;
        if (this.fSw) {
            int abs = Math.abs(i5 - i6);
            if (this.fSp < i5) {
                i7 = i5;
                i8 = i6;
            } else {
                i7 = i6;
                i8 = i5;
            }
            int i16 = (int) (this.fSY * 0.5f * abs);
            float f3 = i16;
            int i17 = i8 + i16;
            int i18 = i7 - i16;
            if (this.fSp < i17) {
                this.fSu = i2 - 1;
                this.fSv = i2;
                this.fSZ = ((i17 - this.fSp) * 0.5f) / f3;
            } else if (this.fSp < i18) {
                this.fSu = i2;
                this.fSv = i2;
            } else {
                this.fSu = i2;
                this.fSv = i2 + 1;
                this.fSZ = (1.0f + ((i7 - this.fSp) / f3)) * 0.5f;
            }
        } else {
            this.fSu = i2;
            this.fSv = i2;
        }
        if (this.fSu < headerViewsCount) {
            this.fSu = headerViewsCount;
            this.fSv = headerViewsCount;
            i2 = headerViewsCount;
        } else if (this.fSv >= this.mListView.getCount() - footerViewsCount) {
            i2 = (this.mListView.getCount() - footerViewsCount) - 1;
            this.fSu = i2;
            this.fSv = i2;
        }
        boolean z = (this.fSu == i14 && this.fSv == i15 && this.fSZ == f2) ? false : true;
        if (i2 != this.fSt) {
            if (this.fSA != null) {
                this.fSA.drag(this.fSt - headerViewsCount, i2 - headerViewsCount);
            }
            this.fSt = i2;
            return true;
        }
        return z;
    }

    public void removeItem(int i2) {
        this.fTi = false;
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
            this.fSD = Math.max(1, obtainStyledAttributes.getDimensionPixelSize(R.styleable.DragSort_collapsed_height, 1));
            this.fTb = obtainStyledAttributes.getBoolean(R.styleable.DragSort_track_drag_sort, false);
            if (this.fTb) {
                this.fTc = new e();
            }
            this.fSr = obtainStyledAttributes.getFloat(R.styleable.DragSort_float_alpha, this.fSr);
            this.fSs = this.fSr;
            this.dTu = obtainStyledAttributes.getBoolean(R.styleable.DragSort_drag_enabled, this.dTu);
            this.fSY = Math.max(0.0f, Math.min(1.0f, 1.0f - obtainStyledAttributes.getFloat(R.styleable.DragSort_slide_shuffle_speed, 0.75f)));
            this.fSw = this.fSY > 0.0f;
            setDragScrollStart(obtainStyledAttributes.getFloat(R.styleable.DragSort_drag_scroll_start, this.fSH));
            this.fSP = obtainStyledAttributes.getFloat(R.styleable.DragSort_max_drag_scroll_speed, this.fSP);
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
                bVar.lG(z);
                bVar.lF(z2);
                bVar.setBackgroundColor(color);
                this.fSV = bVar;
                a(bVar);
            }
            obtainStyledAttributes.recycle();
            i2 = i5;
            i3 = i4;
        }
        this.fSG = new d();
        if (i3 > 0) {
            this.fTf = new k(0.5f, i3);
        }
        if (i2 > 0) {
            this.fTh = new f(0.5f, i2);
        }
        this.fSW = MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
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
        this.fTl = bVar;
        this.mListView.setOnTouchListener(bVar);
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void dispatchDraw(Canvas canvas) {
        float f2;
        this.fTk.dispatchDraw(canvas);
        if (this.mDragState != 0) {
            if (this.fSu != this.fSx) {
                c(this.fSu, canvas);
            }
            if (this.fSv != this.fSu && this.fSv != this.fSx) {
                c(this.fSv, canvas);
            }
        }
        if (this.fSm != null) {
            int width = this.fSm.getWidth();
            int height = this.fSm.getHeight();
            int i2 = this.fSn.x;
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
            int i3 = (int) (f2 * 255.0f * this.fSs);
            canvas.save();
            canvas.translate(this.fSn.x, this.fSn.y);
            canvas.clipRect(0, 0, width, height);
            canvas.saveLayerAlpha(0.0f, 0.0f, width, height, i3, 31);
            this.fSm.draw(canvas);
            canvas.restore();
            canvas.restore();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onDraw(Canvas canvas) {
        this.fTk.onDraw(canvas);
        if (this.fTb) {
            this.fTc.bKh();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.fTd) {
            this.fTd = false;
            return false;
        } else if (!this.dTu) {
            return this.fTk.onTouchEvent(motionEvent);
        } else {
            boolean z2 = this.fST;
            this.fST = false;
            if (!z2) {
                G(motionEvent);
            }
            if (this.mDragState == 4) {
                onDragTouchEvent(motionEvent);
                return true;
            }
            if (this.mDragState == 0 && this.fTk.onTouchEvent(motionEvent)) {
                z = true;
            }
            switch (motionEvent.getAction() & 255) {
                case 1:
                case 3:
                    bJY();
                    return z;
                case 2:
                default:
                    if (z) {
                        this.fSX = 1;
                        return z;
                    }
                    return z;
            }
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (!this.dTu) {
            return this.fTk.onInterceptTouchEvent(motionEvent);
        }
        if (this.fTl != null) {
            this.fTl.bKj().onTouchEvent(motionEvent);
        }
        G(motionEvent);
        this.fST = true;
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            if (this.mDragState != 0) {
                this.fTd = true;
                return true;
            }
            this.fSU = true;
        }
        if (this.fSm == null) {
            if (this.fTk.onInterceptTouchEvent(motionEvent)) {
                this.fTm = true;
                z = true;
            } else {
                z = false;
            }
            switch (action) {
                case 1:
                case 3:
                    bJY();
                    break;
                case 2:
                default:
                    if (z) {
                        this.fSX = 1;
                        break;
                    } else {
                        this.fSX = 2;
                        break;
                    }
            }
        } else {
            z = true;
        }
        if (action == 1 || action == 3) {
            this.fSU = false;
        }
        return z;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        this.fTk.onSizeChanged(i2, i3, i4, i5);
        bJZ();
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void requestLayout() {
        if (!this.mBlockLayoutRequests) {
            this.fTk.requestLayout();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onMeasure(int i2, int i3) {
        this.fTk.onMeasure(i2, i3);
        if (this.fSm != null) {
            if (this.fSm.isLayoutRequested()) {
                bKb();
            }
            this.fSq = true;
        }
        this.mWidthMeasureSpec = i2;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void layoutChildren() {
        this.fTk.layoutChildren();
        if (this.fSm != null) {
            if (this.fSm.isLayoutRequested() && !this.fSq) {
                bKb();
            }
            this.fSm.layout(0, 0, this.fSm.getMeasuredWidth(), this.fSm.getMeasuredHeight());
            this.fSq = false;
        }
    }

    public void removeItem(int i2, float f2) {
        if (this.mDragState == 0 || this.mDragState == 4) {
            if (this.mDragState == 0) {
                this.fSx = this.mListView.getHeaderViewsCount() + i2;
                this.fSu = this.fSx;
                this.fSv = this.fSx;
                this.fSt = this.fSx;
                View childAt = this.mListView.getChildAt(this.fSx - this.mListView.getFirstVisiblePosition());
                if (childAt != null) {
                    childAt.setVisibility(4);
                }
            }
            this.mDragState = 1;
            this.fTj = f2;
            if (this.fSU) {
                switch (this.fSX) {
                    case 1:
                        this.fTk.onTouchEvent(this.fSW);
                        break;
                    case 2:
                        this.fTk.onInterceptTouchEvent(this.fSW);
                        break;
                }
            }
            if (this.fTf != null) {
                this.fTf.start();
            } else {
                tm(i2);
            }
        }
    }

    public void cancelDrag() {
        if (this.mDragState == 4) {
            this.fSG.lE(true);
            bKd();
            bJU();
            bKa();
            if (this.fSU) {
                this.mDragState = 3;
            } else {
                this.mDragState = 0;
            }
        }
    }

    private void bJU() {
        this.fSx = -1;
        this.fSu = -1;
        this.fSv = -1;
        this.fSt = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJV() {
        this.mDragState = 2;
        if (this.fSB != null && this.fSt >= 0 && this.fSt < this.mListView.getCount()) {
            int headerViewsCount = this.mListView.getHeaderViewsCount();
            this.fSB.drop(this.fSx - headerViewsCount, this.fSt - headerViewsCount);
        }
        bKd();
        bJX();
        bJU();
        bKa();
        if (this.fSU) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJW() {
        tm(this.fSx - this.mListView.getHeaderViewsCount());
    }

    private void tm(int i2) {
        this.mDragState = 1;
        if (this.fSC != null) {
            this.fSC.remove(i2);
        }
        bKd();
        bJX();
        bJU();
        if (this.fSU) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    private void bJX() {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        if (this.fSx < firstVisiblePosition) {
            View childAt = this.mListView.getChildAt(0);
            this.mListView.setSelectionFromTop(firstVisiblePosition - 1, (childAt != null ? childAt.getTop() : 0) - this.mListView.getPaddingTop());
        }
    }

    public boolean stopDrag(boolean z) {
        this.fTi = false;
        return stopDrag(z, 0.0f);
    }

    public boolean stopDragWithVelocity(boolean z, float f2) {
        this.fTi = true;
        return stopDrag(z, f2);
    }

    public boolean stopDrag(boolean z, float f2) {
        if (this.fSm != null) {
            this.fSG.lE(true);
            if (z) {
                removeItem(this.fSx - this.mListView.getHeaderViewsCount(), f2);
            } else if (this.fTh != null) {
                this.fTh.start();
            } else {
                bJV();
            }
            if (this.fTb) {
                this.fTc.stopTracking();
                return true;
            }
            return true;
        }
        return false;
    }

    private void bJY() {
        this.fSX = 0;
        this.fSU = false;
        if (this.mDragState == 3) {
            this.mDragState = 0;
        }
        this.fSs = this.fSr;
        this.fTm = false;
        this.fTe.clear();
    }

    private void G(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            this.mLastX = this.cMr;
            this.mLastY = this.cMs;
        }
        this.cMr = (int) motionEvent.getX();
        this.cMs = (int) motionEvent.getY();
        if (action == 0) {
            this.mLastX = this.cMr;
            this.mLastY = this.cMs;
        }
        this.cMO = ((int) motionEvent.getRawX()) - this.cMr;
        this.cMP = ((int) motionEvent.getRawY()) - this.cMs;
    }

    public boolean listViewIntercepted() {
        return this.fTm;
    }

    public void setDragScrollStart(float f2) {
        setDragScrollStarts(f2, f2);
    }

    public void setDragScrollStarts(float f2, float f3) {
        if (f3 > 0.5f) {
            this.fSI = 0.5f;
        } else {
            this.fSI = f3;
        }
        if (f2 > 0.5f) {
            this.fSH = 0.5f;
        } else {
            this.fSH = f2;
        }
        if (this.mListView.getHeight() != 0) {
            bJZ();
        }
    }

    private void bl(int i2, int i3) {
        this.fSn.x = i2 - this.fSy;
        this.fSn.y = i3 - this.fSz;
        lD(true);
        int min = Math.min(i3, this.fSp + this.fSE);
        int max = Math.max(i3, this.fSp - this.fSE);
        int bKf = this.fSG.bKf();
        if (min > this.mLastY && min > this.fSK && bKf != 1) {
            if (bKf != -1) {
                this.fSG.lE(true);
            }
            this.fSG.to(1);
        } else if (max < this.mLastY && max < this.fSJ && bKf != 0) {
            if (bKf != -1) {
                this.fSG.lE(true);
            }
            this.fSG.to(0);
        } else if (max >= this.fSJ && min <= this.fSK && this.fSG.bKe()) {
            this.fSG.lE(true);
        }
    }

    private void bJZ() {
        int height;
        int paddingTop = this.mListView.getPaddingTop();
        float height2 = (this.mListView.getHeight() - paddingTop) - this.mListView.getPaddingBottom();
        this.fSM = paddingTop + (this.fSH * height2);
        this.fSL = (height2 * (1.0f - this.fSI)) + paddingTop;
        this.fSJ = (int) this.fSM;
        this.fSK = (int) this.fSL;
        this.fSN = this.fSM - paddingTop;
        this.fSO = (paddingTop + height) - this.fSL;
    }

    private void bKa() {
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
        if (i2 != this.fSx && i2 != this.fSu && i2 != this.fSv) {
            g2 = -2;
        } else {
            g2 = g(i2, view, z);
        }
        if (g2 != layoutParams.height) {
            layoutParams.height = g2;
            view.setLayoutParams(layoutParams);
        }
        if (i2 == this.fSu || i2 == this.fSv) {
            if (i2 < this.fSx) {
                ((DragSortItemView) view).setGravity(80);
            } else if (i2 > this.fSx) {
                ((DragSortItemView) view).setGravity(48);
            }
        }
        int visibility = view.getVisibility();
        int i3 = 0;
        if (i2 == this.fSx && this.fSm != null) {
            i3 = 4;
        }
        if (i3 != visibility) {
            view.setVisibility(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int tn(int i2) {
        View view;
        if (i2 == this.fSx) {
            return 0;
        }
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        if (childAt != null) {
            return f(i2, childAt, false);
        }
        int i3 = this.fTe.get(i2);
        if (i3 == -1) {
            ListAdapter adapter = this.mListView.getAdapter();
            int itemViewType = adapter.getItemViewType(i2);
            int viewTypeCount = adapter.getViewTypeCount();
            if (viewTypeCount != this.fSF.length) {
                this.fSF = new View[viewTypeCount];
            }
            if (itemViewType >= 0) {
                if (this.fSF[itemViewType] == null) {
                    view = adapter.getView(i2, null, this.mListView);
                    this.fSF[itemViewType] = view;
                } else {
                    view = adapter.getView(i2, this.fSF[itemViewType], this.mListView);
                }
            } else {
                view = adapter.getView(i2, null, this.mListView);
            }
            int f2 = f(i2, view, true);
            this.fTe.bn(i2, f2);
            return f2;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(int i2, View view, boolean z) {
        if (i2 == this.fSx) {
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
        return bm(i2, f(i2, view, z));
    }

    private int bm(int i2, int i3) {
        this.mListView.getDividerHeight();
        boolean z = this.fSw && this.fSu != this.fSv;
        int i4 = this.dyN - this.fSD;
        int i5 = (int) (this.fSZ * i4);
        if (i2 == this.fSx) {
            if (this.fSx == this.fSu) {
                if (z) {
                    return i5 + this.fSD;
                }
                return this.dyN;
            } else if (this.fSx == this.fSv) {
                return this.dyN - i5;
            } else {
                return this.fSD;
            }
        } else if (i2 == this.fSu) {
            if (z) {
                return i3 + i5;
            }
            return i3 + i4;
        } else if (i2 == this.fSv) {
            return (i3 + i4) - i5;
        } else {
            return i3;
        }
    }

    private int b(int i2, View view, int i3, int i4) {
        int i5;
        int i6;
        int tn = tn(i2);
        int height = view.getHeight();
        int bm = bm(i2, tn);
        if (i2 != this.fSx) {
            i6 = height - tn;
            i5 = bm - tn;
        } else {
            i5 = bm;
            i6 = height;
        }
        int i7 = this.dyN;
        if (this.fSx != this.fSu && this.fSx != this.fSv) {
            i7 -= this.fSD;
        }
        if (i2 <= i3) {
            if (i2 > this.fSu) {
                return (i7 - i5) + 0;
            }
        } else if (i2 == i4) {
            if (i2 <= this.fSu) {
                return (i6 - i7) + 0;
            }
            if (i2 == this.fSv) {
                return (height - bm) + 0;
            }
            return 0 + i6;
        } else if (i2 <= this.fSu) {
            return 0 - i7;
        } else {
            if (i2 == this.fSv) {
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

    private void bKb() {
        if (this.fSm != null) {
            measureItem(this.fSm);
            this.dyN = this.fSm.getMeasuredHeight();
            this.fSE = this.dyN / 2;
        }
    }

    protected boolean onDragTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        switch (motionEvent.getAction() & 255) {
            case 1:
                if (this.mDragState == 4) {
                    stopDrag(false);
                }
                bJY();
                return true;
            case 2:
                bl((int) motionEvent.getX(), (int) motionEvent.getY());
                return true;
            case 3:
                if (this.mDragState == 4) {
                    cancelDrag();
                }
                bJY();
                return true;
            default:
                return true;
        }
    }

    public boolean startDrag(int i2, int i3, int i4, int i5) {
        View tp;
        if (!this.fSU || this.fSV == null || (tp = this.fSV.tp(i2)) == null) {
            return false;
        }
        return startDrag(i2, tp, i3, i4, i5);
    }

    public boolean startDrag(int i2, View view, int i3, int i4, int i5) {
        if (this.mDragState == 0 && this.fSU && this.fSm == null && view != null && this.dTu) {
            if (this.mListView.getParent() != null) {
                this.mListView.getParent().requestDisallowInterceptTouchEvent(true);
            }
            int headerViewsCount = this.mListView.getHeaderViewsCount() + i2;
            this.fSu = headerViewsCount;
            this.fSv = headerViewsCount;
            this.fSx = headerViewsCount;
            this.fSt = headerViewsCount;
            this.mDragState = 4;
            this.fSS = 0;
            this.fSS |= i3;
            this.fSm = view;
            bKb();
            this.fSy = i4;
            this.fSz = i5;
            this.fSR = this.cMs;
            this.fSn.x = this.cMr - this.fSy;
            this.fSn.y = this.cMs - this.fSz;
            View childAt = this.mListView.getChildAt(this.fSx - this.mListView.getFirstVisiblePosition());
            if (childAt != null) {
                childAt.setVisibility(4);
            }
            if (this.fTb) {
                this.fTc.bKg();
            }
            switch (this.fSX) {
                case 1:
                    this.fTk.onTouchEvent(this.fSW);
                    break;
                case 2:
                    this.fTk.onInterceptTouchEvent(this.fSW);
                    break;
            }
            this.mListView.requestLayout();
            if (this.fTg != null) {
                this.fTg.start();
                return true;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lD(boolean z) {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition() + (this.mListView.getChildCount() / 2);
        View childAt = this.mListView.getChildAt(this.mListView.getChildCount() / 2);
        if (childAt != null) {
            h(firstVisiblePosition, childAt, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i2, View view, boolean z) {
        this.mBlockLayoutRequests = true;
        bKc();
        int i3 = this.fSu;
        int i4 = this.fSv;
        boolean bJT = bJT();
        if (bJT) {
            bKa();
            this.mListView.setSelectionFromTop(i2, (b(i2, view, i3, i4) + view.getTop()) - this.mListView.getPaddingTop());
            layoutChildren();
        }
        if (bJT || z) {
            this.mListView.invalidate();
        }
        this.mBlockLayoutRequests = false;
    }

    private void bKc() {
        if (this.fSV != null) {
            this.fSo.set(this.cMr, this.cMs);
            this.fSV.b(this.fSm, this.fSn, this.fSo);
        }
        int i2 = this.fSn.x;
        int i3 = this.fSn.y;
        int paddingLeft = this.mListView.getPaddingLeft();
        if ((this.fSS & 1) == 0 && i2 > paddingLeft) {
            this.fSn.x = paddingLeft;
        } else if ((this.fSS & 2) == 0 && i2 < paddingLeft) {
            this.fSn.x = paddingLeft;
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int lastVisiblePosition = this.mListView.getLastVisiblePosition();
        int paddingTop = this.mListView.getPaddingTop();
        if (firstVisiblePosition < headerViewsCount) {
            paddingTop = this.mListView.getChildAt((headerViewsCount - firstVisiblePosition) - 1).getBottom();
        }
        if ((this.fSS & 8) == 0 && firstVisiblePosition <= this.fSx) {
            paddingTop = Math.max(this.mListView.getChildAt(this.fSx - firstVisiblePosition).getTop(), paddingTop);
        }
        int height = this.mListView.getHeight() - this.mListView.getPaddingBottom();
        if (lastVisiblePosition >= (this.mListView.getCount() - footerViewsCount) - 1) {
            height = this.mListView.getChildAt(((this.mListView.getCount() - footerViewsCount) - 1) - firstVisiblePosition).getBottom();
        }
        if ((this.fSS & 4) == 0 && lastVisiblePosition >= this.fSx) {
            height = Math.min(this.mListView.getChildAt(this.fSx - firstVisiblePosition).getBottom(), height);
        }
        if (i3 < paddingTop) {
            this.fSn.y = paddingTop;
        } else if (this.dyN + i3 > height) {
            this.fSn.y = height - this.dyN;
        }
        this.fSp = this.fSn.y + this.fSE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKd() {
        if (this.fSm != null) {
            this.fSm.setVisibility(8);
            if (this.fSV != null) {
                this.fSV.ca(this.fSm);
            }
            this.fSm = null;
            this.mListView.invalidate();
        }
    }

    public void a(h hVar) {
        this.fSV = hVar;
    }

    public void a(b bVar) {
        this.fSA = bVar;
    }

    public void setDragEnabled(boolean z) {
        this.dTu = z;
    }

    public boolean isDragEnabled() {
        return this.dTu;
    }

    public void a(g gVar) {
        this.fSB = gVar;
    }

    public void a(l lVar) {
        this.fSC = lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class i {
        private SparseIntArray fTH;
        private ArrayList<Integer> fTI;
        private int mMaxSize;

        public i(int i) {
            this.fTH = new SparseIntArray(i);
            this.fTI = new ArrayList<>(i);
            this.mMaxSize = i;
        }

        public void bn(int i, int i2) {
            int i3 = this.fTH.get(i, -1);
            if (i3 != i2) {
                if (i3 == -1) {
                    if (this.fTH.size() == this.mMaxSize) {
                        this.fTH.delete(this.fTI.remove(0).intValue());
                    }
                } else {
                    this.fTI.remove(Integer.valueOf(i));
                }
                this.fTH.put(i, i2);
                this.fTI.add(Integer.valueOf(i));
            }
        }

        public int get(int i) {
            return this.fTH.get(i, -1);
        }

        public void clear() {
            this.fTH.clear();
            this.fTI.clear();
        }
    }

    /* renamed from: com.baidu.tbadk.widget.dragsort.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0603a extends BaseAdapter {
        private ListAdapter mAdapter;

        public C0603a(ListAdapter listAdapter) {
            this.mAdapter = listAdapter;
            this.mAdapter.registerDataSetObserver(new DataSetObserver() { // from class: com.baidu.tbadk.widget.dragsort.a.a.1
                @Override // android.database.DataSetObserver
                public void onChanged() {
                    C0603a.this.notifyDataSetChanged();
                }

                @Override // android.database.DataSetObserver
                public void onInvalidated() {
                    C0603a.this.notifyDataSetInvalidated();
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
        private float cMJ;
        private float cMK;
        private float cML;
        private float cMM;
        private float fTS;
        private float mAlpha;
        private boolean mCanceled;
        protected long mStartTime;

        public m(float f, int i) {
            this.mAlpha = f;
            this.fTS = i;
            float f2 = 1.0f / ((this.mAlpha * 2.0f) * (1.0f - this.mAlpha));
            this.cMM = f2;
            this.cMJ = f2;
            this.cMK = this.mAlpha / ((this.mAlpha - 1.0f) * 2.0f);
            this.cML = 1.0f / (1.0f - this.mAlpha);
        }

        public float aq(float f) {
            if (f < this.mAlpha) {
                return this.cMJ * f * f;
            }
            if (f < 1.0f - this.mAlpha) {
                return this.cMK + (this.cML * f);
            }
            return 1.0f - ((this.cMM * (f - 1.0f)) * (f - 1.0f));
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

        public void x(float f, float f2) {
        }

        public void onStop() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.mCanceled) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / this.fTS;
                if (uptimeMillis >= 1.0f) {
                    x(1.0f, 1.0f);
                    onStop();
                    return;
                }
                x(uptimeMillis, aq(uptimeMillis));
                a.this.mListView.post(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class f extends m {
        private int fTD;
        private int fTE;
        private float fTF;
        private float fTG;

        public f(float f, int i) {
            super(f, i);
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.fTD = a.this.fSt;
            this.fTE = a.this.fSx;
            a.this.mDragState = 2;
            this.fTF = a.this.fSn.y - bKi();
            this.fTG = a.this.fSn.x - a.this.mListView.getPaddingLeft();
        }

        private int bKi() {
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            int dividerHeight = (a.this.fSD + a.this.mListView.getDividerHeight()) / 2;
            View childAt = a.this.mListView.getChildAt(this.fTD - firstVisiblePosition);
            if (childAt != null) {
                if (this.fTD == this.fTE) {
                    return childAt.getTop();
                }
                if (this.fTD >= this.fTE) {
                    return (childAt.getBottom() + dividerHeight) - a.this.dyN;
                }
                return childAt.getTop() - dividerHeight;
            }
            cancel();
            return -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void x(float f, float f2) {
            int bKi = bKi();
            float paddingLeft = a.this.fSn.x - a.this.mListView.getPaddingLeft();
            float f3 = 1.0f - f2;
            if (f3 < Math.abs((a.this.fSn.y - bKi) / this.fTF) || f3 < Math.abs(paddingLeft / this.fTG)) {
                a.this.fSn.y = bKi + ((int) (this.fTF * f3));
                a.this.fSn.x = a.this.mListView.getPaddingLeft() + ((int) (this.fTG * f3));
                a.this.lD(true);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.bJV();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class k extends m {
        private int fTE;
        private float fTL;
        private float fTM;
        private float fTN;
        private int fTO;
        private int fTP;
        private int fTQ;
        private int fTR;

        public k(float f, int i) {
            super(f, i);
            this.fTO = -1;
            this.fTP = -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.fTO = -1;
            this.fTP = -1;
            this.fTQ = a.this.fSu;
            this.fTR = a.this.fSv;
            this.fTE = a.this.fSx;
            a.this.mDragState = 1;
            this.fTL = a.this.fSn.x;
            if (a.this.fTi) {
                float width = a.this.mListView.getWidth() * 2.0f;
                if (a.this.fTj == 0.0f) {
                    a.this.fTj = (this.fTL >= 0.0f ? 1 : -1) * width;
                    return;
                }
                float f = width * 2.0f;
                if (a.this.fTj >= 0.0f || a.this.fTj <= (-f)) {
                    if (a.this.fTj > 0.0f && a.this.fTj < f) {
                        a.this.fTj = f;
                        return;
                    }
                    return;
                }
                a.this.fTj = -f;
                return;
            }
            a.this.bKd();
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void x(float f, float f2) {
            View childAt;
            float f3 = 1.0f - f2;
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            View childAt2 = a.this.mListView.getChildAt(this.fTQ - firstVisiblePosition);
            if (a.this.fTi) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / 1000.0f;
                if (uptimeMillis != 0.0f) {
                    float f4 = a.this.fTj * uptimeMillis;
                    int width = a.this.mListView.getWidth();
                    a.this.fTj = ((a.this.fTj > 0.0f ? 1 : -1) * uptimeMillis * width) + a.this.fTj;
                    this.fTL += f4;
                    a.this.fSn.x = (int) this.fTL;
                    if (this.fTL < width && this.fTL > (-width)) {
                        this.mStartTime = SystemClock.uptimeMillis();
                        a.this.lD(true);
                        return;
                    }
                } else {
                    return;
                }
            }
            if (childAt2 != null) {
                if (this.fTO == -1) {
                    this.fTO = a.this.f(this.fTQ, childAt2, false);
                    this.fTM = childAt2.getHeight() - this.fTO;
                }
                int max = Math.max((int) (this.fTM * f3), 1);
                ViewGroup.LayoutParams layoutParams = childAt2.getLayoutParams();
                layoutParams.height = max + this.fTO;
                childAt2.setLayoutParams(layoutParams);
            }
            if (this.fTR != this.fTQ && (childAt = a.this.mListView.getChildAt(this.fTR - firstVisiblePosition)) != null) {
                if (this.fTP == -1) {
                    this.fTP = a.this.f(this.fTR, childAt, false);
                    this.fTN = childAt.getHeight() - this.fTP;
                }
                int max2 = Math.max((int) (this.fTN * f3), 1);
                ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
                layoutParams2.height = max2 + this.fTP;
                childAt.setLayoutParams(layoutParams2);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.bJW();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class j extends m {
        private float fTJ;
        private float fTK;
        final /* synthetic */ a fTo;

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.fTJ = this.fTo.fSz;
            this.fTK = this.fTo.fSE;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void x(float f, float f2) {
            if (this.fTo.mDragState != 4) {
                cancel();
                return;
            }
            this.fTo.fSz = (int) ((this.fTK * f2) + ((1.0f - f2) * this.fTJ));
            this.fTo.fSn.y = this.fTo.cMs - this.fTo.fSz;
            this.fTo.lD(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e {
        StringBuilder mBuilder = new StringBuilder();
        private int fTA = 0;
        private int fTB = 0;
        private boolean fTC = false;
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

        public void bKg() {
            this.mBuilder.append("<DSLVStates>\n");
            this.fTB = 0;
            this.fTC = true;
        }

        public void bKh() {
            if (this.fTC) {
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
                this.mBuilder.append("    <FirstExpPos>").append(a.this.fSu).append("</FirstExpPos>\n");
                this.mBuilder.append("    <FirstExpBlankHeight>").append(a.this.tl(a.this.fSu) - a.this.tn(a.this.fSu)).append("</FirstExpBlankHeight>\n");
                this.mBuilder.append("    <SecondExpPos>").append(a.this.fSv).append("</SecondExpPos>\n");
                this.mBuilder.append("    <SecondExpBlankHeight>").append(a.this.tl(a.this.fSv) - a.this.tn(a.this.fSv)).append("</SecondExpBlankHeight>\n");
                this.mBuilder.append("    <SrcPos>").append(a.this.fSx).append("</SrcPos>\n");
                this.mBuilder.append("    <SrcHeight>").append(a.this.dyN + a.this.mListView.getDividerHeight()).append("</SrcHeight>\n");
                this.mBuilder.append("    <ViewHeight>").append(a.this.mListView.getHeight()).append("</ViewHeight>\n");
                this.mBuilder.append("    <LastY>").append(a.this.mLastY).append("</LastY>\n");
                this.mBuilder.append("    <FloatY>").append(a.this.fSp).append("</FloatY>\n");
                this.mBuilder.append("    <ShuffleEdges>");
                for (int i4 = 0; i4 < childCount; i4++) {
                    this.mBuilder.append(a.this.bk(firstVisiblePosition + i4, a.this.mListView.getChildAt(i4).getTop())).append(",");
                }
                this.mBuilder.append("</ShuffleEdges>\n");
                this.mBuilder.append("</DSLVState>\n");
                this.fTA++;
                if (this.fTA > 1000) {
                    flush();
                    this.fTA = 0;
                }
            }
        }

        public void flush() {
            if (this.fTC) {
                try {
                    FileWriter fileWriter = new FileWriter(this.mFile, this.fTB != 0);
                    fileWriter.write(this.mBuilder.toString());
                    this.mBuilder.delete(0, this.mBuilder.length());
                    fileWriter.flush();
                    fileWriter.close();
                    this.fTB++;
                } catch (IOException e) {
                }
            }
        }

        public void stopTracking() {
            if (this.fTC) {
                this.mBuilder.append("</DSLVStates>\n");
                flush();
                this.fTC = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements Runnable {
        private boolean fTr;
        private long fTs;
        private long fTt;
        private int fTu;
        private float fTv;
        private long fTw;
        private int fTx;
        private float fTy;
        private boolean fTz = false;

        public boolean bKe() {
            return this.fTz;
        }

        public int bKf() {
            if (this.fTz) {
                return this.fTx;
            }
            return -1;
        }

        public d() {
        }

        public void to(int i) {
            if (!this.fTz) {
                this.fTr = false;
                this.fTz = true;
                this.fTw = SystemClock.uptimeMillis();
                this.fTs = this.fTw;
                this.fTx = i;
                a.this.mListView.post(this);
            }
        }

        public void lE(boolean z) {
            if (z) {
                a.this.mListView.removeCallbacks(this);
                this.fTz = false;
                return;
            }
            this.fTr = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.fTr) {
                int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
                int lastVisiblePosition = a.this.mListView.getLastVisiblePosition();
                int count = a.this.mListView.getCount();
                int paddingTop = a.this.mListView.getPaddingTop();
                int height = (a.this.mListView.getHeight() - paddingTop) - a.this.mListView.getPaddingBottom();
                int min = Math.min(a.this.cMs, a.this.fSp + a.this.fSE);
                int max = Math.max(a.this.cMs, a.this.fSp - a.this.fSE);
                if (this.fTx == 0) {
                    View childAt = a.this.mListView.getChildAt(0);
                    if (childAt == null) {
                        this.fTz = false;
                        return;
                    } else if (firstVisiblePosition == 0 && childAt.getTop() == paddingTop) {
                        this.fTz = false;
                        return;
                    } else {
                        this.fTy = a.this.fSQ.b((a.this.fSM - max) / a.this.fSN, this.fTs);
                    }
                } else {
                    View childAt2 = a.this.mListView.getChildAt(lastVisiblePosition - firstVisiblePosition);
                    if (childAt2 == null) {
                        this.fTz = false;
                        return;
                    } else if (lastVisiblePosition == count - 1 && childAt2.getBottom() <= height + paddingTop) {
                        this.fTz = false;
                        return;
                    } else {
                        this.fTy = -a.this.fSQ.b((min - a.this.fSL) / a.this.fSO, this.fTs);
                    }
                }
                this.fTt = SystemClock.uptimeMillis();
                this.fTv = (float) (this.fTt - this.fTs);
                this.fTu = Math.round(this.fTy * this.fTv);
                if (this.fTu >= 0) {
                    this.fTu = Math.min(height, this.fTu);
                    lastVisiblePosition = firstVisiblePosition;
                } else {
                    this.fTu = Math.max(-height, this.fTu);
                }
                View childAt3 = a.this.mListView.getChildAt(lastVisiblePosition - firstVisiblePosition);
                int top = childAt3.getTop() + this.fTu;
                if (lastVisiblePosition == 0 && top > paddingTop) {
                    top = paddingTop;
                }
                a.this.mBlockLayoutRequests = true;
                a.this.mListView.setSelectionFromTop(lastVisiblePosition, top - paddingTop);
                a.this.layoutChildren();
                a.this.mListView.invalidate();
                a.this.mBlockLayoutRequests = false;
                a.this.h(lastVisiblePosition, childAt3, false);
                this.fTs = this.fTt;
                a.this.mListView.post(this);
                return;
            }
            this.fTz = false;
        }
    }
}
