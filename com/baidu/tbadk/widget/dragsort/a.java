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
    private DataSetObserver Qz;
    private int bDC;
    private int bDD;
    private float bDE;
    private float bDF;
    private float bDG;
    private float bDH;
    private int bDK;
    private int bDL;
    private int bDM;
    private MotionEvent bDR;
    private C0094a bDV;
    private e bDX;
    private View bDc;
    private int bDf;
    private int bDj;
    private int bDk;
    private int bDl;
    private int bDn;
    private int bDo;
    private int bDp;
    private int bDq;
    private b bDr;
    private g bDs;
    private l bDt;
    private int bDw;
    private int bDx;
    private d bDz;
    private k bEa;
    private j bEb;
    private f bEc;
    private boolean bEd;
    private com.baidu.tbadk.widget.dragsort.f bEf;
    private com.baidu.tbadk.widget.dragsort.b bEg;
    private int bcE;
    private int mLastX;
    private int mLastY;
    private ListView mListView;
    private Point bDd = new Point();
    private Point bDe = new Point();
    private boolean bDg = false;
    private float bDh = 1.0f;
    private float bDi = 1.0f;
    private boolean bDm = false;
    private boolean bDu = true;
    private int mDragState = 0;
    private int bDv = 1;
    private int mWidthMeasureSpec = 0;
    private View[] bDy = new View[1];
    private float bDA = 0.33333334f;
    private float bDB = 0.33333334f;
    private float bDI = 0.5f;
    private c bDJ = new c() { // from class: com.baidu.tbadk.widget.dragsort.a.1
        @Override // com.baidu.tbadk.widget.dragsort.a.c
        public float b(float f2, long j2) {
            return a.this.bDI * f2;
        }
    };
    private int bDN = 0;
    private boolean bDO = false;
    private boolean bDP = false;
    private h bDQ = null;
    private int bDS = 0;
    private float bDT = 0.25f;
    private float bDU = 0.0f;
    private boolean bDW = false;
    private boolean mBlockLayoutRequests = false;
    private boolean bDY = false;
    private i bDZ = new i(3);
    private float bEe = 0.0f;
    private boolean bEh = false;
    private boolean bEi = false;

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

        View iB(int i);
    }

    /* loaded from: classes.dex */
    public interface l {
        void remove(int i);
    }

    public a(ListView listView, com.baidu.tbadk.widget.dragsort.f fVar) {
        this.bEf = fVar;
        this.mListView = listView;
    }

    @Override // com.baidu.tbadk.widget.dragsort.e
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            this.bDV = new C0094a(listAdapter);
            listAdapter.registerDataSetObserver(this.Qz);
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
            this.bDV = null;
        }
        this.bEf.setAdapter(this.bDV);
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
            if (i2 > this.bDn) {
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
    public int ix(int i2) {
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        return childAt != null ? childAt.getHeight() : aQ(i2, iz(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aO(int i2, int i3) {
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        if (i2 <= headerViewsCount || i2 >= this.mListView.getCount() - footerViewsCount) {
            return i3;
        }
        int dividerHeight = this.mListView.getDividerHeight();
        int i4 = this.bDw - this.bDv;
        int iz = iz(i2);
        int ix = ix(i2);
        if (this.bDl <= this.bDn) {
            if (i2 == this.bDl && this.bDk != this.bDl) {
                if (i2 == this.bDn) {
                    i3 = (i3 + ix) - this.bDw;
                } else {
                    i3 = ((ix - iz) + i3) - i4;
                }
            } else if (i2 > this.bDl && i2 <= this.bDn) {
                i3 -= i4;
            }
        } else if (i2 > this.bDn && i2 <= this.bDk) {
            i3 += i4;
        } else if (i2 == this.bDl && this.bDk != this.bDl) {
            i3 += ix - iz;
        }
        if (i2 <= this.bDn) {
            return (((this.bDw - dividerHeight) - iz(i2 - 1)) / 2) + i3;
        }
        return (((iz - dividerHeight) - this.bDw) / 2) + i3;
    }

    private boolean Pn() {
        int i2;
        int i3;
        int i4;
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int i5 = this.bDk;
        View childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        if (childAt == null) {
            i5 = firstVisiblePosition + (this.mListView.getChildCount() / 2);
            childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        }
        int top = childAt.getTop();
        int height = childAt.getHeight();
        int aO = aO(i5, top);
        int dividerHeight = this.mListView.getDividerHeight();
        if (this.bDf >= aO) {
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
                    i6 = ix(i3 + 1);
                    i2 = aO(i3 + 1, i7);
                    if (this.bDf < i2) {
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
                int ix = ix(i3);
                if (i3 == 0) {
                    i2 = (i8 - dividerHeight) - ix;
                    break;
                }
                i8 -= ix + dividerHeight;
                i2 = aO(i3, i8);
                if (this.bDf >= i2) {
                    break;
                }
                i4 = i2;
            }
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int i9 = this.bDk;
        int i10 = this.bDl;
        float f2 = this.bDU;
        if (this.bDm) {
            int abs = Math.abs(i2 - i4);
            if (this.bDf >= i2) {
                int i11 = i4;
                i4 = i2;
                i2 = i11;
            }
            int i12 = (int) (abs * this.bDT * 0.5f);
            float f3 = i12;
            int i13 = i4 + i12;
            int i14 = i2 - i12;
            if (this.bDf < i13) {
                this.bDk = i3 - 1;
                this.bDl = i3;
                this.bDU = ((i13 - this.bDf) * 0.5f) / f3;
            } else if (this.bDf < i14) {
                this.bDk = i3;
                this.bDl = i3;
            } else {
                this.bDk = i3;
                this.bDl = i3 + 1;
                this.bDU = (1.0f + ((i2 - this.bDf) / f3)) * 0.5f;
            }
        } else {
            this.bDk = i3;
            this.bDl = i3;
        }
        if (this.bDk < headerViewsCount) {
            this.bDk = headerViewsCount;
            this.bDl = headerViewsCount;
            i3 = headerViewsCount;
        } else if (this.bDl >= this.mListView.getCount() - footerViewsCount) {
            i3 = (this.mListView.getCount() - footerViewsCount) - 1;
            this.bDk = i3;
            this.bDl = i3;
        }
        boolean z = (this.bDk == i9 && this.bDl == i10 && this.bDU == f2) ? false : true;
        if (i3 != this.bDj) {
            if (this.bDr != null) {
                this.bDr.drag(this.bDj - headerViewsCount, i3 - headerViewsCount);
            }
            this.bDj = i3;
            return true;
        }
        return z;
    }

    public void removeItem(int i2) {
        this.bEd = false;
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
            this.bDv = Math.max(1, obtainStyledAttributes.getDimensionPixelSize(d.l.DragSort_collapsed_height, 1));
            this.bDW = obtainStyledAttributes.getBoolean(d.l.DragSort_track_drag_sort, false);
            if (this.bDW) {
                this.bDX = new e();
            }
            this.bDh = obtainStyledAttributes.getFloat(d.l.DragSort_float_alpha, this.bDh);
            this.bDi = this.bDh;
            this.bDu = obtainStyledAttributes.getBoolean(d.l.DragSort_drag_enabled, this.bDu);
            this.bDT = Math.max(0.0f, Math.min(1.0f, 1.0f - obtainStyledAttributes.getFloat(d.l.DragSort_slide_shuffle_speed, 0.75f)));
            this.bDm = this.bDT > 0.0f;
            setDragScrollStart(obtainStyledAttributes.getFloat(d.l.DragSort_drag_scroll_start, this.bDA));
            this.bDI = obtainStyledAttributes.getFloat(d.l.DragSort_max_drag_scroll_speed, this.bDI);
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
                bVar.cF(z);
                bVar.cE(z2);
                bVar.setBackgroundColor(color);
                this.bDQ = bVar;
                a(bVar);
            }
            obtainStyledAttributes.recycle();
            i2 = i5;
            i3 = i4;
        }
        this.bDz = new d();
        if (i3 > 0) {
            this.bEa = new k(0.5f, i3);
        }
        if (i2 > 0) {
            this.bEc = new f(0.5f, i2);
        }
        this.bDR = MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        this.Qz = new DataSetObserver() { // from class: com.baidu.tbadk.widget.dragsort.a.2
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
        this.bEg = bVar;
        this.mListView.setOnTouchListener(bVar);
    }

    @Override // com.baidu.tbadk.widget.dragsort.e
    public void dispatchDraw(Canvas canvas) {
        float f2;
        this.bEf.dispatchDraw(canvas);
        if (this.mDragState != 0) {
            if (this.bDk != this.bDn) {
                b(this.bDk, canvas);
            }
            if (this.bDl != this.bDk && this.bDl != this.bDn) {
                b(this.bDl, canvas);
            }
        }
        if (this.bDc != null) {
            int width = this.bDc.getWidth();
            int height = this.bDc.getHeight();
            int i2 = this.bDd.x;
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
            int i3 = (int) (f2 * 255.0f * this.bDi);
            canvas.save();
            canvas.translate(this.bDd.x, this.bDd.y);
            canvas.clipRect(0, 0, width, height);
            canvas.saveLayerAlpha(0.0f, 0.0f, width, height, i3, 31);
            this.bDc.draw(canvas);
            canvas.restore();
            canvas.restore();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.e
    public void onDraw(Canvas canvas) {
        this.bEf.onDraw(canvas);
        if (this.bDW) {
            this.bDX.PA();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.e
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.bDY) {
            this.bDY = false;
            return false;
        } else if (!this.bDu) {
            return this.bEf.onTouchEvent(motionEvent);
        } else {
            boolean z2 = this.bDO;
            this.bDO = false;
            if (!z2) {
                w(motionEvent);
            }
            if (this.mDragState == 4) {
                onDragTouchEvent(motionEvent);
                return true;
            }
            if (this.mDragState == 0 && this.bEf.onTouchEvent(motionEvent)) {
                z = true;
            }
            switch (motionEvent.getAction() & 255) {
                case 1:
                case 3:
                    Ps();
                    return z;
                case 2:
                default:
                    if (z) {
                        this.bDS = 1;
                        return z;
                    }
                    return z;
            }
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.e
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (!this.bDu) {
            return this.bEf.onInterceptTouchEvent(motionEvent);
        }
        if (this.bEg != null) {
            this.bEg.PC().onTouchEvent(motionEvent);
        }
        w(motionEvent);
        this.bDO = true;
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            if (this.mDragState != 0) {
                this.bDY = true;
                return true;
            }
            this.bDP = true;
        }
        if (this.bDc == null) {
            if (this.bEf.onInterceptTouchEvent(motionEvent)) {
                this.bEh = true;
                z = true;
            } else {
                z = false;
            }
            switch (action) {
                case 1:
                case 3:
                    Ps();
                    break;
                case 2:
                default:
                    if (z) {
                        this.bDS = 1;
                        break;
                    } else {
                        this.bDS = 2;
                        break;
                    }
            }
        } else {
            z = true;
        }
        if (action == 1 || action == 3) {
            this.bDP = false;
        }
        return z;
    }

    @Override // com.baidu.tbadk.widget.dragsort.e
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        this.bEf.onSizeChanged(i2, i3, i4, i5);
        Pt();
    }

    @Override // com.baidu.tbadk.widget.dragsort.e
    public void requestLayout() {
        if (!this.mBlockLayoutRequests) {
            this.bEf.requestLayout();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.e
    public void onMeasure(int i2, int i3) {
        this.bEf.onMeasure(i2, i3);
        if (this.bDc != null) {
            if (this.bDc.isLayoutRequested()) {
                Pv();
            }
            this.bDg = true;
        }
        this.mWidthMeasureSpec = i2;
    }

    @Override // com.baidu.tbadk.widget.dragsort.e
    public void layoutChildren() {
        this.bEf.layoutChildren();
        if (this.bDc != null) {
            if (this.bDc.isLayoutRequested() && !this.bDg) {
                Pv();
            }
            this.bDc.layout(0, 0, this.bDc.getMeasuredWidth(), this.bDc.getMeasuredHeight());
            this.bDg = false;
        }
    }

    public void removeItem(int i2, float f2) {
        if (this.mDragState == 0 || this.mDragState == 4) {
            if (this.mDragState == 0) {
                this.bDn = this.mListView.getHeaderViewsCount() + i2;
                this.bDk = this.bDn;
                this.bDl = this.bDn;
                this.bDj = this.bDn;
                View childAt = this.mListView.getChildAt(this.bDn - this.mListView.getFirstVisiblePosition());
                if (childAt != null) {
                    childAt.setVisibility(4);
                }
            }
            this.mDragState = 1;
            this.bEe = f2;
            if (this.bDP) {
                switch (this.bDS) {
                    case 1:
                        this.bEf.onTouchEvent(this.bDR);
                        break;
                    case 2:
                        this.bEf.onInterceptTouchEvent(this.bDR);
                        break;
                }
            }
            if (this.bEa != null) {
                this.bEa.start();
            } else {
                iy(i2);
            }
        }
    }

    public void cancelDrag() {
        if (this.mDragState == 4) {
            this.bDz.cD(true);
            Px();
            Po();
            Pu();
            if (this.bDP) {
                this.mDragState = 3;
            } else {
                this.mDragState = 0;
            }
        }
    }

    private void Po() {
        this.bDn = -1;
        this.bDk = -1;
        this.bDl = -1;
        this.bDj = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pp() {
        this.mDragState = 2;
        if (this.bDs != null && this.bDj >= 0 && this.bDj < this.mListView.getCount()) {
            int headerViewsCount = this.mListView.getHeaderViewsCount();
            this.bDs.drop(this.bDn - headerViewsCount, this.bDj - headerViewsCount);
        }
        Px();
        Pr();
        Po();
        Pu();
        if (this.bDP) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pq() {
        iy(this.bDn - this.mListView.getHeaderViewsCount());
    }

    private void iy(int i2) {
        this.mDragState = 1;
        if (this.bDt != null) {
            this.bDt.remove(i2);
        }
        Px();
        Pr();
        Po();
        if (this.bDP) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    private void Pr() {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        if (this.bDn < firstVisiblePosition) {
            View childAt = this.mListView.getChildAt(0);
            this.mListView.setSelectionFromTop(firstVisiblePosition - 1, (childAt != null ? childAt.getTop() : 0) - this.mListView.getPaddingTop());
        }
    }

    public boolean stopDrag(boolean z) {
        this.bEd = false;
        return stopDrag(z, 0.0f);
    }

    public boolean stopDragWithVelocity(boolean z, float f2) {
        this.bEd = true;
        return stopDrag(z, f2);
    }

    public boolean stopDrag(boolean z, float f2) {
        if (this.bDc != null) {
            this.bDz.cD(true);
            if (z) {
                removeItem(this.bDn - this.mListView.getHeaderViewsCount(), f2);
            } else if (this.bEc != null) {
                this.bEc.start();
            } else {
                Pp();
            }
            if (this.bDW) {
                this.bDX.sd();
                return true;
            }
            return true;
        }
        return false;
    }

    private void Ps() {
        this.bDS = 0;
        this.bDP = false;
        if (this.mDragState == 3) {
            this.mDragState = 0;
        }
        this.bDi = this.bDh;
        this.bEh = false;
        this.bDZ.clear();
    }

    private void w(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            this.mLastX = this.bDK;
            this.mLastY = this.bDL;
        }
        this.bDK = (int) motionEvent.getX();
        this.bDL = (int) motionEvent.getY();
        if (action == 0) {
            this.mLastX = this.bDK;
            this.mLastY = this.bDL;
        }
        this.bDq = ((int) motionEvent.getRawX()) - this.bDK;
        this.bcE = ((int) motionEvent.getRawY()) - this.bDL;
    }

    public boolean listViewIntercepted() {
        return this.bEh;
    }

    public void setDragScrollStart(float f2) {
        setDragScrollStarts(f2, f2);
    }

    public void setDragScrollStarts(float f2, float f3) {
        if (f3 > 0.5f) {
            this.bDB = 0.5f;
        } else {
            this.bDB = f3;
        }
        if (f2 > 0.5f) {
            this.bDA = 0.5f;
        } else {
            this.bDA = f2;
        }
        if (this.mListView.getHeight() != 0) {
            Pt();
        }
    }

    private void aP(int i2, int i3) {
        this.bDd.x = i2 - this.bDo;
        this.bDd.y = i3 - this.bDp;
        cC(true);
        int min = Math.min(i3, this.bDf + this.bDx);
        int max = Math.max(i3, this.bDf - this.bDx);
        int Pz = this.bDz.Pz();
        if (min > this.mLastY && min > this.bDD && Pz != 1) {
            if (Pz != -1) {
                this.bDz.cD(true);
            }
            this.bDz.iA(1);
        } else if (max < this.mLastY && max < this.bDC && Pz != 0) {
            if (Pz != -1) {
                this.bDz.cD(true);
            }
            this.bDz.iA(0);
        } else if (max >= this.bDC && min <= this.bDD && this.bDz.Py()) {
            this.bDz.cD(true);
        }
    }

    private void Pt() {
        int height;
        int paddingTop = this.mListView.getPaddingTop();
        float height2 = (this.mListView.getHeight() - paddingTop) - this.mListView.getPaddingBottom();
        this.bDF = paddingTop + (this.bDA * height2);
        this.bDE = (height2 * (1.0f - this.bDB)) + paddingTop;
        this.bDC = (int) this.bDF;
        this.bDD = (int) this.bDE;
        this.bDG = this.bDF - paddingTop;
        this.bDH = (paddingTop + height) - this.bDE;
    }

    private void Pu() {
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
        if (i2 != this.bDn && i2 != this.bDk && i2 != this.bDl) {
            g2 = -2;
        } else {
            g2 = g(i2, view, z);
        }
        if (g2 != layoutParams.height) {
            layoutParams.height = g2;
            view.setLayoutParams(layoutParams);
        }
        if (i2 == this.bDk || i2 == this.bDl) {
            if (i2 < this.bDn) {
                ((com.baidu.tbadk.widget.dragsort.c) view).setGravity(80);
            } else if (i2 > this.bDn) {
                ((com.baidu.tbadk.widget.dragsort.c) view).setGravity(48);
            }
        }
        int visibility = view.getVisibility();
        int i3 = 0;
        if (i2 == this.bDn && this.bDc != null) {
            i3 = 4;
        }
        if (i3 != visibility) {
            view.setVisibility(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int iz(int i2) {
        View view;
        if (i2 == this.bDn) {
            return 0;
        }
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        if (childAt != null) {
            return f(i2, childAt, false);
        }
        int i3 = this.bDZ.get(i2);
        if (i3 == -1) {
            ListAdapter adapter = this.mListView.getAdapter();
            int itemViewType = adapter.getItemViewType(i2);
            int viewTypeCount = adapter.getViewTypeCount();
            if (viewTypeCount != this.bDy.length) {
                this.bDy = new View[viewTypeCount];
            }
            if (itemViewType >= 0) {
                if (this.bDy[itemViewType] == null) {
                    view = adapter.getView(i2, null, this.mListView);
                    this.bDy[itemViewType] = view;
                } else {
                    view = adapter.getView(i2, this.bDy[itemViewType], this.mListView);
                }
            } else {
                view = adapter.getView(i2, null, this.mListView);
            }
            int f2 = f(i2, view, true);
            this.bDZ.add(i2, f2);
            return f2;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(int i2, View view, boolean z) {
        if (i2 == this.bDn) {
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
        boolean z = this.bDm && this.bDk != this.bDl;
        int i4 = this.bDw - this.bDv;
        int i5 = (int) (this.bDU * i4);
        if (i2 == this.bDn) {
            if (this.bDn == this.bDk) {
                if (z) {
                    return i5 + this.bDv;
                }
                return this.bDw;
            } else if (this.bDn == this.bDl) {
                return this.bDw - i5;
            } else {
                return this.bDv;
            }
        } else if (i2 == this.bDk) {
            if (z) {
                return i3 + i5;
            }
            return i3 + i4;
        } else if (i2 == this.bDl) {
            return (i3 + i4) - i5;
        } else {
            return i3;
        }
    }

    private int b(int i2, View view, int i3, int i4) {
        int i5;
        int i6;
        int iz = iz(i2);
        int height = view.getHeight();
        int aQ = aQ(i2, iz);
        if (i2 != this.bDn) {
            i6 = height - iz;
            i5 = aQ - iz;
        } else {
            i5 = aQ;
            i6 = height;
        }
        int i7 = this.bDw;
        if (this.bDn != this.bDk && this.bDn != this.bDl) {
            i7 -= this.bDv;
        }
        if (i2 <= i3) {
            if (i2 > this.bDk) {
                return (i7 - i5) + 0;
            }
        } else if (i2 == i4) {
            if (i2 <= this.bDk) {
                return (i6 - i7) + 0;
            }
            if (i2 == this.bDl) {
                return (height - aQ) + 0;
            }
            return 0 + i6;
        } else if (i2 <= this.bDk) {
            return 0 - i7;
        } else {
            if (i2 == this.bDl) {
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

    private void Pv() {
        if (this.bDc != null) {
            measureItem(this.bDc);
            this.bDw = this.bDc.getMeasuredHeight();
            this.bDx = this.bDw / 2;
        }
    }

    protected boolean onDragTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        switch (motionEvent.getAction() & 255) {
            case 1:
                if (this.mDragState == 4) {
                    stopDrag(false);
                }
                Ps();
                return true;
            case 2:
                aP((int) motionEvent.getX(), (int) motionEvent.getY());
                return true;
            case 3:
                if (this.mDragState == 4) {
                    cancelDrag();
                }
                Ps();
                return true;
            default:
                return true;
        }
    }

    public boolean startDrag(int i2, int i3, int i4, int i5) {
        View iB;
        if (!this.bDP || this.bDQ == null || (iB = this.bDQ.iB(i2)) == null) {
            return false;
        }
        return startDrag(i2, iB, i3, i4, i5);
    }

    public boolean startDrag(int i2, View view, int i3, int i4, int i5) {
        if (this.mDragState == 0 && this.bDP && this.bDc == null && view != null && this.bDu) {
            if (this.mListView.getParent() != null) {
                this.mListView.getParent().requestDisallowInterceptTouchEvent(true);
            }
            int headerViewsCount = this.mListView.getHeaderViewsCount() + i2;
            this.bDk = headerViewsCount;
            this.bDl = headerViewsCount;
            this.bDn = headerViewsCount;
            this.bDj = headerViewsCount;
            this.mDragState = 4;
            this.bDN = 0;
            this.bDN |= i3;
            this.bDc = view;
            Pv();
            this.bDo = i4;
            this.bDp = i5;
            this.bDM = this.bDL;
            this.bDd.x = this.bDK - this.bDo;
            this.bDd.y = this.bDL - this.bDp;
            View childAt = this.mListView.getChildAt(this.bDn - this.mListView.getFirstVisiblePosition());
            if (childAt != null) {
                childAt.setVisibility(4);
            }
            if (this.bDW) {
                this.bDX.startTracking();
            }
            switch (this.bDS) {
                case 1:
                    this.bEf.onTouchEvent(this.bDR);
                    break;
                case 2:
                    this.bEf.onInterceptTouchEvent(this.bDR);
                    break;
            }
            this.mListView.requestLayout();
            if (this.bEb != null) {
                this.bEb.start();
                return true;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cC(boolean z) {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition() + (this.mListView.getChildCount() / 2);
        View childAt = this.mListView.getChildAt(this.mListView.getChildCount() / 2);
        if (childAt != null) {
            h(firstVisiblePosition, childAt, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i2, View view, boolean z) {
        this.mBlockLayoutRequests = true;
        Pw();
        int i3 = this.bDk;
        int i4 = this.bDl;
        boolean Pn = Pn();
        if (Pn) {
            Pu();
            this.mListView.setSelectionFromTop(i2, (b(i2, view, i3, i4) + view.getTop()) - this.mListView.getPaddingTop());
            layoutChildren();
        }
        if (Pn || z) {
            this.mListView.invalidate();
        }
        this.mBlockLayoutRequests = false;
    }

    private void Pw() {
        if (this.bDQ != null) {
            this.bDe.set(this.bDK, this.bDL);
            this.bDQ.b(this.bDc, this.bDd, this.bDe);
        }
        int i2 = this.bDd.x;
        int i3 = this.bDd.y;
        int paddingLeft = this.mListView.getPaddingLeft();
        if ((this.bDN & 1) == 0 && i2 > paddingLeft) {
            this.bDd.x = paddingLeft;
        } else if ((this.bDN & 2) == 0 && i2 < paddingLeft) {
            this.bDd.x = paddingLeft;
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int lastVisiblePosition = this.mListView.getLastVisiblePosition();
        int paddingTop = this.mListView.getPaddingTop();
        if (firstVisiblePosition < headerViewsCount) {
            paddingTop = this.mListView.getChildAt((headerViewsCount - firstVisiblePosition) - 1).getBottom();
        }
        if ((this.bDN & 8) == 0 && firstVisiblePosition <= this.bDn) {
            paddingTop = Math.max(this.mListView.getChildAt(this.bDn - firstVisiblePosition).getTop(), paddingTop);
        }
        int height = this.mListView.getHeight() - this.mListView.getPaddingBottom();
        if (lastVisiblePosition >= (this.mListView.getCount() - footerViewsCount) - 1) {
            height = this.mListView.getChildAt(((this.mListView.getCount() - footerViewsCount) - 1) - firstVisiblePosition).getBottom();
        }
        if ((this.bDN & 4) == 0 && lastVisiblePosition >= this.bDn) {
            height = Math.min(this.mListView.getChildAt(this.bDn - firstVisiblePosition).getBottom(), height);
        }
        if (i3 < paddingTop) {
            this.bDd.y = paddingTop;
        } else if (this.bDw + i3 > height) {
            this.bDd.y = height - this.bDw;
        }
        this.bDf = this.bDd.y + this.bDx;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Px() {
        if (this.bDc != null) {
            this.bDc.setVisibility(8);
            if (this.bDQ != null) {
                this.bDQ.bn(this.bDc);
            }
            this.bDc = null;
            this.mListView.invalidate();
        }
    }

    public void a(h hVar) {
        this.bDQ = hVar;
    }

    public void a(b bVar) {
        this.bDr = bVar;
    }

    public void setDragEnabled(boolean z) {
        this.bDu = z;
    }

    public boolean isDragEnabled() {
        return this.bDu;
    }

    public void a(g gVar) {
        this.bDs = gVar;
    }

    public void a(l lVar) {
        this.bDt = lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class i {
        private SparseIntArray bEB;
        private ArrayList<Integer> bEC;
        private int mMaxSize;

        public i(int i) {
            this.bEB = new SparseIntArray(i);
            this.bEC = new ArrayList<>(i);
            this.mMaxSize = i;
        }

        public void add(int i, int i2) {
            int i3 = this.bEB.get(i, -1);
            if (i3 != i2) {
                if (i3 == -1) {
                    if (this.bEB.size() == this.mMaxSize) {
                        this.bEB.delete(this.bEC.remove(0).intValue());
                    }
                } else {
                    this.bEC.remove(Integer.valueOf(i));
                }
                this.bEB.put(i, i2);
                this.bEC.add(Integer.valueOf(i));
            }
        }

        public int get(int i) {
            return this.bEB.get(i, -1);
        }

        public void clear() {
            this.bEB.clear();
            this.bEC.clear();
        }
    }

    /* renamed from: com.baidu.tbadk.widget.dragsort.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0094a extends BaseAdapter {
        private ListAdapter mAdapter;

        public C0094a(ListAdapter listAdapter) {
            this.mAdapter = listAdapter;
            this.mAdapter.registerDataSetObserver(new DataSetObserver() { // from class: com.baidu.tbadk.widget.dragsort.a.a.1
                @Override // android.database.DataSetObserver
                public void onChanged() {
                    C0094a.this.notifyDataSetChanged();
                }

                @Override // android.database.DataSetObserver
                public void onInvalidated() {
                    C0094a.this.notifyDataSetInvalidated();
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
        private float bEM;
        private float bEN;
        private float bEO;
        private float bEP;
        private float bEQ;
        private float mAlpha;
        private boolean mCanceled;
        protected long mStartTime;

        public m(float f, int i) {
            this.mAlpha = f;
            this.bEM = i;
            float f2 = 1.0f / ((this.mAlpha * 2.0f) * (1.0f - this.mAlpha));
            this.bEQ = f2;
            this.bEN = f2;
            this.bEO = this.mAlpha / ((this.mAlpha - 1.0f) * 2.0f);
            this.bEP = 1.0f / (1.0f - this.mAlpha);
        }

        public float V(float f) {
            if (f < this.mAlpha) {
                return this.bEN * f * f;
            }
            if (f < 1.0f - this.mAlpha) {
                return this.bEO + (this.bEP * f);
            }
            return 1.0f - ((this.bEQ * (f - 1.0f)) * (f - 1.0f));
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
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / this.bEM;
                if (uptimeMillis >= 1.0f) {
                    n(1.0f, 1.0f);
                    onStop();
                    return;
                }
                n(uptimeMillis, V(uptimeMillis));
                a.this.mListView.post(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class f extends m {
        private float bEA;
        private int bEx;
        private int bEy;
        private float bEz;

        public f(float f, int i) {
            super(f, i);
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.bEx = a.this.bDj;
            this.bEy = a.this.bDn;
            a.this.mDragState = 2;
            this.bEz = a.this.bDd.y - PB();
            this.bEA = a.this.bDd.x - a.this.mListView.getPaddingLeft();
        }

        private int PB() {
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            int dividerHeight = (a.this.bDv + a.this.mListView.getDividerHeight()) / 2;
            View childAt = a.this.mListView.getChildAt(this.bEx - firstVisiblePosition);
            if (childAt != null) {
                if (this.bEx == this.bEy) {
                    return childAt.getTop();
                }
                if (this.bEx >= this.bEy) {
                    return (childAt.getBottom() + dividerHeight) - a.this.bDw;
                }
                return childAt.getTop() - dividerHeight;
            }
            cancel();
            return -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void n(float f, float f2) {
            int PB = PB();
            float paddingLeft = a.this.bDd.x - a.this.mListView.getPaddingLeft();
            float f3 = 1.0f - f2;
            if (f3 < Math.abs((a.this.bDd.y - PB) / this.bEz) || f3 < Math.abs(paddingLeft / this.bEA)) {
                a.this.bDd.y = PB + ((int) (this.bEz * f3));
                a.this.bDd.x = a.this.mListView.getPaddingLeft() + ((int) (this.bEA * f3));
                a.this.cC(true);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.Pp();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class k extends m {
        private float bEF;
        private float bEG;
        private float bEH;
        private int bEI;
        private int bEJ;
        private int bEK;
        private int bEL;
        private int bEy;

        public k(float f, int i) {
            super(f, i);
            this.bEI = -1;
            this.bEJ = -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.bEI = -1;
            this.bEJ = -1;
            this.bEK = a.this.bDk;
            this.bEL = a.this.bDl;
            this.bEy = a.this.bDn;
            a.this.mDragState = 1;
            this.bEF = a.this.bDd.x;
            if (a.this.bEd) {
                float width = a.this.mListView.getWidth() * 2.0f;
                if (a.this.bEe == 0.0f) {
                    a.this.bEe = (this.bEF >= 0.0f ? 1 : -1) * width;
                    return;
                }
                float f = width * 2.0f;
                if (a.this.bEe >= 0.0f || a.this.bEe <= (-f)) {
                    if (a.this.bEe > 0.0f && a.this.bEe < f) {
                        a.this.bEe = f;
                        return;
                    }
                    return;
                }
                a.this.bEe = -f;
                return;
            }
            a.this.Px();
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void n(float f, float f2) {
            View childAt;
            float f3 = 1.0f - f2;
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            View childAt2 = a.this.mListView.getChildAt(this.bEK - firstVisiblePosition);
            if (a.this.bEd) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / 1000.0f;
                if (uptimeMillis != 0.0f) {
                    float f4 = a.this.bEe * uptimeMillis;
                    int width = a.this.mListView.getWidth();
                    a.this.bEe = ((a.this.bEe > 0.0f ? 1 : -1) * uptimeMillis * width) + a.this.bEe;
                    this.bEF += f4;
                    a.this.bDd.x = (int) this.bEF;
                    if (this.bEF < width && this.bEF > (-width)) {
                        this.mStartTime = SystemClock.uptimeMillis();
                        a.this.cC(true);
                        return;
                    }
                } else {
                    return;
                }
            }
            if (childAt2 != null) {
                if (this.bEI == -1) {
                    this.bEI = a.this.f(this.bEK, childAt2, false);
                    this.bEG = childAt2.getHeight() - this.bEI;
                }
                int max = Math.max((int) (this.bEG * f3), 1);
                ViewGroup.LayoutParams layoutParams = childAt2.getLayoutParams();
                layoutParams.height = max + this.bEI;
                childAt2.setLayoutParams(layoutParams);
            }
            if (this.bEL != this.bEK && (childAt = a.this.mListView.getChildAt(this.bEL - firstVisiblePosition)) != null) {
                if (this.bEJ == -1) {
                    this.bEJ = a.this.f(this.bEL, childAt, false);
                    this.bEH = childAt.getHeight() - this.bEJ;
                }
                int max2 = Math.max((int) (this.bEH * f3), 1);
                ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
                layoutParams2.height = max2 + this.bEJ;
                childAt.setLayoutParams(layoutParams2);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.Pq();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class j extends m {
        private float bED;
        private float bEE;
        final /* synthetic */ a bEj;

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.bED = this.bEj.bDp;
            this.bEE = this.bEj.bDx;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void n(float f, float f2) {
            if (this.bEj.mDragState != 4) {
                cancel();
                return;
            }
            this.bEj.bDp = (int) ((this.bEE * f2) + ((1.0f - f2) * this.bED));
            this.bEj.bDd.y = this.bEj.bDL - this.bEj.bDp;
            this.bEj.cC(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e {
        StringBuilder mBuilder = new StringBuilder();
        private int bEu = 0;
        private int bEv = 0;
        private boolean bEw = false;
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
            this.bEv = 0;
            this.bEw = true;
        }

        public void PA() {
            if (this.bEw) {
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
                this.mBuilder.append("    <FirstExpPos>").append(a.this.bDk).append("</FirstExpPos>\n");
                this.mBuilder.append("    <FirstExpBlankHeight>").append(a.this.ix(a.this.bDk) - a.this.iz(a.this.bDk)).append("</FirstExpBlankHeight>\n");
                this.mBuilder.append("    <SecondExpPos>").append(a.this.bDl).append("</SecondExpPos>\n");
                this.mBuilder.append("    <SecondExpBlankHeight>").append(a.this.ix(a.this.bDl) - a.this.iz(a.this.bDl)).append("</SecondExpBlankHeight>\n");
                this.mBuilder.append("    <SrcPos>").append(a.this.bDn).append("</SrcPos>\n");
                this.mBuilder.append("    <SrcHeight>").append(a.this.bDw + a.this.mListView.getDividerHeight()).append("</SrcHeight>\n");
                this.mBuilder.append("    <ViewHeight>").append(a.this.mListView.getHeight()).append("</ViewHeight>\n");
                this.mBuilder.append("    <LastY>").append(a.this.mLastY).append("</LastY>\n");
                this.mBuilder.append("    <FloatY>").append(a.this.bDf).append("</FloatY>\n");
                this.mBuilder.append("    <ShuffleEdges>");
                for (int i4 = 0; i4 < childCount; i4++) {
                    this.mBuilder.append(a.this.aO(firstVisiblePosition + i4, a.this.mListView.getChildAt(i4).getTop())).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                this.mBuilder.append("</ShuffleEdges>\n");
                this.mBuilder.append("</DSLVState>\n");
                this.bEu++;
                if (this.bEu > 1000) {
                    flush();
                    this.bEu = 0;
                }
            }
        }

        public void flush() {
            if (this.bEw) {
                try {
                    FileWriter fileWriter = new FileWriter(this.mFile, this.bEv != 0);
                    fileWriter.write(this.mBuilder.toString());
                    this.mBuilder.delete(0, this.mBuilder.length());
                    fileWriter.flush();
                    fileWriter.close();
                    this.bEv++;
                } catch (IOException e) {
                }
            }
        }

        public void sd() {
            if (this.bEw) {
                this.mBuilder.append("</DSLVStates>\n");
                flush();
                this.bEw = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements Runnable {
        private boolean bEm;
        private long bEn;
        private long bEo;
        private float bEp;
        private long bEq;
        private int bEr;
        private float bEs;
        private boolean bEt = false;
        private int dy;

        public boolean Py() {
            return this.bEt;
        }

        public int Pz() {
            if (this.bEt) {
                return this.bEr;
            }
            return -1;
        }

        public d() {
        }

        public void iA(int i) {
            if (!this.bEt) {
                this.bEm = false;
                this.bEt = true;
                this.bEq = SystemClock.uptimeMillis();
                this.bEn = this.bEq;
                this.bEr = i;
                a.this.mListView.post(this);
            }
        }

        public void cD(boolean z) {
            if (z) {
                a.this.mListView.removeCallbacks(this);
                this.bEt = false;
                return;
            }
            this.bEm = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.bEm) {
                int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
                int lastVisiblePosition = a.this.mListView.getLastVisiblePosition();
                int count = a.this.mListView.getCount();
                int paddingTop = a.this.mListView.getPaddingTop();
                int height = (a.this.mListView.getHeight() - paddingTop) - a.this.mListView.getPaddingBottom();
                int min = Math.min(a.this.bDL, a.this.bDf + a.this.bDx);
                int max = Math.max(a.this.bDL, a.this.bDf - a.this.bDx);
                if (this.bEr == 0) {
                    View childAt = a.this.mListView.getChildAt(0);
                    if (childAt == null) {
                        this.bEt = false;
                        return;
                    } else if (firstVisiblePosition == 0 && childAt.getTop() == paddingTop) {
                        this.bEt = false;
                        return;
                    } else {
                        this.bEs = a.this.bDJ.b((a.this.bDF - max) / a.this.bDG, this.bEn);
                    }
                } else {
                    View childAt2 = a.this.mListView.getChildAt(lastVisiblePosition - firstVisiblePosition);
                    if (childAt2 == null) {
                        this.bEt = false;
                        return;
                    } else if (lastVisiblePosition == count - 1 && childAt2.getBottom() <= height + paddingTop) {
                        this.bEt = false;
                        return;
                    } else {
                        this.bEs = -a.this.bDJ.b((min - a.this.bDE) / a.this.bDH, this.bEn);
                    }
                }
                this.bEo = SystemClock.uptimeMillis();
                this.bEp = (float) (this.bEo - this.bEn);
                this.dy = Math.round(this.bEs * this.bEp);
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
                this.bEn = this.bEo;
                a.this.mListView.post(this);
                return;
            }
            this.bEt = false;
        }
    }
}
