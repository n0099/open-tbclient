package com.baidu.tieba.flist;

import android.content.Context;
import android.graphics.Canvas;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ae;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class CoverFlow extends ViewPager {

    /* renamed from: a  reason: collision with root package name */
    private int f809a;
    private int b;
    private int c;
    private int d;
    private final int[] e;

    public CoverFlow(Context context) {
        this(context, null);
    }

    public CoverFlow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = new int[2];
        setOffscreenPageLimit(12);
        setOnPageChangeListener(new a(this));
    }

    @Override // android.support.v4.view.ViewPager
    public void setAdapter(ae aeVar) {
        super.setAdapter(aeVar);
        setCurrentItem(aeVar.getCount() >> 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.view.ViewPager, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f809a = getMeasuredWidth();
        this.b = getMeasuredHeight();
        this.c = (int) ((this.f809a * 0.5f) + 0.5f);
        this.d = (this.f809a - this.c) >> 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        motionEvent.offsetLocation(-((this.f809a * 0.5f) / 2.0f), 0.0f);
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int i;
        long drawingTime = getDrawingTime();
        int save = canvas.save();
        int width = (int) ((getWidth() * 0.5f) / 2.0f);
        canvas.translate(width, 0.0f);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt != null) {
                childAt.getLocationOnScreen(this.e);
                float d = d(this.e[0] + width);
                int save2 = canvas.save();
                canvas.scale(d, d, i + (this.c >> 1) + getScrollX(), this.b >> 1);
                drawChild(canvas, childAt, drawingTime);
                canvas.restoreToCount(save2);
            }
        }
        canvas.restoreToCount(save);
    }

    private float d(int i) {
        return (float) Math.pow(1.3d, -(Math.abs(i - this.d) / this.c));
    }
}
