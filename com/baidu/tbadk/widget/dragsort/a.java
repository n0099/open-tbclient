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
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a implements com.baidu.tbadk.widget.dragsort.c {
    private int cHC;
    private int cHD;
    private int cHY;
    private int dtn;
    private View fIH;
    private int fIK;
    private int fIO;
    private int fIP;
    private int fIQ;
    private int fIS;
    private int fIT;
    private int fIU;
    private b fIV;
    private g fIW;
    private l fIX;
    private int fIZ;
    private k fJA;
    private j fJB;
    private f fJC;
    private boolean fJD;
    private com.baidu.tbadk.widget.dragsort.d fJF;
    private com.baidu.tbadk.widget.dragsort.b fJG;
    private d fJb;
    private int fJe;
    private int fJf;
    private float fJg;
    private float fJh;
    private float fJi;
    private float fJj;
    private int fJm;
    private MotionEvent fJr;
    private C0612a fJv;
    private e fJx;
    private int mLastX;
    private int mLastY;
    private ListView mListView;
    private DataSetObserver mObserver;
    private int mOffsetY;
    private Point fII = new Point();
    private Point fIJ = new Point();
    private boolean fIL = false;
    private float fIM = 1.0f;
    private float fIN = 1.0f;
    private boolean fIR = false;
    private boolean dKJ = true;
    private int mDragState = 0;
    private int fIY = 1;
    private int mWidthMeasureSpec = 0;
    private View[] fJa = new View[1];
    private float fJc = 0.33333334f;
    private float fJd = 0.33333334f;
    private float fJk = 0.5f;
    private c fJl = new c() { // from class: com.baidu.tbadk.widget.dragsort.a.1
        @Override // com.baidu.tbadk.widget.dragsort.a.c
        public float b(float f2, long j2) {
            return a.this.fJk * f2;
        }
    };
    private int fJn = 0;
    private boolean fJo = false;
    private boolean fJp = false;
    private h fJq = null;
    private int fJs = 0;
    private float fJt = 0.25f;
    private float fJu = 0.0f;
    private boolean fJw = false;
    private boolean mBlockLayoutRequests = false;
    private boolean fJy = false;
    private i fJz = new i(3);
    private float fJE = 0.0f;
    private boolean fJH = false;
    private boolean fJI = false;

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

        void bR(View view);

        View te(int i);
    }

    /* loaded from: classes.dex */
    public interface l {
        void remove(int i);
    }

    public a(ListView listView, com.baidu.tbadk.widget.dragsort.d dVar) {
        this.fJF = dVar;
        this.mListView = listView;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            this.fJv = new C0612a(listAdapter);
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
            this.fJv = null;
        }
        this.fJF.setAdapter(this.fJv);
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
            if (i2 > this.fIS) {
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
    public int ta(int i2) {
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        return childAt != null ? childAt.getHeight() : bo(i2, tc(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bm(int i2, int i3) {
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        if (i2 <= headerViewsCount || i2 >= this.mListView.getCount() - footerViewsCount) {
            return i3;
        }
        int dividerHeight = this.mListView.getDividerHeight();
        int i4 = this.dtn - this.fIY;
        int tc = tc(i2);
        int ta = ta(i2);
        if (this.fIQ <= this.fIS) {
            if (i2 == this.fIQ && this.fIP != this.fIQ) {
                if (i2 == this.fIS) {
                    i3 = (i3 + ta) - this.dtn;
                } else {
                    i3 = ((ta - tc) + i3) - i4;
                }
            } else if (i2 > this.fIQ && i2 <= this.fIS) {
                i3 -= i4;
            }
        } else if (i2 > this.fIS && i2 <= this.fIP) {
            i3 += i4;
        } else if (i2 == this.fIQ && this.fIP != this.fIQ) {
            i3 += ta - tc;
        }
        if (i2 <= this.fIS) {
            return (((this.dtn - dividerHeight) - tc(i2 - 1)) / 2) + i3;
        }
        return (((tc - dividerHeight) - this.dtn) / 2) + i3;
    }

    private boolean bHA() {
        int i2;
        int i3;
        int i4;
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int i5 = this.fIP;
        View childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        if (childAt == null) {
            i5 = firstVisiblePosition + (this.mListView.getChildCount() / 2);
            childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        }
        int top = childAt.getTop();
        int height = childAt.getHeight();
        int bm = bm(i5, top);
        int dividerHeight = this.mListView.getDividerHeight();
        if (this.fIK >= bm) {
            int count = this.mListView.getCount();
            int i6 = height;
            int i7 = top;
            i2 = bm;
            i3 = i5;
            i4 = bm;
            while (true) {
                if (i3 < count) {
                    if (i3 == count - 1) {
                        i2 = i7 + dividerHeight + i6;
                        break;
                    }
                    i7 += dividerHeight + i6;
                    i6 = ta(i3 + 1);
                    i2 = bm(i3 + 1, i7);
                    if (this.fIK < i2) {
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
            i2 = bm;
            i3 = i5;
            i4 = bm;
            while (true) {
                if (i3 < 0) {
                    break;
                }
                i3--;
                int ta = ta(i3);
                if (i3 == 0) {
                    i2 = (i8 - dividerHeight) - ta;
                    break;
                }
                i8 -= ta + dividerHeight;
                i2 = bm(i3, i8);
                if (this.fIK >= i2) {
                    break;
                }
                i4 = i2;
            }
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int i9 = this.fIP;
        int i10 = this.fIQ;
        float f2 = this.fJu;
        if (this.fIR) {
            int abs = Math.abs(i2 - i4);
            if (this.fIK >= i2) {
                int i11 = i4;
                i4 = i2;
                i2 = i11;
            }
            int i12 = (int) (abs * this.fJt * 0.5f);
            float f3 = i12;
            int i13 = i4 + i12;
            int i14 = i2 - i12;
            if (this.fIK < i13) {
                this.fIP = i3 - 1;
                this.fIQ = i3;
                this.fJu = ((i13 - this.fIK) * 0.5f) / f3;
            } else if (this.fIK < i14) {
                this.fIP = i3;
                this.fIQ = i3;
            } else {
                this.fIP = i3;
                this.fIQ = i3 + 1;
                this.fJu = (1.0f + ((i2 - this.fIK) / f3)) * 0.5f;
            }
        } else {
            this.fIP = i3;
            this.fIQ = i3;
        }
        if (this.fIP < headerViewsCount) {
            this.fIP = headerViewsCount;
            this.fIQ = headerViewsCount;
            i3 = headerViewsCount;
        } else if (this.fIQ >= this.mListView.getCount() - footerViewsCount) {
            i3 = (this.mListView.getCount() - footerViewsCount) - 1;
            this.fIP = i3;
            this.fIQ = i3;
        }
        boolean z = (this.fIP == i9 && this.fIQ == i10 && this.fJu == f2) ? false : true;
        if (i3 != this.fIO) {
            if (this.fIV != null) {
                this.fIV.drag(this.fIO - headerViewsCount, i3 - headerViewsCount);
            }
            this.fIO = i3;
            return true;
        }
        return z;
    }

    public void removeItem(int i2) {
        this.fJD = false;
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
            this.fIY = Math.max(1, obtainStyledAttributes.getDimensionPixelSize(R.styleable.DragSort_collapsed_height, 1));
            this.fJw = obtainStyledAttributes.getBoolean(R.styleable.DragSort_track_drag_sort, false);
            if (this.fJw) {
                this.fJx = new e();
            }
            this.fIM = obtainStyledAttributes.getFloat(R.styleable.DragSort_float_alpha, this.fIM);
            this.fIN = this.fIM;
            this.dKJ = obtainStyledAttributes.getBoolean(R.styleable.DragSort_drag_enabled, this.dKJ);
            this.fJt = Math.max(0.0f, Math.min(1.0f, 1.0f - obtainStyledAttributes.getFloat(R.styleable.DragSort_slide_shuffle_speed, 0.75f)));
            this.fIR = this.fJt > 0.0f;
            setDragScrollStart(obtainStyledAttributes.getFloat(R.styleable.DragSort_drag_scroll_start, this.fJc));
            this.fJk = obtainStyledAttributes.getFloat(R.styleable.DragSort_max_drag_scroll_speed, this.fJk);
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
                bVar.lk(z);
                bVar.lj(z2);
                bVar.setBackgroundColor(color);
                this.fJq = bVar;
                a(bVar);
            }
            obtainStyledAttributes.recycle();
            i2 = i5;
            i3 = i4;
        }
        this.fJb = new d();
        if (i3 > 0) {
            this.fJA = new k(0.5f, i3);
        }
        if (i2 > 0) {
            this.fJC = new f(0.5f, i2);
        }
        this.fJr = MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
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
        this.fJG = bVar;
        this.mListView.setOnTouchListener(bVar);
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void dispatchDraw(Canvas canvas) {
        float f2;
        this.fJF.dispatchDraw(canvas);
        if (this.mDragState != 0) {
            if (this.fIP != this.fIS) {
                b(this.fIP, canvas);
            }
            if (this.fIQ != this.fIP && this.fIQ != this.fIS) {
                b(this.fIQ, canvas);
            }
        }
        if (this.fIH != null) {
            int width = this.fIH.getWidth();
            int height = this.fIH.getHeight();
            int i2 = this.fII.x;
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
            int i3 = (int) (f2 * 255.0f * this.fIN);
            canvas.save();
            canvas.translate(this.fII.x, this.fII.y);
            canvas.clipRect(0, 0, width, height);
            canvas.saveLayerAlpha(0.0f, 0.0f, width, height, i3, 31);
            this.fIH.draw(canvas);
            canvas.restore();
            canvas.restore();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onDraw(Canvas canvas) {
        this.fJF.onDraw(canvas);
        if (this.fJw) {
            this.fJx.bHN();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.fJy) {
            this.fJy = false;
            return false;
        } else if (!this.dKJ) {
            return this.fJF.onTouchEvent(motionEvent);
        } else {
            boolean z2 = this.fJo;
            this.fJo = false;
            if (!z2) {
                G(motionEvent);
            }
            if (this.mDragState == 4) {
                onDragTouchEvent(motionEvent);
                return true;
            }
            if (this.mDragState == 0 && this.fJF.onTouchEvent(motionEvent)) {
                z = true;
            }
            switch (motionEvent.getAction() & 255) {
                case 1:
                case 3:
                    bHF();
                    return z;
                case 2:
                default:
                    if (z) {
                        this.fJs = 1;
                        return z;
                    }
                    return z;
            }
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (!this.dKJ) {
            return this.fJF.onInterceptTouchEvent(motionEvent);
        }
        if (this.fJG != null) {
            this.fJG.bHP().onTouchEvent(motionEvent);
        }
        G(motionEvent);
        this.fJo = true;
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            if (this.mDragState != 0) {
                this.fJy = true;
                return true;
            }
            this.fJp = true;
        }
        if (this.fIH == null) {
            if (this.fJF.onInterceptTouchEvent(motionEvent)) {
                this.fJH = true;
                z = true;
            } else {
                z = false;
            }
            switch (action) {
                case 1:
                case 3:
                    bHF();
                    break;
                case 2:
                default:
                    if (z) {
                        this.fJs = 1;
                        break;
                    } else {
                        this.fJs = 2;
                        break;
                    }
            }
        } else {
            z = true;
        }
        if (action == 1 || action == 3) {
            this.fJp = false;
        }
        return z;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        this.fJF.onSizeChanged(i2, i3, i4, i5);
        bHG();
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void requestLayout() {
        if (!this.mBlockLayoutRequests) {
            this.fJF.requestLayout();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onMeasure(int i2, int i3) {
        this.fJF.onMeasure(i2, i3);
        if (this.fIH != null) {
            if (this.fIH.isLayoutRequested()) {
                bHI();
            }
            this.fIL = true;
        }
        this.mWidthMeasureSpec = i2;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void layoutChildren() {
        this.fJF.layoutChildren();
        if (this.fIH != null) {
            if (this.fIH.isLayoutRequested() && !this.fIL) {
                bHI();
            }
            this.fIH.layout(0, 0, this.fIH.getMeasuredWidth(), this.fIH.getMeasuredHeight());
            this.fIL = false;
        }
    }

    public void removeItem(int i2, float f2) {
        if (this.mDragState == 0 || this.mDragState == 4) {
            if (this.mDragState == 0) {
                this.fIS = this.mListView.getHeaderViewsCount() + i2;
                this.fIP = this.fIS;
                this.fIQ = this.fIS;
                this.fIO = this.fIS;
                View childAt = this.mListView.getChildAt(this.fIS - this.mListView.getFirstVisiblePosition());
                if (childAt != null) {
                    childAt.setVisibility(4);
                }
            }
            this.mDragState = 1;
            this.fJE = f2;
            if (this.fJp) {
                switch (this.fJs) {
                    case 1:
                        this.fJF.onTouchEvent(this.fJr);
                        break;
                    case 2:
                        this.fJF.onInterceptTouchEvent(this.fJr);
                        break;
                }
            }
            if (this.fJA != null) {
                this.fJA.start();
            } else {
                tb(i2);
            }
        }
    }

    public void cancelDrag() {
        if (this.mDragState == 4) {
            this.fJb.li(true);
            bHK();
            bHB();
            bHH();
            if (this.fJp) {
                this.mDragState = 3;
            } else {
                this.mDragState = 0;
            }
        }
    }

    private void bHB() {
        this.fIS = -1;
        this.fIP = -1;
        this.fIQ = -1;
        this.fIO = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHC() {
        this.mDragState = 2;
        if (this.fIW != null && this.fIO >= 0 && this.fIO < this.mListView.getCount()) {
            int headerViewsCount = this.mListView.getHeaderViewsCount();
            this.fIW.drop(this.fIS - headerViewsCount, this.fIO - headerViewsCount);
        }
        bHK();
        bHE();
        bHB();
        bHH();
        if (this.fJp) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHD() {
        tb(this.fIS - this.mListView.getHeaderViewsCount());
    }

    private void tb(int i2) {
        this.mDragState = 1;
        if (this.fIX != null) {
            this.fIX.remove(i2);
        }
        bHK();
        bHE();
        bHB();
        if (this.fJp) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    private void bHE() {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        if (this.fIS < firstVisiblePosition) {
            View childAt = this.mListView.getChildAt(0);
            this.mListView.setSelectionFromTop(firstVisiblePosition - 1, (childAt != null ? childAt.getTop() : 0) - this.mListView.getPaddingTop());
        }
    }

    public boolean stopDrag(boolean z) {
        this.fJD = false;
        return stopDrag(z, 0.0f);
    }

    public boolean stopDragWithVelocity(boolean z, float f2) {
        this.fJD = true;
        return stopDrag(z, f2);
    }

    public boolean stopDrag(boolean z, float f2) {
        if (this.fIH != null) {
            this.fJb.li(true);
            if (z) {
                removeItem(this.fIS - this.mListView.getHeaderViewsCount(), f2);
            } else if (this.fJC != null) {
                this.fJC.start();
            } else {
                bHC();
            }
            if (this.fJw) {
                this.fJx.stopTracking();
                return true;
            }
            return true;
        }
        return false;
    }

    private void bHF() {
        this.fJs = 0;
        this.fJp = false;
        if (this.mDragState == 3) {
            this.mDragState = 0;
        }
        this.fIN = this.fIM;
        this.fJH = false;
        this.fJz.clear();
    }

    private void G(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            this.mLastX = this.cHC;
            this.mLastY = this.cHD;
        }
        this.cHC = (int) motionEvent.getX();
        this.cHD = (int) motionEvent.getY();
        if (action == 0) {
            this.mLastX = this.cHC;
            this.mLastY = this.cHD;
        }
        this.cHY = ((int) motionEvent.getRawX()) - this.cHC;
        this.mOffsetY = ((int) motionEvent.getRawY()) - this.cHD;
    }

    public boolean listViewIntercepted() {
        return this.fJH;
    }

    public void setDragScrollStart(float f2) {
        setDragScrollStarts(f2, f2);
    }

    public void setDragScrollStarts(float f2, float f3) {
        if (f3 > 0.5f) {
            this.fJd = 0.5f;
        } else {
            this.fJd = f3;
        }
        if (f2 > 0.5f) {
            this.fJc = 0.5f;
        } else {
            this.fJc = f2;
        }
        if (this.mListView.getHeight() != 0) {
            bHG();
        }
    }

    private void bn(int i2, int i3) {
        this.fII.x = i2 - this.fIT;
        this.fII.y = i3 - this.fIU;
        lh(true);
        int min = Math.min(i3, this.fIK + this.fIZ);
        int max = Math.max(i3, this.fIK - this.fIZ);
        int bHL = this.fJb.bHL();
        if (min > this.mLastY && min > this.fJf && bHL != 1) {
            if (bHL != -1) {
                this.fJb.li(true);
            }
            this.fJb.td(1);
        } else if (max < this.mLastY && max < this.fJe && bHL != 0) {
            if (bHL != -1) {
                this.fJb.li(true);
            }
            this.fJb.td(0);
        } else if (max >= this.fJe && min <= this.fJf && this.fJb.isScrolling()) {
            this.fJb.li(true);
        }
    }

    private void bHG() {
        int height;
        int paddingTop = this.mListView.getPaddingTop();
        float height2 = (this.mListView.getHeight() - paddingTop) - this.mListView.getPaddingBottom();
        this.fJh = paddingTop + (this.fJc * height2);
        this.fJg = (height2 * (1.0f - this.fJd)) + paddingTop;
        this.fJe = (int) this.fJh;
        this.fJf = (int) this.fJg;
        this.fJi = this.fJh - paddingTop;
        this.fJj = (paddingTop + height) - this.fJg;
    }

    private void bHH() {
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
        if (i2 != this.fIS && i2 != this.fIP && i2 != this.fIQ) {
            g2 = -2;
        } else {
            g2 = g(i2, view, z);
        }
        if (g2 != layoutParams.height) {
            layoutParams.height = g2;
            view.setLayoutParams(layoutParams);
        }
        if (i2 == this.fIP || i2 == this.fIQ) {
            if (i2 < this.fIS) {
                ((DragSortItemView) view).setGravity(80);
            } else if (i2 > this.fIS) {
                ((DragSortItemView) view).setGravity(48);
            }
        }
        int visibility = view.getVisibility();
        int i3 = 0;
        if (i2 == this.fIS && this.fIH != null) {
            i3 = 4;
        }
        if (i3 != visibility) {
            view.setVisibility(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int tc(int i2) {
        View view;
        if (i2 == this.fIS) {
            return 0;
        }
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        if (childAt != null) {
            return f(i2, childAt, false);
        }
        int i3 = this.fJz.get(i2);
        if (i3 == -1) {
            ListAdapter adapter = this.mListView.getAdapter();
            int itemViewType = adapter.getItemViewType(i2);
            int viewTypeCount = adapter.getViewTypeCount();
            if (viewTypeCount != this.fJa.length) {
                this.fJa = new View[viewTypeCount];
            }
            if (itemViewType >= 0) {
                if (this.fJa[itemViewType] == null) {
                    view = adapter.getView(i2, null, this.mListView);
                    this.fJa[itemViewType] = view;
                } else {
                    view = adapter.getView(i2, this.fJa[itemViewType], this.mListView);
                }
            } else {
                view = adapter.getView(i2, null, this.mListView);
            }
            int f2 = f(i2, view, true);
            this.fJz.bp(i2, f2);
            return f2;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(int i2, View view, boolean z) {
        if (i2 == this.fIS) {
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
        return bo(i2, f(i2, view, z));
    }

    private int bo(int i2, int i3) {
        this.mListView.getDividerHeight();
        boolean z = this.fIR && this.fIP != this.fIQ;
        int i4 = this.dtn - this.fIY;
        int i5 = (int) (this.fJu * i4);
        if (i2 == this.fIS) {
            if (this.fIS == this.fIP) {
                if (z) {
                    return i5 + this.fIY;
                }
                return this.dtn;
            } else if (this.fIS == this.fIQ) {
                return this.dtn - i5;
            } else {
                return this.fIY;
            }
        } else if (i2 == this.fIP) {
            if (z) {
                return i3 + i5;
            }
            return i3 + i4;
        } else if (i2 == this.fIQ) {
            return (i3 + i4) - i5;
        } else {
            return i3;
        }
    }

    private int b(int i2, View view, int i3, int i4) {
        int i5;
        int i6;
        int tc = tc(i2);
        int height = view.getHeight();
        int bo = bo(i2, tc);
        if (i2 != this.fIS) {
            i6 = height - tc;
            i5 = bo - tc;
        } else {
            i5 = bo;
            i6 = height;
        }
        int i7 = this.dtn;
        if (this.fIS != this.fIP && this.fIS != this.fIQ) {
            i7 -= this.fIY;
        }
        if (i2 <= i3) {
            if (i2 > this.fIP) {
                return (i7 - i5) + 0;
            }
        } else if (i2 == i4) {
            if (i2 <= this.fIP) {
                return (i6 - i7) + 0;
            }
            if (i2 == this.fIQ) {
                return (height - bo) + 0;
            }
            return 0 + i6;
        } else if (i2 <= this.fIP) {
            return 0 - i7;
        } else {
            if (i2 == this.fIQ) {
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

    private void bHI() {
        if (this.fIH != null) {
            measureItem(this.fIH);
            this.dtn = this.fIH.getMeasuredHeight();
            this.fIZ = this.dtn / 2;
        }
    }

    protected boolean onDragTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        switch (motionEvent.getAction() & 255) {
            case 1:
                if (this.mDragState == 4) {
                    stopDrag(false);
                }
                bHF();
                return true;
            case 2:
                bn((int) motionEvent.getX(), (int) motionEvent.getY());
                return true;
            case 3:
                if (this.mDragState == 4) {
                    cancelDrag();
                }
                bHF();
                return true;
            default:
                return true;
        }
    }

    public boolean startDrag(int i2, int i3, int i4, int i5) {
        View te;
        if (!this.fJp || this.fJq == null || (te = this.fJq.te(i2)) == null) {
            return false;
        }
        return startDrag(i2, te, i3, i4, i5);
    }

    public boolean startDrag(int i2, View view, int i3, int i4, int i5) {
        if (this.mDragState == 0 && this.fJp && this.fIH == null && view != null && this.dKJ) {
            if (this.mListView.getParent() != null) {
                this.mListView.getParent().requestDisallowInterceptTouchEvent(true);
            }
            int headerViewsCount = this.mListView.getHeaderViewsCount() + i2;
            this.fIP = headerViewsCount;
            this.fIQ = headerViewsCount;
            this.fIS = headerViewsCount;
            this.fIO = headerViewsCount;
            this.mDragState = 4;
            this.fJn = 0;
            this.fJn |= i3;
            this.fIH = view;
            bHI();
            this.fIT = i4;
            this.fIU = i5;
            this.fJm = this.cHD;
            this.fII.x = this.cHC - this.fIT;
            this.fII.y = this.cHD - this.fIU;
            View childAt = this.mListView.getChildAt(this.fIS - this.mListView.getFirstVisiblePosition());
            if (childAt != null) {
                childAt.setVisibility(4);
            }
            if (this.fJw) {
                this.fJx.bHM();
            }
            switch (this.fJs) {
                case 1:
                    this.fJF.onTouchEvent(this.fJr);
                    break;
                case 2:
                    this.fJF.onInterceptTouchEvent(this.fJr);
                    break;
            }
            this.mListView.requestLayout();
            if (this.fJB != null) {
                this.fJB.start();
                return true;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lh(boolean z) {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition() + (this.mListView.getChildCount() / 2);
        View childAt = this.mListView.getChildAt(this.mListView.getChildCount() / 2);
        if (childAt != null) {
            h(firstVisiblePosition, childAt, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i2, View view, boolean z) {
        this.mBlockLayoutRequests = true;
        bHJ();
        int i3 = this.fIP;
        int i4 = this.fIQ;
        boolean bHA = bHA();
        if (bHA) {
            bHH();
            this.mListView.setSelectionFromTop(i2, (b(i2, view, i3, i4) + view.getTop()) - this.mListView.getPaddingTop());
            layoutChildren();
        }
        if (bHA || z) {
            this.mListView.invalidate();
        }
        this.mBlockLayoutRequests = false;
    }

    private void bHJ() {
        if (this.fJq != null) {
            this.fIJ.set(this.cHC, this.cHD);
            this.fJq.b(this.fIH, this.fII, this.fIJ);
        }
        int i2 = this.fII.x;
        int i3 = this.fII.y;
        int paddingLeft = this.mListView.getPaddingLeft();
        if ((this.fJn & 1) == 0 && i2 > paddingLeft) {
            this.fII.x = paddingLeft;
        } else if ((this.fJn & 2) == 0 && i2 < paddingLeft) {
            this.fII.x = paddingLeft;
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int lastVisiblePosition = this.mListView.getLastVisiblePosition();
        int paddingTop = this.mListView.getPaddingTop();
        if (firstVisiblePosition < headerViewsCount) {
            paddingTop = this.mListView.getChildAt((headerViewsCount - firstVisiblePosition) - 1).getBottom();
        }
        if ((this.fJn & 8) == 0 && firstVisiblePosition <= this.fIS) {
            paddingTop = Math.max(this.mListView.getChildAt(this.fIS - firstVisiblePosition).getTop(), paddingTop);
        }
        int height = this.mListView.getHeight() - this.mListView.getPaddingBottom();
        if (lastVisiblePosition >= (this.mListView.getCount() - footerViewsCount) - 1) {
            height = this.mListView.getChildAt(((this.mListView.getCount() - footerViewsCount) - 1) - firstVisiblePosition).getBottom();
        }
        if ((this.fJn & 4) == 0 && lastVisiblePosition >= this.fIS) {
            height = Math.min(this.mListView.getChildAt(this.fIS - firstVisiblePosition).getBottom(), height);
        }
        if (i3 < paddingTop) {
            this.fII.y = paddingTop;
        } else if (this.dtn + i3 > height) {
            this.fII.y = height - this.dtn;
        }
        this.fIK = this.fII.y + this.fIZ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHK() {
        if (this.fIH != null) {
            this.fIH.setVisibility(8);
            if (this.fJq != null) {
                this.fJq.bR(this.fIH);
            }
            this.fIH = null;
            this.mListView.invalidate();
        }
    }

    public void a(h hVar) {
        this.fJq = hVar;
    }

    public void a(b bVar) {
        this.fIV = bVar;
    }

    public void setDragEnabled(boolean z) {
        this.dKJ = z;
    }

    public boolean isDragEnabled() {
        return this.dKJ;
    }

    public void a(g gVar) {
        this.fIW = gVar;
    }

    public void a(l lVar) {
        this.fIX = lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class i {
        private SparseIntArray fKb;
        private ArrayList<Integer> fKc;
        private int mMaxSize;

        public i(int i) {
            this.fKb = new SparseIntArray(i);
            this.fKc = new ArrayList<>(i);
            this.mMaxSize = i;
        }

        public void bp(int i, int i2) {
            int i3 = this.fKb.get(i, -1);
            if (i3 != i2) {
                if (i3 == -1) {
                    if (this.fKb.size() == this.mMaxSize) {
                        this.fKb.delete(this.fKc.remove(0).intValue());
                    }
                } else {
                    this.fKc.remove(Integer.valueOf(i));
                }
                this.fKb.put(i, i2);
                this.fKc.add(Integer.valueOf(i));
            }
        }

        public int get(int i) {
            return this.fKb.get(i, -1);
        }

        public void clear() {
            this.fKb.clear();
            this.fKc.clear();
        }
    }

    /* renamed from: com.baidu.tbadk.widget.dragsort.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0612a extends BaseAdapter {
        private ListAdapter mAdapter;

        public C0612a(ListAdapter listAdapter) {
            this.mAdapter = listAdapter;
            this.mAdapter.registerDataSetObserver(new DataSetObserver() { // from class: com.baidu.tbadk.widget.dragsort.a.a.1
                @Override // android.database.DataSetObserver
                public void onChanged() {
                    C0612a.this.notifyDataSetChanged();
                }

                @Override // android.database.DataSetObserver
                public void onInvalidated() {
                    C0612a.this.notifyDataSetInvalidated();
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
        private float cHT;
        private float cHU;
        private float cHV;
        private float cHW;
        private float fKm;
        private float mAlpha;
        private boolean mCanceled;
        protected long mStartTime;

        public m(float f, int i) {
            this.mAlpha = f;
            this.fKm = i;
            float f2 = 1.0f / ((this.mAlpha * 2.0f) * (1.0f - this.mAlpha));
            this.cHW = f2;
            this.cHT = f2;
            this.cHU = this.mAlpha / ((this.mAlpha - 1.0f) * 2.0f);
            this.cHV = 1.0f / (1.0f - this.mAlpha);
        }

        public float ao(float f) {
            if (f < this.mAlpha) {
                return this.cHT * f * f;
            }
            if (f < 1.0f - this.mAlpha) {
                return this.cHU + (this.cHV * f);
            }
            return 1.0f - ((this.cHW * (f - 1.0f)) * (f - 1.0f));
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
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / this.fKm;
                if (uptimeMillis >= 1.0f) {
                    x(1.0f, 1.0f);
                    onStop();
                    return;
                }
                x(uptimeMillis, ao(uptimeMillis));
                a.this.mListView.post(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class f extends m {
        private int fJX;
        private int fJY;
        private float fJZ;
        private float fKa;

        public f(float f, int i) {
            super(f, i);
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.fJX = a.this.fIO;
            this.fJY = a.this.fIS;
            a.this.mDragState = 2;
            this.fJZ = a.this.fII.y - bHO();
            this.fKa = a.this.fII.x - a.this.mListView.getPaddingLeft();
        }

        private int bHO() {
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            int dividerHeight = (a.this.fIY + a.this.mListView.getDividerHeight()) / 2;
            View childAt = a.this.mListView.getChildAt(this.fJX - firstVisiblePosition);
            if (childAt != null) {
                if (this.fJX == this.fJY) {
                    return childAt.getTop();
                }
                if (this.fJX >= this.fJY) {
                    return (childAt.getBottom() + dividerHeight) - a.this.dtn;
                }
                return childAt.getTop() - dividerHeight;
            }
            cancel();
            return -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void x(float f, float f2) {
            int bHO = bHO();
            float paddingLeft = a.this.fII.x - a.this.mListView.getPaddingLeft();
            float f3 = 1.0f - f2;
            if (f3 < Math.abs((a.this.fII.y - bHO) / this.fJZ) || f3 < Math.abs(paddingLeft / this.fKa)) {
                a.this.fII.y = bHO + ((int) (this.fJZ * f3));
                a.this.fII.x = a.this.mListView.getPaddingLeft() + ((int) (this.fKa * f3));
                a.this.lh(true);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.bHC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class k extends m {
        private int fJY;
        private float fKf;
        private float fKg;
        private float fKh;
        private int fKi;
        private int fKj;
        private int fKk;
        private int fKl;

        public k(float f, int i) {
            super(f, i);
            this.fKi = -1;
            this.fKj = -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.fKi = -1;
            this.fKj = -1;
            this.fKk = a.this.fIP;
            this.fKl = a.this.fIQ;
            this.fJY = a.this.fIS;
            a.this.mDragState = 1;
            this.fKf = a.this.fII.x;
            if (a.this.fJD) {
                float width = a.this.mListView.getWidth() * 2.0f;
                if (a.this.fJE == 0.0f) {
                    a.this.fJE = (this.fKf >= 0.0f ? 1 : -1) * width;
                    return;
                }
                float f = width * 2.0f;
                if (a.this.fJE >= 0.0f || a.this.fJE <= (-f)) {
                    if (a.this.fJE > 0.0f && a.this.fJE < f) {
                        a.this.fJE = f;
                        return;
                    }
                    return;
                }
                a.this.fJE = -f;
                return;
            }
            a.this.bHK();
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void x(float f, float f2) {
            View childAt;
            float f3 = 1.0f - f2;
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            View childAt2 = a.this.mListView.getChildAt(this.fKk - firstVisiblePosition);
            if (a.this.fJD) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / 1000.0f;
                if (uptimeMillis != 0.0f) {
                    float f4 = a.this.fJE * uptimeMillis;
                    int width = a.this.mListView.getWidth();
                    a.this.fJE = ((a.this.fJE > 0.0f ? 1 : -1) * uptimeMillis * width) + a.this.fJE;
                    this.fKf += f4;
                    a.this.fII.x = (int) this.fKf;
                    if (this.fKf < width && this.fKf > (-width)) {
                        this.mStartTime = SystemClock.uptimeMillis();
                        a.this.lh(true);
                        return;
                    }
                } else {
                    return;
                }
            }
            if (childAt2 != null) {
                if (this.fKi == -1) {
                    this.fKi = a.this.f(this.fKk, childAt2, false);
                    this.fKg = childAt2.getHeight() - this.fKi;
                }
                int max = Math.max((int) (this.fKg * f3), 1);
                ViewGroup.LayoutParams layoutParams = childAt2.getLayoutParams();
                layoutParams.height = max + this.fKi;
                childAt2.setLayoutParams(layoutParams);
            }
            if (this.fKl != this.fKk && (childAt = a.this.mListView.getChildAt(this.fKl - firstVisiblePosition)) != null) {
                if (this.fKj == -1) {
                    this.fKj = a.this.f(this.fKl, childAt, false);
                    this.fKh = childAt.getHeight() - this.fKj;
                }
                int max2 = Math.max((int) (this.fKh * f3), 1);
                ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
                layoutParams2.height = max2 + this.fKj;
                childAt.setLayoutParams(layoutParams2);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.bHD();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class j extends m {
        final /* synthetic */ a fJJ;
        private float fKd;
        private float fKe;

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.fKd = this.fJJ.fIU;
            this.fKe = this.fJJ.fIZ;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void x(float f, float f2) {
            if (this.fJJ.mDragState != 4) {
                cancel();
                return;
            }
            this.fJJ.fIU = (int) ((this.fKe * f2) + ((1.0f - f2) * this.fKd));
            this.fJJ.fII.y = this.fJJ.cHD - this.fJJ.fIU;
            this.fJJ.lh(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e {
        StringBuilder mBuilder = new StringBuilder();
        private int fJU = 0;
        private int fJV = 0;
        private boolean fJW = false;
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

        public void bHM() {
            this.mBuilder.append("<DSLVStates>\n");
            this.fJV = 0;
            this.fJW = true;
        }

        public void bHN() {
            if (this.fJW) {
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
                this.mBuilder.append("    <FirstExpPos>").append(a.this.fIP).append("</FirstExpPos>\n");
                this.mBuilder.append("    <FirstExpBlankHeight>").append(a.this.ta(a.this.fIP) - a.this.tc(a.this.fIP)).append("</FirstExpBlankHeight>\n");
                this.mBuilder.append("    <SecondExpPos>").append(a.this.fIQ).append("</SecondExpPos>\n");
                this.mBuilder.append("    <SecondExpBlankHeight>").append(a.this.ta(a.this.fIQ) - a.this.tc(a.this.fIQ)).append("</SecondExpBlankHeight>\n");
                this.mBuilder.append("    <SrcPos>").append(a.this.fIS).append("</SrcPos>\n");
                this.mBuilder.append("    <SrcHeight>").append(a.this.dtn + a.this.mListView.getDividerHeight()).append("</SrcHeight>\n");
                this.mBuilder.append("    <ViewHeight>").append(a.this.mListView.getHeight()).append("</ViewHeight>\n");
                this.mBuilder.append("    <LastY>").append(a.this.mLastY).append("</LastY>\n");
                this.mBuilder.append("    <FloatY>").append(a.this.fIK).append("</FloatY>\n");
                this.mBuilder.append("    <ShuffleEdges>");
                for (int i4 = 0; i4 < childCount; i4++) {
                    this.mBuilder.append(a.this.bm(firstVisiblePosition + i4, a.this.mListView.getChildAt(i4).getTop())).append(",");
                }
                this.mBuilder.append("</ShuffleEdges>\n");
                this.mBuilder.append("</DSLVState>\n");
                this.fJU++;
                if (this.fJU > 1000) {
                    flush();
                    this.fJU = 0;
                }
            }
        }

        public void flush() {
            if (this.fJW) {
                try {
                    FileWriter fileWriter = new FileWriter(this.mFile, this.fJV != 0);
                    fileWriter.write(this.mBuilder.toString());
                    this.mBuilder.delete(0, this.mBuilder.length());
                    fileWriter.flush();
                    fileWriter.close();
                    this.fJV++;
                } catch (IOException e) {
                }
            }
        }

        public void stopTracking() {
            if (this.fJW) {
                this.mBuilder.append("</DSLVStates>\n");
                flush();
                this.fJW = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements Runnable {
        private boolean fJM;
        private long fJN;
        private long fJO;
        private int fJP;
        private float fJQ;
        private long fJR;
        private int fJS;
        private float fJT;
        private boolean mScrolling = false;

        public boolean isScrolling() {
            return this.mScrolling;
        }

        public int bHL() {
            if (this.mScrolling) {
                return this.fJS;
            }
            return -1;
        }

        public d() {
        }

        public void td(int i) {
            if (!this.mScrolling) {
                this.fJM = false;
                this.mScrolling = true;
                this.fJR = SystemClock.uptimeMillis();
                this.fJN = this.fJR;
                this.fJS = i;
                a.this.mListView.post(this);
            }
        }

        public void li(boolean z) {
            if (z) {
                a.this.mListView.removeCallbacks(this);
                this.mScrolling = false;
                return;
            }
            this.fJM = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.fJM) {
                int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
                int lastVisiblePosition = a.this.mListView.getLastVisiblePosition();
                int count = a.this.mListView.getCount();
                int paddingTop = a.this.mListView.getPaddingTop();
                int height = (a.this.mListView.getHeight() - paddingTop) - a.this.mListView.getPaddingBottom();
                int min = Math.min(a.this.cHD, a.this.fIK + a.this.fIZ);
                int max = Math.max(a.this.cHD, a.this.fIK - a.this.fIZ);
                if (this.fJS == 0) {
                    View childAt = a.this.mListView.getChildAt(0);
                    if (childAt == null) {
                        this.mScrolling = false;
                        return;
                    } else if (firstVisiblePosition == 0 && childAt.getTop() == paddingTop) {
                        this.mScrolling = false;
                        return;
                    } else {
                        this.fJT = a.this.fJl.b((a.this.fJh - max) / a.this.fJi, this.fJN);
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
                        this.fJT = -a.this.fJl.b((min - a.this.fJg) / a.this.fJj, this.fJN);
                    }
                }
                this.fJO = SystemClock.uptimeMillis();
                this.fJQ = (float) (this.fJO - this.fJN);
                this.fJP = Math.round(this.fJT * this.fJQ);
                if (this.fJP >= 0) {
                    this.fJP = Math.min(height, this.fJP);
                    lastVisiblePosition = firstVisiblePosition;
                } else {
                    this.fJP = Math.max(-height, this.fJP);
                }
                View childAt3 = a.this.mListView.getChildAt(lastVisiblePosition - firstVisiblePosition);
                int top = childAt3.getTop() + this.fJP;
                if (lastVisiblePosition == 0 && top > paddingTop) {
                    top = paddingTop;
                }
                a.this.mBlockLayoutRequests = true;
                a.this.mListView.setSelectionFromTop(lastVisiblePosition, top - paddingTop);
                a.this.layoutChildren();
                a.this.mListView.invalidate();
                a.this.mBlockLayoutRequests = false;
                a.this.h(lastVisiblePosition, childAt3, false);
                this.fJN = this.fJO;
                a.this.mListView.post(this);
                return;
            }
            this.mScrolling = false;
        }
    }
}
