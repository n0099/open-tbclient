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
    private int cvC;
    private View exK;
    private int exN;
    private int exR;
    private int exS;
    private int exT;
    private int exV;
    private int exW;
    private int exX;
    private b exY;
    private g exZ;
    private C0497a eyA;
    private e eyC;
    private k eyF;
    private j eyG;
    private f eyH;
    private boolean eyI;
    private com.baidu.tbadk.widget.dragsort.d eyK;
    private com.baidu.tbadk.widget.dragsort.b eyL;
    private l eya;
    private int eyc;
    private d eyf;
    private int eyi;
    private int eyj;
    private float eyk;
    private float eyl;
    private float eyn;
    private float eyo;
    private int eyr;
    private MotionEvent eyw;
    private int mLastX;
    private int mLastY;
    private ListView mListView;
    private DataSetObserver mObserver;
    private int mOffsetX;
    private int mOffsetY;
    private int mX;
    private int mY;
    private Point exL = new Point();
    private Point exM = new Point();
    private boolean exO = false;
    private float exP = 1.0f;
    private float exQ = 1.0f;
    private boolean exU = false;
    private boolean cLC = true;
    private int mDragState = 0;
    private int eyb = 1;
    private int mWidthMeasureSpec = 0;
    private View[] eyd = new View[1];
    private float eyg = 0.33333334f;
    private float eyh = 0.33333334f;
    private float eyp = 0.5f;
    private c eyq = new c() { // from class: com.baidu.tbadk.widget.dragsort.a.1
        @Override // com.baidu.tbadk.widget.dragsort.a.c
        public float b(float f2, long j2) {
            return a.this.eyp * f2;
        }
    };
    private int eys = 0;
    private boolean eyt = false;
    private boolean eyu = false;
    private h eyv = null;
    private int eyx = 0;
    private float eyy = 0.25f;
    private float eyz = 0.0f;
    private boolean eyB = false;
    private boolean mBlockLayoutRequests = false;
    private boolean eyD = false;
    private i eyE = new i(3);
    private float eyJ = 0.0f;
    private boolean eyM = false;
    private boolean eyN = false;

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

        void bl(View view);

        View nS(int i);
    }

    /* loaded from: classes.dex */
    public interface l {
        void remove(int i);
    }

    public a(ListView listView, com.baidu.tbadk.widget.dragsort.d dVar) {
        this.eyK = dVar;
        this.mListView = listView;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            this.eyA = new C0497a(listAdapter);
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
            this.eyA = null;
        }
        this.eyK.setAdapter(this.eyA);
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
            if (i2 > this.exV) {
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
    public int nO(int i2) {
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        return childAt != null ? childAt.getHeight() : aW(i2, nQ(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aU(int i2, int i3) {
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        if (i2 <= headerViewsCount || i2 >= this.mListView.getCount() - footerViewsCount) {
            return i3;
        }
        int dividerHeight = this.mListView.getDividerHeight();
        int i4 = this.cvC - this.eyb;
        int nQ = nQ(i2);
        int nO = nO(i2);
        if (this.exT <= this.exV) {
            if (i2 == this.exT && this.exS != this.exT) {
                if (i2 == this.exV) {
                    i3 = (i3 + nO) - this.cvC;
                } else {
                    i3 = ((nO - nQ) + i3) - i4;
                }
            } else if (i2 > this.exT && i2 <= this.exV) {
                i3 -= i4;
            }
        } else if (i2 > this.exV && i2 <= this.exS) {
            i3 += i4;
        } else if (i2 == this.exT && this.exS != this.exT) {
            i3 += nO - nQ;
        }
        if (i2 <= this.exV) {
            return (((this.cvC - dividerHeight) - nQ(i2 - 1)) / 2) + i3;
        }
        return (((nQ - dividerHeight) - this.cvC) / 2) + i3;
    }

    private boolean bhA() {
        int i2;
        int i3;
        int i4;
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int i5 = this.exS;
        View childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        if (childAt == null) {
            i5 = firstVisiblePosition + (this.mListView.getChildCount() / 2);
            childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        }
        int top2 = childAt.getTop();
        int height = childAt.getHeight();
        int aU = aU(i5, top2);
        int dividerHeight = this.mListView.getDividerHeight();
        if (this.exN >= aU) {
            int count = this.mListView.getCount();
            int i6 = height;
            int i7 = top2;
            i2 = aU;
            i3 = i5;
            i4 = aU;
            while (true) {
                if (i3 < count) {
                    if (i3 == count - 1) {
                        i2 = i7 + dividerHeight + i6;
                        break;
                    }
                    i7 += dividerHeight + i6;
                    i6 = nO(i3 + 1);
                    i2 = aU(i3 + 1, i7);
                    if (this.exN < i2) {
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
            i2 = aU;
            i3 = i5;
            i4 = aU;
            while (true) {
                if (i3 < 0) {
                    break;
                }
                i3--;
                int nO = nO(i3);
                if (i3 == 0) {
                    i2 = (i8 - dividerHeight) - nO;
                    break;
                }
                i8 -= nO + dividerHeight;
                i2 = aU(i3, i8);
                if (this.exN >= i2) {
                    break;
                }
                i4 = i2;
            }
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int i9 = this.exS;
        int i10 = this.exT;
        float f2 = this.eyz;
        if (this.exU) {
            int abs = Math.abs(i2 - i4);
            if (this.exN >= i2) {
                int i11 = i4;
                i4 = i2;
                i2 = i11;
            }
            int i12 = (int) (abs * this.eyy * 0.5f);
            float f3 = i12;
            int i13 = i4 + i12;
            int i14 = i2 - i12;
            if (this.exN < i13) {
                this.exS = i3 - 1;
                this.exT = i3;
                this.eyz = ((i13 - this.exN) * 0.5f) / f3;
            } else if (this.exN < i14) {
                this.exS = i3;
                this.exT = i3;
            } else {
                this.exS = i3;
                this.exT = i3 + 1;
                this.eyz = (1.0f + ((i2 - this.exN) / f3)) * 0.5f;
            }
        } else {
            this.exS = i3;
            this.exT = i3;
        }
        if (this.exS < headerViewsCount) {
            this.exS = headerViewsCount;
            this.exT = headerViewsCount;
            i3 = headerViewsCount;
        } else if (this.exT >= this.mListView.getCount() - footerViewsCount) {
            i3 = (this.mListView.getCount() - footerViewsCount) - 1;
            this.exS = i3;
            this.exT = i3;
        }
        boolean z = (this.exS == i9 && this.exT == i10 && this.eyz == f2) ? false : true;
        if (i3 != this.exR) {
            if (this.exY != null) {
                this.exY.drag(this.exR - headerViewsCount, i3 - headerViewsCount);
            }
            this.exR = i3;
            return true;
        }
        return z;
    }

    public void removeItem(int i2) {
        this.eyI = false;
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
            this.eyb = Math.max(1, obtainStyledAttributes.getDimensionPixelSize(12, 1));
            this.eyB = obtainStyledAttributes.getBoolean(6, false);
            if (this.eyB) {
                this.eyC = new e();
            }
            this.exP = obtainStyledAttributes.getFloat(10, this.exP);
            this.exQ = this.exP;
            this.cLC = obtainStyledAttributes.getBoolean(13, this.cLC);
            this.eyy = Math.max(0.0f, Math.min(1.0f, 1.0f - obtainStyledAttributes.getFloat(2, 0.75f)));
            this.exU = this.eyy > 0.0f;
            setDragScrollStart(obtainStyledAttributes.getFloat(14, this.eyg));
            this.eyp = obtainStyledAttributes.getFloat(0, this.eyp);
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
                bVar.iE(z);
                bVar.iD(z2);
                bVar.setBackgroundColor(color);
                this.eyv = bVar;
                a(bVar);
            }
            obtainStyledAttributes.recycle();
            i2 = i5;
            i3 = i4;
        }
        this.eyf = new d();
        if (i3 > 0) {
            this.eyF = new k(0.5f, i3);
        }
        if (i2 > 0) {
            this.eyH = new f(0.5f, i2);
        }
        this.eyw = MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
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
        this.eyL = bVar;
        this.mListView.setOnTouchListener(bVar);
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void dispatchDraw(Canvas canvas) {
        float f2;
        this.eyK.dispatchDraw(canvas);
        if (this.mDragState != 0) {
            if (this.exS != this.exV) {
                b(this.exS, canvas);
            }
            if (this.exT != this.exS && this.exT != this.exV) {
                b(this.exT, canvas);
            }
        }
        if (this.exK != null) {
            int width = this.exK.getWidth();
            int height = this.exK.getHeight();
            int i2 = this.exL.x;
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
            int i3 = (int) (f2 * 255.0f * this.exQ);
            canvas.save();
            canvas.translate(this.exL.x, this.exL.y);
            canvas.clipRect(0, 0, width, height);
            canvas.saveLayerAlpha(0.0f, 0.0f, width, height, i3, 31);
            this.exK.draw(canvas);
            canvas.restore();
            canvas.restore();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onDraw(Canvas canvas) {
        this.eyK.onDraw(canvas);
        if (this.eyB) {
            this.eyC.bhN();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.eyD) {
            this.eyD = false;
            return false;
        } else if (!this.cLC) {
            return this.eyK.onTouchEvent(motionEvent);
        } else {
            boolean z2 = this.eyt;
            this.eyt = false;
            if (!z2) {
                r(motionEvent);
            }
            if (this.mDragState == 4) {
                onDragTouchEvent(motionEvent);
                return true;
            }
            if (this.mDragState == 0 && this.eyK.onTouchEvent(motionEvent)) {
                z = true;
            }
            switch (motionEvent.getAction() & 255) {
                case 1:
                case 3:
                    bhF();
                    return z;
                case 2:
                default:
                    if (z) {
                        this.eyx = 1;
                        return z;
                    }
                    return z;
            }
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (!this.cLC) {
            return this.eyK.onInterceptTouchEvent(motionEvent);
        }
        if (this.eyL != null) {
            this.eyL.bhP().onTouchEvent(motionEvent);
        }
        r(motionEvent);
        this.eyt = true;
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            if (this.mDragState != 0) {
                this.eyD = true;
                return true;
            }
            this.eyu = true;
        }
        if (this.exK == null) {
            if (this.eyK.onInterceptTouchEvent(motionEvent)) {
                this.eyM = true;
                z = true;
            } else {
                z = false;
            }
            switch (action) {
                case 1:
                case 3:
                    bhF();
                    break;
                case 2:
                default:
                    if (z) {
                        this.eyx = 1;
                        break;
                    } else {
                        this.eyx = 2;
                        break;
                    }
            }
        } else {
            z = true;
        }
        if (action == 1 || action == 3) {
            this.eyu = false;
        }
        return z;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        this.eyK.onSizeChanged(i2, i3, i4, i5);
        bhG();
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void requestLayout() {
        if (!this.mBlockLayoutRequests) {
            this.eyK.requestLayout();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onMeasure(int i2, int i3) {
        this.eyK.onMeasure(i2, i3);
        if (this.exK != null) {
            if (this.exK.isLayoutRequested()) {
                bhI();
            }
            this.exO = true;
        }
        this.mWidthMeasureSpec = i2;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void layoutChildren() {
        this.eyK.layoutChildren();
        if (this.exK != null) {
            if (this.exK.isLayoutRequested() && !this.exO) {
                bhI();
            }
            this.exK.layout(0, 0, this.exK.getMeasuredWidth(), this.exK.getMeasuredHeight());
            this.exO = false;
        }
    }

    public void removeItem(int i2, float f2) {
        if (this.mDragState == 0 || this.mDragState == 4) {
            if (this.mDragState == 0) {
                this.exV = this.mListView.getHeaderViewsCount() + i2;
                this.exS = this.exV;
                this.exT = this.exV;
                this.exR = this.exV;
                View childAt = this.mListView.getChildAt(this.exV - this.mListView.getFirstVisiblePosition());
                if (childAt != null) {
                    childAt.setVisibility(4);
                }
            }
            this.mDragState = 1;
            this.eyJ = f2;
            if (this.eyu) {
                switch (this.eyx) {
                    case 1:
                        this.eyK.onTouchEvent(this.eyw);
                        break;
                    case 2:
                        this.eyK.onInterceptTouchEvent(this.eyw);
                        break;
                }
            }
            if (this.eyF != null) {
                this.eyF.start();
            } else {
                nP(i2);
            }
        }
    }

    public void cancelDrag() {
        if (this.mDragState == 4) {
            this.eyf.iC(true);
            bhK();
            bhB();
            bhH();
            if (this.eyu) {
                this.mDragState = 3;
            } else {
                this.mDragState = 0;
            }
        }
    }

    private void bhB() {
        this.exV = -1;
        this.exS = -1;
        this.exT = -1;
        this.exR = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhC() {
        this.mDragState = 2;
        if (this.exZ != null && this.exR >= 0 && this.exR < this.mListView.getCount()) {
            int headerViewsCount = this.mListView.getHeaderViewsCount();
            this.exZ.drop(this.exV - headerViewsCount, this.exR - headerViewsCount);
        }
        bhK();
        bhE();
        bhB();
        bhH();
        if (this.eyu) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhD() {
        nP(this.exV - this.mListView.getHeaderViewsCount());
    }

    private void nP(int i2) {
        this.mDragState = 1;
        if (this.eya != null) {
            this.eya.remove(i2);
        }
        bhK();
        bhE();
        bhB();
        if (this.eyu) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    private void bhE() {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        if (this.exV < firstVisiblePosition) {
            View childAt = this.mListView.getChildAt(0);
            this.mListView.setSelectionFromTop(firstVisiblePosition - 1, (childAt != null ? childAt.getTop() : 0) - this.mListView.getPaddingTop());
        }
    }

    public boolean stopDrag(boolean z) {
        this.eyI = false;
        return stopDrag(z, 0.0f);
    }

    public boolean stopDragWithVelocity(boolean z, float f2) {
        this.eyI = true;
        return stopDrag(z, f2);
    }

    public boolean stopDrag(boolean z, float f2) {
        if (this.exK != null) {
            this.eyf.iC(true);
            if (z) {
                removeItem(this.exV - this.mListView.getHeaderViewsCount(), f2);
            } else if (this.eyH != null) {
                this.eyH.start();
            } else {
                bhC();
            }
            if (this.eyB) {
                this.eyC.stopTracking();
                return true;
            }
            return true;
        }
        return false;
    }

    private void bhF() {
        this.eyx = 0;
        this.eyu = false;
        if (this.mDragState == 3) {
            this.mDragState = 0;
        }
        this.exQ = this.exP;
        this.eyM = false;
        this.eyE.clear();
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
        return this.eyM;
    }

    public void setDragScrollStart(float f2) {
        setDragScrollStarts(f2, f2);
    }

    public void setDragScrollStarts(float f2, float f3) {
        if (f3 > 0.5f) {
            this.eyh = 0.5f;
        } else {
            this.eyh = f3;
        }
        if (f2 > 0.5f) {
            this.eyg = 0.5f;
        } else {
            this.eyg = f2;
        }
        if (this.mListView.getHeight() != 0) {
            bhG();
        }
    }

    private void aV(int i2, int i3) {
        this.exL.x = i2 - this.exW;
        this.exL.y = i3 - this.exX;
        iB(true);
        int min = Math.min(i3, this.exN + this.eyc);
        int max = Math.max(i3, this.exN - this.eyc);
        int bhL = this.eyf.bhL();
        if (min > this.mLastY && min > this.eyj && bhL != 1) {
            if (bhL != -1) {
                this.eyf.iC(true);
            }
            this.eyf.nR(1);
        } else if (max < this.mLastY && max < this.eyi && bhL != 0) {
            if (bhL != -1) {
                this.eyf.iC(true);
            }
            this.eyf.nR(0);
        } else if (max >= this.eyi && min <= this.eyj && this.eyf.isScrolling()) {
            this.eyf.iC(true);
        }
    }

    private void bhG() {
        int height;
        int paddingTop = this.mListView.getPaddingTop();
        float height2 = (this.mListView.getHeight() - paddingTop) - this.mListView.getPaddingBottom();
        this.eyl = paddingTop + (this.eyg * height2);
        this.eyk = (height2 * (1.0f - this.eyh)) + paddingTop;
        this.eyi = (int) this.eyl;
        this.eyj = (int) this.eyk;
        this.eyn = this.eyl - paddingTop;
        this.eyo = (paddingTop + height) - this.eyk;
    }

    private void bhH() {
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
        if (i2 != this.exV && i2 != this.exS && i2 != this.exT) {
            g2 = -2;
        } else {
            g2 = g(i2, view, z);
        }
        if (g2 != layoutParams.height) {
            layoutParams.height = g2;
            view.setLayoutParams(layoutParams);
        }
        if (i2 == this.exS || i2 == this.exT) {
            if (i2 < this.exV) {
                ((DragSortItemView) view).setGravity(80);
            } else if (i2 > this.exV) {
                ((DragSortItemView) view).setGravity(48);
            }
        }
        int visibility = view.getVisibility();
        int i3 = 0;
        if (i2 == this.exV && this.exK != null) {
            i3 = 4;
        }
        if (i3 != visibility) {
            view.setVisibility(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int nQ(int i2) {
        View view;
        if (i2 == this.exV) {
            return 0;
        }
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        if (childAt != null) {
            return f(i2, childAt, false);
        }
        int i3 = this.eyE.get(i2);
        if (i3 == -1) {
            ListAdapter adapter = this.mListView.getAdapter();
            int itemViewType = adapter.getItemViewType(i2);
            int viewTypeCount = adapter.getViewTypeCount();
            if (viewTypeCount != this.eyd.length) {
                this.eyd = new View[viewTypeCount];
            }
            if (itemViewType >= 0) {
                if (this.eyd[itemViewType] == null) {
                    view = adapter.getView(i2, null, this.mListView);
                    this.eyd[itemViewType] = view;
                } else {
                    view = adapter.getView(i2, this.eyd[itemViewType], this.mListView);
                }
            } else {
                view = adapter.getView(i2, null, this.mListView);
            }
            int f2 = f(i2, view, true);
            this.eyE.aX(i2, f2);
            return f2;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(int i2, View view, boolean z) {
        if (i2 == this.exV) {
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
        return aW(i2, f(i2, view, z));
    }

    private int aW(int i2, int i3) {
        this.mListView.getDividerHeight();
        boolean z = this.exU && this.exS != this.exT;
        int i4 = this.cvC - this.eyb;
        int i5 = (int) (this.eyz * i4);
        if (i2 == this.exV) {
            if (this.exV == this.exS) {
                if (z) {
                    return i5 + this.eyb;
                }
                return this.cvC;
            } else if (this.exV == this.exT) {
                return this.cvC - i5;
            } else {
                return this.eyb;
            }
        } else if (i2 == this.exS) {
            if (z) {
                return i3 + i5;
            }
            return i3 + i4;
        } else if (i2 == this.exT) {
            return (i3 + i4) - i5;
        } else {
            return i3;
        }
    }

    private int b(int i2, View view, int i3, int i4) {
        int i5;
        int i6;
        int nQ = nQ(i2);
        int height = view.getHeight();
        int aW = aW(i2, nQ);
        if (i2 != this.exV) {
            i6 = height - nQ;
            i5 = aW - nQ;
        } else {
            i5 = aW;
            i6 = height;
        }
        int i7 = this.cvC;
        if (this.exV != this.exS && this.exV != this.exT) {
            i7 -= this.eyb;
        }
        if (i2 <= i3) {
            if (i2 > this.exS) {
                return (i7 - i5) + 0;
            }
        } else if (i2 == i4) {
            if (i2 <= this.exS) {
                return (i6 - i7) + 0;
            }
            if (i2 == this.exT) {
                return (height - aW) + 0;
            }
            return 0 + i6;
        } else if (i2 <= this.exS) {
            return 0 - i7;
        } else {
            if (i2 == this.exT) {
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

    private void bhI() {
        if (this.exK != null) {
            measureItem(this.exK);
            this.cvC = this.exK.getMeasuredHeight();
            this.eyc = this.cvC / 2;
        }
    }

    protected boolean onDragTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        switch (motionEvent.getAction() & 255) {
            case 1:
                if (this.mDragState == 4) {
                    stopDrag(false);
                }
                bhF();
                return true;
            case 2:
                aV((int) motionEvent.getX(), (int) motionEvent.getY());
                return true;
            case 3:
                if (this.mDragState == 4) {
                    cancelDrag();
                }
                bhF();
                return true;
            default:
                return true;
        }
    }

    public boolean startDrag(int i2, int i3, int i4, int i5) {
        View nS;
        if (!this.eyu || this.eyv == null || (nS = this.eyv.nS(i2)) == null) {
            return false;
        }
        return startDrag(i2, nS, i3, i4, i5);
    }

    public boolean startDrag(int i2, View view, int i3, int i4, int i5) {
        if (this.mDragState == 0 && this.eyu && this.exK == null && view != null && this.cLC) {
            if (this.mListView.getParent() != null) {
                this.mListView.getParent().requestDisallowInterceptTouchEvent(true);
            }
            int headerViewsCount = this.mListView.getHeaderViewsCount() + i2;
            this.exS = headerViewsCount;
            this.exT = headerViewsCount;
            this.exV = headerViewsCount;
            this.exR = headerViewsCount;
            this.mDragState = 4;
            this.eys = 0;
            this.eys |= i3;
            this.exK = view;
            bhI();
            this.exW = i4;
            this.exX = i5;
            this.eyr = this.mY;
            this.exL.x = this.mX - this.exW;
            this.exL.y = this.mY - this.exX;
            View childAt = this.mListView.getChildAt(this.exV - this.mListView.getFirstVisiblePosition());
            if (childAt != null) {
                childAt.setVisibility(4);
            }
            if (this.eyB) {
                this.eyC.bhM();
            }
            switch (this.eyx) {
                case 1:
                    this.eyK.onTouchEvent(this.eyw);
                    break;
                case 2:
                    this.eyK.onInterceptTouchEvent(this.eyw);
                    break;
            }
            this.mListView.requestLayout();
            if (this.eyG != null) {
                this.eyG.start();
                return true;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iB(boolean z) {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition() + (this.mListView.getChildCount() / 2);
        View childAt = this.mListView.getChildAt(this.mListView.getChildCount() / 2);
        if (childAt != null) {
            h(firstVisiblePosition, childAt, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i2, View view, boolean z) {
        this.mBlockLayoutRequests = true;
        bhJ();
        int i3 = this.exS;
        int i4 = this.exT;
        boolean bhA = bhA();
        if (bhA) {
            bhH();
            this.mListView.setSelectionFromTop(i2, (b(i2, view, i3, i4) + view.getTop()) - this.mListView.getPaddingTop());
            layoutChildren();
        }
        if (bhA || z) {
            this.mListView.invalidate();
        }
        this.mBlockLayoutRequests = false;
    }

    private void bhJ() {
        if (this.eyv != null) {
            this.exM.set(this.mX, this.mY);
            this.eyv.b(this.exK, this.exL, this.exM);
        }
        int i2 = this.exL.x;
        int i3 = this.exL.y;
        int paddingLeft = this.mListView.getPaddingLeft();
        if ((this.eys & 1) == 0 && i2 > paddingLeft) {
            this.exL.x = paddingLeft;
        } else if ((this.eys & 2) == 0 && i2 < paddingLeft) {
            this.exL.x = paddingLeft;
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int lastVisiblePosition = this.mListView.getLastVisiblePosition();
        int paddingTop = this.mListView.getPaddingTop();
        if (firstVisiblePosition < headerViewsCount) {
            paddingTop = this.mListView.getChildAt((headerViewsCount - firstVisiblePosition) - 1).getBottom();
        }
        if ((this.eys & 8) == 0 && firstVisiblePosition <= this.exV) {
            paddingTop = Math.max(this.mListView.getChildAt(this.exV - firstVisiblePosition).getTop(), paddingTop);
        }
        int height = this.mListView.getHeight() - this.mListView.getPaddingBottom();
        if (lastVisiblePosition >= (this.mListView.getCount() - footerViewsCount) - 1) {
            height = this.mListView.getChildAt(((this.mListView.getCount() - footerViewsCount) - 1) - firstVisiblePosition).getBottom();
        }
        if ((this.eys & 4) == 0 && lastVisiblePosition >= this.exV) {
            height = Math.min(this.mListView.getChildAt(this.exV - firstVisiblePosition).getBottom(), height);
        }
        if (i3 < paddingTop) {
            this.exL.y = paddingTop;
        } else if (this.cvC + i3 > height) {
            this.exL.y = height - this.cvC;
        }
        this.exN = this.exL.y + this.eyc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhK() {
        if (this.exK != null) {
            this.exK.setVisibility(8);
            if (this.eyv != null) {
                this.eyv.bl(this.exK);
            }
            this.exK = null;
            this.mListView.invalidate();
        }
    }

    public void a(h hVar) {
        this.eyv = hVar;
    }

    public void a(b bVar) {
        this.exY = bVar;
    }

    public void setDragEnabled(boolean z) {
        this.cLC = z;
    }

    public boolean isDragEnabled() {
        return this.cLC;
    }

    public void a(g gVar) {
        this.exZ = gVar;
    }

    public void a(l lVar) {
        this.eya = lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class i {
        private SparseIntArray ezf;
        private ArrayList<Integer> ezg;
        private int mMaxSize;

        public i(int i) {
            this.ezf = new SparseIntArray(i);
            this.ezg = new ArrayList<>(i);
            this.mMaxSize = i;
        }

        public void aX(int i, int i2) {
            int i3 = this.ezf.get(i, -1);
            if (i3 != i2) {
                if (i3 == -1) {
                    if (this.ezf.size() == this.mMaxSize) {
                        this.ezf.delete(this.ezg.remove(0).intValue());
                    }
                } else {
                    this.ezg.remove(Integer.valueOf(i));
                }
                this.ezf.put(i, i2);
                this.ezg.add(Integer.valueOf(i));
            }
        }

        public int get(int i) {
            return this.ezf.get(i, -1);
        }

        public void clear() {
            this.ezf.clear();
            this.ezg.clear();
        }
    }

    /* renamed from: com.baidu.tbadk.widget.dragsort.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0497a extends BaseAdapter {
        private ListAdapter mAdapter;

        public C0497a(ListAdapter listAdapter) {
            this.mAdapter = listAdapter;
            this.mAdapter.registerDataSetObserver(new DataSetObserver() { // from class: com.baidu.tbadk.widget.dragsort.a.a.1
                @Override // android.database.DataSetObserver
                public void onChanged() {
                    C0497a.this.notifyDataSetChanged();
                }

                @Override // android.database.DataSetObserver
                public void onInvalidated() {
                    C0497a.this.notifyDataSetInvalidated();
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
        private float bOC;
        private float bOD;
        private float bOE;
        private float bOF;
        private float ezq;
        private float mAlpha;
        private boolean mCanceled;
        protected long mStartTime;

        public m(float f, int i) {
            this.mAlpha = f;
            this.ezq = i;
            float f2 = 1.0f / ((this.mAlpha * 2.0f) * (1.0f - this.mAlpha));
            this.bOF = f2;
            this.bOC = f2;
            this.bOD = this.mAlpha / ((this.mAlpha - 1.0f) * 2.0f);
            this.bOE = 1.0f / (1.0f - this.mAlpha);
        }

        public float Z(float f) {
            if (f < this.mAlpha) {
                return this.bOC * f * f;
            }
            if (f < 1.0f - this.mAlpha) {
                return this.bOD + (this.bOE * f);
            }
            return 1.0f - ((this.bOF * (f - 1.0f)) * (f - 1.0f));
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
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / this.ezq;
                if (uptimeMillis >= 1.0f) {
                    s(1.0f, 1.0f);
                    onStop();
                    return;
                }
                s(uptimeMillis, Z(uptimeMillis));
                a.this.mListView.post(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class f extends m {
        private int ezb;
        private int ezc;
        private float ezd;
        private float eze;

        public f(float f, int i) {
            super(f, i);
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.ezb = a.this.exR;
            this.ezc = a.this.exV;
            a.this.mDragState = 2;
            this.ezd = a.this.exL.y - bhO();
            this.eze = a.this.exL.x - a.this.mListView.getPaddingLeft();
        }

        private int bhO() {
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            int dividerHeight = (a.this.eyb + a.this.mListView.getDividerHeight()) / 2;
            View childAt = a.this.mListView.getChildAt(this.ezb - firstVisiblePosition);
            if (childAt != null) {
                if (this.ezb == this.ezc) {
                    return childAt.getTop();
                }
                if (this.ezb >= this.ezc) {
                    return (childAt.getBottom() + dividerHeight) - a.this.cvC;
                }
                return childAt.getTop() - dividerHeight;
            }
            cancel();
            return -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void s(float f, float f2) {
            int bhO = bhO();
            float paddingLeft = a.this.exL.x - a.this.mListView.getPaddingLeft();
            float f3 = 1.0f - f2;
            if (f3 < Math.abs((a.this.exL.y - bhO) / this.ezd) || f3 < Math.abs(paddingLeft / this.eze)) {
                a.this.exL.y = bhO + ((int) (this.ezd * f3));
                a.this.exL.x = a.this.mListView.getPaddingLeft() + ((int) (this.eze * f3));
                a.this.iB(true);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.bhC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class k extends m {
        private int ezc;
        private float ezj;
        private float ezk;
        private float ezl;
        private int ezm;
        private int ezn;
        private int ezo;
        private int ezp;

        public k(float f, int i) {
            super(f, i);
            this.ezm = -1;
            this.ezn = -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.ezm = -1;
            this.ezn = -1;
            this.ezo = a.this.exS;
            this.ezp = a.this.exT;
            this.ezc = a.this.exV;
            a.this.mDragState = 1;
            this.ezj = a.this.exL.x;
            if (a.this.eyI) {
                float width = a.this.mListView.getWidth() * 2.0f;
                if (a.this.eyJ == 0.0f) {
                    a.this.eyJ = (this.ezj >= 0.0f ? 1 : -1) * width;
                    return;
                }
                float f = width * 2.0f;
                if (a.this.eyJ >= 0.0f || a.this.eyJ <= (-f)) {
                    if (a.this.eyJ > 0.0f && a.this.eyJ < f) {
                        a.this.eyJ = f;
                        return;
                    }
                    return;
                }
                a.this.eyJ = -f;
                return;
            }
            a.this.bhK();
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void s(float f, float f2) {
            View childAt;
            float f3 = 1.0f - f2;
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            View childAt2 = a.this.mListView.getChildAt(this.ezo - firstVisiblePosition);
            if (a.this.eyI) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / 1000.0f;
                if (uptimeMillis != 0.0f) {
                    float f4 = a.this.eyJ * uptimeMillis;
                    int width = a.this.mListView.getWidth();
                    a.this.eyJ = ((a.this.eyJ > 0.0f ? 1 : -1) * uptimeMillis * width) + a.this.eyJ;
                    this.ezj += f4;
                    a.this.exL.x = (int) this.ezj;
                    if (this.ezj < width && this.ezj > (-width)) {
                        this.mStartTime = SystemClock.uptimeMillis();
                        a.this.iB(true);
                        return;
                    }
                } else {
                    return;
                }
            }
            if (childAt2 != null) {
                if (this.ezm == -1) {
                    this.ezm = a.this.f(this.ezo, childAt2, false);
                    this.ezk = childAt2.getHeight() - this.ezm;
                }
                int max = Math.max((int) (this.ezk * f3), 1);
                ViewGroup.LayoutParams layoutParams = childAt2.getLayoutParams();
                layoutParams.height = max + this.ezm;
                childAt2.setLayoutParams(layoutParams);
            }
            if (this.ezp != this.ezo && (childAt = a.this.mListView.getChildAt(this.ezp - firstVisiblePosition)) != null) {
                if (this.ezn == -1) {
                    this.ezn = a.this.f(this.ezp, childAt, false);
                    this.ezl = childAt.getHeight() - this.ezn;
                }
                int max2 = Math.max((int) (this.ezl * f3), 1);
                ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
                layoutParams2.height = max2 + this.ezn;
                childAt.setLayoutParams(layoutParams2);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.bhD();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class j extends m {
        final /* synthetic */ a eyO;
        private float ezh;
        private float ezi;

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.ezh = this.eyO.exX;
            this.ezi = this.eyO.eyc;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void s(float f, float f2) {
            if (this.eyO.mDragState != 4) {
                cancel();
                return;
            }
            this.eyO.exX = (int) ((this.ezi * f2) + ((1.0f - f2) * this.ezh));
            this.eyO.exL.y = this.eyO.mY - this.eyO.exX;
            this.eyO.iB(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e {
        StringBuilder mBuilder = new StringBuilder();
        private int eyY = 0;
        private int eyZ = 0;
        private boolean eza = false;
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

        public void bhM() {
            this.mBuilder.append("<DSLVStates>\n");
            this.eyZ = 0;
            this.eza = true;
        }

        public void bhN() {
            if (this.eza) {
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
                this.mBuilder.append("    <FirstExpPos>").append(a.this.exS).append("</FirstExpPos>\n");
                this.mBuilder.append("    <FirstExpBlankHeight>").append(a.this.nO(a.this.exS) - a.this.nQ(a.this.exS)).append("</FirstExpBlankHeight>\n");
                this.mBuilder.append("    <SecondExpPos>").append(a.this.exT).append("</SecondExpPos>\n");
                this.mBuilder.append("    <SecondExpBlankHeight>").append(a.this.nO(a.this.exT) - a.this.nQ(a.this.exT)).append("</SecondExpBlankHeight>\n");
                this.mBuilder.append("    <SrcPos>").append(a.this.exV).append("</SrcPos>\n");
                this.mBuilder.append("    <SrcHeight>").append(a.this.cvC + a.this.mListView.getDividerHeight()).append("</SrcHeight>\n");
                this.mBuilder.append("    <ViewHeight>").append(a.this.mListView.getHeight()).append("</ViewHeight>\n");
                this.mBuilder.append("    <LastY>").append(a.this.mLastY).append("</LastY>\n");
                this.mBuilder.append("    <FloatY>").append(a.this.exN).append("</FloatY>\n");
                this.mBuilder.append("    <ShuffleEdges>");
                for (int i4 = 0; i4 < childCount; i4++) {
                    this.mBuilder.append(a.this.aU(firstVisiblePosition + i4, a.this.mListView.getChildAt(i4).getTop())).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                this.mBuilder.append("</ShuffleEdges>\n");
                this.mBuilder.append("</DSLVState>\n");
                this.eyY++;
                if (this.eyY > 1000) {
                    flush();
                    this.eyY = 0;
                }
            }
        }

        public void flush() {
            if (this.eza) {
                try {
                    FileWriter fileWriter = new FileWriter(this.mFile, this.eyZ != 0);
                    fileWriter.write(this.mBuilder.toString());
                    this.mBuilder.delete(0, this.mBuilder.length());
                    fileWriter.flush();
                    fileWriter.close();
                    this.eyZ++;
                } catch (IOException e) {
                }
            }
        }

        public void stopTracking() {
            if (this.eza) {
                this.mBuilder.append("</DSLVStates>\n");
                flush();
                this.eza = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements Runnable {
        private int dy;
        private boolean eyR;
        private long eyS;
        private long eyT;
        private float eyU;
        private long eyV;
        private int eyW;
        private float eyX;
        private boolean mScrolling = false;

        public boolean isScrolling() {
            return this.mScrolling;
        }

        public int bhL() {
            if (this.mScrolling) {
                return this.eyW;
            }
            return -1;
        }

        public d() {
        }

        public void nR(int i) {
            if (!this.mScrolling) {
                this.eyR = false;
                this.mScrolling = true;
                this.eyV = SystemClock.uptimeMillis();
                this.eyS = this.eyV;
                this.eyW = i;
                a.this.mListView.post(this);
            }
        }

        public void iC(boolean z) {
            if (z) {
                a.this.mListView.removeCallbacks(this);
                this.mScrolling = false;
                return;
            }
            this.eyR = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.eyR) {
                int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
                int lastVisiblePosition = a.this.mListView.getLastVisiblePosition();
                int count = a.this.mListView.getCount();
                int paddingTop = a.this.mListView.getPaddingTop();
                int height = (a.this.mListView.getHeight() - paddingTop) - a.this.mListView.getPaddingBottom();
                int min = Math.min(a.this.mY, a.this.exN + a.this.eyc);
                int max = Math.max(a.this.mY, a.this.exN - a.this.eyc);
                if (this.eyW == 0) {
                    View childAt = a.this.mListView.getChildAt(0);
                    if (childAt == null) {
                        this.mScrolling = false;
                        return;
                    } else if (firstVisiblePosition == 0 && childAt.getTop() == paddingTop) {
                        this.mScrolling = false;
                        return;
                    } else {
                        this.eyX = a.this.eyq.b((a.this.eyl - max) / a.this.eyn, this.eyS);
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
                        this.eyX = -a.this.eyq.b((min - a.this.eyk) / a.this.eyo, this.eyS);
                    }
                }
                this.eyT = SystemClock.uptimeMillis();
                this.eyU = (float) (this.eyT - this.eyS);
                this.dy = Math.round(this.eyX * this.eyU);
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
                this.eyS = this.eyT;
                a.this.mListView.post(this);
                return;
            }
            this.mScrolling = false;
        }
    }
}
