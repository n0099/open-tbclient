package com.baidu.tieba.aiapps.apps.invoice.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUIUtils;
import com.baidu.tieba.e;
/* loaded from: classes4.dex */
public class CommonTagView extends TextView {
    private boolean IW;
    private boolean bDJ;
    private int mBorderColor;
    private int mBorderWidth;
    private Context mContext;
    private int mCornerRadius;
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
        this.IW = true;
        this.bDJ = true;
        b(context, attributeSet, i);
    }

    private void b(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.l.CommonTagView);
        this.mBorderWidth = obtainStyledAttributes.getDimensionPixelOffset(e.l.CommonTagView_borderWidth, 1);
        this.mBorderColor = obtainStyledAttributes.getColor(e.l.CommonTagView_tgViewBorderColor, -16777216);
        this.mCornerRadius = obtainStyledAttributes.getDimensionPixelOffset(e.l.CommonTagView_cornerRadius, 3);
        obtainStyledAttributes.recycle();
        setPadding(getPaddingLeft() == 0 ? AiAppsUIUtils.dip2px(context, 2.0f) : getPaddingLeft(), getPaddingTop() == 0 ? AiAppsUIUtils.dip2px(context, 1.0f) : getPaddingTop(), getPaddingRight() == 0 ? AiAppsUIUtils.dip2px(context, 2.0f) : getPaddingRight(), getPaddingBottom() == 0 ? AiAppsUIUtils.dip2px(context, 1.0f) : getPaddingBottom());
        ch(context);
    }

    private void ch(Context context) {
        this.mContext = context;
        this.mPaint = new Paint();
        this.mRectF = new RectF();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.IW) {
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setAntiAlias(true);
            this.mPaint.setStrokeWidth(this.mBorderWidth);
            if (this.bDJ && this.mBorderColor != getCurrentTextColor()) {
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
