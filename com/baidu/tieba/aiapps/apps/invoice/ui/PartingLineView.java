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
    private Paint aYO;
    private View bJd;
    private int bJi;
    private int bJj;
    private Paint bJk;
    private int bJl;
    private int bJm;
    private Path bJn;
    private Path bJo;
    private int bJp;
    private RectF bJq;
    private RectF bJr;
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
        this.bJi = obtainStyledAttributes.getColor(e.l.PartingLineView_bgNormalColor, SupportMenu.CATEGORY_MASK);
        this.bJj = obtainStyledAttributes.getColor(e.l.PartingLineView_bgPressedColor, SupportMenu.CATEGORY_MASK);
        this.mBorderColor = obtainStyledAttributes.getColor(e.l.PartingLineView_bgBorderColor, -16777216);
        this.mBorderWidth = obtainStyledAttributes.getDimensionPixelOffset(e.l.PartingLineView_bgBorderWidth, 1);
        this.bJl = obtainStyledAttributes.getColor(e.l.PartingLineView_dividerLineColor, -16777216);
        this.bJm = obtainStyledAttributes.getDimensionPixelOffset(e.l.PartingLineView_dividerLineHeight, 1);
        this.bJp = obtainStyledAttributes.getDimensionPixelOffset(e.l.PartingLineView_dividerArcRadius, 30);
        obtainStyledAttributes.recycle();
        ck(context);
    }

    private void ck(Context context) {
        setWillNotDraw(false);
        this.mBgColor = this.bJi;
        this.aYO = new Paint();
        this.aYO.setStyle(Paint.Style.FILL);
        this.aYO.setAntiAlias(true);
        this.aYO.setColor(this.mBgColor);
        this.mBorderPaint = new Paint();
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
        this.mBorderPaint.setAntiAlias(true);
        this.mBorderPaint.setColor(this.mBorderColor);
        this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
        this.bJk = new Paint();
        this.bJk.setStyle(Paint.Style.STROKE);
        this.bJk.setAntiAlias(true);
        this.bJk.setColor(this.bJl);
        this.bJk.setPathEffect(new DashPathEffect(new float[]{9.0f, 9.0f}, 0.0f));
        this.bJk.setStrokeWidth(this.bJm);
        this.bJn = new Path();
        this.bJo = new Path();
        this.mRoundPath = new Path();
        this.bJq = new RectF();
        this.bJr = new RectF();
    }

    public void setContentView(View view, View view2) {
        if (view != null && view2 != null) {
            this.mTopView = view;
            this.bJd = view2;
            al(this.mTopView);
            al(this.bJd);
            invalidate();
        }
    }

    public void setBgNormalColor(int i) {
        if (this.mContext != null && this.aYO != null) {
            this.bJi = this.mContext.getResources().getColor(i);
            this.mBgColor = this.bJi;
            this.aYO.setColor(this.mBgColor);
        }
    }

    public void setBgPressedColor(int i) {
        if (this.mContext != null) {
            this.bJj = this.mContext.getResources().getColor(i);
        }
    }

    public void setBorderColor(int i) {
        if (this.mContext != null && this.mBorderPaint != null) {
            this.mBorderColor = this.mContext.getResources().getColor(i);
            this.mBorderPaint.setColor(this.mBorderColor);
        }
    }

    public void setDividerLineColor(int i) {
        if (this.mContext != null && this.bJk != null) {
            this.bJl = this.mContext.getResources().getColor(i);
            this.bJk.setColor(this.bJl);
        }
    }

    private void al(View view) {
        if (view != null) {
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            addView(view);
        }
    }

    public void dF(boolean z) {
        if (this.aYO != null) {
            this.mBgColor = z ? this.bJj : this.bJi;
            this.aYO.setColor(this.mBgColor);
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
            setMeasuredDimension(size, (this.mTopView != null ? this.mTopView.getMeasuredHeight() : 0) + 0 + getPaddingTop() + this.bJm + (this.bJd != null ? this.bJd.getMeasuredHeight() : 0) + getPaddingBottom());
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
        if (this.bJd != null) {
            this.bJd.layout(paddingLeft + 0, this.bJm + i5, 0 + paddingRight + this.bJd.getMeasuredWidth(), i5 + this.bJd.getMeasuredHeight());
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mTopView != null && this.bJd != null) {
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int width = (getWidth() - paddingLeft) - paddingRight;
            int height = (getHeight() - paddingTop) - paddingBottom;
            this.bJo.reset();
            this.bJo.moveTo(paddingLeft, paddingTop);
            this.bJo.lineTo(paddingLeft + width, paddingTop);
            this.bJo.lineTo(paddingLeft + width, (this.mTopView.getHeight() + paddingTop) - this.bJp);
            this.bJq.set((paddingLeft + width) - this.bJp, (this.mTopView.getHeight() + paddingTop) - this.bJp, paddingLeft + width + this.bJp, this.mTopView.getHeight() + paddingTop + this.bJp);
            this.bJo.arcTo(this.bJq, 270.0f, -180.0f);
            this.bJo.lineTo(paddingLeft + width, paddingTop + height);
            this.bJo.lineTo(paddingLeft, paddingTop + height);
            this.bJo.lineTo(paddingLeft, this.mTopView.getHeight() + paddingTop + this.bJp);
            this.bJq.set(paddingLeft - this.bJp, (this.mTopView.getHeight() + paddingTop) - this.bJp, this.bJp + paddingLeft, this.mTopView.getHeight() + paddingTop + this.bJp);
            this.bJo.arcTo(this.bJq, 90.0f, -180.0f);
            this.bJo.lineTo(paddingLeft, paddingTop);
            this.bJo.close();
            int i = this.mBorderWidth / 2;
            this.bJr.set(paddingLeft + i, paddingTop + i, (width + paddingLeft) - i, (height + paddingTop) - i);
            this.mRoundPath.reset();
            this.mRoundPath.addRoundRect(this.bJr, 10.0f, 10.0f, Path.Direction.CCW);
            if (this.aYO != null) {
                canvas.drawPath(this.bJo, this.aYO);
            }
            if (this.mBorderPaint != null) {
                canvas.drawPath(this.bJo, this.mBorderPaint);
            }
            if (this.bJk != null && this.mTopView != null && this.bJd != null) {
                float height2 = paddingTop + this.mTopView.getHeight();
                this.bJn.reset();
                this.bJn.moveTo(paddingLeft + this.bJp + 9, height2);
                this.bJn.lineTo(((getWidth() - paddingRight) - this.bJp) - 9, height2);
                canvas.drawPath(this.bJn, this.bJk);
            }
        }
    }
}
