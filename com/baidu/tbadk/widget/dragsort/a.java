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
import com.baidu.tieba.e;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a implements com.baidu.tbadk.widget.dragsort.c {
    private int aBq;
    private View bbU;
    private int bbX;
    private int bcC;
    private int bcD;
    private int bcE;
    private MotionEvent bcJ;
    private C0119a bcN;
    private e bcP;
    private k bcS;
    private j bcT;
    private f bcU;
    private boolean bcV;
    private com.baidu.tbadk.widget.dragsort.d bcX;
    private com.baidu.tbadk.widget.dragsort.b bcY;
    private int bcb;
    private int bcc;
    private int bcd;
    private int bcf;
    private int bcg;
    private int bch;
    private int bci;
    private b bcj;
    private g bck;
    private l bcl;
    private int bco;
    private int bcp;
    private d bcr;
    private int bcu;
    private int bcv;
    private float bcw;
    private float bcx;
    private float bcy;
    private float bcz;
    private int mLastX;
    private int mLastY;
    private ListView mListView;
    private DataSetObserver mObserver;
    private Point bbV = new Point();
    private Point bbW = new Point();
    private boolean bbY = false;
    private float bbZ = 1.0f;
    private float bca = 1.0f;
    private boolean bce = false;
    private boolean bcm = true;
    private int mDragState = 0;
    private int bcn = 1;
    private int mWidthMeasureSpec = 0;
    private View[] bcq = new View[1];
    private float bcs = 0.33333334f;
    private float bct = 0.33333334f;
    private float bcA = 0.5f;
    private c bcB = new c() { // from class: com.baidu.tbadk.widget.dragsort.a.1
        @Override // com.baidu.tbadk.widget.dragsort.a.c
        public float b(float f2, long j2) {
            return a.this.bcA * f2;
        }
    };
    private int bcF = 0;
    private boolean bcG = false;
    private boolean bcH = false;
    private h bcI = null;
    private int bcK = 0;
    private float bcL = 0.25f;
    private float bcM = 0.0f;
    private boolean bcO = false;
    private boolean mBlockLayoutRequests = false;
    private boolean bcQ = false;
    private i bcR = new i(3);
    private float bcW = 0.0f;
    private boolean bcZ = false;
    private boolean bda = false;

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
        void ag(View view);

        void b(View view, Point point, Point point2);

        View fN(int i);
    }

    /* loaded from: classes.dex */
    public interface l {
        void remove(int i);
    }

    public a(ListView listView, com.baidu.tbadk.widget.dragsort.d dVar) {
        this.bcX = dVar;
        this.mListView = listView;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            this.bcN = new C0119a(listAdapter);
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
            this.bcN = null;
        }
        this.bcX.setAdapter(this.bcN);
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
            if (i2 > this.bcf) {
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
    public int fJ(int i2) {
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        return childAt != null ? childAt.getHeight() : Q(i2, fL(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int O(int i2, int i3) {
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        if (i2 <= headerViewsCount || i2 >= this.mListView.getCount() - footerViewsCount) {
            return i3;
        }
        int dividerHeight = this.mListView.getDividerHeight();
        int i4 = this.bco - this.bcn;
        int fL = fL(i2);
        int fJ = fJ(i2);
        if (this.bcd <= this.bcf) {
            if (i2 == this.bcd && this.bcc != this.bcd) {
                if (i2 == this.bcf) {
                    i3 = (i3 + fJ) - this.bco;
                } else {
                    i3 = ((fJ - fL) + i3) - i4;
                }
            } else if (i2 > this.bcd && i2 <= this.bcf) {
                i3 -= i4;
            }
        } else if (i2 > this.bcf && i2 <= this.bcc) {
            i3 += i4;
        } else if (i2 == this.bcd && this.bcc != this.bcd) {
            i3 += fJ - fL;
        }
        if (i2 <= this.bcf) {
            return (((this.bco - dividerHeight) - fL(i2 - 1)) / 2) + i3;
        }
        return (((fL - dividerHeight) - this.bco) / 2) + i3;
    }

    private boolean Nz() {
        int i2;
        int i3;
        int i4;
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int i5 = this.bcc;
        View childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        if (childAt == null) {
            i5 = firstVisiblePosition + (this.mListView.getChildCount() / 2);
            childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        }
        int top = childAt.getTop();
        int height = childAt.getHeight();
        int O = O(i5, top);
        int dividerHeight = this.mListView.getDividerHeight();
        if (this.bbX >= O) {
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
                    i6 = fJ(i3 + 1);
                    i2 = O(i3 + 1, i7);
                    if (this.bbX < i2) {
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
                int fJ = fJ(i3);
                if (i3 == 0) {
                    i2 = (i8 - dividerHeight) - fJ;
                    break;
                }
                i8 -= fJ + dividerHeight;
                i2 = O(i3, i8);
                if (this.bbX >= i2) {
                    break;
                }
                i4 = i2;
            }
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int i9 = this.bcc;
        int i10 = this.bcd;
        float f2 = this.bcM;
        if (this.bce) {
            int abs = Math.abs(i2 - i4);
            if (this.bbX >= i2) {
                int i11 = i4;
                i4 = i2;
                i2 = i11;
            }
            int i12 = (int) (abs * this.bcL * 0.5f);
            float f3 = i12;
            int i13 = i4 + i12;
            int i14 = i2 - i12;
            if (this.bbX < i13) {
                this.bcc = i3 - 1;
                this.bcd = i3;
                this.bcM = ((i13 - this.bbX) * 0.5f) / f3;
            } else if (this.bbX < i14) {
                this.bcc = i3;
                this.bcd = i3;
            } else {
                this.bcc = i3;
                this.bcd = i3 + 1;
                this.bcM = (1.0f + ((i2 - this.bbX) / f3)) * 0.5f;
            }
        } else {
            this.bcc = i3;
            this.bcd = i3;
        }
        if (this.bcc < headerViewsCount) {
            this.bcc = headerViewsCount;
            this.bcd = headerViewsCount;
            i3 = headerViewsCount;
        } else if (this.bcd >= this.mListView.getCount() - footerViewsCount) {
            i3 = (this.mListView.getCount() - footerViewsCount) - 1;
            this.bcc = i3;
            this.bcd = i3;
        }
        boolean z = (this.bcc == i9 && this.bcd == i10 && this.bcM == f2) ? false : true;
        if (i3 != this.bcb) {
            if (this.bcj != null) {
                this.bcj.drag(this.bcb - headerViewsCount, i3 - headerViewsCount);
            }
            this.bcb = i3;
            return true;
        }
        return z;
    }

    public void removeItem(int i2) {
        this.bcV = false;
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
            this.bcn = Math.max(1, obtainStyledAttributes.getDimensionPixelSize(e.l.DragSort_collapsed_height, 1));
            this.bcO = obtainStyledAttributes.getBoolean(e.l.DragSort_track_drag_sort, false);
            if (this.bcO) {
                this.bcP = new e();
            }
            this.bbZ = obtainStyledAttributes.getFloat(e.l.DragSort_float_alpha, this.bbZ);
            this.bca = this.bbZ;
            this.bcm = obtainStyledAttributes.getBoolean(e.l.DragSort_drag_enabled, this.bcm);
            this.bcL = Math.max(0.0f, Math.min(1.0f, 1.0f - obtainStyledAttributes.getFloat(e.l.DragSort_slide_shuffle_speed, 0.75f)));
            this.bce = this.bcL > 0.0f;
            setDragScrollStart(obtainStyledAttributes.getFloat(e.l.DragSort_drag_scroll_start, this.bcs));
            this.bcA = obtainStyledAttributes.getFloat(e.l.DragSort_max_drag_scroll_speed, this.bcA);
            int i4 = obtainStyledAttributes.getInt(e.l.DragSort_remove_animation_duration, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
            int i5 = obtainStyledAttributes.getInt(e.l.DragSort_drop_animation_duration, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
            if (obtainStyledAttributes.getBoolean(e.l.DragSort_use_default_controller, true)) {
                boolean z = obtainStyledAttributes.getBoolean(e.l.DragSort_remove_enabled, false);
                int i6 = obtainStyledAttributes.getInt(e.l.DragSort_remove_mode, 1);
                boolean z2 = obtainStyledAttributes.getBoolean(e.l.DragSort_sort_enabled, true);
                int resourceId = obtainStyledAttributes.getResourceId(e.l.DragSort_drag_handle_id, 0);
                int resourceId2 = obtainStyledAttributes.getResourceId(e.l.DragSort_fling_handle_id, 0);
                int resourceId3 = obtainStyledAttributes.getResourceId(e.l.DragSort_click_remove_id, 0);
                int color = obtainStyledAttributes.getColor(e.l.DragSort_float_background_color, ViewCompat.MEASURED_STATE_MASK);
                com.baidu.tbadk.widget.dragsort.b bVar = new com.baidu.tbadk.widget.dragsort.b(this, listView, resourceId, 2, i6, resourceId3, resourceId2);
                bVar.cv(z);
                bVar.cu(z2);
                bVar.setBackgroundColor(color);
                this.bcI = bVar;
                a(bVar);
            }
            obtainStyledAttributes.recycle();
            i2 = i5;
            i3 = i4;
        }
        this.bcr = new d();
        if (i3 > 0) {
            this.bcS = new k(0.5f, i3);
        }
        if (i2 > 0) {
            this.bcU = new f(0.5f, i2);
        }
        this.bcJ = MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
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
        this.bcY = bVar;
        this.mListView.setOnTouchListener(bVar);
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void dispatchDraw(Canvas canvas) {
        float f2;
        this.bcX.dispatchDraw(canvas);
        if (this.mDragState != 0) {
            if (this.bcc != this.bcf) {
                b(this.bcc, canvas);
            }
            if (this.bcd != this.bcc && this.bcd != this.bcf) {
                b(this.bcd, canvas);
            }
        }
        if (this.bbU != null) {
            int width = this.bbU.getWidth();
            int height = this.bbU.getHeight();
            int i2 = this.bbV.x;
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
            int i3 = (int) (f2 * 255.0f * this.bca);
            canvas.save();
            canvas.translate(this.bbV.x, this.bbV.y);
            canvas.clipRect(0, 0, width, height);
            canvas.saveLayerAlpha(0.0f, 0.0f, width, height, i3, 31);
            this.bbU.draw(canvas);
            canvas.restore();
            canvas.restore();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onDraw(Canvas canvas) {
        this.bcX.onDraw(canvas);
        if (this.bcO) {
            this.bcP.NM();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.bcQ) {
            this.bcQ = false;
            return false;
        } else if (!this.bcm) {
            return this.bcX.onTouchEvent(motionEvent);
        } else {
            boolean z2 = this.bcG;
            this.bcG = false;
            if (!z2) {
                u(motionEvent);
            }
            if (this.mDragState == 4) {
                onDragTouchEvent(motionEvent);
                return true;
            }
            if (this.mDragState == 0 && this.bcX.onTouchEvent(motionEvent)) {
                z = true;
            }
            switch (motionEvent.getAction() & 255) {
                case 1:
                case 3:
                    NE();
                    return z;
                case 2:
                default:
                    if (z) {
                        this.bcK = 1;
                        return z;
                    }
                    return z;
            }
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (!this.bcm) {
            return this.bcX.onInterceptTouchEvent(motionEvent);
        }
        if (this.bcY != null) {
            this.bcY.NO().onTouchEvent(motionEvent);
        }
        u(motionEvent);
        this.bcG = true;
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            if (this.mDragState != 0) {
                this.bcQ = true;
                return true;
            }
            this.bcH = true;
        }
        if (this.bbU == null) {
            if (this.bcX.onInterceptTouchEvent(motionEvent)) {
                this.bcZ = true;
                z = true;
            } else {
                z = false;
            }
            switch (action) {
                case 1:
                case 3:
                    NE();
                    break;
                case 2:
                default:
                    if (z) {
                        this.bcK = 1;
                        break;
                    } else {
                        this.bcK = 2;
                        break;
                    }
            }
        } else {
            z = true;
        }
        if (action == 1 || action == 3) {
            this.bcH = false;
        }
        return z;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        this.bcX.onSizeChanged(i2, i3, i4, i5);
        NF();
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void requestLayout() {
        if (!this.mBlockLayoutRequests) {
            this.bcX.requestLayout();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onMeasure(int i2, int i3) {
        this.bcX.onMeasure(i2, i3);
        if (this.bbU != null) {
            if (this.bbU.isLayoutRequested()) {
                NH();
            }
            this.bbY = true;
        }
        this.mWidthMeasureSpec = i2;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void layoutChildren() {
        this.bcX.layoutChildren();
        if (this.bbU != null) {
            if (this.bbU.isLayoutRequested() && !this.bbY) {
                NH();
            }
            this.bbU.layout(0, 0, this.bbU.getMeasuredWidth(), this.bbU.getMeasuredHeight());
            this.bbY = false;
        }
    }

    public void removeItem(int i2, float f2) {
        if (this.mDragState == 0 || this.mDragState == 4) {
            if (this.mDragState == 0) {
                this.bcf = this.mListView.getHeaderViewsCount() + i2;
                this.bcc = this.bcf;
                this.bcd = this.bcf;
                this.bcb = this.bcf;
                View childAt = this.mListView.getChildAt(this.bcf - this.mListView.getFirstVisiblePosition());
                if (childAt != null) {
                    childAt.setVisibility(4);
                }
            }
            this.mDragState = 1;
            this.bcW = f2;
            if (this.bcH) {
                switch (this.bcK) {
                    case 1:
                        this.bcX.onTouchEvent(this.bcJ);
                        break;
                    case 2:
                        this.bcX.onInterceptTouchEvent(this.bcJ);
                        break;
                }
            }
            if (this.bcS != null) {
                this.bcS.start();
            } else {
                fK(i2);
            }
        }
    }

    public void cancelDrag() {
        if (this.mDragState == 4) {
            this.bcr.ct(true);
            NJ();
            NA();
            NG();
            if (this.bcH) {
                this.mDragState = 3;
            } else {
                this.mDragState = 0;
            }
        }
    }

    private void NA() {
        this.bcf = -1;
        this.bcc = -1;
        this.bcd = -1;
        this.bcb = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NB() {
        this.mDragState = 2;
        if (this.bck != null && this.bcb >= 0 && this.bcb < this.mListView.getCount()) {
            int headerViewsCount = this.mListView.getHeaderViewsCount();
            this.bck.drop(this.bcf - headerViewsCount, this.bcb - headerViewsCount);
        }
        NJ();
        ND();
        NA();
        NG();
        if (this.bcH) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NC() {
        fK(this.bcf - this.mListView.getHeaderViewsCount());
    }

    private void fK(int i2) {
        this.mDragState = 1;
        if (this.bcl != null) {
            this.bcl.remove(i2);
        }
        NJ();
        ND();
        NA();
        if (this.bcH) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    private void ND() {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        if (this.bcf < firstVisiblePosition) {
            View childAt = this.mListView.getChildAt(0);
            this.mListView.setSelectionFromTop(firstVisiblePosition - 1, (childAt != null ? childAt.getTop() : 0) - this.mListView.getPaddingTop());
        }
    }

    public boolean stopDrag(boolean z) {
        this.bcV = false;
        return stopDrag(z, 0.0f);
    }

    public boolean stopDragWithVelocity(boolean z, float f2) {
        this.bcV = true;
        return stopDrag(z, f2);
    }

    public boolean stopDrag(boolean z, float f2) {
        if (this.bbU != null) {
            this.bcr.ct(true);
            if (z) {
                removeItem(this.bcf - this.mListView.getHeaderViewsCount(), f2);
            } else if (this.bcU != null) {
                this.bcU.start();
            } else {
                NB();
            }
            if (this.bcO) {
                this.bcP.oc();
                return true;
            }
            return true;
        }
        return false;
    }

    private void NE() {
        this.bcK = 0;
        this.bcH = false;
        if (this.mDragState == 3) {
            this.mDragState = 0;
        }
        this.bca = this.bbZ;
        this.bcZ = false;
        this.bcR.clear();
    }

    private void u(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            this.mLastX = this.bcC;
            this.mLastY = this.bcD;
        }
        this.bcC = (int) motionEvent.getX();
        this.bcD = (int) motionEvent.getY();
        if (action == 0) {
            this.mLastX = this.bcC;
            this.mLastY = this.bcD;
        }
        this.bci = ((int) motionEvent.getRawX()) - this.bcC;
        this.aBq = ((int) motionEvent.getRawY()) - this.bcD;
    }

    public boolean listViewIntercepted() {
        return this.bcZ;
    }

    public void setDragScrollStart(float f2) {
        setDragScrollStarts(f2, f2);
    }

    public void setDragScrollStarts(float f2, float f3) {
        if (f3 > 0.5f) {
            this.bct = 0.5f;
        } else {
            this.bct = f3;
        }
        if (f2 > 0.5f) {
            this.bcs = 0.5f;
        } else {
            this.bcs = f2;
        }
        if (this.mListView.getHeight() != 0) {
            NF();
        }
    }

    private void P(int i2, int i3) {
        this.bbV.x = i2 - this.bcg;
        this.bbV.y = i3 - this.bch;
        cs(true);
        int min = Math.min(i3, this.bbX + this.bcp);
        int max = Math.max(i3, this.bbX - this.bcp);
        int NL = this.bcr.NL();
        if (min > this.mLastY && min > this.bcv && NL != 1) {
            if (NL != -1) {
                this.bcr.ct(true);
            }
            this.bcr.fM(1);
        } else if (max < this.mLastY && max < this.bcu && NL != 0) {
            if (NL != -1) {
                this.bcr.ct(true);
            }
            this.bcr.fM(0);
        } else if (max >= this.bcu && min <= this.bcv && this.bcr.NK()) {
            this.bcr.ct(true);
        }
    }

    private void NF() {
        int height;
        int paddingTop = this.mListView.getPaddingTop();
        float height2 = (this.mListView.getHeight() - paddingTop) - this.mListView.getPaddingBottom();
        this.bcx = paddingTop + (this.bcs * height2);
        this.bcw = (height2 * (1.0f - this.bct)) + paddingTop;
        this.bcu = (int) this.bcx;
        this.bcv = (int) this.bcw;
        this.bcy = this.bcx - paddingTop;
        this.bcz = (paddingTop + height) - this.bcw;
    }

    private void NG() {
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
        if (i2 != this.bcf && i2 != this.bcc && i2 != this.bcd) {
            g2 = -2;
        } else {
            g2 = g(i2, view, z);
        }
        if (g2 != layoutParams.height) {
            layoutParams.height = g2;
            view.setLayoutParams(layoutParams);
        }
        if (i2 == this.bcc || i2 == this.bcd) {
            if (i2 < this.bcf) {
                ((DragSortItemView) view).setGravity(80);
            } else if (i2 > this.bcf) {
                ((DragSortItemView) view).setGravity(48);
            }
        }
        int visibility = view.getVisibility();
        int i3 = 0;
        if (i2 == this.bcf && this.bbU != null) {
            i3 = 4;
        }
        if (i3 != visibility) {
            view.setVisibility(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int fL(int i2) {
        View view;
        if (i2 == this.bcf) {
            return 0;
        }
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        if (childAt != null) {
            return f(i2, childAt, false);
        }
        int i3 = this.bcR.get(i2);
        if (i3 == -1) {
            ListAdapter adapter = this.mListView.getAdapter();
            int itemViewType = adapter.getItemViewType(i2);
            int viewTypeCount = adapter.getViewTypeCount();
            if (viewTypeCount != this.bcq.length) {
                this.bcq = new View[viewTypeCount];
            }
            if (itemViewType >= 0) {
                if (this.bcq[itemViewType] == null) {
                    view = adapter.getView(i2, null, this.mListView);
                    this.bcq[itemViewType] = view;
                } else {
                    view = adapter.getView(i2, this.bcq[itemViewType], this.mListView);
                }
            } else {
                view = adapter.getView(i2, null, this.mListView);
            }
            int f2 = f(i2, view, true);
            this.bcR.add(i2, f2);
            return f2;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(int i2, View view, boolean z) {
        if (i2 == this.bcf) {
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
        boolean z = this.bce && this.bcc != this.bcd;
        int i4 = this.bco - this.bcn;
        int i5 = (int) (this.bcM * i4);
        if (i2 == this.bcf) {
            if (this.bcf == this.bcc) {
                if (z) {
                    return i5 + this.bcn;
                }
                return this.bco;
            } else if (this.bcf == this.bcd) {
                return this.bco - i5;
            } else {
                return this.bcn;
            }
        } else if (i2 == this.bcc) {
            if (z) {
                return i3 + i5;
            }
            return i3 + i4;
        } else if (i2 == this.bcd) {
            return (i3 + i4) - i5;
        } else {
            return i3;
        }
    }

    private int b(int i2, View view, int i3, int i4) {
        int i5;
        int i6;
        int fL = fL(i2);
        int height = view.getHeight();
        int Q = Q(i2, fL);
        if (i2 != this.bcf) {
            i6 = height - fL;
            i5 = Q - fL;
        } else {
            i5 = Q;
            i6 = height;
        }
        int i7 = this.bco;
        if (this.bcf != this.bcc && this.bcf != this.bcd) {
            i7 -= this.bcn;
        }
        if (i2 <= i3) {
            if (i2 > this.bcc) {
                return (i7 - i5) + 0;
            }
        } else if (i2 == i4) {
            if (i2 <= this.bcc) {
                return (i6 - i7) + 0;
            }
            if (i2 == this.bcd) {
                return (height - Q) + 0;
            }
            return 0 + i6;
        } else if (i2 <= this.bcc) {
            return 0 - i7;
        } else {
            if (i2 == this.bcd) {
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

    private void NH() {
        if (this.bbU != null) {
            measureItem(this.bbU);
            this.bco = this.bbU.getMeasuredHeight();
            this.bcp = this.bco / 2;
        }
    }

    protected boolean onDragTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        switch (motionEvent.getAction() & 255) {
            case 1:
                if (this.mDragState == 4) {
                    stopDrag(false);
                }
                NE();
                return true;
            case 2:
                P((int) motionEvent.getX(), (int) motionEvent.getY());
                return true;
            case 3:
                if (this.mDragState == 4) {
                    cancelDrag();
                }
                NE();
                return true;
            default:
                return true;
        }
    }

    public boolean startDrag(int i2, int i3, int i4, int i5) {
        View fN;
        if (!this.bcH || this.bcI == null || (fN = this.bcI.fN(i2)) == null) {
            return false;
        }
        return startDrag(i2, fN, i3, i4, i5);
    }

    public boolean startDrag(int i2, View view, int i3, int i4, int i5) {
        if (this.mDragState == 0 && this.bcH && this.bbU == null && view != null && this.bcm) {
            if (this.mListView.getParent() != null) {
                this.mListView.getParent().requestDisallowInterceptTouchEvent(true);
            }
            int headerViewsCount = this.mListView.getHeaderViewsCount() + i2;
            this.bcc = headerViewsCount;
            this.bcd = headerViewsCount;
            this.bcf = headerViewsCount;
            this.bcb = headerViewsCount;
            this.mDragState = 4;
            this.bcF = 0;
            this.bcF |= i3;
            this.bbU = view;
            NH();
            this.bcg = i4;
            this.bch = i5;
            this.bcE = this.bcD;
            this.bbV.x = this.bcC - this.bcg;
            this.bbV.y = this.bcD - this.bch;
            View childAt = this.mListView.getChildAt(this.bcf - this.mListView.getFirstVisiblePosition());
            if (childAt != null) {
                childAt.setVisibility(4);
            }
            if (this.bcO) {
                this.bcP.startTracking();
            }
            switch (this.bcK) {
                case 1:
                    this.bcX.onTouchEvent(this.bcJ);
                    break;
                case 2:
                    this.bcX.onInterceptTouchEvent(this.bcJ);
                    break;
            }
            this.mListView.requestLayout();
            if (this.bcT != null) {
                this.bcT.start();
                return true;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cs(boolean z) {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition() + (this.mListView.getChildCount() / 2);
        View childAt = this.mListView.getChildAt(this.mListView.getChildCount() / 2);
        if (childAt != null) {
            h(firstVisiblePosition, childAt, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i2, View view, boolean z) {
        this.mBlockLayoutRequests = true;
        NI();
        int i3 = this.bcc;
        int i4 = this.bcd;
        boolean Nz = Nz();
        if (Nz) {
            NG();
            this.mListView.setSelectionFromTop(i2, (b(i2, view, i3, i4) + view.getTop()) - this.mListView.getPaddingTop());
            layoutChildren();
        }
        if (Nz || z) {
            this.mListView.invalidate();
        }
        this.mBlockLayoutRequests = false;
    }

    private void NI() {
        if (this.bcI != null) {
            this.bbW.set(this.bcC, this.bcD);
            this.bcI.b(this.bbU, this.bbV, this.bbW);
        }
        int i2 = this.bbV.x;
        int i3 = this.bbV.y;
        int paddingLeft = this.mListView.getPaddingLeft();
        if ((this.bcF & 1) == 0 && i2 > paddingLeft) {
            this.bbV.x = paddingLeft;
        } else if ((this.bcF & 2) == 0 && i2 < paddingLeft) {
            this.bbV.x = paddingLeft;
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int lastVisiblePosition = this.mListView.getLastVisiblePosition();
        int paddingTop = this.mListView.getPaddingTop();
        if (firstVisiblePosition < headerViewsCount) {
            paddingTop = this.mListView.getChildAt((headerViewsCount - firstVisiblePosition) - 1).getBottom();
        }
        if ((this.bcF & 8) == 0 && firstVisiblePosition <= this.bcf) {
            paddingTop = Math.max(this.mListView.getChildAt(this.bcf - firstVisiblePosition).getTop(), paddingTop);
        }
        int height = this.mListView.getHeight() - this.mListView.getPaddingBottom();
        if (lastVisiblePosition >= (this.mListView.getCount() - footerViewsCount) - 1) {
            height = this.mListView.getChildAt(((this.mListView.getCount() - footerViewsCount) - 1) - firstVisiblePosition).getBottom();
        }
        if ((this.bcF & 4) == 0 && lastVisiblePosition >= this.bcf) {
            height = Math.min(this.mListView.getChildAt(this.bcf - firstVisiblePosition).getBottom(), height);
        }
        if (i3 < paddingTop) {
            this.bbV.y = paddingTop;
        } else if (this.bco + i3 > height) {
            this.bbV.y = height - this.bco;
        }
        this.bbX = this.bbV.y + this.bcp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NJ() {
        if (this.bbU != null) {
            this.bbU.setVisibility(8);
            if (this.bcI != null) {
                this.bcI.ag(this.bbU);
            }
            this.bbU = null;
            this.mListView.invalidate();
        }
    }

    public void a(h hVar) {
        this.bcI = hVar;
    }

    public void a(b bVar) {
        this.bcj = bVar;
    }

    public void setDragEnabled(boolean z) {
        this.bcm = z;
    }

    public boolean isDragEnabled() {
        return this.bcm;
    }

    public void a(g gVar) {
        this.bck = gVar;
    }

    public void a(l lVar) {
        this.bcl = lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class i {
        private SparseIntArray bdt;
        private ArrayList<Integer> bdu;
        private int mMaxSize;

        public i(int i) {
            this.bdt = new SparseIntArray(i);
            this.bdu = new ArrayList<>(i);
            this.mMaxSize = i;
        }

        public void add(int i, int i2) {
            int i3 = this.bdt.get(i, -1);
            if (i3 != i2) {
                if (i3 == -1) {
                    if (this.bdt.size() == this.mMaxSize) {
                        this.bdt.delete(this.bdu.remove(0).intValue());
                    }
                } else {
                    this.bdu.remove(Integer.valueOf(i));
                }
                this.bdt.put(i, i2);
                this.bdu.add(Integer.valueOf(i));
            }
        }

        public int get(int i) {
            return this.bdt.get(i, -1);
        }

        public void clear() {
            this.bdt.clear();
            this.bdu.clear();
        }
    }

    /* renamed from: com.baidu.tbadk.widget.dragsort.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0119a extends BaseAdapter {
        private ListAdapter mAdapter;

        public C0119a(ListAdapter listAdapter) {
            this.mAdapter = listAdapter;
            this.mAdapter.registerDataSetObserver(new DataSetObserver() { // from class: com.baidu.tbadk.widget.dragsort.a.a.1
                @Override // android.database.DataSetObserver
                public void onChanged() {
                    C0119a.this.notifyDataSetChanged();
                }

                @Override // android.database.DataSetObserver
                public void onInvalidated() {
                    C0119a.this.notifyDataSetInvalidated();
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
        private float bdE;
        private float bdF;
        private float bdG;
        private float bdH;
        private float bdI;
        private float mAlpha;
        private boolean mCanceled;
        protected long mStartTime;

        public m(float f, int i) {
            this.mAlpha = f;
            this.bdE = i;
            float f2 = 1.0f / ((this.mAlpha * 2.0f) * (1.0f - this.mAlpha));
            this.bdI = f2;
            this.bdF = f2;
            this.bdG = this.mAlpha / ((this.mAlpha - 1.0f) * 2.0f);
            this.bdH = 1.0f / (1.0f - this.mAlpha);
        }

        public float aa(float f) {
            if (f < this.mAlpha) {
                return this.bdF * f * f;
            }
            if (f < 1.0f - this.mAlpha) {
                return this.bdG + (this.bdH * f);
            }
            return 1.0f - ((this.bdI * (f - 1.0f)) * (f - 1.0f));
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
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / this.bdE;
                if (uptimeMillis >= 1.0f) {
                    n(1.0f, 1.0f);
                    onStop();
                    return;
                }
                n(uptimeMillis, aa(uptimeMillis));
                a.this.mListView.post(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class f extends m {
        private int bdp;
        private int bdq;
        private float bdr;
        private float bds;

        public f(float f, int i) {
            super(f, i);
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.bdp = a.this.bcb;
            this.bdq = a.this.bcf;
            a.this.mDragState = 2;
            this.bdr = a.this.bbV.y - NN();
            this.bds = a.this.bbV.x - a.this.mListView.getPaddingLeft();
        }

        private int NN() {
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            int dividerHeight = (a.this.bcn + a.this.mListView.getDividerHeight()) / 2;
            View childAt = a.this.mListView.getChildAt(this.bdp - firstVisiblePosition);
            if (childAt != null) {
                if (this.bdp == this.bdq) {
                    return childAt.getTop();
                }
                if (this.bdp >= this.bdq) {
                    return (childAt.getBottom() + dividerHeight) - a.this.bco;
                }
                return childAt.getTop() - dividerHeight;
            }
            cancel();
            return -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void n(float f, float f2) {
            int NN = NN();
            float paddingLeft = a.this.bbV.x - a.this.mListView.getPaddingLeft();
            float f3 = 1.0f - f2;
            if (f3 < Math.abs((a.this.bbV.y - NN) / this.bdr) || f3 < Math.abs(paddingLeft / this.bds)) {
                a.this.bbV.y = NN + ((int) (this.bdr * f3));
                a.this.bbV.x = a.this.mListView.getPaddingLeft() + ((int) (this.bds * f3));
                a.this.cs(true);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.NB();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class k extends m {
        private int bdA;
        private int bdB;
        private int bdC;
        private int bdD;
        private int bdq;
        private float bdx;
        private float bdy;
        private float bdz;

        public k(float f, int i) {
            super(f, i);
            this.bdA = -1;
            this.bdB = -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.bdA = -1;
            this.bdB = -1;
            this.bdC = a.this.bcc;
            this.bdD = a.this.bcd;
            this.bdq = a.this.bcf;
            a.this.mDragState = 1;
            this.bdx = a.this.bbV.x;
            if (a.this.bcV) {
                float width = a.this.mListView.getWidth() * 2.0f;
                if (a.this.bcW == 0.0f) {
                    a.this.bcW = (this.bdx >= 0.0f ? 1 : -1) * width;
                    return;
                }
                float f = width * 2.0f;
                if (a.this.bcW >= 0.0f || a.this.bcW <= (-f)) {
                    if (a.this.bcW > 0.0f && a.this.bcW < f) {
                        a.this.bcW = f;
                        return;
                    }
                    return;
                }
                a.this.bcW = -f;
                return;
            }
            a.this.NJ();
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void n(float f, float f2) {
            View childAt;
            float f3 = 1.0f - f2;
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            View childAt2 = a.this.mListView.getChildAt(this.bdC - firstVisiblePosition);
            if (a.this.bcV) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / 1000.0f;
                if (uptimeMillis != 0.0f) {
                    float f4 = a.this.bcW * uptimeMillis;
                    int width = a.this.mListView.getWidth();
                    a.this.bcW = ((a.this.bcW > 0.0f ? 1 : -1) * uptimeMillis * width) + a.this.bcW;
                    this.bdx += f4;
                    a.this.bbV.x = (int) this.bdx;
                    if (this.bdx < width && this.bdx > (-width)) {
                        this.mStartTime = SystemClock.uptimeMillis();
                        a.this.cs(true);
                        return;
                    }
                } else {
                    return;
                }
            }
            if (childAt2 != null) {
                if (this.bdA == -1) {
                    this.bdA = a.this.f(this.bdC, childAt2, false);
                    this.bdy = childAt2.getHeight() - this.bdA;
                }
                int max = Math.max((int) (this.bdy * f3), 1);
                ViewGroup.LayoutParams layoutParams = childAt2.getLayoutParams();
                layoutParams.height = max + this.bdA;
                childAt2.setLayoutParams(layoutParams);
            }
            if (this.bdD != this.bdC && (childAt = a.this.mListView.getChildAt(this.bdD - firstVisiblePosition)) != null) {
                if (this.bdB == -1) {
                    this.bdB = a.this.f(this.bdD, childAt, false);
                    this.bdz = childAt.getHeight() - this.bdB;
                }
                int max2 = Math.max((int) (this.bdz * f3), 1);
                ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
                layoutParams2.height = max2 + this.bdB;
                childAt.setLayoutParams(layoutParams2);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.NC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class j extends m {
        final /* synthetic */ a bdb;
        private float bdv;
        private float bdw;

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.bdv = this.bdb.bch;
            this.bdw = this.bdb.bcp;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void n(float f, float f2) {
            if (this.bdb.mDragState != 4) {
                cancel();
                return;
            }
            this.bdb.bch = (int) ((this.bdw * f2) + ((1.0f - f2) * this.bdv));
            this.bdb.bbV.y = this.bdb.bcD - this.bdb.bch;
            this.bdb.cs(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e {
        StringBuilder mBuilder = new StringBuilder();
        private int bdm = 0;
        private int bdn = 0;
        private boolean bdo = false;
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
            this.bdn = 0;
            this.bdo = true;
        }

        public void NM() {
            if (this.bdo) {
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
                this.mBuilder.append("    <FirstExpPos>").append(a.this.bcc).append("</FirstExpPos>\n");
                this.mBuilder.append("    <FirstExpBlankHeight>").append(a.this.fJ(a.this.bcc) - a.this.fL(a.this.bcc)).append("</FirstExpBlankHeight>\n");
                this.mBuilder.append("    <SecondExpPos>").append(a.this.bcd).append("</SecondExpPos>\n");
                this.mBuilder.append("    <SecondExpBlankHeight>").append(a.this.fJ(a.this.bcd) - a.this.fL(a.this.bcd)).append("</SecondExpBlankHeight>\n");
                this.mBuilder.append("    <SrcPos>").append(a.this.bcf).append("</SrcPos>\n");
                this.mBuilder.append("    <SrcHeight>").append(a.this.bco + a.this.mListView.getDividerHeight()).append("</SrcHeight>\n");
                this.mBuilder.append("    <ViewHeight>").append(a.this.mListView.getHeight()).append("</ViewHeight>\n");
                this.mBuilder.append("    <LastY>").append(a.this.mLastY).append("</LastY>\n");
                this.mBuilder.append("    <FloatY>").append(a.this.bbX).append("</FloatY>\n");
                this.mBuilder.append("    <ShuffleEdges>");
                for (int i4 = 0; i4 < childCount; i4++) {
                    this.mBuilder.append(a.this.O(firstVisiblePosition + i4, a.this.mListView.getChildAt(i4).getTop())).append(",");
                }
                this.mBuilder.append("</ShuffleEdges>\n");
                this.mBuilder.append("</DSLVState>\n");
                this.bdm++;
                if (this.bdm > 1000) {
                    flush();
                    this.bdm = 0;
                }
            }
        }

        public void flush() {
            if (this.bdo) {
                try {
                    FileWriter fileWriter = new FileWriter(this.mFile, this.bdn != 0);
                    fileWriter.write(this.mBuilder.toString());
                    this.mBuilder.delete(0, this.mBuilder.length());
                    fileWriter.flush();
                    fileWriter.close();
                    this.bdn++;
                } catch (IOException e) {
                }
            }
        }

        public void oc() {
            if (this.bdo) {
                this.mBuilder.append("</DSLVStates>\n");
                flush();
                this.bdo = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements Runnable {
        private boolean bde;
        private long bdf;
        private long bdg;
        private float bdh;
        private long bdi;
        private int bdj;
        private float bdk;
        private boolean bdl = false;
        private int dy;

        public boolean NK() {
            return this.bdl;
        }

        public int NL() {
            if (this.bdl) {
                return this.bdj;
            }
            return -1;
        }

        public d() {
        }

        public void fM(int i) {
            if (!this.bdl) {
                this.bde = false;
                this.bdl = true;
                this.bdi = SystemClock.uptimeMillis();
                this.bdf = this.bdi;
                this.bdj = i;
                a.this.mListView.post(this);
            }
        }

        public void ct(boolean z) {
            if (z) {
                a.this.mListView.removeCallbacks(this);
                this.bdl = false;
                return;
            }
            this.bde = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.bde) {
                int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
                int lastVisiblePosition = a.this.mListView.getLastVisiblePosition();
                int count = a.this.mListView.getCount();
                int paddingTop = a.this.mListView.getPaddingTop();
                int height = (a.this.mListView.getHeight() - paddingTop) - a.this.mListView.getPaddingBottom();
                int min = Math.min(a.this.bcD, a.this.bbX + a.this.bcp);
                int max = Math.max(a.this.bcD, a.this.bbX - a.this.bcp);
                if (this.bdj == 0) {
                    View childAt = a.this.mListView.getChildAt(0);
                    if (childAt == null) {
                        this.bdl = false;
                        return;
                    } else if (firstVisiblePosition == 0 && childAt.getTop() == paddingTop) {
                        this.bdl = false;
                        return;
                    } else {
                        this.bdk = a.this.bcB.b((a.this.bcx - max) / a.this.bcy, this.bdf);
                    }
                } else {
                    View childAt2 = a.this.mListView.getChildAt(lastVisiblePosition - firstVisiblePosition);
                    if (childAt2 == null) {
                        this.bdl = false;
                        return;
                    } else if (lastVisiblePosition == count - 1 && childAt2.getBottom() <= height + paddingTop) {
                        this.bdl = false;
                        return;
                    } else {
                        this.bdk = -a.this.bcB.b((min - a.this.bcw) / a.this.bcz, this.bdf);
                    }
                }
                this.bdg = SystemClock.uptimeMillis();
                this.bdh = (float) (this.bdg - this.bdf);
                this.dy = Math.round(this.bdk * this.bdh);
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
                this.bdf = this.bdg;
                a.this.mListView.post(this);
                return;
            }
            this.bdl = false;
        }
    }
}
