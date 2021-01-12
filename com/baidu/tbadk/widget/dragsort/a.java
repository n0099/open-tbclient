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
    private int cHF;
    private int cHG;
    private int cIc;
    private int cId;
    private int dub;
    private View fNF;
    private int fNI;
    private int fNM;
    private int fNN;
    private int fNO;
    private int fNQ;
    private int fNR;
    private int fNS;
    private b fNT;
    private g fNU;
    private l fNV;
    private int fNX;
    private d fNZ;
    private f fOA;
    private boolean fOB;
    private com.baidu.tbadk.widget.dragsort.d fOD;
    private com.baidu.tbadk.widget.dragsort.b fOE;
    private int fOc;
    private int fOd;
    private float fOe;
    private float fOf;
    private float fOg;
    private float fOh;
    private int fOk;
    private MotionEvent fOp;
    private C0586a fOt;
    private e fOv;
    private k fOy;
    private j fOz;
    private int mLastX;
    private int mLastY;
    private ListView mListView;
    private DataSetObserver mObserver;
    private Point fNG = new Point();
    private Point fNH = new Point();
    private boolean fNJ = false;
    private float fNK = 1.0f;
    private float fNL = 1.0f;
    private boolean fNP = false;
    private boolean dOI = true;
    private int mDragState = 0;
    private int fNW = 1;
    private int mWidthMeasureSpec = 0;
    private View[] fNY = new View[1];
    private float fOa = 0.33333334f;
    private float fOb = 0.33333334f;
    private float fOi = 0.5f;
    private c fOj = new c() { // from class: com.baidu.tbadk.widget.dragsort.a.1
        @Override // com.baidu.tbadk.widget.dragsort.a.c
        public float b(float f2, long j2) {
            return a.this.fOi * f2;
        }
    };
    private int fOl = 0;
    private boolean fOm = false;
    private boolean fOn = false;
    private h fOo = null;
    private int fOq = 0;
    private float fOr = 0.25f;
    private float fOs = 0.0f;
    private boolean fOu = false;
    private boolean mBlockLayoutRequests = false;
    private boolean fOw = false;
    private i fOx = new i(3);
    private float fOC = 0.0f;
    private boolean fOF = false;
    private boolean fOG = false;

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

        View rJ(int i);
    }

    /* loaded from: classes.dex */
    public interface l {
        void remove(int i);
    }

    public a(ListView listView, com.baidu.tbadk.widget.dragsort.d dVar) {
        this.fOD = dVar;
        this.mListView = listView;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            this.fOt = new C0586a(listAdapter);
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
            this.fOt = null;
        }
        this.fOD.setAdapter(this.fOt);
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
            if (i2 > this.fNQ) {
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
    public int rF(int i2) {
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        return childAt != null ? childAt.getHeight() : bm(i2, rH(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bk(int i2, int i3) {
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        if (i2 <= headerViewsCount || i2 >= this.mListView.getCount() - footerViewsCount) {
            return i3;
        }
        int dividerHeight = this.mListView.getDividerHeight();
        int i4 = this.dub - this.fNW;
        int rH = rH(i2);
        int rF = rF(i2);
        if (this.fNO <= this.fNQ) {
            if (i2 == this.fNO && this.fNN != this.fNO) {
                if (i2 == this.fNQ) {
                    i3 = (i3 + rF) - this.dub;
                } else {
                    i3 = ((rF - rH) + i3) - i4;
                }
            } else if (i2 > this.fNO && i2 <= this.fNQ) {
                i3 -= i4;
            }
        } else if (i2 > this.fNQ && i2 <= this.fNN) {
            i3 += i4;
        } else if (i2 == this.fNO && this.fNN != this.fNO) {
            i3 += rF - rH;
        }
        if (i2 <= this.fNQ) {
            return (((this.dub - dividerHeight) - rH(i2 - 1)) / 2) + i3;
        }
        return (((rH - dividerHeight) - this.dub) / 2) + i3;
    }

    private boolean bGc() {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int i9 = this.fNN;
        View childAt = this.mListView.getChildAt(i9 - firstVisiblePosition);
        if (childAt == null) {
            i9 = firstVisiblePosition + (this.mListView.getChildCount() / 2);
            childAt = this.mListView.getChildAt(i9 - firstVisiblePosition);
        }
        int top = childAt.getTop();
        int height = childAt.getHeight();
        int bk = bk(i9, top);
        int dividerHeight = this.mListView.getDividerHeight();
        if (this.fNI < bk) {
            int i10 = top;
            i2 = i9;
            i3 = bk;
            i4 = bk;
            while (i2 >= 0) {
                i2--;
                int rF = rF(i2);
                if (i2 == 0) {
                    i5 = (i10 - dividerHeight) - rF;
                    i6 = i3;
                    break;
                }
                int i11 = i10 - (rF + dividerHeight);
                i5 = bk(i2, i11);
                if (this.fNI >= i5) {
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
                int rF2 = rF(i2 + 1);
                i5 = bk(i2 + 1, i13);
                if (this.fNI < i5) {
                    i6 = i3;
                    break;
                }
                i2++;
                i12 = i13;
                i3 = i5;
                i4 = i5;
                height = rF2;
            }
            i6 = i3;
            i5 = i4;
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int i14 = this.fNN;
        int i15 = this.fNO;
        float f2 = this.fOs;
        if (this.fNP) {
            int abs = Math.abs(i5 - i6);
            if (this.fNI < i5) {
                i7 = i5;
                i8 = i6;
            } else {
                i7 = i6;
                i8 = i5;
            }
            int i16 = (int) (this.fOr * 0.5f * abs);
            float f3 = i16;
            int i17 = i8 + i16;
            int i18 = i7 - i16;
            if (this.fNI < i17) {
                this.fNN = i2 - 1;
                this.fNO = i2;
                this.fOs = ((i17 - this.fNI) * 0.5f) / f3;
            } else if (this.fNI < i18) {
                this.fNN = i2;
                this.fNO = i2;
            } else {
                this.fNN = i2;
                this.fNO = i2 + 1;
                this.fOs = (1.0f + ((i7 - this.fNI) / f3)) * 0.5f;
            }
        } else {
            this.fNN = i2;
            this.fNO = i2;
        }
        if (this.fNN < headerViewsCount) {
            this.fNN = headerViewsCount;
            this.fNO = headerViewsCount;
            i2 = headerViewsCount;
        } else if (this.fNO >= this.mListView.getCount() - footerViewsCount) {
            i2 = (this.mListView.getCount() - footerViewsCount) - 1;
            this.fNN = i2;
            this.fNO = i2;
        }
        boolean z = (this.fNN == i14 && this.fNO == i15 && this.fOs == f2) ? false : true;
        if (i2 != this.fNM) {
            if (this.fNT != null) {
                this.fNT.drag(this.fNM - headerViewsCount, i2 - headerViewsCount);
            }
            this.fNM = i2;
            return true;
        }
        return z;
    }

    public void removeItem(int i2) {
        this.fOB = false;
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
            this.fNW = Math.max(1, obtainStyledAttributes.getDimensionPixelSize(R.styleable.DragSort_collapsed_height, 1));
            this.fOu = obtainStyledAttributes.getBoolean(R.styleable.DragSort_track_drag_sort, false);
            if (this.fOu) {
                this.fOv = new e();
            }
            this.fNK = obtainStyledAttributes.getFloat(R.styleable.DragSort_float_alpha, this.fNK);
            this.fNL = this.fNK;
            this.dOI = obtainStyledAttributes.getBoolean(R.styleable.DragSort_drag_enabled, this.dOI);
            this.fOr = Math.max(0.0f, Math.min(1.0f, 1.0f - obtainStyledAttributes.getFloat(R.styleable.DragSort_slide_shuffle_speed, 0.75f)));
            this.fNP = this.fOr > 0.0f;
            setDragScrollStart(obtainStyledAttributes.getFloat(R.styleable.DragSort_drag_scroll_start, this.fOa));
            this.fOi = obtainStyledAttributes.getFloat(R.styleable.DragSort_max_drag_scroll_speed, this.fOi);
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
                bVar.lC(z);
                bVar.lB(z2);
                bVar.setBackgroundColor(color);
                this.fOo = bVar;
                a(bVar);
            }
            obtainStyledAttributes.recycle();
            i2 = i5;
            i3 = i4;
        }
        this.fNZ = new d();
        if (i3 > 0) {
            this.fOy = new k(0.5f, i3);
        }
        if (i2 > 0) {
            this.fOA = new f(0.5f, i2);
        }
        this.fOp = MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
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
        this.fOE = bVar;
        this.mListView.setOnTouchListener(bVar);
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void dispatchDraw(Canvas canvas) {
        float f2;
        this.fOD.dispatchDraw(canvas);
        if (this.mDragState != 0) {
            if (this.fNN != this.fNQ) {
                c(this.fNN, canvas);
            }
            if (this.fNO != this.fNN && this.fNO != this.fNQ) {
                c(this.fNO, canvas);
            }
        }
        if (this.fNF != null) {
            int width = this.fNF.getWidth();
            int height = this.fNF.getHeight();
            int i2 = this.fNG.x;
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
            int i3 = (int) (f2 * 255.0f * this.fNL);
            canvas.save();
            canvas.translate(this.fNG.x, this.fNG.y);
            canvas.clipRect(0, 0, width, height);
            canvas.saveLayerAlpha(0.0f, 0.0f, width, height, i3, 31);
            this.fNF.draw(canvas);
            canvas.restore();
            canvas.restore();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onDraw(Canvas canvas) {
        this.fOD.onDraw(canvas);
        if (this.fOu) {
            this.fOv.bGq();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.fOw) {
            this.fOw = false;
            return false;
        } else if (!this.dOI) {
            return this.fOD.onTouchEvent(motionEvent);
        } else {
            boolean z2 = this.fOm;
            this.fOm = false;
            if (!z2) {
                G(motionEvent);
            }
            if (this.mDragState == 4) {
                onDragTouchEvent(motionEvent);
                return true;
            }
            if (this.mDragState == 0 && this.fOD.onTouchEvent(motionEvent)) {
                z = true;
            }
            switch (motionEvent.getAction() & 255) {
                case 1:
                case 3:
                    bGh();
                    return z;
                case 2:
                default:
                    if (z) {
                        this.fOq = 1;
                        return z;
                    }
                    return z;
            }
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (!this.dOI) {
            return this.fOD.onInterceptTouchEvent(motionEvent);
        }
        if (this.fOE != null) {
            this.fOE.bGs().onTouchEvent(motionEvent);
        }
        G(motionEvent);
        this.fOm = true;
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            if (this.mDragState != 0) {
                this.fOw = true;
                return true;
            }
            this.fOn = true;
        }
        if (this.fNF == null) {
            if (this.fOD.onInterceptTouchEvent(motionEvent)) {
                this.fOF = true;
                z = true;
            } else {
                z = false;
            }
            switch (action) {
                case 1:
                case 3:
                    bGh();
                    break;
                case 2:
                default:
                    if (z) {
                        this.fOq = 1;
                        break;
                    } else {
                        this.fOq = 2;
                        break;
                    }
            }
        } else {
            z = true;
        }
        if (action == 1 || action == 3) {
            this.fOn = false;
        }
        return z;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        this.fOD.onSizeChanged(i2, i3, i4, i5);
        bGi();
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void requestLayout() {
        if (!this.mBlockLayoutRequests) {
            this.fOD.requestLayout();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onMeasure(int i2, int i3) {
        this.fOD.onMeasure(i2, i3);
        if (this.fNF != null) {
            if (this.fNF.isLayoutRequested()) {
                bGk();
            }
            this.fNJ = true;
        }
        this.mWidthMeasureSpec = i2;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void layoutChildren() {
        this.fOD.layoutChildren();
        if (this.fNF != null) {
            if (this.fNF.isLayoutRequested() && !this.fNJ) {
                bGk();
            }
            this.fNF.layout(0, 0, this.fNF.getMeasuredWidth(), this.fNF.getMeasuredHeight());
            this.fNJ = false;
        }
    }

    public void removeItem(int i2, float f2) {
        if (this.mDragState == 0 || this.mDragState == 4) {
            if (this.mDragState == 0) {
                this.fNQ = this.mListView.getHeaderViewsCount() + i2;
                this.fNN = this.fNQ;
                this.fNO = this.fNQ;
                this.fNM = this.fNQ;
                View childAt = this.mListView.getChildAt(this.fNQ - this.mListView.getFirstVisiblePosition());
                if (childAt != null) {
                    childAt.setVisibility(4);
                }
            }
            this.mDragState = 1;
            this.fOC = f2;
            if (this.fOn) {
                switch (this.fOq) {
                    case 1:
                        this.fOD.onTouchEvent(this.fOp);
                        break;
                    case 2:
                        this.fOD.onInterceptTouchEvent(this.fOp);
                        break;
                }
            }
            if (this.fOy != null) {
                this.fOy.start();
            } else {
                rG(i2);
            }
        }
    }

    public void cancelDrag() {
        if (this.mDragState == 4) {
            this.fNZ.lA(true);
            bGm();
            bGd();
            bGj();
            if (this.fOn) {
                this.mDragState = 3;
            } else {
                this.mDragState = 0;
            }
        }
    }

    private void bGd() {
        this.fNQ = -1;
        this.fNN = -1;
        this.fNO = -1;
        this.fNM = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGe() {
        this.mDragState = 2;
        if (this.fNU != null && this.fNM >= 0 && this.fNM < this.mListView.getCount()) {
            int headerViewsCount = this.mListView.getHeaderViewsCount();
            this.fNU.drop(this.fNQ - headerViewsCount, this.fNM - headerViewsCount);
        }
        bGm();
        bGg();
        bGd();
        bGj();
        if (this.fOn) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGf() {
        rG(this.fNQ - this.mListView.getHeaderViewsCount());
    }

    private void rG(int i2) {
        this.mDragState = 1;
        if (this.fNV != null) {
            this.fNV.remove(i2);
        }
        bGm();
        bGg();
        bGd();
        if (this.fOn) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    private void bGg() {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        if (this.fNQ < firstVisiblePosition) {
            View childAt = this.mListView.getChildAt(0);
            this.mListView.setSelectionFromTop(firstVisiblePosition - 1, (childAt != null ? childAt.getTop() : 0) - this.mListView.getPaddingTop());
        }
    }

    public boolean stopDrag(boolean z) {
        this.fOB = false;
        return stopDrag(z, 0.0f);
    }

    public boolean stopDragWithVelocity(boolean z, float f2) {
        this.fOB = true;
        return stopDrag(z, f2);
    }

    public boolean stopDrag(boolean z, float f2) {
        if (this.fNF != null) {
            this.fNZ.lA(true);
            if (z) {
                removeItem(this.fNQ - this.mListView.getHeaderViewsCount(), f2);
            } else if (this.fOA != null) {
                this.fOA.start();
            } else {
                bGe();
            }
            if (this.fOu) {
                this.fOv.stopTracking();
                return true;
            }
            return true;
        }
        return false;
    }

    private void bGh() {
        this.fOq = 0;
        this.fOn = false;
        if (this.mDragState == 3) {
            this.mDragState = 0;
        }
        this.fNL = this.fNK;
        this.fOF = false;
        this.fOx.clear();
    }

    private void G(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            this.mLastX = this.cHF;
            this.mLastY = this.cHG;
        }
        this.cHF = (int) motionEvent.getX();
        this.cHG = (int) motionEvent.getY();
        if (action == 0) {
            this.mLastX = this.cHF;
            this.mLastY = this.cHG;
        }
        this.cIc = ((int) motionEvent.getRawX()) - this.cHF;
        this.cId = ((int) motionEvent.getRawY()) - this.cHG;
    }

    public boolean listViewIntercepted() {
        return this.fOF;
    }

    public void setDragScrollStart(float f2) {
        setDragScrollStarts(f2, f2);
    }

    public void setDragScrollStarts(float f2, float f3) {
        if (f3 > 0.5f) {
            this.fOb = 0.5f;
        } else {
            this.fOb = f3;
        }
        if (f2 > 0.5f) {
            this.fOa = 0.5f;
        } else {
            this.fOa = f2;
        }
        if (this.mListView.getHeight() != 0) {
            bGi();
        }
    }

    private void bl(int i2, int i3) {
        this.fNG.x = i2 - this.fNR;
        this.fNG.y = i3 - this.fNS;
        lz(true);
        int min = Math.min(i3, this.fNI + this.fNX);
        int max = Math.max(i3, this.fNI - this.fNX);
        int bGo = this.fNZ.bGo();
        if (min > this.mLastY && min > this.fOd && bGo != 1) {
            if (bGo != -1) {
                this.fNZ.lA(true);
            }
            this.fNZ.rI(1);
        } else if (max < this.mLastY && max < this.fOc && bGo != 0) {
            if (bGo != -1) {
                this.fNZ.lA(true);
            }
            this.fNZ.rI(0);
        } else if (max >= this.fOc && min <= this.fOd && this.fNZ.bGn()) {
            this.fNZ.lA(true);
        }
    }

    private void bGi() {
        int height;
        int paddingTop = this.mListView.getPaddingTop();
        float height2 = (this.mListView.getHeight() - paddingTop) - this.mListView.getPaddingBottom();
        this.fOf = paddingTop + (this.fOa * height2);
        this.fOe = (height2 * (1.0f - this.fOb)) + paddingTop;
        this.fOc = (int) this.fOf;
        this.fOd = (int) this.fOe;
        this.fOg = this.fOf - paddingTop;
        this.fOh = (paddingTop + height) - this.fOe;
    }

    private void bGj() {
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
        if (i2 != this.fNQ && i2 != this.fNN && i2 != this.fNO) {
            g2 = -2;
        } else {
            g2 = g(i2, view, z);
        }
        if (g2 != layoutParams.height) {
            layoutParams.height = g2;
            view.setLayoutParams(layoutParams);
        }
        if (i2 == this.fNN || i2 == this.fNO) {
            if (i2 < this.fNQ) {
                ((DragSortItemView) view).setGravity(80);
            } else if (i2 > this.fNQ) {
                ((DragSortItemView) view).setGravity(48);
            }
        }
        int visibility = view.getVisibility();
        int i3 = 0;
        if (i2 == this.fNQ && this.fNF != null) {
            i3 = 4;
        }
        if (i3 != visibility) {
            view.setVisibility(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int rH(int i2) {
        View view;
        if (i2 == this.fNQ) {
            return 0;
        }
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        if (childAt != null) {
            return f(i2, childAt, false);
        }
        int i3 = this.fOx.get(i2);
        if (i3 == -1) {
            ListAdapter adapter = this.mListView.getAdapter();
            int itemViewType = adapter.getItemViewType(i2);
            int viewTypeCount = adapter.getViewTypeCount();
            if (viewTypeCount != this.fNY.length) {
                this.fNY = new View[viewTypeCount];
            }
            if (itemViewType >= 0) {
                if (this.fNY[itemViewType] == null) {
                    view = adapter.getView(i2, null, this.mListView);
                    this.fNY[itemViewType] = view;
                } else {
                    view = adapter.getView(i2, this.fNY[itemViewType], this.mListView);
                }
            } else {
                view = adapter.getView(i2, null, this.mListView);
            }
            int f2 = f(i2, view, true);
            this.fOx.bn(i2, f2);
            return f2;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(int i2, View view, boolean z) {
        if (i2 == this.fNQ) {
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
        boolean z = this.fNP && this.fNN != this.fNO;
        int i4 = this.dub - this.fNW;
        int i5 = (int) (this.fOs * i4);
        if (i2 == this.fNQ) {
            if (this.fNQ == this.fNN) {
                if (z) {
                    return i5 + this.fNW;
                }
                return this.dub;
            } else if (this.fNQ == this.fNO) {
                return this.dub - i5;
            } else {
                return this.fNW;
            }
        } else if (i2 == this.fNN) {
            if (z) {
                return i3 + i5;
            }
            return i3 + i4;
        } else if (i2 == this.fNO) {
            return (i3 + i4) - i5;
        } else {
            return i3;
        }
    }

    private int b(int i2, View view, int i3, int i4) {
        int i5;
        int i6;
        int rH = rH(i2);
        int height = view.getHeight();
        int bm = bm(i2, rH);
        if (i2 != this.fNQ) {
            i6 = height - rH;
            i5 = bm - rH;
        } else {
            i5 = bm;
            i6 = height;
        }
        int i7 = this.dub;
        if (this.fNQ != this.fNN && this.fNQ != this.fNO) {
            i7 -= this.fNW;
        }
        if (i2 <= i3) {
            if (i2 > this.fNN) {
                return (i7 - i5) + 0;
            }
        } else if (i2 == i4) {
            if (i2 <= this.fNN) {
                return (i6 - i7) + 0;
            }
            if (i2 == this.fNO) {
                return (height - bm) + 0;
            }
            return 0 + i6;
        } else if (i2 <= this.fNN) {
            return 0 - i7;
        } else {
            if (i2 == this.fNO) {
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

    private void bGk() {
        if (this.fNF != null) {
            measureItem(this.fNF);
            this.dub = this.fNF.getMeasuredHeight();
            this.fNX = this.dub / 2;
        }
    }

    protected boolean onDragTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        switch (motionEvent.getAction() & 255) {
            case 1:
                if (this.mDragState == 4) {
                    stopDrag(false);
                }
                bGh();
                return true;
            case 2:
                bl((int) motionEvent.getX(), (int) motionEvent.getY());
                return true;
            case 3:
                if (this.mDragState == 4) {
                    cancelDrag();
                }
                bGh();
                return true;
            default:
                return true;
        }
    }

    public boolean startDrag(int i2, int i3, int i4, int i5) {
        View rJ;
        if (!this.fOn || this.fOo == null || (rJ = this.fOo.rJ(i2)) == null) {
            return false;
        }
        return startDrag(i2, rJ, i3, i4, i5);
    }

    public boolean startDrag(int i2, View view, int i3, int i4, int i5) {
        if (this.mDragState == 0 && this.fOn && this.fNF == null && view != null && this.dOI) {
            if (this.mListView.getParent() != null) {
                this.mListView.getParent().requestDisallowInterceptTouchEvent(true);
            }
            int headerViewsCount = this.mListView.getHeaderViewsCount() + i2;
            this.fNN = headerViewsCount;
            this.fNO = headerViewsCount;
            this.fNQ = headerViewsCount;
            this.fNM = headerViewsCount;
            this.mDragState = 4;
            this.fOl = 0;
            this.fOl |= i3;
            this.fNF = view;
            bGk();
            this.fNR = i4;
            this.fNS = i5;
            this.fOk = this.cHG;
            this.fNG.x = this.cHF - this.fNR;
            this.fNG.y = this.cHG - this.fNS;
            View childAt = this.mListView.getChildAt(this.fNQ - this.mListView.getFirstVisiblePosition());
            if (childAt != null) {
                childAt.setVisibility(4);
            }
            if (this.fOu) {
                this.fOv.bGp();
            }
            switch (this.fOq) {
                case 1:
                    this.fOD.onTouchEvent(this.fOp);
                    break;
                case 2:
                    this.fOD.onInterceptTouchEvent(this.fOp);
                    break;
            }
            this.mListView.requestLayout();
            if (this.fOz != null) {
                this.fOz.start();
                return true;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lz(boolean z) {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition() + (this.mListView.getChildCount() / 2);
        View childAt = this.mListView.getChildAt(this.mListView.getChildCount() / 2);
        if (childAt != null) {
            h(firstVisiblePosition, childAt, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i2, View view, boolean z) {
        this.mBlockLayoutRequests = true;
        bGl();
        int i3 = this.fNN;
        int i4 = this.fNO;
        boolean bGc = bGc();
        if (bGc) {
            bGj();
            this.mListView.setSelectionFromTop(i2, (b(i2, view, i3, i4) + view.getTop()) - this.mListView.getPaddingTop());
            layoutChildren();
        }
        if (bGc || z) {
            this.mListView.invalidate();
        }
        this.mBlockLayoutRequests = false;
    }

    private void bGl() {
        if (this.fOo != null) {
            this.fNH.set(this.cHF, this.cHG);
            this.fOo.b(this.fNF, this.fNG, this.fNH);
        }
        int i2 = this.fNG.x;
        int i3 = this.fNG.y;
        int paddingLeft = this.mListView.getPaddingLeft();
        if ((this.fOl & 1) == 0 && i2 > paddingLeft) {
            this.fNG.x = paddingLeft;
        } else if ((this.fOl & 2) == 0 && i2 < paddingLeft) {
            this.fNG.x = paddingLeft;
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int lastVisiblePosition = this.mListView.getLastVisiblePosition();
        int paddingTop = this.mListView.getPaddingTop();
        if (firstVisiblePosition < headerViewsCount) {
            paddingTop = this.mListView.getChildAt((headerViewsCount - firstVisiblePosition) - 1).getBottom();
        }
        if ((this.fOl & 8) == 0 && firstVisiblePosition <= this.fNQ) {
            paddingTop = Math.max(this.mListView.getChildAt(this.fNQ - firstVisiblePosition).getTop(), paddingTop);
        }
        int height = this.mListView.getHeight() - this.mListView.getPaddingBottom();
        if (lastVisiblePosition >= (this.mListView.getCount() - footerViewsCount) - 1) {
            height = this.mListView.getChildAt(((this.mListView.getCount() - footerViewsCount) - 1) - firstVisiblePosition).getBottom();
        }
        if ((this.fOl & 4) == 0 && lastVisiblePosition >= this.fNQ) {
            height = Math.min(this.mListView.getChildAt(this.fNQ - firstVisiblePosition).getBottom(), height);
        }
        if (i3 < paddingTop) {
            this.fNG.y = paddingTop;
        } else if (this.dub + i3 > height) {
            this.fNG.y = height - this.dub;
        }
        this.fNI = this.fNG.y + this.fNX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGm() {
        if (this.fNF != null) {
            this.fNF.setVisibility(8);
            if (this.fOo != null) {
                this.fOo.ca(this.fNF);
            }
            this.fNF = null;
            this.mListView.invalidate();
        }
    }

    public void a(h hVar) {
        this.fOo = hVar;
    }

    public void a(b bVar) {
        this.fNT = bVar;
    }

    public void setDragEnabled(boolean z) {
        this.dOI = z;
    }

    public boolean isDragEnabled() {
        return this.dOI;
    }

    public void a(g gVar) {
        this.fNU = gVar;
    }

    public void a(l lVar) {
        this.fNV = lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class i {
        private SparseIntArray fPa;
        private ArrayList<Integer> fPb;
        private int mMaxSize;

        public i(int i) {
            this.fPa = new SparseIntArray(i);
            this.fPb = new ArrayList<>(i);
            this.mMaxSize = i;
        }

        public void bn(int i, int i2) {
            int i3 = this.fPa.get(i, -1);
            if (i3 != i2) {
                if (i3 == -1) {
                    if (this.fPa.size() == this.mMaxSize) {
                        this.fPa.delete(this.fPb.remove(0).intValue());
                    }
                } else {
                    this.fPb.remove(Integer.valueOf(i));
                }
                this.fPa.put(i, i2);
                this.fPb.add(Integer.valueOf(i));
            }
        }

        public int get(int i) {
            return this.fPa.get(i, -1);
        }

        public void clear() {
            this.fPa.clear();
            this.fPb.clear();
        }
    }

    /* renamed from: com.baidu.tbadk.widget.dragsort.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0586a extends BaseAdapter {
        private ListAdapter mAdapter;

        public C0586a(ListAdapter listAdapter) {
            this.mAdapter = listAdapter;
            this.mAdapter.registerDataSetObserver(new DataSetObserver() { // from class: com.baidu.tbadk.widget.dragsort.a.a.1
                @Override // android.database.DataSetObserver
                public void onChanged() {
                    C0586a.this.notifyDataSetChanged();
                }

                @Override // android.database.DataSetObserver
                public void onInvalidated() {
                    C0586a.this.notifyDataSetInvalidated();
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
        private float cHX;
        private float cHY;
        private float cHZ;
        private float cIa;
        private float fPl;
        private float mAlpha;
        private boolean mCanceled;
        protected long mStartTime;

        public m(float f, int i) {
            this.mAlpha = f;
            this.fPl = i;
            float f2 = 1.0f / ((this.mAlpha * 2.0f) * (1.0f - this.mAlpha));
            this.cIa = f2;
            this.cHX = f2;
            this.cHY = this.mAlpha / ((this.mAlpha - 1.0f) * 2.0f);
            this.cHZ = 1.0f / (1.0f - this.mAlpha);
        }

        public float aq(float f) {
            if (f < this.mAlpha) {
                return this.cHX * f * f;
            }
            if (f < 1.0f - this.mAlpha) {
                return this.cHY + (this.cHZ * f);
            }
            return 1.0f - ((this.cIa * (f - 1.0f)) * (f - 1.0f));
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
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / this.fPl;
                if (uptimeMillis >= 1.0f) {
                    y(1.0f, 1.0f);
                    onStop();
                    return;
                }
                y(uptimeMillis, aq(uptimeMillis));
                a.this.mListView.post(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class f extends m {
        private int fOW;
        private int fOX;
        private float fOY;
        private float fOZ;

        public f(float f, int i) {
            super(f, i);
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.fOW = a.this.fNM;
            this.fOX = a.this.fNQ;
            a.this.mDragState = 2;
            this.fOY = a.this.fNG.y - bGr();
            this.fOZ = a.this.fNG.x - a.this.mListView.getPaddingLeft();
        }

        private int bGr() {
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            int dividerHeight = (a.this.fNW + a.this.mListView.getDividerHeight()) / 2;
            View childAt = a.this.mListView.getChildAt(this.fOW - firstVisiblePosition);
            if (childAt != null) {
                if (this.fOW == this.fOX) {
                    return childAt.getTop();
                }
                if (this.fOW >= this.fOX) {
                    return (childAt.getBottom() + dividerHeight) - a.this.dub;
                }
                return childAt.getTop() - dividerHeight;
            }
            cancel();
            return -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void y(float f, float f2) {
            int bGr = bGr();
            float paddingLeft = a.this.fNG.x - a.this.mListView.getPaddingLeft();
            float f3 = 1.0f - f2;
            if (f3 < Math.abs((a.this.fNG.y - bGr) / this.fOY) || f3 < Math.abs(paddingLeft / this.fOZ)) {
                a.this.fNG.y = bGr + ((int) (this.fOY * f3));
                a.this.fNG.x = a.this.mListView.getPaddingLeft() + ((int) (this.fOZ * f3));
                a.this.lz(true);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.bGe();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class k extends m {
        private int fOX;
        private float fPe;
        private float fPf;
        private float fPg;
        private int fPh;
        private int fPi;
        private int fPj;
        private int fPk;

        public k(float f, int i) {
            super(f, i);
            this.fPh = -1;
            this.fPi = -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.fPh = -1;
            this.fPi = -1;
            this.fPj = a.this.fNN;
            this.fPk = a.this.fNO;
            this.fOX = a.this.fNQ;
            a.this.mDragState = 1;
            this.fPe = a.this.fNG.x;
            if (a.this.fOB) {
                float width = a.this.mListView.getWidth() * 2.0f;
                if (a.this.fOC == 0.0f) {
                    a.this.fOC = (this.fPe >= 0.0f ? 1 : -1) * width;
                    return;
                }
                float f = width * 2.0f;
                if (a.this.fOC >= 0.0f || a.this.fOC <= (-f)) {
                    if (a.this.fOC > 0.0f && a.this.fOC < f) {
                        a.this.fOC = f;
                        return;
                    }
                    return;
                }
                a.this.fOC = -f;
                return;
            }
            a.this.bGm();
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void y(float f, float f2) {
            View childAt;
            float f3 = 1.0f - f2;
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            View childAt2 = a.this.mListView.getChildAt(this.fPj - firstVisiblePosition);
            if (a.this.fOB) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / 1000.0f;
                if (uptimeMillis != 0.0f) {
                    float f4 = a.this.fOC * uptimeMillis;
                    int width = a.this.mListView.getWidth();
                    a.this.fOC = ((a.this.fOC > 0.0f ? 1 : -1) * uptimeMillis * width) + a.this.fOC;
                    this.fPe += f4;
                    a.this.fNG.x = (int) this.fPe;
                    if (this.fPe < width && this.fPe > (-width)) {
                        this.mStartTime = SystemClock.uptimeMillis();
                        a.this.lz(true);
                        return;
                    }
                } else {
                    return;
                }
            }
            if (childAt2 != null) {
                if (this.fPh == -1) {
                    this.fPh = a.this.f(this.fPj, childAt2, false);
                    this.fPf = childAt2.getHeight() - this.fPh;
                }
                int max = Math.max((int) (this.fPf * f3), 1);
                ViewGroup.LayoutParams layoutParams = childAt2.getLayoutParams();
                layoutParams.height = max + this.fPh;
                childAt2.setLayoutParams(layoutParams);
            }
            if (this.fPk != this.fPj && (childAt = a.this.mListView.getChildAt(this.fPk - firstVisiblePosition)) != null) {
                if (this.fPi == -1) {
                    this.fPi = a.this.f(this.fPk, childAt, false);
                    this.fPg = childAt.getHeight() - this.fPi;
                }
                int max2 = Math.max((int) (this.fPg * f3), 1);
                ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
                layoutParams2.height = max2 + this.fPi;
                childAt.setLayoutParams(layoutParams2);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.bGf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class j extends m {
        final /* synthetic */ a fOH;
        private float fPc;
        private float fPd;

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.fPc = this.fOH.fNS;
            this.fPd = this.fOH.fNX;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void y(float f, float f2) {
            if (this.fOH.mDragState != 4) {
                cancel();
                return;
            }
            this.fOH.fNS = (int) ((this.fPd * f2) + ((1.0f - f2) * this.fPc));
            this.fOH.fNG.y = this.fOH.cHG - this.fOH.fNS;
            this.fOH.lz(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e {
        StringBuilder mBuilder = new StringBuilder();
        private int fOT = 0;
        private int fOU = 0;
        private boolean fOV = false;
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

        public void bGp() {
            this.mBuilder.append("<DSLVStates>\n");
            this.fOU = 0;
            this.fOV = true;
        }

        public void bGq() {
            if (this.fOV) {
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
                this.mBuilder.append("    <FirstExpPos>").append(a.this.fNN).append("</FirstExpPos>\n");
                this.mBuilder.append("    <FirstExpBlankHeight>").append(a.this.rF(a.this.fNN) - a.this.rH(a.this.fNN)).append("</FirstExpBlankHeight>\n");
                this.mBuilder.append("    <SecondExpPos>").append(a.this.fNO).append("</SecondExpPos>\n");
                this.mBuilder.append("    <SecondExpBlankHeight>").append(a.this.rF(a.this.fNO) - a.this.rH(a.this.fNO)).append("</SecondExpBlankHeight>\n");
                this.mBuilder.append("    <SrcPos>").append(a.this.fNQ).append("</SrcPos>\n");
                this.mBuilder.append("    <SrcHeight>").append(a.this.dub + a.this.mListView.getDividerHeight()).append("</SrcHeight>\n");
                this.mBuilder.append("    <ViewHeight>").append(a.this.mListView.getHeight()).append("</ViewHeight>\n");
                this.mBuilder.append("    <LastY>").append(a.this.mLastY).append("</LastY>\n");
                this.mBuilder.append("    <FloatY>").append(a.this.fNI).append("</FloatY>\n");
                this.mBuilder.append("    <ShuffleEdges>");
                for (int i4 = 0; i4 < childCount; i4++) {
                    this.mBuilder.append(a.this.bk(firstVisiblePosition + i4, a.this.mListView.getChildAt(i4).getTop())).append(",");
                }
                this.mBuilder.append("</ShuffleEdges>\n");
                this.mBuilder.append("</DSLVState>\n");
                this.fOT++;
                if (this.fOT > 1000) {
                    flush();
                    this.fOT = 0;
                }
            }
        }

        public void flush() {
            if (this.fOV) {
                try {
                    FileWriter fileWriter = new FileWriter(this.mFile, this.fOU != 0);
                    fileWriter.write(this.mBuilder.toString());
                    this.mBuilder.delete(0, this.mBuilder.length());
                    fileWriter.flush();
                    fileWriter.close();
                    this.fOU++;
                } catch (IOException e) {
                }
            }
        }

        public void stopTracking() {
            if (this.fOV) {
                this.mBuilder.append("</DSLVStates>\n");
                flush();
                this.fOV = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements Runnable {
        private boolean fOK;
        private long fOL;
        private long fOM;
        private int fON;
        private float fOO;
        private long fOP;
        private int fOQ;
        private float fOR;
        private boolean fOS = false;

        public boolean bGn() {
            return this.fOS;
        }

        public int bGo() {
            if (this.fOS) {
                return this.fOQ;
            }
            return -1;
        }

        public d() {
        }

        public void rI(int i) {
            if (!this.fOS) {
                this.fOK = false;
                this.fOS = true;
                this.fOP = SystemClock.uptimeMillis();
                this.fOL = this.fOP;
                this.fOQ = i;
                a.this.mListView.post(this);
            }
        }

        public void lA(boolean z) {
            if (z) {
                a.this.mListView.removeCallbacks(this);
                this.fOS = false;
                return;
            }
            this.fOK = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.fOK) {
                int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
                int lastVisiblePosition = a.this.mListView.getLastVisiblePosition();
                int count = a.this.mListView.getCount();
                int paddingTop = a.this.mListView.getPaddingTop();
                int height = (a.this.mListView.getHeight() - paddingTop) - a.this.mListView.getPaddingBottom();
                int min = Math.min(a.this.cHG, a.this.fNI + a.this.fNX);
                int max = Math.max(a.this.cHG, a.this.fNI - a.this.fNX);
                if (this.fOQ == 0) {
                    View childAt = a.this.mListView.getChildAt(0);
                    if (childAt == null) {
                        this.fOS = false;
                        return;
                    } else if (firstVisiblePosition == 0 && childAt.getTop() == paddingTop) {
                        this.fOS = false;
                        return;
                    } else {
                        this.fOR = a.this.fOj.b((a.this.fOf - max) / a.this.fOg, this.fOL);
                    }
                } else {
                    View childAt2 = a.this.mListView.getChildAt(lastVisiblePosition - firstVisiblePosition);
                    if (childAt2 == null) {
                        this.fOS = false;
                        return;
                    } else if (lastVisiblePosition == count - 1 && childAt2.getBottom() <= height + paddingTop) {
                        this.fOS = false;
                        return;
                    } else {
                        this.fOR = -a.this.fOj.b((min - a.this.fOe) / a.this.fOh, this.fOL);
                    }
                }
                this.fOM = SystemClock.uptimeMillis();
                this.fOO = (float) (this.fOM - this.fOL);
                this.fON = Math.round(this.fOR * this.fOO);
                if (this.fON >= 0) {
                    this.fON = Math.min(height, this.fON);
                    lastVisiblePosition = firstVisiblePosition;
                } else {
                    this.fON = Math.max(-height, this.fON);
                }
                View childAt3 = a.this.mListView.getChildAt(lastVisiblePosition - firstVisiblePosition);
                int top = childAt3.getTop() + this.fON;
                if (lastVisiblePosition == 0 && top > paddingTop) {
                    top = paddingTop;
                }
                a.this.mBlockLayoutRequests = true;
                a.this.mListView.setSelectionFromTop(lastVisiblePosition, top - paddingTop);
                a.this.layoutChildren();
                a.this.mListView.invalidate();
                a.this.mBlockLayoutRequests = false;
                a.this.h(lastVisiblePosition, childAt3, false);
                this.fOL = this.fOM;
                a.this.mListView.post(this);
                return;
            }
            this.fOS = false;
        }
    }
}
