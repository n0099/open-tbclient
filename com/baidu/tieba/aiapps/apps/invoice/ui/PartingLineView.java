package com.baidu.tieba.aiapps.apps.invoice.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.support.v4.internal.view.SupportMenu;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tieba.e;
/* loaded from: classes4.dex */
public class PartingLineView extends ViewGroup {
    private Paint aTN;
    private View bDX;
    private int bEc;
    private int bEd;
    private Paint bEe;
    private int bEf;
    private int bEg;
    private Path bEh;
    private Path bEi;
    private int bEj;
    private RectF bEk;
    private RectF bEl;
    private int mBgColor;
    private int mBorderColor;
    private Paint mBorderPaint;
    private int mBorderWidth;
    private Context mContext;
    private Path mRoundPath;
    private View mTopView;

    public PartingLineView(Context context) {
        this(context, null);
    }

    public PartingLineView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PartingLineView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        c(context, attributeSet, i);
    }

    private void c(Context context, AttributeSet attributeSet, int i) {
        this.mContext = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.l.PartingLineView);
        this.bEc = obtainStyledAttributes.getColor(e.l.PartingLineView_bgNormalColor, SupportMenu.CATEGORY_MASK);
        this.bEd = obtainStyledAttributes.getColor(e.l.PartingLineView_bgPressedColor, SupportMenu.CATEGORY_MASK);
        this.mBorderColor = obtainStyledAttributes.getColor(e.l.PartingLineView_bgBorderColor, -16777216);
        this.mBorderWidth = obtainStyledAttributes.getDimensionPixelOffset(e.l.PartingLineView_bgBorderWidth, 1);
        this.bEf = obtainStyledAttributes.getColor(e.l.PartingLineView_dividerLineColor, -16777216);
        this.bEg = obtainStyledAttributes.getDimensionPixelOffset(e.l.PartingLineView_dividerLineHeight, 1);
        this.bEj = obtainStyledAttributes.getDimensionPixelOffset(e.l.PartingLineView_dividerArcRadius, 30);
        obtainStyledAttributes.recycle();
        ck(context);
    }

    private void ck(Context context) {
        setWillNotDraw(false);
        this.mBgColor = this.bEc;
        this.aTN = new Paint();
        this.aTN.setStyle(Paint.Style.FILL);
        this.aTN.setAntiAlias(true);
        this.aTN.setColor(this.mBgColor);
        this.mBorderPaint = new Paint();
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
        this.mBorderPaint.setAntiAlias(true);
        this.mBorderPaint.setColor(this.mBorderColor);
        this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
        this.bEe = new Paint();
        this.bEe.setStyle(Paint.Style.STROKE);
        this.bEe.setAntiAlias(true);
        this.bEe.setColor(this.bEf);
        this.bEe.setPathEffect(new DashPathEffect(new float[]{9.0f, 9.0f}, 0.0f));
        this.bEe.setStrokeWidth(this.bEg);
        this.bEh = new Path();
        this.bEi = new Path();
        this.mRoundPath = new Path();
        this.bEk = new RectF();
        this.bEl = new RectF();
    }

    public void setContentView(View view, View view2) {
        if (view != null && view2 != null) {
            this.mTopView = view;
            this.bDX = view2;
            am(this.mTopView);
            am(this.bDX);
            invalidate();
        }
    }

    public void setBgNormalColor(int i) {
        if (this.mContext != null && this.aTN != null) {
            this.bEc = this.mContext.getResources().getColor(i);
            this.mBgColor = this.bEc;
            this.aTN.setColor(this.mBgColor);
        }
    }

    public void setBgPressedColor(int i) {
        if (this.mContext != null) {
            this.bEd = this.mContext.getResources().getColor(i);
        }
    }

    public void setBorderColor(int i) {
        if (this.mContext != null && this.mBorderPaint != null) {
            this.mBorderColor = this.mContext.getResources().getColor(i);
            this.mBorderPaint.setColor(this.mBorderColor);
        }
    }

    public void setDividerLineColor(int i) {
        if (this.mContext != null && this.bEe != null) {
            this.bEf = this.mContext.getResources().getColor(i);
            this.bEe.setColor(this.bEf);
        }
    }

    private void am(View view) {
        if (view != null) {
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            addView(view);
        }
    }

    public void dk(boolean z) {
        if (this.aTN != null) {
            this.mBgColor = z ? this.bEd : this.bEc;
            this.aTN.setColor(this.mBgColor);
            invalidate();
        }
    }

    @Override // android.view.View
    public void refreshDrawableState() {
        super.refreshDrawableState();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        measureChildren(i, i2);
        if (getChildCount() == 0) {
            setMeasuredDimension(0, 0);
        }
        if (mode != 1073741824) {
            setMeasuredDimension(size, (this.mTopView != null ? this.mTopView.getMeasuredHeight() : 0) + 0 + getPaddingTop() + this.bEg + (this.bDX != null ? this.bDX.getMeasuredHeight() : 0) + getPaddingBottom());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        if (this.mTopView != null) {
            int i6 = paddingTop + 0;
            this.mTopView.layout(0 + paddingLeft, i6, 0 + paddingRight + this.mTopView.getMeasuredWidth(), this.mTopView.getMeasuredHeight() + i6);
            i5 = i6 + this.mTopView.getMeasuredHeight();
        } else {
            i5 = 0;
        }
        if (this.bDX != null) {
            this.bDX.layout(paddingLeft + 0, this.bEg + i5, 0 + paddingRight + this.bDX.getMeasuredWidth(), i5 + this.bDX.getMeasuredHeight());
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mTopView != null && this.bDX != null) {
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int width = (getWidth() - paddingLeft) - paddingRight;
            int height = (getHeight() - paddingTop) - paddingBottom;
            this.bEi.reset();
            this.bEi.moveTo(paddingLeft, paddingTop);
            this.bEi.lineTo(paddingLeft + width, paddingTop);
            this.bEi.lineTo(paddingLeft + width, (this.mTopView.getHeight() + paddingTop) - this.bEj);
            this.bEk.set((paddingLeft + width) - this.bEj, (this.mTopView.getHeight() + paddingTop) - this.bEj, paddingLeft + width + this.bEj, this.mTopView.getHeight() + paddingTop + this.bEj);
            this.bEi.arcTo(this.bEk, 270.0f, -180.0f);
            this.bEi.lineTo(paddingLeft + width, paddingTop + height);
            this.bEi.lineTo(paddingLeft, paddingTop + height);
            this.bEi.lineTo(paddingLeft, this.mTopView.getHeight() + paddingTop + this.bEj);
            this.bEk.set(paddingLeft - this.bEj, (this.mTopView.getHeight() + paddingTop) - this.bEj, this.bEj + paddingLeft, this.mTopView.getHeight() + paddingTop + this.bEj);
            this.bEi.arcTo(this.bEk, 90.0f, -180.0f);
            this.bEi.lineTo(paddingLeft, paddingTop);
            this.bEi.close();
            int i = this.mBorderWidth / 2;
            this.bEl.set(paddingLeft + i, paddingTop + i, (width + paddingLeft) - i, (height + paddingTop) - i);
            this.mRoundPath.reset();
            this.mRoundPath.addRoundRect(this.bEl, 10.0f, 10.0f, Path.Direction.CCW);
            if (this.aTN != null) {
                canvas.drawPath(this.bEi, this.aTN);
            }
            if (this.mBorderPaint != null) {
                canvas.drawPath(this.bEi, this.mBorderPaint);
            }
            if (this.bEe != null && this.mTopView != null && this.bDX != null) {
                float height2 = paddingTop + this.mTopView.getHeight();
                this.bEh.reset();
                this.bEh.moveTo(paddingLeft + this.bEj + 9, height2);
                this.bEh.lineTo(((getWidth() - paddingRight) - this.bEj) - 9, height2);
                canvas.drawPath(this.bEh, this.bEe);
            }
        }
    }
}
