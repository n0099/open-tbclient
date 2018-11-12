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
    private d bhB;
    private int bhE;
    private int bhF;
    private float bhG;
    private float bhH;
    private float bhI;
    private float bhJ;
    private int bhM;
    private MotionEvent bhR;
    private C0167a bhV;
    private e bhX;
    private View bhg;
    private int bhj;
    private int bhn;
    private int bho;
    private int bhp;
    private int bhr;
    private int bhs;
    private int bht;
    private b bhu;
    private g bhv;
    private l bhw;
    private int bhz;
    private k bia;
    private j bib;
    private f bic;
    private boolean bie;
    private com.baidu.tbadk.widget.dragsort.d bih;
    private com.baidu.tbadk.widget.dragsort.b bii;
    private int mFloatViewHeight;
    private int mLastX;
    private int mLastY;
    private ListView mListView;
    private DataSetObserver mObserver;
    private int mOffsetX;
    private int mOffsetY;
    private int mX;
    private int mY;
    private Point bhh = new Point();
    private Point bhi = new Point();
    private boolean bhk = false;
    private float bhl = 1.0f;
    private float bhm = 1.0f;
    private boolean bhq = false;
    private boolean bhx = true;
    private int mDragState = 0;
    private int bhy = 1;
    private int mWidthMeasureSpec = 0;
    private View[] bhA = new View[1];
    private float bhC = 0.33333334f;
    private float bhD = 0.33333334f;
    private float bhK = 0.5f;
    private c bhL = new c() { // from class: com.baidu.tbadk.widget.dragsort.a.1
        @Override // com.baidu.tbadk.widget.dragsort.a.c
        public float b(float f2, long j2) {
            return a.this.bhK * f2;
        }
    };
    private int bhN = 0;
    private boolean bhO = false;
    private boolean bhP = false;
    private h bhQ = null;
    private int bhS = 0;
    private float bhT = 0.25f;
    private float bhU = 0.0f;
    private boolean bhW = false;
    private boolean mBlockLayoutRequests = false;
    private boolean bhY = false;
    private i bhZ = new i(3);
    private float bif = 0.0f;
    private boolean bij = false;
    private boolean bik = false;

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

        View gk(int i);
    }

    /* loaded from: classes.dex */
    public interface l {
        void remove(int i);
    }

    public a(ListView listView, com.baidu.tbadk.widget.dragsort.d dVar) {
        this.bih = dVar;
        this.mListView = listView;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            this.bhV = new C0167a(listAdapter);
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
            this.bhV = null;
        }
        this.bih.setAdapter(this.bhV);
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
            if (i2 > this.bhr) {
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
    public int gg(int i2) {
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        return childAt != null ? childAt.getHeight() : Q(i2, gi(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int O(int i2, int i3) {
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        if (i2 <= headerViewsCount || i2 >= this.mListView.getCount() - footerViewsCount) {
            return i3;
        }
        int dividerHeight = this.mListView.getDividerHeight();
        int i4 = this.mFloatViewHeight - this.bhy;
        int gi = gi(i2);
        int gg = gg(i2);
        if (this.bhp <= this.bhr) {
            if (i2 == this.bhp && this.bho != this.bhp) {
                if (i2 == this.bhr) {
                    i3 = (i3 + gg) - this.mFloatViewHeight;
                } else {
                    i3 = ((gg - gi) + i3) - i4;
                }
            } else if (i2 > this.bhp && i2 <= this.bhr) {
                i3 -= i4;
            }
        } else if (i2 > this.bhr && i2 <= this.bho) {
            i3 += i4;
        } else if (i2 == this.bhp && this.bho != this.bhp) {
            i3 += gg - gi;
        }
        if (i2 <= this.bhr) {
            return (((this.mFloatViewHeight - dividerHeight) - gi(i2 - 1)) / 2) + i3;
        }
        return (((gi - dividerHeight) - this.mFloatViewHeight) / 2) + i3;
    }

    private boolean PG() {
        int i2;
        int i3;
        int i4;
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int i5 = this.bho;
        View childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        if (childAt == null) {
            i5 = firstVisiblePosition + (this.mListView.getChildCount() / 2);
            childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        }
        int top = childAt.getTop();
        int height = childAt.getHeight();
        int O = O(i5, top);
        int dividerHeight = this.mListView.getDividerHeight();
        if (this.bhj >= O) {
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
                    i6 = gg(i3 + 1);
                    i2 = O(i3 + 1, i7);
                    if (this.bhj < i2) {
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
                int gg = gg(i3);
                if (i3 == 0) {
                    i2 = (i8 - dividerHeight) - gg;
                    break;
                }
                i8 -= gg + dividerHeight;
                i2 = O(i3, i8);
                if (this.bhj >= i2) {
                    break;
                }
                i4 = i2;
            }
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int i9 = this.bho;
        int i10 = this.bhp;
        float f2 = this.bhU;
        if (this.bhq) {
            int abs = Math.abs(i2 - i4);
            if (this.bhj >= i2) {
                int i11 = i4;
                i4 = i2;
                i2 = i11;
            }
            int i12 = (int) (abs * this.bhT * 0.5f);
            float f3 = i12;
            int i13 = i4 + i12;
            int i14 = i2 - i12;
            if (this.bhj < i13) {
                this.bho = i3 - 1;
                this.bhp = i3;
                this.bhU = ((i13 - this.bhj) * 0.5f) / f3;
            } else if (this.bhj < i14) {
                this.bho = i3;
                this.bhp = i3;
            } else {
                this.bho = i3;
                this.bhp = i3 + 1;
                this.bhU = (1.0f + ((i2 - this.bhj) / f3)) * 0.5f;
            }
        } else {
            this.bho = i3;
            this.bhp = i3;
        }
        if (this.bho < headerViewsCount) {
            this.bho = headerViewsCount;
            this.bhp = headerViewsCount;
            i3 = headerViewsCount;
        } else if (this.bhp >= this.mListView.getCount() - footerViewsCount) {
            i3 = (this.mListView.getCount() - footerViewsCount) - 1;
            this.bho = i3;
            this.bhp = i3;
        }
        boolean z = (this.bho == i9 && this.bhp == i10 && this.bhU == f2) ? false : true;
        if (i3 != this.bhn) {
            if (this.bhu != null) {
                this.bhu.drag(this.bhn - headerViewsCount, i3 - headerViewsCount);
            }
            this.bhn = i3;
            return true;
        }
        return z;
    }

    public void removeItem(int i2) {
        this.bie = false;
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
            this.bhy = Math.max(1, obtainStyledAttributes.getDimensionPixelSize(e.l.DragSort_collapsed_height, 1));
            this.bhW = obtainStyledAttributes.getBoolean(e.l.DragSort_track_drag_sort, false);
            if (this.bhW) {
                this.bhX = new e();
            }
            this.bhl = obtainStyledAttributes.getFloat(e.l.DragSort_float_alpha, this.bhl);
            this.bhm = this.bhl;
            this.bhx = obtainStyledAttributes.getBoolean(e.l.DragSort_drag_enabled, this.bhx);
            this.bhT = Math.max(0.0f, Math.min(1.0f, 1.0f - obtainStyledAttributes.getFloat(e.l.DragSort_slide_shuffle_speed, 0.75f)));
            this.bhq = this.bhT > 0.0f;
            setDragScrollStart(obtainStyledAttributes.getFloat(e.l.DragSort_drag_scroll_start, this.bhC));
            this.bhK = obtainStyledAttributes.getFloat(e.l.DragSort_max_drag_scroll_speed, this.bhK);
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
                bVar.cV(z);
                bVar.cU(z2);
                bVar.setBackgroundColor(color);
                this.bhQ = bVar;
                a(bVar);
            }
            obtainStyledAttributes.recycle();
            i2 = i5;
            i3 = i4;
        }
        this.bhB = new d();
        if (i3 > 0) {
            this.bia = new k(0.5f, i3);
        }
        if (i2 > 0) {
            this.bic = new f(0.5f, i2);
        }
        this.bhR = MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
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
        this.bii = bVar;
        this.mListView.setOnTouchListener(bVar);
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void dispatchDraw(Canvas canvas) {
        float f2;
        this.bih.dispatchDraw(canvas);
        if (this.mDragState != 0) {
            if (this.bho != this.bhr) {
                b(this.bho, canvas);
            }
            if (this.bhp != this.bho && this.bhp != this.bhr) {
                b(this.bhp, canvas);
            }
        }
        if (this.bhg != null) {
            int width = this.bhg.getWidth();
            int height = this.bhg.getHeight();
            int i2 = this.bhh.x;
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
            int i3 = (int) (f2 * 255.0f * this.bhm);
            canvas.save();
            canvas.translate(this.bhh.x, this.bhh.y);
            canvas.clipRect(0, 0, width, height);
            canvas.saveLayerAlpha(0.0f, 0.0f, width, height, i3, 31);
            this.bhg.draw(canvas);
            canvas.restore();
            canvas.restore();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onDraw(Canvas canvas) {
        this.bih.onDraw(canvas);
        if (this.bhW) {
            this.bhX.PS();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.bhY) {
            this.bhY = false;
            return false;
        } else if (!this.bhx) {
            return this.bih.onTouchEvent(motionEvent);
        } else {
            boolean z2 = this.bhO;
            this.bhO = false;
            if (!z2) {
                u(motionEvent);
            }
            if (this.mDragState == 4) {
                onDragTouchEvent(motionEvent);
                return true;
            }
            if (this.mDragState == 0 && this.bih.onTouchEvent(motionEvent)) {
                z = true;
            }
            switch (motionEvent.getAction() & 255) {
                case 1:
                case 3:
                    PL();
                    return z;
                case 2:
                default:
                    if (z) {
                        this.bhS = 1;
                        return z;
                    }
                    return z;
            }
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (!this.bhx) {
            return this.bih.onInterceptTouchEvent(motionEvent);
        }
        if (this.bii != null) {
            this.bii.PU().onTouchEvent(motionEvent);
        }
        u(motionEvent);
        this.bhO = true;
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            if (this.mDragState != 0) {
                this.bhY = true;
                return true;
            }
            this.bhP = true;
        }
        if (this.bhg == null) {
            if (this.bih.onInterceptTouchEvent(motionEvent)) {
                this.bij = true;
                z = true;
            } else {
                z = false;
            }
            switch (action) {
                case 1:
                case 3:
                    PL();
                    break;
                case 2:
                default:
                    if (z) {
                        this.bhS = 1;
                        break;
                    } else {
                        this.bhS = 2;
                        break;
                    }
            }
        } else {
            z = true;
        }
        if (action == 1 || action == 3) {
            this.bhP = false;
        }
        return z;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        this.bih.onSizeChanged(i2, i3, i4, i5);
        PM();
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void requestLayout() {
        if (!this.mBlockLayoutRequests) {
            this.bih.requestLayout();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onMeasure(int i2, int i3) {
        this.bih.onMeasure(i2, i3);
        if (this.bhg != null) {
            if (this.bhg.isLayoutRequested()) {
                PO();
            }
            this.bhk = true;
        }
        this.mWidthMeasureSpec = i2;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void layoutChildren() {
        this.bih.layoutChildren();
        if (this.bhg != null) {
            if (this.bhg.isLayoutRequested() && !this.bhk) {
                PO();
            }
            this.bhg.layout(0, 0, this.bhg.getMeasuredWidth(), this.bhg.getMeasuredHeight());
            this.bhk = false;
        }
    }

    public void removeItem(int i2, float f2) {
        if (this.mDragState == 0 || this.mDragState == 4) {
            if (this.mDragState == 0) {
                this.bhr = this.mListView.getHeaderViewsCount() + i2;
                this.bho = this.bhr;
                this.bhp = this.bhr;
                this.bhn = this.bhr;
                View childAt = this.mListView.getChildAt(this.bhr - this.mListView.getFirstVisiblePosition());
                if (childAt != null) {
                    childAt.setVisibility(4);
                }
            }
            this.mDragState = 1;
            this.bif = f2;
            if (this.bhP) {
                switch (this.bhS) {
                    case 1:
                        this.bih.onTouchEvent(this.bhR);
                        break;
                    case 2:
                        this.bih.onInterceptTouchEvent(this.bhR);
                        break;
                }
            }
            if (this.bia != null) {
                this.bia.start();
            } else {
                gh(i2);
            }
        }
    }

    public void cancelDrag() {
        if (this.mDragState == 4) {
            this.bhB.cT(true);
            PQ();
            PH();
            PN();
            if (this.bhP) {
                this.mDragState = 3;
            } else {
                this.mDragState = 0;
            }
        }
    }

    private void PH() {
        this.bhr = -1;
        this.bho = -1;
        this.bhp = -1;
        this.bhn = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PI() {
        this.mDragState = 2;
        if (this.bhv != null && this.bhn >= 0 && this.bhn < this.mListView.getCount()) {
            int headerViewsCount = this.mListView.getHeaderViewsCount();
            this.bhv.drop(this.bhr - headerViewsCount, this.bhn - headerViewsCount);
        }
        PQ();
        PK();
        PH();
        PN();
        if (this.bhP) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PJ() {
        gh(this.bhr - this.mListView.getHeaderViewsCount());
    }

    private void gh(int i2) {
        this.mDragState = 1;
        if (this.bhw != null) {
            this.bhw.remove(i2);
        }
        PQ();
        PK();
        PH();
        if (this.bhP) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    private void PK() {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        if (this.bhr < firstVisiblePosition) {
            View childAt = this.mListView.getChildAt(0);
            this.mListView.setSelectionFromTop(firstVisiblePosition - 1, (childAt != null ? childAt.getTop() : 0) - this.mListView.getPaddingTop());
        }
    }

    public boolean stopDrag(boolean z) {
        this.bie = false;
        return stopDrag(z, 0.0f);
    }

    public boolean stopDragWithVelocity(boolean z, float f2) {
        this.bie = true;
        return stopDrag(z, f2);
    }

    public boolean stopDrag(boolean z, float f2) {
        if (this.bhg != null) {
            this.bhB.cT(true);
            if (z) {
                removeItem(this.bhr - this.mListView.getHeaderViewsCount(), f2);
            } else if (this.bic != null) {
                this.bic.start();
            } else {
                PI();
            }
            if (this.bhW) {
                this.bhX.ol();
                return true;
            }
            return true;
        }
        return false;
    }

    private void PL() {
        this.bhS = 0;
        this.bhP = false;
        if (this.mDragState == 3) {
            this.mDragState = 0;
        }
        this.bhm = this.bhl;
        this.bij = false;
        this.bhZ.clear();
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
        return this.bij;
    }

    public void setDragScrollStart(float f2) {
        setDragScrollStarts(f2, f2);
    }

    public void setDragScrollStarts(float f2, float f3) {
        if (f3 > 0.5f) {
            this.bhD = 0.5f;
        } else {
            this.bhD = f3;
        }
        if (f2 > 0.5f) {
            this.bhC = 0.5f;
        } else {
            this.bhC = f2;
        }
        if (this.mListView.getHeight() != 0) {
            PM();
        }
    }

    private void P(int i2, int i3) {
        this.bhh.x = i2 - this.bhs;
        this.bhh.y = i3 - this.bht;
        cS(true);
        int min = Math.min(i3, this.bhj + this.bhz);
        int max = Math.max(i3, this.bhj - this.bhz);
        int PR = this.bhB.PR();
        if (min > this.mLastY && min > this.bhF && PR != 1) {
            if (PR != -1) {
                this.bhB.cT(true);
            }
            this.bhB.gj(1);
        } else if (max < this.mLastY && max < this.bhE && PR != 0) {
            if (PR != -1) {
                this.bhB.cT(true);
            }
            this.bhB.gj(0);
        } else if (max >= this.bhE && min <= this.bhF && this.bhB.isScrolling()) {
            this.bhB.cT(true);
        }
    }

    private void PM() {
        int height;
        int paddingTop = this.mListView.getPaddingTop();
        float height2 = (this.mListView.getHeight() - paddingTop) - this.mListView.getPaddingBottom();
        this.bhH = paddingTop + (this.bhC * height2);
        this.bhG = (height2 * (1.0f - this.bhD)) + paddingTop;
        this.bhE = (int) this.bhH;
        this.bhF = (int) this.bhG;
        this.bhI = this.bhH - paddingTop;
        this.bhJ = (paddingTop + height) - this.bhG;
    }

    private void PN() {
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
        if (i2 != this.bhr && i2 != this.bho && i2 != this.bhp) {
            g2 = -2;
        } else {
            g2 = g(i2, view, z);
        }
        if (g2 != layoutParams.height) {
            layoutParams.height = g2;
            view.setLayoutParams(layoutParams);
        }
        if (i2 == this.bho || i2 == this.bhp) {
            if (i2 < this.bhr) {
                ((DragSortItemView) view).setGravity(80);
            } else if (i2 > this.bhr) {
                ((DragSortItemView) view).setGravity(48);
            }
        }
        int visibility = view.getVisibility();
        int i3 = 0;
        if (i2 == this.bhr && this.bhg != null) {
            i3 = 4;
        }
        if (i3 != visibility) {
            view.setVisibility(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int gi(int i2) {
        View view;
        if (i2 == this.bhr) {
            return 0;
        }
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        if (childAt != null) {
            return f(i2, childAt, false);
        }
        int i3 = this.bhZ.get(i2);
        if (i3 == -1) {
            ListAdapter adapter = this.mListView.getAdapter();
            int itemViewType = adapter.getItemViewType(i2);
            int viewTypeCount = adapter.getViewTypeCount();
            if (viewTypeCount != this.bhA.length) {
                this.bhA = new View[viewTypeCount];
            }
            if (itemViewType >= 0) {
                if (this.bhA[itemViewType] == null) {
                    view = adapter.getView(i2, null, this.mListView);
                    this.bhA[itemViewType] = view;
                } else {
                    view = adapter.getView(i2, this.bhA[itemViewType], this.mListView);
                }
            } else {
                view = adapter.getView(i2, null, this.mListView);
            }
            int f2 = f(i2, view, true);
            this.bhZ.add(i2, f2);
            return f2;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(int i2, View view, boolean z) {
        if (i2 == this.bhr) {
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
        boolean z = this.bhq && this.bho != this.bhp;
        int i4 = this.mFloatViewHeight - this.bhy;
        int i5 = (int) (this.bhU * i4);
        if (i2 == this.bhr) {
            if (this.bhr == this.bho) {
                if (z) {
                    return i5 + this.bhy;
                }
                return this.mFloatViewHeight;
            } else if (this.bhr == this.bhp) {
                return this.mFloatViewHeight - i5;
            } else {
                return this.bhy;
            }
        } else if (i2 == this.bho) {
            if (z) {
                return i3 + i5;
            }
            return i3 + i4;
        } else if (i2 == this.bhp) {
            return (i3 + i4) - i5;
        } else {
            return i3;
        }
    }

    private int b(int i2, View view, int i3, int i4) {
        int i5;
        int i6;
        int gi = gi(i2);
        int height = view.getHeight();
        int Q = Q(i2, gi);
        if (i2 != this.bhr) {
            i6 = height - gi;
            i5 = Q - gi;
        } else {
            i5 = Q;
            i6 = height;
        }
        int i7 = this.mFloatViewHeight;
        if (this.bhr != this.bho && this.bhr != this.bhp) {
            i7 -= this.bhy;
        }
        if (i2 <= i3) {
            if (i2 > this.bho) {
                return (i7 - i5) + 0;
            }
        } else if (i2 == i4) {
            if (i2 <= this.bho) {
                return (i6 - i7) + 0;
            }
            if (i2 == this.bhp) {
                return (height - Q) + 0;
            }
            return 0 + i6;
        } else if (i2 <= this.bho) {
            return 0 - i7;
        } else {
            if (i2 == this.bhp) {
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

    private void PO() {
        if (this.bhg != null) {
            measureItem(this.bhg);
            this.mFloatViewHeight = this.bhg.getMeasuredHeight();
            this.bhz = this.mFloatViewHeight / 2;
        }
    }

    protected boolean onDragTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        switch (motionEvent.getAction() & 255) {
            case 1:
                if (this.mDragState == 4) {
                    stopDrag(false);
                }
                PL();
                return true;
            case 2:
                P((int) motionEvent.getX(), (int) motionEvent.getY());
                return true;
            case 3:
                if (this.mDragState == 4) {
                    cancelDrag();
                }
                PL();
                return true;
            default:
                return true;
        }
    }

    public boolean startDrag(int i2, int i3, int i4, int i5) {
        View gk;
        if (!this.bhP || this.bhQ == null || (gk = this.bhQ.gk(i2)) == null) {
            return false;
        }
        return startDrag(i2, gk, i3, i4, i5);
    }

    public boolean startDrag(int i2, View view, int i3, int i4, int i5) {
        if (this.mDragState == 0 && this.bhP && this.bhg == null && view != null && this.bhx) {
            if (this.mListView.getParent() != null) {
                this.mListView.getParent().requestDisallowInterceptTouchEvent(true);
            }
            int headerViewsCount = this.mListView.getHeaderViewsCount() + i2;
            this.bho = headerViewsCount;
            this.bhp = headerViewsCount;
            this.bhr = headerViewsCount;
            this.bhn = headerViewsCount;
            this.mDragState = 4;
            this.bhN = 0;
            this.bhN |= i3;
            this.bhg = view;
            PO();
            this.bhs = i4;
            this.bht = i5;
            this.bhM = this.mY;
            this.bhh.x = this.mX - this.bhs;
            this.bhh.y = this.mY - this.bht;
            View childAt = this.mListView.getChildAt(this.bhr - this.mListView.getFirstVisiblePosition());
            if (childAt != null) {
                childAt.setVisibility(4);
            }
            if (this.bhW) {
                this.bhX.startTracking();
            }
            switch (this.bhS) {
                case 1:
                    this.bih.onTouchEvent(this.bhR);
                    break;
                case 2:
                    this.bih.onInterceptTouchEvent(this.bhR);
                    break;
            }
            this.mListView.requestLayout();
            if (this.bib != null) {
                this.bib.start();
                return true;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cS(boolean z) {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition() + (this.mListView.getChildCount() / 2);
        View childAt = this.mListView.getChildAt(this.mListView.getChildCount() / 2);
        if (childAt != null) {
            h(firstVisiblePosition, childAt, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i2, View view, boolean z) {
        this.mBlockLayoutRequests = true;
        PP();
        int i3 = this.bho;
        int i4 = this.bhp;
        boolean PG = PG();
        if (PG) {
            PN();
            this.mListView.setSelectionFromTop(i2, (b(i2, view, i3, i4) + view.getTop()) - this.mListView.getPaddingTop());
            layoutChildren();
        }
        if (PG || z) {
            this.mListView.invalidate();
        }
        this.mBlockLayoutRequests = false;
    }

    private void PP() {
        if (this.bhQ != null) {
            this.bhi.set(this.mX, this.mY);
            this.bhQ.b(this.bhg, this.bhh, this.bhi);
        }
        int i2 = this.bhh.x;
        int i3 = this.bhh.y;
        int paddingLeft = this.mListView.getPaddingLeft();
        if ((this.bhN & 1) == 0 && i2 > paddingLeft) {
            this.bhh.x = paddingLeft;
        } else if ((this.bhN & 2) == 0 && i2 < paddingLeft) {
            this.bhh.x = paddingLeft;
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int lastVisiblePosition = this.mListView.getLastVisiblePosition();
        int paddingTop = this.mListView.getPaddingTop();
        if (firstVisiblePosition < headerViewsCount) {
            paddingTop = this.mListView.getChildAt((headerViewsCount - firstVisiblePosition) - 1).getBottom();
        }
        if ((this.bhN & 8) == 0 && firstVisiblePosition <= this.bhr) {
            paddingTop = Math.max(this.mListView.getChildAt(this.bhr - firstVisiblePosition).getTop(), paddingTop);
        }
        int height = this.mListView.getHeight() - this.mListView.getPaddingBottom();
        if (lastVisiblePosition >= (this.mListView.getCount() - footerViewsCount) - 1) {
            height = this.mListView.getChildAt(((this.mListView.getCount() - footerViewsCount) - 1) - firstVisiblePosition).getBottom();
        }
        if ((this.bhN & 4) == 0 && lastVisiblePosition >= this.bhr) {
            height = Math.min(this.mListView.getChildAt(this.bhr - firstVisiblePosition).getBottom(), height);
        }
        if (i3 < paddingTop) {
            this.bhh.y = paddingTop;
        } else if (this.mFloatViewHeight + i3 > height) {
            this.bhh.y = height - this.mFloatViewHeight;
        }
        this.bhj = this.bhh.y + this.bhz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PQ() {
        if (this.bhg != null) {
            this.bhg.setVisibility(8);
            if (this.bhQ != null) {
                this.bhQ.af(this.bhg);
            }
            this.bhg = null;
            this.mListView.invalidate();
        }
    }

    public void a(h hVar) {
        this.bhQ = hVar;
    }

    public void a(b bVar) {
        this.bhu = bVar;
    }

    public void setDragEnabled(boolean z) {
        this.bhx = z;
    }

    public boolean isDragEnabled() {
        return this.bhx;
    }

    public void a(g gVar) {
        this.bhv = gVar;
    }

    public void a(l lVar) {
        this.bhw = lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class i {
        private SparseIntArray biC;
        private ArrayList<Integer> biD;
        private int mMaxSize;

        public i(int i) {
            this.biC = new SparseIntArray(i);
            this.biD = new ArrayList<>(i);
            this.mMaxSize = i;
        }

        public void add(int i, int i2) {
            int i3 = this.biC.get(i, -1);
            if (i3 != i2) {
                if (i3 == -1) {
                    if (this.biC.size() == this.mMaxSize) {
                        this.biC.delete(this.biD.remove(0).intValue());
                    }
                } else {
                    this.biD.remove(Integer.valueOf(i));
                }
                this.biC.put(i, i2);
                this.biD.add(Integer.valueOf(i));
            }
        }

        public int get(int i) {
            return this.biC.get(i, -1);
        }

        public void clear() {
            this.biC.clear();
            this.biD.clear();
        }
    }

    /* renamed from: com.baidu.tbadk.widget.dragsort.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0167a extends BaseAdapter {
        private ListAdapter mAdapter;

        public C0167a(ListAdapter listAdapter) {
            this.mAdapter = listAdapter;
            this.mAdapter.registerDataSetObserver(new DataSetObserver() { // from class: com.baidu.tbadk.widget.dragsort.a.a.1
                @Override // android.database.DataSetObserver
                public void onChanged() {
                    C0167a.this.notifyDataSetChanged();
                }

                @Override // android.database.DataSetObserver
                public void onInvalidated() {
                    C0167a.this.notifyDataSetInvalidated();
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
        private float biN;
        private float mA;
        private float mAlpha;
        private float mB;
        private float mC;
        private boolean mCanceled;
        private float mD;
        protected long mStartTime;

        public m(float f, int i) {
            this.mAlpha = f;
            this.biN = i;
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
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / this.biN;
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
        private float biA;
        private float biB;
        private int biy;
        private int biz;

        public f(float f, int i) {
            super(f, i);
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.biy = a.this.bhn;
            this.biz = a.this.bhr;
            a.this.mDragState = 2;
            this.biA = a.this.bhh.y - PT();
            this.biB = a.this.bhh.x - a.this.mListView.getPaddingLeft();
        }

        private int PT() {
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            int dividerHeight = (a.this.bhy + a.this.mListView.getDividerHeight()) / 2;
            View childAt = a.this.mListView.getChildAt(this.biy - firstVisiblePosition);
            if (childAt != null) {
                if (this.biy == this.biz) {
                    return childAt.getTop();
                }
                if (this.biy >= this.biz) {
                    return (childAt.getBottom() + dividerHeight) - a.this.mFloatViewHeight;
                }
                return childAt.getTop() - dividerHeight;
            }
            cancel();
            return -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void q(float f, float f2) {
            int PT = PT();
            float paddingLeft = a.this.bhh.x - a.this.mListView.getPaddingLeft();
            float f3 = 1.0f - f2;
            if (f3 < Math.abs((a.this.bhh.y - PT) / this.biA) || f3 < Math.abs(paddingLeft / this.biB)) {
                a.this.bhh.y = PT + ((int) (this.biA * f3));
                a.this.bhh.x = a.this.mListView.getPaddingLeft() + ((int) (this.biB * f3));
                a.this.cS(true);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.PI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class k extends m {
        private float biG;
        private float biH;
        private float biI;
        private int biJ;
        private int biK;
        private int biL;
        private int biM;
        private int biz;

        public k(float f, int i) {
            super(f, i);
            this.biJ = -1;
            this.biK = -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.biJ = -1;
            this.biK = -1;
            this.biL = a.this.bho;
            this.biM = a.this.bhp;
            this.biz = a.this.bhr;
            a.this.mDragState = 1;
            this.biG = a.this.bhh.x;
            if (a.this.bie) {
                float width = a.this.mListView.getWidth() * 2.0f;
                if (a.this.bif == 0.0f) {
                    a.this.bif = (this.biG >= 0.0f ? 1 : -1) * width;
                    return;
                }
                float f = width * 2.0f;
                if (a.this.bif >= 0.0f || a.this.bif <= (-f)) {
                    if (a.this.bif > 0.0f && a.this.bif < f) {
                        a.this.bif = f;
                        return;
                    }
                    return;
                }
                a.this.bif = -f;
                return;
            }
            a.this.PQ();
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void q(float f, float f2) {
            View childAt;
            float f3 = 1.0f - f2;
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            View childAt2 = a.this.mListView.getChildAt(this.biL - firstVisiblePosition);
            if (a.this.bie) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / 1000.0f;
                if (uptimeMillis != 0.0f) {
                    float f4 = a.this.bif * uptimeMillis;
                    int width = a.this.mListView.getWidth();
                    a.this.bif = ((a.this.bif > 0.0f ? 1 : -1) * uptimeMillis * width) + a.this.bif;
                    this.biG += f4;
                    a.this.bhh.x = (int) this.biG;
                    if (this.biG < width && this.biG > (-width)) {
                        this.mStartTime = SystemClock.uptimeMillis();
                        a.this.cS(true);
                        return;
                    }
                } else {
                    return;
                }
            }
            if (childAt2 != null) {
                if (this.biJ == -1) {
                    this.biJ = a.this.f(this.biL, childAt2, false);
                    this.biH = childAt2.getHeight() - this.biJ;
                }
                int max = Math.max((int) (this.biH * f3), 1);
                ViewGroup.LayoutParams layoutParams = childAt2.getLayoutParams();
                layoutParams.height = max + this.biJ;
                childAt2.setLayoutParams(layoutParams);
            }
            if (this.biM != this.biL && (childAt = a.this.mListView.getChildAt(this.biM - firstVisiblePosition)) != null) {
                if (this.biK == -1) {
                    this.biK = a.this.f(this.biM, childAt, false);
                    this.biI = childAt.getHeight() - this.biK;
                }
                int max2 = Math.max((int) (this.biI * f3), 1);
                ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
                layoutParams2.height = max2 + this.biK;
                childAt.setLayoutParams(layoutParams2);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.PJ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class j extends m {
        private float biE;
        private float biF;
        final /* synthetic */ a bil;

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.biE = this.bil.bht;
            this.biF = this.bil.bhz;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void q(float f, float f2) {
            if (this.bil.mDragState != 4) {
                cancel();
                return;
            }
            this.bil.bht = (int) ((this.biF * f2) + ((1.0f - f2) * this.biE));
            this.bil.bhh.y = this.bil.mY - this.bil.bht;
            this.bil.cS(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e {
        StringBuilder mBuilder = new StringBuilder();
        private int biv = 0;
        private int biw = 0;
        private boolean bix = false;
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
            this.biw = 0;
            this.bix = true;
        }

        public void PS() {
            if (this.bix) {
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
                this.mBuilder.append("    <FirstExpPos>").append(a.this.bho).append("</FirstExpPos>\n");
                this.mBuilder.append("    <FirstExpBlankHeight>").append(a.this.gg(a.this.bho) - a.this.gi(a.this.bho)).append("</FirstExpBlankHeight>\n");
                this.mBuilder.append("    <SecondExpPos>").append(a.this.bhp).append("</SecondExpPos>\n");
                this.mBuilder.append("    <SecondExpBlankHeight>").append(a.this.gg(a.this.bhp) - a.this.gi(a.this.bhp)).append("</SecondExpBlankHeight>\n");
                this.mBuilder.append("    <SrcPos>").append(a.this.bhr).append("</SrcPos>\n");
                this.mBuilder.append("    <SrcHeight>").append(a.this.mFloatViewHeight + a.this.mListView.getDividerHeight()).append("</SrcHeight>\n");
                this.mBuilder.append("    <ViewHeight>").append(a.this.mListView.getHeight()).append("</ViewHeight>\n");
                this.mBuilder.append("    <LastY>").append(a.this.mLastY).append("</LastY>\n");
                this.mBuilder.append("    <FloatY>").append(a.this.bhj).append("</FloatY>\n");
                this.mBuilder.append("    <ShuffleEdges>");
                for (int i4 = 0; i4 < childCount; i4++) {
                    this.mBuilder.append(a.this.O(firstVisiblePosition + i4, a.this.mListView.getChildAt(i4).getTop())).append(",");
                }
                this.mBuilder.append("</ShuffleEdges>\n");
                this.mBuilder.append("</DSLVState>\n");
                this.biv++;
                if (this.biv > 1000) {
                    flush();
                    this.biv = 0;
                }
            }
        }

        public void flush() {
            if (this.bix) {
                try {
                    FileWriter fileWriter = new FileWriter(this.mFile, this.biw != 0);
                    fileWriter.write(this.mBuilder.toString());
                    this.mBuilder.delete(0, this.mBuilder.length());
                    fileWriter.flush();
                    fileWriter.close();
                    this.biw++;
                } catch (IOException e) {
                }
            }
        }

        public void ol() {
            if (this.bix) {
                this.mBuilder.append("</DSLVStates>\n");
                flush();
                this.bix = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements Runnable {
        private boolean bio;
        private long bip;
        private long biq;
        private float bir;
        private long bis;
        private int bit;
        private float biu;
        private int dy;
        private boolean mScrolling = false;

        public boolean isScrolling() {
            return this.mScrolling;
        }

        public int PR() {
            if (this.mScrolling) {
                return this.bit;
            }
            return -1;
        }

        public d() {
        }

        public void gj(int i) {
            if (!this.mScrolling) {
                this.bio = false;
                this.mScrolling = true;
                this.bis = SystemClock.uptimeMillis();
                this.bip = this.bis;
                this.bit = i;
                a.this.mListView.post(this);
            }
        }

        public void cT(boolean z) {
            if (z) {
                a.this.mListView.removeCallbacks(this);
                this.mScrolling = false;
                return;
            }
            this.bio = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.bio) {
                int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
                int lastVisiblePosition = a.this.mListView.getLastVisiblePosition();
                int count = a.this.mListView.getCount();
                int paddingTop = a.this.mListView.getPaddingTop();
                int height = (a.this.mListView.getHeight() - paddingTop) - a.this.mListView.getPaddingBottom();
                int min = Math.min(a.this.mY, a.this.bhj + a.this.bhz);
                int max = Math.max(a.this.mY, a.this.bhj - a.this.bhz);
                if (this.bit == 0) {
                    View childAt = a.this.mListView.getChildAt(0);
                    if (childAt == null) {
                        this.mScrolling = false;
                        return;
                    } else if (firstVisiblePosition == 0 && childAt.getTop() == paddingTop) {
                        this.mScrolling = false;
                        return;
                    } else {
                        this.biu = a.this.bhL.b((a.this.bhH - max) / a.this.bhI, this.bip);
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
                        this.biu = -a.this.bhL.b((min - a.this.bhG) / a.this.bhJ, this.bip);
                    }
                }
                this.biq = SystemClock.uptimeMillis();
                this.bir = (float) (this.biq - this.bip);
                this.dy = Math.round(this.biu * this.bir);
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
                this.bip = this.biq;
                a.this.mListView.post(this);
                return;
            }
            this.mScrolling = false;
        }
    }
}
