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
    private int cDa;
    private int eNA;
    private b eNB;
    private g eNC;
    private l eND;
    private int eNF;
    private d eNH;
    private int eNK;
    private int eNL;
    private float eNM;
    private float eNN;
    private float eNO;
    private float eNP;
    private int eNS;
    private MotionEvent eNX;
    private View eNn;
    private int eNq;
    private int eNu;
    private int eNv;
    private int eNw;
    private int eNy;
    private int eNz;
    private C0515a eOb;
    private e eOd;
    private k eOg;
    private j eOh;
    private f eOi;
    private boolean eOj;
    private com.baidu.tbadk.widget.dragsort.d eOl;
    private com.baidu.tbadk.widget.dragsort.b eOm;
    private int mLastX;
    private int mLastY;
    private ListView mListView;
    private DataSetObserver mObserver;
    private int mOffsetX;
    private int mOffsetY;
    private int mX;
    private int mY;
    private Point eNo = new Point();
    private Point eNp = new Point();
    private boolean eNr = false;
    private float eNs = 1.0f;
    private float eNt = 1.0f;
    private boolean eNx = false;
    private boolean cTN = true;
    private int mDragState = 0;
    private int eNE = 1;
    private int mWidthMeasureSpec = 0;
    private View[] eNG = new View[1];
    private float eNI = 0.33333334f;
    private float eNJ = 0.33333334f;
    private float eNQ = 0.5f;
    private c eNR = new c() { // from class: com.baidu.tbadk.widget.dragsort.a.1
        @Override // com.baidu.tbadk.widget.dragsort.a.c
        public float b(float f2, long j2) {
            return a.this.eNQ * f2;
        }
    };
    private int eNT = 0;
    private boolean eNU = false;
    private boolean eNV = false;
    private h eNW = null;
    private int eNY = 0;
    private float eNZ = 0.25f;
    private float eOa = 0.0f;
    private boolean eOc = false;
    private boolean mBlockLayoutRequests = false;
    private boolean eOe = false;
    private i eOf = new i(3);
    private float eOk = 0.0f;
    private boolean eOn = false;
    private boolean eOo = false;

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

        void bs(View view);

        View oH(int i);
    }

    /* loaded from: classes.dex */
    public interface l {
        void remove(int i);
    }

    public a(ListView listView, com.baidu.tbadk.widget.dragsort.d dVar) {
        this.eOl = dVar;
        this.mListView = listView;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            this.eOb = new C0515a(listAdapter);
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
            this.eOb = null;
        }
        this.eOl.setAdapter(this.eOb);
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
            if (i2 > this.eNy) {
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
    public int oD(int i2) {
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        return childAt != null ? childAt.getHeight() : bd(i2, oF(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bb(int i2, int i3) {
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        if (i2 <= headerViewsCount || i2 >= this.mListView.getCount() - footerViewsCount) {
            return i3;
        }
        int dividerHeight = this.mListView.getDividerHeight();
        int i4 = this.cDa - this.eNE;
        int oF = oF(i2);
        int oD = oD(i2);
        if (this.eNw <= this.eNy) {
            if (i2 == this.eNw && this.eNv != this.eNw) {
                if (i2 == this.eNy) {
                    i3 = (i3 + oD) - this.cDa;
                } else {
                    i3 = ((oD - oF) + i3) - i4;
                }
            } else if (i2 > this.eNw && i2 <= this.eNy) {
                i3 -= i4;
            }
        } else if (i2 > this.eNy && i2 <= this.eNv) {
            i3 += i4;
        } else if (i2 == this.eNw && this.eNv != this.eNw) {
            i3 += oD - oF;
        }
        if (i2 <= this.eNy) {
            return (((this.cDa - dividerHeight) - oF(i2 - 1)) / 2) + i3;
        }
        return (((oF - dividerHeight) - this.cDa) / 2) + i3;
    }

    private boolean bnG() {
        int i2;
        int i3;
        int i4;
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int i5 = this.eNv;
        View childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        if (childAt == null) {
            i5 = firstVisiblePosition + (this.mListView.getChildCount() / 2);
            childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        }
        int top = childAt.getTop();
        int height = childAt.getHeight();
        int bb = bb(i5, top);
        int dividerHeight = this.mListView.getDividerHeight();
        if (this.eNq >= bb) {
            int count = this.mListView.getCount();
            int i6 = height;
            int i7 = top;
            i2 = bb;
            i3 = i5;
            i4 = bb;
            while (true) {
                if (i3 < count) {
                    if (i3 == count - 1) {
                        i2 = i7 + dividerHeight + i6;
                        break;
                    }
                    i7 += dividerHeight + i6;
                    i6 = oD(i3 + 1);
                    i2 = bb(i3 + 1, i7);
                    if (this.eNq < i2) {
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
            i2 = bb;
            i3 = i5;
            i4 = bb;
            while (true) {
                if (i3 < 0) {
                    break;
                }
                i3--;
                int oD = oD(i3);
                if (i3 == 0) {
                    i2 = (i8 - dividerHeight) - oD;
                    break;
                }
                i8 -= oD + dividerHeight;
                i2 = bb(i3, i8);
                if (this.eNq >= i2) {
                    break;
                }
                i4 = i2;
            }
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int i9 = this.eNv;
        int i10 = this.eNw;
        float f2 = this.eOa;
        if (this.eNx) {
            int abs = Math.abs(i2 - i4);
            if (this.eNq >= i2) {
                int i11 = i4;
                i4 = i2;
                i2 = i11;
            }
            int i12 = (int) (abs * this.eNZ * 0.5f);
            float f3 = i12;
            int i13 = i4 + i12;
            int i14 = i2 - i12;
            if (this.eNq < i13) {
                this.eNv = i3 - 1;
                this.eNw = i3;
                this.eOa = ((i13 - this.eNq) * 0.5f) / f3;
            } else if (this.eNq < i14) {
                this.eNv = i3;
                this.eNw = i3;
            } else {
                this.eNv = i3;
                this.eNw = i3 + 1;
                this.eOa = (1.0f + ((i2 - this.eNq) / f3)) * 0.5f;
            }
        } else {
            this.eNv = i3;
            this.eNw = i3;
        }
        if (this.eNv < headerViewsCount) {
            this.eNv = headerViewsCount;
            this.eNw = headerViewsCount;
            i3 = headerViewsCount;
        } else if (this.eNw >= this.mListView.getCount() - footerViewsCount) {
            i3 = (this.mListView.getCount() - footerViewsCount) - 1;
            this.eNv = i3;
            this.eNw = i3;
        }
        boolean z = (this.eNv == i9 && this.eNw == i10 && this.eOa == f2) ? false : true;
        if (i3 != this.eNu) {
            if (this.eNB != null) {
                this.eNB.drag(this.eNu - headerViewsCount, i3 - headerViewsCount);
            }
            this.eNu = i3;
            return true;
        }
        return z;
    }

    public void removeItem(int i2) {
        this.eOj = false;
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
            this.eNE = Math.max(1, obtainStyledAttributes.getDimensionPixelSize(R.styleable.DragSort_collapsed_height, 1));
            this.eOc = obtainStyledAttributes.getBoolean(R.styleable.DragSort_track_drag_sort, false);
            if (this.eOc) {
                this.eOd = new e();
            }
            this.eNs = obtainStyledAttributes.getFloat(R.styleable.DragSort_float_alpha, this.eNs);
            this.eNt = this.eNs;
            this.cTN = obtainStyledAttributes.getBoolean(R.styleable.DragSort_drag_enabled, this.cTN);
            this.eNZ = Math.max(0.0f, Math.min(1.0f, 1.0f - obtainStyledAttributes.getFloat(R.styleable.DragSort_slide_shuffle_speed, 0.75f)));
            this.eNx = this.eNZ > 0.0f;
            setDragScrollStart(obtainStyledAttributes.getFloat(R.styleable.DragSort_drag_scroll_start, this.eNI));
            this.eNQ = obtainStyledAttributes.getFloat(R.styleable.DragSort_max_drag_scroll_speed, this.eNQ);
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
                bVar.ju(z);
                bVar.jt(z2);
                bVar.setBackgroundColor(color);
                this.eNW = bVar;
                a(bVar);
            }
            obtainStyledAttributes.recycle();
            i2 = i5;
            i3 = i4;
        }
        this.eNH = new d();
        if (i3 > 0) {
            this.eOg = new k(0.5f, i3);
        }
        if (i2 > 0) {
            this.eOi = new f(0.5f, i2);
        }
        this.eNX = MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
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
        this.eOm = bVar;
        this.mListView.setOnTouchListener(bVar);
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void dispatchDraw(Canvas canvas) {
        float f2;
        this.eOl.dispatchDraw(canvas);
        if (this.mDragState != 0) {
            if (this.eNv != this.eNy) {
                b(this.eNv, canvas);
            }
            if (this.eNw != this.eNv && this.eNw != this.eNy) {
                b(this.eNw, canvas);
            }
        }
        if (this.eNn != null) {
            int width = this.eNn.getWidth();
            int height = this.eNn.getHeight();
            int i2 = this.eNo.x;
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
            int i3 = (int) (f2 * 255.0f * this.eNt);
            canvas.save();
            canvas.translate(this.eNo.x, this.eNo.y);
            canvas.clipRect(0, 0, width, height);
            canvas.saveLayerAlpha(0.0f, 0.0f, width, height, i3, 31);
            this.eNn.draw(canvas);
            canvas.restore();
            canvas.restore();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onDraw(Canvas canvas) {
        this.eOl.onDraw(canvas);
        if (this.eOc) {
            this.eOd.bnT();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.eOe) {
            this.eOe = false;
            return false;
        } else if (!this.cTN) {
            return this.eOl.onTouchEvent(motionEvent);
        } else {
            boolean z2 = this.eNU;
            this.eNU = false;
            if (!z2) {
                r(motionEvent);
            }
            if (this.mDragState == 4) {
                onDragTouchEvent(motionEvent);
                return true;
            }
            if (this.mDragState == 0 && this.eOl.onTouchEvent(motionEvent)) {
                z = true;
            }
            switch (motionEvent.getAction() & 255) {
                case 1:
                case 3:
                    bnL();
                    return z;
                case 2:
                default:
                    if (z) {
                        this.eNY = 1;
                        return z;
                    }
                    return z;
            }
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (!this.cTN) {
            return this.eOl.onInterceptTouchEvent(motionEvent);
        }
        if (this.eOm != null) {
            this.eOm.bnV().onTouchEvent(motionEvent);
        }
        r(motionEvent);
        this.eNU = true;
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            if (this.mDragState != 0) {
                this.eOe = true;
                return true;
            }
            this.eNV = true;
        }
        if (this.eNn == null) {
            if (this.eOl.onInterceptTouchEvent(motionEvent)) {
                this.eOn = true;
                z = true;
            } else {
                z = false;
            }
            switch (action) {
                case 1:
                case 3:
                    bnL();
                    break;
                case 2:
                default:
                    if (z) {
                        this.eNY = 1;
                        break;
                    } else {
                        this.eNY = 2;
                        break;
                    }
            }
        } else {
            z = true;
        }
        if (action == 1 || action == 3) {
            this.eNV = false;
        }
        return z;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        this.eOl.onSizeChanged(i2, i3, i4, i5);
        bnM();
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void requestLayout() {
        if (!this.mBlockLayoutRequests) {
            this.eOl.requestLayout();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onMeasure(int i2, int i3) {
        this.eOl.onMeasure(i2, i3);
        if (this.eNn != null) {
            if (this.eNn.isLayoutRequested()) {
                bnO();
            }
            this.eNr = true;
        }
        this.mWidthMeasureSpec = i2;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void layoutChildren() {
        this.eOl.layoutChildren();
        if (this.eNn != null) {
            if (this.eNn.isLayoutRequested() && !this.eNr) {
                bnO();
            }
            this.eNn.layout(0, 0, this.eNn.getMeasuredWidth(), this.eNn.getMeasuredHeight());
            this.eNr = false;
        }
    }

    public void removeItem(int i2, float f2) {
        if (this.mDragState == 0 || this.mDragState == 4) {
            if (this.mDragState == 0) {
                this.eNy = this.mListView.getHeaderViewsCount() + i2;
                this.eNv = this.eNy;
                this.eNw = this.eNy;
                this.eNu = this.eNy;
                View childAt = this.mListView.getChildAt(this.eNy - this.mListView.getFirstVisiblePosition());
                if (childAt != null) {
                    childAt.setVisibility(4);
                }
            }
            this.mDragState = 1;
            this.eOk = f2;
            if (this.eNV) {
                switch (this.eNY) {
                    case 1:
                        this.eOl.onTouchEvent(this.eNX);
                        break;
                    case 2:
                        this.eOl.onInterceptTouchEvent(this.eNX);
                        break;
                }
            }
            if (this.eOg != null) {
                this.eOg.start();
            } else {
                oE(i2);
            }
        }
    }

    public void cancelDrag() {
        if (this.mDragState == 4) {
            this.eNH.js(true);
            bnQ();
            bnH();
            bnN();
            if (this.eNV) {
                this.mDragState = 3;
            } else {
                this.mDragState = 0;
            }
        }
    }

    private void bnH() {
        this.eNy = -1;
        this.eNv = -1;
        this.eNw = -1;
        this.eNu = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnI() {
        this.mDragState = 2;
        if (this.eNC != null && this.eNu >= 0 && this.eNu < this.mListView.getCount()) {
            int headerViewsCount = this.mListView.getHeaderViewsCount();
            this.eNC.drop(this.eNy - headerViewsCount, this.eNu - headerViewsCount);
        }
        bnQ();
        bnK();
        bnH();
        bnN();
        if (this.eNV) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnJ() {
        oE(this.eNy - this.mListView.getHeaderViewsCount());
    }

    private void oE(int i2) {
        this.mDragState = 1;
        if (this.eND != null) {
            this.eND.remove(i2);
        }
        bnQ();
        bnK();
        bnH();
        if (this.eNV) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    private void bnK() {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        if (this.eNy < firstVisiblePosition) {
            View childAt = this.mListView.getChildAt(0);
            this.mListView.setSelectionFromTop(firstVisiblePosition - 1, (childAt != null ? childAt.getTop() : 0) - this.mListView.getPaddingTop());
        }
    }

    public boolean stopDrag(boolean z) {
        this.eOj = false;
        return stopDrag(z, 0.0f);
    }

    public boolean stopDragWithVelocity(boolean z, float f2) {
        this.eOj = true;
        return stopDrag(z, f2);
    }

    public boolean stopDrag(boolean z, float f2) {
        if (this.eNn != null) {
            this.eNH.js(true);
            if (z) {
                removeItem(this.eNy - this.mListView.getHeaderViewsCount(), f2);
            } else if (this.eOi != null) {
                this.eOi.start();
            } else {
                bnI();
            }
            if (this.eOc) {
                this.eOd.stopTracking();
                return true;
            }
            return true;
        }
        return false;
    }

    private void bnL() {
        this.eNY = 0;
        this.eNV = false;
        if (this.mDragState == 3) {
            this.mDragState = 0;
        }
        this.eNt = this.eNs;
        this.eOn = false;
        this.eOf.clear();
    }

    private void r(MotionEvent motionEvent) {
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
        return this.eOn;
    }

    public void setDragScrollStart(float f2) {
        setDragScrollStarts(f2, f2);
    }

    public void setDragScrollStarts(float f2, float f3) {
        if (f3 > 0.5f) {
            this.eNJ = 0.5f;
        } else {
            this.eNJ = f3;
        }
        if (f2 > 0.5f) {
            this.eNI = 0.5f;
        } else {
            this.eNI = f2;
        }
        if (this.mListView.getHeight() != 0) {
            bnM();
        }
    }

    private void bc(int i2, int i3) {
        this.eNo.x = i2 - this.eNz;
        this.eNo.y = i3 - this.eNA;
        jr(true);
        int min = Math.min(i3, this.eNq + this.eNF);
        int max = Math.max(i3, this.eNq - this.eNF);
        int bnR = this.eNH.bnR();
        if (min > this.mLastY && min > this.eNL && bnR != 1) {
            if (bnR != -1) {
                this.eNH.js(true);
            }
            this.eNH.oG(1);
        } else if (max < this.mLastY && max < this.eNK && bnR != 0) {
            if (bnR != -1) {
                this.eNH.js(true);
            }
            this.eNH.oG(0);
        } else if (max >= this.eNK && min <= this.eNL && this.eNH.isScrolling()) {
            this.eNH.js(true);
        }
    }

    private void bnM() {
        int height;
        int paddingTop = this.mListView.getPaddingTop();
        float height2 = (this.mListView.getHeight() - paddingTop) - this.mListView.getPaddingBottom();
        this.eNN = paddingTop + (this.eNI * height2);
        this.eNM = (height2 * (1.0f - this.eNJ)) + paddingTop;
        this.eNK = (int) this.eNN;
        this.eNL = (int) this.eNM;
        this.eNO = this.eNN - paddingTop;
        this.eNP = (paddingTop + height) - this.eNM;
    }

    private void bnN() {
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
        if (i2 != this.eNy && i2 != this.eNv && i2 != this.eNw) {
            g2 = -2;
        } else {
            g2 = g(i2, view, z);
        }
        if (g2 != layoutParams.height) {
            layoutParams.height = g2;
            view.setLayoutParams(layoutParams);
        }
        if (i2 == this.eNv || i2 == this.eNw) {
            if (i2 < this.eNy) {
                ((DragSortItemView) view).setGravity(80);
            } else if (i2 > this.eNy) {
                ((DragSortItemView) view).setGravity(48);
            }
        }
        int visibility = view.getVisibility();
        int i3 = 0;
        if (i2 == this.eNy && this.eNn != null) {
            i3 = 4;
        }
        if (i3 != visibility) {
            view.setVisibility(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int oF(int i2) {
        View view;
        if (i2 == this.eNy) {
            return 0;
        }
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        if (childAt != null) {
            return f(i2, childAt, false);
        }
        int i3 = this.eOf.get(i2);
        if (i3 == -1) {
            ListAdapter adapter = this.mListView.getAdapter();
            int itemViewType = adapter.getItemViewType(i2);
            int viewTypeCount = adapter.getViewTypeCount();
            if (viewTypeCount != this.eNG.length) {
                this.eNG = new View[viewTypeCount];
            }
            if (itemViewType >= 0) {
                if (this.eNG[itemViewType] == null) {
                    view = adapter.getView(i2, null, this.mListView);
                    this.eNG[itemViewType] = view;
                } else {
                    view = adapter.getView(i2, this.eNG[itemViewType], this.mListView);
                }
            } else {
                view = adapter.getView(i2, null, this.mListView);
            }
            int f2 = f(i2, view, true);
            this.eOf.be(i2, f2);
            return f2;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(int i2, View view, boolean z) {
        if (i2 == this.eNy) {
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
        return bd(i2, f(i2, view, z));
    }

    private int bd(int i2, int i3) {
        this.mListView.getDividerHeight();
        boolean z = this.eNx && this.eNv != this.eNw;
        int i4 = this.cDa - this.eNE;
        int i5 = (int) (this.eOa * i4);
        if (i2 == this.eNy) {
            if (this.eNy == this.eNv) {
                if (z) {
                    return i5 + this.eNE;
                }
                return this.cDa;
            } else if (this.eNy == this.eNw) {
                return this.cDa - i5;
            } else {
                return this.eNE;
            }
        } else if (i2 == this.eNv) {
            if (z) {
                return i3 + i5;
            }
            return i3 + i4;
        } else if (i2 == this.eNw) {
            return (i3 + i4) - i5;
        } else {
            return i3;
        }
    }

    private int b(int i2, View view, int i3, int i4) {
        int i5;
        int i6;
        int oF = oF(i2);
        int height = view.getHeight();
        int bd = bd(i2, oF);
        if (i2 != this.eNy) {
            i6 = height - oF;
            i5 = bd - oF;
        } else {
            i5 = bd;
            i6 = height;
        }
        int i7 = this.cDa;
        if (this.eNy != this.eNv && this.eNy != this.eNw) {
            i7 -= this.eNE;
        }
        if (i2 <= i3) {
            if (i2 > this.eNv) {
                return (i7 - i5) + 0;
            }
        } else if (i2 == i4) {
            if (i2 <= this.eNv) {
                return (i6 - i7) + 0;
            }
            if (i2 == this.eNw) {
                return (height - bd) + 0;
            }
            return 0 + i6;
        } else if (i2 <= this.eNv) {
            return 0 - i7;
        } else {
            if (i2 == this.eNw) {
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

    private void bnO() {
        if (this.eNn != null) {
            measureItem(this.eNn);
            this.cDa = this.eNn.getMeasuredHeight();
            this.eNF = this.cDa / 2;
        }
    }

    protected boolean onDragTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        switch (motionEvent.getAction() & 255) {
            case 1:
                if (this.mDragState == 4) {
                    stopDrag(false);
                }
                bnL();
                return true;
            case 2:
                bc((int) motionEvent.getX(), (int) motionEvent.getY());
                return true;
            case 3:
                if (this.mDragState == 4) {
                    cancelDrag();
                }
                bnL();
                return true;
            default:
                return true;
        }
    }

    public boolean startDrag(int i2, int i3, int i4, int i5) {
        View oH;
        if (!this.eNV || this.eNW == null || (oH = this.eNW.oH(i2)) == null) {
            return false;
        }
        return startDrag(i2, oH, i3, i4, i5);
    }

    public boolean startDrag(int i2, View view, int i3, int i4, int i5) {
        if (this.mDragState == 0 && this.eNV && this.eNn == null && view != null && this.cTN) {
            if (this.mListView.getParent() != null) {
                this.mListView.getParent().requestDisallowInterceptTouchEvent(true);
            }
            int headerViewsCount = this.mListView.getHeaderViewsCount() + i2;
            this.eNv = headerViewsCount;
            this.eNw = headerViewsCount;
            this.eNy = headerViewsCount;
            this.eNu = headerViewsCount;
            this.mDragState = 4;
            this.eNT = 0;
            this.eNT |= i3;
            this.eNn = view;
            bnO();
            this.eNz = i4;
            this.eNA = i5;
            this.eNS = this.mY;
            this.eNo.x = this.mX - this.eNz;
            this.eNo.y = this.mY - this.eNA;
            View childAt = this.mListView.getChildAt(this.eNy - this.mListView.getFirstVisiblePosition());
            if (childAt != null) {
                childAt.setVisibility(4);
            }
            if (this.eOc) {
                this.eOd.bnS();
            }
            switch (this.eNY) {
                case 1:
                    this.eOl.onTouchEvent(this.eNX);
                    break;
                case 2:
                    this.eOl.onInterceptTouchEvent(this.eNX);
                    break;
            }
            this.mListView.requestLayout();
            if (this.eOh != null) {
                this.eOh.start();
                return true;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jr(boolean z) {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition() + (this.mListView.getChildCount() / 2);
        View childAt = this.mListView.getChildAt(this.mListView.getChildCount() / 2);
        if (childAt != null) {
            h(firstVisiblePosition, childAt, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i2, View view, boolean z) {
        this.mBlockLayoutRequests = true;
        bnP();
        int i3 = this.eNv;
        int i4 = this.eNw;
        boolean bnG = bnG();
        if (bnG) {
            bnN();
            this.mListView.setSelectionFromTop(i2, (b(i2, view, i3, i4) + view.getTop()) - this.mListView.getPaddingTop());
            layoutChildren();
        }
        if (bnG || z) {
            this.mListView.invalidate();
        }
        this.mBlockLayoutRequests = false;
    }

    private void bnP() {
        if (this.eNW != null) {
            this.eNp.set(this.mX, this.mY);
            this.eNW.b(this.eNn, this.eNo, this.eNp);
        }
        int i2 = this.eNo.x;
        int i3 = this.eNo.y;
        int paddingLeft = this.mListView.getPaddingLeft();
        if ((this.eNT & 1) == 0 && i2 > paddingLeft) {
            this.eNo.x = paddingLeft;
        } else if ((this.eNT & 2) == 0 && i2 < paddingLeft) {
            this.eNo.x = paddingLeft;
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int lastVisiblePosition = this.mListView.getLastVisiblePosition();
        int paddingTop = this.mListView.getPaddingTop();
        if (firstVisiblePosition < headerViewsCount) {
            paddingTop = this.mListView.getChildAt((headerViewsCount - firstVisiblePosition) - 1).getBottom();
        }
        if ((this.eNT & 8) == 0 && firstVisiblePosition <= this.eNy) {
            paddingTop = Math.max(this.mListView.getChildAt(this.eNy - firstVisiblePosition).getTop(), paddingTop);
        }
        int height = this.mListView.getHeight() - this.mListView.getPaddingBottom();
        if (lastVisiblePosition >= (this.mListView.getCount() - footerViewsCount) - 1) {
            height = this.mListView.getChildAt(((this.mListView.getCount() - footerViewsCount) - 1) - firstVisiblePosition).getBottom();
        }
        if ((this.eNT & 4) == 0 && lastVisiblePosition >= this.eNy) {
            height = Math.min(this.mListView.getChildAt(this.eNy - firstVisiblePosition).getBottom(), height);
        }
        if (i3 < paddingTop) {
            this.eNo.y = paddingTop;
        } else if (this.cDa + i3 > height) {
            this.eNo.y = height - this.cDa;
        }
        this.eNq = this.eNo.y + this.eNF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnQ() {
        if (this.eNn != null) {
            this.eNn.setVisibility(8);
            if (this.eNW != null) {
                this.eNW.bs(this.eNn);
            }
            this.eNn = null;
            this.mListView.invalidate();
        }
    }

    public void a(h hVar) {
        this.eNW = hVar;
    }

    public void a(b bVar) {
        this.eNB = bVar;
    }

    public void setDragEnabled(boolean z) {
        this.cTN = z;
    }

    public boolean isDragEnabled() {
        return this.cTN;
    }

    public void a(g gVar) {
        this.eNC = gVar;
    }

    public void a(l lVar) {
        this.eND = lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class i {
        private SparseIntArray eOH;
        private ArrayList<Integer> eOI;
        private int mMaxSize;

        public i(int i) {
            this.eOH = new SparseIntArray(i);
            this.eOI = new ArrayList<>(i);
            this.mMaxSize = i;
        }

        public void be(int i, int i2) {
            int i3 = this.eOH.get(i, -1);
            if (i3 != i2) {
                if (i3 == -1) {
                    if (this.eOH.size() == this.mMaxSize) {
                        this.eOH.delete(this.eOI.remove(0).intValue());
                    }
                } else {
                    this.eOI.remove(Integer.valueOf(i));
                }
                this.eOH.put(i, i2);
                this.eOI.add(Integer.valueOf(i));
            }
        }

        public int get(int i) {
            return this.eOH.get(i, -1);
        }

        public void clear() {
            this.eOH.clear();
            this.eOI.clear();
        }
    }

    /* renamed from: com.baidu.tbadk.widget.dragsort.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0515a extends BaseAdapter {
        private ListAdapter mAdapter;

        public C0515a(ListAdapter listAdapter) {
            this.mAdapter = listAdapter;
            this.mAdapter.registerDataSetObserver(new DataSetObserver() { // from class: com.baidu.tbadk.widget.dragsort.a.a.1
                @Override // android.database.DataSetObserver
                public void onChanged() {
                    C0515a.this.notifyDataSetChanged();
                }

                @Override // android.database.DataSetObserver
                public void onInvalidated() {
                    C0515a.this.notifyDataSetInvalidated();
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
        private float bUi;
        private float bUj;
        private float bUk;
        private float bUl;
        private float eOS;
        private float mAlpha;
        private boolean mCanceled;
        protected long mStartTime;

        public m(float f, int i) {
            this.mAlpha = f;
            this.eOS = i;
            float f2 = 1.0f / ((this.mAlpha * 2.0f) * (1.0f - this.mAlpha));
            this.bUl = f2;
            this.bUi = f2;
            this.bUj = this.mAlpha / ((this.mAlpha - 1.0f) * 2.0f);
            this.bUk = 1.0f / (1.0f - this.mAlpha);
        }

        public float ab(float f) {
            if (f < this.mAlpha) {
                return this.bUi * f * f;
            }
            if (f < 1.0f - this.mAlpha) {
                return this.bUj + (this.bUk * f);
            }
            return 1.0f - ((this.bUl * (f - 1.0f)) * (f - 1.0f));
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

        public void s(float f, float f2) {
        }

        public void onStop() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.mCanceled) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / this.eOS;
                if (uptimeMillis >= 1.0f) {
                    s(1.0f, 1.0f);
                    onStop();
                    return;
                }
                s(uptimeMillis, ab(uptimeMillis));
                a.this.mListView.post(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class f extends m {
        private int eOD;
        private int eOE;
        private float eOF;
        private float eOG;

        public f(float f, int i) {
            super(f, i);
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.eOD = a.this.eNu;
            this.eOE = a.this.eNy;
            a.this.mDragState = 2;
            this.eOF = a.this.eNo.y - bnU();
            this.eOG = a.this.eNo.x - a.this.mListView.getPaddingLeft();
        }

        private int bnU() {
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            int dividerHeight = (a.this.eNE + a.this.mListView.getDividerHeight()) / 2;
            View childAt = a.this.mListView.getChildAt(this.eOD - firstVisiblePosition);
            if (childAt != null) {
                if (this.eOD == this.eOE) {
                    return childAt.getTop();
                }
                if (this.eOD >= this.eOE) {
                    return (childAt.getBottom() + dividerHeight) - a.this.cDa;
                }
                return childAt.getTop() - dividerHeight;
            }
            cancel();
            return -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void s(float f, float f2) {
            int bnU = bnU();
            float paddingLeft = a.this.eNo.x - a.this.mListView.getPaddingLeft();
            float f3 = 1.0f - f2;
            if (f3 < Math.abs((a.this.eNo.y - bnU) / this.eOF) || f3 < Math.abs(paddingLeft / this.eOG)) {
                a.this.eNo.y = bnU + ((int) (this.eOF * f3));
                a.this.eNo.x = a.this.mListView.getPaddingLeft() + ((int) (this.eOG * f3));
                a.this.jr(true);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.bnI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class k extends m {
        private int eOE;
        private float eOL;
        private float eOM;
        private float eON;
        private int eOO;
        private int eOP;
        private int eOQ;
        private int eOR;

        public k(float f, int i) {
            super(f, i);
            this.eOO = -1;
            this.eOP = -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.eOO = -1;
            this.eOP = -1;
            this.eOQ = a.this.eNv;
            this.eOR = a.this.eNw;
            this.eOE = a.this.eNy;
            a.this.mDragState = 1;
            this.eOL = a.this.eNo.x;
            if (a.this.eOj) {
                float width = a.this.mListView.getWidth() * 2.0f;
                if (a.this.eOk == 0.0f) {
                    a.this.eOk = (this.eOL >= 0.0f ? 1 : -1) * width;
                    return;
                }
                float f = width * 2.0f;
                if (a.this.eOk >= 0.0f || a.this.eOk <= (-f)) {
                    if (a.this.eOk > 0.0f && a.this.eOk < f) {
                        a.this.eOk = f;
                        return;
                    }
                    return;
                }
                a.this.eOk = -f;
                return;
            }
            a.this.bnQ();
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void s(float f, float f2) {
            View childAt;
            float f3 = 1.0f - f2;
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            View childAt2 = a.this.mListView.getChildAt(this.eOQ - firstVisiblePosition);
            if (a.this.eOj) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / 1000.0f;
                if (uptimeMillis != 0.0f) {
                    float f4 = a.this.eOk * uptimeMillis;
                    int width = a.this.mListView.getWidth();
                    a.this.eOk = ((a.this.eOk > 0.0f ? 1 : -1) * uptimeMillis * width) + a.this.eOk;
                    this.eOL += f4;
                    a.this.eNo.x = (int) this.eOL;
                    if (this.eOL < width && this.eOL > (-width)) {
                        this.mStartTime = SystemClock.uptimeMillis();
                        a.this.jr(true);
                        return;
                    }
                } else {
                    return;
                }
            }
            if (childAt2 != null) {
                if (this.eOO == -1) {
                    this.eOO = a.this.f(this.eOQ, childAt2, false);
                    this.eOM = childAt2.getHeight() - this.eOO;
                }
                int max = Math.max((int) (this.eOM * f3), 1);
                ViewGroup.LayoutParams layoutParams = childAt2.getLayoutParams();
                layoutParams.height = max + this.eOO;
                childAt2.setLayoutParams(layoutParams);
            }
            if (this.eOR != this.eOQ && (childAt = a.this.mListView.getChildAt(this.eOR - firstVisiblePosition)) != null) {
                if (this.eOP == -1) {
                    this.eOP = a.this.f(this.eOR, childAt, false);
                    this.eON = childAt.getHeight() - this.eOP;
                }
                int max2 = Math.max((int) (this.eON * f3), 1);
                ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
                layoutParams2.height = max2 + this.eOP;
                childAt.setLayoutParams(layoutParams2);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.bnJ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class j extends m {
        private float eOJ;
        private float eOK;
        final /* synthetic */ a eOp;

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.eOJ = this.eOp.eNA;
            this.eOK = this.eOp.eNF;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void s(float f, float f2) {
            if (this.eOp.mDragState != 4) {
                cancel();
                return;
            }
            this.eOp.eNA = (int) ((this.eOK * f2) + ((1.0f - f2) * this.eOJ));
            this.eOp.eNo.y = this.eOp.mY - this.eOp.eNA;
            this.eOp.jr(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e {
        StringBuilder mBuilder = new StringBuilder();
        private int eOA = 0;
        private int eOB = 0;
        private boolean eOC = false;
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

        public void bnS() {
            this.mBuilder.append("<DSLVStates>\n");
            this.eOB = 0;
            this.eOC = true;
        }

        public void bnT() {
            if (this.eOC) {
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
                this.mBuilder.append("    <FirstExpPos>").append(a.this.eNv).append("</FirstExpPos>\n");
                this.mBuilder.append("    <FirstExpBlankHeight>").append(a.this.oD(a.this.eNv) - a.this.oF(a.this.eNv)).append("</FirstExpBlankHeight>\n");
                this.mBuilder.append("    <SecondExpPos>").append(a.this.eNw).append("</SecondExpPos>\n");
                this.mBuilder.append("    <SecondExpBlankHeight>").append(a.this.oD(a.this.eNw) - a.this.oF(a.this.eNw)).append("</SecondExpBlankHeight>\n");
                this.mBuilder.append("    <SrcPos>").append(a.this.eNy).append("</SrcPos>\n");
                this.mBuilder.append("    <SrcHeight>").append(a.this.cDa + a.this.mListView.getDividerHeight()).append("</SrcHeight>\n");
                this.mBuilder.append("    <ViewHeight>").append(a.this.mListView.getHeight()).append("</ViewHeight>\n");
                this.mBuilder.append("    <LastY>").append(a.this.mLastY).append("</LastY>\n");
                this.mBuilder.append("    <FloatY>").append(a.this.eNq).append("</FloatY>\n");
                this.mBuilder.append("    <ShuffleEdges>");
                for (int i4 = 0; i4 < childCount; i4++) {
                    this.mBuilder.append(a.this.bb(firstVisiblePosition + i4, a.this.mListView.getChildAt(i4).getTop())).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                this.mBuilder.append("</ShuffleEdges>\n");
                this.mBuilder.append("</DSLVState>\n");
                this.eOA++;
                if (this.eOA > 1000) {
                    flush();
                    this.eOA = 0;
                }
            }
        }

        public void flush() {
            if (this.eOC) {
                try {
                    FileWriter fileWriter = new FileWriter(this.mFile, this.eOB != 0);
                    fileWriter.write(this.mBuilder.toString());
                    this.mBuilder.delete(0, this.mBuilder.length());
                    fileWriter.flush();
                    fileWriter.close();
                    this.eOB++;
                } catch (IOException e) {
                }
            }
        }

        public void stopTracking() {
            if (this.eOC) {
                this.mBuilder.append("</DSLVStates>\n");
                flush();
                this.eOC = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements Runnable {
        private boolean eOs;
        private long eOt;
        private long eOu;
        private int eOv;
        private float eOw;
        private long eOx;
        private int eOy;
        private float eOz;
        private boolean mScrolling = false;

        public boolean isScrolling() {
            return this.mScrolling;
        }

        public int bnR() {
            if (this.mScrolling) {
                return this.eOy;
            }
            return -1;
        }

        public d() {
        }

        public void oG(int i) {
            if (!this.mScrolling) {
                this.eOs = false;
                this.mScrolling = true;
                this.eOx = SystemClock.uptimeMillis();
                this.eOt = this.eOx;
                this.eOy = i;
                a.this.mListView.post(this);
            }
        }

        public void js(boolean z) {
            if (z) {
                a.this.mListView.removeCallbacks(this);
                this.mScrolling = false;
                return;
            }
            this.eOs = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.eOs) {
                int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
                int lastVisiblePosition = a.this.mListView.getLastVisiblePosition();
                int count = a.this.mListView.getCount();
                int paddingTop = a.this.mListView.getPaddingTop();
                int height = (a.this.mListView.getHeight() - paddingTop) - a.this.mListView.getPaddingBottom();
                int min = Math.min(a.this.mY, a.this.eNq + a.this.eNF);
                int max = Math.max(a.this.mY, a.this.eNq - a.this.eNF);
                if (this.eOy == 0) {
                    View childAt = a.this.mListView.getChildAt(0);
                    if (childAt == null) {
                        this.mScrolling = false;
                        return;
                    } else if (firstVisiblePosition == 0 && childAt.getTop() == paddingTop) {
                        this.mScrolling = false;
                        return;
                    } else {
                        this.eOz = a.this.eNR.b((a.this.eNN - max) / a.this.eNO, this.eOt);
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
                        this.eOz = -a.this.eNR.b((min - a.this.eNM) / a.this.eNP, this.eOt);
                    }
                }
                this.eOu = SystemClock.uptimeMillis();
                this.eOw = (float) (this.eOu - this.eOt);
                this.eOv = Math.round(this.eOz * this.eOw);
                if (this.eOv >= 0) {
                    this.eOv = Math.min(height, this.eOv);
                    lastVisiblePosition = firstVisiblePosition;
                } else {
                    this.eOv = Math.max(-height, this.eOv);
                }
                View childAt3 = a.this.mListView.getChildAt(lastVisiblePosition - firstVisiblePosition);
                int top = childAt3.getTop() + this.eOv;
                if (lastVisiblePosition == 0 && top > paddingTop) {
                    top = paddingTop;
                }
                a.this.mBlockLayoutRequests = true;
                a.this.mListView.setSelectionFromTop(lastVisiblePosition, top - paddingTop);
                a.this.layoutChildren();
                a.this.mListView.invalidate();
                a.this.mBlockLayoutRequests = false;
                a.this.h(lastVisiblePosition, childAt3, false);
                this.eOt = this.eOu;
                a.this.mListView.post(this);
                return;
            }
            this.mScrolling = false;
        }
    }
}
