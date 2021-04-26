package com.baidu.tbadk.widget.mission;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
/* loaded from: classes3.dex */
public class CircleView extends View {

    /* renamed from: i  reason: collision with root package name */
    public static int f13935i = 20;
    public static int j = 13;
    public static final int k = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds3);

    /* renamed from: e  reason: collision with root package name */
    public float f13936e;

    /* renamed from: f  reason: collision with root package name */
    public float f13937f;

    /* renamed from: g  reason: collision with root package name */
    public float f13938g;

    /* renamed from: h  reason: collision with root package name */
    public Paint f13939h;

    public CircleView(Context context) {
        super(context);
        a(context);
    }

    public final void a(Context context) {
        f13935i = l.g(context, R.dimen.tbds94);
        j = l.g(context, R.dimen.tbds94);
        Paint paint = new Paint();
        this.f13939h = paint;
        paint.setColor(context.getResources().getColor(R.color.CAM_X0314));
        this.f13939h.setAntiAlias(true);
        this.f13939h.setStyle(Paint.Style.STROKE);
        this.f13939h.setStrokeWidth(k);
    }

    public void b() {
        this.f13939h.setColor(getContext().getResources().getColor(R.color.CAM_X0314));
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(this.f13936e, this.f13937f, this.f13938g, this.f13939h);
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        if (mode == Integer.MIN_VALUE && mode2 == Integer.MIN_VALUE) {
            setMeasuredDimension(f13935i, j);
        } else if (mode == Integer.MIN_VALUE) {
            setMeasuredDimension(f13935i, size2);
        } else if (mode2 == Integer.MIN_VALUE) {
            setMeasuredDimension(size, j);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.f13936e = i2 / 2.0f;
        this.f13937f = i3 / 2.0f;
        this.f13938g = (Math.min(i2, i3) / 2.0f) - k;
    }

    public CircleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public CircleView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }
}
