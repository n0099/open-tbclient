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
import com.baidu.tieba.c;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a implements com.baidu.tbadk.widget.dragsort.c {
    private int aIS;
    private int alR;
    private int alS;
    private int amy;
    private int amz;
    private int cEB;
    private d cED;
    private int cEG;
    private int cEH;
    private float cEI;
    private float cEJ;
    private float cEK;
    private float cEL;
    private int cEO;
    private MotionEvent cET;
    private C0260a cEX;
    private e cEZ;
    private View cEi;
    private int cEl;
    private int cEp;
    private int cEq;
    private int cEr;
    private int cEt;
    private int cEu;
    private int cEv;
    private b cEw;
    private g cEx;
    private l cEy;
    private k cFc;
    private j cFd;
    private f cFe;
    private boolean cFf;
    private com.baidu.tbadk.widget.dragsort.d cFh;
    private com.baidu.tbadk.widget.dragsort.b cFi;
    private int mLastX;
    private int mLastY;
    private ListView mListView;
    private DataSetObserver mObserver;
    private Point cEj = new Point();
    private Point cEk = new Point();
    private boolean cEm = false;
    private float cEn = 1.0f;
    private float cEo = 1.0f;
    private boolean cEs = false;
    private boolean cEz = true;
    private int mDragState = 0;
    private int cEA = 1;
    private int mWidthMeasureSpec = 0;
    private View[] cEC = new View[1];
    private float cEE = 0.33333334f;
    private float cEF = 0.33333334f;
    private float cEM = 0.5f;
    private c cEN = new c() { // from class: com.baidu.tbadk.widget.dragsort.a.1
        @Override // com.baidu.tbadk.widget.dragsort.a.c
        public float b(float f2, long j2) {
            return a.this.cEM * f2;
        }
    };
    private int cEP = 0;
    private boolean cEQ = false;
    private boolean cER = false;
    private h cES = null;
    private int cEU = 0;
    private float cEV = 0.25f;
    private float cEW = 0.0f;
    private boolean cEY = false;
    private boolean mBlockLayoutRequests = false;
    private boolean cFa = false;
    private i cFb = new i(3);
    private float cFg = 0.0f;
    private boolean cFj = false;
    private boolean cFk = false;

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

        void bg(View view);

        View lb(int i);
    }

    /* loaded from: classes.dex */
    public interface l {
        void remove(int i);
    }

    public a(ListView listView, com.baidu.tbadk.widget.dragsort.d dVar) {
        this.cFh = dVar;
        this.mListView = listView;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            this.cEX = new C0260a(listAdapter);
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
            this.cEX = null;
        }
        this.cFh.setAdapter(this.cEX);
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
            if (i2 > this.cEt) {
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
    public int kX(int i2) {
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        return childAt != null ? childAt.getHeight() : an(i2, kZ(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int al(int i2, int i3) {
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        if (i2 <= headerViewsCount || i2 >= this.mListView.getCount() - footerViewsCount) {
            return i3;
        }
        int dividerHeight = this.mListView.getDividerHeight();
        int i4 = this.aIS - this.cEA;
        int kZ = kZ(i2);
        int kX = kX(i2);
        if (this.cEr <= this.cEt) {
            if (i2 == this.cEr && this.cEq != this.cEr) {
                if (i2 == this.cEt) {
                    i3 = (i3 + kX) - this.aIS;
                } else {
                    i3 = ((kX - kZ) + i3) - i4;
                }
            } else if (i2 > this.cEr && i2 <= this.cEt) {
                i3 -= i4;
            }
        } else if (i2 > this.cEt && i2 <= this.cEq) {
            i3 += i4;
        } else if (i2 == this.cEr && this.cEq != this.cEr) {
            i3 += kX - kZ;
        }
        if (i2 <= this.cEt) {
            return (((this.aIS - dividerHeight) - kZ(i2 - 1)) / 2) + i3;
        }
        return (((kZ - dividerHeight) - this.aIS) / 2) + i3;
    }

    private boolean awg() {
        int i2;
        int i3;
        int i4;
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int i5 = this.cEq;
        View childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        if (childAt == null) {
            i5 = firstVisiblePosition + (this.mListView.getChildCount() / 2);
            childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        }
        int top = childAt.getTop();
        int height = childAt.getHeight();
        int al = al(i5, top);
        int dividerHeight = this.mListView.getDividerHeight();
        if (this.cEl >= al) {
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
                    i6 = kX(i3 + 1);
                    i2 = al(i3 + 1, i7);
                    if (this.cEl < i2) {
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
                int kX = kX(i3);
                if (i3 == 0) {
                    i2 = (i8 - dividerHeight) - kX;
                    break;
                }
                i8 -= kX + dividerHeight;
                i2 = al(i3, i8);
                if (this.cEl >= i2) {
                    break;
                }
                i4 = i2;
            }
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int i9 = this.cEq;
        int i10 = this.cEr;
        float f2 = this.cEW;
        if (this.cEs) {
            int abs = Math.abs(i2 - i4);
            if (this.cEl >= i2) {
                int i11 = i4;
                i4 = i2;
                i2 = i11;
            }
            int i12 = (int) (abs * this.cEV * 0.5f);
            float f3 = i12;
            int i13 = i4 + i12;
            int i14 = i2 - i12;
            if (this.cEl < i13) {
                this.cEq = i3 - 1;
                this.cEr = i3;
                this.cEW = ((i13 - this.cEl) * 0.5f) / f3;
            } else if (this.cEl < i14) {
                this.cEq = i3;
                this.cEr = i3;
            } else {
                this.cEq = i3;
                this.cEr = i3 + 1;
                this.cEW = (1.0f + ((i2 - this.cEl) / f3)) * 0.5f;
            }
        } else {
            this.cEq = i3;
            this.cEr = i3;
        }
        if (this.cEq < headerViewsCount) {
            this.cEq = headerViewsCount;
            this.cEr = headerViewsCount;
            i3 = headerViewsCount;
        } else if (this.cEr >= this.mListView.getCount() - footerViewsCount) {
            i3 = (this.mListView.getCount() - footerViewsCount) - 1;
            this.cEq = i3;
            this.cEr = i3;
        }
        boolean z = (this.cEq == i9 && this.cEr == i10 && this.cEW == f2) ? false : true;
        if (i3 != this.cEp) {
            if (this.cEw != null) {
                this.cEw.drag(this.cEp - headerViewsCount, i3 - headerViewsCount);
            }
            this.cEp = i3;
            return true;
        }
        return z;
    }

    public void removeItem(int i2) {
        this.cFf = false;
        removeItem(i2, 0.0f);
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void a(ListView listView, Context context, AttributeSet attributeSet) {
        int i2;
        int i3 = BaseActivity.SHOW_SOFT_KEYBOARD_DELAY;
        if (attributeSet == null) {
            i2 = 150;
        } else {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.a.DragSort, 0, 0);
            this.cEA = Math.max(1, obtainStyledAttributes.getDimensionPixelSize(13, 1));
            this.cEY = obtainStyledAttributes.getBoolean(7, false);
            if (this.cEY) {
                this.cEZ = new e();
            }
            this.cEn = obtainStyledAttributes.getFloat(11, this.cEn);
            this.cEo = this.cEn;
            this.cEz = obtainStyledAttributes.getBoolean(14, this.cEz);
            this.cEV = Math.max(0.0f, Math.min(1.0f, 1.0f - obtainStyledAttributes.getFloat(1, 0.75f)));
            this.cEs = this.cEV > 0.0f;
            setDragScrollStart(obtainStyledAttributes.getFloat(15, this.cEE));
            this.cEM = obtainStyledAttributes.getFloat(0, this.cEM);
            int i4 = obtainStyledAttributes.getInt(12, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
            int i5 = obtainStyledAttributes.getInt(16, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
            if (obtainStyledAttributes.getBoolean(17, true)) {
                boolean z = obtainStyledAttributes.getBoolean(8, false);
                int i6 = obtainStyledAttributes.getInt(5, 1);
                boolean z2 = obtainStyledAttributes.getBoolean(2, true);
                int resourceId = obtainStyledAttributes.getResourceId(9, 0);
                int resourceId2 = obtainStyledAttributes.getResourceId(10, 0);
                int resourceId3 = obtainStyledAttributes.getResourceId(4, 0);
                int color = obtainStyledAttributes.getColor(6, ViewCompat.MEASURED_STATE_MASK);
                com.baidu.tbadk.widget.dragsort.b bVar = new com.baidu.tbadk.widget.dragsort.b(this, listView, resourceId, 2, i6, resourceId3, resourceId2);
                bVar.fM(z);
                bVar.fL(z2);
                bVar.setBackgroundColor(color);
                this.cES = bVar;
                a(bVar);
            }
            obtainStyledAttributes.recycle();
            i2 = i5;
            i3 = i4;
        }
        this.cED = new d();
        if (i3 > 0) {
            this.cFc = new k(0.5f, i3);
        }
        if (i2 > 0) {
            this.cFe = new f(0.5f, i2);
        }
        this.cET = MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
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
        this.cFi = bVar;
        this.mListView.setOnTouchListener(bVar);
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void dispatchDraw(Canvas canvas) {
        float f2;
        this.cFh.dispatchDraw(canvas);
        if (this.mDragState != 0) {
            if (this.cEq != this.cEt) {
                b(this.cEq, canvas);
            }
            if (this.cEr != this.cEq && this.cEr != this.cEt) {
                b(this.cEr, canvas);
            }
        }
        if (this.cEi != null) {
            int width = this.cEi.getWidth();
            int height = this.cEi.getHeight();
            int i2 = this.cEj.x;
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
            int i3 = (int) (f2 * 255.0f * this.cEo);
            canvas.save();
            canvas.translate(this.cEj.x, this.cEj.y);
            canvas.clipRect(0, 0, width, height);
            canvas.saveLayerAlpha(0.0f, 0.0f, width, height, i3, 31);
            this.cEi.draw(canvas);
            canvas.restore();
            canvas.restore();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onDraw(Canvas canvas) {
        this.cFh.onDraw(canvas);
        if (this.cEY) {
            this.cEZ.awt();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.cFa) {
            this.cFa = false;
            return false;
        } else if (!this.cEz) {
            return this.cFh.onTouchEvent(motionEvent);
        } else {
            boolean z2 = this.cEQ;
            this.cEQ = false;
            if (!z2) {
                y(motionEvent);
            }
            if (this.mDragState == 4) {
                onDragTouchEvent(motionEvent);
                return true;
            }
            if (this.mDragState == 0 && this.cFh.onTouchEvent(motionEvent)) {
                z = true;
            }
            switch (motionEvent.getAction() & 255) {
                case 1:
                case 3:
                    awl();
                    return z;
                case 2:
                default:
                    if (z) {
                        this.cEU = 1;
                        return z;
                    }
                    return z;
            }
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (!this.cEz) {
            return this.cFh.onInterceptTouchEvent(motionEvent);
        }
        if (this.cFi != null) {
            this.cFi.awv().onTouchEvent(motionEvent);
        }
        y(motionEvent);
        this.cEQ = true;
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            if (this.mDragState != 0) {
                this.cFa = true;
                return true;
            }
            this.cER = true;
        }
        if (this.cEi == null) {
            if (this.cFh.onInterceptTouchEvent(motionEvent)) {
                this.cFj = true;
                z = true;
            } else {
                z = false;
            }
            switch (action) {
                case 1:
                case 3:
                    awl();
                    break;
                case 2:
                default:
                    if (z) {
                        this.cEU = 1;
                        break;
                    } else {
                        this.cEU = 2;
                        break;
                    }
            }
        } else {
            z = true;
        }
        if (action == 1 || action == 3) {
            this.cER = false;
        }
        return z;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        this.cFh.onSizeChanged(i2, i3, i4, i5);
        awm();
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void requestLayout() {
        if (!this.mBlockLayoutRequests) {
            this.cFh.requestLayout();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onMeasure(int i2, int i3) {
        this.cFh.onMeasure(i2, i3);
        if (this.cEi != null) {
            if (this.cEi.isLayoutRequested()) {
                awo();
            }
            this.cEm = true;
        }
        this.mWidthMeasureSpec = i2;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void layoutChildren() {
        this.cFh.layoutChildren();
        if (this.cEi != null) {
            if (this.cEi.isLayoutRequested() && !this.cEm) {
                awo();
            }
            this.cEi.layout(0, 0, this.cEi.getMeasuredWidth(), this.cEi.getMeasuredHeight());
            this.cEm = false;
        }
    }

    public void removeItem(int i2, float f2) {
        if (this.mDragState == 0 || this.mDragState == 4) {
            if (this.mDragState == 0) {
                this.cEt = this.mListView.getHeaderViewsCount() + i2;
                this.cEq = this.cEt;
                this.cEr = this.cEt;
                this.cEp = this.cEt;
                View childAt = this.mListView.getChildAt(this.cEt - this.mListView.getFirstVisiblePosition());
                if (childAt != null) {
                    childAt.setVisibility(4);
                }
            }
            this.mDragState = 1;
            this.cFg = f2;
            if (this.cER) {
                switch (this.cEU) {
                    case 1:
                        this.cFh.onTouchEvent(this.cET);
                        break;
                    case 2:
                        this.cFh.onInterceptTouchEvent(this.cET);
                        break;
                }
            }
            if (this.cFc != null) {
                this.cFc.start();
            } else {
                kY(i2);
            }
        }
    }

    public void cancelDrag() {
        if (this.mDragState == 4) {
            this.cED.fK(true);
            awq();
            awh();
            awn();
            if (this.cER) {
                this.mDragState = 3;
            } else {
                this.mDragState = 0;
            }
        }
    }

    private void awh() {
        this.cEt = -1;
        this.cEq = -1;
        this.cEr = -1;
        this.cEp = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awi() {
        this.mDragState = 2;
        if (this.cEx != null && this.cEp >= 0 && this.cEp < this.mListView.getCount()) {
            int headerViewsCount = this.mListView.getHeaderViewsCount();
            this.cEx.drop(this.cEt - headerViewsCount, this.cEp - headerViewsCount);
        }
        awq();
        awk();
        awh();
        awn();
        if (this.cER) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awj() {
        kY(this.cEt - this.mListView.getHeaderViewsCount());
    }

    private void kY(int i2) {
        this.mDragState = 1;
        if (this.cEy != null) {
            this.cEy.remove(i2);
        }
        awq();
        awk();
        awh();
        if (this.cER) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    private void awk() {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        if (this.cEt < firstVisiblePosition) {
            View childAt = this.mListView.getChildAt(0);
            this.mListView.setSelectionFromTop(firstVisiblePosition - 1, (childAt != null ? childAt.getTop() : 0) - this.mListView.getPaddingTop());
        }
    }

    public boolean stopDrag(boolean z) {
        this.cFf = false;
        return stopDrag(z, 0.0f);
    }

    public boolean stopDragWithVelocity(boolean z, float f2) {
        this.cFf = true;
        return stopDrag(z, f2);
    }

    public boolean stopDrag(boolean z, float f2) {
        if (this.cEi != null) {
            this.cED.fK(true);
            if (z) {
                removeItem(this.cEt - this.mListView.getHeaderViewsCount(), f2);
            } else if (this.cFe != null) {
                this.cFe.start();
            } else {
                awi();
            }
            if (this.cEY) {
                this.cEZ.nn();
                return true;
            }
            return true;
        }
        return false;
    }

    private void awl() {
        this.cEU = 0;
        this.cER = false;
        if (this.mDragState == 3) {
            this.mDragState = 0;
        }
        this.cEo = this.cEn;
        this.cFj = false;
        this.cFb.clear();
    }

    private void y(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            this.mLastX = this.alR;
            this.mLastY = this.alS;
        }
        this.alR = (int) motionEvent.getX();
        this.alS = (int) motionEvent.getY();
        if (action == 0) {
            this.mLastX = this.alR;
            this.mLastY = this.alS;
        }
        this.amy = ((int) motionEvent.getRawX()) - this.alR;
        this.amz = ((int) motionEvent.getRawY()) - this.alS;
    }

    public boolean listViewIntercepted() {
        return this.cFj;
    }

    public void setDragScrollStart(float f2) {
        setDragScrollStarts(f2, f2);
    }

    public void setDragScrollStarts(float f2, float f3) {
        if (f3 > 0.5f) {
            this.cEF = 0.5f;
        } else {
            this.cEF = f3;
        }
        if (f2 > 0.5f) {
            this.cEE = 0.5f;
        } else {
            this.cEE = f2;
        }
        if (this.mListView.getHeight() != 0) {
            awm();
        }
    }

    private void am(int i2, int i3) {
        this.cEj.x = i2 - this.cEu;
        this.cEj.y = i3 - this.cEv;
        fJ(true);
        int min = Math.min(i3, this.cEl + this.cEB);
        int max = Math.max(i3, this.cEl - this.cEB);
        int aws = this.cED.aws();
        if (min > this.mLastY && min > this.cEH && aws != 1) {
            if (aws != -1) {
                this.cED.fK(true);
            }
            this.cED.la(1);
        } else if (max < this.mLastY && max < this.cEG && aws != 0) {
            if (aws != -1) {
                this.cED.fK(true);
            }
            this.cED.la(0);
        } else if (max >= this.cEG && min <= this.cEH && this.cED.awr()) {
            this.cED.fK(true);
        }
    }

    private void awm() {
        int height;
        int paddingTop = this.mListView.getPaddingTop();
        float height2 = (this.mListView.getHeight() - paddingTop) - this.mListView.getPaddingBottom();
        this.cEJ = paddingTop + (this.cEE * height2);
        this.cEI = (height2 * (1.0f - this.cEF)) + paddingTop;
        this.cEG = (int) this.cEJ;
        this.cEH = (int) this.cEI;
        this.cEK = this.cEJ - paddingTop;
        this.cEL = (paddingTop + height) - this.cEI;
    }

    private void awn() {
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
        if (i2 != this.cEt && i2 != this.cEq && i2 != this.cEr) {
            g2 = -2;
        } else {
            g2 = g(i2, view, z);
        }
        if (g2 != layoutParams.height) {
            layoutParams.height = g2;
            view.setLayoutParams(layoutParams);
        }
        if (i2 == this.cEq || i2 == this.cEr) {
            if (i2 < this.cEt) {
                ((DragSortItemView) view).setGravity(80);
            } else if (i2 > this.cEt) {
                ((DragSortItemView) view).setGravity(48);
            }
        }
        int visibility = view.getVisibility();
        int i3 = 0;
        if (i2 == this.cEt && this.cEi != null) {
            i3 = 4;
        }
        if (i3 != visibility) {
            view.setVisibility(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int kZ(int i2) {
        View view;
        if (i2 == this.cEt) {
            return 0;
        }
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        if (childAt != null) {
            return f(i2, childAt, false);
        }
        int i3 = this.cFb.get(i2);
        if (i3 == -1) {
            ListAdapter adapter = this.mListView.getAdapter();
            int itemViewType = adapter.getItemViewType(i2);
            int viewTypeCount = adapter.getViewTypeCount();
            if (viewTypeCount != this.cEC.length) {
                this.cEC = new View[viewTypeCount];
            }
            if (itemViewType >= 0) {
                if (this.cEC[itemViewType] == null) {
                    view = adapter.getView(i2, null, this.mListView);
                    this.cEC[itemViewType] = view;
                } else {
                    view = adapter.getView(i2, this.cEC[itemViewType], this.mListView);
                }
            } else {
                view = adapter.getView(i2, null, this.mListView);
            }
            int f2 = f(i2, view, true);
            this.cFb.add(i2, f2);
            return f2;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(int i2, View view, boolean z) {
        if (i2 == this.cEt) {
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
        boolean z = this.cEs && this.cEq != this.cEr;
        int i4 = this.aIS - this.cEA;
        int i5 = (int) (this.cEW * i4);
        if (i2 == this.cEt) {
            if (this.cEt == this.cEq) {
                if (z) {
                    return i5 + this.cEA;
                }
                return this.aIS;
            } else if (this.cEt == this.cEr) {
                return this.aIS - i5;
            } else {
                return this.cEA;
            }
        } else if (i2 == this.cEq) {
            if (z) {
                return i3 + i5;
            }
            return i3 + i4;
        } else if (i2 == this.cEr) {
            return (i3 + i4) - i5;
        } else {
            return i3;
        }
    }

    private int b(int i2, View view, int i3, int i4) {
        int i5;
        int i6;
        int kZ = kZ(i2);
        int height = view.getHeight();
        int an = an(i2, kZ);
        if (i2 != this.cEt) {
            i6 = height - kZ;
            i5 = an - kZ;
        } else {
            i5 = an;
            i6 = height;
        }
        int i7 = this.aIS;
        if (this.cEt != this.cEq && this.cEt != this.cEr) {
            i7 -= this.cEA;
        }
        if (i2 <= i3) {
            if (i2 > this.cEq) {
                return (i7 - i5) + 0;
            }
        } else if (i2 == i4) {
            if (i2 <= this.cEq) {
                return (i6 - i7) + 0;
            }
            if (i2 == this.cEr) {
                return (height - an) + 0;
            }
            return 0 + i6;
        } else if (i2 <= this.cEq) {
            return 0 - i7;
        } else {
            if (i2 == this.cEr) {
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

    private void awo() {
        if (this.cEi != null) {
            measureItem(this.cEi);
            this.aIS = this.cEi.getMeasuredHeight();
            this.cEB = this.aIS / 2;
        }
    }

    protected boolean onDragTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        switch (motionEvent.getAction() & 255) {
            case 1:
                if (this.mDragState == 4) {
                    stopDrag(false);
                }
                awl();
                return true;
            case 2:
                am((int) motionEvent.getX(), (int) motionEvent.getY());
                return true;
            case 3:
                if (this.mDragState == 4) {
                    cancelDrag();
                }
                awl();
                return true;
            default:
                return true;
        }
    }

    public boolean startDrag(int i2, int i3, int i4, int i5) {
        View lb;
        if (!this.cER || this.cES == null || (lb = this.cES.lb(i2)) == null) {
            return false;
        }
        return startDrag(i2, lb, i3, i4, i5);
    }

    public boolean startDrag(int i2, View view, int i3, int i4, int i5) {
        if (this.mDragState == 0 && this.cER && this.cEi == null && view != null && this.cEz) {
            if (this.mListView.getParent() != null) {
                this.mListView.getParent().requestDisallowInterceptTouchEvent(true);
            }
            int headerViewsCount = this.mListView.getHeaderViewsCount() + i2;
            this.cEq = headerViewsCount;
            this.cEr = headerViewsCount;
            this.cEt = headerViewsCount;
            this.cEp = headerViewsCount;
            this.mDragState = 4;
            this.cEP = 0;
            this.cEP |= i3;
            this.cEi = view;
            awo();
            this.cEu = i4;
            this.cEv = i5;
            this.cEO = this.alS;
            this.cEj.x = this.alR - this.cEu;
            this.cEj.y = this.alS - this.cEv;
            View childAt = this.mListView.getChildAt(this.cEt - this.mListView.getFirstVisiblePosition());
            if (childAt != null) {
                childAt.setVisibility(4);
            }
            if (this.cEY) {
                this.cEZ.startTracking();
            }
            switch (this.cEU) {
                case 1:
                    this.cFh.onTouchEvent(this.cET);
                    break;
                case 2:
                    this.cFh.onInterceptTouchEvent(this.cET);
                    break;
            }
            this.mListView.requestLayout();
            if (this.cFd != null) {
                this.cFd.start();
                return true;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fJ(boolean z) {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition() + (this.mListView.getChildCount() / 2);
        View childAt = this.mListView.getChildAt(this.mListView.getChildCount() / 2);
        if (childAt != null) {
            h(firstVisiblePosition, childAt, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i2, View view, boolean z) {
        this.mBlockLayoutRequests = true;
        awp();
        int i3 = this.cEq;
        int i4 = this.cEr;
        boolean awg = awg();
        if (awg) {
            awn();
            this.mListView.setSelectionFromTop(i2, (b(i2, view, i3, i4) + view.getTop()) - this.mListView.getPaddingTop());
            layoutChildren();
        }
        if (awg || z) {
            this.mListView.invalidate();
        }
        this.mBlockLayoutRequests = false;
    }

    private void awp() {
        if (this.cES != null) {
            this.cEk.set(this.alR, this.alS);
            this.cES.b(this.cEi, this.cEj, this.cEk);
        }
        int i2 = this.cEj.x;
        int i3 = this.cEj.y;
        int paddingLeft = this.mListView.getPaddingLeft();
        if ((this.cEP & 1) == 0 && i2 > paddingLeft) {
            this.cEj.x = paddingLeft;
        } else if ((this.cEP & 2) == 0 && i2 < paddingLeft) {
            this.cEj.x = paddingLeft;
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int lastVisiblePosition = this.mListView.getLastVisiblePosition();
        int paddingTop = this.mListView.getPaddingTop();
        if (firstVisiblePosition < headerViewsCount) {
            paddingTop = this.mListView.getChildAt((headerViewsCount - firstVisiblePosition) - 1).getBottom();
        }
        if ((this.cEP & 8) == 0 && firstVisiblePosition <= this.cEt) {
            paddingTop = Math.max(this.mListView.getChildAt(this.cEt - firstVisiblePosition).getTop(), paddingTop);
        }
        int height = this.mListView.getHeight() - this.mListView.getPaddingBottom();
        if (lastVisiblePosition >= (this.mListView.getCount() - footerViewsCount) - 1) {
            height = this.mListView.getChildAt(((this.mListView.getCount() - footerViewsCount) - 1) - firstVisiblePosition).getBottom();
        }
        if ((this.cEP & 4) == 0 && lastVisiblePosition >= this.cEt) {
            height = Math.min(this.mListView.getChildAt(this.cEt - firstVisiblePosition).getBottom(), height);
        }
        if (i3 < paddingTop) {
            this.cEj.y = paddingTop;
        } else if (this.aIS + i3 > height) {
            this.cEj.y = height - this.aIS;
        }
        this.cEl = this.cEj.y + this.cEB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awq() {
        if (this.cEi != null) {
            this.cEi.setVisibility(8);
            if (this.cES != null) {
                this.cES.bg(this.cEi);
            }
            this.cEi = null;
            this.mListView.invalidate();
        }
    }

    public void a(h hVar) {
        this.cES = hVar;
    }

    public void a(b bVar) {
        this.cEw = bVar;
    }

    public void setDragEnabled(boolean z) {
        this.cEz = z;
    }

    public boolean isDragEnabled() {
        return this.cEz;
    }

    public void a(g gVar) {
        this.cEx = gVar;
    }

    public void a(l lVar) {
        this.cEy = lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class i {
        private SparseIntArray cFC;
        private ArrayList<Integer> cFD;
        private int mMaxSize;

        public i(int i) {
            this.cFC = new SparseIntArray(i);
            this.cFD = new ArrayList<>(i);
            this.mMaxSize = i;
        }

        public void add(int i, int i2) {
            int i3 = this.cFC.get(i, -1);
            if (i3 != i2) {
                if (i3 == -1) {
                    if (this.cFC.size() == this.mMaxSize) {
                        this.cFC.delete(this.cFD.remove(0).intValue());
                    }
                } else {
                    this.cFD.remove(Integer.valueOf(i));
                }
                this.cFC.put(i, i2);
                this.cFD.add(Integer.valueOf(i));
            }
        }

        public int get(int i) {
            return this.cFC.get(i, -1);
        }

        public void clear() {
            this.cFC.clear();
            this.cFD.clear();
        }
    }

    /* renamed from: com.baidu.tbadk.widget.dragsort.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0260a extends BaseAdapter {
        private ListAdapter mAdapter;

        public C0260a(ListAdapter listAdapter) {
            this.mAdapter = listAdapter;
            this.mAdapter.registerDataSetObserver(new DataSetObserver() { // from class: com.baidu.tbadk.widget.dragsort.a.a.1
                @Override // android.database.DataSetObserver
                public void onChanged() {
                    C0260a.this.notifyDataSetChanged();
                }

                @Override // android.database.DataSetObserver
                public void onInvalidated() {
                    C0260a.this.notifyDataSetInvalidated();
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
        private float ams;
        private float amt;
        private float amu;
        private float amv;
        private float cFN;
        private float mAlpha;
        private boolean mCanceled;
        protected long mStartTime;

        public m(float f, int i) {
            this.mAlpha = f;
            this.cFN = i;
            float f2 = 1.0f / ((this.mAlpha * 2.0f) * (1.0f - this.mAlpha));
            this.amv = f2;
            this.ams = f2;
            this.amt = this.mAlpha / ((this.mAlpha - 1.0f) * 2.0f);
            this.amu = 1.0f / (1.0f - this.mAlpha);
        }

        public float aq(float f) {
            if (f < this.mAlpha) {
                return this.ams * f * f;
            }
            if (f < 1.0f - this.mAlpha) {
                return this.amt + (this.amu * f);
            }
            return 1.0f - ((this.amv * (f - 1.0f)) * (f - 1.0f));
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
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / this.cFN;
                if (uptimeMillis >= 1.0f) {
                    t(1.0f, 1.0f);
                    onStop();
                    return;
                }
                t(uptimeMillis, aq(uptimeMillis));
                a.this.mListView.post(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class f extends m {
        private float cFA;
        private float cFB;
        private int cFy;
        private int cFz;

        public f(float f, int i) {
            super(f, i);
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.cFy = a.this.cEp;
            this.cFz = a.this.cEt;
            a.this.mDragState = 2;
            this.cFA = a.this.cEj.y - awu();
            this.cFB = a.this.cEj.x - a.this.mListView.getPaddingLeft();
        }

        private int awu() {
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            int dividerHeight = (a.this.cEA + a.this.mListView.getDividerHeight()) / 2;
            View childAt = a.this.mListView.getChildAt(this.cFy - firstVisiblePosition);
            if (childAt != null) {
                if (this.cFy == this.cFz) {
                    return childAt.getTop();
                }
                if (this.cFy >= this.cFz) {
                    return (childAt.getBottom() + dividerHeight) - a.this.aIS;
                }
                return childAt.getTop() - dividerHeight;
            }
            cancel();
            return -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void t(float f, float f2) {
            int awu = awu();
            float paddingLeft = a.this.cEj.x - a.this.mListView.getPaddingLeft();
            float f3 = 1.0f - f2;
            if (f3 < Math.abs((a.this.cEj.y - awu) / this.cFA) || f3 < Math.abs(paddingLeft / this.cFB)) {
                a.this.cEj.y = awu + ((int) (this.cFA * f3));
                a.this.cEj.x = a.this.mListView.getPaddingLeft() + ((int) (this.cFB * f3));
                a.this.fJ(true);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.awi();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class k extends m {
        private float cFG;
        private float cFH;
        private float cFI;
        private int cFJ;
        private int cFK;
        private int cFL;
        private int cFM;
        private int cFz;

        public k(float f, int i) {
            super(f, i);
            this.cFJ = -1;
            this.cFK = -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.cFJ = -1;
            this.cFK = -1;
            this.cFL = a.this.cEq;
            this.cFM = a.this.cEr;
            this.cFz = a.this.cEt;
            a.this.mDragState = 1;
            this.cFG = a.this.cEj.x;
            if (a.this.cFf) {
                float width = a.this.mListView.getWidth() * 2.0f;
                if (a.this.cFg == 0.0f) {
                    a.this.cFg = (this.cFG >= 0.0f ? 1 : -1) * width;
                    return;
                }
                float f = width * 2.0f;
                if (a.this.cFg >= 0.0f || a.this.cFg <= (-f)) {
                    if (a.this.cFg > 0.0f && a.this.cFg < f) {
                        a.this.cFg = f;
                        return;
                    }
                    return;
                }
                a.this.cFg = -f;
                return;
            }
            a.this.awq();
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void t(float f, float f2) {
            View childAt;
            float f3 = 1.0f - f2;
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            View childAt2 = a.this.mListView.getChildAt(this.cFL - firstVisiblePosition);
            if (a.this.cFf) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / 1000.0f;
                if (uptimeMillis != 0.0f) {
                    float f4 = a.this.cFg * uptimeMillis;
                    int width = a.this.mListView.getWidth();
                    a.this.cFg = ((a.this.cFg > 0.0f ? 1 : -1) * uptimeMillis * width) + a.this.cFg;
                    this.cFG += f4;
                    a.this.cEj.x = (int) this.cFG;
                    if (this.cFG < width && this.cFG > (-width)) {
                        this.mStartTime = SystemClock.uptimeMillis();
                        a.this.fJ(true);
                        return;
                    }
                } else {
                    return;
                }
            }
            if (childAt2 != null) {
                if (this.cFJ == -1) {
                    this.cFJ = a.this.f(this.cFL, childAt2, false);
                    this.cFH = childAt2.getHeight() - this.cFJ;
                }
                int max = Math.max((int) (this.cFH * f3), 1);
                ViewGroup.LayoutParams layoutParams = childAt2.getLayoutParams();
                layoutParams.height = max + this.cFJ;
                childAt2.setLayoutParams(layoutParams);
            }
            if (this.cFM != this.cFL && (childAt = a.this.mListView.getChildAt(this.cFM - firstVisiblePosition)) != null) {
                if (this.cFK == -1) {
                    this.cFK = a.this.f(this.cFM, childAt, false);
                    this.cFI = childAt.getHeight() - this.cFK;
                }
                int max2 = Math.max((int) (this.cFI * f3), 1);
                ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
                layoutParams2.height = max2 + this.cFK;
                childAt.setLayoutParams(layoutParams2);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.awj();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class j extends m {
        private float cFE;
        private float cFF;
        final /* synthetic */ a cFl;

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.cFE = this.cFl.cEv;
            this.cFF = this.cFl.cEB;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void t(float f, float f2) {
            if (this.cFl.mDragState != 4) {
                cancel();
                return;
            }
            this.cFl.cEv = (int) ((this.cFF * f2) + ((1.0f - f2) * this.cFE));
            this.cFl.cEj.y = this.cFl.alS - this.cFl.cEv;
            this.cFl.fJ(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e {
        StringBuilder mBuilder = new StringBuilder();
        private int cFv = 0;
        private int cFw = 0;
        private boolean cFx = false;
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
            this.cFw = 0;
            this.cFx = true;
        }

        public void awt() {
            if (this.cFx) {
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
                this.mBuilder.append("    <FirstExpPos>").append(a.this.cEq).append("</FirstExpPos>\n");
                this.mBuilder.append("    <FirstExpBlankHeight>").append(a.this.kX(a.this.cEq) - a.this.kZ(a.this.cEq)).append("</FirstExpBlankHeight>\n");
                this.mBuilder.append("    <SecondExpPos>").append(a.this.cEr).append("</SecondExpPos>\n");
                this.mBuilder.append("    <SecondExpBlankHeight>").append(a.this.kX(a.this.cEr) - a.this.kZ(a.this.cEr)).append("</SecondExpBlankHeight>\n");
                this.mBuilder.append("    <SrcPos>").append(a.this.cEt).append("</SrcPos>\n");
                this.mBuilder.append("    <SrcHeight>").append(a.this.aIS + a.this.mListView.getDividerHeight()).append("</SrcHeight>\n");
                this.mBuilder.append("    <ViewHeight>").append(a.this.mListView.getHeight()).append("</ViewHeight>\n");
                this.mBuilder.append("    <LastY>").append(a.this.mLastY).append("</LastY>\n");
                this.mBuilder.append("    <FloatY>").append(a.this.cEl).append("</FloatY>\n");
                this.mBuilder.append("    <ShuffleEdges>");
                for (int i4 = 0; i4 < childCount; i4++) {
                    this.mBuilder.append(a.this.al(firstVisiblePosition + i4, a.this.mListView.getChildAt(i4).getTop())).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                this.mBuilder.append("</ShuffleEdges>\n");
                this.mBuilder.append("</DSLVState>\n");
                this.cFv++;
                if (this.cFv > 1000) {
                    flush();
                    this.cFv = 0;
                }
            }
        }

        public void flush() {
            if (this.cFx) {
                try {
                    FileWriter fileWriter = new FileWriter(this.mFile, this.cFw != 0);
                    fileWriter.write(this.mBuilder.toString());
                    this.mBuilder.delete(0, this.mBuilder.length());
                    fileWriter.flush();
                    fileWriter.close();
                    this.cFw++;
                } catch (IOException e) {
                }
            }
        }

        public void nn() {
            if (this.cFx) {
                this.mBuilder.append("</DSLVStates>\n");
                flush();
                this.cFx = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements Runnable {
        private boolean aMB = false;
        private boolean cFo;
        private long cFp;
        private long cFq;
        private float cFr;
        private long cFs;
        private int cFt;
        private float cFu;
        private int dy;

        public boolean awr() {
            return this.aMB;
        }

        public int aws() {
            if (this.aMB) {
                return this.cFt;
            }
            return -1;
        }

        public d() {
        }

        public void la(int i) {
            if (!this.aMB) {
                this.cFo = false;
                this.aMB = true;
                this.cFs = SystemClock.uptimeMillis();
                this.cFp = this.cFs;
                this.cFt = i;
                a.this.mListView.post(this);
            }
        }

        public void fK(boolean z) {
            if (z) {
                a.this.mListView.removeCallbacks(this);
                this.aMB = false;
                return;
            }
            this.cFo = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.cFo) {
                int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
                int lastVisiblePosition = a.this.mListView.getLastVisiblePosition();
                int count = a.this.mListView.getCount();
                int paddingTop = a.this.mListView.getPaddingTop();
                int height = (a.this.mListView.getHeight() - paddingTop) - a.this.mListView.getPaddingBottom();
                int min = Math.min(a.this.alS, a.this.cEl + a.this.cEB);
                int max = Math.max(a.this.alS, a.this.cEl - a.this.cEB);
                if (this.cFt == 0) {
                    View childAt = a.this.mListView.getChildAt(0);
                    if (childAt == null) {
                        this.aMB = false;
                        return;
                    } else if (firstVisiblePosition == 0 && childAt.getTop() == paddingTop) {
                        this.aMB = false;
                        return;
                    } else {
                        this.cFu = a.this.cEN.b((a.this.cEJ - max) / a.this.cEK, this.cFp);
                    }
                } else {
                    View childAt2 = a.this.mListView.getChildAt(lastVisiblePosition - firstVisiblePosition);
                    if (childAt2 == null) {
                        this.aMB = false;
                        return;
                    } else if (lastVisiblePosition == count - 1 && childAt2.getBottom() <= height + paddingTop) {
                        this.aMB = false;
                        return;
                    } else {
                        this.cFu = -a.this.cEN.b((min - a.this.cEI) / a.this.cEL, this.cFp);
                    }
                }
                this.cFq = SystemClock.uptimeMillis();
                this.cFr = (float) (this.cFq - this.cFp);
                this.dy = Math.round(this.cFu * this.cFr);
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
                this.cFp = this.cFq;
                a.this.mListView.post(this);
                return;
            }
            this.aMB = false;
        }
    }
}
