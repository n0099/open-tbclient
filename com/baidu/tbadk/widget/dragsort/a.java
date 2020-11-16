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
import com.baidu.tieba.R;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a implements com.baidu.tbadk.widget.dragsort.c {
    private int dml;
    private View fAV;
    private int fAY;
    private int fBA;
    private MotionEvent fBF;
    private C0599a fBJ;
    private e fBL;
    private k fBO;
    private j fBP;
    private f fBQ;
    private boolean fBR;
    private com.baidu.tbadk.widget.dragsort.d fBT;
    private com.baidu.tbadk.widget.dragsort.b fBU;
    private int fBc;
    private int fBd;
    private int fBe;
    private int fBg;
    private int fBh;
    private int fBi;
    private b fBj;
    private g fBk;
    private l fBl;
    private int fBn;
    private d fBp;
    private int fBs;
    private int fBt;
    private float fBu;
    private float fBv;
    private float fBw;
    private float fBx;
    private int mLastX;
    private int mLastY;
    private ListView mListView;
    private DataSetObserver mObserver;
    private int mOffsetX;
    private int mOffsetY;
    private int mX;
    private int mY;
    private Point fAW = new Point();
    private Point fAX = new Point();
    private boolean fAZ = false;
    private float fBa = 1.0f;
    private float fBb = 1.0f;
    private boolean fBf = false;
    private boolean dDL = true;
    private int mDragState = 0;
    private int fBm = 1;
    private int mWidthMeasureSpec = 0;
    private View[] fBo = new View[1];
    private float fBq = 0.33333334f;
    private float fBr = 0.33333334f;
    private float fBy = 0.5f;
    private c fBz = new c() { // from class: com.baidu.tbadk.widget.dragsort.a.1
        @Override // com.baidu.tbadk.widget.dragsort.a.c
        public float b(float f2, long j2) {
            return a.this.fBy * f2;
        }
    };
    private int fBB = 0;
    private boolean fBC = false;
    private boolean fBD = false;
    private h fBE = null;
    private int fBG = 0;
    private float fBH = 0.25f;
    private float fBI = 0.0f;
    private boolean fBK = false;
    private boolean mBlockLayoutRequests = false;
    private boolean fBM = false;
    private i fBN = new i(3);
    private float fBS = 0.0f;
    private boolean fBV = false;
    private boolean fBW = false;

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

        void bK(View view);

        View sB(int i);
    }

    /* loaded from: classes.dex */
    public interface l {
        void remove(int i);
    }

    public a(ListView listView, com.baidu.tbadk.widget.dragsort.d dVar) {
        this.fBT = dVar;
        this.mListView = listView;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            this.fBJ = new C0599a(listAdapter);
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
            this.fBJ = null;
        }
        this.fBT.setAdapter(this.fBJ);
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
            if (i2 > this.fBg) {
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
    public int sx(int i2) {
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        return childAt != null ? childAt.getHeight() : bm(i2, sz(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bk(int i2, int i3) {
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        if (i2 <= headerViewsCount || i2 >= this.mListView.getCount() - footerViewsCount) {
            return i3;
        }
        int dividerHeight = this.mListView.getDividerHeight();
        int i4 = this.dml - this.fBm;
        int sz = sz(i2);
        int sx = sx(i2);
        if (this.fBe <= this.fBg) {
            if (i2 == this.fBe && this.fBd != this.fBe) {
                if (i2 == this.fBg) {
                    i3 = (i3 + sx) - this.dml;
                } else {
                    i3 = ((sx - sz) + i3) - i4;
                }
            } else if (i2 > this.fBe && i2 <= this.fBg) {
                i3 -= i4;
            }
        } else if (i2 > this.fBg && i2 <= this.fBd) {
            i3 += i4;
        } else if (i2 == this.fBe && this.fBd != this.fBe) {
            i3 += sx - sz;
        }
        if (i2 <= this.fBg) {
            return (((this.dml - dividerHeight) - sz(i2 - 1)) / 2) + i3;
        }
        return (((sz - dividerHeight) - this.dml) / 2) + i3;
    }

    private boolean bDZ() {
        int i2;
        int i3;
        int i4;
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int i5 = this.fBd;
        View childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        if (childAt == null) {
            i5 = firstVisiblePosition + (this.mListView.getChildCount() / 2);
            childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        }
        int top = childAt.getTop();
        int height = childAt.getHeight();
        int bk = bk(i5, top);
        int dividerHeight = this.mListView.getDividerHeight();
        if (this.fAY >= bk) {
            int count = this.mListView.getCount();
            int i6 = height;
            int i7 = top;
            i2 = bk;
            i3 = i5;
            i4 = bk;
            while (true) {
                if (i3 < count) {
                    if (i3 == count - 1) {
                        i2 = i7 + dividerHeight + i6;
                        break;
                    }
                    i7 += dividerHeight + i6;
                    i6 = sx(i3 + 1);
                    i2 = bk(i3 + 1, i7);
                    if (this.fAY < i2) {
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
            i2 = bk;
            i3 = i5;
            i4 = bk;
            while (true) {
                if (i3 < 0) {
                    break;
                }
                i3--;
                int sx = sx(i3);
                if (i3 == 0) {
                    i2 = (i8 - dividerHeight) - sx;
                    break;
                }
                i8 -= sx + dividerHeight;
                i2 = bk(i3, i8);
                if (this.fAY >= i2) {
                    break;
                }
                i4 = i2;
            }
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int i9 = this.fBd;
        int i10 = this.fBe;
        float f2 = this.fBI;
        if (this.fBf) {
            int abs = Math.abs(i2 - i4);
            if (this.fAY >= i2) {
                int i11 = i4;
                i4 = i2;
                i2 = i11;
            }
            int i12 = (int) (abs * this.fBH * 0.5f);
            float f3 = i12;
            int i13 = i4 + i12;
            int i14 = i2 - i12;
            if (this.fAY < i13) {
                this.fBd = i3 - 1;
                this.fBe = i3;
                this.fBI = ((i13 - this.fAY) * 0.5f) / f3;
            } else if (this.fAY < i14) {
                this.fBd = i3;
                this.fBe = i3;
            } else {
                this.fBd = i3;
                this.fBe = i3 + 1;
                this.fBI = (1.0f + ((i2 - this.fAY) / f3)) * 0.5f;
            }
        } else {
            this.fBd = i3;
            this.fBe = i3;
        }
        if (this.fBd < headerViewsCount) {
            this.fBd = headerViewsCount;
            this.fBe = headerViewsCount;
            i3 = headerViewsCount;
        } else if (this.fBe >= this.mListView.getCount() - footerViewsCount) {
            i3 = (this.mListView.getCount() - footerViewsCount) - 1;
            this.fBd = i3;
            this.fBe = i3;
        }
        boolean z = (this.fBd == i9 && this.fBe == i10 && this.fBI == f2) ? false : true;
        if (i3 != this.fBc) {
            if (this.fBj != null) {
                this.fBj.drag(this.fBc - headerViewsCount, i3 - headerViewsCount);
            }
            this.fBc = i3;
            return true;
        }
        return z;
    }

    public void removeItem(int i2) {
        this.fBR = false;
        removeItem(i2, 0.0f);
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void a(ListView listView, Context context, AttributeSet attributeSet) {
        int i2;
        int i3 = 150;
        if (attributeSet == null) {
            i2 = 150;
        } else {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DragSort, 0, 0);
            this.fBm = Math.max(1, obtainStyledAttributes.getDimensionPixelSize(R.styleable.DragSort_collapsed_height, 1));
            this.fBK = obtainStyledAttributes.getBoolean(R.styleable.DragSort_track_drag_sort, false);
            if (this.fBK) {
                this.fBL = new e();
            }
            this.fBa = obtainStyledAttributes.getFloat(R.styleable.DragSort_float_alpha, this.fBa);
            this.fBb = this.fBa;
            this.dDL = obtainStyledAttributes.getBoolean(R.styleable.DragSort_drag_enabled, this.dDL);
            this.fBH = Math.max(0.0f, Math.min(1.0f, 1.0f - obtainStyledAttributes.getFloat(R.styleable.DragSort_slide_shuffle_speed, 0.75f)));
            this.fBf = this.fBH > 0.0f;
            setDragScrollStart(obtainStyledAttributes.getFloat(R.styleable.DragSort_drag_scroll_start, this.fBq));
            this.fBy = obtainStyledAttributes.getFloat(R.styleable.DragSort_max_drag_scroll_speed, this.fBy);
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
                bVar.kQ(z);
                bVar.kP(z2);
                bVar.setBackgroundColor(color);
                this.fBE = bVar;
                a(bVar);
            }
            obtainStyledAttributes.recycle();
            i2 = i5;
            i3 = i4;
        }
        this.fBp = new d();
        if (i3 > 0) {
            this.fBO = new k(0.5f, i3);
        }
        if (i2 > 0) {
            this.fBQ = new f(0.5f, i2);
        }
        this.fBF = MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
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
        this.fBU = bVar;
        this.mListView.setOnTouchListener(bVar);
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void dispatchDraw(Canvas canvas) {
        float f2;
        this.fBT.dispatchDraw(canvas);
        if (this.mDragState != 0) {
            if (this.fBd != this.fBg) {
                b(this.fBd, canvas);
            }
            if (this.fBe != this.fBd && this.fBe != this.fBg) {
                b(this.fBe, canvas);
            }
        }
        if (this.fAV != null) {
            int width = this.fAV.getWidth();
            int height = this.fAV.getHeight();
            int i2 = this.fAW.x;
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
            int i3 = (int) (f2 * 255.0f * this.fBb);
            canvas.save();
            canvas.translate(this.fAW.x, this.fAW.y);
            canvas.clipRect(0, 0, width, height);
            canvas.saveLayerAlpha(0.0f, 0.0f, width, height, i3, 31);
            this.fAV.draw(canvas);
            canvas.restore();
            canvas.restore();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onDraw(Canvas canvas) {
        this.fBT.onDraw(canvas);
        if (this.fBK) {
            this.fBL.bEm();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.fBM) {
            this.fBM = false;
            return false;
        } else if (!this.dDL) {
            return this.fBT.onTouchEvent(motionEvent);
        } else {
            boolean z2 = this.fBC;
            this.fBC = false;
            if (!z2) {
                G(motionEvent);
            }
            if (this.mDragState == 4) {
                onDragTouchEvent(motionEvent);
                return true;
            }
            if (this.mDragState == 0 && this.fBT.onTouchEvent(motionEvent)) {
                z = true;
            }
            switch (motionEvent.getAction() & 255) {
                case 1:
                case 3:
                    bEe();
                    return z;
                case 2:
                default:
                    if (z) {
                        this.fBG = 1;
                        return z;
                    }
                    return z;
            }
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (!this.dDL) {
            return this.fBT.onInterceptTouchEvent(motionEvent);
        }
        if (this.fBU != null) {
            this.fBU.bEo().onTouchEvent(motionEvent);
        }
        G(motionEvent);
        this.fBC = true;
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            if (this.mDragState != 0) {
                this.fBM = true;
                return true;
            }
            this.fBD = true;
        }
        if (this.fAV == null) {
            if (this.fBT.onInterceptTouchEvent(motionEvent)) {
                this.fBV = true;
                z = true;
            } else {
                z = false;
            }
            switch (action) {
                case 1:
                case 3:
                    bEe();
                    break;
                case 2:
                default:
                    if (z) {
                        this.fBG = 1;
                        break;
                    } else {
                        this.fBG = 2;
                        break;
                    }
            }
        } else {
            z = true;
        }
        if (action == 1 || action == 3) {
            this.fBD = false;
        }
        return z;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        this.fBT.onSizeChanged(i2, i3, i4, i5);
        bEf();
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void requestLayout() {
        if (!this.mBlockLayoutRequests) {
            this.fBT.requestLayout();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onMeasure(int i2, int i3) {
        this.fBT.onMeasure(i2, i3);
        if (this.fAV != null) {
            if (this.fAV.isLayoutRequested()) {
                bEh();
            }
            this.fAZ = true;
        }
        this.mWidthMeasureSpec = i2;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void layoutChildren() {
        this.fBT.layoutChildren();
        if (this.fAV != null) {
            if (this.fAV.isLayoutRequested() && !this.fAZ) {
                bEh();
            }
            this.fAV.layout(0, 0, this.fAV.getMeasuredWidth(), this.fAV.getMeasuredHeight());
            this.fAZ = false;
        }
    }

    public void removeItem(int i2, float f2) {
        if (this.mDragState == 0 || this.mDragState == 4) {
            if (this.mDragState == 0) {
                this.fBg = this.mListView.getHeaderViewsCount() + i2;
                this.fBd = this.fBg;
                this.fBe = this.fBg;
                this.fBc = this.fBg;
                View childAt = this.mListView.getChildAt(this.fBg - this.mListView.getFirstVisiblePosition());
                if (childAt != null) {
                    childAt.setVisibility(4);
                }
            }
            this.mDragState = 1;
            this.fBS = f2;
            if (this.fBD) {
                switch (this.fBG) {
                    case 1:
                        this.fBT.onTouchEvent(this.fBF);
                        break;
                    case 2:
                        this.fBT.onInterceptTouchEvent(this.fBF);
                        break;
                }
            }
            if (this.fBO != null) {
                this.fBO.start();
            } else {
                sy(i2);
            }
        }
    }

    public void cancelDrag() {
        if (this.mDragState == 4) {
            this.fBp.kO(true);
            bEj();
            bEa();
            bEg();
            if (this.fBD) {
                this.mDragState = 3;
            } else {
                this.mDragState = 0;
            }
        }
    }

    private void bEa() {
        this.fBg = -1;
        this.fBd = -1;
        this.fBe = -1;
        this.fBc = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEb() {
        this.mDragState = 2;
        if (this.fBk != null && this.fBc >= 0 && this.fBc < this.mListView.getCount()) {
            int headerViewsCount = this.mListView.getHeaderViewsCount();
            this.fBk.drop(this.fBg - headerViewsCount, this.fBc - headerViewsCount);
        }
        bEj();
        bEd();
        bEa();
        bEg();
        if (this.fBD) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEc() {
        sy(this.fBg - this.mListView.getHeaderViewsCount());
    }

    private void sy(int i2) {
        this.mDragState = 1;
        if (this.fBl != null) {
            this.fBl.remove(i2);
        }
        bEj();
        bEd();
        bEa();
        if (this.fBD) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    private void bEd() {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        if (this.fBg < firstVisiblePosition) {
            View childAt = this.mListView.getChildAt(0);
            this.mListView.setSelectionFromTop(firstVisiblePosition - 1, (childAt != null ? childAt.getTop() : 0) - this.mListView.getPaddingTop());
        }
    }

    public boolean stopDrag(boolean z) {
        this.fBR = false;
        return stopDrag(z, 0.0f);
    }

    public boolean stopDragWithVelocity(boolean z, float f2) {
        this.fBR = true;
        return stopDrag(z, f2);
    }

    public boolean stopDrag(boolean z, float f2) {
        if (this.fAV != null) {
            this.fBp.kO(true);
            if (z) {
                removeItem(this.fBg - this.mListView.getHeaderViewsCount(), f2);
            } else if (this.fBQ != null) {
                this.fBQ.start();
            } else {
                bEb();
            }
            if (this.fBK) {
                this.fBL.stopTracking();
                return true;
            }
            return true;
        }
        return false;
    }

    private void bEe() {
        this.fBG = 0;
        this.fBD = false;
        if (this.mDragState == 3) {
            this.mDragState = 0;
        }
        this.fBb = this.fBa;
        this.fBV = false;
        this.fBN.clear();
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
        return this.fBV;
    }

    public void setDragScrollStart(float f2) {
        setDragScrollStarts(f2, f2);
    }

    public void setDragScrollStarts(float f2, float f3) {
        if (f3 > 0.5f) {
            this.fBr = 0.5f;
        } else {
            this.fBr = f3;
        }
        if (f2 > 0.5f) {
            this.fBq = 0.5f;
        } else {
            this.fBq = f2;
        }
        if (this.mListView.getHeight() != 0) {
            bEf();
        }
    }

    private void bl(int i2, int i3) {
        this.fAW.x = i2 - this.fBh;
        this.fAW.y = i3 - this.fBi;
        kN(true);
        int min = Math.min(i3, this.fAY + this.fBn);
        int max = Math.max(i3, this.fAY - this.fBn);
        int bEk = this.fBp.bEk();
        if (min > this.mLastY && min > this.fBt && bEk != 1) {
            if (bEk != -1) {
                this.fBp.kO(true);
            }
            this.fBp.sA(1);
        } else if (max < this.mLastY && max < this.fBs && bEk != 0) {
            if (bEk != -1) {
                this.fBp.kO(true);
            }
            this.fBp.sA(0);
        } else if (max >= this.fBs && min <= this.fBt && this.fBp.isScrolling()) {
            this.fBp.kO(true);
        }
    }

    private void bEf() {
        int height;
        int paddingTop = this.mListView.getPaddingTop();
        float height2 = (this.mListView.getHeight() - paddingTop) - this.mListView.getPaddingBottom();
        this.fBv = paddingTop + (this.fBq * height2);
        this.fBu = (height2 * (1.0f - this.fBr)) + paddingTop;
        this.fBs = (int) this.fBv;
        this.fBt = (int) this.fBu;
        this.fBw = this.fBv - paddingTop;
        this.fBx = (paddingTop + height) - this.fBu;
    }

    private void bEg() {
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
        if (i2 != this.fBg && i2 != this.fBd && i2 != this.fBe) {
            g2 = -2;
        } else {
            g2 = g(i2, view, z);
        }
        if (g2 != layoutParams.height) {
            layoutParams.height = g2;
            view.setLayoutParams(layoutParams);
        }
        if (i2 == this.fBd || i2 == this.fBe) {
            if (i2 < this.fBg) {
                ((DragSortItemView) view).setGravity(80);
            } else if (i2 > this.fBg) {
                ((DragSortItemView) view).setGravity(48);
            }
        }
        int visibility = view.getVisibility();
        int i3 = 0;
        if (i2 == this.fBg && this.fAV != null) {
            i3 = 4;
        }
        if (i3 != visibility) {
            view.setVisibility(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int sz(int i2) {
        View view;
        if (i2 == this.fBg) {
            return 0;
        }
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        if (childAt != null) {
            return f(i2, childAt, false);
        }
        int i3 = this.fBN.get(i2);
        if (i3 == -1) {
            ListAdapter adapter = this.mListView.getAdapter();
            int itemViewType = adapter.getItemViewType(i2);
            int viewTypeCount = adapter.getViewTypeCount();
            if (viewTypeCount != this.fBo.length) {
                this.fBo = new View[viewTypeCount];
            }
            if (itemViewType >= 0) {
                if (this.fBo[itemViewType] == null) {
                    view = adapter.getView(i2, null, this.mListView);
                    this.fBo[itemViewType] = view;
                } else {
                    view = adapter.getView(i2, this.fBo[itemViewType], this.mListView);
                }
            } else {
                view = adapter.getView(i2, null, this.mListView);
            }
            int f2 = f(i2, view, true);
            this.fBN.bn(i2, f2);
            return f2;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(int i2, View view, boolean z) {
        if (i2 == this.fBg) {
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
        boolean z = this.fBf && this.fBd != this.fBe;
        int i4 = this.dml - this.fBm;
        int i5 = (int) (this.fBI * i4);
        if (i2 == this.fBg) {
            if (this.fBg == this.fBd) {
                if (z) {
                    return i5 + this.fBm;
                }
                return this.dml;
            } else if (this.fBg == this.fBe) {
                return this.dml - i5;
            } else {
                return this.fBm;
            }
        } else if (i2 == this.fBd) {
            if (z) {
                return i3 + i5;
            }
            return i3 + i4;
        } else if (i2 == this.fBe) {
            return (i3 + i4) - i5;
        } else {
            return i3;
        }
    }

    private int b(int i2, View view, int i3, int i4) {
        int i5;
        int i6;
        int sz = sz(i2);
        int height = view.getHeight();
        int bm = bm(i2, sz);
        if (i2 != this.fBg) {
            i6 = height - sz;
            i5 = bm - sz;
        } else {
            i5 = bm;
            i6 = height;
        }
        int i7 = this.dml;
        if (this.fBg != this.fBd && this.fBg != this.fBe) {
            i7 -= this.fBm;
        }
        if (i2 <= i3) {
            if (i2 > this.fBd) {
                return (i7 - i5) + 0;
            }
        } else if (i2 == i4) {
            if (i2 <= this.fBd) {
                return (i6 - i7) + 0;
            }
            if (i2 == this.fBe) {
                return (height - bm) + 0;
            }
            return 0 + i6;
        } else if (i2 <= this.fBd) {
            return 0 - i7;
        } else {
            if (i2 == this.fBe) {
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

    private void bEh() {
        if (this.fAV != null) {
            measureItem(this.fAV);
            this.dml = this.fAV.getMeasuredHeight();
            this.fBn = this.dml / 2;
        }
    }

    protected boolean onDragTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        switch (motionEvent.getAction() & 255) {
            case 1:
                if (this.mDragState == 4) {
                    stopDrag(false);
                }
                bEe();
                return true;
            case 2:
                bl((int) motionEvent.getX(), (int) motionEvent.getY());
                return true;
            case 3:
                if (this.mDragState == 4) {
                    cancelDrag();
                }
                bEe();
                return true;
            default:
                return true;
        }
    }

    public boolean startDrag(int i2, int i3, int i4, int i5) {
        View sB;
        if (!this.fBD || this.fBE == null || (sB = this.fBE.sB(i2)) == null) {
            return false;
        }
        return startDrag(i2, sB, i3, i4, i5);
    }

    public boolean startDrag(int i2, View view, int i3, int i4, int i5) {
        if (this.mDragState == 0 && this.fBD && this.fAV == null && view != null && this.dDL) {
            if (this.mListView.getParent() != null) {
                this.mListView.getParent().requestDisallowInterceptTouchEvent(true);
            }
            int headerViewsCount = this.mListView.getHeaderViewsCount() + i2;
            this.fBd = headerViewsCount;
            this.fBe = headerViewsCount;
            this.fBg = headerViewsCount;
            this.fBc = headerViewsCount;
            this.mDragState = 4;
            this.fBB = 0;
            this.fBB |= i3;
            this.fAV = view;
            bEh();
            this.fBh = i4;
            this.fBi = i5;
            this.fBA = this.mY;
            this.fAW.x = this.mX - this.fBh;
            this.fAW.y = this.mY - this.fBi;
            View childAt = this.mListView.getChildAt(this.fBg - this.mListView.getFirstVisiblePosition());
            if (childAt != null) {
                childAt.setVisibility(4);
            }
            if (this.fBK) {
                this.fBL.bEl();
            }
            switch (this.fBG) {
                case 1:
                    this.fBT.onTouchEvent(this.fBF);
                    break;
                case 2:
                    this.fBT.onInterceptTouchEvent(this.fBF);
                    break;
            }
            this.mListView.requestLayout();
            if (this.fBP != null) {
                this.fBP.start();
                return true;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kN(boolean z) {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition() + (this.mListView.getChildCount() / 2);
        View childAt = this.mListView.getChildAt(this.mListView.getChildCount() / 2);
        if (childAt != null) {
            h(firstVisiblePosition, childAt, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i2, View view, boolean z) {
        this.mBlockLayoutRequests = true;
        bEi();
        int i3 = this.fBd;
        int i4 = this.fBe;
        boolean bDZ = bDZ();
        if (bDZ) {
            bEg();
            this.mListView.setSelectionFromTop(i2, (b(i2, view, i3, i4) + view.getTop()) - this.mListView.getPaddingTop());
            layoutChildren();
        }
        if (bDZ || z) {
            this.mListView.invalidate();
        }
        this.mBlockLayoutRequests = false;
    }

    private void bEi() {
        if (this.fBE != null) {
            this.fAX.set(this.mX, this.mY);
            this.fBE.b(this.fAV, this.fAW, this.fAX);
        }
        int i2 = this.fAW.x;
        int i3 = this.fAW.y;
        int paddingLeft = this.mListView.getPaddingLeft();
        if ((this.fBB & 1) == 0 && i2 > paddingLeft) {
            this.fAW.x = paddingLeft;
        } else if ((this.fBB & 2) == 0 && i2 < paddingLeft) {
            this.fAW.x = paddingLeft;
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int lastVisiblePosition = this.mListView.getLastVisiblePosition();
        int paddingTop = this.mListView.getPaddingTop();
        if (firstVisiblePosition < headerViewsCount) {
            paddingTop = this.mListView.getChildAt((headerViewsCount - firstVisiblePosition) - 1).getBottom();
        }
        if ((this.fBB & 8) == 0 && firstVisiblePosition <= this.fBg) {
            paddingTop = Math.max(this.mListView.getChildAt(this.fBg - firstVisiblePosition).getTop(), paddingTop);
        }
        int height = this.mListView.getHeight() - this.mListView.getPaddingBottom();
        if (lastVisiblePosition >= (this.mListView.getCount() - footerViewsCount) - 1) {
            height = this.mListView.getChildAt(((this.mListView.getCount() - footerViewsCount) - 1) - firstVisiblePosition).getBottom();
        }
        if ((this.fBB & 4) == 0 && lastVisiblePosition >= this.fBg) {
            height = Math.min(this.mListView.getChildAt(this.fBg - firstVisiblePosition).getBottom(), height);
        }
        if (i3 < paddingTop) {
            this.fAW.y = paddingTop;
        } else if (this.dml + i3 > height) {
            this.fAW.y = height - this.dml;
        }
        this.fAY = this.fAW.y + this.fBn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEj() {
        if (this.fAV != null) {
            this.fAV.setVisibility(8);
            if (this.fBE != null) {
                this.fBE.bK(this.fAV);
            }
            this.fAV = null;
            this.mListView.invalidate();
        }
    }

    public void a(h hVar) {
        this.fBE = hVar;
    }

    public void a(b bVar) {
        this.fBj = bVar;
    }

    public void setDragEnabled(boolean z) {
        this.dDL = z;
    }

    public boolean isDragEnabled() {
        return this.dDL;
    }

    public void a(g gVar) {
        this.fBk = gVar;
    }

    public void a(l lVar) {
        this.fBl = lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class i {
        private SparseIntArray fCp;
        private ArrayList<Integer> fCq;
        private int mMaxSize;

        public i(int i) {
            this.fCp = new SparseIntArray(i);
            this.fCq = new ArrayList<>(i);
            this.mMaxSize = i;
        }

        public void bn(int i, int i2) {
            int i3 = this.fCp.get(i, -1);
            if (i3 != i2) {
                if (i3 == -1) {
                    if (this.fCp.size() == this.mMaxSize) {
                        this.fCp.delete(this.fCq.remove(0).intValue());
                    }
                } else {
                    this.fCq.remove(Integer.valueOf(i));
                }
                this.fCp.put(i, i2);
                this.fCq.add(Integer.valueOf(i));
            }
        }

        public int get(int i) {
            return this.fCp.get(i, -1);
        }

        public void clear() {
            this.fCp.clear();
            this.fCq.clear();
        }
    }

    /* renamed from: com.baidu.tbadk.widget.dragsort.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0599a extends BaseAdapter {
        private ListAdapter mAdapter;

        public C0599a(ListAdapter listAdapter) {
            this.mAdapter = listAdapter;
            this.mAdapter.registerDataSetObserver(new DataSetObserver() { // from class: com.baidu.tbadk.widget.dragsort.a.a.1
                @Override // android.database.DataSetObserver
                public void onChanged() {
                    C0599a.this.notifyDataSetChanged();
                }

                @Override // android.database.DataSetObserver
                public void onInvalidated() {
                    C0599a.this.notifyDataSetInvalidated();
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
        private float cAX;
        private float cAY;
        private float cAZ;
        private float cBa;
        private float fCA;
        private float mAlpha;
        private boolean mCanceled;
        protected long mStartTime;

        public m(float f, int i) {
            this.mAlpha = f;
            this.fCA = i;
            float f2 = 1.0f / ((this.mAlpha * 2.0f) * (1.0f - this.mAlpha));
            this.cBa = f2;
            this.cAX = f2;
            this.cAY = this.mAlpha / ((this.mAlpha - 1.0f) * 2.0f);
            this.cAZ = 1.0f / (1.0f - this.mAlpha);
        }

        public float an(float f) {
            if (f < this.mAlpha) {
                return this.cAX * f * f;
            }
            if (f < 1.0f - this.mAlpha) {
                return this.cAY + (this.cAZ * f);
            }
            return 1.0f - ((this.cBa * (f - 1.0f)) * (f - 1.0f));
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
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / this.fCA;
                if (uptimeMillis >= 1.0f) {
                    x(1.0f, 1.0f);
                    onStop();
                    return;
                }
                x(uptimeMillis, an(uptimeMillis));
                a.this.mListView.post(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class f extends m {
        private int fCl;
        private int fCm;
        private float fCn;
        private float fCo;

        public f(float f, int i) {
            super(f, i);
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.fCl = a.this.fBc;
            this.fCm = a.this.fBg;
            a.this.mDragState = 2;
            this.fCn = a.this.fAW.y - bEn();
            this.fCo = a.this.fAW.x - a.this.mListView.getPaddingLeft();
        }

        private int bEn() {
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            int dividerHeight = (a.this.fBm + a.this.mListView.getDividerHeight()) / 2;
            View childAt = a.this.mListView.getChildAt(this.fCl - firstVisiblePosition);
            if (childAt != null) {
                if (this.fCl == this.fCm) {
                    return childAt.getTop();
                }
                if (this.fCl >= this.fCm) {
                    return (childAt.getBottom() + dividerHeight) - a.this.dml;
                }
                return childAt.getTop() - dividerHeight;
            }
            cancel();
            return -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void x(float f, float f2) {
            int bEn = bEn();
            float paddingLeft = a.this.fAW.x - a.this.mListView.getPaddingLeft();
            float f3 = 1.0f - f2;
            if (f3 < Math.abs((a.this.fAW.y - bEn) / this.fCn) || f3 < Math.abs(paddingLeft / this.fCo)) {
                a.this.fAW.y = bEn + ((int) (this.fCn * f3));
                a.this.fAW.x = a.this.mListView.getPaddingLeft() + ((int) (this.fCo * f3));
                a.this.kN(true);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.bEb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class k extends m {
        private int fCm;
        private float fCt;
        private float fCu;
        private float fCv;
        private int fCw;
        private int fCx;
        private int fCy;
        private int fCz;

        public k(float f, int i) {
            super(f, i);
            this.fCw = -1;
            this.fCx = -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.fCw = -1;
            this.fCx = -1;
            this.fCy = a.this.fBd;
            this.fCz = a.this.fBe;
            this.fCm = a.this.fBg;
            a.this.mDragState = 1;
            this.fCt = a.this.fAW.x;
            if (a.this.fBR) {
                float width = a.this.mListView.getWidth() * 2.0f;
                if (a.this.fBS == 0.0f) {
                    a.this.fBS = (this.fCt >= 0.0f ? 1 : -1) * width;
                    return;
                }
                float f = width * 2.0f;
                if (a.this.fBS >= 0.0f || a.this.fBS <= (-f)) {
                    if (a.this.fBS > 0.0f && a.this.fBS < f) {
                        a.this.fBS = f;
                        return;
                    }
                    return;
                }
                a.this.fBS = -f;
                return;
            }
            a.this.bEj();
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void x(float f, float f2) {
            View childAt;
            float f3 = 1.0f - f2;
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            View childAt2 = a.this.mListView.getChildAt(this.fCy - firstVisiblePosition);
            if (a.this.fBR) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / 1000.0f;
                if (uptimeMillis != 0.0f) {
                    float f4 = a.this.fBS * uptimeMillis;
                    int width = a.this.mListView.getWidth();
                    a.this.fBS = ((a.this.fBS > 0.0f ? 1 : -1) * uptimeMillis * width) + a.this.fBS;
                    this.fCt += f4;
                    a.this.fAW.x = (int) this.fCt;
                    if (this.fCt < width && this.fCt > (-width)) {
                        this.mStartTime = SystemClock.uptimeMillis();
                        a.this.kN(true);
                        return;
                    }
                } else {
                    return;
                }
            }
            if (childAt2 != null) {
                if (this.fCw == -1) {
                    this.fCw = a.this.f(this.fCy, childAt2, false);
                    this.fCu = childAt2.getHeight() - this.fCw;
                }
                int max = Math.max((int) (this.fCu * f3), 1);
                ViewGroup.LayoutParams layoutParams = childAt2.getLayoutParams();
                layoutParams.height = max + this.fCw;
                childAt2.setLayoutParams(layoutParams);
            }
            if (this.fCz != this.fCy && (childAt = a.this.mListView.getChildAt(this.fCz - firstVisiblePosition)) != null) {
                if (this.fCx == -1) {
                    this.fCx = a.this.f(this.fCz, childAt, false);
                    this.fCv = childAt.getHeight() - this.fCx;
                }
                int max2 = Math.max((int) (this.fCv * f3), 1);
                ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
                layoutParams2.height = max2 + this.fCx;
                childAt.setLayoutParams(layoutParams2);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.bEc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class j extends m {
        final /* synthetic */ a fBX;
        private float fCr;
        private float fCs;

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.fCr = this.fBX.fBi;
            this.fCs = this.fBX.fBn;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void x(float f, float f2) {
            if (this.fBX.mDragState != 4) {
                cancel();
                return;
            }
            this.fBX.fBi = (int) ((this.fCs * f2) + ((1.0f - f2) * this.fCr));
            this.fBX.fAW.y = this.fBX.mY - this.fBX.fBi;
            this.fBX.kN(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e {
        StringBuilder mBuilder = new StringBuilder();
        private int fCi = 0;
        private int fCj = 0;
        private boolean fCk = false;
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

        public void bEl() {
            this.mBuilder.append("<DSLVStates>\n");
            this.fCj = 0;
            this.fCk = true;
        }

        public void bEm() {
            if (this.fCk) {
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
                this.mBuilder.append("    <FirstExpPos>").append(a.this.fBd).append("</FirstExpPos>\n");
                this.mBuilder.append("    <FirstExpBlankHeight>").append(a.this.sx(a.this.fBd) - a.this.sz(a.this.fBd)).append("</FirstExpBlankHeight>\n");
                this.mBuilder.append("    <SecondExpPos>").append(a.this.fBe).append("</SecondExpPos>\n");
                this.mBuilder.append("    <SecondExpBlankHeight>").append(a.this.sx(a.this.fBe) - a.this.sz(a.this.fBe)).append("</SecondExpBlankHeight>\n");
                this.mBuilder.append("    <SrcPos>").append(a.this.fBg).append("</SrcPos>\n");
                this.mBuilder.append("    <SrcHeight>").append(a.this.dml + a.this.mListView.getDividerHeight()).append("</SrcHeight>\n");
                this.mBuilder.append("    <ViewHeight>").append(a.this.mListView.getHeight()).append("</ViewHeight>\n");
                this.mBuilder.append("    <LastY>").append(a.this.mLastY).append("</LastY>\n");
                this.mBuilder.append("    <FloatY>").append(a.this.fAY).append("</FloatY>\n");
                this.mBuilder.append("    <ShuffleEdges>");
                for (int i4 = 0; i4 < childCount; i4++) {
                    this.mBuilder.append(a.this.bk(firstVisiblePosition + i4, a.this.mListView.getChildAt(i4).getTop())).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                this.mBuilder.append("</ShuffleEdges>\n");
                this.mBuilder.append("</DSLVState>\n");
                this.fCi++;
                if (this.fCi > 1000) {
                    flush();
                    this.fCi = 0;
                }
            }
        }

        public void flush() {
            if (this.fCk) {
                try {
                    FileWriter fileWriter = new FileWriter(this.mFile, this.fCj != 0);
                    fileWriter.write(this.mBuilder.toString());
                    this.mBuilder.delete(0, this.mBuilder.length());
                    fileWriter.flush();
                    fileWriter.close();
                    this.fCj++;
                } catch (IOException e) {
                }
            }
        }

        public void stopTracking() {
            if (this.fCk) {
                this.mBuilder.append("</DSLVStates>\n");
                flush();
                this.fCk = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements Runnable {
        private boolean fCa;
        private long fCb;
        private long fCc;
        private int fCd;
        private float fCe;
        private long fCf;
        private int fCg;
        private float fCh;
        private boolean mScrolling = false;

        public boolean isScrolling() {
            return this.mScrolling;
        }

        public int bEk() {
            if (this.mScrolling) {
                return this.fCg;
            }
            return -1;
        }

        public d() {
        }

        public void sA(int i) {
            if (!this.mScrolling) {
                this.fCa = false;
                this.mScrolling = true;
                this.fCf = SystemClock.uptimeMillis();
                this.fCb = this.fCf;
                this.fCg = i;
                a.this.mListView.post(this);
            }
        }

        public void kO(boolean z) {
            if (z) {
                a.this.mListView.removeCallbacks(this);
                this.mScrolling = false;
                return;
            }
            this.fCa = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.fCa) {
                int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
                int lastVisiblePosition = a.this.mListView.getLastVisiblePosition();
                int count = a.this.mListView.getCount();
                int paddingTop = a.this.mListView.getPaddingTop();
                int height = (a.this.mListView.getHeight() - paddingTop) - a.this.mListView.getPaddingBottom();
                int min = Math.min(a.this.mY, a.this.fAY + a.this.fBn);
                int max = Math.max(a.this.mY, a.this.fAY - a.this.fBn);
                if (this.fCg == 0) {
                    View childAt = a.this.mListView.getChildAt(0);
                    if (childAt == null) {
                        this.mScrolling = false;
                        return;
                    } else if (firstVisiblePosition == 0 && childAt.getTop() == paddingTop) {
                        this.mScrolling = false;
                        return;
                    } else {
                        this.fCh = a.this.fBz.b((a.this.fBv - max) / a.this.fBw, this.fCb);
                    }
                } else {
                    View childAt2 = a.this.mListView.getChildAt(lastVisiblePosition - firstVisiblePosition);
                    if (childAt2 == null) {
                        this.mScrolling = false;
                        return;
                    } else if (lastVisiblePosition == count - 1 && childAt2.getBottom() <= height + paddingTop) {
                        this.mScrolling = false;
                        return;
                    } else {
                        this.fCh = -a.this.fBz.b((min - a.this.fBu) / a.this.fBx, this.fCb);
                    }
                }
                this.fCc = SystemClock.uptimeMillis();
                this.fCe = (float) (this.fCc - this.fCb);
                this.fCd = Math.round(this.fCh * this.fCe);
                if (this.fCd >= 0) {
                    this.fCd = Math.min(height, this.fCd);
                    lastVisiblePosition = firstVisiblePosition;
                } else {
                    this.fCd = Math.max(-height, this.fCd);
                }
                View childAt3 = a.this.mListView.getChildAt(lastVisiblePosition - firstVisiblePosition);
                int top = childAt3.getTop() + this.fCd;
                if (lastVisiblePosition == 0 && top > paddingTop) {
                    top = paddingTop;
                }
                a.this.mBlockLayoutRequests = true;
                a.this.mListView.setSelectionFromTop(lastVisiblePosition, top - paddingTop);
                a.this.layoutChildren();
                a.this.mListView.invalidate();
                a.this.mBlockLayoutRequests = false;
                a.this.h(lastVisiblePosition, childAt3, false);
                this.fCb = this.fCc;
                a.this.mListView.post(this);
                return;
            }
            this.mScrolling = false;
        }
    }
}
