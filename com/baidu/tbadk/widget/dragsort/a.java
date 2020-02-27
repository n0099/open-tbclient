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
    private int bKV;
    private int dID;
    private int dIE;
    private int dIF;
    private int dIH;
    private int dII;
    private int dIJ;
    private b dIK;
    private g dIL;
    private l dIM;
    private int dIO;
    private d dIQ;
    private int dIT;
    private int dIU;
    private float dIV;
    private float dIW;
    private float dIX;
    private float dIY;
    private View dIw;
    private int dIz;
    private int dJb;
    private MotionEvent dJg;
    private C0397a dJk;
    private e dJm;
    private k dJp;
    private j dJq;
    private f dJr;
    private boolean dJs;
    private com.baidu.tbadk.widget.dragsort.d dJu;
    private com.baidu.tbadk.widget.dragsort.b dJv;
    private int mLastX;
    private int mLastY;
    private ListView mListView;
    private DataSetObserver mObserver;
    private int mOffsetX;
    private int mOffsetY;
    private int mX;
    private int mY;
    private Point dIx = new Point();
    private Point dIy = new Point();
    private boolean dIA = false;
    private float dIB = 1.0f;
    private float dIC = 1.0f;
    private boolean dIG = false;
    private boolean mDragEnabled = true;
    private int mDragState = 0;
    private int dIN = 1;
    private int mWidthMeasureSpec = 0;
    private View[] dIP = new View[1];
    private float dIR = 0.33333334f;
    private float dIS = 0.33333334f;
    private float dIZ = 0.5f;
    private c dJa = new c() { // from class: com.baidu.tbadk.widget.dragsort.a.1
        @Override // com.baidu.tbadk.widget.dragsort.a.c
        public float b(float f2, long j2) {
            return a.this.dIZ * f2;
        }
    };
    private int dJc = 0;
    private boolean dJd = false;
    private boolean dJe = false;
    private h dJf = null;
    private int dJh = 0;
    private float dJi = 0.25f;
    private float dJj = 0.0f;
    private boolean dJl = false;
    private boolean mBlockLayoutRequests = false;
    private boolean dJn = false;
    private i dJo = new i(3);
    private float dJt = 0.0f;
    private boolean dJw = false;
    private boolean dJx = false;

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
        this.dJu = dVar;
        this.mListView = listView;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            this.dJk = new C0397a(listAdapter);
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
            this.dJk = null;
        }
        this.dJu.setAdapter(this.dJk);
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
            if (i2 > this.dIH) {
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
        int i4 = this.bKV - this.dIN;
        int mX = mX(i2);
        int mV = mV(i2);
        if (this.dIF <= this.dIH) {
            if (i2 == this.dIF && this.dIE != this.dIF) {
                if (i2 == this.dIH) {
                    i3 = (i3 + mV) - this.bKV;
                } else {
                    i3 = ((mV - mX) + i3) - i4;
                }
            } else if (i2 > this.dIF && i2 <= this.dIH) {
                i3 -= i4;
            }
        } else if (i2 > this.dIH && i2 <= this.dIE) {
            i3 += i4;
        } else if (i2 == this.dIF && this.dIE != this.dIF) {
            i3 += mV - mX;
        }
        if (i2 <= this.dIH) {
            return (((this.bKV - dividerHeight) - mX(i2 - 1)) / 2) + i3;
        }
        return (((mX - dividerHeight) - this.bKV) / 2) + i3;
    }

    private boolean aSY() {
        int i2;
        int i3;
        int i4;
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int i5 = this.dIE;
        View childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        if (childAt == null) {
            i5 = firstVisiblePosition + (this.mListView.getChildCount() / 2);
            childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        }
        int top2 = childAt.getTop();
        int height = childAt.getHeight();
        int aL = aL(i5, top2);
        int dividerHeight = this.mListView.getDividerHeight();
        if (this.dIz >= aL) {
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
                    if (this.dIz < i2) {
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
                if (this.dIz >= i2) {
                    break;
                }
                i4 = i2;
            }
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int i9 = this.dIE;
        int i10 = this.dIF;
        float f2 = this.dJj;
        if (this.dIG) {
            int abs = Math.abs(i2 - i4);
            if (this.dIz >= i2) {
                int i11 = i4;
                i4 = i2;
                i2 = i11;
            }
            int i12 = (int) (abs * this.dJi * 0.5f);
            float f3 = i12;
            int i13 = i4 + i12;
            int i14 = i2 - i12;
            if (this.dIz < i13) {
                this.dIE = i3 - 1;
                this.dIF = i3;
                this.dJj = ((i13 - this.dIz) * 0.5f) / f3;
            } else if (this.dIz < i14) {
                this.dIE = i3;
                this.dIF = i3;
            } else {
                this.dIE = i3;
                this.dIF = i3 + 1;
                this.dJj = (1.0f + ((i2 - this.dIz) / f3)) * 0.5f;
            }
        } else {
            this.dIE = i3;
            this.dIF = i3;
        }
        if (this.dIE < headerViewsCount) {
            this.dIE = headerViewsCount;
            this.dIF = headerViewsCount;
            i3 = headerViewsCount;
        } else if (this.dIF >= this.mListView.getCount() - footerViewsCount) {
            i3 = (this.mListView.getCount() - footerViewsCount) - 1;
            this.dIE = i3;
            this.dIF = i3;
        }
        boolean z = (this.dIE == i9 && this.dIF == i10 && this.dJj == f2) ? false : true;
        if (i3 != this.dID) {
            if (this.dIK != null) {
                this.dIK.drag(this.dID - headerViewsCount, i3 - headerViewsCount);
            }
            this.dID = i3;
            return true;
        }
        return z;
    }

    public void removeItem(int i2) {
        this.dJs = false;
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
            this.dIN = Math.max(1, obtainStyledAttributes.getDimensionPixelSize(12, 1));
            this.dJl = obtainStyledAttributes.getBoolean(6, false);
            if (this.dJl) {
                this.dJm = new e();
            }
            this.dIB = obtainStyledAttributes.getFloat(10, this.dIB);
            this.dIC = this.dIB;
            this.mDragEnabled = obtainStyledAttributes.getBoolean(13, this.mDragEnabled);
            this.dJi = Math.max(0.0f, Math.min(1.0f, 1.0f - obtainStyledAttributes.getFloat(2, 0.75f)));
            this.dIG = this.dJi > 0.0f;
            setDragScrollStart(obtainStyledAttributes.getFloat(14, this.dIR));
            this.dIZ = obtainStyledAttributes.getFloat(0, this.dIZ);
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
                this.dJf = bVar;
                a(bVar);
            }
            obtainStyledAttributes.recycle();
            i2 = i5;
            i3 = i4;
        }
        this.dIQ = new d();
        if (i3 > 0) {
            this.dJp = new k(0.5f, i3);
        }
        if (i2 > 0) {
            this.dJr = new f(0.5f, i2);
        }
        this.dJg = MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
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
        this.dJv = bVar;
        this.mListView.setOnTouchListener(bVar);
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void dispatchDraw(Canvas canvas) {
        float f2;
        this.dJu.dispatchDraw(canvas);
        if (this.mDragState != 0) {
            if (this.dIE != this.dIH) {
                b(this.dIE, canvas);
            }
            if (this.dIF != this.dIE && this.dIF != this.dIH) {
                b(this.dIF, canvas);
            }
        }
        if (this.dIw != null) {
            int width = this.dIw.getWidth();
            int height = this.dIw.getHeight();
            int i2 = this.dIx.x;
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
            int i3 = (int) (f2 * 255.0f * this.dIC);
            canvas.save();
            canvas.translate(this.dIx.x, this.dIx.y);
            canvas.clipRect(0, 0, width, height);
            canvas.saveLayerAlpha(0.0f, 0.0f, width, height, i3, 31);
            this.dIw.draw(canvas);
            canvas.restore();
            canvas.restore();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onDraw(Canvas canvas) {
        this.dJu.onDraw(canvas);
        if (this.dJl) {
            this.dJm.aTl();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.dJn) {
            this.dJn = false;
            return false;
        } else if (!this.mDragEnabled) {
            return this.dJu.onTouchEvent(motionEvent);
        } else {
            boolean z2 = this.dJd;
            this.dJd = false;
            if (!z2) {
                s(motionEvent);
            }
            if (this.mDragState == 4) {
                onDragTouchEvent(motionEvent);
                return true;
            }
            if (this.mDragState == 0 && this.dJu.onTouchEvent(motionEvent)) {
                z = true;
            }
            switch (motionEvent.getAction() & 255) {
                case 1:
                case 3:
                    aTd();
                    return z;
                case 2:
                default:
                    if (z) {
                        this.dJh = 1;
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
            return this.dJu.onInterceptTouchEvent(motionEvent);
        }
        if (this.dJv != null) {
            this.dJv.aTn().onTouchEvent(motionEvent);
        }
        s(motionEvent);
        this.dJd = true;
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            if (this.mDragState != 0) {
                this.dJn = true;
                return true;
            }
            this.dJe = true;
        }
        if (this.dIw == null) {
            if (this.dJu.onInterceptTouchEvent(motionEvent)) {
                this.dJw = true;
                z = true;
            } else {
                z = false;
            }
            switch (action) {
                case 1:
                case 3:
                    aTd();
                    break;
                case 2:
                default:
                    if (z) {
                        this.dJh = 1;
                        break;
                    } else {
                        this.dJh = 2;
                        break;
                    }
            }
        } else {
            z = true;
        }
        if (action == 1 || action == 3) {
            this.dJe = false;
        }
        return z;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        this.dJu.onSizeChanged(i2, i3, i4, i5);
        aTe();
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void requestLayout() {
        if (!this.mBlockLayoutRequests) {
            this.dJu.requestLayout();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onMeasure(int i2, int i3) {
        this.dJu.onMeasure(i2, i3);
        if (this.dIw != null) {
            if (this.dIw.isLayoutRequested()) {
                aTg();
            }
            this.dIA = true;
        }
        this.mWidthMeasureSpec = i2;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void layoutChildren() {
        this.dJu.layoutChildren();
        if (this.dIw != null) {
            if (this.dIw.isLayoutRequested() && !this.dIA) {
                aTg();
            }
            this.dIw.layout(0, 0, this.dIw.getMeasuredWidth(), this.dIw.getMeasuredHeight());
            this.dIA = false;
        }
    }

    public void removeItem(int i2, float f2) {
        if (this.mDragState == 0 || this.mDragState == 4) {
            if (this.mDragState == 0) {
                this.dIH = this.mListView.getHeaderViewsCount() + i2;
                this.dIE = this.dIH;
                this.dIF = this.dIH;
                this.dID = this.dIH;
                View childAt = this.mListView.getChildAt(this.dIH - this.mListView.getFirstVisiblePosition());
                if (childAt != null) {
                    childAt.setVisibility(4);
                }
            }
            this.mDragState = 1;
            this.dJt = f2;
            if (this.dJe) {
                switch (this.dJh) {
                    case 1:
                        this.dJu.onTouchEvent(this.dJg);
                        break;
                    case 2:
                        this.dJu.onInterceptTouchEvent(this.dJg);
                        break;
                }
            }
            if (this.dJp != null) {
                this.dJp.start();
            } else {
                mW(i2);
            }
        }
    }

    public void cancelDrag() {
        if (this.mDragState == 4) {
            this.dIQ.hg(true);
            aTi();
            aSZ();
            aTf();
            if (this.dJe) {
                this.mDragState = 3;
            } else {
                this.mDragState = 0;
            }
        }
    }

    private void aSZ() {
        this.dIH = -1;
        this.dIE = -1;
        this.dIF = -1;
        this.dID = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTa() {
        this.mDragState = 2;
        if (this.dIL != null && this.dID >= 0 && this.dID < this.mListView.getCount()) {
            int headerViewsCount = this.mListView.getHeaderViewsCount();
            this.dIL.drop(this.dIH - headerViewsCount, this.dID - headerViewsCount);
        }
        aTi();
        aTc();
        aSZ();
        aTf();
        if (this.dJe) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTb() {
        mW(this.dIH - this.mListView.getHeaderViewsCount());
    }

    private void mW(int i2) {
        this.mDragState = 1;
        if (this.dIM != null) {
            this.dIM.remove(i2);
        }
        aTi();
        aTc();
        aSZ();
        if (this.dJe) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    private void aTc() {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        if (this.dIH < firstVisiblePosition) {
            View childAt = this.mListView.getChildAt(0);
            this.mListView.setSelectionFromTop(firstVisiblePosition - 1, (childAt != null ? childAt.getTop() : 0) - this.mListView.getPaddingTop());
        }
    }

    public boolean stopDrag(boolean z) {
        this.dJs = false;
        return stopDrag(z, 0.0f);
    }

    public boolean stopDragWithVelocity(boolean z, float f2) {
        this.dJs = true;
        return stopDrag(z, f2);
    }

    public boolean stopDrag(boolean z, float f2) {
        if (this.dIw != null) {
            this.dIQ.hg(true);
            if (z) {
                removeItem(this.dIH - this.mListView.getHeaderViewsCount(), f2);
            } else if (this.dJr != null) {
                this.dJr.start();
            } else {
                aTa();
            }
            if (this.dJl) {
                this.dJm.stopTracking();
                return true;
            }
            return true;
        }
        return false;
    }

    private void aTd() {
        this.dJh = 0;
        this.dJe = false;
        if (this.mDragState == 3) {
            this.mDragState = 0;
        }
        this.dIC = this.dIB;
        this.dJw = false;
        this.dJo.clear();
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
        return this.dJw;
    }

    public void setDragScrollStart(float f2) {
        setDragScrollStarts(f2, f2);
    }

    public void setDragScrollStarts(float f2, float f3) {
        if (f3 > 0.5f) {
            this.dIS = 0.5f;
        } else {
            this.dIS = f3;
        }
        if (f2 > 0.5f) {
            this.dIR = 0.5f;
        } else {
            this.dIR = f2;
        }
        if (this.mListView.getHeight() != 0) {
            aTe();
        }
    }

    private void aM(int i2, int i3) {
        this.dIx.x = i2 - this.dII;
        this.dIx.y = i3 - this.dIJ;
        hf(true);
        int min = Math.min(i3, this.dIz + this.dIO);
        int max = Math.max(i3, this.dIz - this.dIO);
        int aTj = this.dIQ.aTj();
        if (min > this.mLastY && min > this.dIU && aTj != 1) {
            if (aTj != -1) {
                this.dIQ.hg(true);
            }
            this.dIQ.mY(1);
        } else if (max < this.mLastY && max < this.dIT && aTj != 0) {
            if (aTj != -1) {
                this.dIQ.hg(true);
            }
            this.dIQ.mY(0);
        } else if (max >= this.dIT && min <= this.dIU && this.dIQ.isScrolling()) {
            this.dIQ.hg(true);
        }
    }

    private void aTe() {
        int height;
        int paddingTop = this.mListView.getPaddingTop();
        float height2 = (this.mListView.getHeight() - paddingTop) - this.mListView.getPaddingBottom();
        this.dIW = paddingTop + (this.dIR * height2);
        this.dIV = (height2 * (1.0f - this.dIS)) + paddingTop;
        this.dIT = (int) this.dIW;
        this.dIU = (int) this.dIV;
        this.dIX = this.dIW - paddingTop;
        this.dIY = (paddingTop + height) - this.dIV;
    }

    private void aTf() {
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
        if (i2 != this.dIH && i2 != this.dIE && i2 != this.dIF) {
            g2 = -2;
        } else {
            g2 = g(i2, view, z);
        }
        if (g2 != layoutParams.height) {
            layoutParams.height = g2;
            view.setLayoutParams(layoutParams);
        }
        if (i2 == this.dIE || i2 == this.dIF) {
            if (i2 < this.dIH) {
                ((DragSortItemView) view).setGravity(80);
            } else if (i2 > this.dIH) {
                ((DragSortItemView) view).setGravity(48);
            }
        }
        int visibility = view.getVisibility();
        int i3 = 0;
        if (i2 == this.dIH && this.dIw != null) {
            i3 = 4;
        }
        if (i3 != visibility) {
            view.setVisibility(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int mX(int i2) {
        View view;
        if (i2 == this.dIH) {
            return 0;
        }
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        if (childAt != null) {
            return f(i2, childAt, false);
        }
        int i3 = this.dJo.get(i2);
        if (i3 == -1) {
            ListAdapter adapter = this.mListView.getAdapter();
            int itemViewType = adapter.getItemViewType(i2);
            int viewTypeCount = adapter.getViewTypeCount();
            if (viewTypeCount != this.dIP.length) {
                this.dIP = new View[viewTypeCount];
            }
            if (itemViewType >= 0) {
                if (this.dIP[itemViewType] == null) {
                    view = adapter.getView(i2, null, this.mListView);
                    this.dIP[itemViewType] = view;
                } else {
                    view = adapter.getView(i2, this.dIP[itemViewType], this.mListView);
                }
            } else {
                view = adapter.getView(i2, null, this.mListView);
            }
            int f2 = f(i2, view, true);
            this.dJo.aO(i2, f2);
            return f2;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(int i2, View view, boolean z) {
        if (i2 == this.dIH) {
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
        boolean z = this.dIG && this.dIE != this.dIF;
        int i4 = this.bKV - this.dIN;
        int i5 = (int) (this.dJj * i4);
        if (i2 == this.dIH) {
            if (this.dIH == this.dIE) {
                if (z) {
                    return i5 + this.dIN;
                }
                return this.bKV;
            } else if (this.dIH == this.dIF) {
                return this.bKV - i5;
            } else {
                return this.dIN;
            }
        } else if (i2 == this.dIE) {
            if (z) {
                return i3 + i5;
            }
            return i3 + i4;
        } else if (i2 == this.dIF) {
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
        if (i2 != this.dIH) {
            i6 = height - mX;
            i5 = aN - mX;
        } else {
            i5 = aN;
            i6 = height;
        }
        int i7 = this.bKV;
        if (this.dIH != this.dIE && this.dIH != this.dIF) {
            i7 -= this.dIN;
        }
        if (i2 <= i3) {
            if (i2 > this.dIE) {
                return (i7 - i5) + 0;
            }
        } else if (i2 == i4) {
            if (i2 <= this.dIE) {
                return (i6 - i7) + 0;
            }
            if (i2 == this.dIF) {
                return (height - aN) + 0;
            }
            return 0 + i6;
        } else if (i2 <= this.dIE) {
            return 0 - i7;
        } else {
            if (i2 == this.dIF) {
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

    private void aTg() {
        if (this.dIw != null) {
            measureItem(this.dIw);
            this.bKV = this.dIw.getMeasuredHeight();
            this.dIO = this.bKV / 2;
        }
    }

    protected boolean onDragTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        switch (motionEvent.getAction() & 255) {
            case 1:
                if (this.mDragState == 4) {
                    stopDrag(false);
                }
                aTd();
                return true;
            case 2:
                aM((int) motionEvent.getX(), (int) motionEvent.getY());
                return true;
            case 3:
                if (this.mDragState == 4) {
                    cancelDrag();
                }
                aTd();
                return true;
            default:
                return true;
        }
    }

    public boolean startDrag(int i2, int i3, int i4, int i5) {
        View mZ;
        if (!this.dJe || this.dJf == null || (mZ = this.dJf.mZ(i2)) == null) {
            return false;
        }
        return startDrag(i2, mZ, i3, i4, i5);
    }

    public boolean startDrag(int i2, View view, int i3, int i4, int i5) {
        if (this.mDragState == 0 && this.dJe && this.dIw == null && view != null && this.mDragEnabled) {
            if (this.mListView.getParent() != null) {
                this.mListView.getParent().requestDisallowInterceptTouchEvent(true);
            }
            int headerViewsCount = this.mListView.getHeaderViewsCount() + i2;
            this.dIE = headerViewsCount;
            this.dIF = headerViewsCount;
            this.dIH = headerViewsCount;
            this.dID = headerViewsCount;
            this.mDragState = 4;
            this.dJc = 0;
            this.dJc |= i3;
            this.dIw = view;
            aTg();
            this.dII = i4;
            this.dIJ = i5;
            this.dJb = this.mY;
            this.dIx.x = this.mX - this.dII;
            this.dIx.y = this.mY - this.dIJ;
            View childAt = this.mListView.getChildAt(this.dIH - this.mListView.getFirstVisiblePosition());
            if (childAt != null) {
                childAt.setVisibility(4);
            }
            if (this.dJl) {
                this.dJm.aTk();
            }
            switch (this.dJh) {
                case 1:
                    this.dJu.onTouchEvent(this.dJg);
                    break;
                case 2:
                    this.dJu.onInterceptTouchEvent(this.dJg);
                    break;
            }
            this.mListView.requestLayout();
            if (this.dJq != null) {
                this.dJq.start();
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
        aTh();
        int i3 = this.dIE;
        int i4 = this.dIF;
        boolean aSY = aSY();
        if (aSY) {
            aTf();
            this.mListView.setSelectionFromTop(i2, (b(i2, view, i3, i4) + view.getTop()) - this.mListView.getPaddingTop());
            layoutChildren();
        }
        if (aSY || z) {
            this.mListView.invalidate();
        }
        this.mBlockLayoutRequests = false;
    }

    private void aTh() {
        if (this.dJf != null) {
            this.dIy.set(this.mX, this.mY);
            this.dJf.b(this.dIw, this.dIx, this.dIy);
        }
        int i2 = this.dIx.x;
        int i3 = this.dIx.y;
        int paddingLeft = this.mListView.getPaddingLeft();
        if ((this.dJc & 1) == 0 && i2 > paddingLeft) {
            this.dIx.x = paddingLeft;
        } else if ((this.dJc & 2) == 0 && i2 < paddingLeft) {
            this.dIx.x = paddingLeft;
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int lastVisiblePosition = this.mListView.getLastVisiblePosition();
        int paddingTop = this.mListView.getPaddingTop();
        if (firstVisiblePosition < headerViewsCount) {
            paddingTop = this.mListView.getChildAt((headerViewsCount - firstVisiblePosition) - 1).getBottom();
        }
        if ((this.dJc & 8) == 0 && firstVisiblePosition <= this.dIH) {
            paddingTop = Math.max(this.mListView.getChildAt(this.dIH - firstVisiblePosition).getTop(), paddingTop);
        }
        int height = this.mListView.getHeight() - this.mListView.getPaddingBottom();
        if (lastVisiblePosition >= (this.mListView.getCount() - footerViewsCount) - 1) {
            height = this.mListView.getChildAt(((this.mListView.getCount() - footerViewsCount) - 1) - firstVisiblePosition).getBottom();
        }
        if ((this.dJc & 4) == 0 && lastVisiblePosition >= this.dIH) {
            height = Math.min(this.mListView.getChildAt(this.dIH - firstVisiblePosition).getBottom(), height);
        }
        if (i3 < paddingTop) {
            this.dIx.y = paddingTop;
        } else if (this.bKV + i3 > height) {
            this.dIx.y = height - this.bKV;
        }
        this.dIz = this.dIx.y + this.dIO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTi() {
        if (this.dIw != null) {
            this.dIw.setVisibility(8);
            if (this.dJf != null) {
                this.dJf.bj(this.dIw);
            }
            this.dIw = null;
            this.mListView.invalidate();
        }
    }

    public void a(h hVar) {
        this.dJf = hVar;
    }

    public void a(b bVar) {
        this.dIK = bVar;
    }

    public void setDragEnabled(boolean z) {
        this.mDragEnabled = z;
    }

    public boolean isDragEnabled() {
        return this.mDragEnabled;
    }

    public void a(g gVar) {
        this.dIL = gVar;
    }

    public void a(l lVar) {
        this.dIM = lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class i {
        private SparseIntArray dJQ;
        private ArrayList<Integer> dJR;
        private int mMaxSize;

        public i(int i) {
            this.dJQ = new SparseIntArray(i);
            this.dJR = new ArrayList<>(i);
            this.mMaxSize = i;
        }

        public void aO(int i, int i2) {
            int i3 = this.dJQ.get(i, -1);
            if (i3 != i2) {
                if (i3 == -1) {
                    if (this.dJQ.size() == this.mMaxSize) {
                        this.dJQ.delete(this.dJR.remove(0).intValue());
                    }
                } else {
                    this.dJR.remove(Integer.valueOf(i));
                }
                this.dJQ.put(i, i2);
                this.dJR.add(Integer.valueOf(i));
            }
        }

        public int get(int i) {
            return this.dJQ.get(i, -1);
        }

        public void clear() {
            this.dJQ.clear();
            this.dJR.clear();
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
        private float bhf;
        private float bhg;
        private float bhh;
        private float bhi;
        private float dKb;
        private float mAlpha;
        private boolean mCanceled;
        protected long mStartTime;

        public m(float f, int i) {
            this.mAlpha = f;
            this.dKb = i;
            float f2 = 1.0f / ((this.mAlpha * 2.0f) * (1.0f - this.mAlpha));
            this.bhi = f2;
            this.bhf = f2;
            this.bhg = this.mAlpha / ((this.mAlpha - 1.0f) * 2.0f);
            this.bhh = 1.0f / (1.0f - this.mAlpha);
        }

        public float ar(float f) {
            if (f < this.mAlpha) {
                return this.bhf * f * f;
            }
            if (f < 1.0f - this.mAlpha) {
                return this.bhg + (this.bhh * f);
            }
            return 1.0f - ((this.bhi * (f - 1.0f)) * (f - 1.0f));
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
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / this.dKb;
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
        private int dJM;
        private int dJN;
        private float dJO;
        private float dJP;

        public f(float f, int i) {
            super(f, i);
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.dJM = a.this.dID;
            this.dJN = a.this.dIH;
            a.this.mDragState = 2;
            this.dJO = a.this.dIx.y - aTm();
            this.dJP = a.this.dIx.x - a.this.mListView.getPaddingLeft();
        }

        private int aTm() {
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            int dividerHeight = (a.this.dIN + a.this.mListView.getDividerHeight()) / 2;
            View childAt = a.this.mListView.getChildAt(this.dJM - firstVisiblePosition);
            if (childAt != null) {
                if (this.dJM == this.dJN) {
                    return childAt.getTop();
                }
                if (this.dJM >= this.dJN) {
                    return (childAt.getBottom() + dividerHeight) - a.this.bKV;
                }
                return childAt.getTop() - dividerHeight;
            }
            cancel();
            return -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void t(float f, float f2) {
            int aTm = aTm();
            float paddingLeft = a.this.dIx.x - a.this.mListView.getPaddingLeft();
            float f3 = 1.0f - f2;
            if (f3 < Math.abs((a.this.dIx.y - aTm) / this.dJO) || f3 < Math.abs(paddingLeft / this.dJP)) {
                a.this.dIx.y = aTm + ((int) (this.dJO * f3));
                a.this.dIx.x = a.this.mListView.getPaddingLeft() + ((int) (this.dJP * f3));
                a.this.hf(true);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.aTa();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class k extends m {
        private int dJN;
        private float dJU;
        private float dJV;
        private float dJW;
        private int dJX;
        private int dJY;
        private int dJZ;
        private int dKa;

        public k(float f, int i) {
            super(f, i);
            this.dJX = -1;
            this.dJY = -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.dJX = -1;
            this.dJY = -1;
            this.dJZ = a.this.dIE;
            this.dKa = a.this.dIF;
            this.dJN = a.this.dIH;
            a.this.mDragState = 1;
            this.dJU = a.this.dIx.x;
            if (a.this.dJs) {
                float width = a.this.mListView.getWidth() * 2.0f;
                if (a.this.dJt == 0.0f) {
                    a.this.dJt = (this.dJU >= 0.0f ? 1 : -1) * width;
                    return;
                }
                float f = width * 2.0f;
                if (a.this.dJt >= 0.0f || a.this.dJt <= (-f)) {
                    if (a.this.dJt > 0.0f && a.this.dJt < f) {
                        a.this.dJt = f;
                        return;
                    }
                    return;
                }
                a.this.dJt = -f;
                return;
            }
            a.this.aTi();
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void t(float f, float f2) {
            View childAt;
            float f3 = 1.0f - f2;
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            View childAt2 = a.this.mListView.getChildAt(this.dJZ - firstVisiblePosition);
            if (a.this.dJs) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / 1000.0f;
                if (uptimeMillis != 0.0f) {
                    float f4 = a.this.dJt * uptimeMillis;
                    int width = a.this.mListView.getWidth();
                    a.this.dJt = ((a.this.dJt > 0.0f ? 1 : -1) * uptimeMillis * width) + a.this.dJt;
                    this.dJU += f4;
                    a.this.dIx.x = (int) this.dJU;
                    if (this.dJU < width && this.dJU > (-width)) {
                        this.mStartTime = SystemClock.uptimeMillis();
                        a.this.hf(true);
                        return;
                    }
                } else {
                    return;
                }
            }
            if (childAt2 != null) {
                if (this.dJX == -1) {
                    this.dJX = a.this.f(this.dJZ, childAt2, false);
                    this.dJV = childAt2.getHeight() - this.dJX;
                }
                int max = Math.max((int) (this.dJV * f3), 1);
                ViewGroup.LayoutParams layoutParams = childAt2.getLayoutParams();
                layoutParams.height = max + this.dJX;
                childAt2.setLayoutParams(layoutParams);
            }
            if (this.dKa != this.dJZ && (childAt = a.this.mListView.getChildAt(this.dKa - firstVisiblePosition)) != null) {
                if (this.dJY == -1) {
                    this.dJY = a.this.f(this.dKa, childAt, false);
                    this.dJW = childAt.getHeight() - this.dJY;
                }
                int max2 = Math.max((int) (this.dJW * f3), 1);
                ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
                layoutParams2.height = max2 + this.dJY;
                childAt.setLayoutParams(layoutParams2);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.aTb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class j extends m {
        private float dJS;
        private float dJT;
        final /* synthetic */ a dJy;

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.dJS = this.dJy.dIJ;
            this.dJT = this.dJy.dIO;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void t(float f, float f2) {
            if (this.dJy.mDragState != 4) {
                cancel();
                return;
            }
            this.dJy.dIJ = (int) ((this.dJT * f2) + ((1.0f - f2) * this.dJS));
            this.dJy.dIx.y = this.dJy.mY - this.dJy.dIJ;
            this.dJy.hf(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e {
        StringBuilder mBuilder = new StringBuilder();
        private int dJJ = 0;
        private int dJK = 0;
        private boolean dJL = false;
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

        public void aTk() {
            this.mBuilder.append("<DSLVStates>\n");
            this.dJK = 0;
            this.dJL = true;
        }

        public void aTl() {
            if (this.dJL) {
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
                this.mBuilder.append("    <FirstExpPos>").append(a.this.dIE).append("</FirstExpPos>\n");
                this.mBuilder.append("    <FirstExpBlankHeight>").append(a.this.mV(a.this.dIE) - a.this.mX(a.this.dIE)).append("</FirstExpBlankHeight>\n");
                this.mBuilder.append("    <SecondExpPos>").append(a.this.dIF).append("</SecondExpPos>\n");
                this.mBuilder.append("    <SecondExpBlankHeight>").append(a.this.mV(a.this.dIF) - a.this.mX(a.this.dIF)).append("</SecondExpBlankHeight>\n");
                this.mBuilder.append("    <SrcPos>").append(a.this.dIH).append("</SrcPos>\n");
                this.mBuilder.append("    <SrcHeight>").append(a.this.bKV + a.this.mListView.getDividerHeight()).append("</SrcHeight>\n");
                this.mBuilder.append("    <ViewHeight>").append(a.this.mListView.getHeight()).append("</ViewHeight>\n");
                this.mBuilder.append("    <LastY>").append(a.this.mLastY).append("</LastY>\n");
                this.mBuilder.append("    <FloatY>").append(a.this.dIz).append("</FloatY>\n");
                this.mBuilder.append("    <ShuffleEdges>");
                for (int i4 = 0; i4 < childCount; i4++) {
                    this.mBuilder.append(a.this.aL(firstVisiblePosition + i4, a.this.mListView.getChildAt(i4).getTop())).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                this.mBuilder.append("</ShuffleEdges>\n");
                this.mBuilder.append("</DSLVState>\n");
                this.dJJ++;
                if (this.dJJ > 1000) {
                    flush();
                    this.dJJ = 0;
                }
            }
        }

        public void flush() {
            if (this.dJL) {
                try {
                    FileWriter fileWriter = new FileWriter(this.mFile, this.dJK != 0);
                    fileWriter.write(this.mBuilder.toString());
                    this.mBuilder.delete(0, this.mBuilder.length());
                    fileWriter.flush();
                    fileWriter.close();
                    this.dJK++;
                } catch (IOException e) {
                }
            }
        }

        public void stopTracking() {
            if (this.dJL) {
                this.mBuilder.append("</DSLVStates>\n");
                flush();
                this.dJL = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements Runnable {
        private boolean dJB;
        private long dJC;
        private long dJD;
        private int dJE;
        private float dJF;
        private long dJG;
        private int dJH;
        private float dJI;
        private boolean mScrolling = false;

        public boolean isScrolling() {
            return this.mScrolling;
        }

        public int aTj() {
            if (this.mScrolling) {
                return this.dJH;
            }
            return -1;
        }

        public d() {
        }

        public void mY(int i) {
            if (!this.mScrolling) {
                this.dJB = false;
                this.mScrolling = true;
                this.dJG = SystemClock.uptimeMillis();
                this.dJC = this.dJG;
                this.dJH = i;
                a.this.mListView.post(this);
            }
        }

        public void hg(boolean z) {
            if (z) {
                a.this.mListView.removeCallbacks(this);
                this.mScrolling = false;
                return;
            }
            this.dJB = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.dJB) {
                int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
                int lastVisiblePosition = a.this.mListView.getLastVisiblePosition();
                int count = a.this.mListView.getCount();
                int paddingTop = a.this.mListView.getPaddingTop();
                int height = (a.this.mListView.getHeight() - paddingTop) - a.this.mListView.getPaddingBottom();
                int min = Math.min(a.this.mY, a.this.dIz + a.this.dIO);
                int max = Math.max(a.this.mY, a.this.dIz - a.this.dIO);
                if (this.dJH == 0) {
                    View childAt = a.this.mListView.getChildAt(0);
                    if (childAt == null) {
                        this.mScrolling = false;
                        return;
                    } else if (firstVisiblePosition == 0 && childAt.getTop() == paddingTop) {
                        this.mScrolling = false;
                        return;
                    } else {
                        this.dJI = a.this.dJa.b((a.this.dIW - max) / a.this.dIX, this.dJC);
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
                        this.dJI = -a.this.dJa.b((min - a.this.dIV) / a.this.dIY, this.dJC);
                    }
                }
                this.dJD = SystemClock.uptimeMillis();
                this.dJF = (float) (this.dJD - this.dJC);
                this.dJE = Math.round(this.dJI * this.dJF);
                if (this.dJE >= 0) {
                    this.dJE = Math.min(height, this.dJE);
                    lastVisiblePosition = firstVisiblePosition;
                } else {
                    this.dJE = Math.max(-height, this.dJE);
                }
                View childAt3 = a.this.mListView.getChildAt(lastVisiblePosition - firstVisiblePosition);
                int top2 = childAt3.getTop() + this.dJE;
                if (lastVisiblePosition == 0 && top2 > paddingTop) {
                    top2 = paddingTop;
                }
                a.this.mBlockLayoutRequests = true;
                a.this.mListView.setSelectionFromTop(lastVisiblePosition, top2 - paddingTop);
                a.this.layoutChildren();
                a.this.mListView.invalidate();
                a.this.mBlockLayoutRequests = false;
                a.this.h(lastVisiblePosition, childAt3, false);
                this.dJC = this.dJD;
                a.this.mListView.post(this);
                return;
            }
            this.mScrolling = false;
        }
    }
}
