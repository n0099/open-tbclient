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
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a implements com.baidu.tbadk.widget.dragsort.c {
    private int aYC;
    private int aYD;
    private int aYE;
    private int aYG;
    private int aYH;
    private int aYI;
    private int aYJ;
    private b aYK;
    private g aYL;
    private l aYM;
    private int aYP;
    private int aYQ;
    private d aYS;
    private int aYV;
    private int aYW;
    private float aYX;
    private float aYY;
    private float aYZ;
    private View aYv;
    private int aYy;
    private float aZa;
    private int aZd;
    private int aZe;
    private int aZf;
    private MotionEvent aZk;
    private C0122a aZo;
    private e aZq;
    private k aZt;
    private j aZu;
    private f aZv;
    private boolean aZw;
    private com.baidu.tbadk.widget.dragsort.d aZy;
    private com.baidu.tbadk.widget.dragsort.b aZz;
    private int ayJ;
    private int mLastX;
    private int mLastY;
    private ListView mListView;
    private DataSetObserver mObserver;
    private Point aYw = new Point();
    private Point aYx = new Point();
    private boolean aYz = false;
    private float aYA = 1.0f;
    private float aYB = 1.0f;
    private boolean aYF = false;
    private boolean aYN = true;
    private int mDragState = 0;
    private int aYO = 1;
    private int mWidthMeasureSpec = 0;
    private View[] aYR = new View[1];
    private float aYT = 0.33333334f;
    private float aYU = 0.33333334f;
    private float aZb = 0.5f;
    private c aZc = new c() { // from class: com.baidu.tbadk.widget.dragsort.a.1
        @Override // com.baidu.tbadk.widget.dragsort.a.c
        public float b(float f2, long j2) {
            return a.this.aZb * f2;
        }
    };
    private int aZg = 0;
    private boolean aZh = false;
    private boolean aZi = false;
    private h aZj = null;
    private int aZl = 0;
    private float aZm = 0.25f;
    private float aZn = 0.0f;
    private boolean aZp = false;
    private boolean mBlockLayoutRequests = false;
    private boolean aZr = false;
    private i aZs = new i(3);
    private float aZx = 0.0f;
    private boolean aZA = false;
    private boolean aZB = false;

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
        void T(View view);

        void b(View view, Point point, Point point2);

        View fB(int i);
    }

    /* loaded from: classes.dex */
    public interface l {
        void remove(int i);
    }

    public a(ListView listView, com.baidu.tbadk.widget.dragsort.d dVar) {
        this.aZy = dVar;
        this.mListView = listView;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            this.aZo = new C0122a(listAdapter);
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
            this.aZo = null;
        }
        this.aZy.setAdapter(this.aZo);
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
            if (i2 > this.aYG) {
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
    public int fx(int i2) {
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        return childAt != null ? childAt.getHeight() : N(i2, fz(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int L(int i2, int i3) {
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        if (i2 <= headerViewsCount || i2 >= this.mListView.getCount() - footerViewsCount) {
            return i3;
        }
        int dividerHeight = this.mListView.getDividerHeight();
        int i4 = this.aYP - this.aYO;
        int fz = fz(i2);
        int fx = fx(i2);
        if (this.aYE <= this.aYG) {
            if (i2 == this.aYE && this.aYD != this.aYE) {
                if (i2 == this.aYG) {
                    i3 = (i3 + fx) - this.aYP;
                } else {
                    i3 = ((fx - fz) + i3) - i4;
                }
            } else if (i2 > this.aYE && i2 <= this.aYG) {
                i3 -= i4;
            }
        } else if (i2 > this.aYG && i2 <= this.aYD) {
            i3 += i4;
        } else if (i2 == this.aYE && this.aYD != this.aYE) {
            i3 += fx - fz;
        }
        if (i2 <= this.aYG) {
            return (((this.aYP - dividerHeight) - fz(i2 - 1)) / 2) + i3;
        }
        return (((fz - dividerHeight) - this.aYP) / 2) + i3;
    }

    private boolean Mh() {
        int i2;
        int i3;
        int i4;
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int i5 = this.aYD;
        View childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        if (childAt == null) {
            i5 = firstVisiblePosition + (this.mListView.getChildCount() / 2);
            childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        }
        int top = childAt.getTop();
        int height = childAt.getHeight();
        int L = L(i5, top);
        int dividerHeight = this.mListView.getDividerHeight();
        if (this.aYy >= L) {
            int count = this.mListView.getCount();
            int i6 = height;
            int i7 = top;
            i2 = L;
            i3 = i5;
            i4 = L;
            while (true) {
                if (i3 < count) {
                    if (i3 == count - 1) {
                        i2 = i7 + dividerHeight + i6;
                        break;
                    }
                    i7 += dividerHeight + i6;
                    i6 = fx(i3 + 1);
                    i2 = L(i3 + 1, i7);
                    if (this.aYy < i2) {
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
            i2 = L;
            i3 = i5;
            i4 = L;
            while (true) {
                if (i3 < 0) {
                    break;
                }
                i3--;
                int fx = fx(i3);
                if (i3 == 0) {
                    i2 = (i8 - dividerHeight) - fx;
                    break;
                }
                i8 -= fx + dividerHeight;
                i2 = L(i3, i8);
                if (this.aYy >= i2) {
                    break;
                }
                i4 = i2;
            }
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int i9 = this.aYD;
        int i10 = this.aYE;
        float f2 = this.aZn;
        if (this.aYF) {
            int abs = Math.abs(i2 - i4);
            if (this.aYy >= i2) {
                int i11 = i4;
                i4 = i2;
                i2 = i11;
            }
            int i12 = (int) (abs * this.aZm * 0.5f);
            float f3 = i12;
            int i13 = i4 + i12;
            int i14 = i2 - i12;
            if (this.aYy < i13) {
                this.aYD = i3 - 1;
                this.aYE = i3;
                this.aZn = ((i13 - this.aYy) * 0.5f) / f3;
            } else if (this.aYy < i14) {
                this.aYD = i3;
                this.aYE = i3;
            } else {
                this.aYD = i3;
                this.aYE = i3 + 1;
                this.aZn = (1.0f + ((i2 - this.aYy) / f3)) * 0.5f;
            }
        } else {
            this.aYD = i3;
            this.aYE = i3;
        }
        if (this.aYD < headerViewsCount) {
            this.aYD = headerViewsCount;
            this.aYE = headerViewsCount;
            i3 = headerViewsCount;
        } else if (this.aYE >= this.mListView.getCount() - footerViewsCount) {
            i3 = (this.mListView.getCount() - footerViewsCount) - 1;
            this.aYD = i3;
            this.aYE = i3;
        }
        boolean z = (this.aYD == i9 && this.aYE == i10 && this.aZn == f2) ? false : true;
        if (i3 != this.aYC) {
            if (this.aYK != null) {
                this.aYK.drag(this.aYC - headerViewsCount, i3 - headerViewsCount);
            }
            this.aYC = i3;
            return true;
        }
        return z;
    }

    public void removeItem(int i2) {
        this.aZw = false;
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
            this.aYO = Math.max(1, obtainStyledAttributes.getDimensionPixelSize(d.m.DragSort_collapsed_height, 1));
            this.aZp = obtainStyledAttributes.getBoolean(d.m.DragSort_track_drag_sort, false);
            if (this.aZp) {
                this.aZq = new e();
            }
            this.aYA = obtainStyledAttributes.getFloat(d.m.DragSort_float_alpha, this.aYA);
            this.aYB = this.aYA;
            this.aYN = obtainStyledAttributes.getBoolean(d.m.DragSort_drag_enabled, this.aYN);
            this.aZm = Math.max(0.0f, Math.min(1.0f, 1.0f - obtainStyledAttributes.getFloat(d.m.DragSort_slide_shuffle_speed, 0.75f)));
            this.aYF = this.aZm > 0.0f;
            setDragScrollStart(obtainStyledAttributes.getFloat(d.m.DragSort_drag_scroll_start, this.aYT));
            this.aZb = obtainStyledAttributes.getFloat(d.m.DragSort_max_drag_scroll_speed, this.aZb);
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
                bVar.ck(z);
                bVar.cj(z2);
                bVar.setBackgroundColor(color);
                this.aZj = bVar;
                a(bVar);
            }
            obtainStyledAttributes.recycle();
            i2 = i5;
            i3 = i4;
        }
        this.aYS = new d();
        if (i3 > 0) {
            this.aZt = new k(0.5f, i3);
        }
        if (i2 > 0) {
            this.aZv = new f(0.5f, i2);
        }
        this.aZk = MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
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
        this.aZz = bVar;
        this.mListView.setOnTouchListener(bVar);
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void dispatchDraw(Canvas canvas) {
        float f2;
        this.aZy.dispatchDraw(canvas);
        if (this.mDragState != 0) {
            if (this.aYD != this.aYG) {
                b(this.aYD, canvas);
            }
            if (this.aYE != this.aYD && this.aYE != this.aYG) {
                b(this.aYE, canvas);
            }
        }
        if (this.aYv != null) {
            int width = this.aYv.getWidth();
            int height = this.aYv.getHeight();
            int i2 = this.aYw.x;
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
            int i3 = (int) (f2 * 255.0f * this.aYB);
            canvas.save();
            canvas.translate(this.aYw.x, this.aYw.y);
            canvas.clipRect(0, 0, width, height);
            canvas.saveLayerAlpha(0.0f, 0.0f, width, height, i3, 31);
            this.aYv.draw(canvas);
            canvas.restore();
            canvas.restore();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onDraw(Canvas canvas) {
        this.aZy.onDraw(canvas);
        if (this.aZp) {
            this.aZq.Mu();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.aZr) {
            this.aZr = false;
            return false;
        } else if (!this.aYN) {
            return this.aZy.onTouchEvent(motionEvent);
        } else {
            boolean z2 = this.aZh;
            this.aZh = false;
            if (!z2) {
                t(motionEvent);
            }
            if (this.mDragState == 4) {
                onDragTouchEvent(motionEvent);
                return true;
            }
            if (this.mDragState == 0 && this.aZy.onTouchEvent(motionEvent)) {
                z = true;
            }
            switch (motionEvent.getAction() & 255) {
                case 1:
                case 3:
                    Mm();
                    return z;
                case 2:
                default:
                    if (z) {
                        this.aZl = 1;
                        return z;
                    }
                    return z;
            }
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (!this.aYN) {
            return this.aZy.onInterceptTouchEvent(motionEvent);
        }
        if (this.aZz != null) {
            this.aZz.Mw().onTouchEvent(motionEvent);
        }
        t(motionEvent);
        this.aZh = true;
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            if (this.mDragState != 0) {
                this.aZr = true;
                return true;
            }
            this.aZi = true;
        }
        if (this.aYv == null) {
            if (this.aZy.onInterceptTouchEvent(motionEvent)) {
                this.aZA = true;
                z = true;
            } else {
                z = false;
            }
            switch (action) {
                case 1:
                case 3:
                    Mm();
                    break;
                case 2:
                default:
                    if (z) {
                        this.aZl = 1;
                        break;
                    } else {
                        this.aZl = 2;
                        break;
                    }
            }
        } else {
            z = true;
        }
        if (action == 1 || action == 3) {
            this.aZi = false;
        }
        return z;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        this.aZy.onSizeChanged(i2, i3, i4, i5);
        Mn();
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void requestLayout() {
        if (!this.mBlockLayoutRequests) {
            this.aZy.requestLayout();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onMeasure(int i2, int i3) {
        this.aZy.onMeasure(i2, i3);
        if (this.aYv != null) {
            if (this.aYv.isLayoutRequested()) {
                Mp();
            }
            this.aYz = true;
        }
        this.mWidthMeasureSpec = i2;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void layoutChildren() {
        this.aZy.layoutChildren();
        if (this.aYv != null) {
            if (this.aYv.isLayoutRequested() && !this.aYz) {
                Mp();
            }
            this.aYv.layout(0, 0, this.aYv.getMeasuredWidth(), this.aYv.getMeasuredHeight());
            this.aYz = false;
        }
    }

    public void removeItem(int i2, float f2) {
        if (this.mDragState == 0 || this.mDragState == 4) {
            if (this.mDragState == 0) {
                this.aYG = this.mListView.getHeaderViewsCount() + i2;
                this.aYD = this.aYG;
                this.aYE = this.aYG;
                this.aYC = this.aYG;
                View childAt = this.mListView.getChildAt(this.aYG - this.mListView.getFirstVisiblePosition());
                if (childAt != null) {
                    childAt.setVisibility(4);
                }
            }
            this.mDragState = 1;
            this.aZx = f2;
            if (this.aZi) {
                switch (this.aZl) {
                    case 1:
                        this.aZy.onTouchEvent(this.aZk);
                        break;
                    case 2:
                        this.aZy.onInterceptTouchEvent(this.aZk);
                        break;
                }
            }
            if (this.aZt != null) {
                this.aZt.start();
            } else {
                fy(i2);
            }
        }
    }

    public void cancelDrag() {
        if (this.mDragState == 4) {
            this.aYS.ci(true);
            Mr();
            Mi();
            Mo();
            if (this.aZi) {
                this.mDragState = 3;
            } else {
                this.mDragState = 0;
            }
        }
    }

    private void Mi() {
        this.aYG = -1;
        this.aYD = -1;
        this.aYE = -1;
        this.aYC = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mj() {
        this.mDragState = 2;
        if (this.aYL != null && this.aYC >= 0 && this.aYC < this.mListView.getCount()) {
            int headerViewsCount = this.mListView.getHeaderViewsCount();
            this.aYL.drop(this.aYG - headerViewsCount, this.aYC - headerViewsCount);
        }
        Mr();
        Ml();
        Mi();
        Mo();
        if (this.aZi) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mk() {
        fy(this.aYG - this.mListView.getHeaderViewsCount());
    }

    private void fy(int i2) {
        this.mDragState = 1;
        if (this.aYM != null) {
            this.aYM.remove(i2);
        }
        Mr();
        Ml();
        Mi();
        if (this.aZi) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    private void Ml() {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        if (this.aYG < firstVisiblePosition) {
            View childAt = this.mListView.getChildAt(0);
            this.mListView.setSelectionFromTop(firstVisiblePosition - 1, (childAt != null ? childAt.getTop() : 0) - this.mListView.getPaddingTop());
        }
    }

    public boolean stopDrag(boolean z) {
        this.aZw = false;
        return stopDrag(z, 0.0f);
    }

    public boolean stopDragWithVelocity(boolean z, float f2) {
        this.aZw = true;
        return stopDrag(z, f2);
    }

    public boolean stopDrag(boolean z, float f2) {
        if (this.aYv != null) {
            this.aYS.ci(true);
            if (z) {
                removeItem(this.aYG - this.mListView.getHeaderViewsCount(), f2);
            } else if (this.aZv != null) {
                this.aZv.start();
            } else {
                Mj();
            }
            if (this.aZp) {
                this.aZq.mU();
                return true;
            }
            return true;
        }
        return false;
    }

    private void Mm() {
        this.aZl = 0;
        this.aZi = false;
        if (this.mDragState == 3) {
            this.mDragState = 0;
        }
        this.aYB = this.aYA;
        this.aZA = false;
        this.aZs.clear();
    }

    private void t(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            this.mLastX = this.aZd;
            this.mLastY = this.aZe;
        }
        this.aZd = (int) motionEvent.getX();
        this.aZe = (int) motionEvent.getY();
        if (action == 0) {
            this.mLastX = this.aZd;
            this.mLastY = this.aZe;
        }
        this.aYJ = ((int) motionEvent.getRawX()) - this.aZd;
        this.ayJ = ((int) motionEvent.getRawY()) - this.aZe;
    }

    public boolean listViewIntercepted() {
        return this.aZA;
    }

    public void setDragScrollStart(float f2) {
        setDragScrollStarts(f2, f2);
    }

    public void setDragScrollStarts(float f2, float f3) {
        if (f3 > 0.5f) {
            this.aYU = 0.5f;
        } else {
            this.aYU = f3;
        }
        if (f2 > 0.5f) {
            this.aYT = 0.5f;
        } else {
            this.aYT = f2;
        }
        if (this.mListView.getHeight() != 0) {
            Mn();
        }
    }

    private void M(int i2, int i3) {
        this.aYw.x = i2 - this.aYH;
        this.aYw.y = i3 - this.aYI;
        ch(true);
        int min = Math.min(i3, this.aYy + this.aYQ);
        int max = Math.max(i3, this.aYy - this.aYQ);
        int Mt = this.aYS.Mt();
        if (min > this.mLastY && min > this.aYW && Mt != 1) {
            if (Mt != -1) {
                this.aYS.ci(true);
            }
            this.aYS.fA(1);
        } else if (max < this.mLastY && max < this.aYV && Mt != 0) {
            if (Mt != -1) {
                this.aYS.ci(true);
            }
            this.aYS.fA(0);
        } else if (max >= this.aYV && min <= this.aYW && this.aYS.Ms()) {
            this.aYS.ci(true);
        }
    }

    private void Mn() {
        int height;
        int paddingTop = this.mListView.getPaddingTop();
        float height2 = (this.mListView.getHeight() - paddingTop) - this.mListView.getPaddingBottom();
        this.aYY = paddingTop + (this.aYT * height2);
        this.aYX = (height2 * (1.0f - this.aYU)) + paddingTop;
        this.aYV = (int) this.aYY;
        this.aYW = (int) this.aYX;
        this.aYZ = this.aYY - paddingTop;
        this.aZa = (paddingTop + height) - this.aYX;
    }

    private void Mo() {
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
        if (i2 != this.aYG && i2 != this.aYD && i2 != this.aYE) {
            g2 = -2;
        } else {
            g2 = g(i2, view, z);
        }
        if (g2 != layoutParams.height) {
            layoutParams.height = g2;
            view.setLayoutParams(layoutParams);
        }
        if (i2 == this.aYD || i2 == this.aYE) {
            if (i2 < this.aYG) {
                ((DragSortItemView) view).setGravity(80);
            } else if (i2 > this.aYG) {
                ((DragSortItemView) view).setGravity(48);
            }
        }
        int visibility = view.getVisibility();
        int i3 = 0;
        if (i2 == this.aYG && this.aYv != null) {
            i3 = 4;
        }
        if (i3 != visibility) {
            view.setVisibility(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int fz(int i2) {
        View view;
        if (i2 == this.aYG) {
            return 0;
        }
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        if (childAt != null) {
            return f(i2, childAt, false);
        }
        int i3 = this.aZs.get(i2);
        if (i3 == -1) {
            ListAdapter adapter = this.mListView.getAdapter();
            int itemViewType = adapter.getItemViewType(i2);
            int viewTypeCount = adapter.getViewTypeCount();
            if (viewTypeCount != this.aYR.length) {
                this.aYR = new View[viewTypeCount];
            }
            if (itemViewType >= 0) {
                if (this.aYR[itemViewType] == null) {
                    view = adapter.getView(i2, null, this.mListView);
                    this.aYR[itemViewType] = view;
                } else {
                    view = adapter.getView(i2, this.aYR[itemViewType], this.mListView);
                }
            } else {
                view = adapter.getView(i2, null, this.mListView);
            }
            int f2 = f(i2, view, true);
            this.aZs.add(i2, f2);
            return f2;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(int i2, View view, boolean z) {
        if (i2 == this.aYG) {
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
        return N(i2, f(i2, view, z));
    }

    private int N(int i2, int i3) {
        this.mListView.getDividerHeight();
        boolean z = this.aYF && this.aYD != this.aYE;
        int i4 = this.aYP - this.aYO;
        int i5 = (int) (this.aZn * i4);
        if (i2 == this.aYG) {
            if (this.aYG == this.aYD) {
                if (z) {
                    return i5 + this.aYO;
                }
                return this.aYP;
            } else if (this.aYG == this.aYE) {
                return this.aYP - i5;
            } else {
                return this.aYO;
            }
        } else if (i2 == this.aYD) {
            if (z) {
                return i3 + i5;
            }
            return i3 + i4;
        } else if (i2 == this.aYE) {
            return (i3 + i4) - i5;
        } else {
            return i3;
        }
    }

    private int b(int i2, View view, int i3, int i4) {
        int i5;
        int i6;
        int fz = fz(i2);
        int height = view.getHeight();
        int N = N(i2, fz);
        if (i2 != this.aYG) {
            i6 = height - fz;
            i5 = N - fz;
        } else {
            i5 = N;
            i6 = height;
        }
        int i7 = this.aYP;
        if (this.aYG != this.aYD && this.aYG != this.aYE) {
            i7 -= this.aYO;
        }
        if (i2 <= i3) {
            if (i2 > this.aYD) {
                return (i7 - i5) + 0;
            }
        } else if (i2 == i4) {
            if (i2 <= this.aYD) {
                return (i6 - i7) + 0;
            }
            if (i2 == this.aYE) {
                return (height - N) + 0;
            }
            return 0 + i6;
        } else if (i2 <= this.aYD) {
            return 0 - i7;
        } else {
            if (i2 == this.aYE) {
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

    private void Mp() {
        if (this.aYv != null) {
            measureItem(this.aYv);
            this.aYP = this.aYv.getMeasuredHeight();
            this.aYQ = this.aYP / 2;
        }
    }

    protected boolean onDragTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        switch (motionEvent.getAction() & 255) {
            case 1:
                if (this.mDragState == 4) {
                    stopDrag(false);
                }
                Mm();
                return true;
            case 2:
                M((int) motionEvent.getX(), (int) motionEvent.getY());
                return true;
            case 3:
                if (this.mDragState == 4) {
                    cancelDrag();
                }
                Mm();
                return true;
            default:
                return true;
        }
    }

    public boolean startDrag(int i2, int i3, int i4, int i5) {
        View fB;
        if (!this.aZi || this.aZj == null || (fB = this.aZj.fB(i2)) == null) {
            return false;
        }
        return startDrag(i2, fB, i3, i4, i5);
    }

    public boolean startDrag(int i2, View view, int i3, int i4, int i5) {
        if (this.mDragState == 0 && this.aZi && this.aYv == null && view != null && this.aYN) {
            if (this.mListView.getParent() != null) {
                this.mListView.getParent().requestDisallowInterceptTouchEvent(true);
            }
            int headerViewsCount = this.mListView.getHeaderViewsCount() + i2;
            this.aYD = headerViewsCount;
            this.aYE = headerViewsCount;
            this.aYG = headerViewsCount;
            this.aYC = headerViewsCount;
            this.mDragState = 4;
            this.aZg = 0;
            this.aZg |= i3;
            this.aYv = view;
            Mp();
            this.aYH = i4;
            this.aYI = i5;
            this.aZf = this.aZe;
            this.aYw.x = this.aZd - this.aYH;
            this.aYw.y = this.aZe - this.aYI;
            View childAt = this.mListView.getChildAt(this.aYG - this.mListView.getFirstVisiblePosition());
            if (childAt != null) {
                childAt.setVisibility(4);
            }
            if (this.aZp) {
                this.aZq.startTracking();
            }
            switch (this.aZl) {
                case 1:
                    this.aZy.onTouchEvent(this.aZk);
                    break;
                case 2:
                    this.aZy.onInterceptTouchEvent(this.aZk);
                    break;
            }
            this.mListView.requestLayout();
            if (this.aZu != null) {
                this.aZu.start();
                return true;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ch(boolean z) {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition() + (this.mListView.getChildCount() / 2);
        View childAt = this.mListView.getChildAt(this.mListView.getChildCount() / 2);
        if (childAt != null) {
            h(firstVisiblePosition, childAt, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i2, View view, boolean z) {
        this.mBlockLayoutRequests = true;
        Mq();
        int i3 = this.aYD;
        int i4 = this.aYE;
        boolean Mh = Mh();
        if (Mh) {
            Mo();
            this.mListView.setSelectionFromTop(i2, (b(i2, view, i3, i4) + view.getTop()) - this.mListView.getPaddingTop());
            layoutChildren();
        }
        if (Mh || z) {
            this.mListView.invalidate();
        }
        this.mBlockLayoutRequests = false;
    }

    private void Mq() {
        if (this.aZj != null) {
            this.aYx.set(this.aZd, this.aZe);
            this.aZj.b(this.aYv, this.aYw, this.aYx);
        }
        int i2 = this.aYw.x;
        int i3 = this.aYw.y;
        int paddingLeft = this.mListView.getPaddingLeft();
        if ((this.aZg & 1) == 0 && i2 > paddingLeft) {
            this.aYw.x = paddingLeft;
        } else if ((this.aZg & 2) == 0 && i2 < paddingLeft) {
            this.aYw.x = paddingLeft;
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int lastVisiblePosition = this.mListView.getLastVisiblePosition();
        int paddingTop = this.mListView.getPaddingTop();
        if (firstVisiblePosition < headerViewsCount) {
            paddingTop = this.mListView.getChildAt((headerViewsCount - firstVisiblePosition) - 1).getBottom();
        }
        if ((this.aZg & 8) == 0 && firstVisiblePosition <= this.aYG) {
            paddingTop = Math.max(this.mListView.getChildAt(this.aYG - firstVisiblePosition).getTop(), paddingTop);
        }
        int height = this.mListView.getHeight() - this.mListView.getPaddingBottom();
        if (lastVisiblePosition >= (this.mListView.getCount() - footerViewsCount) - 1) {
            height = this.mListView.getChildAt(((this.mListView.getCount() - footerViewsCount) - 1) - firstVisiblePosition).getBottom();
        }
        if ((this.aZg & 4) == 0 && lastVisiblePosition >= this.aYG) {
            height = Math.min(this.mListView.getChildAt(this.aYG - firstVisiblePosition).getBottom(), height);
        }
        if (i3 < paddingTop) {
            this.aYw.y = paddingTop;
        } else if (this.aYP + i3 > height) {
            this.aYw.y = height - this.aYP;
        }
        this.aYy = this.aYw.y + this.aYQ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mr() {
        if (this.aYv != null) {
            this.aYv.setVisibility(8);
            if (this.aZj != null) {
                this.aZj.T(this.aYv);
            }
            this.aYv = null;
            this.mListView.invalidate();
        }
    }

    public void a(h hVar) {
        this.aZj = hVar;
    }

    public void a(b bVar) {
        this.aYK = bVar;
    }

    public void setDragEnabled(boolean z) {
        this.aYN = z;
    }

    public boolean isDragEnabled() {
        return this.aYN;
    }

    public void a(g gVar) {
        this.aYL = gVar;
    }

    public void a(l lVar) {
        this.aYM = lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class i {
        private SparseIntArray aZU;
        private ArrayList<Integer> aZV;
        private int mMaxSize;

        public i(int i) {
            this.aZU = new SparseIntArray(i);
            this.aZV = new ArrayList<>(i);
            this.mMaxSize = i;
        }

        public void add(int i, int i2) {
            int i3 = this.aZU.get(i, -1);
            if (i3 != i2) {
                if (i3 == -1) {
                    if (this.aZU.size() == this.mMaxSize) {
                        this.aZU.delete(this.aZV.remove(0).intValue());
                    }
                } else {
                    this.aZV.remove(Integer.valueOf(i));
                }
                this.aZU.put(i, i2);
                this.aZV.add(Integer.valueOf(i));
            }
        }

        public int get(int i) {
            return this.aZU.get(i, -1);
        }

        public void clear() {
            this.aZU.clear();
            this.aZV.clear();
        }
    }

    /* renamed from: com.baidu.tbadk.widget.dragsort.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0122a extends BaseAdapter {
        private ListAdapter mAdapter;

        public C0122a(ListAdapter listAdapter) {
            this.mAdapter = listAdapter;
            this.mAdapter.registerDataSetObserver(new DataSetObserver() { // from class: com.baidu.tbadk.widget.dragsort.a.a.1
                @Override // android.database.DataSetObserver
                public void onChanged() {
                    C0122a.this.notifyDataSetChanged();
                }

                @Override // android.database.DataSetObserver
                public void onInvalidated() {
                    C0122a.this.notifyDataSetInvalidated();
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
        private float baf;
        private float bag;
        private float bah;
        private float bai;
        private float baj;
        private float mAlpha;
        private boolean mCanceled;
        protected long mStartTime;

        public m(float f, int i) {
            this.mAlpha = f;
            this.baf = i;
            float f2 = 1.0f / ((this.mAlpha * 2.0f) * (1.0f - this.mAlpha));
            this.baj = f2;
            this.bag = f2;
            this.bah = this.mAlpha / ((this.mAlpha - 1.0f) * 2.0f);
            this.bai = 1.0f / (1.0f - this.mAlpha);
        }

        public float Z(float f) {
            if (f < this.mAlpha) {
                return this.bag * f * f;
            }
            if (f < 1.0f - this.mAlpha) {
                return this.bah + (this.bai * f);
            }
            return 1.0f - ((this.baj * (f - 1.0f)) * (f - 1.0f));
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
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / this.baf;
                if (uptimeMillis >= 1.0f) {
                    n(1.0f, 1.0f);
                    onStop();
                    return;
                }
                n(uptimeMillis, Z(uptimeMillis));
                a.this.mListView.post(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class f extends m {
        private int aZQ;
        private int aZR;
        private float aZS;
        private float aZT;

        public f(float f, int i) {
            super(f, i);
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.aZQ = a.this.aYC;
            this.aZR = a.this.aYG;
            a.this.mDragState = 2;
            this.aZS = a.this.aYw.y - Mv();
            this.aZT = a.this.aYw.x - a.this.mListView.getPaddingLeft();
        }

        private int Mv() {
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            int dividerHeight = (a.this.aYO + a.this.mListView.getDividerHeight()) / 2;
            View childAt = a.this.mListView.getChildAt(this.aZQ - firstVisiblePosition);
            if (childAt != null) {
                if (this.aZQ == this.aZR) {
                    return childAt.getTop();
                }
                if (this.aZQ >= this.aZR) {
                    return (childAt.getBottom() + dividerHeight) - a.this.aYP;
                }
                return childAt.getTop() - dividerHeight;
            }
            cancel();
            return -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void n(float f, float f2) {
            int Mv = Mv();
            float paddingLeft = a.this.aYw.x - a.this.mListView.getPaddingLeft();
            float f3 = 1.0f - f2;
            if (f3 < Math.abs((a.this.aYw.y - Mv) / this.aZS) || f3 < Math.abs(paddingLeft / this.aZT)) {
                a.this.aYw.y = Mv + ((int) (this.aZS * f3));
                a.this.aYw.x = a.this.mListView.getPaddingLeft() + ((int) (this.aZT * f3));
                a.this.ch(true);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.Mj();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class k extends m {
        private int aZR;
        private float aZY;
        private float aZZ;
        private float baa;
        private int bab;
        private int bac;
        private int bad;
        private int bae;

        public k(float f, int i) {
            super(f, i);
            this.bab = -1;
            this.bac = -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.bab = -1;
            this.bac = -1;
            this.bad = a.this.aYD;
            this.bae = a.this.aYE;
            this.aZR = a.this.aYG;
            a.this.mDragState = 1;
            this.aZY = a.this.aYw.x;
            if (a.this.aZw) {
                float width = a.this.mListView.getWidth() * 2.0f;
                if (a.this.aZx == 0.0f) {
                    a.this.aZx = (this.aZY >= 0.0f ? 1 : -1) * width;
                    return;
                }
                float f = width * 2.0f;
                if (a.this.aZx >= 0.0f || a.this.aZx <= (-f)) {
                    if (a.this.aZx > 0.0f && a.this.aZx < f) {
                        a.this.aZx = f;
                        return;
                    }
                    return;
                }
                a.this.aZx = -f;
                return;
            }
            a.this.Mr();
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void n(float f, float f2) {
            View childAt;
            float f3 = 1.0f - f2;
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            View childAt2 = a.this.mListView.getChildAt(this.bad - firstVisiblePosition);
            if (a.this.aZw) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / 1000.0f;
                if (uptimeMillis != 0.0f) {
                    float f4 = a.this.aZx * uptimeMillis;
                    int width = a.this.mListView.getWidth();
                    a.this.aZx = ((a.this.aZx > 0.0f ? 1 : -1) * uptimeMillis * width) + a.this.aZx;
                    this.aZY += f4;
                    a.this.aYw.x = (int) this.aZY;
                    if (this.aZY < width && this.aZY > (-width)) {
                        this.mStartTime = SystemClock.uptimeMillis();
                        a.this.ch(true);
                        return;
                    }
                } else {
                    return;
                }
            }
            if (childAt2 != null) {
                if (this.bab == -1) {
                    this.bab = a.this.f(this.bad, childAt2, false);
                    this.aZZ = childAt2.getHeight() - this.bab;
                }
                int max = Math.max((int) (this.aZZ * f3), 1);
                ViewGroup.LayoutParams layoutParams = childAt2.getLayoutParams();
                layoutParams.height = max + this.bab;
                childAt2.setLayoutParams(layoutParams);
            }
            if (this.bae != this.bad && (childAt = a.this.mListView.getChildAt(this.bae - firstVisiblePosition)) != null) {
                if (this.bac == -1) {
                    this.bac = a.this.f(this.bae, childAt, false);
                    this.baa = childAt.getHeight() - this.bac;
                }
                int max2 = Math.max((int) (this.baa * f3), 1);
                ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
                layoutParams2.height = max2 + this.bac;
                childAt.setLayoutParams(layoutParams2);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.Mk();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class j extends m {
        final /* synthetic */ a aZC;
        private float aZW;
        private float aZX;

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.aZW = this.aZC.aYI;
            this.aZX = this.aZC.aYQ;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void n(float f, float f2) {
            if (this.aZC.mDragState != 4) {
                cancel();
                return;
            }
            this.aZC.aYI = (int) ((this.aZX * f2) + ((1.0f - f2) * this.aZW));
            this.aZC.aYw.y = this.aZC.aZe - this.aZC.aYI;
            this.aZC.ch(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e {
        StringBuilder mBuilder = new StringBuilder();
        private int aZN = 0;
        private int aZO = 0;
        private boolean aZP = false;
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
            this.aZO = 0;
            this.aZP = true;
        }

        public void Mu() {
            if (this.aZP) {
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
                this.mBuilder.append("    <FirstExpPos>").append(a.this.aYD).append("</FirstExpPos>\n");
                this.mBuilder.append("    <FirstExpBlankHeight>").append(a.this.fx(a.this.aYD) - a.this.fz(a.this.aYD)).append("</FirstExpBlankHeight>\n");
                this.mBuilder.append("    <SecondExpPos>").append(a.this.aYE).append("</SecondExpPos>\n");
                this.mBuilder.append("    <SecondExpBlankHeight>").append(a.this.fx(a.this.aYE) - a.this.fz(a.this.aYE)).append("</SecondExpBlankHeight>\n");
                this.mBuilder.append("    <SrcPos>").append(a.this.aYG).append("</SrcPos>\n");
                this.mBuilder.append("    <SrcHeight>").append(a.this.aYP + a.this.mListView.getDividerHeight()).append("</SrcHeight>\n");
                this.mBuilder.append("    <ViewHeight>").append(a.this.mListView.getHeight()).append("</ViewHeight>\n");
                this.mBuilder.append("    <LastY>").append(a.this.mLastY).append("</LastY>\n");
                this.mBuilder.append("    <FloatY>").append(a.this.aYy).append("</FloatY>\n");
                this.mBuilder.append("    <ShuffleEdges>");
                for (int i4 = 0; i4 < childCount; i4++) {
                    this.mBuilder.append(a.this.L(firstVisiblePosition + i4, a.this.mListView.getChildAt(i4).getTop())).append(",");
                }
                this.mBuilder.append("</ShuffleEdges>\n");
                this.mBuilder.append("</DSLVState>\n");
                this.aZN++;
                if (this.aZN > 1000) {
                    flush();
                    this.aZN = 0;
                }
            }
        }

        public void flush() {
            if (this.aZP) {
                try {
                    FileWriter fileWriter = new FileWriter(this.mFile, this.aZO != 0);
                    fileWriter.write(this.mBuilder.toString());
                    this.mBuilder.delete(0, this.mBuilder.length());
                    fileWriter.flush();
                    fileWriter.close();
                    this.aZO++;
                } catch (IOException e) {
                }
            }
        }

        public void mU() {
            if (this.aZP) {
                this.mBuilder.append("</DSLVStates>\n");
                flush();
                this.aZP = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements Runnable {
        private boolean aZF;
        private long aZG;
        private long aZH;
        private float aZI;
        private long aZJ;
        private int aZK;
        private float aZL;
        private boolean aZM = false;
        private int dy;

        public boolean Ms() {
            return this.aZM;
        }

        public int Mt() {
            if (this.aZM) {
                return this.aZK;
            }
            return -1;
        }

        public d() {
        }

        public void fA(int i) {
            if (!this.aZM) {
                this.aZF = false;
                this.aZM = true;
                this.aZJ = SystemClock.uptimeMillis();
                this.aZG = this.aZJ;
                this.aZK = i;
                a.this.mListView.post(this);
            }
        }

        public void ci(boolean z) {
            if (z) {
                a.this.mListView.removeCallbacks(this);
                this.aZM = false;
                return;
            }
            this.aZF = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.aZF) {
                int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
                int lastVisiblePosition = a.this.mListView.getLastVisiblePosition();
                int count = a.this.mListView.getCount();
                int paddingTop = a.this.mListView.getPaddingTop();
                int height = (a.this.mListView.getHeight() - paddingTop) - a.this.mListView.getPaddingBottom();
                int min = Math.min(a.this.aZe, a.this.aYy + a.this.aYQ);
                int max = Math.max(a.this.aZe, a.this.aYy - a.this.aYQ);
                if (this.aZK == 0) {
                    View childAt = a.this.mListView.getChildAt(0);
                    if (childAt == null) {
                        this.aZM = false;
                        return;
                    } else if (firstVisiblePosition == 0 && childAt.getTop() == paddingTop) {
                        this.aZM = false;
                        return;
                    } else {
                        this.aZL = a.this.aZc.b((a.this.aYY - max) / a.this.aYZ, this.aZG);
                    }
                } else {
                    View childAt2 = a.this.mListView.getChildAt(lastVisiblePosition - firstVisiblePosition);
                    if (childAt2 == null) {
                        this.aZM = false;
                        return;
                    } else if (lastVisiblePosition == count - 1 && childAt2.getBottom() <= height + paddingTop) {
                        this.aZM = false;
                        return;
                    } else {
                        this.aZL = -a.this.aZc.b((min - a.this.aYX) / a.this.aZa, this.aZG);
                    }
                }
                this.aZH = SystemClock.uptimeMillis();
                this.aZI = (float) (this.aZH - this.aZG);
                this.dy = Math.round(this.aZL * this.aZI);
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
                this.aZG = this.aZH;
                a.this.mListView.post(this);
                return;
            }
            this.aZM = false;
        }
    }
}
