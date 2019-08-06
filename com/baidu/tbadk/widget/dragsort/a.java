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
    private int aJA;
    private int amu;
    private int amv;
    private int anb;
    private int anc;
    private View cFK;
    private int cFN;
    private int cFR;
    private int cFS;
    private int cFT;
    private int cFV;
    private int cFW;
    private int cFX;
    private b cFY;
    private g cFZ;
    private e cGB;
    private k cGE;
    private j cGF;
    private f cGG;
    private boolean cGH;
    private com.baidu.tbadk.widget.dragsort.d cGJ;
    private com.baidu.tbadk.widget.dragsort.b cGK;
    private l cGa;
    private int cGd;
    private d cGf;
    private int cGi;
    private int cGj;
    private float cGk;
    private float cGl;
    private float cGm;
    private float cGn;
    private int cGq;
    private MotionEvent cGv;
    private C0262a cGz;
    private int mLastX;
    private int mLastY;
    private ListView mListView;
    private DataSetObserver mObserver;
    private Point cFL = new Point();
    private Point cFM = new Point();
    private boolean cFO = false;
    private float cFP = 1.0f;
    private float cFQ = 1.0f;
    private boolean cFU = false;
    private boolean cGb = true;
    private int mDragState = 0;
    private int cGc = 1;
    private int mWidthMeasureSpec = 0;
    private View[] cGe = new View[1];
    private float cGg = 0.33333334f;
    private float cGh = 0.33333334f;
    private float cGo = 0.5f;
    private c cGp = new c() { // from class: com.baidu.tbadk.widget.dragsort.a.1
        @Override // com.baidu.tbadk.widget.dragsort.a.c
        public float b(float f2, long j2) {
            return a.this.cGo * f2;
        }
    };
    private int cGr = 0;
    private boolean cGs = false;
    private boolean cGt = false;
    private h cGu = null;
    private int cGw = 0;
    private float cGx = 0.25f;
    private float cGy = 0.0f;
    private boolean cGA = false;
    private boolean mBlockLayoutRequests = false;
    private boolean cGC = false;
    private i cGD = new i(3);
    private float cGI = 0.0f;
    private boolean cGL = false;
    private boolean cGM = false;

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

        void bi(View view);

        View li(int i);
    }

    /* loaded from: classes.dex */
    public interface l {
        void remove(int i);
    }

    public a(ListView listView, com.baidu.tbadk.widget.dragsort.d dVar) {
        this.cGJ = dVar;
        this.mListView = listView;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            this.cGz = new C0262a(listAdapter);
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
            this.cGz = null;
        }
        this.cGJ.setAdapter(this.cGz);
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
            if (i2 > this.cFV) {
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
    public int le(int i2) {
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        return childAt != null ? childAt.getHeight() : aq(i2, lg(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ao(int i2, int i3) {
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        if (i2 <= headerViewsCount || i2 >= this.mListView.getCount() - footerViewsCount) {
            return i3;
        }
        int dividerHeight = this.mListView.getDividerHeight();
        int i4 = this.aJA - this.cGc;
        int lg = lg(i2);
        int le = le(i2);
        if (this.cFT <= this.cFV) {
            if (i2 == this.cFT && this.cFS != this.cFT) {
                if (i2 == this.cFV) {
                    i3 = (i3 + le) - this.aJA;
                } else {
                    i3 = ((le - lg) + i3) - i4;
                }
            } else if (i2 > this.cFT && i2 <= this.cFV) {
                i3 -= i4;
            }
        } else if (i2 > this.cFV && i2 <= this.cFS) {
            i3 += i4;
        } else if (i2 == this.cFT && this.cFS != this.cFT) {
            i3 += le - lg;
        }
        if (i2 <= this.cFV) {
            return (((this.aJA - dividerHeight) - lg(i2 - 1)) / 2) + i3;
        }
        return (((lg - dividerHeight) - this.aJA) / 2) + i3;
    }

    private boolean axu() {
        int i2;
        int i3;
        int i4;
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int i5 = this.cFS;
        View childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        if (childAt == null) {
            i5 = firstVisiblePosition + (this.mListView.getChildCount() / 2);
            childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        }
        int top = childAt.getTop();
        int height = childAt.getHeight();
        int ao = ao(i5, top);
        int dividerHeight = this.mListView.getDividerHeight();
        if (this.cFN >= ao) {
            int count = this.mListView.getCount();
            int i6 = height;
            int i7 = top;
            i2 = ao;
            i3 = i5;
            i4 = ao;
            while (true) {
                if (i3 < count) {
                    if (i3 == count - 1) {
                        i2 = i7 + dividerHeight + i6;
                        break;
                    }
                    i7 += dividerHeight + i6;
                    i6 = le(i3 + 1);
                    i2 = ao(i3 + 1, i7);
                    if (this.cFN < i2) {
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
            i2 = ao;
            i3 = i5;
            i4 = ao;
            while (true) {
                if (i3 < 0) {
                    break;
                }
                i3--;
                int le = le(i3);
                if (i3 == 0) {
                    i2 = (i8 - dividerHeight) - le;
                    break;
                }
                i8 -= le + dividerHeight;
                i2 = ao(i3, i8);
                if (this.cFN >= i2) {
                    break;
                }
                i4 = i2;
            }
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int i9 = this.cFS;
        int i10 = this.cFT;
        float f2 = this.cGy;
        if (this.cFU) {
            int abs = Math.abs(i2 - i4);
            if (this.cFN >= i2) {
                int i11 = i4;
                i4 = i2;
                i2 = i11;
            }
            int i12 = (int) (abs * this.cGx * 0.5f);
            float f3 = i12;
            int i13 = i4 + i12;
            int i14 = i2 - i12;
            if (this.cFN < i13) {
                this.cFS = i3 - 1;
                this.cFT = i3;
                this.cGy = ((i13 - this.cFN) * 0.5f) / f3;
            } else if (this.cFN < i14) {
                this.cFS = i3;
                this.cFT = i3;
            } else {
                this.cFS = i3;
                this.cFT = i3 + 1;
                this.cGy = (1.0f + ((i2 - this.cFN) / f3)) * 0.5f;
            }
        } else {
            this.cFS = i3;
            this.cFT = i3;
        }
        if (this.cFS < headerViewsCount) {
            this.cFS = headerViewsCount;
            this.cFT = headerViewsCount;
            i3 = headerViewsCount;
        } else if (this.cFT >= this.mListView.getCount() - footerViewsCount) {
            i3 = (this.mListView.getCount() - footerViewsCount) - 1;
            this.cFS = i3;
            this.cFT = i3;
        }
        boolean z = (this.cFS == i9 && this.cFT == i10 && this.cGy == f2) ? false : true;
        if (i3 != this.cFR) {
            if (this.cFY != null) {
                this.cFY.drag(this.cFR - headerViewsCount, i3 - headerViewsCount);
            }
            this.cFR = i3;
            return true;
        }
        return z;
    }

    public void removeItem(int i2) {
        this.cGH = false;
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
            this.cGc = Math.max(1, obtainStyledAttributes.getDimensionPixelSize(13, 1));
            this.cGA = obtainStyledAttributes.getBoolean(7, false);
            if (this.cGA) {
                this.cGB = new e();
            }
            this.cFP = obtainStyledAttributes.getFloat(11, this.cFP);
            this.cFQ = this.cFP;
            this.cGb = obtainStyledAttributes.getBoolean(14, this.cGb);
            this.cGx = Math.max(0.0f, Math.min(1.0f, 1.0f - obtainStyledAttributes.getFloat(1, 0.75f)));
            this.cFU = this.cGx > 0.0f;
            setDragScrollStart(obtainStyledAttributes.getFloat(15, this.cGg));
            this.cGo = obtainStyledAttributes.getFloat(0, this.cGo);
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
                bVar.fQ(z);
                bVar.fP(z2);
                bVar.setBackgroundColor(color);
                this.cGu = bVar;
                a(bVar);
            }
            obtainStyledAttributes.recycle();
            i2 = i5;
            i3 = i4;
        }
        this.cGf = new d();
        if (i3 > 0) {
            this.cGE = new k(0.5f, i3);
        }
        if (i2 > 0) {
            this.cGG = new f(0.5f, i2);
        }
        this.cGv = MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
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
        this.cGK = bVar;
        this.mListView.setOnTouchListener(bVar);
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void dispatchDraw(Canvas canvas) {
        float f2;
        this.cGJ.dispatchDraw(canvas);
        if (this.mDragState != 0) {
            if (this.cFS != this.cFV) {
                b(this.cFS, canvas);
            }
            if (this.cFT != this.cFS && this.cFT != this.cFV) {
                b(this.cFT, canvas);
            }
        }
        if (this.cFK != null) {
            int width = this.cFK.getWidth();
            int height = this.cFK.getHeight();
            int i2 = this.cFL.x;
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
            int i3 = (int) (f2 * 255.0f * this.cFQ);
            canvas.save();
            canvas.translate(this.cFL.x, this.cFL.y);
            canvas.clipRect(0, 0, width, height);
            canvas.saveLayerAlpha(0.0f, 0.0f, width, height, i3, 31);
            this.cFK.draw(canvas);
            canvas.restore();
            canvas.restore();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onDraw(Canvas canvas) {
        this.cGJ.onDraw(canvas);
        if (this.cGA) {
            this.cGB.axI();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.cGC) {
            this.cGC = false;
            return false;
        } else if (!this.cGb) {
            return this.cGJ.onTouchEvent(motionEvent);
        } else {
            boolean z2 = this.cGs;
            this.cGs = false;
            if (!z2) {
                y(motionEvent);
            }
            if (this.mDragState == 4) {
                onDragTouchEvent(motionEvent);
                return true;
            }
            if (this.mDragState == 0 && this.cGJ.onTouchEvent(motionEvent)) {
                z = true;
            }
            switch (motionEvent.getAction() & 255) {
                case 1:
                case 3:
                    axz();
                    return z;
                case 2:
                default:
                    if (z) {
                        this.cGw = 1;
                        return z;
                    }
                    return z;
            }
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (!this.cGb) {
            return this.cGJ.onInterceptTouchEvent(motionEvent);
        }
        if (this.cGK != null) {
            this.cGK.axK().onTouchEvent(motionEvent);
        }
        y(motionEvent);
        this.cGs = true;
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            if (this.mDragState != 0) {
                this.cGC = true;
                return true;
            }
            this.cGt = true;
        }
        if (this.cFK == null) {
            if (this.cGJ.onInterceptTouchEvent(motionEvent)) {
                this.cGL = true;
                z = true;
            } else {
                z = false;
            }
            switch (action) {
                case 1:
                case 3:
                    axz();
                    break;
                case 2:
                default:
                    if (z) {
                        this.cGw = 1;
                        break;
                    } else {
                        this.cGw = 2;
                        break;
                    }
            }
        } else {
            z = true;
        }
        if (action == 1 || action == 3) {
            this.cGt = false;
        }
        return z;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        this.cGJ.onSizeChanged(i2, i3, i4, i5);
        axA();
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void requestLayout() {
        if (!this.mBlockLayoutRequests) {
            this.cGJ.requestLayout();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onMeasure(int i2, int i3) {
        this.cGJ.onMeasure(i2, i3);
        if (this.cFK != null) {
            if (this.cFK.isLayoutRequested()) {
                axC();
            }
            this.cFO = true;
        }
        this.mWidthMeasureSpec = i2;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void layoutChildren() {
        this.cGJ.layoutChildren();
        if (this.cFK != null) {
            if (this.cFK.isLayoutRequested() && !this.cFO) {
                axC();
            }
            this.cFK.layout(0, 0, this.cFK.getMeasuredWidth(), this.cFK.getMeasuredHeight());
            this.cFO = false;
        }
    }

    public void removeItem(int i2, float f2) {
        if (this.mDragState == 0 || this.mDragState == 4) {
            if (this.mDragState == 0) {
                this.cFV = this.mListView.getHeaderViewsCount() + i2;
                this.cFS = this.cFV;
                this.cFT = this.cFV;
                this.cFR = this.cFV;
                View childAt = this.mListView.getChildAt(this.cFV - this.mListView.getFirstVisiblePosition());
                if (childAt != null) {
                    childAt.setVisibility(4);
                }
            }
            this.mDragState = 1;
            this.cGI = f2;
            if (this.cGt) {
                switch (this.cGw) {
                    case 1:
                        this.cGJ.onTouchEvent(this.cGv);
                        break;
                    case 2:
                        this.cGJ.onInterceptTouchEvent(this.cGv);
                        break;
                }
            }
            if (this.cGE != null) {
                this.cGE.start();
            } else {
                lf(i2);
            }
        }
    }

    public void cancelDrag() {
        if (this.mDragState == 4) {
            this.cGf.fO(true);
            axE();
            axv();
            axB();
            if (this.cGt) {
                this.mDragState = 3;
            } else {
                this.mDragState = 0;
            }
        }
    }

    private void axv() {
        this.cFV = -1;
        this.cFS = -1;
        this.cFT = -1;
        this.cFR = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axw() {
        this.mDragState = 2;
        if (this.cFZ != null && this.cFR >= 0 && this.cFR < this.mListView.getCount()) {
            int headerViewsCount = this.mListView.getHeaderViewsCount();
            this.cFZ.drop(this.cFV - headerViewsCount, this.cFR - headerViewsCount);
        }
        axE();
        axy();
        axv();
        axB();
        if (this.cGt) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axx() {
        lf(this.cFV - this.mListView.getHeaderViewsCount());
    }

    private void lf(int i2) {
        this.mDragState = 1;
        if (this.cGa != null) {
            this.cGa.remove(i2);
        }
        axE();
        axy();
        axv();
        if (this.cGt) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    private void axy() {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        if (this.cFV < firstVisiblePosition) {
            View childAt = this.mListView.getChildAt(0);
            this.mListView.setSelectionFromTop(firstVisiblePosition - 1, (childAt != null ? childAt.getTop() : 0) - this.mListView.getPaddingTop());
        }
    }

    public boolean stopDrag(boolean z) {
        this.cGH = false;
        return stopDrag(z, 0.0f);
    }

    public boolean stopDragWithVelocity(boolean z, float f2) {
        this.cGH = true;
        return stopDrag(z, f2);
    }

    public boolean stopDrag(boolean z, float f2) {
        if (this.cFK != null) {
            this.cGf.fO(true);
            if (z) {
                removeItem(this.cFV - this.mListView.getHeaderViewsCount(), f2);
            } else if (this.cGG != null) {
                this.cGG.start();
            } else {
                axw();
            }
            if (this.cGA) {
                this.cGB.nF();
                return true;
            }
            return true;
        }
        return false;
    }

    private void axz() {
        this.cGw = 0;
        this.cGt = false;
        if (this.mDragState == 3) {
            this.mDragState = 0;
        }
        this.cFQ = this.cFP;
        this.cGL = false;
        this.cGD.clear();
    }

    private void y(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            this.mLastX = this.amu;
            this.mLastY = this.amv;
        }
        this.amu = (int) motionEvent.getX();
        this.amv = (int) motionEvent.getY();
        if (action == 0) {
            this.mLastX = this.amu;
            this.mLastY = this.amv;
        }
        this.anb = ((int) motionEvent.getRawX()) - this.amu;
        this.anc = ((int) motionEvent.getRawY()) - this.amv;
    }

    public boolean listViewIntercepted() {
        return this.cGL;
    }

    public void setDragScrollStart(float f2) {
        setDragScrollStarts(f2, f2);
    }

    public void setDragScrollStarts(float f2, float f3) {
        if (f3 > 0.5f) {
            this.cGh = 0.5f;
        } else {
            this.cGh = f3;
        }
        if (f2 > 0.5f) {
            this.cGg = 0.5f;
        } else {
            this.cGg = f2;
        }
        if (this.mListView.getHeight() != 0) {
            axA();
        }
    }

    private void ap(int i2, int i3) {
        this.cFL.x = i2 - this.cFW;
        this.cFL.y = i3 - this.cFX;
        fN(true);
        int min = Math.min(i3, this.cFN + this.cGd);
        int max = Math.max(i3, this.cFN - this.cGd);
        int axG = this.cGf.axG();
        if (min > this.mLastY && min > this.cGj && axG != 1) {
            if (axG != -1) {
                this.cGf.fO(true);
            }
            this.cGf.lh(1);
        } else if (max < this.mLastY && max < this.cGi && axG != 0) {
            if (axG != -1) {
                this.cGf.fO(true);
            }
            this.cGf.lh(0);
        } else if (max >= this.cGi && min <= this.cGj && this.cGf.axF()) {
            this.cGf.fO(true);
        }
    }

    private void axA() {
        int height;
        int paddingTop = this.mListView.getPaddingTop();
        float height2 = (this.mListView.getHeight() - paddingTop) - this.mListView.getPaddingBottom();
        this.cGl = paddingTop + (this.cGg * height2);
        this.cGk = (height2 * (1.0f - this.cGh)) + paddingTop;
        this.cGi = (int) this.cGl;
        this.cGj = (int) this.cGk;
        this.cGm = this.cGl - paddingTop;
        this.cGn = (paddingTop + height) - this.cGk;
    }

    private void axB() {
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
        if (i2 != this.cFV && i2 != this.cFS && i2 != this.cFT) {
            g2 = -2;
        } else {
            g2 = g(i2, view, z);
        }
        if (g2 != layoutParams.height) {
            layoutParams.height = g2;
            view.setLayoutParams(layoutParams);
        }
        if (i2 == this.cFS || i2 == this.cFT) {
            if (i2 < this.cFV) {
                ((DragSortItemView) view).setGravity(80);
            } else if (i2 > this.cFV) {
                ((DragSortItemView) view).setGravity(48);
            }
        }
        int visibility = view.getVisibility();
        int i3 = 0;
        if (i2 == this.cFV && this.cFK != null) {
            i3 = 4;
        }
        if (i3 != visibility) {
            view.setVisibility(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int lg(int i2) {
        View view;
        if (i2 == this.cFV) {
            return 0;
        }
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        if (childAt != null) {
            return f(i2, childAt, false);
        }
        int i3 = this.cGD.get(i2);
        if (i3 == -1) {
            ListAdapter adapter = this.mListView.getAdapter();
            int itemViewType = adapter.getItemViewType(i2);
            int viewTypeCount = adapter.getViewTypeCount();
            if (viewTypeCount != this.cGe.length) {
                this.cGe = new View[viewTypeCount];
            }
            if (itemViewType >= 0) {
                if (this.cGe[itemViewType] == null) {
                    view = adapter.getView(i2, null, this.mListView);
                    this.cGe[itemViewType] = view;
                } else {
                    view = adapter.getView(i2, this.cGe[itemViewType], this.mListView);
                }
            } else {
                view = adapter.getView(i2, null, this.mListView);
            }
            int f2 = f(i2, view, true);
            this.cGD.ar(i2, f2);
            return f2;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(int i2, View view, boolean z) {
        if (i2 == this.cFV) {
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
        return aq(i2, f(i2, view, z));
    }

    private int aq(int i2, int i3) {
        this.mListView.getDividerHeight();
        boolean z = this.cFU && this.cFS != this.cFT;
        int i4 = this.aJA - this.cGc;
        int i5 = (int) (this.cGy * i4);
        if (i2 == this.cFV) {
            if (this.cFV == this.cFS) {
                if (z) {
                    return i5 + this.cGc;
                }
                return this.aJA;
            } else if (this.cFV == this.cFT) {
                return this.aJA - i5;
            } else {
                return this.cGc;
            }
        } else if (i2 == this.cFS) {
            if (z) {
                return i3 + i5;
            }
            return i3 + i4;
        } else if (i2 == this.cFT) {
            return (i3 + i4) - i5;
        } else {
            return i3;
        }
    }

    private int b(int i2, View view, int i3, int i4) {
        int i5;
        int i6;
        int lg = lg(i2);
        int height = view.getHeight();
        int aq = aq(i2, lg);
        if (i2 != this.cFV) {
            i6 = height - lg;
            i5 = aq - lg;
        } else {
            i5 = aq;
            i6 = height;
        }
        int i7 = this.aJA;
        if (this.cFV != this.cFS && this.cFV != this.cFT) {
            i7 -= this.cGc;
        }
        if (i2 <= i3) {
            if (i2 > this.cFS) {
                return (i7 - i5) + 0;
            }
        } else if (i2 == i4) {
            if (i2 <= this.cFS) {
                return (i6 - i7) + 0;
            }
            if (i2 == this.cFT) {
                return (height - aq) + 0;
            }
            return 0 + i6;
        } else if (i2 <= this.cFS) {
            return 0 - i7;
        } else {
            if (i2 == this.cFT) {
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

    private void axC() {
        if (this.cFK != null) {
            measureItem(this.cFK);
            this.aJA = this.cFK.getMeasuredHeight();
            this.cGd = this.aJA / 2;
        }
    }

    protected boolean onDragTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        switch (motionEvent.getAction() & 255) {
            case 1:
                if (this.mDragState == 4) {
                    stopDrag(false);
                }
                axz();
                return true;
            case 2:
                ap((int) motionEvent.getX(), (int) motionEvent.getY());
                return true;
            case 3:
                if (this.mDragState == 4) {
                    cancelDrag();
                }
                axz();
                return true;
            default:
                return true;
        }
    }

    public boolean startDrag(int i2, int i3, int i4, int i5) {
        View li;
        if (!this.cGt || this.cGu == null || (li = this.cGu.li(i2)) == null) {
            return false;
        }
        return startDrag(i2, li, i3, i4, i5);
    }

    public boolean startDrag(int i2, View view, int i3, int i4, int i5) {
        if (this.mDragState == 0 && this.cGt && this.cFK == null && view != null && this.cGb) {
            if (this.mListView.getParent() != null) {
                this.mListView.getParent().requestDisallowInterceptTouchEvent(true);
            }
            int headerViewsCount = this.mListView.getHeaderViewsCount() + i2;
            this.cFS = headerViewsCount;
            this.cFT = headerViewsCount;
            this.cFV = headerViewsCount;
            this.cFR = headerViewsCount;
            this.mDragState = 4;
            this.cGr = 0;
            this.cGr |= i3;
            this.cFK = view;
            axC();
            this.cFW = i4;
            this.cFX = i5;
            this.cGq = this.amv;
            this.cFL.x = this.amu - this.cFW;
            this.cFL.y = this.amv - this.cFX;
            View childAt = this.mListView.getChildAt(this.cFV - this.mListView.getFirstVisiblePosition());
            if (childAt != null) {
                childAt.setVisibility(4);
            }
            if (this.cGA) {
                this.cGB.axH();
            }
            switch (this.cGw) {
                case 1:
                    this.cGJ.onTouchEvent(this.cGv);
                    break;
                case 2:
                    this.cGJ.onInterceptTouchEvent(this.cGv);
                    break;
            }
            this.mListView.requestLayout();
            if (this.cGF != null) {
                this.cGF.start();
                return true;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fN(boolean z) {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition() + (this.mListView.getChildCount() / 2);
        View childAt = this.mListView.getChildAt(this.mListView.getChildCount() / 2);
        if (childAt != null) {
            h(firstVisiblePosition, childAt, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i2, View view, boolean z) {
        this.mBlockLayoutRequests = true;
        axD();
        int i3 = this.cFS;
        int i4 = this.cFT;
        boolean axu = axu();
        if (axu) {
            axB();
            this.mListView.setSelectionFromTop(i2, (b(i2, view, i3, i4) + view.getTop()) - this.mListView.getPaddingTop());
            layoutChildren();
        }
        if (axu || z) {
            this.mListView.invalidate();
        }
        this.mBlockLayoutRequests = false;
    }

    private void axD() {
        if (this.cGu != null) {
            this.cFM.set(this.amu, this.amv);
            this.cGu.b(this.cFK, this.cFL, this.cFM);
        }
        int i2 = this.cFL.x;
        int i3 = this.cFL.y;
        int paddingLeft = this.mListView.getPaddingLeft();
        if ((this.cGr & 1) == 0 && i2 > paddingLeft) {
            this.cFL.x = paddingLeft;
        } else if ((this.cGr & 2) == 0 && i2 < paddingLeft) {
            this.cFL.x = paddingLeft;
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int lastVisiblePosition = this.mListView.getLastVisiblePosition();
        int paddingTop = this.mListView.getPaddingTop();
        if (firstVisiblePosition < headerViewsCount) {
            paddingTop = this.mListView.getChildAt((headerViewsCount - firstVisiblePosition) - 1).getBottom();
        }
        if ((this.cGr & 8) == 0 && firstVisiblePosition <= this.cFV) {
            paddingTop = Math.max(this.mListView.getChildAt(this.cFV - firstVisiblePosition).getTop(), paddingTop);
        }
        int height = this.mListView.getHeight() - this.mListView.getPaddingBottom();
        if (lastVisiblePosition >= (this.mListView.getCount() - footerViewsCount) - 1) {
            height = this.mListView.getChildAt(((this.mListView.getCount() - footerViewsCount) - 1) - firstVisiblePosition).getBottom();
        }
        if ((this.cGr & 4) == 0 && lastVisiblePosition >= this.cFV) {
            height = Math.min(this.mListView.getChildAt(this.cFV - firstVisiblePosition).getBottom(), height);
        }
        if (i3 < paddingTop) {
            this.cFL.y = paddingTop;
        } else if (this.aJA + i3 > height) {
            this.cFL.y = height - this.aJA;
        }
        this.cFN = this.cFL.y + this.cGd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axE() {
        if (this.cFK != null) {
            this.cFK.setVisibility(8);
            if (this.cGu != null) {
                this.cGu.bi(this.cFK);
            }
            this.cFK = null;
            this.mListView.invalidate();
        }
    }

    public void a(h hVar) {
        this.cGu = hVar;
    }

    public void a(b bVar) {
        this.cFY = bVar;
    }

    public void setDragEnabled(boolean z) {
        this.cGb = z;
    }

    public boolean isDragEnabled() {
        return this.cGb;
    }

    public void a(g gVar) {
        this.cFZ = gVar;
    }

    public void a(l lVar) {
        this.cGa = lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class i {
        private SparseIntArray cHe;
        private ArrayList<Integer> cHf;
        private int mMaxSize;

        public i(int i) {
            this.cHe = new SparseIntArray(i);
            this.cHf = new ArrayList<>(i);
            this.mMaxSize = i;
        }

        public void ar(int i, int i2) {
            int i3 = this.cHe.get(i, -1);
            if (i3 != i2) {
                if (i3 == -1) {
                    if (this.cHe.size() == this.mMaxSize) {
                        this.cHe.delete(this.cHf.remove(0).intValue());
                    }
                } else {
                    this.cHf.remove(Integer.valueOf(i));
                }
                this.cHe.put(i, i2);
                this.cHf.add(Integer.valueOf(i));
            }
        }

        public int get(int i) {
            return this.cHe.get(i, -1);
        }

        public void clear() {
            this.cHe.clear();
            this.cHf.clear();
        }
    }

    /* renamed from: com.baidu.tbadk.widget.dragsort.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0262a extends BaseAdapter {
        private ListAdapter mAdapter;

        public C0262a(ListAdapter listAdapter) {
            this.mAdapter = listAdapter;
            this.mAdapter.registerDataSetObserver(new DataSetObserver() { // from class: com.baidu.tbadk.widget.dragsort.a.a.1
                @Override // android.database.DataSetObserver
                public void onChanged() {
                    C0262a.this.notifyDataSetChanged();
                }

                @Override // android.database.DataSetObserver
                public void onInvalidated() {
                    C0262a.this.notifyDataSetInvalidated();
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
        private float Ha;
        private float amV;
        private float amW;
        private float amX;
        private float amY;
        private float cHp;
        private boolean mCanceled;
        protected long mStartTime;

        public m(float f, int i) {
            this.Ha = f;
            this.cHp = i;
            float f2 = 1.0f / ((this.Ha * 2.0f) * (1.0f - this.Ha));
            this.amY = f2;
            this.amV = f2;
            this.amW = this.Ha / ((this.Ha - 1.0f) * 2.0f);
            this.amX = 1.0f / (1.0f - this.Ha);
        }

        public float aq(float f) {
            if (f < this.Ha) {
                return this.amV * f * f;
            }
            if (f < 1.0f - this.Ha) {
                return this.amW + (this.amX * f);
            }
            return 1.0f - ((this.amY * (f - 1.0f)) * (f - 1.0f));
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
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / this.cHp;
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
        private int cHa;
        private int cHb;
        private float cHc;
        private float cHd;

        public f(float f, int i) {
            super(f, i);
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.cHa = a.this.cFR;
            this.cHb = a.this.cFV;
            a.this.mDragState = 2;
            this.cHc = a.this.cFL.y - axJ();
            this.cHd = a.this.cFL.x - a.this.mListView.getPaddingLeft();
        }

        private int axJ() {
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            int dividerHeight = (a.this.cGc + a.this.mListView.getDividerHeight()) / 2;
            View childAt = a.this.mListView.getChildAt(this.cHa - firstVisiblePosition);
            if (childAt != null) {
                if (this.cHa == this.cHb) {
                    return childAt.getTop();
                }
                if (this.cHa >= this.cHb) {
                    return (childAt.getBottom() + dividerHeight) - a.this.aJA;
                }
                return childAt.getTop() - dividerHeight;
            }
            cancel();
            return -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void t(float f, float f2) {
            int axJ = axJ();
            float paddingLeft = a.this.cFL.x - a.this.mListView.getPaddingLeft();
            float f3 = 1.0f - f2;
            if (f3 < Math.abs((a.this.cFL.y - axJ) / this.cHc) || f3 < Math.abs(paddingLeft / this.cHd)) {
                a.this.cFL.y = axJ + ((int) (this.cHc * f3));
                a.this.cFL.x = a.this.mListView.getPaddingLeft() + ((int) (this.cHd * f3));
                a.this.fN(true);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.axw();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class k extends m {
        private int cHb;
        private float cHi;
        private float cHj;
        private float cHk;
        private int cHl;
        private int cHm;
        private int cHn;
        private int cHo;

        public k(float f, int i) {
            super(f, i);
            this.cHl = -1;
            this.cHm = -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.cHl = -1;
            this.cHm = -1;
            this.cHn = a.this.cFS;
            this.cHo = a.this.cFT;
            this.cHb = a.this.cFV;
            a.this.mDragState = 1;
            this.cHi = a.this.cFL.x;
            if (a.this.cGH) {
                float width = a.this.mListView.getWidth() * 2.0f;
                if (a.this.cGI == 0.0f) {
                    a.this.cGI = (this.cHi >= 0.0f ? 1 : -1) * width;
                    return;
                }
                float f = width * 2.0f;
                if (a.this.cGI >= 0.0f || a.this.cGI <= (-f)) {
                    if (a.this.cGI > 0.0f && a.this.cGI < f) {
                        a.this.cGI = f;
                        return;
                    }
                    return;
                }
                a.this.cGI = -f;
                return;
            }
            a.this.axE();
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void t(float f, float f2) {
            View childAt;
            float f3 = 1.0f - f2;
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            View childAt2 = a.this.mListView.getChildAt(this.cHn - firstVisiblePosition);
            if (a.this.cGH) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / 1000.0f;
                if (uptimeMillis != 0.0f) {
                    float f4 = a.this.cGI * uptimeMillis;
                    int width = a.this.mListView.getWidth();
                    a.this.cGI = ((a.this.cGI > 0.0f ? 1 : -1) * uptimeMillis * width) + a.this.cGI;
                    this.cHi += f4;
                    a.this.cFL.x = (int) this.cHi;
                    if (this.cHi < width && this.cHi > (-width)) {
                        this.mStartTime = SystemClock.uptimeMillis();
                        a.this.fN(true);
                        return;
                    }
                } else {
                    return;
                }
            }
            if (childAt2 != null) {
                if (this.cHl == -1) {
                    this.cHl = a.this.f(this.cHn, childAt2, false);
                    this.cHj = childAt2.getHeight() - this.cHl;
                }
                int max = Math.max((int) (this.cHj * f3), 1);
                ViewGroup.LayoutParams layoutParams = childAt2.getLayoutParams();
                layoutParams.height = max + this.cHl;
                childAt2.setLayoutParams(layoutParams);
            }
            if (this.cHo != this.cHn && (childAt = a.this.mListView.getChildAt(this.cHo - firstVisiblePosition)) != null) {
                if (this.cHm == -1) {
                    this.cHm = a.this.f(this.cHo, childAt, false);
                    this.cHk = childAt.getHeight() - this.cHm;
                }
                int max2 = Math.max((int) (this.cHk * f3), 1);
                ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
                layoutParams2.height = max2 + this.cHm;
                childAt.setLayoutParams(layoutParams2);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.axx();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class j extends m {
        final /* synthetic */ a cGN;
        private float cHg;
        private float cHh;

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.cHg = this.cGN.cFX;
            this.cHh = this.cGN.cGd;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void t(float f, float f2) {
            if (this.cGN.mDragState != 4) {
                cancel();
                return;
            }
            this.cGN.cFX = (int) ((this.cHh * f2) + ((1.0f - f2) * this.cHg));
            this.cGN.cFL.y = this.cGN.amv - this.cGN.cFX;
            this.cGN.fN(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e {
        StringBuilder mBuilder = new StringBuilder();
        private int cGX = 0;
        private int cGY = 0;
        private boolean cGZ = false;
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

        public void axH() {
            this.mBuilder.append("<DSLVStates>\n");
            this.cGY = 0;
            this.cGZ = true;
        }

        public void axI() {
            if (this.cGZ) {
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
                this.mBuilder.append("    <FirstExpPos>").append(a.this.cFS).append("</FirstExpPos>\n");
                this.mBuilder.append("    <FirstExpBlankHeight>").append(a.this.le(a.this.cFS) - a.this.lg(a.this.cFS)).append("</FirstExpBlankHeight>\n");
                this.mBuilder.append("    <SecondExpPos>").append(a.this.cFT).append("</SecondExpPos>\n");
                this.mBuilder.append("    <SecondExpBlankHeight>").append(a.this.le(a.this.cFT) - a.this.lg(a.this.cFT)).append("</SecondExpBlankHeight>\n");
                this.mBuilder.append("    <SrcPos>").append(a.this.cFV).append("</SrcPos>\n");
                this.mBuilder.append("    <SrcHeight>").append(a.this.aJA + a.this.mListView.getDividerHeight()).append("</SrcHeight>\n");
                this.mBuilder.append("    <ViewHeight>").append(a.this.mListView.getHeight()).append("</ViewHeight>\n");
                this.mBuilder.append("    <LastY>").append(a.this.mLastY).append("</LastY>\n");
                this.mBuilder.append("    <FloatY>").append(a.this.cFN).append("</FloatY>\n");
                this.mBuilder.append("    <ShuffleEdges>");
                for (int i4 = 0; i4 < childCount; i4++) {
                    this.mBuilder.append(a.this.ao(firstVisiblePosition + i4, a.this.mListView.getChildAt(i4).getTop())).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                this.mBuilder.append("</ShuffleEdges>\n");
                this.mBuilder.append("</DSLVState>\n");
                this.cGX++;
                if (this.cGX > 1000) {
                    flush();
                    this.cGX = 0;
                }
            }
        }

        public void flush() {
            if (this.cGZ) {
                try {
                    FileWriter fileWriter = new FileWriter(this.mFile, this.cGY != 0);
                    fileWriter.write(this.mBuilder.toString());
                    this.mBuilder.delete(0, this.mBuilder.length());
                    fileWriter.flush();
                    fileWriter.close();
                    this.cGY++;
                } catch (IOException e) {
                }
            }
        }

        public void nF() {
            if (this.cGZ) {
                this.mBuilder.append("</DSLVStates>\n");
                flush();
                this.cGZ = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements Runnable {
        private boolean aNk = false;
        private boolean cGQ;
        private long cGR;
        private long cGS;
        private float cGT;
        private long cGU;
        private int cGV;
        private float cGW;
        private int dy;

        public boolean axF() {
            return this.aNk;
        }

        public int axG() {
            if (this.aNk) {
                return this.cGV;
            }
            return -1;
        }

        public d() {
        }

        public void lh(int i) {
            if (!this.aNk) {
                this.cGQ = false;
                this.aNk = true;
                this.cGU = SystemClock.uptimeMillis();
                this.cGR = this.cGU;
                this.cGV = i;
                a.this.mListView.post(this);
            }
        }

        public void fO(boolean z) {
            if (z) {
                a.this.mListView.removeCallbacks(this);
                this.aNk = false;
                return;
            }
            this.cGQ = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.cGQ) {
                int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
                int lastVisiblePosition = a.this.mListView.getLastVisiblePosition();
                int count = a.this.mListView.getCount();
                int paddingTop = a.this.mListView.getPaddingTop();
                int height = (a.this.mListView.getHeight() - paddingTop) - a.this.mListView.getPaddingBottom();
                int min = Math.min(a.this.amv, a.this.cFN + a.this.cGd);
                int max = Math.max(a.this.amv, a.this.cFN - a.this.cGd);
                if (this.cGV == 0) {
                    View childAt = a.this.mListView.getChildAt(0);
                    if (childAt == null) {
                        this.aNk = false;
                        return;
                    } else if (firstVisiblePosition == 0 && childAt.getTop() == paddingTop) {
                        this.aNk = false;
                        return;
                    } else {
                        this.cGW = a.this.cGp.b((a.this.cGl - max) / a.this.cGm, this.cGR);
                    }
                } else {
                    View childAt2 = a.this.mListView.getChildAt(lastVisiblePosition - firstVisiblePosition);
                    if (childAt2 == null) {
                        this.aNk = false;
                        return;
                    } else if (lastVisiblePosition == count - 1 && childAt2.getBottom() <= height + paddingTop) {
                        this.aNk = false;
                        return;
                    } else {
                        this.cGW = -a.this.cGp.b((min - a.this.cGk) / a.this.cGn, this.cGR);
                    }
                }
                this.cGS = SystemClock.uptimeMillis();
                this.cGT = (float) (this.cGS - this.cGR);
                this.dy = Math.round(this.cGW * this.cGT);
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
                this.cGR = this.cGS;
                a.this.mListView.post(this);
                return;
            }
            this.aNk = false;
        }
    }
}
