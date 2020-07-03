package com.baidu.tieba.ala.alasquare.widget.banner;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
/* loaded from: classes3.dex */
public class AlaBannerRecyclerView extends RecyclerView {
    private int dos;
    private int dot;

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
                this.dot = y;
                this.dos = x;
                getParent().requestDisallowInterceptTouchEvent(true);
                break;
            case 1:
            case 3:
                getParent().requestDisallowInterceptTouchEvent(false);
                break;
            case 2:
                int i = y - this.dot;
                int i2 = x - this.dos;
                if (Math.abs(i) > ViewConfiguration.getTouchSlop() && Math.abs(i) > Math.abs(i2)) {
                    getParent().requestDisallowInterceptTouchEvent(false);
                    break;
                } else {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    break;
                }
                break;
        }
        this.dot = y;
        this.dos = x;
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.support.v7.widget.RecyclerView
    public boolean fling(int i, int i2) {
        return super.fling(qs(i), qs(i2));
    }

    private int qs(int i) {
        return i > 0 ? Math.min(i, 3000) : Math.max(i, -3000);
    }
}
