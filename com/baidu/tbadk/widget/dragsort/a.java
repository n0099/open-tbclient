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
public class a implements com.baidu.tbadk.widget.dragsort.c {
    private View aPE;
    private int aPH;
    private int aPL;
    private int aPM;
    private int aPN;
    private int aPP;
    private int aPQ;
    private int aPR;
    private int aPS;
    private b aPT;
    private g aPU;
    private l aPV;
    private int aPY;
    private int aPZ;
    private k aQC;
    private j aQD;
    private f aQE;
    private boolean aQF;
    private com.baidu.tbadk.widget.dragsort.d aQH;
    private com.baidu.tbadk.widget.dragsort.b aQI;
    private d aQb;
    private int aQe;
    private int aQf;
    private float aQg;
    private float aQh;
    private float aQi;
    private float aQj;
    private int aQm;
    private int aQn;
    private int aQo;
    private MotionEvent aQt;
    private C0105a aQx;
    private e aQz;
    private int apL;
    private int mLastX;
    private int mLastY;
    private ListView mListView;
    private DataSetObserver mObserver;
    private Point aPF = new Point();
    private Point aPG = new Point();
    private boolean aPI = false;
    private float aPJ = 1.0f;
    private float aPK = 1.0f;
    private boolean aPO = false;
    private boolean aPW = true;
    private int mDragState = 0;
    private int aPX = 1;
    private int mWidthMeasureSpec = 0;
    private View[] aQa = new View[1];
    private float aQc = 0.33333334f;
    private float aQd = 0.33333334f;
    private float aQk = 0.5f;
    private c aQl = new c() { // from class: com.baidu.tbadk.widget.dragsort.a.1
        @Override // com.baidu.tbadk.widget.dragsort.a.c
        public float b(float f2, long j2) {
            return a.this.aQk * f2;
        }
    };
    private int aQp = 0;
    private boolean aQq = false;
    private boolean aQr = false;
    private h aQs = null;
    private int aQu = 0;
    private float aQv = 0.25f;
    private float aQw = 0.0f;
    private boolean aQy = false;
    private boolean mBlockLayoutRequests = false;
    private boolean aQA = false;
    private i aQB = new i(3);
    private float aQG = 0.0f;
    private boolean aQJ = false;
    private boolean aQK = false;

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
        void S(View view2);

        void b(View view2, Point point, Point point2);

