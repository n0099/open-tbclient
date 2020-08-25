package com.baidu.tieba.ala.alasquare.widget.banner;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
/* loaded from: classes4.dex */
public class AlaBannerRecyclerView extends RecyclerView {
    private int deK;
    private int deL;

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
                this.deL = y;
                this.deK = x;
                getParent().requestDisallowInterceptTouchEvent(true);
                break;
            case 1:
            case 3:
                getParent().requestDisallowInterceptTouchEvent(false);
                break;
            case 2:
                int i = y - this.deL;
                int i2 = x - this.deK;
                if (Math.abs(i) > ViewConfiguration.getTouchSlop() && Math.abs(i) > Math.abs(i2)) {
                    getParent().requestDisallowInterceptTouchEvent(false);
                    break;
                } else {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    break;
                }
                break;
        }
        this.deL = y;
        this.deK = x;
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.support.v7.widget.RecyclerView
    public boolean fling(int i, int i2) {
        return super.fling(sT(i), sT(i2));
    }

    private int sT(int i) {
        return i > 0 ? Math.min(i, 3000) : Math.max(i, -3000);
    }
}
