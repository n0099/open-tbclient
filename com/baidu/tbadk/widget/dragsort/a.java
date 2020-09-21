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
    private int cNt;
    private View faP;
    private int faS;
    private int faW;
    private int faX;
    private int faY;
    private C0557a fbD;
    private e fbF;
    private k fbI;
    private j fbJ;
    private f fbK;
    private boolean fbL;
    private com.baidu.tbadk.widget.dragsort.d fbN;
    private com.baidu.tbadk.widget.dragsort.b fbO;
    private int fba;
    private int fbb;
    private int fbc;
    private b fbd;
    private g fbe;
    private l fbf;
    private int fbh;
    private d fbj;
    private int fbm;
    private int fbn;
    private float fbo;
    private float fbp;
    private float fbq;
    private float fbr;
    private int fbu;
    private MotionEvent fbz;
    private int mLastX;
    private int mLastY;
    private ListView mListView;
    private DataSetObserver mObserver;
    private int mOffsetX;
    private int mOffsetY;
    private int mX;
    private int mY;
    private Point faQ = new Point();
    private Point faR = new Point();
    private boolean faT = false;
    private float faU = 1.0f;
    private float faV = 1.0f;
    private boolean faZ = false;
    private boolean deU = true;
    private int mDragState = 0;
    private int fbg = 1;
    private int mWidthMeasureSpec = 0;
    private View[] fbi = new View[1];
    private float fbk = 0.33333334f;
    private float fbl = 0.33333334f;
    private float fbs = 0.5f;
    private c fbt = new c() { // from class: com.baidu.tbadk.widget.dragsort.a.1
        @Override // com.baidu.tbadk.widget.dragsort.a.c
        public float b(float f2, long j2) {
            return a.this.fbs * f2;
        }
    };
    private int fbv = 0;
    private boolean fbw = false;
    private boolean fbx = false;
    private h fby = null;
    private int fbA = 0;
    private float fbB = 0.25f;
    private float fbC = 0.0f;
    private boolean fbE = false;
    private boolean mBlockLayoutRequests = false;
    private boolean fbG = false;
    private i fbH = new i(3);
    private float fbM = 0.0f;
    private boolean fbP = false;
    private boolean fbQ = false;

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

        void by(View view);

        View rk(int i);
    }

    /* loaded from: classes.dex */
    public interface l {
        void remove(int i);
    }

    public a(ListView listView, com.baidu.tbadk.widget.dragsort.d dVar) {
        this.fbN = dVar;
        this.mListView = listView;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            this.fbD = new C0557a(listAdapter);
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
            this.fbD = null;
        }
        this.fbN.setAdapter(this.fbD);
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
            if (i2 > this.fba) {
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
    public int rg(int i2) {
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        return childAt != null ? childAt.getHeight() : bm(i2, ri(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bk(int i2, int i3) {
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        if (i2 <= headerViewsCount || i2 >= this.mListView.getCount() - footerViewsCount) {
            return i3;
        }
        int dividerHeight = this.mListView.getDividerHeight();
        int i4 = this.cNt - this.fbg;
        int ri = ri(i2);
        int rg = rg(i2);
        if (this.faY <= this.fba) {
            if (i2 == this.faY && this.faX != this.faY) {
                if (i2 == this.fba) {
                    i3 = (i3 + rg) - this.cNt;
                } else {
                    i3 = ((rg - ri) + i3) - i4;
                }
            } else if (i2 > this.faY && i2 <= this.fba) {
                i3 -= i4;
            }
        } else if (i2 > this.fba && i2 <= this.faX) {
            i3 += i4;
        } else if (i2 == this.faY && this.faX != this.faY) {
            i3 += rg - ri;
        }
        if (i2 <= this.fba) {
            return (((this.cNt - dividerHeight) - ri(i2 - 1)) / 2) + i3;
        }
        return (((ri - dividerHeight) - this.cNt) / 2) + i3;
    }

    private boolean bxE() {
        int i2;
        int i3;
        int i4;
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int i5 = this.faX;
        View childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        if (childAt == null) {
            i5 = firstVisiblePosition + (this.mListView.getChildCount() / 2);
            childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        }
        int top = childAt.getTop();
        int height = childAt.getHeight();
        int bk = bk(i5, top);
        int dividerHeight = this.mListView.getDividerHeight();
        if (this.faS >= bk) {
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
                    i6 = rg(i3 + 1);
                    i2 = bk(i3 + 1, i7);
                    if (this.faS < i2) {
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
                int rg = rg(i3);
                if (i3 == 0) {
                    i2 = (i8 - dividerHeight) - rg;
                    break;
                }
                i8 -= rg + dividerHeight;
                i2 = bk(i3, i8);
                if (this.faS >= i2) {
                    break;
                }
                i4 = i2;
            }
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int i9 = this.faX;
        int i10 = this.faY;
        float f2 = this.fbC;
        if (this.faZ) {
            int abs = Math.abs(i2 - i4);
            if (this.faS >= i2) {
                int i11 = i4;
                i4 = i2;
                i2 = i11;
            }
            int i12 = (int) (abs * this.fbB * 0.5f);
            float f3 = i12;
            int i13 = i4 + i12;
            int i14 = i2 - i12;
            if (this.faS < i13) {
                this.faX = i3 - 1;
                this.faY = i3;
                this.fbC = ((i13 - this.faS) * 0.5f) / f3;
            } else if (this.faS < i14) {
                this.faX = i3;
                this.faY = i3;
            } else {
                this.faX = i3;
                this.faY = i3 + 1;
                this.fbC = (1.0f + ((i2 - this.faS) / f3)) * 0.5f;
            }
        } else {
            this.faX = i3;
            this.faY = i3;
        }
        if (this.faX < headerViewsCount) {
            this.faX = headerViewsCount;
            this.faY = headerViewsCount;
            i3 = headerViewsCount;
        } else if (this.faY >= this.mListView.getCount() - footerViewsCount) {
            i3 = (this.mListView.getCount() - footerViewsCount) - 1;
            this.faX = i3;
            this.faY = i3;
        }
        boolean z = (this.faX == i9 && this.faY == i10 && this.fbC == f2) ? false : true;
        if (i3 != this.faW) {
            if (this.fbd != null) {
                this.fbd.drag(this.faW - headerViewsCount, i3 - headerViewsCount);
            }
            this.faW = i3;
            return true;
        }
        return z;
    }

    public void removeItem(int i2) {
        this.fbL = false;
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
            this.fbg = Math.max(1, obtainStyledAttributes.getDimensionPixelSize(R.styleable.DragSort_collapsed_height, 1));
            this.fbE = obtainStyledAttributes.getBoolean(R.styleable.DragSort_track_drag_sort, false);
            if (this.fbE) {
                this.fbF = new e();
            }
            this.faU = obtainStyledAttributes.getFloat(R.styleable.DragSort_float_alpha, this.faU);
            this.faV = this.faU;
            this.deU = obtainStyledAttributes.getBoolean(R.styleable.DragSort_drag_enabled, this.deU);
            this.fbB = Math.max(0.0f, Math.min(1.0f, 1.0f - obtainStyledAttributes.getFloat(R.styleable.DragSort_slide_shuffle_speed, 0.75f)));
            this.faZ = this.fbB > 0.0f;
            setDragScrollStart(obtainStyledAttributes.getFloat(R.styleable.DragSort_drag_scroll_start, this.fbk));
            this.fbs = obtainStyledAttributes.getFloat(R.styleable.DragSort_max_drag_scroll_speed, this.fbs);
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
                bVar.jV(z);
                bVar.jU(z2);
                bVar.setBackgroundColor(color);
                this.fby = bVar;
                a(bVar);
            }
            obtainStyledAttributes.recycle();
            i2 = i5;
            i3 = i4;
        }
        this.fbj = new d();
        if (i3 > 0) {
            this.fbI = new k(0.5f, i3);
        }
        if (i2 > 0) {
            this.fbK = new f(0.5f, i2);
        }
        this.fbz = MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
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
        this.fbO = bVar;
        this.mListView.setOnTouchListener(bVar);
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void dispatchDraw(Canvas canvas) {
        float f2;
        this.fbN.dispatchDraw(canvas);
        if (this.mDragState != 0) {
            if (this.faX != this.fba) {
                b(this.faX, canvas);
            }
            if (this.faY != this.faX && this.faY != this.fba) {
                b(this.faY, canvas);
            }
        }
        if (this.faP != null) {
            int width = this.faP.getWidth();
            int height = this.faP.getHeight();
            int i2 = this.faQ.x;
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
            int i3 = (int) (f2 * 255.0f * this.faV);
            canvas.save();
            canvas.translate(this.faQ.x, this.faQ.y);
            canvas.clipRect(0, 0, width, height);
            canvas.saveLayerAlpha(0.0f, 0.0f, width, height, i3, 31);
            this.faP.draw(canvas);
            canvas.restore();
            canvas.restore();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onDraw(Canvas canvas) {
        this.fbN.onDraw(canvas);
        if (this.fbE) {
            this.fbF.bxR();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.fbG) {
            this.fbG = false;
            return false;
        } else if (!this.deU) {
            return this.fbN.onTouchEvent(motionEvent);
        } else {
            boolean z2 = this.fbw;
            this.fbw = false;
            if (!z2) {
                G(motionEvent);
            }
            if (this.mDragState == 4) {
                onDragTouchEvent(motionEvent);
                return true;
            }
            if (this.mDragState == 0 && this.fbN.onTouchEvent(motionEvent)) {
                z = true;
            }
            switch (motionEvent.getAction() & 255) {
                case 1:
                case 3:
                    bxJ();
                    return z;
                case 2:
                default:
                    if (z) {
                        this.fbA = 1;
                        return z;
                    }
                    return z;
            }
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (!this.deU) {
            return this.fbN.onInterceptTouchEvent(motionEvent);
        }
        if (this.fbO != null) {
            this.fbO.bxT().onTouchEvent(motionEvent);
        }
        G(motionEvent);
        this.fbw = true;
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            if (this.mDragState != 0) {
                this.fbG = true;
                return true;
            }
            this.fbx = true;
        }
        if (this.faP == null) {
            if (this.fbN.onInterceptTouchEvent(motionEvent)) {
                this.fbP = true;
                z = true;
            } else {
                z = false;
            }
            switch (action) {
                case 1:
                case 3:
                    bxJ();
                    break;
                case 2:
                default:
                    if (z) {
                        this.fbA = 1;
                        break;
                    } else {
                        this.fbA = 2;
                        break;
                    }
            }
        } else {
            z = true;
        }
        if (action == 1 || action == 3) {
            this.fbx = false;
        }
        return z;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        this.fbN.onSizeChanged(i2, i3, i4, i5);
        bxK();
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void requestLayout() {
        if (!this.mBlockLayoutRequests) {
            this.fbN.requestLayout();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onMeasure(int i2, int i3) {
        this.fbN.onMeasure(i2, i3);
        if (this.faP != null) {
            if (this.faP.isLayoutRequested()) {
                bxM();
            }
            this.faT = true;
        }
        this.mWidthMeasureSpec = i2;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void layoutChildren() {
        this.fbN.layoutChildren();
        if (this.faP != null) {
            if (this.faP.isLayoutRequested() && !this.faT) {
                bxM();
            }
            this.faP.layout(0, 0, this.faP.getMeasuredWidth(), this.faP.getMeasuredHeight());
            this.faT = false;
        }
    }

    public void removeItem(int i2, float f2) {
        if (this.mDragState == 0 || this.mDragState == 4) {
            if (this.mDragState == 0) {
                this.fba = this.mListView.getHeaderViewsCount() + i2;
                this.faX = this.fba;
                this.faY = this.fba;
                this.faW = this.fba;
                View childAt = this.mListView.getChildAt(this.fba - this.mListView.getFirstVisiblePosition());
                if (childAt != null) {
                    childAt.setVisibility(4);
                }
            }
            this.mDragState = 1;
            this.fbM = f2;
            if (this.fbx) {
                switch (this.fbA) {
                    case 1:
                        this.fbN.onTouchEvent(this.fbz);
                        break;
                    case 2:
                        this.fbN.onInterceptTouchEvent(this.fbz);
                        break;
                }
            }
            if (this.fbI != null) {
                this.fbI.start();
            } else {
                rh(i2);
            }
        }
    }

    public void cancelDrag() {
        if (this.mDragState == 4) {
            this.fbj.jT(true);
            bxO();
            bxF();
            bxL();
            if (this.fbx) {
                this.mDragState = 3;
            } else {
                this.mDragState = 0;
            }
        }
    }

    private void bxF() {
        this.fba = -1;
        this.faX = -1;
        this.faY = -1;
        this.faW = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxG() {
        this.mDragState = 2;
        if (this.fbe != null && this.faW >= 0 && this.faW < this.mListView.getCount()) {
            int headerViewsCount = this.mListView.getHeaderViewsCount();
            this.fbe.drop(this.fba - headerViewsCount, this.faW - headerViewsCount);
        }
        bxO();
        bxI();
        bxF();
        bxL();
        if (this.fbx) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxH() {
        rh(this.fba - this.mListView.getHeaderViewsCount());
    }

    private void rh(int i2) {
        this.mDragState = 1;
        if (this.fbf != null) {
            this.fbf.remove(i2);
        }
        bxO();
        bxI();
        bxF();
        if (this.fbx) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    private void bxI() {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        if (this.fba < firstVisiblePosition) {
            View childAt = this.mListView.getChildAt(0);
            this.mListView.setSelectionFromTop(firstVisiblePosition - 1, (childAt != null ? childAt.getTop() : 0) - this.mListView.getPaddingTop());
        }
    }

    public boolean stopDrag(boolean z) {
        this.fbL = false;
        return stopDrag(z, 0.0f);
    }

    public boolean stopDragWithVelocity(boolean z, float f2) {
        this.fbL = true;
        return stopDrag(z, f2);
    }

    public boolean stopDrag(boolean z, float f2) {
        if (this.faP != null) {
            this.fbj.jT(true);
            if (z) {
                removeItem(this.fba - this.mListView.getHeaderViewsCount(), f2);
            } else if (this.fbK != null) {
                this.fbK.start();
            } else {
                bxG();
            }
            if (this.fbE) {
                this.fbF.stopTracking();
                return true;
            }
            return true;
        }
        return false;
    }

    private void bxJ() {
        this.fbA = 0;
        this.fbx = false;
        if (this.mDragState == 3) {
            this.mDragState = 0;
        }
        this.faV = this.faU;
        this.fbP = false;
        this.fbH.clear();
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
        return this.fbP;
    }

    public void setDragScrollStart(float f2) {
        setDragScrollStarts(f2, f2);
    }

    public void setDragScrollStarts(float f2, float f3) {
        if (f3 > 0.5f) {
            this.fbl = 0.5f;
        } else {
            this.fbl = f3;
        }
        if (f2 > 0.5f) {
            this.fbk = 0.5f;
        } else {
            this.fbk = f2;
        }
        if (this.mListView.getHeight() != 0) {
            bxK();
        }
    }

    private void bl(int i2, int i3) {
        this.faQ.x = i2 - this.fbb;
        this.faQ.y = i3 - this.fbc;
        jS(true);
        int min = Math.min(i3, this.faS + this.fbh);
        int max = Math.max(i3, this.faS - this.fbh);
        int bxP = this.fbj.bxP();
        if (min > this.mLastY && min > this.fbn && bxP != 1) {
            if (bxP != -1) {
                this.fbj.jT(true);
            }
            this.fbj.rj(1);
        } else if (max < this.mLastY && max < this.fbm && bxP != 0) {
            if (bxP != -1) {
                this.fbj.jT(true);
            }
            this.fbj.rj(0);
        } else if (max >= this.fbm && min <= this.fbn && this.fbj.isScrolling()) {
            this.fbj.jT(true);
        }
    }

    private void bxK() {
        int height;
        int paddingTop = this.mListView.getPaddingTop();
        float height2 = (this.mListView.getHeight() - paddingTop) - this.mListView.getPaddingBottom();
        this.fbp = paddingTop + (this.fbk * height2);
        this.fbo = (height2 * (1.0f - this.fbl)) + paddingTop;
        this.fbm = (int) this.fbp;
        this.fbn = (int) this.fbo;
        this.fbq = this.fbp - paddingTop;
        this.fbr = (paddingTop + height) - this.fbo;
    }

    private void bxL() {
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
        if (i2 != this.fba && i2 != this.faX && i2 != this.faY) {
            g2 = -2;
        } else {
            g2 = g(i2, view, z);
        }
        if (g2 != layoutParams.height) {
            layoutParams.height = g2;
            view.setLayoutParams(layoutParams);
        }
        if (i2 == this.faX || i2 == this.faY) {
            if (i2 < this.fba) {
                ((DragSortItemView) view).setGravity(80);
            } else if (i2 > this.fba) {
                ((DragSortItemView) view).setGravity(48);
            }
        }
        int visibility = view.getVisibility();
        int i3 = 0;
        if (i2 == this.fba && this.faP != null) {
            i3 = 4;
        }
        if (i3 != visibility) {
            view.setVisibility(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ri(int i2) {
        View view;
        if (i2 == this.fba) {
            return 0;
        }
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        if (childAt != null) {
            return f(i2, childAt, false);
        }
        int i3 = this.fbH.get(i2);
        if (i3 == -1) {
            ListAdapter adapter = this.mListView.getAdapter();
            int itemViewType = adapter.getItemViewType(i2);
            int viewTypeCount = adapter.getViewTypeCount();
            if (viewTypeCount != this.fbi.length) {
                this.fbi = new View[viewTypeCount];
            }
            if (itemViewType >= 0) {
                if (this.fbi[itemViewType] == null) {
                    view = adapter.getView(i2, null, this.mListView);
                    this.fbi[itemViewType] = view;
                } else {
                    view = adapter.getView(i2, this.fbi[itemViewType], this.mListView);
                }
            } else {
                view = adapter.getView(i2, null, this.mListView);
            }
            int f2 = f(i2, view, true);
            this.fbH.bn(i2, f2);
            return f2;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(int i2, View view, boolean z) {
        if (i2 == this.fba) {
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
        boolean z = this.faZ && this.faX != this.faY;
        int i4 = this.cNt - this.fbg;
        int i5 = (int) (this.fbC * i4);
        if (i2 == this.fba) {
            if (this.fba == this.faX) {
                if (z) {
                    return i5 + this.fbg;
                }
                return this.cNt;
            } else if (this.fba == this.faY) {
                return this.cNt - i5;
            } else {
                return this.fbg;
            }
        } else if (i2 == this.faX) {
            if (z) {
                return i3 + i5;
            }
            return i3 + i4;
        } else if (i2 == this.faY) {
            return (i3 + i4) - i5;
        } else {
            return i3;
        }
    }

    private int b(int i2, View view, int i3, int i4) {
        int i5;
        int i6;
        int ri = ri(i2);
        int height = view.getHeight();
        int bm = bm(i2, ri);
        if (i2 != this.fba) {
            i6 = height - ri;
            i5 = bm - ri;
        } else {
            i5 = bm;
            i6 = height;
        }
        int i7 = this.cNt;
        if (this.fba != this.faX && this.fba != this.faY) {
            i7 -= this.fbg;
        }
        if (i2 <= i3) {
            if (i2 > this.faX) {
                return (i7 - i5) + 0;
            }
        } else if (i2 == i4) {
            if (i2 <= this.faX) {
                return (i6 - i7) + 0;
            }
            if (i2 == this.faY) {
                return (height - bm) + 0;
            }
            return 0 + i6;
        } else if (i2 <= this.faX) {
            return 0 - i7;
        } else {
            if (i2 == this.faY) {
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

    private void bxM() {
        if (this.faP != null) {
            measureItem(this.faP);
            this.cNt = this.faP.getMeasuredHeight();
            this.fbh = this.cNt / 2;
        }
    }

    protected boolean onDragTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        switch (motionEvent.getAction() & 255) {
            case 1:
                if (this.mDragState == 4) {
                    stopDrag(false);
                }
                bxJ();
                return true;
            case 2:
                bl((int) motionEvent.getX(), (int) motionEvent.getY());
                return true;
            case 3:
                if (this.mDragState == 4) {
                    cancelDrag();
                }
                bxJ();
                return true;
            default:
                return true;
        }
    }

    public boolean startDrag(int i2, int i3, int i4, int i5) {
        View rk;
        if (!this.fbx || this.fby == null || (rk = this.fby.rk(i2)) == null) {
            return false;
        }
        return startDrag(i2, rk, i3, i4, i5);
    }

    public boolean startDrag(int i2, View view, int i3, int i4, int i5) {
        if (this.mDragState == 0 && this.fbx && this.faP == null && view != null && this.deU) {
            if (this.mListView.getParent() != null) {
                this.mListView.getParent().requestDisallowInterceptTouchEvent(true);
            }
            int headerViewsCount = this.mListView.getHeaderViewsCount() + i2;
            this.faX = headerViewsCount;
            this.faY = headerViewsCount;
            this.fba = headerViewsCount;
            this.faW = headerViewsCount;
            this.mDragState = 4;
            this.fbv = 0;
            this.fbv |= i3;
            this.faP = view;
            bxM();
            this.fbb = i4;
            this.fbc = i5;
            this.fbu = this.mY;
            this.faQ.x = this.mX - this.fbb;
            this.faQ.y = this.mY - this.fbc;
            View childAt = this.mListView.getChildAt(this.fba - this.mListView.getFirstVisiblePosition());
            if (childAt != null) {
                childAt.setVisibility(4);
            }
            if (this.fbE) {
                this.fbF.bxQ();
            }
            switch (this.fbA) {
                case 1:
                    this.fbN.onTouchEvent(this.fbz);
                    break;
                case 2:
                    this.fbN.onInterceptTouchEvent(this.fbz);
                    break;
            }
            this.mListView.requestLayout();
            if (this.fbJ != null) {
                this.fbJ.start();
                return true;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jS(boolean z) {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition() + (this.mListView.getChildCount() / 2);
        View childAt = this.mListView.getChildAt(this.mListView.getChildCount() / 2);
        if (childAt != null) {
            h(firstVisiblePosition, childAt, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i2, View view, boolean z) {
        this.mBlockLayoutRequests = true;
        bxN();
        int i3 = this.faX;
        int i4 = this.faY;
        boolean bxE = bxE();
        if (bxE) {
            bxL();
            this.mListView.setSelectionFromTop(i2, (b(i2, view, i3, i4) + view.getTop()) - this.mListView.getPaddingTop());
            layoutChildren();
        }
        if (bxE || z) {
            this.mListView.invalidate();
        }
        this.mBlockLayoutRequests = false;
    }

    private void bxN() {
        if (this.fby != null) {
            this.faR.set(this.mX, this.mY);
            this.fby.b(this.faP, this.faQ, this.faR);
        }
        int i2 = this.faQ.x;
        int i3 = this.faQ.y;
        int paddingLeft = this.mListView.getPaddingLeft();
        if ((this.fbv & 1) == 0 && i2 > paddingLeft) {
            this.faQ.x = paddingLeft;
        } else if ((this.fbv & 2) == 0 && i2 < paddingLeft) {
            this.faQ.x = paddingLeft;
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int lastVisiblePosition = this.mListView.getLastVisiblePosition();
        int paddingTop = this.mListView.getPaddingTop();
        if (firstVisiblePosition < headerViewsCount) {
            paddingTop = this.mListView.getChildAt((headerViewsCount - firstVisiblePosition) - 1).getBottom();
        }
        if ((this.fbv & 8) == 0 && firstVisiblePosition <= this.fba) {
            paddingTop = Math.max(this.mListView.getChildAt(this.fba - firstVisiblePosition).getTop(), paddingTop);
        }
        int height = this.mListView.getHeight() - this.mListView.getPaddingBottom();
        if (lastVisiblePosition >= (this.mListView.getCount() - footerViewsCount) - 1) {
            height = this.mListView.getChildAt(((this.mListView.getCount() - footerViewsCount) - 1) - firstVisiblePosition).getBottom();
        }
        if ((this.fbv & 4) == 0 && lastVisiblePosition >= this.fba) {
            height = Math.min(this.mListView.getChildAt(this.fba - firstVisiblePosition).getBottom(), height);
        }
        if (i3 < paddingTop) {
            this.faQ.y = paddingTop;
        } else if (this.cNt + i3 > height) {
            this.faQ.y = height - this.cNt;
        }
        this.faS = this.faQ.y + this.fbh;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxO() {
        if (this.faP != null) {
            this.faP.setVisibility(8);
            if (this.fby != null) {
                this.fby.by(this.faP);
            }
            this.faP = null;
            this.mListView.invalidate();
        }
    }

    public void a(h hVar) {
        this.fby = hVar;
    }

    public void a(b bVar) {
        this.fbd = bVar;
    }

    public void setDragEnabled(boolean z) {
        this.deU = z;
    }

    public boolean isDragEnabled() {
        return this.deU;
    }

    public void a(g gVar) {
        this.fbe = gVar;
    }

    public void a(l lVar) {
        this.fbf = lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class i {
        private SparseIntArray fcj;
        private ArrayList<Integer> fck;
        private int mMaxSize;

        public i(int i) {
            this.fcj = new SparseIntArray(i);
            this.fck = new ArrayList<>(i);
            this.mMaxSize = i;
        }

        public void bn(int i, int i2) {
            int i3 = this.fcj.get(i, -1);
            if (i3 != i2) {
                if (i3 == -1) {
                    if (this.fcj.size() == this.mMaxSize) {
                        this.fcj.delete(this.fck.remove(0).intValue());
                    }
                } else {
                    this.fck.remove(Integer.valueOf(i));
                }
                this.fcj.put(i, i2);
                this.fck.add(Integer.valueOf(i));
            }
        }

        public int get(int i) {
            return this.fcj.get(i, -1);
        }

        public void clear() {
            this.fcj.clear();
            this.fck.clear();
        }
    }

    /* renamed from: com.baidu.tbadk.widget.dragsort.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0557a extends BaseAdapter {
        private ListAdapter mAdapter;

        public C0557a(ListAdapter listAdapter) {
            this.mAdapter = listAdapter;
            this.mAdapter.registerDataSetObserver(new DataSetObserver() { // from class: com.baidu.tbadk.widget.dragsort.a.a.1
                @Override // android.database.DataSetObserver
                public void onChanged() {
                    C0557a.this.notifyDataSetChanged();
                }

                @Override // android.database.DataSetObserver
                public void onInvalidated() {
                    C0557a.this.notifyDataSetInvalidated();
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
        private float cbV;
        private float cbW;
        private float cbX;
        private float cbY;
        private float fcv;
        private float mAlpha;
        private boolean mCanceled;
        protected long mStartTime;

        public m(float f, int i) {
            this.mAlpha = f;
            this.fcv = i;
            float f2 = 1.0f / ((this.mAlpha * 2.0f) * (1.0f - this.mAlpha));
            this.cbY = f2;
            this.cbV = f2;
            this.cbW = this.mAlpha / ((this.mAlpha - 1.0f) * 2.0f);
            this.cbX = 1.0f / (1.0f - this.mAlpha);
        }

        public float ag(float f) {
            if (f < this.mAlpha) {
                return this.cbV * f * f;
            }
            if (f < 1.0f - this.mAlpha) {
                return this.cbW + (this.cbX * f);
            }
            return 1.0f - ((this.cbY * (f - 1.0f)) * (f - 1.0f));
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
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / this.fcv;
                if (uptimeMillis >= 1.0f) {
                    x(1.0f, 1.0f);
                    onStop();
                    return;
                }
                x(uptimeMillis, ag(uptimeMillis));
                a.this.mListView.post(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class f extends m {
        private int fcf;
        private int fcg;
        private float fch;
        private float fci;

        public f(float f, int i) {
            super(f, i);
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.fcf = a.this.faW;
            this.fcg = a.this.fba;
            a.this.mDragState = 2;
            this.fch = a.this.faQ.y - bxS();
            this.fci = a.this.faQ.x - a.this.mListView.getPaddingLeft();
        }

        private int bxS() {
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            int dividerHeight = (a.this.fbg + a.this.mListView.getDividerHeight()) / 2;
            View childAt = a.this.mListView.getChildAt(this.fcf - firstVisiblePosition);
            if (childAt != null) {
                if (this.fcf == this.fcg) {
                    return childAt.getTop();
                }
                if (this.fcf >= this.fcg) {
                    return (childAt.getBottom() + dividerHeight) - a.this.cNt;
                }
                return childAt.getTop() - dividerHeight;
            }
            cancel();
            return -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void x(float f, float f2) {
            int bxS = bxS();
            float paddingLeft = a.this.faQ.x - a.this.mListView.getPaddingLeft();
            float f3 = 1.0f - f2;
            if (f3 < Math.abs((a.this.faQ.y - bxS) / this.fch) || f3 < Math.abs(paddingLeft / this.fci)) {
                a.this.faQ.y = bxS + ((int) (this.fch * f3));
                a.this.faQ.x = a.this.mListView.getPaddingLeft() + ((int) (this.fci * f3));
                a.this.jS(true);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.bxG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class k extends m {
        private int fcg;
        private float fcn;
        private float fco;
        private float fcq;
        private int fcr;
        private int fcs;
        private int fct;
        private int fcu;

        public k(float f, int i) {
            super(f, i);
            this.fcr = -1;
            this.fcs = -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.fcr = -1;
            this.fcs = -1;
            this.fct = a.this.faX;
            this.fcu = a.this.faY;
            this.fcg = a.this.fba;
            a.this.mDragState = 1;
            this.fcn = a.this.faQ.x;
            if (a.this.fbL) {
                float width = a.this.mListView.getWidth() * 2.0f;
                if (a.this.fbM == 0.0f) {
                    a.this.fbM = (this.fcn >= 0.0f ? 1 : -1) * width;
                    return;
                }
                float f = width * 2.0f;
                if (a.this.fbM >= 0.0f || a.this.fbM <= (-f)) {
                    if (a.this.fbM > 0.0f && a.this.fbM < f) {
                        a.this.fbM = f;
                        return;
                    }
                    return;
                }
                a.this.fbM = -f;
                return;
            }
            a.this.bxO();
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void x(float f, float f2) {
            View childAt;
            float f3 = 1.0f - f2;
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            View childAt2 = a.this.mListView.getChildAt(this.fct - firstVisiblePosition);
            if (a.this.fbL) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / 1000.0f;
                if (uptimeMillis != 0.0f) {
                    float f4 = a.this.fbM * uptimeMillis;
                    int width = a.this.mListView.getWidth();
                    a.this.fbM = ((a.this.fbM > 0.0f ? 1 : -1) * uptimeMillis * width) + a.this.fbM;
                    this.fcn += f4;
                    a.this.faQ.x = (int) this.fcn;
                    if (this.fcn < width && this.fcn > (-width)) {
                        this.mStartTime = SystemClock.uptimeMillis();
                        a.this.jS(true);
                        return;
                    }
                } else {
                    return;
                }
            }
            if (childAt2 != null) {
                if (this.fcr == -1) {
                    this.fcr = a.this.f(this.fct, childAt2, false);
                    this.fco = childAt2.getHeight() - this.fcr;
                }
                int max = Math.max((int) (this.fco * f3), 1);
                ViewGroup.LayoutParams layoutParams = childAt2.getLayoutParams();
                layoutParams.height = max + this.fcr;
                childAt2.setLayoutParams(layoutParams);
            }
            if (this.fcu != this.fct && (childAt = a.this.mListView.getChildAt(this.fcu - firstVisiblePosition)) != null) {
                if (this.fcs == -1) {
                    this.fcs = a.this.f(this.fcu, childAt, false);
                    this.fcq = childAt.getHeight() - this.fcs;
                }
                int max2 = Math.max((int) (this.fcq * f3), 1);
                ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
                layoutParams2.height = max2 + this.fcs;
                childAt.setLayoutParams(layoutParams2);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.bxH();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class j extends m {
        final /* synthetic */ a fbR;
        private float fcl;
        private float fcm;

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.fcl = this.fbR.fbc;
            this.fcm = this.fbR.fbh;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void x(float f, float f2) {
            if (this.fbR.mDragState != 4) {
                cancel();
                return;
            }
            this.fbR.fbc = (int) ((this.fcm * f2) + ((1.0f - f2) * this.fcl));
            this.fbR.faQ.y = this.fbR.mY - this.fbR.fbc;
            this.fbR.jS(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e {
        StringBuilder mBuilder = new StringBuilder();
        private int fcc = 0;
        private int fcd = 0;
        private boolean fce = false;
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

        public void bxQ() {
            this.mBuilder.append("<DSLVStates>\n");
            this.fcd = 0;
            this.fce = true;
        }

        public void bxR() {
            if (this.fce) {
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
                this.mBuilder.append("    <FirstExpPos>").append(a.this.faX).append("</FirstExpPos>\n");
                this.mBuilder.append("    <FirstExpBlankHeight>").append(a.this.rg(a.this.faX) - a.this.ri(a.this.faX)).append("</FirstExpBlankHeight>\n");
                this.mBuilder.append("    <SecondExpPos>").append(a.this.faY).append("</SecondExpPos>\n");
                this.mBuilder.append("    <SecondExpBlankHeight>").append(a.this.rg(a.this.faY) - a.this.ri(a.this.faY)).append("</SecondExpBlankHeight>\n");
                this.mBuilder.append("    <SrcPos>").append(a.this.fba).append("</SrcPos>\n");
                this.mBuilder.append("    <SrcHeight>").append(a.this.cNt + a.this.mListView.getDividerHeight()).append("</SrcHeight>\n");
                this.mBuilder.append("    <ViewHeight>").append(a.this.mListView.getHeight()).append("</ViewHeight>\n");
                this.mBuilder.append("    <LastY>").append(a.this.mLastY).append("</LastY>\n");
                this.mBuilder.append("    <FloatY>").append(a.this.faS).append("</FloatY>\n");
                this.mBuilder.append("    <ShuffleEdges>");
                for (int i4 = 0; i4 < childCount; i4++) {
                    this.mBuilder.append(a.this.bk(firstVisiblePosition + i4, a.this.mListView.getChildAt(i4).getTop())).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                this.mBuilder.append("</ShuffleEdges>\n");
                this.mBuilder.append("</DSLVState>\n");
                this.fcc++;
                if (this.fcc > 1000) {
                    flush();
                    this.fcc = 0;
                }
            }
        }

        public void flush() {
            if (this.fce) {
                try {
                    FileWriter fileWriter = new FileWriter(this.mFile, this.fcd != 0);
                    fileWriter.write(this.mBuilder.toString());
                    this.mBuilder.delete(0, this.mBuilder.length());
                    fileWriter.flush();
                    fileWriter.close();
                    this.fcd++;
                } catch (IOException e) {
                }
            }
        }

        public void stopTracking() {
            if (this.fce) {
                this.mBuilder.append("</DSLVStates>\n");
                flush();
                this.fce = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements Runnable {
        private boolean fbU;
        private long fbV;
        private long fbW;
        private int fbX;
        private float fbY;
        private long fbZ;
        private int fca;
        private float fcb;
        private boolean mScrolling = false;

        public boolean isScrolling() {
            return this.mScrolling;
        }

        public int bxP() {
            if (this.mScrolling) {
                return this.fca;
            }
            return -1;
        }

        public d() {
        }

        public void rj(int i) {
            if (!this.mScrolling) {
                this.fbU = false;
                this.mScrolling = true;
                this.fbZ = SystemClock.uptimeMillis();
                this.fbV = this.fbZ;
                this.fca = i;
                a.this.mListView.post(this);
            }
        }

        public void jT(boolean z) {
            if (z) {
                a.this.mListView.removeCallbacks(this);
                this.mScrolling = false;
                return;
            }
            this.fbU = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.fbU) {
                int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
                int lastVisiblePosition = a.this.mListView.getLastVisiblePosition();
                int count = a.this.mListView.getCount();
                int paddingTop = a.this.mListView.getPaddingTop();
                int height = (a.this.mListView.getHeight() - paddingTop) - a.this.mListView.getPaddingBottom();
                int min = Math.min(a.this.mY, a.this.faS + a.this.fbh);
                int max = Math.max(a.this.mY, a.this.faS - a.this.fbh);
                if (this.fca == 0) {
                    View childAt = a.this.mListView.getChildAt(0);
                    if (childAt == null) {
                        this.mScrolling = false;
                        return;
                    } else if (firstVisiblePosition == 0 && childAt.getTop() == paddingTop) {
                        this.mScrolling = false;
                        return;
                    } else {
                        this.fcb = a.this.fbt.b((a.this.fbp - max) / a.this.fbq, this.fbV);
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
                        this.fcb = -a.this.fbt.b((min - a.this.fbo) / a.this.fbr, this.fbV);
                    }
                }
                this.fbW = SystemClock.uptimeMillis();
                this.fbY = (float) (this.fbW - this.fbV);
                this.fbX = Math.round(this.fcb * this.fbY);
                if (this.fbX >= 0) {
                    this.fbX = Math.min(height, this.fbX);
                    lastVisiblePosition = firstVisiblePosition;
                } else {
                    this.fbX = Math.max(-height, this.fbX);
                }
                View childAt3 = a.this.mListView.getChildAt(lastVisiblePosition - firstVisiblePosition);
                int top = childAt3.getTop() + this.fbX;
                if (lastVisiblePosition == 0 && top > paddingTop) {
                    top = paddingTop;
                }
                a.this.mBlockLayoutRequests = true;
                a.this.mListView.setSelectionFromTop(lastVisiblePosition, top - paddingTop);
                a.this.layoutChildren();
                a.this.mListView.invalidate();
                a.this.mBlockLayoutRequests = false;
                a.this.h(lastVisiblePosition, childAt3, false);
                this.fbV = this.fbW;
                a.this.mListView.post(this);
                return;
            }
            this.mScrolling = false;
        }
    }
}
