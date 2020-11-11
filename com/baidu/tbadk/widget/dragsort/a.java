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
    private int dnT;
    private int fBA;
    private int fBB;
    private int fBD;
    private int fBE;
    private int fBF;
    private b fBG;
    private g fBH;
    private l fBI;
    private int fBK;
    private d fBM;
    private int fBP;
    private int fBQ;
    private float fBR;
    private float fBS;
    private float fBT;
    private float fBU;
    private int fBX;
    private View fBs;
    private int fBv;
    private int fBz;
    private MotionEvent fCc;
    private C0600a fCg;
    private e fCi;
    private k fCl;
    private j fCm;
    private f fCn;
    private boolean fCo;
    private com.baidu.tbadk.widget.dragsort.d fCq;
    private com.baidu.tbadk.widget.dragsort.b fCr;
    private int mLastX;
    private int mLastY;
    private ListView mListView;
    private DataSetObserver mObserver;
    private int mOffsetX;
    private int mOffsetY;
    private int mX;
    private int mY;
    private Point fBt = new Point();
    private Point fBu = new Point();
    private boolean fBw = false;
    private float fBx = 1.0f;
    private float fBy = 1.0f;
    private boolean fBC = false;
    private boolean dFs = true;
    private int mDragState = 0;
    private int fBJ = 1;
    private int mWidthMeasureSpec = 0;
    private View[] fBL = new View[1];
    private float fBN = 0.33333334f;
    private float fBO = 0.33333334f;
    private float fBV = 0.5f;
    private c fBW = new c() { // from class: com.baidu.tbadk.widget.dragsort.a.1
        @Override // com.baidu.tbadk.widget.dragsort.a.c
        public float b(float f2, long j2) {
            return a.this.fBV * f2;
        }
    };
    private int fBY = 0;
    private boolean fBZ = false;
    private boolean fCa = false;
    private h fCb = null;
    private int fCd = 0;
    private float fCe = 0.25f;
    private float fCf = 0.0f;
    private boolean fCh = false;
    private boolean mBlockLayoutRequests = false;
    private boolean fCj = false;
    private i fCk = new i(3);
    private float fCp = 0.0f;
    private boolean fCs = false;
    private boolean fCt = false;

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

        void bH(View view);

        View sd(int i);
    }

    /* loaded from: classes.dex */
    public interface l {
        void remove(int i);
    }

    public a(ListView listView, com.baidu.tbadk.widget.dragsort.d dVar) {
        this.fCq = dVar;
        this.mListView = listView;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            this.fCg = new C0600a(listAdapter);
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
            this.fCg = null;
        }
        this.fCq.setAdapter(this.fCg);
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
            if (i2 > this.fBD) {
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
    public int rZ(int i2) {
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        return childAt != null ? childAt.getHeight() : bm(i2, sb(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bk(int i2, int i3) {
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        if (i2 <= headerViewsCount || i2 >= this.mListView.getCount() - footerViewsCount) {
            return i3;
        }
        int dividerHeight = this.mListView.getDividerHeight();
        int i4 = this.dnT - this.fBJ;
        int sb = sb(i2);
        int rZ = rZ(i2);
        if (this.fBB <= this.fBD) {
            if (i2 == this.fBB && this.fBA != this.fBB) {
                if (i2 == this.fBD) {
                    i3 = (i3 + rZ) - this.dnT;
                } else {
                    i3 = ((rZ - sb) + i3) - i4;
                }
            } else if (i2 > this.fBB && i2 <= this.fBD) {
                i3 -= i4;
            }
        } else if (i2 > this.fBD && i2 <= this.fBA) {
            i3 += i4;
        } else if (i2 == this.fBB && this.fBA != this.fBB) {
            i3 += rZ - sb;
        }
        if (i2 <= this.fBD) {
            return (((this.dnT - dividerHeight) - sb(i2 - 1)) / 2) + i3;
        }
        return (((sb - dividerHeight) - this.dnT) / 2) + i3;
    }

    private boolean bEG() {
        int i2;
        int i3;
        int i4;
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int i5 = this.fBA;
        View childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        if (childAt == null) {
            i5 = firstVisiblePosition + (this.mListView.getChildCount() / 2);
            childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        }
        int top = childAt.getTop();
        int height = childAt.getHeight();
        int bk = bk(i5, top);
        int dividerHeight = this.mListView.getDividerHeight();
        if (this.fBv >= bk) {
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
                    i6 = rZ(i3 + 1);
                    i2 = bk(i3 + 1, i7);
                    if (this.fBv < i2) {
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
                int rZ = rZ(i3);
                if (i3 == 0) {
                    i2 = (i8 - dividerHeight) - rZ;
                    break;
                }
                i8 -= rZ + dividerHeight;
                i2 = bk(i3, i8);
                if (this.fBv >= i2) {
                    break;
                }
                i4 = i2;
            }
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int i9 = this.fBA;
        int i10 = this.fBB;
        float f2 = this.fCf;
        if (this.fBC) {
            int abs = Math.abs(i2 - i4);
            if (this.fBv >= i2) {
                int i11 = i4;
                i4 = i2;
                i2 = i11;
            }
            int i12 = (int) (abs * this.fCe * 0.5f);
            float f3 = i12;
            int i13 = i4 + i12;
            int i14 = i2 - i12;
            if (this.fBv < i13) {
                this.fBA = i3 - 1;
                this.fBB = i3;
                this.fCf = ((i13 - this.fBv) * 0.5f) / f3;
            } else if (this.fBv < i14) {
                this.fBA = i3;
                this.fBB = i3;
            } else {
                this.fBA = i3;
                this.fBB = i3 + 1;
                this.fCf = (1.0f + ((i2 - this.fBv) / f3)) * 0.5f;
            }
        } else {
            this.fBA = i3;
            this.fBB = i3;
        }
        if (this.fBA < headerViewsCount) {
            this.fBA = headerViewsCount;
            this.fBB = headerViewsCount;
            i3 = headerViewsCount;
        } else if (this.fBB >= this.mListView.getCount() - footerViewsCount) {
            i3 = (this.mListView.getCount() - footerViewsCount) - 1;
            this.fBA = i3;
            this.fBB = i3;
        }
        boolean z = (this.fBA == i9 && this.fBB == i10 && this.fCf == f2) ? false : true;
        if (i3 != this.fBz) {
            if (this.fBG != null) {
                this.fBG.drag(this.fBz - headerViewsCount, i3 - headerViewsCount);
            }
            this.fBz = i3;
            return true;
        }
        return z;
    }

    public void removeItem(int i2) {
        this.fCo = false;
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
            this.fBJ = Math.max(1, obtainStyledAttributes.getDimensionPixelSize(R.styleable.DragSort_collapsed_height, 1));
            this.fCh = obtainStyledAttributes.getBoolean(R.styleable.DragSort_track_drag_sort, false);
            if (this.fCh) {
                this.fCi = new e();
            }
            this.fBx = obtainStyledAttributes.getFloat(R.styleable.DragSort_float_alpha, this.fBx);
            this.fBy = this.fBx;
            this.dFs = obtainStyledAttributes.getBoolean(R.styleable.DragSort_drag_enabled, this.dFs);
            this.fCe = Math.max(0.0f, Math.min(1.0f, 1.0f - obtainStyledAttributes.getFloat(R.styleable.DragSort_slide_shuffle_speed, 0.75f)));
            this.fBC = this.fCe > 0.0f;
            setDragScrollStart(obtainStyledAttributes.getFloat(R.styleable.DragSort_drag_scroll_start, this.fBN));
            this.fBV = obtainStyledAttributes.getFloat(R.styleable.DragSort_max_drag_scroll_speed, this.fBV);
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
                bVar.kP(z);
                bVar.kO(z2);
                bVar.setBackgroundColor(color);
                this.fCb = bVar;
                a(bVar);
            }
            obtainStyledAttributes.recycle();
            i2 = i5;
            i3 = i4;
        }
        this.fBM = new d();
        if (i3 > 0) {
            this.fCl = new k(0.5f, i3);
        }
        if (i2 > 0) {
            this.fCn = new f(0.5f, i2);
        }
        this.fCc = MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
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
        this.fCr = bVar;
        this.mListView.setOnTouchListener(bVar);
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void dispatchDraw(Canvas canvas) {
        float f2;
        this.fCq.dispatchDraw(canvas);
        if (this.mDragState != 0) {
            if (this.fBA != this.fBD) {
                b(this.fBA, canvas);
            }
            if (this.fBB != this.fBA && this.fBB != this.fBD) {
                b(this.fBB, canvas);
            }
        }
        if (this.fBs != null) {
            int width = this.fBs.getWidth();
            int height = this.fBs.getHeight();
            int i2 = this.fBt.x;
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
            int i3 = (int) (f2 * 255.0f * this.fBy);
            canvas.save();
            canvas.translate(this.fBt.x, this.fBt.y);
            canvas.clipRect(0, 0, width, height);
            canvas.saveLayerAlpha(0.0f, 0.0f, width, height, i3, 31);
            this.fBs.draw(canvas);
            canvas.restore();
            canvas.restore();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onDraw(Canvas canvas) {
        this.fCq.onDraw(canvas);
        if (this.fCh) {
            this.fCi.bET();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.fCj) {
            this.fCj = false;
            return false;
        } else if (!this.dFs) {
            return this.fCq.onTouchEvent(motionEvent);
        } else {
            boolean z2 = this.fBZ;
            this.fBZ = false;
            if (!z2) {
                G(motionEvent);
            }
            if (this.mDragState == 4) {
                onDragTouchEvent(motionEvent);
                return true;
            }
            if (this.mDragState == 0 && this.fCq.onTouchEvent(motionEvent)) {
                z = true;
            }
            switch (motionEvent.getAction() & 255) {
                case 1:
                case 3:
                    bEL();
                    return z;
                case 2:
                default:
                    if (z) {
                        this.fCd = 1;
                        return z;
                    }
                    return z;
            }
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (!this.dFs) {
            return this.fCq.onInterceptTouchEvent(motionEvent);
        }
        if (this.fCr != null) {
            this.fCr.bEV().onTouchEvent(motionEvent);
        }
        G(motionEvent);
        this.fBZ = true;
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            if (this.mDragState != 0) {
                this.fCj = true;
                return true;
            }
            this.fCa = true;
        }
        if (this.fBs == null) {
            if (this.fCq.onInterceptTouchEvent(motionEvent)) {
                this.fCs = true;
                z = true;
            } else {
                z = false;
            }
            switch (action) {
                case 1:
                case 3:
                    bEL();
                    break;
                case 2:
                default:
                    if (z) {
                        this.fCd = 1;
                        break;
                    } else {
                        this.fCd = 2;
                        break;
                    }
            }
        } else {
            z = true;
        }
        if (action == 1 || action == 3) {
            this.fCa = false;
        }
        return z;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        this.fCq.onSizeChanged(i2, i3, i4, i5);
        bEM();
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void requestLayout() {
        if (!this.mBlockLayoutRequests) {
            this.fCq.requestLayout();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onMeasure(int i2, int i3) {
        this.fCq.onMeasure(i2, i3);
        if (this.fBs != null) {
            if (this.fBs.isLayoutRequested()) {
                bEO();
            }
            this.fBw = true;
        }
        this.mWidthMeasureSpec = i2;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void layoutChildren() {
        this.fCq.layoutChildren();
        if (this.fBs != null) {
            if (this.fBs.isLayoutRequested() && !this.fBw) {
                bEO();
            }
            this.fBs.layout(0, 0, this.fBs.getMeasuredWidth(), this.fBs.getMeasuredHeight());
            this.fBw = false;
        }
    }

    public void removeItem(int i2, float f2) {
        if (this.mDragState == 0 || this.mDragState == 4) {
            if (this.mDragState == 0) {
                this.fBD = this.mListView.getHeaderViewsCount() + i2;
                this.fBA = this.fBD;
                this.fBB = this.fBD;
                this.fBz = this.fBD;
                View childAt = this.mListView.getChildAt(this.fBD - this.mListView.getFirstVisiblePosition());
                if (childAt != null) {
                    childAt.setVisibility(4);
                }
            }
            this.mDragState = 1;
            this.fCp = f2;
            if (this.fCa) {
                switch (this.fCd) {
                    case 1:
                        this.fCq.onTouchEvent(this.fCc);
                        break;
                    case 2:
                        this.fCq.onInterceptTouchEvent(this.fCc);
                        break;
                }
            }
            if (this.fCl != null) {
                this.fCl.start();
            } else {
                sa(i2);
            }
        }
    }

    public void cancelDrag() {
        if (this.mDragState == 4) {
            this.fBM.kN(true);
            bEQ();
            bEH();
            bEN();
            if (this.fCa) {
                this.mDragState = 3;
            } else {
                this.mDragState = 0;
            }
        }
    }

    private void bEH() {
        this.fBD = -1;
        this.fBA = -1;
        this.fBB = -1;
        this.fBz = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEI() {
        this.mDragState = 2;
        if (this.fBH != null && this.fBz >= 0 && this.fBz < this.mListView.getCount()) {
            int headerViewsCount = this.mListView.getHeaderViewsCount();
            this.fBH.drop(this.fBD - headerViewsCount, this.fBz - headerViewsCount);
        }
        bEQ();
        bEK();
        bEH();
        bEN();
        if (this.fCa) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEJ() {
        sa(this.fBD - this.mListView.getHeaderViewsCount());
    }

    private void sa(int i2) {
        this.mDragState = 1;
        if (this.fBI != null) {
            this.fBI.remove(i2);
        }
        bEQ();
        bEK();
        bEH();
        if (this.fCa) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    private void bEK() {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        if (this.fBD < firstVisiblePosition) {
            View childAt = this.mListView.getChildAt(0);
            this.mListView.setSelectionFromTop(firstVisiblePosition - 1, (childAt != null ? childAt.getTop() : 0) - this.mListView.getPaddingTop());
        }
    }

    public boolean stopDrag(boolean z) {
        this.fCo = false;
        return stopDrag(z, 0.0f);
    }

    public boolean stopDragWithVelocity(boolean z, float f2) {
        this.fCo = true;
        return stopDrag(z, f2);
    }

    public boolean stopDrag(boolean z, float f2) {
        if (this.fBs != null) {
            this.fBM.kN(true);
            if (z) {
                removeItem(this.fBD - this.mListView.getHeaderViewsCount(), f2);
            } else if (this.fCn != null) {
                this.fCn.start();
            } else {
                bEI();
            }
            if (this.fCh) {
                this.fCi.stopTracking();
                return true;
            }
            return true;
        }
        return false;
    }

    private void bEL() {
        this.fCd = 0;
        this.fCa = false;
        if (this.mDragState == 3) {
            this.mDragState = 0;
        }
        this.fBy = this.fBx;
        this.fCs = false;
        this.fCk.clear();
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
        return this.fCs;
    }

    public void setDragScrollStart(float f2) {
        setDragScrollStarts(f2, f2);
    }

    public void setDragScrollStarts(float f2, float f3) {
        if (f3 > 0.5f) {
            this.fBO = 0.5f;
        } else {
            this.fBO = f3;
        }
        if (f2 > 0.5f) {
            this.fBN = 0.5f;
        } else {
            this.fBN = f2;
        }
        if (this.mListView.getHeight() != 0) {
            bEM();
        }
    }

    private void bl(int i2, int i3) {
        this.fBt.x = i2 - this.fBE;
        this.fBt.y = i3 - this.fBF;
        kM(true);
        int min = Math.min(i3, this.fBv + this.fBK);
        int max = Math.max(i3, this.fBv - this.fBK);
        int bER = this.fBM.bER();
        if (min > this.mLastY && min > this.fBQ && bER != 1) {
            if (bER != -1) {
                this.fBM.kN(true);
            }
            this.fBM.sc(1);
        } else if (max < this.mLastY && max < this.fBP && bER != 0) {
            if (bER != -1) {
                this.fBM.kN(true);
            }
            this.fBM.sc(0);
        } else if (max >= this.fBP && min <= this.fBQ && this.fBM.isScrolling()) {
            this.fBM.kN(true);
        }
    }

    private void bEM() {
        int height;
        int paddingTop = this.mListView.getPaddingTop();
        float height2 = (this.mListView.getHeight() - paddingTop) - this.mListView.getPaddingBottom();
        this.fBS = paddingTop + (this.fBN * height2);
        this.fBR = (height2 * (1.0f - this.fBO)) + paddingTop;
        this.fBP = (int) this.fBS;
        this.fBQ = (int) this.fBR;
        this.fBT = this.fBS - paddingTop;
        this.fBU = (paddingTop + height) - this.fBR;
    }

    private void bEN() {
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
        if (i2 != this.fBD && i2 != this.fBA && i2 != this.fBB) {
            g2 = -2;
        } else {
            g2 = g(i2, view, z);
        }
        if (g2 != layoutParams.height) {
            layoutParams.height = g2;
            view.setLayoutParams(layoutParams);
        }
        if (i2 == this.fBA || i2 == this.fBB) {
            if (i2 < this.fBD) {
                ((DragSortItemView) view).setGravity(80);
            } else if (i2 > this.fBD) {
                ((DragSortItemView) view).setGravity(48);
            }
        }
        int visibility = view.getVisibility();
        int i3 = 0;
        if (i2 == this.fBD && this.fBs != null) {
            i3 = 4;
        }
        if (i3 != visibility) {
            view.setVisibility(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int sb(int i2) {
        View view;
        if (i2 == this.fBD) {
            return 0;
        }
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        if (childAt != null) {
            return f(i2, childAt, false);
        }
        int i3 = this.fCk.get(i2);
        if (i3 == -1) {
            ListAdapter adapter = this.mListView.getAdapter();
            int itemViewType = adapter.getItemViewType(i2);
            int viewTypeCount = adapter.getViewTypeCount();
            if (viewTypeCount != this.fBL.length) {
                this.fBL = new View[viewTypeCount];
            }
            if (itemViewType >= 0) {
                if (this.fBL[itemViewType] == null) {
                    view = adapter.getView(i2, null, this.mListView);
                    this.fBL[itemViewType] = view;
                } else {
                    view = adapter.getView(i2, this.fBL[itemViewType], this.mListView);
                }
            } else {
                view = adapter.getView(i2, null, this.mListView);
            }
            int f2 = f(i2, view, true);
            this.fCk.bn(i2, f2);
            return f2;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(int i2, View view, boolean z) {
        if (i2 == this.fBD) {
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
        boolean z = this.fBC && this.fBA != this.fBB;
        int i4 = this.dnT - this.fBJ;
        int i5 = (int) (this.fCf * i4);
        if (i2 == this.fBD) {
            if (this.fBD == this.fBA) {
                if (z) {
                    return i5 + this.fBJ;
                }
                return this.dnT;
            } else if (this.fBD == this.fBB) {
                return this.dnT - i5;
            } else {
                return this.fBJ;
            }
        } else if (i2 == this.fBA) {
            if (z) {
                return i3 + i5;
            }
            return i3 + i4;
        } else if (i2 == this.fBB) {
            return (i3 + i4) - i5;
        } else {
            return i3;
        }
    }

    private int b(int i2, View view, int i3, int i4) {
        int i5;
        int i6;
        int sb = sb(i2);
        int height = view.getHeight();
        int bm = bm(i2, sb);
        if (i2 != this.fBD) {
            i6 = height - sb;
            i5 = bm - sb;
        } else {
            i5 = bm;
            i6 = height;
        }
        int i7 = this.dnT;
        if (this.fBD != this.fBA && this.fBD != this.fBB) {
            i7 -= this.fBJ;
        }
        if (i2 <= i3) {
            if (i2 > this.fBA) {
                return (i7 - i5) + 0;
            }
        } else if (i2 == i4) {
            if (i2 <= this.fBA) {
                return (i6 - i7) + 0;
            }
            if (i2 == this.fBB) {
                return (height - bm) + 0;
            }
            return 0 + i6;
        } else if (i2 <= this.fBA) {
            return 0 - i7;
        } else {
            if (i2 == this.fBB) {
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

    private void bEO() {
        if (this.fBs != null) {
            measureItem(this.fBs);
            this.dnT = this.fBs.getMeasuredHeight();
            this.fBK = this.dnT / 2;
        }
    }

    protected boolean onDragTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        switch (motionEvent.getAction() & 255) {
            case 1:
                if (this.mDragState == 4) {
                    stopDrag(false);
                }
                bEL();
                return true;
            case 2:
                bl((int) motionEvent.getX(), (int) motionEvent.getY());
                return true;
            case 3:
                if (this.mDragState == 4) {
                    cancelDrag();
                }
                bEL();
                return true;
            default:
                return true;
        }
    }

    public boolean startDrag(int i2, int i3, int i4, int i5) {
        View sd;
        if (!this.fCa || this.fCb == null || (sd = this.fCb.sd(i2)) == null) {
            return false;
        }
        return startDrag(i2, sd, i3, i4, i5);
    }

    public boolean startDrag(int i2, View view, int i3, int i4, int i5) {
        if (this.mDragState == 0 && this.fCa && this.fBs == null && view != null && this.dFs) {
            if (this.mListView.getParent() != null) {
                this.mListView.getParent().requestDisallowInterceptTouchEvent(true);
            }
            int headerViewsCount = this.mListView.getHeaderViewsCount() + i2;
            this.fBA = headerViewsCount;
            this.fBB = headerViewsCount;
            this.fBD = headerViewsCount;
            this.fBz = headerViewsCount;
            this.mDragState = 4;
            this.fBY = 0;
            this.fBY |= i3;
            this.fBs = view;
            bEO();
            this.fBE = i4;
            this.fBF = i5;
            this.fBX = this.mY;
            this.fBt.x = this.mX - this.fBE;
            this.fBt.y = this.mY - this.fBF;
            View childAt = this.mListView.getChildAt(this.fBD - this.mListView.getFirstVisiblePosition());
            if (childAt != null) {
                childAt.setVisibility(4);
            }
            if (this.fCh) {
                this.fCi.bES();
            }
            switch (this.fCd) {
                case 1:
                    this.fCq.onTouchEvent(this.fCc);
                    break;
                case 2:
                    this.fCq.onInterceptTouchEvent(this.fCc);
                    break;
            }
            this.mListView.requestLayout();
            if (this.fCm != null) {
                this.fCm.start();
                return true;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kM(boolean z) {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition() + (this.mListView.getChildCount() / 2);
        View childAt = this.mListView.getChildAt(this.mListView.getChildCount() / 2);
        if (childAt != null) {
            h(firstVisiblePosition, childAt, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i2, View view, boolean z) {
        this.mBlockLayoutRequests = true;
        bEP();
        int i3 = this.fBA;
        int i4 = this.fBB;
        boolean bEG = bEG();
        if (bEG) {
            bEN();
            this.mListView.setSelectionFromTop(i2, (b(i2, view, i3, i4) + view.getTop()) - this.mListView.getPaddingTop());
            layoutChildren();
        }
        if (bEG || z) {
            this.mListView.invalidate();
        }
        this.mBlockLayoutRequests = false;
    }

    private void bEP() {
        if (this.fCb != null) {
            this.fBu.set(this.mX, this.mY);
            this.fCb.b(this.fBs, this.fBt, this.fBu);
        }
        int i2 = this.fBt.x;
        int i3 = this.fBt.y;
        int paddingLeft = this.mListView.getPaddingLeft();
        if ((this.fBY & 1) == 0 && i2 > paddingLeft) {
            this.fBt.x = paddingLeft;
        } else if ((this.fBY & 2) == 0 && i2 < paddingLeft) {
            this.fBt.x = paddingLeft;
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int lastVisiblePosition = this.mListView.getLastVisiblePosition();
        int paddingTop = this.mListView.getPaddingTop();
        if (firstVisiblePosition < headerViewsCount) {
            paddingTop = this.mListView.getChildAt((headerViewsCount - firstVisiblePosition) - 1).getBottom();
        }
        if ((this.fBY & 8) == 0 && firstVisiblePosition <= this.fBD) {
            paddingTop = Math.max(this.mListView.getChildAt(this.fBD - firstVisiblePosition).getTop(), paddingTop);
        }
        int height = this.mListView.getHeight() - this.mListView.getPaddingBottom();
        if (lastVisiblePosition >= (this.mListView.getCount() - footerViewsCount) - 1) {
            height = this.mListView.getChildAt(((this.mListView.getCount() - footerViewsCount) - 1) - firstVisiblePosition).getBottom();
        }
        if ((this.fBY & 4) == 0 && lastVisiblePosition >= this.fBD) {
            height = Math.min(this.mListView.getChildAt(this.fBD - firstVisiblePosition).getBottom(), height);
        }
        if (i3 < paddingTop) {
            this.fBt.y = paddingTop;
        } else if (this.dnT + i3 > height) {
            this.fBt.y = height - this.dnT;
        }
        this.fBv = this.fBt.y + this.fBK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEQ() {
        if (this.fBs != null) {
            this.fBs.setVisibility(8);
            if (this.fCb != null) {
                this.fCb.bH(this.fBs);
            }
            this.fBs = null;
            this.mListView.invalidate();
        }
    }

    public void a(h hVar) {
        this.fCb = hVar;
    }

    public void a(b bVar) {
        this.fBG = bVar;
    }

    public void setDragEnabled(boolean z) {
        this.dFs = z;
    }

    public boolean isDragEnabled() {
        return this.dFs;
    }

    public void a(g gVar) {
        this.fBH = gVar;
    }

    public void a(l lVar) {
        this.fBI = lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class i {
        private SparseIntArray fCM;
        private ArrayList<Integer> fCN;
        private int mMaxSize;

        public i(int i) {
            this.fCM = new SparseIntArray(i);
            this.fCN = new ArrayList<>(i);
            this.mMaxSize = i;
        }

        public void bn(int i, int i2) {
            int i3 = this.fCM.get(i, -1);
            if (i3 != i2) {
                if (i3 == -1) {
                    if (this.fCM.size() == this.mMaxSize) {
                        this.fCM.delete(this.fCN.remove(0).intValue());
                    }
                } else {
                    this.fCN.remove(Integer.valueOf(i));
                }
                this.fCM.put(i, i2);
                this.fCN.add(Integer.valueOf(i));
            }
        }

        public int get(int i) {
            return this.fCM.get(i, -1);
        }

        public void clear() {
            this.fCM.clear();
            this.fCN.clear();
        }
    }

    /* renamed from: com.baidu.tbadk.widget.dragsort.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0600a extends BaseAdapter {
        private ListAdapter mAdapter;

        public C0600a(ListAdapter listAdapter) {
            this.mAdapter = listAdapter;
            this.mAdapter.registerDataSetObserver(new DataSetObserver() { // from class: com.baidu.tbadk.widget.dragsort.a.a.1
                @Override // android.database.DataSetObserver
                public void onChanged() {
                    C0600a.this.notifyDataSetChanged();
                }

                @Override // android.database.DataSetObserver
                public void onInvalidated() {
                    C0600a.this.notifyDataSetInvalidated();
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
        private float cCH;
        private float cCI;
        private float cCJ;
        private float cCK;
        private float fCX;
        private float mAlpha;
        private boolean mCanceled;
        protected long mStartTime;

        public m(float f, int i) {
            this.mAlpha = f;
            this.fCX = i;
            float f2 = 1.0f / ((this.mAlpha * 2.0f) * (1.0f - this.mAlpha));
            this.cCK = f2;
            this.cCH = f2;
            this.cCI = this.mAlpha / ((this.mAlpha - 1.0f) * 2.0f);
            this.cCJ = 1.0f / (1.0f - this.mAlpha);
        }

        public float am(float f) {
            if (f < this.mAlpha) {
                return this.cCH * f * f;
            }
            if (f < 1.0f - this.mAlpha) {
                return this.cCI + (this.cCJ * f);
            }
            return 1.0f - ((this.cCK * (f - 1.0f)) * (f - 1.0f));
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
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / this.fCX;
                if (uptimeMillis >= 1.0f) {
                    x(1.0f, 1.0f);
                    onStop();
                    return;
                }
                x(uptimeMillis, am(uptimeMillis));
                a.this.mListView.post(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class f extends m {
        private int fCI;
        private int fCJ;
        private float fCK;
        private float fCL;

        public f(float f, int i) {
            super(f, i);
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.fCI = a.this.fBz;
            this.fCJ = a.this.fBD;
            a.this.mDragState = 2;
            this.fCK = a.this.fBt.y - bEU();
            this.fCL = a.this.fBt.x - a.this.mListView.getPaddingLeft();
        }

        private int bEU() {
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            int dividerHeight = (a.this.fBJ + a.this.mListView.getDividerHeight()) / 2;
            View childAt = a.this.mListView.getChildAt(this.fCI - firstVisiblePosition);
            if (childAt != null) {
                if (this.fCI == this.fCJ) {
                    return childAt.getTop();
                }
                if (this.fCI >= this.fCJ) {
                    return (childAt.getBottom() + dividerHeight) - a.this.dnT;
                }
                return childAt.getTop() - dividerHeight;
            }
            cancel();
            return -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void x(float f, float f2) {
            int bEU = bEU();
            float paddingLeft = a.this.fBt.x - a.this.mListView.getPaddingLeft();
            float f3 = 1.0f - f2;
            if (f3 < Math.abs((a.this.fBt.y - bEU) / this.fCK) || f3 < Math.abs(paddingLeft / this.fCL)) {
                a.this.fBt.y = bEU + ((int) (this.fCK * f3));
                a.this.fBt.x = a.this.mListView.getPaddingLeft() + ((int) (this.fCL * f3));
                a.this.kM(true);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.bEI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class k extends m {
        private int fCJ;
        private float fCQ;
        private float fCR;
        private float fCS;
        private int fCT;
        private int fCU;
        private int fCV;
        private int fCW;

        public k(float f, int i) {
            super(f, i);
            this.fCT = -1;
            this.fCU = -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.fCT = -1;
            this.fCU = -1;
            this.fCV = a.this.fBA;
            this.fCW = a.this.fBB;
            this.fCJ = a.this.fBD;
            a.this.mDragState = 1;
            this.fCQ = a.this.fBt.x;
            if (a.this.fCo) {
                float width = a.this.mListView.getWidth() * 2.0f;
                if (a.this.fCp == 0.0f) {
                    a.this.fCp = (this.fCQ >= 0.0f ? 1 : -1) * width;
                    return;
                }
                float f = width * 2.0f;
                if (a.this.fCp >= 0.0f || a.this.fCp <= (-f)) {
                    if (a.this.fCp > 0.0f && a.this.fCp < f) {
                        a.this.fCp = f;
                        return;
                    }
                    return;
                }
                a.this.fCp = -f;
                return;
            }
            a.this.bEQ();
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void x(float f, float f2) {
            View childAt;
            float f3 = 1.0f - f2;
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            View childAt2 = a.this.mListView.getChildAt(this.fCV - firstVisiblePosition);
            if (a.this.fCo) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / 1000.0f;
                if (uptimeMillis != 0.0f) {
                    float f4 = a.this.fCp * uptimeMillis;
                    int width = a.this.mListView.getWidth();
                    a.this.fCp = ((a.this.fCp > 0.0f ? 1 : -1) * uptimeMillis * width) + a.this.fCp;
                    this.fCQ += f4;
                    a.this.fBt.x = (int) this.fCQ;
                    if (this.fCQ < width && this.fCQ > (-width)) {
                        this.mStartTime = SystemClock.uptimeMillis();
                        a.this.kM(true);
                        return;
                    }
                } else {
                    return;
                }
            }
            if (childAt2 != null) {
                if (this.fCT == -1) {
                    this.fCT = a.this.f(this.fCV, childAt2, false);
                    this.fCR = childAt2.getHeight() - this.fCT;
                }
                int max = Math.max((int) (this.fCR * f3), 1);
                ViewGroup.LayoutParams layoutParams = childAt2.getLayoutParams();
                layoutParams.height = max + this.fCT;
                childAt2.setLayoutParams(layoutParams);
            }
            if (this.fCW != this.fCV && (childAt = a.this.mListView.getChildAt(this.fCW - firstVisiblePosition)) != null) {
                if (this.fCU == -1) {
                    this.fCU = a.this.f(this.fCW, childAt, false);
                    this.fCS = childAt.getHeight() - this.fCU;
                }
                int max2 = Math.max((int) (this.fCS * f3), 1);
                ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
                layoutParams2.height = max2 + this.fCU;
                childAt.setLayoutParams(layoutParams2);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.bEJ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class j extends m {
        private float fCO;
        private float fCP;
        final /* synthetic */ a fCu;

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.fCO = this.fCu.fBF;
            this.fCP = this.fCu.fBK;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void x(float f, float f2) {
            if (this.fCu.mDragState != 4) {
                cancel();
                return;
            }
            this.fCu.fBF = (int) ((this.fCP * f2) + ((1.0f - f2) * this.fCO));
            this.fCu.fBt.y = this.fCu.mY - this.fCu.fBF;
            this.fCu.kM(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e {
        StringBuilder mBuilder = new StringBuilder();
        private int fCF = 0;
        private int fCG = 0;
        private boolean fCH = false;
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

        public void bES() {
            this.mBuilder.append("<DSLVStates>\n");
            this.fCG = 0;
            this.fCH = true;
        }

        public void bET() {
            if (this.fCH) {
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
                this.mBuilder.append("    <FirstExpPos>").append(a.this.fBA).append("</FirstExpPos>\n");
                this.mBuilder.append("    <FirstExpBlankHeight>").append(a.this.rZ(a.this.fBA) - a.this.sb(a.this.fBA)).append("</FirstExpBlankHeight>\n");
                this.mBuilder.append("    <SecondExpPos>").append(a.this.fBB).append("</SecondExpPos>\n");
                this.mBuilder.append("    <SecondExpBlankHeight>").append(a.this.rZ(a.this.fBB) - a.this.sb(a.this.fBB)).append("</SecondExpBlankHeight>\n");
                this.mBuilder.append("    <SrcPos>").append(a.this.fBD).append("</SrcPos>\n");
                this.mBuilder.append("    <SrcHeight>").append(a.this.dnT + a.this.mListView.getDividerHeight()).append("</SrcHeight>\n");
                this.mBuilder.append("    <ViewHeight>").append(a.this.mListView.getHeight()).append("</ViewHeight>\n");
                this.mBuilder.append("    <LastY>").append(a.this.mLastY).append("</LastY>\n");
                this.mBuilder.append("    <FloatY>").append(a.this.fBv).append("</FloatY>\n");
                this.mBuilder.append("    <ShuffleEdges>");
                for (int i4 = 0; i4 < childCount; i4++) {
                    this.mBuilder.append(a.this.bk(firstVisiblePosition + i4, a.this.mListView.getChildAt(i4).getTop())).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                this.mBuilder.append("</ShuffleEdges>\n");
                this.mBuilder.append("</DSLVState>\n");
                this.fCF++;
                if (this.fCF > 1000) {
                    flush();
                    this.fCF = 0;
                }
            }
        }

        public void flush() {
            if (this.fCH) {
                try {
                    FileWriter fileWriter = new FileWriter(this.mFile, this.fCG != 0);
                    fileWriter.write(this.mBuilder.toString());
                    this.mBuilder.delete(0, this.mBuilder.length());
                    fileWriter.flush();
                    fileWriter.close();
                    this.fCG++;
                } catch (IOException e) {
                }
            }
        }

        public void stopTracking() {
            if (this.fCH) {
                this.mBuilder.append("</DSLVStates>\n");
                flush();
                this.fCH = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements Runnable {
        private int fCA;
        private float fCB;
        private long fCC;
        private int fCD;
        private float fCE;
        private boolean fCx;
        private long fCy;
        private long fCz;
        private boolean mScrolling = false;

        public boolean isScrolling() {
            return this.mScrolling;
        }

        public int bER() {
            if (this.mScrolling) {
                return this.fCD;
            }
            return -1;
        }

        public d() {
        }

        public void sc(int i) {
            if (!this.mScrolling) {
                this.fCx = false;
                this.mScrolling = true;
                this.fCC = SystemClock.uptimeMillis();
                this.fCy = this.fCC;
                this.fCD = i;
                a.this.mListView.post(this);
            }
        }

        public void kN(boolean z) {
            if (z) {
                a.this.mListView.removeCallbacks(this);
                this.mScrolling = false;
                return;
            }
            this.fCx = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.fCx) {
                int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
                int lastVisiblePosition = a.this.mListView.getLastVisiblePosition();
                int count = a.this.mListView.getCount();
                int paddingTop = a.this.mListView.getPaddingTop();
                int height = (a.this.mListView.getHeight() - paddingTop) - a.this.mListView.getPaddingBottom();
                int min = Math.min(a.this.mY, a.this.fBv + a.this.fBK);
                int max = Math.max(a.this.mY, a.this.fBv - a.this.fBK);
                if (this.fCD == 0) {
                    View childAt = a.this.mListView.getChildAt(0);
                    if (childAt == null) {
                        this.mScrolling = false;
                        return;
                    } else if (firstVisiblePosition == 0 && childAt.getTop() == paddingTop) {
                        this.mScrolling = false;
                        return;
                    } else {
                        this.fCE = a.this.fBW.b((a.this.fBS - max) / a.this.fBT, this.fCy);
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
                        this.fCE = -a.this.fBW.b((min - a.this.fBR) / a.this.fBU, this.fCy);
                    }
                }
                this.fCz = SystemClock.uptimeMillis();
                this.fCB = (float) (this.fCz - this.fCy);
                this.fCA = Math.round(this.fCE * this.fCB);
                if (this.fCA >= 0) {
                    this.fCA = Math.min(height, this.fCA);
                    lastVisiblePosition = firstVisiblePosition;
                } else {
                    this.fCA = Math.max(-height, this.fCA);
                }
                View childAt3 = a.this.mListView.getChildAt(lastVisiblePosition - firstVisiblePosition);
                int top = childAt3.getTop() + this.fCA;
                if (lastVisiblePosition == 0 && top > paddingTop) {
                    top = paddingTop;
                }
                a.this.mBlockLayoutRequests = true;
                a.this.mListView.setSelectionFromTop(lastVisiblePosition, top - paddingTop);
                a.this.layoutChildren();
                a.this.mListView.invalidate();
                a.this.mBlockLayoutRequests = false;
                a.this.h(lastVisiblePosition, childAt3, false);
                this.fCy = this.fCz;
                a.this.mListView.post(this);
                return;
            }
            this.mScrolling = false;
        }
    }
}
