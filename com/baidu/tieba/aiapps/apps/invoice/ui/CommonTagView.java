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
import com.baidu.swan.apps.an.x;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class CommonTagView extends TextView {
    private boolean Jd;
    private int Oo;
    private boolean cTD;
    private int mBorderColor;
    private int mBorderWidth;
    private Context mContext;
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
        this.Jd = true;
        this.cTD = true;
        b(context, attributeSet, i);
    }

    private void b(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.CommonTagView);
        this.mBorderWidth = obtainStyledAttributes.getDimensionPixelOffset(d.l.CommonTagView_borderWidth, 1);
        this.mBorderColor = obtainStyledAttributes.getColor(d.l.CommonTagView_tgViewBorderColor, ViewCompat.MEASURED_STATE_MASK);
        this.Oo = obtainStyledAttributes.getDimensionPixelOffset(d.l.CommonTagView_cornerRadius, 3);
        obtainStyledAttributes.recycle();
        setPadding(getPaddingLeft() == 0 ? x.dip2px(context, 2.0f) : getPaddingLeft(), getPaddingTop() == 0 ? x.dip2px(context, 1.0f) : getPaddingTop(), getPaddingRight() == 0 ? x.dip2px(context, 2.0f) : getPaddingRight(), getPaddingBottom() == 0 ? x.dip2px(context, 1.0f) : getPaddingBottom());
        dI(context);
    }

    private void dI(Context context) {
        this.mContext = context;
        this.mPaint = new Paint();
        this.mRectF = new RectF();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.Jd) {
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setAntiAlias(true);
            this.mPaint.setStrokeWidth(this.mBorderWidth);
            if (this.cTD && this.mBorderColor != getCurrentTextColor()) {
                this.mBorderColor = getCurrentTextColor();
            }
            this.mPaint.setColor(this.mBorderColor);
            this.mRectF.left = this.mBorderWidth * 0.5f;
            this.mRectF.top = this.mBorderWidth * 0.5f;
            this.mRectF.right = getMeasuredWidth() - (this.mBorderWidth * 0.5f);
            this.mRectF.bottom = getMeasuredHeight() - (this.mBorderWidth * 0.5f);
            canvas.drawRoundRect(this.mRectF, this.Oo, this.Oo, this.mPaint);
        }
    }
}
