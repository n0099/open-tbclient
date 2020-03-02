package com.baidu.tieba.ala.alasquare.widget;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.NestedScrollingChildHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import com.baidu.adp.widget.ListView.BdTypeListView;
/* loaded from: classes3.dex */
public class NestScrollingTypedListView extends BdTypeListView {
    private int euo;
    private boolean isFirst;
    private NestedScrollingChildHelper mChildHelper;
    private int mLastTouchX;
    private int mLastTouchY;
    private int[] mNestedOffsets;
    private int[] mScrollConsumed;
    private int[] mScrollOffset;
    private int mScrollPointerId;

    public NestScrollingTypedListView(Context context) {
        super(context);
        this.mNestedOffsets = new int[2];
        this.mScrollConsumed = new int[2];
        this.mScrollOffset = new int[2];
        this.isFirst = true;
        init();
    }

    public NestScrollingTypedListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mNestedOffsets = new int[2];
        this.mScrollConsumed = new int[2];
        this.mScrollOffset = new int[2];
        this.isFirst = true;
        init();
    }

    public NestScrollingTypedListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mNestedOffsets = new int[2];
        this.mScrollConsumed = new int[2];
        this.mScrollOffset = new int[2];
        this.isFirst = true;
        init();
    }

    private void init() {
        this.mChildHelper = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
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
            int[] iArr = this.mNestedOffsets;
            this.mNestedOffsets[1] = 0;
            iArr[0] = 0;
        }
        obtain.offsetLocation(this.mNestedOffsets[0], this.mNestedOffsets[1]);
        switch (actionMasked) {
            case 0:
                y(motionEvent);
                break;
            case 1:
                stopNestedScroll();
                this.isFirst = true;
                break;
            case 2:
                int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, this.mScrollPointerId);
                if (findPointerIndex < 0) {
                    Log.e("NestedListView", "Error processing scroll; pointer index for id " + this.mScrollPointerId + " not found. Did any MotionEvents get skipped?");
                    return false;
                }
                int x = (int) (MotionEventCompat.getX(motionEvent, findPointerIndex) + 0.5f);
                int y = (int) (MotionEventCompat.getY(motionEvent, findPointerIndex) + 0.5f);
                int i = this.mLastTouchX - x;
                int i2 = this.mLastTouchY - y;
                if (this.isFirst) {
                    Log.i("pyt", "FIRST");
                    this.isFirst = false;
                    y(motionEvent);
                    return true;
                } else if (!be(this.euo, i2)) {
                    this.euo = i2;
                    Log.i("pyt", "move lastY" + this.mLastTouchY + ",y=" + y + ",dy=" + i2);
                    if (dispatchNestedPreScroll(i, i2, this.mScrollConsumed, this.mScrollOffset)) {
                        obtain.offsetLocation(this.mScrollOffset[0], this.mScrollOffset[1]);
                        int[] iArr2 = this.mNestedOffsets;
                        iArr2[0] = iArr2[0] + this.mScrollOffset[0];
                        int[] iArr3 = this.mNestedOffsets;
                        iArr3[1] = iArr3[1] + this.mScrollOffset[1];
                    }
                    this.mLastTouchX = x - this.mScrollOffset[0];
                    this.mLastTouchY = y - this.mScrollOffset[1];
                    break;
                }
                break;
            case 5:
                this.mScrollPointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                this.mLastTouchX = (int) (MotionEventCompat.getX(motionEvent, actionIndex) + 0.5f);
                this.mLastTouchY = (int) (MotionEventCompat.getY(motionEvent, actionIndex) + 0.5f);
                break;
        }
        super.onTouchEvent(motionEvent);
        return true;
    }

    private void y(MotionEvent motionEvent) {
        this.euo = 0;
        int[] iArr = this.mNestedOffsets;
        this.mNestedOffsets[1] = 0;
        iArr[0] = 0;
        this.mScrollPointerId = MotionEventCompat.getPointerId(motionEvent, 0);
        this.mLastTouchX = (int) (motionEvent.getX() + 0.5f);
        this.mLastTouchY = (int) (motionEvent.getY() + 0.5f);
        startNestedScroll(2);
    }

    private boolean be(int i, int i2) {
        return (i > 0 && i2 < 0) || (i < 0 && i2 > 0);
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        this.mChildHelper.setNestedScrollingEnabled(z);
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return this.mChildHelper.isNestedScrollingEnabled();
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i) {
        return this.mChildHelper.startNestedScroll(i);
    }

    @Override // android.view.View
    public void stopNestedScroll() {
        this.mChildHelper.stopNestedScroll();
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return this.mChildHelper.hasNestedScrollingParent();
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.mChildHelper.dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.mChildHelper.dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.mChildHelper.dispatchNestedFling(f, f2, z);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.mChildHelper.dispatchNestedPreFling(f, f2);
    }
}
