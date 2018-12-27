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
    private View bkI;
    private int bkL;
    private int bkP;
    private int bkQ;
    private int bkR;
    private int bkT;
    private int bkU;
    private int bkV;
    private b bkW;
    private g bkX;
    private l bkY;
    private k blC;
    private j blD;
    private f blE;
    private boolean blF;
    private com.baidu.tbadk.widget.dragsort.d blH;
    private com.baidu.tbadk.widget.dragsort.b blI;
    private int blb;
    private d bld;
    private int blg;
    private int blh;
    private float bli;
    private float blj;
    private float blk;
    private float bll;
    private int blo;
    private MotionEvent blt;
    private C0177a blx;
    private e blz;
    private int mFloatViewHeight;
    private int mLastX;
    private int mLastY;
    private ListView mListView;
    private DataSetObserver mObserver;
    private int mOffsetX;
    private int mOffsetY;
    private int mX;
    private int mY;
    private Point bkJ = new Point();
    private Point bkK = new Point();
    private boolean bkM = false;
    private float bkN = 1.0f;
    private float bkO = 1.0f;
    private boolean bkS = false;
    private boolean bkZ = true;
    private int mDragState = 0;
    private int bla = 1;
    private int mWidthMeasureSpec = 0;
    private View[] blc = new View[1];
    private float ble = 0.33333334f;
    private float blf = 0.33333334f;
    private float blm = 0.5f;
    private c bln = new c() { // from class: com.baidu.tbadk.widget.dragsort.a.1
        @Override // com.baidu.tbadk.widget.dragsort.a.c
        public float b(float f2, long j2) {
            return a.this.blm * f2;
        }
    };
    private int blp = 0;
    private boolean blq = false;
    private boolean blr = false;
    private h bls = null;
    private int blu = 0;
    private float blv = 0.25f;
    private float blw = 0.0f;
    private boolean bly = false;
    private boolean mBlockLayoutRequests = false;
    private boolean blA = false;
    private i blB = new i(3);
    private float blG = 0.0f;
    private boolean blJ = false;
    private boolean blK = false;

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

        View gz(int i);
    }

    /* loaded from: classes.dex */
    public interface l {
        void remove(int i);
    }

    public a(ListView listView, com.baidu.tbadk.widget.dragsort.d dVar) {
        this.blH = dVar;
        this.mListView = listView;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            this.blx = new C0177a(listAdapter);
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
            this.blx = null;
        }
        this.blH.setAdapter(this.blx);
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
            if (i2 > this.bkT) {
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
    public int gv(int i2) {
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        return childAt != null ? childAt.getHeight() : R(i2, gx(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int P(int i2, int i3) {
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        if (i2 <= headerViewsCount || i2 >= this.mListView.getCount() - footerViewsCount) {
            return i3;
        }
        int dividerHeight = this.mListView.getDividerHeight();
        int i4 = this.mFloatViewHeight - this.bla;
        int gx = gx(i2);
        int gv = gv(i2);
        if (this.bkR <= this.bkT) {
            if (i2 == this.bkR && this.bkQ != this.bkR) {
                if (i2 == this.bkT) {
                    i3 = (i3 + gv) - this.mFloatViewHeight;
                } else {
                    i3 = ((gv - gx) + i3) - i4;
                }
            } else if (i2 > this.bkR && i2 <= this.bkT) {
                i3 -= i4;
            }
        } else if (i2 > this.bkT && i2 <= this.bkQ) {
            i3 += i4;
        } else if (i2 == this.bkR && this.bkQ != this.bkR) {
            i3 += gv - gx;
        }
        if (i2 <= this.bkT) {
            return (((this.mFloatViewHeight - dividerHeight) - gx(i2 - 1)) / 2) + i3;
        }
        return (((gx - dividerHeight) - this.mFloatViewHeight) / 2) + i3;
    }

    private boolean QO() {
        int i2;
        int i3;
        int i4;
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int i5 = this.bkQ;
        View childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        if (childAt == null) {
            i5 = firstVisiblePosition + (this.mListView.getChildCount() / 2);
            childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        }
        int top = childAt.getTop();
        int height = childAt.getHeight();
        int P = P(i5, top);
        int dividerHeight = this.mListView.getDividerHeight();
        if (this.bkL >= P) {
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
                    i6 = gv(i3 + 1);
                    i2 = P(i3 + 1, i7);
                    if (this.bkL < i2) {
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
                int gv = gv(i3);
                if (i3 == 0) {
                    i2 = (i8 - dividerHeight) - gv;
                    break;
                }
                i8 -= gv + dividerHeight;
                i2 = P(i3, i8);
                if (this.bkL >= i2) {
                    break;
                }
                i4 = i2;
            }
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int i9 = this.bkQ;
        int i10 = this.bkR;
        float f2 = this.blw;
        if (this.bkS) {
            int abs = Math.abs(i2 - i4);
            if (this.bkL >= i2) {
                int i11 = i4;
                i4 = i2;
                i2 = i11;
            }
            int i12 = (int) (abs * this.blv * 0.5f);
            float f3 = i12;
            int i13 = i4 + i12;
            int i14 = i2 - i12;
            if (this.bkL < i13) {
                this.bkQ = i3 - 1;
                this.bkR = i3;
                this.blw = ((i13 - this.bkL) * 0.5f) / f3;
            } else if (this.bkL < i14) {
                this.bkQ = i3;
                this.bkR = i3;
            } else {
                this.bkQ = i3;
                this.bkR = i3 + 1;
                this.blw = (1.0f + ((i2 - this.bkL) / f3)) * 0.5f;
            }
        } else {
            this.bkQ = i3;
            this.bkR = i3;
        }
        if (this.bkQ < headerViewsCount) {
            this.bkQ = headerViewsCount;
            this.bkR = headerViewsCount;
            i3 = headerViewsCount;
        } else if (this.bkR >= this.mListView.getCount() - footerViewsCount) {
            i3 = (this.mListView.getCount() - footerViewsCount) - 1;
            this.bkQ = i3;
            this.bkR = i3;
        }
        boolean z = (this.bkQ == i9 && this.bkR == i10 && this.blw == f2) ? false : true;
        if (i3 != this.bkP) {
            if (this.bkW != null) {
                this.bkW.drag(this.bkP - headerViewsCount, i3 - headerViewsCount);
            }
            this.bkP = i3;
            return true;
        }
        return z;
    }

    public void removeItem(int i2) {
        this.blF = false;
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
            this.bla = Math.max(1, obtainStyledAttributes.getDimensionPixelSize(e.l.DragSort_collapsed_height, 1));
            this.bly = obtainStyledAttributes.getBoolean(e.l.DragSort_track_drag_sort, false);
            if (this.bly) {
                this.blz = new e();
            }
            this.bkN = obtainStyledAttributes.getFloat(e.l.DragSort_float_alpha, this.bkN);
            this.bkO = this.bkN;
            this.bkZ = obtainStyledAttributes.getBoolean(e.l.DragSort_drag_enabled, this.bkZ);
            this.blv = Math.max(0.0f, Math.min(1.0f, 1.0f - obtainStyledAttributes.getFloat(e.l.DragSort_slide_shuffle_speed, 0.75f)));
            this.bkS = this.blv > 0.0f;
            setDragScrollStart(obtainStyledAttributes.getFloat(e.l.DragSort_drag_scroll_start, this.ble));
            this.blm = obtainStyledAttributes.getFloat(e.l.DragSort_max_drag_scroll_speed, this.blm);
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
                this.bls = bVar;
                a(bVar);
            }
            obtainStyledAttributes.recycle();
            i2 = i5;
            i3 = i4;
        }
        this.bld = new d();
        if (i3 > 0) {
            this.blC = new k(0.5f, i3);
        }
        if (i2 > 0) {
            this.blE = new f(0.5f, i2);
        }
        this.blt = MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
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
        this.blI = bVar;
        this.mListView.setOnTouchListener(bVar);
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void dispatchDraw(Canvas canvas) {
        float f2;
        this.blH.dispatchDraw(canvas);
        if (this.mDragState != 0) {
            if (this.bkQ != this.bkT) {
                b(this.bkQ, canvas);
            }
            if (this.bkR != this.bkQ && this.bkR != this.bkT) {
                b(this.bkR, canvas);
            }
        }
        if (this.bkI != null) {
            int width = this.bkI.getWidth();
            int height = this.bkI.getHeight();
            int i2 = this.bkJ.x;
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
            int i3 = (int) (f2 * 255.0f * this.bkO);
            canvas.save();
            canvas.translate(this.bkJ.x, this.bkJ.y);
            canvas.clipRect(0, 0, width, height);
            canvas.saveLayerAlpha(0.0f, 0.0f, width, height, i3, 31);
            this.bkI.draw(canvas);
            canvas.restore();
            canvas.restore();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onDraw(Canvas canvas) {
        this.blH.onDraw(canvas);
        if (this.bly) {
            this.blz.Ra();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.blA) {
            this.blA = false;
            return false;
        } else if (!this.bkZ) {
            return this.blH.onTouchEvent(motionEvent);
        } else {
            boolean z2 = this.blq;
            this.blq = false;
            if (!z2) {
                u(motionEvent);
            }
            if (this.mDragState == 4) {
                onDragTouchEvent(motionEvent);
                return true;
            }
            if (this.mDragState == 0 && this.blH.onTouchEvent(motionEvent)) {
                z = true;
            }
            switch (motionEvent.getAction() & 255) {
                case 1:
                case 3:
                    QT();
                    return z;
                case 2:
                default:
                    if (z) {
                        this.blu = 1;
                        return z;
                    }
                    return z;
            }
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (!this.bkZ) {
            return this.blH.onInterceptTouchEvent(motionEvent);
        }
        if (this.blI != null) {
            this.blI.Rc().onTouchEvent(motionEvent);
        }
        u(motionEvent);
        this.blq = true;
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            if (this.mDragState != 0) {
                this.blA = true;
                return true;
            }
            this.blr = true;
        }
        if (this.bkI == null) {
            if (this.blH.onInterceptTouchEvent(motionEvent)) {
                this.blJ = true;
                z = true;
            } else {
                z = false;
            }
            switch (action) {
                case 1:
                case 3:
                    QT();
                    break;
                case 2:
                default:
                    if (z) {
                        this.blu = 1;
                        break;
                    } else {
                        this.blu = 2;
                        break;
                    }
            }
        } else {
            z = true;
        }
        if (action == 1 || action == 3) {
            this.blr = false;
        }
        return z;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        this.blH.onSizeChanged(i2, i3, i4, i5);
        QU();
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void requestLayout() {
        if (!this.mBlockLayoutRequests) {
            this.blH.requestLayout();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onMeasure(int i2, int i3) {
        this.blH.onMeasure(i2, i3);
        if (this.bkI != null) {
            if (this.bkI.isLayoutRequested()) {
                QW();
            }
            this.bkM = true;
        }
        this.mWidthMeasureSpec = i2;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void layoutChildren() {
        this.blH.layoutChildren();
        if (this.bkI != null) {
            if (this.bkI.isLayoutRequested() && !this.bkM) {
                QW();
            }
            this.bkI.layout(0, 0, this.bkI.getMeasuredWidth(), this.bkI.getMeasuredHeight());
            this.bkM = false;
        }
    }

    public void removeItem(int i2, float f2) {
        if (this.mDragState == 0 || this.mDragState == 4) {
            if (this.mDragState == 0) {
                this.bkT = this.mListView.getHeaderViewsCount() + i2;
                this.bkQ = this.bkT;
                this.bkR = this.bkT;
                this.bkP = this.bkT;
                View childAt = this.mListView.getChildAt(this.bkT - this.mListView.getFirstVisiblePosition());
                if (childAt != null) {
                    childAt.setVisibility(4);
                }
            }
            this.mDragState = 1;
            this.blG = f2;
            if (this.blr) {
                switch (this.blu) {
                    case 1:
                        this.blH.onTouchEvent(this.blt);
                        break;
                    case 2:
                        this.blH.onInterceptTouchEvent(this.blt);
                        break;
                }
            }
            if (this.blC != null) {
                this.blC.start();
            } else {
                gw(i2);
            }
        }
    }

    public void cancelDrag() {
        if (this.mDragState == 4) {
            this.bld.cU(true);
            QY();
            QP();
            QV();
            if (this.blr) {
                this.mDragState = 3;
            } else {
                this.mDragState = 0;
            }
        }
    }

    private void QP() {
        this.bkT = -1;
        this.bkQ = -1;
        this.bkR = -1;
        this.bkP = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QQ() {
        this.mDragState = 2;
        if (this.bkX != null && this.bkP >= 0 && this.bkP < this.mListView.getCount()) {
            int headerViewsCount = this.mListView.getHeaderViewsCount();
            this.bkX.drop(this.bkT - headerViewsCount, this.bkP - headerViewsCount);
        }
        QY();
        QS();
        QP();
        QV();
        if (this.blr) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QR() {
        gw(this.bkT - this.mListView.getHeaderViewsCount());
    }

    private void gw(int i2) {
        this.mDragState = 1;
        if (this.bkY != null) {
            this.bkY.remove(i2);
        }
        QY();
        QS();
        QP();
        if (this.blr) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    private void QS() {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        if (this.bkT < firstVisiblePosition) {
            View childAt = this.mListView.getChildAt(0);
            this.mListView.setSelectionFromTop(firstVisiblePosition - 1, (childAt != null ? childAt.getTop() : 0) - this.mListView.getPaddingTop());
        }
    }

    public boolean stopDrag(boolean z) {
        this.blF = false;
        return stopDrag(z, 0.0f);
    }

    public boolean stopDragWithVelocity(boolean z, float f2) {
        this.blF = true;
        return stopDrag(z, f2);
    }

    public boolean stopDrag(boolean z, float f2) {
        if (this.bkI != null) {
            this.bld.cU(true);
            if (z) {
                removeItem(this.bkT - this.mListView.getHeaderViewsCount(), f2);
            } else if (this.blE != null) {
                this.blE.start();
            } else {
                QQ();
            }
            if (this.bly) {
                this.blz.ok();
                return true;
            }
            return true;
        }
        return false;
    }

    private void QT() {
        this.blu = 0;
        this.blr = false;
        if (this.mDragState == 3) {
            this.mDragState = 0;
        }
        this.bkO = this.bkN;
        this.blJ = false;
        this.blB.clear();
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
        return this.blJ;
    }

    public void setDragScrollStart(float f2) {
        setDragScrollStarts(f2, f2);
    }

    public void setDragScrollStarts(float f2, float f3) {
        if (f3 > 0.5f) {
            this.blf = 0.5f;
        } else {
            this.blf = f3;
        }
        if (f2 > 0.5f) {
            this.ble = 0.5f;
        } else {
            this.ble = f2;
        }
        if (this.mListView.getHeight() != 0) {
            QU();
        }
    }

    private void Q(int i2, int i3) {
        this.bkJ.x = i2 - this.bkU;
        this.bkJ.y = i3 - this.bkV;
        cT(true);
        int min = Math.min(i3, this.bkL + this.blb);
        int max = Math.max(i3, this.bkL - this.blb);
        int QZ = this.bld.QZ();
        if (min > this.mLastY && min > this.blh && QZ != 1) {
            if (QZ != -1) {
                this.bld.cU(true);
            }
            this.bld.gy(1);
        } else if (max < this.mLastY && max < this.blg && QZ != 0) {
            if (QZ != -1) {
                this.bld.cU(true);
            }
            this.bld.gy(0);
        } else if (max >= this.blg && min <= this.blh && this.bld.isScrolling()) {
            this.bld.cU(true);
        }
    }

    private void QU() {
        int height;
        int paddingTop = this.mListView.getPaddingTop();
        float height2 = (this.mListView.getHeight() - paddingTop) - this.mListView.getPaddingBottom();
        this.blj = paddingTop + (this.ble * height2);
        this.bli = (height2 * (1.0f - this.blf)) + paddingTop;
        this.blg = (int) this.blj;
        this.blh = (int) this.bli;
        this.blk = this.blj - paddingTop;
        this.bll = (paddingTop + height) - this.bli;
    }

    private void QV() {
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
        if (i2 != this.bkT && i2 != this.bkQ && i2 != this.bkR) {
            g2 = -2;
        } else {
            g2 = g(i2, view, z);
        }
        if (g2 != layoutParams.height) {
            layoutParams.height = g2;
            view.setLayoutParams(layoutParams);
        }
        if (i2 == this.bkQ || i2 == this.bkR) {
            if (i2 < this.bkT) {
                ((DragSortItemView) view).setGravity(80);
            } else if (i2 > this.bkT) {
                ((DragSortItemView) view).setGravity(48);
            }
        }
        int visibility = view.getVisibility();
        int i3 = 0;
        if (i2 == this.bkT && this.bkI != null) {
            i3 = 4;
        }
        if (i3 != visibility) {
            view.setVisibility(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int gx(int i2) {
        View view;
        if (i2 == this.bkT) {
            return 0;
        }
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        if (childAt != null) {
            return f(i2, childAt, false);
        }
        int i3 = this.blB.get(i2);
        if (i3 == -1) {
            ListAdapter adapter = this.mListView.getAdapter();
            int itemViewType = adapter.getItemViewType(i2);
            int viewTypeCount = adapter.getViewTypeCount();
            if (viewTypeCount != this.blc.length) {
                this.blc = new View[viewTypeCount];
            }
            if (itemViewType >= 0) {
                if (this.blc[itemViewType] == null) {
                    view = adapter.getView(i2, null, this.mListView);
                    this.blc[itemViewType] = view;
                } else {
                    view = adapter.getView(i2, this.blc[itemViewType], this.mListView);
                }
            } else {
                view = adapter.getView(i2, null, this.mListView);
            }
            int f2 = f(i2, view, true);
            this.blB.add(i2, f2);
            return f2;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(int i2, View view, boolean z) {
        if (i2 == this.bkT) {
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
        boolean z = this.bkS && this.bkQ != this.bkR;
        int i4 = this.mFloatViewHeight - this.bla;
        int i5 = (int) (this.blw * i4);
        if (i2 == this.bkT) {
            if (this.bkT == this.bkQ) {
                if (z) {
                    return i5 + this.bla;
                }
                return this.mFloatViewHeight;
            } else if (this.bkT == this.bkR) {
                return this.mFloatViewHeight - i5;
            } else {
                return this.bla;
            }
        } else if (i2 == this.bkQ) {
            if (z) {
                return i3 + i5;
            }
            return i3 + i4;
        } else if (i2 == this.bkR) {
            return (i3 + i4) - i5;
        } else {
            return i3;
        }
    }

    private int b(int i2, View view, int i3, int i4) {
        int i5;
        int i6;
        int gx = gx(i2);
        int height = view.getHeight();
        int R = R(i2, gx);
        if (i2 != this.bkT) {
            i6 = height - gx;
            i5 = R - gx;
        } else {
            i5 = R;
            i6 = height;
        }
        int i7 = this.mFloatViewHeight;
        if (this.bkT != this.bkQ && this.bkT != this.bkR) {
            i7 -= this.bla;
        }
        if (i2 <= i3) {
            if (i2 > this.bkQ) {
                return (i7 - i5) + 0;
            }
        } else if (i2 == i4) {
            if (i2 <= this.bkQ) {
                return (i6 - i7) + 0;
            }
            if (i2 == this.bkR) {
                return (height - R) + 0;
            }
            return 0 + i6;
        } else if (i2 <= this.bkQ) {
            return 0 - i7;
        } else {
            if (i2 == this.bkR) {
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

    private void QW() {
        if (this.bkI != null) {
            measureItem(this.bkI);
            this.mFloatViewHeight = this.bkI.getMeasuredHeight();
            this.blb = this.mFloatViewHeight / 2;
        }
    }

    protected boolean onDragTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        switch (motionEvent.getAction() & 255) {
            case 1:
                if (this.mDragState == 4) {
                    stopDrag(false);
                }
                QT();
                return true;
            case 2:
                Q((int) motionEvent.getX(), (int) motionEvent.getY());
                return true;
            case 3:
                if (this.mDragState == 4) {
                    cancelDrag();
                }
                QT();
                return true;
            default:
                return true;
        }
    }

    public boolean startDrag(int i2, int i3, int i4, int i5) {
        View gz;
        if (!this.blr || this.bls == null || (gz = this.bls.gz(i2)) == null) {
            return false;
        }
        return startDrag(i2, gz, i3, i4, i5);
    }

    public boolean startDrag(int i2, View view, int i3, int i4, int i5) {
        if (this.mDragState == 0 && this.blr && this.bkI == null && view != null && this.bkZ) {
            if (this.mListView.getParent() != null) {
                this.mListView.getParent().requestDisallowInterceptTouchEvent(true);
            }
            int headerViewsCount = this.mListView.getHeaderViewsCount() + i2;
            this.bkQ = headerViewsCount;
            this.bkR = headerViewsCount;
            this.bkT = headerViewsCount;
            this.bkP = headerViewsCount;
            this.mDragState = 4;
            this.blp = 0;
            this.blp |= i3;
            this.bkI = view;
            QW();
            this.bkU = i4;
            this.bkV = i5;
            this.blo = this.mY;
            this.bkJ.x = this.mX - this.bkU;
            this.bkJ.y = this.mY - this.bkV;
            View childAt = this.mListView.getChildAt(this.bkT - this.mListView.getFirstVisiblePosition());
            if (childAt != null) {
                childAt.setVisibility(4);
            }
            if (this.bly) {
                this.blz.startTracking();
            }
            switch (this.blu) {
                case 1:
                    this.blH.onTouchEvent(this.blt);
                    break;
                case 2:
                    this.blH.onInterceptTouchEvent(this.blt);
                    break;
            }
            this.mListView.requestLayout();
            if (this.blD != null) {
                this.blD.start();
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
        QX();
        int i3 = this.bkQ;
        int i4 = this.bkR;
        boolean QO = QO();
        if (QO) {
            QV();
            this.mListView.setSelectionFromTop(i2, (b(i2, view, i3, i4) + view.getTop()) - this.mListView.getPaddingTop());
            layoutChildren();
        }
        if (QO || z) {
            this.mListView.invalidate();
        }
        this.mBlockLayoutRequests = false;
    }

    private void QX() {
        if (this.bls != null) {
            this.bkK.set(this.mX, this.mY);
            this.bls.b(this.bkI, this.bkJ, this.bkK);
        }
        int i2 = this.bkJ.x;
        int i3 = this.bkJ.y;
        int paddingLeft = this.mListView.getPaddingLeft();
        if ((this.blp & 1) == 0 && i2 > paddingLeft) {
            this.bkJ.x = paddingLeft;
        } else if ((this.blp & 2) == 0 && i2 < paddingLeft) {
            this.bkJ.x = paddingLeft;
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int lastVisiblePosition = this.mListView.getLastVisiblePosition();
        int paddingTop = this.mListView.getPaddingTop();
        if (firstVisiblePosition < headerViewsCount) {
            paddingTop = this.mListView.getChildAt((headerViewsCount - firstVisiblePosition) - 1).getBottom();
        }
        if ((this.blp & 8) == 0 && firstVisiblePosition <= this.bkT) {
            paddingTop = Math.max(this.mListView.getChildAt(this.bkT - firstVisiblePosition).getTop(), paddingTop);
        }
        int height = this.mListView.getHeight() - this.mListView.getPaddingBottom();
        if (lastVisiblePosition >= (this.mListView.getCount() - footerViewsCount) - 1) {
            height = this.mListView.getChildAt(((this.mListView.getCount() - footerViewsCount) - 1) - firstVisiblePosition).getBottom();
        }
        if ((this.blp & 4) == 0 && lastVisiblePosition >= this.bkT) {
            height = Math.min(this.mListView.getChildAt(this.bkT - firstVisiblePosition).getBottom(), height);
        }
        if (i3 < paddingTop) {
            this.bkJ.y = paddingTop;
        } else if (this.mFloatViewHeight + i3 > height) {
            this.bkJ.y = height - this.mFloatViewHeight;
        }
        this.bkL = this.bkJ.y + this.blb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QY() {
        if (this.bkI != null) {
            this.bkI.setVisibility(8);
            if (this.bls != null) {
                this.bls.af(this.bkI);
            }
            this.bkI = null;
            this.mListView.invalidate();
        }
    }

    public void a(h hVar) {
        this.bls = hVar;
    }

    public void a(b bVar) {
        this.bkW = bVar;
    }

    public void setDragEnabled(boolean z) {
        this.bkZ = z;
    }

    public boolean isDragEnabled() {
        return this.bkZ;
    }

    public void a(g gVar) {
        this.bkX = gVar;
    }

    public void a(l lVar) {
        this.bkY = lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class i {
        private SparseIntArray bmc;
        private ArrayList<Integer> bmd;
        private int mMaxSize;

        public i(int i) {
            this.bmc = new SparseIntArray(i);
            this.bmd = new ArrayList<>(i);
            this.mMaxSize = i;
        }

        public void add(int i, int i2) {
            int i3 = this.bmc.get(i, -1);
            if (i3 != i2) {
                if (i3 == -1) {
                    if (this.bmc.size() == this.mMaxSize) {
                        this.bmc.delete(this.bmd.remove(0).intValue());
                    }
                } else {
                    this.bmd.remove(Integer.valueOf(i));
                }
                this.bmc.put(i, i2);
                this.bmd.add(Integer.valueOf(i));
            }
        }

        public int get(int i) {
            return this.bmc.get(i, -1);
        }

        public void clear() {
            this.bmc.clear();
            this.bmd.clear();
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
        private float bmn;
        private float mA;
        private float mAlpha;
        private float mB;
        private float mC;
        private boolean mCanceled;
        private float mD;
        protected long mStartTime;

        public m(float f, int i) {
            this.mAlpha = f;
            this.bmn = i;
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
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / this.bmn;
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
        private int blY;
        private int blZ;
        private float bma;
        private float bmb;

        public f(float f, int i) {
            super(f, i);
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.blY = a.this.bkP;
            this.blZ = a.this.bkT;
            a.this.mDragState = 2;
            this.bma = a.this.bkJ.y - Rb();
            this.bmb = a.this.bkJ.x - a.this.mListView.getPaddingLeft();
        }

        private int Rb() {
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            int dividerHeight = (a.this.bla + a.this.mListView.getDividerHeight()) / 2;
            View childAt = a.this.mListView.getChildAt(this.blY - firstVisiblePosition);
            if (childAt != null) {
                if (this.blY == this.blZ) {
                    return childAt.getTop();
                }
                if (this.blY >= this.blZ) {
                    return (childAt.getBottom() + dividerHeight) - a.this.mFloatViewHeight;
                }
                return childAt.getTop() - dividerHeight;
            }
            cancel();
            return -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void q(float f, float f2) {
            int Rb = Rb();
            float paddingLeft = a.this.bkJ.x - a.this.mListView.getPaddingLeft();
            float f3 = 1.0f - f2;
            if (f3 < Math.abs((a.this.bkJ.y - Rb) / this.bma) || f3 < Math.abs(paddingLeft / this.bmb)) {
                a.this.bkJ.y = Rb + ((int) (this.bma * f3));
                a.this.bkJ.x = a.this.mListView.getPaddingLeft() + ((int) (this.bmb * f3));
                a.this.cT(true);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.QQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class k extends m {
        private int blZ;
        private float bmg;
        private float bmh;
        private float bmi;
        private int bmj;
        private int bmk;
        private int bml;
        private int bmm;

        public k(float f, int i) {
            super(f, i);
            this.bmj = -1;
            this.bmk = -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.bmj = -1;
            this.bmk = -1;
            this.bml = a.this.bkQ;
            this.bmm = a.this.bkR;
            this.blZ = a.this.bkT;
            a.this.mDragState = 1;
            this.bmg = a.this.bkJ.x;
            if (a.this.blF) {
                float width = a.this.mListView.getWidth() * 2.0f;
                if (a.this.blG == 0.0f) {
                    a.this.blG = (this.bmg >= 0.0f ? 1 : -1) * width;
                    return;
                }
                float f = width * 2.0f;
                if (a.this.blG >= 0.0f || a.this.blG <= (-f)) {
                    if (a.this.blG > 0.0f && a.this.blG < f) {
                        a.this.blG = f;
                        return;
                    }
                    return;
                }
                a.this.blG = -f;
                return;
            }
            a.this.QY();
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void q(float f, float f2) {
            View childAt;
            float f3 = 1.0f - f2;
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            View childAt2 = a.this.mListView.getChildAt(this.bml - firstVisiblePosition);
            if (a.this.blF) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / 1000.0f;
                if (uptimeMillis != 0.0f) {
                    float f4 = a.this.blG * uptimeMillis;
                    int width = a.this.mListView.getWidth();
                    a.this.blG = ((a.this.blG > 0.0f ? 1 : -1) * uptimeMillis * width) + a.this.blG;
                    this.bmg += f4;
                    a.this.bkJ.x = (int) this.bmg;
                    if (this.bmg < width && this.bmg > (-width)) {
                        this.mStartTime = SystemClock.uptimeMillis();
                        a.this.cT(true);
                        return;
                    }
                } else {
                    return;
                }
            }
            if (childAt2 != null) {
                if (this.bmj == -1) {
                    this.bmj = a.this.f(this.bml, childAt2, false);
                    this.bmh = childAt2.getHeight() - this.bmj;
                }
                int max = Math.max((int) (this.bmh * f3), 1);
                ViewGroup.LayoutParams layoutParams = childAt2.getLayoutParams();
                layoutParams.height = max + this.bmj;
                childAt2.setLayoutParams(layoutParams);
            }
            if (this.bmm != this.bml && (childAt = a.this.mListView.getChildAt(this.bmm - firstVisiblePosition)) != null) {
                if (this.bmk == -1) {
                    this.bmk = a.this.f(this.bmm, childAt, false);
                    this.bmi = childAt.getHeight() - this.bmk;
                }
                int max2 = Math.max((int) (this.bmi * f3), 1);
                ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
                layoutParams2.height = max2 + this.bmk;
                childAt.setLayoutParams(layoutParams2);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.QR();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class j extends m {
        final /* synthetic */ a blL;
        private float bme;
        private float bmf;

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.bme = this.blL.bkV;
            this.bmf = this.blL.blb;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void q(float f, float f2) {
            if (this.blL.mDragState != 4) {
                cancel();
                return;
            }
            this.blL.bkV = (int) ((this.bmf * f2) + ((1.0f - f2) * this.bme));
            this.blL.bkJ.y = this.blL.mY - this.blL.bkV;
            this.blL.cT(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e {
        StringBuilder mBuilder = new StringBuilder();
        private int blV = 0;
        private int blW = 0;
        private boolean blX = false;
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
            this.blW = 0;
            this.blX = true;
        }

        public void Ra() {
            if (this.blX) {
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
                this.mBuilder.append("    <FirstExpPos>").append(a.this.bkQ).append("</FirstExpPos>\n");
                this.mBuilder.append("    <FirstExpBlankHeight>").append(a.this.gv(a.this.bkQ) - a.this.gx(a.this.bkQ)).append("</FirstExpBlankHeight>\n");
                this.mBuilder.append("    <SecondExpPos>").append(a.this.bkR).append("</SecondExpPos>\n");
                this.mBuilder.append("    <SecondExpBlankHeight>").append(a.this.gv(a.this.bkR) - a.this.gx(a.this.bkR)).append("</SecondExpBlankHeight>\n");
                this.mBuilder.append("    <SrcPos>").append(a.this.bkT).append("</SrcPos>\n");
                this.mBuilder.append("    <SrcHeight>").append(a.this.mFloatViewHeight + a.this.mListView.getDividerHeight()).append("</SrcHeight>\n");
                this.mBuilder.append("    <ViewHeight>").append(a.this.mListView.getHeight()).append("</ViewHeight>\n");
                this.mBuilder.append("    <LastY>").append(a.this.mLastY).append("</LastY>\n");
                this.mBuilder.append("    <FloatY>").append(a.this.bkL).append("</FloatY>\n");
                this.mBuilder.append("    <ShuffleEdges>");
                for (int i4 = 0; i4 < childCount; i4++) {
                    this.mBuilder.append(a.this.P(firstVisiblePosition + i4, a.this.mListView.getChildAt(i4).getTop())).append(",");
                }
                this.mBuilder.append("</ShuffleEdges>\n");
                this.mBuilder.append("</DSLVState>\n");
                this.blV++;
                if (this.blV > 1000) {
                    flush();
                    this.blV = 0;
                }
            }
        }

        public void flush() {
            if (this.blX) {
                try {
                    FileWriter fileWriter = new FileWriter(this.mFile, this.blW != 0);
                    fileWriter.write(this.mBuilder.toString());
                    this.mBuilder.delete(0, this.mBuilder.length());
                    fileWriter.flush();
                    fileWriter.close();
                    this.blW++;
                } catch (IOException e) {
                }
            }
        }

        public void ok() {
            if (this.blX) {
                this.mBuilder.append("</DSLVStates>\n");
                flush();
                this.blX = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements Runnable {
        private boolean blO;
        private long blP;
        private long blQ;
        private float blR;
        private long blS;
        private int blT;
        private float blU;
        private int dy;
        private boolean mScrolling = false;

        public boolean isScrolling() {
            return this.mScrolling;
        }

        public int QZ() {
            if (this.mScrolling) {
                return this.blT;
            }
            return -1;
        }

        public d() {
        }

        public void gy(int i) {
            if (!this.mScrolling) {
                this.blO = false;
                this.mScrolling = true;
                this.blS = SystemClock.uptimeMillis();
                this.blP = this.blS;
                this.blT = i;
                a.this.mListView.post(this);
            }
        }

        public void cU(boolean z) {
            if (z) {
                a.this.mListView.removeCallbacks(this);
                this.mScrolling = false;
                return;
            }
            this.blO = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.blO) {
                int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
                int lastVisiblePosition = a.this.mListView.getLastVisiblePosition();
                int count = a.this.mListView.getCount();
                int paddingTop = a.this.mListView.getPaddingTop();
                int height = (a.this.mListView.getHeight() - paddingTop) - a.this.mListView.getPaddingBottom();
                int min = Math.min(a.this.mY, a.this.bkL + a.this.blb);
                int max = Math.max(a.this.mY, a.this.bkL - a.this.blb);
                if (this.blT == 0) {
                    View childAt = a.this.mListView.getChildAt(0);
                    if (childAt == null) {
                        this.mScrolling = false;
                        return;
                    } else if (firstVisiblePosition == 0 && childAt.getTop() == paddingTop) {
                        this.mScrolling = false;
                        return;
                    } else {
                        this.blU = a.this.bln.b((a.this.blj - max) / a.this.blk, this.blP);
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
                        this.blU = -a.this.bln.b((min - a.this.bli) / a.this.bll, this.blP);
                    }
                }
                this.blQ = SystemClock.uptimeMillis();
                this.blR = (float) (this.blQ - this.blP);
                this.dy = Math.round(this.blU * this.blR);
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
                this.blP = this.blQ;
                a.this.mListView.post(this);
                return;
            }
            this.mScrolling = false;
        }
    }
}
