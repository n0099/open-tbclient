package com.baidu.tieba.frs.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;
import com.baidu.tieba.R;
import com.baidu.tieba.view.AdapterLinearLayout;
import java.util.Arrays;
/* loaded from: classes4.dex */
public class RoundAdapterLinearLayout extends AdapterLinearLayout {
    public static final int l = R.color.black_alpha4;

    /* renamed from: g  reason: collision with root package name */
    public float f16453g;

    /* renamed from: h  reason: collision with root package name */
    public Shape f16454h;
    public Paint i;
    public Paint j;
    public RectF k;

    public RoundAdapterLinearLayout(Context context) {
        this(context, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        int saveCount = canvas.getSaveCount();
        canvas.save();
        super.dispatchDraw(canvas);
        Shape shape = this.f16454h;
        if (shape != null) {
            shape.draw(canvas, this.i);
        }
        RectF rectF = this.k;
        float f2 = this.f16453g;
        canvas.drawRoundRect(rectF, f2, f2, this.j);
        if (saveCount < 1 || saveCount > canvas.getSaveCount()) {
            return;
        }
        canvas.restoreToCount(saveCount);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.f16454h == null) {
                float[] fArr = new float[8];
                Arrays.fill(fArr, 0.0f);
                float dimension = ((float) getPaddingLeft()) <= getResources().getDimension(R.dimen.tbds5) ? getResources().getDimension(R.dimen.tbds5) : getPaddingLeft();
                float dimension2 = ((float) getPaddingRight()) <= getResources().getDimension(R.dimen.tbds5) ? getResources().getDimension(R.dimen.tbds5) : getPaddingRight();
                float paddingTop = getPaddingTop() <= 0 ? 1.0f : getPaddingTop();
                float paddingBottom = getPaddingBottom() > 0 ? getPaddingBottom() : 1.0f;
                RectF rectF = new RectF(dimension, paddingTop, dimension2, paddingBottom);
                float[] fArr2 = new float[8];
                Arrays.fill(fArr2, this.f16453g);
                this.f16454h = new RoundRectShape(fArr, rectF, fArr2);
                this.k.set(dimension, paddingTop, getWidth() - dimension2, getHeight() - paddingBottom);
            }
            this.f16454h.resize(getWidth(), getHeight());
        }
    }

    public void setRadius(float f2) {
        this.f16453g = f2;
    }

    public RoundAdapterLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundAdapterLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f16453g = 0.0f;
        setLayerType(1, null);
        Paint paint = new Paint();
        this.i = paint;
        paint.setAntiAlias(true);
        this.i.setColor(-7829368);
        this.i.setStyle(Paint.Style.FILL);
        this.i.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        Paint paint2 = new Paint();
        this.j = paint2;
        paint2.setAntiAlias(true);
        this.j.setColor(getResources().getColor(l));
        this.j.setStyle(Paint.Style.FILL);
        this.j.setShadowLayer(getResources().getDimension(R.dimen.tbds5), 0.0f, getResources().getDimension(R.dimen.tbds4), getResources().getColor(l));
        this.j.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        this.k = new RectF();
    }
}
