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
    private int bFB;
    private int bFC;
    private float bFD;
    private float bFE;
    private float bFF;
    private float bFG;
    private int bFJ;
    private int bFK;
    private int bFL;
    private MotionEvent bFQ;
    private C0119a bFU;
    private e bFW;
    private k bFZ;
    private View bFb;
    private int bFe;
    private int bFi;
    private int bFj;
    private int bFk;
    private int bFm;
    private int bFn;
    private int bFo;
    private int bFp;
    private b bFq;
    private g bFr;
    private l bFs;
    private int bFv;
    private int bFw;
    private d bFy;
    private j bGa;
    private f bGb;
    private boolean bGc;
    private com.baidu.tbadk.widget.dragsort.f bGe;
    private com.baidu.tbadk.widget.dragsort.b bGf;
    private int ber;
    private int mLastX;
    private int mLastY;
    private ListView mListView;
    private Point bFc = new Point();
    private Point bFd = new Point();
    private boolean bFf = false;
    private float bFg = 1.0f;
    private float bFh = 1.0f;
    private boolean bFl = false;
    private boolean bFt = true;
    private int mDragState = 0;
    private int bFu = 1;
    private int mWidthMeasureSpec = 0;
    private View[] bFx = new View[1];
    private float bFz = 0.33333334f;
    private float bFA = 0.33333334f;
    private float bFH = 0.5f;
    private c bFI = new c() { // from class: com.baidu.tbadk.widget.dragsort.a.1
        @Override // com.baidu.tbadk.widget.dragsort.a.c
        public float b(float f2, long j2) {
            return a.this.bFH * f2;
        }
    };
    private int bFM = 0;
    private boolean bFN = false;
    private boolean bFO = false;
    private h bFP = null;
    private int bFR = 0;
    private float bFS = 0.25f;
    private float bFT = 0.0f;
    private boolean bFV = false;
    private boolean mBlockLayoutRequests = false;
    private boolean bFX = false;
    private i bFY = new i(3);
    private float bGd = 0.0f;
    private boolean bGg = false;
    private boolean bGh = false;

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
        this.bGe = fVar;
        this.mListView = listView;
    }

    @Override // com.baidu.tbadk.widget.dragsort.e
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            this.bFU = new C0119a(listAdapter);
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
            this.bFU = null;
        }
        this.bGe.setAdapter(this.bFU);
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
            if (i2 > this.bFm) {
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
        int i4 = this.bFv - this.bFu;
        int iw = iw(i2);
        int iu = iu(i2);
        if (this.bFk <= this.bFm) {
            if (i2 == this.bFk && this.bFj != this.bFk) {
                if (i2 == this.bFm) {
                    i3 = (i3 + iu) - this.bFv;
                } else {
                    i3 = ((iu - iw) + i3) - i4;
                }
            } else if (i2 > this.bFk && i2 <= this.bFm) {
                i3 -= i4;
            }
        } else if (i2 > this.bFm && i2 <= this.bFj) {
            i3 += i4;
        } else if (i2 == this.bFk && this.bFj != this.bFk) {
            i3 += iu - iw;
        }
        if (i2 <= this.bFm) {
            return (((this.bFv - dividerHeight) - iw(i2 - 1)) / 2) + i3;
        }
        return (((iw - dividerHeight) - this.bFv) / 2) + i3;
    }

    private boolean PT() {
        int i2;
        int i3;
        int i4;
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int i5 = this.bFj;
        View childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        if (childAt == null) {
            i5 = firstVisiblePosition + (this.mListView.getChildCount() / 2);
            childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        }
        int top = childAt.getTop();
        int height = childAt.getHeight();
        int aO = aO(i5, top);
        int dividerHeight = this.mListView.getDividerHeight();
        if (this.bFe >= aO) {
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
                    if (this.bFe < i2) {
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
                if (this.bFe >= i2) {
                    break;
                }
                i4 = i2;
            }
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int i9 = this.bFj;
        int i10 = this.bFk;
        float f2 = this.bFT;
        if (this.bFl) {
            int abs = Math.abs(i2 - i4);
            if (this.bFe >= i2) {
                int i11 = i4;
                i4 = i2;
                i2 = i11;
            }
            int i12 = (int) (abs * this.bFS * 0.5f);
            float f3 = i12;
            int i13 = i4 + i12;
            int i14 = i2 - i12;
            if (this.bFe < i13) {
                this.bFj = i3 - 1;
                this.bFk = i3;
                this.bFT = ((i13 - this.bFe) * 0.5f) / f3;
            } else if (this.bFe < i14) {
                this.bFj = i3;
                this.bFk = i3;
            } else {
                this.bFj = i3;
                this.bFk = i3 + 1;
                this.bFT = (1.0f + ((i2 - this.bFe) / f3)) * 0.5f;
            }
        } else {
            this.bFj = i3;
            this.bFk = i3;
        }
        if (this.bFj < headerViewsCount) {
            this.bFj = headerViewsCount;
            this.bFk = headerViewsCount;
            i3 = headerViewsCount;
        } else if (this.bFk >= this.mListView.getCount() - footerViewsCount) {
            i3 = (this.mListView.getCount() - footerViewsCount) - 1;
            this.bFj = i3;
            this.bFk = i3;
        }
        boolean z = (this.bFj == i9 && this.bFk == i10 && this.bFT == f2) ? false : true;
        if (i3 != this.bFi) {
            if (this.bFq != null) {
                this.bFq.drag(this.bFi - headerViewsCount, i3 - headerViewsCount);
            }
            this.bFi = i3;
            return true;
        }
        return z;
    }

    public void removeItem(int i2) {
        this.bGc = false;
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
            this.bFu = Math.max(1, obtainStyledAttributes.getDimensionPixelSize(d.l.DragSort_collapsed_height, 1));
            this.bFV = obtainStyledAttributes.getBoolean(d.l.DragSort_track_drag_sort, false);
            if (this.bFV) {
                this.bFW = new e();
            }
            this.bFg = obtainStyledAttributes.getFloat(d.l.DragSort_float_alpha, this.bFg);
            this.bFh = this.bFg;
            this.bFt = obtainStyledAttributes.getBoolean(d.l.DragSort_drag_enabled, this.bFt);
            this.bFS = Math.max(0.0f, Math.min(1.0f, 1.0f - obtainStyledAttributes.getFloat(d.l.DragSort_slide_shuffle_speed, 0.75f)));
            this.bFl = this.bFS > 0.0f;
            setDragScrollStart(obtainStyledAttributes.getFloat(d.l.DragSort_drag_scroll_start, this.bFz));
            this.bFH = obtainStyledAttributes.getFloat(d.l.DragSort_max_drag_scroll_speed, this.bFH);
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
                this.bFP = bVar;
                a(bVar);
            }
            obtainStyledAttributes.recycle();
            i2 = i5;
            i3 = i4;
        }
        this.bFy = new d();
        if (i3 > 0) {
            this.bFZ = new k(0.5f, i3);
        }
        if (i2 > 0) {
            this.bGb = new f(0.5f, i2);
        }
        this.bFQ = MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
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
        this.bGf = bVar;
        this.mListView.setOnTouchListener(bVar);
    }

    @Override // com.baidu.tbadk.widget.dragsort.e
    public void dispatchDraw(Canvas canvas) {
        float f2;
        this.bGe.dispatchDraw(canvas);
        if (this.mDragState != 0) {
            if (this.bFj != this.bFm) {
                b(this.bFj, canvas);
            }
            if (this.bFk != this.bFj && this.bFk != this.bFm) {
                b(this.bFk, canvas);
            }
        }
        if (this.bFb != null) {
            int width = this.bFb.getWidth();
            int height = this.bFb.getHeight();
            int i2 = this.bFc.x;
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
            int i3 = (int) (f2 * 255.0f * this.bFh);
            canvas.save();
            canvas.translate(this.bFc.x, this.bFc.y);
            canvas.clipRect(0, 0, width, height);
            canvas.saveLayerAlpha(0.0f, 0.0f, width, height, i3, 31);
            this.bFb.draw(canvas);
            canvas.restore();
            canvas.restore();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.e
    public void onDraw(Canvas canvas) {
        this.bGe.onDraw(canvas);
        if (this.bFV) {
            this.bFW.Qg();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.e
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.bFX) {
            this.bFX = false;
            return false;
        } else if (!this.bFt) {
            return this.bGe.onTouchEvent(motionEvent);
        } else {
            boolean z2 = this.bFN;
            this.bFN = false;
            if (!z2) {
                A(motionEvent);
            }
            if (this.mDragState == 4) {
                onDragTouchEvent(motionEvent);
                return true;
            }
            if (this.mDragState == 0 && this.bGe.onTouchEvent(motionEvent)) {
                z = true;
            }
            switch (motionEvent.getAction() & 255) {
                case 1:
                case 3:
                    PY();
                    return z;
                case 2:
                default:
                    if (z) {
                        this.bFR = 1;
                        return z;
                    }
                    return z;
            }
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.e
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (!this.bFt) {
            return this.bGe.onInterceptTouchEvent(motionEvent);
        }
        if (this.bGf != null) {
            this.bGf.Qi().onTouchEvent(motionEvent);
        }
        A(motionEvent);
        this.bFN = true;
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            if (this.mDragState != 0) {
                this.bFX = true;
                return true;
            }
            this.bFO = true;
        }
        if (this.bFb == null) {
            if (this.bGe.onInterceptTouchEvent(motionEvent)) {
                this.bGg = true;
                z = true;
            } else {
                z = false;
            }
            switch (action) {
                case 1:
                case 3:
                    PY();
                    break;
                case 2:
                default:
                    if (z) {
                        this.bFR = 1;
                        break;
                    } else {
                        this.bFR = 2;
                        break;
                    }
            }
        } else {
            z = true;
        }
        if (action == 1 || action == 3) {
            this.bFO = false;
        }
        return z;
    }

    @Override // com.baidu.tbadk.widget.dragsort.e
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        this.bGe.onSizeChanged(i2, i3, i4, i5);
        PZ();
    }

    @Override // com.baidu.tbadk.widget.dragsort.e
    public void requestLayout() {
        if (!this.mBlockLayoutRequests) {
            this.bGe.requestLayout();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.e
    public void onMeasure(int i2, int i3) {
        this.bGe.onMeasure(i2, i3);
        if (this.bFb != null) {
            if (this.bFb.isLayoutRequested()) {
                Qb();
            }
            this.bFf = true;
        }
        this.mWidthMeasureSpec = i2;
    }

    @Override // com.baidu.tbadk.widget.dragsort.e
    public void layoutChildren() {
        this.bGe.layoutChildren();
        if (this.bFb != null) {
            if (this.bFb.isLayoutRequested() && !this.bFf) {
                Qb();
            }
            this.bFb.layout(0, 0, this.bFb.getMeasuredWidth(), this.bFb.getMeasuredHeight());
            this.bFf = false;
        }
    }

    public void removeItem(int i2, float f2) {
        if (this.mDragState == 0 || this.mDragState == 4) {
            if (this.mDragState == 0) {
                this.bFm = this.mListView.getHeaderViewsCount() + i2;
                this.bFj = this.bFm;
                this.bFk = this.bFm;
                this.bFi = this.bFm;
                View childAt = this.mListView.getChildAt(this.bFm - this.mListView.getFirstVisiblePosition());
                if (childAt != null) {
                    childAt.setVisibility(4);
                }
            }
            this.mDragState = 1;
            this.bGd = f2;
            if (this.bFO) {
                switch (this.bFR) {
                    case 1:
                        this.bGe.onTouchEvent(this.bFQ);
                        break;
                    case 2:
                        this.bGe.onInterceptTouchEvent(this.bFQ);
                        break;
                }
            }
            if (this.bFZ != null) {
                this.bFZ.start();
            } else {
                iv(i2);
            }
        }
    }

    public void cancelDrag() {
        if (this.mDragState == 4) {
            this.bFy.cI(true);
            Qd();
            PU();
            Qa();
            if (this.bFO) {
                this.mDragState = 3;
            } else {
                this.mDragState = 0;
            }
        }
    }

    private void PU() {
        this.bFm = -1;
        this.bFj = -1;
        this.bFk = -1;
        this.bFi = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PV() {
        this.mDragState = 2;
        if (this.bFr != null && this.bFi >= 0 && this.bFi < this.mListView.getCount()) {
            int headerViewsCount = this.mListView.getHeaderViewsCount();
            this.bFr.drop(this.bFm - headerViewsCount, this.bFi - headerViewsCount);
        }
        Qd();
        PX();
        PU();
        Qa();
        if (this.bFO) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PW() {
        iv(this.bFm - this.mListView.getHeaderViewsCount());
    }

    private void iv(int i2) {
        this.mDragState = 1;
        if (this.bFs != null) {
            this.bFs.remove(i2);
        }
        Qd();
        PX();
        PU();
        if (this.bFO) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    private void PX() {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        if (this.bFm < firstVisiblePosition) {
            View childAt = this.mListView.getChildAt(0);
            this.mListView.setSelectionFromTop(firstVisiblePosition - 1, (childAt != null ? childAt.getTop() : 0) - this.mListView.getPaddingTop());
        }
    }

    public boolean stopDrag(boolean z) {
        this.bGc = false;
        return stopDrag(z, 0.0f);
    }

    public boolean stopDragWithVelocity(boolean z, float f2) {
        this.bGc = true;
        return stopDrag(z, f2);
    }

    public boolean stopDrag(boolean z, float f2) {
        if (this.bFb != null) {
            this.bFy.cI(true);
            if (z) {
                removeItem(this.bFm - this.mListView.getHeaderViewsCount(), f2);
            } else if (this.bGb != null) {
                this.bGb.start();
            } else {
                PV();
            }
            if (this.bFV) {
                this.bFW.sc();
                return true;
            }
            return true;
        }
        return false;
    }

    private void PY() {
        this.bFR = 0;
        this.bFO = false;
        if (this.mDragState == 3) {
            this.mDragState = 0;
        }
        this.bFh = this.bFg;
        this.bGg = false;
        this.bFY.clear();
    }

    private void A(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            this.mLastX = this.bFJ;
            this.mLastY = this.bFK;
        }
        this.bFJ = (int) motionEvent.getX();
        this.bFK = (int) motionEvent.getY();
        if (action == 0) {
            this.mLastX = this.bFJ;
            this.mLastY = this.bFK;
        }
        this.bFp = ((int) motionEvent.getRawX()) - this.bFJ;
        this.ber = ((int) motionEvent.getRawY()) - this.bFK;
    }

    public boolean listViewIntercepted() {
        return this.bGg;
    }

    public void setDragScrollStart(float f2) {
        setDragScrollStarts(f2, f2);
    }

    public void setDragScrollStarts(float f2, float f3) {
        if (f3 > 0.5f) {
            this.bFA = 0.5f;
        } else {
            this.bFA = f3;
        }
        if (f2 > 0.5f) {
            this.bFz = 0.5f;
        } else {
            this.bFz = f2;
        }
        if (this.mListView.getHeight() != 0) {
            PZ();
        }
    }

    private void aP(int i2, int i3) {
        this.bFc.x = i2 - this.bFn;
        this.bFc.y = i3 - this.bFo;
        cH(true);
        int min = Math.min(i3, this.bFe + this.bFw);
        int max = Math.max(i3, this.bFe - this.bFw);
        int Qf = this.bFy.Qf();
        if (min > this.mLastY && min > this.bFC && Qf != 1) {
            if (Qf != -1) {
                this.bFy.cI(true);
            }
            this.bFy.ix(1);
        } else if (max < this.mLastY && max < this.bFB && Qf != 0) {
            if (Qf != -1) {
                this.bFy.cI(true);
            }
            this.bFy.ix(0);
        } else if (max >= this.bFB && min <= this.bFC && this.bFy.Qe()) {
            this.bFy.cI(true);
        }
    }

    private void PZ() {
        int height;
        int paddingTop = this.mListView.getPaddingTop();
        float height2 = (this.mListView.getHeight() - paddingTop) - this.mListView.getPaddingBottom();
        this.bFE = paddingTop + (this.bFz * height2);
        this.bFD = (height2 * (1.0f - this.bFA)) + paddingTop;
        this.bFB = (int) this.bFE;
        this.bFC = (int) this.bFD;
        this.bFF = this.bFE - paddingTop;
        this.bFG = (paddingTop + height) - this.bFD;
    }

    private void Qa() {
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
        if (i2 != this.bFm && i2 != this.bFj && i2 != this.bFk) {
            g2 = -2;
        } else {
            g2 = g(i2, view, z);
        }
        if (g2 != layoutParams.height) {
            layoutParams.height = g2;
            view.setLayoutParams(layoutParams);
        }
        if (i2 == this.bFj || i2 == this.bFk) {
            if (i2 < this.bFm) {
                ((com.baidu.tbadk.widget.dragsort.c) view).setGravity(80);
            } else if (i2 > this.bFm) {
                ((com.baidu.tbadk.widget.dragsort.c) view).setGravity(48);
            }
        }
        int visibility = view.getVisibility();
        int i3 = 0;
        if (i2 == this.bFm && this.bFb != null) {
            i3 = 4;
        }
        if (i3 != visibility) {
            view.setVisibility(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int iw(int i2) {
        View view;
        if (i2 == this.bFm) {
            return 0;
        }
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        if (childAt != null) {
            return f(i2, childAt, false);
        }
        int i3 = this.bFY.get(i2);
        if (i3 == -1) {
            ListAdapter adapter = this.mListView.getAdapter();
            int itemViewType = adapter.getItemViewType(i2);
            int viewTypeCount = adapter.getViewTypeCount();
            if (viewTypeCount != this.bFx.length) {
                this.bFx = new View[viewTypeCount];
            }
            if (itemViewType >= 0) {
                if (this.bFx[itemViewType] == null) {
                    view = adapter.getView(i2, null, this.mListView);
                    this.bFx[itemViewType] = view;
                } else {
                    view = adapter.getView(i2, this.bFx[itemViewType], this.mListView);
                }
            } else {
                view = adapter.getView(i2, null, this.mListView);
            }
            int f2 = f(i2, view, true);
            this.bFY.add(i2, f2);
            return f2;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(int i2, View view, boolean z) {
        if (i2 == this.bFm) {
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
        boolean z = this.bFl && this.bFj != this.bFk;
        int i4 = this.bFv - this.bFu;
        int i5 = (int) (this.bFT * i4);
        if (i2 == this.bFm) {
            if (this.bFm == this.bFj) {
                if (z) {
                    return i5 + this.bFu;
                }
                return this.bFv;
            } else if (this.bFm == this.bFk) {
                return this.bFv - i5;
            } else {
                return this.bFu;
            }
        } else if (i2 == this.bFj) {
            if (z) {
                return i3 + i5;
            }
            return i3 + i4;
        } else if (i2 == this.bFk) {
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
        if (i2 != this.bFm) {
            i6 = height - iw;
            i5 = aQ - iw;
        } else {
            i5 = aQ;
            i6 = height;
        }
        int i7 = this.bFv;
        if (this.bFm != this.bFj && this.bFm != this.bFk) {
            i7 -= this.bFu;
        }
        if (i2 <= i3) {
            if (i2 > this.bFj) {
                return (i7 - i5) + 0;
            }
        } else if (i2 == i4) {
            if (i2 <= this.bFj) {
                return (i6 - i7) + 0;
            }
            if (i2 == this.bFk) {
                return (height - aQ) + 0;
            }
            return 0 + i6;
        } else if (i2 <= this.bFj) {
            return 0 - i7;
        } else {
            if (i2 == this.bFk) {
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

    private void Qb() {
        if (this.bFb != null) {
            measureItem(this.bFb);
            this.bFv = this.bFb.getMeasuredHeight();
            this.bFw = this.bFv / 2;
        }
    }

    protected boolean onDragTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        switch (motionEvent.getAction() & 255) {
            case 1:
                if (this.mDragState == 4) {
                    stopDrag(false);
                }
                PY();
                return true;
            case 2:
                aP((int) motionEvent.getX(), (int) motionEvent.getY());
                return true;
            case 3:
                if (this.mDragState == 4) {
                    cancelDrag();
                }
                PY();
                return true;
            default:
                return true;
        }
    }

    public boolean startDrag(int i2, int i3, int i4, int i5) {
        View iy;
        if (!this.bFO || this.bFP == null || (iy = this.bFP.iy(i2)) == null) {
            return false;
        }
        return startDrag(i2, iy, i3, i4, i5);
    }

    public boolean startDrag(int i2, View view, int i3, int i4, int i5) {
        if (this.mDragState == 0 && this.bFO && this.bFb == null && view != null && this.bFt) {
            if (this.mListView.getParent() != null) {
                this.mListView.getParent().requestDisallowInterceptTouchEvent(true);
            }
            int headerViewsCount = this.mListView.getHeaderViewsCount() + i2;
            this.bFj = headerViewsCount;
            this.bFk = headerViewsCount;
            this.bFm = headerViewsCount;
            this.bFi = headerViewsCount;
            this.mDragState = 4;
            this.bFM = 0;
            this.bFM |= i3;
            this.bFb = view;
            Qb();
            this.bFn = i4;
            this.bFo = i5;
            this.bFL = this.bFK;
            this.bFc.x = this.bFJ - this.bFn;
            this.bFc.y = this.bFK - this.bFo;
            View childAt = this.mListView.getChildAt(this.bFm - this.mListView.getFirstVisiblePosition());
            if (childAt != null) {
                childAt.setVisibility(4);
            }
            if (this.bFV) {
                this.bFW.startTracking();
            }
            switch (this.bFR) {
                case 1:
                    this.bGe.onTouchEvent(this.bFQ);
                    break;
                case 2:
                    this.bGe.onInterceptTouchEvent(this.bFQ);
                    break;
            }
            this.mListView.requestLayout();
            if (this.bGa != null) {
                this.bGa.start();
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
        Qc();
        int i3 = this.bFj;
        int i4 = this.bFk;
        boolean PT = PT();
        if (PT) {
            Qa();
            this.mListView.setSelectionFromTop(i2, (b(i2, view, i3, i4) + view.getTop()) - this.mListView.getPaddingTop());
            layoutChildren();
        }
        if (PT || z) {
            this.mListView.invalidate();
        }
        this.mBlockLayoutRequests = false;
    }

    private void Qc() {
        if (this.bFP != null) {
            this.bFd.set(this.bFJ, this.bFK);
            this.bFP.b(this.bFb, this.bFc, this.bFd);
        }
        int i2 = this.bFc.x;
        int i3 = this.bFc.y;
        int paddingLeft = this.mListView.getPaddingLeft();
        if ((this.bFM & 1) == 0 && i2 > paddingLeft) {
            this.bFc.x = paddingLeft;
        } else if ((this.bFM & 2) == 0 && i2 < paddingLeft) {
            this.bFc.x = paddingLeft;
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int lastVisiblePosition = this.mListView.getLastVisiblePosition();
        int paddingTop = this.mListView.getPaddingTop();
        if (firstVisiblePosition < headerViewsCount) {
            paddingTop = this.mListView.getChildAt((headerViewsCount - firstVisiblePosition) - 1).getBottom();
        }
        if ((this.bFM & 8) == 0 && firstVisiblePosition <= this.bFm) {
            paddingTop = Math.max(this.mListView.getChildAt(this.bFm - firstVisiblePosition).getTop(), paddingTop);
        }
        int height = this.mListView.getHeight() - this.mListView.getPaddingBottom();
        if (lastVisiblePosition >= (this.mListView.getCount() - footerViewsCount) - 1) {
            height = this.mListView.getChildAt(((this.mListView.getCount() - footerViewsCount) - 1) - firstVisiblePosition).getBottom();
        }
        if ((this.bFM & 4) == 0 && lastVisiblePosition >= this.bFm) {
            height = Math.min(this.mListView.getChildAt(this.bFm - firstVisiblePosition).getBottom(), height);
        }
        if (i3 < paddingTop) {
            this.bFc.y = paddingTop;
        } else if (this.bFv + i3 > height) {
            this.bFc.y = height - this.bFv;
        }
        this.bFe = this.bFc.y + this.bFw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qd() {
        if (this.bFb != null) {
            this.bFb.setVisibility(8);
            if (this.bFP != null) {
                this.bFP.bn(this.bFb);
            }
            this.bFb = null;
            this.mListView.invalidate();
        }
    }

    public void a(h hVar) {
        this.bFP = hVar;
    }

    public void a(b bVar) {
        this.bFq = bVar;
    }

    public void setDragEnabled(boolean z) {
        this.bFt = z;
    }

    public boolean isDragEnabled() {
        return this.bFt;
    }

    public void a(g gVar) {
        this.bFr = gVar;
    }

    public void a(l lVar) {
        this.bFs = lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class i {
        private SparseIntArray bGA;
        private ArrayList<Integer> bGB;
        private int mMaxSize;

        public i(int i) {
            this.bGA = new SparseIntArray(i);
            this.bGB = new ArrayList<>(i);
            this.mMaxSize = i;
        }

        public void add(int i, int i2) {
            int i3 = this.bGA.get(i, -1);
            if (i3 != i2) {
                if (i3 == -1) {
                    if (this.bGA.size() == this.mMaxSize) {
                        this.bGA.delete(this.bGB.remove(0).intValue());
                    }
                } else {
                    this.bGB.remove(Integer.valueOf(i));
                }
                this.bGA.put(i, i2);
                this.bGB.add(Integer.valueOf(i));
            }
        }

        public int get(int i) {
            return this.bGA.get(i, -1);
        }

        public void clear() {
            this.bGA.clear();
            this.bGB.clear();
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
        private float bGL;
        private float bGM;
        private float bGN;
        private float bGO;
        private float bGP;
        private float mAlpha;
        private boolean mCanceled;
        protected long mStartTime;

        public m(float f, int i) {
            this.mAlpha = f;
            this.bGL = i;
            float f2 = 1.0f / ((this.mAlpha * 2.0f) * (1.0f - this.mAlpha));
            this.bGP = f2;
            this.bGM = f2;
            this.bGN = this.mAlpha / ((this.mAlpha - 1.0f) * 2.0f);
            this.bGO = 1.0f / (1.0f - this.mAlpha);
        }

        public float ab(float f) {
            if (f < this.mAlpha) {
                return this.bGM * f * f;
            }
            if (f < 1.0f - this.mAlpha) {
                return this.bGN + (this.bGO * f);
            }
            return 1.0f - ((this.bGP * (f - 1.0f)) * (f - 1.0f));
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
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / this.bGL;
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
        private int bGw;
        private int bGx;
        private float bGy;
        private float bGz;

        public f(float f, int i) {
            super(f, i);
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.bGw = a.this.bFi;
            this.bGx = a.this.bFm;
            a.this.mDragState = 2;
            this.bGy = a.this.bFc.y - Qh();
            this.bGz = a.this.bFc.x - a.this.mListView.getPaddingLeft();
        }

        private int Qh() {
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            int dividerHeight = (a.this.bFu + a.this.mListView.getDividerHeight()) / 2;
            View childAt = a.this.mListView.getChildAt(this.bGw - firstVisiblePosition);
            if (childAt != null) {
                if (this.bGw == this.bGx) {
                    return childAt.getTop();
                }
                if (this.bGw >= this.bGx) {
                    return (childAt.getBottom() + dividerHeight) - a.this.bFv;
                }
                return childAt.getTop() - dividerHeight;
            }
            cancel();
            return -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void n(float f, float f2) {
            int Qh = Qh();
            float paddingLeft = a.this.bFc.x - a.this.mListView.getPaddingLeft();
            float f3 = 1.0f - f2;
            if (f3 < Math.abs((a.this.bFc.y - Qh) / this.bGy) || f3 < Math.abs(paddingLeft / this.bGz)) {
                a.this.bFc.y = Qh + ((int) (this.bGy * f3));
                a.this.bFc.x = a.this.mListView.getPaddingLeft() + ((int) (this.bGz * f3));
                a.this.cH(true);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.PV();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class k extends m {
        private float bGE;
        private float bGF;
        private float bGG;
        private int bGH;
        private int bGI;
        private int bGJ;
        private int bGK;
        private int bGx;

        public k(float f, int i) {
            super(f, i);
            this.bGH = -1;
            this.bGI = -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.bGH = -1;
            this.bGI = -1;
            this.bGJ = a.this.bFj;
            this.bGK = a.this.bFk;
            this.bGx = a.this.bFm;
            a.this.mDragState = 1;
            this.bGE = a.this.bFc.x;
            if (a.this.bGc) {
                float width = a.this.mListView.getWidth() * 2.0f;
                if (a.this.bGd == 0.0f) {
                    a.this.bGd = (this.bGE >= 0.0f ? 1 : -1) * width;
                    return;
                }
                float f = width * 2.0f;
                if (a.this.bGd >= 0.0f || a.this.bGd <= (-f)) {
                    if (a.this.bGd > 0.0f && a.this.bGd < f) {
                        a.this.bGd = f;
                        return;
                    }
                    return;
                }
                a.this.bGd = -f;
                return;
            }
            a.this.Qd();
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void n(float f, float f2) {
            View childAt;
            float f3 = 1.0f - f2;
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            View childAt2 = a.this.mListView.getChildAt(this.bGJ - firstVisiblePosition);
            if (a.this.bGc) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / 1000.0f;
                if (uptimeMillis != 0.0f) {
                    float f4 = a.this.bGd * uptimeMillis;
                    int width = a.this.mListView.getWidth();
                    a.this.bGd = ((a.this.bGd > 0.0f ? 1 : -1) * uptimeMillis * width) + a.this.bGd;
                    this.bGE += f4;
                    a.this.bFc.x = (int) this.bGE;
                    if (this.bGE < width && this.bGE > (-width)) {
                        this.mStartTime = SystemClock.uptimeMillis();
                        a.this.cH(true);
                        return;
                    }
                } else {
                    return;
                }
            }
            if (childAt2 != null) {
                if (this.bGH == -1) {
                    this.bGH = a.this.f(this.bGJ, childAt2, false);
                    this.bGF = childAt2.getHeight() - this.bGH;
                }
                int max = Math.max((int) (this.bGF * f3), 1);
                ViewGroup.LayoutParams layoutParams = childAt2.getLayoutParams();
                layoutParams.height = max + this.bGH;
                childAt2.setLayoutParams(layoutParams);
            }
            if (this.bGK != this.bGJ && (childAt = a.this.mListView.getChildAt(this.bGK - firstVisiblePosition)) != null) {
                if (this.bGI == -1) {
                    this.bGI = a.this.f(this.bGK, childAt, false);
                    this.bGG = childAt.getHeight() - this.bGI;
                }
                int max2 = Math.max((int) (this.bGG * f3), 1);
                ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
                layoutParams2.height = max2 + this.bGI;
                childAt.setLayoutParams(layoutParams2);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.PW();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class j extends m {
        private float bGC;
        private float bGD;
        final /* synthetic */ a bGi;

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.bGC = this.bGi.bFo;
            this.bGD = this.bGi.bFw;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void n(float f, float f2) {
            if (this.bGi.mDragState != 4) {
                cancel();
                return;
            }
            this.bGi.bFo = (int) ((this.bGD * f2) + ((1.0f - f2) * this.bGC));
            this.bGi.bFc.y = this.bGi.bFK - this.bGi.bFo;
            this.bGi.cH(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e {
        StringBuilder mBuilder = new StringBuilder();
        private int bGt = 0;
        private int bGu = 0;
        private boolean bGv = false;
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
            this.bGu = 0;
            this.bGv = true;
        }

        public void Qg() {
            if (this.bGv) {
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
                this.mBuilder.append("    <FirstExpPos>").append(a.this.bFj).append("</FirstExpPos>\n");
                this.mBuilder.append("    <FirstExpBlankHeight>").append(a.this.iu(a.this.bFj) - a.this.iw(a.this.bFj)).append("</FirstExpBlankHeight>\n");
                this.mBuilder.append("    <SecondExpPos>").append(a.this.bFk).append("</SecondExpPos>\n");
                this.mBuilder.append("    <SecondExpBlankHeight>").append(a.this.iu(a.this.bFk) - a.this.iw(a.this.bFk)).append("</SecondExpBlankHeight>\n");
                this.mBuilder.append("    <SrcPos>").append(a.this.bFm).append("</SrcPos>\n");
                this.mBuilder.append("    <SrcHeight>").append(a.this.bFv + a.this.mListView.getDividerHeight()).append("</SrcHeight>\n");
                this.mBuilder.append("    <ViewHeight>").append(a.this.mListView.getHeight()).append("</ViewHeight>\n");
                this.mBuilder.append("    <LastY>").append(a.this.mLastY).append("</LastY>\n");
                this.mBuilder.append("    <FloatY>").append(a.this.bFe).append("</FloatY>\n");
                this.mBuilder.append("    <ShuffleEdges>");
                for (int i4 = 0; i4 < childCount; i4++) {
                    this.mBuilder.append(a.this.aO(firstVisiblePosition + i4, a.this.mListView.getChildAt(i4).getTop())).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                this.mBuilder.append("</ShuffleEdges>\n");
                this.mBuilder.append("</DSLVState>\n");
                this.bGt++;
                if (this.bGt > 1000) {
                    flush();
                    this.bGt = 0;
                }
            }
        }

        public void flush() {
            if (this.bGv) {
                try {
                    FileWriter fileWriter = new FileWriter(this.mFile, this.bGu != 0);
                    fileWriter.write(this.mBuilder.toString());
                    this.mBuilder.delete(0, this.mBuilder.length());
                    fileWriter.flush();
                    fileWriter.close();
                    this.bGu++;
                } catch (IOException e) {
                }
            }
        }

        public void sc() {
            if (this.bGv) {
                this.mBuilder.append("</DSLVStates>\n");
                flush();
                this.bGv = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements Runnable {
        private boolean bGl;
        private long bGm;
        private long bGn;
        private float bGo;
        private long bGp;
        private int bGq;
        private float bGr;
        private boolean bGs = false;
        private int dy;

        public boolean Qe() {
            return this.bGs;
        }

        public int Qf() {
            if (this.bGs) {
                return this.bGq;
            }
            return -1;
        }

        public d() {
        }

        public void ix(int i) {
            if (!this.bGs) {
                this.bGl = false;
                this.bGs = true;
                this.bGp = SystemClock.uptimeMillis();
                this.bGm = this.bGp;
                this.bGq = i;
                a.this.mListView.post(this);
            }
        }

        public void cI(boolean z) {
            if (z) {
                a.this.mListView.removeCallbacks(this);
                this.bGs = false;
                return;
            }
            this.bGl = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.bGl) {
                int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
                int lastVisiblePosition = a.this.mListView.getLastVisiblePosition();
                int count = a.this.mListView.getCount();
                int paddingTop = a.this.mListView.getPaddingTop();
                int height = (a.this.mListView.getHeight() - paddingTop) - a.this.mListView.getPaddingBottom();
                int min = Math.min(a.this.bFK, a.this.bFe + a.this.bFw);
                int max = Math.max(a.this.bFK, a.this.bFe - a.this.bFw);
                if (this.bGq == 0) {
                    View childAt = a.this.mListView.getChildAt(0);
                    if (childAt == null) {
                        this.bGs = false;
                        return;
                    } else if (firstVisiblePosition == 0 && childAt.getTop() == paddingTop) {
                        this.bGs = false;
                        return;
                    } else {
                        this.bGr = a.this.bFI.b((a.this.bFE - max) / a.this.bFF, this.bGm);
                    }
                } else {
                    View childAt2 = a.this.mListView.getChildAt(lastVisiblePosition - firstVisiblePosition);
                    if (childAt2 == null) {
                        this.bGs = false;
                        return;
                    } else if (lastVisiblePosition == count - 1 && childAt2.getBottom() <= height + paddingTop) {
                        this.bGs = false;
                        return;
                    } else {
                        this.bGr = -a.this.bFI.b((min - a.this.bFD) / a.this.bFG, this.bGm);
                    }
                }
                this.bGn = SystemClock.uptimeMillis();
                this.bGo = (float) (this.bGn - this.bGm);
                this.dy = Math.round(this.bGr * this.bGo);
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
                this.bGm = this.bGn;
                a.this.mListView.post(this);
                return;
            }
            this.bGs = false;
        }
    }
}
