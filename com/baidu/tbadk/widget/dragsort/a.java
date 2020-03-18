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
    private int bLi;
    private float dJA;
    private float dJB;
    private float dJC;
    private int dJF;
    private MotionEvent dJK;
    private C0397a dJO;
    private e dJQ;
    private k dJT;
    private j dJU;
    private f dJV;
    private boolean dJW;
    private com.baidu.tbadk.widget.dragsort.d dJY;
    private com.baidu.tbadk.widget.dragsort.b dJZ;
    private View dJa;
    private int dJd;
    private int dJh;
    private int dJi;
    private int dJj;
    private int dJl;
    private int dJm;
    private int dJn;
    private b dJo;
    private g dJp;
    private l dJq;
    private int dJs;
    private d dJu;
    private int dJx;
    private int dJy;
    private float dJz;
    private int mLastX;
    private int mLastY;
    private ListView mListView;
    private DataSetObserver mObserver;
    private int mOffsetX;
    private int mOffsetY;
    private int mX;
    private int mY;
    private Point dJb = new Point();
    private Point dJc = new Point();
    private boolean dJe = false;
    private float dJf = 1.0f;
    private float dJg = 1.0f;
    private boolean dJk = false;
    private boolean mDragEnabled = true;
    private int mDragState = 0;
    private int dJr = 1;
    private int mWidthMeasureSpec = 0;
    private View[] dJt = new View[1];
    private float dJv = 0.33333334f;
    private float dJw = 0.33333334f;
    private float dJD = 0.5f;
    private c dJE = new c() { // from class: com.baidu.tbadk.widget.dragsort.a.1
        @Override // com.baidu.tbadk.widget.dragsort.a.c
        public float b(float f2, long j2) {
            return a.this.dJD * f2;
        }
    };
    private int dJG = 0;
    private boolean dJH = false;
    private boolean dJI = false;
    private h dJJ = null;
    private int dJL = 0;
    private float dJM = 0.25f;
    private float dJN = 0.0f;
    private boolean dJP = false;
    private boolean mBlockLayoutRequests = false;
    private boolean dJR = false;
    private i dJS = new i(3);
    private float dJX = 0.0f;
    private boolean dKa = false;
    private boolean dKb = false;

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

        View nb(int i);
    }

    /* loaded from: classes.dex */
    public interface l {
        void remove(int i);
    }

    public a(ListView listView, com.baidu.tbadk.widget.dragsort.d dVar) {
        this.dJY = dVar;
        this.mListView = listView;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            this.dJO = new C0397a(listAdapter);
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
            this.dJO = null;
        }
        this.dJY.setAdapter(this.dJO);
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
            if (i2 > this.dJl) {
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
    public int mX(int i2) {
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        return childAt != null ? childAt.getHeight() : aO(i2, mZ(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aM(int i2, int i3) {
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        if (i2 <= headerViewsCount || i2 >= this.mListView.getCount() - footerViewsCount) {
            return i3;
        }
        int dividerHeight = this.mListView.getDividerHeight();
        int i4 = this.bLi - this.dJr;
        int mZ = mZ(i2);
        int mX = mX(i2);
        if (this.dJj <= this.dJl) {
            if (i2 == this.dJj && this.dJi != this.dJj) {
                if (i2 == this.dJl) {
                    i3 = (i3 + mX) - this.bLi;
                } else {
                    i3 = ((mX - mZ) + i3) - i4;
                }
            } else if (i2 > this.dJj && i2 <= this.dJl) {
                i3 -= i4;
            }
        } else if (i2 > this.dJl && i2 <= this.dJi) {
            i3 += i4;
        } else if (i2 == this.dJj && this.dJi != this.dJj) {
            i3 += mX - mZ;
        }
        if (i2 <= this.dJl) {
            return (((this.bLi - dividerHeight) - mZ(i2 - 1)) / 2) + i3;
        }
        return (((mZ - dividerHeight) - this.bLi) / 2) + i3;
    }

    private boolean aTf() {
        int i2;
        int i3;
        int i4;
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int i5 = this.dJi;
        View childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        if (childAt == null) {
            i5 = firstVisiblePosition + (this.mListView.getChildCount() / 2);
            childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        }
        int top2 = childAt.getTop();
        int height = childAt.getHeight();
        int aM = aM(i5, top2);
        int dividerHeight = this.mListView.getDividerHeight();
        if (this.dJd >= aM) {
            int count = this.mListView.getCount();
            int i6 = height;
            int i7 = top2;
            i2 = aM;
            i3 = i5;
            i4 = aM;
            while (true) {
                if (i3 < count) {
                    if (i3 == count - 1) {
                        i2 = i7 + dividerHeight + i6;
                        break;
                    }
                    i7 += dividerHeight + i6;
                    i6 = mX(i3 + 1);
                    i2 = aM(i3 + 1, i7);
                    if (this.dJd < i2) {
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
            i2 = aM;
            i3 = i5;
            i4 = aM;
            while (true) {
                if (i3 < 0) {
                    break;
                }
                i3--;
                int mX = mX(i3);
                if (i3 == 0) {
                    i2 = (i8 - dividerHeight) - mX;
                    break;
                }
                i8 -= mX + dividerHeight;
                i2 = aM(i3, i8);
                if (this.dJd >= i2) {
                    break;
                }
                i4 = i2;
            }
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int i9 = this.dJi;
        int i10 = this.dJj;
        float f2 = this.dJN;
        if (this.dJk) {
            int abs = Math.abs(i2 - i4);
            if (this.dJd >= i2) {
                int i11 = i4;
                i4 = i2;
                i2 = i11;
            }
            int i12 = (int) (abs * this.dJM * 0.5f);
            float f3 = i12;
            int i13 = i4 + i12;
            int i14 = i2 - i12;
            if (this.dJd < i13) {
                this.dJi = i3 - 1;
                this.dJj = i3;
                this.dJN = ((i13 - this.dJd) * 0.5f) / f3;
            } else if (this.dJd < i14) {
                this.dJi = i3;
                this.dJj = i3;
            } else {
                this.dJi = i3;
                this.dJj = i3 + 1;
                this.dJN = (1.0f + ((i2 - this.dJd) / f3)) * 0.5f;
            }
        } else {
            this.dJi = i3;
            this.dJj = i3;
        }
        if (this.dJi < headerViewsCount) {
            this.dJi = headerViewsCount;
            this.dJj = headerViewsCount;
            i3 = headerViewsCount;
        } else if (this.dJj >= this.mListView.getCount() - footerViewsCount) {
            i3 = (this.mListView.getCount() - footerViewsCount) - 1;
            this.dJi = i3;
            this.dJj = i3;
        }
        boolean z = (this.dJi == i9 && this.dJj == i10 && this.dJN == f2) ? false : true;
        if (i3 != this.dJh) {
            if (this.dJo != null) {
                this.dJo.drag(this.dJh - headerViewsCount, i3 - headerViewsCount);
            }
            this.dJh = i3;
            return true;
        }
        return z;
    }

    public void removeItem(int i2) {
        this.dJW = false;
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
            this.dJr = Math.max(1, obtainStyledAttributes.getDimensionPixelSize(12, 1));
            this.dJP = obtainStyledAttributes.getBoolean(6, false);
            if (this.dJP) {
                this.dJQ = new e();
            }
            this.dJf = obtainStyledAttributes.getFloat(10, this.dJf);
            this.dJg = this.dJf;
            this.mDragEnabled = obtainStyledAttributes.getBoolean(13, this.mDragEnabled);
            this.dJM = Math.max(0.0f, Math.min(1.0f, 1.0f - obtainStyledAttributes.getFloat(2, 0.75f)));
            this.dJk = this.dJM > 0.0f;
            setDragScrollStart(obtainStyledAttributes.getFloat(14, this.dJv));
            this.dJD = obtainStyledAttributes.getFloat(0, this.dJD);
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
                bVar.hj(z);
                bVar.hi(z2);
                bVar.setBackgroundColor(color);
                this.dJJ = bVar;
                a(bVar);
            }
            obtainStyledAttributes.recycle();
            i2 = i5;
            i3 = i4;
        }
        this.dJu = new d();
        if (i3 > 0) {
            this.dJT = new k(0.5f, i3);
        }
        if (i2 > 0) {
            this.dJV = new f(0.5f, i2);
        }
        this.dJK = MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
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
        this.dJZ = bVar;
        this.mListView.setOnTouchListener(bVar);
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void dispatchDraw(Canvas canvas) {
        float f2;
        this.dJY.dispatchDraw(canvas);
        if (this.mDragState != 0) {
            if (this.dJi != this.dJl) {
                b(this.dJi, canvas);
            }
            if (this.dJj != this.dJi && this.dJj != this.dJl) {
                b(this.dJj, canvas);
            }
        }
        if (this.dJa != null) {
            int width = this.dJa.getWidth();
            int height = this.dJa.getHeight();
            int i2 = this.dJb.x;
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
            int i3 = (int) (f2 * 255.0f * this.dJg);
            canvas.save();
            canvas.translate(this.dJb.x, this.dJb.y);
            canvas.clipRect(0, 0, width, height);
            canvas.saveLayerAlpha(0.0f, 0.0f, width, height, i3, 31);
            this.dJa.draw(canvas);
            canvas.restore();
            canvas.restore();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onDraw(Canvas canvas) {
        this.dJY.onDraw(canvas);
        if (this.dJP) {
            this.dJQ.aTs();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.dJR) {
            this.dJR = false;
            return false;
        } else if (!this.mDragEnabled) {
            return this.dJY.onTouchEvent(motionEvent);
        } else {
            boolean z2 = this.dJH;
            this.dJH = false;
            if (!z2) {
                s(motionEvent);
            }
            if (this.mDragState == 4) {
                onDragTouchEvent(motionEvent);
                return true;
            }
            if (this.mDragState == 0 && this.dJY.onTouchEvent(motionEvent)) {
                z = true;
            }
            switch (motionEvent.getAction() & 255) {
                case 1:
                case 3:
                    aTk();
                    return z;
                case 2:
                default:
                    if (z) {
                        this.dJL = 1;
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
            return this.dJY.onInterceptTouchEvent(motionEvent);
        }
        if (this.dJZ != null) {
            this.dJZ.aTu().onTouchEvent(motionEvent);
        }
        s(motionEvent);
        this.dJH = true;
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            if (this.mDragState != 0) {
                this.dJR = true;
                return true;
            }
            this.dJI = true;
        }
        if (this.dJa == null) {
            if (this.dJY.onInterceptTouchEvent(motionEvent)) {
                this.dKa = true;
                z = true;
            } else {
                z = false;
            }
            switch (action) {
                case 1:
                case 3:
                    aTk();
                    break;
                case 2:
                default:
                    if (z) {
                        this.dJL = 1;
                        break;
                    } else {
                        this.dJL = 2;
                        break;
                    }
            }
        } else {
            z = true;
        }
        if (action == 1 || action == 3) {
            this.dJI = false;
        }
        return z;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        this.dJY.onSizeChanged(i2, i3, i4, i5);
        aTl();
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void requestLayout() {
        if (!this.mBlockLayoutRequests) {
            this.dJY.requestLayout();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onMeasure(int i2, int i3) {
        this.dJY.onMeasure(i2, i3);
        if (this.dJa != null) {
            if (this.dJa.isLayoutRequested()) {
                aTn();
            }
            this.dJe = true;
        }
        this.mWidthMeasureSpec = i2;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void layoutChildren() {
        this.dJY.layoutChildren();
        if (this.dJa != null) {
            if (this.dJa.isLayoutRequested() && !this.dJe) {
                aTn();
            }
            this.dJa.layout(0, 0, this.dJa.getMeasuredWidth(), this.dJa.getMeasuredHeight());
            this.dJe = false;
        }
    }

    public void removeItem(int i2, float f2) {
        if (this.mDragState == 0 || this.mDragState == 4) {
            if (this.mDragState == 0) {
                this.dJl = this.mListView.getHeaderViewsCount() + i2;
                this.dJi = this.dJl;
                this.dJj = this.dJl;
                this.dJh = this.dJl;
                View childAt = this.mListView.getChildAt(this.dJl - this.mListView.getFirstVisiblePosition());
                if (childAt != null) {
                    childAt.setVisibility(4);
                }
            }
            this.mDragState = 1;
            this.dJX = f2;
            if (this.dJI) {
                switch (this.dJL) {
                    case 1:
                        this.dJY.onTouchEvent(this.dJK);
                        break;
                    case 2:
                        this.dJY.onInterceptTouchEvent(this.dJK);
                        break;
                }
            }
            if (this.dJT != null) {
                this.dJT.start();
            } else {
                mY(i2);
            }
        }
    }

    public void cancelDrag() {
        if (this.mDragState == 4) {
            this.dJu.hh(true);
            aTp();
            aTg();
            aTm();
            if (this.dJI) {
                this.mDragState = 3;
            } else {
                this.mDragState = 0;
            }
        }
    }

    private void aTg() {
        this.dJl = -1;
        this.dJi = -1;
        this.dJj = -1;
        this.dJh = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTh() {
        this.mDragState = 2;
        if (this.dJp != null && this.dJh >= 0 && this.dJh < this.mListView.getCount()) {
            int headerViewsCount = this.mListView.getHeaderViewsCount();
            this.dJp.drop(this.dJl - headerViewsCount, this.dJh - headerViewsCount);
        }
        aTp();
        aTj();
        aTg();
        aTm();
        if (this.dJI) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTi() {
        mY(this.dJl - this.mListView.getHeaderViewsCount());
    }

    private void mY(int i2) {
        this.mDragState = 1;
        if (this.dJq != null) {
            this.dJq.remove(i2);
        }
        aTp();
        aTj();
        aTg();
        if (this.dJI) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    private void aTj() {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        if (this.dJl < firstVisiblePosition) {
            View childAt = this.mListView.getChildAt(0);
            this.mListView.setSelectionFromTop(firstVisiblePosition - 1, (childAt != null ? childAt.getTop() : 0) - this.mListView.getPaddingTop());
        }
    }

    public boolean stopDrag(boolean z) {
        this.dJW = false;
        return stopDrag(z, 0.0f);
    }

    public boolean stopDragWithVelocity(boolean z, float f2) {
        this.dJW = true;
        return stopDrag(z, f2);
    }

    public boolean stopDrag(boolean z, float f2) {
        if (this.dJa != null) {
            this.dJu.hh(true);
            if (z) {
                removeItem(this.dJl - this.mListView.getHeaderViewsCount(), f2);
            } else if (this.dJV != null) {
                this.dJV.start();
            } else {
                aTh();
            }
            if (this.dJP) {
                this.dJQ.stopTracking();
                return true;
            }
            return true;
        }
        return false;
    }

    private void aTk() {
        this.dJL = 0;
        this.dJI = false;
        if (this.mDragState == 3) {
            this.mDragState = 0;
        }
        this.dJg = this.dJf;
        this.dKa = false;
        this.dJS.clear();
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
        return this.dKa;
    }

    public void setDragScrollStart(float f2) {
        setDragScrollStarts(f2, f2);
    }

    public void setDragScrollStarts(float f2, float f3) {
        if (f3 > 0.5f) {
            this.dJw = 0.5f;
        } else {
            this.dJw = f3;
        }
        if (f2 > 0.5f) {
            this.dJv = 0.5f;
        } else {
            this.dJv = f2;
        }
        if (this.mListView.getHeight() != 0) {
            aTl();
        }
    }

    private void aN(int i2, int i3) {
        this.dJb.x = i2 - this.dJm;
        this.dJb.y = i3 - this.dJn;
        hg(true);
        int min = Math.min(i3, this.dJd + this.dJs);
        int max = Math.max(i3, this.dJd - this.dJs);
        int aTq = this.dJu.aTq();
        if (min > this.mLastY && min > this.dJy && aTq != 1) {
            if (aTq != -1) {
                this.dJu.hh(true);
            }
            this.dJu.na(1);
        } else if (max < this.mLastY && max < this.dJx && aTq != 0) {
            if (aTq != -1) {
                this.dJu.hh(true);
            }
            this.dJu.na(0);
        } else if (max >= this.dJx && min <= this.dJy && this.dJu.isScrolling()) {
            this.dJu.hh(true);
        }
    }

    private void aTl() {
        int height;
        int paddingTop = this.mListView.getPaddingTop();
        float height2 = (this.mListView.getHeight() - paddingTop) - this.mListView.getPaddingBottom();
        this.dJA = paddingTop + (this.dJv * height2);
        this.dJz = (height2 * (1.0f - this.dJw)) + paddingTop;
        this.dJx = (int) this.dJA;
        this.dJy = (int) this.dJz;
        this.dJB = this.dJA - paddingTop;
        this.dJC = (paddingTop + height) - this.dJz;
    }

    private void aTm() {
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
        if (i2 != this.dJl && i2 != this.dJi && i2 != this.dJj) {
            g2 = -2;
        } else {
            g2 = g(i2, view, z);
        }
        if (g2 != layoutParams.height) {
            layoutParams.height = g2;
            view.setLayoutParams(layoutParams);
        }
        if (i2 == this.dJi || i2 == this.dJj) {
            if (i2 < this.dJl) {
                ((DragSortItemView) view).setGravity(80);
            } else if (i2 > this.dJl) {
                ((DragSortItemView) view).setGravity(48);
            }
        }
        int visibility = view.getVisibility();
        int i3 = 0;
        if (i2 == this.dJl && this.dJa != null) {
            i3 = 4;
        }
        if (i3 != visibility) {
            view.setVisibility(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int mZ(int i2) {
        View view;
        if (i2 == this.dJl) {
            return 0;
        }
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        if (childAt != null) {
            return f(i2, childAt, false);
        }
        int i3 = this.dJS.get(i2);
        if (i3 == -1) {
            ListAdapter adapter = this.mListView.getAdapter();
            int itemViewType = adapter.getItemViewType(i2);
            int viewTypeCount = adapter.getViewTypeCount();
            if (viewTypeCount != this.dJt.length) {
                this.dJt = new View[viewTypeCount];
            }
            if (itemViewType >= 0) {
                if (this.dJt[itemViewType] == null) {
                    view = adapter.getView(i2, null, this.mListView);
                    this.dJt[itemViewType] = view;
                } else {
                    view = adapter.getView(i2, this.dJt[itemViewType], this.mListView);
                }
            } else {
                view = adapter.getView(i2, null, this.mListView);
            }
            int f2 = f(i2, view, true);
            this.dJS.aP(i2, f2);
            return f2;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(int i2, View view, boolean z) {
        if (i2 == this.dJl) {
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
        return aO(i2, f(i2, view, z));
    }

    private int aO(int i2, int i3) {
        this.mListView.getDividerHeight();
        boolean z = this.dJk && this.dJi != this.dJj;
        int i4 = this.bLi - this.dJr;
        int i5 = (int) (this.dJN * i4);
        if (i2 == this.dJl) {
            if (this.dJl == this.dJi) {
                if (z) {
                    return i5 + this.dJr;
                }
                return this.bLi;
            } else if (this.dJl == this.dJj) {
                return this.bLi - i5;
            } else {
                return this.dJr;
            }
        } else if (i2 == this.dJi) {
            if (z) {
                return i3 + i5;
            }
            return i3 + i4;
        } else if (i2 == this.dJj) {
            return (i3 + i4) - i5;
        } else {
            return i3;
        }
    }

    private int b(int i2, View view, int i3, int i4) {
        int i5;
        int i6;
        int mZ = mZ(i2);
        int height = view.getHeight();
        int aO = aO(i2, mZ);
        if (i2 != this.dJl) {
            i6 = height - mZ;
            i5 = aO - mZ;
        } else {
            i5 = aO;
            i6 = height;
        }
        int i7 = this.bLi;
        if (this.dJl != this.dJi && this.dJl != this.dJj) {
            i7 -= this.dJr;
        }
        if (i2 <= i3) {
            if (i2 > this.dJi) {
                return (i7 - i5) + 0;
            }
        } else if (i2 == i4) {
            if (i2 <= this.dJi) {
                return (i6 - i7) + 0;
            }
            if (i2 == this.dJj) {
                return (height - aO) + 0;
            }
            return 0 + i6;
        } else if (i2 <= this.dJi) {
            return 0 - i7;
        } else {
            if (i2 == this.dJj) {
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

    private void aTn() {
        if (this.dJa != null) {
            measureItem(this.dJa);
            this.bLi = this.dJa.getMeasuredHeight();
            this.dJs = this.bLi / 2;
        }
    }

    protected boolean onDragTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        switch (motionEvent.getAction() & 255) {
            case 1:
                if (this.mDragState == 4) {
                    stopDrag(false);
                }
                aTk();
                return true;
            case 2:
                aN((int) motionEvent.getX(), (int) motionEvent.getY());
                return true;
            case 3:
                if (this.mDragState == 4) {
                    cancelDrag();
                }
                aTk();
                return true;
            default:
                return true;
        }
    }

    public boolean startDrag(int i2, int i3, int i4, int i5) {
        View nb;
        if (!this.dJI || this.dJJ == null || (nb = this.dJJ.nb(i2)) == null) {
            return false;
        }
        return startDrag(i2, nb, i3, i4, i5);
    }

    public boolean startDrag(int i2, View view, int i3, int i4, int i5) {
        if (this.mDragState == 0 && this.dJI && this.dJa == null && view != null && this.mDragEnabled) {
            if (this.mListView.getParent() != null) {
                this.mListView.getParent().requestDisallowInterceptTouchEvent(true);
            }
            int headerViewsCount = this.mListView.getHeaderViewsCount() + i2;
            this.dJi = headerViewsCount;
            this.dJj = headerViewsCount;
            this.dJl = headerViewsCount;
            this.dJh = headerViewsCount;
            this.mDragState = 4;
            this.dJG = 0;
            this.dJG |= i3;
            this.dJa = view;
            aTn();
            this.dJm = i4;
            this.dJn = i5;
            this.dJF = this.mY;
            this.dJb.x = this.mX - this.dJm;
            this.dJb.y = this.mY - this.dJn;
            View childAt = this.mListView.getChildAt(this.dJl - this.mListView.getFirstVisiblePosition());
            if (childAt != null) {
                childAt.setVisibility(4);
            }
            if (this.dJP) {
                this.dJQ.aTr();
            }
            switch (this.dJL) {
                case 1:
                    this.dJY.onTouchEvent(this.dJK);
                    break;
                case 2:
                    this.dJY.onInterceptTouchEvent(this.dJK);
                    break;
            }
            this.mListView.requestLayout();
            if (this.dJU != null) {
                this.dJU.start();
                return true;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hg(boolean z) {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition() + (this.mListView.getChildCount() / 2);
        View childAt = this.mListView.getChildAt(this.mListView.getChildCount() / 2);
        if (childAt != null) {
            h(firstVisiblePosition, childAt, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i2, View view, boolean z) {
        this.mBlockLayoutRequests = true;
        aTo();
        int i3 = this.dJi;
        int i4 = this.dJj;
        boolean aTf = aTf();
        if (aTf) {
            aTm();
            this.mListView.setSelectionFromTop(i2, (b(i2, view, i3, i4) + view.getTop()) - this.mListView.getPaddingTop());
            layoutChildren();
        }
        if (aTf || z) {
            this.mListView.invalidate();
        }
        this.mBlockLayoutRequests = false;
    }

    private void aTo() {
        if (this.dJJ != null) {
            this.dJc.set(this.mX, this.mY);
            this.dJJ.b(this.dJa, this.dJb, this.dJc);
        }
        int i2 = this.dJb.x;
        int i3 = this.dJb.y;
        int paddingLeft = this.mListView.getPaddingLeft();
        if ((this.dJG & 1) == 0 && i2 > paddingLeft) {
            this.dJb.x = paddingLeft;
        } else if ((this.dJG & 2) == 0 && i2 < paddingLeft) {
            this.dJb.x = paddingLeft;
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int lastVisiblePosition = this.mListView.getLastVisiblePosition();
        int paddingTop = this.mListView.getPaddingTop();
        if (firstVisiblePosition < headerViewsCount) {
            paddingTop = this.mListView.getChildAt((headerViewsCount - firstVisiblePosition) - 1).getBottom();
        }
        if ((this.dJG & 8) == 0 && firstVisiblePosition <= this.dJl) {
            paddingTop = Math.max(this.mListView.getChildAt(this.dJl - firstVisiblePosition).getTop(), paddingTop);
        }
        int height = this.mListView.getHeight() - this.mListView.getPaddingBottom();
        if (lastVisiblePosition >= (this.mListView.getCount() - footerViewsCount) - 1) {
            height = this.mListView.getChildAt(((this.mListView.getCount() - footerViewsCount) - 1) - firstVisiblePosition).getBottom();
        }
        if ((this.dJG & 4) == 0 && lastVisiblePosition >= this.dJl) {
            height = Math.min(this.mListView.getChildAt(this.dJl - firstVisiblePosition).getBottom(), height);
        }
        if (i3 < paddingTop) {
            this.dJb.y = paddingTop;
        } else if (this.bLi + i3 > height) {
            this.dJb.y = height - this.bLi;
        }
        this.dJd = this.dJb.y + this.dJs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTp() {
        if (this.dJa != null) {
            this.dJa.setVisibility(8);
            if (this.dJJ != null) {
                this.dJJ.bj(this.dJa);
            }
            this.dJa = null;
            this.mListView.invalidate();
        }
    }

    public void a(h hVar) {
        this.dJJ = hVar;
    }

    public void a(b bVar) {
        this.dJo = bVar;
    }

    public void setDragEnabled(boolean z) {
        this.mDragEnabled = z;
    }

    public boolean isDragEnabled() {
        return this.mDragEnabled;
    }

    public void a(g gVar) {
        this.dJp = gVar;
    }

    public void a(l lVar) {
        this.dJq = lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class i {
        private SparseIntArray dKu;
        private ArrayList<Integer> dKv;
        private int mMaxSize;

        public i(int i) {
            this.dKu = new SparseIntArray(i);
            this.dKv = new ArrayList<>(i);
            this.mMaxSize = i;
        }

        public void aP(int i, int i2) {
            int i3 = this.dKu.get(i, -1);
            if (i3 != i2) {
                if (i3 == -1) {
                    if (this.dKu.size() == this.mMaxSize) {
                        this.dKu.delete(this.dKv.remove(0).intValue());
                    }
                } else {
                    this.dKv.remove(Integer.valueOf(i));
                }
                this.dKu.put(i, i2);
                this.dKv.add(Integer.valueOf(i));
            }
        }

        public int get(int i) {
            return this.dKu.get(i, -1);
        }

        public void clear() {
            this.dKu.clear();
            this.dKv.clear();
        }
    }

    /* renamed from: com.baidu.tbadk.widget.dragsort.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0397a extends BaseAdapter {
        private ListAdapter mAdapter;

        public C0397a(ListAdapter listAdapter) {
            this.mAdapter = listAdapter;
            this.mAdapter.registerDataSetObserver(new DataSetObserver() { // from class: com.baidu.tbadk.widget.dragsort.a.a.1
                @Override // android.database.DataSetObserver
                public void onChanged() {
                    C0397a.this.notifyDataSetChanged();
                }

                @Override // android.database.DataSetObserver
                public void onInvalidated() {
                    C0397a.this.notifyDataSetInvalidated();
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
        private float bhu;
        private float bhv;
        private float bhw;
        private float bhx;
        private float dKF;
        private float mAlpha;
        private boolean mCanceled;
        protected long mStartTime;

        public m(float f, int i) {
            this.mAlpha = f;
            this.dKF = i;
            float f2 = 1.0f / ((this.mAlpha * 2.0f) * (1.0f - this.mAlpha));
            this.bhx = f2;
            this.bhu = f2;
            this.bhv = this.mAlpha / ((this.mAlpha - 1.0f) * 2.0f);
            this.bhw = 1.0f / (1.0f - this.mAlpha);
        }

        public float ar(float f) {
            if (f < this.mAlpha) {
                return this.bhu * f * f;
            }
            if (f < 1.0f - this.mAlpha) {
                return this.bhv + (this.bhw * f);
            }
            return 1.0f - ((this.bhx * (f - 1.0f)) * (f - 1.0f));
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
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / this.dKF;
                if (uptimeMillis >= 1.0f) {
                    t(1.0f, 1.0f);
                    onStop();
                    return;
                }
                t(uptimeMillis, ar(uptimeMillis));
                a.this.mListView.post(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class f extends m {
        private int dKq;
        private int dKr;
        private float dKs;
        private float dKt;

        public f(float f, int i) {
            super(f, i);
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.dKq = a.this.dJh;
            this.dKr = a.this.dJl;
            a.this.mDragState = 2;
            this.dKs = a.this.dJb.y - aTt();
            this.dKt = a.this.dJb.x - a.this.mListView.getPaddingLeft();
        }

        private int aTt() {
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            int dividerHeight = (a.this.dJr + a.this.mListView.getDividerHeight()) / 2;
            View childAt = a.this.mListView.getChildAt(this.dKq - firstVisiblePosition);
            if (childAt != null) {
                if (this.dKq == this.dKr) {
                    return childAt.getTop();
                }
                if (this.dKq >= this.dKr) {
                    return (childAt.getBottom() + dividerHeight) - a.this.bLi;
                }
                return childAt.getTop() - dividerHeight;
            }
            cancel();
            return -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void t(float f, float f2) {
            int aTt = aTt();
            float paddingLeft = a.this.dJb.x - a.this.mListView.getPaddingLeft();
            float f3 = 1.0f - f2;
            if (f3 < Math.abs((a.this.dJb.y - aTt) / this.dKs) || f3 < Math.abs(paddingLeft / this.dKt)) {
                a.this.dJb.y = aTt + ((int) (this.dKs * f3));
                a.this.dJb.x = a.this.mListView.getPaddingLeft() + ((int) (this.dKt * f3));
                a.this.hg(true);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.aTh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class k extends m {
        private float dKA;
        private int dKB;
        private int dKC;
        private int dKD;
        private int dKE;
        private int dKr;
        private float dKy;
        private float dKz;

        public k(float f, int i) {
            super(f, i);
            this.dKB = -1;
            this.dKC = -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.dKB = -1;
            this.dKC = -1;
            this.dKD = a.this.dJi;
            this.dKE = a.this.dJj;
            this.dKr = a.this.dJl;
            a.this.mDragState = 1;
            this.dKy = a.this.dJb.x;
            if (a.this.dJW) {
                float width = a.this.mListView.getWidth() * 2.0f;
                if (a.this.dJX == 0.0f) {
                    a.this.dJX = (this.dKy >= 0.0f ? 1 : -1) * width;
                    return;
                }
                float f = width * 2.0f;
                if (a.this.dJX >= 0.0f || a.this.dJX <= (-f)) {
                    if (a.this.dJX > 0.0f && a.this.dJX < f) {
                        a.this.dJX = f;
                        return;
                    }
                    return;
                }
                a.this.dJX = -f;
                return;
            }
            a.this.aTp();
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void t(float f, float f2) {
            View childAt;
            float f3 = 1.0f - f2;
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            View childAt2 = a.this.mListView.getChildAt(this.dKD - firstVisiblePosition);
            if (a.this.dJW) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / 1000.0f;
                if (uptimeMillis != 0.0f) {
                    float f4 = a.this.dJX * uptimeMillis;
                    int width = a.this.mListView.getWidth();
                    a.this.dJX = ((a.this.dJX > 0.0f ? 1 : -1) * uptimeMillis * width) + a.this.dJX;
                    this.dKy += f4;
                    a.this.dJb.x = (int) this.dKy;
                    if (this.dKy < width && this.dKy > (-width)) {
                        this.mStartTime = SystemClock.uptimeMillis();
                        a.this.hg(true);
                        return;
                    }
                } else {
                    return;
                }
            }
            if (childAt2 != null) {
                if (this.dKB == -1) {
                    this.dKB = a.this.f(this.dKD, childAt2, false);
                    this.dKz = childAt2.getHeight() - this.dKB;
                }
                int max = Math.max((int) (this.dKz * f3), 1);
                ViewGroup.LayoutParams layoutParams = childAt2.getLayoutParams();
                layoutParams.height = max + this.dKB;
                childAt2.setLayoutParams(layoutParams);
            }
            if (this.dKE != this.dKD && (childAt = a.this.mListView.getChildAt(this.dKE - firstVisiblePosition)) != null) {
                if (this.dKC == -1) {
                    this.dKC = a.this.f(this.dKE, childAt, false);
                    this.dKA = childAt.getHeight() - this.dKC;
                }
                int max2 = Math.max((int) (this.dKA * f3), 1);
                ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
                layoutParams2.height = max2 + this.dKC;
                childAt.setLayoutParams(layoutParams2);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.aTi();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class j extends m {
        final /* synthetic */ a dKc;
        private float dKw;
        private float dKx;

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.dKw = this.dKc.dJn;
            this.dKx = this.dKc.dJs;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void t(float f, float f2) {
            if (this.dKc.mDragState != 4) {
                cancel();
                return;
            }
            this.dKc.dJn = (int) ((this.dKx * f2) + ((1.0f - f2) * this.dKw));
            this.dKc.dJb.y = this.dKc.mY - this.dKc.dJn;
            this.dKc.hg(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e {
        StringBuilder mBuilder = new StringBuilder();
        private int dKn = 0;
        private int dKo = 0;
        private boolean dKp = false;
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

        public void aTr() {
            this.mBuilder.append("<DSLVStates>\n");
            this.dKo = 0;
            this.dKp = true;
        }

        public void aTs() {
            if (this.dKp) {
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
                this.mBuilder.append("    <FirstExpPos>").append(a.this.dJi).append("</FirstExpPos>\n");
                this.mBuilder.append("    <FirstExpBlankHeight>").append(a.this.mX(a.this.dJi) - a.this.mZ(a.this.dJi)).append("</FirstExpBlankHeight>\n");
                this.mBuilder.append("    <SecondExpPos>").append(a.this.dJj).append("</SecondExpPos>\n");
                this.mBuilder.append("    <SecondExpBlankHeight>").append(a.this.mX(a.this.dJj) - a.this.mZ(a.this.dJj)).append("</SecondExpBlankHeight>\n");
                this.mBuilder.append("    <SrcPos>").append(a.this.dJl).append("</SrcPos>\n");
                this.mBuilder.append("    <SrcHeight>").append(a.this.bLi + a.this.mListView.getDividerHeight()).append("</SrcHeight>\n");
                this.mBuilder.append("    <ViewHeight>").append(a.this.mListView.getHeight()).append("</ViewHeight>\n");
                this.mBuilder.append("    <LastY>").append(a.this.mLastY).append("</LastY>\n");
                this.mBuilder.append("    <FloatY>").append(a.this.dJd).append("</FloatY>\n");
                this.mBuilder.append("    <ShuffleEdges>");
                for (int i4 = 0; i4 < childCount; i4++) {
                    this.mBuilder.append(a.this.aM(firstVisiblePosition + i4, a.this.mListView.getChildAt(i4).getTop())).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                this.mBuilder.append("</ShuffleEdges>\n");
                this.mBuilder.append("</DSLVState>\n");
                this.dKn++;
                if (this.dKn > 1000) {
                    flush();
                    this.dKn = 0;
                }
            }
        }

        public void flush() {
            if (this.dKp) {
                try {
                    FileWriter fileWriter = new FileWriter(this.mFile, this.dKo != 0);
                    fileWriter.write(this.mBuilder.toString());
                    this.mBuilder.delete(0, this.mBuilder.length());
                    fileWriter.flush();
                    fileWriter.close();
                    this.dKo++;
                } catch (IOException e) {
                }
            }
        }

        public void stopTracking() {
            if (this.dKp) {
                this.mBuilder.append("</DSLVStates>\n");
                flush();
                this.dKp = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements Runnable {
        private boolean dKf;
        private long dKg;
        private long dKh;
        private int dKi;
        private float dKj;
        private long dKk;
        private int dKl;
        private float dKm;
        private boolean mScrolling = false;

        public boolean isScrolling() {
            return this.mScrolling;
        }

        public int aTq() {
            if (this.mScrolling) {
                return this.dKl;
            }
            return -1;
        }

        public d() {
        }

        public void na(int i) {
            if (!this.mScrolling) {
                this.dKf = false;
                this.mScrolling = true;
                this.dKk = SystemClock.uptimeMillis();
                this.dKg = this.dKk;
                this.dKl = i;
                a.this.mListView.post(this);
            }
        }

        public void hh(boolean z) {
            if (z) {
                a.this.mListView.removeCallbacks(this);
                this.mScrolling = false;
                return;
            }
            this.dKf = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.dKf) {
                int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
                int lastVisiblePosition = a.this.mListView.getLastVisiblePosition();
                int count = a.this.mListView.getCount();
                int paddingTop = a.this.mListView.getPaddingTop();
                int height = (a.this.mListView.getHeight() - paddingTop) - a.this.mListView.getPaddingBottom();
                int min = Math.min(a.this.mY, a.this.dJd + a.this.dJs);
                int max = Math.max(a.this.mY, a.this.dJd - a.this.dJs);
                if (this.dKl == 0) {
                    View childAt = a.this.mListView.getChildAt(0);
                    if (childAt == null) {
                        this.mScrolling = false;
                        return;
                    } else if (firstVisiblePosition == 0 && childAt.getTop() == paddingTop) {
                        this.mScrolling = false;
                        return;
                    } else {
                        this.dKm = a.this.dJE.b((a.this.dJA - max) / a.this.dJB, this.dKg);
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
                        this.dKm = -a.this.dJE.b((min - a.this.dJz) / a.this.dJC, this.dKg);
                    }
                }
                this.dKh = SystemClock.uptimeMillis();
                this.dKj = (float) (this.dKh - this.dKg);
                this.dKi = Math.round(this.dKm * this.dKj);
                if (this.dKi >= 0) {
                    this.dKi = Math.min(height, this.dKi);
                    lastVisiblePosition = firstVisiblePosition;
                } else {
                    this.dKi = Math.max(-height, this.dKi);
                }
                View childAt3 = a.this.mListView.getChildAt(lastVisiblePosition - firstVisiblePosition);
                int top2 = childAt3.getTop() + this.dKi;
                if (lastVisiblePosition == 0 && top2 > paddingTop) {
                    top2 = paddingTop;
                }
                a.this.mBlockLayoutRequests = true;
                a.this.mListView.setSelectionFromTop(lastVisiblePosition, top2 - paddingTop);
                a.this.layoutChildren();
                a.this.mListView.invalidate();
                a.this.mBlockLayoutRequests = false;
                a.this.h(lastVisiblePosition, childAt3, false);
                this.dKg = this.dKh;
                a.this.mListView.post(this);
                return;
            }
            this.mScrolling = false;
        }
    }
}
