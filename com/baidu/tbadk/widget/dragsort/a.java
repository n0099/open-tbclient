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
    private int aGU;
    private int alA;
    private int alz;
    private int amg;
    private int amh;
    private View cvZ;
    private float cwA;
    private float cwB;
    private float cwC;
    private int cwF;
    private MotionEvent cwK;
    private C0211a cwO;
    private e cwQ;
    private k cwT;
    private j cwU;
    private f cwV;
    private boolean cwW;
    private com.baidu.tbadk.widget.dragsort.d cwY;
    private com.baidu.tbadk.widget.dragsort.b cwZ;
    private int cwc;
    private int cwg;
    private int cwh;
    private int cwi;
    private int cwk;
    private int cwl;
    private int cwm;
    private b cwn;
    private g cwo;
    private l cwp;
    private int cws;
    private d cwu;
    private int cwx;
    private int cwy;
    private float cwz;
    private int mLastX;
    private int mLastY;
    private ListView mListView;
    private DataSetObserver mObserver;
    private Point cwa = new Point();
    private Point cwb = new Point();
    private boolean cwd = false;
    private float cwe = 1.0f;
    private float cwf = 1.0f;
    private boolean cwj = false;
    private boolean cwq = true;
    private int mDragState = 0;
    private int cwr = 1;
    private int mWidthMeasureSpec = 0;
    private View[] cwt = new View[1];
    private float cwv = 0.33333334f;
    private float cww = 0.33333334f;
    private float cwD = 0.5f;
    private c cwE = new c() { // from class: com.baidu.tbadk.widget.dragsort.a.1
        @Override // com.baidu.tbadk.widget.dragsort.a.c
        public float b(float f2, long j2) {
            return a.this.cwD * f2;
        }
    };
    private int cwG = 0;
    private boolean cwH = false;
    private boolean cwI = false;
    private h cwJ = null;
    private int cwL = 0;
    private float cwM = 0.25f;
    private float cwN = 0.0f;
    private boolean cwP = false;
    private boolean mBlockLayoutRequests = false;
    private boolean cwR = false;
    private i cwS = new i(3);
    private float cwX = 0.0f;
    private boolean cxa = false;
    private boolean cxb = false;

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

        void ba(View view);

        View kn(int i);
    }

    /* loaded from: classes.dex */
    public interface l {
        void remove(int i);
    }

    public a(ListView listView, com.baidu.tbadk.widget.dragsort.d dVar) {
        this.cwY = dVar;
        this.mListView = listView;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            this.cwO = new C0211a(listAdapter);
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
            this.cwO = null;
        }
        this.cwY.setAdapter(this.cwO);
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
            if (i2 > this.cwk) {
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
    public int kj(int i2) {
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        return childAt != null ? childAt.getHeight() : an(i2, kl(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int al(int i2, int i3) {
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        if (i2 <= headerViewsCount || i2 >= this.mListView.getCount() - footerViewsCount) {
            return i3;
        }
        int dividerHeight = this.mListView.getDividerHeight();
        int i4 = this.aGU - this.cwr;
        int kl = kl(i2);
        int kj = kj(i2);
        if (this.cwi <= this.cwk) {
            if (i2 == this.cwi && this.cwh != this.cwi) {
                if (i2 == this.cwk) {
                    i3 = (i3 + kj) - this.aGU;
                } else {
                    i3 = ((kj - kl) + i3) - i4;
                }
            } else if (i2 > this.cwi && i2 <= this.cwk) {
                i3 -= i4;
            }
        } else if (i2 > this.cwk && i2 <= this.cwh) {
            i3 += i4;
        } else if (i2 == this.cwi && this.cwh != this.cwi) {
            i3 += kj - kl;
        }
        if (i2 <= this.cwk) {
            return (((this.aGU - dividerHeight) - kl(i2 - 1)) / 2) + i3;
        }
        return (((kl - dividerHeight) - this.aGU) / 2) + i3;
    }

    private boolean ard() {
        int i2;
        int i3;
        int i4;
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int i5 = this.cwh;
        View childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        if (childAt == null) {
            i5 = firstVisiblePosition + (this.mListView.getChildCount() / 2);
            childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        }
        int top = childAt.getTop();
        int height = childAt.getHeight();
        int al = al(i5, top);
        int dividerHeight = this.mListView.getDividerHeight();
        if (this.cwc >= al) {
            int count = this.mListView.getCount();
            int i6 = height;
            int i7 = top;
            i2 = al;
            i3 = i5;
            i4 = al;
            while (true) {
                if (i3 < count) {
                    if (i3 == count - 1) {
                        i2 = i7 + dividerHeight + i6;
                        break;
                    }
                    i7 += dividerHeight + i6;
                    i6 = kj(i3 + 1);
                    i2 = al(i3 + 1, i7);
                    if (this.cwc < i2) {
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
            i2 = al;
            i3 = i5;
            i4 = al;
            while (true) {
                if (i3 < 0) {
                    break;
                }
                i3--;
                int kj = kj(i3);
                if (i3 == 0) {
                    i2 = (i8 - dividerHeight) - kj;
                    break;
                }
                i8 -= kj + dividerHeight;
                i2 = al(i3, i8);
                if (this.cwc >= i2) {
                    break;
                }
                i4 = i2;
            }
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int i9 = this.cwh;
        int i10 = this.cwi;
        float f2 = this.cwN;
        if (this.cwj) {
            int abs = Math.abs(i2 - i4);
            if (this.cwc >= i2) {
                int i11 = i4;
                i4 = i2;
                i2 = i11;
            }
            int i12 = (int) (abs * this.cwM * 0.5f);
            float f3 = i12;
            int i13 = i4 + i12;
            int i14 = i2 - i12;
            if (this.cwc < i13) {
                this.cwh = i3 - 1;
                this.cwi = i3;
                this.cwN = ((i13 - this.cwc) * 0.5f) / f3;
            } else if (this.cwc < i14) {
                this.cwh = i3;
                this.cwi = i3;
            } else {
                this.cwh = i3;
                this.cwi = i3 + 1;
                this.cwN = (1.0f + ((i2 - this.cwc) / f3)) * 0.5f;
            }
        } else {
            this.cwh = i3;
            this.cwi = i3;
        }
        if (this.cwh < headerViewsCount) {
            this.cwh = headerViewsCount;
            this.cwi = headerViewsCount;
            i3 = headerViewsCount;
        } else if (this.cwi >= this.mListView.getCount() - footerViewsCount) {
            i3 = (this.mListView.getCount() - footerViewsCount) - 1;
            this.cwh = i3;
            this.cwi = i3;
        }
        boolean z = (this.cwh == i9 && this.cwi == i10 && this.cwN == f2) ? false : true;
        if (i3 != this.cwg) {
            if (this.cwn != null) {
                this.cwn.drag(this.cwg - headerViewsCount, i3 - headerViewsCount);
            }
            this.cwg = i3;
            return true;
        }
        return z;
    }

    public void removeItem(int i2) {
        this.cwW = false;
        removeItem(i2, 0.0f);
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void a(ListView listView, Context context, AttributeSet attributeSet) {
        int i2;
        int i3 = BaseActivity.SHOW_SOFT_KEYBOARD_DELAY;
        if (attributeSet == null) {
            i2 = 150;
        } else {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.DragSort, 0, 0);
            this.cwr = Math.max(1, obtainStyledAttributes.getDimensionPixelSize(d.l.DragSort_collapsed_height, 1));
            this.cwP = obtainStyledAttributes.getBoolean(d.l.DragSort_track_drag_sort, false);
            if (this.cwP) {
                this.cwQ = new e();
            }
            this.cwe = obtainStyledAttributes.getFloat(d.l.DragSort_float_alpha, this.cwe);
            this.cwf = this.cwe;
            this.cwq = obtainStyledAttributes.getBoolean(d.l.DragSort_drag_enabled, this.cwq);
            this.cwM = Math.max(0.0f, Math.min(1.0f, 1.0f - obtainStyledAttributes.getFloat(d.l.DragSort_slide_shuffle_speed, 0.75f)));
            this.cwj = this.cwM > 0.0f;
            setDragScrollStart(obtainStyledAttributes.getFloat(d.l.DragSort_drag_scroll_start, this.cwv));
            this.cwD = obtainStyledAttributes.getFloat(d.l.DragSort_max_drag_scroll_speed, this.cwD);
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
                bVar.fp(z);
                bVar.fo(z2);
                bVar.setBackgroundColor(color);
                this.cwJ = bVar;
                a(bVar);
            }
            obtainStyledAttributes.recycle();
            i2 = i5;
            i3 = i4;
        }
        this.cwu = new d();
        if (i3 > 0) {
            this.cwT = new k(0.5f, i3);
        }
        if (i2 > 0) {
            this.cwV = new f(0.5f, i2);
        }
        this.cwK = MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
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
        this.cwZ = bVar;
        this.mListView.setOnTouchListener(bVar);
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void dispatchDraw(Canvas canvas) {
        float f2;
        this.cwY.dispatchDraw(canvas);
        if (this.mDragState != 0) {
            if (this.cwh != this.cwk) {
                b(this.cwh, canvas);
            }
            if (this.cwi != this.cwh && this.cwi != this.cwk) {
                b(this.cwi, canvas);
            }
        }
        if (this.cvZ != null) {
            int width = this.cvZ.getWidth();
            int height = this.cvZ.getHeight();
            int i2 = this.cwa.x;
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
            int i3 = (int) (f2 * 255.0f * this.cwf);
            canvas.save();
            canvas.translate(this.cwa.x, this.cwa.y);
            canvas.clipRect(0, 0, width, height);
            canvas.saveLayerAlpha(0.0f, 0.0f, width, height, i3, 31);
            this.cvZ.draw(canvas);
            canvas.restore();
            canvas.restore();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onDraw(Canvas canvas) {
        this.cwY.onDraw(canvas);
        if (this.cwP) {
            this.cwQ.arq();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.cwR) {
            this.cwR = false;
            return false;
        } else if (!this.cwq) {
            return this.cwY.onTouchEvent(motionEvent);
        } else {
            boolean z2 = this.cwH;
            this.cwH = false;
            if (!z2) {
                y(motionEvent);
            }
            if (this.mDragState == 4) {
                onDragTouchEvent(motionEvent);
                return true;
            }
            if (this.mDragState == 0 && this.cwY.onTouchEvent(motionEvent)) {
                z = true;
            }
            switch (motionEvent.getAction() & 255) {
                case 1:
                case 3:
                    ari();
                    return z;
                case 2:
                default:
                    if (z) {
                        this.cwL = 1;
                        return z;
                    }
                    return z;
            }
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (!this.cwq) {
            return this.cwY.onInterceptTouchEvent(motionEvent);
        }
        if (this.cwZ != null) {
            this.cwZ.ars().onTouchEvent(motionEvent);
        }
        y(motionEvent);
        this.cwH = true;
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            if (this.mDragState != 0) {
                this.cwR = true;
                return true;
            }
            this.cwI = true;
        }
        if (this.cvZ == null) {
            if (this.cwY.onInterceptTouchEvent(motionEvent)) {
                this.cxa = true;
                z = true;
            } else {
                z = false;
            }
            switch (action) {
                case 1:
                case 3:
                    ari();
                    break;
                case 2:
                default:
                    if (z) {
                        this.cwL = 1;
                        break;
                    } else {
                        this.cwL = 2;
                        break;
                    }
            }
        } else {
            z = true;
        }
        if (action == 1 || action == 3) {
            this.cwI = false;
        }
        return z;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        this.cwY.onSizeChanged(i2, i3, i4, i5);
        arj();
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void requestLayout() {
        if (!this.mBlockLayoutRequests) {
            this.cwY.requestLayout();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onMeasure(int i2, int i3) {
        this.cwY.onMeasure(i2, i3);
        if (this.cvZ != null) {
            if (this.cvZ.isLayoutRequested()) {
                arl();
            }
            this.cwd = true;
        }
        this.mWidthMeasureSpec = i2;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void layoutChildren() {
        this.cwY.layoutChildren();
        if (this.cvZ != null) {
            if (this.cvZ.isLayoutRequested() && !this.cwd) {
                arl();
            }
            this.cvZ.layout(0, 0, this.cvZ.getMeasuredWidth(), this.cvZ.getMeasuredHeight());
            this.cwd = false;
        }
    }

    public void removeItem(int i2, float f2) {
        if (this.mDragState == 0 || this.mDragState == 4) {
            if (this.mDragState == 0) {
                this.cwk = this.mListView.getHeaderViewsCount() + i2;
                this.cwh = this.cwk;
                this.cwi = this.cwk;
                this.cwg = this.cwk;
                View childAt = this.mListView.getChildAt(this.cwk - this.mListView.getFirstVisiblePosition());
                if (childAt != null) {
                    childAt.setVisibility(4);
                }
            }
            this.mDragState = 1;
            this.cwX = f2;
            if (this.cwI) {
                switch (this.cwL) {
                    case 1:
                        this.cwY.onTouchEvent(this.cwK);
                        break;
                    case 2:
                        this.cwY.onInterceptTouchEvent(this.cwK);
                        break;
                }
            }
            if (this.cwT != null) {
                this.cwT.start();
            } else {
                kk(i2);
            }
        }
    }

    public void cancelDrag() {
        if (this.mDragState == 4) {
            this.cwu.fn(true);
            arn();
            are();
            ark();
            if (this.cwI) {
                this.mDragState = 3;
            } else {
                this.mDragState = 0;
            }
        }
    }

    private void are() {
        this.cwk = -1;
        this.cwh = -1;
        this.cwi = -1;
        this.cwg = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void arf() {
        this.mDragState = 2;
        if (this.cwo != null && this.cwg >= 0 && this.cwg < this.mListView.getCount()) {
            int headerViewsCount = this.mListView.getHeaderViewsCount();
            this.cwo.drop(this.cwk - headerViewsCount, this.cwg - headerViewsCount);
        }
        arn();
        arh();
        are();
        ark();
        if (this.cwI) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void arg() {
        kk(this.cwk - this.mListView.getHeaderViewsCount());
    }

    private void kk(int i2) {
        this.mDragState = 1;
        if (this.cwp != null) {
            this.cwp.remove(i2);
        }
        arn();
        arh();
        are();
        if (this.cwI) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    private void arh() {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        if (this.cwk < firstVisiblePosition) {
            View childAt = this.mListView.getChildAt(0);
            this.mListView.setSelectionFromTop(firstVisiblePosition - 1, (childAt != null ? childAt.getTop() : 0) - this.mListView.getPaddingTop());
        }
    }

    public boolean stopDrag(boolean z) {
        this.cwW = false;
        return stopDrag(z, 0.0f);
    }

    public boolean stopDragWithVelocity(boolean z, float f2) {
        this.cwW = true;
        return stopDrag(z, f2);
    }

    public boolean stopDrag(boolean z, float f2) {
        if (this.cvZ != null) {
            this.cwu.fn(true);
            if (z) {
                removeItem(this.cwk - this.mListView.getHeaderViewsCount(), f2);
            } else if (this.cwV != null) {
                this.cwV.start();
            } else {
                arf();
            }
            if (this.cwP) {
                this.cwQ.ot();
                return true;
            }
            return true;
        }
        return false;
    }

    private void ari() {
        this.cwL = 0;
        this.cwI = false;
        if (this.mDragState == 3) {
            this.mDragState = 0;
        }
        this.cwf = this.cwe;
        this.cxa = false;
        this.cwS.clear();
    }

    private void y(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            this.mLastX = this.alz;
            this.mLastY = this.alA;
        }
        this.alz = (int) motionEvent.getX();
        this.alA = (int) motionEvent.getY();
        if (action == 0) {
            this.mLastX = this.alz;
            this.mLastY = this.alA;
        }
        this.amg = ((int) motionEvent.getRawX()) - this.alz;
        this.amh = ((int) motionEvent.getRawY()) - this.alA;
    }

    public boolean listViewIntercepted() {
        return this.cxa;
    }

    public void setDragScrollStart(float f2) {
        setDragScrollStarts(f2, f2);
    }

    public void setDragScrollStarts(float f2, float f3) {
        if (f3 > 0.5f) {
            this.cww = 0.5f;
        } else {
            this.cww = f3;
        }
        if (f2 > 0.5f) {
            this.cwv = 0.5f;
        } else {
            this.cwv = f2;
        }
        if (this.mListView.getHeight() != 0) {
            arj();
        }
    }

    private void am(int i2, int i3) {
        this.cwa.x = i2 - this.cwl;
        this.cwa.y = i3 - this.cwm;
        fm(true);
        int min = Math.min(i3, this.cwc + this.cws);
        int max = Math.max(i3, this.cwc - this.cws);
        int arp = this.cwu.arp();
        if (min > this.mLastY && min > this.cwy && arp != 1) {
            if (arp != -1) {
                this.cwu.fn(true);
            }
            this.cwu.km(1);
        } else if (max < this.mLastY && max < this.cwx && arp != 0) {
            if (arp != -1) {
                this.cwu.fn(true);
            }
            this.cwu.km(0);
        } else if (max >= this.cwx && min <= this.cwy && this.cwu.aro()) {
            this.cwu.fn(true);
        }
    }

    private void arj() {
        int height;
        int paddingTop = this.mListView.getPaddingTop();
        float height2 = (this.mListView.getHeight() - paddingTop) - this.mListView.getPaddingBottom();
        this.cwA = paddingTop + (this.cwv * height2);
        this.cwz = (height2 * (1.0f - this.cww)) + paddingTop;
        this.cwx = (int) this.cwA;
        this.cwy = (int) this.cwz;
        this.cwB = this.cwA - paddingTop;
        this.cwC = (paddingTop + height) - this.cwz;
    }

    private void ark() {
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
        if (i2 != this.cwk && i2 != this.cwh && i2 != this.cwi) {
            g2 = -2;
        } else {
            g2 = g(i2, view, z);
        }
        if (g2 != layoutParams.height) {
            layoutParams.height = g2;
            view.setLayoutParams(layoutParams);
        }
        if (i2 == this.cwh || i2 == this.cwi) {
            if (i2 < this.cwk) {
                ((DragSortItemView) view).setGravity(80);
            } else if (i2 > this.cwk) {
                ((DragSortItemView) view).setGravity(48);
            }
        }
        int visibility = view.getVisibility();
        int i3 = 0;
        if (i2 == this.cwk && this.cvZ != null) {
            i3 = 4;
        }
        if (i3 != visibility) {
            view.setVisibility(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int kl(int i2) {
        View view;
        if (i2 == this.cwk) {
            return 0;
        }
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        if (childAt != null) {
            return f(i2, childAt, false);
        }
        int i3 = this.cwS.get(i2);
        if (i3 == -1) {
            ListAdapter adapter = this.mListView.getAdapter();
            int itemViewType = adapter.getItemViewType(i2);
            int viewTypeCount = adapter.getViewTypeCount();
            if (viewTypeCount != this.cwt.length) {
                this.cwt = new View[viewTypeCount];
            }
            if (itemViewType >= 0) {
                if (this.cwt[itemViewType] == null) {
                    view = adapter.getView(i2, null, this.mListView);
                    this.cwt[itemViewType] = view;
                } else {
                    view = adapter.getView(i2, this.cwt[itemViewType], this.mListView);
                }
            } else {
                view = adapter.getView(i2, null, this.mListView);
            }
            int f2 = f(i2, view, true);
            this.cwS.add(i2, f2);
            return f2;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(int i2, View view, boolean z) {
        if (i2 == this.cwk) {
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
        return an(i2, f(i2, view, z));
    }

    private int an(int i2, int i3) {
        this.mListView.getDividerHeight();
        boolean z = this.cwj && this.cwh != this.cwi;
        int i4 = this.aGU - this.cwr;
        int i5 = (int) (this.cwN * i4);
        if (i2 == this.cwk) {
            if (this.cwk == this.cwh) {
                if (z) {
                    return i5 + this.cwr;
                }
                return this.aGU;
            } else if (this.cwk == this.cwi) {
                return this.aGU - i5;
            } else {
                return this.cwr;
            }
        } else if (i2 == this.cwh) {
            if (z) {
                return i3 + i5;
            }
            return i3 + i4;
        } else if (i2 == this.cwi) {
            return (i3 + i4) - i5;
        } else {
            return i3;
        }
    }

    private int b(int i2, View view, int i3, int i4) {
        int i5;
        int i6;
        int kl = kl(i2);
        int height = view.getHeight();
        int an = an(i2, kl);
        if (i2 != this.cwk) {
            i6 = height - kl;
            i5 = an - kl;
        } else {
            i5 = an;
            i6 = height;
        }
        int i7 = this.aGU;
        if (this.cwk != this.cwh && this.cwk != this.cwi) {
            i7 -= this.cwr;
        }
        if (i2 <= i3) {
            if (i2 > this.cwh) {
                return (i7 - i5) + 0;
            }
        } else if (i2 == i4) {
            if (i2 <= this.cwh) {
                return (i6 - i7) + 0;
            }
            if (i2 == this.cwi) {
                return (height - an) + 0;
            }
            return 0 + i6;
        } else if (i2 <= this.cwh) {
            return 0 - i7;
        } else {
            if (i2 == this.cwi) {
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

    private void arl() {
        if (this.cvZ != null) {
            measureItem(this.cvZ);
            this.aGU = this.cvZ.getMeasuredHeight();
            this.cws = this.aGU / 2;
        }
    }

    protected boolean onDragTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        switch (motionEvent.getAction() & 255) {
            case 1:
                if (this.mDragState == 4) {
                    stopDrag(false);
                }
                ari();
                return true;
            case 2:
                am((int) motionEvent.getX(), (int) motionEvent.getY());
                return true;
            case 3:
                if (this.mDragState == 4) {
                    cancelDrag();
                }
                ari();
                return true;
            default:
                return true;
        }
    }

    public boolean startDrag(int i2, int i3, int i4, int i5) {
        View kn;
        if (!this.cwI || this.cwJ == null || (kn = this.cwJ.kn(i2)) == null) {
            return false;
        }
        return startDrag(i2, kn, i3, i4, i5);
    }

    public boolean startDrag(int i2, View view, int i3, int i4, int i5) {
        if (this.mDragState == 0 && this.cwI && this.cvZ == null && view != null && this.cwq) {
            if (this.mListView.getParent() != null) {
                this.mListView.getParent().requestDisallowInterceptTouchEvent(true);
            }
            int headerViewsCount = this.mListView.getHeaderViewsCount() + i2;
            this.cwh = headerViewsCount;
            this.cwi = headerViewsCount;
            this.cwk = headerViewsCount;
            this.cwg = headerViewsCount;
            this.mDragState = 4;
            this.cwG = 0;
            this.cwG |= i3;
            this.cvZ = view;
            arl();
            this.cwl = i4;
            this.cwm = i5;
            this.cwF = this.alA;
            this.cwa.x = this.alz - this.cwl;
            this.cwa.y = this.alA - this.cwm;
            View childAt = this.mListView.getChildAt(this.cwk - this.mListView.getFirstVisiblePosition());
            if (childAt != null) {
                childAt.setVisibility(4);
            }
            if (this.cwP) {
                this.cwQ.startTracking();
            }
            switch (this.cwL) {
                case 1:
                    this.cwY.onTouchEvent(this.cwK);
                    break;
                case 2:
                    this.cwY.onInterceptTouchEvent(this.cwK);
                    break;
            }
            this.mListView.requestLayout();
            if (this.cwU != null) {
                this.cwU.start();
                return true;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fm(boolean z) {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition() + (this.mListView.getChildCount() / 2);
        View childAt = this.mListView.getChildAt(this.mListView.getChildCount() / 2);
        if (childAt != null) {
            h(firstVisiblePosition, childAt, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i2, View view, boolean z) {
        this.mBlockLayoutRequests = true;
        arm();
        int i3 = this.cwh;
        int i4 = this.cwi;
        boolean ard = ard();
        if (ard) {
            ark();
            this.mListView.setSelectionFromTop(i2, (b(i2, view, i3, i4) + view.getTop()) - this.mListView.getPaddingTop());
            layoutChildren();
        }
        if (ard || z) {
            this.mListView.invalidate();
        }
        this.mBlockLayoutRequests = false;
    }

    private void arm() {
        if (this.cwJ != null) {
            this.cwb.set(this.alz, this.alA);
            this.cwJ.b(this.cvZ, this.cwa, this.cwb);
        }
        int i2 = this.cwa.x;
        int i3 = this.cwa.y;
        int paddingLeft = this.mListView.getPaddingLeft();
        if ((this.cwG & 1) == 0 && i2 > paddingLeft) {
            this.cwa.x = paddingLeft;
        } else if ((this.cwG & 2) == 0 && i2 < paddingLeft) {
            this.cwa.x = paddingLeft;
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int lastVisiblePosition = this.mListView.getLastVisiblePosition();
        int paddingTop = this.mListView.getPaddingTop();
        if (firstVisiblePosition < headerViewsCount) {
            paddingTop = this.mListView.getChildAt((headerViewsCount - firstVisiblePosition) - 1).getBottom();
        }
        if ((this.cwG & 8) == 0 && firstVisiblePosition <= this.cwk) {
            paddingTop = Math.max(this.mListView.getChildAt(this.cwk - firstVisiblePosition).getTop(), paddingTop);
        }
        int height = this.mListView.getHeight() - this.mListView.getPaddingBottom();
        if (lastVisiblePosition >= (this.mListView.getCount() - footerViewsCount) - 1) {
            height = this.mListView.getChildAt(((this.mListView.getCount() - footerViewsCount) - 1) - firstVisiblePosition).getBottom();
        }
        if ((this.cwG & 4) == 0 && lastVisiblePosition >= this.cwk) {
            height = Math.min(this.mListView.getChildAt(this.cwk - firstVisiblePosition).getBottom(), height);
        }
        if (i3 < paddingTop) {
            this.cwa.y = paddingTop;
        } else if (this.aGU + i3 > height) {
            this.cwa.y = height - this.aGU;
        }
        this.cwc = this.cwa.y + this.cws;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void arn() {
        if (this.cvZ != null) {
            this.cvZ.setVisibility(8);
            if (this.cwJ != null) {
                this.cwJ.ba(this.cvZ);
            }
            this.cvZ = null;
            this.mListView.invalidate();
        }
    }

    public void a(h hVar) {
        this.cwJ = hVar;
    }

    public void a(b bVar) {
        this.cwn = bVar;
    }

    public void setDragEnabled(boolean z) {
        this.cwq = z;
    }

    public boolean isDragEnabled() {
        return this.cwq;
    }

    public void a(g gVar) {
        this.cwo = gVar;
    }

    public void a(l lVar) {
        this.cwp = lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class i {
        private SparseIntArray cxt;
        private ArrayList<Integer> cxu;
        private int mMaxSize;

        public i(int i) {
            this.cxt = new SparseIntArray(i);
            this.cxu = new ArrayList<>(i);
            this.mMaxSize = i;
        }

        public void add(int i, int i2) {
            int i3 = this.cxt.get(i, -1);
            if (i3 != i2) {
                if (i3 == -1) {
                    if (this.cxt.size() == this.mMaxSize) {
                        this.cxt.delete(this.cxu.remove(0).intValue());
                    }
                } else {
                    this.cxu.remove(Integer.valueOf(i));
                }
                this.cxt.put(i, i2);
                this.cxu.add(Integer.valueOf(i));
            }
        }

        public int get(int i) {
            return this.cxt.get(i, -1);
        }

        public void clear() {
            this.cxt.clear();
            this.cxu.clear();
        }
    }

    /* renamed from: com.baidu.tbadk.widget.dragsort.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0211a extends BaseAdapter {
        private ListAdapter mAdapter;

        public C0211a(ListAdapter listAdapter) {
            this.mAdapter = listAdapter;
            this.mAdapter.registerDataSetObserver(new DataSetObserver() { // from class: com.baidu.tbadk.widget.dragsort.a.a.1
                @Override // android.database.DataSetObserver
                public void onChanged() {
                    C0211a.this.notifyDataSetChanged();
                }

                @Override // android.database.DataSetObserver
                public void onInvalidated() {
                    C0211a.this.notifyDataSetInvalidated();
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
        private float ama;
        private float amb;
        private float amc;
        private float amd;
        private float cxE;
        private float mAlpha;
        private boolean mCanceled;
        protected long mStartTime;

        public m(float f, int i) {
            this.mAlpha = f;
            this.cxE = i;
            float f2 = 1.0f / ((this.mAlpha * 2.0f) * (1.0f - this.mAlpha));
            this.amd = f2;
            this.ama = f2;
            this.amb = this.mAlpha / ((this.mAlpha - 1.0f) * 2.0f);
            this.amc = 1.0f / (1.0f - this.mAlpha);
        }

        public float ao(float f) {
            if (f < this.mAlpha) {
                return this.ama * f * f;
            }
            if (f < 1.0f - this.mAlpha) {
                return this.amb + (this.amc * f);
            }
            return 1.0f - ((this.amd * (f - 1.0f)) * (f - 1.0f));
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

        public void t(float f, float f2) {
        }

        public void onStop() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.mCanceled) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / this.cxE;
                if (uptimeMillis >= 1.0f) {
                    t(1.0f, 1.0f);
                    onStop();
                    return;
                }
                t(uptimeMillis, ao(uptimeMillis));
                a.this.mListView.post(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class f extends m {
        private int cxp;
        private int cxq;
        private float cxr;
        private float cxs;

        public f(float f, int i) {
            super(f, i);
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.cxp = a.this.cwg;
            this.cxq = a.this.cwk;
            a.this.mDragState = 2;
            this.cxr = a.this.cwa.y - arr();
            this.cxs = a.this.cwa.x - a.this.mListView.getPaddingLeft();
        }

        private int arr() {
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            int dividerHeight = (a.this.cwr + a.this.mListView.getDividerHeight()) / 2;
            View childAt = a.this.mListView.getChildAt(this.cxp - firstVisiblePosition);
            if (childAt != null) {
                if (this.cxp == this.cxq) {
                    return childAt.getTop();
                }
                if (this.cxp >= this.cxq) {
                    return (childAt.getBottom() + dividerHeight) - a.this.aGU;
                }
                return childAt.getTop() - dividerHeight;
            }
            cancel();
            return -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void t(float f, float f2) {
            int arr = arr();
            float paddingLeft = a.this.cwa.x - a.this.mListView.getPaddingLeft();
            float f3 = 1.0f - f2;
            if (f3 < Math.abs((a.this.cwa.y - arr) / this.cxr) || f3 < Math.abs(paddingLeft / this.cxs)) {
                a.this.cwa.y = arr + ((int) (this.cxr * f3));
                a.this.cwa.x = a.this.mListView.getPaddingLeft() + ((int) (this.cxs * f3));
                a.this.fm(true);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.arf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class k extends m {
        private int cxA;
        private int cxB;
        private int cxC;
        private int cxD;
        private int cxq;
        private float cxx;
        private float cxy;
        private float cxz;

        public k(float f, int i) {
            super(f, i);
            this.cxA = -1;
            this.cxB = -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.cxA = -1;
            this.cxB = -1;
            this.cxC = a.this.cwh;
            this.cxD = a.this.cwi;
            this.cxq = a.this.cwk;
            a.this.mDragState = 1;
            this.cxx = a.this.cwa.x;
            if (a.this.cwW) {
                float width = a.this.mListView.getWidth() * 2.0f;
                if (a.this.cwX == 0.0f) {
                    a.this.cwX = (this.cxx >= 0.0f ? 1 : -1) * width;
                    return;
                }
                float f = width * 2.0f;
                if (a.this.cwX >= 0.0f || a.this.cwX <= (-f)) {
                    if (a.this.cwX > 0.0f && a.this.cwX < f) {
                        a.this.cwX = f;
                        return;
                    }
                    return;
                }
                a.this.cwX = -f;
                return;
            }
            a.this.arn();
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void t(float f, float f2) {
            View childAt;
            float f3 = 1.0f - f2;
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            View childAt2 = a.this.mListView.getChildAt(this.cxC - firstVisiblePosition);
            if (a.this.cwW) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / 1000.0f;
                if (uptimeMillis != 0.0f) {
                    float f4 = a.this.cwX * uptimeMillis;
                    int width = a.this.mListView.getWidth();
                    a.this.cwX = ((a.this.cwX > 0.0f ? 1 : -1) * uptimeMillis * width) + a.this.cwX;
                    this.cxx += f4;
                    a.this.cwa.x = (int) this.cxx;
                    if (this.cxx < width && this.cxx > (-width)) {
                        this.mStartTime = SystemClock.uptimeMillis();
                        a.this.fm(true);
                        return;
                    }
                } else {
                    return;
                }
            }
            if (childAt2 != null) {
                if (this.cxA == -1) {
                    this.cxA = a.this.f(this.cxC, childAt2, false);
                    this.cxy = childAt2.getHeight() - this.cxA;
                }
                int max = Math.max((int) (this.cxy * f3), 1);
                ViewGroup.LayoutParams layoutParams = childAt2.getLayoutParams();
                layoutParams.height = max + this.cxA;
                childAt2.setLayoutParams(layoutParams);
            }
            if (this.cxD != this.cxC && (childAt = a.this.mListView.getChildAt(this.cxD - firstVisiblePosition)) != null) {
                if (this.cxB == -1) {
                    this.cxB = a.this.f(this.cxD, childAt, false);
                    this.cxz = childAt.getHeight() - this.cxB;
                }
                int max2 = Math.max((int) (this.cxz * f3), 1);
                ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
                layoutParams2.height = max2 + this.cxB;
                childAt.setLayoutParams(layoutParams2);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.arg();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class j extends m {
        final /* synthetic */ a cxc;
        private float cxv;
        private float cxw;

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.cxv = this.cxc.cwm;
            this.cxw = this.cxc.cws;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void t(float f, float f2) {
            if (this.cxc.mDragState != 4) {
                cancel();
                return;
            }
            this.cxc.cwm = (int) ((this.cxw * f2) + ((1.0f - f2) * this.cxv));
            this.cxc.cwa.y = this.cxc.alA - this.cxc.cwm;
            this.cxc.fm(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e {
        StringBuilder mBuilder = new StringBuilder();
        private int cxm = 0;
        private int cxn = 0;
        private boolean cxo = false;
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
            this.cxn = 0;
            this.cxo = true;
        }

        public void arq() {
            if (this.cxo) {
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
                this.mBuilder.append("    <FirstExpPos>").append(a.this.cwh).append("</FirstExpPos>\n");
                this.mBuilder.append("    <FirstExpBlankHeight>").append(a.this.kj(a.this.cwh) - a.this.kl(a.this.cwh)).append("</FirstExpBlankHeight>\n");
                this.mBuilder.append("    <SecondExpPos>").append(a.this.cwi).append("</SecondExpPos>\n");
                this.mBuilder.append("    <SecondExpBlankHeight>").append(a.this.kj(a.this.cwi) - a.this.kl(a.this.cwi)).append("</SecondExpBlankHeight>\n");
                this.mBuilder.append("    <SrcPos>").append(a.this.cwk).append("</SrcPos>\n");
                this.mBuilder.append("    <SrcHeight>").append(a.this.aGU + a.this.mListView.getDividerHeight()).append("</SrcHeight>\n");
                this.mBuilder.append("    <ViewHeight>").append(a.this.mListView.getHeight()).append("</ViewHeight>\n");
                this.mBuilder.append("    <LastY>").append(a.this.mLastY).append("</LastY>\n");
                this.mBuilder.append("    <FloatY>").append(a.this.cwc).append("</FloatY>\n");
                this.mBuilder.append("    <ShuffleEdges>");
                for (int i4 = 0; i4 < childCount; i4++) {
                    this.mBuilder.append(a.this.al(firstVisiblePosition + i4, a.this.mListView.getChildAt(i4).getTop())).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                this.mBuilder.append("</ShuffleEdges>\n");
                this.mBuilder.append("</DSLVState>\n");
                this.cxm++;
                if (this.cxm > 1000) {
                    flush();
                    this.cxm = 0;
                }
            }
        }

        public void flush() {
            if (this.cxo) {
                try {
                    FileWriter fileWriter = new FileWriter(this.mFile, this.cxn != 0);
                    fileWriter.write(this.mBuilder.toString());
                    this.mBuilder.delete(0, this.mBuilder.length());
                    fileWriter.flush();
                    fileWriter.close();
                    this.cxn++;
                } catch (IOException e) {
                }
            }
        }

        public void ot() {
            if (this.cxo) {
                this.mBuilder.append("</DSLVStates>\n");
                flush();
                this.cxo = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements Runnable {
        private boolean aKD = false;
        private boolean cxf;
        private long cxg;
        private long cxh;
        private float cxi;
        private long cxj;
        private int cxk;
        private float cxl;
        private int dy;

        public boolean aro() {
            return this.aKD;
        }

        public int arp() {
            if (this.aKD) {
                return this.cxk;
            }
            return -1;
        }

        public d() {
        }

        public void km(int i) {
            if (!this.aKD) {
                this.cxf = false;
                this.aKD = true;
                this.cxj = SystemClock.uptimeMillis();
                this.cxg = this.cxj;
                this.cxk = i;
                a.this.mListView.post(this);
            }
        }

        public void fn(boolean z) {
            if (z) {
                a.this.mListView.removeCallbacks(this);
                this.aKD = false;
                return;
            }
            this.cxf = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.cxf) {
                int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
                int lastVisiblePosition = a.this.mListView.getLastVisiblePosition();
                int count = a.this.mListView.getCount();
                int paddingTop = a.this.mListView.getPaddingTop();
                int height = (a.this.mListView.getHeight() - paddingTop) - a.this.mListView.getPaddingBottom();
                int min = Math.min(a.this.alA, a.this.cwc + a.this.cws);
                int max = Math.max(a.this.alA, a.this.cwc - a.this.cws);
                if (this.cxk == 0) {
                    View childAt = a.this.mListView.getChildAt(0);
                    if (childAt == null) {
                        this.aKD = false;
                        return;
                    } else if (firstVisiblePosition == 0 && childAt.getTop() == paddingTop) {
                        this.aKD = false;
                        return;
                    } else {
                        this.cxl = a.this.cwE.b((a.this.cwA - max) / a.this.cwB, this.cxg);
                    }
                } else {
                    View childAt2 = a.this.mListView.getChildAt(lastVisiblePosition - firstVisiblePosition);
                    if (childAt2 == null) {
                        this.aKD = false;
                        return;
                    } else if (lastVisiblePosition == count - 1 && childAt2.getBottom() <= height + paddingTop) {
                        this.aKD = false;
                        return;
                    } else {
                        this.cxl = -a.this.cwE.b((min - a.this.cwz) / a.this.cwC, this.cxg);
                    }
                }
                this.cxh = SystemClock.uptimeMillis();
                this.cxi = (float) (this.cxh - this.cxg);
                this.dy = Math.round(this.cxl * this.cxi);
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
                this.cxg = this.cxh;
                a.this.mListView.post(this);
                return;
            }
            this.aKD = false;
        }
    }
}
