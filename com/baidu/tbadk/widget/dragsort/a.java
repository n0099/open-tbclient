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
/* loaded from: classes2.dex */
public class a implements com.baidu.tbadk.widget.dragsort.c {
    private int cLp;
    private View eXT;
    private int eXW;
    private MotionEvent eYD;
    private C0561a eYH;
    private e eYJ;
    private k eYM;
    private j eYN;
    private f eYO;
    private boolean eYP;
    private com.baidu.tbadk.widget.dragsort.d eYR;
    private com.baidu.tbadk.widget.dragsort.b eYS;
    private int eYa;
    private int eYb;
    private int eYc;
    private int eYe;
    private int eYf;
    private int eYg;
    private b eYh;
    private g eYi;
    private l eYj;
    private int eYl;
    private d eYn;
    private int eYq;
    private int eYr;
    private float eYs;
    private float eYt;
    private float eYu;
    private float eYv;
    private int eYy;
    private int mLastX;
    private int mLastY;
    private ListView mListView;
    private DataSetObserver mObserver;
    private int mOffsetX;
    private int mOffsetY;
    private int mX;
    private int mY;
    private Point eXU = new Point();
    private Point eXV = new Point();
    private boolean eXX = false;
    private float eXY = 1.0f;
    private float eXZ = 1.0f;
    private boolean eYd = false;
    private boolean dcO = true;
    private int mDragState = 0;
    private int eYk = 1;
    private int mWidthMeasureSpec = 0;
    private View[] eYm = new View[1];
    private float eYo = 0.33333334f;
    private float eYp = 0.33333334f;
    private float eYw = 0.5f;
    private c eYx = new c() { // from class: com.baidu.tbadk.widget.dragsort.a.1
        @Override // com.baidu.tbadk.widget.dragsort.a.c
        public float b(float f2, long j2) {
            return a.this.eYw * f2;
        }
    };
    private int eYz = 0;
    private boolean eYA = false;
    private boolean eYB = false;
    private h eYC = null;
    private int eYE = 0;
    private float eYF = 0.25f;
    private float eYG = 0.0f;
    private boolean eYI = false;
    private boolean mBlockLayoutRequests = false;
    private boolean eYK = false;
    private i eYL = new i(3);
    private float eYQ = 0.0f;
    private boolean eYT = false;
    private boolean eYU = false;

    /* loaded from: classes2.dex */
    public interface b {
        void drag(int i, int i2);
    }

    /* loaded from: classes2.dex */
    public interface c {
        float b(float f, long j);
    }

    /* loaded from: classes2.dex */
    public interface g {
        void drop(int i, int i2);
    }

    /* loaded from: classes2.dex */
    public interface h {
        void b(View view, Point point, Point point2);

        void bu(View view);

        View qT(int i);
    }

    /* loaded from: classes2.dex */
    public interface l {
        void remove(int i);
    }

