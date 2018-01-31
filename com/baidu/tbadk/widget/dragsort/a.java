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
    private g bDA;
    private l bDB;
    private int bDE;
    private int bDF;
    private d bDH;
    private int bDK;
    private int bDL;
    private float bDM;
    private float bDN;
    private float bDO;
    private float bDP;
    private int bDS;
    private int bDT;
    private int bDU;
    private MotionEvent bDZ;
    private View bDk;
    private int bDn;
    private int bDr;
    private int bDs;
    private int bDt;
    private int bDv;
    private int bDw;
    private int bDx;
    private int bDy;
    private b bDz;
    private C0095a bEd;
    private e bEf;
    private k bEi;
    private j bEj;
    private f bEk;
    private boolean bEl;
    private com.baidu.tbadk.widget.dragsort.f bEn;
    private com.baidu.tbadk.widget.dragsort.b bEo;
    private int bcM;
    private int mLastX;
    private int mLastY;
    private ListView mListView;
    private Point bDl = new Point();
    private Point bDm = new Point();
    private boolean bDo = false;
    private float bDp = 1.0f;
    private float bDq = 1.0f;
    private boolean bDu = false;
    private boolean bDC = true;
    private int mDragState = 0;
    private int bDD = 1;
    private int mWidthMeasureSpec = 0;
    private View[] bDG = new View[1];
    private float bDI = 0.33333334f;
    private float bDJ = 0.33333334f;
    private float bDQ = 0.5f;
    private c bDR = new c() { // from class: com.baidu.tbadk.widget.dragsort.a.1
        @Override // com.baidu.tbadk.widget.dragsort.a.c
        public float b(float f2, long j2) {
            return a.this.bDQ * f2;
        }
    };
    private int bDV = 0;
    private boolean bDW = false;
    private boolean bDX = false;
    private h bDY = null;
    private int bEa = 0;
    private float bEb = 0.25f;
    private float bEc = 0.0f;
    private boolean bEe = false;
    private boolean mBlockLayoutRequests = false;
    private boolean bEg = false;
    private i bEh = new i(3);
    private float bEm = 0.0f;
    private boolean bEp = false;
    private boolean bEq = false;

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
        this.bEn = fVar;
        this.mListView = listView;
    }

    @Override // com.baidu.tbadk.widget.dragsort.e
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            this.bEd = new C0095a(listAdapter);
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
            this.bEd = null;
        }
        this.bEn.setAdapter(this.bEd);
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
            if (i2 > this.bDv) {
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
        int i4 = this.bDE - this.bDD;
        int iz = iz(i2);
        int ix = ix(i2);
        if (this.bDt <= this.bDv) {
            if (i2 == this.bDt && this.bDs != this.bDt) {
                if (i2 == this.bDv) {
                    i3 = (i3 + ix) - this.bDE;
                } else {
                    i3 = ((ix - iz) + i3) - i4;
                }
            } else if (i2 > this.bDt && i2 <= this.bDv) {
                i3 -= i4;
            }
        } else if (i2 > this.bDv && i2 <= this.bDs) {
            i3 += i4;
        } else if (i2 == this.bDt && this.bDs != this.bDt) {
            i3 += ix - iz;
        }
        if (i2 <= this.bDv) {
            return (((this.bDE - dividerHeight) - iz(i2 - 1)) / 2) + i3;
        }
        return (((iz - dividerHeight) - this.bDE) / 2) + i3;
    }

    private boolean Pp() {
        int i2;
        int i3;
        int i4;
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int i5 = this.bDs;
        View childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        if (childAt == null) {
            i5 = firstVisiblePosition + (this.mListView.getChildCount() / 2);
            childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        }
        int top = childAt.getTop();
        int height = childAt.getHeight();
        int aO = aO(i5, top);
        int dividerHeight = this.mListView.getDividerHeight();
        if (this.bDn >= aO) {
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
                    if (this.bDn < i2) {
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
                if (this.bDn >= i2) {
                    break;
                }
                i4 = i2;
            }
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int i9 = this.bDs;
        int i10 = this.bDt;
        float f2 = this.bEc;
        if (this.bDu) {
            int abs = Math.abs(i2 - i4);
            if (this.bDn >= i2) {
                int i11 = i4;
                i4 = i2;
                i2 = i11;
            }
            int i12 = (int) (abs * this.bEb * 0.5f);
            float f3 = i12;
            int i13 = i4 + i12;
            int i14 = i2 - i12;
            if (this.bDn < i13) {
                this.bDs = i3 - 1;
                this.bDt = i3;
                this.bEc = ((i13 - this.bDn) * 0.5f) / f3;
            } else if (this.bDn < i14) {
                this.bDs = i3;
                this.bDt = i3;
            } else {
                this.bDs = i3;
                this.bDt = i3 + 1;
                this.bEc = (1.0f + ((i2 - this.bDn) / f3)) * 0.5f;
            }
        } else {
            this.bDs = i3;
            this.bDt = i3;
        }
        if (this.bDs < headerViewsCount) {
            this.bDs = headerViewsCount;
            this.bDt = headerViewsCount;
            i3 = headerViewsCount;
        } else if (this.bDt >= this.mListView.getCount() - footerViewsCount) {
            i3 = (this.mListView.getCount() - footerViewsCount) - 1;
            this.bDs = i3;
            this.bDt = i3;
        }
        boolean z = (this.bDs == i9 && this.bDt == i10 && this.bEc == f2) ? false : true;
        if (i3 != this.bDr) {
            if (this.bDz != null) {
                this.bDz.drag(this.bDr - headerViewsCount, i3 - headerViewsCount);
            }
            this.bDr = i3;
            return true;
        }
        return z;
    }

    public void removeItem(int i2) {
        this.bEl = false;
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
            this.bDD = Math.max(1, obtainStyledAttributes.getDimensionPixelSize(d.l.DragSort_collapsed_height, 1));
            this.bEe = obtainStyledAttributes.getBoolean(d.l.DragSort_track_drag_sort, false);
            if (this.bEe) {
                this.bEf = new e();
            }
            this.bDp = obtainStyledAttributes.getFloat(d.l.DragSort_float_alpha, this.bDp);
            this.bDq = this.bDp;
            this.bDC = obtainStyledAttributes.getBoolean(d.l.DragSort_drag_enabled, this.bDC);
            this.bEb = Math.max(0.0f, Math.min(1.0f, 1.0f - obtainStyledAttributes.getFloat(d.l.DragSort_slide_shuffle_speed, 0.75f)));
            this.bDu = this.bEb > 0.0f;
            setDragScrollStart(obtainStyledAttributes.getFloat(d.l.DragSort_drag_scroll_start, this.bDI));
            this.bDQ = obtainStyledAttributes.getFloat(d.l.DragSort_max_drag_scroll_speed, this.bDQ);
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
                bVar.cG(z);
                bVar.cF(z2);
                bVar.setBackgroundColor(color);
                this.bDY = bVar;
                a(bVar);
            }
            obtainStyledAttributes.recycle();
            i2 = i5;
            i3 = i4;
        }
        this.bDH = new d();
        if (i3 > 0) {
            this.bEi = new k(0.5f, i3);
        }
        if (i2 > 0) {
            this.bEk = new f(0.5f, i2);
        }
        this.bDZ = MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
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
        this.bEo = bVar;
        this.mListView.setOnTouchListener(bVar);
    }

    @Override // com.baidu.tbadk.widget.dragsort.e
    public void dispatchDraw(Canvas canvas) {
        float f2;
        this.bEn.dispatchDraw(canvas);
        if (this.mDragState != 0) {
            if (this.bDs != this.bDv) {
                b(this.bDs, canvas);
            }
            if (this.bDt != this.bDs && this.bDt != this.bDv) {
                b(this.bDt, canvas);
            }
        }
        if (this.bDk != null) {
            int width = this.bDk.getWidth();
            int height = this.bDk.getHeight();
            int i2 = this.bDl.x;
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
            int i3 = (int) (f2 * 255.0f * this.bDq);
            canvas.save();
            canvas.translate(this.bDl.x, this.bDl.y);
            canvas.clipRect(0, 0, width, height);
            canvas.saveLayerAlpha(0.0f, 0.0f, width, height, i3, 31);
            this.bDk.draw(canvas);
            canvas.restore();
            canvas.restore();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.e
    public void onDraw(Canvas canvas) {
        this.bEn.onDraw(canvas);
        if (this.bEe) {
            this.bEf.PC();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.e
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.bEg) {
            this.bEg = false;
            return false;
        } else if (!this.bDC) {
            return this.bEn.onTouchEvent(motionEvent);
        } else {
            boolean z2 = this.bDW;
            this.bDW = false;
            if (!z2) {
                w(motionEvent);
            }
            if (this.mDragState == 4) {
                onDragTouchEvent(motionEvent);
                return true;
            }
            if (this.mDragState == 0 && this.bEn.onTouchEvent(motionEvent)) {
                z = true;
            }
            switch (motionEvent.getAction() & 255) {
                case 1:
                case 3:
                    Pu();
                    return z;
                case 2:
                default:
                    if (z) {
                        this.bEa = 1;
                        return z;
                    }
                    return z;
            }
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.e
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (!this.bDC) {
            return this.bEn.onInterceptTouchEvent(motionEvent);
        }
        if (this.bEo != null) {
            this.bEo.PE().onTouchEvent(motionEvent);
        }
        w(motionEvent);
        this.bDW = true;
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            if (this.mDragState != 0) {
                this.bEg = true;
                return true;
            }
            this.bDX = true;
        }
        if (this.bDk == null) {
            if (this.bEn.onInterceptTouchEvent(motionEvent)) {
                this.bEp = true;
                z = true;
            } else {
                z = false;
            }
            switch (action) {
                case 1:
                case 3:
                    Pu();
                    break;
                case 2:
                default:
                    if (z) {
                        this.bEa = 1;
                        break;
                    } else {
                        this.bEa = 2;
                        break;
                    }
            }
        } else {
            z = true;
        }
        if (action == 1 || action == 3) {
            this.bDX = false;
        }
        return z;
    }

    @Override // com.baidu.tbadk.widget.dragsort.e
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        this.bEn.onSizeChanged(i2, i3, i4, i5);
        Pv();
    }

    @Override // com.baidu.tbadk.widget.dragsort.e
    public void requestLayout() {
        if (!this.mBlockLayoutRequests) {
            this.bEn.requestLayout();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.e
    public void onMeasure(int i2, int i3) {
        this.bEn.onMeasure(i2, i3);
        if (this.bDk != null) {
            if (this.bDk.isLayoutRequested()) {
                Px();
            }
            this.bDo = true;
        }
        this.mWidthMeasureSpec = i2;
    }

    @Override // com.baidu.tbadk.widget.dragsort.e
    public void layoutChildren() {
        this.bEn.layoutChildren();
        if (this.bDk != null) {
            if (this.bDk.isLayoutRequested() && !this.bDo) {
                Px();
            }
            this.bDk.layout(0, 0, this.bDk.getMeasuredWidth(), this.bDk.getMeasuredHeight());
            this.bDo = false;
        }
    }

    public void removeItem(int i2, float f2) {
        if (this.mDragState == 0 || this.mDragState == 4) {
            if (this.mDragState == 0) {
                this.bDv = this.mListView.getHeaderViewsCount() + i2;
                this.bDs = this.bDv;
                this.bDt = this.bDv;
                this.bDr = this.bDv;
                View childAt = this.mListView.getChildAt(this.bDv - this.mListView.getFirstVisiblePosition());
                if (childAt != null) {
                    childAt.setVisibility(4);
                }
            }
            this.mDragState = 1;
            this.bEm = f2;
            if (this.bDX) {
                switch (this.bEa) {
                    case 1:
                        this.bEn.onTouchEvent(this.bDZ);
                        break;
                    case 2:
                        this.bEn.onInterceptTouchEvent(this.bDZ);
                        break;
                }
            }
            if (this.bEi != null) {
                this.bEi.start();
            } else {
                iy(i2);
            }
        }
    }

    public void cancelDrag() {
        if (this.mDragState == 4) {
            this.bDH.cE(true);
            Pz();
            Pq();
            Pw();
            if (this.bDX) {
                this.mDragState = 3;
            } else {
                this.mDragState = 0;
            }
        }
    }

    private void Pq() {
        this.bDv = -1;
        this.bDs = -1;
        this.bDt = -1;
        this.bDr = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pr() {
        this.mDragState = 2;
        if (this.bDA != null && this.bDr >= 0 && this.bDr < this.mListView.getCount()) {
            int headerViewsCount = this.mListView.getHeaderViewsCount();
            this.bDA.drop(this.bDv - headerViewsCount, this.bDr - headerViewsCount);
        }
        Pz();
        Pt();
        Pq();
        Pw();
        if (this.bDX) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ps() {
        iy(this.bDv - this.mListView.getHeaderViewsCount());
    }

    private void iy(int i2) {
        this.mDragState = 1;
        if (this.bDB != null) {
            this.bDB.remove(i2);
        }
        Pz();
        Pt();
        Pq();
        if (this.bDX) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    private void Pt() {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        if (this.bDv < firstVisiblePosition) {
            View childAt = this.mListView.getChildAt(0);
            this.mListView.setSelectionFromTop(firstVisiblePosition - 1, (childAt != null ? childAt.getTop() : 0) - this.mListView.getPaddingTop());
        }
    }

    public boolean stopDrag(boolean z) {
        this.bEl = false;
        return stopDrag(z, 0.0f);
    }

    public boolean stopDragWithVelocity(boolean z, float f2) {
        this.bEl = true;
        return stopDrag(z, f2);
    }

    public boolean stopDrag(boolean z, float f2) {
        if (this.bDk != null) {
            this.bDH.cE(true);
            if (z) {
                removeItem(this.bDv - this.mListView.getHeaderViewsCount(), f2);
            } else if (this.bEk != null) {
                this.bEk.start();
            } else {
                Pr();
            }
            if (this.bEe) {
                this.bEf.se();
                return true;
            }
            return true;
        }
        return false;
    }

    private void Pu() {
        this.bEa = 0;
        this.bDX = false;
        if (this.mDragState == 3) {
            this.mDragState = 0;
        }
        this.bDq = this.bDp;
        this.bEp = false;
        this.bEh.clear();
    }

    private void w(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            this.mLastX = this.bDS;
            this.mLastY = this.bDT;
        }
        this.bDS = (int) motionEvent.getX();
        this.bDT = (int) motionEvent.getY();
        if (action == 0) {
            this.mLastX = this.bDS;
            this.mLastY = this.bDT;
        }
        this.bDy = ((int) motionEvent.getRawX()) - this.bDS;
        this.bcM = ((int) motionEvent.getRawY()) - this.bDT;
    }

    public boolean listViewIntercepted() {
        return this.bEp;
    }

    public void setDragScrollStart(float f2) {
        setDragScrollStarts(f2, f2);
    }

    public void setDragScrollStarts(float f2, float f3) {
        if (f3 > 0.5f) {
            this.bDJ = 0.5f;
        } else {
            this.bDJ = f3;
        }
        if (f2 > 0.5f) {
            this.bDI = 0.5f;
        } else {
            this.bDI = f2;
        }
        if (this.mListView.getHeight() != 0) {
            Pv();
        }
    }

    private void aP(int i2, int i3) {
        this.bDl.x = i2 - this.bDw;
        this.bDl.y = i3 - this.bDx;
        cD(true);
        int min = Math.min(i3, this.bDn + this.bDF);
        int max = Math.max(i3, this.bDn - this.bDF);
        int PB = this.bDH.PB();
        if (min > this.mLastY && min > this.bDL && PB != 1) {
            if (PB != -1) {
                this.bDH.cE(true);
            }
            this.bDH.iA(1);
        } else if (max < this.mLastY && max < this.bDK && PB != 0) {
            if (PB != -1) {
                this.bDH.cE(true);
            }
            this.bDH.iA(0);
        } else if (max >= this.bDK && min <= this.bDL && this.bDH.PA()) {
            this.bDH.cE(true);
        }
    }

    private void Pv() {
        int height;
        int paddingTop = this.mListView.getPaddingTop();
        float height2 = (this.mListView.getHeight() - paddingTop) - this.mListView.getPaddingBottom();
        this.bDN = paddingTop + (this.bDI * height2);
        this.bDM = (height2 * (1.0f - this.bDJ)) + paddingTop;
        this.bDK = (int) this.bDN;
        this.bDL = (int) this.bDM;
        this.bDO = this.bDN - paddingTop;
        this.bDP = (paddingTop + height) - this.bDM;
    }

    private void Pw() {
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
        if (i2 != this.bDv && i2 != this.bDs && i2 != this.bDt) {
            g2 = -2;
        } else {
            g2 = g(i2, view, z);
        }
        if (g2 != layoutParams.height) {
            layoutParams.height = g2;
            view.setLayoutParams(layoutParams);
        }
        if (i2 == this.bDs || i2 == this.bDt) {
            if (i2 < this.bDv) {
                ((com.baidu.tbadk.widget.dragsort.c) view).setGravity(80);
            } else if (i2 > this.bDv) {
                ((com.baidu.tbadk.widget.dragsort.c) view).setGravity(48);
            }
        }
        int visibility = view.getVisibility();
        int i3 = 0;
        if (i2 == this.bDv && this.bDk != null) {
            i3 = 4;
        }
        if (i3 != visibility) {
            view.setVisibility(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int iz(int i2) {
        View view;
        if (i2 == this.bDv) {
            return 0;
        }
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        if (childAt != null) {
            return f(i2, childAt, false);
        }
        int i3 = this.bEh.get(i2);
        if (i3 == -1) {
            ListAdapter adapter = this.mListView.getAdapter();
            int itemViewType = adapter.getItemViewType(i2);
            int viewTypeCount = adapter.getViewTypeCount();
            if (viewTypeCount != this.bDG.length) {
                this.bDG = new View[viewTypeCount];
            }
            if (itemViewType >= 0) {
                if (this.bDG[itemViewType] == null) {
                    view = adapter.getView(i2, null, this.mListView);
                    this.bDG[itemViewType] = view;
                } else {
                    view = adapter.getView(i2, this.bDG[itemViewType], this.mListView);
                }
            } else {
                view = adapter.getView(i2, null, this.mListView);
            }
            int f2 = f(i2, view, true);
            this.bEh.add(i2, f2);
            return f2;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(int i2, View view, boolean z) {
        if (i2 == this.bDv) {
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
        boolean z = this.bDu && this.bDs != this.bDt;
        int i4 = this.bDE - this.bDD;
        int i5 = (int) (this.bEc * i4);
        if (i2 == this.bDv) {
            if (this.bDv == this.bDs) {
                if (z) {
                    return i5 + this.bDD;
                }
                return this.bDE;
            } else if (this.bDv == this.bDt) {
                return this.bDE - i5;
            } else {
                return this.bDD;
            }
        } else if (i2 == this.bDs) {
            if (z) {
                return i3 + i5;
            }
            return i3 + i4;
        } else if (i2 == this.bDt) {
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
        if (i2 != this.bDv) {
            i6 = height - iz;
            i5 = aQ - iz;
        } else {
            i5 = aQ;
            i6 = height;
        }
        int i7 = this.bDE;
        if (this.bDv != this.bDs && this.bDv != this.bDt) {
            i7 -= this.bDD;
        }
        if (i2 <= i3) {
            if (i2 > this.bDs) {
                return (i7 - i5) + 0;
            }
        } else if (i2 == i4) {
            if (i2 <= this.bDs) {
                return (i6 - i7) + 0;
            }
            if (i2 == this.bDt) {
                return (height - aQ) + 0;
            }
            return 0 + i6;
        } else if (i2 <= this.bDs) {
            return 0 - i7;
        } else {
            if (i2 == this.bDt) {
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

    private void Px() {
        if (this.bDk != null) {
            measureItem(this.bDk);
            this.bDE = this.bDk.getMeasuredHeight();
            this.bDF = this.bDE / 2;
        }
    }

    protected boolean onDragTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        switch (motionEvent.getAction() & 255) {
            case 1:
                if (this.mDragState == 4) {
                    stopDrag(false);
                }
                Pu();
                return true;
            case 2:
                aP((int) motionEvent.getX(), (int) motionEvent.getY());
                return true;
            case 3:
                if (this.mDragState == 4) {
                    cancelDrag();
                }
                Pu();
                return true;
            default:
                return true;
        }
    }

    public boolean startDrag(int i2, int i3, int i4, int i5) {
        View iB;
        if (!this.bDX || this.bDY == null || (iB = this.bDY.iB(i2)) == null) {
            return false;
        }
        return startDrag(i2, iB, i3, i4, i5);
    }

    public boolean startDrag(int i2, View view, int i3, int i4, int i5) {
        if (this.mDragState == 0 && this.bDX && this.bDk == null && view != null && this.bDC) {
            if (this.mListView.getParent() != null) {
                this.mListView.getParent().requestDisallowInterceptTouchEvent(true);
            }
            int headerViewsCount = this.mListView.getHeaderViewsCount() + i2;
            this.bDs = headerViewsCount;
            this.bDt = headerViewsCount;
            this.bDv = headerViewsCount;
            this.bDr = headerViewsCount;
            this.mDragState = 4;
            this.bDV = 0;
            this.bDV |= i3;
            this.bDk = view;
            Px();
            this.bDw = i4;
            this.bDx = i5;
            this.bDU = this.bDT;
            this.bDl.x = this.bDS - this.bDw;
            this.bDl.y = this.bDT - this.bDx;
            View childAt = this.mListView.getChildAt(this.bDv - this.mListView.getFirstVisiblePosition());
            if (childAt != null) {
                childAt.setVisibility(4);
            }
            if (this.bEe) {
                this.bEf.startTracking();
            }
            switch (this.bEa) {
                case 1:
                    this.bEn.onTouchEvent(this.bDZ);
                    break;
                case 2:
                    this.bEn.onInterceptTouchEvent(this.bDZ);
                    break;
            }
            this.mListView.requestLayout();
            if (this.bEj != null) {
                this.bEj.start();
                return true;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cD(boolean z) {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition() + (this.mListView.getChildCount() / 2);
        View childAt = this.mListView.getChildAt(this.mListView.getChildCount() / 2);
        if (childAt != null) {
            h(firstVisiblePosition, childAt, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i2, View view, boolean z) {
        this.mBlockLayoutRequests = true;
        Py();
        int i3 = this.bDs;
        int i4 = this.bDt;
        boolean Pp = Pp();
        if (Pp) {
            Pw();
            this.mListView.setSelectionFromTop(i2, (b(i2, view, i3, i4) + view.getTop()) - this.mListView.getPaddingTop());
            layoutChildren();
        }
        if (Pp || z) {
            this.mListView.invalidate();
        }
        this.mBlockLayoutRequests = false;
    }

    private void Py() {
        if (this.bDY != null) {
            this.bDm.set(this.bDS, this.bDT);
            this.bDY.b(this.bDk, this.bDl, this.bDm);
        }
        int i2 = this.bDl.x;
        int i3 = this.bDl.y;
        int paddingLeft = this.mListView.getPaddingLeft();
        if ((this.bDV & 1) == 0 && i2 > paddingLeft) {
            this.bDl.x = paddingLeft;
        } else if ((this.bDV & 2) == 0 && i2 < paddingLeft) {
            this.bDl.x = paddingLeft;
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int lastVisiblePosition = this.mListView.getLastVisiblePosition();
        int paddingTop = this.mListView.getPaddingTop();
        if (firstVisiblePosition < headerViewsCount) {
            paddingTop = this.mListView.getChildAt((headerViewsCount - firstVisiblePosition) - 1).getBottom();
        }
        if ((this.bDV & 8) == 0 && firstVisiblePosition <= this.bDv) {
            paddingTop = Math.max(this.mListView.getChildAt(this.bDv - firstVisiblePosition).getTop(), paddingTop);
        }
        int height = this.mListView.getHeight() - this.mListView.getPaddingBottom();
        if (lastVisiblePosition >= (this.mListView.getCount() - footerViewsCount) - 1) {
            height = this.mListView.getChildAt(((this.mListView.getCount() - footerViewsCount) - 1) - firstVisiblePosition).getBottom();
        }
        if ((this.bDV & 4) == 0 && lastVisiblePosition >= this.bDv) {
            height = Math.min(this.mListView.getChildAt(this.bDv - firstVisiblePosition).getBottom(), height);
        }
        if (i3 < paddingTop) {
            this.bDl.y = paddingTop;
        } else if (this.bDE + i3 > height) {
            this.bDl.y = height - this.bDE;
        }
        this.bDn = this.bDl.y + this.bDF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pz() {
        if (this.bDk != null) {
            this.bDk.setVisibility(8);
            if (this.bDY != null) {
                this.bDY.bn(this.bDk);
            }
            this.bDk = null;
            this.mListView.invalidate();
        }
    }

    public void a(h hVar) {
        this.bDY = hVar;
    }

    public void a(b bVar) {
        this.bDz = bVar;
    }

    public void setDragEnabled(boolean z) {
        this.bDC = z;
    }

    public boolean isDragEnabled() {
        return this.bDC;
    }

    public void a(g gVar) {
        this.bDA = gVar;
    }

    public void a(l lVar) {
        this.bDB = lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class i {
        private SparseIntArray bEJ;
        private ArrayList<Integer> bEK;
        private int mMaxSize;

        public i(int i) {
            this.bEJ = new SparseIntArray(i);
            this.bEK = new ArrayList<>(i);
            this.mMaxSize = i;
        }

        public void add(int i, int i2) {
            int i3 = this.bEJ.get(i, -1);
            if (i3 != i2) {
                if (i3 == -1) {
                    if (this.bEJ.size() == this.mMaxSize) {
                        this.bEJ.delete(this.bEK.remove(0).intValue());
                    }
                } else {
                    this.bEK.remove(Integer.valueOf(i));
                }
                this.bEJ.put(i, i2);
                this.bEK.add(Integer.valueOf(i));
            }
        }

        public int get(int i) {
            return this.bEJ.get(i, -1);
        }

        public void clear() {
            this.bEJ.clear();
            this.bEK.clear();
        }
    }

    /* renamed from: com.baidu.tbadk.widget.dragsort.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0095a extends BaseAdapter {
        private ListAdapter mAdapter;

        public C0095a(ListAdapter listAdapter) {
            this.mAdapter = listAdapter;
            this.mAdapter.registerDataSetObserver(new DataSetObserver() { // from class: com.baidu.tbadk.widget.dragsort.a.a.1
                @Override // android.database.DataSetObserver
                public void onChanged() {
                    C0095a.this.notifyDataSetChanged();
                }

                @Override // android.database.DataSetObserver
                public void onInvalidated() {
                    C0095a.this.notifyDataSetInvalidated();
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
        private float bEU;
        private float bEV;
        private float bEW;
        private float bEX;
        private float bEY;
        private float mAlpha;
        private boolean mCanceled;
        protected long mStartTime;

        public m(float f, int i) {
            this.mAlpha = f;
            this.bEU = i;
            float f2 = 1.0f / ((this.mAlpha * 2.0f) * (1.0f - this.mAlpha));
            this.bEY = f2;
            this.bEV = f2;
            this.bEW = this.mAlpha / ((this.mAlpha - 1.0f) * 2.0f);
            this.bEX = 1.0f / (1.0f - this.mAlpha);
        }

        public float V(float f) {
            if (f < this.mAlpha) {
                return this.bEV * f * f;
            }
            if (f < 1.0f - this.mAlpha) {
                return this.bEW + (this.bEX * f);
            }
            return 1.0f - ((this.bEY * (f - 1.0f)) * (f - 1.0f));
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
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / this.bEU;
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
        private int bEF;
        private int bEG;
        private float bEH;
        private float bEI;

        public f(float f, int i) {
            super(f, i);
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.bEF = a.this.bDr;
            this.bEG = a.this.bDv;
            a.this.mDragState = 2;
            this.bEH = a.this.bDl.y - PD();
            this.bEI = a.this.bDl.x - a.this.mListView.getPaddingLeft();
        }

        private int PD() {
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            int dividerHeight = (a.this.bDD + a.this.mListView.getDividerHeight()) / 2;
            View childAt = a.this.mListView.getChildAt(this.bEF - firstVisiblePosition);
            if (childAt != null) {
                if (this.bEF == this.bEG) {
                    return childAt.getTop();
                }
                if (this.bEF >= this.bEG) {
                    return (childAt.getBottom() + dividerHeight) - a.this.bDE;
                }
                return childAt.getTop() - dividerHeight;
            }
            cancel();
            return -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void n(float f, float f2) {
            int PD = PD();
            float paddingLeft = a.this.bDl.x - a.this.mListView.getPaddingLeft();
            float f3 = 1.0f - f2;
            if (f3 < Math.abs((a.this.bDl.y - PD) / this.bEH) || f3 < Math.abs(paddingLeft / this.bEI)) {
                a.this.bDl.y = PD + ((int) (this.bEH * f3));
                a.this.bDl.x = a.this.mListView.getPaddingLeft() + ((int) (this.bEI * f3));
                a.this.cD(true);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.Pr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class k extends m {
        private int bEG;
        private float bEN;
        private float bEO;
        private float bEP;
        private int bEQ;
        private int bER;
        private int bES;
        private int bET;

        public k(float f, int i) {
            super(f, i);
            this.bEQ = -1;
            this.bER = -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.bEQ = -1;
            this.bER = -1;
            this.bES = a.this.bDs;
            this.bET = a.this.bDt;
            this.bEG = a.this.bDv;
            a.this.mDragState = 1;
            this.bEN = a.this.bDl.x;
            if (a.this.bEl) {
                float width = a.this.mListView.getWidth() * 2.0f;
                if (a.this.bEm == 0.0f) {
                    a.this.bEm = (this.bEN >= 0.0f ? 1 : -1) * width;
                    return;
                }
                float f = width * 2.0f;
                if (a.this.bEm >= 0.0f || a.this.bEm <= (-f)) {
                    if (a.this.bEm > 0.0f && a.this.bEm < f) {
                        a.this.bEm = f;
                        return;
                    }
                    return;
                }
                a.this.bEm = -f;
                return;
            }
            a.this.Pz();
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void n(float f, float f2) {
            View childAt;
            float f3 = 1.0f - f2;
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            View childAt2 = a.this.mListView.getChildAt(this.bES - firstVisiblePosition);
            if (a.this.bEl) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / 1000.0f;
                if (uptimeMillis != 0.0f) {
                    float f4 = a.this.bEm * uptimeMillis;
                    int width = a.this.mListView.getWidth();
                    a.this.bEm = ((a.this.bEm > 0.0f ? 1 : -1) * uptimeMillis * width) + a.this.bEm;
                    this.bEN += f4;
                    a.this.bDl.x = (int) this.bEN;
                    if (this.bEN < width && this.bEN > (-width)) {
                        this.mStartTime = SystemClock.uptimeMillis();
                        a.this.cD(true);
                        return;
                    }
                } else {
                    return;
                }
            }
            if (childAt2 != null) {
                if (this.bEQ == -1) {
                    this.bEQ = a.this.f(this.bES, childAt2, false);
                    this.bEO = childAt2.getHeight() - this.bEQ;
                }
                int max = Math.max((int) (this.bEO * f3), 1);
                ViewGroup.LayoutParams layoutParams = childAt2.getLayoutParams();
                layoutParams.height = max + this.bEQ;
                childAt2.setLayoutParams(layoutParams);
            }
            if (this.bET != this.bES && (childAt = a.this.mListView.getChildAt(this.bET - firstVisiblePosition)) != null) {
                if (this.bER == -1) {
                    this.bER = a.this.f(this.bET, childAt, false);
                    this.bEP = childAt.getHeight() - this.bER;
                }
                int max2 = Math.max((int) (this.bEP * f3), 1);
                ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
                layoutParams2.height = max2 + this.bER;
                childAt.setLayoutParams(layoutParams2);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.Ps();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class j extends m {
        private float bEL;
        private float bEM;
        final /* synthetic */ a bEr;

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.bEL = this.bEr.bDx;
            this.bEM = this.bEr.bDF;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void n(float f, float f2) {
            if (this.bEr.mDragState != 4) {
                cancel();
                return;
            }
            this.bEr.bDx = (int) ((this.bEM * f2) + ((1.0f - f2) * this.bEL));
            this.bEr.bDl.y = this.bEr.bDT - this.bEr.bDx;
            this.bEr.cD(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e {
        StringBuilder mBuilder = new StringBuilder();
        private int bEC = 0;
        private int bED = 0;
        private boolean bEE = false;
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
            this.bED = 0;
            this.bEE = true;
        }

        public void PC() {
            if (this.bEE) {
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
                this.mBuilder.append("    <FirstExpPos>").append(a.this.bDs).append("</FirstExpPos>\n");
                this.mBuilder.append("    <FirstExpBlankHeight>").append(a.this.ix(a.this.bDs) - a.this.iz(a.this.bDs)).append("</FirstExpBlankHeight>\n");
                this.mBuilder.append("    <SecondExpPos>").append(a.this.bDt).append("</SecondExpPos>\n");
                this.mBuilder.append("    <SecondExpBlankHeight>").append(a.this.ix(a.this.bDt) - a.this.iz(a.this.bDt)).append("</SecondExpBlankHeight>\n");
                this.mBuilder.append("    <SrcPos>").append(a.this.bDv).append("</SrcPos>\n");
                this.mBuilder.append("    <SrcHeight>").append(a.this.bDE + a.this.mListView.getDividerHeight()).append("</SrcHeight>\n");
                this.mBuilder.append("    <ViewHeight>").append(a.this.mListView.getHeight()).append("</ViewHeight>\n");
                this.mBuilder.append("    <LastY>").append(a.this.mLastY).append("</LastY>\n");
                this.mBuilder.append("    <FloatY>").append(a.this.bDn).append("</FloatY>\n");
                this.mBuilder.append("    <ShuffleEdges>");
                for (int i4 = 0; i4 < childCount; i4++) {
                    this.mBuilder.append(a.this.aO(firstVisiblePosition + i4, a.this.mListView.getChildAt(i4).getTop())).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                this.mBuilder.append("</ShuffleEdges>\n");
                this.mBuilder.append("</DSLVState>\n");
                this.bEC++;
                if (this.bEC > 1000) {
                    flush();
                    this.bEC = 0;
                }
            }
        }

        public void flush() {
            if (this.bEE) {
                try {
                    FileWriter fileWriter = new FileWriter(this.mFile, this.bED != 0);
                    fileWriter.write(this.mBuilder.toString());
                    this.mBuilder.delete(0, this.mBuilder.length());
                    fileWriter.flush();
                    fileWriter.close();
                    this.bED++;
                } catch (IOException e) {
                }
            }
        }

        public void se() {
            if (this.bEE) {
                this.mBuilder.append("</DSLVStates>\n");
                flush();
                this.bEE = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements Runnable {
        private float bEA;
        private boolean bEB = false;
        private boolean bEu;
        private long bEv;
        private long bEw;
        private float bEx;
        private long bEy;
        private int bEz;
        private int dy;

        public boolean PA() {
            return this.bEB;
        }

        public int PB() {
            if (this.bEB) {
                return this.bEz;
            }
            return -1;
        }

        public d() {
        }

        public void iA(int i) {
            if (!this.bEB) {
                this.bEu = false;
                this.bEB = true;
                this.bEy = SystemClock.uptimeMillis();
                this.bEv = this.bEy;
                this.bEz = i;
                a.this.mListView.post(this);
            }
        }

        public void cE(boolean z) {
            if (z) {
                a.this.mListView.removeCallbacks(this);
                this.bEB = false;
                return;
            }
            this.bEu = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.bEu) {
                int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
                int lastVisiblePosition = a.this.mListView.getLastVisiblePosition();
                int count = a.this.mListView.getCount();
                int paddingTop = a.this.mListView.getPaddingTop();
                int height = (a.this.mListView.getHeight() - paddingTop) - a.this.mListView.getPaddingBottom();
                int min = Math.min(a.this.bDT, a.this.bDn + a.this.bDF);
                int max = Math.max(a.this.bDT, a.this.bDn - a.this.bDF);
                if (this.bEz == 0) {
                    View childAt = a.this.mListView.getChildAt(0);
                    if (childAt == null) {
                        this.bEB = false;
                        return;
                    } else if (firstVisiblePosition == 0 && childAt.getTop() == paddingTop) {
                        this.bEB = false;
                        return;
                    } else {
                        this.bEA = a.this.bDR.b((a.this.bDN - max) / a.this.bDO, this.bEv);
                    }
                } else {
                    View childAt2 = a.this.mListView.getChildAt(lastVisiblePosition - firstVisiblePosition);
                    if (childAt2 == null) {
                        this.bEB = false;
                        return;
                    } else if (lastVisiblePosition == count - 1 && childAt2.getBottom() <= height + paddingTop) {
                        this.bEB = false;
                        return;
                    } else {
                        this.bEA = -a.this.bDR.b((min - a.this.bDM) / a.this.bDP, this.bEv);
                    }
                }
                this.bEw = SystemClock.uptimeMillis();
                this.bEx = (float) (this.bEw - this.bEv);
                this.dy = Math.round(this.bEA * this.bEx);
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
                this.bEv = this.bEw;
                a.this.mListView.post(this);
                return;
            }
            this.bEB = false;
        }
    }
}