        View fy(int i);
    }

    /* loaded from: classes.dex */
    public interface l {
        void remove(int i);
    }

    public a(ListView listView, com.baidu.tbadk.widget.dragsort.d dVar) {
        this.aQH = dVar;
        this.mListView = listView;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            this.aQx = new C0105a(listAdapter);
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
            this.aQx = null;
        }
        this.aQH.setAdapter(this.aQx);
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
            if (i2 > this.aPP) {
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
    public int fu(int i2) {
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        return childAt != null ? childAt.getHeight() : M(i2, fw(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int K(int i2, int i3) {
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        if (i2 <= headerViewsCount || i2 >= this.mListView.getCount() - footerViewsCount) {
            return i3;
        }
        int dividerHeight = this.mListView.getDividerHeight();
        int i4 = this.aPY - this.aPX;
        int fw = fw(i2);
        int fu = fu(i2);
        if (this.aPN <= this.aPP) {
            if (i2 == this.aPN && this.aPM != this.aPN) {
                if (i2 == this.aPP) {
                    i3 = (i3 + fu) - this.aPY;
                } else {
                    i3 = ((fu - fw) + i3) - i4;
                }
            } else if (i2 > this.aPN && i2 <= this.aPP) {
                i3 -= i4;
            }
        } else if (i2 > this.aPP && i2 <= this.aPM) {
            i3 += i4;
        } else if (i2 == this.aPN && this.aPM != this.aPN) {
            i3 += fu - fw;
        }
        if (i2 <= this.aPP) {
            return (((this.aPY - dividerHeight) - fw(i2 - 1)) / 2) + i3;
        }
        return (((fw - dividerHeight) - this.aPY) / 2) + i3;
    }

    private boolean Iv() {
        int i2;
        int i3;
        int i4;
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int i5 = this.aPM;
        View childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        if (childAt == null) {
            i5 = firstVisiblePosition + (this.mListView.getChildCount() / 2);
            childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        }
        int top = childAt.getTop();
        int height = childAt.getHeight();
        int K = K(i5, top);
        int dividerHeight = this.mListView.getDividerHeight();
        if (this.aPH >= K) {
            int count = this.mListView.getCount();
            int i6 = height;
            int i7 = top;
            i2 = K;
            i3 = i5;
            i4 = K;
            while (true) {
                if (i3 < count) {
                    if (i3 == count - 1) {
                        i2 = i7 + dividerHeight + i6;
                        break;
                    }
                    i7 += dividerHeight + i6;
                    i6 = fu(i3 + 1);
                    i2 = K(i3 + 1, i7);
                    if (this.aPH < i2) {
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
            i2 = K;
            i3 = i5;
            i4 = K;
            while (true) {
                if (i3 < 0) {
                    break;
                }
                i3--;
                int fu = fu(i3);
                if (i3 == 0) {
                    i2 = (i8 - dividerHeight) - fu;
                    break;
                }
                i8 -= fu + dividerHeight;
                i2 = K(i3, i8);
                if (this.aPH >= i2) {
                    break;
                }
                i4 = i2;
            }
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int i9 = this.aPM;
        int i10 = this.aPN;
        float f2 = this.aQw;
        if (this.aPO) {
            int abs = Math.abs(i2 - i4);
            if (this.aPH >= i2) {
                int i11 = i4;
                i4 = i2;
                i2 = i11;
            }
            int i12 = (int) (abs * this.aQv * 0.5f);
            float f3 = i12;
            int i13 = i4 + i12;
            int i14 = i2 - i12;
            if (this.aPH < i13) {
                this.aPM = i3 - 1;
                this.aPN = i3;
                this.aQw = ((i13 - this.aPH) * 0.5f) / f3;
            } else if (this.aPH < i14) {
                this.aPM = i3;
                this.aPN = i3;
            } else {
                this.aPM = i3;
                this.aPN = i3 + 1;
                this.aQw = (1.0f + ((i2 - this.aPH) / f3)) * 0.5f;
            }
        } else {
            this.aPM = i3;
            this.aPN = i3;
        }
        if (this.aPM < headerViewsCount) {
            this.aPM = headerViewsCount;
            this.aPN = headerViewsCount;
            i3 = headerViewsCount;
        } else if (this.aPN >= this.mListView.getCount() - footerViewsCount) {
            i3 = (this.mListView.getCount() - footerViewsCount) - 1;
            this.aPM = i3;
            this.aPN = i3;
        }
        boolean z = (this.aPM == i9 && this.aPN == i10 && this.aQw == f2) ? false : true;
        if (i3 != this.aPL) {
            if (this.aPT != null) {
                this.aPT.drag(this.aPL - headerViewsCount, i3 - headerViewsCount);
            }
            this.aPL = i3;
            return true;
        }
        return z;
    }

    public void removeItem(int i2) {
        this.aQF = false;
        removeItem(i2, 0.0f);
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void a(ListView listView, Context context, AttributeSet attributeSet) {
        int i2;
        int i3 = BaseActivity.SHOW_SOFT_KEYBOARD_DELAY;
        if (attributeSet == null) {
            i2 = 150;
        } else {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.m.DragSort, 0, 0);
            this.aPX = Math.max(1, obtainStyledAttributes.getDimensionPixelSize(d.m.DragSort_collapsed_height, 1));
            this.aQy = obtainStyledAttributes.getBoolean(d.m.DragSort_track_drag_sort, false);
            if (this.aQy) {
                this.aQz = new e();
            }
            this.aPJ = obtainStyledAttributes.getFloat(d.m.DragSort_float_alpha, this.aPJ);
            this.aPK = this.aPJ;
            this.aPW = obtainStyledAttributes.getBoolean(d.m.DragSort_drag_enabled, this.aPW);
            this.aQv = Math.max(0.0f, Math.min(1.0f, 1.0f - obtainStyledAttributes.getFloat(d.m.DragSort_slide_shuffle_speed, 0.75f)));
            this.aPO = this.aQv > 0.0f;
            setDragScrollStart(obtainStyledAttributes.getFloat(d.m.DragSort_drag_scroll_start, this.aQc));
            this.aQk = obtainStyledAttributes.getFloat(d.m.DragSort_max_drag_scroll_speed, this.aQk);
            int i4 = obtainStyledAttributes.getInt(d.m.DragSort_remove_animation_duration, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
            int i5 = obtainStyledAttributes.getInt(d.m.DragSort_drop_animation_duration, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
            if (obtainStyledAttributes.getBoolean(d.m.DragSort_use_default_controller, true)) {
                boolean z = obtainStyledAttributes.getBoolean(d.m.DragSort_remove_enabled, false);
                int i6 = obtainStyledAttributes.getInt(d.m.DragSort_remove_mode, 1);
                boolean z2 = obtainStyledAttributes.getBoolean(d.m.DragSort_sort_enabled, true);
                int resourceId = obtainStyledAttributes.getResourceId(d.m.DragSort_drag_handle_id, 0);
                int resourceId2 = obtainStyledAttributes.getResourceId(d.m.DragSort_fling_handle_id, 0);
                int resourceId3 = obtainStyledAttributes.getResourceId(d.m.DragSort_click_remove_id, 0);
                int color = obtainStyledAttributes.getColor(d.m.DragSort_float_background_color, ViewCompat.MEASURED_STATE_MASK);
                com.baidu.tbadk.widget.dragsort.b bVar = new com.baidu.tbadk.widget.dragsort.b(this, listView, resourceId, 2, i6, resourceId3, resourceId2);
                bVar.cc(z);
                bVar.cb(z2);
                bVar.setBackgroundColor(color);
                this.aQs = bVar;
                a(bVar);
            }
            obtainStyledAttributes.recycle();
            i2 = i5;
            i3 = i4;
        }
        this.aQb = new d();
        if (i3 > 0) {
            this.aQC = new k(0.5f, i3);
        }
        if (i2 > 0) {
            this.aQE = new f(0.5f, i2);
        }
        this.aQt = MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
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
        this.aQI = bVar;
        this.mListView.setOnTouchListener(bVar);
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void dispatchDraw(Canvas canvas) {
        float f2;
        this.aQH.dispatchDraw(canvas);
        if (this.mDragState != 0) {
            if (this.aPM != this.aPP) {
                b(this.aPM, canvas);
            }
            if (this.aPN != this.aPM && this.aPN != this.aPP) {
                b(this.aPN, canvas);
            }
        }
        if (this.aPE != null) {
            int width = this.aPE.getWidth();
            int height = this.aPE.getHeight();
            int i2 = this.aPF.x;
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
            int i3 = (int) (f2 * 255.0f * this.aPK);
            canvas.save();
            canvas.translate(this.aPF.x, this.aPF.y);
            canvas.clipRect(0, 0, width, height);
            canvas.saveLayerAlpha(0.0f, 0.0f, width, height, i3, 31);
            this.aPE.draw(canvas);
            canvas.restore();
            canvas.restore();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onDraw(Canvas canvas) {
        this.aQH.onDraw(canvas);
        if (this.aQy) {
            this.aQz.II();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.aQA) {
            this.aQA = false;
            return false;
        } else if (!this.aPW) {
            return this.aQH.onTouchEvent(motionEvent);
        } else {
            boolean z2 = this.aQq;
            this.aQq = false;
            if (!z2) {
                s(motionEvent);
            }
            if (this.mDragState == 4) {
                onDragTouchEvent(motionEvent);
                return true;
            }
            if (this.mDragState == 0 && this.aQH.onTouchEvent(motionEvent)) {
                z = true;
            }
            switch (motionEvent.getAction() & 255) {
                case 1:
                case 3:
                    IA();
                    return z;
                case 2:
                default:
                    if (z) {
                        this.aQu = 1;
                        return z;
                    }
                    return z;
            }
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (!this.aPW) {
            return this.aQH.onInterceptTouchEvent(motionEvent);
        }
        if (this.aQI != null) {
            this.aQI.IK().onTouchEvent(motionEvent);
        }
        s(motionEvent);
        this.aQq = true;
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            if (this.mDragState != 0) {
                this.aQA = true;
                return true;
            }
            this.aQr = true;
        }
        if (this.aPE == null) {
            if (this.aQH.onInterceptTouchEvent(motionEvent)) {
                this.aQJ = true;
                z = true;
            } else {
                z = false;
            }
            switch (action) {
                case 1:
                case 3:
                    IA();
                    break;
                case 2:
                default:
                    if (z) {
                        this.aQu = 1;
                        break;
                    } else {
                        this.aQu = 2;
                        break;
                    }
            }
        } else {
            z = true;
        }
        if (action == 1 || action == 3) {
            this.aQr = false;
        }
        return z;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        this.aQH.onSizeChanged(i2, i3, i4, i5);
        IB();
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void requestLayout() {
        if (!this.mBlockLayoutRequests) {
            this.aQH.requestLayout();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onMeasure(int i2, int i3) {
        this.aQH.onMeasure(i2, i3);
        if (this.aPE != null) {
            if (this.aPE.isLayoutRequested()) {
                ID();
            }
            this.aPI = true;
        }
        this.mWidthMeasureSpec = i2;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void layoutChildren() {
        this.aQH.layoutChildren();
        if (this.aPE != null) {
            if (this.aPE.isLayoutRequested() && !this.aPI) {
                ID();
            }
            this.aPE.layout(0, 0, this.aPE.getMeasuredWidth(), this.aPE.getMeasuredHeight());
            this.aPI = false;
        }
    }

    public void removeItem(int i2, float f2) {
        if (this.mDragState == 0 || this.mDragState == 4) {
            if (this.mDragState == 0) {
                this.aPP = this.mListView.getHeaderViewsCount() + i2;
                this.aPM = this.aPP;
                this.aPN = this.aPP;
                this.aPL = this.aPP;
                View childAt = this.mListView.getChildAt(this.aPP - this.mListView.getFirstVisiblePosition());
                if (childAt != null) {
                    childAt.setVisibility(4);
                }
            }
            this.mDragState = 1;
            this.aQG = f2;
            if (this.aQr) {
                switch (this.aQu) {
                    case 1:
                        this.aQH.onTouchEvent(this.aQt);
                        break;
                    case 2:
                        this.aQH.onInterceptTouchEvent(this.aQt);
                        break;
                }
            }
            if (this.aQC != null) {
                this.aQC.start();
            } else {
                fv(i2);
            }
        }
    }

    public void cancelDrag() {
        if (this.mDragState == 4) {
            this.aQb.ca(true);
            IF();
            Iw();
            IC();
            if (this.aQr) {
                this.mDragState = 3;
            } else {
                this.mDragState = 0;
            }
        }
    }

    private void Iw() {
        this.aPP = -1;
        this.aPM = -1;
        this.aPN = -1;
        this.aPL = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ix() {
        this.mDragState = 2;
        if (this.aPU != null && this.aPL >= 0 && this.aPL < this.mListView.getCount()) {
            int headerViewsCount = this.mListView.getHeaderViewsCount();
            this.aPU.drop(this.aPP - headerViewsCount, this.aPL - headerViewsCount);
        }
        IF();
        Iz();
        Iw();
        IC();
        if (this.aQr) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Iy() {
        fv(this.aPP - this.mListView.getHeaderViewsCount());
    }

    private void fv(int i2) {
        this.mDragState = 1;
        if (this.aPV != null) {
            this.aPV.remove(i2);
        }
        IF();
        Iz();
        Iw();
        if (this.aQr) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    private void Iz() {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        if (this.aPP < firstVisiblePosition) {
            View childAt = this.mListView.getChildAt(0);
            this.mListView.setSelectionFromTop(firstVisiblePosition - 1, (childAt != null ? childAt.getTop() : 0) - this.mListView.getPaddingTop());
        }
    }

    public boolean stopDrag(boolean z) {
        this.aQF = false;
        return stopDrag(z, 0.0f);
    }

    public boolean stopDragWithVelocity(boolean z, float f2) {
        this.aQF = true;
        return stopDrag(z, f2);
    }

    public boolean stopDrag(boolean z, float f2) {
        if (this.aPE != null) {
            this.aQb.ca(true);
            if (z) {
                removeItem(this.aPP - this.mListView.getHeaderViewsCount(), f2);
            } else if (this.aQE != null) {
                this.aQE.start();
            } else {
                Ix();
            }
            if (this.aQy) {
                this.aQz.kh();
                return true;
            }
            return true;
        }
        return false;
    }

    private void IA() {
        this.aQu = 0;
        this.aQr = false;
        if (this.mDragState == 3) {
            this.mDragState = 0;
        }
        this.aPK = this.aPJ;
        this.aQJ = false;
        this.aQB.clear();
    }

    private void s(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            this.mLastX = this.aQm;
            this.mLastY = this.aQn;
        }
        this.aQm = (int) motionEvent.getX();
        this.aQn = (int) motionEvent.getY();
        if (action == 0) {
            this.mLastX = this.aQm;
            this.mLastY = this.aQn;
        }
        this.aPS = ((int) motionEvent.getRawX()) - this.aQm;
        this.apL = ((int) motionEvent.getRawY()) - this.aQn;
    }

    public boolean listViewIntercepted() {
        return this.aQJ;
    }

    public void setDragScrollStart(float f2) {
        setDragScrollStarts(f2, f2);
    }

    public void setDragScrollStarts(float f2, float f3) {
        if (f3 > 0.5f) {
            this.aQd = 0.5f;
        } else {
            this.aQd = f3;
        }
        if (f2 > 0.5f) {
            this.aQc = 0.5f;
        } else {
            this.aQc = f2;
        }
        if (this.mListView.getHeight() != 0) {
            IB();
        }
    }

    private void L(int i2, int i3) {
        this.aPF.x = i2 - this.aPQ;
        this.aPF.y = i3 - this.aPR;
        bZ(true);
        int min = Math.min(i3, this.aPH + this.aPZ);
        int max = Math.max(i3, this.aPH - this.aPZ);
        int IH = this.aQb.IH();
        if (min > this.mLastY && min > this.aQf && IH != 1) {
            if (IH != -1) {
                this.aQb.ca(true);
            }
            this.aQb.fx(1);
        } else if (max < this.mLastY && max < this.aQe && IH != 0) {
            if (IH != -1) {
                this.aQb.ca(true);
            }
            this.aQb.fx(0);
        } else if (max >= this.aQe && min <= this.aQf && this.aQb.IG()) {
            this.aQb.ca(true);
        }
    }

    private void IB() {
        int height;
        int paddingTop = this.mListView.getPaddingTop();
        float height2 = (this.mListView.getHeight() - paddingTop) - this.mListView.getPaddingBottom();
        this.aQh = paddingTop + (this.aQc * height2);
        this.aQg = (height2 * (1.0f - this.aQd)) + paddingTop;
        this.aQe = (int) this.aQh;
        this.aQf = (int) this.aQg;
        this.aQi = this.aQh - paddingTop;
        this.aQj = (paddingTop + height) - this.aQg;
    }

    private void IC() {
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
    public void e(int i2, View view2, boolean z) {
        int g2;
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        if (i2 != this.aPP && i2 != this.aPM && i2 != this.aPN) {
            g2 = -2;
        } else {
            g2 = g(i2, view2, z);
        }
        if (g2 != layoutParams.height) {
            layoutParams.height = g2;
            view2.setLayoutParams(layoutParams);
        }
        if (i2 == this.aPM || i2 == this.aPN) {
            if (i2 < this.aPP) {
                ((DragSortItemView) view2).setGravity(80);
            } else if (i2 > this.aPP) {
                ((DragSortItemView) view2).setGravity(48);
            }
        }
        int visibility = view2.getVisibility();
        int i3 = 0;
        if (i2 == this.aPP && this.aPE != null) {
            i3 = 4;
        }
        if (i3 != visibility) {
            view2.setVisibility(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int fw(int i2) {
        View view2;
        if (i2 == this.aPP) {
            return 0;
        }
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        if (childAt != null) {
            return f(i2, childAt, false);
        }
        int i3 = this.aQB.get(i2);
        if (i3 == -1) {
            ListAdapter adapter = this.mListView.getAdapter();
            int itemViewType = adapter.getItemViewType(i2);
            int viewTypeCount = adapter.getViewTypeCount();
            if (viewTypeCount != this.aQa.length) {
                this.aQa = new View[viewTypeCount];
            }
            if (itemViewType >= 0) {
                if (this.aQa[itemViewType] == null) {
                    view2 = adapter.getView(i2, null, this.mListView);
                    this.aQa[itemViewType] = view2;
                } else {
                    view2 = adapter.getView(i2, this.aQa[itemViewType], this.mListView);
                }
            } else {
                view2 = adapter.getView(i2, null, this.mListView);
            }
            int f2 = f(i2, view2, true);
            this.aQB.add(i2, f2);
            return f2;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(int i2, View view2, boolean z) {
        if (i2 == this.aPP) {
            return 0;
        }
        if (i2 >= this.mListView.getHeaderViewsCount() && i2 < this.mListView.getCount() - this.mListView.getFooterViewsCount()) {
            view2 = ((ViewGroup) view2).getChildAt(0);
        }
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        if (layoutParams != null && layoutParams.height > 0) {
            return layoutParams.height;
        }
        int height = view2.getHeight();
        if (height == 0 || z) {
            measureItem(view2);
            return view2.getMeasuredHeight();
        }
        return height;
    }

    private int g(int i2, View view2, boolean z) {
        return M(i2, f(i2, view2, z));
    }

    private int M(int i2, int i3) {
        this.mListView.getDividerHeight();
        boolean z = this.aPO && this.aPM != this.aPN;
        int i4 = this.aPY - this.aPX;
        int i5 = (int) (this.aQw * i4);
        if (i2 == this.aPP) {
            if (this.aPP == this.aPM) {
                if (z) {
                    return i5 + this.aPX;
                }
                return this.aPY;
            } else if (this.aPP == this.aPN) {
                return this.aPY - i5;
            } else {
                return this.aPX;
            }
        } else if (i2 == this.aPM) {
            if (z) {
                return i3 + i5;
            }
            return i3 + i4;
        } else if (i2 == this.aPN) {
            return (i3 + i4) - i5;
        } else {
            return i3;
        }
    }

    private int b(int i2, View view2, int i3, int i4) {
        int i5;
        int i6;
        int fw = fw(i2);
        int height = view2.getHeight();
        int M = M(i2, fw);
        if (i2 != this.aPP) {
            i6 = height - fw;
            i5 = M - fw;
        } else {
            i5 = M;
            i6 = height;
        }
        int i7 = this.aPY;
        if (this.aPP != this.aPM && this.aPP != this.aPN) {
            i7 -= this.aPX;
        }
        if (i2 <= i3) {
            if (i2 > this.aPM) {
                return (i7 - i5) + 0;
            }
        } else if (i2 == i4) {
            if (i2 <= this.aPM) {
                return (i6 - i7) + 0;
            }
            if (i2 == this.aPN) {
                return (height - M) + 0;
            }
            return 0 + i6;
        } else if (i2 <= this.aPM) {
            return 0 - i7;
        } else {
            if (i2 == this.aPN) {
                return 0 - i5;
            }
        }
        return 0;
    }

    private void measureItem(View view2) {
        int makeMeasureSpec;
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new AbsListView.LayoutParams(-1, -2);
            view2.setLayoutParams(layoutParams);
        }
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(this.mWidthMeasureSpec, this.mListView.getListPaddingLeft() + this.mListView.getListPaddingRight(), layoutParams.width);
        if (layoutParams.height > 0) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view2.measure(childMeasureSpec, makeMeasureSpec);
    }

    private void ID() {
        if (this.aPE != null) {
            measureItem(this.aPE);
            this.aPY = this.aPE.getMeasuredHeight();
            this.aPZ = this.aPY / 2;
        }
    }

    protected boolean onDragTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        switch (motionEvent.getAction() & 255) {
            case 1:
                if (this.mDragState == 4) {
                    stopDrag(false);
                }
                IA();
                return true;
            case 2:
                L((int) motionEvent.getX(), (int) motionEvent.getY());
                return true;
            case 3:
                if (this.mDragState == 4) {
                    cancelDrag();
                }
                IA();
                return true;
            default:
                return true;
        }
    }

    public boolean startDrag(int i2, int i3, int i4, int i5) {
        View fy;
        if (!this.aQr || this.aQs == null || (fy = this.aQs.fy(i2)) == null) {
            return false;
        }
        return startDrag(i2, fy, i3, i4, i5);
    }

    public boolean startDrag(int i2, View view2, int i3, int i4, int i5) {
        if (this.mDragState == 0 && this.aQr && this.aPE == null && view2 != null && this.aPW) {
            if (this.mListView.getParent() != null) {
                this.mListView.getParent().requestDisallowInterceptTouchEvent(true);
            }
            int headerViewsCount = this.mListView.getHeaderViewsCount() + i2;
            this.aPM = headerViewsCount;
            this.aPN = headerViewsCount;
            this.aPP = headerViewsCount;
            this.aPL = headerViewsCount;
            this.mDragState = 4;
            this.aQp = 0;
            this.aQp |= i3;
            this.aPE = view2;
            ID();
            this.aPQ = i4;
            this.aPR = i5;
            this.aQo = this.aQn;
            this.aPF.x = this.aQm - this.aPQ;
            this.aPF.y = this.aQn - this.aPR;
            View childAt = this.mListView.getChildAt(this.aPP - this.mListView.getFirstVisiblePosition());
            if (childAt != null) {
                childAt.setVisibility(4);
            }
            if (this.aQy) {
                this.aQz.startTracking();
            }
            switch (this.aQu) {
                case 1:
                    this.aQH.onTouchEvent(this.aQt);
                    break;
                case 2:
                    this.aQH.onInterceptTouchEvent(this.aQt);
                    break;
            }
            this.mListView.requestLayout();
            if (this.aQD != null) {
                this.aQD.start();
                return true;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZ(boolean z) {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition() + (this.mListView.getChildCount() / 2);
        View childAt = this.mListView.getChildAt(this.mListView.getChildCount() / 2);
        if (childAt != null) {
            h(firstVisiblePosition, childAt, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i2, View view2, boolean z) {
        this.mBlockLayoutRequests = true;
        IE();
        int i3 = this.aPM;
        int i4 = this.aPN;
        boolean Iv = Iv();
        if (Iv) {
            IC();
            this.mListView.setSelectionFromTop(i2, (b(i2, view2, i3, i4) + view2.getTop()) - this.mListView.getPaddingTop());
            layoutChildren();
        }
        if (Iv || z) {
            this.mListView.invalidate();
        }
        this.mBlockLayoutRequests = false;
    }

    private void IE() {
        if (this.aQs != null) {
            this.aPG.set(this.aQm, this.aQn);
            this.aQs.b(this.aPE, this.aPF, this.aPG);
        }
        int i2 = this.aPF.x;
        int i3 = this.aPF.y;
        int paddingLeft = this.mListView.getPaddingLeft();
        if ((this.aQp & 1) == 0 && i2 > paddingLeft) {
            this.aPF.x = paddingLeft;
        } else if ((this.aQp & 2) == 0 && i2 < paddingLeft) {
            this.aPF.x = paddingLeft;
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int lastVisiblePosition = this.mListView.getLastVisiblePosition();
        int paddingTop = this.mListView.getPaddingTop();
        if (firstVisiblePosition < headerViewsCount) {
            paddingTop = this.mListView.getChildAt((headerViewsCount - firstVisiblePosition) - 1).getBottom();
        }
        if ((this.aQp & 8) == 0 && firstVisiblePosition <= this.aPP) {
            paddingTop = Math.max(this.mListView.getChildAt(this.aPP - firstVisiblePosition).getTop(), paddingTop);
        }
        int height = this.mListView.getHeight() - this.mListView.getPaddingBottom();
        if (lastVisiblePosition >= (this.mListView.getCount() - footerViewsCount) - 1) {
            height = this.mListView.getChildAt(((this.mListView.getCount() - footerViewsCount) - 1) - firstVisiblePosition).getBottom();
        }
        if ((this.aQp & 4) == 0 && lastVisiblePosition >= this.aPP) {
            height = Math.min(this.mListView.getChildAt(this.aPP - firstVisiblePosition).getBottom(), height);
        }
        if (i3 < paddingTop) {
            this.aPF.y = paddingTop;
        } else if (this.aPY + i3 > height) {
            this.aPF.y = height - this.aPY;
        }
        this.aPH = this.aPF.y + this.aPZ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IF() {
        if (this.aPE != null) {
            this.aPE.setVisibility(8);
            if (this.aQs != null) {
                this.aQs.S(this.aPE);
            }
            this.aPE = null;
            this.mListView.invalidate();
        }
    }

    public void a(h hVar) {
        this.aQs = hVar;
    }

    public void a(b bVar) {
        this.aPT = bVar;
    }

    public void setDragEnabled(boolean z) {
        this.aPW = z;
    }

    public boolean isDragEnabled() {
        return this.aPW;
    }

    public void a(g gVar) {
        this.aPU = gVar;
    }

    public void a(l lVar) {
        this.aPV = lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class i {
        private SparseIntArray aRd;
        private ArrayList<Integer> aRe;
        private int mMaxSize;

        public i(int i) {
            this.aRd = new SparseIntArray(i);
            this.aRe = new ArrayList<>(i);
            this.mMaxSize = i;
        }

        public void add(int i, int i2) {
            int i3 = this.aRd.get(i, -1);
            if (i3 != i2) {
                if (i3 == -1) {
                    if (this.aRd.size() == this.mMaxSize) {
                        this.aRd.delete(this.aRe.remove(0).intValue());
                    }
                } else {
                    this.aRe.remove(Integer.valueOf(i));
                }
                this.aRd.put(i, i2);
                this.aRe.add(Integer.valueOf(i));
            }
        }

        public int get(int i) {
            return this.aRd.get(i, -1);
        }

        public void clear() {
            this.aRd.clear();
            this.aRe.clear();
        }
    }

    /* renamed from: com.baidu.tbadk.widget.dragsort.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0105a extends BaseAdapter {
        private ListAdapter mAdapter;

        public C0105a(ListAdapter listAdapter) {
            this.mAdapter = listAdapter;
            this.mAdapter.registerDataSetObserver(new DataSetObserver() { // from class: com.baidu.tbadk.widget.dragsort.a.a.1
                @Override // android.database.DataSetObserver
                public void onChanged() {
                    C0105a.this.notifyDataSetChanged();
                }

                @Override // android.database.DataSetObserver
                public void onInvalidated() {
                    C0105a.this.notifyDataSetInvalidated();
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
        public View getView(int i, View view2, ViewGroup viewGroup) {
            DragSortItemView dragSortItemView;
            DragSortItemView dragSortItemView2;
            if (view2 == null) {
                View view3 = this.mAdapter.getView(i, null, a.this.mListView);
                if (view3 instanceof Checkable) {
                    dragSortItemView = new DragSortItemViewCheckable(a.this.mListView.getContext());
                } else {
                    dragSortItemView = new DragSortItemView(a.this.mListView.getContext());
                }
                dragSortItemView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
                dragSortItemView.addView(view3);
                dragSortItemView2 = dragSortItemView;
            } else {
                dragSortItemView2 = (DragSortItemView) view2;
                View childAt = dragSortItemView2.getChildAt(0);
                View view4 = this.mAdapter.getView(i, childAt, a.this.mListView);
                if (view4 != childAt) {
                    if (childAt != null) {
                        dragSortItemView2.removeViewAt(0);
                    }
                    dragSortItemView2.addView(view4);
                }
            }
            a.this.e(a.this.mListView.getHeaderViewsCount() + i, dragSortItemView2, true);
            return dragSortItemView2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class m implements Runnable {
        private float aRo;
        private float aRp;
        private float aRq;
        private float aRr;
        private float aRs;
        private float mAlpha;
        private boolean mCanceled;
        protected long mStartTime;

        public m(float f, int i) {
            this.mAlpha = f;
            this.aRo = i;
            float f2 = 1.0f / ((this.mAlpha * 2.0f) * (1.0f - this.mAlpha));
            this.aRs = f2;
            this.aRp = f2;
            this.aRq = this.mAlpha / ((this.mAlpha - 1.0f) * 2.0f);
            this.aRr = 1.0f / (1.0f - this.mAlpha);
        }

        public float P(float f) {
            if (f < this.mAlpha) {
                return this.aRp * f * f;
            }
            if (f < 1.0f - this.mAlpha) {
                return this.aRq + (this.aRr * f);
            }
            return 1.0f - ((this.aRs * (f - 1.0f)) * (f - 1.0f));
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

        public void g(float f, float f2) {
        }

        public void onStop() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.mCanceled) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / this.aRo;
                if (uptimeMillis >= 1.0f) {
                    g(1.0f, 1.0f);
                    onStop();
                    return;
                }
                g(uptimeMillis, P(uptimeMillis));
                a.this.mListView.post(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class f extends m {
        private int aQZ;
        private int aRa;
        private float aRb;
        private float aRc;

        public f(float f, int i) {
            super(f, i);
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.aQZ = a.this.aPL;
            this.aRa = a.this.aPP;
            a.this.mDragState = 2;
            this.aRb = a.this.aPF.y - IJ();
            this.aRc = a.this.aPF.x - a.this.mListView.getPaddingLeft();
        }

        private int IJ() {
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            int dividerHeight = (a.this.aPX + a.this.mListView.getDividerHeight()) / 2;
            View childAt = a.this.mListView.getChildAt(this.aQZ - firstVisiblePosition);
            if (childAt != null) {
                if (this.aQZ == this.aRa) {
                    return childAt.getTop();
                }
                if (this.aQZ >= this.aRa) {
                    return (childAt.getBottom() + dividerHeight) - a.this.aPY;
                }
                return childAt.getTop() - dividerHeight;
            }
            cancel();
            return -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void g(float f, float f2) {
            int IJ = IJ();
            float paddingLeft = a.this.aPF.x - a.this.mListView.getPaddingLeft();
            float f3 = 1.0f - f2;
            if (f3 < Math.abs((a.this.aPF.y - IJ) / this.aRb) || f3 < Math.abs(paddingLeft / this.aRc)) {
                a.this.aPF.y = IJ + ((int) (this.aRb * f3));
                a.this.aPF.x = a.this.mListView.getPaddingLeft() + ((int) (this.aRc * f3));
                a.this.bZ(true);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.Ix();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class k extends m {
        private int aRa;
        private float aRh;
        private float aRi;
        private float aRj;
        private int aRk;
        private int aRl;
        private int aRm;
        private int aRn;

        public k(float f, int i) {
            super(f, i);
            this.aRk = -1;
            this.aRl = -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.aRk = -1;
            this.aRl = -1;
            this.aRm = a.this.aPM;
            this.aRn = a.this.aPN;
            this.aRa = a.this.aPP;
            a.this.mDragState = 1;
            this.aRh = a.this.aPF.x;
            if (a.this.aQF) {
                float width = a.this.mListView.getWidth() * 2.0f;
                if (a.this.aQG == 0.0f) {
                    a.this.aQG = (this.aRh >= 0.0f ? 1 : -1) * width;
                    return;
                }
                float f = width * 2.0f;
                if (a.this.aQG >= 0.0f || a.this.aQG <= (-f)) {
                    if (a.this.aQG > 0.0f && a.this.aQG < f) {
                        a.this.aQG = f;
                        return;
                    }
                    return;
                }
                a.this.aQG = -f;
                return;
            }
            a.this.IF();
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void g(float f, float f2) {
            View childAt;
            float f3 = 1.0f - f2;
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            View childAt2 = a.this.mListView.getChildAt(this.aRm - firstVisiblePosition);
            if (a.this.aQF) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / 1000.0f;
                if (uptimeMillis != 0.0f) {
                    float f4 = a.this.aQG * uptimeMillis;
                    int width = a.this.mListView.getWidth();
                    a.this.aQG = ((a.this.aQG > 0.0f ? 1 : -1) * uptimeMillis * width) + a.this.aQG;
                    this.aRh += f4;
                    a.this.aPF.x = (int) this.aRh;
                    if (this.aRh < width && this.aRh > (-width)) {
                        this.mStartTime = SystemClock.uptimeMillis();
                        a.this.bZ(true);
                        return;
                    }
                } else {
                    return;
                }
            }
            if (childAt2 != null) {
                if (this.aRk == -1) {
                    this.aRk = a.this.f(this.aRm, childAt2, false);
                    this.aRi = childAt2.getHeight() - this.aRk;
                }
                int max = Math.max((int) (this.aRi * f3), 1);
                ViewGroup.LayoutParams layoutParams = childAt2.getLayoutParams();
                layoutParams.height = max + this.aRk;
                childAt2.setLayoutParams(layoutParams);
            }
            if (this.aRn != this.aRm && (childAt = a.this.mListView.getChildAt(this.aRn - firstVisiblePosition)) != null) {
                if (this.aRl == -1) {
                    this.aRl = a.this.f(this.aRn, childAt, false);
                    this.aRj = childAt.getHeight() - this.aRl;
                }
                int max2 = Math.max((int) (this.aRj * f3), 1);
                ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
                layoutParams2.height = max2 + this.aRl;
                childAt.setLayoutParams(layoutParams2);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.Iy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class j extends m {
        final /* synthetic */ a aQL;
        private float aRf;
        private float aRg;

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.aRf = this.aQL.aPR;
            this.aRg = this.aQL.aPZ;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void g(float f, float f2) {
            if (this.aQL.mDragState != 4) {
                cancel();
                return;
            }
            this.aQL.aPR = (int) ((this.aRg * f2) + ((1.0f - f2) * this.aRf));
            this.aQL.aPF.y = this.aQL.aQn - this.aQL.aPR;
            this.aQL.bZ(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e {
        StringBuilder mBuilder = new StringBuilder();
        private int aQW = 0;
        private int aQX = 0;
        private boolean aQY = false;
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
            this.aQX = 0;
            this.aQY = true;
        }

        public void II() {
            if (this.aQY) {
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
                this.mBuilder.append("    <FirstExpPos>").append(a.this.aPM).append("</FirstExpPos>\n");
                this.mBuilder.append("    <FirstExpBlankHeight>").append(a.this.fu(a.this.aPM) - a.this.fw(a.this.aPM)).append("</FirstExpBlankHeight>\n");
                this.mBuilder.append("    <SecondExpPos>").append(a.this.aPN).append("</SecondExpPos>\n");
                this.mBuilder.append("    <SecondExpBlankHeight>").append(a.this.fu(a.this.aPN) - a.this.fw(a.this.aPN)).append("</SecondExpBlankHeight>\n");
                this.mBuilder.append("    <SrcPos>").append(a.this.aPP).append("</SrcPos>\n");
                this.mBuilder.append("    <SrcHeight>").append(a.this.aPY + a.this.mListView.getDividerHeight()).append("</SrcHeight>\n");
                this.mBuilder.append("    <ViewHeight>").append(a.this.mListView.getHeight()).append("</ViewHeight>\n");
                this.mBuilder.append("    <LastY>").append(a.this.mLastY).append("</LastY>\n");
                this.mBuilder.append("    <FloatY>").append(a.this.aPH).append("</FloatY>\n");
                this.mBuilder.append("    <ShuffleEdges>");
                for (int i4 = 0; i4 < childCount; i4++) {
                    this.mBuilder.append(a.this.K(firstVisiblePosition + i4, a.this.mListView.getChildAt(i4).getTop())).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                this.mBuilder.append("</ShuffleEdges>\n");
                this.mBuilder.append("</DSLVState>\n");
                this.aQW++;
                if (this.aQW > 1000) {
                    flush();
                    this.aQW = 0;
                }
            }
        }

        public void flush() {
            if (this.aQY) {
                try {
                    FileWriter fileWriter = new FileWriter(this.mFile, this.aQX != 0);
                    fileWriter.write(this.mBuilder.toString());
                    this.mBuilder.delete(0, this.mBuilder.length());
                    fileWriter.flush();
                    fileWriter.close();
                    this.aQX++;
                } catch (IOException e) {
                }
            }
        }

        public void kh() {
            if (this.aQY) {
                this.mBuilder.append("</DSLVStates>\n");
                flush();
                this.aQY = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements Runnable {
        private boolean aQO;
        private long aQP;
        private long aQQ;
        private float aQR;
        private long aQS;
        private int aQT;
        private float aQU;
        private boolean aQV = false;
        private int dy;

        public boolean IG() {
            return this.aQV;
        }

        public int IH() {
            if (this.aQV) {
                return this.aQT;
            }
            return -1;
        }

        public d() {
        }

        public void fx(int i) {
            if (!this.aQV) {
                this.aQO = false;
                this.aQV = true;
                this.aQS = SystemClock.uptimeMillis();
                this.aQP = this.aQS;
                this.aQT = i;
                a.this.mListView.post(this);
            }
        }

        public void ca(boolean z) {
            if (z) {
                a.this.mListView.removeCallbacks(this);
                this.aQV = false;
                return;
            }
            this.aQO = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.aQO) {
                int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
                int lastVisiblePosition = a.this.mListView.getLastVisiblePosition();
                int count = a.this.mListView.getCount();
                int paddingTop = a.this.mListView.getPaddingTop();
                int height = (a.this.mListView.getHeight() - paddingTop) - a.this.mListView.getPaddingBottom();
                int min = Math.min(a.this.aQn, a.this.aPH + a.this.aPZ);
                int max = Math.max(a.this.aQn, a.this.aPH - a.this.aPZ);
                if (this.aQT == 0) {
                    View childAt = a.this.mListView.getChildAt(0);
                    if (childAt == null) {
                        this.aQV = false;
                        return;
                    } else if (firstVisiblePosition == 0 && childAt.getTop() == paddingTop) {
                        this.aQV = false;
                        return;
                    } else {
                        this.aQU = a.this.aQl.b((a.this.aQh - max) / a.this.aQi, this.aQP);
                    }
                } else {
                    View childAt2 = a.this.mListView.getChildAt(lastVisiblePosition - firstVisiblePosition);
                    if (childAt2 == null) {
                        this.aQV = false;
                        return;
                    } else if (lastVisiblePosition == count - 1 && childAt2.getBottom() <= height + paddingTop) {
                        this.aQV = false;
                        return;
                    } else {
                        this.aQU = -a.this.aQl.b((min - a.this.aQg) / a.this.aQj, this.aQP);
                    }
                }
                this.aQQ = SystemClock.uptimeMillis();
                this.aQR = (float) (this.aQQ - this.aQP);
                this.dy = Math.round(this.aQU * this.aQR);
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
                this.aQP = this.aQQ;
                a.this.mListView.post(this);
                return;
            }
            this.aQV = false;
        }
    }
}
