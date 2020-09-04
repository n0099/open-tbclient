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
    private int cLt;
    private View eXX;
    private int eYC;
    private MotionEvent eYH;
    private C0561a eYL;
    private e eYN;
    private k eYQ;
    private j eYR;
    private f eYS;
    private boolean eYT;
    private com.baidu.tbadk.widget.dragsort.d eYV;
    private com.baidu.tbadk.widget.dragsort.b eYW;
    private int eYa;
    private int eYe;
    private int eYf;
    private int eYg;
    private int eYi;
    private int eYj;
    private int eYk;
    private b eYl;
    private g eYm;
    private l eYn;
    private int eYp;
    private d eYr;
    private int eYu;
    private int eYv;
    private float eYw;
    private float eYx;
    private float eYy;
    private float eYz;
    private int mLastX;
    private int mLastY;
    private ListView mListView;
    private DataSetObserver mObserver;
    private int mOffsetX;
    private int mOffsetY;
    private int mX;
    private int mY;
    private Point eXY = new Point();
    private Point eXZ = new Point();
    private boolean eYb = false;
    private float eYc = 1.0f;
    private float eYd = 1.0f;
    private boolean eYh = false;
    private boolean dcS = true;
    private int mDragState = 0;
    private int eYo = 1;
    private int mWidthMeasureSpec = 0;
    private View[] eYq = new View[1];
    private float eYs = 0.33333334f;
    private float eYt = 0.33333334f;
    private float eYA = 0.5f;
    private c eYB = new c() { // from class: com.baidu.tbadk.widget.dragsort.a.1
        @Override // com.baidu.tbadk.widget.dragsort.a.c
        public float b(float f2, long j2) {
            return a.this.eYA * f2;
        }
    };
    private int eYD = 0;
    private boolean eYE = false;
    private boolean eYF = false;
    private h eYG = null;
    private int eYI = 0;
    private float eYJ = 0.25f;
    private float eYK = 0.0f;
    private boolean eYM = false;
    private boolean mBlockLayoutRequests = false;
    private boolean eYO = false;
    private i eYP = new i(3);
    private float eYU = 0.0f;
    private boolean eYX = false;
    private boolean eYY = false;

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

        void bu(View view);

        View qT(int i);
    }

    /* loaded from: classes.dex */
    public interface l {
        void remove(int i);
    }

    public a(ListView listView, com.baidu.tbadk.widget.dragsort.d dVar) {
        this.eYV = dVar;
        this.mListView = listView;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            this.eYL = new C0561a(listAdapter);
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
            this.eYL = null;
        }
        this.eYV.setAdapter(this.eYL);
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
            if (i2 > this.eYi) {
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
        int i4 = this.cLt - this.eYo;
        int qR = qR(i2);
        int qP = qP(i2);
        if (this.eYg <= this.eYi) {
            if (i2 == this.eYg && this.eYf != this.eYg) {
                if (i2 == this.eYi) {
                    i3 = (i3 + qP) - this.cLt;
                } else {
                    i3 = ((qP - qR) + i3) - i4;
                }
            } else if (i2 > this.eYg && i2 <= this.eYi) {
                i3 -= i4;
            }
        } else if (i2 > this.eYi && i2 <= this.eYf) {
            i3 += i4;
        } else if (i2 == this.eYg && this.eYf != this.eYg) {
            i3 += qP - qR;
        }
        if (i2 <= this.eYi) {
            return (((this.cLt - dividerHeight) - qR(i2 - 1)) / 2) + i3;
        }
        return (((qR - dividerHeight) - this.cLt) / 2) + i3;
    }

    private boolean bwv() {
        int i2;
        int i3;
        int i4;
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int i5 = this.eYf;
        View childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        if (childAt == null) {
            i5 = firstVisiblePosition + (this.mListView.getChildCount() / 2);
            childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        }
        int top = childAt.getTop();
        int height = childAt.getHeight();
        int bk = bk(i5, top);
        int dividerHeight = this.mListView.getDividerHeight();
        if (this.eYa >= bk) {
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
                    if (this.eYa < i2) {
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
                if (this.eYa >= i2) {
                    break;
                }
                i4 = i2;
            }
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int i9 = this.eYf;
        int i10 = this.eYg;
        float f2 = this.eYK;
        if (this.eYh) {
            int abs = Math.abs(i2 - i4);
            if (this.eYa >= i2) {
                int i11 = i4;
                i4 = i2;
                i2 = i11;
            }
            int i12 = (int) (abs * this.eYJ * 0.5f);
            float f3 = i12;
            int i13 = i4 + i12;
            int i14 = i2 - i12;
            if (this.eYa < i13) {
                this.eYf = i3 - 1;
                this.eYg = i3;
                this.eYK = ((i13 - this.eYa) * 0.5f) / f3;
            } else if (this.eYa < i14) {
                this.eYf = i3;
                this.eYg = i3;
            } else {
                this.eYf = i3;
                this.eYg = i3 + 1;
                this.eYK = (1.0f + ((i2 - this.eYa) / f3)) * 0.5f;
            }
        } else {
            this.eYf = i3;
            this.eYg = i3;
        }
        if (this.eYf < headerViewsCount) {
            this.eYf = headerViewsCount;
            this.eYg = headerViewsCount;
            i3 = headerViewsCount;
        } else if (this.eYg >= this.mListView.getCount() - footerViewsCount) {
            i3 = (this.mListView.getCount() - footerViewsCount) - 1;
            this.eYf = i3;
            this.eYg = i3;
        }
        boolean z = (this.eYf == i9 && this.eYg == i10 && this.eYK == f2) ? false : true;
        if (i3 != this.eYe) {
            if (this.eYl != null) {
                this.eYl.drag(this.eYe - headerViewsCount, i3 - headerViewsCount);
            }
            this.eYe = i3;
            return true;
        }
        return z;
    }

    public void removeItem(int i2) {
        this.eYT = false;
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
            this.eYo = Math.max(1, obtainStyledAttributes.getDimensionPixelSize(R.styleable.DragSort_collapsed_height, 1));
            this.eYM = obtainStyledAttributes.getBoolean(R.styleable.DragSort_track_drag_sort, false);
            if (this.eYM) {
                this.eYN = new e();
            }
            this.eYc = obtainStyledAttributes.getFloat(R.styleable.DragSort_float_alpha, this.eYc);
            this.eYd = this.eYc;
            this.dcS = obtainStyledAttributes.getBoolean(R.styleable.DragSort_drag_enabled, this.dcS);
            this.eYJ = Math.max(0.0f, Math.min(1.0f, 1.0f - obtainStyledAttributes.getFloat(R.styleable.DragSort_slide_shuffle_speed, 0.75f)));
            this.eYh = this.eYJ > 0.0f;
            setDragScrollStart(obtainStyledAttributes.getFloat(R.styleable.DragSort_drag_scroll_start, this.eYs));
            this.eYA = obtainStyledAttributes.getFloat(R.styleable.DragSort_max_drag_scroll_speed, this.eYA);
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
                bVar.jU(z);
                bVar.jT(z2);
                bVar.setBackgroundColor(color);
                this.eYG = bVar;
                a(bVar);
            }
            obtainStyledAttributes.recycle();
            i2 = i5;
            i3 = i4;
        }
        this.eYr = new d();
        if (i3 > 0) {
            this.eYQ = new k(0.5f, i3);
        }
        if (i2 > 0) {
            this.eYS = new f(0.5f, i2);
        }
        this.eYH = MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
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
        this.eYW = bVar;
        this.mListView.setOnTouchListener(bVar);
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void dispatchDraw(Canvas canvas) {
        float f2;
        this.eYV.dispatchDraw(canvas);
        if (this.mDragState != 0) {
            if (this.eYf != this.eYi) {
                b(this.eYf, canvas);
            }
            if (this.eYg != this.eYf && this.eYg != this.eYi) {
                b(this.eYg, canvas);
            }
        }
        if (this.eXX != null) {
            int width = this.eXX.getWidth();
            int height = this.eXX.getHeight();
            int i2 = this.eXY.x;
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
            int i3 = (int) (f2 * 255.0f * this.eYd);
            canvas.save();
            canvas.translate(this.eXY.x, this.eXY.y);
            canvas.clipRect(0, 0, width, height);
            canvas.saveLayerAlpha(0.0f, 0.0f, width, height, i3, 31);
            this.eXX.draw(canvas);
            canvas.restore();
            canvas.restore();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onDraw(Canvas canvas) {
        this.eYV.onDraw(canvas);
        if (this.eYM) {
            this.eYN.bwI();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.eYO) {
            this.eYO = false;
            return false;
        } else if (!this.dcS) {
            return this.eYV.onTouchEvent(motionEvent);
        } else {
            boolean z2 = this.eYE;
            this.eYE = false;
            if (!z2) {
                G(motionEvent);
            }
            if (this.mDragState == 4) {
                onDragTouchEvent(motionEvent);
                return true;
            }
            if (this.mDragState == 0 && this.eYV.onTouchEvent(motionEvent)) {
                z = true;
            }
            switch (motionEvent.getAction() & 255) {
                case 1:
                case 3:
                    bwA();
                    return z;
                case 2:
                default:
                    if (z) {
                        this.eYI = 1;
                        return z;
                    }
                    return z;
            }
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (!this.dcS) {
            return this.eYV.onInterceptTouchEvent(motionEvent);
        }
        if (this.eYW != null) {
            this.eYW.bwK().onTouchEvent(motionEvent);
        }
        G(motionEvent);
        this.eYE = true;
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            if (this.mDragState != 0) {
                this.eYO = true;
                return true;
            }
            this.eYF = true;
        }
        if (this.eXX == null) {
            if (this.eYV.onInterceptTouchEvent(motionEvent)) {
                this.eYX = true;
                z = true;
            } else {
                z = false;
            }
            switch (action) {
                case 1:
                case 3:
                    bwA();
                    break;
                case 2:
                default:
                    if (z) {
                        this.eYI = 1;
                        break;
                    } else {
                        this.eYI = 2;
                        break;
                    }
            }
        } else {
            z = true;
        }
        if (action == 1 || action == 3) {
            this.eYF = false;
        }
        return z;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        this.eYV.onSizeChanged(i2, i3, i4, i5);
        bwB();
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void requestLayout() {
        if (!this.mBlockLayoutRequests) {
            this.eYV.requestLayout();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onMeasure(int i2, int i3) {
        this.eYV.onMeasure(i2, i3);
        if (this.eXX != null) {
            if (this.eXX.isLayoutRequested()) {
                bwD();
            }
            this.eYb = true;
        }
        this.mWidthMeasureSpec = i2;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void layoutChildren() {
        this.eYV.layoutChildren();
        if (this.eXX != null) {
            if (this.eXX.isLayoutRequested() && !this.eYb) {
                bwD();
            }
            this.eXX.layout(0, 0, this.eXX.getMeasuredWidth(), this.eXX.getMeasuredHeight());
            this.eYb = false;
        }
    }

    public void removeItem(int i2, float f2) {
        if (this.mDragState == 0 || this.mDragState == 4) {
            if (this.mDragState == 0) {
                this.eYi = this.mListView.getHeaderViewsCount() + i2;
                this.eYf = this.eYi;
                this.eYg = this.eYi;
                this.eYe = this.eYi;
                View childAt = this.mListView.getChildAt(this.eYi - this.mListView.getFirstVisiblePosition());
                if (childAt != null) {
                    childAt.setVisibility(4);
                }
            }
            this.mDragState = 1;
            this.eYU = f2;
            if (this.eYF) {
                switch (this.eYI) {
                    case 1:
                        this.eYV.onTouchEvent(this.eYH);
                        break;
                    case 2:
                        this.eYV.onInterceptTouchEvent(this.eYH);
                        break;
                }
            }
            if (this.eYQ != null) {
                this.eYQ.start();
            } else {
                qQ(i2);
            }
        }
    }

    public void cancelDrag() {
        if (this.mDragState == 4) {
            this.eYr.jS(true);
            bwF();
            bww();
            bwC();
            if (this.eYF) {
                this.mDragState = 3;
            } else {
                this.mDragState = 0;
            }
        }
    }

    private void bww() {
        this.eYi = -1;
        this.eYf = -1;
        this.eYg = -1;
        this.eYe = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwx() {
        this.mDragState = 2;
        if (this.eYm != null && this.eYe >= 0 && this.eYe < this.mListView.getCount()) {
            int headerViewsCount = this.mListView.getHeaderViewsCount();
            this.eYm.drop(this.eYi - headerViewsCount, this.eYe - headerViewsCount);
        }
        bwF();
        bwz();
        bww();
        bwC();
        if (this.eYF) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwy() {
        qQ(this.eYi - this.mListView.getHeaderViewsCount());
    }

    private void qQ(int i2) {
        this.mDragState = 1;
        if (this.eYn != null) {
            this.eYn.remove(i2);
        }
        bwF();
        bwz();
        bww();
        if (this.eYF) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    private void bwz() {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        if (this.eYi < firstVisiblePosition) {
            View childAt = this.mListView.getChildAt(0);
            this.mListView.setSelectionFromTop(firstVisiblePosition - 1, (childAt != null ? childAt.getTop() : 0) - this.mListView.getPaddingTop());
        }
    }

    public boolean stopDrag(boolean z) {
        this.eYT = false;
        return stopDrag(z, 0.0f);
    }

    public boolean stopDragWithVelocity(boolean z, float f2) {
        this.eYT = true;
        return stopDrag(z, f2);
    }

    public boolean stopDrag(boolean z, float f2) {
        if (this.eXX != null) {
            this.eYr.jS(true);
            if (z) {
                removeItem(this.eYi - this.mListView.getHeaderViewsCount(), f2);
            } else if (this.eYS != null) {
                this.eYS.start();
            } else {
                bwx();
            }
            if (this.eYM) {
                this.eYN.stopTracking();
                return true;
            }
            return true;
        }
        return false;
    }

    private void bwA() {
        this.eYI = 0;
        this.eYF = false;
        if (this.mDragState == 3) {
            this.mDragState = 0;
        }
        this.eYd = this.eYc;
        this.eYX = false;
        this.eYP.clear();
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
        return this.eYX;
    }

    public void setDragScrollStart(float f2) {
        setDragScrollStarts(f2, f2);
    }

    public void setDragScrollStarts(float f2, float f3) {
        if (f3 > 0.5f) {
            this.eYt = 0.5f;
        } else {
            this.eYt = f3;
        }
        if (f2 > 0.5f) {
            this.eYs = 0.5f;
        } else {
            this.eYs = f2;
        }
        if (this.mListView.getHeight() != 0) {
            bwB();
        }
    }

    private void bl(int i2, int i3) {
        this.eXY.x = i2 - this.eYj;
        this.eXY.y = i3 - this.eYk;
        jR(true);
        int min = Math.min(i3, this.eYa + this.eYp);
        int max = Math.max(i3, this.eYa - this.eYp);
        int bwG = this.eYr.bwG();
        if (min > this.mLastY && min > this.eYv && bwG != 1) {
            if (bwG != -1) {
                this.eYr.jS(true);
            }
            this.eYr.qS(1);
        } else if (max < this.mLastY && max < this.eYu && bwG != 0) {
            if (bwG != -1) {
                this.eYr.jS(true);
            }
            this.eYr.qS(0);
        } else if (max >= this.eYu && min <= this.eYv && this.eYr.isScrolling()) {
            this.eYr.jS(true);
        }
    }

    private void bwB() {
        int height;
        int paddingTop = this.mListView.getPaddingTop();
        float height2 = (this.mListView.getHeight() - paddingTop) - this.mListView.getPaddingBottom();
        this.eYx = paddingTop + (this.eYs * height2);
        this.eYw = (height2 * (1.0f - this.eYt)) + paddingTop;
        this.eYu = (int) this.eYx;
        this.eYv = (int) this.eYw;
        this.eYy = this.eYx - paddingTop;
        this.eYz = (paddingTop + height) - this.eYw;
    }

    private void bwC() {
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
        if (i2 != this.eYi && i2 != this.eYf && i2 != this.eYg) {
            g2 = -2;
        } else {
            g2 = g(i2, view, z);
        }
        if (g2 != layoutParams.height) {
            layoutParams.height = g2;
            view.setLayoutParams(layoutParams);
        }
        if (i2 == this.eYf || i2 == this.eYg) {
            if (i2 < this.eYi) {
                ((DragSortItemView) view).setGravity(80);
            } else if (i2 > this.eYi) {
                ((DragSortItemView) view).setGravity(48);
            }
        }
        int visibility = view.getVisibility();
        int i3 = 0;
        if (i2 == this.eYi && this.eXX != null) {
            i3 = 4;
        }
        if (i3 != visibility) {
            view.setVisibility(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int qR(int i2) {
        View view;
        if (i2 == this.eYi) {
            return 0;
        }
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        if (childAt != null) {
            return f(i2, childAt, false);
        }
        int i3 = this.eYP.get(i2);
        if (i3 == -1) {
            ListAdapter adapter = this.mListView.getAdapter();
            int itemViewType = adapter.getItemViewType(i2);
            int viewTypeCount = adapter.getViewTypeCount();
            if (viewTypeCount != this.eYq.length) {
                this.eYq = new View[viewTypeCount];
            }
            if (itemViewType >= 0) {
                if (this.eYq[itemViewType] == null) {
                    view = adapter.getView(i2, null, this.mListView);
                    this.eYq[itemViewType] = view;
                } else {
                    view = adapter.getView(i2, this.eYq[itemViewType], this.mListView);
                }
            } else {
                view = adapter.getView(i2, null, this.mListView);
            }
            int f2 = f(i2, view, true);
            this.eYP.bn(i2, f2);
            return f2;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(int i2, View view, boolean z) {
        if (i2 == this.eYi) {
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
        boolean z = this.eYh && this.eYf != this.eYg;
        int i4 = this.cLt - this.eYo;
        int i5 = (int) (this.eYK * i4);
        if (i2 == this.eYi) {
            if (this.eYi == this.eYf) {
                if (z) {
                    return i5 + this.eYo;
                }
                return this.cLt;
            } else if (this.eYi == this.eYg) {
                return this.cLt - i5;
            } else {
                return this.eYo;
            }
        } else if (i2 == this.eYf) {
            if (z) {
                return i3 + i5;
            }
            return i3 + i4;
        } else if (i2 == this.eYg) {
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
        if (i2 != this.eYi) {
            i6 = height - qR;
            i5 = bm - qR;
        } else {
            i5 = bm;
            i6 = height;
        }
        int i7 = this.cLt;
        if (this.eYi != this.eYf && this.eYi != this.eYg) {
            i7 -= this.eYo;
        }
        if (i2 <= i3) {
            if (i2 > this.eYf) {
                return (i7 - i5) + 0;
            }
        } else if (i2 == i4) {
            if (i2 <= this.eYf) {
                return (i6 - i7) + 0;
            }
            if (i2 == this.eYg) {
                return (height - bm) + 0;
            }
            return 0 + i6;
        } else if (i2 <= this.eYf) {
            return 0 - i7;
        } else {
            if (i2 == this.eYg) {
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

    private void bwD() {
        if (this.eXX != null) {
            measureItem(this.eXX);
            this.cLt = this.eXX.getMeasuredHeight();
            this.eYp = this.cLt / 2;
        }
    }

    protected boolean onDragTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        switch (motionEvent.getAction() & 255) {
            case 1:
                if (this.mDragState == 4) {
                    stopDrag(false);
                }
                bwA();
                return true;
            case 2:
                bl((int) motionEvent.getX(), (int) motionEvent.getY());
                return true;
            case 3:
                if (this.mDragState == 4) {
                    cancelDrag();
                }
                bwA();
                return true;
            default:
                return true;
        }
    }

    public boolean startDrag(int i2, int i3, int i4, int i5) {
        View qT;
        if (!this.eYF || this.eYG == null || (qT = this.eYG.qT(i2)) == null) {
            return false;
        }
        return startDrag(i2, qT, i3, i4, i5);
    }

    public boolean startDrag(int i2, View view, int i3, int i4, int i5) {
        if (this.mDragState == 0 && this.eYF && this.eXX == null && view != null && this.dcS) {
            if (this.mListView.getParent() != null) {
                this.mListView.getParent().requestDisallowInterceptTouchEvent(true);
            }
            int headerViewsCount = this.mListView.getHeaderViewsCount() + i2;
            this.eYf = headerViewsCount;
            this.eYg = headerViewsCount;
            this.eYi = headerViewsCount;
            this.eYe = headerViewsCount;
            this.mDragState = 4;
            this.eYD = 0;
            this.eYD |= i3;
            this.eXX = view;
            bwD();
            this.eYj = i4;
            this.eYk = i5;
            this.eYC = this.mY;
            this.eXY.x = this.mX - this.eYj;
            this.eXY.y = this.mY - this.eYk;
            View childAt = this.mListView.getChildAt(this.eYi - this.mListView.getFirstVisiblePosition());
            if (childAt != null) {
                childAt.setVisibility(4);
            }
            if (this.eYM) {
                this.eYN.bwH();
            }
            switch (this.eYI) {
                case 1:
                    this.eYV.onTouchEvent(this.eYH);
                    break;
                case 2:
                    this.eYV.onInterceptTouchEvent(this.eYH);
                    break;
            }
            this.mListView.requestLayout();
            if (this.eYR != null) {
                this.eYR.start();
                return true;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jR(boolean z) {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition() + (this.mListView.getChildCount() / 2);
        View childAt = this.mListView.getChildAt(this.mListView.getChildCount() / 2);
        if (childAt != null) {
            h(firstVisiblePosition, childAt, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i2, View view, boolean z) {
        this.mBlockLayoutRequests = true;
        bwE();
        int i3 = this.eYf;
        int i4 = this.eYg;
        boolean bwv = bwv();
        if (bwv) {
            bwC();
            this.mListView.setSelectionFromTop(i2, (b(i2, view, i3, i4) + view.getTop()) - this.mListView.getPaddingTop());
            layoutChildren();
        }
        if (bwv || z) {
            this.mListView.invalidate();
        }
        this.mBlockLayoutRequests = false;
    }

    private void bwE() {
        if (this.eYG != null) {
            this.eXZ.set(this.mX, this.mY);
            this.eYG.b(this.eXX, this.eXY, this.eXZ);
        }
        int i2 = this.eXY.x;
        int i3 = this.eXY.y;
        int paddingLeft = this.mListView.getPaddingLeft();
        if ((this.eYD & 1) == 0 && i2 > paddingLeft) {
            this.eXY.x = paddingLeft;
        } else if ((this.eYD & 2) == 0 && i2 < paddingLeft) {
            this.eXY.x = paddingLeft;
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int lastVisiblePosition = this.mListView.getLastVisiblePosition();
        int paddingTop = this.mListView.getPaddingTop();
        if (firstVisiblePosition < headerViewsCount) {
            paddingTop = this.mListView.getChildAt((headerViewsCount - firstVisiblePosition) - 1).getBottom();
        }
        if ((this.eYD & 8) == 0 && firstVisiblePosition <= this.eYi) {
            paddingTop = Math.max(this.mListView.getChildAt(this.eYi - firstVisiblePosition).getTop(), paddingTop);
        }
        int height = this.mListView.getHeight() - this.mListView.getPaddingBottom();
        if (lastVisiblePosition >= (this.mListView.getCount() - footerViewsCount) - 1) {
            height = this.mListView.getChildAt(((this.mListView.getCount() - footerViewsCount) - 1) - firstVisiblePosition).getBottom();
        }
        if ((this.eYD & 4) == 0 && lastVisiblePosition >= this.eYi) {
            height = Math.min(this.mListView.getChildAt(this.eYi - firstVisiblePosition).getBottom(), height);
        }
        if (i3 < paddingTop) {
            this.eXY.y = paddingTop;
        } else if (this.cLt + i3 > height) {
            this.eXY.y = height - this.cLt;
        }
        this.eYa = this.eXY.y + this.eYp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwF() {
        if (this.eXX != null) {
            this.eXX.setVisibility(8);
            if (this.eYG != null) {
                this.eYG.bu(this.eXX);
            }
            this.eXX = null;
            this.mListView.invalidate();
        }
    }

    public void a(h hVar) {
        this.eYG = hVar;
    }

    public void a(b bVar) {
        this.eYl = bVar;
    }

    public void setDragEnabled(boolean z) {
        this.dcS = z;
    }

    public boolean isDragEnabled() {
        return this.dcS;
    }

    public void a(g gVar) {
        this.eYm = gVar;
    }

    public void a(l lVar) {
        this.eYn = lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class i {
        private SparseIntArray eZr;
        private ArrayList<Integer> eZs;
        private int mMaxSize;

        public i(int i) {
            this.eZr = new SparseIntArray(i);
            this.eZs = new ArrayList<>(i);
            this.mMaxSize = i;
        }

        public void bn(int i, int i2) {
            int i3 = this.eZr.get(i, -1);
            if (i3 != i2) {
                if (i3 == -1) {
                    if (this.eZr.size() == this.mMaxSize) {
                        this.eZr.delete(this.eZs.remove(0).intValue());
                    }
                } else {
                    this.eZs.remove(Integer.valueOf(i));
                }
                this.eZr.put(i, i2);
                this.eZs.add(Integer.valueOf(i));
            }
        }

        public int get(int i) {
            return this.eZr.get(i, -1);
        }

        public void clear() {
            this.eZr.clear();
            this.eZs.clear();
        }
    }

    /* renamed from: com.baidu.tbadk.widget.dragsort.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
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
    /* loaded from: classes.dex */
    public class m implements Runnable {
        private float bZU;
        private float bZV;
        private float bZW;
        private float bZX;
        private float eZC;
        private float mAlpha;
        private boolean mCanceled;
        protected long mStartTime;

        public m(float f, int i) {
            this.mAlpha = f;
            this.eZC = i;
            float f2 = 1.0f / ((this.mAlpha * 2.0f) * (1.0f - this.mAlpha));
            this.bZX = f2;
            this.bZU = f2;
            this.bZV = this.mAlpha / ((this.mAlpha - 1.0f) * 2.0f);
            this.bZW = 1.0f / (1.0f - this.mAlpha);
        }

        public float ag(float f) {
            if (f < this.mAlpha) {
                return this.bZU * f * f;
            }
            if (f < 1.0f - this.mAlpha) {
                return this.bZV + (this.bZW * f);
            }
            return 1.0f - ((this.bZX * (f - 1.0f)) * (f - 1.0f));
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
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / this.eZC;
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
    /* loaded from: classes.dex */
    public class f extends m {
        private int eZn;
        private int eZo;
        private float eZp;
        private float eZq;

        public f(float f, int i) {
            super(f, i);
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.eZn = a.this.eYe;
            this.eZo = a.this.eYi;
            a.this.mDragState = 2;
            this.eZp = a.this.eXY.y - bwJ();
            this.eZq = a.this.eXY.x - a.this.mListView.getPaddingLeft();
        }

        private int bwJ() {
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            int dividerHeight = (a.this.eYo + a.this.mListView.getDividerHeight()) / 2;
            View childAt = a.this.mListView.getChildAt(this.eZn - firstVisiblePosition);
            if (childAt != null) {
                if (this.eZn == this.eZo) {
                    return childAt.getTop();
                }
                if (this.eZn >= this.eZo) {
                    return (childAt.getBottom() + dividerHeight) - a.this.cLt;
                }
                return childAt.getTop() - dividerHeight;
            }
            cancel();
            return -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void w(float f, float f2) {
            int bwJ = bwJ();
            float paddingLeft = a.this.eXY.x - a.this.mListView.getPaddingLeft();
            float f3 = 1.0f - f2;
            if (f3 < Math.abs((a.this.eXY.y - bwJ) / this.eZp) || f3 < Math.abs(paddingLeft / this.eZq)) {
                a.this.eXY.y = bwJ + ((int) (this.eZp * f3));
                a.this.eXY.x = a.this.mListView.getPaddingLeft() + ((int) (this.eZq * f3));
                a.this.jR(true);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.bwx();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class k extends m {
        private int eZA;
        private int eZB;
        private int eZo;
        private float eZv;
        private float eZw;
        private float eZx;
        private int eZy;
        private int eZz;

        public k(float f, int i) {
            super(f, i);
            this.eZy = -1;
            this.eZz = -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.eZy = -1;
            this.eZz = -1;
            this.eZA = a.this.eYf;
            this.eZB = a.this.eYg;
            this.eZo = a.this.eYi;
            a.this.mDragState = 1;
            this.eZv = a.this.eXY.x;
            if (a.this.eYT) {
                float width = a.this.mListView.getWidth() * 2.0f;
                if (a.this.eYU == 0.0f) {
                    a.this.eYU = (this.eZv >= 0.0f ? 1 : -1) * width;
                    return;
                }
                float f = width * 2.0f;
                if (a.this.eYU >= 0.0f || a.this.eYU <= (-f)) {
                    if (a.this.eYU > 0.0f && a.this.eYU < f) {
                        a.this.eYU = f;
                        return;
                    }
                    return;
                }
                a.this.eYU = -f;
                return;
            }
            a.this.bwF();
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void w(float f, float f2) {
            View childAt;
            float f3 = 1.0f - f2;
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            View childAt2 = a.this.mListView.getChildAt(this.eZA - firstVisiblePosition);
            if (a.this.eYT) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / 1000.0f;
                if (uptimeMillis != 0.0f) {
                    float f4 = a.this.eYU * uptimeMillis;
                    int width = a.this.mListView.getWidth();
                    a.this.eYU = ((a.this.eYU > 0.0f ? 1 : -1) * uptimeMillis * width) + a.this.eYU;
                    this.eZv += f4;
                    a.this.eXY.x = (int) this.eZv;
                    if (this.eZv < width && this.eZv > (-width)) {
                        this.mStartTime = SystemClock.uptimeMillis();
                        a.this.jR(true);
                        return;
                    }
                } else {
                    return;
                }
            }
            if (childAt2 != null) {
                if (this.eZy == -1) {
                    this.eZy = a.this.f(this.eZA, childAt2, false);
                    this.eZw = childAt2.getHeight() - this.eZy;
                }
                int max = Math.max((int) (this.eZw * f3), 1);
                ViewGroup.LayoutParams layoutParams = childAt2.getLayoutParams();
                layoutParams.height = max + this.eZy;
                childAt2.setLayoutParams(layoutParams);
            }
            if (this.eZB != this.eZA && (childAt = a.this.mListView.getChildAt(this.eZB - firstVisiblePosition)) != null) {
                if (this.eZz == -1) {
                    this.eZz = a.this.f(this.eZB, childAt, false);
                    this.eZx = childAt.getHeight() - this.eZz;
                }
                int max2 = Math.max((int) (this.eZx * f3), 1);
                ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
                layoutParams2.height = max2 + this.eZz;
                childAt.setLayoutParams(layoutParams2);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.bwy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class j extends m {
        final /* synthetic */ a eYZ;
        private float eZt;
        private float eZu;

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.eZt = this.eYZ.eYk;
            this.eZu = this.eYZ.eYp;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void w(float f, float f2) {
            if (this.eYZ.mDragState != 4) {
                cancel();
                return;
            }
            this.eYZ.eYk = (int) ((this.eZu * f2) + ((1.0f - f2) * this.eZt));
            this.eYZ.eXY.y = this.eYZ.mY - this.eYZ.eYk;
            this.eYZ.jR(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e {
        StringBuilder mBuilder = new StringBuilder();
        private int eZk = 0;
        private int eZl = 0;
        private boolean eZm = false;
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

        public void bwH() {
            this.mBuilder.append("<DSLVStates>\n");
            this.eZl = 0;
            this.eZm = true;
        }

        public void bwI() {
            if (this.eZm) {
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
                this.mBuilder.append("    <FirstExpPos>").append(a.this.eYf).append("</FirstExpPos>\n");
                this.mBuilder.append("    <FirstExpBlankHeight>").append(a.this.qP(a.this.eYf) - a.this.qR(a.this.eYf)).append("</FirstExpBlankHeight>\n");
                this.mBuilder.append("    <SecondExpPos>").append(a.this.eYg).append("</SecondExpPos>\n");
                this.mBuilder.append("    <SecondExpBlankHeight>").append(a.this.qP(a.this.eYg) - a.this.qR(a.this.eYg)).append("</SecondExpBlankHeight>\n");
                this.mBuilder.append("    <SrcPos>").append(a.this.eYi).append("</SrcPos>\n");
                this.mBuilder.append("    <SrcHeight>").append(a.this.cLt + a.this.mListView.getDividerHeight()).append("</SrcHeight>\n");
                this.mBuilder.append("    <ViewHeight>").append(a.this.mListView.getHeight()).append("</ViewHeight>\n");
                this.mBuilder.append("    <LastY>").append(a.this.mLastY).append("</LastY>\n");
                this.mBuilder.append("    <FloatY>").append(a.this.eYa).append("</FloatY>\n");
                this.mBuilder.append("    <ShuffleEdges>");
                for (int i4 = 0; i4 < childCount; i4++) {
                    this.mBuilder.append(a.this.bk(firstVisiblePosition + i4, a.this.mListView.getChildAt(i4).getTop())).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                this.mBuilder.append("</ShuffleEdges>\n");
                this.mBuilder.append("</DSLVState>\n");
                this.eZk++;
                if (this.eZk > 1000) {
                    flush();
                    this.eZk = 0;
                }
            }
        }

        public void flush() {
            if (this.eZm) {
                try {
                    FileWriter fileWriter = new FileWriter(this.mFile, this.eZl != 0);
                    fileWriter.write(this.mBuilder.toString());
                    this.mBuilder.delete(0, this.mBuilder.length());
                    fileWriter.flush();
                    fileWriter.close();
                    this.eZl++;
                } catch (IOException e) {
                }
            }
        }

        public void stopTracking() {
            if (this.eZm) {
                this.mBuilder.append("</DSLVStates>\n");
                flush();
                this.eZm = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements Runnable {
        private boolean eZc;
        private long eZd;
        private long eZe;
        private int eZf;
        private float eZg;
        private long eZh;
        private int eZi;
        private float eZj;
        private boolean mScrolling = false;

        public boolean isScrolling() {
            return this.mScrolling;
        }

        public int bwG() {
            if (this.mScrolling) {
                return this.eZi;
            }
            return -1;
        }

        public d() {
        }

        public void qS(int i) {
            if (!this.mScrolling) {
                this.eZc = false;
                this.mScrolling = true;
                this.eZh = SystemClock.uptimeMillis();
                this.eZd = this.eZh;
                this.eZi = i;
                a.this.mListView.post(this);
            }
        }

        public void jS(boolean z) {
            if (z) {
                a.this.mListView.removeCallbacks(this);
                this.mScrolling = false;
                return;
            }
            this.eZc = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.eZc) {
                int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
                int lastVisiblePosition = a.this.mListView.getLastVisiblePosition();
                int count = a.this.mListView.getCount();
                int paddingTop = a.this.mListView.getPaddingTop();
                int height = (a.this.mListView.getHeight() - paddingTop) - a.this.mListView.getPaddingBottom();
                int min = Math.min(a.this.mY, a.this.eYa + a.this.eYp);
                int max = Math.max(a.this.mY, a.this.eYa - a.this.eYp);
                if (this.eZi == 0) {
                    View childAt = a.this.mListView.getChildAt(0);
                    if (childAt == null) {
                        this.mScrolling = false;
                        return;
                    } else if (firstVisiblePosition == 0 && childAt.getTop() == paddingTop) {
                        this.mScrolling = false;
                        return;
                    } else {
                        this.eZj = a.this.eYB.b((a.this.eYx - max) / a.this.eYy, this.eZd);
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
                        this.eZj = -a.this.eYB.b((min - a.this.eYw) / a.this.eYz, this.eZd);
                    }
                }
                this.eZe = SystemClock.uptimeMillis();
                this.eZg = (float) (this.eZe - this.eZd);
                this.eZf = Math.round(this.eZj * this.eZg);
                if (this.eZf >= 0) {
                    this.eZf = Math.min(height, this.eZf);
                    lastVisiblePosition = firstVisiblePosition;
                } else {
                    this.eZf = Math.max(-height, this.eZf);
                }
                View childAt3 = a.this.mListView.getChildAt(lastVisiblePosition - firstVisiblePosition);
                int top = childAt3.getTop() + this.eZf;
                if (lastVisiblePosition == 0 && top > paddingTop) {
                    top = paddingTop;
                }
                a.this.mBlockLayoutRequests = true;
                a.this.mListView.setSelectionFromTop(lastVisiblePosition, top - paddingTop);
                a.this.layoutChildren();
                a.this.mListView.invalidate();
                a.this.mBlockLayoutRequests = false;
                a.this.h(lastVisiblePosition, childAt3, false);
                this.eZd = this.eZe;
                a.this.mListView.post(this);
                return;
            }
            this.mScrolling = false;
        }
    }
}
