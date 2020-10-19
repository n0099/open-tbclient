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
    private int cZw;
    private int fnA;
    private float fnB;
    private float fnC;
    private float fnD;
    private float fnE;
    private int fnH;
    private MotionEvent fnM;
    private C0574a fnQ;
    private e fnS;
    private k fnV;
    private j fnW;
    private f fnX;
    private boolean fnY;
    private View fnc;
    private int fnf;
    private int fnj;
    private int fnk;
    private int fnl;
    private int fnn;
    private int fno;
    private int fnp;
    private b fnq;
    private g fnr;
    private l fns;
    private int fnu;
    private d fnw;
    private int fnz;
    private com.baidu.tbadk.widget.dragsort.d foa;
    private com.baidu.tbadk.widget.dragsort.b fob;
    private int mLastX;
    private int mLastY;
    private ListView mListView;
    private DataSetObserver mObserver;
    private int mOffsetX;
    private int mOffsetY;
    private int mX;
    private int mY;
    private Point fnd = new Point();
    private Point fne = new Point();
    private boolean fng = false;
    private float fnh = 1.0f;
    private float fni = 1.0f;
    private boolean fnm = false;
    private boolean dra = true;
    private int mDragState = 0;
    private int fnt = 1;
    private int mWidthMeasureSpec = 0;
    private View[] fnv = new View[1];
    private float fnx = 0.33333334f;
    private float fny = 0.33333334f;
    private float fnF = 0.5f;
    private c fnG = new c() { // from class: com.baidu.tbadk.widget.dragsort.a.1
        @Override // com.baidu.tbadk.widget.dragsort.a.c
        public float b(float f2, long j2) {
            return a.this.fnF * f2;
        }
    };
    private int fnI = 0;
    private boolean fnJ = false;
    private boolean fnK = false;
    private h fnL = null;
    private int fnN = 0;
    private float fnO = 0.25f;
    private float fnP = 0.0f;
    private boolean fnR = false;
    private boolean mBlockLayoutRequests = false;
    private boolean fnT = false;
    private i fnU = new i(3);
    private float fnZ = 0.0f;
    private boolean foc = false;
    private boolean fod = false;

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

        void bC(View view);

        View rI(int i);
    }

    /* loaded from: classes.dex */
    public interface l {
        void remove(int i);
    }

    public a(ListView listView, com.baidu.tbadk.widget.dragsort.d dVar) {
        this.foa = dVar;
        this.mListView = listView;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            this.fnQ = new C0574a(listAdapter);
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
            this.fnQ = null;
        }
        this.foa.setAdapter(this.fnQ);
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
            if (i2 > this.fnn) {
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
    public int rE(int i2) {
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        return childAt != null ? childAt.getHeight() : bl(i2, rG(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bj(int i2, int i3) {
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        if (i2 <= headerViewsCount || i2 >= this.mListView.getCount() - footerViewsCount) {
            return i3;
        }
        int dividerHeight = this.mListView.getDividerHeight();
        int i4 = this.cZw - this.fnt;
        int rG = rG(i2);
        int rE = rE(i2);
        if (this.fnl <= this.fnn) {
            if (i2 == this.fnl && this.fnk != this.fnl) {
                if (i2 == this.fnn) {
                    i3 = (i3 + rE) - this.cZw;
                } else {
                    i3 = ((rE - rG) + i3) - i4;
                }
            } else if (i2 > this.fnl && i2 <= this.fnn) {
                i3 -= i4;
            }
        } else if (i2 > this.fnn && i2 <= this.fnk) {
            i3 += i4;
        } else if (i2 == this.fnl && this.fnk != this.fnl) {
            i3 += rE - rG;
        }
        if (i2 <= this.fnn) {
            return (((this.cZw - dividerHeight) - rG(i2 - 1)) / 2) + i3;
        }
        return (((rG - dividerHeight) - this.cZw) / 2) + i3;
    }

    private boolean bAo() {
        int i2;
        int i3;
        int i4;
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int i5 = this.fnk;
        View childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        if (childAt == null) {
            i5 = firstVisiblePosition + (this.mListView.getChildCount() / 2);
            childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        }
        int top = childAt.getTop();
        int height = childAt.getHeight();
        int bj = bj(i5, top);
        int dividerHeight = this.mListView.getDividerHeight();
        if (this.fnf >= bj) {
            int count = this.mListView.getCount();
            int i6 = height;
            int i7 = top;
            i2 = bj;
            i3 = i5;
            i4 = bj;
            while (true) {
                if (i3 < count) {
                    if (i3 == count - 1) {
                        i2 = i7 + dividerHeight + i6;
                        break;
                    }
                    i7 += dividerHeight + i6;
                    i6 = rE(i3 + 1);
                    i2 = bj(i3 + 1, i7);
                    if (this.fnf < i2) {
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
            i2 = bj;
            i3 = i5;
            i4 = bj;
            while (true) {
                if (i3 < 0) {
                    break;
                }
                i3--;
                int rE = rE(i3);
                if (i3 == 0) {
                    i2 = (i8 - dividerHeight) - rE;
                    break;
                }
                i8 -= rE + dividerHeight;
                i2 = bj(i3, i8);
                if (this.fnf >= i2) {
                    break;
                }
                i4 = i2;
            }
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int i9 = this.fnk;
        int i10 = this.fnl;
        float f2 = this.fnP;
        if (this.fnm) {
            int abs = Math.abs(i2 - i4);
            if (this.fnf >= i2) {
                int i11 = i4;
                i4 = i2;
                i2 = i11;
            }
            int i12 = (int) (abs * this.fnO * 0.5f);
            float f3 = i12;
            int i13 = i4 + i12;
            int i14 = i2 - i12;
            if (this.fnf < i13) {
                this.fnk = i3 - 1;
                this.fnl = i3;
                this.fnP = ((i13 - this.fnf) * 0.5f) / f3;
            } else if (this.fnf < i14) {
                this.fnk = i3;
                this.fnl = i3;
            } else {
                this.fnk = i3;
                this.fnl = i3 + 1;
                this.fnP = (1.0f + ((i2 - this.fnf) / f3)) * 0.5f;
            }
        } else {
            this.fnk = i3;
            this.fnl = i3;
        }
        if (this.fnk < headerViewsCount) {
            this.fnk = headerViewsCount;
            this.fnl = headerViewsCount;
            i3 = headerViewsCount;
        } else if (this.fnl >= this.mListView.getCount() - footerViewsCount) {
            i3 = (this.mListView.getCount() - footerViewsCount) - 1;
            this.fnk = i3;
            this.fnl = i3;
        }
        boolean z = (this.fnk == i9 && this.fnl == i10 && this.fnP == f2) ? false : true;
        if (i3 != this.fnj) {
            if (this.fnq != null) {
                this.fnq.drag(this.fnj - headerViewsCount, i3 - headerViewsCount);
            }
            this.fnj = i3;
            return true;
        }
        return z;
    }

    public void removeItem(int i2) {
        this.fnY = false;
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
            this.fnt = Math.max(1, obtainStyledAttributes.getDimensionPixelSize(R.styleable.DragSort_collapsed_height, 1));
            this.fnR = obtainStyledAttributes.getBoolean(R.styleable.DragSort_track_drag_sort, false);
            if (this.fnR) {
                this.fnS = new e();
            }
            this.fnh = obtainStyledAttributes.getFloat(R.styleable.DragSort_float_alpha, this.fnh);
            this.fni = this.fnh;
            this.dra = obtainStyledAttributes.getBoolean(R.styleable.DragSort_drag_enabled, this.dra);
            this.fnO = Math.max(0.0f, Math.min(1.0f, 1.0f - obtainStyledAttributes.getFloat(R.styleable.DragSort_slide_shuffle_speed, 0.75f)));
            this.fnm = this.fnO > 0.0f;
            setDragScrollStart(obtainStyledAttributes.getFloat(R.styleable.DragSort_drag_scroll_start, this.fnx));
            this.fnF = obtainStyledAttributes.getFloat(R.styleable.DragSort_max_drag_scroll_speed, this.fnF);
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
                bVar.kt(z);
                bVar.ks(z2);
                bVar.setBackgroundColor(color);
                this.fnL = bVar;
                a(bVar);
            }
            obtainStyledAttributes.recycle();
            i2 = i5;
            i3 = i4;
        }
        this.fnw = new d();
        if (i3 > 0) {
            this.fnV = new k(0.5f, i3);
        }
        if (i2 > 0) {
            this.fnX = new f(0.5f, i2);
        }
        this.fnM = MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
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
        this.fob = bVar;
        this.mListView.setOnTouchListener(bVar);
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void dispatchDraw(Canvas canvas) {
        float f2;
        this.foa.dispatchDraw(canvas);
        if (this.mDragState != 0) {
            if (this.fnk != this.fnn) {
                b(this.fnk, canvas);
            }
            if (this.fnl != this.fnk && this.fnl != this.fnn) {
                b(this.fnl, canvas);
            }
        }
        if (this.fnc != null) {
            int width = this.fnc.getWidth();
            int height = this.fnc.getHeight();
            int i2 = this.fnd.x;
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
            int i3 = (int) (f2 * 255.0f * this.fni);
            canvas.save();
            canvas.translate(this.fnd.x, this.fnd.y);
            canvas.clipRect(0, 0, width, height);
            canvas.saveLayerAlpha(0.0f, 0.0f, width, height, i3, 31);
            this.fnc.draw(canvas);
            canvas.restore();
            canvas.restore();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onDraw(Canvas canvas) {
        this.foa.onDraw(canvas);
        if (this.fnR) {
            this.fnS.bAB();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.fnT) {
            this.fnT = false;
            return false;
        } else if (!this.dra) {
            return this.foa.onTouchEvent(motionEvent);
        } else {
            boolean z2 = this.fnJ;
            this.fnJ = false;
            if (!z2) {
                G(motionEvent);
            }
            if (this.mDragState == 4) {
                onDragTouchEvent(motionEvent);
                return true;
            }
            if (this.mDragState == 0 && this.foa.onTouchEvent(motionEvent)) {
                z = true;
            }
            switch (motionEvent.getAction() & 255) {
                case 1:
                case 3:
                    bAt();
                    return z;
                case 2:
                default:
                    if (z) {
                        this.fnN = 1;
                        return z;
                    }
                    return z;
            }
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (!this.dra) {
            return this.foa.onInterceptTouchEvent(motionEvent);
        }
        if (this.fob != null) {
            this.fob.bAD().onTouchEvent(motionEvent);
        }
        G(motionEvent);
        this.fnJ = true;
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            if (this.mDragState != 0) {
                this.fnT = true;
                return true;
            }
            this.fnK = true;
        }
        if (this.fnc == null) {
            if (this.foa.onInterceptTouchEvent(motionEvent)) {
                this.foc = true;
                z = true;
            } else {
                z = false;
            }
            switch (action) {
                case 1:
                case 3:
                    bAt();
                    break;
                case 2:
                default:
                    if (z) {
                        this.fnN = 1;
                        break;
                    } else {
                        this.fnN = 2;
                        break;
                    }
            }
        } else {
            z = true;
        }
        if (action == 1 || action == 3) {
            this.fnK = false;
        }
        return z;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        this.foa.onSizeChanged(i2, i3, i4, i5);
        bAu();
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void requestLayout() {
        if (!this.mBlockLayoutRequests) {
            this.foa.requestLayout();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onMeasure(int i2, int i3) {
        this.foa.onMeasure(i2, i3);
        if (this.fnc != null) {
            if (this.fnc.isLayoutRequested()) {
                bAw();
            }
            this.fng = true;
        }
        this.mWidthMeasureSpec = i2;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void layoutChildren() {
        this.foa.layoutChildren();
        if (this.fnc != null) {
            if (this.fnc.isLayoutRequested() && !this.fng) {
                bAw();
            }
            this.fnc.layout(0, 0, this.fnc.getMeasuredWidth(), this.fnc.getMeasuredHeight());
            this.fng = false;
        }
    }

    public void removeItem(int i2, float f2) {
        if (this.mDragState == 0 || this.mDragState == 4) {
            if (this.mDragState == 0) {
                this.fnn = this.mListView.getHeaderViewsCount() + i2;
                this.fnk = this.fnn;
                this.fnl = this.fnn;
                this.fnj = this.fnn;
                View childAt = this.mListView.getChildAt(this.fnn - this.mListView.getFirstVisiblePosition());
                if (childAt != null) {
                    childAt.setVisibility(4);
                }
            }
            this.mDragState = 1;
            this.fnZ = f2;
            if (this.fnK) {
                switch (this.fnN) {
                    case 1:
                        this.foa.onTouchEvent(this.fnM);
                        break;
                    case 2:
                        this.foa.onInterceptTouchEvent(this.fnM);
                        break;
                }
            }
            if (this.fnV != null) {
                this.fnV.start();
            } else {
                rF(i2);
            }
        }
    }

    public void cancelDrag() {
        if (this.mDragState == 4) {
            this.fnw.kr(true);
            bAy();
            bAp();
            bAv();
            if (this.fnK) {
                this.mDragState = 3;
            } else {
                this.mDragState = 0;
            }
        }
    }

    private void bAp() {
        this.fnn = -1;
        this.fnk = -1;
        this.fnl = -1;
        this.fnj = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAq() {
        this.mDragState = 2;
        if (this.fnr != null && this.fnj >= 0 && this.fnj < this.mListView.getCount()) {
            int headerViewsCount = this.mListView.getHeaderViewsCount();
            this.fnr.drop(this.fnn - headerViewsCount, this.fnj - headerViewsCount);
        }
        bAy();
        bAs();
        bAp();
        bAv();
        if (this.fnK) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAr() {
        rF(this.fnn - this.mListView.getHeaderViewsCount());
    }

    private void rF(int i2) {
        this.mDragState = 1;
        if (this.fns != null) {
            this.fns.remove(i2);
        }
        bAy();
        bAs();
        bAp();
        if (this.fnK) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    private void bAs() {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        if (this.fnn < firstVisiblePosition) {
            View childAt = this.mListView.getChildAt(0);
            this.mListView.setSelectionFromTop(firstVisiblePosition - 1, (childAt != null ? childAt.getTop() : 0) - this.mListView.getPaddingTop());
        }
    }

    public boolean stopDrag(boolean z) {
        this.fnY = false;
        return stopDrag(z, 0.0f);
    }

    public boolean stopDragWithVelocity(boolean z, float f2) {
        this.fnY = true;
        return stopDrag(z, f2);
    }

    public boolean stopDrag(boolean z, float f2) {
        if (this.fnc != null) {
            this.fnw.kr(true);
            if (z) {
                removeItem(this.fnn - this.mListView.getHeaderViewsCount(), f2);
            } else if (this.fnX != null) {
                this.fnX.start();
            } else {
                bAq();
            }
            if (this.fnR) {
                this.fnS.stopTracking();
                return true;
            }
            return true;
        }
        return false;
    }

    private void bAt() {
        this.fnN = 0;
        this.fnK = false;
        if (this.mDragState == 3) {
            this.mDragState = 0;
        }
        this.fni = this.fnh;
        this.foc = false;
        this.fnU.clear();
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
        return this.foc;
    }

    public void setDragScrollStart(float f2) {
        setDragScrollStarts(f2, f2);
    }

    public void setDragScrollStarts(float f2, float f3) {
        if (f3 > 0.5f) {
            this.fny = 0.5f;
        } else {
            this.fny = f3;
        }
        if (f2 > 0.5f) {
            this.fnx = 0.5f;
        } else {
            this.fnx = f2;
        }
        if (this.mListView.getHeight() != 0) {
            bAu();
        }
    }

    private void bk(int i2, int i3) {
        this.fnd.x = i2 - this.fno;
        this.fnd.y = i3 - this.fnp;
        kq(true);
        int min = Math.min(i3, this.fnf + this.fnu);
        int max = Math.max(i3, this.fnf - this.fnu);
        int bAz = this.fnw.bAz();
        if (min > this.mLastY && min > this.fnA && bAz != 1) {
            if (bAz != -1) {
                this.fnw.kr(true);
            }
            this.fnw.rH(1);
        } else if (max < this.mLastY && max < this.fnz && bAz != 0) {
            if (bAz != -1) {
                this.fnw.kr(true);
            }
            this.fnw.rH(0);
        } else if (max >= this.fnz && min <= this.fnA && this.fnw.isScrolling()) {
            this.fnw.kr(true);
        }
    }

    private void bAu() {
        int height;
        int paddingTop = this.mListView.getPaddingTop();
        float height2 = (this.mListView.getHeight() - paddingTop) - this.mListView.getPaddingBottom();
        this.fnC = paddingTop + (this.fnx * height2);
        this.fnB = (height2 * (1.0f - this.fny)) + paddingTop;
        this.fnz = (int) this.fnC;
        this.fnA = (int) this.fnB;
        this.fnD = this.fnC - paddingTop;
        this.fnE = (paddingTop + height) - this.fnB;
    }

    private void bAv() {
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
        if (i2 != this.fnn && i2 != this.fnk && i2 != this.fnl) {
            g2 = -2;
        } else {
            g2 = g(i2, view, z);
        }
        if (g2 != layoutParams.height) {
            layoutParams.height = g2;
            view.setLayoutParams(layoutParams);
        }
        if (i2 == this.fnk || i2 == this.fnl) {
            if (i2 < this.fnn) {
                ((DragSortItemView) view).setGravity(80);
            } else if (i2 > this.fnn) {
                ((DragSortItemView) view).setGravity(48);
            }
        }
        int visibility = view.getVisibility();
        int i3 = 0;
        if (i2 == this.fnn && this.fnc != null) {
            i3 = 4;
        }
        if (i3 != visibility) {
            view.setVisibility(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int rG(int i2) {
        View view;
        if (i2 == this.fnn) {
            return 0;
        }
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        if (childAt != null) {
            return f(i2, childAt, false);
        }
        int i3 = this.fnU.get(i2);
        if (i3 == -1) {
            ListAdapter adapter = this.mListView.getAdapter();
            int itemViewType = adapter.getItemViewType(i2);
            int viewTypeCount = adapter.getViewTypeCount();
            if (viewTypeCount != this.fnv.length) {
                this.fnv = new View[viewTypeCount];
            }
            if (itemViewType >= 0) {
                if (this.fnv[itemViewType] == null) {
                    view = adapter.getView(i2, null, this.mListView);
                    this.fnv[itemViewType] = view;
                } else {
                    view = adapter.getView(i2, this.fnv[itemViewType], this.mListView);
                }
            } else {
                view = adapter.getView(i2, null, this.mListView);
            }
            int f2 = f(i2, view, true);
            this.fnU.bm(i2, f2);
            return f2;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(int i2, View view, boolean z) {
        if (i2 == this.fnn) {
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
        return bl(i2, f(i2, view, z));
    }

    private int bl(int i2, int i3) {
        this.mListView.getDividerHeight();
        boolean z = this.fnm && this.fnk != this.fnl;
        int i4 = this.cZw - this.fnt;
        int i5 = (int) (this.fnP * i4);
        if (i2 == this.fnn) {
            if (this.fnn == this.fnk) {
                if (z) {
                    return i5 + this.fnt;
                }
                return this.cZw;
            } else if (this.fnn == this.fnl) {
                return this.cZw - i5;
            } else {
                return this.fnt;
            }
        } else if (i2 == this.fnk) {
            if (z) {
                return i3 + i5;
            }
            return i3 + i4;
        } else if (i2 == this.fnl) {
            return (i3 + i4) - i5;
        } else {
            return i3;
        }
    }

    private int b(int i2, View view, int i3, int i4) {
        int i5;
        int i6;
        int rG = rG(i2);
        int height = view.getHeight();
        int bl = bl(i2, rG);
        if (i2 != this.fnn) {
            i6 = height - rG;
            i5 = bl - rG;
        } else {
            i5 = bl;
            i6 = height;
        }
        int i7 = this.cZw;
        if (this.fnn != this.fnk && this.fnn != this.fnl) {
            i7 -= this.fnt;
        }
        if (i2 <= i3) {
            if (i2 > this.fnk) {
                return (i7 - i5) + 0;
            }
        } else if (i2 == i4) {
            if (i2 <= this.fnk) {
                return (i6 - i7) + 0;
            }
            if (i2 == this.fnl) {
                return (height - bl) + 0;
            }
            return 0 + i6;
        } else if (i2 <= this.fnk) {
            return 0 - i7;
        } else {
            if (i2 == this.fnl) {
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

    private void bAw() {
        if (this.fnc != null) {
            measureItem(this.fnc);
            this.cZw = this.fnc.getMeasuredHeight();
            this.fnu = this.cZw / 2;
        }
    }

    protected boolean onDragTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        switch (motionEvent.getAction() & 255) {
            case 1:
                if (this.mDragState == 4) {
                    stopDrag(false);
                }
                bAt();
                return true;
            case 2:
                bk((int) motionEvent.getX(), (int) motionEvent.getY());
                return true;
            case 3:
                if (this.mDragState == 4) {
                    cancelDrag();
                }
                bAt();
                return true;
            default:
                return true;
        }
    }

    public boolean startDrag(int i2, int i3, int i4, int i5) {
        View rI;
        if (!this.fnK || this.fnL == null || (rI = this.fnL.rI(i2)) == null) {
            return false;
        }
        return startDrag(i2, rI, i3, i4, i5);
    }

    public boolean startDrag(int i2, View view, int i3, int i4, int i5) {
        if (this.mDragState == 0 && this.fnK && this.fnc == null && view != null && this.dra) {
            if (this.mListView.getParent() != null) {
                this.mListView.getParent().requestDisallowInterceptTouchEvent(true);
            }
            int headerViewsCount = this.mListView.getHeaderViewsCount() + i2;
            this.fnk = headerViewsCount;
            this.fnl = headerViewsCount;
            this.fnn = headerViewsCount;
            this.fnj = headerViewsCount;
            this.mDragState = 4;
            this.fnI = 0;
            this.fnI |= i3;
            this.fnc = view;
            bAw();
            this.fno = i4;
            this.fnp = i5;
            this.fnH = this.mY;
            this.fnd.x = this.mX - this.fno;
            this.fnd.y = this.mY - this.fnp;
            View childAt = this.mListView.getChildAt(this.fnn - this.mListView.getFirstVisiblePosition());
            if (childAt != null) {
                childAt.setVisibility(4);
            }
            if (this.fnR) {
                this.fnS.bAA();
            }
            switch (this.fnN) {
                case 1:
                    this.foa.onTouchEvent(this.fnM);
                    break;
                case 2:
                    this.foa.onInterceptTouchEvent(this.fnM);
                    break;
            }
            this.mListView.requestLayout();
            if (this.fnW != null) {
                this.fnW.start();
                return true;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kq(boolean z) {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition() + (this.mListView.getChildCount() / 2);
        View childAt = this.mListView.getChildAt(this.mListView.getChildCount() / 2);
        if (childAt != null) {
            h(firstVisiblePosition, childAt, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i2, View view, boolean z) {
        this.mBlockLayoutRequests = true;
        bAx();
        int i3 = this.fnk;
        int i4 = this.fnl;
        boolean bAo = bAo();
        if (bAo) {
            bAv();
            this.mListView.setSelectionFromTop(i2, (b(i2, view, i3, i4) + view.getTop()) - this.mListView.getPaddingTop());
            layoutChildren();
        }
        if (bAo || z) {
            this.mListView.invalidate();
        }
        this.mBlockLayoutRequests = false;
    }

    private void bAx() {
        if (this.fnL != null) {
            this.fne.set(this.mX, this.mY);
            this.fnL.b(this.fnc, this.fnd, this.fne);
        }
        int i2 = this.fnd.x;
        int i3 = this.fnd.y;
        int paddingLeft = this.mListView.getPaddingLeft();
        if ((this.fnI & 1) == 0 && i2 > paddingLeft) {
            this.fnd.x = paddingLeft;
        } else if ((this.fnI & 2) == 0 && i2 < paddingLeft) {
            this.fnd.x = paddingLeft;
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int lastVisiblePosition = this.mListView.getLastVisiblePosition();
        int paddingTop = this.mListView.getPaddingTop();
        if (firstVisiblePosition < headerViewsCount) {
            paddingTop = this.mListView.getChildAt((headerViewsCount - firstVisiblePosition) - 1).getBottom();
        }
        if ((this.fnI & 8) == 0 && firstVisiblePosition <= this.fnn) {
            paddingTop = Math.max(this.mListView.getChildAt(this.fnn - firstVisiblePosition).getTop(), paddingTop);
        }
        int height = this.mListView.getHeight() - this.mListView.getPaddingBottom();
        if (lastVisiblePosition >= (this.mListView.getCount() - footerViewsCount) - 1) {
            height = this.mListView.getChildAt(((this.mListView.getCount() - footerViewsCount) - 1) - firstVisiblePosition).getBottom();
        }
        if ((this.fnI & 4) == 0 && lastVisiblePosition >= this.fnn) {
            height = Math.min(this.mListView.getChildAt(this.fnn - firstVisiblePosition).getBottom(), height);
        }
        if (i3 < paddingTop) {
            this.fnd.y = paddingTop;
        } else if (this.cZw + i3 > height) {
            this.fnd.y = height - this.cZw;
        }
        this.fnf = this.fnd.y + this.fnu;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAy() {
        if (this.fnc != null) {
            this.fnc.setVisibility(8);
            if (this.fnL != null) {
                this.fnL.bC(this.fnc);
            }
            this.fnc = null;
            this.mListView.invalidate();
        }
    }

    public void a(h hVar) {
        this.fnL = hVar;
    }

    public void a(b bVar) {
        this.fnq = bVar;
    }

    public void setDragEnabled(boolean z) {
        this.dra = z;
    }

    public boolean isDragEnabled() {
        return this.dra;
    }

    public void a(g gVar) {
        this.fnr = gVar;
    }

    public void a(l lVar) {
        this.fns = lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class i {
        private SparseIntArray fow;
        private ArrayList<Integer> fox;
        private int mMaxSize;

        public i(int i) {
            this.fow = new SparseIntArray(i);
            this.fox = new ArrayList<>(i);
            this.mMaxSize = i;
        }

        public void bm(int i, int i2) {
            int i3 = this.fow.get(i, -1);
            if (i3 != i2) {
                if (i3 == -1) {
                    if (this.fow.size() == this.mMaxSize) {
                        this.fow.delete(this.fox.remove(0).intValue());
                    }
                } else {
                    this.fox.remove(Integer.valueOf(i));
                }
                this.fow.put(i, i2);
                this.fox.add(Integer.valueOf(i));
            }
        }

        public int get(int i) {
            return this.fow.get(i, -1);
        }

        public void clear() {
            this.fow.clear();
            this.fox.clear();
        }
    }

    /* renamed from: com.baidu.tbadk.widget.dragsort.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0574a extends BaseAdapter {
        private ListAdapter mAdapter;

        public C0574a(ListAdapter listAdapter) {
            this.mAdapter = listAdapter;
            this.mAdapter.registerDataSetObserver(new DataSetObserver() { // from class: com.baidu.tbadk.widget.dragsort.a.a.1
                @Override // android.database.DataSetObserver
                public void onChanged() {
                    C0574a.this.notifyDataSetChanged();
                }

                @Override // android.database.DataSetObserver
                public void onInvalidated() {
                    C0574a.this.notifyDataSetInvalidated();
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
        private float col;

        /* renamed from: com  reason: collision with root package name */
        private float f3675com;
        private float coo;
        private float cop;
        private float foH;
        private float mAlpha;
        private boolean mCanceled;
        protected long mStartTime;

        public m(float f, int i) {
            this.mAlpha = f;
            this.foH = i;
            float f2 = 1.0f / ((this.mAlpha * 2.0f) * (1.0f - this.mAlpha));
            this.cop = f2;
            this.col = f2;
            this.f3675com = this.mAlpha / ((this.mAlpha - 1.0f) * 2.0f);
            this.coo = 1.0f / (1.0f - this.mAlpha);
        }

        public float ai(float f) {
            if (f < this.mAlpha) {
                return this.col * f * f;
            }
            if (f < 1.0f - this.mAlpha) {
                return this.f3675com + (this.coo * f);
            }
            return 1.0f - ((this.cop * (f - 1.0f)) * (f - 1.0f));
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
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / this.foH;
                if (uptimeMillis >= 1.0f) {
                    x(1.0f, 1.0f);
                    onStop();
                    return;
                }
                x(uptimeMillis, ai(uptimeMillis));
                a.this.mListView.post(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class f extends m {
        private int fos;
        private int fot;
        private float fou;
        private float fov;

        public f(float f, int i) {
            super(f, i);
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.fos = a.this.fnj;
            this.fot = a.this.fnn;
            a.this.mDragState = 2;
            this.fou = a.this.fnd.y - bAC();
            this.fov = a.this.fnd.x - a.this.mListView.getPaddingLeft();
        }

        private int bAC() {
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            int dividerHeight = (a.this.fnt + a.this.mListView.getDividerHeight()) / 2;
            View childAt = a.this.mListView.getChildAt(this.fos - firstVisiblePosition);
            if (childAt != null) {
                if (this.fos == this.fot) {
                    return childAt.getTop();
                }
                if (this.fos >= this.fot) {
                    return (childAt.getBottom() + dividerHeight) - a.this.cZw;
                }
                return childAt.getTop() - dividerHeight;
            }
            cancel();
            return -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void x(float f, float f2) {
            int bAC = bAC();
            float paddingLeft = a.this.fnd.x - a.this.mListView.getPaddingLeft();
            float f3 = 1.0f - f2;
            if (f3 < Math.abs((a.this.fnd.y - bAC) / this.fou) || f3 < Math.abs(paddingLeft / this.fov)) {
                a.this.fnd.y = bAC + ((int) (this.fou * f3));
                a.this.fnd.x = a.this.mListView.getPaddingLeft() + ((int) (this.fov * f3));
                a.this.kq(true);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.bAq();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class k extends m {
        private float foA;
        private float foB;
        private float foC;
        private int foD;
        private int foE;
        private int foF;
        private int foG;
        private int fot;

        public k(float f, int i) {
            super(f, i);
            this.foD = -1;
            this.foE = -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.foD = -1;
            this.foE = -1;
            this.foF = a.this.fnk;
            this.foG = a.this.fnl;
            this.fot = a.this.fnn;
            a.this.mDragState = 1;
            this.foA = a.this.fnd.x;
            if (a.this.fnY) {
                float width = a.this.mListView.getWidth() * 2.0f;
                if (a.this.fnZ == 0.0f) {
                    a.this.fnZ = (this.foA >= 0.0f ? 1 : -1) * width;
                    return;
                }
                float f = width * 2.0f;
                if (a.this.fnZ >= 0.0f || a.this.fnZ <= (-f)) {
                    if (a.this.fnZ > 0.0f && a.this.fnZ < f) {
                        a.this.fnZ = f;
                        return;
                    }
                    return;
                }
                a.this.fnZ = -f;
                return;
            }
            a.this.bAy();
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void x(float f, float f2) {
            View childAt;
            float f3 = 1.0f - f2;
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            View childAt2 = a.this.mListView.getChildAt(this.foF - firstVisiblePosition);
            if (a.this.fnY) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / 1000.0f;
                if (uptimeMillis != 0.0f) {
                    float f4 = a.this.fnZ * uptimeMillis;
                    int width = a.this.mListView.getWidth();
                    a.this.fnZ = ((a.this.fnZ > 0.0f ? 1 : -1) * uptimeMillis * width) + a.this.fnZ;
                    this.foA += f4;
                    a.this.fnd.x = (int) this.foA;
                    if (this.foA < width && this.foA > (-width)) {
                        this.mStartTime = SystemClock.uptimeMillis();
                        a.this.kq(true);
                        return;
                    }
                } else {
                    return;
                }
            }
            if (childAt2 != null) {
                if (this.foD == -1) {
                    this.foD = a.this.f(this.foF, childAt2, false);
                    this.foB = childAt2.getHeight() - this.foD;
                }
                int max = Math.max((int) (this.foB * f3), 1);
                ViewGroup.LayoutParams layoutParams = childAt2.getLayoutParams();
                layoutParams.height = max + this.foD;
                childAt2.setLayoutParams(layoutParams);
            }
            if (this.foG != this.foF && (childAt = a.this.mListView.getChildAt(this.foG - firstVisiblePosition)) != null) {
                if (this.foE == -1) {
                    this.foE = a.this.f(this.foG, childAt, false);
                    this.foC = childAt.getHeight() - this.foE;
                }
                int max2 = Math.max((int) (this.foC * f3), 1);
                ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
                layoutParams2.height = max2 + this.foE;
                childAt.setLayoutParams(layoutParams2);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.bAr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class j extends m {
        final /* synthetic */ a foe;
        private float foy;
        private float foz;

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.foy = this.foe.fnp;
            this.foz = this.foe.fnu;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void x(float f, float f2) {
            if (this.foe.mDragState != 4) {
                cancel();
                return;
            }
            this.foe.fnp = (int) ((this.foz * f2) + ((1.0f - f2) * this.foy));
            this.foe.fnd.y = this.foe.mY - this.foe.fnp;
            this.foe.kq(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e {
        StringBuilder mBuilder = new StringBuilder();
        private int fop = 0;
        private int foq = 0;

        /* renamed from: for  reason: not valid java name */
        private boolean f2for = false;
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

        public void bAA() {
            this.mBuilder.append("<DSLVStates>\n");
            this.foq = 0;
            this.f2for = true;
        }

        public void bAB() {
            if (this.f2for) {
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
                this.mBuilder.append("    <FirstExpPos>").append(a.this.fnk).append("</FirstExpPos>\n");
                this.mBuilder.append("    <FirstExpBlankHeight>").append(a.this.rE(a.this.fnk) - a.this.rG(a.this.fnk)).append("</FirstExpBlankHeight>\n");
                this.mBuilder.append("    <SecondExpPos>").append(a.this.fnl).append("</SecondExpPos>\n");
                this.mBuilder.append("    <SecondExpBlankHeight>").append(a.this.rE(a.this.fnl) - a.this.rG(a.this.fnl)).append("</SecondExpBlankHeight>\n");
                this.mBuilder.append("    <SrcPos>").append(a.this.fnn).append("</SrcPos>\n");
                this.mBuilder.append("    <SrcHeight>").append(a.this.cZw + a.this.mListView.getDividerHeight()).append("</SrcHeight>\n");
                this.mBuilder.append("    <ViewHeight>").append(a.this.mListView.getHeight()).append("</ViewHeight>\n");
                this.mBuilder.append("    <LastY>").append(a.this.mLastY).append("</LastY>\n");
                this.mBuilder.append("    <FloatY>").append(a.this.fnf).append("</FloatY>\n");
                this.mBuilder.append("    <ShuffleEdges>");
                for (int i4 = 0; i4 < childCount; i4++) {
                    this.mBuilder.append(a.this.bj(firstVisiblePosition + i4, a.this.mListView.getChildAt(i4).getTop())).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                this.mBuilder.append("</ShuffleEdges>\n");
                this.mBuilder.append("</DSLVState>\n");
                this.fop++;
                if (this.fop > 1000) {
                    flush();
                    this.fop = 0;
                }
            }
        }

        public void flush() {
            if (this.f2for) {
                try {
                    FileWriter fileWriter = new FileWriter(this.mFile, this.foq != 0);
                    fileWriter.write(this.mBuilder.toString());
                    this.mBuilder.delete(0, this.mBuilder.length());
                    fileWriter.flush();
                    fileWriter.close();
                    this.foq++;
                } catch (IOException e) {
                }
            }
        }

        public void stopTracking() {
            if (this.f2for) {
                this.mBuilder.append("</DSLVStates>\n");
                flush();
                this.f2for = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements Runnable {
        private boolean foh;
        private long foi;
        private long foj;
        private int fok;
        private float fol;
        private long fom;
        private int fon;
        private float foo;
        private boolean mScrolling = false;

        public boolean isScrolling() {
            return this.mScrolling;
        }

        public int bAz() {
            if (this.mScrolling) {
                return this.fon;
            }
            return -1;
        }

        public d() {
        }

        public void rH(int i) {
            if (!this.mScrolling) {
                this.foh = false;
                this.mScrolling = true;
                this.fom = SystemClock.uptimeMillis();
                this.foi = this.fom;
                this.fon = i;
                a.this.mListView.post(this);
            }
        }

        public void kr(boolean z) {
            if (z) {
                a.this.mListView.removeCallbacks(this);
                this.mScrolling = false;
                return;
            }
            this.foh = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.foh) {
                int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
                int lastVisiblePosition = a.this.mListView.getLastVisiblePosition();
                int count = a.this.mListView.getCount();
                int paddingTop = a.this.mListView.getPaddingTop();
                int height = (a.this.mListView.getHeight() - paddingTop) - a.this.mListView.getPaddingBottom();
                int min = Math.min(a.this.mY, a.this.fnf + a.this.fnu);
                int max = Math.max(a.this.mY, a.this.fnf - a.this.fnu);
                if (this.fon == 0) {
                    View childAt = a.this.mListView.getChildAt(0);
                    if (childAt == null) {
                        this.mScrolling = false;
                        return;
                    } else if (firstVisiblePosition == 0 && childAt.getTop() == paddingTop) {
                        this.mScrolling = false;
                        return;
                    } else {
                        this.foo = a.this.fnG.b((a.this.fnC - max) / a.this.fnD, this.foi);
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
                        this.foo = -a.this.fnG.b((min - a.this.fnB) / a.this.fnE, this.foi);
                    }
                }
                this.foj = SystemClock.uptimeMillis();
                this.fol = (float) (this.foj - this.foi);
                this.fok = Math.round(this.foo * this.fol);
                if (this.fok >= 0) {
                    this.fok = Math.min(height, this.fok);
                    lastVisiblePosition = firstVisiblePosition;
                } else {
                    this.fok = Math.max(-height, this.fok);
                }
                View childAt3 = a.this.mListView.getChildAt(lastVisiblePosition - firstVisiblePosition);
                int top = childAt3.getTop() + this.fok;
                if (lastVisiblePosition == 0 && top > paddingTop) {
                    top = paddingTop;
                }
                a.this.mBlockLayoutRequests = true;
                a.this.mListView.setSelectionFromTop(lastVisiblePosition, top - paddingTop);
                a.this.layoutChildren();
                a.this.mListView.invalidate();
                a.this.mBlockLayoutRequests = false;
                a.this.h(lastVisiblePosition, childAt3, false);
                this.foi = this.foj;
                a.this.mListView.post(this);
                return;
            }
            this.mScrolling = false;
        }
    }
}
