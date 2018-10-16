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
    private int bgC;
    private int bgD;
    private int bgE;
    private int bgG;
    private int bgH;
    private int bgI;
    private b bgJ;
    private g bgK;
    private l bgL;
    private int bgO;
    private d bgQ;
    private int bgT;
    private int bgU;
    private float bgV;
    private float bgW;
    private float bgX;
    private float bgY;
    private View bgv;
    private int bgy;
    private int bhb;
    private MotionEvent bhg;
    private C0143a bhk;
    private e bhm;
    private k bhp;
    private j bhq;
    private f bhr;
    private boolean bhs;
    private com.baidu.tbadk.widget.dragsort.d bhu;
    private com.baidu.tbadk.widget.dragsort.b bhv;
    private int mFloatViewHeight;
    private int mLastX;
    private int mLastY;
    private ListView mListView;
    private DataSetObserver mObserver;
    private int mOffsetX;
    private int mOffsetY;
    private int mX;
    private int mY;
    private Point bgw = new Point();
    private Point bgx = new Point();
    private boolean bgz = false;
    private float bgA = 1.0f;
    private float bgB = 1.0f;
    private boolean bgF = false;
    private boolean bgM = true;
    private int mDragState = 0;
    private int bgN = 1;
    private int mWidthMeasureSpec = 0;
    private View[] bgP = new View[1];
    private float bgR = 0.33333334f;
    private float bgS = 0.33333334f;
    private float bgZ = 0.5f;
    private c bha = new c() { // from class: com.baidu.tbadk.widget.dragsort.a.1
        @Override // com.baidu.tbadk.widget.dragsort.a.c
        public float b(float f2, long j2) {
            return a.this.bgZ * f2;
        }
    };
    private int bhc = 0;
    private boolean bhd = false;
    private boolean bhe = false;
    private h bhf = null;
    private int bhh = 0;
    private float bhi = 0.25f;
    private float bhj = 0.0f;
    private boolean bhl = false;
    private boolean mBlockLayoutRequests = false;
    private boolean bhn = false;
    private i bho = new i(3);
    private float bht = 0.0f;
    private boolean bhw = false;
    private boolean bhx = false;

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

        View fW(int i);
    }

    /* loaded from: classes.dex */
    public interface l {
        void remove(int i);
    }

    public a(ListView listView, com.baidu.tbadk.widget.dragsort.d dVar) {
        this.bhu = dVar;
        this.mListView = listView;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            this.bhk = new C0143a(listAdapter);
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
            this.bhk = null;
        }
        this.bhu.setAdapter(this.bhk);
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
            if (i2 > this.bgG) {
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
    public int fS(int i2) {
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        return childAt != null ? childAt.getHeight() : Q(i2, fU(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int O(int i2, int i3) {
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        if (i2 <= headerViewsCount || i2 >= this.mListView.getCount() - footerViewsCount) {
            return i3;
        }
        int dividerHeight = this.mListView.getDividerHeight();
        int i4 = this.mFloatViewHeight - this.bgN;
        int fU = fU(i2);
        int fS = fS(i2);
        if (this.bgE <= this.bgG) {
            if (i2 == this.bgE && this.bgD != this.bgE) {
                if (i2 == this.bgG) {
                    i3 = (i3 + fS) - this.mFloatViewHeight;
                } else {
                    i3 = ((fS - fU) + i3) - i4;
                }
            } else if (i2 > this.bgE && i2 <= this.bgG) {
                i3 -= i4;
            }
        } else if (i2 > this.bgG && i2 <= this.bgD) {
            i3 += i4;
        } else if (i2 == this.bgE && this.bgD != this.bgE) {
            i3 += fS - fU;
        }
        if (i2 <= this.bgG) {
            return (((this.mFloatViewHeight - dividerHeight) - fU(i2 - 1)) / 2) + i3;
        }
        return (((fU - dividerHeight) - this.mFloatViewHeight) / 2) + i3;
    }

    private boolean Px() {
        int i2;
        int i3;
        int i4;
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int i5 = this.bgD;
        View childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        if (childAt == null) {
            i5 = firstVisiblePosition + (this.mListView.getChildCount() / 2);
            childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        }
        int top = childAt.getTop();
        int height = childAt.getHeight();
        int O = O(i5, top);
        int dividerHeight = this.mListView.getDividerHeight();
        if (this.bgy >= O) {
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
                    i6 = fS(i3 + 1);
                    i2 = O(i3 + 1, i7);
                    if (this.bgy < i2) {
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
                int fS = fS(i3);
                if (i3 == 0) {
                    i2 = (i8 - dividerHeight) - fS;
                    break;
                }
                i8 -= fS + dividerHeight;
                i2 = O(i3, i8);
                if (this.bgy >= i2) {
                    break;
                }
                i4 = i2;
            }
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int i9 = this.bgD;
        int i10 = this.bgE;
        float f2 = this.bhj;
        if (this.bgF) {
            int abs = Math.abs(i2 - i4);
            if (this.bgy >= i2) {
                int i11 = i4;
                i4 = i2;
                i2 = i11;
            }
            int i12 = (int) (abs * this.bhi * 0.5f);
            float f3 = i12;
            int i13 = i4 + i12;
            int i14 = i2 - i12;
            if (this.bgy < i13) {
                this.bgD = i3 - 1;
                this.bgE = i3;
                this.bhj = ((i13 - this.bgy) * 0.5f) / f3;
            } else if (this.bgy < i14) {
                this.bgD = i3;
                this.bgE = i3;
            } else {
                this.bgD = i3;
                this.bgE = i3 + 1;
                this.bhj = (1.0f + ((i2 - this.bgy) / f3)) * 0.5f;
            }
        } else {
            this.bgD = i3;
            this.bgE = i3;
        }
        if (this.bgD < headerViewsCount) {
            this.bgD = headerViewsCount;
            this.bgE = headerViewsCount;
            i3 = headerViewsCount;
        } else if (this.bgE >= this.mListView.getCount() - footerViewsCount) {
            i3 = (this.mListView.getCount() - footerViewsCount) - 1;
            this.bgD = i3;
            this.bgE = i3;
        }
        boolean z = (this.bgD == i9 && this.bgE == i10 && this.bhj == f2) ? false : true;
        if (i3 != this.bgC) {
            if (this.bgJ != null) {
                this.bgJ.drag(this.bgC - headerViewsCount, i3 - headerViewsCount);
            }
            this.bgC = i3;
            return true;
        }
        return z;
    }

    public void removeItem(int i2) {
        this.bhs = false;
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
            this.bgN = Math.max(1, obtainStyledAttributes.getDimensionPixelSize(e.l.DragSort_collapsed_height, 1));
            this.bhl = obtainStyledAttributes.getBoolean(e.l.DragSort_track_drag_sort, false);
            if (this.bhl) {
                this.bhm = new e();
            }
            this.bgA = obtainStyledAttributes.getFloat(e.l.DragSort_float_alpha, this.bgA);
            this.bgB = this.bgA;
            this.bgM = obtainStyledAttributes.getBoolean(e.l.DragSort_drag_enabled, this.bgM);
            this.bhi = Math.max(0.0f, Math.min(1.0f, 1.0f - obtainStyledAttributes.getFloat(e.l.DragSort_slide_shuffle_speed, 0.75f)));
            this.bgF = this.bhi > 0.0f;
            setDragScrollStart(obtainStyledAttributes.getFloat(e.l.DragSort_drag_scroll_start, this.bgR));
            this.bgZ = obtainStyledAttributes.getFloat(e.l.DragSort_max_drag_scroll_speed, this.bgZ);
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
                bVar.cE(z);
                bVar.cD(z2);
                bVar.setBackgroundColor(color);
                this.bhf = bVar;
                a(bVar);
            }
            obtainStyledAttributes.recycle();
            i2 = i5;
            i3 = i4;
        }
        this.bgQ = new d();
        if (i3 > 0) {
            this.bhp = new k(0.5f, i3);
        }
        if (i2 > 0) {
            this.bhr = new f(0.5f, i2);
        }
        this.bhg = MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
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
        this.bhv = bVar;
        this.mListView.setOnTouchListener(bVar);
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void dispatchDraw(Canvas canvas) {
        float f2;
        this.bhu.dispatchDraw(canvas);
        if (this.mDragState != 0) {
            if (this.bgD != this.bgG) {
                b(this.bgD, canvas);
            }
            if (this.bgE != this.bgD && this.bgE != this.bgG) {
                b(this.bgE, canvas);
            }
        }
        if (this.bgv != null) {
            int width = this.bgv.getWidth();
            int height = this.bgv.getHeight();
            int i2 = this.bgw.x;
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
            int i3 = (int) (f2 * 255.0f * this.bgB);
            canvas.save();
            canvas.translate(this.bgw.x, this.bgw.y);
            canvas.clipRect(0, 0, width, height);
            canvas.saveLayerAlpha(0.0f, 0.0f, width, height, i3, 31);
            this.bgv.draw(canvas);
            canvas.restore();
            canvas.restore();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onDraw(Canvas canvas) {
        this.bhu.onDraw(canvas);
        if (this.bhl) {
            this.bhm.PJ();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.bhn) {
            this.bhn = false;
            return false;
        } else if (!this.bgM) {
            return this.bhu.onTouchEvent(motionEvent);
        } else {
            boolean z2 = this.bhd;
            this.bhd = false;
            if (!z2) {
                u(motionEvent);
            }
            if (this.mDragState == 4) {
                onDragTouchEvent(motionEvent);
                return true;
            }
            if (this.mDragState == 0 && this.bhu.onTouchEvent(motionEvent)) {
                z = true;
            }
            switch (motionEvent.getAction() & 255) {
                case 1:
                case 3:
                    PC();
                    return z;
                case 2:
                default:
                    if (z) {
                        this.bhh = 1;
                        return z;
                    }
                    return z;
            }
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (!this.bgM) {
            return this.bhu.onInterceptTouchEvent(motionEvent);
        }
        if (this.bhv != null) {
            this.bhv.PL().onTouchEvent(motionEvent);
        }
        u(motionEvent);
        this.bhd = true;
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            if (this.mDragState != 0) {
                this.bhn = true;
                return true;
            }
            this.bhe = true;
        }
        if (this.bgv == null) {
            if (this.bhu.onInterceptTouchEvent(motionEvent)) {
                this.bhw = true;
                z = true;
            } else {
                z = false;
            }
            switch (action) {
                case 1:
                case 3:
                    PC();
                    break;
                case 2:
                default:
                    if (z) {
                        this.bhh = 1;
                        break;
                    } else {
                        this.bhh = 2;
                        break;
                    }
            }
        } else {
            z = true;
        }
        if (action == 1 || action == 3) {
            this.bhe = false;
        }
        return z;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        this.bhu.onSizeChanged(i2, i3, i4, i5);
        PD();
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void requestLayout() {
        if (!this.mBlockLayoutRequests) {
            this.bhu.requestLayout();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onMeasure(int i2, int i3) {
        this.bhu.onMeasure(i2, i3);
        if (this.bgv != null) {
            if (this.bgv.isLayoutRequested()) {
                PF();
            }
            this.bgz = true;
        }
        this.mWidthMeasureSpec = i2;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void layoutChildren() {
        this.bhu.layoutChildren();
        if (this.bgv != null) {
            if (this.bgv.isLayoutRequested() && !this.bgz) {
                PF();
            }
            this.bgv.layout(0, 0, this.bgv.getMeasuredWidth(), this.bgv.getMeasuredHeight());
            this.bgz = false;
        }
    }

    public void removeItem(int i2, float f2) {
        if (this.mDragState == 0 || this.mDragState == 4) {
            if (this.mDragState == 0) {
                this.bgG = this.mListView.getHeaderViewsCount() + i2;
                this.bgD = this.bgG;
                this.bgE = this.bgG;
                this.bgC = this.bgG;
                View childAt = this.mListView.getChildAt(this.bgG - this.mListView.getFirstVisiblePosition());
                if (childAt != null) {
                    childAt.setVisibility(4);
                }
            }
            this.mDragState = 1;
            this.bht = f2;
            if (this.bhe) {
                switch (this.bhh) {
                    case 1:
                        this.bhu.onTouchEvent(this.bhg);
                        break;
                    case 2:
                        this.bhu.onInterceptTouchEvent(this.bhg);
                        break;
                }
            }
            if (this.bhp != null) {
                this.bhp.start();
            } else {
                fT(i2);
            }
        }
    }

    public void cancelDrag() {
        if (this.mDragState == 4) {
            this.bgQ.cC(true);
            PH();
            Py();
            PE();
            if (this.bhe) {
                this.mDragState = 3;
            } else {
                this.mDragState = 0;
            }
        }
    }

    private void Py() {
        this.bgG = -1;
        this.bgD = -1;
        this.bgE = -1;
        this.bgC = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pz() {
        this.mDragState = 2;
        if (this.bgK != null && this.bgC >= 0 && this.bgC < this.mListView.getCount()) {
            int headerViewsCount = this.mListView.getHeaderViewsCount();
            this.bgK.drop(this.bgG - headerViewsCount, this.bgC - headerViewsCount);
        }
        PH();
        PB();
        Py();
        PE();
        if (this.bhe) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PA() {
        fT(this.bgG - this.mListView.getHeaderViewsCount());
    }

    private void fT(int i2) {
        this.mDragState = 1;
        if (this.bgL != null) {
            this.bgL.remove(i2);
        }
        PH();
        PB();
        Py();
        if (this.bhe) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    private void PB() {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        if (this.bgG < firstVisiblePosition) {
            View childAt = this.mListView.getChildAt(0);
            this.mListView.setSelectionFromTop(firstVisiblePosition - 1, (childAt != null ? childAt.getTop() : 0) - this.mListView.getPaddingTop());
        }
    }

    public boolean stopDrag(boolean z) {
        this.bhs = false;
        return stopDrag(z, 0.0f);
    }

    public boolean stopDragWithVelocity(boolean z, float f2) {
        this.bhs = true;
        return stopDrag(z, f2);
    }

    public boolean stopDrag(boolean z, float f2) {
        if (this.bgv != null) {
            this.bgQ.cC(true);
            if (z) {
                removeItem(this.bgG - this.mListView.getHeaderViewsCount(), f2);
            } else if (this.bhr != null) {
                this.bhr.start();
            } else {
                Pz();
            }
            if (this.bhl) {
                this.bhm.on();
                return true;
            }
            return true;
        }
        return false;
    }

    private void PC() {
        this.bhh = 0;
        this.bhe = false;
        if (this.mDragState == 3) {
            this.mDragState = 0;
        }
        this.bgB = this.bgA;
        this.bhw = false;
        this.bho.clear();
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
        return this.bhw;
    }

    public void setDragScrollStart(float f2) {
        setDragScrollStarts(f2, f2);
    }

    public void setDragScrollStarts(float f2, float f3) {
        if (f3 > 0.5f) {
            this.bgS = 0.5f;
        } else {
            this.bgS = f3;
        }
        if (f2 > 0.5f) {
            this.bgR = 0.5f;
        } else {
            this.bgR = f2;
        }
        if (this.mListView.getHeight() != 0) {
            PD();
        }
    }

    private void P(int i2, int i3) {
        this.bgw.x = i2 - this.bgH;
        this.bgw.y = i3 - this.bgI;
        cB(true);
        int min = Math.min(i3, this.bgy + this.bgO);
        int max = Math.max(i3, this.bgy - this.bgO);
        int PI = this.bgQ.PI();
        if (min > this.mLastY && min > this.bgU && PI != 1) {
            if (PI != -1) {
                this.bgQ.cC(true);
            }
            this.bgQ.fV(1);
        } else if (max < this.mLastY && max < this.bgT && PI != 0) {
            if (PI != -1) {
                this.bgQ.cC(true);
            }
            this.bgQ.fV(0);
        } else if (max >= this.bgT && min <= this.bgU && this.bgQ.isScrolling()) {
            this.bgQ.cC(true);
        }
    }

    private void PD() {
        int height;
        int paddingTop = this.mListView.getPaddingTop();
        float height2 = (this.mListView.getHeight() - paddingTop) - this.mListView.getPaddingBottom();
        this.bgW = paddingTop + (this.bgR * height2);
        this.bgV = (height2 * (1.0f - this.bgS)) + paddingTop;
        this.bgT = (int) this.bgW;
        this.bgU = (int) this.bgV;
        this.bgX = this.bgW - paddingTop;
        this.bgY = (paddingTop + height) - this.bgV;
    }

    private void PE() {
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
        if (i2 != this.bgG && i2 != this.bgD && i2 != this.bgE) {
            g2 = -2;
        } else {
            g2 = g(i2, view, z);
        }
        if (g2 != layoutParams.height) {
            layoutParams.height = g2;
            view.setLayoutParams(layoutParams);
        }
        if (i2 == this.bgD || i2 == this.bgE) {
            if (i2 < this.bgG) {
                ((DragSortItemView) view).setGravity(80);
            } else if (i2 > this.bgG) {
                ((DragSortItemView) view).setGravity(48);
            }
        }
        int visibility = view.getVisibility();
        int i3 = 0;
        if (i2 == this.bgG && this.bgv != null) {
            i3 = 4;
        }
        if (i3 != visibility) {
            view.setVisibility(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int fU(int i2) {
        View view;
        if (i2 == this.bgG) {
            return 0;
        }
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        if (childAt != null) {
            return f(i2, childAt, false);
        }
        int i3 = this.bho.get(i2);
        if (i3 == -1) {
            ListAdapter adapter = this.mListView.getAdapter();
            int itemViewType = adapter.getItemViewType(i2);
            int viewTypeCount = adapter.getViewTypeCount();
            if (viewTypeCount != this.bgP.length) {
                this.bgP = new View[viewTypeCount];
            }
            if (itemViewType >= 0) {
                if (this.bgP[itemViewType] == null) {
                    view = adapter.getView(i2, null, this.mListView);
                    this.bgP[itemViewType] = view;
                } else {
                    view = adapter.getView(i2, this.bgP[itemViewType], this.mListView);
                }
            } else {
                view = adapter.getView(i2, null, this.mListView);
            }
            int f2 = f(i2, view, true);
            this.bho.add(i2, f2);
            return f2;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(int i2, View view, boolean z) {
        if (i2 == this.bgG) {
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
        boolean z = this.bgF && this.bgD != this.bgE;
        int i4 = this.mFloatViewHeight - this.bgN;
        int i5 = (int) (this.bhj * i4);
        if (i2 == this.bgG) {
            if (this.bgG == this.bgD) {
                if (z) {
                    return i5 + this.bgN;
                }
                return this.mFloatViewHeight;
            } else if (this.bgG == this.bgE) {
                return this.mFloatViewHeight - i5;
            } else {
                return this.bgN;
            }
        } else if (i2 == this.bgD) {
            if (z) {
                return i3 + i5;
            }
            return i3 + i4;
        } else if (i2 == this.bgE) {
            return (i3 + i4) - i5;
        } else {
            return i3;
        }
    }

    private int b(int i2, View view, int i3, int i4) {
        int i5;
        int i6;
        int fU = fU(i2);
        int height = view.getHeight();
        int Q = Q(i2, fU);
        if (i2 != this.bgG) {
            i6 = height - fU;
            i5 = Q - fU;
        } else {
            i5 = Q;
            i6 = height;
        }
        int i7 = this.mFloatViewHeight;
        if (this.bgG != this.bgD && this.bgG != this.bgE) {
            i7 -= this.bgN;
        }
        if (i2 <= i3) {
            if (i2 > this.bgD) {
                return (i7 - i5) + 0;
            }
        } else if (i2 == i4) {
            if (i2 <= this.bgD) {
                return (i6 - i7) + 0;
            }
            if (i2 == this.bgE) {
                return (height - Q) + 0;
            }
            return 0 + i6;
        } else if (i2 <= this.bgD) {
            return 0 - i7;
        } else {
            if (i2 == this.bgE) {
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

    private void PF() {
        if (this.bgv != null) {
            measureItem(this.bgv);
            this.mFloatViewHeight = this.bgv.getMeasuredHeight();
            this.bgO = this.mFloatViewHeight / 2;
        }
    }

    protected boolean onDragTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        switch (motionEvent.getAction() & 255) {
            case 1:
                if (this.mDragState == 4) {
                    stopDrag(false);
                }
                PC();
                return true;
            case 2:
                P((int) motionEvent.getX(), (int) motionEvent.getY());
                return true;
            case 3:
                if (this.mDragState == 4) {
                    cancelDrag();
                }
                PC();
                return true;
            default:
                return true;
        }
    }

    public boolean startDrag(int i2, int i3, int i4, int i5) {
        View fW;
        if (!this.bhe || this.bhf == null || (fW = this.bhf.fW(i2)) == null) {
            return false;
        }
        return startDrag(i2, fW, i3, i4, i5);
    }

    public boolean startDrag(int i2, View view, int i3, int i4, int i5) {
        if (this.mDragState == 0 && this.bhe && this.bgv == null && view != null && this.bgM) {
            if (this.mListView.getParent() != null) {
                this.mListView.getParent().requestDisallowInterceptTouchEvent(true);
            }
            int headerViewsCount = this.mListView.getHeaderViewsCount() + i2;
            this.bgD = headerViewsCount;
            this.bgE = headerViewsCount;
            this.bgG = headerViewsCount;
            this.bgC = headerViewsCount;
            this.mDragState = 4;
            this.bhc = 0;
            this.bhc |= i3;
            this.bgv = view;
            PF();
            this.bgH = i4;
            this.bgI = i5;
            this.bhb = this.mY;
            this.bgw.x = this.mX - this.bgH;
            this.bgw.y = this.mY - this.bgI;
            View childAt = this.mListView.getChildAt(this.bgG - this.mListView.getFirstVisiblePosition());
            if (childAt != null) {
                childAt.setVisibility(4);
            }
            if (this.bhl) {
                this.bhm.startTracking();
            }
            switch (this.bhh) {
                case 1:
                    this.bhu.onTouchEvent(this.bhg);
                    break;
                case 2:
                    this.bhu.onInterceptTouchEvent(this.bhg);
                    break;
            }
            this.mListView.requestLayout();
            if (this.bhq != null) {
                this.bhq.start();
                return true;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cB(boolean z) {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition() + (this.mListView.getChildCount() / 2);
        View childAt = this.mListView.getChildAt(this.mListView.getChildCount() / 2);
        if (childAt != null) {
            h(firstVisiblePosition, childAt, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i2, View view, boolean z) {
        this.mBlockLayoutRequests = true;
        PG();
        int i3 = this.bgD;
        int i4 = this.bgE;
        boolean Px = Px();
        if (Px) {
            PE();
            this.mListView.setSelectionFromTop(i2, (b(i2, view, i3, i4) + view.getTop()) - this.mListView.getPaddingTop());
            layoutChildren();
        }
        if (Px || z) {
            this.mListView.invalidate();
        }
        this.mBlockLayoutRequests = false;
    }

    private void PG() {
        if (this.bhf != null) {
            this.bgx.set(this.mX, this.mY);
            this.bhf.b(this.bgv, this.bgw, this.bgx);
        }
        int i2 = this.bgw.x;
        int i3 = this.bgw.y;
        int paddingLeft = this.mListView.getPaddingLeft();
        if ((this.bhc & 1) == 0 && i2 > paddingLeft) {
            this.bgw.x = paddingLeft;
        } else if ((this.bhc & 2) == 0 && i2 < paddingLeft) {
            this.bgw.x = paddingLeft;
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int lastVisiblePosition = this.mListView.getLastVisiblePosition();
        int paddingTop = this.mListView.getPaddingTop();
        if (firstVisiblePosition < headerViewsCount) {
            paddingTop = this.mListView.getChildAt((headerViewsCount - firstVisiblePosition) - 1).getBottom();
        }
        if ((this.bhc & 8) == 0 && firstVisiblePosition <= this.bgG) {
            paddingTop = Math.max(this.mListView.getChildAt(this.bgG - firstVisiblePosition).getTop(), paddingTop);
        }
        int height = this.mListView.getHeight() - this.mListView.getPaddingBottom();
        if (lastVisiblePosition >= (this.mListView.getCount() - footerViewsCount) - 1) {
            height = this.mListView.getChildAt(((this.mListView.getCount() - footerViewsCount) - 1) - firstVisiblePosition).getBottom();
        }
        if ((this.bhc & 4) == 0 && lastVisiblePosition >= this.bgG) {
            height = Math.min(this.mListView.getChildAt(this.bgG - firstVisiblePosition).getBottom(), height);
        }
        if (i3 < paddingTop) {
            this.bgw.y = paddingTop;
        } else if (this.mFloatViewHeight + i3 > height) {
            this.bgw.y = height - this.mFloatViewHeight;
        }
        this.bgy = this.bgw.y + this.bgO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PH() {
        if (this.bgv != null) {
            this.bgv.setVisibility(8);
            if (this.bhf != null) {
                this.bhf.ag(this.bgv);
            }
            this.bgv = null;
            this.mListView.invalidate();
        }
    }

    public void a(h hVar) {
        this.bhf = hVar;
    }

    public void a(b bVar) {
        this.bgJ = bVar;
    }

    public void setDragEnabled(boolean z) {
        this.bgM = z;
    }

    public boolean isDragEnabled() {
        return this.bgM;
    }

    public void a(g gVar) {
        this.bgK = gVar;
    }

    public void a(l lVar) {
        this.bgL = lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class i {
        private SparseIntArray bhP;
        private ArrayList<Integer> bhQ;
        private int mMaxSize;

        public i(int i) {
            this.bhP = new SparseIntArray(i);
            this.bhQ = new ArrayList<>(i);
            this.mMaxSize = i;
        }

        public void add(int i, int i2) {
            int i3 = this.bhP.get(i, -1);
            if (i3 != i2) {
                if (i3 == -1) {
                    if (this.bhP.size() == this.mMaxSize) {
                        this.bhP.delete(this.bhQ.remove(0).intValue());
                    }
                } else {
                    this.bhQ.remove(Integer.valueOf(i));
                }
                this.bhP.put(i, i2);
                this.bhQ.add(Integer.valueOf(i));
            }
        }

        public int get(int i) {
            return this.bhP.get(i, -1);
        }

        public void clear() {
            this.bhP.clear();
            this.bhQ.clear();
        }
    }

    /* renamed from: com.baidu.tbadk.widget.dragsort.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0143a extends BaseAdapter {
        private ListAdapter mAdapter;

        public C0143a(ListAdapter listAdapter) {
            this.mAdapter = listAdapter;
            this.mAdapter.registerDataSetObserver(new DataSetObserver() { // from class: com.baidu.tbadk.widget.dragsort.a.a.1
                @Override // android.database.DataSetObserver
                public void onChanged() {
                    C0143a.this.notifyDataSetChanged();
                }

                @Override // android.database.DataSetObserver
                public void onInvalidated() {
                    C0143a.this.notifyDataSetInvalidated();
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
        private float bia;
        private float mA;
        private float mAlpha;
        private float mB;
        private float mC;
        private boolean mCanceled;
        private float mD;
        protected long mStartTime;

        public m(float f, int i) {
            this.mAlpha = f;
            this.bia = i;
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

        public void n(float f, float f2) {
        }

        public void onStop() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.mCanceled) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / this.bia;
                if (uptimeMillis >= 1.0f) {
                    n(1.0f, 1.0f);
                    onStop();
                    return;
                }
                n(uptimeMillis, ab(uptimeMillis));
                a.this.mListView.post(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class f extends m {
        private int bhL;
        private int bhM;
        private float bhN;
        private float bhO;

        public f(float f, int i) {
            super(f, i);
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.bhL = a.this.bgC;
            this.bhM = a.this.bgG;
            a.this.mDragState = 2;
            this.bhN = a.this.bgw.y - PK();
            this.bhO = a.this.bgw.x - a.this.mListView.getPaddingLeft();
        }

        private int PK() {
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            int dividerHeight = (a.this.bgN + a.this.mListView.getDividerHeight()) / 2;
            View childAt = a.this.mListView.getChildAt(this.bhL - firstVisiblePosition);
            if (childAt != null) {
                if (this.bhL == this.bhM) {
                    return childAt.getTop();
                }
                if (this.bhL >= this.bhM) {
                    return (childAt.getBottom() + dividerHeight) - a.this.mFloatViewHeight;
                }
                return childAt.getTop() - dividerHeight;
            }
            cancel();
            return -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void n(float f, float f2) {
            int PK = PK();
            float paddingLeft = a.this.bgw.x - a.this.mListView.getPaddingLeft();
            float f3 = 1.0f - f2;
            if (f3 < Math.abs((a.this.bgw.y - PK) / this.bhN) || f3 < Math.abs(paddingLeft / this.bhO)) {
                a.this.bgw.y = PK + ((int) (this.bhN * f3));
                a.this.bgw.x = a.this.mListView.getPaddingLeft() + ((int) (this.bhO * f3));
                a.this.cB(true);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.Pz();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class k extends m {
        private int bhM;
        private float bhT;
        private float bhU;
        private float bhV;
        private int bhW;
        private int bhX;
        private int bhY;
        private int bhZ;

        public k(float f, int i) {
            super(f, i);
            this.bhW = -1;
            this.bhX = -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.bhW = -1;
            this.bhX = -1;
            this.bhY = a.this.bgD;
            this.bhZ = a.this.bgE;
            this.bhM = a.this.bgG;
            a.this.mDragState = 1;
            this.bhT = a.this.bgw.x;
            if (a.this.bhs) {
                float width = a.this.mListView.getWidth() * 2.0f;
                if (a.this.bht == 0.0f) {
                    a.this.bht = (this.bhT >= 0.0f ? 1 : -1) * width;
                    return;
                }
                float f = width * 2.0f;
                if (a.this.bht >= 0.0f || a.this.bht <= (-f)) {
                    if (a.this.bht > 0.0f && a.this.bht < f) {
                        a.this.bht = f;
                        return;
                    }
                    return;
                }
                a.this.bht = -f;
                return;
            }
            a.this.PH();
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void n(float f, float f2) {
            View childAt;
            float f3 = 1.0f - f2;
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            View childAt2 = a.this.mListView.getChildAt(this.bhY - firstVisiblePosition);
            if (a.this.bhs) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / 1000.0f;
                if (uptimeMillis != 0.0f) {
                    float f4 = a.this.bht * uptimeMillis;
                    int width = a.this.mListView.getWidth();
                    a.this.bht = ((a.this.bht > 0.0f ? 1 : -1) * uptimeMillis * width) + a.this.bht;
                    this.bhT += f4;
                    a.this.bgw.x = (int) this.bhT;
                    if (this.bhT < width && this.bhT > (-width)) {
                        this.mStartTime = SystemClock.uptimeMillis();
                        a.this.cB(true);
                        return;
                    }
                } else {
                    return;
                }
            }
            if (childAt2 != null) {
                if (this.bhW == -1) {
                    this.bhW = a.this.f(this.bhY, childAt2, false);
                    this.bhU = childAt2.getHeight() - this.bhW;
                }
                int max = Math.max((int) (this.bhU * f3), 1);
                ViewGroup.LayoutParams layoutParams = childAt2.getLayoutParams();
                layoutParams.height = max + this.bhW;
                childAt2.setLayoutParams(layoutParams);
            }
            if (this.bhZ != this.bhY && (childAt = a.this.mListView.getChildAt(this.bhZ - firstVisiblePosition)) != null) {
                if (this.bhX == -1) {
                    this.bhX = a.this.f(this.bhZ, childAt, false);
                    this.bhV = childAt.getHeight() - this.bhX;
                }
                int max2 = Math.max((int) (this.bhV * f3), 1);
                ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
                layoutParams2.height = max2 + this.bhX;
                childAt.setLayoutParams(layoutParams2);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.PA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class j extends m {
        private float bhR;
        private float bhS;
        final /* synthetic */ a bhy;

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.bhR = this.bhy.bgI;
            this.bhS = this.bhy.bgO;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void n(float f, float f2) {
            if (this.bhy.mDragState != 4) {
                cancel();
                return;
            }
            this.bhy.bgI = (int) ((this.bhS * f2) + ((1.0f - f2) * this.bhR));
            this.bhy.bgw.y = this.bhy.mY - this.bhy.bgI;
            this.bhy.cB(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e {
        StringBuilder mBuilder = new StringBuilder();
        private int bhI = 0;
        private int bhJ = 0;
        private boolean bhK = false;
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
            this.bhJ = 0;
            this.bhK = true;
        }

        public void PJ() {
            if (this.bhK) {
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
                this.mBuilder.append("    <FirstExpPos>").append(a.this.bgD).append("</FirstExpPos>\n");
                this.mBuilder.append("    <FirstExpBlankHeight>").append(a.this.fS(a.this.bgD) - a.this.fU(a.this.bgD)).append("</FirstExpBlankHeight>\n");
                this.mBuilder.append("    <SecondExpPos>").append(a.this.bgE).append("</SecondExpPos>\n");
                this.mBuilder.append("    <SecondExpBlankHeight>").append(a.this.fS(a.this.bgE) - a.this.fU(a.this.bgE)).append("</SecondExpBlankHeight>\n");
                this.mBuilder.append("    <SrcPos>").append(a.this.bgG).append("</SrcPos>\n");
                this.mBuilder.append("    <SrcHeight>").append(a.this.mFloatViewHeight + a.this.mListView.getDividerHeight()).append("</SrcHeight>\n");
                this.mBuilder.append("    <ViewHeight>").append(a.this.mListView.getHeight()).append("</ViewHeight>\n");
                this.mBuilder.append("    <LastY>").append(a.this.mLastY).append("</LastY>\n");
                this.mBuilder.append("    <FloatY>").append(a.this.bgy).append("</FloatY>\n");
                this.mBuilder.append("    <ShuffleEdges>");
                for (int i4 = 0; i4 < childCount; i4++) {
                    this.mBuilder.append(a.this.O(firstVisiblePosition + i4, a.this.mListView.getChildAt(i4).getTop())).append(",");
                }
                this.mBuilder.append("</ShuffleEdges>\n");
                this.mBuilder.append("</DSLVState>\n");
                this.bhI++;
                if (this.bhI > 1000) {
                    flush();
                    this.bhI = 0;
                }
            }
        }

        public void flush() {
            if (this.bhK) {
                try {
                    FileWriter fileWriter = new FileWriter(this.mFile, this.bhJ != 0);
                    fileWriter.write(this.mBuilder.toString());
                    this.mBuilder.delete(0, this.mBuilder.length());
                    fileWriter.flush();
                    fileWriter.close();
                    this.bhJ++;
                } catch (IOException e) {
                }
            }
        }

        public void on() {
            if (this.bhK) {
                this.mBuilder.append("</DSLVStates>\n");
                flush();
                this.bhK = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements Runnable {
        private boolean bhB;
        private long bhC;
        private long bhD;
        private float bhE;
        private long bhF;
        private int bhG;
        private float bhH;
        private int dy;
        private boolean mScrolling = false;

        public boolean isScrolling() {
            return this.mScrolling;
        }

        public int PI() {
            if (this.mScrolling) {
                return this.bhG;
            }
            return -1;
        }

        public d() {
        }

        public void fV(int i) {
            if (!this.mScrolling) {
                this.bhB = false;
                this.mScrolling = true;
                this.bhF = SystemClock.uptimeMillis();
                this.bhC = this.bhF;
                this.bhG = i;
                a.this.mListView.post(this);
            }
        }

        public void cC(boolean z) {
            if (z) {
                a.this.mListView.removeCallbacks(this);
                this.mScrolling = false;
                return;
            }
            this.bhB = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.bhB) {
                int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
                int lastVisiblePosition = a.this.mListView.getLastVisiblePosition();
                int count = a.this.mListView.getCount();
                int paddingTop = a.this.mListView.getPaddingTop();
                int height = (a.this.mListView.getHeight() - paddingTop) - a.this.mListView.getPaddingBottom();
                int min = Math.min(a.this.mY, a.this.bgy + a.this.bgO);
                int max = Math.max(a.this.mY, a.this.bgy - a.this.bgO);
                if (this.bhG == 0) {
                    View childAt = a.this.mListView.getChildAt(0);
                    if (childAt == null) {
                        this.mScrolling = false;
                        return;
                    } else if (firstVisiblePosition == 0 && childAt.getTop() == paddingTop) {
                        this.mScrolling = false;
                        return;
                    } else {
                        this.bhH = a.this.bha.b((a.this.bgW - max) / a.this.bgX, this.bhC);
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
                        this.bhH = -a.this.bha.b((min - a.this.bgV) / a.this.bgY, this.bhC);
                    }
                }
                this.bhD = SystemClock.uptimeMillis();
                this.bhE = (float) (this.bhD - this.bhC);
                this.dy = Math.round(this.bhH * this.bhE);
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
                this.bhC = this.bhD;
                a.this.mListView.post(this);
                return;
            }
            this.mScrolling = false;
        }
    }
}
