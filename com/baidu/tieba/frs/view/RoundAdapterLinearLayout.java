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
/* loaded from: classes9.dex */
public class RoundAdapterLinearLayout extends AdapterLinearLayout {
    private Shape dvy;
    private Paint mPaint;
    private float mRadius;
    private RectF mRectF;
    private Paint mStrokePaint;

    public RoundAdapterLinearLayout(Context context) {
        this(context, null);
    }

    public RoundAdapterLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundAdapterLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRadius = 0.0f;
        setLayerType(1, null);
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(-7829368);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.mStrokePaint = new Paint();
        this.mStrokePaint.setAntiAlias(true);
        this.mStrokePaint.setColor(getResources().getColor(R.color.black_alpha4));
        this.mStrokePaint.setStyle(Paint.Style.FILL);
        this.mStrokePaint.setShadowLayer(getResources().getDimension(R.dimen.tbds5), 0.0f, getResources().getDimension(R.dimen.tbds4), getResources().getColor(R.color.black_alpha4));
        this.mStrokePaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        this.mRectF = new RectF();
    }

    public void setRadius(float f) {
        this.mRadius = f;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.dvy == null) {
                float[] fArr = new float[8];
                Arrays.fill(fArr, 0.0f);
                float dimension = ((float) getPaddingLeft()) <= getResources().getDimension(R.dimen.tbds5) ? getResources().getDimension(R.dimen.tbds5) : getPaddingLeft();
                float dimension2 = ((float) getPaddingRight()) <= getResources().getDimension(R.dimen.tbds5) ? getResources().getDimension(R.dimen.tbds5) : getPaddingRight();
                float paddingTop = getPaddingTop() <= 0 ? 1.0f : getPaddingTop();
                float paddingBottom = getPaddingBottom() > 0 ? getPaddingBottom() : 1.0f;
                RectF rectF = new RectF(dimension, paddingTop, dimension2, paddingBottom);
                float[] fArr2 = new float[8];
                Arrays.fill(fArr2, this.mRadius);
                this.dvy = new RoundRectShape(fArr, rectF, fArr2);
                this.mRectF.set(dimension, paddingTop, getWidth() - dimension2, getHeight() - paddingBottom);
            }
            this.dvy.resize(getWidth(), getHeight());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int saveCount = canvas.getSaveCount();
        canvas.save();
        super.dispatchDraw(canvas);
        if (this.dvy != null) {
            this.dvy.draw(canvas, this.mPaint);
        }
        canvas.drawRoundRect(this.mRectF, this.mRadius, this.mRadius, this.mStrokePaint);
        canvas.restoreToCount(saveCount);
    }
}
