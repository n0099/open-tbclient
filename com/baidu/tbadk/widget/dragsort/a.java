package com.baidu.tbadk.widget.dragsort;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.os.SystemClock;
import android.support.v4.view.MotionEventCompat;
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
    private View aOZ;
    private int aPB;
    private int aPC;
    private float aPD;
    private float aPE;
    private float aPF;
    private float aPG;
    private int aPJ;
    private int aPK;
    private int aPL;
    private MotionEvent aPQ;
    private C0068a aPU;
    private e aPW;
    private k aPZ;
    private int aPc;
    private DataSetObserver aPe;
    private int aPh;
    private int aPi;
    private int aPj;
    private int aPl;
    private int aPm;
    private int aPn;
    private int aPo;
    private int aPp;
    private b aPq;
    private g aPr;
    private l aPs;
    private int aPv;
    private int aPw;
    private d aPy;
    private j aQa;
    private f aQb;
    private boolean aQc;
    private com.baidu.tbadk.widget.dragsort.f aQe;
    private com.baidu.tbadk.widget.dragsort.b aQf;
    private int mLastX;
    private int mLastY;
    private ListView mListView;
    private Point aPa = new Point();
    private Point aPb = new Point();
    private boolean aPd = false;
    private float aPf = 1.0f;
    private float aPg = 1.0f;
    private boolean aPk = false;
    private boolean aPt = true;
    private int mDragState = 0;
    private int aPu = 1;
    private int mWidthMeasureSpec = 0;
    private View[] aPx = new View[1];
    private float aPz = 0.33333334f;
    private float aPA = 0.33333334f;
    private float aPH = 0.5f;
    private c aPI = new c() { // from class: com.baidu.tbadk.widget.dragsort.a.1
        @Override // com.baidu.tbadk.widget.dragsort.a.c
        public float b(float f2, long j2) {
            return a.this.aPH * f2;
        }
    };
    private int aPM = 0;
    private boolean aPN = false;
    private boolean aPO = false;
    private h aPP = null;
    private int aPR = 0;
    private float aPS = 0.25f;
    private float aPT = 0.0f;
    private boolean aPV = false;
    private boolean mBlockLayoutRequests = false;
    private boolean aPX = false;
    private i aPY = new i(3);
    private float aQd = 0.0f;
    private boolean aQg = false;
    private boolean aQh = false;

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
        void S(View view);

        void b(View view, Point point, Point point2);

        View fG(int i);
    }

    /* loaded from: classes.dex */
    public interface l {
        void remove(int i);
    }

    public a(ListView listView, com.baidu.tbadk.widget.dragsort.f fVar) {
        this.aQe = fVar;
        this.mListView = listView;
    }

    @Override // com.baidu.tbadk.widget.dragsort.e
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            this.aPU = new C0068a(listAdapter);
            listAdapter.registerDataSetObserver(this.aPe);
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
            this.aPU = null;
        }
        this.aQe.setAdapter(this.aPU);
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
            if (i2 > this.aPl) {
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
    public int fC(int i2) {
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        return childAt != null ? childAt.getHeight() : Q(i2, fE(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int O(int i2, int i3) {
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        if (i2 <= headerViewsCount || i2 >= this.mListView.getCount() - footerViewsCount) {
            return i3;
        }
        int dividerHeight = this.mListView.getDividerHeight();
        int i4 = this.aPv - this.aPu;
        int fE = fE(i2);
        int fC = fC(i2);
        if (this.aPj <= this.aPl) {
            if (i2 == this.aPj && this.aPi != this.aPj) {
                if (i2 == this.aPl) {
                    i3 = (i3 + fC) - this.aPv;
                } else {
                    i3 = ((fC - fE) + i3) - i4;
                }
            } else if (i2 > this.aPj && i2 <= this.aPl) {
                i3 -= i4;
            }
        } else if (i2 > this.aPl && i2 <= this.aPi) {
            i3 += i4;
        } else if (i2 == this.aPj && this.aPi != this.aPj) {
            i3 += fC - fE;
        }
        if (i2 <= this.aPl) {
            return (((this.aPv - dividerHeight) - fE(i2 - 1)) / 2) + i3;
        }
        return (((fE - dividerHeight) - this.aPv) / 2) + i3;
    }

    private boolean HZ() {
        int i2;
        int i3;
        int i4;
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int i5 = this.aPi;
        View childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        if (childAt == null) {
            i5 = firstVisiblePosition + (this.mListView.getChildCount() / 2);
            childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        }
        int top = childAt.getTop();
        int height = childAt.getHeight();
        int O = O(i5, top);
        int dividerHeight = this.mListView.getDividerHeight();
        if (this.aPc >= O) {
            int count = this.mListView.getCount();
            int i6 = height;
            int i7 = top;
            i2 = O;
            i3 = i5;
            i4 = O;
            while (true) {
                if (i3 < count) {
                    if (i3 == count - 1) {
                        i2 = i7 + dividerHeight + i6;
                        break;
                    }
                    i7 += dividerHeight + i6;
                    i6 = fC(i3 + 1);
                    i2 = O(i3 + 1, i7);
                    if (this.aPc < i2) {
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
            i2 = O;
            i3 = i5;
            i4 = O;
            while (true) {
                if (i3 < 0) {
                    break;
                }
                i3--;
                int fC = fC(i3);
                if (i3 == 0) {
                    i2 = (i8 - dividerHeight) - fC;
                    break;
                }
                i8 -= fC + dividerHeight;
                i2 = O(i3, i8);
                if (this.aPc >= i2) {
                    break;
                }
                i4 = i2;
            }
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int i9 = this.aPi;
        int i10 = this.aPj;
        float f2 = this.aPT;
        if (this.aPk) {
            int abs = Math.abs(i2 - i4);
            if (this.aPc >= i2) {
                int i11 = i4;
                i4 = i2;
                i2 = i11;
            }
            int i12 = (int) (abs * this.aPS * 0.5f);
            float f3 = i12;
            int i13 = i4 + i12;
            int i14 = i2 - i12;
            if (this.aPc < i13) {
                this.aPi = i3 - 1;
                this.aPj = i3;
                this.aPT = ((i13 - this.aPc) * 0.5f) / f3;
            } else if (this.aPc < i14) {
                this.aPi = i3;
                this.aPj = i3;
            } else {
                this.aPi = i3;
                this.aPj = i3 + 1;
                this.aPT = (1.0f + ((i2 - this.aPc) / f3)) * 0.5f;
            }
        } else {
            this.aPi = i3;
            this.aPj = i3;
        }
        if (this.aPi < headerViewsCount) {
            this.aPi = headerViewsCount;
            this.aPj = headerViewsCount;
            i3 = headerViewsCount;
        } else if (this.aPj >= this.mListView.getCount() - footerViewsCount) {
            i3 = (this.mListView.getCount() - footerViewsCount) - 1;
            this.aPi = i3;
            this.aPj = i3;
        }
        boolean z = (this.aPi == i9 && this.aPj == i10 && this.aPT == f2) ? false : true;
        if (i3 != this.aPh) {
            if (this.aPq != null) {
                this.aPq.drag(this.aPh - headerViewsCount, i3 - headerViewsCount);
            }
            this.aPh = i3;
            return true;
        }
        return z;
    }

    public void removeItem(int i2) {
        this.aQc = false;
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
            this.aPu = Math.max(1, obtainStyledAttributes.getDimensionPixelSize(d.l.DragSort_collapsed_height, 1));
            this.aPV = obtainStyledAttributes.getBoolean(d.l.DragSort_track_drag_sort, false);
            if (this.aPV) {
                this.aPW = new e();
            }
            this.aPf = obtainStyledAttributes.getFloat(d.l.DragSort_float_alpha, this.aPf);
            this.aPg = this.aPf;
            this.aPt = obtainStyledAttributes.getBoolean(d.l.DragSort_drag_enabled, this.aPt);
            this.aPS = Math.max(0.0f, Math.min(1.0f, 1.0f - obtainStyledAttributes.getFloat(d.l.DragSort_slide_shuffle_speed, 0.75f)));
            this.aPk = this.aPS > 0.0f;
            setDragScrollStart(obtainStyledAttributes.getFloat(d.l.DragSort_drag_scroll_start, this.aPz));
            this.aPH = obtainStyledAttributes.getFloat(d.l.DragSort_max_drag_scroll_speed, this.aPH);
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
                bVar.cd(z);
                bVar.cc(z2);
                bVar.setBackgroundColor(color);
                this.aPP = bVar;
                a(bVar);
            }
            obtainStyledAttributes.recycle();
            i2 = i5;
            i3 = i4;
        }
        this.aPy = new d();
        if (i3 > 0) {
            this.aPZ = new k(0.5f, i3);
        }
        if (i2 > 0) {
            this.aQb = new f(0.5f, i2);
        }
        this.aPQ = MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        this.aPe = new DataSetObserver() { // from class: com.baidu.tbadk.widget.dragsort.a.2
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
        this.aQf = bVar;
        this.mListView.setOnTouchListener(bVar);
    }

    @Override // com.baidu.tbadk.widget.dragsort.e
    public void dispatchDraw(Canvas canvas) {
        float f2;
        this.aQe.dispatchDraw(canvas);
        if (this.mDragState != 0) {
            if (this.aPi != this.aPl) {
                b(this.aPi, canvas);
            }
            if (this.aPj != this.aPi && this.aPj != this.aPl) {
                b(this.aPj, canvas);
            }
        }
        if (this.aOZ != null) {
            int width = this.aOZ.getWidth();
            int height = this.aOZ.getHeight();
            int i2 = this.aPa.x;
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
            int i3 = (int) (f2 * 255.0f * this.aPg);
            canvas.save();
            canvas.translate(this.aPa.x, this.aPa.y);
            canvas.clipRect(0, 0, width, height);
            canvas.saveLayerAlpha(0.0f, 0.0f, width, height, i3, 31);
            this.aOZ.draw(canvas);
            canvas.restore();
            canvas.restore();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.e
    public void onDraw(Canvas canvas) {
        this.aQe.onDraw(canvas);
        if (this.aPV) {
            this.aPW.Im();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.e
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.aPX) {
            this.aPX = false;
            return false;
        } else if (!this.aPt) {
            return this.aQe.onTouchEvent(motionEvent);
        } else {
            boolean z2 = this.aPN;
            this.aPN = false;
            if (!z2) {
                n(motionEvent);
            }
            if (this.mDragState == 4) {
                onDragTouchEvent(motionEvent);
                return true;
            }
            if (this.mDragState == 0 && this.aQe.onTouchEvent(motionEvent)) {
                z = true;
            }
            switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
                case 1:
                case 3:
                    Ie();
                    return z;
                case 2:
                default:
                    if (z) {
                        this.aPR = 1;
                        return z;
                    }
                    return z;
            }
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.e
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (!this.aPt) {
            return this.aQe.onInterceptTouchEvent(motionEvent);
        }
        if (this.aQf != null) {
            this.aQf.Io().onTouchEvent(motionEvent);
        }
        n(motionEvent);
        this.aPN = true;
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        if (action == 0) {
            if (this.mDragState != 0) {
                this.aPX = true;
                return true;
            }
            this.aPO = true;
        }
        if (this.aOZ == null) {
            if (this.aQe.onInterceptTouchEvent(motionEvent)) {
                this.aQg = true;
                z = true;
            } else {
                z = false;
            }
            switch (action) {
                case 1:
                case 3:
                    Ie();
                    break;
                case 2:
                default:
                    if (z) {
                        this.aPR = 1;
                        break;
                    } else {
                        this.aPR = 2;
                        break;
                    }
            }
        } else {
            z = true;
        }
        if (action == 1 || action == 3) {
            this.aPO = false;
        }
        return z;
    }

    @Override // com.baidu.tbadk.widget.dragsort.e
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        this.aQe.onSizeChanged(i2, i3, i4, i5);
        If();
    }

    @Override // com.baidu.tbadk.widget.dragsort.e
    public void requestLayout() {
        if (!this.mBlockLayoutRequests) {
            this.aQe.requestLayout();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.e
    public void onMeasure(int i2, int i3) {
        this.aQe.onMeasure(i2, i3);
        if (this.aOZ != null) {
            if (this.aOZ.isLayoutRequested()) {
                Ih();
            }
            this.aPd = true;
        }
        this.mWidthMeasureSpec = i2;
    }

    @Override // com.baidu.tbadk.widget.dragsort.e
    public void layoutChildren() {
        this.aQe.layoutChildren();
        if (this.aOZ != null) {
            if (this.aOZ.isLayoutRequested() && !this.aPd) {
                Ih();
            }
            this.aOZ.layout(0, 0, this.aOZ.getMeasuredWidth(), this.aOZ.getMeasuredHeight());
            this.aPd = false;
        }
    }

    public void removeItem(int i2, float f2) {
        if (this.mDragState == 0 || this.mDragState == 4) {
            if (this.mDragState == 0) {
                this.aPl = this.mListView.getHeaderViewsCount() + i2;
                this.aPi = this.aPl;
                this.aPj = this.aPl;
                this.aPh = this.aPl;
                View childAt = this.mListView.getChildAt(this.aPl - this.mListView.getFirstVisiblePosition());
                if (childAt != null) {
                    childAt.setVisibility(4);
                }
            }
            this.mDragState = 1;
            this.aQd = f2;
            if (this.aPO) {
                switch (this.aPR) {
                    case 1:
                        this.aQe.onTouchEvent(this.aPQ);
                        break;
                    case 2:
                        this.aQe.onInterceptTouchEvent(this.aPQ);
                        break;
                }
            }
            if (this.aPZ != null) {
                this.aPZ.start();
            } else {
                fD(i2);
            }
        }
    }

    public void cancelDrag() {
        if (this.mDragState == 4) {
            this.aPy.cb(true);
            Ij();
            Ia();
            Ig();
            if (this.aPO) {
                this.mDragState = 3;
            } else {
                this.mDragState = 0;
            }
        }
    }

    private void Ia() {
        this.aPl = -1;
        this.aPi = -1;
        this.aPj = -1;
        this.aPh = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ib() {
        this.mDragState = 2;
        if (this.aPr != null && this.aPh >= 0 && this.aPh < this.mListView.getCount()) {
            int headerViewsCount = this.mListView.getHeaderViewsCount();
            this.aPr.drop(this.aPl - headerViewsCount, this.aPh - headerViewsCount);
        }
        Ij();
        Id();
        Ia();
        Ig();
        if (this.aPO) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ic() {
        fD(this.aPl - this.mListView.getHeaderViewsCount());
    }

    private void fD(int i2) {
        this.mDragState = 1;
        if (this.aPs != null) {
            this.aPs.remove(i2);
        }
        Ij();
        Id();
        Ia();
        if (this.aPO) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    private void Id() {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        if (this.aPl < firstVisiblePosition) {
            View childAt = this.mListView.getChildAt(0);
            this.mListView.setSelectionFromTop(firstVisiblePosition - 1, (childAt != null ? childAt.getTop() : 0) - this.mListView.getPaddingTop());
        }
    }

    public boolean stopDrag(boolean z) {
        this.aQc = false;
        return stopDrag(z, 0.0f);
    }

    public boolean stopDragWithVelocity(boolean z, float f2) {
        this.aQc = true;
        return stopDrag(z, f2);
    }

    public boolean stopDrag(boolean z, float f2) {
        if (this.aOZ != null) {
            this.aPy.cb(true);
            if (z) {
                removeItem(this.aPl - this.mListView.getHeaderViewsCount(), f2);
            } else if (this.aQb != null) {
                this.aQb.start();
            } else {
                Ib();
            }
            if (this.aPV) {
                this.aPW.kF();
                return true;
            }
            return true;
        }
        return false;
    }

    private void Ie() {
        this.aPR = 0;
        this.aPO = false;
        if (this.mDragState == 3) {
            this.mDragState = 0;
        }
        this.aPg = this.aPf;
        this.aQg = false;
        this.aPY.clear();
    }

    private void n(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        if (action != 0) {
            this.mLastX = this.aPJ;
            this.mLastY = this.aPK;
        }
        this.aPJ = (int) motionEvent.getX();
        this.aPK = (int) motionEvent.getY();
        if (action == 0) {
            this.mLastX = this.aPJ;
            this.mLastY = this.aPK;
        }
        this.aPo = ((int) motionEvent.getRawX()) - this.aPJ;
        this.aPp = ((int) motionEvent.getRawY()) - this.aPK;
    }

    public boolean listViewIntercepted() {
        return this.aQg;
    }

    public void setDragScrollStart(float f2) {
        setDragScrollStarts(f2, f2);
    }

    public void setDragScrollStarts(float f2, float f3) {
        if (f3 > 0.5f) {
            this.aPA = 0.5f;
        } else {
            this.aPA = f3;
        }
        if (f2 > 0.5f) {
            this.aPz = 0.5f;
        } else {
            this.aPz = f2;
        }
        if (this.mListView.getHeight() != 0) {
            If();
        }
    }

    private void P(int i2, int i3) {
        this.aPa.x = i2 - this.aPm;
        this.aPa.y = i3 - this.aPn;
        ca(true);
        int min = Math.min(i3, this.aPc + this.aPw);
        int max = Math.max(i3, this.aPc - this.aPw);
        int Il = this.aPy.Il();
        if (min > this.mLastY && min > this.aPC && Il != 1) {
            if (Il != -1) {
                this.aPy.cb(true);
            }
            this.aPy.fF(1);
        } else if (max < this.mLastY && max < this.aPB && Il != 0) {
            if (Il != -1) {
                this.aPy.cb(true);
            }
            this.aPy.fF(0);
        } else if (max >= this.aPB && min <= this.aPC && this.aPy.Ik()) {
            this.aPy.cb(true);
        }
    }

    private void If() {
        int height;
        int paddingTop = this.mListView.getPaddingTop();
        float height2 = (this.mListView.getHeight() - paddingTop) - this.mListView.getPaddingBottom();
        this.aPE = paddingTop + (this.aPz * height2);
        this.aPD = (height2 * (1.0f - this.aPA)) + paddingTop;
        this.aPB = (int) this.aPE;
        this.aPC = (int) this.aPD;
        this.aPF = this.aPE - paddingTop;
        this.aPG = (paddingTop + height) - this.aPD;
    }

    private void Ig() {
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
        if (i2 != this.aPl && i2 != this.aPi && i2 != this.aPj) {
            g2 = -2;
        } else {
            g2 = g(i2, view, z);
        }
        if (g2 != layoutParams.height) {
            layoutParams.height = g2;
            view.setLayoutParams(layoutParams);
        }
        if (i2 == this.aPi || i2 == this.aPj) {
            if (i2 < this.aPl) {
                ((com.baidu.tbadk.widget.dragsort.c) view).setGravity(80);
            } else if (i2 > this.aPl) {
                ((com.baidu.tbadk.widget.dragsort.c) view).setGravity(48);
            }
        }
        int visibility = view.getVisibility();
        int i3 = 0;
        if (i2 == this.aPl && this.aOZ != null) {
            i3 = 4;
        }
        if (i3 != visibility) {
            view.setVisibility(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int fE(int i2) {
        View view;
        if (i2 == this.aPl) {
            return 0;
        }
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        if (childAt != null) {
            return f(i2, childAt, false);
        }
        int i3 = this.aPY.get(i2);
        if (i3 == -1) {
            ListAdapter adapter = this.mListView.getAdapter();
            int itemViewType = adapter.getItemViewType(i2);
            int viewTypeCount = adapter.getViewTypeCount();
            if (viewTypeCount != this.aPx.length) {
                this.aPx = new View[viewTypeCount];
            }
            if (itemViewType >= 0) {
                if (this.aPx[itemViewType] == null) {
                    view = adapter.getView(i2, null, this.mListView);
                    this.aPx[itemViewType] = view;
                } else {
                    view = adapter.getView(i2, this.aPx[itemViewType], this.mListView);
                }
            } else {
                view = adapter.getView(i2, null, this.mListView);
            }
            int f2 = f(i2, view, true);
            this.aPY.add(i2, f2);
            return f2;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(int i2, View view, boolean z) {
        if (i2 == this.aPl) {
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
        return Q(i2, f(i2, view, z));
    }

    private int Q(int i2, int i3) {
        this.mListView.getDividerHeight();
        boolean z = this.aPk && this.aPi != this.aPj;
        int i4 = this.aPv - this.aPu;
        int i5 = (int) (this.aPT * i4);
        if (i2 == this.aPl) {
            if (this.aPl == this.aPi) {
                if (z) {
                    return i5 + this.aPu;
                }
                return this.aPv;
            } else if (this.aPl == this.aPj) {
                return this.aPv - i5;
            } else {
                return this.aPu;
            }
        } else if (i2 == this.aPi) {
            if (z) {
                return i3 + i5;
            }
            return i3 + i4;
        } else if (i2 == this.aPj) {
            return (i3 + i4) - i5;
        } else {
            return i3;
        }
    }

    private int b(int i2, View view, int i3, int i4) {
        int i5;
        int i6;
        int fE = fE(i2);
        int height = view.getHeight();
        int Q = Q(i2, fE);
        if (i2 != this.aPl) {
            i6 = height - fE;
            i5 = Q - fE;
        } else {
            i5 = Q;
            i6 = height;
        }
        int i7 = this.aPv;
        if (this.aPl != this.aPi && this.aPl != this.aPj) {
            i7 -= this.aPu;
        }
        if (i2 <= i3) {
            if (i2 > this.aPi) {
                return (i7 - i5) + 0;
            }
        } else if (i2 == i4) {
            if (i2 <= this.aPi) {
                return (i6 - i7) + 0;
            }
            if (i2 == this.aPj) {
                return (height - Q) + 0;
            }
            return 0 + i6;
        } else if (i2 <= this.aPi) {
            return 0 - i7;
        } else {
            if (i2 == this.aPj) {
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

    private void Ih() {
        if (this.aOZ != null) {
            measureItem(this.aOZ);
            this.aPv = this.aOZ.getMeasuredHeight();
            this.aPw = this.aPv / 2;
        }
    }

    protected boolean onDragTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
            case 1:
                if (this.mDragState == 4) {
                    stopDrag(false);
                }
                Ie();
                return true;
            case 2:
                P((int) motionEvent.getX(), (int) motionEvent.getY());
                return true;
            case 3:
                if (this.mDragState == 4) {
                    cancelDrag();
                }
                Ie();
                return true;
            default:
                return true;
        }
    }

    public boolean startDrag(int i2, int i3, int i4, int i5) {
        View fG;
        if (!this.aPO || this.aPP == null || (fG = this.aPP.fG(i2)) == null) {
            return false;
        }
        return startDrag(i2, fG, i3, i4, i5);
    }

    public boolean startDrag(int i2, View view, int i3, int i4, int i5) {
        if (this.mDragState == 0 && this.aPO && this.aOZ == null && view != null && this.aPt) {
            if (this.mListView.getParent() != null) {
                this.mListView.getParent().requestDisallowInterceptTouchEvent(true);
            }
            int headerViewsCount = this.mListView.getHeaderViewsCount() + i2;
            this.aPi = headerViewsCount;
            this.aPj = headerViewsCount;
            this.aPl = headerViewsCount;
            this.aPh = headerViewsCount;
            this.mDragState = 4;
            this.aPM = 0;
            this.aPM |= i3;
            this.aOZ = view;
            Ih();
            this.aPm = i4;
            this.aPn = i5;
            this.aPL = this.aPK;
            this.aPa.x = this.aPJ - this.aPm;
            this.aPa.y = this.aPK - this.aPn;
            View childAt = this.mListView.getChildAt(this.aPl - this.mListView.getFirstVisiblePosition());
            if (childAt != null) {
                childAt.setVisibility(4);
            }
            if (this.aPV) {
                this.aPW.startTracking();
            }
            switch (this.aPR) {
                case 1:
                    this.aQe.onTouchEvent(this.aPQ);
                    break;
                case 2:
                    this.aQe.onInterceptTouchEvent(this.aPQ);
                    break;
            }
            this.mListView.requestLayout();
            if (this.aQa != null) {
                this.aQa.start();
                return true;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ca(boolean z) {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition() + (this.mListView.getChildCount() / 2);
        View childAt = this.mListView.getChildAt(this.mListView.getChildCount() / 2);
        if (childAt != null) {
            h(firstVisiblePosition, childAt, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i2, View view, boolean z) {
        this.mBlockLayoutRequests = true;
        Ii();
        int i3 = this.aPi;
        int i4 = this.aPj;
        boolean HZ = HZ();
        if (HZ) {
            Ig();
            this.mListView.setSelectionFromTop(i2, (b(i2, view, i3, i4) + view.getTop()) - this.mListView.getPaddingTop());
            layoutChildren();
        }
        if (HZ || z) {
            this.mListView.invalidate();
        }
        this.mBlockLayoutRequests = false;
    }

    private void Ii() {
        if (this.aPP != null) {
            this.aPb.set(this.aPJ, this.aPK);
            this.aPP.b(this.aOZ, this.aPa, this.aPb);
        }
        int i2 = this.aPa.x;
        int i3 = this.aPa.y;
        int paddingLeft = this.mListView.getPaddingLeft();
        if ((this.aPM & 1) == 0 && i2 > paddingLeft) {
            this.aPa.x = paddingLeft;
        } else if ((this.aPM & 2) == 0 && i2 < paddingLeft) {
            this.aPa.x = paddingLeft;
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int lastVisiblePosition = this.mListView.getLastVisiblePosition();
        int paddingTop = this.mListView.getPaddingTop();
        if (firstVisiblePosition < headerViewsCount) {
            paddingTop = this.mListView.getChildAt((headerViewsCount - firstVisiblePosition) - 1).getBottom();
        }
        if ((this.aPM & 8) == 0 && firstVisiblePosition <= this.aPl) {
            paddingTop = Math.max(this.mListView.getChildAt(this.aPl - firstVisiblePosition).getTop(), paddingTop);
        }
        int height = this.mListView.getHeight() - this.mListView.getPaddingBottom();
        if (lastVisiblePosition >= (this.mListView.getCount() - footerViewsCount) - 1) {
            height = this.mListView.getChildAt(((this.mListView.getCount() - footerViewsCount) - 1) - firstVisiblePosition).getBottom();
        }
        if ((this.aPM & 4) == 0 && lastVisiblePosition >= this.aPl) {
            height = Math.min(this.mListView.getChildAt(this.aPl - firstVisiblePosition).getBottom(), height);
        }
        if (i3 < paddingTop) {
            this.aPa.y = paddingTop;
        } else if (this.aPv + i3 > height) {
            this.aPa.y = height - this.aPv;
        }
        this.aPc = this.aPa.y + this.aPw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ij() {
        if (this.aOZ != null) {
            this.aOZ.setVisibility(8);
            if (this.aPP != null) {
                this.aPP.S(this.aOZ);
            }
            this.aOZ = null;
            this.mListView.invalidate();
        }
    }

    public void a(h hVar) {
        this.aPP = hVar;
    }

    public void a(b bVar) {
        this.aPq = bVar;
    }

    public void setDragEnabled(boolean z) {
        this.aPt = z;
    }

    public boolean isDragEnabled() {
        return this.aPt;
    }

    public void a(g gVar) {
        this.aPr = gVar;
    }

    public void a(l lVar) {
        this.aPs = lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class i {
        private SparseIntArray aQA;
        private ArrayList<Integer> aQB;
        private int mMaxSize;

        public i(int i) {
            this.aQA = new SparseIntArray(i);
            this.aQB = new ArrayList<>(i);
            this.mMaxSize = i;
        }

        public void add(int i, int i2) {
            int i3 = this.aQA.get(i, -1);
            if (i3 != i2) {
                if (i3 == -1) {
                    if (this.aQA.size() == this.mMaxSize) {
                        this.aQA.delete(this.aQB.remove(0).intValue());
                    }
                } else {
                    this.aQB.remove(Integer.valueOf(i));
                }
                this.aQA.put(i, i2);
                this.aQB.add(Integer.valueOf(i));
            }
        }

        public int get(int i) {
            return this.aQA.get(i, -1);
        }

        public void clear() {
            this.aQA.clear();
            this.aQB.clear();
        }
    }

    /* renamed from: com.baidu.tbadk.widget.dragsort.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0068a extends BaseAdapter {
        private ListAdapter mAdapter;

        public C0068a(ListAdapter listAdapter) {
            this.mAdapter = listAdapter;
            this.mAdapter.registerDataSetObserver(new DataSetObserver() { // from class: com.baidu.tbadk.widget.dragsort.a.a.1
                @Override // android.database.DataSetObserver
                public void onChanged() {
                    C0068a.this.notifyDataSetChanged();
                }

                @Override // android.database.DataSetObserver
                public void onInvalidated() {
                    C0068a.this.notifyDataSetInvalidated();
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
        private float aQL;
        private float aQM;
        private float aQN;
        private float aQO;
        private float aQP;
        private float mAlpha;
        private boolean mCanceled;
        protected long mStartTime;

        public m(float f, int i) {
            this.mAlpha = f;
            this.aQL = i;
            float f2 = 1.0f / ((this.mAlpha * 2.0f) * (1.0f - this.mAlpha));
            this.aQP = f2;
            this.aQM = f2;
            this.aQN = this.mAlpha / ((this.mAlpha - 1.0f) * 2.0f);
            this.aQO = 1.0f / (1.0f - this.mAlpha);
        }

        public float F(float f) {
            if (f < this.mAlpha) {
                return this.aQM * f * f;
            }
            if (f < 1.0f - this.mAlpha) {
                return this.aQN + (this.aQO * f);
            }
            return 1.0f - ((this.aQP * (f - 1.0f)) * (f - 1.0f));
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

        public void f(float f, float f2) {
        }

        public void onStop() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.mCanceled) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / this.aQL;
                if (uptimeMillis >= 1.0f) {
                    f(1.0f, 1.0f);
                    onStop();
                    return;
                }
                f(uptimeMillis, F(uptimeMillis));
                a.this.mListView.post(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class f extends m {
        private int aQw;
        private int aQx;
        private float aQy;
        private float aQz;

        public f(float f, int i) {
            super(f, i);
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.aQw = a.this.aPh;
            this.aQx = a.this.aPl;
            a.this.mDragState = 2;
            this.aQy = a.this.aPa.y - In();
            this.aQz = a.this.aPa.x - a.this.mListView.getPaddingLeft();
        }

        private int In() {
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            int dividerHeight = (a.this.aPu + a.this.mListView.getDividerHeight()) / 2;
            View childAt = a.this.mListView.getChildAt(this.aQw - firstVisiblePosition);
            if (childAt != null) {
                if (this.aQw == this.aQx) {
                    return childAt.getTop();
                }
                if (this.aQw >= this.aQx) {
                    return (childAt.getBottom() + dividerHeight) - a.this.aPv;
                }
                return childAt.getTop() - dividerHeight;
            }
            cancel();
            return -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void f(float f, float f2) {
            int In = In();
            float paddingLeft = a.this.aPa.x - a.this.mListView.getPaddingLeft();
            float f3 = 1.0f - f2;
            if (f3 < Math.abs((a.this.aPa.y - In) / this.aQy) || f3 < Math.abs(paddingLeft / this.aQz)) {
                a.this.aPa.y = In + ((int) (this.aQy * f3));
                a.this.aPa.x = a.this.mListView.getPaddingLeft() + ((int) (this.aQz * f3));
                a.this.ca(true);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.Ib();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class k extends m {
        private float aQE;
        private float aQF;
        private float aQG;
        private int aQH;
        private int aQI;
        private int aQJ;
        private int aQK;
        private int aQx;

        public k(float f, int i) {
            super(f, i);
            this.aQH = -1;
            this.aQI = -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.aQH = -1;
            this.aQI = -1;
            this.aQJ = a.this.aPi;
            this.aQK = a.this.aPj;
            this.aQx = a.this.aPl;
            a.this.mDragState = 1;
            this.aQE = a.this.aPa.x;
            if (a.this.aQc) {
                float width = a.this.mListView.getWidth() * 2.0f;
                if (a.this.aQd == 0.0f) {
                    a.this.aQd = (this.aQE >= 0.0f ? 1 : -1) * width;
                    return;
                }
                float f = width * 2.0f;
                if (a.this.aQd >= 0.0f || a.this.aQd <= (-f)) {
                    if (a.this.aQd > 0.0f && a.this.aQd < f) {
                        a.this.aQd = f;
                        return;
                    }
                    return;
                }
                a.this.aQd = -f;
                return;
            }
            a.this.Ij();
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void f(float f, float f2) {
            View childAt;
            float f3 = 1.0f - f2;
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            View childAt2 = a.this.mListView.getChildAt(this.aQJ - firstVisiblePosition);
            if (a.this.aQc) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / 1000.0f;
                if (uptimeMillis != 0.0f) {
                    float f4 = a.this.aQd * uptimeMillis;
                    int width = a.this.mListView.getWidth();
                    a.this.aQd = ((a.this.aQd > 0.0f ? 1 : -1) * uptimeMillis * width) + a.this.aQd;
                    this.aQE += f4;
                    a.this.aPa.x = (int) this.aQE;
                    if (this.aQE < width && this.aQE > (-width)) {
                        this.mStartTime = SystemClock.uptimeMillis();
                        a.this.ca(true);
                        return;
                    }
                } else {
                    return;
                }
            }
            if (childAt2 != null) {
                if (this.aQH == -1) {
                    this.aQH = a.this.f(this.aQJ, childAt2, false);
                    this.aQF = childAt2.getHeight() - this.aQH;
                }
                int max = Math.max((int) (this.aQF * f3), 1);
                ViewGroup.LayoutParams layoutParams = childAt2.getLayoutParams();
                layoutParams.height = max + this.aQH;
                childAt2.setLayoutParams(layoutParams);
            }
            if (this.aQK != this.aQJ && (childAt = a.this.mListView.getChildAt(this.aQK - firstVisiblePosition)) != null) {
                if (this.aQI == -1) {
                    this.aQI = a.this.f(this.aQK, childAt, false);
                    this.aQG = childAt.getHeight() - this.aQI;
                }
                int max2 = Math.max((int) (this.aQG * f3), 1);
                ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
                layoutParams2.height = max2 + this.aQI;
                childAt.setLayoutParams(layoutParams2);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.Ic();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class j extends m {
        private float aQC;
        private float aQD;
        final /* synthetic */ a aQi;

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.aQC = this.aQi.aPn;
            this.aQD = this.aQi.aPw;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void f(float f, float f2) {
            if (this.aQi.mDragState != 4) {
                cancel();
                return;
            }
            this.aQi.aPn = (int) ((this.aQD * f2) + ((1.0f - f2) * this.aQC));
            this.aQi.aPa.y = this.aQi.aPK - this.aQi.aPn;
            this.aQi.ca(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e {
        StringBuilder mBuilder = new StringBuilder();
        private int aQt = 0;
        private int aQu = 0;
        private boolean aQv = false;
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
            this.aQu = 0;
            this.aQv = true;
        }

        public void Im() {
            if (this.aQv) {
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
                this.mBuilder.append("    <FirstExpPos>").append(a.this.aPi).append("</FirstExpPos>\n");
                this.mBuilder.append("    <FirstExpBlankHeight>").append(a.this.fC(a.this.aPi) - a.this.fE(a.this.aPi)).append("</FirstExpBlankHeight>\n");
                this.mBuilder.append("    <SecondExpPos>").append(a.this.aPj).append("</SecondExpPos>\n");
                this.mBuilder.append("    <SecondExpBlankHeight>").append(a.this.fC(a.this.aPj) - a.this.fE(a.this.aPj)).append("</SecondExpBlankHeight>\n");
                this.mBuilder.append("    <SrcPos>").append(a.this.aPl).append("</SrcPos>\n");
                this.mBuilder.append("    <SrcHeight>").append(a.this.aPv + a.this.mListView.getDividerHeight()).append("</SrcHeight>\n");
                this.mBuilder.append("    <ViewHeight>").append(a.this.mListView.getHeight()).append("</ViewHeight>\n");
                this.mBuilder.append("    <LastY>").append(a.this.mLastY).append("</LastY>\n");
                this.mBuilder.append("    <FloatY>").append(a.this.aPc).append("</FloatY>\n");
                this.mBuilder.append("    <ShuffleEdges>");
                for (int i4 = 0; i4 < childCount; i4++) {
                    this.mBuilder.append(a.this.O(firstVisiblePosition + i4, a.this.mListView.getChildAt(i4).getTop())).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                this.mBuilder.append("</ShuffleEdges>\n");
                this.mBuilder.append("</DSLVState>\n");
                this.aQt++;
                if (this.aQt > 1000) {
                    flush();
                    this.aQt = 0;
                }
            }
        }

        public void flush() {
            if (this.aQv) {
                try {
                    FileWriter fileWriter = new FileWriter(this.mFile, this.aQu != 0);
                    fileWriter.write(this.mBuilder.toString());
                    this.mBuilder.delete(0, this.mBuilder.length());
                    fileWriter.flush();
                    fileWriter.close();
                    this.aQu++;
                } catch (IOException e) {
                }
            }
        }

        public void kF() {
            if (this.aQv) {
                this.mBuilder.append("</DSLVStates>\n");
                flush();
                this.aQv = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements Runnable {
        private boolean aQl;
        private long aQm;
        private long aQn;
        private float aQo;
        private long aQp;
        private int aQq;
        private float aQr;
        private boolean aQs = false;
        private int dy;

        public boolean Ik() {
            return this.aQs;
        }

        public int Il() {
            if (this.aQs) {
                return this.aQq;
            }
            return -1;
        }

        public d() {
        }

        public void fF(int i) {
            if (!this.aQs) {
                this.aQl = false;
                this.aQs = true;
                this.aQp = SystemClock.uptimeMillis();
                this.aQm = this.aQp;
                this.aQq = i;
                a.this.mListView.post(this);
            }
        }

        public void cb(boolean z) {
            if (z) {
                a.this.mListView.removeCallbacks(this);
                this.aQs = false;
                return;
            }
            this.aQl = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.aQl) {
                int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
                int lastVisiblePosition = a.this.mListView.getLastVisiblePosition();
                int count = a.this.mListView.getCount();
                int paddingTop = a.this.mListView.getPaddingTop();
                int height = (a.this.mListView.getHeight() - paddingTop) - a.this.mListView.getPaddingBottom();
                int min = Math.min(a.this.aPK, a.this.aPc + a.this.aPw);
                int max = Math.max(a.this.aPK, a.this.aPc - a.this.aPw);
                if (this.aQq == 0) {
                    View childAt = a.this.mListView.getChildAt(0);
                    if (childAt == null) {
                        this.aQs = false;
                        return;
                    } else if (firstVisiblePosition == 0 && childAt.getTop() == paddingTop) {
                        this.aQs = false;
                        return;
                    } else {
                        this.aQr = a.this.aPI.b((a.this.aPE - max) / a.this.aPF, this.aQm);
                    }
                } else {
                    View childAt2 = a.this.mListView.getChildAt(lastVisiblePosition - firstVisiblePosition);
                    if (childAt2 == null) {
                        this.aQs = false;
                        return;
                    } else if (lastVisiblePosition == count - 1 && childAt2.getBottom() <= height + paddingTop) {
                        this.aQs = false;
                        return;
                    } else {
                        this.aQr = -a.this.aPI.b((min - a.this.aPD) / a.this.aPG, this.aQm);
                    }
                }
                this.aQn = SystemClock.uptimeMillis();
                this.aQo = (float) (this.aQn - this.aQm);
                this.dy = Math.round(this.aQr * this.aQo);
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
                this.aQm = this.aQn;
                a.this.mListView.post(this);
                return;
            }
            this.aQs = false;
        }
    }
}
