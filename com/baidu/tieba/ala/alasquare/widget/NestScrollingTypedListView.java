package com.baidu.tieba.ala.alasquare.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingChildHelper;
import com.baidu.adp.widget.ListView.BdTypeListView;
/* loaded from: classes4.dex */
public class NestScrollingTypedListView extends BdTypeListView {
    public NestedScrollingChildHelper N;
    public int[] O;
    public int[] P;
    public int[] Q;
    public int R;
    public int S;
    public int T;
    public boolean U;
    public int V;

    public NestScrollingTypedListView(Context context) {
        super(context);
        this.O = new int[2];
        this.P = new int[2];
        this.Q = new int[2];
        this.U = true;
        H();
    }

    private void H() {
        this.N = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
    }

    public final boolean I(int i, int i2) {
        if (i <= 0 || i2 >= 0) {
            return i < 0 && i2 > 0;
        }
        return true;
    }

    public final void J(MotionEvent motionEvent) {
        this.V = 0;
        int[] iArr = this.O;
        iArr[1] = 0;
        iArr[0] = 0;
        this.R = MotionEventCompat.getPointerId(motionEvent, 0);
        this.S = (int) (motionEvent.getX() + 0.5f);
        this.T = (int) (motionEvent.getY() + 0.5f);
        startNestedScroll(2);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f2, float f3, boolean z) {
        return this.N.dispatchNestedFling(f2, f3, z);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f2, float f3) {
        return this.N.dispatchNestedPreFling(f2, f3);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.N.dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.N.dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return this.N.hasNestedScrollingParent();
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return this.N.isNestedScrollingEnabled();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.ListView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (actionMasked == 0) {
            int[] iArr = this.O;
            iArr[1] = 0;
            iArr[0] = 0;
        }
        int[] iArr2 = this.O;
        obtain.offsetLocation(iArr2[0], iArr2[1]);
        if (actionMasked == 0) {
            J(motionEvent);
        } else if (actionMasked == 1) {
            stopNestedScroll();
            this.U = true;
        } else if (actionMasked == 2) {
            int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, this.R);
            if (findPointerIndex < 0) {
                Log.e("NestedListView", "Error processing scroll; pointer index for id " + this.R + " not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x = (int) (MotionEventCompat.getX(motionEvent, findPointerIndex) + 0.5f);
            int y = (int) (MotionEventCompat.getY(motionEvent, findPointerIndex) + 0.5f);
            int i = this.S - x;
            int i2 = this.T - y;
            if (this.U) {
                Log.i("pyt", "FIRST");
                this.U = false;
                J(motionEvent);
                return true;
            } else if (!I(this.V, i2)) {
                this.V = i2;
                Log.i("pyt", "move lastY" + this.T + ",y=" + y + ",dy=" + i2);
                if (dispatchNestedPreScroll(i, i2, this.P, this.Q)) {
                    int[] iArr3 = this.Q;
                    obtain.offsetLocation(iArr3[0], iArr3[1]);
                    int[] iArr4 = this.O;
                    int i3 = iArr4[0];
                    int[] iArr5 = this.Q;
                    iArr4[0] = i3 + iArr5[0];
                    iArr4[1] = iArr4[1] + iArr5[1];
                }
                int[] iArr6 = this.Q;
                this.S = x - iArr6[0];
                this.T = y - iArr6[1];
            }
        } else if (actionMasked == 5) {
            this.R = MotionEventCompat.getPointerId(motionEvent, actionIndex);
            this.S = (int) (MotionEventCompat.getX(motionEvent, actionIndex) + 0.5f);
            this.T = (int) (MotionEventCompat.getY(motionEvent, actionIndex) + 0.5f);
        }
        super.onTouchEvent(motionEvent);
        return true;
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        this.N.setNestedScrollingEnabled(z);
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i) {
        return this.N.startNestedScroll(i);
    }

    @Override // android.view.View
    public void stopNestedScroll() {
        this.N.stopNestedScroll();
    }

    public NestScrollingTypedListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.O = new int[2];
        this.P = new int[2];
        this.Q = new int[2];
        this.U = true;
        H();
    }

    public NestScrollingTypedListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.O = new int[2];
        this.P = new int[2];
        this.Q = new int[2];
        this.U = true;
        H();
    }
}
