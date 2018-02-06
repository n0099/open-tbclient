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
    private DataSetObserver Qy;
    private int bFA;
    private int bFB;
    private int bFC;
    private b bFD;
    private g bFE;
    private l bFF;
    private int bFI;
    private int bFJ;
    private d bFL;
    private int bFO;
    private int bFP;
    private float bFQ;
    private float bFR;
    private float bFS;
    private float bFT;
    private int bFW;
    private int bFX;
    private int bFY;
    private View bFo;
    private int bFr;
    private int bFv;
    private int bFw;
    private int bFx;
    private int bFz;
    private MotionEvent bGd;
    private C0118a bGh;
    private e bGj;
    private k bGm;
    private j bGn;
    private f bGo;
    private boolean bGp;
    private com.baidu.tbadk.widget.dragsort.f bGr;
    private com.baidu.tbadk.widget.dragsort.b bGs;
    private int beE;
    private int mLastX;
    private int mLastY;
    private ListView mListView;
    private Point bFp = new Point();
    private Point bFq = new Point();
    private boolean bFs = false;
    private float bFt = 1.0f;
    private float bFu = 1.0f;
    private boolean bFy = false;
    private boolean bFG = true;
    private int mDragState = 0;
    private int bFH = 1;
    private int mWidthMeasureSpec = 0;
    private View[] bFK = new View[1];
    private float bFM = 0.33333334f;
    private float bFN = 0.33333334f;
    private float bFU = 0.5f;
    private c bFV = new c() { // from class: com.baidu.tbadk.widget.dragsort.a.1
        @Override // com.baidu.tbadk.widget.dragsort.a.c
        public float b(float f2, long j2) {
            return a.this.bFU * f2;
        }
    };
    private int bFZ = 0;
    private boolean bGa = false;
    private boolean bGb = false;
    private h bGc = null;
    private int bGe = 0;
    private float bGf = 0.25f;
    private float bGg = 0.0f;
    private boolean bGi = false;
    private boolean mBlockLayoutRequests = false;
    private boolean bGk = false;
    private i bGl = new i(3);
    private float bGq = 0.0f;
    private boolean bGt = false;
    private boolean bGu = false;

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
        this.bGr = fVar;
        this.mListView = listView;
    }

    @Override // com.baidu.tbadk.widget.dragsort.e
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            this.bGh = new C0118a(listAdapter);
            listAdapter.registerDataSetObserver(this.Qy);
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
            this.bGh = null;
        }
        this.bGr.setAdapter(this.bGh);
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
            if (i2 > this.bFz) {
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
        int i4 = this.bFI - this.bFH;
        int iw = iw(i2);
        int iu = iu(i2);
        if (this.bFx <= this.bFz) {
            if (i2 == this.bFx && this.bFw != this.bFx) {
                if (i2 == this.bFz) {
                    i3 = (i3 + iu) - this.bFI;
                } else {
                    i3 = ((iu - iw) + i3) - i4;
                }
            } else if (i2 > this.bFx && i2 <= this.bFz) {
                i3 -= i4;
            }
        } else if (i2 > this.bFz && i2 <= this.bFw) {
            i3 += i4;
        } else if (i2 == this.bFx && this.bFw != this.bFx) {
            i3 += iu - iw;
        }
        if (i2 <= this.bFz) {
            return (((this.bFI - dividerHeight) - iw(i2 - 1)) / 2) + i3;
        }
        return (((iw - dividerHeight) - this.bFI) / 2) + i3;
    }

    private boolean PU() {
        int i2;
        int i3;
        int i4;
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int i5 = this.bFw;
        View childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        if (childAt == null) {
            i5 = firstVisiblePosition + (this.mListView.getChildCount() / 2);
            childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        }
        int top = childAt.getTop();
        int height = childAt.getHeight();
        int aO = aO(i5, top);
        int dividerHeight = this.mListView.getDividerHeight();
        if (this.bFr >= aO) {
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
                    if (this.bFr < i2) {
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
                if (this.bFr >= i2) {
                    break;
                }
                i4 = i2;
            }
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int i9 = this.bFw;
        int i10 = this.bFx;
        float f2 = this.bGg;
        if (this.bFy) {
            int abs = Math.abs(i2 - i4);
            if (this.bFr >= i2) {
                int i11 = i4;
                i4 = i2;
                i2 = i11;
            }
            int i12 = (int) (abs * this.bGf * 0.5f);
            float f3 = i12;
            int i13 = i4 + i12;
            int i14 = i2 - i12;
            if (this.bFr < i13) {
                this.bFw = i3 - 1;
                this.bFx = i3;
                this.bGg = ((i13 - this.bFr) * 0.5f) / f3;
            } else if (this.bFr < i14) {
                this.bFw = i3;
                this.bFx = i3;
            } else {
                this.bFw = i3;
                this.bFx = i3 + 1;
                this.bGg = (1.0f + ((i2 - this.bFr) / f3)) * 0.5f;
            }
        } else {
            this.bFw = i3;
            this.bFx = i3;
        }
        if (this.bFw < headerViewsCount) {
            this.bFw = headerViewsCount;
            this.bFx = headerViewsCount;
            i3 = headerViewsCount;
        } else if (this.bFx >= this.mListView.getCount() - footerViewsCount) {
            i3 = (this.mListView.getCount() - footerViewsCount) - 1;
            this.bFw = i3;
            this.bFx = i3;
        }
        boolean z = (this.bFw == i9 && this.bFx == i10 && this.bGg == f2) ? false : true;
        if (i3 != this.bFv) {
            if (this.bFD != null) {
                this.bFD.drag(this.bFv - headerViewsCount, i3 - headerViewsCount);
            }
            this.bFv = i3;
            return true;
        }
        return z;
    }

    public void removeItem(int i2) {
        this.bGp = false;
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
            this.bFH = Math.max(1, obtainStyledAttributes.getDimensionPixelSize(d.l.DragSort_collapsed_height, 1));
            this.bGi = obtainStyledAttributes.getBoolean(d.l.DragSort_track_drag_sort, false);
            if (this.bGi) {
                this.bGj = new e();
            }
            this.bFt = obtainStyledAttributes.getFloat(d.l.DragSort_float_alpha, this.bFt);
            this.bFu = this.bFt;
            this.bFG = obtainStyledAttributes.getBoolean(d.l.DragSort_drag_enabled, this.bFG);
            this.bGf = Math.max(0.0f, Math.min(1.0f, 1.0f - obtainStyledAttributes.getFloat(d.l.DragSort_slide_shuffle_speed, 0.75f)));
            this.bFy = this.bGf > 0.0f;
            setDragScrollStart(obtainStyledAttributes.getFloat(d.l.DragSort_drag_scroll_start, this.bFM));
            this.bFU = obtainStyledAttributes.getFloat(d.l.DragSort_max_drag_scroll_speed, this.bFU);
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
                this.bGc = bVar;
                a(bVar);
            }
            obtainStyledAttributes.recycle();
            i2 = i5;
            i3 = i4;
        }
        this.bFL = new d();
        if (i3 > 0) {
            this.bGm = new k(0.5f, i3);
        }
        if (i2 > 0) {
            this.bGo = new f(0.5f, i2);
        }
        this.bGd = MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        this.Qy = new DataSetObserver() { // from class: com.baidu.tbadk.widget.dragsort.a.2
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
        this.bGs = bVar;
        this.mListView.setOnTouchListener(bVar);
    }

    @Override // com.baidu.tbadk.widget.dragsort.e
    public void dispatchDraw(Canvas canvas) {
        float f2;
        this.bGr.dispatchDraw(canvas);
        if (this.mDragState != 0) {
            if (this.bFw != this.bFz) {
                b(this.bFw, canvas);
            }
            if (this.bFx != this.bFw && this.bFx != this.bFz) {
                b(this.bFx, canvas);
            }
        }
        if (this.bFo != null) {
            int width = this.bFo.getWidth();
            int height = this.bFo.getHeight();
            int i2 = this.bFp.x;
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
            int i3 = (int) (f2 * 255.0f * this.bFu);
            canvas.save();
            canvas.translate(this.bFp.x, this.bFp.y);
            canvas.clipRect(0, 0, width, height);
            canvas.saveLayerAlpha(0.0f, 0.0f, width, height, i3, 31);
            this.bFo.draw(canvas);
            canvas.restore();
            canvas.restore();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.e
    public void onDraw(Canvas canvas) {
        this.bGr.onDraw(canvas);
        if (this.bGi) {
            this.bGj.Qh();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.e
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.bGk) {
            this.bGk = false;
            return false;
        } else if (!this.bFG) {
            return this.bGr.onTouchEvent(motionEvent);
        } else {
            boolean z2 = this.bGa;
            this.bGa = false;
            if (!z2) {
                A(motionEvent);
            }
            if (this.mDragState == 4) {
                onDragTouchEvent(motionEvent);
                return true;
            }
            if (this.mDragState == 0 && this.bGr.onTouchEvent(motionEvent)) {
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
                        this.bGe = 1;
                        return z;
                    }
                    return z;
            }
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.e
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (!this.bFG) {
            return this.bGr.onInterceptTouchEvent(motionEvent);
        }
        if (this.bGs != null) {
            this.bGs.Qj().onTouchEvent(motionEvent);
        }
        A(motionEvent);
        this.bGa = true;
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            if (this.mDragState != 0) {
                this.bGk = true;
                return true;
            }
            this.bGb = true;
        }
        if (this.bFo == null) {
            if (this.bGr.onInterceptTouchEvent(motionEvent)) {
                this.bGt = true;
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
                        this.bGe = 1;
                        break;
                    } else {
                        this.bGe = 2;
                        break;
                    }
            }
        } else {
            z = true;
        }
        if (action == 1 || action == 3) {
            this.bGb = false;
        }
        return z;
    }

    @Override // com.baidu.tbadk.widget.dragsort.e
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        this.bGr.onSizeChanged(i2, i3, i4, i5);
        Qa();
    }

    @Override // com.baidu.tbadk.widget.dragsort.e
    public void requestLayout() {
        if (!this.mBlockLayoutRequests) {
            this.bGr.requestLayout();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.e
    public void onMeasure(int i2, int i3) {
        this.bGr.onMeasure(i2, i3);
        if (this.bFo != null) {
            if (this.bFo.isLayoutRequested()) {
                Qc();
            }
            this.bFs = true;
        }
        this.mWidthMeasureSpec = i2;
    }

    @Override // com.baidu.tbadk.widget.dragsort.e
    public void layoutChildren() {
        this.bGr.layoutChildren();
        if (this.bFo != null) {
            if (this.bFo.isLayoutRequested() && !this.bFs) {
                Qc();
            }
            this.bFo.layout(0, 0, this.bFo.getMeasuredWidth(), this.bFo.getMeasuredHeight());
            this.bFs = false;
        }
    }

    public void removeItem(int i2, float f2) {
        if (this.mDragState == 0 || this.mDragState == 4) {
            if (this.mDragState == 0) {
                this.bFz = this.mListView.getHeaderViewsCount() + i2;
                this.bFw = this.bFz;
                this.bFx = this.bFz;
                this.bFv = this.bFz;
                View childAt = this.mListView.getChildAt(this.bFz - this.mListView.getFirstVisiblePosition());
                if (childAt != null) {
                    childAt.setVisibility(4);
                }
            }
            this.mDragState = 1;
            this.bGq = f2;
            if (this.bGb) {
                switch (this.bGe) {
                    case 1:
                        this.bGr.onTouchEvent(this.bGd);
                        break;
                    case 2:
                        this.bGr.onInterceptTouchEvent(this.bGd);
                        break;
                }
            }
            if (this.bGm != null) {
                this.bGm.start();
            } else {
                iv(i2);
            }
        }
    }

    public void cancelDrag() {
        if (this.mDragState == 4) {
            this.bFL.cI(true);
            Qe();
            PV();
            Qb();
            if (this.bGb) {
                this.mDragState = 3;
            } else {
                this.mDragState = 0;
            }
        }
    }

    private void PV() {
        this.bFz = -1;
        this.bFw = -1;
        this.bFx = -1;
        this.bFv = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PW() {
        this.mDragState = 2;
        if (this.bFE != null && this.bFv >= 0 && this.bFv < this.mListView.getCount()) {
            int headerViewsCount = this.mListView.getHeaderViewsCount();
            this.bFE.drop(this.bFz - headerViewsCount, this.bFv - headerViewsCount);
        }
        Qe();
        PY();
        PV();
        Qb();
        if (this.bGb) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PX() {
        iv(this.bFz - this.mListView.getHeaderViewsCount());
    }

    private void iv(int i2) {
        this.mDragState = 1;
        if (this.bFF != null) {
            this.bFF.remove(i2);
        }
        Qe();
        PY();
        PV();
        if (this.bGb) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    private void PY() {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        if (this.bFz < firstVisiblePosition) {
            View childAt = this.mListView.getChildAt(0);
            this.mListView.setSelectionFromTop(firstVisiblePosition - 1, (childAt != null ? childAt.getTop() : 0) - this.mListView.getPaddingTop());
        }
    }

    public boolean stopDrag(boolean z) {
        this.bGp = false;
        return stopDrag(z, 0.0f);
    }

    public boolean stopDragWithVelocity(boolean z, float f2) {
        this.bGp = true;
        return stopDrag(z, f2);
    }

    public boolean stopDrag(boolean z, float f2) {
        if (this.bFo != null) {
            this.bFL.cI(true);
            if (z) {
                removeItem(this.bFz - this.mListView.getHeaderViewsCount(), f2);
            } else if (this.bGo != null) {
                this.bGo.start();
            } else {
                PW();
            }
            if (this.bGi) {
                this.bGj.sc();
                return true;
            }
            return true;
        }
        return false;
    }

    private void PZ() {
        this.bGe = 0;
        this.bGb = false;
        if (this.mDragState == 3) {
            this.mDragState = 0;
        }
        this.bFu = this.bFt;
        this.bGt = false;
        this.bGl.clear();
    }

    private void A(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            this.mLastX = this.bFW;
            this.mLastY = this.bFX;
        }
        this.bFW = (int) motionEvent.getX();
        this.bFX = (int) motionEvent.getY();
        if (action == 0) {
            this.mLastX = this.bFW;
            this.mLastY = this.bFX;
        }
        this.bFC = ((int) motionEvent.getRawX()) - this.bFW;
        this.beE = ((int) motionEvent.getRawY()) - this.bFX;
    }

    public boolean listViewIntercepted() {
        return this.bGt;
    }

    public void setDragScrollStart(float f2) {
        setDragScrollStarts(f2, f2);
    }

    public void setDragScrollStarts(float f2, float f3) {
        if (f3 > 0.5f) {
            this.bFN = 0.5f;
        } else {
            this.bFN = f3;
        }
        if (f2 > 0.5f) {
            this.bFM = 0.5f;
        } else {
            this.bFM = f2;
        }
        if (this.mListView.getHeight() != 0) {
            Qa();
        }
    }

    private void aP(int i2, int i3) {
        this.bFp.x = i2 - this.bFA;
        this.bFp.y = i3 - this.bFB;
        cH(true);
        int min = Math.min(i3, this.bFr + this.bFJ);
        int max = Math.max(i3, this.bFr - this.bFJ);
        int Qg = this.bFL.Qg();
        if (min > this.mLastY && min > this.bFP && Qg != 1) {
            if (Qg != -1) {
                this.bFL.cI(true);
            }
            this.bFL.ix(1);
        } else if (max < this.mLastY && max < this.bFO && Qg != 0) {
            if (Qg != -1) {
                this.bFL.cI(true);
            }
            this.bFL.ix(0);
        } else if (max >= this.bFO && min <= this.bFP && this.bFL.Qf()) {
            this.bFL.cI(true);
        }
    }

    private void Qa() {
        int height;
        int paddingTop = this.mListView.getPaddingTop();
        float height2 = (this.mListView.getHeight() - paddingTop) - this.mListView.getPaddingBottom();
        this.bFR = paddingTop + (this.bFM * height2);
        this.bFQ = (height2 * (1.0f - this.bFN)) + paddingTop;
        this.bFO = (int) this.bFR;
        this.bFP = (int) this.bFQ;
        this.bFS = this.bFR - paddingTop;
        this.bFT = (paddingTop + height) - this.bFQ;
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
        if (i2 != this.bFz && i2 != this.bFw && i2 != this.bFx) {
            g2 = -2;
        } else {
            g2 = g(i2, view, z);
        }
        if (g2 != layoutParams.height) {
            layoutParams.height = g2;
            view.setLayoutParams(layoutParams);
        }
        if (i2 == this.bFw || i2 == this.bFx) {
            if (i2 < this.bFz) {
                ((com.baidu.tbadk.widget.dragsort.c) view).setGravity(80);
            } else if (i2 > this.bFz) {
                ((com.baidu.tbadk.widget.dragsort.c) view).setGravity(48);
            }
        }
        int visibility = view.getVisibility();
        int i3 = 0;
        if (i2 == this.bFz && this.bFo != null) {
            i3 = 4;
        }
        if (i3 != visibility) {
            view.setVisibility(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int iw(int i2) {
        View view;
        if (i2 == this.bFz) {
            return 0;
        }
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        if (childAt != null) {
            return f(i2, childAt, false);
        }
        int i3 = this.bGl.get(i2);
        if (i3 == -1) {
            ListAdapter adapter = this.mListView.getAdapter();
            int itemViewType = adapter.getItemViewType(i2);
            int viewTypeCount = adapter.getViewTypeCount();
            if (viewTypeCount != this.bFK.length) {
                this.bFK = new View[viewTypeCount];
            }
            if (itemViewType >= 0) {
                if (this.bFK[itemViewType] == null) {
                    view = adapter.getView(i2, null, this.mListView);
                    this.bFK[itemViewType] = view;
                } else {
                    view = adapter.getView(i2, this.bFK[itemViewType], this.mListView);
                }
            } else {
                view = adapter.getView(i2, null, this.mListView);
            }
            int f2 = f(i2, view, true);
            this.bGl.add(i2, f2);
            return f2;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(int i2, View view, boolean z) {
        if (i2 == this.bFz) {
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
        boolean z = this.bFy && this.bFw != this.bFx;
        int i4 = this.bFI - this.bFH;
        int i5 = (int) (this.bGg * i4);
        if (i2 == this.bFz) {
            if (this.bFz == this.bFw) {
                if (z) {
                    return i5 + this.bFH;
                }
                return this.bFI;
            } else if (this.bFz == this.bFx) {
                return this.bFI - i5;
            } else {
                return this.bFH;
            }
        } else if (i2 == this.bFw) {
            if (z) {
                return i3 + i5;
            }
            return i3 + i4;
        } else if (i2 == this.bFx) {
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
        if (i2 != this.bFz) {
            i6 = height - iw;
            i5 = aQ - iw;
        } else {
            i5 = aQ;
            i6 = height;
        }
        int i7 = this.bFI;
        if (this.bFz != this.bFw && this.bFz != this.bFx) {
            i7 -= this.bFH;
        }
        if (i2 <= i3) {
            if (i2 > this.bFw) {
                return (i7 - i5) + 0;
            }
        } else if (i2 == i4) {
            if (i2 <= this.bFw) {
                return (i6 - i7) + 0;
            }
            if (i2 == this.bFx) {
                return (height - aQ) + 0;
            }
            return 0 + i6;
        } else if (i2 <= this.bFw) {
            return 0 - i7;
        } else {
            if (i2 == this.bFx) {
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
        if (this.bFo != null) {
            measureItem(this.bFo);
            this.bFI = this.bFo.getMeasuredHeight();
            this.bFJ = this.bFI / 2;
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
        if (!this.bGb || this.bGc == null || (iy = this.bGc.iy(i2)) == null) {
            return false;
        }
        return startDrag(i2, iy, i3, i4, i5);
    }

    public boolean startDrag(int i2, View view, int i3, int i4, int i5) {
        if (this.mDragState == 0 && this.bGb && this.bFo == null && view != null && this.bFG) {
            if (this.mListView.getParent() != null) {
                this.mListView.getParent().requestDisallowInterceptTouchEvent(true);
            }
            int headerViewsCount = this.mListView.getHeaderViewsCount() + i2;
            this.bFw = headerViewsCount;
            this.bFx = headerViewsCount;
            this.bFz = headerViewsCount;
            this.bFv = headerViewsCount;
            this.mDragState = 4;
            this.bFZ = 0;
            this.bFZ |= i3;
            this.bFo = view;
            Qc();
            this.bFA = i4;
            this.bFB = i5;
            this.bFY = this.bFX;
            this.bFp.x = this.bFW - this.bFA;
            this.bFp.y = this.bFX - this.bFB;
            View childAt = this.mListView.getChildAt(this.bFz - this.mListView.getFirstVisiblePosition());
            if (childAt != null) {
                childAt.setVisibility(4);
            }
            if (this.bGi) {
                this.bGj.startTracking();
            }
            switch (this.bGe) {
                case 1:
                    this.bGr.onTouchEvent(this.bGd);
                    break;
                case 2:
                    this.bGr.onInterceptTouchEvent(this.bGd);
                    break;
            }
            this.mListView.requestLayout();
            if (this.bGn != null) {
                this.bGn.start();
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
        int i3 = this.bFw;
        int i4 = this.bFx;
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
        if (this.bGc != null) {
            this.bFq.set(this.bFW, this.bFX);
            this.bGc.b(this.bFo, this.bFp, this.bFq);
        }
        int i2 = this.bFp.x;
        int i3 = this.bFp.y;
        int paddingLeft = this.mListView.getPaddingLeft();
        if ((this.bFZ & 1) == 0 && i2 > paddingLeft) {
            this.bFp.x = paddingLeft;
        } else if ((this.bFZ & 2) == 0 && i2 < paddingLeft) {
            this.bFp.x = paddingLeft;
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int lastVisiblePosition = this.mListView.getLastVisiblePosition();
        int paddingTop = this.mListView.getPaddingTop();
        if (firstVisiblePosition < headerViewsCount) {
            paddingTop = this.mListView.getChildAt((headerViewsCount - firstVisiblePosition) - 1).getBottom();
        }
        if ((this.bFZ & 8) == 0 && firstVisiblePosition <= this.bFz) {
            paddingTop = Math.max(this.mListView.getChildAt(this.bFz - firstVisiblePosition).getTop(), paddingTop);
        }
        int height = this.mListView.getHeight() - this.mListView.getPaddingBottom();
        if (lastVisiblePosition >= (this.mListView.getCount() - footerViewsCount) - 1) {
            height = this.mListView.getChildAt(((this.mListView.getCount() - footerViewsCount) - 1) - firstVisiblePosition).getBottom();
        }
        if ((this.bFZ & 4) == 0 && lastVisiblePosition >= this.bFz) {
            height = Math.min(this.mListView.getChildAt(this.bFz - firstVisiblePosition).getBottom(), height);
        }
        if (i3 < paddingTop) {
            this.bFp.y = paddingTop;
        } else if (this.bFI + i3 > height) {
            this.bFp.y = height - this.bFI;
        }
        this.bFr = this.bFp.y + this.bFJ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qe() {
        if (this.bFo != null) {
            this.bFo.setVisibility(8);
            if (this.bGc != null) {
                this.bGc.bn(this.bFo);
            }
            this.bFo = null;
            this.mListView.invalidate();
        }
    }

    public void a(h hVar) {
        this.bGc = hVar;
    }

    public void a(b bVar) {
        this.bFD = bVar;
    }

    public void setDragEnabled(boolean z) {
        this.bFG = z;
    }

    public boolean isDragEnabled() {
        return this.bFG;
    }

    public void a(g gVar) {
        this.bFE = gVar;
    }

    public void a(l lVar) {
        this.bFF = lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class i {
        private SparseIntArray bGN;
        private ArrayList<Integer> bGO;
        private int mMaxSize;

        public i(int i) {
            this.bGN = new SparseIntArray(i);
            this.bGO = new ArrayList<>(i);
            this.mMaxSize = i;
        }

        public void add(int i, int i2) {
            int i3 = this.bGN.get(i, -1);
            if (i3 != i2) {
                if (i3 == -1) {
                    if (this.bGN.size() == this.mMaxSize) {
                        this.bGN.delete(this.bGO.remove(0).intValue());
                    }
                } else {
                    this.bGO.remove(Integer.valueOf(i));
                }
                this.bGN.put(i, i2);
                this.bGO.add(Integer.valueOf(i));
            }
        }

        public int get(int i) {
            return this.bGN.get(i, -1);
        }

        public void clear() {
            this.bGN.clear();
            this.bGO.clear();
        }
    }

    /* renamed from: com.baidu.tbadk.widget.dragsort.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0118a extends BaseAdapter {
        private ListAdapter mAdapter;

        public C0118a(ListAdapter listAdapter) {
            this.mAdapter = listAdapter;
            this.mAdapter.registerDataSetObserver(new DataSetObserver() { // from class: com.baidu.tbadk.widget.dragsort.a.a.1
                @Override // android.database.DataSetObserver
                public void onChanged() {
                    C0118a.this.notifyDataSetChanged();
                }

                @Override // android.database.DataSetObserver
                public void onInvalidated() {
                    C0118a.this.notifyDataSetInvalidated();
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
        private float bGY;
        private float bGZ;
        private float bHa;
        private float bHb;
        private float bHc;
        private float mAlpha;
        private boolean mCanceled;
        protected long mStartTime;

        public m(float f, int i) {
            this.mAlpha = f;
            this.bGY = i;
            float f2 = 1.0f / ((this.mAlpha * 2.0f) * (1.0f - this.mAlpha));
            this.bHc = f2;
            this.bGZ = f2;
            this.bHa = this.mAlpha / ((this.mAlpha - 1.0f) * 2.0f);
            this.bHb = 1.0f / (1.0f - this.mAlpha);
        }

        public float ab(float f) {
            if (f < this.mAlpha) {
                return this.bGZ * f * f;
            }
            if (f < 1.0f - this.mAlpha) {
                return this.bHa + (this.bHb * f);
            }
            return 1.0f - ((this.bHc * (f - 1.0f)) * (f - 1.0f));
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
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / this.bGY;
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
        private int bGJ;
        private int bGK;
        private float bGL;
        private float bGM;

        public f(float f, int i) {
            super(f, i);
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.bGJ = a.this.bFv;
            this.bGK = a.this.bFz;
            a.this.mDragState = 2;
            this.bGL = a.this.bFp.y - Qi();
            this.bGM = a.this.bFp.x - a.this.mListView.getPaddingLeft();
        }

        private int Qi() {
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            int dividerHeight = (a.this.bFH + a.this.mListView.getDividerHeight()) / 2;
            View childAt = a.this.mListView.getChildAt(this.bGJ - firstVisiblePosition);
            if (childAt != null) {
                if (this.bGJ == this.bGK) {
                    return childAt.getTop();
                }
                if (this.bGJ >= this.bGK) {
                    return (childAt.getBottom() + dividerHeight) - a.this.bFI;
                }
                return childAt.getTop() - dividerHeight;
            }
            cancel();
            return -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void n(float f, float f2) {
            int Qi = Qi();
            float paddingLeft = a.this.bFp.x - a.this.mListView.getPaddingLeft();
            float f3 = 1.0f - f2;
            if (f3 < Math.abs((a.this.bFp.y - Qi) / this.bGL) || f3 < Math.abs(paddingLeft / this.bGM)) {
                a.this.bFp.y = Qi + ((int) (this.bGL * f3));
                a.this.bFp.x = a.this.mListView.getPaddingLeft() + ((int) (this.bGM * f3));
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
        private int bGK;
        private float bGR;
        private float bGS;
        private float bGT;
        private int bGU;
        private int bGV;
        private int bGW;
        private int bGX;

        public k(float f, int i) {
            super(f, i);
            this.bGU = -1;
            this.bGV = -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.bGU = -1;
            this.bGV = -1;
            this.bGW = a.this.bFw;
            this.bGX = a.this.bFx;
            this.bGK = a.this.bFz;
            a.this.mDragState = 1;
            this.bGR = a.this.bFp.x;
            if (a.this.bGp) {
                float width = a.this.mListView.getWidth() * 2.0f;
                if (a.this.bGq == 0.0f) {
                    a.this.bGq = (this.bGR >= 0.0f ? 1 : -1) * width;
                    return;
                }
                float f = width * 2.0f;
                if (a.this.bGq >= 0.0f || a.this.bGq <= (-f)) {
                    if (a.this.bGq > 0.0f && a.this.bGq < f) {
                        a.this.bGq = f;
                        return;
                    }
                    return;
                }
                a.this.bGq = -f;
                return;
            }
            a.this.Qe();
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void n(float f, float f2) {
            View childAt;
            float f3 = 1.0f - f2;
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            View childAt2 = a.this.mListView.getChildAt(this.bGW - firstVisiblePosition);
            if (a.this.bGp) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / 1000.0f;
                if (uptimeMillis != 0.0f) {
                    float f4 = a.this.bGq * uptimeMillis;
                    int width = a.this.mListView.getWidth();
                    a.this.bGq = ((a.this.bGq > 0.0f ? 1 : -1) * uptimeMillis * width) + a.this.bGq;
                    this.bGR += f4;
                    a.this.bFp.x = (int) this.bGR;
                    if (this.bGR < width && this.bGR > (-width)) {
                        this.mStartTime = SystemClock.uptimeMillis();
                        a.this.cH(true);
                        return;
                    }
                } else {
                    return;
                }
            }
            if (childAt2 != null) {
                if (this.bGU == -1) {
                    this.bGU = a.this.f(this.bGW, childAt2, false);
                    this.bGS = childAt2.getHeight() - this.bGU;
                }
                int max = Math.max((int) (this.bGS * f3), 1);
                ViewGroup.LayoutParams layoutParams = childAt2.getLayoutParams();
                layoutParams.height = max + this.bGU;
                childAt2.setLayoutParams(layoutParams);
            }
            if (this.bGX != this.bGW && (childAt = a.this.mListView.getChildAt(this.bGX - firstVisiblePosition)) != null) {
                if (this.bGV == -1) {
                    this.bGV = a.this.f(this.bGX, childAt, false);
                    this.bGT = childAt.getHeight() - this.bGV;
                }
                int max2 = Math.max((int) (this.bGT * f3), 1);
                ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
                layoutParams2.height = max2 + this.bGV;
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
        private float bGP;
        private float bGQ;
        final /* synthetic */ a bGv;

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.bGP = this.bGv.bFB;
            this.bGQ = this.bGv.bFJ;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void n(float f, float f2) {
            if (this.bGv.mDragState != 4) {
                cancel();
                return;
            }
            this.bGv.bFB = (int) ((this.bGQ * f2) + ((1.0f - f2) * this.bGP));
            this.bGv.bFp.y = this.bGv.bFX - this.bGv.bFB;
            this.bGv.cH(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e {
        StringBuilder mBuilder = new StringBuilder();
        private int bGG = 0;
        private int bGH = 0;
        private boolean bGI = false;
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
            this.bGH = 0;
            this.bGI = true;
        }

        public void Qh() {
            if (this.bGI) {
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
                this.mBuilder.append("    <FirstExpPos>").append(a.this.bFw).append("</FirstExpPos>\n");
                this.mBuilder.append("    <FirstExpBlankHeight>").append(a.this.iu(a.this.bFw) - a.this.iw(a.this.bFw)).append("</FirstExpBlankHeight>\n");
                this.mBuilder.append("    <SecondExpPos>").append(a.this.bFx).append("</SecondExpPos>\n");
                this.mBuilder.append("    <SecondExpBlankHeight>").append(a.this.iu(a.this.bFx) - a.this.iw(a.this.bFx)).append("</SecondExpBlankHeight>\n");
                this.mBuilder.append("    <SrcPos>").append(a.this.bFz).append("</SrcPos>\n");
                this.mBuilder.append("    <SrcHeight>").append(a.this.bFI + a.this.mListView.getDividerHeight()).append("</SrcHeight>\n");
                this.mBuilder.append("    <ViewHeight>").append(a.this.mListView.getHeight()).append("</ViewHeight>\n");
                this.mBuilder.append("    <LastY>").append(a.this.mLastY).append("</LastY>\n");
                this.mBuilder.append("    <FloatY>").append(a.this.bFr).append("</FloatY>\n");
                this.mBuilder.append("    <ShuffleEdges>");
                for (int i4 = 0; i4 < childCount; i4++) {
                    this.mBuilder.append(a.this.aO(firstVisiblePosition + i4, a.this.mListView.getChildAt(i4).getTop())).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                this.mBuilder.append("</ShuffleEdges>\n");
                this.mBuilder.append("</DSLVState>\n");
                this.bGG++;
                if (this.bGG > 1000) {
                    flush();
                    this.bGG = 0;
                }
            }
        }

        public void flush() {
            if (this.bGI) {
                try {
                    FileWriter fileWriter = new FileWriter(this.mFile, this.bGH != 0);
                    fileWriter.write(this.mBuilder.toString());
                    this.mBuilder.delete(0, this.mBuilder.length());
                    fileWriter.flush();
                    fileWriter.close();
                    this.bGH++;
                } catch (IOException e) {
                }
            }
        }

        public void sc() {
            if (this.bGI) {
                this.mBuilder.append("</DSLVStates>\n");
                flush();
                this.bGI = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements Runnable {
        private long bGA;
        private float bGB;
        private long bGC;
        private int bGD;
        private float bGE;
        private boolean bGF = false;
        private boolean bGy;
        private long bGz;
        private int dy;

        public boolean Qf() {
            return this.bGF;
        }

        public int Qg() {
            if (this.bGF) {
                return this.bGD;
            }
            return -1;
        }

        public d() {
        }

        public void ix(int i) {
            if (!this.bGF) {
                this.bGy = false;
                this.bGF = true;
                this.bGC = SystemClock.uptimeMillis();
                this.bGz = this.bGC;
                this.bGD = i;
                a.this.mListView.post(this);
            }
        }

        public void cI(boolean z) {
            if (z) {
                a.this.mListView.removeCallbacks(this);
                this.bGF = false;
                return;
            }
            this.bGy = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.bGy) {
                int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
                int lastVisiblePosition = a.this.mListView.getLastVisiblePosition();
                int count = a.this.mListView.getCount();
                int paddingTop = a.this.mListView.getPaddingTop();
                int height = (a.this.mListView.getHeight() - paddingTop) - a.this.mListView.getPaddingBottom();
                int min = Math.min(a.this.bFX, a.this.bFr + a.this.bFJ);
                int max = Math.max(a.this.bFX, a.this.bFr - a.this.bFJ);
                if (this.bGD == 0) {
                    View childAt = a.this.mListView.getChildAt(0);
                    if (childAt == null) {
                        this.bGF = false;
                        return;
                    } else if (firstVisiblePosition == 0 && childAt.getTop() == paddingTop) {
                        this.bGF = false;
                        return;
                    } else {
                        this.bGE = a.this.bFV.b((a.this.bFR - max) / a.this.bFS, this.bGz);
                    }
                } else {
                    View childAt2 = a.this.mListView.getChildAt(lastVisiblePosition - firstVisiblePosition);
                    if (childAt2 == null) {
                        this.bGF = false;
                        return;
                    } else if (lastVisiblePosition == count - 1 && childAt2.getBottom() <= height + paddingTop) {
                        this.bGF = false;
                        return;
                    } else {
                        this.bGE = -a.this.bFV.b((min - a.this.bFQ) / a.this.bFT, this.bGz);
                    }
                }
                this.bGA = SystemClock.uptimeMillis();
                this.bGB = (float) (this.bGA - this.bGz);
                this.dy = Math.round(this.bGE * this.bGB);
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
                this.bGz = this.bGA;
                a.this.mListView.post(this);
                return;
            }
            this.bGF = false;
        }
    }
}
