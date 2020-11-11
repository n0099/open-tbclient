package com.baidu.tieba.frs.vc;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.tieba.R;
import java.util.Arrays;
/* loaded from: classes22.dex */
public class RoundCornerLinearLayout extends LinearLayout {
    private static final int fMm = R.color.white_alpha100;
    private Shape eIQ;
    private Paint mPaint;
    private float mRadius;
    private RectF mRectF;
    private Paint mStrokePaint;

    public RoundCornerLinearLayout(Context context) {
        this(context, null);
    }

    public RoundCornerLinearLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundCornerLinearLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        setLayerType(1, null);
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(-7829368);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.mStrokePaint = new Paint();
        this.mStrokePaint.setAntiAlias(true);
        this.mStrokePaint.setColor(getResources().getColor(fMm));
        this.mStrokePaint.setStyle(Paint.Style.FILL);
        this.mStrokePaint.setShadowLayer(getResources().getDimension(R.dimen.tbds5), 0.0f, getResources().getDimension(R.dimen.tbds4), getResources().getColor(fMm));
        this.mStrokePaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        this.mRectF = new RectF();
        this.mRadius = getResources().getDimension(R.dimen.tbds20);
        setPadding(0, 0, 0, getResources().getDimensionPixelSize(R.dimen.tbds1));
    }

    public void setRadius(float f) {
        this.mRadius = f;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (this.eIQ == null) {
                float[] fArr = new float[8];
                Arrays.fill(fArr, 0.0f);
                float dimension = ((float) getPaddingLeft()) <= getResources().getDimension(R.dimen.tbds5) ? getResources().getDimension(R.dimen.tbds5) : getPaddingLeft();
                float dimension2 = ((float) getPaddingRight()) <= getResources().getDimension(R.dimen.tbds5) ? getResources().getDimension(R.dimen.tbds5) : getPaddingRight();
                float paddingTop = getPaddingTop() <= 0 ? 1.0f : getPaddingTop();
                float paddingBottom = getPaddingBottom() > 0 ? getPaddingBottom() : 1.0f;
                RectF rectF = new RectF(dimension, paddingTop, dimension2, paddingBottom);
                float[] fArr2 = new float[8];
                Arrays.fill(fArr2, this.mRadius);
                this.eIQ = new RoundRectShape(fArr, rectF, fArr2);
                this.mRectF.set(dimension, paddingTop, getWidth() - dimension2, getHeight() - paddingBottom);
            }
            this.eIQ.resize(getWidth(), getHeight());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int saveCount = canvas.getSaveCount();
        canvas.save();
        super.dispatchDraw(canvas);
        if (this.eIQ != null) {
            this.eIQ.draw(canvas, this.mPaint);
        }
        canvas.drawRoundRect(this.mRectF, this.mRadius, this.mRadius, this.mStrokePaint);
        if (saveCount >= 1 && saveCount <= canvas.getSaveCount()) {
            canvas.restoreToCount(saveCount);
        }
    }
}
