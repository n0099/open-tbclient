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
    private int aGV;
    private int alA;
    private int alB;
    private int amh;
    private int ami;
    private View cvW;
    private int cvZ;
    private int cwC;
    private MotionEvent cwH;
    private C0245a cwL;
    private e cwN;
    private k cwQ;
    private j cwR;
    private f cwS;
    private boolean cwT;
    private com.baidu.tbadk.widget.dragsort.d cwV;
    private com.baidu.tbadk.widget.dragsort.b cwW;
    private int cwd;
    private int cwe;
    private int cwf;
    private int cwh;
    private int cwi;
    private int cwj;
    private b cwk;
    private g cwl;
    private l cwm;
    private int cwp;
    private d cwr;
    private int cwu;
    private int cwv;
    private float cww;
    private float cwx;
    private float cwy;
    private float cwz;
    private int mLastX;
    private int mLastY;
    private ListView mListView;
    private DataSetObserver mObserver;
    private Point cvX = new Point();
    private Point cvY = new Point();
    private boolean cwa = false;
    private float cwb = 1.0f;
    private float cwc = 1.0f;
    private boolean cwg = false;
    private boolean cwn = true;
    private int mDragState = 0;
    private int cwo = 1;
    private int mWidthMeasureSpec = 0;
    private View[] cwq = new View[1];
    private float cws = 0.33333334f;
    private float cwt = 0.33333334f;
    private float cwA = 0.5f;
    private c cwB = new c() { // from class: com.baidu.tbadk.widget.dragsort.a.1
        @Override // com.baidu.tbadk.widget.dragsort.a.c
        public float b(float f2, long j2) {
            return a.this.cwA * f2;
        }
    };
    private int cwD = 0;
    private boolean cwE = false;
    private boolean cwF = false;
    private h cwG = null;
    private int cwI = 0;
    private float cwJ = 0.25f;
    private float cwK = 0.0f;
    private boolean cwM = false;
    private boolean mBlockLayoutRequests = false;
    private boolean cwO = false;
    private i cwP = new i(3);
    private float cwU = 0.0f;
    private boolean cwX = false;
    private boolean cwY = false;

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
        this.cwV = dVar;
        this.mListView = listView;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            this.cwL = new C0245a(listAdapter);
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
            this.cwL = null;
        }
        this.cwV.setAdapter(this.cwL);
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
            if (i2 > this.cwh) {
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
        int i4 = this.aGV - this.cwo;
        int kl = kl(i2);
        int kj = kj(i2);
        if (this.cwf <= this.cwh) {
            if (i2 == this.cwf && this.cwe != this.cwf) {
                if (i2 == this.cwh) {
                    i3 = (i3 + kj) - this.aGV;
                } else {
                    i3 = ((kj - kl) + i3) - i4;
                }
            } else if (i2 > this.cwf && i2 <= this.cwh) {
                i3 -= i4;
            }
        } else if (i2 > this.cwh && i2 <= this.cwe) {
            i3 += i4;
        } else if (i2 == this.cwf && this.cwe != this.cwf) {
            i3 += kj - kl;
        }
        if (i2 <= this.cwh) {
            return (((this.aGV - dividerHeight) - kl(i2 - 1)) / 2) + i3;
        }
        return (((kl - dividerHeight) - this.aGV) / 2) + i3;
    }

    private boolean ard() {
        int i2;
        int i3;
        int i4;
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int i5 = this.cwe;
        View childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        if (childAt == null) {
            i5 = firstVisiblePosition + (this.mListView.getChildCount() / 2);
            childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        }
        int top = childAt.getTop();
        int height = childAt.getHeight();
        int al = al(i5, top);
        int dividerHeight = this.mListView.getDividerHeight();
        if (this.cvZ >= al) {
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
                    if (this.cvZ < i2) {
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
                if (this.cvZ >= i2) {
                    break;
                }
                i4 = i2;
            }
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int i9 = this.cwe;
        int i10 = this.cwf;
        float f2 = this.cwK;
        if (this.cwg) {
            int abs = Math.abs(i2 - i4);
            if (this.cvZ >= i2) {
                int i11 = i4;
                i4 = i2;
                i2 = i11;
            }
            int i12 = (int) (abs * this.cwJ * 0.5f);
            float f3 = i12;
            int i13 = i4 + i12;
            int i14 = i2 - i12;
            if (this.cvZ < i13) {
                this.cwe = i3 - 1;
                this.cwf = i3;
                this.cwK = ((i13 - this.cvZ) * 0.5f) / f3;
            } else if (this.cvZ < i14) {
                this.cwe = i3;
                this.cwf = i3;
            } else {
                this.cwe = i3;
                this.cwf = i3 + 1;
                this.cwK = (1.0f + ((i2 - this.cvZ) / f3)) * 0.5f;
            }
        } else {
            this.cwe = i3;
            this.cwf = i3;
        }
        if (this.cwe < headerViewsCount) {
            this.cwe = headerViewsCount;
            this.cwf = headerViewsCount;
            i3 = headerViewsCount;
        } else if (this.cwf >= this.mListView.getCount() - footerViewsCount) {
            i3 = (this.mListView.getCount() - footerViewsCount) - 1;
            this.cwe = i3;
            this.cwf = i3;
        }
        boolean z = (this.cwe == i9 && this.cwf == i10 && this.cwK == f2) ? false : true;
        if (i3 != this.cwd) {
            if (this.cwk != null) {
                this.cwk.drag(this.cwd - headerViewsCount, i3 - headerViewsCount);
            }
            this.cwd = i3;
            return true;
        }
        return z;
    }

    public void removeItem(int i2) {
        this.cwT = false;
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
            this.cwo = Math.max(1, obtainStyledAttributes.getDimensionPixelSize(d.l.DragSort_collapsed_height, 1));
            this.cwM = obtainStyledAttributes.getBoolean(d.l.DragSort_track_drag_sort, false);
            if (this.cwM) {
                this.cwN = new e();
            }
            this.cwb = obtainStyledAttributes.getFloat(d.l.DragSort_float_alpha, this.cwb);
            this.cwc = this.cwb;
            this.cwn = obtainStyledAttributes.getBoolean(d.l.DragSort_drag_enabled, this.cwn);
            this.cwJ = Math.max(0.0f, Math.min(1.0f, 1.0f - obtainStyledAttributes.getFloat(d.l.DragSort_slide_shuffle_speed, 0.75f)));
            this.cwg = this.cwJ > 0.0f;
            setDragScrollStart(obtainStyledAttributes.getFloat(d.l.DragSort_drag_scroll_start, this.cws));
            this.cwA = obtainStyledAttributes.getFloat(d.l.DragSort_max_drag_scroll_speed, this.cwA);
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
                this.cwG = bVar;
                a(bVar);
            }
            obtainStyledAttributes.recycle();
            i2 = i5;
            i3 = i4;
        }
        this.cwr = new d();
        if (i3 > 0) {
            this.cwQ = new k(0.5f, i3);
        }
        if (i2 > 0) {
            this.cwS = new f(0.5f, i2);
        }
        this.cwH = MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
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
        this.cwW = bVar;
        this.mListView.setOnTouchListener(bVar);
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void dispatchDraw(Canvas canvas) {
        float f2;
        this.cwV.dispatchDraw(canvas);
        if (this.mDragState != 0) {
            if (this.cwe != this.cwh) {
                b(this.cwe, canvas);
            }
            if (this.cwf != this.cwe && this.cwf != this.cwh) {
                b(this.cwf, canvas);
            }
        }
        if (this.cvW != null) {
            int width = this.cvW.getWidth();
            int height = this.cvW.getHeight();
            int i2 = this.cvX.x;
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
            int i3 = (int) (f2 * 255.0f * this.cwc);
            canvas.save();
            canvas.translate(this.cvX.x, this.cvX.y);
            canvas.clipRect(0, 0, width, height);
            canvas.saveLayerAlpha(0.0f, 0.0f, width, height, i3, 31);
            this.cvW.draw(canvas);
            canvas.restore();
            canvas.restore();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onDraw(Canvas canvas) {
        this.cwV.onDraw(canvas);
        if (this.cwM) {
            this.cwN.arq();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.cwO) {
            this.cwO = false;
            return false;
        } else if (!this.cwn) {
            return this.cwV.onTouchEvent(motionEvent);
        } else {
            boolean z2 = this.cwE;
            this.cwE = false;
            if (!z2) {
                y(motionEvent);
            }
            if (this.mDragState == 4) {
                onDragTouchEvent(motionEvent);
                return true;
            }
            if (this.mDragState == 0 && this.cwV.onTouchEvent(motionEvent)) {
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
                        this.cwI = 1;
                        return z;
                    }
                    return z;
            }
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (!this.cwn) {
            return this.cwV.onInterceptTouchEvent(motionEvent);
        }
        if (this.cwW != null) {
            this.cwW.ars().onTouchEvent(motionEvent);
        }
        y(motionEvent);
        this.cwE = true;
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            if (this.mDragState != 0) {
                this.cwO = true;
                return true;
            }
            this.cwF = true;
        }
        if (this.cvW == null) {
            if (this.cwV.onInterceptTouchEvent(motionEvent)) {
                this.cwX = true;
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
                        this.cwI = 1;
                        break;
                    } else {
                        this.cwI = 2;
                        break;
                    }
            }
        } else {
            z = true;
        }
        if (action == 1 || action == 3) {
            this.cwF = false;
        }
        return z;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        this.cwV.onSizeChanged(i2, i3, i4, i5);
        arj();
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void requestLayout() {
        if (!this.mBlockLayoutRequests) {
            this.cwV.requestLayout();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onMeasure(int i2, int i3) {
        this.cwV.onMeasure(i2, i3);
        if (this.cvW != null) {
            if (this.cvW.isLayoutRequested()) {
                arl();
            }
            this.cwa = true;
        }
        this.mWidthMeasureSpec = i2;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void layoutChildren() {
        this.cwV.layoutChildren();
        if (this.cvW != null) {
            if (this.cvW.isLayoutRequested() && !this.cwa) {
                arl();
            }
            this.cvW.layout(0, 0, this.cvW.getMeasuredWidth(), this.cvW.getMeasuredHeight());
            this.cwa = false;
        }
    }

    public void removeItem(int i2, float f2) {
        if (this.mDragState == 0 || this.mDragState == 4) {
            if (this.mDragState == 0) {
                this.cwh = this.mListView.getHeaderViewsCount() + i2;
                this.cwe = this.cwh;
                this.cwf = this.cwh;
                this.cwd = this.cwh;
                View childAt = this.mListView.getChildAt(this.cwh - this.mListView.getFirstVisiblePosition());
                if (childAt != null) {
                    childAt.setVisibility(4);
                }
            }
            this.mDragState = 1;
            this.cwU = f2;
            if (this.cwF) {
                switch (this.cwI) {
                    case 1:
                        this.cwV.onTouchEvent(this.cwH);
                        break;
                    case 2:
                        this.cwV.onInterceptTouchEvent(this.cwH);
                        break;
                }
            }
            if (this.cwQ != null) {
                this.cwQ.start();
            } else {
                kk(i2);
            }
        }
    }

    public void cancelDrag() {
        if (this.mDragState == 4) {
            this.cwr.fn(true);
            arn();
            are();
            ark();
            if (this.cwF) {
                this.mDragState = 3;
            } else {
                this.mDragState = 0;
            }
        }
    }

    private void are() {
        this.cwh = -1;
        this.cwe = -1;
        this.cwf = -1;
        this.cwd = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void arf() {
        this.mDragState = 2;
        if (this.cwl != null && this.cwd >= 0 && this.cwd < this.mListView.getCount()) {
            int headerViewsCount = this.mListView.getHeaderViewsCount();
            this.cwl.drop(this.cwh - headerViewsCount, this.cwd - headerViewsCount);
        }
        arn();
        arh();
        are();
        ark();
        if (this.cwF) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void arg() {
        kk(this.cwh - this.mListView.getHeaderViewsCount());
    }

    private void kk(int i2) {
        this.mDragState = 1;
        if (this.cwm != null) {
            this.cwm.remove(i2);
        }
        arn();
        arh();
        are();
        if (this.cwF) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    private void arh() {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        if (this.cwh < firstVisiblePosition) {
            View childAt = this.mListView.getChildAt(0);
            this.mListView.setSelectionFromTop(firstVisiblePosition - 1, (childAt != null ? childAt.getTop() : 0) - this.mListView.getPaddingTop());
        }
    }

    public boolean stopDrag(boolean z) {
        this.cwT = false;
        return stopDrag(z, 0.0f);
    }

    public boolean stopDragWithVelocity(boolean z, float f2) {
        this.cwT = true;
        return stopDrag(z, f2);
    }

    public boolean stopDrag(boolean z, float f2) {
        if (this.cvW != null) {
            this.cwr.fn(true);
            if (z) {
                removeItem(this.cwh - this.mListView.getHeaderViewsCount(), f2);
            } else if (this.cwS != null) {
                this.cwS.start();
            } else {
                arf();
            }
            if (this.cwM) {
                this.cwN.ot();
                return true;
            }
            return true;
        }
        return false;
    }

    private void ari() {
        this.cwI = 0;
        this.cwF = false;
        if (this.mDragState == 3) {
            this.mDragState = 0;
        }
        this.cwc = this.cwb;
        this.cwX = false;
        this.cwP.clear();
    }

    private void y(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            this.mLastX = this.alA;
            this.mLastY = this.alB;
        }
        this.alA = (int) motionEvent.getX();
        this.alB = (int) motionEvent.getY();
        if (action == 0) {
            this.mLastX = this.alA;
            this.mLastY = this.alB;
        }
        this.amh = ((int) motionEvent.getRawX()) - this.alA;
        this.ami = ((int) motionEvent.getRawY()) - this.alB;
    }

    public boolean listViewIntercepted() {
        return this.cwX;
    }

    public void setDragScrollStart(float f2) {
        setDragScrollStarts(f2, f2);
    }

    public void setDragScrollStarts(float f2, float f3) {
        if (f3 > 0.5f) {
            this.cwt = 0.5f;
        } else {
            this.cwt = f3;
        }
        if (f2 > 0.5f) {
            this.cws = 0.5f;
        } else {
            this.cws = f2;
        }
        if (this.mListView.getHeight() != 0) {
            arj();
        }
    }

    private void am(int i2, int i3) {
        this.cvX.x = i2 - this.cwi;
        this.cvX.y = i3 - this.cwj;
        fm(true);
        int min = Math.min(i3, this.cvZ + this.cwp);
        int max = Math.max(i3, this.cvZ - this.cwp);
        int arp = this.cwr.arp();
        if (min > this.mLastY && min > this.cwv && arp != 1) {
            if (arp != -1) {
                this.cwr.fn(true);
            }
            this.cwr.km(1);
        } else if (max < this.mLastY && max < this.cwu && arp != 0) {
            if (arp != -1) {
                this.cwr.fn(true);
            }
            this.cwr.km(0);
        } else if (max >= this.cwu && min <= this.cwv && this.cwr.aro()) {
            this.cwr.fn(true);
        }
    }

    private void arj() {
        int height;
        int paddingTop = this.mListView.getPaddingTop();
        float height2 = (this.mListView.getHeight() - paddingTop) - this.mListView.getPaddingBottom();
        this.cwx = paddingTop + (this.cws * height2);
        this.cww = (height2 * (1.0f - this.cwt)) + paddingTop;
        this.cwu = (int) this.cwx;
        this.cwv = (int) this.cww;
        this.cwy = this.cwx - paddingTop;
        this.cwz = (paddingTop + height) - this.cww;
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
        if (i2 != this.cwh && i2 != this.cwe && i2 != this.cwf) {
            g2 = -2;
        } else {
            g2 = g(i2, view, z);
        }
        if (g2 != layoutParams.height) {
            layoutParams.height = g2;
            view.setLayoutParams(layoutParams);
        }
        if (i2 == this.cwe || i2 == this.cwf) {
            if (i2 < this.cwh) {
                ((DragSortItemView) view).setGravity(80);
            } else if (i2 > this.cwh) {
                ((DragSortItemView) view).setGravity(48);
            }
        }
        int visibility = view.getVisibility();
        int i3 = 0;
        if (i2 == this.cwh && this.cvW != null) {
            i3 = 4;
        }
        if (i3 != visibility) {
            view.setVisibility(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int kl(int i2) {
        View view;
        if (i2 == this.cwh) {
            return 0;
        }
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        if (childAt != null) {
            return f(i2, childAt, false);
        }
        int i3 = this.cwP.get(i2);
        if (i3 == -1) {
            ListAdapter adapter = this.mListView.getAdapter();
            int itemViewType = adapter.getItemViewType(i2);
            int viewTypeCount = adapter.getViewTypeCount();
            if (viewTypeCount != this.cwq.length) {
                this.cwq = new View[viewTypeCount];
            }
            if (itemViewType >= 0) {
                if (this.cwq[itemViewType] == null) {
                    view = adapter.getView(i2, null, this.mListView);
                    this.cwq[itemViewType] = view;
                } else {
                    view = adapter.getView(i2, this.cwq[itemViewType], this.mListView);
                }
            } else {
                view = adapter.getView(i2, null, this.mListView);
            }
            int f2 = f(i2, view, true);
            this.cwP.add(i2, f2);
            return f2;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(int i2, View view, boolean z) {
        if (i2 == this.cwh) {
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
        boolean z = this.cwg && this.cwe != this.cwf;
        int i4 = this.aGV - this.cwo;
        int i5 = (int) (this.cwK * i4);
        if (i2 == this.cwh) {
            if (this.cwh == this.cwe) {
                if (z) {
                    return i5 + this.cwo;
                }
                return this.aGV;
            } else if (this.cwh == this.cwf) {
                return this.aGV - i5;
            } else {
                return this.cwo;
            }
        } else if (i2 == this.cwe) {
            if (z) {
                return i3 + i5;
            }
            return i3 + i4;
        } else if (i2 == this.cwf) {
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
        if (i2 != this.cwh) {
            i6 = height - kl;
            i5 = an - kl;
        } else {
            i5 = an;
            i6 = height;
        }
        int i7 = this.aGV;
        if (this.cwh != this.cwe && this.cwh != this.cwf) {
            i7 -= this.cwo;
        }
        if (i2 <= i3) {
            if (i2 > this.cwe) {
                return (i7 - i5) + 0;
            }
        } else if (i2 == i4) {
            if (i2 <= this.cwe) {
                return (i6 - i7) + 0;
            }
            if (i2 == this.cwf) {
                return (height - an) + 0;
            }
            return 0 + i6;
        } else if (i2 <= this.cwe) {
            return 0 - i7;
        } else {
            if (i2 == this.cwf) {
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
        if (this.cvW != null) {
            measureItem(this.cvW);
            this.aGV = this.cvW.getMeasuredHeight();
            this.cwp = this.aGV / 2;
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
        if (!this.cwF || this.cwG == null || (kn = this.cwG.kn(i2)) == null) {
            return false;
        }
        return startDrag(i2, kn, i3, i4, i5);
    }

    public boolean startDrag(int i2, View view, int i3, int i4, int i5) {
        if (this.mDragState == 0 && this.cwF && this.cvW == null && view != null && this.cwn) {
            if (this.mListView.getParent() != null) {
                this.mListView.getParent().requestDisallowInterceptTouchEvent(true);
            }
            int headerViewsCount = this.mListView.getHeaderViewsCount() + i2;
            this.cwe = headerViewsCount;
            this.cwf = headerViewsCount;
            this.cwh = headerViewsCount;
            this.cwd = headerViewsCount;
            this.mDragState = 4;
            this.cwD = 0;
            this.cwD |= i3;
            this.cvW = view;
            arl();
            this.cwi = i4;
            this.cwj = i5;
            this.cwC = this.alB;
            this.cvX.x = this.alA - this.cwi;
            this.cvX.y = this.alB - this.cwj;
            View childAt = this.mListView.getChildAt(this.cwh - this.mListView.getFirstVisiblePosition());
            if (childAt != null) {
                childAt.setVisibility(4);
            }
            if (this.cwM) {
                this.cwN.startTracking();
            }
            switch (this.cwI) {
                case 1:
                    this.cwV.onTouchEvent(this.cwH);
                    break;
                case 2:
                    this.cwV.onInterceptTouchEvent(this.cwH);
                    break;
            }
            this.mListView.requestLayout();
            if (this.cwR != null) {
                this.cwR.start();
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
        int i3 = this.cwe;
        int i4 = this.cwf;
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
        if (this.cwG != null) {
            this.cvY.set(this.alA, this.alB);
            this.cwG.b(this.cvW, this.cvX, this.cvY);
        }
        int i2 = this.cvX.x;
        int i3 = this.cvX.y;
        int paddingLeft = this.mListView.getPaddingLeft();
        if ((this.cwD & 1) == 0 && i2 > paddingLeft) {
            this.cvX.x = paddingLeft;
        } else if ((this.cwD & 2) == 0 && i2 < paddingLeft) {
            this.cvX.x = paddingLeft;
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int lastVisiblePosition = this.mListView.getLastVisiblePosition();
        int paddingTop = this.mListView.getPaddingTop();
        if (firstVisiblePosition < headerViewsCount) {
            paddingTop = this.mListView.getChildAt((headerViewsCount - firstVisiblePosition) - 1).getBottom();
        }
        if ((this.cwD & 8) == 0 && firstVisiblePosition <= this.cwh) {
            paddingTop = Math.max(this.mListView.getChildAt(this.cwh - firstVisiblePosition).getTop(), paddingTop);
        }
        int height = this.mListView.getHeight() - this.mListView.getPaddingBottom();
        if (lastVisiblePosition >= (this.mListView.getCount() - footerViewsCount) - 1) {
            height = this.mListView.getChildAt(((this.mListView.getCount() - footerViewsCount) - 1) - firstVisiblePosition).getBottom();
        }
        if ((this.cwD & 4) == 0 && lastVisiblePosition >= this.cwh) {
            height = Math.min(this.mListView.getChildAt(this.cwh - firstVisiblePosition).getBottom(), height);
        }
        if (i3 < paddingTop) {
            this.cvX.y = paddingTop;
        } else if (this.aGV + i3 > height) {
            this.cvX.y = height - this.aGV;
        }
        this.cvZ = this.cvX.y + this.cwp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void arn() {
        if (this.cvW != null) {
            this.cvW.setVisibility(8);
            if (this.cwG != null) {
                this.cwG.ba(this.cvW);
            }
            this.cvW = null;
            this.mListView.invalidate();
        }
    }

    public void a(h hVar) {
        this.cwG = hVar;
    }

    public void a(b bVar) {
        this.cwk = bVar;
    }

    public void setDragEnabled(boolean z) {
        this.cwn = z;
    }

    public boolean isDragEnabled() {
        return this.cwn;
    }

    public void a(g gVar) {
        this.cwl = gVar;
    }

    public void a(l lVar) {
        this.cwm = lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class i {
        private SparseIntArray cxq;
        private ArrayList<Integer> cxr;
        private int mMaxSize;

        public i(int i) {
            this.cxq = new SparseIntArray(i);
            this.cxr = new ArrayList<>(i);
            this.mMaxSize = i;
        }

        public void add(int i, int i2) {
            int i3 = this.cxq.get(i, -1);
            if (i3 != i2) {
                if (i3 == -1) {
                    if (this.cxq.size() == this.mMaxSize) {
                        this.cxq.delete(this.cxr.remove(0).intValue());
                    }
                } else {
                    this.cxr.remove(Integer.valueOf(i));
                }
                this.cxq.put(i, i2);
                this.cxr.add(Integer.valueOf(i));
            }
        }

        public int get(int i) {
            return this.cxq.get(i, -1);
        }

        public void clear() {
            this.cxq.clear();
            this.cxr.clear();
        }
    }

    /* renamed from: com.baidu.tbadk.widget.dragsort.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0245a extends BaseAdapter {
        private ListAdapter mAdapter;

        public C0245a(ListAdapter listAdapter) {
            this.mAdapter = listAdapter;
            this.mAdapter.registerDataSetObserver(new DataSetObserver() { // from class: com.baidu.tbadk.widget.dragsort.a.a.1
                @Override // android.database.DataSetObserver
                public void onChanged() {
                    C0245a.this.notifyDataSetChanged();
                }

                @Override // android.database.DataSetObserver
                public void onInvalidated() {
                    C0245a.this.notifyDataSetInvalidated();
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
        private float amb;
        private float amc;
        private float amd;
        private float ame;
        private float cxB;
        private float mAlpha;
        private boolean mCanceled;
        protected long mStartTime;

        public m(float f, int i) {
            this.mAlpha = f;
            this.cxB = i;
            float f2 = 1.0f / ((this.mAlpha * 2.0f) * (1.0f - this.mAlpha));
            this.ame = f2;
            this.amb = f2;
            this.amc = this.mAlpha / ((this.mAlpha - 1.0f) * 2.0f);
            this.amd = 1.0f / (1.0f - this.mAlpha);
        }

        public float ao(float f) {
            if (f < this.mAlpha) {
                return this.amb * f * f;
            }
            if (f < 1.0f - this.mAlpha) {
                return this.amc + (this.amd * f);
            }
            return 1.0f - ((this.ame * (f - 1.0f)) * (f - 1.0f));
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
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / this.cxB;
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
        private int cxm;
        private int cxn;
        private float cxo;
        private float cxp;

        public f(float f, int i) {
            super(f, i);
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.cxm = a.this.cwd;
            this.cxn = a.this.cwh;
            a.this.mDragState = 2;
            this.cxo = a.this.cvX.y - arr();
            this.cxp = a.this.cvX.x - a.this.mListView.getPaddingLeft();
        }

        private int arr() {
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            int dividerHeight = (a.this.cwo + a.this.mListView.getDividerHeight()) / 2;
            View childAt = a.this.mListView.getChildAt(this.cxm - firstVisiblePosition);
            if (childAt != null) {
                if (this.cxm == this.cxn) {
                    return childAt.getTop();
                }
                if (this.cxm >= this.cxn) {
                    return (childAt.getBottom() + dividerHeight) - a.this.aGV;
                }
                return childAt.getTop() - dividerHeight;
            }
            cancel();
            return -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void t(float f, float f2) {
            int arr = arr();
            float paddingLeft = a.this.cvX.x - a.this.mListView.getPaddingLeft();
            float f3 = 1.0f - f2;
            if (f3 < Math.abs((a.this.cvX.y - arr) / this.cxo) || f3 < Math.abs(paddingLeft / this.cxp)) {
                a.this.cvX.y = arr + ((int) (this.cxo * f3));
                a.this.cvX.x = a.this.mListView.getPaddingLeft() + ((int) (this.cxp * f3));
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
        private int cxn;
        private float cxu;
        private float cxv;
        private float cxw;
        private int cxx;
        private int cxy;
        private int cxz;

        public k(float f, int i) {
            super(f, i);
            this.cxx = -1;
            this.cxy = -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.cxx = -1;
            this.cxy = -1;
            this.cxz = a.this.cwe;
            this.cxA = a.this.cwf;
            this.cxn = a.this.cwh;
            a.this.mDragState = 1;
            this.cxu = a.this.cvX.x;
            if (a.this.cwT) {
                float width = a.this.mListView.getWidth() * 2.0f;
                if (a.this.cwU == 0.0f) {
                    a.this.cwU = (this.cxu >= 0.0f ? 1 : -1) * width;
                    return;
                }
                float f = width * 2.0f;
                if (a.this.cwU >= 0.0f || a.this.cwU <= (-f)) {
                    if (a.this.cwU > 0.0f && a.this.cwU < f) {
                        a.this.cwU = f;
                        return;
                    }
                    return;
                }
                a.this.cwU = -f;
                return;
            }
            a.this.arn();
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void t(float f, float f2) {
            View childAt;
            float f3 = 1.0f - f2;
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            View childAt2 = a.this.mListView.getChildAt(this.cxz - firstVisiblePosition);
            if (a.this.cwT) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / 1000.0f;
                if (uptimeMillis != 0.0f) {
                    float f4 = a.this.cwU * uptimeMillis;
                    int width = a.this.mListView.getWidth();
                    a.this.cwU = ((a.this.cwU > 0.0f ? 1 : -1) * uptimeMillis * width) + a.this.cwU;
                    this.cxu += f4;
                    a.this.cvX.x = (int) this.cxu;
                    if (this.cxu < width && this.cxu > (-width)) {
                        this.mStartTime = SystemClock.uptimeMillis();
                        a.this.fm(true);
                        return;
                    }
                } else {
                    return;
                }
            }
            if (childAt2 != null) {
                if (this.cxx == -1) {
                    this.cxx = a.this.f(this.cxz, childAt2, false);
                    this.cxv = childAt2.getHeight() - this.cxx;
                }
                int max = Math.max((int) (this.cxv * f3), 1);
                ViewGroup.LayoutParams layoutParams = childAt2.getLayoutParams();
                layoutParams.height = max + this.cxx;
                childAt2.setLayoutParams(layoutParams);
            }
            if (this.cxA != this.cxz && (childAt = a.this.mListView.getChildAt(this.cxA - firstVisiblePosition)) != null) {
                if (this.cxy == -1) {
                    this.cxy = a.this.f(this.cxA, childAt, false);
                    this.cxw = childAt.getHeight() - this.cxy;
                }
                int max2 = Math.max((int) (this.cxw * f3), 1);
                ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
                layoutParams2.height = max2 + this.cxy;
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
        final /* synthetic */ a cwZ;
        private float cxs;
        private float cxt;

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.cxs = this.cwZ.cwj;
            this.cxt = this.cwZ.cwp;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void t(float f, float f2) {
            if (this.cwZ.mDragState != 4) {
                cancel();
                return;
            }
            this.cwZ.cwj = (int) ((this.cxt * f2) + ((1.0f - f2) * this.cxs));
            this.cwZ.cvX.y = this.cwZ.alB - this.cwZ.cwj;
            this.cwZ.fm(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e {
        StringBuilder mBuilder = new StringBuilder();
        private int cxj = 0;
        private int cxk = 0;
        private boolean cxl = false;
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
            this.cxk = 0;
            this.cxl = true;
        }

        public void arq() {
            if (this.cxl) {
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
                this.mBuilder.append("    <FirstExpPos>").append(a.this.cwe).append("</FirstExpPos>\n");
                this.mBuilder.append("    <FirstExpBlankHeight>").append(a.this.kj(a.this.cwe) - a.this.kl(a.this.cwe)).append("</FirstExpBlankHeight>\n");
                this.mBuilder.append("    <SecondExpPos>").append(a.this.cwf).append("</SecondExpPos>\n");
                this.mBuilder.append("    <SecondExpBlankHeight>").append(a.this.kj(a.this.cwf) - a.this.kl(a.this.cwf)).append("</SecondExpBlankHeight>\n");
                this.mBuilder.append("    <SrcPos>").append(a.this.cwh).append("</SrcPos>\n");
                this.mBuilder.append("    <SrcHeight>").append(a.this.aGV + a.this.mListView.getDividerHeight()).append("</SrcHeight>\n");
                this.mBuilder.append("    <ViewHeight>").append(a.this.mListView.getHeight()).append("</ViewHeight>\n");
                this.mBuilder.append("    <LastY>").append(a.this.mLastY).append("</LastY>\n");
                this.mBuilder.append("    <FloatY>").append(a.this.cvZ).append("</FloatY>\n");
                this.mBuilder.append("    <ShuffleEdges>");
                for (int i4 = 0; i4 < childCount; i4++) {
                    this.mBuilder.append(a.this.al(firstVisiblePosition + i4, a.this.mListView.getChildAt(i4).getTop())).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                this.mBuilder.append("</ShuffleEdges>\n");
                this.mBuilder.append("</DSLVState>\n");
                this.cxj++;
                if (this.cxj > 1000) {
                    flush();
                    this.cxj = 0;
                }
            }
        }

        public void flush() {
            if (this.cxl) {
                try {
                    FileWriter fileWriter = new FileWriter(this.mFile, this.cxk != 0);
                    fileWriter.write(this.mBuilder.toString());
                    this.mBuilder.delete(0, this.mBuilder.length());
                    fileWriter.flush();
                    fileWriter.close();
                    this.cxk++;
                } catch (IOException e) {
                }
            }
        }

        public void ot() {
            if (this.cxl) {
                this.mBuilder.append("</DSLVStates>\n");
                flush();
                this.cxl = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements Runnable {
        private boolean aKE = false;
        private boolean cxc;
        private long cxd;
        private long cxe;
        private float cxf;
        private long cxg;
        private int cxh;
        private float cxi;
        private int dy;

        public boolean aro() {
            return this.aKE;
        }

        public int arp() {
            if (this.aKE) {
                return this.cxh;
            }
            return -1;
        }

        public d() {
        }

        public void km(int i) {
            if (!this.aKE) {
                this.cxc = false;
                this.aKE = true;
                this.cxg = SystemClock.uptimeMillis();
                this.cxd = this.cxg;
                this.cxh = i;
                a.this.mListView.post(this);
            }
        }

        public void fn(boolean z) {
            if (z) {
                a.this.mListView.removeCallbacks(this);
                this.aKE = false;
                return;
            }
            this.cxc = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.cxc) {
                int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
                int lastVisiblePosition = a.this.mListView.getLastVisiblePosition();
                int count = a.this.mListView.getCount();
                int paddingTop = a.this.mListView.getPaddingTop();
                int height = (a.this.mListView.getHeight() - paddingTop) - a.this.mListView.getPaddingBottom();
                int min = Math.min(a.this.alB, a.this.cvZ + a.this.cwp);
                int max = Math.max(a.this.alB, a.this.cvZ - a.this.cwp);
                if (this.cxh == 0) {
                    View childAt = a.this.mListView.getChildAt(0);
                    if (childAt == null) {
                        this.aKE = false;
                        return;
                    } else if (firstVisiblePosition == 0 && childAt.getTop() == paddingTop) {
                        this.aKE = false;
                        return;
                    } else {
                        this.cxi = a.this.cwB.b((a.this.cwx - max) / a.this.cwy, this.cxd);
                    }
                } else {
                    View childAt2 = a.this.mListView.getChildAt(lastVisiblePosition - firstVisiblePosition);
                    if (childAt2 == null) {
                        this.aKE = false;
                        return;
                    } else if (lastVisiblePosition == count - 1 && childAt2.getBottom() <= height + paddingTop) {
                        this.aKE = false;
                        return;
                    } else {
                        this.cxi = -a.this.cwB.b((min - a.this.cww) / a.this.cwz, this.cxd);
                    }
                }
                this.cxe = SystemClock.uptimeMillis();
                this.cxf = (float) (this.cxe - this.cxd);
                this.dy = Math.round(this.cxi * this.cxf);
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
                this.cxd = this.cxe;
                a.this.mListView.post(this);
                return;
            }
            this.aKE = false;
        }
    }
}
