package com.baidu.tieba.ala.alasquare.widget.banner;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes4.dex */
public class AlaBannerRecyclerView extends RecyclerView {

    /* renamed from: e  reason: collision with root package name */
    public int f14018e;

    /* renamed from: f  reason: collision with root package name */
    public int f14019f;

    public AlaBannerRecyclerView(Context context) {
        super(context);
    }

    public final int b(int i2) {
        if (i2 > 0) {
            return Math.min(i2, 3000);
        }
        return Math.max(i2, -3000);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0018, code lost:
        if (r2 != 3) goto L9;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    int i2 = y - this.f14018e;
                    int i3 = x - this.f14019f;
                    if (Math.abs(i2) > ViewConfiguration.getTouchSlop() && Math.abs(i2) > Math.abs(i3)) {
                        getParent().requestDisallowInterceptTouchEvent(false);
                    } else {
                        getParent().requestDisallowInterceptTouchEvent(true);
                    }
                }
            }
            getParent().requestDisallowInterceptTouchEvent(false);
        } else {
            this.f14018e = y;
            this.f14019f = x;
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        this.f14018e = y;
        this.f14019f = x;
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public boolean fling(int i2, int i3) {
        return super.fling(b(i2), b(i3));
    }

    public AlaBannerRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AlaBannerRecyclerView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
