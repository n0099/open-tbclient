package com.baidu.tbadk.widget.dragsort;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.os.SystemClock;
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
import com.baidu.searchbox.ng.ai.apps.util.AiAppsFileUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.e;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a implements com.baidu.tbadk.widget.dragsort.c {
    private int blA;
    private int blE;
    private int blF;
    private int blG;
    private int blI;
    private int blJ;
    private int blK;
    private b blL;
    private g blM;
    private l blN;
    private int blQ;
    private d blS;
    private int blV;
    private int blW;
    private float blX;
    private float blY;
    private float blZ;
    private View blx;
    private float bma;
    private int bmd;
    private MotionEvent bmi;
    private C0177a bmm;
    private e bmo;
    private k bms;
    private j bmt;
    private f bmu;
    private boolean bmv;
    private com.baidu.tbadk.widget.dragsort.d bmx;
    private com.baidu.tbadk.widget.dragsort.b bmy;
    private int mFloatViewHeight;
    private int mLastX;
    private int mLastY;
    private ListView mListView;
    private DataSetObserver mObserver;
    private int mOffsetX;
    private int mOffsetY;
    private int mX;
    private int mY;
    private Point bly = new Point();
    private Point blz = new Point();
    private boolean blB = false;
    private float blC = 1.0f;
    private float blD = 1.0f;
    private boolean blH = false;
    private boolean blO = true;
    private int mDragState = 0;
    private int blP = 1;
    private int mWidthMeasureSpec = 0;
    private View[] blR = new View[1];
    private float blT = 0.33333334f;
    private float blU = 0.33333334f;
    private float bmb = 0.5f;
    private c bmc = new c() { // from class: com.baidu.tbadk.widget.dragsort.a.1
        @Override // com.baidu.tbadk.widget.dragsort.a.c
        public float b(float f2, long j2) {
            return a.this.bmb * f2;
        }
    };
    private int bme = 0;
    private boolean bmf = false;
    private boolean bmg = false;
    private h bmh = null;
    private int bmj = 0;
    private float bmk = 0.25f;
    private float bml = 0.0f;
    private boolean bmn = false;
    private boolean mBlockLayoutRequests = false;
    private boolean bmq = false;
    private i bmr = new i(3);
    private float bmw = 0.0f;
    private boolean bmz = false;
    private boolean bmA = false;

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
        void af(View view);

        void b(View view, Point point, Point point2);

        View gz(int i);
    }

    /* loaded from: classes.dex */
    public interface l {
        void remove(int i);
    }

    public a(ListView listView, com.baidu.tbadk.widget.dragsort.d dVar) {
        this.bmx = dVar;
        this.mListView = listView;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            this.bmm = new C0177a(listAdapter);
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
            this.bmm = null;
        }
        this.bmx.setAdapter(this.bmm);
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
            if (i2 > this.blI) {
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
    public int gv(int i2) {
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        return childAt != null ? childAt.getHeight() : R(i2, gx(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int P(int i2, int i3) {
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        if (i2 <= headerViewsCount || i2 >= this.mListView.getCount() - footerViewsCount) {
            return i3;
        }
        int dividerHeight = this.mListView.getDividerHeight();
        int i4 = this.mFloatViewHeight - this.blP;
        int gx = gx(i2);
        int gv = gv(i2);
        if (this.blG <= this.blI) {
            if (i2 == this.blG && this.blF != this.blG) {
                if (i2 == this.blI) {
                    i3 = (i3 + gv) - this.mFloatViewHeight;
                } else {
                    i3 = ((gv - gx) + i3) - i4;
                }
            } else if (i2 > this.blG && i2 <= this.blI) {
                i3 -= i4;
            }
        } else if (i2 > this.blI && i2 <= this.blF) {
            i3 += i4;
        } else if (i2 == this.blG && this.blF != this.blG) {
            i3 += gv - gx;
        }
        if (i2 <= this.blI) {
            return (((this.mFloatViewHeight - dividerHeight) - gx(i2 - 1)) / 2) + i3;
        }
        return (((gx - dividerHeight) - this.mFloatViewHeight) / 2) + i3;
    }

    private boolean Rk() {
        int i2;
        int i3;
        int i4;
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int i5 = this.blF;
        View childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        if (childAt == null) {
            i5 = firstVisiblePosition + (this.mListView.getChildCount() / 2);
            childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        }
        int top = childAt.getTop();
        int height = childAt.getHeight();
        int P = P(i5, top);
        int dividerHeight = this.mListView.getDividerHeight();
        if (this.blA >= P) {
            int count = this.mListView.getCount();
            int i6 = height;
            int i7 = top;
            i2 = P;
            i3 = i5;
            i4 = P;
            while (true) {
                if (i3 < count) {
                    if (i3 == count - 1) {
                        i2 = i7 + dividerHeight + i6;
                        break;
                    }
                    i7 += dividerHeight + i6;
                    i6 = gv(i3 + 1);
                    i2 = P(i3 + 1, i7);
                    if (this.blA < i2) {
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
            i2 = P;
            i3 = i5;
            i4 = P;
            while (true) {
                if (i3 < 0) {
                    break;
                }
                i3--;
                int gv = gv(i3);
                if (i3 == 0) {
                    i2 = (i8 - dividerHeight) - gv;
                    break;
                }
                i8 -= gv + dividerHeight;
                i2 = P(i3, i8);
                if (this.blA >= i2) {
                    break;
                }
                i4 = i2;
            }
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int i9 = this.blF;
        int i10 = this.blG;
        float f2 = this.bml;
        if (this.blH) {
            int abs = Math.abs(i2 - i4);
            if (this.blA >= i2) {
                int i11 = i4;
                i4 = i2;
                i2 = i11;
            }
            int i12 = (int) (abs * this.bmk * 0.5f);
            float f3 = i12;
            int i13 = i4 + i12;
            int i14 = i2 - i12;
            if (this.blA < i13) {
                this.blF = i3 - 1;
                this.blG = i3;
                this.bml = ((i13 - this.blA) * 0.5f) / f3;
            } else if (this.blA < i14) {
                this.blF = i3;
                this.blG = i3;
            } else {
                this.blF = i3;
                this.blG = i3 + 1;
                this.bml = (1.0f + ((i2 - this.blA) / f3)) * 0.5f;
            }
        } else {
            this.blF = i3;
            this.blG = i3;
        }
        if (this.blF < headerViewsCount) {
            this.blF = headerViewsCount;
            this.blG = headerViewsCount;
            i3 = headerViewsCount;
        } else if (this.blG >= this.mListView.getCount() - footerViewsCount) {
            i3 = (this.mListView.getCount() - footerViewsCount) - 1;
            this.blF = i3;
            this.blG = i3;
        }
        boolean z = (this.blF == i9 && this.blG == i10 && this.bml == f2) ? false : true;
        if (i3 != this.blE) {
            if (this.blL != null) {
                this.blL.drag(this.blE - headerViewsCount, i3 - headerViewsCount);
            }
            this.blE = i3;
            return true;
        }
        return z;
    }

    public void removeItem(int i2) {
        this.bmv = false;
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
            this.blP = Math.max(1, obtainStyledAttributes.getDimensionPixelSize(e.l.DragSort_collapsed_height, 1));
            this.bmn = obtainStyledAttributes.getBoolean(e.l.DragSort_track_drag_sort, false);
            if (this.bmn) {
                this.bmo = new e();
            }
            this.blC = obtainStyledAttributes.getFloat(e.l.DragSort_float_alpha, this.blC);
            this.blD = this.blC;
            this.blO = obtainStyledAttributes.getBoolean(e.l.DragSort_drag_enabled, this.blO);
            this.bmk = Math.max(0.0f, Math.min(1.0f, 1.0f - obtainStyledAttributes.getFloat(e.l.DragSort_slide_shuffle_speed, 0.75f)));
            this.blH = this.bmk > 0.0f;
            setDragScrollStart(obtainStyledAttributes.getFloat(e.l.DragSort_drag_scroll_start, this.blT));
            this.bmb = obtainStyledAttributes.getFloat(e.l.DragSort_max_drag_scroll_speed, this.bmb);
            int i4 = obtainStyledAttributes.getInt(e.l.DragSort_remove_animation_duration, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
            int i5 = obtainStyledAttributes.getInt(e.l.DragSort_drop_animation_duration, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
            if (obtainStyledAttributes.getBoolean(e.l.DragSort_use_default_controller, true)) {
                boolean z = obtainStyledAttributes.getBoolean(e.l.DragSort_remove_enabled, false);
                int i6 = obtainStyledAttributes.getInt(e.l.DragSort_remove_mode, 1);
                boolean z2 = obtainStyledAttributes.getBoolean(e.l.DragSort_sort_enabled, true);
                int resourceId = obtainStyledAttributes.getResourceId(e.l.DragSort_drag_handle_id, 0);
                int resourceId2 = obtainStyledAttributes.getResourceId(e.l.DragSort_fling_handle_id, 0);
                int resourceId3 = obtainStyledAttributes.getResourceId(e.l.DragSort_click_remove_id, 0);
                int color = obtainStyledAttributes.getColor(e.l.DragSort_float_background_color, -16777216);
                com.baidu.tbadk.widget.dragsort.b bVar = new com.baidu.tbadk.widget.dragsort.b(this, listView, resourceId, 2, i6, resourceId3, resourceId2);
                bVar.cZ(z);
                bVar.cY(z2);
                bVar.setBackgroundColor(color);
                this.bmh = bVar;
                a(bVar);
            }
            obtainStyledAttributes.recycle();
            i2 = i5;
            i3 = i4;
        }
        this.blS = new d();
        if (i3 > 0) {
            this.bms = new k(0.5f, i3);
        }
        if (i2 > 0) {
            this.bmu = new f(0.5f, i2);
        }
        this.bmi = MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
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
        this.bmy = bVar;
        this.mListView.setOnTouchListener(bVar);
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void dispatchDraw(Canvas canvas) {
        float f2;
        this.bmx.dispatchDraw(canvas);
        if (this.mDragState != 0) {
            if (this.blF != this.blI) {
                b(this.blF, canvas);
            }
            if (this.blG != this.blF && this.blG != this.blI) {
                b(this.blG, canvas);
            }
        }
        if (this.blx != null) {
            int width = this.blx.getWidth();
            int height = this.blx.getHeight();
            int i2 = this.bly.x;
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
            int i3 = (int) (f2 * 255.0f * this.blD);
            canvas.save();
            canvas.translate(this.bly.x, this.bly.y);
            canvas.clipRect(0, 0, width, height);
            canvas.saveLayerAlpha(0.0f, 0.0f, width, height, i3, 31);
            this.blx.draw(canvas);
            canvas.restore();
            canvas.restore();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onDraw(Canvas canvas) {
        this.bmx.onDraw(canvas);
        if (this.bmn) {
            this.bmo.Rw();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.bmq) {
            this.bmq = false;
            return false;
        } else if (!this.blO) {
            return this.bmx.onTouchEvent(motionEvent);
        } else {
            boolean z2 = this.bmf;
            this.bmf = false;
            if (!z2) {
                u(motionEvent);
            }
            if (this.mDragState == 4) {
                onDragTouchEvent(motionEvent);
                return true;
            }
            if (this.mDragState == 0 && this.bmx.onTouchEvent(motionEvent)) {
                z = true;
            }
            switch (motionEvent.getAction() & 255) {
                case 1:
                case 3:
                    Rp();
                    return z;
                case 2:
                default:
                    if (z) {
                        this.bmj = 1;
                        return z;
                    }
                    return z;
            }
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (!this.blO) {
            return this.bmx.onInterceptTouchEvent(motionEvent);
        }
        if (this.bmy != null) {
            this.bmy.Ry().onTouchEvent(motionEvent);
        }
        u(motionEvent);
        this.bmf = true;
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            if (this.mDragState != 0) {
                this.bmq = true;
                return true;
            }
            this.bmg = true;
        }
        if (this.blx == null) {
            if (this.bmx.onInterceptTouchEvent(motionEvent)) {
                this.bmz = true;
                z = true;
            } else {
                z = false;
            }
            switch (action) {
                case 1:
                case 3:
                    Rp();
                    break;
                case 2:
                default:
                    if (z) {
                        this.bmj = 1;
                        break;
                    } else {
                        this.bmj = 2;
                        break;
                    }
            }
        } else {
            z = true;
        }
        if (action == 1 || action == 3) {
            this.bmg = false;
        }
        return z;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        this.bmx.onSizeChanged(i2, i3, i4, i5);
        Rq();
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void requestLayout() {
        if (!this.mBlockLayoutRequests) {
            this.bmx.requestLayout();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onMeasure(int i2, int i3) {
        this.bmx.onMeasure(i2, i3);
        if (this.blx != null) {
            if (this.blx.isLayoutRequested()) {
                Rs();
            }
            this.blB = true;
        }
        this.mWidthMeasureSpec = i2;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void layoutChildren() {
        this.bmx.layoutChildren();
        if (this.blx != null) {
            if (this.blx.isLayoutRequested() && !this.blB) {
                Rs();
            }
            this.blx.layout(0, 0, this.blx.getMeasuredWidth(), this.blx.getMeasuredHeight());
            this.blB = false;
        }
    }

    public void removeItem(int i2, float f2) {
        if (this.mDragState == 0 || this.mDragState == 4) {
            if (this.mDragState == 0) {
                this.blI = this.mListView.getHeaderViewsCount() + i2;
                this.blF = this.blI;
                this.blG = this.blI;
                this.blE = this.blI;
                View childAt = this.mListView.getChildAt(this.blI - this.mListView.getFirstVisiblePosition());
                if (childAt != null) {
                    childAt.setVisibility(4);
                }
            }
            this.mDragState = 1;
            this.bmw = f2;
            if (this.bmg) {
                switch (this.bmj) {
                    case 1:
                        this.bmx.onTouchEvent(this.bmi);
                        break;
                    case 2:
                        this.bmx.onInterceptTouchEvent(this.bmi);
                        break;
                }
            }
            if (this.bms != null) {
                this.bms.start();
            } else {
                gw(i2);
            }
        }
    }

    public void cancelDrag() {
        if (this.mDragState == 4) {
            this.blS.cX(true);
            Ru();
            Rl();
            Rr();
            if (this.bmg) {
                this.mDragState = 3;
            } else {
                this.mDragState = 0;
            }
        }
    }

    private void Rl() {
        this.blI = -1;
        this.blF = -1;
        this.blG = -1;
        this.blE = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rm() {
        this.mDragState = 2;
        if (this.blM != null && this.blE >= 0 && this.blE < this.mListView.getCount()) {
            int headerViewsCount = this.mListView.getHeaderViewsCount();
            this.blM.drop(this.blI - headerViewsCount, this.blE - headerViewsCount);
        }
        Ru();
        Ro();
        Rl();
        Rr();
        if (this.bmg) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rn() {
        gw(this.blI - this.mListView.getHeaderViewsCount());
    }

    private void gw(int i2) {
        this.mDragState = 1;
        if (this.blN != null) {
            this.blN.remove(i2);
        }
        Ru();
        Ro();
        Rl();
        if (this.bmg) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    private void Ro() {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        if (this.blI < firstVisiblePosition) {
            View childAt = this.mListView.getChildAt(0);
            this.mListView.setSelectionFromTop(firstVisiblePosition - 1, (childAt != null ? childAt.getTop() : 0) - this.mListView.getPaddingTop());
        }
    }

    public boolean stopDrag(boolean z) {
        this.bmv = false;
        return stopDrag(z, 0.0f);
    }

    public boolean stopDragWithVelocity(boolean z, float f2) {
        this.bmv = true;
        return stopDrag(z, f2);
    }

    public boolean stopDrag(boolean z, float f2) {
        if (this.blx != null) {
            this.blS.cX(true);
            if (z) {
                removeItem(this.blI - this.mListView.getHeaderViewsCount(), f2);
            } else if (this.bmu != null) {
                this.bmu.start();
            } else {
                Rm();
            }
            if (this.bmn) {
                this.bmo.oo();
                return true;
            }
            return true;
        }
        return false;
    }

    private void Rp() {
        this.bmj = 0;
        this.bmg = false;
        if (this.mDragState == 3) {
            this.mDragState = 0;
        }
        this.blD = this.blC;
        this.bmz = false;
        this.bmr.clear();
    }

    private void u(MotionEvent motionEvent) {
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
        return this.bmz;
    }

    public void setDragScrollStart(float f2) {
        setDragScrollStarts(f2, f2);
    }

    public void setDragScrollStarts(float f2, float f3) {
        if (f3 > 0.5f) {
            this.blU = 0.5f;
        } else {
            this.blU = f3;
        }
        if (f2 > 0.5f) {
            this.blT = 0.5f;
        } else {
            this.blT = f2;
        }
        if (this.mListView.getHeight() != 0) {
            Rq();
        }
    }

    private void Q(int i2, int i3) {
        this.bly.x = i2 - this.blJ;
        this.bly.y = i3 - this.blK;
        cW(true);
        int min = Math.min(i3, this.blA + this.blQ);
        int max = Math.max(i3, this.blA - this.blQ);
        int Rv = this.blS.Rv();
        if (min > this.mLastY && min > this.blW && Rv != 1) {
            if (Rv != -1) {
                this.blS.cX(true);
            }
            this.blS.gy(1);
        } else if (max < this.mLastY && max < this.blV && Rv != 0) {
            if (Rv != -1) {
                this.blS.cX(true);
            }
            this.blS.gy(0);
        } else if (max >= this.blV && min <= this.blW && this.blS.isScrolling()) {
            this.blS.cX(true);
        }
    }

    private void Rq() {
        int height;
        int paddingTop = this.mListView.getPaddingTop();
        float height2 = (this.mListView.getHeight() - paddingTop) - this.mListView.getPaddingBottom();
        this.blY = paddingTop + (this.blT * height2);
        this.blX = (height2 * (1.0f - this.blU)) + paddingTop;
        this.blV = (int) this.blY;
        this.blW = (int) this.blX;
        this.blZ = this.blY - paddingTop;
        this.bma = (paddingTop + height) - this.blX;
    }

    private void Rr() {
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
        if (i2 != this.blI && i2 != this.blF && i2 != this.blG) {
            g2 = -2;
        } else {
            g2 = g(i2, view, z);
        }
        if (g2 != layoutParams.height) {
            layoutParams.height = g2;
            view.setLayoutParams(layoutParams);
        }
        if (i2 == this.blF || i2 == this.blG) {
            if (i2 < this.blI) {
                ((DragSortItemView) view).setGravity(80);
            } else if (i2 > this.blI) {
                ((DragSortItemView) view).setGravity(48);
            }
        }
        int visibility = view.getVisibility();
        int i3 = 0;
        if (i2 == this.blI && this.blx != null) {
            i3 = 4;
        }
        if (i3 != visibility) {
            view.setVisibility(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int gx(int i2) {
        View view;
        if (i2 == this.blI) {
            return 0;
        }
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        if (childAt != null) {
            return f(i2, childAt, false);
        }
        int i3 = this.bmr.get(i2);
        if (i3 == -1) {
            ListAdapter adapter = this.mListView.getAdapter();
            int itemViewType = adapter.getItemViewType(i2);
            int viewTypeCount = adapter.getViewTypeCount();
            if (viewTypeCount != this.blR.length) {
                this.blR = new View[viewTypeCount];
            }
            if (itemViewType >= 0) {
                if (this.blR[itemViewType] == null) {
                    view = adapter.getView(i2, null, this.mListView);
                    this.blR[itemViewType] = view;
                } else {
                    view = adapter.getView(i2, this.blR[itemViewType], this.mListView);
                }
            } else {
                view = adapter.getView(i2, null, this.mListView);
            }
            int f2 = f(i2, view, true);
            this.bmr.add(i2, f2);
            return f2;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(int i2, View view, boolean z) {
        if (i2 == this.blI) {
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
        return R(i2, f(i2, view, z));
    }

    private int R(int i2, int i3) {
        this.mListView.getDividerHeight();
        boolean z = this.blH && this.blF != this.blG;
        int i4 = this.mFloatViewHeight - this.blP;
        int i5 = (int) (this.bml * i4);
        if (i2 == this.blI) {
            if (this.blI == this.blF) {
                if (z) {
                    return i5 + this.blP;
                }
                return this.mFloatViewHeight;
            } else if (this.blI == this.blG) {
                return this.mFloatViewHeight - i5;
            } else {
                return this.blP;
            }
        } else if (i2 == this.blF) {
            if (z) {
                return i3 + i5;
            }
            return i3 + i4;
        } else if (i2 == this.blG) {
            return (i3 + i4) - i5;
        } else {
            return i3;
        }
    }

    private int b(int i2, View view, int i3, int i4) {
        int i5;
        int i6;
        int gx = gx(i2);
        int height = view.getHeight();
        int R = R(i2, gx);
        if (i2 != this.blI) {
            i6 = height - gx;
            i5 = R - gx;
        } else {
            i5 = R;
            i6 = height;
        }
        int i7 = this.mFloatViewHeight;
        if (this.blI != this.blF && this.blI != this.blG) {
            i7 -= this.blP;
        }
        if (i2 <= i3) {
            if (i2 > this.blF) {
                return (i7 - i5) + 0;
            }
        } else if (i2 == i4) {
            if (i2 <= this.blF) {
                return (i6 - i7) + 0;
            }
            if (i2 == this.blG) {
                return (height - R) + 0;
            }
            return 0 + i6;
        } else if (i2 <= this.blF) {
            return 0 - i7;
        } else {
            if (i2 == this.blG) {
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
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(layoutParams.height, AiAppsFileUtils.GB);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(childMeasureSpec, makeMeasureSpec);
    }

    private void Rs() {
        if (this.blx != null) {
            measureItem(this.blx);
            this.mFloatViewHeight = this.blx.getMeasuredHeight();
            this.blQ = this.mFloatViewHeight / 2;
        }
    }

    protected boolean onDragTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        switch (motionEvent.getAction() & 255) {
            case 1:
                if (this.mDragState == 4) {
                    stopDrag(false);
                }
                Rp();
                return true;
            case 2:
                Q((int) motionEvent.getX(), (int) motionEvent.getY());
                return true;
            case 3:
                if (this.mDragState == 4) {
                    cancelDrag();
                }
                Rp();
                return true;
            default:
                return true;
        }
    }

    public boolean startDrag(int i2, int i3, int i4, int i5) {
        View gz;
        if (!this.bmg || this.bmh == null || (gz = this.bmh.gz(i2)) == null) {
            return false;
        }
        return startDrag(i2, gz, i3, i4, i5);
    }

    public boolean startDrag(int i2, View view, int i3, int i4, int i5) {
        if (this.mDragState == 0 && this.bmg && this.blx == null && view != null && this.blO) {
            if (this.mListView.getParent() != null) {
                this.mListView.getParent().requestDisallowInterceptTouchEvent(true);
            }
            int headerViewsCount = this.mListView.getHeaderViewsCount() + i2;
            this.blF = headerViewsCount;
            this.blG = headerViewsCount;
            this.blI = headerViewsCount;
            this.blE = headerViewsCount;
            this.mDragState = 4;
            this.bme = 0;
            this.bme |= i3;
            this.blx = view;
            Rs();
            this.blJ = i4;
            this.blK = i5;
            this.bmd = this.mY;
            this.bly.x = this.mX - this.blJ;
            this.bly.y = this.mY - this.blK;
            View childAt = this.mListView.getChildAt(this.blI - this.mListView.getFirstVisiblePosition());
            if (childAt != null) {
                childAt.setVisibility(4);
            }
            if (this.bmn) {
                this.bmo.startTracking();
            }
            switch (this.bmj) {
                case 1:
                    this.bmx.onTouchEvent(this.bmi);
                    break;
                case 2:
                    this.bmx.onInterceptTouchEvent(this.bmi);
                    break;
            }
            this.mListView.requestLayout();
            if (this.bmt != null) {
                this.bmt.start();
                return true;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cW(boolean z) {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition() + (this.mListView.getChildCount() / 2);
        View childAt = this.mListView.getChildAt(this.mListView.getChildCount() / 2);
        if (childAt != null) {
            h(firstVisiblePosition, childAt, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i2, View view, boolean z) {
        this.mBlockLayoutRequests = true;
        Rt();
        int i3 = this.blF;
        int i4 = this.blG;
        boolean Rk = Rk();
        if (Rk) {
            Rr();
            this.mListView.setSelectionFromTop(i2, (b(i2, view, i3, i4) + view.getTop()) - this.mListView.getPaddingTop());
            layoutChildren();
        }
        if (Rk || z) {
            this.mListView.invalidate();
        }
        this.mBlockLayoutRequests = false;
    }

    private void Rt() {
        if (this.bmh != null) {
            this.blz.set(this.mX, this.mY);
            this.bmh.b(this.blx, this.bly, this.blz);
        }
        int i2 = this.bly.x;
        int i3 = this.bly.y;
        int paddingLeft = this.mListView.getPaddingLeft();
        if ((this.bme & 1) == 0 && i2 > paddingLeft) {
            this.bly.x = paddingLeft;
        } else if ((this.bme & 2) == 0 && i2 < paddingLeft) {
            this.bly.x = paddingLeft;
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int lastVisiblePosition = this.mListView.getLastVisiblePosition();
        int paddingTop = this.mListView.getPaddingTop();
        if (firstVisiblePosition < headerViewsCount) {
            paddingTop = this.mListView.getChildAt((headerViewsCount - firstVisiblePosition) - 1).getBottom();
        }
        if ((this.bme & 8) == 0 && firstVisiblePosition <= this.blI) {
            paddingTop = Math.max(this.mListView.getChildAt(this.blI - firstVisiblePosition).getTop(), paddingTop);
        }
        int height = this.mListView.getHeight() - this.mListView.getPaddingBottom();
        if (lastVisiblePosition >= (this.mListView.getCount() - footerViewsCount) - 1) {
            height = this.mListView.getChildAt(((this.mListView.getCount() - footerViewsCount) - 1) - firstVisiblePosition).getBottom();
        }
        if ((this.bme & 4) == 0 && lastVisiblePosition >= this.blI) {
            height = Math.min(this.mListView.getChildAt(this.blI - firstVisiblePosition).getBottom(), height);
        }
        if (i3 < paddingTop) {
            this.bly.y = paddingTop;
        } else if (this.mFloatViewHeight + i3 > height) {
            this.bly.y = height - this.mFloatViewHeight;
        }
        this.blA = this.bly.y + this.blQ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ru() {
        if (this.blx != null) {
            this.blx.setVisibility(8);
            if (this.bmh != null) {
                this.bmh.af(this.blx);
            }
            this.blx = null;
            this.mListView.invalidate();
        }
    }

    public void a(h hVar) {
        this.bmh = hVar;
    }

    public void a(b bVar) {
        this.blL = bVar;
    }

    public void setDragEnabled(boolean z) {
        this.blO = z;
    }

    public boolean isDragEnabled() {
        return this.blO;
    }

    public void a(g gVar) {
        this.blM = gVar;
    }

    public void a(l lVar) {
        this.blN = lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class i {
        private SparseIntArray bmS;
        private ArrayList<Integer> bmT;
        private int mMaxSize;

        public i(int i) {
            this.bmS = new SparseIntArray(i);
            this.bmT = new ArrayList<>(i);
            this.mMaxSize = i;
        }

        public void add(int i, int i2) {
            int i3 = this.bmS.get(i, -1);
            if (i3 != i2) {
                if (i3 == -1) {
                    if (this.bmS.size() == this.mMaxSize) {
                        this.bmS.delete(this.bmT.remove(0).intValue());
                    }
                } else {
                    this.bmT.remove(Integer.valueOf(i));
                }
                this.bmS.put(i, i2);
                this.bmT.add(Integer.valueOf(i));
            }
        }

        public int get(int i) {
            return this.bmS.get(i, -1);
        }

        public void clear() {
            this.bmS.clear();
            this.bmT.clear();
        }
    }

    /* renamed from: com.baidu.tbadk.widget.dragsort.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0177a extends BaseAdapter {
        private ListAdapter mAdapter;

        public C0177a(ListAdapter listAdapter) {
            this.mAdapter = listAdapter;
            this.mAdapter.registerDataSetObserver(new DataSetObserver() { // from class: com.baidu.tbadk.widget.dragsort.a.a.1
                @Override // android.database.DataSetObserver
                public void onChanged() {
                    C0177a.this.notifyDataSetChanged();
                }

                @Override // android.database.DataSetObserver
                public void onInvalidated() {
                    C0177a.this.notifyDataSetInvalidated();
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
        private float bnd;
        private float mA;
        private float mAlpha;
        private float mB;
        private float mC;
        private boolean mCanceled;
        private float mD;
        protected long mStartTime;

        public m(float f, int i) {
            this.mAlpha = f;
            this.bnd = i;
            float f2 = 1.0f / ((this.mAlpha * 2.0f) * (1.0f - this.mAlpha));
            this.mD = f2;
            this.mA = f2;
            this.mB = this.mAlpha / ((this.mAlpha - 1.0f) * 2.0f);
            this.mC = 1.0f / (1.0f - this.mAlpha);
        }

        public float ab(float f) {
            if (f < this.mAlpha) {
                return this.mA * f * f;
            }
            if (f < 1.0f - this.mAlpha) {
                return this.mB + (this.mC * f);
            }
            return 1.0f - ((this.mD * (f - 1.0f)) * (f - 1.0f));
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

        public void q(float f, float f2) {
        }

        public void onStop() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.mCanceled) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / this.bnd;
                if (uptimeMillis >= 1.0f) {
                    q(1.0f, 1.0f);
                    onStop();
                    return;
                }
                q(uptimeMillis, ab(uptimeMillis));
                a.this.mListView.post(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class f extends m {
        private int bmO;
        private int bmP;
        private float bmQ;
        private float bmR;

        public f(float f, int i) {
            super(f, i);
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.bmO = a.this.blE;
            this.bmP = a.this.blI;
            a.this.mDragState = 2;
            this.bmQ = a.this.bly.y - Rx();
            this.bmR = a.this.bly.x - a.this.mListView.getPaddingLeft();
        }

        private int Rx() {
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            int dividerHeight = (a.this.blP + a.this.mListView.getDividerHeight()) / 2;
            View childAt = a.this.mListView.getChildAt(this.bmO - firstVisiblePosition);
            if (childAt != null) {
                if (this.bmO == this.bmP) {
                    return childAt.getTop();
                }
                if (this.bmO >= this.bmP) {
                    return (childAt.getBottom() + dividerHeight) - a.this.mFloatViewHeight;
                }
                return childAt.getTop() - dividerHeight;
            }
            cancel();
            return -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void q(float f, float f2) {
            int Rx = Rx();
            float paddingLeft = a.this.bly.x - a.this.mListView.getPaddingLeft();
            float f3 = 1.0f - f2;
            if (f3 < Math.abs((a.this.bly.y - Rx) / this.bmQ) || f3 < Math.abs(paddingLeft / this.bmR)) {
                a.this.bly.y = Rx + ((int) (this.bmQ * f3));
                a.this.bly.x = a.this.mListView.getPaddingLeft() + ((int) (this.bmR * f3));
                a.this.cW(true);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.Rm();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class k extends m {
        private int bmP;
        private float bmW;
        private float bmX;
        private float bmY;
        private int bmZ;
        private int bna;
        private int bnb;
        private int bnc;

        public k(float f, int i) {
            super(f, i);
            this.bmZ = -1;
            this.bna = -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.bmZ = -1;
            this.bna = -1;
            this.bnb = a.this.blF;
            this.bnc = a.this.blG;
            this.bmP = a.this.blI;
            a.this.mDragState = 1;
            this.bmW = a.this.bly.x;
            if (a.this.bmv) {
                float width = a.this.mListView.getWidth() * 2.0f;
                if (a.this.bmw == 0.0f) {
                    a.this.bmw = (this.bmW >= 0.0f ? 1 : -1) * width;
                    return;
                }
                float f = width * 2.0f;
                if (a.this.bmw >= 0.0f || a.this.bmw <= (-f)) {
                    if (a.this.bmw > 0.0f && a.this.bmw < f) {
                        a.this.bmw = f;
                        return;
                    }
                    return;
                }
                a.this.bmw = -f;
                return;
            }
            a.this.Ru();
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void q(float f, float f2) {
            View childAt;
            float f3 = 1.0f - f2;
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            View childAt2 = a.this.mListView.getChildAt(this.bnb - firstVisiblePosition);
            if (a.this.bmv) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / 1000.0f;
                if (uptimeMillis != 0.0f) {
                    float f4 = a.this.bmw * uptimeMillis;
                    int width = a.this.mListView.getWidth();
                    a.this.bmw = ((a.this.bmw > 0.0f ? 1 : -1) * uptimeMillis * width) + a.this.bmw;
                    this.bmW += f4;
                    a.this.bly.x = (int) this.bmW;
                    if (this.bmW < width && this.bmW > (-width)) {
                        this.mStartTime = SystemClock.uptimeMillis();
                        a.this.cW(true);
                        return;
                    }
                } else {
                    return;
                }
            }
            if (childAt2 != null) {
                if (this.bmZ == -1) {
                    this.bmZ = a.this.f(this.bnb, childAt2, false);
                    this.bmX = childAt2.getHeight() - this.bmZ;
                }
                int max = Math.max((int) (this.bmX * f3), 1);
                ViewGroup.LayoutParams layoutParams = childAt2.getLayoutParams();
                layoutParams.height = max + this.bmZ;
                childAt2.setLayoutParams(layoutParams);
            }
            if (this.bnc != this.bnb && (childAt = a.this.mListView.getChildAt(this.bnc - firstVisiblePosition)) != null) {
                if (this.bna == -1) {
                    this.bna = a.this.f(this.bnc, childAt, false);
                    this.bmY = childAt.getHeight() - this.bna;
                }
                int max2 = Math.max((int) (this.bmY * f3), 1);
                ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
                layoutParams2.height = max2 + this.bna;
                childAt.setLayoutParams(layoutParams2);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.Rn();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class j extends m {
        final /* synthetic */ a bmB;
        private float bmU;
        private float bmV;

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.bmU = this.bmB.blK;
            this.bmV = this.bmB.blQ;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void q(float f, float f2) {
            if (this.bmB.mDragState != 4) {
                cancel();
                return;
            }
            this.bmB.blK = (int) ((this.bmV * f2) + ((1.0f - f2) * this.bmU));
            this.bmB.bly.y = this.bmB.mY - this.bmB.blK;
            this.bmB.cW(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e {
        StringBuilder mBuilder = new StringBuilder();
        private int bmL = 0;
        private int bmM = 0;
        private boolean bmN = false;
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
            this.bmM = 0;
            this.bmN = true;
        }

        public void Rw() {
            if (this.bmN) {
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
                this.mBuilder.append("    <FirstExpPos>").append(a.this.blF).append("</FirstExpPos>\n");
                this.mBuilder.append("    <FirstExpBlankHeight>").append(a.this.gv(a.this.blF) - a.this.gx(a.this.blF)).append("</FirstExpBlankHeight>\n");
                this.mBuilder.append("    <SecondExpPos>").append(a.this.blG).append("</SecondExpPos>\n");
                this.mBuilder.append("    <SecondExpBlankHeight>").append(a.this.gv(a.this.blG) - a.this.gx(a.this.blG)).append("</SecondExpBlankHeight>\n");
                this.mBuilder.append("    <SrcPos>").append(a.this.blI).append("</SrcPos>\n");
                this.mBuilder.append("    <SrcHeight>").append(a.this.mFloatViewHeight + a.this.mListView.getDividerHeight()).append("</SrcHeight>\n");
                this.mBuilder.append("    <ViewHeight>").append(a.this.mListView.getHeight()).append("</ViewHeight>\n");
                this.mBuilder.append("    <LastY>").append(a.this.mLastY).append("</LastY>\n");
                this.mBuilder.append("    <FloatY>").append(a.this.blA).append("</FloatY>\n");
                this.mBuilder.append("    <ShuffleEdges>");
                for (int i4 = 0; i4 < childCount; i4++) {
                    this.mBuilder.append(a.this.P(firstVisiblePosition + i4, a.this.mListView.getChildAt(i4).getTop())).append(",");
                }
                this.mBuilder.append("</ShuffleEdges>\n");
                this.mBuilder.append("</DSLVState>\n");
                this.bmL++;
                if (this.bmL > 1000) {
                    flush();
                    this.bmL = 0;
                }
            }
        }

        public void flush() {
            if (this.bmN) {
                try {
                    FileWriter fileWriter = new FileWriter(this.mFile, this.bmM != 0);
                    fileWriter.write(this.mBuilder.toString());
                    this.mBuilder.delete(0, this.mBuilder.length());
                    fileWriter.flush();
                    fileWriter.close();
                    this.bmM++;
                } catch (IOException e) {
                }
            }
        }

        public void oo() {
            if (this.bmN) {
                this.mBuilder.append("</DSLVStates>\n");
                flush();
                this.bmN = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements Runnable {
        private boolean bmE;
        private long bmF;
        private long bmG;
        private float bmH;
        private long bmI;
        private int bmJ;
        private float bmK;
        private int dy;
        private boolean mScrolling = false;

        public boolean isScrolling() {
            return this.mScrolling;
        }

        public int Rv() {
            if (this.mScrolling) {
                return this.bmJ;
            }
            return -1;
        }

        public d() {
        }

        public void gy(int i) {
            if (!this.mScrolling) {
                this.bmE = false;
                this.mScrolling = true;
                this.bmI = SystemClock.uptimeMillis();
                this.bmF = this.bmI;
                this.bmJ = i;
                a.this.mListView.post(this);
            }
        }

        public void cX(boolean z) {
            if (z) {
                a.this.mListView.removeCallbacks(this);
                this.mScrolling = false;
                return;
            }
            this.bmE = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.bmE) {
                int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
                int lastVisiblePosition = a.this.mListView.getLastVisiblePosition();
                int count = a.this.mListView.getCount();
                int paddingTop = a.this.mListView.getPaddingTop();
                int height = (a.this.mListView.getHeight() - paddingTop) - a.this.mListView.getPaddingBottom();
                int min = Math.min(a.this.mY, a.this.blA + a.this.blQ);
                int max = Math.max(a.this.mY, a.this.blA - a.this.blQ);
                if (this.bmJ == 0) {
                    View childAt = a.this.mListView.getChildAt(0);
                    if (childAt == null) {
                        this.mScrolling = false;
                        return;
                    } else if (firstVisiblePosition == 0 && childAt.getTop() == paddingTop) {
                        this.mScrolling = false;
                        return;
                    } else {
                        this.bmK = a.this.bmc.b((a.this.blY - max) / a.this.blZ, this.bmF);
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
                        this.bmK = -a.this.bmc.b((min - a.this.blX) / a.this.bma, this.bmF);
                    }
                }
                this.bmG = SystemClock.uptimeMillis();
                this.bmH = (float) (this.bmG - this.bmF);
                this.dy = Math.round(this.bmK * this.bmH);
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
                this.bmF = this.bmG;
                a.this.mListView.post(this);
                return;
            }
            this.mScrolling = false;
        }
    }
}
