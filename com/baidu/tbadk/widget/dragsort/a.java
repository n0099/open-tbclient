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
    private View aPF;
    private int aPI;
    private int aPM;
    private int aPN;
    private int aPO;
    private int aPQ;
    private int aPR;
    private int aPS;
    private int aPT;
    private b aPU;
    private g aPV;
    private l aPW;
    private int aPZ;
    private e aQA;
    private k aQD;
    private j aQE;
    private f aQF;
    private boolean aQG;
    private com.baidu.tbadk.widget.dragsort.d aQI;
    private com.baidu.tbadk.widget.dragsort.b aQJ;
    private int aQa;
    private d aQc;
    private int aQf;
    private int aQg;
    private float aQh;
    private float aQi;
    private float aQj;
    private float aQk;
    private int aQn;
    private int aQo;
    private int aQp;
    private MotionEvent aQu;
    private C0105a aQy;
    private int apL;
    private int mLastX;
    private int mLastY;
    private ListView mListView;
    private DataSetObserver mObserver;
    private Point aPG = new Point();
    private Point aPH = new Point();
    private boolean aPJ = false;
    private float aPK = 1.0f;
    private float aPL = 1.0f;
    private boolean aPP = false;
    private boolean aPX = true;
    private int mDragState = 0;
    private int aPY = 1;
    private int mWidthMeasureSpec = 0;
    private View[] aQb = new View[1];
    private float aQd = 0.33333334f;
    private float aQe = 0.33333334f;
    private float aQl = 0.5f;
    private c aQm = new c() { // from class: com.baidu.tbadk.widget.dragsort.a.1
        @Override // com.baidu.tbadk.widget.dragsort.a.c
        public float b(float f2, long j2) {
            return a.this.aQl * f2;
        }
    };
    private int aQq = 0;
    private boolean aQr = false;
    private boolean aQs = false;
    private h aQt = null;
    private int aQv = 0;
    private float aQw = 0.25f;
    private float aQx = 0.0f;
    private boolean aQz = false;
    private boolean mBlockLayoutRequests = false;
    private boolean aQB = false;
    private i aQC = new i(3);
    private float aQH = 0.0f;
    private boolean aQK = false;
    private boolean aQL = false;

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

        View fz(int i);
    }

    /* loaded from: classes.dex */
    public interface l {
        void remove(int i);
    }

    public a(ListView listView, com.baidu.tbadk.widget.dragsort.d dVar) {
        this.aQI = dVar;
        this.mListView = listView;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            this.aQy = new C0105a(listAdapter);
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
            this.aQy = null;
        }
        this.aQI.setAdapter(this.aQy);
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
            if (i2 > this.aPQ) {
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
    public int fv(int i2) {
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        return childAt != null ? childAt.getHeight() : M(i2, fx(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int K(int i2, int i3) {
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        if (i2 <= headerViewsCount || i2 >= this.mListView.getCount() - footerViewsCount) {
            return i3;
        }
        int dividerHeight = this.mListView.getDividerHeight();
        int i4 = this.aPZ - this.aPY;
        int fx = fx(i2);
        int fv = fv(i2);
        if (this.aPO <= this.aPQ) {
            if (i2 == this.aPO && this.aPN != this.aPO) {
                if (i2 == this.aPQ) {
                    i3 = (i3 + fv) - this.aPZ;
                } else {
                    i3 = ((fv - fx) + i3) - i4;
                }
            } else if (i2 > this.aPO && i2 <= this.aPQ) {
                i3 -= i4;
            }
        } else if (i2 > this.aPQ && i2 <= this.aPN) {
            i3 += i4;
        } else if (i2 == this.aPO && this.aPN != this.aPO) {
            i3 += fv - fx;
        }
        if (i2 <= this.aPQ) {
            return (((this.aPZ - dividerHeight) - fx(i2 - 1)) / 2) + i3;
        }
        return (((fx - dividerHeight) - this.aPZ) / 2) + i3;
    }

    private boolean It() {
        int i2;
        int i3;
        int i4;
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int i5 = this.aPN;
        View childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        if (childAt == null) {
            i5 = firstVisiblePosition + (this.mListView.getChildCount() / 2);
            childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        }
        int top = childAt.getTop();
        int height = childAt.getHeight();
        int K = K(i5, top);
        int dividerHeight = this.mListView.getDividerHeight();
        if (this.aPI >= K) {
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
                    i6 = fv(i3 + 1);
                    i2 = K(i3 + 1, i7);
                    if (this.aPI < i2) {
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
                int fv = fv(i3);
                if (i3 == 0) {
                    i2 = (i8 - dividerHeight) - fv;
                    break;
                }
                i8 -= fv + dividerHeight;
                i2 = K(i3, i8);
                if (this.aPI >= i2) {
                    break;
                }
                i4 = i2;
            }
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int i9 = this.aPN;
        int i10 = this.aPO;
        float f2 = this.aQx;
        if (this.aPP) {
            int abs = Math.abs(i2 - i4);
            if (this.aPI >= i2) {
                int i11 = i4;
                i4 = i2;
                i2 = i11;
            }
            int i12 = (int) (abs * this.aQw * 0.5f);
            float f3 = i12;
            int i13 = i4 + i12;
            int i14 = i2 - i12;
            if (this.aPI < i13) {
                this.aPN = i3 - 1;
                this.aPO = i3;
                this.aQx = ((i13 - this.aPI) * 0.5f) / f3;
            } else if (this.aPI < i14) {
                this.aPN = i3;
                this.aPO = i3;
            } else {
                this.aPN = i3;
                this.aPO = i3 + 1;
                this.aQx = (1.0f + ((i2 - this.aPI) / f3)) * 0.5f;
            }
        } else {
            this.aPN = i3;
            this.aPO = i3;
        }
        if (this.aPN < headerViewsCount) {
            this.aPN = headerViewsCount;
            this.aPO = headerViewsCount;
            i3 = headerViewsCount;
        } else if (this.aPO >= this.mListView.getCount() - footerViewsCount) {
            i3 = (this.mListView.getCount() - footerViewsCount) - 1;
            this.aPN = i3;
            this.aPO = i3;
        }
        boolean z = (this.aPN == i9 && this.aPO == i10 && this.aQx == f2) ? false : true;
        if (i3 != this.aPM) {
            if (this.aPU != null) {
                this.aPU.drag(this.aPM - headerViewsCount, i3 - headerViewsCount);
            }
            this.aPM = i3;
            return true;
        }
        return z;
    }

    public void removeItem(int i2) {
        this.aQG = false;
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
            this.aPY = Math.max(1, obtainStyledAttributes.getDimensionPixelSize(d.m.DragSort_collapsed_height, 1));
            this.aQz = obtainStyledAttributes.getBoolean(d.m.DragSort_track_drag_sort, false);
            if (this.aQz) {
                this.aQA = new e();
            }
            this.aPK = obtainStyledAttributes.getFloat(d.m.DragSort_float_alpha, this.aPK);
            this.aPL = this.aPK;
            this.aPX = obtainStyledAttributes.getBoolean(d.m.DragSort_drag_enabled, this.aPX);
            this.aQw = Math.max(0.0f, Math.min(1.0f, 1.0f - obtainStyledAttributes.getFloat(d.m.DragSort_slide_shuffle_speed, 0.75f)));
            this.aPP = this.aQw > 0.0f;
            setDragScrollStart(obtainStyledAttributes.getFloat(d.m.DragSort_drag_scroll_start, this.aQd));
            this.aQl = obtainStyledAttributes.getFloat(d.m.DragSort_max_drag_scroll_speed, this.aQl);
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
                this.aQt = bVar;
                a(bVar);
            }
            obtainStyledAttributes.recycle();
            i2 = i5;
            i3 = i4;
        }
        this.aQc = new d();
        if (i3 > 0) {
            this.aQD = new k(0.5f, i3);
        }
        if (i2 > 0) {
            this.aQF = new f(0.5f, i2);
        }
        this.aQu = MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
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
        this.aQJ = bVar;
        this.mListView.setOnTouchListener(bVar);
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void dispatchDraw(Canvas canvas) {
        float f2;
        this.aQI.dispatchDraw(canvas);
        if (this.mDragState != 0) {
            if (this.aPN != this.aPQ) {
                b(this.aPN, canvas);
            }
            if (this.aPO != this.aPN && this.aPO != this.aPQ) {
                b(this.aPO, canvas);
            }
        }
        if (this.aPF != null) {
            int width = this.aPF.getWidth();
            int height = this.aPF.getHeight();
            int i2 = this.aPG.x;
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
            int i3 = (int) (f2 * 255.0f * this.aPL);
            canvas.save();
            canvas.translate(this.aPG.x, this.aPG.y);
            canvas.clipRect(0, 0, width, height);
            canvas.saveLayerAlpha(0.0f, 0.0f, width, height, i3, 31);
            this.aPF.draw(canvas);
            canvas.restore();
            canvas.restore();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onDraw(Canvas canvas) {
        this.aQI.onDraw(canvas);
        if (this.aQz) {
            this.aQA.IG();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.aQB) {
            this.aQB = false;
            return false;
        } else if (!this.aPX) {
            return this.aQI.onTouchEvent(motionEvent);
        } else {
            boolean z2 = this.aQr;
            this.aQr = false;
            if (!z2) {
                s(motionEvent);
            }
            if (this.mDragState == 4) {
                onDragTouchEvent(motionEvent);
                return true;
            }
            if (this.mDragState == 0 && this.aQI.onTouchEvent(motionEvent)) {
                z = true;
            }
            switch (motionEvent.getAction() & 255) {
                case 1:
                case 3:
                    Iy();
                    return z;
                case 2:
                default:
                    if (z) {
                        this.aQv = 1;
                        return z;
                    }
                    return z;
            }
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (!this.aPX) {
            return this.aQI.onInterceptTouchEvent(motionEvent);
        }
        if (this.aQJ != null) {
            this.aQJ.II().onTouchEvent(motionEvent);
        }
        s(motionEvent);
        this.aQr = true;
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            if (this.mDragState != 0) {
                this.aQB = true;
                return true;
            }
            this.aQs = true;
        }
        if (this.aPF == null) {
            if (this.aQI.onInterceptTouchEvent(motionEvent)) {
                this.aQK = true;
                z = true;
            } else {
                z = false;
            }
            switch (action) {
                case 1:
                case 3:
                    Iy();
                    break;
                case 2:
                default:
                    if (z) {
                        this.aQv = 1;
                        break;
                    } else {
                        this.aQv = 2;
                        break;
                    }
            }
        } else {
            z = true;
        }
        if (action == 1 || action == 3) {
            this.aQs = false;
        }
        return z;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        this.aQI.onSizeChanged(i2, i3, i4, i5);
        Iz();
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void requestLayout() {
        if (!this.mBlockLayoutRequests) {
            this.aQI.requestLayout();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onMeasure(int i2, int i3) {
        this.aQI.onMeasure(i2, i3);
        if (this.aPF != null) {
            if (this.aPF.isLayoutRequested()) {
                IB();
            }
            this.aPJ = true;
        }
        this.mWidthMeasureSpec = i2;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void layoutChildren() {
        this.aQI.layoutChildren();
        if (this.aPF != null) {
            if (this.aPF.isLayoutRequested() && !this.aPJ) {
                IB();
            }
            this.aPF.layout(0, 0, this.aPF.getMeasuredWidth(), this.aPF.getMeasuredHeight());
            this.aPJ = false;
        }
    }

    public void removeItem(int i2, float f2) {
        if (this.mDragState == 0 || this.mDragState == 4) {
            if (this.mDragState == 0) {
                this.aPQ = this.mListView.getHeaderViewsCount() + i2;
                this.aPN = this.aPQ;
                this.aPO = this.aPQ;
                this.aPM = this.aPQ;
                View childAt = this.mListView.getChildAt(this.aPQ - this.mListView.getFirstVisiblePosition());
                if (childAt != null) {
                    childAt.setVisibility(4);
                }
            }
            this.mDragState = 1;
            this.aQH = f2;
            if (this.aQs) {
                switch (this.aQv) {
                    case 1:
                        this.aQI.onTouchEvent(this.aQu);
                        break;
                    case 2:
                        this.aQI.onInterceptTouchEvent(this.aQu);
                        break;
                }
            }
            if (this.aQD != null) {
                this.aQD.start();
            } else {
                fw(i2);
            }
        }
    }

    public void cancelDrag() {
        if (this.mDragState == 4) {
            this.aQc.ca(true);
            ID();
            Iu();
            IA();
            if (this.aQs) {
                this.mDragState = 3;
            } else {
                this.mDragState = 0;
            }
        }
    }

    private void Iu() {
        this.aPQ = -1;
        this.aPN = -1;
        this.aPO = -1;
        this.aPM = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Iv() {
        this.mDragState = 2;
        if (this.aPV != null && this.aPM >= 0 && this.aPM < this.mListView.getCount()) {
            int headerViewsCount = this.mListView.getHeaderViewsCount();
            this.aPV.drop(this.aPQ - headerViewsCount, this.aPM - headerViewsCount);
        }
        ID();
        Ix();
        Iu();
        IA();
        if (this.aQs) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Iw() {
        fw(this.aPQ - this.mListView.getHeaderViewsCount());
    }

    private void fw(int i2) {
        this.mDragState = 1;
        if (this.aPW != null) {
            this.aPW.remove(i2);
        }
        ID();
        Ix();
        Iu();
        if (this.aQs) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    private void Ix() {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        if (this.aPQ < firstVisiblePosition) {
            View childAt = this.mListView.getChildAt(0);
            this.mListView.setSelectionFromTop(firstVisiblePosition - 1, (childAt != null ? childAt.getTop() : 0) - this.mListView.getPaddingTop());
        }
    }

    public boolean stopDrag(boolean z) {
        this.aQG = false;
        return stopDrag(z, 0.0f);
    }

    public boolean stopDragWithVelocity(boolean z, float f2) {
        this.aQG = true;
        return stopDrag(z, f2);
    }

    public boolean stopDrag(boolean z, float f2) {
        if (this.aPF != null) {
            this.aQc.ca(true);
            if (z) {
                removeItem(this.aPQ - this.mListView.getHeaderViewsCount(), f2);
            } else if (this.aQF != null) {
                this.aQF.start();
            } else {
                Iv();
            }
            if (this.aQz) {
                this.aQA.kg();
                return true;
            }
            return true;
        }
        return false;
    }

    private void Iy() {
        this.aQv = 0;
        this.aQs = false;
        if (this.mDragState == 3) {
            this.mDragState = 0;
        }
        this.aPL = this.aPK;
        this.aQK = false;
        this.aQC.clear();
    }

    private void s(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            this.mLastX = this.aQn;
            this.mLastY = this.aQo;
        }
        this.aQn = (int) motionEvent.getX();
        this.aQo = (int) motionEvent.getY();
        if (action == 0) {
            this.mLastX = this.aQn;
            this.mLastY = this.aQo;
        }
        this.aPT = ((int) motionEvent.getRawX()) - this.aQn;
        this.apL = ((int) motionEvent.getRawY()) - this.aQo;
    }

    public boolean listViewIntercepted() {
        return this.aQK;
    }

    public void setDragScrollStart(float f2) {
        setDragScrollStarts(f2, f2);
    }

    public void setDragScrollStarts(float f2, float f3) {
        if (f3 > 0.5f) {
            this.aQe = 0.5f;
        } else {
            this.aQe = f3;
        }
        if (f2 > 0.5f) {
            this.aQd = 0.5f;
        } else {
            this.aQd = f2;
        }
        if (this.mListView.getHeight() != 0) {
            Iz();
        }
    }

    private void L(int i2, int i3) {
        this.aPG.x = i2 - this.aPR;
        this.aPG.y = i3 - this.aPS;
        bZ(true);
        int min = Math.min(i3, this.aPI + this.aQa);
        int max = Math.max(i3, this.aPI - this.aQa);
        int IF = this.aQc.IF();
        if (min > this.mLastY && min > this.aQg && IF != 1) {
            if (IF != -1) {
                this.aQc.ca(true);
            }
            this.aQc.fy(1);
        } else if (max < this.mLastY && max < this.aQf && IF != 0) {
            if (IF != -1) {
                this.aQc.ca(true);
            }
            this.aQc.fy(0);
        } else if (max >= this.aQf && min <= this.aQg && this.aQc.IE()) {
            this.aQc.ca(true);
        }
    }

    private void Iz() {
        int height;
        int paddingTop = this.mListView.getPaddingTop();
        float height2 = (this.mListView.getHeight() - paddingTop) - this.mListView.getPaddingBottom();
        this.aQi = paddingTop + (this.aQd * height2);
        this.aQh = (height2 * (1.0f - this.aQe)) + paddingTop;
        this.aQf = (int) this.aQi;
        this.aQg = (int) this.aQh;
        this.aQj = this.aQi - paddingTop;
        this.aQk = (paddingTop + height) - this.aQh;
    }

    private void IA() {
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
        if (i2 != this.aPQ && i2 != this.aPN && i2 != this.aPO) {
            g2 = -2;
        } else {
            g2 = g(i2, view2, z);
        }
        if (g2 != layoutParams.height) {
            layoutParams.height = g2;
            view2.setLayoutParams(layoutParams);
        }
        if (i2 == this.aPN || i2 == this.aPO) {
            if (i2 < this.aPQ) {
                ((DragSortItemView) view2).setGravity(80);
            } else if (i2 > this.aPQ) {
                ((DragSortItemView) view2).setGravity(48);
            }
        }
        int visibility = view2.getVisibility();
        int i3 = 0;
        if (i2 == this.aPQ && this.aPF != null) {
            i3 = 4;
        }
        if (i3 != visibility) {
            view2.setVisibility(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int fx(int i2) {
        View view2;
        if (i2 == this.aPQ) {
            return 0;
        }
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        if (childAt != null) {
            return f(i2, childAt, false);
        }
        int i3 = this.aQC.get(i2);
        if (i3 == -1) {
            ListAdapter adapter = this.mListView.getAdapter();
            int itemViewType = adapter.getItemViewType(i2);
            int viewTypeCount = adapter.getViewTypeCount();
            if (viewTypeCount != this.aQb.length) {
                this.aQb = new View[viewTypeCount];
            }
            if (itemViewType >= 0) {
                if (this.aQb[itemViewType] == null) {
                    view2 = adapter.getView(i2, null, this.mListView);
                    this.aQb[itemViewType] = view2;
                } else {
                    view2 = adapter.getView(i2, this.aQb[itemViewType], this.mListView);
                }
            } else {
                view2 = adapter.getView(i2, null, this.mListView);
            }
            int f2 = f(i2, view2, true);
            this.aQC.add(i2, f2);
            return f2;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(int i2, View view2, boolean z) {
        if (i2 == this.aPQ) {
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
        boolean z = this.aPP && this.aPN != this.aPO;
        int i4 = this.aPZ - this.aPY;
        int i5 = (int) (this.aQx * i4);
        if (i2 == this.aPQ) {
            if (this.aPQ == this.aPN) {
                if (z) {
                    return i5 + this.aPY;
                }
                return this.aPZ;
            } else if (this.aPQ == this.aPO) {
                return this.aPZ - i5;
            } else {
                return this.aPY;
            }
        } else if (i2 == this.aPN) {
            if (z) {
                return i3 + i5;
            }
            return i3 + i4;
        } else if (i2 == this.aPO) {
            return (i3 + i4) - i5;
        } else {
            return i3;
        }
    }

    private int b(int i2, View view2, int i3, int i4) {
        int i5;
        int i6;
        int fx = fx(i2);
        int height = view2.getHeight();
        int M = M(i2, fx);
        if (i2 != this.aPQ) {
            i6 = height - fx;
            i5 = M - fx;
        } else {
            i5 = M;
            i6 = height;
        }
        int i7 = this.aPZ;
        if (this.aPQ != this.aPN && this.aPQ != this.aPO) {
            i7 -= this.aPY;
        }
        if (i2 <= i3) {
            if (i2 > this.aPN) {
                return (i7 - i5) + 0;
            }
        } else if (i2 == i4) {
            if (i2 <= this.aPN) {
                return (i6 - i7) + 0;
            }
            if (i2 == this.aPO) {
                return (height - M) + 0;
            }
            return 0 + i6;
        } else if (i2 <= this.aPN) {
            return 0 - i7;
        } else {
            if (i2 == this.aPO) {
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

    private void IB() {
        if (this.aPF != null) {
            measureItem(this.aPF);
            this.aPZ = this.aPF.getMeasuredHeight();
            this.aQa = this.aPZ / 2;
        }
    }

    protected boolean onDragTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        switch (motionEvent.getAction() & 255) {
            case 1:
                if (this.mDragState == 4) {
                    stopDrag(false);
                }
                Iy();
                return true;
            case 2:
                L((int) motionEvent.getX(), (int) motionEvent.getY());
                return true;
            case 3:
                if (this.mDragState == 4) {
                    cancelDrag();
                }
                Iy();
                return true;
            default:
                return true;
        }
    }

    public boolean startDrag(int i2, int i3, int i4, int i5) {
        View fz;
        if (!this.aQs || this.aQt == null || (fz = this.aQt.fz(i2)) == null) {
            return false;
        }
        return startDrag(i2, fz, i3, i4, i5);
    }

    public boolean startDrag(int i2, View view2, int i3, int i4, int i5) {
        if (this.mDragState == 0 && this.aQs && this.aPF == null && view2 != null && this.aPX) {
            if (this.mListView.getParent() != null) {
                this.mListView.getParent().requestDisallowInterceptTouchEvent(true);
            }
            int headerViewsCount = this.mListView.getHeaderViewsCount() + i2;
            this.aPN = headerViewsCount;
            this.aPO = headerViewsCount;
            this.aPQ = headerViewsCount;
            this.aPM = headerViewsCount;
            this.mDragState = 4;
            this.aQq = 0;
            this.aQq |= i3;
            this.aPF = view2;
            IB();
            this.aPR = i4;
            this.aPS = i5;
            this.aQp = this.aQo;
            this.aPG.x = this.aQn - this.aPR;
            this.aPG.y = this.aQo - this.aPS;
            View childAt = this.mListView.getChildAt(this.aPQ - this.mListView.getFirstVisiblePosition());
            if (childAt != null) {
                childAt.setVisibility(4);
            }
            if (this.aQz) {
                this.aQA.startTracking();
            }
            switch (this.aQv) {
                case 1:
                    this.aQI.onTouchEvent(this.aQu);
                    break;
                case 2:
                    this.aQI.onInterceptTouchEvent(this.aQu);
                    break;
            }
            this.mListView.requestLayout();
            if (this.aQE != null) {
                this.aQE.start();
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
        IC();
        int i3 = this.aPN;
        int i4 = this.aPO;
        boolean It = It();
        if (It) {
            IA();
            this.mListView.setSelectionFromTop(i2, (b(i2, view2, i3, i4) + view2.getTop()) - this.mListView.getPaddingTop());
            layoutChildren();
        }
        if (It || z) {
            this.mListView.invalidate();
        }
        this.mBlockLayoutRequests = false;
    }

    private void IC() {
        if (this.aQt != null) {
            this.aPH.set(this.aQn, this.aQo);
            this.aQt.b(this.aPF, this.aPG, this.aPH);
        }
        int i2 = this.aPG.x;
        int i3 = this.aPG.y;
        int paddingLeft = this.mListView.getPaddingLeft();
        if ((this.aQq & 1) == 0 && i2 > paddingLeft) {
            this.aPG.x = paddingLeft;
        } else if ((this.aQq & 2) == 0 && i2 < paddingLeft) {
            this.aPG.x = paddingLeft;
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int lastVisiblePosition = this.mListView.getLastVisiblePosition();
        int paddingTop = this.mListView.getPaddingTop();
        if (firstVisiblePosition < headerViewsCount) {
            paddingTop = this.mListView.getChildAt((headerViewsCount - firstVisiblePosition) - 1).getBottom();
        }
        if ((this.aQq & 8) == 0 && firstVisiblePosition <= this.aPQ) {
            paddingTop = Math.max(this.mListView.getChildAt(this.aPQ - firstVisiblePosition).getTop(), paddingTop);
        }
        int height = this.mListView.getHeight() - this.mListView.getPaddingBottom();
        if (lastVisiblePosition >= (this.mListView.getCount() - footerViewsCount) - 1) {
            height = this.mListView.getChildAt(((this.mListView.getCount() - footerViewsCount) - 1) - firstVisiblePosition).getBottom();
        }
        if ((this.aQq & 4) == 0 && lastVisiblePosition >= this.aPQ) {
            height = Math.min(this.mListView.getChildAt(this.aPQ - firstVisiblePosition).getBottom(), height);
        }
        if (i3 < paddingTop) {
            this.aPG.y = paddingTop;
        } else if (this.aPZ + i3 > height) {
            this.aPG.y = height - this.aPZ;
        }
        this.aPI = this.aPG.y + this.aQa;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ID() {
        if (this.aPF != null) {
            this.aPF.setVisibility(8);
            if (this.aQt != null) {
                this.aQt.S(this.aPF);
            }
            this.aPF = null;
            this.mListView.invalidate();
        }
    }

    public void a(h hVar) {
        this.aQt = hVar;
    }

    public void a(b bVar) {
        this.aPU = bVar;
    }

    public void setDragEnabled(boolean z) {
        this.aPX = z;
    }

    public boolean isDragEnabled() {
        return this.aPX;
    }

    public void a(g gVar) {
        this.aPV = gVar;
    }

    public void a(l lVar) {
        this.aPW = lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class i {
        private SparseIntArray aRe;
        private ArrayList<Integer> aRf;
        private int mMaxSize;

        public i(int i) {
            this.aRe = new SparseIntArray(i);
            this.aRf = new ArrayList<>(i);
            this.mMaxSize = i;
        }

        public void add(int i, int i2) {
            int i3 = this.aRe.get(i, -1);
            if (i3 != i2) {
                if (i3 == -1) {
                    if (this.aRe.size() == this.mMaxSize) {
                        this.aRe.delete(this.aRf.remove(0).intValue());
                    }
                } else {
                    this.aRf.remove(Integer.valueOf(i));
                }
                this.aRe.put(i, i2);
                this.aRf.add(Integer.valueOf(i));
            }
        }

        public int get(int i) {
            return this.aRe.get(i, -1);
        }

        public void clear() {
            this.aRe.clear();
            this.aRf.clear();
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
        private float aRp;
        private float aRq;
        private float aRr;
        private float aRs;
        private float aRt;
        private float mAlpha;
        private boolean mCanceled;
        protected long mStartTime;

        public m(float f, int i) {
            this.mAlpha = f;
            this.aRp = i;
            float f2 = 1.0f / ((this.mAlpha * 2.0f) * (1.0f - this.mAlpha));
            this.aRt = f2;
            this.aRq = f2;
            this.aRr = this.mAlpha / ((this.mAlpha - 1.0f) * 2.0f);
            this.aRs = 1.0f / (1.0f - this.mAlpha);
        }

        public float P(float f) {
            if (f < this.mAlpha) {
                return this.aRq * f * f;
            }
            if (f < 1.0f - this.mAlpha) {
                return this.aRr + (this.aRs * f);
            }
            return 1.0f - ((this.aRt * (f - 1.0f)) * (f - 1.0f));
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
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / this.aRp;
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
        private int aRa;
        private int aRb;
        private float aRc;
        private float aRd;

        public f(float f, int i) {
            super(f, i);
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.aRa = a.this.aPM;
            this.aRb = a.this.aPQ;
            a.this.mDragState = 2;
            this.aRc = a.this.aPG.y - IH();
            this.aRd = a.this.aPG.x - a.this.mListView.getPaddingLeft();
        }

        private int IH() {
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            int dividerHeight = (a.this.aPY + a.this.mListView.getDividerHeight()) / 2;
            View childAt = a.this.mListView.getChildAt(this.aRa - firstVisiblePosition);
            if (childAt != null) {
                if (this.aRa == this.aRb) {
                    return childAt.getTop();
                }
                if (this.aRa >= this.aRb) {
                    return (childAt.getBottom() + dividerHeight) - a.this.aPZ;
                }
                return childAt.getTop() - dividerHeight;
            }
            cancel();
            return -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void g(float f, float f2) {
            int IH = IH();
            float paddingLeft = a.this.aPG.x - a.this.mListView.getPaddingLeft();
            float f3 = 1.0f - f2;
            if (f3 < Math.abs((a.this.aPG.y - IH) / this.aRc) || f3 < Math.abs(paddingLeft / this.aRd)) {
                a.this.aPG.y = IH + ((int) (this.aRc * f3));
                a.this.aPG.x = a.this.mListView.getPaddingLeft() + ((int) (this.aRd * f3));
                a.this.bZ(true);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.Iv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class k extends m {
        private int aRb;
        private float aRi;
        private float aRj;
        private float aRk;
        private int aRl;
        private int aRm;
        private int aRn;
        private int aRo;

        public k(float f, int i) {
            super(f, i);
            this.aRl = -1;
            this.aRm = -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.aRl = -1;
            this.aRm = -1;
            this.aRn = a.this.aPN;
            this.aRo = a.this.aPO;
            this.aRb = a.this.aPQ;
            a.this.mDragState = 1;
            this.aRi = a.this.aPG.x;
            if (a.this.aQG) {
                float width = a.this.mListView.getWidth() * 2.0f;
                if (a.this.aQH == 0.0f) {
                    a.this.aQH = (this.aRi >= 0.0f ? 1 : -1) * width;
                    return;
                }
                float f = width * 2.0f;
                if (a.this.aQH >= 0.0f || a.this.aQH <= (-f)) {
                    if (a.this.aQH > 0.0f && a.this.aQH < f) {
                        a.this.aQH = f;
                        return;
                    }
                    return;
                }
                a.this.aQH = -f;
                return;
            }
            a.this.ID();
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void g(float f, float f2) {
            View childAt;
            float f3 = 1.0f - f2;
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            View childAt2 = a.this.mListView.getChildAt(this.aRn - firstVisiblePosition);
            if (a.this.aQG) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / 1000.0f;
                if (uptimeMillis != 0.0f) {
                    float f4 = a.this.aQH * uptimeMillis;
                    int width = a.this.mListView.getWidth();
                    a.this.aQH = ((a.this.aQH > 0.0f ? 1 : -1) * uptimeMillis * width) + a.this.aQH;
                    this.aRi += f4;
                    a.this.aPG.x = (int) this.aRi;
                    if (this.aRi < width && this.aRi > (-width)) {
                        this.mStartTime = SystemClock.uptimeMillis();
                        a.this.bZ(true);
                        return;
                    }
                } else {
                    return;
                }
            }
            if (childAt2 != null) {
                if (this.aRl == -1) {
                    this.aRl = a.this.f(this.aRn, childAt2, false);
                    this.aRj = childAt2.getHeight() - this.aRl;
                }
                int max = Math.max((int) (this.aRj * f3), 1);
                ViewGroup.LayoutParams layoutParams = childAt2.getLayoutParams();
                layoutParams.height = max + this.aRl;
                childAt2.setLayoutParams(layoutParams);
            }
            if (this.aRo != this.aRn && (childAt = a.this.mListView.getChildAt(this.aRo - firstVisiblePosition)) != null) {
                if (this.aRm == -1) {
                    this.aRm = a.this.f(this.aRo, childAt, false);
                    this.aRk = childAt.getHeight() - this.aRm;
                }
                int max2 = Math.max((int) (this.aRk * f3), 1);
                ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
                layoutParams2.height = max2 + this.aRm;
                childAt.setLayoutParams(layoutParams2);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.Iw();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class j extends m {
        final /* synthetic */ a aQM;
        private float aRg;
        private float aRh;

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.aRg = this.aQM.aPS;
            this.aRh = this.aQM.aQa;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void g(float f, float f2) {
            if (this.aQM.mDragState != 4) {
                cancel();
                return;
            }
            this.aQM.aPS = (int) ((this.aRh * f2) + ((1.0f - f2) * this.aRg));
            this.aQM.aPG.y = this.aQM.aQo - this.aQM.aPS;
            this.aQM.bZ(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e {
        StringBuilder mBuilder = new StringBuilder();
        private int aQX = 0;
        private int aQY = 0;
        private boolean aQZ = false;
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
            this.aQY = 0;
            this.aQZ = true;
        }

        public void IG() {
            if (this.aQZ) {
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
                this.mBuilder.append("    <FirstExpPos>").append(a.this.aPN).append("</FirstExpPos>\n");
                this.mBuilder.append("    <FirstExpBlankHeight>").append(a.this.fv(a.this.aPN) - a.this.fx(a.this.aPN)).append("</FirstExpBlankHeight>\n");
                this.mBuilder.append("    <SecondExpPos>").append(a.this.aPO).append("</SecondExpPos>\n");
                this.mBuilder.append("    <SecondExpBlankHeight>").append(a.this.fv(a.this.aPO) - a.this.fx(a.this.aPO)).append("</SecondExpBlankHeight>\n");
                this.mBuilder.append("    <SrcPos>").append(a.this.aPQ).append("</SrcPos>\n");
                this.mBuilder.append("    <SrcHeight>").append(a.this.aPZ + a.this.mListView.getDividerHeight()).append("</SrcHeight>\n");
                this.mBuilder.append("    <ViewHeight>").append(a.this.mListView.getHeight()).append("</ViewHeight>\n");
                this.mBuilder.append("    <LastY>").append(a.this.mLastY).append("</LastY>\n");
                this.mBuilder.append("    <FloatY>").append(a.this.aPI).append("</FloatY>\n");
                this.mBuilder.append("    <ShuffleEdges>");
                for (int i4 = 0; i4 < childCount; i4++) {
                    this.mBuilder.append(a.this.K(firstVisiblePosition + i4, a.this.mListView.getChildAt(i4).getTop())).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                this.mBuilder.append("</ShuffleEdges>\n");
                this.mBuilder.append("</DSLVState>\n");
                this.aQX++;
                if (this.aQX > 1000) {
                    flush();
                    this.aQX = 0;
                }
            }
        }

        public void flush() {
            if (this.aQZ) {
                try {
                    FileWriter fileWriter = new FileWriter(this.mFile, this.aQY != 0);
                    fileWriter.write(this.mBuilder.toString());
                    this.mBuilder.delete(0, this.mBuilder.length());
                    fileWriter.flush();
                    fileWriter.close();
                    this.aQY++;
                } catch (IOException e) {
                }
            }
        }

        public void kg() {
            if (this.aQZ) {
                this.mBuilder.append("</DSLVStates>\n");
                flush();
                this.aQZ = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements Runnable {
        private boolean aQP;
        private long aQQ;
        private long aQR;
        private float aQS;
        private long aQT;
        private int aQU;
        private float aQV;
        private boolean aQW = false;
        private int dy;

        public boolean IE() {
            return this.aQW;
        }

        public int IF() {
            if (this.aQW) {
                return this.aQU;
            }
            return -1;
        }

        public d() {
        }

        public void fy(int i) {
            if (!this.aQW) {
                this.aQP = false;
                this.aQW = true;
                this.aQT = SystemClock.uptimeMillis();
                this.aQQ = this.aQT;
                this.aQU = i;
                a.this.mListView.post(this);
            }
        }

        public void ca(boolean z) {
            if (z) {
                a.this.mListView.removeCallbacks(this);
                this.aQW = false;
                return;
            }
            this.aQP = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.aQP) {
                int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
                int lastVisiblePosition = a.this.mListView.getLastVisiblePosition();
                int count = a.this.mListView.getCount();
                int paddingTop = a.this.mListView.getPaddingTop();
                int height = (a.this.mListView.getHeight() - paddingTop) - a.this.mListView.getPaddingBottom();
                int min = Math.min(a.this.aQo, a.this.aPI + a.this.aQa);
                int max = Math.max(a.this.aQo, a.this.aPI - a.this.aQa);
                if (this.aQU == 0) {
                    View childAt = a.this.mListView.getChildAt(0);
                    if (childAt == null) {
                        this.aQW = false;
                        return;
                    } else if (firstVisiblePosition == 0 && childAt.getTop() == paddingTop) {
                        this.aQW = false;
                        return;
                    } else {
                        this.aQV = a.this.aQm.b((a.this.aQi - max) / a.this.aQj, this.aQQ);
                    }
                } else {
                    View childAt2 = a.this.mListView.getChildAt(lastVisiblePosition - firstVisiblePosition);
                    if (childAt2 == null) {
                        this.aQW = false;
                        return;
                    } else if (lastVisiblePosition == count - 1 && childAt2.getBottom() <= height + paddingTop) {
                        this.aQW = false;
                        return;
                    } else {
                        this.aQV = -a.this.aQm.b((min - a.this.aQh) / a.this.aQk, this.aQQ);
                    }
                }
                this.aQR = SystemClock.uptimeMillis();
                this.aQS = (float) (this.aQR - this.aQQ);
                this.dy = Math.round(this.aQV * this.aQS);
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
                this.aQQ = this.aQR;
                a.this.mListView.post(this);
                return;
            }
            this.aQW = false;
        }
    }
}
