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
    private int aGQ;
    private int aGR;
    private int aGl;
    private int aGm;
    private int bdm;
    private View cQG;
    private int cQJ;
    private int cQN;
    private int cQO;
    private int cQP;
    private int cQR;
    private int cQS;
    private int cQT;
    private b cQU;
    private g cQV;
    private l cQW;
    private int cQZ;
    private k cRA;
    private j cRB;
    private f cRC;
    private boolean cRD;
    private com.baidu.tbadk.widget.dragsort.d cRF;
    private com.baidu.tbadk.widget.dragsort.b cRG;
    private d cRb;
    private int cRe;
    private int cRf;
    private float cRg;
    private float cRh;
    private float cRi;
    private float cRj;
    private int cRm;
    private MotionEvent cRr;
    private C0303a cRv;
    private e cRx;
    private int mLastX;
    private int mLastY;
    private ListView mListView;
    private DataSetObserver mObserver;
    private Point cQH = new Point();
    private Point cQI = new Point();
    private boolean cQK = false;
    private float cQL = 1.0f;
    private float cQM = 1.0f;
    private boolean cQQ = false;
    private boolean cQX = true;
    private int mDragState = 0;
    private int cQY = 1;
    private int mWidthMeasureSpec = 0;
    private View[] cRa = new View[1];
    private float cRc = 0.33333334f;
    private float cRd = 0.33333334f;
    private float cRk = 0.5f;
    private c cRl = new c() { // from class: com.baidu.tbadk.widget.dragsort.a.1
        @Override // com.baidu.tbadk.widget.dragsort.a.c
        public float b(float f2, long j2) {
            return a.this.cRk * f2;
        }
    };
    private int cRn = 0;
    private boolean cRo = false;
    private boolean cRp = false;
    private h cRq = null;
    private int cRs = 0;
    private float cRt = 0.25f;
    private float cRu = 0.0f;
    private boolean cRw = false;
    private boolean mBlockLayoutRequests = false;
    private boolean cRy = false;
    private i cRz = new i(3);
    private float cRE = 0.0f;
    private boolean cRH = false;
    private boolean cRI = false;

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

        View ku(int i);
    }

    /* loaded from: classes.dex */
    public interface l {
        void remove(int i);
    }

    public a(ListView listView, com.baidu.tbadk.widget.dragsort.d dVar) {
        this.cRF = dVar;
        this.mListView = listView;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            this.cRv = new C0303a(listAdapter);
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
            this.cRv = null;
        }
        this.cRF.setAdapter(this.cRv);
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
            if (i2 > this.cQR) {
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
    public int kq(int i2) {
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        return childAt != null ? childAt.getHeight() : ar(i2, ks(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ap(int i2, int i3) {
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        if (i2 <= headerViewsCount || i2 >= this.mListView.getCount() - footerViewsCount) {
            return i3;
        }
        int dividerHeight = this.mListView.getDividerHeight();
        int i4 = this.bdm - this.cQY;
        int ks = ks(i2);
        int kq = kq(i2);
        if (this.cQP <= this.cQR) {
            if (i2 == this.cQP && this.cQO != this.cQP) {
                if (i2 == this.cQR) {
                    i3 = (i3 + kq) - this.bdm;
                } else {
                    i3 = ((kq - ks) + i3) - i4;
                }
            } else if (i2 > this.cQP && i2 <= this.cQR) {
                i3 -= i4;
            }
        } else if (i2 > this.cQR && i2 <= this.cQO) {
            i3 += i4;
        } else if (i2 == this.cQP && this.cQO != this.cQP) {
            i3 += kq - ks;
        }
        if (i2 <= this.cQR) {
            return (((this.bdm - dividerHeight) - ks(i2 - 1)) / 2) + i3;
        }
        return (((ks - dividerHeight) - this.bdm) / 2) + i3;
    }

    private boolean ayq() {
        int i2;
        int i3;
        int i4;
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int i5 = this.cQO;
        View childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        if (childAt == null) {
            i5 = firstVisiblePosition + (this.mListView.getChildCount() / 2);
            childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        }
        int top = childAt.getTop();
        int height = childAt.getHeight();
        int ap = ap(i5, top);
        int dividerHeight = this.mListView.getDividerHeight();
        if (this.cQJ >= ap) {
            int count = this.mListView.getCount();
            int i6 = height;
            int i7 = top;
            i2 = ap;
            i3 = i5;
            i4 = ap;
            while (true) {
                if (i3 < count) {
                    if (i3 == count - 1) {
                        i2 = i7 + dividerHeight + i6;
                        break;
                    }
                    i7 += dividerHeight + i6;
                    i6 = kq(i3 + 1);
                    i2 = ap(i3 + 1, i7);
                    if (this.cQJ < i2) {
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
            i2 = ap;
            i3 = i5;
            i4 = ap;
            while (true) {
                if (i3 < 0) {
                    break;
                }
                i3--;
                int kq = kq(i3);
                if (i3 == 0) {
                    i2 = (i8 - dividerHeight) - kq;
                    break;
                }
                i8 -= kq + dividerHeight;
                i2 = ap(i3, i8);
                if (this.cQJ >= i2) {
                    break;
                }
                i4 = i2;
            }
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int i9 = this.cQO;
        int i10 = this.cQP;
        float f2 = this.cRu;
        if (this.cQQ) {
            int abs = Math.abs(i2 - i4);
            if (this.cQJ >= i2) {
                int i11 = i4;
                i4 = i2;
                i2 = i11;
            }
            int i12 = (int) (abs * this.cRt * 0.5f);
            float f3 = i12;
            int i13 = i4 + i12;
            int i14 = i2 - i12;
            if (this.cQJ < i13) {
                this.cQO = i3 - 1;
                this.cQP = i3;
                this.cRu = ((i13 - this.cQJ) * 0.5f) / f3;
            } else if (this.cQJ < i14) {
                this.cQO = i3;
                this.cQP = i3;
            } else {
                this.cQO = i3;
                this.cQP = i3 + 1;
                this.cRu = (1.0f + ((i2 - this.cQJ) / f3)) * 0.5f;
            }
        } else {
            this.cQO = i3;
            this.cQP = i3;
        }
        if (this.cQO < headerViewsCount) {
            this.cQO = headerViewsCount;
            this.cQP = headerViewsCount;
            i3 = headerViewsCount;
        } else if (this.cQP >= this.mListView.getCount() - footerViewsCount) {
            i3 = (this.mListView.getCount() - footerViewsCount) - 1;
            this.cQO = i3;
            this.cQP = i3;
        }
        boolean z = (this.cQO == i9 && this.cQP == i10 && this.cRu == f2) ? false : true;
        if (i3 != this.cQN) {
            if (this.cQU != null) {
                this.cQU.drag(this.cQN - headerViewsCount, i3 - headerViewsCount);
            }
            this.cQN = i3;
            return true;
        }
        return z;
    }

    public void removeItem(int i2) {
        this.cRD = false;
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
            this.cQY = Math.max(1, obtainStyledAttributes.getDimensionPixelSize(13, 1));
            this.cRw = obtainStyledAttributes.getBoolean(7, false);
            if (this.cRw) {
                this.cRx = new e();
            }
            this.cQL = obtainStyledAttributes.getFloat(11, this.cQL);
            this.cQM = this.cQL;
            this.cQX = obtainStyledAttributes.getBoolean(14, this.cQX);
            this.cRt = Math.max(0.0f, Math.min(1.0f, 1.0f - obtainStyledAttributes.getFloat(1, 0.75f)));
            this.cQQ = this.cRt > 0.0f;
            setDragScrollStart(obtainStyledAttributes.getFloat(15, this.cRc));
            this.cRk = obtainStyledAttributes.getFloat(0, this.cRk);
            int i4 = obtainStyledAttributes.getInt(12, 150);
            int i5 = obtainStyledAttributes.getInt(16, 150);
            if (obtainStyledAttributes.getBoolean(17, true)) {
                boolean z = obtainStyledAttributes.getBoolean(8, false);
                int i6 = obtainStyledAttributes.getInt(5, 1);
                boolean z2 = obtainStyledAttributes.getBoolean(2, true);
                int resourceId = obtainStyledAttributes.getResourceId(9, 0);
                int resourceId2 = obtainStyledAttributes.getResourceId(10, 0);
                int resourceId3 = obtainStyledAttributes.getResourceId(4, 0);
                int color = obtainStyledAttributes.getColor(6, ViewCompat.MEASURED_STATE_MASK);
                com.baidu.tbadk.widget.dragsort.b bVar = new com.baidu.tbadk.widget.dragsort.b(this, listView, resourceId, 2, i6, resourceId3, resourceId2);
                bVar.fI(z);
                bVar.fH(z2);
                bVar.setBackgroundColor(color);
                this.cRq = bVar;
                a(bVar);
            }
            obtainStyledAttributes.recycle();
            i2 = i5;
            i3 = i4;
        }
        this.cRb = new d();
        if (i3 > 0) {
            this.cRA = new k(0.5f, i3);
        }
        if (i2 > 0) {
            this.cRC = new f(0.5f, i2);
        }
        this.cRr = MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
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
        this.cRG = bVar;
        this.mListView.setOnTouchListener(bVar);
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void dispatchDraw(Canvas canvas) {
        float f2;
        this.cRF.dispatchDraw(canvas);
        if (this.mDragState != 0) {
            if (this.cQO != this.cQR) {
                b(this.cQO, canvas);
            }
            if (this.cQP != this.cQO && this.cQP != this.cQR) {
                b(this.cQP, canvas);
            }
        }
        if (this.cQG != null) {
            int width = this.cQG.getWidth();
            int height = this.cQG.getHeight();
            int i2 = this.cQH.x;
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
            int i3 = (int) (f2 * 255.0f * this.cQM);
            canvas.save();
            canvas.translate(this.cQH.x, this.cQH.y);
            canvas.clipRect(0, 0, width, height);
            canvas.saveLayerAlpha(0.0f, 0.0f, width, height, i3, 31);
            this.cQG.draw(canvas);
            canvas.restore();
            canvas.restore();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onDraw(Canvas canvas) {
        this.cRF.onDraw(canvas);
        if (this.cRw) {
            this.cRx.ayE();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.cRy) {
            this.cRy = false;
            return false;
        } else if (!this.cQX) {
            return this.cRF.onTouchEvent(motionEvent);
        } else {
            boolean z2 = this.cRo;
            this.cRo = false;
            if (!z2) {
                s(motionEvent);
            }
            if (this.mDragState == 4) {
                onDragTouchEvent(motionEvent);
                return true;
            }
            if (this.mDragState == 0 && this.cRF.onTouchEvent(motionEvent)) {
                z = true;
            }
            switch (motionEvent.getAction() & 255) {
                case 1:
                case 3:
                    ayv();
                    return z;
                case 2:
                default:
                    if (z) {
                        this.cRs = 1;
                        return z;
                    }
                    return z;
            }
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (!this.cQX) {
            return this.cRF.onInterceptTouchEvent(motionEvent);
        }
        if (this.cRG != null) {
            this.cRG.ayG().onTouchEvent(motionEvent);
        }
        s(motionEvent);
        this.cRo = true;
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            if (this.mDragState != 0) {
                this.cRy = true;
                return true;
            }
            this.cRp = true;
        }
        if (this.cQG == null) {
            if (this.cRF.onInterceptTouchEvent(motionEvent)) {
                this.cRH = true;
                z = true;
            } else {
                z = false;
            }
            switch (action) {
                case 1:
                case 3:
                    ayv();
                    break;
                case 2:
                default:
                    if (z) {
                        this.cRs = 1;
                        break;
                    } else {
                        this.cRs = 2;
                        break;
                    }
            }
        } else {
            z = true;
        }
        if (action == 1 || action == 3) {
            this.cRp = false;
        }
        return z;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        this.cRF.onSizeChanged(i2, i3, i4, i5);
        ayw();
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void requestLayout() {
        if (!this.mBlockLayoutRequests) {
            this.cRF.requestLayout();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onMeasure(int i2, int i3) {
        this.cRF.onMeasure(i2, i3);
        if (this.cQG != null) {
            if (this.cQG.isLayoutRequested()) {
                ayy();
            }
            this.cQK = true;
        }
        this.mWidthMeasureSpec = i2;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void layoutChildren() {
        this.cRF.layoutChildren();
        if (this.cQG != null) {
            if (this.cQG.isLayoutRequested() && !this.cQK) {
                ayy();
            }
            this.cQG.layout(0, 0, this.cQG.getMeasuredWidth(), this.cQG.getMeasuredHeight());
            this.cQK = false;
        }
    }

    public void removeItem(int i2, float f2) {
        if (this.mDragState == 0 || this.mDragState == 4) {
            if (this.mDragState == 0) {
                this.cQR = this.mListView.getHeaderViewsCount() + i2;
                this.cQO = this.cQR;
                this.cQP = this.cQR;
                this.cQN = this.cQR;
                View childAt = this.mListView.getChildAt(this.cQR - this.mListView.getFirstVisiblePosition());
                if (childAt != null) {
                    childAt.setVisibility(4);
                }
            }
            this.mDragState = 1;
            this.cRE = f2;
            if (this.cRp) {
                switch (this.cRs) {
                    case 1:
                        this.cRF.onTouchEvent(this.cRr);
                        break;
                    case 2:
                        this.cRF.onInterceptTouchEvent(this.cRr);
                        break;
                }
            }
            if (this.cRA != null) {
                this.cRA.start();
            } else {
                kr(i2);
            }
        }
    }

    public void cancelDrag() {
        if (this.mDragState == 4) {
            this.cRb.fG(true);
            ayA();
            ayr();
            ayx();
            if (this.cRp) {
                this.mDragState = 3;
            } else {
                this.mDragState = 0;
            }
        }
    }

    private void ayr() {
        this.cQR = -1;
        this.cQO = -1;
        this.cQP = -1;
        this.cQN = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ays() {
        this.mDragState = 2;
        if (this.cQV != null && this.cQN >= 0 && this.cQN < this.mListView.getCount()) {
            int headerViewsCount = this.mListView.getHeaderViewsCount();
            this.cQV.drop(this.cQR - headerViewsCount, this.cQN - headerViewsCount);
        }
        ayA();
        ayu();
        ayr();
        ayx();
        if (this.cRp) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayt() {
        kr(this.cQR - this.mListView.getHeaderViewsCount());
    }

    private void kr(int i2) {
        this.mDragState = 1;
        if (this.cQW != null) {
            this.cQW.remove(i2);
        }
        ayA();
        ayu();
        ayr();
        if (this.cRp) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    private void ayu() {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        if (this.cQR < firstVisiblePosition) {
            View childAt = this.mListView.getChildAt(0);
            this.mListView.setSelectionFromTop(firstVisiblePosition - 1, (childAt != null ? childAt.getTop() : 0) - this.mListView.getPaddingTop());
        }
    }

    public boolean stopDrag(boolean z) {
        this.cRD = false;
        return stopDrag(z, 0.0f);
    }

    public boolean stopDragWithVelocity(boolean z, float f2) {
        this.cRD = true;
        return stopDrag(z, f2);
    }

    public boolean stopDrag(boolean z, float f2) {
        if (this.cQG != null) {
            this.cRb.fG(true);
            if (z) {
                removeItem(this.cQR - this.mListView.getHeaderViewsCount(), f2);
            } else if (this.cRC != null) {
                this.cRC.start();
            } else {
                ays();
            }
            if (this.cRw) {
                this.cRx.stopTracking();
                return true;
            }
            return true;
        }
        return false;
    }

    private void ayv() {
        this.cRs = 0;
        this.cRp = false;
        if (this.mDragState == 3) {
            this.mDragState = 0;
        }
        this.cQM = this.cQL;
        this.cRH = false;
        this.cRz.clear();
    }

    private void s(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            this.mLastX = this.aGl;
            this.mLastY = this.aGm;
        }
        this.aGl = (int) motionEvent.getX();
        this.aGm = (int) motionEvent.getY();
        if (action == 0) {
            this.mLastX = this.aGl;
            this.mLastY = this.aGm;
        }
        this.aGQ = ((int) motionEvent.getRawX()) - this.aGl;
        this.aGR = ((int) motionEvent.getRawY()) - this.aGm;
    }

    public boolean listViewIntercepted() {
        return this.cRH;
    }

    public void setDragScrollStart(float f2) {
        setDragScrollStarts(f2, f2);
    }

    public void setDragScrollStarts(float f2, float f3) {
        if (f3 > 0.5f) {
            this.cRd = 0.5f;
        } else {
            this.cRd = f3;
        }
        if (f2 > 0.5f) {
            this.cRc = 0.5f;
        } else {
            this.cRc = f2;
        }
        if (this.mListView.getHeight() != 0) {
            ayw();
        }
    }

    private void aq(int i2, int i3) {
        this.cQH.x = i2 - this.cQS;
        this.cQH.y = i3 - this.cQT;
        fF(true);
        int min = Math.min(i3, this.cQJ + this.cQZ);
        int max = Math.max(i3, this.cQJ - this.cQZ);
        int ayC = this.cRb.ayC();
        if (min > this.mLastY && min > this.cRf && ayC != 1) {
            if (ayC != -1) {
                this.cRb.fG(true);
            }
            this.cRb.kt(1);
        } else if (max < this.mLastY && max < this.cRe && ayC != 0) {
            if (ayC != -1) {
                this.cRb.fG(true);
            }
            this.cRb.kt(0);
        } else if (max >= this.cRe && min <= this.cRf && this.cRb.ayB()) {
            this.cRb.fG(true);
        }
    }

    private void ayw() {
        int height;
        int paddingTop = this.mListView.getPaddingTop();
        float height2 = (this.mListView.getHeight() - paddingTop) - this.mListView.getPaddingBottom();
        this.cRh = paddingTop + (this.cRc * height2);
        this.cRg = (height2 * (1.0f - this.cRd)) + paddingTop;
        this.cRe = (int) this.cRh;
        this.cRf = (int) this.cRg;
        this.cRi = this.cRh - paddingTop;
        this.cRj = (paddingTop + height) - this.cRg;
    }

    private void ayx() {
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
        if (i2 != this.cQR && i2 != this.cQO && i2 != this.cQP) {
            g2 = -2;
        } else {
            g2 = g(i2, view, z);
        }
        if (g2 != layoutParams.height) {
            layoutParams.height = g2;
            view.setLayoutParams(layoutParams);
        }
        if (i2 == this.cQO || i2 == this.cQP) {
            if (i2 < this.cQR) {
                ((DragSortItemView) view).setGravity(80);
            } else if (i2 > this.cQR) {
                ((DragSortItemView) view).setGravity(48);
            }
        }
        int visibility = view.getVisibility();
        int i3 = 0;
        if (i2 == this.cQR && this.cQG != null) {
            i3 = 4;
        }
        if (i3 != visibility) {
            view.setVisibility(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ks(int i2) {
        View view;
        if (i2 == this.cQR) {
            return 0;
        }
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        if (childAt != null) {
            return f(i2, childAt, false);
        }
        int i3 = this.cRz.get(i2);
        if (i3 == -1) {
            ListAdapter adapter = this.mListView.getAdapter();
            int itemViewType = adapter.getItemViewType(i2);
            int viewTypeCount = adapter.getViewTypeCount();
            if (viewTypeCount != this.cRa.length) {
                this.cRa = new View[viewTypeCount];
            }
            if (itemViewType >= 0) {
                if (this.cRa[itemViewType] == null) {
                    view = adapter.getView(i2, null, this.mListView);
                    this.cRa[itemViewType] = view;
                } else {
                    view = adapter.getView(i2, this.cRa[itemViewType], this.mListView);
                }
            } else {
                view = adapter.getView(i2, null, this.mListView);
            }
            int f2 = f(i2, view, true);
            this.cRz.as(i2, f2);
            return f2;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(int i2, View view, boolean z) {
        if (i2 == this.cQR) {
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
        return ar(i2, f(i2, view, z));
    }

    private int ar(int i2, int i3) {
        this.mListView.getDividerHeight();
        boolean z = this.cQQ && this.cQO != this.cQP;
        int i4 = this.bdm - this.cQY;
        int i5 = (int) (this.cRu * i4);
        if (i2 == this.cQR) {
            if (this.cQR == this.cQO) {
                if (z) {
                    return i5 + this.cQY;
                }
                return this.bdm;
            } else if (this.cQR == this.cQP) {
                return this.bdm - i5;
            } else {
                return this.cQY;
            }
        } else if (i2 == this.cQO) {
            if (z) {
                return i3 + i5;
            }
            return i3 + i4;
        } else if (i2 == this.cQP) {
            return (i3 + i4) - i5;
        } else {
            return i3;
        }
    }

    private int b(int i2, View view, int i3, int i4) {
        int i5;
        int i6;
        int ks = ks(i2);
        int height = view.getHeight();
        int ar = ar(i2, ks);
        if (i2 != this.cQR) {
            i6 = height - ks;
            i5 = ar - ks;
        } else {
            i5 = ar;
            i6 = height;
        }
        int i7 = this.bdm;
        if (this.cQR != this.cQO && this.cQR != this.cQP) {
            i7 -= this.cQY;
        }
        if (i2 <= i3) {
            if (i2 > this.cQO) {
                return (i7 - i5) + 0;
            }
        } else if (i2 == i4) {
            if (i2 <= this.cQO) {
                return (i6 - i7) + 0;
            }
            if (i2 == this.cQP) {
                return (height - ar) + 0;
            }
            return 0 + i6;
        } else if (i2 <= this.cQO) {
            return 0 - i7;
        } else {
            if (i2 == this.cQP) {
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

    private void ayy() {
        if (this.cQG != null) {
            measureItem(this.cQG);
            this.bdm = this.cQG.getMeasuredHeight();
            this.cQZ = this.bdm / 2;
        }
    }

    protected boolean onDragTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        switch (motionEvent.getAction() & 255) {
            case 1:
                if (this.mDragState == 4) {
                    stopDrag(false);
                }
                ayv();
                return true;
            case 2:
                aq((int) motionEvent.getX(), (int) motionEvent.getY());
                return true;
            case 3:
                if (this.mDragState == 4) {
                    cancelDrag();
                }
                ayv();
                return true;
            default:
                return true;
        }
    }

    public boolean startDrag(int i2, int i3, int i4, int i5) {
        View ku;
        if (!this.cRp || this.cRq == null || (ku = this.cRq.ku(i2)) == null) {
            return false;
        }
        return startDrag(i2, ku, i3, i4, i5);
    }

    public boolean startDrag(int i2, View view, int i3, int i4, int i5) {
        if (this.mDragState == 0 && this.cRp && this.cQG == null && view != null && this.cQX) {
            if (this.mListView.getParent() != null) {
                this.mListView.getParent().requestDisallowInterceptTouchEvent(true);
            }
            int headerViewsCount = this.mListView.getHeaderViewsCount() + i2;
            this.cQO = headerViewsCount;
            this.cQP = headerViewsCount;
            this.cQR = headerViewsCount;
            this.cQN = headerViewsCount;
            this.mDragState = 4;
            this.cRn = 0;
            this.cRn |= i3;
            this.cQG = view;
            ayy();
            this.cQS = i4;
            this.cQT = i5;
            this.cRm = this.aGm;
            this.cQH.x = this.aGl - this.cQS;
            this.cQH.y = this.aGm - this.cQT;
            View childAt = this.mListView.getChildAt(this.cQR - this.mListView.getFirstVisiblePosition());
            if (childAt != null) {
                childAt.setVisibility(4);
            }
            if (this.cRw) {
                this.cRx.ayD();
            }
            switch (this.cRs) {
                case 1:
                    this.cRF.onTouchEvent(this.cRr);
                    break;
                case 2:
                    this.cRF.onInterceptTouchEvent(this.cRr);
                    break;
            }
            this.mListView.requestLayout();
            if (this.cRB != null) {
                this.cRB.start();
                return true;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fF(boolean z) {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition() + (this.mListView.getChildCount() / 2);
        View childAt = this.mListView.getChildAt(this.mListView.getChildCount() / 2);
        if (childAt != null) {
            h(firstVisiblePosition, childAt, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i2, View view, boolean z) {
        this.mBlockLayoutRequests = true;
        ayz();
        int i3 = this.cQO;
        int i4 = this.cQP;
        boolean ayq = ayq();
        if (ayq) {
            ayx();
            this.mListView.setSelectionFromTop(i2, (b(i2, view, i3, i4) + view.getTop()) - this.mListView.getPaddingTop());
            layoutChildren();
        }
        if (ayq || z) {
            this.mListView.invalidate();
        }
        this.mBlockLayoutRequests = false;
    }

    private void ayz() {
        if (this.cRq != null) {
            this.cQI.set(this.aGl, this.aGm);
            this.cRq.b(this.cQG, this.cQH, this.cQI);
        }
        int i2 = this.cQH.x;
        int i3 = this.cQH.y;
        int paddingLeft = this.mListView.getPaddingLeft();
        if ((this.cRn & 1) == 0 && i2 > paddingLeft) {
            this.cQH.x = paddingLeft;
        } else if ((this.cRn & 2) == 0 && i2 < paddingLeft) {
            this.cQH.x = paddingLeft;
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int lastVisiblePosition = this.mListView.getLastVisiblePosition();
        int paddingTop = this.mListView.getPaddingTop();
        if (firstVisiblePosition < headerViewsCount) {
            paddingTop = this.mListView.getChildAt((headerViewsCount - firstVisiblePosition) - 1).getBottom();
        }
        if ((this.cRn & 8) == 0 && firstVisiblePosition <= this.cQR) {
            paddingTop = Math.max(this.mListView.getChildAt(this.cQR - firstVisiblePosition).getTop(), paddingTop);
        }
        int height = this.mListView.getHeight() - this.mListView.getPaddingBottom();
        if (lastVisiblePosition >= (this.mListView.getCount() - footerViewsCount) - 1) {
            height = this.mListView.getChildAt(((this.mListView.getCount() - footerViewsCount) - 1) - firstVisiblePosition).getBottom();
        }
        if ((this.cRn & 4) == 0 && lastVisiblePosition >= this.cQR) {
            height = Math.min(this.mListView.getChildAt(this.cQR - firstVisiblePosition).getBottom(), height);
        }
        if (i3 < paddingTop) {
            this.cQH.y = paddingTop;
        } else if (this.bdm + i3 > height) {
            this.cQH.y = height - this.bdm;
        }
        this.cQJ = this.cQH.y + this.cQZ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayA() {
        if (this.cQG != null) {
            this.cQG.setVisibility(8);
            if (this.cRq != null) {
                this.cRq.bi(this.cQG);
            }
            this.cQG = null;
            this.mListView.invalidate();
        }
    }

    public void a(h hVar) {
        this.cRq = hVar;
    }

    public void a(b bVar) {
        this.cQU = bVar;
    }

    public void setDragEnabled(boolean z) {
        this.cQX = z;
    }

    public boolean isDragEnabled() {
        return this.cQX;
    }

    public void a(g gVar) {
        this.cQV = gVar;
    }

    public void a(l lVar) {
        this.cQW = lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class i {
        private SparseIntArray cSb;
        private ArrayList<Integer> cSc;
        private int mMaxSize;

        public i(int i) {
            this.cSb = new SparseIntArray(i);
            this.cSc = new ArrayList<>(i);
            this.mMaxSize = i;
        }

        public void as(int i, int i2) {
            int i3 = this.cSb.get(i, -1);
            if (i3 != i2) {
                if (i3 == -1) {
                    if (this.cSb.size() == this.mMaxSize) {
                        this.cSb.delete(this.cSc.remove(0).intValue());
                    }
                } else {
                    this.cSc.remove(Integer.valueOf(i));
                }
                this.cSb.put(i, i2);
                this.cSc.add(Integer.valueOf(i));
            }
        }

        public int get(int i) {
            return this.cSb.get(i, -1);
        }

        public void clear() {
            this.cSb.clear();
            this.cSc.clear();
        }
    }

    /* renamed from: com.baidu.tbadk.widget.dragsort.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0303a extends BaseAdapter {
        private ListAdapter mAdapter;

        public C0303a(ListAdapter listAdapter) {
            this.mAdapter = listAdapter;
            this.mAdapter.registerDataSetObserver(new DataSetObserver() { // from class: com.baidu.tbadk.widget.dragsort.a.a.1
                @Override // android.database.DataSetObserver
                public void onChanged() {
                    C0303a.this.notifyDataSetChanged();
                }

                @Override // android.database.DataSetObserver
                public void onInvalidated() {
                    C0303a.this.notifyDataSetInvalidated();
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
        private float aGK;
        private float aGL;
        private float aGM;
        private float aGN;
        private float cSm;
        private float mAlpha;
        private boolean mCanceled;
        protected long mStartTime;

        public m(float f, int i) {
            this.mAlpha = f;
            this.cSm = i;
            float f2 = 1.0f / ((this.mAlpha * 2.0f) * (1.0f - this.mAlpha));
            this.aGN = f2;
            this.aGK = f2;
            this.aGL = this.mAlpha / ((this.mAlpha - 1.0f) * 2.0f);
            this.aGM = 1.0f / (1.0f - this.mAlpha);
        }

        public float ae(float f) {
            if (f < this.mAlpha) {
                return this.aGK * f * f;
            }
            if (f < 1.0f - this.mAlpha) {
                return this.aGL + (this.aGM * f);
            }
            return 1.0f - ((this.aGN * (f - 1.0f)) * (f - 1.0f));
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

        public void r(float f, float f2) {
        }

        public void onStop() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.mCanceled) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / this.cSm;
                if (uptimeMillis >= 1.0f) {
                    r(1.0f, 1.0f);
                    onStop();
                    return;
                }
                r(uptimeMillis, ae(uptimeMillis));
                a.this.mListView.post(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class f extends m {
        private int cRX;
        private int cRY;
        private float cRZ;
        private float cSa;

        public f(float f, int i) {
            super(f, i);
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.cRX = a.this.cQN;
            this.cRY = a.this.cQR;
            a.this.mDragState = 2;
            this.cRZ = a.this.cQH.y - ayF();
            this.cSa = a.this.cQH.x - a.this.mListView.getPaddingLeft();
        }

        private int ayF() {
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            int dividerHeight = (a.this.cQY + a.this.mListView.getDividerHeight()) / 2;
            View childAt = a.this.mListView.getChildAt(this.cRX - firstVisiblePosition);
            if (childAt != null) {
                if (this.cRX == this.cRY) {
                    return childAt.getTop();
                }
                if (this.cRX >= this.cRY) {
                    return (childAt.getBottom() + dividerHeight) - a.this.bdm;
                }
                return childAt.getTop() - dividerHeight;
            }
            cancel();
            return -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void r(float f, float f2) {
            int ayF = ayF();
            float paddingLeft = a.this.cQH.x - a.this.mListView.getPaddingLeft();
            float f3 = 1.0f - f2;
            if (f3 < Math.abs((a.this.cQH.y - ayF) / this.cRZ) || f3 < Math.abs(paddingLeft / this.cSa)) {
                a.this.cQH.y = ayF + ((int) (this.cRZ * f3));
                a.this.cQH.x = a.this.mListView.getPaddingLeft() + ((int) (this.cSa * f3));
                a.this.fF(true);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.ays();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class k extends m {
        private int cRY;
        private float cSf;
        private float cSg;
        private float cSh;
        private int cSi;
        private int cSj;
        private int cSk;
        private int cSl;

        public k(float f, int i) {
            super(f, i);
            this.cSi = -1;
            this.cSj = -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.cSi = -1;
            this.cSj = -1;
            this.cSk = a.this.cQO;
            this.cSl = a.this.cQP;
            this.cRY = a.this.cQR;
            a.this.mDragState = 1;
            this.cSf = a.this.cQH.x;
            if (a.this.cRD) {
                float width = a.this.mListView.getWidth() * 2.0f;
                if (a.this.cRE == 0.0f) {
                    a.this.cRE = (this.cSf >= 0.0f ? 1 : -1) * width;
                    return;
                }
                float f = width * 2.0f;
                if (a.this.cRE >= 0.0f || a.this.cRE <= (-f)) {
                    if (a.this.cRE > 0.0f && a.this.cRE < f) {
                        a.this.cRE = f;
                        return;
                    }
                    return;
                }
                a.this.cRE = -f;
                return;
            }
            a.this.ayA();
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void r(float f, float f2) {
            View childAt;
            float f3 = 1.0f - f2;
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            View childAt2 = a.this.mListView.getChildAt(this.cSk - firstVisiblePosition);
            if (a.this.cRD) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / 1000.0f;
                if (uptimeMillis != 0.0f) {
                    float f4 = a.this.cRE * uptimeMillis;
                    int width = a.this.mListView.getWidth();
                    a.this.cRE = ((a.this.cRE > 0.0f ? 1 : -1) * uptimeMillis * width) + a.this.cRE;
                    this.cSf += f4;
                    a.this.cQH.x = (int) this.cSf;
                    if (this.cSf < width && this.cSf > (-width)) {
                        this.mStartTime = SystemClock.uptimeMillis();
                        a.this.fF(true);
                        return;
                    }
                } else {
                    return;
                }
            }
            if (childAt2 != null) {
                if (this.cSi == -1) {
                    this.cSi = a.this.f(this.cSk, childAt2, false);
                    this.cSg = childAt2.getHeight() - this.cSi;
                }
                int max = Math.max((int) (this.cSg * f3), 1);
                ViewGroup.LayoutParams layoutParams = childAt2.getLayoutParams();
                layoutParams.height = max + this.cSi;
                childAt2.setLayoutParams(layoutParams);
            }
            if (this.cSl != this.cSk && (childAt = a.this.mListView.getChildAt(this.cSl - firstVisiblePosition)) != null) {
                if (this.cSj == -1) {
                    this.cSj = a.this.f(this.cSl, childAt, false);
                    this.cSh = childAt.getHeight() - this.cSj;
                }
                int max2 = Math.max((int) (this.cSh * f3), 1);
                ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
                layoutParams2.height = max2 + this.cSj;
                childAt.setLayoutParams(layoutParams2);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.ayt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class j extends m {
        final /* synthetic */ a cRJ;
        private float cSd;
        private float cSe;

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.cSd = this.cRJ.cQT;
            this.cSe = this.cRJ.cQZ;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void r(float f, float f2) {
            if (this.cRJ.mDragState != 4) {
                cancel();
                return;
            }
            this.cRJ.cQT = (int) ((this.cSe * f2) + ((1.0f - f2) * this.cSd));
            this.cRJ.cQH.y = this.cRJ.aGm - this.cRJ.cQT;
            this.cRJ.fF(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e {
        StringBuilder mBuilder = new StringBuilder();
        private int cRU = 0;
        private int cRV = 0;
        private boolean cRW = false;
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

        public void ayD() {
            this.mBuilder.append("<DSLVStates>\n");
            this.cRV = 0;
            this.cRW = true;
        }

        public void ayE() {
            if (this.cRW) {
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
                this.mBuilder.append("    <FirstExpPos>").append(a.this.cQO).append("</FirstExpPos>\n");
                this.mBuilder.append("    <FirstExpBlankHeight>").append(a.this.kq(a.this.cQO) - a.this.ks(a.this.cQO)).append("</FirstExpBlankHeight>\n");
                this.mBuilder.append("    <SecondExpPos>").append(a.this.cQP).append("</SecondExpPos>\n");
                this.mBuilder.append("    <SecondExpBlankHeight>").append(a.this.kq(a.this.cQP) - a.this.ks(a.this.cQP)).append("</SecondExpBlankHeight>\n");
                this.mBuilder.append("    <SrcPos>").append(a.this.cQR).append("</SrcPos>\n");
                this.mBuilder.append("    <SrcHeight>").append(a.this.bdm + a.this.mListView.getDividerHeight()).append("</SrcHeight>\n");
                this.mBuilder.append("    <ViewHeight>").append(a.this.mListView.getHeight()).append("</ViewHeight>\n");
                this.mBuilder.append("    <LastY>").append(a.this.mLastY).append("</LastY>\n");
                this.mBuilder.append("    <FloatY>").append(a.this.cQJ).append("</FloatY>\n");
                this.mBuilder.append("    <ShuffleEdges>");
                for (int i4 = 0; i4 < childCount; i4++) {
                    this.mBuilder.append(a.this.ap(firstVisiblePosition + i4, a.this.mListView.getChildAt(i4).getTop())).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                this.mBuilder.append("</ShuffleEdges>\n");
                this.mBuilder.append("</DSLVState>\n");
                this.cRU++;
                if (this.cRU > 1000) {
                    flush();
                    this.cRU = 0;
                }
            }
        }

        public void flush() {
            if (this.cRW) {
                try {
                    FileWriter fileWriter = new FileWriter(this.mFile, this.cRV != 0);
                    fileWriter.write(this.mBuilder.toString());
                    this.mBuilder.delete(0, this.mBuilder.length());
                    fileWriter.flush();
                    fileWriter.close();
                    this.cRV++;
                } catch (IOException e) {
                }
            }
        }

        public void stopTracking() {
            if (this.cRW) {
                this.mBuilder.append("</DSLVStates>\n");
                flush();
                this.cRW = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements Runnable {
        private boolean bgQ = false;
        private boolean cRM;
        private long cRN;
        private long cRO;
        private int cRP;
        private float cRQ;
        private long cRR;
        private int cRS;
        private float cRT;

        public boolean ayB() {
            return this.bgQ;
        }

        public int ayC() {
            if (this.bgQ) {
                return this.cRS;
            }
            return -1;
        }

        public d() {
        }

        public void kt(int i) {
            if (!this.bgQ) {
                this.cRM = false;
                this.bgQ = true;
                this.cRR = SystemClock.uptimeMillis();
                this.cRN = this.cRR;
                this.cRS = i;
                a.this.mListView.post(this);
            }
        }

        public void fG(boolean z) {
            if (z) {
                a.this.mListView.removeCallbacks(this);
                this.bgQ = false;
                return;
            }
            this.cRM = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.cRM) {
                int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
                int lastVisiblePosition = a.this.mListView.getLastVisiblePosition();
                int count = a.this.mListView.getCount();
                int paddingTop = a.this.mListView.getPaddingTop();
                int height = (a.this.mListView.getHeight() - paddingTop) - a.this.mListView.getPaddingBottom();
                int min = Math.min(a.this.aGm, a.this.cQJ + a.this.cQZ);
                int max = Math.max(a.this.aGm, a.this.cQJ - a.this.cQZ);
                if (this.cRS == 0) {
                    View childAt = a.this.mListView.getChildAt(0);
                    if (childAt == null) {
                        this.bgQ = false;
                        return;
                    } else if (firstVisiblePosition == 0 && childAt.getTop() == paddingTop) {
                        this.bgQ = false;
                        return;
                    } else {
                        this.cRT = a.this.cRl.b((a.this.cRh - max) / a.this.cRi, this.cRN);
                    }
                } else {
                    View childAt2 = a.this.mListView.getChildAt(lastVisiblePosition - firstVisiblePosition);
                    if (childAt2 == null) {
                        this.bgQ = false;
                        return;
                    } else if (lastVisiblePosition == count - 1 && childAt2.getBottom() <= height + paddingTop) {
                        this.bgQ = false;
                        return;
                    } else {
                        this.cRT = -a.this.cRl.b((min - a.this.cRg) / a.this.cRj, this.cRN);
                    }
                }
                this.cRO = SystemClock.uptimeMillis();
                this.cRQ = (float) (this.cRO - this.cRN);
                this.cRP = Math.round(this.cRT * this.cRQ);
                if (this.cRP >= 0) {
                    this.cRP = Math.min(height, this.cRP);
                    lastVisiblePosition = firstVisiblePosition;
                } else {
                    this.cRP = Math.max(-height, this.cRP);
                }
                View childAt3 = a.this.mListView.getChildAt(lastVisiblePosition - firstVisiblePosition);
                int top = childAt3.getTop() + this.cRP;
                if (lastVisiblePosition == 0 && top > paddingTop) {
                    top = paddingTop;
                }
                a.this.mBlockLayoutRequests = true;
                a.this.mListView.setSelectionFromTop(lastVisiblePosition, top - paddingTop);
                a.this.layoutChildren();
                a.this.mListView.invalidate();
                a.this.mBlockLayoutRequests = false;
                a.this.h(lastVisiblePosition, childAt3, false);
                this.cRN = this.cRO;
                a.this.mListView.post(this);
                return;
            }
            this.bgQ = false;
        }
    }
}
