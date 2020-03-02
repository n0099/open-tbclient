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
    private int bKW;
    private int dIA;
    private int dIE;
    private int dIF;
    private int dIG;
    private int dII;
    private int dIJ;
    private int dIK;
    private b dIL;
    private g dIM;
    private l dIN;
    private int dIP;
    private d dIR;
    private int dIU;
    private int dIV;
    private float dIW;
    private float dIX;
    private float dIY;
    private float dIZ;
    private View dIx;
    private int dJc;
    private MotionEvent dJh;
    private C0397a dJl;
    private e dJn;
    private k dJq;
    private j dJr;
    private f dJs;
    private boolean dJt;
    private com.baidu.tbadk.widget.dragsort.d dJv;
    private com.baidu.tbadk.widget.dragsort.b dJw;
    private int mLastX;
    private int mLastY;
    private ListView mListView;
    private DataSetObserver mObserver;
    private int mOffsetX;
    private int mOffsetY;
    private int mX;
    private int mY;
    private Point dIy = new Point();
    private Point dIz = new Point();
    private boolean dIB = false;
    private float dIC = 1.0f;
    private float dID = 1.0f;
    private boolean dIH = false;
    private boolean mDragEnabled = true;
    private int mDragState = 0;
    private int dIO = 1;
    private int mWidthMeasureSpec = 0;
    private View[] dIQ = new View[1];
    private float dIS = 0.33333334f;
    private float dIT = 0.33333334f;
    private float dJa = 0.5f;
    private c dJb = new c() { // from class: com.baidu.tbadk.widget.dragsort.a.1
        @Override // com.baidu.tbadk.widget.dragsort.a.c
        public float b(float f2, long j2) {
            return a.this.dJa * f2;
        }
    };
    private int dJd = 0;
    private boolean dJe = false;
    private boolean dJf = false;
    private h dJg = null;
    private int dJi = 0;
    private float dJj = 0.25f;
    private float dJk = 0.0f;
    private boolean dJm = false;
    private boolean mBlockLayoutRequests = false;
    private boolean dJo = false;
    private i dJp = new i(3);
    private float dJu = 0.0f;
    private boolean dJx = false;
    private boolean dJy = false;

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
        this.dJv = dVar;
        this.mListView = listView;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            this.dJl = new C0397a(listAdapter);
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
            this.dJl = null;
        }
        this.dJv.setAdapter(this.dJl);
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
            if (i2 > this.dII) {
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
        int i4 = this.bKW - this.dIO;
        int mX = mX(i2);
        int mV = mV(i2);
        if (this.dIG <= this.dII) {
            if (i2 == this.dIG && this.dIF != this.dIG) {
                if (i2 == this.dII) {
                    i3 = (i3 + mV) - this.bKW;
                } else {
                    i3 = ((mV - mX) + i3) - i4;
                }
            } else if (i2 > this.dIG && i2 <= this.dII) {
                i3 -= i4;
            }
        } else if (i2 > this.dII && i2 <= this.dIF) {
            i3 += i4;
        } else if (i2 == this.dIG && this.dIF != this.dIG) {
            i3 += mV - mX;
        }
        if (i2 <= this.dII) {
            return (((this.bKW - dividerHeight) - mX(i2 - 1)) / 2) + i3;
        }
        return (((mX - dividerHeight) - this.bKW) / 2) + i3;
    }

    private boolean aTa() {
        int i2;
        int i3;
        int i4;
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int i5 = this.dIF;
        View childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        if (childAt == null) {
            i5 = firstVisiblePosition + (this.mListView.getChildCount() / 2);
            childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        }
        int top2 = childAt.getTop();
        int height = childAt.getHeight();
        int aL = aL(i5, top2);
        int dividerHeight = this.mListView.getDividerHeight();
        if (this.dIA >= aL) {
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
                    if (this.dIA < i2) {
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
                if (this.dIA >= i2) {
                    break;
                }
                i4 = i2;
            }
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int i9 = this.dIF;
        int i10 = this.dIG;
        float f2 = this.dJk;
        if (this.dIH) {
            int abs = Math.abs(i2 - i4);
            if (this.dIA >= i2) {
                int i11 = i4;
                i4 = i2;
                i2 = i11;
            }
            int i12 = (int) (abs * this.dJj * 0.5f);
            float f3 = i12;
            int i13 = i4 + i12;
            int i14 = i2 - i12;
            if (this.dIA < i13) {
                this.dIF = i3 - 1;
                this.dIG = i3;
                this.dJk = ((i13 - this.dIA) * 0.5f) / f3;
            } else if (this.dIA < i14) {
                this.dIF = i3;
                this.dIG = i3;
            } else {
                this.dIF = i3;
                this.dIG = i3 + 1;
                this.dJk = (1.0f + ((i2 - this.dIA) / f3)) * 0.5f;
            }
        } else {
            this.dIF = i3;
            this.dIG = i3;
        }
        if (this.dIF < headerViewsCount) {
            this.dIF = headerViewsCount;
            this.dIG = headerViewsCount;
            i3 = headerViewsCount;
        } else if (this.dIG >= this.mListView.getCount() - footerViewsCount) {
            i3 = (this.mListView.getCount() - footerViewsCount) - 1;
            this.dIF = i3;
            this.dIG = i3;
        }
        boolean z = (this.dIF == i9 && this.dIG == i10 && this.dJk == f2) ? false : true;
        if (i3 != this.dIE) {
            if (this.dIL != null) {
                this.dIL.drag(this.dIE - headerViewsCount, i3 - headerViewsCount);
            }
            this.dIE = i3;
            return true;
        }
        return z;
    }

    public void removeItem(int i2) {
        this.dJt = false;
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
            this.dIO = Math.max(1, obtainStyledAttributes.getDimensionPixelSize(12, 1));
            this.dJm = obtainStyledAttributes.getBoolean(6, false);
            if (this.dJm) {
                this.dJn = new e();
            }
            this.dIC = obtainStyledAttributes.getFloat(10, this.dIC);
            this.dID = this.dIC;
            this.mDragEnabled = obtainStyledAttributes.getBoolean(13, this.mDragEnabled);
            this.dJj = Math.max(0.0f, Math.min(1.0f, 1.0f - obtainStyledAttributes.getFloat(2, 0.75f)));
            this.dIH = this.dJj > 0.0f;
            setDragScrollStart(obtainStyledAttributes.getFloat(14, this.dIS));
            this.dJa = obtainStyledAttributes.getFloat(0, this.dJa);
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
                this.dJg = bVar;
                a(bVar);
            }
            obtainStyledAttributes.recycle();
            i2 = i5;
            i3 = i4;
        }
        this.dIR = new d();
        if (i3 > 0) {
            this.dJq = new k(0.5f, i3);
        }
        if (i2 > 0) {
            this.dJs = new f(0.5f, i2);
        }
        this.dJh = MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
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
        this.dJw = bVar;
        this.mListView.setOnTouchListener(bVar);
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void dispatchDraw(Canvas canvas) {
        float f2;
        this.dJv.dispatchDraw(canvas);
        if (this.mDragState != 0) {
            if (this.dIF != this.dII) {
                b(this.dIF, canvas);
            }
            if (this.dIG != this.dIF && this.dIG != this.dII) {
                b(this.dIG, canvas);
            }
        }
        if (this.dIx != null) {
            int width = this.dIx.getWidth();
            int height = this.dIx.getHeight();
            int i2 = this.dIy.x;
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
            int i3 = (int) (f2 * 255.0f * this.dID);
            canvas.save();
            canvas.translate(this.dIy.x, this.dIy.y);
            canvas.clipRect(0, 0, width, height);
            canvas.saveLayerAlpha(0.0f, 0.0f, width, height, i3, 31);
            this.dIx.draw(canvas);
            canvas.restore();
            canvas.restore();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onDraw(Canvas canvas) {
        this.dJv.onDraw(canvas);
        if (this.dJm) {
            this.dJn.aTn();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.dJo) {
            this.dJo = false;
            return false;
        } else if (!this.mDragEnabled) {
            return this.dJv.onTouchEvent(motionEvent);
        } else {
            boolean z2 = this.dJe;
            this.dJe = false;
            if (!z2) {
                s(motionEvent);
            }
            if (this.mDragState == 4) {
                onDragTouchEvent(motionEvent);
                return true;
            }
            if (this.mDragState == 0 && this.dJv.onTouchEvent(motionEvent)) {
                z = true;
            }
            switch (motionEvent.getAction() & 255) {
                case 1:
                case 3:
                    aTf();
                    return z;
                case 2:
                default:
                    if (z) {
                        this.dJi = 1;
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
            return this.dJv.onInterceptTouchEvent(motionEvent);
        }
        if (this.dJw != null) {
            this.dJw.aTp().onTouchEvent(motionEvent);
        }
        s(motionEvent);
        this.dJe = true;
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            if (this.mDragState != 0) {
                this.dJo = true;
                return true;
            }
            this.dJf = true;
        }
        if (this.dIx == null) {
            if (this.dJv.onInterceptTouchEvent(motionEvent)) {
                this.dJx = true;
                z = true;
            } else {
                z = false;
            }
            switch (action) {
                case 1:
                case 3:
                    aTf();
                    break;
                case 2:
                default:
                    if (z) {
                        this.dJi = 1;
                        break;
                    } else {
                        this.dJi = 2;
                        break;
                    }
            }
        } else {
            z = true;
        }
        if (action == 1 || action == 3) {
            this.dJf = false;
        }
        return z;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        this.dJv.onSizeChanged(i2, i3, i4, i5);
        aTg();
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void requestLayout() {
        if (!this.mBlockLayoutRequests) {
            this.dJv.requestLayout();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onMeasure(int i2, int i3) {
        this.dJv.onMeasure(i2, i3);
        if (this.dIx != null) {
            if (this.dIx.isLayoutRequested()) {
                aTi();
            }
            this.dIB = true;
        }
        this.mWidthMeasureSpec = i2;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void layoutChildren() {
        this.dJv.layoutChildren();
        if (this.dIx != null) {
            if (this.dIx.isLayoutRequested() && !this.dIB) {
                aTi();
            }
            this.dIx.layout(0, 0, this.dIx.getMeasuredWidth(), this.dIx.getMeasuredHeight());
            this.dIB = false;
        }
    }

    public void removeItem(int i2, float f2) {
        if (this.mDragState == 0 || this.mDragState == 4) {
            if (this.mDragState == 0) {
                this.dII = this.mListView.getHeaderViewsCount() + i2;
                this.dIF = this.dII;
                this.dIG = this.dII;
                this.dIE = this.dII;
                View childAt = this.mListView.getChildAt(this.dII - this.mListView.getFirstVisiblePosition());
                if (childAt != null) {
                    childAt.setVisibility(4);
                }
            }
            this.mDragState = 1;
            this.dJu = f2;
            if (this.dJf) {
                switch (this.dJi) {
                    case 1:
                        this.dJv.onTouchEvent(this.dJh);
                        break;
                    case 2:
                        this.dJv.onInterceptTouchEvent(this.dJh);
                        break;
                }
            }
            if (this.dJq != null) {
                this.dJq.start();
            } else {
                mW(i2);
            }
        }
    }

    public void cancelDrag() {
        if (this.mDragState == 4) {
            this.dIR.hg(true);
            aTk();
            aTb();
            aTh();
            if (this.dJf) {
                this.mDragState = 3;
            } else {
                this.mDragState = 0;
            }
        }
    }

    private void aTb() {
        this.dII = -1;
        this.dIF = -1;
        this.dIG = -1;
        this.dIE = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTc() {
        this.mDragState = 2;
        if (this.dIM != null && this.dIE >= 0 && this.dIE < this.mListView.getCount()) {
            int headerViewsCount = this.mListView.getHeaderViewsCount();
            this.dIM.drop(this.dII - headerViewsCount, this.dIE - headerViewsCount);
        }
        aTk();
        aTe();
        aTb();
        aTh();
        if (this.dJf) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTd() {
        mW(this.dII - this.mListView.getHeaderViewsCount());
    }

    private void mW(int i2) {
        this.mDragState = 1;
        if (this.dIN != null) {
            this.dIN.remove(i2);
        }
        aTk();
        aTe();
        aTb();
        if (this.dJf) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    private void aTe() {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        if (this.dII < firstVisiblePosition) {
            View childAt = this.mListView.getChildAt(0);
            this.mListView.setSelectionFromTop(firstVisiblePosition - 1, (childAt != null ? childAt.getTop() : 0) - this.mListView.getPaddingTop());
        }
    }

    public boolean stopDrag(boolean z) {
        this.dJt = false;
        return stopDrag(z, 0.0f);
    }

    public boolean stopDragWithVelocity(boolean z, float f2) {
        this.dJt = true;
        return stopDrag(z, f2);
    }

    public boolean stopDrag(boolean z, float f2) {
        if (this.dIx != null) {
            this.dIR.hg(true);
            if (z) {
                removeItem(this.dII - this.mListView.getHeaderViewsCount(), f2);
            } else if (this.dJs != null) {
                this.dJs.start();
            } else {
                aTc();
            }
            if (this.dJm) {
                this.dJn.stopTracking();
                return true;
            }
            return true;
        }
        return false;
    }

    private void aTf() {
        this.dJi = 0;
        this.dJf = false;
        if (this.mDragState == 3) {
            this.mDragState = 0;
        }
        this.dID = this.dIC;
        this.dJx = false;
        this.dJp.clear();
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
        return this.dJx;
    }

    public void setDragScrollStart(float f2) {
        setDragScrollStarts(f2, f2);
    }

    public void setDragScrollStarts(float f2, float f3) {
        if (f3 > 0.5f) {
            this.dIT = 0.5f;
        } else {
            this.dIT = f3;
        }
        if (f2 > 0.5f) {
            this.dIS = 0.5f;
        } else {
            this.dIS = f2;
        }
        if (this.mListView.getHeight() != 0) {
            aTg();
        }
    }

    private void aM(int i2, int i3) {
        this.dIy.x = i2 - this.dIJ;
        this.dIy.y = i3 - this.dIK;
        hf(true);
        int min = Math.min(i3, this.dIA + this.dIP);
        int max = Math.max(i3, this.dIA - this.dIP);
        int aTl = this.dIR.aTl();
        if (min > this.mLastY && min > this.dIV && aTl != 1) {
            if (aTl != -1) {
                this.dIR.hg(true);
            }
            this.dIR.mY(1);
        } else if (max < this.mLastY && max < this.dIU && aTl != 0) {
            if (aTl != -1) {
                this.dIR.hg(true);
            }
            this.dIR.mY(0);
        } else if (max >= this.dIU && min <= this.dIV && this.dIR.isScrolling()) {
            this.dIR.hg(true);
        }
    }

    private void aTg() {
        int height;
        int paddingTop = this.mListView.getPaddingTop();
        float height2 = (this.mListView.getHeight() - paddingTop) - this.mListView.getPaddingBottom();
        this.dIX = paddingTop + (this.dIS * height2);
        this.dIW = (height2 * (1.0f - this.dIT)) + paddingTop;
        this.dIU = (int) this.dIX;
        this.dIV = (int) this.dIW;
        this.dIY = this.dIX - paddingTop;
        this.dIZ = (paddingTop + height) - this.dIW;
    }

    private void aTh() {
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
        if (i2 != this.dII && i2 != this.dIF && i2 != this.dIG) {
            g2 = -2;
        } else {
            g2 = g(i2, view, z);
        }
        if (g2 != layoutParams.height) {
            layoutParams.height = g2;
            view.setLayoutParams(layoutParams);
        }
        if (i2 == this.dIF || i2 == this.dIG) {
            if (i2 < this.dII) {
                ((DragSortItemView) view).setGravity(80);
            } else if (i2 > this.dII) {
                ((DragSortItemView) view).setGravity(48);
            }
        }
        int visibility = view.getVisibility();
        int i3 = 0;
        if (i2 == this.dII && this.dIx != null) {
            i3 = 4;
        }
        if (i3 != visibility) {
            view.setVisibility(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int mX(int i2) {
        View view;
        if (i2 == this.dII) {
            return 0;
        }
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        if (childAt != null) {
            return f(i2, childAt, false);
        }
        int i3 = this.dJp.get(i2);
        if (i3 == -1) {
            ListAdapter adapter = this.mListView.getAdapter();
            int itemViewType = adapter.getItemViewType(i2);
            int viewTypeCount = adapter.getViewTypeCount();
            if (viewTypeCount != this.dIQ.length) {
                this.dIQ = new View[viewTypeCount];
            }
            if (itemViewType >= 0) {
                if (this.dIQ[itemViewType] == null) {
                    view = adapter.getView(i2, null, this.mListView);
                    this.dIQ[itemViewType] = view;
                } else {
                    view = adapter.getView(i2, this.dIQ[itemViewType], this.mListView);
                }
            } else {
                view = adapter.getView(i2, null, this.mListView);
            }
            int f2 = f(i2, view, true);
            this.dJp.aO(i2, f2);
            return f2;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(int i2, View view, boolean z) {
        if (i2 == this.dII) {
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
        boolean z = this.dIH && this.dIF != this.dIG;
        int i4 = this.bKW - this.dIO;
        int i5 = (int) (this.dJk * i4);
        if (i2 == this.dII) {
            if (this.dII == this.dIF) {
                if (z) {
                    return i5 + this.dIO;
                }
                return this.bKW;
            } else if (this.dII == this.dIG) {
                return this.bKW - i5;
            } else {
                return this.dIO;
            }
        } else if (i2 == this.dIF) {
            if (z) {
                return i3 + i5;
            }
            return i3 + i4;
        } else if (i2 == this.dIG) {
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
        if (i2 != this.dII) {
            i6 = height - mX;
            i5 = aN - mX;
        } else {
            i5 = aN;
            i6 = height;
        }
        int i7 = this.bKW;
        if (this.dII != this.dIF && this.dII != this.dIG) {
            i7 -= this.dIO;
        }
        if (i2 <= i3) {
            if (i2 > this.dIF) {
                return (i7 - i5) + 0;
            }
        } else if (i2 == i4) {
            if (i2 <= this.dIF) {
                return (i6 - i7) + 0;
            }
            if (i2 == this.dIG) {
                return (height - aN) + 0;
            }
            return 0 + i6;
        } else if (i2 <= this.dIF) {
            return 0 - i7;
        } else {
            if (i2 == this.dIG) {
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

    private void aTi() {
        if (this.dIx != null) {
            measureItem(this.dIx);
            this.bKW = this.dIx.getMeasuredHeight();
            this.dIP = this.bKW / 2;
        }
    }

    protected boolean onDragTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        switch (motionEvent.getAction() & 255) {
            case 1:
                if (this.mDragState == 4) {
                    stopDrag(false);
                }
                aTf();
                return true;
            case 2:
                aM((int) motionEvent.getX(), (int) motionEvent.getY());
                return true;
            case 3:
                if (this.mDragState == 4) {
                    cancelDrag();
                }
                aTf();
                return true;
            default:
                return true;
        }
    }

    public boolean startDrag(int i2, int i3, int i4, int i5) {
        View mZ;
        if (!this.dJf || this.dJg == null || (mZ = this.dJg.mZ(i2)) == null) {
            return false;
        }
        return startDrag(i2, mZ, i3, i4, i5);
    }

    public boolean startDrag(int i2, View view, int i3, int i4, int i5) {
        if (this.mDragState == 0 && this.dJf && this.dIx == null && view != null && this.mDragEnabled) {
            if (this.mListView.getParent() != null) {
                this.mListView.getParent().requestDisallowInterceptTouchEvent(true);
            }
            int headerViewsCount = this.mListView.getHeaderViewsCount() + i2;
            this.dIF = headerViewsCount;
            this.dIG = headerViewsCount;
            this.dII = headerViewsCount;
            this.dIE = headerViewsCount;
            this.mDragState = 4;
            this.dJd = 0;
            this.dJd |= i3;
            this.dIx = view;
            aTi();
            this.dIJ = i4;
            this.dIK = i5;
            this.dJc = this.mY;
            this.dIy.x = this.mX - this.dIJ;
            this.dIy.y = this.mY - this.dIK;
            View childAt = this.mListView.getChildAt(this.dII - this.mListView.getFirstVisiblePosition());
            if (childAt != null) {
                childAt.setVisibility(4);
            }
            if (this.dJm) {
                this.dJn.aTm();
            }
            switch (this.dJi) {
                case 1:
                    this.dJv.onTouchEvent(this.dJh);
                    break;
                case 2:
                    this.dJv.onInterceptTouchEvent(this.dJh);
                    break;
            }
            this.mListView.requestLayout();
            if (this.dJr != null) {
                this.dJr.start();
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
        aTj();
        int i3 = this.dIF;
        int i4 = this.dIG;
        boolean aTa = aTa();
        if (aTa) {
            aTh();
            this.mListView.setSelectionFromTop(i2, (b(i2, view, i3, i4) + view.getTop()) - this.mListView.getPaddingTop());
            layoutChildren();
        }
        if (aTa || z) {
            this.mListView.invalidate();
        }
        this.mBlockLayoutRequests = false;
    }

    private void aTj() {
        if (this.dJg != null) {
            this.dIz.set(this.mX, this.mY);
            this.dJg.b(this.dIx, this.dIy, this.dIz);
        }
        int i2 = this.dIy.x;
        int i3 = this.dIy.y;
        int paddingLeft = this.mListView.getPaddingLeft();
        if ((this.dJd & 1) == 0 && i2 > paddingLeft) {
            this.dIy.x = paddingLeft;
        } else if ((this.dJd & 2) == 0 && i2 < paddingLeft) {
            this.dIy.x = paddingLeft;
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int lastVisiblePosition = this.mListView.getLastVisiblePosition();
        int paddingTop = this.mListView.getPaddingTop();
        if (firstVisiblePosition < headerViewsCount) {
            paddingTop = this.mListView.getChildAt((headerViewsCount - firstVisiblePosition) - 1).getBottom();
        }
        if ((this.dJd & 8) == 0 && firstVisiblePosition <= this.dII) {
            paddingTop = Math.max(this.mListView.getChildAt(this.dII - firstVisiblePosition).getTop(), paddingTop);
        }
        int height = this.mListView.getHeight() - this.mListView.getPaddingBottom();
        if (lastVisiblePosition >= (this.mListView.getCount() - footerViewsCount) - 1) {
            height = this.mListView.getChildAt(((this.mListView.getCount() - footerViewsCount) - 1) - firstVisiblePosition).getBottom();
        }
        if ((this.dJd & 4) == 0 && lastVisiblePosition >= this.dII) {
            height = Math.min(this.mListView.getChildAt(this.dII - firstVisiblePosition).getBottom(), height);
        }
        if (i3 < paddingTop) {
            this.dIy.y = paddingTop;
        } else if (this.bKW + i3 > height) {
            this.dIy.y = height - this.bKW;
        }
        this.dIA = this.dIy.y + this.dIP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTk() {
        if (this.dIx != null) {
            this.dIx.setVisibility(8);
            if (this.dJg != null) {
                this.dJg.bj(this.dIx);
            }
            this.dIx = null;
            this.mListView.invalidate();
        }
    }

    public void a(h hVar) {
        this.dJg = hVar;
    }

    public void a(b bVar) {
        this.dIL = bVar;
    }

    public void setDragEnabled(boolean z) {
        this.mDragEnabled = z;
    }

    public boolean isDragEnabled() {
        return this.mDragEnabled;
    }

    public void a(g gVar) {
        this.dIM = gVar;
    }

    public void a(l lVar) {
        this.dIN = lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class i {
        private SparseIntArray dJR;
        private ArrayList<Integer> dJS;
        private int mMaxSize;

        public i(int i) {
            this.dJR = new SparseIntArray(i);
            this.dJS = new ArrayList<>(i);
            this.mMaxSize = i;
        }

        public void aO(int i, int i2) {
            int i3 = this.dJR.get(i, -1);
            if (i3 != i2) {
                if (i3 == -1) {
                    if (this.dJR.size() == this.mMaxSize) {
                        this.dJR.delete(this.dJS.remove(0).intValue());
                    }
                } else {
                    this.dJS.remove(Integer.valueOf(i));
                }
                this.dJR.put(i, i2);
                this.dJS.add(Integer.valueOf(i));
            }
        }

        public int get(int i) {
            return this.dJR.get(i, -1);
        }

        public void clear() {
            this.dJR.clear();
            this.dJS.clear();
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
        private float bhg;
        private float bhh;
        private float bhi;
        private float bhj;
        private float dKc;
        private float mAlpha;
        private boolean mCanceled;
        protected long mStartTime;

        public m(float f, int i) {
            this.mAlpha = f;
            this.dKc = i;
            float f2 = 1.0f / ((this.mAlpha * 2.0f) * (1.0f - this.mAlpha));
            this.bhj = f2;
            this.bhg = f2;
            this.bhh = this.mAlpha / ((this.mAlpha - 1.0f) * 2.0f);
            this.bhi = 1.0f / (1.0f - this.mAlpha);
        }

        public float ar(float f) {
            if (f < this.mAlpha) {
                return this.bhg * f * f;
            }
            if (f < 1.0f - this.mAlpha) {
                return this.bhh + (this.bhi * f);
            }
            return 1.0f - ((this.bhj * (f - 1.0f)) * (f - 1.0f));
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
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / this.dKc;
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
        private int dJN;
        private int dJO;
        private float dJP;
        private float dJQ;

        public f(float f, int i) {
            super(f, i);
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.dJN = a.this.dIE;
            this.dJO = a.this.dII;
            a.this.mDragState = 2;
            this.dJP = a.this.dIy.y - aTo();
            this.dJQ = a.this.dIy.x - a.this.mListView.getPaddingLeft();
        }

        private int aTo() {
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            int dividerHeight = (a.this.dIO + a.this.mListView.getDividerHeight()) / 2;
            View childAt = a.this.mListView.getChildAt(this.dJN - firstVisiblePosition);
            if (childAt != null) {
                if (this.dJN == this.dJO) {
                    return childAt.getTop();
                }
                if (this.dJN >= this.dJO) {
                    return (childAt.getBottom() + dividerHeight) - a.this.bKW;
                }
                return childAt.getTop() - dividerHeight;
            }
            cancel();
            return -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void t(float f, float f2) {
            int aTo = aTo();
            float paddingLeft = a.this.dIy.x - a.this.mListView.getPaddingLeft();
            float f3 = 1.0f - f2;
            if (f3 < Math.abs((a.this.dIy.y - aTo) / this.dJP) || f3 < Math.abs(paddingLeft / this.dJQ)) {
                a.this.dIy.y = aTo + ((int) (this.dJP * f3));
                a.this.dIy.x = a.this.mListView.getPaddingLeft() + ((int) (this.dJQ * f3));
                a.this.hf(true);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.aTc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class k extends m {
        private int dJO;
        private float dJV;
        private float dJW;
        private float dJX;
        private int dJY;
        private int dJZ;
        private int dKa;
        private int dKb;

        public k(float f, int i) {
            super(f, i);
            this.dJY = -1;
            this.dJZ = -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.dJY = -1;
            this.dJZ = -1;
            this.dKa = a.this.dIF;
            this.dKb = a.this.dIG;
            this.dJO = a.this.dII;
            a.this.mDragState = 1;
            this.dJV = a.this.dIy.x;
            if (a.this.dJt) {
                float width = a.this.mListView.getWidth() * 2.0f;
                if (a.this.dJu == 0.0f) {
                    a.this.dJu = (this.dJV >= 0.0f ? 1 : -1) * width;
                    return;
                }
                float f = width * 2.0f;
                if (a.this.dJu >= 0.0f || a.this.dJu <= (-f)) {
                    if (a.this.dJu > 0.0f && a.this.dJu < f) {
                        a.this.dJu = f;
                        return;
                    }
                    return;
                }
                a.this.dJu = -f;
                return;
            }
            a.this.aTk();
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void t(float f, float f2) {
            View childAt;
            float f3 = 1.0f - f2;
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            View childAt2 = a.this.mListView.getChildAt(this.dKa - firstVisiblePosition);
            if (a.this.dJt) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / 1000.0f;
                if (uptimeMillis != 0.0f) {
                    float f4 = a.this.dJu * uptimeMillis;
                    int width = a.this.mListView.getWidth();
                    a.this.dJu = ((a.this.dJu > 0.0f ? 1 : -1) * uptimeMillis * width) + a.this.dJu;
                    this.dJV += f4;
                    a.this.dIy.x = (int) this.dJV;
                    if (this.dJV < width && this.dJV > (-width)) {
                        this.mStartTime = SystemClock.uptimeMillis();
                        a.this.hf(true);
                        return;
                    }
                } else {
                    return;
                }
            }
            if (childAt2 != null) {
                if (this.dJY == -1) {
                    this.dJY = a.this.f(this.dKa, childAt2, false);
                    this.dJW = childAt2.getHeight() - this.dJY;
                }
                int max = Math.max((int) (this.dJW * f3), 1);
                ViewGroup.LayoutParams layoutParams = childAt2.getLayoutParams();
                layoutParams.height = max + this.dJY;
                childAt2.setLayoutParams(layoutParams);
            }
            if (this.dKb != this.dKa && (childAt = a.this.mListView.getChildAt(this.dKb - firstVisiblePosition)) != null) {
                if (this.dJZ == -1) {
                    this.dJZ = a.this.f(this.dKb, childAt, false);
                    this.dJX = childAt.getHeight() - this.dJZ;
                }
                int max2 = Math.max((int) (this.dJX * f3), 1);
                ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
                layoutParams2.height = max2 + this.dJZ;
                childAt.setLayoutParams(layoutParams2);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.aTd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class j extends m {
        private float dJT;
        private float dJU;
        final /* synthetic */ a dJz;

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.dJT = this.dJz.dIK;
            this.dJU = this.dJz.dIP;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void t(float f, float f2) {
            if (this.dJz.mDragState != 4) {
                cancel();
                return;
            }
            this.dJz.dIK = (int) ((this.dJU * f2) + ((1.0f - f2) * this.dJT));
            this.dJz.dIy.y = this.dJz.mY - this.dJz.dIK;
            this.dJz.hf(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e {
        StringBuilder mBuilder = new StringBuilder();
        private int dJK = 0;
        private int dJL = 0;
        private boolean dJM = false;
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

        public void aTm() {
            this.mBuilder.append("<DSLVStates>\n");
            this.dJL = 0;
            this.dJM = true;
        }

        public void aTn() {
            if (this.dJM) {
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
                this.mBuilder.append("    <FirstExpPos>").append(a.this.dIF).append("</FirstExpPos>\n");
                this.mBuilder.append("    <FirstExpBlankHeight>").append(a.this.mV(a.this.dIF) - a.this.mX(a.this.dIF)).append("</FirstExpBlankHeight>\n");
                this.mBuilder.append("    <SecondExpPos>").append(a.this.dIG).append("</SecondExpPos>\n");
                this.mBuilder.append("    <SecondExpBlankHeight>").append(a.this.mV(a.this.dIG) - a.this.mX(a.this.dIG)).append("</SecondExpBlankHeight>\n");
                this.mBuilder.append("    <SrcPos>").append(a.this.dII).append("</SrcPos>\n");
                this.mBuilder.append("    <SrcHeight>").append(a.this.bKW + a.this.mListView.getDividerHeight()).append("</SrcHeight>\n");
                this.mBuilder.append("    <ViewHeight>").append(a.this.mListView.getHeight()).append("</ViewHeight>\n");
                this.mBuilder.append("    <LastY>").append(a.this.mLastY).append("</LastY>\n");
                this.mBuilder.append("    <FloatY>").append(a.this.dIA).append("</FloatY>\n");
                this.mBuilder.append("    <ShuffleEdges>");
                for (int i4 = 0; i4 < childCount; i4++) {
                    this.mBuilder.append(a.this.aL(firstVisiblePosition + i4, a.this.mListView.getChildAt(i4).getTop())).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                this.mBuilder.append("</ShuffleEdges>\n");
                this.mBuilder.append("</DSLVState>\n");
                this.dJK++;
                if (this.dJK > 1000) {
                    flush();
                    this.dJK = 0;
                }
            }
        }

        public void flush() {
            if (this.dJM) {
                try {
                    FileWriter fileWriter = new FileWriter(this.mFile, this.dJL != 0);
                    fileWriter.write(this.mBuilder.toString());
                    this.mBuilder.delete(0, this.mBuilder.length());
                    fileWriter.flush();
                    fileWriter.close();
                    this.dJL++;
                } catch (IOException e) {
                }
            }
        }

        public void stopTracking() {
            if (this.dJM) {
                this.mBuilder.append("</DSLVStates>\n");
                flush();
                this.dJM = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements Runnable {
        private boolean dJC;
        private long dJD;
        private long dJE;
        private int dJF;
        private float dJG;
        private long dJH;
        private int dJI;
        private float dJJ;
        private boolean mScrolling = false;

        public boolean isScrolling() {
            return this.mScrolling;
        }

        public int aTl() {
            if (this.mScrolling) {
                return this.dJI;
            }
            return -1;
        }

        public d() {
        }

        public void mY(int i) {
            if (!this.mScrolling) {
                this.dJC = false;
                this.mScrolling = true;
                this.dJH = SystemClock.uptimeMillis();
                this.dJD = this.dJH;
                this.dJI = i;
                a.this.mListView.post(this);
            }
        }

        public void hg(boolean z) {
            if (z) {
                a.this.mListView.removeCallbacks(this);
                this.mScrolling = false;
                return;
            }
            this.dJC = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.dJC) {
                int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
                int lastVisiblePosition = a.this.mListView.getLastVisiblePosition();
                int count = a.this.mListView.getCount();
                int paddingTop = a.this.mListView.getPaddingTop();
                int height = (a.this.mListView.getHeight() - paddingTop) - a.this.mListView.getPaddingBottom();
                int min = Math.min(a.this.mY, a.this.dIA + a.this.dIP);
                int max = Math.max(a.this.mY, a.this.dIA - a.this.dIP);
                if (this.dJI == 0) {
                    View childAt = a.this.mListView.getChildAt(0);
                    if (childAt == null) {
                        this.mScrolling = false;
                        return;
                    } else if (firstVisiblePosition == 0 && childAt.getTop() == paddingTop) {
                        this.mScrolling = false;
                        return;
                    } else {
                        this.dJJ = a.this.dJb.b((a.this.dIX - max) / a.this.dIY, this.dJD);
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
                        this.dJJ = -a.this.dJb.b((min - a.this.dIW) / a.this.dIZ, this.dJD);
                    }
                }
                this.dJE = SystemClock.uptimeMillis();
                this.dJG = (float) (this.dJE - this.dJD);
                this.dJF = Math.round(this.dJJ * this.dJG);
                if (this.dJF >= 0) {
                    this.dJF = Math.min(height, this.dJF);
                    lastVisiblePosition = firstVisiblePosition;
                } else {
                    this.dJF = Math.max(-height, this.dJF);
                }
                View childAt3 = a.this.mListView.getChildAt(lastVisiblePosition - firstVisiblePosition);
                int top2 = childAt3.getTop() + this.dJF;
                if (lastVisiblePosition == 0 && top2 > paddingTop) {
                    top2 = paddingTop;
                }
                a.this.mBlockLayoutRequests = true;
                a.this.mListView.setSelectionFromTop(lastVisiblePosition, top2 - paddingTop);
                a.this.layoutChildren();
                a.this.mListView.invalidate();
                a.this.mBlockLayoutRequests = false;
                a.this.h(lastVisiblePosition, childAt3, false);
                this.dJD = this.dJE;
                a.this.mListView.post(this);
                return;
            }
            this.mScrolling = false;
        }
    }
}