    public a(ListView listView, com.baidu.tbadk.widget.dragsort.d dVar) {
        this.eYR = dVar;
        this.mListView = listView;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            this.eYH = new C0561a(listAdapter);
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
            this.eYH = null;
        }
        this.eYR.setAdapter(this.eYH);
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
            if (i2 > this.eYe) {
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
    public int qP(int i2) {
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        return childAt != null ? childAt.getHeight() : bm(i2, qR(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bk(int i2, int i3) {
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        if (i2 <= headerViewsCount || i2 >= this.mListView.getCount() - footerViewsCount) {
            return i3;
        }
        int dividerHeight = this.mListView.getDividerHeight();
        int i4 = this.cLp - this.eYk;
        int qR = qR(i2);
        int qP = qP(i2);
        if (this.eYc <= this.eYe) {
            if (i2 == this.eYc && this.eYb != this.eYc) {
                if (i2 == this.eYe) {
                    i3 = (i3 + qP) - this.cLp;
                } else {
                    i3 = ((qP - qR) + i3) - i4;
                }
            } else if (i2 > this.eYc && i2 <= this.eYe) {
                i3 -= i4;
            }
        } else if (i2 > this.eYe && i2 <= this.eYb) {
            i3 += i4;
        } else if (i2 == this.eYc && this.eYb != this.eYc) {
            i3 += qP - qR;
        }
        if (i2 <= this.eYe) {
            return (((this.cLp - dividerHeight) - qR(i2 - 1)) / 2) + i3;
        }
        return (((qR - dividerHeight) - this.cLp) / 2) + i3;
    }

    private boolean bwu() {
        int i2;
        int i3;
        int i4;
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int i5 = this.eYb;
        View childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        if (childAt == null) {
            i5 = firstVisiblePosition + (this.mListView.getChildCount() / 2);
            childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        }
        int top = childAt.getTop();
        int height = childAt.getHeight();
        int bk = bk(i5, top);
        int dividerHeight = this.mListView.getDividerHeight();
        if (this.eXW >= bk) {
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
                    i6 = qP(i3 + 1);
                    i2 = bk(i3 + 1, i7);
                    if (this.eXW < i2) {
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
                int qP = qP(i3);
                if (i3 == 0) {
                    i2 = (i8 - dividerHeight) - qP;
                    break;
                }
                i8 -= qP + dividerHeight;
                i2 = bk(i3, i8);
                if (this.eXW >= i2) {
                    break;
                }
                i4 = i2;
            }
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int i9 = this.eYb;
        int i10 = this.eYc;
        float f2 = this.eYG;
        if (this.eYd) {
            int abs = Math.abs(i2 - i4);
            if (this.eXW >= i2) {
                int i11 = i4;
                i4 = i2;
                i2 = i11;
            }
            int i12 = (int) (abs * this.eYF * 0.5f);
            float f3 = i12;
            int i13 = i4 + i12;
            int i14 = i2 - i12;
            if (this.eXW < i13) {
                this.eYb = i3 - 1;
                this.eYc = i3;
                this.eYG = ((i13 - this.eXW) * 0.5f) / f3;
            } else if (this.eXW < i14) {
                this.eYb = i3;
                this.eYc = i3;
            } else {
                this.eYb = i3;
                this.eYc = i3 + 1;
                this.eYG = (1.0f + ((i2 - this.eXW) / f3)) * 0.5f;
            }
        } else {
            this.eYb = i3;
            this.eYc = i3;
        }
        if (this.eYb < headerViewsCount) {
            this.eYb = headerViewsCount;
            this.eYc = headerViewsCount;
            i3 = headerViewsCount;
        } else if (this.eYc >= this.mListView.getCount() - footerViewsCount) {
            i3 = (this.mListView.getCount() - footerViewsCount) - 1;
            this.eYb = i3;
            this.eYc = i3;
        }
        boolean z = (this.eYb == i9 && this.eYc == i10 && this.eYG == f2) ? false : true;
        if (i3 != this.eYa) {
            if (this.eYh != null) {
                this.eYh.drag(this.eYa - headerViewsCount, i3 - headerViewsCount);
            }
            this.eYa = i3;
            return true;
        }
        return z;
    }

    public void removeItem(int i2) {
        this.eYP = false;
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
            this.eYk = Math.max(1, obtainStyledAttributes.getDimensionPixelSize(R.styleable.DragSort_collapsed_height, 1));
            this.eYI = obtainStyledAttributes.getBoolean(R.styleable.DragSort_track_drag_sort, false);
            if (this.eYI) {
                this.eYJ = new e();
            }
            this.eXY = obtainStyledAttributes.getFloat(R.styleable.DragSort_float_alpha, this.eXY);
            this.eXZ = this.eXY;
            this.dcO = obtainStyledAttributes.getBoolean(R.styleable.DragSort_drag_enabled, this.dcO);
            this.eYF = Math.max(0.0f, Math.min(1.0f, 1.0f - obtainStyledAttributes.getFloat(R.styleable.DragSort_slide_shuffle_speed, 0.75f)));
            this.eYd = this.eYF > 0.0f;
            setDragScrollStart(obtainStyledAttributes.getFloat(R.styleable.DragSort_drag_scroll_start, this.eYo));
            this.eYw = obtainStyledAttributes.getFloat(R.styleable.DragSort_max_drag_scroll_speed, this.eYw);
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
                bVar.jS(z);
                bVar.jR(z2);
                bVar.setBackgroundColor(color);
                this.eYC = bVar;
                a(bVar);
            }
            obtainStyledAttributes.recycle();
            i2 = i5;
            i3 = i4;
        }
        this.eYn = new d();
        if (i3 > 0) {
            this.eYM = new k(0.5f, i3);
        }
        if (i2 > 0) {
            this.eYO = new f(0.5f, i2);
        }
        this.eYD = MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
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
        this.eYS = bVar;
        this.mListView.setOnTouchListener(bVar);
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void dispatchDraw(Canvas canvas) {
        float f2;
        this.eYR.dispatchDraw(canvas);
        if (this.mDragState != 0) {
            if (this.eYb != this.eYe) {
                b(this.eYb, canvas);
            }
            if (this.eYc != this.eYb && this.eYc != this.eYe) {
                b(this.eYc, canvas);
            }
        }
        if (this.eXT != null) {
            int width = this.eXT.getWidth();
            int height = this.eXT.getHeight();
            int i2 = this.eXU.x;
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
            int i3 = (int) (f2 * 255.0f * this.eXZ);
            canvas.save();
            canvas.translate(this.eXU.x, this.eXU.y);
            canvas.clipRect(0, 0, width, height);
            canvas.saveLayerAlpha(0.0f, 0.0f, width, height, i3, 31);
            this.eXT.draw(canvas);
            canvas.restore();
            canvas.restore();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onDraw(Canvas canvas) {
        this.eYR.onDraw(canvas);
        if (this.eYI) {
            this.eYJ.bwH();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.eYK) {
            this.eYK = false;
            return false;
        } else if (!this.dcO) {
            return this.eYR.onTouchEvent(motionEvent);
        } else {
            boolean z2 = this.eYA;
            this.eYA = false;
            if (!z2) {
                G(motionEvent);
            }
            if (this.mDragState == 4) {
                onDragTouchEvent(motionEvent);
                return true;
            }
            if (this.mDragState == 0 && this.eYR.onTouchEvent(motionEvent)) {
                z = true;
            }
            switch (motionEvent.getAction() & 255) {
                case 1:
                case 3:
                    bwz();
                    return z;
                case 2:
                default:
                    if (z) {
                        this.eYE = 1;
                        return z;
                    }
                    return z;
            }
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (!this.dcO) {
            return this.eYR.onInterceptTouchEvent(motionEvent);
        }
        if (this.eYS != null) {
            this.eYS.bwJ().onTouchEvent(motionEvent);
        }
        G(motionEvent);
        this.eYA = true;
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            if (this.mDragState != 0) {
                this.eYK = true;
                return true;
            }
            this.eYB = true;
        }
        if (this.eXT == null) {
            if (this.eYR.onInterceptTouchEvent(motionEvent)) {
                this.eYT = true;
                z = true;
            } else {
                z = false;
            }
            switch (action) {
                case 1:
                case 3:
                    bwz();
                    break;
                case 2:
                default:
                    if (z) {
                        this.eYE = 1;
                        break;
                    } else {
                        this.eYE = 2;
                        break;
                    }
            }
        } else {
            z = true;
        }
        if (action == 1 || action == 3) {
            this.eYB = false;
        }
        return z;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        this.eYR.onSizeChanged(i2, i3, i4, i5);
        bwA();
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void requestLayout() {
        if (!this.mBlockLayoutRequests) {
            this.eYR.requestLayout();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onMeasure(int i2, int i3) {
        this.eYR.onMeasure(i2, i3);
        if (this.eXT != null) {
            if (this.eXT.isLayoutRequested()) {
                bwC();
            }
            this.eXX = true;
        }
        this.mWidthMeasureSpec = i2;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void layoutChildren() {
        this.eYR.layoutChildren();
        if (this.eXT != null) {
            if (this.eXT.isLayoutRequested() && !this.eXX) {
                bwC();
            }
            this.eXT.layout(0, 0, this.eXT.getMeasuredWidth(), this.eXT.getMeasuredHeight());
            this.eXX = false;
        }
    }

    public void removeItem(int i2, float f2) {
        if (this.mDragState == 0 || this.mDragState == 4) {
            if (this.mDragState == 0) {
                this.eYe = this.mListView.getHeaderViewsCount() + i2;
                this.eYb = this.eYe;
                this.eYc = this.eYe;
                this.eYa = this.eYe;
                View childAt = this.mListView.getChildAt(this.eYe - this.mListView.getFirstVisiblePosition());
                if (childAt != null) {
                    childAt.setVisibility(4);
                }
            }
            this.mDragState = 1;
            this.eYQ = f2;
            if (this.eYB) {
                switch (this.eYE) {
                    case 1:
                        this.eYR.onTouchEvent(this.eYD);
                        break;
                    case 2:
                        this.eYR.onInterceptTouchEvent(this.eYD);
                        break;
                }
            }
            if (this.eYM != null) {
                this.eYM.start();
            } else {
                qQ(i2);
            }
        }
    }

    public void cancelDrag() {
        if (this.mDragState == 4) {
            this.eYn.jQ(true);
            bwE();
            bwv();
            bwB();
            if (this.eYB) {
                this.mDragState = 3;
            } else {
                this.mDragState = 0;
            }
        }
    }

    private void bwv() {
        this.eYe = -1;
        this.eYb = -1;
        this.eYc = -1;
        this.eYa = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bww() {
        this.mDragState = 2;
        if (this.eYi != null && this.eYa >= 0 && this.eYa < this.mListView.getCount()) {
            int headerViewsCount = this.mListView.getHeaderViewsCount();
            this.eYi.drop(this.eYe - headerViewsCount, this.eYa - headerViewsCount);
        }
        bwE();
        bwy();
        bwv();
        bwB();
        if (this.eYB) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwx() {
        qQ(this.eYe - this.mListView.getHeaderViewsCount());
    }

    private void qQ(int i2) {
        this.mDragState = 1;
        if (this.eYj != null) {
            this.eYj.remove(i2);
        }
        bwE();
        bwy();
        bwv();
        if (this.eYB) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    private void bwy() {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        if (this.eYe < firstVisiblePosition) {
            View childAt = this.mListView.getChildAt(0);
            this.mListView.setSelectionFromTop(firstVisiblePosition - 1, (childAt != null ? childAt.getTop() : 0) - this.mListView.getPaddingTop());
        }
    }

    public boolean stopDrag(boolean z) {
        this.eYP = false;
        return stopDrag(z, 0.0f);
    }

    public boolean stopDragWithVelocity(boolean z, float f2) {
        this.eYP = true;
        return stopDrag(z, f2);
    }

    public boolean stopDrag(boolean z, float f2) {
        if (this.eXT != null) {
            this.eYn.jQ(true);
            if (z) {
                removeItem(this.eYe - this.mListView.getHeaderViewsCount(), f2);
            } else if (this.eYO != null) {
                this.eYO.start();
            } else {
                bww();
            }
            if (this.eYI) {
                this.eYJ.stopTracking();
                return true;
            }
            return true;
        }
        return false;
    }

    private void bwz() {
        this.eYE = 0;
        this.eYB = false;
        if (this.mDragState == 3) {
            this.mDragState = 0;
        }
        this.eXZ = this.eXY;
        this.eYT = false;
        this.eYL.clear();
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
        return this.eYT;
    }

    public void setDragScrollStart(float f2) {
        setDragScrollStarts(f2, f2);
    }

    public void setDragScrollStarts(float f2, float f3) {
        if (f3 > 0.5f) {
            this.eYp = 0.5f;
        } else {
            this.eYp = f3;
        }
        if (f2 > 0.5f) {
            this.eYo = 0.5f;
        } else {
            this.eYo = f2;
        }
        if (this.mListView.getHeight() != 0) {
            bwA();
        }
    }

    private void bl(int i2, int i3) {
        this.eXU.x = i2 - this.eYf;
        this.eXU.y = i3 - this.eYg;
        jP(true);
        int min = Math.min(i3, this.eXW + this.eYl);
        int max = Math.max(i3, this.eXW - this.eYl);
        int bwF = this.eYn.bwF();
        if (min > this.mLastY && min > this.eYr && bwF != 1) {
            if (bwF != -1) {
                this.eYn.jQ(true);
            }
            this.eYn.qS(1);
        } else if (max < this.mLastY && max < this.eYq && bwF != 0) {
            if (bwF != -1) {
                this.eYn.jQ(true);
            }
            this.eYn.qS(0);
        } else if (max >= this.eYq && min <= this.eYr && this.eYn.isScrolling()) {
            this.eYn.jQ(true);
        }
    }

    private void bwA() {
        int height;
        int paddingTop = this.mListView.getPaddingTop();
        float height2 = (this.mListView.getHeight() - paddingTop) - this.mListView.getPaddingBottom();
        this.eYt = paddingTop + (this.eYo * height2);
        this.eYs = (height2 * (1.0f - this.eYp)) + paddingTop;
        this.eYq = (int) this.eYt;
        this.eYr = (int) this.eYs;
        this.eYu = this.eYt - paddingTop;
        this.eYv = (paddingTop + height) - this.eYs;
    }

    private void bwB() {
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
        if (i2 != this.eYe && i2 != this.eYb && i2 != this.eYc) {
            g2 = -2;
        } else {
            g2 = g(i2, view, z);
        }
        if (g2 != layoutParams.height) {
            layoutParams.height = g2;
            view.setLayoutParams(layoutParams);
        }
        if (i2 == this.eYb || i2 == this.eYc) {
            if (i2 < this.eYe) {
                ((DragSortItemView) view).setGravity(80);
            } else if (i2 > this.eYe) {
                ((DragSortItemView) view).setGravity(48);
            }
        }
        int visibility = view.getVisibility();
        int i3 = 0;
        if (i2 == this.eYe && this.eXT != null) {
            i3 = 4;
        }
        if (i3 != visibility) {
            view.setVisibility(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int qR(int i2) {
        View view;
        if (i2 == this.eYe) {
            return 0;
        }
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        if (childAt != null) {
            return f(i2, childAt, false);
        }
        int i3 = this.eYL.get(i2);
        if (i3 == -1) {
            ListAdapter adapter = this.mListView.getAdapter();
            int itemViewType = adapter.getItemViewType(i2);
            int viewTypeCount = adapter.getViewTypeCount();
            if (viewTypeCount != this.eYm.length) {
                this.eYm = new View[viewTypeCount];
            }
            if (itemViewType >= 0) {
                if (this.eYm[itemViewType] == null) {
                    view = adapter.getView(i2, null, this.mListView);
                    this.eYm[itemViewType] = view;
                } else {
                    view = adapter.getView(i2, this.eYm[itemViewType], this.mListView);
                }
            } else {
                view = adapter.getView(i2, null, this.mListView);
            }
            int f2 = f(i2, view, true);
            this.eYL.bn(i2, f2);
            return f2;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(int i2, View view, boolean z) {
        if (i2 == this.eYe) {
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
        boolean z = this.eYd && this.eYb != this.eYc;
        int i4 = this.cLp - this.eYk;
        int i5 = (int) (this.eYG * i4);
        if (i2 == this.eYe) {
            if (this.eYe == this.eYb) {
                if (z) {
                    return i5 + this.eYk;
                }
                return this.cLp;
            } else if (this.eYe == this.eYc) {
                return this.cLp - i5;
            } else {
                return this.eYk;
            }
        } else if (i2 == this.eYb) {
            if (z) {
                return i3 + i5;
            }
            return i3 + i4;
        } else if (i2 == this.eYc) {
            return (i3 + i4) - i5;
        } else {
            return i3;
        }
    }

    private int b(int i2, View view, int i3, int i4) {
        int i5;
        int i6;
        int qR = qR(i2);
        int height = view.getHeight();
        int bm = bm(i2, qR);
        if (i2 != this.eYe) {
            i6 = height - qR;
            i5 = bm - qR;
        } else {
            i5 = bm;
            i6 = height;
        }
        int i7 = this.cLp;
        if (this.eYe != this.eYb && this.eYe != this.eYc) {
            i7 -= this.eYk;
        }
        if (i2 <= i3) {
            if (i2 > this.eYb) {
                return (i7 - i5) + 0;
            }
        } else if (i2 == i4) {
            if (i2 <= this.eYb) {
                return (i6 - i7) + 0;
            }
            if (i2 == this.eYc) {
                return (height - bm) + 0;
            }
            return 0 + i6;
        } else if (i2 <= this.eYb) {
            return 0 - i7;
        } else {
            if (i2 == this.eYc) {
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

    private void bwC() {
        if (this.eXT != null) {
            measureItem(this.eXT);
            this.cLp = this.eXT.getMeasuredHeight();
            this.eYl = this.cLp / 2;
        }
    }

    protected boolean onDragTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        switch (motionEvent.getAction() & 255) {
            case 1:
                if (this.mDragState == 4) {
                    stopDrag(false);
                }
                bwz();
                return true;
            case 2:
                bl((int) motionEvent.getX(), (int) motionEvent.getY());
                return true;
            case 3:
                if (this.mDragState == 4) {
                    cancelDrag();
                }
                bwz();
                return true;
            default:
                return true;
        }
    }

    public boolean startDrag(int i2, int i3, int i4, int i5) {
        View qT;
        if (!this.eYB || this.eYC == null || (qT = this.eYC.qT(i2)) == null) {
            return false;
        }
        return startDrag(i2, qT, i3, i4, i5);
    }

    public boolean startDrag(int i2, View view, int i3, int i4, int i5) {
        if (this.mDragState == 0 && this.eYB && this.eXT == null && view != null && this.dcO) {
            if (this.mListView.getParent() != null) {
                this.mListView.getParent().requestDisallowInterceptTouchEvent(true);
            }
            int headerViewsCount = this.mListView.getHeaderViewsCount() + i2;
            this.eYb = headerViewsCount;
            this.eYc = headerViewsCount;
            this.eYe = headerViewsCount;
            this.eYa = headerViewsCount;
            this.mDragState = 4;
            this.eYz = 0;
            this.eYz |= i3;
            this.eXT = view;
            bwC();
            this.eYf = i4;
            this.eYg = i5;
            this.eYy = this.mY;
            this.eXU.x = this.mX - this.eYf;
            this.eXU.y = this.mY - this.eYg;
            View childAt = this.mListView.getChildAt(this.eYe - this.mListView.getFirstVisiblePosition());
            if (childAt != null) {
                childAt.setVisibility(4);
            }
            if (this.eYI) {
                this.eYJ.bwG();
            }
            switch (this.eYE) {
                case 1:
                    this.eYR.onTouchEvent(this.eYD);
                    break;
                case 2:
                    this.eYR.onInterceptTouchEvent(this.eYD);
                    break;
            }
            this.mListView.requestLayout();
            if (this.eYN != null) {
                this.eYN.start();
                return true;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jP(boolean z) {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition() + (this.mListView.getChildCount() / 2);
        View childAt = this.mListView.getChildAt(this.mListView.getChildCount() / 2);
        if (childAt != null) {
            h(firstVisiblePosition, childAt, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i2, View view, boolean z) {
        this.mBlockLayoutRequests = true;
        bwD();
        int i3 = this.eYb;
        int i4 = this.eYc;
        boolean bwu = bwu();
        if (bwu) {
            bwB();
            this.mListView.setSelectionFromTop(i2, (b(i2, view, i3, i4) + view.getTop()) - this.mListView.getPaddingTop());
            layoutChildren();
        }
        if (bwu || z) {
            this.mListView.invalidate();
        }
        this.mBlockLayoutRequests = false;
    }

    private void bwD() {
        if (this.eYC != null) {
            this.eXV.set(this.mX, this.mY);
            this.eYC.b(this.eXT, this.eXU, this.eXV);
        }
        int i2 = this.eXU.x;
        int i3 = this.eXU.y;
        int paddingLeft = this.mListView.getPaddingLeft();
        if ((this.eYz & 1) == 0 && i2 > paddingLeft) {
            this.eXU.x = paddingLeft;
        } else if ((this.eYz & 2) == 0 && i2 < paddingLeft) {
            this.eXU.x = paddingLeft;
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int lastVisiblePosition = this.mListView.getLastVisiblePosition();
        int paddingTop = this.mListView.getPaddingTop();
        if (firstVisiblePosition < headerViewsCount) {
            paddingTop = this.mListView.getChildAt((headerViewsCount - firstVisiblePosition) - 1).getBottom();
        }
        if ((this.eYz & 8) == 0 && firstVisiblePosition <= this.eYe) {
            paddingTop = Math.max(this.mListView.getChildAt(this.eYe - firstVisiblePosition).getTop(), paddingTop);
        }
        int height = this.mListView.getHeight() - this.mListView.getPaddingBottom();
        if (lastVisiblePosition >= (this.mListView.getCount() - footerViewsCount) - 1) {
            height = this.mListView.getChildAt(((this.mListView.getCount() - footerViewsCount) - 1) - firstVisiblePosition).getBottom();
        }
        if ((this.eYz & 4) == 0 && lastVisiblePosition >= this.eYe) {
            height = Math.min(this.mListView.getChildAt(this.eYe - firstVisiblePosition).getBottom(), height);
        }
        if (i3 < paddingTop) {
            this.eXU.y = paddingTop;
        } else if (this.cLp + i3 > height) {
            this.eXU.y = height - this.cLp;
        }
        this.eXW = this.eXU.y + this.eYl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwE() {
        if (this.eXT != null) {
            this.eXT.setVisibility(8);
            if (this.eYC != null) {
                this.eYC.bu(this.eXT);
            }
            this.eXT = null;
            this.mListView.invalidate();
        }
    }

    public void a(h hVar) {
        this.eYC = hVar;
    }

    public void a(b bVar) {
        this.eYh = bVar;
    }

    public void setDragEnabled(boolean z) {
        this.dcO = z;
    }

    public boolean isDragEnabled() {
        return this.dcO;
    }

    public void a(g gVar) {
        this.eYi = gVar;
    }

    public void a(l lVar) {
        this.eYj = lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class i {
        private SparseIntArray eZn;
        private ArrayList<Integer> eZo;
        private int mMaxSize;

        public i(int i) {
            this.eZn = new SparseIntArray(i);
            this.eZo = new ArrayList<>(i);
            this.mMaxSize = i;
        }

        public void bn(int i, int i2) {
            int i3 = this.eZn.get(i, -1);
            if (i3 != i2) {
                if (i3 == -1) {
                    if (this.eZn.size() == this.mMaxSize) {
                        this.eZn.delete(this.eZo.remove(0).intValue());
                    }
                } else {
                    this.eZo.remove(Integer.valueOf(i));
                }
                this.eZn.put(i, i2);
                this.eZo.add(Integer.valueOf(i));
            }
        }

        public int get(int i) {
            return this.eZn.get(i, -1);
        }

        public void clear() {
            this.eZn.clear();
            this.eZo.clear();
        }
    }

    /* renamed from: com.baidu.tbadk.widget.dragsort.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private class C0561a extends BaseAdapter {
        private ListAdapter mAdapter;

        public C0561a(ListAdapter listAdapter) {
            this.mAdapter = listAdapter;
            this.mAdapter.registerDataSetObserver(new DataSetObserver() { // from class: com.baidu.tbadk.widget.dragsort.a.a.1
                @Override // android.database.DataSetObserver
                public void onChanged() {
                    C0561a.this.notifyDataSetChanged();
                }

                @Override // android.database.DataSetObserver
                public void onInvalidated() {
                    C0561a.this.notifyDataSetInvalidated();
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
    /* loaded from: classes2.dex */
    public class m implements Runnable {
        private float bZQ;
        private float bZR;
        private float bZS;
        private float bZT;
        private float eZy;
        private float mAlpha;
        private boolean mCanceled;
        protected long mStartTime;

        public m(float f, int i) {
            this.mAlpha = f;
            this.eZy = i;
            float f2 = 1.0f / ((this.mAlpha * 2.0f) * (1.0f - this.mAlpha));
            this.bZT = f2;
            this.bZQ = f2;
            this.bZR = this.mAlpha / ((this.mAlpha - 1.0f) * 2.0f);
            this.bZS = 1.0f / (1.0f - this.mAlpha);
        }

        public float ag(float f) {
            if (f < this.mAlpha) {
                return this.bZQ * f * f;
            }
            if (f < 1.0f - this.mAlpha) {
                return this.bZR + (this.bZS * f);
            }
            return 1.0f - ((this.bZT * (f - 1.0f)) * (f - 1.0f));
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

        public void w(float f, float f2) {
        }

        public void onStop() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.mCanceled) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / this.eZy;
                if (uptimeMillis >= 1.0f) {
                    w(1.0f, 1.0f);
                    onStop();
                    return;
                }
                w(uptimeMillis, ag(uptimeMillis));
                a.this.mListView.post(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class f extends m {
        private int eZj;
        private int eZk;
        private float eZl;
        private float eZm;

        public f(float f, int i) {
            super(f, i);
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.eZj = a.this.eYa;
            this.eZk = a.this.eYe;
            a.this.mDragState = 2;
            this.eZl = a.this.eXU.y - bwI();
            this.eZm = a.this.eXU.x - a.this.mListView.getPaddingLeft();
        }

        private int bwI() {
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            int dividerHeight = (a.this.eYk + a.this.mListView.getDividerHeight()) / 2;
            View childAt = a.this.mListView.getChildAt(this.eZj - firstVisiblePosition);
            if (childAt != null) {
                if (this.eZj == this.eZk) {
                    return childAt.getTop();
                }
                if (this.eZj >= this.eZk) {
                    return (childAt.getBottom() + dividerHeight) - a.this.cLp;
                }
                return childAt.getTop() - dividerHeight;
            }
            cancel();
            return -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void w(float f, float f2) {
            int bwI = bwI();
            float paddingLeft = a.this.eXU.x - a.this.mListView.getPaddingLeft();
            float f3 = 1.0f - f2;
            if (f3 < Math.abs((a.this.eXU.y - bwI) / this.eZl) || f3 < Math.abs(paddingLeft / this.eZm)) {
                a.this.eXU.y = bwI + ((int) (this.eZl * f3));
                a.this.eXU.x = a.this.mListView.getPaddingLeft() + ((int) (this.eZm * f3));
                a.this.jP(true);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.bww();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class k extends m {
        private int eZk;
        private float eZr;
        private float eZs;
        private float eZt;
        private int eZu;
        private int eZv;
        private int eZw;
        private int eZx;

        public k(float f, int i) {
            super(f, i);
            this.eZu = -1;
            this.eZv = -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.eZu = -1;
            this.eZv = -1;
            this.eZw = a.this.eYb;
            this.eZx = a.this.eYc;
            this.eZk = a.this.eYe;
            a.this.mDragState = 1;
            this.eZr = a.this.eXU.x;
            if (a.this.eYP) {
                float width = a.this.mListView.getWidth() * 2.0f;
                if (a.this.eYQ == 0.0f) {
                    a.this.eYQ = (this.eZr >= 0.0f ? 1 : -1) * width;
                    return;
                }
                float f = width * 2.0f;
                if (a.this.eYQ >= 0.0f || a.this.eYQ <= (-f)) {
                    if (a.this.eYQ > 0.0f && a.this.eYQ < f) {
                        a.this.eYQ = f;
                        return;
                    }
                    return;
                }
                a.this.eYQ = -f;
                return;
            }
            a.this.bwE();
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void w(float f, float f2) {
            View childAt;
            float f3 = 1.0f - f2;
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            View childAt2 = a.this.mListView.getChildAt(this.eZw - firstVisiblePosition);
            if (a.this.eYP) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / 1000.0f;
                if (uptimeMillis != 0.0f) {
                    float f4 = a.this.eYQ * uptimeMillis;
                    int width = a.this.mListView.getWidth();
                    a.this.eYQ = ((a.this.eYQ > 0.0f ? 1 : -1) * uptimeMillis * width) + a.this.eYQ;
                    this.eZr += f4;
                    a.this.eXU.x = (int) this.eZr;
                    if (this.eZr < width && this.eZr > (-width)) {
                        this.mStartTime = SystemClock.uptimeMillis();
                        a.this.jP(true);
                        return;
                    }
                } else {
                    return;
                }
            }
            if (childAt2 != null) {
                if (this.eZu == -1) {
                    this.eZu = a.this.f(this.eZw, childAt2, false);
                    this.eZs = childAt2.getHeight() - this.eZu;
                }
                int max = Math.max((int) (this.eZs * f3), 1);
                ViewGroup.LayoutParams layoutParams = childAt2.getLayoutParams();
                layoutParams.height = max + this.eZu;
                childAt2.setLayoutParams(layoutParams);
            }
            if (this.eZx != this.eZw && (childAt = a.this.mListView.getChildAt(this.eZx - firstVisiblePosition)) != null) {
                if (this.eZv == -1) {
                    this.eZv = a.this.f(this.eZx, childAt, false);
                    this.eZt = childAt.getHeight() - this.eZv;
                }
                int max2 = Math.max((int) (this.eZt * f3), 1);
                ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
                layoutParams2.height = max2 + this.eZv;
                childAt.setLayoutParams(layoutParams2);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.bwx();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class j extends m {
        final /* synthetic */ a eYV;
        private float eZp;
        private float eZq;

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.eZp = this.eYV.eYg;
            this.eZq = this.eYV.eYl;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void w(float f, float f2) {
            if (this.eYV.mDragState != 4) {
                cancel();
                return;
            }
            this.eYV.eYg = (int) ((this.eZq * f2) + ((1.0f - f2) * this.eZp));
            this.eYV.eXU.y = this.eYV.mY - this.eYV.eYg;
            this.eYV.jP(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class e {
        StringBuilder mBuilder = new StringBuilder();
        private int eZg = 0;
        private int eZh = 0;
        private boolean eZi = false;
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

        public void bwG() {
            this.mBuilder.append("<DSLVStates>\n");
            this.eZh = 0;
            this.eZi = true;
        }

        public void bwH() {
            if (this.eZi) {
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
                this.mBuilder.append("    <FirstExpPos>").append(a.this.eYb).append("</FirstExpPos>\n");
                this.mBuilder.append("    <FirstExpBlankHeight>").append(a.this.qP(a.this.eYb) - a.this.qR(a.this.eYb)).append("</FirstExpBlankHeight>\n");
                this.mBuilder.append("    <SecondExpPos>").append(a.this.eYc).append("</SecondExpPos>\n");
                this.mBuilder.append("    <SecondExpBlankHeight>").append(a.this.qP(a.this.eYc) - a.this.qR(a.this.eYc)).append("</SecondExpBlankHeight>\n");
                this.mBuilder.append("    <SrcPos>").append(a.this.eYe).append("</SrcPos>\n");
                this.mBuilder.append("    <SrcHeight>").append(a.this.cLp + a.this.mListView.getDividerHeight()).append("</SrcHeight>\n");
                this.mBuilder.append("    <ViewHeight>").append(a.this.mListView.getHeight()).append("</ViewHeight>\n");
                this.mBuilder.append("    <LastY>").append(a.this.mLastY).append("</LastY>\n");
                this.mBuilder.append("    <FloatY>").append(a.this.eXW).append("</FloatY>\n");
                this.mBuilder.append("    <ShuffleEdges>");
                for (int i4 = 0; i4 < childCount; i4++) {
                    this.mBuilder.append(a.this.bk(firstVisiblePosition + i4, a.this.mListView.getChildAt(i4).getTop())).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                this.mBuilder.append("</ShuffleEdges>\n");
                this.mBuilder.append("</DSLVState>\n");
                this.eZg++;
                if (this.eZg > 1000) {
                    flush();
                    this.eZg = 0;
                }
            }
        }

        public void flush() {
            if (this.eZi) {
                try {
                    FileWriter fileWriter = new FileWriter(this.mFile, this.eZh != 0);
                    fileWriter.write(this.mBuilder.toString());
                    this.mBuilder.delete(0, this.mBuilder.length());
                    fileWriter.flush();
                    fileWriter.close();
                    this.eZh++;
                } catch (IOException e) {
                }
            }
        }

        public void stopTracking() {
            if (this.eZi) {
                this.mBuilder.append("</DSLVStates>\n");
                flush();
                this.eZi = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class d implements Runnable {
        private boolean eYY;
        private long eYZ;
        private long eZa;
        private int eZb;
        private float eZc;
        private long eZd;
        private int eZe;
        private float eZf;
        private boolean mScrolling = false;

        public boolean isScrolling() {
            return this.mScrolling;
        }

        public int bwF() {
            if (this.mScrolling) {
                return this.eZe;
            }
            return -1;
        }

        public d() {
        }

        public void qS(int i) {
            if (!this.mScrolling) {
                this.eYY = false;
                this.mScrolling = true;
                this.eZd = SystemClock.uptimeMillis();
                this.eYZ = this.eZd;
                this.eZe = i;
                a.this.mListView.post(this);
            }
        }

        public void jQ(boolean z) {
            if (z) {
                a.this.mListView.removeCallbacks(this);
                this.mScrolling = false;
                return;
            }
            this.eYY = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.eYY) {
                int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
                int lastVisiblePosition = a.this.mListView.getLastVisiblePosition();
                int count = a.this.mListView.getCount();
                int paddingTop = a.this.mListView.getPaddingTop();
                int height = (a.this.mListView.getHeight() - paddingTop) - a.this.mListView.getPaddingBottom();
                int min = Math.min(a.this.mY, a.this.eXW + a.this.eYl);
                int max = Math.max(a.this.mY, a.this.eXW - a.this.eYl);
                if (this.eZe == 0) {
                    View childAt = a.this.mListView.getChildAt(0);
                    if (childAt == null) {
                        this.mScrolling = false;
                        return;
                    } else if (firstVisiblePosition == 0 && childAt.getTop() == paddingTop) {
                        this.mScrolling = false;
                        return;
                    } else {
                        this.eZf = a.this.eYx.b((a.this.eYt - max) / a.this.eYu, this.eYZ);
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
                        this.eZf = -a.this.eYx.b((min - a.this.eYs) / a.this.eYv, this.eYZ);
                    }
                }
                this.eZa = SystemClock.uptimeMillis();
                this.eZc = (float) (this.eZa - this.eYZ);
                this.eZb = Math.round(this.eZf * this.eZc);
                if (this.eZb >= 0) {
                    this.eZb = Math.min(height, this.eZb);
                    lastVisiblePosition = firstVisiblePosition;
                } else {
                    this.eZb = Math.max(-height, this.eZb);
                }
                View childAt3 = a.this.mListView.getChildAt(lastVisiblePosition - firstVisiblePosition);
                int top = childAt3.getTop() + this.eZb;
                if (lastVisiblePosition == 0 && top > paddingTop) {
                    top = paddingTop;
                }
                a.this.mBlockLayoutRequests = true;
                a.this.mListView.setSelectionFromTop(lastVisiblePosition, top - paddingTop);
                a.this.layoutChildren();
                a.this.mListView.invalidate();
                a.this.mBlockLayoutRequests = false;
                a.this.h(lastVisiblePosition, childAt3, false);
                this.eYZ = this.eZa;
                a.this.mListView.post(this);
                return;
            }
            this.mScrolling = false;
        }
    }
}
