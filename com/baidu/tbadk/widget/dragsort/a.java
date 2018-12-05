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
import com.baidu.searchbox.ng.ai.apps.util.AiAppsFileUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.e;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a implements com.baidu.tbadk.widget.dragsort.c {
    private View bkF;
    private int bkI;
    private int bkM;
    private int bkN;
    private int bkO;
    private int bkQ;
    private int bkR;
    private int bkS;
    private b bkT;
    private g bkU;
    private l bkV;
    private int bkY;
    private j blA;
    private f blB;
    private boolean blC;
    private com.baidu.tbadk.widget.dragsort.d blE;
    private com.baidu.tbadk.widget.dragsort.b blF;
    private d bla;
    private int bld;
    private int ble;
    private float blf;
    private float blg;
    private float blh;
    private float bli;
    private int bll;
    private MotionEvent blq;
    private C0177a blu;
    private e blw;
    private k blz;
    private int mFloatViewHeight;
    private int mLastX;
    private int mLastY;
    private ListView mListView;
    private DataSetObserver mObserver;
    private int mOffsetX;
    private int mOffsetY;
    private int mX;
    private int mY;
    private Point bkG = new Point();
    private Point bkH = new Point();
    private boolean bkJ = false;
    private float bkK = 1.0f;
    private float bkL = 1.0f;
    private boolean bkP = false;
    private boolean bkW = true;
    private int mDragState = 0;
    private int bkX = 1;
    private int mWidthMeasureSpec = 0;
    private View[] bkZ = new View[1];
    private float blb = 0.33333334f;
    private float blc = 0.33333334f;
    private float blj = 0.5f;
    private c blk = new c() { // from class: com.baidu.tbadk.widget.dragsort.a.1
        @Override // com.baidu.tbadk.widget.dragsort.a.c
        public float b(float f2, long j2) {
            return a.this.blj * f2;
        }
    };
    private int blm = 0;
    private boolean bln = false;
    private boolean blo = false;
    private h blp = null;
    private int blr = 0;
    private float bls = 0.25f;
    private float blt = 0.0f;
    private boolean blv = false;
    private boolean mBlockLayoutRequests = false;
    private boolean blx = false;
    private i bly = new i(3);
    private float blD = 0.0f;
    private boolean blG = false;
    private boolean blH = false;

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
        void af(View view);

        void b(View view, Point point, Point point2);

        View gy(int i);
    }

    /* loaded from: classes.dex */
    public interface l {
        void remove(int i);
    }

    public a(ListView listView, com.baidu.tbadk.widget.dragsort.d dVar) {
        this.blE = dVar;
        this.mListView = listView;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            this.blu = new C0177a(listAdapter);
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
            this.blu = null;
        }
        this.blE.setAdapter(this.blu);
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
            if (i2 > this.bkQ) {
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
    public int gu(int i2) {
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        return childAt != null ? childAt.getHeight() : R(i2, gw(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int P(int i2, int i3) {
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        if (i2 <= headerViewsCount || i2 >= this.mListView.getCount() - footerViewsCount) {
            return i3;
        }
        int dividerHeight = this.mListView.getDividerHeight();
        int i4 = this.mFloatViewHeight - this.bkX;
        int gw = gw(i2);
        int gu = gu(i2);
        if (this.bkO <= this.bkQ) {
            if (i2 == this.bkO && this.bkN != this.bkO) {
                if (i2 == this.bkQ) {
                    i3 = (i3 + gu) - this.mFloatViewHeight;
                } else {
                    i3 = ((gu - gw) + i3) - i4;
                }
            } else if (i2 > this.bkO && i2 <= this.bkQ) {
                i3 -= i4;
            }
        } else if (i2 > this.bkQ && i2 <= this.bkN) {
            i3 += i4;
        } else if (i2 == this.bkO && this.bkN != this.bkO) {
            i3 += gu - gw;
        }
        if (i2 <= this.bkQ) {
            return (((this.mFloatViewHeight - dividerHeight) - gw(i2 - 1)) / 2) + i3;
        }
        return (((gw - dividerHeight) - this.mFloatViewHeight) / 2) + i3;
    }

    private boolean QM() {
        int i2;
        int i3;
        int i4;
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int i5 = this.bkN;
        View childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        if (childAt == null) {
            i5 = firstVisiblePosition + (this.mListView.getChildCount() / 2);
            childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        }
        int top = childAt.getTop();
        int height = childAt.getHeight();
        int P = P(i5, top);
        int dividerHeight = this.mListView.getDividerHeight();
        if (this.bkI >= P) {
            int count = this.mListView.getCount();
            int i6 = height;
            int i7 = top;
            i2 = P;
            i3 = i5;
            i4 = P;
            while (true) {
                if (i3 < count) {
                    if (i3 == count - 1) {
                        i2 = i7 + dividerHeight + i6;
                        break;
                    }
                    i7 += dividerHeight + i6;
                    i6 = gu(i3 + 1);
                    i2 = P(i3 + 1, i7);
                    if (this.bkI < i2) {
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
            i2 = P;
            i3 = i5;
            i4 = P;
            while (true) {
                if (i3 < 0) {
                    break;
                }
                i3--;
                int gu = gu(i3);
                if (i3 == 0) {
                    i2 = (i8 - dividerHeight) - gu;
                    break;
                }
                i8 -= gu + dividerHeight;
                i2 = P(i3, i8);
                if (this.bkI >= i2) {
                    break;
                }
                i4 = i2;
            }
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int i9 = this.bkN;
        int i10 = this.bkO;
        float f2 = this.blt;
        if (this.bkP) {
            int abs = Math.abs(i2 - i4);
            if (this.bkI >= i2) {
                int i11 = i4;
                i4 = i2;
                i2 = i11;
            }
            int i12 = (int) (abs * this.bls * 0.5f);
            float f3 = i12;
            int i13 = i4 + i12;
            int i14 = i2 - i12;
            if (this.bkI < i13) {
                this.bkN = i3 - 1;
                this.bkO = i3;
                this.blt = ((i13 - this.bkI) * 0.5f) / f3;
            } else if (this.bkI < i14) {
                this.bkN = i3;
                this.bkO = i3;
            } else {
                this.bkN = i3;
                this.bkO = i3 + 1;
                this.blt = (1.0f + ((i2 - this.bkI) / f3)) * 0.5f;
            }
        } else {
            this.bkN = i3;
            this.bkO = i3;
        }
        if (this.bkN < headerViewsCount) {
            this.bkN = headerViewsCount;
            this.bkO = headerViewsCount;
            i3 = headerViewsCount;
        } else if (this.bkO >= this.mListView.getCount() - footerViewsCount) {
            i3 = (this.mListView.getCount() - footerViewsCount) - 1;
            this.bkN = i3;
            this.bkO = i3;
        }
        boolean z = (this.bkN == i9 && this.bkO == i10 && this.blt == f2) ? false : true;
        if (i3 != this.bkM) {
            if (this.bkT != null) {
                this.bkT.drag(this.bkM - headerViewsCount, i3 - headerViewsCount);
            }
            this.bkM = i3;
            return true;
        }
        return z;
    }

    public void removeItem(int i2) {
        this.blC = false;
        removeItem(i2, 0.0f);
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void a(ListView listView, Context context, AttributeSet attributeSet) {
        int i2;
        int i3 = BaseActivity.SHOW_SOFT_KEYBOARD_DELAY;
        if (attributeSet == null) {
            i2 = 150;
        } else {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.l.DragSort, 0, 0);
            this.bkX = Math.max(1, obtainStyledAttributes.getDimensionPixelSize(e.l.DragSort_collapsed_height, 1));
            this.blv = obtainStyledAttributes.getBoolean(e.l.DragSort_track_drag_sort, false);
            if (this.blv) {
                this.blw = new e();
            }
            this.bkK = obtainStyledAttributes.getFloat(e.l.DragSort_float_alpha, this.bkK);
            this.bkL = this.bkK;
            this.bkW = obtainStyledAttributes.getBoolean(e.l.DragSort_drag_enabled, this.bkW);
            this.bls = Math.max(0.0f, Math.min(1.0f, 1.0f - obtainStyledAttributes.getFloat(e.l.DragSort_slide_shuffle_speed, 0.75f)));
            this.bkP = this.bls > 0.0f;
            setDragScrollStart(obtainStyledAttributes.getFloat(e.l.DragSort_drag_scroll_start, this.blb));
            this.blj = obtainStyledAttributes.getFloat(e.l.DragSort_max_drag_scroll_speed, this.blj);
            int i4 = obtainStyledAttributes.getInt(e.l.DragSort_remove_animation_duration, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
            int i5 = obtainStyledAttributes.getInt(e.l.DragSort_drop_animation_duration, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
            if (obtainStyledAttributes.getBoolean(e.l.DragSort_use_default_controller, true)) {
                boolean z = obtainStyledAttributes.getBoolean(e.l.DragSort_remove_enabled, false);
                int i6 = obtainStyledAttributes.getInt(e.l.DragSort_remove_mode, 1);
                boolean z2 = obtainStyledAttributes.getBoolean(e.l.DragSort_sort_enabled, true);
                int resourceId = obtainStyledAttributes.getResourceId(e.l.DragSort_drag_handle_id, 0);
                int resourceId2 = obtainStyledAttributes.getResourceId(e.l.DragSort_fling_handle_id, 0);
                int resourceId3 = obtainStyledAttributes.getResourceId(e.l.DragSort_click_remove_id, 0);
                int color = obtainStyledAttributes.getColor(e.l.DragSort_float_background_color, -16777216);
                com.baidu.tbadk.widget.dragsort.b bVar = new com.baidu.tbadk.widget.dragsort.b(this, listView, resourceId, 2, i6, resourceId3, resourceId2);
                bVar.cW(z);
                bVar.cV(z2);
                bVar.setBackgroundColor(color);
                this.blp = bVar;
                a(bVar);
            }
            obtainStyledAttributes.recycle();
            i2 = i5;
            i3 = i4;
        }
        this.bla = new d();
        if (i3 > 0) {
            this.blz = new k(0.5f, i3);
        }
        if (i2 > 0) {
            this.blB = new f(0.5f, i2);
        }
        this.blq = MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
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
        this.blF = bVar;
        this.mListView.setOnTouchListener(bVar);
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void dispatchDraw(Canvas canvas) {
        float f2;
        this.blE.dispatchDraw(canvas);
        if (this.mDragState != 0) {
            if (this.bkN != this.bkQ) {
                b(this.bkN, canvas);
            }
            if (this.bkO != this.bkN && this.bkO != this.bkQ) {
                b(this.bkO, canvas);
            }
        }
        if (this.bkF != null) {
            int width = this.bkF.getWidth();
            int height = this.bkF.getHeight();
            int i2 = this.bkG.x;
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
            int i3 = (int) (f2 * 255.0f * this.bkL);
            canvas.save();
            canvas.translate(this.bkG.x, this.bkG.y);
            canvas.clipRect(0, 0, width, height);
            canvas.saveLayerAlpha(0.0f, 0.0f, width, height, i3, 31);
            this.bkF.draw(canvas);
            canvas.restore();
            canvas.restore();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onDraw(Canvas canvas) {
        this.blE.onDraw(canvas);
        if (this.blv) {
            this.blw.QY();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.blx) {
            this.blx = false;
            return false;
        } else if (!this.bkW) {
            return this.blE.onTouchEvent(motionEvent);
        } else {
            boolean z2 = this.bln;
            this.bln = false;
            if (!z2) {
                u(motionEvent);
            }
            if (this.mDragState == 4) {
                onDragTouchEvent(motionEvent);
                return true;
            }
            if (this.mDragState == 0 && this.blE.onTouchEvent(motionEvent)) {
                z = true;
            }
            switch (motionEvent.getAction() & 255) {
                case 1:
                case 3:
                    QR();
                    return z;
                case 2:
                default:
                    if (z) {
                        this.blr = 1;
                        return z;
                    }
                    return z;
            }
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (!this.bkW) {
            return this.blE.onInterceptTouchEvent(motionEvent);
        }
        if (this.blF != null) {
            this.blF.Ra().onTouchEvent(motionEvent);
        }
        u(motionEvent);
        this.bln = true;
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            if (this.mDragState != 0) {
                this.blx = true;
                return true;
            }
            this.blo = true;
        }
        if (this.bkF == null) {
            if (this.blE.onInterceptTouchEvent(motionEvent)) {
                this.blG = true;
                z = true;
            } else {
                z = false;
            }
            switch (action) {
                case 1:
                case 3:
                    QR();
                    break;
                case 2:
                default:
                    if (z) {
                        this.blr = 1;
                        break;
                    } else {
                        this.blr = 2;
                        break;
                    }
            }
        } else {
            z = true;
        }
        if (action == 1 || action == 3) {
            this.blo = false;
        }
        return z;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        this.blE.onSizeChanged(i2, i3, i4, i5);
        QS();
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void requestLayout() {
        if (!this.mBlockLayoutRequests) {
            this.blE.requestLayout();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onMeasure(int i2, int i3) {
        this.blE.onMeasure(i2, i3);
        if (this.bkF != null) {
            if (this.bkF.isLayoutRequested()) {
                QU();
            }
            this.bkJ = true;
        }
        this.mWidthMeasureSpec = i2;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void layoutChildren() {
        this.blE.layoutChildren();
        if (this.bkF != null) {
            if (this.bkF.isLayoutRequested() && !this.bkJ) {
                QU();
            }
            this.bkF.layout(0, 0, this.bkF.getMeasuredWidth(), this.bkF.getMeasuredHeight());
            this.bkJ = false;
        }
    }

    public void removeItem(int i2, float f2) {
        if (this.mDragState == 0 || this.mDragState == 4) {
            if (this.mDragState == 0) {
                this.bkQ = this.mListView.getHeaderViewsCount() + i2;
                this.bkN = this.bkQ;
                this.bkO = this.bkQ;
                this.bkM = this.bkQ;
                View childAt = this.mListView.getChildAt(this.bkQ - this.mListView.getFirstVisiblePosition());
                if (childAt != null) {
                    childAt.setVisibility(4);
                }
            }
            this.mDragState = 1;
            this.blD = f2;
            if (this.blo) {
                switch (this.blr) {
                    case 1:
                        this.blE.onTouchEvent(this.blq);
                        break;
                    case 2:
                        this.blE.onInterceptTouchEvent(this.blq);
                        break;
                }
            }
            if (this.blz != null) {
                this.blz.start();
            } else {
                gv(i2);
            }
        }
    }

    public void cancelDrag() {
        if (this.mDragState == 4) {
            this.bla.cU(true);
            QW();
            QN();
            QT();
            if (this.blo) {
                this.mDragState = 3;
            } else {
                this.mDragState = 0;
            }
        }
    }

    private void QN() {
        this.bkQ = -1;
        this.bkN = -1;
        this.bkO = -1;
        this.bkM = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QO() {
        this.mDragState = 2;
        if (this.bkU != null && this.bkM >= 0 && this.bkM < this.mListView.getCount()) {
            int headerViewsCount = this.mListView.getHeaderViewsCount();
            this.bkU.drop(this.bkQ - headerViewsCount, this.bkM - headerViewsCount);
        }
        QW();
        QQ();
        QN();
        QT();
        if (this.blo) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QP() {
        gv(this.bkQ - this.mListView.getHeaderViewsCount());
    }

    private void gv(int i2) {
        this.mDragState = 1;
        if (this.bkV != null) {
            this.bkV.remove(i2);
        }
        QW();
        QQ();
        QN();
        if (this.blo) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    private void QQ() {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        if (this.bkQ < firstVisiblePosition) {
            View childAt = this.mListView.getChildAt(0);
            this.mListView.setSelectionFromTop(firstVisiblePosition - 1, (childAt != null ? childAt.getTop() : 0) - this.mListView.getPaddingTop());
        }
    }

    public boolean stopDrag(boolean z) {
        this.blC = false;
        return stopDrag(z, 0.0f);
    }

    public boolean stopDragWithVelocity(boolean z, float f2) {
        this.blC = true;
        return stopDrag(z, f2);
    }

    public boolean stopDrag(boolean z, float f2) {
        if (this.bkF != null) {
            this.bla.cU(true);
            if (z) {
                removeItem(this.bkQ - this.mListView.getHeaderViewsCount(), f2);
            } else if (this.blB != null) {
                this.blB.start();
            } else {
                QO();
            }
            if (this.blv) {
                this.blw.ok();
                return true;
            }
            return true;
        }
        return false;
    }

    private void QR() {
        this.blr = 0;
        this.blo = false;
        if (this.mDragState == 3) {
            this.mDragState = 0;
        }
        this.bkL = this.bkK;
        this.blG = false;
        this.bly.clear();
    }

    private void u(MotionEvent motionEvent) {
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
        return this.blG;
    }

    public void setDragScrollStart(float f2) {
        setDragScrollStarts(f2, f2);
    }

    public void setDragScrollStarts(float f2, float f3) {
        if (f3 > 0.5f) {
            this.blc = 0.5f;
        } else {
            this.blc = f3;
        }
        if (f2 > 0.5f) {
            this.blb = 0.5f;
        } else {
            this.blb = f2;
        }
        if (this.mListView.getHeight() != 0) {
            QS();
        }
    }

    private void Q(int i2, int i3) {
        this.bkG.x = i2 - this.bkR;
        this.bkG.y = i3 - this.bkS;
        cT(true);
        int min = Math.min(i3, this.bkI + this.bkY);
        int max = Math.max(i3, this.bkI - this.bkY);
        int QX = this.bla.QX();
        if (min > this.mLastY && min > this.ble && QX != 1) {
            if (QX != -1) {
                this.bla.cU(true);
            }
            this.bla.gx(1);
        } else if (max < this.mLastY && max < this.bld && QX != 0) {
            if (QX != -1) {
                this.bla.cU(true);
            }
            this.bla.gx(0);
        } else if (max >= this.bld && min <= this.ble && this.bla.isScrolling()) {
            this.bla.cU(true);
        }
    }

    private void QS() {
        int height;
        int paddingTop = this.mListView.getPaddingTop();
        float height2 = (this.mListView.getHeight() - paddingTop) - this.mListView.getPaddingBottom();
        this.blg = paddingTop + (this.blb * height2);
        this.blf = (height2 * (1.0f - this.blc)) + paddingTop;
        this.bld = (int) this.blg;
        this.ble = (int) this.blf;
        this.blh = this.blg - paddingTop;
        this.bli = (paddingTop + height) - this.blf;
    }

    private void QT() {
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
        if (i2 != this.bkQ && i2 != this.bkN && i2 != this.bkO) {
            g2 = -2;
        } else {
            g2 = g(i2, view, z);
        }
        if (g2 != layoutParams.height) {
            layoutParams.height = g2;
            view.setLayoutParams(layoutParams);
        }
        if (i2 == this.bkN || i2 == this.bkO) {
            if (i2 < this.bkQ) {
                ((DragSortItemView) view).setGravity(80);
            } else if (i2 > this.bkQ) {
                ((DragSortItemView) view).setGravity(48);
            }
        }
        int visibility = view.getVisibility();
        int i3 = 0;
        if (i2 == this.bkQ && this.bkF != null) {
            i3 = 4;
        }
        if (i3 != visibility) {
            view.setVisibility(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int gw(int i2) {
        View view;
        if (i2 == this.bkQ) {
            return 0;
        }
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        if (childAt != null) {
            return f(i2, childAt, false);
        }
        int i3 = this.bly.get(i2);
        if (i3 == -1) {
            ListAdapter adapter = this.mListView.getAdapter();
            int itemViewType = adapter.getItemViewType(i2);
            int viewTypeCount = adapter.getViewTypeCount();
            if (viewTypeCount != this.bkZ.length) {
                this.bkZ = new View[viewTypeCount];
            }
            if (itemViewType >= 0) {
                if (this.bkZ[itemViewType] == null) {
                    view = adapter.getView(i2, null, this.mListView);
                    this.bkZ[itemViewType] = view;
                } else {
                    view = adapter.getView(i2, this.bkZ[itemViewType], this.mListView);
                }
            } else {
                view = adapter.getView(i2, null, this.mListView);
            }
            int f2 = f(i2, view, true);
            this.bly.add(i2, f2);
            return f2;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(int i2, View view, boolean z) {
        if (i2 == this.bkQ) {
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
        return R(i2, f(i2, view, z));
    }

    private int R(int i2, int i3) {
        this.mListView.getDividerHeight();
        boolean z = this.bkP && this.bkN != this.bkO;
        int i4 = this.mFloatViewHeight - this.bkX;
        int i5 = (int) (this.blt * i4);
        if (i2 == this.bkQ) {
            if (this.bkQ == this.bkN) {
                if (z) {
                    return i5 + this.bkX;
                }
                return this.mFloatViewHeight;
            } else if (this.bkQ == this.bkO) {
                return this.mFloatViewHeight - i5;
            } else {
                return this.bkX;
            }
        } else if (i2 == this.bkN) {
            if (z) {
                return i3 + i5;
            }
            return i3 + i4;
        } else if (i2 == this.bkO) {
            return (i3 + i4) - i5;
        } else {
            return i3;
        }
    }

    private int b(int i2, View view, int i3, int i4) {
        int i5;
        int i6;
        int gw = gw(i2);
        int height = view.getHeight();
        int R = R(i2, gw);
        if (i2 != this.bkQ) {
            i6 = height - gw;
            i5 = R - gw;
        } else {
            i5 = R;
            i6 = height;
        }
        int i7 = this.mFloatViewHeight;
        if (this.bkQ != this.bkN && this.bkQ != this.bkO) {
            i7 -= this.bkX;
        }
        if (i2 <= i3) {
            if (i2 > this.bkN) {
                return (i7 - i5) + 0;
            }
        } else if (i2 == i4) {
            if (i2 <= this.bkN) {
                return (i6 - i7) + 0;
            }
            if (i2 == this.bkO) {
                return (height - R) + 0;
            }
            return 0 + i6;
        } else if (i2 <= this.bkN) {
            return 0 - i7;
        } else {
            if (i2 == this.bkO) {
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
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(layoutParams.height, AiAppsFileUtils.GB);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(childMeasureSpec, makeMeasureSpec);
    }

    private void QU() {
        if (this.bkF != null) {
            measureItem(this.bkF);
            this.mFloatViewHeight = this.bkF.getMeasuredHeight();
            this.bkY = this.mFloatViewHeight / 2;
        }
    }

    protected boolean onDragTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        switch (motionEvent.getAction() & 255) {
            case 1:
                if (this.mDragState == 4) {
                    stopDrag(false);
                }
                QR();
                return true;
            case 2:
                Q((int) motionEvent.getX(), (int) motionEvent.getY());
                return true;
            case 3:
                if (this.mDragState == 4) {
                    cancelDrag();
                }
                QR();
                return true;
            default:
                return true;
        }
    }

    public boolean startDrag(int i2, int i3, int i4, int i5) {
        View gy;
        if (!this.blo || this.blp == null || (gy = this.blp.gy(i2)) == null) {
            return false;
        }
        return startDrag(i2, gy, i3, i4, i5);
    }

    public boolean startDrag(int i2, View view, int i3, int i4, int i5) {
        if (this.mDragState == 0 && this.blo && this.bkF == null && view != null && this.bkW) {
            if (this.mListView.getParent() != null) {
                this.mListView.getParent().requestDisallowInterceptTouchEvent(true);
            }
            int headerViewsCount = this.mListView.getHeaderViewsCount() + i2;
            this.bkN = headerViewsCount;
            this.bkO = headerViewsCount;
            this.bkQ = headerViewsCount;
            this.bkM = headerViewsCount;
            this.mDragState = 4;
            this.blm = 0;
            this.blm |= i3;
            this.bkF = view;
            QU();
            this.bkR = i4;
            this.bkS = i5;
            this.bll = this.mY;
            this.bkG.x = this.mX - this.bkR;
            this.bkG.y = this.mY - this.bkS;
            View childAt = this.mListView.getChildAt(this.bkQ - this.mListView.getFirstVisiblePosition());
            if (childAt != null) {
                childAt.setVisibility(4);
            }
            if (this.blv) {
                this.blw.startTracking();
            }
            switch (this.blr) {
                case 1:
                    this.blE.onTouchEvent(this.blq);
                    break;
                case 2:
                    this.blE.onInterceptTouchEvent(this.blq);
                    break;
            }
            this.mListView.requestLayout();
            if (this.blA != null) {
                this.blA.start();
                return true;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cT(boolean z) {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition() + (this.mListView.getChildCount() / 2);
        View childAt = this.mListView.getChildAt(this.mListView.getChildCount() / 2);
        if (childAt != null) {
            h(firstVisiblePosition, childAt, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i2, View view, boolean z) {
        this.mBlockLayoutRequests = true;
        QV();
        int i3 = this.bkN;
        int i4 = this.bkO;
        boolean QM = QM();
        if (QM) {
            QT();
            this.mListView.setSelectionFromTop(i2, (b(i2, view, i3, i4) + view.getTop()) - this.mListView.getPaddingTop());
            layoutChildren();
        }
        if (QM || z) {
            this.mListView.invalidate();
        }
        this.mBlockLayoutRequests = false;
    }

    private void QV() {
        if (this.blp != null) {
            this.bkH.set(this.mX, this.mY);
            this.blp.b(this.bkF, this.bkG, this.bkH);
        }
        int i2 = this.bkG.x;
        int i3 = this.bkG.y;
        int paddingLeft = this.mListView.getPaddingLeft();
        if ((this.blm & 1) == 0 && i2 > paddingLeft) {
            this.bkG.x = paddingLeft;
        } else if ((this.blm & 2) == 0 && i2 < paddingLeft) {
            this.bkG.x = paddingLeft;
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int lastVisiblePosition = this.mListView.getLastVisiblePosition();
        int paddingTop = this.mListView.getPaddingTop();
        if (firstVisiblePosition < headerViewsCount) {
            paddingTop = this.mListView.getChildAt((headerViewsCount - firstVisiblePosition) - 1).getBottom();
        }
        if ((this.blm & 8) == 0 && firstVisiblePosition <= this.bkQ) {
            paddingTop = Math.max(this.mListView.getChildAt(this.bkQ - firstVisiblePosition).getTop(), paddingTop);
        }
        int height = this.mListView.getHeight() - this.mListView.getPaddingBottom();
        if (lastVisiblePosition >= (this.mListView.getCount() - footerViewsCount) - 1) {
            height = this.mListView.getChildAt(((this.mListView.getCount() - footerViewsCount) - 1) - firstVisiblePosition).getBottom();
        }
        if ((this.blm & 4) == 0 && lastVisiblePosition >= this.bkQ) {
            height = Math.min(this.mListView.getChildAt(this.bkQ - firstVisiblePosition).getBottom(), height);
        }
        if (i3 < paddingTop) {
            this.bkG.y = paddingTop;
        } else if (this.mFloatViewHeight + i3 > height) {
            this.bkG.y = height - this.mFloatViewHeight;
        }
        this.bkI = this.bkG.y + this.bkY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QW() {
        if (this.bkF != null) {
            this.bkF.setVisibility(8);
            if (this.blp != null) {
                this.blp.af(this.bkF);
            }
            this.bkF = null;
            this.mListView.invalidate();
        }
    }

    public void a(h hVar) {
        this.blp = hVar;
    }

    public void a(b bVar) {
        this.bkT = bVar;
    }

    public void setDragEnabled(boolean z) {
        this.bkW = z;
    }

    public boolean isDragEnabled() {
        return this.bkW;
    }

    public void a(g gVar) {
        this.bkU = gVar;
    }

    public void a(l lVar) {
        this.bkV = lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class i {
        private SparseIntArray blZ;
        private ArrayList<Integer> bma;
        private int mMaxSize;

        public i(int i) {
            this.blZ = new SparseIntArray(i);
            this.bma = new ArrayList<>(i);
            this.mMaxSize = i;
        }

        public void add(int i, int i2) {
            int i3 = this.blZ.get(i, -1);
            if (i3 != i2) {
                if (i3 == -1) {
                    if (this.blZ.size() == this.mMaxSize) {
                        this.blZ.delete(this.bma.remove(0).intValue());
                    }
                } else {
                    this.bma.remove(Integer.valueOf(i));
                }
                this.blZ.put(i, i2);
                this.bma.add(Integer.valueOf(i));
            }
        }

        public int get(int i) {
            return this.blZ.get(i, -1);
        }

        public void clear() {
            this.blZ.clear();
            this.bma.clear();
        }
    }

    /* renamed from: com.baidu.tbadk.widget.dragsort.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0177a extends BaseAdapter {
        private ListAdapter mAdapter;

        public C0177a(ListAdapter listAdapter) {
            this.mAdapter = listAdapter;
            this.mAdapter.registerDataSetObserver(new DataSetObserver() { // from class: com.baidu.tbadk.widget.dragsort.a.a.1
                @Override // android.database.DataSetObserver
                public void onChanged() {
                    C0177a.this.notifyDataSetChanged();
                }

                @Override // android.database.DataSetObserver
                public void onInvalidated() {
                    C0177a.this.notifyDataSetInvalidated();
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
        private float bmk;
        private float mA;
        private float mAlpha;
        private float mB;
        private float mC;
        private boolean mCanceled;
        private float mD;
        protected long mStartTime;

        public m(float f, int i) {
            this.mAlpha = f;
            this.bmk = i;
            float f2 = 1.0f / ((this.mAlpha * 2.0f) * (1.0f - this.mAlpha));
            this.mD = f2;
            this.mA = f2;
            this.mB = this.mAlpha / ((this.mAlpha - 1.0f) * 2.0f);
            this.mC = 1.0f / (1.0f - this.mAlpha);
        }

        public float ab(float f) {
            if (f < this.mAlpha) {
                return this.mA * f * f;
            }
            if (f < 1.0f - this.mAlpha) {
                return this.mB + (this.mC * f);
            }
            return 1.0f - ((this.mD * (f - 1.0f)) * (f - 1.0f));
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

        public void q(float f, float f2) {
        }

        public void onStop() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.mCanceled) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / this.bmk;
                if (uptimeMillis >= 1.0f) {
                    q(1.0f, 1.0f);
                    onStop();
                    return;
                }
                q(uptimeMillis, ab(uptimeMillis));
                a.this.mListView.post(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class f extends m {
        private int blV;
        private int blW;
        private float blX;
        private float blY;

        public f(float f, int i) {
            super(f, i);
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.blV = a.this.bkM;
            this.blW = a.this.bkQ;
            a.this.mDragState = 2;
            this.blX = a.this.bkG.y - QZ();
            this.blY = a.this.bkG.x - a.this.mListView.getPaddingLeft();
        }

        private int QZ() {
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            int dividerHeight = (a.this.bkX + a.this.mListView.getDividerHeight()) / 2;
            View childAt = a.this.mListView.getChildAt(this.blV - firstVisiblePosition);
            if (childAt != null) {
                if (this.blV == this.blW) {
                    return childAt.getTop();
                }
                if (this.blV >= this.blW) {
                    return (childAt.getBottom() + dividerHeight) - a.this.mFloatViewHeight;
                }
                return childAt.getTop() - dividerHeight;
            }
            cancel();
            return -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void q(float f, float f2) {
            int QZ = QZ();
            float paddingLeft = a.this.bkG.x - a.this.mListView.getPaddingLeft();
            float f3 = 1.0f - f2;
            if (f3 < Math.abs((a.this.bkG.y - QZ) / this.blX) || f3 < Math.abs(paddingLeft / this.blY)) {
                a.this.bkG.y = QZ + ((int) (this.blX * f3));
                a.this.bkG.x = a.this.mListView.getPaddingLeft() + ((int) (this.blY * f3));
                a.this.cT(true);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.QO();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class k extends m {
        private int blW;
        private float bmd;
        private float bme;
        private float bmf;
        private int bmg;
        private int bmh;
        private int bmi;
        private int bmj;

        public k(float f, int i) {
            super(f, i);
            this.bmg = -1;
            this.bmh = -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.bmg = -1;
            this.bmh = -1;
            this.bmi = a.this.bkN;
            this.bmj = a.this.bkO;
            this.blW = a.this.bkQ;
            a.this.mDragState = 1;
            this.bmd = a.this.bkG.x;
            if (a.this.blC) {
                float width = a.this.mListView.getWidth() * 2.0f;
                if (a.this.blD == 0.0f) {
                    a.this.blD = (this.bmd >= 0.0f ? 1 : -1) * width;
                    return;
                }
                float f = width * 2.0f;
                if (a.this.blD >= 0.0f || a.this.blD <= (-f)) {
                    if (a.this.blD > 0.0f && a.this.blD < f) {
                        a.this.blD = f;
                        return;
                    }
                    return;
                }
                a.this.blD = -f;
                return;
            }
            a.this.QW();
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void q(float f, float f2) {
            View childAt;
            float f3 = 1.0f - f2;
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            View childAt2 = a.this.mListView.getChildAt(this.bmi - firstVisiblePosition);
            if (a.this.blC) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / 1000.0f;
                if (uptimeMillis != 0.0f) {
                    float f4 = a.this.blD * uptimeMillis;
                    int width = a.this.mListView.getWidth();
                    a.this.blD = ((a.this.blD > 0.0f ? 1 : -1) * uptimeMillis * width) + a.this.blD;
                    this.bmd += f4;
                    a.this.bkG.x = (int) this.bmd;
                    if (this.bmd < width && this.bmd > (-width)) {
                        this.mStartTime = SystemClock.uptimeMillis();
                        a.this.cT(true);
                        return;
                    }
                } else {
                    return;
                }
            }
            if (childAt2 != null) {
                if (this.bmg == -1) {
                    this.bmg = a.this.f(this.bmi, childAt2, false);
                    this.bme = childAt2.getHeight() - this.bmg;
                }
                int max = Math.max((int) (this.bme * f3), 1);
                ViewGroup.LayoutParams layoutParams = childAt2.getLayoutParams();
                layoutParams.height = max + this.bmg;
                childAt2.setLayoutParams(layoutParams);
            }
            if (this.bmj != this.bmi && (childAt = a.this.mListView.getChildAt(this.bmj - firstVisiblePosition)) != null) {
                if (this.bmh == -1) {
                    this.bmh = a.this.f(this.bmj, childAt, false);
                    this.bmf = childAt.getHeight() - this.bmh;
                }
                int max2 = Math.max((int) (this.bmf * f3), 1);
                ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
                layoutParams2.height = max2 + this.bmh;
                childAt.setLayoutParams(layoutParams2);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.QP();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class j extends m {
        final /* synthetic */ a blI;
        private float bmb;
        private float bmc;

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.bmb = this.blI.bkS;
            this.bmc = this.blI.bkY;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void q(float f, float f2) {
            if (this.blI.mDragState != 4) {
                cancel();
                return;
            }
            this.blI.bkS = (int) ((this.bmc * f2) + ((1.0f - f2) * this.bmb));
            this.blI.bkG.y = this.blI.mY - this.blI.bkS;
            this.blI.cT(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e {
        StringBuilder mBuilder = new StringBuilder();
        private int blS = 0;
        private int blT = 0;
        private boolean blU = false;
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
            this.blT = 0;
            this.blU = true;
        }

        public void QY() {
            if (this.blU) {
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
                this.mBuilder.append("    <FirstExpPos>").append(a.this.bkN).append("</FirstExpPos>\n");
                this.mBuilder.append("    <FirstExpBlankHeight>").append(a.this.gu(a.this.bkN) - a.this.gw(a.this.bkN)).append("</FirstExpBlankHeight>\n");
                this.mBuilder.append("    <SecondExpPos>").append(a.this.bkO).append("</SecondExpPos>\n");
                this.mBuilder.append("    <SecondExpBlankHeight>").append(a.this.gu(a.this.bkO) - a.this.gw(a.this.bkO)).append("</SecondExpBlankHeight>\n");
                this.mBuilder.append("    <SrcPos>").append(a.this.bkQ).append("</SrcPos>\n");
                this.mBuilder.append("    <SrcHeight>").append(a.this.mFloatViewHeight + a.this.mListView.getDividerHeight()).append("</SrcHeight>\n");
                this.mBuilder.append("    <ViewHeight>").append(a.this.mListView.getHeight()).append("</ViewHeight>\n");
                this.mBuilder.append("    <LastY>").append(a.this.mLastY).append("</LastY>\n");
                this.mBuilder.append("    <FloatY>").append(a.this.bkI).append("</FloatY>\n");
                this.mBuilder.append("    <ShuffleEdges>");
                for (int i4 = 0; i4 < childCount; i4++) {
                    this.mBuilder.append(a.this.P(firstVisiblePosition + i4, a.this.mListView.getChildAt(i4).getTop())).append(",");
                }
                this.mBuilder.append("</ShuffleEdges>\n");
                this.mBuilder.append("</DSLVState>\n");
                this.blS++;
                if (this.blS > 1000) {
                    flush();
                    this.blS = 0;
                }
            }
        }

        public void flush() {
            if (this.blU) {
                try {
                    FileWriter fileWriter = new FileWriter(this.mFile, this.blT != 0);
                    fileWriter.write(this.mBuilder.toString());
                    this.mBuilder.delete(0, this.mBuilder.length());
                    fileWriter.flush();
                    fileWriter.close();
                    this.blT++;
                } catch (IOException e) {
                }
            }
        }

        public void ok() {
            if (this.blU) {
                this.mBuilder.append("</DSLVStates>\n");
                flush();
                this.blU = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements Runnable {
        private boolean blL;
        private long blM;
        private long blN;
        private float blO;
        private long blP;
        private int blQ;
        private float blR;
        private int dy;
        private boolean mScrolling = false;

        public boolean isScrolling() {
            return this.mScrolling;
        }

        public int QX() {
            if (this.mScrolling) {
                return this.blQ;
            }
            return -1;
        }

        public d() {
        }

        public void gx(int i) {
            if (!this.mScrolling) {
                this.blL = false;
                this.mScrolling = true;
                this.blP = SystemClock.uptimeMillis();
                this.blM = this.blP;
                this.blQ = i;
                a.this.mListView.post(this);
            }
        }

        public void cU(boolean z) {
            if (z) {
                a.this.mListView.removeCallbacks(this);
                this.mScrolling = false;
                return;
            }
            this.blL = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.blL) {
                int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
                int lastVisiblePosition = a.this.mListView.getLastVisiblePosition();
                int count = a.this.mListView.getCount();
                int paddingTop = a.this.mListView.getPaddingTop();
                int height = (a.this.mListView.getHeight() - paddingTop) - a.this.mListView.getPaddingBottom();
                int min = Math.min(a.this.mY, a.this.bkI + a.this.bkY);
                int max = Math.max(a.this.mY, a.this.bkI - a.this.bkY);
                if (this.blQ == 0) {
                    View childAt = a.this.mListView.getChildAt(0);
                    if (childAt == null) {
                        this.mScrolling = false;
                        return;
                    } else if (firstVisiblePosition == 0 && childAt.getTop() == paddingTop) {
                        this.mScrolling = false;
                        return;
                    } else {
                        this.blR = a.this.blk.b((a.this.blg - max) / a.this.blh, this.blM);
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
                        this.blR = -a.this.blk.b((min - a.this.blf) / a.this.bli, this.blM);
                    }
                }
                this.blN = SystemClock.uptimeMillis();
                this.blO = (float) (this.blN - this.blM);
                this.dy = Math.round(this.blR * this.blO);
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
                this.blM = this.blN;
                a.this.mListView.post(this);
                return;
            }
            this.mScrolling = false;
        }
    }
}
