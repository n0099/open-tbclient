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
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a implements com.baidu.tbadk.widget.dragsort.e {
    private DataSetObserver Qt;
    private d bFB;
    private int bFE;
    private int bFF;
    private float bFG;
    private float bFH;
    private float bFI;
    private float bFJ;
    private int bFM;
    private int bFN;
    private int bFO;
    private MotionEvent bFT;
    private C0119a bFX;
    private e bFZ;
    private View bFe;
    private int bFh;
    private int bFl;
    private int bFm;
    private int bFn;
    private int bFp;
    private int bFq;
    private int bFr;
    private int bFs;
    private b bFt;
    private g bFu;
    private l bFv;
    private int bFy;
    private int bFz;
    private k bGc;
    private j bGd;
    private f bGe;
    private boolean bGf;
    private com.baidu.tbadk.widget.dragsort.f bGh;
    private com.baidu.tbadk.widget.dragsort.b bGi;
    private int bev;
    private int mLastX;
    private int mLastY;
    private ListView mListView;
    private Point bFf = new Point();
    private Point bFg = new Point();
    private boolean bFi = false;
    private float bFj = 1.0f;
    private float bFk = 1.0f;
    private boolean bFo = false;
    private boolean bFw = true;
    private int mDragState = 0;
    private int bFx = 1;
    private int mWidthMeasureSpec = 0;
    private View[] bFA = new View[1];
    private float bFC = 0.33333334f;
    private float bFD = 0.33333334f;
    private float bFK = 0.5f;
    private c bFL = new c() { // from class: com.baidu.tbadk.widget.dragsort.a.1
        @Override // com.baidu.tbadk.widget.dragsort.a.c
        public float b(float f2, long j2) {
            return a.this.bFK * f2;
        }
    };
    private int bFP = 0;
    private boolean bFQ = false;
    private boolean bFR = false;
    private h bFS = null;
    private int bFU = 0;
    private float bFV = 0.25f;
    private float bFW = 0.0f;
    private boolean bFY = false;
    private boolean mBlockLayoutRequests = false;
    private boolean bGa = false;
    private i bGb = new i(3);
    private float bGg = 0.0f;
    private boolean bGj = false;
    private boolean bGk = false;

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

        void bn(View view);

        View iy(int i);
    }

    /* loaded from: classes.dex */
    public interface l {
        void remove(int i);
    }

    public a(ListView listView, com.baidu.tbadk.widget.dragsort.f fVar) {
        this.bGh = fVar;
        this.mListView = listView;
    }

    @Override // com.baidu.tbadk.widget.dragsort.e
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            this.bFX = new C0119a(listAdapter);
            listAdapter.registerDataSetObserver(this.Qt);
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
            this.bFX = null;
        }
        this.bGh.setAdapter(this.bFX);
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
            if (i2 > this.bFp) {
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
    public int iu(int i2) {
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        return childAt != null ? childAt.getHeight() : aQ(i2, iw(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aO(int i2, int i3) {
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        if (i2 <= headerViewsCount || i2 >= this.mListView.getCount() - footerViewsCount) {
            return i3;
        }
        int dividerHeight = this.mListView.getDividerHeight();
        int i4 = this.bFy - this.bFx;
        int iw = iw(i2);
        int iu = iu(i2);
        if (this.bFn <= this.bFp) {
            if (i2 == this.bFn && this.bFm != this.bFn) {
                if (i2 == this.bFp) {
                    i3 = (i3 + iu) - this.bFy;
                } else {
                    i3 = ((iu - iw) + i3) - i4;
                }
            } else if (i2 > this.bFn && i2 <= this.bFp) {
                i3 -= i4;
            }
        } else if (i2 > this.bFp && i2 <= this.bFm) {
            i3 += i4;
        } else if (i2 == this.bFn && this.bFm != this.bFn) {
            i3 += iu - iw;
        }
        if (i2 <= this.bFp) {
            return (((this.bFy - dividerHeight) - iw(i2 - 1)) / 2) + i3;
        }
        return (((iw - dividerHeight) - this.bFy) / 2) + i3;
    }

    private boolean PU() {
        int i2;
        int i3;
        int i4;
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int i5 = this.bFm;
        View childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        if (childAt == null) {
            i5 = firstVisiblePosition + (this.mListView.getChildCount() / 2);
            childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        }
        int top = childAt.getTop();
        int height = childAt.getHeight();
        int aO = aO(i5, top);
        int dividerHeight = this.mListView.getDividerHeight();
        if (this.bFh >= aO) {
            int count = this.mListView.getCount();
            int i6 = height;
            int i7 = top;
            i2 = aO;
            i3 = i5;
            i4 = aO;
            while (true) {
                if (i3 < count) {
                    if (i3 == count - 1) {
                        i2 = i7 + dividerHeight + i6;
                        break;
                    }
                    i7 += dividerHeight + i6;
                    i6 = iu(i3 + 1);
                    i2 = aO(i3 + 1, i7);
                    if (this.bFh < i2) {
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
            i2 = aO;
            i3 = i5;
            i4 = aO;
            while (true) {
                if (i3 < 0) {
                    break;
                }
                i3--;
                int iu = iu(i3);
                if (i3 == 0) {
                    i2 = (i8 - dividerHeight) - iu;
                    break;
                }
                i8 -= iu + dividerHeight;
                i2 = aO(i3, i8);
                if (this.bFh >= i2) {
                    break;
                }
                i4 = i2;
            }
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int i9 = this.bFm;
        int i10 = this.bFn;
        float f2 = this.bFW;
        if (this.bFo) {
            int abs = Math.abs(i2 - i4);
            if (this.bFh >= i2) {
                int i11 = i4;
                i4 = i2;
                i2 = i11;
            }
            int i12 = (int) (abs * this.bFV * 0.5f);
            float f3 = i12;
            int i13 = i4 + i12;
            int i14 = i2 - i12;
            if (this.bFh < i13) {
                this.bFm = i3 - 1;
                this.bFn = i3;
                this.bFW = ((i13 - this.bFh) * 0.5f) / f3;
            } else if (this.bFh < i14) {
                this.bFm = i3;
                this.bFn = i3;
            } else {
                this.bFm = i3;
                this.bFn = i3 + 1;
                this.bFW = (1.0f + ((i2 - this.bFh) / f3)) * 0.5f;
            }
        } else {
            this.bFm = i3;
            this.bFn = i3;
        }
        if (this.bFm < headerViewsCount) {
            this.bFm = headerViewsCount;
            this.bFn = headerViewsCount;
            i3 = headerViewsCount;
        } else if (this.bFn >= this.mListView.getCount() - footerViewsCount) {
            i3 = (this.mListView.getCount() - footerViewsCount) - 1;
            this.bFm = i3;
            this.bFn = i3;
        }
        boolean z = (this.bFm == i9 && this.bFn == i10 && this.bFW == f2) ? false : true;
        if (i3 != this.bFl) {
            if (this.bFt != null) {
                this.bFt.drag(this.bFl - headerViewsCount, i3 - headerViewsCount);
            }
            this.bFl = i3;
            return true;
        }
        return z;
    }

    public void removeItem(int i2) {
        this.bGf = false;
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
            this.bFx = Math.max(1, obtainStyledAttributes.getDimensionPixelSize(d.l.DragSort_collapsed_height, 1));
            this.bFY = obtainStyledAttributes.getBoolean(d.l.DragSort_track_drag_sort, false);
            if (this.bFY) {
                this.bFZ = new e();
            }
            this.bFj = obtainStyledAttributes.getFloat(d.l.DragSort_float_alpha, this.bFj);
            this.bFk = this.bFj;
            this.bFw = obtainStyledAttributes.getBoolean(d.l.DragSort_drag_enabled, this.bFw);
            this.bFV = Math.max(0.0f, Math.min(1.0f, 1.0f - obtainStyledAttributes.getFloat(d.l.DragSort_slide_shuffle_speed, 0.75f)));
            this.bFo = this.bFV > 0.0f;
            setDragScrollStart(obtainStyledAttributes.getFloat(d.l.DragSort_drag_scroll_start, this.bFC));
            this.bFK = obtainStyledAttributes.getFloat(d.l.DragSort_max_drag_scroll_speed, this.bFK);
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
                bVar.cK(z);
                bVar.cJ(z2);
                bVar.setBackgroundColor(color);
                this.bFS = bVar;
                a(bVar);
            }
            obtainStyledAttributes.recycle();
            i2 = i5;
            i3 = i4;
        }
        this.bFB = new d();
        if (i3 > 0) {
            this.bGc = new k(0.5f, i3);
        }
        if (i2 > 0) {
            this.bGe = new f(0.5f, i2);
        }
        this.bFT = MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        this.Qt = new DataSetObserver() { // from class: com.baidu.tbadk.widget.dragsort.a.2
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
        this.bGi = bVar;
        this.mListView.setOnTouchListener(bVar);
    }

    @Override // com.baidu.tbadk.widget.dragsort.e
    public void dispatchDraw(Canvas canvas) {
        float f2;
        this.bGh.dispatchDraw(canvas);
        if (this.mDragState != 0) {
            if (this.bFm != this.bFp) {
                b(this.bFm, canvas);
            }
            if (this.bFn != this.bFm && this.bFn != this.bFp) {
                b(this.bFn, canvas);
            }
        }
        if (this.bFe != null) {
            int width = this.bFe.getWidth();
            int height = this.bFe.getHeight();
            int i2 = this.bFf.x;
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
            int i3 = (int) (f2 * 255.0f * this.bFk);
            canvas.save();
            canvas.translate(this.bFf.x, this.bFf.y);
            canvas.clipRect(0, 0, width, height);
            canvas.saveLayerAlpha(0.0f, 0.0f, width, height, i3, 31);
            this.bFe.draw(canvas);
            canvas.restore();
            canvas.restore();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.e
    public void onDraw(Canvas canvas) {
        this.bGh.onDraw(canvas);
        if (this.bFY) {
            this.bFZ.Qh();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.e
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.bGa) {
            this.bGa = false;
            return false;
        } else if (!this.bFw) {
            return this.bGh.onTouchEvent(motionEvent);
        } else {
            boolean z2 = this.bFQ;
            this.bFQ = false;
            if (!z2) {
                A(motionEvent);
            }
            if (this.mDragState == 4) {
                onDragTouchEvent(motionEvent);
                return true;
            }
            if (this.mDragState == 0 && this.bGh.onTouchEvent(motionEvent)) {
                z = true;
            }
            switch (motionEvent.getAction() & 255) {
                case 1:
                case 3:
                    PZ();
                    return z;
                case 2:
                default:
                    if (z) {
                        this.bFU = 1;
                        return z;
                    }
                    return z;
            }
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.e
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (!this.bFw) {
            return this.bGh.onInterceptTouchEvent(motionEvent);
        }
        if (this.bGi != null) {
            this.bGi.Qj().onTouchEvent(motionEvent);
        }
        A(motionEvent);
        this.bFQ = true;
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            if (this.mDragState != 0) {
                this.bGa = true;
                return true;
            }
            this.bFR = true;
        }
        if (this.bFe == null) {
            if (this.bGh.onInterceptTouchEvent(motionEvent)) {
                this.bGj = true;
                z = true;
            } else {
                z = false;
            }
            switch (action) {
                case 1:
                case 3:
                    PZ();
                    break;
                case 2:
                default:
                    if (z) {
                        this.bFU = 1;
                        break;
                    } else {
                        this.bFU = 2;
                        break;
                    }
            }
        } else {
            z = true;
        }
        if (action == 1 || action == 3) {
            this.bFR = false;
        }
        return z;
    }

    @Override // com.baidu.tbadk.widget.dragsort.e
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        this.bGh.onSizeChanged(i2, i3, i4, i5);
        Qa();
    }

    @Override // com.baidu.tbadk.widget.dragsort.e
    public void requestLayout() {
        if (!this.mBlockLayoutRequests) {
            this.bGh.requestLayout();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.e
    public void onMeasure(int i2, int i3) {
        this.bGh.onMeasure(i2, i3);
        if (this.bFe != null) {
            if (this.bFe.isLayoutRequested()) {
                Qc();
            }
            this.bFi = true;
        }
        this.mWidthMeasureSpec = i2;
    }

    @Override // com.baidu.tbadk.widget.dragsort.e
    public void layoutChildren() {
        this.bGh.layoutChildren();
        if (this.bFe != null) {
            if (this.bFe.isLayoutRequested() && !this.bFi) {
                Qc();
            }
            this.bFe.layout(0, 0, this.bFe.getMeasuredWidth(), this.bFe.getMeasuredHeight());
            this.bFi = false;
        }
    }

    public void removeItem(int i2, float f2) {
        if (this.mDragState == 0 || this.mDragState == 4) {
            if (this.mDragState == 0) {
                this.bFp = this.mListView.getHeaderViewsCount() + i2;
                this.bFm = this.bFp;
                this.bFn = this.bFp;
                this.bFl = this.bFp;
                View childAt = this.mListView.getChildAt(this.bFp - this.mListView.getFirstVisiblePosition());
                if (childAt != null) {
                    childAt.setVisibility(4);
                }
            }
            this.mDragState = 1;
            this.bGg = f2;
            if (this.bFR) {
                switch (this.bFU) {
                    case 1:
                        this.bGh.onTouchEvent(this.bFT);
                        break;
                    case 2:
                        this.bGh.onInterceptTouchEvent(this.bFT);
                        break;
                }
            }
            if (this.bGc != null) {
                this.bGc.start();
            } else {
                iv(i2);
            }
        }
    }

    public void cancelDrag() {
        if (this.mDragState == 4) {
            this.bFB.cI(true);
            Qe();
            PV();
            Qb();
            if (this.bFR) {
                this.mDragState = 3;
            } else {
                this.mDragState = 0;
            }
        }
    }

    private void PV() {
        this.bFp = -1;
        this.bFm = -1;
        this.bFn = -1;
        this.bFl = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PW() {
        this.mDragState = 2;
        if (this.bFu != null && this.bFl >= 0 && this.bFl < this.mListView.getCount()) {
            int headerViewsCount = this.mListView.getHeaderViewsCount();
            this.bFu.drop(this.bFp - headerViewsCount, this.bFl - headerViewsCount);
        }
        Qe();
        PY();
        PV();
        Qb();
        if (this.bFR) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PX() {
        iv(this.bFp - this.mListView.getHeaderViewsCount());
    }

    private void iv(int i2) {
        this.mDragState = 1;
        if (this.bFv != null) {
            this.bFv.remove(i2);
        }
        Qe();
        PY();
        PV();
        if (this.bFR) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    private void PY() {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        if (this.bFp < firstVisiblePosition) {
            View childAt = this.mListView.getChildAt(0);
            this.mListView.setSelectionFromTop(firstVisiblePosition - 1, (childAt != null ? childAt.getTop() : 0) - this.mListView.getPaddingTop());
        }
    }

    public boolean stopDrag(boolean z) {
        this.bGf = false;
        return stopDrag(z, 0.0f);
    }

    public boolean stopDragWithVelocity(boolean z, float f2) {
        this.bGf = true;
        return stopDrag(z, f2);
    }

    public boolean stopDrag(boolean z, float f2) {
        if (this.bFe != null) {
            this.bFB.cI(true);
            if (z) {
                removeItem(this.bFp - this.mListView.getHeaderViewsCount(), f2);
            } else if (this.bGe != null) {
                this.bGe.start();
            } else {
                PW();
            }
            if (this.bFY) {
                this.bFZ.sc();
                return true;
            }
            return true;
        }
        return false;
    }

    private void PZ() {
        this.bFU = 0;
        this.bFR = false;
        if (this.mDragState == 3) {
            this.mDragState = 0;
        }
        this.bFk = this.bFj;
        this.bGj = false;
        this.bGb.clear();
    }

    private void A(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            this.mLastX = this.bFM;
            this.mLastY = this.bFN;
        }
        this.bFM = (int) motionEvent.getX();
        this.bFN = (int) motionEvent.getY();
        if (action == 0) {
            this.mLastX = this.bFM;
            this.mLastY = this.bFN;
        }
        this.bFs = ((int) motionEvent.getRawX()) - this.bFM;
        this.bev = ((int) motionEvent.getRawY()) - this.bFN;
    }

    public boolean listViewIntercepted() {
        return this.bGj;
    }

    public void setDragScrollStart(float f2) {
        setDragScrollStarts(f2, f2);
    }

    public void setDragScrollStarts(float f2, float f3) {
        if (f3 > 0.5f) {
            this.bFD = 0.5f;
        } else {
            this.bFD = f3;
        }
        if (f2 > 0.5f) {
            this.bFC = 0.5f;
        } else {
            this.bFC = f2;
        }
        if (this.mListView.getHeight() != 0) {
            Qa();
        }
    }

    private void aP(int i2, int i3) {
        this.bFf.x = i2 - this.bFq;
        this.bFf.y = i3 - this.bFr;
        cH(true);
        int min = Math.min(i3, this.bFh + this.bFz);
        int max = Math.max(i3, this.bFh - this.bFz);
        int Qg = this.bFB.Qg();
        if (min > this.mLastY && min > this.bFF && Qg != 1) {
            if (Qg != -1) {
                this.bFB.cI(true);
            }
            this.bFB.ix(1);
        } else if (max < this.mLastY && max < this.bFE && Qg != 0) {
            if (Qg != -1) {
                this.bFB.cI(true);
            }
            this.bFB.ix(0);
        } else if (max >= this.bFE && min <= this.bFF && this.bFB.Qf()) {
            this.bFB.cI(true);
        }
    }

    private void Qa() {
        int height;
        int paddingTop = this.mListView.getPaddingTop();
        float height2 = (this.mListView.getHeight() - paddingTop) - this.mListView.getPaddingBottom();
        this.bFH = paddingTop + (this.bFC * height2);
        this.bFG = (height2 * (1.0f - this.bFD)) + paddingTop;
        this.bFE = (int) this.bFH;
        this.bFF = (int) this.bFG;
        this.bFI = this.bFH - paddingTop;
        this.bFJ = (paddingTop + height) - this.bFG;
    }

    private void Qb() {
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
        if (i2 != this.bFp && i2 != this.bFm && i2 != this.bFn) {
            g2 = -2;
        } else {
            g2 = g(i2, view, z);
        }
        if (g2 != layoutParams.height) {
            layoutParams.height = g2;
            view.setLayoutParams(layoutParams);
        }
        if (i2 == this.bFm || i2 == this.bFn) {
            if (i2 < this.bFp) {
                ((com.baidu.tbadk.widget.dragsort.c) view).setGravity(80);
            } else if (i2 > this.bFp) {
                ((com.baidu.tbadk.widget.dragsort.c) view).setGravity(48);
            }
        }
        int visibility = view.getVisibility();
        int i3 = 0;
        if (i2 == this.bFp && this.bFe != null) {
            i3 = 4;
        }
        if (i3 != visibility) {
            view.setVisibility(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int iw(int i2) {
        View view;
        if (i2 == this.bFp) {
            return 0;
        }
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        if (childAt != null) {
            return f(i2, childAt, false);
        }
        int i3 = this.bGb.get(i2);
        if (i3 == -1) {
            ListAdapter adapter = this.mListView.getAdapter();
            int itemViewType = adapter.getItemViewType(i2);
            int viewTypeCount = adapter.getViewTypeCount();
            if (viewTypeCount != this.bFA.length) {
                this.bFA = new View[viewTypeCount];
            }
            if (itemViewType >= 0) {
                if (this.bFA[itemViewType] == null) {
                    view = adapter.getView(i2, null, this.mListView);
                    this.bFA[itemViewType] = view;
                } else {
                    view = adapter.getView(i2, this.bFA[itemViewType], this.mListView);
                }
            } else {
                view = adapter.getView(i2, null, this.mListView);
            }
            int f2 = f(i2, view, true);
            this.bGb.add(i2, f2);
            return f2;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(int i2, View view, boolean z) {
        if (i2 == this.bFp) {
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
        return aQ(i2, f(i2, view, z));
    }

    private int aQ(int i2, int i3) {
        this.mListView.getDividerHeight();
        boolean z = this.bFo && this.bFm != this.bFn;
        int i4 = this.bFy - this.bFx;
        int i5 = (int) (this.bFW * i4);
        if (i2 == this.bFp) {
            if (this.bFp == this.bFm) {
                if (z) {
                    return i5 + this.bFx;
                }
                return this.bFy;
            } else if (this.bFp == this.bFn) {
                return this.bFy - i5;
            } else {
                return this.bFx;
            }
        } else if (i2 == this.bFm) {
            if (z) {
                return i3 + i5;
            }
            return i3 + i4;
        } else if (i2 == this.bFn) {
            return (i3 + i4) - i5;
        } else {
            return i3;
        }
    }

    private int b(int i2, View view, int i3, int i4) {
        int i5;
        int i6;
        int iw = iw(i2);
        int height = view.getHeight();
        int aQ = aQ(i2, iw);
        if (i2 != this.bFp) {
            i6 = height - iw;
            i5 = aQ - iw;
        } else {
            i5 = aQ;
            i6 = height;
        }
        int i7 = this.bFy;
        if (this.bFp != this.bFm && this.bFp != this.bFn) {
            i7 -= this.bFx;
        }
        if (i2 <= i3) {
            if (i2 > this.bFm) {
                return (i7 - i5) + 0;
            }
        } else if (i2 == i4) {
            if (i2 <= this.bFm) {
                return (i6 - i7) + 0;
            }
            if (i2 == this.bFn) {
                return (height - aQ) + 0;
            }
            return 0 + i6;
        } else if (i2 <= this.bFm) {
            return 0 - i7;
        } else {
            if (i2 == this.bFn) {
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

    private void Qc() {
        if (this.bFe != null) {
            measureItem(this.bFe);
            this.bFy = this.bFe.getMeasuredHeight();
            this.bFz = this.bFy / 2;
        }
    }

    protected boolean onDragTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        switch (motionEvent.getAction() & 255) {
            case 1:
                if (this.mDragState == 4) {
                    stopDrag(false);
                }
                PZ();
                return true;
            case 2:
                aP((int) motionEvent.getX(), (int) motionEvent.getY());
                return true;
            case 3:
                if (this.mDragState == 4) {
                    cancelDrag();
                }
                PZ();
                return true;
            default:
                return true;
        }
    }

    public boolean startDrag(int i2, int i3, int i4, int i5) {
        View iy;
        if (!this.bFR || this.bFS == null || (iy = this.bFS.iy(i2)) == null) {
            return false;
        }
        return startDrag(i2, iy, i3, i4, i5);
    }

    public boolean startDrag(int i2, View view, int i3, int i4, int i5) {
        if (this.mDragState == 0 && this.bFR && this.bFe == null && view != null && this.bFw) {
            if (this.mListView.getParent() != null) {
                this.mListView.getParent().requestDisallowInterceptTouchEvent(true);
            }
            int headerViewsCount = this.mListView.getHeaderViewsCount() + i2;
            this.bFm = headerViewsCount;
            this.bFn = headerViewsCount;
            this.bFp = headerViewsCount;
            this.bFl = headerViewsCount;
            this.mDragState = 4;
            this.bFP = 0;
            this.bFP |= i3;
            this.bFe = view;
            Qc();
            this.bFq = i4;
            this.bFr = i5;
            this.bFO = this.bFN;
            this.bFf.x = this.bFM - this.bFq;
            this.bFf.y = this.bFN - this.bFr;
            View childAt = this.mListView.getChildAt(this.bFp - this.mListView.getFirstVisiblePosition());
            if (childAt != null) {
                childAt.setVisibility(4);
            }
            if (this.bFY) {
                this.bFZ.startTracking();
            }
            switch (this.bFU) {
                case 1:
                    this.bGh.onTouchEvent(this.bFT);
                    break;
                case 2:
                    this.bGh.onInterceptTouchEvent(this.bFT);
                    break;
            }
            this.mListView.requestLayout();
            if (this.bGd != null) {
                this.bGd.start();
                return true;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cH(boolean z) {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition() + (this.mListView.getChildCount() / 2);
        View childAt = this.mListView.getChildAt(this.mListView.getChildCount() / 2);
        if (childAt != null) {
            h(firstVisiblePosition, childAt, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i2, View view, boolean z) {
        this.mBlockLayoutRequests = true;
        Qd();
        int i3 = this.bFm;
        int i4 = this.bFn;
        boolean PU = PU();
        if (PU) {
            Qb();
            this.mListView.setSelectionFromTop(i2, (b(i2, view, i3, i4) + view.getTop()) - this.mListView.getPaddingTop());
            layoutChildren();
        }
        if (PU || z) {
            this.mListView.invalidate();
        }
        this.mBlockLayoutRequests = false;
    }

    private void Qd() {
        if (this.bFS != null) {
            this.bFg.set(this.bFM, this.bFN);
            this.bFS.b(this.bFe, this.bFf, this.bFg);
        }
        int i2 = this.bFf.x;
        int i3 = this.bFf.y;
        int paddingLeft = this.mListView.getPaddingLeft();
        if ((this.bFP & 1) == 0 && i2 > paddingLeft) {
            this.bFf.x = paddingLeft;
        } else if ((this.bFP & 2) == 0 && i2 < paddingLeft) {
            this.bFf.x = paddingLeft;
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int lastVisiblePosition = this.mListView.getLastVisiblePosition();
        int paddingTop = this.mListView.getPaddingTop();
        if (firstVisiblePosition < headerViewsCount) {
            paddingTop = this.mListView.getChildAt((headerViewsCount - firstVisiblePosition) - 1).getBottom();
        }
        if ((this.bFP & 8) == 0 && firstVisiblePosition <= this.bFp) {
            paddingTop = Math.max(this.mListView.getChildAt(this.bFp - firstVisiblePosition).getTop(), paddingTop);
        }
        int height = this.mListView.getHeight() - this.mListView.getPaddingBottom();
        if (lastVisiblePosition >= (this.mListView.getCount() - footerViewsCount) - 1) {
            height = this.mListView.getChildAt(((this.mListView.getCount() - footerViewsCount) - 1) - firstVisiblePosition).getBottom();
        }
        if ((this.bFP & 4) == 0 && lastVisiblePosition >= this.bFp) {
            height = Math.min(this.mListView.getChildAt(this.bFp - firstVisiblePosition).getBottom(), height);
        }
        if (i3 < paddingTop) {
            this.bFf.y = paddingTop;
        } else if (this.bFy + i3 > height) {
            this.bFf.y = height - this.bFy;
        }
        this.bFh = this.bFf.y + this.bFz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qe() {
        if (this.bFe != null) {
            this.bFe.setVisibility(8);
            if (this.bFS != null) {
                this.bFS.bn(this.bFe);
            }
            this.bFe = null;
            this.mListView.invalidate();
        }
    }

    public void a(h hVar) {
        this.bFS = hVar;
    }

    public void a(b bVar) {
        this.bFt = bVar;
    }

    public void setDragEnabled(boolean z) {
        this.bFw = z;
    }

    public boolean isDragEnabled() {
        return this.bFw;
    }

    public void a(g gVar) {
        this.bFu = gVar;
    }

    public void a(l lVar) {
        this.bFv = lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class i {
        private SparseIntArray bGD;
        private ArrayList<Integer> bGE;
        private int mMaxSize;

        public i(int i) {
            this.bGD = new SparseIntArray(i);
            this.bGE = new ArrayList<>(i);
            this.mMaxSize = i;
        }

        public void add(int i, int i2) {
            int i3 = this.bGD.get(i, -1);
            if (i3 != i2) {
                if (i3 == -1) {
                    if (this.bGD.size() == this.mMaxSize) {
                        this.bGD.delete(this.bGE.remove(0).intValue());
                    }
                } else {
                    this.bGE.remove(Integer.valueOf(i));
                }
                this.bGD.put(i, i2);
                this.bGE.add(Integer.valueOf(i));
            }
        }

        public int get(int i) {
            return this.bGD.get(i, -1);
        }

        public void clear() {
            this.bGD.clear();
            this.bGE.clear();
        }
    }

    /* renamed from: com.baidu.tbadk.widget.dragsort.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0119a extends BaseAdapter {
        private ListAdapter mAdapter;

        public C0119a(ListAdapter listAdapter) {
            this.mAdapter = listAdapter;
            this.mAdapter.registerDataSetObserver(new DataSetObserver() { // from class: com.baidu.tbadk.widget.dragsort.a.a.1
                @Override // android.database.DataSetObserver
                public void onChanged() {
                    C0119a.this.notifyDataSetChanged();
                }

                @Override // android.database.DataSetObserver
                public void onInvalidated() {
                    C0119a.this.notifyDataSetInvalidated();
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
        private float bGO;
        private float bGP;
        private float bGQ;
        private float bGR;
        private float bGS;
        private float mAlpha;
        private boolean mCanceled;
        protected long mStartTime;

        public m(float f, int i) {
            this.mAlpha = f;
            this.bGO = i;
            float f2 = 1.0f / ((this.mAlpha * 2.0f) * (1.0f - this.mAlpha));
            this.bGS = f2;
            this.bGP = f2;
            this.bGQ = this.mAlpha / ((this.mAlpha - 1.0f) * 2.0f);
            this.bGR = 1.0f / (1.0f - this.mAlpha);
        }

        public float ab(float f) {
            if (f < this.mAlpha) {
                return this.bGP * f * f;
            }
            if (f < 1.0f - this.mAlpha) {
                return this.bGQ + (this.bGR * f);
            }
            return 1.0f - ((this.bGS * (f - 1.0f)) * (f - 1.0f));
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
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / this.bGO;
                if (uptimeMillis >= 1.0f) {
                    n(1.0f, 1.0f);
                    onStop();
                    return;
                }
                n(uptimeMillis, ab(uptimeMillis));
                a.this.mListView.post(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class f extends m {
        private int bGA;
        private float bGB;
        private float bGC;
        private int bGz;

        public f(float f, int i) {
            super(f, i);
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.bGz = a.this.bFl;
            this.bGA = a.this.bFp;
            a.this.mDragState = 2;
            this.bGB = a.this.bFf.y - Qi();
            this.bGC = a.this.bFf.x - a.this.mListView.getPaddingLeft();
        }

        private int Qi() {
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            int dividerHeight = (a.this.bFx + a.this.mListView.getDividerHeight()) / 2;
            View childAt = a.this.mListView.getChildAt(this.bGz - firstVisiblePosition);
            if (childAt != null) {
                if (this.bGz == this.bGA) {
                    return childAt.getTop();
                }
                if (this.bGz >= this.bGA) {
                    return (childAt.getBottom() + dividerHeight) - a.this.bFy;
                }
                return childAt.getTop() - dividerHeight;
            }
            cancel();
            return -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void n(float f, float f2) {
            int Qi = Qi();
            float paddingLeft = a.this.bFf.x - a.this.mListView.getPaddingLeft();
            float f3 = 1.0f - f2;
            if (f3 < Math.abs((a.this.bFf.y - Qi) / this.bGB) || f3 < Math.abs(paddingLeft / this.bGC)) {
                a.this.bFf.y = Qi + ((int) (this.bGB * f3));
                a.this.bFf.x = a.this.mListView.getPaddingLeft() + ((int) (this.bGC * f3));
                a.this.cH(true);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.PW();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class k extends m {
        private int bGA;
        private float bGH;
        private float bGI;
        private float bGJ;
        private int bGK;
        private int bGL;
        private int bGM;
        private int bGN;

        public k(float f, int i) {
            super(f, i);
            this.bGK = -1;
            this.bGL = -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.bGK = -1;
            this.bGL = -1;
            this.bGM = a.this.bFm;
            this.bGN = a.this.bFn;
            this.bGA = a.this.bFp;
            a.this.mDragState = 1;
            this.bGH = a.this.bFf.x;
            if (a.this.bGf) {
                float width = a.this.mListView.getWidth() * 2.0f;
                if (a.this.bGg == 0.0f) {
                    a.this.bGg = (this.bGH >= 0.0f ? 1 : -1) * width;
                    return;
                }
                float f = width * 2.0f;
                if (a.this.bGg >= 0.0f || a.this.bGg <= (-f)) {
                    if (a.this.bGg > 0.0f && a.this.bGg < f) {
                        a.this.bGg = f;
                        return;
                    }
                    return;
                }
                a.this.bGg = -f;
                return;
            }
            a.this.Qe();
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void n(float f, float f2) {
            View childAt;
            float f3 = 1.0f - f2;
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            View childAt2 = a.this.mListView.getChildAt(this.bGM - firstVisiblePosition);
            if (a.this.bGf) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / 1000.0f;
                if (uptimeMillis != 0.0f) {
                    float f4 = a.this.bGg * uptimeMillis;
                    int width = a.this.mListView.getWidth();
                    a.this.bGg = ((a.this.bGg > 0.0f ? 1 : -1) * uptimeMillis * width) + a.this.bGg;
                    this.bGH += f4;
                    a.this.bFf.x = (int) this.bGH;
                    if (this.bGH < width && this.bGH > (-width)) {
                        this.mStartTime = SystemClock.uptimeMillis();
                        a.this.cH(true);
                        return;
                    }
                } else {
                    return;
                }
            }
            if (childAt2 != null) {
                if (this.bGK == -1) {
                    this.bGK = a.this.f(this.bGM, childAt2, false);
                    this.bGI = childAt2.getHeight() - this.bGK;
                }
                int max = Math.max((int) (this.bGI * f3), 1);
                ViewGroup.LayoutParams layoutParams = childAt2.getLayoutParams();
                layoutParams.height = max + this.bGK;
                childAt2.setLayoutParams(layoutParams);
            }
            if (this.bGN != this.bGM && (childAt = a.this.mListView.getChildAt(this.bGN - firstVisiblePosition)) != null) {
                if (this.bGL == -1) {
                    this.bGL = a.this.f(this.bGN, childAt, false);
                    this.bGJ = childAt.getHeight() - this.bGL;
                }
                int max2 = Math.max((int) (this.bGJ * f3), 1);
                ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
                layoutParams2.height = max2 + this.bGL;
                childAt.setLayoutParams(layoutParams2);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.PX();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class j extends m {
        private float bGF;
        private float bGG;
        final /* synthetic */ a bGl;

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.bGF = this.bGl.bFr;
            this.bGG = this.bGl.bFz;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void n(float f, float f2) {
            if (this.bGl.mDragState != 4) {
                cancel();
                return;
            }
            this.bGl.bFr = (int) ((this.bGG * f2) + ((1.0f - f2) * this.bGF));
            this.bGl.bFf.y = this.bGl.bFN - this.bGl.bFr;
            this.bGl.cH(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e {
        StringBuilder mBuilder = new StringBuilder();
        private int bGw = 0;
        private int bGx = 0;
        private boolean bGy = false;
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
            this.bGx = 0;
            this.bGy = true;
        }

        public void Qh() {
            if (this.bGy) {
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
                this.mBuilder.append("    <FirstExpPos>").append(a.this.bFm).append("</FirstExpPos>\n");
                this.mBuilder.append("    <FirstExpBlankHeight>").append(a.this.iu(a.this.bFm) - a.this.iw(a.this.bFm)).append("</FirstExpBlankHeight>\n");
                this.mBuilder.append("    <SecondExpPos>").append(a.this.bFn).append("</SecondExpPos>\n");
                this.mBuilder.append("    <SecondExpBlankHeight>").append(a.this.iu(a.this.bFn) - a.this.iw(a.this.bFn)).append("</SecondExpBlankHeight>\n");
                this.mBuilder.append("    <SrcPos>").append(a.this.bFp).append("</SrcPos>\n");
                this.mBuilder.append("    <SrcHeight>").append(a.this.bFy + a.this.mListView.getDividerHeight()).append("</SrcHeight>\n");
                this.mBuilder.append("    <ViewHeight>").append(a.this.mListView.getHeight()).append("</ViewHeight>\n");
                this.mBuilder.append("    <LastY>").append(a.this.mLastY).append("</LastY>\n");
                this.mBuilder.append("    <FloatY>").append(a.this.bFh).append("</FloatY>\n");
                this.mBuilder.append("    <ShuffleEdges>");
                for (int i4 = 0; i4 < childCount; i4++) {
                    this.mBuilder.append(a.this.aO(firstVisiblePosition + i4, a.this.mListView.getChildAt(i4).getTop())).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                this.mBuilder.append("</ShuffleEdges>\n");
                this.mBuilder.append("</DSLVState>\n");
                this.bGw++;
                if (this.bGw > 1000) {
                    flush();
                    this.bGw = 0;
                }
            }
        }

        public void flush() {
            if (this.bGy) {
                try {
                    FileWriter fileWriter = new FileWriter(this.mFile, this.bGx != 0);
                    fileWriter.write(this.mBuilder.toString());
                    this.mBuilder.delete(0, this.mBuilder.length());
                    fileWriter.flush();
                    fileWriter.close();
                    this.bGx++;
                } catch (IOException e) {
                }
            }
        }

        public void sc() {
            if (this.bGy) {
                this.mBuilder.append("</DSLVStates>\n");
                flush();
                this.bGy = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements Runnable {
        private boolean bGo;
        private long bGp;
        private long bGq;
        private float bGr;
        private long bGs;
        private int bGt;
        private float bGu;
        private boolean bGv = false;
        private int dy;

        public boolean Qf() {
            return this.bGv;
        }

        public int Qg() {
            if (this.bGv) {
                return this.bGt;
            }
            return -1;
        }

        public d() {
        }

        public void ix(int i) {
            if (!this.bGv) {
                this.bGo = false;
                this.bGv = true;
                this.bGs = SystemClock.uptimeMillis();
                this.bGp = this.bGs;
                this.bGt = i;
                a.this.mListView.post(this);
            }
        }

        public void cI(boolean z) {
            if (z) {
                a.this.mListView.removeCallbacks(this);
                this.bGv = false;
                return;
            }
            this.bGo = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.bGo) {
                int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
                int lastVisiblePosition = a.this.mListView.getLastVisiblePosition();
                int count = a.this.mListView.getCount();
                int paddingTop = a.this.mListView.getPaddingTop();
                int height = (a.this.mListView.getHeight() - paddingTop) - a.this.mListView.getPaddingBottom();
                int min = Math.min(a.this.bFN, a.this.bFh + a.this.bFz);
                int max = Math.max(a.this.bFN, a.this.bFh - a.this.bFz);
                if (this.bGt == 0) {
                    View childAt = a.this.mListView.getChildAt(0);
                    if (childAt == null) {
                        this.bGv = false;
                        return;
                    } else if (firstVisiblePosition == 0 && childAt.getTop() == paddingTop) {
                        this.bGv = false;
                        return;
                    } else {
                        this.bGu = a.this.bFL.b((a.this.bFH - max) / a.this.bFI, this.bGp);
                    }
                } else {
                    View childAt2 = a.this.mListView.getChildAt(lastVisiblePosition - firstVisiblePosition);
                    if (childAt2 == null) {
                        this.bGv = false;
                        return;
                    } else if (lastVisiblePosition == count - 1 && childAt2.getBottom() <= height + paddingTop) {
                        this.bGv = false;
                        return;
                    } else {
                        this.bGu = -a.this.bFL.b((min - a.this.bFG) / a.this.bFJ, this.bGp);
                    }
                }
                this.bGq = SystemClock.uptimeMillis();
                this.bGr = (float) (this.bGq - this.bGp);
                this.dy = Math.round(this.bGu * this.bGr);
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
                this.bGp = this.bGq;
                a.this.mListView.post(this);
                return;
            }
            this.bGv = false;
        }
    }
}
