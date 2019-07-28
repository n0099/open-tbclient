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
    private View cFD;
    private int cFG;
    private int cFK;
    private int cFL;
    private int cFM;
    private int cFO;
    private int cFP;
    private int cFQ;
    private b cFR;
    private g cFS;
    private l cFT;
    private int cFW;
    private d cFY;
    private boolean cGA;
    private com.baidu.tbadk.widget.dragsort.d cGC;
    private com.baidu.tbadk.widget.dragsort.b cGD;
    private int cGb;
    private int cGc;
    private float cGd;
    private float cGe;
    private float cGf;
    private float cGg;
    private int cGj;
    private MotionEvent cGo;
    private C0262a cGs;
    private e cGu;
    private k cGx;
    private j cGy;
    private f cGz;
    private int mLastX;
    private int mLastY;
    private ListView mListView;
    private DataSetObserver mObserver;
    private Point cFE = new Point();
    private Point cFF = new Point();
    private boolean cFH = false;
    private float cFI = 1.0f;
    private float cFJ = 1.0f;
    private boolean cFN = false;
    private boolean cFU = true;
    private int mDragState = 0;
    private int cFV = 1;
    private int mWidthMeasureSpec = 0;
    private View[] cFX = new View[1];
    private float cFZ = 0.33333334f;
    private float cGa = 0.33333334f;
    private float cGh = 0.5f;
    private c cGi = new c() { // from class: com.baidu.tbadk.widget.dragsort.a.1
        @Override // com.baidu.tbadk.widget.dragsort.a.c
        public float b(float f2, long j2) {
            return a.this.cGh * f2;
        }
    };
    private int cGk = 0;
    private boolean cGl = false;
    private boolean cGm = false;
    private h cGn = null;
    private int cGp = 0;
    private float cGq = 0.25f;
    private float cGr = 0.0f;
    private boolean cGt = false;
    private boolean mBlockLayoutRequests = false;
    private boolean cGv = false;
    private i cGw = new i(3);
    private float cGB = 0.0f;
    private boolean cGE = false;
    private boolean cGF = false;

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

        View lh(int i);
    }

    /* loaded from: classes.dex */
    public interface l {
        void remove(int i);
    }

    public a(ListView listView, com.baidu.tbadk.widget.dragsort.d dVar) {
        this.cGC = dVar;
        this.mListView = listView;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            this.cGs = new C0262a(listAdapter);
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
            this.cGs = null;
        }
        this.cGC.setAdapter(this.cGs);
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
            if (i2 > this.cFO) {
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
    public int ld(int i2) {
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        return childAt != null ? childAt.getHeight() : aq(i2, lf(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ao(int i2, int i3) {
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        if (i2 <= headerViewsCount || i2 >= this.mListView.getCount() - footerViewsCount) {
            return i3;
        }
        int dividerHeight = this.mListView.getDividerHeight();
        int i4 = this.aJA - this.cFV;
        int lf = lf(i2);
        int ld = ld(i2);
        if (this.cFM <= this.cFO) {
            if (i2 == this.cFM && this.cFL != this.cFM) {
                if (i2 == this.cFO) {
                    i3 = (i3 + ld) - this.aJA;
                } else {
                    i3 = ((ld - lf) + i3) - i4;
                }
            } else if (i2 > this.cFM && i2 <= this.cFO) {
                i3 -= i4;
            }
        } else if (i2 > this.cFO && i2 <= this.cFL) {
            i3 += i4;
        } else if (i2 == this.cFM && this.cFL != this.cFM) {
            i3 += ld - lf;
        }
        if (i2 <= this.cFO) {
            return (((this.aJA - dividerHeight) - lf(i2 - 1)) / 2) + i3;
        }
        return (((lf - dividerHeight) - this.aJA) / 2) + i3;
    }

    private boolean axs() {
        int i2;
        int i3;
        int i4;
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int i5 = this.cFL;
        View childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        if (childAt == null) {
            i5 = firstVisiblePosition + (this.mListView.getChildCount() / 2);
            childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        }
        int top = childAt.getTop();
        int height = childAt.getHeight();
        int ao = ao(i5, top);
        int dividerHeight = this.mListView.getDividerHeight();
        if (this.cFG >= ao) {
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
                    i6 = ld(i3 + 1);
                    i2 = ao(i3 + 1, i7);
                    if (this.cFG < i2) {
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
                int ld = ld(i3);
                if (i3 == 0) {
                    i2 = (i8 - dividerHeight) - ld;
                    break;
                }
                i8 -= ld + dividerHeight;
                i2 = ao(i3, i8);
                if (this.cFG >= i2) {
                    break;
                }
                i4 = i2;
            }
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int i9 = this.cFL;
        int i10 = this.cFM;
        float f2 = this.cGr;
        if (this.cFN) {
            int abs = Math.abs(i2 - i4);
            if (this.cFG >= i2) {
                int i11 = i4;
                i4 = i2;
                i2 = i11;
            }
            int i12 = (int) (abs * this.cGq * 0.5f);
            float f3 = i12;
            int i13 = i4 + i12;
            int i14 = i2 - i12;
            if (this.cFG < i13) {
                this.cFL = i3 - 1;
                this.cFM = i3;
                this.cGr = ((i13 - this.cFG) * 0.5f) / f3;
            } else if (this.cFG < i14) {
                this.cFL = i3;
                this.cFM = i3;
            } else {
                this.cFL = i3;
                this.cFM = i3 + 1;
                this.cGr = (1.0f + ((i2 - this.cFG) / f3)) * 0.5f;
            }
        } else {
            this.cFL = i3;
            this.cFM = i3;
        }
        if (this.cFL < headerViewsCount) {
            this.cFL = headerViewsCount;
            this.cFM = headerViewsCount;
            i3 = headerViewsCount;
        } else if (this.cFM >= this.mListView.getCount() - footerViewsCount) {
            i3 = (this.mListView.getCount() - footerViewsCount) - 1;
            this.cFL = i3;
            this.cFM = i3;
        }
        boolean z = (this.cFL == i9 && this.cFM == i10 && this.cGr == f2) ? false : true;
        if (i3 != this.cFK) {
            if (this.cFR != null) {
                this.cFR.drag(this.cFK - headerViewsCount, i3 - headerViewsCount);
            }
            this.cFK = i3;
            return true;
        }
        return z;
    }

    public void removeItem(int i2) {
        this.cGA = false;
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
            this.cFV = Math.max(1, obtainStyledAttributes.getDimensionPixelSize(13, 1));
            this.cGt = obtainStyledAttributes.getBoolean(7, false);
            if (this.cGt) {
                this.cGu = new e();
            }
            this.cFI = obtainStyledAttributes.getFloat(11, this.cFI);
            this.cFJ = this.cFI;
            this.cFU = obtainStyledAttributes.getBoolean(14, this.cFU);
            this.cGq = Math.max(0.0f, Math.min(1.0f, 1.0f - obtainStyledAttributes.getFloat(1, 0.75f)));
            this.cFN = this.cGq > 0.0f;
            setDragScrollStart(obtainStyledAttributes.getFloat(15, this.cFZ));
            this.cGh = obtainStyledAttributes.getFloat(0, this.cGh);
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
                this.cGn = bVar;
                a(bVar);
            }
            obtainStyledAttributes.recycle();
            i2 = i5;
            i3 = i4;
        }
        this.cFY = new d();
        if (i3 > 0) {
            this.cGx = new k(0.5f, i3);
        }
        if (i2 > 0) {
            this.cGz = new f(0.5f, i2);
        }
        this.cGo = MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
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
        this.cGD = bVar;
        this.mListView.setOnTouchListener(bVar);
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void dispatchDraw(Canvas canvas) {
        float f2;
        this.cGC.dispatchDraw(canvas);
        if (this.mDragState != 0) {
            if (this.cFL != this.cFO) {
                b(this.cFL, canvas);
            }
            if (this.cFM != this.cFL && this.cFM != this.cFO) {
                b(this.cFM, canvas);
            }
        }
        if (this.cFD != null) {
            int width = this.cFD.getWidth();
            int height = this.cFD.getHeight();
            int i2 = this.cFE.x;
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
            int i3 = (int) (f2 * 255.0f * this.cFJ);
            canvas.save();
            canvas.translate(this.cFE.x, this.cFE.y);
            canvas.clipRect(0, 0, width, height);
            canvas.saveLayerAlpha(0.0f, 0.0f, width, height, i3, 31);
            this.cFD.draw(canvas);
            canvas.restore();
            canvas.restore();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onDraw(Canvas canvas) {
        this.cGC.onDraw(canvas);
        if (this.cGt) {
            this.cGu.axG();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.cGv) {
            this.cGv = false;
            return false;
        } else if (!this.cFU) {
            return this.cGC.onTouchEvent(motionEvent);
        } else {
            boolean z2 = this.cGl;
            this.cGl = false;
            if (!z2) {
                y(motionEvent);
            }
            if (this.mDragState == 4) {
                onDragTouchEvent(motionEvent);
                return true;
            }
            if (this.mDragState == 0 && this.cGC.onTouchEvent(motionEvent)) {
                z = true;
            }
            switch (motionEvent.getAction() & 255) {
                case 1:
                case 3:
                    axx();
                    return z;
                case 2:
                default:
                    if (z) {
                        this.cGp = 1;
                        return z;
                    }
                    return z;
            }
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (!this.cFU) {
            return this.cGC.onInterceptTouchEvent(motionEvent);
        }
        if (this.cGD != null) {
            this.cGD.axI().onTouchEvent(motionEvent);
        }
        y(motionEvent);
        this.cGl = true;
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            if (this.mDragState != 0) {
                this.cGv = true;
                return true;
            }
            this.cGm = true;
        }
        if (this.cFD == null) {
            if (this.cGC.onInterceptTouchEvent(motionEvent)) {
                this.cGE = true;
                z = true;
            } else {
                z = false;
            }
            switch (action) {
                case 1:
                case 3:
                    axx();
                    break;
                case 2:
                default:
                    if (z) {
                        this.cGp = 1;
                        break;
                    } else {
                        this.cGp = 2;
                        break;
                    }
            }
        } else {
            z = true;
        }
        if (action == 1 || action == 3) {
            this.cGm = false;
        }
        return z;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        this.cGC.onSizeChanged(i2, i3, i4, i5);
        axy();
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void requestLayout() {
        if (!this.mBlockLayoutRequests) {
            this.cGC.requestLayout();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onMeasure(int i2, int i3) {
        this.cGC.onMeasure(i2, i3);
        if (this.cFD != null) {
            if (this.cFD.isLayoutRequested()) {
                axA();
            }
            this.cFH = true;
        }
        this.mWidthMeasureSpec = i2;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void layoutChildren() {
        this.cGC.layoutChildren();
        if (this.cFD != null) {
            if (this.cFD.isLayoutRequested() && !this.cFH) {
                axA();
            }
            this.cFD.layout(0, 0, this.cFD.getMeasuredWidth(), this.cFD.getMeasuredHeight());
            this.cFH = false;
        }
    }

    public void removeItem(int i2, float f2) {
        if (this.mDragState == 0 || this.mDragState == 4) {
            if (this.mDragState == 0) {
                this.cFO = this.mListView.getHeaderViewsCount() + i2;
                this.cFL = this.cFO;
                this.cFM = this.cFO;
                this.cFK = this.cFO;
                View childAt = this.mListView.getChildAt(this.cFO - this.mListView.getFirstVisiblePosition());
                if (childAt != null) {
                    childAt.setVisibility(4);
                }
            }
            this.mDragState = 1;
            this.cGB = f2;
            if (this.cGm) {
                switch (this.cGp) {
                    case 1:
                        this.cGC.onTouchEvent(this.cGo);
                        break;
                    case 2:
                        this.cGC.onInterceptTouchEvent(this.cGo);
                        break;
                }
            }
            if (this.cGx != null) {
                this.cGx.start();
            } else {
                le(i2);
            }
        }
    }

    public void cancelDrag() {
        if (this.mDragState == 4) {
            this.cFY.fO(true);
            axC();
            axt();
            axz();
            if (this.cGm) {
                this.mDragState = 3;
            } else {
                this.mDragState = 0;
            }
        }
    }

    private void axt() {
        this.cFO = -1;
        this.cFL = -1;
        this.cFM = -1;
        this.cFK = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axu() {
        this.mDragState = 2;
        if (this.cFS != null && this.cFK >= 0 && this.cFK < this.mListView.getCount()) {
            int headerViewsCount = this.mListView.getHeaderViewsCount();
            this.cFS.drop(this.cFO - headerViewsCount, this.cFK - headerViewsCount);
        }
        axC();
        axw();
        axt();
        axz();
        if (this.cGm) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axv() {
        le(this.cFO - this.mListView.getHeaderViewsCount());
    }

    private void le(int i2) {
        this.mDragState = 1;
        if (this.cFT != null) {
            this.cFT.remove(i2);
        }
        axC();
        axw();
        axt();
        if (this.cGm) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    private void axw() {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        if (this.cFO < firstVisiblePosition) {
            View childAt = this.mListView.getChildAt(0);
            this.mListView.setSelectionFromTop(firstVisiblePosition - 1, (childAt != null ? childAt.getTop() : 0) - this.mListView.getPaddingTop());
        }
    }

    public boolean stopDrag(boolean z) {
        this.cGA = false;
        return stopDrag(z, 0.0f);
    }

    public boolean stopDragWithVelocity(boolean z, float f2) {
        this.cGA = true;
        return stopDrag(z, f2);
    }

    public boolean stopDrag(boolean z, float f2) {
        if (this.cFD != null) {
            this.cFY.fO(true);
            if (z) {
                removeItem(this.cFO - this.mListView.getHeaderViewsCount(), f2);
            } else if (this.cGz != null) {
                this.cGz.start();
            } else {
                axu();
            }
            if (this.cGt) {
                this.cGu.nF();
                return true;
            }
            return true;
        }
        return false;
    }

    private void axx() {
        this.cGp = 0;
        this.cGm = false;
        if (this.mDragState == 3) {
            this.mDragState = 0;
        }
        this.cFJ = this.cFI;
        this.cGE = false;
        this.cGw.clear();
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
        return this.cGE;
    }

    public void setDragScrollStart(float f2) {
        setDragScrollStarts(f2, f2);
    }

    public void setDragScrollStarts(float f2, float f3) {
        if (f3 > 0.5f) {
            this.cGa = 0.5f;
        } else {
            this.cGa = f3;
        }
        if (f2 > 0.5f) {
            this.cFZ = 0.5f;
        } else {
            this.cFZ = f2;
        }
        if (this.mListView.getHeight() != 0) {
            axy();
        }
    }

    private void ap(int i2, int i3) {
        this.cFE.x = i2 - this.cFP;
        this.cFE.y = i3 - this.cFQ;
        fN(true);
        int min = Math.min(i3, this.cFG + this.cFW);
        int max = Math.max(i3, this.cFG - this.cFW);
        int axE = this.cFY.axE();
        if (min > this.mLastY && min > this.cGc && axE != 1) {
            if (axE != -1) {
                this.cFY.fO(true);
            }
            this.cFY.lg(1);
        } else if (max < this.mLastY && max < this.cGb && axE != 0) {
            if (axE != -1) {
                this.cFY.fO(true);
            }
            this.cFY.lg(0);
        } else if (max >= this.cGb && min <= this.cGc && this.cFY.axD()) {
            this.cFY.fO(true);
        }
    }

    private void axy() {
        int height;
        int paddingTop = this.mListView.getPaddingTop();
        float height2 = (this.mListView.getHeight() - paddingTop) - this.mListView.getPaddingBottom();
        this.cGe = paddingTop + (this.cFZ * height2);
        this.cGd = (height2 * (1.0f - this.cGa)) + paddingTop;
        this.cGb = (int) this.cGe;
        this.cGc = (int) this.cGd;
        this.cGf = this.cGe - paddingTop;
        this.cGg = (paddingTop + height) - this.cGd;
    }

    private void axz() {
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
        if (i2 != this.cFO && i2 != this.cFL && i2 != this.cFM) {
            g2 = -2;
        } else {
            g2 = g(i2, view, z);
        }
        if (g2 != layoutParams.height) {
            layoutParams.height = g2;
            view.setLayoutParams(layoutParams);
        }
        if (i2 == this.cFL || i2 == this.cFM) {
            if (i2 < this.cFO) {
                ((DragSortItemView) view).setGravity(80);
            } else if (i2 > this.cFO) {
                ((DragSortItemView) view).setGravity(48);
            }
        }
        int visibility = view.getVisibility();
        int i3 = 0;
        if (i2 == this.cFO && this.cFD != null) {
            i3 = 4;
        }
        if (i3 != visibility) {
            view.setVisibility(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int lf(int i2) {
        View view;
        if (i2 == this.cFO) {
            return 0;
        }
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        if (childAt != null) {
            return f(i2, childAt, false);
        }
        int i3 = this.cGw.get(i2);
        if (i3 == -1) {
            ListAdapter adapter = this.mListView.getAdapter();
            int itemViewType = adapter.getItemViewType(i2);
            int viewTypeCount = adapter.getViewTypeCount();
            if (viewTypeCount != this.cFX.length) {
                this.cFX = new View[viewTypeCount];
            }
            if (itemViewType >= 0) {
                if (this.cFX[itemViewType] == null) {
                    view = adapter.getView(i2, null, this.mListView);
                    this.cFX[itemViewType] = view;
                } else {
                    view = adapter.getView(i2, this.cFX[itemViewType], this.mListView);
                }
            } else {
                view = adapter.getView(i2, null, this.mListView);
            }
            int f2 = f(i2, view, true);
            this.cGw.ar(i2, f2);
            return f2;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(int i2, View view, boolean z) {
        if (i2 == this.cFO) {
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
        boolean z = this.cFN && this.cFL != this.cFM;
        int i4 = this.aJA - this.cFV;
        int i5 = (int) (this.cGr * i4);
        if (i2 == this.cFO) {
            if (this.cFO == this.cFL) {
                if (z) {
                    return i5 + this.cFV;
                }
                return this.aJA;
            } else if (this.cFO == this.cFM) {
                return this.aJA - i5;
            } else {
                return this.cFV;
            }
        } else if (i2 == this.cFL) {
            if (z) {
                return i3 + i5;
            }
            return i3 + i4;
        } else if (i2 == this.cFM) {
            return (i3 + i4) - i5;
        } else {
            return i3;
        }
    }

    private int b(int i2, View view, int i3, int i4) {
        int i5;
        int i6;
        int lf = lf(i2);
        int height = view.getHeight();
        int aq = aq(i2, lf);
        if (i2 != this.cFO) {
            i6 = height - lf;
            i5 = aq - lf;
        } else {
            i5 = aq;
            i6 = height;
        }
        int i7 = this.aJA;
        if (this.cFO != this.cFL && this.cFO != this.cFM) {
            i7 -= this.cFV;
        }
        if (i2 <= i3) {
            if (i2 > this.cFL) {
                return (i7 - i5) + 0;
            }
        } else if (i2 == i4) {
            if (i2 <= this.cFL) {
                return (i6 - i7) + 0;
            }
            if (i2 == this.cFM) {
                return (height - aq) + 0;
            }
            return 0 + i6;
        } else if (i2 <= this.cFL) {
            return 0 - i7;
        } else {
            if (i2 == this.cFM) {
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

    private void axA() {
        if (this.cFD != null) {
            measureItem(this.cFD);
            this.aJA = this.cFD.getMeasuredHeight();
            this.cFW = this.aJA / 2;
        }
    }

    protected boolean onDragTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        switch (motionEvent.getAction() & 255) {
            case 1:
                if (this.mDragState == 4) {
                    stopDrag(false);
                }
                axx();
                return true;
            case 2:
                ap((int) motionEvent.getX(), (int) motionEvent.getY());
                return true;
            case 3:
                if (this.mDragState == 4) {
                    cancelDrag();
                }
                axx();
                return true;
            default:
                return true;
        }
    }

    public boolean startDrag(int i2, int i3, int i4, int i5) {
        View lh;
        if (!this.cGm || this.cGn == null || (lh = this.cGn.lh(i2)) == null) {
            return false;
        }
        return startDrag(i2, lh, i3, i4, i5);
    }

    public boolean startDrag(int i2, View view, int i3, int i4, int i5) {
        if (this.mDragState == 0 && this.cGm && this.cFD == null && view != null && this.cFU) {
            if (this.mListView.getParent() != null) {
                this.mListView.getParent().requestDisallowInterceptTouchEvent(true);
            }
            int headerViewsCount = this.mListView.getHeaderViewsCount() + i2;
            this.cFL = headerViewsCount;
            this.cFM = headerViewsCount;
            this.cFO = headerViewsCount;
            this.cFK = headerViewsCount;
            this.mDragState = 4;
            this.cGk = 0;
            this.cGk |= i3;
            this.cFD = view;
            axA();
            this.cFP = i4;
            this.cFQ = i5;
            this.cGj = this.amv;
            this.cFE.x = this.amu - this.cFP;
            this.cFE.y = this.amv - this.cFQ;
            View childAt = this.mListView.getChildAt(this.cFO - this.mListView.getFirstVisiblePosition());
            if (childAt != null) {
                childAt.setVisibility(4);
            }
            if (this.cGt) {
                this.cGu.axF();
            }
            switch (this.cGp) {
                case 1:
                    this.cGC.onTouchEvent(this.cGo);
                    break;
                case 2:
                    this.cGC.onInterceptTouchEvent(this.cGo);
                    break;
            }
            this.mListView.requestLayout();
            if (this.cGy != null) {
                this.cGy.start();
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
        axB();
        int i3 = this.cFL;
        int i4 = this.cFM;
        boolean axs = axs();
        if (axs) {
            axz();
            this.mListView.setSelectionFromTop(i2, (b(i2, view, i3, i4) + view.getTop()) - this.mListView.getPaddingTop());
            layoutChildren();
        }
        if (axs || z) {
            this.mListView.invalidate();
        }
        this.mBlockLayoutRequests = false;
    }

    private void axB() {
        if (this.cGn != null) {
            this.cFF.set(this.amu, this.amv);
            this.cGn.b(this.cFD, this.cFE, this.cFF);
        }
        int i2 = this.cFE.x;
        int i3 = this.cFE.y;
        int paddingLeft = this.mListView.getPaddingLeft();
        if ((this.cGk & 1) == 0 && i2 > paddingLeft) {
            this.cFE.x = paddingLeft;
        } else if ((this.cGk & 2) == 0 && i2 < paddingLeft) {
            this.cFE.x = paddingLeft;
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int lastVisiblePosition = this.mListView.getLastVisiblePosition();
        int paddingTop = this.mListView.getPaddingTop();
        if (firstVisiblePosition < headerViewsCount) {
            paddingTop = this.mListView.getChildAt((headerViewsCount - firstVisiblePosition) - 1).getBottom();
        }
        if ((this.cGk & 8) == 0 && firstVisiblePosition <= this.cFO) {
            paddingTop = Math.max(this.mListView.getChildAt(this.cFO - firstVisiblePosition).getTop(), paddingTop);
        }
        int height = this.mListView.getHeight() - this.mListView.getPaddingBottom();
        if (lastVisiblePosition >= (this.mListView.getCount() - footerViewsCount) - 1) {
            height = this.mListView.getChildAt(((this.mListView.getCount() - footerViewsCount) - 1) - firstVisiblePosition).getBottom();
        }
        if ((this.cGk & 4) == 0 && lastVisiblePosition >= this.cFO) {
            height = Math.min(this.mListView.getChildAt(this.cFO - firstVisiblePosition).getBottom(), height);
        }
        if (i3 < paddingTop) {
            this.cFE.y = paddingTop;
        } else if (this.aJA + i3 > height) {
            this.cFE.y = height - this.aJA;
        }
        this.cFG = this.cFE.y + this.cFW;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axC() {
        if (this.cFD != null) {
            this.cFD.setVisibility(8);
            if (this.cGn != null) {
                this.cGn.bi(this.cFD);
            }
            this.cFD = null;
            this.mListView.invalidate();
        }
    }

    public void a(h hVar) {
        this.cGn = hVar;
    }

    public void a(b bVar) {
        this.cFR = bVar;
    }

    public void setDragEnabled(boolean z) {
        this.cFU = z;
    }

    public boolean isDragEnabled() {
        return this.cFU;
    }

    public void a(g gVar) {
        this.cFS = gVar;
    }

    public void a(l lVar) {
        this.cFT = lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class i {
        private SparseIntArray cGX;
        private ArrayList<Integer> cGY;
        private int mMaxSize;

        public i(int i) {
            this.cGX = new SparseIntArray(i);
            this.cGY = new ArrayList<>(i);
            this.mMaxSize = i;
        }

        public void ar(int i, int i2) {
            int i3 = this.cGX.get(i, -1);
            if (i3 != i2) {
                if (i3 == -1) {
                    if (this.cGX.size() == this.mMaxSize) {
                        this.cGX.delete(this.cGY.remove(0).intValue());
                    }
                } else {
                    this.cGY.remove(Integer.valueOf(i));
                }
                this.cGX.put(i, i2);
                this.cGY.add(Integer.valueOf(i));
            }
        }

        public int get(int i) {
            return this.cGX.get(i, -1);
        }

        public void clear() {
            this.cGX.clear();
            this.cGY.clear();
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
        private float cHi;
        private boolean mCanceled;
        protected long mStartTime;

        public m(float f, int i) {
            this.Ha = f;
            this.cHi = i;
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
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / this.cHi;
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
        private int cGT;
        private int cGU;
        private float cGV;
        private float cGW;

        public f(float f, int i) {
            super(f, i);
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.cGT = a.this.cFK;
            this.cGU = a.this.cFO;
            a.this.mDragState = 2;
            this.cGV = a.this.cFE.y - axH();
            this.cGW = a.this.cFE.x - a.this.mListView.getPaddingLeft();
        }

        private int axH() {
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            int dividerHeight = (a.this.cFV + a.this.mListView.getDividerHeight()) / 2;
            View childAt = a.this.mListView.getChildAt(this.cGT - firstVisiblePosition);
            if (childAt != null) {
                if (this.cGT == this.cGU) {
                    return childAt.getTop();
                }
                if (this.cGT >= this.cGU) {
                    return (childAt.getBottom() + dividerHeight) - a.this.aJA;
                }
                return childAt.getTop() - dividerHeight;
            }
            cancel();
            return -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void t(float f, float f2) {
            int axH = axH();
            float paddingLeft = a.this.cFE.x - a.this.mListView.getPaddingLeft();
            float f3 = 1.0f - f2;
            if (f3 < Math.abs((a.this.cFE.y - axH) / this.cGV) || f3 < Math.abs(paddingLeft / this.cGW)) {
                a.this.cFE.y = axH + ((int) (this.cGV * f3));
                a.this.cFE.x = a.this.mListView.getPaddingLeft() + ((int) (this.cGW * f3));
                a.this.fN(true);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.axu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class k extends m {
        private int cGU;
        private float cHb;
        private float cHc;
        private float cHd;
        private int cHe;
        private int cHf;
        private int cHg;
        private int cHh;

        public k(float f, int i) {
            super(f, i);
            this.cHe = -1;
            this.cHf = -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.cHe = -1;
            this.cHf = -1;
            this.cHg = a.this.cFL;
            this.cHh = a.this.cFM;
            this.cGU = a.this.cFO;
            a.this.mDragState = 1;
            this.cHb = a.this.cFE.x;
            if (a.this.cGA) {
                float width = a.this.mListView.getWidth() * 2.0f;
                if (a.this.cGB == 0.0f) {
                    a.this.cGB = (this.cHb >= 0.0f ? 1 : -1) * width;
                    return;
                }
                float f = width * 2.0f;
                if (a.this.cGB >= 0.0f || a.this.cGB <= (-f)) {
                    if (a.this.cGB > 0.0f && a.this.cGB < f) {
                        a.this.cGB = f;
                        return;
                    }
                    return;
                }
                a.this.cGB = -f;
                return;
            }
            a.this.axC();
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void t(float f, float f2) {
            View childAt;
            float f3 = 1.0f - f2;
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            View childAt2 = a.this.mListView.getChildAt(this.cHg - firstVisiblePosition);
            if (a.this.cGA) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / 1000.0f;
                if (uptimeMillis != 0.0f) {
                    float f4 = a.this.cGB * uptimeMillis;
                    int width = a.this.mListView.getWidth();
                    a.this.cGB = ((a.this.cGB > 0.0f ? 1 : -1) * uptimeMillis * width) + a.this.cGB;
                    this.cHb += f4;
                    a.this.cFE.x = (int) this.cHb;
                    if (this.cHb < width && this.cHb > (-width)) {
                        this.mStartTime = SystemClock.uptimeMillis();
                        a.this.fN(true);
                        return;
                    }
                } else {
                    return;
                }
            }
            if (childAt2 != null) {
                if (this.cHe == -1) {
                    this.cHe = a.this.f(this.cHg, childAt2, false);
                    this.cHc = childAt2.getHeight() - this.cHe;
                }
                int max = Math.max((int) (this.cHc * f3), 1);
                ViewGroup.LayoutParams layoutParams = childAt2.getLayoutParams();
                layoutParams.height = max + this.cHe;
                childAt2.setLayoutParams(layoutParams);
            }
            if (this.cHh != this.cHg && (childAt = a.this.mListView.getChildAt(this.cHh - firstVisiblePosition)) != null) {
                if (this.cHf == -1) {
                    this.cHf = a.this.f(this.cHh, childAt, false);
                    this.cHd = childAt.getHeight() - this.cHf;
                }
                int max2 = Math.max((int) (this.cHd * f3), 1);
                ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
                layoutParams2.height = max2 + this.cHf;
                childAt.setLayoutParams(layoutParams2);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.axv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class j extends m {
        final /* synthetic */ a cGG;
        private float cGZ;
        private float cHa;

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.cGZ = this.cGG.cFQ;
            this.cHa = this.cGG.cFW;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void t(float f, float f2) {
            if (this.cGG.mDragState != 4) {
                cancel();
                return;
            }
            this.cGG.cFQ = (int) ((this.cHa * f2) + ((1.0f - f2) * this.cGZ));
            this.cGG.cFE.y = this.cGG.amv - this.cGG.cFQ;
            this.cGG.fN(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e {
        StringBuilder mBuilder = new StringBuilder();
        private int cGQ = 0;
        private int cGR = 0;
        private boolean cGS = false;
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

        public void axF() {
            this.mBuilder.append("<DSLVStates>\n");
            this.cGR = 0;
            this.cGS = true;
        }

        public void axG() {
            if (this.cGS) {
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
                this.mBuilder.append("    <FirstExpPos>").append(a.this.cFL).append("</FirstExpPos>\n");
                this.mBuilder.append("    <FirstExpBlankHeight>").append(a.this.ld(a.this.cFL) - a.this.lf(a.this.cFL)).append("</FirstExpBlankHeight>\n");
                this.mBuilder.append("    <SecondExpPos>").append(a.this.cFM).append("</SecondExpPos>\n");
                this.mBuilder.append("    <SecondExpBlankHeight>").append(a.this.ld(a.this.cFM) - a.this.lf(a.this.cFM)).append("</SecondExpBlankHeight>\n");
                this.mBuilder.append("    <SrcPos>").append(a.this.cFO).append("</SrcPos>\n");
                this.mBuilder.append("    <SrcHeight>").append(a.this.aJA + a.this.mListView.getDividerHeight()).append("</SrcHeight>\n");
                this.mBuilder.append("    <ViewHeight>").append(a.this.mListView.getHeight()).append("</ViewHeight>\n");
                this.mBuilder.append("    <LastY>").append(a.this.mLastY).append("</LastY>\n");
                this.mBuilder.append("    <FloatY>").append(a.this.cFG).append("</FloatY>\n");
                this.mBuilder.append("    <ShuffleEdges>");
                for (int i4 = 0; i4 < childCount; i4++) {
                    this.mBuilder.append(a.this.ao(firstVisiblePosition + i4, a.this.mListView.getChildAt(i4).getTop())).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                this.mBuilder.append("</ShuffleEdges>\n");
                this.mBuilder.append("</DSLVState>\n");
                this.cGQ++;
                if (this.cGQ > 1000) {
                    flush();
                    this.cGQ = 0;
                }
            }
        }

        public void flush() {
            if (this.cGS) {
                try {
                    FileWriter fileWriter = new FileWriter(this.mFile, this.cGR != 0);
                    fileWriter.write(this.mBuilder.toString());
                    this.mBuilder.delete(0, this.mBuilder.length());
                    fileWriter.flush();
                    fileWriter.close();
                    this.cGR++;
                } catch (IOException e) {
                }
            }
        }

        public void nF() {
            if (this.cGS) {
                this.mBuilder.append("</DSLVStates>\n");
                flush();
                this.cGS = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements Runnable {
        private boolean aNk = false;
        private boolean cGJ;
        private long cGK;
        private long cGL;
        private float cGM;
        private long cGN;
        private int cGO;
        private float cGP;
        private int dy;

        public boolean axD() {
            return this.aNk;
        }

        public int axE() {
            if (this.aNk) {
                return this.cGO;
            }
            return -1;
        }

        public d() {
        }

        public void lg(int i) {
            if (!this.aNk) {
                this.cGJ = false;
                this.aNk = true;
                this.cGN = SystemClock.uptimeMillis();
                this.cGK = this.cGN;
                this.cGO = i;
                a.this.mListView.post(this);
            }
        }

        public void fO(boolean z) {
            if (z) {
                a.this.mListView.removeCallbacks(this);
                this.aNk = false;
                return;
            }
            this.cGJ = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.cGJ) {
                int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
                int lastVisiblePosition = a.this.mListView.getLastVisiblePosition();
                int count = a.this.mListView.getCount();
                int paddingTop = a.this.mListView.getPaddingTop();
                int height = (a.this.mListView.getHeight() - paddingTop) - a.this.mListView.getPaddingBottom();
                int min = Math.min(a.this.amv, a.this.cFG + a.this.cFW);
                int max = Math.max(a.this.amv, a.this.cFG - a.this.cFW);
                if (this.cGO == 0) {
                    View childAt = a.this.mListView.getChildAt(0);
                    if (childAt == null) {
                        this.aNk = false;
                        return;
                    } else if (firstVisiblePosition == 0 && childAt.getTop() == paddingTop) {
                        this.aNk = false;
                        return;
                    } else {
                        this.cGP = a.this.cGi.b((a.this.cGe - max) / a.this.cGf, this.cGK);
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
                        this.cGP = -a.this.cGi.b((min - a.this.cGd) / a.this.cGg, this.cGK);
                    }
                }
                this.cGL = SystemClock.uptimeMillis();
                this.cGM = (float) (this.cGL - this.cGK);
                this.dy = Math.round(this.cGP * this.cGM);
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
                this.cGK = this.cGL;
                a.this.mListView.post(this);
                return;
            }
            this.aNk = false;
        }
    }
}
