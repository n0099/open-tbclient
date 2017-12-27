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
    private View bCT;
    private int bCW;
    private int bDC;
    private int bDD;
    private int bDE;
    private MotionEvent bDJ;
    private C0095a bDN;
    private e bDP;
    private k bDS;
    private j bDT;
    private f bDU;
    private boolean bDV;
    private com.baidu.tbadk.widget.dragsort.f bDX;
    private com.baidu.tbadk.widget.dragsort.b bDY;
    private int bDa;
    private int bDb;
    private int bDc;
    private int bDe;
    private int bDf;
    private int bDg;
    private int bDh;
    private int bDi;
    private b bDj;
    private g bDk;
    private l bDl;
    private int bDo;
    private int bDp;
    private d bDr;
    private int bDu;
    private int bDv;
    private float bDw;
    private float bDx;
    private float bDy;
    private float bDz;
    private int mLastX;
    private int mLastY;
    private ListView mListView;
    private Point bCU = new Point();
    private Point bCV = new Point();
    private boolean bCX = false;
    private float bCY = 1.0f;
    private float bCZ = 1.0f;
    private boolean bDd = false;
    private boolean bDm = true;
    private int mDragState = 0;
    private int bDn = 1;
    private int mWidthMeasureSpec = 0;
    private View[] bDq = new View[1];
    private float bDs = 0.33333334f;
    private float bDt = 0.33333334f;
    private float bDA = 0.5f;
    private c bDB = new c() { // from class: com.baidu.tbadk.widget.dragsort.a.1
        @Override // com.baidu.tbadk.widget.dragsort.a.c
        public float b(float f2, long j2) {
            return a.this.bDA * f2;
        }
    };
    private int bDF = 0;
    private boolean bDG = false;
    private boolean bDH = false;
    private h bDI = null;
    private int bDK = 0;
    private float bDL = 0.25f;
    private float bDM = 0.0f;
    private boolean bDO = false;
    private boolean mBlockLayoutRequests = false;
    private boolean bDQ = false;
    private i bDR = new i(3);
    private float bDW = 0.0f;
    private boolean bDZ = false;
    private boolean bEa = false;

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

        void bl(View view);

        View iF(int i);
    }

    /* loaded from: classes.dex */
    public interface l {
        void remove(int i);
    }

    public a(ListView listView, com.baidu.tbadk.widget.dragsort.f fVar) {
        this.bDX = fVar;
        this.mListView = listView;
    }

    @Override // com.baidu.tbadk.widget.dragsort.e
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            this.bDN = new C0095a(listAdapter);
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
            this.bDN = null;
        }
        this.bDX.setAdapter(this.bDN);
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
            if (i2 > this.bDe) {
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
    public int iB(int i2) {
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        return childAt != null ? childAt.getHeight() : aQ(i2, iD(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aO(int i2, int i3) {
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        if (i2 <= headerViewsCount || i2 >= this.mListView.getCount() - footerViewsCount) {
            return i3;
        }
        int dividerHeight = this.mListView.getDividerHeight();
        int i4 = this.bDo - this.bDn;
        int iD = iD(i2);
        int iB = iB(i2);
        if (this.bDc <= this.bDe) {
            if (i2 == this.bDc && this.bDb != this.bDc) {
                if (i2 == this.bDe) {
                    i3 = (i3 + iB) - this.bDo;
                } else {
                    i3 = ((iB - iD) + i3) - i4;
                }
            } else if (i2 > this.bDc && i2 <= this.bDe) {
                i3 -= i4;
            }
        } else if (i2 > this.bDe && i2 <= this.bDb) {
            i3 += i4;
        } else if (i2 == this.bDc && this.bDb != this.bDc) {
            i3 += iB - iD;
        }
        if (i2 <= this.bDe) {
            return (((this.bDo - dividerHeight) - iD(i2 - 1)) / 2) + i3;
        }
        return (((iD - dividerHeight) - this.bDo) / 2) + i3;
    }

    private boolean Pz() {
        int i2;
        int i3;
        int i4;
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int i5 = this.bDb;
        View childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        if (childAt == null) {
            i5 = firstVisiblePosition + (this.mListView.getChildCount() / 2);
            childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        }
        int top = childAt.getTop();
        int height = childAt.getHeight();
        int aO = aO(i5, top);
        int dividerHeight = this.mListView.getDividerHeight();
        if (this.bCW >= aO) {
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
                    i6 = iB(i3 + 1);
                    i2 = aO(i3 + 1, i7);
                    if (this.bCW < i2) {
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
                int iB = iB(i3);
                if (i3 == 0) {
                    i2 = (i8 - dividerHeight) - iB;
                    break;
                }
                i8 -= iB + dividerHeight;
                i2 = aO(i3, i8);
                if (this.bCW >= i2) {
                    break;
                }
                i4 = i2;
            }
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int i9 = this.bDb;
        int i10 = this.bDc;
        float f2 = this.bDM;
        if (this.bDd) {
            int abs = Math.abs(i2 - i4);
            if (this.bCW >= i2) {
                int i11 = i4;
                i4 = i2;
                i2 = i11;
            }
            int i12 = (int) (abs * this.bDL * 0.5f);
            float f3 = i12;
            int i13 = i4 + i12;
            int i14 = i2 - i12;
            if (this.bCW < i13) {
                this.bDb = i3 - 1;
                this.bDc = i3;
                this.bDM = ((i13 - this.bCW) * 0.5f) / f3;
            } else if (this.bCW < i14) {
                this.bDb = i3;
                this.bDc = i3;
            } else {
                this.bDb = i3;
                this.bDc = i3 + 1;
                this.bDM = (1.0f + ((i2 - this.bCW) / f3)) * 0.5f;
            }
        } else {
            this.bDb = i3;
            this.bDc = i3;
        }
        if (this.bDb < headerViewsCount) {
            this.bDb = headerViewsCount;
            this.bDc = headerViewsCount;
            i3 = headerViewsCount;
        } else if (this.bDc >= this.mListView.getCount() - footerViewsCount) {
            i3 = (this.mListView.getCount() - footerViewsCount) - 1;
            this.bDb = i3;
            this.bDc = i3;
        }
        boolean z = (this.bDb == i9 && this.bDc == i10 && this.bDM == f2) ? false : true;
        if (i3 != this.bDa) {
            if (this.bDj != null) {
                this.bDj.drag(this.bDa - headerViewsCount, i3 - headerViewsCount);
            }
            this.bDa = i3;
            return true;
        }
        return z;
    }

    public void removeItem(int i2) {
        this.bDV = false;
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
            this.bDn = Math.max(1, obtainStyledAttributes.getDimensionPixelSize(d.l.DragSort_collapsed_height, 1));
            this.bDO = obtainStyledAttributes.getBoolean(d.l.DragSort_track_drag_sort, false);
            if (this.bDO) {
                this.bDP = new e();
            }
            this.bCY = obtainStyledAttributes.getFloat(d.l.DragSort_float_alpha, this.bCY);
            this.bCZ = this.bCY;
            this.bDm = obtainStyledAttributes.getBoolean(d.l.DragSort_drag_enabled, this.bDm);
            this.bDL = Math.max(0.0f, Math.min(1.0f, 1.0f - obtainStyledAttributes.getFloat(d.l.DragSort_slide_shuffle_speed, 0.75f)));
            this.bDd = this.bDL > 0.0f;
            setDragScrollStart(obtainStyledAttributes.getFloat(d.l.DragSort_drag_scroll_start, this.bDs));
            this.bDA = obtainStyledAttributes.getFloat(d.l.DragSort_max_drag_scroll_speed, this.bDA);
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
                bVar.cH(z);
                bVar.cG(z2);
                bVar.setBackgroundColor(color);
                this.bDI = bVar;
                a(bVar);
            }
            obtainStyledAttributes.recycle();
            i2 = i5;
            i3 = i4;
        }
        this.bDr = new d();
        if (i3 > 0) {
            this.bDS = new k(0.5f, i3);
        }
        if (i2 > 0) {
            this.bDU = new f(0.5f, i2);
        }
        this.bDJ = MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
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
        this.bDY = bVar;
        this.mListView.setOnTouchListener(bVar);
    }

    @Override // com.baidu.tbadk.widget.dragsort.e
    public void dispatchDraw(Canvas canvas) {
        float f2;
        this.bDX.dispatchDraw(canvas);
        if (this.mDragState != 0) {
            if (this.bDb != this.bDe) {
                b(this.bDb, canvas);
            }
            if (this.bDc != this.bDb && this.bDc != this.bDe) {
                b(this.bDc, canvas);
            }
        }
        if (this.bCT != null) {
            int width = this.bCT.getWidth();
            int height = this.bCT.getHeight();
            int i2 = this.bCU.x;
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
            int i3 = (int) (f2 * 255.0f * this.bCZ);
            canvas.save();
            canvas.translate(this.bCU.x, this.bCU.y);
            canvas.clipRect(0, 0, width, height);
            canvas.saveLayerAlpha(0.0f, 0.0f, width, height, i3, 31);
            this.bCT.draw(canvas);
            canvas.restore();
            canvas.restore();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.e
    public void onDraw(Canvas canvas) {
        this.bDX.onDraw(canvas);
        if (this.bDO) {
            this.bDP.PM();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.e
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.bDQ) {
            this.bDQ = false;
            return false;
        } else if (!this.bDm) {
            return this.bDX.onTouchEvent(motionEvent);
        } else {
            boolean z2 = this.bDG;
            this.bDG = false;
            if (!z2) {
                w(motionEvent);
            }
            if (this.mDragState == 4) {
                onDragTouchEvent(motionEvent);
                return true;
            }
            if (this.mDragState == 0 && this.bDX.onTouchEvent(motionEvent)) {
                z = true;
            }
            switch (motionEvent.getAction() & 255) {
                case 1:
                case 3:
                    PE();
                    return z;
                case 2:
                default:
                    if (z) {
                        this.bDK = 1;
                        return z;
                    }
                    return z;
            }
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.e
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (!this.bDm) {
            return this.bDX.onInterceptTouchEvent(motionEvent);
        }
        if (this.bDY != null) {
            this.bDY.PO().onTouchEvent(motionEvent);
        }
        w(motionEvent);
        this.bDG = true;
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            if (this.mDragState != 0) {
                this.bDQ = true;
                return true;
            }
            this.bDH = true;
        }
        if (this.bCT == null) {
            if (this.bDX.onInterceptTouchEvent(motionEvent)) {
                this.bDZ = true;
                z = true;
            } else {
                z = false;
            }
            switch (action) {
                case 1:
                case 3:
                    PE();
                    break;
                case 2:
                default:
                    if (z) {
                        this.bDK = 1;
                        break;
                    } else {
                        this.bDK = 2;
                        break;
                    }
            }
        } else {
            z = true;
        }
        if (action == 1 || action == 3) {
            this.bDH = false;
        }
        return z;
    }

    @Override // com.baidu.tbadk.widget.dragsort.e
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        this.bDX.onSizeChanged(i2, i3, i4, i5);
        PF();
    }

    @Override // com.baidu.tbadk.widget.dragsort.e
    public void requestLayout() {
        if (!this.mBlockLayoutRequests) {
            this.bDX.requestLayout();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.e
    public void onMeasure(int i2, int i3) {
        this.bDX.onMeasure(i2, i3);
        if (this.bCT != null) {
            if (this.bCT.isLayoutRequested()) {
                PH();
            }
            this.bCX = true;
        }
        this.mWidthMeasureSpec = i2;
    }

    @Override // com.baidu.tbadk.widget.dragsort.e
    public void layoutChildren() {
        this.bDX.layoutChildren();
        if (this.bCT != null) {
            if (this.bCT.isLayoutRequested() && !this.bCX) {
                PH();
            }
            this.bCT.layout(0, 0, this.bCT.getMeasuredWidth(), this.bCT.getMeasuredHeight());
            this.bCX = false;
        }
    }

    public void removeItem(int i2, float f2) {
        if (this.mDragState == 0 || this.mDragState == 4) {
            if (this.mDragState == 0) {
                this.bDe = this.mListView.getHeaderViewsCount() + i2;
                this.bDb = this.bDe;
                this.bDc = this.bDe;
                this.bDa = this.bDe;
                View childAt = this.mListView.getChildAt(this.bDe - this.mListView.getFirstVisiblePosition());
                if (childAt != null) {
                    childAt.setVisibility(4);
                }
            }
            this.mDragState = 1;
            this.bDW = f2;
            if (this.bDH) {
                switch (this.bDK) {
                    case 1:
                        this.bDX.onTouchEvent(this.bDJ);
                        break;
                    case 2:
                        this.bDX.onInterceptTouchEvent(this.bDJ);
                        break;
                }
            }
            if (this.bDS != null) {
                this.bDS.start();
            } else {
                iC(i2);
            }
        }
    }

    public void cancelDrag() {
        if (this.mDragState == 4) {
            this.bDr.cF(true);
            PJ();
            PA();
            PG();
            if (this.bDH) {
                this.mDragState = 3;
            } else {
                this.mDragState = 0;
            }
        }
    }

    private void PA() {
        this.bDe = -1;
        this.bDb = -1;
        this.bDc = -1;
        this.bDa = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PB() {
        this.mDragState = 2;
        if (this.bDk != null && this.bDa >= 0 && this.bDa < this.mListView.getCount()) {
            int headerViewsCount = this.mListView.getHeaderViewsCount();
            this.bDk.drop(this.bDe - headerViewsCount, this.bDa - headerViewsCount);
        }
        PJ();
        PD();
        PA();
        PG();
        if (this.bDH) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PC() {
        iC(this.bDe - this.mListView.getHeaderViewsCount());
    }

    private void iC(int i2) {
        this.mDragState = 1;
        if (this.bDl != null) {
            this.bDl.remove(i2);
        }
        PJ();
        PD();
        PA();
        if (this.bDH) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    private void PD() {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        if (this.bDe < firstVisiblePosition) {
            View childAt = this.mListView.getChildAt(0);
            this.mListView.setSelectionFromTop(firstVisiblePosition - 1, (childAt != null ? childAt.getTop() : 0) - this.mListView.getPaddingTop());
        }
    }

    public boolean stopDrag(boolean z) {
        this.bDV = false;
        return stopDrag(z, 0.0f);
    }

    public boolean stopDragWithVelocity(boolean z, float f2) {
        this.bDV = true;
        return stopDrag(z, f2);
    }

    public boolean stopDrag(boolean z, float f2) {
        if (this.bCT != null) {
            this.bDr.cF(true);
            if (z) {
                removeItem(this.bDe - this.mListView.getHeaderViewsCount(), f2);
            } else if (this.bDU != null) {
                this.bDU.start();
            } else {
                PB();
            }
            if (this.bDO) {
                this.bDP.sd();
                return true;
            }
            return true;
        }
        return false;
    }

    private void PE() {
        this.bDK = 0;
        this.bDH = false;
        if (this.mDragState == 3) {
            this.mDragState = 0;
        }
        this.bCZ = this.bCY;
        this.bDZ = false;
        this.bDR.clear();
    }

    private void w(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            this.mLastX = this.bDC;
            this.mLastY = this.bDD;
        }
        this.bDC = (int) motionEvent.getX();
        this.bDD = (int) motionEvent.getY();
        if (action == 0) {
            this.mLastX = this.bDC;
            this.mLastY = this.bDD;
        }
        this.bDh = ((int) motionEvent.getRawX()) - this.bDC;
        this.bDi = ((int) motionEvent.getRawY()) - this.bDD;
    }

    public boolean listViewIntercepted() {
        return this.bDZ;
    }

    public void setDragScrollStart(float f2) {
        setDragScrollStarts(f2, f2);
    }

    public void setDragScrollStarts(float f2, float f3) {
        if (f3 > 0.5f) {
            this.bDt = 0.5f;
        } else {
            this.bDt = f3;
        }
        if (f2 > 0.5f) {
            this.bDs = 0.5f;
        } else {
            this.bDs = f2;
        }
        if (this.mListView.getHeight() != 0) {
            PF();
        }
    }

    private void aP(int i2, int i3) {
        this.bCU.x = i2 - this.bDf;
        this.bCU.y = i3 - this.bDg;
        cE(true);
        int min = Math.min(i3, this.bCW + this.bDp);
        int max = Math.max(i3, this.bCW - this.bDp);
        int PL = this.bDr.PL();
        if (min > this.mLastY && min > this.bDv && PL != 1) {
            if (PL != -1) {
                this.bDr.cF(true);
            }
            this.bDr.iE(1);
        } else if (max < this.mLastY && max < this.bDu && PL != 0) {
            if (PL != -1) {
                this.bDr.cF(true);
            }
            this.bDr.iE(0);
        } else if (max >= this.bDu && min <= this.bDv && this.bDr.PK()) {
            this.bDr.cF(true);
        }
    }

    private void PF() {
        int height;
        int paddingTop = this.mListView.getPaddingTop();
        float height2 = (this.mListView.getHeight() - paddingTop) - this.mListView.getPaddingBottom();
        this.bDx = paddingTop + (this.bDs * height2);
        this.bDw = (height2 * (1.0f - this.bDt)) + paddingTop;
        this.bDu = (int) this.bDx;
        this.bDv = (int) this.bDw;
        this.bDy = this.bDx - paddingTop;
        this.bDz = (paddingTop + height) - this.bDw;
    }

    private void PG() {
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
        if (i2 != this.bDe && i2 != this.bDb && i2 != this.bDc) {
            g2 = -2;
        } else {
            g2 = g(i2, view, z);
        }
        if (g2 != layoutParams.height) {
            layoutParams.height = g2;
            view.setLayoutParams(layoutParams);
        }
        if (i2 == this.bDb || i2 == this.bDc) {
            if (i2 < this.bDe) {
                ((com.baidu.tbadk.widget.dragsort.c) view).setGravity(80);
            } else if (i2 > this.bDe) {
                ((com.baidu.tbadk.widget.dragsort.c) view).setGravity(48);
            }
        }
        int visibility = view.getVisibility();
        int i3 = 0;
        if (i2 == this.bDe && this.bCT != null) {
            i3 = 4;
        }
        if (i3 != visibility) {
            view.setVisibility(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int iD(int i2) {
        View view;
        if (i2 == this.bDe) {
            return 0;
        }
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        if (childAt != null) {
            return f(i2, childAt, false);
        }
        int i3 = this.bDR.get(i2);
        if (i3 == -1) {
            ListAdapter adapter = this.mListView.getAdapter();
            int itemViewType = adapter.getItemViewType(i2);
            int viewTypeCount = adapter.getViewTypeCount();
            if (viewTypeCount != this.bDq.length) {
                this.bDq = new View[viewTypeCount];
            }
            if (itemViewType >= 0) {
                if (this.bDq[itemViewType] == null) {
                    view = adapter.getView(i2, null, this.mListView);
                    this.bDq[itemViewType] = view;
                } else {
                    view = adapter.getView(i2, this.bDq[itemViewType], this.mListView);
                }
            } else {
                view = adapter.getView(i2, null, this.mListView);
            }
            int f2 = f(i2, view, true);
            this.bDR.add(i2, f2);
            return f2;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(int i2, View view, boolean z) {
        if (i2 == this.bDe) {
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
        boolean z = this.bDd && this.bDb != this.bDc;
        int i4 = this.bDo - this.bDn;
        int i5 = (int) (this.bDM * i4);
        if (i2 == this.bDe) {
            if (this.bDe == this.bDb) {
                if (z) {
                    return i5 + this.bDn;
                }
                return this.bDo;
            } else if (this.bDe == this.bDc) {
                return this.bDo - i5;
            } else {
                return this.bDn;
            }
        } else if (i2 == this.bDb) {
            if (z) {
                return i3 + i5;
            }
            return i3 + i4;
        } else if (i2 == this.bDc) {
            return (i3 + i4) - i5;
        } else {
            return i3;
        }
    }

    private int b(int i2, View view, int i3, int i4) {
        int i5;
        int i6;
        int iD = iD(i2);
        int height = view.getHeight();
        int aQ = aQ(i2, iD);
        if (i2 != this.bDe) {
            i6 = height - iD;
            i5 = aQ - iD;
        } else {
            i5 = aQ;
            i6 = height;
        }
        int i7 = this.bDo;
        if (this.bDe != this.bDb && this.bDe != this.bDc) {
            i7 -= this.bDn;
        }
        if (i2 <= i3) {
            if (i2 > this.bDb) {
                return (i7 - i5) + 0;
            }
        } else if (i2 == i4) {
            if (i2 <= this.bDb) {
                return (i6 - i7) + 0;
            }
            if (i2 == this.bDc) {
                return (height - aQ) + 0;
            }
            return 0 + i6;
        } else if (i2 <= this.bDb) {
            return 0 - i7;
        } else {
            if (i2 == this.bDc) {
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

    private void PH() {
        if (this.bCT != null) {
            measureItem(this.bCT);
            this.bDo = this.bCT.getMeasuredHeight();
            this.bDp = this.bDo / 2;
        }
    }

    protected boolean onDragTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        switch (motionEvent.getAction() & 255) {
            case 1:
                if (this.mDragState == 4) {
                    stopDrag(false);
                }
                PE();
                return true;
            case 2:
                aP((int) motionEvent.getX(), (int) motionEvent.getY());
                return true;
            case 3:
                if (this.mDragState == 4) {
                    cancelDrag();
                }
                PE();
                return true;
            default:
                return true;
        }
    }

    public boolean startDrag(int i2, int i3, int i4, int i5) {
        View iF;
        if (!this.bDH || this.bDI == null || (iF = this.bDI.iF(i2)) == null) {
            return false;
        }
        return startDrag(i2, iF, i3, i4, i5);
    }

    public boolean startDrag(int i2, View view, int i3, int i4, int i5) {
        if (this.mDragState == 0 && this.bDH && this.bCT == null && view != null && this.bDm) {
            if (this.mListView.getParent() != null) {
                this.mListView.getParent().requestDisallowInterceptTouchEvent(true);
            }
            int headerViewsCount = this.mListView.getHeaderViewsCount() + i2;
            this.bDb = headerViewsCount;
            this.bDc = headerViewsCount;
            this.bDe = headerViewsCount;
            this.bDa = headerViewsCount;
            this.mDragState = 4;
            this.bDF = 0;
            this.bDF |= i3;
            this.bCT = view;
            PH();
            this.bDf = i4;
            this.bDg = i5;
            this.bDE = this.bDD;
            this.bCU.x = this.bDC - this.bDf;
            this.bCU.y = this.bDD - this.bDg;
            View childAt = this.mListView.getChildAt(this.bDe - this.mListView.getFirstVisiblePosition());
            if (childAt != null) {
                childAt.setVisibility(4);
            }
            if (this.bDO) {
                this.bDP.startTracking();
            }
            switch (this.bDK) {
                case 1:
                    this.bDX.onTouchEvent(this.bDJ);
                    break;
                case 2:
                    this.bDX.onInterceptTouchEvent(this.bDJ);
                    break;
            }
            this.mListView.requestLayout();
            if (this.bDT != null) {
                this.bDT.start();
                return true;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cE(boolean z) {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition() + (this.mListView.getChildCount() / 2);
        View childAt = this.mListView.getChildAt(this.mListView.getChildCount() / 2);
        if (childAt != null) {
            h(firstVisiblePosition, childAt, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i2, View view, boolean z) {
        this.mBlockLayoutRequests = true;
        PI();
        int i3 = this.bDb;
        int i4 = this.bDc;
        boolean Pz = Pz();
        if (Pz) {
            PG();
            this.mListView.setSelectionFromTop(i2, (b(i2, view, i3, i4) + view.getTop()) - this.mListView.getPaddingTop());
            layoutChildren();
        }
        if (Pz || z) {
            this.mListView.invalidate();
        }
        this.mBlockLayoutRequests = false;
    }

    private void PI() {
        if (this.bDI != null) {
            this.bCV.set(this.bDC, this.bDD);
            this.bDI.b(this.bCT, this.bCU, this.bCV);
        }
        int i2 = this.bCU.x;
        int i3 = this.bCU.y;
        int paddingLeft = this.mListView.getPaddingLeft();
        if ((this.bDF & 1) == 0 && i2 > paddingLeft) {
            this.bCU.x = paddingLeft;
        } else if ((this.bDF & 2) == 0 && i2 < paddingLeft) {
            this.bCU.x = paddingLeft;
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int lastVisiblePosition = this.mListView.getLastVisiblePosition();
        int paddingTop = this.mListView.getPaddingTop();
        if (firstVisiblePosition < headerViewsCount) {
            paddingTop = this.mListView.getChildAt((headerViewsCount - firstVisiblePosition) - 1).getBottom();
        }
        if ((this.bDF & 8) == 0 && firstVisiblePosition <= this.bDe) {
            paddingTop = Math.max(this.mListView.getChildAt(this.bDe - firstVisiblePosition).getTop(), paddingTop);
        }
        int height = this.mListView.getHeight() - this.mListView.getPaddingBottom();
        if (lastVisiblePosition >= (this.mListView.getCount() - footerViewsCount) - 1) {
            height = this.mListView.getChildAt(((this.mListView.getCount() - footerViewsCount) - 1) - firstVisiblePosition).getBottom();
        }
        if ((this.bDF & 4) == 0 && lastVisiblePosition >= this.bDe) {
            height = Math.min(this.mListView.getChildAt(this.bDe - firstVisiblePosition).getBottom(), height);
        }
        if (i3 < paddingTop) {
            this.bCU.y = paddingTop;
        } else if (this.bDo + i3 > height) {
            this.bCU.y = height - this.bDo;
        }
        this.bCW = this.bCU.y + this.bDp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PJ() {
        if (this.bCT != null) {
            this.bCT.setVisibility(8);
            if (this.bDI != null) {
                this.bDI.bl(this.bCT);
            }
            this.bCT = null;
            this.mListView.invalidate();
        }
    }

    public void a(h hVar) {
        this.bDI = hVar;
    }

    public void a(b bVar) {
        this.bDj = bVar;
    }

    public void setDragEnabled(boolean z) {
        this.bDm = z;
    }

    public boolean isDragEnabled() {
        return this.bDm;
    }

    public void a(g gVar) {
        this.bDk = gVar;
    }

    public void a(l lVar) {
        this.bDl = lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class i {
        private SparseIntArray bEt;
        private ArrayList<Integer> bEu;
        private int mMaxSize;

        public i(int i) {
            this.bEt = new SparseIntArray(i);
            this.bEu = new ArrayList<>(i);
            this.mMaxSize = i;
        }

        public void add(int i, int i2) {
            int i3 = this.bEt.get(i, -1);
            if (i3 != i2) {
                if (i3 == -1) {
                    if (this.bEt.size() == this.mMaxSize) {
                        this.bEt.delete(this.bEu.remove(0).intValue());
                    }
                } else {
                    this.bEu.remove(Integer.valueOf(i));
                }
                this.bEt.put(i, i2);
                this.bEu.add(Integer.valueOf(i));
            }
        }

        public int get(int i) {
            return this.bEt.get(i, -1);
        }

        public void clear() {
            this.bEt.clear();
            this.bEu.clear();
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
        private float bEE;
        private float bEF;
        private float bEG;
        private float bEH;
        private float bEI;
        private float mAlpha;
        private boolean mCanceled;
        protected long mStartTime;

        public m(float f, int i) {
            this.mAlpha = f;
            this.bEE = i;
            float f2 = 1.0f / ((this.mAlpha * 2.0f) * (1.0f - this.mAlpha));
            this.bEI = f2;
            this.bEF = f2;
            this.bEG = this.mAlpha / ((this.mAlpha - 1.0f) * 2.0f);
            this.bEH = 1.0f / (1.0f - this.mAlpha);
        }

        public float V(float f) {
            if (f < this.mAlpha) {
                return this.bEF * f * f;
            }
            if (f < 1.0f - this.mAlpha) {
                return this.bEG + (this.bEH * f);
            }
            return 1.0f - ((this.bEI * (f - 1.0f)) * (f - 1.0f));
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
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / this.bEE;
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
        private int bEp;
        private int bEq;
        private float bEr;
        private float bEs;

        public f(float f, int i) {
            super(f, i);
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.bEp = a.this.bDa;
            this.bEq = a.this.bDe;
            a.this.mDragState = 2;
            this.bEr = a.this.bCU.y - PN();
            this.bEs = a.this.bCU.x - a.this.mListView.getPaddingLeft();
        }

        private int PN() {
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            int dividerHeight = (a.this.bDn + a.this.mListView.getDividerHeight()) / 2;
            View childAt = a.this.mListView.getChildAt(this.bEp - firstVisiblePosition);
            if (childAt != null) {
                if (this.bEp == this.bEq) {
                    return childAt.getTop();
                }
                if (this.bEp >= this.bEq) {
                    return (childAt.getBottom() + dividerHeight) - a.this.bDo;
                }
                return childAt.getTop() - dividerHeight;
            }
            cancel();
            return -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void n(float f, float f2) {
            int PN = PN();
            float paddingLeft = a.this.bCU.x - a.this.mListView.getPaddingLeft();
            float f3 = 1.0f - f2;
            if (f3 < Math.abs((a.this.bCU.y - PN) / this.bEr) || f3 < Math.abs(paddingLeft / this.bEs)) {
                a.this.bCU.y = PN + ((int) (this.bEr * f3));
                a.this.bCU.x = a.this.mListView.getPaddingLeft() + ((int) (this.bEs * f3));
                a.this.cE(true);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.PB();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class k extends m {
        private int bEA;
        private int bEB;
        private int bEC;
        private int bED;
        private int bEq;
        private float bEx;
        private float bEy;
        private float bEz;

        public k(float f, int i) {
            super(f, i);
            this.bEA = -1;
            this.bEB = -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.bEA = -1;
            this.bEB = -1;
            this.bEC = a.this.bDb;
            this.bED = a.this.bDc;
            this.bEq = a.this.bDe;
            a.this.mDragState = 1;
            this.bEx = a.this.bCU.x;
            if (a.this.bDV) {
                float width = a.this.mListView.getWidth() * 2.0f;
                if (a.this.bDW == 0.0f) {
                    a.this.bDW = (this.bEx >= 0.0f ? 1 : -1) * width;
                    return;
                }
                float f = width * 2.0f;
                if (a.this.bDW >= 0.0f || a.this.bDW <= (-f)) {
                    if (a.this.bDW > 0.0f && a.this.bDW < f) {
                        a.this.bDW = f;
                        return;
                    }
                    return;
                }
                a.this.bDW = -f;
                return;
            }
            a.this.PJ();
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void n(float f, float f2) {
            View childAt;
            float f3 = 1.0f - f2;
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            View childAt2 = a.this.mListView.getChildAt(this.bEC - firstVisiblePosition);
            if (a.this.bDV) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / 1000.0f;
                if (uptimeMillis != 0.0f) {
                    float f4 = a.this.bDW * uptimeMillis;
                    int width = a.this.mListView.getWidth();
                    a.this.bDW = ((a.this.bDW > 0.0f ? 1 : -1) * uptimeMillis * width) + a.this.bDW;
                    this.bEx += f4;
                    a.this.bCU.x = (int) this.bEx;
                    if (this.bEx < width && this.bEx > (-width)) {
                        this.mStartTime = SystemClock.uptimeMillis();
                        a.this.cE(true);
                        return;
                    }
                } else {
                    return;
                }
            }
            if (childAt2 != null) {
                if (this.bEA == -1) {
                    this.bEA = a.this.f(this.bEC, childAt2, false);
                    this.bEy = childAt2.getHeight() - this.bEA;
                }
                int max = Math.max((int) (this.bEy * f3), 1);
                ViewGroup.LayoutParams layoutParams = childAt2.getLayoutParams();
                layoutParams.height = max + this.bEA;
                childAt2.setLayoutParams(layoutParams);
            }
            if (this.bED != this.bEC && (childAt = a.this.mListView.getChildAt(this.bED - firstVisiblePosition)) != null) {
                if (this.bEB == -1) {
                    this.bEB = a.this.f(this.bED, childAt, false);
                    this.bEz = childAt.getHeight() - this.bEB;
                }
                int max2 = Math.max((int) (this.bEz * f3), 1);
                ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
                layoutParams2.height = max2 + this.bEB;
                childAt.setLayoutParams(layoutParams2);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.PC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class j extends m {
        final /* synthetic */ a bEb;
        private float bEv;
        private float bEw;

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.bEv = this.bEb.bDg;
            this.bEw = this.bEb.bDp;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void n(float f, float f2) {
            if (this.bEb.mDragState != 4) {
                cancel();
                return;
            }
            this.bEb.bDg = (int) ((this.bEw * f2) + ((1.0f - f2) * this.bEv));
            this.bEb.bCU.y = this.bEb.bDD - this.bEb.bDg;
            this.bEb.cE(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e {
        StringBuilder mBuilder = new StringBuilder();
        private int bEm = 0;
        private int bEn = 0;
        private boolean bEo = false;
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
            this.bEn = 0;
            this.bEo = true;
        }

        public void PM() {
            if (this.bEo) {
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
                this.mBuilder.append("    <FirstExpPos>").append(a.this.bDb).append("</FirstExpPos>\n");
                this.mBuilder.append("    <FirstExpBlankHeight>").append(a.this.iB(a.this.bDb) - a.this.iD(a.this.bDb)).append("</FirstExpBlankHeight>\n");
                this.mBuilder.append("    <SecondExpPos>").append(a.this.bDc).append("</SecondExpPos>\n");
                this.mBuilder.append("    <SecondExpBlankHeight>").append(a.this.iB(a.this.bDc) - a.this.iD(a.this.bDc)).append("</SecondExpBlankHeight>\n");
                this.mBuilder.append("    <SrcPos>").append(a.this.bDe).append("</SrcPos>\n");
                this.mBuilder.append("    <SrcHeight>").append(a.this.bDo + a.this.mListView.getDividerHeight()).append("</SrcHeight>\n");
                this.mBuilder.append("    <ViewHeight>").append(a.this.mListView.getHeight()).append("</ViewHeight>\n");
                this.mBuilder.append("    <LastY>").append(a.this.mLastY).append("</LastY>\n");
                this.mBuilder.append("    <FloatY>").append(a.this.bCW).append("</FloatY>\n");
                this.mBuilder.append("    <ShuffleEdges>");
                for (int i4 = 0; i4 < childCount; i4++) {
                    this.mBuilder.append(a.this.aO(firstVisiblePosition + i4, a.this.mListView.getChildAt(i4).getTop())).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                this.mBuilder.append("</ShuffleEdges>\n");
                this.mBuilder.append("</DSLVState>\n");
                this.bEm++;
                if (this.bEm > 1000) {
                    flush();
                    this.bEm = 0;
                }
            }
        }

        public void flush() {
            if (this.bEo) {
                try {
                    FileWriter fileWriter = new FileWriter(this.mFile, this.bEn != 0);
                    fileWriter.write(this.mBuilder.toString());
                    this.mBuilder.delete(0, this.mBuilder.length());
                    fileWriter.flush();
                    fileWriter.close();
                    this.bEn++;
                } catch (IOException e) {
                }
            }
        }

        public void sd() {
            if (this.bEo) {
                this.mBuilder.append("</DSLVStates>\n");
                flush();
                this.bEo = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements Runnable {
        private boolean bEe;
        private long bEf;
        private long bEg;
        private float bEh;
        private long bEi;
        private int bEj;
        private float bEk;
        private boolean bEl = false;
        private int dy;

        public boolean PK() {
            return this.bEl;
        }

        public int PL() {
            if (this.bEl) {
                return this.bEj;
            }
            return -1;
        }

        public d() {
        }

        public void iE(int i) {
            if (!this.bEl) {
                this.bEe = false;
                this.bEl = true;
                this.bEi = SystemClock.uptimeMillis();
                this.bEf = this.bEi;
                this.bEj = i;
                a.this.mListView.post(this);
            }
        }

        public void cF(boolean z) {
            if (z) {
                a.this.mListView.removeCallbacks(this);
                this.bEl = false;
                return;
            }
            this.bEe = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.bEe) {
                int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
                int lastVisiblePosition = a.this.mListView.getLastVisiblePosition();
                int count = a.this.mListView.getCount();
                int paddingTop = a.this.mListView.getPaddingTop();
                int height = (a.this.mListView.getHeight() - paddingTop) - a.this.mListView.getPaddingBottom();
                int min = Math.min(a.this.bDD, a.this.bCW + a.this.bDp);
                int max = Math.max(a.this.bDD, a.this.bCW - a.this.bDp);
                if (this.bEj == 0) {
                    View childAt = a.this.mListView.getChildAt(0);
                    if (childAt == null) {
                        this.bEl = false;
                        return;
                    } else if (firstVisiblePosition == 0 && childAt.getTop() == paddingTop) {
                        this.bEl = false;
                        return;
                    } else {
                        this.bEk = a.this.bDB.b((a.this.bDx - max) / a.this.bDy, this.bEf);
                    }
                } else {
                    View childAt2 = a.this.mListView.getChildAt(lastVisiblePosition - firstVisiblePosition);
                    if (childAt2 == null) {
                        this.bEl = false;
                        return;
                    } else if (lastVisiblePosition == count - 1 && childAt2.getBottom() <= height + paddingTop) {
                        this.bEl = false;
                        return;
                    } else {
                        this.bEk = -a.this.bDB.b((min - a.this.bDw) / a.this.bDz, this.bEf);
                    }
                }
                this.bEg = SystemClock.uptimeMillis();
                this.bEh = (float) (this.bEg - this.bEf);
                this.dy = Math.round(this.bEk * this.bEh);
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
                this.bEf = this.bEg;
                a.this.mListView.post(this);
                return;
            }
            this.bEl = false;
        }
    }
}
