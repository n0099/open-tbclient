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
    private int bKX;
    private View dIK;
    private int dIN;
    private int dIR;
    private int dIS;
    private int dIT;
    private int dIV;
    private int dIW;
    private int dIX;
    private b dIY;
    private g dIZ;
    private e dJA;
    private k dJD;
    private j dJE;
    private f dJF;
    private boolean dJG;
    private com.baidu.tbadk.widget.dragsort.d dJI;
    private com.baidu.tbadk.widget.dragsort.b dJJ;
    private l dJa;
    private int dJc;
    private d dJe;
    private int dJh;
    private int dJi;
    private float dJj;
    private float dJk;
    private float dJl;
    private float dJm;
    private int dJp;
    private MotionEvent dJu;
    private C0397a dJy;
    private int mLastX;
    private int mLastY;
    private ListView mListView;
    private DataSetObserver mObserver;
    private int mOffsetX;
    private int mOffsetY;
    private int mX;
    private int mY;
    private Point dIL = new Point();
    private Point dIM = new Point();
    private boolean dIO = false;
    private float dIP = 1.0f;
    private float dIQ = 1.0f;
    private boolean dIU = false;
    private boolean mDragEnabled = true;
    private int mDragState = 0;
    private int dJb = 1;
    private int mWidthMeasureSpec = 0;
    private View[] dJd = new View[1];
    private float dJf = 0.33333334f;
    private float dJg = 0.33333334f;
    private float dJn = 0.5f;
    private c dJo = new c() { // from class: com.baidu.tbadk.widget.dragsort.a.1
        @Override // com.baidu.tbadk.widget.dragsort.a.c
        public float b(float f2, long j2) {
            return a.this.dJn * f2;
        }
    };
    private int dJq = 0;
    private boolean dJr = false;
    private boolean dJs = false;
    private h dJt = null;
    private int dJv = 0;
    private float dJw = 0.25f;
    private float dJx = 0.0f;
    private boolean dJz = false;
    private boolean mBlockLayoutRequests = false;
    private boolean dJB = false;
    private i dJC = new i(3);
    private float dJH = 0.0f;
    private boolean dJK = false;
    private boolean dJL = false;

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

        View mZ(int i);
    }

    /* loaded from: classes.dex */
    public interface l {
        void remove(int i);
    }

    public a(ListView listView, com.baidu.tbadk.widget.dragsort.d dVar) {
        this.dJI = dVar;
        this.mListView = listView;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            this.dJy = new C0397a(listAdapter);
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
            this.dJy = null;
        }
        this.dJI.setAdapter(this.dJy);
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
            if (i2 > this.dIV) {
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
    public int mV(int i2) {
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        return childAt != null ? childAt.getHeight() : aN(i2, mX(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aL(int i2, int i3) {
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        if (i2 <= headerViewsCount || i2 >= this.mListView.getCount() - footerViewsCount) {
            return i3;
        }
        int dividerHeight = this.mListView.getDividerHeight();
        int i4 = this.bKX - this.dJb;
        int mX = mX(i2);
        int mV = mV(i2);
        if (this.dIT <= this.dIV) {
            if (i2 == this.dIT && this.dIS != this.dIT) {
                if (i2 == this.dIV) {
                    i3 = (i3 + mV) - this.bKX;
                } else {
                    i3 = ((mV - mX) + i3) - i4;
                }
            } else if (i2 > this.dIT && i2 <= this.dIV) {
                i3 -= i4;
            }
        } else if (i2 > this.dIV && i2 <= this.dIS) {
            i3 += i4;
        } else if (i2 == this.dIT && this.dIS != this.dIT) {
            i3 += mV - mX;
        }
        if (i2 <= this.dIV) {
            return (((this.bKX - dividerHeight) - mX(i2 - 1)) / 2) + i3;
        }
        return (((mX - dividerHeight) - this.bKX) / 2) + i3;
    }

    private boolean aTb() {
        int i2;
        int i3;
        int i4;
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int i5 = this.dIS;
        View childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        if (childAt == null) {
            i5 = firstVisiblePosition + (this.mListView.getChildCount() / 2);
            childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        }
        int top2 = childAt.getTop();
        int height = childAt.getHeight();
        int aL = aL(i5, top2);
        int dividerHeight = this.mListView.getDividerHeight();
        if (this.dIN >= aL) {
            int count = this.mListView.getCount();
            int i6 = height;
            int i7 = top2;
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
                    i6 = mV(i3 + 1);
                    i2 = aL(i3 + 1, i7);
                    if (this.dIN < i2) {
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
            i2 = aL;
            i3 = i5;
            i4 = aL;
            while (true) {
                if (i3 < 0) {
                    break;
                }
                i3--;
                int mV = mV(i3);
                if (i3 == 0) {
                    i2 = (i8 - dividerHeight) - mV;
                    break;
                }
                i8 -= mV + dividerHeight;
                i2 = aL(i3, i8);
                if (this.dIN >= i2) {
                    break;
                }
                i4 = i2;
            }
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int i9 = this.dIS;
        int i10 = this.dIT;
        float f2 = this.dJx;
        if (this.dIU) {
            int abs = Math.abs(i2 - i4);
            if (this.dIN >= i2) {
                int i11 = i4;
                i4 = i2;
                i2 = i11;
            }
            int i12 = (int) (abs * this.dJw * 0.5f);
            float f3 = i12;
            int i13 = i4 + i12;
            int i14 = i2 - i12;
            if (this.dIN < i13) {
                this.dIS = i3 - 1;
                this.dIT = i3;
                this.dJx = ((i13 - this.dIN) * 0.5f) / f3;
            } else if (this.dIN < i14) {
                this.dIS = i3;
                this.dIT = i3;
            } else {
                this.dIS = i3;
                this.dIT = i3 + 1;
                this.dJx = (1.0f + ((i2 - this.dIN) / f3)) * 0.5f;
            }
        } else {
            this.dIS = i3;
            this.dIT = i3;
        }
        if (this.dIS < headerViewsCount) {
            this.dIS = headerViewsCount;
            this.dIT = headerViewsCount;
            i3 = headerViewsCount;
        } else if (this.dIT >= this.mListView.getCount() - footerViewsCount) {
            i3 = (this.mListView.getCount() - footerViewsCount) - 1;
            this.dIS = i3;
            this.dIT = i3;
        }
        boolean z = (this.dIS == i9 && this.dIT == i10 && this.dJx == f2) ? false : true;
        if (i3 != this.dIR) {
            if (this.dIY != null) {
                this.dIY.drag(this.dIR - headerViewsCount, i3 - headerViewsCount);
            }
            this.dIR = i3;
            return true;
        }
        return z;
    }

    public void removeItem(int i2) {
        this.dJG = false;
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
            this.dJb = Math.max(1, obtainStyledAttributes.getDimensionPixelSize(12, 1));
            this.dJz = obtainStyledAttributes.getBoolean(6, false);
            if (this.dJz) {
                this.dJA = new e();
            }
            this.dIP = obtainStyledAttributes.getFloat(10, this.dIP);
            this.dIQ = this.dIP;
            this.mDragEnabled = obtainStyledAttributes.getBoolean(13, this.mDragEnabled);
            this.dJw = Math.max(0.0f, Math.min(1.0f, 1.0f - obtainStyledAttributes.getFloat(2, 0.75f)));
            this.dIU = this.dJw > 0.0f;
            setDragScrollStart(obtainStyledAttributes.getFloat(14, this.dJf));
            this.dJn = obtainStyledAttributes.getFloat(0, this.dJn);
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
                bVar.hi(z);
                bVar.hh(z2);
                bVar.setBackgroundColor(color);
                this.dJt = bVar;
                a(bVar);
            }
            obtainStyledAttributes.recycle();
            i2 = i5;
            i3 = i4;
        }
        this.dJe = new d();
        if (i3 > 0) {
            this.dJD = new k(0.5f, i3);
        }
        if (i2 > 0) {
            this.dJF = new f(0.5f, i2);
        }
        this.dJu = MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
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
        this.dJJ = bVar;
        this.mListView.setOnTouchListener(bVar);
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void dispatchDraw(Canvas canvas) {
        float f2;
        this.dJI.dispatchDraw(canvas);
        if (this.mDragState != 0) {
            if (this.dIS != this.dIV) {
                b(this.dIS, canvas);
            }
            if (this.dIT != this.dIS && this.dIT != this.dIV) {
                b(this.dIT, canvas);
            }
        }
        if (this.dIK != null) {
            int width = this.dIK.getWidth();
            int height = this.dIK.getHeight();
            int i2 = this.dIL.x;
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
            int i3 = (int) (f2 * 255.0f * this.dIQ);
            canvas.save();
            canvas.translate(this.dIL.x, this.dIL.y);
            canvas.clipRect(0, 0, width, height);
            canvas.saveLayerAlpha(0.0f, 0.0f, width, height, i3, 31);
            this.dIK.draw(canvas);
            canvas.restore();
            canvas.restore();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onDraw(Canvas canvas) {
        this.dJI.onDraw(canvas);
        if (this.dJz) {
            this.dJA.aTo();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.dJB) {
            this.dJB = false;
            return false;
        } else if (!this.mDragEnabled) {
            return this.dJI.onTouchEvent(motionEvent);
        } else {
            boolean z2 = this.dJr;
            this.dJr = false;
            if (!z2) {
                s(motionEvent);
            }
            if (this.mDragState == 4) {
                onDragTouchEvent(motionEvent);
                return true;
            }
            if (this.mDragState == 0 && this.dJI.onTouchEvent(motionEvent)) {
                z = true;
            }
            switch (motionEvent.getAction() & 255) {
                case 1:
                case 3:
                    aTg();
                    return z;
                case 2:
                default:
                    if (z) {
                        this.dJv = 1;
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
            return this.dJI.onInterceptTouchEvent(motionEvent);
        }
        if (this.dJJ != null) {
            this.dJJ.aTq().onTouchEvent(motionEvent);
        }
        s(motionEvent);
        this.dJr = true;
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            if (this.mDragState != 0) {
                this.dJB = true;
                return true;
            }
            this.dJs = true;
        }
        if (this.dIK == null) {
            if (this.dJI.onInterceptTouchEvent(motionEvent)) {
                this.dJK = true;
                z = true;
            } else {
                z = false;
            }
            switch (action) {
                case 1:
                case 3:
                    aTg();
                    break;
                case 2:
                default:
                    if (z) {
                        this.dJv = 1;
                        break;
                    } else {
                        this.dJv = 2;
                        break;
                    }
            }
        } else {
            z = true;
        }
        if (action == 1 || action == 3) {
            this.dJs = false;
        }
        return z;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        this.dJI.onSizeChanged(i2, i3, i4, i5);
        aTh();
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void requestLayout() {
        if (!this.mBlockLayoutRequests) {
            this.dJI.requestLayout();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onMeasure(int i2, int i3) {
        this.dJI.onMeasure(i2, i3);
        if (this.dIK != null) {
            if (this.dIK.isLayoutRequested()) {
                aTj();
            }
            this.dIO = true;
        }
        this.mWidthMeasureSpec = i2;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void layoutChildren() {
        this.dJI.layoutChildren();
        if (this.dIK != null) {
            if (this.dIK.isLayoutRequested() && !this.dIO) {
                aTj();
            }
            this.dIK.layout(0, 0, this.dIK.getMeasuredWidth(), this.dIK.getMeasuredHeight());
            this.dIO = false;
        }
    }

    public void removeItem(int i2, float f2) {
        if (this.mDragState == 0 || this.mDragState == 4) {
            if (this.mDragState == 0) {
                this.dIV = this.mListView.getHeaderViewsCount() + i2;
                this.dIS = this.dIV;
                this.dIT = this.dIV;
                this.dIR = this.dIV;
                View childAt = this.mListView.getChildAt(this.dIV - this.mListView.getFirstVisiblePosition());
                if (childAt != null) {
                    childAt.setVisibility(4);
                }
            }
            this.mDragState = 1;
            this.dJH = f2;
            if (this.dJs) {
                switch (this.dJv) {
                    case 1:
                        this.dJI.onTouchEvent(this.dJu);
                        break;
                    case 2:
                        this.dJI.onInterceptTouchEvent(this.dJu);
                        break;
                }
            }
            if (this.dJD != null) {
                this.dJD.start();
            } else {
                mW(i2);
            }
        }
    }

    public void cancelDrag() {
        if (this.mDragState == 4) {
            this.dJe.hg(true);
            aTl();
            aTc();
            aTi();
            if (this.dJs) {
                this.mDragState = 3;
            } else {
                this.mDragState = 0;
            }
        }
    }

    private void aTc() {
        this.dIV = -1;
        this.dIS = -1;
        this.dIT = -1;
        this.dIR = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTd() {
        this.mDragState = 2;
        if (this.dIZ != null && this.dIR >= 0 && this.dIR < this.mListView.getCount()) {
            int headerViewsCount = this.mListView.getHeaderViewsCount();
            this.dIZ.drop(this.dIV - headerViewsCount, this.dIR - headerViewsCount);
        }
        aTl();
        aTf();
        aTc();
        aTi();
        if (this.dJs) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTe() {
        mW(this.dIV - this.mListView.getHeaderViewsCount());
    }

    private void mW(int i2) {
        this.mDragState = 1;
        if (this.dJa != null) {
            this.dJa.remove(i2);
        }
        aTl();
        aTf();
        aTc();
        if (this.dJs) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    private void aTf() {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        if (this.dIV < firstVisiblePosition) {
            View childAt = this.mListView.getChildAt(0);
            this.mListView.setSelectionFromTop(firstVisiblePosition - 1, (childAt != null ? childAt.getTop() : 0) - this.mListView.getPaddingTop());
        }
    }

    public boolean stopDrag(boolean z) {
        this.dJG = false;
        return stopDrag(z, 0.0f);
    }

    public boolean stopDragWithVelocity(boolean z, float f2) {
        this.dJG = true;
        return stopDrag(z, f2);
    }

    public boolean stopDrag(boolean z, float f2) {
        if (this.dIK != null) {
            this.dJe.hg(true);
            if (z) {
                removeItem(this.dIV - this.mListView.getHeaderViewsCount(), f2);
            } else if (this.dJF != null) {
                this.dJF.start();
            } else {
                aTd();
            }
            if (this.dJz) {
                this.dJA.stopTracking();
                return true;
            }
            return true;
        }
        return false;
    }

    private void aTg() {
        this.dJv = 0;
        this.dJs = false;
        if (this.mDragState == 3) {
            this.mDragState = 0;
        }
        this.dIQ = this.dIP;
        this.dJK = false;
        this.dJC.clear();
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
        return this.dJK;
    }

    public void setDragScrollStart(float f2) {
        setDragScrollStarts(f2, f2);
    }

    public void setDragScrollStarts(float f2, float f3) {
        if (f3 > 0.5f) {
            this.dJg = 0.5f;
        } else {
            this.dJg = f3;
        }
        if (f2 > 0.5f) {
            this.dJf = 0.5f;
        } else {
            this.dJf = f2;
        }
        if (this.mListView.getHeight() != 0) {
            aTh();
        }
    }

    private void aM(int i2, int i3) {
        this.dIL.x = i2 - this.dIW;
        this.dIL.y = i3 - this.dIX;
        hf(true);
        int min = Math.min(i3, this.dIN + this.dJc);
        int max = Math.max(i3, this.dIN - this.dJc);
        int aTm = this.dJe.aTm();
        if (min > this.mLastY && min > this.dJi && aTm != 1) {
            if (aTm != -1) {
                this.dJe.hg(true);
            }
            this.dJe.mY(1);
        } else if (max < this.mLastY && max < this.dJh && aTm != 0) {
            if (aTm != -1) {
                this.dJe.hg(true);
            }
            this.dJe.mY(0);
        } else if (max >= this.dJh && min <= this.dJi && this.dJe.isScrolling()) {
            this.dJe.hg(true);
        }
    }

    private void aTh() {
        int height;
        int paddingTop = this.mListView.getPaddingTop();
        float height2 = (this.mListView.getHeight() - paddingTop) - this.mListView.getPaddingBottom();
        this.dJk = paddingTop + (this.dJf * height2);
        this.dJj = (height2 * (1.0f - this.dJg)) + paddingTop;
        this.dJh = (int) this.dJk;
        this.dJi = (int) this.dJj;
        this.dJl = this.dJk - paddingTop;
        this.dJm = (paddingTop + height) - this.dJj;
    }

    private void aTi() {
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
        if (i2 != this.dIV && i2 != this.dIS && i2 != this.dIT) {
            g2 = -2;
        } else {
            g2 = g(i2, view, z);
        }
        if (g2 != layoutParams.height) {
            layoutParams.height = g2;
            view.setLayoutParams(layoutParams);
        }
        if (i2 == this.dIS || i2 == this.dIT) {
            if (i2 < this.dIV) {
                ((DragSortItemView) view).setGravity(80);
            } else if (i2 > this.dIV) {
                ((DragSortItemView) view).setGravity(48);
            }
        }
        int visibility = view.getVisibility();
        int i3 = 0;
        if (i2 == this.dIV && this.dIK != null) {
            i3 = 4;
        }
        if (i3 != visibility) {
            view.setVisibility(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int mX(int i2) {
        View view;
        if (i2 == this.dIV) {
            return 0;
        }
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        if (childAt != null) {
            return f(i2, childAt, false);
        }
        int i3 = this.dJC.get(i2);
        if (i3 == -1) {
            ListAdapter adapter = this.mListView.getAdapter();
            int itemViewType = adapter.getItemViewType(i2);
            int viewTypeCount = adapter.getViewTypeCount();
            if (viewTypeCount != this.dJd.length) {
                this.dJd = new View[viewTypeCount];
            }
            if (itemViewType >= 0) {
                if (this.dJd[itemViewType] == null) {
                    view = adapter.getView(i2, null, this.mListView);
                    this.dJd[itemViewType] = view;
                } else {
                    view = adapter.getView(i2, this.dJd[itemViewType], this.mListView);
                }
            } else {
                view = adapter.getView(i2, null, this.mListView);
            }
            int f2 = f(i2, view, true);
            this.dJC.aO(i2, f2);
            return f2;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(int i2, View view, boolean z) {
        if (i2 == this.dIV) {
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
        boolean z = this.dIU && this.dIS != this.dIT;
        int i4 = this.bKX - this.dJb;
        int i5 = (int) (this.dJx * i4);
        if (i2 == this.dIV) {
            if (this.dIV == this.dIS) {
                if (z) {
                    return i5 + this.dJb;
                }
                return this.bKX;
            } else if (this.dIV == this.dIT) {
                return this.bKX - i5;
            } else {
                return this.dJb;
            }
        } else if (i2 == this.dIS) {
            if (z) {
                return i3 + i5;
            }
            return i3 + i4;
        } else if (i2 == this.dIT) {
            return (i3 + i4) - i5;
        } else {
            return i3;
        }
    }

    private int b(int i2, View view, int i3, int i4) {
        int i5;
        int i6;
        int mX = mX(i2);
        int height = view.getHeight();
        int aN = aN(i2, mX);
        if (i2 != this.dIV) {
            i6 = height - mX;
            i5 = aN - mX;
        } else {
            i5 = aN;
            i6 = height;
        }
        int i7 = this.bKX;
        if (this.dIV != this.dIS && this.dIV != this.dIT) {
            i7 -= this.dJb;
        }
        if (i2 <= i3) {
            if (i2 > this.dIS) {
                return (i7 - i5) + 0;
            }
        } else if (i2 == i4) {
            if (i2 <= this.dIS) {
                return (i6 - i7) + 0;
            }
            if (i2 == this.dIT) {
                return (height - aN) + 0;
            }
            return 0 + i6;
        } else if (i2 <= this.dIS) {
            return 0 - i7;
        } else {
            if (i2 == this.dIT) {
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

    private void aTj() {
        if (this.dIK != null) {
            measureItem(this.dIK);
            this.bKX = this.dIK.getMeasuredHeight();
            this.dJc = this.bKX / 2;
        }
    }

    protected boolean onDragTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        switch (motionEvent.getAction() & 255) {
            case 1:
                if (this.mDragState == 4) {
                    stopDrag(false);
                }
                aTg();
                return true;
            case 2:
                aM((int) motionEvent.getX(), (int) motionEvent.getY());
                return true;
            case 3:
                if (this.mDragState == 4) {
                    cancelDrag();
                }
                aTg();
                return true;
            default:
                return true;
        }
    }

    public boolean startDrag(int i2, int i3, int i4, int i5) {
        View mZ;
        if (!this.dJs || this.dJt == null || (mZ = this.dJt.mZ(i2)) == null) {
            return false;
        }
        return startDrag(i2, mZ, i3, i4, i5);
    }

    public boolean startDrag(int i2, View view, int i3, int i4, int i5) {
        if (this.mDragState == 0 && this.dJs && this.dIK == null && view != null && this.mDragEnabled) {
            if (this.mListView.getParent() != null) {
                this.mListView.getParent().requestDisallowInterceptTouchEvent(true);
            }
            int headerViewsCount = this.mListView.getHeaderViewsCount() + i2;
            this.dIS = headerViewsCount;
            this.dIT = headerViewsCount;
            this.dIV = headerViewsCount;
            this.dIR = headerViewsCount;
            this.mDragState = 4;
            this.dJq = 0;
            this.dJq |= i3;
            this.dIK = view;
            aTj();
            this.dIW = i4;
            this.dIX = i5;
            this.dJp = this.mY;
            this.dIL.x = this.mX - this.dIW;
            this.dIL.y = this.mY - this.dIX;
            View childAt = this.mListView.getChildAt(this.dIV - this.mListView.getFirstVisiblePosition());
            if (childAt != null) {
                childAt.setVisibility(4);
            }
            if (this.dJz) {
                this.dJA.aTn();
            }
            switch (this.dJv) {
                case 1:
                    this.dJI.onTouchEvent(this.dJu);
                    break;
                case 2:
                    this.dJI.onInterceptTouchEvent(this.dJu);
                    break;
            }
            this.mListView.requestLayout();
            if (this.dJE != null) {
                this.dJE.start();
                return true;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hf(boolean z) {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition() + (this.mListView.getChildCount() / 2);
        View childAt = this.mListView.getChildAt(this.mListView.getChildCount() / 2);
        if (childAt != null) {
            h(firstVisiblePosition, childAt, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i2, View view, boolean z) {
        this.mBlockLayoutRequests = true;
        aTk();
        int i3 = this.dIS;
        int i4 = this.dIT;
        boolean aTb = aTb();
        if (aTb) {
            aTi();
            this.mListView.setSelectionFromTop(i2, (b(i2, view, i3, i4) + view.getTop()) - this.mListView.getPaddingTop());
            layoutChildren();
        }
        if (aTb || z) {
            this.mListView.invalidate();
        }
        this.mBlockLayoutRequests = false;
    }

    private void aTk() {
        if (this.dJt != null) {
            this.dIM.set(this.mX, this.mY);
            this.dJt.b(this.dIK, this.dIL, this.dIM);
        }
        int i2 = this.dIL.x;
        int i3 = this.dIL.y;
        int paddingLeft = this.mListView.getPaddingLeft();
        if ((this.dJq & 1) == 0 && i2 > paddingLeft) {
            this.dIL.x = paddingLeft;
        } else if ((this.dJq & 2) == 0 && i2 < paddingLeft) {
            this.dIL.x = paddingLeft;
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int lastVisiblePosition = this.mListView.getLastVisiblePosition();
        int paddingTop = this.mListView.getPaddingTop();
        if (firstVisiblePosition < headerViewsCount) {
            paddingTop = this.mListView.getChildAt((headerViewsCount - firstVisiblePosition) - 1).getBottom();
        }
        if ((this.dJq & 8) == 0 && firstVisiblePosition <= this.dIV) {
            paddingTop = Math.max(this.mListView.getChildAt(this.dIV - firstVisiblePosition).getTop(), paddingTop);
        }
        int height = this.mListView.getHeight() - this.mListView.getPaddingBottom();
        if (lastVisiblePosition >= (this.mListView.getCount() - footerViewsCount) - 1) {
            height = this.mListView.getChildAt(((this.mListView.getCount() - footerViewsCount) - 1) - firstVisiblePosition).getBottom();
        }
        if ((this.dJq & 4) == 0 && lastVisiblePosition >= this.dIV) {
            height = Math.min(this.mListView.getChildAt(this.dIV - firstVisiblePosition).getBottom(), height);
        }
        if (i3 < paddingTop) {
            this.dIL.y = paddingTop;
        } else if (this.bKX + i3 > height) {
            this.dIL.y = height - this.bKX;
        }
        this.dIN = this.dIL.y + this.dJc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTl() {
        if (this.dIK != null) {
            this.dIK.setVisibility(8);
            if (this.dJt != null) {
                this.dJt.bj(this.dIK);
            }
            this.dIK = null;
            this.mListView.invalidate();
        }
    }

    public void a(h hVar) {
        this.dJt = hVar;
    }

    public void a(b bVar) {
        this.dIY = bVar;
    }

    public void setDragEnabled(boolean z) {
        this.mDragEnabled = z;
    }

    public boolean isDragEnabled() {
        return this.mDragEnabled;
    }

    public void a(g gVar) {
        this.dIZ = gVar;
    }

    public void a(l lVar) {
        this.dJa = lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class i {
        private SparseIntArray dKe;
        private ArrayList<Integer> dKf;
        private int mMaxSize;

        public i(int i) {
            this.dKe = new SparseIntArray(i);
            this.dKf = new ArrayList<>(i);
            this.mMaxSize = i;
        }

        public void aO(int i, int i2) {
            int i3 = this.dKe.get(i, -1);
            if (i3 != i2) {
                if (i3 == -1) {
                    if (this.dKe.size() == this.mMaxSize) {
                        this.dKe.delete(this.dKf.remove(0).intValue());
                    }
                } else {
                    this.dKf.remove(Integer.valueOf(i));
                }
                this.dKe.put(i, i2);
                this.dKf.add(Integer.valueOf(i));
            }
        }

        public int get(int i) {
            return this.dKe.get(i, -1);
        }

        public void clear() {
            this.dKe.clear();
            this.dKf.clear();
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
        private float bhh;
        private float bhi;
        private float bhj;
        private float bhk;
        private float dKp;
        private float mAlpha;
        private boolean mCanceled;
        protected long mStartTime;

        public m(float f, int i) {
            this.mAlpha = f;
            this.dKp = i;
            float f2 = 1.0f / ((this.mAlpha * 2.0f) * (1.0f - this.mAlpha));
            this.bhk = f2;
            this.bhh = f2;
            this.bhi = this.mAlpha / ((this.mAlpha - 1.0f) * 2.0f);
            this.bhj = 1.0f / (1.0f - this.mAlpha);
        }

        public float ar(float f) {
            if (f < this.mAlpha) {
                return this.bhh * f * f;
            }
            if (f < 1.0f - this.mAlpha) {
                return this.bhi + (this.bhj * f);
            }
            return 1.0f - ((this.bhk * (f - 1.0f)) * (f - 1.0f));
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
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / this.dKp;
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
        private int dKa;
        private int dKb;
        private float dKc;
        private float dKd;

        public f(float f, int i) {
            super(f, i);
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.dKa = a.this.dIR;
            this.dKb = a.this.dIV;
            a.this.mDragState = 2;
            this.dKc = a.this.dIL.y - aTp();
            this.dKd = a.this.dIL.x - a.this.mListView.getPaddingLeft();
        }

        private int aTp() {
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            int dividerHeight = (a.this.dJb + a.this.mListView.getDividerHeight()) / 2;
            View childAt = a.this.mListView.getChildAt(this.dKa - firstVisiblePosition);
            if (childAt != null) {
                if (this.dKa == this.dKb) {
                    return childAt.getTop();
                }
                if (this.dKa >= this.dKb) {
                    return (childAt.getBottom() + dividerHeight) - a.this.bKX;
                }
                return childAt.getTop() - dividerHeight;
            }
            cancel();
            return -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void t(float f, float f2) {
            int aTp = aTp();
            float paddingLeft = a.this.dIL.x - a.this.mListView.getPaddingLeft();
            float f3 = 1.0f - f2;
            if (f3 < Math.abs((a.this.dIL.y - aTp) / this.dKc) || f3 < Math.abs(paddingLeft / this.dKd)) {
                a.this.dIL.y = aTp + ((int) (this.dKc * f3));
                a.this.dIL.x = a.this.mListView.getPaddingLeft() + ((int) (this.dKd * f3));
                a.this.hf(true);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.aTd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class k extends m {
        private int dKb;
        private float dKi;
        private float dKj;
        private float dKk;
        private int dKl;
        private int dKm;
        private int dKn;
        private int dKo;

        public k(float f, int i) {
            super(f, i);
            this.dKl = -1;
            this.dKm = -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.dKl = -1;
            this.dKm = -1;
            this.dKn = a.this.dIS;
            this.dKo = a.this.dIT;
            this.dKb = a.this.dIV;
            a.this.mDragState = 1;
            this.dKi = a.this.dIL.x;
            if (a.this.dJG) {
                float width = a.this.mListView.getWidth() * 2.0f;
                if (a.this.dJH == 0.0f) {
                    a.this.dJH = (this.dKi >= 0.0f ? 1 : -1) * width;
                    return;
                }
                float f = width * 2.0f;
                if (a.this.dJH >= 0.0f || a.this.dJH <= (-f)) {
                    if (a.this.dJH > 0.0f && a.this.dJH < f) {
                        a.this.dJH = f;
                        return;
                    }
                    return;
                }
                a.this.dJH = -f;
                return;
            }
            a.this.aTl();
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void t(float f, float f2) {
            View childAt;
            float f3 = 1.0f - f2;
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            View childAt2 = a.this.mListView.getChildAt(this.dKn - firstVisiblePosition);
            if (a.this.dJG) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / 1000.0f;
                if (uptimeMillis != 0.0f) {
                    float f4 = a.this.dJH * uptimeMillis;
                    int width = a.this.mListView.getWidth();
                    a.this.dJH = ((a.this.dJH > 0.0f ? 1 : -1) * uptimeMillis * width) + a.this.dJH;
                    this.dKi += f4;
                    a.this.dIL.x = (int) this.dKi;
                    if (this.dKi < width && this.dKi > (-width)) {
                        this.mStartTime = SystemClock.uptimeMillis();
                        a.this.hf(true);
                        return;
                    }
                } else {
                    return;
                }
            }
            if (childAt2 != null) {
                if (this.dKl == -1) {
                    this.dKl = a.this.f(this.dKn, childAt2, false);
                    this.dKj = childAt2.getHeight() - this.dKl;
                }
                int max = Math.max((int) (this.dKj * f3), 1);
                ViewGroup.LayoutParams layoutParams = childAt2.getLayoutParams();
                layoutParams.height = max + this.dKl;
                childAt2.setLayoutParams(layoutParams);
            }
            if (this.dKo != this.dKn && (childAt = a.this.mListView.getChildAt(this.dKo - firstVisiblePosition)) != null) {
                if (this.dKm == -1) {
                    this.dKm = a.this.f(this.dKo, childAt, false);
                    this.dKk = childAt.getHeight() - this.dKm;
                }
                int max2 = Math.max((int) (this.dKk * f3), 1);
                ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
                layoutParams2.height = max2 + this.dKm;
                childAt.setLayoutParams(layoutParams2);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.aTe();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class j extends m {
        final /* synthetic */ a dJM;
        private float dKg;
        private float dKh;

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.dKg = this.dJM.dIX;
            this.dKh = this.dJM.dJc;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void t(float f, float f2) {
            if (this.dJM.mDragState != 4) {
                cancel();
                return;
            }
            this.dJM.dIX = (int) ((this.dKh * f2) + ((1.0f - f2) * this.dKg));
            this.dJM.dIL.y = this.dJM.mY - this.dJM.dIX;
            this.dJM.hf(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e {
        StringBuilder mBuilder = new StringBuilder();
        private int dJX = 0;
        private int dJY = 0;
        private boolean dJZ = false;
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

        public void aTn() {
            this.mBuilder.append("<DSLVStates>\n");
            this.dJY = 0;
            this.dJZ = true;
        }

        public void aTo() {
            if (this.dJZ) {
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
                this.mBuilder.append("    <FirstExpPos>").append(a.this.dIS).append("</FirstExpPos>\n");
                this.mBuilder.append("    <FirstExpBlankHeight>").append(a.this.mV(a.this.dIS) - a.this.mX(a.this.dIS)).append("</FirstExpBlankHeight>\n");
                this.mBuilder.append("    <SecondExpPos>").append(a.this.dIT).append("</SecondExpPos>\n");
                this.mBuilder.append("    <SecondExpBlankHeight>").append(a.this.mV(a.this.dIT) - a.this.mX(a.this.dIT)).append("</SecondExpBlankHeight>\n");
                this.mBuilder.append("    <SrcPos>").append(a.this.dIV).append("</SrcPos>\n");
                this.mBuilder.append("    <SrcHeight>").append(a.this.bKX + a.this.mListView.getDividerHeight()).append("</SrcHeight>\n");
                this.mBuilder.append("    <ViewHeight>").append(a.this.mListView.getHeight()).append("</ViewHeight>\n");
                this.mBuilder.append("    <LastY>").append(a.this.mLastY).append("</LastY>\n");
                this.mBuilder.append("    <FloatY>").append(a.this.dIN).append("</FloatY>\n");
                this.mBuilder.append("    <ShuffleEdges>");
                for (int i4 = 0; i4 < childCount; i4++) {
                    this.mBuilder.append(a.this.aL(firstVisiblePosition + i4, a.this.mListView.getChildAt(i4).getTop())).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                this.mBuilder.append("</ShuffleEdges>\n");
                this.mBuilder.append("</DSLVState>\n");
                this.dJX++;
                if (this.dJX > 1000) {
                    flush();
                    this.dJX = 0;
                }
            }
        }

        public void flush() {
            if (this.dJZ) {
                try {
                    FileWriter fileWriter = new FileWriter(this.mFile, this.dJY != 0);
                    fileWriter.write(this.mBuilder.toString());
                    this.mBuilder.delete(0, this.mBuilder.length());
                    fileWriter.flush();
                    fileWriter.close();
                    this.dJY++;
                } catch (IOException e) {
                }
            }
        }

        public void stopTracking() {
            if (this.dJZ) {
                this.mBuilder.append("</DSLVStates>\n");
                flush();
                this.dJZ = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements Runnable {
        private boolean dJP;
        private long dJQ;
        private long dJR;
        private int dJS;
        private float dJT;
        private long dJU;
        private int dJV;
        private float dJW;
        private boolean mScrolling = false;

        public boolean isScrolling() {
            return this.mScrolling;
        }

        public int aTm() {
            if (this.mScrolling) {
                return this.dJV;
            }
            return -1;
        }

        public d() {
        }

        public void mY(int i) {
            if (!this.mScrolling) {
                this.dJP = false;
                this.mScrolling = true;
                this.dJU = SystemClock.uptimeMillis();
                this.dJQ = this.dJU;
                this.dJV = i;
                a.this.mListView.post(this);
            }
        }

        public void hg(boolean z) {
            if (z) {
                a.this.mListView.removeCallbacks(this);
                this.mScrolling = false;
                return;
            }
            this.dJP = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.dJP) {
                int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
                int lastVisiblePosition = a.this.mListView.getLastVisiblePosition();
                int count = a.this.mListView.getCount();
                int paddingTop = a.this.mListView.getPaddingTop();
                int height = (a.this.mListView.getHeight() - paddingTop) - a.this.mListView.getPaddingBottom();
                int min = Math.min(a.this.mY, a.this.dIN + a.this.dJc);
                int max = Math.max(a.this.mY, a.this.dIN - a.this.dJc);
                if (this.dJV == 0) {
                    View childAt = a.this.mListView.getChildAt(0);
                    if (childAt == null) {
                        this.mScrolling = false;
                        return;
                    } else if (firstVisiblePosition == 0 && childAt.getTop() == paddingTop) {
                        this.mScrolling = false;
                        return;
                    } else {
                        this.dJW = a.this.dJo.b((a.this.dJk - max) / a.this.dJl, this.dJQ);
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
                        this.dJW = -a.this.dJo.b((min - a.this.dJj) / a.this.dJm, this.dJQ);
                    }
                }
                this.dJR = SystemClock.uptimeMillis();
                this.dJT = (float) (this.dJR - this.dJQ);
                this.dJS = Math.round(this.dJW * this.dJT);
                if (this.dJS >= 0) {
                    this.dJS = Math.min(height, this.dJS);
                    lastVisiblePosition = firstVisiblePosition;
                } else {
                    this.dJS = Math.max(-height, this.dJS);
                }
                View childAt3 = a.this.mListView.getChildAt(lastVisiblePosition - firstVisiblePosition);
                int top2 = childAt3.getTop() + this.dJS;
                if (lastVisiblePosition == 0 && top2 > paddingTop) {
                    top2 = paddingTop;
                }
                a.this.mBlockLayoutRequests = true;
                a.this.mListView.setSelectionFromTop(lastVisiblePosition, top2 - paddingTop);
                a.this.layoutChildren();
                a.this.mListView.invalidate();
                a.this.mBlockLayoutRequests = false;
                a.this.h(lastVisiblePosition, childAt3, false);
                this.dJQ = this.dJR;
                a.this.mListView.post(this);
                return;
            }
            this.mScrolling = false;
        }
    }
}
