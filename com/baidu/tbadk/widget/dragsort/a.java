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
    private int cjS;
    private View eiR;
    private int eiU;
    private int eiY;
    private int eiZ;
    private MotionEvent ejB;
    private C0429a ejF;
    private e ejH;
    private k ejK;
    private j ejL;
    private f ejM;
    private boolean ejN;
    private com.baidu.tbadk.widget.dragsort.d ejP;
    private com.baidu.tbadk.widget.dragsort.b ejQ;
    private int eja;
    private int ejc;
    private int ejd;
    private int eje;
    private b ejf;
    private g ejg;
    private l ejh;
    private int ejj;
    private d ejl;
    private int ejo;
    private int ejp;
    private float ejq;
    private float ejr;
    private float ejs;
    private float ejt;
    private int ejw;
    private int mLastX;
    private int mLastY;
    private ListView mListView;
    private DataSetObserver mObserver;
    private int mOffsetX;
    private int mOffsetY;
    private int mX;
    private int mY;
    private Point eiS = new Point();
    private Point eiT = new Point();
    private boolean eiV = false;
    private float eiW = 1.0f;
    private float eiX = 1.0f;
    private boolean ejb = false;
    private boolean cyD = true;
    private int mDragState = 0;
    private int eji = 1;
    private int mWidthMeasureSpec = 0;
    private View[] ejk = new View[1];
    private float ejm = 0.33333334f;
    private float ejn = 0.33333334f;
    private float eju = 0.5f;
    private c ejv = new c() { // from class: com.baidu.tbadk.widget.dragsort.a.1
        @Override // com.baidu.tbadk.widget.dragsort.a.c
        public float b(float f2, long j2) {
            return a.this.eju * f2;
        }
    };
    private int ejx = 0;
    private boolean ejy = false;
    private boolean ejz = false;
    private h ejA = null;
    private int ejC = 0;
    private float ejD = 0.25f;
    private float ejE = 0.0f;
    private boolean ejG = false;
    private boolean mBlockLayoutRequests = false;
    private boolean ejI = false;
    private i ejJ = new i(3);
    private float ejO = 0.0f;
    private boolean ejR = false;
    private boolean ejS = false;

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
        this.ejP = dVar;
        this.mListView = listView;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            this.ejF = new C0429a(listAdapter);
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
            this.ejF = null;
        }
        this.ejP.setAdapter(this.ejF);
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
            if (i2 > this.ejc) {
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
        int i4 = this.cjS - this.eji;
        int nl = nl(i2);
        int nj = nj(i2);
        if (this.eja <= this.ejc) {
            if (i2 == this.eja && this.eiZ != this.eja) {
                if (i2 == this.ejc) {
                    i3 = (i3 + nj) - this.cjS;
                } else {
                    i3 = ((nj - nl) + i3) - i4;
                }
            } else if (i2 > this.eja && i2 <= this.ejc) {
                i3 -= i4;
            }
        } else if (i2 > this.ejc && i2 <= this.eiZ) {
            i3 += i4;
        } else if (i2 == this.eja && this.eiZ != this.eja) {
            i3 += nj - nl;
        }
        if (i2 <= this.ejc) {
            return (((this.cjS - dividerHeight) - nl(i2 - 1)) / 2) + i3;
        }
        return (((nl - dividerHeight) - this.cjS) / 2) + i3;
    }

    private boolean bbp() {
        int i2;
        int i3;
        int i4;
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int i5 = this.eiZ;
        View childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        if (childAt == null) {
            i5 = firstVisiblePosition + (this.mListView.getChildCount() / 2);
            childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        }
        int top2 = childAt.getTop();
        int height = childAt.getHeight();
        int aQ = aQ(i5, top2);
        int dividerHeight = this.mListView.getDividerHeight();
        if (this.eiU >= aQ) {
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
                    if (this.eiU < i2) {
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
                if (this.eiU >= i2) {
                    break;
                }
                i4 = i2;
            }
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int i9 = this.eiZ;
        int i10 = this.eja;
        float f2 = this.ejE;
        if (this.ejb) {
            int abs = Math.abs(i2 - i4);
            if (this.eiU >= i2) {
                int i11 = i4;
                i4 = i2;
                i2 = i11;
            }
            int i12 = (int) (abs * this.ejD * 0.5f);
            float f3 = i12;
            int i13 = i4 + i12;
            int i14 = i2 - i12;
            if (this.eiU < i13) {
                this.eiZ = i3 - 1;
                this.eja = i3;
                this.ejE = ((i13 - this.eiU) * 0.5f) / f3;
            } else if (this.eiU < i14) {
                this.eiZ = i3;
                this.eja = i3;
            } else {
                this.eiZ = i3;
                this.eja = i3 + 1;
                this.ejE = (1.0f + ((i2 - this.eiU) / f3)) * 0.5f;
            }
        } else {
            this.eiZ = i3;
            this.eja = i3;
        }
        if (this.eiZ < headerViewsCount) {
            this.eiZ = headerViewsCount;
            this.eja = headerViewsCount;
            i3 = headerViewsCount;
        } else if (this.eja >= this.mListView.getCount() - footerViewsCount) {
            i3 = (this.mListView.getCount() - footerViewsCount) - 1;
            this.eiZ = i3;
            this.eja = i3;
        }
        boolean z = (this.eiZ == i9 && this.eja == i10 && this.ejE == f2) ? false : true;
        if (i3 != this.eiY) {
            if (this.ejf != null) {
                this.ejf.drag(this.eiY - headerViewsCount, i3 - headerViewsCount);
            }
            this.eiY = i3;
            return true;
        }
        return z;
    }

    public void removeItem(int i2) {
        this.ejN = false;
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
            this.eji = Math.max(1, obtainStyledAttributes.getDimensionPixelSize(12, 1));
            this.ejG = obtainStyledAttributes.getBoolean(6, false);
            if (this.ejG) {
                this.ejH = new e();
            }
            this.eiW = obtainStyledAttributes.getFloat(10, this.eiW);
            this.eiX = this.eiW;
            this.cyD = obtainStyledAttributes.getBoolean(13, this.cyD);
            this.ejD = Math.max(0.0f, Math.min(1.0f, 1.0f - obtainStyledAttributes.getFloat(2, 0.75f)));
            this.ejb = this.ejD > 0.0f;
            setDragScrollStart(obtainStyledAttributes.getFloat(14, this.ejm));
            this.eju = obtainStyledAttributes.getFloat(0, this.eju);
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
                this.ejA = bVar;
                a(bVar);
            }
            obtainStyledAttributes.recycle();
            i2 = i5;
            i3 = i4;
        }
        this.ejl = new d();
        if (i3 > 0) {
            this.ejK = new k(0.5f, i3);
        }
        if (i2 > 0) {
            this.ejM = new f(0.5f, i2);
        }
        this.ejB = MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
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
        this.ejQ = bVar;
        this.mListView.setOnTouchListener(bVar);
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void dispatchDraw(Canvas canvas) {
        float f2;
        this.ejP.dispatchDraw(canvas);
        if (this.mDragState != 0) {
            if (this.eiZ != this.ejc) {
                b(this.eiZ, canvas);
            }
            if (this.eja != this.eiZ && this.eja != this.ejc) {
                b(this.eja, canvas);
            }
        }
        if (this.eiR != null) {
            int width = this.eiR.getWidth();
            int height = this.eiR.getHeight();
            int i2 = this.eiS.x;
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
            int i3 = (int) (f2 * 255.0f * this.eiX);
            canvas.save();
            canvas.translate(this.eiS.x, this.eiS.y);
            canvas.clipRect(0, 0, width, height);
            canvas.saveLayerAlpha(0.0f, 0.0f, width, height, i3, 31);
            this.eiR.draw(canvas);
            canvas.restore();
            canvas.restore();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onDraw(Canvas canvas) {
        this.ejP.onDraw(canvas);
        if (this.ejG) {
            this.ejH.bbC();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.ejI) {
            this.ejI = false;
            return false;
        } else if (!this.cyD) {
            return this.ejP.onTouchEvent(motionEvent);
        } else {
            boolean z2 = this.ejy;
            this.ejy = false;
            if (!z2) {
                r(motionEvent);
            }
            if (this.mDragState == 4) {
                onDragTouchEvent(motionEvent);
                return true;
            }
            if (this.mDragState == 0 && this.ejP.onTouchEvent(motionEvent)) {
                z = true;
            }
            switch (motionEvent.getAction() & 255) {
                case 1:
                case 3:
                    bbu();
                    return z;
                case 2:
                default:
                    if (z) {
                        this.ejC = 1;
                        return z;
                    }
                    return z;
            }
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (!this.cyD) {
            return this.ejP.onInterceptTouchEvent(motionEvent);
        }
        if (this.ejQ != null) {
            this.ejQ.bbE().onTouchEvent(motionEvent);
        }
        r(motionEvent);
        this.ejy = true;
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            if (this.mDragState != 0) {
                this.ejI = true;
                return true;
            }
            this.ejz = true;
        }
        if (this.eiR == null) {
            if (this.ejP.onInterceptTouchEvent(motionEvent)) {
                this.ejR = true;
                z = true;
            } else {
                z = false;
            }
            switch (action) {
                case 1:
                case 3:
                    bbu();
                    break;
                case 2:
                default:
                    if (z) {
                        this.ejC = 1;
                        break;
                    } else {
                        this.ejC = 2;
                        break;
                    }
            }
        } else {
            z = true;
        }
        if (action == 1 || action == 3) {
            this.ejz = false;
        }
        return z;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        this.ejP.onSizeChanged(i2, i3, i4, i5);
        bbv();
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void requestLayout() {
        if (!this.mBlockLayoutRequests) {
            this.ejP.requestLayout();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onMeasure(int i2, int i3) {
        this.ejP.onMeasure(i2, i3);
        if (this.eiR != null) {
            if (this.eiR.isLayoutRequested()) {
                bbx();
            }
            this.eiV = true;
        }
        this.mWidthMeasureSpec = i2;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void layoutChildren() {
        this.ejP.layoutChildren();
        if (this.eiR != null) {
            if (this.eiR.isLayoutRequested() && !this.eiV) {
                bbx();
            }
            this.eiR.layout(0, 0, this.eiR.getMeasuredWidth(), this.eiR.getMeasuredHeight());
            this.eiV = false;
        }
    }

    public void removeItem(int i2, float f2) {
        if (this.mDragState == 0 || this.mDragState == 4) {
            if (this.mDragState == 0) {
                this.ejc = this.mListView.getHeaderViewsCount() + i2;
                this.eiZ = this.ejc;
                this.eja = this.ejc;
                this.eiY = this.ejc;
                View childAt = this.mListView.getChildAt(this.ejc - this.mListView.getFirstVisiblePosition());
                if (childAt != null) {
                    childAt.setVisibility(4);
                }
            }
            this.mDragState = 1;
            this.ejO = f2;
            if (this.ejz) {
                switch (this.ejC) {
                    case 1:
                        this.ejP.onTouchEvent(this.ejB);
                        break;
                    case 2:
                        this.ejP.onInterceptTouchEvent(this.ejB);
                        break;
                }
            }
            if (this.ejK != null) {
                this.ejK.start();
            } else {
                nk(i2);
            }
        }
    }

    public void cancelDrag() {
        if (this.mDragState == 4) {
            this.ejl.m31if(true);
            bbz();
            bbq();
            bbw();
            if (this.ejz) {
                this.mDragState = 3;
            } else {
                this.mDragState = 0;
            }
        }
    }

    private void bbq() {
        this.ejc = -1;
        this.eiZ = -1;
        this.eja = -1;
        this.eiY = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbr() {
        this.mDragState = 2;
        if (this.ejg != null && this.eiY >= 0 && this.eiY < this.mListView.getCount()) {
            int headerViewsCount = this.mListView.getHeaderViewsCount();
            this.ejg.drop(this.ejc - headerViewsCount, this.eiY - headerViewsCount);
        }
        bbz();
        bbt();
        bbq();
        bbw();
        if (this.ejz) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbs() {
        nk(this.ejc - this.mListView.getHeaderViewsCount());
    }

    private void nk(int i2) {
        this.mDragState = 1;
        if (this.ejh != null) {
            this.ejh.remove(i2);
        }
        bbz();
        bbt();
        bbq();
        if (this.ejz) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    private void bbt() {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        if (this.ejc < firstVisiblePosition) {
            View childAt = this.mListView.getChildAt(0);
            this.mListView.setSelectionFromTop(firstVisiblePosition - 1, (childAt != null ? childAt.getTop() : 0) - this.mListView.getPaddingTop());
        }
    }

    public boolean stopDrag(boolean z) {
        this.ejN = false;
        return stopDrag(z, 0.0f);
    }

    public boolean stopDragWithVelocity(boolean z, float f2) {
        this.ejN = true;
        return stopDrag(z, f2);
    }

    public boolean stopDrag(boolean z, float f2) {
        if (this.eiR != null) {
            this.ejl.m31if(true);
            if (z) {
                removeItem(this.ejc - this.mListView.getHeaderViewsCount(), f2);
            } else if (this.ejM != null) {
                this.ejM.start();
            } else {
                bbr();
            }
            if (this.ejG) {
                this.ejH.stopTracking();
                return true;
            }
            return true;
        }
        return false;
    }

    private void bbu() {
        this.ejC = 0;
        this.ejz = false;
        if (this.mDragState == 3) {
            this.mDragState = 0;
        }
        this.eiX = this.eiW;
        this.ejR = false;
        this.ejJ.clear();
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
        return this.ejR;
    }

    public void setDragScrollStart(float f2) {
        setDragScrollStarts(f2, f2);
    }

    public void setDragScrollStarts(float f2, float f3) {
        if (f3 > 0.5f) {
            this.ejn = 0.5f;
        } else {
            this.ejn = f3;
        }
        if (f2 > 0.5f) {
            this.ejm = 0.5f;
        } else {
            this.ejm = f2;
        }
        if (this.mListView.getHeight() != 0) {
            bbv();
        }
    }

    private void aR(int i2, int i3) {
        this.eiS.x = i2 - this.ejd;
        this.eiS.y = i3 - this.eje;
        ie(true);
        int min = Math.min(i3, this.eiU + this.ejj);
        int max = Math.max(i3, this.eiU - this.ejj);
        int bbA = this.ejl.bbA();
        if (min > this.mLastY && min > this.ejp && bbA != 1) {
            if (bbA != -1) {
                this.ejl.m31if(true);
            }
            this.ejl.nm(1);
        } else if (max < this.mLastY && max < this.ejo && bbA != 0) {
            if (bbA != -1) {
                this.ejl.m31if(true);
            }
            this.ejl.nm(0);
        } else if (max >= this.ejo && min <= this.ejp && this.ejl.isScrolling()) {
            this.ejl.m31if(true);
        }
    }

    private void bbv() {
        int height;
        int paddingTop = this.mListView.getPaddingTop();
        float height2 = (this.mListView.getHeight() - paddingTop) - this.mListView.getPaddingBottom();
        this.ejr = paddingTop + (this.ejm * height2);
        this.ejq = (height2 * (1.0f - this.ejn)) + paddingTop;
        this.ejo = (int) this.ejr;
        this.ejp = (int) this.ejq;
        this.ejs = this.ejr - paddingTop;
        this.ejt = (paddingTop + height) - this.ejq;
    }

    private void bbw() {
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
        if (i2 != this.ejc && i2 != this.eiZ && i2 != this.eja) {
            g2 = -2;
        } else {
            g2 = g(i2, view, z);
        }
        if (g2 != layoutParams.height) {
            layoutParams.height = g2;
            view.setLayoutParams(layoutParams);
        }
        if (i2 == this.eiZ || i2 == this.eja) {
            if (i2 < this.ejc) {
                ((DragSortItemView) view).setGravity(80);
            } else if (i2 > this.ejc) {
                ((DragSortItemView) view).setGravity(48);
            }
        }
        int visibility = view.getVisibility();
        int i3 = 0;
        if (i2 == this.ejc && this.eiR != null) {
            i3 = 4;
        }
        if (i3 != visibility) {
            view.setVisibility(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int nl(int i2) {
        View view;
        if (i2 == this.ejc) {
            return 0;
        }
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        if (childAt != null) {
            return f(i2, childAt, false);
        }
        int i3 = this.ejJ.get(i2);
        if (i3 == -1) {
            ListAdapter adapter = this.mListView.getAdapter();
            int itemViewType = adapter.getItemViewType(i2);
            int viewTypeCount = adapter.getViewTypeCount();
            if (viewTypeCount != this.ejk.length) {
                this.ejk = new View[viewTypeCount];
            }
            if (itemViewType >= 0) {
                if (this.ejk[itemViewType] == null) {
                    view = adapter.getView(i2, null, this.mListView);
                    this.ejk[itemViewType] = view;
                } else {
                    view = adapter.getView(i2, this.ejk[itemViewType], this.mListView);
                }
            } else {
                view = adapter.getView(i2, null, this.mListView);
            }
            int f2 = f(i2, view, true);
            this.ejJ.aT(i2, f2);
            return f2;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(int i2, View view, boolean z) {
        if (i2 == this.ejc) {
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
        boolean z = this.ejb && this.eiZ != this.eja;
        int i4 = this.cjS - this.eji;
        int i5 = (int) (this.ejE * i4);
        if (i2 == this.ejc) {
            if (this.ejc == this.eiZ) {
                if (z) {
                    return i5 + this.eji;
                }
                return this.cjS;
            } else if (this.ejc == this.eja) {
                return this.cjS - i5;
            } else {
                return this.eji;
            }
        } else if (i2 == this.eiZ) {
            if (z) {
                return i3 + i5;
            }
            return i3 + i4;
        } else if (i2 == this.eja) {
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
        if (i2 != this.ejc) {
            i6 = height - nl;
            i5 = aS - nl;
        } else {
            i5 = aS;
            i6 = height;
        }
        int i7 = this.cjS;
        if (this.ejc != this.eiZ && this.ejc != this.eja) {
            i7 -= this.eji;
        }
        if (i2 <= i3) {
            if (i2 > this.eiZ) {
                return (i7 - i5) + 0;
            }
        } else if (i2 == i4) {
            if (i2 <= this.eiZ) {
                return (i6 - i7) + 0;
            }
            if (i2 == this.eja) {
                return (height - aS) + 0;
            }
            return 0 + i6;
        } else if (i2 <= this.eiZ) {
            return 0 - i7;
        } else {
            if (i2 == this.eja) {
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

    private void bbx() {
        if (this.eiR != null) {
            measureItem(this.eiR);
            this.cjS = this.eiR.getMeasuredHeight();
            this.ejj = this.cjS / 2;
        }
    }

    protected boolean onDragTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        switch (motionEvent.getAction() & 255) {
            case 1:
                if (this.mDragState == 4) {
                    stopDrag(false);
                }
                bbu();
                return true;
            case 2:
                aR((int) motionEvent.getX(), (int) motionEvent.getY());
                return true;
            case 3:
                if (this.mDragState == 4) {
                    cancelDrag();
                }
                bbu();
                return true;
            default:
                return true;
        }
    }

    public boolean startDrag(int i2, int i3, int i4, int i5) {
        View nn;
        if (!this.ejz || this.ejA == null || (nn = this.ejA.nn(i2)) == null) {
            return false;
        }
        return startDrag(i2, nn, i3, i4, i5);
    }

    public boolean startDrag(int i2, View view, int i3, int i4, int i5) {
        if (this.mDragState == 0 && this.ejz && this.eiR == null && view != null && this.cyD) {
            if (this.mListView.getParent() != null) {
                this.mListView.getParent().requestDisallowInterceptTouchEvent(true);
            }
            int headerViewsCount = this.mListView.getHeaderViewsCount() + i2;
            this.eiZ = headerViewsCount;
            this.eja = headerViewsCount;
            this.ejc = headerViewsCount;
            this.eiY = headerViewsCount;
            this.mDragState = 4;
            this.ejx = 0;
            this.ejx |= i3;
            this.eiR = view;
            bbx();
            this.ejd = i4;
            this.eje = i5;
            this.ejw = this.mY;
            this.eiS.x = this.mX - this.ejd;
            this.eiS.y = this.mY - this.eje;
            View childAt = this.mListView.getChildAt(this.ejc - this.mListView.getFirstVisiblePosition());
            if (childAt != null) {
                childAt.setVisibility(4);
            }
            if (this.ejG) {
                this.ejH.bbB();
            }
            switch (this.ejC) {
                case 1:
                    this.ejP.onTouchEvent(this.ejB);
                    break;
                case 2:
                    this.ejP.onInterceptTouchEvent(this.ejB);
                    break;
            }
            this.mListView.requestLayout();
            if (this.ejL != null) {
                this.ejL.start();
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
        bby();
        int i3 = this.eiZ;
        int i4 = this.eja;
        boolean bbp = bbp();
        if (bbp) {
            bbw();
            this.mListView.setSelectionFromTop(i2, (b(i2, view, i3, i4) + view.getTop()) - this.mListView.getPaddingTop());
            layoutChildren();
        }
        if (bbp || z) {
            this.mListView.invalidate();
        }
        this.mBlockLayoutRequests = false;
    }

    private void bby() {
        if (this.ejA != null) {
            this.eiT.set(this.mX, this.mY);
            this.ejA.b(this.eiR, this.eiS, this.eiT);
        }
        int i2 = this.eiS.x;
        int i3 = this.eiS.y;
        int paddingLeft = this.mListView.getPaddingLeft();
        if ((this.ejx & 1) == 0 && i2 > paddingLeft) {
            this.eiS.x = paddingLeft;
        } else if ((this.ejx & 2) == 0 && i2 < paddingLeft) {
            this.eiS.x = paddingLeft;
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int lastVisiblePosition = this.mListView.getLastVisiblePosition();
        int paddingTop = this.mListView.getPaddingTop();
        if (firstVisiblePosition < headerViewsCount) {
            paddingTop = this.mListView.getChildAt((headerViewsCount - firstVisiblePosition) - 1).getBottom();
        }
        if ((this.ejx & 8) == 0 && firstVisiblePosition <= this.ejc) {
            paddingTop = Math.max(this.mListView.getChildAt(this.ejc - firstVisiblePosition).getTop(), paddingTop);
        }
        int height = this.mListView.getHeight() - this.mListView.getPaddingBottom();
        if (lastVisiblePosition >= (this.mListView.getCount() - footerViewsCount) - 1) {
            height = this.mListView.getChildAt(((this.mListView.getCount() - footerViewsCount) - 1) - firstVisiblePosition).getBottom();
        }
        if ((this.ejx & 4) == 0 && lastVisiblePosition >= this.ejc) {
            height = Math.min(this.mListView.getChildAt(this.ejc - firstVisiblePosition).getBottom(), height);
        }
        if (i3 < paddingTop) {
            this.eiS.y = paddingTop;
        } else if (this.cjS + i3 > height) {
            this.eiS.y = height - this.cjS;
        }
        this.eiU = this.eiS.y + this.ejj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbz() {
        if (this.eiR != null) {
            this.eiR.setVisibility(8);
            if (this.ejA != null) {
                this.ejA.bk(this.eiR);
            }
            this.eiR = null;
            this.mListView.invalidate();
        }
    }

    public void a(h hVar) {
        this.ejA = hVar;
    }

    public void a(b bVar) {
        this.ejf = bVar;
    }

    public void setDragEnabled(boolean z) {
        this.cyD = z;
    }

    public boolean isDragEnabled() {
        return this.cyD;
    }

    public void a(g gVar) {
        this.ejg = gVar;
    }

    public void a(l lVar) {
        this.ejh = lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class i {
        private SparseIntArray ekk;
        private ArrayList<Integer> ekl;
        private int mMaxSize;

        public i(int i) {
            this.ekk = new SparseIntArray(i);
            this.ekl = new ArrayList<>(i);
            this.mMaxSize = i;
        }

        public void aT(int i, int i2) {
            int i3 = this.ekk.get(i, -1);
            if (i3 != i2) {
                if (i3 == -1) {
                    if (this.ekk.size() == this.mMaxSize) {
                        this.ekk.delete(this.ekl.remove(0).intValue());
                    }
                } else {
                    this.ekl.remove(Integer.valueOf(i));
                }
                this.ekk.put(i, i2);
                this.ekl.add(Integer.valueOf(i));
            }
        }

        public int get(int i) {
            return this.ekk.get(i, -1);
        }

        public void clear() {
            this.ekk.clear();
            this.ekl.clear();
        }
    }

    /* renamed from: com.baidu.tbadk.widget.dragsort.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0429a extends BaseAdapter {
        private ListAdapter mAdapter;

        public C0429a(ListAdapter listAdapter) {
            this.mAdapter = listAdapter;
            this.mAdapter.registerDataSetObserver(new DataSetObserver() { // from class: com.baidu.tbadk.widget.dragsort.a.a.1
                @Override // android.database.DataSetObserver
                public void onChanged() {
                    C0429a.this.notifyDataSetChanged();
                }

                @Override // android.database.DataSetObserver
                public void onInvalidated() {
                    C0429a.this.notifyDataSetInvalidated();
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
        private float bFF;
        private float bFG;
        private float bFH;
        private float bFI;
        private float ekv;
        private float mAlpha;
        private boolean mCanceled;
        protected long mStartTime;

        public m(float f, int i) {
            this.mAlpha = f;
            this.ekv = i;
            float f2 = 1.0f / ((this.mAlpha * 2.0f) * (1.0f - this.mAlpha));
            this.bFI = f2;
            this.bFF = f2;
            this.bFG = this.mAlpha / ((this.mAlpha - 1.0f) * 2.0f);
            this.bFH = 1.0f / (1.0f - this.mAlpha);
        }

        public float ab(float f) {
            if (f < this.mAlpha) {
                return this.bFF * f * f;
            }
            if (f < 1.0f - this.mAlpha) {
                return this.bFG + (this.bFH * f);
            }
            return 1.0f - ((this.bFI * (f - 1.0f)) * (f - 1.0f));
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
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / this.ekv;
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
        private int ekg;
        private int ekh;
        private float eki;
        private float ekj;

        public f(float f, int i) {
            super(f, i);
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.ekg = a.this.eiY;
            this.ekh = a.this.ejc;
            a.this.mDragState = 2;
            this.eki = a.this.eiS.y - bbD();
            this.ekj = a.this.eiS.x - a.this.mListView.getPaddingLeft();
        }

        private int bbD() {
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            int dividerHeight = (a.this.eji + a.this.mListView.getDividerHeight()) / 2;
            View childAt = a.this.mListView.getChildAt(this.ekg - firstVisiblePosition);
            if (childAt != null) {
                if (this.ekg == this.ekh) {
                    return childAt.getTop();
                }
                if (this.ekg >= this.ekh) {
                    return (childAt.getBottom() + dividerHeight) - a.this.cjS;
                }
                return childAt.getTop() - dividerHeight;
            }
            cancel();
            return -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void s(float f, float f2) {
            int bbD = bbD();
            float paddingLeft = a.this.eiS.x - a.this.mListView.getPaddingLeft();
            float f3 = 1.0f - f2;
            if (f3 < Math.abs((a.this.eiS.y - bbD) / this.eki) || f3 < Math.abs(paddingLeft / this.ekj)) {
                a.this.eiS.y = bbD + ((int) (this.eki * f3));
                a.this.eiS.x = a.this.mListView.getPaddingLeft() + ((int) (this.ekj * f3));
                a.this.ie(true);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.bbr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class k extends m {
        private int ekh;
        private float eko;
        private float ekp;
        private float ekq;
        private int ekr;
        private int eks;
        private int ekt;
        private int eku;

        public k(float f, int i) {
            super(f, i);
            this.ekr = -1;
            this.eks = -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.ekr = -1;
            this.eks = -1;
            this.ekt = a.this.eiZ;
            this.eku = a.this.eja;
            this.ekh = a.this.ejc;
            a.this.mDragState = 1;
            this.eko = a.this.eiS.x;
            if (a.this.ejN) {
                float width = a.this.mListView.getWidth() * 2.0f;
                if (a.this.ejO == 0.0f) {
                    a.this.ejO = (this.eko >= 0.0f ? 1 : -1) * width;
                    return;
                }
                float f = width * 2.0f;
                if (a.this.ejO >= 0.0f || a.this.ejO <= (-f)) {
                    if (a.this.ejO > 0.0f && a.this.ejO < f) {
                        a.this.ejO = f;
                        return;
                    }
                    return;
                }
                a.this.ejO = -f;
                return;
            }
            a.this.bbz();
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void s(float f, float f2) {
            View childAt;
            float f3 = 1.0f - f2;
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            View childAt2 = a.this.mListView.getChildAt(this.ekt - firstVisiblePosition);
            if (a.this.ejN) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / 1000.0f;
                if (uptimeMillis != 0.0f) {
                    float f4 = a.this.ejO * uptimeMillis;
                    int width = a.this.mListView.getWidth();
                    a.this.ejO = ((a.this.ejO > 0.0f ? 1 : -1) * uptimeMillis * width) + a.this.ejO;
                    this.eko += f4;
                    a.this.eiS.x = (int) this.eko;
                    if (this.eko < width && this.eko > (-width)) {
                        this.mStartTime = SystemClock.uptimeMillis();
                        a.this.ie(true);
                        return;
                    }
                } else {
                    return;
                }
            }
            if (childAt2 != null) {
                if (this.ekr == -1) {
                    this.ekr = a.this.f(this.ekt, childAt2, false);
                    this.ekp = childAt2.getHeight() - this.ekr;
                }
                int max = Math.max((int) (this.ekp * f3), 1);
                ViewGroup.LayoutParams layoutParams = childAt2.getLayoutParams();
                layoutParams.height = max + this.ekr;
                childAt2.setLayoutParams(layoutParams);
            }
            if (this.eku != this.ekt && (childAt = a.this.mListView.getChildAt(this.eku - firstVisiblePosition)) != null) {
                if (this.eks == -1) {
                    this.eks = a.this.f(this.eku, childAt, false);
                    this.ekq = childAt.getHeight() - this.eks;
                }
                int max2 = Math.max((int) (this.ekq * f3), 1);
                ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
                layoutParams2.height = max2 + this.eks;
                childAt.setLayoutParams(layoutParams2);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.bbs();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class j extends m {
        final /* synthetic */ a ejT;
        private float ekm;
        private float ekn;

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.ekm = this.ejT.eje;
            this.ekn = this.ejT.ejj;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void s(float f, float f2) {
            if (this.ejT.mDragState != 4) {
                cancel();
                return;
            }
            this.ejT.eje = (int) ((this.ekn * f2) + ((1.0f - f2) * this.ekm));
            this.ejT.eiS.y = this.ejT.mY - this.ejT.eje;
            this.ejT.ie(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e {
        StringBuilder mBuilder = new StringBuilder();
        private int ekd = 0;
        private int eke = 0;
        private boolean ekf = false;
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

        public void bbB() {
            this.mBuilder.append("<DSLVStates>\n");
            this.eke = 0;
            this.ekf = true;
        }

        public void bbC() {
            if (this.ekf) {
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
                this.mBuilder.append("    <FirstExpPos>").append(a.this.eiZ).append("</FirstExpPos>\n");
                this.mBuilder.append("    <FirstExpBlankHeight>").append(a.this.nj(a.this.eiZ) - a.this.nl(a.this.eiZ)).append("</FirstExpBlankHeight>\n");
                this.mBuilder.append("    <SecondExpPos>").append(a.this.eja).append("</SecondExpPos>\n");
                this.mBuilder.append("    <SecondExpBlankHeight>").append(a.this.nj(a.this.eja) - a.this.nl(a.this.eja)).append("</SecondExpBlankHeight>\n");
                this.mBuilder.append("    <SrcPos>").append(a.this.ejc).append("</SrcPos>\n");
                this.mBuilder.append("    <SrcHeight>").append(a.this.cjS + a.this.mListView.getDividerHeight()).append("</SrcHeight>\n");
                this.mBuilder.append("    <ViewHeight>").append(a.this.mListView.getHeight()).append("</ViewHeight>\n");
                this.mBuilder.append("    <LastY>").append(a.this.mLastY).append("</LastY>\n");
                this.mBuilder.append("    <FloatY>").append(a.this.eiU).append("</FloatY>\n");
                this.mBuilder.append("    <ShuffleEdges>");
                for (int i4 = 0; i4 < childCount; i4++) {
                    this.mBuilder.append(a.this.aQ(firstVisiblePosition + i4, a.this.mListView.getChildAt(i4).getTop())).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                this.mBuilder.append("</ShuffleEdges>\n");
                this.mBuilder.append("</DSLVState>\n");
                this.ekd++;
                if (this.ekd > 1000) {
                    flush();
                    this.ekd = 0;
                }
            }
        }

        public void flush() {
            if (this.ekf) {
                try {
                    FileWriter fileWriter = new FileWriter(this.mFile, this.eke != 0);
                    fileWriter.write(this.mBuilder.toString());
                    this.mBuilder.delete(0, this.mBuilder.length());
                    fileWriter.flush();
                    fileWriter.close();
                    this.eke++;
                } catch (IOException e) {
                }
            }
        }

        public void stopTracking() {
            if (this.ekf) {
                this.mBuilder.append("</DSLVStates>\n");
                flush();
                this.ekf = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements Runnable {
        private int dy;
        private boolean ejW;
        private long ejX;
        private long ejY;
        private float ejZ;
        private long eka;
        private int ekb;
        private float ekc;
        private boolean mScrolling = false;

        public boolean isScrolling() {
            return this.mScrolling;
        }

        public int bbA() {
            if (this.mScrolling) {
                return this.ekb;
            }
            return -1;
        }

        public d() {
        }

        public void nm(int i) {
            if (!this.mScrolling) {
                this.ejW = false;
                this.mScrolling = true;
                this.eka = SystemClock.uptimeMillis();
                this.ejX = this.eka;
                this.ekb = i;
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
            this.ejW = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.ejW) {
                int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
                int lastVisiblePosition = a.this.mListView.getLastVisiblePosition();
                int count = a.this.mListView.getCount();
                int paddingTop = a.this.mListView.getPaddingTop();
                int height = (a.this.mListView.getHeight() - paddingTop) - a.this.mListView.getPaddingBottom();
                int min = Math.min(a.this.mY, a.this.eiU + a.this.ejj);
                int max = Math.max(a.this.mY, a.this.eiU - a.this.ejj);
                if (this.ekb == 0) {
                    View childAt = a.this.mListView.getChildAt(0);
                    if (childAt == null) {
                        this.mScrolling = false;
                        return;
                    } else if (firstVisiblePosition == 0 && childAt.getTop() == paddingTop) {
                        this.mScrolling = false;
                        return;
                    } else {
                        this.ekc = a.this.ejv.b((a.this.ejr - max) / a.this.ejs, this.ejX);
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
                        this.ekc = -a.this.ejv.b((min - a.this.ejq) / a.this.ejt, this.ejX);
                    }
                }
                this.ejY = SystemClock.uptimeMillis();
                this.ejZ = (float) (this.ejY - this.ejX);
                this.dy = Math.round(this.ekc * this.ejZ);
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
                this.ejX = this.ejY;
                a.this.mListView.post(this);
                return;
            }
            this.mScrolling = false;
        }
    }
}
