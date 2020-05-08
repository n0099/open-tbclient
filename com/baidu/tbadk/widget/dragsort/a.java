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
    private int cjY;
    private View eiW;
    private int eiZ;
    private int ejB;
    private MotionEvent ejG;
    private C0450a ejK;
    private e ejM;
    private k ejP;
    private j ejQ;
    private f ejR;
    private boolean ejS;
    private com.baidu.tbadk.widget.dragsort.d ejU;
    private com.baidu.tbadk.widget.dragsort.b ejV;
    private int ejd;
    private int eje;
    private int ejf;
    private int ejh;
    private int eji;
    private int ejj;
    private b ejk;
    private g ejl;
    private l ejm;
    private int ejo;
    private d ejq;
    private int ejt;
    private int eju;
    private float ejv;
    private float ejw;
    private float ejx;
    private float ejy;
    private int mLastX;
    private int mLastY;
    private ListView mListView;
    private DataSetObserver mObserver;
    private int mOffsetX;
    private int mOffsetY;
    private int mX;
    private int mY;
    private Point eiX = new Point();
    private Point eiY = new Point();
    private boolean eja = false;
    private float ejb = 1.0f;
    private float ejc = 1.0f;
    private boolean ejg = false;
    private boolean cyJ = true;
    private int mDragState = 0;
    private int ejn = 1;
    private int mWidthMeasureSpec = 0;
    private View[] ejp = new View[1];
    private float ejr = 0.33333334f;
    private float ejs = 0.33333334f;
    private float ejz = 0.5f;
    private c ejA = new c() { // from class: com.baidu.tbadk.widget.dragsort.a.1
        @Override // com.baidu.tbadk.widget.dragsort.a.c
        public float b(float f2, long j2) {
            return a.this.ejz * f2;
        }
    };
    private int ejC = 0;
    private boolean ejD = false;
    private boolean ejE = false;
    private h ejF = null;
    private int ejH = 0;
    private float ejI = 0.25f;
    private float ejJ = 0.0f;
    private boolean ejL = false;
    private boolean mBlockLayoutRequests = false;
    private boolean ejN = false;
    private i ejO = new i(3);
    private float ejT = 0.0f;
    private boolean ejW = false;
    private boolean ejX = false;

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

        void bk(View view);

        View nn(int i);
    }

    /* loaded from: classes.dex */
    public interface l {
        void remove(int i);
    }

    public a(ListView listView, com.baidu.tbadk.widget.dragsort.d dVar) {
        this.ejU = dVar;
        this.mListView = listView;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            this.ejK = new C0450a(listAdapter);
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
            this.ejK = null;
        }
        this.ejU.setAdapter(this.ejK);
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
            if (i2 > this.ejh) {
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
    public int nj(int i2) {
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        return childAt != null ? childAt.getHeight() : aS(i2, nl(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aQ(int i2, int i3) {
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        if (i2 <= headerViewsCount || i2 >= this.mListView.getCount() - footerViewsCount) {
            return i3;
        }
        int dividerHeight = this.mListView.getDividerHeight();
        int i4 = this.cjY - this.ejn;
        int nl = nl(i2);
        int nj = nj(i2);
        if (this.ejf <= this.ejh) {
            if (i2 == this.ejf && this.eje != this.ejf) {
                if (i2 == this.ejh) {
                    i3 = (i3 + nj) - this.cjY;
                } else {
                    i3 = ((nj - nl) + i3) - i4;
                }
            } else if (i2 > this.ejf && i2 <= this.ejh) {
                i3 -= i4;
            }
        } else if (i2 > this.ejh && i2 <= this.eje) {
            i3 += i4;
        } else if (i2 == this.ejf && this.eje != this.ejf) {
            i3 += nj - nl;
        }
        if (i2 <= this.ejh) {
            return (((this.cjY - dividerHeight) - nl(i2 - 1)) / 2) + i3;
        }
        return (((nl - dividerHeight) - this.cjY) / 2) + i3;
    }

    private boolean bbn() {
        int i2;
        int i3;
        int i4;
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int i5 = this.eje;
        View childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        if (childAt == null) {
            i5 = firstVisiblePosition + (this.mListView.getChildCount() / 2);
            childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        }
        int top2 = childAt.getTop();
        int height = childAt.getHeight();
        int aQ = aQ(i5, top2);
        int dividerHeight = this.mListView.getDividerHeight();
        if (this.eiZ >= aQ) {
            int count = this.mListView.getCount();
            int i6 = height;
            int i7 = top2;
            i2 = aQ;
            i3 = i5;
            i4 = aQ;
            while (true) {
                if (i3 < count) {
                    if (i3 == count - 1) {
                        i2 = i7 + dividerHeight + i6;
                        break;
                    }
                    i7 += dividerHeight + i6;
                    i6 = nj(i3 + 1);
                    i2 = aQ(i3 + 1, i7);
                    if (this.eiZ < i2) {
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
            i2 = aQ;
            i3 = i5;
            i4 = aQ;
            while (true) {
                if (i3 < 0) {
                    break;
                }
                i3--;
                int nj = nj(i3);
                if (i3 == 0) {
                    i2 = (i8 - dividerHeight) - nj;
                    break;
                }
                i8 -= nj + dividerHeight;
                i2 = aQ(i3, i8);
                if (this.eiZ >= i2) {
                    break;
                }
                i4 = i2;
            }
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int i9 = this.eje;
        int i10 = this.ejf;
        float f2 = this.ejJ;
        if (this.ejg) {
            int abs = Math.abs(i2 - i4);
            if (this.eiZ >= i2) {
                int i11 = i4;
                i4 = i2;
                i2 = i11;
            }
            int i12 = (int) (abs * this.ejI * 0.5f);
            float f3 = i12;
            int i13 = i4 + i12;
            int i14 = i2 - i12;
            if (this.eiZ < i13) {
                this.eje = i3 - 1;
                this.ejf = i3;
                this.ejJ = ((i13 - this.eiZ) * 0.5f) / f3;
            } else if (this.eiZ < i14) {
                this.eje = i3;
                this.ejf = i3;
            } else {
                this.eje = i3;
                this.ejf = i3 + 1;
                this.ejJ = (1.0f + ((i2 - this.eiZ) / f3)) * 0.5f;
            }
        } else {
            this.eje = i3;
            this.ejf = i3;
        }
        if (this.eje < headerViewsCount) {
            this.eje = headerViewsCount;
            this.ejf = headerViewsCount;
            i3 = headerViewsCount;
        } else if (this.ejf >= this.mListView.getCount() - footerViewsCount) {
            i3 = (this.mListView.getCount() - footerViewsCount) - 1;
            this.eje = i3;
            this.ejf = i3;
        }
        boolean z = (this.eje == i9 && this.ejf == i10 && this.ejJ == f2) ? false : true;
        if (i3 != this.ejd) {
            if (this.ejk != null) {
                this.ejk.drag(this.ejd - headerViewsCount, i3 - headerViewsCount);
            }
            this.ejd = i3;
            return true;
        }
        return z;
    }

    public void removeItem(int i2) {
        this.ejS = false;
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
            this.ejn = Math.max(1, obtainStyledAttributes.getDimensionPixelSize(12, 1));
            this.ejL = obtainStyledAttributes.getBoolean(6, false);
            if (this.ejL) {
                this.ejM = new e();
            }
            this.ejb = obtainStyledAttributes.getFloat(10, this.ejb);
            this.ejc = this.ejb;
            this.cyJ = obtainStyledAttributes.getBoolean(13, this.cyJ);
            this.ejI = Math.max(0.0f, Math.min(1.0f, 1.0f - obtainStyledAttributes.getFloat(2, 0.75f)));
            this.ejg = this.ejI > 0.0f;
            setDragScrollStart(obtainStyledAttributes.getFloat(14, this.ejr));
            this.ejz = obtainStyledAttributes.getFloat(0, this.ejz);
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
                bVar.ih(z);
                bVar.ig(z2);
                bVar.setBackgroundColor(color);
                this.ejF = bVar;
                a(bVar);
            }
            obtainStyledAttributes.recycle();
            i2 = i5;
            i3 = i4;
        }
        this.ejq = new d();
        if (i3 > 0) {
            this.ejP = new k(0.5f, i3);
        }
        if (i2 > 0) {
            this.ejR = new f(0.5f, i2);
        }
        this.ejG = MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
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
        this.ejV = bVar;
        this.mListView.setOnTouchListener(bVar);
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void dispatchDraw(Canvas canvas) {
        float f2;
        this.ejU.dispatchDraw(canvas);
        if (this.mDragState != 0) {
            if (this.eje != this.ejh) {
                b(this.eje, canvas);
            }
            if (this.ejf != this.eje && this.ejf != this.ejh) {
                b(this.ejf, canvas);
            }
        }
        if (this.eiW != null) {
            int width = this.eiW.getWidth();
            int height = this.eiW.getHeight();
            int i2 = this.eiX.x;
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
            int i3 = (int) (f2 * 255.0f * this.ejc);
            canvas.save();
            canvas.translate(this.eiX.x, this.eiX.y);
            canvas.clipRect(0, 0, width, height);
            canvas.saveLayerAlpha(0.0f, 0.0f, width, height, i3, 31);
            this.eiW.draw(canvas);
            canvas.restore();
            canvas.restore();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onDraw(Canvas canvas) {
        this.ejU.onDraw(canvas);
        if (this.ejL) {
            this.ejM.bbA();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.ejN) {
            this.ejN = false;
            return false;
        } else if (!this.cyJ) {
            return this.ejU.onTouchEvent(motionEvent);
        } else {
            boolean z2 = this.ejD;
            this.ejD = false;
            if (!z2) {
                r(motionEvent);
            }
            if (this.mDragState == 4) {
                onDragTouchEvent(motionEvent);
                return true;
            }
            if (this.mDragState == 0 && this.ejU.onTouchEvent(motionEvent)) {
                z = true;
            }
            switch (motionEvent.getAction() & 255) {
                case 1:
                case 3:
                    bbs();
                    return z;
                case 2:
                default:
                    if (z) {
                        this.ejH = 1;
                        return z;
                    }
                    return z;
            }
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (!this.cyJ) {
            return this.ejU.onInterceptTouchEvent(motionEvent);
        }
        if (this.ejV != null) {
            this.ejV.bbC().onTouchEvent(motionEvent);
        }
        r(motionEvent);
        this.ejD = true;
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            if (this.mDragState != 0) {
                this.ejN = true;
                return true;
            }
            this.ejE = true;
        }
        if (this.eiW == null) {
            if (this.ejU.onInterceptTouchEvent(motionEvent)) {
                this.ejW = true;
                z = true;
            } else {
                z = false;
            }
            switch (action) {
                case 1:
                case 3:
                    bbs();
                    break;
                case 2:
                default:
                    if (z) {
                        this.ejH = 1;
                        break;
                    } else {
                        this.ejH = 2;
                        break;
                    }
            }
        } else {
            z = true;
        }
        if (action == 1 || action == 3) {
            this.ejE = false;
        }
        return z;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        this.ejU.onSizeChanged(i2, i3, i4, i5);
        bbt();
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void requestLayout() {
        if (!this.mBlockLayoutRequests) {
            this.ejU.requestLayout();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onMeasure(int i2, int i3) {
        this.ejU.onMeasure(i2, i3);
        if (this.eiW != null) {
            if (this.eiW.isLayoutRequested()) {
                bbv();
            }
            this.eja = true;
        }
        this.mWidthMeasureSpec = i2;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void layoutChildren() {
        this.ejU.layoutChildren();
        if (this.eiW != null) {
            if (this.eiW.isLayoutRequested() && !this.eja) {
                bbv();
            }
            this.eiW.layout(0, 0, this.eiW.getMeasuredWidth(), this.eiW.getMeasuredHeight());
            this.eja = false;
        }
    }

    public void removeItem(int i2, float f2) {
        if (this.mDragState == 0 || this.mDragState == 4) {
            if (this.mDragState == 0) {
                this.ejh = this.mListView.getHeaderViewsCount() + i2;
                this.eje = this.ejh;
                this.ejf = this.ejh;
                this.ejd = this.ejh;
                View childAt = this.mListView.getChildAt(this.ejh - this.mListView.getFirstVisiblePosition());
                if (childAt != null) {
                    childAt.setVisibility(4);
                }
            }
            this.mDragState = 1;
            this.ejT = f2;
            if (this.ejE) {
                switch (this.ejH) {
                    case 1:
                        this.ejU.onTouchEvent(this.ejG);
                        break;
                    case 2:
                        this.ejU.onInterceptTouchEvent(this.ejG);
                        break;
                }
            }
            if (this.ejP != null) {
                this.ejP.start();
            } else {
                nk(i2);
            }
        }
    }

    public void cancelDrag() {
        if (this.mDragState == 4) {
            this.ejq.m31if(true);
            bbx();
            bbo();
            bbu();
            if (this.ejE) {
                this.mDragState = 3;
            } else {
                this.mDragState = 0;
            }
        }
    }

    private void bbo() {
        this.ejh = -1;
        this.eje = -1;
        this.ejf = -1;
        this.ejd = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbp() {
        this.mDragState = 2;
        if (this.ejl != null && this.ejd >= 0 && this.ejd < this.mListView.getCount()) {
            int headerViewsCount = this.mListView.getHeaderViewsCount();
            this.ejl.drop(this.ejh - headerViewsCount, this.ejd - headerViewsCount);
        }
        bbx();
        bbr();
        bbo();
        bbu();
        if (this.ejE) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbq() {
        nk(this.ejh - this.mListView.getHeaderViewsCount());
    }

    private void nk(int i2) {
        this.mDragState = 1;
        if (this.ejm != null) {
            this.ejm.remove(i2);
        }
        bbx();
        bbr();
        bbo();
        if (this.ejE) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    private void bbr() {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        if (this.ejh < firstVisiblePosition) {
            View childAt = this.mListView.getChildAt(0);
            this.mListView.setSelectionFromTop(firstVisiblePosition - 1, (childAt != null ? childAt.getTop() : 0) - this.mListView.getPaddingTop());
        }
    }

    public boolean stopDrag(boolean z) {
        this.ejS = false;
        return stopDrag(z, 0.0f);
    }

    public boolean stopDragWithVelocity(boolean z, float f2) {
        this.ejS = true;
        return stopDrag(z, f2);
    }

    public boolean stopDrag(boolean z, float f2) {
        if (this.eiW != null) {
            this.ejq.m31if(true);
            if (z) {
                removeItem(this.ejh - this.mListView.getHeaderViewsCount(), f2);
            } else if (this.ejR != null) {
                this.ejR.start();
            } else {
                bbp();
            }
            if (this.ejL) {
                this.ejM.stopTracking();
                return true;
            }
            return true;
        }
        return false;
    }

    private void bbs() {
        this.ejH = 0;
        this.ejE = false;
        if (this.mDragState == 3) {
            this.mDragState = 0;
        }
        this.ejc = this.ejb;
        this.ejW = false;
        this.ejO.clear();
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
        return this.ejW;
    }

    public void setDragScrollStart(float f2) {
        setDragScrollStarts(f2, f2);
    }

    public void setDragScrollStarts(float f2, float f3) {
        if (f3 > 0.5f) {
            this.ejs = 0.5f;
        } else {
            this.ejs = f3;
        }
        if (f2 > 0.5f) {
            this.ejr = 0.5f;
        } else {
            this.ejr = f2;
        }
        if (this.mListView.getHeight() != 0) {
            bbt();
        }
    }

    private void aR(int i2, int i3) {
        this.eiX.x = i2 - this.eji;
        this.eiX.y = i3 - this.ejj;
        ie(true);
        int min = Math.min(i3, this.eiZ + this.ejo);
        int max = Math.max(i3, this.eiZ - this.ejo);
        int bby = this.ejq.bby();
        if (min > this.mLastY && min > this.eju && bby != 1) {
            if (bby != -1) {
                this.ejq.m31if(true);
            }
            this.ejq.nm(1);
        } else if (max < this.mLastY && max < this.ejt && bby != 0) {
            if (bby != -1) {
                this.ejq.m31if(true);
            }
            this.ejq.nm(0);
        } else if (max >= this.ejt && min <= this.eju && this.ejq.isScrolling()) {
            this.ejq.m31if(true);
        }
    }

    private void bbt() {
        int height;
        int paddingTop = this.mListView.getPaddingTop();
        float height2 = (this.mListView.getHeight() - paddingTop) - this.mListView.getPaddingBottom();
        this.ejw = paddingTop + (this.ejr * height2);
        this.ejv = (height2 * (1.0f - this.ejs)) + paddingTop;
        this.ejt = (int) this.ejw;
        this.eju = (int) this.ejv;
        this.ejx = this.ejw - paddingTop;
        this.ejy = (paddingTop + height) - this.ejv;
    }

    private void bbu() {
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
        if (i2 != this.ejh && i2 != this.eje && i2 != this.ejf) {
            g2 = -2;
        } else {
            g2 = g(i2, view, z);
        }
        if (g2 != layoutParams.height) {
            layoutParams.height = g2;
            view.setLayoutParams(layoutParams);
        }
        if (i2 == this.eje || i2 == this.ejf) {
            if (i2 < this.ejh) {
                ((DragSortItemView) view).setGravity(80);
            } else if (i2 > this.ejh) {
                ((DragSortItemView) view).setGravity(48);
            }
        }
        int visibility = view.getVisibility();
        int i3 = 0;
        if (i2 == this.ejh && this.eiW != null) {
            i3 = 4;
        }
        if (i3 != visibility) {
            view.setVisibility(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int nl(int i2) {
        View view;
        if (i2 == this.ejh) {
            return 0;
        }
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        if (childAt != null) {
            return f(i2, childAt, false);
        }
        int i3 = this.ejO.get(i2);
        if (i3 == -1) {
            ListAdapter adapter = this.mListView.getAdapter();
            int itemViewType = adapter.getItemViewType(i2);
            int viewTypeCount = adapter.getViewTypeCount();
            if (viewTypeCount != this.ejp.length) {
                this.ejp = new View[viewTypeCount];
            }
            if (itemViewType >= 0) {
                if (this.ejp[itemViewType] == null) {
                    view = adapter.getView(i2, null, this.mListView);
                    this.ejp[itemViewType] = view;
                } else {
                    view = adapter.getView(i2, this.ejp[itemViewType], this.mListView);
                }
            } else {
                view = adapter.getView(i2, null, this.mListView);
            }
            int f2 = f(i2, view, true);
            this.ejO.aT(i2, f2);
            return f2;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(int i2, View view, boolean z) {
        if (i2 == this.ejh) {
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
        return aS(i2, f(i2, view, z));
    }

    private int aS(int i2, int i3) {
        this.mListView.getDividerHeight();
        boolean z = this.ejg && this.eje != this.ejf;
        int i4 = this.cjY - this.ejn;
        int i5 = (int) (this.ejJ * i4);
        if (i2 == this.ejh) {
            if (this.ejh == this.eje) {
                if (z) {
                    return i5 + this.ejn;
                }
                return this.cjY;
            } else if (this.ejh == this.ejf) {
                return this.cjY - i5;
            } else {
                return this.ejn;
            }
        } else if (i2 == this.eje) {
            if (z) {
                return i3 + i5;
            }
            return i3 + i4;
        } else if (i2 == this.ejf) {
            return (i3 + i4) - i5;
        } else {
            return i3;
        }
    }

    private int b(int i2, View view, int i3, int i4) {
        int i5;
        int i6;
        int nl = nl(i2);
        int height = view.getHeight();
        int aS = aS(i2, nl);
        if (i2 != this.ejh) {
            i6 = height - nl;
            i5 = aS - nl;
        } else {
            i5 = aS;
            i6 = height;
        }
        int i7 = this.cjY;
        if (this.ejh != this.eje && this.ejh != this.ejf) {
            i7 -= this.ejn;
        }
        if (i2 <= i3) {
            if (i2 > this.eje) {
                return (i7 - i5) + 0;
            }
        } else if (i2 == i4) {
            if (i2 <= this.eje) {
                return (i6 - i7) + 0;
            }
            if (i2 == this.ejf) {
                return (height - aS) + 0;
            }
            return 0 + i6;
        } else if (i2 <= this.eje) {
            return 0 - i7;
        } else {
            if (i2 == this.ejf) {
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

    private void bbv() {
        if (this.eiW != null) {
            measureItem(this.eiW);
            this.cjY = this.eiW.getMeasuredHeight();
            this.ejo = this.cjY / 2;
        }
    }

    protected boolean onDragTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        switch (motionEvent.getAction() & 255) {
            case 1:
                if (this.mDragState == 4) {
                    stopDrag(false);
                }
                bbs();
                return true;
            case 2:
                aR((int) motionEvent.getX(), (int) motionEvent.getY());
                return true;
            case 3:
                if (this.mDragState == 4) {
                    cancelDrag();
                }
                bbs();
                return true;
            default:
                return true;
        }
    }

    public boolean startDrag(int i2, int i3, int i4, int i5) {
        View nn;
        if (!this.ejE || this.ejF == null || (nn = this.ejF.nn(i2)) == null) {
            return false;
        }
        return startDrag(i2, nn, i3, i4, i5);
    }

    public boolean startDrag(int i2, View view, int i3, int i4, int i5) {
        if (this.mDragState == 0 && this.ejE && this.eiW == null && view != null && this.cyJ) {
            if (this.mListView.getParent() != null) {
                this.mListView.getParent().requestDisallowInterceptTouchEvent(true);
            }
            int headerViewsCount = this.mListView.getHeaderViewsCount() + i2;
            this.eje = headerViewsCount;
            this.ejf = headerViewsCount;
            this.ejh = headerViewsCount;
            this.ejd = headerViewsCount;
            this.mDragState = 4;
            this.ejC = 0;
            this.ejC |= i3;
            this.eiW = view;
            bbv();
            this.eji = i4;
            this.ejj = i5;
            this.ejB = this.mY;
            this.eiX.x = this.mX - this.eji;
            this.eiX.y = this.mY - this.ejj;
            View childAt = this.mListView.getChildAt(this.ejh - this.mListView.getFirstVisiblePosition());
            if (childAt != null) {
                childAt.setVisibility(4);
            }
            if (this.ejL) {
                this.ejM.bbz();
            }
            switch (this.ejH) {
                case 1:
                    this.ejU.onTouchEvent(this.ejG);
                    break;
                case 2:
                    this.ejU.onInterceptTouchEvent(this.ejG);
                    break;
            }
            this.mListView.requestLayout();
            if (this.ejQ != null) {
                this.ejQ.start();
                return true;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ie(boolean z) {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition() + (this.mListView.getChildCount() / 2);
        View childAt = this.mListView.getChildAt(this.mListView.getChildCount() / 2);
        if (childAt != null) {
            h(firstVisiblePosition, childAt, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i2, View view, boolean z) {
        this.mBlockLayoutRequests = true;
        bbw();
        int i3 = this.eje;
        int i4 = this.ejf;
        boolean bbn = bbn();
        if (bbn) {
            bbu();
            this.mListView.setSelectionFromTop(i2, (b(i2, view, i3, i4) + view.getTop()) - this.mListView.getPaddingTop());
            layoutChildren();
        }
        if (bbn || z) {
            this.mListView.invalidate();
        }
        this.mBlockLayoutRequests = false;
    }

    private void bbw() {
        if (this.ejF != null) {
            this.eiY.set(this.mX, this.mY);
            this.ejF.b(this.eiW, this.eiX, this.eiY);
        }
        int i2 = this.eiX.x;
        int i3 = this.eiX.y;
        int paddingLeft = this.mListView.getPaddingLeft();
        if ((this.ejC & 1) == 0 && i2 > paddingLeft) {
            this.eiX.x = paddingLeft;
        } else if ((this.ejC & 2) == 0 && i2 < paddingLeft) {
            this.eiX.x = paddingLeft;
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int lastVisiblePosition = this.mListView.getLastVisiblePosition();
        int paddingTop = this.mListView.getPaddingTop();
        if (firstVisiblePosition < headerViewsCount) {
            paddingTop = this.mListView.getChildAt((headerViewsCount - firstVisiblePosition) - 1).getBottom();
        }
        if ((this.ejC & 8) == 0 && firstVisiblePosition <= this.ejh) {
            paddingTop = Math.max(this.mListView.getChildAt(this.ejh - firstVisiblePosition).getTop(), paddingTop);
        }
        int height = this.mListView.getHeight() - this.mListView.getPaddingBottom();
        if (lastVisiblePosition >= (this.mListView.getCount() - footerViewsCount) - 1) {
            height = this.mListView.getChildAt(((this.mListView.getCount() - footerViewsCount) - 1) - firstVisiblePosition).getBottom();
        }
        if ((this.ejC & 4) == 0 && lastVisiblePosition >= this.ejh) {
            height = Math.min(this.mListView.getChildAt(this.ejh - firstVisiblePosition).getBottom(), height);
        }
        if (i3 < paddingTop) {
            this.eiX.y = paddingTop;
        } else if (this.cjY + i3 > height) {
            this.eiX.y = height - this.cjY;
        }
        this.eiZ = this.eiX.y + this.ejo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbx() {
        if (this.eiW != null) {
            this.eiW.setVisibility(8);
            if (this.ejF != null) {
                this.ejF.bk(this.eiW);
            }
            this.eiW = null;
            this.mListView.invalidate();
        }
    }

    public void a(h hVar) {
        this.ejF = hVar;
    }

    public void a(b bVar) {
        this.ejk = bVar;
    }

    public void setDragEnabled(boolean z) {
        this.cyJ = z;
    }

    public boolean isDragEnabled() {
        return this.cyJ;
    }

    public void a(g gVar) {
        this.ejl = gVar;
    }

    public void a(l lVar) {
        this.ejm = lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class i {
        private SparseIntArray ekp;
        private ArrayList<Integer> ekq;
        private int mMaxSize;

        public i(int i) {
            this.ekp = new SparseIntArray(i);
            this.ekq = new ArrayList<>(i);
            this.mMaxSize = i;
        }

        public void aT(int i, int i2) {
            int i3 = this.ekp.get(i, -1);
            if (i3 != i2) {
                if (i3 == -1) {
                    if (this.ekp.size() == this.mMaxSize) {
                        this.ekp.delete(this.ekq.remove(0).intValue());
                    }
                } else {
                    this.ekq.remove(Integer.valueOf(i));
                }
                this.ekp.put(i, i2);
                this.ekq.add(Integer.valueOf(i));
            }
        }

        public int get(int i) {
            return this.ekp.get(i, -1);
        }

        public void clear() {
            this.ekp.clear();
            this.ekq.clear();
        }
    }

    /* renamed from: com.baidu.tbadk.widget.dragsort.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0450a extends BaseAdapter {
        private ListAdapter mAdapter;

        public C0450a(ListAdapter listAdapter) {
            this.mAdapter = listAdapter;
            this.mAdapter.registerDataSetObserver(new DataSetObserver() { // from class: com.baidu.tbadk.widget.dragsort.a.a.1
                @Override // android.database.DataSetObserver
                public void onChanged() {
                    C0450a.this.notifyDataSetChanged();
                }

                @Override // android.database.DataSetObserver
                public void onInvalidated() {
                    C0450a.this.notifyDataSetInvalidated();
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
        private float bFK;
        private float bFL;
        private float bFM;
        private float bFN;
        private float ekA;
        private float mAlpha;
        private boolean mCanceled;
        protected long mStartTime;

        public m(float f, int i) {
            this.mAlpha = f;
            this.ekA = i;
            float f2 = 1.0f / ((this.mAlpha * 2.0f) * (1.0f - this.mAlpha));
            this.bFN = f2;
            this.bFK = f2;
            this.bFL = this.mAlpha / ((this.mAlpha - 1.0f) * 2.0f);
            this.bFM = 1.0f / (1.0f - this.mAlpha);
        }

        public float ab(float f) {
            if (f < this.mAlpha) {
                return this.bFK * f * f;
            }
            if (f < 1.0f - this.mAlpha) {
                return this.bFL + (this.bFM * f);
            }
            return 1.0f - ((this.bFN * (f - 1.0f)) * (f - 1.0f));
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
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / this.ekA;
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
        private int ekl;
        private int ekm;
        private float ekn;
        private float eko;

        public f(float f, int i) {
            super(f, i);
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.ekl = a.this.ejd;
            this.ekm = a.this.ejh;
            a.this.mDragState = 2;
            this.ekn = a.this.eiX.y - bbB();
            this.eko = a.this.eiX.x - a.this.mListView.getPaddingLeft();
        }

        private int bbB() {
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            int dividerHeight = (a.this.ejn + a.this.mListView.getDividerHeight()) / 2;
            View childAt = a.this.mListView.getChildAt(this.ekl - firstVisiblePosition);
            if (childAt != null) {
                if (this.ekl == this.ekm) {
                    return childAt.getTop();
                }
                if (this.ekl >= this.ekm) {
                    return (childAt.getBottom() + dividerHeight) - a.this.cjY;
                }
                return childAt.getTop() - dividerHeight;
            }
            cancel();
            return -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void s(float f, float f2) {
            int bbB = bbB();
            float paddingLeft = a.this.eiX.x - a.this.mListView.getPaddingLeft();
            float f3 = 1.0f - f2;
            if (f3 < Math.abs((a.this.eiX.y - bbB) / this.ekn) || f3 < Math.abs(paddingLeft / this.eko)) {
                a.this.eiX.y = bbB + ((int) (this.ekn * f3));
                a.this.eiX.x = a.this.mListView.getPaddingLeft() + ((int) (this.eko * f3));
                a.this.ie(true);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.bbp();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class k extends m {
        private int ekm;
        private float ekt;
        private float eku;
        private float ekv;
        private int ekw;
        private int ekx;
        private int eky;
        private int ekz;

        public k(float f, int i) {
            super(f, i);
            this.ekw = -1;
            this.ekx = -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.ekw = -1;
            this.ekx = -1;
            this.eky = a.this.eje;
            this.ekz = a.this.ejf;
            this.ekm = a.this.ejh;
            a.this.mDragState = 1;
            this.ekt = a.this.eiX.x;
            if (a.this.ejS) {
                float width = a.this.mListView.getWidth() * 2.0f;
                if (a.this.ejT == 0.0f) {
                    a.this.ejT = (this.ekt >= 0.0f ? 1 : -1) * width;
                    return;
                }
                float f = width * 2.0f;
                if (a.this.ejT >= 0.0f || a.this.ejT <= (-f)) {
                    if (a.this.ejT > 0.0f && a.this.ejT < f) {
                        a.this.ejT = f;
                        return;
                    }
                    return;
                }
                a.this.ejT = -f;
                return;
            }
            a.this.bbx();
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void s(float f, float f2) {
            View childAt;
            float f3 = 1.0f - f2;
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            View childAt2 = a.this.mListView.getChildAt(this.eky - firstVisiblePosition);
            if (a.this.ejS) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / 1000.0f;
                if (uptimeMillis != 0.0f) {
                    float f4 = a.this.ejT * uptimeMillis;
                    int width = a.this.mListView.getWidth();
                    a.this.ejT = ((a.this.ejT > 0.0f ? 1 : -1) * uptimeMillis * width) + a.this.ejT;
                    this.ekt += f4;
                    a.this.eiX.x = (int) this.ekt;
                    if (this.ekt < width && this.ekt > (-width)) {
                        this.mStartTime = SystemClock.uptimeMillis();
                        a.this.ie(true);
                        return;
                    }
                } else {
                    return;
                }
            }
            if (childAt2 != null) {
                if (this.ekw == -1) {
                    this.ekw = a.this.f(this.eky, childAt2, false);
                    this.eku = childAt2.getHeight() - this.ekw;
                }
                int max = Math.max((int) (this.eku * f3), 1);
                ViewGroup.LayoutParams layoutParams = childAt2.getLayoutParams();
                layoutParams.height = max + this.ekw;
                childAt2.setLayoutParams(layoutParams);
            }
            if (this.ekz != this.eky && (childAt = a.this.mListView.getChildAt(this.ekz - firstVisiblePosition)) != null) {
                if (this.ekx == -1) {
                    this.ekx = a.this.f(this.ekz, childAt, false);
                    this.ekv = childAt.getHeight() - this.ekx;
                }
                int max2 = Math.max((int) (this.ekv * f3), 1);
                ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
                layoutParams2.height = max2 + this.ekx;
                childAt.setLayoutParams(layoutParams2);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.bbq();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class j extends m {
        final /* synthetic */ a ejY;
        private float ekr;
        private float eks;

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.ekr = this.ejY.ejj;
            this.eks = this.ejY.ejo;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void s(float f, float f2) {
            if (this.ejY.mDragState != 4) {
                cancel();
                return;
            }
            this.ejY.ejj = (int) ((this.eks * f2) + ((1.0f - f2) * this.ekr));
            this.ejY.eiX.y = this.ejY.mY - this.ejY.ejj;
            this.ejY.ie(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e {
        StringBuilder mBuilder = new StringBuilder();
        private int eki = 0;
        private int ekj = 0;
        private boolean ekk = false;
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

        public void bbz() {
            this.mBuilder.append("<DSLVStates>\n");
            this.ekj = 0;
            this.ekk = true;
        }

        public void bbA() {
            if (this.ekk) {
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
                this.mBuilder.append("    <FirstExpPos>").append(a.this.eje).append("</FirstExpPos>\n");
                this.mBuilder.append("    <FirstExpBlankHeight>").append(a.this.nj(a.this.eje) - a.this.nl(a.this.eje)).append("</FirstExpBlankHeight>\n");
                this.mBuilder.append("    <SecondExpPos>").append(a.this.ejf).append("</SecondExpPos>\n");
                this.mBuilder.append("    <SecondExpBlankHeight>").append(a.this.nj(a.this.ejf) - a.this.nl(a.this.ejf)).append("</SecondExpBlankHeight>\n");
                this.mBuilder.append("    <SrcPos>").append(a.this.ejh).append("</SrcPos>\n");
                this.mBuilder.append("    <SrcHeight>").append(a.this.cjY + a.this.mListView.getDividerHeight()).append("</SrcHeight>\n");
                this.mBuilder.append("    <ViewHeight>").append(a.this.mListView.getHeight()).append("</ViewHeight>\n");
                this.mBuilder.append("    <LastY>").append(a.this.mLastY).append("</LastY>\n");
                this.mBuilder.append("    <FloatY>").append(a.this.eiZ).append("</FloatY>\n");
                this.mBuilder.append("    <ShuffleEdges>");
                for (int i4 = 0; i4 < childCount; i4++) {
                    this.mBuilder.append(a.this.aQ(firstVisiblePosition + i4, a.this.mListView.getChildAt(i4).getTop())).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                this.mBuilder.append("</ShuffleEdges>\n");
                this.mBuilder.append("</DSLVState>\n");
                this.eki++;
                if (this.eki > 1000) {
                    flush();
                    this.eki = 0;
                }
            }
        }

        public void flush() {
            if (this.ekk) {
                try {
                    FileWriter fileWriter = new FileWriter(this.mFile, this.ekj != 0);
                    fileWriter.write(this.mBuilder.toString());
                    this.mBuilder.delete(0, this.mBuilder.length());
                    fileWriter.flush();
                    fileWriter.close();
                    this.ekj++;
                } catch (IOException e) {
                }
            }
        }

        public void stopTracking() {
            if (this.ekk) {
                this.mBuilder.append("</DSLVStates>\n");
                flush();
                this.ekk = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements Runnable {
        private int dy;
        private boolean ekb;
        private long ekc;
        private long ekd;
        private float eke;
        private long ekf;
        private int ekg;
        private float ekh;
        private boolean mScrolling = false;

        public boolean isScrolling() {
            return this.mScrolling;
        }

        public int bby() {
            if (this.mScrolling) {
                return this.ekg;
            }
            return -1;
        }

        public d() {
        }

        public void nm(int i) {
            if (!this.mScrolling) {
                this.ekb = false;
                this.mScrolling = true;
                this.ekf = SystemClock.uptimeMillis();
                this.ekc = this.ekf;
                this.ekg = i;
                a.this.mListView.post(this);
            }
        }

        /* renamed from: if  reason: not valid java name */
        public void m31if(boolean z) {
            if (z) {
                a.this.mListView.removeCallbacks(this);
                this.mScrolling = false;
                return;
            }
            this.ekb = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.ekb) {
                int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
                int lastVisiblePosition = a.this.mListView.getLastVisiblePosition();
                int count = a.this.mListView.getCount();
                int paddingTop = a.this.mListView.getPaddingTop();
                int height = (a.this.mListView.getHeight() - paddingTop) - a.this.mListView.getPaddingBottom();
                int min = Math.min(a.this.mY, a.this.eiZ + a.this.ejo);
                int max = Math.max(a.this.mY, a.this.eiZ - a.this.ejo);
                if (this.ekg == 0) {
                    View childAt = a.this.mListView.getChildAt(0);
                    if (childAt == null) {
                        this.mScrolling = false;
                        return;
                    } else if (firstVisiblePosition == 0 && childAt.getTop() == paddingTop) {
                        this.mScrolling = false;
                        return;
                    } else {
                        this.ekh = a.this.ejA.b((a.this.ejw - max) / a.this.ejx, this.ekc);
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
                        this.ekh = -a.this.ejA.b((min - a.this.ejv) / a.this.ejy, this.ekc);
                    }
                }
                this.ekd = SystemClock.uptimeMillis();
                this.eke = (float) (this.ekd - this.ekc);
                this.dy = Math.round(this.ekh * this.eke);
                if (this.dy >= 0) {
                    this.dy = Math.min(height, this.dy);
                    lastVisiblePosition = firstVisiblePosition;
                } else {
                    this.dy = Math.max(-height, this.dy);
                }
                View childAt3 = a.this.mListView.getChildAt(lastVisiblePosition - firstVisiblePosition);
                int top2 = childAt3.getTop() + this.dy;
                if (lastVisiblePosition == 0 && top2 > paddingTop) {
                    top2 = paddingTop;
                }
                a.this.mBlockLayoutRequests = true;
                a.this.mListView.setSelectionFromTop(lastVisiblePosition, top2 - paddingTop);
                a.this.layoutChildren();
                a.this.mListView.invalidate();
                a.this.mBlockLayoutRequests = false;
                a.this.h(lastVisiblePosition, childAt3, false);
                this.ekc = this.ekd;
                a.this.mListView.post(this);
                return;
            }
            this.mScrolling = false;
        }
    }
}
