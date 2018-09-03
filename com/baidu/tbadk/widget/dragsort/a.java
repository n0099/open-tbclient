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
import com.baidu.tieba.f;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a implements com.baidu.tbadk.widget.dragsort.c {
    private View aYB;
    private int aYE;
    private int aYI;
    private int aYJ;
    private int aYK;
    private int aYM;
    private int aYN;
    private int aYO;
    private int aYP;
    private b aYQ;
    private g aYR;
    private l aYS;
    private int aYV;
    private int aYW;
    private d aYY;
    private j aZA;
    private f aZB;
    private boolean aZC;
    private com.baidu.tbadk.widget.dragsort.d aZE;
    private com.baidu.tbadk.widget.dragsort.b aZF;
    private int aZb;
    private int aZc;
    private float aZd;
    private float aZe;
    private float aZf;
    private float aZg;
    private int aZj;
    private int aZk;
    private int aZl;
    private MotionEvent aZq;
    private C0119a aZu;
    private e aZw;
    private k aZz;
    private int ayt;
    private int mLastX;
    private int mLastY;
    private ListView mListView;
    private DataSetObserver mObserver;
    private Point aYC = new Point();
    private Point aYD = new Point();
    private boolean aYF = false;
    private float aYG = 1.0f;
    private float aYH = 1.0f;
    private boolean aYL = false;
    private boolean aYT = true;
    private int mDragState = 0;
    private int aYU = 1;
    private int mWidthMeasureSpec = 0;
    private View[] aYX = new View[1];
    private float aYZ = 0.33333334f;
    private float aZa = 0.33333334f;
    private float aZh = 0.5f;
    private c aZi = new c() { // from class: com.baidu.tbadk.widget.dragsort.a.1
        @Override // com.baidu.tbadk.widget.dragsort.a.c
        public float b(float f2, long j2) {
            return a.this.aZh * f2;
        }
    };
    private int aZm = 0;
    private boolean aZn = false;
    private boolean aZo = false;
    private h aZp = null;
    private int aZr = 0;
    private float aZs = 0.25f;
    private float aZt = 0.0f;
    private boolean aZv = false;
    private boolean mBlockLayoutRequests = false;
    private boolean aZx = false;
    private i aZy = new i(3);
    private float aZD = 0.0f;
    private boolean aZG = false;
    private boolean aZH = false;

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
        this.aZE = dVar;
        this.mListView = listView;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            this.aZu = new C0119a(listAdapter);
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
            this.aZu = null;
        }
        this.aZE.setAdapter(this.aZu);
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
            if (i2 > this.aYM) {
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
        return childAt != null ? childAt.getHeight() : O(i2, fz(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int M(int i2, int i3) {
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        if (i2 <= headerViewsCount || i2 >= this.mListView.getCount() - footerViewsCount) {
            return i3;
        }
        int dividerHeight = this.mListView.getDividerHeight();
        int i4 = this.aYV - this.aYU;
        int fz = fz(i2);
        int fx = fx(i2);
        if (this.aYK <= this.aYM) {
            if (i2 == this.aYK && this.aYJ != this.aYK) {
                if (i2 == this.aYM) {
                    i3 = (i3 + fx) - this.aYV;
                } else {
                    i3 = ((fx - fz) + i3) - i4;
                }
            } else if (i2 > this.aYK && i2 <= this.aYM) {
                i3 -= i4;
            }
        } else if (i2 > this.aYM && i2 <= this.aYJ) {
            i3 += i4;
        } else if (i2 == this.aYK && this.aYJ != this.aYK) {
            i3 += fx - fz;
        }
        if (i2 <= this.aYM) {
            return (((this.aYV - dividerHeight) - fz(i2 - 1)) / 2) + i3;
        }
        return (((fz - dividerHeight) - this.aYV) / 2) + i3;
    }

    private boolean Mh() {
        int i2;
        int i3;
        int i4;
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int i5 = this.aYJ;
        View childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        if (childAt == null) {
            i5 = firstVisiblePosition + (this.mListView.getChildCount() / 2);
            childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        }
        int top = childAt.getTop();
        int height = childAt.getHeight();
        int M = M(i5, top);
        int dividerHeight = this.mListView.getDividerHeight();
        if (this.aYE >= M) {
            int count = this.mListView.getCount();
            int i6 = height;
            int i7 = top;
            i2 = M;
            i3 = i5;
            i4 = M;
            while (true) {
                if (i3 < count) {
                    if (i3 == count - 1) {
                        i2 = i7 + dividerHeight + i6;
                        break;
                    }
                    i7 += dividerHeight + i6;
                    i6 = fx(i3 + 1);
                    i2 = M(i3 + 1, i7);
                    if (this.aYE < i2) {
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
            i2 = M;
            i3 = i5;
            i4 = M;
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
                i2 = M(i3, i8);
                if (this.aYE >= i2) {
                    break;
                }
                i4 = i2;
            }
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int i9 = this.aYJ;
        int i10 = this.aYK;
        float f2 = this.aZt;
        if (this.aYL) {
            int abs = Math.abs(i2 - i4);
            if (this.aYE >= i2) {
                int i11 = i4;
                i4 = i2;
                i2 = i11;
            }
            int i12 = (int) (abs * this.aZs * 0.5f);
            float f3 = i12;
            int i13 = i4 + i12;
            int i14 = i2 - i12;
            if (this.aYE < i13) {
                this.aYJ = i3 - 1;
                this.aYK = i3;
                this.aZt = ((i13 - this.aYE) * 0.5f) / f3;
            } else if (this.aYE < i14) {
                this.aYJ = i3;
                this.aYK = i3;
            } else {
                this.aYJ = i3;
                this.aYK = i3 + 1;
                this.aZt = (1.0f + ((i2 - this.aYE) / f3)) * 0.5f;
            }
        } else {
            this.aYJ = i3;
            this.aYK = i3;
        }
        if (this.aYJ < headerViewsCount) {
            this.aYJ = headerViewsCount;
            this.aYK = headerViewsCount;
            i3 = headerViewsCount;
        } else if (this.aYK >= this.mListView.getCount() - footerViewsCount) {
            i3 = (this.mListView.getCount() - footerViewsCount) - 1;
            this.aYJ = i3;
            this.aYK = i3;
        }
        boolean z = (this.aYJ == i9 && this.aYK == i10 && this.aZt == f2) ? false : true;
        if (i3 != this.aYI) {
            if (this.aYQ != null) {
                this.aYQ.drag(this.aYI - headerViewsCount, i3 - headerViewsCount);
            }
            this.aYI = i3;
            return true;
        }
        return z;
    }

    public void removeItem(int i2) {
        this.aZC = false;
        removeItem(i2, 0.0f);
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void a(ListView listView, Context context, AttributeSet attributeSet) {
        int i2;
        int i3 = BaseActivity.SHOW_SOFT_KEYBOARD_DELAY;
        if (attributeSet == null) {
            i2 = 150;
        } else {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f.l.DragSort, 0, 0);
            this.aYU = Math.max(1, obtainStyledAttributes.getDimensionPixelSize(f.l.DragSort_collapsed_height, 1));
            this.aZv = obtainStyledAttributes.getBoolean(f.l.DragSort_track_drag_sort, false);
            if (this.aZv) {
                this.aZw = new e();
            }
            this.aYG = obtainStyledAttributes.getFloat(f.l.DragSort_float_alpha, this.aYG);
            this.aYH = this.aYG;
            this.aYT = obtainStyledAttributes.getBoolean(f.l.DragSort_drag_enabled, this.aYT);
            this.aZs = Math.max(0.0f, Math.min(1.0f, 1.0f - obtainStyledAttributes.getFloat(f.l.DragSort_slide_shuffle_speed, 0.75f)));
            this.aYL = this.aZs > 0.0f;
            setDragScrollStart(obtainStyledAttributes.getFloat(f.l.DragSort_drag_scroll_start, this.aYZ));
            this.aZh = obtainStyledAttributes.getFloat(f.l.DragSort_max_drag_scroll_speed, this.aZh);
            int i4 = obtainStyledAttributes.getInt(f.l.DragSort_remove_animation_duration, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
            int i5 = obtainStyledAttributes.getInt(f.l.DragSort_drop_animation_duration, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
            if (obtainStyledAttributes.getBoolean(f.l.DragSort_use_default_controller, true)) {
                boolean z = obtainStyledAttributes.getBoolean(f.l.DragSort_remove_enabled, false);
                int i6 = obtainStyledAttributes.getInt(f.l.DragSort_remove_mode, 1);
                boolean z2 = obtainStyledAttributes.getBoolean(f.l.DragSort_sort_enabled, true);
                int resourceId = obtainStyledAttributes.getResourceId(f.l.DragSort_drag_handle_id, 0);
                int resourceId2 = obtainStyledAttributes.getResourceId(f.l.DragSort_fling_handle_id, 0);
                int resourceId3 = obtainStyledAttributes.getResourceId(f.l.DragSort_click_remove_id, 0);
                int color = obtainStyledAttributes.getColor(f.l.DragSort_float_background_color, ViewCompat.MEASURED_STATE_MASK);
                com.baidu.tbadk.widget.dragsort.b bVar = new com.baidu.tbadk.widget.dragsort.b(this, listView, resourceId, 2, i6, resourceId3, resourceId2);
                bVar.cj(z);
                bVar.ci(z2);
                bVar.setBackgroundColor(color);
                this.aZp = bVar;
                a(bVar);
            }
            obtainStyledAttributes.recycle();
            i2 = i5;
            i3 = i4;
        }
        this.aYY = new d();
        if (i3 > 0) {
            this.aZz = new k(0.5f, i3);
        }
        if (i2 > 0) {
            this.aZB = new f(0.5f, i2);
        }
        this.aZq = MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
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
        this.aZF = bVar;
        this.mListView.setOnTouchListener(bVar);
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void dispatchDraw(Canvas canvas) {
        float f2;
        this.aZE.dispatchDraw(canvas);
        if (this.mDragState != 0) {
            if (this.aYJ != this.aYM) {
                b(this.aYJ, canvas);
            }
            if (this.aYK != this.aYJ && this.aYK != this.aYM) {
                b(this.aYK, canvas);
            }
        }
        if (this.aYB != null) {
            int width = this.aYB.getWidth();
            int height = this.aYB.getHeight();
            int i2 = this.aYC.x;
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
            int i3 = (int) (f2 * 255.0f * this.aYH);
            canvas.save();
            canvas.translate(this.aYC.x, this.aYC.y);
            canvas.clipRect(0, 0, width, height);
            canvas.saveLayerAlpha(0.0f, 0.0f, width, height, i3, 31);
            this.aYB.draw(canvas);
            canvas.restore();
            canvas.restore();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onDraw(Canvas canvas) {
        this.aZE.onDraw(canvas);
        if (this.aZv) {
            this.aZw.Mu();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.aZx) {
            this.aZx = false;
            return false;
        } else if (!this.aYT) {
            return this.aZE.onTouchEvent(motionEvent);
        } else {
            boolean z2 = this.aZn;
            this.aZn = false;
            if (!z2) {
                u(motionEvent);
            }
            if (this.mDragState == 4) {
                onDragTouchEvent(motionEvent);
                return true;
            }
            if (this.mDragState == 0 && this.aZE.onTouchEvent(motionEvent)) {
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
                        this.aZr = 1;
                        return z;
                    }
                    return z;
            }
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (!this.aYT) {
            return this.aZE.onInterceptTouchEvent(motionEvent);
        }
        if (this.aZF != null) {
            this.aZF.Mw().onTouchEvent(motionEvent);
        }
        u(motionEvent);
        this.aZn = true;
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            if (this.mDragState != 0) {
                this.aZx = true;
                return true;
            }
            this.aZo = true;
        }
        if (this.aYB == null) {
            if (this.aZE.onInterceptTouchEvent(motionEvent)) {
                this.aZG = true;
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
                        this.aZr = 1;
                        break;
                    } else {
                        this.aZr = 2;
                        break;
                    }
            }
        } else {
            z = true;
        }
        if (action == 1 || action == 3) {
            this.aZo = false;
        }
        return z;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        this.aZE.onSizeChanged(i2, i3, i4, i5);
        Mn();
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void requestLayout() {
        if (!this.mBlockLayoutRequests) {
            this.aZE.requestLayout();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onMeasure(int i2, int i3) {
        this.aZE.onMeasure(i2, i3);
        if (this.aYB != null) {
            if (this.aYB.isLayoutRequested()) {
                Mp();
            }
            this.aYF = true;
        }
        this.mWidthMeasureSpec = i2;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void layoutChildren() {
        this.aZE.layoutChildren();
        if (this.aYB != null) {
            if (this.aYB.isLayoutRequested() && !this.aYF) {
                Mp();
            }
            this.aYB.layout(0, 0, this.aYB.getMeasuredWidth(), this.aYB.getMeasuredHeight());
            this.aYF = false;
        }
    }

    public void removeItem(int i2, float f2) {
        if (this.mDragState == 0 || this.mDragState == 4) {
            if (this.mDragState == 0) {
                this.aYM = this.mListView.getHeaderViewsCount() + i2;
                this.aYJ = this.aYM;
                this.aYK = this.aYM;
                this.aYI = this.aYM;
                View childAt = this.mListView.getChildAt(this.aYM - this.mListView.getFirstVisiblePosition());
                if (childAt != null) {
                    childAt.setVisibility(4);
                }
            }
            this.mDragState = 1;
            this.aZD = f2;
            if (this.aZo) {
                switch (this.aZr) {
                    case 1:
                        this.aZE.onTouchEvent(this.aZq);
                        break;
                    case 2:
                        this.aZE.onInterceptTouchEvent(this.aZq);
                        break;
                }
            }
            if (this.aZz != null) {
                this.aZz.start();
            } else {
                fy(i2);
            }
        }
    }

    public void cancelDrag() {
        if (this.mDragState == 4) {
            this.aYY.ch(true);
            Mr();
            Mi();
            Mo();
            if (this.aZo) {
                this.mDragState = 3;
            } else {
                this.mDragState = 0;
            }
        }
    }

    private void Mi() {
        this.aYM = -1;
        this.aYJ = -1;
        this.aYK = -1;
        this.aYI = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mj() {
        this.mDragState = 2;
        if (this.aYR != null && this.aYI >= 0 && this.aYI < this.mListView.getCount()) {
            int headerViewsCount = this.mListView.getHeaderViewsCount();
            this.aYR.drop(this.aYM - headerViewsCount, this.aYI - headerViewsCount);
        }
        Mr();
        Ml();
        Mi();
        Mo();
        if (this.aZo) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mk() {
        fy(this.aYM - this.mListView.getHeaderViewsCount());
    }

    private void fy(int i2) {
        this.mDragState = 1;
        if (this.aYS != null) {
            this.aYS.remove(i2);
        }
        Mr();
        Ml();
        Mi();
        if (this.aZo) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    private void Ml() {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        if (this.aYM < firstVisiblePosition) {
            View childAt = this.mListView.getChildAt(0);
            this.mListView.setSelectionFromTop(firstVisiblePosition - 1, (childAt != null ? childAt.getTop() : 0) - this.mListView.getPaddingTop());
        }
    }

    public boolean stopDrag(boolean z) {
        this.aZC = false;
        return stopDrag(z, 0.0f);
    }

    public boolean stopDragWithVelocity(boolean z, float f2) {
        this.aZC = true;
        return stopDrag(z, f2);
    }

    public boolean stopDrag(boolean z, float f2) {
        if (this.aYB != null) {
            this.aYY.ch(true);
            if (z) {
                removeItem(this.aYM - this.mListView.getHeaderViewsCount(), f2);
            } else if (this.aZB != null) {
                this.aZB.start();
            } else {
                Mj();
            }
            if (this.aZv) {
                this.aZw.mW();
                return true;
            }
            return true;
        }
        return false;
    }

    private void Mm() {
        this.aZr = 0;
        this.aZo = false;
        if (this.mDragState == 3) {
            this.mDragState = 0;
        }
        this.aYH = this.aYG;
        this.aZG = false;
        this.aZy.clear();
    }

    private void u(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            this.mLastX = this.aZj;
            this.mLastY = this.aZk;
        }
        this.aZj = (int) motionEvent.getX();
        this.aZk = (int) motionEvent.getY();
        if (action == 0) {
            this.mLastX = this.aZj;
            this.mLastY = this.aZk;
        }
        this.aYP = ((int) motionEvent.getRawX()) - this.aZj;
        this.ayt = ((int) motionEvent.getRawY()) - this.aZk;
    }

    public boolean listViewIntercepted() {
        return this.aZG;
    }

    public void setDragScrollStart(float f2) {
        setDragScrollStarts(f2, f2);
    }

    public void setDragScrollStarts(float f2, float f3) {
        if (f3 > 0.5f) {
            this.aZa = 0.5f;
        } else {
            this.aZa = f3;
        }
        if (f2 > 0.5f) {
            this.aYZ = 0.5f;
        } else {
            this.aYZ = f2;
        }
        if (this.mListView.getHeight() != 0) {
            Mn();
        }
    }

    private void N(int i2, int i3) {
        this.aYC.x = i2 - this.aYN;
        this.aYC.y = i3 - this.aYO;
        cg(true);
        int min = Math.min(i3, this.aYE + this.aYW);
        int max = Math.max(i3, this.aYE - this.aYW);
        int Mt = this.aYY.Mt();
        if (min > this.mLastY && min > this.aZc && Mt != 1) {
            if (Mt != -1) {
                this.aYY.ch(true);
            }
            this.aYY.fA(1);
        } else if (max < this.mLastY && max < this.aZb && Mt != 0) {
            if (Mt != -1) {
                this.aYY.ch(true);
            }
            this.aYY.fA(0);
        } else if (max >= this.aZb && min <= this.aZc && this.aYY.Ms()) {
            this.aYY.ch(true);
        }
    }

    private void Mn() {
        int height;
        int paddingTop = this.mListView.getPaddingTop();
        float height2 = (this.mListView.getHeight() - paddingTop) - this.mListView.getPaddingBottom();
        this.aZe = paddingTop + (this.aYZ * height2);
        this.aZd = (height2 * (1.0f - this.aZa)) + paddingTop;
        this.aZb = (int) this.aZe;
        this.aZc = (int) this.aZd;
        this.aZf = this.aZe - paddingTop;
        this.aZg = (paddingTop + height) - this.aZd;
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
        if (i2 != this.aYM && i2 != this.aYJ && i2 != this.aYK) {
            g2 = -2;
        } else {
            g2 = g(i2, view, z);
        }
        if (g2 != layoutParams.height) {
            layoutParams.height = g2;
            view.setLayoutParams(layoutParams);
        }
        if (i2 == this.aYJ || i2 == this.aYK) {
            if (i2 < this.aYM) {
                ((DragSortItemView) view).setGravity(80);
            } else if (i2 > this.aYM) {
                ((DragSortItemView) view).setGravity(48);
            }
        }
        int visibility = view.getVisibility();
        int i3 = 0;
        if (i2 == this.aYM && this.aYB != null) {
            i3 = 4;
        }
        if (i3 != visibility) {
            view.setVisibility(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int fz(int i2) {
        View view;
        if (i2 == this.aYM) {
            return 0;
        }
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        if (childAt != null) {
            return f(i2, childAt, false);
        }
        int i3 = this.aZy.get(i2);
        if (i3 == -1) {
            ListAdapter adapter = this.mListView.getAdapter();
            int itemViewType = adapter.getItemViewType(i2);
            int viewTypeCount = adapter.getViewTypeCount();
            if (viewTypeCount != this.aYX.length) {
                this.aYX = new View[viewTypeCount];
            }
            if (itemViewType >= 0) {
                if (this.aYX[itemViewType] == null) {
                    view = adapter.getView(i2, null, this.mListView);
                    this.aYX[itemViewType] = view;
                } else {
                    view = adapter.getView(i2, this.aYX[itemViewType], this.mListView);
                }
            } else {
                view = adapter.getView(i2, null, this.mListView);
            }
            int f2 = f(i2, view, true);
            this.aZy.add(i2, f2);
            return f2;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(int i2, View view, boolean z) {
        if (i2 == this.aYM) {
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
        return O(i2, f(i2, view, z));
    }

    private int O(int i2, int i3) {
        this.mListView.getDividerHeight();
        boolean z = this.aYL && this.aYJ != this.aYK;
        int i4 = this.aYV - this.aYU;
        int i5 = (int) (this.aZt * i4);
        if (i2 == this.aYM) {
            if (this.aYM == this.aYJ) {
                if (z) {
                    return i5 + this.aYU;
                }
                return this.aYV;
            } else if (this.aYM == this.aYK) {
                return this.aYV - i5;
            } else {
                return this.aYU;
            }
        } else if (i2 == this.aYJ) {
            if (z) {
                return i3 + i5;
            }
            return i3 + i4;
        } else if (i2 == this.aYK) {
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
        int O = O(i2, fz);
        if (i2 != this.aYM) {
            i6 = height - fz;
            i5 = O - fz;
        } else {
            i5 = O;
            i6 = height;
        }
        int i7 = this.aYV;
        if (this.aYM != this.aYJ && this.aYM != this.aYK) {
            i7 -= this.aYU;
        }
        if (i2 <= i3) {
            if (i2 > this.aYJ) {
                return (i7 - i5) + 0;
            }
        } else if (i2 == i4) {
            if (i2 <= this.aYJ) {
                return (i6 - i7) + 0;
            }
            if (i2 == this.aYK) {
                return (height - O) + 0;
            }
            return 0 + i6;
        } else if (i2 <= this.aYJ) {
            return 0 - i7;
        } else {
            if (i2 == this.aYK) {
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
        if (this.aYB != null) {
            measureItem(this.aYB);
            this.aYV = this.aYB.getMeasuredHeight();
            this.aYW = this.aYV / 2;
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
                N((int) motionEvent.getX(), (int) motionEvent.getY());
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
        if (!this.aZo || this.aZp == null || (fB = this.aZp.fB(i2)) == null) {
            return false;
        }
        return startDrag(i2, fB, i3, i4, i5);
    }

    public boolean startDrag(int i2, View view, int i3, int i4, int i5) {
        if (this.mDragState == 0 && this.aZo && this.aYB == null && view != null && this.aYT) {
            if (this.mListView.getParent() != null) {
                this.mListView.getParent().requestDisallowInterceptTouchEvent(true);
            }
            int headerViewsCount = this.mListView.getHeaderViewsCount() + i2;
            this.aYJ = headerViewsCount;
            this.aYK = headerViewsCount;
            this.aYM = headerViewsCount;
            this.aYI = headerViewsCount;
            this.mDragState = 4;
            this.aZm = 0;
            this.aZm |= i3;
            this.aYB = view;
            Mp();
            this.aYN = i4;
            this.aYO = i5;
            this.aZl = this.aZk;
            this.aYC.x = this.aZj - this.aYN;
            this.aYC.y = this.aZk - this.aYO;
            View childAt = this.mListView.getChildAt(this.aYM - this.mListView.getFirstVisiblePosition());
            if (childAt != null) {
                childAt.setVisibility(4);
            }
            if (this.aZv) {
                this.aZw.startTracking();
            }
            switch (this.aZr) {
                case 1:
                    this.aZE.onTouchEvent(this.aZq);
                    break;
                case 2:
                    this.aZE.onInterceptTouchEvent(this.aZq);
                    break;
            }
            this.mListView.requestLayout();
            if (this.aZA != null) {
                this.aZA.start();
                return true;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cg(boolean z) {
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
        int i3 = this.aYJ;
        int i4 = this.aYK;
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
        if (this.aZp != null) {
            this.aYD.set(this.aZj, this.aZk);
            this.aZp.b(this.aYB, this.aYC, this.aYD);
        }
        int i2 = this.aYC.x;
        int i3 = this.aYC.y;
        int paddingLeft = this.mListView.getPaddingLeft();
        if ((this.aZm & 1) == 0 && i2 > paddingLeft) {
            this.aYC.x = paddingLeft;
        } else if ((this.aZm & 2) == 0 && i2 < paddingLeft) {
            this.aYC.x = paddingLeft;
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int lastVisiblePosition = this.mListView.getLastVisiblePosition();
        int paddingTop = this.mListView.getPaddingTop();
        if (firstVisiblePosition < headerViewsCount) {
            paddingTop = this.mListView.getChildAt((headerViewsCount - firstVisiblePosition) - 1).getBottom();
        }
        if ((this.aZm & 8) == 0 && firstVisiblePosition <= this.aYM) {
            paddingTop = Math.max(this.mListView.getChildAt(this.aYM - firstVisiblePosition).getTop(), paddingTop);
        }
        int height = this.mListView.getHeight() - this.mListView.getPaddingBottom();
        if (lastVisiblePosition >= (this.mListView.getCount() - footerViewsCount) - 1) {
            height = this.mListView.getChildAt(((this.mListView.getCount() - footerViewsCount) - 1) - firstVisiblePosition).getBottom();
        }
        if ((this.aZm & 4) == 0 && lastVisiblePosition >= this.aYM) {
            height = Math.min(this.mListView.getChildAt(this.aYM - firstVisiblePosition).getBottom(), height);
        }
        if (i3 < paddingTop) {
            this.aYC.y = paddingTop;
        } else if (this.aYV + i3 > height) {
            this.aYC.y = height - this.aYV;
        }
        this.aYE = this.aYC.y + this.aYW;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mr() {
        if (this.aYB != null) {
            this.aYB.setVisibility(8);
            if (this.aZp != null) {
                this.aZp.T(this.aYB);
            }
            this.aYB = null;
            this.mListView.invalidate();
        }
    }

    public void a(h hVar) {
        this.aZp = hVar;
    }

    public void a(b bVar) {
        this.aYQ = bVar;
    }

    public void setDragEnabled(boolean z) {
        this.aYT = z;
    }

    public boolean isDragEnabled() {
        return this.aYT;
    }

    public void a(g gVar) {
        this.aYR = gVar;
    }

    public void a(l lVar) {
        this.aYS = lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class i {
        private SparseIntArray baa;
        private ArrayList<Integer> bab;
        private int mMaxSize;

        public i(int i) {
            this.baa = new SparseIntArray(i);
            this.bab = new ArrayList<>(i);
            this.mMaxSize = i;
        }

        public void add(int i, int i2) {
            int i3 = this.baa.get(i, -1);
            if (i3 != i2) {
                if (i3 == -1) {
                    if (this.baa.size() == this.mMaxSize) {
                        this.baa.delete(this.bab.remove(0).intValue());
                    }
                } else {
                    this.bab.remove(Integer.valueOf(i));
                }
                this.baa.put(i, i2);
                this.bab.add(Integer.valueOf(i));
            }
        }

        public int get(int i) {
            return this.baa.get(i, -1);
        }

        public void clear() {
            this.baa.clear();
            this.bab.clear();
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
        private float bal;
        private float bam;
        private float ban;
        private float bao;
        private float bap;
        private float mAlpha;
        private boolean mCanceled;
        protected long mStartTime;

        public m(float f, int i) {
            this.mAlpha = f;
            this.bal = i;
            float f2 = 1.0f / ((this.mAlpha * 2.0f) * (1.0f - this.mAlpha));
            this.bap = f2;
            this.bam = f2;
            this.ban = this.mAlpha / ((this.mAlpha - 1.0f) * 2.0f);
            this.bao = 1.0f / (1.0f - this.mAlpha);
        }

        public float aa(float f) {
            if (f < this.mAlpha) {
                return this.bam * f * f;
            }
            if (f < 1.0f - this.mAlpha) {
                return this.ban + (this.bao * f);
            }
            return 1.0f - ((this.bap * (f - 1.0f)) * (f - 1.0f));
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
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / this.bal;
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
        private int aZW;
        private int aZX;
        private float aZY;
        private float aZZ;

        public f(float f, int i) {
            super(f, i);
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.aZW = a.this.aYI;
            this.aZX = a.this.aYM;
            a.this.mDragState = 2;
            this.aZY = a.this.aYC.y - Mv();
            this.aZZ = a.this.aYC.x - a.this.mListView.getPaddingLeft();
        }

        private int Mv() {
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            int dividerHeight = (a.this.aYU + a.this.mListView.getDividerHeight()) / 2;
            View childAt = a.this.mListView.getChildAt(this.aZW - firstVisiblePosition);
            if (childAt != null) {
                if (this.aZW == this.aZX) {
                    return childAt.getTop();
                }
                if (this.aZW >= this.aZX) {
                    return (childAt.getBottom() + dividerHeight) - a.this.aYV;
                }
                return childAt.getTop() - dividerHeight;
            }
            cancel();
            return -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void n(float f, float f2) {
            int Mv = Mv();
            float paddingLeft = a.this.aYC.x - a.this.mListView.getPaddingLeft();
            float f3 = 1.0f - f2;
            if (f3 < Math.abs((a.this.aYC.y - Mv) / this.aZY) || f3 < Math.abs(paddingLeft / this.aZZ)) {
                a.this.aYC.y = Mv + ((int) (this.aZY * f3));
                a.this.aYC.x = a.this.mListView.getPaddingLeft() + ((int) (this.aZZ * f3));
                a.this.cg(true);
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
        private int aZX;
        private float bae;
        private float baf;
        private float bag;
        private int bah;
        private int bai;
        private int baj;
        private int bak;

        public k(float f, int i) {
            super(f, i);
            this.bah = -1;
            this.bai = -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.bah = -1;
            this.bai = -1;
            this.baj = a.this.aYJ;
            this.bak = a.this.aYK;
            this.aZX = a.this.aYM;
            a.this.mDragState = 1;
            this.bae = a.this.aYC.x;
            if (a.this.aZC) {
                float width = a.this.mListView.getWidth() * 2.0f;
                if (a.this.aZD == 0.0f) {
                    a.this.aZD = (this.bae >= 0.0f ? 1 : -1) * width;
                    return;
                }
                float f = width * 2.0f;
                if (a.this.aZD >= 0.0f || a.this.aZD <= (-f)) {
                    if (a.this.aZD > 0.0f && a.this.aZD < f) {
                        a.this.aZD = f;
                        return;
                    }
                    return;
                }
                a.this.aZD = -f;
                return;
            }
            a.this.Mr();
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void n(float f, float f2) {
            View childAt;
            float f3 = 1.0f - f2;
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            View childAt2 = a.this.mListView.getChildAt(this.baj - firstVisiblePosition);
            if (a.this.aZC) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / 1000.0f;
                if (uptimeMillis != 0.0f) {
                    float f4 = a.this.aZD * uptimeMillis;
                    int width = a.this.mListView.getWidth();
                    a.this.aZD = ((a.this.aZD > 0.0f ? 1 : -1) * uptimeMillis * width) + a.this.aZD;
                    this.bae += f4;
                    a.this.aYC.x = (int) this.bae;
                    if (this.bae < width && this.bae > (-width)) {
                        this.mStartTime = SystemClock.uptimeMillis();
                        a.this.cg(true);
                        return;
                    }
                } else {
                    return;
                }
            }
            if (childAt2 != null) {
                if (this.bah == -1) {
                    this.bah = a.this.f(this.baj, childAt2, false);
                    this.baf = childAt2.getHeight() - this.bah;
                }
                int max = Math.max((int) (this.baf * f3), 1);
                ViewGroup.LayoutParams layoutParams = childAt2.getLayoutParams();
                layoutParams.height = max + this.bah;
                childAt2.setLayoutParams(layoutParams);
            }
            if (this.bak != this.baj && (childAt = a.this.mListView.getChildAt(this.bak - firstVisiblePosition)) != null) {
                if (this.bai == -1) {
                    this.bai = a.this.f(this.bak, childAt, false);
                    this.bag = childAt.getHeight() - this.bai;
                }
                int max2 = Math.max((int) (this.bag * f3), 1);
                ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
                layoutParams2.height = max2 + this.bai;
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
        final /* synthetic */ a aZI;
        private float bac;
        private float bad;

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.bac = this.aZI.aYO;
            this.bad = this.aZI.aYW;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void n(float f, float f2) {
            if (this.aZI.mDragState != 4) {
                cancel();
                return;
            }
            this.aZI.aYO = (int) ((this.bad * f2) + ((1.0f - f2) * this.bac));
            this.aZI.aYC.y = this.aZI.aZk - this.aZI.aYO;
            this.aZI.cg(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e {
        StringBuilder mBuilder = new StringBuilder();
        private int aZT = 0;
        private int aZU = 0;
        private boolean aZV = false;
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
            this.aZU = 0;
            this.aZV = true;
        }

        public void Mu() {
            if (this.aZV) {
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
                this.mBuilder.append("    <FirstExpPos>").append(a.this.aYJ).append("</FirstExpPos>\n");
                this.mBuilder.append("    <FirstExpBlankHeight>").append(a.this.fx(a.this.aYJ) - a.this.fz(a.this.aYJ)).append("</FirstExpBlankHeight>\n");
                this.mBuilder.append("    <SecondExpPos>").append(a.this.aYK).append("</SecondExpPos>\n");
                this.mBuilder.append("    <SecondExpBlankHeight>").append(a.this.fx(a.this.aYK) - a.this.fz(a.this.aYK)).append("</SecondExpBlankHeight>\n");
                this.mBuilder.append("    <SrcPos>").append(a.this.aYM).append("</SrcPos>\n");
                this.mBuilder.append("    <SrcHeight>").append(a.this.aYV + a.this.mListView.getDividerHeight()).append("</SrcHeight>\n");
                this.mBuilder.append("    <ViewHeight>").append(a.this.mListView.getHeight()).append("</ViewHeight>\n");
                this.mBuilder.append("    <LastY>").append(a.this.mLastY).append("</LastY>\n");
                this.mBuilder.append("    <FloatY>").append(a.this.aYE).append("</FloatY>\n");
                this.mBuilder.append("    <ShuffleEdges>");
                for (int i4 = 0; i4 < childCount; i4++) {
                    this.mBuilder.append(a.this.M(firstVisiblePosition + i4, a.this.mListView.getChildAt(i4).getTop())).append(",");
                }
                this.mBuilder.append("</ShuffleEdges>\n");
                this.mBuilder.append("</DSLVState>\n");
                this.aZT++;
                if (this.aZT > 1000) {
                    flush();
                    this.aZT = 0;
                }
            }
        }

        public void flush() {
            if (this.aZV) {
                try {
                    FileWriter fileWriter = new FileWriter(this.mFile, this.aZU != 0);
                    fileWriter.write(this.mBuilder.toString());
                    this.mBuilder.delete(0, this.mBuilder.length());
                    fileWriter.flush();
                    fileWriter.close();
                    this.aZU++;
                } catch (IOException e) {
                }
            }
        }

        public void mW() {
            if (this.aZV) {
                this.mBuilder.append("</DSLVStates>\n");
                flush();
                this.aZV = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements Runnable {
        private boolean aZL;
        private long aZM;
        private long aZN;
        private float aZO;
        private long aZP;
        private int aZQ;
        private float aZR;
        private boolean aZS = false;
        private int dy;

        public boolean Ms() {
            return this.aZS;
        }

        public int Mt() {
            if (this.aZS) {
                return this.aZQ;
            }
            return -1;
        }

        public d() {
        }

        public void fA(int i) {
            if (!this.aZS) {
                this.aZL = false;
                this.aZS = true;
                this.aZP = SystemClock.uptimeMillis();
                this.aZM = this.aZP;
                this.aZQ = i;
                a.this.mListView.post(this);
            }
        }

        public void ch(boolean z) {
            if (z) {
                a.this.mListView.removeCallbacks(this);
                this.aZS = false;
                return;
            }
            this.aZL = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.aZL) {
                int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
                int lastVisiblePosition = a.this.mListView.getLastVisiblePosition();
                int count = a.this.mListView.getCount();
                int paddingTop = a.this.mListView.getPaddingTop();
                int height = (a.this.mListView.getHeight() - paddingTop) - a.this.mListView.getPaddingBottom();
                int min = Math.min(a.this.aZk, a.this.aYE + a.this.aYW);
                int max = Math.max(a.this.aZk, a.this.aYE - a.this.aYW);
                if (this.aZQ == 0) {
                    View childAt = a.this.mListView.getChildAt(0);
                    if (childAt == null) {
                        this.aZS = false;
                        return;
                    } else if (firstVisiblePosition == 0 && childAt.getTop() == paddingTop) {
                        this.aZS = false;
                        return;
                    } else {
                        this.aZR = a.this.aZi.b((a.this.aZe - max) / a.this.aZf, this.aZM);
                    }
                } else {
                    View childAt2 = a.this.mListView.getChildAt(lastVisiblePosition - firstVisiblePosition);
                    if (childAt2 == null) {
                        this.aZS = false;
                        return;
                    } else if (lastVisiblePosition == count - 1 && childAt2.getBottom() <= height + paddingTop) {
                        this.aZS = false;
                        return;
                    } else {
                        this.aZR = -a.this.aZi.b((min - a.this.aZd) / a.this.aZg, this.aZM);
                    }
                }
                this.aZN = SystemClock.uptimeMillis();
                this.aZO = (float) (this.aZN - this.aZM);
                this.dy = Math.round(this.aZR * this.aZO);
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
                this.aZM = this.aZN;
                a.this.mListView.post(this);
                return;
            }
            this.aZS = false;
        }
    }
}
