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
    private int bGQ;
    private int dEA;
    private int dEC;
    private int dED;
    private int dEE;
    private b dEF;
    private g dEG;
    private l dEH;
    private int dEJ;
    private d dEL;
    private int dEO;
    private int dEP;
    private float dEQ;
    private float dER;
    private float dES;
    private float dET;
    private int dEW;
    private View dEr;
    private int dEu;
    private int dEy;
    private int dEz;
    private MotionEvent dFb;
    private C0386a dFf;
    private e dFh;
    private k dFk;
    private j dFl;
    private f dFm;
    private boolean dFn;
    private com.baidu.tbadk.widget.dragsort.d dFp;
    private com.baidu.tbadk.widget.dragsort.b dFq;
    private int mLastX;
    private int mLastY;
    private ListView mListView;
    private DataSetObserver mObserver;
    private int mOffsetX;
    private int mOffsetY;
    private int mX;
    private int mY;
    private Point dEs = new Point();
    private Point dEt = new Point();
    private boolean dEv = false;
    private float dEw = 1.0f;
    private float dEx = 1.0f;
    private boolean dEB = false;
    private boolean mDragEnabled = true;
    private int mDragState = 0;
    private int dEI = 1;
    private int mWidthMeasureSpec = 0;
    private View[] dEK = new View[1];
    private float dEM = 0.33333334f;
    private float dEN = 0.33333334f;
    private float dEU = 0.5f;
    private c dEV = new c() { // from class: com.baidu.tbadk.widget.dragsort.a.1
        @Override // com.baidu.tbadk.widget.dragsort.a.c
        public float b(float f2, long j2) {
            return a.this.dEU * f2;
        }
    };
    private int dEX = 0;
    private boolean dEY = false;
    private boolean dEZ = false;
    private h dFa = null;
    private int dFc = 0;
    private float dFd = 0.25f;
    private float dFe = 0.0f;
    private boolean dFg = false;
    private boolean mBlockLayoutRequests = false;
    private boolean dFi = false;
    private i dFj = new i(3);
    private float dFo = 0.0f;
    private boolean dFr = false;
    private boolean dFs = false;

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

        void bj(View view);

        View mI(int i);
    }

    /* loaded from: classes.dex */
    public interface l {
        void remove(int i);
    }

    public a(ListView listView, com.baidu.tbadk.widget.dragsort.d dVar) {
        this.dFp = dVar;
        this.mListView = listView;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            this.dFf = new C0386a(listAdapter);
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
            this.dFf = null;
        }
        this.dFp.setAdapter(this.dFf);
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
            if (i2 > this.dEC) {
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
    public int mE(int i2) {
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        return childAt != null ? childAt.getHeight() : aN(i2, mG(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aL(int i2, int i3) {
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        if (i2 <= headerViewsCount || i2 >= this.mListView.getCount() - footerViewsCount) {
            return i3;
        }
        int dividerHeight = this.mListView.getDividerHeight();
        int i4 = this.bGQ - this.dEI;
        int mG = mG(i2);
        int mE = mE(i2);
        if (this.dEA <= this.dEC) {
            if (i2 == this.dEA && this.dEz != this.dEA) {
                if (i2 == this.dEC) {
                    i3 = (i3 + mE) - this.bGQ;
                } else {
                    i3 = ((mE - mG) + i3) - i4;
                }
            } else if (i2 > this.dEA && i2 <= this.dEC) {
                i3 -= i4;
            }
        } else if (i2 > this.dEC && i2 <= this.dEz) {
            i3 += i4;
        } else if (i2 == this.dEA && this.dEz != this.dEA) {
            i3 += mE - mG;
        }
        if (i2 <= this.dEC) {
            return (((this.bGQ - dividerHeight) - mG(i2 - 1)) / 2) + i3;
        }
        return (((mG - dividerHeight) - this.bGQ) / 2) + i3;
    }

    private boolean aQH() {
        int i2;
        int i3;
        int i4;
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int i5 = this.dEz;
        View childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        if (childAt == null) {
            i5 = firstVisiblePosition + (this.mListView.getChildCount() / 2);
            childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        }
        int top = childAt.getTop();
        int height = childAt.getHeight();
        int aL = aL(i5, top);
        int dividerHeight = this.mListView.getDividerHeight();
        if (this.dEu >= aL) {
            int count = this.mListView.getCount();
            int i6 = height;
            int i7 = top;
            i2 = aL;
            i3 = i5;
            i4 = aL;
            while (true) {
                if (i3 < count) {
                    if (i3 == count - 1) {
                        i2 = i7 + dividerHeight + i6;
                        break;
                    }
                    i7 += dividerHeight + i6;
                    i6 = mE(i3 + 1);
                    i2 = aL(i3 + 1, i7);
                    if (this.dEu < i2) {
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
            i2 = aL;
            i3 = i5;
            i4 = aL;
            while (true) {
                if (i3 < 0) {
                    break;
                }
                i3--;
                int mE = mE(i3);
                if (i3 == 0) {
                    i2 = (i8 - dividerHeight) - mE;
                    break;
                }
                i8 -= mE + dividerHeight;
                i2 = aL(i3, i8);
                if (this.dEu >= i2) {
                    break;
                }
                i4 = i2;
            }
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int i9 = this.dEz;
        int i10 = this.dEA;
        float f2 = this.dFe;
        if (this.dEB) {
            int abs = Math.abs(i2 - i4);
            if (this.dEu >= i2) {
                int i11 = i4;
                i4 = i2;
                i2 = i11;
            }
            int i12 = (int) (abs * this.dFd * 0.5f);
            float f3 = i12;
            int i13 = i4 + i12;
            int i14 = i2 - i12;
            if (this.dEu < i13) {
                this.dEz = i3 - 1;
                this.dEA = i3;
                this.dFe = ((i13 - this.dEu) * 0.5f) / f3;
            } else if (this.dEu < i14) {
                this.dEz = i3;
                this.dEA = i3;
            } else {
                this.dEz = i3;
                this.dEA = i3 + 1;
                this.dFe = (1.0f + ((i2 - this.dEu) / f3)) * 0.5f;
            }
        } else {
            this.dEz = i3;
            this.dEA = i3;
        }
        if (this.dEz < headerViewsCount) {
            this.dEz = headerViewsCount;
            this.dEA = headerViewsCount;
            i3 = headerViewsCount;
        } else if (this.dEA >= this.mListView.getCount() - footerViewsCount) {
            i3 = (this.mListView.getCount() - footerViewsCount) - 1;
            this.dEz = i3;
            this.dEA = i3;
        }
        boolean z = (this.dEz == i9 && this.dEA == i10 && this.dFe == f2) ? false : true;
        if (i3 != this.dEy) {
            if (this.dEF != null) {
                this.dEF.drag(this.dEy - headerViewsCount, i3 - headerViewsCount);
            }
            this.dEy = i3;
            return true;
        }
        return z;
    }

    public void removeItem(int i2) {
        this.dFn = false;
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
            this.dEI = Math.max(1, obtainStyledAttributes.getDimensionPixelSize(12, 1));
            this.dFg = obtainStyledAttributes.getBoolean(6, false);
            if (this.dFg) {
                this.dFh = new e();
            }
            this.dEw = obtainStyledAttributes.getFloat(10, this.dEw);
            this.dEx = this.dEw;
            this.mDragEnabled = obtainStyledAttributes.getBoolean(13, this.mDragEnabled);
            this.dFd = Math.max(0.0f, Math.min(1.0f, 1.0f - obtainStyledAttributes.getFloat(2, 0.75f)));
            this.dEB = this.dFd > 0.0f;
            setDragScrollStart(obtainStyledAttributes.getFloat(14, this.dEM));
            this.dEU = obtainStyledAttributes.getFloat(0, this.dEU);
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
                bVar.hb(z);
                bVar.ha(z2);
                bVar.setBackgroundColor(color);
                this.dFa = bVar;
                a(bVar);
            }
            obtainStyledAttributes.recycle();
            i2 = i5;
            i3 = i4;
        }
        this.dEL = new d();
        if (i3 > 0) {
            this.dFk = new k(0.5f, i3);
        }
        if (i2 > 0) {
            this.dFm = new f(0.5f, i2);
        }
        this.dFb = MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
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
        this.dFq = bVar;
        this.mListView.setOnTouchListener(bVar);
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void dispatchDraw(Canvas canvas) {
        float f2;
        this.dFp.dispatchDraw(canvas);
        if (this.mDragState != 0) {
            if (this.dEz != this.dEC) {
                b(this.dEz, canvas);
            }
            if (this.dEA != this.dEz && this.dEA != this.dEC) {
                b(this.dEA, canvas);
            }
        }
        if (this.dEr != null) {
            int width = this.dEr.getWidth();
            int height = this.dEr.getHeight();
            int i2 = this.dEs.x;
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
            int i3 = (int) (f2 * 255.0f * this.dEx);
            canvas.save();
            canvas.translate(this.dEs.x, this.dEs.y);
            canvas.clipRect(0, 0, width, height);
            canvas.saveLayerAlpha(0.0f, 0.0f, width, height, i3, 31);
            this.dEr.draw(canvas);
            canvas.restore();
            canvas.restore();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onDraw(Canvas canvas) {
        this.dFp.onDraw(canvas);
        if (this.dFg) {
            this.dFh.aQU();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.dFi) {
            this.dFi = false;
            return false;
        } else if (!this.mDragEnabled) {
            return this.dFp.onTouchEvent(motionEvent);
        } else {
            boolean z2 = this.dEY;
            this.dEY = false;
            if (!z2) {
                s(motionEvent);
            }
            if (this.mDragState == 4) {
                onDragTouchEvent(motionEvent);
                return true;
            }
            if (this.mDragState == 0 && this.dFp.onTouchEvent(motionEvent)) {
                z = true;
            }
            switch (motionEvent.getAction() & 255) {
                case 1:
                case 3:
                    aQM();
                    return z;
                case 2:
                default:
                    if (z) {
                        this.dFc = 1;
                        return z;
                    }
                    return z;
            }
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (!this.mDragEnabled) {
            return this.dFp.onInterceptTouchEvent(motionEvent);
        }
        if (this.dFq != null) {
            this.dFq.aQW().onTouchEvent(motionEvent);
        }
        s(motionEvent);
        this.dEY = true;
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            if (this.mDragState != 0) {
                this.dFi = true;
                return true;
            }
            this.dEZ = true;
        }
        if (this.dEr == null) {
            if (this.dFp.onInterceptTouchEvent(motionEvent)) {
                this.dFr = true;
                z = true;
            } else {
                z = false;
            }
            switch (action) {
                case 1:
                case 3:
                    aQM();
                    break;
                case 2:
                default:
                    if (z) {
                        this.dFc = 1;
                        break;
                    } else {
                        this.dFc = 2;
                        break;
                    }
            }
        } else {
            z = true;
        }
        if (action == 1 || action == 3) {
            this.dEZ = false;
        }
        return z;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        this.dFp.onSizeChanged(i2, i3, i4, i5);
        aQN();
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void requestLayout() {
        if (!this.mBlockLayoutRequests) {
            this.dFp.requestLayout();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onMeasure(int i2, int i3) {
        this.dFp.onMeasure(i2, i3);
        if (this.dEr != null) {
            if (this.dEr.isLayoutRequested()) {
                aQP();
            }
            this.dEv = true;
        }
        this.mWidthMeasureSpec = i2;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void layoutChildren() {
        this.dFp.layoutChildren();
        if (this.dEr != null) {
            if (this.dEr.isLayoutRequested() && !this.dEv) {
                aQP();
            }
            this.dEr.layout(0, 0, this.dEr.getMeasuredWidth(), this.dEr.getMeasuredHeight());
            this.dEv = false;
        }
    }

    public void removeItem(int i2, float f2) {
        if (this.mDragState == 0 || this.mDragState == 4) {
            if (this.mDragState == 0) {
                this.dEC = this.mListView.getHeaderViewsCount() + i2;
                this.dEz = this.dEC;
                this.dEA = this.dEC;
                this.dEy = this.dEC;
                View childAt = this.mListView.getChildAt(this.dEC - this.mListView.getFirstVisiblePosition());
                if (childAt != null) {
                    childAt.setVisibility(4);
                }
            }
            this.mDragState = 1;
            this.dFo = f2;
            if (this.dEZ) {
                switch (this.dFc) {
                    case 1:
                        this.dFp.onTouchEvent(this.dFb);
                        break;
                    case 2:
                        this.dFp.onInterceptTouchEvent(this.dFb);
                        break;
                }
            }
            if (this.dFk != null) {
                this.dFk.start();
            } else {
                mF(i2);
            }
        }
    }

    public void cancelDrag() {
        if (this.mDragState == 4) {
            this.dEL.gZ(true);
            aQR();
            aQI();
            aQO();
            if (this.dEZ) {
                this.mDragState = 3;
            } else {
                this.mDragState = 0;
            }
        }
    }

    private void aQI() {
        this.dEC = -1;
        this.dEz = -1;
        this.dEA = -1;
        this.dEy = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQJ() {
        this.mDragState = 2;
        if (this.dEG != null && this.dEy >= 0 && this.dEy < this.mListView.getCount()) {
            int headerViewsCount = this.mListView.getHeaderViewsCount();
            this.dEG.drop(this.dEC - headerViewsCount, this.dEy - headerViewsCount);
        }
        aQR();
        aQL();
        aQI();
        aQO();
        if (this.dEZ) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQK() {
        mF(this.dEC - this.mListView.getHeaderViewsCount());
    }

    private void mF(int i2) {
        this.mDragState = 1;
        if (this.dEH != null) {
            this.dEH.remove(i2);
        }
        aQR();
        aQL();
        aQI();
        if (this.dEZ) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    private void aQL() {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        if (this.dEC < firstVisiblePosition) {
            View childAt = this.mListView.getChildAt(0);
            this.mListView.setSelectionFromTop(firstVisiblePosition - 1, (childAt != null ? childAt.getTop() : 0) - this.mListView.getPaddingTop());
        }
    }

    public boolean stopDrag(boolean z) {
        this.dFn = false;
        return stopDrag(z, 0.0f);
    }

    public boolean stopDragWithVelocity(boolean z, float f2) {
        this.dFn = true;
        return stopDrag(z, f2);
    }

    public boolean stopDrag(boolean z, float f2) {
        if (this.dEr != null) {
            this.dEL.gZ(true);
            if (z) {
                removeItem(this.dEC - this.mListView.getHeaderViewsCount(), f2);
            } else if (this.dFm != null) {
                this.dFm.start();
            } else {
                aQJ();
            }
            if (this.dFg) {
                this.dFh.stopTracking();
                return true;
            }
            return true;
        }
        return false;
    }

    private void aQM() {
        this.dFc = 0;
        this.dEZ = false;
        if (this.mDragState == 3) {
            this.mDragState = 0;
        }
        this.dEx = this.dEw;
        this.dFr = false;
        this.dFj.clear();
    }

    private void s(MotionEvent motionEvent) {
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
        return this.dFr;
    }

    public void setDragScrollStart(float f2) {
        setDragScrollStarts(f2, f2);
    }

    public void setDragScrollStarts(float f2, float f3) {
        if (f3 > 0.5f) {
            this.dEN = 0.5f;
        } else {
            this.dEN = f3;
        }
        if (f2 > 0.5f) {
            this.dEM = 0.5f;
        } else {
            this.dEM = f2;
        }
        if (this.mListView.getHeight() != 0) {
            aQN();
        }
    }

    private void aM(int i2, int i3) {
        this.dEs.x = i2 - this.dED;
        this.dEs.y = i3 - this.dEE;
        gY(true);
        int min = Math.min(i3, this.dEu + this.dEJ);
        int max = Math.max(i3, this.dEu - this.dEJ);
        int aQS = this.dEL.aQS();
        if (min > this.mLastY && min > this.dEP && aQS != 1) {
            if (aQS != -1) {
                this.dEL.gZ(true);
            }
            this.dEL.mH(1);
        } else if (max < this.mLastY && max < this.dEO && aQS != 0) {
            if (aQS != -1) {
                this.dEL.gZ(true);
            }
            this.dEL.mH(0);
        } else if (max >= this.dEO && min <= this.dEP && this.dEL.isScrolling()) {
            this.dEL.gZ(true);
        }
    }

    private void aQN() {
        int height;
        int paddingTop = this.mListView.getPaddingTop();
        float height2 = (this.mListView.getHeight() - paddingTop) - this.mListView.getPaddingBottom();
        this.dER = paddingTop + (this.dEM * height2);
        this.dEQ = (height2 * (1.0f - this.dEN)) + paddingTop;
        this.dEO = (int) this.dER;
        this.dEP = (int) this.dEQ;
        this.dES = this.dER - paddingTop;
        this.dET = (paddingTop + height) - this.dEQ;
    }

    private void aQO() {
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
        if (i2 != this.dEC && i2 != this.dEz && i2 != this.dEA) {
            g2 = -2;
        } else {
            g2 = g(i2, view, z);
        }
        if (g2 != layoutParams.height) {
            layoutParams.height = g2;
            view.setLayoutParams(layoutParams);
        }
        if (i2 == this.dEz || i2 == this.dEA) {
            if (i2 < this.dEC) {
                ((DragSortItemView) view).setGravity(80);
            } else if (i2 > this.dEC) {
                ((DragSortItemView) view).setGravity(48);
            }
        }
        int visibility = view.getVisibility();
        int i3 = 0;
        if (i2 == this.dEC && this.dEr != null) {
            i3 = 4;
        }
        if (i3 != visibility) {
            view.setVisibility(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int mG(int i2) {
        View view;
        if (i2 == this.dEC) {
            return 0;
        }
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        if (childAt != null) {
            return f(i2, childAt, false);
        }
        int i3 = this.dFj.get(i2);
        if (i3 == -1) {
            ListAdapter adapter = this.mListView.getAdapter();
            int itemViewType = adapter.getItemViewType(i2);
            int viewTypeCount = adapter.getViewTypeCount();
            if (viewTypeCount != this.dEK.length) {
                this.dEK = new View[viewTypeCount];
            }
            if (itemViewType >= 0) {
                if (this.dEK[itemViewType] == null) {
                    view = adapter.getView(i2, null, this.mListView);
                    this.dEK[itemViewType] = view;
                } else {
                    view = adapter.getView(i2, this.dEK[itemViewType], this.mListView);
                }
            } else {
                view = adapter.getView(i2, null, this.mListView);
            }
            int f2 = f(i2, view, true);
            this.dFj.aO(i2, f2);
            return f2;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(int i2, View view, boolean z) {
        if (i2 == this.dEC) {
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
        return aN(i2, f(i2, view, z));
    }

    private int aN(int i2, int i3) {
        this.mListView.getDividerHeight();
        boolean z = this.dEB && this.dEz != this.dEA;
        int i4 = this.bGQ - this.dEI;
        int i5 = (int) (this.dFe * i4);
        if (i2 == this.dEC) {
            if (this.dEC == this.dEz) {
                if (z) {
                    return i5 + this.dEI;
                }
                return this.bGQ;
            } else if (this.dEC == this.dEA) {
                return this.bGQ - i5;
            } else {
                return this.dEI;
            }
        } else if (i2 == this.dEz) {
            if (z) {
                return i3 + i5;
            }
            return i3 + i4;
        } else if (i2 == this.dEA) {
            return (i3 + i4) - i5;
        } else {
            return i3;
        }
    }

    private int b(int i2, View view, int i3, int i4) {
        int i5;
        int i6;
        int mG = mG(i2);
        int height = view.getHeight();
        int aN = aN(i2, mG);
        if (i2 != this.dEC) {
            i6 = height - mG;
            i5 = aN - mG;
        } else {
            i5 = aN;
            i6 = height;
        }
        int i7 = this.bGQ;
        if (this.dEC != this.dEz && this.dEC != this.dEA) {
            i7 -= this.dEI;
        }
        if (i2 <= i3) {
            if (i2 > this.dEz) {
                return (i7 - i5) + 0;
            }
        } else if (i2 == i4) {
            if (i2 <= this.dEz) {
                return (i6 - i7) + 0;
            }
            if (i2 == this.dEA) {
                return (height - aN) + 0;
            }
            return 0 + i6;
        } else if (i2 <= this.dEz) {
            return 0 - i7;
        } else {
            if (i2 == this.dEA) {
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

    private void aQP() {
        if (this.dEr != null) {
            measureItem(this.dEr);
            this.bGQ = this.dEr.getMeasuredHeight();
            this.dEJ = this.bGQ / 2;
        }
    }

    protected boolean onDragTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        switch (motionEvent.getAction() & 255) {
            case 1:
                if (this.mDragState == 4) {
                    stopDrag(false);
                }
                aQM();
                return true;
            case 2:
                aM((int) motionEvent.getX(), (int) motionEvent.getY());
                return true;
            case 3:
                if (this.mDragState == 4) {
                    cancelDrag();
                }
                aQM();
                return true;
            default:
                return true;
        }
    }

    public boolean startDrag(int i2, int i3, int i4, int i5) {
        View mI;
        if (!this.dEZ || this.dFa == null || (mI = this.dFa.mI(i2)) == null) {
            return false;
        }
        return startDrag(i2, mI, i3, i4, i5);
    }

    public boolean startDrag(int i2, View view, int i3, int i4, int i5) {
        if (this.mDragState == 0 && this.dEZ && this.dEr == null && view != null && this.mDragEnabled) {
            if (this.mListView.getParent() != null) {
                this.mListView.getParent().requestDisallowInterceptTouchEvent(true);
            }
            int headerViewsCount = this.mListView.getHeaderViewsCount() + i2;
            this.dEz = headerViewsCount;
            this.dEA = headerViewsCount;
            this.dEC = headerViewsCount;
            this.dEy = headerViewsCount;
            this.mDragState = 4;
            this.dEX = 0;
            this.dEX |= i3;
            this.dEr = view;
            aQP();
            this.dED = i4;
            this.dEE = i5;
            this.dEW = this.mY;
            this.dEs.x = this.mX - this.dED;
            this.dEs.y = this.mY - this.dEE;
            View childAt = this.mListView.getChildAt(this.dEC - this.mListView.getFirstVisiblePosition());
            if (childAt != null) {
                childAt.setVisibility(4);
            }
            if (this.dFg) {
                this.dFh.aQT();
            }
            switch (this.dFc) {
                case 1:
                    this.dFp.onTouchEvent(this.dFb);
                    break;
                case 2:
                    this.dFp.onInterceptTouchEvent(this.dFb);
                    break;
            }
            this.mListView.requestLayout();
            if (this.dFl != null) {
                this.dFl.start();
                return true;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gY(boolean z) {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition() + (this.mListView.getChildCount() / 2);
        View childAt = this.mListView.getChildAt(this.mListView.getChildCount() / 2);
        if (childAt != null) {
            h(firstVisiblePosition, childAt, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i2, View view, boolean z) {
        this.mBlockLayoutRequests = true;
        aQQ();
        int i3 = this.dEz;
        int i4 = this.dEA;
        boolean aQH = aQH();
        if (aQH) {
            aQO();
            this.mListView.setSelectionFromTop(i2, (b(i2, view, i3, i4) + view.getTop()) - this.mListView.getPaddingTop());
            layoutChildren();
        }
        if (aQH || z) {
            this.mListView.invalidate();
        }
        this.mBlockLayoutRequests = false;
    }

    private void aQQ() {
        if (this.dFa != null) {
            this.dEt.set(this.mX, this.mY);
            this.dFa.b(this.dEr, this.dEs, this.dEt);
        }
        int i2 = this.dEs.x;
        int i3 = this.dEs.y;
        int paddingLeft = this.mListView.getPaddingLeft();
        if ((this.dEX & 1) == 0 && i2 > paddingLeft) {
            this.dEs.x = paddingLeft;
        } else if ((this.dEX & 2) == 0 && i2 < paddingLeft) {
            this.dEs.x = paddingLeft;
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int lastVisiblePosition = this.mListView.getLastVisiblePosition();
        int paddingTop = this.mListView.getPaddingTop();
        if (firstVisiblePosition < headerViewsCount) {
            paddingTop = this.mListView.getChildAt((headerViewsCount - firstVisiblePosition) - 1).getBottom();
        }
        if ((this.dEX & 8) == 0 && firstVisiblePosition <= this.dEC) {
            paddingTop = Math.max(this.mListView.getChildAt(this.dEC - firstVisiblePosition).getTop(), paddingTop);
        }
        int height = this.mListView.getHeight() - this.mListView.getPaddingBottom();
        if (lastVisiblePosition >= (this.mListView.getCount() - footerViewsCount) - 1) {
            height = this.mListView.getChildAt(((this.mListView.getCount() - footerViewsCount) - 1) - firstVisiblePosition).getBottom();
        }
        if ((this.dEX & 4) == 0 && lastVisiblePosition >= this.dEC) {
            height = Math.min(this.mListView.getChildAt(this.dEC - firstVisiblePosition).getBottom(), height);
        }
        if (i3 < paddingTop) {
            this.dEs.y = paddingTop;
        } else if (this.bGQ + i3 > height) {
            this.dEs.y = height - this.bGQ;
        }
        this.dEu = this.dEs.y + this.dEJ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQR() {
        if (this.dEr != null) {
            this.dEr.setVisibility(8);
            if (this.dFa != null) {
                this.dFa.bj(this.dEr);
            }
            this.dEr = null;
            this.mListView.invalidate();
        }
    }

    public void a(h hVar) {
        this.dFa = hVar;
    }

    public void a(b bVar) {
        this.dEF = bVar;
    }

    public void setDragEnabled(boolean z) {
        this.mDragEnabled = z;
    }

    public boolean isDragEnabled() {
        return this.mDragEnabled;
    }

    public void a(g gVar) {
        this.dEG = gVar;
    }

    public void a(l lVar) {
        this.dEH = lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class i {
        private SparseIntArray dFL;
        private ArrayList<Integer> dFM;
        private int mMaxSize;

        public i(int i) {
            this.dFL = new SparseIntArray(i);
            this.dFM = new ArrayList<>(i);
            this.mMaxSize = i;
        }

        public void aO(int i, int i2) {
            int i3 = this.dFL.get(i, -1);
            if (i3 != i2) {
                if (i3 == -1) {
                    if (this.dFL.size() == this.mMaxSize) {
                        this.dFL.delete(this.dFM.remove(0).intValue());
                    }
                } else {
                    this.dFM.remove(Integer.valueOf(i));
                }
                this.dFL.put(i, i2);
                this.dFM.add(Integer.valueOf(i));
            }
        }

        public int get(int i) {
            return this.dFL.get(i, -1);
        }

        public void clear() {
            this.dFL.clear();
            this.dFM.clear();
        }
    }

    /* renamed from: com.baidu.tbadk.widget.dragsort.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0386a extends BaseAdapter {
        private ListAdapter mAdapter;

        public C0386a(ListAdapter listAdapter) {
            this.mAdapter = listAdapter;
            this.mAdapter.registerDataSetObserver(new DataSetObserver() { // from class: com.baidu.tbadk.widget.dragsort.a.a.1
                @Override // android.database.DataSetObserver
                public void onChanged() {
                    C0386a.this.notifyDataSetChanged();
                }

                @Override // android.database.DataSetObserver
                public void onInvalidated() {
                    C0386a.this.notifyDataSetInvalidated();
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
        private float bcQ;
        private float bcR;
        private float bcS;
        private float bcT;
        private float dFW;
        private float mAlpha;
        private boolean mCanceled;
        protected long mStartTime;

        public m(float f, int i) {
            this.mAlpha = f;
            this.dFW = i;
            float f2 = 1.0f / ((this.mAlpha * 2.0f) * (1.0f - this.mAlpha));
            this.bcT = f2;
            this.bcQ = f2;
            this.bcR = this.mAlpha / ((this.mAlpha - 1.0f) * 2.0f);
            this.bcS = 1.0f / (1.0f - this.mAlpha);
        }

        public float as(float f) {
            if (f < this.mAlpha) {
                return this.bcQ * f * f;
            }
            if (f < 1.0f - this.mAlpha) {
                return this.bcR + (this.bcS * f);
            }
            return 1.0f - ((this.bcT * (f - 1.0f)) * (f - 1.0f));
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
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / this.dFW;
                if (uptimeMillis >= 1.0f) {
                    t(1.0f, 1.0f);
                    onStop();
                    return;
                }
                t(uptimeMillis, as(uptimeMillis));
                a.this.mListView.post(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class f extends m {
        private int dFH;
        private int dFI;
        private float dFJ;
        private float dFK;

        public f(float f, int i) {
            super(f, i);
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.dFH = a.this.dEy;
            this.dFI = a.this.dEC;
            a.this.mDragState = 2;
            this.dFJ = a.this.dEs.y - aQV();
            this.dFK = a.this.dEs.x - a.this.mListView.getPaddingLeft();
        }

        private int aQV() {
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            int dividerHeight = (a.this.dEI + a.this.mListView.getDividerHeight()) / 2;
            View childAt = a.this.mListView.getChildAt(this.dFH - firstVisiblePosition);
            if (childAt != null) {
                if (this.dFH == this.dFI) {
                    return childAt.getTop();
                }
                if (this.dFH >= this.dFI) {
                    return (childAt.getBottom() + dividerHeight) - a.this.bGQ;
                }
                return childAt.getTop() - dividerHeight;
            }
            cancel();
            return -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void t(float f, float f2) {
            int aQV = aQV();
            float paddingLeft = a.this.dEs.x - a.this.mListView.getPaddingLeft();
            float f3 = 1.0f - f2;
            if (f3 < Math.abs((a.this.dEs.y - aQV) / this.dFJ) || f3 < Math.abs(paddingLeft / this.dFK)) {
                a.this.dEs.y = aQV + ((int) (this.dFJ * f3));
                a.this.dEs.x = a.this.mListView.getPaddingLeft() + ((int) (this.dFK * f3));
                a.this.gY(true);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.aQJ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class k extends m {
        private int dFI;
        private float dFP;
        private float dFQ;
        private float dFR;
        private int dFS;
        private int dFT;
        private int dFU;
        private int dFV;

        public k(float f, int i) {
            super(f, i);
            this.dFS = -1;
            this.dFT = -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.dFS = -1;
            this.dFT = -1;
            this.dFU = a.this.dEz;
            this.dFV = a.this.dEA;
            this.dFI = a.this.dEC;
            a.this.mDragState = 1;
            this.dFP = a.this.dEs.x;
            if (a.this.dFn) {
                float width = a.this.mListView.getWidth() * 2.0f;
                if (a.this.dFo == 0.0f) {
                    a.this.dFo = (this.dFP >= 0.0f ? 1 : -1) * width;
                    return;
                }
                float f = width * 2.0f;
                if (a.this.dFo >= 0.0f || a.this.dFo <= (-f)) {
                    if (a.this.dFo > 0.0f && a.this.dFo < f) {
                        a.this.dFo = f;
                        return;
                    }
                    return;
                }
                a.this.dFo = -f;
                return;
            }
            a.this.aQR();
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void t(float f, float f2) {
            View childAt;
            float f3 = 1.0f - f2;
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            View childAt2 = a.this.mListView.getChildAt(this.dFU - firstVisiblePosition);
            if (a.this.dFn) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / 1000.0f;
                if (uptimeMillis != 0.0f) {
                    float f4 = a.this.dFo * uptimeMillis;
                    int width = a.this.mListView.getWidth();
                    a.this.dFo = ((a.this.dFo > 0.0f ? 1 : -1) * uptimeMillis * width) + a.this.dFo;
                    this.dFP += f4;
                    a.this.dEs.x = (int) this.dFP;
                    if (this.dFP < width && this.dFP > (-width)) {
                        this.mStartTime = SystemClock.uptimeMillis();
                        a.this.gY(true);
                        return;
                    }
                } else {
                    return;
                }
            }
            if (childAt2 != null) {
                if (this.dFS == -1) {
                    this.dFS = a.this.f(this.dFU, childAt2, false);
                    this.dFQ = childAt2.getHeight() - this.dFS;
                }
                int max = Math.max((int) (this.dFQ * f3), 1);
                ViewGroup.LayoutParams layoutParams = childAt2.getLayoutParams();
                layoutParams.height = max + this.dFS;
                childAt2.setLayoutParams(layoutParams);
            }
            if (this.dFV != this.dFU && (childAt = a.this.mListView.getChildAt(this.dFV - firstVisiblePosition)) != null) {
                if (this.dFT == -1) {
                    this.dFT = a.this.f(this.dFV, childAt, false);
                    this.dFR = childAt.getHeight() - this.dFT;
                }
                int max2 = Math.max((int) (this.dFR * f3), 1);
                ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
                layoutParams2.height = max2 + this.dFT;
                childAt.setLayoutParams(layoutParams2);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.aQK();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class j extends m {
        private float dFN;
        private float dFO;
        final /* synthetic */ a dFt;

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.dFN = this.dFt.dEE;
            this.dFO = this.dFt.dEJ;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void t(float f, float f2) {
            if (this.dFt.mDragState != 4) {
                cancel();
                return;
            }
            this.dFt.dEE = (int) ((this.dFO * f2) + ((1.0f - f2) * this.dFN));
            this.dFt.dEs.y = this.dFt.mY - this.dFt.dEE;
            this.dFt.gY(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e {
        StringBuilder mBuilder = new StringBuilder();
        private int dFE = 0;
        private int dFF = 0;
        private boolean dFG = false;
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

        public void aQT() {
            this.mBuilder.append("<DSLVStates>\n");
            this.dFF = 0;
            this.dFG = true;
        }

        public void aQU() {
            if (this.dFG) {
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
                this.mBuilder.append("    <FirstExpPos>").append(a.this.dEz).append("</FirstExpPos>\n");
                this.mBuilder.append("    <FirstExpBlankHeight>").append(a.this.mE(a.this.dEz) - a.this.mG(a.this.dEz)).append("</FirstExpBlankHeight>\n");
                this.mBuilder.append("    <SecondExpPos>").append(a.this.dEA).append("</SecondExpPos>\n");
                this.mBuilder.append("    <SecondExpBlankHeight>").append(a.this.mE(a.this.dEA) - a.this.mG(a.this.dEA)).append("</SecondExpBlankHeight>\n");
                this.mBuilder.append("    <SrcPos>").append(a.this.dEC).append("</SrcPos>\n");
                this.mBuilder.append("    <SrcHeight>").append(a.this.bGQ + a.this.mListView.getDividerHeight()).append("</SrcHeight>\n");
                this.mBuilder.append("    <ViewHeight>").append(a.this.mListView.getHeight()).append("</ViewHeight>\n");
                this.mBuilder.append("    <LastY>").append(a.this.mLastY).append("</LastY>\n");
                this.mBuilder.append("    <FloatY>").append(a.this.dEu).append("</FloatY>\n");
                this.mBuilder.append("    <ShuffleEdges>");
                for (int i4 = 0; i4 < childCount; i4++) {
                    this.mBuilder.append(a.this.aL(firstVisiblePosition + i4, a.this.mListView.getChildAt(i4).getTop())).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                this.mBuilder.append("</ShuffleEdges>\n");
                this.mBuilder.append("</DSLVState>\n");
                this.dFE++;
                if (this.dFE > 1000) {
                    flush();
                    this.dFE = 0;
                }
            }
        }

        public void flush() {
            if (this.dFG) {
                try {
                    FileWriter fileWriter = new FileWriter(this.mFile, this.dFF != 0);
                    fileWriter.write(this.mBuilder.toString());
                    this.mBuilder.delete(0, this.mBuilder.length());
                    fileWriter.flush();
                    fileWriter.close();
                    this.dFF++;
                } catch (IOException e) {
                }
            }
        }

        public void stopTracking() {
            if (this.dFG) {
                this.mBuilder.append("</DSLVStates>\n");
                flush();
                this.dFG = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements Runnable {
        private float dFA;
        private long dFB;
        private int dFC;
        private float dFD;
        private boolean dFw;
        private long dFx;
        private long dFy;
        private int dFz;
        private boolean mScrolling = false;

        public boolean isScrolling() {
            return this.mScrolling;
        }

        public int aQS() {
            if (this.mScrolling) {
                return this.dFC;
            }
            return -1;
        }

        public d() {
        }

        public void mH(int i) {
            if (!this.mScrolling) {
                this.dFw = false;
                this.mScrolling = true;
                this.dFB = SystemClock.uptimeMillis();
                this.dFx = this.dFB;
                this.dFC = i;
                a.this.mListView.post(this);
            }
        }

        public void gZ(boolean z) {
            if (z) {
                a.this.mListView.removeCallbacks(this);
                this.mScrolling = false;
                return;
            }
            this.dFw = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.dFw) {
                int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
                int lastVisiblePosition = a.this.mListView.getLastVisiblePosition();
                int count = a.this.mListView.getCount();
                int paddingTop = a.this.mListView.getPaddingTop();
                int height = (a.this.mListView.getHeight() - paddingTop) - a.this.mListView.getPaddingBottom();
                int min = Math.min(a.this.mY, a.this.dEu + a.this.dEJ);
                int max = Math.max(a.this.mY, a.this.dEu - a.this.dEJ);
                if (this.dFC == 0) {
                    View childAt = a.this.mListView.getChildAt(0);
                    if (childAt == null) {
                        this.mScrolling = false;
                        return;
                    } else if (firstVisiblePosition == 0 && childAt.getTop() == paddingTop) {
                        this.mScrolling = false;
                        return;
                    } else {
                        this.dFD = a.this.dEV.b((a.this.dER - max) / a.this.dES, this.dFx);
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
                        this.dFD = -a.this.dEV.b((min - a.this.dEQ) / a.this.dET, this.dFx);
                    }
                }
                this.dFy = SystemClock.uptimeMillis();
                this.dFA = (float) (this.dFy - this.dFx);
                this.dFz = Math.round(this.dFD * this.dFA);
                if (this.dFz >= 0) {
                    this.dFz = Math.min(height, this.dFz);
                    lastVisiblePosition = firstVisiblePosition;
                } else {
                    this.dFz = Math.max(-height, this.dFz);
                }
                View childAt3 = a.this.mListView.getChildAt(lastVisiblePosition - firstVisiblePosition);
                int top = childAt3.getTop() + this.dFz;
                if (lastVisiblePosition == 0 && top > paddingTop) {
                    top = paddingTop;
                }
                a.this.mBlockLayoutRequests = true;
                a.this.mListView.setSelectionFromTop(lastVisiblePosition, top - paddingTop);
                a.this.layoutChildren();
                a.this.mListView.invalidate();
                a.this.mBlockLayoutRequests = false;
                a.this.h(lastVisiblePosition, childAt3, false);
                this.dFx = this.dFy;
                a.this.mListView.post(this);
                return;
            }
            this.mScrolling = false;
        }
    }
}
