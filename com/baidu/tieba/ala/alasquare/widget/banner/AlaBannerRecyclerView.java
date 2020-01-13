package com.baidu.tieba.ala.alasquare.widget.banner;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
/* loaded from: classes2.dex */
public class AlaBannerRecyclerView extends RecyclerView {
    private int cvp;
    private int cvq;

    public AlaBannerRecyclerView(Context context) {
        super(context);
    }

    public AlaBannerRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AlaBannerRecyclerView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                this.cvq = y;
                this.cvp = x;
                getParent().requestDisallowInterceptTouchEvent(true);
                break;
            case 1:
            case 3:
                getParent().requestDisallowInterceptTouchEvent(false);
                break;
            case 2:
                int i = y - this.cvq;
                int i2 = x - this.cvp;
                if (Math.abs(i) > ViewConfiguration.getTouchSlop() && Math.abs(i) > Math.abs(i2)) {
                    getParent().requestDisallowInterceptTouchEvent(false);
                    break;
                } else {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    break;
                }
                break;
        }
        this.cvq = y;
        this.cvp = x;
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.support.v7.widget.RecyclerView
    public boolean fling(int i, int i2) {
        return super.fling(oE(i), oE(i2));
    }

    private int oE(int i) {
        return i > 0 ? Math.min(i, 3000) : Math.max(i, -3000);
    }
}
