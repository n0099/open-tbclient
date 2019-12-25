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
    private int bGg;
    private int bcg;
    private int dEA;
    private d dEC;
    private int dEF;
    private int dEG;
    private float dEH;
    private float dEI;
    private float dEJ;
    private float dEK;
    private int dEN;
    private MotionEvent dES;
    private C0384a dEW;
    private e dEY;
    private View dEi;
    private int dEl;
    private int dEp;
    private int dEq;
    private int dEr;
    private int dEt;
    private int dEu;
    private int dEv;
    private b dEw;
    private g dEx;
    private l dEy;
    private k dFb;
    private j dFc;
    private f dFd;
    private boolean dFe;
    private com.baidu.tbadk.widget.dragsort.d dFg;
    private com.baidu.tbadk.widget.dragsort.b dFh;
    private int mLastX;
    private int mLastY;
    private ListView mListView;
    private DataSetObserver mObserver;
    private int mOffsetY;
    private int mX;
    private int mY;
    private Point dEj = new Point();
    private Point dEk = new Point();
    private boolean dEm = false;
    private float dEn = 1.0f;
    private float dEo = 1.0f;
    private boolean dEs = false;
    private boolean mDragEnabled = true;
    private int mDragState = 0;
    private int dEz = 1;
    private int mWidthMeasureSpec = 0;
    private View[] dEB = new View[1];
    private float dED = 0.33333334f;
    private float dEE = 0.33333334f;
    private float dEL = 0.5f;
    private c dEM = new c() { // from class: com.baidu.tbadk.widget.dragsort.a.1
        @Override // com.baidu.tbadk.widget.dragsort.a.c
        public float b(float f2, long j2) {
            return a.this.dEL * f2;
        }
    };
    private int dEO = 0;
    private boolean dEP = false;
    private boolean dEQ = false;
    private h dER = null;
    private int dET = 0;
    private float dEU = 0.25f;
    private float dEV = 0.0f;
    private boolean dEX = false;
    private boolean mBlockLayoutRequests = false;
    private boolean dEZ = false;
    private i dFa = new i(3);
    private float dFf = 0.0f;
    private boolean dFi = false;
    private boolean dFj = false;

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

        void bf(View view);

        View mI(int i);
    }

    /* loaded from: classes.dex */
    public interface l {
        void remove(int i);
    }

    public a(ListView listView, com.baidu.tbadk.widget.dragsort.d dVar) {
        this.dFg = dVar;
        this.mListView = listView;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            this.dEW = new C0384a(listAdapter);
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
            this.dEW = null;
        }
        this.dFg.setAdapter(this.dEW);
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
            if (i2 > this.dEt) {
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
        return childAt != null ? childAt.getHeight() : aJ(i2, mG(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aH(int i2, int i3) {
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        if (i2 <= headerViewsCount || i2 >= this.mListView.getCount() - footerViewsCount) {
            return i3;
        }
        int dividerHeight = this.mListView.getDividerHeight();
        int i4 = this.bGg - this.dEz;
        int mG = mG(i2);
        int mE = mE(i2);
        if (this.dEr <= this.dEt) {
            if (i2 == this.dEr && this.dEq != this.dEr) {
                if (i2 == this.dEt) {
                    i3 = (i3 + mE) - this.bGg;
                } else {
                    i3 = ((mE - mG) + i3) - i4;
                }
            } else if (i2 > this.dEr && i2 <= this.dEt) {
                i3 -= i4;
            }
        } else if (i2 > this.dEt && i2 <= this.dEq) {
            i3 += i4;
        } else if (i2 == this.dEr && this.dEq != this.dEr) {
            i3 += mE - mG;
        }
        if (i2 <= this.dEt) {
            return (((this.bGg - dividerHeight) - mG(i2 - 1)) / 2) + i3;
        }
        return (((mG - dividerHeight) - this.bGg) / 2) + i3;
    }

    private boolean aQo() {
        int i2;
        int i3;
        int i4;
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int i5 = this.dEq;
        View childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        if (childAt == null) {
            i5 = firstVisiblePosition + (this.mListView.getChildCount() / 2);
            childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        }
        int top = childAt.getTop();
        int height = childAt.getHeight();
        int aH = aH(i5, top);
        int dividerHeight = this.mListView.getDividerHeight();
        if (this.dEl >= aH) {
            int count = this.mListView.getCount();
            int i6 = height;
            int i7 = top;
            i2 = aH;
            i3 = i5;
            i4 = aH;
            while (true) {
                if (i3 < count) {
                    if (i3 == count - 1) {
                        i2 = i7 + dividerHeight + i6;
                        break;
                    }
                    i7 += dividerHeight + i6;
                    i6 = mE(i3 + 1);
                    i2 = aH(i3 + 1, i7);
                    if (this.dEl < i2) {
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
            i2 = aH;
            i3 = i5;
            i4 = aH;
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
                i2 = aH(i3, i8);
                if (this.dEl >= i2) {
                    break;
                }
                i4 = i2;
            }
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int i9 = this.dEq;
        int i10 = this.dEr;
        float f2 = this.dEV;
        if (this.dEs) {
            int abs = Math.abs(i2 - i4);
            if (this.dEl >= i2) {
                int i11 = i4;
                i4 = i2;
                i2 = i11;
            }
            int i12 = (int) (abs * this.dEU * 0.5f);
            float f3 = i12;
            int i13 = i4 + i12;
            int i14 = i2 - i12;
            if (this.dEl < i13) {
                this.dEq = i3 - 1;
                this.dEr = i3;
                this.dEV = ((i13 - this.dEl) * 0.5f) / f3;
            } else if (this.dEl < i14) {
                this.dEq = i3;
                this.dEr = i3;
            } else {
                this.dEq = i3;
                this.dEr = i3 + 1;
                this.dEV = (1.0f + ((i2 - this.dEl) / f3)) * 0.5f;
            }
        } else {
            this.dEq = i3;
            this.dEr = i3;
        }
        if (this.dEq < headerViewsCount) {
            this.dEq = headerViewsCount;
            this.dEr = headerViewsCount;
            i3 = headerViewsCount;
        } else if (this.dEr >= this.mListView.getCount() - footerViewsCount) {
            i3 = (this.mListView.getCount() - footerViewsCount) - 1;
            this.dEq = i3;
            this.dEr = i3;
        }
        boolean z = (this.dEq == i9 && this.dEr == i10 && this.dEV == f2) ? false : true;
        if (i3 != this.dEp) {
            if (this.dEw != null) {
                this.dEw.drag(this.dEp - headerViewsCount, i3 - headerViewsCount);
            }
            this.dEp = i3;
            return true;
        }
        return z;
    }

    public void removeItem(int i2) {
        this.dFe = false;
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
            this.dEz = Math.max(1, obtainStyledAttributes.getDimensionPixelSize(12, 1));
            this.dEX = obtainStyledAttributes.getBoolean(6, false);
            if (this.dEX) {
                this.dEY = new e();
            }
            this.dEn = obtainStyledAttributes.getFloat(10, this.dEn);
            this.dEo = this.dEn;
            this.mDragEnabled = obtainStyledAttributes.getBoolean(13, this.mDragEnabled);
            this.dEU = Math.max(0.0f, Math.min(1.0f, 1.0f - obtainStyledAttributes.getFloat(2, 0.75f)));
            this.dEs = this.dEU > 0.0f;
            setDragScrollStart(obtainStyledAttributes.getFloat(14, this.dED));
            this.dEL = obtainStyledAttributes.getFloat(0, this.dEL);
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
                bVar.gW(z);
                bVar.gV(z2);
                bVar.setBackgroundColor(color);
                this.dER = bVar;
                a(bVar);
            }
            obtainStyledAttributes.recycle();
            i2 = i5;
            i3 = i4;
        }
        this.dEC = new d();
        if (i3 > 0) {
            this.dFb = new k(0.5f, i3);
        }
        if (i2 > 0) {
            this.dFd = new f(0.5f, i2);
        }
        this.dES = MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
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
        this.dFh = bVar;
        this.mListView.setOnTouchListener(bVar);
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void dispatchDraw(Canvas canvas) {
        float f2;
        this.dFg.dispatchDraw(canvas);
        if (this.mDragState != 0) {
            if (this.dEq != this.dEt) {
                b(this.dEq, canvas);
            }
            if (this.dEr != this.dEq && this.dEr != this.dEt) {
                b(this.dEr, canvas);
            }
        }
        if (this.dEi != null) {
            int width = this.dEi.getWidth();
            int height = this.dEi.getHeight();
            int i2 = this.dEj.x;
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
            int i3 = (int) (f2 * 255.0f * this.dEo);
            canvas.save();
            canvas.translate(this.dEj.x, this.dEj.y);
            canvas.clipRect(0, 0, width, height);
            canvas.saveLayerAlpha(0.0f, 0.0f, width, height, i3, 31);
            this.dEi.draw(canvas);
            canvas.restore();
            canvas.restore();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onDraw(Canvas canvas) {
        this.dFg.onDraw(canvas);
        if (this.dEX) {
            this.dEY.aQB();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.dEZ) {
            this.dEZ = false;
            return false;
        } else if (!this.mDragEnabled) {
            return this.dFg.onTouchEvent(motionEvent);
        } else {
            boolean z2 = this.dEP;
            this.dEP = false;
            if (!z2) {
                s(motionEvent);
            }
            if (this.mDragState == 4) {
                onDragTouchEvent(motionEvent);
                return true;
            }
            if (this.mDragState == 0 && this.dFg.onTouchEvent(motionEvent)) {
                z = true;
            }
            switch (motionEvent.getAction() & 255) {
                case 1:
                case 3:
                    aQt();
                    return z;
                case 2:
                default:
                    if (z) {
                        this.dET = 1;
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
            return this.dFg.onInterceptTouchEvent(motionEvent);
        }
        if (this.dFh != null) {
            this.dFh.aQD().onTouchEvent(motionEvent);
        }
        s(motionEvent);
        this.dEP = true;
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            if (this.mDragState != 0) {
                this.dEZ = true;
                return true;
            }
            this.dEQ = true;
        }
        if (this.dEi == null) {
            if (this.dFg.onInterceptTouchEvent(motionEvent)) {
                this.dFi = true;
                z = true;
            } else {
                z = false;
            }
            switch (action) {
                case 1:
                case 3:
                    aQt();
                    break;
                case 2:
                default:
                    if (z) {
                        this.dET = 1;
                        break;
                    } else {
                        this.dET = 2;
                        break;
                    }
            }
        } else {
            z = true;
        }
        if (action == 1 || action == 3) {
            this.dEQ = false;
        }
        return z;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        this.dFg.onSizeChanged(i2, i3, i4, i5);
        aQu();
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void requestLayout() {
        if (!this.mBlockLayoutRequests) {
            this.dFg.requestLayout();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onMeasure(int i2, int i3) {
        this.dFg.onMeasure(i2, i3);
        if (this.dEi != null) {
            if (this.dEi.isLayoutRequested()) {
                aQw();
            }
            this.dEm = true;
        }
        this.mWidthMeasureSpec = i2;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void layoutChildren() {
        this.dFg.layoutChildren();
        if (this.dEi != null) {
            if (this.dEi.isLayoutRequested() && !this.dEm) {
                aQw();
            }
            this.dEi.layout(0, 0, this.dEi.getMeasuredWidth(), this.dEi.getMeasuredHeight());
            this.dEm = false;
        }
    }

    public void removeItem(int i2, float f2) {
        if (this.mDragState == 0 || this.mDragState == 4) {
            if (this.mDragState == 0) {
                this.dEt = this.mListView.getHeaderViewsCount() + i2;
                this.dEq = this.dEt;
                this.dEr = this.dEt;
                this.dEp = this.dEt;
                View childAt = this.mListView.getChildAt(this.dEt - this.mListView.getFirstVisiblePosition());
                if (childAt != null) {
                    childAt.setVisibility(4);
                }
            }
            this.mDragState = 1;
            this.dFf = f2;
            if (this.dEQ) {
                switch (this.dET) {
                    case 1:
                        this.dFg.onTouchEvent(this.dES);
                        break;
                    case 2:
                        this.dFg.onInterceptTouchEvent(this.dES);
                        break;
                }
            }
            if (this.dFb != null) {
                this.dFb.start();
            } else {
                mF(i2);
            }
        }
    }

    public void cancelDrag() {
        if (this.mDragState == 4) {
            this.dEC.gU(true);
            aQy();
            aQp();
            aQv();
            if (this.dEQ) {
                this.mDragState = 3;
            } else {
                this.mDragState = 0;
            }
        }
    }

    private void aQp() {
        this.dEt = -1;
        this.dEq = -1;
        this.dEr = -1;
        this.dEp = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQq() {
        this.mDragState = 2;
        if (this.dEx != null && this.dEp >= 0 && this.dEp < this.mListView.getCount()) {
            int headerViewsCount = this.mListView.getHeaderViewsCount();
            this.dEx.drop(this.dEt - headerViewsCount, this.dEp - headerViewsCount);
        }
        aQy();
        aQs();
        aQp();
        aQv();
        if (this.dEQ) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQr() {
        mF(this.dEt - this.mListView.getHeaderViewsCount());
    }

    private void mF(int i2) {
        this.mDragState = 1;
        if (this.dEy != null) {
            this.dEy.remove(i2);
        }
        aQy();
        aQs();
        aQp();
        if (this.dEQ) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    private void aQs() {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        if (this.dEt < firstVisiblePosition) {
            View childAt = this.mListView.getChildAt(0);
            this.mListView.setSelectionFromTop(firstVisiblePosition - 1, (childAt != null ? childAt.getTop() : 0) - this.mListView.getPaddingTop());
        }
    }

    public boolean stopDrag(boolean z) {
        this.dFe = false;
        return stopDrag(z, 0.0f);
    }

    public boolean stopDragWithVelocity(boolean z, float f2) {
        this.dFe = true;
        return stopDrag(z, f2);
    }

    public boolean stopDrag(boolean z, float f2) {
        if (this.dEi != null) {
            this.dEC.gU(true);
            if (z) {
                removeItem(this.dEt - this.mListView.getHeaderViewsCount(), f2);
            } else if (this.dFd != null) {
                this.dFd.start();
            } else {
                aQq();
            }
            if (this.dEX) {
                this.dEY.stopTracking();
                return true;
            }
            return true;
        }
        return false;
    }

    private void aQt() {
        this.dET = 0;
        this.dEQ = false;
        if (this.mDragState == 3) {
            this.mDragState = 0;
        }
        this.dEo = this.dEn;
        this.dFi = false;
        this.dFa.clear();
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
        this.bcg = ((int) motionEvent.getRawX()) - this.mX;
        this.mOffsetY = ((int) motionEvent.getRawY()) - this.mY;
    }

    public boolean listViewIntercepted() {
        return this.dFi;
    }

    public void setDragScrollStart(float f2) {
        setDragScrollStarts(f2, f2);
    }

    public void setDragScrollStarts(float f2, float f3) {
        if (f3 > 0.5f) {
            this.dEE = 0.5f;
        } else {
            this.dEE = f3;
        }
        if (f2 > 0.5f) {
            this.dED = 0.5f;
        } else {
            this.dED = f2;
        }
        if (this.mListView.getHeight() != 0) {
            aQu();
        }
    }

    private void aI(int i2, int i3) {
        this.dEj.x = i2 - this.dEu;
        this.dEj.y = i3 - this.dEv;
        gT(true);
        int min = Math.min(i3, this.dEl + this.dEA);
        int max = Math.max(i3, this.dEl - this.dEA);
        int aQz = this.dEC.aQz();
        if (min > this.mLastY && min > this.dEG && aQz != 1) {
            if (aQz != -1) {
                this.dEC.gU(true);
            }
            this.dEC.mH(1);
        } else if (max < this.mLastY && max < this.dEF && aQz != 0) {
            if (aQz != -1) {
                this.dEC.gU(true);
            }
            this.dEC.mH(0);
        } else if (max >= this.dEF && min <= this.dEG && this.dEC.isScrolling()) {
            this.dEC.gU(true);
        }
    }

    private void aQu() {
        int height;
        int paddingTop = this.mListView.getPaddingTop();
        float height2 = (this.mListView.getHeight() - paddingTop) - this.mListView.getPaddingBottom();
        this.dEI = paddingTop + (this.dED * height2);
        this.dEH = (height2 * (1.0f - this.dEE)) + paddingTop;
        this.dEF = (int) this.dEI;
        this.dEG = (int) this.dEH;
        this.dEJ = this.dEI - paddingTop;
        this.dEK = (paddingTop + height) - this.dEH;
    }

    private void aQv() {
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
        if (i2 != this.dEt && i2 != this.dEq && i2 != this.dEr) {
            g2 = -2;
        } else {
            g2 = g(i2, view, z);
        }
        if (g2 != layoutParams.height) {
            layoutParams.height = g2;
            view.setLayoutParams(layoutParams);
        }
        if (i2 == this.dEq || i2 == this.dEr) {
            if (i2 < this.dEt) {
                ((DragSortItemView) view).setGravity(80);
            } else if (i2 > this.dEt) {
                ((DragSortItemView) view).setGravity(48);
            }
        }
        int visibility = view.getVisibility();
        int i3 = 0;
        if (i2 == this.dEt && this.dEi != null) {
            i3 = 4;
        }
        if (i3 != visibility) {
            view.setVisibility(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int mG(int i2) {
        View view;
        if (i2 == this.dEt) {
            return 0;
        }
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        if (childAt != null) {
            return f(i2, childAt, false);
        }
        int i3 = this.dFa.get(i2);
        if (i3 == -1) {
            ListAdapter adapter = this.mListView.getAdapter();
            int itemViewType = adapter.getItemViewType(i2);
            int viewTypeCount = adapter.getViewTypeCount();
            if (viewTypeCount != this.dEB.length) {
                this.dEB = new View[viewTypeCount];
            }
            if (itemViewType >= 0) {
                if (this.dEB[itemViewType] == null) {
                    view = adapter.getView(i2, null, this.mListView);
                    this.dEB[itemViewType] = view;
                } else {
                    view = adapter.getView(i2, this.dEB[itemViewType], this.mListView);
                }
            } else {
                view = adapter.getView(i2, null, this.mListView);
            }
            int f2 = f(i2, view, true);
            this.dFa.aK(i2, f2);
            return f2;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(int i2, View view, boolean z) {
        if (i2 == this.dEt) {
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
        return aJ(i2, f(i2, view, z));
    }

    private int aJ(int i2, int i3) {
        this.mListView.getDividerHeight();
        boolean z = this.dEs && this.dEq != this.dEr;
        int i4 = this.bGg - this.dEz;
        int i5 = (int) (this.dEV * i4);
        if (i2 == this.dEt) {
            if (this.dEt == this.dEq) {
                if (z) {
                    return i5 + this.dEz;
                }
                return this.bGg;
            } else if (this.dEt == this.dEr) {
                return this.bGg - i5;
            } else {
                return this.dEz;
            }
        } else if (i2 == this.dEq) {
            if (z) {
                return i3 + i5;
            }
            return i3 + i4;
        } else if (i2 == this.dEr) {
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
        int aJ = aJ(i2, mG);
        if (i2 != this.dEt) {
            i6 = height - mG;
            i5 = aJ - mG;
        } else {
            i5 = aJ;
            i6 = height;
        }
        int i7 = this.bGg;
        if (this.dEt != this.dEq && this.dEt != this.dEr) {
            i7 -= this.dEz;
        }
        if (i2 <= i3) {
            if (i2 > this.dEq) {
                return (i7 - i5) + 0;
            }
        } else if (i2 == i4) {
            if (i2 <= this.dEq) {
                return (i6 - i7) + 0;
            }
            if (i2 == this.dEr) {
                return (height - aJ) + 0;
            }
            return 0 + i6;
        } else if (i2 <= this.dEq) {
            return 0 - i7;
        } else {
            if (i2 == this.dEr) {
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

    private void aQw() {
        if (this.dEi != null) {
            measureItem(this.dEi);
            this.bGg = this.dEi.getMeasuredHeight();
            this.dEA = this.bGg / 2;
        }
    }

    protected boolean onDragTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        switch (motionEvent.getAction() & 255) {
            case 1:
                if (this.mDragState == 4) {
                    stopDrag(false);
                }
                aQt();
                return true;
            case 2:
                aI((int) motionEvent.getX(), (int) motionEvent.getY());
                return true;
            case 3:
                if (this.mDragState == 4) {
                    cancelDrag();
                }
                aQt();
                return true;
            default:
                return true;
        }
    }

    public boolean startDrag(int i2, int i3, int i4, int i5) {
        View mI;
        if (!this.dEQ || this.dER == null || (mI = this.dER.mI(i2)) == null) {
            return false;
        }
        return startDrag(i2, mI, i3, i4, i5);
    }

    public boolean startDrag(int i2, View view, int i3, int i4, int i5) {
        if (this.mDragState == 0 && this.dEQ && this.dEi == null && view != null && this.mDragEnabled) {
            if (this.mListView.getParent() != null) {
                this.mListView.getParent().requestDisallowInterceptTouchEvent(true);
            }
            int headerViewsCount = this.mListView.getHeaderViewsCount() + i2;
            this.dEq = headerViewsCount;
            this.dEr = headerViewsCount;
            this.dEt = headerViewsCount;
            this.dEp = headerViewsCount;
            this.mDragState = 4;
            this.dEO = 0;
            this.dEO |= i3;
            this.dEi = view;
            aQw();
            this.dEu = i4;
            this.dEv = i5;
            this.dEN = this.mY;
            this.dEj.x = this.mX - this.dEu;
            this.dEj.y = this.mY - this.dEv;
            View childAt = this.mListView.getChildAt(this.dEt - this.mListView.getFirstVisiblePosition());
            if (childAt != null) {
                childAt.setVisibility(4);
            }
            if (this.dEX) {
                this.dEY.aQA();
            }
            switch (this.dET) {
                case 1:
                    this.dFg.onTouchEvent(this.dES);
                    break;
                case 2:
                    this.dFg.onInterceptTouchEvent(this.dES);
                    break;
            }
            this.mListView.requestLayout();
            if (this.dFc != null) {
                this.dFc.start();
                return true;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gT(boolean z) {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition() + (this.mListView.getChildCount() / 2);
        View childAt = this.mListView.getChildAt(this.mListView.getChildCount() / 2);
        if (childAt != null) {
            h(firstVisiblePosition, childAt, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i2, View view, boolean z) {
        this.mBlockLayoutRequests = true;
        aQx();
        int i3 = this.dEq;
        int i4 = this.dEr;
        boolean aQo = aQo();
        if (aQo) {
            aQv();
            this.mListView.setSelectionFromTop(i2, (b(i2, view, i3, i4) + view.getTop()) - this.mListView.getPaddingTop());
            layoutChildren();
        }
        if (aQo || z) {
            this.mListView.invalidate();
        }
        this.mBlockLayoutRequests = false;
    }

    private void aQx() {
        if (this.dER != null) {
            this.dEk.set(this.mX, this.mY);
            this.dER.b(this.dEi, this.dEj, this.dEk);
        }
        int i2 = this.dEj.x;
        int i3 = this.dEj.y;
        int paddingLeft = this.mListView.getPaddingLeft();
        if ((this.dEO & 1) == 0 && i2 > paddingLeft) {
            this.dEj.x = paddingLeft;
        } else if ((this.dEO & 2) == 0 && i2 < paddingLeft) {
            this.dEj.x = paddingLeft;
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int lastVisiblePosition = this.mListView.getLastVisiblePosition();
        int paddingTop = this.mListView.getPaddingTop();
        if (firstVisiblePosition < headerViewsCount) {
            paddingTop = this.mListView.getChildAt((headerViewsCount - firstVisiblePosition) - 1).getBottom();
        }
        if ((this.dEO & 8) == 0 && firstVisiblePosition <= this.dEt) {
            paddingTop = Math.max(this.mListView.getChildAt(this.dEt - firstVisiblePosition).getTop(), paddingTop);
        }
        int height = this.mListView.getHeight() - this.mListView.getPaddingBottom();
        if (lastVisiblePosition >= (this.mListView.getCount() - footerViewsCount) - 1) {
            height = this.mListView.getChildAt(((this.mListView.getCount() - footerViewsCount) - 1) - firstVisiblePosition).getBottom();
        }
        if ((this.dEO & 4) == 0 && lastVisiblePosition >= this.dEt) {
            height = Math.min(this.mListView.getChildAt(this.dEt - firstVisiblePosition).getBottom(), height);
        }
        if (i3 < paddingTop) {
            this.dEj.y = paddingTop;
        } else if (this.bGg + i3 > height) {
            this.dEj.y = height - this.bGg;
        }
        this.dEl = this.dEj.y + this.dEA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQy() {
        if (this.dEi != null) {
            this.dEi.setVisibility(8);
            if (this.dER != null) {
                this.dER.bf(this.dEi);
            }
            this.dEi = null;
            this.mListView.invalidate();
        }
    }

    public void a(h hVar) {
        this.dER = hVar;
    }

    public void a(b bVar) {
        this.dEw = bVar;
    }

    public void setDragEnabled(boolean z) {
        this.mDragEnabled = z;
    }

    public boolean isDragEnabled() {
        return this.mDragEnabled;
    }

    public void a(g gVar) {
        this.dEx = gVar;
    }

    public void a(l lVar) {
        this.dEy = lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class i {
        private SparseIntArray dFC;
        private ArrayList<Integer> dFD;
        private int mMaxSize;

        public i(int i) {
            this.dFC = new SparseIntArray(i);
            this.dFD = new ArrayList<>(i);
            this.mMaxSize = i;
        }

        public void aK(int i, int i2) {
            int i3 = this.dFC.get(i, -1);
            if (i3 != i2) {
                if (i3 == -1) {
                    if (this.dFC.size() == this.mMaxSize) {
                        this.dFC.delete(this.dFD.remove(0).intValue());
                    }
                } else {
                    this.dFD.remove(Integer.valueOf(i));
                }
                this.dFC.put(i, i2);
                this.dFD.add(Integer.valueOf(i));
            }
        }

        public int get(int i) {
            return this.dFC.get(i, -1);
        }

        public void clear() {
            this.dFC.clear();
            this.dFD.clear();
        }
    }

    /* renamed from: com.baidu.tbadk.widget.dragsort.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0384a extends BaseAdapter {
        private ListAdapter mAdapter;

        public C0384a(ListAdapter listAdapter) {
            this.mAdapter = listAdapter;
            this.mAdapter.registerDataSetObserver(new DataSetObserver() { // from class: com.baidu.tbadk.widget.dragsort.a.a.1
                @Override // android.database.DataSetObserver
                public void onChanged() {
                    C0384a.this.notifyDataSetChanged();
                }

                @Override // android.database.DataSetObserver
                public void onInvalidated() {
                    C0384a.this.notifyDataSetInvalidated();
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
        private float bca;
        private float bcb;
        private float bcc;
        private float bcd;
        private float dFN;
        private float mAlpha;
        private boolean mCanceled;
        protected long mStartTime;

        public m(float f, int i) {
            this.mAlpha = f;
            this.dFN = i;
            float f2 = 1.0f / ((this.mAlpha * 2.0f) * (1.0f - this.mAlpha));
            this.bcd = f2;
            this.bca = f2;
            this.bcb = this.mAlpha / ((this.mAlpha - 1.0f) * 2.0f);
            this.bcc = 1.0f / (1.0f - this.mAlpha);
        }

        public float at(float f) {
            if (f < this.mAlpha) {
                return this.bca * f * f;
            }
            if (f < 1.0f - this.mAlpha) {
                return this.bcb + (this.bcc * f);
            }
            return 1.0f - ((this.bcd * (f - 1.0f)) * (f - 1.0f));
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
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / this.dFN;
                if (uptimeMillis >= 1.0f) {
                    t(1.0f, 1.0f);
                    onStop();
                    return;
                }
                t(uptimeMillis, at(uptimeMillis));
                a.this.mListView.post(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class f extends m {
        private float dFA;
        private float dFB;
        private int dFy;
        private int dFz;

        public f(float f, int i) {
            super(f, i);
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.dFy = a.this.dEp;
            this.dFz = a.this.dEt;
            a.this.mDragState = 2;
            this.dFA = a.this.dEj.y - aQC();
            this.dFB = a.this.dEj.x - a.this.mListView.getPaddingLeft();
        }

        private int aQC() {
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            int dividerHeight = (a.this.dEz + a.this.mListView.getDividerHeight()) / 2;
            View childAt = a.this.mListView.getChildAt(this.dFy - firstVisiblePosition);
            if (childAt != null) {
                if (this.dFy == this.dFz) {
                    return childAt.getTop();
                }
                if (this.dFy >= this.dFz) {
                    return (childAt.getBottom() + dividerHeight) - a.this.bGg;
                }
                return childAt.getTop() - dividerHeight;
            }
            cancel();
            return -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void t(float f, float f2) {
            int aQC = aQC();
            float paddingLeft = a.this.dEj.x - a.this.mListView.getPaddingLeft();
            float f3 = 1.0f - f2;
            if (f3 < Math.abs((a.this.dEj.y - aQC) / this.dFA) || f3 < Math.abs(paddingLeft / this.dFB)) {
                a.this.dEj.y = aQC + ((int) (this.dFA * f3));
                a.this.dEj.x = a.this.mListView.getPaddingLeft() + ((int) (this.dFB * f3));
                a.this.gT(true);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.aQq();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class k extends m {
        private float dFG;
        private float dFH;
        private float dFI;
        private int dFJ;
        private int dFK;
        private int dFL;
        private int dFM;
        private int dFz;

        public k(float f, int i) {
            super(f, i);
            this.dFJ = -1;
            this.dFK = -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.dFJ = -1;
            this.dFK = -1;
            this.dFL = a.this.dEq;
            this.dFM = a.this.dEr;
            this.dFz = a.this.dEt;
            a.this.mDragState = 1;
            this.dFG = a.this.dEj.x;
            if (a.this.dFe) {
                float width = a.this.mListView.getWidth() * 2.0f;
                if (a.this.dFf == 0.0f) {
                    a.this.dFf = (this.dFG >= 0.0f ? 1 : -1) * width;
                    return;
                }
                float f = width * 2.0f;
                if (a.this.dFf >= 0.0f || a.this.dFf <= (-f)) {
                    if (a.this.dFf > 0.0f && a.this.dFf < f) {
                        a.this.dFf = f;
                        return;
                    }
                    return;
                }
                a.this.dFf = -f;
                return;
            }
            a.this.aQy();
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void t(float f, float f2) {
            View childAt;
            float f3 = 1.0f - f2;
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            View childAt2 = a.this.mListView.getChildAt(this.dFL - firstVisiblePosition);
            if (a.this.dFe) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / 1000.0f;
                if (uptimeMillis != 0.0f) {
                    float f4 = a.this.dFf * uptimeMillis;
                    int width = a.this.mListView.getWidth();
                    a.this.dFf = ((a.this.dFf > 0.0f ? 1 : -1) * uptimeMillis * width) + a.this.dFf;
                    this.dFG += f4;
                    a.this.dEj.x = (int) this.dFG;
                    if (this.dFG < width && this.dFG > (-width)) {
                        this.mStartTime = SystemClock.uptimeMillis();
                        a.this.gT(true);
                        return;
                    }
                } else {
                    return;
                }
            }
            if (childAt2 != null) {
                if (this.dFJ == -1) {
                    this.dFJ = a.this.f(this.dFL, childAt2, false);
                    this.dFH = childAt2.getHeight() - this.dFJ;
                }
                int max = Math.max((int) (this.dFH * f3), 1);
                ViewGroup.LayoutParams layoutParams = childAt2.getLayoutParams();
                layoutParams.height = max + this.dFJ;
                childAt2.setLayoutParams(layoutParams);
            }
            if (this.dFM != this.dFL && (childAt = a.this.mListView.getChildAt(this.dFM - firstVisiblePosition)) != null) {
                if (this.dFK == -1) {
                    this.dFK = a.this.f(this.dFM, childAt, false);
                    this.dFI = childAt.getHeight() - this.dFK;
                }
                int max2 = Math.max((int) (this.dFI * f3), 1);
                ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
                layoutParams2.height = max2 + this.dFK;
                childAt.setLayoutParams(layoutParams2);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.aQr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class j extends m {
        private float dFE;
        private float dFF;
        final /* synthetic */ a dFk;

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.dFE = this.dFk.dEv;
            this.dFF = this.dFk.dEA;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void t(float f, float f2) {
            if (this.dFk.mDragState != 4) {
                cancel();
                return;
            }
            this.dFk.dEv = (int) ((this.dFF * f2) + ((1.0f - f2) * this.dFE));
            this.dFk.dEj.y = this.dFk.mY - this.dFk.dEv;
            this.dFk.gT(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e {
        StringBuilder mBuilder = new StringBuilder();
        private int dFv = 0;
        private int dFw = 0;
        private boolean dFx = false;
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

        public void aQA() {
            this.mBuilder.append("<DSLVStates>\n");
            this.dFw = 0;
            this.dFx = true;
        }

        public void aQB() {
            if (this.dFx) {
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
                this.mBuilder.append("    <FirstExpPos>").append(a.this.dEq).append("</FirstExpPos>\n");
                this.mBuilder.append("    <FirstExpBlankHeight>").append(a.this.mE(a.this.dEq) - a.this.mG(a.this.dEq)).append("</FirstExpBlankHeight>\n");
                this.mBuilder.append("    <SecondExpPos>").append(a.this.dEr).append("</SecondExpPos>\n");
                this.mBuilder.append("    <SecondExpBlankHeight>").append(a.this.mE(a.this.dEr) - a.this.mG(a.this.dEr)).append("</SecondExpBlankHeight>\n");
                this.mBuilder.append("    <SrcPos>").append(a.this.dEt).append("</SrcPos>\n");
                this.mBuilder.append("    <SrcHeight>").append(a.this.bGg + a.this.mListView.getDividerHeight()).append("</SrcHeight>\n");
                this.mBuilder.append("    <ViewHeight>").append(a.this.mListView.getHeight()).append("</ViewHeight>\n");
                this.mBuilder.append("    <LastY>").append(a.this.mLastY).append("</LastY>\n");
                this.mBuilder.append("    <FloatY>").append(a.this.dEl).append("</FloatY>\n");
                this.mBuilder.append("    <ShuffleEdges>");
                for (int i4 = 0; i4 < childCount; i4++) {
                    this.mBuilder.append(a.this.aH(firstVisiblePosition + i4, a.this.mListView.getChildAt(i4).getTop())).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                this.mBuilder.append("</ShuffleEdges>\n");
                this.mBuilder.append("</DSLVState>\n");
                this.dFv++;
                if (this.dFv > 1000) {
                    flush();
                    this.dFv = 0;
                }
            }
        }

        public void flush() {
            if (this.dFx) {
                try {
                    FileWriter fileWriter = new FileWriter(this.mFile, this.dFw != 0);
                    fileWriter.write(this.mBuilder.toString());
                    this.mBuilder.delete(0, this.mBuilder.length());
                    fileWriter.flush();
                    fileWriter.close();
                    this.dFw++;
                } catch (IOException e) {
                }
            }
        }

        public void stopTracking() {
            if (this.dFx) {
                this.mBuilder.append("</DSLVStates>\n");
                flush();
                this.dFx = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements Runnable {
        private boolean dFn;
        private long dFo;
        private long dFp;
        private int dFq;
        private float dFr;
        private long dFs;
        private int dFt;
        private float dFu;
        private boolean mScrolling = false;

        public boolean isScrolling() {
            return this.mScrolling;
        }

        public int aQz() {
            if (this.mScrolling) {
                return this.dFt;
            }
            return -1;
        }

        public d() {
        }

        public void mH(int i) {
            if (!this.mScrolling) {
                this.dFn = false;
                this.mScrolling = true;
                this.dFs = SystemClock.uptimeMillis();
                this.dFo = this.dFs;
                this.dFt = i;
                a.this.mListView.post(this);
            }
        }

        public void gU(boolean z) {
            if (z) {
                a.this.mListView.removeCallbacks(this);
                this.mScrolling = false;
                return;
            }
            this.dFn = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.dFn) {
                int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
                int lastVisiblePosition = a.this.mListView.getLastVisiblePosition();
                int count = a.this.mListView.getCount();
                int paddingTop = a.this.mListView.getPaddingTop();
                int height = (a.this.mListView.getHeight() - paddingTop) - a.this.mListView.getPaddingBottom();
                int min = Math.min(a.this.mY, a.this.dEl + a.this.dEA);
                int max = Math.max(a.this.mY, a.this.dEl - a.this.dEA);
                if (this.dFt == 0) {
                    View childAt = a.this.mListView.getChildAt(0);
                    if (childAt == null) {
                        this.mScrolling = false;
                        return;
                    } else if (firstVisiblePosition == 0 && childAt.getTop() == paddingTop) {
                        this.mScrolling = false;
                        return;
                    } else {
                        this.dFu = a.this.dEM.b((a.this.dEI - max) / a.this.dEJ, this.dFo);
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
                        this.dFu = -a.this.dEM.b((min - a.this.dEH) / a.this.dEK, this.dFo);
                    }
                }
                this.dFp = SystemClock.uptimeMillis();
                this.dFr = (float) (this.dFp - this.dFo);
                this.dFq = Math.round(this.dFu * this.dFr);
                if (this.dFq >= 0) {
                    this.dFq = Math.min(height, this.dFq);
                    lastVisiblePosition = firstVisiblePosition;
                } else {
                    this.dFq = Math.max(-height, this.dFq);
                }
                View childAt3 = a.this.mListView.getChildAt(lastVisiblePosition - firstVisiblePosition);
                int top = childAt3.getTop() + this.dFq;
                if (lastVisiblePosition == 0 && top > paddingTop) {
                    top = paddingTop;
                }
                a.this.mBlockLayoutRequests = true;
                a.this.mListView.setSelectionFromTop(lastVisiblePosition, top - paddingTop);
                a.this.layoutChildren();
                a.this.mListView.invalidate();
                a.this.mBlockLayoutRequests = false;
                a.this.h(lastVisiblePosition, childAt3, false);
                this.dFo = this.dFp;
                a.this.mListView.post(this);
                return;
            }
            this.mScrolling = false;
        }
    }
}
