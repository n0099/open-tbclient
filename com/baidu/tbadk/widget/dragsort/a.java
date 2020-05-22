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
    private int exC;
    private int exG;
    private int exH;
    private int exI;
    private int exK;
    private int exL;
    private int exM;
    private b exN;
    private g exO;
    private l exP;
    private int exR;
    private d exT;
    private int exW;
    private int exX;
    private float exY;
    private float exZ;
    private View exz;
    private com.baidu.tbadk.widget.dragsort.b eyA;
    private float eya;
    private float eyb;
    private int eyf;
    private MotionEvent eyk;
    private C0497a eyp;
    private e eyr;
    private k eyu;
    private j eyv;
    private f eyw;
    private boolean eyx;
    private com.baidu.tbadk.widget.dragsort.d eyz;
    private int mLastX;
    private int mLastY;
    private ListView mListView;
    private DataSetObserver mObserver;
    private int mOffsetX;
    private int mOffsetY;
    private int mX;
    private int mY;
    private Point exA = new Point();
    private Point exB = new Point();
    private boolean exD = false;
    private float exE = 1.0f;
    private float exF = 1.0f;
    private boolean exJ = false;
    private boolean cLC = true;
    private int mDragState = 0;
    private int exQ = 1;
    private int mWidthMeasureSpec = 0;
    private View[] exS = new View[1];
    private float exU = 0.33333334f;
    private float exV = 0.33333334f;
    private float eyc = 0.5f;
    private c eyd = new c() { // from class: com.baidu.tbadk.widget.dragsort.a.1
        @Override // com.baidu.tbadk.widget.dragsort.a.c
        public float b(float f2, long j2) {
            return a.this.eyc * f2;
        }
    };
    private int eyg = 0;
    private boolean eyh = false;
    private boolean eyi = false;
    private h eyj = null;
    private int eyl = 0;
    private float eyn = 0.25f;
    private float eyo = 0.0f;
    private boolean eyq = false;
    private boolean mBlockLayoutRequests = false;
    private boolean eys = false;
    private i eyt = new i(3);
    private float eyy = 0.0f;
    private boolean eyB = false;
    private boolean eyC = false;

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

        View nQ(int i);
    }

    /* loaded from: classes.dex */
    public interface l {
        void remove(int i);
    }

    public a(ListView listView, com.baidu.tbadk.widget.dragsort.d dVar) {
        this.eyz = dVar;
        this.mListView = listView;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            this.eyp = new C0497a(listAdapter);
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
            this.eyp = null;
        }
        this.eyz.setAdapter(this.eyp);
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
            if (i2 > this.exK) {
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
    public int nM(int i2) {
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        return childAt != null ? childAt.getHeight() : aW(i2, nO(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aU(int i2, int i3) {
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        if (i2 <= headerViewsCount || i2 >= this.mListView.getCount() - footerViewsCount) {
            return i3;
        }
        int dividerHeight = this.mListView.getDividerHeight();
        int i4 = this.cvC - this.exQ;
        int nO = nO(i2);
        int nM = nM(i2);
        if (this.exI <= this.exK) {
            if (i2 == this.exI && this.exH != this.exI) {
                if (i2 == this.exK) {
                    i3 = (i3 + nM) - this.cvC;
                } else {
                    i3 = ((nM - nO) + i3) - i4;
                }
            } else if (i2 > this.exI && i2 <= this.exK) {
                i3 -= i4;
            }
        } else if (i2 > this.exK && i2 <= this.exH) {
            i3 += i4;
        } else if (i2 == this.exI && this.exH != this.exI) {
            i3 += nM - nO;
        }
        if (i2 <= this.exK) {
            return (((this.cvC - dividerHeight) - nO(i2 - 1)) / 2) + i3;
        }
        return (((nO - dividerHeight) - this.cvC) / 2) + i3;
    }

    private boolean bhy() {
        int i2;
        int i3;
        int i4;
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int i5 = this.exH;
        View childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        if (childAt == null) {
            i5 = firstVisiblePosition + (this.mListView.getChildCount() / 2);
            childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        }
        int top2 = childAt.getTop();
        int height = childAt.getHeight();
        int aU = aU(i5, top2);
        int dividerHeight = this.mListView.getDividerHeight();
        if (this.exC >= aU) {
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
                    i6 = nM(i3 + 1);
                    i2 = aU(i3 + 1, i7);
                    if (this.exC < i2) {
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
                int nM = nM(i3);
                if (i3 == 0) {
                    i2 = (i8 - dividerHeight) - nM;
                    break;
                }
                i8 -= nM + dividerHeight;
                i2 = aU(i3, i8);
                if (this.exC >= i2) {
                    break;
                }
                i4 = i2;
            }
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int i9 = this.exH;
        int i10 = this.exI;
        float f2 = this.eyo;
        if (this.exJ) {
            int abs = Math.abs(i2 - i4);
            if (this.exC >= i2) {
                int i11 = i4;
                i4 = i2;
                i2 = i11;
            }
            int i12 = (int) (abs * this.eyn * 0.5f);
            float f3 = i12;
            int i13 = i4 + i12;
            int i14 = i2 - i12;
            if (this.exC < i13) {
                this.exH = i3 - 1;
                this.exI = i3;
                this.eyo = ((i13 - this.exC) * 0.5f) / f3;
            } else if (this.exC < i14) {
                this.exH = i3;
                this.exI = i3;
            } else {
                this.exH = i3;
                this.exI = i3 + 1;
                this.eyo = (1.0f + ((i2 - this.exC) / f3)) * 0.5f;
            }
        } else {
            this.exH = i3;
            this.exI = i3;
        }
        if (this.exH < headerViewsCount) {
            this.exH = headerViewsCount;
            this.exI = headerViewsCount;
            i3 = headerViewsCount;
        } else if (this.exI >= this.mListView.getCount() - footerViewsCount) {
            i3 = (this.mListView.getCount() - footerViewsCount) - 1;
            this.exH = i3;
            this.exI = i3;
        }
        boolean z = (this.exH == i9 && this.exI == i10 && this.eyo == f2) ? false : true;
        if (i3 != this.exG) {
            if (this.exN != null) {
                this.exN.drag(this.exG - headerViewsCount, i3 - headerViewsCount);
            }
            this.exG = i3;
            return true;
        }
        return z;
    }

    public void removeItem(int i2) {
        this.eyx = false;
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
            this.exQ = Math.max(1, obtainStyledAttributes.getDimensionPixelSize(12, 1));
            this.eyq = obtainStyledAttributes.getBoolean(6, false);
            if (this.eyq) {
                this.eyr = new e();
            }
            this.exE = obtainStyledAttributes.getFloat(10, this.exE);
            this.exF = this.exE;
            this.cLC = obtainStyledAttributes.getBoolean(13, this.cLC);
            this.eyn = Math.max(0.0f, Math.min(1.0f, 1.0f - obtainStyledAttributes.getFloat(2, 0.75f)));
            this.exJ = this.eyn > 0.0f;
            setDragScrollStart(obtainStyledAttributes.getFloat(14, this.exU));
            this.eyc = obtainStyledAttributes.getFloat(0, this.eyc);
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
                this.eyj = bVar;
                a(bVar);
            }
            obtainStyledAttributes.recycle();
            i2 = i5;
            i3 = i4;
        }
        this.exT = new d();
        if (i3 > 0) {
            this.eyu = new k(0.5f, i3);
        }
        if (i2 > 0) {
            this.eyw = new f(0.5f, i2);
        }
        this.eyk = MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
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
        this.eyA = bVar;
        this.mListView.setOnTouchListener(bVar);
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void dispatchDraw(Canvas canvas) {
        float f2;
        this.eyz.dispatchDraw(canvas);
        if (this.mDragState != 0) {
            if (this.exH != this.exK) {
                b(this.exH, canvas);
            }
            if (this.exI != this.exH && this.exI != this.exK) {
                b(this.exI, canvas);
            }
        }
        if (this.exz != null) {
            int width = this.exz.getWidth();
            int height = this.exz.getHeight();
            int i2 = this.exA.x;
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
            int i3 = (int) (f2 * 255.0f * this.exF);
            canvas.save();
            canvas.translate(this.exA.x, this.exA.y);
            canvas.clipRect(0, 0, width, height);
            canvas.saveLayerAlpha(0.0f, 0.0f, width, height, i3, 31);
            this.exz.draw(canvas);
            canvas.restore();
            canvas.restore();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onDraw(Canvas canvas) {
        this.eyz.onDraw(canvas);
        if (this.eyq) {
            this.eyr.bhL();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.eys) {
            this.eys = false;
            return false;
        } else if (!this.cLC) {
            return this.eyz.onTouchEvent(motionEvent);
        } else {
            boolean z2 = this.eyh;
            this.eyh = false;
            if (!z2) {
                r(motionEvent);
            }
            if (this.mDragState == 4) {
                onDragTouchEvent(motionEvent);
                return true;
            }
            if (this.mDragState == 0 && this.eyz.onTouchEvent(motionEvent)) {
                z = true;
            }
            switch (motionEvent.getAction() & 255) {
                case 1:
                case 3:
                    bhD();
                    return z;
                case 2:
                default:
                    if (z) {
                        this.eyl = 1;
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
            return this.eyz.onInterceptTouchEvent(motionEvent);
        }
        if (this.eyA != null) {
            this.eyA.bhN().onTouchEvent(motionEvent);
        }
        r(motionEvent);
        this.eyh = true;
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            if (this.mDragState != 0) {
                this.eys = true;
                return true;
            }
            this.eyi = true;
        }
        if (this.exz == null) {
            if (this.eyz.onInterceptTouchEvent(motionEvent)) {
                this.eyB = true;
                z = true;
            } else {
                z = false;
            }
            switch (action) {
                case 1:
                case 3:
                    bhD();
                    break;
                case 2:
                default:
                    if (z) {
                        this.eyl = 1;
                        break;
                    } else {
                        this.eyl = 2;
                        break;
                    }
            }
        } else {
            z = true;
        }
        if (action == 1 || action == 3) {
            this.eyi = false;
        }
        return z;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        this.eyz.onSizeChanged(i2, i3, i4, i5);
        bhE();
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void requestLayout() {
        if (!this.mBlockLayoutRequests) {
            this.eyz.requestLayout();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onMeasure(int i2, int i3) {
        this.eyz.onMeasure(i2, i3);
        if (this.exz != null) {
            if (this.exz.isLayoutRequested()) {
                bhG();
            }
            this.exD = true;
        }
        this.mWidthMeasureSpec = i2;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void layoutChildren() {
        this.eyz.layoutChildren();
        if (this.exz != null) {
            if (this.exz.isLayoutRequested() && !this.exD) {
                bhG();
            }
            this.exz.layout(0, 0, this.exz.getMeasuredWidth(), this.exz.getMeasuredHeight());
            this.exD = false;
        }
    }

    public void removeItem(int i2, float f2) {
        if (this.mDragState == 0 || this.mDragState == 4) {
            if (this.mDragState == 0) {
                this.exK = this.mListView.getHeaderViewsCount() + i2;
                this.exH = this.exK;
                this.exI = this.exK;
                this.exG = this.exK;
                View childAt = this.mListView.getChildAt(this.exK - this.mListView.getFirstVisiblePosition());
                if (childAt != null) {
                    childAt.setVisibility(4);
                }
            }
            this.mDragState = 1;
            this.eyy = f2;
            if (this.eyi) {
                switch (this.eyl) {
                    case 1:
                        this.eyz.onTouchEvent(this.eyk);
                        break;
                    case 2:
                        this.eyz.onInterceptTouchEvent(this.eyk);
                        break;
                }
            }
            if (this.eyu != null) {
                this.eyu.start();
            } else {
                nN(i2);
            }
        }
    }

    public void cancelDrag() {
        if (this.mDragState == 4) {
            this.exT.iC(true);
            bhI();
            bhz();
            bhF();
            if (this.eyi) {
                this.mDragState = 3;
            } else {
                this.mDragState = 0;
            }
        }
    }

    private void bhz() {
        this.exK = -1;
        this.exH = -1;
        this.exI = -1;
        this.exG = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhA() {
        this.mDragState = 2;
        if (this.exO != null && this.exG >= 0 && this.exG < this.mListView.getCount()) {
            int headerViewsCount = this.mListView.getHeaderViewsCount();
            this.exO.drop(this.exK - headerViewsCount, this.exG - headerViewsCount);
        }
        bhI();
        bhC();
        bhz();
        bhF();
        if (this.eyi) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhB() {
        nN(this.exK - this.mListView.getHeaderViewsCount());
    }

    private void nN(int i2) {
        this.mDragState = 1;
        if (this.exP != null) {
            this.exP.remove(i2);
        }
        bhI();
        bhC();
        bhz();
        if (this.eyi) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    private void bhC() {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        if (this.exK < firstVisiblePosition) {
            View childAt = this.mListView.getChildAt(0);
            this.mListView.setSelectionFromTop(firstVisiblePosition - 1, (childAt != null ? childAt.getTop() : 0) - this.mListView.getPaddingTop());
        }
    }

    public boolean stopDrag(boolean z) {
        this.eyx = false;
        return stopDrag(z, 0.0f);
    }

    public boolean stopDragWithVelocity(boolean z, float f2) {
        this.eyx = true;
        return stopDrag(z, f2);
    }

    public boolean stopDrag(boolean z, float f2) {
        if (this.exz != null) {
            this.exT.iC(true);
            if (z) {
                removeItem(this.exK - this.mListView.getHeaderViewsCount(), f2);
            } else if (this.eyw != null) {
                this.eyw.start();
            } else {
                bhA();
            }
            if (this.eyq) {
                this.eyr.stopTracking();
                return true;
            }
            return true;
        }
        return false;
    }

    private void bhD() {
        this.eyl = 0;
        this.eyi = false;
        if (this.mDragState == 3) {
            this.mDragState = 0;
        }
        this.exF = this.exE;
        this.eyB = false;
        this.eyt.clear();
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
        return this.eyB;
    }

    public void setDragScrollStart(float f2) {
        setDragScrollStarts(f2, f2);
    }

    public void setDragScrollStarts(float f2, float f3) {
        if (f3 > 0.5f) {
            this.exV = 0.5f;
        } else {
            this.exV = f3;
        }
        if (f2 > 0.5f) {
            this.exU = 0.5f;
        } else {
            this.exU = f2;
        }
        if (this.mListView.getHeight() != 0) {
            bhE();
        }
    }

    private void aV(int i2, int i3) {
        this.exA.x = i2 - this.exL;
        this.exA.y = i3 - this.exM;
        iB(true);
        int min = Math.min(i3, this.exC + this.exR);
        int max = Math.max(i3, this.exC - this.exR);
        int bhJ = this.exT.bhJ();
        if (min > this.mLastY && min > this.exX && bhJ != 1) {
            if (bhJ != -1) {
                this.exT.iC(true);
            }
            this.exT.nP(1);
        } else if (max < this.mLastY && max < this.exW && bhJ != 0) {
            if (bhJ != -1) {
                this.exT.iC(true);
            }
            this.exT.nP(0);
        } else if (max >= this.exW && min <= this.exX && this.exT.isScrolling()) {
            this.exT.iC(true);
        }
    }

    private void bhE() {
        int height;
        int paddingTop = this.mListView.getPaddingTop();
        float height2 = (this.mListView.getHeight() - paddingTop) - this.mListView.getPaddingBottom();
        this.exZ = paddingTop + (this.exU * height2);
        this.exY = (height2 * (1.0f - this.exV)) + paddingTop;
        this.exW = (int) this.exZ;
        this.exX = (int) this.exY;
        this.eya = this.exZ - paddingTop;
        this.eyb = (paddingTop + height) - this.exY;
    }

    private void bhF() {
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
        if (i2 != this.exK && i2 != this.exH && i2 != this.exI) {
            g2 = -2;
        } else {
            g2 = g(i2, view, z);
        }
        if (g2 != layoutParams.height) {
            layoutParams.height = g2;
            view.setLayoutParams(layoutParams);
        }
        if (i2 == this.exH || i2 == this.exI) {
            if (i2 < this.exK) {
                ((DragSortItemView) view).setGravity(80);
            } else if (i2 > this.exK) {
                ((DragSortItemView) view).setGravity(48);
            }
        }
        int visibility = view.getVisibility();
        int i3 = 0;
        if (i2 == this.exK && this.exz != null) {
            i3 = 4;
        }
        if (i3 != visibility) {
            view.setVisibility(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int nO(int i2) {
        View view;
        if (i2 == this.exK) {
            return 0;
        }
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        if (childAt != null) {
            return f(i2, childAt, false);
        }
        int i3 = this.eyt.get(i2);
        if (i3 == -1) {
            ListAdapter adapter = this.mListView.getAdapter();
            int itemViewType = adapter.getItemViewType(i2);
            int viewTypeCount = adapter.getViewTypeCount();
            if (viewTypeCount != this.exS.length) {
                this.exS = new View[viewTypeCount];
            }
            if (itemViewType >= 0) {
                if (this.exS[itemViewType] == null) {
                    view = adapter.getView(i2, null, this.mListView);
                    this.exS[itemViewType] = view;
                } else {
                    view = adapter.getView(i2, this.exS[itemViewType], this.mListView);
                }
            } else {
                view = adapter.getView(i2, null, this.mListView);
            }
            int f2 = f(i2, view, true);
            this.eyt.aX(i2, f2);
            return f2;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(int i2, View view, boolean z) {
        if (i2 == this.exK) {
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
        boolean z = this.exJ && this.exH != this.exI;
        int i4 = this.cvC - this.exQ;
        int i5 = (int) (this.eyo * i4);
        if (i2 == this.exK) {
            if (this.exK == this.exH) {
                if (z) {
                    return i5 + this.exQ;
                }
                return this.cvC;
            } else if (this.exK == this.exI) {
                return this.cvC - i5;
            } else {
                return this.exQ;
            }
        } else if (i2 == this.exH) {
            if (z) {
                return i3 + i5;
            }
            return i3 + i4;
        } else if (i2 == this.exI) {
            return (i3 + i4) - i5;
        } else {
            return i3;
        }
    }

    private int b(int i2, View view, int i3, int i4) {
        int i5;
        int i6;
        int nO = nO(i2);
        int height = view.getHeight();
        int aW = aW(i2, nO);
        if (i2 != this.exK) {
            i6 = height - nO;
            i5 = aW - nO;
        } else {
            i5 = aW;
            i6 = height;
        }
        int i7 = this.cvC;
        if (this.exK != this.exH && this.exK != this.exI) {
            i7 -= this.exQ;
        }
        if (i2 <= i3) {
            if (i2 > this.exH) {
                return (i7 - i5) + 0;
            }
        } else if (i2 == i4) {
            if (i2 <= this.exH) {
                return (i6 - i7) + 0;
            }
            if (i2 == this.exI) {
                return (height - aW) + 0;
            }
            return 0 + i6;
        } else if (i2 <= this.exH) {
            return 0 - i7;
        } else {
            if (i2 == this.exI) {
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

    private void bhG() {
        if (this.exz != null) {
            measureItem(this.exz);
            this.cvC = this.exz.getMeasuredHeight();
            this.exR = this.cvC / 2;
        }
    }

    protected boolean onDragTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        switch (motionEvent.getAction() & 255) {
            case 1:
                if (this.mDragState == 4) {
                    stopDrag(false);
                }
                bhD();
                return true;
            case 2:
                aV((int) motionEvent.getX(), (int) motionEvent.getY());
                return true;
            case 3:
                if (this.mDragState == 4) {
                    cancelDrag();
                }
                bhD();
                return true;
            default:
                return true;
        }
    }

    public boolean startDrag(int i2, int i3, int i4, int i5) {
        View nQ;
        if (!this.eyi || this.eyj == null || (nQ = this.eyj.nQ(i2)) == null) {
            return false;
        }
        return startDrag(i2, nQ, i3, i4, i5);
    }

    public boolean startDrag(int i2, View view, int i3, int i4, int i5) {
        if (this.mDragState == 0 && this.eyi && this.exz == null && view != null && this.cLC) {
            if (this.mListView.getParent() != null) {
                this.mListView.getParent().requestDisallowInterceptTouchEvent(true);
            }
            int headerViewsCount = this.mListView.getHeaderViewsCount() + i2;
            this.exH = headerViewsCount;
            this.exI = headerViewsCount;
            this.exK = headerViewsCount;
            this.exG = headerViewsCount;
            this.mDragState = 4;
            this.eyg = 0;
            this.eyg |= i3;
            this.exz = view;
            bhG();
            this.exL = i4;
            this.exM = i5;
            this.eyf = this.mY;
            this.exA.x = this.mX - this.exL;
            this.exA.y = this.mY - this.exM;
            View childAt = this.mListView.getChildAt(this.exK - this.mListView.getFirstVisiblePosition());
            if (childAt != null) {
                childAt.setVisibility(4);
            }
            if (this.eyq) {
                this.eyr.bhK();
            }
            switch (this.eyl) {
                case 1:
                    this.eyz.onTouchEvent(this.eyk);
                    break;
                case 2:
                    this.eyz.onInterceptTouchEvent(this.eyk);
                    break;
            }
            this.mListView.requestLayout();
            if (this.eyv != null) {
                this.eyv.start();
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
        bhH();
        int i3 = this.exH;
        int i4 = this.exI;
        boolean bhy = bhy();
        if (bhy) {
            bhF();
            this.mListView.setSelectionFromTop(i2, (b(i2, view, i3, i4) + view.getTop()) - this.mListView.getPaddingTop());
            layoutChildren();
        }
        if (bhy || z) {
            this.mListView.invalidate();
        }
        this.mBlockLayoutRequests = false;
    }

    private void bhH() {
        if (this.eyj != null) {
            this.exB.set(this.mX, this.mY);
            this.eyj.b(this.exz, this.exA, this.exB);
        }
        int i2 = this.exA.x;
        int i3 = this.exA.y;
        int paddingLeft = this.mListView.getPaddingLeft();
        if ((this.eyg & 1) == 0 && i2 > paddingLeft) {
            this.exA.x = paddingLeft;
        } else if ((this.eyg & 2) == 0 && i2 < paddingLeft) {
            this.exA.x = paddingLeft;
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int lastVisiblePosition = this.mListView.getLastVisiblePosition();
        int paddingTop = this.mListView.getPaddingTop();
        if (firstVisiblePosition < headerViewsCount) {
            paddingTop = this.mListView.getChildAt((headerViewsCount - firstVisiblePosition) - 1).getBottom();
        }
        if ((this.eyg & 8) == 0 && firstVisiblePosition <= this.exK) {
            paddingTop = Math.max(this.mListView.getChildAt(this.exK - firstVisiblePosition).getTop(), paddingTop);
        }
        int height = this.mListView.getHeight() - this.mListView.getPaddingBottom();
        if (lastVisiblePosition >= (this.mListView.getCount() - footerViewsCount) - 1) {
            height = this.mListView.getChildAt(((this.mListView.getCount() - footerViewsCount) - 1) - firstVisiblePosition).getBottom();
        }
        if ((this.eyg & 4) == 0 && lastVisiblePosition >= this.exK) {
            height = Math.min(this.mListView.getChildAt(this.exK - firstVisiblePosition).getBottom(), height);
        }
        if (i3 < paddingTop) {
            this.exA.y = paddingTop;
        } else if (this.cvC + i3 > height) {
            this.exA.y = height - this.cvC;
        }
        this.exC = this.exA.y + this.exR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhI() {
        if (this.exz != null) {
            this.exz.setVisibility(8);
            if (this.eyj != null) {
                this.eyj.bl(this.exz);
            }
            this.exz = null;
            this.mListView.invalidate();
        }
    }

    public void a(h hVar) {
        this.eyj = hVar;
    }

    public void a(b bVar) {
        this.exN = bVar;
    }

    public void setDragEnabled(boolean z) {
        this.cLC = z;
    }

    public boolean isDragEnabled() {
        return this.cLC;
    }

    public void a(g gVar) {
        this.exO = gVar;
    }

    public void a(l lVar) {
        this.exP = lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class i {
        private SparseIntArray eyU;
        private ArrayList<Integer> eyV;
        private int mMaxSize;

        public i(int i) {
            this.eyU = new SparseIntArray(i);
            this.eyV = new ArrayList<>(i);
            this.mMaxSize = i;
        }

        public void aX(int i, int i2) {
            int i3 = this.eyU.get(i, -1);
            if (i3 != i2) {
                if (i3 == -1) {
                    if (this.eyU.size() == this.mMaxSize) {
                        this.eyU.delete(this.eyV.remove(0).intValue());
                    }
                } else {
                    this.eyV.remove(Integer.valueOf(i));
                }
                this.eyU.put(i, i2);
                this.eyV.add(Integer.valueOf(i));
            }
        }

        public int get(int i) {
            return this.eyU.get(i, -1);
        }

        public void clear() {
            this.eyU.clear();
            this.eyV.clear();
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
        private float ezf;
        private float mAlpha;
        private boolean mCanceled;
        protected long mStartTime;

        public m(float f, int i) {
            this.mAlpha = f;
            this.ezf = i;
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
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / this.ezf;
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
        private int eyQ;
        private int eyR;
        private float eyS;
        private float eyT;

        public f(float f, int i) {
            super(f, i);
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.eyQ = a.this.exG;
            this.eyR = a.this.exK;
            a.this.mDragState = 2;
            this.eyS = a.this.exA.y - bhM();
            this.eyT = a.this.exA.x - a.this.mListView.getPaddingLeft();
        }

        private int bhM() {
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            int dividerHeight = (a.this.exQ + a.this.mListView.getDividerHeight()) / 2;
            View childAt = a.this.mListView.getChildAt(this.eyQ - firstVisiblePosition);
            if (childAt != null) {
                if (this.eyQ == this.eyR) {
                    return childAt.getTop();
                }
                if (this.eyQ >= this.eyR) {
                    return (childAt.getBottom() + dividerHeight) - a.this.cvC;
                }
                return childAt.getTop() - dividerHeight;
            }
            cancel();
            return -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void s(float f, float f2) {
            int bhM = bhM();
            float paddingLeft = a.this.exA.x - a.this.mListView.getPaddingLeft();
            float f3 = 1.0f - f2;
            if (f3 < Math.abs((a.this.exA.y - bhM) / this.eyS) || f3 < Math.abs(paddingLeft / this.eyT)) {
                a.this.exA.y = bhM + ((int) (this.eyS * f3));
                a.this.exA.x = a.this.mListView.getPaddingLeft() + ((int) (this.eyT * f3));
                a.this.iB(true);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.bhA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class k extends m {
        private int eyR;
        private float eyY;
        private float eyZ;
        private float eza;
        private int ezb;
        private int ezc;
        private int ezd;
        private int eze;

        public k(float f, int i) {
            super(f, i);
            this.ezb = -1;
            this.ezc = -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.ezb = -1;
            this.ezc = -1;
            this.ezd = a.this.exH;
            this.eze = a.this.exI;
            this.eyR = a.this.exK;
            a.this.mDragState = 1;
            this.eyY = a.this.exA.x;
            if (a.this.eyx) {
                float width = a.this.mListView.getWidth() * 2.0f;
                if (a.this.eyy == 0.0f) {
                    a.this.eyy = (this.eyY >= 0.0f ? 1 : -1) * width;
                    return;
                }
                float f = width * 2.0f;
                if (a.this.eyy >= 0.0f || a.this.eyy <= (-f)) {
                    if (a.this.eyy > 0.0f && a.this.eyy < f) {
                        a.this.eyy = f;
                        return;
                    }
                    return;
                }
                a.this.eyy = -f;
                return;
            }
            a.this.bhI();
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void s(float f, float f2) {
            View childAt;
            float f3 = 1.0f - f2;
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            View childAt2 = a.this.mListView.getChildAt(this.ezd - firstVisiblePosition);
            if (a.this.eyx) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / 1000.0f;
                if (uptimeMillis != 0.0f) {
                    float f4 = a.this.eyy * uptimeMillis;
                    int width = a.this.mListView.getWidth();
                    a.this.eyy = ((a.this.eyy > 0.0f ? 1 : -1) * uptimeMillis * width) + a.this.eyy;
                    this.eyY += f4;
                    a.this.exA.x = (int) this.eyY;
                    if (this.eyY < width && this.eyY > (-width)) {
                        this.mStartTime = SystemClock.uptimeMillis();
                        a.this.iB(true);
                        return;
                    }
                } else {
                    return;
                }
            }
            if (childAt2 != null) {
                if (this.ezb == -1) {
                    this.ezb = a.this.f(this.ezd, childAt2, false);
                    this.eyZ = childAt2.getHeight() - this.ezb;
                }
                int max = Math.max((int) (this.eyZ * f3), 1);
                ViewGroup.LayoutParams layoutParams = childAt2.getLayoutParams();
                layoutParams.height = max + this.ezb;
                childAt2.setLayoutParams(layoutParams);
            }
            if (this.eze != this.ezd && (childAt = a.this.mListView.getChildAt(this.eze - firstVisiblePosition)) != null) {
                if (this.ezc == -1) {
                    this.ezc = a.this.f(this.eze, childAt, false);
                    this.eza = childAt.getHeight() - this.ezc;
                }
                int max2 = Math.max((int) (this.eza * f3), 1);
                ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
                layoutParams2.height = max2 + this.ezc;
                childAt.setLayoutParams(layoutParams2);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.bhB();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class j extends m {
        final /* synthetic */ a eyD;
        private float eyW;
        private float eyX;

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.eyW = this.eyD.exM;
            this.eyX = this.eyD.exR;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void s(float f, float f2) {
            if (this.eyD.mDragState != 4) {
                cancel();
                return;
            }
            this.eyD.exM = (int) ((this.eyX * f2) + ((1.0f - f2) * this.eyW));
            this.eyD.exA.y = this.eyD.mY - this.eyD.exM;
            this.eyD.iB(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e {
        StringBuilder mBuilder = new StringBuilder();
        private int eyN = 0;
        private int eyO = 0;
        private boolean eyP = false;
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

        public void bhK() {
            this.mBuilder.append("<DSLVStates>\n");
            this.eyO = 0;
            this.eyP = true;
        }

        public void bhL() {
            if (this.eyP) {
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
                this.mBuilder.append("    <FirstExpPos>").append(a.this.exH).append("</FirstExpPos>\n");
                this.mBuilder.append("    <FirstExpBlankHeight>").append(a.this.nM(a.this.exH) - a.this.nO(a.this.exH)).append("</FirstExpBlankHeight>\n");
                this.mBuilder.append("    <SecondExpPos>").append(a.this.exI).append("</SecondExpPos>\n");
                this.mBuilder.append("    <SecondExpBlankHeight>").append(a.this.nM(a.this.exI) - a.this.nO(a.this.exI)).append("</SecondExpBlankHeight>\n");
                this.mBuilder.append("    <SrcPos>").append(a.this.exK).append("</SrcPos>\n");
                this.mBuilder.append("    <SrcHeight>").append(a.this.cvC + a.this.mListView.getDividerHeight()).append("</SrcHeight>\n");
                this.mBuilder.append("    <ViewHeight>").append(a.this.mListView.getHeight()).append("</ViewHeight>\n");
                this.mBuilder.append("    <LastY>").append(a.this.mLastY).append("</LastY>\n");
                this.mBuilder.append("    <FloatY>").append(a.this.exC).append("</FloatY>\n");
                this.mBuilder.append("    <ShuffleEdges>");
                for (int i4 = 0; i4 < childCount; i4++) {
                    this.mBuilder.append(a.this.aU(firstVisiblePosition + i4, a.this.mListView.getChildAt(i4).getTop())).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                this.mBuilder.append("</ShuffleEdges>\n");
                this.mBuilder.append("</DSLVState>\n");
                this.eyN++;
                if (this.eyN > 1000) {
                    flush();
                    this.eyN = 0;
                }
            }
        }

        public void flush() {
            if (this.eyP) {
                try {
                    FileWriter fileWriter = new FileWriter(this.mFile, this.eyO != 0);
                    fileWriter.write(this.mBuilder.toString());
                    this.mBuilder.delete(0, this.mBuilder.length());
                    fileWriter.flush();
                    fileWriter.close();
                    this.eyO++;
                } catch (IOException e) {
                }
            }
        }

        public void stopTracking() {
            if (this.eyP) {
                this.mBuilder.append("</DSLVStates>\n");
                flush();
                this.eyP = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements Runnable {
        private int dy;
        private boolean eyG;
        private long eyH;
        private long eyI;
        private float eyJ;
        private long eyK;
        private int eyL;
        private float eyM;
        private boolean mScrolling = false;

        public boolean isScrolling() {
            return this.mScrolling;
        }

        public int bhJ() {
            if (this.mScrolling) {
                return this.eyL;
            }
            return -1;
        }

        public d() {
        }

        public void nP(int i) {
            if (!this.mScrolling) {
                this.eyG = false;
                this.mScrolling = true;
                this.eyK = SystemClock.uptimeMillis();
                this.eyH = this.eyK;
                this.eyL = i;
                a.this.mListView.post(this);
            }
        }

        public void iC(boolean z) {
            if (z) {
                a.this.mListView.removeCallbacks(this);
                this.mScrolling = false;
                return;
            }
            this.eyG = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.eyG) {
                int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
                int lastVisiblePosition = a.this.mListView.getLastVisiblePosition();
                int count = a.this.mListView.getCount();
                int paddingTop = a.this.mListView.getPaddingTop();
                int height = (a.this.mListView.getHeight() - paddingTop) - a.this.mListView.getPaddingBottom();
                int min = Math.min(a.this.mY, a.this.exC + a.this.exR);
                int max = Math.max(a.this.mY, a.this.exC - a.this.exR);
                if (this.eyL == 0) {
                    View childAt = a.this.mListView.getChildAt(0);
                    if (childAt == null) {
                        this.mScrolling = false;
                        return;
                    } else if (firstVisiblePosition == 0 && childAt.getTop() == paddingTop) {
                        this.mScrolling = false;
                        return;
                    } else {
                        this.eyM = a.this.eyd.b((a.this.exZ - max) / a.this.eya, this.eyH);
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
                        this.eyM = -a.this.eyd.b((min - a.this.exY) / a.this.eyb, this.eyH);
                    }
                }
                this.eyI = SystemClock.uptimeMillis();
                this.eyJ = (float) (this.eyI - this.eyH);
                this.dy = Math.round(this.eyM * this.eyJ);
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
                this.eyH = this.eyI;
                a.this.mListView.post(this);
                return;
            }
            this.mScrolling = false;
        }
    }
}
