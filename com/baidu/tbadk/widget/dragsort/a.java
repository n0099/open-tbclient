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
    private int cEC;
    private d cEE;
    private int cEH;
    private int cEI;
    private float cEJ;
    private float cEK;
    private float cEL;
    private float cEM;
    private int cEP;
    private MotionEvent cEU;
    private C0260a cEY;
    private View cEj;
    private int cEm;
    private int cEq;
    private int cEr;
    private int cEs;
    private int cEu;
    private int cEv;
    private int cEw;
    private b cEx;
    private g cEy;
    private l cEz;
    private e cFa;
    private k cFd;
    private j cFe;
    private f cFf;
    private boolean cFg;
    private com.baidu.tbadk.widget.dragsort.d cFi;
    private com.baidu.tbadk.widget.dragsort.b cFj;
    private int mLastX;
    private int mLastY;
    private ListView mListView;
    private DataSetObserver mObserver;
    private Point cEk = new Point();
    private Point cEl = new Point();
    private boolean cEn = false;
    private float cEo = 1.0f;
    private float cEp = 1.0f;
    private boolean cEt = false;
    private boolean cEA = true;
    private int mDragState = 0;
    private int cEB = 1;
    private int mWidthMeasureSpec = 0;
    private View[] cED = new View[1];
    private float cEF = 0.33333334f;
    private float cEG = 0.33333334f;
    private float cEN = 0.5f;
    private c cEO = new c() { // from class: com.baidu.tbadk.widget.dragsort.a.1
        @Override // com.baidu.tbadk.widget.dragsort.a.c
        public float b(float f2, long j2) {
            return a.this.cEN * f2;
        }
    };
    private int cEQ = 0;
    private boolean cER = false;
    private boolean cES = false;
    private h cET = null;
    private int cEV = 0;
    private float cEW = 0.25f;
    private float cEX = 0.0f;
    private boolean cEZ = false;
    private boolean mBlockLayoutRequests = false;
    private boolean cFb = false;
    private i cFc = new i(3);
    private float cFh = 0.0f;
    private boolean cFk = false;
    private boolean cFl = false;

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
        this.cFi = dVar;
        this.mListView = listView;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            this.cEY = new C0260a(listAdapter);
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
            this.cEY = null;
        }
        this.cFi.setAdapter(this.cEY);
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
            if (i2 > this.cEu) {
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
        int i4 = this.aIS - this.cEB;
        int kZ = kZ(i2);
        int kX = kX(i2);
        if (this.cEs <= this.cEu) {
            if (i2 == this.cEs && this.cEr != this.cEs) {
                if (i2 == this.cEu) {
                    i3 = (i3 + kX) - this.aIS;
                } else {
                    i3 = ((kX - kZ) + i3) - i4;
                }
            } else if (i2 > this.cEs && i2 <= this.cEu) {
                i3 -= i4;
            }
        } else if (i2 > this.cEu && i2 <= this.cEr) {
            i3 += i4;
        } else if (i2 == this.cEs && this.cEr != this.cEs) {
            i3 += kX - kZ;
        }
        if (i2 <= this.cEu) {
            return (((this.aIS - dividerHeight) - kZ(i2 - 1)) / 2) + i3;
        }
        return (((kZ - dividerHeight) - this.aIS) / 2) + i3;
    }

    private boolean awh() {
        int i2;
        int i3;
        int i4;
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int i5 = this.cEr;
        View childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        if (childAt == null) {
            i5 = firstVisiblePosition + (this.mListView.getChildCount() / 2);
            childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        }
        int top = childAt.getTop();
        int height = childAt.getHeight();
        int al = al(i5, top);
        int dividerHeight = this.mListView.getDividerHeight();
        if (this.cEm >= al) {
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
                    if (this.cEm < i2) {
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
                if (this.cEm >= i2) {
                    break;
                }
                i4 = i2;
            }
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int i9 = this.cEr;
        int i10 = this.cEs;
        float f2 = this.cEX;
        if (this.cEt) {
            int abs = Math.abs(i2 - i4);
            if (this.cEm >= i2) {
                int i11 = i4;
                i4 = i2;
                i2 = i11;
            }
            int i12 = (int) (abs * this.cEW * 0.5f);
            float f3 = i12;
            int i13 = i4 + i12;
            int i14 = i2 - i12;
            if (this.cEm < i13) {
                this.cEr = i3 - 1;
                this.cEs = i3;
                this.cEX = ((i13 - this.cEm) * 0.5f) / f3;
            } else if (this.cEm < i14) {
                this.cEr = i3;
                this.cEs = i3;
            } else {
                this.cEr = i3;
                this.cEs = i3 + 1;
                this.cEX = (1.0f + ((i2 - this.cEm) / f3)) * 0.5f;
            }
        } else {
            this.cEr = i3;
            this.cEs = i3;
        }
        if (this.cEr < headerViewsCount) {
            this.cEr = headerViewsCount;
            this.cEs = headerViewsCount;
            i3 = headerViewsCount;
        } else if (this.cEs >= this.mListView.getCount() - footerViewsCount) {
            i3 = (this.mListView.getCount() - footerViewsCount) - 1;
            this.cEr = i3;
            this.cEs = i3;
        }
        boolean z = (this.cEr == i9 && this.cEs == i10 && this.cEX == f2) ? false : true;
        if (i3 != this.cEq) {
            if (this.cEx != null) {
                this.cEx.drag(this.cEq - headerViewsCount, i3 - headerViewsCount);
            }
            this.cEq = i3;
            return true;
        }
        return z;
    }

    public void removeItem(int i2) {
        this.cFg = false;
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
            this.cEB = Math.max(1, obtainStyledAttributes.getDimensionPixelSize(13, 1));
            this.cEZ = obtainStyledAttributes.getBoolean(7, false);
            if (this.cEZ) {
                this.cFa = new e();
            }
            this.cEo = obtainStyledAttributes.getFloat(11, this.cEo);
            this.cEp = this.cEo;
            this.cEA = obtainStyledAttributes.getBoolean(14, this.cEA);
            this.cEW = Math.max(0.0f, Math.min(1.0f, 1.0f - obtainStyledAttributes.getFloat(1, 0.75f)));
            this.cEt = this.cEW > 0.0f;
            setDragScrollStart(obtainStyledAttributes.getFloat(15, this.cEF));
            this.cEN = obtainStyledAttributes.getFloat(0, this.cEN);
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
                this.cET = bVar;
                a(bVar);
            }
            obtainStyledAttributes.recycle();
            i2 = i5;
            i3 = i4;
        }
        this.cEE = new d();
        if (i3 > 0) {
            this.cFd = new k(0.5f, i3);
        }
        if (i2 > 0) {
            this.cFf = new f(0.5f, i2);
        }
        this.cEU = MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
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
        this.cFj = bVar;
        this.mListView.setOnTouchListener(bVar);
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void dispatchDraw(Canvas canvas) {
        float f2;
        this.cFi.dispatchDraw(canvas);
        if (this.mDragState != 0) {
            if (this.cEr != this.cEu) {
                b(this.cEr, canvas);
            }
            if (this.cEs != this.cEr && this.cEs != this.cEu) {
                b(this.cEs, canvas);
            }
        }
        if (this.cEj != null) {
            int width = this.cEj.getWidth();
            int height = this.cEj.getHeight();
            int i2 = this.cEk.x;
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
            int i3 = (int) (f2 * 255.0f * this.cEp);
            canvas.save();
            canvas.translate(this.cEk.x, this.cEk.y);
            canvas.clipRect(0, 0, width, height);
            canvas.saveLayerAlpha(0.0f, 0.0f, width, height, i3, 31);
            this.cEj.draw(canvas);
            canvas.restore();
            canvas.restore();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onDraw(Canvas canvas) {
        this.cFi.onDraw(canvas);
        if (this.cEZ) {
            this.cFa.awu();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.cFb) {
            this.cFb = false;
            return false;
        } else if (!this.cEA) {
            return this.cFi.onTouchEvent(motionEvent);
        } else {
            boolean z2 = this.cER;
            this.cER = false;
            if (!z2) {
                y(motionEvent);
            }
            if (this.mDragState == 4) {
                onDragTouchEvent(motionEvent);
                return true;
            }
            if (this.mDragState == 0 && this.cFi.onTouchEvent(motionEvent)) {
                z = true;
            }
            switch (motionEvent.getAction() & 255) {
                case 1:
                case 3:
                    awm();
                    return z;
                case 2:
                default:
                    if (z) {
                        this.cEV = 1;
                        return z;
                    }
                    return z;
            }
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (!this.cEA) {
            return this.cFi.onInterceptTouchEvent(motionEvent);
        }
        if (this.cFj != null) {
            this.cFj.aww().onTouchEvent(motionEvent);
        }
        y(motionEvent);
        this.cER = true;
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            if (this.mDragState != 0) {
                this.cFb = true;
                return true;
            }
            this.cES = true;
        }
        if (this.cEj == null) {
            if (this.cFi.onInterceptTouchEvent(motionEvent)) {
                this.cFk = true;
                z = true;
            } else {
                z = false;
            }
            switch (action) {
                case 1:
                case 3:
                    awm();
                    break;
                case 2:
                default:
                    if (z) {
                        this.cEV = 1;
                        break;
                    } else {
                        this.cEV = 2;
                        break;
                    }
            }
        } else {
            z = true;
        }
        if (action == 1 || action == 3) {
            this.cES = false;
        }
        return z;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        this.cFi.onSizeChanged(i2, i3, i4, i5);
        awn();
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void requestLayout() {
        if (!this.mBlockLayoutRequests) {
            this.cFi.requestLayout();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onMeasure(int i2, int i3) {
        this.cFi.onMeasure(i2, i3);
        if (this.cEj != null) {
            if (this.cEj.isLayoutRequested()) {
                awp();
            }
            this.cEn = true;
        }
        this.mWidthMeasureSpec = i2;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void layoutChildren() {
        this.cFi.layoutChildren();
        if (this.cEj != null) {
            if (this.cEj.isLayoutRequested() && !this.cEn) {
                awp();
            }
            this.cEj.layout(0, 0, this.cEj.getMeasuredWidth(), this.cEj.getMeasuredHeight());
            this.cEn = false;
        }
    }

    public void removeItem(int i2, float f2) {
        if (this.mDragState == 0 || this.mDragState == 4) {
            if (this.mDragState == 0) {
                this.cEu = this.mListView.getHeaderViewsCount() + i2;
                this.cEr = this.cEu;
                this.cEs = this.cEu;
                this.cEq = this.cEu;
                View childAt = this.mListView.getChildAt(this.cEu - this.mListView.getFirstVisiblePosition());
                if (childAt != null) {
                    childAt.setVisibility(4);
                }
            }
            this.mDragState = 1;
            this.cFh = f2;
            if (this.cES) {
                switch (this.cEV) {
                    case 1:
                        this.cFi.onTouchEvent(this.cEU);
                        break;
                    case 2:
                        this.cFi.onInterceptTouchEvent(this.cEU);
                        break;
                }
            }
            if (this.cFd != null) {
                this.cFd.start();
            } else {
                kY(i2);
            }
        }
    }

    public void cancelDrag() {
        if (this.mDragState == 4) {
            this.cEE.fK(true);
            awr();
            awi();
            awo();
            if (this.cES) {
                this.mDragState = 3;
            } else {
                this.mDragState = 0;
            }
        }
    }

    private void awi() {
        this.cEu = -1;
        this.cEr = -1;
        this.cEs = -1;
        this.cEq = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awj() {
        this.mDragState = 2;
        if (this.cEy != null && this.cEq >= 0 && this.cEq < this.mListView.getCount()) {
            int headerViewsCount = this.mListView.getHeaderViewsCount();
            this.cEy.drop(this.cEu - headerViewsCount, this.cEq - headerViewsCount);
        }
        awr();
        awl();
        awi();
        awo();
        if (this.cES) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awk() {
        kY(this.cEu - this.mListView.getHeaderViewsCount());
    }

    private void kY(int i2) {
        this.mDragState = 1;
        if (this.cEz != null) {
            this.cEz.remove(i2);
        }
        awr();
        awl();
        awi();
        if (this.cES) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    private void awl() {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        if (this.cEu < firstVisiblePosition) {
            View childAt = this.mListView.getChildAt(0);
            this.mListView.setSelectionFromTop(firstVisiblePosition - 1, (childAt != null ? childAt.getTop() : 0) - this.mListView.getPaddingTop());
        }
    }

    public boolean stopDrag(boolean z) {
        this.cFg = false;
        return stopDrag(z, 0.0f);
    }

    public boolean stopDragWithVelocity(boolean z, float f2) {
        this.cFg = true;
        return stopDrag(z, f2);
    }

    public boolean stopDrag(boolean z, float f2) {
        if (this.cEj != null) {
            this.cEE.fK(true);
            if (z) {
                removeItem(this.cEu - this.mListView.getHeaderViewsCount(), f2);
            } else if (this.cFf != null) {
                this.cFf.start();
            } else {
                awj();
            }
            if (this.cEZ) {
                this.cFa.nn();
                return true;
            }
            return true;
        }
        return false;
    }

    private void awm() {
        this.cEV = 0;
        this.cES = false;
        if (this.mDragState == 3) {
            this.mDragState = 0;
        }
        this.cEp = this.cEo;
        this.cFk = false;
        this.cFc.clear();
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
        return this.cFk;
    }

    public void setDragScrollStart(float f2) {
        setDragScrollStarts(f2, f2);
    }

    public void setDragScrollStarts(float f2, float f3) {
        if (f3 > 0.5f) {
            this.cEG = 0.5f;
        } else {
            this.cEG = f3;
        }
        if (f2 > 0.5f) {
            this.cEF = 0.5f;
        } else {
            this.cEF = f2;
        }
        if (this.mListView.getHeight() != 0) {
            awn();
        }
    }

    private void am(int i2, int i3) {
        this.cEk.x = i2 - this.cEv;
        this.cEk.y = i3 - this.cEw;
        fJ(true);
        int min = Math.min(i3, this.cEm + this.cEC);
        int max = Math.max(i3, this.cEm - this.cEC);
        int awt = this.cEE.awt();
        if (min > this.mLastY && min > this.cEI && awt != 1) {
            if (awt != -1) {
                this.cEE.fK(true);
            }
            this.cEE.la(1);
        } else if (max < this.mLastY && max < this.cEH && awt != 0) {
            if (awt != -1) {
                this.cEE.fK(true);
            }
            this.cEE.la(0);
        } else if (max >= this.cEH && min <= this.cEI && this.cEE.aws()) {
            this.cEE.fK(true);
        }
    }

    private void awn() {
        int height;
        int paddingTop = this.mListView.getPaddingTop();
        float height2 = (this.mListView.getHeight() - paddingTop) - this.mListView.getPaddingBottom();
        this.cEK = paddingTop + (this.cEF * height2);
        this.cEJ = (height2 * (1.0f - this.cEG)) + paddingTop;
        this.cEH = (int) this.cEK;
        this.cEI = (int) this.cEJ;
        this.cEL = this.cEK - paddingTop;
        this.cEM = (paddingTop + height) - this.cEJ;
    }

    private void awo() {
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
        if (i2 != this.cEu && i2 != this.cEr && i2 != this.cEs) {
            g2 = -2;
        } else {
            g2 = g(i2, view, z);
        }
        if (g2 != layoutParams.height) {
            layoutParams.height = g2;
            view.setLayoutParams(layoutParams);
        }
        if (i2 == this.cEr || i2 == this.cEs) {
            if (i2 < this.cEu) {
                ((DragSortItemView) view).setGravity(80);
            } else if (i2 > this.cEu) {
                ((DragSortItemView) view).setGravity(48);
            }
        }
        int visibility = view.getVisibility();
        int i3 = 0;
        if (i2 == this.cEu && this.cEj != null) {
            i3 = 4;
        }
        if (i3 != visibility) {
            view.setVisibility(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int kZ(int i2) {
        View view;
        if (i2 == this.cEu) {
            return 0;
        }
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        if (childAt != null) {
            return f(i2, childAt, false);
        }
        int i3 = this.cFc.get(i2);
        if (i3 == -1) {
            ListAdapter adapter = this.mListView.getAdapter();
            int itemViewType = adapter.getItemViewType(i2);
            int viewTypeCount = adapter.getViewTypeCount();
            if (viewTypeCount != this.cED.length) {
                this.cED = new View[viewTypeCount];
            }
            if (itemViewType >= 0) {
                if (this.cED[itemViewType] == null) {
                    view = adapter.getView(i2, null, this.mListView);
                    this.cED[itemViewType] = view;
                } else {
                    view = adapter.getView(i2, this.cED[itemViewType], this.mListView);
                }
            } else {
                view = adapter.getView(i2, null, this.mListView);
            }
            int f2 = f(i2, view, true);
            this.cFc.add(i2, f2);
            return f2;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(int i2, View view, boolean z) {
        if (i2 == this.cEu) {
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
        boolean z = this.cEt && this.cEr != this.cEs;
        int i4 = this.aIS - this.cEB;
        int i5 = (int) (this.cEX * i4);
        if (i2 == this.cEu) {
            if (this.cEu == this.cEr) {
                if (z) {
                    return i5 + this.cEB;
                }
                return this.aIS;
            } else if (this.cEu == this.cEs) {
                return this.aIS - i5;
            } else {
                return this.cEB;
            }
        } else if (i2 == this.cEr) {
            if (z) {
                return i3 + i5;
            }
            return i3 + i4;
        } else if (i2 == this.cEs) {
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
        if (i2 != this.cEu) {
            i6 = height - kZ;
            i5 = an - kZ;
        } else {
            i5 = an;
            i6 = height;
        }
        int i7 = this.aIS;
        if (this.cEu != this.cEr && this.cEu != this.cEs) {
            i7 -= this.cEB;
        }
        if (i2 <= i3) {
            if (i2 > this.cEr) {
                return (i7 - i5) + 0;
            }
        } else if (i2 == i4) {
            if (i2 <= this.cEr) {
                return (i6 - i7) + 0;
            }
            if (i2 == this.cEs) {
                return (height - an) + 0;
            }
            return 0 + i6;
        } else if (i2 <= this.cEr) {
            return 0 - i7;
        } else {
            if (i2 == this.cEs) {
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

    private void awp() {
        if (this.cEj != null) {
            measureItem(this.cEj);
            this.aIS = this.cEj.getMeasuredHeight();
            this.cEC = this.aIS / 2;
        }
    }

    protected boolean onDragTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        switch (motionEvent.getAction() & 255) {
            case 1:
                if (this.mDragState == 4) {
                    stopDrag(false);
                }
                awm();
                return true;
            case 2:
                am((int) motionEvent.getX(), (int) motionEvent.getY());
                return true;
            case 3:
                if (this.mDragState == 4) {
                    cancelDrag();
                }
                awm();
                return true;
            default:
                return true;
        }
    }

    public boolean startDrag(int i2, int i3, int i4, int i5) {
        View lb;
        if (!this.cES || this.cET == null || (lb = this.cET.lb(i2)) == null) {
            return false;
        }
        return startDrag(i2, lb, i3, i4, i5);
    }

    public boolean startDrag(int i2, View view, int i3, int i4, int i5) {
        if (this.mDragState == 0 && this.cES && this.cEj == null && view != null && this.cEA) {
            if (this.mListView.getParent() != null) {
                this.mListView.getParent().requestDisallowInterceptTouchEvent(true);
            }
            int headerViewsCount = this.mListView.getHeaderViewsCount() + i2;
            this.cEr = headerViewsCount;
            this.cEs = headerViewsCount;
            this.cEu = headerViewsCount;
            this.cEq = headerViewsCount;
            this.mDragState = 4;
            this.cEQ = 0;
            this.cEQ |= i3;
            this.cEj = view;
            awp();
            this.cEv = i4;
            this.cEw = i5;
            this.cEP = this.alS;
            this.cEk.x = this.alR - this.cEv;
            this.cEk.y = this.alS - this.cEw;
            View childAt = this.mListView.getChildAt(this.cEu - this.mListView.getFirstVisiblePosition());
            if (childAt != null) {
                childAt.setVisibility(4);
            }
            if (this.cEZ) {
                this.cFa.startTracking();
            }
            switch (this.cEV) {
                case 1:
                    this.cFi.onTouchEvent(this.cEU);
                    break;
                case 2:
                    this.cFi.onInterceptTouchEvent(this.cEU);
                    break;
            }
            this.mListView.requestLayout();
            if (this.cFe != null) {
                this.cFe.start();
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
        awq();
        int i3 = this.cEr;
        int i4 = this.cEs;
        boolean awh = awh();
        if (awh) {
            awo();
            this.mListView.setSelectionFromTop(i2, (b(i2, view, i3, i4) + view.getTop()) - this.mListView.getPaddingTop());
            layoutChildren();
        }
        if (awh || z) {
            this.mListView.invalidate();
        }
        this.mBlockLayoutRequests = false;
    }

    private void awq() {
        if (this.cET != null) {
            this.cEl.set(this.alR, this.alS);
            this.cET.b(this.cEj, this.cEk, this.cEl);
        }
        int i2 = this.cEk.x;
        int i3 = this.cEk.y;
        int paddingLeft = this.mListView.getPaddingLeft();
        if ((this.cEQ & 1) == 0 && i2 > paddingLeft) {
            this.cEk.x = paddingLeft;
        } else if ((this.cEQ & 2) == 0 && i2 < paddingLeft) {
            this.cEk.x = paddingLeft;
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int lastVisiblePosition = this.mListView.getLastVisiblePosition();
        int paddingTop = this.mListView.getPaddingTop();
        if (firstVisiblePosition < headerViewsCount) {
            paddingTop = this.mListView.getChildAt((headerViewsCount - firstVisiblePosition) - 1).getBottom();
        }
        if ((this.cEQ & 8) == 0 && firstVisiblePosition <= this.cEu) {
            paddingTop = Math.max(this.mListView.getChildAt(this.cEu - firstVisiblePosition).getTop(), paddingTop);
        }
        int height = this.mListView.getHeight() - this.mListView.getPaddingBottom();
        if (lastVisiblePosition >= (this.mListView.getCount() - footerViewsCount) - 1) {
            height = this.mListView.getChildAt(((this.mListView.getCount() - footerViewsCount) - 1) - firstVisiblePosition).getBottom();
        }
        if ((this.cEQ & 4) == 0 && lastVisiblePosition >= this.cEu) {
            height = Math.min(this.mListView.getChildAt(this.cEu - firstVisiblePosition).getBottom(), height);
        }
        if (i3 < paddingTop) {
            this.cEk.y = paddingTop;
        } else if (this.aIS + i3 > height) {
            this.cEk.y = height - this.aIS;
        }
        this.cEm = this.cEk.y + this.cEC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awr() {
        if (this.cEj != null) {
            this.cEj.setVisibility(8);
            if (this.cET != null) {
                this.cET.bg(this.cEj);
            }
            this.cEj = null;
            this.mListView.invalidate();
        }
    }

    public void a(h hVar) {
        this.cET = hVar;
    }

    public void a(b bVar) {
        this.cEx = bVar;
    }

    public void setDragEnabled(boolean z) {
        this.cEA = z;
    }

    public boolean isDragEnabled() {
        return this.cEA;
    }

    public void a(g gVar) {
        this.cEy = gVar;
    }

    public void a(l lVar) {
        this.cEz = lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class i {
        private SparseIntArray cFD;
        private ArrayList<Integer> cFE;
        private int mMaxSize;

        public i(int i) {
            this.cFD = new SparseIntArray(i);
            this.cFE = new ArrayList<>(i);
            this.mMaxSize = i;
        }

        public void add(int i, int i2) {
            int i3 = this.cFD.get(i, -1);
            if (i3 != i2) {
                if (i3 == -1) {
                    if (this.cFD.size() == this.mMaxSize) {
                        this.cFD.delete(this.cFE.remove(0).intValue());
                    }
                } else {
                    this.cFE.remove(Integer.valueOf(i));
                }
                this.cFD.put(i, i2);
                this.cFE.add(Integer.valueOf(i));
            }
        }

        public int get(int i) {
            return this.cFD.get(i, -1);
        }

        public void clear() {
            this.cFD.clear();
            this.cFE.clear();
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
        private float cFO;
        private float mAlpha;
        private boolean mCanceled;
        protected long mStartTime;

        public m(float f, int i) {
            this.mAlpha = f;
            this.cFO = i;
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
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / this.cFO;
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
        private int cFA;
        private float cFB;
        private float cFC;
        private int cFz;

        public f(float f, int i) {
            super(f, i);
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.cFz = a.this.cEq;
            this.cFA = a.this.cEu;
            a.this.mDragState = 2;
            this.cFB = a.this.cEk.y - awv();
            this.cFC = a.this.cEk.x - a.this.mListView.getPaddingLeft();
        }

        private int awv() {
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            int dividerHeight = (a.this.cEB + a.this.mListView.getDividerHeight()) / 2;
            View childAt = a.this.mListView.getChildAt(this.cFz - firstVisiblePosition);
            if (childAt != null) {
                if (this.cFz == this.cFA) {
                    return childAt.getTop();
                }
                if (this.cFz >= this.cFA) {
                    return (childAt.getBottom() + dividerHeight) - a.this.aIS;
                }
                return childAt.getTop() - dividerHeight;
            }
            cancel();
            return -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void t(float f, float f2) {
            int awv = awv();
            float paddingLeft = a.this.cEk.x - a.this.mListView.getPaddingLeft();
            float f3 = 1.0f - f2;
            if (f3 < Math.abs((a.this.cEk.y - awv) / this.cFB) || f3 < Math.abs(paddingLeft / this.cFC)) {
                a.this.cEk.y = awv + ((int) (this.cFB * f3));
                a.this.cEk.x = a.this.mListView.getPaddingLeft() + ((int) (this.cFC * f3));
                a.this.fJ(true);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.awj();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class k extends m {
        private int cFA;
        private float cFH;
        private float cFI;
        private float cFJ;
        private int cFK;
        private int cFL;
        private int cFM;
        private int cFN;

        public k(float f, int i) {
            super(f, i);
            this.cFK = -1;
            this.cFL = -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.cFK = -1;
            this.cFL = -1;
            this.cFM = a.this.cEr;
            this.cFN = a.this.cEs;
            this.cFA = a.this.cEu;
            a.this.mDragState = 1;
            this.cFH = a.this.cEk.x;
            if (a.this.cFg) {
                float width = a.this.mListView.getWidth() * 2.0f;
                if (a.this.cFh == 0.0f) {
                    a.this.cFh = (this.cFH >= 0.0f ? 1 : -1) * width;
                    return;
                }
                float f = width * 2.0f;
                if (a.this.cFh >= 0.0f || a.this.cFh <= (-f)) {
                    if (a.this.cFh > 0.0f && a.this.cFh < f) {
                        a.this.cFh = f;
                        return;
                    }
                    return;
                }
                a.this.cFh = -f;
                return;
            }
            a.this.awr();
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void t(float f, float f2) {
            View childAt;
            float f3 = 1.0f - f2;
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            View childAt2 = a.this.mListView.getChildAt(this.cFM - firstVisiblePosition);
            if (a.this.cFg) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / 1000.0f;
                if (uptimeMillis != 0.0f) {
                    float f4 = a.this.cFh * uptimeMillis;
                    int width = a.this.mListView.getWidth();
                    a.this.cFh = ((a.this.cFh > 0.0f ? 1 : -1) * uptimeMillis * width) + a.this.cFh;
                    this.cFH += f4;
                    a.this.cEk.x = (int) this.cFH;
                    if (this.cFH < width && this.cFH > (-width)) {
                        this.mStartTime = SystemClock.uptimeMillis();
                        a.this.fJ(true);
                        return;
                    }
                } else {
                    return;
                }
            }
            if (childAt2 != null) {
                if (this.cFK == -1) {
                    this.cFK = a.this.f(this.cFM, childAt2, false);
                    this.cFI = childAt2.getHeight() - this.cFK;
                }
                int max = Math.max((int) (this.cFI * f3), 1);
                ViewGroup.LayoutParams layoutParams = childAt2.getLayoutParams();
                layoutParams.height = max + this.cFK;
                childAt2.setLayoutParams(layoutParams);
            }
            if (this.cFN != this.cFM && (childAt = a.this.mListView.getChildAt(this.cFN - firstVisiblePosition)) != null) {
                if (this.cFL == -1) {
                    this.cFL = a.this.f(this.cFN, childAt, false);
                    this.cFJ = childAt.getHeight() - this.cFL;
                }
                int max2 = Math.max((int) (this.cFJ * f3), 1);
                ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
                layoutParams2.height = max2 + this.cFL;
                childAt.setLayoutParams(layoutParams2);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.awk();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class j extends m {
        private float cFF;
        private float cFG;
        final /* synthetic */ a cFm;

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.cFF = this.cFm.cEw;
            this.cFG = this.cFm.cEC;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void t(float f, float f2) {
            if (this.cFm.mDragState != 4) {
                cancel();
                return;
            }
            this.cFm.cEw = (int) ((this.cFG * f2) + ((1.0f - f2) * this.cFF));
            this.cFm.cEk.y = this.cFm.alS - this.cFm.cEw;
            this.cFm.fJ(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e {
        StringBuilder mBuilder = new StringBuilder();
        private int cFw = 0;
        private int cFx = 0;
        private boolean cFy = false;
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
            this.cFx = 0;
            this.cFy = true;
        }

        public void awu() {
            if (this.cFy) {
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
                this.mBuilder.append("    <FirstExpPos>").append(a.this.cEr).append("</FirstExpPos>\n");
                this.mBuilder.append("    <FirstExpBlankHeight>").append(a.this.kX(a.this.cEr) - a.this.kZ(a.this.cEr)).append("</FirstExpBlankHeight>\n");
                this.mBuilder.append("    <SecondExpPos>").append(a.this.cEs).append("</SecondExpPos>\n");
                this.mBuilder.append("    <SecondExpBlankHeight>").append(a.this.kX(a.this.cEs) - a.this.kZ(a.this.cEs)).append("</SecondExpBlankHeight>\n");
                this.mBuilder.append("    <SrcPos>").append(a.this.cEu).append("</SrcPos>\n");
                this.mBuilder.append("    <SrcHeight>").append(a.this.aIS + a.this.mListView.getDividerHeight()).append("</SrcHeight>\n");
                this.mBuilder.append("    <ViewHeight>").append(a.this.mListView.getHeight()).append("</ViewHeight>\n");
                this.mBuilder.append("    <LastY>").append(a.this.mLastY).append("</LastY>\n");
                this.mBuilder.append("    <FloatY>").append(a.this.cEm).append("</FloatY>\n");
                this.mBuilder.append("    <ShuffleEdges>");
                for (int i4 = 0; i4 < childCount; i4++) {
                    this.mBuilder.append(a.this.al(firstVisiblePosition + i4, a.this.mListView.getChildAt(i4).getTop())).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                this.mBuilder.append("</ShuffleEdges>\n");
                this.mBuilder.append("</DSLVState>\n");
                this.cFw++;
                if (this.cFw > 1000) {
                    flush();
                    this.cFw = 0;
                }
            }
        }

        public void flush() {
            if (this.cFy) {
                try {
                    FileWriter fileWriter = new FileWriter(this.mFile, this.cFx != 0);
                    fileWriter.write(this.mBuilder.toString());
                    this.mBuilder.delete(0, this.mBuilder.length());
                    fileWriter.flush();
                    fileWriter.close();
                    this.cFx++;
                } catch (IOException e) {
                }
            }
        }

        public void nn() {
            if (this.cFy) {
                this.mBuilder.append("</DSLVStates>\n");
                flush();
                this.cFy = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements Runnable {
        private boolean aMB = false;
        private boolean cFp;
        private long cFq;
        private long cFr;
        private float cFs;
        private long cFt;
        private int cFu;
        private float cFv;
        private int dy;

        public boolean aws() {
            return this.aMB;
        }

        public int awt() {
            if (this.aMB) {
                return this.cFu;
            }
            return -1;
        }

        public d() {
        }

        public void la(int i) {
            if (!this.aMB) {
                this.cFp = false;
                this.aMB = true;
                this.cFt = SystemClock.uptimeMillis();
                this.cFq = this.cFt;
                this.cFu = i;
                a.this.mListView.post(this);
            }
        }

        public void fK(boolean z) {
            if (z) {
                a.this.mListView.removeCallbacks(this);
                this.aMB = false;
                return;
            }
            this.cFp = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.cFp) {
                int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
                int lastVisiblePosition = a.this.mListView.getLastVisiblePosition();
                int count = a.this.mListView.getCount();
                int paddingTop = a.this.mListView.getPaddingTop();
                int height = (a.this.mListView.getHeight() - paddingTop) - a.this.mListView.getPaddingBottom();
                int min = Math.min(a.this.alS, a.this.cEm + a.this.cEC);
                int max = Math.max(a.this.alS, a.this.cEm - a.this.cEC);
                if (this.cFu == 0) {
                    View childAt = a.this.mListView.getChildAt(0);
                    if (childAt == null) {
                        this.aMB = false;
                        return;
                    } else if (firstVisiblePosition == 0 && childAt.getTop() == paddingTop) {
                        this.aMB = false;
                        return;
                    } else {
                        this.cFv = a.this.cEO.b((a.this.cEK - max) / a.this.cEL, this.cFq);
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
                        this.cFv = -a.this.cEO.b((min - a.this.cEJ) / a.this.cEM, this.cFq);
                    }
                }
                this.cFr = SystemClock.uptimeMillis();
                this.cFs = (float) (this.cFr - this.cFq);
                this.dy = Math.round(this.cFv * this.cFs);
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
                this.cFq = this.cFr;
                a.this.mListView.post(this);
                return;
            }
            this.aMB = false;
        }
    }
}
