package com.baidu.tieba.frs.vc;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import java.util.Arrays;
/* loaded from: classes4.dex */
public class RoundCornerLinearLayout extends LinearLayout {
    public static final int j = R.color.white_alpha100;

    /* renamed from: e  reason: collision with root package name */
    public float f15915e;

    /* renamed from: f  reason: collision with root package name */
    public Shape f15916f;

    /* renamed from: g  reason: collision with root package name */
    public Paint f15917g;

    /* renamed from: h  reason: collision with root package name */
    public Paint f15918h;

    /* renamed from: i  reason: collision with root package name */
    public RectF f15919i;

    public RoundCornerLinearLayout(Context context) {
        this(context, null);
    }

    public final void a() {
        setLayerType(1, null);
        Paint paint = new Paint();
        this.f15917g = paint;
        paint.setAntiAlias(true);
        this.f15917g.setColor(-7829368);
        this.f15917g.setStyle(Paint.Style.FILL);
        this.f15917g.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        Paint paint2 = new Paint();
        this.f15918h = paint2;
        paint2.setAntiAlias(true);
        this.f15918h.setColor(getResources().getColor(j));
        this.f15918h.setStyle(Paint.Style.FILL);
        this.f15918h.setShadowLayer(getResources().getDimension(R.dimen.tbds5), 0.0f, getResources().getDimension(R.dimen.tbds4), getResources().getColor(j));
        this.f15918h.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        this.f15919i = new RectF();
        this.f15915e = getResources().getDimension(R.dimen.tbds20);
        setPadding(0, 0, 0, getResources().getDimensionPixelSize(R.dimen.tbds1));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        int saveCount = canvas.getSaveCount();
        canvas.save();
        super.dispatchDraw(canvas);
        Shape shape = this.f15916f;
        if (shape != null) {
            shape.draw(canvas, this.f15917g);
        }
        RectF rectF = this.f15919i;
        float f2 = this.f15915e;
        canvas.drawRoundRect(rectF, f2, f2, this.f15918h);
        if (saveCount < 1 || saveCount > canvas.getSaveCount()) {
            return;
        }
        canvas.restoreToCount(saveCount);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (z) {
            if (this.f15916f == null) {
                float[] fArr = new float[8];
                Arrays.fill(fArr, 0.0f);
                float dimension = ((float) getPaddingLeft()) <= getResources().getDimension(R.dimen.tbds5) ? getResources().getDimension(R.dimen.tbds5) : getPaddingLeft();
                float dimension2 = ((float) getPaddingRight()) <= getResources().getDimension(R.dimen.tbds5) ? getResources().getDimension(R.dimen.tbds5) : getPaddingRight();
                float paddingTop = getPaddingTop() <= 0 ? 1.0f : getPaddingTop();
                float paddingBottom = getPaddingBottom() > 0 ? getPaddingBottom() : 1.0f;
                RectF rectF = new RectF(dimension, paddingTop, dimension2, paddingBottom);
                float[] fArr2 = new float[8];
                Arrays.fill(fArr2, this.f15915e);
                this.f15916f = new RoundRectShape(fArr, rectF, fArr2);
                this.f15919i.set(dimension, paddingTop, getWidth() - dimension2, getHeight() - paddingBottom);
            }
            this.f15916f.resize(getWidth(), getHeight());
        }
    }

    public void setRadius(float f2) {
        this.f15915e = f2;
    }

    public RoundCornerLinearLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundCornerLinearLayout(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }
}
