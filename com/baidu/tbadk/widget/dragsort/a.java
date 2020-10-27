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
    private int dhX;
    private View fvC;
    private int fvF;
    private int fvJ;
    private int fvK;
    private int fvL;
    private int fvN;
    private int fvO;
    private int fvP;
    private b fvQ;
    private g fvR;
    private l fvS;
    private int fvU;
    private d fvW;
    private int fvZ;
    private com.baidu.tbadk.widget.dragsort.d fwA;
    private com.baidu.tbadk.widget.dragsort.b fwB;
    private int fwa;
    private float fwb;
    private float fwc;
    private float fwd;
    private float fwe;
    private int fwh;
    private MotionEvent fwm;
    private C0588a fwq;
    private e fws;
    private k fwv;
    private j fww;
    private f fwx;
    private boolean fwy;
    private int mLastX;
    private int mLastY;
    private ListView mListView;
    private DataSetObserver mObserver;
    private int mOffsetX;
    private int mOffsetY;
    private int mX;
    private int mY;
    private Point fvD = new Point();
    private Point fvE = new Point();
    private boolean fvG = false;
    private float fvH = 1.0f;
    private float fvI = 1.0f;
    private boolean fvM = false;
    private boolean dzA = true;
    private int mDragState = 0;
    private int fvT = 1;
    private int mWidthMeasureSpec = 0;
    private View[] fvV = new View[1];
    private float fvX = 0.33333334f;
    private float fvY = 0.33333334f;
    private float fwf = 0.5f;
    private c fwg = new c() { // from class: com.baidu.tbadk.widget.dragsort.a.1
        @Override // com.baidu.tbadk.widget.dragsort.a.c
        public float b(float f2, long j2) {
            return a.this.fwf * f2;
        }
    };
    private int fwi = 0;
    private boolean fwj = false;
    private boolean fwk = false;
    private h fwl = null;
    private int fwn = 0;
    private float fwo = 0.25f;
    private float fwp = 0.0f;
    private boolean fwr = false;
    private boolean mBlockLayoutRequests = false;
    private boolean fwt = false;
    private i fwu = new i(3);
    private float fwz = 0.0f;
    private boolean fwC = false;
    private boolean fwD = false;

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

        void bD(View view);

        View rT(int i);
    }

    /* loaded from: classes.dex */
    public interface l {
        void remove(int i);
    }

    public a(ListView listView, com.baidu.tbadk.widget.dragsort.d dVar) {
        this.fwA = dVar;
        this.mListView = listView;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            this.fwq = new C0588a(listAdapter);
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
            this.fwq = null;
        }
        this.fwA.setAdapter(this.fwq);
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
            if (i2 > this.fvN) {
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
    public int rP(int i2) {
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        return childAt != null ? childAt.getHeight() : bm(i2, rR(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bk(int i2, int i3) {
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        if (i2 <= headerViewsCount || i2 >= this.mListView.getCount() - footerViewsCount) {
            return i3;
        }
        int dividerHeight = this.mListView.getDividerHeight();
        int i4 = this.dhX - this.fvT;
        int rR = rR(i2);
        int rP = rP(i2);
        if (this.fvL <= this.fvN) {
            if (i2 == this.fvL && this.fvK != this.fvL) {
                if (i2 == this.fvN) {
                    i3 = (i3 + rP) - this.dhX;
                } else {
                    i3 = ((rP - rR) + i3) - i4;
                }
            } else if (i2 > this.fvL && i2 <= this.fvN) {
                i3 -= i4;
            }
        } else if (i2 > this.fvN && i2 <= this.fvK) {
            i3 += i4;
        } else if (i2 == this.fvL && this.fvK != this.fvL) {
            i3 += rP - rR;
        }
        if (i2 <= this.fvN) {
            return (((this.dhX - dividerHeight) - rR(i2 - 1)) / 2) + i3;
        }
        return (((rR - dividerHeight) - this.dhX) / 2) + i3;
    }

    private boolean bCh() {
        int i2;
        int i3;
        int i4;
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int i5 = this.fvK;
        View childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        if (childAt == null) {
            i5 = firstVisiblePosition + (this.mListView.getChildCount() / 2);
            childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        }
        int top = childAt.getTop();
        int height = childAt.getHeight();
        int bk = bk(i5, top);
        int dividerHeight = this.mListView.getDividerHeight();
        if (this.fvF >= bk) {
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
                    i6 = rP(i3 + 1);
                    i2 = bk(i3 + 1, i7);
                    if (this.fvF < i2) {
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
                int rP = rP(i3);
                if (i3 == 0) {
                    i2 = (i8 - dividerHeight) - rP;
                    break;
                }
                i8 -= rP + dividerHeight;
                i2 = bk(i3, i8);
                if (this.fvF >= i2) {
                    break;
                }
                i4 = i2;
            }
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int i9 = this.fvK;
        int i10 = this.fvL;
        float f2 = this.fwp;
        if (this.fvM) {
            int abs = Math.abs(i2 - i4);
            if (this.fvF >= i2) {
                int i11 = i4;
                i4 = i2;
                i2 = i11;
            }
            int i12 = (int) (abs * this.fwo * 0.5f);
            float f3 = i12;
            int i13 = i4 + i12;
            int i14 = i2 - i12;
            if (this.fvF < i13) {
                this.fvK = i3 - 1;
                this.fvL = i3;
                this.fwp = ((i13 - this.fvF) * 0.5f) / f3;
            } else if (this.fvF < i14) {
                this.fvK = i3;
                this.fvL = i3;
            } else {
                this.fvK = i3;
                this.fvL = i3 + 1;
                this.fwp = (1.0f + ((i2 - this.fvF) / f3)) * 0.5f;
            }
        } else {
            this.fvK = i3;
            this.fvL = i3;
        }
        if (this.fvK < headerViewsCount) {
            this.fvK = headerViewsCount;
            this.fvL = headerViewsCount;
            i3 = headerViewsCount;
        } else if (this.fvL >= this.mListView.getCount() - footerViewsCount) {
            i3 = (this.mListView.getCount() - footerViewsCount) - 1;
            this.fvK = i3;
            this.fvL = i3;
        }
        boolean z = (this.fvK == i9 && this.fvL == i10 && this.fwp == f2) ? false : true;
        if (i3 != this.fvJ) {
            if (this.fvQ != null) {
                this.fvQ.drag(this.fvJ - headerViewsCount, i3 - headerViewsCount);
            }
            this.fvJ = i3;
            return true;
        }
        return z;
    }

    public void removeItem(int i2) {
        this.fwy = false;
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
            this.fvT = Math.max(1, obtainStyledAttributes.getDimensionPixelSize(R.styleable.DragSort_collapsed_height, 1));
            this.fwr = obtainStyledAttributes.getBoolean(R.styleable.DragSort_track_drag_sort, false);
            if (this.fwr) {
                this.fws = new e();
            }
            this.fvH = obtainStyledAttributes.getFloat(R.styleable.DragSort_float_alpha, this.fvH);
            this.fvI = this.fvH;
            this.dzA = obtainStyledAttributes.getBoolean(R.styleable.DragSort_drag_enabled, this.dzA);
            this.fwo = Math.max(0.0f, Math.min(1.0f, 1.0f - obtainStyledAttributes.getFloat(R.styleable.DragSort_slide_shuffle_speed, 0.75f)));
            this.fvM = this.fwo > 0.0f;
            setDragScrollStart(obtainStyledAttributes.getFloat(R.styleable.DragSort_drag_scroll_start, this.fvX));
            this.fwf = obtainStyledAttributes.getFloat(R.styleable.DragSort_max_drag_scroll_speed, this.fwf);
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
                bVar.kG(z);
                bVar.kF(z2);
                bVar.setBackgroundColor(color);
                this.fwl = bVar;
                a(bVar);
            }
            obtainStyledAttributes.recycle();
            i2 = i5;
            i3 = i4;
        }
        this.fvW = new d();
        if (i3 > 0) {
            this.fwv = new k(0.5f, i3);
        }
        if (i2 > 0) {
            this.fwx = new f(0.5f, i2);
        }
        this.fwm = MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
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
        this.fwB = bVar;
        this.mListView.setOnTouchListener(bVar);
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void dispatchDraw(Canvas canvas) {
        float f2;
        this.fwA.dispatchDraw(canvas);
        if (this.mDragState != 0) {
            if (this.fvK != this.fvN) {
                b(this.fvK, canvas);
            }
            if (this.fvL != this.fvK && this.fvL != this.fvN) {
                b(this.fvL, canvas);
            }
        }
        if (this.fvC != null) {
            int width = this.fvC.getWidth();
            int height = this.fvC.getHeight();
            int i2 = this.fvD.x;
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
            int i3 = (int) (f2 * 255.0f * this.fvI);
            canvas.save();
            canvas.translate(this.fvD.x, this.fvD.y);
            canvas.clipRect(0, 0, width, height);
            canvas.saveLayerAlpha(0.0f, 0.0f, width, height, i3, 31);
            this.fvC.draw(canvas);
            canvas.restore();
            canvas.restore();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onDraw(Canvas canvas) {
        this.fwA.onDraw(canvas);
        if (this.fwr) {
            this.fws.bCu();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.fwt) {
            this.fwt = false;
            return false;
        } else if (!this.dzA) {
            return this.fwA.onTouchEvent(motionEvent);
        } else {
            boolean z2 = this.fwj;
            this.fwj = false;
            if (!z2) {
                G(motionEvent);
            }
            if (this.mDragState == 4) {
                onDragTouchEvent(motionEvent);
                return true;
            }
            if (this.mDragState == 0 && this.fwA.onTouchEvent(motionEvent)) {
                z = true;
            }
            switch (motionEvent.getAction() & 255) {
                case 1:
                case 3:
                    bCm();
                    return z;
                case 2:
                default:
                    if (z) {
                        this.fwn = 1;
                        return z;
                    }
                    return z;
            }
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (!this.dzA) {
            return this.fwA.onInterceptTouchEvent(motionEvent);
        }
        if (this.fwB != null) {
            this.fwB.bCw().onTouchEvent(motionEvent);
        }
        G(motionEvent);
        this.fwj = true;
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            if (this.mDragState != 0) {
                this.fwt = true;
                return true;
            }
            this.fwk = true;
        }
        if (this.fvC == null) {
            if (this.fwA.onInterceptTouchEvent(motionEvent)) {
                this.fwC = true;
                z = true;
            } else {
                z = false;
            }
            switch (action) {
                case 1:
                case 3:
                    bCm();
                    break;
                case 2:
                default:
                    if (z) {
                        this.fwn = 1;
                        break;
                    } else {
                        this.fwn = 2;
                        break;
                    }
            }
        } else {
            z = true;
        }
        if (action == 1 || action == 3) {
            this.fwk = false;
        }
        return z;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        this.fwA.onSizeChanged(i2, i3, i4, i5);
        bCn();
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void requestLayout() {
        if (!this.mBlockLayoutRequests) {
            this.fwA.requestLayout();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onMeasure(int i2, int i3) {
        this.fwA.onMeasure(i2, i3);
        if (this.fvC != null) {
            if (this.fvC.isLayoutRequested()) {
                bCp();
            }
            this.fvG = true;
        }
        this.mWidthMeasureSpec = i2;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void layoutChildren() {
        this.fwA.layoutChildren();
        if (this.fvC != null) {
            if (this.fvC.isLayoutRequested() && !this.fvG) {
                bCp();
            }
            this.fvC.layout(0, 0, this.fvC.getMeasuredWidth(), this.fvC.getMeasuredHeight());
            this.fvG = false;
        }
    }

    public void removeItem(int i2, float f2) {
        if (this.mDragState == 0 || this.mDragState == 4) {
            if (this.mDragState == 0) {
                this.fvN = this.mListView.getHeaderViewsCount() + i2;
                this.fvK = this.fvN;
                this.fvL = this.fvN;
                this.fvJ = this.fvN;
                View childAt = this.mListView.getChildAt(this.fvN - this.mListView.getFirstVisiblePosition());
                if (childAt != null) {
                    childAt.setVisibility(4);
                }
            }
            this.mDragState = 1;
            this.fwz = f2;
            if (this.fwk) {
                switch (this.fwn) {
                    case 1:
                        this.fwA.onTouchEvent(this.fwm);
                        break;
                    case 2:
                        this.fwA.onInterceptTouchEvent(this.fwm);
                        break;
                }
            }
            if (this.fwv != null) {
                this.fwv.start();
            } else {
                rQ(i2);
            }
        }
    }

    public void cancelDrag() {
        if (this.mDragState == 4) {
            this.fvW.kE(true);
            bCr();
            bCi();
            bCo();
            if (this.fwk) {
                this.mDragState = 3;
            } else {
                this.mDragState = 0;
            }
        }
    }

    private void bCi() {
        this.fvN = -1;
        this.fvK = -1;
        this.fvL = -1;
        this.fvJ = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCj() {
        this.mDragState = 2;
        if (this.fvR != null && this.fvJ >= 0 && this.fvJ < this.mListView.getCount()) {
            int headerViewsCount = this.mListView.getHeaderViewsCount();
            this.fvR.drop(this.fvN - headerViewsCount, this.fvJ - headerViewsCount);
        }
        bCr();
        bCl();
        bCi();
        bCo();
        if (this.fwk) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCk() {
        rQ(this.fvN - this.mListView.getHeaderViewsCount());
    }

    private void rQ(int i2) {
        this.mDragState = 1;
        if (this.fvS != null) {
            this.fvS.remove(i2);
        }
        bCr();
        bCl();
        bCi();
        if (this.fwk) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    private void bCl() {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        if (this.fvN < firstVisiblePosition) {
            View childAt = this.mListView.getChildAt(0);
            this.mListView.setSelectionFromTop(firstVisiblePosition - 1, (childAt != null ? childAt.getTop() : 0) - this.mListView.getPaddingTop());
        }
    }

    public boolean stopDrag(boolean z) {
        this.fwy = false;
        return stopDrag(z, 0.0f);
    }

    public boolean stopDragWithVelocity(boolean z, float f2) {
        this.fwy = true;
        return stopDrag(z, f2);
    }

    public boolean stopDrag(boolean z, float f2) {
        if (this.fvC != null) {
            this.fvW.kE(true);
            if (z) {
                removeItem(this.fvN - this.mListView.getHeaderViewsCount(), f2);
            } else if (this.fwx != null) {
                this.fwx.start();
            } else {
                bCj();
            }
            if (this.fwr) {
                this.fws.stopTracking();
                return true;
            }
            return true;
        }
        return false;
    }

    private void bCm() {
        this.fwn = 0;
        this.fwk = false;
        if (this.mDragState == 3) {
            this.mDragState = 0;
        }
        this.fvI = this.fvH;
        this.fwC = false;
        this.fwu.clear();
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
        return this.fwC;
    }

    public void setDragScrollStart(float f2) {
        setDragScrollStarts(f2, f2);
    }

    public void setDragScrollStarts(float f2, float f3) {
        if (f3 > 0.5f) {
            this.fvY = 0.5f;
        } else {
            this.fvY = f3;
        }
        if (f2 > 0.5f) {
            this.fvX = 0.5f;
        } else {
            this.fvX = f2;
        }
        if (this.mListView.getHeight() != 0) {
            bCn();
        }
    }

    private void bl(int i2, int i3) {
        this.fvD.x = i2 - this.fvO;
        this.fvD.y = i3 - this.fvP;
        kD(true);
        int min = Math.min(i3, this.fvF + this.fvU);
        int max = Math.max(i3, this.fvF - this.fvU);
        int bCs = this.fvW.bCs();
        if (min > this.mLastY && min > this.fwa && bCs != 1) {
            if (bCs != -1) {
                this.fvW.kE(true);
            }
            this.fvW.rS(1);
        } else if (max < this.mLastY && max < this.fvZ && bCs != 0) {
            if (bCs != -1) {
                this.fvW.kE(true);
            }
            this.fvW.rS(0);
        } else if (max >= this.fvZ && min <= this.fwa && this.fvW.isScrolling()) {
            this.fvW.kE(true);
        }
    }

    private void bCn() {
        int height;
        int paddingTop = this.mListView.getPaddingTop();
        float height2 = (this.mListView.getHeight() - paddingTop) - this.mListView.getPaddingBottom();
        this.fwc = paddingTop + (this.fvX * height2);
        this.fwb = (height2 * (1.0f - this.fvY)) + paddingTop;
        this.fvZ = (int) this.fwc;
        this.fwa = (int) this.fwb;
        this.fwd = this.fwc - paddingTop;
        this.fwe = (paddingTop + height) - this.fwb;
    }

    private void bCo() {
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
        if (i2 != this.fvN && i2 != this.fvK && i2 != this.fvL) {
            g2 = -2;
        } else {
            g2 = g(i2, view, z);
        }
        if (g2 != layoutParams.height) {
            layoutParams.height = g2;
            view.setLayoutParams(layoutParams);
        }
        if (i2 == this.fvK || i2 == this.fvL) {
            if (i2 < this.fvN) {
                ((DragSortItemView) view).setGravity(80);
            } else if (i2 > this.fvN) {
                ((DragSortItemView) view).setGravity(48);
            }
        }
        int visibility = view.getVisibility();
        int i3 = 0;
        if (i2 == this.fvN && this.fvC != null) {
            i3 = 4;
        }
        if (i3 != visibility) {
            view.setVisibility(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int rR(int i2) {
        View view;
        if (i2 == this.fvN) {
            return 0;
        }
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        if (childAt != null) {
            return f(i2, childAt, false);
        }
        int i3 = this.fwu.get(i2);
        if (i3 == -1) {
            ListAdapter adapter = this.mListView.getAdapter();
            int itemViewType = adapter.getItemViewType(i2);
            int viewTypeCount = adapter.getViewTypeCount();
            if (viewTypeCount != this.fvV.length) {
                this.fvV = new View[viewTypeCount];
            }
            if (itemViewType >= 0) {
                if (this.fvV[itemViewType] == null) {
                    view = adapter.getView(i2, null, this.mListView);
                    this.fvV[itemViewType] = view;
                } else {
                    view = adapter.getView(i2, this.fvV[itemViewType], this.mListView);
                }
            } else {
                view = adapter.getView(i2, null, this.mListView);
            }
            int f2 = f(i2, view, true);
            this.fwu.bn(i2, f2);
            return f2;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(int i2, View view, boolean z) {
        if (i2 == this.fvN) {
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
        boolean z = this.fvM && this.fvK != this.fvL;
        int i4 = this.dhX - this.fvT;
        int i5 = (int) (this.fwp * i4);
        if (i2 == this.fvN) {
            if (this.fvN == this.fvK) {
                if (z) {
                    return i5 + this.fvT;
                }
                return this.dhX;
            } else if (this.fvN == this.fvL) {
                return this.dhX - i5;
            } else {
                return this.fvT;
            }
        } else if (i2 == this.fvK) {
            if (z) {
                return i3 + i5;
            }
            return i3 + i4;
        } else if (i2 == this.fvL) {
            return (i3 + i4) - i5;
        } else {
            return i3;
        }
    }

    private int b(int i2, View view, int i3, int i4) {
        int i5;
        int i6;
        int rR = rR(i2);
        int height = view.getHeight();
        int bm = bm(i2, rR);
        if (i2 != this.fvN) {
            i6 = height - rR;
            i5 = bm - rR;
        } else {
            i5 = bm;
            i6 = height;
        }
        int i7 = this.dhX;
        if (this.fvN != this.fvK && this.fvN != this.fvL) {
            i7 -= this.fvT;
        }
        if (i2 <= i3) {
            if (i2 > this.fvK) {
                return (i7 - i5) + 0;
            }
        } else if (i2 == i4) {
            if (i2 <= this.fvK) {
                return (i6 - i7) + 0;
            }
            if (i2 == this.fvL) {
                return (height - bm) + 0;
            }
            return 0 + i6;
        } else if (i2 <= this.fvK) {
            return 0 - i7;
        } else {
            if (i2 == this.fvL) {
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

    private void bCp() {
        if (this.fvC != null) {
            measureItem(this.fvC);
            this.dhX = this.fvC.getMeasuredHeight();
            this.fvU = this.dhX / 2;
        }
    }

    protected boolean onDragTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        switch (motionEvent.getAction() & 255) {
            case 1:
                if (this.mDragState == 4) {
                    stopDrag(false);
                }
                bCm();
                return true;
            case 2:
                bl((int) motionEvent.getX(), (int) motionEvent.getY());
                return true;
            case 3:
                if (this.mDragState == 4) {
                    cancelDrag();
                }
                bCm();
                return true;
            default:
                return true;
        }
    }

    public boolean startDrag(int i2, int i3, int i4, int i5) {
        View rT;
        if (!this.fwk || this.fwl == null || (rT = this.fwl.rT(i2)) == null) {
            return false;
        }
        return startDrag(i2, rT, i3, i4, i5);
    }

    public boolean startDrag(int i2, View view, int i3, int i4, int i5) {
        if (this.mDragState == 0 && this.fwk && this.fvC == null && view != null && this.dzA) {
            if (this.mListView.getParent() != null) {
                this.mListView.getParent().requestDisallowInterceptTouchEvent(true);
            }
            int headerViewsCount = this.mListView.getHeaderViewsCount() + i2;
            this.fvK = headerViewsCount;
            this.fvL = headerViewsCount;
            this.fvN = headerViewsCount;
            this.fvJ = headerViewsCount;
            this.mDragState = 4;
            this.fwi = 0;
            this.fwi |= i3;
            this.fvC = view;
            bCp();
            this.fvO = i4;
            this.fvP = i5;
            this.fwh = this.mY;
            this.fvD.x = this.mX - this.fvO;
            this.fvD.y = this.mY - this.fvP;
            View childAt = this.mListView.getChildAt(this.fvN - this.mListView.getFirstVisiblePosition());
            if (childAt != null) {
                childAt.setVisibility(4);
            }
            if (this.fwr) {
                this.fws.bCt();
            }
            switch (this.fwn) {
                case 1:
                    this.fwA.onTouchEvent(this.fwm);
                    break;
                case 2:
                    this.fwA.onInterceptTouchEvent(this.fwm);
                    break;
            }
            this.mListView.requestLayout();
            if (this.fww != null) {
                this.fww.start();
                return true;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kD(boolean z) {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition() + (this.mListView.getChildCount() / 2);
        View childAt = this.mListView.getChildAt(this.mListView.getChildCount() / 2);
        if (childAt != null) {
            h(firstVisiblePosition, childAt, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i2, View view, boolean z) {
        this.mBlockLayoutRequests = true;
        bCq();
        int i3 = this.fvK;
        int i4 = this.fvL;
        boolean bCh = bCh();
        if (bCh) {
            bCo();
            this.mListView.setSelectionFromTop(i2, (b(i2, view, i3, i4) + view.getTop()) - this.mListView.getPaddingTop());
            layoutChildren();
        }
        if (bCh || z) {
            this.mListView.invalidate();
        }
        this.mBlockLayoutRequests = false;
    }

    private void bCq() {
        if (this.fwl != null) {
            this.fvE.set(this.mX, this.mY);
            this.fwl.b(this.fvC, this.fvD, this.fvE);
        }
        int i2 = this.fvD.x;
        int i3 = this.fvD.y;
        int paddingLeft = this.mListView.getPaddingLeft();
        if ((this.fwi & 1) == 0 && i2 > paddingLeft) {
            this.fvD.x = paddingLeft;
        } else if ((this.fwi & 2) == 0 && i2 < paddingLeft) {
            this.fvD.x = paddingLeft;
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int lastVisiblePosition = this.mListView.getLastVisiblePosition();
        int paddingTop = this.mListView.getPaddingTop();
        if (firstVisiblePosition < headerViewsCount) {
            paddingTop = this.mListView.getChildAt((headerViewsCount - firstVisiblePosition) - 1).getBottom();
        }
        if ((this.fwi & 8) == 0 && firstVisiblePosition <= this.fvN) {
            paddingTop = Math.max(this.mListView.getChildAt(this.fvN - firstVisiblePosition).getTop(), paddingTop);
        }
        int height = this.mListView.getHeight() - this.mListView.getPaddingBottom();
        if (lastVisiblePosition >= (this.mListView.getCount() - footerViewsCount) - 1) {
            height = this.mListView.getChildAt(((this.mListView.getCount() - footerViewsCount) - 1) - firstVisiblePosition).getBottom();
        }
        if ((this.fwi & 4) == 0 && lastVisiblePosition >= this.fvN) {
            height = Math.min(this.mListView.getChildAt(this.fvN - firstVisiblePosition).getBottom(), height);
        }
        if (i3 < paddingTop) {
            this.fvD.y = paddingTop;
        } else if (this.dhX + i3 > height) {
            this.fvD.y = height - this.dhX;
        }
        this.fvF = this.fvD.y + this.fvU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCr() {
        if (this.fvC != null) {
            this.fvC.setVisibility(8);
            if (this.fwl != null) {
                this.fwl.bD(this.fvC);
            }
            this.fvC = null;
            this.mListView.invalidate();
        }
    }

    public void a(h hVar) {
        this.fwl = hVar;
    }

    public void a(b bVar) {
        this.fvQ = bVar;
    }

    public void setDragEnabled(boolean z) {
        this.dzA = z;
    }

    public boolean isDragEnabled() {
        return this.dzA;
    }

    public void a(g gVar) {
        this.fvR = gVar;
    }

    public void a(l lVar) {
        this.fvS = lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class i {
        private SparseIntArray fwW;
        private ArrayList<Integer> fwX;
        private int mMaxSize;

        public i(int i) {
            this.fwW = new SparseIntArray(i);
            this.fwX = new ArrayList<>(i);
            this.mMaxSize = i;
        }

        public void bn(int i, int i2) {
            int i3 = this.fwW.get(i, -1);
            if (i3 != i2) {
                if (i3 == -1) {
                    if (this.fwW.size() == this.mMaxSize) {
                        this.fwW.delete(this.fwX.remove(0).intValue());
                    }
                } else {
                    this.fwX.remove(Integer.valueOf(i));
                }
                this.fwW.put(i, i2);
                this.fwX.add(Integer.valueOf(i));
            }
        }

        public int get(int i) {
            return this.fwW.get(i, -1);
        }

        public void clear() {
            this.fwW.clear();
            this.fwX.clear();
        }
    }

    /* renamed from: com.baidu.tbadk.widget.dragsort.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0588a extends BaseAdapter {
        private ListAdapter mAdapter;

        public C0588a(ListAdapter listAdapter) {
            this.mAdapter = listAdapter;
            this.mAdapter.registerDataSetObserver(new DataSetObserver() { // from class: com.baidu.tbadk.widget.dragsort.a.a.1
                @Override // android.database.DataSetObserver
                public void onChanged() {
                    C0588a.this.notifyDataSetChanged();
                }

                @Override // android.database.DataSetObserver
                public void onInvalidated() {
                    C0588a.this.notifyDataSetInvalidated();
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
        private float cwO;
        private float cwP;
        private float cwQ;
        private float cwR;
        private float fxh;
        private float mAlpha;
        private boolean mCanceled;
        protected long mStartTime;

        public m(float f, int i) {
            this.mAlpha = f;
            this.fxh = i;
            float f2 = 1.0f / ((this.mAlpha * 2.0f) * (1.0f - this.mAlpha));
            this.cwR = f2;
            this.cwO = f2;
            this.cwP = this.mAlpha / ((this.mAlpha - 1.0f) * 2.0f);
            this.cwQ = 1.0f / (1.0f - this.mAlpha);
        }

        public float ak(float f) {
            if (f < this.mAlpha) {
                return this.cwO * f * f;
            }
            if (f < 1.0f - this.mAlpha) {
                return this.cwP + (this.cwQ * f);
            }
            return 1.0f - ((this.cwR * (f - 1.0f)) * (f - 1.0f));
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

        public void x(float f, float f2) {
        }

        public void onStop() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.mCanceled) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / this.fxh;
                if (uptimeMillis >= 1.0f) {
                    x(1.0f, 1.0f);
                    onStop();
                    return;
                }
                x(uptimeMillis, ak(uptimeMillis));
                a.this.mListView.post(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class f extends m {
        private int fwS;
        private int fwT;
        private float fwU;
        private float fwV;

        public f(float f, int i) {
            super(f, i);
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.fwS = a.this.fvJ;
            this.fwT = a.this.fvN;
            a.this.mDragState = 2;
            this.fwU = a.this.fvD.y - bCv();
            this.fwV = a.this.fvD.x - a.this.mListView.getPaddingLeft();
        }

        private int bCv() {
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            int dividerHeight = (a.this.fvT + a.this.mListView.getDividerHeight()) / 2;
            View childAt = a.this.mListView.getChildAt(this.fwS - firstVisiblePosition);
            if (childAt != null) {
                if (this.fwS == this.fwT) {
                    return childAt.getTop();
                }
                if (this.fwS >= this.fwT) {
                    return (childAt.getBottom() + dividerHeight) - a.this.dhX;
                }
                return childAt.getTop() - dividerHeight;
            }
            cancel();
            return -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void x(float f, float f2) {
            int bCv = bCv();
            float paddingLeft = a.this.fvD.x - a.this.mListView.getPaddingLeft();
            float f3 = 1.0f - f2;
            if (f3 < Math.abs((a.this.fvD.y - bCv) / this.fwU) || f3 < Math.abs(paddingLeft / this.fwV)) {
                a.this.fvD.y = bCv + ((int) (this.fwU * f3));
                a.this.fvD.x = a.this.mListView.getPaddingLeft() + ((int) (this.fwV * f3));
                a.this.kD(true);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.bCj();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class k extends m {
        private int fwT;
        private float fxa;
        private float fxb;
        private float fxc;
        private int fxd;
        private int fxe;
        private int fxf;
        private int fxg;

        public k(float f, int i) {
            super(f, i);
            this.fxd = -1;
            this.fxe = -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.fxd = -1;
            this.fxe = -1;
            this.fxf = a.this.fvK;
            this.fxg = a.this.fvL;
            this.fwT = a.this.fvN;
            a.this.mDragState = 1;
            this.fxa = a.this.fvD.x;
            if (a.this.fwy) {
                float width = a.this.mListView.getWidth() * 2.0f;
                if (a.this.fwz == 0.0f) {
                    a.this.fwz = (this.fxa >= 0.0f ? 1 : -1) * width;
                    return;
                }
                float f = width * 2.0f;
                if (a.this.fwz >= 0.0f || a.this.fwz <= (-f)) {
                    if (a.this.fwz > 0.0f && a.this.fwz < f) {
                        a.this.fwz = f;
                        return;
                    }
                    return;
                }
                a.this.fwz = -f;
                return;
            }
            a.this.bCr();
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void x(float f, float f2) {
            View childAt;
            float f3 = 1.0f - f2;
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            View childAt2 = a.this.mListView.getChildAt(this.fxf - firstVisiblePosition);
            if (a.this.fwy) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / 1000.0f;
                if (uptimeMillis != 0.0f) {
                    float f4 = a.this.fwz * uptimeMillis;
                    int width = a.this.mListView.getWidth();
                    a.this.fwz = ((a.this.fwz > 0.0f ? 1 : -1) * uptimeMillis * width) + a.this.fwz;
                    this.fxa += f4;
                    a.this.fvD.x = (int) this.fxa;
                    if (this.fxa < width && this.fxa > (-width)) {
                        this.mStartTime = SystemClock.uptimeMillis();
                        a.this.kD(true);
                        return;
                    }
                } else {
                    return;
                }
            }
            if (childAt2 != null) {
                if (this.fxd == -1) {
                    this.fxd = a.this.f(this.fxf, childAt2, false);
                    this.fxb = childAt2.getHeight() - this.fxd;
                }
                int max = Math.max((int) (this.fxb * f3), 1);
                ViewGroup.LayoutParams layoutParams = childAt2.getLayoutParams();
                layoutParams.height = max + this.fxd;
                childAt2.setLayoutParams(layoutParams);
            }
            if (this.fxg != this.fxf && (childAt = a.this.mListView.getChildAt(this.fxg - firstVisiblePosition)) != null) {
                if (this.fxe == -1) {
                    this.fxe = a.this.f(this.fxg, childAt, false);
                    this.fxc = childAt.getHeight() - this.fxe;
                }
                int max2 = Math.max((int) (this.fxc * f3), 1);
                ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
                layoutParams2.height = max2 + this.fxe;
                childAt.setLayoutParams(layoutParams2);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.bCk();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class j extends m {
        final /* synthetic */ a fwE;
        private float fwY;
        private float fwZ;

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.fwY = this.fwE.fvP;
            this.fwZ = this.fwE.fvU;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void x(float f, float f2) {
            if (this.fwE.mDragState != 4) {
                cancel();
                return;
            }
            this.fwE.fvP = (int) ((this.fwZ * f2) + ((1.0f - f2) * this.fwY));
            this.fwE.fvD.y = this.fwE.mY - this.fwE.fvP;
            this.fwE.kD(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e {
        StringBuilder mBuilder = new StringBuilder();
        private int fwP = 0;
        private int fwQ = 0;
        private boolean fwR = false;
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

        public void bCt() {
            this.mBuilder.append("<DSLVStates>\n");
            this.fwQ = 0;
            this.fwR = true;
        }

        public void bCu() {
            if (this.fwR) {
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
                this.mBuilder.append("    <FirstExpPos>").append(a.this.fvK).append("</FirstExpPos>\n");
                this.mBuilder.append("    <FirstExpBlankHeight>").append(a.this.rP(a.this.fvK) - a.this.rR(a.this.fvK)).append("</FirstExpBlankHeight>\n");
                this.mBuilder.append("    <SecondExpPos>").append(a.this.fvL).append("</SecondExpPos>\n");
                this.mBuilder.append("    <SecondExpBlankHeight>").append(a.this.rP(a.this.fvL) - a.this.rR(a.this.fvL)).append("</SecondExpBlankHeight>\n");
                this.mBuilder.append("    <SrcPos>").append(a.this.fvN).append("</SrcPos>\n");
                this.mBuilder.append("    <SrcHeight>").append(a.this.dhX + a.this.mListView.getDividerHeight()).append("</SrcHeight>\n");
                this.mBuilder.append("    <ViewHeight>").append(a.this.mListView.getHeight()).append("</ViewHeight>\n");
                this.mBuilder.append("    <LastY>").append(a.this.mLastY).append("</LastY>\n");
                this.mBuilder.append("    <FloatY>").append(a.this.fvF).append("</FloatY>\n");
                this.mBuilder.append("    <ShuffleEdges>");
                for (int i4 = 0; i4 < childCount; i4++) {
                    this.mBuilder.append(a.this.bk(firstVisiblePosition + i4, a.this.mListView.getChildAt(i4).getTop())).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                this.mBuilder.append("</ShuffleEdges>\n");
                this.mBuilder.append("</DSLVState>\n");
                this.fwP++;
                if (this.fwP > 1000) {
                    flush();
                    this.fwP = 0;
                }
            }
        }

        public void flush() {
            if (this.fwR) {
                try {
                    FileWriter fileWriter = new FileWriter(this.mFile, this.fwQ != 0);
                    fileWriter.write(this.mBuilder.toString());
                    this.mBuilder.delete(0, this.mBuilder.length());
                    fileWriter.flush();
                    fileWriter.close();
                    this.fwQ++;
                } catch (IOException e) {
                }
            }
        }

        public void stopTracking() {
            if (this.fwR) {
                this.mBuilder.append("</DSLVStates>\n");
                flush();
                this.fwR = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements Runnable {
        private boolean fwH;
        private long fwI;
        private long fwJ;
        private int fwK;
        private float fwL;
        private long fwM;
        private int fwN;
        private float fwO;
        private boolean mScrolling = false;

        public boolean isScrolling() {
            return this.mScrolling;
        }

        public int bCs() {
            if (this.mScrolling) {
                return this.fwN;
            }
            return -1;
        }

        public d() {
        }

        public void rS(int i) {
            if (!this.mScrolling) {
                this.fwH = false;
                this.mScrolling = true;
                this.fwM = SystemClock.uptimeMillis();
                this.fwI = this.fwM;
                this.fwN = i;
                a.this.mListView.post(this);
            }
        }

        public void kE(boolean z) {
            if (z) {
                a.this.mListView.removeCallbacks(this);
                this.mScrolling = false;
                return;
            }
            this.fwH = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.fwH) {
                int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
                int lastVisiblePosition = a.this.mListView.getLastVisiblePosition();
                int count = a.this.mListView.getCount();
                int paddingTop = a.this.mListView.getPaddingTop();
                int height = (a.this.mListView.getHeight() - paddingTop) - a.this.mListView.getPaddingBottom();
                int min = Math.min(a.this.mY, a.this.fvF + a.this.fvU);
                int max = Math.max(a.this.mY, a.this.fvF - a.this.fvU);
                if (this.fwN == 0) {
                    View childAt = a.this.mListView.getChildAt(0);
                    if (childAt == null) {
                        this.mScrolling = false;
                        return;
                    } else if (firstVisiblePosition == 0 && childAt.getTop() == paddingTop) {
                        this.mScrolling = false;
                        return;
                    } else {
                        this.fwO = a.this.fwg.b((a.this.fwc - max) / a.this.fwd, this.fwI);
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
                        this.fwO = -a.this.fwg.b((min - a.this.fwb) / a.this.fwe, this.fwI);
                    }
                }
                this.fwJ = SystemClock.uptimeMillis();
                this.fwL = (float) (this.fwJ - this.fwI);
                this.fwK = Math.round(this.fwO * this.fwL);
                if (this.fwK >= 0) {
                    this.fwK = Math.min(height, this.fwK);
                    lastVisiblePosition = firstVisiblePosition;
                } else {
                    this.fwK = Math.max(-height, this.fwK);
                }
                View childAt3 = a.this.mListView.getChildAt(lastVisiblePosition - firstVisiblePosition);
                int top = childAt3.getTop() + this.fwK;
                if (lastVisiblePosition == 0 && top > paddingTop) {
                    top = paddingTop;
                }
                a.this.mBlockLayoutRequests = true;
                a.this.mListView.setSelectionFromTop(lastVisiblePosition, top - paddingTop);
                a.this.layoutChildren();
                a.this.mListView.invalidate();
                a.this.mBlockLayoutRequests = false;
                a.this.h(lastVisiblePosition, childAt3, false);
                this.fwI = this.fwJ;
                a.this.mListView.post(this);
                return;
            }
            this.mScrolling = false;
        }
    }
}
