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
    private int aGY;
    private int alE;
    private int alF;
    private int aml;
    private int amm;
    private View cvY;
    private float cwA;
    private float cwB;
    private int cwE;
    private MotionEvent cwJ;
    private C0245a cwN;
    private e cwP;
    private k cwS;
    private j cwT;
    private f cwU;
    private boolean cwV;
    private com.baidu.tbadk.widget.dragsort.d cwX;
    private com.baidu.tbadk.widget.dragsort.b cwY;
    private int cwb;
    private int cwf;
    private int cwg;
    private int cwh;
    private int cwj;
    private int cwk;
    private int cwl;
    private b cwm;
    private g cwn;
    private l cwo;
    private int cwr;
    private d cwt;
    private int cww;
    private int cwx;
    private float cwy;
    private float cwz;
    private int mLastX;
    private int mLastY;
    private ListView mListView;
    private DataSetObserver mObserver;
    private Point cvZ = new Point();
    private Point cwa = new Point();
    private boolean cwc = false;
    private float cwd = 1.0f;
    private float cwe = 1.0f;
    private boolean cwi = false;
    private boolean cwp = true;
    private int mDragState = 0;
    private int cwq = 1;
    private int mWidthMeasureSpec = 0;
    private View[] cws = new View[1];
    private float cwu = 0.33333334f;
    private float cwv = 0.33333334f;
    private float cwC = 0.5f;
    private c cwD = new c() { // from class: com.baidu.tbadk.widget.dragsort.a.1
        @Override // com.baidu.tbadk.widget.dragsort.a.c
        public float b(float f2, long j2) {
            return a.this.cwC * f2;
        }
    };
    private int cwF = 0;
    private boolean cwG = false;
    private boolean cwH = false;
    private h cwI = null;
    private int cwK = 0;
    private float cwL = 0.25f;
    private float cwM = 0.0f;
    private boolean cwO = false;
    private boolean mBlockLayoutRequests = false;
    private boolean cwQ = false;
    private i cwR = new i(3);
    private float cwW = 0.0f;
    private boolean cwZ = false;
    private boolean cxa = false;

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

        View km(int i);
    }

    /* loaded from: classes.dex */
    public interface l {
        void remove(int i);
    }

    public a(ListView listView, com.baidu.tbadk.widget.dragsort.d dVar) {
        this.cwX = dVar;
        this.mListView = listView;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            this.cwN = new C0245a(listAdapter);
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
            this.cwN = null;
        }
        this.cwX.setAdapter(this.cwN);
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
            if (i2 > this.cwj) {
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
    public int ki(int i2) {
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        return childAt != null ? childAt.getHeight() : an(i2, kk(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int al(int i2, int i3) {
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        if (i2 <= headerViewsCount || i2 >= this.mListView.getCount() - footerViewsCount) {
            return i3;
        }
        int dividerHeight = this.mListView.getDividerHeight();
        int i4 = this.aGY - this.cwq;
        int kk = kk(i2);
        int ki = ki(i2);
        if (this.cwh <= this.cwj) {
            if (i2 == this.cwh && this.cwg != this.cwh) {
                if (i2 == this.cwj) {
                    i3 = (i3 + ki) - this.aGY;
                } else {
                    i3 = ((ki - kk) + i3) - i4;
                }
            } else if (i2 > this.cwh && i2 <= this.cwj) {
                i3 -= i4;
            }
        } else if (i2 > this.cwj && i2 <= this.cwg) {
            i3 += i4;
        } else if (i2 == this.cwh && this.cwg != this.cwh) {
            i3 += ki - kk;
        }
        if (i2 <= this.cwj) {
            return (((this.aGY - dividerHeight) - kk(i2 - 1)) / 2) + i3;
        }
        return (((kk - dividerHeight) - this.aGY) / 2) + i3;
    }

    private boolean ara() {
        int i2;
        int i3;
        int i4;
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int i5 = this.cwg;
        View childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        if (childAt == null) {
            i5 = firstVisiblePosition + (this.mListView.getChildCount() / 2);
            childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        }
        int top = childAt.getTop();
        int height = childAt.getHeight();
        int al = al(i5, top);
        int dividerHeight = this.mListView.getDividerHeight();
        if (this.cwb >= al) {
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
                    i6 = ki(i3 + 1);
                    i2 = al(i3 + 1, i7);
                    if (this.cwb < i2) {
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
                int ki = ki(i3);
                if (i3 == 0) {
                    i2 = (i8 - dividerHeight) - ki;
                    break;
                }
                i8 -= ki + dividerHeight;
                i2 = al(i3, i8);
                if (this.cwb >= i2) {
                    break;
                }
                i4 = i2;
            }
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int i9 = this.cwg;
        int i10 = this.cwh;
        float f2 = this.cwM;
        if (this.cwi) {
            int abs = Math.abs(i2 - i4);
            if (this.cwb >= i2) {
                int i11 = i4;
                i4 = i2;
                i2 = i11;
            }
            int i12 = (int) (abs * this.cwL * 0.5f);
            float f3 = i12;
            int i13 = i4 + i12;
            int i14 = i2 - i12;
            if (this.cwb < i13) {
                this.cwg = i3 - 1;
                this.cwh = i3;
                this.cwM = ((i13 - this.cwb) * 0.5f) / f3;
            } else if (this.cwb < i14) {
                this.cwg = i3;
                this.cwh = i3;
            } else {
                this.cwg = i3;
                this.cwh = i3 + 1;
                this.cwM = (1.0f + ((i2 - this.cwb) / f3)) * 0.5f;
            }
        } else {
            this.cwg = i3;
            this.cwh = i3;
        }
        if (this.cwg < headerViewsCount) {
            this.cwg = headerViewsCount;
            this.cwh = headerViewsCount;
            i3 = headerViewsCount;
        } else if (this.cwh >= this.mListView.getCount() - footerViewsCount) {
            i3 = (this.mListView.getCount() - footerViewsCount) - 1;
            this.cwg = i3;
            this.cwh = i3;
        }
        boolean z = (this.cwg == i9 && this.cwh == i10 && this.cwM == f2) ? false : true;
        if (i3 != this.cwf) {
            if (this.cwm != null) {
                this.cwm.drag(this.cwf - headerViewsCount, i3 - headerViewsCount);
            }
            this.cwf = i3;
            return true;
        }
        return z;
    }

    public void removeItem(int i2) {
        this.cwV = false;
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
            this.cwq = Math.max(1, obtainStyledAttributes.getDimensionPixelSize(d.l.DragSort_collapsed_height, 1));
            this.cwO = obtainStyledAttributes.getBoolean(d.l.DragSort_track_drag_sort, false);
            if (this.cwO) {
                this.cwP = new e();
            }
            this.cwd = obtainStyledAttributes.getFloat(d.l.DragSort_float_alpha, this.cwd);
            this.cwe = this.cwd;
            this.cwp = obtainStyledAttributes.getBoolean(d.l.DragSort_drag_enabled, this.cwp);
            this.cwL = Math.max(0.0f, Math.min(1.0f, 1.0f - obtainStyledAttributes.getFloat(d.l.DragSort_slide_shuffle_speed, 0.75f)));
            this.cwi = this.cwL > 0.0f;
            setDragScrollStart(obtainStyledAttributes.getFloat(d.l.DragSort_drag_scroll_start, this.cwu));
            this.cwC = obtainStyledAttributes.getFloat(d.l.DragSort_max_drag_scroll_speed, this.cwC);
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
                this.cwI = bVar;
                a(bVar);
            }
            obtainStyledAttributes.recycle();
            i2 = i5;
            i3 = i4;
        }
        this.cwt = new d();
        if (i3 > 0) {
            this.cwS = new k(0.5f, i3);
        }
        if (i2 > 0) {
            this.cwU = new f(0.5f, i2);
        }
        this.cwJ = MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
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
        this.cwY = bVar;
        this.mListView.setOnTouchListener(bVar);
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void dispatchDraw(Canvas canvas) {
        float f2;
        this.cwX.dispatchDraw(canvas);
        if (this.mDragState != 0) {
            if (this.cwg != this.cwj) {
                b(this.cwg, canvas);
            }
            if (this.cwh != this.cwg && this.cwh != this.cwj) {
                b(this.cwh, canvas);
            }
        }
        if (this.cvY != null) {
            int width = this.cvY.getWidth();
            int height = this.cvY.getHeight();
            int i2 = this.cvZ.x;
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
            int i3 = (int) (f2 * 255.0f * this.cwe);
            canvas.save();
            canvas.translate(this.cvZ.x, this.cvZ.y);
            canvas.clipRect(0, 0, width, height);
            canvas.saveLayerAlpha(0.0f, 0.0f, width, height, i3, 31);
            this.cvY.draw(canvas);
            canvas.restore();
            canvas.restore();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onDraw(Canvas canvas) {
        this.cwX.onDraw(canvas);
        if (this.cwO) {
            this.cwP.arn();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.cwQ) {
            this.cwQ = false;
            return false;
        } else if (!this.cwp) {
            return this.cwX.onTouchEvent(motionEvent);
        } else {
            boolean z2 = this.cwG;
            this.cwG = false;
            if (!z2) {
                y(motionEvent);
            }
            if (this.mDragState == 4) {
                onDragTouchEvent(motionEvent);
                return true;
            }
            if (this.mDragState == 0 && this.cwX.onTouchEvent(motionEvent)) {
                z = true;
            }
            switch (motionEvent.getAction() & 255) {
                case 1:
                case 3:
                    arf();
                    return z;
                case 2:
                default:
                    if (z) {
                        this.cwK = 1;
                        return z;
                    }
                    return z;
            }
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (!this.cwp) {
            return this.cwX.onInterceptTouchEvent(motionEvent);
        }
        if (this.cwY != null) {
            this.cwY.arp().onTouchEvent(motionEvent);
        }
        y(motionEvent);
        this.cwG = true;
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            if (this.mDragState != 0) {
                this.cwQ = true;
                return true;
            }
            this.cwH = true;
        }
        if (this.cvY == null) {
            if (this.cwX.onInterceptTouchEvent(motionEvent)) {
                this.cwZ = true;
                z = true;
            } else {
                z = false;
            }
            switch (action) {
                case 1:
                case 3:
                    arf();
                    break;
                case 2:
                default:
                    if (z) {
                        this.cwK = 1;
                        break;
                    } else {
                        this.cwK = 2;
                        break;
                    }
            }
        } else {
            z = true;
        }
        if (action == 1 || action == 3) {
            this.cwH = false;
        }
        return z;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        this.cwX.onSizeChanged(i2, i3, i4, i5);
        arg();
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void requestLayout() {
        if (!this.mBlockLayoutRequests) {
            this.cwX.requestLayout();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onMeasure(int i2, int i3) {
        this.cwX.onMeasure(i2, i3);
        if (this.cvY != null) {
            if (this.cvY.isLayoutRequested()) {
                ari();
            }
            this.cwc = true;
        }
        this.mWidthMeasureSpec = i2;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void layoutChildren() {
        this.cwX.layoutChildren();
        if (this.cvY != null) {
            if (this.cvY.isLayoutRequested() && !this.cwc) {
                ari();
            }
            this.cvY.layout(0, 0, this.cvY.getMeasuredWidth(), this.cvY.getMeasuredHeight());
            this.cwc = false;
        }
    }

    public void removeItem(int i2, float f2) {
        if (this.mDragState == 0 || this.mDragState == 4) {
            if (this.mDragState == 0) {
                this.cwj = this.mListView.getHeaderViewsCount() + i2;
                this.cwg = this.cwj;
                this.cwh = this.cwj;
                this.cwf = this.cwj;
                View childAt = this.mListView.getChildAt(this.cwj - this.mListView.getFirstVisiblePosition());
                if (childAt != null) {
                    childAt.setVisibility(4);
                }
            }
            this.mDragState = 1;
            this.cwW = f2;
            if (this.cwH) {
                switch (this.cwK) {
                    case 1:
                        this.cwX.onTouchEvent(this.cwJ);
                        break;
                    case 2:
                        this.cwX.onInterceptTouchEvent(this.cwJ);
                        break;
                }
            }
            if (this.cwS != null) {
                this.cwS.start();
            } else {
                kj(i2);
            }
        }
    }

    public void cancelDrag() {
        if (this.mDragState == 4) {
            this.cwt.fn(true);
            ark();
            arb();
            arh();
            if (this.cwH) {
                this.mDragState = 3;
            } else {
                this.mDragState = 0;
            }
        }
    }

    private void arb() {
        this.cwj = -1;
        this.cwg = -1;
        this.cwh = -1;
        this.cwf = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void arc() {
        this.mDragState = 2;
        if (this.cwn != null && this.cwf >= 0 && this.cwf < this.mListView.getCount()) {
            int headerViewsCount = this.mListView.getHeaderViewsCount();
            this.cwn.drop(this.cwj - headerViewsCount, this.cwf - headerViewsCount);
        }
        ark();
        are();
        arb();
        arh();
        if (this.cwH) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ard() {
        kj(this.cwj - this.mListView.getHeaderViewsCount());
    }

    private void kj(int i2) {
        this.mDragState = 1;
        if (this.cwo != null) {
            this.cwo.remove(i2);
        }
        ark();
        are();
        arb();
        if (this.cwH) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    private void are() {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        if (this.cwj < firstVisiblePosition) {
            View childAt = this.mListView.getChildAt(0);
            this.mListView.setSelectionFromTop(firstVisiblePosition - 1, (childAt != null ? childAt.getTop() : 0) - this.mListView.getPaddingTop());
        }
    }

    public boolean stopDrag(boolean z) {
        this.cwV = false;
        return stopDrag(z, 0.0f);
    }

    public boolean stopDragWithVelocity(boolean z, float f2) {
        this.cwV = true;
        return stopDrag(z, f2);
    }

    public boolean stopDrag(boolean z, float f2) {
        if (this.cvY != null) {
            this.cwt.fn(true);
            if (z) {
                removeItem(this.cwj - this.mListView.getHeaderViewsCount(), f2);
            } else if (this.cwU != null) {
                this.cwU.start();
            } else {
                arc();
            }
            if (this.cwO) {
                this.cwP.ot();
                return true;
            }
            return true;
        }
        return false;
    }

    private void arf() {
        this.cwK = 0;
        this.cwH = false;
        if (this.mDragState == 3) {
            this.mDragState = 0;
        }
        this.cwe = this.cwd;
        this.cwZ = false;
        this.cwR.clear();
    }

    private void y(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            this.mLastX = this.alE;
            this.mLastY = this.alF;
        }
        this.alE = (int) motionEvent.getX();
        this.alF = (int) motionEvent.getY();
        if (action == 0) {
            this.mLastX = this.alE;
            this.mLastY = this.alF;
        }
        this.aml = ((int) motionEvent.getRawX()) - this.alE;
        this.amm = ((int) motionEvent.getRawY()) - this.alF;
    }

    public boolean listViewIntercepted() {
        return this.cwZ;
    }

    public void setDragScrollStart(float f2) {
        setDragScrollStarts(f2, f2);
    }

    public void setDragScrollStarts(float f2, float f3) {
        if (f3 > 0.5f) {
            this.cwv = 0.5f;
        } else {
            this.cwv = f3;
        }
        if (f2 > 0.5f) {
            this.cwu = 0.5f;
        } else {
            this.cwu = f2;
        }
        if (this.mListView.getHeight() != 0) {
            arg();
        }
    }

    private void am(int i2, int i3) {
        this.cvZ.x = i2 - this.cwk;
        this.cvZ.y = i3 - this.cwl;
        fm(true);
        int min = Math.min(i3, this.cwb + this.cwr);
        int max = Math.max(i3, this.cwb - this.cwr);
        int arm = this.cwt.arm();
        if (min > this.mLastY && min > this.cwx && arm != 1) {
            if (arm != -1) {
                this.cwt.fn(true);
            }
            this.cwt.kl(1);
        } else if (max < this.mLastY && max < this.cww && arm != 0) {
            if (arm != -1) {
                this.cwt.fn(true);
            }
            this.cwt.kl(0);
        } else if (max >= this.cww && min <= this.cwx && this.cwt.arl()) {
            this.cwt.fn(true);
        }
    }

    private void arg() {
        int height;
        int paddingTop = this.mListView.getPaddingTop();
        float height2 = (this.mListView.getHeight() - paddingTop) - this.mListView.getPaddingBottom();
        this.cwz = paddingTop + (this.cwu * height2);
        this.cwy = (height2 * (1.0f - this.cwv)) + paddingTop;
        this.cww = (int) this.cwz;
        this.cwx = (int) this.cwy;
        this.cwA = this.cwz - paddingTop;
        this.cwB = (paddingTop + height) - this.cwy;
    }

    private void arh() {
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
        if (i2 != this.cwj && i2 != this.cwg && i2 != this.cwh) {
            g2 = -2;
        } else {
            g2 = g(i2, view, z);
        }
        if (g2 != layoutParams.height) {
            layoutParams.height = g2;
            view.setLayoutParams(layoutParams);
        }
        if (i2 == this.cwg || i2 == this.cwh) {
            if (i2 < this.cwj) {
                ((DragSortItemView) view).setGravity(80);
            } else if (i2 > this.cwj) {
                ((DragSortItemView) view).setGravity(48);
            }
        }
        int visibility = view.getVisibility();
        int i3 = 0;
        if (i2 == this.cwj && this.cvY != null) {
            i3 = 4;
        }
        if (i3 != visibility) {
            view.setVisibility(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int kk(int i2) {
        View view;
        if (i2 == this.cwj) {
            return 0;
        }
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        if (childAt != null) {
            return f(i2, childAt, false);
        }
        int i3 = this.cwR.get(i2);
        if (i3 == -1) {
            ListAdapter adapter = this.mListView.getAdapter();
            int itemViewType = adapter.getItemViewType(i2);
            int viewTypeCount = adapter.getViewTypeCount();
            if (viewTypeCount != this.cws.length) {
                this.cws = new View[viewTypeCount];
            }
            if (itemViewType >= 0) {
                if (this.cws[itemViewType] == null) {
                    view = adapter.getView(i2, null, this.mListView);
                    this.cws[itemViewType] = view;
                } else {
                    view = adapter.getView(i2, this.cws[itemViewType], this.mListView);
                }
            } else {
                view = adapter.getView(i2, null, this.mListView);
            }
            int f2 = f(i2, view, true);
            this.cwR.add(i2, f2);
            return f2;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(int i2, View view, boolean z) {
        if (i2 == this.cwj) {
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
        boolean z = this.cwi && this.cwg != this.cwh;
        int i4 = this.aGY - this.cwq;
        int i5 = (int) (this.cwM * i4);
        if (i2 == this.cwj) {
            if (this.cwj == this.cwg) {
                if (z) {
                    return i5 + this.cwq;
                }
                return this.aGY;
            } else if (this.cwj == this.cwh) {
                return this.aGY - i5;
            } else {
                return this.cwq;
            }
        } else if (i2 == this.cwg) {
            if (z) {
                return i3 + i5;
            }
            return i3 + i4;
        } else if (i2 == this.cwh) {
            return (i3 + i4) - i5;
        } else {
            return i3;
        }
    }

    private int b(int i2, View view, int i3, int i4) {
        int i5;
        int i6;
        int kk = kk(i2);
        int height = view.getHeight();
        int an = an(i2, kk);
        if (i2 != this.cwj) {
            i6 = height - kk;
            i5 = an - kk;
        } else {
            i5 = an;
            i6 = height;
        }
        int i7 = this.aGY;
        if (this.cwj != this.cwg && this.cwj != this.cwh) {
            i7 -= this.cwq;
        }
        if (i2 <= i3) {
            if (i2 > this.cwg) {
                return (i7 - i5) + 0;
            }
        } else if (i2 == i4) {
            if (i2 <= this.cwg) {
                return (i6 - i7) + 0;
            }
            if (i2 == this.cwh) {
                return (height - an) + 0;
            }
            return 0 + i6;
        } else if (i2 <= this.cwg) {
            return 0 - i7;
        } else {
            if (i2 == this.cwh) {
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

    private void ari() {
        if (this.cvY != null) {
            measureItem(this.cvY);
            this.aGY = this.cvY.getMeasuredHeight();
            this.cwr = this.aGY / 2;
        }
    }

    protected boolean onDragTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        switch (motionEvent.getAction() & 255) {
            case 1:
                if (this.mDragState == 4) {
                    stopDrag(false);
                }
                arf();
                return true;
            case 2:
                am((int) motionEvent.getX(), (int) motionEvent.getY());
                return true;
            case 3:
                if (this.mDragState == 4) {
                    cancelDrag();
                }
                arf();
                return true;
            default:
                return true;
        }
    }

    public boolean startDrag(int i2, int i3, int i4, int i5) {
        View km;
        if (!this.cwH || this.cwI == null || (km = this.cwI.km(i2)) == null) {
            return false;
        }
        return startDrag(i2, km, i3, i4, i5);
    }

    public boolean startDrag(int i2, View view, int i3, int i4, int i5) {
        if (this.mDragState == 0 && this.cwH && this.cvY == null && view != null && this.cwp) {
            if (this.mListView.getParent() != null) {
                this.mListView.getParent().requestDisallowInterceptTouchEvent(true);
            }
            int headerViewsCount = this.mListView.getHeaderViewsCount() + i2;
            this.cwg = headerViewsCount;
            this.cwh = headerViewsCount;
            this.cwj = headerViewsCount;
            this.cwf = headerViewsCount;
            this.mDragState = 4;
            this.cwF = 0;
            this.cwF |= i3;
            this.cvY = view;
            ari();
            this.cwk = i4;
            this.cwl = i5;
            this.cwE = this.alF;
            this.cvZ.x = this.alE - this.cwk;
            this.cvZ.y = this.alF - this.cwl;
            View childAt = this.mListView.getChildAt(this.cwj - this.mListView.getFirstVisiblePosition());
            if (childAt != null) {
                childAt.setVisibility(4);
            }
            if (this.cwO) {
                this.cwP.startTracking();
            }
            switch (this.cwK) {
                case 1:
                    this.cwX.onTouchEvent(this.cwJ);
                    break;
                case 2:
                    this.cwX.onInterceptTouchEvent(this.cwJ);
                    break;
            }
            this.mListView.requestLayout();
            if (this.cwT != null) {
                this.cwT.start();
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
        arj();
        int i3 = this.cwg;
        int i4 = this.cwh;
        boolean ara = ara();
        if (ara) {
            arh();
            this.mListView.setSelectionFromTop(i2, (b(i2, view, i3, i4) + view.getTop()) - this.mListView.getPaddingTop());
            layoutChildren();
        }
        if (ara || z) {
            this.mListView.invalidate();
        }
        this.mBlockLayoutRequests = false;
    }

    private void arj() {
        if (this.cwI != null) {
            this.cwa.set(this.alE, this.alF);
            this.cwI.b(this.cvY, this.cvZ, this.cwa);
        }
        int i2 = this.cvZ.x;
        int i3 = this.cvZ.y;
        int paddingLeft = this.mListView.getPaddingLeft();
        if ((this.cwF & 1) == 0 && i2 > paddingLeft) {
            this.cvZ.x = paddingLeft;
        } else if ((this.cwF & 2) == 0 && i2 < paddingLeft) {
            this.cvZ.x = paddingLeft;
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int lastVisiblePosition = this.mListView.getLastVisiblePosition();
        int paddingTop = this.mListView.getPaddingTop();
        if (firstVisiblePosition < headerViewsCount) {
            paddingTop = this.mListView.getChildAt((headerViewsCount - firstVisiblePosition) - 1).getBottom();
        }
        if ((this.cwF & 8) == 0 && firstVisiblePosition <= this.cwj) {
            paddingTop = Math.max(this.mListView.getChildAt(this.cwj - firstVisiblePosition).getTop(), paddingTop);
        }
        int height = this.mListView.getHeight() - this.mListView.getPaddingBottom();
        if (lastVisiblePosition >= (this.mListView.getCount() - footerViewsCount) - 1) {
            height = this.mListView.getChildAt(((this.mListView.getCount() - footerViewsCount) - 1) - firstVisiblePosition).getBottom();
        }
        if ((this.cwF & 4) == 0 && lastVisiblePosition >= this.cwj) {
            height = Math.min(this.mListView.getChildAt(this.cwj - firstVisiblePosition).getBottom(), height);
        }
        if (i3 < paddingTop) {
            this.cvZ.y = paddingTop;
        } else if (this.aGY + i3 > height) {
            this.cvZ.y = height - this.aGY;
        }
        this.cwb = this.cvZ.y + this.cwr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ark() {
        if (this.cvY != null) {
            this.cvY.setVisibility(8);
            if (this.cwI != null) {
                this.cwI.ba(this.cvY);
            }
            this.cvY = null;
            this.mListView.invalidate();
        }
    }

    public void a(h hVar) {
        this.cwI = hVar;
    }

    public void a(b bVar) {
        this.cwm = bVar;
    }

    public void setDragEnabled(boolean z) {
        this.cwp = z;
    }

    public boolean isDragEnabled() {
        return this.cwp;
    }

    public void a(g gVar) {
        this.cwn = gVar;
    }

    public void a(l lVar) {
        this.cwo = lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class i {
        private SparseIntArray cxs;
        private ArrayList<Integer> cxt;
        private int mMaxSize;

        public i(int i) {
            this.cxs = new SparseIntArray(i);
            this.cxt = new ArrayList<>(i);
            this.mMaxSize = i;
        }

        public void add(int i, int i2) {
            int i3 = this.cxs.get(i, -1);
            if (i3 != i2) {
                if (i3 == -1) {
                    if (this.cxs.size() == this.mMaxSize) {
                        this.cxs.delete(this.cxt.remove(0).intValue());
                    }
                } else {
                    this.cxt.remove(Integer.valueOf(i));
                }
                this.cxs.put(i, i2);
                this.cxt.add(Integer.valueOf(i));
            }
        }

        public int get(int i) {
            return this.cxs.get(i, -1);
        }

        public void clear() {
            this.cxs.clear();
            this.cxt.clear();
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
        private float amf;
        private float amg;
        private float amh;
        private float ami;
        private float cxD;
        private float mAlpha;
        private boolean mCanceled;
        protected long mStartTime;

        public m(float f, int i) {
            this.mAlpha = f;
            this.cxD = i;
            float f2 = 1.0f / ((this.mAlpha * 2.0f) * (1.0f - this.mAlpha));
            this.ami = f2;
            this.amf = f2;
            this.amg = this.mAlpha / ((this.mAlpha - 1.0f) * 2.0f);
            this.amh = 1.0f / (1.0f - this.mAlpha);
        }

        public float ao(float f) {
            if (f < this.mAlpha) {
                return this.amf * f * f;
            }
            if (f < 1.0f - this.mAlpha) {
                return this.amg + (this.amh * f);
            }
            return 1.0f - ((this.ami * (f - 1.0f)) * (f - 1.0f));
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
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / this.cxD;
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
        private int cxo;
        private int cxp;
        private float cxq;
        private float cxr;

        public f(float f, int i) {
            super(f, i);
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.cxo = a.this.cwf;
            this.cxp = a.this.cwj;
            a.this.mDragState = 2;
            this.cxq = a.this.cvZ.y - aro();
            this.cxr = a.this.cvZ.x - a.this.mListView.getPaddingLeft();
        }

        private int aro() {
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            int dividerHeight = (a.this.cwq + a.this.mListView.getDividerHeight()) / 2;
            View childAt = a.this.mListView.getChildAt(this.cxo - firstVisiblePosition);
            if (childAt != null) {
                if (this.cxo == this.cxp) {
                    return childAt.getTop();
                }
                if (this.cxo >= this.cxp) {
                    return (childAt.getBottom() + dividerHeight) - a.this.aGY;
                }
                return childAt.getTop() - dividerHeight;
            }
            cancel();
            return -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void t(float f, float f2) {
            int aro = aro();
            float paddingLeft = a.this.cvZ.x - a.this.mListView.getPaddingLeft();
            float f3 = 1.0f - f2;
            if (f3 < Math.abs((a.this.cvZ.y - aro) / this.cxq) || f3 < Math.abs(paddingLeft / this.cxr)) {
                a.this.cvZ.y = aro + ((int) (this.cxq * f3));
                a.this.cvZ.x = a.this.mListView.getPaddingLeft() + ((int) (this.cxr * f3));
                a.this.fm(true);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.arc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class k extends m {
        private int cxA;
        private int cxB;
        private int cxC;
        private int cxp;
        private float cxw;
        private float cxx;
        private float cxy;
        private int cxz;

        public k(float f, int i) {
            super(f, i);
            this.cxz = -1;
            this.cxA = -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.cxz = -1;
            this.cxA = -1;
            this.cxB = a.this.cwg;
            this.cxC = a.this.cwh;
            this.cxp = a.this.cwj;
            a.this.mDragState = 1;
            this.cxw = a.this.cvZ.x;
            if (a.this.cwV) {
                float width = a.this.mListView.getWidth() * 2.0f;
                if (a.this.cwW == 0.0f) {
                    a.this.cwW = (this.cxw >= 0.0f ? 1 : -1) * width;
                    return;
                }
                float f = width * 2.0f;
                if (a.this.cwW >= 0.0f || a.this.cwW <= (-f)) {
                    if (a.this.cwW > 0.0f && a.this.cwW < f) {
                        a.this.cwW = f;
                        return;
                    }
                    return;
                }
                a.this.cwW = -f;
                return;
            }
            a.this.ark();
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void t(float f, float f2) {
            View childAt;
            float f3 = 1.0f - f2;
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            View childAt2 = a.this.mListView.getChildAt(this.cxB - firstVisiblePosition);
            if (a.this.cwV) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / 1000.0f;
                if (uptimeMillis != 0.0f) {
                    float f4 = a.this.cwW * uptimeMillis;
                    int width = a.this.mListView.getWidth();
                    a.this.cwW = ((a.this.cwW > 0.0f ? 1 : -1) * uptimeMillis * width) + a.this.cwW;
                    this.cxw += f4;
                    a.this.cvZ.x = (int) this.cxw;
                    if (this.cxw < width && this.cxw > (-width)) {
                        this.mStartTime = SystemClock.uptimeMillis();
                        a.this.fm(true);
                        return;
                    }
                } else {
                    return;
                }
            }
            if (childAt2 != null) {
                if (this.cxz == -1) {
                    this.cxz = a.this.f(this.cxB, childAt2, false);
                    this.cxx = childAt2.getHeight() - this.cxz;
                }
                int max = Math.max((int) (this.cxx * f3), 1);
                ViewGroup.LayoutParams layoutParams = childAt2.getLayoutParams();
                layoutParams.height = max + this.cxz;
                childAt2.setLayoutParams(layoutParams);
            }
            if (this.cxC != this.cxB && (childAt = a.this.mListView.getChildAt(this.cxC - firstVisiblePosition)) != null) {
                if (this.cxA == -1) {
                    this.cxA = a.this.f(this.cxC, childAt, false);
                    this.cxy = childAt.getHeight() - this.cxA;
                }
                int max2 = Math.max((int) (this.cxy * f3), 1);
                ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
                layoutParams2.height = max2 + this.cxA;
                childAt.setLayoutParams(layoutParams2);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.ard();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class j extends m {
        final /* synthetic */ a cxb;
        private float cxu;
        private float cxv;

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.cxu = this.cxb.cwl;
            this.cxv = this.cxb.cwr;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void t(float f, float f2) {
            if (this.cxb.mDragState != 4) {
                cancel();
                return;
            }
            this.cxb.cwl = (int) ((this.cxv * f2) + ((1.0f - f2) * this.cxu));
            this.cxb.cvZ.y = this.cxb.alF - this.cxb.cwl;
            this.cxb.fm(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e {
        StringBuilder mBuilder = new StringBuilder();
        private int cxl = 0;
        private int cxm = 0;
        private boolean cxn = false;
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
            this.cxm = 0;
            this.cxn = true;
        }

        public void arn() {
            if (this.cxn) {
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
                this.mBuilder.append("    <FirstExpPos>").append(a.this.cwg).append("</FirstExpPos>\n");
                this.mBuilder.append("    <FirstExpBlankHeight>").append(a.this.ki(a.this.cwg) - a.this.kk(a.this.cwg)).append("</FirstExpBlankHeight>\n");
                this.mBuilder.append("    <SecondExpPos>").append(a.this.cwh).append("</SecondExpPos>\n");
                this.mBuilder.append("    <SecondExpBlankHeight>").append(a.this.ki(a.this.cwh) - a.this.kk(a.this.cwh)).append("</SecondExpBlankHeight>\n");
                this.mBuilder.append("    <SrcPos>").append(a.this.cwj).append("</SrcPos>\n");
                this.mBuilder.append("    <SrcHeight>").append(a.this.aGY + a.this.mListView.getDividerHeight()).append("</SrcHeight>\n");
                this.mBuilder.append("    <ViewHeight>").append(a.this.mListView.getHeight()).append("</ViewHeight>\n");
                this.mBuilder.append("    <LastY>").append(a.this.mLastY).append("</LastY>\n");
                this.mBuilder.append("    <FloatY>").append(a.this.cwb).append("</FloatY>\n");
                this.mBuilder.append("    <ShuffleEdges>");
                for (int i4 = 0; i4 < childCount; i4++) {
                    this.mBuilder.append(a.this.al(firstVisiblePosition + i4, a.this.mListView.getChildAt(i4).getTop())).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                this.mBuilder.append("</ShuffleEdges>\n");
                this.mBuilder.append("</DSLVState>\n");
                this.cxl++;
                if (this.cxl > 1000) {
                    flush();
                    this.cxl = 0;
                }
            }
        }

        public void flush() {
            if (this.cxn) {
                try {
                    FileWriter fileWriter = new FileWriter(this.mFile, this.cxm != 0);
                    fileWriter.write(this.mBuilder.toString());
                    this.mBuilder.delete(0, this.mBuilder.length());
                    fileWriter.flush();
                    fileWriter.close();
                    this.cxm++;
                } catch (IOException e) {
                }
            }
        }

        public void ot() {
            if (this.cxn) {
                this.mBuilder.append("</DSLVStates>\n");
                flush();
                this.cxn = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements Runnable {
        private boolean aKH = false;
        private boolean cxe;
        private long cxf;
        private long cxg;
        private float cxh;
        private long cxi;
        private int cxj;
        private float cxk;
        private int dy;

        public boolean arl() {
            return this.aKH;
        }

        public int arm() {
            if (this.aKH) {
                return this.cxj;
            }
            return -1;
        }

        public d() {
        }

        public void kl(int i) {
            if (!this.aKH) {
                this.cxe = false;
                this.aKH = true;
                this.cxi = SystemClock.uptimeMillis();
                this.cxf = this.cxi;
                this.cxj = i;
                a.this.mListView.post(this);
            }
        }

        public void fn(boolean z) {
            if (z) {
                a.this.mListView.removeCallbacks(this);
                this.aKH = false;
                return;
            }
            this.cxe = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.cxe) {
                int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
                int lastVisiblePosition = a.this.mListView.getLastVisiblePosition();
                int count = a.this.mListView.getCount();
                int paddingTop = a.this.mListView.getPaddingTop();
                int height = (a.this.mListView.getHeight() - paddingTop) - a.this.mListView.getPaddingBottom();
                int min = Math.min(a.this.alF, a.this.cwb + a.this.cwr);
                int max = Math.max(a.this.alF, a.this.cwb - a.this.cwr);
                if (this.cxj == 0) {
                    View childAt = a.this.mListView.getChildAt(0);
                    if (childAt == null) {
                        this.aKH = false;
                        return;
                    } else if (firstVisiblePosition == 0 && childAt.getTop() == paddingTop) {
                        this.aKH = false;
                        return;
                    } else {
                        this.cxk = a.this.cwD.b((a.this.cwz - max) / a.this.cwA, this.cxf);
                    }
                } else {
                    View childAt2 = a.this.mListView.getChildAt(lastVisiblePosition - firstVisiblePosition);
                    if (childAt2 == null) {
                        this.aKH = false;
                        return;
                    } else if (lastVisiblePosition == count - 1 && childAt2.getBottom() <= height + paddingTop) {
                        this.aKH = false;
                        return;
                    } else {
                        this.cxk = -a.this.cwD.b((min - a.this.cwy) / a.this.cwB, this.cxf);
                    }
                }
                this.cxg = SystemClock.uptimeMillis();
                this.cxh = (float) (this.cxg - this.cxf);
                this.dy = Math.round(this.cxk * this.cxh);
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
                this.cxf = this.cxg;
                a.this.mListView.post(this);
                return;
            }
            this.aKH = false;
        }
    }
}
