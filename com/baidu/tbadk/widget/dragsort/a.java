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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.d;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a implements com.baidu.tbadk.widget.dragsort.c {
    private int aJY;
    private int amS;
    private int amT;
    private int anA;
    private int anz;
    private View cGB;
    private int cGE;
    private int cGI;
    private int cGJ;
    private int cGK;
    private int cGM;
    private int cGN;
    private int cGO;
    private b cGP;
    private g cGQ;
    private l cGR;
    private int cGU;
    private d cGW;
    private int cGZ;
    private com.baidu.tbadk.widget.dragsort.d cHA;
    private com.baidu.tbadk.widget.dragsort.b cHB;
    private int cHa;
    private float cHb;
    private float cHc;
    private float cHd;
    private float cHe;
    private int cHh;
    private MotionEvent cHm;
    private C0271a cHq;
    private e cHs;
    private k cHv;
    private j cHw;
    private f cHx;
    private boolean cHy;
    private int mLastX;
    private int mLastY;
    private ListView mListView;
    private DataSetObserver mObserver;
    private Point cGC = new Point();
    private Point cGD = new Point();
    private boolean cGF = false;
    private float cGG = 1.0f;
    private float cGH = 1.0f;
    private boolean cGL = false;
    private boolean cGS = true;
    private int mDragState = 0;
    private int cGT = 1;
    private int mWidthMeasureSpec = 0;
    private View[] cGV = new View[1];
    private float cGX = 0.33333334f;
    private float cGY = 0.33333334f;
    private float cHf = 0.5f;
    private c cHg = new c() { // from class: com.baidu.tbadk.widget.dragsort.a.1
        @Override // com.baidu.tbadk.widget.dragsort.a.c
        public float b(float f2, long j2) {
            return a.this.cHf * f2;
        }
    };
    private int cHi = 0;
    private boolean cHj = false;
    private boolean cHk = false;
    private h cHl = null;
    private int cHn = 0;
    private float cHo = 0.25f;
    private float cHp = 0.0f;
    private boolean cHr = false;
    private boolean mBlockLayoutRequests = false;
    private boolean cHt = false;
    private i cHu = new i(3);
    private float cHz = 0.0f;
    private boolean cHC = false;
    private boolean cHD = false;

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

        View lm(int i);
    }

    /* loaded from: classes.dex */
    public interface l {
        void remove(int i);
    }

    public a(ListView listView, com.baidu.tbadk.widget.dragsort.d dVar) {
        this.cHA = dVar;
        this.mListView = listView;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            this.cHq = new C0271a(listAdapter);
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
            this.cHq = null;
        }
        this.cHA.setAdapter(this.cHq);
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
            if (i2 > this.cGM) {
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
    public int li(int i2) {
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        return childAt != null ? childAt.getHeight() : aq(i2, lk(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ao(int i2, int i3) {
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        if (i2 <= headerViewsCount || i2 >= this.mListView.getCount() - footerViewsCount) {
            return i3;
        }
        int dividerHeight = this.mListView.getDividerHeight();
        int i4 = this.aJY - this.cGT;
        int lk = lk(i2);
        int li = li(i2);
        if (this.cGK <= this.cGM) {
            if (i2 == this.cGK && this.cGJ != this.cGK) {
                if (i2 == this.cGM) {
                    i3 = (i3 + li) - this.aJY;
                } else {
                    i3 = ((li - lk) + i3) - i4;
                }
            } else if (i2 > this.cGK && i2 <= this.cGM) {
                i3 -= i4;
            }
        } else if (i2 > this.cGM && i2 <= this.cGJ) {
            i3 += i4;
        } else if (i2 == this.cGK && this.cGJ != this.cGK) {
            i3 += li - lk;
        }
        if (i2 <= this.cGM) {
            return (((this.aJY - dividerHeight) - lk(i2 - 1)) / 2) + i3;
        }
        return (((lk - dividerHeight) - this.aJY) / 2) + i3;
    }

    private boolean axG() {
        int i2;
        int i3;
        int i4;
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int i5 = this.cGJ;
        View childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        if (childAt == null) {
            i5 = firstVisiblePosition + (this.mListView.getChildCount() / 2);
            childAt = this.mListView.getChildAt(i5 - firstVisiblePosition);
        }
        int top = childAt.getTop();
        int height = childAt.getHeight();
        int ao = ao(i5, top);
        int dividerHeight = this.mListView.getDividerHeight();
        if (this.cGE >= ao) {
            int count = this.mListView.getCount();
            int i6 = height;
            int i7 = top;
            i2 = ao;
            i3 = i5;
            i4 = ao;
            while (true) {
                if (i3 < count) {
                    if (i3 == count - 1) {
                        i2 = i7 + dividerHeight + i6;
                        break;
                    }
                    i7 += dividerHeight + i6;
                    i6 = li(i3 + 1);
                    i2 = ao(i3 + 1, i7);
                    if (this.cGE < i2) {
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
            i2 = ao;
            i3 = i5;
            i4 = ao;
            while (true) {
                if (i3 < 0) {
                    break;
                }
                i3--;
                int li = li(i3);
                if (i3 == 0) {
                    i2 = (i8 - dividerHeight) - li;
                    break;
                }
                i8 -= li + dividerHeight;
                i2 = ao(i3, i8);
                if (this.cGE >= i2) {
                    break;
                }
                i4 = i2;
            }
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int i9 = this.cGJ;
        int i10 = this.cGK;
        float f2 = this.cHp;
        if (this.cGL) {
            int abs = Math.abs(i2 - i4);
            if (this.cGE >= i2) {
                int i11 = i4;
                i4 = i2;
                i2 = i11;
            }
            int i12 = (int) (abs * this.cHo * 0.5f);
            float f3 = i12;
            int i13 = i4 + i12;
            int i14 = i2 - i12;
            if (this.cGE < i13) {
                this.cGJ = i3 - 1;
                this.cGK = i3;
                this.cHp = ((i13 - this.cGE) * 0.5f) / f3;
            } else if (this.cGE < i14) {
                this.cGJ = i3;
                this.cGK = i3;
            } else {
                this.cGJ = i3;
                this.cGK = i3 + 1;
                this.cHp = (1.0f + ((i2 - this.cGE) / f3)) * 0.5f;
            }
        } else {
            this.cGJ = i3;
            this.cGK = i3;
        }
        if (this.cGJ < headerViewsCount) {
            this.cGJ = headerViewsCount;
            this.cGK = headerViewsCount;
            i3 = headerViewsCount;
        } else if (this.cGK >= this.mListView.getCount() - footerViewsCount) {
            i3 = (this.mListView.getCount() - footerViewsCount) - 1;
            this.cGJ = i3;
            this.cGK = i3;
        }
        boolean z = (this.cGJ == i9 && this.cGK == i10 && this.cHp == f2) ? false : true;
        if (i3 != this.cGI) {
            if (this.cGP != null) {
                this.cGP.drag(this.cGI - headerViewsCount, i3 - headerViewsCount);
            }
            this.cGI = i3;
            return true;
        }
        return z;
    }

    public void removeItem(int i2) {
        this.cHy = false;
        removeItem(i2, 0.0f);
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void a(ListView listView, Context context, AttributeSet attributeSet) {
        int i2;
        int i3 = BaseActivity.SHOW_SOFT_KEYBOARD_DELAY;
        if (attributeSet == null) {
            i2 = 150;
        } else {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.a.DragSort, 0, 0);
            this.cGT = Math.max(1, obtainStyledAttributes.getDimensionPixelSize(13, 1));
            this.cHr = obtainStyledAttributes.getBoolean(7, false);
            if (this.cHr) {
                this.cHs = new e();
            }
            this.cGG = obtainStyledAttributes.getFloat(11, this.cGG);
            this.cGH = this.cGG;
            this.cGS = obtainStyledAttributes.getBoolean(14, this.cGS);
            this.cHo = Math.max(0.0f, Math.min(1.0f, 1.0f - obtainStyledAttributes.getFloat(1, 0.75f)));
            this.cGL = this.cHo > 0.0f;
            setDragScrollStart(obtainStyledAttributes.getFloat(15, this.cGX));
            this.cHf = obtainStyledAttributes.getFloat(0, this.cHf);
            int i4 = obtainStyledAttributes.getInt(12, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
            int i5 = obtainStyledAttributes.getInt(16, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
            if (obtainStyledAttributes.getBoolean(17, true)) {
                boolean z = obtainStyledAttributes.getBoolean(8, false);
                int i6 = obtainStyledAttributes.getInt(5, 1);
                boolean z2 = obtainStyledAttributes.getBoolean(2, true);
                int resourceId = obtainStyledAttributes.getResourceId(9, 0);
                int resourceId2 = obtainStyledAttributes.getResourceId(10, 0);
                int resourceId3 = obtainStyledAttributes.getResourceId(4, 0);
                int color = obtainStyledAttributes.getColor(6, ViewCompat.MEASURED_STATE_MASK);
                com.baidu.tbadk.widget.dragsort.b bVar = new com.baidu.tbadk.widget.dragsort.b(this, listView, resourceId, 2, i6, resourceId3, resourceId2);
                bVar.fT(z);
                bVar.fS(z2);
                bVar.setBackgroundColor(color);
                this.cHl = bVar;
                a(bVar);
            }
            obtainStyledAttributes.recycle();
            i2 = i5;
            i3 = i4;
        }
        this.cGW = new d();
        if (i3 > 0) {
            this.cHv = new k(0.5f, i3);
        }
        if (i2 > 0) {
            this.cHx = new f(0.5f, i2);
        }
        this.cHm = MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
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
        this.cHB = bVar;
        this.mListView.setOnTouchListener(bVar);
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void dispatchDraw(Canvas canvas) {
        float f2;
        this.cHA.dispatchDraw(canvas);
        if (this.mDragState != 0) {
            if (this.cGJ != this.cGM) {
                b(this.cGJ, canvas);
            }
            if (this.cGK != this.cGJ && this.cGK != this.cGM) {
                b(this.cGK, canvas);
            }
        }
        if (this.cGB != null) {
            int width = this.cGB.getWidth();
            int height = this.cGB.getHeight();
            int i2 = this.cGC.x;
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
            int i3 = (int) (f2 * 255.0f * this.cGH);
            canvas.save();
            canvas.translate(this.cGC.x, this.cGC.y);
            canvas.clipRect(0, 0, width, height);
            canvas.saveLayerAlpha(0.0f, 0.0f, width, height, i3, 31);
            this.cGB.draw(canvas);
            canvas.restore();
            canvas.restore();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onDraw(Canvas canvas) {
        this.cHA.onDraw(canvas);
        if (this.cHr) {
            this.cHs.axU();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.cHt) {
            this.cHt = false;
            return false;
        } else if (!this.cGS) {
            return this.cHA.onTouchEvent(motionEvent);
        } else {
            boolean z2 = this.cHj;
            this.cHj = false;
            if (!z2) {
                y(motionEvent);
            }
            if (this.mDragState == 4) {
                onDragTouchEvent(motionEvent);
                return true;
            }
            if (this.mDragState == 0 && this.cHA.onTouchEvent(motionEvent)) {
                z = true;
            }
            switch (motionEvent.getAction() & 255) {
                case 1:
                case 3:
                    axL();
                    return z;
                case 2:
                default:
                    if (z) {
                        this.cHn = 1;
                        return z;
                    }
                    return z;
            }
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (!this.cGS) {
            return this.cHA.onInterceptTouchEvent(motionEvent);
        }
        if (this.cHB != null) {
            this.cHB.axW().onTouchEvent(motionEvent);
        }
        y(motionEvent);
        this.cHj = true;
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            if (this.mDragState != 0) {
                this.cHt = true;
                return true;
            }
            this.cHk = true;
        }
        if (this.cGB == null) {
            if (this.cHA.onInterceptTouchEvent(motionEvent)) {
                this.cHC = true;
                z = true;
            } else {
                z = false;
            }
            switch (action) {
                case 1:
                case 3:
                    axL();
                    break;
                case 2:
                default:
                    if (z) {
                        this.cHn = 1;
                        break;
                    } else {
                        this.cHn = 2;
                        break;
                    }
            }
        } else {
            z = true;
        }
        if (action == 1 || action == 3) {
            this.cHk = false;
        }
        return z;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        this.cHA.onSizeChanged(i2, i3, i4, i5);
        axM();
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void requestLayout() {
        if (!this.mBlockLayoutRequests) {
            this.cHA.requestLayout();
        }
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void onMeasure(int i2, int i3) {
        this.cHA.onMeasure(i2, i3);
        if (this.cGB != null) {
            if (this.cGB.isLayoutRequested()) {
                axO();
            }
            this.cGF = true;
        }
        this.mWidthMeasureSpec = i2;
    }

    @Override // com.baidu.tbadk.widget.dragsort.c
    public void layoutChildren() {
        this.cHA.layoutChildren();
        if (this.cGB != null) {
            if (this.cGB.isLayoutRequested() && !this.cGF) {
                axO();
            }
            this.cGB.layout(0, 0, this.cGB.getMeasuredWidth(), this.cGB.getMeasuredHeight());
            this.cGF = false;
        }
    }

    public void removeItem(int i2, float f2) {
        if (this.mDragState == 0 || this.mDragState == 4) {
            if (this.mDragState == 0) {
                this.cGM = this.mListView.getHeaderViewsCount() + i2;
                this.cGJ = this.cGM;
                this.cGK = this.cGM;
                this.cGI = this.cGM;
                View childAt = this.mListView.getChildAt(this.cGM - this.mListView.getFirstVisiblePosition());
                if (childAt != null) {
                    childAt.setVisibility(4);
                }
            }
            this.mDragState = 1;
            this.cHz = f2;
            if (this.cHk) {
                switch (this.cHn) {
                    case 1:
                        this.cHA.onTouchEvent(this.cHm);
                        break;
                    case 2:
                        this.cHA.onInterceptTouchEvent(this.cHm);
                        break;
                }
            }
            if (this.cHv != null) {
                this.cHv.start();
            } else {
                lj(i2);
            }
        }
    }

    public void cancelDrag() {
        if (this.mDragState == 4) {
            this.cGW.fR(true);
            axQ();
            axH();
            axN();
            if (this.cHk) {
                this.mDragState = 3;
            } else {
                this.mDragState = 0;
            }
        }
    }

    private void axH() {
        this.cGM = -1;
        this.cGJ = -1;
        this.cGK = -1;
        this.cGI = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axI() {
        this.mDragState = 2;
        if (this.cGQ != null && this.cGI >= 0 && this.cGI < this.mListView.getCount()) {
            int headerViewsCount = this.mListView.getHeaderViewsCount();
            this.cGQ.drop(this.cGM - headerViewsCount, this.cGI - headerViewsCount);
        }
        axQ();
        axK();
        axH();
        axN();
        if (this.cHk) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axJ() {
        lj(this.cGM - this.mListView.getHeaderViewsCount());
    }

    private void lj(int i2) {
        this.mDragState = 1;
        if (this.cGR != null) {
            this.cGR.remove(i2);
        }
        axQ();
        axK();
        axH();
        if (this.cHk) {
            this.mDragState = 3;
        } else {
            this.mDragState = 0;
        }
    }

    private void axK() {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        if (this.cGM < firstVisiblePosition) {
            View childAt = this.mListView.getChildAt(0);
            this.mListView.setSelectionFromTop(firstVisiblePosition - 1, (childAt != null ? childAt.getTop() : 0) - this.mListView.getPaddingTop());
        }
    }

    public boolean stopDrag(boolean z) {
        this.cHy = false;
        return stopDrag(z, 0.0f);
    }

    public boolean stopDragWithVelocity(boolean z, float f2) {
        this.cHy = true;
        return stopDrag(z, f2);
    }

    public boolean stopDrag(boolean z, float f2) {
        if (this.cGB != null) {
            this.cGW.fR(true);
            if (z) {
                removeItem(this.cGM - this.mListView.getHeaderViewsCount(), f2);
            } else if (this.cHx != null) {
                this.cHx.start();
            } else {
                axI();
            }
            if (this.cHr) {
                this.cHs.nF();
                return true;
            }
            return true;
        }
        return false;
    }

    private void axL() {
        this.cHn = 0;
        this.cHk = false;
        if (this.mDragState == 3) {
            this.mDragState = 0;
        }
        this.cGH = this.cGG;
        this.cHC = false;
        this.cHu.clear();
    }

    private void y(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            this.mLastX = this.amS;
            this.mLastY = this.amT;
        }
        this.amS = (int) motionEvent.getX();
        this.amT = (int) motionEvent.getY();
        if (action == 0) {
            this.mLastX = this.amS;
            this.mLastY = this.amT;
        }
        this.anz = ((int) motionEvent.getRawX()) - this.amS;
        this.anA = ((int) motionEvent.getRawY()) - this.amT;
    }

    public boolean listViewIntercepted() {
        return this.cHC;
    }

    public void setDragScrollStart(float f2) {
        setDragScrollStarts(f2, f2);
    }

    public void setDragScrollStarts(float f2, float f3) {
        if (f3 > 0.5f) {
            this.cGY = 0.5f;
        } else {
            this.cGY = f3;
        }
        if (f2 > 0.5f) {
            this.cGX = 0.5f;
        } else {
            this.cGX = f2;
        }
        if (this.mListView.getHeight() != 0) {
            axM();
        }
    }

    private void ap(int i2, int i3) {
        this.cGC.x = i2 - this.cGN;
        this.cGC.y = i3 - this.cGO;
        fQ(true);
        int min = Math.min(i3, this.cGE + this.cGU);
        int max = Math.max(i3, this.cGE - this.cGU);
        int axS = this.cGW.axS();
        if (min > this.mLastY && min > this.cHa && axS != 1) {
            if (axS != -1) {
                this.cGW.fR(true);
            }
            this.cGW.ll(1);
        } else if (max < this.mLastY && max < this.cGZ && axS != 0) {
            if (axS != -1) {
                this.cGW.fR(true);
            }
            this.cGW.ll(0);
        } else if (max >= this.cGZ && min <= this.cHa && this.cGW.axR()) {
            this.cGW.fR(true);
        }
    }

    private void axM() {
        int height;
        int paddingTop = this.mListView.getPaddingTop();
        float height2 = (this.mListView.getHeight() - paddingTop) - this.mListView.getPaddingBottom();
        this.cHc = paddingTop + (this.cGX * height2);
        this.cHb = (height2 * (1.0f - this.cGY)) + paddingTop;
        this.cGZ = (int) this.cHc;
        this.cHa = (int) this.cHb;
        this.cHd = this.cHc - paddingTop;
        this.cHe = (paddingTop + height) - this.cHb;
    }

    private void axN() {
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
        if (i2 != this.cGM && i2 != this.cGJ && i2 != this.cGK) {
            g2 = -2;
        } else {
            g2 = g(i2, view, z);
        }
        if (g2 != layoutParams.height) {
            layoutParams.height = g2;
            view.setLayoutParams(layoutParams);
        }
        if (i2 == this.cGJ || i2 == this.cGK) {
            if (i2 < this.cGM) {
                ((DragSortItemView) view).setGravity(80);
            } else if (i2 > this.cGM) {
                ((DragSortItemView) view).setGravity(48);
            }
        }
        int visibility = view.getVisibility();
        int i3 = 0;
        if (i2 == this.cGM && this.cGB != null) {
            i3 = 4;
        }
        if (i3 != visibility) {
            view.setVisibility(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int lk(int i2) {
        View view;
        if (i2 == this.cGM) {
            return 0;
        }
        View childAt = this.mListView.getChildAt(i2 - this.mListView.getFirstVisiblePosition());
        if (childAt != null) {
            return f(i2, childAt, false);
        }
        int i3 = this.cHu.get(i2);
        if (i3 == -1) {
            ListAdapter adapter = this.mListView.getAdapter();
            int itemViewType = adapter.getItemViewType(i2);
            int viewTypeCount = adapter.getViewTypeCount();
            if (viewTypeCount != this.cGV.length) {
                this.cGV = new View[viewTypeCount];
            }
            if (itemViewType >= 0) {
                if (this.cGV[itemViewType] == null) {
                    view = adapter.getView(i2, null, this.mListView);
                    this.cGV[itemViewType] = view;
                } else {
                    view = adapter.getView(i2, this.cGV[itemViewType], this.mListView);
                }
            } else {
                view = adapter.getView(i2, null, this.mListView);
            }
            int f2 = f(i2, view, true);
            this.cHu.ar(i2, f2);
            return f2;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(int i2, View view, boolean z) {
        if (i2 == this.cGM) {
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
        return aq(i2, f(i2, view, z));
    }

    private int aq(int i2, int i3) {
        this.mListView.getDividerHeight();
        boolean z = this.cGL && this.cGJ != this.cGK;
        int i4 = this.aJY - this.cGT;
        int i5 = (int) (this.cHp * i4);
        if (i2 == this.cGM) {
            if (this.cGM == this.cGJ) {
                if (z) {
                    return i5 + this.cGT;
                }
                return this.aJY;
            } else if (this.cGM == this.cGK) {
                return this.aJY - i5;
            } else {
                return this.cGT;
            }
        } else if (i2 == this.cGJ) {
            if (z) {
                return i3 + i5;
            }
            return i3 + i4;
        } else if (i2 == this.cGK) {
            return (i3 + i4) - i5;
        } else {
            return i3;
        }
    }

    private int b(int i2, View view, int i3, int i4) {
        int i5;
        int i6;
        int lk = lk(i2);
        int height = view.getHeight();
        int aq = aq(i2, lk);
        if (i2 != this.cGM) {
            i6 = height - lk;
            i5 = aq - lk;
        } else {
            i5 = aq;
            i6 = height;
        }
        int i7 = this.aJY;
        if (this.cGM != this.cGJ && this.cGM != this.cGK) {
            i7 -= this.cGT;
        }
        if (i2 <= i3) {
            if (i2 > this.cGJ) {
                return (i7 - i5) + 0;
            }
        } else if (i2 == i4) {
            if (i2 <= this.cGJ) {
                return (i6 - i7) + 0;
            }
            if (i2 == this.cGK) {
                return (height - aq) + 0;
            }
            return 0 + i6;
        } else if (i2 <= this.cGJ) {
            return 0 - i7;
        } else {
            if (i2 == this.cGK) {
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

    private void axO() {
        if (this.cGB != null) {
            measureItem(this.cGB);
            this.aJY = this.cGB.getMeasuredHeight();
            this.cGU = this.aJY / 2;
        }
    }

    protected boolean onDragTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        switch (motionEvent.getAction() & 255) {
            case 1:
                if (this.mDragState == 4) {
                    stopDrag(false);
                }
                axL();
                return true;
            case 2:
                ap((int) motionEvent.getX(), (int) motionEvent.getY());
                return true;
            case 3:
                if (this.mDragState == 4) {
                    cancelDrag();
                }
                axL();
                return true;
            default:
                return true;
        }
    }

    public boolean startDrag(int i2, int i3, int i4, int i5) {
        View lm;
        if (!this.cHk || this.cHl == null || (lm = this.cHl.lm(i2)) == null) {
            return false;
        }
        return startDrag(i2, lm, i3, i4, i5);
    }

    public boolean startDrag(int i2, View view, int i3, int i4, int i5) {
        if (this.mDragState == 0 && this.cHk && this.cGB == null && view != null && this.cGS) {
            if (this.mListView.getParent() != null) {
                this.mListView.getParent().requestDisallowInterceptTouchEvent(true);
            }
            int headerViewsCount = this.mListView.getHeaderViewsCount() + i2;
            this.cGJ = headerViewsCount;
            this.cGK = headerViewsCount;
            this.cGM = headerViewsCount;
            this.cGI = headerViewsCount;
            this.mDragState = 4;
            this.cHi = 0;
            this.cHi |= i3;
            this.cGB = view;
            axO();
            this.cGN = i4;
            this.cGO = i5;
            this.cHh = this.amT;
            this.cGC.x = this.amS - this.cGN;
            this.cGC.y = this.amT - this.cGO;
            View childAt = this.mListView.getChildAt(this.cGM - this.mListView.getFirstVisiblePosition());
            if (childAt != null) {
                childAt.setVisibility(4);
            }
            if (this.cHr) {
                this.cHs.axT();
            }
            switch (this.cHn) {
                case 1:
                    this.cHA.onTouchEvent(this.cHm);
                    break;
                case 2:
                    this.cHA.onInterceptTouchEvent(this.cHm);
                    break;
            }
            this.mListView.requestLayout();
            if (this.cHw != null) {
                this.cHw.start();
                return true;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fQ(boolean z) {
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition() + (this.mListView.getChildCount() / 2);
        View childAt = this.mListView.getChildAt(this.mListView.getChildCount() / 2);
        if (childAt != null) {
            h(firstVisiblePosition, childAt, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i2, View view, boolean z) {
        this.mBlockLayoutRequests = true;
        axP();
        int i3 = this.cGJ;
        int i4 = this.cGK;
        boolean axG = axG();
        if (axG) {
            axN();
            this.mListView.setSelectionFromTop(i2, (b(i2, view, i3, i4) + view.getTop()) - this.mListView.getPaddingTop());
            layoutChildren();
        }
        if (axG || z) {
            this.mListView.invalidate();
        }
        this.mBlockLayoutRequests = false;
    }

    private void axP() {
        if (this.cHl != null) {
            this.cGD.set(this.amS, this.amT);
            this.cHl.b(this.cGB, this.cGC, this.cGD);
        }
        int i2 = this.cGC.x;
        int i3 = this.cGC.y;
        int paddingLeft = this.mListView.getPaddingLeft();
        if ((this.cHi & 1) == 0 && i2 > paddingLeft) {
            this.cGC.x = paddingLeft;
        } else if ((this.cHi & 2) == 0 && i2 < paddingLeft) {
            this.cGC.x = paddingLeft;
        }
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int firstVisiblePosition = this.mListView.getFirstVisiblePosition();
        int lastVisiblePosition = this.mListView.getLastVisiblePosition();
        int paddingTop = this.mListView.getPaddingTop();
        if (firstVisiblePosition < headerViewsCount) {
            paddingTop = this.mListView.getChildAt((headerViewsCount - firstVisiblePosition) - 1).getBottom();
        }
        if ((this.cHi & 8) == 0 && firstVisiblePosition <= this.cGM) {
            paddingTop = Math.max(this.mListView.getChildAt(this.cGM - firstVisiblePosition).getTop(), paddingTop);
        }
        int height = this.mListView.getHeight() - this.mListView.getPaddingBottom();
        if (lastVisiblePosition >= (this.mListView.getCount() - footerViewsCount) - 1) {
            height = this.mListView.getChildAt(((this.mListView.getCount() - footerViewsCount) - 1) - firstVisiblePosition).getBottom();
        }
        if ((this.cHi & 4) == 0 && lastVisiblePosition >= this.cGM) {
            height = Math.min(this.mListView.getChildAt(this.cGM - firstVisiblePosition).getBottom(), height);
        }
        if (i3 < paddingTop) {
            this.cGC.y = paddingTop;
        } else if (this.aJY + i3 > height) {
            this.cGC.y = height - this.aJY;
        }
        this.cGE = this.cGC.y + this.cGU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axQ() {
        if (this.cGB != null) {
            this.cGB.setVisibility(8);
            if (this.cHl != null) {
                this.cHl.bi(this.cGB);
            }
            this.cGB = null;
            this.mListView.invalidate();
        }
    }

    public void a(h hVar) {
        this.cHl = hVar;
    }

    public void a(b bVar) {
        this.cGP = bVar;
    }

    public void setDragEnabled(boolean z) {
        this.cGS = z;
    }

    public boolean isDragEnabled() {
        return this.cGS;
    }

    public void a(g gVar) {
        this.cGQ = gVar;
    }

    public void a(l lVar) {
        this.cGR = lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class i {
        private SparseIntArray cHV;
        private ArrayList<Integer> cHW;
        private int mMaxSize;

        public i(int i) {
            this.cHV = new SparseIntArray(i);
            this.cHW = new ArrayList<>(i);
            this.mMaxSize = i;
        }

        public void ar(int i, int i2) {
            int i3 = this.cHV.get(i, -1);
            if (i3 != i2) {
                if (i3 == -1) {
                    if (this.cHV.size() == this.mMaxSize) {
                        this.cHV.delete(this.cHW.remove(0).intValue());
                    }
                } else {
                    this.cHW.remove(Integer.valueOf(i));
                }
                this.cHV.put(i, i2);
                this.cHW.add(Integer.valueOf(i));
            }
        }

        public int get(int i) {
            return this.cHV.get(i, -1);
        }

        public void clear() {
            this.cHV.clear();
            this.cHW.clear();
        }
    }

    /* renamed from: com.baidu.tbadk.widget.dragsort.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0271a extends BaseAdapter {
        private ListAdapter mAdapter;

        public C0271a(ListAdapter listAdapter) {
            this.mAdapter = listAdapter;
            this.mAdapter.registerDataSetObserver(new DataSetObserver() { // from class: com.baidu.tbadk.widget.dragsort.a.a.1
                @Override // android.database.DataSetObserver
                public void onChanged() {
                    C0271a.this.notifyDataSetChanged();
                }

                @Override // android.database.DataSetObserver
                public void onInvalidated() {
                    C0271a.this.notifyDataSetInvalidated();
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
        private float Ha;
        private float ant;
        private float anu;
        private float anv;
        private float anw;
        private float cIg;
        private boolean mCanceled;
        protected long mStartTime;

        public m(float f, int i) {
            this.Ha = f;
            this.cIg = i;
            float f2 = 1.0f / ((this.Ha * 2.0f) * (1.0f - this.Ha));
            this.anw = f2;
            this.ant = f2;
            this.anu = this.Ha / ((this.Ha - 1.0f) * 2.0f);
            this.anv = 1.0f / (1.0f - this.Ha);
        }

        public float aq(float f) {
            if (f < this.Ha) {
                return this.ant * f * f;
            }
            if (f < 1.0f - this.Ha) {
                return this.anu + (this.anv * f);
            }
            return 1.0f - ((this.anw * (f - 1.0f)) * (f - 1.0f));
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
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / this.cIg;
                if (uptimeMillis >= 1.0f) {
                    t(1.0f, 1.0f);
                    onStop();
                    return;
                }
                t(uptimeMillis, aq(uptimeMillis));
                a.this.mListView.post(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class f extends m {
        private int cHR;
        private int cHS;
        private float cHT;
        private float cHU;

        public f(float f, int i) {
            super(f, i);
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.cHR = a.this.cGI;
            this.cHS = a.this.cGM;
            a.this.mDragState = 2;
            this.cHT = a.this.cGC.y - axV();
            this.cHU = a.this.cGC.x - a.this.mListView.getPaddingLeft();
        }

        private int axV() {
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            int dividerHeight = (a.this.cGT + a.this.mListView.getDividerHeight()) / 2;
            View childAt = a.this.mListView.getChildAt(this.cHR - firstVisiblePosition);
            if (childAt != null) {
                if (this.cHR == this.cHS) {
                    return childAt.getTop();
                }
                if (this.cHR >= this.cHS) {
                    return (childAt.getBottom() + dividerHeight) - a.this.aJY;
                }
                return childAt.getTop() - dividerHeight;
            }
            cancel();
            return -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void t(float f, float f2) {
            int axV = axV();
            float paddingLeft = a.this.cGC.x - a.this.mListView.getPaddingLeft();
            float f3 = 1.0f - f2;
            if (f3 < Math.abs((a.this.cGC.y - axV) / this.cHT) || f3 < Math.abs(paddingLeft / this.cHU)) {
                a.this.cGC.y = axV + ((int) (this.cHT * f3));
                a.this.cGC.x = a.this.mListView.getPaddingLeft() + ((int) (this.cHU * f3));
                a.this.fQ(true);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.axI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class k extends m {
        private int cHS;
        private float cHZ;
        private float cIa;
        private float cIb;
        private int cIc;
        private int cId;
        private int cIe;
        private int cIf;

        public k(float f, int i) {
            super(f, i);
            this.cIc = -1;
            this.cId = -1;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.cIc = -1;
            this.cId = -1;
            this.cIe = a.this.cGJ;
            this.cIf = a.this.cGK;
            this.cHS = a.this.cGM;
            a.this.mDragState = 1;
            this.cHZ = a.this.cGC.x;
            if (a.this.cHy) {
                float width = a.this.mListView.getWidth() * 2.0f;
                if (a.this.cHz == 0.0f) {
                    a.this.cHz = (this.cHZ >= 0.0f ? 1 : -1) * width;
                    return;
                }
                float f = width * 2.0f;
                if (a.this.cHz >= 0.0f || a.this.cHz <= (-f)) {
                    if (a.this.cHz > 0.0f && a.this.cHz < f) {
                        a.this.cHz = f;
                        return;
                    }
                    return;
                }
                a.this.cHz = -f;
                return;
            }
            a.this.axQ();
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void t(float f, float f2) {
            View childAt;
            float f3 = 1.0f - f2;
            int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
            View childAt2 = a.this.mListView.getChildAt(this.cIe - firstVisiblePosition);
            if (a.this.cHy) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / 1000.0f;
                if (uptimeMillis != 0.0f) {
                    float f4 = a.this.cHz * uptimeMillis;
                    int width = a.this.mListView.getWidth();
                    a.this.cHz = ((a.this.cHz > 0.0f ? 1 : -1) * uptimeMillis * width) + a.this.cHz;
                    this.cHZ += f4;
                    a.this.cGC.x = (int) this.cHZ;
                    if (this.cHZ < width && this.cHZ > (-width)) {
                        this.mStartTime = SystemClock.uptimeMillis();
                        a.this.fQ(true);
                        return;
                    }
                } else {
                    return;
                }
            }
            if (childAt2 != null) {
                if (this.cIc == -1) {
                    this.cIc = a.this.f(this.cIe, childAt2, false);
                    this.cIa = childAt2.getHeight() - this.cIc;
                }
                int max = Math.max((int) (this.cIa * f3), 1);
                ViewGroup.LayoutParams layoutParams = childAt2.getLayoutParams();
                layoutParams.height = max + this.cIc;
                childAt2.setLayoutParams(layoutParams);
            }
            if (this.cIf != this.cIe && (childAt = a.this.mListView.getChildAt(this.cIf - firstVisiblePosition)) != null) {
                if (this.cId == -1) {
                    this.cId = a.this.f(this.cIf, childAt, false);
                    this.cIb = childAt.getHeight() - this.cId;
                }
                int max2 = Math.max((int) (this.cIb * f3), 1);
                ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
                layoutParams2.height = max2 + this.cId;
                childAt.setLayoutParams(layoutParams2);
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStop() {
            a.this.axJ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class j extends m {
        final /* synthetic */ a cHE;
        private float cHX;
        private float cHY;

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void onStart() {
            this.cHX = this.cHE.cGO;
            this.cHY = this.cHE.cGU;
        }

        @Override // com.baidu.tbadk.widget.dragsort.a.m
        public void t(float f, float f2) {
            if (this.cHE.mDragState != 4) {
                cancel();
                return;
            }
            this.cHE.cGO = (int) ((this.cHY * f2) + ((1.0f - f2) * this.cHX));
            this.cHE.cGC.y = this.cHE.amT - this.cHE.cGO;
            this.cHE.fQ(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e {
        StringBuilder mBuilder = new StringBuilder();
        private int cHO = 0;
        private int cHP = 0;
        private boolean cHQ = false;
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

        public void axT() {
            this.mBuilder.append("<DSLVStates>\n");
            this.cHP = 0;
            this.cHQ = true;
        }

        public void axU() {
            if (this.cHQ) {
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
                this.mBuilder.append("    <FirstExpPos>").append(a.this.cGJ).append("</FirstExpPos>\n");
                this.mBuilder.append("    <FirstExpBlankHeight>").append(a.this.li(a.this.cGJ) - a.this.lk(a.this.cGJ)).append("</FirstExpBlankHeight>\n");
                this.mBuilder.append("    <SecondExpPos>").append(a.this.cGK).append("</SecondExpPos>\n");
                this.mBuilder.append("    <SecondExpBlankHeight>").append(a.this.li(a.this.cGK) - a.this.lk(a.this.cGK)).append("</SecondExpBlankHeight>\n");
                this.mBuilder.append("    <SrcPos>").append(a.this.cGM).append("</SrcPos>\n");
                this.mBuilder.append("    <SrcHeight>").append(a.this.aJY + a.this.mListView.getDividerHeight()).append("</SrcHeight>\n");
                this.mBuilder.append("    <ViewHeight>").append(a.this.mListView.getHeight()).append("</ViewHeight>\n");
                this.mBuilder.append("    <LastY>").append(a.this.mLastY).append("</LastY>\n");
                this.mBuilder.append("    <FloatY>").append(a.this.cGE).append("</FloatY>\n");
                this.mBuilder.append("    <ShuffleEdges>");
                for (int i4 = 0; i4 < childCount; i4++) {
                    this.mBuilder.append(a.this.ao(firstVisiblePosition + i4, a.this.mListView.getChildAt(i4).getTop())).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                this.mBuilder.append("</ShuffleEdges>\n");
                this.mBuilder.append("</DSLVState>\n");
                this.cHO++;
                if (this.cHO > 1000) {
                    flush();
                    this.cHO = 0;
                }
            }
        }

        public void flush() {
            if (this.cHQ) {
                try {
                    FileWriter fileWriter = new FileWriter(this.mFile, this.cHP != 0);
                    fileWriter.write(this.mBuilder.toString());
                    this.mBuilder.delete(0, this.mBuilder.length());
                    fileWriter.flush();
                    fileWriter.close();
                    this.cHP++;
                } catch (IOException e) {
                }
            }
        }

        public void nF() {
            if (this.cHQ) {
                this.mBuilder.append("</DSLVStates>\n");
                flush();
                this.cHQ = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements Runnable {
        private boolean aNI = false;
        private boolean cHH;
        private long cHI;
        private long cHJ;
        private float cHK;
        private long cHL;
        private int cHM;
        private float cHN;
        private int dy;

        public boolean axR() {
            return this.aNI;
        }

        public int axS() {
            if (this.aNI) {
                return this.cHM;
            }
            return -1;
        }

        public d() {
        }

        public void ll(int i) {
            if (!this.aNI) {
                this.cHH = false;
                this.aNI = true;
                this.cHL = SystemClock.uptimeMillis();
                this.cHI = this.cHL;
                this.cHM = i;
                a.this.mListView.post(this);
            }
        }

        public void fR(boolean z) {
            if (z) {
                a.this.mListView.removeCallbacks(this);
                this.aNI = false;
                return;
            }
            this.cHH = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.cHH) {
                int firstVisiblePosition = a.this.mListView.getFirstVisiblePosition();
                int lastVisiblePosition = a.this.mListView.getLastVisiblePosition();
                int count = a.this.mListView.getCount();
                int paddingTop = a.this.mListView.getPaddingTop();
                int height = (a.this.mListView.getHeight() - paddingTop) - a.this.mListView.getPaddingBottom();
                int min = Math.min(a.this.amT, a.this.cGE + a.this.cGU);
                int max = Math.max(a.this.amT, a.this.cGE - a.this.cGU);
                if (this.cHM == 0) {
                    View childAt = a.this.mListView.getChildAt(0);
                    if (childAt == null) {
                        this.aNI = false;
                        return;
                    } else if (firstVisiblePosition == 0 && childAt.getTop() == paddingTop) {
                        this.aNI = false;
                        return;
                    } else {
                        this.cHN = a.this.cHg.b((a.this.cHc - max) / a.this.cHd, this.cHI);
                    }
                } else {
                    View childAt2 = a.this.mListView.getChildAt(lastVisiblePosition - firstVisiblePosition);
                    if (childAt2 == null) {
                        this.aNI = false;
                        return;
                    } else if (lastVisiblePosition == count - 1 && childAt2.getBottom() <= height + paddingTop) {
                        this.aNI = false;
                        return;
                    } else {
                        this.cHN = -a.this.cHg.b((min - a.this.cHb) / a.this.cHe, this.cHI);
                    }
                }
                this.cHJ = SystemClock.uptimeMillis();
                this.cHK = (float) (this.cHJ - this.cHI);
                this.dy = Math.round(this.cHN * this.cHK);
                if (this.dy >= 0) {
                    this.dy = Math.min(height, this.dy);
                    lastVisiblePosition = firstVisiblePosition;
                } else {
                    this.dy = Math.max(-height, this.dy);
                }
                View childAt3 = a.this.mListView.getChildAt(lastVisiblePosition - firstVisiblePosition);
                int top = childAt3.getTop() + this.dy;
                if (lastVisiblePosition == 0 && top > paddingTop) {
                    top = paddingTop;
                }
                a.this.mBlockLayoutRequests = true;
                a.this.mListView.setSelectionFromTop(lastVisiblePosition, top - paddingTop);
                a.this.layoutChildren();
                a.this.mListView.invalidate();
                a.this.mBlockLayoutRequests = false;
                a.this.h(lastVisiblePosition, childAt3, false);
                this.cHI = this.cHJ;
                a.this.mListView.post(this);
                return;
            }
            this.aNI = false;
        }
    }
}
