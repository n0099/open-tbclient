package com.baidu.tieba.aiapps.apps.invoice.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.swan.apps.an.z;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class CommonTagView extends TextView {
    private boolean dnV;
    private int mBorderColor;
    private int mBorderWidth;
    private Context mContext;
    private int mCornerRadius;
    private boolean mHasBorder;
    private Paint mPaint;
    private RectF mRectF;

    public CommonTagView(Context context) {
        this(context, null);
    }

    public CommonTagView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommonTagView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHasBorder = true;
        this.dnV = true;
        init(context, attributeSet, i);
    }

    private void init(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CommonTagView);
        this.mBorderWidth = obtainStyledAttributes.getDimensionPixelOffset(0, 1);
        this.mBorderColor = obtainStyledAttributes.getColor(1, ViewCompat.MEASURED_STATE_MASK);
        this.mCornerRadius = obtainStyledAttributes.getDimensionPixelOffset(2, 3);
        obtainStyledAttributes.recycle();
        setPadding(getPaddingLeft() == 0 ? z.dip2px(context, 2.0f) : getPaddingLeft(), getPaddingTop() == 0 ? z.dip2px(context, 1.0f) : getPaddingTop(), getPaddingRight() == 0 ? z.dip2px(context, 2.0f) : getPaddingRight(), getPaddingBottom() == 0 ? z.dip2px(context, 1.0f) : getPaddingBottom());
        df(context);
    }

    private void df(Context context) {
        this.mContext = context;
        this.mPaint = new Paint();
        this.mRectF = new RectF();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mHasBorder) {
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setAntiAlias(true);
            this.mPaint.setStrokeWidth(this.mBorderWidth);
            if (this.dnV && this.mBorderColor != getCurrentTextColor()) {
                this.mBorderColor = getCurrentTextColor();
            }
            this.mPaint.setColor(this.mBorderColor);
            this.mRectF.left = this.mBorderWidth * 0.5f;
            this.mRectF.top = this.mBorderWidth * 0.5f;
            this.mRectF.right = getMeasuredWidth() - (this.mBorderWidth * 0.5f);
            this.mRectF.bottom = getMeasuredHeight() - (this.mBorderWidth * 0.5f);
            canvas.drawRoundRect(this.mRectF, this.mCornerRadius, this.mCornerRadius, this.mPaint);
        }
    }
}
