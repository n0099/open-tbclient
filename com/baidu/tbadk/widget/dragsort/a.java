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
import com.baidu.tieba.R;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a implements com.baidu.tbadk.widget.dragsort.c {
    private int cAn;
    private View eGR;
    private int eGU;
    private int eGY;
    private int eGZ;
    private MotionEvent eHB;
    private C0503a eHF;
    private e eHH;
    private k eHK;
    private j eHL;
    private f eHM;
    private boolean eHN;
    private com.baidu.tbadk.widget.dragsort.d eHP;
    private com.baidu.tbadk.widget.dragsort.b eHQ;
    private int eHa;
    private int eHc;
    private int eHd;
    private int eHe;
    private b eHf;
    private g eHg;
    private l eHh;
    private int eHj;
    private d eHl;
    private int eHo;
    private int eHp;
    private float eHq;
    private float eHr;
    private float eHs;
    private float eHt;
    private int eHw;
    private int mLastX;
    private int mLastY;
    private ListView mListView;
    private DataSetObserver mObserver;
    private int mOffsetX;
    private int mOffsetY;
    private int mX;
    private int mY;
    private Point eGS = new Point();
    private Point eGT = new Point();
    private boolean eGV = false;
    private float eGW = 1.0f;
    private float eGX = 1.0f;
    private boolean eHb = false;
    private boolean cQm = true;
    private int mDragState = 0;
    private int eHi = 1;
    private int mWidthMeasureSpec = 0;
    private View[] eHk = new View[1];
    private float eHm = 0.33333334f;
    private float eHn = 0.33333334f;
    private float eHu = 0.5f;
    private c eHv = new c() { // from class: com.baidu.tbadk.widget.dragsort.a.1
        @Override // com.baidu.tbadk.widget.dragsort.a.c
        public float b(float f2, long j2) {
            return a.this.eHu * f2;
        }
    };
    private int eHx = 0;
    private boolean eHy = false;
    private boolean eHz = false;
    private h eHA = null;
    private int eHC = 0;
    private float eHD = 0.25f;
    private float eHE = 0.0f;
    private boolean eHG = false;
    private boolean mBlockLayoutRequests = false;
    private boolean eHI = false;
    private i eHJ = new i(3);
    private float eHO = 0.0f;
    private boolean eHR = false;
    private boolean eHS = false;

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

        void bm(View view);

        View oo(int i);
    }

    /* loaded from: classes.dex */
    public interface l {
        void remove(int i);
    }

    public a(ListView listView, com.baidu.tbadk.widget.dragsort.d dVar) {
        this.eHP = dVar;
        this.mListView = listView;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            this.eHF = new C0503a(listAdapter);
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
            this.eHF = null;
        }
        this.eHP.setAdapter(this.eHF);
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
            if (i2 > this.eHc) {
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
    public int ok(int i2) {
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        return childAt != null ? childAt.getHeight() : ba(i2, om(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aY(int i2, int i3) {
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        if (i2 <= headerViewsCount || i2 >= this.mListView.getCount() - footerViewsCount) {
            return i3;
        }
        int dividerHeight = this.mListView.getDividerHeight();
        int i4 = this.cAn - this.eHi;
        int om = om(i2);
        int ok = ok(i2);
        if (this.eHa <= this.eHc) {
            if (i2 == this.eHa && this.eGZ != this.eHa) {
                if (i2 == this.eHc) {
                    i3 = (i3 + ok) - this.cAn;
                } else {
                    i3 = ((ok - om) + i3) - i4;
                }
            } else if (i2 > this.eHa && i2 <= this.eHc) {
                i3 -= i4;
            }
        } else if (i2 > this.eHc && i2 <= this.eGZ) {
            i3 += i4;
        } else if (i2 == this.eHa && this.eGZ != this.eHa) {
            i3 += ok - om;
        }
        if (i2 <= this.eHc) {
            return (((this.cAn - dividerHeight) - om(i2 - 1)) / 2) + i3;
        }
        return (((om - dividerHeight) - this.cAn) / 2) + i3;
    }

    private boolean bjM() {
        int i2;
        int i3;
        int i4;
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int i5 = this.eGZ;
        View childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        if (childAt == null) {
            i5 = firstVisiblePosition + (this.mListView.getChildCount() / 2);
            childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        }
        int top2 = childAt.getTop();
        int height = childAt.getHeight();
        int aY = aY(i5, top2);
        int dividerHeight = this.mListView.getDividerHeight();
        if (this.eGU >= aY) {
            int count = this.mListView.getCount();
            int i6 = height;
            int i7 = top2;
            i2 = aY;
            i3 = i5;
            i4 = aY;
            while (true) {
                if (i3 < count) {
                    if (i3 == count - 1) {
                        i2 = i7 + dividerHeight + i6;
                        break;
                    }
                    i7 += dividerHeight + i6;
                    i6 = ok(i3 + 1);
                    i2 = aY(i3 + 1, i7);
                    if (this.eGU < i2) {
                        break;
                    }
                    i3++;
                    i4 = i2;
                } else {
                    break;
                }
            }
        } else {
            int i8 = top2;
            i2 = aY;
            i3 = i5;
            i4 = aY;
            while (true) {
                if (i3 < 0) {
                    break;
                }
                i3--;
                int ok = ok(i3);
                if (i3 == 0) {
                    i2 = (i8 - dividerHeight) - ok;
                    break;
                }
                i8 -= ok + dividerHeight;
                i2 = aY(i3, i8);
                if (this.eGU >= i2) {
                    break;
                }
                i4 = i2;
            }
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int i9 = this.eGZ;
        int i10 = this.eHa;
        float f2 = this.eHE;
        if (this.eHb) {
            int abs = Math.abs(i2 - i4);
            if (this.eGU >= i2) {
                int i11 = i4;
                i4 = i2;
                i2 = i11;
            }
            int i12 = (int) (abs * this.eHD * 0.5f);
            float f3 = i12;
            int i13 = i4 + i12;
            int i14 = i2 - i12;
            if (this.eGU < i13) {
                this.eGZ = i3 - 1;
                this.eHa = i3;
                this.eHE = ((i13 - this.eGU) * 0.5f) / f3;
            } else if (this.eGU < i14) {
                this.eGZ = i3;
                this.eHa = i3;
            } else {
                this.eGZ = i3;
                this.eHa = i3 + 1;
                this.eHE = (1.0f + ((i2 - this.eGU) / f3)) * 0.5f;
            }
        } else {
            this.eGZ = i3;
            this.eHa = i3;
        }
        if (this.eGZ < headerViewsCount) {
            this.eGZ = headerViewsCount;
            this.eHa = headerViewsCount;
            i3 = headerViewsCount;
        } else if (this.eHa >= this.mListView.getCount() - footerViewsCount) {
            i3 = (this.mListView.getCount() - footerViewsCount) - 1;
            this.eGZ = i3;
            this.eHa = i3;
        }
        boolean z = (this.eGZ == i9 && this.eHa == i10 && this.eHE == f2) ? false : true;
        if (i3 != this.eGY) {
            if (this.eHf != null) {
                this.eHf.drag(this.eGY - headerViewsCount, i3 - headerViewsCount);
            }
            this.eGY = i3;
            return true;
        }
        return z;
    }

    public void removeItem(int i2) {
        this.eHN = false;
        removeItem(i2, 0.0f);
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void a(ListView listView, Context context, AttributeSet attributeSet) {
        int i2;
        int i3 = 150;
        if (attributeSet == null) {
            i2 = 150;
        } else {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DragSort, 0, 0);
            this.eHi = Math.max(1, obtainStyledAttributes.getDimensionPixelSize(12, 1));
            this.eHG = obtainStyledAttributes.getBoolean(6, false);
            if (this.eHG) {
                this.eHH = new e();
            }
            this.eGW = obtainStyledAttributes.getFloat(10, this.eGW);
            this.eGX = this.eGW;
            this.cQm = obtainStyledAttributes.getBoolean(13, this.cQm);
            this.eHD = Math.max(0.0f, Math.min(1.0f, 1.0f - obtainStyledAttributes.getFloat(2, 0.75f)));
            this.eHb = this.eHD > 0.0f;
            setDragScrollStart(obtainStyledAttributes.getFloat(14, this.eHm));
            this.eHu = obtainStyledAttributes.getFloat(0, this.eHu);
            int i4 = obtainStyledAttributes.getInt(11, 150);
            int i5 = obtainStyledAttributes.getInt(15, 150);
            if (obtainStyledAttributes.getBoolean(17, true)) {
                boolean z = obtainStyledAttributes.getBoolean(7, false);
                int i6 = obtainStyledAttributes.getInt(1, 1);
                boolean z2 = obtainStyledAttributes.getBoolean(3, true);
                int resourceId = obtainStyledAttributes.getResourceId(8, 0);
                int resourceId2 = obtainStyledAttributes.getResourceId(9, 0);
                int resourceId3 = obtainStyledAttributes.getResourceId(4, 0);
                int color = obtainStyledAttributes.getColor(5, ViewCompat.MEASURED_STATE_MASK);
                com.baidu.tbadk.widget.dragsort.b bVar = new com.baidu.tbadk.widget.dragsort.b(this, listView, resourceId, 2, i6, resourceId3, resourceId2);
                bVar.iP(z);
                bVar.iO(z2);
                bVar.setBackgroundColor(color);
                this.eHA = bVar;
                a(bVar);
            }
            obtainStyledAttributes.recycle();
            i2 = i5;
            i3 = i4;
        }
        this.eHl = new d();
        if (i3 > 0) {
            this.eHK = new k(0.5f, i3);
        }
        if (i2 > 0) {
            this.eHM = new f(0.5f, i2);
        }
        this.eHB = MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
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
        this.eHQ = bVar;
        this.mListView.setOnTouchListener(bVar);
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void dispatchDraw(Canvas canvas) {
        float f2;
        this.eHP.dispatchDraw(canvas);
        if (this.mDragState != 0) {
            if (this.eGZ != this.eHc) {
                b(this.eGZ, canvas);
            }
            if (this.eHa != this.eGZ && this.eHa != this.eHc) {
                b(this.eHa, canvas);
            }
        }
        if (this.eGR != null) {
            int width = this.eGR.getWidth();
            int height = this.eGR.getHeight();
            int i2 = this.eGS.x;
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
            int i3 = (int) (f2 * 255.0f * this.eGX);
            canvas.save();
            canvas.translate(this.eGS.x, this.eGS.y);
            canvas.clipRect(0, 0, width, height);
            canvas.saveLayerAlpha(0.0f, 0.0f, width, height, i3, 31);
            this.eGR.draw(canvas);
            canvas.restore();
            canvas.restore();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onDraw(Canvas canvas) {
        this.eHP.onDraw(canvas);
        if (this.eHG) {
            this.eHH.bjZ();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.eHI) {
            this.eHI = false;
            return false;
        } else if (!this.cQm) {
            return this.eHP.onTouchEvent(motionEvent);
        } else {
            boolean z2 = this.eHy;
            this.eHy = false;
            if (!z2) {
                r(motionEvent);
            }
            if (this.mDragState == 4) {
                onDragTouchEvent(motionEvent);
                return true;
            }
            if (this.mDragState == 0 && this.eHP.onTouchEvent(motionEvent)) {
                z = true;
            }
            switch (motionEvent.getAction() & 255) {
                case 1:
                case 3:
                    bjR();
                    return z;
                case 2:
                default:
                    if (z) {
                        this.eHC = 1;
                        return z;
                    }
                    return z;
            }
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (!this.cQm) {
            return this.eHP.onInterceptTouchEvent(motionEvent);
        }
        if (this.eHQ != null) {
            this.eHQ.bkb().onTouchEvent(motionEvent);
        }
        r(motionEvent);
        this.eHy = true;
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            if (this.mDragState != 0) {
                this.eHI = true;
                return true;
            }
            this.eHz = true;
        }
        if (this.eGR == null) {
            if (this.eHP.onInterceptTouchEvent(motionEvent)) {
                this.eHR = true;
                z = true;
            } else {
                z = false;
            }
            switch (action) {
                case 1:
                case 3:
                    bjR();
                    break;
                case 2:
                default:
                    if (z) {
                        this.eHC = 1;
                        break;
                    } else {
                        this.eHC = 2;
                        break;
                    }
            }
        } else {
            z = true;
        }
        if (action == 1 || action == 3) {
            this.eHz = false;
        }
        return z;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        this.eHP.onSizeChanged(i2, i3, i4, i5);
        bjS();
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void requestLayout() {
        if (!this.mBlockLayoutRequests) {
            this.eHP.requestLayout();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onMeasure(int i2, int i3) {
        this.eHP.onMeasure(i2, i3);
        if (this.eGR != null) {
            if (this.eGR.isLayoutRequested()) {
                bjU();
            }
            this.eGV = true;
        }
        this.mWidthMeasureSpec = i2;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void layoutChildren() {
        this.eHP.layoutChildren();
        if (this.eGR != null) {
            if (this.eGR.isLayoutRequested() && !this.eGV) {
                bjU();
            }
            this.eGR.layout(0, 0, this.eGR.getMeasuredWidth(), this.eGR.getMeasuredHeight());
            this.eGV = false;
        }
    }

    public void removeItem(int i2, float f2) {
        if (this.mDragState == 0 || this.mDragState == 4) {
            if (this.mDragState == 0) {
                this.eHc = this.mListView.getHeaderViewsCount() + i2;
                this.eGZ = this.eHc;
                this.eHa = this.eHc;
                this.eGY = this.eHc;
                View childAt = this.mListView.getChildAt(this.eHc - this.mListView.getFirstVisiblePosition());
                if (childAt != null) {
                    childAt.setVisibility(4);
                }
            }
            this.mDragState = 1;
            this.eHO = f2;
            if (this.eHz) {
                switch (this.eHC) {
                    case 1:
                        this.eHP.onTouchEvent(this.eHB);
                        break;
                    case 2:
                        this.eHP.onInterceptTouchEvent(this.eHB);
                        break;
                }
            }
            if (this.eHK != null) {
                this.eHK.start();
            } else {
                ol(i2);
            }
        }
    }

    public void cancelDrag() {
        if (this.mDragState == 4) {
            this.eHl.iN(true);
            bjW();
            bjN();
            bjT();
            if (this.eHz) {
                this.mDragState = 3;
            } else {
                this.mDragState = 0;
            }
        }
    }

    private void bjN() {
        this.eHc = -1;
        this.eGZ = -1;
        this.eHa = -1;
        this.eGY = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjO() {
        this.mDragState = 2;
        if (this.eHg != null && this.eGY >= 0 && this.eGY < this.mListView.getCount()) {
            int headerViewsCount = this.mListView.getHeaderViewsCount();
            this.eHg.drop(this.eHc - headerViewsCount, this.eGY - headerViewsCount);
        }
        bjW();
        bjQ();
        bjN();
        bjT();
        if (this.eHz) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjP() {
        ol(this.eHc - this.mListView.getHeaderViewsCount());
    }

    private void ol(int i2) {
        this.mDragState = 1;
        if (this.eHh != null) {
            this.eHh.remove(i2);
        }
        bjW();
        bjQ();
        bjN();
        if (this.eHz) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    private void bjQ() {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        if (this.eHc < firstVisiblePosition) {
            View childAt = this.mListView.getChildAt(0);
            this.mListView.setSelectionFromTop(firstVisiblePosition - 1, (childAt != null ? childAt.getTop() : 0) - this.mListView.getPaddingTop());
        }
    }

    public boolean stopDrag(boolean z) {
        this.eHN = false;
        return stopDrag(z, 0.0f);
    }

    public boolean stopDragWithVelocity(boolean z, float f2) {
        this.eHN = true;
        return stopDrag(z, f2);
    }

    public boolean stopDrag(boolean z, float f2) {
        if (this.eGR != null) {
            this.eHl.iN(true);
            if (z) {
                removeItem(this.eHc - this.mListView.getHeaderViewsCount(), f2);
            } else if (this.eHM != null) {
                this.eHM.start();
            } else {
                bjO();
            }
            if (this.eHG) {
                this.eHH.stopTracking();
                return true;
            }
            return true;
        }
        return false;
    }

    private void bjR() {
        this.eHC = 0;
        this.eHz = false;
        if (this.mDragState == 3) {
            this.mDragState = 0;
        }
        this.eGX = this.eGW;
        this.eHR = false;
        this.eHJ.clear();
    }

    private void r(MotionEvent motionEvent) {
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
        return this.eHR;
    }

    public void setDragScrollStart(float f2) {
        setDragScrollStarts(f2, f2);
    }

    public void setDragScrollStarts(float f2, float f3) {
        if (f3 > 0.5f) {
            this.eHn = 0.5f;
        } else {
            this.eHn = f3;
        }
        if (f2 > 0.5f) {
            this.eHm = 0.5f;
        } else {
            this.eHm = f2;
        }
        if (this.mListView.getHeight() != 0) {
            bjS();
        }
    }

    private void aZ(int i2, int i3) {
        this.eGS.x = i2 - this.eHd;
        this.eGS.y = i3 - this.eHe;
        iM(true);
        int min = Math.min(i3, this.eGU + this.eHj);
        int max = Math.max(i3, this.eGU - this.eHj);
        int bjX = this.eHl.bjX();
        if (min > this.mLastY && min > this.eHp && bjX != 1) {
            if (bjX != -1) {
                this.eHl.iN(true);
            }
            this.eHl.on(1);
        } else if (max < this.mLastY && max < this.eHo && bjX != 0) {
            if (bjX != -1) {
                this.eHl.iN(true);
            }
            this.eHl.on(0);
        } else if (max >= this.eHo && min <= this.eHp && this.eHl.isScrolling()) {
            this.eHl.iN(true);
        }
    }

    private void bjS() {
        int height;
        int paddingTop = this.mListView.getPaddingTop();
        float height2 = (this.mListView.getHeight() - paddingTop) - this.mListView.getPaddingBottom();
        this.eHr = paddingTop + (this.eHm * height2);
        this.eHq = (height2 * (1.0f - this.eHn)) + paddingTop;
        this.eHo = (int) this.eHr;
        this.eHp = (int) this.eHq;
        this.eHs = this.eHr - paddingTop;
        this.eHt = (paddingTop + height) - this.eHq;
    }

    private void bjT() {
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
        if (i2 != this.eHc && i2 != this.eGZ && i2 != this.eHa) {
            g2 = -2;
        } else {
            g2 = g(i2, view, z);
        }
        if (g2 != layoutParams.height) {
            layoutParams.height = g2;
            view.setLayoutParams(layoutParams);
        }
        if (i2 == this.eGZ || i2 == this.eHa) {
            if (i2 < this.eHc) {
                ((DragSortItemView) view).setGravity(80);
            } else if (i2 > this.eHc) {
                ((DragSortItemView) view).setGravity(48);
            }
        }
        int visibility = view.getVisibility();
        int i3 = 0;
        if (i2 == this.eHc && this.eGR != null) {
            i3 = 4;
        }
        if (i3 != visibility) {
            view.setVisibility(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int om(int i2) {
        View view;
        if (i2 == this.eHc) {
            return 0;
        }
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        if (childAt != null) {
            return f(i2, childAt, false);
        }
        int i3 = this.eHJ.get(i2);
        if (i3 == -1) {
            ListAdapter adapter = this.mListView.getAdapter();
            int itemViewType = adapter.getItemViewType(i2);
            int viewTypeCount = adapter.getViewTypeCount();
            if (viewTypeCount != this.eHk.length) {
                this.eHk = new View[viewTypeCount];
            }
            if (itemViewType >= 0) {
                if (this.eHk[itemViewType] == null) {
                    view = adapter.getView(i2, null, this.mListView);
                    this.eHk[itemViewType] = view;
                } else {
                    view = adapter.getView(i2, this.eHk[itemViewType], this.mListView);
                }
            } else {
                view = adapter.getView(i2, null, this.mListView);
            }
            int f2 = f(i2, view, true);
            this.eHJ.bb(i2, f2);
            return f2;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(int i2, View view, boolean z) {
        if (i2 == this.eHc) {
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
        return ba(i2, f(i2, view, z));
    }

    private int ba(int i2, int i3) {
        this.mListView.getDividerHeight();
        boolean z = this.eHb && this.eGZ != this.eHa;
        int i4 = this.cAn - this.eHi;
        int i5 = (int) (this.eHE * i4);
        if (i2 == this.eHc) {
            if (this.eHc == this.eGZ) {
                if (z) {
                    return i5 + this.eHi;
                }
                return this.cAn;
            } else if (this.eHc == this.eHa) {
                return this.cAn - i5;
            } else {
                return this.eHi;
            }
        } else if (i2 == this.eGZ) {
            if (z) {
                return i3 + i5;
            }
            return i3 + i4;
        } else if (i2 == this.eHa) {
            return (i3 + i4) - i5;
        } else {
            return i3;
        }
    }

    private int b(int i2, View view, int i3, int i4) {
        int i5;
        int i6;
        int om = om(i2);
        int height = view.getHeight();
        int ba = ba(i2, om);
        if (i2 != this.eHc) {
            i6 = height - om;
            i5 = ba - om;
        } else {
            i5 = ba;
            i6 = height;
        }
        int i7 = this.cAn;
        if (this.eHc != this.eGZ && this.eHc != this.eHa) {
            i7 -= this.eHi;
        }
        if (i2 <= i3) {
            if (i2 > this.eGZ) {
                return (i7 - i5) + 0;
            }
        } else if (i2 == i4) {
            if (i2 <= this.eGZ) {
                return (i6 - i7) + 0;
            }
            if (i2 == this.eHa) {
                return (height - ba) + 0;
            }
            return 0 + i6;
        } else if (i2 <= this.eGZ) {
            return 0 - i7;
        } else {
            if (i2 == this.eHa) {
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

    private void bjU() {
        if (this.eGR != null) {
            measureItem(this.eGR);
            this.cAn = this.eGR.getMeasuredHeight();
            this.eHj = this.cAn / 2;
        }
    }

    protected boolean onDragTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        switch (motionEvent.getAction() & 255) {
            case 1:
                if (this.mDragState == 4) {
                    stopDrag(false);
                }
                bjR();
                return true;
            case 2:
                aZ((int) motionEvent.getX(), (int) motionEvent.getY());
                return true;
            case 3:
                if (this.mDragState == 4) {
                    cancelDrag();
                }
                bjR();
                return true;
            default:
                return true;
        }
    }

    public boolean startDrag(int i2, int i3, int i4, int i5) {
        View oo;
        if (!this.eHz || this.eHA == null || (oo = this.eHA.oo(i2)) == null) {
            return false;
        }
        return startDrag(i2, oo, i3, i4, i5);
    }

    public boolean startDrag(int i2, View view, int i3, int i4, int i5) {
        if (this.mDragState == 0 && this.eHz && this.eGR == null && view != null && this.cQm) {
            if (this.mListView.getParent() != null) {
                this.mListView.getParent().requestDisallowInterceptTouchEvent(true);
            }
            int headerViewsCount = this.mListView.getHeaderViewsCount() + i2;
            this.eGZ = headerViewsCount;
            this.eHa = headerViewsCount;
            this.eHc = headerViewsCount;
            this.eGY = headerViewsCount;
            this.mDragState = 4;
            this.eHx = 0;
            this.eHx |= i3;
            this.eGR = view;
            bjU();
            this.eHd = i4;
            this.eHe = i5;
            this.eHw = this.mY;
            this.eGS.x = this.mX - this.eHd;
            this.eGS.y = this.mY - this.eHe;
            View childAt = this.mListView.getChildAt(this.eHc - this.mListView.getFirstVisiblePosition());
            if (childAt != null) {
                childAt.setVisibility(4);
            }
            if (this.eHG) {
                this.eHH.bjY();
            }
            switch (this.eHC) {
                case 1:
                    this.eHP.onTouchEvent(this.eHB);
                    break;
                case 2:
                    this.eHP.onInterceptTouchEvent(this.eHB);
                    break;
            }
            this.mListView.requestLayout();
            if (this.eHL != null) {
                this.eHL.start();
                return true;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iM(boolean z) {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition() + (this.mListView.getChildCount() / 2);
        View childAt = this.mListView.getChildAt(this.mListView.getChildCount() / 2);
        if (childAt != null) {
            h(firstVisiblePosition, childAt, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i2, View view, boolean z) {
        this.mBlockLayoutRequests = true;
        bjV();
        int i3 = this.eGZ;
        int i4 = this.eHa;
        boolean bjM = bjM();
        if (bjM) {
            bjT();
            this.mListView.setSelectionFromTop(i2, (b(i2, view, i3, i4) + view.getTop()) - this.mListView.getPaddingTop());
            layoutChildren();
        }
        if (bjM || z) {
            this.mListView.invalidate();
        }
        this.mBlockLayoutRequests = false;
    }

    private void bjV() {
        if (this.eHA != null) {
            this.eGT.set(this.mX, this.mY);
            this.eHA.b(this.eGR, this.eGS, this.eGT);
        }
        int i2 = this.eGS.x;
        int i3 = this.eGS.y;
        int paddingLeft = this.mListView.getPaddingLeft();
        if ((this.eHx & 1) == 0 && i2 > paddingLeft) {
            this.eGS.x = paddingLeft;
        } else if ((this.eHx & 2) == 0 && i2 < paddingLeft) {
            this.eGS.x = paddingLeft;
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int lastVisiblePosition = this.mListView.getLastVisiblePosition();
        int paddingTop = this.mListView.getPaddingTop();
        if (firstVisiblePosition < headerViewsCount) {
            paddingTop = this.mListView.getChildAt((headerViewsCount - firstVisiblePosition) - 1).getBottom();
        }
        if ((this.eHx & 8) == 0 && firstVisiblePosition <= this.eHc) {
            paddingTop = Math.max(this.mListView.getChildAt(this.eHc - firstVisiblePosition).getTop(), paddingTop);
        }
        int height = this.mListView.getHeight() - this.mListView.getPaddingBottom();
        if (lastVisiblePosition >= (this.mListView.getCount() - footerViewsCount) - 1) {
            height = this.mListView.getChildAt(((this.mListView.getCount() - footerViewsCount) - 1) - firstVisiblePosition).getBottom();
        }
        if ((this.eHx & 4) == 0 && lastVisiblePosition >= this.eHc) {
            height = Math.min(this.mListView.getChildAt(this.eHc - firstVisiblePosition).getBottom(), height);
        }
        if (i3 < paddingTop) {
            this.eGS.y = paddingTop;
        } else if (this.cAn + i3 > height) {
            this.eGS.y = height - this.cAn;
        }
        this.eGU = this.eGS.y + this.eHj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjW() {
        if (this.eGR != null) {
            this.eGR.setVisibility(8);
            if (this.eHA != null) {
                this.eHA.bm(this.eGR);
            }
            this.eGR = null;
            this.mListView.invalidate();
        }
    }

    public void a(h hVar) {
        this.eHA = hVar;
    }

    public void a(b bVar) {
        this.eHf = bVar;
    }

    public void setDragEnabled(boolean z) {
        this.cQm = z;
    }

    public boolean isDragEnabled() {
        return this.cQm;
    }

    public void a(g gVar) {
        this.eHg = gVar;
    }

    public void a(l lVar) {
        this.eHh = lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class i {
        private SparseIntArray eIl;
        private ArrayList<Integer> eIm;
        private int mMaxSize;

        public i(int i) {
            this.eIl = new SparseIntArray(i);
            this.eIm = new ArrayList<>(i);
            this.mMaxSize = i;
        }

        public void bb(int i, int i2) {
            int i3 = this.eIl.get(i, -1);
            if (i3 != i2) {
                if (i3 == -1) {
                    if (this.eIl.size() == this.mMaxSize) {
                        this.eIl.delete(this.eIm.remove(0).intValue());
                    }
                } else {
                    this.eIm.remove(Integer.valueOf(i));
                }
                this.eIl.put(i, i2);
                this.eIm.add(Integer.valueOf(i));
            }
        }

        public int get(int i) {
            return this.eIl.get(i, -1);
        }

        public void clear() {
            this.eIl.clear();
            this.eIm.clear();
        }
    }

    /* renamed from: com.baidu.tbadk.widget.dragsort.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0503a extends BaseAdapter {
        private ListAdapter mAdapter;

        public C0503a(ListAdapter listAdapter) {
            this.mAdapter = listAdapter;
            this.mAdapter.registerDataSetObserver(new DataSetObserver() { // from class: com.baidu.tbadk.widget.dragsort.a.a.1
                @Override // android.database.DataSetObserver
                public void onChanged() {
                    C0503a.this.notifyDataSetChanged();
                }

                @Override // android.database.DataSetObserver
                public void onInvalidated() {
                    C0503a.this.notifyDataSetInvalidated();
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
        private float bTq;
        private float bTr;
        private float bTs;
        private float bTt;
        private float eIw;
        private float mAlpha;
        private boolean mCanceled;
        protected long mStartTime;

        public m(float f, int i) {
            this.mAlpha = f;
            this.eIw = i;
            float f2 = 1.0f / ((this.mAlpha * 2.0f) * (1.0f - this.mAlpha));
            this.bTt = f2;
            this.bTq = f2;
            this.bTr = this.mAlpha / ((this.mAlpha - 1.0f) * 2.0f);
            this.bTs = 1.0f / (1.0f - this.mAlpha);
        }

        public float ab(float f) {
            if (f < this.mAlpha) {
                return this.bTq * f * f;
            }
            if (f < 1.0f - this.mAlpha) {
                return this.bTr + (this.bTs * f);
            }
            return 1.0f - ((this.bTt * (f - 1.0f)) * (f - 1.0f));
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

        public void s(float f, float f2) {
        }

        public void onStop() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.mCanceled) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / this.eIw;
                if (uptimeMillis >= 1.0f) {
                    s(1.0f, 1.0f);
                    onStop();
                    return;
                }
                s(uptimeMillis, ab(uptimeMillis));
                a.this.mListView.post(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class f extends m {
        private int eIh;
        private int eIi;
        private float eIj;
        private float eIk;

        public f(float f, int i) {
            super(f, i);
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.eIh = a.this.eGY;
            this.eIi = a.this.eHc;
            a.this.mDragState = 2;
            this.eIj = a.this.eGS.y - bka();
            this.eIk = a.this.eGS.x - a.this.mListView.getPaddingLeft();
        }

        private int bka() {
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            int dividerHeight = (a.this.eHi + a.this.mListView.getDividerHeight()) / 2;
            View childAt = a.this.mListView.getChildAt(this.eIh - firstVisiblePosition);
            if (childAt != null) {
                if (this.eIh == this.eIi) {
                    return childAt.getTop();
                }
                if (this.eIh >= this.eIi) {
                    return (childAt.getBottom() + dividerHeight) - a.this.cAn;
                }
                return childAt.getTop() - dividerHeight;
            }
            cancel();
            return -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void s(float f, float f2) {
            int bka = bka();
            float paddingLeft = a.this.eGS.x - a.this.mListView.getPaddingLeft();
            float f3 = 1.0f - f2;
            if (f3 < Math.abs((a.this.eGS.y - bka) / this.eIj) || f3 < Math.abs(paddingLeft / this.eIk)) {
                a.this.eGS.y = bka + ((int) (this.eIj * f3));
                a.this.eGS.x = a.this.mListView.getPaddingLeft() + ((int) (this.eIk * f3));
                a.this.iM(true);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.bjO();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class k extends m {
        private int eIi;
        private float eIp;
        private float eIq;
        private float eIr;
        private int eIs;
        private int eIt;
        private int eIu;
        private int eIv;

        public k(float f, int i) {
            super(f, i);
            this.eIs = -1;
            this.eIt = -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.eIs = -1;
            this.eIt = -1;
            this.eIu = a.this.eGZ;
            this.eIv = a.this.eHa;
            this.eIi = a.this.eHc;
            a.this.mDragState = 1;
            this.eIp = a.this.eGS.x;
            if (a.this.eHN) {
                float width = a.this.mListView.getWidth() * 2.0f;
                if (a.this.eHO == 0.0f) {
                    a.this.eHO = (this.eIp >= 0.0f ? 1 : -1) * width;
                    return;
                }
                float f = width * 2.0f;
                if (a.this.eHO >= 0.0f || a.this.eHO <= (-f)) {
                    if (a.this.eHO > 0.0f && a.this.eHO < f) {
                        a.this.eHO = f;
                        return;
                    }
                    return;
                }
                a.this.eHO = -f;
                return;
            }
            a.this.bjW();
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void s(float f, float f2) {
            View childAt;
            float f3 = 1.0f - f2;
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            View childAt2 = a.this.mListView.getChildAt(this.eIu - firstVisiblePosition);
            if (a.this.eHN) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / 1000.0f;
                if (uptimeMillis != 0.0f) {
                    float f4 = a.this.eHO * uptimeMillis;
                    int width = a.this.mListView.getWidth();
                    a.this.eHO = ((a.this.eHO > 0.0f ? 1 : -1) * uptimeMillis * width) + a.this.eHO;
                    this.eIp += f4;
                    a.this.eGS.x = (int) this.eIp;
                    if (this.eIp < width && this.eIp > (-width)) {
                        this.mStartTime = SystemClock.uptimeMillis();
                        a.this.iM(true);
                        return;
                    }
                } else {
                    return;
                }
            }
            if (childAt2 != null) {
                if (this.eIs == -1) {
                    this.eIs = a.this.f(this.eIu, childAt2, false);
                    this.eIq = childAt2.getHeight() - this.eIs;
                }
                int max = Math.max((int) (this.eIq * f3), 1);
                ViewGroup.LayoutParams layoutParams = childAt2.getLayoutParams();
                layoutParams.height = max + this.eIs;
                childAt2.setLayoutParams(layoutParams);
            }
            if (this.eIv != this.eIu && (childAt = a.this.mListView.getChildAt(this.eIv - firstVisiblePosition)) != null) {
                if (this.eIt == -1) {
                    this.eIt = a.this.f(this.eIv, childAt, false);
                    this.eIr = childAt.getHeight() - this.eIt;
                }
                int max2 = Math.max((int) (this.eIr * f3), 1);
                ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
                layoutParams2.height = max2 + this.eIt;
                childAt.setLayoutParams(layoutParams2);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.bjP();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class j extends m {
        final /* synthetic */ a eHT;
        private float eIn;
        private float eIo;

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.eIn = this.eHT.eHe;
            this.eIo = this.eHT.eHj;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void s(float f, float f2) {
            if (this.eHT.mDragState != 4) {
                cancel();
                return;
            }
            this.eHT.eHe = (int) ((this.eIo * f2) + ((1.0f - f2) * this.eIn));
            this.eHT.eGS.y = this.eHT.mY - this.eHT.eHe;
            this.eHT.iM(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e {
        StringBuilder mBuilder = new StringBuilder();
        private int eIe = 0;
        private int eIf = 0;
        private boolean eIg = false;
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

        public void bjY() {
            this.mBuilder.append("<DSLVStates>\n");
            this.eIf = 0;
            this.eIg = true;
        }

        public void bjZ() {
            if (this.eIg) {
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
                this.mBuilder.append("    <FirstExpPos>").append(a.this.eGZ).append("</FirstExpPos>\n");
                this.mBuilder.append("    <FirstExpBlankHeight>").append(a.this.ok(a.this.eGZ) - a.this.om(a.this.eGZ)).append("</FirstExpBlankHeight>\n");
                this.mBuilder.append("    <SecondExpPos>").append(a.this.eHa).append("</SecondExpPos>\n");
                this.mBuilder.append("    <SecondExpBlankHeight>").append(a.this.ok(a.this.eHa) - a.this.om(a.this.eHa)).append("</SecondExpBlankHeight>\n");
                this.mBuilder.append("    <SrcPos>").append(a.this.eHc).append("</SrcPos>\n");
                this.mBuilder.append("    <SrcHeight>").append(a.this.cAn + a.this.mListView.getDividerHeight()).append("</SrcHeight>\n");
                this.mBuilder.append("    <ViewHeight>").append(a.this.mListView.getHeight()).append("</ViewHeight>\n");
                this.mBuilder.append("    <LastY>").append(a.this.mLastY).append("</LastY>\n");
                this.mBuilder.append("    <FloatY>").append(a.this.eGU).append("</FloatY>\n");
                this.mBuilder.append("    <ShuffleEdges>");
                for (int i4 = 0; i4 < childCount; i4++) {
                    this.mBuilder.append(a.this.aY(firstVisiblePosition + i4, a.this.mListView.getChildAt(i4).getTop())).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                this.mBuilder.append("</ShuffleEdges>\n");
                this.mBuilder.append("</DSLVState>\n");
                this.eIe++;
                if (this.eIe > 1000) {
                    flush();
                    this.eIe = 0;
                }
            }
        }

        public void flush() {
            if (this.eIg) {
                try {
                    FileWriter fileWriter = new FileWriter(this.mFile, this.eIf != 0);
                    fileWriter.write(this.mBuilder.toString());
                    this.mBuilder.delete(0, this.mBuilder.length());
                    fileWriter.flush();
                    fileWriter.close();
                    this.eIf++;
                } catch (IOException e) {
                }
            }
        }

        public void stopTracking() {
            if (this.eIg) {
                this.mBuilder.append("</DSLVStates>\n");
                flush();
                this.eIg = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements Runnable {
        private boolean eHW;
        private long eHX;
        private long eHY;
        private int eHZ;
        private float eIa;
        private long eIb;
        private int eIc;
        private float eId;
        private boolean mScrolling = false;

        public boolean isScrolling() {
            return this.mScrolling;
        }

        public int bjX() {
            if (this.mScrolling) {
                return this.eIc;
            }
            return -1;
        }

        public d() {
        }

        public void on(int i) {
            if (!this.mScrolling) {
                this.eHW = false;
                this.mScrolling = true;
                this.eIb = SystemClock.uptimeMillis();
                this.eHX = this.eIb;
                this.eIc = i;
                a.this.mListView.post(this);
            }
        }

        public void iN(boolean z) {
            if (z) {
                a.this.mListView.removeCallbacks(this);
                this.mScrolling = false;
                return;
            }
            this.eHW = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.eHW) {
                int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
                int lastVisiblePosition = a.this.mListView.getLastVisiblePosition();
                int count = a.this.mListView.getCount();
                int paddingTop = a.this.mListView.getPaddingTop();
                int height = (a.this.mListView.getHeight() - paddingTop) - a.this.mListView.getPaddingBottom();
                int min = Math.min(a.this.mY, a.this.eGU + a.this.eHj);
                int max = Math.max(a.this.mY, a.this.eGU - a.this.eHj);
                if (this.eIc == 0) {
                    View childAt = a.this.mListView.getChildAt(0);
                    if (childAt == null) {
                        this.mScrolling = false;
                        return;
                    } else if (firstVisiblePosition == 0 && childAt.getTop() == paddingTop) {
                        this.mScrolling = false;
                        return;
                    } else {
                        this.eId = a.this.eHv.b((a.this.eHr - max) / a.this.eHs, this.eHX);
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
                        this.eId = -a.this.eHv.b((min - a.this.eHq) / a.this.eHt, this.eHX);
                    }
                }
                this.eHY = SystemClock.uptimeMillis();
                this.eIa = (float) (this.eHY - this.eHX);
                this.eHZ = Math.round(this.eId * this.eIa);
                if (this.eHZ >= 0) {
                    this.eHZ = Math.min(height, this.eHZ);
                    lastVisiblePosition = firstVisiblePosition;
                } else {
                    this.eHZ = Math.max(-height, this.eHZ);
                }
                View childAt3 = a.this.mListView.getChildAt(lastVisiblePosition - firstVisiblePosition);
                int top2 = childAt3.getTop() + this.eHZ;
                if (lastVisiblePosition == 0 && top2 > paddingTop) {
                    top2 = paddingTop;
                }
                a.this.mBlockLayoutRequests = true;
                a.this.mListView.setSelectionFromTop(lastVisiblePosition, top2 - paddingTop);
                a.this.layoutChildren();
                a.this.mListView.invalidate();
                a.this.mBlockLayoutRequests = false;
                a.this.h(lastVisiblePosition, childAt3, false);
                this.eHX = this.eHY;
                a.this.mListView.post(this);
                return;
            }
            this.mScrolling = false;
        }
    }
}
