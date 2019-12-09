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
    private int aFT;
    private int aFU;
    private int aGy;
    private int aGz;
    private int bcU;
    private View cPP;
    private int cPS;
    private int cPW;
    private int cPX;
    private int cPY;
    private MotionEvent cQA;
    private C0298a cQE;
    private e cQG;
    private k cQJ;
    private j cQK;
    private f cQL;
    private boolean cQM;
    private com.baidu.tbadk.widget.dragsort.d cQO;
    private com.baidu.tbadk.widget.dragsort.b cQP;
    private int cQa;
    private int cQb;
    private int cQc;
    private b cQd;
    private g cQe;
    private l cQf;
    private int cQi;
    private d cQk;
    private int cQn;
    private int cQo;
    private float cQp;
    private float cQq;
    private float cQr;
    private float cQs;
    private int cQv;
    private int mLastX;
    private int mLastY;
    private ListView mListView;
    private DataSetObserver mObserver;
    private Point cPQ = new Point();
    private Point cPR = new Point();
    private boolean cPT = false;
    private float cPU = 1.0f;
    private float cPV = 1.0f;
    private boolean cPZ = false;
    private boolean cQg = true;
    private int mDragState = 0;
    private int cQh = 1;
    private int mWidthMeasureSpec = 0;
    private View[] cQj = new View[1];
    private float cQl = 0.33333334f;
    private float cQm = 0.33333334f;
    private float cQt = 0.5f;
    private c cQu = new c() { // from class: com.baidu.tbadk.widget.dragsort.a.1
        @Override // com.baidu.tbadk.widget.dragsort.a.c
        public float b(float f2, long j2) {
            return a.this.cQt * f2;
        }
    };
    private int cQw = 0;
    private boolean cQx = false;
    private boolean cQy = false;
    private h cQz = null;
    private int cQB = 0;
    private float cQC = 0.25f;
    private float cQD = 0.0f;
    private boolean cQF = false;
    private boolean mBlockLayoutRequests = false;
    private boolean cQH = false;
    private i cQI = new i(3);
    private float cQN = 0.0f;
    private boolean cQQ = false;
    private boolean cQR = false;

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

        View kt(int i);
    }

    /* loaded from: classes.dex */
    public interface l {
        void remove(int i);
    }

    public a(ListView listView, com.baidu.tbadk.widget.dragsort.d dVar) {
        this.cQO = dVar;
        this.mListView = listView;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            this.cQE = new C0298a(listAdapter);
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
            this.cQE = null;
        }
        this.cQO.setAdapter(this.cQE);
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
            if (i2 > this.cQa) {
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
    public int kp(int i2) {
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        return childAt != null ? childAt.getHeight() : ap(i2, kr(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int an(int i2, int i3) {
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        if (i2 <= headerViewsCount || i2 >= this.mListView.getCount() - footerViewsCount) {
            return i3;
        }
        int dividerHeight = this.mListView.getDividerHeight();
        int i4 = this.bcU - this.cQh;
        int kr = kr(i2);
        int kp = kp(i2);
        if (this.cPY <= this.cQa) {
            if (i2 == this.cPY && this.cPX != this.cPY) {
                if (i2 == this.cQa) {
                    i3 = (i3 + kp) - this.bcU;
                } else {
                    i3 = ((kp - kr) + i3) - i4;
                }
            } else if (i2 > this.cPY && i2 <= this.cQa) {
                i3 -= i4;
            }
        } else if (i2 > this.cQa && i2 <= this.cPX) {
            i3 += i4;
        } else if (i2 == this.cPY && this.cPX != this.cPY) {
            i3 += kp - kr;
        }
        if (i2 <= this.cQa) {
            return (((this.bcU - dividerHeight) - kr(i2 - 1)) / 2) + i3;
        }
        return (((kr - dividerHeight) - this.bcU) / 2) + i3;
    }

    private boolean ayo() {
        int i2;
        int i3;
        int i4;
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int i5 = this.cPX;
        View childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        if (childAt == null) {
            i5 = firstVisiblePosition + (this.mListView.getChildCount() / 2);
            childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        }
        int top = childAt.getTop();
        int height = childAt.getHeight();
        int an = an(i5, top);
        int dividerHeight = this.mListView.getDividerHeight();
        if (this.cPS >= an) {
            int count = this.mListView.getCount();
            int i6 = height;
            int i7 = top;
            i2 = an;
            i3 = i5;
            i4 = an;
            while (true) {
                if (i3 < count) {
                    if (i3 == count - 1) {
                        i2 = i7 + dividerHeight + i6;
                        break;
                    }
                    i7 += dividerHeight + i6;
                    i6 = kp(i3 + 1);
                    i2 = an(i3 + 1, i7);
                    if (this.cPS < i2) {
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
            i2 = an;
            i3 = i5;
            i4 = an;
            while (true) {
                if (i3 < 0) {
                    break;
                }
                i3--;
                int kp = kp(i3);
                if (i3 == 0) {
                    i2 = (i8 - dividerHeight) - kp;
                    break;
                }
                i8 -= kp + dividerHeight;
                i2 = an(i3, i8);
                if (this.cPS >= i2) {
                    break;
                }
                i4 = i2;
            }
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int i9 = this.cPX;
        int i10 = this.cPY;
        float f2 = this.cQD;
        if (this.cPZ) {
            int abs = Math.abs(i2 - i4);
            if (this.cPS >= i2) {
                int i11 = i4;
                i4 = i2;
                i2 = i11;
            }
            int i12 = (int) (abs * this.cQC * 0.5f);
            float f3 = i12;
            int i13 = i4 + i12;
            int i14 = i2 - i12;
            if (this.cPS < i13) {
                this.cPX = i3 - 1;
                this.cPY = i3;
                this.cQD = ((i13 - this.cPS) * 0.5f) / f3;
            } else if (this.cPS < i14) {
                this.cPX = i3;
                this.cPY = i3;
            } else {
                this.cPX = i3;
                this.cPY = i3 + 1;
                this.cQD = (1.0f + ((i2 - this.cPS) / f3)) * 0.5f;
            }
        } else {
            this.cPX = i3;
            this.cPY = i3;
        }
        if (this.cPX < headerViewsCount) {
            this.cPX = headerViewsCount;
            this.cPY = headerViewsCount;
            i3 = headerViewsCount;
        } else if (this.cPY >= this.mListView.getCount() - footerViewsCount) {
            i3 = (this.mListView.getCount() - footerViewsCount) - 1;
            this.cPX = i3;
            this.cPY = i3;
        }
        boolean z = (this.cPX == i9 && this.cPY == i10 && this.cQD == f2) ? false : true;
        if (i3 != this.cPW) {
            if (this.cQd != null) {
                this.cQd.drag(this.cPW - headerViewsCount, i3 - headerViewsCount);
            }
            this.cPW = i3;
            return true;
        }
        return z;
    }

    public void removeItem(int i2) {
        this.cQM = false;
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
            this.cQh = Math.max(1, obtainStyledAttributes.getDimensionPixelSize(13, 1));
            this.cQF = obtainStyledAttributes.getBoolean(7, false);
            if (this.cQF) {
                this.cQG = new e();
            }
            this.cPU = obtainStyledAttributes.getFloat(11, this.cPU);
            this.cPV = this.cPU;
            this.cQg = obtainStyledAttributes.getBoolean(14, this.cQg);
            this.cQC = Math.max(0.0f, Math.min(1.0f, 1.0f - obtainStyledAttributes.getFloat(1, 0.75f)));
            this.cPZ = this.cQC > 0.0f;
            setDragScrollStart(obtainStyledAttributes.getFloat(15, this.cQl));
            this.cQt = obtainStyledAttributes.getFloat(0, this.cQt);
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
                this.cQz = bVar;
                a(bVar);
            }
            obtainStyledAttributes.recycle();
            i2 = i5;
            i3 = i4;
        }
        this.cQk = new d();
        if (i3 > 0) {
            this.cQJ = new k(0.5f, i3);
        }
        if (i2 > 0) {
            this.cQL = new f(0.5f, i2);
        }
        this.cQA = MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
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
        this.cQP = bVar;
        this.mListView.setOnTouchListener(bVar);
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void dispatchDraw(Canvas canvas) {
        float f2;
        this.cQO.dispatchDraw(canvas);
        if (this.mDragState != 0) {
            if (this.cPX != this.cQa) {
                b(this.cPX, canvas);
            }
            if (this.cPY != this.cPX && this.cPY != this.cQa) {
                b(this.cPY, canvas);
            }
        }
        if (this.cPP != null) {
            int width = this.cPP.getWidth();
            int height = this.cPP.getHeight();
            int i2 = this.cPQ.x;
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
            int i3 = (int) (f2 * 255.0f * this.cPV);
            canvas.save();
            canvas.translate(this.cPQ.x, this.cPQ.y);
            canvas.clipRect(0, 0, width, height);
            canvas.saveLayerAlpha(0.0f, 0.0f, width, height, i3, 31);
            this.cPP.draw(canvas);
            canvas.restore();
            canvas.restore();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onDraw(Canvas canvas) {
        this.cQO.onDraw(canvas);
        if (this.cQF) {
            this.cQG.ayC();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.cQH) {
            this.cQH = false;
            return false;
        } else if (!this.cQg) {
            return this.cQO.onTouchEvent(motionEvent);
        } else {
            boolean z2 = this.cQx;
            this.cQx = false;
            if (!z2) {
                s(motionEvent);
            }
            if (this.mDragState == 4) {
                onDragTouchEvent(motionEvent);
                return true;
            }
            if (this.mDragState == 0 && this.cQO.onTouchEvent(motionEvent)) {
                z = true;
            }
            switch (motionEvent.getAction() & 255) {
                case 1:
                case 3:
                    ayt();
                    return z;
                case 2:
                default:
                    if (z) {
                        this.cQB = 1;
                        return z;
                    }
                    return z;
            }
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (!this.cQg) {
            return this.cQO.onInterceptTouchEvent(motionEvent);
        }
        if (this.cQP != null) {
            this.cQP.ayE().onTouchEvent(motionEvent);
        }
        s(motionEvent);
        this.cQx = true;
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            if (this.mDragState != 0) {
                this.cQH = true;
                return true;
            }
            this.cQy = true;
        }
        if (this.cPP == null) {
            if (this.cQO.onInterceptTouchEvent(motionEvent)) {
                this.cQQ = true;
                z = true;
            } else {
                z = false;
            }
            switch (action) {
                case 1:
                case 3:
                    ayt();
                    break;
                case 2:
                default:
                    if (z) {
                        this.cQB = 1;
                        break;
                    } else {
                        this.cQB = 2;
                        break;
                    }
            }
        } else {
            z = true;
        }
        if (action == 1 || action == 3) {
            this.cQy = false;
        }
        return z;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        this.cQO.onSizeChanged(i2, i3, i4, i5);
        ayu();
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void requestLayout() {
        if (!this.mBlockLayoutRequests) {
            this.cQO.requestLayout();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onMeasure(int i2, int i3) {
        this.cQO.onMeasure(i2, i3);
        if (this.cPP != null) {
            if (this.cPP.isLayoutRequested()) {
                ayw();
            }
            this.cPT = true;
        }
        this.mWidthMeasureSpec = i2;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void layoutChildren() {
        this.cQO.layoutChildren();
        if (this.cPP != null) {
            if (this.cPP.isLayoutRequested() && !this.cPT) {
                ayw();
            }
            this.cPP.layout(0, 0, this.cPP.getMeasuredWidth(), this.cPP.getMeasuredHeight());
            this.cPT = false;
        }
    }

    public void removeItem(int i2, float f2) {
        if (this.mDragState == 0 || this.mDragState == 4) {
            if (this.mDragState == 0) {
                this.cQa = this.mListView.getHeaderViewsCount() + i2;
                this.cPX = this.cQa;
                this.cPY = this.cQa;
                this.cPW = this.cQa;
                View childAt = this.mListView.getChildAt(this.cQa - this.mListView.getFirstVisiblePosition());
                if (childAt != null) {
                    childAt.setVisibility(4);
                }
            }
            this.mDragState = 1;
            this.cQN = f2;
            if (this.cQy) {
                switch (this.cQB) {
                    case 1:
                        this.cQO.onTouchEvent(this.cQA);
                        break;
                    case 2:
                        this.cQO.onInterceptTouchEvent(this.cQA);
                        break;
                }
            }
            if (this.cQJ != null) {
                this.cQJ.start();
            } else {
                kq(i2);
            }
        }
    }

    public void cancelDrag() {
        if (this.mDragState == 4) {
            this.cQk.fG(true);
            ayy();
            ayp();
            ayv();
            if (this.cQy) {
                this.mDragState = 3;
            } else {
                this.mDragState = 0;
            }
        }
    }

    private void ayp() {
        this.cQa = -1;
        this.cPX = -1;
        this.cPY = -1;
        this.cPW = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayq() {
        this.mDragState = 2;
        if (this.cQe != null && this.cPW >= 0 && this.cPW < this.mListView.getCount()) {
            int headerViewsCount = this.mListView.getHeaderViewsCount();
            this.cQe.drop(this.cQa - headerViewsCount, this.cPW - headerViewsCount);
        }
        ayy();
        ays();
        ayp();
        ayv();
        if (this.cQy) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayr() {
        kq(this.cQa - this.mListView.getHeaderViewsCount());
    }

    private void kq(int i2) {
        this.mDragState = 1;
        if (this.cQf != null) {
            this.cQf.remove(i2);
        }
        ayy();
        ays();
        ayp();
        if (this.cQy) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    private void ays() {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        if (this.cQa < firstVisiblePosition) {
            View childAt = this.mListView.getChildAt(0);
            this.mListView.setSelectionFromTop(firstVisiblePosition - 1, (childAt != null ? childAt.getTop() : 0) - this.mListView.getPaddingTop());
        }
    }

    public boolean stopDrag(boolean z) {
        this.cQM = false;
        return stopDrag(z, 0.0f);
    }

    public boolean stopDragWithVelocity(boolean z, float f2) {
        this.cQM = true;
        return stopDrag(z, f2);
    }

    public boolean stopDrag(boolean z, float f2) {
        if (this.cPP != null) {
            this.cQk.fG(true);
            if (z) {
                removeItem(this.cQa - this.mListView.getHeaderViewsCount(), f2);
            } else if (this.cQL != null) {
                this.cQL.start();
            } else {
                ayq();
            }
            if (this.cQF) {
                this.cQG.stopTracking();
                return true;
            }
            return true;
        }
        return false;
    }

    private void ayt() {
        this.cQB = 0;
        this.cQy = false;
        if (this.mDragState == 3) {
            this.mDragState = 0;
        }
        this.cPV = this.cPU;
        this.cQQ = false;
        this.cQI.clear();
    }

    private void s(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            this.mLastX = this.aFT;
            this.mLastY = this.aFU;
        }
        this.aFT = (int) motionEvent.getX();
        this.aFU = (int) motionEvent.getY();
        if (action == 0) {
            this.mLastX = this.aFT;
            this.mLastY = this.aFU;
        }
        this.aGy = ((int) motionEvent.getRawX()) - this.aFT;
        this.aGz = ((int) motionEvent.getRawY()) - this.aFU;
    }

    public boolean listViewIntercepted() {
        return this.cQQ;
    }

    public void setDragScrollStart(float f2) {
        setDragScrollStarts(f2, f2);
    }

    public void setDragScrollStarts(float f2, float f3) {
        if (f3 > 0.5f) {
            this.cQm = 0.5f;
        } else {
            this.cQm = f3;
        }
        if (f2 > 0.5f) {
            this.cQl = 0.5f;
        } else {
            this.cQl = f2;
        }
        if (this.mListView.getHeight() != 0) {
            ayu();
        }
    }

    private void ao(int i2, int i3) {
        this.cPQ.x = i2 - this.cQb;
        this.cPQ.y = i3 - this.cQc;
        fF(true);
        int min = Math.min(i3, this.cPS + this.cQi);
        int max = Math.max(i3, this.cPS - this.cQi);
        int ayA = this.cQk.ayA();
        if (min > this.mLastY && min > this.cQo && ayA != 1) {
            if (ayA != -1) {
                this.cQk.fG(true);
            }
            this.cQk.ks(1);
        } else if (max < this.mLastY && max < this.cQn && ayA != 0) {
            if (ayA != -1) {
                this.cQk.fG(true);
            }
            this.cQk.ks(0);
        } else if (max >= this.cQn && min <= this.cQo && this.cQk.ayz()) {
            this.cQk.fG(true);
        }
    }

    private void ayu() {
        int height;
        int paddingTop = this.mListView.getPaddingTop();
        float height2 = (this.mListView.getHeight() - paddingTop) - this.mListView.getPaddingBottom();
        this.cQq = paddingTop + (this.cQl * height2);
        this.cQp = (height2 * (1.0f - this.cQm)) + paddingTop;
        this.cQn = (int) this.cQq;
        this.cQo = (int) this.cQp;
        this.cQr = this.cQq - paddingTop;
        this.cQs = (paddingTop + height) - this.cQp;
    }

    private void ayv() {
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
        if (i2 != this.cQa && i2 != this.cPX && i2 != this.cPY) {
            g2 = -2;
        } else {
            g2 = g(i2, view, z);
        }
        if (g2 != layoutParams.height) {
            layoutParams.height = g2;
            view.setLayoutParams(layoutParams);
        }
        if (i2 == this.cPX || i2 == this.cPY) {
            if (i2 < this.cQa) {
                ((DragSortItemView) view).setGravity(80);
            } else if (i2 > this.cQa) {
                ((DragSortItemView) view).setGravity(48);
            }
        }
        int visibility = view.getVisibility();
        int i3 = 0;
        if (i2 == this.cQa && this.cPP != null) {
            i3 = 4;
        }
        if (i3 != visibility) {
            view.setVisibility(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int kr(int i2) {
        View view;
        if (i2 == this.cQa) {
            return 0;
        }
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        if (childAt != null) {
            return f(i2, childAt, false);
        }
        int i3 = this.cQI.get(i2);
        if (i3 == -1) {
            ListAdapter adapter = this.mListView.getAdapter();
            int itemViewType = adapter.getItemViewType(i2);
            int viewTypeCount = adapter.getViewTypeCount();
            if (viewTypeCount != this.cQj.length) {
                this.cQj = new View[viewTypeCount];
            }
            if (itemViewType >= 0) {
                if (this.cQj[itemViewType] == null) {
                    view = adapter.getView(i2, null, this.mListView);
                    this.cQj[itemViewType] = view;
                } else {
                    view = adapter.getView(i2, this.cQj[itemViewType], this.mListView);
                }
            } else {
                view = adapter.getView(i2, null, this.mListView);
            }
            int f2 = f(i2, view, true);
            this.cQI.aq(i2, f2);
            return f2;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(int i2, View view, boolean z) {
        if (i2 == this.cQa) {
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
        return ap(i2, f(i2, view, z));
    }

    private int ap(int i2, int i3) {
        this.mListView.getDividerHeight();
        boolean z = this.cPZ && this.cPX != this.cPY;
        int i4 = this.bcU - this.cQh;
        int i5 = (int) (this.cQD * i4);
        if (i2 == this.cQa) {
            if (this.cQa == this.cPX) {
                if (z) {
                    return i5 + this.cQh;
                }
                return this.bcU;
            } else if (this.cQa == this.cPY) {
                return this.bcU - i5;
            } else {
                return this.cQh;
            }
        } else if (i2 == this.cPX) {
            if (z) {
                return i3 + i5;
            }
            return i3 + i4;
        } else if (i2 == this.cPY) {
            return (i3 + i4) - i5;
        } else {
            return i3;
        }
    }

    private int b(int i2, View view, int i3, int i4) {
        int i5;
        int i6;
        int kr = kr(i2);
        int height = view.getHeight();
        int ap = ap(i2, kr);
        if (i2 != this.cQa) {
            i6 = height - kr;
            i5 = ap - kr;
        } else {
            i5 = ap;
            i6 = height;
        }
        int i7 = this.bcU;
        if (this.cQa != this.cPX && this.cQa != this.cPY) {
            i7 -= this.cQh;
        }
        if (i2 <= i3) {
            if (i2 > this.cPX) {
                return (i7 - i5) + 0;
            }
        } else if (i2 == i4) {
            if (i2 <= this.cPX) {
                return (i6 - i7) + 0;
            }
            if (i2 == this.cPY) {
                return (height - ap) + 0;
            }
            return 0 + i6;
        } else if (i2 <= this.cPX) {
            return 0 - i7;
        } else {
            if (i2 == this.cPY) {
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

    private void ayw() {
        if (this.cPP != null) {
            measureItem(this.cPP);
            this.bcU = this.cPP.getMeasuredHeight();
            this.cQi = this.bcU / 2;
        }
    }

    protected boolean onDragTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        switch (motionEvent.getAction() & 255) {
            case 1:
                if (this.mDragState == 4) {
                    stopDrag(false);
                }
                ayt();
                return true;
            case 2:
                ao((int) motionEvent.getX(), (int) motionEvent.getY());
                return true;
            case 3:
                if (this.mDragState == 4) {
                    cancelDrag();
                }
                ayt();
                return true;
            default:
                return true;
        }
    }

    public boolean startDrag(int i2, int i3, int i4, int i5) {
        View kt;
        if (!this.cQy || this.cQz == null || (kt = this.cQz.kt(i2)) == null) {
            return false;
        }
        return startDrag(i2, kt, i3, i4, i5);
    }

    public boolean startDrag(int i2, View view, int i3, int i4, int i5) {
        if (this.mDragState == 0 && this.cQy && this.cPP == null && view != null && this.cQg) {
            if (this.mListView.getParent() != null) {
                this.mListView.getParent().requestDisallowInterceptTouchEvent(true);
            }
            int headerViewsCount = this.mListView.getHeaderViewsCount() + i2;
            this.cPX = headerViewsCount;
            this.cPY = headerViewsCount;
            this.cQa = headerViewsCount;
            this.cPW = headerViewsCount;
            this.mDragState = 4;
            this.cQw = 0;
            this.cQw |= i3;
            this.cPP = view;
            ayw();
            this.cQb = i4;
            this.cQc = i5;
            this.cQv = this.aFU;
            this.cPQ.x = this.aFT - this.cQb;
            this.cPQ.y = this.aFU - this.cQc;
            View childAt = this.mListView.getChildAt(this.cQa - this.mListView.getFirstVisiblePosition());
            if (childAt != null) {
                childAt.setVisibility(4);
            }
            if (this.cQF) {
                this.cQG.ayB();
            }
            switch (this.cQB) {
                case 1:
                    this.cQO.onTouchEvent(this.cQA);
                    break;
                case 2:
                    this.cQO.onInterceptTouchEvent(this.cQA);
                    break;
            }
            this.mListView.requestLayout();
            if (this.cQK != null) {
                this.cQK.start();
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
        ayx();
        int i3 = this.cPX;
        int i4 = this.cPY;
        boolean ayo = ayo();
        if (ayo) {
            ayv();
            this.mListView.setSelectionFromTop(i2, (b(i2, view, i3, i4) + view.getTop()) - this.mListView.getPaddingTop());
            layoutChildren();
        }
        if (ayo || z) {
            this.mListView.invalidate();
        }
        this.mBlockLayoutRequests = false;
    }

    private void ayx() {
        if (this.cQz != null) {
            this.cPR.set(this.aFT, this.aFU);
            this.cQz.b(this.cPP, this.cPQ, this.cPR);
        }
        int i2 = this.cPQ.x;
        int i3 = this.cPQ.y;
        int paddingLeft = this.mListView.getPaddingLeft();
        if ((this.cQw & 1) == 0 && i2 > paddingLeft) {
            this.cPQ.x = paddingLeft;
        } else if ((this.cQw & 2) == 0 && i2 < paddingLeft) {
            this.cPQ.x = paddingLeft;
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int lastVisiblePosition = this.mListView.getLastVisiblePosition();
        int paddingTop = this.mListView.getPaddingTop();
        if (firstVisiblePosition < headerViewsCount) {
            paddingTop = this.mListView.getChildAt((headerViewsCount - firstVisiblePosition) - 1).getBottom();
        }
        if ((this.cQw & 8) == 0 && firstVisiblePosition <= this.cQa) {
            paddingTop = Math.max(this.mListView.getChildAt(this.cQa - firstVisiblePosition).getTop(), paddingTop);
        }
        int height = this.mListView.getHeight() - this.mListView.getPaddingBottom();
        if (lastVisiblePosition >= (this.mListView.getCount() - footerViewsCount) - 1) {
            height = this.mListView.getChildAt(((this.mListView.getCount() - footerViewsCount) - 1) - firstVisiblePosition).getBottom();
        }
        if ((this.cQw & 4) == 0 && lastVisiblePosition >= this.cQa) {
            height = Math.min(this.mListView.getChildAt(this.cQa - firstVisiblePosition).getBottom(), height);
        }
        if (i3 < paddingTop) {
            this.cPQ.y = paddingTop;
        } else if (this.bcU + i3 > height) {
            this.cPQ.y = height - this.bcU;
        }
        this.cPS = this.cPQ.y + this.cQi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayy() {
        if (this.cPP != null) {
            this.cPP.setVisibility(8);
            if (this.cQz != null) {
                this.cQz.bi(this.cPP);
            }
            this.cPP = null;
            this.mListView.invalidate();
        }
    }

    public void a(h hVar) {
        this.cQz = hVar;
    }

    public void a(b bVar) {
        this.cQd = bVar;
    }

    public void setDragEnabled(boolean z) {
        this.cQg = z;
    }

    public boolean isDragEnabled() {
        return this.cQg;
    }

    public void a(g gVar) {
        this.cQe = gVar;
    }

    public void a(l lVar) {
        this.cQf = lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class i {
        private SparseIntArray cRk;
        private ArrayList<Integer> cRl;
        private int mMaxSize;

        public i(int i) {
            this.cRk = new SparseIntArray(i);
            this.cRl = new ArrayList<>(i);
            this.mMaxSize = i;
        }

        public void aq(int i, int i2) {
            int i3 = this.cRk.get(i, -1);
            if (i3 != i2) {
                if (i3 == -1) {
                    if (this.cRk.size() == this.mMaxSize) {
                        this.cRk.delete(this.cRl.remove(0).intValue());
                    }
                } else {
                    this.cRl.remove(Integer.valueOf(i));
                }
                this.cRk.put(i, i2);
                this.cRl.add(Integer.valueOf(i));
            }
        }

        public int get(int i) {
            return this.cRk.get(i, -1);
        }

        public void clear() {
            this.cRk.clear();
            this.cRl.clear();
        }
    }

    /* renamed from: com.baidu.tbadk.widget.dragsort.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0298a extends BaseAdapter {
        private ListAdapter mAdapter;

        public C0298a(ListAdapter listAdapter) {
            this.mAdapter = listAdapter;
            this.mAdapter.registerDataSetObserver(new DataSetObserver() { // from class: com.baidu.tbadk.widget.dragsort.a.a.1
                @Override // android.database.DataSetObserver
                public void onChanged() {
                    C0298a.this.notifyDataSetChanged();
                }

                @Override // android.database.DataSetObserver
                public void onInvalidated() {
                    C0298a.this.notifyDataSetInvalidated();
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
        private float aGs;
        private float aGt;
        private float aGu;
        private float aGv;
        private float cRv;
        private float mAlpha;
        private boolean mCanceled;
        protected long mStartTime;

        public m(float f, int i) {
            this.mAlpha = f;
            this.cRv = i;
            float f2 = 1.0f / ((this.mAlpha * 2.0f) * (1.0f - this.mAlpha));
            this.aGv = f2;
            this.aGs = f2;
            this.aGt = this.mAlpha / ((this.mAlpha - 1.0f) * 2.0f);
            this.aGu = 1.0f / (1.0f - this.mAlpha);
        }

        public float ae(float f) {
            if (f < this.mAlpha) {
                return this.aGs * f * f;
            }
            if (f < 1.0f - this.mAlpha) {
                return this.aGt + (this.aGu * f);
            }
            return 1.0f - ((this.aGv * (f - 1.0f)) * (f - 1.0f));
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
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / this.cRv;
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
        private int cRg;
        private int cRh;
        private float cRi;
        private float cRj;

        public f(float f, int i) {
            super(f, i);
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.cRg = a.this.cPW;
            this.cRh = a.this.cQa;
            a.this.mDragState = 2;
            this.cRi = a.this.cPQ.y - ayD();
            this.cRj = a.this.cPQ.x - a.this.mListView.getPaddingLeft();
        }

        private int ayD() {
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            int dividerHeight = (a.this.cQh + a.this.mListView.getDividerHeight()) / 2;
            View childAt = a.this.mListView.getChildAt(this.cRg - firstVisiblePosition);
            if (childAt != null) {
                if (this.cRg == this.cRh) {
                    return childAt.getTop();
                }
                if (this.cRg >= this.cRh) {
                    return (childAt.getBottom() + dividerHeight) - a.this.bcU;
                }
                return childAt.getTop() - dividerHeight;
            }
            cancel();
            return -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void r(float f, float f2) {
            int ayD = ayD();
            float paddingLeft = a.this.cPQ.x - a.this.mListView.getPaddingLeft();
            float f3 = 1.0f - f2;
            if (f3 < Math.abs((a.this.cPQ.y - ayD) / this.cRi) || f3 < Math.abs(paddingLeft / this.cRj)) {
                a.this.cPQ.y = ayD + ((int) (this.cRi * f3));
                a.this.cPQ.x = a.this.mListView.getPaddingLeft() + ((int) (this.cRj * f3));
                a.this.fF(true);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.ayq();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class k extends m {
        private int cRh;
        private float cRo;
        private float cRp;
        private float cRq;
        private int cRr;
        private int cRs;
        private int cRt;
        private int cRu;

        public k(float f, int i) {
            super(f, i);
            this.cRr = -1;
            this.cRs = -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.cRr = -1;
            this.cRs = -1;
            this.cRt = a.this.cPX;
            this.cRu = a.this.cPY;
            this.cRh = a.this.cQa;
            a.this.mDragState = 1;
            this.cRo = a.this.cPQ.x;
            if (a.this.cQM) {
                float width = a.this.mListView.getWidth() * 2.0f;
                if (a.this.cQN == 0.0f) {
                    a.this.cQN = (this.cRo >= 0.0f ? 1 : -1) * width;
                    return;
                }
                float f = width * 2.0f;
                if (a.this.cQN >= 0.0f || a.this.cQN <= (-f)) {
                    if (a.this.cQN > 0.0f && a.this.cQN < f) {
                        a.this.cQN = f;
                        return;
                    }
                    return;
                }
                a.this.cQN = -f;
                return;
            }
            a.this.ayy();
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void r(float f, float f2) {
            View childAt;
            float f3 = 1.0f - f2;
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            View childAt2 = a.this.mListView.getChildAt(this.cRt - firstVisiblePosition);
            if (a.this.cQM) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / 1000.0f;
                if (uptimeMillis != 0.0f) {
                    float f4 = a.this.cQN * uptimeMillis;
                    int width = a.this.mListView.getWidth();
                    a.this.cQN = ((a.this.cQN > 0.0f ? 1 : -1) * uptimeMillis * width) + a.this.cQN;
                    this.cRo += f4;
                    a.this.cPQ.x = (int) this.cRo;
                    if (this.cRo < width && this.cRo > (-width)) {
                        this.mStartTime = SystemClock.uptimeMillis();
                        a.this.fF(true);
                        return;
                    }
                } else {
                    return;
                }
            }
            if (childAt2 != null) {
                if (this.cRr == -1) {
                    this.cRr = a.this.f(this.cRt, childAt2, false);
                    this.cRp = childAt2.getHeight() - this.cRr;
                }
                int max = Math.max((int) (this.cRp * f3), 1);
                ViewGroup.LayoutParams layoutParams = childAt2.getLayoutParams();
                layoutParams.height = max + this.cRr;
                childAt2.setLayoutParams(layoutParams);
            }
            if (this.cRu != this.cRt && (childAt = a.this.mListView.getChildAt(this.cRu - firstVisiblePosition)) != null) {
                if (this.cRs == -1) {
                    this.cRs = a.this.f(this.cRu, childAt, false);
                    this.cRq = childAt.getHeight() - this.cRs;
                }
                int max2 = Math.max((int) (this.cRq * f3), 1);
                ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
                layoutParams2.height = max2 + this.cRs;
                childAt.setLayoutParams(layoutParams2);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.ayr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class j extends m {
        final /* synthetic */ a cQS;
        private float cRm;
        private float cRn;

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.cRm = this.cQS.cQc;
            this.cRn = this.cQS.cQi;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void r(float f, float f2) {
            if (this.cQS.mDragState != 4) {
                cancel();
                return;
            }
            this.cQS.cQc = (int) ((this.cRn * f2) + ((1.0f - f2) * this.cRm));
            this.cQS.cPQ.y = this.cQS.aFU - this.cQS.cQc;
            this.cQS.fF(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e {
        StringBuilder mBuilder = new StringBuilder();
        private int cRd = 0;
        private int cRe = 0;
        private boolean cRf = false;
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

        public void ayB() {
            this.mBuilder.append("<DSLVStates>\n");
            this.cRe = 0;
            this.cRf = true;
        }

        public void ayC() {
            if (this.cRf) {
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
                this.mBuilder.append("    <FirstExpPos>").append(a.this.cPX).append("</FirstExpPos>\n");
                this.mBuilder.append("    <FirstExpBlankHeight>").append(a.this.kp(a.this.cPX) - a.this.kr(a.this.cPX)).append("</FirstExpBlankHeight>\n");
                this.mBuilder.append("    <SecondExpPos>").append(a.this.cPY).append("</SecondExpPos>\n");
                this.mBuilder.append("    <SecondExpBlankHeight>").append(a.this.kp(a.this.cPY) - a.this.kr(a.this.cPY)).append("</SecondExpBlankHeight>\n");
                this.mBuilder.append("    <SrcPos>").append(a.this.cQa).append("</SrcPos>\n");
                this.mBuilder.append("    <SrcHeight>").append(a.this.bcU + a.this.mListView.getDividerHeight()).append("</SrcHeight>\n");
                this.mBuilder.append("    <ViewHeight>").append(a.this.mListView.getHeight()).append("</ViewHeight>\n");
                this.mBuilder.append("    <LastY>").append(a.this.mLastY).append("</LastY>\n");
                this.mBuilder.append("    <FloatY>").append(a.this.cPS).append("</FloatY>\n");
                this.mBuilder.append("    <ShuffleEdges>");
                for (int i4 = 0; i4 < childCount; i4++) {
                    this.mBuilder.append(a.this.an(firstVisiblePosition + i4, a.this.mListView.getChildAt(i4).getTop())).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                this.mBuilder.append("</ShuffleEdges>\n");
                this.mBuilder.append("</DSLVState>\n");
                this.cRd++;
                if (this.cRd > 1000) {
                    flush();
                    this.cRd = 0;
                }
            }
        }

        public void flush() {
            if (this.cRf) {
                try {
                    FileWriter fileWriter = new FileWriter(this.mFile, this.cRe != 0);
                    fileWriter.write(this.mBuilder.toString());
                    this.mBuilder.delete(0, this.mBuilder.length());
                    fileWriter.flush();
                    fileWriter.close();
                    this.cRe++;
                } catch (IOException e) {
                }
            }
        }

        public void stopTracking() {
            if (this.cRf) {
                this.mBuilder.append("</DSLVStates>\n");
                flush();
                this.cRf = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements Runnable {
        private boolean bgy = false;
        private boolean cQV;
        private long cQW;
        private long cQX;
        private int cQY;
        private float cQZ;
        private long cRa;
        private int cRb;
        private float cRc;

        public boolean ayz() {
            return this.bgy;
        }

        public int ayA() {
            if (this.bgy) {
                return this.cRb;
            }
            return -1;
        }

        public d() {
        }

        public void ks(int i) {
            if (!this.bgy) {
                this.cQV = false;
                this.bgy = true;
                this.cRa = SystemClock.uptimeMillis();
                this.cQW = this.cRa;
                this.cRb = i;
                a.this.mListView.post(this);
            }
        }

        public void fG(boolean z) {
            if (z) {
                a.this.mListView.removeCallbacks(this);
                this.bgy = false;
                return;
            }
            this.cQV = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.cQV) {
                int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
                int lastVisiblePosition = a.this.mListView.getLastVisiblePosition();
                int count = a.this.mListView.getCount();
                int paddingTop = a.this.mListView.getPaddingTop();
                int height = (a.this.mListView.getHeight() - paddingTop) - a.this.mListView.getPaddingBottom();
                int min = Math.min(a.this.aFU, a.this.cPS + a.this.cQi);
                int max = Math.max(a.this.aFU, a.this.cPS - a.this.cQi);
                if (this.cRb == 0) {
                    View childAt = a.this.mListView.getChildAt(0);
                    if (childAt == null) {
                        this.bgy = false;
                        return;
                    } else if (firstVisiblePosition == 0 && childAt.getTop() == paddingTop) {
                        this.bgy = false;
                        return;
                    } else {
                        this.cRc = a.this.cQu.b((a.this.cQq - max) / a.this.cQr, this.cQW);
                    }
                } else {
                    View childAt2 = a.this.mListView.getChildAt(lastVisiblePosition - firstVisiblePosition);
                    if (childAt2 == null) {
                        this.bgy = false;
                        return;
                    } else if (lastVisiblePosition == count - 1 && childAt2.getBottom() <= height + paddingTop) {
                        this.bgy = false;
                        return;
                    } else {
                        this.cRc = -a.this.cQu.b((min - a.this.cQp) / a.this.cQs, this.cQW);
                    }
                }
                this.cQX = SystemClock.uptimeMillis();
                this.cQZ = (float) (this.cQX - this.cQW);
                this.cQY = Math.round(this.cRc * this.cQZ);
                if (this.cQY >= 0) {
                    this.cQY = Math.min(height, this.cQY);
                    lastVisiblePosition = firstVisiblePosition;
                } else {
                    this.cQY = Math.max(-height, this.cQY);
                }
                View childAt3 = a.this.mListView.getChildAt(lastVisiblePosition - firstVisiblePosition);
                int top = childAt3.getTop() + this.cQY;
                if (lastVisiblePosition == 0 && top > paddingTop) {
                    top = paddingTop;
                }
                a.this.mBlockLayoutRequests = true;
                a.this.mListView.setSelectionFromTop(lastVisiblePosition, top - paddingTop);
                a.this.layoutChildren();
                a.this.mListView.invalidate();
                a.this.mBlockLayoutRequests = false;
                a.this.h(lastVisiblePosition, childAt3, false);
                this.cQW = this.cQX;
                a.this.mListView.post(this);
                return;
            }
            this.bgy = false;
        }
    }
}
